// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import com.google.android.mms.InvalidHeaderValueException;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.google.android.mms.pdu:
//            EncodedStringValue

public class PduHeaders {

    public PduHeaders() {
        mHeaderMap = null;
        mHeaderMap = new HashMap();
    }

    protected void appendEncodedStringValue(EncodedStringValue encodedstringvalue, int i) {
        if(encodedstringvalue == null)
            throw new NullPointerException();
        ArrayList arraylist;
        switch(i) {
        default:
            throw new RuntimeException("Invalid header field!");

        case 129: 
        case 130: 
        case 151: 
            arraylist = (ArrayList)mHeaderMap.get(Integer.valueOf(i));
            break;
        }
        if(arraylist == null)
            arraylist = new ArrayList();
        arraylist.add(encodedstringvalue);
        mHeaderMap.put(Integer.valueOf(i), arraylist);
    }

    protected EncodedStringValue getEncodedStringValue(int i) {
        return (EncodedStringValue)mHeaderMap.get(Integer.valueOf(i));
    }

    protected EncodedStringValue[] getEncodedStringValues(int i) {
        ArrayList arraylist = (ArrayList)mHeaderMap.get(Integer.valueOf(i));
        EncodedStringValue aencodedstringvalue[];
        if(arraylist == null)
            aencodedstringvalue = null;
        else
            aencodedstringvalue = (EncodedStringValue[])arraylist.toArray(new EncodedStringValue[arraylist.size()]);
        return aencodedstringvalue;
    }

    protected long getLongInteger(int i) {
        Long long1 = (Long)mHeaderMap.get(Integer.valueOf(i));
        long l;
        if(long1 == null)
            l = -1L;
        else
            l = long1.longValue();
        return l;
    }

    protected int getOctet(int i) {
        Integer integer = (Integer)mHeaderMap.get(Integer.valueOf(i));
        int j;
        if(integer == null)
            j = 0;
        else
            j = integer.intValue();
        return j;
    }

    protected byte[] getTextString(int i) {
        return (byte[])(byte[])mHeaderMap.get(Integer.valueOf(i));
    }

    protected void setEncodedStringValue(EncodedStringValue encodedstringvalue, int i) {
        if(encodedstringvalue == null)
            throw new NullPointerException();
        switch(i) {
        default:
            throw new RuntimeException("Invalid header field!");

        case 137: 
        case 147: 
        case 150: 
        case 154: 
        case 160: 
        case 164: 
        case 166: 
        case 181: 
        case 182: 
            mHeaderMap.put(Integer.valueOf(i), encodedstringvalue);
            break;
        }
    }

    protected void setEncodedStringValues(EncodedStringValue aencodedstringvalue[], int i) {
        if(aencodedstringvalue == null)
            throw new NullPointerException();
        ArrayList arraylist;
        switch(i) {
        default:
            throw new RuntimeException("Invalid header field!");

        case 129: 
        case 130: 
        case 151: 
            arraylist = new ArrayList();
            break;
        }
        for(int j = 0; j < aencodedstringvalue.length; j++)
            arraylist.add(aencodedstringvalue[j]);

        mHeaderMap.put(Integer.valueOf(i), arraylist);
    }

    protected void setLongInteger(long l, int i) {
        switch(i) {
        default:
            throw new RuntimeException("Invalid header field!");

        case 133: 
        case 135: 
        case 136: 
        case 142: 
        case 157: 
        case 159: 
        case 161: 
        case 173: 
        case 175: 
        case 179: 
            mHeaderMap.put(Integer.valueOf(i), Long.valueOf(l));
            break;
        }
    }

