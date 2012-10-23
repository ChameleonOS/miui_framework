// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.telephony;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.internal.telephony.gsm.MiuiSpnOverride;
import java.util.Locale;
import miui.telephony.phonenumber.ChineseAreaCode;
import miui.telephony.phonenumber.ChineseTelocation;
import miui.telephony.phonenumber.CountryCode;
import miui.telephony.phonenumber.Prefix;

public class PhoneNumberUtils extends android.telephony.PhoneNumberUtils {
    private static class TelocationAsyncQueryHandler extends AsyncQueryHandler {
        protected class TelocationWorkerHandler extends android.content.AsyncQueryHandler.WorkerHandler {

            public void handleMessage(Message message) {
                TelocationWorkerArgs telocationworkerargs = (TelocationWorkerArgs)message.obj;
                if(message.arg1 == 10)
                    telocationworkerargs.location = TelocationAsyncQueryHandler.queryTelocation(telocationworkerargs.context, telocationworkerargs.phoneNumber);
                Message message1 = telocationworkerargs.handler.obtainMessage(message.what);
                message1.arg1 = message.arg1;
                message1.obj = message.obj;
                message1.sendToTarget();
            }

            final TelocationAsyncQueryHandler this$0;

            public TelocationWorkerHandler(Looper looper) {
                this$0 = TelocationAsyncQueryHandler.this;
                super(TelocationAsyncQueryHandler.this, looper);
            }
        }

        protected static final class TelocationWorkerArgs {

            public Context context;
            public Object cookie1;
            public Object cookie2;
            public Object cookie3;
            public Object cookie4;
            public Handler handler;
            public TelocationQueryListener listener;
            public String location;
            public String phoneNumber;

            protected TelocationWorkerArgs() {
            }
        }


        public static TelocationAsyncQueryHandler getInstance() {
            if(sInstance != null) goto _L2; else goto _L1
_L1:
            miui/telephony/PhoneNumberUtils$TelocationAsyncQueryHandler;
            JVM INSTR monitorenter ;
            if(sInstance == null)
                sInstance = new TelocationAsyncQueryHandler();
            miui/telephony/PhoneNumberUtils$TelocationAsyncQueryHandler;
            JVM INSTR monitorexit ;
_L2:
            return sInstance;
            Exception exception;
            exception;
            miui/telephony/PhoneNumberUtils$TelocationAsyncQueryHandler;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public static String queryTelocation(Context context, CharSequence charsequence) {
            return PhoneNumber.getLocation(context, charsequence);
        }

        protected Handler createHandler(Looper looper) {
            if(mWorkerHandler == null)
                mWorkerHandler = new TelocationWorkerHandler(looper);
            return mWorkerHandler;
        }

        public void handleMessage(Message message) {
            TelocationWorkerArgs telocationworkerargs = (TelocationWorkerArgs)message.obj;
            if(message.arg1 == 10 && telocationworkerargs.listener != null)
                telocationworkerargs.listener.onComplete(telocationworkerargs.cookie1, telocationworkerargs.cookie2, telocationworkerargs.cookie3, telocationworkerargs.cookie4, telocationworkerargs.location);
        }

        public void startQueryTelocationString(int i, Object obj, Object obj1, Object obj2, Object obj3, TelocationQueryListener telocationquerylistener, Context context, 
                String s) {
            TelocationWorkerArgs telocationworkerargs = new TelocationWorkerArgs();
            telocationworkerargs.handler = this;
            telocationworkerargs.context = context;
            telocationworkerargs.phoneNumber = s;
            telocationworkerargs.cookie1 = obj;
            telocationworkerargs.cookie2 = obj1;
            telocationworkerargs.cookie3 = obj2;
            telocationworkerargs.cookie4 = obj3;
            telocationworkerargs.listener = telocationquerylistener;
            telocationworkerargs.location = null;
            Message message = mWorkerHandler.obtainMessage(i);
            message.arg1 = 10;
            message.obj = telocationworkerargs;
            message.sendToTarget();
        }

        private static final int EVENT_QUERY_TELOCATION = 10;
        private static TelocationAsyncQueryHandler sInstance;
        private Handler mWorkerHandler;

        private TelocationAsyncQueryHandler() {
            super(null);
        }
    }

    public static interface TelocationQueryListener {

        public abstract void onComplete(Object obj, Object obj1, Object obj2, Object obj3, String s);
    }

    public static class PhoneNumber {

