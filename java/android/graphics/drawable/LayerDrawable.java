// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.graphics.drawable:
//            Drawable

public class LayerDrawable extends Drawable
    implements Drawable.Callback {
    static class LayerState extends Drawable.ConstantState {

        public boolean canConstantState() {
            if(mCheckedConstantState || mChildren == null) goto _L2; else goto _L1
_L1:
            int i;
            int j;
            mCanConstantState = true;
            i = mNum;
            j = 0;
_L8:
            if(j >= i) goto _L4; else goto _L3
_L3:
            if(mChildren[j].mDrawable.getConstantState() != null) goto _L6; else goto _L5
_L5:
            mCanConstantState = false;
_L4:
            mCheckedConstantState = true;
_L2:
            return mCanConstantState;
_L6:
            j++;
            if(true) goto _L8; else goto _L7
_L7:
        }

        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        public final int getOpacity() {
            int j;
            if(mHaveOpacity) {
                j = mOpacity;
            } else {
                int i = mNum;
                int k;
                if(i > 0)
                    j = mChildren[0].mDrawable.getOpacity();
                else
                    j = -2;
                for(k = 1; k < i; k++)
                    j = Drawable.resolveOpacity(j, mChildren[k].mDrawable.getOpacity());

                mOpacity = j;
                mHaveOpacity = true;
            }
            return j;
        }

        public final boolean isStateful() {
            if(!mHaveStateful) goto _L2; else goto _L1
_L1:
            boolean flag = mStateful;
_L4:
            return flag;
_L2:
            flag = false;
            int i = mNum;
            int j = 0;
            do {
label0:
                {
                    if(j < i) {
                        if(!mChildren[j].mDrawable.isStateful())
                            break label0;
                        flag = true;
                    }
                    mStateful = flag;
                    mHaveStateful = true;
                }
                if(true)
                    continue;
                j++;
            } while(true);
            if(true) goto _L4; else goto _L3
_L3:
        }

        public Drawable newDrawable() {
            return new LayerDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new LayerDrawable(this, resources);
        }

        private boolean mCanConstantState;
        int mChangingConfigurations;
        private boolean mCheckedConstantState;
        ChildDrawable mChildren[];
        int mChildrenChangingConfigurations;
        private boolean mHaveOpacity;
        private boolean mHaveStateful;
        int mNum;
        private int mOpacity;
        private boolean mStateful;

        LayerState(LayerState layerstate, LayerDrawable layerdrawable, Resources resources) {
            mHaveOpacity = false;
            mHaveStateful = false;
            if(layerstate != null) {
                ChildDrawable achilddrawable[] = layerstate.mChildren;
                int i = layerstate.mNum;
                mNum = i;
                mChildren = new ChildDrawable[i];
                mChangingConfigurations = layerstate.mChangingConfigurations;
                mChildrenChangingConfigurations = layerstate.mChildrenChangingConfigurations;
                int j = 0;
                while(j < i)  {
                    ChildDrawable achilddrawable1[] = mChildren;
                    ChildDrawable childdrawable = new ChildDrawable();
                    achilddrawable1[j] = childdrawable;
                    ChildDrawable childdrawable1 = achilddrawable[j];
                    if(resources != null)
                        childdrawable.mDrawable = childdrawable1.mDrawable.getConstantState().newDrawable(resources);
                    else
                        childdrawable.mDrawable = childdrawable1.mDrawable.getConstantState().newDrawable();
                    childdrawable.mDrawable.setCallback(layerdrawable);
                    childdrawable.mInsetL = childdrawable1.mInsetL;
                    childdrawable.mInsetT = childdrawable1.mInsetT;
                    childdrawable.mInsetR = childdrawable1.mInsetR;
                    childdrawable.mInsetB = childdrawable1.mInsetB;
                    childdrawable.mId = childdrawable1.mId;
                    j++;
                }
                mHaveOpacity = layerstate.mHaveOpacity;
                mOpacity = layerstate.mOpacity;
                mHaveStateful = layerstate.mHaveStateful;
                mStateful = layerstate.mStateful;
                mCanConstantState = true;
                mCheckedConstantState = true;
            } else {
                mNum = 0;
                mChildren = null;
            }
        }
    }

    static class ChildDrawable {

        public Drawable mDrawable;
        public int mId;
        public int mInsetB;
        public int mInsetL;
        public int mInsetR;
        public int mInsetT;

        ChildDrawable() {
        }
    }


    LayerDrawable() {
        this((LayerState)null, ((Resources) (null)));
    }

    LayerDrawable(LayerState layerstate, Resources resources) {
        mOpacityOverride = 0;
        mTmpRect = new Rect();
        LayerState layerstate1 = createConstantState(layerstate, resources);
        mLayerState = layerstate1;
        if(layerstate1.mNum > 0)
            ensurePadding();
    }

    public LayerDrawable(Drawable adrawable[]) {
        this(adrawable, ((LayerState) (null)));
    }

    LayerDrawable(Drawable adrawable[], LayerState layerstate) {
        this(layerstate, ((Resources) (null)));
        int i = adrawable.length;
        ChildDrawable achilddrawable[] = new ChildDrawable[i];
        for(int j = 0; j < i; j++) {
            achilddrawable[j] = new ChildDrawable();
            achilddrawable[j].mDrawable = adrawable[j];
            adrawable[j].setCallback(this);
            LayerState layerstate1 = mLayerState;
            layerstate1.mChildrenChangingConfigurations = layerstate1.mChildrenChangingConfigurations | adrawable[j].getChangingConfigurations();
        }

        mLayerState.mNum = i;
        mLayerState.mChildren = achilddrawable;
        ensurePadding();
    }

    private void addLayer(Drawable drawable, int i, int j, int k, int l, int i1) {
        LayerState layerstate = mLayerState;
        int j1;
        int k1;
        LayerState layerstate1;
        ChildDrawable childdrawable;
        if(layerstate.mChildren != null)
            j1 = layerstate.mChildren.length;
        else
            j1 = 0;
        k1 = layerstate.mNum;
        if(k1 >= j1) {
            ChildDrawable achilddrawable[] = new ChildDrawable[j1 + 10];
            if(k1 > 0)
                System.arraycopy(layerstate.mChildren, 0, achilddrawable, 0, k1);
            layerstate.mChildren = achilddrawable;
        }
        layerstate1 = mLayerState;
        layerstate1.mChildrenChangingConfigurations = layerstate1.mChildrenChangingConfigurations | drawable.getChangingConfigurations();
        childdrawable = new ChildDrawable();
        layerstate.mChildren[k1] = childdrawable;
        childdrawable.mId = i;
        childdrawable.mDrawable = drawable;
        childdrawable.mInsetL = j;
        childdrawable.mInsetT = k;
        childdrawable.mInsetR = l;
        childdrawable.mInsetB = i1;
        layerstate.mNum = 1 + layerstate.mNum;
        drawable.setCallback(this);
    }

    private void ensurePadding() {
        int i = mLayerState.mNum;
        if(mPaddingL == null || mPaddingL.length < i) {
            mPaddingL = new int[i];
            mPaddingT = new int[i];
            mPaddingR = new int[i];
            mPaddingB = new int[i];
        }
    }

    private boolean reapplyPadding(int i, ChildDrawable childdrawable) {
        Rect rect = mTmpRect;
        childdrawable.mDrawable.getPadding(rect);
        boolean flag;
        if(rect.left != mPaddingL[i] || rect.top != mPaddingT[i] || rect.right != mPaddingR[i] || rect.bottom != mPaddingB[i]) {
            mPaddingL[i] = rect.left;
            mPaddingT[i] = rect.top;
            mPaddingR[i] = rect.right;
            mPaddingB[i] = rect.bottom;
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    LayerState createConstantState(LayerState layerstate, Resources resources) {
        return new LayerState(layerstate, this, resources);
    }

    public void draw(Canvas canvas) {
        ChildDrawable achilddrawable[] = mLayerState.mChildren;
        int i = mLayerState.mNum;
        for(int j = 0; j < i; j++)
            achilddrawable[j].mDrawable.draw(canvas);

    }

    public Drawable findDrawableByLayerId(int i) {
        ChildDrawable achilddrawable[];
        int j;
        achilddrawable = mLayerState.mChildren;
        j = -1 + mLayerState.mNum;
_L3:
        if(j < 0)
            break MISSING_BLOCK_LABEL_50;
        if(achilddrawable[j].mId != i) goto _L2; else goto _L1
_L1:
        Drawable drawable = achilddrawable[j].mDrawable;
_L4:
        return drawable;
_L2:
        j--;
          goto _L3
        drawable = null;
          goto _L4
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mLayerState.mChangingConfigurations | mLayerState.mChildrenChangingConfigurations;
    }

    public Drawable.ConstantState getConstantState() {
        LayerState layerstate;
        if(mLayerState.canConstantState()) {
            mLayerState.mChangingConfigurations = getChangingConfigurations();
            layerstate = mLayerState;
        } else {
            layerstate = null;
        }
        return layerstate;
    }

    public Drawable getDrawable(int i) {
        return mLayerState.mChildren[i].mDrawable;
    }

    public int getId(int i) {
        return mLayerState.mChildren[i].mId;
    }

    public int getIntrinsicHeight() {
        int i = -1;
        ChildDrawable achilddrawable[] = mLayerState.mChildren;
        int j = mLayerState.mNum;
        int k = 0;
        int l = 0;
        for(int i1 = 0; i1 < j; i1++) {
            ChildDrawable childdrawable = achilddrawable[i1];
            int j1 = l + (k + (childdrawable.mDrawable.getIntrinsicHeight() + childdrawable.mInsetT + childdrawable.mInsetB));
            if(j1 > i)
                i = j1;
            k += mPaddingT[i1];
            l += mPaddingB[i1];
        }

        return i;
    }

    public int getIntrinsicWidth() {
        int i = -1;
        ChildDrawable achilddrawable[] = mLayerState.mChildren;
        int j = mLayerState.mNum;
        int k = 0;
        int l = 0;
        for(int i1 = 0; i1 < j; i1++) {
            ChildDrawable childdrawable = achilddrawable[i1];
            int j1 = l + (k + (childdrawable.mDrawable.getIntrinsicWidth() + childdrawable.mInsetL + childdrawable.mInsetR));
            if(j1 > i)
                i = j1;
            k += mPaddingL[i1];
            l += mPaddingR[i1];
        }

        return i;
    }

    public int getNumberOfLayers() {
        return mLayerState.mNum;
    }

    public int getOpacity() {
        int i;
        if(mOpacityOverride != 0)
            i = mOpacityOverride;
        else
            i = mLayerState.getOpacity();
        return i;
    }

    public boolean getPadding(Rect rect) {
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        ChildDrawable achilddrawable[] = mLayerState.mChildren;
        int i = mLayerState.mNum;
        for(int j = 0; j < i; j++) {
            reapplyPadding(j, achilddrawable[j]);
            rect.left = rect.left + mPaddingL[j];
            rect.top = rect.top + mPaddingT[j];
            rect.right = rect.right + mPaddingR[j];
            rect.bottom = rect.bottom + mPaddingB[j];
        }

        return true;
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlpullparser, attributeset);
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.LayerDrawable);
        mOpacityOverride = typedarray.getInt(0, 0);
        typedarray.recycle();
        int i = 1 + xmlpullparser.getDepth();
        do {
            int j = xmlpullparser.next();
            if(j == 1)
                break;
            int k = xmlpullparser.getDepth();
            if(k < i && j == 3)
                break;
            if(j == 2 && k <= i && xmlpullparser.getName().equals("item")) {
                TypedArray typedarray1 = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.LayerDrawableItem);
                int l = typedarray1.getDimensionPixelOffset(2, 0);
                int i1 = typedarray1.getDimensionPixelOffset(3, 0);
                int j1 = typedarray1.getDimensionPixelOffset(4, 0);
                int k1 = typedarray1.getDimensionPixelOffset(5, 0);
                int l1 = typedarray1.getResourceId(1, 0);
                int i2 = typedarray1.getResourceId(0, -1);
                typedarray1.recycle();
                Drawable drawable;
                if(l1 != 0) {
                    drawable = resources.getDrawable(l1);
                } else {
                    int j2;
                    do
                        j2 = xmlpullparser.next();
                    while(j2 == 4);
                    if(j2 != 2)
                        throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": <item> tag requires a 'drawable' attribute or ").append("child tag defining a drawable").toString());
                    drawable = Drawable.createFromXmlInner(resources, xmlpullparser, attributeset);
                }
                addLayer(drawable, i2, l, i1, j1, k1);
            }
        } while(true);
        ensurePadding();
        onStateChange(getState());
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if(callback != null)
            callback.invalidateDrawable(this);
    }

    public boolean isStateful() {
        return mLayerState.isStateful();
    }

    public Drawable mutate() {
        if(!mMutated && super.mutate() == this) {
            if(!mLayerState.canConstantState())
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            mLayerState = new LayerState(mLayerState, this, null);
            ChildDrawable achilddrawable[] = mLayerState.mChildren;
            int i = mLayerState.mNum;
            for(int j = 0; j < i; j++)
                achilddrawable[j].mDrawable.mutate();

            mMutated = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        ChildDrawable achilddrawable[] = mLayerState.mChildren;
        int i = mLayerState.mNum;
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        for(int j1 = 0; j1 < i; j1++) {
            ChildDrawable childdrawable = achilddrawable[j1];
            childdrawable.mDrawable.setBounds(j + (rect.left + childdrawable.mInsetL), k + (rect.top + childdrawable.mInsetT), rect.right - childdrawable.mInsetR - l, rect.bottom - childdrawable.mInsetB - i1);
            j += mPaddingL[j1];
            l += mPaddingR[j1];
            k += mPaddingT[j1];
            i1 += mPaddingB[j1];
        }

    }

    protected boolean onLevelChange(int i) {
        ChildDrawable achilddrawable[] = mLayerState.mChildren;
        int j = mLayerState.mNum;
        boolean flag = false;
        boolean flag1 = false;
        for(int k = 0; k < j; k++) {
            ChildDrawable childdrawable = achilddrawable[k];
            if(childdrawable.mDrawable.setLevel(i))
                flag1 = true;
            if(reapplyPadding(k, childdrawable))
                flag = true;
        }

        if(flag)
            onBoundsChange(getBounds());
        return flag1;
    }

    protected boolean onStateChange(int ai[]) {
        ChildDrawable achilddrawable[] = mLayerState.mChildren;
        int i = mLayerState.mNum;
        boolean flag = false;
        boolean flag1 = false;
        for(int j = 0; j < i; j++) {
            ChildDrawable childdrawable = achilddrawable[j];
            if(childdrawable.mDrawable.setState(ai))
                flag1 = true;
            if(reapplyPadding(j, childdrawable))
                flag = true;
        }

        if(flag)
            onBoundsChange(getBounds());
        return flag1;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
        Drawable.Callback callback = getCallback();
        if(callback != null)
            callback.scheduleDrawable(this, runnable, l);
    }

    public void setAlpha(int i) {
        ChildDrawable achilddrawable[] = mLayerState.mChildren;
        int j = mLayerState.mNum;
        for(int k = 0; k < j; k++)
            achilddrawable[k].mDrawable.setAlpha(i);

    }

    public void setColorFilter(ColorFilter colorfilter) {
        ChildDrawable achilddrawable[] = mLayerState.mChildren;
        int i = mLayerState.mNum;
        for(int j = 0; j < i; j++)
            achilddrawable[j].mDrawable.setColorFilter(colorfilter);

    }

    public void setDither(boolean flag) {
        ChildDrawable achilddrawable[] = mLayerState.mChildren;
        int i = mLayerState.mNum;
        for(int j = 0; j < i; j++)
            achilddrawable[j].mDrawable.setDither(flag);

    }

    public boolean setDrawableByLayerId(int i, Drawable drawable) {
        ChildDrawable achilddrawable[];
        int j;
        achilddrawable = mLayerState.mChildren;
        j = -1 + mLayerState.mNum;
_L3:
        if(j < 0)
            break MISSING_BLOCK_LABEL_104;
        if(achilddrawable[j].mId != i) goto _L2; else goto _L1
_L1:
        boolean flag;
        if(achilddrawable[j].mDrawable != null) {
            if(drawable != null)
                drawable.setBounds(achilddrawable[j].mDrawable.getBounds());
            achilddrawable[j].mDrawable.setCallback(null);
        }
        if(drawable != null)
            drawable.setCallback(this);
        achilddrawable[j].mDrawable = drawable;
        flag = true;
_L4:
        return flag;
_L2:
        j--;
          goto _L3
        flag = false;
          goto _L4
    }

    public void setId(int i, int j) {
        mLayerState.mChildren[i].mId = j;
    }

    public void setLayerInset(int i, int j, int k, int l, int i1) {
        ChildDrawable childdrawable = mLayerState.mChildren[i];
        childdrawable.mInsetL = j;
        childdrawable.mInsetT = k;
        childdrawable.mInsetR = l;
        childdrawable.mInsetB = i1;
    }

    public void setOpacity(int i) {
        mOpacityOverride = i;
    }

    public boolean setVisible(boolean flag, boolean flag1) {
        boolean flag2 = super.setVisible(flag, flag1);
        ChildDrawable achilddrawable[] = mLayerState.mChildren;
        int i = mLayerState.mNum;
        for(int j = 0; j < i; j++)
            achilddrawable[j].mDrawable.setVisible(flag, flag1);

        return flag2;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if(callback != null)
            callback.unscheduleDrawable(this, runnable);
    }

    LayerState mLayerState;
    private boolean mMutated;
    private int mOpacityOverride;
    private int mPaddingB[];
    private int mPaddingL[];
    private int mPaddingR[];
    private int mPaddingT[];
    private final Rect mTmpRect;
}
