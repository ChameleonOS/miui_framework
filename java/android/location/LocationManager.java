// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.app.PendingIntent;
import android.os.*;
import android.util.Log;
import com.android.internal.location.DummyLocationProvider;
import java.util.*;

// Referenced classes of package android.location:
//            GpsStatus, ILocationManager, Criteria, LocationListener, 
//            LocationProvider, Location

public class LocationManager {
    private class GpsStatusListenerTransport extends IGpsStatusListener.Stub {
        private class Nmea {

            String mNmea;
            long mTimestamp;
            final GpsStatusListenerTransport this$1;

            Nmea(long l, String s) {
                this$1 = GpsStatusListenerTransport.this;
                super();
                mTimestamp = l;
                mNmea = s;
            }
        }


        public void onFirstFix(int i) {
            if(mListener != null) {
                mGpsStatus.setTimeToFirstFix(i);
                Message message = Message.obtain();
                message.what = 3;
                mGpsHandler.sendMessage(message);
            }
        }

        public void onGpsStarted() {
            if(mListener != null) {
                Message message = Message.obtain();
                message.what = 1;
                mGpsHandler.sendMessage(message);
            }
        }

        public void onGpsStopped() {
            if(mListener != null) {
                Message message = Message.obtain();
                message.what = 2;
                mGpsHandler.sendMessage(message);
            }
        }

        public void onNmeaReceived(long l, String s) {
            if(mNmeaListener != null) {
                synchronized(mNmeaBuffer) {
                    mNmeaBuffer.add(new Nmea(l, s));
                }
                Message message = Message.obtain();
                message.what = 1000;
                mGpsHandler.removeMessages(1000);
                mGpsHandler.sendMessage(message);
            }
            return;
            exception;
            arraylist;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void onSvStatusChanged(int i, int ai[], float af[], float af1[], float af2[], int j, int k, 
                int l) {
            if(mListener != null) {
                mGpsStatus.setStatus(i, ai, af, af1, af2, j, k, l);
                Message message = Message.obtain();
                message.what = 4;
                mGpsHandler.removeMessages(4);
                mGpsHandler.sendMessage(message);
            }
        }

        private static final int NMEA_RECEIVED = 1000;
        private final Handler mGpsHandler;
        private final GpsStatus.Listener mListener;
        private ArrayList mNmeaBuffer;
        private final GpsStatus.NmeaListener mNmeaListener;
        final LocationManager this$0;




        GpsStatusListenerTransport(GpsStatus.Listener listener) {
            this$0 = LocationManager.this;
            super();
            mGpsHandler = new Handler() {

                public void handleMessage(Message message) {
                    if(message.what != 1000)
                        break MISSING_BLOCK_LABEL_113;
                    ArrayList arraylist = mNmeaBuffer;
                    arraylist;
                    JVM INSTR monitorenter ;
                    int i = mNmeaBuffer.size();
                    for(int j = 0; j < i; j++) {
                        Nmea nmea = (Nmea)mNmeaBuffer.get(j);
                        mNmeaListener.onNmeaReceived(nmea.mTimestamp, nmea.mNmea);
                    }

                    mNmeaBuffer.clear();
                    break MISSING_BLOCK_LABEL_152;
                    GpsStatus gpsstatus = mGpsStatus;
                    gpsstatus;
                    JVM INSTR monitorenter ;
                    mListener.onGpsStatusChanged(message.what);
                }

                final GpsStatusListenerTransport this$1;

                 {
                    this$1 = GpsStatusListenerTransport.this;
                    super();
                }
            };
            mListener = listener;
            mNmeaListener = null;
        }

        GpsStatusListenerTransport(GpsStatus.NmeaListener nmealistener) {
            this$0 = LocationManager.this;
            super();
            mGpsHandler = new _cls1();
            mNmeaListener = nmealistener;
            mListener = null;
            mNmeaBuffer = new ArrayList();
        }
    }

    private class ListenerTransport extends ILocationListener.Stub {

