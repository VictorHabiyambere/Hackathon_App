package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public final class JsonPrimitive extends JsonElement {
    private final Object value;

    public JsonPrimitive(Boolean bool) {
        this.value = Objects.requireNonNull(bool);
    }

    public JsonPrimitive(Number number) {
        this.value = Objects.requireNonNull(number);
    }

    public JsonPrimitive(String string) {
        this.value = Objects.requireNonNull(string);
    }

    public JsonPrimitive(Character c) {
        this.value = ((Character) Objects.requireNonNull(c)).toString();
    }

    public JsonPrimitive deepCopy() {
        return this;
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    public boolean getAsBoolean() {
        if (isBoolean()) {
            return ((Boolean) this.value).booleanValue();
        }
        return Boolean.parseBoolean(getAsString());
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public Number getAsNumber() {
        if (this.value instanceof Number) {
            return (Number) this.value;
        }
        if (this.value instanceof String) {
            return new LazilyParsedNumber((String) this.value);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    public String getAsString() {
        if (this.value instanceof String) {
            return (String) this.value;
        }
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return ((Boolean) this.value).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.value.getClass());
    }

    public double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    public BigDecimal getAsBigDecimal() {
        return this.value instanceof BigDecimal ? (BigDecimal) this.value : new BigDecimal(getAsString());
    }

    public BigInteger getAsBigInteger() {
        return this.value instanceof BigInteger ? (BigInteger) this.value : new BigInteger(getAsString());
    }

    public float getAsFloat() {
        return isNumber() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
    }

    public long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    public short getAsShort() {
        return isNumber() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
    }

    public int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    public byte getAsByte() {
        return isNumber() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
    }

    @Deprecated
    public char getAsCharacter() {
        String s = getAsString();
        if (!s.isEmpty()) {
            return s.charAt(0);
        }
        throw new UnsupportedOperationException("String value is empty");
    }

    public int hashCode() {
        if (this.value == null) {
            return 31;
        }
        if (isIntegral(this)) {
            long value2 = getAsNumber().longValue();
            return (int) ((value2 >>> 32) ^ value2);
        } else if (!(this.value instanceof Number)) {
            return this.value.hashCode();
        } else {
            long value3 = Double.doubleToLongBits(getAsNumber().doubleValue());
            return (int) ((value3 >>> 32) ^ value3);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JsonPrimitive other = (JsonPrimitive) obj;
        if (this.value == null) {
            if (other.value == null) {
                return true;
            }
            return false;
        } else if (!isIntegral(this) || !isIntegral(other)) {
            if (!(this.value instanceof Number) || !(other.value instanceof Number)) {
                return this.value.equals(other.value);
            }
            double a = getAsNumber().doubleValue();
            double b = other.getAsNumber().doubleValue();
            if (a == b) {
                return true;
            }
            if (!Double.isNaN(a) || !Double.isNaN(b)) {
                return false;
            }
            return true;
        } else if (getAsNumber().longValue() == other.getAsNumber().longValue()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isIntegral(JsonPrimitive primitive) {
        if (!(primitive.value instanceof Number)) {
            return false;
        }
        Number number = (Number) primitive.value;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }
}
