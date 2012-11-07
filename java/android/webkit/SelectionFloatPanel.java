// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;
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

            public void onClick(View view3) {
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
            android.view.View.OnClickListener onclicklistener1 = new android.view.View.OnClickListener() {

                public void onClick(View view3) {
                    wvclassic.selectAll();
                    instance.setVisibility(0);
                }

                final SelectionFloatPanel val$instance;
                final WebViewClassic val$wvclassic;

             {
                wvclassic = webviewclassic;
                instance = selectionfloatpanel;
                super();
            }
            };
            View view1 = instance.findViewById(0x60b001a);
            if(view1 != null) {
                view1.setOnClickListener(onclicklistener1);
                android.view.View.OnClickListener onclicklistener2 = new android.view.View.OnClickListener() {

                    public void onClick(View view3) {
                        wvclassic.webSearchText();
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
                View view2 = instance.findViewById(0x60b008a);
                if(view2 != null) {
                    view2.setOnClickListener(onclicklistener2);
                    ((ViewGroup)(ViewGroup)wvclassic.getWebView().getRootView()).addView(instance);
                } else {
                    Log.e("showFloat", "no webSearch view.");
                    instance = null;
                }
            } else {
                Log.e("showFloat", "no selectAll view.");
                instance = null;
            }
        } else {
            Log.e("showFloat", "no copy view.");
            instance = null;
        }
        return instance;
    }

    protected void onMeasure(int i, int j) {
        super.onMeasure(i, j);
        sHeight = getMeasuredHeight();
        sWidth = getMeasuredWidth();
    }

    public void showAt(int i, int j) {
        setVisibility(0);
        setX(i);
        setY(j);
        requestLayout();
    }

    public int viewHeight() {
        return sHeight;
    }

    public int viewWidth() {
        return sWidth;
    }

    private static int sHeight = 0;
    private static int sWidth = 0;

}
