// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

// Referenced classes of package android.preference:
//            DialogPreference

public class SeekBarDialogPreference extends DialogPreference {

    public SeekBarDialogPreference(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        setDialogLayoutResource(0x10900a3);
        createActionButtons();
        mMyIcon = getDialogIcon();
        setDialogIcon(null);
    }

    protected static SeekBar getSeekBar(View view) {
        return (SeekBar)view.findViewById(0x1020307);
    }

    public void createActionButtons() {
        setPositiveButtonText(0x104000a);
        setNegativeButtonText(0x1040000);
    }

    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        ImageView imageview = (ImageView)view.findViewById(0x1020006);
        if(mMyIcon != null)
            imageview.setImageDrawable(mMyIcon);
        else
            imageview.setVisibility(8);
    }

    private static final String TAG = "SeekBarDialogPreference";
    private Drawable mMyIcon;
}
