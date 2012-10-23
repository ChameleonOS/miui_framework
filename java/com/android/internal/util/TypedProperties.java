// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypedProperties extends HashMap {
    public static class TypeException extends IllegalArgumentException {

        TypeException(String s, Object obj, String s1) {
            super((new StringBuilder()).append(s).append(" has type ").append(obj.getClass().getName()).append(", not ").append(s1).toString());
        }
    }

    public static class ParseException extends IllegalArgumentException {

        ParseException(StreamTokenizer streamtokenizer, String s) {
            super((new StringBuilder()).append("expected ").append(s).append(", saw ").append(streamtokenizer.toString()).toString());
        }
    }


    public TypedProperties() {
    }

    static StreamTokenizer initTokenizer(Reader reader) {
        StreamTokenizer streamtokenizer = new StreamTokenizer(reader);
        streamtokenizer.resetSyntax();
        streamtokenizer.wordChars(48, 57);
        streamtokenizer.wordChars(65, 90);
        streamtokenizer.wordChars(97, 122);
        streamtokenizer.wordChars(95, 95);
        streamtokenizer.wordChars(36, 36);
        streamtokenizer.wordChars(46, 46);
        streamtokenizer.wordChars(45, 45);
        streamtokenizer.wordChars(43, 43);
        streamtokenizer.ordinaryChar(61);
        streamtokenizer.whitespaceChars(32, 32);
        streamtokenizer.whitespaceChars(9, 9);
        streamtokenizer.whitespaceChars(10, 10);
        streamtokenizer.whitespaceChars(13, 13);
        streamtokenizer.quoteChar(34);
        streamtokenizer.slashStarComments(true);
        streamtokenizer.slashSlashComments(true);
        return streamtokenizer;
    }

    static int interpretType(String s) {
        char c;
        if("unset".equals(s))
            c = 'x';
        else
        if("boolean".equals(s))
            c = 'Z';
        else
        if("byte".equals(s))
            c = '\u0149';
        else
        if("short".equals(s))
            c = '\u0249';
        else
        if("int".equals(s))
            c = '\u0449';
        else
        if("long".equals(s))
            c = '\u0849';
        else
        if("float".equals(s))
            c = '\u0446';
        else
        if("double".equals(s))
            c = '\u0846';
        else
        if("String".equals(s))
            c = '\u734C';
        else
            c = '\uFFFF';
        return c;
    }

    static void parse(Reader reader, Map map) throws ParseException, IOException {
        StreamTokenizer streamtokenizer = initTokenizer(reader);
        Pattern pattern = Pattern.compile("([a-zA-Z_$][0-9a-zA-Z_$]*\\.)*[a-zA-Z_$][0-9a-zA-Z_$]*");
        do {
            int i = streamtokenizer.nextToken();
            if(i == -1)
                return;
            if(i != -3)
                throw new ParseException(streamtokenizer, "type name");
            int j = interpretType(streamtokenizer.sval);
            if(j == -1)
                throw new ParseException(streamtokenizer, "valid type name");
            streamtokenizer.sval = null;
            if(j == 120 && streamtokenizer.nextToken() != 40)
                throw new ParseException(streamtokenizer, "'('");
            if(streamtokenizer.nextToken() != -3)
                throw new ParseException(streamtokenizer, "property name");
            String s = streamtokenizer.sval;
            if(!pattern.matcher(s).matches())
                throw new ParseException(streamtokenizer, "valid property name");
            streamtokenizer.sval = null;
            if(j == 120) {
                if(streamtokenizer.nextToken() != 41)
                    throw new ParseException(streamtokenizer, "')'");
                map.remove(s);
            } else {
                if(streamtokenizer.nextToken() != 61)
                    throw new ParseException(streamtokenizer, "'='");
                Object obj = parseValue(streamtokenizer, j);
                Object obj1 = map.remove(s);
                if(obj1 != null && obj.getClass() != obj1.getClass())
                    throw new ParseException(streamtokenizer, "(property previously declared as a different type)");
                map.put(s, obj);
            }
        } while(streamtokenizer.nextToken() == 59);
        throw new ParseException(streamtokenizer, "';'");
    }

    static Object parseValue(StreamTokenizer streamtokenizer, int i) throws IOException {
        int j = streamtokenizer.nextToken();
        if(i != 90) goto _L2; else goto _L1
_L1:
        Object obj;
        if(j != -3)
            throw new ParseException(streamtokenizer, "boolean constant");
        if("true".equals(streamtokenizer.sval))
            obj = Boolean.TRUE;
        else
        if("false".equals(streamtokenizer.sval))
            obj = Boolean.FALSE;
        else
            throw new ParseException(streamtokenizer, "boolean constant");
_L4:
        return obj;
_L2:
label0:
        {
label1:
            {
                if((i & 0xff) == 73) {
                    if(j != -3)
                        throw new ParseException(streamtokenizer, "integer constant");
                    long l;
                    int k;
                    try {
                        l = Long.decode(streamtokenizer.sval).longValue();
                    }
                    catch(NumberFormatException numberformatexception1) {
                        throw new ParseException(streamtokenizer, "integer constant");
                    }
                    k = 0xff & i >> 8;
                    switch(k) {
                    case 3: // '\003'
                    case 5: // '\005'
                    case 6: // '\006'
                    case 7: // '\007'
                    default:
                        throw new IllegalStateException((new StringBuilder()).append("Internal error; unexpected integer type width ").append(k).toString());

                    case 1: // '\001'
                        if(l < -128L || l > 127L)
                            throw new ParseException(streamtokenizer, "8-bit integer constant");
                        obj = new Byte((byte)(int)l);
                        break;

                    case 2: // '\002'
                        if(l < -32768L || l > 32767L)
                            throw new ParseException(streamtokenizer, "16-bit integer constant");
                        obj = new Short((short)(int)l);
                        break;

                    case 4: // '\004'
                        if(l < 0xffffffff80000000L || l > 0x7fffffffL)
                            throw new ParseException(streamtokenizer, "32-bit integer constant");
                        obj = new Integer((int)l);
                        break;

                    case 8: // '\b'
                        if(l < 0x8000000000000000L || l > 0x7fffffffffffffffL)
                            throw new ParseException(streamtokenizer, "64-bit integer constant");
                        obj = new Long(l);
                        break;
                    }
                } else {
                    if((i & 0xff) != 70)
                        break label0;
                    if(j != -3)
                        throw new ParseException(streamtokenizer, "float constant");
                    break label1;
                }
                if(false)
                    ;
                continue; /* Loop/switch isn't completed */
            }
            double d;
            try {
                d = Double.parseDouble(streamtokenizer.sval);
            }
            catch(NumberFormatException numberformatexception) {
                throw new ParseException(streamtokenizer, "float constant");
            }
            if((0xff & i >> 8) == 4) {
                double d1 = Math.abs(d);
                if(d1 != 0.0D && !Double.isInfinite(d) && !Double.isNaN(d) && (d1 < 1.4012984643248171E-45D || d1 > 3.4028234663852886E+38D))
                    throw new ParseException(streamtokenizer, "32-bit float constant");
                obj = new Float((float)d);
            } else {
                obj = new Double(d);
            }
            continue; /* Loop/switch isn't completed */
        }
        if(i == 29516) {
            if(j == 34)
                obj = streamtokenizer.sval;
            else
            if(j == -3 && "null".equals(streamtokenizer.sval))
                obj = NULL_STRING;
            else
                throw new ParseException(streamtokenizer, "double-quoted string or 'null'");
        } else {
            throw new IllegalStateException((new StringBuilder()).append("Internal error; unknown type ").append(i).toString());
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Object get(Object obj) {
        Object obj1 = super.get(obj);
        if(obj1 == NULL_STRING)
            obj1 = null;
        return obj1;
    }

    public boolean getBoolean(String s) {
        return getBoolean(s, false);
    }

    public boolean getBoolean(String s, boolean flag) {
        Object obj = super.get(s);
        if(obj != null)
            if(obj instanceof Boolean)
                flag = ((Boolean)obj).booleanValue();
            else
                throw new TypeException(s, obj, "boolean");
        return flag;
    }

    public byte getByte(String s) {
        return getByte(s, (byte)0);
    }

    public byte getByte(String s, byte byte0) {
        Object obj = super.get(s);
        if(obj != null)
            if(obj instanceof Byte)
                byte0 = ((Byte)obj).byteValue();
            else
                throw new TypeException(s, obj, "byte");
        return byte0;
    }

    public double getDouble(String s) {
        return getDouble(s, 0.0D);
    }

    public double getDouble(String s, double d) {
        Object obj = super.get(s);
        if(obj != null)
            if(obj instanceof Double)
                d = ((Double)obj).doubleValue();
            else
                throw new TypeException(s, obj, "double");
        return d;
    }

    public float getFloat(String s) {
        return getFloat(s, 0.0F);
    }

    public float getFloat(String s, float f) {
        Object obj = super.get(s);
        if(obj != null)
            if(obj instanceof Float)
                f = ((Float)obj).floatValue();
            else
                throw new TypeException(s, obj, "float");
        return f;
    }

    public int getInt(String s) {
        return getInt(s, 0);
    }

    public int getInt(String s, int i) {
        Object obj = super.get(s);
        if(obj != null)
            if(obj instanceof Integer)
                i = ((Integer)obj).intValue();
            else
                throw new TypeException(s, obj, "int");
        return i;
    }

    public long getLong(String s) {
        return getLong(s, 0L);
    }

    public long getLong(String s, long l) {
        Object obj = super.get(s);
        if(obj != null)
            if(obj instanceof Long)
                l = ((Long)obj).longValue();
            else
                throw new TypeException(s, obj, "long");
        return l;
    }

    public short getShort(String s) {
        return getShort(s, (short)0);
    }

    public short getShort(String s, short word0) {
        Object obj = super.get(s);
        if(obj != null)
            if(obj instanceof Short)
                word0 = ((Short)obj).shortValue();
            else
                throw new TypeException(s, obj, "short");
        return word0;
    }

    public String getString(String s) {
        return getString(s, "");
    }

    public String getString(String s, String s1) {
        Object obj = super.get(s);
        if(obj != null)
            if(obj == NULL_STRING)
                s1 = null;
            else
            if(obj instanceof String)
                s1 = (String)obj;
            else
                throw new TypeException(s, obj, "string");
        return s1;
    }

    public int getStringInfo(String s) {
        Object obj = super.get(s);
        byte byte0;
        if(obj == null)
            byte0 = -1;
        else
        if(obj == NULL_STRING)
            byte0 = 0;
        else
        if(obj instanceof String)
            byte0 = 1;
        else
            byte0 = -2;
        return byte0;
    }

    public void load(Reader reader) throws IOException {
        parse(reader, this);
    }

    static final String NULL_STRING = new String("<TypedProperties:NULL_STRING>");
    public static final int STRING_NOT_SET = -1;
    public static final int STRING_NULL = 0;
    public static final int STRING_SET = 1;
    public static final int STRING_TYPE_MISMATCH = -2;
    static final int TYPE_BOOLEAN = 90;
    static final int TYPE_BYTE = 329;
    static final int TYPE_DOUBLE = 2118;
    static final int TYPE_ERROR = -1;
    static final int TYPE_FLOAT = 1094;
    static final int TYPE_INT = 1097;
    static final int TYPE_LONG = 2121;
    static final int TYPE_SHORT = 585;
    static final int TYPE_STRING = 29516;
    static final int TYPE_UNSET = 120;

}
