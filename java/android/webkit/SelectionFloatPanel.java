// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package android.webkit:
//            WebViewClassic, WebView

public class SelectionFloatPanel extends FrameLayout {

    public SelectionFloatPanel(Context context) {
        super(context);
    }

    public SelectionFloatPanel(Context context, AttributeSet attributeset) {
        super(context, attributeset);
    }

    public static SelectionFloatPanel getInstance(Context context, final WebViewClassic wvclassic) {
        final SelectionFloatPanel instance = (SelectionFloatPanel)LayoutInflater.from(context).inflate(0x6030037, null);
        android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

            public void onClick(View view1) {
                wvclassic.copySelection();
                wvclassic.selectionDone();
                instance.setVisibility(4);
            }

            final SelectionFloatPanel val$instance;
            final WebViewClassic val$wvclassic;

             {
                wvclassic = webviewclassic;
                instance = selectionfloatpanel;
                super();
            }
        };
        View view = instance.findViewById(0x60b0015);
        if(view != null) {
            view.setOnClickListener(onclicklistener);
            wvclassic.getWebView().addView(instance);
            instance.setVisibility(0);
        } else {
            Log.e("showFloat", "no view");
            instance = null;
        }
        return instance;
    }

    public void showAt(int i, int j) {
        setVisibility(0);
        setX(i);
        setY(j);
        requestLayout();
    }
}