        public static String addCountryCode(String s) {
            PhoneNumber phonenumber = parse(s);
            boolean flag = TextUtils.isEmpty(phonenumber.getCountryCode());
            String s1;
            if(phonenumber.isChineseNumber())
                if(!TextUtils.isEmpty(phonenumber.getPrefix()))
                    flag = false;
                else
                if(phonenumber.isServiceNumber())
                    flag = false;
                else
                if(!phonenumber.isNormalMobileNumber())
                    if(!TextUtils.isEmpty(phonenumber.getAreaCode()))
                        flag = true;
                    else
                        flag = false;
            s1 = s;
            if(flag) {
                String s2 = CountryCode.getUserDefinedCountryCode();
                if(TextUtils.isEmpty(s2))
                    s2 = CountryCode.getIccCountryCode();
                if(!TextUtils.isEmpty(s2))
                    if("39".equals(s2) || s.charAt(0) != '0')
                        s1 = (new StringBuilder()).append("+").append(s2).append(s).toString();
                    else
                        s1 = (new StringBuilder()).append("+").append(s2).append(s.substring(1)).toString();
            }
            phonenumber.recycle();
            return s1;
        }

        private static boolean areEqual(CharSequence charsequence, int i, CharSequence charsequence1, int j, int k) {
            boolean flag;
            flag = false;
            break MISSING_BLOCK_LABEL_3;
label0:
            while(true)  {
                do
                    return flag;
                while(charsequence == null || charsequence1 == null || i < 0 || j < 0 || k < 0 || charsequence.length() < i + k || charsequence1.length() < j + k);
                for(int l = 0; l < k; l++)
                    if(charsequence.charAt(i + l) != charsequence1.charAt(j + l))
                        continue label0;

                flag = true;
            }
        }

        private void attach(CharSequence charsequence) {
            if(charsequence == null)
                charsequence = "";
            mOriginal = charsequence;
            boolean flag = false;
            int i = 0;
            int j = charsequence.length();
            while(i < j)  {
                char c = charsequence.charAt(i);
                if(flag && PhoneNumberUtils.isNonSeparator(c))
                    mBuffer.append(c);
                else
                if(i == 0 && c == '+')
                    mBuffer.append(c);
                else
                if(c >= '0' && c <= '9')
                    mBuffer.append(c);
                else
                if(!flag && PhoneNumberUtils.isStartsPostDial(c)) {
                    mPostDialStringStart = mBuffer.length();
                    flag = true;
                    mBuffer.append(c);
                }
                i++;
            }
            if(!flag)
                mPostDialStringStart = mBuffer.length();
        }

        private void clear() {
            mBuffer.setLength(0);
            mPrefix = null;
            mCountryCode = null;
            mAreaCode = null;
            mEffectiveNumberStart = 0;
            mEffectiveNumber = null;
            mPostDialStringStart = 0;
            mPostDialString = null;
        }

        public static String getDefaultCountryCode() {
            return CountryCode.getIccCountryCode();
        }

        public static String getDialableNumber(String s) {
            if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
            s = "";
_L4:
            return s;
_L2:
            int i = s.indexOf('\002');
            int j;
            if(i < 0)
                j = 1;
            else
                j = i + 1;
            if(s.charAt(0) == '\001')
                s = s.substring(j);
            if(true) goto _L4; else goto _L3
_L3:
        }

        public static String getHashString(String s) {
            PhoneNumber phonenumber = parse(s);
            String s1;
            if(!phonenumber.isChineseNumber()) {
                Object aobj5[] = new Object[4];
                aobj5[0] = Character.valueOf('\001');
                aobj5[1] = phonenumber.getCountryCode();
                aobj5[2] = phonenumber.getEffectiveNumber();
                aobj5[3] = phonenumber.getPostDialString();
                s1 = String.format("%c(00%s)%s%s", aobj5);
            } else
            if(phonenumber.isNormalMobileNumber()) {
                Object aobj4[] = new Object[4];
                aobj4[0] = Character.valueOf('\001');
                aobj4[1] = "86";
                aobj4[2] = phonenumber.getEffectiveNumber();
                aobj4[3] = phonenumber.getPostDialString();
                s1 = String.format("%c(00%s)%s%s", aobj4);
            } else
            if(!TextUtils.isEmpty(phonenumber.getCountryCode())) {
                if(!TextUtils.isEmpty(phonenumber.getAreaCode())) {
                    Object aobj3[] = new Object[5];
                    aobj3[0] = Character.valueOf('\001');
                    aobj3[1] = "86";
                    aobj3[2] = phonenumber.getAreaCode();
                    aobj3[3] = phonenumber.getEffectiveNumber();
                    aobj3[4] = phonenumber.getPostDialString();
                    s1 = String.format("%c(00%s)%s-%s%s", aobj3);
                } else {
                    Object aobj2[] = new Object[4];
                    aobj2[0] = Character.valueOf('\001');
                    aobj2[1] = "86";
                    aobj2[2] = phonenumber.getEffectiveNumber();
                    aobj2[3] = phonenumber.getPostDialString();
                    s1 = String.format("%c(00%s)%s%s", aobj2);
                }
            } else
            if(!TextUtils.isEmpty(phonenumber.getAreaCode())) {
                Object aobj1[] = new Object[5];
                aobj1[0] = Character.valueOf('\001');
                aobj1[1] = "86";
                aobj1[2] = phonenumber.getAreaCode();
                aobj1[3] = phonenumber.getEffectiveNumber();
                aobj1[4] = phonenumber.getPostDialString();
                s1 = String.format("%c(00%s)%s-%s%s", aobj1);
            } else {
                Object aobj[] = new Object[5];
                aobj[0] = Character.valueOf('\001');
                aobj[1] = "86";
                aobj[2] = Character.valueOf('\002');
                aobj[3] = phonenumber.getEffectiveNumber();
                aobj[4] = phonenumber.getPostDialString();
                s1 = String.format("%c(00%s)%c%s%s", aobj);
            }
            phonenumber.recycle();
            return s1;
        }

