// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import java.util.ArrayList;

public class SystemProperties {

    public SystemProperties() {
    }

    public static void addChangeCallback(Runnable runnable) {
        ArrayList arraylist = sChangeCallbacks;
        arraylist;
        JVM INSTR monitorenter ;
        if(sChangeCallbacks.size() == 0)
            native_add_change_callback();
        sChangeCallbacks.add(runnable);
        return;
    }

    static void callChangeCallbacks() {
        ArrayList arraylist = sChangeCallbacks;
        arraylist;
        JVM INSTR monitorenter ;
        if(sChangeCallbacks.size() != 0) {
            ArrayList arraylist1 = new ArrayList(sChangeCallbacks);
            for(int i = 0; i < arraylist1.size(); i++)
                ((Runnable)arraylist1.get(i)).run();

        }
        return;
    }

    public static String get(String s) {
        if(s.length() > 31)
            throw new IllegalArgumentException("key.length > 31");
        else
            return native_get(s);
    }

    public static String get(String s, String s1) {
        if(s.length() > 31)
            throw new IllegalArgumentException("key.length > 31");
        else
            return native_get(s, s1);
    }

    public static boolean getBoolean(String s, boolean flag) {
        if(s.length() > 31)
            throw new IllegalArgumentException("key.length > 31");
        else
            return native_get_boolean(s, flag);
    }

    public static int getInt(String s, int i) {
        if(s.length() > 31)
            throw new IllegalArgumentException("key.length > 31");
        else
            return native_get_int(s, i);
    }

    public static long getLong(String s, long l) {
        if(s.length() > 31)
            throw new IllegalArgumentException("key.length > 31");
        else
            return native_get_long(s, l);
    }

    private static native void native_add_change_callback();

    private static native String native_get(String s);

    private static native String native_get(String s, String s1);

    private static native boolean native_get_boolean(String s, boolean flag);

    private static native int native_get_int(String s, int i);

    private static native long native_get_long(String s, long l);

    private static native void native_set(String s, String s1);

    public static void set(String s, String s1) {
        if(s.length() > 31)
            throw new IllegalArgumentException("key.length > 31");
        if(s1 != null && s1.length() > 91) {
            throw new IllegalArgumentException("val.length > 91");
        } else {
            native_set(s, s1);
            return;
        }
    }

    public static final int PROP_NAME_MAX = 31;
    public static final int PROP_VALUE_MAX = 91;
    private static final ArrayList sChangeCallbacks = new ArrayList();

}
