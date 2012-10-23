// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.util;

import android.content.ContentUris;
import android.content.UriMatcher;
import android.net.Uri;
import java.util.*;

// Referenced classes of package com.google.android.mms.util:
//            AbstractCache, PduCacheEntry

public final class PduCache extends AbstractCache {

    private PduCache() {
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    public static final PduCache getInstance() {
        com/google/android/mms/util/PduCache;
        JVM INSTR monitorenter ;
        PduCache pducache;
        if(sInstance == null)
            sInstance = new PduCache();
        pducache = sInstance;
        com/google/android/mms/util/PduCache;
        JVM INSTR monitorexit ;
        return pducache;
        Exception exception;
        exception;
        throw exception;
    }

    private Uri normalizeKey(Uri uri) {
        URI_MATCHER.match(uri);
        JVM INSTR tableswitch 1 9: default 56
    //                   1 62
    //                   2 56
    //                   3 70
    //                   4 56
    //                   5 70
    //                   6 56
    //                   7 70
    //                   8 56
    //                   9 70;
           goto _L1 _L2 _L1 _L3 _L1 _L3 _L1 _L3 _L1 _L3
_L1:
        Uri uri2 = null;
_L4:
        return uri2;
_L2:
        Uri uri1 = uri;
_L5:
        uri2 = uri1;
        if(true) goto _L4; else goto _L3
_L3:
        String s = uri.getLastPathSegment();
        uri1 = Uri.withAppendedPath(android.provider.Telephony.Mms.CONTENT_URI, s);
          goto _L5
    }

    private void purgeByMessageBox(Integer integer) {
        if(integer != null) {
            HashSet hashset = (HashSet)mMessageBoxes.remove(integer);
            if(hashset != null) {
                Iterator iterator = hashset.iterator();
                do {
                    if(!iterator.hasNext())
                        break;
                    Uri uri = (Uri)iterator.next();
                    mUpdating.remove(uri);
                    PduCacheEntry pducacheentry = (PduCacheEntry)super.purge(uri);
                    if(pducacheentry != null)
                        removeFromThreads(uri, pducacheentry);
                } while(true);
            }
        }
    }

    private void purgeByThreadId(long l) {
        HashSet hashset = (HashSet)mThreads.remove(Long.valueOf(l));
        if(hashset != null) {
            Iterator iterator = hashset.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                Uri uri = (Uri)iterator.next();
                mUpdating.remove(uri);
                PduCacheEntry pducacheentry = (PduCacheEntry)super.purge(uri);
                if(pducacheentry != null)
                    removeFromMessageBoxes(uri, pducacheentry);
            } while(true);
        }
    }

    private PduCacheEntry purgeSingleEntry(Uri uri) {
        mUpdating.remove(uri);
        PduCacheEntry pducacheentry = (PduCacheEntry)super.purge(uri);
        if(pducacheentry != null) {
            removeFromThreads(uri, pducacheentry);
            removeFromMessageBoxes(uri, pducacheentry);
        } else {
            pducacheentry = null;
        }
        return pducacheentry;
    }

    private void removeFromMessageBoxes(Uri uri, PduCacheEntry pducacheentry) {
        HashSet hashset = (HashSet)mThreads.get(Long.valueOf(pducacheentry.getMessageBox()));
        if(hashset != null)
            hashset.remove(uri);
    }

    private void removeFromThreads(Uri uri, PduCacheEntry pducacheentry) {
        HashSet hashset = (HashSet)mThreads.get(Long.valueOf(pducacheentry.getThreadId()));
        if(hashset != null)
            hashset.remove(uri);
    }

    /**
     * @deprecated Method isUpdating is deprecated
     */

