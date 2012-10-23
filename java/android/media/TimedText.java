// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.graphics.Rect;
import android.os.Parcel;
import android.util.Log;
import java.util.*;

public final class TimedText {
    public static final class HyperText {

        public final String URL;
        public final String altString;
        public final int endChar;
        public final int startChar;

        public HyperText(int i, int j, String s, String s1) {
            startChar = i;
            endChar = j;
            URL = s;
            altString = s1;
        }
    }

    public static final class Karaoke {

        public final int endChar;
        public final int endTimeMs;
        public final int startChar;
        public final int startTimeMs;

        public Karaoke(int i, int j, int k, int l) {
            startTimeMs = i;
            endTimeMs = j;
            startChar = k;
            endChar = l;
        }
    }

    public static final class Font {

        public final int ID;
        public final String name;

        public Font(int i, String s) {
            ID = i;
            name = s;
        }
    }

    public static final class Style {

        public final int colorRGBA;
        public final int endChar;
        public final int fontID;
        public final int fontSize;
        public final boolean isBold;
        public final boolean isItalic;
        public final boolean isUnderlined;
        public final int startChar;

        public Style(int i, int j, int k, boolean flag, boolean flag1, boolean flag2, int l, 
                int i1) {
            startChar = i;
            endChar = j;
            fontID = k;
            isBold = flag;
            isItalic = flag1;
            isUnderlined = flag2;
            fontSize = l;
            colorRGBA = i1;
        }
    }

    public static final class Justification {

        public final int horizontalJustification;
        public final int verticalJustification;

        public Justification(int i, int j) {
            horizontalJustification = i;
            verticalJustification = j;
        }
    }

    public static final class CharPos {

        public final int endChar;
        public final int startChar;

        public CharPos(int i, int j) {
            startChar = i;
            endChar = j;
        }
    }


    public TimedText(Parcel parcel) {
        mDisplayFlags = -1;
        mBackgroundColorRGBA = -1;
        mHighlightColorRGBA = -1;
        mScrollDelay = -1;
        mWrapText = -1;
        mBlinkingPosList = null;
        mHighlightPosList = null;
        mKaraokeList = null;
        mFontList = null;
        mStyleList = null;
        mHyperTextList = null;
        mTextBounds = null;
        mTextChars = null;
        if(!parseParcel(parcel)) {
            mKeyObjectMap.clear();
            throw new IllegalArgumentException("parseParcel() fails");
        } else {
            return;
        }
    }

