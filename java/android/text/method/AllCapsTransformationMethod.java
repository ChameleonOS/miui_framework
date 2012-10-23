// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.util.Locale;

// Referenced classes of package android.text.method:
//            TransformationMethod2

public class AllCapsTransformationMethod
    implements TransformationMethod2 {

    public AllCapsTransformationMethod(Context context) {
        mLocale = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charsequence, View view) {
        Object obj;
        if(mEnabled) {
            if(charsequence != null)
                obj = charsequence.toString().toUpperCase(mLocale);
            else
                obj = null;
        } else {
            Log.w("AllCapsTransformationMethod", "Caller did not enable length changes; not transforming text");
            obj = charsequence;
        }
        return ((CharSequence) (obj));
    }

    public void onFocusChanged(View view, CharSequence charsequence, boolean flag, int i, Rect rect) {
    }

    public void setLengthChangesAllowed(boolean flag) {
        mEnabled = flag;
    }

    private static final String TAG = "AllCapsTransformationMethod";
    private boolean mEnabled;
    private Locale mLocale;
}
