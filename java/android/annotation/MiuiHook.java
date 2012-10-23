// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.annotation;

import java.lang.annotation.Annotation;

public interface MiuiHook
    extends Annotation {
    public static final class MiuiHookType extends Enum {

        public static MiuiHookType valueOf(String s) {
            return (MiuiHookType)Enum.valueOf(android/annotation/MiuiHook$MiuiHookType, s);
        }

        public static MiuiHookType[] values() {
            return (MiuiHookType[])$VALUES.clone();
        }

        private static final MiuiHookType $VALUES[];
        public static final MiuiHookType CHANGE_ACCESS;
        public static final MiuiHookType CHANGE_BASE_CLASS;
        public static final MiuiHookType CHANGE_CODE;
        public static final MiuiHookType CHANGE_CODE_AND_ACCESS;
        public static final MiuiHookType CHANGE_PARAMETER;
        public static final MiuiHookType CHANGE_PARAMETER_AND_ACCESS;
        public static final MiuiHookType NEW_CLASS;
        public static final MiuiHookType NEW_FIELD;
        public static final MiuiHookType NEW_METHOD;

        static  {
            CHANGE_ACCESS = new MiuiHookType("CHANGE_ACCESS", 0);
            CHANGE_CODE = new MiuiHookType("CHANGE_CODE", 1);
            CHANGE_CODE_AND_ACCESS = new MiuiHookType("CHANGE_CODE_AND_ACCESS", 2);
            CHANGE_PARAMETER = new MiuiHookType("CHANGE_PARAMETER", 3);
            CHANGE_PARAMETER_AND_ACCESS = new MiuiHookType("CHANGE_PARAMETER_AND_ACCESS", 4);
            CHANGE_BASE_CLASS = new MiuiHookType("CHANGE_BASE_CLASS", 5);
            NEW_CLASS = new MiuiHookType("NEW_CLASS", 6);
            NEW_FIELD = new MiuiHookType("NEW_FIELD", 7);
            NEW_METHOD = new MiuiHookType("NEW_METHOD", 8);
            MiuiHookType amiuihooktype[] = new MiuiHookType[9];
            amiuihooktype[0] = CHANGE_ACCESS;
            amiuihooktype[1] = CHANGE_CODE;
            amiuihooktype[2] = CHANGE_CODE_AND_ACCESS;
            amiuihooktype[3] = CHANGE_PARAMETER;
            amiuihooktype[4] = CHANGE_PARAMETER_AND_ACCESS;
            amiuihooktype[5] = CHANGE_BASE_CLASS;
            amiuihooktype[6] = NEW_CLASS;
            amiuihooktype[7] = NEW_FIELD;
            amiuihooktype[8] = NEW_METHOD;
            $VALUES = amiuihooktype;
        }

        private MiuiHookType(String s, int i) {
            super(s, i);
        }
    }


    public abstract MiuiHookType value();
}