    protected void setOctet(int i, int j) throws InvalidHeaderValueException {
        j;
        JVM INSTR tableswitch 134 191: default 248
    //                   134 259
    //                   135 248
    //                   136 248
    //                   137 248
    //                   138 248
    //                   139 248
    //                   140 733
    //                   141 715
    //                   142 248
    //                   143 334
    //                   144 259
    //                   145 259
    //                   146 645
    //                   147 248
    //                   148 259
    //                   149 359
    //                   150 248
    //                   151 248
    //                   152 248
    //                   153 477
    //                   154 248
    //                   155 284
    //                   156 384
    //                   157 248
    //                   158 248
    //                   159 248
    //                   160 248
    //                   161 248
    //                   162 259
    //                   163 409
    //                   164 248
    //                   165 568
    //                   166 248
    //                   167 259
    //                   168 248
    //                   169 259
    //                   170 248
    //                   171 259
    //                   172 248
    //                   173 248
    //                   174 248
    //                   175 248
    //                   176 248
    //                   177 259
    //                   178 248
    //                   179 248
    //                   180 434
    //                   181 248
    //                   182 248
    //                   183 248
    //                   184 248
    //                   185 248
    //                   186 452
    //                   187 259
    //                   188 259
    //                   189 248
    //                   190 248
    //                   191 309;
           goto _L1 _L2 _L1 _L1 _L1 _L1 _L1 _L3 _L4 _L1 _L5 _L2 _L2 _L6 _L1 _L2 _L7 _L1 _L1 _L1 _L8 _L1 _L9 _L10 _L1 _L1 _L1 _L1 _L1 _L2 _L11 _L1 _L12 _L1 _L2 _L1 _L2 _L1 _L2 _L1 _L1 _L1 _L1 _L1 _L2 _L1 _L1 _L13 _L1 _L1 _L1 _L1 _L1 _L14 _L2 _L2 _L1 _L1 _L15
_L1:
        throw new RuntimeException("Invalid header field!");
_L2:
        if(128 != i && 129 != i)
            throw new InvalidHeaderValueException("Invalid Octet value!");
        break; /* Loop/switch isn't completed */
_L9:
        if(128 != i && 129 != i)
            throw new InvalidHeaderValueException("Invalid Octet value!");
        break; /* Loop/switch isn't completed */
_L15:
        if(128 != i && 129 != i)
            throw new InvalidHeaderValueException("Invalid Octet value!");
        break; /* Loop/switch isn't completed */
_L5:
        if(i < 128 || i > 130)
            throw new InvalidHeaderValueException("Invalid Octet value!");
        break; /* Loop/switch isn't completed */
_L7:
        if(i < 128 || i > 135)
            throw new InvalidHeaderValueException("Invalid Octet value!");
        break; /* Loop/switch isn't completed */
_L10:
        if(i < 128 || i > 131)
            throw new InvalidHeaderValueException("Invalid Octet value!");
        break; /* Loop/switch isn't completed */
_L11:
        if(i < 128 || i > 132)
            throw new InvalidHeaderValueException("Invalid Octet value!");
        break; /* Loop/switch isn't completed */
_L13:
        if(128 != i)
            throw new InvalidHeaderValueException("Invalid Octet value!");
        break; /* Loop/switch isn't completed */
_L14:
        if(i < 128 || i > 135)
            throw new InvalidHeaderValueException("Invalid Octet value!");
        break; /* Loop/switch isn't completed */
_L8:
        if(i <= 194 || i >= 224) goto _L17; else goto _L16
_L16:
        i = 192;
_L18:
        mHeaderMap.put(Integer.valueOf(j), Integer.valueOf(i));
        return;
_L17:
        if(i > 227 && i <= 255)
            i = 224;
        else
        if(i < 128 || i > 128 && i < 192 || i > 255)
            i = 224;
        continue; /* Loop/switch isn't completed */
_L12:
        if(i > 193 && i < 224)
            i = 192;
        else
        if(i > 228 && i <= 255)
            i = 224;
        else
        if(i < 128 || i > 128 && i < 192 || i > 255)
            i = 224;
        continue; /* Loop/switch isn't completed */
_L6:
        if(i > 196 && i < 224)
            i = 192;
        else
        if(i > 235 && i <= 255 || i < 128 || i > 136 && i < 192 || i > 255)
            i = 224;
        continue; /* Loop/switch isn't completed */
_L4:
        if(i < 16 || i > 19)
            i = 18;
        if(true) goto _L18; else goto _L3
_L3:
        if(i < 128 || i > 151)
            throw new InvalidHeaderValueException("Invalid Octet value!");
        if(true) goto _L18; else goto _L19
_L19:
    }

    protected void setTextString(byte abyte0[], int i) {
        if(abyte0 == null)
            throw new NullPointerException();
        switch(i) {
        default:
            throw new RuntimeException("Invalid header field!");

        case 131: 
        case 132: 
        case 138: 
        case 139: 
        case 152: 
        case 158: 
        case 183: 
        case 184: 
        case 185: 
        case 189: 
        case 190: 
            mHeaderMap.put(Integer.valueOf(i), abyte0);
            break;
        }
    }

