// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;


// Referenced classes of package com.android.internal.telephony.cat:
//            ValueObject, ComprehensionTlvTag

class ItemsIconId extends ValueObject {

    ItemsIconId() {
    }

    ComprehensionTlvTag getTag() {
        return ComprehensionTlvTag.ITEM_ICON_ID_LIST;
    }

    int recordNumbers[];
    boolean selfExplanatory;
}
