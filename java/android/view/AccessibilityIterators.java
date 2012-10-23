// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import java.text.BreakIterator;
import java.util.Locale;

// Referenced classes of package android.view:
//            ViewRootImpl

public final class AccessibilityIterators {
    static class ParagraphTextSegmentIterator extends AbstractTextSegmentIterator {

        public static ParagraphTextSegmentIterator getInstance() {
            if(sInstance == null)
                sInstance = new ParagraphTextSegmentIterator();
            return sInstance;
        }

        private boolean isEndBoundary(int i) {
            boolean flag;
            if(i > 0 && super.mText.charAt(i - 1) != '\n' && (i == super.mText.length() || super.mText.charAt(i) == '\n'))
                flag = true;
            else
                flag = false;
            return flag;
        }

        private boolean isStartBoundary(int i) {
            boolean flag;
            if(super.mText.charAt(i) != '\n' && (i == 0 || super.mText.charAt(i - 1) == '\n'))
                flag = true;
            else
                flag = false;
            return flag;
        }

        public int[] following(int i) {
            int ai[];
            int j;
            ai = null;
            j = super.mText.length();
            break MISSING_BLOCK_LABEL_10;
            while(true)  {
                do
                    return ai;
                while(j <= 0 || i >= j);
                int k = i;
                if(k < 0)
                    k = 0;
                for(; k < j && super.mText.charAt(k) == '\n' && !isStartBoundary(k); k++);
                if(k < j) {
                    int l;
                    for(l = k + 1; l < j && !isEndBoundary(l); l++);
                    ai = getRange(k, l);
                }
            }
        }

        public int[] preceding(int i) {
            int ai[];
            int j;
            ai = null;
            j = super.mText.length();
            break MISSING_BLOCK_LABEL_10;
            while(true)  {
                do
                    return ai;
                while(j <= 0 || i <= 0);
                int k = i;
                if(k > j)
                    k = j;
                for(; k > 0 && super.mText.charAt(k - 1) == '\n' && !isEndBoundary(k); k--);
                if(k > 0) {
                    int l;
                    for(l = k - 1; l > 0 && !isStartBoundary(l); l--);
                    ai = getRange(l, k);
                }
            }
        }

        private static ParagraphTextSegmentIterator sInstance;

        ParagraphTextSegmentIterator() {
        }
    }

    static class WordTextSegmentIterator extends CharacterTextSegmentIterator {

        public static WordTextSegmentIterator getInstance(Locale locale) {
            if(sInstance == null)
                sInstance = new WordTextSegmentIterator(locale);
            return sInstance;
        }

        private boolean isEndBoundary(int i) {
            boolean flag;
            if(i > 0 && isLetterOrDigit(i - 1) && (i == super.mText.length() || !isLetterOrDigit(i)))
                flag = true;
            else
                flag = false;
            return flag;
        }

        private boolean isLetterOrDigit(int i) {
            boolean flag;
            if(i >= 0 && i < super.mText.length())
                flag = Character.isLetterOrDigit(super.mText.codePointAt(i));
            else
                flag = false;
            return flag;
        }

        private boolean isStartBoundary(int i) {
            boolean flag;
            if(isLetterOrDigit(i) && (i == 0 || !isLetterOrDigit(i - 1)))
                flag = true;
            else
                flag = false;
            return flag;
        }

        public int[] following(int i) {
            int ai[];
            ai = null;
            break MISSING_BLOCK_LABEL_2;
label0:
            while(true)  {
                do
                    return ai;
                while(super.mText.length() <= 0 || i >= super.mText.length());
                int j = i;
                if(j < 0)
                    j = 0;
                while(!isLetterOrDigit(j) && !isStartBoundary(j))  {
                    j = super.mImpl.following(j);
                    if(j == -1)
                        continue label0;
                }
                int k = super.mImpl.following(j);
                if(k != -1 && isEndBoundary(k))
                    ai = getRange(j, k);
            }
        }

