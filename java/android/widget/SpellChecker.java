// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.text.*;
import android.text.method.WordIterator;
import android.text.style.SpellCheckSpan;
import android.text.style.SuggestionSpan;
import android.util.Log;
import android.util.LruCache;
import android.view.textservice.*;
import com.android.internal.util.ArrayUtils;
import java.util.Locale;

// Referenced classes of package android.widget:
//            TextView

public class SpellChecker
    implements android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener {
    private class SpellParser {

        private void removeRangeSpan(Editable editable) {
            editable.removeSpan(mRange);
        }

        private void removeSpansAt(Editable editable, int i, Object aobj[]) {
            int j = aobj.length;
            int k = 0;
            do {
                if(k >= j)
                    break;
                Object obj = aobj[k];
                if(editable.getSpanStart(obj) <= i && editable.getSpanEnd(obj) >= i)
                    editable.removeSpan(obj);
                k++;
            } while(true);
        }

        private void setRangeSpan(Editable editable, int i, int j) {
            editable.setSpan(mRange, i, j, 33);
        }

        public boolean isFinished() {
            boolean flag;
            if(((Editable)mTextView.getText()).getSpanStart(mRange) < 0)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void parse() {
            Editable editable;
            int i;
            int j;
            int k;
            int l;
            int i1;
            editable = (Editable)mTextView.getText();
            if(mIsSentenceSpellCheckSupported)
                i = Math.max(0, -50 + editable.getSpanStart(mRange));
            else
                i = editable.getSpanStart(mRange);
            j = editable.getSpanEnd(mRange);
            k = Math.min(j, 350 + i);
            mWordIterator.setCharSequence(editable, i, k);
            l = mWordIterator.preceding(i);
            if(l == -1) {
                i1 = mWordIterator.following(i);
                if(i1 != -1)
                    l = mWordIterator.getBeginning(i1);
            } else {
                i1 = mWordIterator.getEnd(l);
            }
            if(i1 != -1) goto _L2; else goto _L1
_L1:
            removeRangeSpan(editable);
_L5:
            return;
_L2:
            SpellCheckSpan aspellcheckspan[];
            SuggestionSpan asuggestionspan[];
            int j1;
            boolean flag;
            aspellcheckspan = (SpellCheckSpan[])editable.getSpans(i - 1, j + 1, android/text/style/SpellCheckSpan);
            asuggestionspan = (SuggestionSpan[])editable.getSpans(i - 1, j + 1, android/text/style/SuggestionSpan);
            j1 = 0;
            flag = false;
            if(!mIsSentenceSpellCheckSupported) goto _L4; else goto _L3
_L3:
            int j2;
label0:
            {
                if(k < j)
                    flag = true;
                j2 = mWordIterator.preceding(k);
                boolean flag2;
                if(j2 != -1)
                    flag2 = true;
                else
                    flag2 = false;
                if(flag2) {
                    j2 = mWordIterator.getEnd(j2);
                    if(j2 != -1)
                        flag2 = true;
                    else
                        flag2 = false;
                }
                if(flag2)
                    break label0;
                removeRangeSpan(editable);
            }
              goto _L5
            int k2;
            boolean flag3;
            int l2;
            k2 = l;
            flag3 = true;
            l2 = 0;
_L10:
            if(l2 >= mLength) goto _L7; else goto _L6
_L6:
            SpellCheckSpan spellcheckspan = mSpellCheckSpans[l2];
            if(mIds[l2] >= 0 && !spellcheckspan.isSpellCheckInProgress()) goto _L9; else goto _L8
_L8:
            l2++;
              goto _L10
_L9:
            int i3;
            int j3;
            i3 = editable.getSpanStart(spellcheckspan);
            j3 = editable.getSpanEnd(spellcheckspan);
            if(j3 < k2 || j2 < i3) goto _L8; else goto _L11
_L11:
            if(i3 > k2 || j2 > j3) goto _L13; else goto _L12
_L12:
            flag3 = false;
_L7:
            if(j2 >= i)
                if(j2 <= k2)
                    Log.w(SpellChecker.TAG, (new StringBuilder()).append("Trying to spellcheck invalid region, from ").append(i).append(" to ").append(j).toString());
                else
                if(flag3)
                    addSpellCheckSpan(editable, k2, j2);
            l = j2;
_L23:
            int k1;
            boolean flag1;
            int l1;
            int i2;
            if(flag)
                setRangeSpan(editable, l, j);
            else
                removeRangeSpan(editable);
            spellCheck();
              goto _L5
_L13:
            editable.removeSpan(spellcheckspan);
            k2 = Math.min(i3, k2);
            j2 = Math.max(j3, j2);
              goto _L8
_L4:
            if(l > j)
                break; /* Loop/switch isn't completed */
            if(i1 < i || i1 <= l) goto _L15; else goto _L14
_L14:
            if(j1 >= 50) {
                flag = true;
                break; /* Loop/switch isn't completed */
            }
            if(l < i && i1 > i) {
                removeSpansAt(editable, i, aspellcheckspan);
                removeSpansAt(editable, i, asuggestionspan);
            }
            if(l < j && i1 > j) {
                removeSpansAt(editable, j, aspellcheckspan);
                removeSpansAt(editable, j, asuggestionspan);
            }
            flag1 = true;
            if(i1 != i) goto _L17; else goto _L16
_L16:
            i2 = 0;
_L24:
            if(i2 >= aspellcheckspan.length) goto _L17; else goto _L18
_L18:
            if(editable.getSpanEnd(aspellcheckspan[i2]) != i) goto _L20; else goto _L19
_L19:
            flag1 = false;
_L17:
            if(l != j) goto _L22; else goto _L21
_L21:
            l1 = 0;
_L25:
            if(l1 < aspellcheckspan.length) {
                if(editable.getSpanStart(aspellcheckspan[l1]) != j)
                    break MISSING_BLOCK_LABEL_853;
                flag1 = false;
            }
_L22:
            if(flag1)
                addSpellCheckSpan(editable, l, i1);
            j1++;
_L15:
            k1 = i1;
            i1 = mWordIterator.following(i1);
            if(k < j && (i1 == -1 || i1 >= k)) {
                k = Math.min(j, k1 + 350);
                mWordIterator.setCharSequence(editable, k1, k);
                i1 = mWordIterator.following(k1);
            }
            if(i1 == -1)
                break; /* Loop/switch isn't completed */
            l = mWordIterator.getBeginning(i1);
            if(l != -1) goto _L4; else goto _L23
_L20:
            i2++;
              goto _L24
            l1++;
              goto _L25
        }

        public void parse(int i, int j) {
            int k = mTextView.length();
            int l;
            if(j > k) {
                Log.w(SpellChecker.TAG, (new StringBuilder()).append("Parse invalid region, from ").append(i).append(" to ").append(j).toString());
                l = k;
            } else {
                l = j;
            }
            if(l > i) {
                setRangeSpan((Editable)mTextView.getText(), i, l);
                parse();
            }
        }

        public void stop() {
            removeRangeSpan((Editable)mTextView.getText());
        }

        private Object mRange;
        final SpellChecker this$0;

        private SpellParser() {
            this$0 = SpellChecker.this;
            super();
            mRange = new Object();
        }

    }


    public SpellChecker(TextView textview) {
        mSpellParsers = new SpellParser[0];
        mSpanSequenceCounter = 0;
        mTextView = textview;
        int i = ArrayUtils.idealObjectArraySize(1);
        mIds = new int[i];
        mSpellCheckSpans = new SpellCheckSpan[i];
        setLocale(mTextView.getTextServicesLocale());
    }

    private void addSpellCheckSpan(Editable editable, int i, int j) {
        int k = nextSpellCheckSpanIndex();
        SpellCheckSpan spellcheckspan = mSpellCheckSpans[k];
        editable.setSpan(spellcheckspan, i, j, 33);
        spellcheckspan.setSpellCheckInProgress(false);
        int ai[] = mIds;
        int l = mSpanSequenceCounter;
        mSpanSequenceCounter = l + 1;
        ai[k] = l;
    }

    private void createMisspelledSuggestionSpan(Editable editable, SuggestionsInfo suggestionsinfo, SpellCheckSpan spellcheckspan, int i, int j) {
        int k = editable.getSpanStart(spellcheckspan);
        int l = editable.getSpanEnd(spellcheckspan);
        if(k >= 0 && l > k) {
            int i1;
            int j1;
            int k1;
            String as[];
            if(i != -1 && j != -1) {
                i1 = k + i;
                j1 = i1 + j;
            } else {
                i1 = k;
                j1 = l;
            }
            k1 = suggestionsinfo.getSuggestionsCount();
            if(k1 > 0) {
                as = new String[k1];
                for(int l1 = 0; l1 < k1; l1++)
                    as[l1] = suggestionsinfo.getSuggestionAt(l1);

            } else {
                as = (String[])ArrayUtils.emptyArray(java/lang/String);
            }
            SuggestionSpan suggestionspan = new SuggestionSpan(mTextView.getContext(), as, 3);
            if(mIsSentenceSpellCheckSupported) {
                Long long1 = Long.valueOf(TextUtils.packRangeInLong(i1, j1));
                SuggestionSpan suggestionspan1 = (SuggestionSpan)mSuggestionSpanCache.get(long1);
                if(suggestionspan1 != null)
                    editable.removeSpan(suggestionspan1);
                mSuggestionSpanCache.put(long1, suggestionspan);
            }
            editable.setSpan(suggestionspan, i1, j1, 33);
            mTextView.invalidateRegion(i1, j1, false);
        }
    }

    private boolean isSessionActive() {
        boolean flag;
        if(mSpellCheckerSession != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private int nextSpellCheckSpanIndex() {
        int i = 0;
_L3:
        if(i >= mLength)
            break MISSING_BLOCK_LABEL_27;
        if(mIds[i] >= 0) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        i++;
          goto _L3
        if(mLength == mSpellCheckSpans.length) {
            int j = 2 * mLength;
            int ai[] = new int[j];
            SpellCheckSpan aspellcheckspan[] = new SpellCheckSpan[j];
            System.arraycopy(mIds, 0, ai, 0, mLength);
            System.arraycopy(mSpellCheckSpans, 0, aspellcheckspan, 0, mLength);
            mIds = ai;
            mSpellCheckSpans = aspellcheckspan;
        }
        mSpellCheckSpans[mLength] = new SpellCheckSpan();
        mLength = 1 + mLength;
        i = -1 + mLength;
          goto _L1
    }

    private SpellCheckSpan onGetSuggestionsInternal(SuggestionsInfo suggestionsinfo, int i, int j) {
        if(suggestionsinfo != null && suggestionsinfo.getCookie() == mCookie) goto _L2; else goto _L1
_L1:
        SpellCheckSpan spellcheckspan = null;
_L4:
        return spellcheckspan;
_L2:
        Editable editable = (Editable)mTextView.getText();
        int k = suggestionsinfo.getSequence();
        int l = 0;
        do {
            if(l >= mLength)
                break;
            if(k == mIds[l]) {
                int i1 = suggestionsinfo.getSuggestionsAttributes();
                boolean flag;
                boolean flag1;
                if((i1 & 1) > 0)
                    flag = true;
                else
                    flag = false;
                if((i1 & 2) > 0)
                    flag1 = true;
                else
                    flag1 = false;
                spellcheckspan = mSpellCheckSpans[l];
                if(!flag && flag1)
                    createMisspelledSuggestionSpan(editable, suggestionsinfo, spellcheckspan, i, j);
                else
                if(mIsSentenceSpellCheckSupported) {
                    int j1 = editable.getSpanStart(spellcheckspan);
                    int k1 = editable.getSpanEnd(spellcheckspan);
                    int l1;
                    int i2;
                    if(i != -1 && j != -1) {
                        l1 = j1 + i;
                        i2 = l1 + j;
                    } else {
                        l1 = j1;
                        i2 = k1;
                    }
                    if(j1 >= 0 && k1 > j1 && i2 > l1) {
                        Long long1 = Long.valueOf(TextUtils.packRangeInLong(l1, i2));
                        SuggestionSpan suggestionspan = (SuggestionSpan)mSuggestionSpanCache.get(long1);
                        if(suggestionspan != null) {
                            editable.removeSpan(suggestionspan);
                            mSuggestionSpanCache.remove(long1);
                        }
                    }
                }
                continue; /* Loop/switch isn't completed */
            }
            l++;
        } while(true);
        spellcheckspan = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void resetSession() {
        closeSession();
        mTextServicesManager = (TextServicesManager)mTextView.getContext().getSystemService("textservices");
        int i;
        if(!mTextServicesManager.isSpellCheckerEnabled() || mTextServicesManager.getCurrentSpellCheckerSubtype(true) == null) {
            mSpellCheckerSession = null;
        } else {
            mSpellCheckerSession = mTextServicesManager.newSpellCheckerSession(null, mCurrentLocale, this, false);
            mIsSentenceSpellCheckSupported = true;
        }
        for(i = 0; i < mLength; i++)
            mIds[i] = -1;

        mLength = 0;
        mTextView.removeMisspelledSpans((Editable)mTextView.getText());
        mSuggestionSpanCache.evictAll();
    }

    private void scheduleNewSpellCheck() {
        if(mSpellRunnable == null)
            mSpellRunnable = new Runnable() {

                public void run() {
                    int i = mSpellParsers.length;
                    int j = 0;
                    do {
label0:
                        {
                            if(j < i) {
                                SpellParser spellparser = mSpellParsers[j];
                                if(spellparser.isFinished())
                                    break label0;
                                spellparser.parse();
                            }
                            return;
                        }
                        j++;
                    } while(true);
                }

                final SpellChecker this$0;

             {
                this$0 = SpellChecker.this;
                super();
            }
            };
        else
            mTextView.removeCallbacks(mSpellRunnable);
        mTextView.postDelayed(mSpellRunnable, 400L);
    }

    private void setLocale(Locale locale) {
        mCurrentLocale = locale;
        resetSession();
        mWordIterator = new WordIterator(locale);
        mTextView.onLocaleChanged();
    }

    private void spellCheck() {
        if(mSpellCheckerSession != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Editable editable = (Editable)mTextView.getText();
        int i = Selection.getSelectionStart(editable);
        int j = Selection.getSelectionEnd(editable);
        TextInfo atextinfo[] = new TextInfo[mLength];
        int k = 0;
        int l = 0;
        while(l < mLength)  {
            SpellCheckSpan spellcheckspan = mSpellCheckSpans[l];
            if(mIds[l] >= 0 && !spellcheckspan.isSpellCheckInProgress()) {
                int i1 = editable.getSpanStart(spellcheckspan);
                int j1 = editable.getSpanEnd(spellcheckspan);
                boolean flag;
                if(mIsSentenceSpellCheckSupported) {
                    if(j <= i1 || i > j1)
                        flag = true;
                    else
                        flag = false;
                } else
                if(j < i1 || i > j1)
                    flag = true;
                else
                    flag = false;
                if(i1 >= 0 && j1 > i1 && flag) {
                    String s;
                    int k1;
                    if(editable instanceof SpannableStringBuilder)
                        s = ((SpannableStringBuilder)editable).substring(i1, j1);
                    else
                        s = editable.subSequence(i1, j1).toString();
                    spellcheckspan.setSpellCheckInProgress(true);
                    k1 = k + 1;
                    atextinfo[k] = new TextInfo(s, mCookie, mIds[l]);
                    k = k1;
                }
            }
            l++;
        }
        if(k > 0) {
            if(k < atextinfo.length) {
                TextInfo atextinfo1[] = new TextInfo[k];
                System.arraycopy(atextinfo, 0, atextinfo1, 0, k);
                atextinfo = atextinfo1;
            }
            if(mIsSentenceSpellCheckSupported)
                mSpellCheckerSession.getSentenceSuggestions(atextinfo, 5);
            else
                mSpellCheckerSession.getSuggestions(atextinfo, 5, false);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void closeSession() {
        if(mSpellCheckerSession != null)
            mSpellCheckerSession.close();
        int i = mSpellParsers.length;
        for(int j = 0; j < i; j++)
            mSpellParsers[j].stop();

        if(mSpellRunnable != null)
            mTextView.removeCallbacks(mSpellRunnable);
    }

    public void onGetSentenceSuggestions(SentenceSuggestionsInfo asentencesuggestionsinfo[]) {
        Editable editable = (Editable)mTextView.getText();
        int i = 0;
        while(i < asentencesuggestionsinfo.length)  {
            SentenceSuggestionsInfo sentencesuggestionsinfo = asentencesuggestionsinfo[i];
            if(sentencesuggestionsinfo != null) {
                SpellCheckSpan spellcheckspan = null;
                int j = 0;
                while(j < sentencesuggestionsinfo.getSuggestionsCount())  {
                    SuggestionsInfo suggestionsinfo = sentencesuggestionsinfo.getSuggestionsInfoAt(j);
                    if(suggestionsinfo != null) {
                        SpellCheckSpan spellcheckspan1 = onGetSuggestionsInternal(suggestionsinfo, sentencesuggestionsinfo.getOffsetAt(j), sentencesuggestionsinfo.getLengthAt(j));
                        if(spellcheckspan == null && spellcheckspan1 != null)
                            spellcheckspan = spellcheckspan1;
                    }
                    j++;
                }
                if(spellcheckspan != null)
                    editable.removeSpan(spellcheckspan);
            }
            i++;
        }
        scheduleNewSpellCheck();
    }

    public void onGetSuggestions(SuggestionsInfo asuggestionsinfo[]) {
        Editable editable = (Editable)mTextView.getText();
        for(int i = 0; i < asuggestionsinfo.length; i++) {
            SpellCheckSpan spellcheckspan = onGetSuggestionsInternal(asuggestionsinfo[i], -1, -1);
            if(spellcheckspan != null)
                editable.removeSpan(spellcheckspan);
        }

        scheduleNewSpellCheck();
    }

    public void onSelectionChanged() {
        spellCheck();
    }

    public void onSpellCheckSpanRemoved(SpellCheckSpan spellcheckspan) {
        int i = 0;
        do {
label0:
            {
                if(i < mLength) {
                    if(mSpellCheckSpans[i] != spellcheckspan)
                        break label0;
                    mIds[i] = -1;
                }
                return;
            }
            i++;
        } while(true);
    }

    public void spellCheck(int i, int j) {
        Locale locale = mTextView.getTextServicesLocale();
        boolean flag = isSessionActive();
        if(mCurrentLocale == null || !mCurrentLocale.equals(locale)) {
            setLocale(locale);
            i = 0;
            j = mTextView.getText().length();
        } else
        if(flag != mTextServicesManager.isSpellCheckerEnabled())
            resetSession();
        if(flag) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k = mSpellParsers.length;
        int l = 0;
        do {
            if(l >= k)
                break;
            SpellParser spellparser1 = mSpellParsers[l];
            if(spellparser1.isFinished()) {
                spellparser1.parse(i, j);
                continue; /* Loop/switch isn't completed */
            }
            l++;
        } while(true);
        SpellParser aspellparser[] = new SpellParser[k + 1];
        System.arraycopy(mSpellParsers, 0, aspellparser, 0, k);
        mSpellParsers = aspellparser;
        SpellParser spellparser = new SpellParser();
        mSpellParsers[k] = spellparser;
        spellparser.parse(i, j);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static final int AVERAGE_WORD_LENGTH = 7;
    private static final boolean DBG = false;
    public static final int MAX_NUMBER_OF_WORDS = 50;
    private static final int MIN_SENTENCE_LENGTH = 50;
    private static final int SPELL_PAUSE_DURATION = 400;
    private static final int SUGGESTION_SPAN_CACHE_SIZE = 10;
    private static final String TAG = android/widget/SpellChecker.getSimpleName();
    private static final int USE_SPAN_RANGE = -1;
    public static final int WORD_ITERATOR_INTERVAL = 350;
    final int mCookie = hashCode();
    private Locale mCurrentLocale;
    private int mIds[];
    private boolean mIsSentenceSpellCheckSupported;
    private int mLength;
    private int mSpanSequenceCounter;
    private SpellCheckSpan mSpellCheckSpans[];
    SpellCheckerSession mSpellCheckerSession;
    private SpellParser mSpellParsers[];
    private Runnable mSpellRunnable;
    private final LruCache mSuggestionSpanCache = new LruCache(10);
    private TextServicesManager mTextServicesManager;
    private final TextView mTextView;
    private WordIterator mWordIterator;











}
