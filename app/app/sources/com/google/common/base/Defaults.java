package com.google.common.base;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class Defaults {
    private static final Double DOUBLE_DEFAULT = Double.valueOf(0.0d);
    private static final Float FLOAT_DEFAULT = Float.valueOf(0.0f);

    private Defaults() {
    }

    @CheckForNull
    public static <T> T defaultValue(Class<T> type) {
        Preconditions.checkNotNull(type);
        if (!type.isPrimitive()) {
            return null;
        }
        if (type == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (type == Character.TYPE) {
            return 0;
        }
        if (type == Byte.TYPE) {
            return (byte) 0;
        }
        if (type == Short.TYPE) {
            return (short) 0;
        }
        if (type == Integer.TYPE) {
            return 0;
        }
        if (type == Long.TYPE) {
            return 0L;
        }
        if (type == Float.TYPE) {
            return FLOAT_DEFAULT;
        }
        if (type == Double.TYPE) {
            return DOUBLE_DEFAULT;
        }
        return null;
    }
}
