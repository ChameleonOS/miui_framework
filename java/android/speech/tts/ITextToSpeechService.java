// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;

import android.net.Uri;
import android.os.*;

// Referenced classes of package android.speech.tts:
//            ITextToSpeechCallback

public interface ITextToSpeechService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ITextToSpeechService {
        private static class Proxy
            implements ITextToSpeechService {

            public IBinder asBinder() {
                return mRemote;
            }

            public String[] getFeaturesForLanguage(String s, String s1, String s2) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.speech.tts.ITextToSpeechService");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeString(s2);
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                as = parcel1.createStringArray();
                parcel1.recycle();
                parcel.recycle();
                return as;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.speech.tts.ITextToSpeechService";
            }

            public String[] getLanguage() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.speech.tts.ITextToSpeechService");
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                as = parcel1.createStringArray();
                parcel1.recycle();
                parcel.recycle();
                return as;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int isLanguageAvailable(String s, String s1, String s2) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.speech.tts.ITextToSpeechService");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeString(s2);
                mRemote.transact(8, parcel, parcel1, 0);
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

            public boolean isSpeaking() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.speech.tts.ITextToSpeechService");
                mRemote.transact(5, parcel, parcel1, 0);
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

            public int loadLanguage(String s, String s1, String s2) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.speech.tts.ITextToSpeechService");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeString(s2);
                mRemote.transact(10, parcel, parcel1, 0);
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

            public int playAudio(IBinder ibinder, Uri uri, int i, Bundle bundle) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.tts.ITextToSpeechService");
                parcel.writeStrongBinder(ibinder);
                if(uri == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                uri.writeToParcel(parcel, 0);
_L3:
                parcel.writeInt(i);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_130;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L4:
                int j;
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public int playSilence(IBinder ibinder, long l, int i, Bundle bundle) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.tts.ITextToSpeechService");
                parcel.writeStrongBinder(ibinder);
                parcel.writeLong(l);
                parcel.writeInt(i);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_96;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                int j;
                mRemote.transact(4, parcel, parcel1, 0);
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

            public void setCallback(IBinder ibinder, ITextToSpeechCallback itexttospeechcallback) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder1;
                parcel.writeInterfaceToken("android.speech.tts.ITextToSpeechService");
                parcel.writeStrongBinder(ibinder);
                if(itexttospeechcallback == null)
                    break MISSING_BLOCK_LABEL_69;
                ibinder1 = itexttospeechcallback.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder1);
                mRemote.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder1 = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int speak(IBinder ibinder, String s, int i, Bundle bundle) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.tts.ITextToSpeechService");
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                parcel.writeInt(i);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_95;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                int j;
                mRemote.transact(1, parcel, parcel1, 0);
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

