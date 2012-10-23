// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.accessibility;

import android.os.Parcelable;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.view.accessibility:
//            AccessibilityNodeInfo, AccessibilityInteractionClient

public class AccessibilityRecord {

    AccessibilityRecord() {
        mBooleanProperties = 512;
        mCurrentItemIndex = -1;
        mItemCount = -1;
        mFromIndex = -1;
        mToIndex = -1;
        mScrollX = -1;
        mScrollY = -1;
        mMaxScrollX = -1;
        mMaxScrollY = -1;
        mAddedCount = -1;
        mRemovedCount = -1;
        mSourceNodeId = AccessibilityNodeInfo.makeNodeId(-1, -1);
        mSourceWindowId = -1;
        mConnectionId = -1;
    }

    private boolean getBooleanProperty(int i) {
        boolean flag;
        if((i & mBooleanProperties) == i)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static AccessibilityRecord obtain() {
        Object obj = sPoolLock;
        obj;
        JVM INSTR monitorenter ;
        AccessibilityRecord accessibilityrecord;
        if(sPool != null) {
            accessibilityrecord = sPool;
            sPool = sPool.mNext;
            sPoolSize = -1 + sPoolSize;
            accessibilityrecord.mNext = null;
            accessibilityrecord.mIsInPool = false;
        } else {
            accessibilityrecord = new AccessibilityRecord();
        }
        return accessibilityrecord;
    }

    public static AccessibilityRecord obtain(AccessibilityRecord accessibilityrecord) {
        AccessibilityRecord accessibilityrecord1 = obtain();
        accessibilityrecord1.init(accessibilityrecord);
        return accessibilityrecord1;
    }

    private void setBooleanProperty(int i, boolean flag) {
        if(flag)
            mBooleanProperties = i | mBooleanProperties;
        else
            mBooleanProperties = mBooleanProperties & ~i;
    }

    void clear() {
        mSealed = false;
        mBooleanProperties = 512;
        mCurrentItemIndex = -1;
        mItemCount = -1;
        mFromIndex = -1;
        mToIndex = -1;
        mScrollX = -1;
        mScrollY = -1;
        mMaxScrollX = -1;
        mMaxScrollY = -1;
        mAddedCount = -1;
        mRemovedCount = -1;
        mClassName = null;
        mContentDescription = null;
        mBeforeText = null;
        mParcelableData = null;
        mText.clear();
        mSourceNodeId = AccessibilityNodeInfo.makeNodeId(-1, -1);
        mSourceWindowId = -1;
        mConnectionId = -1;
    }

    void enforceNotSealed() {
        if(isSealed())
            throw new IllegalStateException("Cannot perform this action on a sealed instance.");
        else
            return;
    }

    void enforceSealed() {
        if(!isSealed())
            throw new IllegalStateException("Cannot perform this action on a not sealed instance.");
        else
            return;
    }

    public int getAddedCount() {
        return mAddedCount;
    }

    public CharSequence getBeforeText() {
        return mBeforeText;
    }

    public CharSequence getClassName() {
        return mClassName;
    }

    public CharSequence getContentDescription() {
        return mContentDescription;
    }

    public int getCurrentItemIndex() {
        return mCurrentItemIndex;
    }

    public int getFromIndex() {
        return mFromIndex;
    }

    public int getItemCount() {
        return mItemCount;
    }

    public int getMaxScrollX() {
        return mMaxScrollX;
    }

    public int getMaxScrollY() {
        return mMaxScrollY;
    }

    public Parcelable getParcelableData() {
        return mParcelableData;
    }

    public int getRemovedCount() {
        return mRemovedCount;
    }

    public int getScrollX() {
        return mScrollX;
    }

    public int getScrollY() {
        return mScrollY;
    }

    public AccessibilityNodeInfo getSource() {
        enforceSealed();
        AccessibilityNodeInfo accessibilitynodeinfo;
        if(mConnectionId == -1 || mSourceWindowId == -1 || AccessibilityNodeInfo.getAccessibilityViewId(mSourceNodeId) == -1)
            accessibilitynodeinfo = null;
        else
            accessibilitynodeinfo = AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfoByAccessibilityId(mConnectionId, mSourceWindowId, mSourceNodeId, 7);
        return accessibilitynodeinfo;
    }

    public long getSourceNodeId() {
        return mSourceNodeId;
    }

    public List getText() {
        return mText;
    }

    public int getToIndex() {
        return mToIndex;
    }

    public int getWindowId() {
        return mSourceWindowId;
    }

    void init(AccessibilityRecord accessibilityrecord) {
        mSealed = accessibilityrecord.mSealed;
        mBooleanProperties = accessibilityrecord.mBooleanProperties;
        mCurrentItemIndex = accessibilityrecord.mCurrentItemIndex;
        mItemCount = accessibilityrecord.mItemCount;
        mFromIndex = accessibilityrecord.mFromIndex;
        mToIndex = accessibilityrecord.mToIndex;
        mScrollX = accessibilityrecord.mScrollX;
        mScrollY = accessibilityrecord.mScrollY;
        mMaxScrollX = accessibilityrecord.mMaxScrollX;
        mMaxScrollY = accessibilityrecord.mMaxScrollY;
        mAddedCount = accessibilityrecord.mAddedCount;
        mRemovedCount = accessibilityrecord.mRemovedCount;
        mClassName = accessibilityrecord.mClassName;
        mContentDescription = accessibilityrecord.mContentDescription;
        mBeforeText = accessibilityrecord.mBeforeText;
        mParcelableData = accessibilityrecord.mParcelableData;
        mText.addAll(accessibilityrecord.mText);
        mSourceWindowId = accessibilityrecord.mSourceWindowId;
        mSourceNodeId = accessibilityrecord.mSourceNodeId;
        mConnectionId = accessibilityrecord.mConnectionId;
    }

    public boolean isChecked() {
        return getBooleanProperty(1);
    }

    public boolean isEnabled() {
        return getBooleanProperty(2);
    }

    public boolean isFullScreen() {
        return getBooleanProperty(128);
    }

    public boolean isImportantForAccessibility() {
        return getBooleanProperty(512);
    }

    public boolean isPassword() {
        return getBooleanProperty(4);
    }

    public boolean isScrollable() {
        return getBooleanProperty(256);
    }

    boolean isSealed() {
        return mSealed;
    }

    public void recycle() {
        if(mIsInPool)
            throw new IllegalStateException("Record already recycled!");
        clear();
        Object obj = sPoolLock;
        obj;
        JVM INSTR monitorenter ;
        if(sPoolSize <= 10) {
            mNext = sPool;
            sPool = this;
            mIsInPool = true;
            sPoolSize = 1 + sPoolSize;
        }
        return;
    }

    public void setAddedCount(int i) {
        enforceNotSealed();
        mAddedCount = i;
    }

    public void setBeforeText(CharSequence charsequence) {
        enforceNotSealed();
        mBeforeText = charsequence;
    }

    public void setChecked(boolean flag) {
        enforceNotSealed();
        setBooleanProperty(1, flag);
    }

    public void setClassName(CharSequence charsequence) {
        enforceNotSealed();
        mClassName = charsequence;
    }

    public void setConnectionId(int i) {
        enforceNotSealed();
        mConnectionId = i;
    }

    public void setContentDescription(CharSequence charsequence) {
        enforceNotSealed();
        mContentDescription = charsequence;
    }

    public void setCurrentItemIndex(int i) {
        enforceNotSealed();
        mCurrentItemIndex = i;
    }

    public void setEnabled(boolean flag) {
        enforceNotSealed();
        setBooleanProperty(2, flag);
    }

    public void setFromIndex(int i) {
        enforceNotSealed();
        mFromIndex = i;
    }

    public void setFullScreen(boolean flag) {
        enforceNotSealed();
        setBooleanProperty(128, flag);
    }

    public void setItemCount(int i) {
        enforceNotSealed();
        mItemCount = i;
    }

    public void setMaxScrollX(int i) {
        enforceNotSealed();
        mMaxScrollX = i;
    }

    public void setMaxScrollY(int i) {
        enforceNotSealed();
        mMaxScrollY = i;
    }

    public void setParcelableData(Parcelable parcelable) {
        enforceNotSealed();
        mParcelableData = parcelable;
    }

    public void setPassword(boolean flag) {
        enforceNotSealed();
        setBooleanProperty(4, flag);
    }

    public void setRemovedCount(int i) {
        enforceNotSealed();
        mRemovedCount = i;
    }

    public void setScrollX(int i) {
        enforceNotSealed();
        mScrollX = i;
    }

    public void setScrollY(int i) {
        enforceNotSealed();
        mScrollY = i;
    }

    public void setScrollable(boolean flag) {
        enforceNotSealed();
        setBooleanProperty(256, flag);
    }

    public void setSealed(boolean flag) {
        mSealed = flag;
    }

    public void setSource(View view) {
        setSource(view, -1);
    }

    public void setSource(View view, int i) {
        enforceNotSealed();
        boolean flag;
        int j;
        int k;
        if(i == -1) {
            if(view != null)
                flag = view.isImportantForAccessibility();
            else
                flag = true;
        } else {
            flag = true;
        }
        setBooleanProperty(512, flag);
        if(view != null)
            j = view.getAccessibilityWindowId();
        else
            j = -1;
        mSourceWindowId = j;
        if(view != null)
            k = view.getAccessibilityViewId();
        else
            k = -1;
        mSourceNodeId = AccessibilityNodeInfo.makeNodeId(k, i);
    }

    public void setToIndex(int i) {
        enforceNotSealed();
        mToIndex = i;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder()).append(" [ ClassName: ").append(mClassName).toString());
        stringbuilder.append((new StringBuilder()).append("; Text: ").append(mText).toString());
        stringbuilder.append((new StringBuilder()).append("; ContentDescription: ").append(mContentDescription).toString());
        stringbuilder.append((new StringBuilder()).append("; ItemCount: ").append(mItemCount).toString());
        stringbuilder.append((new StringBuilder()).append("; CurrentItemIndex: ").append(mCurrentItemIndex).toString());
        stringbuilder.append((new StringBuilder()).append("; IsEnabled: ").append(getBooleanProperty(2)).toString());
        stringbuilder.append((new StringBuilder()).append("; IsPassword: ").append(getBooleanProperty(4)).toString());
        stringbuilder.append((new StringBuilder()).append("; IsChecked: ").append(getBooleanProperty(1)).toString());
        stringbuilder.append((new StringBuilder()).append("; IsFullScreen: ").append(getBooleanProperty(128)).toString());
        stringbuilder.append((new StringBuilder()).append("; Scrollable: ").append(getBooleanProperty(256)).toString());
        stringbuilder.append((new StringBuilder()).append("; BeforeText: ").append(mBeforeText).toString());
        stringbuilder.append((new StringBuilder()).append("; FromIndex: ").append(mFromIndex).toString());
        stringbuilder.append((new StringBuilder()).append("; ToIndex: ").append(mToIndex).toString());
        stringbuilder.append((new StringBuilder()).append("; ScrollX: ").append(mScrollX).toString());
        stringbuilder.append((new StringBuilder()).append("; ScrollY: ").append(mScrollY).toString());
        stringbuilder.append((new StringBuilder()).append("; MaxScrollX: ").append(mMaxScrollX).toString());
        stringbuilder.append((new StringBuilder()).append("; MaxScrollY: ").append(mMaxScrollY).toString());
        stringbuilder.append((new StringBuilder()).append("; AddedCount: ").append(mAddedCount).toString());
        stringbuilder.append((new StringBuilder()).append("; RemovedCount: ").append(mRemovedCount).toString());
        stringbuilder.append((new StringBuilder()).append("; ParcelableData: ").append(mParcelableData).toString());
        stringbuilder.append(" ]");
        return stringbuilder.toString();
    }

    private static final int GET_SOURCE_PREFETCH_FLAGS = 7;
    private static final int MAX_POOL_SIZE = 10;
    private static final int PROPERTY_CHECKED = 1;
    private static final int PROPERTY_ENABLED = 2;
    private static final int PROPERTY_FULL_SCREEN = 128;
    private static final int PROPERTY_IMPORTANT_FOR_ACCESSIBILITY = 512;
    private static final int PROPERTY_PASSWORD = 4;
    private static final int PROPERTY_SCROLLABLE = 256;
    private static final int UNDEFINED = -1;
    private static AccessibilityRecord sPool;
    private static final Object sPoolLock = new Object();
    private static int sPoolSize;
    int mAddedCount;
    CharSequence mBeforeText;
    int mBooleanProperties;
    CharSequence mClassName;
    int mConnectionId;
    CharSequence mContentDescription;
    int mCurrentItemIndex;
    int mFromIndex;
    private boolean mIsInPool;
    int mItemCount;
    int mMaxScrollX;
    int mMaxScrollY;
    private AccessibilityRecord mNext;
    Parcelable mParcelableData;
    int mRemovedCount;
    int mScrollX;
    int mScrollY;
    boolean mSealed;
    long mSourceNodeId;
    int mSourceWindowId;
    final List mText = new ArrayList();
    int mToIndex;

}
