// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc;

import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.*;
import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package android.nfc:
//            INfcTag

public final class Tag
    implements Parcelable {

    public Tag(byte abyte0[], int ai[], Bundle abundle[], int i, INfcTag infctag) {
        if(ai == null) {
            throw new IllegalArgumentException("rawTargets cannot be null");
        } else {
            mId = abyte0;
            mTechList = Arrays.copyOf(ai, ai.length);
            mTechStringList = generateTechStringList(ai);
            mTechExtras = (Bundle[])Arrays.copyOf(abundle, ai.length);
            mServiceHandle = i;
            mTagService = infctag;
            mConnectedTechnology = -1;
            return;
        }
    }

    public static Tag createMockTag(byte abyte0[], int ai[], Bundle abundle[]) {
        return new Tag(abyte0, ai, abundle, 0, null);
    }

    private String[] generateTechStringList(int ai[]) {
        int i;
        String as[];
        int j;
        i = ai.length;
        as = new String[i];
        j = 0;
_L12:
        if(j >= i)
            break MISSING_BLOCK_LABEL_213;
        ai[j];
        JVM INSTR tableswitch 1 9: default 72
    //                   1 165
    //                   2 177
    //                   3 102
    //                   4 189
    //                   5 201
    //                   6 141
    //                   7 153
    //                   8 117
    //                   9 129;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L6:
        break MISSING_BLOCK_LABEL_201;
_L9:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown tech type ").append(ai[j]).toString());
_L4:
        as[j] = android/nfc/tech/IsoDep.getName();
_L13:
        j++;
        if(true) goto _L12; else goto _L11
_L11:
        as[j] = android/nfc/tech/MifareClassic.getName();
          goto _L13
_L10:
        as[j] = android/nfc/tech/MifareUltralight.getName();
          goto _L13
_L7:
        as[j] = android/nfc/tech/Ndef.getName();
          goto _L13
_L8:
        as[j] = android/nfc/tech/NdefFormatable.getName();
          goto _L13
_L2:
        as[j] = android/nfc/tech/NfcA.getName();
          goto _L13
_L3:
        as[j] = android/nfc/tech/NfcB.getName();
          goto _L13
_L5:
        as[j] = android/nfc/tech/NfcF.getName();
          goto _L13
        as[j] = android/nfc/tech/NfcV.getName();
          goto _L13
        return as;
    }

    static byte[] readBytesWithNull(Parcel parcel) {
        int i = parcel.readInt();
        byte abyte0[] = null;
        if(i >= 0) {
            abyte0 = new byte[i];
            parcel.readByteArray(abyte0);
        }
        return abyte0;
    }

    static void writeBytesWithNull(Parcel parcel, byte abyte0[]) {
        if(abyte0 == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(abyte0.length);
            parcel.writeByteArray(abyte0);
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getConnectedTechnology() {
        return mConnectedTechnology;
    }

    public byte[] getId() {
        return mId;
    }

    public int getServiceHandle() {
        return mServiceHandle;
    }

    public INfcTag getTagService() {
        return mTagService;
    }

    public Bundle getTechExtras(int i) {
        int j = -1;
        int k = 0;
        do {
label0:
            {
                if(k < mTechList.length) {
                    if(mTechList[k] != i)
                        break label0;
                    j = k;
                }
                Bundle bundle;
                if(j < 0)
                    bundle = null;
                else
                    bundle = mTechExtras[j];
                return bundle;
            }
            k++;
        } while(true);
    }

    public String[] getTechList() {
        return mTechStringList;
    }

    public boolean hasTech(int i) {
        int ai[];
        int j;
        int k;
        ai = mTechList;
        j = ai.length;
        k = 0;
_L3:
        if(k >= j)
            break MISSING_BLOCK_LABEL_37;
        if(ai[k] != i) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        k++;
          goto _L3
        flag = false;
          goto _L4
    }

    public Tag rediscover() throws IOException {
        if(getConnectedTechnology() != -1)
            throw new IllegalStateException("Close connection to the technology first!");
        if(mTagService == null)
            throw new IOException("Mock tags don't support this operation.");
        try {
            Tag tag = mTagService.rediscover(getServiceHandle());
            if(tag != null)
                return tag;
            else
                throw new IOException("Failed to rediscover tag");
        }
        catch(RemoteException remoteexception) {
            throw new IOException("NFC service dead");
        }
    }

    /**
     * @deprecated Method setConnectedTechnology is deprecated
     */

    public void setConnectedTechnology(int i) {
        this;
        JVM INSTR monitorenter ;
        if(mConnectedTechnology != -1)
            break MISSING_BLOCK_LABEL_19;
        mConnectedTechnology = i;
        this;
        JVM INSTR monitorexit ;
        return;
        throw new IllegalStateException("Close other technology first!");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setTechnologyDisconnected() {
        mConnectedTechnology = -1;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder("TAG: Tech [");
        String as[] = getTechList();
        int i = as.length;
        for(int j = 0; j < i; j++) {
            stringbuilder.append(as[j]);
            if(j < i - 1)
                stringbuilder.append(", ");
        }

        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j;
        if(mTagService == null)
            j = 1;
        else
            j = 0;
        writeBytesWithNull(parcel, mId);
        parcel.writeInt(mTechList.length);
        parcel.writeIntArray(mTechList);
        parcel.writeTypedArray(mTechExtras, 0);
        parcel.writeInt(mServiceHandle);
        parcel.writeInt(j);
        if(j == 0)
            parcel.writeStrongBinder(mTagService.asBinder());
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Tag createFromParcel(Parcel parcel) {
            byte abyte0[] = Tag.readBytesWithNull(parcel);
            int ai[] = new int[parcel.readInt()];
            parcel.readIntArray(ai);
            Bundle abundle[] = (Bundle[])parcel.createTypedArray(Bundle.CREATOR);
            int i = parcel.readInt();
            INfcTag infctag;
            if(parcel.readInt() == 0)
                infctag = INfcTag.Stub.asInterface(parcel.readStrongBinder());
            else
                infctag = null;
            return new Tag(abyte0, ai, abundle, i, infctag);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Tag[] newArray(int i) {
            return new Tag[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    int mConnectedTechnology;
    final byte mId[];
    final int mServiceHandle;
    final INfcTag mTagService;
    final Bundle mTechExtras[];
    final int mTechList[];
    final String mTechStringList[];

}
