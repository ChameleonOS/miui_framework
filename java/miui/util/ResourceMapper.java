// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

public class ResourceMapper {

    public ResourceMapper() {
    }

    public static int resolveReference(Context context, int i) {
        TypedValue typedvalue = new TypedValue();
        context.getResources().getValue(i, typedvalue, true);
        if(typedvalue.resourceId != 0)
            i = typedvalue.resourceId;
        return i;
    }
}
