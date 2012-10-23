// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.accessibility;

import android.graphics.Rect;
import android.os.*;
import android.util.SparseLongArray;
import android.view.View;
import java.util.Collections;
import java.util.List;

// Referenced classes of package android.view.accessibility:
//            AccessibilityInteractionClient

public class AccessibilityNodeInfo
    implements Parcelable {

    private AccessibilityNodeInfo() {
        mWindowId = -1;
        mSourceNodeId = ROOT_NODE_ID;
        mParentNodeId = ROOT_NODE_ID;
        mConnectionId = -1;
    }

    private boolean canPerformRequestOverConnection(long l) {
        boolean flag;
        if(mWindowId != -1 && getAccessibilityViewId(l) != -1 && mConnectionId != -1)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void clear() {
        mSealed = false;
        mSourceNodeId = ROOT_NODE_ID;
        mParentNodeId = ROOT_NODE_ID;
        mWindowId = -1;
        mConnectionId = -1;
        mMovementGranularities = 0;
        mChildNodeIds.clear();
        mBoundsInParent.set(0, 0, 0, 0);
        mBoundsInScreen.set(0, 0, 0, 0);
        mBooleanProperties = 0;
        mPackageName = null;
        mClassName = null;
        mText = null;
        mContentDescription = null;
        mActions = 0;
    }

    private void enforceValidFocusDirection(int i) {
        switch(i) {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown direction: ").append(i).toString());

        case 1: // '\001'
        case 2: // '\002'
        case 17: // '\021'
        case 33: // '!'
        case 66: // 'B'
        case 130: 
        case 4097: 
        case 4098: 
        case 4113: 
        case 4129: 
        case 4162: 
        case 4226: 
            return;
        }
    }

    private void enforceValidFocusType(int i) {
        switch(i) {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown focus type: ").append(i).toString());

        case 1: // '\001'
        case 2: // '\002'
            return;
        }
    }

    public static int getAccessibilityViewId(long l) {
        return (int)l;
    }

    private static String getActionSymbolicName(int i) {
        i;
        JVM INSTR lookupswitch 14: default 124
    //                   1: 151
    //                   2: 156
    //                   4: 162
    //                   8: 168
    //                   16: 174
    //                   32: 180
    //                   64: 186
    //                   128: 192
    //                   256: 198
    //                   512: 204
    //                   1024: 210
    //                   2048: 216
    //                   4096: 222
    //                   8192: 228;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown action: ").append(i).toString());
_L2:
        String s = "ACTION_FOCUS";
_L17:
        return s;
_L3:
        s = "ACTION_CLEAR_FOCUS";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "ACTION_SELECT";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "ACTION_CLEAR_SELECTION";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "ACTION_CLICK";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "ACTION_LONG_CLICK";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "ACTION_ACCESSIBILITY_FOCUS";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "ACTION_NEXT_HTML_ELEMENT";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "ACTION_PREVIOUS_HTML_ELEMENT";
        continue; /* Loop/switch isn't completed */
_L14:
        s = "ACTION_SCROLL_FORWARD";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "ACTION_SCROLL_BACKWARD";
        if(true) goto _L17; else goto _L16
_L16:
    }

    private boolean getBooleanProperty(int i) {
        boolean flag;
        if((i & mBooleanProperties) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static String getMovementGranularitySymbolicName(int i) {
        i;
        JVM INSTR lookupswitch 5: default 52
    //                   1: 79
    //                   2: 84
    //                   4: 90
    //                   8: 96
    //                   16: 102;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown movement granularity: ").append(i).toString());
_L2:
        String s = "MOVEMENT_GRANULARITY_CHARACTER";
_L8:
        return s;
_L3:
        s = "MOVEMENT_GRANULARITY_WORD";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "MOVEMENT_GRANULARITY_LINE";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "MOVEMENT_GRANULARITY_PARAGRAPH";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "MOVEMENT_GRANULARITY_PAGE";
        if(true) goto _L8; else goto _L7
_L7:
    }

    public static int getVirtualDescendantId(long l) {
        return (int)((0xffffffff00000000L & l) >> 32);
    }

    private void init(AccessibilityNodeInfo accessibilitynodeinfo) {
        mSealed = accessibilitynodeinfo.mSealed;
        mSourceNodeId = accessibilitynodeinfo.mSourceNodeId;
        mParentNodeId = accessibilitynodeinfo.mParentNodeId;
        mWindowId = accessibilitynodeinfo.mWindowId;
        mConnectionId = accessibilitynodeinfo.mConnectionId;
        mBoundsInParent.set(accessibilitynodeinfo.mBoundsInParent);
        mBoundsInScreen.set(accessibilitynodeinfo.mBoundsInScreen);
        mPackageName = accessibilitynodeinfo.mPackageName;
        mClassName = accessibilitynodeinfo.mClassName;
        mText = accessibilitynodeinfo.mText;
        mContentDescription = accessibilitynodeinfo.mContentDescription;
        mActions = accessibilitynodeinfo.mActions;
        mBooleanProperties = accessibilitynodeinfo.mBooleanProperties;
        mMovementGranularities = accessibilitynodeinfo.mMovementGranularities;
        int i = accessibilitynodeinfo.mChildNodeIds.size();
        for(int j = 0; j < i; j++)
            mChildNodeIds.put(j, accessibilitynodeinfo.mChildNodeIds.valueAt(j));

    }

    private void initFromParcel(Parcel parcel) {
        boolean flag = true;
        SparseLongArray sparselongarray;
        int i;
        if(parcel.readInt() != flag)
            flag = false;
        mSealed = flag;
        mSourceNodeId = parcel.readLong();
        mWindowId = parcel.readInt();
        mParentNodeId = parcel.readLong();
        mConnectionId = parcel.readInt();
        sparselongarray = mChildNodeIds;
        i = parcel.readInt();
        for(int j = 0; j < i; j++)
            sparselongarray.put(j, parcel.readLong());

        mBoundsInParent.top = parcel.readInt();
        mBoundsInParent.bottom = parcel.readInt();
        mBoundsInParent.left = parcel.readInt();
        mBoundsInParent.right = parcel.readInt();
        mBoundsInScreen.top = parcel.readInt();
        mBoundsInScreen.bottom = parcel.readInt();
        mBoundsInScreen.left = parcel.readInt();
        mBoundsInScreen.right = parcel.readInt();
        mActions = parcel.readInt();
        mMovementGranularities = parcel.readInt();
        mBooleanProperties = parcel.readInt();
        mPackageName = parcel.readCharSequence();
        mClassName = parcel.readCharSequence();
        mText = parcel.readCharSequence();
        mContentDescription = parcel.readCharSequence();
    }

    public static long makeNodeId(int i, int j) {
        return (long)j << 32 | (long)i;
    }

    public static AccessibilityNodeInfo obtain() {
        Object obj = sPoolLock;
        obj;
        JVM INSTR monitorenter ;
        AccessibilityNodeInfo accessibilitynodeinfo;
        if(sPool != null) {
            accessibilitynodeinfo = sPool;
            sPool = sPool.mNext;
            sPoolSize = -1 + sPoolSize;
            accessibilitynodeinfo.mNext = null;
            accessibilitynodeinfo.mIsInPool = false;
        } else {
            accessibilitynodeinfo = new AccessibilityNodeInfo();
        }
        return accessibilitynodeinfo;
    }

    public static AccessibilityNodeInfo obtain(View view) {
        AccessibilityNodeInfo accessibilitynodeinfo = obtain();
        accessibilitynodeinfo.setSource(view);
        return accessibilitynodeinfo;
    }

    public static AccessibilityNodeInfo obtain(View view, int i) {
        AccessibilityNodeInfo accessibilitynodeinfo = obtain();
        accessibilitynodeinfo.setSource(view, i);
        return accessibilitynodeinfo;
    }

    public static AccessibilityNodeInfo obtain(AccessibilityNodeInfo accessibilitynodeinfo) {
        AccessibilityNodeInfo accessibilitynodeinfo1 = obtain();
        accessibilitynodeinfo1.init(accessibilitynodeinfo);
        return accessibilitynodeinfo1;
    }

    private void setBooleanProperty(int i, boolean flag) {
        enforceNotSealed();
        if(flag)
            mBooleanProperties = i | mBooleanProperties;
        else
            mBooleanProperties = mBooleanProperties & ~i;
    }

    public void addAction(int i) {
        enforceNotSealed();
        mActions = i | mActions;
    }

    public void addChild(View view) {
        addChild(view, -1);
    }

    public void addChild(View view, int i) {
        enforceNotSealed();
        int j = mChildNodeIds.size();
        int k;
        long l;
        if(view != null)
            k = view.getAccessibilityViewId();
        else
            k = -1;
        l = makeNodeId(k, i);
        mChildNodeIds.put(j, l);
    }

    public int describeContents() {
        return 0;
    }

    protected void enforceNotSealed() {
        if(isSealed())
            throw new IllegalStateException("Cannot perform this action on a sealed instance.");
        else
            return;
    }

    protected void enforceSealed() {
        if(!isSealed())
            throw new IllegalStateException("Cannot perform this action on a not sealed instance.");
        else
            return;
    }

    public boolean equals(Object obj) {
        boolean flag = true;
        if(this != obj) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(obj == null)
            flag = false;
        else
        if(getClass() != obj.getClass()) {
            flag = false;
        } else {
            AccessibilityNodeInfo accessibilitynodeinfo = (AccessibilityNodeInfo)obj;
            if(mSourceNodeId != accessibilitynodeinfo.mSourceNodeId)
                flag = false;
            else
            if(mWindowId != accessibilitynodeinfo.mWindowId)
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public List findAccessibilityNodeInfosByText(String s) {
        enforceSealed();
        List list;
        if(!canPerformRequestOverConnection(mSourceNodeId))
            list = Collections.emptyList();
        else
            list = AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfosByText(mConnectionId, mWindowId, mSourceNodeId, s);
        return list;
    }

    public AccessibilityNodeInfo findFocus(int i) {
        enforceSealed();
        enforceValidFocusType(i);
        AccessibilityNodeInfo accessibilitynodeinfo;
        if(!canPerformRequestOverConnection(mSourceNodeId))
            accessibilitynodeinfo = null;
        else
            accessibilitynodeinfo = AccessibilityInteractionClient.getInstance().findFocus(mConnectionId, mWindowId, mSourceNodeId, i);
        return accessibilitynodeinfo;
    }

    public AccessibilityNodeInfo focusSearch(int i) {
        enforceSealed();
        enforceValidFocusDirection(i);
        AccessibilityNodeInfo accessibilitynodeinfo;
        if(!canPerformRequestOverConnection(mSourceNodeId))
            accessibilitynodeinfo = null;
        else
            accessibilitynodeinfo = AccessibilityInteractionClient.getInstance().focusSearch(mConnectionId, mWindowId, mSourceNodeId, i);
        return accessibilitynodeinfo;
    }

    public int getActions() {
        return mActions;
    }

    public void getBoundsInParent(Rect rect) {
        rect.set(mBoundsInParent.left, mBoundsInParent.top, mBoundsInParent.right, mBoundsInParent.bottom);
    }

    public void getBoundsInScreen(Rect rect) {
        rect.set(mBoundsInScreen.left, mBoundsInScreen.top, mBoundsInScreen.right, mBoundsInScreen.bottom);
    }

    public AccessibilityNodeInfo getChild(int i) {
        enforceSealed();
        AccessibilityNodeInfo accessibilitynodeinfo;
        if(!canPerformRequestOverConnection(mSourceNodeId)) {
            accessibilitynodeinfo = null;
        } else {
            long l = mChildNodeIds.get(i);
            accessibilitynodeinfo = AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfoByAccessibilityId(mConnectionId, mWindowId, l, 4);
        }
        return accessibilitynodeinfo;
    }

    public int getChildCount() {
        return mChildNodeIds.size();
    }

    public SparseLongArray getChildNodeIds() {
        return mChildNodeIds;
    }

    public CharSequence getClassName() {
        return mClassName;
    }

    public CharSequence getContentDescription() {
        return mContentDescription;
    }

    public int getMovementGranularities() {
        return mMovementGranularities;
    }

    public CharSequence getPackageName() {
        return mPackageName;
    }

    public AccessibilityNodeInfo getParent() {
        enforceSealed();
        AccessibilityNodeInfo accessibilitynodeinfo;
        if(!canPerformRequestOverConnection(mParentNodeId))
            accessibilitynodeinfo = null;
        else
            accessibilitynodeinfo = AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfoByAccessibilityId(mConnectionId, mWindowId, mParentNodeId, 6);
        return accessibilitynodeinfo;
    }

    public long getParentNodeId() {
        return mParentNodeId;
    }

    public long getSourceNodeId() {
        return mSourceNodeId;
    }

    public CharSequence getText() {
        return mText;
    }

    public int getWindowId() {
        return mWindowId;
    }

    public int hashCode() {
        return 31 * (31 * (31 + getAccessibilityViewId(mSourceNodeId)) + getVirtualDescendantId(mSourceNodeId)) + mWindowId;
    }

    public boolean isAccessibilityFocused() {
        return getBooleanProperty(1024);
    }

    public boolean isCheckable() {
        return getBooleanProperty(1);
    }

    public boolean isChecked() {
        return getBooleanProperty(2);
    }

    public boolean isClickable() {
        return getBooleanProperty(32);
    }

    public boolean isEnabled() {
        return getBooleanProperty(128);
    }

    public boolean isFocusable() {
        return getBooleanProperty(4);
    }

    public boolean isFocused() {
        return getBooleanProperty(8);
    }

    public boolean isLongClickable() {
        return getBooleanProperty(64);
    }

    public boolean isPassword() {
        return getBooleanProperty(256);
    }

    public boolean isScrollable() {
        return getBooleanProperty(512);
    }

    public boolean isSealed() {
        return mSealed;
    }

    public boolean isSelected() {
        return getBooleanProperty(16);
    }

    public boolean isVisibleToUser() {
        return getBooleanProperty(2048);
    }

    public boolean performAction(int i) {
        enforceSealed();
        boolean flag;
        if(!canPerformRequestOverConnection(mSourceNodeId))
            flag = false;
        else
            flag = AccessibilityInteractionClient.getInstance().performAccessibilityAction(mConnectionId, mWindowId, mSourceNodeId, i, null);
        return flag;
    }

    public boolean performAction(int i, Bundle bundle) {
        enforceSealed();
        boolean flag;
        if(!canPerformRequestOverConnection(mSourceNodeId))
            flag = false;
        else
            flag = AccessibilityInteractionClient.getInstance().performAccessibilityAction(mConnectionId, mWindowId, mSourceNodeId, i, bundle);
        return flag;
    }

    public void recycle() {
        if(mIsInPool)
            throw new IllegalStateException("Info already recycled!");
        clear();
        Object obj = sPoolLock;
        obj;
        JVM INSTR monitorenter ;
        if(sPoolSize <= 50) {
            mNext = sPool;
            sPool = this;
            mIsInPool = true;
            sPoolSize = 1 + sPoolSize;
        }
        return;
    }

    public void setAccessibilityFocused(boolean flag) {
        setBooleanProperty(1024, flag);
    }

    public void setBoundsInParent(Rect rect) {
        enforceNotSealed();
        mBoundsInParent.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setBoundsInScreen(Rect rect) {
        enforceNotSealed();
        mBoundsInScreen.set(rect.left, rect.top, rect.right, rect.bottom);
        mBoundsInScreen.offset(mActualAndReportedWindowLeftDelta, mActualAndReportedWindowTopDelta);
    }

    public void setCheckable(boolean flag) {
        setBooleanProperty(1, flag);
    }

    public void setChecked(boolean flag) {
        setBooleanProperty(2, flag);
    }

    public void setClassName(CharSequence charsequence) {
        enforceNotSealed();
        mClassName = charsequence;
    }

    public void setClickable(boolean flag) {
        setBooleanProperty(32, flag);
    }

    public void setConnectionId(int i) {
        enforceNotSealed();
        mConnectionId = i;
    }

    public void setContentDescription(CharSequence charsequence) {
        enforceNotSealed();
        mContentDescription = charsequence;
    }

    public void setEnabled(boolean flag) {
        setBooleanProperty(128, flag);
    }

    public void setFocusable(boolean flag) {
        setBooleanProperty(4, flag);
    }

    public void setFocused(boolean flag) {
        setBooleanProperty(8, flag);
    }

    public void setLongClickable(boolean flag) {
        setBooleanProperty(64, flag);
    }

    public void setMovementGranularities(int i) {
        enforceNotSealed();
        mMovementGranularities = i;
    }

    public void setPackageName(CharSequence charsequence) {
        enforceNotSealed();
        mPackageName = charsequence;
    }

    public void setParent(View view) {
        setParent(view, -1);
    }

    public void setParent(View view, int i) {
        enforceNotSealed();
        int j;
        if(view != null)
            j = view.getAccessibilityViewId();
        else
            j = -1;
        mParentNodeId = makeNodeId(j, i);
    }

    public void setPassword(boolean flag) {
        setBooleanProperty(256, flag);
    }

    public void setScrollable(boolean flag) {
        enforceNotSealed();
        setBooleanProperty(512, flag);
    }

    public void setSealed(boolean flag) {
        mSealed = flag;
    }

    public void setSelected(boolean flag) {
        setBooleanProperty(16, flag);
    }

    public void setSource(View view) {
        setSource(view, -1);
    }

    public void setSource(View view, int i) {
        enforceNotSealed();
        int j;
        int k;
        if(view != null)
            j = view.getAccessibilityWindowId();
        else
            j = -1;
        mWindowId = j;
        if(view != null)
            k = view.getAccessibilityViewId();
        else
            k = -1;
        mSourceNodeId = makeNodeId(k, i);
        if(view != null) {
            mActualAndReportedWindowLeftDelta = view.getActualAndReportedWindowLeftDelta();
            mActualAndReportedWindowTopDelta = view.getActualAndReportedWindowTopDelta();
        }
    }

    public void setText(CharSequence charsequence) {
        enforceNotSealed();
        mText = charsequence;
    }

    public void setVisibleToUser(boolean flag) {
        setBooleanProperty(2048, flag);
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(super.toString());
        stringbuilder.append((new StringBuilder()).append("; boundsInParent: ").append(mBoundsInParent).toString());
        stringbuilder.append((new StringBuilder()).append("; boundsInScreen: ").append(mBoundsInScreen).toString());
        stringbuilder.append("; packageName: ").append(mPackageName);
        stringbuilder.append("; className: ").append(mClassName);
        stringbuilder.append("; text: ").append(mText);
        stringbuilder.append("; contentDescription: ").append(mContentDescription);
        stringbuilder.append("; checkable: ").append(isCheckable());
        stringbuilder.append("; checked: ").append(isChecked());
        stringbuilder.append("; focusable: ").append(isFocusable());
        stringbuilder.append("; focused: ").append(isFocused());
        stringbuilder.append("; selected: ").append(isSelected());
        stringbuilder.append("; clickable: ").append(isClickable());
        stringbuilder.append("; longClickable: ").append(isLongClickable());
        stringbuilder.append("; enabled: ").append(isEnabled());
        stringbuilder.append("; password: ").append(isPassword());
        stringbuilder.append((new StringBuilder()).append("; scrollable: ").append(isScrollable()).toString());
        stringbuilder.append("; [");
        int i = mActions;
        do {
            if(i == 0)
                break;
            int j = 1 << Integer.numberOfTrailingZeros(i);
            i &= ~j;
            stringbuilder.append(getActionSymbolicName(j));
            if(i != 0)
                stringbuilder.append(", ");
        } while(true);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j;
        SparseLongArray sparselongarray;
        int k;
        if(isSealed())
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        parcel.writeLong(mSourceNodeId);
        parcel.writeInt(mWindowId);
        parcel.writeLong(mParentNodeId);
        parcel.writeInt(mConnectionId);
        sparselongarray = mChildNodeIds;
        k = sparselongarray.size();
        parcel.writeInt(k);
        for(int l = 0; l < k; l++)
            parcel.writeLong(sparselongarray.valueAt(l));

        parcel.writeInt(mBoundsInParent.top);
        parcel.writeInt(mBoundsInParent.bottom);
        parcel.writeInt(mBoundsInParent.left);
        parcel.writeInt(mBoundsInParent.right);
        parcel.writeInt(mBoundsInScreen.top);
        parcel.writeInt(mBoundsInScreen.bottom);
        parcel.writeInt(mBoundsInScreen.left);
        parcel.writeInt(mBoundsInScreen.right);
        parcel.writeInt(mActions);
        parcel.writeInt(mMovementGranularities);
        parcel.writeInt(mBooleanProperties);
        parcel.writeCharSequence(mPackageName);
        parcel.writeCharSequence(mClassName);
        parcel.writeCharSequence(mText);
        parcel.writeCharSequence(mContentDescription);
        recycle();
    }

    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTIVE_WINDOW_ID = -1;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AccessibilityNodeInfo createFromParcel(Parcel parcel) {
            AccessibilityNodeInfo accessibilitynodeinfo = AccessibilityNodeInfo.obtain();
            accessibilitynodeinfo.initFromParcel(parcel);
            return accessibilitynodeinfo;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public AccessibilityNodeInfo[] newArray(int i) {
            return new AccessibilityNodeInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final boolean DEBUG = false;
    public static final int FLAG_PREFETCH_DESCENDANTS = 4;
    public static final int FLAG_PREFETCH_PREDECESSORS = 1;
    public static final int FLAG_PREFETCH_SIBLINGS = 2;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    public static final int INCLUDE_NOT_IMPORTANT_VIEWS = 8;
    private static final int MAX_POOL_SIZE = 50;
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private static final int PROPERTY_ACCESSIBILITY_FOCUSED = 1024;
    private static final int PROPERTY_CHECKABLE = 1;
    private static final int PROPERTY_CHECKED = 2;
    private static final int PROPERTY_CLICKABLE = 32;
    private static final int PROPERTY_ENABLED = 128;
    private static final int PROPERTY_FOCUSABLE = 4;
    private static final int PROPERTY_FOCUSED = 8;
    private static final int PROPERTY_LONG_CLICKABLE = 64;
    private static final int PROPERTY_PASSWORD = 256;
    private static final int PROPERTY_SCROLLABLE = 512;
    private static final int PROPERTY_SELECTED = 16;
    private static final int PROPERTY_VISIBLE_TO_USER = 2048;
    public static final long ROOT_NODE_ID = 0L;
    public static final int UNDEFINED = -1;
    private static final long VIRTUAL_DESCENDANT_ID_MASK = 0xffffffff00000000L;
    private static final int VIRTUAL_DESCENDANT_ID_SHIFT = 32;
    private static AccessibilityNodeInfo sPool;
    private static final Object sPoolLock = new Object();
    private static int sPoolSize;
    private int mActions;
    private int mActualAndReportedWindowLeftDelta;
    private int mActualAndReportedWindowTopDelta;
    private int mBooleanProperties;
    private final Rect mBoundsInParent = new Rect();
    private final Rect mBoundsInScreen = new Rect();
    private final SparseLongArray mChildNodeIds = new SparseLongArray();
    private CharSequence mClassName;
    private int mConnectionId;
    private CharSequence mContentDescription;
    private boolean mIsInPool;
    private int mMovementGranularities;
    private AccessibilityNodeInfo mNext;
    private CharSequence mPackageName;
    private long mParentNodeId;
    private boolean mSealed;
    private long mSourceNodeId;
    private CharSequence mText;
    private int mWindowId;

    static  {
        ROOT_NODE_ID = makeNodeId(-1, -1);
    }

}
