package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Advice extends GeneratedMessageLite<Advice, Builder> implements AdviceOrBuilder {
    /* access modifiers changed from: private */
    public static final Advice DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    private static volatile Parser<Advice> PARSER;
    private String description_ = "";

    private Advice() {
    }

    public String getDescription() {
        return this.description_;
    }

    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    /* access modifiers changed from: private */
    public void setDescription(String value) {
        value.getClass();
        this.description_ = value;
    }

    /* access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* access modifiers changed from: private */
    public void setDescriptionBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.description_ = value.toStringUtf8();
    }

    public static Advice parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (Advice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Advice parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Advice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Advice parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Advice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Advice parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Advice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Advice parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Advice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Advice parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Advice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Advice parseFrom(InputStream input) throws IOException {
        return (Advice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Advice parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Advice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Advice parseDelimitedFrom(InputStream input) throws IOException {
        return (Advice) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Advice parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Advice) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Advice parseFrom(CodedInputStream input) throws IOException {
        return (Advice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Advice parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Advice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Advice prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Advice, Builder> implements AdviceOrBuilder {
        private Builder() {
            super(Advice.DEFAULT_INSTANCE);
        }

        public String getDescription() {
            return ((Advice) this.instance).getDescription();
        }

        public ByteString getDescriptionBytes() {
            return ((Advice) this.instance).getDescriptionBytes();
        }

        public Builder setDescription(String value) {
            copyOnWrite();
            ((Advice) this.instance).setDescription(value);
            return this;
        }

        public Builder clearDescription() {
            copyOnWrite();
            ((Advice) this.instance).clearDescription();
            return this;
        }

        public Builder setDescriptionBytes(ByteString value) {
            copyOnWrite();
            ((Advice) this.instance).setDescriptionBytes(value);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new Advice();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002Ȉ", new Object[]{"description_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<Advice> parser = PARSER;
                if (parser == null) {
                    synchronized (Advice.class) {
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
        Advice defaultInstance = new Advice();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(Advice.class, defaultInstance);
    }

    public static Advice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Advice> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
