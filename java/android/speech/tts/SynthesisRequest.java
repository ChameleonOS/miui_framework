// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;

import android.os.Bundle;

public final class SynthesisRequest {

    public SynthesisRequest(String s, Bundle bundle) {
        mText = s;
        mParams = new Bundle(bundle);
    }

    public String getCountry() {
        return mCountry;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public Bundle getParams() {
        return mParams;
    }

    public int getPitch() {
        return mPitch;
    }

    public int getSpeechRate() {
        return mSpeechRate;
    }

    public String getText() {
        return mText;
    }

    public String getVariant() {
        return mVariant;
    }

    void setLanguage(String s, String s1, String s2) {
        mLanguage = s;
        mCountry = s1;
        mVariant = s2;
    }

    void setPitch(int i) {
        mPitch = i;
    }

    void setSpeechRate(int i) {
        mSpeechRate = i;
    }

    private String mCountry;
    private String mLanguage;
    private final Bundle mParams;
    private int mPitch;
    private int mSpeechRate;
    private final String mText;
    private String mVariant;
}
