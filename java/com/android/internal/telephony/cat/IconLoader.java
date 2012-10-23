// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.*;
import com.android.internal.telephony.IccFileHandler;
import java.util.HashMap;

// Referenced classes of package com.android.internal.telephony.cat:
//            ImageDescriptor, CatLog

class IconLoader extends Handler {

    private IconLoader(Looper looper, IccFileHandler iccfilehandler) {
        super(looper);
        mState = 1;
        mId = null;
        mCurrentIcon = null;
        mSimFH = null;
        mEndMsg = null;
        mIconData = null;
        mRecordNumbers = null;
        mCurrentRecordIndex = 0;
        mIcons = null;
        mIconsCache = null;
        mSimFH = iccfilehandler;
        mIconsCache = new HashMap(50);
    }

    private static int bitToBnW(int i) {
        int j;
        if(i == 1)
            j = -1;
        else
            j = 0xff000000;
        return j;
    }

    static IconLoader getInstance(Handler handler, IccFileHandler iccfilehandler) {
        IconLoader iconloader;
        if(sLoader != null)
            iconloader = sLoader;
        else
        if(iccfilehandler != null) {
            HandlerThread handlerthread = new HandlerThread("Cat Icon Loader");
            handlerthread.start();
            iconloader = new IconLoader(handlerthread.getLooper(), iccfilehandler);
        } else {
            iconloader = null;
        }
        return iconloader;
    }

    private static int getMask(int i) {
        int j = 0;
        i;
        JVM INSTR tableswitch 1 8: default 48
    //                   1 50
    //                   2 55
    //                   3 60
    //                   4 66
    //                   5 72
    //                   6 78
    //                   7 84
    //                   8 90;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        return j;
_L2:
        j = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        j = 3;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 7;
        continue; /* Loop/switch isn't completed */
_L5:
        j = 15;
        continue; /* Loop/switch isn't completed */
_L6:
        j = 31;
        continue; /* Loop/switch isn't completed */
_L7:
        j = 63;
        continue; /* Loop/switch isn't completed */
_L8:
        j = 127;
        continue; /* Loop/switch isn't completed */
_L9:
        j = 255;
        if(true) goto _L1; else goto _L10
_L10:
    }

    private boolean handleImageDescriptor(byte abyte0[]) {
        boolean flag = true;
        mId = ImageDescriptor.parse(abyte0, flag);
        if(mId == null)
            flag = false;
        return flag;
    }

    public static Bitmap parseToBnW(byte abyte0[], int i) {
        int j = 0 + 1;
        int k = 0xff & abyte0[0];
        int l = j + 1;
        int i1 = 0xff & abyte0[j];
        int j1 = k * i1;
        int ai[] = new int[j1];
        int k1 = 7;
        byte byte0 = 0;
        int l1 = 0;
        int i2 = l;
        while(l1 < j1)  {
            int j2;
            int k2;
            int l2;
            if(l1 % 8 == 0) {
                j2 = i2 + 1;
                byte0 = abyte0[i2];
                k1 = 7;
            } else {
                j2 = i2;
            }
            k2 = l1 + 1;
            l2 = k1 - 1;
            ai[l1] = bitToBnW(1 & byte0 >> k1);
            k1 = l2;
            l1 = k2;
            i2 = j2;
        }
        if(l1 != j1)
            CatLog.d("IconLoader", "parseToBnW; size error");
        return Bitmap.createBitmap(ai, k, i1, android.graphics.Bitmap.Config.ARGB_8888);
    }

    public static Bitmap parseToRGB(byte abyte0[], int i, boolean flag, byte abyte1[]) {
        int j = 0 + 1;
        int k = 0xff & abyte0[0];
        int l = j + 1;
        int i1 = 0xff & abyte0[j];
        int j1 = l + 1;
        int k1 = 0xff & abyte0[l];
        int _tmp = j1 + 1;
        int l1 = 0xff & abyte0[j1];
        if(flag)
            abyte1[l1 - 1] = 0;
        int i2 = k * i1;
        int ai[] = new int[i2];
        int j2 = 8 - k1;
        int k2 = j2;
        int l2 = 6 + 1;
        byte byte0 = abyte0[6];
        int i3 = getMask(k1);
        boolean flag1;
        int j3;
        if(8 % k1 == 0)
            flag1 = true;
        else
            flag1 = false;
        j3 = 0;
        while(j3 < i2)  {
            int k3;
            if(k2 < 0) {
                k3 = l2 + 1;
                byte0 = abyte0[l2];
                int l3;
                int i4;
                if(flag1)
                    k2 = j2;
                else
                    k2 *= -1;
            } else {
                k3 = l2;
            }
            l3 = 3 * (i3 & byte0 >> k2);
            i4 = j3 + 1;
            ai[j3] = Color.rgb(abyte1[l3], abyte1[l3 + 1], abyte1[l3 + 2]);
            k2 -= k1;
            j3 = i4;
            l2 = k3;
        }
        return Bitmap.createBitmap(ai, k, i1, android.graphics.Bitmap.Config.ARGB_8888);
    }