        public static String getLocation(Context context, CharSequence charsequence) {
            PhoneNumber phonenumber = parse(charsequence);
            String s = phonenumber.getLocation(context);
            phonenumber.recycle();
            return s;
        }

        public static String getLocationAreaCode(Context context, String s) {
            PhoneNumber phonenumber = parse(s);
            String s1 = phonenumber.getLocationAreaCode(context);
            phonenumber.recycle();
            return s1;
        }

        public static boolean isChineseOperator() {
            return CountryCode.isChinaEnvironment();
        }

        public static boolean isValidCountryCode(String s) {
            return CountryCode.isValidCountryCode(s);
        }

        public static PhoneNumber parse(CharSequence charsequence) {
            PhoneNumber aphonenumber[] = sPool;
            aphonenumber;
            JVM INSTR monitorenter ;
            PhoneNumber phonenumber;
            if(sPoolIndex != -1)
                break MISSING_BLOCK_LABEL_31;
            phonenumber = new PhoneNumber();
_L2:
            phonenumber.attach(charsequence);
            return phonenumber;
            phonenumber = sPool[sPoolIndex];
            PhoneNumber aphonenumber1[] = sPool;
            int i = sPoolIndex;
            sPoolIndex = i - 1;
            aphonenumber1[i] = null;
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            throw exception;
        }

        public static String replaceCdmaInternationalAccessCode(String s) {
_L1:
            return s1;
            if(!PhoneNumberUtils.isChinaMobileNumber(s1) && s1.charAt(0) != '0')
                s1 = (new StringBuilder()).append('0').append(s1).toString();
              goto _L1
            String s1;
            if(s.startsWith("+86") && "86".equals(CountryCode.getNetworkCountryCode())) {
                s1 = s.substring(3);
                break MISSING_BLOCK_LABEL_26;
            }
            if(!TextUtils.isEmpty(s) && s.charAt(0) == '+') {
                String s2 = CountryCode.getIddCode();
                s = (new StringBuilder()).append(s2).append(s.substring(1)).toString();
            }
            s1 = s;
            if(true) goto _L1; else goto _L2
_L2:
        }

        public String getAreaCode() {
            if(mAreaCode == null) {
                mAreaCode = "";
                if(isChineseNumber() && !Prefix.isSmsPrefix(getPrefix())) {
                    boolean flag = true;
                    if(TextUtils.isEmpty(getCountryCode())) {
                        flag = false;
                        if(mBuffer.length() > mEffectiveNumberStart && mBuffer.charAt(mEffectiveNumberStart) == '0') {
                            flag = true;
                            mEffectiveNumberStart = 1 + mEffectiveNumberStart;
                        }
                    }
                    if(flag) {
                        mAreaCode = ChineseAreaCode.parse(mBuffer, mEffectiveNumberStart, mPostDialStringStart - mEffectiveNumberStart);
                        mEffectiveNumberStart = mEffectiveNumberStart + mAreaCode.length();
                    }
                }
            }
            return mAreaCode;
        }

