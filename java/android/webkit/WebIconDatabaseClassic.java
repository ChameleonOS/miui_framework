// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.*;
import android.provider.Browser;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

// Referenced classes of package android.webkit:
//            WebIconDatabase

class WebIconDatabaseClassic extends WebIconDatabase {
    private static class EventHandler extends Handler {
        private class IconResult {

            void dispatch() {
                mListener.onReceivedIcon(mUrl, mIcon);
            }

            private final Bitmap mIcon;
            private final WebIconDatabase.IconListener mListener;
            private final String mUrl;
            final EventHandler this$0;

            IconResult(String s, Bitmap bitmap, WebIconDatabase.IconListener iconlistener) {
                this$0 = EventHandler.this;
                super();
                mUrl = s;
                mIcon = bitmap;
                mListener = iconlistener;
            }
        }


        private void bulkRequestIcons(Message message) {
            WebIconDatabase.IconListener iconlistener;
            ContentResolver contentresolver;
            String s;
            Cursor cursor;
            HashMap hashmap = (HashMap)message.obj;
            iconlistener = (WebIconDatabase.IconListener)hashmap.get("listener");
            contentresolver = (ContentResolver)hashmap.get("contentResolver");
            s = (String)hashmap.get("where");
            cursor = null;
            android.net.Uri uri = Browser.BOOKMARKS_URI;
            String as[] = new String[1];
            as[0] = "url";
            cursor = contentresolver.query(uri, as, s, null, null);
            boolean flag;
            if(cursor.moveToFirst())
                do {
                    requestIconAndSendResult(cursor.getString(0), iconlistener);
                    flag = cursor.moveToNext();
                } while(flag);
            if(cursor == null) goto _L2; else goto _L1
_L1:
            cursor.close();
_L2:
            return;
            IllegalStateException illegalstateexception;
            illegalstateexception;
            Log.e("WebIconDatabase", "BulkRequestIcons", illegalstateexception);
            if(cursor == null) goto _L2; else goto _L1
            Exception exception;
            exception;
            if(cursor != null)
                cursor.close();
            throw exception;
        }

        /**
         * @deprecated Method createHandler is deprecated
         */