        private void _handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 1 4: default 36
        //                       1 50
        //                       2 80
        //                       3 134
        //                       4 153;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            mService.locationCallbackFinished(this);
_L6:
            return;
_L2:
            Location location = new Location((Location)message.obj);
            mListener.onLocationChanged(location);
              goto _L1
_L3:
            Bundle bundle = (Bundle)message.obj;
            String s = bundle.getString("provider");
            int i = bundle.getInt("status");
            Bundle bundle1 = bundle.getBundle("extras");
            mListener.onStatusChanged(s, i, bundle1);
              goto _L1
_L4:
            mListener.onProviderEnabled((String)message.obj);
              goto _L1
_L5:
            mListener.onProviderDisabled((String)message.obj);
              goto _L1
            RemoteException remoteexception;
            remoteexception;
            Log.e("LocationManager", "locationCallbackFinished: RemoteException", remoteexception);
              goto _L6
        }

        public void onLocationChanged(Location location) {
            Message message = Message.obtain();
            message.what = 1;
            message.obj = location;
            mListenerHandler.sendMessage(message);
        }

        public void onProviderDisabled(String s) {
            Message message = Message.obtain();
            message.what = 4;
            message.obj = s;
            mListenerHandler.sendMessage(message);
        }

        public void onProviderEnabled(String s) {
            Message message = Message.obtain();
            message.what = 3;
            message.obj = s;
            mListenerHandler.sendMessage(message);
        }

        public void onStatusChanged(String s, int i, Bundle bundle) {
            Message message = Message.obtain();
            message.what = 2;
            Bundle bundle1 = new Bundle();
            bundle1.putString("provider", s);
            bundle1.putInt("status", i);
            if(bundle != null)
                bundle1.putBundle("extras", bundle);
            message.obj = bundle1;
            mListenerHandler.sendMessage(message);
        }

        private static final int TYPE_LOCATION_CHANGED = 1;
        private static final int TYPE_PROVIDER_DISABLED = 4;
        private static final int TYPE_PROVIDER_ENABLED = 3;
        private static final int TYPE_STATUS_CHANGED = 2;
        private LocationListener mListener;
        private final Handler mListenerHandler;
        final LocationManager this$0;


        ListenerTransport(LocationListener locationlistener, final Looper final_looper) {
            this$0 = LocationManager.this;
            super();
            mListener = locationlistener;
            if(final_looper == null)
                mListenerHandler = new Handler() {

                    public void handleMessage(Message message) {
                        _handleMessage(message);
                    }

                    final ListenerTransport this$1;
                    final LocationManager val$this$0;


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
                };
            else
                mListenerHandler = new Handler(LocationManager.this) {

                    public void handleMessage(Message message) {
                        _handleMessage(message);
                    }

                    final ListenerTransport this$1;
                    final LocationManager val$this$0;

                 {
                    this$1 = ListenerTransport.this;
                    this$0 = locationmanager;
                    super(final_looper);
                }
                };
        }
    }


    public LocationManager(ILocationManager ilocationmanager) {
        mListeners = new HashMap();
        mService = ilocationmanager;
    }

