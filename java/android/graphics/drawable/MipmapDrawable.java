// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.graphics.drawable:
//            DrawableContainer, Drawable

public class MipmapDrawable extends DrawableContainer {
    private static final class MipmapContainerState extends DrawableContainer.DrawableContainerState {

        public void addDrawable(Drawable drawable) {
            int i = addChild(drawable);
            int j = drawable.getIntrinsicHeight();
            do {
                if(i <= 0)
                    break;
                Drawable drawable1 = super.mDrawables[i - 1];
                int k = drawable1.getIntrinsicHeight();
                if(j >= k)
                    break;
                super.mDrawables[i] = drawable1;
                mMipmapHeights[i] = k;
                super.mDrawables[i - 1] = drawable;
                mMipmapHeights[i - 1] = j;
                i--;
            } while(true);
        }

        protected void computeConstantSize() {
            int i = getChildCount();
            if(i > 0) {
                Drawable drawable = super.mDrawables[0];
                super.mConstantMinimumWidth = drawable.getMinimumWidth();
                super.mConstantMinimumHeight = drawable.getMinimumHeight();
                Drawable drawable1 = super.mDrawables[i - 1];
                super.mConstantWidth = drawable1.getIntrinsicWidth();
                super.mConstantHeight = drawable1.getIntrinsicHeight();
            } else {
                super.mConstantHeight = -1;
                super.mConstantWidth = -1;
                super.mConstantMinimumHeight = 0;
                super.mConstantMinimumWidth = 0;
            }
            super.mComputedConstantSize = true;
        }

        public void growArray(int i, int j) {
            super.growArray(i, j);
            int ai[] = new int[j];
            System.arraycopy(mMipmapHeights, 0, ai, 0, i);
            mMipmapHeights = ai;
        }

        public int indexForBounds(Rect rect) {
            int i;
            int j;
            int k;
            i = rect.height();
            j = getChildCount();
            k = 0;
_L3:
            if(k >= j)
                break MISSING_BLOCK_LABEL_39;
            if(i > mMipmapHeights[k]) goto _L2; else goto _L1
_L1:
            return k;
_L2:
            k++;
              goto _L3
            if(j > 0)
                k = j - 1;
            else
                k = -1;
              goto _L1
        }

        public Drawable newDrawable() {
            return new MipmapDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new MipmapDrawable(this, resources);
        }

        private int mMipmapHeights[];



/*
        static int[] access$002(MipmapContainerState mipmapcontainerstate, int ai[]) {
            mipmapcontainerstate.mMipmapHeights = ai;
            return ai;
        }

*/

        MipmapContainerState(MipmapContainerState mipmapcontainerstate, MipmapDrawable mipmapdrawable, Resources resources) {
            super(mipmapcontainerstate, mipmapdrawable, resources);
            if(mipmapcontainerstate != null)
                mMipmapHeights = mipmapcontainerstate.mMipmapHeights;
            else
                mMipmapHeights = new int[getChildren().length];
            setConstantSize(true);
        }
    }


    public MipmapDrawable() {
        this(null, null);
    }

    private MipmapDrawable(MipmapContainerState mipmapcontainerstate, Resources resources) {
        MipmapContainerState mipmapcontainerstate1 = new MipmapContainerState(mipmapcontainerstate, this, resources);
        mMipmapContainerState = mipmapcontainerstate1;
        setConstantState(mipmapcontainerstate1);
        onDrawableAdded();
    }


    private void onDrawableAdded() {
        selectDrawable(-1);
        onBoundsChange(getBounds());
    }

    public void addDrawable(Drawable drawable) {
        if(drawable != null) {
            mMipmapContainerState.addDrawable(drawable);
            onDrawableAdded();
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlpullparser, attributeset);
        int i = 1 + xmlpullparser.getDepth();
        do {
            int j = xmlpullparser.next();
            if(j == 1)
                break;
            int k = xmlpullparser.getDepth();
            if(k < i && j == 3)
                break;
            if(j == 2 && k <= i && xmlpullparser.getName().equals("item")) {
                TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.MipmapDrawableItem);
                int l = typedarray.getResourceId(0, 0);
                typedarray.recycle();
                Drawable drawable;
                if(l != 0) {
                    drawable = resources.getDrawable(l);
                } else {
                    int i1;
                    do
                        i1 = xmlpullparser.next();
                    while(i1 == 4);
                    if(i1 != 2)
                        throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": <item> tag requires a 'drawable' attribute or ").append("child tag defining a drawable").toString());
                    drawable = Drawable.createFromXmlInner(resources, xmlpullparser, attributeset);
                }
                mMipmapContainerState.addDrawable(drawable);
            }
        } while(true);
        onDrawableAdded();
    }

    public Drawable mutate() {
        if(!mMutated && super.mutate() == this) {
            mMipmapContainerState.mMipmapHeights = (int[])mMipmapContainerState.mMipmapHeights.clone();
            mMutated = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        selectDrawable(mMipmapContainerState.indexForBounds(rect));
        super.onBoundsChange(rect);
    }

    private final MipmapContainerState mMipmapContainerState;
    private boolean mMutated;
}
