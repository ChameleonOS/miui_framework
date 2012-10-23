// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UriMatcher {

    private UriMatcher() {
        mCode = -1;
        mWhich = -1;
        mChildren = new ArrayList();
        mText = null;
    }

    public UriMatcher(int i) {
        mCode = i;
        mWhich = -1;
        mChildren = new ArrayList();
        mText = null;
    }

    public void addURI(String s, String s1, int i) {
        if(i < 0)
            throw new IllegalArgumentException((new StringBuilder()).append("code ").append(i).append(" is invalid: it must be positive").toString());
        String as[];
        int j;
        UriMatcher urimatcher;
        int k;
        if(s1 != null)
            as = PATH_SPLIT_PATTERN.split(s1);
        else
            as = null;
        if(as != null)
            j = as.length;
        else
            j = 0;
        urimatcher = this;
        k = -1;
label0:
        do {
            if(k < j) {
                String s2;
                ArrayList arraylist;
                int l;
                int i1;
                if(k < 0)
                    s2 = s;
                else
                    s2 = as[k];
                arraylist = urimatcher.mChildren;
                l = arraylist.size();
                i1 = 0;
                do {
label1:
                    {
                        if(i1 < l) {
                            UriMatcher urimatcher2 = (UriMatcher)arraylist.get(i1);
                            if(!s2.equals(urimatcher2.mText))
                                break label1;
                            urimatcher = urimatcher2;
                        }
                        if(i1 == l) {
                            UriMatcher urimatcher1 = new UriMatcher();
                            if(s2.equals("#"))
                                urimatcher1.mWhich = 1;
                            else
                            if(s2.equals("*"))
                                urimatcher1.mWhich = 2;
                            else
                                urimatcher1.mWhich = 0;
                            urimatcher1.mText = s2;
                            urimatcher.mChildren.add(urimatcher1);
                            urimatcher = urimatcher1;
                        }
                        k++;
                        continue label0;
                    }
                    i1++;
                } while(true);
            }
            urimatcher.mCode = i;
            return;
        } while(true);
    }

    public int match(Uri uri) {
        List list;
        int i;
        UriMatcher urimatcher;
        list = uri.getPathSegments();
        i = list.size();
        urimatcher = this;
        if(i != 0 || uri.getAuthority() != null) goto _L2; else goto _L1
_L1:
        int k = mCode;
_L3:
        return k;
_L2:
        int j = -1;
_L18:
        String s;
        ArrayList arraylist;
label0:
        {
            if(j < i) {
                if(j < 0)
                    s = uri.getAuthority();
                else
                    s = (String)list.get(j);
                arraylist = urimatcher.mChildren;
                if(arraylist != null)
                    break label0;
            }
            k = urimatcher.mCode;
        }
          goto _L3
        int l;
        int i1;
        urimatcher = null;
        l = arraylist.size();
        i1 = 0;
_L17:
        if(i1 >= l) goto _L5; else goto _L4
_L4:
        UriMatcher urimatcher1 = (UriMatcher)arraylist.get(i1);
        urimatcher1.mWhich;
        JVM INSTR tableswitch 0 2: default 156
    //                   0 173
    //                   1 193
    //                   2 246;
           goto _L6 _L7 _L8 _L9
_L6:
        if(urimatcher == null) goto _L10; else goto _L5
_L5:
        if(urimatcher != null) goto _L12; else goto _L11
_L11:
        k = -1;
          goto _L3
_L7:
        if(urimatcher1.mText.equals(s))
            urimatcher = urimatcher1;
          goto _L6
_L8:
        int j1;
        int k1;
        j1 = s.length();
        k1 = 0;
_L16:
        if(k1 >= j1) goto _L14; else goto _L13
_L13:
        char c = s.charAt(k1);
        if(c < '0' || c > '9') goto _L6; else goto _L15
_L15:
        k1++;
          goto _L16
_L14:
        urimatcher = urimatcher1;
          goto _L6
_L9:
        urimatcher = urimatcher1;
          goto _L6
_L10:
        i1++;
          goto _L17
_L12:
        j++;
          goto _L18
    }

    private static final int EXACT = 0;
    public static final int NO_MATCH = -1;
    private static final int NUMBER = 1;
    static final Pattern PATH_SPLIT_PATTERN = Pattern.compile("/");
    private static final int TEXT = 2;
    private ArrayList mChildren;
    private int mCode;
    private String mText;
    private int mWhich;

}
