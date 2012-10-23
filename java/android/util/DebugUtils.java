// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DebugUtils {

    public DebugUtils() {
    }

    public static void buildShortClassTag(Object obj, StringBuilder stringbuilder) {
        if(obj == null) {
            stringbuilder.append("null");
        } else {
            String s = obj.getClass().getSimpleName();
            if(s == null || s.isEmpty()) {
                s = obj.getClass().getName();
                int i = s.lastIndexOf('.');
                if(i > 0)
                    s = s.substring(i + 1);
            }
            stringbuilder.append(s);
            stringbuilder.append('{');
            stringbuilder.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    public static boolean isObjectSelected(Object obj) {
        boolean flag;
        String s;
        flag = false;
        s = System.getenv("ANDROID_OBJECT_FILTER");
        if(s == null || s.length() <= 0) goto _L2; else goto _L1
_L1:
        String as[] = s.split("@");
        if(!obj.getClass().getSimpleName().matches(as[0])) goto _L2; else goto _L3
_L3:
        int i = 1;
_L5:
        if(i < as.length)
            break MISSING_BLOCK_LABEL_52;
_L2:
        return flag;
        String as1[] = as[i].split("=");
        Class class1 = obj.getClass();
        Class class2 = class1;
        try {
            Method method;
            do {
                method = class2.getDeclaredMethod((new StringBuilder()).append("get").append(as1[0].substring(0, 1).toUpperCase()).append(as1[0].substring(1)).toString(), (Class[])null);
                class2 = class1.getSuperclass();
            } while(class2 != null && method == null);
            if(method != null) {
                Object obj1 = method.invoke(obj, (Object[])null);
                String s1;
                if(obj1 != null)
                    s1 = obj1.toString();
                else
                    s1 = "null";
                flag |= s1.matches(as1[1]);
            }
        }
        catch(NoSuchMethodException nosuchmethodexception) {
            nosuchmethodexception.printStackTrace();
        }
        catch(IllegalAccessException illegalaccessexception) {
            illegalaccessexception.printStackTrace();
        }
        catch(InvocationTargetException invocationtargetexception) {
            invocationtargetexception.printStackTrace();
        }
        i++;
        if(true) goto _L5; else goto _L4
_L4:
    }
}
