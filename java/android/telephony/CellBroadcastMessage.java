// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;

// Referenced classes of package android.telephony:
//            SmsCbMessage, SmsCbLocation, SmsCbEtwsInfo, SmsCbCmasInfo

public class CellBroadcastMessage
    implements Parcelable {

    private CellBroadcastMessage(Parcel parcel) {
        mSmsCbMessage = new SmsCbMessage(parcel);
        mDeliveryTime = parcel.readLong();
        boolean flag;
        if(parcel.readInt() != 0)
            flag = true;
        else
            flag = false;
        mIsRead = flag;
    }


    public CellBroadcastMessage(SmsCbMessage smscbmessage) {
        mSmsCbMessage = smscbmessage;
        mDeliveryTime = System.currentTimeMillis();
        mIsRead = false;
    }

    private CellBroadcastMessage(SmsCbMessage smscbmessage, long l, boolean flag) {
        mSmsCbMessage = smscbmessage;
        mDeliveryTime = l;
        mIsRead = flag;
    }

    public static CellBroadcastMessage createFromCursor(Cursor cursor) {
        int i = cursor.getInt(cursor.getColumnIndexOrThrow("geo_scope"));
        int j = cursor.getInt(cursor.getColumnIndexOrThrow("serial_number"));
        int k = cursor.getInt(cursor.getColumnIndexOrThrow("service_category"));
        String s = cursor.getString(cursor.getColumnIndexOrThrow("language"));
        String s1 = cursor.getString(cursor.getColumnIndexOrThrow("body"));
        int l = cursor.getInt(cursor.getColumnIndexOrThrow("format"));
        int i1 = cursor.getInt(cursor.getColumnIndexOrThrow("priority"));
        int j1 = cursor.getColumnIndex("plmn");
        String s2;
        int k1;
        int l1;
        int i2;
        int j2;
        SmsCbLocation smscblocation;
        int k2;
        SmsCbEtwsInfo smscbetwsinfo;
        int l2;
        SmsCbCmasInfo smscbcmasinfo;
        boolean flag;
        if(j1 != -1 && !cursor.isNull(j1))
            s2 = cursor.getString(j1);
        else
            s2 = null;
        k1 = cursor.getColumnIndex("lac");
        if(k1 != -1 && !cursor.isNull(k1))
            l1 = cursor.getInt(k1);
        else
            l1 = -1;
        i2 = cursor.getColumnIndex("cid");
        if(i2 != -1 && !cursor.isNull(i2))
            j2 = cursor.getInt(i2);
        else
            j2 = -1;
        smscblocation = new SmsCbLocation(s2, l1, j2);
        k2 = cursor.getColumnIndex("etws_warning_type");
        if(k2 != -1 && !cursor.isNull(k2)) {
            int i6 = cursor.getInt(k2);
            smscbetwsinfo = new SmsCbEtwsInfo(i6, false, false, null);
        } else {
            smscbetwsinfo = null;
        }
        l2 = cursor.getColumnIndex("cmas_message_class");
        if(l2 != -1 && !cursor.isNull(l2)) {
            int i3 = cursor.getInt(l2);
            int j3 = cursor.getColumnIndex("cmas_category");
            SmsCbMessage smscbmessage;
            long l3;
            CellBroadcastMessage cellbroadcastmessage;
            int k3;
            int i4;
            int j4;
            int k4;
            int l4;
            int i5;
            int j5;
            int k5;
            int l5;
            if(j3 != -1 && !cursor.isNull(j3))
                k3 = cursor.getInt(j3);
            else
                k3 = -1;
            i4 = cursor.getColumnIndex("cmas_response_type");
            if(i4 != -1 && !cursor.isNull(i4))
                j4 = cursor.getInt(i4);
            else
                j4 = -1;
            k4 = cursor.getColumnIndex("cmas_severity");
            if(k4 != -1 && !cursor.isNull(k4))
                l4 = cursor.getInt(k4);
            else
                l4 = -1;
            i5 = cursor.getColumnIndex("cmas_urgency");
            if(i5 != -1 && !cursor.isNull(i5))
                j5 = cursor.getInt(i5);
            else
                j5 = -1;
            k5 = cursor.getColumnIndex("cmas_certainty");
            if(k5 != -1 && !cursor.isNull(k5))
                l5 = cursor.getInt(k5);
            else
                l5 = -1;
            smscbcmasinfo = new SmsCbCmasInfo(i3, k3, j4, l4, j5, l5);
        } else {
            smscbcmasinfo = null;
        }
        smscbmessage = new SmsCbMessage(l, i, j, smscblocation, k, s, s1, i1, smscbetwsinfo, smscbcmasinfo);
        l3 = cursor.getLong(cursor.getColumnIndexOrThrow("date"));
        if(cursor.getInt(cursor.getColumnIndexOrThrow("read")) != 0)
            flag = true;
        else
            flag = false;
        cellbroadcastmessage = new CellBroadcastMessage(smscbmessage, l3, flag);
        return cellbroadcastmessage;
    }

    public int describeContents() {
        return 0;
    }

    public int getCmasMessageClass() {
        int i;
        if(mSmsCbMessage.isCmasMessage())
            i = mSmsCbMessage.getCmasWarningInfo().getMessageClass();
        else
            i = -1;
        return i;
    }

    public SmsCbCmasInfo getCmasWarningInfo() {
        return mSmsCbMessage.getCmasWarningInfo();
    }

    public ContentValues getContentValues() {
        ContentValues contentvalues = new ContentValues(16);
        SmsCbMessage smscbmessage = mSmsCbMessage;
        contentvalues.put("geo_scope", Integer.valueOf(smscbmessage.getGeographicalScope()));
        SmsCbLocation smscblocation = smscbmessage.getLocation();
        if(smscblocation.getPlmn() != null)
            contentvalues.put("plmn", smscblocation.getPlmn());
        if(smscblocation.getLac() != -1)
            contentvalues.put("lac", Integer.valueOf(smscblocation.getLac()));
        if(smscblocation.getCid() != -1)
            contentvalues.put("cid", Integer.valueOf(smscblocation.getCid()));
        contentvalues.put("serial_number", Integer.valueOf(smscbmessage.getSerialNumber()));
        contentvalues.put("service_category", Integer.valueOf(smscbmessage.getServiceCategory()));
        contentvalues.put("language", smscbmessage.getLanguageCode());
        contentvalues.put("body", smscbmessage.getMessageBody());
        contentvalues.put("date", Long.valueOf(mDeliveryTime));
        contentvalues.put("read", Boolean.valueOf(mIsRead));
        contentvalues.put("format", Integer.valueOf(smscbmessage.getMessageFormat()));
        contentvalues.put("priority", Integer.valueOf(smscbmessage.getMessagePriority()));
        SmsCbEtwsInfo smscbetwsinfo = mSmsCbMessage.getEtwsWarningInfo();
        if(smscbetwsinfo != null)
            contentvalues.put("etws_warning_type", Integer.valueOf(smscbetwsinfo.getWarningType()));
        SmsCbCmasInfo smscbcmasinfo = mSmsCbMessage.getCmasWarningInfo();
        if(smscbcmasinfo != null) {
            contentvalues.put("cmas_message_class", Integer.valueOf(smscbcmasinfo.getMessageClass()));
            contentvalues.put("cmas_category", Integer.valueOf(smscbcmasinfo.getCategory()));
            contentvalues.put("cmas_response_type", Integer.valueOf(smscbcmasinfo.getResponseType()));
            contentvalues.put("cmas_severity", Integer.valueOf(smscbcmasinfo.getSeverity()));
            contentvalues.put("cmas_urgency", Integer.valueOf(smscbcmasinfo.getUrgency()));
            contentvalues.put("cmas_certainty", Integer.valueOf(smscbcmasinfo.getCertainty()));
        }
        return contentvalues;
    }

    public String getDateString(Context context) {
        return DateUtils.formatDateTime(context, mDeliveryTime, 0x80b11);
    }

    public long getDeliveryTime() {
        return mDeliveryTime;
    }

    public SmsCbEtwsInfo getEtwsWarningInfo() {
        return mSmsCbMessage.getEtwsWarningInfo();
    }

    public String getLanguageCode() {
        return mSmsCbMessage.getLanguageCode();
    }

    public String getMessageBody() {
        return mSmsCbMessage.getMessageBody();
    }

    public int getSerialNumber() {
        return mSmsCbMessage.getSerialNumber();
    }

    public int getServiceCategory() {
        return mSmsCbMessage.getServiceCategory();
    }

    public String getSpokenDateString(Context context) {
        return DateUtils.formatDateTime(context, mDeliveryTime, 17);
    }

    public boolean isCmasMessage() {
        return mSmsCbMessage.isCmasMessage();
    }

    public boolean isEmergencyAlertMessage() {
        boolean flag = false;
        if(mSmsCbMessage.isEmergencyMessage()) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        SmsCbCmasInfo smscbcmasinfo = mSmsCbMessage.getCmasWarningInfo();
        if(smscbcmasinfo == null || smscbcmasinfo.getMessageClass() != 3)
            flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean isEtwsEmergencyUserAlert() {
        SmsCbEtwsInfo smscbetwsinfo = mSmsCbMessage.getEtwsWarningInfo();
        boolean flag;
        if(smscbetwsinfo != null && smscbetwsinfo.isEmergencyUserAlert())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isEtwsMessage() {
        return mSmsCbMessage.isEtwsMessage();
    }

    public boolean isEtwsPopupAlert() {
        SmsCbEtwsInfo smscbetwsinfo = mSmsCbMessage.getEtwsWarningInfo();
        boolean flag;
        if(smscbetwsinfo != null && smscbetwsinfo.isPopupAlert())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isEtwsTestMessage() {
        SmsCbEtwsInfo smscbetwsinfo = mSmsCbMessage.getEtwsWarningInfo();
        boolean flag;
        if(smscbetwsinfo != null && smscbetwsinfo.getWarningType() == 3)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isPublicAlertMessage() {
        return mSmsCbMessage.isEmergencyMessage();
    }

    public boolean isRead() {
        return mIsRead;
    }

    public void setIsRead(boolean flag) {
        mIsRead = flag;
    }

    public void writeToParcel(Parcel parcel, int i) {
        mSmsCbMessage.writeToParcel(parcel, i);
        parcel.writeLong(mDeliveryTime);
        int j;
        if(mIsRead)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CellBroadcastMessage createFromParcel(Parcel parcel) {
            return new CellBroadcastMessage(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public CellBroadcastMessage[] newArray(int i) {
            return new CellBroadcastMessage[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final String SMS_CB_MESSAGE_EXTRA = "com.android.cellbroadcastreceiver.SMS_CB_MESSAGE";
    private final long mDeliveryTime;
    private boolean mIsRead;
    private final SmsCbMessage mSmsCbMessage;

}
