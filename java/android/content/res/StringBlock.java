// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.res;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.*;
import android.text.style.*;
import android.util.SparseArray;
import com.android.internal.util.XmlUtils;

final class StringBlock {
    private static class Height
        implements android.text.style.LineHeightSpan.WithDensity {

        public void chooseHeight(CharSequence charsequence, int i, int j, int k, int l, android.graphics.Paint.FontMetricsInt fontmetricsint) {
            chooseHeight(charsequence, i, j, k, l, fontmetricsint, null);
        }

        public void chooseHeight(CharSequence charsequence, int i, int j, int k, int l, android.graphics.Paint.FontMetricsInt fontmetricsint, TextPaint textpaint) {
            int i1 = mSize;
            if(textpaint != null)
                i1 = (int)((float)i1 * textpaint.density);
            if(fontmetricsint.bottom - fontmetricsint.top < i1) {
                fontmetricsint.top = fontmetricsint.bottom - i1;
                fontmetricsint.ascent = fontmetricsint.ascent - i1;
            } else {
                if(sProportion == 0.0F) {
                    Paint paint = new Paint();
                    paint.setTextSize(100F);
                    Rect rect = new Rect();
                    paint.getTextBounds("ABCDEFG", 0, 7, rect);
                    sProportion = (float)rect.top / paint.ascent();
                }
                int j1 = (int)Math.ceil((float)(-fontmetricsint.top) * sProportion);
                if(i1 - fontmetricsint.descent >= j1) {
                    fontmetricsint.top = fontmetricsint.bottom - i1;
                    fontmetricsint.ascent = fontmetricsint.descent - i1;
                } else
                if(i1 >= j1) {
                    int l1 = -j1;
                    fontmetricsint.ascent = l1;
                    fontmetricsint.top = l1;
                    int i2 = i1 + fontmetricsint.top;
                    fontmetricsint.descent = i2;
                    fontmetricsint.bottom = i2;
                } else {
                    int k1 = -i1;
                    fontmetricsint.ascent = k1;
                    fontmetricsint.top = k1;
                    fontmetricsint.descent = 0;
                    fontmetricsint.bottom = 0;
                }
            }
        }

        private static float sProportion = 0.0F;
        private int mSize;


        public Height(int i) {
            mSize = i;
        }
    }

    static final class StyleIDs {

        private int bigId;
        private int boldId;
        private int italicId;
        private int listItemId;
        private int marqueeId;
        private int smallId;
        private int strikeId;
        private int subId;
        private int supId;
        private int ttId;
        private int underlineId;



/*
        static int access$002(StyleIDs styleids, int i) {
            styleids.boldId = i;
            return i;
        }

*/




/*
        static int access$1002(StyleIDs styleids, int i) {
            styleids.marqueeId = i;
            return i;
        }

*/


/*
        static int access$102(StyleIDs styleids, int i) {
            styleids.italicId = i;
            return i;
        }

*/



/*
        static int access$202(StyleIDs styleids, int i) {
            styleids.underlineId = i;
            return i;
        }

*/



/*
        static int access$302(StyleIDs styleids, int i) {
            styleids.ttId = i;
            return i;
        }

*/



/*
        static int access$402(StyleIDs styleids, int i) {
            styleids.bigId = i;
            return i;
        }

*/



/*
        static int access$502(StyleIDs styleids, int i) {
            styleids.smallId = i;
            return i;
        }

*/



/*
        static int access$602(StyleIDs styleids, int i) {
            styleids.subId = i;
            return i;
        }

*/



/*
        static int access$702(StyleIDs styleids, int i) {
            styleids.supId = i;
            return i;
        }

*/



/*
        static int access$802(StyleIDs styleids, int i) {
            styleids.strikeId = i;
            return i;
        }

*/



/*
        static int access$902(StyleIDs styleids, int i) {
            styleids.listItemId = i;
            return i;
        }

*/

        StyleIDs() {
            boldId = -1;
            italicId = -1;
            underlineId = -1;
            ttId = -1;
            bigId = -1;
            smallId = -1;
            subId = -1;
            supId = -1;
            strikeId = -1;
            listItemId = -1;
            marqueeId = -1;
        }
    }


    StringBlock(int i, boolean flag) {
        mStyleIDs = null;
        mNative = i;
        mUseSparse = flag;
        mOwnsNative = false;
    }

    public StringBlock(byte abyte0[], int i, int j, boolean flag) {
        mStyleIDs = null;
        mNative = nativeCreate(abyte0, i, j);
        mUseSparse = flag;
        mOwnsNative = true;
    }

    public StringBlock(byte abyte0[], boolean flag) {
        mStyleIDs = null;
        mNative = nativeCreate(abyte0, 0, abyte0.length);
        mUseSparse = flag;
        mOwnsNative = true;
    }

