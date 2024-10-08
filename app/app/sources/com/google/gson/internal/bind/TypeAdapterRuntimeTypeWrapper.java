package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final Gson context;
    private final TypeAdapter<T> delegate;
    private final Type type;

    TypeAdapterRuntimeTypeWrapper(Gson context2, TypeAdapter<T> delegate2, Type type2) {
        this.context = context2;
        this.delegate = delegate2;
        this.type = type2;
    }

    public T read(JsonReader in) throws IOException {
        return this.delegate.read(in);
    }

    public void write(JsonWriter out, T value) throws IOException {
        TypeAdapter<T> chosen = this.delegate;
        Type runtimeType = getRuntimeTypeIfMoreSpecific(this.type, value);
        if (runtimeType != this.type) {
            TypeAdapter<T> runtimeTypeAdapter = this.context.getAdapter(TypeToken.get(runtimeType));
            if (!(runtimeTypeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                chosen = runtimeTypeAdapter;
            } else if (!isReflective(this.delegate)) {
                chosen = this.delegate;
            } else {
                chosen = runtimeTypeAdapter;
            }
        }
        chosen.write(out, value);
    }

    private static boolean isReflective(TypeAdapter<?> typeAdapter) {
        TypeAdapter<?> delegate2;
        while ((typeAdapter instanceof SerializationDelegatingTypeAdapter) && (delegate2 = ((SerializationDelegatingTypeAdapter) typeAdapter).getSerializationDelegate()) != typeAdapter) {
            typeAdapter = delegate2;
        }
        return typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter;
    }

    private static Type getRuntimeTypeIfMoreSpecific(Type type2, Object value) {
        if (value == null) {
            return type2;
        }
        if ((type2 instanceof Class) || (type2 instanceof TypeVariable)) {
            return value.getClass();
        }
        return type2;
    }
}
