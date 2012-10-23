// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.view.View;

// Referenced classes of package android.text.style:
//            ClickableSpan

public class URLSpan extends ClickableSpan
    implements ParcelableSpan {

    public URLSpan(Parcel parcel) {
        mURL = parcel.readString();
    }

    public URLSpan(String s) {
        mURL = s;
    }

    public int describeContents() {
        return 0;
    }

    public int getSpanTypeId() {
        return 11;
    }

    public String getURL() {
        return mURL;
    }

    public void onClick(View view) {
        Uri uri = Uri.parse(getURL());
        Context context = view.getContext();
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.putExtra("com.android.browser.application_id", context.getPackageName());
        context.startActivity(intent);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mURL);
    }

    private final String mURL;
}
