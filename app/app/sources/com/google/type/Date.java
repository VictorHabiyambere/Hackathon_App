package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Date extends GeneratedMessageLite<Date, Builder> implements DateOrBuilder {
    public static final int DAY_FIELD_NUMBER = 3;
    /* access modifiers changed from: private */
    public static final Date DEFAULT_INSTANCE;
    public static final int MONTH_FIELD_NUMBER = 2;
    private static volatile Parser<Date> PARSER = null;
    public static final int YEAR_FIELD_NUMBER = 1;
    private int day_;
    private int month_;
    private int year_;

    private Date() {
    }

    public int getYear() {
        return this.year_;
    }

    /* access modifiers changed from: private */
    public void setYear(int value) {
        this.year_ = value;
    }

    /* access modifiers changed from: private */
    public void clearYear() {
        this.year_ = 0;
    }

    public int getMonth() {
        return this.month_;
    }

    /* access modifiers changed from: private */
    public void setMonth(int value) {
        this.month_ = value;
    }

    /* access modifiers changed from: private */
    public void clearMonth() {
        this.month_ = 0;
    }

    public int getDay() {
        return this.day_;
    }

    /* access modifiers changed from: private */
    public void setDay(int value) {
        this.day_ = value;
    }

    /* access modifiers changed from: private */
    public void clearDay() {
        this.day_ = 0;
    }

    public static Date parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Date parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Date parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Date parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Date parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Date parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Date parseFrom(InputStream input) throws IOException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Date parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Date parseDelimitedFrom(InputStream input) throws IOException {
        return (Date) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Date parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Date) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Date parseFrom(CodedInputStream input) throws IOException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Date parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Date prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Date, Builder> implements DateOrBuilder {
        private Builder() {
            super(Date.DEFAULT_INSTANCE);
        }

        public int getYear() {
            return ((Date) this.instance).getYear();
        }

        public Builder setYear(int value) {
            copyOnWrite();
            ((Date) this.instance).setYear(value);
            return this;
        }

        public Builder clearYear() {
            copyOnWrite();
            ((Date) this.instance).clearYear();
            return this;
        }

        public int getMonth() {
            return ((Date) this.instance).getMonth();
        }

        public Builder setMonth(int value) {
            copyOnWrite();
            ((Date) this.instance).setMonth(value);
            return this;
        }

        public Builder clearMonth() {
            copyOnWrite();
            ((Date) this.instance).clearMonth();
            return this;
        }

        public int getDay() {
            return ((Date) this.instance).getDay();
        }

        public Builder setDay(int value) {
            copyOnWrite();
            ((Date) this.instance).setDay(value);
            return this;
        }

        public Builder clearDay() {
            copyOnWrite();
            ((Date) this.instance).clearDay();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new Date();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004", new Object[]{"year_", "month_", "day_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<Date> parser = PARSER;
                if (parser == null) {
                    synchronized (Date.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        Date defaultInstance = new Date();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(Date.class, defaultInstance);
    }

    public static Date getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Date> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
