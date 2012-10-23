// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import android.util.Log;
import java.io.*;
import java.util.ArrayList;

// Referenced classes of package com.google.android.mms.pdu:
//            CharacterSets

public class EncodedStringValue
    implements Cloneable {

    public EncodedStringValue(int i, byte abyte0[]) {
        if(abyte0 == null) {
            throw new NullPointerException("EncodedStringValue: Text-string is null.");
        } else {
            mCharacterSet = i;
            mData = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, mData, 0, abyte0.length);
            return;
        }
    }

    public EncodedStringValue(String s) {
        mData = s.getBytes("utf-8");
        mCharacterSet = 106;
_L1:
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        Log.e("EncodedStringValue", "Default encoding must be supported.", unsupportedencodingexception);
          goto _L1
    }

    public EncodedStringValue(byte abyte0[]) {
        this(106, abyte0);
    }

    public static String concat(EncodedStringValue aencodedstringvalue[]) {
        StringBuilder stringbuilder = new StringBuilder();
        int i = -1 + aencodedstringvalue.length;
        for(int j = 0; j <= i; j++) {
            stringbuilder.append(aencodedstringvalue[j].getString());
            if(j < i)
                stringbuilder.append(";");
        }

        return stringbuilder.toString();
    }

    public static EncodedStringValue copy(EncodedStringValue encodedstringvalue) {
        EncodedStringValue encodedstringvalue1;
        if(encodedstringvalue == null)
            encodedstringvalue1 = null;
        else
            encodedstringvalue1 = new EncodedStringValue(encodedstringvalue.mCharacterSet, encodedstringvalue.mData);
        return encodedstringvalue1;
    }

    public static EncodedStringValue[] encodeStrings(String as[]) {
        int i = as.length;
        EncodedStringValue aencodedstringvalue[];
        if(i > 0) {
            aencodedstringvalue = new EncodedStringValue[i];
            for(int j = 0; j < i; j++)
                aencodedstringvalue[j] = new EncodedStringValue(as[j]);

        } else {
            aencodedstringvalue = null;
        }
        return aencodedstringvalue;
    }

    public static EncodedStringValue[] extract(String s) {
        String as[] = s.split(";");
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < as.length; i++)
            if(as[i].length() > 0)
                arraylist.add(new EncodedStringValue(as[i]));

        int j = arraylist.size();
        EncodedStringValue aencodedstringvalue[];
        if(j > 0)
            aencodedstringvalue = (EncodedStringValue[])arraylist.toArray(new EncodedStringValue[j]);
        else
            aencodedstringvalue = null;
        return aencodedstringvalue;
    }

    public void appendTextString(byte abyte0[]) {
        if(abyte0 == null)
            throw new NullPointerException("Text-string is null.");
        if(mData != null) goto _L2; else goto _L1
_L1:
        mData = new byte[abyte0.length];
        System.arraycopy(abyte0, 0, mData, 0, abyte0.length);
_L4:
        return;
_L2:
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try {
            bytearrayoutputstream.write(mData);
            bytearrayoutputstream.write(abyte0);
        }
        catch(IOException ioexception) {
            ioexception.printStackTrace();
            throw new NullPointerException("appendTextString: failed when write a new Text-string");
        }
        mData = bytearrayoutputstream.toByteArray();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Object clone() throws CloneNotSupportedException {
        super.clone();
        int i = mData.length;
        byte abyte0[] = new byte[i];
        System.arraycopy(mData, 0, abyte0, 0, i);
        EncodedStringValue encodedstringvalue;
        try {
            encodedstringvalue = new EncodedStringValue(mCharacterSet, abyte0);
        }
        catch(Exception exception) {
            Log.e("EncodedStringValue", (new StringBuilder()).append("failed to clone an EncodedStringValue: ").append(this).toString());
            exception.printStackTrace();
            throw new CloneNotSupportedException(exception.getMessage());
        }
        return encodedstringvalue;
    }

    public int getCharacterSet() {
        return mCharacterSet;
    }

    public String getString() {
        String s;
        if(mCharacterSet == 0)
            s = new String(mData);
        else
            try {
                String s1 = CharacterSets.getMimeName(mCharacterSet);
                s = new String(mData, s1);
            }
            catch(UnsupportedEncodingException unsupportedencodingexception) {
                try {
                    s = new String(mData, "iso-8859-1");
                }
                catch(UnsupportedEncodingException unsupportedencodingexception1) {
                    s = new String(mData);
                }
            }
        return s;
    }

    public byte[] getTextString() {
        byte abyte0[] = new byte[mData.length];
        System.arraycopy(mData, 0, abyte0, 0, mData.length);
        return abyte0;
    }

    public void setCharacterSet(int i) {
        mCharacterSet = i;
    }

    public void setTextString(byte abyte0[]) {
        if(abyte0 == null) {
            throw new NullPointerException("EncodedStringValue: Text-string is null.");
        } else {
            mData = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, mData, 0, abyte0.length);
            return;
        }
    }

    public EncodedStringValue[] split(String s) {
        String as[];
        EncodedStringValue aencodedstringvalue[];
        int i;
        as = getString().split(s);
        aencodedstringvalue = new EncodedStringValue[as.length];
        i = 0;
_L2:
        if(i >= aencodedstringvalue.length)
            break; /* Loop/switch isn't completed */
        aencodedstringvalue[i] = new EncodedStringValue(mCharacterSet, as[i].getBytes());
        i++;
        if(true) goto _L2; else goto _L1
        NullPointerException nullpointerexception;
        nullpointerexception;
        aencodedstringvalue = null;
_L1:
        return aencodedstringvalue;
    }

    private static final boolean DEBUG = false;
    private static final boolean LOCAL_LOGV = false;
    private static final String TAG = "EncodedStringValue";
    private int mCharacterSet;
    private byte mData[];
}
