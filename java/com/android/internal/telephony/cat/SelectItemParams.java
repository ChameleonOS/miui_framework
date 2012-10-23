// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.android.internal.telephony.cat:
//            CommandParams, Menu, Item, CommandDetails

class SelectItemParams extends CommandParams {

    SelectItemParams(CommandDetails commanddetails, Menu menu1, boolean flag) {
        super(commanddetails);
        menu = null;
        loadTitleIcon = false;
        menu = menu1;
        loadTitleIcon = flag;
    }

    boolean setIcon(Bitmap bitmap) {
        if(bitmap == null || menu == null)
            break MISSING_BLOCK_LABEL_90;
        if(!loadTitleIcon || menu.titleIcon != null) goto _L2; else goto _L1
_L1:
        menu.titleIcon = bitmap;
_L4:
        boolean flag = true;
_L7:
        return flag;
_L2:
        Iterator iterator = menu.items.iterator();
_L6:
        if(!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        Item item = (Item)iterator.next();
        if(item.icon != null) goto _L6; else goto _L5
_L5:
        item.icon = bitmap;
          goto _L4
        flag = false;
          goto _L7
    }

    boolean loadTitleIcon;
    Menu menu;
}
