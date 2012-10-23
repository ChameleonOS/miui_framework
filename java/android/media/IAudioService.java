// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.app.PendingIntent;
import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.os.*;
import android.view.KeyEvent;

// Referenced classes of package android.media:
//            IAudioFocusDispatcher, IRingtonePlayer, IRemoteControlClient, IRemoteControlDisplay, 
//            IRemoteVolumeObserver, IAudioRoutesObserver, AudioRoutesInfo

public interface IAudioService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IAudioService {
        private static class Proxy
            implements IAudioService {

            public int abandonAudioFocus(IAudioFocusDispatcher iaudiofocusdispatcher, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(iaudiofocusdispatcher == null)
                    break MISSING_BLOCK_LABEL_78;
                ibinder = iaudiofocusdispatcher.asBinder();
_L1:
                int i;
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                mRemote.transact(39, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void adjustLocalOrRemoteStreamVolume(int i, int j) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void adjustMasterVolume(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void adjustStreamVolume(int i, int j, int k) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void adjustSuggestedStreamVolume(int i, int j, int k) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void adjustVolume(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public IBinder asBinder() {
                return mRemote;
            }

            public void dispatchMediaKeyEvent(KeyEvent keyevent) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(keyevent == null)
                    break MISSING_BLOCK_LABEL_45;
                parcel.writeInt(1);
                keyevent.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(41, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void dispatchMediaKeyEventUnderWakelock(KeyEvent keyevent) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(keyevent == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                keyevent.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(42, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void forceVolumeControlStream(int i, IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(58, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.media.IAudioService";
            }

            public int getLastAudibleMasterVolume() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(19, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getLastAudibleStreamVolume(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                mRemote.transact(18, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getMasterMaxVolume() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(17, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getMasterStreamType() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(61, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getMasterVolume() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(15, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getMode() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(26, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getRemoteStreamMaxVolume() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(53, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getRemoteStreamVolume() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(54, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getRingerMode() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(21, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public IRingtonePlayer getRingtonePlayer() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IRingtonePlayer iringtoneplayer;
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(60, parcel, parcel1, 0);
                parcel1.readException();
                iringtoneplayer = IRingtonePlayer.Stub.asInterface(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                return iringtoneplayer;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getStreamMaxVolume(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                mRemote.transact(16, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getStreamVolume(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                mRemote.transact(14, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getVibrateSetting(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                mRemote.transact(23, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isBluetoothA2dpOn() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(37, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isBluetoothScoOn() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(35, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isMasterMute() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isSpeakerphoneOn() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(33, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isStreamMute(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                mRemote.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean loadSoundEffects() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(29, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void playSoundEffect(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                mRemote.transact(27, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void playSoundEffectVolume(int i, float f) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                parcel.writeFloat(f);
                mRemote.transact(28, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void registerMediaButtonEventReceiverForCalls(ComponentName componentname) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_45;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(45, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void registerMediaButtonIntent(PendingIntent pendingintent, ComponentName componentname) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(pendingintent == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L3:
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_77;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(43, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public int registerRemoteControlClient(PendingIntent pendingintent, IRemoteControlClient iremotecontrolclient, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(pendingintent == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L3:
                IBinder ibinder;
                if(iremotecontrolclient == null)
                    break MISSING_BLOCK_LABEL_125;
                ibinder = iremotecontrolclient.asBinder();
_L4:
                int i;
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                mRemote.transact(47, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                ibinder = null;
                  goto _L4
            }

            public void registerRemoteControlDisplay(IRemoteControlDisplay iremotecontroldisplay) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(iremotecontroldisplay != null)
                    ibinder = iremotecontroldisplay.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(49, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void registerRemoteVolumeObserverForRcc(int i, IRemoteVolumeObserver iremotevolumeobserver) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                if(iremotevolumeobserver != null)
                    ibinder = iremotevolumeobserver.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(55, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void reloadAudioSettings() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(31, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void remoteControlDisplayUsesBitmapSize(IRemoteControlDisplay iremotecontroldisplay, int i, int j) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(iremotecontroldisplay != null)
                    ibinder = iremotecontroldisplay.asBinder();
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(51, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public int requestAudioFocus(int i, int j, IBinder ibinder, IAudioFocusDispatcher iaudiofocusdispatcher, String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder1;
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeStrongBinder(ibinder);
                if(iaudiofocusdispatcher == null)
                    break MISSING_BLOCK_LABEL_112;
                ibinder1 = iaudiofocusdispatcher.asBinder();
_L1:
                int k;
                parcel.writeStrongBinder(ibinder1);
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(38, parcel, parcel1, 0);
                parcel1.readException();
                k = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return k;
                ibinder1 = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int setBluetoothA2dpDeviceConnectionState(BluetoothDevice bluetoothdevice, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_75;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(63, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setBluetoothA2dpOn(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(36, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setBluetoothScoOn(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(34, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setMasterMute(boolean flag, int i, IBinder ibinder) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(flag)
                    j = 1;
                parcel.writeInt(j);
                parcel.writeInt(i);
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setMasterVolume(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setMode(int i, IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(25, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setPlaybackInfoForRcc(int i, int j, int k) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                mRemote.transact(52, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setRemoteStreamVolume(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                mRemote.transact(7, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setRingerMode(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                mRemote.transact(20, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setRingtonePlayer(IRingtonePlayer iringtoneplayer) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(iringtoneplayer == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = iringtoneplayer.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(59, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setSpeakerphoneOn(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(32, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setStreamMute(int i, boolean flag, IBinder ibinder) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                if(flag)
                    j = 1;
                parcel.writeInt(j);
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setStreamSolo(int i, boolean flag, IBinder ibinder) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                if(flag)
                    j = 1;
                parcel.writeInt(j);
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setStreamVolume(int i, int j, int k) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setVibrateSetting(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(22, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setWiredDeviceConnectionState(int i, int j, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeString(s);
                mRemote.transact(62, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean shouldVibrate(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeInt(i);
                mRemote.transact(24, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void startBluetoothSco(IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(56, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public AudioRoutesInfo startWatchingRoutes(IAudioRoutesObserver iaudioroutesobserver) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(iaudioroutesobserver == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iaudioroutesobserver.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(64, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L4; else goto _L3
_L3:
                AudioRoutesInfo audioroutesinfo = (AudioRoutesInfo)AudioRoutesInfo.CREATOR.createFromParcel(parcel1);
_L6:
                parcel1.recycle();
                parcel.recycle();
                return audioroutesinfo;
_L2:
                ibinder = null;
                  goto _L5
_L4:
                audioroutesinfo = null;
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public void stopBluetoothSco(IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(57, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void unloadSoundEffects() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(30, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void unregisterAudioFocusClient(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                parcel.writeString(s);
                mRemote.transact(40, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void unregisterMediaButtonEventReceiverForCalls() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                mRemote.transact(46, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void unregisterMediaButtonIntent(PendingIntent pendingintent, ComponentName componentname) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(pendingintent == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L3:
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_77;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(44, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public void unregisterRemoteControlClient(PendingIntent pendingintent, IRemoteControlClient iremotecontrolclient) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(pendingintent == null)
                    break MISSING_BLOCK_LABEL_70;
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L1:
                if(iremotecontrolclient != null)
                    ibinder = iremotecontrolclient.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(48, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void unregisterRemoteControlDisplay(IRemoteControlDisplay iremotecontroldisplay) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioService");
                if(iremotecontroldisplay != null)
                    ibinder = iremotecontroldisplay.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(50, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IAudioService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.media.IAudioService");
                if(iinterface != null && (iinterface instanceof IAudioService))
                    obj = (IAudioService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IAudioService) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag;
            boolean flag1;
            flag = false;
            flag1 = true;
            i;
            JVM INSTR lookupswitch 65: default 536
        //                       1: 559
        //                       2: 584
        //                       3: 605
        //                       4: 634
        //                       5: 663
        //                       6: 688
        //                       7: 717
        //                       8: 734
        //                       9: 759
        //                       10: 801
        //                       11: 843
        //                       12: 881
        //                       13: 925
        //                       14: 959
        //                       15: 988
        //                       16: 1013
        //                       17: 1042
        //                       18: 1067
        //                       19: 1096
        //                       20: 1121
        //                       21: 1142
        //                       22: 1167
        //                       23: 1192
        //                       24: 1221
        //                       25: 1259
        //                       26: 1284
        //                       27: 1309
        //                       28: 1326
        //                       29: 1347
        //                       30: 1381
        //                       31: 1394
        //                       32: 1407
        //                       33: 1443
        //                       34: 1477
        //                       35: 1513
        //                       36: 1547
        //                       37: 1583
        //                       38: 1617
        //                       39: 1669
        //                       40: 1705
        //                       41: 1726
        //                       42: 1768
        //                       43: 1814
        //                       44: 1885
        //                       45: 1956
        //                       46: 1998
        //                       47: 2011
        //                       48: 2076
        //                       49: 2125
        //                       50: 2145
        //                       51: 2165
        //                       52: 2193
        //                       53: 2218
        //                       54: 2243
        //                       55: 2268
        //                       56: 2292
        //                       57: 2313
        //                       58: 2334
        //                       59: 2359
        //                       60: 2383
        //                       61: 2428
        //                       62: 2453
        //                       63: 2482
        //                       64: 2540
        //                       1598968902: 550;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61 _L62 _L63 _L64 _L65 _L66
_L1:
            flag1 = super.onTransact(i, parcel, parcel1, j);
_L68:
            return flag1;
_L66:
            parcel1.writeString("android.media.IAudioService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.media.IAudioService");
            adjustVolume(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.media.IAudioService");
            adjustLocalOrRemoteStreamVolume(parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.media.IAudioService");
            adjustSuggestedStreamVolume(parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.media.IAudioService");
            adjustStreamVolume(parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.media.IAudioService");
            adjustMasterVolume(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.media.IAudioService");
            setStreamVolume(parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.media.IAudioService");
            setRemoteStreamVolume(parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.media.IAudioService");
            setMasterVolume(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.media.IAudioService");
            int l4 = parcel.readInt();
            if(parcel.readInt() != 0)
                flag = flag1;
            setStreamSolo(l4, flag, parcel.readStrongBinder());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.media.IAudioService");
            int k4 = parcel.readInt();
            if(parcel.readInt() != 0)
                flag = flag1;
            setStreamMute(k4, flag, parcel.readStrongBinder());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.media.IAudioService");
            boolean flag12 = isStreamMute(parcel.readInt());
            parcel1.writeNoException();
            if(flag12)
                flag = flag1;
            parcel1.writeInt(flag);
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.media.IAudioService");
            boolean flag11;
            if(parcel.readInt() != 0)
                flag11 = flag1;
            else
                flag11 = false;
            setMasterMute(flag11, parcel.readInt(), parcel.readStrongBinder());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.media.IAudioService");
            boolean flag10 = isMasterMute();
            parcel1.writeNoException();
            if(flag10)
                flag = flag1;
            parcel1.writeInt(flag);
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.media.IAudioService");
            int j4 = getStreamVolume(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(j4);
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.media.IAudioService");
            int i4 = getMasterVolume();
            parcel1.writeNoException();
            parcel1.writeInt(i4);
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.media.IAudioService");
            int l3 = getStreamMaxVolume(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(l3);
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.media.IAudioService");
            int k3 = getMasterMaxVolume();
            parcel1.writeNoException();
            parcel1.writeInt(k3);
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.media.IAudioService");
            int j3 = getLastAudibleStreamVolume(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(j3);
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.media.IAudioService");
            int i3 = getLastAudibleMasterVolume();
            parcel1.writeNoException();
            parcel1.writeInt(i3);
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("android.media.IAudioService");
            setRingerMode(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("android.media.IAudioService");
            int l2 = getRingerMode();
            parcel1.writeNoException();
            parcel1.writeInt(l2);
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("android.media.IAudioService");
            setVibrateSetting(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L24:
            parcel.enforceInterface("android.media.IAudioService");
            int k2 = getVibrateSetting(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(k2);
            continue; /* Loop/switch isn't completed */
_L25:
            parcel.enforceInterface("android.media.IAudioService");
            boolean flag9 = shouldVibrate(parcel.readInt());
            parcel1.writeNoException();
            if(flag9)
                flag = flag1;
            parcel1.writeInt(flag);
            continue; /* Loop/switch isn't completed */
_L26:
            parcel.enforceInterface("android.media.IAudioService");
            setMode(parcel.readInt(), parcel.readStrongBinder());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L27:
            parcel.enforceInterface("android.media.IAudioService");
            int j2 = getMode();
            parcel1.writeNoException();
            parcel1.writeInt(j2);
            continue; /* Loop/switch isn't completed */
_L28:
            parcel.enforceInterface("android.media.IAudioService");
            playSoundEffect(parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L29:
            parcel.enforceInterface("android.media.IAudioService");
            playSoundEffectVolume(parcel.readInt(), parcel.readFloat());
            continue; /* Loop/switch isn't completed */
_L30:
            parcel.enforceInterface("android.media.IAudioService");
            boolean flag8 = loadSoundEffects();
            parcel1.writeNoException();
            if(flag8)
                flag = flag1;
            parcel1.writeInt(flag);
            continue; /* Loop/switch isn't completed */
_L31:
            parcel.enforceInterface("android.media.IAudioService");
            unloadSoundEffects();
            continue; /* Loop/switch isn't completed */
_L32:
            parcel.enforceInterface("android.media.IAudioService");
            reloadAudioSettings();
            continue; /* Loop/switch isn't completed */
_L33:
            parcel.enforceInterface("android.media.IAudioService");
            boolean flag7;
            if(parcel.readInt() != 0)
                flag7 = flag1;
            else
                flag7 = false;
            setSpeakerphoneOn(flag7);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L34:
            parcel.enforceInterface("android.media.IAudioService");
            boolean flag6 = isSpeakerphoneOn();
            parcel1.writeNoException();
            if(flag6)
                flag = flag1;
            parcel1.writeInt(flag);
            continue; /* Loop/switch isn't completed */
_L35:
            parcel.enforceInterface("android.media.IAudioService");
            boolean flag5;
            if(parcel.readInt() != 0)
                flag5 = flag1;
            else
                flag5 = false;
            setBluetoothScoOn(flag5);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L36:
            parcel.enforceInterface("android.media.IAudioService");
            boolean flag4 = isBluetoothScoOn();
            parcel1.writeNoException();
            if(flag4)
                flag = flag1;
            parcel1.writeInt(flag);
            continue; /* Loop/switch isn't completed */
_L37:
            parcel.enforceInterface("android.media.IAudioService");
            boolean flag3;
            if(parcel.readInt() != 0)
                flag3 = flag1;
            else
                flag3 = false;
            setBluetoothA2dpOn(flag3);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L38:
            parcel.enforceInterface("android.media.IAudioService");
            boolean flag2 = isBluetoothA2dpOn();
            parcel1.writeNoException();
            if(flag2)
                flag = flag1;
            parcel1.writeInt(flag);
            continue; /* Loop/switch isn't completed */
_L39:
            parcel.enforceInterface("android.media.IAudioService");
            int i2 = requestAudioFocus(parcel.readInt(), parcel.readInt(), parcel.readStrongBinder(), IAudioFocusDispatcher.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(i2);
            continue; /* Loop/switch isn't completed */
_L40:
            parcel.enforceInterface("android.media.IAudioService");
            int l1 = abandonAudioFocus(IAudioFocusDispatcher.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(l1);
            continue; /* Loop/switch isn't completed */
_L41:
            parcel.enforceInterface("android.media.IAudioService");
            unregisterAudioFocusClient(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L42:
            parcel.enforceInterface("android.media.IAudioService");
            KeyEvent keyevent1;
            if(parcel.readInt() != 0)
                keyevent1 = (KeyEvent)KeyEvent.CREATOR.createFromParcel(parcel);
            else
                keyevent1 = null;
            dispatchMediaKeyEvent(keyevent1);
            continue; /* Loop/switch isn't completed */
_L43:
            parcel.enforceInterface("android.media.IAudioService");
            KeyEvent keyevent;
            if(parcel.readInt() != 0)
                keyevent = (KeyEvent)KeyEvent.CREATOR.createFromParcel(parcel);
            else
                keyevent = null;
            dispatchMediaKeyEventUnderWakelock(keyevent);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L44:
            parcel.enforceInterface("android.media.IAudioService");
            PendingIntent pendingintent3;
            ComponentName componentname2;
            if(parcel.readInt() != 0)
                pendingintent3 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent3 = null;
            if(parcel.readInt() != 0)
                componentname2 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname2 = null;
            registerMediaButtonIntent(pendingintent3, componentname2);
            continue; /* Loop/switch isn't completed */
_L45:
            parcel.enforceInterface("android.media.IAudioService");
            PendingIntent pendingintent2;
            ComponentName componentname1;
            if(parcel.readInt() != 0)
                pendingintent2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent2 = null;
            if(parcel.readInt() != 0)
                componentname1 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname1 = null;
            unregisterMediaButtonIntent(pendingintent2, componentname1);
            continue; /* Loop/switch isn't completed */
_L46:
            parcel.enforceInterface("android.media.IAudioService");
            ComponentName componentname;
            if(parcel.readInt() != 0)
                componentname = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname = null;
            registerMediaButtonEventReceiverForCalls(componentname);
            continue; /* Loop/switch isn't completed */
_L47:
            parcel.enforceInterface("android.media.IAudioService");
            unregisterMediaButtonEventReceiverForCalls();
            continue; /* Loop/switch isn't completed */
_L48:
            parcel.enforceInterface("android.media.IAudioService");
            PendingIntent pendingintent1;
            int k1;
            if(parcel.readInt() != 0)
                pendingintent1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent1 = null;
            k1 = registerRemoteControlClient(pendingintent1, IRemoteControlClient.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(k1);
            continue; /* Loop/switch isn't completed */
_L49:
            parcel.enforceInterface("android.media.IAudioService");
            PendingIntent pendingintent;
            if(parcel.readInt() != 0)
                pendingintent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent = null;
            unregisterRemoteControlClient(pendingintent, IRemoteControlClient.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L50:
            parcel.enforceInterface("android.media.IAudioService");
            registerRemoteControlDisplay(IRemoteControlDisplay.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L51:
            parcel.enforceInterface("android.media.IAudioService");
            unregisterRemoteControlDisplay(IRemoteControlDisplay.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L52:
            parcel.enforceInterface("android.media.IAudioService");
            remoteControlDisplayUsesBitmapSize(IRemoteControlDisplay.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L53:
            parcel.enforceInterface("android.media.IAudioService");
            setPlaybackInfoForRcc(parcel.readInt(), parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L54:
            parcel.enforceInterface("android.media.IAudioService");
            int j1 = getRemoteStreamMaxVolume();
            parcel1.writeNoException();
            parcel1.writeInt(j1);
            continue; /* Loop/switch isn't completed */
_L55:
            parcel.enforceInterface("android.media.IAudioService");
            int i1 = getRemoteStreamVolume();
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            continue; /* Loop/switch isn't completed */
_L56:
            parcel.enforceInterface("android.media.IAudioService");
            registerRemoteVolumeObserverForRcc(parcel.readInt(), IRemoteVolumeObserver.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L57:
            parcel.enforceInterface("android.media.IAudioService");
            startBluetoothSco(parcel.readStrongBinder());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L58:
            parcel.enforceInterface("android.media.IAudioService");
            stopBluetoothSco(parcel.readStrongBinder());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L59:
            parcel.enforceInterface("android.media.IAudioService");
            forceVolumeControlStream(parcel.readInt(), parcel.readStrongBinder());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L60:
            parcel.enforceInterface("android.media.IAudioService");
            setRingtonePlayer(IRingtonePlayer.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L61:
            parcel.enforceInterface("android.media.IAudioService");
            IRingtonePlayer iringtoneplayer = getRingtonePlayer();
            parcel1.writeNoException();
            IBinder ibinder;
            if(iringtoneplayer != null)
                ibinder = iringtoneplayer.asBinder();
            else
                ibinder = null;
            parcel1.writeStrongBinder(ibinder);
            continue; /* Loop/switch isn't completed */
_L62:
            parcel.enforceInterface("android.media.IAudioService");
            int l = getMasterStreamType();
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L63:
            parcel.enforceInterface("android.media.IAudioService");
            setWiredDeviceConnectionState(parcel.readInt(), parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L64:
            parcel.enforceInterface("android.media.IAudioService");
            BluetoothDevice bluetoothdevice;
            int k;
            if(parcel.readInt() != 0)
                bluetoothdevice = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice = null;
            k = setBluetoothA2dpDeviceConnectionState(bluetoothdevice, parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L65:
            parcel.enforceInterface("android.media.IAudioService");
            AudioRoutesInfo audioroutesinfo = startWatchingRoutes(IAudioRoutesObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if(audioroutesinfo != null) {
                parcel1.writeInt(flag1);
                audioroutesinfo.writeToParcel(parcel1, flag1);
            } else {
                parcel1.writeInt(0);
            }
            if(true) goto _L68; else goto _L67
_L67:
        }

        private static final String DESCRIPTOR = "android.media.IAudioService";
        static final int TRANSACTION_abandonAudioFocus = 39;
        static final int TRANSACTION_adjustLocalOrRemoteStreamVolume = 2;
        static final int TRANSACTION_adjustMasterVolume = 5;
        static final int TRANSACTION_adjustStreamVolume = 4;
        static final int TRANSACTION_adjustSuggestedStreamVolume = 3;
        static final int TRANSACTION_adjustVolume = 1;
        static final int TRANSACTION_dispatchMediaKeyEvent = 41;
        static final int TRANSACTION_dispatchMediaKeyEventUnderWakelock = 42;
        static final int TRANSACTION_forceVolumeControlStream = 58;
        static final int TRANSACTION_getLastAudibleMasterVolume = 19;
        static final int TRANSACTION_getLastAudibleStreamVolume = 18;
        static final int TRANSACTION_getMasterMaxVolume = 17;
        static final int TRANSACTION_getMasterStreamType = 61;
        static final int TRANSACTION_getMasterVolume = 15;
        static final int TRANSACTION_getMode = 26;
        static final int TRANSACTION_getRemoteStreamMaxVolume = 53;
        static final int TRANSACTION_getRemoteStreamVolume = 54;
        static final int TRANSACTION_getRingerMode = 21;
        static final int TRANSACTION_getRingtonePlayer = 60;
        static final int TRANSACTION_getStreamMaxVolume = 16;
        static final int TRANSACTION_getStreamVolume = 14;
        static final int TRANSACTION_getVibrateSetting = 23;
        static final int TRANSACTION_isBluetoothA2dpOn = 37;
        static final int TRANSACTION_isBluetoothScoOn = 35;
        static final int TRANSACTION_isMasterMute = 13;
        static final int TRANSACTION_isSpeakerphoneOn = 33;
        static final int TRANSACTION_isStreamMute = 11;
        static final int TRANSACTION_loadSoundEffects = 29;
        static final int TRANSACTION_playSoundEffect = 27;
        static final int TRANSACTION_playSoundEffectVolume = 28;
        static final int TRANSACTION_registerMediaButtonEventReceiverForCalls = 45;
        static final int TRANSACTION_registerMediaButtonIntent = 43;
        static final int TRANSACTION_registerRemoteControlClient = 47;
        static final int TRANSACTION_registerRemoteControlDisplay = 49;
        static final int TRANSACTION_registerRemoteVolumeObserverForRcc = 55;
        static final int TRANSACTION_reloadAudioSettings = 31;
        static final int TRANSACTION_remoteControlDisplayUsesBitmapSize = 51;
        static final int TRANSACTION_requestAudioFocus = 38;
        static final int TRANSACTION_setBluetoothA2dpDeviceConnectionState = 63;
        static final int TRANSACTION_setBluetoothA2dpOn = 36;
        static final int TRANSACTION_setBluetoothScoOn = 34;
        static final int TRANSACTION_setMasterMute = 12;
        static final int TRANSACTION_setMasterVolume = 8;
        static final int TRANSACTION_setMode = 25;
        static final int TRANSACTION_setPlaybackInfoForRcc = 52;
        static final int TRANSACTION_setRemoteStreamVolume = 7;
        static final int TRANSACTION_setRingerMode = 20;
        static final int TRANSACTION_setRingtonePlayer = 59;
        static final int TRANSACTION_setSpeakerphoneOn = 32;
        static final int TRANSACTION_setStreamMute = 10;
        static final int TRANSACTION_setStreamSolo = 9;
        static final int TRANSACTION_setStreamVolume = 6;
        static final int TRANSACTION_setVibrateSetting = 22;
        static final int TRANSACTION_setWiredDeviceConnectionState = 62;
        static final int TRANSACTION_shouldVibrate = 24;
        static final int TRANSACTION_startBluetoothSco = 56;
        static final int TRANSACTION_startWatchingRoutes = 64;
        static final int TRANSACTION_stopBluetoothSco = 57;
        static final int TRANSACTION_unloadSoundEffects = 30;
        static final int TRANSACTION_unregisterAudioFocusClient = 40;
        static final int TRANSACTION_unregisterMediaButtonEventReceiverForCalls = 46;
        static final int TRANSACTION_unregisterMediaButtonIntent = 44;
        static final int TRANSACTION_unregisterRemoteControlClient = 48;
        static final int TRANSACTION_unregisterRemoteControlDisplay = 50;

        public Stub() {
            attachInterface(this, "android.media.IAudioService");
        }
    }


    public abstract int abandonAudioFocus(IAudioFocusDispatcher iaudiofocusdispatcher, String s) throws RemoteException;

    public abstract void adjustLocalOrRemoteStreamVolume(int i, int j) throws RemoteException;

    public abstract void adjustMasterVolume(int i, int j) throws RemoteException;

    public abstract void adjustStreamVolume(int i, int j, int k) throws RemoteException;

    public abstract void adjustSuggestedStreamVolume(int i, int j, int k) throws RemoteException;

    public abstract void adjustVolume(int i, int j) throws RemoteException;

    public abstract void dispatchMediaKeyEvent(KeyEvent keyevent) throws RemoteException;

    public abstract void dispatchMediaKeyEventUnderWakelock(KeyEvent keyevent) throws RemoteException;

    public abstract void forceVolumeControlStream(int i, IBinder ibinder) throws RemoteException;

    public abstract int getLastAudibleMasterVolume() throws RemoteException;

    public abstract int getLastAudibleStreamVolume(int i) throws RemoteException;

    public abstract int getMasterMaxVolume() throws RemoteException;

    public abstract int getMasterStreamType() throws RemoteException;

    public abstract int getMasterVolume() throws RemoteException;

    public abstract int getMode() throws RemoteException;

    public abstract int getRemoteStreamMaxVolume() throws RemoteException;

    public abstract int getRemoteStreamVolume() throws RemoteException;

    public abstract int getRingerMode() throws RemoteException;

    public abstract IRingtonePlayer getRingtonePlayer() throws RemoteException;

    public abstract int getStreamMaxVolume(int i) throws RemoteException;

    public abstract int getStreamVolume(int i) throws RemoteException;

    public abstract int getVibrateSetting(int i) throws RemoteException;

    public abstract boolean isBluetoothA2dpOn() throws RemoteException;

    public abstract boolean isBluetoothScoOn() throws RemoteException;

    public abstract boolean isMasterMute() throws RemoteException;

    public abstract boolean isSpeakerphoneOn() throws RemoteException;

    public abstract boolean isStreamMute(int i) throws RemoteException;

    public abstract boolean loadSoundEffects() throws RemoteException;

    public abstract void playSoundEffect(int i) throws RemoteException;

    public abstract void playSoundEffectVolume(int i, float f) throws RemoteException;

    public abstract void registerMediaButtonEventReceiverForCalls(ComponentName componentname) throws RemoteException;

    public abstract void registerMediaButtonIntent(PendingIntent pendingintent, ComponentName componentname) throws RemoteException;

    public abstract int registerRemoteControlClient(PendingIntent pendingintent, IRemoteControlClient iremotecontrolclient, String s) throws RemoteException;

    public abstract void registerRemoteControlDisplay(IRemoteControlDisplay iremotecontroldisplay) throws RemoteException;

    public abstract void registerRemoteVolumeObserverForRcc(int i, IRemoteVolumeObserver iremotevolumeobserver) throws RemoteException;

    public abstract void reloadAudioSettings() throws RemoteException;

    public abstract void remoteControlDisplayUsesBitmapSize(IRemoteControlDisplay iremotecontroldisplay, int i, int j) throws RemoteException;

    public abstract int requestAudioFocus(int i, int j, IBinder ibinder, IAudioFocusDispatcher iaudiofocusdispatcher, String s, String s1) throws RemoteException;

    public abstract int setBluetoothA2dpDeviceConnectionState(BluetoothDevice bluetoothdevice, int i) throws RemoteException;

    public abstract void setBluetoothA2dpOn(boolean flag) throws RemoteException;

    public abstract void setBluetoothScoOn(boolean flag) throws RemoteException;

    public abstract void setMasterMute(boolean flag, int i, IBinder ibinder) throws RemoteException;

    public abstract void setMasterVolume(int i, int j) throws RemoteException;

    public abstract void setMode(int i, IBinder ibinder) throws RemoteException;

    public abstract void setPlaybackInfoForRcc(int i, int j, int k) throws RemoteException;

    public abstract void setRemoteStreamVolume(int i) throws RemoteException;

    public abstract void setRingerMode(int i) throws RemoteException;

    public abstract void setRingtonePlayer(IRingtonePlayer iringtoneplayer) throws RemoteException;

    public abstract void setSpeakerphoneOn(boolean flag) throws RemoteException;

    public abstract void setStreamMute(int i, boolean flag, IBinder ibinder) throws RemoteException;

    public abstract void setStreamSolo(int i, boolean flag, IBinder ibinder) throws RemoteException;

    public abstract void setStreamVolume(int i, int j, int k) throws RemoteException;

    public abstract void setVibrateSetting(int i, int j) throws RemoteException;

    public abstract void setWiredDeviceConnectionState(int i, int j, String s) throws RemoteException;

    public abstract boolean shouldVibrate(int i) throws RemoteException;

    public abstract void startBluetoothSco(IBinder ibinder) throws RemoteException;

    public abstract AudioRoutesInfo startWatchingRoutes(IAudioRoutesObserver iaudioroutesobserver) throws RemoteException;

    public abstract void stopBluetoothSco(IBinder ibinder) throws RemoteException;

    public abstract void unloadSoundEffects() throws RemoteException;

    public abstract void unregisterAudioFocusClient(String s) throws RemoteException;

    public abstract void unregisterMediaButtonEventReceiverForCalls() throws RemoteException;

    public abstract void unregisterMediaButtonIntent(PendingIntent pendingintent, ComponentName componentname) throws RemoteException;

    public abstract void unregisterRemoteControlClient(PendingIntent pendingintent, IRemoteControlClient iremotecontrolclient) throws RemoteException;

    public abstract void unregisterRemoteControlDisplay(IRemoteControlDisplay iremotecontroldisplay) throws RemoteException;
}
