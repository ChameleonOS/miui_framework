// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;


public interface InputType {

    public static final int TYPE_CLASS_DATETIME = 4;
    public static final int TYPE_CLASS_NUMBER = 2;
    public static final int TYPE_CLASS_PHONE = 3;
    public static final int TYPE_CLASS_TEXT = 1;
    public static final int TYPE_DATETIME_VARIATION_DATE = 16;
    public static final int TYPE_DATETIME_VARIATION_NORMAL = 0;
    public static final int TYPE_DATETIME_VARIATION_TIME = 32;
    public static final int TYPE_MASK_CLASS = 15;
    public static final int TYPE_MASK_FLAGS = 0xfff000;
    public static final int TYPE_MASK_VARIATION = 4080;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_NUMBER_FLAG_DECIMAL = 8192;
    public static final int TYPE_NUMBER_FLAG_SIGNED = 4096;
    public static final int TYPE_NUMBER_VARIATION_NORMAL = 0;
    public static final int TYPE_NUMBER_VARIATION_PASSWORD = 16;
    public static final int TYPE_TEXT_FLAG_AUTO_COMPLETE = 0x10000;
    public static final int TYPE_TEXT_FLAG_AUTO_CORRECT = 32768;
    public static final int TYPE_TEXT_FLAG_CAP_CHARACTERS = 4096;
    public static final int TYPE_TEXT_FLAG_CAP_SENTENCES = 16384;
    public static final int TYPE_TEXT_FLAG_CAP_WORDS = 8192;
    public static final int TYPE_TEXT_FLAG_IME_MULTI_LINE = 0x40000;
    public static final int TYPE_TEXT_FLAG_MULTI_LINE = 0x20000;
    public static final int TYPE_TEXT_FLAG_NO_SUGGESTIONS = 0x80000;
    public static final int TYPE_TEXT_VARIATION_EMAIL_ADDRESS = 32;
    public static final int TYPE_TEXT_VARIATION_EMAIL_SUBJECT = 48;
    public static final int TYPE_TEXT_VARIATION_FILTER = 176;
    public static final int TYPE_TEXT_VARIATION_LONG_MESSAGE = 80;
    public static final int TYPE_TEXT_VARIATION_NORMAL = 0;
    public static final int TYPE_TEXT_VARIATION_PASSWORD = 128;
    public static final int TYPE_TEXT_VARIATION_PERSON_NAME = 96;
    public static final int TYPE_TEXT_VARIATION_PHONETIC = 192;
    public static final int TYPE_TEXT_VARIATION_POSTAL_ADDRESS = 112;
    public static final int TYPE_TEXT_VARIATION_SHORT_MESSAGE = 64;
    public static final int TYPE_TEXT_VARIATION_URI = 16;
    public static final int TYPE_TEXT_VARIATION_VISIBLE_PASSWORD = 144;
    public static final int TYPE_TEXT_VARIATION_WEB_EDIT_TEXT = 160;
    public static final int TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS = 208;
    public static final int TYPE_TEXT_VARIATION_WEB_PASSWORD = 224;
}
