// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


final class JsonScope extends Enum {

    private JsonScope(String s, int i) {
        super(s, i);
    }

    public static JsonScope valueOf(String s) {
        return (JsonScope)Enum.valueOf(android/util/JsonScope, s);
    }

    public static JsonScope[] values() {
        return (JsonScope[])$VALUES.clone();
    }

    private static final JsonScope $VALUES[];
    public static final JsonScope CLOSED;
    public static final JsonScope DANGLING_NAME;
    public static final JsonScope EMPTY_ARRAY;
    public static final JsonScope EMPTY_DOCUMENT;
    public static final JsonScope EMPTY_OBJECT;
    public static final JsonScope NONEMPTY_ARRAY;
    public static final JsonScope NONEMPTY_DOCUMENT;
    public static final JsonScope NONEMPTY_OBJECT;

    static  {
        EMPTY_ARRAY = new JsonScope("EMPTY_ARRAY", 0);
        NONEMPTY_ARRAY = new JsonScope("NONEMPTY_ARRAY", 1);
        EMPTY_OBJECT = new JsonScope("EMPTY_OBJECT", 2);
        DANGLING_NAME = new JsonScope("DANGLING_NAME", 3);
        NONEMPTY_OBJECT = new JsonScope("NONEMPTY_OBJECT", 4);
        EMPTY_DOCUMENT = new JsonScope("EMPTY_DOCUMENT", 5);
        NONEMPTY_DOCUMENT = new JsonScope("NONEMPTY_DOCUMENT", 6);
        CLOSED = new JsonScope("CLOSED", 7);
        JsonScope ajsonscope[] = new JsonScope[8];
        ajsonscope[0] = EMPTY_ARRAY;
        ajsonscope[1] = NONEMPTY_ARRAY;
        ajsonscope[2] = EMPTY_OBJECT;
        ajsonscope[3] = DANGLING_NAME;
        ajsonscope[4] = NONEMPTY_OBJECT;
        ajsonscope[5] = EMPTY_DOCUMENT;
        ajsonscope[6] = NONEMPTY_DOCUMENT;
        ajsonscope[7] = CLOSED;
        $VALUES = ajsonscope;
    }
}
