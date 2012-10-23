// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.graphics.drawable:
//            DrawableContainer, Drawable

public class LevelListDrawable extends DrawableContainer {
    private static final class LevelListState extends DrawableContainer.DrawableContainerState {

        public void addLevel(int i, int j, Drawable drawable) {
            int k = addChild(drawable);
            mLows[k] = i;
            mHighs[k] = j;
        }

        public void growArray(int i, int j) {
            super.growArray(i, j);
            int ai[] = new int[j];
            System.arraycopy(mLows, 0, ai, 0, i);
            mLows = ai;
            int ai1[] = new int[j];
            System.arraycopy(mHighs, 0, ai1, 0, i);
            mHighs = ai1;
        }

        public int indexOfLevel(int i) {
            int ai[];
            int ai1[];
            int j;
            int k;
            ai = mLows;
            ai1 = mHighs;
            j = getChildCount();
            k = 0;
_L3:
            if(k >= j)
                break MISSING_BLOCK_LABEL_51;
            if(i < ai[k] || i > ai1[k]) goto _L2; else goto _L1
_L1:
            return k;
_L2:
            k++;
              goto _L3
            k = -1;
              goto _L1
        }

        public Drawable newDrawable() {
            return new LevelListDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new LevelListDrawable(this, resources);
        }

        private int mHighs[];
        private int mLows[];



/*
        static int[] access$002(LevelListState levelliststate, int ai[]) {
            levelliststate.mLows = ai;
            return ai;
        }

*/



/*
        static int[] access$102(LevelListState levelliststate, int ai[]) {
            levelliststate.mHighs = ai;
            return ai;
        }

*/

        LevelListState(LevelListState levelliststate, LevelListDrawable levellistdrawable, Resources resources) {
            super(levelliststate, levellistdrawable, resources);
            if(levelliststate != null) {
                mLows = levelliststate.mLows;
                mHighs = levelliststate.mHighs;
            } else {
                mLows = new int[getChildren().length];
                mHighs = new int[getChildren().length];
            }
        }
    }


    public LevelListDrawable() {
        this(null, null);
    }

    private LevelListDrawable(LevelListState levelliststate, Resources resources) {
        LevelListState levelliststate1 = new LevelListState(levelliststate, this, resources);
        mLevelListState = levelliststate1;
        setConstantState(levelliststate1);
        onLevelChange(getLevel());
    }


    public void addLevel(int i, int j, Drawable drawable) {
        if(drawable != null) {
            mLevelListState.addLevel(i, j, drawable);
            onLevelChange(getLevel());
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
                TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.LevelListDrawableItem);
                int l = typedarray.getInt(1, 0);
                int i1 = typedarray.getInt(2, 0);
                int j1 = typedarray.getResourceId(0, 0);
                typedarray.recycle();
                if(i1 < 0)
                    throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": <item> tag requires a 'maxLevel' attribute").toString());
                Drawable drawable;
                if(j1 != 0) {
                    drawable = resources.getDrawable(j1);
                } else {
                    int k1;
                    do
                        k1 = xmlpullparser.next();
                    while(k1 == 4);
                    if(k1 != 2)
                        throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": <item> tag requires a 'drawable' attribute or ").append("child tag defining a drawable").toString());
                    drawable = Drawable.createFromXmlInner(resources, xmlpullparser, attributeset);
                }
                mLevelListState.addLevel(l, i1, drawable);
            }
        } while(true);
        onLevelChange(getLevel());
    }

    public Drawable mutate() {
        if(!mMutated && super.mutate() == this) {
            mLevelListState.mLows = (int[])mLevelListState.mLows.clone();
            mLevelListState.mHighs = (int[])mLevelListState.mHighs.clone();
            mMutated = true;
        }
        return this;
    }

    protected boolean onLevelChange(int i) {
        boolean flag;
        if(selectDrawable(mLevelListState.indexOfLevel(i)))
            flag = true;
        else
            flag = super.onLevelChange(i);
        return flag;
    }

    private final LevelListState mLevelListState;
    private boolean mMutated;
}