        protected void onLocaleChanged(Locale locale) {
            super.mImpl = BreakIterator.getWordInstance(locale);
        }

        public int[] preceding(int i) {
            int ai[];
            int j;
            ai = null;
            j = super.mText.length();
            break MISSING_BLOCK_LABEL_10;
label0:
            while(true)  {
                do
                    return ai;
                while(j <= 0 || i <= 0);
                int k = i;
                if(k > j)
                    k = j;
                while(k > 0 && !isLetterOrDigit(k - 1) && !isEndBoundary(k))  {
                    k = super.mImpl.preceding(k);
                    if(k == -1)
                        continue label0;
                }
                int l = super.mImpl.preceding(k);
                if(l != -1 && isStartBoundary(l))
                    ai = getRange(l, k);
            }
        }

        private static WordTextSegmentIterator sInstance;

        private WordTextSegmentIterator(Locale locale) {
            super(locale);
        }
    }

    static class CharacterTextSegmentIterator extends AbstractTextSegmentIterator
        implements ComponentCallbacks {

        public static CharacterTextSegmentIterator getInstance(Locale locale) {
            if(sInstance == null)
                sInstance = new CharacterTextSegmentIterator(locale);
            return sInstance;
        }

        public int[] following(int i) {
            int ai[];
            int j;
            ai = null;
            j = super.mText.length();
            break MISSING_BLOCK_LABEL_10;
label0:
            while(true)  {
                do
                    return ai;
                while(j <= 0 || i >= j);
                int k = i;
                if(k < 0)
                    k = 0;
                while(!mImpl.isBoundary(k))  {
                    k = mImpl.following(k);
                    if(k == -1)
                        continue label0;
                }
                int l = mImpl.following(k);
                if(l != -1)
                    ai = getRange(k, l);
            }
        }

        public void initialize(String s) {
            super.initialize(s);
            mImpl.setText(s);
        }

        public void onConfigurationChanged(Configuration configuration) {
            Locale locale = configuration.locale;
            if(!mLocale.equals(locale)) {
                mLocale = locale;
                onLocaleChanged(locale);
            }
        }

        protected void onLocaleChanged(Locale locale) {
            mImpl = BreakIterator.getCharacterInstance(locale);
        }

        public void onLowMemory() {
        }

        public int[] preceding(int i) {
            int ai[];
            int j;
            ai = null;
            j = super.mText.length();
            break MISSING_BLOCK_LABEL_10;
label0:
            while(true)  {
                do
                    return ai;
                while(j <= 0 || i <= 0);
                int k = i;
                if(k > j)
                    k = j;
                while(!mImpl.isBoundary(k))  {
                    k = mImpl.preceding(k);
                    if(k == -1)
                        continue label0;
                }
                int l = mImpl.preceding(k);
                if(l != -1)
                    ai = getRange(l, k);
            }
        }

        private static CharacterTextSegmentIterator sInstance;
        protected BreakIterator mImpl;
        private Locale mLocale;

        private CharacterTextSegmentIterator(Locale locale) {
            mLocale = locale;
            onLocaleChanged(locale);
            ViewRootImpl.addConfigCallback(this);
        }

    }

    public static abstract class AbstractTextSegmentIterator
        implements TextSegmentIterator {

        protected int[] getRange(int i, int j) {
            int ai[];
            if(i < 0 || j < 0 || i == j) {
                ai = null;
            } else {
                mSegment[0] = i;
                mSegment[1] = j;
                ai = mSegment;
            }
            return ai;
        }

        public void initialize(String s) {
            mText = s;
        }

        private final int mSegment[] = new int[2];
        protected String mText;

        public AbstractTextSegmentIterator() {
        }
    }

    public static interface TextSegmentIterator {

        public abstract int[] following(int i);

        public abstract int[] preceding(int i);
    }


    public AccessibilityIterators() {
    }
}