        public String getCountryCode() {
            if(mCountryCode == null) {
                getPrefix();
                String s = "+";
                if(!areEqual(mBuffer, mEffectiveNumberStart, s, 0, s.length())) {
                    s = CountryCode.getIddCode();
                    if(!areEqual(mBuffer, mEffectiveNumberStart, s, 0, s.length()))
                        s = null;
                }
                if(s != null) {
                    mEffectiveNumberStart = mEffectiveNumberStart + s.length();
                    mCountryCode = CountryCode.parse(mBuffer, mEffectiveNumberStart, mPostDialStringStart - mEffectiveNumberStart);
                    mEffectiveNumberStart = mEffectiveNumberStart + mCountryCode.length();
                } else {
                    mCountryCode = "";
                }
            }
            return mCountryCode;
        }

        public String getEffectiveNumber() {
            String s;
            if(mEffectiveNumber == null) {
                getAreaCode();
                String s1;
                if(mBuffer.length() > mEffectiveNumberStart)
                    mEffectiveNumber = mBuffer.substring(mEffectiveNumberStart, mPostDialStringStart);
                else
                    mEffectiveNumber = "";
            }
            if(TextUtils.isEmpty(mEffectiveNumber)) {
                s1 = mOriginal.toString();
                mOriginal = s1;
                s = s1.toString();
            } else {
                s = mEffectiveNumber;
            }
            return s;
        }

        public String getLocation(Context context) {
            Locale locale = context.getResources().getConfiguration().locale;
            String s;
            if(!locale.getLanguage().equals(Locale.CHINA.getLanguage()) || !isChineseNumber()) {
                s = ChineseTelocation.getInstance().getExternalLocation(context, getCountryCode(), mOriginal, locale);
            } else {
                ChineseTelocation chinesetelocation = ChineseTelocation.getInstance();
                StringBuffer stringbuffer = mBuffer;
                int i = mEffectiveNumberStart;
                int j = mPostDialStringStart - mEffectiveNumberStart;
                boolean flag;
                if(isNormalMobileNumber() || getAreaCode().length() > 0)
                    flag = true;
                else
                    flag = false;
                s = chinesetelocation.getLocation(context, stringbuffer, i, j, flag);
            }
            return s;
        }

        public String getLocationAreaCode(Context context) {
            String s = "";
            if(isChineseNumber())
                if(isNormalMobileNumber())
                    s = ChineseTelocation.getInstance().getAreaCode(context, mBuffer, mEffectiveNumberStart, mPostDialStringStart - mEffectiveNumberStart);
                else
                    s = getAreaCode();
            return s;
        }