    private void postIcon() {
        if(mState != 1) goto _L2; else goto _L1
_L1:
        mEndMsg.obj = mCurrentIcon;
        mEndMsg.sendToTarget();
_L4:
        return;
_L2:
        if(mState == 2) {
            Bitmap abitmap[] = mIcons;
            int i = mCurrentRecordIndex;
            mCurrentRecordIndex = i + 1;
            abitmap[i] = mCurrentIcon;
            if(mCurrentRecordIndex < mRecordNumbers.length) {
                startLoadingIcon(mRecordNumbers[mCurrentRecordIndex]);
            } else {
                mEndMsg.obj = mIcons;
                mEndMsg.sendToTarget();
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void readClut() {
        int i = 3 * mIconData[3];
        Message message = obtainMessage(3);
        mSimFH.loadEFImgTransparent(mId.imageId, mIconData[4], mIconData[5], i, message);
    }

    private void readIconData() {
        Message message = obtainMessage(2);
        mSimFH.loadEFImgTransparent(mId.imageId, 0, 0, mId.length, message);
    }

    private void readId() {
        if(mRecordNumber < 0) {
            mCurrentIcon = null;
            postIcon();
        } else {
            Message message = obtainMessage(1);
            mSimFH.loadEFImgLinearFixed(mRecordNumber, message);
        }
    }

    private void startLoadingIcon(int i) {
        mId = null;
        mIconData = null;
        mCurrentIcon = null;
        mRecordNumber = i;
        if(mIconsCache.containsKey(Integer.valueOf(i))) {
            mCurrentIcon = (Bitmap)mIconsCache.get(Integer.valueOf(i));
            postIcon();
        } else {
            readId();
        }
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 1 3: default 237
    //                   1 32
    //                   2 86
    //                   3 179;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        if(handleImageDescriptor((byte[])(byte[])((AsyncResult)message.obj).result)) {
            readIconData();
            break; /* Loop/switch isn't completed */
        }
          goto _L5
        Exception exception;
        exception;
        CatLog.d(this, "Icon load failed");
        postIcon();
        break; /* Loop/switch isn't completed */
_L5:
        throw new Exception("Unable to parse image descriptor");
_L3:
        byte abyte1[] = (byte[])(byte[])((AsyncResult)message.obj).result;
        if(mId.codingScheme == 17) {
            mCurrentIcon = parseToBnW(abyte1, abyte1.length);
            mIconsCache.put(Integer.valueOf(mRecordNumber), mCurrentIcon);
            postIcon();
            break; /* Loop/switch isn't completed */
        }
        if(mId.codingScheme == 33) {
            mIconData = abyte1;
            readClut();
        }
        break; /* Loop/switch isn't completed */
_L4:
        byte abyte0[] = (byte[])(byte[])((AsyncResult)message.obj).result;
        mCurrentIcon = parseToRGB(mIconData, mIconData.length, false, abyte0);
        mIconsCache.put(Integer.valueOf(mRecordNumber), mCurrentIcon);
        postIcon();
    }

    void loadIcon(int i, Message message) {
        if(message != null) {
            mEndMsg = message;
            mState = 1;
            startLoadingIcon(i);
        }
    }

    void loadIcons(int ai[], Message message) {
        if(ai != null && ai.length != 0 && message != null) {
            mEndMsg = message;
            mIcons = new Bitmap[ai.length];
            mRecordNumbers = ai;
            mCurrentRecordIndex = 0;
            mState = 2;
            startLoadingIcon(ai[0]);
        }
    }

    private static final int CLUT_ENTRY_SIZE = 3;
    private static final int CLUT_LOCATION_OFFSET = 4;
    private static final int EVENT_READ_CLUT_DONE = 3;
    private static final int EVENT_READ_EF_IMG_RECOED_DONE = 1;
    private static final int EVENT_READ_ICON_DONE = 2;
    private static final int STATE_MULTI_ICONS = 2;
    private static final int STATE_SINGLE_ICON = 1;
    private static IconLoader sLoader = null;
    private Bitmap mCurrentIcon;
    private int mCurrentRecordIndex;
    private Message mEndMsg;
    private byte mIconData[];
    private Bitmap mIcons[];
    private HashMap mIconsCache;
    private ImageDescriptor mId;
    private int mRecordNumber;
    private int mRecordNumbers[];
    private IccFileHandler mSimFH;
    private int mState;

}