    public boolean isUpdating(Uri uri) {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mUpdating.contains(uri);
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method purge is deprecated
     */

    public PduCacheEntry purge(Uri uri) {
        this;
        JVM INSTR monitorenter ;
        int i = URI_MATCHER.match(uri);
        i;
        JVM INSTR tableswitch 0 11: default 72
    //                   0 113
    //                   1 80
    //                   2 123
    //                   3 90
    //                   4 123
    //                   5 90
    //                   6 123
    //                   7 90
    //                   8 123
    //                   9 90
    //                   10 113
    //                   11 146;
           goto _L1 _L2 _L3 _L4 _L5 _L4 _L5 _L4 _L5 _L4 _L5 _L2 _L6
_L1:
        PduCacheEntry pducacheentry = null;
_L8:
        this;
        JVM INSTR monitorexit ;
        return pducacheentry;
_L3:
        pducacheentry = purgeSingleEntry(uri);
        continue; /* Loop/switch isn't completed */
_L5:
        String s = uri.getLastPathSegment();
        pducacheentry = purgeSingleEntry(Uri.withAppendedPath(android.provider.Telephony.Mms.CONTENT_URI, s));
        continue; /* Loop/switch isn't completed */
_L2:
        purgeAll();
        pducacheentry = null;
        continue; /* Loop/switch isn't completed */
_L4:
        purgeByMessageBox((Integer)MATCH_TO_MSGBOX_ID_MAP.get(Integer.valueOf(i)));
        pducacheentry = null;
        continue; /* Loop/switch isn't completed */
_L6:
        purgeByThreadId(ContentUris.parseId(uri));
        pducacheentry = null;
        if(true) goto _L8; else goto _L7
_L7:
        Exception exception;
        exception;
        throw exception;
    }

    public volatile Object purge(Object obj) {
        return purge((Uri)obj);
    }

    /**
     * @deprecated Method purgeAll is deprecated
     */

    public void purgeAll() {
        this;
        JVM INSTR monitorenter ;
        super.purgeAll();
        mMessageBoxes.clear();
        mThreads.clear();
        mUpdating.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method put is deprecated
     */

    public boolean put(Uri uri, PduCacheEntry pducacheentry) {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        int i = pducacheentry.getMessageBox();
        HashSet hashset = (HashSet)mMessageBoxes.get(Integer.valueOf(i));
        if(hashset == null) {
            hashset = new HashSet();
            mMessageBoxes.put(Integer.valueOf(i), hashset);
        }
        long l = pducacheentry.getThreadId();
        HashSet hashset1 = (HashSet)mThreads.get(Long.valueOf(l));
        if(hashset1 == null) {
            hashset1 = new HashSet();
            mThreads.put(Long.valueOf(l), hashset1);
        }
        Uri uri1 = normalizeKey(uri);
        flag = super.put(uri1, pducacheentry);
        if(flag) {
            hashset.add(uri1);
            hashset1.add(uri1);
        }
        setUpdating(uri, false);
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile boolean put(Object obj, Object obj1) {
        return put((Uri)obj, (PduCacheEntry)obj1);
    }

    /**
     * @deprecated Method setUpdating is deprecated
     */

    public void setUpdating(Uri uri, boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(!flag) goto _L2; else goto _L1
_L1:
        mUpdating.add(uri);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mUpdating.remove(uri);
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private static final boolean DEBUG = false;
    private static final boolean LOCAL_LOGV = false;
    private static final HashMap MATCH_TO_MSGBOX_ID_MAP;
    private static final int MMS_ALL = 0;
    private static final int MMS_ALL_ID = 1;
    private static final int MMS_CONVERSATION = 10;
    private static final int MMS_CONVERSATION_ID = 11;
    private static final int MMS_DRAFTS = 6;
    private static final int MMS_DRAFTS_ID = 7;
    private static final int MMS_INBOX = 2;
    private static final int MMS_INBOX_ID = 3;
    private static final int MMS_OUTBOX = 8;
    private static final int MMS_OUTBOX_ID = 9;
    private static final int MMS_SENT = 4;
    private static final int MMS_SENT_ID = 5;
    private static final String TAG = "PduCache";
    private static final UriMatcher URI_MATCHER;
    private static PduCache sInstance;
    private final HashMap mMessageBoxes = new HashMap();
    private final HashMap mThreads = new HashMap();
    private final HashSet mUpdating = new HashSet();

    static  {
        URI_MATCHER = new UriMatcher(-1);
        URI_MATCHER.addURI("mms", null, 0);
        URI_MATCHER.addURI("mms", "#", 1);
        URI_MATCHER.addURI("mms", "inbox", 2);
        URI_MATCHER.addURI("mms", "inbox/#", 3);
        URI_MATCHER.addURI("mms", "sent", 4);
        URI_MATCHER.addURI("mms", "sent/#", 5);
        URI_MATCHER.addURI("mms", "drafts", 6);
        URI_MATCHER.addURI("mms", "drafts/#", 7);
        URI_MATCHER.addURI("mms", "outbox", 8);
        URI_MATCHER.addURI("mms", "outbox/#", 9);
        URI_MATCHER.addURI("mms-sms", "conversations", 10);
        URI_MATCHER.addURI("mms-sms", "conversations/#", 11);
        MATCH_TO_MSGBOX_ID_MAP = new HashMap();
        MATCH_TO_MSGBOX_ID_MAP.put(Integer.valueOf(2), Integer.valueOf(1));
        MATCH_TO_MSGBOX_ID_MAP.put(Integer.valueOf(4), Integer.valueOf(2));
        MATCH_TO_MSGBOX_ID_MAP.put(Integer.valueOf(6), Integer.valueOf(3));
        MATCH_TO_MSGBOX_ID_MAP.put(Integer.valueOf(8), Integer.valueOf(4));
    }
}
