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

public final class RequestInfo extends GeneratedMessageLite<RequestInfo, Builder> implements RequestInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final RequestInfo DEFAULT_INSTANCE;
    private static volatile Parser<RequestInfo> PARSER = null;
    public static final int REQUEST_ID_FIELD_NUMBER = 1;
    public static final int SERVING_DATA_FIELD_NUMBER = 2;
    private String requestId_ = "";
    private String servingData_ = "";

    private RequestInfo() {
    }

    public String getRequestId() {
        return this.requestId_;
    }

    public ByteString getRequestIdBytes() {
        return ByteString.copyFromUtf8(this.requestId_);
    }

    /* access modifiers changed from: private */
    public void setRequestId(String value) {
        value.getClass();
        this.requestId_ = value;
    }

    /* access modifiers changed from: private */
    public void clearRequestId() {
        this.requestId_ = getDefaultInstance().getRequestId();
    }

    /* access modifiers changed from: private */
    public void setRequestIdBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.requestId_ = value.toStringUtf8();
    }

    public String getServingData() {
        return this.servingData_;
    }

    public ByteString getServingDataBytes() {
        return ByteString.copyFromUtf8(this.servingData_);
    }

    /* access modifiers changed from: private */
    public void setServingData(String value) {
        value.getClass();
        this.servingData_ = value;
    }

    /* access modifiers changed from: private */
    public void clearServingData() {
        this.servingData_ = getDefaultInstance().getServingData();
    }

    /* access modifiers changed from: private */
    public void setServingDataBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.servingData_ = value.toStringUtf8();
    }

    public static RequestInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RequestInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RequestInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RequestInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RequestInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RequestInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RequestInfo parseFrom(InputStream input) throws IOException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RequestInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RequestInfo parseDelimitedFrom(InputStream input) throws IOException {
        return (RequestInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RequestInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RequestInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RequestInfo parseFrom(CodedInputStream input) throws IOException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RequestInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RequestInfo prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RequestInfo, Builder> implements RequestInfoOrBuilder {
        private Builder() {
            super(RequestInfo.DEFAULT_INSTANCE);
        }

        public String getRequestId() {
            return ((RequestInfo) this.instance).getRequestId();
        }

        public ByteString getRequestIdBytes() {
            return ((RequestInfo) this.instance).getRequestIdBytes();
        }

        public Builder setRequestId(String value) {
            copyOnWrite();
            ((RequestInfo) this.instance).setRequestId(value);
            return this;
        }

        public Builder clearRequestId() {
            copyOnWrite();
            ((RequestInfo) this.instance).clearRequestId();
            return this;
        }

        public Builder setRequestIdBytes(ByteString value) {
            copyOnWrite();
            ((RequestInfo) this.instance).setRequestIdBytes(value);
            return this;
        }

        public String getServingData() {
            return ((RequestInfo) this.instance).getServingData();
        }

        public ByteString getServingDataBytes() {
            return ((RequestInfo) this.instance).getServingDataBytes();
        }

        public Builder setServingData(String value) {
            copyOnWrite();
            ((RequestInfo) this.instance).setServingData(value);
            return this;
        }

        public Builder clearServingData() {
            copyOnWrite();
            ((RequestInfo) this.instance).clearServingData();
            return this;
        }

        public Builder setServingDataBytes(ByteString value) {
            copyOnWrite();
            ((RequestInfo) this.instance).setServingDataBytes(value);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new RequestInfo();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"requestId_", "servingData_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<RequestInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (RequestInfo.class) {
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
        RequestInfo defaultInstance = new RequestInfo();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(RequestInfo.class, defaultInstance);
    }

    public static RequestInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RequestInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
