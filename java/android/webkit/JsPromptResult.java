// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;


// Referenced classes of package android.webkit:
//            JsResult

public class JsPromptResult extends JsResult {

    public JsPromptResult(JsResult.ResultReceiver resultreceiver) {
        super(resultreceiver);
    }

    public void confirm(String s) {
        mStringResult = s;
        confirm();
    }

    public String getStringResult() {
        return mStringResult;
    }

    private String mStringResult;
}