        public String getNormalizedNumber(boolean flag, boolean flag1) {
            if(isChineseNumber()) goto _L2; else goto _L1
_L1:
            String s;
            int k;
            int l;
            if(flag)
                k = mEffectiveNumberStart - getCountryCode().length();
            else
                k = mEffectiveNumberStart;
            if(flag1)
                l = mBuffer.length();
            else
                l = mPostDialStringStart;
            s = mBuffer.substring(k, l);
            if(flag && getCountryCode().length() > 0)
                s = (new StringBuilder()).append("+").append(s).toString();
_L4:
            return s;
_L2:
            if(isNormalMobileNumber()) {
                int j;
                if(flag1)
                    j = mBuffer.length();
                else
                    j = mPostDialStringStart;
                s = mBuffer.substring(mEffectiveNumberStart, j);
                if(flag)
                    s = (new StringBuilder()).append("+86").append(s).toString();
            } else {
                int i;
                if(flag1)
                    i = mBuffer.length();
                else
                    i = mPostDialStringStart;
                if(!TextUtils.isEmpty(getAreaCode()) && !isServiceNumber()) {
                    String s1 = mBuffer.substring(mEffectiveNumberStart - getAreaCode().length(), i);
                    if(flag)
                        s = (new StringBuilder()).append("+86").append(s1).toString();
                    else
                        s = (new StringBuilder()).append("0").append(s1).toString();
                } else {
                    s = mBuffer.substring(mEffectiveNumberStart, i);
                }
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        public String getNumberWithoutPrefix(boolean flag) {
            int i = 0;
            if(!TextUtils.isEmpty(getPrefix()))
                i = getPrefix().length();
            String s;
            if(flag)
                s = mBuffer.substring(i);
            else
                s = mBuffer.substring(i, mPostDialStringStart);
            return s;
        }

        public String getPostDialString() {
            if(mPostDialString == null)
                if(mBuffer.length() > mPostDialStringStart)
                    mPostDialString = mBuffer.substring(mPostDialStringStart);
                else
                    mPostDialString = "";
            return mPostDialString;
        }

        public String getPrefix() {
            if(mPrefix == null) {
                mPrefix = Prefix.parse(mBuffer, mEffectiveNumberStart, mPostDialStringStart - mEffectiveNumberStart);
                mEffectiveNumberStart = mEffectiveNumberStart + mPrefix.length();
            }
            return mPrefix;
        }

        public boolean isChineseNumber() {
            String s = getCountryCode();
            boolean flag;
            if(!TextUtils.isEmpty(s))
                flag = "86".equals(s);
            else
                flag = CountryCode.isChinaEnvironment();
            return flag;
        }

        public boolean isNormalMobileNumber() {
            boolean flag;
            boolean flag1;
            flag = true;
            flag1 = false;
            getAreaCode();
            if(!isChineseNumber() || mPostDialStringStart - mEffectiveNumberStart < 11 || mBuffer.charAt(mEffectiveNumberStart) != '1') goto _L2; else goto _L1
_L1:
            mBuffer.charAt(1 + mEffectiveNumberStart);
            JVM INSTR tableswitch 51 56: default 96
        //                       51 98
        //                       52 298
        //                       53 298
        //                       54 96
        //                       55 270
        //                       56 298;
               goto _L2 _L3 _L4 _L4 _L2 _L5 _L4
_L2:
            return flag1;
_L3:
            if(mBuffer.charAt(2 + mEffectiveNumberStart) != '8' || mBuffer.charAt(3 + mEffectiveNumberStart) != '0' || mBuffer.charAt(4 + mEffectiveNumberStart) != '0' || mBuffer.charAt(5 + mEffectiveNumberStart) != '1' || mBuffer.charAt(6 + mEffectiveNumberStart) != '3' || mBuffer.charAt(7 + mEffectiveNumberStart) != '8' || mBuffer.charAt(8 + mEffectiveNumberStart) != '0' || mBuffer.charAt(9 + mEffectiveNumberStart) != '0' || mBuffer.charAt(10 + mEffectiveNumberStart) != '0')
                flag1 = flag;
            continue; /* Loop/switch isn't completed */
_L5:
            if(mBuffer.charAt(2 + mEffectiveNumberStart) == '9')
                flag = false;
            flag1 = flag;
            continue; /* Loop/switch isn't completed */
_L4:
            flag1 = flag;
            if(true) goto _L2; else goto _L6
_L6:
        }

        public boolean isServiceNumber() {
            boolean flag;
            flag = true;
            getAreaCode();
            if(!isChineseNumber() || mPostDialStringStart - mEffectiveNumberStart <= 2) goto _L2; else goto _L1
_L1:
            char c = mBuffer.charAt(mEffectiveNumberStart);
            if(c != '1') goto _L4; else goto _L3
_L3:
            mBuffer.charAt(1 + mEffectiveNumberStart);
            JVM INSTR tableswitch 48 55: default 104
        //                       48 106
        //                       49 106
        //                       50 106
        //                       51 108
        //                       52 104
        //                       53 104
        //                       54 106
        //                       55 294;
               goto _L5 _L6 _L6 _L6 _L7 _L5 _L5 _L6 _L8
_L6:
            break MISSING_BLOCK_LABEL_106;
_L5:
            flag = false;
_L10:
            return flag;
_L7:
            if(mPostDialStringStart - mEffectiveNumberStart < 11 || mBuffer.charAt(2 + mEffectiveNumberStart) != '8' || mBuffer.charAt(3 + mEffectiveNumberStart) != '0' || mBuffer.charAt(4 + mEffectiveNumberStart) != '0' || mBuffer.charAt(5 + mEffectiveNumberStart) != '1' || mBuffer.charAt(6 + mEffectiveNumberStart) != '3' || mBuffer.charAt(7 + mEffectiveNumberStart) != '8' || mBuffer.charAt(8 + mEffectiveNumberStart) != '0' || mBuffer.charAt(9 + mEffectiveNumberStart) != '0' || mBuffer.charAt(10 + mEffectiveNumberStart) != '0')
                flag = false;
            continue; /* Loop/switch isn't completed */
_L8:
            if(mBuffer.charAt(2 + mEffectiveNumberStart) != '9')
                flag = false;
            continue; /* Loop/switch isn't completed */
_L4:
            if(c == '9')
                continue; /* Loop/switch isn't completed */
            if(c >= '2' && c <= '8') {
                if(mBuffer.charAt(1 + mEffectiveNumberStart) != '0' || mBuffer.charAt(2 + mEffectiveNumberStart) != '0')
                    flag = false;
                continue; /* Loop/switch isn't completed */
            }
_L2:
            flag = false;
            if(true) goto _L10; else goto _L9
_L9:
        }

        public boolean isSmsPrefix() {
            return Prefix.isSmsPrefix(getPrefix());
        }

        public void recycle() {
            clear();
            PhoneNumber aphonenumber[] = sPool;
            aphonenumber;
            JVM INSTR monitorenter ;
            if(sPoolIndex < sPool.length) {
                PhoneNumber aphonenumber1[] = sPool;
                int i = 1 + sPoolIndex;
                sPoolIndex = i;
                aphonenumber1[i] = this;
            }
            return;
        }

        private static final String EMPTY = "";
        private static final char HASH_STRING_INDICATOR = 1;
        private static final int MAX_NUMBER_LENGTH = 256;
        private static final char MISSING_AREA_CODE_INDICATOR = 2;
        private static final int POOL_SIZE = 10;
        private static final PhoneNumber sPool[] = new PhoneNumber[10];
        private static int sPoolIndex = -1;
        private String mAreaCode;
        private StringBuffer mBuffer;
        private String mCountryCode;
        private String mEffectiveNumber;
        private int mEffectiveNumberStart;
        private CharSequence mOriginal;
        private String mPostDialString;
        private int mPostDialStringStart;
        private String mPrefix;


        private PhoneNumber() {
            mBuffer = new StringBuffer(256);
            clear();
        }
    }


    public PhoneNumberUtils() {
    }

    public static void cancelAsyncTelocationQuery(int i) {
        TelocationAsyncQueryHandler.getInstance().cancelOperation(i);
    }

    public static String extractNetworkPortion(String s) {
        return extractNetworkPortion(s, 0);
    }

    public static String extractNetworkPortion(String s, int i) {
        String s1;
        if(s == null)
            s1 = null;
        else
        if(i == 3 || isUriNumber(s))
            s1 = s.substring(0, 1 + indexOfLastNetworkChar(s)).trim();
        else
            s1 = android.telephony.PhoneNumberUtils.extractNetworkPortion(s);
        return s1;
    }

    public static String extractNetworkPortionAlt(String s) {
        return extractNetworkPortionAlt(s, 0);
    }

    public static String extractNetworkPortionAlt(String s, int i) {
        String s1;
        if(s == null)
            s1 = null;
        else
        if(i == 3 || isUriNumber(s))
            s1 = s.substring(0, 1 + indexOfLastNetworkChar(s)).trim();
        else
            s1 = android.telephony.PhoneNumberUtils.extractNetworkPortionAlt(s);
        return s1;
    }

    public static String formatNumberWithIp(Context context, String s) {
        boolean flag;
        String s2;
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "button_autoip", 0) != 0)
            flag = true;
        else
            flag = false;
        if(flag) goto _L2; else goto _L1
_L1:
        s2 = s;
_L4:
        return s2;
_L2:
        String s3;
        PhoneNumber phonenumber;
        boolean flag1;
        String s1 = miui.provider.ExtraSettings.System.getString(context.getContentResolver(), "current_areacode", null);
        if(s1 == null || s1.length() < 2) {
            s2 = s;
            continue; /* Loop/switch isn't completed */
        }
        s3 = miui.provider.ExtraSettings.System.getString(context.getContentResolver(), "autoip_prefix", getDefaultIpBySim(context));
        if(TextUtils.isEmpty(s3)) {
            s2 = s;
            continue; /* Loop/switch isn't completed */
        }
        if(s.startsWith(s3)) {
            s2 = s;
            continue; /* Loop/switch isn't completed */
        }
        phonenumber = PhoneNumber.parse(s);
        if(phonenumber.getPrefix().length() == 0) {
            String s4 = phonenumber.getLocationAreaCode(context);
            String s5;
            boolean flag2;
            if(s1.startsWith("0"))
                s5 = s1.substring(1);
            else
                s5 = s1;
            if(android.provider.Settings.System.getInt(context.getContentResolver(), "button_add_zero_prefix", 0) != 0)
                flag1 = true;
            else
                flag1 = false;
            if(android.provider.Settings.System.getInt(context.getContentResolver(), "button_auto_ip_support_local_numbers", 0) != 0)
                flag2 = true;
            else
                flag2 = false;
            if(!TextUtils.isEmpty(s4) && (flag2 || !s5.equals(s4))) {
                if(!s.startsWith("+86"))
                    break; /* Loop/switch isn't completed */
                if(phonenumber.getAreaCode().length() > 0 || phonenumber.isNormalMobileNumber() && flag1)
                    s = (new StringBuilder()).append(s3).append("0").append(s.substring(3)).toString();
                else
                    s = (new StringBuilder()).append(s3).append(s.substring(3)).toString();
            }
        }
_L5:
        phonenumber.recycle();
        s2 = s;
        if(true) goto _L4; else goto _L3
_L3:
        if(s.startsWith("0086")) {
            if(phonenumber.getAreaCode().length() > 0 || phonenumber.isNormalMobileNumber() && flag1)
                s = (new StringBuilder()).append(s3).append("0").append(s.substring(4)).toString();
            else
                s = (new StringBuilder()).append(s3).append(s.substring(4)).toString();
        } else
        if(phonenumber.isNormalMobileNumber() && flag1)
            s = (new StringBuilder()).append(s3).append("0").append(s).toString();
        else
            s = (new StringBuilder()).append(s3).append(s.replace("+", "00")).toString();
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    public static String formatNumberWithoutIp(Context context, String s) {
        boolean flag = false;
        String s2;
        if(s == null) {
            s2 = s;
        } else {
            if(android.provider.Settings.System.getInt(context.getContentResolver(), "button_autoip", 0) != 0)
                flag = true;
            if(!flag) {
                s2 = s;
            } else {
                String s1 = android.provider.Settings.System.getString(context.getContentResolver(), "autoip_prefix");
                if(s1 == null)
                    s1 = getDefaultIpBySim(context);
                if(TextUtils.isEmpty(s1)) {
                    s2 = s;
                } else {
                    if(s.startsWith(s1))
                        s = s.substring(s1.length());
                    s2 = s;
                }
            }
        }
        return s2;
    }

