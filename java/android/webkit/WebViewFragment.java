// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.app.Fragment;
import android.os.Bundle;
import android.view.*;

// Referenced classes of package android.webkit:
//            WebView

public class WebViewFragment extends Fragment {

    public WebViewFragment() {
    }

    public WebView getWebView() {
        WebView webview;
        if(mIsWebViewAvailable)
            webview = mWebView;
        else
            webview = null;
        return webview;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle) {
        if(mWebView != null)
            mWebView.destroy();
        mWebView = new WebView(getActivity());
        mIsWebViewAvailable = true;
        return mWebView;
    }

    public void onDestroy() {
        if(mWebView != null) {
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        mIsWebViewAvailable = false;
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
        mWebView.onPause();
    }

    public void onResume() {
        mWebView.onResume();
        super.onResume();
    }

    private boolean mIsWebViewAvailable;
    private WebView mWebView;
}
