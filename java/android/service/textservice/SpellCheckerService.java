// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.service.textservice;

import android.app.Service;
import android.content.Intent;
import android.os.*;
import android.text.TextUtils;
import android.text.method.WordIterator;
import android.view.textservice.*;
import com.android.internal.textservice.ISpellCheckerSession;
import com.android.internal.textservice.ISpellCheckerSessionListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;

public abstract class SpellCheckerService extends Service {
    private static class SentenceLevelAdapter {
        public static class SentenceTextInfoParams {

            final ArrayList mItems;
            final TextInfo mOriginalTextInfo;
            final int mSize;

            public SentenceTextInfoParams(TextInfo textinfo, ArrayList arraylist) {
                mOriginalTextInfo = textinfo;
                mItems = arraylist;
                mSize = arraylist.size();
            }
        }

        public static class SentenceWordItem {

            public final int mLength;
            public final int mStart;
            public final TextInfo mTextInfo;

            public SentenceWordItem(TextInfo textinfo, int i, int j) {
                mTextInfo = textinfo;
                mStart = i;
                mLength = j - i;
            }
        }


        private SentenceTextInfoParams getSplitWords(TextInfo textinfo) {
            WordIterator worditerator = mWordIterator;
            String s = textinfo.getText();
            int i = textinfo.getCookie();
            int j = s.length();
            ArrayList arraylist = new ArrayList();
            worditerator.setCharSequence(s, 0, s.length());
            int k = worditerator.following(0);
            int l = worditerator.getBeginning(k);
            do {
label0:
                {
                    if(l <= j && k != -1 && l != -1) {
                        if(k >= 0 && k > l) {
                            String s1 = s.subSequence(l, k).toString();
                            arraylist.add(new SentenceWordItem(new TextInfo(s1, i, s1.hashCode()), l, k));
                        }
                        k = worditerator.following(k);
                        if(k != -1)
                            break label0;
                    }
                    return new SentenceTextInfoParams(textinfo, arraylist);
                }
                l = worditerator.getBeginning(k);
            } while(true);
        }

        public static SentenceSuggestionsInfo reconstructSuggestions(SentenceTextInfoParams sentencetextinfoparams, SuggestionsInfo asuggestionsinfo[]) {
            SentenceSuggestionsInfo sentencesuggestionsinfo;
            sentencesuggestionsinfo = null;
            break MISSING_BLOCK_LABEL_2;
_L5:
            int i;
            int j;
            int k;
            int ai[];
            int ai1[];
            SuggestionsInfo asuggestionsinfo1[];
            int l;
            do
                return sentencesuggestionsinfo;
            while(asuggestionsinfo == null || asuggestionsinfo.length == 0 || sentencetextinfoparams == null);
            i = sentencetextinfoparams.mOriginalTextInfo.getCookie();
            j = sentencetextinfoparams.mOriginalTextInfo.getSequence();
            k = sentencetextinfoparams.mSize;
            ai = new int[k];
            ai1 = new int[k];
            asuggestionsinfo1 = new SuggestionsInfo[k];
            l = 0;
_L2:
            SentenceWordItem sentenceworditem;
            SuggestionsInfo suggestionsinfo;
            int i1;
            if(l >= k)
                break MISSING_BLOCK_LABEL_187;
            sentenceworditem = (SentenceWordItem)sentencetextinfoparams.mItems.get(l);
            suggestionsinfo = null;
            i1 = 0;
_L3:
label0:
            {
                if(i1 < asuggestionsinfo.length) {
                    SuggestionsInfo suggestionsinfo1 = asuggestionsinfo[i1];
                    if(suggestionsinfo1 == null || suggestionsinfo1.getSequence() != sentenceworditem.mTextInfo.getSequence())
                        break label0;
                    suggestionsinfo = suggestionsinfo1;
                    suggestionsinfo.setCookieAndSequence(i, j);
                }
                ai[l] = sentenceworditem.mStart;
                ai1[l] = sentenceworditem.mLength;
                if(suggestionsinfo == null)
                    suggestionsinfo = EMPTY_SUGGESTIONS_INFO;
                asuggestionsinfo1[l] = suggestionsinfo;
                l++;
            }
            if(true) goto _L2; else goto _L1
_L1:
            i1++;
              goto _L3
            sentencesuggestionsinfo = new SentenceSuggestionsInfo(asuggestionsinfo1, ai, ai1);
            if(true) goto _L5; else goto _L4
_L4:
        }

