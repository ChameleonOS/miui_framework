// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.util.XmlUtils;
import java.io.*;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.android.internal.telephony.cdma:
//            EriInfo

public final class EriManager {
    class EriDisplayInformation {

        public String toString() {
            return (new StringBuilder()).append("EriDisplayInformation: { IconIndex: ").append(mEriIconIndex).append(" EriIconMode: ").append(mEriIconMode).append(" EriIconText: ").append(mEriIconText).append(" }").toString();
        }

        public int mEriIconIndex;
        public int mEriIconMode;
        public String mEriIconText;
        final EriManager this$0;

        public EriDisplayInformation(int i, int j, String s) {
            this$0 = EriManager.this;
            super();
            mEriIconIndex = i;
            mEriIconMode = j;
            mEriIconText = s;
        }
    }

    class EriFile {

        public String mCallPromptId[];
        public int mEriFileType;
        public int mNumberOfEriEntries;
        public HashMap mRoamIndTable;
        public int mVersionNumber;
        final EriManager this$0;

        public EriFile() {
            this$0 = EriManager.this;
            super();
            mVersionNumber = -1;
            mNumberOfEriEntries = 0;
            mEriFileType = -1;
            String as[] = new String[3];
            as[0] = "";
            as[1] = "";
            as[2] = "";
            mCallPromptId = as;
            mRoamIndTable = new HashMap();
        }
    }


    public EriManager(PhoneBase phonebase, Context context, int i) {
        mEriFileSource = 0;
        mPhone = phonebase;
        mContext = context;
        mEriFileSource = i;
        mEriFile = new EriFile();
    }

    private EriDisplayInformation getEriDisplayInformation(int i, int j) {
        if(!isEriFileLoaded) goto _L2; else goto _L1
_L1:
        EriInfo eriinfo2 = getEriInfo(i);
        if(eriinfo2 == null) goto _L2; else goto _L3
_L3:
        EriDisplayInformation eridisplayinformation1 = new EriDisplayInformation(eriinfo2.mIconIndex, eriinfo2.mIconMode, eriinfo2.mEriText);
_L22:
        return eridisplayinformation1;
_L2:
        i;
        JVM INSTR tableswitch 0 12: default 116
    //                   0 165
    //                   1 191
    //                   2 217
    //                   3 243
    //                   4 269
    //                   5 295
    //                   6 321
    //                   7 347
    //                   8 373
    //                   9 399
    //                   10 425
    //                   11 451
    //                   12 477;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L4:
        if(isEriFileLoaded) goto _L19; else goto _L18
_L18:
        Log.d("CDMA", "ERI File not loaded");
        if(j <= 2) goto _L21; else goto _L20
_L20:
        EriDisplayInformation eridisplayinformation = new EriDisplayInformation(2, 1, mContext.getText(0x10400fe).toString());
_L23:
        eridisplayinformation1 = eridisplayinformation;
          goto _L22
_L5:
        eridisplayinformation = new EriDisplayInformation(0, 0, mContext.getText(0x10400fc).toString());
          goto _L23
_L6:
        eridisplayinformation = new EriDisplayInformation(1, 0, mContext.getText(0x10400fd).toString());
          goto _L23
_L7:
        eridisplayinformation = new EriDisplayInformation(2, 1, mContext.getText(0x10400fe).toString());
          goto _L23
_L8:
        eridisplayinformation = new EriDisplayInformation(i, 0, mContext.getText(0x10400ff).toString());
          goto _L23
_L9:
        eridisplayinformation = new EriDisplayInformation(i, 0, mContext.getText(0x1040100).toString());
          goto _L23
_L10:
        eridisplayinformation = new EriDisplayInformation(i, 0, mContext.getText(0x1040101).toString());
          goto _L23
_L11:
        eridisplayinformation = new EriDisplayInformation(i, 0, mContext.getText(0x1040102).toString());
          goto _L23
_L12:
        eridisplayinformation = new EriDisplayInformation(i, 0, mContext.getText(0x1040103).toString());
          goto _L23
_L13:
        eridisplayinformation = new EriDisplayInformation(i, 0, mContext.getText(0x1040104).toString());
          goto _L23
_L14:
        eridisplayinformation = new EriDisplayInformation(i, 0, mContext.getText(0x1040105).toString());
          goto _L23
_L15:
        eridisplayinformation = new EriDisplayInformation(i, 0, mContext.getText(0x1040106).toString());
          goto _L23
_L16:
        eridisplayinformation = new EriDisplayInformation(i, 0, mContext.getText(0x1040107).toString());
          goto _L23
_L17:
        eridisplayinformation = new EriDisplayInformation(i, 0, mContext.getText(0x1040108).toString());
          goto _L23
_L21:
        switch(j) {
        default:
            eridisplayinformation = new EriDisplayInformation(-1, -1, "ERI text");
            break;

        case 0: // '\0'
            eridisplayinformation = new EriDisplayInformation(0, 0, mContext.getText(0x10400fc).toString());
            break;

        case 1: // '\001'
            eridisplayinformation = new EriDisplayInformation(1, 0, mContext.getText(0x10400fd).toString());
            break;

        case 2: // '\002'
            eridisplayinformation = new EriDisplayInformation(2, 1, mContext.getText(0x10400fe).toString());
            break;
        }
        continue; /* Loop/switch isn't completed */
_L19:
        EriInfo eriinfo = getEriInfo(i);
        EriInfo eriinfo1 = getEriInfo(j);
        if(eriinfo == null) {
            if(eriinfo1 == null) {
                Log.e("CDMA", (new StringBuilder()).append("ERI defRoamInd ").append(j).append(" not found in ERI file ...on").toString());
                eridisplayinformation = new EriDisplayInformation(0, 0, mContext.getText(0x10400fc).toString());
            } else {
                eridisplayinformation = new EriDisplayInformation(eriinfo1.mIconIndex, eriinfo1.mIconMode, eriinfo1.mEriText);
            }
        } else {
            eridisplayinformation = new EriDisplayInformation(eriinfo.mIconIndex, eriinfo.mIconMode, eriinfo.mEriText);
        }
        if(true) goto _L23; else goto _L24
_L24:
    }

