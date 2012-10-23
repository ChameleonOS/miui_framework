// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;


public final class SmsBroadcastConfigInfo {

    public SmsBroadcastConfigInfo(int i, int j, int k, int l, boolean flag) {
        fromServiceId = i;
        toServiceId = j;
        fromCodeScheme = k;
        toCodeScheme = l;
        selected = flag;
    }

    public int getFromCodeScheme() {
        return fromCodeScheme;
    }

    public int getFromServiceId() {
        return fromServiceId;
    }

    public int getToCodeScheme() {
        return toCodeScheme;
    }

    public int getToServiceId() {
        return toServiceId;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setFromCodeScheme(int i) {
        fromCodeScheme = i;
    }

    public void setFromServiceId(int i) {
        fromServiceId = i;
    }

    public void setSelected(boolean flag) {
        selected = flag;
    }

    public void setToCodeScheme(int i) {
        toCodeScheme = i;
    }

    public void setToServiceId(int i) {
        toServiceId = i;
    }

    public String toString() {
        StringBuilder stringbuilder = (new StringBuilder()).append("SmsBroadcastConfigInfo: Id [").append(fromServiceId).append(',').append(toServiceId).append("] Code [").append(fromCodeScheme).append(',').append(toCodeScheme).append("] ");
        String s;
        if(selected)
            s = "ENABLED";
        else
            s = "DISABLED";
        return stringbuilder.append(s).toString();
    }

    private int fromCodeScheme;
    private int fromServiceId;
    private boolean selected;
    private int toCodeScheme;
    private int toServiceId;
}
