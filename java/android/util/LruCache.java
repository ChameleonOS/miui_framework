// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache {

    public LruCache(int i) {
        if(i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else {
            maxSize = i;
            map = new LinkedHashMap(0, 0.75F, true);
            return;
        }
    }

    private int safeSizeOf(Object obj, Object obj1) {
        int i = sizeOf(obj, obj1);
        if(i < 0)
            throw new IllegalStateException((new StringBuilder()).append("Negative size: ").append(obj).append("=").append(obj1).toString());
        else
            return i;
    }

    private void trimToSize(int i) {
_L2:
        this;
        JVM INSTR monitorenter ;
        if(size < 0 || map.isEmpty() && size != 0)
            throw new IllegalStateException((new StringBuilder()).append(getClass().getName()).append(".sizeOf() is reporting inconsistent results!").toString());
        break MISSING_BLOCK_LABEL_64;
        Exception exception;
        exception;
        throw exception;
        if(size > i)
            break MISSING_BLOCK_LABEL_77;
        this;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
        java.util.Map.Entry entry;
        entry = map.eldest();
        if(entry != null)
            break MISSING_BLOCK_LABEL_94;
        this;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
        Object obj;
        Object obj1;
        obj = entry.getKey();
        obj1 = entry.getValue();
        map.remove(obj);
        size = size - safeSizeOf(obj, obj1);
        evictionCount = 1 + evictionCount;
        this;
        JVM INSTR monitorexit ;
        entryRemoved(true, obj, obj1, null);
        if(true) goto _L2; else goto _L1
_L1:
    }

    protected Object create(Object obj) {
        return null;
    }

    /**
     * @deprecated Method createCount is deprecated
     */

    public final int createCount() {
        this;
        JVM INSTR monitorenter ;
        int i = createCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    protected void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    /**
     * @deprecated Method evictionCount is deprecated
     */

    public final int evictionCount() {
        this;
        JVM INSTR monitorenter ;
        int i = evictionCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final Object get(Object obj) {
        if(obj == null)
            throw new NullPointerException("key == null");
        this;
        JVM INSTR monitorenter ;
        Object obj1;
        obj1 = map.get(obj);
        if(obj1 == null)
            break MISSING_BLOCK_LABEL_47;
        hitCount = 1 + hitCount;
        this;
        JVM INSTR monitorexit ;
        Object obj2;
        obj2 = obj1;
        break MISSING_BLOCK_LABEL_180;
        missCount = 1 + missCount;
        this;
        JVM INSTR monitorexit ;
        obj2 = create(obj);
        if(obj2 == null) {
            obj2 = null;
            break MISSING_BLOCK_LABEL_180;
        }
        break MISSING_BLOCK_LABEL_82;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorenter ;
        Object obj3;
        createCount = 1 + createCount;
        obj3 = map.put(obj, obj2);
        if(obj3 == null)
            break MISSING_BLOCK_LABEL_146;
        map.put(obj, obj3);
_L1:
        this;
        JVM INSTR monitorexit ;
        Exception exception1;
        if(obj3 != null) {
            entryRemoved(false, obj, obj2, obj3);
            obj2 = obj3;
        } else {
            trimToSize(maxSize);
        }
        break MISSING_BLOCK_LABEL_180;
        size = size + safeSizeOf(obj, obj2);
          goto _L1
        exception1;
        throw exception1;
        return obj2;
    }

    /**
     * @deprecated Method hitCount is deprecated
     */

    public final int hitCount() {
        this;
        JVM INSTR monitorenter ;
        int i = hitCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method maxSize is deprecated
     */

    public final int maxSize() {
        this;
        JVM INSTR monitorenter ;
        int i = maxSize;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method missCount is deprecated
     */

    public final int missCount() {
        this;
        JVM INSTR monitorenter ;
        int i = missCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final Object put(Object obj, Object obj1) {
        if(obj == null || obj1 == null)
            throw new NullPointerException("key == null || value == null");
        this;
        JVM INSTR monitorenter ;
        Object obj2;
        putCount = 1 + putCount;
        size = size + safeSizeOf(obj, obj1);
        obj2 = map.put(obj, obj1);
        if(obj2 != null)
            size = size - safeSizeOf(obj, obj2);
        this;
        JVM INSTR monitorexit ;
        if(obj2 != null)
            entryRemoved(false, obj, obj2, obj1);
        trimToSize(maxSize);
        return obj2;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method putCount is deprecated
     */

    public final int putCount() {
        this;
        JVM INSTR monitorenter ;
        int i = putCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final Object remove(Object obj) {
        if(obj == null)
            throw new NullPointerException("key == null");
        this;
        JVM INSTR monitorenter ;
        Object obj1;
        obj1 = map.remove(obj);
        if(obj1 != null)
            size = size - safeSizeOf(obj, obj1);
        this;
        JVM INSTR monitorexit ;
        if(obj1 != null)
            entryRemoved(false, obj, obj1, null);
        return obj1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void resize(int i) {
        if(i <= 0)
            throw new IllegalArgumentException("maxSize <= 0");
        this;
        JVM INSTR monitorenter ;
        maxSize = i;
        this;
        JVM INSTR monitorexit ;
        trimToSize(i);
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method size is deprecated
     */

    public final int size() {
        this;
        JVM INSTR monitorenter ;
        int i = size;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    protected int sizeOf(Object obj, Object obj1) {
        return 1;
    }

    /**
     * @deprecated Method snapshot is deprecated
     */

    public final Map snapshot() {
        this;
        JVM INSTR monitorenter ;
        LinkedHashMap linkedhashmap = new LinkedHashMap(map);
        this;
        JVM INSTR monitorexit ;
        return linkedhashmap;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method toString is deprecated
     */

    public final String toString() {
        int i = 0;
        this;
        JVM INSTR monitorenter ;
        String s;
        int j = hitCount + missCount;
        if(j != 0)
            i = (100 * hitCount) / j;
        Object aobj[] = new Object[4];
        aobj[0] = Integer.valueOf(maxSize);
        aobj[1] = Integer.valueOf(hitCount);
        aobj[2] = Integer.valueOf(missCount);
        aobj[3] = Integer.valueOf(i);
        s = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", aobj);
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;
}
