// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.miui.internal.app;

import android.content.Context;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.CheckBox;
import java.io.*;
import java.util.Calendar;

public class ShutdownAlarm {

    public ShutdownAlarm() {
    }

    public static CheckBox buildShutdownAlarmCheckBox(Context context) {
        int i;
        StringBuilder stringbuilder;
        long l = 1000L * readWakeAlarm();
        i = getWakeAlarmDeltaDays(l);
        boolean flag;
        CheckBox checkbox;
        Calendar calendar;
        Object aobj[];
        if(i == 0 || i == 1)
            flag = true;
        else
            flag = false;
        checkbox = null;
        if(!flag) goto _L2; else goto _L1
_L1:
        checkbox = new CheckBox(context);
        checkbox.setChecked(true);
        stringbuilder = new StringBuilder();
        if(i != 0) goto _L4; else goto _L3
_L3:
        stringbuilder.append(context.getString(0x60c01d1));
_L6:
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        stringbuilder.append(formatTime(context, calendar));
        aobj = new Object[1];
        aobj[0] = stringbuilder.toString();
        checkbox.setText(context.getString(0x60c01f5, aobj));
_L2:
        return checkbox;
_L4:
        if(i == 1)
            stringbuilder.append(context.getString(0x60c01a9));
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static String formatTime(Context context, Calendar calendar) {
        String s;
        String s1;
        if(DateFormat.is24HourFormat(context))
            s = "kk:mm";
        else
            s = context.getString(0x60c01f6);
        if(calendar == null)
            s1 = "";
        else
            s1 = (String)DateFormat.format(s, calendar);
        return s1;
    }

    private static int getWakeAlarmDeltaDays(long l) {
        long l1 = l - System.currentTimeMillis();
        int i = -1;
        if(l1 > 0L && l1 < 0xa4cb800L) {
            Calendar calendar = Calendar.getInstance();
            int j = calendar.get(7);
            calendar.setTimeInMillis(l);
            i = (7 + (calendar.get(7) - j)) % 7;
            Log.d("ShutdownAlarm", (new StringBuilder()).append("wake alarm days: ").append(i).toString());
        }
        return i;
    }

    public static long readWakeAlarm() {
        long l;
        BufferedReader bufferedreader;
        l = 0L;
        bufferedreader = null;
        BufferedReader bufferedreader1 = new BufferedReader(new FileReader("/sys/class/rtc/rtc0/wakealarm"));
        int i = Integer.parseInt(bufferedreader1.readLine());
        FileNotFoundException filenotfoundexception;
        Exception exception;
        NumberFormatException numberformatexception;
        IOException ioexception2;
        l = i;
        IOException ioexception;
        IOException ioexception1;
        String s;
        String s1;
        if(bufferedreader1 != null)
            try {
                bufferedreader1.close();
            }
            catch(IOException ioexception3) {
                Log.e("ShutdownAlarm", "read wake alarm error", ioexception3);
            }
        return l;
        filenotfoundexception;
_L7:
        Log.e("ShutdownAlarm", "read wake alarm error", filenotfoundexception);
        if(bufferedreader == null)
            break MISSING_BLOCK_LABEL_42;
        bufferedreader.close();
        break MISSING_BLOCK_LABEL_42;
        ioexception1;
        s = "ShutdownAlarm";
        s1 = "read wake alarm error";
_L1:
        Log.e(s, s1, ioexception1);
        break MISSING_BLOCK_LABEL_42;
        numberformatexception;
_L5:
        Log.e("ShutdownAlarm", "read wake alarm error", numberformatexception);
        if(bufferedreader == null)
            break MISSING_BLOCK_LABEL_42;
        try {
            bufferedreader.close();
            break MISSING_BLOCK_LABEL_42;
        }
        // Misplaced declaration of an exception variable
        catch(IOException ioexception1) {
            s = "ShutdownAlarm";
            s1 = "read wake alarm error";
        }
          goto _L1
        ioexception2;
_L4:
        Log.e("ShutdownAlarm", "read wake alarm error", ioexception2);
        if(bufferedreader == null)
            break MISSING_BLOCK_LABEL_42;
        try {
            bufferedreader.close();
            break MISSING_BLOCK_LABEL_42;
        }
        // Misplaced declaration of an exception variable
        catch(IOException ioexception1) {
            s = "ShutdownAlarm";
            s1 = "read wake alarm error";
        }
          goto _L1
        exception;
_L3:
        if(bufferedreader != null)
            try {
                bufferedreader.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception) {
                Log.e("ShutdownAlarm", "read wake alarm error", ioexception);
            }
        throw exception;
        exception;
        bufferedreader = bufferedreader1;
        if(true) goto _L3; else goto _L2
_L2:
        ioexception2;
        bufferedreader = bufferedreader1;
          goto _L4
        numberformatexception;
        bufferedreader = bufferedreader1;
          goto _L5
        filenotfoundexception;
        bufferedreader = bufferedreader1;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public static void writeWakeAlarm(long l) {
        BufferedWriter bufferedwriter = null;
        BufferedWriter bufferedwriter1 = new BufferedWriter(new FileWriter("/sys/class/rtc/rtc0/wakealarm"));
        bufferedwriter1.write(String.valueOf(l));
        if(bufferedwriter1 == null)
            break MISSING_BLOCK_LABEL_35;
        bufferedwriter1.close();
_L1:
        return;
        IOException ioexception;
        ioexception;
_L3:
        Log.e("ShutdownAlarm", "write wake alarm error", ioexception);
        if(bufferedwriter != null)
            try {
                bufferedwriter.close();
            }
            catch(IOException ioexception2) {
                Log.e("ShutdownAlarm", "write wake alarm error", ioexception2);
            }
          goto _L1
        Exception exception;
        exception;
_L2:
        if(bufferedwriter != null)
            try {
                bufferedwriter.close();
            }
            catch(IOException ioexception1) {
                Log.e("ShutdownAlarm", "write wake alarm error", ioexception1);
            }
        throw exception;
        IOException ioexception3;
        ioexception3;
        Log.e("ShutdownAlarm", "write wake alarm error", ioexception3);
          goto _L1
        exception;
        bufferedwriter = bufferedwriter1;
          goto _L2
        ioexception;
        bufferedwriter = bufferedwriter1;
          goto _L3
    }

    private static final String TAG = "ShutdownAlarm";
    private static final String WAKEALARM_PATH = "/sys/class/rtc/rtc0/wakealarm";
}
