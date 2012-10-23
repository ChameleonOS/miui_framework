// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;

// Referenced classes of package android.widget:
//            ResourceCursorAdapter, TextView, ImageView

public class SimpleCursorAdapter extends ResourceCursorAdapter {
    public static interface CursorToStringConverter {

        public abstract CharSequence convertToString(Cursor cursor);
    }

    public static interface ViewBinder {

        public abstract boolean setViewValue(View view, Cursor cursor, int i);
    }


    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String as[], int ai[]) {
        super(context, i, cursor);
        mStringConversionColumn = -1;
        mTo = ai;
        mOriginalFrom = as;
        findColumns(cursor, as);
    }

    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String as[], int ai[], int j) {
        super(context, i, cursor, j);
        mStringConversionColumn = -1;
        mTo = ai;
        mOriginalFrom = as;
        findColumns(cursor, as);
    }

    private void findColumns(Cursor cursor, String as[]) {
        if(cursor != null) {
            int i = as.length;
            if(mFrom == null || mFrom.length != i)
                mFrom = new int[i];
            for(int j = 0; j < i; j++)
                mFrom[j] = cursor.getColumnIndexOrThrow(as[j]);

        } else {
            mFrom = null;
        }
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ViewBinder viewbinder = mViewBinder;
        int i = mTo.length;
        int ai[] = mFrom;
        int ai1[] = mTo;
        int j = 0;
        while(j < i)  {
            View view1 = view.findViewById(ai1[j]);
            if(view1 == null)
                continue;
            boolean flag = false;
            if(viewbinder != null)
                flag = viewbinder.setViewValue(view1, cursor, ai[j]);
            if(!flag) {
                String s = cursor.getString(ai[j]);
                if(s == null)
                    s = "";
                if(view1 instanceof TextView)
                    setViewText((TextView)view1, s);
                else
                if(view1 instanceof ImageView)
                    setViewImage((ImageView)view1, s);
                else
                    throw new IllegalStateException((new StringBuilder()).append(view1.getClass().getName()).append(" is not a ").append(" view that can be bounds by this SimpleCursorAdapter").toString());
            }
            j++;
        }
    }

    public void changeCursorAndColumns(Cursor cursor, String as[], int ai[]) {
        mOriginalFrom = as;
        mTo = ai;
        findColumns(cursor, mOriginalFrom);
        super.changeCursor(cursor);
    }

    public CharSequence convertToString(Cursor cursor) {
        Object obj;
        if(mCursorToStringConverter != null)
            obj = mCursorToStringConverter.convertToString(cursor);
        else
        if(mStringConversionColumn > -1)
            obj = cursor.getString(mStringConversionColumn);
        else
            obj = super.convertToString(cursor);
        return ((CharSequence) (obj));
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return mCursorToStringConverter;
    }

    public int getStringConversionColumn() {
        return mStringConversionColumn;
    }

    public ViewBinder getViewBinder() {
        return mViewBinder;
    }

    public void setCursorToStringConverter(CursorToStringConverter cursortostringconverter) {
        mCursorToStringConverter = cursortostringconverter;
    }

    public void setStringConversionColumn(int i) {
        mStringConversionColumn = i;
    }

    public void setViewBinder(ViewBinder viewbinder) {
        mViewBinder = viewbinder;
    }

    public void setViewImage(ImageView imageview, String s) {
        imageview.setImageResource(Integer.parseInt(s));
_L1:
        return;
        NumberFormatException numberformatexception;
        numberformatexception;
        imageview.setImageURI(Uri.parse(s));
          goto _L1
    }

    public void setViewText(TextView textview, String s) {
        textview.setText(s);
    }

    public Cursor swapCursor(Cursor cursor) {
        findColumns(cursor, mOriginalFrom);
        return super.swapCursor(cursor);
    }

    private CursorToStringConverter mCursorToStringConverter;
    protected int mFrom[];
    String mOriginalFrom[];
    private int mStringConversionColumn;
    protected int mTo[];
    private ViewBinder mViewBinder;
}
