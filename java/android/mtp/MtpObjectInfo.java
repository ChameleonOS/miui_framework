// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.mtp;


public final class MtpObjectInfo {

    private MtpObjectInfo() {
    }

    public final int getAssociationDesc() {
        return mAssociationDesc;
    }

    public final int getAssociationType() {
        return mAssociationType;
    }

    public final int getCompressedSize() {
        return mCompressedSize;
    }

    public final long getDateCreated() {
        return mDateCreated;
    }

    public final long getDateModified() {
        return mDateModified;
    }

    public final int getFormat() {
        return mFormat;
    }

    public final int getImagePixDepth() {
        return mImagePixDepth;
    }

    public final int getImagePixHeight() {
        return mImagePixHeight;
    }

    public final int getImagePixWidth() {
        return mImagePixWidth;
    }

    public final String getKeywords() {
        return mKeywords;
    }

    public final String getName() {
        return mName;
    }

    public final int getObjectHandle() {
        return mHandle;
    }

    public final int getParent() {
        return mParent;
    }

    public final int getProtectionStatus() {
        return mProtectionStatus;
    }

    public final int getSequenceNumber() {
        return mSequenceNumber;
    }

    public final int getStorageId() {
        return mStorageId;
    }

    public final int getThumbCompressedSize() {
        return mThumbCompressedSize;
    }

    public final int getThumbFormat() {
        return mThumbFormat;
    }

    public final int getThumbPixHeight() {
        return mThumbPixHeight;
    }

    public final int getThumbPixWidth() {
        return mThumbPixWidth;
    }

    private int mAssociationDesc;
    private int mAssociationType;
    private int mCompressedSize;
    private long mDateCreated;
    private long mDateModified;
    private int mFormat;
    private int mHandle;
    private int mImagePixDepth;
    private int mImagePixHeight;
    private int mImagePixWidth;
    private String mKeywords;
    private String mName;
    private int mParent;
    private int mProtectionStatus;
    private int mSequenceNumber;
    private int mStorageId;
    private int mThumbCompressedSize;
    private int mThumbFormat;
    private int mThumbPixHeight;
    private int mThumbPixWidth;
}
