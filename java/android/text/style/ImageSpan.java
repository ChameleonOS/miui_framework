// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import java.io.InputStream;

// Referenced classes of package android.text.style:
//            DynamicDrawableSpan

public class ImageSpan extends DynamicDrawableSpan {

    public ImageSpan(Context context, int i) {
        this(context, i, 0);
    }

    public ImageSpan(Context context, int i, int j) {
        super(j);
        mContext = context;
        mResourceId = i;
    }

    public ImageSpan(Context context, Bitmap bitmap) {
        this(context, bitmap, 0);
    }

    public ImageSpan(Context context, Bitmap bitmap, int i) {
        super(i);
        mContext = context;
        BitmapDrawable bitmapdrawable;
        int j;
        int k;
        Drawable drawable;
        if(context != null)
            bitmapdrawable = new BitmapDrawable(context.getResources(), bitmap);
        else
            bitmapdrawable = new BitmapDrawable(bitmap);
        mDrawable = bitmapdrawable;
        j = mDrawable.getIntrinsicWidth();
        k = mDrawable.getIntrinsicHeight();
        drawable = mDrawable;
        if(j <= 0)
            j = 0;
        if(k <= 0)
            k = 0;
        drawable.setBounds(0, 0, j, k);
    }

    public ImageSpan(Context context, Uri uri) {
        this(context, uri, 0);
    }

    public ImageSpan(Context context, Uri uri, int i) {
        super(i);
        mContext = context;
        mContentUri = uri;
        mSource = uri.toString();
    }

    public ImageSpan(Bitmap bitmap) {
        this(((Context) (null)), bitmap, 0);
    }

    public ImageSpan(Bitmap bitmap, int i) {
        this(((Context) (null)), bitmap, i);
    }

    public ImageSpan(Drawable drawable) {
        this(drawable, 0);
    }

    public ImageSpan(Drawable drawable, int i) {
        super(i);
        mDrawable = drawable;
    }

    public ImageSpan(Drawable drawable, String s) {
        this(drawable, s, 0);
    }

    public ImageSpan(Drawable drawable, String s, int i) {
        super(i);
        mDrawable = drawable;
        mSource = s;
    }

    public Drawable getDrawable() {
        Object obj = null;
        if(mDrawable == null) goto _L2; else goto _L1
_L1:
        obj = mDrawable;
_L5:
        return ((Drawable) (obj));
_L2:
        if(mContentUri == null) goto _L4; else goto _L3
_L3:
        InputStream inputstream;
        BitmapDrawable bitmapdrawable;
        inputstream = mContext.getContentResolver().openInputStream(mContentUri);
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream);
        bitmapdrawable = new BitmapDrawable(mContext.getResources(), bitmap);
        bitmapdrawable.setBounds(0, 0, bitmapdrawable.getIntrinsicWidth(), bitmapdrawable.getIntrinsicHeight());
        inputstream.close();
        obj = bitmapdrawable;
          goto _L5
        Exception exception1;
        exception1;
_L6:
        Log.e("sms", (new StringBuilder()).append("Failed to loaded content ").append(mContentUri).toString(), exception1);
          goto _L5
_L4:
        try {
            obj = mContext.getResources().getDrawable(mResourceId);
            ((Drawable) (obj)).setBounds(0, 0, ((Drawable) (obj)).getIntrinsicWidth(), ((Drawable) (obj)).getIntrinsicHeight());
        }
        catch(Exception exception) {
            Log.e("sms", (new StringBuilder()).append("Unable to find resource: ").append(mResourceId).toString());
        }
          goto _L5
        exception1;
        obj = bitmapdrawable;
          goto _L6
    }

    public String getSource() {
        return mSource;
    }

    private Uri mContentUri;
    private Context mContext;
    private Drawable mDrawable;
    private int mResourceId;
    private String mSource;
}
