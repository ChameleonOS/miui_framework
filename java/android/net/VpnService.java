// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.*;
import com.android.internal.net.VpnConfig;
import java.io.FileDescriptor;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.net:
//            IConnectivityManager

public class VpnService extends Service {
    public class Builder {

        private void check(InetAddress inetaddress, int i) {
            if(inetaddress.isLoopbackAddress())
                throw new IllegalArgumentException("Bad address");
            if(inetaddress instanceof Inet4Address) {
                if(i < 0 || i > 32)
                    throw new IllegalArgumentException("Bad prefixLength");
            } else
            if(inetaddress instanceof Inet6Address) {
                if(i < 0 || i > 128)
                    throw new IllegalArgumentException("Bad prefixLength");
            } else {
                throw new IllegalArgumentException("Unsupported family");
            }
        }

        public Builder addAddress(String s, int i) {
            return addAddress(InetAddress.parseNumericAddress(s), i);
        }

        public Builder addAddress(InetAddress inetaddress, int i) {
            check(inetaddress, i);
            if(inetaddress.isAnyLocalAddress()) {
                throw new IllegalArgumentException("Bad address");
            } else {
                StringBuilder stringbuilder = mAddresses;
                Object aobj[] = new Object[2];
                aobj[0] = inetaddress.getHostAddress();
                aobj[1] = Integer.valueOf(i);
                stringbuilder.append(String.format(" %s/%d", aobj));
                return this;
            }
        }

        public Builder addDnsServer(String s) {
            return addDnsServer(InetAddress.parseNumericAddress(s));
        }

        public Builder addDnsServer(InetAddress inetaddress) {
            if(inetaddress.isLoopbackAddress() || inetaddress.isAnyLocalAddress())
                throw new IllegalArgumentException("Bad address");
            if(mConfig.dnsServers == null)
                mConfig.dnsServers = new ArrayList();
            mConfig.dnsServers.add(inetaddress.getHostAddress());
            return this;
        }

        public Builder addRoute(String s, int i) {
            return addRoute(InetAddress.parseNumericAddress(s), i);
        }

        public Builder addRoute(InetAddress inetaddress, int i) {
            check(inetaddress, i);
            int j = i / 8;
            byte abyte0[] = inetaddress.getAddress();
            if(j < abyte0.length) {
                abyte0[j] = (byte)(abyte0[j] << i % 8);
                for(; j < abyte0.length; j++)
                    if(abyte0[j] != 0)
                        throw new IllegalArgumentException("Bad address");

            }
            StringBuilder stringbuilder = mRoutes;
            Object aobj[] = new Object[2];
            aobj[0] = inetaddress.getHostAddress();
            aobj[1] = Integer.valueOf(i);
            stringbuilder.append(String.format(" %s/%d", aobj));
            return this;
        }

        public Builder addSearchDomain(String s) {
            if(mConfig.searchDomains == null)
                mConfig.searchDomains = new ArrayList();
            mConfig.searchDomains.add(s);
            return this;
        }

        public ParcelFileDescriptor establish() {
            mConfig.addresses = mAddresses.toString();
            mConfig.routes = mRoutes.toString();
            ParcelFileDescriptor parcelfiledescriptor;
            try {
                parcelfiledescriptor = VpnService.getService().establishVpn(mConfig);
            }
            catch(RemoteException remoteexception) {
                throw new IllegalStateException(remoteexception);
            }
            return parcelfiledescriptor;
        }

        public Builder setConfigureIntent(PendingIntent pendingintent) {
            mConfig.configureIntent = pendingintent;
            return this;
        }

        public Builder setMtu(int i) {
            if(i <= 0) {
                throw new IllegalArgumentException("Bad mtu");
            } else {
                mConfig.mtu = i;
                return this;
            }
        }

        public Builder setSession(String s) {
            mConfig.session = s;
            return this;
        }

        private final StringBuilder mAddresses = new StringBuilder();
        private final VpnConfig mConfig = new VpnConfig();
        private final StringBuilder mRoutes = new StringBuilder();
        final VpnService this$0;

        public Builder() {
            this$0 = VpnService.this;
            super();
            mConfig.user = getClass().getName();
        }
    }

    private class Callback extends Binder {

        protected boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) {
            boolean flag;
            if(i == 0xffffff) {
                onRevoke();
                flag = true;
            } else {
                flag = false;
            }
            return flag;
        }

        final VpnService this$0;

        private Callback() {
            this$0 = VpnService.this;
            super();
        }

    }


    public VpnService() {
    }

    private static IConnectivityManager getService() {
        return IConnectivityManager.Stub.asInterface(ServiceManager.getService("connectivity"));
    }

    public static Intent prepare(Context context) {
        Intent intent = null;
        boolean flag = getService().prepareVpn(context.getPackageName(), null);
        if(!flag) goto _L2; else goto _L1
_L1:
        return intent;
        RemoteException remoteexception;
        remoteexception;
_L2:
        intent = VpnConfig.getIntentForConfirmation();
        if(true) goto _L1; else goto _L3
_L3:
    }

    public IBinder onBind(Intent intent) {
        Callback callback;
        if(intent != null && "android.net.VpnService".equals(intent.getAction()))
            callback = new Callback();
        else
            callback = null;
        return callback;
    }

    public void onRevoke() {
        stopSelf();
    }

    public boolean protect(int i) {
        boolean flag;
        ParcelFileDescriptor parcelfiledescriptor = null;
        Exception exception3;
        boolean flag1;
        try {
            parcelfiledescriptor = ParcelFileDescriptor.fromFd(i);
            flag1 = getService().protectVpn(parcelfiledescriptor);
        }
        catch(Exception exception2) {
            flag = false;
            parcelfiledescriptor.close();
            break MISSING_BLOCK_LABEL_58;
        }
        finally {
            try {
                parcelfiledescriptor.close();
            }
            catch(Exception exception1) { }
            throw exception;
        }
        flag = flag1;
        parcelfiledescriptor.close();
        break MISSING_BLOCK_LABEL_58;
        exception3;
        return flag;
    }

    public boolean protect(DatagramSocket datagramsocket) {
        return protect(datagramsocket.getFileDescriptor$().getInt$());
    }

    public boolean protect(Socket socket) {
        return protect(socket.getFileDescriptor$().getInt$());
    }

    public static final String SERVICE_INTERFACE = "android.net.VpnService";

}
