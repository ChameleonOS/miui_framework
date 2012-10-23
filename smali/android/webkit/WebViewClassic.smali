.class public final Landroid/webkit/WebViewClassic;
.super Ljava/lang/Object;
.source "WebViewClassic.java"

# interfaces
.implements Landroid/webkit/WebViewProvider;
.implements Landroid/webkit/WebViewProvider$ScrollDelegate;
.implements Landroid/webkit/WebViewProvider$ViewDelegate;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/webkit/WebViewClassic$InvokeListBox;,
        Landroid/webkit/WebViewClassic$PageSwapDelegate;,
        Landroid/webkit/WebViewClassic$FocusTransitionDrawable;,
        Landroid/webkit/WebViewClassic$PrivateHandler;,
        Landroid/webkit/WebViewClassic$RequestFormData;,
        Landroid/webkit/WebViewClassic$SelectionHandleAlpha;,
        Landroid/webkit/WebViewClassic$ViewSizeData;,
        Landroid/webkit/WebViewClassic$SaveWebArchiveMessage;,
        Landroid/webkit/WebViewClassic$DestroyNativeRunnable;,
        Landroid/webkit/WebViewClassic$TitleBarDelegate;,
        Landroid/webkit/WebViewClassic$PackageListener;,
        Landroid/webkit/WebViewClassic$ProxyReceiver;,
        Landroid/webkit/WebViewClassic$TrustStorageListener;,
        Landroid/webkit/WebViewClassic$Factory;,
        Landroid/webkit/WebViewClassic$FocusNodeHref;,
        Landroid/webkit/WebViewClassic$OnTrimMemoryListener;,
        Landroid/webkit/WebViewClassic$PastePopupWindow;,
        Landroid/webkit/WebViewClassic$WebViewInputConnection;
    }
.end annotation


# static fields
.field private static final ANGLE_HORIZ:F = 0.0f

.field private static final ANGLE_VERT:F = 2.0f

.field static final AUTOFILL_COMPLETE:I = 0x86

.field static final AUTOFILL_FORM:I = 0x94

.field private static final AUTO_REDRAW_HACK:Z = false

.field private static final CARET_HANDLE_STAMINA_MS:J = 0xbb8L

.field static final CENTER_FIT_RECT:I = 0x7f

.field static final CLEAR_CARET_HANDLE:I = 0x90

.field static final CLEAR_TEXT_ENTRY:I = 0x6f

.field static final COPY_TO_CLIPBOARD:I = 0x8d

.field private static final DEBUG_TOUCH_HIGHLIGHT:Z = true

.field static final DEFAULT_VIEWPORT_WIDTH:I = 0x3d4

.field private static final DRAG_HELD_MOTIONLESS:I = 0x8

.field private static final DRAG_LAYER_FINGER_DISTANCE:I = 0x4e20

.field private static final DRAW_EXTRAS_CURSOR_RING:I = 0x2

.field private static final DRAW_EXTRAS_NONE:I = 0x0

.field private static final DRAW_EXTRAS_SELECTION:I = 0x1

.field private static final EDIT_RECT_BUFFER:I = 0xa

.field static final EDIT_TEXT_SIZE_CHANGED:I = 0x96

.field static final ENTER_FULLSCREEN_VIDEO:I = 0x89

.field static final EXIT_FULLSCREEN_VIDEO:I = 0x8c

.field private static final FIRST_PACKAGE_MSG_ID:I = 0x65

.field private static final FIRST_PRIVATE_MSG_ID:I = 0x1

.field static final FOCUS_NODE_CHANGED:I = 0x93

.field static final HANDLE_ID_LEFT:I = 0x0

.field static final HANDLE_ID_RIGHT:I = 0x1

.field static final HIDE_FULLSCREEN:I = 0x79

.field static final HIGHLIGHT_COLOR:I = 0x6633b5e5

.field static final HIT_TEST_RESULT:I = 0x83

.field private static final HSLOPE_TO_BREAK_SNAP:F = 0.4f

.field private static final HSLOPE_TO_START_SNAP:F = 0.25f

.field static final HandlerPackageDebugString:[Ljava/lang/String; = null

.field static final HandlerPrivateDebugString:[Ljava/lang/String; = null

.field static final INIT_EDIT_FIELD:I = 0x8e

.field static final INVAL_RECT_MSG_ID:I = 0x75

.field static final KEY_PRESS:I = 0x91

.field private static final LAST_PACKAGE_MSG_ID:I = 0x83

.field private static final LAST_PRIVATE_MSG_ID:I = 0xb

.field static final LOGTAG:Ljava/lang/String; = "webview"

.field static final LONG_PRESS_CENTER:I = 0x72

.field private static final LONG_PRESS_TIMEOUT:I = 0x3e8

.field private static final MAX_DURATION:I = 0x2ee

.field private static final MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION:F = 0.2f

.field private static final MIN_FLING_TIME:I = 0xfa

.field private static final MMA_WEIGHT_N:F = 5.0f

.field private static final MOTIONLESS_FALSE:I = 0x0

.field private static final MOTIONLESS_IGNORE:I = 0x3

.field private static final MOTIONLESS_PENDING:I = 0x1

.field private static final MOTIONLESS_TIME:I = 0x64

.field private static final MOTIONLESS_TRUE:I = 0x2

.field private static final NEVER_REMEMBER_PASSWORD:I = 0x2

.field static final NEW_PICTURE_MSG_ID:I = 0x69

.field static final NO_LEFTEDGE:I = -0x1

.field private static final PAGE_SCROLL_OVERLAP:I = 0x18

.field private static final PREVENT_DEFAULT_TIMEOUT:I = 0xa

.field static final PREVENT_TOUCH_ID:I = 0x73

.field private static final RELEASE_SINGLE_TAP:I = 0x5

.field static final RELOCATE_AUTO_COMPLETE_POPUP:I = 0x92

.field private static final REMEMBER_PASSWORD:I = 0x1

.field static final REPLACE_TEXT:I = 0x8f

.field private static final REQUEST_FORM_DATA:I = 0x6

.field static final REQUEST_KEYBOARD:I = 0x76

.field static final SAVE_WEBARCHIVE_FINISHED:I = 0x84

.field public static final SCHEME_GEO:Ljava/lang/String; = "geo:0,0?q="

.field public static final SCHEME_MAILTO:Ljava/lang/String; = "mailto:"

.field public static final SCHEME_TEL:Ljava/lang/String; = "tel:"

.field static final SCREEN_ON:I = 0x88

.field private static final SCROLLBAR_ALWAYSOFF:I = 0x1

.field private static final SCROLLBAR_ALWAYSON:I = 0x2

.field private static final SCROLLBAR_AUTO:I = 0x0

.field private static final SCROLL_BITS:I = 0x6

.field static final SCROLL_EDIT_TEXT:I = 0x95

.field private static final SCROLL_SELECT_TEXT:I = 0xb

.field static final SCROLL_TO_MSG_ID:I = 0x65

.field static final SELECTION_STRING_CHANGED:I = 0x82

.field private static final SELECT_CURSOR_OFFSET:I = 0x10

.field private static final SELECT_SCROLL:I = 0x5

.field private static final SELECT_SCROLL_INTERVAL:J = 0x10L

.field static final SET_AUTOFILLABLE:I = 0x85

.field static final SET_SCROLLBAR_MODES:I = 0x81

.field static final SHOW_CARET_HANDLE:I = 0x97

.field static final SHOW_FULLSCREEN:I = 0x78

.field static final SHOW_MAGNIFIER:I = 0x1388
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation
.end field

.field static final SHOW_RECT_MSG_ID:I = 0x71

.field private static final SNAP_LOCK:I = 0x1

.field private static final SNAP_NONE:I = 0x0

.field private static final SNAP_X:I = 0x2

.field private static final SNAP_Y:I = 0x4

.field private static final STD_SPEED:I = 0x1e0

.field static final SWITCH_READ_MODE:I = 0x1389
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation
.end field

.field private static final SWITCH_TO_LONGPRESS:I = 0x4

.field private static final SWITCH_TO_SHORTPRESS:I = 0x3

.field static final TAKE_FOCUS:I = 0x6e

.field private static final TAP_TIMEOUT:I = 0x12c

.field private static final TEXT_SCROLL_FIRST_SCROLL_MS:J = 0x10L

.field private static final TEXT_SCROLL_RATE:F = 0.01f

.field private static final TOUCH_DONE_MODE:I = 0x7

.field private static final TOUCH_DOUBLE_TAP_MODE:I = 0x6

.field private static final TOUCH_DRAG_LAYER_MODE:I = 0x9

.field private static final TOUCH_DRAG_MODE:I = 0x3

.field private static final TOUCH_DRAG_START_MODE:I = 0x2

.field private static final TOUCH_DRAG_TEXT_MODE:I = 0xa

.field private static final TOUCH_HIGHLIGHT_ELAPSE_TIME:I = 0x7d0

.field private static final TOUCH_INIT_MODE:I = 0x1

.field private static final TOUCH_PINCH_DRAG:I = 0x8

.field private static final TOUCH_SENT_INTERVAL:I = 0x0

.field private static final TOUCH_SHORTPRESS_MODE:I = 0x5

.field private static final TOUCH_SHORTPRESS_START_MODE:I = 0x4

.field private static final TRACKBALL_KEY_TIMEOUT:I = 0x3e8

.field private static final TRACKBALL_MOVE_COUNT:I = 0xa

.field private static final TRACKBALL_MULTIPLIER:I = 0x3

.field private static final TRACKBALL_SCALE:I = 0x190

.field private static final TRACKBALL_SCROLL_COUNT:I = 0x5

.field private static final TRACKBALL_TIMEOUT:I = 0xc8

.field private static final TRACKBALL_WAIT:I = 0x64

.field static final UPDATE_CONTENT_BOUNDS:I = 0x98

.field static final UPDATE_MATCH_COUNT:I = 0x7e

.field static final UPDATE_TEXTFIELD_TEXT_MSG_ID:I = 0x6c

.field static final UPDATE_TEXT_SELECTION_MSG_ID:I = 0x70

.field static final UPDATE_ZOOM_DENSITY:I = 0x8b

.field static final UPDATE_ZOOM_RANGE:I = 0x6d

.field private static final VSLOPE_TO_BREAK_SNAP:F = 0.95f

.field private static final VSLOPE_TO_START_SNAP:F = 1.25f

.field static final WEBCORE_INITIALIZED_MSG_ID:I = 0x6b

.field static final WEBCORE_NEED_TOUCH_EVENTS:I = 0x74

.field private static final ZOOM_BITS:I = 0x86

.field static mLogEvent:Z

.field private static mOverScrollBackground:Landroid/graphics/Paint;

.field private static mOverScrollBorder:Landroid/graphics/Paint;

.field private static sGoogleApps:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field static sMaxViewportWidth:I

.field private static sNotificationsEnabled:Z

.field private static sPackageInstallationReceiverAdded:Z

.field private static sProxyReceiver:Landroid/webkit/WebViewClassic$ProxyReceiver;

.field private static sTrustStorageListener:Landroid/webkit/WebViewClassic$TrustStorageListener;


# instance fields
.field private DRAG_LAYER_INVERSE_DENSITY_SQUARED:F

.field private mAccessibilityInjector:Landroid/webkit/AccessibilityInjector;

.field private mAfterStart:Ljava/lang/String;
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation
.end field

.field private mAutoCompletePopup:Landroid/webkit/AutoCompletePopup;

.field private mAutoFillData:Landroid/webkit/WebViewCore$AutoFillData;

.field private mAutoRedraw:Z

.field private mAutoScrollX:I

.field private mAutoScrollY:I

.field private mAverageAngle:F

.field mAverageSwapFps:D

.field private mBackgroundColor:I

.field mBatchedTextChanges:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/os/Message;",
            ">;"
        }
    .end annotation
.end field

.field private mBeforeStart:Ljava/lang/String;
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation
.end field

.field private mBlockWebkitViewMessages:Z

.field private mCachedOverlappingActionModeHeight:I

.field private mCallbackProxy:Landroid/webkit/CallbackProxy;

.field private mCertificate:Landroid/net/http/SslCertificate;

.field private mConfirmMove:Z

.field private mContentHeight:I

.field private mContentWidth:I

.field private final mContext:Landroid/content/Context;

.field private mCopyFloatPanel:Landroid/webkit/SelectionFloatPanel;
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation
.end field

.field private mCurrentScrollingLayerId:I

.field private mCurrentTouchInterval:I

.field private mDatabase:Landroid/webkit/WebViewDatabaseClassic;

.field private mDelaySetPicture:Landroid/webkit/WebViewCore$DrawData;

.field private mDoubleTapSlopSquare:I

.field private mDrawCursorRing:Z

.field private mDrawHistory:Z

.field mEditTextContent:Landroid/graphics/Rect;

.field mEditTextContentBounds:Landroid/graphics/Rect;

.field mEditTextLayerId:I

.field mEditTextScroller:Landroid/widget/Scroller;

.field private mFieldPointer:I

.field private mFindCallback:Landroid/webkit/FindActionModeCallback;

.field private mFindIsUp:Z

.field private mFindListener:Landroid/webkit/WebView$FindListener;

.field private mFindRequest:Landroid/webkit/WebViewCore$FindAllRequest;

.field private mFocusTransition:Landroid/webkit/WebViewClassic$FocusTransitionDrawable;

.field private mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

.field mFullScreenHolder:Landroid/webkit/PluginFullScreenHolder;

.field private mGlobalVisibleOffset:Landroid/graphics/Point;

.field private mGlobalVisibleRect:Landroid/graphics/Rect;

.field private mGotCenterDown:Z

.field private mHTML5VideoViewProxy:Landroid/webkit/HTML5VideoViewProxy;

.field private mHandleAlpha:Landroid/webkit/WebViewClassic$SelectionHandleAlpha;

.field private mHandleAlphaAnimator:Landroid/animation/ObjectAnimator;

.field private mHardwareAccelSkia:Z

.field mHeightCanMeasure:Z

.field private mHeldMotionless:I

.field private mHistoryHeight:I

.field private mHistoryPicture:Landroid/graphics/Picture;

.field private mHistoryWidth:I

.field private mHorizontalScrollBarMode:I

.field private mInOverScrollMode:Z

.field private mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

.field private mInitialScaleInPercent:I

.field mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

.field private mInputDispatcher:Landroid/webkit/WebViewInputDispatcher;

.field private final mInvScreenRect:Landroid/graphics/Rect;

.field private mIsActionUp:Z
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation
.end field

.field mIsBatchingTextChanges:Z

.field private mIsCaretSelection:Z

.field mIsEditingText:Z

.field private mIsPaused:Z

.field private mIsWebViewVisible:Z

.field private mKeysPressed:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field mLastActualHeightSent:I

.field private mLastCursorBounds:Landroid/graphics/Rect;

.field private mLastCursorTime:J

.field private mLastEditScroll:J

.field private mLastGlobalRect:Landroid/graphics/Rect;

.field mLastHeightSent:I

.field private mLastSentTouchTime:J

.field mLastSwapTime:J

.field private mLastTouchTime:J

.field private mLastTouchUpTime:J

.field private mLastTouchX:I

.field private mLastTouchY:I

.field private mLastVelX:F

.field private mLastVelY:F

.field private mLastVelocity:F

.field private mLastVisibleRectSent:Landroid/graphics/Rect;

.field mLastWidthSent:I

.field private mListBoxDialog:Landroid/app/AlertDialog;

.field private mListBoxMessage:Landroid/os/Message;

.field private mLoadedPicture:Landroid/webkit/WebViewCore$DrawData;

.field private mMapTrackballToArrowKeys:Z

.field private mMaxAutoScrollX:I

.field private mMaxAutoScrollY:I

.field private mMaximumFling:I

.field private mMenuLeft:I
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation
.end field

.field private mMenuTop:I
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation
.end field

.field private mMinAutoScrollX:I

.field private mMinAutoScrollY:I

.field private mNativeClass:I

.field private mNavSlop:I

.field private mOrientation:I

.field private mOverScrollGlow:Landroid/webkit/OverScrollGlow;

.field private mOverflingDistance:I

.field private mOverlayHorizontalScrollbar:Z

.field private mOverlayVerticalScrollbar:Z

.field private mOverscrollDistance:I

.field private mPasteWindow:Landroid/webkit/WebViewClassic$PastePopupWindow;

.field private mPictureListener:Landroid/webkit/WebView$PictureListener;

.field private mPictureUpdatePausedForFocusChange:Z

.field final mPrivateHandler:Landroid/os/Handler;

.field private mResumeMsg:Landroid/os/Message;

.field private final mScreenRect:Landroid/graphics/Rect;

.field private final mScrollFilter:Landroid/graphics/DrawFilter;

.field private mScrollOffset:Landroid/graphics/Point;

.field mScroller:Landroid/widget/OverScroller;

.field private mScrollingLayerBounds:Landroid/graphics/Rect;

.field private mScrollingLayerRect:Landroid/graphics/Rect;

.field private mSelectCursorLeft:Landroid/graphics/Point;

.field private mSelectCursorLeftLayerId:I

.field private mSelectCursorLeftTextQuad:Landroid/webkit/QuadF;

.field private mSelectCursorRight:Landroid/graphics/Point;

.field private mSelectCursorRightLayerId:I

.field private mSelectCursorRightTextQuad:Landroid/webkit/QuadF;

.field private mSelectDraggingCursor:Landroid/graphics/Point;

.field private mSelectDraggingOffset:Landroid/graphics/Point;

.field private mSelectDraggingTextQuad:Landroid/webkit/QuadF;

.field private mSelectHandleCenter:Landroid/graphics/drawable/Drawable;

.field private mSelectHandleCenterOffset:Landroid/graphics/Point;

.field private mSelectHandleLeft:Landroid/graphics/drawable/Drawable;

.field private mSelectHandleLeftOffset:Landroid/graphics/Point;

.field private mSelectHandleRight:Landroid/graphics/drawable/Drawable;

.field private mSelectHandleRightOffset:Landroid/graphics/Point;

.field private mSelectHighlight:Landroid/graphics/drawable/Drawable;
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation
.end field

.field private mSelectMagnifier:Landroid/graphics/drawable/Drawable;
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation
.end field

.field private mSelectX:I

.field private mSelectY:I

.field private mSelectingText:Z

.field private mSelectionStarted:Z

.field private mSendScrollEvent:Z

.field private mSentAutoScrollMessage:Z

.field private mShowTapHighlight:Z

.field private mShowTextSelectionExtra:Z

.field private mSnapPositive:Z

.field private mSnapScrollMode:I

.field private mStartTouchX:I

.field private mStartTouchY:I

.field private final mTempContentVisibleRect:Landroid/graphics/Rect;

.field private final mTempVisibleRect:Landroid/graphics/Rect;

.field private final mTempVisibleRectOffset:Landroid/graphics/Point;

.field private mTextGeneration:I

.field private mTouchCrossHairColor:Landroid/graphics/Paint;

.field private mTouchHighlightRegion:Landroid/graphics/Region;

.field private mTouchHighlightX:I

.field private mTouchHighlightY:I

.field private mTouchHightlightPaint:Landroid/graphics/Paint;

.field private mTouchInEditText:Z

.field private mTouchMode:I

.field private mTouchSlopSquare:I

.field private mTrackballDown:Z

.field private mTrackballFirstTime:J

.field private mTrackballLastTime:J

.field private mTrackballRemainsX:F

.field private mTrackballRemainsY:F

.field private mTrackballUpTime:J

.field private mTrackballXMove:I

.field private mTrackballYMove:I

.field mVelocityTracker:Landroid/view/VelocityTracker;

.field private mVerticalScrollBarMode:I

.field mViewManager:Landroid/webkit/ViewManager;

.field private final mVisibleContentRect:Landroid/graphics/RectF;

.field private mVisibleRect:Landroid/graphics/Rect;

.field private final mWebView:Landroid/webkit/WebView;

.field private mWebViewCore:Landroid/webkit/WebViewCore;

.field private final mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

.field mWidthCanMeasure:Z

.field private mWrapContent:Z

.field private final mZoomFilter:Landroid/graphics/DrawFilter;

.field private mZoomManager:Landroid/webkit/ZoomManager;


# direct methods
.method static constructor <clinit>()V
    .registers 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 1064
    const/16 v0, 0xb

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "REMEMBER_PASSWORD"

    aput-object v1, v0, v4

    const-string v1, "NEVER_REMEMBER_PASSWORD"

    aput-object v1, v0, v3

    const-string v1, "SWITCH_TO_SHORTPRESS"

    aput-object v1, v0, v5

    const-string v1, "SWITCH_TO_LONGPRESS"

    aput-object v1, v0, v6

    const-string v1, "RELEASE_SINGLE_TAP"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "REQUEST_FORM_DATA"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "RESUME_WEBCORE_PRIORITY"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "DRAG_HELD_MOTIONLESS"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, ""

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "PREVENT_DEFAULT_TIMEOUT"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "SCROLL_SELECT_TEXT"

    aput-object v2, v0, v1

    sput-object v0, Landroid/webkit/WebViewClassic;->HandlerPrivateDebugString:[Ljava/lang/String;

    .line 1078
    const/16 v0, 0x26

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "SCROLL_TO_MSG_ID"

    aput-object v1, v0, v4

    const-string v1, "102"

    aput-object v1, v0, v3

    const-string v1, "103"

    aput-object v1, v0, v5

    const-string v1, "104"

    aput-object v1, v0, v6

    const-string v1, "NEW_PICTURE_MSG_ID"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "UPDATE_TEXT_ENTRY_MSG_ID"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "WEBCORE_INITIALIZED_MSG_ID"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "UPDATE_TEXTFIELD_TEXT_MSG_ID"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "UPDATE_ZOOM_RANGE"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "UNHANDLED_NAV_KEY"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "CLEAR_TEXT_ENTRY"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "UPDATE_TEXT_SELECTION_MSG_ID"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "SHOW_RECT_MSG_ID"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "LONG_PRESS_CENTER"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "PREVENT_TOUCH_ID"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "WEBCORE_NEED_TOUCH_EVENTS"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "INVAL_RECT_MSG_ID"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "REQUEST_KEYBOARD"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string v2, "DO_MOTION_UP"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string v2, "SHOW_FULLSCREEN"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string v2, "HIDE_FULLSCREEN"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string v2, "DOM_FOCUS_CHANGED"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string v2, "REPLACE_BASE_CONTENT"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string v2, "RETURN_LABEL"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    const-string v2, "UPDATE_MATCH_COUNT"

    aput-object v2, v0, v1

    const/16 v1, 0x19

    const-string v2, "CENTER_FIT_RECT"

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    const-string v2, "REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID"

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    const-string v2, "SET_SCROLLBAR_MODES"

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    const-string v2, "SELECTION_STRING_CHANGED"

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    const-string v2, "SET_TOUCH_HIGHLIGHT_RECTS"

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    const-string v2, "SAVE_WEBARCHIVE_FINISHED"

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    const-string v2, "SET_AUTOFILLABLE"

    aput-object v2, v0, v1

    const/16 v1, 0x20

    const-string v2, "AUTOFILL_COMPLETE"

    aput-object v2, v0, v1

    const/16 v1, 0x21

    const-string v2, "SELECT_AT"

    aput-object v2, v0, v1

    const/16 v1, 0x22

    const-string v2, "SCREEN_ON"

    aput-object v2, v0, v1

    const/16 v1, 0x23

    const-string v2, "ENTER_FULLSCREEN_VIDEO"

    aput-object v2, v0, v1

    const/16 v1, 0x24

    const-string v2, "UPDATE_SELECTION"

    aput-object v2, v0, v1

    const/16 v1, 0x25

    const-string v2, "UPDATE_ZOOM_DENSITY"

    aput-object v2, v0, v1

    sput-object v0, Landroid/webkit/WebViewClassic;->HandlerPackageDebugString:[Ljava/lang/String;

    .line 1127
    const/16 v0, 0x3d4

    sput v0, Landroid/webkit/WebViewClassic;->sMaxViewportWidth:I

    .line 1173
    sput-boolean v3, Landroid/webkit/WebViewClassic;->mLogEvent:Z

    .line 1180
    sput-boolean v3, Landroid/webkit/WebViewClassic;->sNotificationsEnabled:Z

    .line 1572
    sput-boolean v4, Landroid/webkit/WebViewClassic;->sPackageInstallationReceiverAdded:Z

    .line 1581
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Landroid/webkit/WebViewClassic;->sGoogleApps:Ljava/util/Set;

    .line 1582
    sget-object v0, Landroid/webkit/WebViewClassic;->sGoogleApps:Ljava/util/Set;

    const-string v1, "com.google.android.youtube"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1583
    return-void
.end method

.method public constructor <init>(Landroid/webkit/WebView;Landroid/webkit/WebView$PrivateAccess;)V
    .registers 12
    .parameter "webView"
    .parameter "privateAccess"

    .prologue
    const/4 v8, -0x1

    const-wide/16 v6, 0x0

    const/4 v5, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 1231
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 690
    iput-object v5, p0, Landroid/webkit/WebViewClassic;->mListBoxDialog:Landroid/app/AlertDialog;

    .line 696
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mInvScreenRect:Landroid/graphics/Rect;

    .line 697
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mScreenRect:Landroid/graphics/Rect;

    .line 698
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mVisibleContentRect:Landroid/graphics/RectF;

    .line 699
    iput-boolean v4, p0, Landroid/webkit/WebViewClassic;->mIsWebViewVisible:Z

    .line 700
    iput-object v5, p0, Landroid/webkit/WebViewClassic;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    .line 704
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    .line 705
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mEditTextContent:Landroid/graphics/Rect;

    .line 707
    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mIsEditingText:Z

    .line 708
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mBatchedTextChanges:Ljava/util/ArrayList;

    .line 709
    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mIsBatchingTextChanges:Z

    .line 710
    iput-wide v6, p0, Landroid/webkit/WebViewClassic;->mLastEditScroll:J

    .line 767
    new-instance v0, Landroid/webkit/WebViewClassic$PrivateHandler;

    invoke-direct {v0, p0}, Landroid/webkit/WebViewClassic$PrivateHandler;-><init>(Landroid/webkit/WebViewClassic;)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    .line 818
    iput v3, p0, Landroid/webkit/WebViewClassic;->mCurrentTouchInterval:I

    .line 831
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    .line 842
    const/4 v0, 0x7

    iput v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    .line 859
    iput-boolean v4, p0, Landroid/webkit/WebViewClassic;->mDrawCursorRing:Z

    .line 915
    iput-boolean v4, p0, Landroid/webkit/WebViewClassic;->mOverlayHorizontalScrollbar:Z

    .line 916
    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mOverlayVerticalScrollbar:Z

    .line 929
    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mInOverScrollMode:Z

    .line 954
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    .line 956
    new-instance v0, Landroid/webkit/QuadF;

    invoke-direct {v0}, Landroid/webkit/QuadF;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeftTextQuad:Landroid/webkit/QuadF;

    .line 957
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRight:Landroid/graphics/Point;

    .line 959
    new-instance v0, Landroid/webkit/QuadF;

    invoke-direct {v0}, Landroid/webkit/QuadF;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRightTextQuad:Landroid/webkit/QuadF;

    .line 970
    new-instance v0, Landroid/graphics/Region;

    invoke-direct {v0}, Landroid/graphics/Region;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightRegion:Landroid/graphics/Region;

    .line 972
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mTouchHightlightPaint:Landroid/graphics/Paint;

    .line 986
    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mBlockWebkitViewMessages:Z

    .line 989
    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mHardwareAccelSkia:Z

    .line 1130
    iput v3, p0, Landroid/webkit/WebViewClassic;->mInitialScaleInPercent:I

    .line 1134
    iput-boolean v4, p0, Landroid/webkit/WebViewClassic;->mSendScrollEvent:Z

    .line 1136
    iput v3, p0, Landroid/webkit/WebViewClassic;->mSnapScrollMode:I

    .line 1153
    iput v3, p0, Landroid/webkit/WebViewClassic;->mHorizontalScrollBarMode:I

    .line 1154
    iput v3, p0, Landroid/webkit/WebViewClassic;->mVerticalScrollBarMode:I

    .line 1176
    iput-wide v6, p0, Landroid/webkit/WebViewClassic;->mLastTouchUpTime:J

    .line 1195
    iput v8, p0, Landroid/webkit/WebViewClassic;->mBackgroundColor:I

    .line 1198
    iput v3, p0, Landroid/webkit/WebViewClassic;->mAutoScrollX:I

    .line 1199
    iput v3, p0, Landroid/webkit/WebViewClassic;->mAutoScrollY:I

    .line 1200
    iput v3, p0, Landroid/webkit/WebViewClassic;->mMinAutoScrollX:I

    .line 1201
    iput v3, p0, Landroid/webkit/WebViewClassic;->mMaxAutoScrollX:I

    .line 1202
    iput v3, p0, Landroid/webkit/WebViewClassic;->mMinAutoScrollY:I

    .line 1203
    iput v3, p0, Landroid/webkit/WebViewClassic;->mMaxAutoScrollY:I

    .line 1204
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mScrollingLayerBounds:Landroid/graphics/Rect;

    .line 1205
    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mSentAutoScrollMessage:Z

    .line 1211
    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mPictureUpdatePausedForFocusChange:Z

    .line 1990
    iput v8, p0, Landroid/webkit/WebViewClassic;->mCachedOverlappingActionModeHeight:I

    .line 3111
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mLastVisibleRectSent:Landroid/graphics/Rect;

    .line 3112
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mLastGlobalRect:Landroid/graphics/Rect;

    .line 3113
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mVisibleRect:Landroid/graphics/Rect;

    .line 3114
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mGlobalVisibleRect:Landroid/graphics/Rect;

    .line 3115
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mScrollOffset:Landroid/graphics/Point;

    .line 3149
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mGlobalVisibleOffset:Landroid/graphics/Point;

    .line 3169
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mTempContentVisibleRect:Landroid/graphics/Rect;

    .line 3692
    iput-object v5, p0, Landroid/webkit/WebViewClassic;->mFindRequest:Landroid/webkit/WebViewCore$FindAllRequest;

    .line 4438
    iput v3, p0, Landroid/webkit/WebViewClassic;->mOrientation:I

    .line 4509
    new-instance v0, Landroid/graphics/PaintFlagsDrawFilter;

    const/16 v1, 0x86

    const/16 v2, 0x40

    invoke-direct {v0, v1, v2}, Landroid/graphics/PaintFlagsDrawFilter;-><init>(II)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomFilter:Landroid/graphics/DrawFilter;

    .line 4512
    new-instance v0, Landroid/graphics/PaintFlagsDrawFilter;

    const/4 v1, 0x6

    invoke-direct {v0, v1, v3}, Landroid/graphics/PaintFlagsDrawFilter;-><init>(II)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mScrollFilter:Landroid/graphics/DrawFilter;

    .line 4615
    iput v8, p0, Landroid/webkit/WebViewClassic;->mMenuLeft:I

    .line 4617
    iput v8, p0, Landroid/webkit/WebViewClassic;->mMenuTop:I

    .line 4747
    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mDrawHistory:Z

    .line 4748
    iput-object v5, p0, Landroid/webkit/WebViewClassic;->mHistoryPicture:Landroid/graphics/Picture;

    .line 4749
    iput v3, p0, Landroid/webkit/WebViewClassic;->mHistoryWidth:I

    .line 4750
    iput v3, p0, Landroid/webkit/WebViewClassic;->mHistoryHeight:I

    .line 4990
    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mGotCenterDown:Z

    .line 5602
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mTempVisibleRectOffset:Landroid/graphics/Point;

    .line 5603
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mTempVisibleRect:Landroid/graphics/Rect;

    .line 6586
    iput-wide v6, p0, Landroid/webkit/WebViewClassic;->mTrackballFirstTime:J

    .line 6587
    iput-wide v6, p0, Landroid/webkit/WebViewClassic;->mTrackballLastTime:J

    .line 6588
    const/4 v0, 0x0

    iput v0, p0, Landroid/webkit/WebViewClassic;->mTrackballRemainsX:F

    .line 6589
    const/4 v0, 0x0

    iput v0, p0, Landroid/webkit/WebViewClassic;->mTrackballRemainsY:F

    .line 6590
    iput v3, p0, Landroid/webkit/WebViewClassic;->mTrackballXMove:I

    .line 6591
    iput v3, p0, Landroid/webkit/WebViewClassic;->mTrackballYMove:I

    .line 6592
    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    .line 6593
    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mShowTextSelectionExtra:Z

    .line 6594
    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mSelectionStarted:Z

    .line 6604
    iput v3, p0, Landroid/webkit/WebViewClassic;->mSelectX:I

    .line 6605
    iput v3, p0, Landroid/webkit/WebViewClassic;->mSelectY:I

    .line 6606
    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mTrackballDown:Z

    .line 6607
    iput-wide v6, p0, Landroid/webkit/WebViewClassic;->mTrackballUpTime:J

    .line 6608
    iput-wide v6, p0, Landroid/webkit/WebViewClassic;->mLastCursorTime:J

    .line 6610
    new-instance v0, Landroid/webkit/WebViewClassic$SelectionHandleAlpha;

    invoke-direct {v0, p0, v5}, Landroid/webkit/WebViewClassic$SelectionHandleAlpha;-><init>(Landroid/webkit/WebViewClassic;Landroid/webkit/WebViewClassic$1;)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mHandleAlpha:Landroid/webkit/WebViewClassic$SelectionHandleAlpha;

    .line 6611
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHandleAlpha:Landroid/webkit/WebViewClassic$SelectionHandleAlpha;

    const-string v1, "alpha"

    new-array v2, v4, [I

    aput v3, v2, v3

    invoke-static {v0, v1, v2}, Landroid/animation/ObjectAnimator;->ofInt(Ljava/lang/Object;Ljava/lang/String;[I)Landroid/animation/ObjectAnimator;

    move-result-object v0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mHandleAlphaAnimator:Landroid/animation/ObjectAnimator;

    .line 6617
    iput-boolean v4, p0, Landroid/webkit/WebViewClassic;->mMapTrackballToArrowKeys:Z

    .line 7861
    iput-object v5, p0, Landroid/webkit/WebViewClassic;->mFocusTransition:Landroid/webkit/WebViewClassic$FocusTransitionDrawable;

    .line 1232
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    .line 1233
    iput-object p2, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    .line 1234
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    .line 1235
    return-void
.end method

.method private abortAnimation()V
    .registers 2

    .prologue
    .line 3074
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v0}, Landroid/widget/OverScroller;->abortAnimation()V

    .line 3075
    const/4 v0, 0x0

    iput v0, p0, Landroid/webkit/WebViewClassic;->mLastVelocity:F

    .line 3076
    return-void
.end method

.method static synthetic access$000(Landroid/webkit/WebViewClassic;)Landroid/webkit/WebView;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    return-object v0
.end method

.method static synthetic access$100(Landroid/webkit/WebViewClassic;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget v0, p0, Landroid/webkit/WebViewClassic;->mFieldPointer:I

    return v0
.end method

.method static synthetic access$1000()V
    .registers 0

    .prologue
    .line 149
    invoke-static {}, Landroid/webkit/WebViewClassic;->handleCertTrustChanged()V

    return-void
.end method

.method static synthetic access$102(Landroid/webkit/WebViewClassic;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput p1, p0, Landroid/webkit/WebViewClassic;->mFieldPointer:I

    return p1
.end method

.method static synthetic access$1200(Landroid/content/Intent;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 149
    invoke-static {p0}, Landroid/webkit/WebViewClassic;->handleProxyBroadcast(Landroid/content/Intent;)V

    return-void
.end method

.method static synthetic access$1400()Ljava/util/Set;
    .registers 1

    .prologue
    .line 149
    sget-object v0, Landroid/webkit/WebViewClassic;->sGoogleApps:Ljava/util/Set;

    return-object v0
.end method

.method static synthetic access$1600(Landroid/webkit/WebViewClassic;)Landroid/webkit/WebViewCore;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    return-object v0
.end method

.method static synthetic access$1700(Landroid/webkit/WebViewClassic;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mResumeMsg:Landroid/os/Message;

    return-object v0
.end method

.method static synthetic access$1702(Landroid/webkit/WebViewClassic;Landroid/os/Message;)Landroid/os/Message;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mResumeMsg:Landroid/os/Message;

    return-object p1
.end method

.method static synthetic access$1800(I)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 149
    invoke-static {p0}, Landroid/webkit/WebViewClassic;->nativeDestroy(I)V

    return-void
.end method

.method static synthetic access$1900(Landroid/webkit/WebViewClassic;Landroid/graphics/Picture;Landroid/os/Bundle;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 149
    invoke-direct {p0, p1, p2}, Landroid/webkit/WebViewClassic;->restoreHistoryPictureFields(Landroid/graphics/Picture;Landroid/os/Bundle;)V

    return-void
.end method

.method static synthetic access$200(Landroid/webkit/WebViewClassic;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 149
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->beginTextBatch()V

    return-void
.end method

.method static synthetic access$2000(Landroid/webkit/WebViewClassic;)Landroid/webkit/WebViewCore$DrawData;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mLoadedPicture:Landroid/webkit/WebViewCore$DrawData;

    return-object v0
.end method

.method static synthetic access$2002(Landroid/webkit/WebViewClassic;Landroid/webkit/WebViewCore$DrawData;)Landroid/webkit/WebViewCore$DrawData;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mLoadedPicture:Landroid/webkit/WebViewCore$DrawData;

    return-object p1
.end method

.method static synthetic access$2100(Landroid/webkit/WebViewClassic;)Landroid/graphics/drawable/Drawable;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mSelectHandleLeft:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method static synthetic access$2200(Landroid/webkit/WebViewClassic;)Landroid/graphics/drawable/Drawable;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mSelectHandleRight:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method static synthetic access$2300(Landroid/webkit/WebViewClassic;)Landroid/webkit/WebViewCore$AutoFillData;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mAutoFillData:Landroid/webkit/WebViewCore$AutoFillData;

    return-object v0
.end method

.method static synthetic access$2302(Landroid/webkit/WebViewClassic;Landroid/webkit/WebViewCore$AutoFillData;)Landroid/webkit/WebViewCore$AutoFillData;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mAutoFillData:Landroid/webkit/WebViewCore$AutoFillData;

    return-object p1
.end method

.method static synthetic access$2400(Landroid/webkit/WebViewClassic;)Landroid/webkit/WebViewDatabaseClassic;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mDatabase:Landroid/webkit/WebViewDatabaseClassic;

    return-object v0
.end method

.method static synthetic access$2600(Landroid/webkit/WebViewClassic;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mBlockWebkitViewMessages:Z

    return v0
.end method

.method static synthetic access$2700(Landroid/webkit/WebViewClassic;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget v0, p0, Landroid/webkit/WebViewClassic;->mAutoScrollX:I

    return v0
.end method

.method static synthetic access$2800(Landroid/webkit/WebViewClassic;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget v0, p0, Landroid/webkit/WebViewClassic;->mAutoScrollY:I

    return v0
.end method

.method static synthetic access$2902(Landroid/webkit/WebViewClassic;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput-boolean p1, p0, Landroid/webkit/WebViewClassic;->mSentAutoScrollMessage:Z

    return p1
.end method

.method static synthetic access$300(Landroid/webkit/WebViewClassic;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 149
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->commitTextBatch()V

    return-void
.end method

.method static synthetic access$3000(Landroid/webkit/WebViewClassic;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget v0, p0, Landroid/webkit/WebViewClassic;->mCurrentScrollingLayerId:I

    return v0
.end method

.method static synthetic access$3100(Landroid/webkit/WebViewClassic;IIZI)Z
    .registers 6
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"
    .parameter "x4"

    .prologue
    .line 149
    invoke-direct {p0, p1, p2, p3, p4}, Landroid/webkit/WebViewClassic;->pinScrollBy(IIZI)Z

    move-result v0

    return v0
.end method

.method static synthetic access$3200(Landroid/webkit/WebViewClassic;)Landroid/graphics/Rect;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    return-object v0
.end method

.method static synthetic access$3300(Landroid/webkit/WebViewClassic;II)V
    .registers 3
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 149
    invoke-direct {p0, p1, p2}, Landroid/webkit/WebViewClassic;->scrollLayerTo(II)V

    return-void
.end method

.method static synthetic access$3400(Landroid/webkit/WebViewClassic;IIZ)V
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"

    .prologue
    .line 149
    invoke-direct {p0, p1, p2, p3}, Landroid/webkit/WebViewClassic;->contentScrollTo(IIZ)V

    return-void
.end method

.method static synthetic access$3500(Landroid/webkit/WebViewClassic;)Landroid/webkit/ZoomManager;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    return-object v0
.end method

.method static synthetic access$3600(Landroid/webkit/WebViewClassic;ILjava/lang/String;Z)V
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"

    .prologue
    .line 149
    invoke-direct {p0, p1, p2, p3}, Landroid/webkit/WebViewClassic;->nativeCreate(ILjava/lang/String;Z)V

    return-void
.end method

.method static synthetic access$3700(Landroid/webkit/WebViewClassic;)Landroid/webkit/WebViewCore$DrawData;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mDelaySetPicture:Landroid/webkit/WebViewCore$DrawData;

    return-object v0
.end method

.method static synthetic access$3702(Landroid/webkit/WebViewClassic;Landroid/webkit/WebViewCore$DrawData;)Landroid/webkit/WebViewCore$DrawData;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mDelaySetPicture:Landroid/webkit/WebViewCore$DrawData;

    return-object p1
.end method

.method static synthetic access$3800(Landroid/webkit/WebViewClassic;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsPaused:Z

    return v0
.end method

.method static synthetic access$3900(Landroid/webkit/WebViewClassic;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    return v0
.end method

.method static synthetic access$400(Landroid/webkit/WebViewClassic;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 149
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->hideSoftKeyboard()V

    return-void
.end method

.method static synthetic access$4000(IZ)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    invoke-static {p0, p1}, Landroid/webkit/WebViewClassic;->nativeSetPauseDrawing(IZ)V

    return-void
.end method

.method static synthetic access$4100(Landroid/webkit/WebViewClassic;)Landroid/webkit/WebViewInputDispatcher;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mInputDispatcher:Landroid/webkit/WebViewInputDispatcher;

    return-object v0
.end method

.method static synthetic access$4102(Landroid/webkit/WebViewClassic;Landroid/webkit/WebViewInputDispatcher;)Landroid/webkit/WebViewInputDispatcher;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mInputDispatcher:Landroid/webkit/WebViewInputDispatcher;

    return-object p1
.end method

.method static synthetic access$4200(Landroid/webkit/WebViewClassic;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTextGeneration:I

    return v0
.end method

.method static synthetic access$4202(Landroid/webkit/WebViewClassic;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput p1, p0, Landroid/webkit/WebViewClassic;->mTextGeneration:I

    return p1
.end method

.method static synthetic access$4300(Landroid/webkit/WebViewClassic;IILandroid/webkit/WebViewCore$TextSelectionData;)V
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"

    .prologue
    .line 149
    invoke-direct {p0, p1, p2, p3}, Landroid/webkit/WebViewClassic;->updateTextSelectionFromMessage(IILandroid/webkit/WebViewCore$TextSelectionData;)V

    return-void
.end method

.method static synthetic access$4400(Landroid/webkit/WebViewClassic;IIII)V
    .registers 5
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"
    .parameter "x4"

    .prologue
    .line 149
    invoke-direct {p0, p1, p2, p3, p4}, Landroid/webkit/WebViewClassic;->viewInvalidate(IIII)V

    return-void
.end method

.method static synthetic access$4502(Landroid/webkit/WebViewClassic;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput-boolean p1, p0, Landroid/webkit/WebViewClassic;->mGotCenterDown:Z

    return p1
.end method

.method static synthetic access$4602(Landroid/webkit/WebViewClassic;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput-boolean p1, p0, Landroid/webkit/WebViewClassic;->mTrackballDown:Z

    return p1
.end method

.method static synthetic access$4700(Landroid/webkit/WebViewClassic;Z)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->displaySoftKeyboard(Z)V

    return-void
.end method

.method static synthetic access$4802(Landroid/webkit/WebViewClassic;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput p1, p0, Landroid/webkit/WebViewClassic;->mHeldMotionless:I

    return p1
.end method

.method static synthetic access$4900(Landroid/webkit/WebViewClassic;)Landroid/webkit/HTML5VideoViewProxy;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHTML5VideoViewProxy:Landroid/webkit/HTML5VideoViewProxy;

    return-object v0
.end method

.method static synthetic access$500(Landroid/webkit/WebViewClassic;)Landroid/webkit/AutoCompletePopup;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mAutoCompletePopup:Landroid/webkit/AutoCompletePopup;

    return-object v0
.end method

.method static synthetic access$5000(Landroid/webkit/WebViewClassic;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->inFullScreenMode()Z

    move-result v0

    return v0
.end method

.method static synthetic access$5100(Landroid/webkit/WebViewClassic;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 149
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->dismissFullScreenMode()V

    return-void
.end method

.method static synthetic access$5200(Landroid/webkit/WebViewClassic;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getVisibleTitleHeightImpl()I

    move-result v0

    return v0
.end method

.method static synthetic access$5302(Landroid/webkit/WebViewClassic;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput p1, p0, Landroid/webkit/WebViewClassic;->mHorizontalScrollBarMode:I

    return p1
.end method

.method static synthetic access$5402(Landroid/webkit/WebViewClassic;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput p1, p0, Landroid/webkit/WebViewClassic;->mVerticalScrollBarMode:I

    return p1
.end method

.method static synthetic access$5500(Landroid/webkit/WebViewClassic;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->isAccessibilityEnabled()Z

    move-result v0

    return v0
.end method

.method static synthetic access$5600(Landroid/webkit/WebViewClassic;)Landroid/webkit/AccessibilityInjector;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getAccessibilityInjector()Landroid/webkit/AccessibilityInjector;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$5702(Landroid/webkit/WebViewClassic;Landroid/webkit/WebViewCore$WebKitHitTest;)Landroid/webkit/WebViewCore$WebKitHitTest;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    return-object p1
.end method

.method static synthetic access$5800(Landroid/webkit/WebViewClassic;Landroid/webkit/WebViewCore$WebKitHitTest;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->setTouchHighlightRects(Landroid/webkit/WebViewCore$WebKitHitTest;)V

    return-void
.end method

.method static synthetic access$5900(Landroid/webkit/WebViewClassic;Landroid/webkit/WebViewCore$WebKitHitTest;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->setHitTestResult(Landroid/webkit/WebViewCore$WebKitHitTest;)V

    return-void
.end method

.method static synthetic access$600(Landroid/webkit/WebViewClassic;)Landroid/content/Context;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$6000(Landroid/webkit/WebViewClassic;Ljava/lang/String;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->copyToClipboard(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$6102(Landroid/webkit/WebViewClassic;Ljava/lang/String;)Ljava/lang/String;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mBeforeStart:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$6202(Landroid/webkit/WebViewClassic;Ljava/lang/String;)Ljava/lang/String;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mAfterStart:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$6300(IILandroid/graphics/Rect;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 149
    invoke-static {p0, p1, p2}, Landroid/webkit/WebViewClassic;->nativeMapLayerRect(IILandroid/graphics/Rect;)V

    return-void
.end method

.method static synthetic access$6400(Landroid/webkit/WebViewClassic;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 149
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->relocateAutoCompletePopup()V

    return-void
.end method

.method static synthetic access$6500(Landroid/webkit/WebViewClassic;)Landroid/webkit/FindActionModeCallback;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mFindCallback:Landroid/webkit/FindActionModeCallback;

    return-object v0
.end method

.method static synthetic access$6600(Landroid/webkit/WebViewClassic;)Landroid/webkit/WebViewCore$FindAllRequest;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mFindRequest:Landroid/webkit/WebViewCore$FindAllRequest;

    return-object v0
.end method

.method static synthetic access$6700(Landroid/webkit/WebViewClassic;)Landroid/webkit/WebView$FindListener;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mFindListener:Landroid/webkit/WebView$FindListener;

    return-object v0
.end method

.method static synthetic access$6800(Landroid/webkit/WebViewClassic;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsCaretSelection:Z

    return v0
.end method

.method static synthetic access$6900(Landroid/webkit/WebViewClassic;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    return v0
.end method

.method static synthetic access$700(Landroid/webkit/WebViewClassic;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 149
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->ensureSelectionHandles()V

    return-void
.end method

.method static synthetic access$7000(Landroid/webkit/WebViewClassic;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->setupWebkitSelect()Z

    move-result v0

    return v0
.end method

.method static synthetic access$7100(Landroid/webkit/WebViewClassic;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 149
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->resetCaretTimer()V

    return-void
.end method

.method static synthetic access$7200(Landroid/webkit/WebViewClassic;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 149
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->showPasteWindow()V

    return-void
.end method

.method static synthetic access$7300(Landroid/webkit/WebViewClassic;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 149
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->scrollEditWithCursor()V

    return-void
.end method

.method static synthetic access$7400(Landroid/webkit/WebViewClassic;Landroid/view/MotionEvent;II)V
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"

    .prologue
    .line 149
    invoke-direct {p0, p1, p2, p3}, Landroid/webkit/WebViewClassic;->onHandleUiEvent(Landroid/view/MotionEvent;II)V

    return-void
.end method

.method static synthetic access$7500(Landroid/webkit/WebViewClassic;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mShowTapHighlight:Z

    return v0
.end method

.method static synthetic access$7502(Landroid/webkit/WebViewClassic;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput-boolean p1, p0, Landroid/webkit/WebViewClassic;->mShowTapHighlight:Z

    return p1
.end method

.method static synthetic access$7600(Landroid/webkit/WebViewClassic;)Landroid/graphics/Paint;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mTouchHightlightPaint:Landroid/graphics/Paint;

    return-object v0
.end method

.method static synthetic access$7700(Landroid/webkit/WebViewClassic;)Landroid/webkit/WebViewClassic$FocusTransitionDrawable;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mFocusTransition:Landroid/webkit/WebViewClassic$FocusTransitionDrawable;

    return-object v0
.end method

.method static synthetic access$7702(Landroid/webkit/WebViewClassic;Landroid/webkit/WebViewClassic$FocusTransitionDrawable;)Landroid/webkit/WebViewClassic$FocusTransitionDrawable;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mFocusTransition:Landroid/webkit/WebViewClassic$FocusTransitionDrawable;

    return-object p1
.end method

.method static synthetic access$800(Landroid/webkit/WebViewClassic;)Landroid/graphics/drawable/Drawable;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mSelectHandleCenter:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method static synthetic access$8100(Landroid/webkit/WebViewClassic;)Landroid/app/AlertDialog;
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mListBoxDialog:Landroid/app/AlertDialog;

    return-object v0
.end method

.method static synthetic access$8102(Landroid/webkit/WebViewClassic;Landroid/app/AlertDialog;)Landroid/app/AlertDialog;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mListBoxDialog:Landroid/app/AlertDialog;

    return-object p1
.end method

.method static synthetic access$8202(Landroid/webkit/WebViewClassic;Landroid/os/Message;)Landroid/os/Message;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 149
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mListBoxMessage:Landroid/os/Message;

    return-object p1
.end method

.method static synthetic access$900(I)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 149
    invoke-static {p0}, Landroid/webkit/WebViewClassic;->nativeOnTrimMemory(I)V

    return-void
.end method

.method private adjustSelectionCursors()V
    .registers 15

    .prologue
    const/4 v10, 0x1

    const/4 v11, 0x0

    .line 5288
    iget-boolean v12, p0, Landroid/webkit/WebViewClassic;->mIsCaretSelection:Z

    if-eqz v12, :cond_a

    .line 5289
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->syncSelectionCursors()V

    .line 5317
    :goto_9
    return-void

    .line 5293
    :cond_a
    iget-object v12, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    iget-object v13, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    if-ne v12, v13, :cond_65

    move v9, v10

    .line 5294
    .local v9, wasDraggingLeft:Z
    :goto_11
    iget-object v12, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    iget v6, v12, Landroid/graphics/Point;->x:I

    .line 5295
    .local v6, oldX:I
    iget-object v12, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    iget v7, v12, Landroid/graphics/Point;->y:I

    .line 5296
    .local v7, oldY:I
    iget-object v12, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v2, v12, Landroid/graphics/Point;->x:I

    .line 5297
    .local v2, oldLeftX:I
    iget-object v12, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v3, v12, Landroid/graphics/Point;->y:I

    .line 5298
    .local v3, oldLeftY:I
    iget-object v12, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRight:Landroid/graphics/Point;

    iget v4, v12, Landroid/graphics/Point;->x:I

    .line 5299
    .local v4, oldRightX:I
    iget-object v12, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRight:Landroid/graphics/Point;

    iget v5, v12, Landroid/graphics/Point;->y:I

    .line 5300
    .local v5, oldRightY:I
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->syncSelectionCursors()V

    .line 5302
    iget-object v12, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRight:Landroid/graphics/Point;

    iget v12, v12, Landroid/graphics/Point;->x:I

    if-ne v4, v12, :cond_38

    iget-object v12, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRight:Landroid/graphics/Point;

    iget v12, v12, Landroid/graphics/Point;->y:I

    if-eq v5, v12, :cond_67

    :cond_38
    move v8, v10

    .line 5304
    .local v8, rightChanged:Z
    :goto_39
    iget-object v12, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v12, v12, Landroid/graphics/Point;->x:I

    if-ne v2, v12, :cond_45

    iget-object v12, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v12, v12, Landroid/graphics/Point;->y:I

    if-eq v3, v12, :cond_69

    :cond_45
    move v1, v10

    .line 5306
    .local v1, leftChanged:Z
    :goto_46
    if-eqz v1, :cond_5f

    if-eqz v8, :cond_5f

    .line 5308
    if-nez v9, :cond_6b

    move v0, v10

    .line 5309
    .local v0, draggingLeft:Z
    :goto_4d
    if-eqz v0, :cond_6d

    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    :goto_51
    iput-object v10, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    .line 5311
    if-eqz v0, :cond_70

    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeftTextQuad:Landroid/webkit/QuadF;

    :goto_57
    iput-object v10, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingTextQuad:Landroid/webkit/QuadF;

    .line 5313
    if-eqz v0, :cond_73

    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mSelectHandleLeftOffset:Landroid/graphics/Point;

    :goto_5d
    iput-object v10, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingOffset:Landroid/graphics/Point;

    .line 5316
    .end local v0           #draggingLeft:Z
    :cond_5f
    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    invoke-virtual {v10, v6, v7}, Landroid/graphics/Point;->set(II)V

    goto :goto_9

    .end local v1           #leftChanged:Z
    .end local v2           #oldLeftX:I
    .end local v3           #oldLeftY:I
    .end local v4           #oldRightX:I
    .end local v5           #oldRightY:I
    .end local v6           #oldX:I
    .end local v7           #oldY:I
    .end local v8           #rightChanged:Z
    .end local v9           #wasDraggingLeft:Z
    :cond_65
    move v9, v11

    .line 5293
    goto :goto_11

    .restart local v2       #oldLeftX:I
    .restart local v3       #oldLeftY:I
    .restart local v4       #oldRightX:I
    .restart local v5       #oldRightY:I
    .restart local v6       #oldX:I
    .restart local v7       #oldY:I
    .restart local v9       #wasDraggingLeft:Z
    :cond_67
    move v8, v11

    .line 5302
    goto :goto_39

    .restart local v8       #rightChanged:Z
    :cond_69
    move v1, v11

    .line 5304
    goto :goto_46

    .restart local v1       #leftChanged:Z
    :cond_6b
    move v0, v11

    .line 5308
    goto :goto_4d

    .line 5309
    .restart local v0       #draggingLeft:Z
    :cond_6d
    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRight:Landroid/graphics/Point;

    goto :goto_51

    .line 5311
    :cond_70
    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRightTextQuad:Landroid/webkit/QuadF;

    goto :goto_57

    .line 5313
    :cond_73
    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mSelectHandleRightOffset:Landroid/graphics/Point;

    goto :goto_5d
.end method

.method private beginScrollEdit()V
    .registers 5

    .prologue
    .line 6328
    iget-wide v0, p0, Landroid/webkit/WebViewClassic;->mLastEditScroll:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_14

    .line 6329
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    const-wide/16 v2, 0x10

    sub-long/2addr v0, v2

    iput-wide v0, p0, Landroid/webkit/WebViewClassic;->mLastEditScroll:J

    .line 6331
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->scrollEditWithCursor()V

    .line 6333
    :cond_14
    return-void
.end method

.method private beginTextBatch()V
    .registers 2

    .prologue
    .line 8160
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsBatchingTextChanges:Z

    .line 8161
    return-void
.end method

.method private calcOurContentVisibleRect(Landroid/graphics/Rect;)V
    .registers 4
    .parameter "r"

    .prologue
    .line 3158
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->calcOurVisibleRect(Landroid/graphics/Rect;)V

    .line 3159
    iget v0, p1, Landroid/graphics/Rect;->left:I

    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->viewToContentX(I)I

    move-result v0

    iput v0, p1, Landroid/graphics/Rect;->left:I

    .line 3164
    iget v0, p1, Landroid/graphics/Rect;->top:I

    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getVisibleTitleHeightImpl()I

    move-result v1

    add-int/2addr v0, v1

    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->viewToContentY(I)I

    move-result v0

    iput v0, p1, Landroid/graphics/Rect;->top:I

    .line 3165
    iget v0, p1, Landroid/graphics/Rect;->right:I

    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->viewToContentX(I)I

    move-result v0

    iput v0, p1, Landroid/graphics/Rect;->right:I

    .line 3166
    iget v0, p1, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->viewToContentY(I)I

    move-result v0

    iput v0, p1, Landroid/graphics/Rect;->bottom:I

    .line 3167
    return-void
.end method

.method private calcOurContentVisibleRectF(Landroid/graphics/RectF;)V
    .registers 3
    .parameter "r"

    .prologue
    .line 3175
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mTempContentVisibleRect:Landroid/graphics/Rect;

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->calcOurVisibleRect(Landroid/graphics/Rect;)V

    .line 3176
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mTempContentVisibleRect:Landroid/graphics/Rect;

    invoke-direct {p0, p1, v0}, Landroid/webkit/WebViewClassic;->viewToContentVisibleRect(Landroid/graphics/RectF;Landroid/graphics/Rect;)V

    .line 3177
    return-void
.end method

.method private calcOurVisibleRect(Landroid/graphics/Rect;)V
    .registers 4
    .parameter "r"

    .prologue
    .line 3152
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mGlobalVisibleOffset:Landroid/graphics/Point;

    invoke-virtual {v0, p1, v1}, Landroid/webkit/WebView;->getGlobalVisibleRect(Landroid/graphics/Rect;Landroid/graphics/Point;)Z

    .line 3153
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mGlobalVisibleOffset:Landroid/graphics/Point;

    iget v0, v0, Landroid/graphics/Point;->x:I

    neg-int v0, v0

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mGlobalVisibleOffset:Landroid/graphics/Point;

    iget v1, v1, Landroid/graphics/Point;->y:I

    neg-int v1, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Rect;->offset(II)V

    .line 3154
    return-void
.end method

.method private calculateCaretTop()Landroid/graphics/Point;
    .registers 8

    .prologue
    .line 5263
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->x:I

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v4, v4, Landroid/graphics/Point;->y:I

    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeftTextQuad:Landroid/webkit/QuadF;

    iget-object v5, v5, Landroid/webkit/QuadF;->p4:Landroid/graphics/PointF;

    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeftTextQuad:Landroid/webkit/QuadF;

    iget-object v6, v6, Landroid/webkit/QuadF;->p3:Landroid/graphics/PointF;

    invoke-static {v3, v4, v5, v6}, Landroid/webkit/WebViewClassic;->scaleAlongSegment(IILandroid/graphics/PointF;Landroid/graphics/PointF;)F

    move-result v0

    .line 5265
    .local v0, scale:F
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeftTextQuad:Landroid/webkit/QuadF;

    iget-object v3, v3, Landroid/webkit/QuadF;->p1:Landroid/graphics/PointF;

    iget v3, v3, Landroid/graphics/PointF;->x:F

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeftTextQuad:Landroid/webkit/QuadF;

    iget-object v4, v4, Landroid/webkit/QuadF;->p2:Landroid/graphics/PointF;

    iget v4, v4, Landroid/graphics/PointF;->x:F

    invoke-static {v0, v3, v4}, Landroid/webkit/WebViewClassic;->scaleCoordinate(FFF)F

    move-result v3

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v1

    .line 5267
    .local v1, x:I
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeftTextQuad:Landroid/webkit/QuadF;

    iget-object v3, v3, Landroid/webkit/QuadF;->p1:Landroid/graphics/PointF;

    iget v3, v3, Landroid/graphics/PointF;->y:F

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeftTextQuad:Landroid/webkit/QuadF;

    iget-object v4, v4, Landroid/webkit/QuadF;->p2:Landroid/graphics/PointF;

    iget v4, v4, Landroid/graphics/PointF;->y:F

    invoke-static {v0, v3, v4}, Landroid/webkit/WebViewClassic;->scaleCoordinate(FFF)F

    move-result v3

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v2

    .line 5269
    .local v2, y:I
    new-instance v3, Landroid/graphics/Point;

    invoke-direct {v3, v1, v2}, Landroid/graphics/Point;-><init>(II)V

    return-object v3
.end method

.method private calculateDragAngle(II)F
    .registers 7
    .parameter "dx"
    .parameter "dy"

    .prologue
    .line 5950
    invoke-static {p1}, Ljava/lang/Math;->abs(I)I

    move-result p1

    .line 5951
    invoke-static {p2}, Ljava/lang/Math;->abs(I)I

    move-result p2

    .line 5952
    int-to-double v0, p2

    int-to-double v2, p1

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->atan2(DD)D

    move-result-wide v0

    double-to-float v0, v0

    return v0
.end method

.method private canTextScroll(II)Z
    .registers 11
    .parameter "directionX"
    .parameter "directionY"

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 7280
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getTextScrollX()I

    move-result v4

    .line 7281
    .local v4, scrollX:I
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getTextScrollY()I

    move-result v5

    .line 7282
    .local v5, scrollY:I
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getMaxTextScrollX()I

    move-result v2

    .line 7283
    .local v2, maxScrollX:I
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getMaxTextScrollY()I

    move-result v3

    .line 7284
    .local v3, maxScrollY:I
    if-lez p1, :cond_24

    if-ge v4, v2, :cond_22

    move v0, v7

    .line 7287
    .local v0, canScrollX:Z
    :goto_17
    if-lez p2, :cond_2c

    if-ge v5, v3, :cond_2a

    move v1, v7

    .line 7290
    .local v1, canScrollY:Z
    :goto_1c
    if-nez v0, :cond_20

    if-eqz v1, :cond_21

    :cond_20
    move v6, v7

    :cond_21
    return v6

    .end local v0           #canScrollX:Z
    .end local v1           #canScrollY:Z
    :cond_22
    move v0, v6

    .line 7284
    goto :goto_17

    :cond_24
    if-lez v4, :cond_28

    move v0, v7

    goto :goto_17

    :cond_28
    move v0, v6

    goto :goto_17

    .restart local v0       #canScrollX:Z
    :cond_2a
    move v1, v6

    .line 7287
    goto :goto_1c

    :cond_2c
    if-lez v5, :cond_30

    move v1, v7

    goto :goto_1c

    :cond_30
    move v1, v6

    goto :goto_1c
.end method

.method private cancelSelectDialog()V
    .registers 2

    .prologue
    .line 2093
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mListBoxDialog:Landroid/app/AlertDialog;

    if-eqz v0, :cond_c

    .line 2094
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mListBoxDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->cancel()V

    .line 2095
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mListBoxDialog:Landroid/app/AlertDialog;

    .line 2097
    :cond_c
    return-void
.end method

.method private cancelTouch()V
    .registers 4

    .prologue
    const/4 v2, 0x3

    .line 6511
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-eqz v0, :cond_d

    .line 6512
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v0}, Landroid/view/VelocityTracker;->recycle()V

    .line 6513
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 6516
    :cond_d
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    if-eq v0, v2, :cond_17

    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/16 v1, 0x9

    if-ne v0, v1, :cond_27

    :cond_17
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-nez v0, :cond_27

    .line 6518
    invoke-static {}, Landroid/webkit/WebViewCore;->resumePriority()V

    .line 6519
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-static {v0}, Landroid/webkit/WebViewCore;->resumeUpdatePicture(Landroid/webkit/WebViewCore;)V

    .line 6520
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->nativeSetIsScrolling(Z)V

    .line 6522
    :cond_27
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    invoke-virtual {v0, v2}, Landroid/os/Handler;->removeMessages(I)V

    .line 6523
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 6524
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 6525
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->removeTouchHighlight()V

    .line 6526
    const/4 v0, 0x2

    iput v0, p0, Landroid/webkit/WebViewClassic;->mHeldMotionless:I

    .line 6527
    const/4 v0, 0x7

    iput v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    .line 6528
    return-void
.end method

.method private clearActionModes()V
    .registers 2
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    .line 2075
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mFindCallback:Landroid/webkit/FindActionModeCallback;

    if-eqz v0, :cond_9

    .line 2076
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mFindCallback:Landroid/webkit/FindActionModeCallback;

    invoke-virtual {v0}, Landroid/webkit/FindActionModeCallback;->finish()V

    .line 2078
    :cond_9
    return-void
.end method

.method private clearHelpers()V
    .registers 1

    .prologue
    .line 2086
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->hideSoftKeyboard()V

    .line 2087
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->clearActionModes()V

    .line 2088
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->dismissFullScreenMode()V

    .line 2089
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->cancelSelectDialog()V

    .line 2090
    return-void
.end method

.method private commitTextBatch()V
    .registers 3

    .prologue
    .line 8164
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-eqz v0, :cond_b

    .line 8165
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mBatchedTextChanges:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessages(Ljava/util/ArrayList;)V

    .line 8167
    :cond_b
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mBatchedTextChanges:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 8168
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsBatchingTextChanges:Z

    .line 8169
    return-void
.end method

.method private static computeDuration(II)I
    .registers 6
    .parameter "dx"
    .parameter "dy"

    .prologue
    .line 3889
    invoke-static {p0}, Ljava/lang/Math;->abs(I)I

    move-result v2

    invoke-static {p1}, Ljava/lang/Math;->abs(I)I

    move-result v3

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 3890
    .local v0, distance:I
    mul-int/lit16 v2, v0, 0x3e8

    div-int/lit16 v1, v2, 0x1e0

    .line 3891
    .local v1, duration:I
    const/16 v2, 0x2ee

    invoke-static {v1, v2}, Ljava/lang/Math;->min(II)I

    move-result v2

    return v2
.end method

.method private computeRealHorizontalScrollRange()I
    .registers 3

    .prologue
    .line 3258
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mDrawHistory:Z

    if-eqz v0, :cond_7

    .line 3259
    iget v0, p0, Landroid/webkit/WebViewClassic;->mHistoryWidth:I

    .line 3262
    :goto_6
    return v0

    :cond_7
    iget v0, p0, Landroid/webkit/WebViewClassic;->mContentWidth:I

    int-to-float v0, v0

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v1}, Landroid/webkit/ZoomManager;->getScale()F

    move-result v1

    mul-float/2addr v0, v1

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-int v0, v0

    goto :goto_6
.end method

.method private computeRealVerticalScrollRange()I
    .registers 3

    .prologue
    .line 3288
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mDrawHistory:Z

    if-eqz v0, :cond_7

    .line 3289
    iget v0, p0, Landroid/webkit/WebViewClassic;->mHistoryHeight:I

    .line 3292
    :goto_6
    return v0

    :cond_7
    iget v0, p0, Landroid/webkit/WebViewClassic;->mContentHeight:I

    int-to-float v0, v0

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v1}, Landroid/webkit/ZoomManager;->getScale()F

    move-result v1

    mul-float/2addr v0, v1

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-int v0, v0

    goto :goto_6
.end method

.method private contentScrollTo(IIZ)V
    .registers 7
    .parameter "cx"
    .parameter "cy"
    .parameter "animate"

    .prologue
    .line 3989
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mDrawHistory:Z

    if-eqz v2, :cond_5

    .line 3997
    :goto_4
    return-void

    .line 3994
    :cond_5
    invoke-virtual {p0, p1}, Landroid/webkit/WebViewClassic;->contentToViewX(I)I

    move-result v0

    .line 3995
    .local v0, vx:I
    invoke-virtual {p0, p2}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v1

    .line 3996
    .local v1, vy:I
    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, p3, v2}, Landroid/webkit/WebViewClassic;->pinScrollTo(IIZI)Z

    goto :goto_4
.end method

.method private contentSizeChanged(Z)V
    .registers 4
    .parameter "updateLayout"

    .prologue
    .line 4007
    iget v0, p0, Landroid/webkit/WebViewClassic;->mContentWidth:I

    iget v1, p0, Landroid/webkit/WebViewClassic;->mContentHeight:I

    or-int/2addr v0, v1

    if-nez v0, :cond_8

    .line 4026
    :cond_7
    :goto_7
    return-void

    .line 4011
    :cond_8
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mHeightCanMeasure:Z

    if-eqz v0, :cond_22

    .line 4012
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getMeasuredHeight()I

    move-result v0

    iget v1, p0, Landroid/webkit/WebViewClassic;->mContentHeight:I

    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v1

    if-ne v0, v1, :cond_1c

    if-eqz p1, :cond_7

    .line 4014
    :cond_1c
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->requestLayout()V

    goto :goto_7

    .line 4016
    :cond_22
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mWidthCanMeasure:Z

    if-eqz v0, :cond_3c

    .line 4017
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getMeasuredWidth()I

    move-result v0

    iget v1, p0, Landroid/webkit/WebViewClassic;->mContentWidth:I

    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v1

    if-ne v0, v1, :cond_36

    if-eqz p1, :cond_7

    .line 4019
    :cond_36
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->requestLayout()V

    goto :goto_7

    .line 4024
    :cond_3c
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->sendViewSizeZoom(Z)Z

    goto :goto_7
.end method

.method private contentToViewRect(Landroid/graphics/Rect;)Landroid/graphics/Rect;
    .registers 7
    .parameter "x"

    .prologue
    .line 3026
    new-instance v0, Landroid/graphics/Rect;

    iget v1, p1, Landroid/graphics/Rect;->left:I

    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->contentToViewX(I)I

    move-result v1

    iget v2, p1, Landroid/graphics/Rect;->top:I

    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v2

    iget v3, p1, Landroid/graphics/Rect;->right:I

    invoke-virtual {p0, v3}, Landroid/webkit/WebViewClassic;->contentToViewX(I)I

    move-result v3

    iget v4, p1, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {p0, v4}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v4

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/Rect;-><init>(IIII)V

    return-object v0
.end method

.method private copyToClipboard(Ljava/lang/String;)V
    .registers 6
    .parameter "text"

    .prologue
    .line 8633
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    const-string v3, "clipboard"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/ClipboardManager;

    .line 8635
    .local v1, cm:Landroid/content/ClipboardManager;
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, p1}, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;

    move-result-object v0

    .line 8636
    .local v0, clip:Landroid/content/ClipData;
    invoke-virtual {v1, v0}, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V

    .line 8637
    return-void
.end method

.method private destroyJava()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 2123
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v1}, Landroid/webkit/CallbackProxy;->blockMessages()V

    .line 2124
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->clearHelpers()V

    .line 2125
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mListBoxDialog:Landroid/app/AlertDialog;

    if-eqz v1, :cond_14

    .line 2126
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mListBoxDialog:Landroid/app/AlertDialog;

    invoke-virtual {v1}, Landroid/app/AlertDialog;->dismiss()V

    .line 2127
    iput-object v2, p0, Landroid/webkit/WebViewClassic;->mListBoxDialog:Landroid/app/AlertDialog;

    .line 2129
    :cond_14
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-eqz v1, :cond_27

    .line 2131
    monitor-enter p0

    .line 2132
    :try_start_19
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    .line 2133
    .local v0, webViewCore:Landroid/webkit/WebViewCore;
    const/4 v1, 0x0

    iput-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    .line 2134
    invoke-virtual {v0}, Landroid/webkit/WebViewCore;->destroy()V

    .line 2135
    monitor-exit p0
    :try_end_22
    .catchall {:try_start_19 .. :try_end_22} :catchall_28

    .line 2137
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    invoke-virtual {v1, v2}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 2139
    .end local v0           #webViewCore:Landroid/webkit/WebViewCore;
    :cond_27
    return-void

    .line 2135
    :catchall_28
    move-exception v1

    :try_start_29
    monitor-exit p0
    :try_end_2a
    .catchall {:try_start_29 .. :try_end_2a} :catchall_28

    throw v1
.end method

.method private destroyNative()V
    .registers 4

    .prologue
    .line 2142
    iget v1, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v1, :cond_5

    .line 2151
    :goto_4
    return-void

    .line 2143
    :cond_5
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    .line 2144
    .local v0, nptr:I
    const/4 v1, 0x0

    iput v1, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    .line 2145
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    invoke-virtual {v2}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-virtual {v2}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v2

    if-ne v1, v2, :cond_1e

    .line 2147
    invoke-static {v0}, Landroid/webkit/WebViewClassic;->nativeDestroy(I)V

    goto :goto_4

    .line 2149
    :cond_1e
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    new-instance v2, Landroid/webkit/WebViewClassic$DestroyNativeRunnable;

    invoke-direct {v2, v0}, Landroid/webkit/WebViewClassic$DestroyNativeRunnable;-><init>(I)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_4
.end method

.method public static disablePlatformNotifications()V
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2187
    const-class v2, Landroid/webkit/WebViewClassic;

    monitor-enter v2

    .line 2188
    const/4 v1, 0x0

    :try_start_4
    sput-boolean v1, Landroid/webkit/WebViewClassic;->sNotificationsEnabled:Z

    .line 2189
    invoke-static {}, Landroid/webkit/JniUtil;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 2190
    .local v0, context:Landroid/content/Context;
    if-eqz v0, :cond_f

    .line 2191
    invoke-static {v0}, Landroid/webkit/WebViewClassic;->disableProxyListener(Landroid/content/Context;)V

    .line 2192
    :cond_f
    monitor-exit v2

    .line 2193
    return-void

    .line 2192
    :catchall_11
    move-exception v1

    monitor-exit v2
    :try_end_13
    .catchall {:try_start_4 .. :try_end_13} :catchall_11

    throw v1
.end method

.method private static declared-synchronized disableProxyListener(Landroid/content/Context;)V
    .registers 4
    .parameter "context"

    .prologue
    .line 1552
    const-class v1, Landroid/webkit/WebViewClassic;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/webkit/WebViewClassic;->sProxyReceiver:Landroid/webkit/WebViewClassic$ProxyReceiver;
    :try_end_5
    .catchall {:try_start_3 .. :try_end_5} :catchall_16

    if-nez v0, :cond_9

    .line 1557
    :goto_7
    monitor-exit v1

    return-void

    .line 1555
    :cond_9
    :try_start_9
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget-object v2, Landroid/webkit/WebViewClassic;->sProxyReceiver:Landroid/webkit/WebViewClassic$ProxyReceiver;

    invoke-virtual {v0, v2}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 1556
    const/4 v0, 0x0

    sput-object v0, Landroid/webkit/WebViewClassic;->sProxyReceiver:Landroid/webkit/WebViewClassic$ProxyReceiver;
    :try_end_15
    .catchall {:try_start_9 .. :try_end_15} :catchall_16

    goto :goto_7

    .line 1552
    :catchall_16
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private dismissFullScreenMode()V
    .registers 2

    .prologue
    .line 5826
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->inFullScreenMode()Z

    move-result v0

    if-eqz v0, :cond_11

    .line 5827
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mFullScreenHolder:Landroid/webkit/PluginFullScreenHolder;

    invoke-virtual {v0}, Landroid/webkit/PluginFullScreenHolder;->hide()V

    .line 5828
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mFullScreenHolder:Landroid/webkit/PluginFullScreenHolder;

    .line 5829
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 5831
    :cond_11
    return-void
.end method

.method private displaySoftKeyboard(Z)V
    .registers 8
    .parameter "isTextView"

    .prologue
    const/4 v2, 0x0

    .line 4829
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    const-string v4, "input_method"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 4833
    .local v0, imm:Landroid/view/inputmethod/InputMethodManager;
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v3}, Landroid/webkit/ZoomManager;->getScale()F

    move-result v3

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v4}, Landroid/webkit/ZoomManager;->getDefaultScale()F

    move-result v4

    cmpg-float v3, v3, v4

    if-gez v3, :cond_3a

    const/4 v1, 0x1

    .line 4834
    .local v1, zoom:Z
    :goto_1c
    if-eqz v1, :cond_34

    .line 4835
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    iget v4, p0, Landroid/webkit/WebViewClassic;->mLastTouchX:I

    int-to-float v4, v4

    iget v5, p0, Landroid/webkit/WebViewClassic;->mLastTouchY:I

    int-to-float v5, v5

    invoke-virtual {v3, v4, v5}, Landroid/webkit/ZoomManager;->setZoomCenter(FF)V

    .line 4836
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v4}, Landroid/webkit/ZoomManager;->getDefaultScale()F

    move-result v4

    invoke-virtual {v3, v4, v2}, Landroid/webkit/ZoomManager;->setZoomScale(FZ)V

    .line 4843
    :cond_34
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0, v3, v2}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 4844
    return-void

    .end local v1           #zoom:Z
    :cond_3a
    move v1, v2

    .line 4833
    goto :goto_1c
.end method

.method private distanceSquared(IILandroid/graphics/Point;)F
    .registers 8
    .parameter "x"
    .parameter "y"
    .parameter "p"

    .prologue
    .line 5320
    iget v2, p3, Landroid/graphics/Point;->x:I

    sub-int/2addr v2, p1

    int-to-float v0, v2

    .line 5321
    .local v0, dx:F
    iget v2, p3, Landroid/graphics/Point;->y:I

    sub-int/2addr v2, p2

    int-to-float v1, v2

    .line 5322
    .local v1, dy:F
    mul-float v2, v0, v0

    mul-float v3, v1, v1

    add-float/2addr v2, v3

    return v2
.end method

.method private doDrag(II)Z
    .registers 22
    .parameter "deltaX"
    .parameter "deltaY"

    .prologue
    .line 6412
    const/4 v12, 0x1

    .line 6413
    .local v12, allDrag:Z
    or-int v2, p1, p2

    if-eqz v2, :cond_a3

    .line 6414
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v5

    .line 6415
    .local v5, oldX:I
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v6

    .line 6416
    .local v6, oldY:I
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollX()I

    move-result v7

    .line 6417
    .local v7, rangeX:I
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollY()I

    move-result v8

    .line 6418
    .local v8, rangeY:I
    move/from16 v0, p1

    int-to-float v2, v0

    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v3}, Landroid/webkit/ZoomManager;->getInvScale()F

    move-result v3

    mul-float/2addr v2, v3

    float-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    double-to-int v13, v2

    .line 6419
    .local v13, contentX:I
    move/from16 v0, p2

    int-to-float v2, v0

    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v3}, Landroid/webkit/ZoomManager;->getInvScale()F

    move-result v3

    mul-float/2addr v2, v3

    float-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    double-to-int v14, v2

    .line 6422
    .local v14, contentY:I
    const/4 v2, 0x3

    move-object/from16 v0, p0

    iput v2, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    .line 6425
    move-object/from16 v0, p0

    iget-boolean v2, v0, Landroid/webkit/WebViewClassic;->mIsEditingText:Z

    if-eqz v2, :cond_ab

    move-object/from16 v0, p0

    iget-boolean v2, v0, Landroid/webkit/WebViewClassic;->mTouchInEditText:Z

    if-eqz v2, :cond_ab

    invoke-direct/range {p0 .. p2}, Landroid/webkit/WebViewClassic;->canTextScroll(II)Z

    move-result v2

    if-eqz v2, :cond_ab

    .line 6427
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getTextScrollX()I

    move-result v5

    .line 6428
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getMaxTextScrollX()I

    move-result v7

    .line 6429
    move/from16 p1, v13

    .line 6430
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getTextScrollY()I

    move-result v6

    .line 6431
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getMaxTextScrollY()I

    move-result v8

    .line 6432
    move/from16 p2, v14

    .line 6433
    const/16 v2, 0xa

    move-object/from16 v0, p0

    iput v2, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    .line 6434
    const/4 v12, 0x0

    .line 6460
    :cond_6b
    :goto_6b
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mOverScrollGlow:Landroid/webkit/OverScrollGlow;

    if-eqz v2, :cond_7c

    .line 6461
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mOverScrollGlow:Landroid/webkit/OverScrollGlow;

    move/from16 v0, p1

    move/from16 v1, p2

    invoke-virtual {v2, v0, v1}, Landroid/webkit/OverScrollGlow;->setOverScrollDeltas(II)V

    .line 6464
    :cond_7c
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    move-object/from16 v0, p0

    iget v9, v0, Landroid/webkit/WebViewClassic;->mOverscrollDistance:I

    move-object/from16 v0, p0

    iget v10, v0, Landroid/webkit/WebViewClassic;->mOverscrollDistance:I

    const/4 v11, 0x1

    move/from16 v3, p1

    move/from16 v4, p2

    invoke-virtual/range {v2 .. v11}, Landroid/webkit/WebView$PrivateAccess;->overScrollBy(IIIIIIIIZ)V

    .line 6467
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mOverScrollGlow:Landroid/webkit/OverScrollGlow;

    if-eqz v2, :cond_a3

    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mOverScrollGlow:Landroid/webkit/OverScrollGlow;

    invoke-virtual {v2}, Landroid/webkit/OverScrollGlow;->isAnimating()Z

    move-result v2

    if-eqz v2, :cond_a3

    .line 6468
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 6471
    .end local v5           #oldX:I
    .end local v6           #oldY:I
    .end local v7           #rangeX:I
    .end local v8           #rangeY:I
    .end local v13           #contentX:I
    .end local v14           #contentY:I
    :cond_a3
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v2}, Landroid/webkit/ZoomManager;->keepZoomPickerVisible()V

    .line 6472
    return v12

    .line 6435
    .restart local v5       #oldX:I
    .restart local v6       #oldY:I
    .restart local v7       #rangeX:I
    .restart local v8       #rangeY:I
    .restart local v13       #contentX:I
    .restart local v14       #contentY:I
    :cond_ab
    move-object/from16 v0, p0

    iget v2, v0, Landroid/webkit/WebViewClassic;->mCurrentScrollingLayerId:I

    if-eqz v2, :cond_6b

    .line 6438
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v15, v2, Landroid/graphics/Rect;->right:I

    .line 6439
    .local v15, maxX:I
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v0, v2, Landroid/graphics/Rect;->bottom:I

    move/from16 v16, v0

    .line 6440
    .local v16, maxY:I
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->left:I

    add-int/2addr v3, v13

    invoke-static {v3, v15}, Ljava/lang/Math;->min(II)I

    move-result v3

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v17

    .line 6442
    .local v17, resultX:I
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->top:I

    add-int/2addr v3, v14

    move/from16 v0, v16

    invoke-static {v3, v0}, Ljava/lang/Math;->min(II)I

    move-result v3

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v18

    .line 6445
    .local v18, resultY:I
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->left:I

    move/from16 v0, v17

    if-ne v0, v2, :cond_f9

    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->top:I

    move/from16 v0, v18

    if-ne v0, v2, :cond_f9

    or-int v2, v13, v14

    if-nez v2, :cond_6b

    .line 6449
    :cond_f9
    const/16 v2, 0x9

    move-object/from16 v0, p0

    iput v2, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    .line 6450
    move/from16 p1, v13

    .line 6451
    move/from16 p2, v14

    .line 6452
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v5, v2, Landroid/graphics/Rect;->left:I

    .line 6453
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v6, v2, Landroid/graphics/Rect;->top:I

    .line 6454
    move v7, v15

    .line 6455
    move/from16 v8, v16

    .line 6456
    const/4 v12, 0x0

    goto/16 :goto_6b
.end method

.method private doFling()V
    .registers 28

    .prologue
    .line 6855
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-nez v2, :cond_7

    .line 6958
    :cond_6
    :goto_6
    return-void

    .line 6858
    :cond_7
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollX()I

    move-result v6

    .line 6859
    .local v6, maxX:I
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollY()I

    move-result v8

    .line 6861
    .local v8, maxY:I
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    const/16 v5, 0x3e8

    move-object/from16 v0, p0

    iget v7, v0, Landroid/webkit/WebViewClassic;->mMaximumFling:I

    int-to-float v7, v7

    invoke-virtual {v2, v5, v7}, Landroid/view/VelocityTracker;->computeCurrentVelocity(IF)V

    .line 6862
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v2}, Landroid/view/VelocityTracker;->getXVelocity()F

    move-result v2

    float-to-int v0, v2

    move/from16 v25, v0

    .line 6863
    .local v25, vx:I
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v2}, Landroid/view/VelocityTracker;->getYVelocity()F

    move-result v2

    float-to-int v0, v2

    move/from16 v26, v0

    .line 6865
    .local v26, vy:I
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    .line 6866
    .local v3, scrollX:I
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v4

    .line 6867
    .local v4, scrollY:I
    move-object/from16 v0, p0

    iget v0, v0, Landroid/webkit/WebViewClassic;->mOverscrollDistance:I

    move/from16 v23, v0

    .line 6868
    .local v23, overscrollDistance:I
    move-object/from16 v0, p0

    iget v0, v0, Landroid/webkit/WebViewClassic;->mOverflingDistance:I

    move/from16 v19, v0

    .line 6871
    .local v19, overflingDistance:I
    move-object/from16 v0, p0

    iget v2, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/16 v5, 0x9

    if-ne v2, v5, :cond_a5

    .line 6872
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v3, v2, Landroid/graphics/Rect;->left:I

    .line 6873
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v4, v2, Landroid/graphics/Rect;->top:I

    .line 6874
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v6, v2, Landroid/graphics/Rect;->right:I

    .line 6875
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v8, v2, Landroid/graphics/Rect;->bottom:I

    .line 6877
    const/16 v19, 0x0

    move/from16 v23, v19

    .line 6887
    :cond_6b
    :goto_6b
    move-object/from16 v0, p0

    iget v2, v0, Landroid/webkit/WebViewClassic;->mSnapScrollMode:I

    if-eqz v2, :cond_7c

    .line 6888
    move-object/from16 v0, p0

    iget v2, v0, Landroid/webkit/WebViewClassic;->mSnapScrollMode:I

    and-int/lit8 v2, v2, 0x2

    const/4 v5, 0x2

    if-ne v2, v5, :cond_c2

    .line 6889
    const/16 v26, 0x0

    .line 6894
    :cond_7c
    :goto_7c
    if-nez v6, :cond_80

    if-eqz v26, :cond_84

    :cond_80
    if-nez v8, :cond_c5

    if-nez v25, :cond_c5

    .line 6895
    :cond_84
    invoke-static {}, Landroid/webkit/WebViewCore;->resumePriority()V

    .line 6896
    move-object/from16 v0, p0

    iget-boolean v2, v0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-nez v2, :cond_94

    .line 6897
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-static {v2}, Landroid/webkit/WebViewCore;->resumeUpdatePicture(Landroid/webkit/WebViewCore;)V

    .line 6899
    :cond_94
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    const/4 v5, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v2 .. v8}, Landroid/widget/OverScroller;->springBack(IIIIII)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 6900
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    goto/16 :goto_6

    .line 6878
    :cond_a5
    move-object/from16 v0, p0

    iget v2, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/16 v5, 0xa

    if-ne v2, v5, :cond_6b

    .line 6879
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getTextScrollX()I

    move-result v3

    .line 6880
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getTextScrollY()I

    move-result v4

    .line 6881
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getMaxTextScrollX()I

    move-result v6

    .line 6882
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getMaxTextScrollY()I

    move-result v8

    .line 6884
    const/16 v19, 0x0

    move/from16 v23, v19

    goto :goto_6b

    .line 6891
    :cond_c2
    const/16 v25, 0x0

    goto :goto_7c

    .line 6904
    :cond_c5
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v2}, Landroid/widget/OverScroller;->getCurrVelocity()F

    move-result v21

    .line 6905
    .local v21, currentVelocity:F
    move/from16 v0, v25

    int-to-double v9, v0

    move/from16 v0, v26

    int-to-double v11, v0

    invoke-static {v9, v10, v11, v12}, Ljava/lang/Math;->hypot(DD)D

    move-result-wide v9

    double-to-float v0, v9

    move/from16 v24, v0

    .line 6906
    .local v24, velocity:F
    move-object/from16 v0, p0

    iget v2, v0, Landroid/webkit/WebViewClassic;->mLastVelocity:F

    const/4 v5, 0x0

    cmpl-float v2, v2, v5

    if-lez v2, :cond_156

    const/4 v2, 0x0

    cmpl-float v2, v21, v2

    if-lez v2, :cond_156

    move-object/from16 v0, p0

    iget v2, v0, Landroid/webkit/WebViewClassic;->mLastVelocity:F

    const v5, 0x3e4ccccd

    mul-float/2addr v2, v5

    cmpl-float v2, v24, v2

    if-lez v2, :cond_156

    .line 6908
    move-object/from16 v0, p0

    iget v2, v0, Landroid/webkit/WebViewClassic;->mLastVelY:F

    float-to-double v9, v2

    move-object/from16 v0, p0

    iget v2, v0, Landroid/webkit/WebViewClassic;->mLastVelX:F

    float-to-double v11, v2

    invoke-static {v9, v10, v11, v12}, Ljava/lang/Math;->atan2(DD)D

    move-result-wide v9

    move/from16 v0, v26

    int-to-double v11, v0

    move/from16 v0, v25

    int-to-double v13, v0

    invoke-static {v11, v12, v13, v14}, Ljava/lang/Math;->atan2(DD)D

    move-result-wide v11

    sub-double/2addr v9, v11

    invoke-static {v9, v10}, Ljava/lang/Math;->abs(D)D

    move-result-wide v9

    double-to-float v0, v9

    move/from16 v22, v0

    .line 6910
    .local v22, deltaR:F
    const v20, 0x40c90fdb

    .line 6911
    .local v20, circle:F
    const v2, 0x40b4f4ab

    cmpl-float v2, v22, v2

    if-gtz v2, :cond_125

    const v2, 0x3f20d97c

    cmpg-float v2, v22, v2

    if-gez v2, :cond_156

    .line 6912
    :cond_125
    move/from16 v0, v25

    int-to-float v2, v0

    move-object/from16 v0, p0

    iget v5, v0, Landroid/webkit/WebViewClassic;->mLastVelX:F

    mul-float v5, v5, v21

    move-object/from16 v0, p0

    iget v7, v0, Landroid/webkit/WebViewClassic;->mLastVelocity:F

    div-float/2addr v5, v7

    add-float/2addr v2, v5

    float-to-int v0, v2

    move/from16 v25, v0

    .line 6913
    move/from16 v0, v26

    int-to-float v2, v0

    move-object/from16 v0, p0

    iget v5, v0, Landroid/webkit/WebViewClassic;->mLastVelY:F

    mul-float v5, v5, v21

    move-object/from16 v0, p0

    iget v7, v0, Landroid/webkit/WebViewClassic;->mLastVelocity:F

    div-float/2addr v5, v7

    add-float/2addr v2, v5

    float-to-int v0, v2

    move/from16 v26, v0

    .line 6914
    move/from16 v0, v25

    int-to-double v9, v0

    move/from16 v0, v26

    int-to-double v11, v0

    invoke-static {v9, v10, v11, v12}, Ljava/lang/Math;->hypot(DD)D

    move-result-wide v9

    double-to-float v0, v9

    move/from16 v24, v0

    .line 6931
    .end local v20           #circle:F
    .end local v22           #deltaR:F
    :cond_156
    if-eqz v3, :cond_15a

    if-ne v3, v6, :cond_166

    :cond_15a
    invoke-static/range {v25 .. v25}, Ljava/lang/Math;->abs(I)I

    move-result v2

    invoke-static/range {v26 .. v26}, Ljava/lang/Math;->abs(I)I

    move-result v5

    if-ge v2, v5, :cond_166

    .line 6932
    const/16 v25, 0x0

    .line 6934
    :cond_166
    if-eqz v4, :cond_16a

    if-ne v4, v8, :cond_176

    :cond_16a
    invoke-static/range {v26 .. v26}, Ljava/lang/Math;->abs(I)I

    move-result v2

    invoke-static/range {v25 .. v25}, Ljava/lang/Math;->abs(I)I

    move-result v5

    if-ge v2, v5, :cond_176

    .line 6935
    const/16 v26, 0x0

    .line 6938
    :cond_176
    move/from16 v0, v23

    move/from16 v1, v19

    if-ge v0, v1, :cond_19a

    .line 6939
    if-lez v25, :cond_183

    move/from16 v0, v23

    neg-int v2, v0

    if-eq v3, v2, :cond_189

    :cond_183
    if-gez v25, :cond_18b

    add-int v2, v6, v23

    if-ne v3, v2, :cond_18b

    .line 6941
    :cond_189
    const/16 v25, 0x0

    .line 6943
    :cond_18b
    if-lez v26, :cond_192

    move/from16 v0, v23

    neg-int v2, v0

    if-eq v4, v2, :cond_198

    :cond_192
    if-gez v26, :cond_19a

    add-int v2, v8, v23

    if-ne v4, v2, :cond_19a

    .line 6945
    :cond_198
    const/16 v26, 0x0

    .line 6949
    :cond_19a
    move/from16 v0, v25

    int-to-float v2, v0

    move-object/from16 v0, p0

    iput v2, v0, Landroid/webkit/WebViewClassic;->mLastVelX:F

    .line 6950
    move/from16 v0, v26

    int-to-float v2, v0

    move-object/from16 v0, p0

    iput v2, v0, Landroid/webkit/WebViewClassic;->mLastVelY:F

    .line 6951
    move/from16 v0, v24

    move-object/from16 v1, p0

    iput v0, v1, Landroid/webkit/WebViewClassic;->mLastVelocity:F

    .line 6954
    move-object/from16 v0, p0

    iget-object v9, v0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    move/from16 v0, v25

    neg-int v12, v0

    move/from16 v0, v26

    neg-int v13, v0

    const/4 v14, 0x0

    const/16 v16, 0x0

    if-nez v6, :cond_1cc

    const/16 v18, 0x0

    :goto_1bf
    move v10, v3

    move v11, v4

    move v15, v6

    move/from16 v17, v8

    invoke-virtual/range {v9 .. v19}, Landroid/widget/OverScroller;->fling(IIIIIIIIII)V

    .line 6957
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    goto/16 :goto_6

    :cond_1cc
    move/from16 v18, v19

    .line 6954
    goto :goto_1bf
.end method

.method private doTrackball(JI)V
    .registers 29
    .parameter "time"
    .parameter "metaState"

    .prologue
    .line 6747
    move-object/from16 v0, p0

    iget-wide v5, v0, Landroid/webkit/WebViewClassic;->mTrackballLastTime:J

    move-object/from16 v0, p0

    iget-wide v7, v0, Landroid/webkit/WebViewClassic;->mTrackballFirstTime:J

    sub-long/2addr v5, v7

    long-to-int v12, v5

    .line 6748
    .local v12, elapsed:I
    if-nez v12, :cond_e

    .line 6749
    const/16 v12, 0xc8

    .line 6751
    :cond_e
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTrackballRemainsX:F

    const/high16 v5, 0x447a

    mul-float/2addr v3, v5

    int-to-float v5, v12

    div-float v22, v3, v5

    .line 6752
    .local v22, xRate:F
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTrackballRemainsY:F

    const/high16 v5, 0x447a

    mul-float/2addr v3, v5

    int-to-float v5, v12

    div-float v24, v3, v5

    .line 6753
    .local v24, yRate:F
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getViewWidth()I

    move-result v19

    .line 6754
    .local v19, viewWidth:I
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getViewHeight()I

    move-result v18

    .line 6755
    .local v18, viewHeight:I
    invoke-static/range {v22 .. v22}, Ljava/lang/Math;->abs(F)F

    move-result v9

    .line 6756
    .local v9, ax:F
    invoke-static/range {v24 .. v24}, Ljava/lang/Math;->abs(F)F

    move-result v10

    .line 6757
    .local v10, ay:F
    invoke-static {v9, v10}, Ljava/lang/Math;->max(FF)F

    move-result v15

    .line 6765
    .local v15, maxA:F
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mContentWidth:I

    sub-int v20, v3, v19

    .line 6766
    .local v20, width:I
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mContentHeight:I

    sub-int v13, v3, v18

    .line 6767
    .local v13, height:I
    if-gez v20, :cond_46

    const/16 v20, 0x0

    .line 6768
    :cond_46
    if-gez v13, :cond_49

    const/4 v13, 0x0

    .line 6769
    :cond_49
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTrackballRemainsX:F

    const/high16 v5, 0x4040

    mul-float/2addr v3, v5

    invoke-static {v3}, Ljava/lang/Math;->abs(F)F

    move-result v9

    .line 6770
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTrackballRemainsY:F

    const/high16 v5, 0x4040

    mul-float/2addr v3, v5

    invoke-static {v3}, Ljava/lang/Math;->abs(F)F

    move-result v10

    .line 6771
    invoke-static {v9, v10}, Ljava/lang/Math;->max(FF)F

    move-result v15

    .line 6772
    const/4 v3, 0x0

    float-to-int v5, v15

    invoke-static {v3, v5}, Ljava/lang/Math;->max(II)I

    move-result v11

    .line 6773
    .local v11, count:I
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v16

    .line 6774
    .local v16, oldScrollX:I
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v17

    .line 6775
    .local v17, oldScrollY:I
    if-lez v11, :cond_c3

    .line 6776
    cmpg-float v3, v9, v10

    if-gez v3, :cond_a1

    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTrackballRemainsY:F

    const/4 v5, 0x0

    cmpg-float v3, v3, v5

    if-gez v3, :cond_9e

    const/16 v4, 0x13

    .line 6780
    .local v4, selectKeyCode:I
    :goto_82
    const/16 v3, 0xa

    invoke-static {v11, v3}, Ljava/lang/Math;->min(II)I

    move-result v11

    .line 6787
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-eqz v3, :cond_ba

    .line 6788
    const/4 v14, 0x0

    .local v14, i:I
    :goto_8f
    if-ge v14, v11, :cond_b0

    .line 6789
    const/4 v7, 0x1

    move-object/from16 v3, p0

    move-wide/from16 v5, p1

    move/from16 v8, p3

    invoke-direct/range {v3 .. v8}, Landroid/webkit/WebViewClassic;->letPageHandleNavKey(IJZI)V

    .line 6788
    add-int/lit8 v14, v14, 0x1

    goto :goto_8f

    .line 6776
    .end local v4           #selectKeyCode:I
    .end local v14           #i:I
    :cond_9e
    const/16 v4, 0x14

    goto :goto_82

    :cond_a1
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTrackballRemainsX:F

    const/4 v5, 0x0

    cmpg-float v3, v3, v5

    if-gez v3, :cond_ad

    const/16 v4, 0x15

    goto :goto_82

    :cond_ad
    const/16 v4, 0x16

    goto :goto_82

    .line 6791
    .restart local v4       #selectKeyCode:I
    .restart local v14       #i:I
    :cond_b0
    const/4 v7, 0x0

    move-object/from16 v3, p0

    move-wide/from16 v5, p1

    move/from16 v8, p3

    invoke-direct/range {v3 .. v8}, Landroid/webkit/WebViewClassic;->letPageHandleNavKey(IJZI)V

    .line 6793
    .end local v14           #i:I
    :cond_ba
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mTrackballRemainsY:F

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mTrackballRemainsX:F

    .line 6795
    .end local v4           #selectKeyCode:I
    :cond_c3
    const/4 v3, 0x5

    if-lt v11, v3, :cond_10b

    .line 6796
    move-object/from16 v0, p0

    move/from16 v1, v22

    move/from16 v2, v20

    invoke-direct {v0, v1, v2}, Landroid/webkit/WebViewClassic;->scaleTrackballX(FI)I

    move-result v21

    .line 6797
    .local v21, xMove:I
    move-object/from16 v0, p0

    move/from16 v1, v24

    invoke-direct {v0, v1, v13}, Landroid/webkit/WebViewClassic;->scaleTrackballY(FI)I

    move-result v23

    .line 6806
    .local v23, yMove:I
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    sub-int v3, v3, v16

    invoke-static {v3}, Ljava/lang/Math;->abs(I)I

    move-result v3

    invoke-static/range {v21 .. v21}, Ljava/lang/Math;->abs(I)I

    move-result v5

    if-le v3, v5, :cond_ea

    .line 6807
    const/16 v21, 0x0

    .line 6809
    :cond_ea
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v3

    sub-int v3, v3, v17

    invoke-static {v3}, Ljava/lang/Math;->abs(I)I

    move-result v3

    invoke-static/range {v23 .. v23}, Ljava/lang/Math;->abs(I)I

    move-result v5

    if-le v3, v5, :cond_fc

    .line 6810
    const/16 v23, 0x0

    .line 6812
    :cond_fc
    if-nez v21, :cond_100

    if-eqz v23, :cond_10b

    .line 6813
    :cond_100
    const/4 v3, 0x1

    const/4 v5, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v21

    move/from16 v2, v23

    invoke-direct {v0, v1, v2, v3, v5}, Landroid/webkit/WebViewClassic;->pinScrollBy(IIZI)Z

    .line 6816
    .end local v21           #xMove:I
    .end local v23           #yMove:I
    :cond_10b
    return-void
.end method

.method private drawContent(Landroid/graphics/Canvas;)V
    .registers 15
    .parameter "canvas"

    .prologue
    .line 4173
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mDrawHistory:Z

    if-eqz v0, :cond_19

    .line 4174
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->getScale()F

    move-result v0

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v1}, Landroid/webkit/ZoomManager;->getScale()F

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->scale(FF)V

    .line 4175
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHistoryPicture:Landroid/graphics/Picture;

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->drawPicture(Landroid/graphics/Picture;)V

    .line 4256
    :cond_18
    :goto_18
    return-void

    .line 4178
    :cond_19
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-eqz v0, :cond_18

    .line 4180
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->isFixedLengthAnimationInProgress()Z

    move-result v9

    .line 4181
    .local v9, animateZoom:Z
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v0}, Landroid/widget/OverScroller;->isFinished()Z

    move-result v0

    if-eqz v0, :cond_2f

    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-eqz v0, :cond_ef

    :cond_2f
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_39

    iget v0, p0, Landroid/webkit/WebViewClassic;->mHeldMotionless:I

    const/4 v1, 0x2

    if-eq v0, v1, :cond_ef

    :cond_39
    const/4 v8, 0x1

    .line 4185
    .local v8, animateScroll:Z
    :goto_3a
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_64

    .line 4186
    iget v0, p0, Landroid/webkit/WebViewClassic;->mHeldMotionless:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_4e

    .line 4187
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 4188
    const/4 v0, 0x0

    iput v0, p0, Landroid/webkit/WebViewClassic;->mHeldMotionless:I

    .line 4190
    :cond_4e
    iget v0, p0, Landroid/webkit/WebViewClassic;->mHeldMotionless:I

    if-nez v0, :cond_64

    .line 4191
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/16 v4, 0x8

    invoke-virtual {v1, v4}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    const-wide/16 v4, 0x64

    invoke-virtual {v0, v1, v4, v5}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 4193
    const/4 v0, 0x1

    iput v0, p0, Landroid/webkit/WebViewClassic;->mHeldMotionless:I

    .line 4196
    :cond_64
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v12

    .line 4197
    .local v12, saveCount:I
    if-eqz v9, :cond_f2

    .line 4198
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0, p1}, Landroid/webkit/ZoomManager;->animateZoom(Landroid/graphics/Canvas;)V

    .line 4203
    :cond_6f
    :goto_6f
    const/4 v7, 0x0

    .line 4206
    .local v7, UIAnimationsRunning:Z
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-eqz v0, :cond_8d

    invoke-virtual {p1}, Landroid/graphics/Canvas;->isHardwareAccelerated()Z

    move-result v0

    if-nez v0, :cond_8d

    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->nativeEvaluateLayersAnimations(I)Z

    move-result v0

    if-eqz v0, :cond_8d

    .line 4208
    const/4 v7, 0x1

    .line 4213
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0xc4

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 4214
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 4218
    :cond_8d
    const/4 v6, 0x0

    .line 4219
    .local v6, extras:I
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mFindIsUp:Z

    if-nez v0, :cond_97

    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mShowTextSelectionExtra:Z

    if-eqz v0, :cond_97

    .line 4220
    const/4 v6, 0x1

    .line 4223
    :cond_97
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mVisibleContentRect:Landroid/graphics/RectF;

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->calcOurContentVisibleRectF(Landroid/graphics/RectF;)V

    .line 4224
    invoke-virtual {p1}, Landroid/graphics/Canvas;->isHardwareAccelerated()Z

    move-result v0

    if-eqz v0, :cond_10d

    .line 4225
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsWebViewVisible:Z

    if-eqz v0, :cond_109

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mInvScreenRect:Landroid/graphics/Rect;

    .line 4226
    .local v2, invScreenRect:Landroid/graphics/Rect;
    :goto_a8
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsWebViewVisible:Z

    if-eqz v0, :cond_10b

    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mScreenRect:Landroid/graphics/Rect;

    .line 4228
    .local v3, screenRect:Landroid/graphics/Rect;
    :goto_ae
    iget v1, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mVisibleContentRect:Landroid/graphics/RectF;

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScale()F

    move-result v5

    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Landroid/webkit/WebViewClassic;->nativeCreateDrawGLFunction(ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/RectF;FI)I

    move-result v11

    .local v11, functor:I
    move-object v0, p1

    .line 4230
    check-cast v0, Landroid/view/HardwareCanvas;

    invoke-virtual {v0, v11}, Landroid/view/HardwareCanvas;->callDrawGLFunction(I)I

    .line 4231
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mHardwareAccelSkia:Z

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebSettingsClassic;->getHardwareAccelSkiaEnabled()Z

    move-result v1

    if-eq v0, v1, :cond_dc

    .line 4232
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebSettingsClassic;->getHardwareAccelSkiaEnabled()Z

    move-result v0

    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mHardwareAccelSkia:Z

    .line 4233
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mHardwareAccelSkia:Z

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->nativeUseHardwareAccelSkia(Z)V

    .line 4248
    .end local v2           #invScreenRect:Landroid/graphics/Rect;
    .end local v3           #screenRect:Landroid/graphics/Rect;
    .end local v11           #functor:I
    :cond_dc
    :goto_dc
    invoke-virtual {p1, v12}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 4249
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->drawTextSelectionHandles(Landroid/graphics/Canvas;)V

    .line 4251
    const/4 v0, 0x2

    if-ne v6, v0, :cond_18

    .line 4252
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/4 v1, 0x4

    if-ne v0, v1, :cond_18

    .line 4253
    const/4 v0, 0x5

    iput v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    goto/16 :goto_18

    .line 4181
    .end local v6           #extras:I
    .end local v7           #UIAnimationsRunning:Z
    .end local v8           #animateScroll:Z
    .end local v12           #saveCount:I
    :cond_ef
    const/4 v8, 0x0

    goto/16 :goto_3a

    .line 4199
    .restart local v8       #animateScroll:Z
    .restart local v12       #saveCount:I
    :cond_f2
    invoke-virtual {p1}, Landroid/graphics/Canvas;->isHardwareAccelerated()Z

    move-result v0

    if-nez v0, :cond_6f

    .line 4200
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->getScale()F

    move-result v0

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v1}, Landroid/webkit/ZoomManager;->getScale()F

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->scale(FF)V

    goto/16 :goto_6f

    .line 4225
    .restart local v6       #extras:I
    .restart local v7       #UIAnimationsRunning:Z
    :cond_109
    const/4 v2, 0x0

    goto :goto_a8

    .line 4226
    .restart local v2       #invScreenRect:Landroid/graphics/Rect;
    :cond_10b
    const/4 v3, 0x0

    goto :goto_ae

    .line 4237
    .end local v2           #invScreenRect:Landroid/graphics/Rect;
    :cond_10d
    const/4 v10, 0x0

    .line 4238
    .local v10, df:Landroid/graphics/DrawFilter;
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->isZoomAnimating()Z

    move-result v0

    if-nez v0, :cond_118

    if-eqz v7, :cond_129

    .line 4239
    :cond_118
    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mZoomFilter:Landroid/graphics/DrawFilter;

    .line 4243
    :cond_11a
    :goto_11a
    invoke-virtual {p1, v10}, Landroid/graphics/Canvas;->setDrawFilter(Landroid/graphics/DrawFilter;)V

    .line 4244
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mVisibleContentRect:Landroid/graphics/RectF;

    iget v1, p0, Landroid/webkit/WebViewClassic;->mBackgroundColor:I

    invoke-direct {p0, p1, v0, v1, v6}, Landroid/webkit/WebViewClassic;->nativeDraw(Landroid/graphics/Canvas;Landroid/graphics/RectF;II)V

    .line 4245
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->setDrawFilter(Landroid/graphics/DrawFilter;)V

    goto :goto_dc

    .line 4240
    :cond_129
    if-eqz v8, :cond_11a

    .line 4241
    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mScrollFilter:Landroid/graphics/DrawFilter;

    goto :goto_11a
.end method

.method private drawOverScrollBackground(Landroid/graphics/Canvas;)V
    .registers 12
    .parameter "canvas"

    .prologue
    .line 4263
    sget-object v0, Landroid/webkit/WebViewClassic;->mOverScrollBackground:Landroid/graphics/Paint;

    if-nez v0, :cond_42

    .line 4264
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    sput-object v0, Landroid/webkit/WebViewClassic;->mOverScrollBackground:Landroid/graphics/Paint;

    .line 4265
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x1080560

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v6

    .line 4268
    .local v6, bm:Landroid/graphics/Bitmap;
    sget-object v0, Landroid/webkit/WebViewClassic;->mOverScrollBackground:Landroid/graphics/Paint;

    new-instance v1, Landroid/graphics/BitmapShader;

    sget-object v2, Landroid/graphics/Shader$TileMode;->REPEAT:Landroid/graphics/Shader$TileMode;

    sget-object v3, Landroid/graphics/Shader$TileMode;->REPEAT:Landroid/graphics/Shader$TileMode;

    invoke-direct {v1, v6, v2, v3}, Landroid/graphics/BitmapShader;-><init>(Landroid/graphics/Bitmap;Landroid/graphics/Shader$TileMode;Landroid/graphics/Shader$TileMode;)V

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    .line 4270
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    sput-object v0, Landroid/webkit/WebViewClassic;->mOverScrollBorder:Landroid/graphics/Paint;

    .line 4271
    sget-object v0, Landroid/webkit/WebViewClassic;->mOverScrollBorder:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 4272
    sget-object v0, Landroid/webkit/WebViewClassic;->mOverScrollBorder:Landroid/graphics/Paint;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 4273
    sget-object v0, Landroid/webkit/WebViewClassic;->mOverScrollBorder:Landroid/graphics/Paint;

    const v1, -0x444445

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 4276
    .end local v6           #bm:Landroid/graphics/Bitmap;
    :cond_42
    const/4 v9, 0x0

    .line 4277
    .local v9, top:I
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->computeRealHorizontalScrollRange()I

    move-result v8

    .line 4278
    .local v8, right:I
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->computeRealVerticalScrollRange()I

    move-result v0

    add-int v7, v9, v0

    .line 4280
    .local v7, bottom:I
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 4281
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v0

    int-to-float v0, v0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 4282
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v0

    neg-int v0, v0

    int-to-float v1, v0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v0

    sub-int v0, v9, v0

    int-to-float v2, v0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v0

    sub-int v0, v8, v0

    int-to-float v3, v0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v0

    sub-int v0, v7, v0

    int-to-float v4, v0

    sget-object v5, Landroid/graphics/Region$Op;->DIFFERENCE:Landroid/graphics/Region$Op;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->clipRect(FFFFLandroid/graphics/Region$Op;)Z

    .line 4284
    sget-object v0, Landroid/webkit/WebViewClassic;->mOverScrollBackground:Landroid/graphics/Paint;

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->drawPaint(Landroid/graphics/Paint;)V

    .line 4285
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 4287
    const/high16 v1, -0x4080

    const/4 v0, -0x1

    int-to-float v2, v0

    int-to-float v3, v8

    int-to-float v4, v7

    sget-object v5, Landroid/webkit/WebViewClassic;->mOverScrollBorder:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 4289
    const/4 v0, 0x0

    invoke-virtual {p1, v0, v9, v8, v7}, Landroid/graphics/Canvas;->clipRect(IIII)Z

    .line 4290
    return-void
.end method

.method private drawTextSelectionHandles(Landroid/graphics/Canvas;)V
    .registers 12
    .parameter "canvas"

    .prologue
    const/4 v8, -0x1

    .line 4567
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mHandleAlpha:Landroid/webkit/WebViewClassic$SelectionHandleAlpha;

    invoke-virtual {v7}, Landroid/webkit/WebViewClassic$SelectionHandleAlpha;->getAlpha()I

    move-result v7

    if-nez v7, :cond_a

    .line 4613
    :cond_9
    :goto_9
    return-void

    .line 4570
    :cond_a
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->ensureSelectionHandles()V

    .line 4572
    new-instance v6, Landroid/graphics/Rect;

    invoke-direct {v6, v8, v8, v8, v8}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 4573
    .local v6, topLeft:Landroid/graphics/Rect;
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0, v8, v8, v8, v8}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 4574
    .local v0, bottomRight:Landroid/graphics/Rect;
    iget-boolean v7, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-eqz v7, :cond_6f

    .line 4575
    const/4 v7, 0x4

    new-array v3, v7, [I

    .line 4576
    .local v3, handles:[I
    invoke-direct {p0, v3}, Landroid/webkit/WebViewClassic;->getSelectionHandles([I)V

    .line 4577
    const/4 v7, 0x0

    aget v7, v3, v7

    invoke-virtual {p0, v7}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v4

    .line 4578
    .local v4, start_x:I
    const/4 v7, 0x1

    aget v7, v3, v7

    invoke-virtual {p0, v7}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v5

    .line 4579
    .local v5, start_y:I
    const/4 v7, 0x2

    aget v7, v3, v7

    invoke-virtual {p0, v7}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v1

    .line 4580
    .local v1, end_x:I
    const/4 v7, 0x3

    aget v7, v3, v7

    invoke-virtual {p0, v7}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v2

    .line 4582
    .local v2, end_y:I
    iget-boolean v7, p0, Landroid/webkit/WebViewClassic;->mIsCaretSelection:Z

    if-eqz v7, :cond_79

    .line 4584
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mSelectHandleCenter:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v7}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    sub-int/2addr v4, v7

    .line 4585
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mSelectHandleCenter:Landroid/graphics/drawable/Drawable;

    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mSelectHandleCenter:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v8}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v8

    add-int/2addr v8, v4

    iget-object v9, p0, Landroid/webkit/WebViewClassic;->mSelectHandleCenter:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v9}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v9

    add-int/2addr v9, v5

    invoke-virtual {v7, v4, v5, v8, v9}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 4599
    :goto_5d
    new-instance v6, Landroid/graphics/Rect;

    .end local v6           #topLeft:Landroid/graphics/Rect;
    add-int/lit8 v7, v4, 0x3c

    add-int/lit8 v8, v5, 0x3c

    invoke-direct {v6, v4, v5, v7, v8}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 4600
    .restart local v6       #topLeft:Landroid/graphics/Rect;
    new-instance v0, Landroid/graphics/Rect;

    .end local v0           #bottomRight:Landroid/graphics/Rect;
    add-int/lit8 v7, v1, 0x3c

    add-int/lit8 v8, v2, 0x3c

    invoke-direct {v0, v1, v2, v7, v8}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 4603
    .end local v1           #end_x:I
    .end local v2           #end_y:I
    .end local v3           #handles:[I
    .end local v4           #start_x:I
    .end local v5           #start_y:I
    .restart local v0       #bottomRight:Landroid/graphics/Rect;
    :cond_6f
    iget-boolean v7, p0, Landroid/webkit/WebViewClassic;->mIsCaretSelection:Z

    if-eqz v7, :cond_b4

    .line 4604
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mSelectHandleCenter:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v7, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    goto :goto_9

    .line 4590
    .restart local v1       #end_x:I
    .restart local v2       #end_y:I
    .restart local v3       #handles:[I
    .restart local v4       #start_x:I
    .restart local v5       #start_y:I
    :cond_79
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mSelectHandleLeft:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v7}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v7

    mul-int/lit8 v7, v7, 0x3

    div-int/lit8 v7, v7, 0x4

    sub-int/2addr v4, v7

    .line 4591
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mSelectHandleLeft:Landroid/graphics/drawable/Drawable;

    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mSelectHandleLeft:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v8}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v8

    add-int/2addr v8, v4

    iget-object v9, p0, Landroid/webkit/WebViewClassic;->mSelectHandleLeft:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v9}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v9

    add-int/2addr v9, v5

    invoke-virtual {v7, v4, v5, v8, v9}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 4594
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mSelectHandleRight:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v7}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v7

    div-int/lit8 v7, v7, 0x4

    sub-int/2addr v1, v7

    .line 4595
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mSelectHandleRight:Landroid/graphics/drawable/Drawable;

    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mSelectHandleRight:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v8}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v8

    add-int/2addr v8, v1

    iget-object v9, p0, Landroid/webkit/WebViewClassic;->mSelectHandleRight:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v9}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v9

    add-int/2addr v9, v2

    invoke-virtual {v7, v1, v2, v8, v9}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    goto :goto_5d

    .line 4606
    .end local v1           #end_x:I
    .end local v2           #end_y:I
    .end local v3           #handles:[I
    .end local v4           #start_x:I
    .end local v5           #start_y:I
    :cond_b4
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mSelectHandleLeft:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v7, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 4607
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mSelectHandleRight:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v7, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 4609
    iget-boolean v7, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-eqz v7, :cond_9

    .line 4610
    invoke-direct {p0, p1, v6, v0}, Landroid/webkit/WebViewClassic;->showMagnifier(Landroid/graphics/Canvas;Landroid/graphics/Rect;Landroid/graphics/Rect;)V

    goto/16 :goto_9
.end method

.method public static enablePlatformNotifications()V
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2174
    const-class v2, Landroid/webkit/WebViewClassic;

    monitor-enter v2

    .line 2175
    const/4 v1, 0x1

    :try_start_4
    sput-boolean v1, Landroid/webkit/WebViewClassic;->sNotificationsEnabled:Z

    .line 2176
    invoke-static {}, Landroid/webkit/JniUtil;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 2177
    .local v0, context:Landroid/content/Context;
    if-eqz v0, :cond_f

    .line 2178
    invoke-static {v0}, Landroid/webkit/WebViewClassic;->setupProxyListener(Landroid/content/Context;)V

    .line 2179
    :cond_f
    monitor-exit v2

    .line 2180
    return-void

    .line 2179
    :catchall_11
    move-exception v1

    monitor-exit v2
    :try_end_13
    .catchall {:try_start_4 .. :try_end_13} :catchall_11

    throw v1
.end method

.method private endScrollEdit()V
    .registers 3

    .prologue
    .line 6336
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/webkit/WebViewClassic;->mLastEditScroll:J

    .line 6337
    return-void
.end method

.method private endSelectingText()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 4541
    iput-boolean v2, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    .line 4542
    iput-boolean v2, p0, Landroid/webkit/WebViewClassic;->mShowTextSelectionExtra:Z

    .line 4543
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHandleAlphaAnimator:Landroid/animation/ObjectAnimator;

    const/4 v1, 0x1

    new-array v1, v1, [I

    aput v2, v1, v2

    invoke-virtual {v0, v1}, Landroid/animation/ObjectAnimator;->setIntValues([I)V

    .line 4544
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHandleAlphaAnimator:Landroid/animation/ObjectAnimator;

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->start()V

    .line 4545
    return-void
.end method

.method private ensureFunctorDetached()V
    .registers 4

    .prologue
    .line 2113
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->isHardwareAccelerated()Z

    move-result v2

    if-eqz v2, :cond_1b

    .line 2114
    iget v2, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    invoke-direct {p0, v2}, Landroid/webkit/WebViewClassic;->nativeGetDrawGLFunction(I)I

    move-result v0

    .line 2115
    .local v0, drawGLFunction:I
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->getViewRootImpl()Landroid/view/ViewRootImpl;

    move-result-object v1

    .line 2116
    .local v1, viewRoot:Landroid/view/ViewRootImpl;
    if-eqz v0, :cond_1b

    if-eqz v1, :cond_1b

    .line 2117
    invoke-virtual {v1, v0}, Landroid/view/ViewRootImpl;->detachFunctor(I)V

    .line 2120
    .end local v0           #drawGLFunction:I
    .end local v1           #viewRoot:Landroid/view/ViewRootImpl;
    :cond_1b
    return-void
.end method

.method private ensureSelectionHandles()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 4548
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mSelectHandleCenter:Landroid/graphics/drawable/Drawable;

    if-nez v0, :cond_70

    .line 4549
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x10805ba

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mSelectHandleCenter:Landroid/graphics/drawable/Drawable;

    .line 4551
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x10805b9

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mSelectHandleLeft:Landroid/graphics/drawable/Drawable;

    .line 4553
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x10805bb

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mSelectHandleRight:Landroid/graphics/drawable/Drawable;

    .line 4555
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHandleAlpha:Landroid/webkit/WebViewClassic$SelectionHandleAlpha;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mHandleAlpha:Landroid/webkit/WebViewClassic$SelectionHandleAlpha;

    invoke-virtual {v1}, Landroid/webkit/WebViewClassic$SelectionHandleAlpha;->getAlpha()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewClassic$SelectionHandleAlpha;->setAlpha(I)V

    .line 4556
    new-instance v0, Landroid/graphics/Point;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mSelectHandleCenter:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    neg-int v1, v1

    invoke-direct {v0, v2, v1}, Landroid/graphics/Point;-><init>(II)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mSelectHandleCenterOffset:Landroid/graphics/Point;

    .line 4558
    new-instance v0, Landroid/graphics/Point;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mSelectHandleLeft:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    neg-int v1, v1

    invoke-direct {v0, v2, v1}, Landroid/graphics/Point;-><init>(II)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mSelectHandleLeftOffset:Landroid/graphics/Point;

    .line 4560
    new-instance v0, Landroid/graphics/Point;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mSelectHandleLeft:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v1

    neg-int v1, v1

    div-int/lit8 v1, v1, 0x2

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mSelectHandleRight:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v2

    neg-int v2, v2

    invoke-direct {v0, v1, v2}, Landroid/graphics/Point;-><init>(II)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mSelectHandleRightOffset:Landroid/graphics/Point;

    .line 4564
    :cond_70
    return-void
.end method

.method private extendScroll(I)Z
    .registers 6
    .parameter "y"

    .prologue
    const/4 v2, 0x0

    .line 2741
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v3}, Landroid/widget/OverScroller;->getFinalY()I

    move-result v0

    .line 2742
    .local v0, finalY:I
    add-int v3, v0, p1

    invoke-virtual {p0, v3}, Landroid/webkit/WebViewClassic;->pinLocY(I)I

    move-result v1

    .line 2743
    .local v1, newY:I
    if-ne v1, v0, :cond_10

    .line 2746
    :goto_f
    return v2

    .line 2744
    :cond_10
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v3, v1}, Landroid/widget/OverScroller;->setFinalY(I)V

    .line 2745
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-static {v2, p1}, Landroid/webkit/WebViewClassic;->computeDuration(II)I

    move-result v2

    invoke-virtual {v3, v2}, Landroid/widget/OverScroller;->extendDuration(I)V

    .line 2746
    const/4 v2, 0x1

    goto :goto_f
.end method

.method public static findAddress(Ljava/lang/String;)Ljava/lang/String;
    .registers 2
    .parameter "addr"

    .prologue
    .line 3715
    const/4 v0, 0x0

    invoke-static {p0, v0}, Landroid/webkit/WebViewClassic;->findAddress(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static findAddress(Ljava/lang/String;Z)Ljava/lang/String;
    .registers 3
    .parameter "addr"
    .parameter "caseInsensitive"

    .prologue
    .line 3740
    invoke-static {p0, p1}, Landroid/webkit/WebViewCore;->nativeFindAddress(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private findAllBody(Ljava/lang/String;Z)I
    .registers 9
    .parameter "find"
    .parameter "isAsync"

    .prologue
    const/16 v4, 0xdd

    const/4 v1, 0x0

    .line 3614
    iget v2, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v2, :cond_8

    .line 3633
    :cond_7
    :goto_7
    return v1

    .line 3615
    :cond_8
    const/4 v2, 0x0

    iput-object v2, p0, Landroid/webkit/WebViewClassic;->mFindRequest:Landroid/webkit/WebViewCore$FindAllRequest;

    .line 3616
    if-eqz p1, :cond_7

    .line 3617
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v2, v4}, Landroid/webkit/WebViewCore;->removeMessages(I)V

    .line 3618
    new-instance v2, Landroid/webkit/WebViewCore$FindAllRequest;

    invoke-direct {v2, p1}, Landroid/webkit/WebViewCore$FindAllRequest;-><init>(Ljava/lang/String;)V

    iput-object v2, p0, Landroid/webkit/WebViewClassic;->mFindRequest:Landroid/webkit/WebViewCore$FindAllRequest;

    .line 3619
    if-eqz p2, :cond_23

    .line 3620
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mFindRequest:Landroid/webkit/WebViewCore$FindAllRequest;

    invoke-virtual {v2, v4, v3}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    goto :goto_7

    .line 3623
    :cond_23
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mFindRequest:Landroid/webkit/WebViewCore$FindAllRequest;

    monitor-enter v2

    .line 3625
    :try_start_26
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v4, 0xdd

    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mFindRequest:Landroid/webkit/WebViewCore$FindAllRequest;

    invoke-virtual {v3, v4, v5}, Landroid/webkit/WebViewCore;->sendMessageAtFrontOfQueue(ILjava/lang/Object;)V

    .line 3626
    :goto_2f
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mFindRequest:Landroid/webkit/WebViewCore$FindAllRequest;

    iget v3, v3, Landroid/webkit/WebViewCore$FindAllRequest;->mMatchCount:I

    const/4 v4, -0x1

    if-ne v3, v4, :cond_42

    .line 3627
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mFindRequest:Landroid/webkit/WebViewCore$FindAllRequest;

    invoke-virtual {v3}, Ljava/lang/Object;->wait()V
    :try_end_3b
    .catchall {:try_start_26 .. :try_end_3b} :catchall_3f
    .catch Ljava/lang/InterruptedException; {:try_start_26 .. :try_end_3b} :catch_3c

    goto :goto_2f

    .line 3630
    :catch_3c
    move-exception v0

    .line 3631
    .local v0, e:Ljava/lang/InterruptedException;
    :try_start_3d
    monitor-exit v2

    goto :goto_7

    .line 3634
    .end local v0           #e:Ljava/lang/InterruptedException;
    :catchall_3f
    move-exception v1

    monitor-exit v2
    :try_end_41
    .catchall {:try_start_3d .. :try_end_41} :catchall_3f

    throw v1

    .line 3633
    :cond_42
    :try_start_42
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mFindRequest:Landroid/webkit/WebViewCore$FindAllRequest;

    iget v1, v1, Landroid/webkit/WebViewCore$FindAllRequest;->mMatchCount:I

    monitor-exit v2
    :try_end_47
    .catchall {:try_start_42 .. :try_end_47} :catchall_3f

    goto :goto_7
.end method

.method public static fromWebView(Landroid/webkit/WebView;)Landroid/webkit/WebViewClassic;
    .registers 2
    .parameter "webView"

    .prologue
    .line 1445
    if-nez p0, :cond_4

    const/4 v0, 0x0

    :goto_3
    return-object v0

    :cond_4
    invoke-virtual {p0}, Landroid/webkit/WebView;->getWebViewProvider()Landroid/webkit/WebViewProvider;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebViewClassic;

    goto :goto_3
.end method

.method private getAccessibilityInjector()Landroid/webkit/AccessibilityInjector;
    .registers 2

    .prologue
    .line 1786
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mAccessibilityInjector:Landroid/webkit/AccessibilityInjector;

    if-nez v0, :cond_b

    .line 1787
    new-instance v0, Landroid/webkit/AccessibilityInjector;

    invoke-direct {v0, p0}, Landroid/webkit/AccessibilityInjector;-><init>(Landroid/webkit/WebViewClassic;)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mAccessibilityInjector:Landroid/webkit/AccessibilityInjector;

    .line 1789
    :cond_b
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mAccessibilityInjector:Landroid/webkit/AccessibilityInjector;

    return-object v0
.end method

.method private getMaxTextScrollX()I
    .registers 4

    .prologue
    .line 7302
    const/4 v0, 0x0

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mEditTextContent:Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->width()I

    move-result v1

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    invoke-virtual {v2}, Landroid/graphics/Rect;->width()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method private getMaxTextScrollY()I
    .registers 4

    .prologue
    .line 7306
    const/4 v0, 0x0

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mEditTextContent:Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->height()I

    move-result v1

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    invoke-virtual {v2}, Landroid/graphics/Rect;->height()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method private getOverlappingActionModeHeight()I
    .registers 5

    .prologue
    const/4 v0, 0x0

    .line 1993
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mFindCallback:Landroid/webkit/FindActionModeCallback;

    if-nez v1, :cond_6

    .line 2001
    :goto_5
    return v0

    .line 1996
    :cond_6
    iget v1, p0, Landroid/webkit/WebViewClassic;->mCachedOverlappingActionModeHeight:I

    if-gez v1, :cond_24

    .line 1997
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mGlobalVisibleRect:Landroid/graphics/Rect;

    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mGlobalVisibleOffset:Landroid/graphics/Point;

    invoke-virtual {v1, v2, v3}, Landroid/webkit/WebView;->getGlobalVisibleRect(Landroid/graphics/Rect;Landroid/graphics/Point;)Z

    .line 1998
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mFindCallback:Landroid/webkit/FindActionModeCallback;

    invoke-virtual {v1}, Landroid/webkit/FindActionModeCallback;->getActionModeGlobalBottom()I

    move-result v1

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mGlobalVisibleRect:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->top:I

    sub-int/2addr v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    iput v0, p0, Landroid/webkit/WebViewClassic;->mCachedOverlappingActionModeHeight:I

    .line 2001
    :cond_24
    iget v0, p0, Landroid/webkit/WebViewClassic;->mCachedOverlappingActionModeHeight:I

    goto :goto_5
.end method

.method public static declared-synchronized getPluginList()Landroid/webkit/PluginList;
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 4149
    const-class v1, Landroid/webkit/WebViewClassic;

    monitor-enter v1

    :try_start_3
    new-instance v0, Landroid/webkit/PluginList;

    invoke-direct {v0}, Landroid/webkit/PluginList;-><init>()V
    :try_end_8
    .catchall {:try_start_3 .. :try_end_8} :catchall_a

    monitor-exit v1

    return-object v0

    :catchall_a
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private getScaledMaxXScroll()I
    .registers 4

    .prologue
    .line 8504
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mHeightCanMeasure:Z

    if-nez v2, :cond_f

    .line 8505
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getViewWidth()I

    move-result v2

    div-int/lit8 v1, v2, 0x4

    .line 8512
    .local v1, width:I
    :goto_a
    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->viewToContentX(I)I

    move-result v2

    return v2

    .line 8507
    .end local v1           #width:I
    :cond_f
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 8508
    .local v0, visRect:Landroid/graphics/Rect;
    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->calcOurVisibleRect(Landroid/graphics/Rect;)V

    .line 8509
    invoke-virtual {v0}, Landroid/graphics/Rect;->width()I

    move-result v2

    div-int/lit8 v1, v2, 0x2

    .restart local v1       #width:I
    goto :goto_a
.end method

.method private getScaledMaxYScroll()I
    .registers 5

    .prologue
    .line 8517
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mHeightCanMeasure:Z

    if-nez v2, :cond_17

    .line 8518
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getViewHeight()I

    move-result v2

    div-int/lit8 v0, v2, 0x4

    .line 8527
    .local v0, height:I
    :goto_a
    int-to-float v2, v0

    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v3}, Landroid/webkit/ZoomManager;->getInvScale()F

    move-result v3

    mul-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v2

    return v2

    .line 8520
    .end local v0           #height:I
    :cond_17
    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    .line 8521
    .local v1, visRect:Landroid/graphics/Rect;
    invoke-direct {p0, v1}, Landroid/webkit/WebViewClassic;->calcOurVisibleRect(Landroid/graphics/Rect;)V

    .line 8522
    invoke-virtual {v1}, Landroid/graphics/Rect;->height()I

    move-result v2

    div-int/lit8 v0, v2, 0x2

    .restart local v0       #height:I
    goto :goto_a
.end method

.method private getSelectionHandles([I)V
    .registers 4
    .parameter "handles"

    .prologue
    .line 4740
    const/4 v0, 0x0

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v1, v1, Landroid/graphics/Point;->x:I

    aput v1, p1, v0

    .line 4741
    const/4 v0, 0x1

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v1, v1, Landroid/graphics/Point;->y:I

    aput v1, p1, v0

    .line 4742
    const/4 v0, 0x2

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRight:Landroid/graphics/Point;

    iget v1, v1, Landroid/graphics/Point;->x:I

    aput v1, p1, v0

    .line 4743
    const/4 v0, 0x3

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRight:Landroid/graphics/Point;

    iget v1, v1, Landroid/graphics/Point;->y:I

    aput v1, p1, v0

    .line 4744
    return-void
.end method

.method private static getTextScrollDelta(FJ)I
    .registers 10
    .parameter "speed"
    .parameter "deltaT"

    .prologue
    .line 6340
    long-to-float v3, p1

    mul-float v0, p0, v3

    .line 6341
    .local v0, distance:F
    float-to-double v3, v0

    invoke-static {v3, v4}, Ljava/lang/Math;->floor(D)D

    move-result-wide v3

    double-to-int v1, v3

    .line 6342
    .local v1, intDistance:I
    int-to-float v3, v1

    sub-float v2, v0, v3

    .line 6343
    .local v2, probability:F
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v3

    float-to-double v5, v2

    cmpg-double v3, v3, v5

    if-gez v3, :cond_17

    .line 6344
    add-int/lit8 v1, v1, 0x1

    .line 6346
    :cond_17
    return v1
.end method

.method private static getTextScrollSpeed(III)F
    .registers 5
    .parameter "coordinate"
    .parameter "min"
    .parameter "max"

    .prologue
    const v1, 0x3c23d70a

    .line 6318
    if-ge p0, p1, :cond_a

    .line 6319
    sub-int v0, p0, p1

    int-to-float v0, v0

    mul-float/2addr v0, v1

    .line 6323
    :goto_9
    return v0

    .line 6320
    :cond_a
    if-lt p0, p2, :cond_13

    .line 6321
    sub-int v0, p0, p2

    add-int/lit8 v0, v0, 0x1

    int-to-float v0, v0

    mul-float/2addr v0, v1

    goto :goto_9

    .line 6323
    :cond_13
    const/4 v0, 0x0

    goto :goto_9
.end method

.method private getTextScrollX()I
    .registers 2

    .prologue
    .line 7294
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mEditTextContent:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->left:I

    neg-int v0, v0

    return v0
.end method

.method private getTextScrollY()I
    .registers 2

    .prologue
    .line 7298
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mEditTextContent:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->top:I

    neg-int v0, v0

    return v0
.end method

.method private getVisibleTitleHeightImpl()I
    .registers 4

    .prologue
    .line 1986
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    sub-int/2addr v0, v1

    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getOverlappingActionModeHeight()I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method private goBackOrForward(IZ)V
    .registers 6
    .parameter "steps"
    .parameter "ignoreSnapshot"

    .prologue
    .line 2720
    if-eqz p1, :cond_f

    .line 2721
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->clearHelpers()V

    .line 2722
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v2, 0x6a

    if-eqz p2, :cond_10

    const/4 v0, 0x1

    :goto_c
    invoke-virtual {v1, v2, p1, v0}, Landroid/webkit/WebViewCore;->sendMessage(III)V

    .line 2725
    :cond_f
    return-void

    .line 2722
    :cond_10
    const/4 v0, 0x0

    goto :goto_c
.end method

.method private goBackOrForwardImpl(I)V
    .registers 3
    .parameter "steps"

    .prologue
    .line 2716
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/webkit/WebViewClassic;->goBackOrForward(IZ)V

    .line 2717
    return-void
.end method

.method private static handleCertTrustChanged()V
    .registers 2

    .prologue
    .line 1497
    const/16 v0, 0xdc

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/webkit/WebViewCore;->sendStaticMessage(ILjava/lang/Object;)V

    .line 1498
    return-void
.end method

.method private static handleProxyBroadcast(Landroid/content/Intent;)V
    .registers 4
    .parameter "intent"

    .prologue
    const/16 v2, 0xc1

    .line 1560
    const-string/jumbo v1, "proxy"

    invoke-virtual {p0, v1}, Landroid/content/Intent;->getExtra(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ProxyProperties;

    .line 1561
    .local v0, proxyProperties:Landroid/net/ProxyProperties;
    if-eqz v0, :cond_13

    invoke-virtual {v0}, Landroid/net/ProxyProperties;->getHost()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_18

    .line 1562
    :cond_13
    const/4 v1, 0x0

    invoke-static {v2, v1}, Landroid/webkit/WebViewCore;->sendStaticMessage(ILjava/lang/Object;)V

    .line 1566
    :goto_17
    return-void

    .line 1565
    :cond_18
    invoke-static {v2, v0}, Landroid/webkit/WebViewCore;->sendStaticMessage(ILjava/lang/Object;)V

    goto :goto_17
.end method

.method private handleTouchEventCommon(Landroid/view/MotionEvent;III)V
    .registers 35
    .parameter "event"
    .parameter "action"
    .parameter "x"
    .parameter "y"

    .prologue
    .line 5961
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v3}, Landroid/webkit/ZoomManager;->getMultiTouchGestureDetector()Landroid/view/ScaleGestureDetector;

    move-result-object v17

    .line 5963
    .local v17, detector:Landroid/view/ScaleGestureDetector;
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v18

    .line 5969
    .local v18, eventTime:J
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getViewWidth()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    move/from16 v0, p3

    invoke-static {v0, v3}, Ljava/lang/Math;->min(II)I

    move-result p3

    .line 5970
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getViewHeightWithTitle()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    move/from16 v0, p4

    invoke-static {v0, v3}, Ljava/lang/Math;->min(II)I

    move-result p4

    .line 5972
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mLastTouchX:I

    sub-int v15, v3, p3

    .line 5973
    .local v15, deltaX:I
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mLastTouchY:I

    sub-int v16, v3, p4

    .line 5974
    .local v16, deltaY:I
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    add-int v3, v3, p3

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/webkit/WebViewClassic;->viewToContentX(I)I

    move-result v13

    .line 5975
    .local v13, contentX:I
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v3

    add-int v3, v3, p4

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/webkit/WebViewClassic;->viewToContentY(I)I

    move-result v14

    .line 5977
    .local v14, contentY:I
    packed-switch p2, :pswitch_data_60e

    .line 6308
    :cond_4b
    :goto_4b
    return-void

    .line 5979
    :pswitch_4c
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput-boolean v3, v0, Landroid/webkit/WebViewClassic;->mConfirmMove:Z

    .line 5980
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mEditTextScroller:Landroid/widget/Scroller;

    invoke-virtual {v3}, Landroid/widget/Scroller;->isFinished()Z

    move-result v3

    if-nez v3, :cond_62

    .line 5981
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mEditTextScroller:Landroid/widget/Scroller;

    invoke-virtual {v3}, Landroid/widget/Scroller;->abortAnimation()V

    .line 5983
    :cond_62
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v3}, Landroid/widget/OverScroller;->isFinished()Z

    move-result v3

    if-nez v3, :cond_cb

    .line 5987
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v3}, Landroid/widget/OverScroller;->abortAnimation()V

    .line 5988
    const/4 v3, 0x2

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    .line 5989
    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput-boolean v3, v0, Landroid/webkit/WebViewClassic;->mConfirmMove:Z

    .line 5990
    const/4 v3, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Landroid/webkit/WebViewClassic;->nativeSetIsScrolling(Z)V

    .line 6041
    :cond_83
    :goto_83
    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-nez v3, :cond_ab

    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/4 v4, 0x1

    if-eq v3, v4, :cond_97

    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/4 v4, 0x6

    if-ne v3, v4, :cond_ab

    .line 6043
    :cond_97
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v4, 0x3

    const-wide/16 v5, 0x12c

    invoke-virtual {v3, v4, v5, v6}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    .line 6045
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v4, 0x4

    const-wide/16 v5, 0x3e8

    invoke-virtual {v3, v4, v5, v6}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    .line 6048
    :cond_ab
    move/from16 v0, p3

    int-to-float v3, v0

    move/from16 v0, p4

    int-to-float v4, v0

    move-object/from16 v0, p0

    move-wide/from16 v1, v18

    invoke-direct {v0, v3, v4, v1, v2}, Landroid/webkit/WebViewClassic;->startTouch(FFJ)V

    .line 6049
    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mIsEditingText:Z

    if-eqz v3, :cond_4b

    .line 6050
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    invoke-virtual {v3, v13, v14}, Landroid/graphics/Rect;->contains(II)Z

    move-result v3

    move-object/from16 v0, p0

    iput-boolean v3, v0, Landroid/webkit/WebViewClassic;->mTouchInEditText:Z

    goto :goto_4b

    .line 5991
    :cond_cb
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v4, 0x5

    invoke-virtual {v3, v4}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v3

    if-eqz v3, :cond_f8

    .line 5992
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v4, 0x5

    invoke-virtual {v3, v4}, Landroid/os/Handler;->removeMessages(I)V

    .line 5993
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->removeTouchHighlight()V

    .line 5994
    mul-int v3, v15, v15

    mul-int v4, v16, v16

    add-int/2addr v3, v4

    move-object/from16 v0, p0

    iget v4, v0, Landroid/webkit/WebViewClassic;->mDoubleTapSlopSquare:I

    if-ge v3, v4, :cond_f2

    .line 5995
    const/4 v3, 0x6

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    goto :goto_83

    .line 5997
    :cond_f2
    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    goto :goto_83

    .line 6000
    :cond_f8
    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    .line 6001
    sget-boolean v3, Landroid/webkit/WebViewClassic;->mLogEvent:Z

    if-eqz v3, :cond_12a

    move-object/from16 v0, p0

    iget-wide v3, v0, Landroid/webkit/WebViewClassic;->mLastTouchUpTime:J

    sub-long v3, v18, v3

    const-wide/16 v5, 0x3e8

    cmp-long v3, v3, v5

    if-gez v3, :cond_12a

    .line 6002
    const v3, 0x111d6

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    move-object/from16 v0, p0

    iget-wide v6, v0, Landroid/webkit/WebViewClassic;->mLastTouchUpTime:J

    sub-long v6, v18, v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static/range {v18 .. v19}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Landroid/util/EventLog;->writeEvent(I[Ljava/lang/Object;)I

    .line 6005
    :cond_12a
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSelectionStarted:Z

    .line 6006
    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-eqz v3, :cond_83

    .line 6007
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->ensureSelectionHandles()V

    .line 6008
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v3

    sub-int v3, p4, v3

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v4

    add-int v29, v3, v4

    .line 6009
    .local v29, shiftedY:I
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    add-int v28, p3, v3

    .line 6010
    .local v28, shiftedX:I
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectHandleCenter:Landroid/graphics/drawable/Drawable;

    if-eqz v3, :cond_18d

    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectHandleCenter:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v3

    move/from16 v0, v28

    move/from16 v1, v29

    invoke-virtual {v3, v0, v1}, Landroid/graphics/Rect;->contains(II)Z

    move-result v3

    if-eqz v3, :cond_18d

    .line 6012
    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSelectionStarted:Z

    .line 6013
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    move-object/from16 v0, p0

    iput-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    .line 6014
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectHandleCenterOffset:Landroid/graphics/Point;

    move-object/from16 v0, p0

    iput-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingOffset:Landroid/graphics/Point;

    .line 6015
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectCursorLeftTextQuad:Landroid/webkit/QuadF;

    move-object/from16 v0, p0

    iput-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingTextQuad:Landroid/webkit/QuadF;

    .line 6016
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/16 v4, 0x90

    invoke-virtual {v3, v4}, Landroid/os/Handler;->removeMessages(I)V

    .line 6017
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->hidePasteButton()V

    goto/16 :goto_83

    .line 6018
    :cond_18d
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectHandleLeft:Landroid/graphics/drawable/Drawable;

    if-eqz v3, :cond_1c4

    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectHandleLeft:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v3

    move/from16 v0, v28

    move/from16 v1, v29

    invoke-virtual {v3, v0, v1}, Landroid/graphics/Rect;->contains(II)Z

    move-result v3

    if-eqz v3, :cond_1c4

    .line 6021
    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSelectionStarted:Z

    .line 6022
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectHandleLeftOffset:Landroid/graphics/Point;

    move-object/from16 v0, p0

    iput-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingOffset:Landroid/graphics/Point;

    .line 6023
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    move-object/from16 v0, p0

    iput-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    .line 6024
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectCursorLeftTextQuad:Landroid/webkit/QuadF;

    move-object/from16 v0, p0

    iput-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingTextQuad:Landroid/webkit/QuadF;

    goto/16 :goto_83

    .line 6025
    :cond_1c4
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectHandleRight:Landroid/graphics/drawable/Drawable;

    if-eqz v3, :cond_1fb

    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectHandleRight:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v3

    move/from16 v0, v28

    move/from16 v1, v29

    invoke-virtual {v3, v0, v1}, Landroid/graphics/Rect;->contains(II)Z

    move-result v3

    if-eqz v3, :cond_1fb

    .line 6028
    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSelectionStarted:Z

    .line 6029
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectHandleRightOffset:Landroid/graphics/Point;

    move-object/from16 v0, p0

    iput-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingOffset:Landroid/graphics/Point;

    .line 6030
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectCursorRight:Landroid/graphics/Point;

    move-object/from16 v0, p0

    iput-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    .line 6031
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectCursorRightTextQuad:Landroid/webkit/QuadF;

    move-object/from16 v0, p0

    iput-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingTextQuad:Landroid/webkit/QuadF;

    goto/16 :goto_83

    .line 6032
    :cond_1fb
    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mIsCaretSelection:Z

    if-eqz v3, :cond_83

    .line 6033
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->selectionDone()V

    goto/16 :goto_83

    .line 6056
    .end local v28           #shiftedX:I
    .end local v29           #shiftedY:I
    :pswitch_206
    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mConfirmMove:Z

    if-nez v3, :cond_23b

    mul-int v3, v15, v15

    mul-int v4, v16, v16

    add-int/2addr v3, v4

    move-object/from16 v0, p0

    iget v4, v0, Landroid/webkit/WebViewClassic;->mTouchSlopSquare:I

    if-lt v3, v4, :cond_23b

    .line 6058
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v4, 0x3

    invoke-virtual {v3, v4}, Landroid/os/Handler;->removeMessages(I)V

    .line 6059
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v4, 0x4

    invoke-virtual {v3, v4}, Landroid/os/Handler;->removeMessages(I)V

    .line 6060
    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput-boolean v3, v0, Landroid/webkit/WebViewClassic;->mConfirmMove:Z

    .line 6061
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/4 v4, 0x6

    if-ne v3, v4, :cond_238

    .line 6062
    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    .line 6064
    :cond_238
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->removeTouchHighlight()V

    .line 6066
    :cond_23b
    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-eqz v3, :cond_2d9

    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSelectionStarted:Z

    if-eqz v3, :cond_2d9

    .line 6070
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v3}, Landroid/webkit/WebView;->getParent()Landroid/view/ViewParent;

    move-result-object v25

    .line 6071
    .local v25, parent:Landroid/view/ViewParent;
    if-eqz v25, :cond_257

    .line 6072
    const/4 v3, 0x1

    move-object/from16 v0, v25

    invoke-interface {v0, v3}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 6074
    :cond_257
    if-nez v15, :cond_25b

    if-eqz v16, :cond_4b

    .line 6075
    :cond_25b
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingOffset:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->x:I

    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Landroid/webkit/WebViewClassic;->viewToContentDimension(I)I

    move-result v3

    add-int v20, v13, v3

    .line 6077
    .local v20, handleX:I
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingOffset:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->y:I

    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Landroid/webkit/WebViewClassic;->viewToContentDimension(I)I

    move-result v3

    add-int v21, v14, v3

    .line 6079
    .local v21, handleY:I
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    move/from16 v0, v20

    move/from16 v1, v21

    invoke-virtual {v3, v0, v1}, Landroid/graphics/Point;->set(II)V

    .line 6080
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingTextQuad:Landroid/webkit/QuadF;

    move/from16 v0, v20

    int-to-float v4, v0

    move/from16 v0, v21

    int-to-float v5, v0

    invoke-virtual {v3, v4, v5}, Landroid/webkit/QuadF;->containsPoint(FF)Z

    move-result v22

    .line 6082
    .local v22, inCursorText:Z
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    move/from16 v0, v20

    move/from16 v1, v21

    invoke-virtual {v3, v0, v1}, Landroid/graphics/Rect;->contains(II)Z

    move-result v23

    .line 6084
    .local v23, inEditBounds:Z
    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mIsEditingText:Z

    if-eqz v3, :cond_2d5

    if-nez v23, :cond_2d5

    .line 6085
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->beginScrollEdit()V

    .line 6089
    :goto_2a7
    if-nez v22, :cond_2b1

    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mIsEditingText:Z

    if-eqz v3, :cond_2b4

    if-nez v23, :cond_2b4

    .line 6090
    :cond_2b1
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->snapDraggingCursor()V

    .line 6092
    :cond_2b4
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->updateWebkitSelection()V

    .line 6093
    if-nez v22, :cond_2c4

    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mIsEditingText:Z

    if-eqz v3, :cond_2c4

    if-eqz v23, :cond_2c4

    .line 6095
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->snapDraggingCursor()V

    .line 6097
    :cond_2c4
    move/from16 v0, p3

    move-object/from16 v1, p0

    iput v0, v1, Landroid/webkit/WebViewClassic;->mLastTouchX:I

    .line 6098
    move/from16 v0, p4

    move-object/from16 v1, p0

    iput v0, v1, Landroid/webkit/WebViewClassic;->mLastTouchY:I

    .line 6099
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    goto/16 :goto_4b

    .line 6087
    :cond_2d5
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->endScrollEdit()V

    goto :goto_2a7

    .line 6104
    .end local v20           #handleX:I
    .end local v21           #handleY:I
    .end local v22           #inCursorText:Z
    .end local v23           #inEditBounds:Z
    .end local v25           #parent:Landroid/view/ViewParent;
    :cond_2d9
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/4 v4, 0x7

    if-eq v3, v4, :cond_4b

    .line 6109
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-nez v3, :cond_37b

    .line 6110
    const-string/jumbo v3, "webview"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Got null mVelocityTracker when  mTouchMode = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p0

    iget v5, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 6116
    :goto_303
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/4 v4, 0x3

    if-eq v3, v4, :cond_371

    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/16 v4, 0x9

    if-eq v3, v4, :cond_371

    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/16 v4, 0xa

    if-eq v3, v4, :cond_371

    .line 6120
    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mConfirmMove:Z

    if-eqz v3, :cond_4b

    .line 6127
    move-object/from16 v0, p0

    move/from16 v1, v16

    invoke-direct {v0, v15, v1}, Landroid/webkit/WebViewClassic;->calculateDragAngle(II)F

    move-result v3

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    .line 6128
    if-eqz v17, :cond_334

    invoke-virtual/range {v17 .. v17}, Landroid/view/ScaleGestureDetector;->isInProgress()Z

    move-result v3

    if-nez v3, :cond_34f

    .line 6130
    :cond_334
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    const/high16 v4, 0x3e80

    cmpg-float v3, v3, v4

    if-gez v3, :cond_388

    .line 6131
    const/4 v3, 0x2

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mSnapScrollMode:I

    .line 6132
    if-lez v15, :cond_386

    const/4 v3, 0x1

    :goto_346
    move-object/from16 v0, p0

    iput-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSnapPositive:Z

    .line 6133
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    .line 6141
    :cond_34f
    :goto_34f
    const/4 v3, 0x3

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    .line 6142
    move/from16 v0, p3

    move-object/from16 v1, p0

    iput v0, v1, Landroid/webkit/WebViewClassic;->mLastTouchX:I

    .line 6143
    move/from16 v0, p4

    move-object/from16 v1, p0

    iput v0, v1, Landroid/webkit/WebViewClassic;->mLastTouchY:I

    .line 6144
    const/4 v15, 0x0

    .line 6145
    const/16 v16, 0x0

    .line 6147
    move/from16 v0, p3

    int-to-float v3, v0

    move/from16 v0, p4

    int-to-float v4, v0

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4}, Landroid/webkit/WebViewClassic;->startScrollingLayer(FF)V

    .line 6148
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->startDrag()V

    .line 6152
    :cond_371
    const/16 v24, 0x0

    .line 6153
    .local v24, keepScrollBarsVisible:Z
    if-nez v15, :cond_3a7

    if-nez v16, :cond_3a7

    .line 6154
    const/16 v24, 0x1

    goto/16 :goto_4b

    .line 6113
    .end local v24           #keepScrollBarsVisible:Z
    :cond_37b
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v0, p1

    invoke-virtual {v3, v0}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    goto/16 :goto_303

    .line 6132
    :cond_386
    const/4 v3, 0x0

    goto :goto_346

    .line 6134
    :cond_388
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    const/high16 v4, 0x3fa0

    cmpl-float v3, v3, v4

    if-lez v3, :cond_34f

    .line 6135
    const/4 v3, 0x4

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mSnapScrollMode:I

    .line 6136
    if-lez v16, :cond_3a5

    const/4 v3, 0x1

    :goto_39a
    move-object/from16 v0, p0

    iput-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSnapPositive:Z

    .line 6137
    const/high16 v3, 0x4000

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    goto :goto_34f

    .line 6136
    :cond_3a5
    const/4 v3, 0x0

    goto :goto_39a

    .line 6156
    .restart local v24       #keepScrollBarsVisible:Z
    :cond_3a7
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    move-object/from16 v0, p0

    move/from16 v1, v16

    invoke-direct {v0, v15, v1}, Landroid/webkit/WebViewClassic;->calculateDragAngle(II)F

    move-result v4

    move-object/from16 v0, p0

    iget v5, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    sub-float/2addr v4, v5

    const/high16 v5, 0x40a0

    div-float/2addr v4, v5

    add-float/2addr v3, v4

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    .line 6159
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mSnapScrollMode:I

    if-eqz v3, :cond_433

    .line 6160
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mSnapScrollMode:I

    const/4 v4, 0x4

    if-ne v3, v4, :cond_3dd

    .line 6162
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    const v4, 0x3f733333

    cmpg-float v3, v3, v4

    if-gez v3, :cond_3dd

    .line 6163
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mSnapScrollMode:I

    .line 6166
    :cond_3dd
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mSnapScrollMode:I

    const/4 v4, 0x2

    if-ne v3, v4, :cond_3f4

    .line 6168
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    const v4, 0x3ecccccd

    cmpl-float v3, v3, v4

    if-lez v3, :cond_3f4

    .line 6169
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mSnapScrollMode:I

    .line 6183
    :cond_3f4
    :goto_3f4
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mSnapScrollMode:I

    if-eqz v3, :cond_405

    .line 6184
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mSnapScrollMode:I

    and-int/lit8 v3, v3, 0x2

    const/4 v4, 0x2

    if-ne v3, v4, :cond_481

    .line 6185
    const/16 v16, 0x0

    .line 6190
    :cond_405
    :goto_405
    mul-int v3, v15, v15

    mul-int v4, v16, v16

    add-int/2addr v3, v4

    move-object/from16 v0, p0

    iget v4, v0, Landroid/webkit/WebViewClassic;->mTouchSlopSquare:I

    if-le v3, v4, :cond_483

    .line 6191
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mHeldMotionless:I

    .line 6197
    :goto_415
    move-wide/from16 v0, v18

    move-object/from16 v2, p0

    iput-wide v0, v2, Landroid/webkit/WebViewClassic;->mLastTouchTime:J

    .line 6198
    move-object/from16 v0, p0

    move/from16 v1, v16

    invoke-direct {v0, v15, v1}, Landroid/webkit/WebViewClassic;->doDrag(II)Z

    move-result v10

    .line 6199
    .local v10, allDrag:Z
    if-eqz v10, :cond_48b

    .line 6200
    move/from16 v0, p3

    move-object/from16 v1, p0

    iput v0, v1, Landroid/webkit/WebViewClassic;->mLastTouchX:I

    .line 6201
    move/from16 v0, p4

    move-object/from16 v1, p0

    iput v0, v1, Landroid/webkit/WebViewClassic;->mLastTouchY:I

    goto/16 :goto_4b

    .line 6173
    .end local v10           #allDrag:Z
    :cond_433
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    const/high16 v4, 0x3e80

    cmpg-float v3, v3, v4

    if-gez v3, :cond_459

    .line 6174
    const/4 v3, 0x2

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mSnapScrollMode:I

    .line 6175
    if-lez v15, :cond_457

    const/4 v3, 0x1

    :goto_445
    move-object/from16 v0, p0

    iput-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSnapPositive:Z

    .line 6176
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    const/4 v4, 0x0

    add-float/2addr v3, v4

    const/high16 v4, 0x4000

    div-float/2addr v3, v4

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    goto :goto_3f4

    .line 6175
    :cond_457
    const/4 v3, 0x0

    goto :goto_445

    .line 6177
    :cond_459
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    const/high16 v4, 0x3fa0

    cmpl-float v3, v3, v4

    if-lez v3, :cond_3f4

    .line 6178
    const/4 v3, 0x4

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mSnapScrollMode:I

    .line 6179
    if-lez v16, :cond_47f

    const/4 v3, 0x1

    :goto_46b
    move-object/from16 v0, p0

    iput-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSnapPositive:Z

    .line 6180
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    const/high16 v4, 0x4000

    add-float/2addr v3, v4

    const/high16 v4, 0x4000

    div-float/2addr v3, v4

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mAverageAngle:F

    goto/16 :goto_3f4

    .line 6179
    :cond_47f
    const/4 v3, 0x0

    goto :goto_46b

    .line 6187
    :cond_481
    const/4 v15, 0x0

    goto :goto_405

    .line 6193
    :cond_483
    const/4 v3, 0x2

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mHeldMotionless:I

    .line 6194
    const/16 v24, 0x1

    goto :goto_415

    .line 6203
    .restart local v10       #allDrag:Z
    :cond_48b
    int-to-float v3, v15

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v4}, Landroid/webkit/ZoomManager;->getInvScale()F

    move-result v4

    mul-float/2addr v3, v4

    float-to-double v3, v3

    invoke-static {v3, v4}, Ljava/lang/Math;->floor(D)D

    move-result-wide v3

    double-to-int v11, v3

    .line 6204
    .local v11, contentDeltaX:I
    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v26

    .line 6205
    .local v26, roundedDeltaX:I
    move/from16 v0, v16

    int-to-float v3, v0

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v4}, Landroid/webkit/ZoomManager;->getInvScale()F

    move-result v4

    mul-float/2addr v3, v4

    float-to-double v3, v3

    invoke-static {v3, v4}, Ljava/lang/Math;->floor(D)D

    move-result-wide v3

    double-to-int v12, v3

    .line 6206
    .local v12, contentDeltaY:I
    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v27

    .line 6207
    .local v27, roundedDeltaY:I
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mLastTouchX:I

    sub-int v3, v3, v26

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mLastTouchX:I

    .line 6208
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mLastTouchY:I

    sub-int v3, v3, v27

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mLastTouchY:I

    goto/16 :goto_4b

    .line 6215
    .end local v10           #allDrag:Z
    .end local v11           #contentDeltaX:I
    .end local v12           #contentDeltaY:I
    .end local v24           #keepScrollBarsVisible:Z
    .end local v26           #roundedDeltaX:I
    .end local v27           #roundedDeltaY:I
    :pswitch_4cf
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->endScrollEdit()V

    .line 6216
    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mConfirmMove:Z

    if-nez v3, :cond_4f2

    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mIsEditingText:Z

    if-eqz v3, :cond_4f2

    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSelectionStarted:Z

    if-eqz v3, :cond_4f2

    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mIsCaretSelection:Z

    if-eqz v3, :cond_4f2

    .line 6218
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->showPasteWindow()V

    .line 6219
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->stopTouch()V

    goto/16 :goto_4b

    .line 6222
    :cond_4f2
    move-wide/from16 v0, v18

    move-object/from16 v2, p0

    iput-wide v0, v2, Landroid/webkit/WebViewClassic;->mLastTouchUpTime:J

    .line 6223
    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSentAutoScrollMessage:Z

    if-eqz v3, :cond_507

    .line 6224
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mAutoScrollY:I

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mAutoScrollX:I

    .line 6226
    :cond_507
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    packed-switch v3, :pswitch_data_61a

    .line 6295
    :cond_50e
    :goto_50e
    :pswitch_50e
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->stopTouch()V

    goto/16 :goto_4b

    .line 6228
    :pswitch_513
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v4, 0x3

    invoke-virtual {v3, v4}, Landroid/os/Handler;->removeMessages(I)V

    .line 6229
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v4, 0x4

    invoke-virtual {v3, v4}, Landroid/os/Handler;->removeMessages(I)V

    .line 6230
    const/4 v3, 0x7

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    goto :goto_50e

    .line 6235
    :pswitch_529
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v4, 0x3

    invoke-virtual {v3, v4}, Landroid/os/Handler;->removeMessages(I)V

    .line 6236
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v4, 0x4

    invoke-virtual {v3, v4}, Landroid/os/Handler;->removeMessages(I)V

    .line 6237
    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mConfirmMove:Z

    if-nez v3, :cond_570

    .line 6238
    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-eqz v3, :cond_54f

    .line 6240
    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSelectionStarted:Z

    if-nez v3, :cond_50e

    .line 6241
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->selectionDone()V

    goto :goto_50e

    .line 6247
    :cond_54f
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_50e

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->canZoomIn()Z

    move-result v3

    if-nez v3, :cond_562

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->canZoomOut()Z

    move-result v3

    if-eqz v3, :cond_50e

    .line 6249
    :cond_562
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v4, 0x5

    invoke-static {}, Landroid/view/ViewConfiguration;->getDoubleTapTimeout()I

    move-result v5

    int-to-long v5, v5

    invoke-virtual {v3, v4, v5, v6}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_50e

    .line 6258
    :cond_570
    :pswitch_570
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/os/Handler;->removeMessages(I)V

    .line 6261
    move-object/from16 v0, p0

    iget-wide v3, v0, Landroid/webkit/WebViewClassic;->mLastTouchTime:J

    sub-long v3, v18, v3

    const-wide/16 v5, 0xfa

    cmp-long v3, v3, v5

    if-gtz v3, :cond_5a7

    .line 6262
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-nez v3, :cond_59d

    .line 6263
    const-string/jumbo v3, "webview"

    const-string v4, "Got null mVelocityTracker"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 6270
    :goto_593
    const/4 v3, 0x3

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mHeldMotionless:I

    .line 6271
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->doFling()V

    goto/16 :goto_50e

    .line 6265
    :cond_59d
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v0, p1

    invoke-virtual {v3, v0}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    goto :goto_593

    .line 6274
    :cond_5a7
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v4

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v5

    const/4 v6, 0x0

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollX()I

    move-result v7

    const/4 v8, 0x0

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollY()I

    move-result v9

    invoke-virtual/range {v3 .. v9}, Landroid/widget/OverScroller;->springBack(IIIIII)Z

    move-result v3

    if-eqz v3, :cond_5c6

    .line 6277
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 6281
    :cond_5c6
    const/4 v3, 0x2

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mHeldMotionless:I

    .line 6282
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 6288
    :pswitch_5ce
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput v3, v0, Landroid/webkit/WebViewClassic;->mLastVelocity:F

    .line 6289
    invoke-static {}, Landroid/webkit/WebViewCore;->resumePriority()V

    .line 6290
    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-nez v3, :cond_50e

    .line 6291
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-static {v3}, Landroid/webkit/WebViewCore;->resumeUpdatePicture(Landroid/webkit/WebViewCore;)V

    goto/16 :goto_50e

    .line 6299
    :pswitch_5e5
    move-object/from16 v0, p0

    iget v3, v0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/4 v4, 0x3

    if-ne v3, v4, :cond_608

    .line 6300
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v4

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v5

    const/4 v6, 0x0

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollX()I

    move-result v7

    const/4 v8, 0x0

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollY()I

    move-result v9

    invoke-virtual/range {v3 .. v9}, Landroid/widget/OverScroller;->springBack(IIIIII)Z

    .line 6302
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 6304
    :cond_608
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->cancelTouch()V

    goto/16 :goto_4b

    .line 5977
    nop

    :pswitch_data_60e
    .packed-switch 0x0
        :pswitch_4c
        :pswitch_4cf
        :pswitch_206
        :pswitch_5e5
    .end packed-switch

    .line 6226
    :pswitch_data_61a
    .packed-switch 0x1
        :pswitch_529
        :pswitch_5ce
        :pswitch_570
        :pswitch_529
        :pswitch_529
        :pswitch_513
        :pswitch_50e
        :pswitch_50e
        :pswitch_570
        :pswitch_570
    .end packed-switch
.end method

.method private hideFloatView()V
    .registers 3
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_METHOD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    .line 5889
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mCopyFloatPanel:Landroid/webkit/SelectionFloatPanel;

    if-eqz v0, :cond_a

    .line 5890
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mCopyFloatPanel:Landroid/webkit/SelectionFloatPanel;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/webkit/SelectionFloatPanel;->setVisibility(I)V

    .line 5892
    :cond_a
    return-void
.end method

.method private hidePasteButton()V
    .registers 2

    .prologue
    .line 5273
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mPasteWindow:Landroid/webkit/WebViewClassic$PastePopupWindow;

    if-eqz v0, :cond_9

    .line 5274
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mPasteWindow:Landroid/webkit/WebViewClassic$PastePopupWindow;

    invoke-virtual {v0}, Landroid/webkit/WebViewClassic$PastePopupWindow;->hide()V

    .line 5276
    :cond_9
    return-void
.end method

.method private hideSoftKeyboard()V
    .registers 4

    .prologue
    .line 4848
    invoke-static {}, Landroid/view/inputmethod/InputMethodManager;->peekInstance()Landroid/view/inputmethod/InputMethodManager;

    move-result-object v0

    .line 4849
    .local v0, imm:Landroid/view/inputmethod/InputMethodManager;
    if-eqz v0, :cond_18

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0, v1}, Landroid/view/inputmethod/InputMethodManager;->isActive(Landroid/view/View;)Z

    move-result v1

    if-eqz v1, :cond_18

    .line 4850
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 4852
    :cond_18
    return-void
.end method

.method private inFullScreenMode()Z
    .registers 2

    .prologue
    .line 5822
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mFullScreenHolder:Landroid/webkit/PluginFullScreenHolder;

    if-eqz v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method private init()V
    .registers 7

    .prologue
    const/4 v5, 0x1

    .line 1669
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    invoke-static {v3}, Landroid/webkit/WebViewClassic$OnTrimMemoryListener;->init(Landroid/content/Context;)V

    .line 1670
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/webkit/WebView;->setWillNotDraw(Z)V

    .line 1671
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v3, v5}, Landroid/webkit/WebView;->setClickable(Z)V

    .line 1672
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v3, v5}, Landroid/webkit/WebView;->setLongClickable(Z)V

    .line 1674
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    invoke-static {v3}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    .line 1675
    .local v0, configuration:Landroid/view/ViewConfiguration;
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v2

    .line 1676
    .local v2, slop:I
    mul-int v3, v2, v2

    iput v3, p0, Landroid/webkit/WebViewClassic;->mTouchSlopSquare:I

    .line 1677
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledDoubleTapSlop()I

    move-result v2

    .line 1678
    mul-int v3, v2, v2

    iput v3, p0, Landroid/webkit/WebViewClassic;->mDoubleTapSlopSquare:I

    .line 1679
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v1, v3, Landroid/util/DisplayMetrics;->density:F

    .line 1682
    .local v1, density:F
    const/high16 v3, 0x4180

    mul-float/2addr v3, v1

    float-to-int v3, v3

    iput v3, p0, Landroid/webkit/WebViewClassic;->mNavSlop:I

    .line 1683
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v3, v1}, Landroid/webkit/ZoomManager;->init(F)V

    .line 1684
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMaximumFlingVelocity()I

    move-result v3

    iput v3, p0, Landroid/webkit/WebViewClassic;->mMaximumFling:I

    .line 1687
    const/high16 v3, 0x3f80

    mul-float v4, v1, v1

    div-float/2addr v3, v4

    iput v3, p0, Landroid/webkit/WebViewClassic;->DRAG_LAYER_INVERSE_DENSITY_SQUARED:F

    .line 1689
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledOverscrollDistance()I

    move-result v3

    iput v3, p0, Landroid/webkit/WebViewClassic;->mOverscrollDistance:I

    .line 1690
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledOverflingDistance()I

    move-result v3

    iput v3, p0, Landroid/webkit/WebViewClassic;->mOverflingDistance:I

    .line 1692
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v3}, Landroid/webkit/WebView$PrivateAccess;->super_getScrollBarStyle()I

    move-result v3

    invoke-virtual {p0, v3}, Landroid/webkit/WebViewClassic;->setScrollBarStyle(I)V

    .line 1695
    new-instance v3, Ljava/util/Vector;

    const/4 v4, 0x2

    invoke-direct {v3, v4}, Ljava/util/Vector;-><init>(I)V

    iput-object v3, p0, Landroid/webkit/WebViewClassic;->mKeysPressed:Ljava/util/Vector;

    .line 1696
    const/4 v3, 0x0

    iput-object v3, p0, Landroid/webkit/WebViewClassic;->mHTML5VideoViewProxy:Landroid/webkit/HTML5VideoViewProxy;

    .line 1697
    return-void
.end method

.method private invalidateContentRect(Landroid/graphics/Rect;)V
    .registers 6
    .parameter "r"

    .prologue
    .line 3068
    iget v0, p1, Landroid/graphics/Rect;->left:I

    iget v1, p1, Landroid/graphics/Rect;->top:I

    iget v2, p1, Landroid/graphics/Rect;->right:I

    iget v3, p1, Landroid/graphics/Rect;->bottom:I

    invoke-direct {p0, v0, v1, v2, v3}, Landroid/webkit/WebViewClassic;->viewInvalidate(IIII)V

    .line 3069
    return-void
.end method

.method private isAccessibilityEnabled()Z
    .registers 2

    .prologue
    .line 1782
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/accessibility/AccessibilityManager;->getInstance(Landroid/content/Context;)Landroid/view/accessibility/AccessibilityManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v0

    return v0
.end method

.method private isEnterActionKey(I)Z
    .registers 3
    .parameter "keyCode"

    .prologue
    .line 5009
    const/16 v0, 0x17

    if-eq p1, v0, :cond_c

    const/16 v0, 0x42

    if-eq p1, v0, :cond_c

    const/16 v0, 0xa0

    if-ne p1, v0, :cond_e

    :cond_c
    const/4 v0, 0x1

    :goto_d
    return v0

    :cond_e
    const/4 v0, 0x0

    goto :goto_d
.end method

.method private isScrollableForAccessibility()Z
    .registers 4

    .prologue
    .line 1793
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getContentWidth()I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->contentToViewX(I)I

    move-result v0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getWidth()I

    move-result v1

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->getPaddingLeft()I

    move-result v2

    sub-int/2addr v1, v2

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->getPaddingRight()I

    move-result v2

    sub-int/2addr v1, v2

    if-gt v0, v1, :cond_38

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getContentHeight()I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getHeight()I

    move-result v1

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->getPaddingTop()I

    move-result v2

    sub-int/2addr v1, v2

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->getPaddingBottom()I

    move-result v2

    sub-int/2addr v1, v2

    if-le v0, v1, :cond_3a

    :cond_38
    const/4 v0, 0x1

    :goto_39
    return v0

    :cond_3a
    const/4 v0, 0x0

    goto :goto_39
.end method

.method private keyCodeToSoundsEffect(I)I
    .registers 3
    .parameter "keyCode"

    .prologue
    .line 6733
    packed-switch p1, :pswitch_data_e

    .line 6743
    const/4 v0, 0x0

    :goto_4
    return v0

    .line 6735
    :pswitch_5
    const/4 v0, 0x2

    goto :goto_4

    .line 6737
    :pswitch_7
    const/4 v0, 0x3

    goto :goto_4

    .line 6739
    :pswitch_9
    const/4 v0, 0x4

    goto :goto_4

    .line 6741
    :pswitch_b
    const/4 v0, 0x1

    goto :goto_4

    .line 6733
    nop

    :pswitch_data_e
    .packed-switch 0x13
        :pswitch_5
        :pswitch_9
        :pswitch_b
        :pswitch_7
    .end packed-switch
.end method

.method private letPageHandleNavKey(IJZI)V
    .registers 18
    .parameter "keyCode"
    .parameter "time"
    .parameter "down"
    .parameter "metaState"

    .prologue
    .line 8543
    if-eqz p4, :cond_1c

    .line 8544
    const/4 v5, 0x0

    .line 8549
    .local v5, keyEventAction:I
    :goto_3
    new-instance v0, Landroid/view/KeyEvent;

    const/4 v7, 0x1

    and-int/lit8 v1, p5, 0x1

    and-int/lit8 v2, p5, 0x2

    or-int/2addr v1, v2

    and-int/lit8 v2, p5, 0x4

    or-int v8, v1, v2

    const/4 v9, -0x1

    const/4 v10, 0x0

    const/4 v11, 0x0

    move-wide v1, p2

    move-wide v3, p2

    move v6, p1

    invoke-direct/range {v0 .. v11}, Landroid/view/KeyEvent;-><init>(JJIIIIIII)V

    .line 8554
    .local v0, event:Landroid/view/KeyEvent;
    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->sendKeyEvent(Landroid/view/KeyEvent;)V

    .line 8555
    return-void

    .line 8546
    .end local v0           #event:Landroid/view/KeyEvent;
    .end local v5           #keyEventAction:I
    :cond_1c
    const/4 v5, 0x1

    .restart local v5       #keyEventAction:I
    goto :goto_3
.end method

.method private loadDataImpl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 6
    .parameter "data"
    .parameter "mimeType"
    .parameter "encoding"

    .prologue
    .line 2557
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "data:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 2558
    .local v0, dataUrl:Ljava/lang/StringBuilder;
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 2559
    const-string v1, "base64"

    invoke-virtual {v1, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_17

    .line 2560
    const-string v1, ";base64"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 2562
    :cond_17
    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 2563
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 2564
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Landroid/webkit/WebViewClassic;->loadUrlImpl(Ljava/lang/String;)V

    .line 2565
    return-void
.end method

.method private loadUrlImpl(Ljava/lang/String;)V
    .registers 3
    .parameter "url"

    .prologue
    .line 2525
    if-nez p1, :cond_3

    .line 2529
    :goto_2
    return-void

    .line 2528
    :cond_3
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/webkit/WebViewClassic;->loadUrlImpl(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_2
.end method

.method private loadUrlImpl(Ljava/lang/String;Ljava/util/Map;)V
    .registers 6
    .parameter "url"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 2508
    .local p2, extraHeaders:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->switchOutDrawHistory()V

    .line 2509
    new-instance v0, Landroid/webkit/WebViewCore$GetUrlData;

    invoke-direct {v0}, Landroid/webkit/WebViewCore$GetUrlData;-><init>()V

    .line 2510
    .local v0, arg:Landroid/webkit/WebViewCore$GetUrlData;
    iput-object p1, v0, Landroid/webkit/WebViewCore$GetUrlData;->mUrl:Ljava/lang/String;

    .line 2511
    iput-object p2, v0, Landroid/webkit/WebViewCore$GetUrlData;->mExtraHeaders:Ljava/util/Map;

    .line 2512
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v2, 0x64

    invoke-virtual {v1, v2, v0}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 2513
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->clearHelpers()V

    .line 2514
    return-void
.end method

.method private native nativeCopyBaseContentToPicture(Landroid/graphics/Picture;)V
.end method

.method private native nativeCreate(ILjava/lang/String;Z)V
.end method

.method private native nativeCreateDrawGLFunction(ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/RectF;FI)I
.end method

.method private native nativeDebugDump()V
.end method

.method private static native nativeDestroy(I)V
.end method

.method private native nativeDiscardAllTextures()V
.end method

.method private native nativeDraw(Landroid/graphics/Canvas;Landroid/graphics/RectF;II)V
.end method

.method private native nativeDumpDisplayTree(Ljava/lang/String;)V
.end method

.method private native nativeEvaluateLayersAnimations(I)Z
.end method

.method private static native nativeFindMaxVisibleRect(IILandroid/graphics/Rect;)V
.end method

.method private native nativeGetBackgroundColor(I)I
.end method

.method private native nativeGetBaseLayer(I)I
.end method

.method private native nativeGetDrawGLFunction(I)I
.end method

.method private static native nativeGetHandleLayerId(IILandroid/graphics/Point;Landroid/webkit/QuadF;)I
.end method

.method private native nativeGetSelection()Ljava/lang/String;
.end method

.method private native nativeHasContent()Z
.end method

.method private static native nativeMapLayerRect(IILandroid/graphics/Rect;)V
.end method

.method private static native nativeOnTrimMemory(I)V
.end method

.method private native nativeScrollLayer(IIII)Z
.end method

.method private native nativeScrollableLayer(IIILandroid/graphics/Rect;Landroid/graphics/Rect;)I
.end method

.method private native nativeSetBaseLayer(IIZZI)Z
.end method

.method private native nativeSetHeightCanMeasure(Z)V
.end method

.method private static native nativeSetHwAccelerated(IZ)I
.end method

.method private native nativeSetIsScrolling(Z)V
.end method

.method private static native nativeSetPauseDrawing(IZ)V
.end method

.method private static native nativeSetTextSelection(II)V
.end method

.method private native nativeStopGL(I)V
.end method

.method private native nativeTileProfilingClear()V
.end method

.method private native nativeTileProfilingGetFloat(IILjava/lang/String;)F
.end method

.method private native nativeTileProfilingGetInt(IILjava/lang/String;)I
.end method

.method private native nativeTileProfilingNumFrames()I
.end method

.method private native nativeTileProfilingNumTilesInFrame(I)I
.end method

.method private native nativeTileProfilingStart()V
.end method

.method private native nativeTileProfilingStop()F
.end method

.method private native nativeUpdateDrawGLFunction(ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/RectF;F)V
.end method

.method private native nativeUseHardwareAccelSkia(Z)V
.end method

.method private onHandleUiEvent(Landroid/view/MotionEvent;II)V
    .registers 8
    .parameter "event"
    .parameter "eventType"
    .parameter "flags"

    .prologue
    .line 1353
    packed-switch p2, :pswitch_data_3a

    .line 1373
    :cond_3
    :goto_3
    :pswitch_3
    return-void

    .line 1355
    :pswitch_4
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getHitTestResult()Landroid/webkit/WebView$HitTestResult;

    move-result-object v0

    .line 1356
    .local v0, hitTest:Landroid/webkit/WebView$HitTestResult;
    if-eqz v0, :cond_3

    .line 1357
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->performLongClick()Z

    goto :goto_3

    .line 1361
    .end local v0           #hitTest:Landroid/webkit/WebView$HitTestResult;
    :pswitch_10
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/webkit/ZoomManager;->handleDoubleTap(FF)V

    goto :goto_3

    .line 1364
    :pswitch_1e
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->onHandleUiTouchEvent(Landroid/view/MotionEvent;)V

    goto :goto_3

    .line 1367
    :pswitch_22
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    if-eqz v1, :cond_3

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget-object v1, v1, Landroid/webkit/WebViewCore$WebKitHitTest;->mIntentUrl:Ljava/lang/String;

    if-eqz v1, :cond_3

    .line 1368
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->playSoundEffect(I)V

    .line 1369
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget-object v1, v1, Landroid/webkit/WebViewCore$WebKitHitTest;->mIntentUrl:Ljava/lang/String;

    invoke-direct {p0, v1}, Landroid/webkit/WebViewClassic;->overrideLoading(Ljava/lang/String;)V

    goto :goto_3

    .line 1353
    :pswitch_data_3a
    .packed-switch 0x0
        :pswitch_1e
        :pswitch_3
        :pswitch_3
        :pswitch_4
        :pswitch_22
        :pswitch_10
    .end packed-switch
.end method

.method private onHandleUiTouchEvent(Landroid/view/MotionEvent;)V
    .registers 10
    .parameter "ev"

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x0

    .line 1376
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v4}, Landroid/webkit/ZoomManager;->getMultiTouchGestureDetector()Landroid/view/ScaleGestureDetector;

    move-result-object v1

    .line 1379
    .local v1, detector:Landroid/view/ScaleGestureDetector;
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    .line 1380
    .local v2, x:F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    .line 1382
    .local v3, y:F
    if-eqz v1, :cond_4a

    .line 1383
    invoke-virtual {v1, p1}, Landroid/view/ScaleGestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 1384
    invoke-virtual {v1}, Landroid/view/ScaleGestureDetector;->isInProgress()Z

    move-result v4

    if-eqz v4, :cond_4a

    .line 1385
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v4

    iput-wide v4, p0, Landroid/webkit/WebViewClassic;->mLastTouchTime:J

    .line 1386
    invoke-virtual {v1}, Landroid/view/ScaleGestureDetector;->getFocusX()F

    move-result v2

    .line 1387
    invoke-virtual {v1}, Landroid/view/ScaleGestureDetector;->getFocusY()F

    move-result v3

    .line 1389
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v4}, Landroid/webkit/WebView;->cancelLongPress()V

    .line 1390
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v5, 0x4

    invoke-virtual {v4, v5}, Landroid/os/Handler;->removeMessages(I)V

    .line 1391
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v4}, Landroid/webkit/ZoomManager;->supportsPanDuringZoom()Z

    move-result v4

    if-nez v4, :cond_3d

    .line 1417
    :cond_3c
    :goto_3c
    return-void

    .line 1394
    :cond_3d
    const/4 v4, 0x3

    iput v4, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    .line 1395
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-nez v4, :cond_4a

    .line 1396
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v4

    iput-object v4, p0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 1401
    :cond_4a
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    .line 1402
    .local v0, action:I
    const/4 v4, 0x5

    if-ne v0, v4, :cond_61

    .line 1403
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->cancelTouch()V

    .line 1404
    const/4 v0, 0x0

    .line 1416
    :cond_55
    :goto_55
    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v4

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v5

    invoke-direct {p0, p1, v0, v4, v5}, Landroid/webkit/WebViewClassic;->handleTouchEventCommon(Landroid/view/MotionEvent;III)V

    goto :goto_3c

    .line 1405
    :cond_61
    const/4 v4, 0x6

    if-ne v0, v4, :cond_77

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v4

    if-lt v4, v7, :cond_77

    .line 1407
    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v4

    iput v4, p0, Landroid/webkit/WebViewClassic;->mLastTouchX:I

    .line 1408
    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v4

    iput v4, p0, Landroid/webkit/WebViewClassic;->mLastTouchY:I

    goto :goto_55

    .line 1409
    :cond_77
    if-ne v0, v7, :cond_55

    .line 1411
    cmpg-float v4, v2, v6

    if-ltz v4, :cond_3c

    cmpg-float v4, v3, v6

    if-gez v4, :cond_55

    goto :goto_3c
.end method

.method private onZoomAnimationEnd()V
    .registers 3

    .prologue
    .line 4488
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/16 v1, 0x92

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 4489
    return-void
.end method

.method private onZoomAnimationStart()V
    .registers 2

    .prologue
    .line 4482
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-nez v0, :cond_11

    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHandleAlpha:Landroid/webkit/WebViewClassic$SelectionHandleAlpha;

    invoke-virtual {v0}, Landroid/webkit/WebViewClassic$SelectionHandleAlpha;->getAlpha()I

    move-result v0

    if-lez v0, :cond_11

    .line 4483
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHandleAlphaAnimator:Landroid/animation/ObjectAnimator;

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->end()V

    .line 4485
    :cond_11
    return-void
.end method

.method private overrideLoading(Ljava/lang/String;)V
    .registers 3
    .parameter "url"

    .prologue
    .line 7095
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v0, p1}, Landroid/webkit/CallbackProxy;->uiOverrideUrlLoading(Ljava/lang/String;)Z

    .line 7096
    return-void
.end method

.method static pinLoc(III)I
    .registers 4
    .parameter "x"
    .parameter "viewMax"
    .parameter "docMax"

    .prologue
    .line 2928
    if-ge p2, p1, :cond_4

    .line 2930
    const/4 p0, 0x0

    .line 2939
    :cond_3
    :goto_3
    return p0

    .line 2932
    :cond_4
    if-gez p0, :cond_8

    .line 2933
    const/4 p0, 0x0

    goto :goto_3

    .line 2935
    :cond_8
    add-int v0, p0, p1

    if-le v0, p2, :cond_3

    .line 2936
    sub-int p0, p2, p1

    goto :goto_3
.end method

.method private pinScrollBy(IIZI)Z
    .registers 7
    .parameter "dx"
    .parameter "dy"
    .parameter "animate"
    .parameter "animationDuration"

    .prologue
    .line 3897
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v0

    add-int/2addr v0, p1

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v1

    add-int/2addr v1, p2

    invoke-direct {p0, v0, v1, p3, p4}, Landroid/webkit/WebViewClassic;->pinScrollTo(IIZI)Z

    move-result v0

    return v0
.end method

.method private pinScrollTo(IIZI)Z
    .registers 11
    .parameter "x"
    .parameter "y"
    .parameter "animate"
    .parameter "animationDuration"

    .prologue
    .line 3902
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->abortAnimation()V

    .line 3903
    invoke-virtual {p0, p1}, Landroid/webkit/WebViewClassic;->pinLocX(I)I

    move-result p1

    .line 3904
    invoke-virtual {p0, p2}, Landroid/webkit/WebViewClassic;->pinLocY(I)I

    move-result p2

    .line 3905
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v0

    sub-int v3, p1, v0

    .line 3906
    .local v3, dx:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v0

    sub-int v4, p2, v0

    .line 3908
    .local v4, dy:I
    or-int v0, v3, v4

    if-nez v0, :cond_1d

    .line 3909
    const/4 v0, 0x0

    .line 3919
    :goto_1c
    return v0

    .line 3911
    :cond_1d
    if-eqz p3, :cond_39

    .line 3913
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v1

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v2

    if-lez p4, :cond_34

    move v5, p4

    :goto_2c
    invoke-virtual/range {v0 .. v5}, Landroid/widget/OverScroller;->startScroll(IIIII)V

    .line 3915
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 3919
    :goto_32
    const/4 v0, 0x1

    goto :goto_1c

    .line 3913
    :cond_34
    invoke-static {v3, v4}, Landroid/webkit/WebViewClassic;->computeDuration(II)I

    move-result v5

    goto :goto_2c

    .line 3917
    :cond_39
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0, p1, p2}, Landroid/webkit/WebView;->scrollTo(II)V

    goto :goto_32
.end method

.method private postInvalidate()V
    .registers 2

    .prologue
    .line 8734
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->postInvalidate()V

    .line 8735
    return-void
.end method

.method private recordNewContentSize(IIZ)V
    .registers 6
    .parameter "w"
    .parameter "h"
    .parameter "updateLayout"

    .prologue
    .line 3083
    or-int v0, p1, p2

    if-nez v0, :cond_8

    .line 3084
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 3108
    :goto_7
    return-void

    .line 3089
    :cond_8
    iget v0, p0, Landroid/webkit/WebViewClassic;->mContentWidth:I

    if-ne v0, p1, :cond_10

    iget v0, p0, Landroid/webkit/WebViewClassic;->mContentHeight:I

    if-eq v0, p2, :cond_54

    .line 3091
    :cond_10
    iput p1, p0, Landroid/webkit/WebViewClassic;->mContentWidth:I

    .line 3092
    iput p2, p0, Landroid/webkit/WebViewClassic;->mContentHeight:I

    .line 3095
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mDrawHistory:Z

    if-nez v0, :cond_51

    .line 3097
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->pinLocX(I)I

    move-result v0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v1

    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->pinLocY(I)I

    move-result v1

    invoke-virtual {p0, v0, v1}, Landroid/webkit/WebViewClassic;->updateScrollCoordinates(II)Z

    .line 3098
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v0}, Landroid/widget/OverScroller;->isFinished()Z

    move-result v0

    if-nez v0, :cond_51

    .line 3101
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v1}, Landroid/widget/OverScroller;->getFinalX()I

    move-result v1

    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->pinLocX(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/OverScroller;->setFinalX(I)V

    .line 3102
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v1}, Landroid/widget/OverScroller;->getFinalY()I

    move-result v1

    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->pinLocY(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/OverScroller;->setFinalY(I)V

    .line 3105
    :cond_51
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 3107
    :cond_54
    invoke-direct {p0, p3}, Landroid/webkit/WebViewClassic;->contentSizeChanged(Z)V

    goto :goto_7
.end method

.method private relocateAutoCompletePopup()V
    .registers 3

    .prologue
    .line 4818
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mAutoCompletePopup:Landroid/webkit/AutoCompletePopup;

    if-eqz v0, :cond_14

    .line 4819
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mAutoCompletePopup:Landroid/webkit/AutoCompletePopup;

    invoke-virtual {v0}, Landroid/webkit/AutoCompletePopup;->resetRect()V

    .line 4820
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mAutoCompletePopup:Landroid/webkit/AutoCompletePopup;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    invoke-virtual {v1}, Landroid/webkit/WebViewClassic$WebViewInputConnection;->getEditable()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/AutoCompletePopup;->setText(Ljava/lang/CharSequence;)V

    .line 4822
    :cond_14
    return-void
.end method

.method private removeTouchHighlight()V
    .registers 2

    .prologue
    .line 4372
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->setTouchHighlightRects(Landroid/webkit/WebViewCore$WebKitHitTest;)V

    .line 4373
    return-void
.end method

.method private resetCaretTimer()V
    .registers 5
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    const/16 v3, 0x90

    .line 5355
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    invoke-virtual {v0, v3}, Landroid/os/Handler;->removeMessages(I)V

    .line 5356
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mSelectionStarted:Z

    if-nez v0, :cond_12

    .line 5357
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const-wide/16 v1, 0xbb8

    invoke-virtual {v0, v3, v1, v2}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    .line 5360
    :cond_12
    return-void
.end method

.method private restoreHistoryPictureFields(Landroid/graphics/Picture;Landroid/os/Bundle;)V
    .registers 8
    .parameter "p"
    .parameter "b"

    .prologue
    const/4 v4, 0x0

    .line 2320
    const-string/jumbo v3, "scrollX"

    invoke-virtual {p2, v3, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 2321
    .local v1, sx:I
    const-string/jumbo v3, "scrollY"

    invoke-virtual {p2, v3, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v2

    .line 2323
    .local v2, sy:I
    const/4 v3, 0x1

    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mDrawHistory:Z

    .line 2324
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mHistoryPicture:Landroid/graphics/Picture;

    .line 2326
    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->setScrollXRaw(I)V

    .line 2327
    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->setScrollYRaw(I)V

    .line 2328
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v3, p2}, Landroid/webkit/ZoomManager;->restoreZoomState(Landroid/os/Bundle;)V

    .line 2329
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v3}, Landroid/webkit/ZoomManager;->getScale()F

    move-result v0

    .line 2330
    .local v0, scale:F
    invoke-virtual {p1}, Landroid/graphics/Picture;->getWidth()I

    move-result v3

    int-to-float v3, v3

    mul-float/2addr v3, v0

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    iput v3, p0, Landroid/webkit/WebViewClassic;->mHistoryWidth:I

    .line 2331
    invoke-virtual {p1}, Landroid/graphics/Picture;->getHeight()I

    move-result v3

    int-to-float v3, v3

    mul-float/2addr v3, v0

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    iput v3, p0, Landroid/webkit/WebViewClassic;->mHistoryHeight:I

    .line 2333
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 2334
    return-void
.end method

.method private saveWebArchiveImpl(Ljava/lang/String;ZLandroid/webkit/ValueCallback;)V
    .registers 7
    .parameter "basename"
    .parameter "autoname"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z",
            "Landroid/webkit/ValueCallback",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 2620
    .local p3, callback:Landroid/webkit/ValueCallback;,"Landroid/webkit/ValueCallback<Ljava/lang/String;>;"
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x93

    new-instance v2, Landroid/webkit/WebViewClassic$SaveWebArchiveMessage;

    invoke-direct {v2, p1, p2, p3}, Landroid/webkit/WebViewClassic$SaveWebArchiveMessage;-><init>(Ljava/lang/String;ZLandroid/webkit/ValueCallback;)V

    invoke-virtual {v0, v1, v2}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 2622
    return-void
.end method

.method private static scaleAlongSegment(IILandroid/graphics/PointF;Landroid/graphics/PointF;)F
    .registers 13
    .parameter "x"
    .parameter "y"
    .parameter "a"
    .parameter "b"

    .prologue
    .line 5246
    iget v7, p3, Landroid/graphics/PointF;->x:F

    iget v8, p2, Landroid/graphics/PointF;->x:F

    sub-float v2, v7, v8

    .line 5247
    .local v2, abX:F
    iget v7, p3, Landroid/graphics/PointF;->y:F

    iget v8, p2, Landroid/graphics/PointF;->y:F

    sub-float v3, v7, v8

    .line 5248
    .local v3, abY:F
    mul-float v7, v2, v2

    mul-float v8, v3, v3

    add-float v0, v7, v8

    .line 5251
    .local v0, ab2:F
    int-to-float v7, p0

    iget v8, p2, Landroid/graphics/PointF;->x:F

    sub-float v4, v7, v8

    .line 5252
    .local v4, apX:F
    int-to-float v7, p1

    iget v8, p2, Landroid/graphics/PointF;->y:F

    sub-float v5, v7, v8

    .line 5253
    .local v5, apY:F
    mul-float v7, v4, v2

    mul-float v8, v5, v3

    add-float v1, v7, v8

    .line 5254
    .local v1, abDotAP:F
    div-float v6, v1, v0

    .line 5255
    .local v6, scale:F
    return v6
.end method

.method private static scaleCoordinate(FFF)F
    .registers 5
    .parameter "scale"
    .parameter "coord1"
    .parameter "coord2"

    .prologue
    .line 6553
    sub-float v0, p2, p1

    .line 6554
    .local v0, diff:F
    mul-float v1, p0, v0

    add-float/2addr v1, p1

    return v1
.end method

.method private scaleTrackballX(FI)I
    .registers 7
    .parameter "xRate"
    .parameter "width"

    .prologue
    .line 6705
    const/high16 v2, 0x43c8

    div-float v2, p1, v2

    int-to-float v3, p2

    mul-float/2addr v2, v3

    float-to-int v1, v2

    .line 6706
    .local v1, xMove:I
    move v0, v1

    .line 6707
    .local v0, nextXMove:I
    if-lez v1, :cond_14

    .line 6708
    iget v2, p0, Landroid/webkit/WebViewClassic;->mTrackballXMove:I

    if-le v1, v2, :cond_11

    .line 6709
    iget v2, p0, Landroid/webkit/WebViewClassic;->mTrackballXMove:I

    sub-int/2addr v1, v2

    .line 6714
    :cond_11
    :goto_11
    iput v0, p0, Landroid/webkit/WebViewClassic;->mTrackballXMove:I

    .line 6715
    return v1

    .line 6711
    :cond_14
    iget v2, p0, Landroid/webkit/WebViewClassic;->mTrackballXMove:I

    if-ge v1, v2, :cond_11

    .line 6712
    iget v2, p0, Landroid/webkit/WebViewClassic;->mTrackballXMove:I

    sub-int/2addr v1, v2

    goto :goto_11
.end method

.method private scaleTrackballY(FI)I
    .registers 7
    .parameter "yRate"
    .parameter "height"

    .prologue
    .line 6719
    const/high16 v2, 0x43c8

    div-float v2, p1, v2

    int-to-float v3, p2

    mul-float/2addr v2, v3

    float-to-int v1, v2

    .line 6720
    .local v1, yMove:I
    move v0, v1

    .line 6721
    .local v0, nextYMove:I
    if-lez v1, :cond_14

    .line 6722
    iget v2, p0, Landroid/webkit/WebViewClassic;->mTrackballYMove:I

    if-le v1, v2, :cond_11

    .line 6723
    iget v2, p0, Landroid/webkit/WebViewClassic;->mTrackballYMove:I

    sub-int/2addr v1, v2

    .line 6728
    :cond_11
    :goto_11
    iput v0, p0, Landroid/webkit/WebViewClassic;->mTrackballYMove:I

    .line 6729
    return v1

    .line 6725
    :cond_14
    iget v2, p0, Landroid/webkit/WebViewClassic;->mTrackballYMove:I

    if-ge v1, v2, :cond_11

    .line 6726
    iget v2, p0, Landroid/webkit/WebViewClassic;->mTrackballYMove:I

    sub-int/2addr v1, v2

    goto :goto_11
.end method

.method private scrollEditIntoView()V
    .registers 13

    .prologue
    const/4 v11, 0x0

    .line 5694
    new-instance v5, Landroid/graphics/Rect;

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v6

    invoke-virtual {p0, v6}, Landroid/webkit/WebViewClassic;->viewToContentX(I)I

    move-result v6

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v7

    invoke-virtual {p0, v7}, Landroid/webkit/WebViewClassic;->viewToContentY(I)I

    move-result v7

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v8

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getWidth()I

    move-result v9

    add-int/2addr v8, v9

    invoke-virtual {p0, v8}, Landroid/webkit/WebViewClassic;->viewToContentX(I)I

    move-result v8

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v9

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getViewHeightWithTitle()I

    move-result v10

    add-int/2addr v9, v10

    invoke-virtual {p0, v9}, Landroid/webkit/WebViewClassic;->viewToContentY(I)I

    move-result v9

    invoke-direct {v5, v6, v7, v8, v9}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 5698
    .local v5, visibleRect:Landroid/graphics/Rect;
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    invoke-virtual {v5, v6}, Landroid/graphics/Rect;->contains(Landroid/graphics/Rect;)Z

    move-result v6

    if-eqz v6, :cond_39

    .line 5751
    :cond_38
    :goto_38
    return-void

    .line 5701
    :cond_39
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->syncSelectionCursors()V

    .line 5702
    iget v6, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    iget v7, p0, Landroid/webkit/WebViewClassic;->mEditTextLayerId:I

    invoke-static {v6, v7, v5}, Landroid/webkit/WebViewClassic;->nativeFindMaxVisibleRect(IILandroid/graphics/Rect;)V

    .line 5703
    const/4 v6, 0x1

    const/16 v7, 0xa

    invoke-direct {p0, v7}, Landroid/webkit/WebViewClassic;->viewToContentDimension(I)I

    move-result v7

    invoke-static {v6, v7}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 5704
    .local v0, buffer:I
    new-instance v4, Landroid/graphics/Rect;

    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->left:I

    sub-int/2addr v6, v0

    invoke-static {v11, v6}, Ljava/lang/Math;->max(II)I

    move-result v6

    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->top:I

    sub-int/2addr v7, v0

    invoke-static {v11, v7}, Ljava/lang/Math;->max(II)I

    move-result v7

    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    iget v8, v8, Landroid/graphics/Rect;->right:I

    add-int/2addr v8, v0

    iget-object v9, p0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    iget v9, v9, Landroid/graphics/Rect;->bottom:I

    add-int/2addr v9, v0

    invoke-direct {v4, v6, v7, v8, v9}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 5709
    .local v4, showRect:Landroid/graphics/Rect;
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->calculateCaretTop()Landroid/graphics/Point;

    move-result-object v1

    .line 5710
    .local v1, caretTop:Landroid/graphics/Point;
    invoke-virtual {v5}, Landroid/graphics/Rect;->width()I

    move-result v6

    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    invoke-virtual {v7}, Landroid/graphics/Rect;->width()I

    move-result v7

    if-ge v6, v7, :cond_97

    .line 5712
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->x:I

    iget v7, v1, Landroid/graphics/Point;->x:I

    if-ge v6, v7, :cond_ee

    .line 5713
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->x:I

    sub-int/2addr v6, v0

    invoke-static {v11, v6}, Ljava/lang/Math;->max(II)I

    move-result v6

    iput v6, v4, Landroid/graphics/Rect;->left:I

    .line 5714
    iget v6, v1, Landroid/graphics/Point;->x:I

    add-int/2addr v6, v0

    iput v6, v4, Landroid/graphics/Rect;->right:I

    .line 5720
    :cond_97
    :goto_97
    invoke-virtual {v5}, Landroid/graphics/Rect;->height()I

    move-result v6

    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    invoke-virtual {v7}, Landroid/graphics/Rect;->height()I

    move-result v7

    if-ge v6, v7, :cond_bb

    .line 5722
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->y:I

    iget v7, v1, Landroid/graphics/Point;->y:I

    if-le v6, v7, :cond_ff

    .line 5723
    iget v6, v1, Landroid/graphics/Point;->y:I

    sub-int/2addr v6, v0

    invoke-static {v11, v6}, Ljava/lang/Math;->max(II)I

    move-result v6

    iput v6, v4, Landroid/graphics/Rect;->top:I

    .line 5724
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->y:I

    add-int/2addr v6, v0

    iput v6, v4, Landroid/graphics/Rect;->bottom:I

    .line 5731
    :cond_bb
    :goto_bb
    invoke-virtual {v5, v4}, Landroid/graphics/Rect;->contains(Landroid/graphics/Rect;)Z

    move-result v6

    if-nez v6, :cond_38

    .line 5735
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v6

    invoke-virtual {p0, v6}, Landroid/webkit/WebViewClassic;->viewToContentX(I)I

    move-result v2

    .line 5736
    .local v2, scrollX:I
    iget v6, v5, Landroid/graphics/Rect;->left:I

    iget v7, v4, Landroid/graphics/Rect;->left:I

    if-le v6, v7, :cond_110

    .line 5738
    iget v6, v4, Landroid/graphics/Rect;->left:I

    iget v7, v5, Landroid/graphics/Rect;->left:I

    sub-int/2addr v6, v7

    add-int/2addr v2, v6

    .line 5743
    :cond_d5
    :goto_d5
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v6

    invoke-virtual {p0, v6}, Landroid/webkit/WebViewClassic;->viewToContentY(I)I

    move-result v3

    .line 5744
    .local v3, scrollY:I
    iget v6, v5, Landroid/graphics/Rect;->top:I

    iget v7, v4, Landroid/graphics/Rect;->top:I

    if-le v6, v7, :cond_11d

    .line 5745
    iget v6, v4, Landroid/graphics/Rect;->top:I

    iget v7, v5, Landroid/graphics/Rect;->top:I

    sub-int/2addr v6, v7

    add-int/2addr v3, v6

    .line 5750
    :cond_e9
    :goto_e9
    invoke-direct {p0, v2, v3, v11}, Landroid/webkit/WebViewClassic;->contentScrollTo(IIZ)V

    goto/16 :goto_38

    .line 5716
    .end local v2           #scrollX:I
    .end local v3           #scrollY:I
    :cond_ee
    iget v6, v1, Landroid/graphics/Point;->x:I

    sub-int/2addr v6, v0

    invoke-static {v11, v6}, Ljava/lang/Math;->max(II)I

    move-result v6

    iput v6, v4, Landroid/graphics/Rect;->left:I

    .line 5717
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->x:I

    add-int/2addr v6, v0

    iput v6, v4, Landroid/graphics/Rect;->right:I

    goto :goto_97

    .line 5726
    :cond_ff
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->y:I

    sub-int/2addr v6, v0

    invoke-static {v11, v6}, Ljava/lang/Math;->max(II)I

    move-result v6

    iput v6, v4, Landroid/graphics/Rect;->top:I

    .line 5727
    iget v6, v1, Landroid/graphics/Point;->y:I

    add-int/2addr v6, v0

    iput v6, v4, Landroid/graphics/Rect;->bottom:I

    goto :goto_bb

    .line 5739
    .restart local v2       #scrollX:I
    :cond_110
    iget v6, v5, Landroid/graphics/Rect;->right:I

    iget v7, v4, Landroid/graphics/Rect;->right:I

    if-ge v6, v7, :cond_d5

    .line 5741
    iget v6, v4, Landroid/graphics/Rect;->right:I

    iget v7, v5, Landroid/graphics/Rect;->right:I

    sub-int/2addr v6, v7

    add-int/2addr v2, v6

    goto :goto_d5

    .line 5746
    .restart local v3       #scrollY:I
    :cond_11d
    iget v6, v5, Landroid/graphics/Rect;->bottom:I

    iget v7, v4, Landroid/graphics/Rect;->bottom:I

    if-ge v6, v7, :cond_e9

    .line 5747
    iget v6, v4, Landroid/graphics/Rect;->bottom:I

    iget v7, v5, Landroid/graphics/Rect;->bottom:I

    sub-int/2addr v6, v7

    add-int/2addr v3, v6

    goto :goto_e9
.end method

.method private scrollEditText(II)V
    .registers 9
    .parameter "scrollX"
    .parameter "scrollY"

    .prologue
    .line 8152
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getMaxTextScrollX()I

    move-result v2

    int-to-float v0, v2

    .line 8153
    .local v0, maxScrollX:F
    int-to-float v2, p1

    div-float v1, v2, v0

    .line 8154
    .local v1, scrollPercentX:F
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mEditTextContent:Landroid/graphics/Rect;

    neg-int v3, p1

    neg-int v4, p2

    invoke-virtual {v2, v3, v4}, Landroid/graphics/Rect;->offsetTo(II)V

    .line 8155
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v3, 0x63

    const/4 v4, 0x0

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    invoke-virtual {v2, v3, v4, p2, v5}, Landroid/webkit/WebViewCore;->sendMessageAtFrontOfQueue(IIILjava/lang/Object;)V

    .line 8157
    return-void
.end method

.method private scrollEditWithCursor()V
    .registers 20

    .prologue
    .line 6353
    move-object/from16 v0, p0

    iget-wide v15, v0, Landroid/webkit/WebViewClassic;->mLastEditScroll:J

    const-wide/16 v17, 0x0

    cmp-long v15, v15, v17

    if-eqz v15, :cond_81

    .line 6354
    move-object/from16 v0, p0

    iget v15, v0, Landroid/webkit/WebViewClassic;->mLastTouchX:I

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v16

    add-int v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingOffset:Landroid/graphics/Point;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v16, v0

    add-int v15, v15, v16

    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Landroid/webkit/WebViewClassic;->viewToContentX(I)I

    move-result v13

    .line 6355
    .local v13, x:I
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    iget v15, v15, Landroid/graphics/Rect;->left:I

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v16, v0

    move/from16 v0, v16

    invoke-static {v13, v15, v0}, Landroid/webkit/WebViewClassic;->getTextScrollSpeed(III)F

    move-result v7

    .line 6357
    .local v7, scrollSpeedX:F
    move-object/from16 v0, p0

    iget v15, v0, Landroid/webkit/WebViewClassic;->mLastTouchY:I

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v16

    add-int v15, v15, v16

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingOffset:Landroid/graphics/Point;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget v0, v0, Landroid/graphics/Point;->y:I

    move/from16 v16, v0

    add-int v15, v15, v16

    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Landroid/webkit/WebViewClassic;->viewToContentY(I)I

    move-result v14

    .line 6358
    .local v14, y:I
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    iget v15, v15, Landroid/graphics/Rect;->top:I

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    move/from16 v16, v0

    invoke-static/range {v14 .. v16}, Landroid/webkit/WebViewClassic;->getTextScrollSpeed(III)F

    move-result v8

    .line 6360
    .local v8, scrollSpeedY:F
    const/4 v15, 0x0

    cmpl-float v15, v7, v15

    if-nez v15, :cond_82

    const/4 v15, 0x0

    cmpl-float v15, v8, v15

    if-nez v15, :cond_82

    .line 6361
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->endScrollEdit()V

    .line 6388
    .end local v7           #scrollSpeedX:F
    .end local v8           #scrollSpeedY:F
    .end local v13           #x:I
    .end local v14           #y:I
    :cond_81
    :goto_81
    return-void

    .line 6363
    .restart local v7       #scrollSpeedX:F
    .restart local v8       #scrollSpeedY:F
    .restart local v13       #x:I
    .restart local v14       #y:I
    :cond_82
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v1

    .line 6364
    .local v1, currentTime:J
    move-object/from16 v0, p0

    iget-wide v15, v0, Landroid/webkit/WebViewClassic;->mLastEditScroll:J

    sub-long v11, v1, v15

    .line 6365
    .local v11, timeSinceLastUpdate:J
    invoke-static {v7, v11, v12}, Landroid/webkit/WebViewClassic;->getTextScrollDelta(FJ)I

    move-result v5

    .line 6366
    .local v5, deltaX:I
    invoke-static {v8, v11, v12}, Landroid/webkit/WebViewClassic;->getTextScrollDelta(FJ)I

    move-result v6

    .line 6367
    .local v6, deltaY:I
    move-object/from16 v0, p0

    iput-wide v1, v0, Landroid/webkit/WebViewClassic;->mLastEditScroll:J

    .line 6368
    if-nez v5, :cond_a8

    if-nez v6, :cond_a8

    .line 6370
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/16 v16, 0x95

    const-wide/16 v17, 0x10

    invoke-virtual/range {v15 .. v18}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_81

    .line 6373
    :cond_a8
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getTextScrollX()I

    move-result v15

    add-int v9, v15, v5

    .line 6374
    .local v9, scrollX:I
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getMaxTextScrollX()I

    move-result v15

    invoke-static {v15, v9}, Ljava/lang/Math;->min(II)I

    move-result v9

    .line 6375
    const/4 v15, 0x0

    invoke-static {v15, v9}, Ljava/lang/Math;->max(II)I

    move-result v9

    .line 6376
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getTextScrollY()I

    move-result v15

    add-int v10, v15, v6

    .line 6377
    .local v10, scrollY:I
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getMaxTextScrollY()I

    move-result v15

    invoke-static {v15, v10}, Ljava/lang/Math;->min(II)I

    move-result v10

    .line 6378
    const/4 v15, 0x0

    invoke-static {v15, v10}, Ljava/lang/Math;->max(II)I

    move-result v10

    .line 6379
    move-object/from16 v0, p0

    invoke-direct {v0, v9, v10}, Landroid/webkit/WebViewClassic;->scrollEditText(II)V

    .line 6380
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    iget v3, v15, Landroid/graphics/Point;->x:I

    .line 6381
    .local v3, cursorX:I
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    iget v4, v15, Landroid/graphics/Point;->y:I

    .line 6382
    .local v4, cursorY:I
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    sub-int v16, v13, v5

    sub-int v17, v14, v6

    invoke-virtual/range {v15 .. v17}, Landroid/graphics/Point;->set(II)V

    .line 6383
    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->updateWebkitSelection()V

    .line 6384
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    invoke-virtual {v15, v3, v4}, Landroid/graphics/Point;->set(II)V

    goto :goto_81
.end method

.method private scrollLayerTo(II)V
    .registers 10
    .parameter "x"
    .parameter "y"

    .prologue
    .line 3856
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->left:I

    sub-int v0, v2, p1

    .line 3857
    .local v0, dx:I
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->top:I

    sub-int v1, v2, p2

    .line 3858
    .local v1, dy:I
    if-nez v0, :cond_10

    if-eqz v1, :cond_14

    :cond_10
    iget v2, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v2, :cond_15

    .line 3886
    :cond_14
    :goto_14
    return-void

    .line 3861
    :cond_15
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-eqz v2, :cond_84

    .line 3862
    iget v2, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeftLayerId:I

    iget v3, p0, Landroid/webkit/WebViewClassic;->mCurrentScrollingLayerId:I

    if-ne v2, v3, :cond_2b

    .line 3863
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    invoke-virtual {v2, v0, v1}, Landroid/graphics/Point;->offset(II)V

    .line 3864
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeftTextQuad:Landroid/webkit/QuadF;

    int-to-float v3, v0

    int-to-float v4, v1

    invoke-virtual {v2, v3, v4}, Landroid/webkit/QuadF;->offset(FF)V

    .line 3866
    :cond_2b
    iget v2, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRightLayerId:I

    iget v3, p0, Landroid/webkit/WebViewClassic;->mCurrentScrollingLayerId:I

    if-ne v2, v3, :cond_3d

    .line 3867
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRight:Landroid/graphics/Point;

    invoke-virtual {v2, v0, v1}, Landroid/graphics/Point;->offset(II)V

    .line 3868
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRightTextQuad:Landroid/webkit/QuadF;

    int-to-float v3, v0

    int-to-float v4, v1

    invoke-virtual {v2, v3, v4}, Landroid/webkit/QuadF;->offset(FF)V

    .line 3874
    :cond_3d
    :goto_3d
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mAutoCompletePopup:Landroid/webkit/AutoCompletePopup;

    if-eqz v2, :cond_51

    iget v2, p0, Landroid/webkit/WebViewClassic;->mCurrentScrollingLayerId:I

    iget v3, p0, Landroid/webkit/WebViewClassic;->mEditTextLayerId:I

    if-ne v2, v3, :cond_51

    .line 3876
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    invoke-virtual {v2, v0, v1}, Landroid/graphics/Rect;->offset(II)V

    .line 3877
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mAutoCompletePopup:Landroid/webkit/AutoCompletePopup;

    invoke-virtual {v2}, Landroid/webkit/AutoCompletePopup;->resetRect()V

    .line 3879
    :cond_51
    iget v2, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    iget v3, p0, Landroid/webkit/WebViewClassic;->mCurrentScrollingLayerId:I

    invoke-direct {p0, v2, v3, p1, p2}, Landroid/webkit/WebViewClassic;->nativeScrollLayer(IIII)Z

    .line 3880
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iput p1, v2, Landroid/graphics/Rect;->left:I

    .line 3881
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iput p2, v2, Landroid/graphics/Rect;->top:I

    .line 3882
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v3, 0xc6

    iget v4, p0, Landroid/webkit/WebViewClassic;->mCurrentScrollingLayerId:I

    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    invoke-virtual {v2, v3, v4, v5}, Landroid/webkit/WebViewCore;->sendMessage(IILjava/lang/Object;)V

    .line 3884
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v4

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v5

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v6

    invoke-virtual {v2, v3, v4, v5, v6}, Landroid/webkit/WebView$PrivateAccess;->onScrollChanged(IIII)V

    .line 3885
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    goto :goto_14

    .line 3870
    :cond_84
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mHandleAlpha:Landroid/webkit/WebViewClassic$SelectionHandleAlpha;

    invoke-virtual {v2}, Landroid/webkit/WebViewClassic$SelectionHandleAlpha;->getAlpha()I

    move-result v2

    if-lez v2, :cond_3d

    .line 3872
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mHandleAlphaAnimator:Landroid/animation/ObjectAnimator;

    invoke-virtual {v2}, Landroid/animation/ObjectAnimator;->end()V

    goto :goto_3d
.end method

.method private sendKeyEvent(Landroid/view/KeyEvent;)V
    .registers 6
    .parameter "event"

    .prologue
    .line 8558
    const/4 v0, 0x0

    .line 8559
    .local v0, direction:I
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v3

    sparse-switch v3, :sswitch_data_48

    .line 8576
    :goto_8
    if-eqz v0, :cond_13

    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v3, v0}, Landroid/webkit/WebView;->focusSearch(I)Landroid/view/View;

    move-result-object v3

    if-nez v3, :cond_13

    .line 8578
    const/4 v0, 0x0

    .line 8580
    :cond_13
    const/16 v1, 0x68

    .line 8581
    .local v1, eventHubAction:I
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v3

    if-nez v3, :cond_2c

    .line 8582
    const/16 v1, 0x67

    .line 8583
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v3

    invoke-direct {p0, v3}, Landroid/webkit/WebViewClassic;->keyCodeToSoundsEffect(I)I

    move-result v2

    .line 8584
    .local v2, sound:I
    if-eqz v2, :cond_2c

    .line 8585
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v3, v2}, Landroid/webkit/WebView;->playSoundEffect(I)V

    .line 8588
    .end local v2           #sound:I
    :cond_2c
    const/4 v3, 0x0

    invoke-virtual {p0, v1, v0, v3, p1}, Landroid/webkit/WebViewClassic;->sendBatchableInputMessage(IIILjava/lang/Object;)V

    .line 8589
    return-void

    .line 8561
    .end local v1           #eventHubAction:I
    :sswitch_31
    const/16 v0, 0x82

    .line 8562
    goto :goto_8

    .line 8564
    :sswitch_34
    const/16 v0, 0x21

    .line 8565
    goto :goto_8

    .line 8567
    :sswitch_37
    const/16 v0, 0x11

    .line 8568
    goto :goto_8

    .line 8570
    :sswitch_3a
    const/16 v0, 0x42

    .line 8571
    goto :goto_8

    .line 8573
    :sswitch_3d
    invoke-virtual {p1}, Landroid/view/KeyEvent;->isShiftPressed()Z

    move-result v3

    if-eqz v3, :cond_45

    const/4 v0, 0x1

    :goto_44
    goto :goto_8

    :cond_45
    const/4 v0, 0x2

    goto :goto_44

    .line 8559
    nop

    :sswitch_data_48
    .sparse-switch
        0x13 -> :sswitch_34
        0x14 -> :sswitch_31
        0x15 -> :sswitch_37
        0x16 -> :sswitch_3a
        0x3d -> :sswitch_3d
    .end sparse-switch
.end method

.method private setContentScrollBy(IIZ)Z
    .registers 7
    .parameter "cx"
    .parameter "cy"
    .parameter "animate"

    .prologue
    const/4 v1, 0x0

    .line 3925
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mDrawHistory:Z

    if-eqz v2, :cond_6

    .line 3949
    :cond_5
    :goto_5
    return v1

    .line 3932
    :cond_6
    invoke-virtual {p0, p1}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result p1

    .line 3933
    invoke-virtual {p0, p2}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result p2

    .line 3934
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mHeightCanMeasure:Z

    if-eqz v2, :cond_30

    .line 3936
    if-eqz p2, :cond_24

    .line 3937
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 3938
    .local v0, tempRect:Landroid/graphics/Rect;
    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->calcOurVisibleRect(Landroid/graphics/Rect;)V

    .line 3939
    invoke-virtual {v0, p1, p2}, Landroid/graphics/Rect;->offset(II)V

    .line 3940
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2, v0}, Landroid/webkit/WebView;->requestRectangleOnScreen(Landroid/graphics/Rect;)Z

    .line 3947
    .end local v0           #tempRect:Landroid/graphics/Rect;
    :cond_24
    if-nez p2, :cond_5

    if-eqz p1, :cond_5

    invoke-direct {p0, p1, v1, p3, v1}, Landroid/webkit/WebViewClassic;->pinScrollBy(IIZI)Z

    move-result v2

    if-eqz v2, :cond_5

    const/4 v1, 0x1

    goto :goto_5

    .line 3949
    :cond_30
    invoke-direct {p0, p1, p2, p3, v1}, Landroid/webkit/WebViewClassic;->pinScrollBy(IIZI)Z

    move-result v1

    goto :goto_5
.end method

.method private setFindIsUp(Z)V
    .registers 2
    .parameter "isUp"

    .prologue
    .line 3684
    iput-boolean p1, p0, Landroid/webkit/WebViewClassic;->mFindIsUp:Z

    .line 3685
    return-void
.end method

.method private setHitTestResult(Landroid/webkit/WebViewCore$WebKitHitTest;)V
    .registers 4
    .parameter "hit"

    .prologue
    .line 7822
    if-nez p1, :cond_6

    .line 7823
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    .line 7842
    :cond_5
    :goto_5
    return-void

    .line 7826
    :cond_6
    new-instance v0, Landroid/webkit/WebView$HitTestResult;

    invoke-direct {v0}, Landroid/webkit/WebView$HitTestResult;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    .line 7827
    iget-object v0, p1, Landroid/webkit/WebViewCore$WebKitHitTest;->mLinkUrl:Ljava/lang/String;

    if-eqz v0, :cond_32

    .line 7828
    iget-object v0, p1, Landroid/webkit/WebViewCore$WebKitHitTest;->mLinkUrl:Ljava/lang/String;

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->setHitTestTypeFromUrl(Ljava/lang/String;)V

    .line 7829
    iget-object v0, p1, Landroid/webkit/WebViewCore$WebKitHitTest;->mImageUrl:Ljava/lang/String;

    if-eqz v0, :cond_5

    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    invoke-virtual {v0}, Landroid/webkit/WebView$HitTestResult;->getType()I

    move-result v0

    const/4 v1, 0x7

    if-ne v0, v1, :cond_5

    .line 7831
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/webkit/WebView$HitTestResult;->setType(I)V

    .line 7832
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    iget-object v1, p1, Landroid/webkit/WebViewCore$WebKitHitTest;->mImageUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView$HitTestResult;->setExtra(Ljava/lang/String;)V

    goto :goto_5

    .line 7834
    :cond_32
    iget-object v0, p1, Landroid/webkit/WebViewCore$WebKitHitTest;->mImageUrl:Ljava/lang/String;

    if-eqz v0, :cond_44

    .line 7835
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/webkit/WebView$HitTestResult;->setType(I)V

    .line 7836
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    iget-object v1, p1, Landroid/webkit/WebViewCore$WebKitHitTest;->mImageUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView$HitTestResult;->setExtra(Ljava/lang/String;)V

    goto :goto_5

    .line 7837
    :cond_44
    iget-boolean v0, p1, Landroid/webkit/WebViewCore$WebKitHitTest;->mEditable:Z

    if-eqz v0, :cond_50

    .line 7838
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    const/16 v1, 0x9

    invoke-virtual {v0, v1}, Landroid/webkit/WebView$HitTestResult;->setType(I)V

    goto :goto_5

    .line 7839
    :cond_50
    iget-object v0, p1, Landroid/webkit/WebViewCore$WebKitHitTest;->mIntentUrl:Ljava/lang/String;

    if-eqz v0, :cond_5

    .line 7840
    iget-object v0, p1, Landroid/webkit/WebViewCore$WebKitHitTest;->mIntentUrl:Ljava/lang/String;

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->setHitTestTypeFromUrl(Ljava/lang/String;)V

    goto :goto_5
.end method

.method private setHitTestTypeFromUrl(Ljava/lang/String;)V
    .registers 7
    .parameter "url"

    .prologue
    .line 7798
    const/4 v1, 0x0

    .line 7799
    .local v1, substr:Ljava/lang/String;
    const-string v2, "geo:0,0?q="

    invoke-virtual {p1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_25

    .line 7800
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    const/4 v3, 0x3

    invoke-virtual {v2, v3}, Landroid/webkit/WebView$HitTestResult;->setType(I)V

    .line 7801
    const-string v2, "geo:0,0?q="

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    .line 7814
    :goto_19
    :try_start_19
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    const-string v3, "UTF-8"

    invoke-static {v1, v3}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/webkit/WebView$HitTestResult;->setExtra(Ljava/lang/String;)V
    :try_end_24
    .catch Ljava/lang/Throwable; {:try_start_19 .. :try_end_24} :catch_67

    .line 7819
    :goto_24
    return-void

    .line 7802
    :cond_25
    const-string/jumbo v2, "tel:"

    invoke-virtual {p1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_40

    .line 7803
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    const/4 v3, 0x2

    invoke-virtual {v2, v3}, Landroid/webkit/WebView$HitTestResult;->setType(I)V

    .line 7804
    const-string/jumbo v2, "tel:"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_19

    .line 7805
    :cond_40
    const-string/jumbo v2, "mailto:"

    invoke-virtual {p1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5b

    .line 7806
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    const/4 v3, 0x4

    invoke-virtual {v2, v3}, Landroid/webkit/WebView$HitTestResult;->setType(I)V

    .line 7807
    const-string/jumbo v2, "mailto:"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_19

    .line 7809
    :cond_5b
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    const/4 v3, 0x7

    invoke-virtual {v2, v3}, Landroid/webkit/WebView$HitTestResult;->setType(I)V

    .line 7810
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    invoke-virtual {v2, p1}, Landroid/webkit/WebView$HitTestResult;->setExtra(Ljava/lang/String;)V

    goto :goto_24

    .line 7815
    :catch_67
    move-exception v0

    .line 7816
    .local v0, e:Ljava/lang/Throwable;
    const-string/jumbo v2, "webview"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to decode URL! "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 7817
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/webkit/WebView$HitTestResult;->setType(I)V

    goto :goto_24
.end method

.method public static setShouldMonitorWebCoreThread()V
    .registers 0

    .prologue
    .line 8739
    invoke-static {}, Landroid/webkit/WebViewCore;->setShouldMonitorWebCoreThread()V

    .line 8740
    return-void
.end method

.method private setTouchHighlightRects(Landroid/webkit/WebViewCore$WebKitHitTest;)V
    .registers 15
    .parameter "hit"

    .prologue
    .line 7944
    const/4 v6, 0x0

    .line 7945
    .local v6, transition:Landroid/webkit/WebViewClassic$FocusTransitionDrawable;
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->shouldAnimateTo(Landroid/webkit/WebViewCore$WebKitHitTest;)Z

    move-result v8

    if-eqz v8, :cond_c

    .line 7946
    new-instance v6, Landroid/webkit/WebViewClassic$FocusTransitionDrawable;

    .end local v6           #transition:Landroid/webkit/WebViewClassic$FocusTransitionDrawable;
    invoke-direct {v6, p0}, Landroid/webkit/WebViewClassic$FocusTransitionDrawable;-><init>(Landroid/webkit/WebViewClassic;)V

    .line 7948
    .restart local v6       #transition:Landroid/webkit/WebViewClassic$FocusTransitionDrawable;
    :cond_c
    if-eqz p1, :cond_67

    iget-object v5, p1, Landroid/webkit/WebViewCore$WebKitHitTest;->mTouchRects:[Landroid/graphics/Rect;

    .line 7949
    .local v5, rects:[Landroid/graphics/Rect;
    :goto_10
    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightRegion:Landroid/graphics/Region;

    invoke-virtual {v8}, Landroid/graphics/Region;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_33

    .line 7950
    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    iget-object v9, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightRegion:Landroid/graphics/Region;

    invoke-virtual {v9}, Landroid/graphics/Region;->getBounds()Landroid/graphics/Rect;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/webkit/WebView;->invalidate(Landroid/graphics/Rect;)V

    .line 7951
    if-eqz v6, :cond_2e

    .line 7952
    new-instance v8, Landroid/graphics/Region;

    iget-object v9, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightRegion:Landroid/graphics/Region;

    invoke-direct {v8, v9}, Landroid/graphics/Region;-><init>(Landroid/graphics/Region;)V

    iput-object v8, v6, Landroid/webkit/WebViewClassic$FocusTransitionDrawable;->mPreviousRegion:Landroid/graphics/Region;

    .line 7954
    :cond_2e
    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightRegion:Landroid/graphics/Region;

    invoke-virtual {v8}, Landroid/graphics/Region;->setEmpty()V

    .line 7956
    :cond_33
    if-eqz v5, :cond_99

    .line 7957
    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mTouchHightlightPaint:Landroid/graphics/Paint;

    iget v9, p1, Landroid/webkit/WebViewCore$WebKitHitTest;->mTapHighlightColor:I

    invoke-virtual {v8, v9}, Landroid/graphics/Paint;->setColor(I)V

    .line 7958
    move-object v1, v5

    .local v1, arr$:[Landroid/graphics/Rect;
    array-length v3, v1

    .local v3, len$:I
    const/4 v2, 0x0

    .local v2, i$:I
    :goto_3f
    if-ge v2, v3, :cond_69

    aget-object v4, v1, v2

    .line 7959
    .local v4, rect:Landroid/graphics/Rect;
    invoke-direct {p0, v4}, Landroid/webkit/WebViewClassic;->contentToViewRect(Landroid/graphics/Rect;)Landroid/graphics/Rect;

    move-result-object v7

    .line 7964
    .local v7, viewRect:Landroid/graphics/Rect;
    invoke-virtual {v7}, Landroid/graphics/Rect;->width()I

    move-result v8

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getWidth()I

    move-result v9

    shr-int/lit8 v9, v9, 0x1

    if-lt v8, v9, :cond_5f

    invoke-virtual {v7}, Landroid/graphics/Rect;->height()I

    move-result v8

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getHeight()I

    move-result v9

    shr-int/lit8 v9, v9, 0x1

    if-ge v8, v9, :cond_64

    .line 7966
    :cond_5f
    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightRegion:Landroid/graphics/Region;

    invoke-virtual {v8, v7}, Landroid/graphics/Region;->union(Landroid/graphics/Rect;)Z

    .line 7958
    :cond_64
    add-int/lit8 v2, v2, 0x1

    goto :goto_3f

    .line 7948
    .end local v1           #arr$:[Landroid/graphics/Rect;
    .end local v2           #i$:I
    .end local v3           #len$:I
    .end local v4           #rect:Landroid/graphics/Rect;
    .end local v5           #rects:[Landroid/graphics/Rect;
    .end local v7           #viewRect:Landroid/graphics/Rect;
    :cond_67
    const/4 v5, 0x0

    goto :goto_10

    .line 7972
    .restart local v1       #arr$:[Landroid/graphics/Rect;
    .restart local v2       #i$:I
    .restart local v3       #len$:I
    .restart local v5       #rects:[Landroid/graphics/Rect;
    :cond_69
    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    iget-object v9, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightRegion:Landroid/graphics/Region;

    invoke-virtual {v9}, Landroid/graphics/Region;->getBounds()Landroid/graphics/Rect;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/webkit/WebView;->invalidate(Landroid/graphics/Rect;)V

    .line 7973
    if-eqz v6, :cond_99

    iget-object v8, v6, Landroid/webkit/WebViewClassic$FocusTransitionDrawable;->mPreviousRegion:Landroid/graphics/Region;

    if-eqz v8, :cond_99

    .line 7974
    new-instance v8, Landroid/graphics/Region;

    iget-object v9, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightRegion:Landroid/graphics/Region;

    invoke-direct {v8, v9}, Landroid/graphics/Region;-><init>(Landroid/graphics/Region;)V

    iput-object v8, v6, Landroid/webkit/WebViewClassic$FocusTransitionDrawable;->mNewRegion:Landroid/graphics/Region;

    .line 7975
    iput-object v6, p0, Landroid/webkit/WebViewClassic;->mFocusTransition:Landroid/webkit/WebViewClassic$FocusTransitionDrawable;

    .line 7976
    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mFocusTransition:Landroid/webkit/WebViewClassic$FocusTransitionDrawable;

    const-string/jumbo v9, "progress"

    const/4 v10, 0x1

    new-array v10, v10, [F

    const/4 v11, 0x0

    const/high16 v12, 0x3f80

    aput v12, v10, v11

    invoke-static {v8, v9, v10}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .line 7978
    .local v0, animator:Landroid/animation/ObjectAnimator;
    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->start()V

    .line 7981
    .end local v0           #animator:Landroid/animation/ObjectAnimator;
    .end local v1           #arr$:[Landroid/graphics/Rect;
    .end local v2           #i$:I
    .end local v3           #len$:I
    :cond_99
    return-void
.end method

.method private setupPackageListener(Landroid/content/Context;)V
    .registers 7
    .parameter "context"

    .prologue
    .line 1618
    const-class v4, Landroid/webkit/WebViewClassic;

    monitor-enter v4

    .line 1622
    :try_start_3
    sget-boolean v3, Landroid/webkit/WebViewClassic;->sPackageInstallationReceiverAdded:Z

    if-eqz v3, :cond_9

    .line 1623
    monitor-exit v4

    .line 1662
    :goto_8
    return-void

    .line 1626
    :cond_9
    new-instance v0, Landroid/content/IntentFilter;

    const-string v3, "android.intent.action.PACKAGE_ADDED"

    invoke-direct {v0, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 1627
    .local v0, filter:Landroid/content/IntentFilter;
    const-string v3, "android.intent.action.PACKAGE_REMOVED"

    invoke-virtual {v0, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 1628
    const-string/jumbo v3, "package"

    invoke-virtual {v0, v3}, Landroid/content/IntentFilter;->addDataScheme(Ljava/lang/String;)V

    .line 1629
    new-instance v1, Landroid/webkit/WebViewClassic$PackageListener;

    const/4 v3, 0x0

    invoke-direct {v1, v3}, Landroid/webkit/WebViewClassic$PackageListener;-><init>(Landroid/webkit/WebViewClassic$1;)V

    .line 1630
    .local v1, packageListener:Landroid/content/BroadcastReceiver;
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3, v1, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 1631
    const/4 v3, 0x1

    sput-boolean v3, Landroid/webkit/WebViewClassic;->sPackageInstallationReceiverAdded:Z

    .line 1632
    monitor-exit v4
    :try_end_2c
    .catchall {:try_start_3 .. :try_end_2c} :catchall_38

    .line 1635
    new-instance v2, Landroid/webkit/WebViewClassic$1;

    invoke-direct {v2, p0}, Landroid/webkit/WebViewClassic$1;-><init>(Landroid/webkit/WebViewClassic;)V

    .line 1661
    .local v2, task:Landroid/os/AsyncTask;,"Landroid/os/AsyncTask<Ljava/lang/Void;Ljava/lang/Void;Ljava/util/Set<Ljava/lang/String;>;>;"
    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    invoke-virtual {v2, v3}, Landroid/os/AsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_8

    .line 1632
    .end local v0           #filter:Landroid/content/IntentFilter;
    .end local v1           #packageListener:Landroid/content/BroadcastReceiver;
    .end local v2           #task:Landroid/os/AsyncTask;,"Landroid/os/AsyncTask<Ljava/lang/Void;Ljava/lang/Void;Ljava/util/Set<Ljava/lang/String;>;>;"
    :catchall_38
    move-exception v3

    :try_start_39
    monitor-exit v4
    :try_end_3a
    .catchall {:try_start_39 .. :try_end_3a} :catchall_38

    throw v3
.end method

.method private static declared-synchronized setupProxyListener(Landroid/content/Context;)V
    .registers 6
    .parameter "context"

    .prologue
    .line 1535
    const-class v3, Landroid/webkit/WebViewClassic;

    monitor-enter v3

    :try_start_3
    sget-object v2, Landroid/webkit/WebViewClassic;->sProxyReceiver:Landroid/webkit/WebViewClassic$ProxyReceiver;

    if-nez v2, :cond_b

    sget-boolean v2, Landroid/webkit/WebViewClassic;->sNotificationsEnabled:Z
    :try_end_9
    .catchall {:try_start_3 .. :try_end_9} :catchall_2f

    if-nez v2, :cond_d

    .line 1546
    :cond_b
    :goto_b
    monitor-exit v3

    return-void

    .line 1538
    :cond_d
    :try_start_d
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 1539
    .local v1, filter:Landroid/content/IntentFilter;
    const-string v2, "android.intent.action.PROXY_CHANGE"

    invoke-virtual {v1, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 1540
    new-instance v2, Landroid/webkit/WebViewClassic$ProxyReceiver;

    const/4 v4, 0x0

    invoke-direct {v2, v4}, Landroid/webkit/WebViewClassic$ProxyReceiver;-><init>(Landroid/webkit/WebViewClassic$1;)V

    sput-object v2, Landroid/webkit/WebViewClassic;->sProxyReceiver:Landroid/webkit/WebViewClassic$ProxyReceiver;

    .line 1541
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    sget-object v4, Landroid/webkit/WebViewClassic;->sProxyReceiver:Landroid/webkit/WebViewClassic$ProxyReceiver;

    invoke-virtual {v2, v4, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    move-result-object v0

    .line 1543
    .local v0, currentProxy:Landroid/content/Intent;
    if-eqz v0, :cond_b

    .line 1544
    invoke-static {v0}, Landroid/webkit/WebViewClassic;->handleProxyBroadcast(Landroid/content/Intent;)V
    :try_end_2e
    .catchall {:try_start_d .. :try_end_2e} :catchall_2f

    goto :goto_b

    .line 1535
    .end local v0           #currentProxy:Landroid/content/Intent;
    .end local v1           #filter:Landroid/content/IntentFilter;
    :catchall_2f
    move-exception v2

    monitor-exit v3

    throw v2
.end method

.method private static setupTrustStorageListener(Landroid/content/Context;)V
    .registers 5
    .parameter "context"

    .prologue
    .line 1504
    sget-object v2, Landroid/webkit/WebViewClassic;->sTrustStorageListener:Landroid/webkit/WebViewClassic$TrustStorageListener;

    if-eqz v2, :cond_5

    .line 1515
    :cond_4
    :goto_4
    return-void

    .line 1507
    :cond_5
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 1508
    .local v1, filter:Landroid/content/IntentFilter;
    const-string v2, "android.security.STORAGE_CHANGED"

    invoke-virtual {v1, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 1509
    new-instance v2, Landroid/webkit/WebViewClassic$TrustStorageListener;

    const/4 v3, 0x0

    invoke-direct {v2, v3}, Landroid/webkit/WebViewClassic$TrustStorageListener;-><init>(Landroid/webkit/WebViewClassic$1;)V

    sput-object v2, Landroid/webkit/WebViewClassic;->sTrustStorageListener:Landroid/webkit/WebViewClassic$TrustStorageListener;

    .line 1510
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    sget-object v3, Landroid/webkit/WebViewClassic;->sTrustStorageListener:Landroid/webkit/WebViewClassic$TrustStorageListener;

    invoke-virtual {v2, v3, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    move-result-object v0

    .line 1512
    .local v0, current:Landroid/content/Intent;
    if-eqz v0, :cond_4

    .line 1513
    invoke-static {}, Landroid/webkit/WebViewClassic;->handleCertTrustChanged()V

    goto :goto_4
.end method

.method private setupWebkitSelect()Z
    .registers 2

    .prologue
    .line 5326
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->syncSelectionCursors()V

    .line 5327
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsCaretSelection:Z

    if-nez v0, :cond_12

    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->startSelectActionMode()Z

    move-result v0

    if-nez v0, :cond_12

    .line 5328
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->selectionDone()V

    .line 5329
    const/4 v0, 0x0

    .line 5333
    :goto_11
    return v0

    .line 5331
    :cond_12
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->startSelectingText()V

    .line 5332
    const/4 v0, 0x3

    iput v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    .line 5333
    const/4 v0, 0x1

    goto :goto_11
.end method

.method private shouldAnimateTo(Landroid/webkit/WebViewCore$WebKitHitTest;)Z
    .registers 3
    .parameter "hit"

    .prologue
    .line 7940
    const/4 v0, 0x0

    return v0
.end method

.method private shouldDrawHighlightRect()Z
    .registers 3

    .prologue
    const/4 v0, 0x0

    .line 7845
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    if-eqz v1, :cond_9

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    if-nez v1, :cond_a

    .line 7857
    :cond_9
    :goto_9
    return v0

    .line 7848
    :cond_a
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightRegion:Landroid/graphics/Region;

    invoke-virtual {v1}, Landroid/graphics/Region;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_9

    .line 7851
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget-boolean v1, v1, Landroid/webkit/WebViewCore$WebKitHitTest;->mHasFocus:Z

    if-eqz v1, :cond_2c

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->isInTouchMode()Z

    move-result v1

    if-nez v1, :cond_2c

    .line 7852
    iget-boolean v1, p0, Landroid/webkit/WebViewClassic;->mDrawCursorRing:Z

    if-eqz v1, :cond_9

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget-boolean v1, v1, Landroid/webkit/WebViewCore$WebKitHitTest;->mEditable:Z

    if-nez v1, :cond_9

    const/4 v0, 0x1

    goto :goto_9

    .line 7854
    :cond_2c
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget-boolean v1, v1, Landroid/webkit/WebViewCore$WebKitHitTest;->mHasFocus:Z

    if-eqz v1, :cond_38

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget-boolean v1, v1, Landroid/webkit/WebViewCore$WebKitHitTest;->mEditable:Z

    if-nez v1, :cond_9

    .line 7857
    :cond_38
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mShowTapHighlight:Z

    goto :goto_9
.end method

.method private showFloatView()V
    .registers 9
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_METHOD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    .line 5896
    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mCopyFloatPanel:Landroid/webkit/SelectionFloatPanel;

    if-nez v5, :cond_c

    .line 5897
    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    invoke-static {v5, p0}, Landroid/webkit/SelectionFloatPanel;->getInstance(Landroid/content/Context;Landroid/webkit/WebViewClassic;)Landroid/webkit/SelectionFloatPanel;

    move-result-object v5

    iput-object v5, p0, Landroid/webkit/WebViewClassic;->mCopyFloatPanel:Landroid/webkit/SelectionFloatPanel;

    .line 5899
    :cond_c
    iget v5, p0, Landroid/webkit/WebViewClassic;->mMenuLeft:I

    const/4 v6, -0x1

    if-ne v5, v6, :cond_3f

    .line 5900
    const/4 v5, 0x4

    new-array v2, v5, [I

    .line 5901
    .local v2, handles:[I
    invoke-direct {p0, v2}, Landroid/webkit/WebViewClassic;->getSelectionHandles([I)V

    .line 5902
    const/4 v5, 0x0

    aget v5, v2, v5

    invoke-virtual {p0, v5}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v3

    .line 5903
    .local v3, start_x:I
    const/4 v5, 0x1

    aget v5, v2, v5

    invoke-virtual {p0, v5}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v4

    .line 5904
    .local v4, start_y:I
    const/4 v5, 0x2

    aget v5, v2, v5

    invoke-virtual {p0, v5}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v0

    .line 5905
    .local v0, end_x:I
    const/4 v5, 0x3

    aget v5, v2, v5

    invoke-virtual {p0, v5}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v1

    .line 5906
    .local v1, end_y:I
    add-int v5, v3, v0

    div-int/lit8 v5, v5, 0x2

    iput v5, p0, Landroid/webkit/WebViewClassic;->mMenuLeft:I

    .line 5907
    if-ge v4, v1, :cond_49

    .end local v4           #start_y:I
    :goto_3b
    add-int/lit8 v5, v4, -0x1e

    iput v5, p0, Landroid/webkit/WebViewClassic;->mMenuTop:I

    .line 5909
    .end local v0           #end_x:I
    .end local v1           #end_y:I
    .end local v2           #handles:[I
    .end local v3           #start_x:I
    :cond_3f
    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mCopyFloatPanel:Landroid/webkit/SelectionFloatPanel;

    iget v6, p0, Landroid/webkit/WebViewClassic;->mMenuLeft:I

    iget v7, p0, Landroid/webkit/WebViewClassic;->mMenuTop:I

    invoke-virtual {v5, v6, v7}, Landroid/webkit/SelectionFloatPanel;->showAt(II)V

    .line 5910
    return-void

    .restart local v0       #end_x:I
    .restart local v1       #end_y:I
    .restart local v2       #handles:[I
    .restart local v3       #start_x:I
    .restart local v4       #start_y:I
    :cond_49
    move v4, v1

    .line 5907
    goto :goto_3b
.end method

.method private showMagnifier(Landroid/graphics/Canvas;Landroid/graphics/Rect;Landroid/graphics/Rect;)V
    .registers 38
    .parameter "canvas"
    .parameter "topLeft"
    .parameter "bottomRight"
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_METHOD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    .line 4632
    const/16 v29, 0x5

    move/from16 v0, v29

    new-array v13, v0, [I

    .line 4633
    .local v13, handles:[I
    move-object/from16 v0, p0

    invoke-direct {v0, v13}, Landroid/webkit/WebViewClassic;->getSelectionHandles([I)V

    .line 4635
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    move-object/from16 v30, v0

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    if-ne v0, v1, :cond_370

    const/16 v28, 0x1

    .line 4637
    .local v28, wasDraggingLeft:Z
    :goto_1f
    move-object/from16 v0, p0

    iget-boolean v0, v0, Landroid/webkit/WebViewClassic;->mIsActionUp:Z

    move/from16 v29, v0

    if-nez v29, :cond_36f

    move-object/from16 v0, p0

    iget-boolean v0, v0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    move/from16 v29, v0

    if-eqz v29, :cond_36f

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mBeforeStart:Ljava/lang/String;

    move-object/from16 v29, v0

    if-nez v29, :cond_3f

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mAfterStart:Ljava/lang/String;

    move-object/from16 v29, v0

    if-eqz v29, :cond_36f

    .line 4638
    :cond_3f
    new-instance v24, Landroid/graphics/Rect;

    invoke-direct/range {v24 .. v24}, Landroid/graphics/Rect;-><init>()V

    .line 4640
    .local v24, rr:Landroid/graphics/Rect;
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mSelectMagnifier:Landroid/graphics/drawable/Drawable;

    move-object/from16 v29, v0

    if-nez v29, :cond_63

    .line 4641
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v29

    const v30, 0x60201fb

    invoke-virtual/range {v29 .. v30}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v29

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/webkit/WebViewClassic;->mSelectMagnifier:Landroid/graphics/drawable/Drawable;

    .line 4644
    :cond_63
    new-instance v11, Landroid/graphics/Rect;

    invoke-direct {v11}, Landroid/graphics/Rect;-><init>()V

    .line 4645
    .local v11, contentPadding:Landroid/graphics/Rect;
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mSelectMagnifier:Landroid/graphics/drawable/Drawable;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    invoke-virtual {v0, v11}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 4647
    const/high16 v5, 0x3fc0

    .line 4648
    .local v5, BASE_DENSITY:F
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v29

    move-object/from16 v0, v29

    iget v12, v0, Landroid/util/DisplayMetrics;->density:F

    .line 4649
    .local v12, density:F
    const/high16 v29, 0x3fc0

    div-float v23, v12, v29

    .line 4650
    .local v23, ratio:F
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mSelectMagnifier:Landroid/graphics/drawable/Drawable;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v29

    move/from16 v0, v29

    int-to-float v0, v0

    move/from16 v29, v0

    mul-float v29, v29, v23

    move/from16 v0, v29

    float-to-int v7, v0

    .line 4651
    .local v7, BASE_HEIGHT:I
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mSelectMagnifier:Landroid/graphics/drawable/Drawable;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v29

    div-int/lit8 v29, v29, 0x2

    move/from16 v0, v29

    int-to-float v0, v0

    move/from16 v29, v0

    mul-float v29, v29, v23

    move/from16 v0, v29

    float-to-int v6, v0

    .line 4653
    .local v6, BASE_HALF_WIDTH:I
    const/high16 v29, 0x41a0

    mul-float v29, v29, v23

    move/from16 v0, v29

    float-to-int v0, v0

    move/from16 v21, v0

    .line 4654
    .local v21, offset:I
    const/4 v10, 0x2

    .line 4656
    .local v10, charPadding:I
    if-eqz v28, :cond_374

    .line 4657
    move-object/from16 v0, p2

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v29, v0

    sub-int v29, v29, v6

    move/from16 v0, v29

    move-object/from16 v1, v24

    iput v0, v1, Landroid/graphics/Rect;->left:I

    .line 4658
    move-object/from16 v0, p2

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v29, v0

    sub-int v29, v29, v7

    sub-int v29, v29, v21

    move/from16 v0, v29

    move-object/from16 v1, v24

    iput v0, v1, Landroid/graphics/Rect;->top:I

    .line 4659
    move-object/from16 v0, p2

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v29, v0

    add-int v29, v29, v6

    move/from16 v0, v29

    move-object/from16 v1, v24

    iput v0, v1, Landroid/graphics/Rect;->right:I

    .line 4660
    move-object/from16 v0, p2

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v29, v0

    sub-int v29, v29, v21

    move/from16 v0, v29

    move-object/from16 v1, v24

    iput v0, v1, Landroid/graphics/Rect;->bottom:I

    .line 4667
    :goto_fb
    move-object/from16 v0, p2

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v29, v0

    move-object/from16 v0, p3

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v30, v0

    add-int v29, v29, v30

    div-int/lit8 v29, v29, 0x2

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput v0, v1, Landroid/webkit/WebViewClassic;->mMenuLeft:I

    .line 4668
    move-object/from16 v0, p2

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v29, v0

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput v0, v1, Landroid/webkit/WebViewClassic;->mMenuTop:I

    .line 4670
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mSelectMagnifier:Landroid/graphics/drawable/Drawable;

    move-object/from16 v29, v0

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v30, v0

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v31, v0

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v32, v0

    mul-int/lit8 v33, v6, 0x2

    add-int v32, v32, v33

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v33, v0

    add-int v33, v33, v7

    invoke-virtual/range {v29 .. v33}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 4671
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mSelectMagnifier:Landroid/graphics/drawable/Drawable;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 4673
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mSelectHighlight:Landroid/graphics/drawable/Drawable;

    move-object/from16 v29, v0

    if-nez v29, :cond_170

    .line 4674
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v29

    const v30, 0x60201fa

    invoke-virtual/range {v29 .. v30}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v29

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/webkit/WebViewClassic;->mSelectHighlight:Landroid/graphics/drawable/Drawable;

    .line 4678
    :cond_170
    iget v0, v11, Landroid/graphics/Rect;->left:I

    move/from16 v29, v0

    move/from16 v0, v29

    int-to-float v0, v0

    move/from16 v29, v0

    mul-float v29, v29, v23

    move/from16 v0, v29

    float-to-int v0, v0

    move/from16 v16, v0

    .line 4679
    .local v16, innerLeftPadding:I
    iget v0, v11, Landroid/graphics/Rect;->top:I

    move/from16 v29, v0

    move/from16 v0, v29

    int-to-float v0, v0

    move/from16 v29, v0

    mul-float v29, v29, v23

    move/from16 v0, v29

    float-to-int v0, v0

    move/from16 v18, v0

    .line 4680
    .local v18, innerTopPadding:I
    iget v0, v11, Landroid/graphics/Rect;->right:I

    move/from16 v29, v0

    move/from16 v0, v29

    int-to-float v0, v0

    move/from16 v29, v0

    mul-float v29, v29, v23

    move/from16 v0, v29

    float-to-int v0, v0

    move/from16 v17, v0

    .line 4681
    .local v17, innerRightPadding:I
    iget v0, v11, Landroid/graphics/Rect;->bottom:I

    move/from16 v29, v0

    move/from16 v0, v29

    int-to-float v0, v0

    move/from16 v29, v0

    mul-float v29, v29, v23

    move/from16 v0, v29

    float-to-int v15, v0

    .line 4683
    .local v15, innerBottomPadding:I
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mSelectHighlight:Landroid/graphics/drawable/Drawable;

    move-object/from16 v29, v0

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v30, v0

    add-int v30, v30, v16

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v31, v0

    add-int v31, v31, v18

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v32, v0

    add-int v32, v32, v6

    sub-int v32, v32, v17

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v33, v0

    add-int v33, v33, v7

    sub-int v33, v33, v15

    invoke-virtual/range {v29 .. v33}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 4684
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mSelectHighlight:Landroid/graphics/drawable/Drawable;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 4686
    new-instance v22, Landroid/graphics/Paint;

    invoke-direct/range {v22 .. v22}, Landroid/graphics/Paint;-><init>()V

    .line 4687
    .local v22, p:Landroid/graphics/Paint;
    const v29, 0x6633b5e5

    move-object/from16 v0, v22

    move/from16 v1, v29

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 4690
    if-eqz v28, :cond_3b0

    .line 4691
    new-instance v25, Landroid/graphics/Rect;

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v29, v0

    add-int v29, v29, v6

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v30, v0

    add-int v30, v30, v18

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v31, v0

    sub-int v31, v31, v17

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    move/from16 v32, v0

    sub-int v32, v32, v15

    move-object/from16 v0, v25

    move/from16 v1, v29

    move/from16 v2, v30

    move/from16 v3, v31

    move/from16 v4, v32

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 4695
    .local v25, shadow:Landroid/graphics/Rect;
    :goto_228
    move-object/from16 v0, p1

    move-object/from16 v1, v25

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 4696
    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v29, v0

    add-int v29, v29, v16

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v30, v0

    add-int v30, v30, v18

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v31, v0

    sub-int v31, v31, v17

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    move/from16 v32, v0

    sub-int v32, v32, v15

    move-object/from16 v0, p1

    move/from16 v1, v29

    move/from16 v2, v30

    move/from16 v3, v31

    move/from16 v4, v32

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->clipRect(IIII)Z

    .line 4698
    new-instance v27, Landroid/graphics/Paint;

    invoke-direct/range {v27 .. v27}, Landroid/graphics/Paint;-><init>()V

    .line 4699
    .local v27, textPaint:Landroid/graphics/Paint;
    sget-object v29, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    move-object/from16 v0, v27

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 4700
    const/16 v29, 0x0

    move-object/from16 v0, v27

    move/from16 v1, v29

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 4701
    const/high16 v29, -0x100

    move-object/from16 v0, v27

    move/from16 v1, v29

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 4702
    invoke-virtual/range {v22 .. v22}, Landroid/graphics/Paint;->getTextSize()F

    move-result v29

    const/high16 v30, 0x4040

    mul-float v29, v29, v30

    mul-float v29, v29, v23

    move-object/from16 v0, v27

    move/from16 v1, v29

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 4704
    const/4 v9, 0x0

    .line 4705
    .local v9, beforeTextWidth:I
    const-string v26, " "

    .line 4706
    .local v26, ss:Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mBeforeStart:Ljava/lang/String;

    move-object/from16 v29, v0

    if-eqz v29, :cond_301

    .line 4707
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mBeforeStart:Ljava/lang/String;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Ljava/lang/String;->length()I

    move-result v19

    .line 4708
    .local v19, len:I
    const/4 v14, 0x0

    .local v14, i:I
    :goto_2a5
    move/from16 v0, v19

    if-ge v14, v0, :cond_2c8

    .line 4709
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mBeforeStart:Ljava/lang/String;

    move-object/from16 v29, v0

    sub-int v30, v19, v14

    add-int/lit8 v30, v30, -0x1

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v26

    .line 4710
    move-object/from16 v0, v27

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v29

    move/from16 v0, v29

    float-to-int v9, v0

    .line 4711
    mul-int/lit8 v29, v6, 0x2

    move/from16 v0, v29

    if-le v9, v0, :cond_3e1

    .line 4715
    :cond_2c8
    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v29, v0

    add-int v29, v29, v6

    sub-int v29, v29, v9

    add-int/lit8 v29, v29, -0x2

    move/from16 v0, v29

    int-to-float v0, v0

    move/from16 v29, v0

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    move/from16 v30, v0

    sub-int v30, v30, v15

    div-int/lit8 v31, v21, 0x2

    sub-int v30, v30, v31

    move/from16 v0, v30

    int-to-float v0, v0

    move/from16 v30, v0

    invoke-virtual/range {v27 .. v27}, Landroid/graphics/Paint;->descent()F

    move-result v31

    const/high16 v32, 0x4000

    div-float v31, v31, v32

    add-float v30, v30, v31

    move-object/from16 v0, p1

    move-object/from16 v1, v26

    move/from16 v2, v29

    move/from16 v3, v30

    move-object/from16 v4, v27

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 4718
    .end local v14           #i:I
    .end local v19           #len:I
    :cond_301
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mAfterStart:Ljava/lang/String;

    move-object/from16 v29, v0

    if-eqz v29, :cond_36f

    .line 4719
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mAfterStart:Ljava/lang/String;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Ljava/lang/String;->length()I

    move-result v19

    .line 4720
    .restart local v19       #len:I
    const/4 v8, 0x0

    .line 4722
    .local v8, afterTextWidth:I
    mul-int/lit8 v20, v6, 0x2

    .line 4723
    .local v20, limit:I
    const/4 v14, 0x0

    .restart local v14       #i:I
    :goto_317
    move/from16 v0, v19

    if-ge v14, v0, :cond_338

    .line 4724
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mAfterStart:Ljava/lang/String;

    move-object/from16 v29, v0

    const/16 v30, 0x0

    add-int/lit8 v31, v14, 0x1

    invoke-virtual/range {v29 .. v31}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v26

    .line 4725
    move-object/from16 v0, v27

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v29

    move/from16 v0, v29

    float-to-int v8, v0

    .line 4726
    move/from16 v0, v20

    if-le v8, v0, :cond_3e5

    .line 4730
    :cond_338
    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v29, v0

    add-int v29, v29, v6

    add-int/lit8 v29, v29, 0x2

    move/from16 v0, v29

    int-to-float v0, v0

    move/from16 v29, v0

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    move/from16 v30, v0

    sub-int v30, v30, v15

    div-int/lit8 v31, v21, 0x2

    sub-int v30, v30, v31

    move/from16 v0, v30

    int-to-float v0, v0

    move/from16 v30, v0

    invoke-virtual/range {v27 .. v27}, Landroid/graphics/Paint;->descent()F

    move-result v31

    const/high16 v32, 0x4000

    div-float v31, v31, v32

    add-float v30, v30, v31

    move-object/from16 v0, p1

    move-object/from16 v1, v26

    move/from16 v2, v29

    move/from16 v3, v30

    move-object/from16 v4, v27

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 4733
    .end local v5           #BASE_DENSITY:F
    .end local v6           #BASE_HALF_WIDTH:I
    .end local v7           #BASE_HEIGHT:I
    .end local v8           #afterTextWidth:I
    .end local v9           #beforeTextWidth:I
    .end local v10           #charPadding:I
    .end local v11           #contentPadding:Landroid/graphics/Rect;
    .end local v12           #density:F
    .end local v14           #i:I
    .end local v15           #innerBottomPadding:I
    .end local v16           #innerLeftPadding:I
    .end local v17           #innerRightPadding:I
    .end local v18           #innerTopPadding:I
    .end local v19           #len:I
    .end local v20           #limit:I
    .end local v21           #offset:I
    .end local v22           #p:Landroid/graphics/Paint;
    .end local v23           #ratio:F
    .end local v24           #rr:Landroid/graphics/Rect;
    .end local v25           #shadow:Landroid/graphics/Rect;
    .end local v26           #ss:Ljava/lang/String;
    .end local v27           #textPaint:Landroid/graphics/Paint;
    :cond_36f
    return-void

    .line 4635
    .end local v28           #wasDraggingLeft:Z
    :cond_370
    const/16 v28, 0x0

    goto/16 :goto_1f

    .line 4662
    .restart local v5       #BASE_DENSITY:F
    .restart local v6       #BASE_HALF_WIDTH:I
    .restart local v7       #BASE_HEIGHT:I
    .restart local v10       #charPadding:I
    .restart local v11       #contentPadding:Landroid/graphics/Rect;
    .restart local v12       #density:F
    .restart local v21       #offset:I
    .restart local v23       #ratio:F
    .restart local v24       #rr:Landroid/graphics/Rect;
    .restart local v28       #wasDraggingLeft:Z
    :cond_374
    move-object/from16 v0, p3

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v29, v0

    sub-int v29, v29, v6

    move/from16 v0, v29

    move-object/from16 v1, v24

    iput v0, v1, Landroid/graphics/Rect;->left:I

    .line 4663
    move-object/from16 v0, p3

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v29, v0

    sub-int v29, v29, v7

    sub-int v29, v29, v21

    move/from16 v0, v29

    move-object/from16 v1, v24

    iput v0, v1, Landroid/graphics/Rect;->top:I

    .line 4664
    move-object/from16 v0, p3

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v29, v0

    add-int v29, v29, v6

    move/from16 v0, v29

    move-object/from16 v1, v24

    iput v0, v1, Landroid/graphics/Rect;->right:I

    .line 4665
    move-object/from16 v0, p3

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v29, v0

    sub-int v29, v29, v21

    move/from16 v0, v29

    move-object/from16 v1, v24

    iput v0, v1, Landroid/graphics/Rect;->bottom:I

    goto/16 :goto_fb

    .line 4693
    .restart local v15       #innerBottomPadding:I
    .restart local v16       #innerLeftPadding:I
    .restart local v17       #innerRightPadding:I
    .restart local v18       #innerTopPadding:I
    .restart local v22       #p:Landroid/graphics/Paint;
    :cond_3b0
    new-instance v25, Landroid/graphics/Rect;

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v29, v0

    add-int v29, v29, v16

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v30, v0

    add-int v30, v30, v18

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v31, v0

    add-int v31, v31, v6

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    move/from16 v32, v0

    sub-int v32, v32, v15

    move-object/from16 v0, v25

    move/from16 v1, v29

    move/from16 v2, v30

    move/from16 v3, v31

    move/from16 v4, v32

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/Rect;-><init>(IIII)V

    .restart local v25       #shadow:Landroid/graphics/Rect;
    goto/16 :goto_228

    .line 4708
    .restart local v9       #beforeTextWidth:I
    .restart local v14       #i:I
    .restart local v19       #len:I
    .restart local v26       #ss:Ljava/lang/String;
    .restart local v27       #textPaint:Landroid/graphics/Paint;
    :cond_3e1
    add-int/lit8 v14, v14, 0x1

    goto/16 :goto_2a5

    .line 4723
    .restart local v8       #afterTextWidth:I
    .restart local v20       #limit:I
    :cond_3e5
    add-int/lit8 v14, v14, 0x1

    goto/16 :goto_317
.end method

.method private showPasteWindow()V
    .registers 11

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 5209
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    const-string v7, "clipboard"

    invoke-virtual {v6, v7}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/ClipboardManager;

    move-object v0, v6

    check-cast v0, Landroid/content/ClipboardManager;

    .line 5211
    .local v0, cm:Landroid/content/ClipboardManager;
    invoke-virtual {v0}, Landroid/content/ClipboardManager;->hasPrimaryClip()Z

    move-result v6

    if-eqz v6, :cond_6f

    .line 5212
    new-instance v1, Landroid/graphics/Point;

    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->x:I

    invoke-virtual {p0, v6}, Landroid/webkit/WebViewClassic;->contentToViewX(I)I

    move-result v6

    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v7, v7, Landroid/graphics/Point;->y:I

    invoke-virtual {p0, v7}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v7

    invoke-direct {v1, v6, v7}, Landroid/graphics/Point;-><init>(II)V

    .line 5214
    .local v1, cursorPoint:Landroid/graphics/Point;
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->calculateCaretTop()Landroid/graphics/Point;

    move-result-object v2

    .line 5215
    .local v2, cursorTop:Landroid/graphics/Point;
    iget v6, v2, Landroid/graphics/Point;->x:I

    invoke-virtual {p0, v6}, Landroid/webkit/WebViewClassic;->contentToViewX(I)I

    move-result v6

    iget v7, v2, Landroid/graphics/Point;->y:I

    invoke-virtual {p0, v7}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v7

    invoke-virtual {v2, v6, v7}, Landroid/graphics/Point;->set(II)V

    .line 5218
    const/4 v6, 0x2

    new-array v3, v6, [I

    .line 5219
    .local v3, location:[I
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v6, v3}, Landroid/webkit/WebView;->getLocationInWindow([I)V

    .line 5220
    aget v6, v3, v8

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v7

    sub-int v4, v6, v7

    .line 5221
    .local v4, offsetX:I
    aget v6, v3, v9

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v7

    sub-int v5, v6, v7

    .line 5222
    .local v5, offsetY:I
    invoke-virtual {v1, v4, v5}, Landroid/graphics/Point;->offset(II)V

    .line 5223
    invoke-virtual {v2, v4, v5}, Landroid/graphics/Point;->offset(II)V

    .line 5224
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mPasteWindow:Landroid/webkit/WebViewClassic$PastePopupWindow;

    if-nez v6, :cond_66

    .line 5225
    new-instance v6, Landroid/webkit/WebViewClassic$PastePopupWindow;

    invoke-direct {v6, p0}, Landroid/webkit/WebViewClassic$PastePopupWindow;-><init>(Landroid/webkit/WebViewClassic;)V

    iput-object v6, p0, Landroid/webkit/WebViewClassic;->mPasteWindow:Landroid/webkit/WebViewClassic$PastePopupWindow;

    .line 5227
    :cond_66
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mPasteWindow:Landroid/webkit/WebViewClassic$PastePopupWindow;

    aget v7, v3, v8

    aget v8, v3, v9

    invoke-virtual {v6, v1, v2, v7, v8}, Landroid/webkit/WebViewClassic$PastePopupWindow;->show(Landroid/graphics/Point;Landroid/graphics/Point;II)V

    .line 5229
    .end local v1           #cursorPoint:Landroid/graphics/Point;
    .end local v2           #cursorTop:Landroid/graphics/Point;
    .end local v3           #location:[I
    .end local v4           #offsetX:I
    .end local v5           #offsetY:I
    :cond_6f
    return-void
.end method

.method private snapDraggingCursor()V
    .registers 10

    .prologue
    .line 6531
    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    iget v5, v5, Landroid/graphics/Point;->x:I

    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->y:I

    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingTextQuad:Landroid/webkit/QuadF;

    iget-object v7, v7, Landroid/webkit/QuadF;->p4:Landroid/graphics/PointF;

    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingTextQuad:Landroid/webkit/QuadF;

    iget-object v8, v8, Landroid/webkit/QuadF;->p3:Landroid/graphics/PointF;

    invoke-static {v5, v6, v7, v8}, Landroid/webkit/WebViewClassic;->scaleAlongSegment(IILandroid/graphics/PointF;Landroid/graphics/PointF;)F

    move-result v2

    .line 6535
    .local v2, scale:F
    const/4 v5, 0x0

    invoke-static {v5, v2}, Ljava/lang/Math;->max(FF)F

    move-result v2

    .line 6536
    const/high16 v5, 0x3f80

    invoke-static {v2, v5}, Ljava/lang/Math;->min(FF)F

    move-result v2

    .line 6537
    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingTextQuad:Landroid/webkit/QuadF;

    iget-object v5, v5, Landroid/webkit/QuadF;->p4:Landroid/graphics/PointF;

    iget v5, v5, Landroid/graphics/PointF;->x:F

    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingTextQuad:Landroid/webkit/QuadF;

    iget-object v6, v6, Landroid/webkit/QuadF;->p3:Landroid/graphics/PointF;

    iget v6, v6, Landroid/graphics/PointF;->x:F

    invoke-static {v2, v5, v6}, Landroid/webkit/WebViewClassic;->scaleCoordinate(FFF)F

    move-result v0

    .line 6539
    .local v0, newX:F
    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingTextQuad:Landroid/webkit/QuadF;

    iget-object v5, v5, Landroid/webkit/QuadF;->p4:Landroid/graphics/PointF;

    iget v5, v5, Landroid/graphics/PointF;->y:F

    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingTextQuad:Landroid/webkit/QuadF;

    iget-object v6, v6, Landroid/webkit/QuadF;->p3:Landroid/graphics/PointF;

    iget v6, v6, Landroid/graphics/PointF;->y:F

    invoke-static {v2, v5, v6}, Landroid/webkit/WebViewClassic;->scaleCoordinate(FFF)F

    move-result v1

    .line 6541
    .local v1, newY:F
    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v3

    .line 6542
    .local v3, x:I
    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v4

    .line 6543
    .local v4, y:I
    iget-boolean v5, p0, Landroid/webkit/WebViewClassic;->mIsEditingText:Z

    if-eqz v5, :cond_6b

    .line 6544
    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->left:I

    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->right:I

    invoke-static {v6, v3}, Ljava/lang/Math;->min(II)I

    move-result v6

    invoke-static {v5, v6}, Ljava/lang/Math;->max(II)I

    move-result v3

    .line 6546
    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->top:I

    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->bottom:I

    invoke-static {v6, v4}, Ljava/lang/Math;->min(II)I

    move-result v6

    invoke-static {v5, v6}, Ljava/lang/Math;->max(II)I

    move-result v4

    .line 6549
    :cond_6b
    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    invoke-virtual {v5, v3, v4}, Landroid/graphics/Point;->set(II)V

    .line 6550
    return-void
.end method

.method private startDrag()V
    .registers 3

    .prologue
    const/4 v1, 0x1

    .line 6400
    invoke-static {}, Landroid/webkit/WebViewCore;->reducePriority()V

    .line 6402
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-static {v0}, Landroid/webkit/WebViewCore;->pauseUpdatePicture(Landroid/webkit/WebViewCore;)V

    .line 6403
    invoke-direct {p0, v1}, Landroid/webkit/WebViewClassic;->nativeSetIsScrolling(Z)V

    .line 6405
    iget v0, p0, Landroid/webkit/WebViewClassic;->mHorizontalScrollBarMode:I

    if-ne v0, v1, :cond_14

    iget v0, p0, Landroid/webkit/WebViewClassic;->mVerticalScrollBarMode:I

    if-eq v0, v1, :cond_19

    .line 6407
    :cond_14
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->invokeZoomPicker()V

    .line 6409
    :cond_19
    return-void
.end method

.method private startPrivateBrowsing()V
    .registers 3

    .prologue
    .line 2737
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettingsClassic;->setPrivateBrowsingEnabled(Z)V

    .line 2738
    return-void
.end method

.method private startScrollingLayer(FF)V
    .registers 9
    .parameter "x"
    .parameter "y"

    .prologue
    .line 5852
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v0, :cond_5

    .line 5862
    :cond_4
    :goto_4
    return-void

    .line 5855
    :cond_5
    float-to-int v0, p1

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v1

    add-int/2addr v0, v1

    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->viewToContentX(I)I

    move-result v2

    .line 5856
    .local v2, contentX:I
    float-to-int v0, p2

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v1

    add-int/2addr v0, v1

    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->viewToContentY(I)I

    move-result v3

    .line 5857
    .local v3, contentY:I
    iget v1, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mScrollingLayerBounds:Landroid/graphics/Rect;

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Landroid/webkit/WebViewClassic;->nativeScrollableLayer(IIILandroid/graphics/Rect;Landroid/graphics/Rect;)I

    move-result v0

    iput v0, p0, Landroid/webkit/WebViewClassic;->mCurrentScrollingLayerId:I

    .line 5859
    iget v0, p0, Landroid/webkit/WebViewClassic;->mCurrentScrollingLayerId:I

    if-eqz v0, :cond_4

    .line 5860
    const/16 v0, 0x9

    iput v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    goto :goto_4
.end method

.method private startSelectActionMode()Z
    .registers 3

    .prologue
    .line 5204
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->performHapticFeedback(I)Z

    .line 5205
    const/4 v0, 0x1

    return v0
.end method

.method private startSelectingText()V
    .registers 5

    .prologue
    const/4 v1, 0x1

    .line 4535
    iput-boolean v1, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    .line 4536
    iput-boolean v1, p0, Landroid/webkit/WebViewClassic;->mShowTextSelectionExtra:Z

    .line 4537
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHandleAlphaAnimator:Landroid/animation/ObjectAnimator;

    new-array v1, v1, [I

    const/4 v2, 0x0

    const/16 v3, 0xff

    aput v3, v1, v2

    invoke-virtual {v0, v1}, Landroid/animation/ObjectAnimator;->setIntValues([I)V

    .line 4538
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHandleAlphaAnimator:Landroid/animation/ObjectAnimator;

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->start()V

    .line 4539
    return-void
.end method

.method private startTouch(FFJ)V
    .registers 6
    .parameter "x"
    .parameter "y"
    .parameter "eventTime"

    .prologue
    .line 6392
    invoke-static {p1}, Ljava/lang/Math;->round(F)I

    move-result v0

    iput v0, p0, Landroid/webkit/WebViewClassic;->mLastTouchX:I

    iput v0, p0, Landroid/webkit/WebViewClassic;->mStartTouchX:I

    .line 6393
    invoke-static {p2}, Ljava/lang/Math;->round(F)I

    move-result v0

    iput v0, p0, Landroid/webkit/WebViewClassic;->mLastTouchY:I

    iput v0, p0, Landroid/webkit/WebViewClassic;->mStartTouchY:I

    .line 6394
    iput-wide p3, p0, Landroid/webkit/WebViewClassic;->mLastTouchTime:J

    .line 6395
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 6396
    const/4 v0, 0x0

    iput v0, p0, Landroid/webkit/WebViewClassic;->mSnapScrollMode:I

    .line 6397
    return-void
.end method

.method private stopTouch()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 6476
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v0}, Landroid/widget/OverScroller;->isFinished()Z

    move-result v0

    if-eqz v0, :cond_23

    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-nez v0, :cond_23

    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/4 v1, 0x3

    if-eq v0, v1, :cond_18

    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/16 v1, 0x9

    if-ne v0, v1, :cond_23

    .line 6479
    :cond_18
    invoke-static {}, Landroid/webkit/WebViewCore;->resumePriority()V

    .line 6480
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-static {v0}, Landroid/webkit/WebViewCore;->resumeUpdatePicture(Landroid/webkit/WebViewCore;)V

    .line 6481
    invoke-direct {p0, v2}, Landroid/webkit/WebViewClassic;->nativeSetIsScrolling(Z)V

    .line 6487
    :cond_23
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-eqz v0, :cond_2f

    .line 6488
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v0}, Landroid/view/VelocityTracker;->recycle()V

    .line 6489
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 6493
    :cond_2f
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mOverScrollGlow:Landroid/webkit/OverScrollGlow;

    if-eqz v0, :cond_38

    .line 6494
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mOverScrollGlow:Landroid/webkit/OverScrollGlow;

    invoke-virtual {v0}, Landroid/webkit/OverScrollGlow;->releaseAll()V

    .line 6497
    :cond_38
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-eqz v0, :cond_4b

    .line 6498
    iput-boolean v2, p0, Landroid/webkit/WebViewClassic;->mSelectionStarted:Z

    .line 6499
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->syncSelectionCursors()V

    .line 6500
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsCaretSelection:Z

    if-eqz v0, :cond_48

    .line 6501
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->resetCaretTimer()V

    .line 6503
    :cond_48
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 6505
    :cond_4b
    return-void
.end method

.method private syncSelectionCursors()V
    .registers 5

    .prologue
    .line 5279
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    const/4 v1, 0x0

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeftTextQuad:Landroid/webkit/QuadF;

    invoke-static {v0, v1, v2, v3}, Landroid/webkit/WebViewClassic;->nativeGetHandleLayerId(IILandroid/graphics/Point;Landroid/webkit/QuadF;)I

    move-result v0

    iput v0, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeftLayerId:I

    .line 5282
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    const/4 v1, 0x1

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRight:Landroid/graphics/Point;

    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRightTextQuad:Landroid/webkit/QuadF;

    invoke-static {v0, v1, v2, v3}, Landroid/webkit/WebViewClassic;->nativeGetHandleLayerId(IILandroid/graphics/Point;Landroid/webkit/QuadF;)I

    move-result v0

    iput v0, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRightLayerId:I

    .line 5285
    return-void
.end method

.method private updateHwAccelerated()V
    .registers 5

    .prologue
    .line 8666
    iget v2, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v2, :cond_5

    .line 8680
    :cond_4
    :goto_4
    return-void

    .line 8669
    :cond_5
    const/4 v0, 0x0

    .line 8670
    .local v0, hwAccelerated:Z
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->isHardwareAccelerated()Z

    move-result v2

    if-eqz v2, :cond_18

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->getLayerType()I

    move-result v2

    const/4 v3, 0x1

    if-eq v2, v3, :cond_18

    .line 8672
    const/4 v0, 0x1

    .line 8676
    :cond_18
    iget v2, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    invoke-static {v2, v0}, Landroid/webkit/WebViewClassic;->nativeSetHwAccelerated(IZ)I

    move-result v1

    .line 8677
    .local v1, result:I
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-eqz v2, :cond_4

    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mBlockWebkitViewMessages:Z

    if-nez v2, :cond_4

    if-eqz v1, :cond_4

    .line 8678
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v2}, Landroid/webkit/WebViewCore;->contentDraw()V

    goto :goto_4
.end method

.method private updateTextSelectionFromMessage(IILandroid/webkit/WebViewCore$TextSelectionData;)V
    .registers 8
    .parameter "nodePointer"
    .parameter "textGeneration"
    .parameter "data"

    .prologue
    const/4 v0, 0x1

    .line 8107
    iget v1, p0, Landroid/webkit/WebViewClassic;->mTextGeneration:I

    if-ne p2, v1, :cond_16

    .line 8108
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    if-eqz v1, :cond_16

    iget v1, p0, Landroid/webkit/WebViewClassic;->mFieldPointer:I

    if-ne v1, p1, :cond_16

    .line 8109
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    iget v2, p3, Landroid/webkit/WebViewCore$TextSelectionData;->mStart:I

    iget v3, p3, Landroid/webkit/WebViewCore$TextSelectionData;->mEnd:I

    invoke-virtual {v1, v2, v3}, Landroid/webkit/WebViewClassic$WebViewInputConnection;->setSelection(II)Z

    .line 8112
    :cond_16
    iget v1, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    iget v2, p3, Landroid/webkit/WebViewCore$TextSelectionData;->mSelectTextPtr:I

    invoke-static {v1, v2}, Landroid/webkit/WebViewClassic;->nativeSetTextSelection(II)V

    .line 8114
    iget v1, p3, Landroid/webkit/WebViewCore$TextSelectionData;->mSelectionReason:I

    if-eq v1, v0, :cond_30

    iget-boolean v1, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-nez v1, :cond_39

    iget v1, p3, Landroid/webkit/WebViewCore$TextSelectionData;->mStart:I

    iget v2, p3, Landroid/webkit/WebViewCore$TextSelectionData;->mEnd:I

    if-eq v1, v2, :cond_39

    iget v1, p3, Landroid/webkit/WebViewCore$TextSelectionData;->mSelectionReason:I

    const/4 v2, 0x2

    if-eq v1, v2, :cond_39

    .line 8117
    :cond_30
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->selectionDone()V

    .line 8118
    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mShowTextSelectionExtra:Z

    .line 8119
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 8148
    :goto_38
    return-void

    .line 8123
    :cond_39
    iget v1, p3, Landroid/webkit/WebViewCore$TextSelectionData;->mSelectTextPtr:I

    if-eqz v1, :cond_8b

    iget v1, p3, Landroid/webkit/WebViewCore$TextSelectionData;->mStart:I

    iget v2, p3, Landroid/webkit/WebViewCore$TextSelectionData;->mEnd:I

    if-ne v1, v2, :cond_4b

    iget v1, p0, Landroid/webkit/WebViewClassic;->mFieldPointer:I

    if-ne v1, p1, :cond_8b

    iget v1, p0, Landroid/webkit/WebViewClassic;->mFieldPointer:I

    if-eqz v1, :cond_8b

    .line 8126
    :cond_4b
    iget v1, p3, Landroid/webkit/WebViewCore$TextSelectionData;->mStart:I

    iget v2, p3, Landroid/webkit/WebViewCore$TextSelectionData;->mEnd:I

    if-ne v1, v2, :cond_6e

    :goto_51
    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsCaretSelection:Z

    .line 8127
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsCaretSelection:Z

    if-eqz v0, :cond_70

    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    if-eqz v0, :cond_67

    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    invoke-virtual {v0}, Landroid/webkit/WebViewClassic$WebViewInputConnection;->getEditable()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->length()I

    move-result v0

    if-nez v0, :cond_70

    .line 8131
    :cond_67
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->selectionDone()V

    .line 8147
    :cond_6a
    :goto_6a
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    goto :goto_38

    .line 8126
    :cond_6e
    const/4 v0, 0x0

    goto :goto_51

    .line 8133
    :cond_70
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-nez v0, :cond_7f

    .line 8134
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->setupWebkitSelect()Z

    .line 8140
    :goto_77
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsCaretSelection:Z

    if-eqz v0, :cond_6a

    .line 8141
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->resetCaretTimer()V

    goto :goto_6a

    .line 8135
    :cond_7f
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mSelectionStarted:Z

    if-nez v0, :cond_87

    .line 8136
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->syncSelectionCursors()V

    goto :goto_77

    .line 8138
    :cond_87
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->adjustSelectionCursors()V

    goto :goto_77

    .line 8145
    :cond_8b
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->selectionDone()V

    goto :goto_6a
.end method

.method private updateWebkitSelection()V
    .registers 7

    .prologue
    const/16 v5, 0xd5

    const/4 v1, 0x0

    .line 5338
    const/4 v0, 0x0

    .line 5339
    .local v0, data:[I
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mIsCaretSelection:Z

    if-eqz v2, :cond_15

    .line 5340
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mSelectCursorRight:Landroid/graphics/Point;

    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->x:I

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    iget v4, v4, Landroid/graphics/Point;->y:I

    invoke-virtual {v2, v3, v4}, Landroid/graphics/Point;->set(II)V

    .line 5342
    :cond_15
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-eqz v2, :cond_34

    .line 5343
    const/4 v2, 0x5

    new-array v0, v2, [I

    .line 5344
    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->getSelectionHandles([I)V

    .line 5345
    const/4 v2, 0x4

    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mSelectDraggingCursor:Landroid/graphics/Point;

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mSelectCursorLeft:Landroid/graphics/Point;

    if-ne v3, v4, :cond_27

    const/4 v1, 0x1

    :cond_27
    aput v1, v0, v2

    .line 5349
    :goto_29
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v1, v5}, Landroid/webkit/WebViewCore;->removeMessages(I)V

    .line 5350
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v1, v5, v0}, Landroid/webkit/WebViewCore;->sendMessageAtFrontOfQueue(ILjava/lang/Object;)V

    .line 5351
    return-void

    .line 5347
    :cond_34
    iget v2, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    invoke-static {v2, v1}, Landroid/webkit/WebViewClassic;->nativeSetTextSelection(II)V

    goto :goto_29
.end method

.method private viewInvalidate()V
    .registers 1

    .prologue
    .line 8534
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 8535
    return-void
.end method

.method private viewInvalidate(IIII)V
    .registers 13
    .parameter "l"
    .parameter "t"
    .parameter "r"
    .parameter "b"

    .prologue
    .line 3047
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v2}, Landroid/webkit/ZoomManager;->getScale()F

    move-result v1

    .line 3048
    .local v1, scale:F
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v0

    .line 3049
    .local v0, dy:I
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    int-to-float v3, p1

    mul-float/2addr v3, v1

    float-to-double v3, v3

    invoke-static {v3, v4}, Ljava/lang/Math;->floor(D)D

    move-result-wide v3

    double-to-int v3, v3

    int-to-float v4, p2

    mul-float/2addr v4, v1

    float-to-double v4, v4

    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    double-to-int v4, v4

    add-int/2addr v4, v0

    int-to-float v5, p3

    mul-float/2addr v5, v1

    float-to-double v5, v5

    invoke-static {v5, v6}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v5

    double-to-int v5, v5

    int-to-float v6, p4

    mul-float/2addr v6, v1

    float-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v6

    double-to-int v6, v6

    add-int/2addr v6, v0

    invoke-virtual {v2, v3, v4, v5, v6}, Landroid/webkit/WebView;->invalidate(IIII)V

    .line 3053
    return-void
.end method

.method private viewInvalidateDelayed(JIIII)V
    .registers 16
    .parameter "delay"
    .parameter "l"
    .parameter "t"
    .parameter "r"
    .parameter "b"

    .prologue
    .line 3058
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->getScale()F

    move-result v8

    .line 3059
    .local v8, scale:F
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v7

    .line 3060
    .local v7, dy:I
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    int-to-float v1, p3

    mul-float/2addr v1, v8

    float-to-double v1, v1

    invoke-static {v1, v2}, Ljava/lang/Math;->floor(D)D

    move-result-wide v1

    double-to-int v3, v1

    int-to-float v1, p4

    mul-float/2addr v1, v8

    float-to-double v1, v1

    invoke-static {v1, v2}, Ljava/lang/Math;->floor(D)D

    move-result-wide v1

    double-to-int v1, v1

    add-int v4, v1, v7

    int-to-float v1, p5

    mul-float/2addr v1, v8

    float-to-double v1, v1

    invoke-static {v1, v2}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v1

    double-to-int v5, v1

    int-to-float v1, p6

    mul-float/2addr v1, v8

    float-to-double v1, v1

    invoke-static {v1, v2}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v1

    double-to-int v1, v1

    add-int v6, v1, v7

    move-wide v1, p1

    invoke-virtual/range {v0 .. v6}, Landroid/webkit/WebView;->postInvalidateDelayed(JIIII)V

    .line 3065
    return-void
.end method

.method private viewToContentDimension(I)I
    .registers 4
    .parameter "d"

    .prologue
    .line 2962
    int-to-float v0, p1

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v1}, Landroid/webkit/ZoomManager;->getInvScale()F

    move-result v1

    mul-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    return v0
.end method

.method private viewToContentVisibleRect(Landroid/graphics/RectF;Landroid/graphics/Rect;)V
    .registers 5
    .parameter "contentRect"
    .parameter "viewRect"

    .prologue
    .line 5635
    iget v0, p2, Landroid/graphics/Rect;->left:I

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->viewToContentXf(I)F

    move-result v0

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getScaleX()F

    move-result v1

    div-float/2addr v0, v1

    iput v0, p1, Landroid/graphics/RectF;->left:F

    .line 5640
    iget v0, p2, Landroid/graphics/Rect;->top:I

    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getVisibleTitleHeightImpl()I

    move-result v1

    add-int/2addr v0, v1

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->viewToContentYf(I)F

    move-result v0

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getScaleY()F

    move-result v1

    div-float/2addr v0, v1

    iput v0, p1, Landroid/graphics/RectF;->top:F

    .line 5642
    iget v0, p2, Landroid/graphics/Rect;->right:I

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->viewToContentXf(I)F

    move-result v0

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getScaleX()F

    move-result v1

    div-float/2addr v0, v1

    iput v0, p1, Landroid/graphics/RectF;->right:F

    .line 5643
    iget v0, p2, Landroid/graphics/Rect;->bottom:I

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->viewToContentYf(I)F

    move-result v0

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getScaleY()F

    move-result v1

    div-float/2addr v0, v1

    iput v0, p1, Landroid/graphics/RectF;->bottom:F

    .line 5644
    return-void
.end method

.method private viewToContentXf(I)F
    .registers 4
    .parameter "x"

    .prologue
    .line 2987
    int-to-float v0, p1

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v1}, Landroid/webkit/ZoomManager;->getInvScale()F

    move-result v1

    mul-float/2addr v0, v1

    return v0
.end method

.method private viewToContentYf(I)F
    .registers 4
    .parameter "y"

    .prologue
    .line 2996
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v0

    sub-int v0, p1, v0

    int-to-float v0, v0

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v1}, Landroid/webkit/ZoomManager;->getInvScale()F

    move-result v1

    mul-float/2addr v0, v1

    return v0
.end method


# virtual methods
.method public addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V
    .registers 6
    .parameter "object"
    .parameter "name"

    .prologue
    .line 4113
    if-nez p1, :cond_3

    .line 4120
    :goto_2
    return-void

    .line 4116
    :cond_3
    new-instance v0, Landroid/webkit/WebViewCore$JSInterfaceData;

    invoke-direct {v0}, Landroid/webkit/WebViewCore$JSInterfaceData;-><init>()V

    .line 4117
    .local v0, arg:Landroid/webkit/WebViewCore$JSInterfaceData;
    iput-object p1, v0, Landroid/webkit/WebViewCore$JSInterfaceData;->mObject:Ljava/lang/Object;

    .line 4118
    iput-object p2, v0, Landroid/webkit/WebViewCore$JSInterfaceData;->mInterfaceName:Ljava/lang/String;

    .line 4119
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v2, 0x8a

    invoke-virtual {v1, v2, v0}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    goto :goto_2
.end method

.method adjustDefaultZoomDensity(I)V
    .registers 5
    .parameter "zoomDensity"

    .prologue
    .line 1811
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->density:F

    const/high16 v2, 0x42c8

    mul-float/2addr v1, v2

    int-to-float v2, p1

    div-float v0, v1, v2

    .line 1813
    .local v0, density:F
    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->updateDefaultZoomDensity(F)V

    .line 1814
    return-void
.end method

.method autoFillForm(I)V
    .registers 5
    .parameter "autoFillQueryId"

    .prologue
    .line 8640
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/16 v1, 0x94

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p1, v2}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 8642
    return-void
.end method

.method public canGoBack()Z
    .registers 4

    .prologue
    const/4 v1, 0x0

    .line 2650
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v2}, Landroid/webkit/CallbackProxy;->getBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v0

    .line 2651
    .local v0, l:Landroid/webkit/WebBackForwardList;
    monitor-enter v0

    .line 2652
    :try_start_8
    invoke-virtual {v0}, Landroid/webkit/WebBackForwardList;->getClearPending()Z

    move-result v2

    if-eqz v2, :cond_10

    .line 2653
    monitor-exit v0

    .line 2655
    :goto_f
    return v1

    :cond_10
    invoke-virtual {v0}, Landroid/webkit/WebBackForwardList;->getCurrentIndex()I

    move-result v2

    if-lez v2, :cond_17

    const/4 v1, 0x1

    :cond_17
    monitor-exit v0

    goto :goto_f

    .line 2657
    :catchall_19
    move-exception v1

    monitor-exit v0
    :try_end_1b
    .catchall {:try_start_8 .. :try_end_1b} :catchall_19

    throw v1
.end method

.method public canGoBackOrForward(I)Z
    .registers 6
    .parameter "steps"

    .prologue
    const/4 v2, 0x0

    .line 2696
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v3}, Landroid/webkit/CallbackProxy;->getBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v0

    .line 2697
    .local v0, l:Landroid/webkit/WebBackForwardList;
    monitor-enter v0

    .line 2698
    :try_start_8
    invoke-virtual {v0}, Landroid/webkit/WebBackForwardList;->getClearPending()Z

    move-result v3

    if-eqz v3, :cond_10

    .line 2699
    monitor-exit v0

    .line 2702
    :goto_f
    return v2

    .line 2701
    :cond_10
    invoke-virtual {v0}, Landroid/webkit/WebBackForwardList;->getCurrentIndex()I

    move-result v3

    add-int v1, v3, p1

    .line 2702
    .local v1, newIndex:I
    if-ltz v1, :cond_1f

    invoke-virtual {v0}, Landroid/webkit/WebBackForwardList;->getSize()I

    move-result v3

    if-ge v1, v3, :cond_1f

    const/4 v2, 0x1

    :cond_1f
    monitor-exit v0

    goto :goto_f

    .line 2704
    .end local v1           #newIndex:I
    :catchall_21
    move-exception v2

    monitor-exit v0
    :try_end_23
    .catchall {:try_start_8 .. :try_end_23} :catchall_21

    throw v2
.end method

.method public canGoForward()Z
    .registers 5

    .prologue
    const/4 v1, 0x0

    .line 2673
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v2}, Landroid/webkit/CallbackProxy;->getBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v0

    .line 2674
    .local v0, l:Landroid/webkit/WebBackForwardList;
    monitor-enter v0

    .line 2675
    :try_start_8
    invoke-virtual {v0}, Landroid/webkit/WebBackForwardList;->getClearPending()Z

    move-result v2

    if-eqz v2, :cond_10

    .line 2676
    monitor-exit v0

    .line 2678
    :goto_f
    return v1

    :cond_10
    invoke-virtual {v0}, Landroid/webkit/WebBackForwardList;->getCurrentIndex()I

    move-result v2

    invoke-virtual {v0}, Landroid/webkit/WebBackForwardList;->getSize()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    if-ge v2, v3, :cond_1d

    const/4 v1, 0x1

    :cond_1d
    monitor-exit v0

    goto :goto_f

    .line 2680
    :catchall_1f
    move-exception v1

    monitor-exit v0
    :try_end_21
    .catchall {:try_start_8 .. :try_end_21} :catchall_1f

    throw v1
.end method

.method public canZoomIn()Z
    .registers 2

    .prologue
    .line 6994
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->canZoomIn()Z

    move-result v0

    return v0
.end method

.method public canZoomOut()Z
    .registers 2

    .prologue
    .line 7002
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->canZoomOut()Z

    move-result v0

    return v0
.end method

.method public capturePicture()Landroid/graphics/Picture;
    .registers 3

    .prologue
    .line 2812
    iget v1, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v1, :cond_6

    const/4 v0, 0x0

    .line 2815
    :goto_5
    return-object v0

    .line 2813
    :cond_6
    new-instance v0, Landroid/graphics/Picture;

    invoke-direct {v0}, Landroid/graphics/Picture;-><init>()V

    .line 2814
    .local v0, result:Landroid/graphics/Picture;
    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->nativeCopyBaseContentToPicture(Landroid/graphics/Picture;)V

    goto :goto_5
.end method

.method centerFitRect(Landroid/graphics/Rect;)V
    .registers 29
    .parameter "rect"

    .prologue
    .line 7047
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Rect;->width()I

    move-result v17

    .line 7048
    .local v17, rectWidth:I
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Rect;->height()I

    move-result v12

    .line 7049
    .local v12, rectHeight:I
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getViewWidth()I

    move-result v20

    .line 7050
    .local v20, viewWidth:I
    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getViewHeightWithTitle()I

    move-result v19

    .line 7051
    .local v19, viewHeight:I
    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v23, v0

    move/from16 v0, v17

    int-to-float v0, v0

    move/from16 v24, v0

    div-float v23, v23, v24

    move/from16 v0, v19

    int-to-float v0, v0

    move/from16 v24, v0

    int-to-float v0, v12

    move/from16 v25, v0

    div-float v24, v24, v25

    invoke-static/range {v23 .. v24}, Ljava/lang/Math;->min(FF)F

    move-result v18

    .line 7053
    .local v18, scale:F
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/webkit/ZoomManager;->computeScaleWithLimits(F)F

    move-result v18

    .line 7054
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/webkit/ZoomManager;->willScaleTriggerZoom(F)Z

    move-result v23

    if-nez v23, :cond_86

    .line 7055
    move-object/from16 v0, p1

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v23, v0

    div-int/lit8 v24, v17, 0x2

    add-int v23, v23, v24

    move-object/from16 v0, p0

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewClassic;->contentToViewX(I)I

    move-result v23

    div-int/lit8 v24, v20, 0x2

    sub-int v23, v23, v24

    move-object/from16 v0, p1

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v24, v0

    div-int/lit8 v25, v12, 0x2

    add-int v24, v24, v25

    move-object/from16 v0, p0

    move/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v24

    div-int/lit8 v25, v19, 0x2

    sub-int v24, v24, v25

    const/16 v25, 0x1

    const/16 v26, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v23

    move/from16 v2, v24

    move/from16 v3, v25

    move/from16 v4, v26

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/webkit/WebViewClassic;->pinScrollTo(IIZI)Z

    .line 7090
    :goto_85
    return-void

    .line 7059
    :cond_86
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Landroid/webkit/ZoomManager;->getScale()F

    move-result v5

    .line 7060
    .local v5, actualScale:F
    move-object/from16 v0, p1

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v23, v0

    move/from16 v0, v23

    int-to-float v0, v0

    move/from16 v23, v0

    mul-float v23, v23, v5

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v24

    move/from16 v0, v24

    int-to-float v0, v0

    move/from16 v24, v0

    sub-float v10, v23, v24

    .line 7061
    .local v10, oldScreenX:F
    move-object/from16 v0, p1

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v23, v0

    move/from16 v0, v23

    int-to-float v0, v0

    move/from16 v23, v0

    mul-float v15, v23, v18

    .line 7062
    .local v15, rectViewX:F
    move/from16 v0, v17

    int-to-float v0, v0

    move/from16 v23, v0

    mul-float v14, v23, v18

    .line 7063
    .local v14, rectViewWidth:F
    move-object/from16 v0, p0

    iget v0, v0, Landroid/webkit/WebViewClassic;->mContentWidth:I

    move/from16 v23, v0

    move/from16 v0, v23

    int-to-float v0, v0

    move/from16 v23, v0

    mul-float v7, v23, v18

    .line 7064
    .local v7, newMaxWidth:F
    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v23, v0

    sub-float v23, v23, v14

    const/high16 v24, 0x4000

    div-float v8, v23, v24

    .line 7066
    .local v8, newScreenX:F
    cmpl-float v23, v8, v15

    if-lez v23, :cond_178

    .line 7067
    move v8, v15

    .line 7071
    :cond_d9
    :goto_d9
    mul-float v23, v10, v18

    mul-float v24, v8, v5

    sub-float v23, v23, v24

    sub-float v24, v18, v5

    div-float v21, v23, v24

    .line 7073
    .local v21, zoomCenterX:F
    move-object/from16 v0, p1

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v23, v0

    move/from16 v0, v23

    int-to-float v0, v0

    move/from16 v23, v0

    mul-float v23, v23, v5

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v24

    move/from16 v0, v24

    int-to-float v0, v0

    move/from16 v24, v0

    add-float v23, v23, v24

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v24

    move/from16 v0, v24

    int-to-float v0, v0

    move/from16 v24, v0

    sub-float v11, v23, v24

    .line 7075
    .local v11, oldScreenY:F
    move-object/from16 v0, p1

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v23, v0

    move/from16 v0, v23

    int-to-float v0, v0

    move/from16 v23, v0

    mul-float v23, v23, v18

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v24

    move/from16 v0, v24

    int-to-float v0, v0

    move/from16 v24, v0

    add-float v16, v23, v24

    .line 7076
    .local v16, rectViewY:F
    int-to-float v0, v12

    move/from16 v23, v0

    mul-float v13, v23, v18

    .line 7077
    .local v13, rectViewHeight:F
    move-object/from16 v0, p0

    iget v0, v0, Landroid/webkit/WebViewClassic;->mContentHeight:I

    move/from16 v23, v0

    move/from16 v0, v23

    int-to-float v0, v0

    move/from16 v23, v0

    mul-float v23, v23, v18

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v24

    move/from16 v0, v24

    int-to-float v0, v0

    move/from16 v24, v0

    add-float v6, v23, v24

    .line 7078
    .local v6, newMaxHeight:F
    move/from16 v0, v19

    int-to-float v0, v0

    move/from16 v23, v0

    sub-float v23, v23, v13

    const/high16 v24, 0x4000

    div-float v9, v23, v24

    .line 7080
    .local v9, newScreenY:F
    cmpl-float v23, v9, v16

    if-lez v23, :cond_18b

    .line 7081
    move/from16 v9, v16

    .line 7085
    :cond_14c
    :goto_14c
    mul-float v23, v11, v18

    mul-float v24, v9, v5

    sub-float v23, v23, v24

    sub-float v24, v18, v5

    div-float v22, v23, v24

    .line 7087
    .local v22, zoomCenterY:F
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    move/from16 v1, v21

    move/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Landroid/webkit/ZoomManager;->setZoomCenter(FF)V

    .line 7088
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    move-object/from16 v23, v0

    const/16 v24, 0x0

    move-object/from16 v0, v23

    move/from16 v1, v18

    move/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Landroid/webkit/ZoomManager;->startZoomAnimation(FZ)Z

    goto/16 :goto_85

    .line 7068
    .end local v6           #newMaxHeight:F
    .end local v9           #newScreenY:F
    .end local v11           #oldScreenY:F
    .end local v13           #rectViewHeight:F
    .end local v16           #rectViewY:F
    .end local v21           #zoomCenterX:F
    .end local v22           #zoomCenterY:F
    :cond_178
    sub-float v23, v7, v15

    sub-float v23, v23, v14

    cmpl-float v23, v8, v23

    if-lez v23, :cond_d9

    .line 7069
    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v23, v0

    sub-float v24, v7, v15

    sub-float v8, v23, v24

    goto/16 :goto_d9

    .line 7082
    .restart local v6       #newMaxHeight:F
    .restart local v9       #newScreenY:F
    .restart local v11       #oldScreenY:F
    .restart local v13       #rectViewHeight:F
    .restart local v16       #rectViewY:F
    .restart local v21       #zoomCenterX:F
    :cond_18b
    sub-float v23, v6, v16

    sub-float v23, v23, v13

    cmpl-float v23, v9, v23

    if-lez v23, :cond_14c

    .line 7083
    move/from16 v0, v19

    int-to-float v0, v0

    move/from16 v23, v0

    sub-float v24, v6, v16

    sub-float v9, v23, v24

    goto :goto_14c
.end method

.method public checkIfReadModeAvailable()V
    .registers 4
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_METHOD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    .line 1289
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x1392

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/webkit/WebViewCore;->sendMessage(II)V

    .line 1290
    return-void
.end method

.method public checkIfReadModeAvailable(Z)V
    .registers 5
    .parameter "inSession"
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_METHOD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    .line 1299
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v2, 0x1392

    if-eqz p1, :cond_b

    const/4 v0, 0x1

    :goto_7
    invoke-virtual {v1, v2, v0}, Landroid/webkit/WebViewCore;->sendMessage(II)V

    .line 1300
    return-void

    .line 1299
    :cond_b
    const/4 v0, 0x0

    goto :goto_7
.end method

.method public clearCache(Z)V
    .registers 6
    .parameter "includeDiskFiles"

    .prologue
    const/4 v1, 0x0

    .line 3543
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v3, 0x6f

    if-eqz p1, :cond_c

    const/4 v0, 0x1

    :goto_8
    invoke-virtual {v2, v3, v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(III)V

    .line 3545
    return-void

    :cond_c
    move v0, v1

    .line 3543
    goto :goto_8
.end method

.method public clearFormData()V
    .registers 2

    .prologue
    .line 3552
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mAutoCompletePopup:Landroid/webkit/AutoCompletePopup;

    if-eqz v0, :cond_9

    .line 3553
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mAutoCompletePopup:Landroid/webkit/AutoCompletePopup;

    invoke-virtual {v0}, Landroid/webkit/AutoCompletePopup;->clearAdapter()V

    .line 3555
    :cond_9
    return-void
.end method

.method public clearHistory()V
    .registers 3

    .prologue
    .line 3562
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v0}, Landroid/webkit/CallbackProxy;->getBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebBackForwardList;->setClearPending()V

    .line 3563
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x70

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 3564
    return-void
.end method

.method public clearMatches()V
    .registers 4

    .prologue
    const/16 v2, 0xdd

    .line 3748
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v0, :cond_7

    .line 3752
    :goto_6
    return-void

    .line 3750
    :cond_7
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v0, v2}, Landroid/webkit/WebViewCore;->removeMessages(I)V

    .line 3751
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/4 v1, 0x0

    invoke-virtual {v0, v2, v1}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    goto :goto_6
.end method

.method public clearSslPreferences()V
    .registers 3

    .prologue
    .line 3571
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x96

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 3572
    return-void
.end method

.method public clearView()V
    .registers 3

    .prologue
    const/4 v0, 0x0

    .line 2801
    iput v0, p0, Landroid/webkit/WebViewClassic;->mContentWidth:I

    .line 2802
    iput v0, p0, Landroid/webkit/WebViewClassic;->mContentHeight:I

    .line 2803
    invoke-virtual {p0, v0, v0, v0}, Landroid/webkit/WebViewClassic;->setBaseLayer(IZZ)V

    .line 2804
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x86

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 2805
    return-void
.end method

.method public clearViewState()V
    .registers 2

    .prologue
    .line 2438
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mBlockWebkitViewMessages:Z

    .line 2439
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mLoadedPicture:Landroid/webkit/WebViewCore$DrawData;

    .line 2440
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 2441
    return-void
.end method

.method public computeHorizontalScrollOffset()I
    .registers 3

    .prologue
    .line 3284
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method public computeHorizontalScrollRange()I
    .registers 5

    .prologue
    .line 3268
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->computeRealHorizontalScrollRange()I

    move-result v1

    .line 3271
    .local v1, range:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v2

    .line 3272
    .local v2, scrollX:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollX()I

    move-result v0

    .line 3273
    .local v0, overscrollRight:I
    if-gez v2, :cond_10

    .line 3274
    sub-int/2addr v1, v2

    .line 3279
    :cond_f
    :goto_f
    return v1

    .line 3275
    :cond_10
    if-le v2, v0, :cond_f

    .line 3276
    sub-int v3, v2, v0

    add-int/2addr v1, v3

    goto :goto_f
.end method

.method computeMaxScrollX()I
    .registers 3

    .prologue
    .line 6823
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->computeRealHorizontalScrollRange()I

    move-result v0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getViewWidth()I

    move-result v1

    sub-int/2addr v0, v1

    const/4 v1, 0x0

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method computeMaxScrollY()I
    .registers 3

    .prologue
    .line 6831
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->computeRealVerticalScrollRange()I

    move-result v0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v1

    add-int/2addr v0, v1

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getViewHeightWithTitle()I

    move-result v1

    sub-int/2addr v0, v1

    const/4 v1, 0x0

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method computeReadingLevelScale(F)F
    .registers 3
    .parameter "scale"

    .prologue
    .line 2832
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0, p1}, Landroid/webkit/ZoomManager;->computeReadingLevelScale(F)F

    move-result v0

    return v0
.end method

.method public computeScroll()V
    .registers 13

    .prologue
    const/16 v2, 0xa

    const/16 v1, 0x9

    const/4 v9, 0x0

    .line 3793
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v0}, Landroid/widget/OverScroller;->computeScrollOffset()Z

    move-result v0

    if-eqz v0, :cond_b3

    .line 3794
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    .line 3795
    .local v3, oldX:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v4

    .line 3796
    .local v4, oldY:I
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v0}, Landroid/widget/OverScroller;->getCurrX()I

    move-result v10

    .line 3797
    .local v10, x:I
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v0}, Landroid/widget/OverScroller;->getCurrY()I

    move-result v11

    .line 3798
    .local v11, y:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 3800
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v0}, Landroid/widget/OverScroller;->isFinished()Z

    move-result v0

    if-nez v0, :cond_77

    .line 3801
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollX()I

    move-result v5

    .line 3802
    .local v5, rangeX:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollY()I

    move-result v6

    .line 3803
    .local v6, rangeY:I
    iget v7, p0, Landroid/webkit/WebViewClassic;->mOverflingDistance:I

    .line 3806
    .local v7, overflingDistance:I
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    if-ne v0, v1, :cond_61

    .line 3807
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v3, v0, Landroid/graphics/Rect;->left:I

    .line 3808
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v4, v0, Landroid/graphics/Rect;->top:I

    .line 3809
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v5, v0, Landroid/graphics/Rect;->right:I

    .line 3810
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScrollingLayerRect:Landroid/graphics/Rect;

    iget v6, v0, Landroid/graphics/Rect;->bottom:I

    .line 3812
    const/4 v7, 0x0

    .line 3821
    :cond_4b
    :goto_4b
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    sub-int v1, v10, v3

    sub-int v2, v11, v4

    move v8, v7

    invoke-virtual/range {v0 .. v9}, Landroid/webkit/WebView$PrivateAccess;->overScrollBy(IIIIIIIIZ)V

    .line 3825
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mOverScrollGlow:Landroid/webkit/OverScrollGlow;

    if-eqz v0, :cond_60

    .line 3826
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mOverScrollGlow:Landroid/webkit/OverScrollGlow;

    move v1, v10

    move v2, v11

    invoke-virtual/range {v0 .. v6}, Landroid/webkit/OverScrollGlow;->absorbGlow(IIIIII)V

    .line 3853
    .end local v3           #oldX:I
    .end local v4           #oldY:I
    .end local v5           #rangeX:I
    .end local v6           #rangeY:I
    .end local v7           #overflingDistance:I
    .end local v10           #x:I
    .end local v11           #y:I
    :cond_60
    :goto_60
    return-void

    .line 3813
    .restart local v3       #oldX:I
    .restart local v4       #oldY:I
    .restart local v5       #rangeX:I
    .restart local v6       #rangeY:I
    .restart local v7       #overflingDistance:I
    .restart local v10       #x:I
    .restart local v11       #y:I
    :cond_61
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    if-ne v0, v2, :cond_4b

    .line 3814
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getTextScrollX()I

    move-result v3

    .line 3815
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getTextScrollY()I

    move-result v4

    .line 3816
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getMaxTextScrollX()I

    move-result v5

    .line 3817
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getMaxTextScrollY()I

    move-result v6

    .line 3818
    const/4 v7, 0x0

    goto :goto_4b

    .line 3829
    .end local v5           #rangeX:I
    .end local v6           #rangeY:I
    .end local v7           #overflingDistance:I
    :cond_77
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    if-ne v0, v1, :cond_a4

    .line 3831
    invoke-direct {p0, v10, v11}, Landroid/webkit/WebViewClassic;->scrollLayerTo(II)V

    .line 3838
    :goto_7e
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->abortAnimation()V

    .line 3839
    invoke-direct {p0, v9}, Landroid/webkit/WebViewClassic;->nativeSetIsScrolling(Z)V

    .line 3840
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mBlockWebkitViewMessages:Z

    if-nez v0, :cond_94

    .line 3841
    invoke-static {}, Landroid/webkit/WebViewCore;->resumePriority()V

    .line 3842
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-nez v0, :cond_94

    .line 3843
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-static {v0}, Landroid/webkit/WebViewCore;->resumeUpdatePicture(Landroid/webkit/WebViewCore;)V

    .line 3846
    :cond_94
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v0

    if-ne v3, v0, :cond_a0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v0

    if-eq v4, v0, :cond_60

    .line 3847
    :cond_a0
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->sendOurVisibleRect()Landroid/graphics/Rect;

    goto :goto_60

    .line 3832
    :cond_a4
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    if-ne v0, v2, :cond_ac

    .line 3833
    invoke-direct {p0, v10, v11}, Landroid/webkit/WebViewClassic;->scrollEditText(II)V

    goto :goto_7e

    .line 3835
    :cond_ac
    invoke-virtual {p0, v10}, Landroid/webkit/WebViewClassic;->setScrollXRaw(I)V

    .line 3836
    invoke-virtual {p0, v11}, Landroid/webkit/WebViewClassic;->setScrollYRaw(I)V

    goto :goto_7e

    .line 3851
    .end local v3           #oldX:I
    .end local v4           #oldY:I
    .end local v10           #x:I
    .end local v11           #y:I
    :cond_b3
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v0}, Landroid/webkit/WebView$PrivateAccess;->super_computeScroll()V

    goto :goto_60
.end method

.method public computeVerticalScrollExtent()I
    .registers 2

    .prologue
    .line 3319
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getViewHeight()I

    move-result v0

    return v0
.end method

.method public computeVerticalScrollOffset()I
    .registers 3

    .prologue
    .line 3314
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v1

    sub-int/2addr v0, v1

    const/4 v1, 0x0

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method public computeVerticalScrollRange()I
    .registers 5

    .prologue
    .line 3298
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->computeRealVerticalScrollRange()I

    move-result v1

    .line 3301
    .local v1, range:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v2

    .line 3302
    .local v2, scrollY:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollY()I

    move-result v0

    .line 3303
    .local v0, overscrollBottom:I
    if-gez v2, :cond_10

    .line 3304
    sub-int/2addr v1, v2

    .line 3309
    :cond_f
    :goto_f
    return v1

    .line 3305
    :cond_10
    if-le v2, v0, :cond_f

    .line 3306
    sub-int v3, v2, v0

    add-int/2addr v1, v3

    goto :goto_f
.end method

.method protected contentInvalidateAll()V
    .registers 3

    .prologue
    .line 8650
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-eqz v0, :cond_f

    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mBlockWebkitViewMessages:Z

    if-nez v0, :cond_f

    .line 8651
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0xaf

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 8653
    :cond_f
    return-void
.end method

.method contentToViewDimension(I)I
    .registers 4
    .parameter "d"

    .prologue
    .line 3006
    int-to-float v0, p1

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v1}, Landroid/webkit/ZoomManager;->getScale()F

    move-result v1

    mul-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    return v0
.end method

.method contentToViewX(I)I
    .registers 3
    .parameter "x"

    .prologue
    .line 3014
    invoke-virtual {p0, p1}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v0

    return v0
.end method

.method contentToViewY(I)I
    .registers 4
    .parameter "y"

    .prologue
    .line 3022
    invoke-virtual {p0, p1}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public copyBackForwardList()Landroid/webkit/WebBackForwardList;
    .registers 2

    .prologue
    .line 3579
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v0}, Landroid/webkit/CallbackProxy;->getBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebBackForwardList;->clone()Landroid/webkit/WebBackForwardList;

    move-result-object v0

    return-object v0
.end method

.method public copySelection()Z
    .registers 8

    .prologue
    .line 5403
    const/4 v1, 0x0

    .line 5404
    .local v1, copiedSomething:Z
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSelection()Ljava/lang/String;

    move-result-object v3

    .line 5405
    .local v3, selection:Ljava/lang/String;
    if-eqz v3, :cond_33

    const-string v4, ""

    if-eq v3, v4, :cond_33

    .line 5409
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    const v5, 0x1040396

    const/4 v6, 0x0

    invoke-static {v4, v5, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/Toast;->show()V

    .line 5412
    const/4 v1, 0x1

    .line 5413
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    const-string v5, "clipboard"

    invoke-virtual {v4, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ClipboardManager;

    .line 5415
    .local v0, cm:Landroid/content/ClipboardManager;
    invoke-virtual {v0, v3}, Landroid/content/ClipboardManager;->setText(Ljava/lang/CharSequence;)V

    .line 5416
    const/4 v4, 0x4

    new-array v2, v4, [I

    .line 5417
    .local v2, handles:[I
    invoke-direct {p0, v2}, Landroid/webkit/WebViewClassic;->getSelectionHandles([I)V

    .line 5418
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v5, 0xd2

    invoke-virtual {v4, v5, v2}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 5420
    .end local v0           #cm:Landroid/content/ClipboardManager;
    .end local v2           #handles:[I
    :cond_33
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 5421
    return v1
.end method

.method public cutSelection()V
    .registers 4

    .prologue
    .line 5430
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->copySelection()Z

    .line 5431
    const/4 v1, 0x4

    new-array v0, v1, [I

    .line 5432
    .local v0, handles:[I
    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->getSelectionHandles([I)V

    .line 5433
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v2, 0xd3

    invoke-virtual {v1, v2, v0}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 5434
    return-void
.end method

.method public debugDump()V
    .registers 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 8606
    return-void
.end method

.method deleteSelection(II)V
    .registers 8
    .parameter "start"
    .parameter "end"

    .prologue
    const/4 v4, 0x0

    .line 4788
    iget v1, p0, Landroid/webkit/WebViewClassic;->mTextGeneration:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroid/webkit/WebViewClassic;->mTextGeneration:I

    .line 4789
    new-instance v0, Landroid/webkit/WebViewCore$TextSelectionData;

    invoke-direct {v0, p1, p2, v4}, Landroid/webkit/WebViewCore$TextSelectionData;-><init>(III)V

    .line 4791
    .local v0, data:Landroid/webkit/WebViewCore$TextSelectionData;
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v2, 0x7a

    iget v3, p0, Landroid/webkit/WebViewClassic;->mTextGeneration:I

    invoke-virtual {v1, v2, v3, v4, v0}, Landroid/webkit/WebViewCore;->sendMessage(IIILjava/lang/Object;)V

    .line 4793
    return-void
.end method

.method public destroy()V
    .registers 3

    .prologue
    .line 2104
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getViewRootImpl()Landroid/view/ViewRootImpl;

    move-result-object v0

    if-eqz v0, :cond_10

    .line 2105
    const-string/jumbo v0, "webview"

    const-string v1, "Error: WebView.destroy() called while still attached!"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2107
    :cond_10
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->ensureFunctorDetached()V

    .line 2108
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->destroyJava()V

    .line 2109
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->destroyNative()V

    .line 2110
    return-void
.end method

.method public discardAllTextures()V
    .registers 1

    .prologue
    .line 8657
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->nativeDiscardAllTextures()V

    .line 8658
    return-void
.end method

.method dismissZoomControl()V
    .registers 2

    .prologue
    .line 6974
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->dismissZoomPicker()V

    .line 6975
    return-void
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .registers 5
    .parameter "event"

    .prologue
    .line 5768
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    packed-switch v1, :pswitch_data_36

    .line 5792
    :goto_7
    :pswitch_7
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v1, p1}, Landroid/webkit/WebView$PrivateAccess;->super_dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v1

    :goto_d
    return v1

    .line 5770
    :pswitch_e
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mKeysPressed:Ljava/util/Vector;

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    goto :goto_7

    .line 5776
    :pswitch_1c
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mKeysPressed:Ljava/util/Vector;

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/Vector;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 5777
    .local v0, location:I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_2f

    .line 5780
    const/4 v1, 0x0

    goto :goto_d

    .line 5784
    :cond_2f
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mKeysPressed:Ljava/util/Vector;

    invoke-virtual {v1, v0}, Ljava/util/Vector;->remove(I)Ljava/lang/Object;

    goto :goto_7

    .line 5768
    nop

    :pswitch_data_36
    .packed-switch 0x0
        :pswitch_e
        :pswitch_1c
        :pswitch_7
    .end packed-switch
.end method

.method public documentAsText(Landroid/os/Message;)V
    .registers 4
    .parameter "callback"

    .prologue
    .line 4105
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0xa1

    invoke-virtual {v0, v1, p1}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 4106
    return-void
.end method

.method public documentHasImages(Landroid/os/Message;)V
    .registers 4
    .parameter "response"

    .prologue
    .line 3777
    if-nez p1, :cond_3

    .line 3781
    :goto_2
    return-void

    .line 3780
    :cond_3
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x78

    invoke-virtual {v0, v1, p1}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    goto :goto_2
.end method

.method drawHistory()Z
    .registers 2

    .prologue
    .line 4754
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mDrawHistory:Z

    return v0
.end method

.method public dumpDisplayTree()V
    .registers 2

    .prologue
    .line 4945
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->nativeDumpDisplayTree(Ljava/lang/String;)V

    .line 4946
    return-void
.end method

.method public dumpDomTree(Z)V
    .registers 6
    .parameter "toFile"

    .prologue
    const/4 v1, 0x0

    .line 4955
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v3, 0xaa

    if-eqz p1, :cond_c

    const/4 v0, 0x1

    :goto_8
    invoke-virtual {v2, v3, v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(III)V

    .line 4956
    return-void

    :cond_c
    move v0, v1

    .line 4955
    goto :goto_8
.end method

.method public dumpRenderTree(Z)V
    .registers 6
    .parameter "toFile"

    .prologue
    const/4 v1, 0x0

    .line 4965
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v3, 0xab

    if-eqz p1, :cond_c

    const/4 v0, 0x1

    :goto_8
    invoke-virtual {v2, v3, v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(III)V

    .line 4966
    return-void

    :cond_c
    move v0, v1

    .line 4965
    goto :goto_8
.end method

.method public emulateShiftHeld()V
    .registers 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 5368
    return-void
.end method

.method public enterReadMode()V
    .registers 2
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_METHOD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    .line 1277
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v0}, Landroid/webkit/WebViewCore;->getReadModeString()[Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_8

    .line 1280
    :cond_8
    return-void
.end method

.method public externalRepresentation(Landroid/os/Message;)V
    .registers 4
    .parameter "callback"

    .prologue
    .line 4100
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0xa0

    invoke-virtual {v0, v1, p1}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 4101
    return-void
.end method

.method protected finalize()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 4166
    :try_start_0
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->destroy()V
    :try_end_3
    .catchall {:try_start_0 .. :try_end_3} :catchall_7

    .line 4168
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 4170
    return-void

    .line 4168
    :catchall_7
    move-exception v0

    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    throw v0
.end method

.method public findAll(Ljava/lang/String;)I
    .registers 3
    .parameter "find"

    .prologue
    .line 3606
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/webkit/WebViewClassic;->findAllBody(Ljava/lang/String;Z)I

    move-result v0

    return v0
.end method

.method public findAllAsync(Ljava/lang/String;)V
    .registers 3
    .parameter "find"

    .prologue
    .line 3610
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Landroid/webkit/WebViewClassic;->findAllBody(Ljava/lang/String;Z)I

    .line 3611
    return-void
.end method

.method public findNext(Z)V
    .registers 6
    .parameter "forward"

    .prologue
    .line 3595
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v0, :cond_5

    .line 3599
    :cond_4
    :goto_4
    return-void

    .line 3596
    :cond_5
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mFindRequest:Landroid/webkit/WebViewCore$FindAllRequest;

    if-eqz v0, :cond_4

    .line 3597
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v2, 0xde

    if-eqz p1, :cond_16

    const/4 v0, 0x1

    :goto_10
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mFindRequest:Landroid/webkit/WebViewCore$FindAllRequest;

    invoke-virtual {v1, v2, v0, v3}, Landroid/webkit/WebViewCore;->sendMessage(IILjava/lang/Object;)V

    goto :goto_4

    :cond_16
    const/4 v0, 0x0

    goto :goto_10
.end method

.method public flingScroll(II)V
    .registers 14
    .parameter "vx"
    .parameter "vy"

    .prologue
    const/4 v5, 0x0

    .line 6849
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v1

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v2

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollX()I

    move-result v6

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollY()I

    move-result v8

    iget v9, p0, Landroid/webkit/WebViewClassic;->mOverflingDistance:I

    iget v10, p0, Landroid/webkit/WebViewClassic;->mOverflingDistance:I

    move v3, p1

    move v4, p2

    move v7, v5

    invoke-virtual/range {v0 .. v10}, Landroid/widget/OverScroller;->fling(IIIIIIIIII)V

    .line 6851
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 6852
    return-void
.end method

.method focusCandidateIsEditableText()Z
    .registers 2

    .prologue
    .line 8726
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    if-eqz v0, :cond_9

    .line 8727
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget-boolean v0, v0, Landroid/webkit/WebViewCore$WebKitHitTest;->mEditable:Z

    .line 8729
    :goto_8
    return v0

    :cond_9
    const/4 v0, 0x0

    goto :goto_8
.end method

.method public freeMemory()V
    .registers 3

    .prologue
    .line 3532
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x91

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 3533
    return-void
.end method

.method getBaseLayer()I
    .registers 2

    .prologue
    .line 4475
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v0, :cond_6

    .line 4476
    const/4 v0, 0x0

    .line 4478
    :goto_5
    return v0

    :cond_6
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->nativeGetBaseLayer(I)I

    move-result v0

    goto :goto_5
.end method

.method getBlockLeftEdge(IIF)I
    .registers 12
    .parameter "x"
    .parameter "y"
    .parameter "readingScale"

    .prologue
    .line 2868
    const/high16 v6, 0x3f80

    div-float v1, v6, p3

    .line 2869
    .local v1, invReadingScale:F
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getViewWidth()I

    move-result v6

    int-to-float v6, v6

    mul-float/2addr v6, v1

    float-to-int v4, v6

    .line 2870
    .local v4, readingWidth:I
    const/4 v2, -0x1

    .line 2871
    .local v2, left:I
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    if-eqz v6, :cond_31

    .line 2872
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget-object v6, v6, Landroid/webkit/WebViewCore$WebKitHitTest;->mEnclosingParentRects:[Landroid/graphics/Rect;

    array-length v3, v6

    .line 2873
    .local v3, length:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_16
    if-ge v0, v3, :cond_31

    .line 2874
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget-object v6, v6, Landroid/webkit/WebViewCore$WebKitHitTest;->mEnclosingParentRects:[Landroid/graphics/Rect;

    aget-object v5, v6, v0

    .line 2875
    .local v5, rect:Landroid/graphics/Rect;
    invoke-virtual {v5}, Landroid/graphics/Rect;->width()I

    move-result v6

    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget v7, v7, Landroid/webkit/WebViewCore$WebKitHitTest;->mHitTestSlop:I

    if-ge v6, v7, :cond_2b

    .line 2873
    :goto_28
    add-int/lit8 v0, v0, 0x1

    goto :goto_16

    .line 2878
    :cond_2b
    invoke-virtual {v5}, Landroid/graphics/Rect;->width()I

    move-result v6

    if-le v6, v4, :cond_32

    .line 2888
    .end local v0           #i:I
    .end local v3           #length:I
    .end local v5           #rect:Landroid/graphics/Rect;
    :cond_31
    return v2

    .line 2884
    .restart local v0       #i:I
    .restart local v3       #length:I
    .restart local v5       #rect:Landroid/graphics/Rect;
    :cond_32
    iget v2, v5, Landroid/graphics/Rect;->left:I

    goto :goto_28
.end method

.method public getCertificate()Landroid/net/http/SslCertificate;
    .registers 2

    .prologue
    .line 2026
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mCertificate:Landroid/net/http/SslCertificate;

    return-object v0
.end method

.method public getContentHeight()I
    .registers 2

    .prologue
    .line 3427
    iget v0, p0, Landroid/webkit/WebViewClassic;->mContentHeight:I

    return v0
.end method

.method public getContentWidth()I
    .registers 2

    .prologue
    .line 3435
    iget v0, p0, Landroid/webkit/WebViewClassic;->mContentWidth:I

    return v0
.end method

.method getContext()Landroid/content/Context;
    .registers 2

    .prologue
    .line 1466
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method getDefaultZoomScale()F
    .registers 2

    .prologue
    .line 6978
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->getDefaultScale()F

    move-result v0

    return v0
.end method

.method public getFavicon()Landroid/graphics/Bitmap;
    .registers 3

    .prologue
    .line 3401
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v1}, Landroid/webkit/CallbackProxy;->getBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebBackForwardList;->getCurrentItem()Landroid/webkit/WebHistoryItem;

    move-result-object v0

    .line 3402
    .local v0, h:Landroid/webkit/WebHistoryItem;
    if-eqz v0, :cond_11

    invoke-virtual {v0}, Landroid/webkit/WebHistoryItem;->getFavicon()Landroid/graphics/Bitmap;

    move-result-object v1

    :goto_10
    return-object v1

    :cond_11
    const/4 v1, 0x0

    goto :goto_10
.end method

.method getHeight()I
    .registers 2

    .prologue
    .line 1462
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getHeight()I

    move-result v0

    return v0
.end method

.method getHistoryPictureWidth()I
    .registers 2

    .prologue
    .line 4758
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHistoryPicture:Landroid/graphics/Picture;

    if-eqz v0, :cond_b

    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHistoryPicture:Landroid/graphics/Picture;

    invoke-virtual {v0}, Landroid/graphics/Picture;->getWidth()I

    move-result v0

    :goto_a
    return v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method public getHitTestResult()Landroid/webkit/WebView$HitTestResult;
    .registers 2

    .prologue
    .line 2861
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    return-object v0
.end method

.method public getHttpAuthUsernamePassword(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    .registers 4
    .parameter "host"
    .parameter "realm"

    .prologue
    .line 2067
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mDatabase:Landroid/webkit/WebViewDatabaseClassic;

    invoke-virtual {v0, p1, p2}, Landroid/webkit/WebViewDatabaseClassic;->getHttpAuthUsernamePassword(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getOriginalUrl()Ljava/lang/String;
    .registers 3

    .prologue
    .line 3383
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v1}, Landroid/webkit/CallbackProxy;->getBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebBackForwardList;->getCurrentItem()Landroid/webkit/WebHistoryItem;

    move-result-object v0

    .line 3384
    .local v0, h:Landroid/webkit/WebHistoryItem;
    if-eqz v0, :cond_11

    invoke-virtual {v0}, Landroid/webkit/WebHistoryItem;->getOriginalUrl()Ljava/lang/String;

    move-result-object v1

    :goto_10
    return-object v1

    :cond_11
    const/4 v1, 0x0

    goto :goto_10
.end method

.method public getPageBackgroundColor()I
    .registers 2

    .prologue
    .line 3439
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v0, :cond_6

    const/4 v0, -0x1

    .line 3444
    :goto_5
    return v0

    .line 3440
    :cond_6
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebSettingsClassic;->getNightReadModeEnabled()Z

    move-result v0

    if-eqz v0, :cond_13

    .line 3441
    const/high16 v0, -0x100

    goto :goto_5

    .line 3444
    :cond_13
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->nativeGetBackgroundColor(I)I

    move-result v0

    goto :goto_5
.end method

.method public getProgress()I
    .registers 2

    .prologue
    .line 3419
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v0}, Landroid/webkit/CallbackProxy;->getProgress()I

    move-result v0

    return v0
.end method

.method public getScale()F
    .registers 2

    .prologue
    .line 2823
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->getScale()F

    move-result v0

    return v0
.end method

.method getScaledNavSlop()I
    .registers 2

    .prologue
    .line 1822
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNavSlop:I

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->viewToContentDimension(I)I

    move-result v0

    return v0
.end method

.method public getScrollDelegate()Landroid/webkit/WebViewProvider$ScrollDelegate;
    .registers 1

    .prologue
    .line 1441
    return-object p0
.end method

.method getScrollX()I
    .registers 2

    .prologue
    .line 1450
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getScrollX()I

    move-result v0

    return v0
.end method

.method getScrollY()I
    .registers 2

    .prologue
    .line 1454
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getScrollY()I

    move-result v0

    return v0
.end method

.method public getSearchBox()Landroid/webkit/SearchBox;
    .registers 2

    .prologue
    .line 5458
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-eqz v0, :cond_c

    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v0}, Landroid/webkit/WebViewCore;->getBrowserFrame()Landroid/webkit/BrowserFrame;

    move-result-object v0

    if-nez v0, :cond_e

    .line 5459
    :cond_c
    const/4 v0, 0x0

    .line 5461
    :goto_d
    return-object v0

    :cond_e
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v0}, Landroid/webkit/WebViewCore;->getBrowserFrame()Landroid/webkit/BrowserFrame;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/BrowserFrame;->getSearchBox()Landroid/webkit/SearchBox;

    move-result-object v0

    goto :goto_d
.end method

.method getSelection()Ljava/lang/String;
    .registers 2

    .prologue
    .line 5468
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v0, :cond_7

    const-string v0, ""

    .line 5469
    :goto_6
    return-object v0

    :cond_7
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->nativeGetSelection()Ljava/lang/String;

    move-result-object v0

    goto :goto_6
.end method

.method public bridge synthetic getSettings()Landroid/webkit/WebSettings;
    .registers 2

    .prologue
    .line 147
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v0

    return-object v0
.end method

.method public getSettings()Landroid/webkit/WebSettingsClassic;
    .registers 2

    .prologue
    .line 4141
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-eqz v0, :cond_b

    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v0}, Landroid/webkit/WebViewCore;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v0

    :goto_a
    return-object v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method public getTitle()Ljava/lang/String;
    .registers 3

    .prologue
    .line 3392
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v1}, Landroid/webkit/CallbackProxy;->getBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebBackForwardList;->getCurrentItem()Landroid/webkit/WebHistoryItem;

    move-result-object v0

    .line 3393
    .local v0, h:Landroid/webkit/WebHistoryItem;
    if-eqz v0, :cond_11

    invoke-virtual {v0}, Landroid/webkit/WebHistoryItem;->getTitle()Ljava/lang/String;

    move-result-object v1

    :goto_10
    return-object v1

    :cond_11
    const/4 v1, 0x0

    goto :goto_10
.end method

.method protected getTitleHeight()I
    .registers 2

    .prologue
    .line 1967
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    instance-of v0, v0, Landroid/webkit/WebViewClassic$TitleBarDelegate;

    if-eqz v0, :cond_f

    .line 1968
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    check-cast v0, Landroid/webkit/WebViewClassic$TitleBarDelegate;

    invoke-interface {v0}, Landroid/webkit/WebViewClassic$TitleBarDelegate;->getTitleHeight()I

    move-result v0

    .line 1970
    :goto_e
    return v0

    :cond_f
    const/4 v0, 0x0

    goto :goto_e
.end method

.method public getTouchIconUrl()Ljava/lang/String;
    .registers 3

    .prologue
    .line 3410
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v1}, Landroid/webkit/CallbackProxy;->getBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebBackForwardList;->getCurrentItem()Landroid/webkit/WebHistoryItem;

    move-result-object v0

    .line 3411
    .local v0, h:Landroid/webkit/WebHistoryItem;
    if-eqz v0, :cond_11

    invoke-virtual {v0}, Landroid/webkit/WebHistoryItem;->getTouchIconUrl()Ljava/lang/String;

    move-result-object v1

    :goto_10
    return-object v1

    :cond_11
    const/4 v1, 0x0

    goto :goto_10
.end method

.method public getUrl()Ljava/lang/String;
    .registers 3

    .prologue
    .line 3374
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v1}, Landroid/webkit/CallbackProxy;->getBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebBackForwardList;->getCurrentItem()Landroid/webkit/WebHistoryItem;

    move-result-object v0

    .line 3375
    .local v0, h:Landroid/webkit/WebHistoryItem;
    if-eqz v0, :cond_11

    invoke-virtual {v0}, Landroid/webkit/WebHistoryItem;->getUrl()Ljava/lang/String;

    move-result-object v1

    :goto_10
    return-object v1

    :cond_11
    const/4 v1, 0x0

    goto :goto_10
.end method

.method public getViewDelegate()Landroid/webkit/WebViewProvider$ViewDelegate;
    .registers 1

    .prologue
    .line 1436
    return-object p0
.end method

.method getViewHeight()I
    .registers 3

    .prologue
    .line 2010
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getViewHeightWithTitle()I

    move-result v0

    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getVisibleTitleHeightImpl()I

    move-result v1

    sub-int/2addr v0, v1

    return v0
.end method

.method getViewHeightWithTitle()I
    .registers 3

    .prologue
    .line 2014
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getHeight()I

    move-result v0

    .line 2015
    .local v0, height:I
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->isHorizontalScrollBarEnabled()Z

    move-result v1

    if-eqz v1, :cond_17

    iget-boolean v1, p0, Landroid/webkit/WebViewClassic;->mOverlayHorizontalScrollbar:Z

    if-nez v1, :cond_17

    .line 2016
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v1}, Landroid/webkit/WebView$PrivateAccess;->getHorizontalScrollbarHeight()I

    move-result v1

    sub-int/2addr v0, v1

    .line 2018
    :cond_17
    return v0
.end method

.method getViewManager()Landroid/webkit/ViewManager;
    .registers 2

    .prologue
    .line 8645
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mViewManager:Landroid/webkit/ViewManager;

    return-object v0
.end method

.method getViewWidth()I
    .registers 4

    .prologue
    .line 1949
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->isVerticalScrollBarEnabled()Z

    move-result v0

    if-eqz v0, :cond_c

    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mOverlayVerticalScrollbar:Z

    if-eqz v0, :cond_11

    .line 1950
    :cond_c
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getWidth()I

    move-result v0

    .line 1952
    :goto_10
    return v0

    :cond_11
    const/4 v0, 0x0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getWidth()I

    move-result v1

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->getVerticalScrollbarWidth()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    goto :goto_10
.end method

.method public getVisibleTitleHeight()I
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1981
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getVisibleTitleHeightImpl()I

    move-result v0

    return v0
.end method

.method public getWebBackForwardListClient()Landroid/webkit/WebBackForwardListClient;
    .registers 2

    .prologue
    .line 4086
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v0}, Landroid/webkit/CallbackProxy;->getWebBackForwardListClient()Landroid/webkit/WebBackForwardListClient;

    move-result-object v0

    return-object v0
.end method

.method public getWebChromeClient()Landroid/webkit/WebChromeClient;
    .registers 2

    .prologue
    .line 4069
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v0}, Landroid/webkit/CallbackProxy;->getWebChromeClient()Landroid/webkit/WebChromeClient;

    move-result-object v0

    return-object v0
.end method

.method public getWebView()Landroid/webkit/WebView;
    .registers 2

    .prologue
    .line 1431
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    return-object v0
.end method

.method public getWebViewClient()Landroid/webkit/WebViewClient;
    .registers 2

    .prologue
    .line 4043
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v0}, Landroid/webkit/CallbackProxy;->getWebViewClient()Landroid/webkit/WebViewClient;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getWebViewCore()Landroid/webkit/WebViewCore;
    .registers 2

    .prologue
    .line 7276
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method getWidth()I
    .registers 2

    .prologue
    .line 1458
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getWidth()I

    move-result v0

    return v0
.end method

.method public getZoomControls()Landroid/view/View;
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 6966
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebSettingsClassic;->supportZoom()Z

    move-result v0

    if-nez v0, :cond_14

    .line 6967
    const-string/jumbo v0, "webview"

    const-string v1, "This WebView doesn\'t support zoom."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 6968
    const/4 v0, 0x0

    .line 6970
    :goto_13
    return-object v0

    :cond_14
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->getExternalZoomPicker()Landroid/view/View;

    move-result-object v0

    goto :goto_13
.end method

.method getZoomOverviewScale()F
    .registers 2

    .prologue
    .line 6986
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->getZoomOverviewScale()F

    move-result v0

    return v0
.end method

.method public goBack()V
    .registers 2

    .prologue
    .line 2665
    const/4 v0, -0x1

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->goBackOrForwardImpl(I)V

    .line 2666
    return-void
.end method

.method public goBackOrForward(I)V
    .registers 2
    .parameter "steps"

    .prologue
    .line 2712
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->goBackOrForwardImpl(I)V

    .line 2713
    return-void
.end method

.method public goForward()V
    .registers 2

    .prologue
    .line 2688
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->goBackOrForwardImpl(I)V

    .line 2689
    return-void
.end method

.method incrementTextGeneration()V
    .registers 2

    .prologue
    .line 772
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTextGeneration:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroid/webkit/WebViewClassic;->mTextGeneration:I

    return-void
.end method

.method public init(Ljava/util/Map;Z)V
    .registers 9
    .parameter
    .parameter "privateBrowsing"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .local p1, javaScriptInterfaces:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v3, 0x0

    .line 1242
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    .line 1245
    .local v1, context:Landroid/content/Context;
    invoke-static {v1}, Landroid/webkit/JniUtil;->setContext(Landroid/content/Context;)V

    .line 1247
    new-instance v0, Landroid/webkit/CallbackProxy;

    invoke-direct {v0, v1, p0}, Landroid/webkit/CallbackProxy;-><init>(Landroid/content/Context;Landroid/webkit/WebViewClassic;)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    .line 1248
    new-instance v0, Landroid/webkit/ViewManager;

    invoke-direct {v0, p0}, Landroid/webkit/ViewManager;-><init>(Landroid/webkit/WebViewClassic;)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mViewManager:Landroid/webkit/ViewManager;

    .line 1249
    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/webkit/L10nUtils;->setApplicationContext(Landroid/content/Context;)V

    .line 1250
    new-instance v0, Landroid/webkit/WebViewCore;

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-direct {v0, v1, p0, v2, p1}, Landroid/webkit/WebViewCore;-><init>(Landroid/content/Context;Landroid/webkit/WebViewClassic;Landroid/webkit/CallbackProxy;Ljava/util/Map;)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    .line 1251
    invoke-static {v1}, Landroid/webkit/WebViewDatabaseClassic;->getInstance(Landroid/content/Context;)Landroid/webkit/WebViewDatabaseClassic;

    move-result-object v0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mDatabase:Landroid/webkit/WebViewDatabaseClassic;

    .line 1252
    new-instance v0, Landroid/widget/OverScroller;

    const/4 v2, 0x0

    const/4 v5, 0x0

    move v4, v3

    invoke-direct/range {v0 .. v5}, Landroid/widget/OverScroller;-><init>(Landroid/content/Context;Landroid/view/animation/Interpolator;FFZ)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    .line 1253
    new-instance v0, Landroid/webkit/ZoomManager;

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-direct {v0, p0, v2}, Landroid/webkit/ZoomManager;-><init>(Landroid/webkit/WebViewClassic;Landroid/webkit/CallbackProxy;)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    .line 1258
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->init()V

    .line 1259
    invoke-direct {p0, v1}, Landroid/webkit/WebViewClassic;->setupPackageListener(Landroid/content/Context;)V

    .line 1260
    invoke-static {v1}, Landroid/webkit/WebViewClassic;->setupProxyListener(Landroid/content/Context;)V

    .line 1261
    invoke-static {v1}, Landroid/webkit/WebViewClassic;->setupTrustStorageListener(Landroid/content/Context;)V

    .line 1262
    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->updateMultiTouchSupport(Landroid/content/Context;)V

    .line 1264
    if-eqz p2, :cond_51

    .line 1265
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->startPrivateBrowsing()V

    .line 1268
    :cond_51
    new-instance v0, Landroid/webkit/WebViewCore$AutoFillData;

    invoke-direct {v0}, Landroid/webkit/WebViewCore$AutoFillData;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mAutoFillData:Landroid/webkit/WebViewCore$AutoFillData;

    .line 1269
    new-instance v0, Landroid/widget/Scroller;

    invoke-direct {v0, v1}, Landroid/widget/Scroller;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mEditTextScroller:Landroid/widget/Scroller;

    .line 1270
    return-void
.end method

.method invalidate()V
    .registers 2

    .prologue
    .line 1470
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->invalidate()V

    .line 1471
    return-void
.end method

.method public invokeZoomPicker()V
    .registers 3

    .prologue
    .line 2848
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebSettingsClassic;->supportZoom()Z

    move-result v0

    if-nez v0, :cond_13

    .line 2849
    const-string/jumbo v0, "webview"

    const-string v1, "This WebView doesn\'t support zoom."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 2854
    :goto_12
    return-void

    .line 2852
    :cond_13
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->clearHelpers()V

    .line 2853
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->invokeZoomPicker()V

    goto :goto_12
.end method

.method public isPaused()Z
    .registers 2

    .prologue
    .line 3524
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsPaused:Z

    return v0
.end method

.method public isPrivateBrowsingEnabled()Z
    .registers 3

    .prologue
    .line 2732
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v0

    .line 2733
    .local v0, settings:Landroid/webkit/WebSettingsClassic;
    if-eqz v0, :cond_b

    invoke-virtual {v0}, Landroid/webkit/WebSettingsClassic;->isPrivateBrowsingEnabled()Z

    move-result v1

    :goto_a
    return v1

    :cond_b
    const/4 v1, 0x0

    goto :goto_a
.end method

.method isRectFitOnScreen(Landroid/graphics/Rect;)Z
    .registers 10
    .parameter "rect"

    .prologue
    .line 7026
    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v1

    .line 7027
    .local v1, rectWidth:I
    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result v0

    .line 7028
    .local v0, rectHeight:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getViewWidth()I

    move-result v4

    .line 7029
    .local v4, viewWidth:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getViewHeightWithTitle()I

    move-result v3

    .line 7030
    .local v3, viewHeight:I
    int-to-float v5, v4

    int-to-float v6, v1

    div-float/2addr v5, v6

    int-to-float v6, v3

    int-to-float v7, v0

    div-float/2addr v6, v7

    invoke-static {v5, v6}, Ljava/lang/Math;->min(FF)F

    move-result v2

    .line 7031
    .local v2, scale:F
    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v5, v2}, Landroid/webkit/ZoomManager;->computeScaleWithLimits(F)F

    move-result v2

    .line 7032
    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v5, v2}, Landroid/webkit/ZoomManager;->willScaleTriggerZoom(F)Z

    move-result v5

    if-nez v5, :cond_5c

    iget v5, p1, Landroid/graphics/Rect;->left:I

    invoke-virtual {p0, v5}, Landroid/webkit/WebViewClassic;->contentToViewX(I)I

    move-result v5

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v6

    if-lt v5, v6, :cond_5c

    iget v5, p1, Landroid/graphics/Rect;->right:I

    invoke-virtual {p0, v5}, Landroid/webkit/WebViewClassic;->contentToViewX(I)I

    move-result v5

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v6

    add-int/2addr v6, v4

    if-gt v5, v6, :cond_5c

    iget v5, p1, Landroid/graphics/Rect;->top:I

    invoke-virtual {p0, v5}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v5

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v6

    if-lt v5, v6, :cond_5c

    iget v5, p1, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {p0, v5}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v5

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v6

    add-int/2addr v6, v3

    if-gt v5, v6, :cond_5c

    const/4 v5, 0x1

    :goto_5b
    return v5

    :cond_5c
    const/4 v5, 0x0

    goto :goto_5b
.end method

.method public loadData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "data"
    .parameter "mimeType"
    .parameter "encoding"

    .prologue
    .line 2553
    invoke-direct {p0, p1, p2, p3}, Landroid/webkit/WebViewClassic;->loadDataImpl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2554
    return-void
.end method

.method public loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 9
    .parameter "baseUrl"
    .parameter "data"
    .parameter "mimeType"
    .parameter "encoding"
    .parameter "historyUrl"

    .prologue
    .line 2574
    if-eqz p1, :cond_12

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    const-string v2, "data:"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_12

    .line 2575
    invoke-direct {p0, p2, p3, p4}, Landroid/webkit/WebViewClassic;->loadDataImpl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2587
    :goto_11
    return-void

    .line 2578
    :cond_12
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->switchOutDrawHistory()V

    .line 2579
    new-instance v0, Landroid/webkit/WebViewCore$BaseUrlData;

    invoke-direct {v0}, Landroid/webkit/WebViewCore$BaseUrlData;-><init>()V

    .line 2580
    .local v0, arg:Landroid/webkit/WebViewCore$BaseUrlData;
    iput-object p1, v0, Landroid/webkit/WebViewCore$BaseUrlData;->mBaseUrl:Ljava/lang/String;

    .line 2581
    iput-object p2, v0, Landroid/webkit/WebViewCore$BaseUrlData;->mData:Ljava/lang/String;

    .line 2582
    iput-object p3, v0, Landroid/webkit/WebViewCore$BaseUrlData;->mMimeType:Ljava/lang/String;

    .line 2583
    iput-object p4, v0, Landroid/webkit/WebViewCore$BaseUrlData;->mEncoding:Ljava/lang/String;

    .line 2584
    iput-object p5, v0, Landroid/webkit/WebViewCore$BaseUrlData;->mHistoryUrl:Ljava/lang/String;

    .line 2585
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v2, 0x8b

    invoke-virtual {v1, v2, v0}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 2586
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->clearHelpers()V

    goto :goto_11
.end method

.method public loadUrl(Ljava/lang/String;)V
    .registers 2
    .parameter "url"

    .prologue
    .line 2521
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->loadUrlImpl(Ljava/lang/String;)V

    .line 2522
    return-void
.end method

.method public loadUrl(Ljava/lang/String;Ljava/util/Map;)V
    .registers 3
    .parameter "url"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 2504
    .local p2, additionalHttpHeaders:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0, p1, p2}, Landroid/webkit/WebViewClassic;->loadUrlImpl(Ljava/lang/String;Ljava/util/Map;)V

    .line 2505
    return-void
.end method

.method public loadViewState(Ljava/io/InputStream;)V
    .registers 5
    .parameter "stream"

    .prologue
    const/4 v1, 0x1

    .line 2403
    iput-boolean v1, p0, Landroid/webkit/WebViewClassic;->mBlockWebkitViewMessages:Z

    .line 2404
    new-instance v0, Landroid/webkit/WebViewClassic$8;

    invoke-direct {v0, p0}, Landroid/webkit/WebViewClassic$8;-><init>(Landroid/webkit/WebViewClassic;)V

    new-array v1, v1, [Ljava/io/InputStream;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewClassic$8;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 2431
    return-void
.end method

.method native nativeGetProperty(Ljava/lang/String;)Ljava/lang/String;
.end method

.method native nativeSetProperty(Ljava/lang/String;Ljava/lang/String;)Z
.end method

.method notifyFindDialogDismissed()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 3759
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mFindCallback:Landroid/webkit/FindActionModeCallback;

    .line 3760
    const/4 v0, -0x1

    iput v0, p0, Landroid/webkit/WebViewClassic;->mCachedOverlappingActionModeHeight:I

    .line 3761
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-nez v0, :cond_c

    .line 3770
    :goto_b
    return-void

    .line 3764
    :cond_c
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->clearMatches()V

    .line 3765
    invoke-direct {p0, v2}, Landroid/webkit/WebViewClassic;->setFindIsUp(Z)V

    .line 3768
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v1

    invoke-direct {p0, v0, v1, v2, v2}, Landroid/webkit/WebViewClassic;->pinScrollTo(IIZI)Z

    .line 3769
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    goto :goto_b
.end method

.method public onAttachedToWindow()V
    .registers 2

    .prologue
    .line 5474
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->hasWindowFocus()Z

    move-result v0

    if-eqz v0, :cond_c

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->setActive(Z)V

    .line 5476
    :cond_c
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_19

    .line 5477
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getAccessibilityInjector()Landroid/webkit/AccessibilityInjector;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/AccessibilityInjector;->addAccessibilityApisIfNecessary()V

    .line 5480
    :cond_19
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->updateHwAccelerated()V

    .line 5481
    return-void
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .registers 4
    .parameter "newConfig"

    .prologue
    .line 4442
    const/4 v0, -0x1

    iput v0, p0, Landroid/webkit/WebViewClassic;->mCachedOverlappingActionModeHeight:I

    .line 4443
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-eqz v0, :cond_10

    iget v0, p0, Landroid/webkit/WebViewClassic;->mOrientation:I

    iget v1, p1, Landroid/content/res/Configuration;->orientation:I

    if-eq v0, v1, :cond_10

    .line 4444
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->selectionDone()V

    .line 4446
    :cond_10
    iget v0, p1, Landroid/content/res/Configuration;->orientation:I

    iput v0, p0, Landroid/webkit/WebViewClassic;->mOrientation:I

    .line 4447
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-eqz v0, :cond_23

    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mBlockWebkitViewMessages:Z

    if-nez v0, :cond_23

    .line 4448
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x86

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 4450
    :cond_23
    return-void
.end method

.method public onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;
    .registers 4
    .parameter "outAttrs"

    .prologue
    .line 4809
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    if-nez v0, :cond_14

    .line 4810
    new-instance v0, Landroid/webkit/WebViewClassic$WebViewInputConnection;

    invoke-direct {v0, p0}, Landroid/webkit/WebViewClassic$WebViewInputConnection;-><init>(Landroid/webkit/WebViewClassic;)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    .line 4811
    new-instance v0, Landroid/webkit/AutoCompletePopup;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    invoke-direct {v0, p0, v1}, Landroid/webkit/AutoCompletePopup;-><init>(Landroid/webkit/WebViewClassic;Landroid/webkit/WebViewClassic$WebViewInputConnection;)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mAutoCompletePopup:Landroid/webkit/AutoCompletePopup;

    .line 4813
    :cond_14
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    invoke-virtual {v0, p1}, Landroid/webkit/WebViewClassic$WebViewInputConnection;->setupEditorInfo(Landroid/view/inputmethod/EditorInfo;)V

    .line 4814
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    return-object v0
.end method

.method public onDetachedFromWindow()V
    .registers 2

    .prologue
    .line 5485
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->clearHelpers()V

    .line 5486
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->dismissZoomPicker()V

    .line 5487
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->hasWindowFocus()Z

    move-result v0

    if-eqz v0, :cond_14

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->setActive(Z)V

    .line 5489
    :cond_14
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_28

    .line 5490
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getAccessibilityInjector()Landroid/webkit/AccessibilityInjector;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/AccessibilityInjector;->removeAccessibilityApisIfNecessary()V

    .line 5497
    :goto_21
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->updateHwAccelerated()V

    .line 5499
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->ensureFunctorDetached()V

    .line 5500
    return-void

    .line 5494
    :cond_28
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mAccessibilityInjector:Landroid/webkit/AccessibilityInjector;

    goto :goto_21
.end method

.method public onDraw(Landroid/graphics/Canvas;)V
    .registers 11
    .parameter "canvas"

    .prologue
    const/high16 v1, -0x100

    .line 4294
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->inFullScreenMode()Z

    move-result v0

    if-eqz v0, :cond_9

    .line 4369
    :cond_8
    :goto_8
    return-void

    .line 4299
    :cond_9
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v0

    if-eqz v0, :cond_1e

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebSettingsClassic;->getNightReadModeEnabled()Z

    move-result v0

    if-eqz v0, :cond_1e

    .line 4300
    iput v1, p0, Landroid/webkit/WebViewClassic;->mBackgroundColor:I

    .line 4301
    invoke-virtual {p1, v1}, Landroid/graphics/Canvas;->drawColor(I)V

    .line 4303
    :cond_1e
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v0, :cond_28

    .line 4304
    iget v0, p0, Landroid/webkit/WebViewClassic;->mBackgroundColor:I

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->drawColor(I)V

    goto :goto_8

    .line 4311
    :cond_28
    iget v0, p0, Landroid/webkit/WebViewClassic;->mContentWidth:I

    iget v1, p0, Landroid/webkit/WebViewClassic;->mContentHeight:I

    or-int/2addr v0, v1

    if-nez v0, :cond_39

    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHistoryPicture:Landroid/graphics/Picture;

    if-nez v0, :cond_39

    .line 4312
    iget v0, p0, Landroid/webkit/WebViewClassic;->mBackgroundColor:I

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->drawColor(I)V

    goto :goto_8

    .line 4316
    :cond_39
    invoke-virtual {p1}, Landroid/graphics/Canvas;->isHardwareAccelerated()Z

    move-result v0

    if-eqz v0, :cond_ee

    .line 4317
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->setHardwareAccelerated()V

    .line 4322
    :goto_44
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v8

    .line 4323
    .local v8, saveCount:I
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mInOverScrollMode:Z

    if-eqz v0, :cond_59

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebSettingsClassic;->getUseWebViewBackgroundForOverscrollBackground()Z

    move-result v0

    if-nez v0, :cond_59

    .line 4325
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->drawOverScrollBackground(Landroid/graphics/Canvas;)V

    .line 4328
    :cond_59
    const/4 v0, 0x0

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 4329
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->drawContent(Landroid/graphics/Canvas;)V

    .line 4330
    invoke-virtual {p1, v8}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 4335
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v0}, Landroid/webkit/WebViewCore;->signalRepaintDone()V

    .line 4337
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mOverScrollGlow:Landroid/webkit/OverScrollGlow;

    if-eqz v0, :cond_7c

    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mOverScrollGlow:Landroid/webkit/OverScrollGlow;

    invoke-virtual {v0, p1}, Landroid/webkit/OverScrollGlow;->drawEdgeGlows(Landroid/graphics/Canvas;)Z

    move-result v0

    if-eqz v0, :cond_7c

    .line 4338
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 4341
    :cond_7c
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mFocusTransition:Landroid/webkit/WebViewClassic$FocusTransitionDrawable;

    if-eqz v0, :cond_f5

    .line 4342
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mFocusTransition:Landroid/webkit/WebViewClassic$FocusTransitionDrawable;

    invoke-virtual {v0, p1}, Landroid/webkit/WebViewClassic$FocusTransitionDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 4351
    :cond_85
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebSettingsClassic;->getNavDump()Z

    move-result v0

    if-eqz v0, :cond_8

    .line 4352
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightX:I

    iget v1, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightY:I

    or-int/2addr v0, v1

    if-eqz v0, :cond_8

    .line 4353
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mTouchCrossHairColor:Landroid/graphics/Paint;

    if-nez v0, :cond_a8

    .line 4354
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mTouchCrossHairColor:Landroid/graphics/Paint;

    .line 4355
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mTouchCrossHairColor:Landroid/graphics/Paint;

    const/high16 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 4357
    :cond_a8
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightX:I

    iget v1, p0, Landroid/webkit/WebViewClassic;->mNavSlop:I

    sub-int/2addr v0, v1

    int-to-float v1, v0

    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightY:I

    iget v2, p0, Landroid/webkit/WebViewClassic;->mNavSlop:I

    sub-int/2addr v0, v2

    int-to-float v2, v0

    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightX:I

    iget v3, p0, Landroid/webkit/WebViewClassic;->mNavSlop:I

    add-int/2addr v0, v3

    add-int/lit8 v0, v0, 0x1

    int-to-float v3, v0

    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightY:I

    iget v4, p0, Landroid/webkit/WebViewClassic;->mNavSlop:I

    add-int/2addr v0, v4

    add-int/lit8 v0, v0, 0x1

    int-to-float v4, v0

    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mTouchCrossHairColor:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 4361
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightX:I

    iget v1, p0, Landroid/webkit/WebViewClassic;->mNavSlop:I

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x1

    int-to-float v1, v0

    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightY:I

    iget v2, p0, Landroid/webkit/WebViewClassic;->mNavSlop:I

    sub-int/2addr v0, v2

    int-to-float v2, v0

    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightX:I

    iget v3, p0, Landroid/webkit/WebViewClassic;->mNavSlop:I

    sub-int/2addr v0, v3

    int-to-float v3, v0

    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightY:I

    iget v4, p0, Landroid/webkit/WebViewClassic;->mNavSlop:I

    add-int/2addr v0, v4

    add-int/lit8 v0, v0, 0x1

    int-to-float v4, v0

    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mTouchCrossHairColor:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    goto/16 :goto_8

    .line 4319
    .end local v8           #saveCount:I
    :cond_ee
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v0}, Landroid/webkit/WebViewCore;->resumeWebKitDraw()V

    goto/16 :goto_44

    .line 4343
    .restart local v8       #saveCount:I
    :cond_f5
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->shouldDrawHighlightRect()Z

    move-result v0

    if-eqz v0, :cond_85

    .line 4344
    new-instance v6, Landroid/graphics/RegionIterator;

    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightRegion:Landroid/graphics/Region;

    invoke-direct {v6, v0}, Landroid/graphics/RegionIterator;-><init>(Landroid/graphics/Region;)V

    .line 4345
    .local v6, iter:Landroid/graphics/RegionIterator;
    new-instance v7, Landroid/graphics/Rect;

    invoke-direct {v7}, Landroid/graphics/Rect;-><init>()V

    .line 4346
    .local v7, r:Landroid/graphics/Rect;
    :goto_107
    invoke-virtual {v6, v7}, Landroid/graphics/RegionIterator;->next(Landroid/graphics/Rect;)Z

    move-result v0

    if-eqz v0, :cond_85

    .line 4347
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mTouchHightlightPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v7, v0}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    goto :goto_107
.end method

.method public onDrawVerticalScrollBar(Landroid/graphics/Canvas;Landroid/graphics/drawable/Drawable;IIII)V
    .registers 8
    .parameter "canvas"
    .parameter "scrollBar"
    .parameter "l"
    .parameter "t"
    .parameter "r"
    .parameter "b"

    .prologue
    .line 3326
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v0

    if-gez v0, :cond_b

    .line 3327
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v0

    sub-int/2addr p4, v0

    .line 3329
    :cond_b
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getVisibleTitleHeightImpl()I

    move-result v0

    add-int/2addr v0, p4

    invoke-virtual {p2, p3, v0, p5, p6}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 3330
    invoke-virtual {p2, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 3331
    return-void
.end method

.method onFixedLengthZoomAnimationEnd()V
    .registers 2

    .prologue
    .line 4497
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mBlockWebkitViewMessages:Z

    if-nez v0, :cond_d

    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-nez v0, :cond_d

    .line 4498
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-static {v0}, Landroid/webkit/WebViewCore;->resumeUpdatePicture(Landroid/webkit/WebViewCore;)V

    .line 4500
    :cond_d
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->onZoomAnimationEnd()V

    .line 4501
    return-void
.end method

.method onFixedLengthZoomAnimationStart()V
    .registers 2

    .prologue
    .line 4492
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getWebViewCore()Landroid/webkit/WebViewCore;

    move-result-object v0

    invoke-static {v0}, Landroid/webkit/WebViewCore;->pauseUpdatePicture(Landroid/webkit/WebViewCore;)V

    .line 4493
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->onZoomAnimationStart()V

    .line 4494
    return-void
.end method

.method public onFocusChanged(ZILandroid/graphics/Rect;)V
    .registers 6
    .parameter "focused"
    .parameter "direction"
    .parameter "previouslyFocusedRect"

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 5586
    if-eqz p1, :cond_1d

    .line 5587
    iput-boolean v1, p0, Landroid/webkit/WebViewClassic;->mDrawCursorRing:Z

    .line 5588
    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->setFocusControllerActive(Z)V

    .line 5594
    :goto_9
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightRegion:Landroid/graphics/Region;

    invoke-virtual {v0}, Landroid/graphics/Region;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1c

    .line 5595
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mTouchHighlightRegion:Landroid/graphics/Region;

    invoke-virtual {v1}, Landroid/graphics/Region;->getBounds()Landroid/graphics/Rect;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->invalidate(Landroid/graphics/Rect;)V

    .line 5597
    :cond_1c
    return-void

    .line 5590
    :cond_1d
    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mDrawCursorRing:Z

    .line 5591
    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->setFocusControllerActive(Z)V

    .line 5592
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mKeysPressed:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    goto :goto_9
.end method

.method public onGenericMotionEvent(Landroid/view/MotionEvent;)Z
    .registers 10
    .parameter "event"

    .prologue
    const/16 v7, 0x9

    const/4 v6, 0x0

    const/4 v5, 0x0

    .line 6559
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getSource()I

    move-result v4

    and-int/lit8 v4, v4, 0x2

    if-eqz v4, :cond_13

    .line 6560
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    packed-switch v4, :pswitch_data_54

    .line 6583
    :cond_13
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v4, p1}, Landroid/webkit/WebView$PrivateAccess;->super_onGenericMotionEvent(Landroid/view/MotionEvent;)Z

    move-result v4

    :goto_19
    return v4

    .line 6564
    :pswitch_1a
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getMetaState()I

    move-result v4

    and-int/lit8 v4, v4, 0x1

    if-eqz v4, :cond_47

    .line 6565
    const/4 v3, 0x0

    .line 6566
    .local v3, vscroll:F
    invoke-virtual {p1, v7}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v1

    .line 6571
    .local v1, hscroll:F
    :goto_27
    cmpl-float v4, v1, v5

    if-nez v4, :cond_2f

    cmpl-float v4, v3, v5

    if-eqz v4, :cond_13

    .line 6572
    :cond_2f
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v4}, Landroid/webkit/WebView$PrivateAccess;->getVerticalScrollFactor()F

    move-result v4

    mul-float/2addr v4, v3

    float-to-int v2, v4

    .line 6574
    .local v2, vdelta:I
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v4}, Landroid/webkit/WebView$PrivateAccess;->getHorizontalScrollFactor()F

    move-result v4

    mul-float/2addr v4, v1

    float-to-int v0, v4

    .line 6576
    .local v0, hdelta:I
    invoke-direct {p0, v0, v2, v6, v6}, Landroid/webkit/WebViewClassic;->pinScrollBy(IIZI)Z

    move-result v4

    if-eqz v4, :cond_13

    .line 6577
    const/4 v4, 0x1

    goto :goto_19

    .line 6568
    .end local v0           #hdelta:I
    .end local v1           #hscroll:F
    .end local v2           #vdelta:I
    .end local v3           #vscroll:F
    :cond_47
    invoke-virtual {p1, v7}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v4

    neg-float v3, v4

    .line 6569
    .restart local v3       #vscroll:F
    const/16 v4, 0xa

    invoke-virtual {p1, v4}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v1

    .restart local v1       #hscroll:F
    goto :goto_27

    .line 6560
    nop

    :pswitch_data_54
    .packed-switch 0x8
        :pswitch_1a
    .end packed-switch
.end method

.method public onHoverEvent(Landroid/view/MotionEvent;)Z
    .registers 6
    .parameter "event"

    .prologue
    .line 5874
    iget v2, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v2, :cond_6

    .line 5875
    const/4 v2, 0x0

    .line 5881
    :goto_5
    return v2

    .line 5877
    :cond_6
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    float-to-int v2, v2

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->viewToContentX(I)I

    move-result v0

    .line 5878
    .local v0, x:I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    float-to-int v2, v2

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->viewToContentY(I)I

    move-result v1

    .line 5879
    .local v1, y:I
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v3, 0x87

    invoke-virtual {v2, v3, v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(III)V

    .line 5880
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v2, p1}, Landroid/webkit/WebView$PrivateAccess;->super_onHoverEvent(Landroid/view/MotionEvent;)Z

    .line 5881
    const/4 v2, 0x1

    goto :goto_5
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .registers 9
    .parameter "event"

    .prologue
    const/4 v6, 0x0

    .line 1768
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->isScrollableForAccessibility()Z

    move-result v4

    invoke-virtual {p1, v4}, Landroid/view/accessibility/AccessibilityEvent;->setScrollable(Z)V

    .line 1769
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v4

    invoke-virtual {p1, v4}, Landroid/view/accessibility/AccessibilityEvent;->setScrollX(I)V

    .line 1770
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v4

    invoke-virtual {p1, v4}, Landroid/view/accessibility/AccessibilityEvent;->setScrollY(I)V

    .line 1771
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getContentWidth()I

    move-result v4

    invoke-virtual {p0, v4}, Landroid/webkit/WebViewClassic;->contentToViewX(I)I

    move-result v3

    .line 1772
    .local v3, convertedContentWidth:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getWidth()I

    move-result v4

    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v5}, Landroid/webkit/WebView;->getPaddingLeft()I

    move-result v5

    sub-int/2addr v4, v5

    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v5}, Landroid/webkit/WebView;->getPaddingLeft()I

    move-result v5

    sub-int v1, v4, v5

    .line 1774
    .local v1, adjustedViewWidth:I
    sub-int v4, v3, v1

    invoke-static {v4, v6}, Ljava/lang/Math;->max(II)I

    move-result v4

    invoke-virtual {p1, v4}, Landroid/view/accessibility/AccessibilityEvent;->setMaxScrollX(I)V

    .line 1775
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getContentHeight()I

    move-result v4

    invoke-virtual {p0, v4}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v2

    .line 1776
    .local v2, convertedContentHeight:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getHeight()I

    move-result v4

    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v5}, Landroid/webkit/WebView;->getPaddingTop()I

    move-result v5

    sub-int/2addr v4, v5

    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v5}, Landroid/webkit/WebView;->getPaddingBottom()I

    move-result v5

    sub-int v0, v4, v5

    .line 1778
    .local v0, adjustedViewHeight:I
    sub-int v4, v2, v0

    invoke-static {v4, v6}, Ljava/lang/Math;->max(II)I

    move-result v4

    invoke-virtual {p1, v4}, Landroid/view/accessibility/AccessibilityEvent;->setMaxScrollY(I)V

    .line 1779
    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .registers 11
    .parameter "info"

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 1741
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v7}, Landroid/webkit/WebView;->isEnabled()Z

    move-result v7

    if-nez v7, :cond_b

    .line 1764
    :goto_a
    return-void

    .line 1746
    :cond_b
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->isScrollableForAccessibility()Z

    move-result v7

    invoke-virtual {p1, v7}, Landroid/view/accessibility/AccessibilityNodeInfo;->setScrollable(Z)V

    .line 1748
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getContentHeight()I

    move-result v7

    invoke-virtual {p0, v7}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v3

    .line 1749
    .local v3, convertedContentHeight:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getHeight()I

    move-result v7

    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v8}, Landroid/webkit/WebView;->getPaddingTop()I

    move-result v8

    sub-int/2addr v7, v8

    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v8}, Landroid/webkit/WebView;->getPaddingBottom()I

    move-result v8

    sub-int v0, v7, v8

    .line 1751
    .local v0, adjustedViewHeight:I
    sub-int v7, v3, v0

    invoke-static {v7, v6}, Ljava/lang/Math;->max(II)I

    move-result v4

    .line 1752
    .local v4, maxScrollY:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v7

    if-lez v7, :cond_58

    move v1, v5

    .line 1753
    .local v1, canScrollBackward:Z
    :goto_3a
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v7

    sub-int/2addr v7, v4

    if-lez v7, :cond_5a

    move v2, v5

    .line 1755
    .local v2, canScrollForward:Z
    :goto_42
    if-eqz v2, :cond_49

    .line 1756
    const/16 v5, 0x1000

    invoke-virtual {p1, v5}, Landroid/view/accessibility/AccessibilityNodeInfo;->addAction(I)V

    .line 1759
    :cond_49
    if-eqz v2, :cond_50

    .line 1760
    const/16 v5, 0x2000

    invoke-virtual {p1, v5}, Landroid/view/accessibility/AccessibilityNodeInfo;->addAction(I)V

    .line 1763
    :cond_50
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getAccessibilityInjector()Landroid/webkit/AccessibilityInjector;

    move-result-object v5

    invoke-virtual {v5, p1}, Landroid/webkit/AccessibilityInjector;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    goto :goto_a

    .end local v1           #canScrollBackward:Z
    .end local v2           #canScrollForward:Z
    :cond_58
    move v1, v6

    .line 1752
    goto :goto_3a

    .restart local v1       #canScrollBackward:Z
    :cond_5a
    move v2, v6

    .line 1753
    goto :goto_42
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .registers 9
    .parameter "keyCode"
    .parameter "event"

    .prologue
    const/4 v3, 0x2

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 5028
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mIsCaretSelection:Z

    if-eqz v2, :cond_a

    .line 5029
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->selectionDone()V

    .line 5031
    :cond_a
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mBlockWebkitViewMessages:Z

    if-eqz v2, :cond_10

    move v1, v0

    .line 5133
    :cond_f
    :goto_f
    return v1

    .line 5036
    :cond_10
    invoke-virtual {p2}, Landroid/view/KeyEvent;->isCtrlPressed()Z

    move-result v2

    if-eqz v2, :cond_18

    move v1, v0

    .line 5037
    goto :goto_f

    .line 5040
    :cond_18
    iget v2, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v2, :cond_1e

    move v1, v0

    .line 5041
    goto :goto_f

    .line 5056
    :cond_1e
    invoke-virtual {p2}, Landroid/view/KeyEvent;->isSystem()Z

    move-result v2

    if-nez v2, :cond_2c

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v2, p2}, Landroid/webkit/CallbackProxy;->uiOverrideKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v2

    if-eqz v2, :cond_2e

    :cond_2c
    move v1, v0

    .line 5058
    goto :goto_f

    .line 5062
    :cond_2e
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->isAccessibilityEnabled()Z

    move-result v2

    if-eqz v2, :cond_3e

    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getAccessibilityInjector()Landroid/webkit/AccessibilityInjector;

    move-result-object v2

    invoke-virtual {v2, p2}, Landroid/webkit/AccessibilityInjector;->handleKeyEventIfNecessary(Landroid/view/KeyEvent;)Z

    move-result v2

    if-nez v2, :cond_f

    .line 5067
    :cond_3e
    const/16 v2, 0x5c

    if-ne p1, v2, :cond_56

    .line 5068
    invoke-virtual {p2}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v2

    if-eqz v2, :cond_4c

    .line 5069
    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->pageUp(Z)Z

    goto :goto_f

    .line 5071
    :cond_4c
    invoke-virtual {p2, v3}, Landroid/view/KeyEvent;->hasModifiers(I)Z

    move-result v2

    if-eqz v2, :cond_56

    .line 5072
    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->pageUp(Z)Z

    goto :goto_f

    .line 5077
    :cond_56
    const/16 v2, 0x5d

    if-ne p1, v2, :cond_6e

    .line 5078
    invoke-virtual {p2}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v2

    if-eqz v2, :cond_64

    .line 5079
    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->pageDown(Z)Z

    goto :goto_f

    .line 5081
    :cond_64
    invoke-virtual {p2, v3}, Landroid/view/KeyEvent;->hasModifiers(I)Z

    move-result v2

    if-eqz v2, :cond_6e

    .line 5082
    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->pageDown(Z)Z

    goto :goto_f

    .line 5087
    :cond_6e
    const/16 v2, 0x7a

    if-ne p1, v2, :cond_7c

    invoke-virtual {p2}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v2

    if-eqz v2, :cond_7c

    .line 5088
    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->pageUp(Z)Z

    goto :goto_f

    .line 5092
    :cond_7c
    const/16 v2, 0x7b

    if-ne p1, v2, :cond_8a

    invoke-virtual {p2}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v2

    if-eqz v2, :cond_8a

    .line 5093
    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->pageDown(Z)Z

    goto :goto_f

    .line 5097
    :cond_8a
    const/16 v2, 0x13

    if-lt p1, v2, :cond_95

    const/16 v2, 0x16

    if-gt p1, v2, :cond_95

    .line 5099
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->switchOutDrawHistory()V

    .line 5102
    :cond_95
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->isEnterActionKey(I)Z

    move-result v2

    if-eqz v2, :cond_b9

    .line 5103
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->switchOutDrawHistory()V

    .line 5104
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v2

    if-nez v2, :cond_b9

    .line 5105
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-nez v2, :cond_f

    .line 5108
    iput-boolean v1, p0, Landroid/webkit/WebViewClassic;->mGotCenterDown:Z

    .line 5109
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/16 v4, 0x72

    invoke-virtual {v3, v4}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v3

    const-wide/16 v4, 0x3e8

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 5114
    :cond_b9
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebSettingsClassic;->getNavDump()Z

    move-result v2

    if-eqz v2, :cond_c6

    .line 5115
    packed-switch p1, :pswitch_data_e2

    .line 5131
    :cond_c6
    :goto_c6
    invoke-direct {p0, p2}, Landroid/webkit/WebViewClassic;->sendKeyEvent(Landroid/view/KeyEvent;)V

    goto/16 :goto_f

    .line 5117
    :pswitch_cb
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->dumpDisplayTree()V

    goto :goto_c6

    .line 5121
    :pswitch_cf
    const/16 v2, 0xc

    if-ne p1, v2, :cond_d4

    move v0, v1

    :cond_d4
    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->dumpDomTree(Z)V

    goto :goto_c6

    .line 5125
    :pswitch_d8
    const/16 v2, 0xe

    if-ne p1, v2, :cond_dd

    move v0, v1

    :cond_dd
    invoke-virtual {p0, v0}, Landroid/webkit/WebViewClassic;->dumpRenderTree(Z)V

    goto :goto_c6

    .line 5115
    nop

    :pswitch_data_e2
    .packed-switch 0xb
        :pswitch_cb
        :pswitch_cf
        :pswitch_cf
        :pswitch_d8
        :pswitch_d8
    .end packed-switch
.end method

.method public onKeyMultiple(IILandroid/view/KeyEvent;)Z
    .registers 6
    .parameter "keyCode"
    .parameter "repeatCount"
    .parameter "event"

    .prologue
    const/4 v0, 0x0

    .line 4994
    iget-boolean v1, p0, Landroid/webkit/WebViewClassic;->mBlockWebkitViewMessages:Z

    if-eqz v1, :cond_6

    .line 5005
    :cond_5
    :goto_5
    return v0

    .line 4998
    :cond_6
    if-nez p1, :cond_5

    invoke-virtual {p3}, Landroid/view/KeyEvent;->getCharacters()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_5

    .line 5000
    const/16 v1, 0x67

    invoke-virtual {p0, v1, v0, v0, p3}, Landroid/webkit/WebViewClassic;->sendBatchableInputMessage(IIILjava/lang/Object;)V

    .line 5001
    const/16 v1, 0x68

    invoke-virtual {p0, v1, v0, v0, p3}, Landroid/webkit/WebViewClassic;->sendBatchableInputMessage(IIILjava/lang/Object;)V

    .line 5003
    const/4 v0, 0x1

    goto :goto_5
.end method

.method public onKeyPreIme(ILandroid/view/KeyEvent;)Z
    .registers 4
    .parameter "keyCode"
    .parameter "event"

    .prologue
    .line 5015
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mAutoCompletePopup:Landroid/webkit/AutoCompletePopup;

    if-eqz v0, :cond_b

    .line 5016
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mAutoCompletePopup:Landroid/webkit/AutoCompletePopup;

    invoke-virtual {v0, p1, p2}, Landroid/webkit/AutoCompletePopup;->onKeyPreIme(ILandroid/view/KeyEvent;)Z

    move-result v0

    .line 5018
    :goto_a
    return v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .registers 9
    .parameter "keyCode"
    .parameter "event"

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 5142
    iget-boolean v4, p0, Landroid/webkit/WebViewClassic;->mBlockWebkitViewMessages:Z

    if-eqz v4, :cond_7

    .line 5189
    :cond_6
    :goto_6
    return v2

    .line 5146
    :cond_7
    iget v4, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-eqz v4, :cond_6

    .line 5151
    const/4 v4, 0x5

    if-ne p1, v4, :cond_33

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    if-eqz v4, :cond_33

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    invoke-virtual {v4}, Landroid/webkit/WebView$HitTestResult;->getType()I

    move-result v4

    const/4 v5, 0x2

    if-ne v4, v5, :cond_33

    .line 5154
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mInitialHitTestResult:Landroid/webkit/WebView$HitTestResult;

    invoke-virtual {v2}, Landroid/webkit/WebView$HitTestResult;->getExtra()Ljava/lang/String;

    move-result-object v1

    .line 5155
    .local v1, text:Ljava/lang/String;
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.DIAL"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-direct {v0, v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 5156
    .local v0, intent:Landroid/content/Intent;
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    invoke-virtual {v2, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    move v2, v3

    .line 5157
    goto :goto_6

    .line 5163
    .end local v0           #intent:Landroid/content/Intent;
    .end local v1           #text:Ljava/lang/String;
    :cond_33
    invoke-virtual {p2}, Landroid/view/KeyEvent;->isSystem()Z

    move-result v4

    if-nez v4, :cond_6

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v4, p2}, Landroid/webkit/CallbackProxy;->uiOverrideKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v4

    if-nez v4, :cond_6

    .line 5169
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->isAccessibilityEnabled()Z

    move-result v4

    if-eqz v4, :cond_53

    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getAccessibilityInjector()Landroid/webkit/AccessibilityInjector;

    move-result-object v4

    invoke-virtual {v4, p2}, Landroid/webkit/AccessibilityInjector;->handleKeyEventIfNecessary(Landroid/view/KeyEvent;)Z

    move-result v4

    if-eqz v4, :cond_53

    move v2, v3

    .line 5171
    goto :goto_6

    .line 5174
    :cond_53
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->isEnterActionKey(I)Z

    move-result v4

    if-eqz v4, :cond_6e

    .line 5176
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/16 v5, 0x72

    invoke-virtual {v4, v5}, Landroid/os/Handler;->removeMessages(I)V

    .line 5177
    iput-boolean v2, p0, Landroid/webkit/WebViewClassic;->mGotCenterDown:Z

    .line 5179
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-eqz v2, :cond_6e

    .line 5180
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->copySelection()Z

    .line 5181
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->selectionDone()V

    move v2, v3

    .line 5182
    goto :goto_6

    .line 5187
    :cond_6e
    invoke-direct {p0, p2}, Landroid/webkit/WebViewClassic;->sendKeyEvent(Landroid/view/KeyEvent;)V

    move v2, v3

    .line 5189
    goto :goto_6
.end method

.method public onMeasure(II)V
    .registers 15
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    const/high16 v11, 0x100

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 7134
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v2

    .line 7135
    .local v2, heightMode:I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v3

    .line 7136
    .local v3, heightSize:I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v6

    .line 7137
    .local v6, widthMode:I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v7

    .line 7139
    .local v7, widthSize:I
    move v4, v3

    .line 7140
    .local v4, measuredHeight:I
    move v5, v7

    .line 7143
    .local v5, measuredWidth:I
    iget v8, p0, Landroid/webkit/WebViewClassic;->mContentHeight:I

    invoke-virtual {p0, v8}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v0

    .line 7144
    .local v0, contentHeight:I
    iget v8, p0, Landroid/webkit/WebViewClassic;->mContentWidth:I

    invoke-virtual {p0, v8}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v1

    .line 7148
    .local v1, contentWidth:I
    const/high16 v8, 0x4000

    if-eq v2, v8, :cond_49

    .line 7149
    iput-boolean v10, p0, Landroid/webkit/WebViewClassic;->mHeightCanMeasure:Z

    .line 7150
    move v4, v0

    .line 7151
    const/high16 v8, -0x8000

    if-ne v2, v8, :cond_33

    .line 7154
    if-le v4, v3, :cond_33

    .line 7155
    move v4, v3

    .line 7156
    iput-boolean v9, p0, Landroid/webkit/WebViewClassic;->mHeightCanMeasure:Z

    .line 7157
    or-int/2addr v4, v11

    .line 7163
    :cond_33
    :goto_33
    iget v8, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-eqz v8, :cond_3c

    .line 7164
    iget-boolean v8, p0, Landroid/webkit/WebViewClassic;->mHeightCanMeasure:Z

    invoke-direct {p0, v8}, Landroid/webkit/WebViewClassic;->nativeSetHeightCanMeasure(Z)V

    .line 7167
    :cond_3c
    if-nez v6, :cond_4c

    .line 7168
    iput-boolean v10, p0, Landroid/webkit/WebViewClassic;->mWidthCanMeasure:Z

    .line 7169
    move v5, v1

    .line 7177
    :goto_41
    monitor-enter p0

    .line 7178
    :try_start_42
    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v8, v5, v4}, Landroid/webkit/WebView$PrivateAccess;->setMeasuredDimension(II)V

    .line 7179
    monitor-exit p0
    :try_end_48
    .catchall {:try_start_42 .. :try_end_48} :catchall_52

    .line 7180
    return-void

    .line 7161
    :cond_49
    iput-boolean v9, p0, Landroid/webkit/WebViewClassic;->mHeightCanMeasure:Z

    goto :goto_33

    .line 7171
    :cond_4c
    if-ge v5, v1, :cond_4f

    .line 7172
    or-int/2addr v5, v11

    .line 7174
    :cond_4f
    iput-boolean v9, p0, Landroid/webkit/WebViewClassic;->mWidthCanMeasure:Z

    goto :goto_41

    .line 7179
    :catchall_52
    move-exception v8

    :try_start_53
    monitor-exit p0
    :try_end_54
    .catchall {:try_start_53 .. :try_end_54} :catchall_52

    throw v8
.end method

.method public onOverScrolled(IIZZ)V
    .registers 12
    .parameter "scrollX"
    .parameter "scrollY"
    .parameter "clampedX"
    .parameter "clampedY"

    .prologue
    const/4 v2, 0x1

    .line 3338
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/16 v1, 0xa

    if-ne v0, v1, :cond_b

    .line 3339
    invoke-direct {p0, p1, p2}, Landroid/webkit/WebViewClassic;->scrollEditText(II)V

    .line 3367
    :cond_a
    :goto_a
    return-void

    .line 3342
    :cond_b
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/16 v1, 0x9

    if-ne v0, v1, :cond_15

    .line 3343
    invoke-direct {p0, p1, p2}, Landroid/webkit/WebViewClassic;->scrollLayerTo(II)V

    goto :goto_a

    .line 3346
    :cond_15
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mInOverScrollMode:Z

    .line 3347
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollX()I

    move-result v5

    .line 3348
    .local v5, maxX:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->computeMaxScrollY()I

    move-result v6

    .line 3349
    .local v6, maxY:I
    if-nez v5, :cond_4b

    .line 3351
    invoke-virtual {p0, p1}, Landroid/webkit/WebViewClassic;->pinLocX(I)I

    move-result p1

    .line 3355
    :cond_26
    :goto_26
    if-ltz p2, :cond_2a

    if-le p2, v6, :cond_2c

    .line 3356
    :cond_2a
    iput-boolean v2, p0, Landroid/webkit/WebViewClassic;->mInOverScrollMode:Z

    .line 3359
    :cond_2c
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    .line 3360
    .local v3, oldX:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v4

    .line 3362
    .local v4, oldY:I
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v0, p1, p2}, Landroid/webkit/WebView$PrivateAccess;->super_scrollTo(II)V

    .line 3364
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mOverScrollGlow:Landroid/webkit/OverScrollGlow;

    if-eqz v0, :cond_a

    .line 3365
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mOverScrollGlow:Landroid/webkit/OverScrollGlow;

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v1

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v2

    invoke-virtual/range {v0 .. v6}, Landroid/webkit/OverScrollGlow;->pullGlow(IIIIII)V

    goto :goto_a

    .line 3352
    .end local v3           #oldX:I
    .end local v4           #oldY:I
    :cond_4b
    if-ltz p1, :cond_4f

    if-le p1, v5, :cond_26

    .line 3353
    :cond_4f
    iput-boolean v2, p0, Landroid/webkit/WebViewClassic;->mInOverScrollMode:Z

    goto :goto_26
.end method

.method onPageFinished(Ljava/lang/String;)V
    .registers 3
    .parameter "url"

    .prologue
    .line 3980
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0, p1}, Landroid/webkit/ZoomManager;->onPageFinished(Ljava/lang/String;)V

    .line 3982
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_12

    .line 3983
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getAccessibilityInjector()Landroid/webkit/AccessibilityInjector;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/webkit/AccessibilityInjector;->onPageFinished(Ljava/lang/String;)V

    .line 3985
    :cond_12
    return-void
.end method

.method onPageStarted(Ljava/lang/String;)V
    .registers 4
    .parameter "url"

    .prologue
    .line 3963
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setCertificate(Landroid/net/http/SslCertificate;)V

    .line 3967
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_13

    .line 3968
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getAccessibilityInjector()Landroid/webkit/AccessibilityInjector;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/webkit/AccessibilityInjector;->onPageStarted(Ljava/lang/String;)V

    .line 3972
    :cond_13
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsEditingText:Z

    .line 3973
    return-void
.end method

.method public onPause()V
    .registers 4

    .prologue
    const/4 v2, 0x1

    .line 3468
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsPaused:Z

    if-nez v0, :cond_26

    .line 3469
    iput-boolean v2, p0, Landroid/webkit/WebViewClassic;->mIsPaused:Z

    .line 3470
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x8f

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 3473
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHTML5VideoViewProxy:Landroid/webkit/HTML5VideoViewProxy;

    if-eqz v0, :cond_17

    .line 3474
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHTML5VideoViewProxy:Landroid/webkit/HTML5VideoViewProxy;

    invoke-virtual {v0}, Landroid/webkit/HTML5VideoViewProxy;->pauseAndDispatch()V

    .line 3476
    :cond_17
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-eqz v0, :cond_20

    .line 3477
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    invoke-static {v0, v2}, Landroid/webkit/WebViewClassic;->nativeSetPauseDrawing(IZ)V

    .line 3480
    :cond_20
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->cancelSelectDialog()V

    .line 3481
    invoke-static {}, Landroid/webkit/WebCoreThreadWatchdog;->pause()V

    .line 3483
    :cond_26
    return-void
.end method

.method onPinchToZoomAnimationEnd(Landroid/view/ScaleGestureDetector;)V
    .registers 6
    .parameter "detector"

    .prologue
    .line 5840
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->onZoomAnimationEnd()V

    .line 5844
    const/16 v0, 0x8

    iput v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    .line 5845
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mConfirmMove:Z

    .line 5846
    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusX()F

    move-result v0

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusY()F

    move-result v1

    iget-wide v2, p0, Landroid/webkit/WebViewClassic;->mLastTouchTime:J

    invoke-direct {p0, v0, v1, v2, v3}, Landroid/webkit/WebViewClassic;->startTouch(FFJ)V

    .line 5847
    return-void
.end method

.method onPinchToZoomAnimationStart()V
    .registers 1

    .prologue
    .line 5835
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->cancelTouch()V

    .line 5836
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->onZoomAnimationStart()V

    .line 5837
    return-void
.end method

.method public onResume()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 3506
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsPaused:Z

    if-eqz v0, :cond_17

    .line 3507
    iput-boolean v2, p0, Landroid/webkit/WebViewClassic;->mIsPaused:Z

    .line 3508
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x90

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 3509
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-eqz v0, :cond_17

    .line 3510
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    invoke-static {v0, v2}, Landroid/webkit/WebViewClassic;->nativeSetPauseDrawing(IZ)V

    .line 3516
    :cond_17
    invoke-static {}, Landroid/webkit/WebCoreThreadWatchdog;->resume()V

    .line 3517
    return-void
.end method

.method onSavePassword(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)Z
    .registers 11
    .parameter "schemePlusHost"
    .parameter "username"
    .parameter "password"
    .parameter "resumeMsg"

    .prologue
    const/4 v3, 0x1

    .line 1827
    const/4 v1, 0x0

    .line 1828
    .local v1, rVal:Z
    if-nez p4, :cond_b

    .line 1830
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mDatabase:Landroid/webkit/WebViewDatabaseClassic;

    invoke-virtual {v3, p1, p2, p3}, Landroid/webkit/WebViewDatabaseClassic;->setUsernamePassword(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    :goto_9
    move v3, v1

    .line 1898
    :goto_a
    return v3

    .line 1832
    :cond_b
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mResumeMsg:Landroid/os/Message;

    if-eqz v4, :cond_1c

    .line 1833
    const-string/jumbo v4, "webview"

    const-string/jumbo v5, "onSavePassword should not be called while dialog is up"

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1834
    invoke-virtual {p4}, Landroid/os/Message;->sendToTarget()V

    goto :goto_a

    .line 1837
    :cond_1c
    iput-object p4, p0, Landroid/webkit/WebViewClassic;->mResumeMsg:Landroid/os/Message;

    .line 1838
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    invoke-virtual {v4, v3}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v2

    .line 1840
    .local v2, remember:Landroid/os/Message;
    invoke-virtual {v2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v3

    const-string v4, "host"

    invoke-virtual {v3, v4, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1841
    invoke-virtual {v2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v3

    const-string/jumbo v4, "username"

    invoke-virtual {v3, v4, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1842
    invoke-virtual {v2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v3

    const-string/jumbo v4, "password"

    invoke-virtual {v3, v4, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1843
    iput-object p4, v2, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 1845
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v4, 0x2

    invoke-virtual {v3, v4}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .line 1847
    .local v0, neverRemember:Landroid/os/Message;
    invoke-virtual {v0}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v3

    const-string v4, "host"

    invoke-virtual {v3, v4, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1848
    invoke-virtual {v0}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v3

    const-string/jumbo v4, "username"

    invoke-virtual {v3, v4, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1849
    invoke-virtual {v0}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v3

    const-string/jumbo v4, "password"

    invoke-virtual {v3, v4, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1850
    iput-object p4, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 1852
    new-instance v3, Landroid/app/AlertDialog$Builder;

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    invoke-direct {v3, v4}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const v4, 0x1040340

    invoke-virtual {v3, v4}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    const v4, 0x1040391

    invoke-virtual {v3, v4}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    const v4, 0x1040392

    new-instance v5, Landroid/webkit/WebViewClassic$5;

    invoke-direct {v5, p0, p4}, Landroid/webkit/WebViewClassic$5;-><init>(Landroid/webkit/WebViewClassic;Landroid/os/Message;)V

    invoke-virtual {v3, v4, v5}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    const v4, 0x1040393

    new-instance v5, Landroid/webkit/WebViewClassic$4;

    invoke-direct {v5, p0, v2}, Landroid/webkit/WebViewClassic$4;-><init>(Landroid/webkit/WebViewClassic;Landroid/os/Message;)V

    invoke-virtual {v3, v4, v5}, Landroid/app/AlertDialog$Builder;->setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    const v4, 0x1040394

    new-instance v5, Landroid/webkit/WebViewClassic$3;

    invoke-direct {v5, p0, v0}, Landroid/webkit/WebViewClassic$3;-><init>(Landroid/webkit/WebViewClassic;Landroid/os/Message;)V

    invoke-virtual {v3, v4, v5}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    new-instance v4, Landroid/webkit/WebViewClassic$2;

    invoke-direct {v4, p0, p4}, Landroid/webkit/WebViewClassic$2;-><init>(Landroid/webkit/WebViewClassic;Landroid/os/Message;)V

    invoke-virtual {v3, v4}, Landroid/app/AlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 1896
    const/4 v1, 0x1

    goto/16 :goto_9
.end method

.method public onScrollChanged(IIII)V
    .registers 9
    .parameter "l"
    .parameter "t"
    .parameter "oldl"
    .parameter "oldt"

    .prologue
    const/4 v3, 0x0

    .line 5755
    iget-boolean v1, p0, Landroid/webkit/WebViewClassic;->mInOverScrollMode:Z

    if-nez v1, :cond_1d

    .line 5756
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->sendOurVisibleRect()Landroid/graphics/Rect;

    .line 5759
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v0

    .line 5760
    .local v0, titleHeight:I
    sub-int v1, v0, p2

    invoke-static {v1, v3}, Ljava/lang/Math;->max(II)I

    move-result v1

    sub-int v2, v0, p4

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v2

    if-eq v1, v2, :cond_1d

    .line 5761
    invoke-virtual {p0, v3}, Landroid/webkit/WebViewClassic;->sendViewSizeZoom(Z)Z

    .line 5764
    .end local v0           #titleHeight:I
    :cond_1d
    return-void
.end method

.method public onSizeChanged(IIII)V
    .registers 8
    .parameter "w"
    .parameter "h"
    .parameter "ow"
    .parameter "oh"

    .prologue
    .line 5667
    invoke-static {p1, p2}, Ljava/lang/Math;->max(II)I

    move-result v1

    int-to-float v1, v1

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v2}, Landroid/webkit/ZoomManager;->getDefaultMinZoomScale()F

    move-result v2

    div-float/2addr v1, v2

    float-to-int v0, v1

    .line 5668
    .local v0, newMaxViewportWidth:I
    sget v1, Landroid/webkit/WebViewClassic;->sMaxViewportWidth:I

    if-le v0, v1, :cond_13

    .line 5669
    sput v0, Landroid/webkit/WebViewClassic;->sMaxViewportWidth:I

    .line 5672
    :cond_13
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v1, p1, p2, p3, p4}, Landroid/webkit/ZoomManager;->onSizeChanged(IIII)V

    .line 5674
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mLoadedPicture:Landroid/webkit/WebViewCore$DrawData;

    if-eqz v1, :cond_26

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mDelaySetPicture:Landroid/webkit/WebViewCore$DrawData;

    if-nez v1, :cond_26

    .line 5678
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mLoadedPicture:Landroid/webkit/WebViewCore$DrawData;

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Landroid/webkit/WebViewClassic;->setNewPicture(Landroid/webkit/WebViewCore$DrawData;Z)V

    .line 5680
    :cond_26
    iget-boolean v1, p0, Landroid/webkit/WebViewClassic;->mIsEditingText:Z

    if-eqz v1, :cond_2d

    .line 5681
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->scrollEditIntoView()V

    .line 5683
    :cond_2d
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->relocateAutoCompletePopup()V

    .line 5684
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 8
    .parameter "ev"

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 5914
    iget v2, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-eqz v2, :cond_16

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->isClickable()Z

    move-result v2

    if-nez v2, :cond_17

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->isLongClickable()Z

    move-result v2

    if-nez v2, :cond_17

    .line 5945
    :cond_16
    :goto_16
    return v0

    .line 5918
    :cond_17
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mInputDispatcher:Landroid/webkit/WebViewInputDispatcher;

    if-eqz v2, :cond_16

    .line 5922
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->isFocusable()Z

    move-result v2

    if-eqz v2, :cond_38

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->isFocusableInTouchMode()Z

    move-result v2

    if-eqz v2, :cond_38

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->isFocused()Z

    move-result v2

    if-nez v2, :cond_38

    .line 5924
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->requestFocus()Z

    .line 5927
    :cond_38
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    if-ne v2, v1, :cond_71

    .line 5928
    iput-boolean v1, p0, Landroid/webkit/WebViewClassic;->mIsActionUp:Z

    .line 5929
    const/4 v2, 0x0

    iput-object v2, p0, Landroid/webkit/WebViewClassic;->mAfterStart:Ljava/lang/String;

    iput-object v2, p0, Landroid/webkit/WebViewClassic;->mBeforeStart:Ljava/lang/String;

    .line 5930
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 5931
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-eqz v2, :cond_4f

    .line 5932
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->showFloatView()V

    .line 5939
    :cond_4f
    :goto_4f
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mInputDispatcher:Landroid/webkit/WebViewInputDispatcher;

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v4

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v5

    sub-int/2addr v4, v5

    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v5}, Landroid/webkit/ZoomManager;->getInvScale()F

    move-result v5

    invoke-virtual {v2, p1, v3, v4, v5}, Landroid/webkit/WebViewInputDispatcher;->postPointerEvent(Landroid/view/MotionEvent;IIF)Z

    move-result v2

    if-eqz v2, :cond_7b

    .line 5941
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mInputDispatcher:Landroid/webkit/WebViewInputDispatcher;

    invoke-virtual {v0}, Landroid/webkit/WebViewInputDispatcher;->dispatchUiEvents()V

    move v0, v1

    .line 5942
    goto :goto_16

    .line 5934
    :cond_71
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-eqz v2, :cond_4f

    .line 5935
    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsActionUp:Z

    .line 5936
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->hideFloatView()V

    goto :goto_4f

    .line 5944
    :cond_7b
    const-string/jumbo v1, "webview"

    const-string/jumbo v2, "mInputDispatcher rejected the event!"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_16
.end method

.method public onTrackballEvent(Landroid/view/MotionEvent;)Z
    .registers 10
    .parameter "ev"

    .prologue
    const-wide/16 v6, 0xc8

    const/4 v5, 0x0

    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 6632
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v0

    .line 6633
    .local v0, time:J
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getMetaState()I

    move-result v4

    and-int/lit8 v4, v4, 0x2

    if-eqz v4, :cond_28

    .line 6634
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    cmpl-float v3, v3, v5

    if-lez v3, :cond_1c

    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->pageDown(Z)Z

    .line 6635
    :cond_1c
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    cmpg-float v3, v3, v5

    if-gez v3, :cond_27

    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->pageUp(Z)Z

    .line 6701
    :cond_27
    :goto_27
    return v2

    .line 6638
    :cond_28
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    if-nez v4, :cond_49

    .line 6639
    iget-boolean v4, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-nez v4, :cond_27

    .line 6642
    iput-boolean v2, p0, Landroid/webkit/WebViewClassic;->mTrackballDown:Z

    .line 6643
    iget v2, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v2, :cond_3a

    move v2, v3

    .line 6644
    goto :goto_27

    .line 6651
    :cond_3a
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->isInTouchMode()Z

    move-result v2

    if-eqz v2, :cond_47

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->requestFocusFromTouch()Z

    :cond_47
    move v2, v3

    .line 6652
    goto :goto_27

    .line 6654
    :cond_49
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    if-ne v4, v2, :cond_67

    .line 6656
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/16 v5, 0x72

    invoke-virtual {v4, v5}, Landroid/os/Handler;->removeMessages(I)V

    .line 6657
    iput-boolean v3, p0, Landroid/webkit/WebViewClassic;->mTrackballDown:Z

    .line 6658
    iput-wide v0, p0, Landroid/webkit/WebViewClassic;->mTrackballUpTime:J

    .line 6659
    iget-boolean v4, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-eqz v4, :cond_65

    .line 6660
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->copySelection()Z

    .line 6661
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->selectionDone()V

    goto :goto_27

    :cond_65
    move v2, v3

    .line 6669
    goto :goto_27

    .line 6671
    :cond_67
    iget-boolean v4, p0, Landroid/webkit/WebViewClassic;->mMapTrackballToArrowKeys:Z

    if-eqz v4, :cond_73

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getMetaState()I

    move-result v4

    and-int/lit8 v4, v4, 0x1

    if-eqz v4, :cond_7f

    :cond_73
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    invoke-static {v4}, Landroid/view/accessibility/AccessibilityManager;->getInstance(Landroid/content/Context;)Landroid/view/accessibility/AccessibilityManager;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v4

    if-eqz v4, :cond_81

    :cond_7f
    move v2, v3

    .line 6674
    goto :goto_27

    .line 6676
    :cond_81
    iget-boolean v4, p0, Landroid/webkit/WebViewClassic;->mTrackballDown:Z

    if-nez v4, :cond_27

    .line 6680
    iget-wide v4, p0, Landroid/webkit/WebViewClassic;->mTrackballUpTime:J

    sub-long v4, v0, v4

    cmp-long v4, v4, v6

    if-ltz v4, :cond_27

    .line 6685
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->switchOutDrawHistory()V

    .line 6686
    iget-wide v4, p0, Landroid/webkit/WebViewClassic;->mTrackballLastTime:J

    sub-long v4, v0, v4

    cmp-long v4, v4, v6

    if-lez v4, :cond_9e

    .line 6691
    iput-wide v0, p0, Landroid/webkit/WebViewClassic;->mTrackballFirstTime:J

    .line 6692
    iput v3, p0, Landroid/webkit/WebViewClassic;->mTrackballYMove:I

    iput v3, p0, Landroid/webkit/WebViewClassic;->mTrackballXMove:I

    .line 6694
    :cond_9e
    iput-wide v0, p0, Landroid/webkit/WebViewClassic;->mTrackballLastTime:J

    .line 6698
    iget v3, p0, Landroid/webkit/WebViewClassic;->mTrackballRemainsX:F

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v4

    add-float/2addr v3, v4

    iput v3, p0, Landroid/webkit/WebViewClassic;->mTrackballRemainsX:F

    .line 6699
    iget v3, p0, Landroid/webkit/WebViewClassic;->mTrackballRemainsY:F

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    add-float/2addr v3, v4

    iput v3, p0, Landroid/webkit/WebViewClassic;->mTrackballRemainsY:F

    .line 6700
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getMetaState()I

    move-result v3

    invoke-direct {p0, v0, v1, v3}, Landroid/webkit/WebViewClassic;->doTrackball(JI)V

    goto/16 :goto_27
.end method

.method public onVisibilityChanged(Landroid/view/View;I)V
    .registers 4
    .parameter "changedView"
    .parameter "visibility"

    .prologue
    .line 5506
    if-eqz p2, :cond_b

    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    if-eqz v0, :cond_b

    .line 5507
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->dismissZoomPicker()V

    .line 5509
    :cond_b
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->updateDrawingState()V

    .line 5510
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .registers 4
    .parameter "hasWindowFocus"

    .prologue
    .line 5546
    invoke-virtual {p0, p1}, Landroid/webkit/WebViewClassic;->setActive(Z)V

    .line 5547
    if-eqz p1, :cond_15

    .line 5548
    invoke-static {p0}, Landroid/webkit/JWebCoreJavaBridge;->setActiveWebView(Landroid/webkit/WebViewClassic;)V

    .line 5549
    iget-boolean v1, p0, Landroid/webkit/WebViewClassic;->mPictureUpdatePausedForFocusChange:Z

    if-eqz v1, :cond_14

    .line 5550
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-static {v1}, Landroid/webkit/WebViewCore;->resumeUpdatePicture(Landroid/webkit/WebViewCore;)V

    .line 5551
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/webkit/WebViewClassic;->mPictureUpdatePausedForFocusChange:Z

    .line 5562
    :cond_14
    :goto_14
    return-void

    .line 5554
    :cond_15
    invoke-static {p0}, Landroid/webkit/JWebCoreJavaBridge;->removeActiveWebView(Landroid/webkit/WebViewClassic;)V

    .line 5555
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v0

    .line 5556
    .local v0, settings:Landroid/webkit/WebSettings;
    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroid/webkit/WebSettingsClassic;->enableSmoothTransition()Z

    move-result v1

    if-eqz v1, :cond_14

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-eqz v1, :cond_14

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-static {v1}, Landroid/webkit/WebViewCore;->isUpdatePicturePaused(Landroid/webkit/WebViewCore;)Z

    move-result v1

    if-nez v1, :cond_14

    .line 5558
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-static {v1}, Landroid/webkit/WebViewCore;->pauseUpdatePicture(Landroid/webkit/WebViewCore;)V

    .line 5559
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/webkit/WebViewClassic;->mPictureUpdatePausedForFocusChange:Z

    goto :goto_14
.end method

.method public onWindowVisibilityChanged(I)V
    .registers 2
    .parameter "visibility"

    .prologue
    .line 3487
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->updateDrawingState()V

    .line 3488
    return-void
.end method

.method public overlayHorizontalScrollbar()Z
    .registers 2

    .prologue
    .line 1932
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mOverlayHorizontalScrollbar:Z

    return v0
.end method

.method public overlayVerticalScrollbar()Z
    .registers 2

    .prologue
    .line 1940
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mOverlayVerticalScrollbar:Z

    return v0
.end method

.method public pageDown(Z)Z
    .registers 8
    .parameter "bottom"

    .prologue
    const/4 v5, 0x1

    const/4 v2, 0x0

    .line 2778
    iget v3, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v3, :cond_7

    .line 2792
    :goto_6
    return v2

    .line 2781
    :cond_7
    if-eqz p1, :cond_16

    .line 2782
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->computeRealVerticalScrollRange()I

    move-result v4

    invoke-direct {p0, v3, v4, v5, v2}, Landroid/webkit/WebViewClassic;->pinScrollTo(IIZI)Z

    move-result v2

    goto :goto_6

    .line 2785
    :cond_16
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getHeight()I

    move-result v0

    .line 2787
    .local v0, h:I
    const/16 v3, 0x30

    if-le v0, v3, :cond_2d

    .line 2788
    add-int/lit8 v1, v0, -0x18

    .line 2792
    .local v1, y:I
    :goto_20
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v3}, Landroid/widget/OverScroller;->isFinished()Z

    move-result v3

    if-eqz v3, :cond_30

    invoke-direct {p0, v2, v1, v5, v2}, Landroid/webkit/WebViewClassic;->pinScrollBy(IIZI)Z

    move-result v2

    goto :goto_6

    .line 2790
    .end local v1           #y:I
    :cond_2d
    div-int/lit8 v1, v0, 0x2

    .restart local v1       #y:I
    goto :goto_20

    .line 2792
    :cond_30
    invoke-direct {p0, v1}, Landroid/webkit/WebViewClassic;->extendScroll(I)Z

    move-result v2

    goto :goto_6
.end method

.method protected pageSwapCallback(Z)V
    .registers 5
    .parameter "notifyAnimationStarted"

    .prologue
    .line 8001
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v0}, Landroid/webkit/WebViewCore;->resumeWebKitDraw()V

    .line 8002
    if-eqz p1, :cond_e

    .line 8003
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0xc4

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 8005
    :cond_e
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    instance-of v0, v0, Landroid/webkit/WebViewClassic$PageSwapDelegate;

    if-eqz v0, :cond_1b

    .line 8007
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    check-cast v0, Landroid/webkit/WebViewClassic$PageSwapDelegate;

    invoke-interface {v0, p1}, Landroid/webkit/WebViewClassic$PageSwapDelegate;->onPageSwapOccurred(Z)V

    .line 8010
    :cond_1b
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mPictureListener:Landroid/webkit/WebView$PictureListener;

    if-eqz v0, :cond_2c

    .line 8013
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mPictureListener:Landroid/webkit/WebView$PictureListener;

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->capturePicture()Landroid/graphics/Picture;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/webkit/WebView$PictureListener;->onNewPicture(Landroid/webkit/WebView;Landroid/graphics/Picture;)V

    .line 8015
    :cond_2c
    return-void
.end method

.method public pageUp(Z)Z
    .registers 7
    .parameter "top"

    .prologue
    const/4 v4, 0x1

    const/4 v2, 0x0

    .line 2754
    iget v3, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v3, :cond_7

    .line 2769
    :goto_6
    return v2

    .line 2757
    :cond_7
    if-eqz p1, :cond_12

    .line 2759
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    invoke-direct {p0, v3, v2, v4, v2}, Landroid/webkit/WebViewClassic;->pinScrollTo(IIZI)Z

    move-result v2

    goto :goto_6

    .line 2762
    :cond_12
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getHeight()I

    move-result v0

    .line 2764
    .local v0, h:I
    const/16 v3, 0x30

    if-le v0, v3, :cond_2a

    .line 2765
    neg-int v3, v0

    add-int/lit8 v1, v3, 0x18

    .line 2769
    .local v1, y:I
    :goto_1d
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v3}, Landroid/widget/OverScroller;->isFinished()Z

    move-result v3

    if-eqz v3, :cond_2e

    invoke-direct {p0, v2, v1, v4, v2}, Landroid/webkit/WebViewClassic;->pinScrollBy(IIZI)Z

    move-result v2

    goto :goto_6

    .line 2767
    .end local v1           #y:I
    :cond_2a
    neg-int v3, v0

    div-int/lit8 v1, v3, 0x2

    .restart local v1       #y:I
    goto :goto_1d

    .line 2769
    :cond_2e
    invoke-direct {p0, v1}, Landroid/webkit/WebViewClassic;->extendScroll(I)Z

    move-result v2

    goto :goto_6
.end method

.method passToJavaScript(Ljava/lang/String;Landroid/view/KeyEvent;)V
    .registers 9
    .parameter "currentText"
    .parameter "event"

    .prologue
    const/16 v5, 0x80

    .line 7258
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-nez v1, :cond_7

    .line 7273
    :goto_6
    return-void

    .line 7261
    :cond_7
    new-instance v0, Landroid/webkit/WebViewCore$JSKeyData;

    invoke-direct {v0}, Landroid/webkit/WebViewCore$JSKeyData;-><init>()V

    .line 7262
    .local v0, arg:Landroid/webkit/WebViewCore$JSKeyData;
    iput-object p2, v0, Landroid/webkit/WebViewCore$JSKeyData;->mEvent:Landroid/view/KeyEvent;

    .line 7263
    iput-object p1, v0, Landroid/webkit/WebViewCore$JSKeyData;->mCurrentText:Ljava/lang/String;

    .line 7265
    iget v1, p0, Landroid/webkit/WebViewClassic;->mTextGeneration:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroid/webkit/WebViewClassic;->mTextGeneration:I

    .line 7266
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v2, 0x73

    iget v3, p0, Landroid/webkit/WebViewClassic;->mTextGeneration:I

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4, v0}, Landroid/webkit/WebViewCore;->sendMessage(IIILjava/lang/Object;)V

    .line 7271
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v1, v5}, Landroid/webkit/WebViewCore;->removeMessages(I)V

    .line 7272
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/4 v2, 0x0

    const-wide/16 v3, 0x3e8

    invoke-virtual {v1, v5, v2, v3, v4}, Landroid/webkit/WebViewCore;->sendMessageDelayed(ILjava/lang/Object;J)V

    goto :goto_6
.end method

.method public pasteFromClipboard()V
    .registers 7

    .prologue
    .line 5442
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    const-string v5, "clipboard"

    invoke-virtual {v4, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/content/ClipboardManager;

    .line 5444
    .local v2, cm:Landroid/content/ClipboardManager;
    invoke-virtual {v2}, Landroid/content/ClipboardManager;->getPrimaryClip()Landroid/content/ClipData;

    move-result-object v0

    .line 5445
    .local v0, clipData:Landroid/content/ClipData;
    if-eqz v0, :cond_22

    .line 5446
    const/4 v4, 0x0

    invoke-virtual {v0, v4}, Landroid/content/ClipData;->getItemAt(I)Landroid/content/ClipData$Item;

    move-result-object v1

    .line 5447
    .local v1, clipItem:Landroid/content/ClipData$Item;
    invoke-virtual {v1}, Landroid/content/ClipData$Item;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    .line 5448
    .local v3, pasteText:Ljava/lang/CharSequence;
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    if-eqz v4, :cond_22

    .line 5449
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    invoke-virtual {v4, v3}, Landroid/webkit/WebViewClassic$WebViewInputConnection;->replaceSelection(Ljava/lang/CharSequence;)V

    .line 5452
    .end local v1           #clipItem:Landroid/content/ClipData$Item;
    .end local v3           #pasteText:Ljava/lang/CharSequence;
    :cond_22
    return-void
.end method

.method public pauseTimers()V
    .registers 3

    .prologue
    .line 3452
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x6d

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 3453
    return-void
.end method

.method public performAccessibilityAction(ILandroid/os/Bundle;)Z
    .registers 12
    .parameter "action"
    .parameter "arguments"

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 1706
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v7}, Landroid/webkit/WebView;->isEnabled()Z

    move-result v7

    if-nez v7, :cond_11

    .line 1708
    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v5, p1, p2}, Landroid/webkit/WebView$PrivateAccess;->super_performAccessibilityAction(ILandroid/os/Bundle;)Z

    move-result v5

    .line 1736
    :goto_10
    return v5

    .line 1711
    :cond_11
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getAccessibilityInjector()Landroid/webkit/AccessibilityInjector;

    move-result-object v7

    invoke-virtual {v7, p1}, Landroid/webkit/AccessibilityInjector;->supportsAccessibilityAction(I)Z

    move-result v7

    if-eqz v7, :cond_24

    .line 1712
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getAccessibilityInjector()Landroid/webkit/AccessibilityInjector;

    move-result-object v5

    invoke-virtual {v5, p1, p2}, Landroid/webkit/AccessibilityInjector;->performAccessibilityAction(ILandroid/os/Bundle;)Z

    move-result v5

    goto :goto_10

    .line 1715
    :cond_24
    sparse-switch p1, :sswitch_data_7e

    .line 1736
    iget-object v5, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v5, p1, p2}, Landroid/webkit/WebView$PrivateAccess;->super_performAccessibilityAction(ILandroid/os/Bundle;)Z

    move-result v5

    goto :goto_10

    .line 1718
    :sswitch_2e
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getContentHeight()I

    move-result v7

    invoke-virtual {p0, v7}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v3

    .line 1719
    .local v3, convertedContentHeight:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getHeight()I

    move-result v7

    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v8}, Landroid/webkit/WebView;->getPaddingTop()I

    move-result v8

    sub-int/2addr v7, v8

    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v8}, Landroid/webkit/WebView;->getPaddingBottom()I

    move-result v8

    sub-int v0, v7, v8

    .line 1721
    .local v0, adjustedViewHeight:I
    sub-int v7, v3, v0

    invoke-static {v7, v6}, Ljava/lang/Math;->max(II)I

    move-result v4

    .line 1722
    .local v4, maxScrollY:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v7

    if-lez v7, :cond_6a

    move v1, v5

    .line 1723
    .local v1, canScrollBackward:Z
    :goto_56
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v7

    sub-int/2addr v7, v4

    if-lez v7, :cond_6c

    move v2, v5

    .line 1724
    .local v2, canScrollForward:Z
    :goto_5e
    const/16 v7, 0x2000

    if-ne p1, v7, :cond_6e

    if-eqz v1, :cond_6e

    .line 1725
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v7, v6, v0}, Landroid/webkit/WebView;->scrollBy(II)V

    goto :goto_10

    .end local v1           #canScrollBackward:Z
    .end local v2           #canScrollForward:Z
    :cond_6a
    move v1, v6

    .line 1722
    goto :goto_56

    .restart local v1       #canScrollBackward:Z
    :cond_6c
    move v2, v6

    .line 1723
    goto :goto_5e

    .line 1728
    .restart local v2       #canScrollForward:Z
    :cond_6e
    const/16 v7, 0x1000

    if-ne p1, v7, :cond_7b

    if-eqz v2, :cond_7b

    .line 1729
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    neg-int v8, v0

    invoke-virtual {v7, v6, v8}, Landroid/webkit/WebView;->scrollBy(II)V

    goto :goto_10

    :cond_7b
    move v5, v6

    .line 1732
    goto :goto_10

    .line 1715
    nop

    :sswitch_data_7e
    .sparse-switch
        0x1000 -> :sswitch_2e
        0x2000 -> :sswitch_2e
    .end sparse-switch
.end method

.method public performLongClick()Z
    .registers 5
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 4389
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v3}, Landroid/webkit/WebView;->getParent()Landroid/view/ViewParent;

    move-result-object v3

    if-nez v3, :cond_b

    move v1, v2

    .line 4413
    :cond_a
    :goto_a
    return v1

    .line 4393
    :cond_b
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v3}, Landroid/webkit/ZoomManager;->getMultiTouchGestureDetector()Landroid/view/ScaleGestureDetector;

    move-result-object v0

    .line 4394
    .local v0, detector:Landroid/view/ScaleGestureDetector;
    if-eqz v0, :cond_1b

    invoke-virtual {v0}, Landroid/view/ScaleGestureDetector;->isInProgress()Z

    move-result v3

    if-eqz v3, :cond_1b

    move v1, v2

    .line 4395
    goto :goto_a

    .line 4398
    :cond_1b
    iget-boolean v3, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-eqz v3, :cond_21

    move v1, v2

    goto :goto_a

    .line 4402
    :cond_21
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v3}, Landroid/webkit/WebView$PrivateAccess;->super_performLongClick()Z

    move-result v3

    if-eqz v3, :cond_2b

    .line 4403
    const/4 v1, 0x1

    goto :goto_a

    .line 4409
    :cond_2b
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->selectText()Z

    move-result v1

    .line 4410
    .local v1, isSelecting:Z
    if-eqz v1, :cond_a

    .line 4411
    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v3, v2}, Landroid/webkit/WebView;->performHapticFeedback(I)Z

    goto :goto_a
.end method

.method pinLocX(I)I
    .registers 4
    .parameter "x"

    .prologue
    .line 2944
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mInOverScrollMode:Z

    if-eqz v0, :cond_5

    .line 2945
    .end local p1
    :goto_4
    return p1

    .restart local p1
    :cond_5
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getViewWidth()I

    move-result v0

    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->computeRealHorizontalScrollRange()I

    move-result v1

    invoke-static {p1, v0, v1}, Landroid/webkit/WebViewClassic;->pinLoc(III)I

    move-result p1

    goto :goto_4
.end method

.method pinLocY(I)I
    .registers 5
    .parameter "y"

    .prologue
    .line 2950
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mInOverScrollMode:Z

    if-eqz v0, :cond_5

    .line 2951
    .end local p1
    :goto_4
    return p1

    .restart local p1
    :cond_5
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getViewHeightWithTitle()I

    move-result v0

    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->computeRealVerticalScrollRange()I

    move-result v1

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v2

    add-int/2addr v1, v2

    invoke-static {p1, v0, v1}, Landroid/webkit/WebViewClassic;->pinLoc(III)I

    move-result p1

    goto :goto_4
.end method

.method public postUrl(Ljava/lang/String;[B)V
    .registers 6
    .parameter "url"
    .parameter "postData"

    .prologue
    .line 2536
    invoke-static {p1}, Landroid/webkit/URLUtil;->isNetworkUrl(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1d

    .line 2537
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->switchOutDrawHistory()V

    .line 2538
    new-instance v0, Landroid/webkit/WebViewCore$PostUrlData;

    invoke-direct {v0}, Landroid/webkit/WebViewCore$PostUrlData;-><init>()V

    .line 2539
    .local v0, arg:Landroid/webkit/WebViewCore$PostUrlData;
    iput-object p1, v0, Landroid/webkit/WebViewCore$PostUrlData;->mUrl:Ljava/lang/String;

    .line 2540
    iput-object p2, v0, Landroid/webkit/WebViewCore$PostUrlData;->mPostData:[B

    .line 2541
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v2, 0x84

    invoke-virtual {v1, v2, v0}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 2542
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->clearHelpers()V

    .line 2546
    .end local v0           #arg:Landroid/webkit/WebViewCore$PostUrlData;
    :goto_1c
    return-void

    .line 2544
    :cond_1d
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->loadUrlImpl(Ljava/lang/String;)V

    goto :goto_1c
.end method

.method public refreshPlugins(Z)V
    .registers 2
    .parameter "reloadOpenPages"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 4157
    return-void
.end method

.method public reload()V
    .registers 3

    .prologue
    .line 2640
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->clearHelpers()V

    .line 2641
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->switchOutDrawHistory()V

    .line 2642
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x66

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 2643
    return-void
.end method

.method public removeJavascriptInterface(Ljava/lang/String;)V
    .registers 5
    .parameter "interfaceName"

    .prologue
    .line 4127
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-eqz v1, :cond_12

    .line 4128
    new-instance v0, Landroid/webkit/WebViewCore$JSInterfaceData;

    invoke-direct {v0}, Landroid/webkit/WebViewCore$JSInterfaceData;-><init>()V

    .line 4129
    .local v0, arg:Landroid/webkit/WebViewCore$JSInterfaceData;
    iput-object p1, v0, Landroid/webkit/WebViewCore$JSInterfaceData;->mInterfaceName:Ljava/lang/String;

    .line 4130
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v2, 0x95

    invoke-virtual {v1, v2, v0}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 4132
    .end local v0           #arg:Landroid/webkit/WebViewCore$JSInterfaceData;
    :cond_12
    return-void
.end method

.method replaceTextfieldText(IILjava/lang/String;II)V
    .registers 8
    .parameter "oldStart"
    .parameter "oldEnd"
    .parameter "replace"
    .parameter "newStart"
    .parameter "newEnd"

    .prologue
    .line 7247
    new-instance v0, Landroid/webkit/WebViewCore$ReplaceTextData;

    invoke-direct {v0}, Landroid/webkit/WebViewCore$ReplaceTextData;-><init>()V

    .line 7248
    .local v0, arg:Landroid/webkit/WebViewCore$ReplaceTextData;
    iput-object p3, v0, Landroid/webkit/WebViewCore$ReplaceTextData;->mReplace:Ljava/lang/String;

    .line 7249
    iput p4, v0, Landroid/webkit/WebViewCore$ReplaceTextData;->mNewStart:I

    .line 7250
    iput p5, v0, Landroid/webkit/WebViewCore$ReplaceTextData;->mNewEnd:I

    .line 7251
    iget v1, p0, Landroid/webkit/WebViewClassic;->mTextGeneration:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroid/webkit/WebViewClassic;->mTextGeneration:I

    .line 7252
    iget v1, p0, Landroid/webkit/WebViewClassic;->mTextGeneration:I

    iput v1, v0, Landroid/webkit/WebViewCore$ReplaceTextData;->mTextGeneration:I

    .line 7253
    const/16 v1, 0x72

    invoke-virtual {p0, v1, p1, p2, v0}, Landroid/webkit/WebViewClassic;->sendBatchableInputMessage(IIILjava/lang/Object;)V

    .line 7254
    return-void
.end method

.method public requestChildRectangleOnScreen(Landroid/view/View;Landroid/graphics/Rect;Z)Z
    .registers 20
    .parameter "child"
    .parameter "rect"
    .parameter "immediate"

    .prologue
    .line 7186
    move-object/from16 v0, p0

    iget v11, v0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v11, :cond_8

    .line 7187
    const/4 v11, 0x0

    .line 7242
    :goto_7
    return v11

    .line 7191
    :cond_8
    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v11}, Landroid/webkit/ZoomManager;->isFixedLengthAnimationInProgress()Z

    move-result v11

    if-eqz v11, :cond_14

    .line 7192
    const/4 v11, 0x0

    goto :goto_7

    .line 7195
    :cond_14
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getLeft()I

    move-result v11

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getScrollX()I

    move-result v12

    sub-int/2addr v11, v12

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getTop()I

    move-result v12

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getScrollY()I

    move-result v13

    sub-int/2addr v12, v13

    move-object/from16 v0, p2

    invoke-virtual {v0, v11, v12}, Landroid/graphics/Rect;->offset(II)V

    .line 7198
    new-instance v1, Landroid/graphics/Rect;

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v11

    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Landroid/webkit/WebViewClassic;->viewToContentX(I)I

    move-result v11

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v12

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Landroid/webkit/WebViewClassic;->viewToContentY(I)I

    move-result v12

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v13

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getWidth()I

    move-result v14

    add-int/2addr v13, v14

    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v14}, Landroid/webkit/WebView;->getVerticalScrollbarWidth()I

    move-result v14

    sub-int/2addr v13, v14

    move-object/from16 v0, p0

    invoke-virtual {v0, v13}, Landroid/webkit/WebViewClassic;->viewToContentX(I)I

    move-result v13

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v14

    invoke-virtual/range {p0 .. p0}, Landroid/webkit/WebViewClassic;->getViewHeightWithTitle()I

    move-result v15

    add-int/2addr v14, v15

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Landroid/webkit/WebViewClassic;->viewToContentY(I)I

    move-result v14

    invoke-direct {v1, v11, v12, v13, v14}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 7203
    .local v1, content:Landroid/graphics/Rect;
    iget v11, v1, Landroid/graphics/Rect;->top:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v7

    .line 7204
    .local v7, screenTop:I
    iget v11, v1, Landroid/graphics/Rect;->bottom:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v4

    .line 7205
    .local v4, screenBottom:I
    sub-int v2, v4, v7

    .line 7206
    .local v2, height:I
    const/4 v9, 0x0

    .line 7208
    .local v9, scrollYDelta:I
    move-object/from16 v0, p2

    iget v11, v0, Landroid/graphics/Rect;->bottom:I

    if-le v11, v4, :cond_d8

    .line 7209
    div-int/lit8 v3, v2, 0x3

    .line 7210
    .local v3, oneThirdOfScreenHeight:I
    invoke-virtual/range {p2 .. p2}, Landroid/graphics/Rect;->height()I

    move-result v11

    mul-int/lit8 v12, v3, 0x2

    if-le v11, v12, :cond_cf

    .line 7213
    move-object/from16 v0, p2

    iget v11, v0, Landroid/graphics/Rect;->top:I

    sub-int v9, v11, v7

    .line 7223
    .end local v3           #oneThirdOfScreenHeight:I
    :cond_94
    :goto_94
    iget v11, v1, Landroid/graphics/Rect;->left:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Landroid/webkit/WebViewClassic;->contentToViewX(I)I

    move-result v5

    .line 7224
    .local v5, screenLeft:I
    iget v11, v1, Landroid/graphics/Rect;->right:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Landroid/webkit/WebViewClassic;->contentToViewX(I)I

    move-result v6

    .line 7225
    .local v6, screenRight:I
    sub-int v10, v6, v5

    .line 7226
    .local v10, width:I
    const/4 v8, 0x0

    .line 7228
    .local v8, scrollXDelta:I
    move-object/from16 v0, p2

    iget v11, v0, Landroid/graphics/Rect;->right:I

    if-le v11, v6, :cond_ec

    move-object/from16 v0, p2

    iget v11, v0, Landroid/graphics/Rect;->left:I

    if-le v11, v5, :cond_ec

    .line 7229
    invoke-virtual/range {p2 .. p2}, Landroid/graphics/Rect;->width()I

    move-result v11

    if-le v11, v10, :cond_e5

    .line 7230
    move-object/from16 v0, p2

    iget v11, v0, Landroid/graphics/Rect;->left:I

    sub-int/2addr v11, v5

    add-int/2addr v8, v11

    .line 7238
    :cond_bf
    :goto_bf
    or-int v11, v9, v8

    if-eqz v11, :cond_fc

    .line 7239
    if-nez p3, :cond_fa

    const/4 v11, 0x1

    :goto_c6
    const/4 v12, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v8, v9, v11, v12}, Landroid/webkit/WebViewClassic;->pinScrollBy(IIZI)Z

    move-result v11

    goto/16 :goto_7

    .line 7217
    .end local v5           #screenLeft:I
    .end local v6           #screenRight:I
    .end local v8           #scrollXDelta:I
    .end local v10           #width:I
    .restart local v3       #oneThirdOfScreenHeight:I
    :cond_cf
    move-object/from16 v0, p2

    iget v11, v0, Landroid/graphics/Rect;->top:I

    add-int v12, v7, v3

    sub-int v9, v11, v12

    goto :goto_94

    .line 7219
    .end local v3           #oneThirdOfScreenHeight:I
    :cond_d8
    move-object/from16 v0, p2

    iget v11, v0, Landroid/graphics/Rect;->top:I

    if-ge v11, v7, :cond_94

    .line 7220
    move-object/from16 v0, p2

    iget v11, v0, Landroid/graphics/Rect;->top:I

    sub-int v9, v11, v7

    goto :goto_94

    .line 7232
    .restart local v5       #screenLeft:I
    .restart local v6       #screenRight:I
    .restart local v8       #scrollXDelta:I
    .restart local v10       #width:I
    :cond_e5
    move-object/from16 v0, p2

    iget v11, v0, Landroid/graphics/Rect;->right:I

    sub-int/2addr v11, v6

    add-int/2addr v8, v11

    goto :goto_bf

    .line 7234
    :cond_ec
    move-object/from16 v0, p2

    iget v11, v0, Landroid/graphics/Rect;->left:I

    if-ge v11, v5, :cond_bf

    .line 7235
    move-object/from16 v0, p2

    iget v11, v0, Landroid/graphics/Rect;->left:I

    sub-int v11, v5, v11

    sub-int/2addr v8, v11

    goto :goto_bf

    .line 7239
    :cond_fa
    const/4 v11, 0x0

    goto :goto_c6

    .line 7242
    :cond_fc
    const/4 v11, 0x0

    goto/16 :goto_7
.end method

.method public requestFocus(ILandroid/graphics/Rect;)Z
    .registers 7
    .parameter "direction"
    .parameter "previouslyFocusedRect"

    .prologue
    .line 7102
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mFindIsUp:Z

    if-eqz v2, :cond_6

    const/4 v1, 0x0

    .line 7129
    :cond_5
    :goto_5
    return v1

    .line 7103
    :cond_6
    const/4 v1, 0x0

    .line 7104
    .local v1, result:Z
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v2, p1, p2}, Landroid/webkit/WebView$PrivateAccess;->super_requestFocus(ILandroid/graphics/Rect;)Z

    move-result v1

    .line 7105
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v2}, Landroid/webkit/WebViewCore;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebSettingsClassic;->getNeedInitialFocus()Z

    move-result v2

    if-eqz v2, :cond_5

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->isInTouchMode()Z

    move-result v2

    if-nez v2, :cond_5

    .line 7110
    const/4 v0, 0x0

    .line 7111
    .local v0, fakeKeyDirection:I
    sparse-switch p1, :sswitch_data_3a

    goto :goto_5

    .line 7119
    :sswitch_26
    const/16 v0, 0x15

    .line 7127
    :goto_28
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v3, 0xe0

    invoke-virtual {v2, v3, v0}, Landroid/webkit/WebViewCore;->sendMessage(II)V

    goto :goto_5

    .line 7113
    :sswitch_30
    const/16 v0, 0x13

    .line 7114
    goto :goto_28

    .line 7116
    :sswitch_33
    const/16 v0, 0x14

    .line 7117
    goto :goto_28

    .line 7122
    :sswitch_36
    const/16 v0, 0x16

    .line 7123
    goto :goto_28

    .line 7111
    nop

    :sswitch_data_3a
    .sparse-switch
        0x11 -> :sswitch_26
        0x21 -> :sswitch_30
        0x42 -> :sswitch_36
        0x82 -> :sswitch_33
    .end sparse-switch
.end method

.method public requestFocusNodeHref(Landroid/os/Message;)V
    .registers 7
    .parameter "hrefMsg"

    .prologue
    .line 2896
    if-nez p1, :cond_3

    .line 2911
    :goto_2
    return-void

    .line 2899
    :cond_3
    iget v2, p0, Landroid/webkit/WebViewClassic;->mLastTouchX:I

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->viewToContentX(I)I

    move-result v0

    .line 2900
    .local v0, contentX:I
    iget v2, p0, Landroid/webkit/WebViewClassic;->mLastTouchY:I

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->viewToContentY(I)I

    move-result v1

    .line 2901
    .local v1, contentY:I
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    if-eqz v2, :cond_57

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget v2, v2, Landroid/webkit/WebViewCore$WebKitHitTest;->mHitTestX:I

    if-ne v2, v0, :cond_57

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget v2, v2, Landroid/webkit/WebViewCore$WebKitHitTest;->mHitTestY:I

    if-ne v2, v1, :cond_57

    .line 2903
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v2

    const-string/jumbo v3, "url"

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget-object v4, v4, Landroid/webkit/WebViewCore$WebKitHitTest;->mLinkUrl:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2904
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v2

    const-string/jumbo v3, "title"

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget-object v4, v4, Landroid/webkit/WebViewCore$WebKitHitTest;->mAnchorText:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2905
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v2

    const-string/jumbo v3, "src"

    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget-object v4, v4, Landroid/webkit/WebViewCore$WebKitHitTest;->mImageUrl:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2906
    invoke-virtual {p1}, Landroid/os/Message;->sendToTarget()V

    goto :goto_2

    .line 2909
    :cond_57
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v3, 0x89

    invoke-virtual {v2, v3, v0, v1, p1}, Landroid/webkit/WebViewCore;->sendMessage(IIILjava/lang/Object;)V

    goto :goto_2
.end method

.method requestFormData(Ljava/lang/String;IZZ)V
    .registers 13
    .parameter "name"
    .parameter "nodePointer"
    .parameter "autoFillable"
    .parameter "autoComplete"

    .prologue
    .line 4868
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v1}, Landroid/webkit/WebViewCore;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebSettingsClassic;->getSaveFormData()Z

    move-result v1

    if-eqz v1, :cond_2a

    .line 4869
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v2, 0x6

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v4

    .line 4870
    .local v4, update:Landroid/os/Message;
    iput p2, v4, Landroid/os/Message;->arg1:I

    .line 4871
    new-instance v0, Landroid/webkit/WebViewClassic$RequestFormData;

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getUrl()Ljava/lang/String;

    move-result-object v3

    move-object v1, p0

    move-object v2, p1

    move v5, p3

    move v6, p4

    invoke-direct/range {v0 .. v6}, Landroid/webkit/WebViewClassic$RequestFormData;-><init>(Landroid/webkit/WebViewClassic;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;ZZ)V

    .line 4873
    .local v0, updater:Landroid/webkit/WebViewClassic$RequestFormData;
    new-instance v7, Ljava/lang/Thread;

    invoke-direct {v7, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 4874
    .local v7, t:Ljava/lang/Thread;
    invoke-virtual {v7}, Ljava/lang/Thread;->start()V

    .line 4876
    .end local v0           #updater:Landroid/webkit/WebViewClassic$RequestFormData;
    .end local v4           #update:Landroid/os/Message;
    .end local v7           #t:Ljava/lang/Thread;
    :cond_2a
    return-void
.end method

.method public requestImageRef(Landroid/os/Message;)V
    .registers 5
    .parameter "msg"

    .prologue
    .line 2918
    iget v2, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v2, :cond_5

    .line 2924
    :goto_4
    return-void

    .line 2919
    :cond_5
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    if-eqz v2, :cond_1e

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mFocusedNode:Landroid/webkit/WebViewCore$WebKitHitTest;

    iget-object v1, v2, Landroid/webkit/WebViewCore$WebKitHitTest;->mImageUrl:Ljava/lang/String;

    .line 2920
    .local v1, url:Ljava/lang/String;
    :goto_d
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    .line 2921
    .local v0, data:Landroid/os/Bundle;
    const-string/jumbo v2, "url"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2922
    invoke-virtual {p1, v0}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    .line 2923
    invoke-virtual {p1}, Landroid/os/Message;->sendToTarget()V

    goto :goto_4

    .line 2919
    .end local v0           #data:Landroid/os/Bundle;
    .end local v1           #url:Ljava/lang/String;
    :cond_1e
    const/4 v1, 0x0

    goto :goto_d
.end method

.method requestListBox([Ljava/lang/String;[II)V
    .registers 11
    .parameter "array"
    .parameter "enabledArray"
    .parameter "selection"

    .prologue
    .line 8498
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    new-instance v0, Landroid/webkit/WebViewClassic$InvokeListBox;

    const/4 v5, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move v4, p3

    invoke-direct/range {v0 .. v5}, Landroid/webkit/WebViewClassic$InvokeListBox;-><init>(Landroid/webkit/WebViewClassic;[Ljava/lang/String;[IILandroid/webkit/WebViewClassic$1;)V

    invoke-virtual {v6, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 8500
    return-void
.end method

.method requestListBox([Ljava/lang/String;[I[I)V
    .registers 11
    .parameter "array"
    .parameter "enabledArray"
    .parameter "selectedArray"

    .prologue
    .line 8484
    iget-object v6, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    new-instance v0, Landroid/webkit/WebViewClassic$InvokeListBox;

    const/4 v5, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    invoke-direct/range {v0 .. v5}, Landroid/webkit/WebViewClassic$InvokeListBox;-><init>(Landroid/webkit/WebViewClassic;[Ljava/lang/String;[I[ILandroid/webkit/WebViewClassic$1;)V

    invoke-virtual {v6, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 8486
    return-void
.end method

.method resetTrackballTime()V
    .registers 3

    .prologue
    .line 6627
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/webkit/WebViewClassic;->mTrackballLastTime:J

    .line 6628
    return-void
.end method

.method public restorePicture(Landroid/os/Bundle;Ljava/io/File;)Z
    .registers 8
    .parameter "b"
    .parameter "src"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 2342
    if-eqz p2, :cond_5

    if-nez p1, :cond_6

    .line 2378
    :cond_5
    :goto_5
    return v3

    .line 2345
    :cond_6
    invoke-virtual {p2}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 2349
    :try_start_c
    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, p2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 2350
    .local v2, in:Ljava/io/FileInputStream;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0, p1}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    .line 2351
    .local v0, copy:Landroid/os/Bundle;
    new-instance v3, Ljava/lang/Thread;

    new-instance v4, Landroid/webkit/WebViewClassic$7;

    invoke-direct {v4, p0, v2, v0}, Landroid/webkit/WebViewClassic$7;-><init>(Landroid/webkit/WebViewClassic;Ljava/io/FileInputStream;Landroid/os/Bundle;)V

    invoke-direct {v3, v4}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v3}, Ljava/lang/Thread;->start()V
    :try_end_23
    .catch Ljava/io/FileNotFoundException; {:try_start_c .. :try_end_23} :catch_25

    .line 2378
    .end local v0           #copy:Landroid/os/Bundle;
    .end local v2           #in:Ljava/io/FileInputStream;
    :goto_23
    const/4 v3, 0x1

    goto :goto_5

    .line 2375
    :catch_25
    move-exception v1

    .line 2376
    .local v1, e:Ljava/io/FileNotFoundException;
    invoke-virtual {v1}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_23
.end method

.method public restoreState(Landroid/os/Bundle;)Landroid/webkit/WebBackForwardList;
    .registers 12
    .parameter "inState"

    .prologue
    const/4 v8, 0x0

    .line 2448
    const/4 v6, 0x0

    .line 2449
    .local v6, returnList:Landroid/webkit/WebBackForwardList;
    if-nez p1, :cond_6

    move-object v8, v6

    .line 2496
    :goto_5
    return-object v8

    .line 2452
    :cond_6
    const-string v9, "index"

    invoke-virtual {p1, v9}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_87

    const-string v9, "history"

    invoke-virtual {p1, v9}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_87

    .line 2453
    const-string v9, "certificate"

    invoke-virtual {p1, v9}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v9

    invoke-static {v9}, Landroid/net/http/SslCertificate;->restoreState(Landroid/os/Bundle;)Landroid/net/http/SslCertificate;

    move-result-object v9

    iput-object v9, p0, Landroid/webkit/WebViewClassic;->mCertificate:Landroid/net/http/SslCertificate;

    .line 2456
    iget-object v9, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v9}, Landroid/webkit/CallbackProxy;->getBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v5

    .line 2457
    .local v5, list:Landroid/webkit/WebBackForwardList;
    const-string v9, "index"

    invoke-virtual {p1, v9}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    .line 2461
    .local v3, index:I
    monitor-enter v5

    .line 2462
    :try_start_2f
    const-string v9, "history"

    invoke-virtual {p1, v9}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 2464
    .local v1, history:Ljava/util/List;,"Ljava/util/List<[B>;"
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v7

    .line 2467
    .local v7, size:I
    if-ltz v3, :cond_3f

    if-lt v3, v7, :cond_44

    .line 2468
    :cond_3f
    monitor-exit v5

    goto :goto_5

    .line 2484
    .end local v1           #history:Ljava/util/List;,"Ljava/util/List<[B>;"
    .end local v7           #size:I
    :catchall_41
    move-exception v8

    monitor-exit v5
    :try_end_43
    .catchall {:try_start_2f .. :try_end_43} :catchall_41

    throw v8

    .line 2470
    .restart local v1       #history:Ljava/util/List;,"Ljava/util/List<[B>;"
    .restart local v7       #size:I
    :cond_44
    const/4 v2, 0x0

    .local v2, i:I
    :goto_45
    if-ge v2, v7, :cond_5d

    .line 2471
    const/4 v9, 0x0

    :try_start_48
    invoke-interface {v1, v9}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    .line 2472
    .local v0, data:[B
    if-nez v0, :cond_52

    .line 2475
    monitor-exit v5

    goto :goto_5

    .line 2477
    :cond_52
    new-instance v4, Landroid/webkit/WebHistoryItem;

    invoke-direct {v4, v0}, Landroid/webkit/WebHistoryItem;-><init>([B)V

    .line 2478
    .local v4, item:Landroid/webkit/WebHistoryItem;
    invoke-virtual {v5, v4}, Landroid/webkit/WebBackForwardList;->addHistoryItem(Landroid/webkit/WebHistoryItem;)V

    .line 2470
    add-int/lit8 v2, v2, 0x1

    goto :goto_45

    .line 2481
    .end local v0           #data:[B
    .end local v4           #item:Landroid/webkit/WebHistoryItem;
    :cond_5d
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->copyBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v6

    .line 2483
    invoke-virtual {v6, v3}, Landroid/webkit/WebBackForwardList;->setCurrentIndex(I)V

    .line 2484
    monitor-exit v5
    :try_end_65
    .catchall {:try_start_48 .. :try_end_65} :catchall_41

    .line 2486
    const-string/jumbo v8, "privateBrowsingEnabled"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_76

    .line 2487
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v8

    const/4 v9, 0x1

    invoke-virtual {v8, v9}, Landroid/webkit/WebSettingsClassic;->setPrivateBrowsingEnabled(Z)V

    .line 2489
    :cond_76
    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v8, p1}, Landroid/webkit/ZoomManager;->restoreZoomState(Landroid/os/Bundle;)V

    .line 2492
    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v8}, Landroid/webkit/WebViewCore;->removeMessages()V

    .line 2494
    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v9, 0x6c

    invoke-virtual {v8, v9, v3}, Landroid/webkit/WebViewCore;->sendMessage(II)V

    .end local v1           #history:Ljava/util/List;,"Ljava/util/List<[B>;"
    .end local v2           #i:I
    .end local v3           #index:I
    .end local v5           #list:Landroid/webkit/WebBackForwardList;
    .end local v7           #size:I
    :cond_87
    move-object v8, v6

    .line 2496
    goto/16 :goto_5
.end method

.method public resumeTimers()V
    .registers 3

    .prologue
    .line 3460
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x6e

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 3461
    return-void
.end method

.method public savePassword(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 5
    .parameter "host"
    .parameter "username"
    .parameter "password"

    .prologue
    .line 2050
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mDatabase:Landroid/webkit/WebViewDatabaseClassic;

    invoke-virtual {v0, p1, p2, p3}, Landroid/webkit/WebViewDatabaseClassic;->setUsernamePassword(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2051
    return-void
.end method

.method public savePicture(Landroid/os/Bundle;Ljava/io/File;)Z
    .registers 7
    .parameter "b"
    .parameter "dest"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2281
    if-eqz p2, :cond_4

    if-nez p1, :cond_6

    .line 2282
    :cond_4
    const/4 v2, 0x0

    .line 2316
    :goto_5
    return v2

    .line 2284
    :cond_6
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->capturePicture()Landroid/graphics/Picture;

    move-result-object v0

    .line 2287
    .local v0, p:Landroid/graphics/Picture;
    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".writing"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 2288
    .local v1, temp:Ljava/io/File;
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Landroid/webkit/WebViewClassic$6;

    invoke-direct {v3, p0, v1, v0, p2}, Landroid/webkit/WebViewClassic$6;-><init>(Landroid/webkit/WebViewClassic;Ljava/io/File;Landroid/graphics/Picture;Ljava/io/File;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 2313
    const-string/jumbo v2, "scrollX"

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2314
    const-string/jumbo v2, "scrollY"

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v3

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2315
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v2, p1}, Landroid/webkit/ZoomManager;->saveZoomState(Landroid/os/Bundle;)V

    .line 2316
    const/4 v2, 0x1

    goto :goto_5
.end method

.method public saveState(Landroid/os/Bundle;)Landroid/webkit/WebBackForwardList;
    .registers 12
    .parameter "outState"

    .prologue
    const/4 v7, 0x0

    .line 2230
    if-nez p1, :cond_5

    move-object v5, v7

    .line 2272
    :goto_4
    return-object v5

    .line 2235
    :cond_5
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->copyBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v5

    .line 2236
    .local v5, list:Landroid/webkit/WebBackForwardList;
    invoke-virtual {v5}, Landroid/webkit/WebBackForwardList;->getCurrentIndex()I

    move-result v0

    .line 2237
    .local v0, currentIndex:I
    invoke-virtual {v5}, Landroid/webkit/WebBackForwardList;->getSize()I

    move-result v6

    .line 2240
    .local v6, size:I
    if-ltz v0, :cond_17

    if-ge v0, v6, :cond_17

    if-nez v6, :cond_19

    :cond_17
    move-object v5, v7

    .line 2241
    goto :goto_4

    .line 2243
    :cond_19
    const-string v8, "index"

    invoke-virtual {p1, v8, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2247
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 2248
    .local v2, history:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    const/4 v3, 0x0

    .local v3, i:I
    :goto_24
    if-ge v3, v6, :cond_45

    .line 2249
    invoke-virtual {v5, v3}, Landroid/webkit/WebBackForwardList;->getItemAtIndex(I)Landroid/webkit/WebHistoryItem;

    move-result-object v4

    .line 2250
    .local v4, item:Landroid/webkit/WebHistoryItem;
    if-nez v4, :cond_37

    .line 2253
    const-string/jumbo v8, "webview"

    const-string/jumbo v9, "saveState: Unexpected null history item."

    invoke-static {v8, v9}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move-object v5, v7

    .line 2254
    goto :goto_4

    .line 2256
    :cond_37
    invoke-virtual {v4}, Landroid/webkit/WebHistoryItem;->getFlattenedData()[B

    move-result-object v1

    .line 2257
    .local v1, data:[B
    if-nez v1, :cond_3f

    move-object v5, v7

    .line 2261
    goto :goto_4

    .line 2263
    :cond_3f
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2248
    add-int/lit8 v3, v3, 0x1

    goto :goto_24

    .line 2265
    .end local v1           #data:[B
    .end local v4           #item:Landroid/webkit/WebHistoryItem;
    :cond_45
    const-string v7, "history"

    invoke-virtual {p1, v7, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 2266
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mCertificate:Landroid/net/http/SslCertificate;

    if-eqz v7, :cond_59

    .line 2267
    const-string v7, "certificate"

    iget-object v8, p0, Landroid/webkit/WebViewClassic;->mCertificate:Landroid/net/http/SslCertificate;

    invoke-static {v8}, Landroid/net/http/SslCertificate;->saveState(Landroid/net/http/SslCertificate;)Landroid/os/Bundle;

    move-result-object v8

    invoke-virtual {p1, v7, v8}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 2270
    :cond_59
    const-string/jumbo v7, "privateBrowsingEnabled"

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->isPrivateBrowsingEnabled()Z

    move-result v8

    invoke-virtual {p1, v7, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 2271
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v7, p1}, Landroid/webkit/ZoomManager;->saveZoomState(Landroid/os/Bundle;)V

    goto :goto_4
.end method

.method public saveViewState(Ljava/io/OutputStream;Landroid/webkit/ValueCallback;)V
    .registers 6
    .parameter "stream"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/OutputStream;",
            "Landroid/webkit/ValueCallback",
            "<",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 2389
    .local p2, callback:Landroid/webkit/ValueCallback;,"Landroid/webkit/ValueCallback<Ljava/lang/Boolean;>;"
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-nez v0, :cond_d

    .line 2390
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-interface {p2, v0}, Landroid/webkit/ValueCallback;->onReceiveValue(Ljava/lang/Object;)V

    .line 2395
    :goto_c
    return-void

    .line 2393
    :cond_d
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0xe1

    new-instance v2, Landroid/webkit/WebViewCore$SaveViewStateRequest;

    invoke-direct {v2, p1, p2}, Landroid/webkit/WebViewCore$SaveViewStateRequest;-><init>(Ljava/io/OutputStream;Landroid/webkit/ValueCallback;)V

    invoke-virtual {v0, v1, v2}, Landroid/webkit/WebViewCore;->sendMessageAtFrontOfQueue(ILjava/lang/Object;)V

    goto :goto_c
.end method

.method public saveWebArchive(Ljava/lang/String;)V
    .registers 4
    .parameter "filename"

    .prologue
    .line 2594
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Landroid/webkit/WebViewClassic;->saveWebArchiveImpl(Ljava/lang/String;ZLandroid/webkit/ValueCallback;)V

    .line 2595
    return-void
.end method

.method public saveWebArchive(Ljava/lang/String;ZLandroid/webkit/ValueCallback;)V
    .registers 4
    .parameter "basename"
    .parameter "autoname"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z",
            "Landroid/webkit/ValueCallback",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 2615
    .local p3, callback:Landroid/webkit/ValueCallback;,"Landroid/webkit/ValueCallback<Ljava/lang/String;>;"
    invoke-direct {p0, p1, p2, p3}, Landroid/webkit/WebViewClassic;->saveWebArchiveImpl(Ljava/lang/String;ZLandroid/webkit/ValueCallback;)V

    .line 2616
    return-void
.end method

.method public selectAll()V
    .registers 3

    .prologue
    .line 5376
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0xd7

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 5377
    return-void
.end method

.method public selectText()Z
    .registers 5

    .prologue
    .line 4422
    iget v2, p0, Landroid/webkit/WebViewClassic;->mLastTouchX:I

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->viewToContentX(I)I

    move-result v0

    .line 4423
    .local v0, x:I
    iget v2, p0, Landroid/webkit/WebViewClassic;->mLastTouchY:I

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->viewToContentY(I)I

    move-result v1

    .line 4424
    .local v1, y:I
    invoke-virtual {p0, v0, v1}, Landroid/webkit/WebViewClassic;->selectText(II)Z

    move-result v2

    return v2
.end method

.method selectText(II)Z
    .registers 5
    .parameter "x"
    .parameter "y"

    .prologue
    .line 4431
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-nez v0, :cond_6

    .line 4432
    const/4 v0, 0x0

    .line 4435
    :goto_5
    return v0

    .line 4434
    :cond_6
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0xd6

    invoke-virtual {v0, v1, p1, p2}, Landroid/webkit/WebViewCore;->sendMessage(III)V

    .line 4435
    const/4 v0, 0x1

    goto :goto_5
.end method

.method selectionDone()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 5383
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mSelectingText:Z

    if-eqz v0, :cond_17

    .line 5384
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->hideFloatView()V

    .line 5385
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->hidePasteButton()V

    .line 5386
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->endSelectingText()V

    .line 5390
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 5391
    iput v1, p0, Landroid/webkit/WebViewClassic;->mAutoScrollX:I

    .line 5392
    iput v1, p0, Landroid/webkit/WebViewClassic;->mAutoScrollY:I

    .line 5393
    iput-boolean v1, p0, Landroid/webkit/WebViewClassic;->mSentAutoScrollMessage:Z

    .line 5395
    :cond_17
    return-void
.end method

.method sendBatchableInputMessage(IIILjava/lang/Object;)V
    .registers 7
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"
    .parameter "obj"

    .prologue
    .line 8173
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-nez v1, :cond_5

    .line 8182
    :goto_4
    return-void

    .line 8176
    :cond_5
    const/4 v1, 0x0

    invoke-static {v1, p1, p2, p3, p4}, Landroid/os/Message;->obtain(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 8177
    .local v0, message:Landroid/os/Message;
    iget-boolean v1, p0, Landroid/webkit/WebViewClassic;->mIsBatchingTextChanges:Z

    if-eqz v1, :cond_14

    .line 8178
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mBatchedTextChanges:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 8180
    :cond_14
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v1, v0}, Landroid/webkit/WebViewCore;->sendMessage(Landroid/os/Message;)V

    goto :goto_4
.end method

.method sendOurVisibleRect()Landroid/graphics/Rect;
    .registers 5

    .prologue
    const/16 v3, 0x6b

    .line 3118
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->isPreventingWebkitUpdates()Z

    move-result v0

    if-eqz v0, :cond_d

    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mLastVisibleRectSent:Landroid/graphics/Rect;

    .line 3146
    :goto_c
    return-object v0

    .line 3119
    :cond_d
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mVisibleRect:Landroid/graphics/Rect;

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->calcOurContentVisibleRect(Landroid/graphics/Rect;)V

    .line 3121
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mVisibleRect:Landroid/graphics/Rect;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mLastVisibleRectSent:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/graphics/Rect;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4b

    .line 3122
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mBlockWebkitViewMessages:Z

    if-nez v0, :cond_3e

    .line 3123
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScrollOffset:Landroid/graphics/Point;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mVisibleRect:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->left:I

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mVisibleRect:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->top:I

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Point;->set(II)V

    .line 3124
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v0, v3}, Landroid/webkit/WebViewCore;->removeMessages(I)V

    .line 3125
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mSendScrollEvent:Z

    if-eqz v0, :cond_76

    const/4 v0, 0x1

    :goto_39
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mScrollOffset:Landroid/graphics/Point;

    invoke-virtual {v1, v3, v0, v2}, Landroid/webkit/WebViewCore;->sendMessage(IILjava/lang/Object;)V

    .line 3128
    :cond_3e
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mLastVisibleRectSent:Landroid/graphics/Rect;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mVisibleRect:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 3129
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 3131
    :cond_4b
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mGlobalVisibleRect:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z

    move-result v0

    if-eqz v0, :cond_73

    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mGlobalVisibleRect:Landroid/graphics/Rect;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mLastGlobalRect:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/graphics/Rect;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_73

    .line 3141
    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mBlockWebkitViewMessages:Z

    if-nez v0, :cond_6c

    .line 3142
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x74

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mGlobalVisibleRect:Landroid/graphics/Rect;

    invoke-virtual {v0, v1, v2}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 3144
    :cond_6c
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mLastGlobalRect:Landroid/graphics/Rect;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mGlobalVisibleRect:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 3146
    :cond_73
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mVisibleRect:Landroid/graphics/Rect;

    goto :goto_c

    .line 3125
    :cond_76
    const/4 v0, 0x0

    goto :goto_39
.end method

.method sendViewSizeZoom(Z)Z
    .registers 13
    .parameter "force"

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 3201
    iget-boolean v9, p0, Landroid/webkit/WebViewClassic;->mBlockWebkitViewMessages:Z

    if-eqz v9, :cond_7

    .line 3247
    :cond_6
    :goto_6
    return v7

    .line 3202
    :cond_7
    iget-object v9, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v9}, Landroid/webkit/ZoomManager;->isPreventingWebkitUpdates()Z

    move-result v9

    if-nez v9, :cond_6

    .line 3204
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getViewWidth()I

    move-result v6

    .line 3205
    .local v6, viewWidth:I
    int-to-float v9, v6

    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v10}, Landroid/webkit/ZoomManager;->getInvScale()F

    move-result v10

    mul-float/2addr v9, v10

    invoke-static {v9}, Ljava/lang/Math;->round(F)I

    move-result v4

    .line 3207
    .local v4, newWidth:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getViewHeightWithTitle()I

    move-result v9

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v10

    sub-int v5, v9, v10

    .line 3208
    .local v5, viewHeight:I
    int-to-float v9, v5

    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v10}, Landroid/webkit/ZoomManager;->getInvScale()F

    move-result v10

    mul-float/2addr v9, v10

    invoke-static {v9}, Ljava/lang/Math;->round(F)I

    move-result v3

    .line 3211
    .local v3, newHeight:I
    int-to-float v9, v5

    int-to-float v10, v6

    div-float v2, v9, v10

    .line 3220
    .local v2, heightWidthRatio:F
    iget v9, p0, Landroid/webkit/WebViewClassic;->mLastWidthSent:I

    if-le v4, v9, :cond_43

    iget-boolean v9, p0, Landroid/webkit/WebViewClassic;->mWrapContent:Z

    if-eqz v9, :cond_43

    .line 3221
    const/4 v3, 0x0

    .line 3222
    const/4 v2, 0x0

    .line 3225
    :cond_43
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getViewHeight()I

    move-result v9

    int-to-float v9, v9

    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v10}, Landroid/webkit/ZoomManager;->getInvScale()F

    move-result v10

    mul-float/2addr v9, v10

    invoke-static {v9}, Ljava/lang/Math;->round(F)I

    move-result v0

    .line 3227
    .local v0, actualViewHeight:I
    iget v9, p0, Landroid/webkit/WebViewClassic;->mLastWidthSent:I

    if-ne v4, v9, :cond_61

    iget v9, p0, Landroid/webkit/WebViewClassic;->mLastHeightSent:I

    if-ne v3, v9, :cond_61

    if-nez p1, :cond_61

    iget v9, p0, Landroid/webkit/WebViewClassic;->mLastActualHeightSent:I

    if-eq v0, v9, :cond_6

    .line 3229
    :cond_61
    new-instance v1, Landroid/webkit/WebViewClassic$ViewSizeData;

    invoke-direct {v1}, Landroid/webkit/WebViewClassic$ViewSizeData;-><init>()V

    .line 3230
    .local v1, data:Landroid/webkit/WebViewClassic$ViewSizeData;
    iput v4, v1, Landroid/webkit/WebViewClassic$ViewSizeData;->mWidth:I

    .line 3231
    iput v3, v1, Landroid/webkit/WebViewClassic$ViewSizeData;->mHeight:I

    .line 3232
    iput v2, v1, Landroid/webkit/WebViewClassic$ViewSizeData;->mHeightWidthRatio:F

    .line 3233
    iput v0, v1, Landroid/webkit/WebViewClassic$ViewSizeData;->mActualViewHeight:I

    .line 3234
    int-to-float v9, v6

    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v10}, Landroid/webkit/ZoomManager;->getTextWrapScale()F

    move-result v10

    div-float/2addr v9, v10

    invoke-static {v9}, Ljava/lang/Math;->round(F)I

    move-result v9

    iput v9, v1, Landroid/webkit/WebViewClassic$ViewSizeData;->mTextWrapWidth:I

    .line 3235
    iget-object v9, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v9}, Landroid/webkit/ZoomManager;->getScale()F

    move-result v9

    iput v9, v1, Landroid/webkit/WebViewClassic$ViewSizeData;->mScale:F

    .line 3236
    iget-object v9, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v9}, Landroid/webkit/ZoomManager;->isFixedLengthAnimationInProgress()Z

    move-result v9

    if-eqz v9, :cond_91

    iget-boolean v9, p0, Landroid/webkit/WebViewClassic;->mHeightCanMeasure:Z

    if-nez v9, :cond_91

    move v7, v8

    :cond_91
    iput-boolean v7, v1, Landroid/webkit/WebViewClassic$ViewSizeData;->mIgnoreHeight:Z

    .line 3238
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v7}, Landroid/webkit/ZoomManager;->getDocumentAnchorX()I

    move-result v7

    iput v7, v1, Landroid/webkit/WebViewClassic$ViewSizeData;->mAnchorX:I

    .line 3239
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v7}, Landroid/webkit/ZoomManager;->getDocumentAnchorY()I

    move-result v7

    iput v7, v1, Landroid/webkit/WebViewClassic$ViewSizeData;->mAnchorY:I

    .line 3240
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v9, 0x69

    invoke-virtual {v7, v9, v1}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 3241
    iput v4, p0, Landroid/webkit/WebViewClassic;->mLastWidthSent:I

    .line 3242
    iput v3, p0, Landroid/webkit/WebViewClassic;->mLastHeightSent:I

    .line 3243
    iput v0, p0, Landroid/webkit/WebViewClassic;->mLastActualHeightSent:I

    .line 3244
    iget-object v7, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v7}, Landroid/webkit/ZoomManager;->clearDocumentAnchor()V

    move v7, v8

    .line 3245
    goto/16 :goto_6
.end method

.method setActive(Z)V
    .registers 5
    .parameter "active"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 5513
    if-eqz p1, :cond_1b

    .line 5514
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->hasFocus()Z

    move-result v0

    if-eqz v0, :cond_15

    .line 5517
    iput-boolean v1, p0, Landroid/webkit/WebViewClassic;->mDrawCursorRing:Z

    .line 5518
    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->setFocusControllerActive(Z)V

    .line 5539
    :goto_11
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 5540
    return-void

    .line 5520
    :cond_15
    iput-boolean v2, p0, Landroid/webkit/WebViewClassic;->mDrawCursorRing:Z

    .line 5521
    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->setFocusControllerActive(Z)V

    goto :goto_11

    .line 5524
    :cond_1b
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->isZoomPickerVisible()Z

    move-result v0

    if-nez v0, :cond_25

    .line 5532
    iput-boolean v2, p0, Landroid/webkit/WebViewClassic;->mDrawCursorRing:Z

    .line 5534
    :cond_25
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mKeysPressed:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    .line 5535
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 5536
    const/4 v0, 0x7

    iput v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    .line 5537
    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->setFocusControllerActive(Z)V

    goto :goto_11
.end method

.method public setBackgroundColor(I)V
    .registers 4
    .parameter "color"

    .prologue
    .line 8596
    iput p1, p0, Landroid/webkit/WebViewClassic;->mBackgroundColor:I

    .line 8597
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x7e

    invoke-virtual {v0, v1, p1}, Landroid/webkit/WebViewCore;->sendMessage(II)V

    .line 8598
    return-void
.end method

.method setBaseLayer(IZZ)V
    .registers 11
    .parameter "layer"
    .parameter "showVisualIndicator"
    .parameter "isPictureAfterFirstLayout"

    .prologue
    .line 4454
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v0, :cond_5

    .line 4472
    :cond_4
    :goto_4
    return-void

    .line 4457
    :cond_5
    iget v0, p0, Landroid/webkit/WebViewClassic;->mTouchMode:I

    const/16 v1, 0x9

    if-ne v0, v1, :cond_28

    iget v5, p0, Landroid/webkit/WebViewClassic;->mCurrentScrollingLayerId:I

    .line 4459
    .local v5, scrollingLayer:I
    :goto_d
    iget v1, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    invoke-direct/range {v0 .. v5}, Landroid/webkit/WebViewClassic;->nativeSetBaseLayer(IIZZI)Z

    move-result v6

    .line 4463
    .local v6, queueFull:Z
    if-eqz v6, :cond_2a

    .line 4464
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v0}, Landroid/webkit/WebViewCore;->pauseWebKitDraw()V

    .line 4469
    :goto_1e
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHTML5VideoViewProxy:Landroid/webkit/HTML5VideoViewProxy;

    if-eqz v0, :cond_4

    .line 4470
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mHTML5VideoViewProxy:Landroid/webkit/HTML5VideoViewProxy;

    invoke-virtual {v0, p1}, Landroid/webkit/HTML5VideoViewProxy;->setBaseLayer(I)V

    goto :goto_4

    .line 4457
    .end local v5           #scrollingLayer:I
    .end local v6           #queueFull:Z
    :cond_28
    const/4 v5, 0x0

    goto :goto_d

    .line 4466
    .restart local v5       #scrollingLayer:I
    .restart local v6       #queueFull:Z
    :cond_2a
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-virtual {v0}, Landroid/webkit/WebViewCore;->resumeWebKitDraw()V

    goto :goto_1e
.end method

.method public setCertificate(Landroid/net/http/SslCertificate;)V
    .registers 2
    .parameter "certificate"

    .prologue
    .line 2038
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mCertificate:Landroid/net/http/SslCertificate;

    .line 2039
    return-void
.end method

.method public setDownloadListener(Landroid/webkit/DownloadListener;)V
    .registers 3
    .parameter "listener"

    .prologue
    .line 4051
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v0, p1}, Landroid/webkit/CallbackProxy;->setDownloadListener(Landroid/webkit/DownloadListener;)V

    .line 4052
    return-void
.end method

.method public setFindListener(Landroid/webkit/WebView$FindListener;)V
    .registers 2
    .parameter "listener"

    .prologue
    .line 3587
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mFindListener:Landroid/webkit/WebView$FindListener;

    .line 3588
    return-void
.end method

.method setFocusControllerActive(Z)V
    .registers 6
    .parameter "active"

    .prologue
    const/4 v1, 0x0

    .line 5571
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-nez v0, :cond_6

    .line 5578
    :cond_5
    :goto_5
    return-void

    .line 5572
    :cond_6
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v3, 0x8e

    if-eqz p1, :cond_21

    const/4 v0, 0x1

    :goto_d
    invoke-virtual {v2, v3, v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(III)V

    .line 5574
    if-eqz p1, :cond_5

    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mListBoxMessage:Landroid/os/Message;

    if-eqz v0, :cond_5

    .line 5575
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mListBoxMessage:Landroid/os/Message;

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(Landroid/os/Message;)V

    .line 5576
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mListBoxMessage:Landroid/os/Message;

    goto :goto_5

    :cond_21
    move v0, v1

    .line 5572
    goto :goto_d
.end method

.method public setFrame(IIII)Z
    .registers 7
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    .line 5648
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v1, p1, p2, p3, p4}, Landroid/webkit/WebView$PrivateAccess;->super_setFrame(IIII)Z

    move-result v0

    .line 5649
    .local v0, changed:Z
    if-nez v0, :cond_10

    iget-boolean v1, p0, Landroid/webkit/WebViewClassic;->mHeightCanMeasure:Z

    if-eqz v1, :cond_10

    .line 5656
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Landroid/webkit/WebViewClassic;->sendViewSizeZoom(Z)Z

    .line 5658
    :cond_10
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->updateRectsForGL()V

    .line 5659
    return v0
.end method

.method public setHTML5VideoViewProxy(Landroid/webkit/HTML5VideoViewProxy;)V
    .registers 2
    .parameter "proxy"

    .prologue
    .line 8614
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mHTML5VideoViewProxy:Landroid/webkit/HTML5VideoViewProxy;

    .line 8615
    return-void
.end method

.method public setHorizontalScrollbarOverlay(Z)V
    .registers 2
    .parameter "overlay"

    .prologue
    .line 1916
    iput-boolean p1, p0, Landroid/webkit/WebViewClassic;->mOverlayHorizontalScrollbar:Z

    .line 1917
    return-void
.end method

.method public setHttpAuthUsernamePassword(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 6
    .parameter "host"
    .parameter "realm"
    .parameter "username"
    .parameter "password"

    .prologue
    .line 2059
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mDatabase:Landroid/webkit/WebViewDatabaseClassic;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/webkit/WebViewDatabaseClassic;->setHttpAuthUsernamePassword(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2060
    return-void
.end method

.method public setInitialScale(I)V
    .registers 3
    .parameter "scaleInPercent"

    .prologue
    .line 2840
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0, p1}, Landroid/webkit/ZoomManager;->setInitialScaleInPercent(I)V

    .line 2841
    return-void
.end method

.method public setJsFlags(Ljava/lang/String;)V
    .registers 4
    .parameter "flags"

    .prologue
    .line 2203
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0xae

    invoke-virtual {v0, v1, p1}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 2204
    return-void
.end method

.method public setLayerType(ILandroid/graphics/Paint;)V
    .registers 3
    .parameter "layerType"
    .parameter "paint"

    .prologue
    .line 8662
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->updateHwAccelerated()V

    .line 8663
    return-void
.end method

.method public setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    .registers 4
    .parameter "params"

    .prologue
    .line 4377
    iget v0, p1, Landroid/view/ViewGroup$LayoutParams;->height:I

    const/4 v1, -0x2

    if-ne v0, v1, :cond_8

    .line 4378
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mWrapContent:Z

    .line 4380
    :cond_8
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView$PrivateAccess;->super_setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 4381
    return-void
.end method

.method public setMapTrackballToArrowKeys(Z)V
    .registers 2
    .parameter "setMap"

    .prologue
    .line 6623
    iput-boolean p1, p0, Landroid/webkit/WebViewClassic;->mMapTrackballToArrowKeys:Z

    .line 6624
    return-void
.end method

.method public setMockDeviceOrientation(ZDZDZD)V
    .registers 20
    .parameter "canProvideAlpha"
    .parameter "alpha"
    .parameter "canProvideBeta"
    .parameter "beta"
    .parameter "canProvideGamma"
    .parameter "gamma"

    .prologue
    .line 4984
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    move v1, p1

    move-wide v2, p2

    move v4, p4

    move-wide v5, p5

    move/from16 v7, p7

    move-wide/from16 v8, p8

    invoke-virtual/range {v0 .. v9}, Landroid/webkit/WebViewCore;->setMockDeviceOrientation(ZDZDZD)V

    .line 4986
    return-void
.end method

.method public setNetworkAvailable(Z)V
    .registers 6
    .parameter "networkUp"

    .prologue
    const/4 v1, 0x0

    .line 2211
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v3, 0x77

    if-eqz p1, :cond_c

    const/4 v0, 0x1

    :goto_8
    invoke-virtual {v2, v3, v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(III)V

    .line 2213
    return-void

    :cond_c
    move v0, v1

    .line 2211
    goto :goto_8
.end method

.method public setNetworkType(Ljava/lang/String;Ljava/lang/String;)V
    .registers 6
    .parameter "type"
    .parameter "subtype"

    .prologue
    .line 2219
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 2220
    .local v0, map:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v1, "type"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2221
    const-string/jumbo v1, "subtype"

    invoke-interface {v0, v1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2222
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v2, 0xb7

    invoke-virtual {v1, v2, v0}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 2223
    return-void
.end method

.method setNewPicture(Landroid/webkit/WebViewCore$DrawData;Z)V
    .registers 16
    .parameter "draw"
    .parameter "updateBaseLayer"

    .prologue
    const/4 v9, 0x1

    const/4 v10, 0x0

    .line 8018
    iget v11, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-nez v11, :cond_15

    .line 8019
    iget-object v9, p0, Landroid/webkit/WebViewClassic;->mDelaySetPicture:Landroid/webkit/WebViewCore$DrawData;

    if-eqz v9, :cond_12

    .line 8020
    new-instance v9, Ljava/lang/IllegalStateException;

    const-string v10, "Tried to setNewPicture with a delay picture already set! (memory leak)"

    invoke-direct {v9, v10}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 8024
    :cond_12
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mDelaySetPicture:Landroid/webkit/WebViewCore$DrawData;

    .line 8099
    :cond_14
    :goto_14
    return-void

    .line 8027
    :cond_15
    iget-object v8, p1, Landroid/webkit/WebViewCore$DrawData;->mViewState:Landroid/webkit/WebViewCore$ViewState;

    .line 8028
    .local v8, viewState:Landroid/webkit/WebViewCore$ViewState;
    if-eqz v8, :cond_cf

    move v2, v9

    .line 8030
    .local v2, isPictureAfterFirstLayout:Z
    :goto_1a
    if-eqz p2, :cond_29

    .line 8031
    iget v11, p1, Landroid/webkit/WebViewCore$DrawData;->mBaseLayer:I

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v12

    invoke-virtual {v12}, Landroid/webkit/WebSettingsClassic;->getShowVisualIndicator()Z

    move-result v12

    invoke-virtual {p0, v11, v12, v2}, Landroid/webkit/WebViewClassic;->setBaseLayer(IZZ)V

    .line 8035
    :cond_29
    iget-object v7, p1, Landroid/webkit/WebViewCore$DrawData;->mViewSize:Landroid/graphics/Point;

    .line 8040
    .local v7, viewSize:Landroid/graphics/Point;
    iget v11, v7, Landroid/graphics/Point;->x:I

    iget v12, p0, Landroid/webkit/WebViewClassic;->mLastWidthSent:I

    if-ne v11, v12, :cond_d2

    iget v11, v7, Landroid/graphics/Point;->y:I

    iget v12, p0, Landroid/webkit/WebViewClassic;->mLastHeightSent:I

    if-ne v11, v12, :cond_d2

    move v5, v9

    .line 8045
    .local v5, updateLayout:Z
    :goto_38
    iput-boolean v10, p0, Landroid/webkit/WebViewClassic;->mSendScrollEvent:Z

    .line 8046
    iget-object v11, p1, Landroid/webkit/WebViewCore$DrawData;->mContentSize:Landroid/graphics/Point;

    iget v11, v11, Landroid/graphics/Point;->x:I

    iget-object v12, p1, Landroid/webkit/WebViewCore$DrawData;->mContentSize:Landroid/graphics/Point;

    iget v12, v12, Landroid/graphics/Point;->y:I

    invoke-direct {p0, v11, v12, v5}, Landroid/webkit/WebViewClassic;->recordNewContentSize(IIZ)V

    .line 8048
    if-eqz v2, :cond_62

    .line 8050
    iput v10, p0, Landroid/webkit/WebViewClassic;->mLastWidthSent:I

    .line 8051
    iget-object v11, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v11, p1}, Landroid/webkit/ZoomManager;->onFirstLayout(Landroid/webkit/WebViewCore$DrawData;)V

    .line 8052
    iget-boolean v11, v8, Landroid/webkit/WebViewCore$ViewState;->mShouldStartScrolledRight:Z

    if-eqz v11, :cond_d5

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getContentWidth()I

    move-result v3

    .line 8054
    .local v3, scrollX:I
    :goto_56
    iget v4, v8, Landroid/webkit/WebViewCore$ViewState;->mScrollY:I

    .line 8055
    .local v4, scrollY:I
    invoke-direct {p0, v3, v4, v10}, Landroid/webkit/WebViewClassic;->contentScrollTo(IIZ)V

    .line 8056
    iget-boolean v11, p0, Landroid/webkit/WebViewClassic;->mDrawHistory:Z

    if-nez v11, :cond_62

    .line 8058
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->hideSoftKeyboard()V

    .line 8061
    .end local v3           #scrollX:I
    .end local v4           #scrollY:I
    :cond_62
    iput-boolean v9, p0, Landroid/webkit/WebViewClassic;->mSendScrollEvent:Z

    .line 8063
    const/4 v1, 0x0

    .line 8064
    .local v1, functor:I
    move v0, v2

    .line 8065
    .local v0, forceInval:Z
    iget-object v11, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v11}, Landroid/webkit/WebView;->getViewRootImpl()Landroid/view/ViewRootImpl;

    move-result-object v6

    .line 8066
    .local v6, viewRoot:Landroid/view/ViewRootImpl;
    iget-object v11, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v11}, Landroid/webkit/WebView;->isHardwareAccelerated()Z

    move-result v11

    if-eqz v11, :cond_86

    if-eqz v6, :cond_86

    .line 8067
    iget v11, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    invoke-direct {p0, v11}, Landroid/webkit/WebViewClassic;->nativeGetDrawGLFunction(I)I

    move-result v1

    .line 8068
    if-eqz v1, :cond_86

    .line 8070
    invoke-virtual {v6, v1}, Landroid/view/ViewRootImpl;->attachFunctor(I)Z

    move-result v11

    if-nez v11, :cond_85

    move v10, v9

    :cond_85
    or-int/2addr v0, v10

    .line 8074
    :cond_86
    if-eqz v1, :cond_92

    if-nez v0, :cond_92

    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v10}, Landroid/webkit/WebView;->getLayerType()I

    move-result v10

    if-eqz v10, :cond_97

    .line 8079
    :cond_92
    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v10}, Landroid/webkit/WebView;->invalidate()V

    .line 8083
    :cond_97
    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v10, p1}, Landroid/webkit/ZoomManager;->onNewPicture(Landroid/webkit/WebViewCore$DrawData;)Z

    move-result v10

    if-eqz v10, :cond_a2

    .line 8084
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 8086
    :cond_a2
    if-eqz v2, :cond_a9

    .line 8087
    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mViewManager:Landroid/webkit/ViewManager;

    invoke-virtual {v10}, Landroid/webkit/ViewManager;->postReadyToDrawAll()V

    .line 8089
    :cond_a9
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->scrollEditWithCursor()V

    .line 8091
    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mPictureListener:Landroid/webkit/WebView$PictureListener;

    if-eqz v10, :cond_14

    .line 8092
    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v10}, Landroid/webkit/WebView;->isHardwareAccelerated()Z

    move-result v10

    if-eqz v10, :cond_c0

    iget-object v10, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v10}, Landroid/webkit/WebView;->getLayerType()I

    move-result v10

    if-ne v10, v9, :cond_14

    .line 8096
    :cond_c0
    iget-object v9, p0, Landroid/webkit/WebViewClassic;->mPictureListener:Landroid/webkit/WebView$PictureListener;

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getWebView()Landroid/webkit/WebView;

    move-result-object v10

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->capturePicture()Landroid/graphics/Picture;

    move-result-object v11

    invoke-interface {v9, v10, v11}, Landroid/webkit/WebView$PictureListener;->onNewPicture(Landroid/webkit/WebView;Landroid/graphics/Picture;)V

    goto/16 :goto_14

    .end local v0           #forceInval:Z
    .end local v1           #functor:I
    .end local v2           #isPictureAfterFirstLayout:Z
    .end local v5           #updateLayout:Z
    .end local v6           #viewRoot:Landroid/view/ViewRootImpl;
    .end local v7           #viewSize:Landroid/graphics/Point;
    :cond_cf
    move v2, v10

    .line 8028
    goto/16 :goto_1a

    .restart local v2       #isPictureAfterFirstLayout:Z
    .restart local v7       #viewSize:Landroid/graphics/Point;
    :cond_d2
    move v5, v10

    .line 8040
    goto/16 :goto_38

    .line 8052
    .restart local v5       #updateLayout:Z
    :cond_d5
    iget v3, v8, Landroid/webkit/WebViewCore$ViewState;->mScrollX:I

    goto/16 :goto_56
.end method

.method public setOverScrollMode(I)V
    .registers 3
    .parameter "mode"

    .prologue
    .line 1801
    const/4 v0, 0x2

    if-eq p1, v0, :cond_f

    .line 1802
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mOverScrollGlow:Landroid/webkit/OverScrollGlow;

    if-nez v0, :cond_e

    .line 1803
    new-instance v0, Landroid/webkit/OverScrollGlow;

    invoke-direct {v0, p0}, Landroid/webkit/OverScrollGlow;-><init>(Landroid/webkit/WebViewClassic;)V

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mOverScrollGlow:Landroid/webkit/OverScrollGlow;

    .line 1808
    :cond_e
    :goto_e
    return-void

    .line 1806
    :cond_f
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mOverScrollGlow:Landroid/webkit/OverScrollGlow;

    goto :goto_e
.end method

.method public setPictureListener(Landroid/webkit/WebView$PictureListener;)V
    .registers 2
    .parameter "listener"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 4095
    iput-object p1, p0, Landroid/webkit/WebViewClassic;->mPictureListener:Landroid/webkit/WebView$PictureListener;

    .line 4096
    return-void
.end method

.method public setScrollBarStyle(I)V
    .registers 3
    .parameter "style"

    .prologue
    .line 1903
    const/high16 v0, 0x100

    if-eq p1, v0, :cond_8

    const/high16 v0, 0x300

    if-ne p1, v0, :cond_e

    .line 1905
    :cond_8
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mOverlayVerticalScrollbar:Z

    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mOverlayHorizontalScrollbar:Z

    .line 1909
    :goto_d
    return-void

    .line 1907
    :cond_e
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mOverlayVerticalScrollbar:Z

    iput-boolean v0, p0, Landroid/webkit/WebViewClassic;->mOverlayHorizontalScrollbar:Z

    goto :goto_d
.end method

.method setScrollXRaw(I)V
    .registers 3
    .parameter "mScrollX"

    .prologue
    .line 1475
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView$PrivateAccess;->setScrollXRaw(I)V

    .line 1476
    return-void
.end method

.method setScrollYRaw(I)V
    .registers 3
    .parameter "mScrollY"

    .prologue
    .line 1479
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView$PrivateAccess;->setScrollYRaw(I)V

    .line 1480
    return-void
.end method

.method setSelection(II)V
    .registers 5
    .parameter "start"
    .parameter "end"

    .prologue
    .line 4802
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-eqz v0, :cond_b

    .line 4803
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x71

    invoke-virtual {v0, v1, p1, p2}, Landroid/webkit/WebViewCore;->sendMessage(III)V

    .line 4805
    :cond_b
    return-void
.end method

.method public setTouchInterval(I)V
    .registers 2
    .parameter "interval"

    .prologue
    .line 8624
    iput p1, p0, Landroid/webkit/WebViewClassic;->mCurrentTouchInterval:I

    .line 8625
    return-void
.end method

.method public setUseMockDeviceOrientation()V
    .registers 3

    .prologue
    .line 4974
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0xbf

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 4975
    return-void
.end method

.method public setVerticalScrollbarOverlay(Z)V
    .registers 2
    .parameter "overlay"

    .prologue
    .line 1924
    iput-boolean p1, p0, Landroid/webkit/WebViewClassic;->mOverlayVerticalScrollbar:Z

    .line 1925
    return-void
.end method

.method public setWebBackForwardListClient(Landroid/webkit/WebBackForwardListClient;)V
    .registers 3
    .parameter "client"

    .prologue
    .line 4079
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v0, p1}, Landroid/webkit/CallbackProxy;->setWebBackForwardListClient(Landroid/webkit/WebBackForwardListClient;)V

    .line 4080
    return-void
.end method

.method public setWebChromeClient(Landroid/webkit/WebChromeClient;)V
    .registers 3
    .parameter "client"

    .prologue
    .line 4059
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v0, p1}, Landroid/webkit/CallbackProxy;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 4060
    return-void
.end method

.method public setWebViewClient(Landroid/webkit/WebViewClient;)V
    .registers 3
    .parameter "client"

    .prologue
    .line 4033
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v0, p1}, Landroid/webkit/CallbackProxy;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 4034
    return-void
.end method

.method public shouldDelayChildPressedState()Z
    .registers 2

    .prologue
    .line 1701
    const/4 v0, 0x1

    return v0
.end method

.method public showFindDialog(Ljava/lang/String;Z)Z
    .registers 6
    .parameter "text"
    .parameter "showIme"

    .prologue
    const/4 v1, 0x1

    .line 3648
    new-instance v0, Landroid/webkit/FindActionModeCallback;

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;

    invoke-direct {v0, v2}, Landroid/webkit/FindActionModeCallback;-><init>(Landroid/content/Context;)V

    .line 3649
    .local v0, callback:Landroid/webkit/FindActionModeCallback;
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    if-eqz v2, :cond_18

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2, v0}, Landroid/webkit/WebView;->startActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    move-result-object v2

    if-nez v2, :cond_1a

    .line 3651
    :cond_18
    const/4 v1, 0x0

    .line 3671
    :cond_19
    :goto_19
    return v1

    .line 3653
    :cond_1a
    const/4 v2, -0x1

    iput v2, p0, Landroid/webkit/WebViewClassic;->mCachedOverlappingActionModeHeight:I

    .line 3654
    iput-object v0, p0, Landroid/webkit/WebViewClassic;->mFindCallback:Landroid/webkit/FindActionModeCallback;

    .line 3655
    invoke-direct {p0, v1}, Landroid/webkit/WebViewClassic;->setFindIsUp(Z)V

    .line 3656
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mFindCallback:Landroid/webkit/FindActionModeCallback;

    invoke-virtual {v2, p0}, Landroid/webkit/FindActionModeCallback;->setWebView(Landroid/webkit/WebViewClassic;)V

    .line 3657
    if-eqz p2, :cond_42

    .line 3658
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mFindCallback:Landroid/webkit/FindActionModeCallback;

    invoke-virtual {v2}, Landroid/webkit/FindActionModeCallback;->showSoftInput()V

    .line 3664
    :cond_2e
    if-nez p1, :cond_35

    .line 3665
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mFindRequest:Landroid/webkit/WebViewCore$FindAllRequest;

    if-nez v2, :cond_4f

    const/4 p1, 0x0

    .line 3667
    :cond_35
    :goto_35
    if-eqz p1, :cond_19

    .line 3668
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mFindCallback:Landroid/webkit/FindActionModeCallback;

    invoke-virtual {v2, p1}, Landroid/webkit/FindActionModeCallback;->setText(Ljava/lang/String;)V

    .line 3669
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mFindCallback:Landroid/webkit/FindActionModeCallback;

    invoke-virtual {v2}, Landroid/webkit/FindActionModeCallback;->findAll()V

    goto :goto_19

    .line 3659
    :cond_42
    if-eqz p1, :cond_2e

    .line 3660
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mFindCallback:Landroid/webkit/FindActionModeCallback;

    invoke-virtual {v2, p1}, Landroid/webkit/FindActionModeCallback;->setText(Ljava/lang/String;)V

    .line 3661
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mFindCallback:Landroid/webkit/FindActionModeCallback;

    invoke-virtual {v2}, Landroid/webkit/FindActionModeCallback;->findAll()V

    goto :goto_19

    .line 3665
    :cond_4f
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mFindRequest:Landroid/webkit/WebViewCore$FindAllRequest;

    iget-object p1, v2, Landroid/webkit/WebViewCore$FindAllRequest;->mSearchText:Ljava/lang/String;

    goto :goto_35
.end method

.method public stopLoading()V
    .registers 3

    .prologue
    .line 2631
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->switchOutDrawHistory()V

    .line 2632
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0x65

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewCore;->sendMessage(I)V

    .line 2633
    return-void
.end method

.method public stopScroll()V
    .registers 3

    .prologue
    .line 3787
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/OverScroller;->forceFinished(Z)V

    .line 3788
    const/4 v0, 0x0

    iput v0, p0, Landroid/webkit/WebViewClassic;->mLastVelocity:F

    .line 3789
    return-void
.end method

.method switchOutDrawHistory()V
    .registers 6

    .prologue
    .line 4763
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-nez v2, :cond_5

    .line 4778
    :cond_4
    :goto_4
    return-void

    .line 4764
    :cond_5
    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mDrawHistory:Z

    if-eqz v2, :cond_4

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getProgress()I

    move-result v2

    const/16 v3, 0x64

    if-eq v2, v3, :cond_17

    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->nativeHasContent()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 4765
    :cond_17
    const/4 v2, 0x0

    iput-boolean v2, p0, Landroid/webkit/WebViewClassic;->mDrawHistory:Z

    .line 4766
    const/4 v2, 0x0

    iput-object v2, p0, Landroid/webkit/WebViewClassic;->mHistoryPicture:Landroid/graphics/Picture;

    .line 4767
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 4768
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v0

    .line 4769
    .local v0, oldScrollX:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v1

    .line 4770
    .local v1, oldScrollY:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v2

    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->pinLocX(I)I

    move-result v2

    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->setScrollXRaw(I)V

    .line 4771
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v2

    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->pinLocY(I)I

    move-result v2

    invoke-virtual {p0, v2}, Landroid/webkit/WebViewClassic;->setScrollYRaw(I)V

    .line 4772
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v2

    if-ne v0, v2, :cond_4a

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v2

    if-eq v1, v2, :cond_58

    .line 4773
    :cond_4a
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v4

    invoke-virtual {v2, v3, v4, v0, v1}, Landroid/webkit/WebView$PrivateAccess;->onScrollChanged(IIII)V

    goto :goto_4

    .line 4775
    :cond_58
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->sendOurVisibleRect()Landroid/graphics/Rect;

    goto :goto_4
.end method

.method public tileProfilingClear()V
    .registers 1

    .prologue
    .line 8701
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->nativeTileProfilingClear()V

    .line 8702
    return-void
.end method

.method public tileProfilingGetFloat(IILjava/lang/String;)F
    .registers 5
    .parameter "frame"
    .parameter "tile"
    .parameter "key"

    .prologue
    .line 8717
    invoke-direct {p0, p1, p2, p3}, Landroid/webkit/WebViewClassic;->nativeTileProfilingGetFloat(IILjava/lang/String;)F

    move-result v0

    return v0
.end method

.method public tileProfilingGetInt(IILjava/lang/String;)I
    .registers 5
    .parameter "frame"
    .parameter "tile"
    .parameter "key"

    .prologue
    .line 8713
    invoke-direct {p0, p1, p2, p3}, Landroid/webkit/WebViewClassic;->nativeTileProfilingGetInt(IILjava/lang/String;)I

    move-result v0

    return v0
.end method

.method public tileProfilingNumFrames()I
    .registers 2

    .prologue
    .line 8705
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->nativeTileProfilingNumFrames()I

    move-result v0

    return v0
.end method

.method public tileProfilingNumTilesInFrame(I)I
    .registers 3
    .parameter "frame"

    .prologue
    .line 8709
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->nativeTileProfilingNumTilesInFrame(I)I

    move-result v0

    return v0
.end method

.method public tileProfilingStart()V
    .registers 1

    .prologue
    .line 8688
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->nativeTileProfilingStart()V

    .line 8689
    return-void
.end method

.method public tileProfilingStop()F
    .registers 2

    .prologue
    .line 8696
    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->nativeTileProfilingStop()F

    move-result v0

    return v0
.end method

.method updateDefaultZoomDensity(F)V
    .registers 3
    .parameter "density"

    .prologue
    .line 1817
    const/high16 v0, 0x4180

    mul-float/2addr v0, p1

    float-to-int v0, v0

    iput v0, p0, Landroid/webkit/WebViewClassic;->mNavSlop:I

    .line 1818
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0, p1}, Landroid/webkit/ZoomManager;->updateDefaultZoomDensity(F)V

    .line 1819
    return-void
.end method

.method updateDoubleTapZoom(I)V
    .registers 3
    .parameter "doubleTapZoom"

    .prologue
    .line 3254
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0, p1}, Landroid/webkit/ZoomManager;->updateDoubleTapZoom(I)V

    .line 3255
    return-void
.end method

.method updateDrawingState()V
    .registers 3

    .prologue
    const/4 v1, 0x1

    .line 3491
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    if-eqz v0, :cond_9

    iget-boolean v0, p0, Landroid/webkit/WebViewClassic;->mIsPaused:Z

    if-eqz v0, :cond_a

    .line 3499
    :cond_9
    :goto_9
    return-void

    .line 3492
    :cond_a
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getWindowVisibility()I

    move-result v0

    if-eqz v0, :cond_18

    .line 3493
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    invoke-static {v0, v1}, Landroid/webkit/WebViewClassic;->nativeSetPauseDrawing(IZ)V

    goto :goto_9

    .line 3494
    :cond_18
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_26

    .line 3495
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    invoke-static {v0, v1}, Landroid/webkit/WebViewClassic;->nativeSetPauseDrawing(IZ)V

    goto :goto_9

    .line 3497
    :cond_26
    iget v0, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/webkit/WebViewClassic;->nativeSetPauseDrawing(IZ)V

    goto :goto_9
.end method

.method updateMultiTouchSupport(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 1665
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0, p1}, Landroid/webkit/ZoomManager;->updateMultiTouchSupport(Landroid/content/Context;)V

    .line 1666
    return-void
.end method

.method updateRectsForGL()V
    .registers 11

    .prologue
    const/4 v0, 0x0

    .line 5609
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mTempVisibleRect:Landroid/graphics/Rect;

    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mTempVisibleRectOffset:Landroid/graphics/Point;

    invoke-virtual {v1, v2, v3}, Landroid/webkit/WebView;->getGlobalVisibleRect(Landroid/graphics/Rect;Landroid/graphics/Point;)Z

    move-result v9

    .line 5610
    .local v9, visible:Z
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mInvScreenRect:Landroid/graphics/Rect;

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mTempVisibleRect:Landroid/graphics/Rect;

    invoke-virtual {v1, v2}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 5611
    if-eqz v9, :cond_70

    .line 5613
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getRootView()Landroid/view/View;

    move-result-object v6

    .line 5614
    .local v6, rootView:Landroid/view/View;
    invoke-virtual {v6}, Landroid/view/View;->getHeight()I

    move-result v7

    .line 5615
    .local v7, rootViewHeight:I
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mScreenRect:Landroid/graphics/Rect;

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mInvScreenRect:Landroid/graphics/Rect;

    invoke-virtual {v1, v2}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 5616
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mInvScreenRect:Landroid/graphics/Rect;

    iget v8, v1, Landroid/graphics/Rect;->bottom:I

    .line 5617
    .local v8, savedWebViewBottom:I
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mInvScreenRect:Landroid/graphics/Rect;

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mInvScreenRect:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->top:I

    sub-int v2, v7, v2

    invoke-direct {p0}, Landroid/webkit/WebViewClassic;->getVisibleTitleHeightImpl()I

    move-result v3

    sub-int/2addr v2, v3

    iput v2, v1, Landroid/graphics/Rect;->bottom:I

    .line 5618
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mInvScreenRect:Landroid/graphics/Rect;

    sub-int v2, v7, v8

    iput v2, v1, Landroid/graphics/Rect;->top:I

    .line 5619
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/webkit/WebViewClassic;->mIsWebViewVisible:Z

    .line 5624
    .end local v6           #rootView:Landroid/view/View;
    .end local v7           #rootViewHeight:I
    .end local v8           #savedWebViewBottom:I
    :goto_41
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mTempVisibleRect:Landroid/graphics/Rect;

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mTempVisibleRectOffset:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    neg-int v2, v2

    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mTempVisibleRectOffset:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->y:I

    neg-int v3, v3

    invoke-virtual {v1, v2, v3}, Landroid/graphics/Rect;->offset(II)V

    .line 5625
    iget-object v1, p0, Landroid/webkit/WebViewClassic;->mVisibleContentRect:Landroid/graphics/RectF;

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mTempVisibleRect:Landroid/graphics/Rect;

    invoke-direct {p0, v1, v2}, Landroid/webkit/WebViewClassic;->viewToContentVisibleRect(Landroid/graphics/RectF;Landroid/graphics/Rect;)V

    .line 5627
    iget v1, p0, Landroid/webkit/WebViewClassic;->mNativeClass:I

    iget-boolean v2, p0, Landroid/webkit/WebViewClassic;->mIsWebViewVisible:Z

    if-eqz v2, :cond_74

    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mInvScreenRect:Landroid/graphics/Rect;

    :goto_5f
    iget-boolean v3, p0, Landroid/webkit/WebViewClassic;->mIsWebViewVisible:Z

    if-eqz v3, :cond_76

    iget-object v3, p0, Landroid/webkit/WebViewClassic;->mScreenRect:Landroid/graphics/Rect;

    :goto_65
    iget-object v4, p0, Landroid/webkit/WebViewClassic;->mVisibleContentRect:Landroid/graphics/RectF;

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScale()F

    move-result v5

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Landroid/webkit/WebViewClassic;->nativeUpdateDrawGLFunction(ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/RectF;F)V

    .line 5630
    return-void

    .line 5621
    :cond_70
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/webkit/WebViewClassic;->mIsWebViewVisible:Z

    goto :goto_41

    :cond_74
    move-object v2, v0

    .line 5627
    goto :goto_5f

    :cond_76
    move-object v3, v0

    goto :goto_65
.end method

.method updateScrollCoordinates(II)Z
    .registers 8
    .parameter "x"
    .parameter "y"

    .prologue
    .line 6836
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v0

    .line 6837
    .local v0, oldX:I
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v1

    .line 6838
    .local v1, oldY:I
    invoke-virtual {p0, p1}, Landroid/webkit/WebViewClassic;->setScrollXRaw(I)V

    .line 6839
    invoke-virtual {p0, p2}, Landroid/webkit/WebViewClassic;->setScrollYRaw(I)V

    .line 6840
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v2

    if-ne v0, v2, :cond_1a

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v2

    if-eq v1, v2, :cond_29

    .line 6841
    :cond_1a
    iget-object v2, p0, Landroid/webkit/WebViewClassic;->mWebViewPrivate:Landroid/webkit/WebView$PrivateAccess;

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v4

    invoke-virtual {v2, v3, v4, v0, v1}, Landroid/webkit/WebView$PrivateAccess;->onScrollChanged(IIII)V

    .line 6842
    const/4 v2, 0x1

    .line 6844
    :goto_28
    return v2

    :cond_29
    const/4 v2, 0x0

    goto :goto_28
.end method

.method viewToContentX(I)I
    .registers 3
    .parameter "x"

    .prologue
    .line 2970
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic;->viewToContentDimension(I)I

    move-result v0

    return v0
.end method

.method viewToContentY(I)I
    .registers 3
    .parameter "y"

    .prologue
    .line 2979
    invoke-virtual {p0}, Landroid/webkit/WebViewClassic;->getTitleHeight()I

    move-result v0

    sub-int v0, p1, v0

    invoke-direct {p0, v0}, Landroid/webkit/WebViewClassic;->viewToContentDimension(I)I

    move-result v0

    return v0
.end method

.method public zoomIn()Z
    .registers 2

    .prologue
    .line 7010
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->zoomIn()Z

    move-result v0

    return v0
.end method

.method public zoomOut()Z
    .registers 2

    .prologue
    .line 7018
    iget-object v0, p0, Landroid/webkit/WebViewClassic;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v0}, Landroid/webkit/ZoomManager;->zoomOut()Z

    move-result v0

    return v0
.end method
