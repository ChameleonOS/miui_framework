// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;

// Referenced classes of package android.graphics.drawable:
//            DrawableContainer, Drawable

public class ListDrawable extends DrawableContainer {
    private static final class ListState extends DrawableContainer.DrawableContainerState {

        public Drawable newDrawable() {
            return new ListDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new ListDrawable(this, resources);
        }

        ListState(ListState liststate, ListDrawable listdrawable, Resources resources) {
            super(liststate, listdrawable, resources);
        }
    }


    public ListDrawable(ListState liststate, Resources resources) {
        mListState = new ListState(liststate, this, resources);
        setConstantState(mListState);
        if(resources != null) {
            mResources = resources;
            enableFade(true);
        }
    }

    public void addDrawable(int i) {
        if(mResources != null)
            mListState.addChild(mResources.getDrawable(i));
    }

    public void enableFade(boolean flag) {
        if(flag) {
            setEnterFadeDuration(mResources.getInteger(0x10e0000));
            setExitFadeDuration(mResources.getInteger(0x10e0001));
        } else {
            setEnterFadeDuration(1);
            setExitFadeDuration(1);
        }
    }

    protected boolean onLevelChange(int i) {
        boolean flag;
        if(selectDrawable(i))
            flag = true;
        else
            flag = super.onLevelChange(i);
        return flag;
    }

    private final ListState mListState;
    private Resources mResources;
}
