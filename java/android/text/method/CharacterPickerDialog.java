// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.view.*;
import android.widget.*;

public class CharacterPickerDialog extends Dialog
    implements android.widget.AdapterView.OnItemClickListener, android.view.View.OnClickListener {
    private class OptionsAdapter extends BaseAdapter {

        public final int getCount() {
            return mOptions.length();
        }

        public final Object getItem(int i) {
            return String.valueOf(mOptions.charAt(i));
        }

        public final long getItemId(int i) {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            Button button = (Button)mInflater.inflate(0x1090030, null);
            button.setText(String.valueOf(mOptions.charAt(i)));
            button.setOnClickListener(CharacterPickerDialog.this);
            return button;
        }

        final CharacterPickerDialog this$0;

        public OptionsAdapter(Context context) {
            this$0 = CharacterPickerDialog.this;
            super();
        }
    }


    public CharacterPickerDialog(Context context, View view, Editable editable, String s, boolean flag) {
        super(context, 0x1030059);
        mView = view;
        mText = editable;
        mOptions = s;
        mInsert = flag;
        mInflater = LayoutInflater.from(context);
    }

    private void replaceCharacterAndClose(CharSequence charsequence) {
        int i = Selection.getSelectionEnd(mText);
        if(mInsert || i == 0)
            mText.insert(i, charsequence);
        else
            mText.replace(i - 1, i, charsequence);
        dismiss();
    }

    public void onClick(View view) {
        if(view != mCancelButton) goto _L2; else goto _L1
_L1:
        dismiss();
_L4:
        return;
_L2:
        if(view instanceof Button)
            replaceCharacterAndClose(((Button)view).getText());
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        layoutparams.token = mView.getApplicationWindowToken();
        layoutparams.type = 1003;
        layoutparams.flags = 1 | layoutparams.flags;
        setContentView(0x109002f);
        GridView gridview = (GridView)findViewById(0x1020268);
        gridview.setAdapter(new OptionsAdapter(getContext()));
        gridview.setOnItemClickListener(this);
        mCancelButton = (Button)findViewById(0x1020269);
        mCancelButton.setOnClickListener(this);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l) {
        replaceCharacterAndClose(String.valueOf(mOptions.charAt(i)));
    }

    private Button mCancelButton;
    private LayoutInflater mInflater;
    private boolean mInsert;
    private String mOptions;
    private Editable mText;
    private View mView;


}
