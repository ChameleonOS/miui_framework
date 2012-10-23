// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import java.io.PrintStream;
import java.lang.reflect.Method;

class WithFramework {

    WithFramework() {
    }

    public static void main(String args[]) throws Exception {
        if(args.length == 0) {
            printUsage();
        } else {
            Class class1 = Class.forName(args[0]);
            System.loadLibrary("android_runtime");
            if(registerNatives() < 0)
                throw new RuntimeException("Error registering natives.");
            String args1[] = new String[-1 + args.length];
            System.arraycopy(args, 1, args1, 0, args1.length);
            Class aclass[] = new Class[1];
            aclass[0] = [Ljava/lang/String;;
            Method method = class1.getMethod("main", aclass);
            Object aobj[] = new Object[1];
            aobj[0] = args1;
            method.invoke(null, aobj);
        }
    }

    private static void printUsage() {
        System.err.println((new StringBuilder()).append("Usage: dalvikvm ").append(com/android/internal/util/WithFramework.getName()).append(" [main class] [args]").toString());
    }

    static native int registerNatives();
}
