// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.*;

// Referenced classes of package android.content:
//            ContentValues, ContentProviderResult, ContentUris, OperationApplicationException, 
//            ContentProvider

public class ContentProviderOperation
    implements Parcelable {
    public static class Builder {

        public ContentProviderOperation build() {
            if(mType == 2 && (mValues == null || mValues.size() == 0) && (mValuesBackReferences == null || mValuesBackReferences.size() == 0))
                throw new IllegalArgumentException("Empty values");
            if(mType == 4 && (mValues == null || mValues.size() == 0) && (mValuesBackReferences == null || mValuesBackReferences.size() == 0) && mExpectedCount == null)
                throw new IllegalArgumentException("Empty values");
            else
                return new ContentProviderOperation(this);
        }

        public Builder withExpectedCount(int i) {
            if(mType != 2 && mType != 3 && mType != 4) {
                throw new IllegalArgumentException("only updates, deletes, and asserts can have expected counts");
            } else {
                mExpectedCount = Integer.valueOf(i);
                return this;
            }
        }

        public Builder withSelection(String s, String as[]) {
            if(mType != 2 && mType != 3 && mType != 4)
                throw new IllegalArgumentException("only updates, deletes, and asserts can have selections");
            mSelection = s;
            if(as == null) {
                mSelectionArgs = null;
            } else {
                mSelectionArgs = new String[as.length];
                System.arraycopy(as, 0, mSelectionArgs, 0, as.length);
            }
            return this;
        }

        public Builder withSelectionBackReference(int i, int j) {
            if(mType != 2 && mType != 3 && mType != 4)
                throw new IllegalArgumentException("only updates, deletes, and asserts can have selection back-references");
            if(mSelectionArgsBackReferences == null)
                mSelectionArgsBackReferences = new HashMap();
            mSelectionArgsBackReferences.put(Integer.valueOf(i), Integer.valueOf(j));
            return this;
        }

        public Builder withValue(String s, Object obj) {
            if(mType != 1 && mType != 2 && mType != 4)
                throw new IllegalArgumentException("only inserts and updates can have values");
            if(mValues == null)
                mValues = new ContentValues();
            if(obj == null)
                mValues.putNull(s);
            else
            if(obj instanceof String)
                mValues.put(s, (String)obj);
            else
            if(obj instanceof Byte)
                mValues.put(s, (Byte)obj);
            else
            if(obj instanceof Short)
                mValues.put(s, (Short)obj);
            else
            if(obj instanceof Integer)
                mValues.put(s, (Integer)obj);
            else
            if(obj instanceof Long)
                mValues.put(s, (Long)obj);
            else
            if(obj instanceof Float)
                mValues.put(s, (Float)obj);
            else
            if(obj instanceof Double)
                mValues.put(s, (Double)obj);
            else
            if(obj instanceof Boolean)
                mValues.put(s, (Boolean)obj);
            else
            if(obj instanceof byte[])
                mValues.put(s, (byte[])(byte[])obj);
            else
                throw new IllegalArgumentException((new StringBuilder()).append("bad value type: ").append(obj.getClass().getName()).toString());
            return this;
        }

        public Builder withValueBackReference(String s, int i) {
            if(mType != 1 && mType != 2 && mType != 4)
                throw new IllegalArgumentException("only inserts, updates, and asserts can have value back-references");
            if(mValuesBackReferences == null)
                mValuesBackReferences = new ContentValues();
            mValuesBackReferences.put(s, Integer.valueOf(i));
            return this;
        }

        public Builder withValueBackReferences(ContentValues contentvalues) {
            if(mType != 1 && mType != 2 && mType != 4) {
                throw new IllegalArgumentException("only inserts, updates, and asserts can have value back-references");
            } else {
                mValuesBackReferences = contentvalues;
                return this;
            }
        }

        public Builder withValues(ContentValues contentvalues) {
            if(mType != 1 && mType != 2 && mType != 4)
                throw new IllegalArgumentException("only inserts, updates, and asserts can have values");
            if(mValues == null)
                mValues = new ContentValues();
            mValues.putAll(contentvalues);
            return this;
        }

        public Builder withYieldAllowed(boolean flag) {
            mYieldAllowed = flag;
            return this;
        }

        private Integer mExpectedCount;
        private String mSelection;
        private String mSelectionArgs[];
        private Map mSelectionArgsBackReferences;
        private final int mType;
        private final Uri mUri;
        private ContentValues mValues;
        private ContentValues mValuesBackReferences;
        private boolean mYieldAllowed;










        private Builder(int i, Uri uri) {
            if(uri == null) {
                throw new IllegalArgumentException("uri must not be null");
            } else {
                mType = i;
                mUri = uri;
                return;
            }
        }

    }


    private ContentProviderOperation(Builder builder) {
        mType = builder.mType;
        mUri = builder.mUri;
        mValues = builder.mValues;
        mSelection = builder.mSelection;
        mSelectionArgs = builder.mSelectionArgs;
        mExpectedCount = builder.mExpectedCount;
        mSelectionArgsBackReferences = builder.mSelectionArgsBackReferences;
        mValuesBackReferences = builder.mValuesBackReferences;
        mYieldAllowed = builder.mYieldAllowed;
    }


    private ContentProviderOperation(Parcel parcel) {
        HashMap hashmap = null;
        super();
        mType = parcel.readInt();
        mUri = (Uri)Uri.CREATOR.createFromParcel(parcel);
        ContentValues contentvalues;
        String s;
        String as[];
        Integer integer;
        ContentValues contentvalues1;
        if(parcel.readInt() != 0)
            contentvalues = (ContentValues)ContentValues.CREATOR.createFromParcel(parcel);
        else
            contentvalues = null;
        mValues = contentvalues;
        if(parcel.readInt() != 0)
            s = parcel.readString();
        else
            s = null;
        mSelection = s;
        if(parcel.readInt() != 0)
            as = parcel.readStringArray();
        else
            as = null;
        mSelectionArgs = as;
        if(parcel.readInt() != 0)
            integer = Integer.valueOf(parcel.readInt());
        else
            integer = null;
        mExpectedCount = integer;
        if(parcel.readInt() != 0)
            contentvalues1 = (ContentValues)ContentValues.CREATOR.createFromParcel(parcel);
        else
            contentvalues1 = null;
        mValuesBackReferences = contentvalues1;
        if(parcel.readInt() != 0)
            hashmap = new HashMap();
        mSelectionArgsBackReferences = hashmap;
        if(mSelectionArgsBackReferences != null) {
            int i = parcel.readInt();
            for(int j = 0; j < i; j++)
                mSelectionArgsBackReferences.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));

        }
        boolean flag;
        if(parcel.readInt() != 0)
            flag = true;
        else
            flag = false;
        mYieldAllowed = flag;
    }


    private long backRefToValue(ContentProviderResult acontentproviderresult[], int i, Integer integer) {
        if(integer.intValue() >= i) {
            Log.e("ContentProviderOperation", toString());
            throw new ArrayIndexOutOfBoundsException((new StringBuilder()).append("asked for back ref ").append(integer).append(" but there are only ").append(i).append(" back refs").toString());
        }
        ContentProviderResult contentproviderresult = acontentproviderresult[integer.intValue()];
        long l;
        if(contentproviderresult.uri != null)
            l = ContentUris.parseId(contentproviderresult.uri);
        else
            l = contentproviderresult.count.intValue();
        return l;
    }

    public static Builder newAssertQuery(Uri uri) {
        return new Builder(4, uri);
    }

    public static Builder newDelete(Uri uri) {
        return new Builder(3, uri);
    }

    public static Builder newInsert(Uri uri) {
        return new Builder(1, uri);
    }

    public static Builder newUpdate(Uri uri) {
        return new Builder(2, uri);
    }

    public ContentProviderResult apply(ContentProvider contentprovider, ContentProviderResult acontentproviderresult[], int i) throws OperationApplicationException {
        ContentValues contentvalues;
        String as[];
        contentvalues = resolveValueBackReferences(acontentproviderresult, i);
        as = resolveSelectionArgsBackReferences(acontentproviderresult, i);
        if(mType != 1) goto _L2; else goto _L1
_L1:
        ContentProviderResult contentproviderresult;
        Uri uri = contentprovider.insert(mUri, contentvalues);
        if(uri == null)
            throw new OperationApplicationException("insert failed");
        contentproviderresult = new ContentProviderResult(uri);
_L13:
        return contentproviderresult;
_L2:
        if(mType != 3) goto _L4; else goto _L3
_L3:
        int j = contentprovider.delete(mUri, mSelection, as);
_L11:
        if(mExpectedCount != null && mExpectedCount.intValue() != j) {
            Log.e("ContentProviderOperation", toString());
            throw new OperationApplicationException((new StringBuilder()).append("wrong number of rows: ").append(j).toString());
        }
        break MISSING_BLOCK_LABEL_484;
_L4:
        String as1[];
        Cursor cursor;
        if(mType == 2) {
            j = contentprovider.update(mUri, contentvalues, mSelection, as);
            continue; /* Loop/switch isn't completed */
        }
        if(mType != 4)
            break; /* Loop/switch isn't completed */
        as1 = null;
        if(contentvalues != null) {
            ArrayList arraylist = new ArrayList();
            for(Iterator iterator = contentvalues.valueSet().iterator(); iterator.hasNext(); arraylist.add(((java.util.Map.Entry)iterator.next()).getKey()));
            as1 = (String[])arraylist.toArray(new String[arraylist.size()]);
        }
        cursor = contentprovider.query(mUri, as1, mSelection, as, null);
        j = cursor.getCount();
        if(as1 == null) goto _L6; else goto _L5
_L5:
        int k;
        if(!cursor.moveToNext())
            break; /* Loop/switch isn't completed */
        k = 0;
_L9:
        if(k >= as1.length)
            break; /* Loop/switch isn't completed */
        String s = cursor.getString(k);
        String s1 = contentvalues.getAsString(as1[k]);
        if(!TextUtils.equals(s, s1)) {
            Log.e("ContentProviderOperation", toString());
            throw new OperationApplicationException((new StringBuilder()).append("Found value ").append(s).append(" when expected ").append(s1).append(" for column ").append(as1[k]).toString());
        }
          goto _L7
        Exception exception;
        exception;
        cursor.close();
        throw exception;
_L7:
        k++;
        if(true) goto _L9; else goto _L8
_L8:
        if(true) goto _L5; else goto _L6
_L6:
        cursor.close();
        if(true) goto _L11; else goto _L10
_L10:
        Log.e("ContentProviderOperation", toString());
        throw new IllegalStateException((new StringBuilder()).append("bad type, ").append(mType).toString());
        contentproviderresult = new ContentProviderResult(j);
        if(true) goto _L13; else goto _L12
_L12:
    }

    public int describeContents() {
        return 0;
    }

    public int getType() {
        return mType;
    }

    public Uri getUri() {
        return mUri;
    }

    public boolean isReadOperation() {
        boolean flag;
        if(mType == 4)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isWriteOperation() {
        boolean flag = true;
        if(mType != 3 && mType != flag && mType != 2)
            flag = false;
        return flag;
    }

    public boolean isYieldAllowed() {
        return mYieldAllowed;
    }

    public String[] resolveSelectionArgsBackReferences(ContentProviderResult acontentproviderresult[], int i) {
        String as[];
        if(mSelectionArgsBackReferences == null) {
            as = mSelectionArgs;
        } else {
            as = new String[mSelectionArgs.length];
            System.arraycopy(mSelectionArgs, 0, as, 0, mSelectionArgs.length);
            Iterator iterator = mSelectionArgsBackReferences.entrySet().iterator();
            while(iterator.hasNext())  {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                Integer integer = (Integer)entry.getKey();
                int j = ((Integer)entry.getValue()).intValue();
                as[integer.intValue()] = String.valueOf(backRefToValue(acontentproviderresult, i, Integer.valueOf(j)));
            }
        }
        return as;
    }

    public ContentValues resolveValueBackReferences(ContentProviderResult acontentproviderresult[], int i) {
        ContentValues contentvalues;
        if(mValuesBackReferences == null) {
            contentvalues = mValues;
        } else {
            Iterator iterator;
            if(mValues == null)
                contentvalues = new ContentValues();
            else
                contentvalues = new ContentValues(mValues);
            iterator = mValuesBackReferences.valueSet().iterator();
            while(iterator.hasNext())  {
                String s = (String)((java.util.Map.Entry)iterator.next()).getKey();
                Integer integer = mValuesBackReferences.getAsInteger(s);
                if(integer == null) {
                    Log.e("ContentProviderOperation", toString());
                    throw new IllegalArgumentException((new StringBuilder()).append("values backref ").append(s).append(" is not an integer").toString());
                }
                contentvalues.put(s, Long.valueOf(backRefToValue(acontentproviderresult, i, integer)));
            }
        }
        return contentvalues;
    }

    public String toString() {
        return (new StringBuilder()).append("mType: ").append(mType).append(", mUri: ").append(mUri).append(", mSelection: ").append(mSelection).append(", mExpectedCount: ").append(mExpectedCount).append(", mYieldAllowed: ").append(mYieldAllowed).append(", mValues: ").append(mValues).append(", mValuesBackReferences: ").append(mValuesBackReferences).append(", mSelectionArgsBackReferences: ").append(mSelectionArgsBackReferences).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mType);
        Uri.writeToParcel(parcel, mUri);
        if(mValues != null) {
            parcel.writeInt(1);
            mValues.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if(mSelection != null) {
            parcel.writeInt(1);
            parcel.writeString(mSelection);
        } else {
            parcel.writeInt(0);
        }
        if(mSelectionArgs != null) {
            parcel.writeInt(1);
            parcel.writeStringArray(mSelectionArgs);
        } else {
            parcel.writeInt(0);
        }
        if(mExpectedCount != null) {
            parcel.writeInt(1);
            parcel.writeInt(mExpectedCount.intValue());
        } else {
            parcel.writeInt(0);
        }
        if(mValuesBackReferences != null) {
            parcel.writeInt(1);
            mValuesBackReferences.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if(mSelectionArgsBackReferences != null) {
            parcel.writeInt(1);
            parcel.writeInt(mSelectionArgsBackReferences.size());
            java.util.Map.Entry entry;
            for(Iterator iterator = mSelectionArgsBackReferences.entrySet().iterator(); iterator.hasNext(); parcel.writeInt(((Integer)entry.getValue()).intValue())) {
                entry = (java.util.Map.Entry)iterator.next();
                parcel.writeInt(((Integer)entry.getKey()).intValue());
            }

        } else {
            parcel.writeInt(0);
        }
        int j;
        if(mYieldAllowed)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ContentProviderOperation createFromParcel(Parcel parcel) {
            return new ContentProviderOperation(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ContentProviderOperation[] newArray(int i) {
            return new ContentProviderOperation[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final String TAG = "ContentProviderOperation";
    public static final int TYPE_ASSERT = 4;
    public static final int TYPE_DELETE = 3;
    public static final int TYPE_INSERT = 1;
    public static final int TYPE_UPDATE = 2;
    private final Integer mExpectedCount;
    private final String mSelection;
    private final String mSelectionArgs[];
    private final Map mSelectionArgsBackReferences;
    private final int mType;
    private final Uri mUri;
    private final ContentValues mValues;
    private final ContentValues mValuesBackReferences;
    private final boolean mYieldAllowed;

}