    private static void addParagraphSpan(Spannable spannable, Object obj, int i, int j) {
        int k = spannable.length();
        if(i == 0 || i == k || spannable.charAt(i - 1) == '\n') goto _L2; else goto _L1
_L1:
        i--;
_L5:
        if(i > 0 && spannable.charAt(i - 1) != '\n') goto _L3; else goto _L2
_L2:
        if(j != 0 && j != k && spannable.charAt(j - 1) != '\n')
            for(j++; j < k && spannable.charAt(j - 1) != '\n'; j++)
                break MISSING_BLOCK_LABEL_118;

        spannable.setSpan(obj, i, j, 51);
        return;
_L3:
        i--;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private CharSequence applyStyles(String s, int ai[], StyleIDs styleids) {
        if(ai.length != 0) goto _L2; else goto _L1
_L1:
        return s;
_L2:
        SpannableString spannablestring;
        int i;
        spannablestring = new SpannableString(s);
        i = 0;
_L3:
        String s1;
        if(i >= ai.length)
            break MISSING_BLOCK_LABEL_926;
        int j = ai[i];
        if(j == styleids.boldId)
            spannablestring.setSpan(new StyleSpan(1), ai[i + 1], 1 + ai[i + 2], 33);
        else
        if(j == styleids.italicId)
            spannablestring.setSpan(new StyleSpan(2), ai[i + 1], 1 + ai[i + 2], 33);
        else
        if(j == styleids.underlineId)
            spannablestring.setSpan(new UnderlineSpan(), ai[i + 1], 1 + ai[i + 2], 33);
        else
        if(j == styleids.ttId)
            spannablestring.setSpan(new TypefaceSpan("monospace"), ai[i + 1], 1 + ai[i + 2], 33);
        else
        if(j == styleids.bigId)
            spannablestring.setSpan(new RelativeSizeSpan(1.25F), ai[i + 1], 1 + ai[i + 2], 33);
        else
        if(j == styleids.smallId)
            spannablestring.setSpan(new RelativeSizeSpan(0.8F), ai[i + 1], 1 + ai[i + 2], 33);
        else
        if(j == styleids.subId)
            spannablestring.setSpan(new SubscriptSpan(), ai[i + 1], 1 + ai[i + 2], 33);
        else
        if(j == styleids.supId)
            spannablestring.setSpan(new SuperscriptSpan(), ai[i + 1], 1 + ai[i + 2], 33);
        else
        if(j == styleids.strikeId)
            spannablestring.setSpan(new StrikethroughSpan(), ai[i + 1], 1 + ai[i + 2], 33);
        else
        if(j == styleids.listItemId)
            addParagraphSpan(spannablestring, new BulletSpan(10), ai[i + 1], 1 + ai[i + 2]);
        else
        if(j == styleids.marqueeId) {
            spannablestring.setSpan(android.text.TextUtils.TruncateAt.MARQUEE, ai[i + 1], 1 + ai[i + 2], 18);
        } else {
            s1 = nativeGetString(mNative, j);
            if(s1.startsWith("font;")) {
                String s5 = subtag(s1, ";height=");
                if(s5 != null) {
                    int j2 = Integer.parseInt(s5);
                    Height height = new Height(j2);
                    addParagraphSpan(spannablestring, height, ai[i + 1], 1 + ai[i + 2]);
                }
                String s6 = subtag(s1, ";size=");
                if(s6 != null) {
                    int i2 = Integer.parseInt(s6);
                    AbsoluteSizeSpan absolutesizespan = new AbsoluteSizeSpan(i2, true);
                    spannablestring.setSpan(absolutesizespan, ai[i + 1], 1 + ai[i + 2], 33);
                }
                String s7 = subtag(s1, ";fgcolor=");
                if(s7 != null) {
                    int l1 = XmlUtils.convertValueToUnsignedInt(s7, -1);
                    ForegroundColorSpan foregroundcolorspan = new ForegroundColorSpan(l1);
                    spannablestring.setSpan(foregroundcolorspan, ai[i + 1], 1 + ai[i + 2], 33);
                }
                String s8 = subtag(s1, ";bgcolor=");
                if(s8 != null) {
                    int k1 = XmlUtils.convertValueToUnsignedInt(s8, -1);
                    BackgroundColorSpan backgroundcolorspan = new BackgroundColorSpan(k1);
                    spannablestring.setSpan(backgroundcolorspan, ai[i + 1], 1 + ai[i + 2], 33);
                }
            } else {
                if(!s1.startsWith("a;"))
                    continue; /* Loop/switch isn't completed */
                String s4 = subtag(s1, ";href=");
                if(s4 != null) {
                    URLSpan urlspan = new URLSpan(s4);
                    spannablestring.setSpan(urlspan, ai[i + 1], 1 + ai[i + 2], 33);
                }
            }
        }
_L5:
        i += 3;
          goto _L3
        if(!s1.startsWith("annotation;")) goto _L5; else goto _L4
_L4:
        int k;
        int l;
        k = s1.length();
        l = s1.indexOf(';');
_L8:
        if(l >= k) goto _L5; else goto _L6
_L6:
        int i1 = s1.indexOf('=', l);
        if(i1 < 0) goto _L5; else goto _L7
_L7:
        int j1 = s1.indexOf(';', i1);
        if(j1 < 0)
            j1 = k;
        String s2 = s1.substring(l + 1, i1);
        String s3 = s1.substring(i1 + 1, j1);
        Annotation annotation = new Annotation(s2, s3);
        spannablestring.setSpan(annotation, ai[i + 1], 1 + ai[i + 2], 33);
        l = j1;
          goto _L8
        s = new SpannedString(spannablestring);
        if(true) goto _L1; else goto _L9
_L9:
    }

    private static final native int nativeCreate(byte abyte0[], int i, int j);

    private static final native void nativeDestroy(int i);

    private static final native int nativeGetSize(int i);

    private static final native String nativeGetString(int i, int j);

    private static final native int[] nativeGetStyle(int i, int j);

    private static String subtag(String s, String s1) {
        int i = s.indexOf(s1);
        String s2;
        if(i < 0) {
            s2 = null;
        } else {
            int j = i + s1.length();
            int k = s.indexOf(';', j);
            if(k < 0)
                s2 = s.substring(j);
            else
                s2 = s.substring(j, k);
        }
        return s2;
    }

    protected void finalize() throws Throwable {
        if(mOwnsNative)
            nativeDestroy(mNative);
    }

    public CharSequence get(int i) {
        this;
        JVM INSTR monitorenter ;
        if(mStrings == null) goto _L2; else goto _L1
_L1:
        Object obj = mStrings[i];
        if(obj == null) goto _L4; else goto _L3
_L2:
        if(mSparseStrings == null) goto _L6; else goto _L5
_L5:
        obj = (CharSequence)mSparseStrings.get(i);
        if(obj == null) goto _L4; else goto _L3
        Exception exception;
        exception;
        throw exception;
_L6:
        String s;
        int ai[];
        int j = nativeGetSize(mNative);
        if(mUseSparse && j > 250)
            mSparseStrings = new SparseArray();
        else
            mStrings = new CharSequence[j];
_L4:
        s = nativeGetString(mNative, i);
        obj = s;
        ai = nativeGetStyle(mNative, i);
        if(ai != null) {
            if(mStyleIDs == null)
                mStyleIDs = new StyleIDs();
            break MISSING_BLOCK_LABEL_631;
        }
          goto _L7
        k = 0;
        int k;
        for(; k < ai.length; k += 3) {
            int l = ai[k];
            if(l != mStyleIDs.boldId && l != mStyleIDs.italicId && l != mStyleIDs.underlineId && l != mStyleIDs.ttId && l != mStyleIDs.bigId && l != mStyleIDs.smallId && l != mStyleIDs.subId && l != mStyleIDs.supId && l != mStyleIDs.strikeId && l != mStyleIDs.listItemId && l != mStyleIDs.marqueeId) {
                String s1 = nativeGetString(mNative, l);
                if(s1.equals("b"))
                    mStyleIDs.boldId = l;
                else
                if(s1.equals("i"))
                    mStyleIDs.italicId = l;
                else
                if(s1.equals("u"))
                    mStyleIDs.underlineId = l;
                else
                if(s1.equals("tt"))
                    mStyleIDs.ttId = l;
                else
                if(s1.equals("big"))
                    mStyleIDs.bigId = l;
                else
                if(s1.equals("small"))
                    mStyleIDs.smallId = l;
                else
                if(s1.equals("sup"))
                    mStyleIDs.supId = l;
                else
                if(s1.equals("sub"))
                    mStyleIDs.subId = l;
                else
                if(s1.equals("strike"))
                    mStyleIDs.strikeId = l;
                else
                if(s1.equals("li"))
                    mStyleIDs.listItemId = l;
                else
                if(s1.equals("marquee"))
                    mStyleIDs.marqueeId = l;
            }
            break MISSING_BLOCK_LABEL_637;
        }

        obj = applyStyles(s, ai, mStyleIDs);
_L7:
        if(mStrings != null)
            mStrings[i] = ((CharSequence) (obj));
        else
            mSparseStrings.put(i, obj);
        this;
        JVM INSTR monitorexit ;
_L3:
        return ((CharSequence) (obj));
    }

    private static final String TAG = "AssetManager";
    private static final boolean localLOGV;
    private final int mNative;
    private final boolean mOwnsNative;
    private SparseArray mSparseStrings;
    private CharSequence mStrings[];
    StyleIDs mStyleIDs;
    private final boolean mUseSparse;
}
