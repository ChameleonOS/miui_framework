// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.android.internal.logging:
//            AndroidHandler

public class AndroidConfig {

    public AndroidConfig() {
        Logger logger = Logger.getLogger("");
        logger.addHandler(new AndroidHandler());
        logger.setLevel(Level.INFO);
        Logger.getLogger("org.apache").setLevel(Level.WARNING);
_L1:
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
          goto _L1
    }
}
