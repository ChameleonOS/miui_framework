// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package android.bluetooth:
//            AtCommandResult, AtCommandHandler

public class AtParser {

    public AtParser() {
        mBasicHandlers = new HashMap();
        mExtHandlers = new HashMap();
        mLastInput = "";
    }

    private static String clean(String s) {
        StringBuilder stringbuilder;
        int i;
        stringbuilder = new StringBuilder(s.length());
        i = 0;
_L2:
        char c;
        int j;
label0:
        {
            if(i < s.length()) {
                c = s.charAt(i);
                if(c != '"')
                    break; /* Loop/switch isn't completed */
                j = s.indexOf('"', i + 1);
                if(j != -1)
                    break label0;
                stringbuilder.append(s.substring(i, s.length()));
                stringbuilder.append('"');
            }
            return stringbuilder.toString();
        }
        stringbuilder.append(s.substring(i, j + 1));
        i = j;
_L4:
        i++;
        if(true) goto _L2; else goto _L1
_L1:
        if(c == ' ') goto _L4; else goto _L3
_L3:
        stringbuilder.append(Character.toUpperCase(c));
          goto _L4
    }

    private static int findChar(char c, String s, int i) {
        int j = i;
_L3:
        if(j >= s.length()) goto _L2; else goto _L1
_L1:
        int k;
        char c1 = s.charAt(j);
        if(c1 == '"') {
            j = s.indexOf('"', j + 1);
            if(j != -1)
                continue; /* Loop/switch isn't completed */
            k = s.length();
        } else {
            if(c1 != c)
                continue; /* Loop/switch isn't completed */
            k = j;
        }
_L4:
        return k;
        j++;
          goto _L3
_L2:
        k = s.length();
          goto _L4
    }

    private static int findEndExtendedName(String s, int i) {
        int j = i;
_L3:
        char c;
        if(j >= s.length())
            break; /* Loop/switch isn't completed */
        c = s.charAt(j);
          goto _L1
_L5:
        j++;
        if(true) goto _L3; else goto _L2
_L1:
        if(isAtoZ(c) || c >= '0' && c <= '9') goto _L5; else goto _L4
_L4:
        c;
        JVM INSTR lookupswitch 7: default 108
    //                   33: 23
    //                   37: 23
    //                   45: 23
    //                   46: 23
    //                   47: 23
    //                   58: 23
    //                   95: 23;
           goto _L6 _L5 _L5 _L5 _L5 _L5 _L5 _L5
_L6:
        return j;
_L2:
        j = s.length();
        if(true) goto _L6; else goto _L7
_L7:
    }

    private static Object[] generateArgs(String s) {
        int i = 0;
        ArrayList arraylist = new ArrayList();
        while(i <= s.length())  {
            int j = findChar(',', s, i);
            String s1 = s.substring(i, j);
            try {
                arraylist.add(new Integer(s1));
            }
            catch(NumberFormatException numberformatexception) {
                arraylist.add(s1);
            }
            i = j + 1;
        }
        return arraylist.toArray();
    }

    private static boolean isAtoZ(char c) {
        boolean flag;
        if(c >= 'A' && c <= 'Z')
            flag = true;
        else
            flag = false;
        return flag;
    }

    public AtCommandResult process(String s) {
        String s1;
        AtCommandResult atcommandresult;
        s1 = clean(s);
        if(s1.regionMatches(0, "A/", 0, 2))
            s1 = new String(mLastInput);
        else
            mLastInput = new String(s1);
        if(s1.equals("")) {
            atcommandresult = new AtCommandResult(2);
        } else {
label0:
            {
                if(s1.regionMatches(0, "AT", 0, 2))
                    break label0;
                atcommandresult = new AtCommandResult(1);
            }
        }
_L1:
        return atcommandresult;
        int i;
        i = 2;
        atcommandresult = new AtCommandResult(2);
_L10:
        char c;
        if(i < s1.length()) {
label1:
            {
                c = s1.charAt(i);
                if(!isAtoZ(c))
                    break label1;
                String s3 = s1.substring(i + 1);
                if(mBasicHandlers.containsKey(Character.valueOf(c)))
                    atcommandresult.addResult(((AtCommandHandler)mBasicHandlers.get(Character.valueOf(c))).handleBasicCommand(s3));
                else
                    atcommandresult.addResult(new AtCommandResult(1));
            }
        }
          goto _L1
        if(c != '+') goto _L3; else goto _L2
_L2:
        int j;
        String s2;
label2:
        {
            j = findEndExtendedName(s1, i + 1);
            s2 = s1.substring(i, j);
            if(mExtHandlers.containsKey(s2))
                break label2;
            atcommandresult.addResult(new AtCommandResult(1));
        }
          goto _L1
        AtCommandHandler atcommandhandler;
        int k;
        atcommandhandler = (AtCommandHandler)mExtHandlers.get(s2);
        k = findChar(';', s1, i);
        int l;
        if(j >= k)
            l = 0;
        else
        if(s1.charAt(j) == '?')
            l = 1;
        else
        if(s1.charAt(j) == '=') {
            if(j + 1 < k) {
                if(s1.charAt(j + 1) == '?')
                    l = 3;
                else
                    l = 2;
            } else {
                l = 2;
            }
        } else {
            l = 0;
        }
        l;
        JVM INSTR tableswitch 0 3: default 312
    //                   0 400
    //                   1 412
    //                   2 436
    //                   3 424;
           goto _L4 _L5 _L6 _L7 _L8
_L4:
        if(atcommandresult.getResultCode() != 0) goto _L1; else goto _L9
_L9:
        i = k;
          goto _L10
_L5:
        atcommandresult.addResult(atcommandhandler.handleActionCommand());
          goto _L4
_L6:
        atcommandresult.addResult(atcommandhandler.handleReadCommand());
          goto _L4
_L8:
        atcommandresult.addResult(atcommandhandler.handleTestCommand());
          goto _L4
_L7:
        atcommandresult.addResult(atcommandhandler.handleSetCommand(generateArgs(s1.substring(j + 1, k))));
          goto _L4
_L3:
        i++;
          goto _L10
    }

    public void register(Character character, AtCommandHandler atcommandhandler) {
        mBasicHandlers.put(character, atcommandhandler);
    }

    public void register(String s, AtCommandHandler atcommandhandler) {
        mExtHandlers.put(s, atcommandhandler);
    }

    private static final int TYPE_ACTION = 0;
    private static final int TYPE_READ = 1;
    private static final int TYPE_SET = 2;
    private static final int TYPE_TEST = 3;
    private HashMap mBasicHandlers;
    private HashMap mExtHandlers;
    private String mLastInput;
}
