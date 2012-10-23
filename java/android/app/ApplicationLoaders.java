// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import dalvik.system.PathClassLoader;
import java.util.HashMap;
import java.util.Map;

class ApplicationLoaders {

    ApplicationLoaders() {
    }

    public static ApplicationLoaders getDefault() {
        return gApplicationLoaders;
    }

    public ClassLoader getClassLoader(String s, String s1, ClassLoader classloader) {
        ClassLoader classloader1 = ClassLoader.getSystemClassLoader().getParent();
        Map map = mLoaders;
        map;
        JVM INSTR monitorenter ;
        if(classloader == null)
            classloader = classloader1;
        Object obj;
        if(classloader == classloader1) {
            obj = (ClassLoader)mLoaders.get(s);
            if(obj == null) {
                PathClassLoader pathclassloader = new PathClassLoader(s, s1, classloader);
                mLoaders.put(s, pathclassloader);
                obj = pathclassloader;
            }
        } else {
            obj = new PathClassLoader(s, classloader);
        }
        return ((ClassLoader) (obj));
    }

    private static final ApplicationLoaders gApplicationLoaders = new ApplicationLoaders();
    private final Map mLoaders = new HashMap();

}
