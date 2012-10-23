// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.location.Country;
import android.location.CountryDetector;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import miui.telephony.CallerInfo;

// Referenced classes of package com.android.internal.telephony:
//            CallerInfo

public class CallerInfoAsyncQuery {
    private class CallerInfoAsyncQueryHandler extends AsyncQueryHandler {
        protected class CallerInfoWorkerHandler extends android.content.AsyncQueryHandler.WorkerHandler {

            public void handleMessage(Message message) {
                android.content.AsyncQueryHandler.WorkerArgs workerargs;
                CookieWrapper cookiewrapper;
                workerargs = (android.content.AsyncQueryHandler.WorkerArgs)message.obj;
                cookiewrapper = (CookieWrapper)workerargs.cookie;
                if(cookiewrapper != null) goto _L2; else goto _L1
_L1:
                super.handleMessage(message);
_L4:
                return;
_L2:
                switch(cookiewrapper.event) {
                case 1: // '\001'
                    super.handleMessage(message);
                    break;

                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                case 5: // '\005'
                    Message message1 = workerargs.handler.obtainMessage(message.what);
                    message1.obj = workerargs;
                    message1.arg1 = message.arg1;
                    message1.sendToTarget();
                    break;
                }
                if(true) goto _L4; else goto _L3
_L3:
            }

            final CallerInfoAsyncQueryHandler this$1;

            public CallerInfoWorkerHandler(Looper looper) {
                this$1 = CallerInfoAsyncQueryHandler.this;
                super(CallerInfoAsyncQueryHandler.this, looper);
            }
        }


        protected Handler createHandler(Looper looper) {
            return new CallerInfoWorkerHandler(looper);
        }

        protected void onQueryComplete(int i, Object obj, Cursor cursor) {
            CookieWrapper cookiewrapper = (CookieWrapper)obj;
            if(cookiewrapper != null)
                if(cookiewrapper.event == 3) {
                    release();
                } else {
                    if(mCallerInfo == null) {
                        if(mQueryContext == null || mQueryUri == null)
                            throw new QueryPoolException("Bad context or query uri, or CallerInfoAsyncQuery already released.");
                        CookieWrapper cookiewrapper1;
                        if(cookiewrapper.event == 4)
                            mCallerInfo = (new com.android.internal.telephony.CallerInfo()).markAsEmergency(mQueryContext);
                        else
                        if(cookiewrapper.event == 5) {
                            mCallerInfo = (new com.android.internal.telephony.CallerInfo()).markAsVoiceMail();
                        } else {
                            mCallerInfo = CallerInfo.getCallerInfo(mQueryContext, mQueryUri, cursor);
                            com.android.internal.telephony.CallerInfo callerinfo = CallerInfo.doSecondaryLookupIfNecessary(mQueryContext, cookiewrapper.number, mCallerInfo);
                            if(callerinfo != mCallerInfo)
                                mCallerInfo = callerinfo;
                            CallerInfo.doSpNumberQuery(mQueryContext, cookiewrapper.number, mCallerInfo);
                            if(TextUtils.isEmpty(mCallerInfo.name))
                                mCallerInfo.updateGeoDescription(mQueryContext, cookiewrapper.number);
                            if(!TextUtils.isEmpty(cookiewrapper.number)) {
                                CountryDetector countrydetector = (CountryDetector)mQueryContext.getSystemService("country_detector");
                                mCallerInfo.phoneNumber = PhoneNumberUtils.formatNumber(cookiewrapper.number, mCallerInfo.normalizedNumber, countrydetector.detectCountry().getCountryIso());
                            }
                        }
                        cookiewrapper1 = new CookieWrapper();
                        cookiewrapper1.event = 3;
                        startQuery(i, cookiewrapper1, null, null, null, null, null);
                    }
                    if(cookiewrapper.listener != null)
                        cookiewrapper.listener.onQueryComplete(i, cookiewrapper.cookie, mCallerInfo);
                }
        }

        private com.android.internal.telephony.CallerInfo mCallerInfo;
        private Context mQueryContext;
        private Uri mQueryUri;
        final CallerInfoAsyncQuery this$0;


/*
        static Context access$302(CallerInfoAsyncQueryHandler callerinfoasyncqueryhandler, Context context) {
            callerinfoasyncqueryhandler.mQueryContext = context;
            return context;
        }

*/


/*
        static Uri access$402(CallerInfoAsyncQueryHandler callerinfoasyncqueryhandler, Uri uri) {
            callerinfoasyncqueryhandler.mQueryUri = uri;
            return uri;
        }

*/


/*
        static com.android.internal.telephony.CallerInfo access$502(CallerInfoAsyncQueryHandler callerinfoasyncqueryhandler, com.android.internal.telephony.CallerInfo callerinfo) {
            callerinfoasyncqueryhandler.mCallerInfo = callerinfo;
            return callerinfo;
        }

*/