    public static final int ADAPTATION_ALLOWED = 188;
    public static final int ADDITIONAL_HEADERS = 176;
    public static final int APPLIC_ID = 183;
    public static final int ATTRIBUTES = 168;
    public static final int AUX_APPLIC_ID = 185;
    public static final int BCC = 129;
    public static final int CANCEL_ID = 190;
    public static final int CANCEL_STATUS = 191;
    public static final int CANCEL_STATUS_REQUEST_CORRUPTED = 129;
    public static final int CANCEL_STATUS_REQUEST_SUCCESSFULLY_RECEIVED = 128;
    public static final int CC = 130;
    public static final int CONTENT = 174;
    public static final int CONTENT_CLASS = 186;
    public static final int CONTENT_CLASS_CONTENT_BASIC = 134;
    public static final int CONTENT_CLASS_CONTENT_RICH = 135;
    public static final int CONTENT_CLASS_IMAGE_BASIC = 129;
    public static final int CONTENT_CLASS_IMAGE_RICH = 130;
    public static final int CONTENT_CLASS_MEGAPIXEL = 133;
    public static final int CONTENT_CLASS_TEXT = 128;
    public static final int CONTENT_CLASS_VIDEO_BASIC = 131;
    public static final int CONTENT_CLASS_VIDEO_RICH = 132;
    public static final int CONTENT_LOCATION = 131;
    public static final int CONTENT_TYPE = 132;
    public static final int CURRENT_MMS_VERSION = 18;
    public static final int DATE = 133;
    public static final int DELIVERY_REPORT = 134;
    public static final int DELIVERY_TIME = 135;
    public static final int DISTRIBUTION_INDICATOR = 177;
    public static final int DRM_CONTENT = 187;
    public static final int ELEMENT_DESCRIPTOR = 178;
    public static final int EXPIRY = 136;
    public static final int FROM = 137;
    public static final int FROM_ADDRESS_PRESENT_TOKEN = 128;
    public static final String FROM_ADDRESS_PRESENT_TOKEN_STR = "address-present-token";
    public static final int FROM_INSERT_ADDRESS_TOKEN = 129;
    public static final String FROM_INSERT_ADDRESS_TOKEN_STR = "insert-address-token";
    public static final int LIMIT = 179;
    public static final int MBOX_QUOTAS = 172;
    public static final int MBOX_TOTALS = 170;
    public static final int MESSAGE_CLASS = 138;
    public static final int MESSAGE_CLASS_ADVERTISEMENT = 129;
    public static final String MESSAGE_CLASS_ADVERTISEMENT_STR = "advertisement";
    public static final int MESSAGE_CLASS_AUTO = 131;
    public static final String MESSAGE_CLASS_AUTO_STR = "auto";
    public static final int MESSAGE_CLASS_INFORMATIONAL = 130;
    public static final String MESSAGE_CLASS_INFORMATIONAL_STR = "informational";
    public static final int MESSAGE_CLASS_PERSONAL = 128;
    public static final String MESSAGE_CLASS_PERSONAL_STR = "personal";
    public static final int MESSAGE_COUNT = 173;
    public static final int MESSAGE_ID = 139;
    public static final int MESSAGE_SIZE = 142;
    public static final int MESSAGE_TYPE = 140;
    public static final int MESSAGE_TYPE_ACKNOWLEDGE_IND = 133;
    public static final int MESSAGE_TYPE_CANCEL_CONF = 151;
    public static final int MESSAGE_TYPE_CANCEL_REQ = 150;
    public static final int MESSAGE_TYPE_DELETE_CONF = 149;
    public static final int MESSAGE_TYPE_DELETE_REQ = 148;
    public static final int MESSAGE_TYPE_DELIVERY_IND = 134;
    public static final int MESSAGE_TYPE_FORWARD_CONF = 138;
    public static final int MESSAGE_TYPE_FORWARD_REQ = 137;
    public static final int MESSAGE_TYPE_MBOX_DELETE_CONF = 146;
    public static final int MESSAGE_TYPE_MBOX_DELETE_REQ = 145;
    public static final int MESSAGE_TYPE_MBOX_DESCR = 147;
    public static final int MESSAGE_TYPE_MBOX_STORE_CONF = 140;
    public static final int MESSAGE_TYPE_MBOX_STORE_REQ = 139;
    public static final int MESSAGE_TYPE_MBOX_UPLOAD_CONF = 144;
    public static final int MESSAGE_TYPE_MBOX_UPLOAD_REQ = 143;
    public static final int MESSAGE_TYPE_MBOX_VIEW_CONF = 142;
    public static final int MESSAGE_TYPE_MBOX_VIEW_REQ = 141;
    public static final int MESSAGE_TYPE_NOTIFICATION_IND = 130;
    public static final int MESSAGE_TYPE_NOTIFYRESP_IND = 131;
    public static final int MESSAGE_TYPE_READ_ORIG_IND = 136;
    public static final int MESSAGE_TYPE_READ_REC_IND = 135;
    public static final int MESSAGE_TYPE_RETRIEVE_CONF = 132;
    public static final int MESSAGE_TYPE_SEND_CONF = 129;
    public static final int MESSAGE_TYPE_SEND_REQ = 128;
    public static final int MMS_VERSION = 141;
    public static final int MMS_VERSION_1_0 = 16;
    public static final int MMS_VERSION_1_1 = 17;
    public static final int MMS_VERSION_1_2 = 18;
    public static final int MMS_VERSION_1_3 = 19;
    public static final int MM_FLAGS = 164;
    public static final int MM_FLAGS_ADD_TOKEN = 128;
    public static final int MM_FLAGS_FILTER_TOKEN = 130;
    public static final int MM_FLAGS_REMOVE_TOKEN = 129;
    public static final int MM_STATE = 163;
    public static final int MM_STATE_DRAFT = 128;
    public static final int MM_STATE_FORWARDED = 132;
    public static final int MM_STATE_NEW = 130;
    public static final int MM_STATE_RETRIEVED = 131;
    public static final int MM_STATE_SENT = 129;
    public static final int PREVIOUSLY_SENT_BY = 160;
    public static final int PREVIOUSLY_SENT_DATE = 161;
    public static final int PRIORITY = 143;
    public static final int PRIORITY_HIGH = 130;
    public static final int PRIORITY_LOW = 128;
    public static final int PRIORITY_NORMAL = 129;
    public static final int QUOTAS = 171;
    public static final int READ_REPLY = 144;
    public static final int READ_REPORT = 144;
    public static final int READ_STATUS = 155;
    public static final int READ_STATUS_READ = 128;
    public static final int READ_STATUS__DELETED_WITHOUT_BEING_READ = 129;
    public static final int RECOMMENDED_RETRIEVAL_MODE = 180;
    public static final int RECOMMENDED_RETRIEVAL_MODE_MANUAL = 128;
    public static final int RECOMMENDED_RETRIEVAL_MODE_TEXT = 181;
    public static final int REPLACE_ID = 189;
    public static final int REPLY_APPLIC_ID = 184;
    public static final int REPLY_CHARGING = 156;
    public static final int REPLY_CHARGING_ACCEPTED = 130;
    public static final int REPLY_CHARGING_ACCEPTED_TEXT_ONLY = 131;
    public static final int REPLY_CHARGING_DEADLINE = 157;
    public static final int REPLY_CHARGING_ID = 158;
    public static final int REPLY_CHARGING_REQUESTED = 128;
    public static final int REPLY_CHARGING_REQUESTED_TEXT_ONLY = 129;
    public static final int REPLY_CHARGING_SIZE = 159;
    public static final int REPORT_ALLOWED = 145;
    public static final int RESPONSE_STATUS = 146;
    public static final int RESPONSE_STATUS_ERROR_CONTENT_NOT_ACCEPTED = 135;
    public static final int RESPONSE_STATUS_ERROR_MESSAGE_FORMAT_CORRUPT = 131;
    public static final int RESPONSE_STATUS_ERROR_MESSAGE_NOT_FOUND = 133;
    public static final int RESPONSE_STATUS_ERROR_NETWORK_PROBLEM = 134;
    public static final int RESPONSE_STATUS_ERROR_PERMANENT_ADDRESS_HIDING_NOT_SUPPORTED = 234;
    public static final int RESPONSE_STATUS_ERROR_PERMANENT_CONTENT_NOT_ACCEPTED = 229;
    public static final int RESPONSE_STATUS_ERROR_PERMANENT_END = 255;
    public static final int RESPONSE_STATUS_ERROR_PERMANENT_FAILURE = 224;
    public static final int RESPONSE_STATUS_ERROR_PERMANENT_LACK_OF_PREPAID = 235;
    public static final int RESPONSE_STATUS_ERROR_PERMANENT_MESSAGE_FORMAT_CORRUPT = 226;
    public static final int RESPONSE_STATUS_ERROR_PERMANENT_MESSAGE_NOT_FOUND = 228;
    public static final int RESPONSE_STATUS_ERROR_PERMANENT_REPLY_CHARGING_FORWARDING_DENIED = 232;
    public static final int RESPONSE_STATUS_ERROR_PERMANENT_REPLY_CHARGING_LIMITATIONS_NOT_MET = 230;
    public static final int RESPONSE_STATUS_ERROR_PERMANENT_REPLY_CHARGING_NOT_SUPPORTED = 233;
    public static final int RESPONSE_STATUS_ERROR_PERMANENT_REPLY_CHARGING_REQUEST_NOT_ACCEPTED = 230;
    public static final int RESPONSE_STATUS_ERROR_PERMANENT_SENDING_ADDRESS_UNRESOLVED = 227;
    public static final int RESPONSE_STATUS_ERROR_PERMANENT_SERVICE_DENIED = 225;
    public static final int RESPONSE_STATUS_ERROR_SENDING_ADDRESS_UNRESOLVED = 132;
    public static final int RESPONSE_STATUS_ERROR_SERVICE_DENIED = 130;
    public static final int RESPONSE_STATUS_ERROR_TRANSIENT_FAILURE = 192;
    public static final int RESPONSE_STATUS_ERROR_TRANSIENT_MESSAGE_NOT_FOUND = 194;
    public static final int RESPONSE_STATUS_ERROR_TRANSIENT_NETWORK_PROBLEM = 195;
    public static final int RESPONSE_STATUS_ERROR_TRANSIENT_PARTIAL_SUCCESS = 196;
    public static final int RESPONSE_STATUS_ERROR_TRANSIENT_SENDNG_ADDRESS_UNRESOLVED = 193;
    public static final int RESPONSE_STATUS_ERROR_UNSPECIFIED = 129;
    public static final int RESPONSE_STATUS_ERROR_UNSUPPORTED_MESSAGE = 136;
    public static final int RESPONSE_STATUS_OK = 128;
    public static final int RESPONSE_TEXT = 147;
    public static final int RETRIEVE_STATUS = 153;
    public static final int RETRIEVE_STATUS_ERROR_END = 255;
    public static final int RETRIEVE_STATUS_ERROR_PERMANENT_CONTENT_UNSUPPORTED = 227;
    public static final int RETRIEVE_STATUS_ERROR_PERMANENT_FAILURE = 224;
    public static final int RETRIEVE_STATUS_ERROR_PERMANENT_MESSAGE_NOT_FOUND = 226;
    public static final int RETRIEVE_STATUS_ERROR_PERMANENT_SERVICE_DENIED = 225;
    public static final int RETRIEVE_STATUS_ERROR_TRANSIENT_FAILURE = 192;
    public static final int RETRIEVE_STATUS_ERROR_TRANSIENT_MESSAGE_NOT_FOUND = 193;
    public static final int RETRIEVE_STATUS_ERROR_TRANSIENT_NETWORK_PROBLEM = 194;
    public static final int RETRIEVE_STATUS_OK = 128;
    public static final int RETRIEVE_TEXT = 154;
    public static final int SENDER_VISIBILITY = 148;
    public static final int SENDER_VISIBILITY_HIDE = 128;
    public static final int SENDER_VISIBILITY_SHOW = 129;
    public static final int START = 175;
    public static final int STATUS = 149;
    public static final int STATUS_DEFERRED = 131;
    public static final int STATUS_EXPIRED = 128;
    public static final int STATUS_FORWARDED = 134;
    public static final int STATUS_INDETERMINATE = 133;
    public static final int STATUS_REJECTED = 130;
    public static final int STATUS_RETRIEVED = 129;
    public static final int STATUS_TEXT = 182;
    public static final int STATUS_UNREACHABLE = 135;
    public static final int STATUS_UNRECOGNIZED = 132;
    public static final int STORE = 162;
    public static final int STORED = 167;
    public static final int STORE_STATUS = 165;
    public static final int STORE_STATUS_ERROR_END = 255;
    public static final int STORE_STATUS_ERROR_PERMANENT_FAILURE = 224;
    public static final int STORE_STATUS_ERROR_PERMANENT_MESSAGE_FORMAT_CORRUPT = 226;
    public static final int STORE_STATUS_ERROR_PERMANENT_MESSAGE_NOT_FOUND = 227;
    public static final int STORE_STATUS_ERROR_PERMANENT_MMBOX_FULL = 228;
    public static final int STORE_STATUS_ERROR_PERMANENT_SERVICE_DENIED = 225;
    public static final int STORE_STATUS_ERROR_TRANSIENT_FAILURE = 192;
    public static final int STORE_STATUS_ERROR_TRANSIENT_NETWORK_PROBLEM = 193;
    public static final int STORE_STATUS_SUCCESS = 128;
    public static final int STORE_STATUS_TEXT = 166;
    public static final int SUBJECT = 150;
    public static final int TO = 151;
    public static final int TOTALS = 169;
    public static final int TRANSACTION_ID = 152;
    public static final int VALUE_ABSOLUTE_TOKEN = 128;
    public static final int VALUE_NO = 129;
    public static final int VALUE_RELATIVE_TOKEN = 129;
    public static final int VALUE_YES = 128;
    private HashMap mHeaderMap;
}
