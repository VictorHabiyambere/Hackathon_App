package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class LocalizedMessage extends GeneratedMessageLite<LocalizedMessage, Builder> implements LocalizedMessageOrBuilder {
    /* access modifiers changed from: private */
    public static final LocalizedMessage DEFAULT_INSTANCE;
    public static final int LOCALE_FIELD_NUMBER = 1;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile Parser<LocalizedMessage> PARSER;
    private String locale_ = "";
    private String message_ = "";

    private LocalizedMessage() {
    }

    public String getLocale() {
        return this.locale_;
    }

    public ByteString getLocaleBytes() {
        return ByteString.copyFromUtf8(this.locale_);
    }

    /* access modifiers changed from: private */
    public void setLocale(String value) {
        value.getClass();
        this.locale_ = value;
    }

    /* access modifiers changed from: private */
    public void clearLocale() {
        this.locale_ = getDefaultInstance().getLocale();
    }

    /* access modifiers changed from: private */
    public void setLocaleBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.locale_ = value.toStringUtf8();
    }

    public String getMessage() {
        return this.message_;
    }

    public ByteString getMessageBytes() {
        return ByteString.copyFromUtf8(this.message_);
    }

    /* access modifiers changed from: private */
    public void setMessage(String value) {
        value.getClass();
        this.message_ = value;
    }

    /* access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    /* access modifiers changed from: private */
    public void setMessageBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.message_ = value.toStringUtf8();
    }

    public static LocalizedMessage parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LocalizedMessage parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LocalizedMessage parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LocalizedMessage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LocalizedMessage parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LocalizedMessage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LocalizedMessage parseFrom(InputStream input) throws IOException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LocalizedMessage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LocalizedMessage parseDelimitedFrom(InputStream input) throws IOException {
        return (LocalizedMessage) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static LocalizedMessage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LocalizedMessage) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LocalizedMessage parseFrom(CodedInputStream input) throws IOException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LocalizedMessage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(LocalizedMessage prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<LocalizedMessage, Builder> implements LocalizedMessageOrBuilder {
        private Builder() {
            super(LocalizedMessage.DEFAULT_INSTANCE);
        }

        public String getLocale() {
            return ((LocalizedMessage) this.instance).getLocale();
        }

        public ByteString getLocaleBytes() {
            return ((LocalizedMessage) this.instance).getLocaleBytes();
        }

        public Builder setLocale(String value) {
            copyOnWrite();
            ((LocalizedMessage) this.instance).setLocale(value);
            return this;
        }

        public Builder clearLocale() {
            copyOnWrite();
            ((LocalizedMessage) this.instance).clearLocale();
            return this;
        }

        public Builder setLocaleBytes(ByteString value) {
            copyOnWrite();
            ((LocalizedMessage) this.instance).setLocaleBytes(value);
            return this;
        }

        public String getMessage() {
            return ((LocalizedMessage) this.instance).getMessage();
        }

        public ByteString getMessageBytes() {
            return ((LocalizedMessage) this.instance).getMessageBytes();
        }

        public Builder setMessage(String value) {
            copyOnWrite();
            ((LocalizedMessage) this.instance).setMessage(value);
            return this;
        }

        public Builder clearMessage() {
            copyOnWrite();
            ((LocalizedMessage) this.instance).clearMessage();
            return this;
        }

        public Builder setMessageBytes(ByteString value) {
            copyOnWrite();
            ((LocalizedMessage) this.instance).setMessageBytes(value);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new LocalizedMessage();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"locale_", "message_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<LocalizedMessage> parser = PARSER;
                if (parser == null) {
                    synchronized (LocalizedMessage.class) {
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
        LocalizedMessage defaultInstance = new LocalizedMessage();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(LocalizedMessage.class, defaultInstance);
    }

    public static LocalizedMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<LocalizedMessage> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
