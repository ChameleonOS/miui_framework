// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.StateSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.graphics.drawable:
//            DrawableContainer, Drawable

public class StateListDrawable extends DrawableContainer {
    static final class StateListState extends DrawableContainer.DrawableContainerState {

        private int indexOfStateSet(int ai[]) {
            int ai1[][];
            int i;
            int j;
            ai1 = mStateSets;
            i = getChildCount();
            j = 0;
_L3:
            if(j >= i)
                break MISSING_BLOCK_LABEL_39;
            if(!StateSet.stateSetMatches(ai1[j], ai)) goto _L2; else goto _L1
_L1:
            return j;
_L2:
            j++;
              goto _L3
            j = -1;
              goto _L1
        }

        int addStateSet(int ai[], Drawable drawable) {
            int i = addChild(drawable);
            mStateSets[i] = ai;
            return i;
        }

        public void growArray(int i, int j) {
            super.growArray(i, j);
            int ai[][] = new int[j][];
            System.arraycopy(mStateSets, 0, ai, 0, i);
            mStateSets = ai;
        }

        public Drawable newDrawable() {
            return new StateListDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new StateListDrawable(this, resources);
        }

        int mStateSets[][];


        StateListState(StateListState stateliststate, StateListDrawable statelistdrawable, Resources resources) {
            super(stateliststate, statelistdrawable, resources);
            if(stateliststate != null)
                mStateSets = stateliststate.mStateSets;
            else
                mStateSets = new int[getChildren().length][];
        }
    }


    public StateListDrawable() {
        this(null, null);
    }

    private StateListDrawable(StateListState stateliststate, Resources resources) {
        StateListState stateliststate1 = new StateListState(stateliststate, this, resources);
        mStateListState = stateliststate1;
        setConstantState(stateliststate1);
        onStateChange(getState());
    }


    public void addState(int ai[], Drawable drawable) {
        if(drawable != null) {
            mStateListState.addStateSet(ai, drawable);
            onStateChange(getState());
        }
    }

    public int getStateCount() {
        return mStateListState.getChildCount();
    }

    public Drawable getStateDrawable(int i) {
        return mStateListState.getChildren()[i];
    }

    public int getStateDrawableIndex(int ai[]) {
        return mStateListState.indexOfStateSet(ai);
    }

    StateListState getStateListState() {
        return mStateListState;
    }

    public int[] getStateSet(int i) {
        return mStateListState.mStateSets[i];
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.StateListDrawable);
        super.inflateWithAttributes(resources, xmlpullparser, typedarray, 1);
        mStateListState.setVariablePadding(typedarray.getBoolean(2, false));
        mStateListState.setConstantSize(typedarray.getBoolean(3, false));
        mStateListState.setEnterFadeDuration(typedarray.getInt(4, 0));
        mStateListState.setExitFadeDuration(typedarray.getInt(5, 0));
        setDither(typedarray.getBoolean(0, true));
        typedarray.recycle();
        int i = 1 + xmlpullparser.getDepth();
label0:
        do {
            int j = xmlpullparser.next();
            if(j != 1) {
                int k = xmlpullparser.getDepth();
                if(k >= i || j != 3) {
                    if(j != 2 || k > i || !xmlpullparser.getName().equals("item"))
                        continue;
                    int l = 0;
                    int i1 = attributeset.getAttributeCount();
                    int ai[] = new int[i1];
                    int j1 = 0;
                    int k1 = 0;
                    do {
label1:
                        {
                            int i2;
                            if(j1 < i1) {
                                i2 = attributeset.getAttributeNameResource(j1);
                                if(i2 != 0)
                                    break label1;
                            }
                            int ai1[] = StateSet.trimStateSet(ai, k1);
                            Drawable drawable;
                            int j2;
                            if(l != 0) {
                                drawable = resources.getDrawable(l);
                            } else {
                                int l1;
                                do
                                    l1 = xmlpullparser.next();
                                while(l1 == 4);
                                if(l1 != 2)
                                    throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": <item> tag requires a 'drawable' attribute or ").append("child tag defining a drawable").toString());
                                drawable = Drawable.createFromXmlInner(resources, xmlpullparser, attributeset);
                            }
                            mStateListState.addStateSet(ai1, drawable);
                            continue label0;
                        }
                        if(i2 == 0x1010199) {
                            l = attributeset.getAttributeResourceValue(j1, 0);
                            j2 = k1;
                        } else {
                            j2 = k1 + 1;
                            if(!attributeset.getAttributeBooleanValue(j1, false))
                                i2 = -i2;
                            ai[k1] = i2;
                        }
                        j1++;
                        k1 = j2;
                    } while(true);
                }
            }
            onStateChange(getState());
            return;
        } while(true);
    }

    public boolean isStateful() {
        return true;
    }

    public Drawable mutate() {
        if(!mMutated && super.mutate() == this) {
            int ai[][] = mStateListState.mStateSets;
            int i = ai.length;
            mStateListState.mStateSets = new int[i][];
            for(int j = 0; j < i; j++) {
                int ai1[] = ai[j];
                if(ai1 != null)
                    mStateListState.mStateSets[j] = (int[])ai1.clone();
            }

            mMutated = true;
        }
        return this;
    }

    protected boolean onStateChange(int ai[]) {
        int i = mStateListState.indexOfStateSet(ai);
        if(i < 0)
            i = mStateListState.indexOfStateSet(StateSet.WILD_CARD);
        boolean flag;
        if(selectDrawable(i))
            flag = true;
        else
            flag = super.onStateChange(ai);
        return flag;
    }

    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final String TAG = "StateListDrawable";
    private boolean mMutated;
    private final StateListState mStateListState;
}