            public int stop(IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.speech.tts.ITextToSpeechService");
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(6, parcel, parcel1, 0);
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

            public int synthesizeToFile(IBinder ibinder, String s, String s1, Bundle bundle) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.tts.ITextToSpeechService");
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                parcel.writeString(s1);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_95;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static ITextToSpeechService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.speech.tts.ITextToSpeechService");
                if(iinterface != null && (iinterface instanceof ITextToSpeechService))
                    obj = (ITextToSpeechService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ITextToSpeechService) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 12: default 112
        //                       1: 135
        //                       2: 213
        //                       3: 291
        //                       4: 390
        //                       5: 468
        //                       6: 508
        //                       7: 537
        //                       8: 562
        //                       9: 599
        //                       10: 636
        //                       11: 673
        //                       1598968902: 126;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L15:
            return flag;
_L13:
            parcel1.writeString("android.speech.tts.ITextToSpeechService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.speech.tts.ITextToSpeechService");
            IBinder ibinder3 = parcel.readStrongBinder();
            String s2 = parcel.readString();
            int i3 = parcel.readInt();
            Bundle bundle3;
            int j3;
            if(parcel.readInt() != 0)
                bundle3 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle3 = null;
            j3 = speak(ibinder3, s2, i3, bundle3);
            parcel1.writeNoException();
            parcel1.writeInt(j3);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.speech.tts.ITextToSpeechService");
            IBinder ibinder2 = parcel.readStrongBinder();
            String s = parcel.readString();
            String s1 = parcel.readString();
            Bundle bundle2;
            int l2;
            if(parcel.readInt() != 0)
                bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle2 = null;
            l2 = synthesizeToFile(ibinder2, s, s1, bundle2);
            parcel1.writeNoException();
            parcel1.writeInt(l2);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.speech.tts.ITextToSpeechService");
            IBinder ibinder1 = parcel.readStrongBinder();
            Uri uri;
            int j2;
            Bundle bundle1;
            int k2;
            if(parcel.readInt() != 0)
                uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
            else
                uri = null;
            j2 = parcel.readInt();
            if(parcel.readInt() != 0)
                bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle1 = null;
            k2 = playAudio(ibinder1, uri, j2, bundle1);
            parcel1.writeNoException();
            parcel1.writeInt(k2);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.speech.tts.ITextToSpeechService");
            IBinder ibinder = parcel.readStrongBinder();
            long l1 = parcel.readLong();
            int k1 = parcel.readInt();
            Bundle bundle;
            int i2;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            i2 = playSilence(ibinder, l1, k1, bundle);
            parcel1.writeNoException();
            parcel1.writeInt(i2);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.speech.tts.ITextToSpeechService");
            boolean flag1 = isSpeaking();
            parcel1.writeNoException();
            int j1;
            if(flag1)
                j1 = ((flag) ? 1 : 0);
            else
                j1 = 0;
            parcel1.writeInt(j1);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.speech.tts.ITextToSpeechService");
            int i1 = stop(parcel.readStrongBinder());
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.speech.tts.ITextToSpeechService");
            String as1[] = getLanguage();
            parcel1.writeNoException();
            parcel1.writeStringArray(as1);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.speech.tts.ITextToSpeechService");
            int l = isLanguageAvailable(parcel.readString(), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.speech.tts.ITextToSpeechService");
            String as[] = getFeaturesForLanguage(parcel.readString(), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            parcel1.writeStringArray(as);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.speech.tts.ITextToSpeechService");
            int k = loadLanguage(parcel.readString(), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.speech.tts.ITextToSpeechService");
            setCallback(parcel.readStrongBinder(), ITextToSpeechCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if(true) goto _L15; else goto _L14
_L14:
        }

        private static final String DESCRIPTOR = "android.speech.tts.ITextToSpeechService";
        static final int TRANSACTION_getFeaturesForLanguage = 9;
        static final int TRANSACTION_getLanguage = 7;
        static final int TRANSACTION_isLanguageAvailable = 8;
        static final int TRANSACTION_isSpeaking = 5;
        static final int TRANSACTION_loadLanguage = 10;
        static final int TRANSACTION_playAudio = 3;
        static final int TRANSACTION_playSilence = 4;
        static final int TRANSACTION_setCallback = 11;
        static final int TRANSACTION_speak = 1;
        static final int TRANSACTION_stop = 6;
        static final int TRANSACTION_synthesizeToFile = 2;

        public Stub() {
            attachInterface(this, "android.speech.tts.ITextToSpeechService");
        }
    }


    public abstract String[] getFeaturesForLanguage(String s, String s1, String s2) throws RemoteException;

    public abstract String[] getLanguage() throws RemoteException;

    public abstract int isLanguageAvailable(String s, String s1, String s2) throws RemoteException;

    public abstract boolean isSpeaking() throws RemoteException;

    public abstract int loadLanguage(String s, String s1, String s2) throws RemoteException;

    public abstract int playAudio(IBinder ibinder, Uri uri, int i, Bundle bundle) throws RemoteException;

    public abstract int playSilence(IBinder ibinder, long l, int i, Bundle bundle) throws RemoteException;

    public abstract void setCallback(IBinder ibinder, ITextToSpeechCallback itexttospeechcallback) throws RemoteException;

    public abstract int speak(IBinder ibinder, String s, int i, Bundle bundle) throws RemoteException;

    public abstract int stop(IBinder ibinder) throws RemoteException;

    public abstract int synthesizeToFile(IBinder ibinder, String s, String s1, Bundle bundle) throws RemoteException;
}
