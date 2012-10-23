// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import java.lang.ref.WeakReference;

// Referenced classes of package android.view:
//            View, ViewGroup, LayoutInflater

public final class ViewStub extends View {
    public static interface OnInflateListener {

        public abstract void onInflate(ViewStub viewstub, View view);
    }


    public ViewStub(Context context) {
        mLayoutResource = 0;
        initialize(context);
    }

    public ViewStub(Context context, int i) {
        mLayoutResource = 0;
        mLayoutResource = i;
        initialize(context);
    }

    public ViewStub(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public ViewStub(Context context, AttributeSet attributeset, int i) {
        mLayoutResource = 0;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ViewStub, i, 0);
        mInflatedId = typedarray.getResourceId(1, -1);
        mLayoutResource = typedarray.getResourceId(0, 0);
        typedarray.recycle();
        TypedArray typedarray1 = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.View, i, 0);
        super.mID = typedarray1.getResourceId(8, -1);
        typedarray1.recycle();
        initialize(context);
    }

    private void initialize(Context context) {
        super.mContext = context;
        setVisibility(8);
        setWillNotDraw(true);
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return mInflatedId;
    }

    public LayoutInflater getLayoutInflater() {
        return mInflater;
    }

    public int getLayoutResource() {
        return mLayoutResource;
    }

    public View inflate() {
        ViewParent viewparent = getParent();
        if(viewparent != null && (viewparent instanceof ViewGroup)) {
            if(mLayoutResource != 0) {
                ViewGroup viewgroup = (ViewGroup)viewparent;
                LayoutInflater layoutinflater;
                View view;
                int i;
                ViewGroup.LayoutParams layoutparams;
                if(mInflater != null)
                    layoutinflater = mInflater;
                else
                    layoutinflater = LayoutInflater.from(super.mContext);
                view = layoutinflater.inflate(mLayoutResource, viewgroup, false);
                if(mInflatedId != -1)
                    view.setId(mInflatedId);
                i = viewgroup.indexOfChild(this);
                viewgroup.removeViewInLayout(this);
                layoutparams = getLayoutParams();
                if(layoutparams != null)
                    viewgroup.addView(view, i, layoutparams);
                else
                    viewgroup.addView(view, i);
                mInflatedViewRef = new WeakReference(view);
                if(mInflateListener != null)
                    mInflateListener.onInflate(this, view);
                return view;
            } else {
                throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
            }
        } else {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
    }

    protected void onMeasure(int i, int j) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        mInflatedId = i;
    }

    public void setLayoutInflater(LayoutInflater layoutinflater) {
        mInflater = layoutinflater;
    }

    public void setLayoutResource(int i) {
        mLayoutResource = i;
    }

    public void setOnInflateListener(OnInflateListener oninflatelistener) {
        mInflateListener = oninflatelistener;
    }

    public void setVisibility(int i) {
        if(mInflatedViewRef == null) goto _L2; else goto _L1
_L1:
        View view = (View)mInflatedViewRef.get();
        if(view == null) goto _L4; else goto _L3
_L3:
        view.setVisibility(i);
_L6:
        return;
_L4:
        throw new IllegalStateException("setVisibility called on un-referenced view");
_L2:
        super.setVisibility(i);
        if(i == 0 || i == 4)
            inflate();
        if(true) goto _L6; else goto _L5
_L5:
    }

    private OnInflateListener mInflateListener;
    private int mInflatedId;
    private WeakReference mInflatedViewRef;
    private LayoutInflater mInflater;
    private int mLayoutResource;
}
