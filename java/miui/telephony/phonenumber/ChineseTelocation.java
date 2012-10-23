// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.telephony.phonenumber;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;
import java.io.*;
import java.util.*;
import miui.provider.Telocation;

// Referenced classes of package miui.telephony.phonenumber:
//            TelocationConstants, CountryCode

public class ChineseTelocation {

    private ChineseTelocation() {
        mNormalCustomLocations = new HashMap();
        mGroupCustomLocations = new HashMap();
        long l;
        byte abyte0[];
        l = System.currentTimeMillis();
        mFile = new RandomAccessFile(new File("/etc/telocation.td"), "r");
        abyte0 = new byte[TelocationConstants.FILE_TAG.length];
        mFile.read(abyte0);
        if(Arrays.equals(abyte0, TelocationConstants.FILE_TAG)) goto _L2; else goto _L1
_L1:
        Log.w("ChineseTelocation", "Unknow file type for /etc/telocation.td, NO mobile telocation supported!");
        if(false || mFile == null) goto _L4; else goto _L3
_L3:
        Exception exception;
        IOException ioexception1;
        RandomAccessFile randomaccessfile;
        IOException ioexception3;
        FileNotFoundException filenotfoundexception;
        IOException ioexception4;
        byte abyte1[];
        IOException ioexception5;
        RandomAccessFile randomaccessfile1;
        IOException ioexception6;
        IOException ioexception7;
        RandomAccessFile randomaccessfile2;
        IOException ioexception8;
        IOException ioexception9;
        RandomAccessFile randomaccessfile3;
        IOException ioexception10;
        RandomAccessFile randomaccessfile4;
        try {
            randomaccessfile4 = mFile;
        }
        catch(IOException ioexception11) {
            continue; /* Loop/switch isn't completed */
        }
        try {
            randomaccessfile4.close();
        }
        catch(IOException ioexception12) { }
_L9:
        mFile = null;
_L4:
        return;
_L2:
        abyte1 = new byte[mFile.readInt()];
        mFile.read(abyte1);
        if("2344453f7a6ff34e610abad9ee41a48ddbf6430d".equals(new String(abyte1)))
            break MISSING_BLOCK_LABEL_194;
        Log.w("ChineseTelocation", "Unmatched digest for /etc/telocation.td, NO mobile telocation supported!");
        if(false || mFile == null) goto _L4; else goto _L5
_L5:
        try {
            randomaccessfile3 = mFile;
        }
        // Misplaced declaration of an exception variable
        catch(IOException ioexception9) {
            continue; /* Loop/switch isn't completed */
        }
        try {
            randomaccessfile3.close();
        }
        // Misplaced declaration of an exception variable
        catch(IOException ioexception10) { }
        continue; /* Loop/switch isn't completed */
        if(1 == mFile.readInt())
            break MISSING_BLOCK_LABEL_243;
        Log.w("ChineseTelocation", "Unmatched version for /etc/telocation.td, NO mobile telocation supported!");
        if(false || mFile == null) goto _L4; else goto _L6
_L6:
        try {
            randomaccessfile2 = mFile;
        }
        // Misplaced declaration of an exception variable
        catch(IOException ioexception7) {
            continue; /* Loop/switch isn't completed */
        }
        try {
            randomaccessfile2.close();
        }
        // Misplaced declaration of an exception variable
        catch(IOException ioexception8) { }
        continue; /* Loop/switch isn't completed */
        Log.d("ChineseTelocation", (new StringBuilder()).append("[").append(System.currentTimeMillis() - l).append("]ms to load data file").toString());
        if(false && mFile != null) {
            try {
                randomaccessfile1 = mFile;
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception5) {
                continue; /* Loop/switch isn't completed */
            }
            try {
                randomaccessfile1.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception6) { }
            continue; /* Loop/switch isn't completed */
        }
          goto _L4
        filenotfoundexception;
        Log.w("ChineseTelocation", "Can't find /etc/telocation.td, NO mobile telocation supported!");
        if(true && mFile != null) {
            try {
                mFile.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception4) { }
            continue; /* Loop/switch isn't completed */
        }
          goto _L4
        ioexception1;
        Log.w("ChineseTelocation", "Can't read /etc/telocation.td, NO mobile telocation supported!");
        if(false || mFile == null) goto _L4; else goto _L7
_L7:
        randomaccessfile = mFile;
        try {
            randomaccessfile.close();
        }
        // Misplaced declaration of an exception variable
        catch(IOException ioexception3) { }
        continue; /* Loop/switch isn't completed */
        exception;
        if(false && mFile != null) {
            IOException ioexception2;
            try {
                mFile.close();
            }
            catch(IOException ioexception) { }
            mFile = null;
        }
        throw exception;
        ioexception2;
        if(true) goto _L9; else goto _L8
_L8:
    }

