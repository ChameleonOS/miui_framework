// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import java.util.ArrayList;

// Referenced classes of package com.google.android.util:
//            AbstractMessageParser, SmileyResources

public class SmileyParser extends AbstractMessageParser {

    public SmileyParser(String s, SmileyResources smileyresources) {
        super(s, true, false, false, false, false, false);
        mRes = smileyresources;
    }

    protected AbstractMessageParser.Resources getResources() {
        return mRes;
    }

    public CharSequence getSpannableString(Context context) {
        Object obj = new SpannableStringBuilder();
        if(getPartCount() == 0) {
            obj = "";
        } else {
            ArrayList arraylist = getPart(0).getTokens();
            int i = arraylist.size();
            int j = 0;
            while(j < i)  {
                AbstractMessageParser.Token token = (AbstractMessageParser.Token)arraylist.get(j);
                int k = ((SpannableStringBuilder) (obj)).length();
                ((SpannableStringBuilder) (obj)).append(token.getRawText());
                if(token.getType() == AbstractMessageParser.Token.Type.SMILEY) {
                    int l = mRes.getSmileyRes(token.getRawText());
                    if(l != -1)
                        ((SpannableStringBuilder) (obj)).setSpan(new ImageSpan(context, l), k, ((SpannableStringBuilder) (obj)).length(), 33);
                }
                j++;
            }
        }
        return ((CharSequence) (obj));
    }

    private SmileyResources mRes;
}
