// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import libcore.util.ZoneInfoDB;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.util:
//            Log

public class TimeUtils {

    public TimeUtils() {
    }

    private static int accumField(int i, int j, boolean flag, int k) {
        int l;
        if(i > 99 || flag && k >= 3)
            l = j + 3;
        else
        if(i > 9 || flag && k >= 2)
            l = j + 2;
        else
        if(flag || i > 0)
            l = j + 1;
        else
            l = 0;
        return l;
    }

    public static void formatDuration(long l, long l1, PrintWriter printwriter) {
        if(l == 0L)
            printwriter.print("--");
        else
            formatDuration(l - l1, printwriter, 0);
    }

    public static void formatDuration(long l, PrintWriter printwriter) {
        formatDuration(l, printwriter, 0);
    }

    public static void formatDuration(long l, PrintWriter printwriter, int i) {
        Object obj = sFormatSync;
        obj;
        JVM INSTR monitorenter ;
        int j = formatDurationLocked(l, i);
        printwriter.print(new String(sFormatStr, 0, j));
        return;
    }

    public static void formatDuration(long l, StringBuilder stringbuilder) {
        Object obj = sFormatSync;
        obj;
        JVM INSTR monitorenter ;
        int i = formatDurationLocked(l, 0);
        stringbuilder.append(sFormatStr, 0, i);
        return;
    }

    private static int formatDurationLocked(long l, int i) {
        if(sFormatStr.length < i)
            sFormatStr = new char[i];
        char ac[] = sFormatStr;
        int k3;
        if(l == 0L) {
            int i5 = i - 1;
            int j5;
            int k5;
            for(j5 = 0; j5 < i5; j5 = k5) {
                k5 = j5 + 1;
                ac[j5] = ' ';
            }

            ac[j5] = '0';
            k3 = j5 + 1;
        } else {
            char c;
            int j;
            int k;
            int i1;
            int j1;
            int k1;
            int l1;
            if(l > 0L) {
                c = '+';
            } else {
                c = '-';
                l = -l;
            }
            j = (int)(l % 1000L);
            k = (int)Math.floor(l / 1000L);
            i1 = 0;
            j1 = 0;
            k1 = 0;
            if(k > 0x15180) {
                i1 = k / 0x15180;
                k -= 0x15180 * i1;
            }
            if(k > 3600) {
                j1 = k / 3600;
                k -= j1 * 3600;
            }
            if(k > 60) {
                k1 = k / 60;
                k -= k1 * 60;
            }
            l1 = 0;
            if(i != 0) {
                int l3 = accumField(i1, 1, false, 0);
                boolean flag4;
                int i4;
                boolean flag5;
                int j4;
                boolean flag6;
                int k4;
                byte byte4;
                int l4;
                if(l3 > 0)
                    flag4 = true;
                else
                    flag4 = false;
                i4 = l3 + accumField(j1, 1, flag4, 2);
                if(i4 > 0)
                    flag5 = true;
                else
                    flag5 = false;
                j4 = i4 + accumField(k1, 1, flag5, 2);
                if(j4 > 0)
                    flag6 = true;
                else
                    flag6 = false;
                k4 = j4 + accumField(k, 1, flag6, 2);
                if(k4 > 0)
                    byte4 = 3;
                else
                    byte4 = 0;
                for(l4 = k4 + (1 + accumField(j, 2, true, byte4)); l4 < i; l4++) {
                    ac[l1] = ' ';
                    l1++;
                }

            }
            ac[l1] = c;
            int i2 = l1 + 1;
            boolean flag;
            int j2;
            boolean flag1;
            byte byte0;
            int k2;
            boolean flag2;
            byte byte1;
            int l2;
            boolean flag3;
            byte byte2;
            int i3;
            byte byte3;
            int j3;
            if(i != 0)
                flag = true;
            else
                flag = false;
            j2 = printField(ac, i1, 'd', i2, false, 0);
            if(j2 != i2)
                flag1 = true;
            else
                flag1 = false;
            if(flag)
                byte0 = 2;
            else
                byte0 = 0;
            k2 = printField(ac, j1, 'h', j2, flag1, byte0);
            if(k2 != i2)
                flag2 = true;
            else
                flag2 = false;
            if(flag)
                byte1 = 2;
            else
                byte1 = 0;
            l2 = printField(ac, k1, 'm', k2, flag2, byte1);
            if(l2 != i2)
                flag3 = true;
            else
                flag3 = false;
            if(flag)
                byte2 = 2;
            else
                byte2 = 0;
            i3 = printField(ac, k, 's', l2, flag3, byte2);
            if(flag && i3 != i2)
                byte3 = 3;
            else
                byte3 = 0;
            j3 = printField(ac, j, 'm', i3, true, byte3);
            ac[j3] = 's';
            k3 = j3 + 1;
        }
        return k3;
    }