        public static final SentenceSuggestionsInfo EMPTY_SENTENCE_SUGGESTIONS_INFOS[] = new SentenceSuggestionsInfo[0];
        private static final SuggestionsInfo EMPTY_SUGGESTIONS_INFO = new SuggestionsInfo(0, null);
        private final WordIterator mWordIterator;



        public SentenceLevelAdapter(Locale locale) {
            mWordIterator = new WordIterator(locale);
        }
    }

    private static class SpellCheckerServiceBinder extends com.android.internal.textservice.ISpellCheckerService.Stub {

        public ISpellCheckerSession getISpellCheckerSession(String s, ISpellCheckerSessionListener ispellcheckersessionlistener, Bundle bundle) {
            SpellCheckerService spellcheckerservice = (SpellCheckerService)mInternalServiceRef.get();
            Object obj;
            if(spellcheckerservice == null) {
                obj = null;
            } else {
                Session session = spellcheckerservice.createSession();
                obj = new InternalISpellCheckerSession(s, ispellcheckersessionlistener, bundle, session);
                session.onCreate();
            }
            return ((ISpellCheckerSession) (obj));
        }

        private final WeakReference mInternalServiceRef;

        public SpellCheckerServiceBinder(SpellCheckerService spellcheckerservice) {
            mInternalServiceRef = new WeakReference(spellcheckerservice);
        }
    }

    private static class InternalISpellCheckerSession extends com.android.internal.textservice.ISpellCheckerSession.Stub {

        public Bundle getBundle() {
            return mBundle;
        }

        public String getLocale() {
            return mLocale;
        }

        public void onCancel() {
            int i = Process.getThreadPriority(Process.myTid());
            Process.setThreadPriority(10);
            mSession.onCancel();
            Process.setThreadPriority(i);
            return;
            Exception exception;
            exception;
            Process.setThreadPriority(i);
            throw exception;
        }

        public void onClose() {
            int i = Process.getThreadPriority(Process.myTid());
            Process.setThreadPriority(10);
            mSession.onClose();
            Process.setThreadPriority(i);
            mListener = null;
            return;
            Exception exception;
            exception;
            Process.setThreadPriority(i);
            mListener = null;
            throw exception;
        }

        public void onGetSentenceSuggestionsMultiple(TextInfo atextinfo[], int i) {
            mListener.onGetSentenceSuggestions(mSession.onGetSentenceSuggestionsMultiple(atextinfo, i));
_L2:
            return;
            RemoteException remoteexception;
            remoteexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public void onGetSuggestionsMultiple(TextInfo atextinfo[], int i, boolean flag) {
            int j = Process.getThreadPriority(Process.myTid());
            Exception exception;
            try {
                Process.setThreadPriority(10);
                mListener.onGetSuggestions(mSession.onGetSuggestionsMultiple(atextinfo, i, flag));
            }
            catch(RemoteException remoteexception) { }
            finally {
                Process.setThreadPriority(j);
            }
            Process.setThreadPriority(j);
            return;
            throw exception;
        }

        private final Bundle mBundle;
        private ISpellCheckerSessionListener mListener;
        private final String mLocale;
        private final Session mSession;

        public InternalISpellCheckerSession(String s, ISpellCheckerSessionListener ispellcheckersessionlistener, Bundle bundle, Session session) {
            mListener = ispellcheckersessionlistener;
            mSession = session;
            mLocale = s;
            mBundle = bundle;
            session.setInternalISpellCheckerSession(this);
        }
    }

