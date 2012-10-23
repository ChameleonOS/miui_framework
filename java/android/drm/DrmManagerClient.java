// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.*;
import android.util.Log;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package android.drm:
//            DrmInfoRequest, DrmSupportInfo, DrmInfo, DrmRights, 
//            DrmUtils, DrmConvertedStatus, DrmInfoStatus, DrmErrorEvent, 
//            DrmInfoEvent, DrmEvent

public class DrmManagerClient {
    private class InfoHandler extends Handler {

        public void handleMessage(Message message) {
            DrmInfoEvent drminfoevent;
            DrmErrorEvent drmerrorevent;
            drminfoevent = null;
            drmerrorevent = null;
            message.what;
            JVM INSTR tableswitch 1 1: default 28
        //                       1 57;
               goto _L1 _L2
_L1:
            Log.e("DrmManagerClient", (new StringBuilder()).append("Unknown message type ").append(message.what).toString());
_L7:
            return;
_L2:
            int i;
            int j;
            String s;
            i = message.arg1;
            j = message.arg2;
            s = message.obj.toString();
            j;
            JVM INSTR tableswitch 1 6: default 120
        //                       1 231
        //                       2 199
        //                       3 231
        //                       4 231
        //                       5 231
        //                       6 231;
               goto _L3 _L4 _L5 _L4 _L4 _L4 _L4
_L5:
            break; /* Loop/switch isn't completed */
_L3:
            drmerrorevent = new DrmErrorEvent(i, j, s);
_L8:
            if(mOnInfoListener != null && drminfoevent != null)
                mOnInfoListener.onInfo(DrmManagerClient.this, drminfoevent);
            if(mOnErrorListener != null && drmerrorevent != null)
                mOnErrorListener.onError(DrmManagerClient.this, drmerrorevent);
            if(true) goto _L7; else goto _L6
_L6:
            try {
                DrmUtils.removeFile(s);
            }
            catch(IOException ioexception) {
                ioexception.printStackTrace();
            }
            drminfoevent = new DrmInfoEvent(i, j, s);
              goto _L8
_L4:
            drminfoevent = new DrmInfoEvent(i, j, s);
              goto _L8
        }

        public static final int INFO_EVENT_TYPE = 1;
        final DrmManagerClient this$0;

        public InfoHandler(Looper looper) {
            this$0 = DrmManagerClient.this;
            super(looper);
        }
    }

    private class EventHandler extends Handler {

        public void handleMessage(Message message) {
            DrmEvent drmevent;
            DrmErrorEvent drmerrorevent;
            HashMap hashmap;
            drmevent = null;
            drmerrorevent = null;
            hashmap = new HashMap();
            message.what;
            JVM INSTR tableswitch 1001 1002: default 40
        //                       1001 277
        //                       1002 69;
               goto _L1 _L2 _L3
_L1:
            Log.e("DrmManagerClient", (new StringBuilder()).append("Unknown message type ").append(message.what).toString());
_L4:
            return;
_L3:
            DrmInfo drminfo = (DrmInfo)message.obj;
            DrmInfoStatus drminfostatus = _processDrmInfo(mUniqueId, drminfo);
            hashmap.put("drm_info_status_object", drminfostatus);
            hashmap.put("drm_info_object", drminfo);
            if(drminfostatus != null && 1 == drminfostatus.statusCode) {
                drmevent = new DrmEvent(mUniqueId, getEventType(drminfostatus.infoType), null, hashmap);
            } else {
                int i;
                if(drminfostatus != null)
                    i = drminfostatus.infoType;
                else
                    i = drminfo.getInfoType();
                drmerrorevent = new DrmErrorEvent(mUniqueId, getErrorType(i), null, hashmap);
            }
_L5:
            if(mOnEventListener != null && drmevent != null)
                mOnEventListener.onEvent(DrmManagerClient.this, drmevent);
            if(mOnErrorListener != null && drmerrorevent != null)
                mOnErrorListener.onError(DrmManagerClient.this, drmerrorevent);
            if(true) goto _L4; else goto _L2
_L2:
            if(_removeAllRights(mUniqueId) == 0)
                drmevent = new DrmEvent(mUniqueId, 1001, null);
            else
                drmerrorevent = new DrmErrorEvent(mUniqueId, 2007, null);
              goto _L5
        }

        final DrmManagerClient this$0;

        public EventHandler(Looper looper) {
            this$0 = DrmManagerClient.this;
            super(looper);
        }
    }

    public static interface OnErrorListener {

