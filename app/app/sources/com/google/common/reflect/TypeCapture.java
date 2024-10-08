package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@ElementTypesAreNonnullByDefault
abstract class TypeCapture<T> {
    TypeCapture() {
    }

    /* access modifiers changed from: package-private */
    public final Type capture() {
        Type superclass = getClass().getGenericSuperclass();
        Preconditions.checkArgument(superclass instanceof ParameterizedType, "%s isn't parameterized", (Object) superclass);
        return ((ParameterizedType) superclass).getActualTypeArguments()[0];
    }
}
