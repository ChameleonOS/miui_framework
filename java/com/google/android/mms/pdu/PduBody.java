// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import java.util.*;

// Referenced classes of package com.google.android.mms.pdu:
//            PduPart

public class PduBody {

    public PduBody() {
        mParts = null;
        mPartMapByContentId = null;
        mPartMapByContentLocation = null;
        mPartMapByName = null;
        mPartMapByFileName = null;
        mParts = new Vector();
        mPartMapByContentId = new HashMap();
        mPartMapByContentLocation = new HashMap();
        mPartMapByName = new HashMap();
        mPartMapByFileName = new HashMap();
    }

    private void putPartToMaps(PduPart pdupart) {
        byte abyte0[] = pdupart.getContentId();
        if(abyte0 != null)
            mPartMapByContentId.put(new String(abyte0), pdupart);
        byte abyte1[] = pdupart.getContentLocation();
        if(abyte1 != null) {
            String s = new String(abyte1);
            mPartMapByContentLocation.put(s, pdupart);
        }
        byte abyte2[] = pdupart.getName();
        if(abyte2 != null) {
            String s1 = new String(abyte2);
            mPartMapByName.put(s1, pdupart);
        }
        byte abyte3[] = pdupart.getFilename();
        if(abyte3 != null) {
            String s2 = new String(abyte3);
            mPartMapByFileName.put(s2, pdupart);
        }
    }

    public void addPart(int i, PduPart pdupart) {
        if(pdupart == null) {
            throw new NullPointerException();
        } else {
            putPartToMaps(pdupart);
            mParts.add(i, pdupart);
            return;
        }
    }

    public boolean addPart(PduPart pdupart) {
        if(pdupart == null) {
            throw new NullPointerException();
        } else {
            putPartToMaps(pdupart);
            return mParts.add(pdupart);
        }
    }

    public PduPart getPart(int i) {
        return (PduPart)mParts.get(i);
    }

    public PduPart getPartByContentId(String s) {
        return (PduPart)mPartMapByContentId.get(s);
    }

    public PduPart getPartByContentLocation(String s) {
        return (PduPart)mPartMapByContentLocation.get(s);
    }

    public PduPart getPartByFileName(String s) {
        return (PduPart)mPartMapByFileName.get(s);
    }

    public PduPart getPartByName(String s) {
        return (PduPart)mPartMapByName.get(s);
    }

    public int getPartIndex(PduPart pdupart) {
        return mParts.indexOf(pdupart);
    }

    public int getPartsNum() {
        return mParts.size();
    }

    public void removeAll() {
        mParts.clear();
    }

    public PduPart removePart(int i) {
        return (PduPart)mParts.remove(i);
    }

    private Map mPartMapByContentId;
    private Map mPartMapByContentLocation;
    private Map mPartMapByFileName;
    private Map mPartMapByName;
    private Vector mParts;
}
