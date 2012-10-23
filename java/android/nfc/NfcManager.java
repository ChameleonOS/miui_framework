// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc;

import android.content.Context;

// Referenced classes of package android.nfc:
//            NfcAdapter

public final class NfcManager {

    public NfcManager(Context context) {
        Context context1;
        context1 = context.getApplicationContext();
        if(context1 == null)
            throw new IllegalArgumentException("context not associated with any application (using a mock context?)");
        NfcAdapter nfcadapter1 = NfcAdapter.getNfcAdapter(context1);
        NfcAdapter nfcadapter = nfcadapter1;
_L2:
        mAdapter = nfcadapter;
        return;
        UnsupportedOperationException unsupportedoperationexception;
        unsupportedoperationexception;
        nfcadapter = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public NfcAdapter getDefaultAdapter() {
        return mAdapter;
    }

    private final NfcAdapter mAdapter;
}
