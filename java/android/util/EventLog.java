// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.io.*;
import java.nio.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package android.util:
//            Log

public class EventLog {
    public static final class Event {

        private Object decodeObject() {
            byte byte0 = mBuffer.get();
            byte0;
            JVM INSTR tableswitch 0 3: default 40
        //                       0 67
        //                       1 80
        //                       2 94
        //                       3 166;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown entry type: ").append(byte0).toString());
_L2:
            Object obj = Integer.valueOf(mBuffer.getInt());
_L6:
            return obj;
_L3:
            obj = Long.valueOf(mBuffer.getLong());
            continue; /* Loop/switch isn't completed */
_L4:
            try {
                int k = mBuffer.getInt();
                int l = mBuffer.position();
                mBuffer.position(l + k);
                obj = new String(mBuffer.array(), l, k, "UTF-8");
            }
            catch(UnsupportedEncodingException unsupportedencodingexception) {
                Log.wtf("EventLog", "UTF-8 is not supported", unsupportedencodingexception);
                obj = null;
            }
            if(true) goto _L6; else goto _L5
_L5:
            int i = mBuffer.get();
            if(i < 0)
                i += 256;
            obj = ((Object) (new Object[i]));
            int j = 0;
            while(j < i)  {
                obj[j] = decodeObject();
                j++;
            }
            if(true) goto _L6; else goto _L7
_L7:
        }

        /**
         * @deprecated Method getData is deprecated
         */

        public Object getData() {
            Object obj = null;
            this;
            JVM INSTR monitorenter ;
            Object obj1;
            mBuffer.limit(20 + mBuffer.getShort(0));
            mBuffer.position(24);
            obj1 = decodeObject();
            obj = obj1;
_L1:
            this;
            JVM INSTR monitorexit ;
            return obj;
            IllegalArgumentException illegalargumentexception;
            illegalargumentexception;
            Log.wtf("EventLog", (new StringBuilder()).append("Illegal entry payload: tag=").append(getTag()).toString(), illegalargumentexception);
              goto _L1
            Exception exception;
            exception;
            throw exception;
            BufferUnderflowException bufferunderflowexception;
            bufferunderflowexception;
            Log.wtf("EventLog", (new StringBuilder()).append("Truncated entry payload: tag=").append(getTag()).toString(), bufferunderflowexception);
              goto _L1
        }

        public int getProcessId() {
            return mBuffer.getInt(4);
        }

        public int getTag() {
            return mBuffer.getInt(20);
        }

        public int getThreadId() {
            return mBuffer.getInt(8);
        }

        public long getTimeNanos() {
            return 0x3b9aca00L * (long)mBuffer.getInt(12) + (long)mBuffer.getInt(16);
        }

        private static final int DATA_START = 24;
        private static final byte INT_TYPE = 0;
        private static final int LENGTH_OFFSET = 0;
        private static final byte LIST_TYPE = 3;
        private static final byte LONG_TYPE = 1;
        private static final int NANOSECONDS_OFFSET = 16;
        private static final int PAYLOAD_START = 20;
        private static final int PROCESS_OFFSET = 4;
        private static final int SECONDS_OFFSET = 12;
        private static final byte STRING_TYPE = 2;
        private static final int TAG_OFFSET = 20;
        private static final int THREAD_OFFSET = 8;
        private final ByteBuffer 