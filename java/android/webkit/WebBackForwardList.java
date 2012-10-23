// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package android.webkit:
//            WebHistoryItem, CallbackProxy

public class WebBackForwardList
    implements Cloneable, Serializable {

    WebBackForwardList(CallbackProxy callbackproxy) {
        mCurrentIndex = -1;
        mArray = new ArrayList();
        mCallbackProxy = callbackproxy;
    }

    private static native void nativeClose(int i);

    /**
     * @deprecated Method removeHistoryItem is deprecated
     */

    private void removeHistoryItem(int i) {
        this;
        JVM INSTR monitorenter ;
        (WebHistoryItem)mArray.remove(i);
        mCurrentIndex = -1 + mCurrentIndex;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method restoreIndex is deprecated
     */

    static synchronized native void restoreIndex(int i, int j);

    /**
     * @deprecated Method addHistoryItem is deprecated
     */

    void addHistoryItem(WebHistoryItem webhistoryitem) {
        this;
        JVM INSTR monitorenter ;
        mCurrentIndex = 1 + mCurrentIndex;
        int i = mArray.size();
        int j = mCurrentIndex;
        if(j != i) {
            for(int k = i - 1; k >= j; k--) {
                (WebHistoryItem)mArray.remove(k);
            }

        }
        mArray.add(webhistoryitem);
        if(mCallbackProxy != null)
            mCallbackProxy.onNewHistoryItem(webhistoryitem);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method clone is deprecated
     */

    protected WebBackForwardList clone() {
        this;
        JVM INSTR monitorenter ;
        WebBackForwardList webbackforwardlist = new WebBackForwardList(null);
        if(!mClearPending) goto _L2; else goto _L1
_L1:
        webbackforwardlist.addHistoryItem(getCurrentItem());
_L6:
        this;
        JVM INSTR monitorexit ;
        return webbackforwardlist;
_L2:
        int i;
        int j;
        webbackforwardlist.mCurrentIndex = mCurrentIndex;
        i = getSize();
        webbackforwardlist.mArray = new ArrayList(i);
        j = 0;
_L4:
        if(j >= i)
            break; /* Loop/switch isn't completed */
        webbackforwardlist.mArray.add(((WebHistoryItem)mArray.get(j)).clone());
        j++;
        if(true) goto _L4; else goto _L3
_L3:
        if(true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    protected volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    /**
     * @deprecated Method close is deprecated
     */

    void close(int i) {
        this;
        JVM INSTR monitorenter ;
        mArray.clear();
        mCurrentIndex = -1;
        nativeClose(i);
        mClearPending = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getClearPending is deprecated
     */

    boolean getClearPending() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mClearPending;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getCurrentIndex is deprecated
     */

    public int getCurrentIndex() {
        this;
        JVM INSTR monitorenter ;
        int i = mCurrentIndex;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getCurrentItem is deprecated
     */

    public WebHistoryItem getCurrentItem() {
        this;
        JVM INSTR monitorenter ;
        WebHistoryItem webhistoryitem = getItemAtIndex(mCurrentIndex);
        this;
        JVM INSTR monitorexit ;
        return webhistoryitem;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getItemAtIndex is deprecated
     */

    public WebHistoryItem getItemAtIndex(int i) {
        this;
        JVM INSTR monitorenter ;
        if(i < 0) goto _L2; else goto _L1
_L1:
        int j = getSize();
        if(i < j) goto _L3; else goto _L2
_L2:
        WebHistoryItem webhistoryitem = null;
_L5:
        this;
        JVM INSTR monitorexit ;
        return webhistoryitem;
_L3:
        webhistoryitem = (WebHistoryItem)mArray.get(i);
        if(true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getSize is deprecated
     */

    public int getSize() {
        this;
        JVM INSTR monitorenter ;
        int i = mArray.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setClearPending is deprecated
     */

    void setClearPending() {
        this;
        JVM INSTR monitorenter ;
        mClearPending = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setCurrentIndex is deprecated
     */

    void setCurrentIndex(int i) {
        this;
        JVM INSTR monitorenter ;
        mCurrentIndex = i;
        if(mCallbackProxy != null)
            mCallbackProxy.onIndexChanged(getItemAtIndex(i), i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private ArrayList mArray;
    private final CallbackProxy mCallbackProxy;
    private boolean mClearPending;
    private int mCurrentIndex;
}