    private EriInfo getEriInfo(int i) {
        EriInfo eriinfo;
        if(mEriFile.mRoamIndTable.containsKey(Integer.valueOf(i)))
            eriinfo = (EriInfo)mEriFile.mRoamIndTable.get(Integer.valueOf(i));
        else
            eriinfo = null;
        return eriinfo;
    }

    private void loadEriFileFromFileSystem() {
    }

    private void loadEriFileFromModem() {
    }

    private void loadEriFileFromXml() {
        FileInputStream fileinputstream;
        Resources resources;
        fileinputstream = null;
        resources = mContext.getResources();
        FileInputStream fileinputstream1;
        Log.d("CDMA", "loadEriFileFromXml: check for alternate file");
        fileinputstream1 = new FileInputStream(resources.getString(0x104047a));
        Object obj;
        obj = Xml.newPullParser();
        ((XmlPullParser) (obj)).setInput(fileinputstream1, null);
        Log.d("CDMA", "loadEriFileFromXml: opened alternate file");
        fileinputstream = fileinputstream1;
_L3:
        if(obj == null) {
            Log.d("CDMA", "loadEriFileFromXml: open normal file");
            obj = resources.getXml(0x10f0002);
        }
        int i;
        XmlUtils.beginDocument(((XmlPullParser) (obj)), "EriFile");
        mEriFile.mVersionNumber = Integer.parseInt(((XmlPullParser) (obj)).getAttributeValue(null, "VersionNumber"));
        mEriFile.mNumberOfEriEntries = Integer.parseInt(((XmlPullParser) (obj)).getAttributeValue(null, "NumberOfEriEntries"));
        mEriFile.mEriFileType = Integer.parseInt(((XmlPullParser) (obj)).getAttributeValue(null, "EriFileType"));
        i = 0;
_L6:
        String s;
        XmlUtils.nextElement(((XmlPullParser) (obj)));
        s = ((XmlPullParser) (obj)).getName();
        if(s != null) goto _L2; else goto _L1
_L1:
        if(i != mEriFile.mNumberOfEriEntries)
            Log.e("CDMA", (new StringBuilder()).append("Error Parsing ERI file: ").append(mEriFile.mNumberOfEriEntries).append(" defined, ").append(i).append(" parsed!").toString());
        Log.d("CDMA", "loadEriFileFromXml: eri parsing successful, file loaded");
        isEriFileLoaded = true;
        if(obj instanceof XmlResourceParser)
            ((XmlResourceParser)obj).close();
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_266;
        fileinputstream.close();
_L7:
        return;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
_L10:
        Log.d("CDMA", "loadEriFileFromXml: no alternate file");
        obj = null;
          goto _L3
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
_L9:
        Log.d("CDMA", "loadEriFileFromXml: no parser for alternate file");
        obj = null;
          goto _L3
_L2:
        if(!s.equals("CallPromptId")) goto _L5; else goto _L4
_L4:
        int k1;
        k1 = Integer.parseInt(((XmlPullParser) (obj)).getAttributeValue(null, "Id"));
        String s2 = ((XmlPullParser) (obj)).getAttributeValue(null, "CallPromptText");
        if(k1 < 0 || k1 > 2)
            break MISSING_BLOCK_LABEL_409;
        mEriFile.mCallPromptId[k1] = s2;
          goto _L6
        Exception exception1;
        exception1;
        Log.e("CDMA", "Got exception while loading ERI file.", exception1);
        if(obj instanceof XmlResourceParser)
            ((XmlResourceParser)obj).close();
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception1) { }
          goto _L7
        Log.e("CDMA", (new StringBuilder()).append("Error Parsing ERI file: found").append(k1).append(" CallPromptId").toString());
          goto _L6
        Exception exception;
        exception;
        if(obj instanceof XmlResourceParser)
            ((XmlResourceParser)obj).close();
        int j;
        int k;
        int l;
        String s1;
        int i1;
        int j1;
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception) { }
        throw exception;
