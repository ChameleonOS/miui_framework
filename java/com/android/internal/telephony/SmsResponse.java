// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;


public class SmsResponse {

    public SmsResponse(int i, String s, int j) {
        messageRef = i;
        ackPdu = s;
        errorCode = j;
    }

    public String toString() {
        return (new StringBuilder()).append("{ messageRef = ").append(messageRef).append(", errorCode = ").append(errorCode).append(", ackPdu = ").append(ackPdu).append("}").toString();
    }

    String ackPdu;
    int errorCode;
    int messageRef;
}
