// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.util;

import java.util.HashMap;
import java.util.Set;

public class SmileyResources
    implements AbstractMessageParser.Resources {

    public SmileyResources(String as[], int ai[]) {
        mSmileyToRes = new HashMap();
        for(int i = 0; i < as.length; i++) {
            AbstractMessageParser.TrieNode.addToTrie(smileys, as[i], "");
            mSmileyToRes.put(as[i], Integer.valueOf(ai[i]));
        }

    }

    public AbstractMessageParser.TrieNode getAcronyms() {
        return null;
    }

    public AbstractMessageParser.TrieNode getDomainSuffixes() {
        return null;
    }

    public Set getSchemes() {
        return null;
    }

    public int getSmileyRes(String s) {
        Integer integer = (Integer)mSmileyToRes.get(s);
        int i;
        if(integer == null)
            i = -1;
        else
            i = integer.intValue();
        return i;
    }

    public AbstractMessageParser.TrieNode getSmileys() {
        return smileys;
    }

    private HashMap mSmileyToRes;
    private final AbstractMessageParser.TrieNode smileys = new AbstractMessageParser.TrieNode();
}