        public abstract void onError(DrmManagerClient drmmanagerclient, DrmErrorEvent drmerrorevent);
    }

    public static interface OnEventListener {

        public abstract void onEvent(DrmManagerClient drmmanagerclient, DrmEvent drmevent);
    }

    public static interface OnInfoListener {

        public abstract void onInfo(DrmManagerClient drmmanagerclient, DrmInfoEvent drminfoevent);
    }


    public DrmManagerClient(Context context) {
        mContext = context;
        mReleased = false;
        createEventThreads();
        mUniqueId = _initialize();
    }

    private native DrmInfo _acquireDrmInfo(int i, DrmInfoRequest drminforequest);

    private native boolean _canHandle(int i, String s, String s1);

    private native int _checkRightsStatus(int i, String s, int j);

    private native DrmConvertedStatus _closeConvertSession(int i, int j);

    private native DrmConvertedStatus _convertData(int i, int j, byte abyte0[]);

    private native DrmSupportInfo[] _getAllSupportInfo(int i);

    private native ContentValues _getConstraints(int i, String s, int j);

    private native int _getDrmObjectType(int i, String s, String s1);

    private native ContentValues _getMetadata(int i, String s);

    private native String _getOriginalMimeType(int i, String s);

    private native int _initialize();

    private native void _installDrmEngine(int i, String s);

    private native int _openConvertSession(int i, String s);

    private native DrmInfoStatus _processDrmInfo(int i, DrmInfo drminfo);

    private native void _release(int i);

    private native int _removeAllRights(int i);

    private native int _removeRights(int i, String s);

    private native int _saveRights(int i, DrmRights drmrights, String s, String s1);

    private native void _setListeners(int i, Object obj);

    private String convertUriToPath(Uri uri) {
        String s = null;
        if(uri == null) goto _L2; else goto _L1
_L1:
        String s1 = uri.getScheme();
        if(s1 != null && !s1.equals("") && !s1.equals("file")) goto _L4; else goto _L3
_L3:
        s = uri.getPath();
_L2:
        return s;
_L4:
        Cursor cursor;
label0:
        {
            if(s1.equals("http")) {
                s = uri.toString();
                continue; /* Loop/switch isn't completed */
            }
            if(!s1.equals("content"))
                break; /* Loop/switch isn't completed */
            String as[] = new String[1];
            as[0] = "_data";
            cursor = null;
            try {
                cursor = mContext.getContentResolver().query(uri, as, null, null, null);
                if(cursor == null || cursor.getCount() == 0 || !cursor.moveToFirst())
                    throw new IllegalArgumentException("Given Uri could not be found in media store");
                break label0;
            }
            catch(SQLiteException sqliteexception) { }
            finally {
                if(cursor != null)
                    cursor.close();
                throw exception;
            }
        }
        throw new IllegalArgumentException("Given Uri is not formatted in a way so that it can be found in media store.");
        String s2 = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
        s = s2;
        if(cursor != null)
            cursor.close();
        if(true) goto _L2; else goto _L5
_L5:
        throw new IllegalArgumentException("Given Uri scheme is not supported");
    }

    private void createEventThreads() {
        if(mEventHandler == null && mInfoHandler == null) {
            mInfoThread = new HandlerThread("DrmManagerClient.InfoHandler");
            mInfoThread.start();
            mInfoHandler = new InfoHandler(mInfoThread.getLooper());
            mEventThread = new HandlerThread("DrmManagerClient.EventHandler");
            mEventThread.start();
            mEventHandler = new EventHandler(mEventThread.getLooper());
        }
    }

    private void createListeners() {
        _setListeners(mUniqueId, new WeakReference(this));
    }

    private int getErrorType(int i) {
        char c = '\uFFFF';
        i;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 34
    //                   2 34
    //                   3 34;
           goto _L1 _L2 _L2 _L2
_L1:
        return c;
_L2:
        c = '\u07D6';
        if(true) goto _L1; else goto _L3
_L3:
    }