_L5:
        if(!s.equals("EriInfo")) goto _L6; else goto _L8
_L8:
        j = Integer.parseInt(((XmlPullParser) (obj)).getAttributeValue(null, "RoamingIndicator"));
        k = Integer.parseInt(((XmlPullParser) (obj)).getAttributeValue(null, "IconIndex"));
        l = Integer.parseInt(((XmlPullParser) (obj)).getAttributeValue(null, "IconMode"));
        s1 = ((XmlPullParser) (obj)).getAttributeValue(null, "EriText");
        i1 = Integer.parseInt(((XmlPullParser) (obj)).getAttributeValue(null, "CallPromptId"));
        j1 = Integer.parseInt(((XmlPullParser) (obj)).getAttributeValue(null, "AlertId"));
        i++;
        mEriFile.mRoamIndTable.put(Integer.valueOf(j), new EriInfo(j, k, l, s1, i1, j1));
          goto _L6
        XmlPullParserException xmlpullparserexception1;
        xmlpullparserexception1;
        fileinputstream = fileinputstream1;
          goto _L9
        FileNotFoundException filenotfoundexception1;
        filenotfoundexception1;
        fileinputstream = fileinputstream1;
          goto _L10
    }

    public void dispose() {
        mEriFile = new EriFile();
        isEriFileLoaded = false;
    }

    public int getCdmaEriIconIndex(int i, int j) {
        return getEriDisplayInformation(i, j).mEriIconIndex;
    }

    public int getCdmaEriIconMode(int i, int j) {
        return getEriDisplayInformation(i, j).mEriIconMode;
    }

    public String getCdmaEriText(int i, int j) {
        return getEriDisplayInformation(i, j).mEriIconText;
    }

    public int getEriFileType() {
        return mEriFile.mEriFileType;
    }

    public int getEriFileVersion() {
        return mEriFile.mVersionNumber;
    }

    public int getEriNumberOfEntries() {
        return mEriFile.mNumberOfEriEntries;
    }

    public boolean isEriFileLoaded() {
        return isEriFileLoaded;
    }

    public void loadEriFile() {
        mEriFileSource;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 40
    //                   2 33;
           goto _L1 _L2 _L3
_L1:
        loadEriFileFromXml();
_L5:
        return;
_L3:
        loadEriFileFromModem();
        continue; /* Loop/switch isn't completed */
_L2:
        loadEriFileFromFileSystem();
        if(true) goto _L5; else goto _L4
_L4:
    }

    private static final boolean DBG = true;
    public static final int ERI_FROM_FILE_SYSTEM = 1;
    public static final int ERI_FROM_MODEM = 2;
    public static final int ERI_FROM_XML = 0;
    private static final String LOG_TAG = "CDMA";
    private static final boolean VDBG;
    private boolean isEriFileLoaded;
    private Context mContext;
    private EriFile mEriFile;
    private int mEriFileSource;
    private PhoneBase mPhone;
}
