// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Slog;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class ContainerEncryptionParams
    implements Parcelable {

    private ContainerEncryptionParams(Parcel parcel) throws InvalidAlgorithmParameterException {
        mEncryptionAlgorithm = parcel.readString();
        int i = parcel.readInt();
        byte abyte0[] = parcel.createByteArray();
        mEncryptionKey = (SecretKey)parcel.readSerializable();
        mMacAlgorithm = parcel.readString();
        int j = parcel.readInt();
        parcel.createByteArray();
        mMacKey = (SecretKey)parcel.readSerializable();
        mMacTag = parcel.createByteArray();
        mAuthenticatedDataStart = parcel.readLong();
        mEncryptedDataStart = parcel.readLong();
        mDataEnd = parcel.readLong();
        switch(i) {
        default:
            throw new InvalidAlgorithmParameterException((new StringBuilder()).append("Unknown parameter type ").append(i).toString());

        case 1: // '\001'
            mEncryptionSpec = new IvParameterSpec(abyte0);
            break;
        }
        switch(j) {
        default:
            throw new InvalidAlgorithmParameterException((new StringBuilder()).append("Unknown parameter type ").append(j).toString());

        case 1: // '\001'
            mMacSpec = null;
            break;
        }
        if(mEncryptionKey == null)
            throw new NullPointerException("encryptionKey == null");
        else
            return;
    }


    public ContainerEncryptionParams(String s, AlgorithmParameterSpec algorithmparameterspec, SecretKey secretkey) throws InvalidAlgorithmParameterException {
        this(s, algorithmparameterspec, secretkey, null, null, null, null, -1L, -1L, -1L);
    }

    public ContainerEncryptionParams(String s, AlgorithmParameterSpec algorithmparameterspec, SecretKey secretkey, String s1, AlgorithmParameterSpec algorithmparameterspec1, SecretKey secretkey1, byte abyte0[], 
            long l, long l1, long l2) throws InvalidAlgorithmParameterException {
        if(TextUtils.isEmpty(s))
            throw new NullPointerException("algorithm == null");
        if(algorithmparameterspec == null)
            throw new NullPointerException("encryptionSpec == null");
        if(secretkey == null)
            throw new NullPointerException("encryptionKey == null");
        if(!TextUtils.isEmpty(s1) && secretkey1 == null)
            throw new NullPointerException("macKey == null");
        if(!(algorithmparameterspec instanceof IvParameterSpec)) {
            throw new InvalidAlgorithmParameterException("Unknown parameter spec class; must be IvParameters");
        } else {
            mEncryptionAlgorithm = s;
            mEncryptionSpec = (IvParameterSpec)algorithmparameterspec;
            mEncryptionKey = secretkey;
            mMacAlgorithm = s1;
            mMacSpec = algorithmparameterspec1;
            mMacKey = secretkey1;
            mMacTag = abyte0;
            mAuthenticatedDataStart = l;
            mEncryptedDataStart = l1;
            mDataEnd = l2;
            return;
        }
    }

    private static final boolean isSecretKeyEqual(SecretKey secretkey, SecretKey secretkey1) {
        boolean flag = false;
        String s = secretkey.getFormat();
        String s1 = secretkey1.getFormat();
        if(s != null ? s.equals(secretkey1.getFormat()) && Arrays.equals(secretkey.getEncoded(), secretkey1.getEncoded()) : s == s1 && secretkey.getEncoded() == secretkey1.getEncoded())
            flag = true;
        return flag;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = true;
        if(this != obj) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(!(obj instanceof ContainerEncryptionParams)) {
            flag = false;
        } else {
            ContainerEncryptionParams containerencryptionparams = (ContainerEncryptionParams)obj;
            if(mAuthenticatedDataStart != containerencryptionparams.mAuthenticatedDataStart || mEncryptedDataStart != containerencryptionparams.mEncryptedDataStart || mDataEnd != containerencryptionparams.mDataEnd)
                flag = false;
            else
            if(!mEncryptionAlgorithm.equals(containerencryptionparams.mEncryptionAlgorithm) || !mMacAlgorithm.equals(containerencryptionparams.mMacAlgorithm))
                flag = false;
            else
            if(!isSecretKeyEqual(mEncryptionKey, containerencryptionparams.mEncryptionKey) || !isSecretKeyEqual(mMacKey, containerencryptionparams.mMacKey))
                flag = false;
            else
            if(!Arrays.equals(mEncryptionSpec.getIV(), containerencryptionparams.mEncryptionSpec.getIV()) || !Arrays.equals(mMacTag, containerencryptionparams.mMacTag) || mMacSpec != containerencryptionparams.mMacSpec)
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public long getAuthenticatedDataStart() {
        return mAuthenticatedDataStart;
    }

    public long getDataEnd() {
        return mDataEnd;
    }

    public long getEncryptedDataStart() {
        return mEncryptedDataStart;
    }

    public String getEncryptionAlgorithm() {
        return mEncryptionAlgorithm;
    }

    public SecretKey getEncryptionKey() {
        return mEncryptionKey;
    }

    public AlgorithmParameterSpec getEncryptionSpec() {
        return mEncryptionSpec;
    }

    public String getMacAlgorithm() {
        return mMacAlgorithm;
    }

    public SecretKey getMacKey() {
        return mMacKey;
    }

    public AlgorithmParameterSpec getMacSpec() {
        return mMacSpec;
    }

    public byte[] getMacTag() {
        return mMacTag;
    }

    public int hashCode() {
        return (int)((long)(int)((long)(int)((long)(3 + 5 * mEncryptionAlgorithm.hashCode() + 7 * Arrays.hashCode(mEncryptionSpec.getIV()) + 11 * mEncryptionKey.hashCode() + 13 * mMacAlgorithm.hashCode() + 17 * mMacKey.hashCode() + 19 * Arrays.hashCode(mMacTag)) + 23L * mAuthenticatedDataStart) + 29L * mEncryptedDataStart) + 31L * mDataEnd);
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder("ContainerEncryptionParams{");
        stringbuilder.append("mEncryptionAlgorithm=\"");
        stringbuilder.append(mEncryptionAlgorithm);
        stringbuilder.append("\",");
        stringbuilder.append("mEncryptionSpec=");
        stringbuilder.append(mEncryptionSpec.toString());
        stringbuilder.append("mEncryptionKey=");
        stringbuilder.append(mEncryptionKey.toString());
        stringbuilder.append("mMacAlgorithm=\"");
        stringbuilder.append(mMacAlgorithm);
        stringbuilder.append("\",");
        stringbuilder.append("mMacSpec=");
        stringbuilder.append(mMacSpec.toString());
        stringbuilder.append("mMacKey=");
        stringbuilder.append(mMacKey.toString());
        stringbuilder.append(",mAuthenticatedDataStart=");
        stringbuilder.append(mAuthenticatedDataStart);
        stringbuilder.append(",mEncryptedDataStart=");
        stringbuilder.append(mEncryptedDataStart);
        stringbuilder.append(",mDataEnd=");
        stringbuilder.append(mDataEnd);
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mEncryptionAlgorithm);
        parcel.writeInt(1);
        parcel.writeByteArray(mEncryptionSpec.getIV());
        parcel.writeSerializable(mEncryptionKey);
        parcel.writeString(mMacAlgorithm);
        parcel.writeInt(1);
        parcel.writeByteArray(new byte[0]);
        parcel.writeSerializable(mMacKey);
        parcel.writeByteArray(mMacTag);
        parcel.writeLong(mAuthenticatedDataStart);
        parcel.writeLong(mEncryptedDataStart);
        parcel.writeLong(mDataEnd);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ContainerEncryptionParams createFromParcel(Parcel parcel) {
            ContainerEncryptionParams containerencryptionparams;
            try {
                containerencryptionparams = new ContainerEncryptionParams(parcel);
            }
            catch(InvalidAlgorithmParameterException invalidalgorithmparameterexception) {
                Slog.e("ContainerEncryptionParams", "Invalid algorithm parameters specified", invalidalgorithmparameterexception);
                containerencryptionparams = null;
            }
            return containerencryptionparams;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ContainerEncryptionParams[] newArray(int i) {
            return new ContainerEncryptionParams[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final int ENC_PARAMS_IV_PARAMETERS = 1;
    private static final int MAC_PARAMS_NONE = 1;
    protected static final String TAG = "ContainerEncryptionParams";
    private static final String TO_STRING_PREFIX = "ContainerEncryptionParams{";
    private final long mAuthenticatedDataStart;
    private final long mDataEnd;
    private final long mEncryptedDataStart;
    private final String mEncryptionAlgorithm;
    private final SecretKey mEncryptionKey;
    private final IvParameterSpec mEncryptionSpec;
    private final String mMacAlgorithm;
    private final SecretKey mMacKey;
    private final AlgorithmParameterSpec mMacSpec;
    private final byte mMacTag[];

}