        private void createHandler() {
            this;
            JVM INSTR monitorenter ;
            if(mHandler == null) {
                mHandler = new Handler() {

                    public void handleMessage(Message message) {
                        message.what;
                        JVM INSTR tableswitch 0 6: default 48
                    //                                   0 49
                    //                                   1 62
                    //                                   2 68
                    //                                   3 74
                    //                                   4 115
                    //                                   5 128
                    //                                   6 104;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
                        return;
_L2:
                        WebIconDatabaseClassic.nativeOpen((String)message.obj);
                        continue; /* Loop/switch isn't completed */
_L3:
                        WebIconDatabaseClassic.nativeClose();
                        continue; /* Loop/switch isn't completed */
_L4:
                        WebIconDatabaseClassic.nativeRemoveAllIcons();
                        continue; /* Loop/switch isn't completed */
_L5:
                        WebIconDatabase.IconListener iconlistener = (WebIconDatabase.IconListener)message.obj;
                        String s = message.getData().getString("url");
                        requestIconAndSendResult(s, iconlistener);
                        continue; /* Loop/switch isn't completed */
_L8:
                        bulkRequestIcons(message);
                        continue; /* Loop/switch isn't completed */
_L6:
                        WebIconDatabaseClassic.nativeRetainIconForPageUrl((String)message.obj);
                        continue; /* Loop/switch isn't completed */
_L7:
                        WebIconDatabaseClassic.nativeReleaseIconForPageUrl((String)message.obj);
                        if(true) goto _L1; else goto _L9
_L9:
                    }

                    final EventHandler this$0;

                 {
                    this$0 = EventHandler.this;
                    super();
                }
                };
                for(int i = mMessages.size(); i > 0; i--)
                    mHandler.sendMessage((Message)mMessages.remove(0));

                mMessages = null;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method hasHandler is deprecated
         */

        private boolean hasHandler() {
            this;
            JVM INSTR monitorenter ;
            Handler handler = mHandler;
            boolean flag;
            if(handler != null)
                flag = true;
            else
                flag = false;
            this;
            JVM INSTR monitorexit ;
            return flag;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method postMessage is deprecated
         */

        private void postMessage(Message message) {
            this;
            JVM INSTR monitorenter ;
            if(mMessages == null) goto _L2; else goto _L1
_L1:
            mMessages.add(message);
_L4:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            mHandler.sendMessage(message);
            if(true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        private void requestIconAndSendResult(String s, WebIconDatabase.IconListener iconlistener) {
            Bitmap bitmap = WebIconDatabaseClassic.nativeIconForPageUrl(s);
            if(bitmap != null)
                sendMessage(obtainMessage(10, new IconResult(s, bitmap, iconlistener)));
        }

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 10 10: default 24
        //                       10 25;
               goto _L1 _L2
_L1:
            return;
_L2:
            ((IconResult)message.obj).dispatch();
            if(true) goto _L1; else goto _L3
_L3:
        }

        static final int BULK_REQUEST_ICON = 6;
        static final int CLOSE = 1;
        private static final int ICON_RESULT = 10;
        static final int OPEN = 0;
        static final int RELEASE_ICON = 5;
        static final int REMOVE_ALL = 2;
        static final int REQUEST_ICON = 3;
        static final int RETAIN_ICON = 4;
        private Handler mHandler;
        private Vector mMessages;






        private EventHandler() {
            mMessages = new Vector();
        }

    }


    private WebIconDatabaseClassic() {
    }

    public static WebIconDatabaseClassic getInstance() {
        if(sIconDatabase == null)
            sIconDatabase = new WebIconDatabaseClassic();
        return sIconDatabase;
    }

    private static native void nativeClose();

    private static native Bitmap nativeIconForPageUrl(String s);

    private static native void nativeOpen(String s);

    private static native void nativeReleaseIconForPageUrl(String s);

    private static native void nativeRemoveAllIcons();

    private static native void nativeRetainIconForPageUrl(String s);

    public void bulkRequestIconForPageUrl(ContentResolver contentresolver, String s, WebIconDatabase.IconListener iconlistener) {
        if(iconlistener != null && mEventHandler.hasHandler()) {
            HashMap hashmap = new HashMap();
            hashmap.put("contentResolver", contentresolver);
            hashmap.put("where", s);
            hashmap.put("listener", iconlistener);
            Message message = Message.obtain(null, 6, hashmap);
            mEventHandler.postMessage(message);
        }
    }

    public void close() {
        mEventHandler.postMessage(Message.obtain(null, 1));
    }

    void createHandler() {
        mEventHandler.createHandler();
    }

    public void open(String s) {
        if(s != null) {
            File file = new File(s);
            if(!file.exists())
                file.mkdirs();
            mEventHandler.postMessage(Message.obtain(null, 0, file.getAbsolutePath()));
        }
    }

    public void releaseIconForPageUrl(String s) {
        if(s != null)
            mEventHandler.postMessage(Message.obtain(null, 5, s));
    }

    public void removeAllIcons() {
        mEventHandler.postMessage(Message.obtain(null, 2));
    }

    public void requestIconForPageUrl(String s, WebIconDatabase.IconListener iconlistener) {
        if(iconlistener != null && s != null) {
            Message message = Message.obtain(null, 3, iconlistener);
            message.getData().putString("url", s);
            mEventHandler.postMessage(message);
        }
    }

    public void retainIconForPageUrl(String s) {
        if(s != null)
            mEventHandler.postMessage(Message.obtain(null, 4, s));
    }

    private static final String LOGTAG = "WebIconDatabase";
    private static WebIconDatabaseClassic sIconDatabase;
    private final EventHandler mEventHandler = new EventHandler();






}
