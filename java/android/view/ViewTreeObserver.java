// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.Rect;
import android.graphics.Region;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package android.view:
//            View

public final class ViewTreeObserver {
    public static interface OnComputeInternalInsetsListener {

        public abstract void onComputeInternalInsets(InternalInsetsInfo internalinsetsinfo);
    }

    public static final class InternalInsetsInfo {

        public boolean equals(Object obj) {
            boolean flag = true;
            if(this != obj) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            if(obj == null || getClass() != obj.getClass()) {
                flag = false;
            } else {
                InternalInsetsInfo internalinsetsinfo = (InternalInsetsInfo)obj;
                if(mTouchableInsets != internalinsetsinfo.mTouchableInsets || !contentInsets.equals(internalinsetsinfo.contentInsets) || !visibleInsets.equals(internalinsetsinfo.visibleInsets) || !touchableRegion.equals(internalinsetsinfo.touchableRegion))
                    flag = false;
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        public int hashCode() {
            int i = 0;
            int j;
            int k;
            int l;
            int i1;
            if(contentInsets != null)
                j = contentInsets.hashCode();
            else
                j = 0;
            k = j * 31;
            if(visibleInsets != null)
                l = visibleInsets.hashCode();
            else
                l = 0;
            i1 = 31 * (k + l);
            if(touchableRegion != null)
                i = touchableRegion.hashCode();
            return 31 * (i1 + i) + mTouchableInsets;
        }

        void reset() {
            contentInsets.setEmpty();
            visibleInsets.setEmpty();
            touchableRegion.setEmpty();
            mTouchableInsets = 0;
        }

        void set(InternalInsetsInfo internalinsetsinfo) {
            contentInsets.set(internalinsetsinfo.contentInsets);
            visibleInsets.set(internalinsetsinfo.visibleInsets);
            touchableRegion.set(internalinsetsinfo.touchableRegion);
            mTouchableInsets = internalinsetsinfo.mTouchableInsets;
        }

        public void setTouchableInsets(int i) {
            mTouchableInsets = i;
        }

        public static final int TOUCHABLE_INSETS_CONTENT = 1;
        public static final int TOUCHABLE_INSETS_FRAME = 0;
        public static final int TOUCHABLE_INSETS_REGION = 3;
        public static final int TOUCHABLE_INSETS_VISIBLE = 2;
        public final Rect contentInsets = new Rect();
        int mTouchableInsets;
        public final Region touchableRegion = new Region();
        public final Rect visibleInsets = new Rect();

        public InternalInsetsInfo() {
        }
    }

    public static interface OnScrollChangedListener {

        public abstract void onScrollChanged();
    }

    public static interface OnTouchModeChangeListener {

        public abstract void onTouchModeChanged(boolean flag);
    }

    public static interface OnDrawListener {

        public abstract void onDraw();
    }

    public static interface OnPreDrawListener {

        public abstract boolean onPreDraw();
    }

    public static interface OnGlobalLayoutListener {

        public abstract void onGlobalLayout();
    }

    public static interface OnGlobalFocusChangeListener {

        public abstract void onGlobalFocusChanged(View view, View view1);
    }


    ViewTreeObserver() {
        mAlive = true;
    }

    private void checkIsAlive() {
        if(!mAlive)
            throw new IllegalStateException("This ViewTreeObserver is not alive, call getViewTreeObserver() again");
        else
            return;
    }

    private void kill() {
        mAlive = false;
    }

    public void addOnComputeInternalInsetsListener(OnComputeInternalInsetsListener oncomputeinternalinsetslistener) {
        checkIsAlive();
        if(mOnComputeInternalInsetsListeners == null)
            mOnComputeInternalInsetsListeners = new CopyOnWriteArrayList();
        mOnComputeInternalInsetsListeners.add(oncomputeinternalinsetslistener);
    }

    public void addOnDrawListener(OnDrawListener ondrawlistener) {
        checkIsAlive();
        if(mOnDrawListeners == null)
            mOnDrawListeners = new ArrayList();
        mOnDrawListeners.add(ondrawlistener);
    }

    public void addOnGlobalFocusChangeListener(OnGlobalFocusChangeListener onglobalfocuschangelistener) {
        checkIsAlive();
        if(mOnGlobalFocusListeners == null)
            mOnGlobalFocusListeners = new CopyOnWriteArrayList();
        mOnGlobalFocusListeners.add(onglobalfocuschangelistener);
    }

    public void addOnGlobalLayoutListener(OnGlobalLayoutListener ongloballayoutlistener) {
        checkIsAlive();
        if(mOnGlobalLayoutListeners == null)
            mOnGlobalLayoutListeners = new CopyOnWriteArrayList();
        mOnGlobalLayoutListeners.add(ongloballayoutlistener);
    }

    public void addOnPreDrawListener(OnPreDrawListener onpredrawlistener) {
        checkIsAlive();
        if(mOnPreDrawListeners == null)
            mOnPreDrawListeners = new ArrayList();
        mOnPreDrawListeners.add(onpredrawlistener);
    }

    public void addOnScrollChangedListener(OnScrollChangedListener onscrollchangedlistener) {
        checkIsAlive();
        if(mOnScrollChangedListeners == null)
            mOnScrollChangedListeners = new CopyOnWriteArrayList();
        mOnScrollChangedListeners.add(onscrollchangedlistener);
    }

    public void addOnTouchModeChangeListener(OnTouchModeChangeListener ontouchmodechangelistener) {
        checkIsAlive();
        if(mOnTouchModeChangeListeners == null)
            mOnTouchModeChangeListeners = new CopyOnWriteArrayList();
        mOnTouchModeChangeListeners.add(ontouchmodechangelistener);
    }

    final void dispatchOnComputeInternalInsets(InternalInsetsInfo internalinsetsinfo) {
        CopyOnWriteArrayList copyonwritearraylist = mOnComputeInternalInsetsListeners;
        if(copyonwritearraylist != null && copyonwritearraylist.size() > 0) {
            for(Iterator iterator = copyonwritearraylist.iterator(); iterator.hasNext(); ((OnComputeInternalInsetsListener)iterator.next()).onComputeInternalInsets(internalinsetsinfo));
        }
    }

    public final void dispatchOnDraw() {
        if(mOnDrawListeners != null) {
            ArrayList arraylist = mOnDrawListeners;
            int i = arraylist.size();
            for(int j = 0; j < i; j++)
                ((OnDrawListener)arraylist.get(j)).onDraw();

        }
    }

    final void dispatchOnGlobalFocusChange(View view, View view1) {
        CopyOnWriteArrayList copyonwritearraylist = mOnGlobalFocusListeners;
        if(copyonwritearraylist != null && copyonwritearraylist.size() > 0) {
            for(Iterator iterator = copyonwritearraylist.iterator(); iterator.hasNext(); ((OnGlobalFocusChangeListener)iterator.next()).onGlobalFocusChanged(view, view1));
        }
    }

    public final void dispatchOnGlobalLayout() {
        CopyOnWriteArrayList copyonwritearraylist = mOnGlobalLayoutListeners;
        if(copyonwritearraylist != null && copyonwritearraylist.size() > 0) {
            for(Iterator iterator = copyonwritearraylist.iterator(); iterator.hasNext(); ((OnGlobalLayoutListener)iterator.next()).onGlobalLayout());
        }
    }

    public final boolean dispatchOnPreDraw() {
        boolean flag = false;
        if(mOnPreDrawListeners != null && mOnPreDrawListeners.size() > 0) {
            ArrayList arraylist = (ArrayList)mOnPreDrawListeners.clone();
            int i = arraylist.size();
            int j = 0;
            while(j < i)  {
                boolean flag1;
                if(!((OnPreDrawListener)arraylist.get(j)).onPreDraw())
                    flag1 = true;
                else
                    flag1 = false;
                flag |= flag1;
                j++;
            }
        }
        return flag;
    }

    final void dispatchOnScrollChanged() {
        CopyOnWriteArrayList copyonwritearraylist = mOnScrollChangedListeners;
        if(copyonwritearraylist != null && copyonwritearraylist.size() > 0) {
            for(Iterator iterator = copyonwritearraylist.iterator(); iterator.hasNext(); ((OnScrollChangedListener)iterator.next()).onScrollChanged());
        }
    }

    final void dispatchOnTouchModeChanged(boolean flag) {
        CopyOnWriteArrayList copyonwritearraylist = mOnTouchModeChangeListeners;
        if(copyonwritearraylist != null && copyonwritearraylist.size() > 0) {
            for(Iterator iterator = copyonwritearraylist.iterator(); iterator.hasNext(); ((OnTouchModeChangeListener)iterator.next()).onTouchModeChanged(flag));
        }
    }

    final boolean hasComputeInternalInsetsListeners() {
        CopyOnWriteArrayList copyonwritearraylist = mOnComputeInternalInsetsListeners;
        boolean flag;
        if(copyonwritearraylist != null && copyonwritearraylist.size() > 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isAlive() {
        return mAlive;
    }

    void merge(ViewTreeObserver viewtreeobserver) {
        if(viewtreeobserver.mOnGlobalFocusListeners != null)
            if(mOnGlobalFocusListeners != null)
                mOnGlobalFocusListeners.addAll(viewtreeobserver.mOnGlobalFocusListeners);
            else
                mOnGlobalFocusListeners = viewtreeobserver.mOnGlobalFocusListeners;
        if(viewtreeobserver.mOnGlobalLayoutListeners != null)
            if(mOnGlobalLayoutListeners != null)
                mOnGlobalLayoutListeners.addAll(viewtreeobserver.mOnGlobalLayoutListeners);
            else
                mOnGlobalLayoutListeners = viewtreeobserver.mOnGlobalLayoutListeners;
        if(viewtreeobserver.mOnPreDrawListeners != null)
            if(mOnPreDrawListeners != null)
                mOnPreDrawListeners.addAll(viewtreeobserver.mOnPreDrawListeners);
            else
                mOnPreDrawListeners = viewtreeobserver.mOnPreDrawListeners;
        if(viewtreeobserver.mOnTouchModeChangeListeners != null)
            if(mOnTouchModeChangeListeners != null)
                mOnTouchModeChangeListeners.addAll(viewtreeobserver.mOnTouchModeChangeListeners);
            else
                mOnTouchModeChangeListeners = viewtreeobserver.mOnTouchModeChangeListeners;
        if(viewtreeobserver.mOnComputeInternalInsetsListeners != null)
            if(mOnComputeInternalInsetsListeners != null)
                mOnComputeInternalInsetsListeners.addAll(viewtreeobserver.mOnComputeInternalInsetsListeners);
            else
                mOnComputeInternalInsetsListeners = viewtreeobserver.mOnComputeInternalInsetsListeners;
        if(viewtreeobserver.mOnScrollChangedListeners != null)
            if(mOnScrollChangedListeners != null)
                mOnScrollChangedListeners.addAll(viewtreeobserver.mOnScrollChangedListeners);
            else
                mOnScrollChangedListeners = viewtreeobserver.mOnScrollChangedListeners;
        viewtreeobserver.kill();
    }

    public void removeGlobalOnLayoutListener(OnGlobalLayoutListener ongloballayoutlistener) {
        removeOnGlobalLayoutListener(ongloballayoutlistener);
    }

    public void removeOnComputeInternalInsetsListener(OnComputeInternalInsetsListener oncomputeinternalinsetslistener) {
        checkIsAlive();
        if(mOnComputeInternalInsetsListeners != null)
            mOnComputeInternalInsetsListeners.remove(oncomputeinternalinsetslistener);
    }

    public void removeOnDrawListener(OnDrawListener ondrawlistener) {
        checkIsAlive();
        if(mOnDrawListeners != null)
            mOnDrawListeners.remove(ondrawlistener);
    }

    public void removeOnGlobalFocusChangeListener(OnGlobalFocusChangeListener onglobalfocuschangelistener) {
        checkIsAlive();
        if(mOnGlobalFocusListeners != null)
            mOnGlobalFocusListeners.remove(onglobalfocuschangelistener);
    }

    public void removeOnGlobalLayoutListener(OnGlobalLayoutListener ongloballayoutlistener) {
        checkIsAlive();
        if(mOnGlobalLayoutListeners != null)
            mOnGlobalLayoutListeners.remove(ongloballayoutlistener);
    }

    public void removeOnPreDrawListener(OnPreDrawListener onpredrawlistener) {
        checkIsAlive();
        if(mOnPreDrawListeners != null)
            mOnPreDrawListeners.remove(onpredrawlistener);
    }

    public void removeOnScrollChangedListener(OnScrollChangedListener onscrollchangedlistener) {
        checkIsAlive();
        if(mOnScrollChangedListeners != null)
            mOnScrollChangedListeners.remove(onscrollchangedlistener);
    }

    public void removeOnTouchModeChangeListener(OnTouchModeChangeListener ontouchmodechangelistener) {
        checkIsAlive();
        if(mOnTouchModeChangeListeners != null)
            mOnTouchModeChangeListeners.remove(ontouchmodechangelistener);
    }

    private boolean mAlive;
    private CopyOnWriteArrayList mOnComputeInternalInsetsListeners;
    private ArrayList mOnDrawListeners;
    private CopyOnWriteArrayList mOnGlobalFocusListeners;
    private CopyOnWriteArrayList mOnGlobalLayoutListeners;
    private ArrayList mOnPreDrawListeners;
    private CopyOnWriteArrayList mOnScrollChangedListeners;
    private CopyOnWriteArrayList mOnTouchModeChangeListeners;
}