    private int getEventType(int i) {
        char c = '\uFFFF';
        i;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 34
    //                   2 34
    //                   3 34;
           goto _L1 _L2 _L2 _L2
_L1:
        return c;
_L2:
        c = '\u03EA';
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static void notify(Object obj, int i, int j, String s) {
        DrmManagerClient drmmanagerclient = (DrmManagerClient)((WeakReference)obj).get();
        if(drmmanagerclient != null && drmmanagerclient.mInfoHandler != null) {
            Message message = drmmanagerclient.mInfoHandler.obtainMessage(1, i, j, s);
            drmmanagerclient.mInfoHandler.sendMessage(message);
        }
    }

    public DrmInfo acquireDrmInfo(DrmInfoRequest drminforequest) {
        if(drminforequest == null || !drminforequest.isValid())
            throw new IllegalArgumentException("Given drmInfoRequest is invalid/null");
        else
            return _acquireDrmInfo(mUniqueId, drminforequest);
    }

    public int acquireRights(DrmInfoRequest drminforequest) {
        DrmInfo drminfo = acquireDrmInfo(drminforequest);
        int i;
        if(drminfo == null)
            i = -2000;
        else
            i = processDrmInfo(drminfo);
        return i;
    }

    public boolean canHandle(Uri uri, String s) {
        if((uri == null || Uri.EMPTY == uri) && (s == null || s.equals("")))
            throw new IllegalArgumentException("Uri or the mimetype should be non null");
        else
            return canHandle(convertUriToPath(uri), s);
    }

    public boolean canHandle(String s, String s1) {
        if((s == null || s.equals("")) && (s1 == null || s1.equals("")))
            throw new IllegalArgumentException("Path or the mimetype should be non null");
        else
            return _canHandle(mUniqueId, s, s1);
    }

    public int checkRightsStatus(Uri uri) {
        if(uri == null || Uri.EMPTY == uri)
            throw new IllegalArgumentException("Given uri is not valid");
        else
            return checkRightsStatus(convertUriToPath(uri));
    }

    public int checkRightsStatus(Uri uri, int i) {
        if(uri == null || Uri.EMPTY == uri)
            throw new IllegalArgumentException("Given uri is not valid");
        else
            return checkRightsStatus(convertUriToPath(uri), i);
    }

    public int checkRightsStatus(String s) {
        return checkRightsStatus(s, 0);
    }

    public int checkRightsStatus(String s, int i) {
        if(s == null || s.equals("") || !DrmStore.Action.isValid(i))
            throw new IllegalArgumentException("Given path or action is not valid");
        else
            return _checkRightsStatus(mUniqueId, s, i);
    }

    public DrmConvertedStatus closeConvertSession(int i) {
        return _closeConvertSession(mUniqueId, i);
    }

    public DrmConvertedStatus convertData(int i, byte abyte0[]) {
        if(abyte0 == null || abyte0.length <= 0)
            throw new IllegalArgumentException("Given inputData should be non null");
        else
            return _convertData(mUniqueId, i, abyte0);
    }

    protected void finalize() {
        if(!mReleased) {
            Log.w("DrmManagerClient", "You should have called release()");
            release();
        }
    }

    public String[] getAvailableDrmEngines() {
        DrmSupportInfo adrmsupportinfo[] = _getAllSupportInfo(mUniqueId);
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < adrmsupportinfo.length; i++)
            arraylist.add(adrmsupportinfo[i].getDescriprition());

        return (String[])arraylist.toArray(new String[arraylist.size()]);
    }

    public ContentValues getConstraints(Uri uri, int i) {
        if(uri == null || Uri.EMPTY == uri)
            throw new IllegalArgumentException("Uri should be non null");
        else
            return getConstraints(convertUriToPath(uri), i);
    }

    public ContentValues getConstraints(String s, int i) {
        if(s == null || s.equals("") || !DrmStore.Action.isValid(i))
            throw new IllegalArgumentException("Given usage or path is invalid/null");
        else
            return _getConstraints(mUniqueId, s, i);
    }

