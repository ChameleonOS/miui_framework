// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.ContentResolver;
import android.graphics.Bitmap;

// Referenced classes of package android.webkit:
//            WebViewFactory, WebViewFactoryProvider, MustOverrideException

public class WebIconDatabase {
    public static interface IconListener {

        public abstract void onReceivedIcon(String s, Bitmap bitmap);
    }


    protected WebIconDatabase() {
    }

    public static WebIconDatabase getInstance() {
        return WebViewFactory.getProvider().getWebIconDatabase();
    }

    public void bulkRequestIconForPageUrl(ContentResolver contentresolver, String s, IconListener iconlistener) {
        throw new MustOverrideException();
    }

    public void close() {
        throw new MustOverrideException();
    }

    public void open(String s) {
        throw new MustOverrideException();
    }

    public void releaseIconForPageUrl(String s) {
        throw new MustOverrideException();
    }

    public void removeAllIcons() {
        throw new MustOverrideException();
    }

    public void requestIconForPageUrl(String s, IconListener iconlistener) {
        throw new MustOverrideException();
    }

    public void retainIconForPageUrl(String s) {
        throw new MustOverrideException();
    }
}
