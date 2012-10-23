// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.*;
import java.util.ArrayList;

// Referenced classes of package com.android.internal.telephony:
//            IccConstants, CommandsInterface, IccIoResult, IccFileTypeMismatch, 
//            IccUtils, IccCard

public abstract class IccFileHandler extends Handler
    implements IccConstants {
    static class LoadLinearFixedContext {

        int countRecords;
        int efid;
        boolean loadAll;
        Message onLoaded;
        int recordNum;
        int recordSize;
        ArrayList results;

        LoadLinearFixedContext(int i, int j, Message message) {
            efid = i;
            recordNum = j;
            onLoaded = message;
            loadAll = false;
        }

        LoadLinearFixedContext(int i, Message message) {
            efid = i;
            recordNum = 1;
            loadAll = true;
            onLoaded = message;
        }
    }


    protected IccFileHandler(IccCard icccard, String s, CommandsInterface commandsinterface) {
        mParentCard = icccard;
        mAid = s;
        mCi = commandsinterface;
    }

    private void sendResult(Message message, Object obj, Throwable throwable) {
        if(message != null) {
            AsyncResult.forMessage(message, obj, throwable);
            message.sendToTarget();
        }
    }

    public void dispose() {
    }

    protected String getCommonIccEFPath(int i) {
        i;
        JVM INSTR lookupswitch 10: default 92
    //                   12037: 102
    //                   12258: 102
    //                   20256: 108
    //                   28474: 96
    //                   28475: 96
    //                   28480: 96
    //                   28489: 96
    //                   28490: 96
    //                   28491: 96
    //                   28492: 96;
           goto _L1 _L2 _L2 _L3 _L4 _L4 _L4 _L4 _L4 _L4 _L4
_L1:
        String s = null;
_L6:
        return s;
_L4:
        s = "3F007F10";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "3F00";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "3F007F105F50";
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void getEFLinearRecordSize(int i, Message message) {
        Message message1 = obtainMessage(8, new LoadLinearFixedContext(i, message));
        mCi.iccIOForApp(192, i, getEFPath(i), 0, 0, 15, null, null, mAid, message1);
    }

    protected abstract String getEFPath(int i);

    public void handleMessage(Message message) {
        Message message1 = null;
        message.what;
        JVM INSTR tableswitch 4 10: default 1164
    //                   4 638
    //                   5 1046
    //                   6 377
    //                   7 825
    //                   8 194
    //                   9 48
    //                   10 132;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        break; /* Loop/switch isn't completed */
_L7:
        AsyncResult asyncresult6 = (AsyncResult)message.obj;
        LoadLinearFixedContext loadlinearfixedcontext3 = (LoadLinearFixedContext)asyncresult6.userObj;
        IccIoResult iccioresult6 = (IccIoResult)asyncresult6.result;
        message1 = loadlinearfixedcontext3.onLoaded;
        if(iccioresult6.getException() != null) {
            byte abyte6[] = iccioresult6.payload;
            Throwable throwable6 = asyncresult6.exception;
            sendResult(message1, abyte6, throwable6);
        }
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        AsyncResult asyncresult;
        IccIoResult iccioresult;
        IccException iccexception;
        byte abyte0[];
        Throwable throwable;
        AsyncResult asyncresult1;
        LoadLinearFixedContext loadlinearfixedcontext;
        IccIoResult iccioresult1;
        IccException iccexception1;
        ArrayList arraylist;
        byte abyte1[];
        Throwable throwable1;
        AsyncResult asyncresult2;
        IccIoResult iccioresult2;
        IccException iccexception2;
        byte abyte2[];
        int i;
        int j;
        Throwable throwable2;
        AsyncResult asyncresult3;
        LoadLinearFixedContext loadlinearfixedcontext1;
        IccIoResult iccioresult3;
        IccException iccexception3;
        byte abyte3[];
        Throwable throwable3;
        AsyncResult asyncresult4;
        LoadLinearFixedContext loadlinearfixedcontext2;
        IccIoResult iccioresult4;
        IccException iccexception4;
        byte abyte4[];
        int ai[];
        Throwable throwable4;
        AsyncResult asyncresult5;
        IccIoResult iccioresult5;
        byte abyte5[];
        Throwable throwable5;
        if(message1 != null)
            sendResult(message1, null, exception);
        else
            loge((new StringBuilder()).append("uncaught exception").append(exception).toString());
        break; /* Loop/switch isn't completed */
_L8:
        asyncresult5 = (AsyncResult)message.obj;
        message1 = (Message)asyncresult5.userObj;
        iccioresult5 = (IccIoResult)asyncresult5.result;
        if(iccioresult5.getException() != null) {
            abyte5 = iccioresult5.payload;
            throwable5 = asyncresult5.exception;
            sendResult(message1, abyte5, throwable5);
        }
        break; /* Loop/switch isn't completed */
_L6:
        asyncresult4 = (AsyncResult)message.obj;
        loadlinearfixedcontext2 = (LoadLinearFixedContext)asyncresult4.userObj;
        iccioresult4 = (IccIoResult)asyncresult4.result;
        message1 = loadlinearfixedcontext2.onLoaded;
        if(asyncresult4.exception != null) {
            throwable4 = asyncresult4.exception;
            sendResult(message1, null, throwable4);
            break; /* Loop/switch isn't completed */
        }
        iccexception4 = iccioresult4.getException();
        if(iccexception4 != null) {
            sendResult(message1, null, iccexception4);
            break; /* Loop/switch isn't completed */
        }
        abyte4 = iccioresult4.payload;
        if(4 != abyte4[6] || 1 != abyte4[13])
            throw new IccFileTypeMismatch();
        ai = new int[3];
        ai[0] = 0xff & abyte4[14];
        ai[1] = ((0xff & abyte4[2]) << 8) + (0xff & abyte4[3]);
        ai[2] = ai[1] / ai[0];
        sendResult(message1, ai, null);
        break; /* Loop/switch isn't completed */
_L4:
        asyncresult3 = (AsyncResult)message.obj;
        loadlinearfixedcontext1 = (LoadLinearFixedContext)asyncresult3.userObj;
        iccioresult3 = (IccIoResult)asyncresult3.result;
        message1 = loadlinearfixedcontext1.onLoaded;
        if(asyncresult3.exception != null) {
            throwable3 = asyncresult3.exception;
            sendResult(message1, null, throwable3);
            break; /* Loop/switch isn't completed */
        }
        iccexception3 = iccioresult3.getException();
        if(iccexception3 != null) {
            sendResult(message1, null, iccexception3);
            break; /* Loop/switch isn't completed */
        }
        abyte3 = iccioresult3.payload;
        loadlinearfixedcontext1.efid;
        loadlinearfixedcontext1.recordNum;
        if(4 != abyte3[6])
            throw new IccFileTypeMismatch();
        if(1 != abyte3[13])
            throw new IccFileTypeMismatch();
        loadlinearfixedcontext1.recordSize = 0xff & abyte3[14];
        loadlinearfixedcontext1.countRecords = (((0xff & abyte3[2]) << 8) + (0xff & abyte3[3])) / loadlinearfixedcontext1.recordSize;
        if(loadlinearfixedcontext1.loadAll)
            loadlinearfixedcontext1.results = new ArrayList(loadlinearfixedcontext1.countRecords);
        mCi.iccIOForApp(178, loadlinearfixedcontext1.efid, getEFPath(loadlinearfixedcontext1.efid), loadlinearfixedcontext1.recordNum, 4, loadlinearfixedcontext1.recordSize, null, null, mAid, obtainMessage(7, loadlinearfixedcontext1));
        break; /* Loop/switch isn't completed */
_L2:
        asyncresult2 = (AsyncResult)message.obj;
        message1 = (Message)asyncresult2.userObj;
        iccioresult2 = (IccIoResult)asyncresult2.result;
        if(asyncresult2.exception != null) {
            throwable2 = asyncresult2.exception;
            sendResult(message1, null, throwable2);
            break; /* Loop/switch isn't completed */
        }
        iccexception2 = iccioresult2.getException();
        if(iccexception2 != null) {
            sendResult(message1, null, iccexception2);
            break; /* Loop/switch isn't completed */
        }
        abyte2 = iccioresult2.payload;
        i = message.arg1;
        if(4 != abyte2[6])
            throw new IccFileTypeMismatch();
        if(abyte2[13] != 0)
            throw new IccFileTypeMismatch();
        j = ((0xff & abyte2[2]) << 8) + (0xff & abyte2[3]);
        mCi.iccIOForApp(176, i, getEFPath(i), 0, 0, j, null, null, mAid, obtainMessage(5, i, 0, message1));
        break; /* Loop/switch isn't completed */
_L5:
        asyncresult1 = (AsyncResult)message.obj;
        loadlinearfixedcontext = (LoadLinearFixedContext)asyncresult1.userObj;
        iccioresult1 = (IccIoResult)asyncresult1.result;
        message1 = loadlinearfixedcontext.onLoaded;
        if(asyncresult1.exception != null) {
            throwable1 = asyncresult1.exception;
            sendResult(message1, null, throwable1);
            break; /* Loop/switch isn't completed */
        }
        iccexception1 = iccioresult1.getException();
        if(iccexception1 != null) {
            sendResult(message1, null, iccexception1);
            break; /* Loop/switch isn't completed */
        }
        if(!loadlinearfixedcontext.loadAll) {
            abyte1 = iccioresult1.payload;
            sendResult(message1, abyte1, null);
            break; /* Loop/switch isn't completed */
        }
        loadlinearfixedcontext.results.add(iccioresult1.payload);
        loadlinearfixedcontext.recordNum = 1 + loadlinearfixedcontext.recordNum;
        if(loadlinearfixedcontext.recordNum > loadlinearfixedcontext.countRecords) {
            arraylist = loadlinearfixedcontext.results;
            sendResult(message1, arraylist, null);
        } else {
            mCi.iccIOForApp(178, loadlinearfixedcontext.efid, getEFPath(loadlinearfixedcontext.efid), loadlinearfixedcontext.recordNum, 4, loadlinearfixedcontext.recordSize, null, null, mAid, obtainMessage(7, loadlinearfixedcontext));
        }
        break; /* Loop/switch isn't completed */
_L3:
        asyncresult = (AsyncResult)message.obj;
        message1 = (Message)asyncresult.userObj;
        iccioresult = (IccIoResult)asyncresult.result;
        if(asyncresult.exception != null) {
            throwable = asyncresult.exception;
            sendResult(message1, null, throwable);
            break; /* Loop/switch isn't completed */
        }
        iccexception = iccioresult.getException();
        if(iccexception != null) {
            sendResult(message1, null, iccexception);
        } else {
            abyte0 = iccioresult.payload;
            sendResult(message1, abyte0, null);
        }
    }

    public void loadEFImgLinearFixed(int i, Message message) {
        Message message1 = obtainMessage(9, new LoadLinearFixedContext(20256, i, message));
        mCi.iccIOForApp(192, 20256, "img", i, 4, 10, null, null, mAid, message1);
    }

    public void loadEFImgTransparent(int i, int j, int k, int l, Message message) {
        Message message1 = obtainMessage(10, i, 0, message);
        mCi.iccIOForApp(176, i, "img", j, k, l, null, null, mAid, message1);
    }

    public void loadEFLinearFixed(int i, int j, Message message) {
        Message message1 = obtainMessage(6, new LoadLinearFixedContext(i, j, message));
        mCi.iccIOForApp(192, i, getEFPath(i), 0, 0, 15, null, null, mAid, message1);
    }

    public void loadEFLinearFixedAll(int i, Message message) {
        Message message1 = obtainMessage(6, new LoadLinearFixedContext(i, message));
        mCi.iccIOForApp(192, i, getEFPath(i), 0, 0, 15, null, null, mAid, message1);
    }

    public void loadEFTransparent(int i, Message message) {
        Message message1 = obtainMessage(4, i, 0, message);
        mCi.iccIOForApp(192, i, getEFPath(i), 0, 0, 15, null, null, mAid, message1);
    }

    protected abstract void logd(String s);

    protected abstract void loge(String s);

    protected void setAid(String s) {
        mAid = s;
    }

    public void updateEFLinearFixed(int i, int j, byte abyte0[], String s, Message message) {
        mCi.iccIOForApp(220, i, getEFPath(i), j, 4, abyte0.length, IccUtils.bytesToHexString(abyte0), s, mAid, message);
    }

    public void updateEFTransparent(int i, byte abyte0[], Message message) {
        mCi.iccIOForApp(214, i, getEFPath(i), 0, 0, abyte0.length, IccUtils.bytesToHexString(abyte0), null, mAid, message);
    }

    protected static final int COMMAND_GET_RESPONSE = 192;
    protected static final int COMMAND_READ_BINARY = 176;
    protected static final int COMMAND_READ_RECORD = 178;
    protected static final int COMMAND_SEEK = 162;
    protected static final int COMMAND_UPDATE_BINARY = 214;
    protected static final int COMMAND_UPDATE_RECORD = 220;
    protected static final int EF_TYPE_CYCLIC = 3;
    protected static final int EF_TYPE_LINEAR_FIXED = 1;
    protected static final int EF_TYPE_TRANSPARENT = 0;
    protected static final int EVENT_GET_BINARY_SIZE_DONE = 4;
    protected static final int EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE = 8;
    protected static final int EVENT_GET_RECORD_SIZE_DONE = 6;
    protected static final int EVENT_READ_BINARY_DONE = 5;
    protected static final int EVENT_READ_ICON_DONE = 10;
    protected static final int EVENT_READ_IMG_DONE = 9;
    protected static final int EVENT_READ_RECORD_DONE = 7;
    protected static final int GET_RESPONSE_EF_IMG_SIZE_BYTES = 10;
    protected static final int GET_RESPONSE_EF_SIZE_BYTES = 15;
    protected static final int READ_RECORD_MODE_ABSOLUTE = 4;
    protected static final int RESPONSE_DATA_ACCESS_CONDITION_1 = 8;
    protected static final int RESPONSE_DATA_ACCESS_CONDITION_2 = 9;
    protected static final int RESPONSE_DATA_ACCESS_CONDITION_3 = 10;
    protected static final int RESPONSE_DATA_FILE_ID_1 = 4;
    protected static final int RESPONSE_DATA_FILE_ID_2 = 5;
    protected static final int RESPONSE_DATA_FILE_SIZE_1 = 2;
    protected static final int RESPONSE_DATA_FILE_SIZE_2 = 3;
    protected static final int RESPONSE_DATA_FILE_STATUS = 11;
    protected static final int RESPONSE_DATA_FILE_TYPE = 6;
    protected static final int RESPONSE_DATA_LENGTH = 12;
    protected static final int RESPONSE_DATA_RECORD_LENGTH = 14;
    protected static final int RESPONSE_DATA_RFU_1 = 0;
    protected static final int RESPONSE_DATA_RFU_2 = 1;
    protected static final int RESPONSE_DATA_RFU_3 = 7;
    protected static final int RESPONSE_DATA_STRUCTURE = 13;
    protected static final int TYPE_DF = 2;
    protected static final int TYPE_EF = 4;
    protected static final int TYPE_MF = 1;
    protected static final int TYPE_RFU;
    protected String mAid;
    protected final CommandsInterface mCi;
    protected final IccCard mParentCard;
}