        private CallerInfoAsyncQueryHandler(Context context) {
            this$0 = CallerInfoAsyncQuery.this;
            super(context.getContentResolver());
        }

    }

    public static class QueryPoolException extends SQLException {

        public QueryPoolException(String s) {
            super(s);
        }
    }

    private static final class CookieWrapper {

        public Object cookie;
        public int event;
        public OnQueryCompleteListener listener;
        public String number;

        private CookieWrapper() {
        }

    }

    public static interface OnQueryCompleteListener {

        public abstract void onQueryComplete(int i, Object obj, com.android.internal.telephony.CallerInfo callerinfo);
    }


    private CallerInfoAsyncQuery() {
    }

    private void allocate(Context context, Uri uri) {
        if(context == null || uri == null) {
            throw new QueryPoolException("Bad context or query uri.");
        } else {
            mHandler = new CallerInfoAsyncQueryHandler(context);
            mHandler.mQueryContext = context;
            mHandler.mQueryUri = uri;
            return;
        }
    }

    private static String getPhoneNumber(String s) {
        miui.telephony.PhoneNumberUtils.PhoneNumber phonenumber = miui.telephony.PhoneNumberUtils.PhoneNumber.parse(s);
        if(phonenumber != null)
            s = phonenumber.getNumberWithoutPrefix(true);
        return s;
    }

    private void release() {
        mHandler.mQueryContext = null;
        mHandler.mQueryUri = null;
        mHandler.mCallerInfo = null;
        mHandler = null;
    }

    private static String sanitizeUriToString(Uri uri) {
        String s;
        if(uri != null) {
            s = uri.toString();
            int i = s.lastIndexOf('/');
            if(i > 0)
                s = (new StringBuilder()).append(s.substring(0, i)).append("/xxxxxxx").toString();
        } else {
            s = "";
        }
        return s;
    }

    public static CallerInfoAsyncQuery startQuery(int i, Context context, Uri uri, OnQueryCompleteListener onquerycompletelistener, Object obj) {
        CallerInfoAsyncQuery callerinfoasyncquery = new CallerInfoAsyncQuery();
        callerinfoasyncquery.allocate(context, uri);
        CookieWrapper cookiewrapper = new CookieWrapper();
        cookiewrapper.listener = onquerycompletelistener;
        cookiewrapper.cookie = obj;
        cookiewrapper.event = 1;
        callerinfoasyncquery.mHandler.startQuery(i, cookiewrapper, uri, null, null, null, null);
        return callerinfoasyncquery;
    }

    public static CallerInfoAsyncQuery startQuery(int i, Context context, String s, OnQueryCompleteListener onquerycompletelistener, Object obj) {
        Uri uri;
        String s1;
        String as[];
        CallerInfoAsyncQuery callerinfoasyncquery;
        CookieWrapper cookiewrapper;
        if(PhoneNumberUtils.isUriNumber(s)) {
            uri = android.provider.ContactsContract.Data.CONTENT_URI;
            s1 = "upper(data1)=? AND mimetype='vnd.android.cursor.item/sip_address'";
            as = new String[1];
            as[0] = s.toUpperCase();
        } else {
            uri = Uri.withAppendedPath(android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(getPhoneNumber(s)));
            s1 = null;
            as = null;
        }
        callerinfoasyncquery = new CallerInfoAsyncQuery();
        callerinfoasyncquery.allocate(context, uri);
        cookiewrapper = new CookieWrapper();
        cookiewrapper.listener = onquerycompletelistener;
        cookiewrapper.cookie = obj;
        cookiewrapper.number = s;
        if(PhoneNumberUtils.isLocalEmergencyNumber(s, context))
            cookiewrapper.event = 4;
        else
        if(PhoneNumberUtils.isVoiceMailNumber(s))
            cookiewrapper.event = 5;
        else
            cookiewrapper.event = 1;
        callerinfoasyncquery.mHandler.startQuery(i, cookiewrapper, uri, null, s1, as, null);
        return callerinfoasyncquery;
    }

    public void addQueryListener(int i, OnQueryCompleteListener onquerycompletelistener, Object obj) {
        CookieWrapper cookiewrapper = new CookieWrapper();
        cookiewrapper.listener = onquerycompletelistener;
        cookiewrapper.cookie = obj;
        cookiewrapper.event = 2;
        mHandler.startQuery(i, cookiewrapper, null, null, null, null, null);
    }

    private static final boolean DBG = false;
    private static final boolean ENABLE_UNKNOWN_NUMBER_GEO_DESCRIPTION = true;
    private static final int EVENT_ADD_LISTENER = 2;
    private static final int EVENT_EMERGENCY_NUMBER = 4;
    private static final int EVENT_END_OF_QUEUE = 3;
    private static final int EVENT_NEW_QUERY = 1;
    private static final int EVENT_VOICEMAIL_NUMBER = 5;
    private static final String LOG_TAG = "CallerInfoAsyncQuery";
    private CallerInfoAsyncQueryHandler mHandler;

}
