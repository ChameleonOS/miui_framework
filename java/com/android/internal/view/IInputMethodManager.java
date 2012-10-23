// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.os.*;
import android.text.style.SuggestionSpan;
import android.view.inputmethod.*;
import java.util.List;

// Referenced classes of package com.android.internal.view:
//            IInputMethodClient, IInputContext, InputBindResult

public interface IInputMethodManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IInputMethodManager {
        private static class Proxy
            implements IInputMethodManager {

            public void addClient(IInputMethodClient iinputmethodclient, IInputContext iinputcontext, int i, int j) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                Parcel parcel1;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder1;
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                if(iinputmethodclient == null)
                    break MISSING_BLOCK_LABEL_104;
                ibinder1 = iinputmethodclient.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder1);
                if(iinputcontext != null)
                    ibinder = iinputcontext.asBinder();
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(6, parcel, parcel1, 0);
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

            public IBinder asBinder() {
                return mRemote;
            }

            public void finishInput(IInputMethodClient iinputmethodclient) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                if(iinputmethodclient == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = iinputmethodclient.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(9, parcel, parcel1, 0);
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

            public InputMethodSubtype getCurrentInputMethodSubtype() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                mRemote.transact(23, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                InputMethodSubtype inputmethodsubtype = (InputMethodSubtype)InputMethodSubtype.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return inputmethodsubtype;
_L2:
                inputmethodsubtype = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List getEnabledInputMethodList() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(InputMethodInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List getEnabledInputMethodSubtypeList(InputMethodInfo inputmethodinfo, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                if(inputmethodinfo != null) {
                    parcel.writeInt(1);
                    inputmethodinfo.writeToParcel(parcel, 0);
                    break MISSING_BLOCK_LABEL_113;
                }
                  goto _L1
_L2:
                java.util.ArrayList arraylist;
                parcel.writeInt(i);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(InputMethodSubtype.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
_L1:
                parcel.writeInt(0);
                break MISSING_BLOCK_LABEL_113;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                while(!flag)  {
                    i = 0;
                    break;
                }
                  goto _L2
            }

            public List getInputMethodList() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(InputMethodInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.view.IInputMethodManager";
            }

            public InputMethodSubtype getLastInputMethodSubtype() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                InputMethodSubtype inputmethodsubtype = (InputMethodSubtype)InputMethodSubtype.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return inputmethodsubtype;
_L2:
                inputmethodsubtype = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List getShortcutInputMethodsAndSubtypes() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.readArrayList(getClass().getClassLoader());
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void hideMySoftInput(IBinder ibinder, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                mRemote.transact(17, parcel, parcel1, 0);
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

            public boolean hideSoftInput(IInputMethodClient iinputmethodclient, int i, ResultReceiver resultreceiver) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                if(iinputmethodclient == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iinputmethodclient.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                if(resultreceiver == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                resultreceiver.writeToParcel(parcel, 0);
_L6:
                int j;
                mRemote.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                Exception exception;
                if(j == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
_L2:
                ibinder = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public boolean notifySuggestionPicked(SuggestionSpan suggestionspan, String s, int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                if(suggestionspan == null)
                    break MISSING_BLOCK_LABEL_96;
                parcel.writeInt(1);
                suggestionspan.writeToParcel(parcel, 0);
_L1:
                int j;
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(22, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                Exception exception;
                if(j == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void registerSuggestionSpansForNotification(SuggestionSpan asuggestionspan[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                parcel.writeTypedArray(asuggestionspan, 0);
                mRemote.transact(21, parcel, parcel1, 0);
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

            public void removeClient(IInputMethodClient iinputmethodclient) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                if(iinputmethodclient == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = iinputmethodclient.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(7, parcel, parcel1, 0);
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

            public void setAdditionalInputMethodSubtypes(String s, InputMethodSubtype ainputmethodsubtype[]) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                parcel.writeString(s);
                parcel.writeTypedArray(ainputmethodsubtype, 0);
                mRemote.transact(28, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public boolean setCurrentInputMethodSubtype(InputMethodSubtype inputmethodsubtype) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                if(inputmethodsubtype == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                inputmethodsubtype.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(24, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                Exception exception;
                if(i == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setImeWindowStatus(IBinder ibinder, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                parcel.writeInt(j);
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

            public void setInputMethod(IBinder ibinder, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                mRemote.transact(15, parcel, parcel1, 0);
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

            public void setInputMethodAndSubtype(IBinder ibinder, String s, InputMethodSubtype inputmethodsubtype) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                if(inputmethodsubtype == null)
                    break MISSING_BLOCK_LABEL_79;
                parcel.writeInt(1);
                inputmethodsubtype.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(16, parcel, parcel1, 0);
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

            public boolean setInputMethodEnabled(String s, boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                parcel.writeString(s);
                if(!flag)
                    break MISSING_BLOCK_LABEL_85;
                i = ((flag1) ? 1 : 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(27, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j == 0)
                    flag1 = false;
                parcel1.recycle();
                parcel.recycle();
                return flag1;
                i = 0;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void showInputMethodAndSubtypeEnablerFromClient(IInputMethodClient iinputmethodclient, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                if(iinputmethodclient == null)
                    break MISSING_BLOCK_LABEL_69;
                ibinder = iinputmethodclient.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                mRemote.transact(14, parcel, parcel1, 0);
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

            public void showInputMethodPickerFromClient(IInputMethodClient iinputmethodclient) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                if(iinputmethodclient == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = iinputmethodclient.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(13, parcel, parcel1, 0);
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

            public void showMySoftInput(IBinder ibinder, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                mRemote.transact(18, parcel, parcel1, 0);
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

            public boolean showSoftInput(IInputMethodClient iinputmethodclient, int i, ResultReceiver resultreceiver) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                if(iinputmethodclient == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iinputmethodclient.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                if(resultreceiver == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                resultreceiver.writeToParcel(parcel, 0);
_L6:
                int j;
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                Exception exception;
                if(j == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
_L2:
                ibinder = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public InputBindResult startInput(IInputMethodClient iinputmethodclient, IInputContext iinputcontext, EditorInfo editorinfo, int i) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                Parcel parcel1;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                if(iinputmethodclient == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder1 = iinputmethodclient.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder1);
                if(iinputcontext != null)
                    ibinder = iinputcontext.asBinder();
                parcel.writeStrongBinder(ibinder);
                if(editorinfo == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                editorinfo.writeToParcel(parcel, 0);
_L6:
                InputBindResult inputbindresult;
                parcel.writeInt(i);
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_170;
                inputbindresult = (InputBindResult)InputBindResult.CREATOR.createFromParcel(parcel1);
_L7:
                parcel1.recycle();
                parcel.recycle();
                return inputbindresult;
_L2:
                ibinder1 = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                inputbindresult = null;
                  goto _L7
            }

            public boolean switchToLastInputMethod(IBinder ibinder) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(25, parcel, parcel1, 0);
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

            public boolean switchToNextInputMethod(IBinder ibinder, boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                parcel.writeStrongBinder(ibinder);
                if(!flag)
                    break MISSING_BLOCK_LABEL_85;
                i = ((flag1) ? 1 : 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(26, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j == 0)
                    flag1 = false;
                parcel1.recycle();
                parcel.recycle();
                return flag1;
                i = 0;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void updateStatusIcon(IBinder ibinder, String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(19, parcel, parcel1, 0);
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

            public InputBindResult windowGainedFocus(IInputMethodClient iinputmethodclient, IBinder ibinder, int i, int j, int k, EditorInfo editorinfo, IInputContext iinputcontext) throws RemoteException {
                IBinder ibinder1;
                Parcel parcel;
                Parcel parcel1;
                ibinder1 = null;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodManager");
                if(iinputmethodclient == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder2 = iinputmethodclient.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder2);
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                if(editorinfo == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                editorinfo.writeToParcel(parcel, 0);
_L6:
                InputBindResult inputbindresult;
                if(iinputcontext != null)
                    ibinder1 = iinputcontext.asBinder();
                parcel.writeStrongBinder(ibinder1);
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_193;
                inputbindresult = (InputBindResult)InputBindResult.CREATOR.createFromParcel(parcel1);
_L7:
                parcel1.recycle();
                parcel.recycle();
                return inputbindresult;
_L2:
                ibinder2 = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                inputbindresult = null;
                  goto _L7
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IInputMethodManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.view.IInputMethodManager");
                if(iinterface != null && (iinterface instanceof IInputMethodManager))
                    obj = (IInputMethodManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IInputMethodManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 29: default 244
        //                       1: 270
        //                       2: 298
        //                       3: 326
        //                       4: 401
        //                       5: 448
        //                       6: 476
        //                       7: 518
        //                       8: 545
        //                       9: 647
        //                       10: 674
        //                       11: 764
        //                       12: 854
        //                       13: 980
        //                       14: 1007
        //                       15: 1038
        //                       16: 1066
        //                       17: 1131
        //                       18: 1159
        //                       19: 1187
        //                       20: 1219
        //                       21: 1251
        //                       22: 1281
        //                       23: 1360
        //                       24: 1407
        //                       25: 1478
        //                       26: 1524
        //                       27: 1592
        //                       28: 1660
        //                       1598968902: 258;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L32:
            return flag;
_L30:
            parcel1.writeString("com.android.internal.view.IInputMethodManager");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            List list3 = getInputMethodList();
            parcel1.writeNoException();
            parcel1.writeTypedList(list3);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            List list2 = getEnabledInputMethodList();
            parcel1.writeNoException();
            parcel1.writeTypedList(list2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            InputMethodInfo inputmethodinfo;
            boolean flag10;
            List list1;
            if(parcel.readInt() != 0)
                inputmethodinfo = (InputMethodInfo)InputMethodInfo.CREATOR.createFromParcel(parcel);
            else
                inputmethodinfo = null;
            if(parcel.readInt() != 0)
                flag10 = true;
            else
                flag10 = false;
            list1 = getEnabledInputMethodSubtypeList(inputmethodinfo, flag10);
            parcel1.writeNoException();
            parcel1.writeTypedList(list1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            InputMethodSubtype inputmethodsubtype3 = getLastInputMethodSubtype();
            parcel1.writeNoException();
            if(inputmethodsubtype3 != null) {
                parcel1.writeInt(1);
                inputmethodsubtype3.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            List list = getShortcutInputMethodsAndSubtypes();
            parcel1.writeNoException();
            parcel1.writeList(list);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            addClient(IInputMethodClient.Stub.asInterface(parcel.readStrongBinder()), IInputContext.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            removeClient(IInputMethodClient.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            IInputMethodClient iinputmethodclient3 = IInputMethodClient.Stub.asInterface(parcel.readStrongBinder());
            IInputContext iinputcontext = IInputContext.Stub.asInterface(parcel.readStrongBinder());
            EditorInfo editorinfo1;
            InputBindResult inputbindresult1;
            if(parcel.readInt() != 0)
                editorinfo1 = (EditorInfo)EditorInfo.CREATOR.createFromParcel(parcel);
            else
                editorinfo1 = null;
            inputbindresult1 = startInput(iinputmethodclient3, iinputcontext, editorinfo1, parcel.readInt());
            parcel1.writeNoException();
            if(inputbindresult1 != null) {
                parcel1.writeInt(1);
                inputbindresult1.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            finishInput(IInputMethodClient.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            IInputMethodClient iinputmethodclient2 = IInputMethodClient.Stub.asInterface(parcel.readStrongBinder());
            int i3 = parcel.readInt();
            ResultReceiver resultreceiver1;
            boolean flag9;
            int j3;
            if(parcel.readInt() != 0)
                resultreceiver1 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(parcel);
            else
                resultreceiver1 = null;
            flag9 = showSoftInput(iinputmethodclient2, i3, resultreceiver1);
            parcel1.writeNoException();
            if(flag9)
                j3 = 1;
            else
                j3 = 0;
            parcel1.writeInt(j3);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            IInputMethodClient iinputmethodclient1 = IInputMethodClient.Stub.asInterface(parcel.readStrongBinder());
            int k2 = parcel.readInt();
            ResultReceiver resultreceiver;
            boolean flag8;
            int l2;
            if(parcel.readInt() != 0)
                resultreceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(parcel);
            else
                resultreceiver = null;
            flag8 = hideSoftInput(iinputmethodclient1, k2, resultreceiver);
            parcel1.writeNoException();
            if(flag8)
                l2 = 1;
            else
                l2 = 0;
            parcel1.writeInt(l2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            IInputMethodClient iinputmethodclient = IInputMethodClient.Stub.asInterface(parcel.readStrongBinder());
            IBinder ibinder2 = parcel.readStrongBinder();
            int l1 = parcel.readInt();
            int i2 = parcel.readInt();
            int j2 = parcel.readInt();
            EditorInfo editorinfo;
            InputBindResult inputbindresult;
            if(parcel.readInt() != 0)
                editorinfo = (EditorInfo)EditorInfo.CREATOR.createFromParcel(parcel);
            else
                editorinfo = null;
            inputbindresult = windowGainedFocus(iinputmethodclient, ibinder2, l1, i2, j2, editorinfo, IInputContext.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if(inputbindresult != null) {
                parcel1.writeInt(1);
                inputbindresult.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            showInputMethodPickerFromClient(IInputMethodClient.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            showInputMethodAndSubtypeEnablerFromClient(IInputMethodClient.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            setInputMethod(parcel.readStrongBinder(), parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            IBinder ibinder1 = parcel.readStrongBinder();
            String s1 = parcel.readString();
            InputMethodSubtype inputmethodsubtype2;
            if(parcel.readInt() != 0)
                inputmethodsubtype2 = (InputMethodSubtype)InputMethodSubtype.CREATOR.createFromParcel(parcel);
            else
                inputmethodsubtype2 = null;
            setInputMethodAndSubtype(ibinder1, s1, inputmethodsubtype2);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            hideMySoftInput(parcel.readStrongBinder(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            showMySoftInput(parcel.readStrongBinder(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            updateStatusIcon(parcel.readStrongBinder(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            setImeWindowStatus(parcel.readStrongBinder(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            registerSuggestionSpansForNotification((SuggestionSpan[])parcel.createTypedArray(SuggestionSpan.CREATOR));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            SuggestionSpan suggestionspan;
            boolean flag7;
            int k1;
            if(parcel.readInt() != 0)
                suggestionspan = (SuggestionSpan)SuggestionSpan.CREATOR.createFromParcel(parcel);
            else
                suggestionspan = null;
            flag7 = notifySuggestionPicked(suggestionspan, parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            if(flag7)
                k1 = 1;
            else
                k1 = 0;
            parcel1.writeInt(k1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L24:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            InputMethodSubtype inputmethodsubtype1 = getCurrentInputMethodSubtype();
            parcel1.writeNoException();
            if(inputmethodsubtype1 != null) {
                parcel1.writeInt(1);
                inputmethodsubtype1.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L25:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            InputMethodSubtype inputmethodsubtype;
            boolean flag6;
            int j1;
            if(parcel.readInt() != 0)
                inputmethodsubtype = (InputMethodSubtype)InputMethodSubtype.CREATOR.createFromParcel(parcel);
            else
                inputmethodsubtype = null;
            flag6 = setCurrentInputMethodSubtype(inputmethodsubtype);
            parcel1.writeNoException();
            if(flag6)
                j1 = 1;
            else
                j1 = 0;
            parcel1.writeInt(j1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L26:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            boolean flag5 = switchToLastInputMethod(parcel.readStrongBinder());
            parcel1.writeNoException();
            int i1;
            if(flag5)
                i1 = 1;
            else
                i1 = 0;
            parcel1.writeInt(i1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L27:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            IBinder ibinder = parcel.readStrongBinder();
            boolean flag3;
            boolean flag4;
            int l;
            if(parcel.readInt() != 0)
                flag3 = true;
            else
                flag3 = false;
            flag4 = switchToNextInputMethod(ibinder, flag3);
            parcel1.writeNoException();
            if(flag4)
                l = 1;
            else
                l = 0;
            parcel1.writeInt(l);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L28:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            String s = parcel.readString();
            boolean flag1;
            boolean flag2;
            int k;
            if(parcel.readInt() != 0)
                flag1 = true;
            else
                flag1 = false;
            flag2 = setInputMethodEnabled(s, flag1);
            parcel1.writeNoException();
            if(flag2)
                k = 1;
            else
                k = 0;
            parcel1.writeInt(k);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L29:
            parcel.enforceInterface("com.android.internal.view.IInputMethodManager");
            setAdditionalInputMethodSubtypes(parcel.readString(), (InputMethodSubtype[])parcel.createTypedArray(InputMethodSubtype.CREATOR));
            flag = true;
            if(true) goto _L32; else goto _L31
_L31:
        }

        private static final String DESCRIPTOR = "com.android.internal.view.IInputMethodManager";
        static final int TRANSACTION_addClient = 6;
        static final int TRANSACTION_finishInput = 9;
        static final int TRANSACTION_getCurrentInputMethodSubtype = 23;
        static final int TRANSACTION_getEnabledInputMethodList = 2;
        static final int TRANSACTION_getEnabledInputMethodSubtypeList = 3;
        static final int TRANSACTION_getInputMethodList = 1;
        static final int TRANSACTION_getLastInputMethodSubtype = 4;
        static final int TRANSACTION_getShortcutInputMethodsAndSubtypes = 5;
        static final int TRANSACTION_hideMySoftInput = 17;
        static final int TRANSACTION_hideSoftInput = 11;
        static final int TRANSACTION_notifySuggestionPicked = 22;
        static final int TRANSACTION_registerSuggestionSpansForNotification = 21;
        static final int TRANSACTION_removeClient = 7;
        static final int TRANSACTION_setAdditionalInputMethodSubtypes = 28;
        static final int TRANSACTION_setCurrentInputMethodSubtype = 24;
        static final int TRANSACTION_setImeWindowStatus = 20;
        static final int TRANSACTION_setInputMethod = 15;
        static final int TRANSACTION_setInputMethodAndSubtype = 16;
        static final int TRANSACTION_setInputMethodEnabled = 27;
        static final int TRANSACTION_showInputMethodAndSubtypeEnablerFromClient = 14;
        static final int TRANSACTION_showInputMethodPickerFromClient = 13;
        static final int TRANSACTION_showMySoftInput = 18;
        static final int TRANSACTION_showSoftInput = 10;
        static final int TRANSACTION_startInput = 8;
        static final int TRANSACTION_switchToLastInputMethod = 25;
        static final int TRANSACTION_switchToNextInputMethod = 26;
        static final int TRANSACTION_updateStatusIcon = 19;
        static final int TRANSACTION_windowGainedFocus = 12;

        public Stub() {
            attachInterface(this, "com.android.internal.view.IInputMethodManager");
        }
    }


    public abstract void addClient(IInputMethodClient iinputmethodclient, IInputContext iinputcontext, int i, int j) throws RemoteException;

    public abstract void finishInput(IInputMethodClient iinputmethodclient) throws RemoteException;

    public abstract InputMethodSubtype getCurrentInputMethodSubtype() throws RemoteException;

    public abstract List getEnabledInputMethodList() throws RemoteException;

    public abstract List getEnabledInputMethodSubtypeList(InputMethodInfo inputmethodinfo, boolean flag) throws RemoteException;

    public abstract List getInputMethodList() throws RemoteException;

    public abstract InputMethodSubtype getLastInputMethodSubtype() throws RemoteException;

    public abstract List getShortcutInputMethodsAndSubtypes() throws RemoteException;

    public abstract void hideMySoftInput(IBinder ibinder, int i) throws RemoteException;

    public abstract boolean hideSoftInput(IInputMethodClient iinputmethodclient, int i, ResultReceiver resultreceiver) throws RemoteException;

    public abstract boolean notifySuggestionPicked(SuggestionSpan suggestionspan, String s, int i) throws RemoteException;

    public abstract void registerSuggestionSpansForNotification(SuggestionSpan asuggestionspan[]) throws RemoteException;

    public abstract void removeClient(IInputMethodClient iinputmethodclient) throws RemoteException;

    public abstract void setAdditionalInputMethodSubtypes(String s, InputMethodSubtype ainputmethodsubtype[]) throws RemoteException;

    public abstract boolean setCurrentInputMethodSubtype(InputMethodSubtype inputmethodsubtype) throws RemoteException;

    public abstract void setImeWindowStatus(IBinder ibinder, int i, int j) throws RemoteException;

    public abstract void setInputMethod(IBinder ibinder, String s) throws RemoteException;

    public abstract void setInputMethodAndSubtype(IBinder ibinder, String s, InputMethodSubtype inputmethodsubtype) throws RemoteException;

    public abstract boolean setInputMethodEnabled(String s, boolean flag) throws RemoteException;

    public abstract void showInputMethodAndSubtypeEnablerFromClient(IInputMethodClient iinputmethodclient, String s) throws RemoteException;

    public abstract void showInputMethodPickerFromClient(IInputMethodClient iinputmethodclient) throws RemoteException;

    public abstract void showMySoftInput(IBinder ibinder, int i) throws RemoteException;

    public abstract boolean showSoftInput(IInputMethodClient iinputmethodclient, int i, ResultReceiver resultreceiver) throws RemoteException;

    public abstract InputBindResult startInput(IInputMethodClient iinputmethodclient, IInputContext iinputcontext, EditorInfo editorinfo, int i) throws RemoteException;

    public abstract boolean switchToLastInputMethod(IBinder ibinder) throws RemoteException;

    public abstract boolean switchToNextInputMethod(IBinder ibinder, boolean flag) throws RemoteException;

    public abstract void updateStatusIcon(IBinder ibinder, String s, int i) throws RemoteException;

    public abstract InputBindResult windowGainedFocus(IInputMethodClient iinputmethodclient, IBinder ibinder, int i, int j, int k, EditorInfo editorinfo, IInputContext iinputcontext) throws RemoteException;
}
