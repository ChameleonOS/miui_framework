// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;


public class ConsoleMessage {
    public static final class MessageLevel extends Enum {

        public static MessageLevel valueOf(String s) {
            return (MessageLevel)Enum.valueOf(android/webkit/ConsoleMessage$MessageLevel, s);
        }

        public static MessageLevel[] values() {
            return (MessageLevel[])$VALUES.clone();
        }

        private static final MessageLevel $VALUES[];
        public static final MessageLevel DEBUG;
        public static final MessageLevel ERROR;
        public static final MessageLevel LOG;
        public static final MessageLevel TIP;
        public static final MessageLevel WARNING;

        static  {
            TIP = new MessageLevel("TIP", 0);
            LOG = new MessageLevel("LOG", 1);
            WARNING = new MessageLevel("WARNING", 2);
            ERROR = new MessageLevel("ERROR", 3);
            DEBUG = new MessageLevel("DEBUG", 4);
            MessageLevel amessagelevel[] = new MessageLevel[5];
            amessagelevel[0] = TIP;
            amessagelevel[1] = LOG;
            amessagelevel[2] = WARNING;
            amessagelevel[3] = ERROR;
            amessagelevel[4] = DEBUG;
            $VALUES = amessagelevel;
        }

        private MessageLevel(String s, int i) {
            super(s, i);
        }
    }


    public ConsoleMessage(String s, String s1, int i, MessageLevel messagelevel) {
        mMessage = s;
        mSourceId = s1;
        mLineNumber = i;
        mLevel = messagelevel;
    }

    public int lineNumber() {
        return mLineNumber;
    }

    public String message() {
        return mMessage;
    }

    public MessageLevel messageLevel() {
        return mLevel;
    }

    public String sourceId() {
        return mSourceId;
    }

    private MessageLevel mLevel;
    private int mLineNumber;
    private String mMessage;
    private String mSourceId;
}
