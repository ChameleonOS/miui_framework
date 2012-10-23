// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.os.*;
import android.util.Log;
import java.util.HashMap;

// Referenced classes of package android.location:
//            ICountryDetector, CountryListener, Country

public class CountryDetector {
    private static final class ListenerTransport extends ICountryListener.Stub {

        public void onCountryDetected(final Country country) {
            mHandler.post(new Runnable() {

                public void run() {
                    mListener.onCountryDetected(country);
                }

                final ListenerTransport this$0;
                final Country val$country;

                 {
                    this$0 = ListenerTransport.this;
                    country = country1;
                    super();
                }
            });
        }

        private final Handler mHandler;
        private final CountryListener mListener;


        public ListenerTransport(CountryListener countrylistener, Looper looper) {
            mListener = countrylistener;
            if(looper != null)
                mHandler = new Handler(looper);
            else
                mHandler = new Handler();
        }
    }


    public CountryDetector(ICountryDetector icountrydetector) {
        mService = icountrydetector;
    }

    public void addCountryListener(CountryListener countrylistener, Looper looper) {
        HashMap hashmap = mListeners;
        hashmap;
        JVM INSTR monitorenter ;
        ListenerTransport listenertransport;
        if(mListeners.containsKey(countrylistener))
            break MISSING_BLOCK_LABEL_51;
        listenertransport = new ListenerTransport(countrylistener, looper);
        try {
            mService.addCountryListener(listenertransport);
            mListeners.put(countrylistener, listenertransport);
        }
        catch(RemoteException remoteexception) {
            Log.e("CountryDetector", "addCountryListener: RemoteException", remoteexception);
        }
        hashmap;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public Country detectCountry() {
        Country country1 = mService.detectCountry();
        Country country = country1;
_L2:
        return country;
        RemoteException remoteexception;
        remoteexception;
        Log.e("CountryDetector", "detectCountry: RemoteException", remoteexception);
        country = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void removeCountryListener(CountryListener countrylistener) {
        HashMap hashmap = mListeners;
        hashmap;
        JVM INSTR monitorenter ;
        ListenerTransport listenertransport = (ListenerTransport)mListeners.get(countrylistener);
        Exception exception;
        if(listenertransport != null)
            try {
                mListeners.remove(countrylistener);
                mService.removeCountryListener(listenertransport);
            }
            catch(RemoteException remoteexception) {
                Log.e("CountryDetector", "removeCountryListener: RemoteException", remoteexception);
            }
            finally {
                hashmap;
            }
        hashmap;
        JVM INSTR monitorexit ;
        return;
        throw exception;
    }

    private static final String TAG = "CountryDetector";
    private final HashMap mListeners = new HashMap();
    private final ICountryDetector mService;
}
