// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.ClipData;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.*;
import android.util.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityEventSource;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.ScrollBarDrawable;
import com.android.internal.util.Predicate;
import com.android.internal.view.menu.MenuBuilder;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package android.view:
//            InputEventConsistencyVerifier, ViewConfiguration, ViewParent, DisplayList, 
//            ViewGroup, ViewRootImpl, HardwareRenderer, HardwareCanvas, 
//            HardwareLayer, LayoutInflater, ViewPropertyAnimator, ViewTreeObserver, 
//            MotionEvent, KeyEvent, IWindowSession, WindowManagerImpl, 
//            Display, ViewDebug, TouchDelegate, Choreographer, 
//            Surface, ContextMenu, DragEvent, ActionMode, 
//            IWindow, AbsSavedState

public class View
    implements android.graphics.drawable.Drawable.Callback, android.graphics.drawable.Drawable.Callback2, KeyEvent.Callback, AccessibilityEventSource {
    public static class AccessibilityDelegate {

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent) {
            return view.dispatchPopulateAccessibilityEventInternal(accessibilityevent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent) {
            view.onInitializeAccessibilityEventInternal(accessibilityevent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilitynodeinfo) {
            view.onInitializeAccessibilityNodeInfoInternal(accessibilitynodeinfo);
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent) {
            view.onPopulateAccessibilityEventInternal(accessibilityevent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent) {
            return viewgroup.onRequestSendAccessibilityEventInternal(view, accessibilityevent);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return view.performAccessibilityActionInternal(i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            view.sendAccessibilityEventInternal(i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityevent) {
            view.sendAccessibilityEventUncheckedInternal(accessibilityevent);
        }

        public AccessibilityDelegate() {
        }
    }

    private class SendViewScrolledAccessibilityEvent
        implements Runnable {

        public void run() {
            sendAccessibilityEvent(4096);
            mIsPending = false;
        }

        public volatile boolean mIsPending;
        final View this$0;

        private SendViewScrolledAccessibilityEvent() {
            this$0 = View.this;
            super();
        }

    }

    private static class ScrollabilityCache
        implements Runnable {

        public void run() {
            long l = AnimationUtils.currentAnimationTimeMillis();
            if(l >= fadeStartTime) {
                int i = (int)l;
                Interpolator interpolator = scrollBarInterpolator;
                int j = 0 + 1;
                interpolator.setKeyFrame(0, i, OPAQUE);
                interpolator.setKeyFrame(j, i + scrollBarFadeDuration, TRANSPARENT);
                state = 2;
                host.invalidate(true);
            }
        }

        public void setFadeColor(int i) {
            if(i != 0 && i != mLastColor) {
                mLastColor = i;
                int j = i | 0xff000000;
                shader = new LinearGradient(0.0F, 0.0F, 0.0F, 1.0F, j | 0xff000000, j & 0xffffff, android.graphics.Shader.TileMode.CLAMP);
                paint.setShader(shader);
                paint.setXfermode(null);
            }
        }

        public static final int FADING = 2;
        public static final int OFF = 0;
        public static final int ON = 1;
        private static final float OPAQUE[];
        private static final float TRANSPARENT[];
        public boolean fadeScrollBars;
        public long fadeStartTime;
        public int fadingEdgeLength;
        public View host;
        public float interpolatorValues[];
        private int mLastColor;
        public final Matrix matrix = new Matrix();
        public final Paint paint = new Paint();
        public ScrollBarDrawable scrollBar;
        public int scrollBarDefaultDelayBeforeFade;
        public int scrollBarFadeDuration;
        public final Interpolator scrollBarInterpolator = new Interpolator(1, 2);
        public int scrollBarSize;
        public Shader shader;
        public int state;

        static  {
            float af[] = new float[1];
            af[0] = 255F;
            OPAQUE = af;
            float af1[] = new float[1];
            af1[0] = 0.0F;
            TRANSPARENT = af1;
        }

        public ScrollabilityCache(ViewConfiguration viewconfiguration, View view) {
            state = 0;
            fadingEdgeLength = viewconfiguration.getScaledFadingEdgeLength();
            scrollBarSize = viewconfiguration.getScaledScrollBarSize();
            scrollBarDefaultDelayBeforeFade = ViewConfiguration.getScrollDefaultDelay();
            scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration();
            shader = new LinearGradient(0.0F, 0.0F, 0.0F, 1.0F, 0xff000000, 0, android.graphics.Shader.TileMode.CLAMP);
            paint.setShader(shader);
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
            host = view;
        }
    }

    static class AttachInfo {
        static class InvalidateInfo
            implements Poolable {

            static InvalidateInfo acquire() {
                return (InvalidateInfo)sPool.acquire();
            }

            public InvalidateInfo getNextPoolable() {
                return mNext;
            }

            public volatile Object getNextPoolable() {
                return getNextPoolable();
            }

            public boolean isPooled() {
                return mIsPooled;
            }

            void release() {
                sPool.release(this);
            }

            public void setNextPoolable(InvalidateInfo invalidateinfo) {
                mNext = invalidateinfo;
            }

            public volatile void setNextPoolable(Object obj) {
                setNextPoolable((InvalidateInfo)obj);
            }

            public void setPooled(boolean flag) {
                mIsPooled = flag;
            }

            private static final int POOL_LIMIT = 10;
            private static final Pool sPool = Pools.synchronizedPool(Pools.finitePool(new PoolableManager() {

                public volatile Poolable newInstance() {
                    return newInstance();
                }

                public InvalidateInfo newInstance() {
                    return new InvalidateInfo();
                }

                public volatile void onAcquired(Poolable poolable) {
                    onAcquired((InvalidateInfo)poolable);
                }

                public void onAcquired(InvalidateInfo invalidateinfo) {
                }

                public volatile void onReleased(Poolable poolable) {
                    onReleased((InvalidateInfo)poolable);
                }

                public void onReleased(InvalidateInfo invalidateinfo) {
                    invalidateinfo.target = null;
                }

            }, 10));
            int bottom;
            int left;
            private boolean mIsPooled;
            private InvalidateInfo mNext;
            int right;
            View target;
            int top;


            InvalidateInfo() {
            }
        }

        static interface Callbacks {

            public abstract boolean performHapticFeedback(int i, boolean flag);

            public abstract void playSoundEffect(int i);
        }


        Drawable mAccessibilityFocusDrawable;
        int mAccessibilityWindowId;
        int mActualWindowLeft;
        int mActualWindowTop;
        float mApplicationScale;
        Canvas mCanvas;
        final Rect mContentInsets = new Rect();
        boolean mDebugLayout;
        int mDisabledSystemUiVisibility;
        long mDrawingTime;
        boolean mForceReportNewAttributes;
        final ViewTreeObserver.InternalInsetsInfo mGivenInternalInsets = new ViewTreeObserver.InternalInsetsInfo();
        int mGlobalSystemUiVisibility;
        final Handler mHandler;
        boolean mHardwareAccelerated;
        boolean mHardwareAccelerationRequested;
        HardwareCanvas mHardwareCanvas;
        HardwareRenderer mHardwareRenderer;
        boolean mHasSystemUiListeners;
        boolean mHasWindowFocus;
        boolean mIgnoreDirtyState;
        boolean mInTouchMode;
        boolean mIncludeNotImportantViews;
        final int mInvalidateChildLocation[] = new int[2];
        boolean mKeepScreenOn;
        final KeyEvent.DispatcherState mKeyDispatchState = new KeyEvent.DispatcherState();
        IBinder mPanelParentWindowToken;
        final Point mPoint = new Point();
        boolean mRecomputeGlobalAttributes;
        final Callbacks mRootCallbacks;
        View mRootView;
        boolean mScalingRequired;
        boolean mScreenOn;
        final ArrayList mScrollContainers = new ArrayList();
        final IWindowSession mSession;
        boolean mSetIgnoreDirtyState;
        Surface mSurface;
        int mSystemUiVisibility;
        final ArrayList mTempArrayList = new ArrayList(24);
        final Rect mTmpInvalRect = new Rect();
        final float mTmpTransformLocation[] = new float[2];
        final RectF mTmpTransformRect = new RectF();
        final int mTransparentLocation[] = new int[2];
        final ViewTreeObserver mTreeObserver = new ViewTreeObserver();
        boolean mTurnOffWindowResizeAnim;
        boolean mUse32BitDrawingCache;
        final ViewRootImpl mViewRootImpl;
        boolean mViewScrollChanged;
        boolean mViewVisibilityChanged;
        final Rect mVisibleInsets = new Rect();
        final IWindow mWindow;
        int mWindowLeft;
        final IBinder mWindowToken;
        int mWindowTop;
        int mWindowVisibility;

        AttachInfo(IWindowSession iwindowsession, IWindow iwindow, ViewRootImpl viewrootimpl, Handler handler, Callbacks callbacks) {
            mSetIgnoreDirtyState = false;
            mAccessibilityWindowId = -1;
            mDebugLayout = SystemProperties.getBoolean("debug.layout", false);
            mSession = iwindowsession;
            mWindow = iwindow;
            mWindowToken = iwindow.asBinder();
            mViewRootImpl = viewrootimpl;
            mHandler = handler;
            mRootCallbacks = callbacks;
        }
    }

    public static class BaseSavedState extends AbsSavedState {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public BaseSavedState[] newArray(int i) {
                return new BaseSavedState[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };


        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private final class UnsetPressedState
        implements Runnable {

        public void run() {
            setPressed(false);
        }

        final View this$0;

        private UnsetPressedState() {
            this$0 = View.this;
            super();
        }

    }

    public static interface OnAttachStateChangeListener {

        public abstract void onViewAttachedToWindow(View view);

        public abstract void onViewDetachedFromWindow(View view);
    }

    public static interface OnSystemUiVisibilityChangeListener {

        public abstract void onSystemUiVisibilityChange(int i);
    }

    public static interface OnCreateContextMenuListener {

        public abstract void onCreateContextMenu(ContextMenu contextmenu, View view, ContextMenu.ContextMenuInfo contextmenuinfo);
    }

    public static interface OnClickListener {

        public abstract void onClick(View view);
    }

    public static interface OnFocusChangeListener {

        public abstract void onFocusChange(View view, boolean flag);
    }

    public static interface OnDragListener {

        public abstract boolean onDrag(View view, DragEvent dragevent);
    }

    public static interface OnLongClickListener {

        public abstract boolean onLongClick(View view);
    }

    public static interface OnGenericMotionListener {

        public abstract boolean onGenericMotion(View view, MotionEvent motionevent);
    }

    public static interface OnHoverListener {

        public abstract boolean onHover(View view, MotionEvent motionevent);
    }

    public static interface OnTouchListener {

        public abstract boolean onTouch(View view, MotionEvent motionevent);
    }

    public static interface OnKeyListener {

        public abstract boolean onKey(View view, int i, KeyEvent keyevent);
    }

    private final class PerformClick
        implements Runnable {

        public void run() {
            performClick();
        }

        final View this$0;

        private PerformClick() {
            this$0 = View.this;
            super();
        }

    }

    private final class CheckForTap
        implements Runnable {

        public void run() {
            View view = View.this;
            view.mPrivateFlags = 0xfdffffff & view.mPrivateFlags;
            setPressed(true);
            checkForLongClick(ViewConfiguration.getTapTimeout());
        }

        final View this$0;

        private CheckForTap() {
            this$0 = View.this;
            super();
        }

    }

    class CheckForLongPress
        implements Runnable {

        public void rememberWindowAttachCount() {
            mOriginalWindowAttachCount = mWindowAttachCount;
        }

        public void run() {
            if(isPressed() && mParent != null && mOriginalWindowAttachCount == mWindowAttachCount && performLongClick())
                mHasPerformedLongPress = true;
        }

        private int mOriginalWindowAttachCount;
        final View this$0;

        CheckForLongPress() {
            this$0 = View.this;
            super();
        }
    }

    public static class MeasureSpec {

        public static int getMode(int i) {
            return 0xc0000000 & i;
        }

        public static int getSize(int i) {
            return 0x3fffffff & i;
        }

        public static int makeMeasureSpec(int i, int j) {
            return i + j;
        }

        public static String toString(int i) {
            int j = getMode(i);
            int k = getSize(i);
            StringBuilder stringbuilder = new StringBuilder("MeasureSpec: ");
            if(j == 0)
                stringbuilder.append("UNSPECIFIED ");
            else
            if(j == 0x40000000)
                stringbuilder.append("EXACTLY ");
            else
            if(j == 0x80000000)
                stringbuilder.append("AT_MOST ");
            else
                stringbuilder.append(j).append(" ");
            stringbuilder.append(k);
            return stringbuilder.toString();
        }

        public static final int AT_MOST = 0x80000000;
        public static final int EXACTLY = 0x40000000;
        private static final int MODE_MASK = 0xc0000000;
        private static final int MODE_SHIFT = 30;
        public static final int UNSPECIFIED;

        public MeasureSpec() {
        }
    }

    public static class DragShadowBuilder {

        public final View getView() {
            return (View)mView.get();
        }

        public void onDrawShadow(Canvas canvas) {
            View view = (View)mView.get();
            if(view != null)
                view.draw(canvas);
            else
                Log.e("View", "Asked to draw drag shadow but no view");
        }

        public void onProvideShadowMetrics(Point point, Point point1) {
            View view = (View)mView.get();
            if(view != null) {
                point.set(view.getWidth(), view.getHeight());
                point1.set(point.x / 2, point.y / 2);
            } else {
                Log.e("View", "Asked for drag thumb metrics but no view");
            }
        }

        private final WeakReference mView;

        public DragShadowBuilder() {
            mView = new WeakReference(null);
        }

        public DragShadowBuilder(View view) {
            mView = new WeakReference(view);
        }
    }

    public static interface OnLayoutChangeListener {

        public abstract void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
                int k1, int l1);
    }

    static class ListenerInfo {

        private CopyOnWriteArrayList mOnAttachStateChangeListeners;
        public OnClickListener mOnClickListener;
        protected OnCreateContextMenuListener mOnCreateContextMenuListener;
        private OnDragListener mOnDragListener;
        protected OnFocusChangeListener mOnFocusChangeListener;
        private OnGenericMotionListener mOnGenericMotionListener;
        private OnHoverListener mOnHoverListener;
        private OnKeyListener mOnKeyListener;
        private ArrayList mOnLayoutChangeListeners;
        protected OnLongClickListener mOnLongClickListener;
        private OnSystemUiVisibilityChangeListener mOnSystemUiVisibilityChangeListener;
        private OnTouchListener mOnTouchListener;



/*
        static ArrayList access$002(ListenerInfo listenerinfo, ArrayList arraylist) {
            listenerinfo.mOnLayoutChangeListeners = arraylist;
            return arraylist;
        }

*/



/*
        static CopyOnWriteArrayList access$102(ListenerInfo listenerinfo, CopyOnWriteArrayList copyonwritearraylist) {
            listenerinfo.mOnAttachStateChangeListeners = copyonwritearraylist;
            return copyonwritearraylist;
        }

*/



/*
        static OnKeyListener access$202(ListenerInfo listenerinfo, OnKeyListener onkeylistener) {
            listenerinfo.mOnKeyListener = onkeylistener;
            return onkeylistener;
        }

*/



/*
        static OnTouchListener access$302(ListenerInfo listenerinfo, OnTouchListener ontouchlistener) {
            listenerinfo.mOnTouchListener = ontouchlistener;
            return ontouchlistener;
        }

*/



/*
        static OnGenericMotionListener access$402(ListenerInfo listenerinfo, OnGenericMotionListener ongenericmotionlistener) {
            listenerinfo.mOnGenericMotionListener = ongenericmotionlistener;
            return ongenericmotionlistener;
        }

*/



/*
        static OnHoverListener access$502(ListenerInfo listenerinfo, OnHoverListener onhoverlistener) {
            listenerinfo.mOnHoverListener = onhoverlistener;
            return onhoverlistener;
        }

*/



/*
        static OnDragListener access$602(ListenerInfo listenerinfo, OnDragListener ondraglistener) {
            listenerinfo.mOnDragListener = ondraglistener;
            return ondraglistener;
        }

*/



/*
        static OnSystemUiVisibilityChangeListener access$702(ListenerInfo listenerinfo, OnSystemUiVisibilityChangeListener onsystemuivisibilitychangelistener) {
            listenerinfo.mOnSystemUiVisibilityChangeListener = onsystemuivisibilitychangelistener;
            return onsystemuivisibilitychangelistener;
        }

*/

        ListenerInfo() {
        }
    }

    static class TransformationInfo {

        float mAlpha;
        private Camera mCamera;
        private Matrix mInverseMatrix;
        private boolean mInverseMatrixDirty;
        private final Matrix mMatrix = new Matrix();
        boolean mMatrixDirty;
        private boolean mMatrixIsIdentity;
        float mPivotX;
        float mPivotY;
        private int mPrevHeight;
        private int mPrevWidth;
        float mRotation;
        float mRotationX;
        float mRotationY;
        float mScaleX;
        float mScaleY;
        float mTranslationX;
        float mTranslationY;
        private Matrix matrix3D;




/*
        static boolean access$1202(TransformationInfo transformationinfo, boolean flag) {
            transformationinfo.mMatrixIsIdentity = flag;
            return flag;
        }

*/



/*
        static int access$1302(TransformationInfo transformationinfo, int i) {
            transformationinfo.mPrevWidth = i;
            return i;
        }

*/



/*
        static int access$1402(TransformationInfo transformationinfo, int i) {
            transformationinfo.mPrevHeight = i;
            return i;
        }

*/



/*
        static Camera access$1502(TransformationInfo transformationinfo, Camera camera) {
            transformationinfo.mCamera = camera;
            return camera;
        }

*/



/*
        static Matrix access$1602(TransformationInfo transformationinfo, Matrix matrix) {
            transformationinfo.matrix3D = matrix;
            return matrix;
        }

*/



/*
        static boolean access$1702(TransformationInfo transformationinfo, boolean flag) {
            transformationinfo.mInverseMatrixDirty = flag;
            return flag;
        }

*/



/*
        static Matrix access$1802(TransformationInfo transformationinfo, Matrix matrix) {
            transformationinfo.mInverseMatrix = matrix;
            return matrix;
        }

*/

        TransformationInfo() {
            mMatrixDirty = false;
            mInverseMatrixDirty = true;
            mMatrixIsIdentity = true;
            mCamera = null;
            matrix3D = null;
            mPrevWidth = -1;
            mPrevHeight = -1;
            mRotationY = 0.0F;
            mRotationX = 0.0F;
            mRotation = 0.0F;
            mTranslationX = 0.0F;
            mTranslationY = 0.0F;
            mScaleX = 1.0F;
            mScaleY = 1.0F;
            mPivotX = 0.0F;
            mPivotY = 0.0F;
            mAlpha = 1.0F;
        }
    }

    static class Injector {

        static boolean isHapticEnabledExplictly(View view, int i) {
            boolean flag;
            if((i & 4) != 0 && !view.mHapticEnabledExplicitly)
                flag = false;
            else
                flag = true;
            return flag;
        }

        static void performHapticFeedbackOnDown(View view) {
            view.performHapticFeedback(1, 4);
        }

        static void performHapticFeedbackOnRelease(View view) {
            view.performHapticFeedback(2, 4);
        }

        Injector() {
        }
    }


    View() {
        mCurrentAnimation = null;
        mRecreateDisplayList = false;
        mID = -1;
        mAccessibilityViewId = -1;
        mAccessibilityCursorPosition = -1;
        mTransientStateCount = 0;
        mOldWidthMeasureSpec = 0x80000000;
        mOldHeightMeasureSpec = 0x80000000;
        mDrawableState = null;
        mNextFocusLeftId = -1;
        mNextFocusRightId = -1;
        mNextFocusUpId = -1;
        mNextFocusDownId = -1;
        mNextFocusForwardId = -1;
        mPendingCheckForTap = null;
        mTouchDelegate = null;
        mDrawingCacheBackgroundColor = 0;
        mAnimator = null;
        mLayerType = 0;
        InputEventConsistencyVerifier inputeventconsistencyverifier;
        if(InputEventConsistencyVerifier.isInstrumentationEnabled())
            inputeventconsistencyverifier = new InputEventConsistencyVerifier(this, 0);
        else
            inputeventconsistencyverifier = null;
        mInputEventConsistencyVerifier = inputeventconsistencyverifier;
        mAdditionalState = 0;
        mResources = null;
    }

    public View(Context context) {
        Resources resources = null;
        super();
        mCurrentAnimation = null;
        mRecreateDisplayList = false;
        mID = -1;
        mAccessibilityViewId = -1;
        mAccessibilityCursorPosition = -1;
        mTransientStateCount = 0;
        mOldWidthMeasureSpec = 0x80000000;
        mOldHeightMeasureSpec = 0x80000000;
        mDrawableState = null;
        mNextFocusLeftId = -1;
        mNextFocusRightId = -1;
        mNextFocusUpId = -1;
        mNextFocusDownId = -1;
        mNextFocusForwardId = -1;
        mPendingCheckForTap = null;
        mTouchDelegate = null;
        mDrawingCacheBackgroundColor = 0;
        mAnimator = null;
        mLayerType = 0;
        InputEventConsistencyVerifier inputeventconsistencyverifier;
        if(InputEventConsistencyVerifier.isInstrumentationEnabled())
            inputeventconsistencyverifier = new InputEventConsistencyVerifier(this, 0);
        else
            inputeventconsistencyverifier = null;
        mInputEventConsistencyVerifier = inputeventconsistencyverifier;
        mAdditionalState = 0;
        mContext = context;
        if(context != null)
            resources = context.getResources();
        mResources = resources;
        mViewFlags = 0x18000000;
        mPrivateFlags2 = 0 | (0 | (8 | TEXT_DIRECTION_DEFAULT << 6 | TEXT_ALIGNMENT_DEFAULT << 13));
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setOverScrollMode(1);
        mUserPaddingStart = -1;
        mUserPaddingEnd = -1;
        mUserPaddingRelative = false;
    }

    public View(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public View(Context context, AttributeSet attributeset, int i) {
        TypedArray typedarray;
        Drawable drawable;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        boolean flag;
        int k2;
        int l2;
        float f;
        float f1;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        boolean flag1;
        int i3;
        int j3;
        int k3;
        int l3;
        this(context);
        typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.View, i, 0);
        drawable = null;
        j = -1;
        k = -1;
        l = -1;
        i1 = -1;
        j1 = -1;
        k1 = -1;
        l1 = -1;
        i2 = 0;
        j2 = 0;
        flag = false;
        k2 = 0;
        l2 = 0;
        f = 0.0F;
        f1 = 0.0F;
        f2 = 0.0F;
        f3 = 0.0F;
        f4 = 0.0F;
        f5 = 1.0F;
        f6 = 1.0F;
        flag1 = false;
        i3 = 0;
        j3 = mOverScrollMode;
        k3 = typedarray.getIndexCount();
        l3 = 0;
_L58:
        int i4;
        if(l3 >= k3)
            break MISSING_BLOCK_LABEL_1643;
        i4 = typedarray.getIndex(l3);
        i4;
        JVM INSTR tableswitch 7 66: default 380
    //                   7 1214
    //                   8 683
    //                   9 699
    //                   10 496
    //                   11 509
    //                   12 386
    //                   13 398
    //                   14 412
    //                   15 426
    //                   16 440
    //                   17 454
    //                   18 739
    //                   19 765
    //                   20 909
    //                   21 713
    //                   22 1124
    //                   23 1163
    //                   24 380
    //                   25 1331
    //                   26 1347
    //                   27 1363
    //                   28 1379
    //                   29 795
    //                   30 825
    //                   31 853
    //                   32 1004
    //                   33 881
    //                   34 1411
    //                   35 1426
    //                   36 1054
    //                   37 1273
    //                   38 1251
    //                   39 1083
    //                   40 1441
    //                   41 1040
    //                   42 380
    //                   43 380
    //                   44 380
    //                   45 1494
    //                   46 1301
    //                   47 522
    //                   48 537
    //                   49 553
    //                   50 569
    //                   51 586
    //                   52 651
    //                   53 667
    //                   54 603
    //                   55 619
    //                   56 635
    //                   57 1507
    //                   58 1395
    //                   59 1522
    //                   60 1175
    //                   61 1628
    //                   62 468
    //                   63 482
    //                   64 945
    //                   65 1538
    //                   66 1586;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L1 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L1 _L1 _L1 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57
_L1:
        break; /* Loop/switch isn't completed */
_L52:
        break MISSING_BLOCK_LABEL_1628;
_L59:
        l3++;
          goto _L58
_L7:
        drawable = typedarray.getDrawable(i4);
          goto _L59
_L8:
        l1 = typedarray.getDimensionPixelSize(i4, -1);
          goto _L59
_L9:
        j = typedarray.getDimensionPixelSize(i4, -1);
          goto _L59
_L10:
        k = typedarray.getDimensionPixelSize(i4, -1);
          goto _L59
_L11:
        l = typedarray.getDimensionPixelSize(i4, -1);
          goto _L59
_L12:
        i1 = typedarray.getDimensionPixelSize(i4, -1);
          goto _L59
_L53:
        j1 = typedarray.getDimensionPixelSize(i4, -1);
          goto _L59
_L54:
        k1 = typedarray.getDimensionPixelSize(i4, -1);
          goto _L59
_L5:
        k2 = typedarray.getDimensionPixelOffset(i4, 0);
          goto _L59
_L6:
        l2 = typedarray.getDimensionPixelOffset(i4, 0);
          goto _L59
_L38:
        setAlpha(typedarray.getFloat(i4, 1.0F));
          goto _L59
_L39:
        setPivotX(typedarray.getDimensionPixelOffset(i4, 0));
          goto _L59
_L40:
        setPivotY(typedarray.getDimensionPixelOffset(i4, 0));
          goto _L59
_L41:
        f = typedarray.getDimensionPixelOffset(i4, 0);
        flag1 = true;
          goto _L59
_L42:
        f1 = typedarray.getDimensionPixelOffset(i4, 0);
        flag1 = true;
          goto _L59
_L45:
        f2 = typedarray.getFloat(i4, 0.0F);
        flag1 = true;
          goto _L59
_L46:
        f3 = typedarray.getFloat(i4, 0.0F);
        flag1 = true;
          goto _L59
_L47:
        f4 = typedarray.getFloat(i4, 0.0F);
        flag1 = true;
          goto _L59
_L43:
        f5 = typedarray.getFloat(i4, 1.0F);
        flag1 = true;
          goto _L59
_L44:
        f6 = typedarray.getFloat(i4, 1.0F);
        flag1 = true;
          goto _L59
_L3:
        mID = typedarray.getResourceId(i4, -1);
          goto _L59
_L4:
        mTag = typedarray.getText(i4);
          goto _L59
_L16:
        if(typedarray.getBoolean(i4, false)) {
            i2 |= 2;
            j2 |= 2;
        }
          goto _L59
_L13:
        if(typedarray.getBoolean(i4, false)) {
            i2 |= 1;
            j2 |= 1;
        }
          goto _L59
_L14:
        if(typedarray.getBoolean(i4, false)) {
            i2 |= 0x40001;
            j2 |= 0x40001;
        }
          goto _L59
_L23:
        if(typedarray.getBoolean(i4, false)) {
            i2 = 0x4000 | i2;
            j2 = 0x4000 | j2;
        }
          goto _L59
_L24:
        if(typedarray.getBoolean(i4, false)) {
            i2 |= 0x200000;
            j2 |= 0x200000;
        }
          goto _L59
_L25:
        if(!typedarray.getBoolean(i4, true)) {
            i2 |= 0x10000;
            j2 |= 0x10000;
        }
          goto _L59
_L27:
        if(typedarray.getBoolean(i4, false)) {
            i2 |= 0x400000;
            j2 |= 0x400000;
        }
          goto _L59
_L15:
        int i6 = typedarray.getInt(i4, 0);
        if(i6 != 0) {
            i2 |= VISIBILITY_FLAGS[i6];
            j2 |= 0xc;
        }
          goto _L59
_L55:
        mPrivateFlags2 = 0xffffffc3 & mPrivateFlags2;
        int k5 = typedarray.getInt(i4, -1);
        int l5;
        if(k5 != -1)
            l5 = LAYOUT_DIRECTION_FLAGS[k5];
        else
            l5 = 2;
        mPrivateFlags2 = mPrivateFlags2 | l5 << 2;
          goto _L59
_L26:
        int j5 = typedarray.getInt(i4, 0);
        if(j5 != 0) {
            i2 |= DRAWING_CACHE_QUALITY_FLAGS[j5];
            j2 |= 0x180000;
        }
          goto _L59
_L35:
        setContentDescription(typedarray.getString(i4));
          goto _L59
_L30:
        if(!typedarray.getBoolean(i4, true)) {
            i2 &= 0xf7ffffff;
            j2 |= 0x8000000;
        }
          goto _L59
_L33:
        mHapticEnabledExplicitly = typedarray.getBoolean(i4, false);
        if(!typedarray.getBoolean(i4, true)) {
            i2 &= 0xefffffff;
            j2 |= 0x10000000;
        }
          goto _L59
_L17:
        int i5 = typedarray.getInt(i4, 0);
        if(i5 != 0) {
            i2 |= i5;
            j2 = 0x300 | j2;
            initializeScrollbars(typedarray);
        }
          goto _L59
_L18:
        if(context.getApplicationInfo().targetSdkVersion >= 14) goto _L59; else goto _L51
_L51:
        int l4 = typedarray.getInt(i4, 0);
        if(l4 != 0) {
            i2 |= l4;
            j2 = 0x3000 | j2;
            initializeFadingEdge(typedarray);
        }
          goto _L59
_L2:
        i3 = typedarray.getInt(i4, 0);
        if(i3 != 0) {
            i2 |= 0x3000000 & i3;
            j2 |= 0x3000000;
        }
          goto _L59
_L32:
        flag = true;
        if(typedarray.getBoolean(i4, false))
            setScrollContainer(true);
          goto _L59
_L31:
        if(typedarray.getBoolean(i4, false)) {
            i2 |= 0x4000000;
            j2 |= 0x4000000;
        }
          goto _L59
_L37:
        if(typedarray.getBoolean(i4, false)) {
            i2 = 0x400 | i2;
            j2 = 0x400 | j2;
        }
          goto _L59
_L19:
        mNextFocusLeftId = typedarray.getResourceId(i4, -1);
          goto _L59
_L20:
        mNextFocusRightId = typedarray.getResourceId(i4, -1);
          goto _L59
_L21:
        mNextFocusUpId = typedarray.getResourceId(i4, -1);
          goto _L59
_L22:
        mNextFocusDownId = typedarray.getResourceId(i4, -1);
          goto _L59
_L49:
        mNextFocusForwardId = typedarray.getResourceId(i4, -1);
          goto _L59
_L28:
        mMinWidth = typedarray.getDimensionPixelSize(i4, 0);
          goto _L59
_L29:
        mMinHeight = typedarray.getDimensionPixelSize(i4, 0);
          goto _L59
_L34:
        if(context.isRestricted())
            throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        final String handlerName = typedarray.getString(i4);
        if(handlerName != null) {
            OnClickListener onclicklistener = new OnClickListener() {

                public void onClick(View view) {
                    if(mHandler == null)
                        try {
                            Class class1 = getContext().getClass();
                            String s1 = handlerName;
                            Class aclass[] = new Class[1];
                            aclass[0] = android/view/View;
                            mHandler = class1.getMethod(s1, aclass);
                        }
                        catch(NoSuchMethodException nosuchmethodexception) {
                            int j6 = getId();
                            String s;
                            if(j6 == -1)
                                s = "";
                            else
                                s = (new StringBuilder()).append(" with id '").append(getContext().getResources().getResourceEntryName(j6)).append("'").toString();
                            throw new IllegalStateException((new StringBuilder()).append("Could not find a method ").append(handlerName).append("(View) in the activity ").append(getContext().getClass()).append(" for onClick handler").append(" on view ").append(getClass()).append(s).toString(), nosuchmethodexception);
                        }
                    try {
                        Method method = mHandler;
                        Context context1 = getContext();
                        Object aobj[] = new Object[1];
                        aobj[0] = View.this;
                        method.invoke(context1, aobj);
                        return;
                    }
                    catch(IllegalAccessException illegalaccessexception) {
                        throw new IllegalStateException("Could not execute non public method of the activity", illegalaccessexception);
                    }
                    catch(InvocationTargetException invocationtargetexception) {
                        throw new IllegalStateException("Could not execute method of the activity", invocationtargetexception);
                    }
                }

                private Method mHandler;
                final View this$0;
                final String val$handlerName;

             {
                this$0 = View.this;
                handlerName = s;
                super();
            }
            };
            setOnClickListener(onclicklistener);
        }
          goto _L59
_L36:
        j3 = typedarray.getInt(i4, 1);
          goto _L59
_L48:
        mVerticalScrollbarPosition = typedarray.getInt(i4, 0);
          goto _L59
_L50:
        setLayerType(typedarray.getInt(i4, 0), null);
          goto _L59
_L56:
        mPrivateFlags2 = 0xfffffe3f & mPrivateFlags2;
        int k4 = typedarray.getInt(i4, -1);
        if(k4 != -1)
            mPrivateFlags2 = mPrivateFlags2 | TEXT_DIRECTION_FLAGS[k4];
          goto _L59
_L57:
        mPrivateFlags2 = 0xffff1fff & mPrivateFlags2;
        int j4 = typedarray.getInt(i4, TEXT_ALIGNMENT_DEFAULT);
        mPrivateFlags2 = mPrivateFlags2 | TEXT_ALIGNMENT_FLAGS[j4];
          goto _L59
        setImportantForAccessibility(typedarray.getInt(i4, 0));
          goto _L59
        typedarray.recycle();
        setOverScrollMode(j3);
        if(drawable != null)
            setBackground(drawable);
        mUserPaddingStart = j1;
        mUserPaddingEnd = k1;
        updateUserPaddingRelative();
        if(l1 >= 0) {
            j = l1;
            k = l1;
            l = l1;
            i1 = l1;
        }
        if(j < 0)
            j = mPaddingLeft;
        if(k < 0)
            k = mPaddingTop;
        if(l < 0)
            l = mPaddingRight;
        if(i1 < 0)
            i1 = mPaddingBottom;
        setPadding(j, k, l, i1);
        if(j2 != 0)
            setFlags(i2, j2);
        if(i3 != 0)
            recomputePadding();
        if(k2 != 0 || l2 != 0)
            scrollTo(k2, l2);
        if(flag1) {
            setTranslationX(f);
            setTranslationY(f1);
            setRotation(f2);
            setRotationX(f3);
            setRotationY(f4);
            setScaleX(f5);
            setScaleY(f6);
        }
        if(!flag && (0x200 & i2) != 0)
            setScrollContainer(true);
        computeOpaqueFlags();
        return;
    }

    private boolean canTakeAccessibilityFocusFromHover() {
        boolean flag = true;
        if(!includeForAccessibility() || !isActionableForAccessibility()) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(mParent != null) {
            if(mParent.findViewToTakeAccessibilityFocusFromHover(this, this) != this)
                flag = false;
        } else {
            flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void checkForLongClick(int i) {
        if((0x200000 & mViewFlags) == 0x200000) {
            mHasPerformedLongPress = false;
            if(mPendingCheckForLongPress == null)
                mPendingCheckForLongPress = new CheckForLongPress();
            mPendingCheckForLongPress.rememberWindowAttachCount();
            postDelayed(mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout() - i);
        }
    }

    private void clearDisplayList() {
        if(mDisplayList != null) {
            mDisplayList.invalidate();
            mDisplayList.clear();
        }
    }

    public static int combineMeasuredStates(int i, int j) {
        return i | j;
    }

    protected static String debugIndent(int i) {
        StringBuilder stringbuilder = new StringBuilder(2 * (3 + i * 2));
        for(int j = 0; j < 3 + i * 2; j++)
            stringbuilder.append(' ').append(' ');

        return stringbuilder.toString();
    }

    private boolean dispatchGenericMotionEventInternal(MotionEvent motionevent) {
        boolean flag;
        ListenerInfo listenerinfo;
        flag = true;
        listenerinfo = mListenerInfo;
        break MISSING_BLOCK_LABEL_7;
        if((listenerinfo == null || listenerinfo.mOnGenericMotionListener == null || (0x20 & mViewFlags) != 0 || !listenerinfo.mOnGenericMotionListener.onGenericMotion(this, motionevent)) && !onGenericMotionEvent(motionevent)) {
            if(mInputEventConsistencyVerifier != null)
                mInputEventConsistencyVerifier.onUnhandledEvent(motionevent, 0);
            flag = false;
        }
        return flag;
    }

    private boolean drawAnimation(ViewGroup viewgroup, long l, Animation animation, boolean flag) {
        int i;
        Transformation transformation;
        i = viewgroup.mGroupFlags;
        if(!animation.isInitialized()) {
            animation.initialize(mRight - mLeft, mBottom - mTop, viewgroup.getWidth(), viewgroup.getHeight());
            animation.initializeInvalidateRegion(0, 0, mRight - mLeft, mBottom - mTop);
            if(mAttachInfo != null)
                animation.setListenerHandler(mAttachInfo.mHandler);
            onAnimationStart();
        }
        boolean flag1 = animation.getTransformation(l, viewgroup.mChildTransformation, 1.0F);
        if(flag && mAttachInfo.mApplicationScale != 1.0F) {
            if(viewgroup.mInvalidationTransformation == null)
                viewgroup.mInvalidationTransformation = new Transformation();
            transformation = viewgroup.mInvalidationTransformation;
            animation.getTransformation(l, transformation, 1.0F);
        } else {
            transformation = viewgroup.mChildTransformation;
        }
        if(!flag1) goto _L2; else goto _L1
_L1:
        if(animation.willChangeBounds()) goto _L4; else goto _L3
_L3:
        if((i & 0x90) != 128) goto _L6; else goto _L5
_L5:
        viewgroup.mGroupFlags = 4 | viewgroup.mGroupFlags;
_L2:
        return flag1;
_L6:
        if((i & 4) == 0) {
            viewgroup.mPrivateFlags = 0x40 | ((View) (viewgroup)).mPrivateFlags;
            viewgroup.invalidate(mLeft, mTop, mRight, mBottom);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if(viewgroup.mInvalidateRegion == null)
            viewgroup.mInvalidateRegion = new RectF();
        RectF rectf = viewgroup.mInvalidateRegion;
        animation.getInvalidateRegion(0, 0, mRight - mLeft, mBottom - mTop, rectf, transformation);
        viewgroup.mPrivateFlags = 0x40 | ((View) (viewgroup)).mPrivateFlags;
        int j = mLeft + (int)rectf.left;
        int k = mTop + (int)rectf.top;
        viewgroup.invalidate(j, k, j + (int)(0.5F + rectf.width()), k + (int)(0.5F + rectf.height()));
        if(true) goto _L2; else goto _L7
_L7:
    }

    private View findViewInsideOutShouldExist(View view, final int childViewId) {
        View view1 = view.findViewByPredicateInsideOut(this, new Predicate() {

            public boolean apply(View view2) {
                boolean flag;
                if(view2.mID == childViewId)
                    flag = true;
                else
                    flag = false;
                return flag;
            }

            public volatile boolean apply(Object obj) {
                return apply((View)obj);
            }

            final View this$0;
            final int val$childViewId;

             {
                this$0 = View.this;
                childViewId = i;
                super();
            }
        });
        if(view1 == null)
            Log.w("View", (new StringBuilder()).append("couldn't find next focus view specified by user for id ").append(childViewId).toString());
        return view1;
    }

    private void getBoundsOnScreen(Rect rect) {
        if(mAttachInfo != null) {
            RectF rectf = mAttachInfo.mTmpTransformRect;
            rectf.set(0.0F, 0.0F, mRight - mLeft, mBottom - mTop);
            if(!hasIdentityMatrix())
                getMatrix().mapRect(rectf);
            rectf.offset(mLeft, mTop);
            ViewParent viewparent;
            View view;
            for(viewparent = mParent; viewparent instanceof View; viewparent = view.mParent) {
                view = (View)viewparent;
                rectf.offset(-view.mScrollX, -view.mScrollY);
                if(!view.hasIdentityMatrix())
                    view.getMatrix().mapRect(rectf);
                rectf.offset(view.mLeft, view.mTop);
            }

            if(viewparent instanceof ViewRootImpl)
                rectf.offset(0.0F, -((ViewRootImpl)viewparent).mCurScrollY);
            rectf.offset(mAttachInfo.mWindowLeft, mAttachInfo.mWindowTop);
            rect.set((int)(0.5F + rectf.left), (int)(0.5F + rectf.top), (int)(0.5F + rectf.right), (int)(0.5F + rectf.bottom));
        }
    }

    public static int getDefaultSize(int i, int j) {
        int k;
        int l;
        int i1;
        k = i;
        l = MeasureSpec.getMode(j);
        i1 = MeasureSpec.getSize(j);
        l;
        JVM INSTR lookupswitch 3: default 48
    //                   -2147483648: 55
    //                   0: 50
    //                   1073741824: 55;
           goto _L1 _L2 _L3 _L2
_L1:
        return k;
_L3:
        k = i;
        continue; /* Loop/switch isn't completed */
_L2:
        k = i1;
        if(true) goto _L1; else goto _L4
_L4:
    }

    private DisplayList getDisplayList(DisplayList displaylist, boolean flag) {
        DisplayList displaylist1;
        if(!canHaveDisplayList()) {
            displaylist1 = null;
        } else {
label0:
            {
                if((0x8000 & mPrivateFlags) != 0 && displaylist != null && displaylist.isValid() && (flag || !mRecreateDisplayList))
                    break MISSING_BLOCK_LABEL_490;
                if(displaylist == null || !displaylist.isValid() || flag || mRecreateDisplayList)
                    break label0;
                mPrivateFlags = 0x8020 | mPrivateFlags;
                mPrivateFlags = 0xff9fffff & mPrivateFlags;
                dispatchGetDisplayList();
                displaylist1 = displaylist;
            }
        }
_L9:
        return displaylist1;
        boolean flag1;
        HardwareCanvas hardwarecanvas;
        int i;
        int j;
        if(!flag)
            mRecreateDisplayList = true;
        if(displaylist == null) {
            String s = getClass().getSimpleName();
            displaylist = mAttachInfo.mHardwareRenderer.createDisplayList(s);
            invalidateParentCaches();
        }
        flag1 = false;
        hardwarecanvas = displaylist.start();
        i = mRight - mLeft;
        j = mBottom - mTop;
        hardwarecanvas.setViewport(i, j);
        hardwarecanvas.onPreDraw(null);
        if((mParent instanceof ViewGroup) && !((ViewGroup)mParent).mDrawLayers) goto _L2; else goto _L1
_L1:
        int k = getLayerType();
_L10:
        if(flag || k == 0) goto _L4; else goto _L3
_L3:
        if(k != 2) goto _L6; else goto _L5
_L5:
        HardwareLayer hardwarelayer = getHardwareLayer();
        if(hardwarelayer == null || !hardwarelayer.isValid()) goto _L8; else goto _L7
_L7:
        hardwarecanvas.drawHardwareLayer(hardwarelayer, 0.0F, 0.0F, mLayerPaint);
_L11:
        flag1 = true;
_L12:
        hardwarecanvas.onPostDraw();
        displaylist.end();
        displaylist.setCaching(flag1);
        Exception exception;
        Bitmap bitmap;
        if(flag)
            displaylist.setLeftTopRightBottom(0, 0, i, j);
        else
            setDisplayListProperties(displaylist);
_L13:
        displaylist1 = displaylist;
          goto _L9
_L2:
        k = 0;
          goto _L10
_L8:
        hardwarecanvas.saveLayer(0.0F, 0.0F, mRight - mLeft, mBottom - mTop, mLayerPaint, 20);
          goto _L11
        exception;
        hardwarecanvas.onPostDraw();
        displaylist.end();
        displaylist.setCaching(false);
        if(flag)
            displaylist.setLeftTopRightBottom(0, 0, i, j);
        else
            setDisplayListProperties(displaylist);
        throw exception;
_L6:
        buildDrawingCache(true);
        bitmap = getDrawingCache(true);
        if(bitmap != null) {
            hardwarecanvas.drawBitmap(bitmap, 0.0F, 0.0F, mLayerPaint);
            flag1 = true;
        }
          goto _L12
_L4:
        computeScroll();
        hardwarecanvas.translate(-mScrollX, -mScrollY);
        if(!flag) {
            mPrivateFlags = 0x8020 | mPrivateFlags;
            mPrivateFlags = 0xff9fffff & mPrivateFlags;
        }
        if((0x80 & mPrivateFlags) == 128)
            dispatchDraw(hardwarecanvas);
        else
            draw(hardwarecanvas);
          goto _L12
        if(!flag) {
            mPrivateFlags = 0x8020 | mPrivateFlags;
            mPrivateFlags = 0xff9fffff & mPrivateFlags;
        }
          goto _L13
    }

    private DisplayList getHardwareLayerDisplayList(HardwareLayer hardwarelayer) {
        DisplayList displaylist = getDisplayList(hardwarelayer.getDisplayList(), true);
        hardwarelayer.setDisplayList(displaylist);
        return displaylist;
    }

    private ScrollabilityCache getScrollCache() {
        initScrollCache();
        return mScrollCache;
    }

    private boolean hasAncestorThatBlocksDescendantFocus() {
        ViewParent viewparent = mParent;
_L3:
        ViewGroup viewgroup;
        if(!(viewparent instanceof ViewGroup))
            break MISSING_BLOCK_LABEL_39;
        viewgroup = (ViewGroup)viewparent;
        if(viewgroup.getDescendantFocusability() != 0x60000) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        viewparent = viewgroup.getParent();
          goto _L3
        flag = false;
          goto _L4
    }

    private boolean hasListenersForAccessibility() {
        ListenerInfo listenerinfo = getListenerInfo();
        boolean flag;
        if(mTouchDelegate != null || listenerinfo.mOnKeyListener != null || listenerinfo.mOnTouchListener != null || listenerinfo.mOnGenericMotionListener != null || listenerinfo.mOnHoverListener != null || listenerinfo.mOnDragListener != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean hasRtlSupport() {
        return mContext.getApplicationInfo().hasRtlSupport();
    }

    public static View inflate(Context context, int i, ViewGroup viewgroup) {
        return LayoutInflater.from(context).inflate(i, viewgroup);
    }

    private void initScrollCache() {
        if(mScrollCache == null)
            mScrollCache = new ScrollabilityCache(ViewConfiguration.get(mContext), this);
    }

    private boolean initialAwakenScrollBars() {
        boolean flag = true;
        if(mScrollCache == null || !awakenScrollBars(4 * mScrollCache.scrollBarDefaultDelayBeforeFade, flag))
            flag = false;
        return flag;
    }

    private void internalSetPadding(int i, int j, int k, int l) {
        int i1;
        int j1;
        boolean flag;
        i1 = 0;
        mUserPaddingLeft = i;
        mUserPaddingRight = k;
        mUserPaddingBottom = l;
        j1 = mViewFlags;
        flag = false;
        if((j1 & 0x300) == 0) goto _L2; else goto _L1
_L1:
        if((j1 & 0x200) == 0) goto _L4; else goto _L3
_L3:
        int k1;
        if((j1 & 0x1000000) == 0)
            k1 = 0;
        else
            k1 = getVerticalScrollbarWidth();
        mVerticalScrollbarPosition;
        JVM INSTR tableswitch 0 2: default 88
    //                   0 198
    //                   1 230
    //                   2 222;
           goto _L5 _L6 _L7 _L8
_L5:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_230;
_L4:
        if((j1 & 0x100) != 0) {
            if((j1 & 0x1000000) != 0)
                i1 = getHorizontalScrollbarHeight();
            l += i1;
        }
_L2:
        if(mPaddingLeft != i) {
            flag = true;
            mPaddingLeft = i;
        }
        if(mPaddingTop != j) {
            flag = true;
            mPaddingTop = j;
        }
        if(mPaddingRight != k) {
            flag = true;
            mPaddingRight = k;
        }
        if(mPaddingBottom != l) {
            flag = true;
            mPaddingBottom = l;
        }
        if(flag)
            requestLayout();
        return;
_L6:
        if(getResolvedLayoutDirection() == 1)
            i += k1;
        else
            k += k1;
          goto _L4
_L8:
        k += k1;
          goto _L4
        i += k1;
          goto _L4
    }

    private boolean isHoverable() {
        boolean flag;
        int i;
        flag = false;
        i = mViewFlags;
        break MISSING_BLOCK_LABEL_7;
        if((i & 0x20) != 32 && ((i & 0x4000) == 16384 || (i & 0x200000) == 0x200000))
            flag = true;
        return flag;
    }

    protected static boolean isLayoutDirectionRtl(Locale locale) {
        boolean flag = true;
        if(flag != LocaleUtil.getLayoutDirectionFromLocale(locale))
            flag = false;
        return flag;
    }

    protected static int[] mergeDrawableStates(int ai[], int ai1[]) {
        int i;
        for(i = -1 + ai.length; i >= 0 && ai[i] == 0; i--);
        System.arraycopy(ai1, 0, ai, i + 1, ai1.length);
        return ai;
    }

    private boolean nextAtGranularity(int i) {
        boolean flag;
        CharSequence charsequence;
        flag = false;
        charsequence = getIterableTextForAccessibility();
        if(charsequence != null && charsequence.length() != 0) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        AccessibilityIterators.TextSegmentIterator textsegmentiterator = getIteratorForGranularity(i);
        if(textsegmentiterator != null) {
            int ai[] = textsegmentiterator.following(getAccessibilityCursorPosition());
            if(ai != null) {
                int j = ai[0];
                int k = ai[1];
                setAccessibilityCursorPosition(k);
                sendViewTextTraversedAtGranularityEvent(256, i, j, k);
                flag = true;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static boolean nonzero(float f) {
        boolean flag;
        if(f < -0.001F || f > 0.001F)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean pointInView(float f, float f1, float f2) {
        boolean flag;
        if(f >= -f2 && f1 >= -f2 && f < f2 + (float)(mRight - mLeft) && f1 < f2 + (float)(mBottom - mTop))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void postSendViewScrolledAccessibilityEventCallback() {
        if(mSendViewScrolledAccessibilityEvent == null)
            mSendViewScrolledAccessibilityEvent = new SendViewScrolledAccessibilityEvent();
        if(!mSendViewScrolledAccessibilityEvent.mIsPending) {
            mSendViewScrolledAccessibilityEvent.mIsPending = true;
            postDelayed(mSendViewScrolledAccessibilityEvent, ViewConfiguration.getSendRecurringAccessibilityEventsInterval());
        }
    }

    private boolean previousAtGranularity(int i) {
        boolean flag;
        CharSequence charsequence;
        flag = false;
        charsequence = getIterableTextForAccessibility();
        if(charsequence != null && charsequence.length() != 0) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        AccessibilityIterators.TextSegmentIterator textsegmentiterator = getIteratorForGranularity(i);
        if(textsegmentiterator == null) goto _L4; else goto _L3
_L3:
        int j = getAccessibilityCursorPosition();
        if(j != -1) goto _L6; else goto _L5
_L5:
        j = charsequence.length();
_L7:
        int ai[] = textsegmentiterator.preceding(j);
        if(ai != null) {
            int k = ai[0];
            int l = ai[1];
            if(i == 1)
                setAccessibilityCursorPosition(l);
            else
                setAccessibilityCursorPosition(k);
            sendViewTextTraversedAtGranularityEvent(512, i, k, l);
            flag = true;
        }
_L4:
        if(true) goto _L1; else goto _L6
_L6:
        if(i == 1)
            j--;
          goto _L7
    }

    private static String printFlags(int i) {
        String s;
        int j;
        s = "";
        j = 0;
        if((i & 1) == 1) {
            s = (new StringBuilder()).append(s).append("TAKES_FOCUS").toString();
            j = 0 + 1;
        }
        i & 0xc;
        JVM INSTR lookupswitch 2: default 68
    //                   4: 70
    //                   8: 119;
           goto _L1 _L2 _L3
_L1:
        return s;
_L2:
        if(j > 0)
            s = (new StringBuilder()).append(s).append(" ").toString();
        s = (new StringBuilder()).append(s).append("INVISIBLE").toString();
        continue; /* Loop/switch isn't completed */
_L3:
        if(j > 0)
            s = (new StringBuilder()).append(s).append(" ").toString();
        s = (new StringBuilder()).append(s).append("GONE").toString();
        if(true) goto _L1; else goto _L4
_L4:
    }

    private static String printPrivateFlags(int i) {
        String s = "";
        int j = 0;
        if((i & 1) == 1) {
            s = (new StringBuilder()).append(s).append("WANTS_FOCUS").toString();
            j = 0 + 1;
        }
        if((i & 2) == 2) {
            if(j > 0)
                s = (new StringBuilder()).append(s).append(" ").toString();
            s = (new StringBuilder()).append(s).append("FOCUSED").toString();
            j++;
        }
        if((i & 4) == 4) {
            if(j > 0)
                s = (new StringBuilder()).append(s).append(" ").toString();
            s = (new StringBuilder()).append(s).append("SELECTED").toString();
            j++;
        }
        if((i & 8) == 8) {
            if(j > 0)
                s = (new StringBuilder()).append(s).append(" ").toString();
            s = (new StringBuilder()).append(s).append("IS_ROOT_NAMESPACE").toString();
            j++;
        }
        if((i & 0x10) == 16) {
            if(j > 0)
                s = (new StringBuilder()).append(s).append(" ").toString();
            s = (new StringBuilder()).append(s).append("HAS_BOUNDS").toString();
            j++;
        }
        if((i & 0x20) == 32) {
            if(j > 0)
                s = (new StringBuilder()).append(s).append(" ").toString();
            s = (new StringBuilder()).append(s).append("DRAWN").toString();
        }
        return s;
    }

    private void removeLongPressCallback() {
        if(mPendingCheckForLongPress != null)
            removeCallbacks(mPendingCheckForLongPress);
    }

    private void removePerformClickCallback() {
        if(mPerformClick != null)
            removeCallbacks(mPerformClick);
    }

    private void removeSendViewScrolledAccessibilityEventCallback() {
        if(mSendViewScrolledAccessibilityEvent != null) {
            removeCallbacks(mSendViewScrolledAccessibilityEvent);
            mSendViewScrolledAccessibilityEvent.mIsPending = false;
        }
    }

    private void removeTapCallback() {
        if(mPendingCheckForTap != null) {
            mPrivateFlags = 0xfdffffff & mPrivateFlags;
            removeCallbacks(mPendingCheckForTap);
        }
    }

    private void removeUnsetPressCallback() {
        if((0x4000 & mPrivateFlags) != 0 && mUnsetPressedState != null) {
            setPressed(false);
            removeCallbacks(mUnsetPressedState);
        }
    }

    private void requestAccessibilityFocusFromHover() {
        if(!includeForAccessibility() || !isActionableForAccessibility()) goto _L2; else goto _L1
_L1:
        requestAccessibilityFocus();
_L4:
        return;
_L2:
        if(mParent != null) {
            View view = mParent.findViewToTakeAccessibilityFocusFromHover(this, this);
            if(view != null)
                view.requestAccessibilityFocus();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean requestFocusNoSearch(int i, Rect rect) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if((1 & mViewFlags) == 1 && (0xc & mViewFlags) == 0 && (!isInTouchMode() || 0x40000 == (0x40000 & mViewFlags)) && !hasAncestorThatBlocksDescendantFocus()) {
            handleFocusGainInternal(i, rect);
            flag = true;
        }
        return flag;
    }

    private void resetPressedState() {
_L2:
        return;
        if((0x20 & mViewFlags) == 32 || !isPressed()) goto _L2; else goto _L1
_L1:
        setPressed(false);
        if(!mHasPerformedLongPress)
            removeLongPressCallback();
        if(true) goto _L2; else goto _L3
_L3:
    }

    public static int resolveSize(int i, int j) {
        return 0xffffff & resolveSizeAndState(i, j, 0);
    }

    public static int resolveSizeAndState(int i, int j, int k) {
        int l;
        int i1;
        int j1;
        l = i;
        i1 = MeasureSpec.getMode(j);
        j1 = MeasureSpec.getSize(j);
        i1;
        JVM INSTR lookupswitch 3: default 52
    //                   -2147483648: 65
    //                   0: 60
    //                   1073741824: 86;
           goto _L1 _L2 _L3 _L4
_L1:
        return l | 0xff000000 & k;
_L3:
        l = i;
        continue; /* Loop/switch isn't completed */
_L2:
        if(j1 < i)
            l = j1 | 0x1000000;
        else
            l = i;
        continue; /* Loop/switch isn't completed */
_L4:
        l = j1;
        if(true) goto _L1; else goto _L5
_L5:
    }

    private void sendAccessibilityHoverEvent(int i) {
        View view = this;
_L6:
        if(!view.includeForAccessibility()) goto _L2; else goto _L1
_L1:
        view.sendAccessibilityEvent(i);
_L4:
        return;
_L2:
        ViewParent viewparent = view.getParent();
        if(!(viewparent instanceof View)) goto _L4; else goto _L3
_L3:
        view = (View)viewparent;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void sendViewTextTraversedAtGranularityEvent(int i, int j, int k, int l) {
        if(mParent != null) {
            AccessibilityEvent accessibilityevent = AccessibilityEvent.obtain(0x20000);
            onInitializeAccessibilityEvent(accessibilityevent);
            onPopulateAccessibilityEvent(accessibilityevent);
            accessibilityevent.setFromIndex(k);
            accessibilityevent.setToIndex(l);
            accessibilityevent.setAction(i);
            accessibilityevent.setMovementGranularity(j);
            mParent.requestSendAccessibilityEvent(this, accessibilityevent);
        }
    }

    private void setKeyedTag(int i, Object obj) {
        if(mKeyedTags == null)
            mKeyedTags = new SparseArray();
        mKeyedTags.put(i, obj);
    }

    private boolean skipInvalidate() {
        boolean flag;
        if((0xc & mViewFlags) != 0 && mCurrentAnimation == null && (!(mParent instanceof ViewGroup) || !((ViewGroup)mParent).isViewTransitioning(this)))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void updateMatrix() {
        TransformationInfo transformationinfo;
        transformationinfo = mTransformationInfo;
        break MISSING_BLOCK_LABEL_5;
_L2:
        do
            return;
        while(transformationinfo == null || !transformationinfo.mMatrixDirty);
        if((0x20000000 & mPrivateFlags) == 0 && (mRight - mLeft != transformationinfo.mPrevWidth || mBottom - mTop != transformationinfo.mPrevHeight)) {
            transformationinfo.mPrevWidth = mRight - mLeft;
            transformationinfo.mPrevHeight = mBottom - mTop;
            transformationinfo.mPivotX = (float)transformationinfo.mPrevWidth / 2.0F;
            transformationinfo.mPivotY = (float)transformationinfo.mPrevHeight / 2.0F;
        }
        transformationinfo.mMatrix.reset();
        if(nonzero(transformationinfo.mRotationX) || nonzero(transformationinfo.mRotationY))
            break; /* Loop/switch isn't completed */
        transformationinfo.mMatrix.setTranslate(transformationinfo.mTranslationX, transformationinfo.mTranslationY);
        transformationinfo.mMatrix.preRotate(transformationinfo.mRotation, transformationinfo.mPivotX, transformationinfo.mPivotY);
        transformationinfo.mMatrix.preScale(transformationinfo.mScaleX, transformationinfo.mScaleY, transformationinfo.mPivotX, transformationinfo.mPivotY);
_L3:
        transformationinfo.mMatrixDirty = false;
        transformationinfo.mMatrixIsIdentity = transformationinfo.mMatrix.isIdentity();
        transformationinfo.mInverseMatrixDirty = true;
        if(true) goto _L2; else goto _L1
_L1:
        if(transformationinfo.mCamera == null) {
            transformationinfo.mCamera = new Camera();
            transformationinfo.matrix3D = new Matrix();
        }
        transformationinfo.mCamera.save();
        transformationinfo.mMatrix.preScale(transformationinfo.mScaleX, transformationinfo.mScaleY, transformationinfo.mPivotX, transformationinfo.mPivotY);
        transformationinfo.mCamera.rotate(transformationinfo.mRotationX, transformationinfo.mRotationY, -transformationinfo.mRotation);
        transformationinfo.mCamera.getMatrix(transformationinfo.matrix3D);
        transformationinfo.matrix3D.preTranslate(-transformationinfo.mPivotX, -transformationinfo.mPivotY);
        transformationinfo.matrix3D.postTranslate(transformationinfo.mPivotX + transformationinfo.mTranslationX, transformationinfo.mPivotY + transformationinfo.mTranslationY);
        transformationinfo.mMatrix.postConcat(transformationinfo.matrix3D);
        transformationinfo.mCamera.restore();
          goto _L3
        if(true) goto _L2; else goto _L4
_L4:
    }

    private void updateUserPaddingRelative() {
        boolean flag;
        if(mUserPaddingStart >= 0 || mUserPaddingEnd >= 0)
            flag = true;
        else
            flag = false;
        mUserPaddingRelative = flag;
    }

    public void addChildrenForAccessibility(ArrayList arraylist) {
        if(includeForAccessibility())
            arraylist.add(this);
    }

    public void addFocusables(ArrayList arraylist, int i) {
        addFocusables(arraylist, i, 1);
    }

    public void addFocusables(ArrayList arraylist, int i, int j) {
        if(arraylist != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if((j & 2) == 2 && isAccessibilityFocusable())
            arraylist.add(this);
        else
        if(isFocusable() && ((j & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()))
            arraylist.add(this);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onattachstatechangelistener) {
        ListenerInfo listenerinfo = getListenerInfo();
        if(listenerinfo.mOnAttachStateChangeListeners == null)
            listenerinfo.mOnAttachStateChangeListeners = new CopyOnWriteArrayList();
        listenerinfo.mOnAttachStateChangeListeners.add(onattachstatechangelistener);
    }

    public void addOnLayoutChangeListener(OnLayoutChangeListener onlayoutchangelistener) {
        ListenerInfo listenerinfo = getListenerInfo();
        if(listenerinfo.mOnLayoutChangeListeners == null)
            listenerinfo.mOnLayoutChangeListeners = new ArrayList();
        if(!listenerinfo.mOnLayoutChangeListeners.contains(onlayoutchangelistener))
            listenerinfo.mOnLayoutChangeListeners.add(onlayoutchangelistener);
    }

    public void addTouchables(ArrayList arraylist) {
        int i = mViewFlags;
        if(((i & 0x4000) == 16384 || (i & 0x200000) == 0x200000) && (i & 0x20) == 0)
            arraylist.add(this);
    }

    public ViewPropertyAnimator animate() {
        if(mAnimator == null)
            mAnimator = new ViewPropertyAnimator(this);
        return mAnimator;
    }

    public void announceForAccessibility(CharSequence charsequence) {
        if(AccessibilityManager.getInstance(mContext).isEnabled()) {
            AccessibilityEvent accessibilityevent = AccessibilityEvent.obtain(16384);
            accessibilityevent.getText().add(charsequence);
            sendAccessibilityEventUnchecked(accessibilityevent);
        }
    }

    public void applyDrawableToTransparentRegion(Drawable drawable, Region region) {
        Region region1 = drawable.getTransparentRegion();
        Rect rect = drawable.getBounds();
        AttachInfo attachinfo = mAttachInfo;
        if(region1 != null && attachinfo != null) {
            int i = getRight() - getLeft();
            int j = getBottom() - getTop();
            if(rect.left > 0)
                region1.op(0, 0, rect.left, j, android.graphics.Region.Op.UNION);
            if(rect.right < i)
                region1.op(rect.right, 0, i, j, android.graphics.Region.Op.UNION);
            if(rect.top > 0)
                region1.op(0, 0, i, rect.top, android.graphics.Region.Op.UNION);
            if(rect.bottom < j)
                region1.op(0, rect.bottom, i, j, android.graphics.Region.Op.UNION);
            int ai[] = attachinfo.mTransparentLocation;
            getLocationInWindow(ai);
            region1.translate(ai[0], ai[1]);
            region.op(region1, android.graphics.Region.Op.INTERSECT);
        } else {
            region.op(rect, android.graphics.Region.Op.DIFFERENCE);
        }
    }

    void assignParent(ViewParent viewparent) {
        if(mParent == null)
            mParent = viewparent;
        else
        if(viewparent == null)
            mParent = null;
        else
            throw new RuntimeException((new StringBuilder()).append("view ").append(this).append(" being added, but").append(" it already has a parent").toString());
    }

    protected boolean awakenScrollBars() {
        boolean flag = true;
        if(mScrollCache == null || !awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade, flag))
            flag = false;
        return flag;
    }

    protected boolean awakenScrollBars(int i) {
        return awakenScrollBars(i, true);
    }

    protected boolean awakenScrollBars(int i, boolean flag) {
        boolean flag1;
        ScrollabilityCache scrollabilitycache;
        flag1 = false;
        scrollabilitycache = mScrollCache;
        if(scrollabilitycache != null && scrollabilitycache.fadeScrollBars) goto _L2; else goto _L1
_L1:
        return flag1;
_L2:
        if(scrollabilitycache.scrollBar == null)
            scrollabilitycache.scrollBar = new ScrollBarDrawable();
        if(isHorizontalScrollBarEnabled() || isVerticalScrollBarEnabled()) {
            if(flag)
                postInvalidateOnAnimation();
            if(scrollabilitycache.state == 0)
                i = Math.max(750, i);
            long l = AnimationUtils.currentAnimationTimeMillis() + (long)i;
            scrollabilitycache.fadeStartTime = l;
            scrollabilitycache.state = 1;
            if(mAttachInfo != null) {
                mAttachInfo.mHandler.removeCallbacks(scrollabilitycache);
                mAttachInfo.mHandler.postAtTime(scrollabilitycache, l);
            }
            flag1 = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void bringToFront() {
        if(mParent != null)
            mParent.bringChildToFront(this);
    }

    public void buildDrawingCache() {
        buildDrawingCache(false);
    }

    public void buildDrawingCache(boolean flag) {
        int i;
        int j;
        AttachInfo attachinfo;
        boolean flag1;
        int k;
        boolean flag2;
        boolean flag3;
        if((0x8000 & mPrivateFlags) != 0 && (flag ? mDrawingCache != null : mUnscaledDrawingCache != null)) goto _L2; else goto _L1
_L1:
        mCachingFailed = false;
        i = mRight - mLeft;
        j = mBottom - mTop;
        attachinfo = mAttachInfo;
        if(attachinfo != null && attachinfo.mScalingRequired)
            flag1 = true;
        else
            flag1 = false;
        if(flag && flag1) {
            i = (int)(0.5F + (float)i * attachinfo.mApplicationScale);
            j = (int)(0.5F + (float)j * attachinfo.mApplicationScale);
        }
        k = mDrawingCacheBackgroundColor;
        if(k != 0 || isOpaque())
            flag2 = true;
        else
            flag2 = false;
        if(attachinfo != null && attachinfo.mUse32BitDrawingCache)
            flag3 = true;
        else
            flag3 = false;
        if(i <= 0 || j <= 0) goto _L4; else goto _L3
_L3:
        int l = i * j;
        byte byte0;
        if(flag2 && !flag3)
            byte0 = 2;
        else
            byte0 = 4;
        if(byte0 * l <= ViewConfiguration.get(mContext).getScaledMaximumDrawingCacheSize()) goto _L5; else goto _L4
_L4:
        destroyDrawingCache();
        mCachingFailed = true;
_L2:
        return;
_L5:
        boolean flag4;
        Bitmap bitmap;
        android.graphics.Bitmap.Config config;
        Canvas canvas;
        flag4 = true;
        int i1;
        float f;
        if(flag)
            bitmap = mDrawingCache;
        else
            bitmap = mUnscaledDrawingCache;
        if(bitmap != null && bitmap.getWidth() == i && bitmap.getHeight() == j) goto _L7; else goto _L6
_L6:
        if(flag2) goto _L9; else goto _L8
_L8:
        0x180000 & mViewFlags;
        JVM INSTR lookupswitch 3: default 312
    //                   0: 604
    //                   524288: 612
    //                   1048576: 620;
           goto _L10 _L11 _L12 _L13
_L10:
        config = android.graphics.Bitmap.Config.ARGB_8888;
_L14:
        if(bitmap != null)
            bitmap.recycle();
        bitmap = Bitmap.createBitmap(i, j, config);
        bitmap.setDensity(getResources().getDisplayMetrics().densityDpi);
        if(!flag)
            break MISSING_BLOCK_LABEL_649;
        mDrawingCache = bitmap;
_L15:
        if(flag2 && flag3)
            bitmap.setHasAlpha(false);
        OutOfMemoryError outofmemoryerror;
        if(k != 0)
            flag4 = true;
        else
            flag4 = false;
_L7:
        if(attachinfo != null) {
            canvas = attachinfo.mCanvas;
            if(canvas == null)
                canvas = new Canvas();
            canvas.setBitmap(bitmap);
            attachinfo.mCanvas = null;
        } else {
            canvas = new Canvas(bitmap);
        }
        if(flag4)
            bitmap.eraseColor(k);
        computeScroll();
        i1 = canvas.save();
        if(flag && flag1) {
            f = attachinfo.mApplicationScale;
            canvas.scale(f, f);
        }
        canvas.translate(-mScrollX, -mScrollY);
        mPrivateFlags = 0x20 | mPrivateFlags;
        if(mAttachInfo == null || !mAttachInfo.mHardwareAccelerated || mLayerType != 0)
            mPrivateFlags = 0x8000 | mPrivateFlags;
        if((0x80 & mPrivateFlags) == 128) {
            mPrivateFlags = 0xff9fffff & mPrivateFlags;
            dispatchDraw(canvas);
        } else {
            draw(canvas);
        }
        canvas.restoreToCount(i1);
        canvas.setBitmap(null);
        if(attachinfo != null)
            attachinfo.mCanvas = canvas;
        continue; /* Loop/switch isn't completed */
_L11:
        config = android.graphics.Bitmap.Config.ARGB_8888;
          goto _L14
_L12:
        config = android.graphics.Bitmap.Config.ARGB_8888;
          goto _L14
_L13:
        config = android.graphics.Bitmap.Config.ARGB_8888;
          goto _L14
_L9:
        if(flag3)
            config = android.graphics.Bitmap.Config.ARGB_8888;
        else
            config = android.graphics.Bitmap.Config.RGB_565;
          goto _L14
        mUnscaledDrawingCache = bitmap;
          goto _L15
        outofmemoryerror;
        if(flag)
            mDrawingCache = null;
        else
            mUnscaledDrawingCache = null;
        mCachingFailed = true;
        if(true) goto _L2; else goto _L16
_L16:
    }

    public void buildLayer() {
        if(mLayerType != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(mAttachInfo == null)
            throw new IllegalStateException("This view must be attached to a window first");
        switch(mLayerType) {
        case 1: // '\001'
            buildDrawingCache(true);
            break;

        case 2: // '\002'
            if(mAttachInfo.mHardwareRenderer != null && mAttachInfo.mHardwareRenderer.isEnabled() && mAttachInfo.mHardwareRenderer.validate())
                getHardwareLayer();
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean callOnClick() {
        ListenerInfo listenerinfo = mListenerInfo;
        boolean flag;
        if(listenerinfo != null && listenerinfo.mOnClickListener != null) {
            listenerinfo.mOnClickListener.onClick(this);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    boolean canAcceptDrag() {
        boolean flag;
        if((1 & mPrivateFlags2) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean canHaveDisplayList() {
        boolean flag;
        if(mAttachInfo != null && mAttachInfo.mHardwareRenderer != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean canResolveLayoutDirection() {
        boolean flag = true;
        getLayoutDirection();
        JVM INSTR tableswitch 2 2: default 24
    //                   2 26;
           goto _L1 _L2
_L1:
        return flag;
_L2:
        if(mParent == null || !(mParent instanceof ViewGroup))
            flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean canResolveTextAlignment() {
        boolean flag = true;
        getTextAlignment();
        JVM INSTR tableswitch 0 0: default 24
    //                   0 26;
           goto _L1 _L2
_L1:
        return flag;
_L2:
        if(mParent == null)
            flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean canResolveTextDirection() {
        boolean flag = true;
        getTextDirection();
        JVM INSTR tableswitch 0 0: default 24
    //                   0 26;
           goto _L1 _L2
_L1:
        return flag;
_L2:
        if(mParent == null || !(mParent instanceof ViewGroup))
            flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean canScrollHorizontally(int i) {
        boolean flag;
        int j;
        int k;
        flag = true;
        j = computeHorizontalScrollOffset();
        k = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
        if(k != 0) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if(i < 0) {
            if(j <= 0)
                flag = false;
        } else
        if(j >= k - 1)
            flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean canScrollVertically(int i) {
        boolean flag;
        int j;
        int k;
        flag = true;
        j = computeVerticalScrollOffset();
        k = computeVerticalScrollRange() - computeVerticalScrollExtent();
        if(k != 0) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if(i < 0) {
            if(j <= 0)
                flag = false;
        } else
        if(j >= k - 1)
            flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void cancelLongPress() {
        removeLongPressCallback();
        removeTapCallback();
    }

    public boolean checkInputConnectionProxy(View view) {
        return false;
    }

    public void clearAccessibilityFocus() {
        if((0x4000000 & mPrivateFlags2) != 0) {
            mPrivateFlags2 = 0xfbffffff & mPrivateFlags2;
            invalidate();
            sendAccessibilityEvent(0x10000);
            notifyAccessibilityStateChanged();
        }
        ViewRootImpl viewrootimpl = getViewRootImpl();
        if(viewrootimpl != null) {
            View view = viewrootimpl.getAccessibilityFocusedHost();
            if(view != null && ViewRootImpl.isViewDescendantOf(view, this))
                viewrootimpl.setAccessibilityFocus(null, null);
        }
    }

    void clearAccessibilityFocusNoCallbacks() {
        if((0x4000000 & mPrivateFlags2) != 0) {
            mPrivateFlags2 = 0xfbffffff & mPrivateFlags2;
            invalidate();
        }
    }

    public void clearAnimation() {
        if(mCurrentAnimation != null)
            mCurrentAnimation.detach();
        mCurrentAnimation = null;
        invalidateParentIfNeeded();
    }

    public void clearFocus() {
        if((2 & mPrivateFlags) != 0) {
            mPrivateFlags = -3 & mPrivateFlags;
            if(mParent != null)
                mParent.clearChildFocus(this);
            onFocusChanged(false, 0, null);
            refreshDrawableState();
            ensureInputFocusOnFirstFocusable();
            if(AccessibilityManager.getInstance(mContext).isEnabled())
                notifyAccessibilityStateChanged();
        }
    }

    protected int computeHorizontalScrollExtent() {
        return getWidth();
    }

    protected int computeHorizontalScrollOffset() {
        return mScrollX;
    }

    protected int computeHorizontalScrollRange() {
        return getWidth();
    }

    protected void computeOpaqueFlags() {
        int i;
        if(mBackground != null && mBackground.getOpacity() == -1)
            mPrivateFlags = 0x800000 | mPrivateFlags;
        else
            mPrivateFlags = 0xff7fffff & mPrivateFlags;
        i = mViewFlags;
        if((i & 0x200) == 0 && (i & 0x100) == 0 || (0x3000000 & i) == 0)
            mPrivateFlags = 0x1000000 | mPrivateFlags;
        else
            mPrivateFlags = 0xfeffffff & mPrivateFlags;
    }

    public void computeScroll() {
    }

    protected int computeVerticalScrollExtent() {
        return getHeight();
    }

    protected int computeVerticalScrollOffset() {
        return mScrollY;
    }

    protected int computeVerticalScrollRange() {
        return getHeight();
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo() {
        AccessibilityNodeProvider accessibilitynodeprovider = getAccessibilityNodeProvider();
        AccessibilityNodeInfo accessibilitynodeinfo;
        if(accessibilitynodeprovider != null) {
            accessibilitynodeinfo = accessibilitynodeprovider.createAccessibilityNodeInfo(-1);
        } else {
            accessibilitynodeinfo = AccessibilityNodeInfo.obtain(this);
            onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        }
        return accessibilitynodeinfo;
    }

    public void createContextMenu(ContextMenu contextmenu) {
        ContextMenu.ContextMenuInfo contextmenuinfo = getContextMenuInfo();
        ((MenuBuilder)contextmenu).setCurrentMenuInfo(contextmenuinfo);
        onCreateContextMenu(contextmenu);
        ListenerInfo listenerinfo = mListenerInfo;
        if(listenerinfo != null && listenerinfo.mOnCreateContextMenuListener != null)
            listenerinfo.mOnCreateContextMenuListener.onCreateContextMenu(contextmenu, this, contextmenuinfo);
        ((MenuBuilder)contextmenu).setCurrentMenuInfo(null);
        if(mParent != null)
            mParent.createContextMenu(contextmenu);
    }

    Bitmap createSnapshot(android.graphics.Bitmap.Config config, int i, boolean flag) {
        int j = mRight - mLeft;
        int k = mBottom - mTop;
        AttachInfo attachinfo = mAttachInfo;
        float f;
        int l;
        int i1;
        Bitmap bitmap;
        if(attachinfo != null)
            f = attachinfo.mApplicationScale;
        else
            f = 1.0F;
        l = (int)(0.5F + f * (float)j);
        i1 = (int)(0.5F + f * (float)k);
        if(l <= 0)
            l = 1;
        if(i1 <= 0)
            i1 = 1;
        bitmap = Bitmap.createBitmap(l, i1, config);
        if(bitmap == null)
            throw new OutOfMemoryError();
        Resources resources = getResources();
        if(resources != null)
            bitmap.setDensity(resources.getDisplayMetrics().densityDpi);
        Canvas canvas;
        int j1;
        int k1;
        if(attachinfo != null) {
            canvas = attachinfo.mCanvas;
            if(canvas == null)
                canvas = new Canvas();
            canvas.setBitmap(bitmap);
            attachinfo.mCanvas = null;
        } else {
            canvas = new Canvas(bitmap);
        }
        if((0xff000000 & i) != 0)
            bitmap.eraseColor(i);
        computeScroll();
        j1 = canvas.save();
        canvas.scale(f, f);
        canvas.translate(-mScrollX, -mScrollY);
        k1 = mPrivateFlags;
        mPrivateFlags = 0xff9fffff & mPrivateFlags;
        if((0x80 & mPrivateFlags) == 128)
            dispatchDraw(canvas);
        else
            draw(canvas);
        mPrivateFlags = k1;
        canvas.restoreToCount(j1);
        canvas.setBitmap(null);
        if(attachinfo != null)
            attachinfo.mCanvas = canvas;
        return bitmap;
    }

    public void debug() {
        debug(0);
    }

    protected void debug(int i) {
        String s = debugIndent(i - 1);
        String s1 = (new StringBuilder()).append(s).append("+ ").append(this).toString();
        int j = getId();
        if(j != -1)
            s1 = (new StringBuilder()).append(s1).append(" (id=").append(j).append(")").toString();
        Object obj = getTag();
        if(obj != null)
            s1 = (new StringBuilder()).append(s1).append(" (tag=").append(obj).append(")").toString();
        Log.d("View", s1);
        if((2 & mPrivateFlags) != 0)
            Log.d("View", (new StringBuilder()).append(debugIndent(i)).append(" FOCUSED").toString());
        String s2 = debugIndent(i);
        Log.d("View", (new StringBuilder()).append(s2).append("frame={").append(mLeft).append(", ").append(mTop).append(", ").append(mRight).append(", ").append(mBottom).append("} scroll={").append(mScrollX).append(", ").append(mScrollY).append("} ").toString());
        if(mPaddingLeft != 0 || mPaddingTop != 0 || mPaddingRight != 0 || mPaddingBottom != 0) {
            String s3 = debugIndent(i);
            Log.d("View", (new StringBuilder()).append(s3).append("padding={").append(mPaddingLeft).append(", ").append(mPaddingTop).append(", ").append(mPaddingRight).append(", ").append(mPaddingBottom).append("}").toString());
        }
        String s4 = debugIndent(i);
        Log.d("View", (new StringBuilder()).append(s4).append("mMeasureWidth=").append(mMeasuredWidth).append(" mMeasureHeight=").append(mMeasuredHeight).toString());
        String s5 = debugIndent(i);
        String s6;
        String s7;
        String s8;
        String s9;
        String s10;
        String s11;
        String s12;
        if(mLayoutParams == null)
            s6 = (new StringBuilder()).append(s5).append("BAD! no layout params").toString();
        else
            s6 = mLayoutParams.debug(s5);
        Log.d("View", s6);
        s7 = debugIndent(i);
        s8 = (new StringBuilder()).append(s7).append("flags={").toString();
        s9 = (new StringBuilder()).append(s8).append(printFlags(mViewFlags)).toString();
        Log.d("View", (new StringBuilder()).append(s9).append("}").toString());
        s10 = debugIndent(i);
        s11 = (new StringBuilder()).append(s10).append("privateFlags={").toString();
        s12 = (new StringBuilder()).append(s11).append(printPrivateFlags(mPrivateFlags)).toString();
        Log.d("View", (new StringBuilder()).append(s12).append("}").toString());
    }

    public void destroyDrawingCache() {
        if(mDrawingCache != null) {
            mDrawingCache.recycle();
            mDrawingCache = null;
        }
        if(mUnscaledDrawingCache != null) {
            mUnscaledDrawingCache.recycle();
            mUnscaledDrawingCache = null;
        }
    }

    protected void destroyHardwareResources() {
        destroyLayer(true);
    }

    boolean destroyLayer(boolean flag) {
        boolean flag1 = true;
        if(mHardwareLayer != null) {
            AttachInfo attachinfo = mAttachInfo;
            if(attachinfo != null && attachinfo.mHardwareRenderer != null && attachinfo.mHardwareRenderer.isEnabled() && (flag || attachinfo.mHardwareRenderer.validate())) {
                mHardwareLayer.destroy();
                mHardwareLayer = null;
                invalidate(flag1);
                invalidateParentCaches();
            }
        } else {
            flag1 = false;
        }
        return flag1;
    }

    void dispatchAttachedToWindow(AttachInfo attachinfo, int i) {
        CopyOnWriteArrayList copyonwritearraylist = null;
        mAttachInfo = attachinfo;
        mWindowAttachCount = 1 + mWindowAttachCount;
        mPrivateFlags = 0x400 | mPrivateFlags;
        if(mFloatingTreeObserver != null) {
            attachinfo.mTreeObserver.merge(mFloatingTreeObserver);
            mFloatingTreeObserver = null;
        }
        if((0x80000 & mPrivateFlags) != 0) {
            mAttachInfo.mScrollContainers.add(this);
            mPrivateFlags = 0x100000 | mPrivateFlags;
        }
        performCollectViewAttributes(mAttachInfo, i);
        onAttachedToWindow();
        ListenerInfo listenerinfo = mListenerInfo;
        if(listenerinfo != null)
            copyonwritearraylist = listenerinfo.mOnAttachStateChangeListeners;
        if(copyonwritearraylist != null && copyonwritearraylist.size() > 0) {
            for(Iterator iterator = copyonwritearraylist.iterator(); iterator.hasNext(); ((OnAttachStateChangeListener)iterator.next()).onViewAttachedToWindow(this));
        }
        int j = attachinfo.mWindowVisibility;
        if(j != 8)
            onWindowVisibilityChanged(j);
        if((0x400 & mPrivateFlags) != 0)
            refreshDrawableState();
    }

    void dispatchCollectViewAttributes(AttachInfo attachinfo, int i) {
        performCollectViewAttributes(attachinfo, i);
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    void dispatchDetachedFromWindow() {
        AttachInfo attachinfo = mAttachInfo;
        if(attachinfo != null && attachinfo.mWindowVisibility != 8)
            onWindowVisibilityChanged(8);
        onDetachedFromWindow();
        ListenerInfo listenerinfo = mListenerInfo;
        CopyOnWriteArrayList copyonwritearraylist;
        if(listenerinfo != null)
            copyonwritearraylist = listenerinfo.mOnAttachStateChangeListeners;
        else
            copyonwritearraylist = null;
        if(copyonwritearraylist != null && copyonwritearraylist.size() > 0) {
            for(Iterator iterator = copyonwritearraylist.iterator(); iterator.hasNext(); ((OnAttachStateChangeListener)iterator.next()).onViewDetachedFromWindow(this));
        }
        if((0x100000 & mPrivateFlags) != 0) {
            mAttachInfo.mScrollContainers.remove(this);
            mPrivateFlags = 0xffefffff & mPrivateFlags;
        }
        mAttachInfo = null;
    }

    public void dispatchDisplayHint(int i) {
        onDisplayHint(i);
    }

    public boolean dispatchDragEvent(DragEvent dragevent) {
        ListenerInfo listenerinfo = mListenerInfo;
        boolean flag;
        if(listenerinfo != null && listenerinfo.mOnDragListener != null && (0x20 & mViewFlags) == 0 && listenerinfo.mOnDragListener.onDrag(this, dragevent))
            flag = true;
        else
            flag = onDragEvent(dragevent);
        return flag;
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void dispatchFinishTemporaryDetach() {
        onFinishTemporaryDetach();
    }

    protected boolean dispatchGenericFocusedEvent(MotionEvent motionevent) {
        return false;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionevent) {
        boolean flag;
        flag = true;
        if(mInputEventConsistencyVerifier != null)
            mInputEventConsistencyVerifier.onGenericMotionEvent(motionevent, 0);
        break MISSING_BLOCK_LABEL_18;
        int i;
        if(((2 & motionevent.getSource()) == 0 ? !dispatchGenericFocusedEvent(motionevent) : (i = motionevent.getAction()) != 9 && i != 7 && i != 10 ? !dispatchGenericPointerEvent(motionevent) : !dispatchHoverEvent(motionevent)) && !dispatchGenericMotionEventInternal(motionevent)) {
            if(mInputEventConsistencyVerifier != null)
                mInputEventConsistencyVerifier.onUnhandledEvent(motionevent, 0);
            flag = false;
        }
        return flag;
    }

    protected boolean dispatchGenericPointerEvent(MotionEvent motionevent) {
        return false;
    }

    protected void dispatchGetDisplayList() {
    }

    protected boolean dispatchHoverEvent(MotionEvent motionevent) {
        ListenerInfo listenerinfo = mListenerInfo;
        boolean flag;
        if(listenerinfo != null && listenerinfo.mOnHoverListener != null && (0x20 & mViewFlags) == 0 && listenerinfo.mOnHoverListener.onHover(this, motionevent))
            flag = true;
        else
            flag = onHoverEvent(motionevent);
        return flag;
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent) {
        if(mInputEventConsistencyVerifier != null)
            mInputEventConsistencyVerifier.onKeyEvent(keyevent, 0);
        ListenerInfo listenerinfo = mListenerInfo;
        boolean flag;
        if(listenerinfo != null && listenerinfo.mOnKeyListener != null && (0x20 & mViewFlags) == 0 && listenerinfo.mOnKeyListener.onKey(this, keyevent.getKeyCode(), keyevent)) {
            flag = true;
        } else {
            KeyEvent.DispatcherState dispatcherstate;
            if(mAttachInfo != null)
                dispatcherstate = mAttachInfo.mKeyDispatchState;
            else
                dispatcherstate = null;
            if(keyevent.dispatch(this, dispatcherstate, this)) {
                flag = true;
            } else {
                if(mInputEventConsistencyVerifier != null)
                    mInputEventConsistencyVerifier.onUnhandledEvent(keyevent, 0);
                flag = false;
            }
        }
        return flag;
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyevent) {
        return onKeyPreIme(keyevent.getKeyCode(), keyevent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyevent) {
        return onKeyShortcut(keyevent.getKeyCode(), keyevent);
    }

    public final boolean dispatchPointerEvent(MotionEvent motionevent) {
        boolean flag;
        if(motionevent.isTouchEvent())
            flag = dispatchTouchEvent(motionevent);
        else
            flag = dispatchGenericMotionEvent(motionevent);
        return flag;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        boolean flag;
        if(mAccessibilityDelegate != null)
            flag = mAccessibilityDelegate.dispatchPopulateAccessibilityEvent(this, accessibilityevent);
        else
            flag = dispatchPopulateAccessibilityEventInternal(accessibilityevent);
        return flag;
    }

    boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent accessibilityevent) {
        onPopulateAccessibilityEvent(accessibilityevent);
        return false;
    }

    protected void dispatchRestoreInstanceState(SparseArray sparsearray) {
        if(mID != -1) {
            Parcelable parcelable = (Parcelable)sparsearray.get(mID);
            if(parcelable != null) {
                mPrivateFlags = 0xfffdffff & mPrivateFlags;
                onRestoreInstanceState(parcelable);
                if((0x20000 & mPrivateFlags) == 0)
                    throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
            }
        }
    }

    protected void dispatchSaveInstanceState(SparseArray sparsearray) {
        if(mID != -1 && (0x10000 & mViewFlags) == 0) {
            mPrivateFlags = 0xfffdffff & mPrivateFlags;
            Parcelable parcelable = onSaveInstanceState();
            if((0x20000 & mPrivateFlags) == 0)
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            if(parcelable != null)
                sparsearray.put(mID, parcelable);
        }
    }

    void dispatchScreenStateChanged(int i) {
        onScreenStateChanged(i);
    }

    protected void dispatchSetActivated(boolean flag) {
    }

    protected void dispatchSetPressed(boolean flag) {
    }

    protected void dispatchSetSelected(boolean flag) {
    }

    public void dispatchStartTemporaryDetach() {
        clearAccessibilityFocus();
        clearDisplayList();
        onStartTemporaryDetach();
    }

    public void dispatchSystemUiVisibilityChanged(int i) {
        ListenerInfo listenerinfo = mListenerInfo;
        if(listenerinfo != null && listenerinfo.mOnSystemUiVisibilityChangeListener != null)
            listenerinfo.mOnSystemUiVisibilityChangeListener.onSystemUiVisibilityChange(0xffff & i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent) {
        boolean flag = true;
        if(mInputEventConsistencyVerifier != null)
            mInputEventConsistencyVerifier.onTouchEvent(motionevent, 0);
        ListenerInfo listenerinfo;
        if(onFilterTouchEventForSecurity(motionevent)) {
            listenerinfo = mListenerInfo;
            break MISSING_BLOCK_LABEL_31;
        }
        do {
            if(mInputEventConsistencyVerifier != null)
                mInputEventConsistencyVerifier.onUnhandledEvent(motionevent, 0);
            flag = false;
            if(true)
                do
                    return flag;
                while(listenerinfo != null && listenerinfo.mOnTouchListener != null && (0x20 & mViewFlags) == 0 && listenerinfo.mOnTouchListener.onTouch(this, motionevent) || onTouchEvent(motionevent));
        } while(true);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionevent) {
        if(mInputEventConsistencyVerifier != null)
            mInputEventConsistencyVerifier.onTrackballEvent(motionevent, 0);
        return onTrackballEvent(motionevent);
    }

    public boolean dispatchUnhandledMove(View view, int i) {
        return false;
    }

    protected void dispatchVisibilityChanged(View view, int i) {
        onVisibilityChanged(view, i);
    }

    public void dispatchWindowFocusChanged(boolean flag) {
        onWindowFocusChanged(flag);
    }

    public void dispatchWindowSystemUiVisiblityChanged(int i) {
        onWindowSystemUiVisibilityChanged(i);
    }

    public void dispatchWindowVisibilityChanged(int i) {
        onWindowVisibilityChanged(i);
    }

    public void draw(Canvas canvas) {
        int i = mPrivateFlags;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if((0x600000 & i) == 0x400000 && (mAttachInfo == null || !mAttachInfo.mIgnoreDirtyState))
            flag = true;
        else
            flag = false;
        mPrivateFlags = 0x20 | 0xff9fffff & i;
        if(!flag) {
            Drawable drawable = mBackground;
            if(drawable != null) {
                int k2 = mScrollX;
                int l2 = mScrollY;
                if(mBackgroundSizeChanged) {
                    drawable.setBounds(0, 0, mRight - mLeft, mBottom - mTop);
                    mBackgroundSizeChanged = false;
                }
                int j;
                if((k2 | l2) == 0) {
                    drawable.draw(canvas);
                } else {
                    canvas.translate(k2, l2);
                    drawable.draw(canvas);
                    canvas.translate(-k2, -l2);
                }
            }
        }
        j = mViewFlags;
        if((j & 0x1000) != 0)
            flag1 = true;
        else
            flag1 = false;
        if((j & 0x2000) != 0)
            flag2 = true;
        else
            flag2 = false;
        if(!flag2 && !flag1) {
            if(!flag)
                onDraw(canvas);
            dispatchDraw(canvas);
            onDrawScrollBars(canvas);
        } else {
            boolean flag3 = false;
            boolean flag4 = false;
            boolean flag5 = false;
            boolean flag6 = false;
            float f = 0.0F;
            float f1 = 0.0F;
            float f2 = 0.0F;
            float f3 = 0.0F;
            int k = mPaddingLeft;
            boolean flag7 = isPaddingOffsetRequired();
            if(flag7)
                k += getLeftPaddingOffset();
            int l = k + mScrollX;
            int i1 = (l + mRight) - mLeft - mPaddingRight - k;
            int j1 = mScrollY + getFadeTop(flag7);
            int k1 = j1 + getFadeHeight(flag7);
            if(flag7) {
                i1 += getRightPaddingOffset();
                k1 += getBottomPaddingOffset();
            }
            ScrollabilityCache scrollabilitycache = mScrollCache;
            float f4 = scrollabilitycache.fadingEdgeLength;
            int l1 = (int)f4;
            if(flag2 && j1 + l1 > k1 - l1)
                l1 = (k1 - j1) / 2;
            if(flag1 && l + l1 > i1 - l1)
                l1 = (i1 - l) / 2;
            int j2;
            if(flag2) {
                f = Math.max(0.0F, Math.min(1.0F, getTopFadingEdgeStrength()));
                int i2;
                Paint paint;
                Matrix matrix;
                Shader shader;
                if(f * f4 > 1.0F)
                    flag3 = true;
                else
                    flag3 = false;
                f1 = Math.max(0.0F, Math.min(1.0F, getBottomFadingEdgeStrength()));
                if(f1 * f4 > 1.0F)
                    flag4 = true;
                else
                    flag4 = false;
            }
            if(flag1) {
                f2 = Math.max(0.0F, Math.min(1.0F, getLeftFadingEdgeStrength()));
                if(f2 * f4 > 1.0F)
                    flag5 = true;
                else
                    flag5 = false;
                f3 = Math.max(0.0F, Math.min(1.0F, getRightFadingEdgeStrength()));
                if(f3 * f4 > 1.0F)
                    flag6 = true;
                else
                    flag6 = false;
            }
            i2 = canvas.getSaveCount();
            j2 = getSolidColor();
            if(j2 == 0) {
                if(flag3)
                    canvas.saveLayer(l, j1, i1, j1 + l1, null, 4);
                if(flag4)
                    canvas.saveLayer(l, k1 - l1, i1, k1, null, 4);
                if(flag5)
                    canvas.saveLayer(l, j1, l + l1, k1, null, 4);
                if(flag6)
                    canvas.saveLayer(i1 - l1, j1, i1, k1, null, 4);
            } else {
                scrollabilitycache.setFadeColor(j2);
            }
            if(!flag)
                onDraw(canvas);
            dispatchDraw(canvas);
            paint = scrollabilitycache.paint;
            matrix = scrollabilitycache.matrix;
            shader = scrollabilitycache.shader;
            if(flag3) {
                matrix.setScale(1.0F, f4 * f);
                matrix.postTranslate(l, j1);
                shader.setLocalMatrix(matrix);
                canvas.drawRect(l, j1, i1, j1 + l1, paint);
            }
            if(flag4) {
                matrix.setScale(1.0F, f4 * f1);
                matrix.postRotate(180F);
                matrix.postTranslate(l, k1);
                shader.setLocalMatrix(matrix);
                canvas.drawRect(l, k1 - l1, i1, k1, paint);
            }
            if(flag5) {
                matrix.setScale(1.0F, f4 * f2);
                matrix.postRotate(-90F);
                matrix.postTranslate(l, j1);
                shader.setLocalMatrix(matrix);
                canvas.drawRect(l, j1, l + l1, k1, paint);
            }
            if(flag6) {
                matrix.setScale(1.0F, f4 * f3);
                matrix.postRotate(90F);
                matrix.postTranslate(i1, j1);
                shader.setLocalMatrix(matrix);
                canvas.drawRect(i1 - l1, j1, i1, k1, paint);
            }
            canvas.restoreToCount(i2);
            onDrawScrollBars(canvas);
        }
    }

    boolean draw(Canvas canvas, ViewGroup viewgroup, long l) {
        boolean flag;
        boolean flag1;
        boolean flag2;
        int i;
        Transformation transformation;
        boolean flag4;
        int j;
        boolean flag5;
        boolean flag6;
        Animation animation;
        boolean flag8;
        boolean flag3;
        boolean flag7;
        if(mAttachInfo != null && mAttachInfo.mHardwareAccelerated)
            flag = true;
        else
            flag = false;
        flag1 = false;
        flag2 = hasIdentityMatrix();
        i = viewgroup.mGroupFlags;
        if((i & 0x100) == 256) {
            viewgroup.mChildTransformation.clear();
            viewgroup.mGroupFlags = 0xfffffeff & viewgroup.mGroupFlags;
        }
        transformation = null;
        flag3 = false;
        flag4 = false;
        if(viewgroup.mDrawLayers)
            j = getLayerType();
        else
            j = 0;
        flag5 = canvas.isHardwareAccelerated();
        if((0x8000 & i) != 0 || (i & 0x4000) != 0) {
            flag6 = true;
            if(mAttachInfo != null)
                flag4 = mAttachInfo.mScalingRequired;
        } else
        if(j != 0 || flag5)
            flag6 = true;
        else
            flag6 = false;
        animation = getAnimation();
        if(animation != null) {
            flag1 = drawAnimation(viewgroup, l, animation, flag4);
            flag3 = animation.willChangeTransformationMatrix();
            if(flag3)
                mPrivateFlags3 = 1 | mPrivateFlags3;
            transformation = viewgroup.mChildTransformation;
        } else {
            if((1 & mPrivateFlags3) == 1 && mDisplayList != null) {
                mDisplayList.setAnimationMatrix(null);
                mPrivateFlags3 = -2 & mPrivateFlags3;
            }
            if(!flag && (i & 0x800) != 0 && viewgroup.getChildStaticTransformation(this, viewgroup.mChildTransformation)) {
                int k = viewgroup.mChildTransformation.getTransformationType();
                if(k != Transformation.TYPE_IDENTITY)
                    transformation = viewgroup.mChildTransformation;
                else
                    transformation = null;
                if((k & Transformation.TYPE_MATRIX) != 0)
                    flag3 = true;
                else
                    flag3 = false;
            }
        }
        if(!flag2)
            flag7 = true;
        else
            flag7 = false;
        flag8 = flag3 | flag7;
        mPrivateFlags = 0x20 | mPrivateFlags;
        if(flag8 || !canvas.quickReject(mLeft, mTop, mRight, mBottom, android.graphics.Canvas.EdgeType.BW) || (0x40 & mPrivateFlags) != 0) goto _L2; else goto _L1
_L1:
        mPrivateFlags2 = 0x10000000 | mPrivateFlags2;
_L9:
        return flag1;
_L2:
        int i1;
        int j1;
        DisplayList displaylist;
        Bitmap bitmap;
        boolean flag9;
        mPrivateFlags2 = 0xefffffff & mPrivateFlags2;
        if(flag5) {
            boolean flag13;
            HardwareLayer hardwarelayer;
            float f2;
            float f3;
            Matrix matrix;
            boolean flag14;
            if((0x80000000 & mPrivateFlags) == 0x80000000)
                flag14 = true;
            else
                flag14 = false;
            mRecreateDisplayList = flag14;
            mPrivateFlags = 0x7fffffff & mPrivateFlags;
        }
        computeScroll();
        i1 = mScrollX;
        j1 = mScrollY;
        displaylist = null;
        bitmap = null;
        flag9 = false;
        if(!flag6) goto _L4; else goto _L3
_L3:
        if(flag5) goto _L6; else goto _L5
_L5:
        if(j != 0) {
            j = 1;
            buildDrawingCache(true);
        }
        bitmap = getDrawingCache(true);
_L4:
        boolean flag10 = flag & flag9;
        if(flag10) {
            displaylist = getDisplayList();
            if(!displaylist.isValid()) {
                displaylist = null;
                flag9 = false;
                flag10 = false;
            }
        }
        boolean flag11;
        boolean flag12;
        int k1;
        float f1;
        if(bitmap == null || flag9)
            flag11 = true;
        else
            flag11 = false;
        if(bitmap == null && !flag9 && j != 2)
            flag12 = true;
        else
            flag12 = false;
        k1 = -1;
        if(!flag10 || transformation != null)
            k1 = canvas.save();
        if(flag12) {
            canvas.translate(mLeft - i1, mTop - j1);
        } else {
            if(!flag10)
                canvas.translate(mLeft, mTop);
            if(flag4) {
                if(flag10)
                    k1 = canvas.save();
                float f = 1.0F / mAttachInfo.mApplicationScale;
                canvas.scale(f, f);
            }
        }
        if(flag10)
            f1 = 1.0F;
        else
            f1 = getAlpha();
        if(transformation != null || f1 < 1.0F || !hasIdentityMatrix() || (2 & mPrivateFlags3) == 2) {
            if(transformation != null || !flag2) {
                int l1 = 0;
                int i2 = 0;
                if(flag12) {
                    l1 = -i1;
                    i2 = -j1;
                }
                if(transformation != null) {
                    if(flag8) {
                        if(flag10) {
                            matrix = transformation.getMatrix();
                            displaylist.setAnimationMatrix(matrix);
                        } else {
                            canvas.translate(-l1, -i2);
                            canvas.concat(transformation.getMatrix());
                            canvas.translate(l1, i2);
                        }
                        viewgroup.mGroupFlags = 0x100 | viewgroup.mGroupFlags;
                    }
                    f3 = transformation.getAlpha();
                    if(f3 < 1.0F) {
                        f1 *= f3;
                        viewgroup.mGroupFlags = 0x100 | viewgroup.mGroupFlags;
                    }
                }
                if(!flag2 && !flag10) {
                    canvas.translate(-l1, -i2);
                    canvas.concat(getMatrix());
                    canvas.translate(l1, i2);
                }
            }
            if(f1 < 1.0F || (2 & mPrivateFlags3) == 2) {
                if(f1 < 1.0F)
                    mPrivateFlags3 = 2 | mPrivateFlags3;
                else
                    mPrivateFlags3 = -3 & mPrivateFlags3;
                viewgroup.mGroupFlags = 0x100 | viewgroup.mGroupFlags;
                if(flag11) {
                    int j3 = (int)(255F * f1);
                    if(!onSetAlpha(j3)) {
                        int k3 = 4;
                        if((i & 1) != 0 || j != 0)
                            k3 |= 0x10;
                        if(flag10) {
                            f2 = f1 * getAlpha();
                            displaylist.setAlpha(f2);
                        } else
                        if(j == 0) {
                            int l3;
                            int i4;
                            if(flag9)
                                l3 = 0;
                            else
                                l3 = i1;
                            if(flag9)
                                i4 = 0;
                            else
                                i4 = j1;
                            canvas.saveLayerAlpha(l3, i4, (l3 + mRight) - mLeft, (i4 + mBottom) - mTop, j3, k3);
                        }
                    } else {
                        mPrivateFlags = 0x40000 | mPrivateFlags;
                    }
                }
            }
        } else
        if((0x40000 & mPrivateFlags) == 0x40000) {
            onSetAlpha(255);
            mPrivateFlags = 0xfffbffff & mPrivateFlags;
        }
        if((i & 1) == 1 && !flag10)
            if(flag12)
                canvas.clipRect(i1, j1, i1 + (mRight - mLeft), j1 + (mBottom - mTop));
            else
            if(!flag4 || bitmap == null)
                canvas.clipRect(0, 0, mRight - mLeft, mBottom - mTop);
            else
                canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        if(!flag10 && flag9) {
            displaylist = getDisplayList();
            if(!displaylist.isValid()) {
                displaylist = null;
                flag9 = false;
            }
        }
        if(flag11) {
            flag13 = false;
            if(j == 2 && !flag10) {
                hardwarelayer = getHardwareLayer();
                if(hardwarelayer != null && hardwarelayer.isValid()) {
                    mLayerPaint.setAlpha((int)(255F * f1));
                    ((HardwareCanvas)canvas).drawHardwareLayer(hardwarelayer, 0.0F, 0.0F, mLayerPaint);
                    flag13 = true;
                } else {
                    int l2;
                    int i3;
                    if(flag9)
                        l2 = 0;
                    else
                        l2 = i1;
                    if(flag9)
                        i3 = 0;
                    else
                        i3 = j1;
                    canvas.saveLayer(l2, i3, (l2 + mRight) - mLeft, (i3 + mBottom) - mTop, mLayerPaint, 20);
                }
            }
            if(!flag13)
                if(!flag9) {
                    if((0x80 & mPrivateFlags) == 128) {
                        mPrivateFlags = 0xff9fffff & mPrivateFlags;
                        dispatchDraw(canvas);
                    } else {
                        draw(canvas);
                    }
                } else {
                    mPrivateFlags = 0xff9fffff & mPrivateFlags;
                    ((HardwareCanvas)canvas).drawDisplayList(displaylist, null, i);
                }
        } else
        if(bitmap != null) {
            mPrivateFlags = 0xff9fffff & mPrivateFlags;
            Paint paint;
            if(j == 0) {
                paint = viewgroup.mCachePaint;
                if(paint == null) {
                    paint = new Paint();
                    paint.setDither(false);
                    viewgroup.mCachePaint = paint;
                }
                if(f1 < 1.0F) {
                    int k2 = (int)(255F * f1);
                    paint.setAlpha(k2);
                    viewgroup.mGroupFlags = 0x1000 | viewgroup.mGroupFlags;
                } else
                if((i & 0x1000) != 0) {
                    paint.setAlpha(255);
                    viewgroup.mGroupFlags = 0xffffefff & viewgroup.mGroupFlags;
                }
            } else {
                paint = mLayerPaint;
                int j2 = (int)(255F * f1);
                paint.setAlpha(j2);
            }
            canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        }
        if(k1 >= 0)
            canvas.restoreToCount(k1);
        if(animation != null && !flag1) {
            if(!flag5 && !animation.getFillAfter())
                onSetAlpha(255);
            viewgroup.finishAnimatingView(this, animation);
        }
        if(flag1 && flag5) {
            viewgroup.invalidate(true);
            if(animation.hasAlpha() && (0x40000 & mPrivateFlags) == 0x40000)
                invalidate(true);
        }
        mRecreateDisplayList = false;
        continue; /* Loop/switch isn't completed */
_L6:
        switch(j) {
        case 0: // '\0'
            flag9 = canHaveDisplayList();
            break;

        case 1: // '\001'
            if(flag) {
                flag9 = canHaveDisplayList();
            } else {
                buildDrawingCache(true);
                bitmap = getDrawingCache(true);
            }
            break;

        case 2: // '\002'
            if(flag)
                flag9 = canHaveDisplayList();
            break;
        }
        if(true) goto _L4; else goto _L7
_L7:
        if(true) goto _L9; else goto _L8
_L8:
    }

    protected void drawableStateChanged() {
        Drawable drawable = mBackground;
        if(drawable != null && drawable.isStateful())
            drawable.setState(getDrawableState());
    }

    void ensureInputFocusOnFirstFocusable() {
        View view = getRootView();
        if(view != null)
            view.requestFocus();
    }

    void ensureTransformationInfo() {
        if(mTransformationInfo == null)
            mTransformationInfo = new TransformationInfo();
    }

    void fillAdditionalState(int ai[]) {
        ai[-1 + ai.length] = mAdditionalState;
    }

    public View findFocus() {
        if((2 & mPrivateFlags) == 0)
            this = null;
        return this;
    }

    View findUserSetNextFocus(View view, int i) {
        View view1 = null;
        i;
        JVM INSTR lookupswitch 6: default 60
    //                   1: 172
    //                   2: 150
    //                   17: 62
    //                   33: 106
    //                   66: 84
    //                   130: 128;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return view1;
_L4:
        if(mNextFocusLeftId != -1)
            view1 = findViewInsideOutShouldExist(view, mNextFocusLeftId);
        continue; /* Loop/switch isn't completed */
_L6:
        if(mNextFocusRightId != -1)
            view1 = findViewInsideOutShouldExist(view, mNextFocusRightId);
        continue; /* Loop/switch isn't completed */
_L5:
        if(mNextFocusUpId != -1)
            view1 = findViewInsideOutShouldExist(view, mNextFocusUpId);
        continue; /* Loop/switch isn't completed */
_L7:
        if(mNextFocusDownId != -1)
            view1 = findViewInsideOutShouldExist(view, mNextFocusDownId);
        continue; /* Loop/switch isn't completed */
_L3:
        if(mNextFocusForwardId != -1)
            view1 = findViewInsideOutShouldExist(view, mNextFocusForwardId);
        continue; /* Loop/switch isn't completed */
_L2:
        if(mID != -1)
            view1 = view.findViewByPredicateInsideOut(this, new Predicate() {

                public boolean apply(View view2) {
                    boolean flag;
                    if(view2.mNextFocusForwardId == id)
                        flag = true;
                    else
                        flag = false;
                    return flag;
                }

                public volatile boolean apply(Object obj) {
                    return apply((View)obj);
                }

                final View this$0;
                final int val$id;

             {
                this$0 = View.this;
                id = i;
                super();
            }
            });
        if(true) goto _L1; else goto _L8
_L8:
    }

    final View findViewByAccessibilityId(int i) {
        View view;
        if(i < 0)
            view = null;
        else
            view = findViewByAccessibilityIdTraversal(i);
        return view;
    }

    View findViewByAccessibilityIdTraversal(int i) {
        if(getAccessibilityViewId() != i)
            this = null;
        return this;
    }

    public final View findViewById(int i) {
        View view;
        if(i < 0)
            view = null;
        else
            view = findViewTraversal(i);
        return view;
    }

    public final View findViewByPredicate(Predicate predicate) {
        return findViewByPredicateTraversal(predicate, null);
    }

    public final View findViewByPredicateInsideOut(View view, Predicate predicate) {
        View view1 = null;
_L5:
        View view2 = view.findViewByPredicateTraversal(predicate, view1);
        if(view2 == null && view != this) goto _L2; else goto _L1
_L1:
        return view2;
_L2:
        ViewParent viewparent;
        viewparent = view.getParent();
        if(viewparent != null && (viewparent instanceof View))
            break; /* Loop/switch isn't completed */
        view2 = null;
        if(true) goto _L1; else goto _L3
_L3:
        view1 = view;
        view = (View)viewparent;
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected View findViewByPredicateTraversal(Predicate predicate, View view) {
        if(!predicate.apply(this))
            this = null;
        return this;
    }

    protected View findViewTraversal(int i) {
        if(i != mID)
            this = null;
        return this;
    }

    public final View findViewWithTag(Object obj) {
        View view;
        if(obj == null)
            view = null;
        else
            view = findViewWithTagTraversal(obj);
        return view;
    }

    protected View findViewWithTagTraversal(Object obj) {
        if(obj == null || !obj.equals(mTag))
            this = null;
        return this;
    }

    public void findViewsWithText(ArrayList arraylist, CharSequence charsequence, int i) {
        if(getAccessibilityNodeProvider() == null) goto _L2; else goto _L1
_L1:
        if((i & 4) != 0)
            arraylist.add(this);
_L4:
        return;
_L2:
        if((i & 2) != 0 && charsequence != null && charsequence.length() > 0 && mContentDescription != null && mContentDescription.length() > 0) {
            String s = charsequence.toString().toLowerCase();
            if(mContentDescription.toString().toLowerCase().contains(s))
                arraylist.add(this);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected boolean fitSystemWindows(Rect rect) {
        boolean flag = false;
        if((2 & mViewFlags) == 2) {
            mUserPaddingStart = -1;
            mUserPaddingEnd = -1;
            mUserPaddingRelative = false;
            if((0x800 & mViewFlags) == 0 || mAttachInfo == null || (0x600 & mAttachInfo.mSystemUiVisibility) == 0) {
                internalSetPadding(rect.left, rect.top, rect.right, rect.bottom);
                flag = true;
            } else {
                internalSetPadding(0, 0, 0, 0);
            }
        }
        return flag;
    }

    public boolean fitsSystemWindows() {
        return getFitsSystemWindows();
    }

    void flushLayer() {
        if(mLayerType == 2 && mHardwareLayer != null)
            mHardwareLayer.flush();
    }

    public View focusSearch(int i) {
        View view;
        if(mParent != null)
            view = mParent.focusSearch(this, i);
        else
            view = null;
        return view;
    }

    public void forceLayout() {
        mPrivateFlags = 0x1000 | mPrivateFlags;
        mPrivateFlags = 0x80000000 | mPrivateFlags;
    }

    public boolean gatherTransparentRegion(Region region) {
        AttachInfo attachinfo = mAttachInfo;
        if(region == null || attachinfo == null) goto _L2; else goto _L1
_L1:
        int i = mPrivateFlags;
        if((i & 0x80) != 0) goto _L4; else goto _L3
_L3:
        int ai[] = attachinfo.mTransparentLocation;
        getLocationInWindow(ai);
        region.op(ai[0], ai[1], (ai[0] + mRight) - mLeft, (ai[1] + mBottom) - mTop, android.graphics.Region.Op.DIFFERENCE);
_L2:
        return true;
_L4:
        if((i & 0x100) != 0 && mBackground != null)
            applyDrawableToTransparentRegion(mBackground, region);
        if(true) goto _L2; else goto _L5
_L5:
    }

    public int getAccessibilityCursorPosition() {
        return mAccessibilityCursorPosition;
    }

    public int getAccessibilityFocusable() {
        return (0x60000000 & mPrivateFlags2) >>> 29;
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityNodeProvider accessibilitynodeprovider;
        if(mAccessibilityDelegate != null)
            accessibilitynodeprovider = mAccessibilityDelegate.getAccessibilityNodeProvider(this);
        else
            accessibilitynodeprovider = null;
        return accessibilitynodeprovider;
    }

    public int getAccessibilityViewId() {
        if(mAccessibilityViewId == -1) {
            int i = sNextAccessibilityViewId;
            sNextAccessibilityViewId = i + 1;
            mAccessibilityViewId = i;
        }
        return mAccessibilityViewId;
    }

    public int getAccessibilityWindowId() {
        int i;
        if(mAttachInfo != null)
            i = mAttachInfo.mAccessibilityWindowId;
        else
            i = -1;
        return i;
    }

    public int getActualAndReportedWindowLeftDelta() {
        int i;
        if(mAttachInfo != null)
            i = mAttachInfo.mActualWindowLeft - mAttachInfo.mWindowLeft;
        else
            i = 0;
        return i;
    }

    public int getActualAndReportedWindowTopDelta() {
        int i;
        if(mAttachInfo != null)
            i = mAttachInfo.mActualWindowTop - mAttachInfo.mWindowTop;
        else
            i = 0;
        return i;
    }

    public float getAlpha() {
        float f;
        if(mTransformationInfo != null)
            f = mTransformationInfo.mAlpha;
        else
            f = 1.0F;
        return f;
    }

    public Animation getAnimation() {
        return mCurrentAnimation;
    }

    public IBinder getApplicationWindowToken() {
        AttachInfo attachinfo = mAttachInfo;
        IBinder ibinder;
        if(attachinfo != null) {
            ibinder = attachinfo.mPanelParentWindowToken;
            if(ibinder == null)
                ibinder = attachinfo.mWindowToken;
        } else {
            ibinder = null;
        }
        return ibinder;
    }

    public Drawable getBackground() {
        return mBackground;
    }

    public int getBaseline() {
        return -1;
    }

    public final int getBottom() {
        return mBottom;
    }

    protected float getBottomFadingEdgeStrength() {
        float f;
        if(computeVerticalScrollOffset() + computeVerticalScrollExtent() < computeVerticalScrollRange())
            f = 1.0F;
        else
            f = 0.0F;
        return f;
    }

    protected int getBottomPaddingOffset() {
        return 0;
    }

    public float getCameraDistance() {
        ensureTransformationInfo();
        float f = mResources.getDisplayMetrics().densityDpi;
        TransformationInfo transformationinfo = mTransformationInfo;
        if(transformationinfo.mCamera == null) {
            transformationinfo.mCamera = new Camera();
            transformationinfo.matrix3D = new Matrix();
        }
        return -(f * transformationinfo.mCamera.getLocationZ());
    }

    public CharSequence getContentDescription() {
        return mContentDescription;
    }

    public final Context getContext() {
        return mContext;
    }

    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return null;
    }

    public DisplayList getDisplayList() {
        mDisplayList = getDisplayList(mDisplayList, false);
        return mDisplayList;
    }

    public final int[] getDrawableState() {
        int ai[];
        if(mDrawableState != null && (0x400 & mPrivateFlags) == 0) {
            ai = mDrawableState;
        } else {
            mDrawableState = onCreateDrawableState(0);
            mPrivateFlags = 0xfffffbff & mPrivateFlags;
            ai = mDrawableState;
        }
        return ai;
    }

    public Bitmap getDrawingCache() {
        return getDrawingCache(false);
    }

    public Bitmap getDrawingCache(boolean flag) {
        Bitmap bitmap;
        if((0x20000 & mViewFlags) == 0x20000) {
            bitmap = null;
        } else {
            if((0x8000 & mViewFlags) == 32768)
                buildDrawingCache(flag);
            if(flag)
                bitmap = mDrawingCache;
            else
                bitmap = mUnscaledDrawingCache;
        }
        return bitmap;
    }

    public int getDrawingCacheBackgroundColor() {
        return mDrawingCacheBackgroundColor;
    }

    public int getDrawingCacheQuality() {
        return 0x180000 & mViewFlags;
    }

    public void getDrawingRect(Rect rect) {
        rect.left = mScrollX;
        rect.top = mScrollY;
        rect.right = mScrollX + (mRight - mLeft);
        rect.bottom = mScrollY + (mBottom - mTop);
    }

    public long getDrawingTime() {
        long l;
        if(mAttachInfo != null)
            l = mAttachInfo.mDrawingTime;
        else
            l = 0L;
        return l;
    }

    protected int getFadeHeight(boolean flag) {
        int i = mPaddingTop;
        if(flag)
            i += getTopPaddingOffset();
        return mBottom - mTop - mPaddingBottom - i;
    }

    protected int getFadeTop(boolean flag) {
        int i = mPaddingTop;
        if(flag)
            i += getTopPaddingOffset();
        return i;
    }

    public boolean getFilterTouchesWhenObscured() {
        boolean flag;
        if((0x400 & mViewFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean getFitsSystemWindows() {
        boolean flag;
        if((2 & mViewFlags) == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public ArrayList getFocusables(int i) {
        ArrayList arraylist = new ArrayList(24);
        addFocusables(arraylist, i);
        return arraylist;
    }

    public void getFocusedRect(Rect rect) {
        getDrawingRect(rect);
    }

    public final boolean getGlobalVisibleRect(Rect rect) {
        return getGlobalVisibleRect(rect, null);
    }

    public boolean getGlobalVisibleRect(Rect rect, Point point) {
        boolean flag = false;
        int i = mRight - mLeft;
        int j = mBottom - mTop;
        if(i > 0 && j > 0) {
            rect.set(0, 0, i, j);
            if(point != null)
                point.set(-mScrollX, -mScrollY);
            if(mParent == null || mParent.getChildVisibleRect(this, rect, point))
                flag = true;
        }
        return flag;
    }

    public Handler getHandler() {
        Handler handler;
        if(mAttachInfo != null)
            handler = mAttachInfo.mHandler;
        else
            handler = null;
        return handler;
    }

    HardwareLayer getHardwareLayer() {
        HardwareLayer hardwarelayer;
        hardwarelayer = null;
        break MISSING_BLOCK_LABEL_2;
        while(true)  {
            do
                return hardwarelayer;
            while(mAttachInfo == null || mAttachInfo.mHardwareRenderer == null || !mAttachInfo.mHardwareRenderer.isEnabled() || !mAttachInfo.mHardwareRenderer.validate());
            int i = mRight - mLeft;
            int j = mBottom - mTop;
            if(i == 0 || j == 0)
                continue;
            if((0x8000 & mPrivateFlags) == 0 || mHardwareLayer == null) {
                if(mHardwareLayer == null) {
                    mHardwareLayer = mAttachInfo.mHardwareRenderer.createHardwareLayer(i, j, isOpaque());
                    mLocalDirtyRect.set(0, 0, i, j);
                } else
                if(mHardwareLayer.getWidth() != i || mHardwareLayer.getHeight() != j) {
                    mHardwareLayer.resize(i, j);
                    mLocalDirtyRect.set(0, 0, i, j);
                }
                if(!mHardwareLayer.isValid())
                    continue;
                mHardwareLayer.redraw(getHardwareLayerDisplayList(mHardwareLayer), mLocalDirtyRect);
                mLocalDirtyRect.setEmpty();
            }
            hardwarelayer = mHardwareLayer;
        }
    }

    public HardwareRenderer getHardwareRenderer() {
        HardwareRenderer hardwarerenderer;
        if(mAttachInfo != null)
            hardwarerenderer = mAttachInfo.mHardwareRenderer;
        else
            hardwarerenderer = null;
        return hardwarerenderer;
    }

    public final int getHeight() {
        return mBottom - mTop;
    }

    public void getHitRect(Rect rect) {
        updateMatrix();
        TransformationInfo transformationinfo = mTransformationInfo;
        if(transformationinfo == null || transformationinfo.mMatrixIsIdentity || mAttachInfo == null) {
            rect.set(mLeft, mTop, mRight, mBottom);
        } else {
            RectF rectf = mAttachInfo.mTmpTransformRect;
            rectf.set(-transformationinfo.mPivotX, -transformationinfo.mPivotY, (float)getWidth() - transformationinfo.mPivotX, (float)getHeight() - transformationinfo.mPivotY);
            transformationinfo.mMatrix.mapRect(rectf);
            rect.set((int)rectf.left + mLeft, (int)rectf.top + mTop, (int)rectf.right + mLeft, (int)rectf.bottom + mTop);
        }
    }

    public int getHorizontalFadingEdgeLength() {
        if(!isHorizontalFadingEdgeEnabled()) goto _L2; else goto _L1
_L1:
        ScrollabilityCache scrollabilitycache = mScrollCache;
        if(scrollabilitycache == null) goto _L2; else goto _L3
_L3:
        int i = scrollabilitycache.fadingEdgeLength;
_L5:
        return i;
_L2:
        i = 0;
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected float getHorizontalScrollFactor() {
        return getVerticalScrollFactor();
    }

    protected int getHorizontalScrollbarHeight() {
        int i = 0;
        ScrollabilityCache scrollabilitycache = mScrollCache;
        if(scrollabilitycache != null) {
            ScrollBarDrawable scrollbardrawable = scrollabilitycache.scrollBar;
            if(scrollbardrawable != null) {
                i = scrollbardrawable.getSize(false);
                if(i <= 0)
                    i = scrollabilitycache.scrollBarSize;
            }
        }
        return i;
    }

    public int getId() {
        return mID;
    }

    public int getImportantForAccessibility() {
        return (0x300000 & mPrivateFlags2) >> 20;
    }

    final Matrix getInverseMatrix() {
        TransformationInfo transformationinfo = mTransformationInfo;
        Matrix matrix;
        if(transformationinfo != null) {
            updateMatrix();
            if(transformationinfo.mInverseMatrixDirty) {
                if(transformationinfo.mInverseMatrix == null)
                    transformationinfo.mInverseMatrix = new Matrix();
                transformationinfo.mMatrix.invert(transformationinfo.mInverseMatrix);
                transformationinfo.mInverseMatrixDirty = false;
            }
            matrix = transformationinfo.mInverseMatrix;
        } else {
            matrix = Matrix.IDENTITY_MATRIX;
        }
        return matrix;
    }

    public CharSequence getIterableTextForAccessibility() {
        return mContentDescription;
    }

    public AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(int i) {
        i;
        JVM INSTR lookupswitch 3: default 36
    //                   1: 40
    //                   2: 90
    //                   8: 140;
           goto _L1 _L2 _L3 _L4
_L1:
        Object obj = null;
_L6:
        CharSequence charsequence2;
        return ((AccessibilityIterators.TextSegmentIterator) (obj));
_L2:
        if((charsequence2 = getIterableTextForAccessibility()) == null || charsequence2.length() <= 0) goto _L1; else goto _L5
_L5:
        obj = AccessibilityIterators.CharacterTextSegmentIterator.getInstance(mContext.getResources().getConfiguration().locale);
        ((AccessibilityIterators.CharacterTextSegmentIterator) (obj)).initialize(charsequence2.toString());
          goto _L6
_L3:
        CharSequence charsequence1 = getIterableTextForAccessibility();
        if(charsequence1 == null || charsequence1.length() <= 0) goto _L1; else goto _L7
_L7:
        obj = AccessibilityIterators.WordTextSegmentIterator.getInstance(mContext.getResources().getConfiguration().locale);
        ((AccessibilityIterators.WordTextSegmentIterator) (obj)).initialize(charsequence1.toString());
          goto _L6
_L4:
        CharSequence charsequence = getIterableTextForAccessibility();
        if(charsequence == null || charsequence.length() <= 0) goto _L1; else goto _L8
_L8:
        obj = AccessibilityIterators.ParagraphTextSegmentIterator.getInstance();
        ((AccessibilityIterators.ParagraphTextSegmentIterator) (obj)).initialize(charsequence.toString());
          goto _L6
    }

    public boolean getKeepScreenOn() {
        boolean flag;
        if((0x4000000 & mViewFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public KeyEvent.DispatcherState getKeyDispatcherState() {
        KeyEvent.DispatcherState dispatcherstate;
        if(mAttachInfo != null)
            dispatcherstate = mAttachInfo.mKeyDispatchState;
        else
            dispatcherstate = null;
        return dispatcherstate;
    }

    public int getLayerType() {
        return mLayerType;
    }

    public int getLayoutDirection() {
        return (0xc & mPrivateFlags2) >> 2;
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        return mLayoutParams;
    }

    public final int getLeft() {
        return mLeft;
    }

    protected float getLeftFadingEdgeStrength() {
        float f;
        if(computeHorizontalScrollOffset() > 0)
            f = 1.0F;
        else
            f = 0.0F;
        return f;
    }

    protected int getLeftPaddingOffset() {
        return 0;
    }

    ListenerInfo getListenerInfo() {
        ListenerInfo listenerinfo;
        if(mListenerInfo != null) {
            listenerinfo = mListenerInfo;
        } else {
            mListenerInfo = new ListenerInfo();
            listenerinfo = mListenerInfo;
        }
        return listenerinfo;
    }

    public final boolean getLocalVisibleRect(Rect rect) {
        Point point;
        boolean flag;
        if(mAttachInfo != null)
            point = mAttachInfo.mPoint;
        else
            point = new Point();
        if(getGlobalVisibleRect(rect, point)) {
            rect.offset(-point.x, -point.y);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void getLocationInWindow(int ai[]) {
        if(ai == null || ai.length < 2)
            throw new IllegalArgumentException("location must be an array of two integers");
        if(mAttachInfo == null) {
            ai[1] = 0;
            ai[0] = 0;
        } else {
            float af[] = mAttachInfo.mTmpTransformLocation;
            af[1] = 0.0F;
            af[0] = 0.0F;
            if(!hasIdentityMatrix())
                getMatrix().mapPoints(af);
            af[0] = af[0] + (float)mLeft;
            af[1] = af[1] + (float)mTop;
            ViewParent viewparent;
            View view;
            for(viewparent = mParent; viewparent instanceof View; viewparent = view.mParent) {
                view = (View)viewparent;
                af[0] = af[0] - (float)view.mScrollX;
                af[1] = af[1] - (float)view.mScrollY;
                if(!view.hasIdentityMatrix())
                    view.getMatrix().mapPoints(af);
                af[0] = af[0] + (float)view.mLeft;
                af[1] = af[1] + (float)view.mTop;
            }

            if(viewparent instanceof ViewRootImpl) {
                ViewRootImpl viewrootimpl = (ViewRootImpl)viewparent;
                af[1] = af[1] - (float)viewrootimpl.mCurScrollY;
            }
            ai[0] = (int)(0.5F + af[0]);
            ai[1] = (int)(0.5F + af[1]);
        }
    }

    public void getLocationOnScreen(int ai[]) {
        getLocationInWindow(ai);
        AttachInfo attachinfo = mAttachInfo;
        if(attachinfo != null) {
            ai[0] = ai[0] + attachinfo.mWindowLeft;
            ai[1] = ai[1] + attachinfo.mWindowTop;
        }
    }

    public Matrix getMatrix() {
        Matrix matrix;
        if(mTransformationInfo != null) {
            updateMatrix();
            matrix = mTransformationInfo.mMatrix;
        } else {
            matrix = Matrix.IDENTITY_MATRIX;
        }
        return matrix;
    }

    public final int getMeasuredHeight() {
        return 0xffffff & mMeasuredHeight;
    }

    public final int getMeasuredHeightAndState() {
        return mMeasuredHeight;
    }

    public final int getMeasuredState() {
        return 0xff000000 & mMeasuredWidth | 0xffffff00 & mMeasuredHeight >> 16;
    }

    public final int getMeasuredWidth() {
        return 0xffffff & mMeasuredWidth;
    }

    public final int getMeasuredWidthAndState() {
        return mMeasuredWidth;
    }

    public int getMinimumHeight() {
        return mMinHeight;
    }

    public int getMinimumWidth() {
        return mMinWidth;
    }

    public int getNextFocusDownId() {
        return mNextFocusDownId;
    }

    public int getNextFocusForwardId() {
        return mNextFocusForwardId;
    }

    public int getNextFocusLeftId() {
        return mNextFocusLeftId;
    }

    public int getNextFocusRightId() {
        return mNextFocusRightId;
    }

    public int getNextFocusUpId() {
        return mNextFocusUpId;
    }

    public OnFocusChangeListener getOnFocusChangeListener() {
        ListenerInfo listenerinfo = mListenerInfo;
        OnFocusChangeListener onfocuschangelistener;
        if(listenerinfo != null)
            onfocuschangelistener = listenerinfo.mOnFocusChangeListener;
        else
            onfocuschangelistener = null;
        return onfocuschangelistener;
    }

    public Insets getOpticalInsets() {
        if(mLayoutInsets == null) {
            Insets insets;
            if(mBackground == null)
                insets = Insets.NONE;
            else
                insets = mBackground.getLayoutInsets();
            mLayoutInsets = insets;
        }
        return mLayoutInsets;
    }

    public int getOverScrollMode() {
        return mOverScrollMode;
    }

    public int getPaddingBottom() {
        return mPaddingBottom;
    }

    public int getPaddingEnd() {
        int i;
        if(getResolvedLayoutDirection() == 1)
            i = mPaddingLeft;
        else
            i = mPaddingRight;
        return i;
    }

    public int getPaddingLeft() {
        return mPaddingLeft;
    }

    public int getPaddingRight() {
        return mPaddingRight;
    }

    public int getPaddingStart() {
        int i;
        if(getResolvedLayoutDirection() == 1)
            i = mPaddingRight;
        else
            i = mPaddingLeft;
        return i;
    }

    public int getPaddingTop() {
        return mPaddingTop;
    }

    public final ViewParent getParent() {
        return mParent;
    }

    public ViewParent getParentForAccessibility() {
        ViewParent viewparent;
        if(mParent instanceof View) {
            if(((View)mParent).includeForAccessibility())
                viewparent = mParent;
            else
                viewparent = mParent.getParentForAccessibility();
        } else {
            viewparent = null;
        }
        return viewparent;
    }

    public float getPivotX() {
        float f;
        if(mTransformationInfo != null)
            f = mTransformationInfo.mPivotX;
        else
            f = 0.0F;
        return f;
    }

    public float getPivotY() {
        float f;
        if(mTransformationInfo != null)
            f = mTransformationInfo.mPivotY;
        else
            f = 0.0F;
        return f;
    }

    public int getResolvedLayoutDirection() {
        if((0x20 & mPrivateFlags2) != 32)
            resolveLayoutDirection();
        int i;
        if((0x10 & mPrivateFlags2) == 16)
            i = 1;
        else
            i = 0;
        return i;
    }

    public int getResolvedLayoutDirection(Drawable drawable) {
        int i;
        if(drawable == mBackground)
            i = getResolvedLayoutDirection();
        else
            i = 2;
        return i;
    }

    public int getResolvedTextAlignment() {
        if((0x10000 & mPrivateFlags2) != 0x10000)
            resolveTextAlignment();
        return (0xe0000 & mPrivateFlags2) >> 17;
    }

    public int getResolvedTextDirection() {
        if((0x200 & mPrivateFlags2) != 512)
            resolveTextDirection();
        return (0x1c00 & mPrivateFlags2) >> 10;
    }

    public Resources getResources() {
        return mResources;
    }

    public final int getRight() {
        return mRight;
    }

    protected float getRightFadingEdgeStrength() {
        float f;
        if(computeHorizontalScrollOffset() + computeHorizontalScrollExtent() < computeHorizontalScrollRange())
            f = 1.0F;
        else
            f = 0.0F;
        return f;
    }

    protected int getRightPaddingOffset() {
        return 0;
    }

    public View getRootView() {
        if(mAttachInfo == null) goto _L2; else goto _L1
_L1:
        View view1 = mAttachInfo.mRootView;
        if(view1 == null) goto _L2; else goto _L3
_L3:
        return view1;
_L2:
        View view;
        for(view = this; view.mParent != null && (view.mParent instanceof View); view = (View)view.mParent);
        view1 = view;
        if(true) goto _L3; else goto _L4
_L4:
    }

    public float getRotation() {
        float f;
        if(mTransformationInfo != null)
            f = mTransformationInfo.mRotation;
        else
            f = 0.0F;
        return f;
    }

    public float getRotationX() {
        float f;
        if(mTransformationInfo != null)
            f = mTransformationInfo.mRotationX;
        else
            f = 0.0F;
        return f;
    }

    public float getRotationY() {
        float f;
        if(mTransformationInfo != null)
            f = mTransformationInfo.mRotationY;
        else
            f = 0.0F;
        return f;
    }

    public float getScaleX() {
        float f;
        if(mTransformationInfo != null)
            f = mTransformationInfo.mScaleX;
        else
            f = 1.0F;
        return f;
    }

    public float getScaleY() {
        float f;
        if(mTransformationInfo != null)
            f = mTransformationInfo.mScaleY;
        else
            f = 1.0F;
        return f;
    }

    public int getScrollBarDefaultDelayBeforeFade() {
        int i;
        if(mScrollCache == null)
            i = ViewConfiguration.getScrollDefaultDelay();
        else
            i = mScrollCache.scrollBarDefaultDelayBeforeFade;
        return i;
    }

    public int getScrollBarFadeDuration() {
        int i;
        if(mScrollCache == null)
            i = ViewConfiguration.getScrollBarFadeDuration();
        else
            i = mScrollCache.scrollBarFadeDuration;
        return i;
    }

    public int getScrollBarSize() {
        int i;
        if(mScrollCache == null)
            i = ViewConfiguration.get(mContext).getScaledScrollBarSize();
        else
            i = mScrollCache.scrollBarSize;
        return i;
    }

    public int getScrollBarStyle() {
        return 0x3000000 & mViewFlags;
    }

    public final int getScrollX() {
        return mScrollX;
    }

    public final int getScrollY() {
        return mScrollY;
    }

    public int getSolidColor() {
        return 0;
    }

    protected int getSuggestedMinimumHeight() {
        int i;
        if(mBackground == null)
            i = mMinHeight;
        else
            i = Math.max(mMinHeight, mBackground.getMinimumHeight());
        return i;
    }

    protected int getSuggestedMinimumWidth() {
        int i;
        if(mBackground == null)
            i = mMinWidth;
        else
            i = Math.max(mMinWidth, mBackground.getMinimumWidth());
        return i;
    }

    public int getSystemUiVisibility() {
        return mSystemUiVisibility;
    }

    public Object getTag() {
        return mTag;
    }

    public Object getTag(int i) {
        Object obj;
        if(mKeyedTags != null)
            obj = mKeyedTags.get(i);
        else
            obj = null;
        return obj;
    }

    public int getTextAlignment() {
        return (0xe000 & mPrivateFlags2) >> 13;
    }

    public int getTextDirection() {
        return (0x1c0 & mPrivateFlags2) >> 6;
    }

    public final int getTop() {
        return mTop;
    }

    protected float getTopFadingEdgeStrength() {
        float f;
        if(computeVerticalScrollOffset() > 0)
            f = 1.0F;
        else
            f = 0.0F;
        return f;
    }

    protected int getTopPaddingOffset() {
        return 0;
    }

    public TouchDelegate getTouchDelegate() {
        return mTouchDelegate;
    }

    public ArrayList getTouchables() {
        ArrayList arraylist = new ArrayList();
        addTouchables(arraylist);
        return arraylist;
    }

    public float getTranslationX() {
        float f;
        if(mTransformationInfo != null)
            f = mTransformationInfo.mTranslationX;
        else
            f = 0.0F;
        return f;
    }

    public float getTranslationY() {
        float f;
        if(mTransformationInfo != null)
            f = mTransformationInfo.mTranslationY;
        else
            f = 0.0F;
        return f;
    }

    public int getVerticalFadingEdgeLength() {
        if(!isVerticalFadingEdgeEnabled()) goto _L2; else goto _L1
_L1:
        ScrollabilityCache scrollabilitycache = mScrollCache;
        if(scrollabilitycache == null) goto _L2; else goto _L3
_L3:
        int i = scrollabilitycache.fadingEdgeLength;
_L5:
        return i;
_L2:
        i = 0;
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected float getVerticalScrollFactor() {
        if(mVerticalScrollFactor == 0.0F) {
            TypedValue typedvalue = new TypedValue();
            if(!mContext.getTheme().resolveAttribute(0x101004d, typedvalue, true))
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            mVerticalScrollFactor = typedvalue.getDimension(mContext.getResources().getDisplayMetrics());
        }
        return mVerticalScrollFactor;
    }

    public int getVerticalScrollbarPosition() {
        return mVerticalScrollbarPosition;
    }

    public int getVerticalScrollbarWidth() {
        int i = 0;
        ScrollabilityCache scrollabilitycache = mScrollCache;
        if(scrollabilitycache != null) {
            ScrollBarDrawable scrollbardrawable = scrollabilitycache.scrollBar;
            if(scrollbardrawable != null) {
                i = scrollbardrawable.getSize(true);
                if(i <= 0)
                    i = scrollabilitycache.scrollBarSize;
            }
        }
        return i;
    }

    public ViewRootImpl getViewRootImpl() {
        ViewRootImpl viewrootimpl;
        if(mAttachInfo != null)
            viewrootimpl = mAttachInfo.mViewRootImpl;
        else
            viewrootimpl = null;
        return viewrootimpl;
    }

    public ViewTreeObserver getViewTreeObserver() {
        ViewTreeObserver viewtreeobserver;
        if(mAttachInfo != null) {
            viewtreeobserver = mAttachInfo.mTreeObserver;
        } else {
            if(mFloatingTreeObserver == null)
                mFloatingTreeObserver = new ViewTreeObserver();
            viewtreeobserver = mFloatingTreeObserver;
        }
        return viewtreeobserver;
    }

    public int getVisibility() {
        return 0xc & mViewFlags;
    }

    public final int getWidth() {
        return mRight - mLeft;
    }

    protected int getWindowAttachCount() {
        return mWindowAttachCount;
    }

    IWindowSession getWindowSession() {
        IWindowSession iwindowsession;
        if(mAttachInfo != null)
            iwindowsession = mAttachInfo.mSession;
        else
            iwindowsession = null;
        return iwindowsession;
    }

    public int getWindowSystemUiVisibility() {
        int i;
        if(mAttachInfo != null)
            i = mAttachInfo.mSystemUiVisibility;
        else
            i = 0;
        return i;
    }

    public IBinder getWindowToken() {
        IBinder ibinder;
        if(mAttachInfo != null)
            ibinder = mAttachInfo.mWindowToken;
        else
            ibinder = null;
        return ibinder;
    }

    public int getWindowVisibility() {
        int i;
        if(mAttachInfo != null)
            i = mAttachInfo.mWindowVisibility;
        else
            i = 8;
        return i;
    }

    public void getWindowVisibleDisplayFrame(Rect rect) {
        if(mAttachInfo == null) goto _L2; else goto _L1
_L1:
        Rect rect1;
        try {
            mAttachInfo.mSession.getDisplayFrame(mAttachInfo.mWindow, rect);
        }
        catch(RemoteException remoteexception) {
            continue; /* Loop/switch isn't completed */
        }
        rect1 = mAttachInfo.mVisibleInsets;
        rect.left = rect.left + rect1.left;
        rect.top = rect.top + rect1.top;
        rect.right = rect.right - rect1.right;
        rect.bottom = rect.bottom - rect1.bottom;
_L4:
        return;
_L2:
        WindowManagerImpl.getDefault().getDefaultDisplay().getRectSize(rect);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public float getX() {
        float f = mLeft;
        float f1;
        if(mTransformationInfo != null)
            f1 = mTransformationInfo.mTranslationX;
        else
            f1 = 0.0F;
        return f1 + f;
    }

    public float getY() {
        float f = mTop;
        float f1;
        if(mTransformationInfo != null)
            f1 = mTransformationInfo.mTranslationY;
        else
            f1 = 0.0F;
        return f1 + f;
    }

    public void hackTurnOffWindowResizeAnim(boolean flag) {
        mAttachInfo.mTurnOffWindowResizeAnim = flag;
    }

    void handleFocusGainInternal(int i, Rect rect) {
        if((2 & mPrivateFlags) == 0) {
            mPrivateFlags = 2 | mPrivateFlags;
            if(mParent != null)
                mParent.requestChildFocus(this, this);
            onFocusChanged(true, i, rect);
            refreshDrawableState();
            if(AccessibilityManager.getInstance(mContext).isEnabled())
                notifyAccessibilityStateChanged();
        }
    }

    public boolean hasFocus() {
        boolean flag;
        if((2 & mPrivateFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasFocusable() {
        boolean flag;
        if((0xc & mViewFlags) == 0 && isFocusable())
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected boolean hasHoveredChild() {
        return false;
    }

    final boolean hasIdentityMatrix() {
        boolean flag;
        if(mTransformationInfo != null) {
            updateMatrix();
            flag = mTransformationInfo.mMatrixIsIdentity;
        } else {
            flag = true;
        }
        return flag;
    }

    public boolean hasOnClickListeners() {
        ListenerInfo listenerinfo = mListenerInfo;
        boolean flag;
        if(listenerinfo != null && listenerinfo.mOnClickListener != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected boolean hasOpaqueScrollbars() {
        boolean flag;
        if((0x1000000 & mPrivateFlags) == 0x1000000)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasOverlappingRendering() {
        return true;
    }

    boolean hasStaticLayer() {
        return true;
    }

    public boolean hasTransientState() {
        boolean flag;
        if((0x100 & mPrivateFlags2) == 256)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasWindowFocus() {
        boolean flag;
        if(mAttachInfo != null && mAttachInfo.mHasWindowFocus)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean includeForAccessibility() {
        boolean flag;
        if(mAttachInfo != null) {
            if(!mAttachInfo.mIncludeNotImportantViews)
                flag = isImportantForAccessibility();
            else
                flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    protected void initializeFadingEdge(TypedArray typedarray) {
        initScrollCache();
        mScrollCache.fadingEdgeLength = typedarray.getDimensionPixelSize(24, ViewConfiguration.get(mContext).getScaledFadingEdgeLength());
    }

    protected void initializeScrollbars(TypedArray typedarray) {
        initScrollCache();
        ScrollabilityCache scrollabilitycache = mScrollCache;
        if(scrollabilitycache.scrollBar == null)
            scrollabilitycache.scrollBar = new ScrollBarDrawable();
        boolean flag = typedarray.getBoolean(44, true);
        if(!flag)
            scrollabilitycache.state = 1;
        scrollabilitycache.fadeScrollBars = flag;
        scrollabilitycache.scrollBarFadeDuration = typedarray.getInt(42, ViewConfiguration.getScrollBarFadeDuration());
        scrollabilitycache.scrollBarDefaultDelayBeforeFade = typedarray.getInt(43, ViewConfiguration.getScrollDefaultDelay());
        scrollabilitycache.scrollBarSize = typedarray.getDimensionPixelSize(0, ViewConfiguration.get(mContext).getScaledScrollBarSize());
        Drawable drawable = typedarray.getDrawable(3);
        scrollabilitycache.scrollBar.setHorizontalTrackDrawable(drawable);
        Drawable drawable1 = typedarray.getDrawable(1);
        if(drawable1 != null)
            scrollabilitycache.scrollBar.setHorizontalThumbDrawable(drawable1);
        if(typedarray.getBoolean(5, false))
            scrollabilitycache.scrollBar.setAlwaysDrawHorizontalTrack(true);
        Drawable drawable2 = typedarray.getDrawable(4);
        scrollabilitycache.scrollBar.setVerticalTrackDrawable(drawable2);
        Drawable drawable3 = typedarray.getDrawable(2);
        if(drawable3 != null)
            scrollabilitycache.scrollBar.setVerticalThumbDrawable(drawable3);
        if(typedarray.getBoolean(6, false))
            scrollabilitycache.scrollBar.setAlwaysDrawVerticalTrack(true);
        resolvePadding();
    }

    public void invalidate() {
        invalidate(true);
    }

    public void invalidate(int i, int j, int k, int l) {
_L2:
        return;
        if(skipInvalidate() || (0x30 & mPrivateFlags) != 48 && (0x8000 & mPrivateFlags) != 32768 && (0x80000000 & mPrivateFlags) == 0x80000000) goto _L2; else goto _L1
_L1:
        mPrivateFlags = 0xffff7fff & mPrivateFlags;
        mPrivateFlags = 0x80000000 | mPrivateFlags;
        mPrivateFlags = 0x200000 | mPrivateFlags;
        ViewParent viewparent = mParent;
        AttachInfo attachinfo = mAttachInfo;
        if(viewparent != null && attachinfo != null && i < k && j < l) {
            int i1 = mScrollX;
            int j1 = mScrollY;
            Rect rect = attachinfo.mTmpInvalRect;
            rect.set(i - i1, j - j1, k - i1, l - j1);
            viewparent.invalidateChild(this, rect);
        }
        if(true) goto _L2; else goto _L3
_L3:
    }

    public void invalidate(Rect rect) {
_L2:
        return;
        if(skipInvalidate() || (0x30 & mPrivateFlags) != 48 && (0x8000 & mPrivateFlags) != 32768 && (0x80000000 & mPrivateFlags) == 0x80000000) goto _L2; else goto _L1
_L1:
        mPrivateFlags = 0xffff7fff & mPrivateFlags;
        mPrivateFlags = 0x80000000 | mPrivateFlags;
        mPrivateFlags = 0x200000 | mPrivateFlags;
        ViewParent viewparent = mParent;
        AttachInfo attachinfo = mAttachInfo;
        if(viewparent != null && attachinfo != null) {
            int i = mScrollX;
            int j = mScrollY;
            Rect rect1 = attachinfo.mTmpInvalRect;
            rect1.set(rect.left - i, rect.top - j, rect.right - i, rect.bottom - j);
            mParent.invalidateChild(this, rect1);
        }
        if(true) goto _L2; else goto _L3
_L3:
    }

    void invalidate(boolean flag) {
_L2:
        return;
        if(skipInvalidate() || (0x30 & mPrivateFlags) != 48 && (!flag || (0x8000 & mPrivateFlags) != 32768) && (0x80000000 & mPrivateFlags) == 0x80000000 && isOpaque() == mLastIsOpaque) goto _L2; else goto _L1
_L1:
        mLastIsOpaque = isOpaque();
        mPrivateFlags = 0xffffffdf & mPrivateFlags;
        mPrivateFlags = 0x200000 | mPrivateFlags;
        if(flag) {
            mPrivateFlags = 0x80000000 | mPrivateFlags;
            mPrivateFlags = 0xffff7fff & mPrivateFlags;
        }
        AttachInfo attachinfo = mAttachInfo;
        ViewParent viewparent = mParent;
        if(viewparent != null && attachinfo != null) {
            Rect rect = attachinfo.mTmpInvalRect;
            rect.set(0, 0, mRight - mLeft, mBottom - mTop);
            viewparent.invalidateChild(this, rect);
        }
        if(true) goto _L2; else goto _L3
_L3:
    }

    public void invalidateDrawable(Drawable drawable) {
        if(verifyDrawable(drawable)) {
            Rect rect = drawable.getBounds();
            int i = mScrollX;
            int j = mScrollY;
            invalidate(i + rect.left, j + rect.top, i + rect.right, j + rect.bottom);
        }
    }

    protected void invalidateParentCaches() {
        if(mParent instanceof View) {
            View view = (View)mParent;
            view.mPrivateFlags = 0x80000000 | view.mPrivateFlags;
        }
    }

    protected void invalidateParentIfNeeded() {
        if(isHardwareAccelerated() && (mParent instanceof View))
            ((View)mParent).invalidate(true);
    }

    void invalidateViewProperty(boolean flag, boolean flag1) {
        if(mDisplayList != null && (0x40 & mPrivateFlags) != 64) goto _L2; else goto _L1
_L1:
        if(flag)
            invalidateParentCaches();
        if(flag1)
            mPrivateFlags = 0x20 | mPrivateFlags;
        invalidate(false);
_L4:
        return;
_L2:
        AttachInfo attachinfo = mAttachInfo;
        if(mParent != null && attachinfo != null) {
            Rect rect = attachinfo.mTmpInvalRect;
            rect.set(0, 0, mRight - mLeft, mBottom - mTop);
            if(mParent instanceof ViewGroup)
                ((ViewGroup)mParent).invalidateChildFast(this, rect);
            else
                mParent.invalidateChild(this, rect);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean isAccessibilityFocusable() {
        boolean flag;
        int i;
        flag = false;
        i = (0x60000000 & mPrivateFlags2) >>> 29;
        i;
        JVM INSTR tableswitch 0 2: default 40
    //                   0 72
    //                   1 68
    //                   2 70;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknow accessibility focusable mode: ").append(i).toString());
_L3:
        flag = true;
_L4:
        return flag;
_L2:
        if(canTakeAccessibilityFocusFromHover() || getAccessibilityNodeProvider() != null)
            flag = true;
        if(true) goto _L4; else goto _L5
_L5:
    }

    boolean isAccessibilityFocused() {
        boolean flag;
        if((0x4000000 & mPrivateFlags2) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isActionableForAccessibility() {
        boolean flag;
        if(isClickable() || isLongClickable() || isFocusable())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isActivated() {
        boolean flag;
        if((0x40000000 & mPrivateFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isClickable() {
        boolean flag;
        if((0x4000 & mViewFlags) == 16384)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isDirty() {
        boolean flag;
        if((0x600000 & mPrivateFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isDrawingCacheEnabled() {
        boolean flag;
        if((0x8000 & mViewFlags) == 32768)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isDuplicateParentStateEnabled() {
        boolean flag;
        if((0x400000 & mViewFlags) == 0x400000)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isEnabled() {
        boolean flag;
        if((0x20 & mViewFlags) == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean isFocusable() {
        boolean flag = true;
        if(flag != (1 & mViewFlags))
            flag = false;
        return flag;
    }

    public final boolean isFocusableInTouchMode() {
        boolean flag;
        if(0x40000 == (0x40000 & mViewFlags))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isFocused() {
        boolean flag;
        if((2 & mPrivateFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isHapticFeedbackEnabled() {
        boolean flag;
        if(0x10000000 == (0x10000000 & mViewFlags))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isHardwareAccelerated() {
        boolean flag;
        if(mAttachInfo != null && mAttachInfo.mHardwareAccelerated)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isHorizontalFadingEdgeEnabled() {
        boolean flag;
        if((0x1000 & mViewFlags) == 4096)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isHorizontalScrollBarEnabled() {
        boolean flag;
        if((0x100 & mViewFlags) == 256)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isHovered() {
        boolean flag;
        if((0x10000000 & mPrivateFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isImportantForAccessibility() {
        boolean flag;
        int i;
        flag = false;
        i = (0x300000 & mPrivateFlags2) >> 20;
        i;
        JVM INSTR tableswitch 0 2: default 40
    //                   0 72
    //                   1 68
    //                   2 70;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknow important for accessibility mode: ").append(i).toString());
_L3:
        flag = true;
_L4:
        return flag;
_L2:
        if(isActionableForAccessibility() || hasListenersForAccessibility())
            flag = true;
        if(true) goto _L4; else goto _L5
_L5:
    }

    public boolean isInEditMode() {
        return false;
    }

    public boolean isInScrollingContainer() {
        ViewParent viewparent = getParent();
_L3:
        if(viewparent == null || !(viewparent instanceof ViewGroup))
            break MISSING_BLOCK_LABEL_40;
        if(!((ViewGroup)viewparent).shouldDelayChildPressedState()) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        viewparent = viewparent.getParent();
          goto _L3
        flag = false;
          goto _L4
    }

    public boolean isInTouchMode() {
        boolean flag;
        if(mAttachInfo != null)
            flag = mAttachInfo.mInTouchMode;
        else
            flag = ViewRootImpl.isInTouchMode();
        return flag;
    }

    public boolean isLayoutRequested() {
        boolean flag;
        if((0x1000 & mPrivateFlags) == 4096)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isLayoutRtl() {
        boolean flag = true;
        if(getResolvedLayoutDirection() != flag)
            flag = false;
        return flag;
    }

    public boolean isLongClickable() {
        boolean flag;
        if((0x200000 & mViewFlags) == 0x200000)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isOpaque() {
        if((0x1800000 & mPrivateFlags) != 0x1800000) goto _L2; else goto _L1
_L1:
        boolean flag;
        float f;
        if(mTransformationInfo != null)
            f = mTransformationInfo.mAlpha;
        else
            f = 1.0F;
        if(f < 0.9791667F) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        return flag;
_L2:
        flag = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected boolean isPaddingOffsetRequired() {
        return false;
    }

    public boolean isPaddingRelative() {
        return mUserPaddingRelative;
    }

    public boolean isPressed() {
        boolean flag;
        if((0x4000 & mPrivateFlags) == 16384)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isRootNamespace() {
        boolean flag;
        if((8 & mPrivateFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isSaveEnabled() {
        boolean flag;
        if((0x10000 & mViewFlags) != 0x10000)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isSaveFromParentEnabled() {
        boolean flag;
        if((0x20000000 & mViewFlags) != 0x20000000)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isScrollContainer() {
        boolean flag;
        if((0x100000 & mPrivateFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isScrollbarFadingEnabled() {
        boolean flag;
        if(mScrollCache != null && mScrollCache.fadeScrollBars)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isSelected() {
        boolean flag;
        if((4 & mPrivateFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isShown() {
        boolean flag;
        View view;
        flag = false;
        view = this;
_L4:
        if((0xc & view.mViewFlags) == 0) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        ViewParent viewparent;
        viewparent = view.mParent;
        if(viewparent == null)
            continue; /* Loop/switch isn't completed */
        if(viewparent instanceof View)
            break; /* Loop/switch isn't completed */
        flag = true;
        if(true) goto _L1; else goto _L3
_L3:
        view = (View)viewparent;
        if(view != null) goto _L4; else goto _L1
    }

    public boolean isSoundEffectsEnabled() {
        boolean flag;
        if(0x8000000 == (0x8000000 & mViewFlags))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isVerticalFadingEdgeEnabled() {
        boolean flag;
        if((0x2000 & mViewFlags) == 8192)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isVerticalScrollBarEnabled() {
        boolean flag;
        if((0x200 & mViewFlags) == 512)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected boolean isVerticalScrollBarHidden() {
        return false;
    }

    protected boolean isVisibleToUser() {
        return isVisibleToUser(null);
    }

    protected boolean isVisibleToUser(Rect rect) {
        Rect rect1 = mAttachInfo.mTmpInvalRect;
        Point point = mAttachInfo.mPoint;
        boolean flag;
        if(mAttachInfo != null && mAttachInfo.mWindowVisibility == 0 && getAlpha() > 0.0F && isShown() && getGlobalVisibleRect(rect1, point))
            flag = true;
        else
            flag = false;
        if(flag && rect != null) {
            rect1.offset(-point.x, -point.y);
            flag &= rect.intersect(rect1);
        }
        return flag;
    }

    public void jumpDrawablesToCurrentState() {
        if(mBackground != null)
            mBackground.jumpToCurrentState();
    }

    public void layout(int i, int j, int k, int l) {
        int i1 = mLeft;
        int j1 = mTop;
        int k1 = mBottom;
        int l1 = mRight;
        boolean flag = setFrame(i, j, k, l);
        if(flag || (0x2000 & mPrivateFlags) == 8192) {
            onLayout(flag, i, j, k, l);
            mPrivateFlags = 0xffffdfff & mPrivateFlags;
            ListenerInfo listenerinfo = mListenerInfo;
            if(listenerinfo != null && listenerinfo.mOnLayoutChangeListeners != null) {
                ArrayList arraylist = (ArrayList)listenerinfo.mOnLayoutChangeListeners.clone();
                int i2 = arraylist.size();
                for(int j2 = 0; j2 < i2; j2++)
                    ((OnLayoutChangeListener)arraylist.get(j2)).onLayoutChange(this, i, j, k, l, i1, j1, l1, k1);

            }
        }
        mPrivateFlags = 0xffffefff & mPrivateFlags;
    }

    public void makeOptionalFitsSystemWindows() {
        setFlags(2048, 2048);
    }

    public final void measure(int i, int j) {
        if((0x1000 & mPrivateFlags) == 4096 || i != mOldWidthMeasureSpec || j != mOldHeightMeasureSpec) {
            mPrivateFlags = 0xfffff7ff & mPrivateFlags;
            onMeasure(i, j);
            if((0x800 & mPrivateFlags) != 2048)
                throw new IllegalStateException("onMeasure() did not set the measured dimension by calling setMeasuredDimension()");
            mPrivateFlags = 0x2000 | mPrivateFlags;
        }
        mOldWidthMeasureSpec = i;
        mOldHeightMeasureSpec = j;
    }

    void needGlobalAttributesUpdate(boolean flag) {
        AttachInfo attachinfo = mAttachInfo;
        if(attachinfo != null && (flag || attachinfo.mKeepScreenOn || attachinfo.mSystemUiVisibility != 0 || attachinfo.mHasSystemUiListeners))
            attachinfo.mRecomputeGlobalAttributes = true;
    }

    public void notifyAccessibilityStateChanged() {
_L2:
        return;
        if(!AccessibilityManager.getInstance(mContext).isEnabled() || (0x8000000 & mPrivateFlags2) != 0) goto _L2; else goto _L1
_L1:
        mPrivateFlags2 = 0x8000000 | mPrivateFlags2;
        if(mParent != null)
            mParent.childAccessibilityStateChanged(this);
        if(true) goto _L2; else goto _L3
_L3:
    }

    public void offsetLeftAndRight(int i) {
        if(i != 0) {
            updateMatrix();
            boolean flag;
            if(mTransformationInfo == null || mTransformationInfo.mMatrixIsIdentity)
                flag = true;
            else
                flag = false;
            if(flag) {
                if(mDisplayList != null) {
                    invalidateViewProperty(false, false);
                } else {
                    ViewParent viewparent = mParent;
                    if(viewparent != null && mAttachInfo != null) {
                        Rect rect = mAttachInfo.mTmpInvalRect;
                        int j;
                        int k;
                        if(i < 0) {
                            j = i + mLeft;
                            k = mRight;
                        } else {
                            j = mLeft;
                            k = i + mRight;
                        }
                        rect.set(0, 0, k - j, mBottom - mTop);
                        viewparent.invalidateChild(this, rect);
                    }
                }
            } else {
                invalidateViewProperty(false, false);
            }
            mLeft = i + mLeft;
            mRight = i + mRight;
            if(mDisplayList != null) {
                mDisplayList.offsetLeftRight(i);
                invalidateViewProperty(false, false);
            } else {
                if(!flag)
                    invalidateViewProperty(false, true);
                invalidateParentIfNeeded();
            }
        }
    }

    public void offsetTopAndBottom(int i) {
        if(i != 0) {
            updateMatrix();
            boolean flag;
            if(mTransformationInfo == null || mTransformationInfo.mMatrixIsIdentity)
                flag = true;
            else
                flag = false;
            if(flag) {
                if(mDisplayList != null) {
                    invalidateViewProperty(false, false);
                } else {
                    ViewParent viewparent = mParent;
                    if(viewparent != null && mAttachInfo != null) {
                        Rect rect = mAttachInfo.mTmpInvalRect;
                        int j;
                        int k;
                        int l;
                        if(i < 0) {
                            j = i + mTop;
                            k = mBottom;
                            l = i;
                        } else {
                            j = mTop;
                            k = i + mBottom;
                            l = 0;
                        }
                        rect.set(0, l, mRight - mLeft, k - j);
                        viewparent.invalidateChild(this, rect);
                    }
                }
            } else {
                invalidateViewProperty(false, false);
            }
            mTop = i + mTop;
            mBottom = i + mBottom;
            if(mDisplayList != null) {
                mDisplayList.offsetTopBottom(i);
                invalidateViewProperty(false, false);
            } else {
                if(!flag)
                    invalidateViewProperty(false, true);
                invalidateParentIfNeeded();
            }
        }
    }

    protected void onAnimationEnd() {
        mPrivateFlags = 0xfffeffff & mPrivateFlags;
    }

    protected void onAnimationStart() {
        mPrivateFlags = 0x10000 | mPrivateFlags;
    }

    protected void onAttachedToWindow() {
        if((0x200 & mPrivateFlags) != 0)
            mParent.requestTransparentRegion(this);
        if((0x8000000 & mPrivateFlags) != 0) {
            initialAwakenScrollBars();
            mPrivateFlags = 0xf7ffffff & mPrivateFlags;
        }
        jumpDrawablesToCurrentState();
        resolveLayoutDirection();
        resolvePadding();
        resolveTextDirection();
        resolveTextAlignment();
        clearAccessibilityFocus();
        if(isFocused())
            InputMethodManager.peekInstance().focusIn(this);
        if(mAttachInfo != null && mDisplayList != null)
            mAttachInfo.mViewRootImpl.dequeueDisplayList(mDisplayList);
    }

    public boolean onCheckIsTextEditor() {
        return false;
    }

    public void onCloseSystemDialogs(String s) {
    }

    protected void onConfigurationChanged(Configuration configuration) {
    }

    protected void onCreateContextMenu(ContextMenu contextmenu) {
    }

    protected int[] onCreateDrawableState(int i) {
        if((0x400000 & mViewFlags) != 0x400000 || !(mParent instanceof View)) goto _L2; else goto _L1
_L1:
        int ai[] = ((View)mParent).onCreateDrawableState(i);
_L4:
        return ai;
_L2:
        int j = mPrivateFlags;
        int k = 0;
        if((j & 0x4000) != 0)
            k = 0 | 0x10;
        if((0x20 & mViewFlags) == 0)
            k |= 8;
        if(isFocused())
            k |= 4;
        if((j & 4) != 0)
            k |= 2;
        if(hasWindowFocus())
            k |= 1;
        if((0x40000000 & j) != 0)
            k |= 0x20;
        if(mAttachInfo != null && mAttachInfo.mHardwareAccelerationRequested && HardwareRenderer.isAvailable())
            k |= 0x40;
        if((0x10000000 & j) != 0)
            k |= 0x80;
        int l = mPrivateFlags2;
        if((l & 1) != 0)
            k |= 0x100;
        if((l & 2) != 0)
            k |= 0x200;
        ai = VIEW_STATE_SETS[k];
        fillAdditionalState(ai);
        if(i != 0) {
            int ai1[];
            if(ai != null) {
                ai1 = new int[i + ai.length];
                System.arraycopy(ai, 0, ai1, 0, ai.length);
            } else {
                ai1 = new int[i];
            }
            ai = ai1;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public InputConnection onCreateInputConnection(EditorInfo editorinfo) {
        return null;
    }

    protected void onDetachedFromWindow() {
        mPrivateFlags = 0xfbffffff & mPrivateFlags;
        removeUnsetPressCallback();
        removeLongPressCallback();
        removePerformClickCallback();
        removeSendViewScrolledAccessibilityEventCallback();
        destroyDrawingCache();
        destroyLayer(false);
        if(mAttachInfo != null) {
            if(mDisplayList != null)
                mAttachInfo.mViewRootImpl.enqueueDisplayList(mDisplayList);
            mAttachInfo.mViewRootImpl.cancelInvalidate(this);
        } else {
            clearDisplayList();
        }
        mCurrentAnimation = null;
        resetResolvedLayoutDirection();
        resetResolvedTextAlignment();
        resetAccessibilityStateChanged();
    }

    protected void onDisplayHint(int i) {
    }

    public boolean onDragEvent(DragEvent dragevent) {
        return false;
    }

    protected void onDraw(Canvas canvas) {
    }

    protected void onDrawHorizontalScrollBar(Canvas canvas, Drawable drawable, int i, int j, int k, int l) {
        drawable.setBounds(i, j, k, l);
        drawable.draw(canvas);
    }

    protected final void onDrawScrollBars(Canvas canvas) {
        ScrollabilityCache scrollabilitycache = mScrollCache;
        if(scrollabilitycache == null) goto _L2; else goto _L1
_L1:
        int i = scrollabilitycache.state;
        if(i != 0) goto _L3; else goto _L2
_L2:
        return;
_L3:
        int i1;
        byte byte0;
        int l1;
        boolean flag = false;
        boolean flag1;
        boolean flag2;
        if(i == 2) {
            if(scrollabilitycache.interpolatorValues == null)
                scrollabilitycache.interpolatorValues = new float[1];
            float af[] = scrollabilitycache.interpolatorValues;
            int j;
            int k;
            int l;
            ScrollBarDrawable scrollbardrawable;
            int j1;
            int k1;
            int i2;
            int j2;
            int k2;
            int l2;
            int j3;
            int k3;
            int l3;
            int i4;
            if(scrollabilitycache.scrollBarInterpolator.timeToValues(af) == android.graphics.Interpolator.Result.FREEZE_END)
                scrollabilitycache.state = 0;
            else
                scrollabilitycache.scrollBar.setAlpha(Math.round(af[0]));
            flag = true;
        } else {
            scrollabilitycache.scrollBar.setAlpha(255);
        }
        j = mViewFlags;
        if((j & 0x100) == 256)
            flag1 = true;
        else
            flag1 = false;
        if((j & 0x200) == 512 && !isVerticalScrollBarHidden())
            flag2 = true;
        else
            flag2 = false;
        if(!flag2 && !flag1)
            continue; /* Loop/switch isn't completed */
        k = mRight - mLeft;
        l = mBottom - mTop;
        scrollbardrawable = scrollabilitycache.scrollBar;
        i1 = mScrollX;
        j1 = mScrollY;
        if((0x2000000 & j) == 0)
            byte0 = -1;
        else
            byte0 = 0;
        if(flag1) {
            l2 = scrollbardrawable.getSize(false);
            if(l2 <= 0)
                l2 = scrollabilitycache.scrollBarSize;
            scrollbardrawable.setParameters(computeHorizontalScrollRange(), computeHorizontalScrollOffset(), computeHorizontalScrollExtent(), false);
            int i3;
            if(flag2)
                i3 = getVerticalScrollbarWidth();
            else
                i3 = 0;
            j3 = (j1 + l) - l2 - (byte0 & mUserPaddingBottom);
            k3 = i1 + (byte0 & mPaddingLeft);
            l3 = (i1 + k) - (byte0 & mUserPaddingRight) - i3;
            i4 = j3 + l2;
            onDrawHorizontalScrollBar(canvas, scrollbardrawable, k3, j3, l3, i4);
            if(flag)
                invalidate(k3, j3, l3, i4);
        }
        if(!flag2)
            continue; /* Loop/switch isn't completed */
        k1 = scrollbardrawable.getSize(true);
        if(k1 <= 0)
            k1 = scrollabilitycache.scrollBarSize;
        scrollbardrawable.setParameters(computeVerticalScrollRange(), computeVerticalScrollOffset(), computeVerticalScrollExtent(), true);
        switch(mVerticalScrollbarPosition) {
        default:
            l1 = (i1 + k) - k1 - (byte0 & mUserPaddingRight);
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */
        }
_L5:
        i2 = j1 + (byte0 & mPaddingTop);
        j2 = l1 + k1;
        k2 = (j1 + l) - (byte0 & mUserPaddingBottom);
        onDrawVerticalScrollBar(canvas, scrollbardrawable, l1, i2, j2, k2);
        if(flag)
            invalidate(l1, i2, j2, k2);
        if(true) goto _L2; else goto _L4
_L4:
        l1 = i1 + (byte0 & mUserPaddingLeft);
          goto _L5
        if(true) goto _L2; else goto _L6
_L6:
    }

    protected void onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i, int j, int k, int l) {
        drawable.setBounds(i, j, k, l);
        drawable.draw(canvas);
    }

    public boolean onFilterTouchEventForSecurity(MotionEvent motionevent) {
        boolean flag;
        if((0x400 & mViewFlags) != 0 && (1 & motionevent.getFlags()) != 0)
            flag = false;
        else
            flag = true;
        return flag;
    }

    protected void onFinishInflate() {
    }

    public void onFinishTemporaryDetach() {
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect) {
        InputMethodManager inputmethodmanager;
        if(flag && AccessibilityManager.getInstance(mContext).isEnabled())
            sendAccessibilityEvent(8);
        inputmethodmanager = InputMethodManager.peekInstance();
        if(flag) goto _L2; else goto _L1
_L1:
        if(isPressed())
            setPressed(false);
        if(inputmethodmanager != null && mAttachInfo != null && mAttachInfo.mHasWindowFocus)
            inputmethodmanager.focusOut(this);
        onFocusLost();
_L4:
        invalidate(true);
        ListenerInfo listenerinfo = mListenerInfo;
        if(listenerinfo != null && listenerinfo.mOnFocusChangeListener != null)
            listenerinfo.mOnFocusChangeListener.onFocusChange(this, flag);
        if(mAttachInfo != null)
            mAttachInfo.mKeyDispatchState.reset(this);
        return;
_L2:
        if(inputmethodmanager != null && mAttachInfo != null && mAttachInfo.mHasWindowFocus)
            inputmethodmanager.focusIn(this);
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void onFocusLost() {
        resetPressedState();
    }

    public boolean onGenericMotionEvent(MotionEvent motionevent) {
        return false;
    }

    public void onHoverChanged(boolean flag) {
    }

    public boolean onHoverEvent(MotionEvent motionevent) {
        boolean flag;
        flag = true;
        int i = motionevent.getActionMasked();
        if(!mSendingHoverAccessibilityEvents) {
            if((i == 9 || i == 7) && !hasHoveredChild() && pointInView(motionevent.getX(), motionevent.getY())) {
                sendAccessibilityHoverEvent(128);
                mSendingHoverAccessibilityEvents = flag;
            }
        } else
        if(i == 10 || i == 2 && !pointInView(motionevent.getX(), motionevent.getY())) {
            mSendingHoverAccessibilityEvents = false;
            sendAccessibilityHoverEvent(256);
            if(mAttachInfo != null && !mAttachInfo.mHasWindowFocus)
                getViewRootImpl().setAccessibilityFocus(null, null);
        }
        if(!isHoverable())
            break MISSING_BLOCK_LABEL_183;
        i;
        JVM INSTR tableswitch 9 10: default 92
    //                   9 167
    //                   10 175;
           goto _L1 _L2 _L3
_L1:
        dispatchGenericMotionEventInternal(motionevent);
_L4:
        return flag;
_L2:
        setHovered(flag);
          goto _L1
_L3:
        setHovered(false);
          goto _L1
        flag = false;
          goto _L4
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        if(mAccessibilityDelegate != null)
            mAccessibilityDelegate.onInitializeAccessibilityEvent(this, accessibilityevent);
        else
            onInitializeAccessibilityEventInternal(accessibilityevent);
    }

    void onInitializeAccessibilityEventInternal(AccessibilityEvent accessibilityevent) {
        accessibilityevent.setSource(this);
        accessibilityevent.setClassName(android/view/View.getName());
        accessibilityevent.setPackageName(getContext().getPackageName());
        accessibilityevent.setEnabled(isEnabled());
        accessibilityevent.setContentDescription(mContentDescription);
        if(accessibilityevent.getEventType() == 8 && mAttachInfo != null) {
            ArrayList arraylist = mAttachInfo.mTempArrayList;
            getRootView().addFocusables(arraylist, 2, 0);
            accessibilityevent.setItemCount(arraylist.size());
            accessibilityevent.setCurrentItemIndex(arraylist.indexOf(this));
            arraylist.clear();
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        if(mAccessibilityDelegate != null)
            mAccessibilityDelegate.onInitializeAccessibilityNodeInfo(this, accessibilitynodeinfo);
        else
            onInitializeAccessibilityNodeInfoInternal(accessibilitynodeinfo);
    }

    void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo accessibilitynodeinfo) {
        Rect rect = mAttachInfo.mTmpInvalRect;
        getDrawingRect(rect);
        accessibilitynodeinfo.setBoundsInParent(rect);
        getBoundsOnScreen(rect);
        accessibilitynodeinfo.setBoundsInScreen(rect);
        ViewParent viewparent = getParentForAccessibility();
        if(viewparent instanceof View)
            accessibilitynodeinfo.setParent((View)viewparent);
        accessibilitynodeinfo.setVisibleToUser(isVisibleToUser());
        accessibilitynodeinfo.setPackageName(mContext.getPackageName());
        accessibilitynodeinfo.setClassName(android/view/View.getName());
        accessibilitynodeinfo.setContentDescription(getContentDescription());
        accessibilitynodeinfo.setEnabled(isEnabled());
        accessibilitynodeinfo.setClickable(isClickable());
        accessibilitynodeinfo.setFocusable(isFocusable());
        accessibilitynodeinfo.setFocused(isFocused());
        accessibilitynodeinfo.setAccessibilityFocused(isAccessibilityFocused());
        accessibilitynodeinfo.setSelected(isSelected());
        accessibilitynodeinfo.setLongClickable(isLongClickable());
        accessibilitynodeinfo.addAction(4);
        accessibilitynodeinfo.addAction(8);
        if(isFocusable())
            if(isFocused())
                accessibilitynodeinfo.addAction(2);
            else
                accessibilitynodeinfo.addAction(1);
        if(!isAccessibilityFocused()) {
            int i = getAccessibilityFocusable();
            if(i == 1 || i == 0)
                accessibilitynodeinfo.addAction(64);
        } else {
            accessibilitynodeinfo.addAction(128);
        }
        if(isClickable() && isEnabled())
            accessibilitynodeinfo.addAction(16);
        if(isLongClickable() && isEnabled())
            accessibilitynodeinfo.addAction(32);
        if(mContentDescription != null && mContentDescription.length() > 0) {
            accessibilitynodeinfo.addAction(256);
            accessibilitynodeinfo.addAction(512);
            accessibilitynodeinfo.setMovementGranularities(11);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        boolean flag = false;
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   23: 30
    //                   66: 30;
           goto _L1 _L2 _L2
_L1:
        return flag;
_L2:
        if((0x20 & mViewFlags) == 32)
            flag = true;
        else
        if(((0x4000 & mViewFlags) == 16384 || (0x200000 & mViewFlags) == 0x200000) && keyevent.getRepeatCount() == 0) {
            setPressed(true);
            checkForLongClick(0);
            flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean onKeyLongPress(int i, KeyEvent keyevent) {
        return false;
    }

    public boolean onKeyMultiple(int i, int j, KeyEvent keyevent) {
        return false;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent) {
        return false;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyevent) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyevent) {
        boolean flag = false;
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   23: 34
    //                   66: 34;
           goto _L1 _L2 _L2
_L1:
        boolean flag1 = flag;
_L4:
        return flag1;
_L2:
        if((0x20 & mViewFlags) != 32)
            break; /* Loop/switch isn't completed */
        flag1 = true;
        if(true) goto _L4; else goto _L3
_L3:
        if((0x4000 & mViewFlags) == 16384 && isPressed()) {
            setPressed(false);
            if(!mHasPerformedLongPress) {
                removeLongPressCallback();
                flag = performClick();
            }
        }
        if(true) goto _L1; else goto _L5
_L5:
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
    }

    protected void onMeasure(int i, int j) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), j));
    }

    protected void onOverScrolled(int i, int j, boolean flag, boolean flag1) {
    }

    public void onPaddingChanged(int i) {
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        if(mAccessibilityDelegate != null)
            mAccessibilityDelegate.onPopulateAccessibilityEvent(this, accessibilityevent);
        else
            onPopulateAccessibilityEventInternal(accessibilityevent);
    }

    void onPopulateAccessibilityEventInternal(AccessibilityEvent accessibilityevent) {
    }

    public void onResolvedLayoutDirectionChanged() {
    }

    public void onResolvedLayoutDirectionReset() {
    }

    public void onResolvedTextAlignmentChanged() {
    }

    public void onResolvedTextAlignmentReset() {
    }

    public void onResolvedTextDirectionChanged() {
    }

    public void onResolvedTextDirectionReset() {
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        mPrivateFlags = 0x20000 | mPrivateFlags;
        if(parcelable != BaseSavedState.EMPTY_STATE && parcelable != null)
            throw new IllegalArgumentException((new StringBuilder()).append("Wrong state class, expecting View State but received ").append(parcelable.getClass().toString()).append(" instead. This usually happens ").append("when two views of different type have the same id in the same hierarchy. ").append("This view's id is ").append(ViewDebug.resolveId(mContext, getId())).append(". Make sure ").append("other views do not use the same id.").toString());
        else
            return;
    }

    protected Parcelable onSaveInstanceState() {
        mPrivateFlags = 0x20000 | mPrivateFlags;
        return BaseSavedState.EMPTY_STATE;
    }

    public void onScreenStateChanged(int i) {
    }

    protected void onScrollChanged(int i, int j, int k, int l) {
        if(AccessibilityManager.getInstance(mContext).isEnabled())
            postSendViewScrolledAccessibilityEventCallback();
        mBackgroundSizeChanged = true;
        AttachInfo attachinfo = mAttachInfo;
        if(attachinfo != null)
            attachinfo.mViewScrollChanged = true;
    }

    protected boolean onSetAlpha(int i) {
        return false;
    }

    protected void onSizeChanged(int i, int j, int k, int l) {
    }

    public void onStartTemporaryDetach() {
        removeUnsetPressCallback();
        mPrivateFlags = 0x4000000 | mPrivateFlags;
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag;
        int i;
        flag = false;
        i = mViewFlags;
        if((i & 0x20) != 32) goto _L2; else goto _L1
_L1:
        if(motionevent.getAction() == 1 && (0x4000 & mPrivateFlags) != 0)
            setPressed(false);
        if((i & 0x4000) == 16384 || (i & 0x200000) == 0x200000)
            flag = true;
_L9:
        return flag;
_L2:
        if(mTouchDelegate != null && mTouchDelegate.onTouchEvent(motionevent)) {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        if((i & 0x4000) != 16384 && (i & 0x200000) != 0x200000)
            continue; /* Loop/switch isn't completed */
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 140
    //                   0 343
    //                   1 145
    //                   2 440
    //                   3 428;
           goto _L3 _L4 _L5 _L6 _L7
_L6:
        break MISSING_BLOCK_LABEL_440;
_L3:
        break; /* Loop/switch isn't completed */
_L5:
        break; /* Loop/switch isn't completed */
_L10:
        flag = true;
        if(true) goto _L9; else goto _L8
_L8:
        boolean flag1;
        if((0x2000000 & mPrivateFlags) != 0)
            flag1 = true;
        else
            flag1 = false;
        if((0x4000 & mPrivateFlags) != 0 || flag1) {
            boolean flag2 = false;
            if(isFocusable() && isFocusableInTouchMode() && !isFocused())
                flag2 = requestFocus();
            if(flag1)
                setPressed(true);
            if(!mHasPerformedLongPress) {
                removeLongPressCallback();
                if(!flag2) {
                    if(mPerformClick == null)
                        mPerformClick = new PerformClick();
                    Injector.performHapticFeedbackOnRelease(this);
                    if(!post(mPerformClick))
                        performClick();
                }
            }
            if(mUnsetPressedState == null)
                mUnsetPressedState = new UnsetPressedState();
            if(flag1)
                postDelayed(mUnsetPressedState, ViewConfiguration.getPressedStateDuration());
            else
            if(!post(mUnsetPressedState))
                mUnsetPressedState.run();
            removeTapCallback();
        }
          goto _L10
_L4:
        mHasPerformedLongPress = false;
        if(!performButtonActionOnTouchDown(motionevent))
            if(isInScrollingContainer()) {
                mPrivateFlags = 0x2000000 | mPrivateFlags;
                if(mPendingCheckForTap == null)
                    mPendingCheckForTap = new CheckForTap();
                postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
            } else {
                setPressed(true);
                checkForLongClick(0);
                Injector.performHapticFeedbackOnDown(this);
            }
          goto _L10
_L7:
        setPressed(false);
        removeTapCallback();
          goto _L10
        int j = (int)motionevent.getX();
        int k = (int)motionevent.getY();
        if(!pointInView(j, k, mTouchSlop)) {
            removeTapCallback();
            if((0x4000 & mPrivateFlags) != 0) {
                removeLongPressCallback();
                setPressed(false);
            }
        }
          goto _L10
    }

    public boolean onTrackballEvent(MotionEvent motionevent) {
        return false;
    }

    protected void onVisibilityChanged(View view, int i) {
        if(i == 0)
            if(mAttachInfo != null)
                initialAwakenScrollBars();
            else
                mPrivateFlags = 0x8000000 | mPrivateFlags;
    }

    public void onWindowFocusChanged(boolean flag) {
        InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
        if(flag) goto _L2; else goto _L1
_L1:
        if(isPressed())
            setPressed(false);
        if(inputmethodmanager != null && (2 & mPrivateFlags) != 0)
            inputmethodmanager.focusOut(this);
        removeLongPressCallback();
        removeTapCallback();
        onFocusLost();
_L4:
        refreshDrawableState();
        return;
_L2:
        if(inputmethodmanager != null && (2 & mPrivateFlags) != 0)
            inputmethodmanager.focusIn(this);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
    }

    protected void onWindowVisibilityChanged(int i) {
        if(i == 0)
            initialAwakenScrollBars();
    }

    public void outputDirtyFlags(String s, boolean flag, int i) {
        Log.d("View", (new StringBuilder()).append(s).append(this).append("             DIRTY(").append(0x600000 & mPrivateFlags).append(") DRAWN(").append(0x20 & mPrivateFlags).append(")").append(" CACHE_VALID(").append(0x8000 & mPrivateFlags).append(") INVALIDATED(").append(0x80000000 & mPrivateFlags).append(")").toString());
        if(flag)
            mPrivateFlags = i & mPrivateFlags;
        if(this instanceof ViewGroup) {
            ViewGroup viewgroup = (ViewGroup)this;
            int j = viewgroup.getChildCount();
            for(int k = 0; k < j; k++)
                viewgroup.getChildAt(k).outputDirtyFlags((new StringBuilder()).append(s).append("  ").toString(), flag, i);

        }
    }

    protected boolean overScrollBy(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, boolean flag) {
        int i2 = mOverScrollMode;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        if(computeHorizontalScrollRange() > computeHorizontalScrollExtent())
            flag1 = true;
        else
            flag1 = false;
        if(computeVerticalScrollRange() > computeVerticalScrollExtent())
            flag2 = true;
        else
            flag2 = false;
        if(i2 == 0 || i2 == 1 && flag1)
            flag3 = true;
        else
            flag3 = false;
        if(i2 == 0 || i2 == 1 && flag2)
            flag4 = true;
        else
            flag4 = false;
        j2 = k + i;
        if(!flag3)
            k1 = 0;
        k2 = l + j;
        if(!flag4)
            l1 = 0;
        l2 = -k1;
        i3 = k1 + i1;
        j3 = -l1;
        k3 = l1 + j1;
        flag5 = false;
        if(j2 > i3) {
            j2 = i3;
            flag5 = true;
        } else
        if(j2 < l2) {
            j2 = l2;
            flag5 = true;
        }
        flag6 = false;
        if(k2 > k3) {
            k2 = k3;
            flag6 = true;
        } else
        if(k2 < j3) {
            k2 = j3;
            flag6 = true;
        }
        onOverScrolled(j2, k2, flag5, flag6);
        if(flag5 || flag6)
            flag7 = true;
        else
            flag7 = false;
        return flag7;
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        boolean flag;
        if(mAccessibilityDelegate != null)
            flag = mAccessibilityDelegate.performAccessibilityAction(this, i, bundle);
        else
            flag = performAccessibilityActionInternal(i, bundle);
        return flag;
    }

    boolean performAccessibilityActionInternal(int i, Bundle bundle) {
        boolean flag = true;
        i;
        JVM INSTR lookupswitch 10: default 92
    //                   1: 126
    //                   2: 150
    //                   4: 173
    //                   8: 193
    //                   16: 96
    //                   32: 111
    //                   64: 217
    //                   128: 249
    //                   256: 263
    //                   512: 282;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        flag = false;
_L13:
        return flag;
_L6:
        if(!isClickable()) goto _L1; else goto _L12
_L12:
        flag = performClick();
          goto _L13
_L7:
        if(!isLongClickable()) goto _L1; else goto _L14
_L14:
        flag = performLongClick();
          goto _L13
_L2:
        if(hasFocus()) goto _L1; else goto _L15
_L15:
        getViewRootImpl().ensureTouchMode(false);
        flag = requestFocus();
          goto _L13
_L3:
        if(!hasFocus()) goto _L1; else goto _L16
_L16:
        clearFocus();
        if(isFocused())
            flag = false;
          goto _L13
_L4:
        if(isSelected()) goto _L1; else goto _L17
_L17:
        setSelected(flag);
        flag = isSelected();
          goto _L13
_L5:
        if(!isSelected()) goto _L1; else goto _L18
_L18:
        setSelected(false);
        if(isSelected())
            flag = false;
          goto _L13
_L8:
        int j = getAccessibilityFocusable();
        if(isAccessibilityFocused() || j != flag && j != 0) goto _L1; else goto _L19
_L19:
        flag = requestAccessibilityFocus();
          goto _L13
_L9:
        if(!isAccessibilityFocused()) goto _L1; else goto _L20
_L20:
        clearAccessibilityFocus();
          goto _L13
_L10:
        if(bundle == null) goto _L1; else goto _L21
_L21:
        flag = nextAtGranularity(bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT"));
          goto _L13
_L11:
        if(bundle == null) goto _L1; else goto _L22
_L22:
        flag = previousAtGranularity(bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT"));
          goto _L13
    }

    protected boolean performButtonActionOnTouchDown(MotionEvent motionevent) {
        boolean flag;
        if((2 & motionevent.getButtonState()) != 0 && showContextMenu(motionevent.getX(), motionevent.getY(), motionevent.getMetaState()))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean performClick() {
        boolean flag = true;
        sendAccessibilityEvent(flag);
        ListenerInfo listenerinfo = mListenerInfo;
        if(listenerinfo != null && listenerinfo.mOnClickListener != null) {
            playSoundEffect(0);
            listenerinfo.mOnClickListener.onClick(this);
        } else {
            flag = false;
        }
        return flag;
    }

    void performCollectViewAttributes(AttachInfo attachinfo, int i) {
        if((i & 0xc) == 0) {
            if((0x4000000 & mViewFlags) == 0x4000000)
                attachinfo.mKeepScreenOn = true;
            attachinfo.mSystemUiVisibility = attachinfo.mSystemUiVisibility | mSystemUiVisibility;
            ListenerInfo listenerinfo = mListenerInfo;
            if(listenerinfo != null && listenerinfo.mOnSystemUiVisibilityChangeListener != null)
                attachinfo.mHasSystemUiListeners = true;
        }
    }

    public boolean performHapticFeedback(int i) {
        return performHapticFeedback(i, 0);
    }

    public boolean performHapticFeedback(int i, int j) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(mAttachInfo != null && Injector.isHapticEnabledExplictly(this, j) && ((j & 1) != 0 || isHapticFeedbackEnabled())) {
            AttachInfo.Callbacks callbacks = mAttachInfo.mRootCallbacks;
            if((j & 2) != 0)
                flag = true;
            flag = callbacks.performHapticFeedback(i, flag);
        }
        return flag;
    }

    public boolean performLongClick() {
        sendAccessibilityEvent(2);
        boolean flag = false;
        ListenerInfo listenerinfo = mListenerInfo;
        if(listenerinfo != null && listenerinfo.mOnLongClickListener != null)
            flag = listenerinfo.mOnLongClickListener.onLongClick(this);
        if(!flag)
            flag = showContextMenu();
        if(flag)
            performHapticFeedback(0);
        return flag;
    }

    public void playSoundEffect(int i) {
        if(mAttachInfo != null && mAttachInfo.mRootCallbacks != null && isSoundEffectsEnabled())
            mAttachInfo.mRootCallbacks.playSoundEffect(i);
    }

    final boolean pointInView(float f, float f1) {
        boolean flag;
        if(f >= 0.0F && f < (float)(mRight - mLeft) && f1 >= 0.0F && f1 < (float)(mBottom - mTop))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean post(Runnable runnable) {
        AttachInfo attachinfo = mAttachInfo;
        boolean flag;
        if(attachinfo != null) {
            flag = attachinfo.mHandler.post(runnable);
        } else {
            ViewRootImpl.getRunQueue().post(runnable);
            flag = true;
        }
        return flag;
    }

    public boolean postDelayed(Runnable runnable, long l) {
        AttachInfo attachinfo = mAttachInfo;
        boolean flag;
        if(attachinfo != null) {
            flag = attachinfo.mHandler.postDelayed(runnable, l);
        } else {
            ViewRootImpl.getRunQueue().postDelayed(runnable, l);
            flag = true;
        }
        return flag;
    }

    public void postInvalidate() {
        postInvalidateDelayed(0L);
    }

    public void postInvalidate(int i, int j, int k, int l) {
        postInvalidateDelayed(0L, i, j, k, l);
    }

    public void postInvalidateDelayed(long l) {
        AttachInfo attachinfo = mAttachInfo;
        if(attachinfo != null)
            attachinfo.mViewRootImpl.dispatchInvalidateDelayed(this, l);
    }

    public void postInvalidateDelayed(long l, int i, int j, int k, int i1) {
        AttachInfo attachinfo = mAttachInfo;
        if(attachinfo != null) {
            AttachInfo.InvalidateInfo invalidateinfo = AttachInfo.InvalidateInfo.acquire();
            invalidateinfo.target = this;
            invalidateinfo.left = i;
            invalidateinfo.top = j;
            invalidateinfo.right = k;
            invalidateinfo.bottom = i1;
            attachinfo.mViewRootImpl.dispatchInvalidateRectDelayed(invalidateinfo, l);
        }
    }

    public void postInvalidateOnAnimation() {
        AttachInfo attachinfo = mAttachInfo;
        if(attachinfo != null)
            attachinfo.mViewRootImpl.dispatchInvalidateOnAnimation(this);
    }

    public void postInvalidateOnAnimation(int i, int j, int k, int l) {
        AttachInfo attachinfo = mAttachInfo;
        if(attachinfo != null) {
            AttachInfo.InvalidateInfo invalidateinfo = AttachInfo.InvalidateInfo.acquire();
            invalidateinfo.target = this;
            invalidateinfo.left = i;
            invalidateinfo.top = j;
            invalidateinfo.right = k;
            invalidateinfo.bottom = l;
            attachinfo.mViewRootImpl.dispatchInvalidateRectOnAnimation(invalidateinfo);
        }
    }

    public void postOnAnimation(Runnable runnable) {
        AttachInfo attachinfo = mAttachInfo;
        if(attachinfo != null)
            attachinfo.mViewRootImpl.mChoreographer.postCallback(1, runnable, null);
        else
            ViewRootImpl.getRunQueue().post(runnable);
    }

    public void postOnAnimationDelayed(Runnable runnable, long l) {
        AttachInfo attachinfo = mAttachInfo;
        if(attachinfo != null)
            attachinfo.mViewRootImpl.mChoreographer.postCallbackDelayed(1, runnable, null, l);
        else
            ViewRootImpl.getRunQueue().postDelayed(runnable, l);
    }

    protected void recomputePadding() {
        setPadding(mUserPaddingLeft, mPaddingTop, mUserPaddingRight, mUserPaddingBottom);
    }

    public void refreshDrawableState() {
        mPrivateFlags = 0x400 | mPrivateFlags;
        drawableStateChanged();
        ViewParent viewparent = mParent;
        if(viewparent != null)
            viewparent.childDrawableStateChanged(this);
    }

    public boolean removeCallbacks(Runnable runnable) {
        if(runnable != null) {
            AttachInfo attachinfo = mAttachInfo;
            if(attachinfo != null) {
                attachinfo.mHandler.removeCallbacks(runnable);
                attachinfo.mViewRootImpl.mChoreographer.removeCallbacks(1, runnable, null);
            } else {
                ViewRootImpl.getRunQueue().removeCallbacks(runnable);
            }
        }
        return true;
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onattachstatechangelistener) {
        ListenerInfo listenerinfo = mListenerInfo;
        if(listenerinfo != null && listenerinfo.mOnAttachStateChangeListeners != null)
            listenerinfo.mOnAttachStateChangeListeners.remove(onattachstatechangelistener);
    }

    public void removeOnLayoutChangeListener(OnLayoutChangeListener onlayoutchangelistener) {
        ListenerInfo listenerinfo = mListenerInfo;
        if(listenerinfo != null && listenerinfo.mOnLayoutChangeListeners != null)
            listenerinfo.mOnLayoutChangeListeners.remove(onlayoutchangelistener);
    }

    public boolean requestAccessibilityFocus() {
        boolean flag;
        AccessibilityManager accessibilitymanager;
        flag = false;
        accessibilitymanager = AccessibilityManager.getInstance(mContext);
        break MISSING_BLOCK_LABEL_10;
        if(accessibilitymanager.isEnabled() && accessibilitymanager.isTouchExplorationEnabled() && (0xc & mViewFlags) == 0 && (0x4000000 & mPrivateFlags2) == 0) {
            mPrivateFlags2 = 0x4000000 | mPrivateFlags2;
            ViewRootImpl viewrootimpl = getViewRootImpl();
            if(viewrootimpl != null)
                viewrootimpl.setAccessibilityFocus(this, null);
            invalidate();
            sendAccessibilityEvent(32768);
            notifyAccessibilityStateChanged();
            flag = true;
        }
        return flag;
    }

    public void requestFitSystemWindows() {
        if(mParent != null)
            mParent.requestFitSystemWindows();
    }

    public final boolean requestFocus() {
        return requestFocus(130);
    }

    public final boolean requestFocus(int i) {
        return requestFocus(i, null);
    }

    public boolean requestFocus(int i, Rect rect) {
        return requestFocusNoSearch(i, rect);
    }

    public final boolean requestFocusFromTouch() {
        if(isInTouchMode()) {
            ViewRootImpl viewrootimpl = getViewRootImpl();
            if(viewrootimpl != null)
                viewrootimpl.ensureTouchMode(false);
        }
        return requestFocus(130);
    }

    public void requestLayout() {
        mPrivateFlags = 0x1000 | mPrivateFlags;
        mPrivateFlags = 0x80000000 | mPrivateFlags;
        if(mLayoutParams != null)
            mLayoutParams.onResolveLayoutDirection(getResolvedLayoutDirection());
        if(mParent != null && !mParent.isLayoutRequested())
            mParent.requestLayout();
    }

    public boolean requestRectangleOnScreen(Rect rect) {
        return requestRectangleOnScreen(rect, false);
    }

    public boolean requestRectangleOnScreen(Rect rect, boolean flag) {
        View view = this;
        ViewParent viewparent = mParent;
        boolean flag1 = false;
        do {
label0:
            {
                if(viewparent != null) {
                    flag1 |= viewparent.requestChildRectangleOnScreen(view, rect, flag);
                    rect.offset(view.getLeft(), view.getTop());
                    rect.offset(-view.getScrollX(), -view.getScrollY());
                    if(viewparent instanceof View)
                        break label0;
                }
                return flag1;
            }
            view = (View)viewparent;
            viewparent = view.getParent();
        } while(true);
    }

    public void resetAccessibilityStateChanged() {
        mPrivateFlags2 = 0xf7ffffff & mPrivateFlags2;
    }

    public void resetResolvedLayoutDirection() {
        mPrivateFlags2 = 0xffffffcf & mPrivateFlags2;
        onResolvedLayoutDirectionReset();
        resetResolvedTextDirection();
    }

    public void resetResolvedTextAlignment() {
        mPrivateFlags2 = 0xfff0ffff & mPrivateFlags2;
        onResolvedTextAlignmentReset();
    }

    public void resetResolvedTextDirection() {
        mPrivateFlags2 = 0xffffe1ff & mPrivateFlags2;
        onResolvedTextDirectionReset();
    }

    public void resolveLayoutDirection() {
        mPrivateFlags2 = 0xffffffcf & mPrivateFlags2;
        if(!hasRtlSupport()) goto _L2; else goto _L1
_L1:
        getLayoutDirection();
        JVM INSTR tableswitch 1 3: default 48
    //                   1 103
    //                   2 68
    //                   3 117;
           goto _L2 _L3 _L4 _L5
_L2:
        mPrivateFlags2 = 0x20 | mPrivateFlags2;
        onResolvedLayoutDirectionChanged();
        resolvePadding();
        return;
_L4:
        if(canResolveLayoutDirection() && ((ViewGroup)mParent).getResolvedLayoutDirection() == 1)
            mPrivateFlags2 = 0x10 | mPrivateFlags2;
        continue; /* Loop/switch isn't completed */
_L3:
        mPrivateFlags2 = 0x10 | mPrivateFlags2;
        continue; /* Loop/switch isn't completed */
_L5:
        if(isLayoutDirectionRtl(Locale.getDefault()))
            mPrivateFlags2 = 0x10 | mPrivateFlags2;
        if(true) goto _L2; else goto _L6
_L6:
    }

    public void resolvePadding() {
        int j;
        int i = getResolvedLayoutDirection();
        switch(i) {
        default:
            if(mUserPaddingStart >= 0)
                mUserPaddingLeft = mUserPaddingStart;
            else
            if(mUserPaddingLeft < 0)
                mUserPaddingLeft = mPaddingLeft;
            if(mUserPaddingEnd >= 0)
                mUserPaddingRight = mUserPaddingEnd;
            else
            if(mUserPaddingRight < 0)
                mUserPaddingRight = mPaddingRight;
            break;

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_104;
        }
        if(mUserPaddingBottom >= 0)
            j = mUserPaddingBottom;
        else
            j = mPaddingBottom;
        mUserPaddingBottom = j;
        if(isPaddingRelative())
            setPaddingRelative(mUserPaddingStart, mPaddingTop, mUserPaddingEnd, mUserPaddingBottom);
        else
            recomputePadding();
        onPaddingChanged(i);
        return;
        if(mUserPaddingStart >= 0)
            mUserPaddingRight = mUserPaddingStart;
        else
        if(mUserPaddingRight < 0)
            mUserPaddingRight = mPaddingRight;
        if(mUserPaddingEnd >= 0)
            mUserPaddingLeft = mUserPaddingEnd;
        else
        if(mUserPaddingLeft < 0)
            mUserPaddingLeft = mPaddingLeft;
        break MISSING_BLOCK_LABEL_54;
    }

    public void resolveTextAlignment() {
        mPrivateFlags2 = 0xfff0ffff & mPrivateFlags2;
        if(!hasRtlSupport()) goto _L2; else goto _L1
_L1:
        int i = getTextAlignment();
        i;
        JVM INSTR tableswitch 0 6: default 68
    //                   0 96
    //                   1 210
    //                   2 210
    //                   3 210
    //                   4 210
    //                   5 210
    //                   6 210;
           goto _L3 _L4 _L5 _L5 _L5 _L5 _L5 _L5
_L3:
        mPrivateFlags2 = 0x20000 | mPrivateFlags2;
_L7:
        mPrivateFlags2 = 0x10000 | mPrivateFlags2;
        onResolvedTextAlignmentChanged();
        return;
_L4:
        if(canResolveLayoutDirection() && (mParent instanceof View)) {
            int j = ((View)mParent).getResolvedTextAlignment();
            switch(j) {
            default:
                mPrivateFlags2 = 0x20000 | mPrivateFlags2;
                break;

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
                mPrivateFlags2 = mPrivateFlags2 | j << 17;
                break;
            }
        } else {
            mPrivateFlags2 = 0x20000 | mPrivateFlags2;
        }
        if(false)
            ;
        continue; /* Loop/switch isn't completed */
_L5:
        mPrivateFlags2 = mPrivateFlags2 | i << 17;
        continue; /* Loop/switch isn't completed */
_L2:
        mPrivateFlags2 = 0x20000 | mPrivateFlags2;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public void resolveTextDirection() {
        mPrivateFlags2 = 0xffffe1ff & mPrivateFlags2;
        if(!hasRtlSupport()) goto _L2; else goto _L1
_L1:
        int i = getTextDirection();
        i;
        JVM INSTR tableswitch 0 5: default 64
    //                   0 93
    //                   1 194
    //                   2 194
    //                   3 194
    //                   4 194
    //                   5 194;
           goto _L3 _L4 _L5 _L5 _L5 _L5 _L5
_L3:
        mPrivateFlags2 = 0x400 | mPrivateFlags2;
_L7:
        mPrivateFlags2 = 0x200 | mPrivateFlags2;
        onResolvedTextDirectionChanged();
        return;
_L4:
        if(canResolveTextDirection()) {
            int j = ((ViewGroup)mParent).getResolvedTextDirection();
            switch(j) {
            default:
                mPrivateFlags2 = 0x400 | mPrivateFlags2;
                break;

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
                mPrivateFlags2 = mPrivateFlags2 | j << 10;
                break;
            }
        } else {
            mPrivateFlags2 = 0x400 | mPrivateFlags2;
        }
        if(false)
            ;
        continue; /* Loop/switch isn't completed */
_L5:
        mPrivateFlags2 = mPrivateFlags2 | i << 10;
        continue; /* Loop/switch isn't completed */
_L2:
        mPrivateFlags2 = 0x400 | mPrivateFlags2;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public void restoreHierarchyState(SparseArray sparsearray) {
        dispatchRestoreInstanceState(sparsearray);
    }

    public void saveHierarchyState(SparseArray sparsearray) {
        dispatchSaveInstanceState(sparsearray);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
        if(verifyDrawable(drawable) && runnable != null) {
            long l1 = l - SystemClock.uptimeMillis();
            if(mAttachInfo != null)
                mAttachInfo.mViewRootImpl.mChoreographer.postCallbackDelayed(1, runnable, drawable, Choreographer.subtractFrameDelay(l1));
            else
                ViewRootImpl.getRunQueue().postDelayed(runnable, l1);
        }
    }

    public void scrollBy(int i, int j) {
        scrollTo(i + mScrollX, j + mScrollY);
    }

    public void scrollTo(int i, int j) {
        if(mScrollX != i || mScrollY != j) {
            int k = mScrollX;
            int l = mScrollY;
            mScrollX = i;
            mScrollY = j;
            invalidateParentCaches();
            onScrollChanged(mScrollX, mScrollY, k, l);
            if(!awakenScrollBars())
                postInvalidateOnAnimation();
        }
    }

    public void sendAccessibilityEvent(int i) {
        if(mAccessibilityDelegate != null)
            mAccessibilityDelegate.sendAccessibilityEvent(this, i);
        else
            sendAccessibilityEventInternal(i);
    }

    void sendAccessibilityEventInternal(int i) {
        if(AccessibilityManager.getInstance(mContext).isEnabled())
            sendAccessibilityEventUnchecked(AccessibilityEvent.obtain(i));
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityevent) {
        if(mAccessibilityDelegate != null)
            mAccessibilityDelegate.sendAccessibilityEventUnchecked(this, accessibilityevent);
        else
            sendAccessibilityEventUncheckedInternal(accessibilityevent);
    }

    void sendAccessibilityEventUncheckedInternal(AccessibilityEvent accessibilityevent) {
        if(isShown()) {
            onInitializeAccessibilityEvent(accessibilityevent);
            if((0x2a1bf & accessibilityevent.getEventType()) != 0)
                dispatchPopulateAccessibilityEvent(accessibilityevent);
            getParent().requestSendAccessibilityEvent(this, accessibilityevent);
        }
    }

    public void setAccessibilityCursorPosition(int i) {
        mAccessibilityCursorPosition = i;
    }

    public void setAccessibilityDelegate(AccessibilityDelegate accessibilitydelegate) {
        mAccessibilityDelegate = accessibilitydelegate;
    }

    public void setAccessibilityFocusable(int i) {
        if(i != getAccessibilityFocusable()) {
            mPrivateFlags2 = 0x9fffffff & mPrivateFlags2;
            mPrivateFlags2 = mPrivateFlags2 | 0x60000000 & i << 29;
            notifyAccessibilityStateChanged();
        }
    }

    public void setActivated(boolean flag) {
        int i = 0x40000000;
        boolean flag1;
        if((i & mPrivateFlags) != 0)
            flag1 = true;
        else
            flag1 = false;
        if(flag1 != flag) {
            int j = 0xbfffffff & mPrivateFlags;
            if(!flag)
                i = 0;
            mPrivateFlags = i | j;
            invalidate(true);
            refreshDrawableState();
            dispatchSetActivated(flag);
        }
    }

    public void setAdditionalState(int i) {
        if(i != mAdditionalState) {
            mAdditionalState = i;
            invalidate(true);
            refreshDrawableState();
        }
    }

    public void setAlpha(float f) {
        ensureTransformationInfo();
        if(mTransformationInfo.mAlpha == f) goto _L2; else goto _L1
_L1:
        mTransformationInfo.mAlpha = f;
        if(!onSetAlpha((int)(255F * f))) goto _L4; else goto _L3
_L3:
        mPrivateFlags = 0x40000 | mPrivateFlags;
        invalidateParentCaches();
        invalidate(true);
_L2:
        return;
_L4:
        mPrivateFlags = 0xfffbffff & mPrivateFlags;
        invalidateViewProperty(true, false);
        if(mDisplayList != null)
            mDisplayList.setAlpha(f);
        if(true) goto _L2; else goto _L5
_L5:
    }

    boolean setAlphaNoInvalidation(float f) {
        ensureTransformationInfo();
        if(mTransformationInfo.mAlpha == f) goto _L2; else goto _L1
_L1:
        mTransformationInfo.mAlpha = f;
        if(!onSetAlpha((int)(255F * f))) goto _L4; else goto _L3
_L3:
        boolean flag;
        mPrivateFlags = 0x40000 | mPrivateFlags;
        flag = true;
_L6:
        return flag;
_L4:
        mPrivateFlags = 0xfffbffff & mPrivateFlags;
        if(mDisplayList != null)
            mDisplayList.setAlpha(f);
_L2:
        flag = false;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void setAnimation(Animation animation) {
        mCurrentAnimation = animation;
        if(animation != null) {
            if(mAttachInfo != null && !mAttachInfo.mScreenOn && animation.getStartTime() == -1L)
                animation.setStartTime(AnimationUtils.currentAnimationTimeMillis());
            animation.reset();
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i) {
        if(mBackground instanceof ColorDrawable)
            ((ColorDrawable)mBackground).setColor(i);
        else
            setBackground(new ColorDrawable(i));
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if(drawable != mBackground) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag;
        Rect rect;
        flag = false;
        mBackgroundResource = 0;
        if(mBackground != null) {
            mBackground.setCallback(null);
            unscheduleDrawable(mBackground);
        }
        if(drawable == null)
            break MISSING_BLOCK_LABEL_296;
        rect = (Rect)sThreadLocal.get();
        if(rect == null) {
            rect = new Rect();
            sThreadLocal.set(rect);
        }
        if(!drawable.getPadding(rect)) goto _L4; else goto _L3
_L3:
        drawable.getResolvedLayoutDirectionSelf();
        JVM INSTR tableswitch 1 1: default 104
    //                   1 267;
           goto _L5 _L6
_L5:
        setPadding(rect.left, rect.top, rect.right, rect.bottom);
_L4:
        if(mBackground == null || mBackground.getMinimumHeight() != drawable.getMinimumHeight() || mBackground.getMinimumWidth() != drawable.getMinimumWidth())
            flag = true;
        drawable.setCallback(this);
        if(drawable.isStateful())
            drawable.setState(getDrawableState());
        boolean flag1;
        if(getVisibility() == 0)
            flag1 = true;
        else
            flag1 = false;
        drawable.setVisible(flag1, false);
        mBackground = drawable;
        if((0x80 & mPrivateFlags) != 0) {
            mPrivateFlags = 0xffffff7f & mPrivateFlags;
            mPrivateFlags = 0x100 | mPrivateFlags;
            flag = true;
        }
_L7:
        computeOpaqueFlags();
        if(flag)
            requestLayout();
        mBackgroundSizeChanged = true;
        invalidate(true);
          goto _L1
_L6:
        setPadding(rect.right, rect.top, rect.left, rect.bottom);
          goto _L4
        mBackground = null;
        if((0x100 & mPrivateFlags) != 0) {
            mPrivateFlags = 0xfffffeff & mPrivateFlags;
            mPrivateFlags = 0x80 | mPrivateFlags;
        }
        flag = true;
          goto _L7
    }

    public void setBackgroundResource(int i) {
        if(i == 0 || i != mBackgroundResource) {
            Drawable drawable = null;
            if(i != 0)
                drawable = mResources.getDrawable(i);
            setBackground(drawable);
            mBackgroundResource = i;
        }
    }

    public final void setBottom(int i) {
        if(i != mBottom) {
            updateMatrix();
            boolean flag;
            if(mTransformationInfo == null || mTransformationInfo.mMatrixIsIdentity)
                flag = true;
            else
                flag = false;
            if(flag) {
                if(mAttachInfo != null) {
                    int j;
                    int k;
                    int l;
                    if(i < mBottom)
                        l = mBottom;
                    else
                        l = i;
                    invalidate(0, 0, mRight - mLeft, l - mTop);
                }
            } else {
                invalidate(true);
            }
            j = mRight - mLeft;
            k = mBottom - mTop;
            mBottom = i;
            if(mDisplayList != null)
                mDisplayList.setBottom(mBottom);
            onSizeChanged(j, mBottom - mTop, j, k);
            if(!flag) {
                if((0x20000000 & mPrivateFlags) == 0)
                    mTransformationInfo.mMatrixDirty = true;
                mPrivateFlags = 0x20 | mPrivateFlags;
                invalidate(true);
            }
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
            if((0x10000000 & mPrivateFlags2) == 0x10000000)
                invalidateParentIfNeeded();
        }
    }

    public void setCameraDistance(float f) {
        invalidateViewProperty(true, false);
        ensureTransformationInfo();
        float f1 = mResources.getDisplayMetrics().densityDpi;
        TransformationInfo transformationinfo = mTransformationInfo;
        if(transformationinfo.mCamera == null) {
            transformationinfo.mCamera = new Camera();
            transformationinfo.matrix3D = new Matrix();
        }
        transformationinfo.mCamera.setLocation(0.0F, 0.0F, -Math.abs(f) / f1);
        transformationinfo.mMatrixDirty = true;
        invalidateViewProperty(false, false);
        if(mDisplayList != null)
            mDisplayList.setCameraDistance(-Math.abs(f) / f1);
        if((0x10000000 & mPrivateFlags2) == 0x10000000)
            invalidateParentIfNeeded();
    }

    public void setClickable(boolean flag) {
        char c;
        if(flag)
            c = '\u4000';
        else
            c = '\0';
        setFlags(c, 16384);
    }

    public void setContentDescription(CharSequence charsequence) {
        mContentDescription = charsequence;
        boolean flag;
        if(charsequence != null && charsequence.length() > 0)
            flag = true;
        else
            flag = false;
        if(flag && getImportantForAccessibility() == 0)
            setImportantForAccessibility(1);
    }

    public void setDisabledSystemUiVisibility(int i) {
        if(mAttachInfo != null && mAttachInfo.mDisabledSystemUiVisibility != i) {
            mAttachInfo.mDisabledSystemUiVisibility = i;
            if(mParent != null)
                mParent.recomputeViewAttributes(this);
        }
    }

    void setDisplayListProperties(DisplayList displaylist) {
        if(displaylist == null) goto _L2; else goto _L1
_L1:
        float f;
        displaylist.setLeftTopRightBottom(mLeft, mTop, mRight, mBottom);
        displaylist.setHasOverlappingRendering(hasOverlappingRendering());
        if(mParent instanceof ViewGroup) {
            float f1;
            ViewGroup viewgroup;
            Transformation transformation;
            int i;
            boolean flag;
            if((1 & ((ViewGroup)mParent).mGroupFlags) != 0)
                flag = true;
            else
                flag = false;
            displaylist.setClipChildren(flag);
        }
        f = 1.0F;
        if((mParent instanceof ViewGroup) && (0x800 & ((ViewGroup)mParent).mGroupFlags) != 0) {
            viewgroup = (ViewGroup)mParent;
            if(viewgroup.getChildStaticTransformation(this, viewgroup.mChildTransformation)) {
                transformation = viewgroup.mChildTransformation;
                i = viewgroup.mChildTransformation.getTransformationType();
                if(i != Transformation.TYPE_IDENTITY) {
                    if((i & Transformation.TYPE_ALPHA) != 0)
                        f = transformation.getAlpha();
                    if((i & Transformation.TYPE_MATRIX) != 0)
                        displaylist.setStaticMatrix(transformation.getMatrix());
                }
            }
        }
        if(mTransformationInfo == null) goto _L4; else goto _L3
_L3:
        f1 = f * mTransformationInfo.mAlpha;
        if(f1 < 1.0F && onSetAlpha((int)(255F * f1)))
            f1 = 1.0F;
        displaylist.setTransformationInfo(f1, mTransformationInfo.mTranslationX, mTransformationInfo.mTranslationY, mTransformationInfo.mRotation, mTransformationInfo.mRotationX, mTransformationInfo.mRotationY, mTransformationInfo.mScaleX, mTransformationInfo.mScaleY);
        if(mTransformationInfo.mCamera == null) {
            mTransformationInfo.mCamera = new Camera();
            mTransformationInfo.matrix3D = new Matrix();
        }
        displaylist.setCameraDistance(mTransformationInfo.mCamera.getLocationZ());
        if((0x20000000 & mPrivateFlags) == 0x20000000) {
            displaylist.setPivotX(getPivotX());
            displaylist.setPivotY(getPivotY());
        }
_L2:
        return;
_L4:
        if(f < 1.0F)
            displaylist.setAlpha(f);
        if(true) goto _L2; else goto _L5
_L5:
    }

    public void setDrawingCacheBackgroundColor(int i) {
        if(i != mDrawingCacheBackgroundColor) {
            mDrawingCacheBackgroundColor = i;
            mPrivateFlags = 0xffff7fff & mPrivateFlags;
        }
    }

    public void setDrawingCacheEnabled(boolean flag) {
        int i = 0;
        mCachingFailed = false;
        if(flag)
            i = 32768;
        setFlags(i, 32768);
    }

    public void setDrawingCacheQuality(int i) {
        setFlags(i, 0x180000);
    }

    public void setDuplicateParentStateEnabled(boolean flag) {
        int i;
        if(flag)
            i = 0x400000;
        else
            i = 0;
        setFlags(i, 0x400000);
    }

    public void setEnabled(boolean flag) {
        if(flag != isEnabled()) {
            int i;
            if(flag)
                i = 0;
            else
                i = 32;
            setFlags(i, 32);
            refreshDrawableState();
            invalidate(true);
        }
    }

    public void setFadingEdgeLength(int i) {
        initScrollCache();
        mScrollCache.fadingEdgeLength = i;
    }

    public void setFilterTouchesWhenObscured(boolean flag) {
        int i;
        if(flag)
            i = 0;
        else
            i = 1024;
        setFlags(i, 1024);
    }

    public void setFitsSystemWindows(boolean flag) {
        byte byte0;
        if(flag)
            byte0 = 2;
        else
            byte0 = 0;
        setFlags(byte0, 2);
    }

    void setFlags(int i, int j) {
        int k = mViewFlags;
        mViewFlags = mViewFlags & ~j | i & j;
        int l = k ^ mViewFlags;
        if(l != 0) {
            int i1 = mPrivateFlags;
            if((l & 1) != 0 && (i1 & 0x10) != 0) {
                if((k & 1) == 1 && (i1 & 2) != 0)
                    clearFocus();
                else
                if((k & 1) == 0 && (i1 & 2) == 0 && mParent != null)
                    mParent.focusableViewAvailable(this);
                if(AccessibilityManager.getInstance(mContext).isEnabled())
                    notifyAccessibilityStateChanged();
            }
            if((i & 0xc) == 0 && (l & 0xc) != 0) {
                mPrivateFlags = 0x20 | mPrivateFlags;
                invalidate(true);
                needGlobalAttributesUpdate(true);
                if(mParent != null && mBottom > mTop && mRight > mLeft)
                    mParent.focusableViewAvailable(this);
            }
            if((l & 8) != 0) {
                needGlobalAttributesUpdate(false);
                requestLayout();
                if((0xc & mViewFlags) == 8) {
                    if(hasFocus())
                        clearFocus();
                    clearAccessibilityFocus();
                    destroyDrawingCache();
                    if(mParent instanceof View)
                        ((View)mParent).invalidate(true);
                    mPrivateFlags = 0x20 | mPrivateFlags;
                }
                if(mAttachInfo != null)
                    mAttachInfo.mViewVisibilityChanged = true;
            }
            if((l & 4) != 0) {
                needGlobalAttributesUpdate(false);
                mPrivateFlags = 0x20 | mPrivateFlags;
                if((0xc & mViewFlags) == 4 && hasFocus() && getRootView() != this) {
                    clearFocus();
                    clearAccessibilityFocus();
                }
                if(mAttachInfo != null)
                    mAttachInfo.mViewVisibilityChanged = true;
            }
            if((l & 0xc) != 0) {
                if(mParent instanceof ViewGroup) {
                    ((ViewGroup)mParent).onChildVisibilityChanged(this, l & 0xc, i & 0xc);
                    ((View)mParent).invalidate(true);
                } else
                if(mParent != null)
                    mParent.invalidateChild(this, null);
                dispatchVisibilityChanged(this, i & 0xc);
            }
            if((0x20000 & l) != 0)
                destroyDrawingCache();
            if((0x8000 & l) != 0) {
                destroyDrawingCache();
                mPrivateFlags = 0xffff7fff & mPrivateFlags;
                invalidateParentCaches();
            }
            if((0x180000 & l) != 0) {
                destroyDrawingCache();
                mPrivateFlags = 0xffff7fff & mPrivateFlags;
            }
            if((l & 0x80) != 0) {
                if((0x80 & mViewFlags) != 0) {
                    if(mBackground != null) {
                        mPrivateFlags = 0xffffff7f & mPrivateFlags;
                        mPrivateFlags = 0x100 | mPrivateFlags;
                    } else {
                        mPrivateFlags = 0x80 | mPrivateFlags;
                    }
                } else {
                    mPrivateFlags = 0xffffff7f & mPrivateFlags;
                }
                requestLayout();
                invalidate(true);
            }
            if((0x4000000 & l) != 0 && mParent != null && mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes)
                mParent.recomputeViewAttributes(this);
            if(AccessibilityManager.getInstance(mContext).isEnabled() && ((l & 1) != 0 || (l & 0x4000) != 0 || (0x200000 & l) != 0 || (l & 0) != 0))
                notifyAccessibilityStateChanged();
        }
    }

    public void setFocusable(boolean flag) {
        int i = 0;
        if(!flag)
            setFlags(0, 0x40000);
        if(flag)
            i = 1;
        setFlags(i, 1);
    }

    public void setFocusableInTouchMode(boolean flag) {
        int i;
        if(flag)
            i = 0x40000;
        else
            i = 0;
        setFlags(i, 0x40000);
        if(flag)
            setFlags(1, 1);
    }

    protected boolean setFrame(int i, int j, int k, int l) {
        boolean flag = false;
        if(mLeft != i || mRight != k || mTop != j || mBottom != l) {
            flag = true;
            int i1 = 0x20 & mPrivateFlags;
            int j1 = mRight - mLeft;
            int k1 = mBottom - mTop;
            int l1 = k - i;
            int i2 = l - j;
            boolean flag1;
            if(l1 != j1 || i2 != k1)
                flag1 = true;
            else
                flag1 = false;
            invalidate(flag1);
            mLeft = i;
            mTop = j;
            mRight = k;
            mBottom = l;
            if(mDisplayList != null)
                mDisplayList.setLeftTopRightBottom(mLeft, mTop, mRight, mBottom);
            mPrivateFlags = 0x10 | mPrivateFlags;
            if(flag1) {
                if((0x20000000 & mPrivateFlags) == 0 && mTransformationInfo != null)
                    mTransformationInfo.mMatrixDirty = true;
                onSizeChanged(l1, i2, j1, k1);
            }
            if((0xc & mViewFlags) == 0) {
                mPrivateFlags = 0x20 | mPrivateFlags;
                invalidate(flag1);
                invalidateParentCaches();
            }
            mPrivateFlags = i1 | mPrivateFlags;
            mBackgroundSizeChanged = true;
        }
        return flag;
    }

    public void setHapticFeedbackEnabled(boolean flag) {
        int i;
        if(flag)
            i = 0x10000000;
        else
            i = 0;
        setFlags(i, 0x10000000);
        mHapticEnabledExplicitly = flag;
    }

    public void setHasTransientState(boolean flag) {
        int i;
        int j;
        char c;
        if(flag)
            i = 1 + mTransientStateCount;
        else
            i = -1 + mTransientStateCount;
        mTransientStateCount = i;
        if(mTransientStateCount < 0) {
            mTransientStateCount = 0;
            Log.e("View", "hasTransientState decremented below 0: unmatched pair of setHasTransientState calls");
        }
        if((!flag || mTransientStateCount != 1) && (flag || mTransientStateCount != 0))
            break MISSING_BLOCK_LABEL_105;
        j = 0xfffffeff & mPrivateFlags2;
        if(flag)
            c = '\u0100';
        else
            c = '\0';
        mPrivateFlags2 = c | j;
        if(mParent == null)
            break MISSING_BLOCK_LABEL_105;
        mParent.childHasTransientStateChanged(this, flag);
_L1:
        return;
        AbstractMethodError abstractmethoderror;
        abstractmethoderror;
        Log.e("View", (new StringBuilder()).append(mParent.getClass().getSimpleName()).append(" does not fully implement ViewParent").toString(), abstractmethoderror);
          goto _L1
    }

    public void setHorizontalFadingEdgeEnabled(boolean flag) {
        if(isHorizontalFadingEdgeEnabled() != flag) {
            if(flag)
                initScrollCache();
            mViewFlags = 0x1000 ^ mViewFlags;
        }
    }

    public void setHorizontalScrollBarEnabled(boolean flag) {
        if(isHorizontalScrollBarEnabled() != flag) {
            mViewFlags = 0x100 ^ mViewFlags;
            computeOpaqueFlags();
            resolvePadding();
        }
    }

    public void setHovered(boolean flag) {
        if(!flag) goto _L2; else goto _L1
_L1:
        if((0x10000000 & mPrivateFlags) == 0) {
            mPrivateFlags = 0x10000000 | mPrivateFlags;
            refreshDrawableState();
            onHoverChanged(true);
        }
_L4:
        return;
_L2:
        if((0x10000000 & mPrivateFlags) != 0) {
            mPrivateFlags = 0xefffffff & mPrivateFlags;
            refreshDrawableState();
            onHoverChanged(false);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setId(int i) {
        mID = i;
    }

    public void setImportantForAccessibility(int i) {
        if(i != getImportantForAccessibility()) {
            mPrivateFlags2 = 0xffcfffff & mPrivateFlags2;
            mPrivateFlags2 = mPrivateFlags2 | 0x300000 & i << 20;
            notifyAccessibilityStateChanged();
        }
    }

    public void setIsRootNamespace(boolean flag) {
        if(flag)
            mPrivateFlags = 8 | mPrivateFlags;
        else
            mPrivateFlags = -9 & mPrivateFlags;
    }

    public void setKeepScreenOn(boolean flag) {
        int i;
        if(flag)
            i = 0x4000000;
        else
            i = 0;
        setFlags(i, 0x4000000);
    }

    public void setLayerType(int i, Paint paint) {
        Rect rect;
        boolean flag;
        rect = null;
        flag = false;
        if(i < 0 || i > 2)
            throw new IllegalArgumentException("Layer type can only be one of: LAYER_TYPE_NONE, LAYER_TYPE_SOFTWARE or LAYER_TYPE_HARDWARE");
        if(i != mLayerType) goto _L2; else goto _L1
_L1:
        if(i != 0 && paint != mLayerPaint) {
            if(paint == null)
                paint = new Paint();
            mLayerPaint = paint;
            invalidateParentCaches();
            invalidate(true);
        }
_L7:
        return;
_L2:
        mLayerType;
        JVM INSTR tableswitch 1 2: default 100
    //                   1 155
    //                   2 149;
           goto _L3 _L4 _L5
_L3:
        mLayerType = i;
        if(mLayerType == 0)
            flag = true;
        if(flag)
            paint = null;
        else
        if(paint == null)
            paint = new Paint();
        mLayerPaint = paint;
        if(!flag)
            rect = new Rect();
        mLocalDirtyRect = rect;
        invalidateParentCaches();
        invalidate(true);
        continue; /* Loop/switch isn't completed */
_L5:
        destroyLayer(false);
_L4:
        destroyDrawingCache();
          goto _L3
        if(true) goto _L7; else goto _L6
_L6:
    }

    public void setLayoutDirection(int i) {
        if(getLayoutDirection() != i) {
            mPrivateFlags2 = 0xfffffff3 & mPrivateFlags2;
            resetResolvedLayoutDirection();
            mPrivateFlags2 = mPrivateFlags2 | 0xc & i << 2;
            requestLayout();
        }
    }

    public void setLayoutInsets(Insets insets) {
        mLayoutInsets = insets;
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutparams) {
        if(layoutparams == null)
            throw new NullPointerException("Layout parameters cannot be null");
        mLayoutParams = layoutparams;
        if(mParent instanceof ViewGroup)
            ((ViewGroup)mParent).onSetLayoutParams(this, layoutparams);
        requestLayout();
    }

    public final void setLeft(int i) {
        if(i != mLeft) {
            updateMatrix();
            boolean flag;
            if(mTransformationInfo == null || mTransformationInfo.mMatrixIsIdentity)
                flag = true;
            else
                flag = false;
            if(flag) {
                if(mAttachInfo != null) {
                    int j;
                    int k;
                    int l;
                    int i1;
                    if(i < mLeft) {
                        l = i;
                        i1 = i - mLeft;
                    } else {
                        l = mLeft;
                        i1 = 0;
                    }
                    invalidate(i1, 0, mRight - l, mBottom - mTop);
                }
            } else {
                invalidate(true);
            }
            j = mRight - mLeft;
            k = mBottom - mTop;
            mLeft = i;
            if(mDisplayList != null)
                mDisplayList.setLeft(i);
            onSizeChanged(mRight - mLeft, k, j, k);
            if(!flag) {
                if((0x20000000 & mPrivateFlags) == 0)
                    mTransformationInfo.mMatrixDirty = true;
                mPrivateFlags = 0x20 | mPrivateFlags;
                invalidate(true);
            }
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
            if((0x10000000 & mPrivateFlags2) == 0x10000000)
                invalidateParentIfNeeded();
        }
    }

    public void setLongClickable(boolean flag) {
        int i;
        if(flag)
            i = 0x200000;
        else
            i = 0;
        setFlags(i, 0x200000);
    }

    protected final void setMeasuredDimension(int i, int j) {
        mMeasuredWidth = i;
        mMeasuredHeight = j;
        mPrivateFlags = 0x800 | mPrivateFlags;
    }

    public void setMinimumHeight(int i) {
        mMinHeight = i;
        requestLayout();
    }

    public void setMinimumWidth(int i) {
        mMinWidth = i;
        requestLayout();
    }

    public void setNextFocusDownId(int i) {
        mNextFocusDownId = i;
    }

    public void setNextFocusForwardId(int i) {
        mNextFocusForwardId = i;
    }

    public void setNextFocusLeftId(int i) {
        mNextFocusLeftId = i;
    }

    public void setNextFocusRightId(int i) {
        mNextFocusRightId = i;
    }

    public void setNextFocusUpId(int i) {
        mNextFocusUpId = i;
    }

    public void setOnClickListener(OnClickListener onclicklistener) {
        if(!isClickable())
            setClickable(true);
        getListenerInfo().mOnClickListener = onclicklistener;
    }

    public void setOnCreateContextMenuListener(OnCreateContextMenuListener oncreatecontextmenulistener) {
        if(!isLongClickable())
            setLongClickable(true);
        getListenerInfo().mOnCreateContextMenuListener = oncreatecontextmenulistener;
    }

    public void setOnDragListener(OnDragListener ondraglistener) {
        getListenerInfo().mOnDragListener = ondraglistener;
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onfocuschangelistener) {
        getListenerInfo().mOnFocusChangeListener = onfocuschangelistener;
    }

    public void setOnGenericMotionListener(OnGenericMotionListener ongenericmotionlistener) {
        getListenerInfo().mOnGenericMotionListener = ongenericmotionlistener;
    }

    public void setOnHoverListener(OnHoverListener onhoverlistener) {
        getListenerInfo().mOnHoverListener = onhoverlistener;
    }

    public void setOnKeyListener(OnKeyListener onkeylistener) {
        getListenerInfo().mOnKeyListener = onkeylistener;
    }

    public void setOnLongClickListener(OnLongClickListener onlongclicklistener) {
        if(!isLongClickable())
            setLongClickable(true);
        getListenerInfo().mOnLongClickListener = onlongclicklistener;
    }

    public void setOnSystemUiVisibilityChangeListener(OnSystemUiVisibilityChangeListener onsystemuivisibilitychangelistener) {
        getListenerInfo().mOnSystemUiVisibilityChangeListener = onsystemuivisibilitychangelistener;
        if(mParent != null && mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes)
            mParent.recomputeViewAttributes(this);
    }

    public void setOnTouchListener(OnTouchListener ontouchlistener) {
        getListenerInfo().mOnTouchListener = ontouchlistener;
    }

    public void setOverScrollMode(int i) {
        if(i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid overscroll mode ").append(i).toString());
        } else {
            mOverScrollMode = i;
            return;
        }
    }

    public void setPadding(int i, int j, int k, int l) {
        mUserPaddingStart = -1;
        mUserPaddingEnd = -1;
        mUserPaddingRelative = false;
        internalSetPadding(i, j, k, l);
    }

    public void setPaddingRelative(int i, int j, int k, int l) {
        mUserPaddingStart = i;
        mUserPaddingEnd = k;
        mUserPaddingRelative = true;
        getResolvedLayoutDirection();
        JVM INSTR tableswitch 1 1: default 36
    //                   1 46;
           goto _L1 _L2
_L1:
        internalSetPadding(i, j, k, l);
_L4:
        return;
_L2:
        internalSetPadding(k, j, i, l);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setPivotX(float f) {
        ensureTransformationInfo();
        mPrivateFlags = 0x20000000 | mPrivateFlags;
        TransformationInfo transformationinfo = mTransformationInfo;
        if(transformationinfo.mPivotX != f) {
            invalidateViewProperty(true, false);
            transformationinfo.mPivotX = f;
            transformationinfo.mMatrixDirty = true;
            invalidateViewProperty(false, true);
            if(mDisplayList != null)
                mDisplayList.setPivotX(f);
            if((0x10000000 & mPrivateFlags2) == 0x10000000)
                invalidateParentIfNeeded();
        }
    }

    public void setPivotY(float f) {
        ensureTransformationInfo();
        mPrivateFlags = 0x20000000 | mPrivateFlags;
        TransformationInfo transformationinfo = mTransformationInfo;
        if(transformationinfo.mPivotY != f) {
            invalidateViewProperty(true, false);
            transformationinfo.mPivotY = f;
            transformationinfo.mMatrixDirty = true;
            invalidateViewProperty(false, true);
            if(mDisplayList != null)
                mDisplayList.setPivotY(f);
            if((0x10000000 & mPrivateFlags2) == 0x10000000)
                invalidateParentIfNeeded();
        }
    }

    public void setPressed(boolean flag) {
        boolean flag1 = true;
        boolean flag2;
        if((0x4000 & mPrivateFlags) == 16384)
            flag2 = flag1;
        else
            flag2 = false;
        if(flag == flag2)
            flag1 = false;
        if(flag)
            mPrivateFlags = 0x4000 | mPrivateFlags;
        else
            mPrivateFlags = 0xffffbfff & mPrivateFlags;
        if(flag1)
            refreshDrawableState();
        dispatchSetPressed(flag);
    }

    public final void setRight(int i) {
        if(i != mRight) {
            updateMatrix();
            boolean flag;
            if(mTransformationInfo == null || mTransformationInfo.mMatrixIsIdentity)
                flag = true;
            else
                flag = false;
            if(flag) {
                if(mAttachInfo != null) {
                    int j;
                    int k;
                    int l;
                    if(i < mRight)
                        l = mRight;
                    else
                        l = i;
                    invalidate(0, 0, l - mLeft, mBottom - mTop);
                }
            } else {
                invalidate(true);
            }
            j = mRight - mLeft;
            k = mBottom - mTop;
            mRight = i;
            if(mDisplayList != null)
                mDisplayList.setRight(mRight);
            onSizeChanged(mRight - mLeft, k, j, k);
            if(!flag) {
                if((0x20000000 & mPrivateFlags) == 0)
                    mTransformationInfo.mMatrixDirty = true;
                mPrivateFlags = 0x20 | mPrivateFlags;
                invalidate(true);
            }
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
            if((0x10000000 & mPrivateFlags2) == 0x10000000)
                invalidateParentIfNeeded();
        }
    }

    public void setRotation(float f) {
        ensureTransformationInfo();
        TransformationInfo transformationinfo = mTransformationInfo;
        if(transformationinfo.mRotation != f) {
            invalidateViewProperty(true, false);
            transformationinfo.mRotation = f;
            transformationinfo.mMatrixDirty = true;
            invalidateViewProperty(false, true);
            if(mDisplayList != null)
                mDisplayList.setRotation(f);
            if((0x10000000 & mPrivateFlags2) == 0x10000000)
                invalidateParentIfNeeded();
        }
    }

    public void setRotationX(float f) {
        ensureTransformationInfo();
        TransformationInfo transformationinfo = mTransformationInfo;
        if(transformationinfo.mRotationX != f) {
            invalidateViewProperty(true, false);
            transformationinfo.mRotationX = f;
            transformationinfo.mMatrixDirty = true;
            invalidateViewProperty(false, true);
            if(mDisplayList != null)
                mDisplayList.setRotationX(f);
            if((0x10000000 & mPrivateFlags2) == 0x10000000)
                invalidateParentIfNeeded();
        }
    }

    public void setRotationY(float f) {
        ensureTransformationInfo();
        TransformationInfo transformationinfo = mTransformationInfo;
        if(transformationinfo.mRotationY != f) {
            invalidateViewProperty(true, false);
            transformationinfo.mRotationY = f;
            transformationinfo.mMatrixDirty = true;
            invalidateViewProperty(false, true);
            if(mDisplayList != null)
                mDisplayList.setRotationY(f);
            if((0x10000000 & mPrivateFlags2) == 0x10000000)
                invalidateParentIfNeeded();
        }
    }

    public void setSaveEnabled(boolean flag) {
        int i;
        if(flag)
            i = 0;
        else
            i = 0x10000;
        setFlags(i, 0x10000);
    }

    public void setSaveFromParentEnabled(boolean flag) {
        int i;
        if(flag)
            i = 0;
        else
            i = 0x20000000;
        setFlags(i, 0x20000000);
    }

    public void setScaleX(float f) {
        ensureTransformationInfo();
        TransformationInfo transformationinfo = mTransformationInfo;
        if(transformationinfo.mScaleX != f) {
            invalidateViewProperty(true, false);
            transformationinfo.mScaleX = f;
            transformationinfo.mMatrixDirty = true;
            invalidateViewProperty(false, true);
            if(mDisplayList != null)
                mDisplayList.setScaleX(f);
            if((0x10000000 & mPrivateFlags2) == 0x10000000)
                invalidateParentIfNeeded();
        }
    }

    public void setScaleY(float f) {
        ensureTransformationInfo();
        TransformationInfo transformationinfo = mTransformationInfo;
        if(transformationinfo.mScaleY != f) {
            invalidateViewProperty(true, false);
            transformationinfo.mScaleY = f;
            transformationinfo.mMatrixDirty = true;
            invalidateViewProperty(false, true);
            if(mDisplayList != null)
                mDisplayList.setScaleY(f);
            if((0x10000000 & mPrivateFlags2) == 0x10000000)
                invalidateParentIfNeeded();
        }
    }

    public void setScrollBarDefaultDelayBeforeFade(int i) {
        getScrollCache().scrollBarDefaultDelayBeforeFade = i;
    }

    public void setScrollBarFadeDuration(int i) {
        getScrollCache().scrollBarFadeDuration = i;
    }

    public void setScrollBarSize(int i) {
        getScrollCache().scrollBarSize = i;
    }

    public void setScrollBarStyle(int i) {
        if(i != (0x3000000 & mViewFlags)) {
            mViewFlags = 0xfcffffff & mViewFlags | i & 0x3000000;
            computeOpaqueFlags();
            resolvePadding();
        }
    }

    public void setScrollContainer(boolean flag) {
        if(flag) {
            if(mAttachInfo != null && (0x100000 & mPrivateFlags) == 0) {
                mAttachInfo.mScrollContainers.add(this);
                mPrivateFlags = 0x100000 | mPrivateFlags;
            }
            mPrivateFlags = 0x80000 | mPrivateFlags;
        } else {
            if((0x100000 & mPrivateFlags) != 0)
                mAttachInfo.mScrollContainers.remove(this);
            mPrivateFlags = 0xffe7ffff & mPrivateFlags;
        }
    }

    public void setScrollX(int i) {
        scrollTo(i, mScrollY);
    }

    public void setScrollY(int i) {
        scrollTo(mScrollX, i);
    }

    public void setScrollbarFadingEnabled(boolean flag) {
        initScrollCache();
        ScrollabilityCache scrollabilitycache = mScrollCache;
        scrollabilitycache.fadeScrollBars = flag;
        if(flag)
            scrollabilitycache.state = 0;
        else
            scrollabilitycache.state = 1;
    }

    public void setSelected(boolean flag) {
        byte byte0 = 0;
        boolean flag1;
        if((4 & mPrivateFlags) != 0)
            flag1 = true;
        else
            flag1 = false;
        if(flag1 != flag) {
            int i = -5 & mPrivateFlags;
            if(flag)
                byte0 = 4;
            mPrivateFlags = byte0 | i;
            if(!flag)
                resetPressedState();
            invalidate(true);
            refreshDrawableState();
            dispatchSetSelected(flag);
            if(AccessibilityManager.getInstance(mContext).isEnabled())
                notifyAccessibilityStateChanged();
        }
    }

    public void setSoundEffectsEnabled(boolean flag) {
        int i;
        if(flag)
            i = 0x8000000;
        else
            i = 0;
        setFlags(i, 0x8000000);
    }

    public void setSystemUiVisibility(int i) {
        if(i != mSystemUiVisibility) {
            mSystemUiVisibility = i;
            if(mParent != null && mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes)
                mParent.recomputeViewAttributes(this);
        }
    }

    public void setTag(int i, Object obj) {
        if(i >>> 24 < 2) {
            throw new IllegalArgumentException("The key must be an application-specific resource id.");
        } else {
            setKeyedTag(i, obj);
            return;
        }
    }

    public void setTag(Object obj) {
        mTag = obj;
    }

    public void setTagInternal(int i, Object obj) {
        if(i >>> 24 != 1) {
            throw new IllegalArgumentException("The key must be a framework-specific resource id.");
        } else {
            setKeyedTag(i, obj);
            return;
        }
    }

    public void setTextAlignment(int i) {
        if(i != getTextAlignment()) {
            mPrivateFlags2 = 0xffff1fff & mPrivateFlags2;
            resetResolvedTextAlignment();
            mPrivateFlags2 = mPrivateFlags2 | 0xe000 & i << 13;
            requestLayout();
            invalidate(true);
        }
    }

    public void setTextDirection(int i) {
        if(getTextDirection() != i) {
            mPrivateFlags2 = 0xfffffe3f & mPrivateFlags2;
            resetResolvedTextDirection();
            mPrivateFlags2 = mPrivateFlags2 | 0x1c0 & i << 6;
            requestLayout();
            invalidate(true);
        }
    }

    public final void setTop(int i) {
        if(i != mTop) {
            updateMatrix();
            boolean flag;
            if(mTransformationInfo == null || mTransformationInfo.mMatrixIsIdentity)
                flag = true;
            else
                flag = false;
            if(flag) {
                if(mAttachInfo != null) {
                    int j;
                    int k;
                    int l;
                    int i1;
                    if(i < mTop) {
                        l = i;
                        i1 = i - mTop;
                    } else {
                        l = mTop;
                        i1 = 0;
                    }
                    invalidate(0, i1, mRight - mLeft, mBottom - l);
                }
            } else {
                invalidate(true);
            }
            j = mRight - mLeft;
            k = mBottom - mTop;
            mTop = i;
            if(mDisplayList != null)
                mDisplayList.setTop(mTop);
            onSizeChanged(j, mBottom - mTop, j, k);
            if(!flag) {
                if((0x20000000 & mPrivateFlags) == 0)
                    mTransformationInfo.mMatrixDirty = true;
                mPrivateFlags = 0x20 | mPrivateFlags;
                invalidate(true);
            }
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
            if((0x10000000 & mPrivateFlags2) == 0x10000000)
                invalidateParentIfNeeded();
        }
    }

    public void setTouchDelegate(TouchDelegate touchdelegate) {
        mTouchDelegate = touchdelegate;
    }

    public void setTranslationX(float f) {
        ensureTransformationInfo();
        TransformationInfo transformationinfo = mTransformationInfo;
        if(transformationinfo.mTranslationX != f) {
            invalidateViewProperty(true, false);
            transformationinfo.mTranslationX = f;
            transformationinfo.mMatrixDirty = true;
            invalidateViewProperty(false, true);
            if(mDisplayList != null)
                mDisplayList.setTranslationX(f);
            if((0x10000000 & mPrivateFlags2) == 0x10000000)
                invalidateParentIfNeeded();
        }
    }

    public void setTranslationY(float f) {
        ensureTransformationInfo();
        TransformationInfo transformationinfo = mTransformationInfo;
        if(transformationinfo.mTranslationY != f) {
            invalidateViewProperty(true, false);
            transformationinfo.mTranslationY = f;
            transformationinfo.mMatrixDirty = true;
            invalidateViewProperty(false, true);
            if(mDisplayList != null)
                mDisplayList.setTranslationY(f);
            if((0x10000000 & mPrivateFlags2) == 0x10000000)
                invalidateParentIfNeeded();
        }
    }

    public void setVerticalFadingEdgeEnabled(boolean flag) {
        if(isVerticalFadingEdgeEnabled() != flag) {
            if(flag)
                initScrollCache();
            mViewFlags = 0x2000 ^ mViewFlags;
        }
    }

    public void setVerticalScrollBarEnabled(boolean flag) {
        if(isVerticalScrollBarEnabled() != flag) {
            mViewFlags = 0x200 ^ mViewFlags;
            computeOpaqueFlags();
            resolvePadding();
        }
    }

    public void setVerticalScrollbarPosition(int i) {
        if(mVerticalScrollbarPosition != i) {
            mVerticalScrollbarPosition = i;
            computeOpaqueFlags();
            resolvePadding();
        }
    }

    public void setVisibility(int i) {
        setFlags(i, 12);
        if(mBackground != null) {
            Drawable drawable = mBackground;
            boolean flag;
            if(i == 0)
                flag = true;
            else
                flag = false;
            drawable.setVisible(flag, false);
        }
    }

    public void setWillNotCacheDrawing(boolean flag) {
        int i;
        if(flag)
            i = 0x20000;
        else
            i = 0;
        setFlags(i, 0x20000);
    }

    public void setWillNotDraw(boolean flag) {
        char c;
        if(flag)
            c = '\200';
        else
            c = '\0';
        setFlags(c, 128);
    }

    public void setX(float f) {
        setTranslationX(f - (float)mLeft);
    }

    public void setY(float f) {
        setTranslationY(f - (float)mTop);
    }

    public boolean showContextMenu() {
        return getParent().showContextMenuForChild(this);
    }

    public boolean showContextMenu(float f, float f1, int i) {
        return showContextMenu();
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        ViewParent viewparent = getParent();
        ActionMode actionmode;
        if(viewparent == null)
            actionmode = null;
        else
            actionmode = viewparent.startActionModeForChild(this, callback);
        return actionmode;
    }

    public void startAnimation(Animation animation) {
        animation.setStartTime(-1L);
        setAnimation(animation);
        invalidateParentCaches();
        invalidate(true);
    }

    public final boolean startDrag(ClipData clipdata, DragShadowBuilder dragshadowbuilder, Object obj, int i) {
        boolean flag;
        Point point;
        Point point1;
        Surface surface;
        flag = false;
        point = new Point();
        point1 = new Point();
        dragshadowbuilder.onProvideShadowMetrics(point, point1);
        if(point.x < 0 || point.y < 0 || point1.x < 0 || point1.y < 0)
            throw new IllegalStateException("Drag shadow dimensions must not be negative");
        surface = new Surface();
        IBinder ibinder;
        Canvas canvas;
        ibinder = mAttachInfo.mSession.prepareDrag(mAttachInfo.mWindow, i, point.x, point.y, surface);
        if(ibinder == null)
            break MISSING_BLOCK_LABEL_257;
        canvas = surface.lockCanvas(null);
        canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        dragshadowbuilder.onDrawShadow(canvas);
        surface.unlockCanvasAndPost(canvas);
        ViewRootImpl viewrootimpl = getViewRootImpl();
        viewrootimpl.setLocalDragState(obj);
        viewrootimpl.getLastTouchPoint(point);
        flag = mAttachInfo.mSession.performDrag(mAttachInfo.mWindow, ibinder, point.x, point.y, point1.x, point1.y, clipdata);
        surface.release();
        break MISSING_BLOCK_LABEL_257;
        Exception exception1;
        exception1;
        surface.unlockCanvasAndPost(canvas);
        throw exception1;
        Exception exception;
        exception;
        Log.e("View", "Unable to initiate drag", exception);
        surface.destroy();
        return flag;
    }

    void transformRect(Rect rect) {
        if(!getMatrix().isIdentity()) {
            RectF rectf = mAttachInfo.mTmpTransformRect;
            rectf.set(rect);
            getMatrix().mapRect(rectf);
            rect.set((int)(rectf.left - 0.5F), (int)(rectf.top - 0.5F), (int)(0.5F + rectf.right), (int)(0.5F + rectf.bottom));
        }
    }

    void unFocus() {
        if((2 & mPrivateFlags) != 0) {
            mPrivateFlags = -3 & mPrivateFlags;
            onFocusChanged(false, 0, null);
            refreshDrawableState();
            if(AccessibilityManager.getInstance(mContext).isEnabled())
                notifyAccessibilityStateChanged();
        }
    }

    public void unscheduleDrawable(Drawable drawable) {
        if(mAttachInfo != null && drawable != null)
            mAttachInfo.mViewRootImpl.mChoreographer.removeCallbacks(1, null, drawable);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if(verifyDrawable(drawable) && runnable != null)
            if(mAttachInfo != null)
                mAttachInfo.mViewRootImpl.mChoreographer.removeCallbacks(1, runnable, drawable);
            else
                ViewRootImpl.getRunQueue().removeCallbacks(runnable);
    }

    boolean updateLocalSystemUiVisibility(int i, int j) {
        int k = mSystemUiVisibility & ~j | i & j;
        boolean flag;
        if(k != mSystemUiVisibility) {
            setSystemUiVisibility(k);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean flag;
        if(drawable == mBackground)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean willNotCacheDrawing() {
        boolean flag;
        if((0x20000 & mViewFlags) == 0x20000)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean willNotDraw() {
        boolean flag;
        if((0x80 & mViewFlags) == 128)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static final int ACCESSIBILITY_CURSOR_POSITION_UNDEFINED = -1;
    public static final int ACCESSIBILITY_FOCUSABLE_AUTO = 0;
    static final int ACCESSIBILITY_FOCUSABLE_DEFAULT = 0;
    static final int ACCESSIBILITY_FOCUSABLE_MASK = 0x60000000;
    public static final int ACCESSIBILITY_FOCUSABLE_NO = 2;
    static final int ACCESSIBILITY_FOCUSABLE_SHIFT = 29;
    public static final int ACCESSIBILITY_FOCUSABLE_YES = 1;
    static final int ACCESSIBILITY_FOCUSED = 0x4000000;
    public static final int ACCESSIBILITY_FOCUS_BACKWARD = 4097;
    public static final int ACCESSIBILITY_FOCUS_DOWN = 4226;
    public static final int ACCESSIBILITY_FOCUS_FORWARD = 4098;
    public static final int ACCESSIBILITY_FOCUS_LEFT = 4113;
    public static final int ACCESSIBILITY_FOCUS_RIGHT = 4162;
    public static final int ACCESSIBILITY_FOCUS_UP = 4129;
    static final int ACCESSIBILITY_STATE_CHANGED = 0x8000000;
    static final int ACTIVATED = 0x40000000;
    public static final Property ALPHA = new FloatProperty("alpha") {

        public Float get(View view) {
            return Float.valueOf(view.getAlpha());
        }

        public volatile Object get(Object obj) {
            return get((View)obj);
        }

        public void setValue(View view, float f) {
            view.setAlpha(f);
        }

        public volatile void setValue(Object obj, float f) {
            setValue((View)obj, f);
        }

    };
    static final int ALPHA_SET = 0x40000;
    static final int ANIMATION_STARTED = 0x10000;
    private static final int AWAKEN_SCROLL_BARS_ON_ATTACH = 0x8000000;
    static final int CANCEL_NEXT_UP_EVENT = 0x4000000;
    static final int CLICKABLE = 16384;
    private static final boolean DBG = false;
    public static final String DEBUG_LAYOUT_PROPERTY = "debug.layout";
    static final int DIRTY = 0x200000;
    static final int DIRTY_MASK = 0x600000;
    static final int DIRTY_OPAQUE = 0x400000;
    static final int DISABLED = 32;
    static final int DRAG_CAN_ACCEPT = 1;
    public static final int DRAG_FLAG_GLOBAL = 1;
    static final int DRAG_HOVERED = 2;
    static final int DRAG_MASK = 3;
    static final int DRAWABLE_STATE_DIRTY = 1024;
    static final int DRAWING_CACHE_ENABLED = 32768;
    public static final int DRAWING_CACHE_QUALITY_AUTO = 0;
    private static final int DRAWING_CACHE_QUALITY_FLAGS[];
    public static final int DRAWING_CACHE_QUALITY_HIGH = 0x100000;
    public static final int DRAWING_CACHE_QUALITY_LOW = 0x80000;
    static final int DRAWING_CACHE_QUALITY_MASK = 0x180000;
    static final int DRAWING_CACHE_VALID = 32768;
    static final int DRAWN = 32;
    static final int DRAW_ANIMATION = 64;
    static final int DRAW_MASK = 128;
    static final int DUPLICATE_PARENT_STATE = 0x400000;
    protected static final int EMPTY_STATE_SET[];
    static final int ENABLED = 0;
    protected static final int ENABLED_FOCUSED_SELECTED_STATE_SET[];
    protected static final int ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET[];
    protected static final int ENABLED_FOCUSED_STATE_SET[];
    protected static final int ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET[];
    static final int ENABLED_MASK = 32;
    protected static final int ENABLED_SELECTED_STATE_SET[];
    protected static final int ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET[];
    protected static final int ENABLED_STATE_SET[];
    protected static final int ENABLED_WINDOW_FOCUSED_STATE_SET[];
    static final int FADING_EDGE_HORIZONTAL = 4096;
    static final int FADING_EDGE_MASK = 12288;
    static final int FADING_EDGE_NONE = 0;
    static final int FADING_EDGE_VERTICAL = 8192;
    static final int FILTER_TOUCHES_WHEN_OBSCURED = 1024;
    public static final int FIND_VIEWS_WITH_ACCESSIBILITY_NODE_PROVIDERS = 4;
    public static final int FIND_VIEWS_WITH_CONTENT_DESCRIPTION = 2;
    public static final int FIND_VIEWS_WITH_TEXT = 1;
    private static final int FITS_SYSTEM_WINDOWS = 2;
    private static final int FOCUSABLE = 1;
    public static final int FOCUSABLES_ACCESSIBILITY = 2;
    public static final int FOCUSABLES_ALL = 0;
    public static final int FOCUSABLES_TOUCH_MODE = 1;
    static final int FOCUSABLE_IN_TOUCH_MODE = 0x40000;
    private static final int FOCUSABLE_MASK = 1;
    static final int FOCUSED = 2;
    protected static final int FOCUSED_SELECTED_STATE_SET[];
    protected static final int FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET[];
    protected static final int FOCUSED_STATE_SET[];
    protected static final int FOCUSED_WINDOW_FOCUSED_STATE_SET[];
    public static final int FOCUS_ACCESSIBILITY = 4096;
    public static final int FOCUS_BACKWARD = 1;
    public static final int FOCUS_DOWN = 130;
    public static final int FOCUS_FORWARD = 2;
    public static final int FOCUS_LEFT = 17;
    public static final int FOCUS_RIGHT = 66;
    public static final int FOCUS_UP = 33;
    static final int FORCE_LAYOUT = 4096;
    public static final int GONE = 8;
    public static final int HAPTIC_FEEDBACK_ENABLED = 0x10000000;
    static final int HAS_BOUNDS = 16;
    static final int HAS_TRANSIENT_STATE = 256;
    private static final int HOVERED = 0x10000000;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    static final int IMPORTANT_FOR_ACCESSIBILITY_DEFAULT = 0;
    static final int IMPORTANT_FOR_ACCESSIBILITY_MASK = 0x300000;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    static final int IMPORTANT_FOR_ACCESSIBILITY_SHIFT = 20;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    static final int INVALIDATED = 0x80000000;
    public static final int INVISIBLE = 4;
    static final int IS_ROOT_NAMESPACE = 8;
    public static final int KEEP_SCREEN_ON = 0x4000000;
    public static final int LAYER_TYPE_HARDWARE = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    private static final int LAYOUT_DIRECTION_DEFAULT = 2;
    private static final int LAYOUT_DIRECTION_FLAGS[];
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    static final int LAYOUT_DIRECTION_MASK = 12;
    static final int LAYOUT_DIRECTION_MASK_SHIFT = 2;
    static final int LAYOUT_DIRECTION_RESOLVED = 32;
    static final int LAYOUT_DIRECTION_RESOLVED_MASK = 48;
    static final int LAYOUT_DIRECTION_RESOLVED_RTL = 16;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    static final int LAYOUT_REQUIRED = 8192;
    static final int LONG_CLICKABLE = 0x200000;
    static final int MEASURED_DIMENSION_SET = 2048;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_SIZE_MASK = 0xffffff;
    public static final int MEASURED_STATE_MASK = 0xff000000;
    public static final int MEASURED_STATE_TOO_SMALL = 0x1000000;
    private static final float NONZERO_EPSILON = 0.001F;
    private static final int NOT_FOCUSABLE = 0;
    public static final int NO_ID = -1;
    static final int ONLY_DRAWS_BACKGROUND = 256;
    static final int OPAQUE_BACKGROUND = 0x800000;
    static final int OPAQUE_MASK = 0x1800000;
    static final int OPAQUE_SCROLLBARS = 0x1000000;
    static final int OPTIONAL_FITS_SYSTEM_WINDOWS = 2048;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    static final int PARENT_SAVE_DISABLED = 0x20000000;
    static final int PARENT_SAVE_DISABLED_MASK = 0x20000000;
    private static final int PIVOT_EXPLICITLY_SET = 0x20000000;
    private static final int POPULATING_ACCESSIBILITY_EVENT_TYPES = 0x2a1bf;
    private static final int PREPRESSED = 0x2000000;
    private static final int PRESSED = 16384;
    protected static final int PRESSED_ENABLED_FOCUSED_SELECTED_STATE_SET[];
    protected static final int PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET[];
    protected static final int PRESSED_ENABLED_FOCUSED_STATE_SET[];
    protected static final int PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET[];
    protected static final int PRESSED_ENABLED_SELECTED_STATE_SET[];
    protected static final int PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET[];
    protected static final int PRESSED_ENABLED_STATE_SET[];
    protected static final int PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET[];
    protected static final int PRESSED_FOCUSED_SELECTED_STATE_SET[];
    protected static final int PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET[];
    protected static final int PRESSED_FOCUSED_STATE_SET[];
    protected static final int PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET[];
    protected static final int PRESSED_SELECTED_STATE_SET[];
    protected static final int PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET[];
    protected static final int PRESSED_STATE_SET[];
    protected static final int PRESSED_WINDOW_FOCUSED_STATE_SET[];
    public static final int PUBLIC_STATUS_BAR_VISIBILITY_MASK = 65535;
    static final int REQUEST_TRANSPARENT_REGIONS = 512;
    public static final Property ROTATION = new FloatProperty("rotation") {

        public Float get(View view) {
            return Float.valueOf(view.getRotation());
        }

        public volatile Object get(Object obj) {
            return get((View)obj);
        }

        public void setValue(View view, float f) {
            view.setRotation(f);
        }

        public volatile void setValue(Object obj, float f) {
            setValue((View)obj, f);
        }

    };
    public static final Property ROTATION_X = new FloatProperty("rotationX") {

        public Float get(View view) {
            return Float.valueOf(view.getRotationX());
        }

        public volatile Object get(Object obj) {
            return get((View)obj);
        }

        public void setValue(View view, float f) {
            view.setRotationX(f);
        }

        public volatile void setValue(Object obj, float f) {
            setValue((View)obj, f);
        }

    };
    public static final Property ROTATION_Y = new FloatProperty("rotationY") {

        public Float get(View view) {
            return Float.valueOf(view.getRotationY());
        }

        public volatile Object get(Object obj) {
            return get((View)obj);
        }

        public void setValue(View view, float f) {
            view.setRotationY(f);
        }

        public volatile void setValue(Object obj, float f) {
            setValue((View)obj, f);
        }

    };
    static final int SAVE_DISABLED = 0x10000;
    static final int SAVE_DISABLED_MASK = 0x10000;
    private static final int SAVE_STATE_CALLED = 0x20000;
    public static final Property SCALE_X = new FloatProperty("scaleX") {

        public Float get(View view) {
            return Float.valueOf(view.getScaleX());
        }

        public volatile Object get(Object obj) {
            return get((View)obj);
        }

        public void setValue(View view, float f) {
            view.setScaleX(f);
        }

        public volatile void setValue(Object obj, float f) {
            setValue((View)obj, f);
        }

    };
    public static final Property SCALE_Y = new FloatProperty("scaleY") {

        public Float get(View view) {
            return Float.valueOf(view.getScaleY());
        }

        public volatile Object get(Object obj) {
            return get((View)obj);
        }

        public void setValue(View view, float f) {
            view.setScaleY(f);
        }

        public volatile void setValue(Object obj, float f) {
            setValue((View)obj, f);
        }

    };
    public static final int SCREEN_STATE_OFF = 0;
    public static final int SCREEN_STATE_ON = 1;
    static final int SCROLLBARS_HORIZONTAL = 256;
    static final int SCROLLBARS_INSET_MASK = 0x1000000;
    public static final int SCROLLBARS_INSIDE_INSET = 0x1000000;
    public static final int SCROLLBARS_INSIDE_OVERLAY = 0;
    static final int SCROLLBARS_MASK = 768;
    static final int SCROLLBARS_NONE = 0;
    public static final int SCROLLBARS_OUTSIDE_INSET = 0x3000000;
    static final int SCROLLBARS_OUTSIDE_MASK = 0x2000000;
    public static final int SCROLLBARS_OUTSIDE_OVERLAY = 0x2000000;
    static final int SCROLLBARS_STYLE_MASK = 0x3000000;
    static final int SCROLLBARS_VERTICAL = 512;
    public static final int SCROLLBAR_POSITION_DEFAULT = 0;
    public static final int SCROLLBAR_POSITION_LEFT = 1;
    public static final int SCROLLBAR_POSITION_RIGHT = 2;
    static final int SCROLL_CONTAINER = 0x80000;
    static final int SCROLL_CONTAINER_ADDED = 0x100000;
    static final int SELECTED = 4;
    protected static final int SELECTED_STATE_SET[];
    protected static final int SELECTED_WINDOW_FOCUSED_STATE_SET[];
    static final int SKIP_DRAW = 128;
    public static final int SOUND_EFFECTS_ENABLED = 0x8000000;
    public static final int STATUS_BAR_DISABLE_BACK = 0x400000;
    public static final int STATUS_BAR_DISABLE_CLOCK = 0x800000;
    public static final int STATUS_BAR_DISABLE_EXPAND = 0x10000;
    public static final int STATUS_BAR_DISABLE_HOME = 0x200000;
    public static final int STATUS_BAR_DISABLE_NOTIFICATION_ALERTS = 0x40000;
    public static final int STATUS_BAR_DISABLE_NOTIFICATION_ICONS = 0x20000;
    public static final int STATUS_BAR_DISABLE_NOTIFICATION_TICKER = 0x80000;
    public static final int STATUS_BAR_DISABLE_RECENT = 0x1000000;
    public static final int STATUS_BAR_DISABLE_SYSTEM_INFO = 0x100000;
    public static final int STATUS_BAR_HIDDEN = 1;
    public static final int STATUS_BAR_VISIBLE = 0;
    public static final int SYSTEM_UI_CLEARABLE_FLAGS = 7;
    public static final int SYSTEM_UI_FLAG_FULLSCREEN = 4;
    public static final int SYSTEM_UI_FLAG_HIDE_NAVIGATION = 2;
    public static final int SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN = 1024;
    public static final int SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION = 512;
    public static final int SYSTEM_UI_FLAG_LAYOUT_STABLE = 256;
    public static final int SYSTEM_UI_FLAG_LOW_PROFILE = 1;
    public static final int SYSTEM_UI_FLAG_VISIBLE = 0;
    public static final int SYSTEM_UI_LAYOUT_FLAGS = 1536;
    public static final int TEXT_ALIGNMENT_CENTER = 4;
    protected static int TEXT_ALIGNMENT_DEFAULT = 0;
    private static final int TEXT_ALIGNMENT_FLAGS[];
    public static final int TEXT_ALIGNMENT_GRAVITY = 1;
    public static final int TEXT_ALIGNMENT_INHERIT = 0;
    static final int TEXT_ALIGNMENT_MASK = 57344;
    static final int TEXT_ALIGNMENT_MASK_SHIFT = 13;
    static final int TEXT_ALIGNMENT_RESOLVED = 0x10000;
    public static final int TEXT_ALIGNMENT_RESOLVED_DEFAULT = 0x20000;
    static final int TEXT_ALIGNMENT_RESOLVED_MASK = 0xe0000;
    static final int TEXT_ALIGNMENT_RESOLVED_MASK_SHIFT = 17;
    public static final int TEXT_ALIGNMENT_TEXT_END = 3;
    public static final int TEXT_ALIGNMENT_TEXT_START = 2;
    public static final int TEXT_ALIGNMENT_VIEW_END = 6;
    public static final int TEXT_ALIGNMENT_VIEW_START = 5;
    public static final int TEXT_DIRECTION_ANY_RTL = 2;
    protected static int TEXT_DIRECTION_DEFAULT = 0;
    public static final int TEXT_DIRECTION_FIRST_STRONG = 1;
    private static final int TEXT_DIRECTION_FLAGS[];
    public static final int TEXT_DIRECTION_INHERIT = 0;
    public static final int TEXT_DIRECTION_LOCALE = 5;
    public static final int TEXT_DIRECTION_LTR = 3;
    static final int TEXT_DIRECTION_MASK = 448;
    static final int TEXT_DIRECTION_MASK_SHIFT = 6;
    static final int TEXT_DIRECTION_RESOLVED = 512;
    static final int TEXT_DIRECTION_RESOLVED_DEFAULT = 1024;
    static final int TEXT_DIRECTION_RESOLVED_MASK = 7168;
    static final int TEXT_DIRECTION_RESOLVED_MASK_SHIFT = 10;
    public static final int TEXT_DIRECTION_RTL = 4;
    public static final Property TRANSLATION_X = new FloatProperty("translationX") {

        public Float get(View view) {
            return Float.valueOf(view.getTranslationX());
        }

        public volatile Object get(Object obj) {
            return get((View)obj);
        }

        public void setValue(View view, float f) {
            view.setTranslationX(f);
        }

        public volatile void setValue(Object obj, float f) {
            setValue((View)obj, f);
        }

    };
    public static final Property TRANSLATION_Y = new FloatProperty("translationY") {

        public Float get(View view) {
            return Float.valueOf(view.getTranslationY());
        }

        public volatile Object get(Object obj) {
            return get((View)obj);
        }

        public void setValue(View view, float f) {
            view.setTranslationY(f);
        }

        public volatile void setValue(Object obj, float f) {
            setValue((View)obj, f);
        }

    };
    static final int VIEW_IS_ANIMATING_ALPHA = 2;
    static final int VIEW_IS_ANIMATING_TRANSFORM = 1;
    protected static final String VIEW_LOG_TAG = "View";
    static final int VIEW_QUICK_REJECTED = 0x10000000;
    static final int VIEW_STATE_ACCELERATED = 64;
    static final int VIEW_STATE_ACTIVATED = 32;
    static final int VIEW_STATE_DRAG_CAN_ACCEPT = 256;
    static final int VIEW_STATE_DRAG_HOVERED = 512;
    static final int VIEW_STATE_ENABLED = 8;
    static final int VIEW_STATE_FOCUSED = 4;
    static final int VIEW_STATE_HOVERED = 128;
    static final int VIEW_STATE_IDS[];
    static final int VIEW_STATE_PRESSED = 16;
    static final int VIEW_STATE_SELECTED = 2;
    private static final int VIEW_STATE_SETS[][];
    static final int VIEW_STATE_WINDOW_FOCUSED = 1;
    private static final int VISIBILITY_FLAGS[];
    static final int VISIBILITY_MASK = 12;
    public static final int VISIBLE = 0;
    static final int WANTS_FOCUS = 1;
    static final int WILL_NOT_CACHE_DRAWING = 0x20000;
    static final int WILL_NOT_DRAW = 128;
    protected static final int WINDOW_FOCUSED_STATE_SET[];
    public static final Property X = new FloatProperty("x") {

        public Float get(View view) {
            return Float.valueOf(view.getX());
        }

        public volatile Object get(Object obj) {
            return get((View)obj);
        }

        public void setValue(View view, float f) {
            view.setX(f);
        }

        public volatile void setValue(Object obj, float f) {
            setValue((View)obj, f);
        }

    };
    public static final Property Y = new FloatProperty("y") {

        public Float get(View view) {
            return Float.valueOf(view.getY());
        }

        public volatile Object get(Object obj) {
            return get((View)obj);
        }

        public void setValue(View view, float f) {
            view.setY(f);
        }

        public volatile void setValue(Object obj, float f) {
            setValue((View)obj, f);
        }

    };
    private static int sNextAccessibilityViewId;
    static final ThreadLocal sThreadLocal = new ThreadLocal();
    private int mAccessibilityCursorPosition;
    AccessibilityDelegate mAccessibilityDelegate;
    int mAccessibilityViewId;
    int mAdditionalState;
    private ViewPropertyAnimator mAnimator;
    AttachInfo mAttachInfo;
    private Drawable mBackground;
    private int mBackgroundResource;
    private boolean mBackgroundSizeChanged;
    protected int mBottom;
    public boolean mCachingFailed;
    private CharSequence mContentDescription;
    protected Context mContext;
    protected Animation mCurrentAnimation;
    DisplayList mDisplayList;
    private int mDrawableState[];
    private Bitmap mDrawingCache;
    private int mDrawingCacheBackgroundColor;
    private ViewTreeObserver mFloatingTreeObserver;
    boolean mHapticEnabledExplicitly;
    private HardwareLayer mHardwareLayer;
    private boolean mHasPerformedLongPress;
    int mID;
    protected final InputEventConsistencyVerifier mInputEventConsistencyVerifier;
    private SparseArray mKeyedTags;
    private boolean mLastIsOpaque;
    Paint mLayerPaint;
    int mLayerType;
    private Insets mLayoutInsets;
    protected ViewGroup.LayoutParams mLayoutParams;
    protected int mLeft;
    ListenerInfo mListenerInfo;
    Rect mLocalDirtyRect;
    int mMeasuredHeight;
    int mMeasuredWidth;
    private int mMinHeight;
    private int mMinWidth;
    private int mNextFocusDownId;
    int mNextFocusForwardId;
    private int mNextFocusLeftId;
    private int mNextFocusRightId;
    private int mNextFocusUpId;
    int mOldHeightMeasureSpec;
    int mOldWidthMeasureSpec;
    private int mOverScrollMode;
    protected int mPaddingBottom;
    protected int mPaddingLeft;
    protected int mPaddingRight;
    protected int mPaddingTop;
    protected ViewParent mParent;
    private CheckForLongPress mPendingCheckForLongPress;
    private CheckForTap mPendingCheckForTap;
    private PerformClick mPerformClick;
    int mPrivateFlags;
    int mPrivateFlags2;
    int mPrivateFlags3;
    boolean mRecreateDisplayList;
    private final Resources mResources;
    protected int mRight;
    private ScrollabilityCache mScrollCache;
    protected int mScrollX;
    protected int mScrollY;
    private SendViewScrolledAccessibilityEvent mSendViewScrolledAccessibilityEvent;
    private boolean mSendingHoverAccessibilityEvents;
    int mSystemUiVisibility;
    protected Object mTag;
    protected int mTop;
    private TouchDelegate mTouchDelegate;
    private int mTouchSlop;
    TransformationInfo mTransformationInfo;
    int mTransientStateCount;
    private Bitmap mUnscaledDrawingCache;
    private UnsetPressedState mUnsetPressedState;
    protected int mUserPaddingBottom;
    int mUserPaddingEnd;
    protected int mUserPaddingLeft;
    boolean mUserPaddingRelative;
    protected int mUserPaddingRight;
    int mUserPaddingStart;
    private float mVerticalScrollFactor;
    private int mVerticalScrollbarPosition;
    int mViewFlags;
    int mWindowAttachCount;

    static  {
        int ai[] = new int[3];
        ai[0] = 0;
        ai[1] = 4;
        ai[2] = 8;
        VISIBILITY_FLAGS = ai;
        int ai1[] = new int[3];
        ai1[0] = 0;
        ai1[1] = 0x80000;
        ai1[2] = 0x100000;
        DRAWING_CACHE_QUALITY_FLAGS = ai1;
        int ai2[] = new int[20];
        ai2[0] = 0x101009d;
        ai2[1] = 1;
        ai2[2] = 0x10100a1;
        ai2[3] = 2;
        ai2[4] = 0x101009c;
        ai2[5] = 4;
        ai2[6] = 0x101009e;
        ai2[7] = 8;
        ai2[8] = 0x10100a7;
        ai2[9] = 16;
        ai2[10] = 0x10102fe;
        ai2[11] = 32;
        ai2[12] = 0x101031b;
        ai2[13] = 64;
        ai2[14] = 0x1010367;
        ai2[15] = 128;
        ai2[16] = 0x1010368;
        ai2[17] = 256;
        ai2[18] = 0x1010369;
        ai2[19] = 512;
        VIEW_STATE_IDS = ai2;
        if(VIEW_STATE_IDS.length / 2 != com.android.internal.R.styleable.ViewDrawableStates.length)
            throw new IllegalStateException("VIEW_STATE_IDs array length does not match ViewDrawableStates style array");
        int ai3[] = new int[VIEW_STATE_IDS.length];
        for(int i = 0; i < com.android.internal.R.styleable.ViewDrawableStates.length; i++) {
            int j1 = com.android.internal.R.styleable.ViewDrawableStates[i];
            for(int k1 = 0; k1 < VIEW_STATE_IDS.length; k1 += 2)
                if(VIEW_STATE_IDS[k1] == j1) {
                    ai3[i * 2] = j1;
                    ai3[1 + i * 2] = VIEW_STATE_IDS[k1 + 1];
                }

        }

        VIEW_STATE_SETS = new int[1 << VIEW_STATE_IDS.length / 2][];
        for(int j = 0; j < VIEW_STATE_SETS.length; j++) {
            int ai7[] = new int[1 + Integer.bitCount(j)];
            int k = 0;
            for(int l = 0; l < ai3.length; l += 2)
                if((j & ai3[l + 1]) != 0) {
                    int i1 = k + 1;
                    ai7[k] = ai3[l];
                    k = i1;
                }

            VIEW_STATE_SETS[j] = ai7;
        }

        EMPTY_STATE_SET = VIEW_STATE_SETS[0];
        WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[1];
        SELECTED_STATE_SET = VIEW_STATE_SETS[2];
        SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[3];
        FOCUSED_STATE_SET = VIEW_STATE_SETS[4];
        FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[5];
        FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[6];
        FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[7];
        ENABLED_STATE_SET = VIEW_STATE_SETS[8];
        ENABLED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[9];
        ENABLED_SELECTED_STATE_SET = VIEW_STATE_SETS[10];
        ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[11];
        ENABLED_FOCUSED_STATE_SET = VIEW_STATE_SETS[12];
        ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[13];
        ENABLED_FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[14];
        ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[15];
        PRESSED_STATE_SET = VIEW_STATE_SETS[16];
        PRESSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[17];
        PRESSED_SELECTED_STATE_SET = VIEW_STATE_SETS[18];
        PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[19];
        PRESSED_FOCUSED_STATE_SET = VIEW_STATE_SETS[20];
        PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[21];
        PRESSED_FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[22];
        PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[23];
        PRESSED_ENABLED_STATE_SET = VIEW_STATE_SETS[24];
        PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[25];
        PRESSED_ENABLED_SELECTED_STATE_SET = VIEW_STATE_SETS[26];
        PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[27];
        PRESSED_ENABLED_FOCUSED_STATE_SET = VIEW_STATE_SETS[28];
        PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[29];
        PRESSED_ENABLED_FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[30];
        PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[31];
        int ai4[] = new int[4];
        ai4[0] = 0;
        ai4[1] = 1;
        ai4[2] = 2;
        ai4[3] = 3;
        LAYOUT_DIRECTION_FLAGS = ai4;
        TEXT_DIRECTION_DEFAULT = 0;
        int ai5[] = new int[6];
        ai5[0] = 0;
        ai5[1] = 64;
        ai5[2] = 128;
        ai5[3] = 192;
        ai5[4] = 256;
        ai5[5] = 320;
        TEXT_DIRECTION_FLAGS = ai5;
        TEXT_ALIGNMENT_DEFAULT = 1;
        int ai6[] = new int[7];
        ai6[0] = 0;
        ai6[1] = 8192;
        ai6[2] = 16384;
        ai6[3] = 24576;
        ai6[4] = 32768;
        ai6[5] = 40960;
        ai6[6] = 49152;
        TEXT_ALIGNMENT_FLAGS = ai6;
    }


/*
    static boolean access$2002(View view, boolean flag) {
        view.mHasPerformedLongPress = flag;
        return flag;
    }

*/

}