    public static TimeZone getTimeZone(int i, boolean flag, long l, String s) {
        TimeZone timezone;
        Date date;
        TimeZone timezone1;
        String s1;
        int j;
        boolean flag1;
        Iterator iterator;
        timezone = null;
        Resources.getSystem().getXml(0x10f000d);
        date = new Date(l);
        timezone1 = TimeZone.getDefault();
        s1 = timezone1.getID();
        j = timezone1.getOffset(l);
        flag1 = timezone1.inDaylightTime(date);
        iterator = getTimeZones(s).iterator();
_L3:
        TimeZone timezone2;
        if(!iterator.hasNext())
            break MISSING_BLOCK_LABEL_144;
        timezone2 = (TimeZone)iterator.next();
        if(!timezone2.getID().equals(s1) || j != i || flag1 != flag) goto _L2; else goto _L1
_L1:
        return timezone1;
_L2:
        if(timezone == null && timezone2.getOffset(l) == i && timezone2.inDaylightTime(date) == flag)
            timezone = timezone2;
          goto _L3
        timezone1 = timezone;
          goto _L1
    }

    public static String getTimeZoneDatabaseVersion() {
        return ZoneInfoDB.getVersion();
    }

    public static ArrayList getTimeZones(String s) {
        Object obj = sLastLockObj;
        obj;
        JVM INSTR monitorenter ;
        if(s == null) goto _L2; else goto _L1
_L1:
        if(!s.equals(sLastCountry)) goto _L2; else goto _L3
_L3:
        ArrayList arraylist = sLastZones;
        obj;
        JVM INSTR monitorexit ;
          goto _L4
_L2:
        obj;
        JVM INSTR monitorexit ;
        arraylist = new ArrayList();
        if(s == null) goto _L4; else goto _L5
_L5:
        XmlResourceParser xmlresourceparser = Resources.getSystem().getXml(0x10f000d);
        XmlUtils.beginDocument(xmlresourceparser, "timezones");
_L11:
        String s1;
        XmlUtils.nextElement(xmlresourceparser);
        s1 = xmlresourceparser.getName();
        if(s1 == null) goto _L7; else goto _L6
_L6:
        boolean flag = s1.equals("timezone");
        if(flag) goto _L8; else goto _L7
_L7:
        xmlresourceparser.close();
_L9:
        Object obj1 = sLastLockObj;
        obj1;
        JVM INSTR monitorenter ;
        sLastZones = arraylist;
        sLastCountry = s;
        arraylist = sLastZones;
          goto _L4
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L8:
        if(s.equals(xmlresourceparser.getAttributeValue(null, "code")) && xmlresourceparser.next() == 4) {
            TimeZone timezone = TimeZone.getTimeZone(xmlresourceparser.getText());
            if(!timezone.getID().startsWith("GMT"))
                arraylist.add(timezone);
        }
        continue; /* Loop/switch isn't completed */
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        Log.e("TimeUtils", (new StringBuilder()).append("Got xml parser exception getTimeZone('").append(s).append("'): e=").toString(), xmlpullparserexception);
        xmlresourceparser.close();
          goto _L9
        IOException ioexception;
        ioexception;
        Log.e("TimeUtils", (new StringBuilder()).append("Got IO exception getTimeZone('").append(s).append("'): e=").toString(), ioexception);
        xmlresourceparser.close();
          goto _L9
        Exception exception1;
        exception1;
        xmlresourceparser.close();
        throw exception1;
_L4:
        return arraylist;
        if(true) goto _L11; else goto _L10
_L10:
    }

