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

public final class OAuthRequirements extends GeneratedMessageLite<OAuthRequirements, Builder> implements OAuthRequirementsOrBuilder {
    public static final int CANONICAL_SCOPES_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final OAuthRequirements DEFAULT_INSTANCE;
    private static volatile Parser<OAuthRequirements> PARSER;
    private String canonicalScopes_ = "";

    private OAuthRequirements() {
    }

    public String getCanonicalScopes() {
        return this.canonicalScopes_;
    }

    public ByteString getCanonicalScopesBytes() {
        return ByteString.copyFromUtf8(this.canonicalScopes_);
    }

    /* access modifiers changed from: private */
    public void setCanonicalScopes(String value) {
        value.getClass();
        this.canonicalScopes_ = value;
    }

    /* access modifiers changed from: private */
    public void clearCanonicalScopes() {
        this.canonicalScopes_ = getDefaultInstance().getCanonicalScopes();
    }

    /* access modifiers changed from: private */
    public void setCanonicalScopesBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.canonicalScopes_ = value.toStringUtf8();
    }

    public static OAuthRequirements parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static OAuthRequirements parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static OAuthRequirements parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static OAuthRequirements parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static OAuthRequirements parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static OAuthRequirements parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static OAuthRequirements parseFrom(InputStream input) throws IOException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static OAuthRequirements parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static OAuthRequirements parseDelimitedFrom(InputStream input) throws IOException {
        return (OAuthRequirements) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static OAuthRequirements parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (OAuthRequirements) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static OAuthRequirements parseFrom(CodedInputStream input) throws IOException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static OAuthRequirements parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(OAuthRequirements prototype) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<OAuthRequirements, Builder> implements OAuthRequirementsOrBuilder {
        private Builder() {
            super(OAuthRequirements.DEFAULT_INSTANCE);
        }

        public String getCanonicalScopes() {
            return ((OAuthRequirements) this.instance).getCanonicalScopes();
        }

        public ByteString getCanonicalScopesBytes() {
            return ((OAuthRequirements) this.instance).getCanonicalScopesBytes();
        }

        public Builder setCanonicalScopes(String value) {
            copyOnWrite();
            ((OAuthRequirements) this.instance).setCanonicalScopes(value);
            return this;
        }

        public Builder clearCanonicalScopes() {
            copyOnWrite();
            ((OAuthRequirements) this.instance).clearCanonicalScopes();
            return this;
        }

        public Builder setCanonicalScopesBytes(ByteString value) {
            copyOnWrite();
            ((OAuthRequirements) this.instance).setCanonicalScopesBytes(value);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE:
                return new OAuthRequirements();
            case NEW_BUILDER:
                return new Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"canonicalScopes_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                Parser<OAuthRequirements> parser = PARSER;
                if (parser == null) {
                    synchronized (OAuthRequirements.class) {
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
        OAuthRequirements defaultInstance = new OAuthRequirements();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(OAuthRequirements.class, defaultInstance);
    }

    public static OAuthRequirements getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<OAuthRequirements> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
