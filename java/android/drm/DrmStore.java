// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm;


public class DrmStore {
    public static class RightsStatus {

        public static final int RIGHTS_EXPIRED = 2;
        public static final int RIGHTS_INVALID = 1;
        public static final int RIGHTS_NOT_ACQUIRED = 3;
        public static final int RIGHTS_VALID;

        public RightsStatus() {
        }
    }

    public static class Action {

        static boolean isValid(int i) {
            boolean flag = false;
            i;
            JVM INSTR tableswitch 0 7: default 48
        //                       0 50
        //                       1 50
        //                       2 50
        //                       3 50
        //                       4 50
        //                       5 50
        //                       6 50
        //                       7 50;
               goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2
_L1:
            return flag;
_L2:
            flag = true;
            if(true) goto _L1; else goto _L3
_L3:
        }

        public static final int DEFAULT = 0;
        public static final int DISPLAY = 7;
        public static final int EXECUTE = 6;
        public static final int OUTPUT = 4;
        public static final int PLAY = 1;
        public static final int PREVIEW = 5;
        public static final int RINGTONE = 2;
        public static final int TRANSFER = 3;

        public Action() {
        }
    }

    public static class Playback {

        static boolean isValid(int i) {
            boolean flag = false;
            i;
            JVM INSTR tableswitch 0 3: default 32
        //                       0 34
        //                       1 34
        //                       2 34
        //                       3 34;
               goto _L1 _L2 _L2 _L2 _L2
_L1:
            return flag;
_L2:
            flag = true;
            if(true) goto _L1; else goto _L3
_L3:
        }

        public static final int PAUSE = 2;
        public static final int RESUME = 3;
        public static final int START = 0;
        public static final int STOP = 1;

        public Playback() {
        }
    }

    public static class DrmObjectType {

        public static final int CONTENT = 1;
        public static final int RIGHTS_OBJECT = 2;
        public static final int TRIGGER_OBJECT = 3;
        public static final int UNKNOWN;

        public DrmObjectType() {
        }
    }

    public static interface ConstraintsColumns {

        public static final String EXTENDED_METADATA = "extended_metadata";
        public static final String LICENSE_AVAILABLE_TIME = "license_available_time";
        public static final String LICENSE_EXPIRY_TIME = "license_expiry_time";
        public static final String LICENSE_START_TIME = "license_start_time";
        public static final String MAX_REPEAT_COUNT = "max_repeat_count";
        public static final String REMAINING_REPEAT_COUNT = "remaining_repeat_count";
    }


    public DrmStore() {
    }
}