    private boolean containsKey(int i) {
        boolean flag;
        if(isValidKey(i) && mKeyObjectMap.containsKey(Integer.valueOf(i)))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private Object getObject(int i) {
        if(containsKey(i))
            return mKeyObjectMap.get(Integer.valueOf(i));
        else
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid key: ").append(i).toString());
    }

    private boolean isValidKey(int i) {
        boolean flag = true;
        if((i < flag || i > 16) && (i < 101 || i > 107))
            flag = false;
        return flag;
    }

    private Set keySet() {
        return mKeyObjectMap.keySet();
    }

    private boolean parseParcel(Parcel parcel) {
        parcel.setDataPosition(0);
        if(parcel.dataAvail() != 0) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L21:
        return flag;
_L2:
        int j;
        int i = parcel.readInt();
        if(i == 102) {
            int j1 = parcel.readInt();
            if(j1 != 7) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            int k1 = parcel.readInt();
            mKeyObjectMap.put(Integer.valueOf(j1), Integer.valueOf(k1));
            if(parcel.readInt() != 16) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            parcel.readInt();
            byte abyte0[] = parcel.createByteArray();
            if(abyte0 == null || abyte0.length == 0)
                mTextChars = null;
            else
                mTextChars = new String(abyte0);
        } else
        if(i != 101) {
            Log.w("TimedText", (new StringBuilder()).append("Invalid timed text key found: ").append(i).toString());
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
_L18:
        Object obj;
        if(parcel.dataAvail() <= 0)
            break MISSING_BLOCK_LABEL_605;
        j = parcel.readInt();
        if(!isValidKey(j)) {
            Log.w("TimedText", (new StringBuilder()).append("Invalid timed text key found: ").append(j).toString());
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        obj = null;
        j;
        JVM INSTR tableswitch 1 15: default 300
    //                   1 475
    //                   2 300
    //                   3 523
    //                   4 455
    //                   5 585
    //                   6 435
    //                   7 300
    //                   8 421
    //                   9 365
    //                   10 379
    //                   11 407
    //                   12 393
    //                   13 351
    //                   14 543
    //                   15 495;
           goto _L3 _L4 _L3 _L5 _L6 _L7 _L8 _L3 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L7:
        break MISSING_BLOCK_LABEL_585;
_L3:
        break; /* Loop/switch isn't completed */
_L14:
        break; /* Loop/switch isn't completed */
_L19:
        if(obj != null) {
            if(mKeyObjectMap.containsKey(Integer.valueOf(j)))
                mKeyObjectMap.remove(Integer.valueOf(j));
            mKeyObjectMap.put(Integer.valueOf(j), obj);
        }
        if(true) goto _L18; else goto _L17
_L17:
        readStyle(parcel);
        obj = mStyleList;
          goto _L19
_L10:
        readFont(parcel);
        obj = mFontList;
          goto _L19
_L11:
        readHighlight(parcel);
        obj = mHighlightPosList;
          goto _L19
_L13:
        readKaraoke(parcel);
        obj = mKaraokeList;
          goto _L19
_L12:
        readHyperText(parcel);
        obj = mHyperTextList;
          goto _L19
_L9:
        readBlinkingText(parcel);
        obj = mBlinkingPosList;
          goto _L19
_L8:
        mWrapText = parcel.readInt();
        obj = Integer.valueOf(mWrapText);
          goto _L19
_L6:
        mHighlightColorRGBA = parcel.readInt();
        obj = Integer.valueOf(mHighlightColorRGBA);
          goto _L19
_L4:
        mDisplayFlags = parcel.readInt();
        obj = Integer.valueOf(mDisplayFlags);
          goto _L19
_L16:
        mJustification = new Justification(parcel.readInt(), parcel.readInt());
        obj = mJustification;
          goto _L19
_L5:
        mBackgroundColorRGBA = parcel.readInt();
        obj = Integer.valueOf(mBackgroundColorRGBA);
          goto _L19
_L15:
        int k = parcel.readInt();
        int l = parcel.readInt();
        int i1 = parcel.readInt();
        mTextBounds = new Rect(l, k, parcel.readInt(), i1);
          goto _L19
        mScrollDelay = parcel.readInt();
        obj = Integer.valueOf(mScrollDelay);
          goto _L19
        flag = true;
        if(true) goto _L21; else goto _L20
_L20:
    }

    private void readBlinkingText(Parcel parcel) {
        CharPos charpos = new CharPos(parcel.readInt(), parcel.readInt());
        if(mBlinkingPosList == null)
            mBlinkingPosList = new ArrayList();
        mBlinkingPosList.add(charpos);
    }

    private void readFont(Parcel parcel) {
        int i = parcel.readInt();
        for(int j = 0; j < i; j++) {
            int k = parcel.readInt();
            int l = parcel.readInt();
            Font font = new Font(k, new String(parcel.createByteArray(), 0, l));
            if(mFontList == null)
                mFontList = new ArrayList();
            mFontList.add(font);
        }

    }

    private void readHighlight(Parcel parcel) {
        CharPos charpos = new CharPos(parcel.readInt(), parcel.readInt());
        if(mHighlightPosList == null)
            mHighlightPosList = new ArrayList();
        mHighlightPosList.add(charpos);
    }

    private void readHyperText(Parcel parcel) {
        int i = parcel.readInt();
        int j = parcel.readInt();
        int k = parcel.readInt();
        String s = new String(parcel.createByteArray(), 0, k);
        int l = parcel.readInt();
        HyperText hypertext = new HyperText(i, j, s, new String(parcel.createByteArray(), 0, l));
        if(mHyperTextList == null)
            mHyperTextList = new ArrayList();
        mHyperTextList.add(hypertext);
    }

    private void readKaraoke(Parcel parcel) {
        int i = parcel.readInt();
        for(int j = 0; j < i; j++) {
            Karaoke karaoke = new Karaoke(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            if(mKaraokeList == null)
                mKaraokeList = new ArrayList();
            mKaraokeList.add(karaoke);
        }

    }

    private void readStyle(Parcel parcel) {
        boolean flag = false;
        int i = -1;
        int j = -1;
        int k = -1;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        int l = -1;
        int i1 = -1;
        do {
            if(!flag && parcel.dataAvail() > 0) {
                switch(parcel.readInt()) {
                default:
                    parcel.setDataPosition(-4 + parcel.dataPosition());
                    flag = true;
                    break;

                case 103: // 'g'
                    i = parcel.readInt();
                    break;

                case 104: // 'h'
                    j = parcel.readInt();
                    break;

                case 105: // 'i'
                    k = parcel.readInt();
                    break;

                case 2: // '\002'
                    int j1 = parcel.readInt();
                    if(j1 % 2 == 1)
                        flag1 = true;
                    else
                        flag1 = false;
                    if(j1 % 4 >= 2)
                        flag2 = true;
                    else
                        flag2 = false;
                    if(j1 / 4 == 1)
                        flag3 = true;
                    else
                        flag3 = false;
                    break;

                case 106: // 'j'
                    l = parcel.readInt();
                    break;

                case 107: // 'k'
                    i1 = parcel.readInt();
                    break;
                }
                continue;
            }
            Style style = new Style(i, j, k, flag1, flag2, flag3, l, i1);
            if(mStyleList == null)
                mStyleList = new ArrayList();
            mStyleList.add(style);
            break;
        } while(true);
    }

    public Rect getBounds() {
        return mTextBounds;
    }

    public String getText() {
        return mTextChars;
    }

    private static final int FIRST_PRIVATE_KEY = 101;
    private static final int FIRST_PUBLIC_KEY = 1;
    private static final int KEY_BACKGROUND_COLOR_RGBA = 3;
    private static final int KEY_DISPLAY_FLAGS = 1;
    private static final int KEY_END_CHAR = 104;
    private static final int KEY_FONT_ID = 105;
    private static final int KEY_FONT_SIZE = 106;
    private static final int KEY_GLOBAL_SETTING = 101;
    private static final int KEY_HIGHLIGHT_COLOR_RGBA = 4;
    private static final int KEY_LOCAL_SETTING = 102;
    private static final int KEY_SCROLL_DELAY = 5;
    private static final int KEY_START_CHAR = 103;
    private static final int KEY_START_TIME = 7;
    private static final int KEY_STRUCT_BLINKING_TEXT_LIST = 8;
    private static final int KEY_STRUCT_FONT_LIST = 9;
    private static final int KEY_STRUCT_HIGHLIGHT_LIST = 10;
    private static final int KEY_STRUCT_HYPER_TEXT_LIST = 11;
    private static final int KEY_STRUCT_JUSTIFICATION = 15;
    private static final int KEY_STRUCT_KARAOKE_LIST = 12;
    private static final int KEY_STRUCT_STYLE_LIST = 13;
    private static final int KEY_STRUCT_TEXT = 16;
    private static final int KEY_STRUCT_TEXT_POS = 14;
    private static final int KEY_STYLE_FLAGS = 2;
    private static final int KEY_TEXT_COLOR_RGBA = 107;
    private static final int KEY_WRAP_TEXT = 6;
    private static final int LAST_PRIVATE_KEY = 107;
    private static final int LAST_PUBLIC_KEY = 16;
    private static final String TAG = "TimedText";
    private int mBackgroundColorRGBA;
    private List mBlinkingPosList;
    private int mDisplayFlags;
    private List mFontList;
    private int mHighlightColorRGBA;
    private List mHighlightPosList;
    private List mHyperTextList;
    private Justification mJustification;
    private List mKaraokeList;
    private final HashMap mKeyObjectMap = new HashMap();
    private int mScrollDelay;
    private List mStyleList;
    private Rect mTextBounds;
    private String mTextChars;
    private int mWrapText;
}
