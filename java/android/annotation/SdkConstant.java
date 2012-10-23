// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.annotation;

import java.lang.annotation.Annotation;

public interface SdkConstant
    extends Annotation {
    public static final class SdkConstantType extends Enum {

        public static SdkConstantType valueOf(String s) {
            return (SdkConstantType)Enum.valueOf(android/annotation/SdkConstant$SdkConstantType, s);
        }

        public static SdkConstantType[] values() {
            return (SdkConstantType[])$VALUES.clone();
        }

        private static final SdkConstantType $VALUES[];
        public static final SdkConstantType ACTIVITY_INTENT_ACTION;
        public static final SdkConstantType BROADCAST_INTENT_ACTION;
        public static final SdkConstantType FEATURE;
        public static final SdkConstantType INTENT_CATEGORY;
        public static final SdkConstantType SERVICE_ACTION;

        static  {
            ACTIVITY_INTENT_ACTION = new SdkConstantType("ACTIVITY_INTENT_ACTION", 0);
            BROADCAST_INTENT_ACTION = new SdkConstantType("BROADCAST_INTENT_ACTION", 1);
            SERVICE_ACTION = new SdkConstantType("SERVICE_ACTION", 2);
            INTENT_CATEGORY = new SdkConstantType("INTENT_CATEGORY", 3);
            FEATURE = new SdkConstantType("FEATURE", 4);
            SdkConstantType asdkconstanttype[] = new SdkConstantType[5];
            asdkconstanttype[0] = ACTIVITY_INTENT_ACTION;
            asdkconstanttype[1] = BROADCAST_INTENT_ACTION;
            asdkconstanttype[2] = SERVICE_ACTION;
            asdkconstanttype[3] = INTENT_CATEGORY;
            asdkconstanttype[4] = FEATURE;
            $VALUES = asdkconstanttype;
        }

        private SdkConstantType(String s, int i) {
            super(s, i);
        }
    }


    public abstract SdkConstantType value();
}
