// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.logging;

import android.util.Log;
import dalvik.system.DalvikLogHandler;
import dalvik.system.DalvikLogging;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;

public class AndroidHandler extends Handler
    implements DalvikLogHandler {

    public AndroidHandler() {
        setFormatter(THE_FORMATTER);
    }

    static int getAndroidLevel(Level level) {
        int i = level.intValue();
        byte byte0;
        if(i >= 1000)
            byte0 = 6;
        else
        if(i >= 900)
            byte0 = 5;
        else
        if(i >= 800)
            byte0 = 4;
        else
            byte0 = 3;
        return byte0;
    }

    public void close() {
    }

    public void flush() {
    }

    public void publish(LogRecord logrecord) {
        int i = getAndroidLevel(logrecord.getLevel());
        String s = DalvikLogging.loggerNameToTag(logrecord.getLoggerName());
        if(Log.isLoggable(s, i))
            try {
                Log.println(i, s, getFormatter().format(logrecord));
            }
            catch(RuntimeException runtimeexception) {
                Log.e("AndroidHandler", "Error logging message.", runtimeexception);
            }
    }

    public void publish(Logger logger, String s, Level level, String s1) {
        int i = getAndroidLevel(level);
        if(Log.isLoggable(s, i))
            try {
                Log.println(i, s, s1);
            }
            catch(RuntimeException runtimeexception) {
                Log.e("AndroidHandler", "Error logging message.", runtimeexception);
            }
    }

    private static final Formatter THE_FORMATTER = new Formatter() {

        public String format(LogRecord logrecord) {
            Throwable throwable = logrecord.getThrown();
            String s;
            if(throwable != null) {
                StringWriter stringwriter = new StringWriter();
                PrintWriter printwriter = new PrintWriter(stringwriter);
                stringwriter.write(logrecord.getMessage());
                stringwriter.write("\n");
                throwable.printStackTrace(printwriter);
                printwriter.flush();
                s = stringwriter.toString();
            } else {
                s = logrecord.getMessage();
            }
            return s;
        }

    };

}