    public static ArrayList getTimeZonesWithUniqueOffsets(String s) {
        Object obj = sLastUniqueLockObj;
        obj;
        JVM INSTR monitorenter ;
        if(s == null) goto _L2; else goto _L1
_L1:
        if(!s.equals(sLastUniqueCountry)) goto _L2; else goto _L3
_L3:
        ArrayList arraylist2 = sLastUniqueZoneOffsets;
        obj;
        JVM INSTR monitorexit ;
          goto _L4
_L2:
        obj;
        JVM INSTR monitorexit ;
        ArrayList arraylist1;
        Iterator iterator;
        ArrayList arraylist = getTimeZones(s);
        arraylist1 = new ArrayList();
        iterator = arraylist.iterator();
_L9:
        if(!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        TimeZone timezone;
        boolean flag;
        int i;
        timezone = (TimeZone)iterator.next();
        flag = false;
        i = 0;
_L7:
        if(i < arraylist1.size()) {
            if(((TimeZone)arraylist1.get(i)).getRawOffset() != timezone.getRawOffset())
                break MISSING_BLOCK_LABEL_137;
            flag = true;
        }
        if(!flag)
            arraylist1.add(timezone);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        i++;
        if(true) goto _L7; else goto _L6
_L6:
        Object obj1 = sLastUniqueLockObj;
        obj1;
        JVM INSTR monitorenter ;
        sLastUniqueZoneOffsets = arraylist1;
        sLastUniqueCountry = s;
        arraylist2 = sLastUniqueZoneOffsets;
_L4:
        return arraylist2;
        if(true) goto _L9; else goto _L8
_L8:
    }

    public static String logTimeOfDay(long l) {
        Calendar calendar = Calendar.getInstance();
        String s;
        if(l >= 0L) {
            calendar.setTimeInMillis(l);
            Object aobj[] = new Object[6];
            aobj[0] = calendar;
            aobj[1] = calendar;
            aobj[2] = calendar;
            aobj[3] = calendar;
            aobj[4] = calendar;
            aobj[5] = calendar;
            s = String.format("%tm-%td %tH:%tM:%tS.%tL", aobj);
        } else {
            s = Long.toString(l);
        }
        return s;
    }

    private static int printField(char ac[], int i, char c, int j, boolean flag, int k) {
        if(flag || i > 0) {
            int l = j;
            if(flag && k >= 3 || i > 99) {
                int k1 = i / 100;
                ac[j] = (char)(k1 + 48);
                j++;
                i -= k1 * 100;
            }
            if(flag && k >= 2 || i > 9 || l != j) {
                int i1 = i / 10;
                ac[j] = (char)(i1 + 48);
                j++;
                i -= i1 * 10;
            }
            ac[j] = (char)(i + 48);
            int j1 = j + 1;
            ac[j1] = c;
            j = j1 + 1;
        }
        return j;
    }

    private static final boolean DBG = false;
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 0x15180;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final String TAG = "TimeUtils";
    private static char sFormatStr[] = new char[24];
    private static final Object sFormatSync = new Object();
    private static String sLastCountry = null;
    private static final Object sLastLockObj = new Object();
    private static String sLastUniqueCountry = null;
    private static final Object sLastUniqueLockObj = new Object();
    private static ArrayList sLastUniqueZoneOffsets = null;
    private static ArrayList sLastZones = null;

}