    public static String getDefaultIpBySim(Context context) {
        String s = ((TelephonyManager)context.getSystemService("phone")).getSimOperator();
        String s1 = MiuiSpnOverride.getInstance().getEquivalentOperatorNumeric(s);
        String s2;
        if("46000".equals(s1))
            s2 = "17951";
        else
        if("46001".equals(s1))
            s2 = "17911";
        else
        if("46003".equals(s1))
            s2 = "17901";
        else
            s2 = "";
        return s2;
    }

    private static int indexOfLastNetworkChar(String s) {
        int i = s.length();
        int j = minPositive(s.indexOf(','), s.indexOf(';'));
        int k;
        if(j < 0)
            k = i - 1;
        else
            k = j - 1;
        return k;
    }

    private static boolean isAlnum(char c) {
        boolean flag;
        if(c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isChinaMobileNumber(String s) {
        boolean flag = false;
        if(!TextUtils.isEmpty(s) && s.length() >= 11) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        String s1 = stripSeparators(s);
        if(s1.length() >= 11 + "86".length())
            flag = s1.substring((-11 + s1.length()) - "86".length()).startsWith("861");
        else
        if(s1.length() >= 11)
            flag = s1.substring(-11 + s1.length()).startsWith("1");
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static boolean isChineseOperator(String s) {
        boolean flag;
        if(!TextUtils.isEmpty(s) && s.startsWith("460"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isDialable(String s) {
        int i;
        int j;
        i = 0;
        j = s.length();
_L3:
        if(i >= j)
            break MISSING_BLOCK_LABEL_33;
        if(isDialable(s.charAt(i))) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = true;
          goto _L4
    }

    public static boolean isMiuiEmergencyNumber(String s, boolean flag) {
        boolean flag1 = false;
        if(s != null) goto _L2; else goto _L1
_L1:
        return flag1;
_L2:
        String as[] = EMERGENCY_NUMBERS;
        int i = as.length;
        int j = 0;
        do {
            if(j < i) {
label0:
                {
                    String s1 = as[j];
                    if(flag) {
                        if(!s1.equals(s))
                            break label0;
                        flag1 = true;
                    } else {
                        if(!s1.startsWith(s))
                            break label0;
                        flag1 = true;
                    }
                }
            }
            if(true)
                continue;
            j++;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static boolean isServiceNumber(String s) {
        PhoneNumber phonenumber = PhoneNumber.parse(s);
        boolean flag;
        if(phonenumber != null && phonenumber.isServiceNumber())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static String maskPhoneNumber(String s, int i) {
        if(s != null) goto _L2; else goto _L1
_L1:
        String s1 = "";
_L9:
        return s1;
_L2:
        int j;
        int l;
        j = 0;
        for(int k = 0; k < s.length(); k++)
            if(isAlnum(s.charAt(k)))
                j++;

        if(j < 7) {
            s1 = new String(s);
            continue; /* Loop/switch isn't completed */
        }
        if(j < 11)
            l = 2;
        else
            l = 3;
        i;
        JVM INSTR tableswitch 0 2: default 100
    //                   0 117
    //                   1 189
    //                   2 198;
           goto _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_198;
_L3:
        throw new IllegalArgumentException("Invalid cut mode");
_L4:
        int i1 = 0;
_L7:
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        int j1 = 0;
        int k1 = 0;
        while(k1 < s.length())  {
            if(isAlnum(s.charAt(k1))) {
                if(j1 < i1 || l <= 0) {
                    stringbuilder.append(s.charAt(k1));
                } else {
                    stringbuilder.append('?');
                    l--;
                }
                j1++;
            } else {
                stringbuilder.append(s.charAt(k1));
            }
            k1++;
        }
        break MISSING_BLOCK_LABEL_238;
_L5:
        i1 = j - l;
          goto _L7
        i1 = (j - l) / 2;
          goto _L7
        s1 = stringbuilder.toString();
        if(true) goto _L9; else goto _L8
_L8:
    }

    private static int minPositive(int i, int j) {
        if(i < 0 || j < 0) goto _L2; else goto _L1
_L1:
        if(i >= j)
            i = j;
_L4:
        return i;
_L2:
        if(i < 0)
            if(j >= 0)
                i = j;
            else
                i = -1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static String parseNumber(String s) {
        if(TelephonyManager.getDefault().getSimState() == 5) {
            PhoneNumber phonenumber = PhoneNumber.parse(s);
            if(phonenumber != null)
                s = phonenumber.getEffectiveNumber();
        }
        return s;
    }

    public static String parseTelocationString(Context context, CharSequence charsequence) {
        return TelocationAsyncQueryHandler.queryTelocation(context, charsequence);
    }

    public static void queryTelocationStringAsync(int i, Object obj, Object obj1, Object obj2, Object obj3, TelocationQueryListener telocationquerylistener, Context context, String s) {
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "enable_telocation", 1) == 1)
            TelocationAsyncQueryHandler.getInstance().startQueryTelocationString(i, obj, obj1, obj2, obj3, telocationquerylistener, context, s);
        else
            telocationquerylistener.onComplete(obj, obj1, obj2, obj3, null);
    }

    public static void queryTelocationStringAsync(int i, Object obj, Object obj1, Object obj2, Object obj3, TelocationQueryListener telocationquerylistener, Context context, String s, 
            boolean flag) {
        if(flag)
            TelocationAsyncQueryHandler.getInstance().startQueryTelocationString(i, obj, obj1, obj2, obj3, telocationquerylistener, context, s);
        else
            telocationquerylistener.onComplete(obj, obj1, obj2, obj3, null);
    }

    public static String removeDashesAndBlanks(String s) {
        if(!TextUtils.isEmpty(s)) {
            StringBuilder stringbuilder = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c != ' ' && c != '-')
                    stringbuilder.append(c);
            }

            s = stringbuilder.toString();
        }
        return s;
    }

    public static String[] splitNetworkAndPostDialPortion(String s) {
        String as[];
        if(s == null) {
            as = null;
        } else {
            int i = 1 + indexOfLastNetworkChar(s);
            as = new String[2];
            as[0] = s.substring(0, i);
            String s1;
            if(i == s.length())
                s1 = "";
            else
                s1 = s.substring(i);
            as[1] = s1;
        }
        return as;
    }

    public static String stripSeparatorsAndCountryCode(String s) {
        String s1 = stripSeparators(s);
        if(s1 == null) goto _L2; else goto _L1
_L1:
        if(!s1.startsWith("+86")) goto _L4; else goto _L3
_L3:
        s1 = s1.substring("+86".length());
_L2:
        return s1;
_L4:
        if(s1.startsWith("0086"))
            s1 = s1.substring("0086".length());
        if(true) goto _L2; else goto _L5
_L5:
    }

    private static final String CHINA_COUNTRY_CODE = "86";
    public static final String CHINA_MCC = "460";
    private static final int CHINA_MOBILE_NUMBER_LENGTH = 11;
    private static final String CHINA_MOBILE_NUMBER_PREFIX = "1";
    private static final String CHINA_REGION_CODE1 = "+86";
    private static final String CHINA_REGION_CODE2 = "0086";
    private static final String EMERGENCY_NUMBERS[];
    static final String LOG_TAG = "PhoneNumberUtils";
    public static final int MASK_PHONE_NUMBER_MODE_HEAD = 0;
    public static final int MASK_PHONE_NUMBER_MODE_MIDDLE = 2;
    public static final int MASK_PHONE_NUMBER_MODE_TAIL = 1;

    static  {
        String as[] = new String[6];
        as[0] = "110";
        as[1] = "112";
        as[2] = "119";
        as[3] = "120";
        as[4] = "122";
        as[5] = "911";
        EMERGENCY_NUMBERS = as;
    }
}
