// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.*;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;

public class MusicSearchProvider {
    public static class MusicMeta
        implements Parcelable {
        public static class Builder {

            public MusicMeta create() {
                return new MusicMeta(mLocalId, mOnlineId, mTitle, mData, mArtistName, mAlbumName, mDuartion, mFlag);
            }

            public Builder setAlbumName(String s) {
                mAlbumName = s;
                return this;
            }

            public Builder setArtistName(String s) {
                mArtistName = s;
                return this;
            }

            public Builder setData(String s) {
                mData = s;
                return this;
            }

            public Builder setDuration(long l) {
                mDuartion = l;
                return this;
            }

            public Builder setFlag(int i) {
                mFlag = i;
                return this;
            }

            public Builder setLocalId(long l) {
                mLocalId = l;
                return this;
            }

            public Builder setOnlineId(String s) {
                mOnlineId = s;
                return this;
            }

            public Builder setTitle(String s) {
                mTitle = s;
                return this;
            }

            public String mAlbumName;
            public String mArtistName;
            public String mData;
            public long mDuartion;
            public int mFlag;
            public long mLocalId;
            public String mOnlineId;
            public String mTitle;

            public Builder() {
                mLocalId = -1L;
                mOnlineId = null;
                mTitle = null;
                mData = null;
                mArtistName = null;
                mAlbumName = null;
                mDuartion = 0L;
                mFlag = 0;
            }
        }

        public static interface Flag {

            public static final int FILTERED = 1;
            public static final int NONE;
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
            if(!(obj instanceof MusicMeta)) {
                flag = false;
            } else {
                MusicMeta musicmeta = (MusicMeta)obj;
                if(mLocalId != musicmeta.mLocalId || mDuartion != musicmeta.mDuartion || mFlag != musicmeta.mFlag || !TextUtils.equals(mOnlineId, musicmeta.mOnlineId) || !TextUtils.equals(mTitle, musicmeta.mTitle) || !TextUtils.equals(mData, musicmeta.mData) || !TextUtils.equals(mArtistName, musicmeta.mArtistName) || !TextUtils.equals(mAlbumName, musicmeta.mAlbumName))
                    flag = false;
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        public int hashCode() {
            int i = (int)mLocalId;
            int j;
            if(mOnlineId != null)
                j = mOnlineId.hashCode();
            else
                j = 0;
            return j + i;
        }

        public boolean isOnline() {
            boolean flag;
            if(mOnlineId != null)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(mLocalId);
            parcel.writeString(mOnlineId);
            parcel.writeString(mTitle);
            parcel.writeString(mData);
            parcel.writeString(mArtistName);
            parcel.writeString(mAlbumName);
            parcel.writeLong(mDuartion);
            parcel.writeInt(mFlag);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public MusicMeta createFromParcel(Parcel parcel) {
                return new MusicMeta(parcel);
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

            public MusicMeta[] newArray(int i) {
                return new MusicMeta[i];
            }

        };
        public final String mAlbumName;
        public final String mArtistName;
        public final String mData;
        public final long mDuartion;
        public final int mFlag;
        public final long mLocalId;
        public final String mOnlineId;
        public final String mTitle;


        public MusicMeta(long l, String s, String s1, String s2, String s3, String s4, 
                long l1, int i) {
            mLocalId = l;
            mOnlineId = s;
            mTitle = s1;
            mData = s2;
            mArtistName = s3;
            mAlbumName = s4;
            mDuartion = l1;
            mFlag = i;
        }

        MusicMeta(Parcel parcel) {
            mLocalId = parcel.readLong();
            mOnlineId = parcel.readString();
            mTitle = parcel.readString();
            mData = parcel.readString();
            mArtistName = parcel.readString();
            mAlbumName = parcel.readString();
            mDuartion = parcel.readLong();
            mFlag = parcel.readInt();
        }
    }

    public static class MusicSearchResult
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            boolean flag = true;
            if(this != obj) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            if(!(obj instanceof MusicSearchResult)) {
                flag = false;
            } else {
                MusicSearchResult musicsearchresult = (MusicSearchResult)obj;
                if(mType != musicsearchresult.mType || !Arrays.equals(mKeys, musicsearchresult.mKeys) || !Arrays.equals(mLocalResult, musicsearchresult.mLocalResult) || !Arrays.equals(mOnlineResult, musicsearchresult.mOnlineResult))
                    flag = false;
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        public int getCount() {
            return localCount() + onlineCount();
        }

        public int hashCode() {
            int i = 0;
            if(mKeys != null) {
                int j = 0;
                String as[] = mKeys;
                int k = as.length;
                int l = 0;
                while(l < k)  {
                    String s = as[l];
                    int i1 = j * 31;
                    int j1;
                    if(s == null)
                        j1 = 0;
                    else
                        j1 = s.hashCode();
                    j = i1 + j1;
                    l++;
                }
                i = j;
            }
            return i;
        }

        public int localCount() {
            int i;
            if(mLocalResult != null)
                i = mLocalResult.length;
            else
                i = 0;
            return i;
        }

        public MusicMeta localResult(int i) {
            return mLocalResult[i];
        }

        public MusicMeta[] localResult() {
            MusicMeta amusicmeta[] = null;
            if(mLocalResult != null) {
                amusicmeta = new MusicMeta[mLocalResult.length];
                System.arraycopy(mLocalResult, 0, amusicmeta, 0, mLocalResult.length);
            }
            return amusicmeta;
        }

        public int onlineCount() {
            int i;
            if(mOnlineResult != null)
                i = mOnlineResult.length;
            else
                i = 0;
            return i;
        }

        public MusicMeta onlineResult(int i) {
            return mOnlineResult[i];
        }

        public MusicMeta[] onlineResult() {
            MusicMeta amusicmeta[] = null;
            if(mOnlineResult != null) {
                amusicmeta = new MusicMeta[mOnlineResult.length];
                System.arraycopy(mOnlineResult, 0, amusicmeta, 0, mOnlineResult.length);
            }
            return amusicmeta;
        }

        public MusicMeta[] result() {
            MusicMeta amusicmeta[];
            if(mLocalResult != null && mOnlineResult != null) {
                amusicmeta = new MusicMeta[mLocalResult.length + mOnlineResult.length];
                System.arraycopy(mLocalResult, 0, amusicmeta, 0, mLocalResult.length);
                System.arraycopy(mOnlineResult, 0, amusicmeta, mLocalResult.length, mOnlineResult.length);
            } else
            if(mOnlineResult != null)
                amusicmeta = onlineResult();
            else
            if(mLocalResult != null)
                amusicmeta = localResult();
            else
                amusicmeta = null;
            return amusicmeta;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedArray(mLocalResult, i);
            parcel.writeTypedArray(mOnlineResult, i);
            parcel.writeStringArray(mKeys);
            parcel.writeInt(mType);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public MusicSearchResult createFromParcel(Parcel parcel) {
                return new MusicSearchResult(parcel);
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

            public MusicSearchResult[] newArray(int i) {
                return new MusicSearchResult[i];
            }

        };
        public final String mKeys[];
        private final MusicMeta mLocalResult[];
        private final MusicMeta mOnlineResult[];
        public final int mType;


        MusicSearchResult(Parcel parcel) {
            mLocalResult = (MusicMeta[])parcel.createTypedArray(MusicMeta.CREATOR);
            mOnlineResult = (MusicMeta[])parcel.createTypedArray(MusicMeta.CREATOR);
            mKeys = parcel.readStringArray();
            mType = parcel.readInt();
        }

        public MusicSearchResult(MusicMeta amusicmeta[], MusicMeta amusicmeta1[], String as[], int i) {
            mLocalResult = amusicmeta;
            mOnlineResult = amusicmeta1;
            mKeys = as;
            mType = i;
        }
    }


    public MusicSearchProvider() {
    }

    public static boolean isValidType(int i) {
        boolean flag;
        if((i & -4) == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static int parseIntFromUri(Uri uri, String s, int i) {
        int j;
        String s1;
        j = i;
        if(uri == null)
            break MISSING_BLOCK_LABEL_31;
        s1 = uri.getQueryParameter(s);
        if(s1 == null)
            break MISSING_BLOCK_LABEL_31;
        int k = Integer.valueOf(s1).intValue();
        j = k;
_L2:
        return j;
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.e(TAG, "", numberformatexception);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static int parseLimitFromUri(Uri uri) {
        return parseIntFromUri(uri, "limit", -1);
    }

    public static int parseTypeFromUri(Uri uri) {
        return parseIntFromUri(uri, "type", 3);
    }

    public static MusicSearchResult query(Context context, int i, String as[], int j) {
        Bundle bundle;
        Cursor cursor;
        if(!isValidType(i))
            throw new IllegalArgumentException((new StringBuilder()).append("bad type: ").append(i).toString());
        bundle = null;
        android.net.Uri.Builder builder = URI.buildUpon();
        builder.appendQueryParameter("type", String.valueOf(i)).appendQueryParameter("limit", String.valueOf(j));
        cursor = context.getContentResolver().query(builder.build(), null, null, as, null);
        if(cursor == null)
            break MISSING_BLOCK_LABEL_109;
        Bundle bundle1 = cursor.getExtras();
        bundle = bundle1;
        cursor.close();
        MusicSearchResult musicsearchresult;
        Exception exception;
        if(bundle != null)
            musicsearchresult = (MusicSearchResult)bundle.getParcelable("result_key");
        else
            musicsearchresult = null;
        return musicsearchresult;
        exception;
        cursor.close();
        throw exception;
    }

    public static final int INDEX_ALBUM = 2;
    public static final int INDEX_ARTIST = 1;
    public static final int INDEX_TRACK = 0;
    public static final String KEY_RESULT = "result_key";
    public static final String PATH = "search";
    public static final String QUERY_PARAM_LIMIT = "limit";
    public static final String QUERY_PARAM_TYPE = "type";
    public static final String SEARCH_COLS[];
    static final String TAG = miui/provider/MusicSearchProvider.getName();
    public static final int TYPE_ALL = 3;
    public static final int TYPE_MEDIA_PROVIDER = 1;
    public static final int TYPE_ONLINE = 2;
    public static final Uri URI = Uri.parse("content://com.miui.player/search");

    static  {
        String as[] = new String[3];
        as[0] = "title";
        as[1] = "artist";
        as[2] = "album";
        SEARCH_COLS = as;
    }
}
