// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.os.SystemProperties;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.TimeZone;

// Referenced classes of package com.android.internal.telephony.cat:
//            ResponseData, CatLog

class DTTZResponseData extends ResponseData {

    public DTTZResponseData(Calendar calendar1) {
        calendar = calendar1;
    }

    private byte byteToBCD(int i) {
        byte byte0;
        if(i < 0 && i > 99) {
            CatLog.d(this, (new StringBuilder()).append("Err: byteToBCD conversion Value is ").append(i).append(" Value has to be between 0 and 99").toString());
            byte0 = 0;
        } else {
            byte0 = (byte)(i / 10 | i % 10 << 4);
        }
        return byte0;
    }

    private byte getTZOffSetByte(long l) {
        int i = 1;
        int j;
        long l1;
        byte byte0;
        if(l < 0L)
            j = i;
        else
            j = 0;
        l1 = l / 0xdbba0L;
        if(j != 0)
            i = -1;
        byte0 = byteToBCD((int)(l1 * (long)i));
        if(j != 0) {
            byte0 |= 8;
            byte _tmp = byte0;
        } else {
            byte _tmp1 = byte0;
        }
        return byte0;
    }

    public void format(ByteArrayOutputStream bytearrayoutputstream) {
        if(bytearrayoutputstream != null) {
            bytearrayoutputstream.write(0x80 | AppInterface.CommandType.PROVIDE_LOCAL_INFORMATION.value());
            byte abyte0[] = new byte[8];
            abyte0[0] = 7;
            if(calendar == null)
                calendar = Calendar.getInstance();
            abyte0[1] = byteToBCD(calendar.get(1) % 100);
            abyte0[2] = byteToBCD(1 + calendar.get(2));
            abyte0[3] = byteToBCD(calendar.get(5));
            abyte0[4] = byteToBCD(calendar.get(11));
            abyte0[5] = byteToBCD(calendar.get(12));
            abyte0[6] = byteToBCD(calendar.get(13));
            String s = SystemProperties.get("persist.sys.timezone", "");
            int i;
            int j;
            if(TextUtils.isEmpty(s)) {
                abyte0[7] = -1;
            } else {
                TimeZone timezone = TimeZone.getTimeZone(s);
                abyte0[7] = getTZOffSetByte(timezone.getRawOffset() + timezone.getDSTSavings());
            }
            i = abyte0.length;
            j = 0;
            while(j < i)  {
                bytearrayoutputstream.write(abyte0[j]);
                j++;
            }
        }
    }

    private Calendar calendar;
}
