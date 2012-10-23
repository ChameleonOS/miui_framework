// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import android.util.LocaleUtil;
import java.util.Locale;

// Referenced classes of package android.text:
//            TextDirectionHeuristic

public class TextDirectionHeuristics {
    private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {

        protected boolean defaultIsRtl() {
            boolean flag = true;
            if(LocaleUtil.getLayoutDirectionFromLocale(Locale.getDefault()) != flag)
                flag = false;
            return flag;
        }

        public static final TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicLocale();


        public TextDirectionHeuristicLocale() {
            super(null);
        }
    }

    private static class AnyStrong
        implements TextDirectionAlgorithm {

        public TriState checkRtl(char ac[], int i, int j) {
            boolean flag;
            int k;
            int l;
            flag = false;
            k = i;
            l = i + j;
_L6:
            if(k >= l) goto _L2; else goto _L1
_L1:
            class _cls1 {

                static final int $SwitchMap$android$text$TextDirectionHeuristics$TriState[];

                static  {
                    $SwitchMap$android$text$TextDirectionHeuristics$TriState = new int[TriState.values().length];
                    NoSuchFieldError nosuchfielderror1;
                    try {
                        $SwitchMap$android$text$TextDirectionHeuristics$TriState[TriState.TRUE.ordinal()] = 1;
                    }
                    catch(NoSuchFieldError nosuchfielderror) { }
                    $SwitchMap$android$text$TextDirectionHeuristics$TriState[TriState.FALSE.ordinal()] = 2;
_L2:
                    return;
                    nosuchfielderror1;
                    if(true) goto _L2; else goto _L1
_L1:
                }
            }

            _cls1..SwitchMap.android.text.TextDirectionHeuristics.TriState[TextDirectionHeuristics.isRtlText(Character.getDirectionality(ac[k])).ordinal()];
            JVM INSTR tableswitch 1 2: default 56
        //                       1 62
        //                       2 83;
               goto _L3 _L4 _L5
_L3:
            k++;
              goto _L6
_L4:
            if(!mLookForRtl) goto _L8; else goto _L7
_L7:
            TriState tristate = TriState.TRUE;
_L11:
            return tristate;
_L8:
            flag = true;
              goto _L3
_L5:
            if(mLookForRtl) goto _L10; else goto _L9
_L9:
            tristate = TriState.FALSE;
              goto _L11
_L10:
            flag = true;
              goto _L3
_L2:
            if(flag) {
                if(mLookForRtl)
                    tristate = TriState.FALSE;
                else
                    tristate = TriState.TRUE;
            } else {
                tristate = TriState.UNKNOWN;
            }
              goto _L11
        }

        public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
        public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
        private final boolean mLookForRtl;


        private AnyStrong(boolean flag) {
            mLookForRtl = flag;
        }
    }

    private static class FirstStrong
        implements TextDirectionAlgorithm {

        public TriState checkRtl(char ac[], int i, int j) {
            TriState tristate = TriState.UNKNOWN;
            int k = i;
            for(int l = i + j; k < l && tristate == TriState.UNKNOWN; k++)
                tristate = TextDirectionHeuristics.isRtlTextOrFormat(Character.getDirectionality(ac[k]));

            return tristate;
        }

        public static final FirstStrong INSTANCE = new FirstStrong();


        private FirstStrong() {
        }
    }

    private static interface TextDirectionAlgorithm {

        public abstract TriState checkRtl(char ac[], int i, int j);
    }

    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {

        protected boolean defaultIsRtl() {
            return mDefaultIsRtl;
        }

        private final boolean mDefaultIsRtl;

        private TextDirectionHeuristicInternal(TextDirectionAlgorithm textdirectionalgorithm, boolean flag) {
            super(textdirectionalgorithm);
            mDefaultIsRtl = flag;
        }

    }

    private static abstract class TextDirectionHeuristicImpl
        implements TextDirectionHeuristic {

        private boolean doCheck(char ac[], int i, int j) {
            _cls1..SwitchMap.android.text.TextDirectionHeuristics.TriState[mAlgorithm.checkRtl(ac, i, j).ordinal()];
            JVM INSTR tableswitch 1 2: default 40
        //                       1 49
        //                       2 55;
               goto _L1 _L2 _L3
_L1:
            boolean flag = defaultIsRtl();
_L5:
            return flag;
_L2:
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            flag = false;
            if(true) goto _L5; else goto _L4
_L4:
        }

        protected abstract boolean defaultIsRtl();

        public boolean isRtl(char ac[], int i, int j) {
            if(ac == null || i < 0 || j < 0 || ac.length - j < i)
                throw new IllegalArgumentException();
            boolean flag;
            if(mAlgorithm == null)
                flag = defaultIsRtl();
            else
                flag = doCheck(ac, i, j);
            return flag;
        }

        private final TextDirectionAlgorithm mAlgorithm;

        public TextDirectionHeuristicImpl(TextDirectionAlgorithm textdirectionalgorithm) {
            mAlgorithm = textdirectionalgorithm;
        }
    }

    private static final class TriState extends Enum {

        public static TriState valueOf(String s) {
            return (TriState)Enum.valueOf(android/text/TextDirectionHeuristics$TriState, s);
        }

        public static TriState[] values() {
            return (TriState[])$VALUES.clone();
        }

        private static final TriState $VALUES[];
        public static final TriState FALSE;
        public static final TriState TRUE;
        public static final TriState UNKNOWN;

        static  {
            TRUE = new TriState("TRUE", 0);
            FALSE = new TriState("FALSE", 1);
            UNKNOWN = new TriState("UNKNOWN", 2);
            TriState atristate[] = new TriState[3];
            atristate[0] = TRUE;
            atristate[1] = FALSE;
            atristate[2] = UNKNOWN;
            $VALUES = atristate;
        }

        private TriState(String s, int i) {
            super(s, i);
        }
    }


    public TextDirectionHeuristics() {
    }

    private static TriState isRtlText(int i) {
        i;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 34
    //                   1 41
    //                   2 41;
           goto _L1 _L2 _L3 _L3
_L1:
        TriState tristate = TriState.UNKNOWN;
_L5:
        return tristate;
_L2:
        tristate = TriState.FALSE;
        continue; /* Loop/switch isn't completed */
_L3:
        tristate = TriState.TRUE;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private static TriState isRtlTextOrFormat(int i) {
        i;
        JVM INSTR lookupswitch 7: default 68
    //                   0: 74
    //                   1: 81
    //                   2: 81
    //                   14: 74
    //                   15: 74
    //                   16: 81
    //                   17: 81;
           goto _L1 _L2 _L3 _L3 _L2 _L2 _L3 _L3
_L1:
        TriState tristate = TriState.UNKNOWN;
_L5:
        return tristate;
_L2:
        tristate = TriState.FALSE;
        continue; /* Loop/switch isn't completed */
_L3:
        tristate = TriState.TRUE;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public static final TextDirectionHeuristic ANYRTL_LTR;
    public static final TextDirectionHeuristic FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristic FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristic LOCALE;
    public static final TextDirectionHeuristic LTR = new TextDirectionHeuristicInternal(null, false, null);
    public static final TextDirectionHeuristic RTL = new TextDirectionHeuristicInternal(null, true, null);

    static  {
        FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false, null);
        FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true, null);
        ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false, null);
        LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    }


}