    public int getDrmObjectType(Uri uri, String s) {
        String s1;
        if((uri == null || Uri.EMPTY == uri) && (s == null || s.equals("")))
            throw new IllegalArgumentException("Uri or the mimetype should be non null");
        s1 = "";
        String s2 = convertUriToPath(uri);
        s1 = s2;
_L2:
        return getDrmObjectType(s1, s);
        Exception exception;
        exception;
        Log.w("DrmManagerClient", "Given Uri could not be found in media store");
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getDrmObjectType(String s, String s1) {
        if((s == null || s.equals("")) && (s1 == null || s1.equals("")))
            throw new IllegalArgumentException("Path or the mimetype should be non null");
        else
            return _getDrmObjectType(mUniqueId, s, s1);
    }

    public ContentValues getMetadata(Uri uri) {
        if(uri == null || Uri.EMPTY == uri)
            throw new IllegalArgumentException("Uri should be non null");
        else
            return getMetadata(convertUriToPath(uri));
    }

    public ContentValues getMetadata(String s) {
        if(s == null || s.equals(""))
            throw new IllegalArgumentException("Given path is invalid/null");
        else
            return _getMetadata(mUniqueId, s);
    }

    public String getOriginalMimeType(Uri uri) {
        if(uri == null || Uri.EMPTY == uri)
            throw new IllegalArgumentException("Given uri is not valid");
        else
            return getOriginalMimeType(convertUriToPath(uri));
    }

    public String getOriginalMimeType(String s) {
        if(s == null || s.equals(""))
            throw new IllegalArgumentException("Given path should be non null");
        else
            return _getOriginalMimeType(mUniqueId, s);
    }

    public void installDrmEngine(String s) {
        if(s == null || s.equals("")) {
            throw new IllegalArgumentException((new StringBuilder()).append("Given engineFilePath: ").append(s).append("is not valid").toString());
        } else {
            _installDrmEngine(mUniqueId, s);
            return;
        }
    }

    public int openConvertSession(String s) {
        if(s == null || s.equals(""))
            throw new IllegalArgumentException("Path or the mimeType should be non null");
        else
            return _openConvertSession(mUniqueId, s);
    }

    public int processDrmInfo(DrmInfo drminfo) {
        if(drminfo == null || !drminfo.isValid())
            throw new IllegalArgumentException("Given drmInfo is invalid/null");
        char c = '\uF830';
        if(mEventHandler != null) {
            Message message = mEventHandler.obtainMessage(1002, drminfo);
            if(mEventHandler.sendMessage(message))
                c = '\0';
        }
        return c;
    }

    public void release() {
        if(mReleased) {
            Log.w("DrmManagerClient", "You have already called release()");
        } else {
            mReleased = true;
            if(mEventHandler != null) {
                mEventThread.quit();
                mEventThread = null;
            }
            if(mInfoHandler != null) {
                mInfoThread.quit();
                mInfoThread = null;
            }
            mEventHandler = null;
            mInfoHandler = null;
            mOnEventListener = null;
            mOnInfoListener = null;
            mOnErrorListener = null;
            _release(mUniqueId);
        }
    }

    public int removeAllRights() {
        char c = '\uF830';
        if(mEventHandler != null) {
            Message message = mEventHandler.obtainMessage(1001);
            if(mEventHandler.sendMessage(message))
                c = '\0';
        }
        return c;
    }

    public int removeRights(Uri uri) {
        if(uri == null || Uri.EMPTY == uri)
            throw new IllegalArgumentException("Given uri is not valid");
        else
            return removeRights(convertUriToPath(uri));
    }

    public int removeRights(String s) {
        if(s == null || s.equals(""))
            throw new IllegalArgumentException("Given path should be non null");
        else
            return _removeRights(mUniqueId, s);
    }

    public int saveRights(DrmRights drmrights, String s, String s1) throws IOException {
        if(drmrights == null || !drmrights.isValid())
            throw new IllegalArgumentException("Given drmRights or contentPath is not valid");
        if(s != null && !s.equals(""))
            DrmUtils.writeToFile(s, drmrights.getData());
        return _saveRights(mUniqueId, drmrights, s, s1);
    }

    /**
     * @deprecated Method setOnErrorListener is deprecated
     */

    public void setOnErrorListener(OnErrorListener onerrorlistener) {
        this;
        JVM INSTR monitorenter ;
        mOnErrorListener = onerrorlistener;
        if(onerrorlistener != null)
            createListeners();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setOnEventListener is deprecated
     */

    public void setOnEventListener(OnEventListener oneventlistener) {
        this;
        JVM INSTR monitorenter ;
        mOnEventListener = oneventlistener;
        if(oneventlistener != null)
            createListeners();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setOnInfoListener is deprecated
     */

    public void setOnInfoListener(OnInfoListener oninfolistener) {
        this;
        JVM INSTR monitorenter ;
        mOnInfoListener = oninfolistener;
        if(oninfolistener != null)
            createListeners();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private static final int ACTION_PROCESS_DRM_INFO = 1002;
    private static final int ACTION_REMOVE_ALL_RIGHTS = 1001;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_UNKNOWN = -2000;
    private static final String TAG = "DrmManagerClient";
    private Context mContext;
    private EventHandler mEventHandler;
    HandlerThread mEventThread;
    private InfoHandler mInfoHandler;
    HandlerThread mInfoThread;
    private int mNativeContext;
    private OnErrorListener mOnErrorListener;
    private OnEventListener mOnEventListener;
    private OnInfoListener mOnInfoListener;
    private boolean mReleased;
    private int mUniqueId;

    static  {
        System.loadLibrary("drmframework_jni");
    }








}
