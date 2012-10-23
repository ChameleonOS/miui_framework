// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.util;

import java.util.HashMap;

public abstract class AbstractCache {
    private static class CacheEntry {

        int hit;
        Object value;

        private CacheEntry() {
        }

    }


    protected AbstractCache() {
    }

    public Object get(Object obj) {
        if(obj == null) goto _L2; else goto _L1
_L1:
        CacheEntry cacheentry = (CacheEntry)mCacheMap.get(obj);
        if(cacheentry == null) goto _L2; else goto _L3
_L3:
        Object obj1;
        cacheentry.hit = 1 + cacheentry.hit;
        obj1 = cacheentry.value;
_L5:
        return obj1;
_L2:
        obj1 = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public Object purge(Object obj) {
        CacheEntry cacheentry = (CacheEntry)mCacheMap.remove(obj);
        Object obj1;
        if(cacheentry != null)
            obj1 = cacheentry.value;
        else
            obj1 = null;
        return obj1;
    }

    public void purgeAll() {
        mCacheMap.clear();
    }

    public boolean put(Object obj, Object obj1) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(mCacheMap.size() < 500 && obj != null) {
            CacheEntry cacheentry = new CacheEntry();
            cacheentry.value = obj1;
            mCacheMap.put(obj, cacheentry);
            flag = true;
        }
        return flag;
    }

    public int size() {
        return mCacheMap.size();
    }

    private static final boolean DEBUG = false;
    private static final boolean LOCAL_LOGV = false;
    private static final int MAX_CACHED_ITEMS = 500;
    private static final String TAG = "AbstractCache";
    private final HashMap mCacheMap = new HashMap();
}