    private void _requestLocationUpdates(String s, Criteria criteria, long l, float f, boolean flag, PendingIntent pendingintent) {
        if(l < 0L)
            l = 0L;
        if(f < 0.0F)
            f = 0.0F;
        mService.requestLocationUpdatesPI(s, criteria, l, f, flag, pendingintent);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "requestLocationUpdates: RemoteException", remoteexception);
          goto _L1
    }

    private void _requestLocationUpdates(String s, Criteria criteria, long l, float f, boolean flag, LocationListener locationlistener, 
            Looper looper) {
        if(l < 0L)
            l = 0L;
        if(f < 0.0F)
            f = 0.0F;
        HashMap hashmap = mListeners;
        hashmap;
        JVM INSTR monitorenter ;
        ListenerTransport listenertransport = (ListenerTransport)mListeners.get(locationlistener);
        if(listenertransport == null)
            listenertransport = new ListenerTransport(locationlistener, looper);
        mListeners.put(locationlistener, listenertransport);
        mService.requestLocationUpdates(s, criteria, l, f, flag, listenertransport);
        break MISSING_BLOCK_LABEL_116;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "requestLocationUpdates: DeadObjectException", remoteexception);
    }

    private LocationProvider createProvider(String s, Bundle bundle) {
        DummyLocationProvider dummylocationprovider = new DummyLocationProvider(s, mService);
        dummylocationprovider.setRequiresNetwork(bundle.getBoolean("network"));
        dummylocationprovider.setRequiresSatellite(bundle.getBoolean("satellite"));
        dummylocationprovider.setRequiresCell(bundle.getBoolean("cell"));
        dummylocationprovider.setHasMonetaryCost(bundle.getBoolean("cost"));
        dummylocationprovider.setSupportsAltitude(bundle.getBoolean("altitude"));
        dummylocationprovider.setSupportsSpeed(bundle.getBoolean("speed"));
        dummylocationprovider.setSupportsBearing(bundle.getBoolean("bearing"));
        dummylocationprovider.setPowerRequirement(bundle.getInt("power"));
        dummylocationprovider.setAccuracy(bundle.getInt("accuracy"));
        return dummylocationprovider;
    }

    public boolean addGpsStatusListener(GpsStatus.Listener listener) {
        if(mGpsStatusListeners.get(listener) == null) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        try {
            GpsStatusListenerTransport gpsstatuslistenertransport = new GpsStatusListenerTransport(listener);
            flag = mService.addGpsStatusListener(gpsstatuslistenertransport);
            if(flag)
                mGpsStatusListeners.put(listener, gpsstatuslistenertransport);
        }
        catch(RemoteException remoteexception) {
            Log.e("LocationManager", "RemoteException in registerGpsStatusListener: ", remoteexception);
            flag = false;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean addNmeaListener(GpsStatus.NmeaListener nmealistener) {
        if(mNmeaListeners.get(nmealistener) == null) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        try {
            GpsStatusListenerTransport gpsstatuslistenertransport = new GpsStatusListenerTransport(nmealistener);
            flag = mService.addGpsStatusListener(gpsstatuslistenertransport);
            if(flag)
                mNmeaListeners.put(nmealistener, gpsstatuslistenertransport);
        }
        catch(RemoteException remoteexception) {
            Log.e("LocationManager", "RemoteException in registerGpsStatusListener: ", remoteexception);
            flag = false;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void addProximityAlert(double d, double d1, float f, long l, 
            PendingIntent pendingintent) {
        mService.addProximityAlert(d, d1, f, l, pendingintent);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "addProximityAlert: RemoteException", remoteexception);
          goto _L1
    }

    public void addTestProvider(String s, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, 
            boolean flag6, int i, int j) {
        mService.addTestProvider(s, flag, flag1, flag2, flag3, flag4, flag5, flag6, i, j);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "addTestProvider: RemoteException", remoteexception);
          goto _L1
    }

    public void clearTestProviderEnabled(String s) {
        mService.clearTestProviderEnabled(s);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "clearTestProviderEnabled: RemoteException", remoteexception);
          goto _L1
    }

    public void clearTestProviderLocation(String s) {
        mService.clearTestProviderLocation(s);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "clearTestProviderLocation: RemoteException", remoteexception);
          goto _L1
    }

    public void clearTestProviderStatus(String s) {
        mService.clearTestProviderStatus(s);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "clearTestProviderStatus: RemoteException", remoteexception);
          goto _L1
    }

    public List getAllProviders() {
        List list1 = mService.getAllProviders();
        List list = list1;
_L2:
        return list;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "getAllProviders: RemoteException", remoteexception);
        list = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getBestProvider(Criteria criteria, boolean flag) {
        if(criteria == null)
            throw new IllegalArgumentException("criteria==null");
        String s1 = mService.getBestProvider(criteria, flag);
        String s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "getBestProvider: RemoteException", remoteexception);
        s = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public GpsStatus getGpsStatus(GpsStatus gpsstatus) {
        if(gpsstatus == null)
            gpsstatus = new GpsStatus();
        gpsstatus.setStatus(mGpsStatus);
        return gpsstatus;
    }

    public Location getLastKnownLocation(String s) {
        if(s == null)
            throw new IllegalArgumentException("provider==null");
        Location location1 = mService.getLastKnownLocation(s);
        Location location = location1;
_L2:
        return location;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "getLastKnowLocation: RemoteException", remoteexception);
        location = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public LocationProvider getProvider(String s) {
        LocationProvider locationprovider;
        locationprovider = null;
        if(s == null)
            throw new IllegalArgumentException("name==null");
        LocationProvider locationprovider1;
        Bundle bundle = mService.getProviderInfo(s);
        if(bundle == null)
            break MISSING_BLOCK_LABEL_63;
        locationprovider1 = createProvider(s, bundle);
        locationprovider = locationprovider1;
        break MISSING_BLOCK_LABEL_63;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "getProvider: RemoteException", remoteexception);
        return locationprovider;
    }

    public List getProviders(Criteria criteria, boolean flag) {
        if(criteria == null)
            throw new IllegalArgumentException("criteria==null");
        List list1 = mService.getProviders(criteria, flag);
        List list = list1;
_L2:
        return list;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "getProviders: RemoteException", remoteexception);
        list = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public List getProviders(boolean flag) {
        List list = null;
        List list1 = mService.getProviders(null, flag);
        list = list1;
_L2:
        return list;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "getProviders: RemoteException", remoteexception);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isProviderEnabled(String s) {
        if(s == null)
            throw new IllegalArgumentException("provider==null");
        boolean flag1 = mService.isProviderEnabled(s);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "isProviderEnabled: RemoteException", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void removeGpsStatusListener(GpsStatus.Listener listener) {
        GpsStatusListenerTransport gpsstatuslistenertransport = (GpsStatusListenerTransport)mGpsStatusListeners.remove(listener);
        if(gpsstatuslistenertransport != null)
            mService.removeGpsStatusListener(gpsstatuslistenertransport);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "RemoteException in unregisterGpsStatusListener: ", remoteexception);
          goto _L1
    }

    public void removeNmeaListener(GpsStatus.NmeaListener nmealistener) {
        GpsStatusListenerTransport gpsstatuslistenertransport = (GpsStatusListenerTransport)mNmeaListeners.remove(nmealistener);
        if(gpsstatuslistenertransport != null)
            mService.removeGpsStatusListener(gpsstatuslistenertransport);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "RemoteException in unregisterGpsStatusListener: ", remoteexception);
          goto _L1
    }

    public void removeProximityAlert(PendingIntent pendingintent) {
        mService.removeProximityAlert(pendingintent);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "removeProximityAlert: RemoteException", remoteexception);
          goto _L1
    }

    public void removeTestProvider(String s) {
        mService.removeTestProvider(s);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "removeTestProvider: RemoteException", remoteexception);
          goto _L1
    }

    public void removeUpdates(PendingIntent pendingintent) {
        if(pendingintent == null)
            throw new IllegalArgumentException("intent==null");
        mService.removeUpdatesPI(pendingintent);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "removeUpdates: RemoteException", remoteexception);
          goto _L1
    }

    public void removeUpdates(LocationListener locationlistener) {
        if(locationlistener == null)
            throw new IllegalArgumentException("listener==null");
        ListenerTransport listenertransport = (ListenerTransport)mListeners.remove(locationlistener);
        if(listenertransport != null)
            mService.removeUpdates(listenertransport);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "removeUpdates: DeadObjectException", remoteexception);
          goto _L1
    }

    public void requestLocationUpdates(long l, float f, Criteria criteria, PendingIntent pendingintent) {
        if(criteria == null)
            throw new IllegalArgumentException("criteria==null");
        if(pendingintent == null) {
            throw new IllegalArgumentException("intent==null");
        } else {
            _requestLocationUpdates(null, criteria, l, f, false, pendingintent);
            return;
        }
    }

    public void requestLocationUpdates(long l, float f, Criteria criteria, LocationListener locationlistener, Looper looper) {
        if(criteria == null)
            throw new IllegalArgumentException("criteria==null");
        if(locationlistener == null) {
            throw new IllegalArgumentException("listener==null");
        } else {
            _requestLocationUpdates(null, criteria, l, f, false, locationlistener, looper);
            return;
        }
    }

    public void requestLocationUpdates(String s, long l, float f, PendingIntent pendingintent) {
        if(s == null)
            throw new IllegalArgumentException("provider==null");
        if(pendingintent == null) {
            throw new IllegalArgumentException("intent==null");
        } else {
            _requestLocationUpdates(s, null, l, f, false, pendingintent);
            return;
        }
    }

    public void requestLocationUpdates(String s, long l, float f, LocationListener locationlistener) {
        if(s == null)
            throw new IllegalArgumentException("provider==null");
        if(locationlistener == null) {
            throw new IllegalArgumentException("listener==null");
        } else {
            _requestLocationUpdates(s, null, l, f, false, locationlistener, null);
            return;
        }
    }

    public void requestLocationUpdates(String s, long l, float f, LocationListener locationlistener, Looper looper) {
        if(s == null)
            throw new IllegalArgumentException("provider==null");
        if(locationlistener == null) {
            throw new IllegalArgumentException("listener==null");
        } else {
            _requestLocationUpdates(s, null, l, f, false, locationlistener, looper);
            return;
        }
    }

    public void requestSingleUpdate(Criteria criteria, PendingIntent pendingintent) {
        if(criteria == null)
            throw new IllegalArgumentException("criteria==null");
        if(pendingintent == null) {
            throw new IllegalArgumentException("intent==null");
        } else {
            _requestLocationUpdates(null, criteria, 0L, 0.0F, true, pendingintent);
            return;
        }
    }

    public void requestSingleUpdate(Criteria criteria, LocationListener locationlistener, Looper looper) {
        if(criteria == null)
            throw new IllegalArgumentException("criteria==null");
        if(locationlistener == null) {
            throw new IllegalArgumentException("listener==null");
        } else {
            _requestLocationUpdates(null, criteria, 0L, 0.0F, true, locationlistener, looper);
            return;
        }
    }

    public void requestSingleUpdate(String s, PendingIntent pendingintent) {
        if(s == null)
            throw new IllegalArgumentException("provider==null");
        if(pendingintent == null) {
            throw new IllegalArgumentException("intent==null");
        } else {
            _requestLocationUpdates(s, null, 0L, 0.0F, true, pendingintent);
            return;
        }
    }

    public void requestSingleUpdate(String s, LocationListener locationlistener, Looper looper) {
        if(s == null)
            throw new IllegalArgumentException("provider==null");
        if(locationlistener == null) {
            throw new IllegalArgumentException("listener==null");
        } else {
            _requestLocationUpdates(s, null, 0L, 0.0F, true, locationlistener, looper);
            return;
        }
    }

    public boolean sendExtraCommand(String s, String s1, Bundle bundle) {
        boolean flag1 = mService.sendExtraCommand(s, s1, bundle);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "RemoteException in sendExtraCommand: ", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean sendNiResponse(int i, int j) {
        boolean flag1 = mService.sendNiResponse(i, j);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "RemoteException in sendNiResponse: ", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setTestProviderEnabled(String s, boolean flag) {
        mService.setTestProviderEnabled(s, flag);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "setTestProviderEnabled: RemoteException", remoteexception);
          goto _L1
    }

    public void setTestProviderLocation(String s, Location location) {
        mService.setTestProviderLocation(s, location);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "setTestProviderLocation: RemoteException", remoteexception);
          goto _L1
    }

    public void setTestProviderStatus(String s, int i, Bundle bundle, long l) {
        mService.setTestProviderStatus(s, i, bundle, l);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationManager", "setTestProviderStatus: RemoteException", remoteexception);
          goto _L1
    }

    public static final String EXTRA_GPS_ENABLED = "enabled";
    public static final String GPS_ENABLED_CHANGE_ACTION = "android.location.GPS_ENABLED_CHANGE";
    public static final String GPS_FIX_CHANGE_ACTION = "android.location.GPS_FIX_CHANGE";
    public static final String GPS_PROVIDER = "gps";
    public static final String KEY_LOCATION_CHANGED = "location";
    public static final String KEY_PROVIDER_ENABLED = "providerEnabled";
    public static final String KEY_PROXIMITY_ENTERING = "entering";
    public static final String KEY_STATUS_CHANGED = "status";
    public static final String NETWORK_PROVIDER = "network";
    public static final String PASSIVE_PROVIDER = "passive";
    public static final String PROVIDERS_CHANGED_ACTION = "android.location.PROVIDERS_CHANGED";
    private static final String TAG = "LocationManager";
    private final GpsStatus mGpsStatus = new GpsStatus();
    private final HashMap mGpsStatusListeners = new HashMap();
    private HashMap mListeners;
    private final HashMap mNmeaListeners = new HashMap();
    private ILocationManager mService;


}