    private int convertUniqIdToIndex(int i) {
        if(i < 1 || i > 999) goto _L2; else goto _L1
_L1:
        int j = i;
_L4:
        return j;
_L2:
        int k;
        long l;
        if(i < 0x493e0 || i > 0xdbb9f)
            break MISSING_BLOCK_LABEL_89;
        k = (i - 0x493e0 << 1) + FILE_HEADER_SIZE;
        if(mFile == null)
            break MISSING_BLOCK_LABEL_89;
        l = k;
        short word0;
        if(l >= mFile.length())
            break MISSING_BLOCK_LABEL_89;
        mFile.seek(k);
        word0 = mFile.readShort();
        j = word0;
        continue; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        j = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private String findCustomLocation(int i, CharSequence charsequence, int j, int k) {
        String s;
        s = null;
        if(i > 0)
            s = (String)mNormalCustomLocations.get(Integer.valueOf(i));
        if(s != null || mGroupCustomLocations.size() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator = mGroupCustomLocations.keySet().iterator();
_L4:
        if(iterator.hasNext()) {
            String s1 = (String)iterator.next();
            if(k != s1.length())
                continue; /* Loop/switch isn't completed */
            boolean flag = true;
            int l = 0;
            int i1 = s1.length();
            do {
label0:
                {
                    if(l < i1) {
                        if(s1.charAt(l) == '#' || s1.charAt(l) == charsequence.charAt(j + l))
                            break label0;
                        flag = false;
                    }
                    if(flag)
                        s = (String)mGroupCustomLocations.get(s1);
                    continue; /* Loop/switch isn't completed */
                }
                l++;
            } while(true);
        }
_L2:
        if(s == null)
            s = "";
        return s;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static ChineseTelocation getInstance() {
        return sInstance;
    }

    private void initObserver(Context context) {
        mContext = context.getApplicationContext();
        if(mContext == null)
            mContext = context;
        updateTelocationSetting();
        updateCustomLocation();
        Handler handler = new Handler(mContext.getMainLooper());
        mSettingObserver = new ContentObserver(handler) {

            public void onChange(boolean flag) {
                super.onChange(flag);
                Log.d("ChineseTelocation", "telocation setting changed, reloading ...");
                updateTelocationSetting();
            }

            final ChineseTelocation this$0;

             {
                this$0 = ChineseTelocation.this;
                super(handler);
            }
        };
        mContext.getContentResolver().registerContentObserver(android.provider.Settings.System.getUriFor("enable_telocation"), false, mSettingObserver);
        mCustomLocationObserver = new ContentObserver(handler) {

            public void onChange(boolean flag) {
                super.onChange(flag);
                Log.d("ChineseTelocation", "custom location changed, reloading ...");
                updateCustomLocation();
            }

            final ChineseTelocation this$0;

             {
                this$0 = ChineseTelocation.this;
                super(handler);
            }
        };
        mContext.getContentResolver().registerContentObserver(Telocation.CONTENT_CUSTOM_LOCATION_URI, true, mCustomLocationObserver);
    }

    private void updateCustomLocation() {
        mNormalCustomLocations.clear();
        mGroupCustomLocations.clear();
        if(!mAllowTelocation) goto _L2; else goto _L1
_L1:
        Cursor cursor = null;
        ContentResolver contentresolver = mContext.getContentResolver();
        android.net.Uri uri = Telocation.CONTENT_CUSTOM_LOCATION_URI;
        String as[] = new String[4];
        as[0] = "_id";
        as[1] = "number";
        as[2] = "location";
        as[3] = "type";
        cursor = contentresolver.query(uri, as, null, null, null);
        if(cursor == null) goto _L4; else goto _L3
_L3:
        if(!cursor.moveToNext()) goto _L4; else goto _L5
_L5:
        int i;
        String s;
        String s1;
        i = cursor.getInt(3);
        s = cursor.getString(1);
        s1 = cursor.getString(2);
        i;
        JVM INSTR tableswitch 0 2: default 264
    //                   0 152
    //                   1 152
    //                   2 238;
           goto _L3 _L6 _L6 _L7
_L6:
        byte byte0 = 0;
        if(!s.startsWith("+86")) goto _L9; else goto _L8
_L8:
        byte0 = 3;
_L11:
        int j = getUniqId(s, byte0, s.length(), true);
        if(j != 0)
            mNormalCustomLocations.put(Integer.valueOf(j), s1);
          goto _L3
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
_L9:
        if(!s.startsWith("0086")) goto _L11; else goto _L10
_L10:
        byte0 = 4;
          goto _L11
_L7:
        mGroupCustomLocations.put(s, s1);
          goto _L3
_L4:
        if(cursor != null)
            cursor.close();
_L2:
    }

    private void updateTelocationSetting() {
        boolean flag = true;
        if(android.provider.Settings.System.getInt(mContext.getContentResolver(), "enable_telocation", flag) == 0)
            flag = false;
        mAllowTelocation = flag;
        updateCustomLocation();
    }

    protected void finalize() throws Throwable {
        if(mFile != null)
            try {
                mFile.close();
            }
            catch(IOException ioexception) { }
        if(mSettingObserver != null)
            mContext.getContentResolver().unregisterContentObserver(mSettingObserver);
        if(mCustomLocationObserver != null)
            mContext.getContentResolver().unregisterContentObserver(mCustomLocationObserver);
        super.finalize();
    }

    public String getAreaCode(Context context, CharSequence charsequence, int i, int j) {
        int k = getUniqId(charsequence, i, j, true);
        return TelocationConstants.AREA_CODES[convertUniqIdToIndex(k)];
    }

    public String getExternalLocation(Context context, String s, CharSequence charsequence, Locale locale) {
        if(mContext == null)
            initObserver(context);
        if(mAllowTelocation) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        return s1;
_L2:
        if(TextUtils.isEmpty(s)) {
            s = CountryCode.getUserDefinedCountryCode();
            if(TextUtils.isEmpty(s))
                s = CountryCode.getIccCountryCode();
        }
        String s2;
        if(TextUtils.isEmpty(s))
            break MISSING_BLOCK_LABEL_93;
        s2 = PhoneNumberOfflineGeocoder.getInstance().getDescriptionForNumber(PhoneNumberUtil.getInstance().parse(charsequence.toString(), PhoneNumberUtil.getInstance().getRegionCodeForCountryCode(Integer.parseInt(s))), locale);
        s1 = s2;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        s1 = "";
        if(true) goto _L4; else goto _L3
_L3:
    }

    public String getLocation(Context context, CharSequence charsequence, int i, int j, boolean flag) {
        if(mContext == null)
            initObserver(context);
        if(mAllowTelocation) goto _L2; else goto _L1
_L1:
        String s = null;
_L4:
        return s;
_L2:
        int k = -1;
        if(flag)
            k = getUniqId(charsequence, i, j, true);
        s = findCustomLocation(k, charsequence, i, j);
        if(TextUtils.isEmpty(s) && k > 0)
            s = TelocationConstants.AREA_LOCATIONS[convertUniqIdToIndex(k)];
        if(true) goto _L4; else goto _L3
_L3:
    }

    int getUniqId(CharSequence charsequence, int i, int j, boolean flag) {
        if(j > 0 && charsequence.charAt(i) == '0') {
            i++;
            j--;
        }
        if(j > 1) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        switch(charsequence.charAt(i)) {
        default:
            if(j > 2) {
                int i1 = 10 * (10 * (-48 + charsequence.charAt(i)) + (-48 + charsequence.charAt(i + 1))) + (-48 + charsequence.charAt(i + 2));
                k = AREA_CODES_INDEX[i1];
                continue; /* Loop/switch isn't completed */
            }
            break;

        case 48: // '0'
            break;

        case 49: // '1'
            if(charsequence.charAt(i + 1) == '0') {
                k = AREA_CODES_INDEX[10];
                continue; /* Loop/switch isn't completed */
            }
            if(!flag || j <= 6)
                break;
            k = 0x186a0 * (-48 + charsequence.charAt(i + 1)) + 10000 * (-48 + charsequence.charAt(i + 2)) + 1000 * (-48 + charsequence.charAt(i + 3)) + 100 * (-48 + charsequence.charAt(i + 4)) + 10 * (-48 + charsequence.charAt(i + 5)) + (-48 + charsequence.charAt(i + 6));
            if(k == 0x1388d && j > 10 && charsequence.charAt(i + 7) == '8' && charsequence.charAt(i + 8) == '0' && charsequence.charAt(i + 9) == '0' && charsequence.charAt(i + 10) == '0')
                k = 0;
            continue; /* Loop/switch isn't completed */

        case 50: // '2'
            int l = 10 * (-48 + charsequence.charAt(i)) + (-48 + charsequence.charAt(i + 1));
            k = AREA_CODES_INDEX[l];
            continue; /* Loop/switch isn't completed */
        }
        k = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public String parseAreaCode(CharSequence charsequence, int i, int j) {
        int k = getUniqId(charsequence, i, j, false);
        return TelocationConstants.AREA_CODES[convertUniqIdToIndex(k)];
    }

    private static final short AREA_CODES_INDEX[];
    private static final String DATA_PATH = "/etc/telocation.td";
    private static final String EMPTY = "";
    private static final int FILE_HEADER_SIZE = 0;
    private static final int FILE_VERSION = 1;
    private static final int INDEX_NONE = 0;
    private static final int MAX_MOB_UNIQUE_ID = 0xdbb9f;
    private static final int MAX_TEL_UNIQUE_ID = 999;
    private static final int MIN_MOB_UNIQUE_ID = 0x493e0;
    private static final int MIN_TEL_UNIQUE_ID = 1;
    private static final String TAG = "ChineseTelocation";
    private static final int UNIQUE_ID_NONE;
    private static ChineseTelocation sInstance = new ChineseTelocation();
    private boolean mAllowTelocation;
    private Context mContext;
    private ContentObserver mCustomLocationObserver;
    private RandomAccessFile mFile;
    private HashMap mGroupCustomLocations;
    private HashMap mNormalCustomLocations;
    private ContentObserver mSettingObserver;

    static  {
        FILE_HEADER_SIZE = 0 + (4 + (4 + (4 + TelocationConstants.FILE_TAG.length + "2344453f7a6ff34e610abad9ee41a48ddbf6430d".getBytes().length)));
        AREA_CODES_INDEX = new short[1000];
        Arrays.fill(AREA_CODES_INDEX, (short)0);
        for(int i = 1; i < 327; i++) {
            String s = TelocationConstants.AREA_CODES[i];
            int j = 10 * (-48 + s.charAt(0)) + (-48 + s.charAt(1));
            if(s.length() == 3)
                j = j * 10 + (-48 + s.charAt(2));
            AREA_CODES_INDEX[j] = (short)i;
        }

    }


}