    public static abstract class Session {

        public Bundle getBundle() {
            return mInternalSession.getBundle();
        }

        public String getLocale() {
            return mInternalSession.getLocale();
        }

        public void onCancel() {
        }

        public void onClose() {
        }

        public abstract void onCreate();

        public SentenceSuggestionsInfo[] onGetSentenceSuggestionsMultiple(TextInfo atextinfo[], int i) {
            if(atextinfo != null && atextinfo.length != 0) goto _L2; else goto _L1
_L1:
            SentenceSuggestionsInfo asentencesuggestionsinfo[] = SentenceLevelAdapter.EMPTY_SENTENCE_SUGGESTIONS_INFOS;
_L6:
            return asentencesuggestionsinfo;
_L2:
            if(mSentenceLevelAdapter != null) goto _L4; else goto _L3
_L3:
            this;
            JVM INSTR monitorenter ;
            if(mSentenceLevelAdapter == null) {
                String s = getLocale();
                if(!TextUtils.isEmpty(s))
                    mSentenceLevelAdapter = new SentenceLevelAdapter(new Locale(s));
            }
            this;
            JVM INSTR monitorexit ;
_L4:
            if(mSentenceLevelAdapter != null)
                break; /* Loop/switch isn't completed */
            asentencesuggestionsinfo = SentenceLevelAdapter.EMPTY_SENTENCE_SUGGESTIONS_INFOS;
            if(true) goto _L6; else goto _L5
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
_L5:
            int j = atextinfo.length;
            asentencesuggestionsinfo = new SentenceSuggestionsInfo[j];
            int k = 0;
            while(k < j)  {
                SentenceLevelAdapter.SentenceTextInfoParams sentencetextinfoparams = mSentenceLevelAdapter.getSplitWords(atextinfo[k]);
                ArrayList arraylist = sentencetextinfoparams.mItems;
                int l = arraylist.size();
                TextInfo atextinfo1[] = new TextInfo[l];
                for(int i1 = 0; i1 < l; i1++)
                    atextinfo1[i1] = ((SentenceLevelAdapter.SentenceWordItem)arraylist.get(i1)).mTextInfo;

                asentencesuggestionsinfo[k] = SentenceLevelAdapter.reconstructSuggestions(sentencetextinfoparams, onGetSuggestionsMultiple(atextinfo1, i, true));
                k++;
            }
            if(true) goto _L6; else goto _L7
_L7:
        }

        public abstract SuggestionsInfo onGetSuggestions(TextInfo textinfo, int i);

        public SuggestionsInfo[] onGetSuggestionsMultiple(TextInfo atextinfo[], int i, boolean flag) {
            int j = atextinfo.length;
            SuggestionsInfo asuggestionsinfo[] = new SuggestionsInfo[j];
            for(int k = 0; k < j; k++) {
                asuggestionsinfo[k] = onGetSuggestions(atextinfo[k], i);
                asuggestionsinfo[k].setCookieAndSequence(atextinfo[k].getCookie(), atextinfo[k].getSequence());
            }

            return asuggestionsinfo;
        }

        public final void setInternalISpellCheckerSession(InternalISpellCheckerSession internalispellcheckersession) {
            mInternalSession = internalispellcheckersession;
        }

        private InternalISpellCheckerSession mInternalSession;
        private volatile SentenceLevelAdapter mSentenceLevelAdapter;

        public Session() {
        }
    }


    public SpellCheckerService() {
    }

    public abstract Session createSession();

    public final IBinder onBind(Intent intent) {
        return mBinder;
    }

    private static final boolean DBG = false;
    public static final String SERVICE_INTERFACE = "android.service.textservice.SpellCheckerService";
    private static final String TAG = android/service/textservice/SpellCheckerService.getSimpleName();
    private final SpellCheckerServiceBinder mBinder = new SpellCheckerServiceBinder(this);

}
