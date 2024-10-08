package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 {
        public <T> boolean put(@ParametricNullness T object, Funnel<? super T> funnel, int numHashFunctions, LockFreeBitArray bits) {
            long bitSize = bits.bitSize();
            long hash64 = Hashing.murmur3_128().hashObject(object, funnel).asLong();
            int hash1 = (int) hash64;
            int hash2 = (int) (hash64 >>> 32);
            boolean bitsChanged = false;
            for (int i = 1; i <= numHashFunctions; i++) {
                int combinedHash = (i * hash2) + hash1;
                if (combinedHash < 0) {
                    combinedHash = ~combinedHash;
                }
                bitsChanged |= bits.set(((long) combinedHash) % bitSize);
            }
            return bitsChanged;
        }

        public <T> boolean mightContain(@ParametricNullness T object, Funnel<? super T> funnel, int numHashFunctions, LockFreeBitArray bits) {
            long bitSize = bits.bitSize();
            long hash64 = Hashing.murmur3_128().hashObject(object, funnel).asLong();
            int hash1 = (int) hash64;
            int hash2 = (int) (hash64 >>> 32);
            for (int i = 1; i <= numHashFunctions; i++) {
                int combinedHash = (i * hash2) + hash1;
                if (combinedHash < 0) {
                    combinedHash = ~combinedHash;
                }
                if (!bits.get(((long) combinedHash) % bitSize)) {
                    return false;
                }
            }
            return true;
        }
    },
    MURMUR128_MITZ_64 {
        public <T> boolean put(@ParametricNullness T object, Funnel<? super T> funnel, int numHashFunctions, LockFreeBitArray bits) {
            long bitSize = bits.bitSize();
            byte[] bytes = Hashing.murmur3_128().hashObject(object, funnel).getBytesInternal();
            long hash1 = lowerEight(bytes);
            long hash2 = upperEight(bytes);
            boolean bitsChanged = false;
            long combinedHash = hash1;
            int i = 0;
            while (i < numHashFunctions) {
                byte[] bytes2 = bytes;
                bitsChanged |= bits.set((Long.MAX_VALUE & combinedHash) % bitSize);
                combinedHash += hash2;
                i++;
                T t = object;
                bytes = bytes2;
            }
            return bitsChanged;
        }

        public <T> boolean mightContain(@ParametricNullness T object, Funnel<? super T> funnel, int numHashFunctions, LockFreeBitArray bits) {
            long bitSize = bits.bitSize();
            byte[] bytes = Hashing.murmur3_128().hashObject(object, funnel).getBytesInternal();
            long hash1 = lowerEight(bytes);
            long hash2 = upperEight(bytes);
            long combinedHash = hash1;
            int i = 0;
            while (i < numHashFunctions) {
                if (!bits.get((Long.MAX_VALUE & combinedHash) % bitSize)) {
                    return false;
                }
                combinedHash += hash2;
                i++;
            }
            LockFreeBitArray lockFreeBitArray = bits;
            return true;
        }

        private long lowerEight(byte[] bytes) {
            return Longs.fromBytes(bytes[7], bytes[6], bytes[5], bytes[4], bytes[3], bytes[2], bytes[1], bytes[0]);
        }

        private long upperEight(byte[] bytes) {
            return Longs.fromBytes(bytes[15], bytes[14], bytes[13], bytes[12], bytes[11], bytes[10], bytes[9], bytes[8]);
        }
    };

    static final class LockFreeBitArray {
        private static final int LONG_ADDRESSABLE_BITS = 6;
        private final LongAddable bitCount;
        final AtomicLongArray data;

        LockFreeBitArray(long bits) {
            Preconditions.checkArgument(bits > 0, "data length is zero!");
            this.data = new AtomicLongArray(Ints.checkedCast(LongMath.divide(bits, 64, RoundingMode.CEILING)));
            this.bitCount = LongAddables.create();
        }

        LockFreeBitArray(long[] data2) {
            Preconditions.checkArgument(data2.length > 0, "data length is zero!");
            this.data = new AtomicLongArray(data2);
            this.bitCount = LongAddables.create();
            long bitCount2 = 0;
            for (long value : data2) {
                bitCount2 += (long) Long.bitCount(value);
            }
            this.bitCount.add(bitCount2);
        }

        /* access modifiers changed from: package-private */
        public boolean set(long bitIndex) {
            long oldValue;
            long newValue;
            long j = bitIndex;
            if (get(bitIndex)) {
                return false;
            }
            int longIndex = (int) (j >>> 6);
            long mask = 1 << ((int) j);
            do {
                oldValue = this.data.get(longIndex);
                newValue = oldValue | mask;
                if (oldValue == newValue) {
                    return false;
                }
            } while (!this.data.compareAndSet(longIndex, oldValue, newValue));
            this.bitCount.increment();
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean get(long bitIndex) {
            return (this.data.get((int) (bitIndex >>> 6)) & (1 << ((int) bitIndex))) != 0;
        }

        public static long[] toPlainArray(AtomicLongArray atomicLongArray) {
            long[] array = new long[atomicLongArray.length()];
            for (int i = 0; i < array.length; i++) {
                array[i] = atomicLongArray.get(i);
            }
            return array;
        }

        /* access modifiers changed from: package-private */
        public long bitSize() {
            return ((long) this.data.length()) * 64;
        }

        /* access modifiers changed from: package-private */
        public long bitCount() {
            return this.bitCount.sum();
        }

        /* access modifiers changed from: package-private */
        public LockFreeBitArray copy() {
            return new LockFreeBitArray(toPlainArray(this.data));
        }

        /* access modifiers changed from: package-private */
        public void putAll(LockFreeBitArray other) {
            Preconditions.checkArgument(this.data.length() == other.data.length(), "BitArrays must be of equal length (%s != %s)", this.data.length(), other.data.length());
            for (int i = 0; i < this.data.length(); i++) {
                putData(i, other.data.get(i));
            }
        }

        /* access modifiers changed from: package-private */
        public void putData(int i, long longValue) {
            long ourLongOld;
            long ourLongNew;
            boolean changedAnyBits = true;
            while (true) {
                ourLongOld = this.data.get(i);
                ourLongNew = ourLongOld | longValue;
                if (ourLongOld != ourLongNew) {
                    if (this.data.compareAndSet(i, ourLongOld, ourLongNew)) {
                        break;
                    }
                } else {
                    changedAnyBits = false;
                    break;
                }
            }
            if (changedAnyBits) {
                this.bitCount.add((long) (Long.bitCount(ourLongNew) - Long.bitCount(ourLongOld)));
            }
        }

        /* access modifiers changed from: package-private */
        public int dataLength() {
            return this.data.length();
        }

        public boolean equals(@CheckForNull Object o) {
            if (o instanceof LockFreeBitArray) {
                return Arrays.equals(toPlainArray(this.data), toPlainArray(((LockFreeBitArray) o).data));
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(toPlainArray(this.data));
        }
    }
}
