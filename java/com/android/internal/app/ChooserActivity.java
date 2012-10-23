// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.app;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

// Referenced classes of package com.android.internal.app:
//            ResolverActivity

public class ChooserActivity extends ResolverActivity {

    public ChooserActivity() {
    }

    protected void onCreate(Bundle bundle) {
        Intent intent;
        android.os.Parcelable parcelable;
        intent = getIntent();
        parcelable = intent.getParcelableExtra("android.intent.extra.INTENT");
        if(parcelable instanceof Intent) goto _L2; else goto _L1
_L1:
        Log.w("ChooseActivity", (new StringBuilder()).append("Target is not an intent: ").append(parcelable).toString());
        finish();
_L4:
        return;
_L2:
        Intent intent1 = (Intent)parcelable;
        CharSequence charsequence = intent.getCharSequenceExtra("android.intent.extra.TITLE");
        if(charsequence == null)
            charsequence = getResources().getText(0x10403cc);
        android.os.Parcelable aparcelable[] = intent.getParcelableArrayExtra("android.intent.extra.INITIAL_INTENTS");
        Intent aintent[] = null;
        if(aparcelable != null) {
            aintent = new Intent[aparcelable.length];
            int i = 0;
            do {
                if(i >= aparcelable.length)
                    break;
                if(!(aparcelable[i] instanceof Intent)) {
                    Log.w("ChooseActivity", (new StringBuilder()).append("Initial intent #").append(i).append(" not an Intent: ").append(aparcelable[i]).toString());
                    finish();
                    continue; /* Loop/switch isn't completed */
                }
                aintent[i] = (Intent)aparcelable[i];
                i++;
            } while(true);
        }
        super.onCreate(bundle, intent1, charsequence, aintent, null, false);
        if(true) goto _L4; else goto _L3
_L3:
    }
}
