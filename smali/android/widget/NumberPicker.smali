.class public Landroid/widget/NumberPicker;
.super Landroid/widget/LinearLayout;
.source "NumberPicker.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;,
        Landroid/widget/NumberPicker$BeginSoftInputOnLongPressCommand;,
        Landroid/widget/NumberPicker$CustomEditText;,
        Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;,
        Landroid/widget/NumberPicker$SetSelectionCommand;,
        Landroid/widget/NumberPicker$PressedStateHelper;,
        Landroid/widget/NumberPicker$InputTextFilter;,
        Landroid/widget/NumberPicker$Formatter;,
        Landroid/widget/NumberPicker$OnScrollListener;,
        Landroid/widget/NumberPicker$OnValueChangeListener;
    }
.end annotation


# static fields
.field private static final DEFAULT_LAYOUT_RESOURCE_ID:I = 0x1090078

.field private static final DEFAULT_LONG_PRESS_UPDATE_INTERVAL:J = 0x12cL

.field private static final DIGIT_CHARACTERS:[C = null

.field private static final SELECTOR_ADJUSTMENT_DURATION_MILLIS:I = 0x320

.field private static final SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT:I = 0x8

.field private static final SELECTOR_MIDDLE_ITEM_INDEX:I = 0x1

.field private static final SELECTOR_WHEEL_ITEM_COUNT:I = 0x3

.field private static final SIZE_UNSPECIFIED:I = -0x1

.field private static final SNAP_SCROLL_DURATION:I = 0x12c

.field private static final TOP_AND_BOTTOM_FADING_EDGE_STRENGTH:F = 0.9f

.field public static final TWO_DIGIT_FORMATTER:Landroid/widget/NumberPicker$Formatter; = null

.field private static final UNSCALED_DEFAULT_SELECTION_DIVIDERS_DISTANCE:I = 0x30

.field private static final UNSCALED_DEFAULT_SELECTION_DIVIDER_HEIGHT:I = 0x2


# instance fields
.field private mAccessibilityNodeProvider:Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;

.field private final mAdjustScroller:Landroid/widget/Scroller;

.field private mBeginSoftInputOnLongPressCommand:Landroid/widget/NumberPicker$BeginSoftInputOnLongPressCommand;

.field private mBottomSelectionDividerBottom:I

.field private mChangeCurrentByOneFromLongPressCommand:Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;

.field private final mComputeMaxWidth:Z

.field private mCurrentScrollOffset:I

.field private final mDecrementButton:Landroid/widget/ImageButton;

.field private mDecrementVirtualButtonPressed:Z

.field private mDisplayedValues:[Ljava/lang/String;

.field private final mFlingScroller:Landroid/widget/Scroller;

.field private mFormatter:Landroid/widget/NumberPicker$Formatter;

.field private final mHasSelectorWheel:Z

.field private final mIncrementButton:Landroid/widget/ImageButton;

.field private mIncrementVirtualButtonPressed:Z

.field private mIngonreMoveEvents:Z

.field private mInitialScrollOffset:I

.field private final mInputText:Landroid/widget/EditText;

.field private mLastDownEventTime:J

.field private mLastDownEventY:F

.field private mLastDownOrMoveEventY:F

.field private mLastHoveredChildVirtualViewId:I

.field private mLongPressUpdateInterval:J

.field private final mMaxHeight:I

.field private mMaxValue:I

.field private mMaxWidth:I

.field private mMaximumFlingVelocity:I

.field private final mMinHeight:I

.field private mMinValue:I

.field private final mMinWidth:I

.field private mMinimumFlingVelocity:I

.field private mOnScrollListener:Landroid/widget/NumberPicker$OnScrollListener;

.field private mOnValueChangeListener:Landroid/widget/NumberPicker$OnValueChangeListener;

.field private final mPressedStateHelper:Landroid/widget/NumberPicker$PressedStateHelper;

.field private mPreviousScrollerY:I

.field private mScrollState:I

.field private final mSelectionDivider:Landroid/graphics/drawable/Drawable;

.field private final mSelectionDividerHeight:I

.field private final mSelectionDividersDistance:I

.field private mSelectorElementHeight:I

.field private final mSelectorIndexToStringCache:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mSelectorIndices:[I

.field private mSelectorTextGapHeight:I

.field private final mSelectorWheelPaint:Landroid/graphics/Paint;

.field private mSetSelectionCommand:Landroid/widget/NumberPicker$SetSelectionCommand;

.field private mShowSoftInputOnTap:Z

.field private final mSolidColor:I

.field private final mTextSize:I

.field private mTopSelectionDividerTop:I

.field private mTouchSlop:I

.field private mValue:I

.field private mVelocityTracker:Landroid/view/VelocityTracker;

.field private final mVirtualButtonPressedDrawable:Landroid/graphics/drawable/Drawable;

.field private mWrapSelectorWheel:Z


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 143
    const/16 v0, 0xa

    new-array v0, v0, [C

    fill-array-data v0, :array_12

    sput-object v0, Landroid/widget/NumberPicker;->DIGIT_CHARACTERS:[C

    .line 160
    new-instance v0, Landroid/widget/NumberPicker$1;

    invoke-direct {v0}, Landroid/widget/NumberPicker$1;-><init>()V

    sput-object v0, Landroid/widget/NumberPicker;->TWO_DIGIT_FORMATTER:Landroid/widget/NumberPicker$Formatter;

    return-void

    .line 143
    nop

    :array_12
    .array-data 0x2
        0x30t 0x0t
        0x31t 0x0t
        0x32t 0x0t
        0x33t 0x0t
        0x34t 0x0t
        0x35t 0x0t
        0x36t 0x0t
        0x37t 0x0t
        0x38t 0x0t
        0x39t 0x0t
    .end array-data
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 514
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/widget/NumberPicker;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 515
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 524
    const v0, 0x10103c2

    invoke-direct {p0, p1, p2, v0}, Landroid/widget/NumberPicker;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 525
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 22
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyle"

    .prologue
    .line 535
    invoke-direct/range {p0 .. p3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 268
    const-wide/16 v14, 0x12c

    move-object/from16 v0, p0

    iput-wide v14, v0, Landroid/widget/NumberPicker;->mLongPressUpdateInterval:J

    .line 273
    new-instance v14, Landroid/util/SparseArray;

    invoke-direct {v14}, Landroid/util/SparseArray;-><init>()V

    move-object/from16 v0, p0

    iput-object v14, v0, Landroid/widget/NumberPicker;->mSelectorIndexToStringCache:Landroid/util/SparseArray;

    .line 278
    const/4 v14, 0x3

    new-array v14, v14, [I

    move-object/from16 v0, p0

    iput-object v14, v0, Landroid/widget/NumberPicker;->mSelectorIndices:[I

    .line 298
    const/high16 v14, -0x8000

    move-object/from16 v0, p0

    iput v14, v0, Landroid/widget/NumberPicker;->mInitialScrollOffset:I

    .line 399
    const/4 v14, 0x0

    move-object/from16 v0, p0

    iput v14, v0, Landroid/widget/NumberPicker;->mScrollState:I

    .line 538
    sget-object v14, Lcom/android/internal/R$styleable;->NumberPicker:[I

    const/4 v15, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    move/from16 v2, p3

    invoke-virtual {v0, v1, v14, v2, v15}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v3

    .line 540
    .local v3, attributesArray:Landroid/content/res/TypedArray;
    const/4 v14, 0x1

    const v15, 0x1090078

    invoke-virtual {v3, v14, v15}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v10

    .line 543
    .local v10, layoutResId:I
    const v14, 0x1090078

    if-eq v10, v14, :cond_bd

    const/4 v14, 0x1

    :goto_3f
    move-object/from16 v0, p0

    iput-boolean v14, v0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    .line 545
    const/4 v14, 0x0

    const/4 v15, 0x0

    invoke-virtual {v3, v14, v15}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v14

    move-object/from16 v0, p0

    iput v14, v0, Landroid/widget/NumberPicker;->mSolidColor:I

    .line 547
    const/4 v14, 0x2

    invoke-virtual {v3, v14}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v14

    move-object/from16 v0, p0

    iput-object v14, v0, Landroid/widget/NumberPicker;->mSelectionDivider:Landroid/graphics/drawable/Drawable;

    .line 549
    const/4 v14, 0x1

    const/high16 v15, 0x4000

    invoke-virtual/range {p0 .. p0}, Landroid/widget/NumberPicker;->getResources()Landroid/content/res/Resources;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v16

    invoke-static/range {v14 .. v16}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v14

    float-to-int v8, v14

    .line 552
    .local v8, defSelectionDividerHeight:I
    const/4 v14, 0x3

    invoke-virtual {v3, v14, v8}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v14

    move-object/from16 v0, p0

    iput v14, v0, Landroid/widget/NumberPicker;->mSelectionDividerHeight:I

    .line 555
    const/4 v14, 0x1

    const/high16 v15, 0x4240

    invoke-virtual/range {p0 .. p0}, Landroid/widget/NumberPicker;->getResources()Landroid/content/res/Resources;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v16

    invoke-static/range {v14 .. v16}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v14

    float-to-int v7, v14

    .line 558
    .local v7, defSelectionDividerDistance:I
    const/4 v14, 0x4

    invoke-virtual {v3, v14, v7}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v14

    move-object/from16 v0, p0

    iput v14, v0, Landroid/widget/NumberPicker;->mSelectionDividersDistance:I

    .line 561
    const/4 v14, 0x5

    const/4 v15, -0x1

    invoke-virtual {v3, v14, v15}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v14

    move-object/from16 v0, p0

    iput v14, v0, Landroid/widget/NumberPicker;->mMinHeight:I

    .line 564
    const/4 v14, 0x6

    const/4 v15, -0x1

    invoke-virtual {v3, v14, v15}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v14

    move-object/from16 v0, p0

    iput v14, v0, Landroid/widget/NumberPicker;->mMaxHeight:I

    .line 566
    move-object/from16 v0, p0

    iget v14, v0, Landroid/widget/NumberPicker;->mMinHeight:I

    const/4 v15, -0x1

    if-eq v14, v15, :cond_bf

    move-object/from16 v0, p0

    iget v14, v0, Landroid/widget/NumberPicker;->mMaxHeight:I

    const/4 v15, -0x1

    if-eq v14, v15, :cond_bf

    move-object/from16 v0, p0

    iget v14, v0, Landroid/widget/NumberPicker;->mMinHeight:I

    move-object/from16 v0, p0

    iget v15, v0, Landroid/widget/NumberPicker;->mMaxHeight:I

    if-le v14, v15, :cond_bf

    .line 568
    new-instance v14, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v15, "minHeight > maxHeight"

    invoke-direct {v14, v15}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v14

    .line 543
    .end local v7           #defSelectionDividerDistance:I
    .end local v8           #defSelectionDividerHeight:I
    :cond_bd
    const/4 v14, 0x0

    goto :goto_3f

    .line 571
    .restart local v7       #defSelectionDividerDistance:I
    .restart local v8       #defSelectionDividerHeight:I
    :cond_bf
    const/4 v14, 0x7

    const/4 v15, -0x1

    invoke-virtual {v3, v14, v15}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v14

    move-object/from16 v0, p0

    iput v14, v0, Landroid/widget/NumberPicker;->mMinWidth:I

    .line 574
    const/16 v14, 0x8

    const/4 v15, -0x1

    invoke-virtual {v3, v14, v15}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v14

    move-object/from16 v0, p0

    iput v14, v0, Landroid/widget/NumberPicker;->mMaxWidth:I

    .line 576
    move-object/from16 v0, p0

    iget v14, v0, Landroid/widget/NumberPicker;->mMinWidth:I

    const/4 v15, -0x1

    if-eq v14, v15, :cond_f5

    move-object/from16 v0, p0

    iget v14, v0, Landroid/widget/NumberPicker;->mMaxWidth:I

    const/4 v15, -0x1

    if-eq v14, v15, :cond_f5

    move-object/from16 v0, p0

    iget v14, v0, Landroid/widget/NumberPicker;->mMinWidth:I

    move-object/from16 v0, p0

    iget v15, v0, Landroid/widget/NumberPicker;->mMaxWidth:I

    if-le v14, v15, :cond_f5

    .line 578
    new-instance v14, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v15, "minWidth > maxWidth"

    invoke-direct {v14, v15}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v14

    .line 581
    :cond_f5
    move-object/from16 v0, p0

    iget v14, v0, Landroid/widget/NumberPicker;->mMaxWidth:I

    const/4 v15, -0x1

    if-ne v14, v15, :cond_262

    const/4 v14, 0x1

    :goto_fd
    move-object/from16 v0, p0

    iput-boolean v14, v0, Landroid/widget/NumberPicker;->mComputeMaxWidth:Z

    .line 583
    const/16 v14, 0x9

    invoke-virtual {v3, v14}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v14

    move-object/from16 v0, p0

    iput-object v14, v0, Landroid/widget/NumberPicker;->mVirtualButtonPressedDrawable:Landroid/graphics/drawable/Drawable;

    .line 586
    invoke-virtual {v3}, Landroid/content/res/TypedArray;->recycle()V

    .line 588
    new-instance v14, Landroid/widget/NumberPicker$PressedStateHelper;

    move-object/from16 v0, p0

    invoke-direct {v14, v0}, Landroid/widget/NumberPicker$PressedStateHelper;-><init>(Landroid/widget/NumberPicker;)V

    move-object/from16 v0, p0

    iput-object v14, v0, Landroid/widget/NumberPicker;->mPressedStateHelper:Landroid/widget/NumberPicker$PressedStateHelper;

    .line 595
    move-object/from16 v0, p0

    iget-boolean v14, v0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    if-nez v14, :cond_265

    const/4 v14, 0x1

    :goto_120
    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Landroid/widget/NumberPicker;->setWillNotDraw(Z)V

    .line 597
    invoke-virtual/range {p0 .. p0}, Landroid/widget/NumberPicker;->getContext()Landroid/content/Context;

    move-result-object v14

    const-string v15, "layout_inflater"

    invoke-virtual {v14, v15}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/view/LayoutInflater;

    .line 599
    .local v9, inflater:Landroid/view/LayoutInflater;
    const/4 v14, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v9, v10, v0, v14}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 601
    new-instance v11, Landroid/widget/NumberPicker$2;

    move-object/from16 v0, p0

    invoke-direct {v11, v0}, Landroid/widget/NumberPicker$2;-><init>(Landroid/widget/NumberPicker;)V

    .line 613
    .local v11, onClickListener:Landroid/view/View$OnClickListener;
    new-instance v12, Landroid/widget/NumberPicker$3;

    move-object/from16 v0, p0

    invoke-direct {v12, v0}, Landroid/widget/NumberPicker$3;-><init>(Landroid/widget/NumberPicker;)V

    .line 627
    .local v12, onLongClickListener:Landroid/view/View$OnLongClickListener;
    move-object/from16 v0, p0

    iget-boolean v14, v0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    if-nez v14, :cond_268

    .line 628
    const v14, 0x10202fb

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Landroid/widget/NumberPicker;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/ImageButton;

    move-object/from16 v0, p0

    iput-object v14, v0, Landroid/widget/NumberPicker;->mIncrementButton:Landroid/widget/ImageButton;

    .line 629
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/widget/NumberPicker;->mIncrementButton:Landroid/widget/ImageButton;

    invoke-virtual {v14, v11}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 630
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/widget/NumberPicker;->mIncrementButton:Landroid/widget/ImageButton;

    invoke-virtual {v14, v12}, Landroid/widget/ImageButton;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 636
    :goto_168
    move-object/from16 v0, p0

    iget-boolean v14, v0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    if-nez v14, :cond_26f

    .line 637
    const v14, 0x10202fd

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Landroid/widget/NumberPicker;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/ImageButton;

    move-object/from16 v0, p0

    iput-object v14, v0, Landroid/widget/NumberPicker;->mDecrementButton:Landroid/widget/ImageButton;

    .line 638
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/widget/NumberPicker;->mDecrementButton:Landroid/widget/ImageButton;

    invoke-virtual {v14, v11}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 639
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/widget/NumberPicker;->mDecrementButton:Landroid/widget/ImageButton;

    invoke-virtual {v14, v12}, Landroid/widget/ImageButton;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 645
    :goto_18b
    const v14, 0x10202fc

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Landroid/widget/NumberPicker;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/EditText;

    move-object/from16 v0, p0

    iput-object v14, v0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    .line 646
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    new-instance v15, Landroid/widget/NumberPicker$4;

    move-object/from16 v0, p0

    invoke-direct {v15, v0}, Landroid/widget/NumberPicker$4;-><init>(Landroid/widget/NumberPicker;)V

    invoke-virtual {v14, v15}, Landroid/widget/EditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 656
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    const/4 v15, 0x1

    new-array v15, v15, [Landroid/text/InputFilter;

    const/16 v16, 0x0

    new-instance v17, Landroid/widget/NumberPicker$InputTextFilter;

    invoke-direct/range {v17 .. v18}, Landroid/widget/NumberPicker$InputTextFilter;-><init>(Landroid/widget/NumberPicker;)V

    aput-object v17, v15, v16

    invoke-virtual {v14, v15}, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V

    .line 660
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    const/4 v15, 0x2

    invoke-virtual {v14, v15}, Landroid/widget/EditText;->setRawInputType(I)V

    .line 661
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    const/4 v15, 0x6

    invoke-virtual {v14, v15}, Landroid/widget/EditText;->setImeOptions(I)V

    .line 664
    invoke-static/range {p1 .. p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v6

    .line 665
    .local v6, configuration:Landroid/view/ViewConfiguration;
    invoke-virtual {v6}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v14

    move-object/from16 v0, p0

    iput v14, v0, Landroid/widget/NumberPicker;->mTouchSlop:I

    .line 666
    invoke-virtual {v6}, Landroid/view/ViewConfiguration;->getScaledMinimumFlingVelocity()I

    move-result v14

    move-object/from16 v0, p0

    iput v14, v0, Landroid/widget/NumberPicker;->mMinimumFlingVelocity:I

    .line 667
    invoke-virtual {v6}, Landroid/view/ViewConfiguration;->getScaledMaximumFlingVelocity()I

    move-result v14

    div-int/lit8 v14, v14, 0x8

    move-object/from16 v0, p0

    iput v14, v0, Landroid/widget/NumberPicker;->mMaximumFlingVelocity:I

    .line 669
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v14}, Landroid/widget/EditText;->getTextSize()F

    move-result v14

    float-to-int v14, v14

    move-object/from16 v0, p0

    iput v14, v0, Landroid/widget/NumberPicker;->mTextSize:I

    .line 672
    new-instance v13, Landroid/graphics/Paint;

    invoke-direct {v13}, Landroid/graphics/Paint;-><init>()V

    .line 673
    .local v13, paint:Landroid/graphics/Paint;
    const/4 v14, 0x1

    invoke-virtual {v13, v14}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 674
    sget-object v14, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v13, v14}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 675
    move-object/from16 v0, p0

    iget v14, v0, Landroid/widget/NumberPicker;->mTextSize:I

    int-to-float v14, v14

    invoke-virtual {v13, v14}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 676
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v14}, Landroid/widget/EditText;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v14

    invoke-virtual {v13, v14}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 677
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v14}, Landroid/widget/EditText;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v5

    .line 678
    .local v5, colors:Landroid/content/res/ColorStateList;
    sget-object v14, Landroid/widget/NumberPicker;->ENABLED_STATE_SET:[I

    const/4 v15, -0x1

    invoke-virtual {v5, v14, v15}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v4

    .line 679
    .local v4, color:I
    invoke-virtual {v13, v4}, Landroid/graphics/Paint;->setColor(I)V

    .line 680
    move-object/from16 v0, p0

    iput-object v13, v0, Landroid/widget/NumberPicker;->mSelectorWheelPaint:Landroid/graphics/Paint;

    .line 683
    new-instance v14, Landroid/widget/Scroller;

    invoke-virtual/range {p0 .. p0}, Landroid/widget/NumberPicker;->getContext()Landroid/content/Context;

    move-result-object v15

    const/16 v16, 0x0

    const/16 v17, 0x1

    invoke-direct/range {v14 .. v17}, Landroid/widget/Scroller;-><init>(Landroid/content/Context;Landroid/view/animation/Interpolator;Z)V

    move-object/from16 v0, p0

    iput-object v14, v0, Landroid/widget/NumberPicker;->mFlingScroller:Landroid/widget/Scroller;

    .line 684
    new-instance v14, Landroid/widget/Scroller;

    invoke-virtual/range {p0 .. p0}, Landroid/widget/NumberPicker;->getContext()Landroid/content/Context;

    move-result-object v15

    new-instance v16, Landroid/view/animation/DecelerateInterpolator;

    const/high16 v17, 0x4020

    invoke-direct/range {v16 .. v17}, Landroid/view/animation/DecelerateInterpolator;-><init>(F)V

    invoke-direct/range {v14 .. v16}, Landroid/widget/Scroller;-><init>(Landroid/content/Context;Landroid/view/animation/Interpolator;)V

    move-object/from16 v0, p0

    iput-object v14, v0, Landroid/widget/NumberPicker;->mAdjustScroller:Landroid/widget/Scroller;

    .line 686
    invoke-direct/range {p0 .. p0}, Landroid/widget/NumberPicker;->updateInputTextView()Z

    .line 689
    invoke-virtual/range {p0 .. p0}, Landroid/widget/NumberPicker;->getImportantForAccessibility()I

    move-result v14

    if-nez v14, :cond_261

    .line 690
    const/4 v14, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Landroid/widget/NumberPicker;->setImportantForAccessibility(I)V

    .line 692
    :cond_261
    return-void

    .line 581
    .end local v4           #color:I
    .end local v5           #colors:Landroid/content/res/ColorStateList;
    .end local v6           #configuration:Landroid/view/ViewConfiguration;
    .end local v9           #inflater:Landroid/view/LayoutInflater;
    .end local v11           #onClickListener:Landroid/view/View$OnClickListener;
    .end local v12           #onLongClickListener:Landroid/view/View$OnLongClickListener;
    .end local v13           #paint:Landroid/graphics/Paint;
    :cond_262
    const/4 v14, 0x0

    goto/16 :goto_fd

    .line 595
    :cond_265
    const/4 v14, 0x0

    goto/16 :goto_120

    .line 632
    .restart local v9       #inflater:Landroid/view/LayoutInflater;
    .restart local v11       #onClickListener:Landroid/view/View$OnClickListener;
    .restart local v12       #onLongClickListener:Landroid/view/View$OnLongClickListener;
    :cond_268
    const/4 v14, 0x0

    move-object/from16 v0, p0

    iput-object v14, v0, Landroid/widget/NumberPicker;->mIncrementButton:Landroid/widget/ImageButton;

    goto/16 :goto_168

    .line 641
    :cond_26f
    const/4 v14, 0x0

    move-object/from16 v0, p0

    iput-object v14, v0, Landroid/widget/NumberPicker;->mDecrementButton:Landroid/widget/ImageButton;

    goto/16 :goto_18b
.end method

.method static synthetic access$000(Landroid/widget/NumberPicker;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 88
    invoke-direct {p0}, Landroid/widget/NumberPicker;->hideSoftInput()V

    return-void
.end method

.method static synthetic access$100(Landroid/widget/NumberPicker;)Landroid/widget/EditText;
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget-object v0, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1000(Landroid/widget/NumberPicker;Ljava/lang/String;)I
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 88
    invoke-direct {p0, p1}, Landroid/widget/NumberPicker;->getSelectedPos(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method static synthetic access$1100(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    return v0
.end method

.method static synthetic access$1200(Landroid/widget/NumberPicker;II)V
    .registers 3
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 88
    invoke-direct {p0, p1, p2}, Landroid/widget/NumberPicker;->postSetSelectionCommand(II)V

    return-void
.end method

.method static synthetic access$1300(Landroid/widget/NumberPicker;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget-boolean v0, p0, Landroid/widget/NumberPicker;->mIncrementVirtualButtonPressed:Z

    return v0
.end method

.method static synthetic access$1302(Landroid/widget/NumberPicker;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 88
    iput-boolean p1, p0, Landroid/widget/NumberPicker;->mIncrementVirtualButtonPressed:Z

    return p1
.end method

.method static synthetic access$1380(Landroid/widget/NumberPicker;I)Z
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 88
    iget-boolean v0, p0, Landroid/widget/NumberPicker;->mIncrementVirtualButtonPressed:Z

    xor-int/2addr v0, p1

    int-to-byte v0, v0

    iput-boolean v0, p0, Landroid/widget/NumberPicker;->mIncrementVirtualButtonPressed:Z

    return v0
.end method

.method static synthetic access$1400(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/widget/NumberPicker;->mBottomSelectionDividerBottom:I

    return v0
.end method

.method static synthetic access$1500(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mRight:I

    return v0
.end method

.method static synthetic access$1600(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mBottom:I

    return v0
.end method

.method static synthetic access$1700(Landroid/widget/NumberPicker;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget-boolean v0, p0, Landroid/widget/NumberPicker;->mDecrementVirtualButtonPressed:Z

    return v0
.end method

.method static synthetic access$1702(Landroid/widget/NumberPicker;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 88
    iput-boolean p1, p0, Landroid/widget/NumberPicker;->mDecrementVirtualButtonPressed:Z

    return p1
.end method

.method static synthetic access$1780(Landroid/widget/NumberPicker;I)Z
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 88
    iget-boolean v0, p0, Landroid/widget/NumberPicker;->mDecrementVirtualButtonPressed:Z

    xor-int/2addr v0, p1

    int-to-byte v0, v0

    iput-boolean v0, p0, Landroid/widget/NumberPicker;->mDecrementVirtualButtonPressed:Z

    return v0
.end method

.method static synthetic access$1800(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mRight:I

    return v0
.end method

.method static synthetic access$1900(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/widget/NumberPicker;->mTopSelectionDividerTop:I

    return v0
.end method

.method static synthetic access$200(Landroid/widget/NumberPicker;Z)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 88
    invoke-direct {p0, p1}, Landroid/widget/NumberPicker;->changeValueByOne(Z)V

    return-void
.end method

.method static synthetic access$2000(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mRight:I

    return v0
.end method

.method static synthetic access$2100(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mBottom:I

    return v0
.end method

.method static synthetic access$2200(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mRight:I

    return v0
.end method

.method static synthetic access$2300(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mRight:I

    return v0
.end method

.method static synthetic access$2400(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mBottom:I

    return v0
.end method

.method static synthetic access$2500(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mRight:I

    return v0
.end method

.method static synthetic access$2600(Landroid/widget/NumberPicker;)J
    .registers 3
    .parameter "x0"

    .prologue
    .line 88
    iget-wide v0, p0, Landroid/widget/NumberPicker;->mLongPressUpdateInterval:J

    return-wide v0
.end method

.method static synthetic access$2700(Landroid/widget/NumberPicker;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 88
    invoke-direct {p0}, Landroid/widget/NumberPicker;->showSoftInput()V

    return-void
.end method

.method static synthetic access$2802(Landroid/widget/NumberPicker;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 88
    iput-boolean p1, p0, Landroid/widget/NumberPicker;->mIngonreMoveEvents:Z

    return p1
.end method

.method static synthetic access$2900(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mScrollX:I

    return v0
.end method

.method static synthetic access$300(Landroid/widget/NumberPicker;ZJ)V
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 88
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/NumberPicker;->postChangeCurrentByOneFromLongPress(ZJ)V

    return-void
.end method

.method static synthetic access$3000(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mScrollY:I

    return v0
.end method

.method static synthetic access$3100(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mScrollX:I

    return v0
.end method

.method static synthetic access$3200(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mRight:I

    return v0
.end method

.method static synthetic access$3300(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mLeft:I

    return v0
.end method

.method static synthetic access$3400(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mScrollY:I

    return v0
.end method

.method static synthetic access$3500(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mBottom:I

    return v0
.end method

.method static synthetic access$3600(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mTop:I

    return v0
.end method

.method static synthetic access$3700(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mScrollX:I

    return v0
.end method

.method static synthetic access$3800(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mScrollY:I

    return v0
.end method

.method static synthetic access$3900(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mScrollX:I

    return v0
.end method

.method static synthetic access$400(Landroid/widget/NumberPicker;Landroid/view/View;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 88
    invoke-direct {p0, p1}, Landroid/widget/NumberPicker;->validateInputTextView(Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$4000(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mRight:I

    return v0
.end method

.method static synthetic access$4100(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mLeft:I

    return v0
.end method

.method static synthetic access$4200(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/widget/NumberPicker;->mSelectionDividerHeight:I

    return v0
.end method

.method static synthetic access$4300(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mScrollX:I

    return v0
.end method

.method static synthetic access$4400(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mScrollX:I

    return v0
.end method

.method static synthetic access$4500(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mRight:I

    return v0
.end method

.method static synthetic access$4600(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mLeft:I

    return v0
.end method

.method static synthetic access$4700(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mScrollY:I

    return v0
.end method

.method static synthetic access$4800(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mBottom:I

    return v0
.end method

.method static synthetic access$4900(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mTop:I

    return v0
.end method

.method static synthetic access$5000(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mRight:I

    return v0
.end method

.method static synthetic access$5100(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mBottom:I

    return v0
.end method

.method static synthetic access$5200(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mRight:I

    return v0
.end method

.method static synthetic access$5300(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mBottom:I

    return v0
.end method

.method static synthetic access$5400(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mRight:I

    return v0
.end method

.method static synthetic access$5500(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/view/View;->mRight:I

    return v0
.end method

.method static synthetic access$5600(Landroid/widget/NumberPicker;)Landroid/content/Context;
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget-object v0, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$5700(Landroid/widget/NumberPicker;)Landroid/content/Context;
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget-object v0, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$5800(Landroid/widget/NumberPicker;Landroid/graphics/Rect;)Z
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 88
    invoke-virtual {p0, p1}, Landroid/widget/NumberPicker;->isVisibleToUser(Landroid/graphics/Rect;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$5900(Landroid/widget/NumberPicker;)Landroid/content/Context;
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget-object v0, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$6000(Landroid/widget/NumberPicker;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->isVisibleToUser()Z

    move-result v0

    return v0
.end method

.method static synthetic access$6100(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/widget/NumberPicker;->mValue:I

    return v0
.end method

.method static synthetic access$6200(Landroid/widget/NumberPicker;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget-boolean v0, p0, Landroid/widget/NumberPicker;->mWrapSelectorWheel:Z

    return v0
.end method

.method static synthetic access$6300(Landroid/widget/NumberPicker;I)I
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 88
    invoke-direct {p0, p1}, Landroid/widget/NumberPicker;->getWrappedSelectorIndex(I)I

    move-result v0

    return v0
.end method

.method static synthetic access$6400(Landroid/widget/NumberPicker;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget v0, p0, Landroid/widget/NumberPicker;->mMinValue:I

    return v0
.end method

.method static synthetic access$6500(Landroid/widget/NumberPicker;I)Ljava/lang/String;
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 88
    invoke-direct {p0, p1}, Landroid/widget/NumberPicker;->formatNumber(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$800()[C
    .registers 1

    .prologue
    .line 88
    sget-object v0, Landroid/widget/NumberPicker;->DIGIT_CHARACTERS:[C

    return-object v0
.end method

.method static synthetic access$900(Landroid/widget/NumberPicker;)[Ljava/lang/String;
    .registers 2
    .parameter "x0"

    .prologue
    .line 88
    iget-object v0, p0, Landroid/widget/NumberPicker;->mDisplayedValues:[Ljava/lang/String;

    return-object v0
.end method

.method private changeValueByOne(Z)V
    .registers 8
    .parameter "increment"

    .prologue
    const/16 v5, 0x12c

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 1550
    iget-boolean v0, p0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    if-eqz v0, :cond_37

    .line 1551
    iget-object v0, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    const/4 v2, 0x4

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setVisibility(I)V

    .line 1552
    iget-object v0, p0, Landroid/widget/NumberPicker;->mFlingScroller:Landroid/widget/Scroller;

    invoke-direct {p0, v0}, Landroid/widget/NumberPicker;->moveToFinalScrollerPosition(Landroid/widget/Scroller;)Z

    move-result v0

    if-nez v0, :cond_1b

    .line 1553
    iget-object v0, p0, Landroid/widget/NumberPicker;->mAdjustScroller:Landroid/widget/Scroller;

    invoke-direct {p0, v0}, Landroid/widget/NumberPicker;->moveToFinalScrollerPosition(Landroid/widget/Scroller;)Z

    .line 1555
    :cond_1b
    iput v1, p0, Landroid/widget/NumberPicker;->mPreviousScrollerY:I

    .line 1556
    if-eqz p1, :cond_2d

    .line 1557
    iget-object v0, p0, Landroid/widget/NumberPicker;->mFlingScroller:Landroid/widget/Scroller;

    iget v2, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    neg-int v4, v2

    move v2, v1

    move v3, v1

    invoke-virtual/range {v0 .. v5}, Landroid/widget/Scroller;->startScroll(IIIII)V

    .line 1561
    :goto_29
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->invalidate()V

    .line 1569
    :goto_2c
    return-void

    .line 1559
    :cond_2d
    iget-object v0, p0, Landroid/widget/NumberPicker;->mFlingScroller:Landroid/widget/Scroller;

    iget v4, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    move v2, v1

    move v3, v1

    invoke-virtual/range {v0 .. v5}, Landroid/widget/Scroller;->startScroll(IIIII)V

    goto :goto_29

    .line 1563
    :cond_37
    if-eqz p1, :cond_41

    .line 1564
    iget v0, p0, Landroid/widget/NumberPicker;->mValue:I

    add-int/lit8 v0, v0, 0x1

    invoke-direct {p0, v0, v2}, Landroid/widget/NumberPicker;->setValueInternal(IZ)V

    goto :goto_2c

    .line 1566
    :cond_41
    iget v0, p0, Landroid/widget/NumberPicker;->mValue:I

    add-int/lit8 v0, v0, -0x1

    invoke-direct {p0, v0, v2}, Landroid/widget/NumberPicker;->setValueInternal(IZ)V

    goto :goto_2c
.end method

.method private decrementSelectorIndices([I)V
    .registers 5
    .parameter "selectorIndices"

    .prologue
    .line 1670
    array-length v2, p1

    add-int/lit8 v0, v2, -0x1

    .local v0, i:I
    :goto_3
    if-lez v0, :cond_e

    .line 1671
    add-int/lit8 v2, v0, -0x1

    aget v2, p1, v2

    aput v2, p1, v0

    .line 1670
    add-int/lit8 v0, v0, -0x1

    goto :goto_3

    .line 1673
    :cond_e
    const/4 v2, 0x1

    aget v2, p1, v2

    add-int/lit8 v1, v2, -0x1

    .line 1674
    .local v1, nextScrollSelectorIndex:I
    iget-boolean v2, p0, Landroid/widget/NumberPicker;->mWrapSelectorWheel:Z

    if-eqz v2, :cond_1d

    iget v2, p0, Landroid/widget/NumberPicker;->mMinValue:I

    if-ge v1, v2, :cond_1d

    .line 1675
    iget v1, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    .line 1677
    :cond_1d
    const/4 v2, 0x0

    aput v1, p1, v2

    .line 1678
    invoke-direct {p0, v1}, Landroid/widget/NumberPicker;->ensureCachedScrollSelectorValue(I)V

    .line 1679
    return-void
.end method

.method private ensureCachedScrollSelectorValue(I)V
    .registers 6
    .parameter "selectorIndex"

    .prologue
    .line 1686
    iget-object v0, p0, Landroid/widget/NumberPicker;->mSelectorIndexToStringCache:Landroid/util/SparseArray;

    .line 1687
    .local v0, cache:Landroid/util/SparseArray;,"Landroid/util/SparseArray<Ljava/lang/String;>;"
    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 1688
    .local v2, scrollSelectorValue:Ljava/lang/String;
    if-eqz v2, :cond_b

    .line 1702
    :goto_a
    return-void

    .line 1691
    :cond_b
    iget v3, p0, Landroid/widget/NumberPicker;->mMinValue:I

    if-lt p1, v3, :cond_13

    iget v3, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    if-le p1, v3, :cond_19

    .line 1692
    :cond_13
    const-string v2, ""

    .line 1701
    :goto_15
    invoke-virtual {v0, p1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto :goto_a

    .line 1694
    :cond_19
    iget-object v3, p0, Landroid/widget/NumberPicker;->mDisplayedValues:[Ljava/lang/String;

    if-eqz v3, :cond_26

    .line 1695
    iget v3, p0, Landroid/widget/NumberPicker;->mMinValue:I

    sub-int v1, p1, v3

    .line 1696
    .local v1, displayedValueIndex:I
    iget-object v3, p0, Landroid/widget/NumberPicker;->mDisplayedValues:[Ljava/lang/String;

    aget-object v2, v3, v1

    .line 1697
    goto :goto_15

    .line 1698
    .end local v1           #displayedValueIndex:I
    :cond_26
    invoke-direct {p0, p1}, Landroid/widget/NumberPicker;->formatNumber(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_15
.end method

.method private ensureScrollWheelAdjusted()Z
    .registers 7

    .prologue
    const/4 v1, 0x0

    .line 1936
    iget v0, p0, Landroid/widget/NumberPicker;->mInitialScrollOffset:I

    iget v2, p0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    sub-int v4, v0, v2

    .line 1937
    .local v4, deltaY:I
    if-eqz v4, :cond_28

    .line 1938
    iput v1, p0, Landroid/widget/NumberPicker;->mPreviousScrollerY:I

    .line 1939
    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v0

    iget v2, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    div-int/lit8 v2, v2, 0x2

    if-le v0, v2, :cond_1b

    .line 1940
    if-lez v4, :cond_29

    iget v0, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    neg-int v0, v0

    :goto_1a
    add-int/2addr v4, v0

    .line 1942
    :cond_1b
    iget-object v0, p0, Landroid/widget/NumberPicker;->mAdjustScroller:Landroid/widget/Scroller;

    const/16 v5, 0x320

    move v2, v1

    move v3, v1

    invoke-virtual/range {v0 .. v5}, Landroid/widget/Scroller;->startScroll(IIIII)V

    .line 1943
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->invalidate()V

    .line 1944
    const/4 v1, 0x1

    .line 1946
    :cond_28
    return v1

    .line 1940
    :cond_29
    iget v0, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    goto :goto_1a
.end method

.method private fling(I)V
    .registers 11
    .parameter "velocityY"

    .prologue
    const v8, 0x7fffffff

    const/4 v1, 0x0

    .line 1626
    iput v1, p0, Landroid/widget/NumberPicker;->mPreviousScrollerY:I

    .line 1628
    if-lez p1, :cond_17

    .line 1629
    iget-object v0, p0, Landroid/widget/NumberPicker;->mFlingScroller:Landroid/widget/Scroller;

    move v2, v1

    move v3, v1

    move v4, p1

    move v5, v1

    move v6, v1

    move v7, v1

    invoke-virtual/range {v0 .. v8}, Landroid/widget/Scroller;->fling(IIIIIIII)V

    .line 1634
    :goto_13
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->invalidate()V

    .line 1635
    return-void

    .line 1631
    :cond_17
    iget-object v0, p0, Landroid/widget/NumberPicker;->mFlingScroller:Landroid/widget/Scroller;

    move v2, v8

    move v3, v1

    move v4, p1

    move v5, v1

    move v6, v1

    move v7, v1

    invoke-virtual/range {v0 .. v8}, Landroid/widget/Scroller;->fling(IIIIIIII)V

    goto :goto_13
.end method

.method private formatNumber(I)Ljava/lang/String;
    .registers 3
    .parameter "value"

    .prologue
    .line 1705
    iget-object v0, p0, Landroid/widget/NumberPicker;->mFormatter:Landroid/widget/NumberPicker$Formatter;

    if-eqz v0, :cond_b

    iget-object v0, p0, Landroid/widget/NumberPicker;->mFormatter:Landroid/widget/NumberPicker$Formatter;

    invoke-interface {v0, p1}, Landroid/widget/NumberPicker$Formatter;->format(I)Ljava/lang/String;

    move-result-object v0

    :goto_a
    return-object v0

    :cond_b
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_a
.end method

.method private getSelectedPos(Ljava/lang/String;)I
    .registers 4
    .parameter "value"

    .prologue
    .line 1820
    iget-object v1, p0, Landroid/widget/NumberPicker;->mDisplayedValues:[Ljava/lang/String;

    if-nez v1, :cond_9

    .line 1822
    :try_start_4
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_7
    .catch Ljava/lang/NumberFormatException; {:try_start_4 .. :try_end_7} :catch_2d

    move-result v1

    .line 1846
    :goto_8
    return v1

    .line 1827
    :cond_9
    const/4 v0, 0x0

    .local v0, i:I
    :goto_a
    iget-object v1, p0, Landroid/widget/NumberPicker;->mDisplayedValues:[Ljava/lang/String;

    array-length v1, v1

    if-ge v0, v1, :cond_28

    .line 1829
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object p1

    .line 1830
    iget-object v1, p0, Landroid/widget/NumberPicker;->mDisplayedValues:[Ljava/lang/String;

    aget-object v1, v1, v0

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_25

    .line 1831
    iget v1, p0, Landroid/widget/NumberPicker;->mMinValue:I

    add-int/2addr v1, v0

    goto :goto_8

    .line 1827
    :cond_25
    add-int/lit8 v0, v0, 0x1

    goto :goto_a

    .line 1840
    :cond_28
    :try_start_28
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_2b
    .catch Ljava/lang/NumberFormatException; {:try_start_28 .. :try_end_2b} :catch_31

    move-result v1

    goto :goto_8

    .line 1823
    .end local v0           #i:I
    :catch_2d
    move-exception v1

    .line 1846
    :goto_2e
    iget v1, p0, Landroid/widget/NumberPicker;->mMinValue:I

    goto :goto_8

    .line 1841
    .restart local v0       #i:I
    :catch_31
    move-exception v1

    goto :goto_2e
.end method

.method private getWrappedSelectorIndex(I)I
    .registers 6
    .parameter "selectorIndex"

    .prologue
    .line 1641
    iget v0, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    if-le p1, v0, :cond_14

    .line 1642
    iget v0, p0, Landroid/widget/NumberPicker;->mMinValue:I

    iget v1, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    sub-int v1, p1, v1

    iget v2, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    iget v3, p0, Landroid/widget/NumberPicker;->mMinValue:I

    sub-int/2addr v2, v3

    rem-int/2addr v1, v2

    add-int/2addr v0, v1

    add-int/lit8 p1, v0, -0x1

    .line 1646
    .end local p1
    :cond_13
    :goto_13
    return p1

    .line 1643
    .restart local p1
    :cond_14
    iget v0, p0, Landroid/widget/NumberPicker;->mMinValue:I

    if-ge p1, v0, :cond_13

    .line 1644
    iget v0, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    iget v1, p0, Landroid/widget/NumberPicker;->mMinValue:I

    sub-int/2addr v1, p1

    iget v2, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    iget v3, p0, Landroid/widget/NumberPicker;->mMinValue:I

    sub-int/2addr v2, v3

    rem-int/2addr v1, v2

    sub-int/2addr v0, v1

    add-int/lit8 p1, v0, 0x1

    goto :goto_13
.end method

.method private hideSoftInput()V
    .registers 4

    .prologue
    .line 1139
    invoke-static {}, Landroid/view/inputmethod/InputMethodManager;->peekInstance()Landroid/view/inputmethod/InputMethodManager;

    move-result-object v0

    .line 1140
    .local v0, inputMethodManager:Landroid/view/inputmethod/InputMethodManager;
    if-eqz v0, :cond_20

    iget-object v1, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v0, v1}, Landroid/view/inputmethod/InputMethodManager;->isActive(Landroid/view/View;)Z

    move-result v1

    if-eqz v1, :cond_20

    .line 1141
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 1142
    iget-boolean v1, p0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    if-eqz v1, :cond_20

    .line 1143
    iget-object v1, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setVisibility(I)V

    .line 1146
    :cond_20
    return-void
.end method

.method private incrementSelectorIndices([I)V
    .registers 5
    .parameter "selectorIndices"

    .prologue
    .line 1654
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    array-length v2, p1

    add-int/lit8 v2, v2, -0x1

    if-ge v0, v2, :cond_f

    .line 1655
    add-int/lit8 v2, v0, 0x1

    aget v2, p1, v2

    aput v2, p1, v0

    .line 1654
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1657
    :cond_f
    array-length v2, p1

    add-int/lit8 v2, v2, -0x2

    aget v2, p1, v2

    add-int/lit8 v1, v2, 0x1

    .line 1658
    .local v1, nextScrollSelectorIndex:I
    iget-boolean v2, p0, Landroid/widget/NumberPicker;->mWrapSelectorWheel:Z

    if-eqz v2, :cond_20

    iget v2, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    if-le v1, v2, :cond_20

    .line 1659
    iget v1, p0, Landroid/widget/NumberPicker;->mMinValue:I

    .line 1661
    :cond_20
    array-length v2, p1

    add-int/lit8 v2, v2, -0x1

    aput v1, p1, v2

    .line 1662
    invoke-direct {p0, v1}, Landroid/widget/NumberPicker;->ensureCachedScrollSelectorValue(I)V

    .line 1663
    return-void
.end method

.method private initializeFadingEdges()V
    .registers 3

    .prologue
    .line 1589
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/widget/NumberPicker;->setVerticalFadingEdgeEnabled(Z)V

    .line 1590
    iget v0, p0, Landroid/view/View;->mBottom:I

    iget v1, p0, Landroid/view/View;->mTop:I

    sub-int/2addr v0, v1

    iget v1, p0, Landroid/widget/NumberPicker;->mTextSize:I

    sub-int/2addr v0, v1

    div-int/lit8 v0, v0, 0x2

    invoke-virtual {p0, v0}, Landroid/widget/NumberPicker;->setFadingEdgeLength(I)V

    .line 1591
    return-void
.end method

.method private initializeSelectorWheel()V
    .registers 8

    .prologue
    .line 1572
    invoke-direct {p0}, Landroid/widget/NumberPicker;->initializeSelectorWheelIndices()V

    .line 1573
    iget-object v1, p0, Landroid/widget/NumberPicker;->mSelectorIndices:[I

    .line 1574
    .local v1, selectorIndices:[I
    array-length v5, v1

    iget v6, p0, Landroid/widget/NumberPicker;->mTextSize:I

    mul-int v4, v5, v6

    .line 1575
    .local v4, totalTextHeight:I
    iget v5, p0, Landroid/view/View;->mBottom:I

    iget v6, p0, Landroid/view/View;->mTop:I

    sub-int/2addr v5, v6

    sub-int/2addr v5, v4

    int-to-float v3, v5

    .line 1576
    .local v3, totalTextGapHeight:F
    array-length v5, v1

    int-to-float v2, v5

    .line 1577
    .local v2, textGapCount:F
    div-float v5, v3, v2

    const/high16 v6, 0x3f00

    add-float/2addr v5, v6

    float-to-int v5, v5

    iput v5, p0, Landroid/widget/NumberPicker;->mSelectorTextGapHeight:I

    .line 1578
    iget v5, p0, Landroid/widget/NumberPicker;->mTextSize:I

    iget v6, p0, Landroid/widget/NumberPicker;->mSelectorTextGapHeight:I

    add-int/2addr v5, v6

    iput v5, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    .line 1581
    iget-object v5, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v5}, Landroid/widget/EditText;->getBaseline()I

    move-result v5

    iget-object v6, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getTop()I

    move-result v6

    add-int v0, v5, v6

    .line 1582
    .local v0, editTextTextPosition:I
    iget v5, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    mul-int/lit8 v5, v5, 0x1

    sub-int v5, v0, v5

    iput v5, p0, Landroid/widget/NumberPicker;->mInitialScrollOffset:I

    .line 1584
    iget v5, p0, Landroid/widget/NumberPicker;->mInitialScrollOffset:I

    iput v5, p0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    .line 1585
    invoke-direct {p0}, Landroid/widget/NumberPicker;->updateInputTextView()Z

    .line 1586
    return-void
.end method

.method private initializeSelectorWheelIndices()V
    .registers 6

    .prologue
    .line 1502
    iget-object v4, p0, Landroid/widget/NumberPicker;->mSelectorIndexToStringCache:Landroid/util/SparseArray;

    invoke-virtual {v4}, Landroid/util/SparseArray;->clear()V

    .line 1503
    iget-object v3, p0, Landroid/widget/NumberPicker;->mSelectorIndices:[I

    .line 1504
    .local v3, selectorIndices:[I
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->getValue()I

    move-result v0

    .line 1505
    .local v0, current:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_c
    iget-object v4, p0, Landroid/widget/NumberPicker;->mSelectorIndices:[I

    array-length v4, v4

    if-ge v1, v4, :cond_27

    .line 1506
    add-int/lit8 v4, v1, -0x1

    add-int v2, v0, v4

    .line 1507
    .local v2, selectorIndex:I
    iget-boolean v4, p0, Landroid/widget/NumberPicker;->mWrapSelectorWheel:Z

    if-eqz v4, :cond_1d

    .line 1508
    invoke-direct {p0, v2}, Landroid/widget/NumberPicker;->getWrappedSelectorIndex(I)I

    move-result v2

    .line 1510
    :cond_1d
    aput v2, v3, v1

    .line 1511
    aget v4, v3, v1

    invoke-direct {p0, v4}, Landroid/widget/NumberPicker;->ensureCachedScrollSelectorValue(I)V

    .line 1505
    add-int/lit8 v1, v1, 0x1

    goto :goto_c

    .line 1513
    .end local v2           #selectorIndex:I
    :cond_27
    return-void
.end method

.method private makeMeasureSpec(II)I
    .registers 8
    .parameter "measureSpec"
    .parameter "maxSize"

    .prologue
    const/high16 v3, 0x4000

    .line 1460
    const/4 v2, -0x1

    if-ne p2, v2, :cond_6

    .line 1471
    .end local p1
    :goto_5
    :sswitch_5
    return p1

    .line 1463
    .restart local p1
    :cond_6
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v1

    .line 1464
    .local v1, size:I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v0

    .line 1465
    .local v0, mode:I
    sparse-switch v0, :sswitch_data_38

    .line 1473
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unknown measure mode: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1469
    :sswitch_2a
    invoke-static {v1, p2}, Ljava/lang/Math;->min(II)I

    move-result v2

    invoke-static {v2, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result p1

    goto :goto_5

    .line 1471
    :sswitch_33
    invoke-static {p2, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result p1

    goto :goto_5

    .line 1465
    :sswitch_data_38
    .sparse-switch
        -0x80000000 -> :sswitch_2a
        0x0 -> :sswitch_33
        0x40000000 -> :sswitch_5
    .end sparse-switch
.end method

.method private moveToFinalScrollerPosition(Landroid/widget/Scroller;)Z
    .registers 9
    .parameter "scroller"

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 750
    invoke-virtual {p1, v3}, Landroid/widget/Scroller;->forceFinished(Z)V

    .line 751
    invoke-virtual {p1}, Landroid/widget/Scroller;->getFinalY()I

    move-result v5

    invoke-virtual {p1}, Landroid/widget/Scroller;->getCurrY()I

    move-result v6

    sub-int v0, v5, v6

    .line 752
    .local v0, amountToScroll:I
    iget v5, p0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    add-int/2addr v5, v0

    iget v6, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    rem-int v1, v5, v6

    .line 753
    .local v1, futureScrollOffset:I
    iget v5, p0, Landroid/widget/NumberPicker;->mInitialScrollOffset:I

    sub-int v2, v5, v1

    .line 754
    .local v2, overshootAdjustment:I
    if-eqz v2, :cond_34

    .line 755
    invoke-static {v2}, Ljava/lang/Math;->abs(I)I

    move-result v5

    iget v6, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    div-int/lit8 v6, v6, 0x2

    if-le v5, v6, :cond_2b

    .line 756
    if-lez v2, :cond_30

    .line 757
    iget v5, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    sub-int/2addr v2, v5

    .line 762
    :cond_2b
    :goto_2b
    add-int/2addr v0, v2

    .line 763
    invoke-virtual {p0, v4, v0}, Landroid/widget/NumberPicker;->scrollBy(II)V

    .line 766
    :goto_2f
    return v3

    .line 759
    :cond_30
    iget v5, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    add-int/2addr v2, v5

    goto :goto_2b

    :cond_34
    move v3, v4

    .line 766
    goto :goto_2f
.end method

.method private notifyChange(II)V
    .registers 5
    .parameter "previous"
    .parameter "current"

    .prologue
    .line 1749
    iget-object v0, p0, Landroid/widget/NumberPicker;->mOnValueChangeListener:Landroid/widget/NumberPicker$OnValueChangeListener;

    if-eqz v0, :cond_b

    .line 1750
    iget-object v0, p0, Landroid/widget/NumberPicker;->mOnValueChangeListener:Landroid/widget/NumberPicker$OnValueChangeListener;

    iget v1, p0, Landroid/widget/NumberPicker;->mValue:I

    invoke-interface {v0, p0, p1, v1}, Landroid/widget/NumberPicker$OnValueChangeListener;->onValueChange(Landroid/widget/NumberPicker;II)V

    .line 1752
    :cond_b
    return-void
.end method

.method private onScrollStateChange(I)V
    .registers 3
    .parameter "scrollState"

    .prologue
    .line 1613
    iget v0, p0, Landroid/widget/NumberPicker;->mScrollState:I

    if-ne v0, p1, :cond_5

    .line 1620
    :cond_4
    :goto_4
    return-void

    .line 1616
    :cond_5
    iput p1, p0, Landroid/widget/NumberPicker;->mScrollState:I

    .line 1617
    iget-object v0, p0, Landroid/widget/NumberPicker;->mOnScrollListener:Landroid/widget/NumberPicker$OnScrollListener;

    if-eqz v0, :cond_4

    .line 1618
    iget-object v0, p0, Landroid/widget/NumberPicker;->mOnScrollListener:Landroid/widget/NumberPicker$OnScrollListener;

    invoke-interface {v0, p0, p1}, Landroid/widget/NumberPicker$OnScrollListener;->onScrollStateChange(Landroid/widget/NumberPicker;I)V

    goto :goto_4
.end method

.method private onScrollerFinished(Landroid/widget/Scroller;)V
    .registers 4
    .parameter "scroller"

    .prologue
    .line 1597
    iget-object v0, p0, Landroid/widget/NumberPicker;->mFlingScroller:Landroid/widget/Scroller;

    if-ne p1, v0, :cond_12

    .line 1598
    invoke-direct {p0}, Landroid/widget/NumberPicker;->ensureScrollWheelAdjusted()Z

    move-result v0

    if-nez v0, :cond_d

    .line 1599
    invoke-direct {p0}, Landroid/widget/NumberPicker;->updateInputTextView()Z

    .line 1601
    :cond_d
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/widget/NumberPicker;->onScrollStateChange(I)V

    .line 1607
    :cond_11
    :goto_11
    return-void

    .line 1603
    :cond_12
    iget v0, p0, Landroid/widget/NumberPicker;->mScrollState:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_11

    .line 1604
    invoke-direct {p0}, Landroid/widget/NumberPicker;->updateInputTextView()Z

    goto :goto_11
.end method

.method private postBeginSoftInputOnLongPressCommand()V
    .registers 4

    .prologue
    .line 1783
    iget-object v0, p0, Landroid/widget/NumberPicker;->mBeginSoftInputOnLongPressCommand:Landroid/widget/NumberPicker$BeginSoftInputOnLongPressCommand;

    if-nez v0, :cond_16

    .line 1784
    new-instance v0, Landroid/widget/NumberPicker$BeginSoftInputOnLongPressCommand;

    invoke-direct {v0, p0}, Landroid/widget/NumberPicker$BeginSoftInputOnLongPressCommand;-><init>(Landroid/widget/NumberPicker;)V

    iput-object v0, p0, Landroid/widget/NumberPicker;->mBeginSoftInputOnLongPressCommand:Landroid/widget/NumberPicker$BeginSoftInputOnLongPressCommand;

    .line 1788
    :goto_b
    iget-object v0, p0, Landroid/widget/NumberPicker;->mBeginSoftInputOnLongPressCommand:Landroid/widget/NumberPicker$BeginSoftInputOnLongPressCommand;

    invoke-static {}, Landroid/view/ViewConfiguration;->getLongPressTimeout()I

    move-result v1

    int-to-long v1, v1

    invoke-virtual {p0, v0, v1, v2}, Landroid/widget/NumberPicker;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 1789
    return-void

    .line 1786
    :cond_16
    iget-object v0, p0, Landroid/widget/NumberPicker;->mBeginSoftInputOnLongPressCommand:Landroid/widget/NumberPicker$BeginSoftInputOnLongPressCommand;

    invoke-virtual {p0, v0}, Landroid/widget/NumberPicker;->removeCallbacks(Ljava/lang/Runnable;)Z

    goto :goto_b
.end method

.method private postChangeCurrentByOneFromLongPress(ZJ)V
    .registers 5
    .parameter "increment"
    .parameter "delayMillis"

    .prologue
    .line 1760
    iget-object v0, p0, Landroid/widget/NumberPicker;->mChangeCurrentByOneFromLongPressCommand:Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;

    if-nez v0, :cond_16

    .line 1761
    new-instance v0, Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;

    invoke-direct {v0, p0}, Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;-><init>(Landroid/widget/NumberPicker;)V

    iput-object v0, p0, Landroid/widget/NumberPicker;->mChangeCurrentByOneFromLongPressCommand:Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;

    .line 1765
    :goto_b
    iget-object v0, p0, Landroid/widget/NumberPicker;->mChangeCurrentByOneFromLongPressCommand:Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;

    #calls: Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;->setStep(Z)V
    invoke-static {v0, p1}, Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;->access$500(Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;Z)V

    .line 1766
    iget-object v0, p0, Landroid/widget/NumberPicker;->mChangeCurrentByOneFromLongPressCommand:Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;

    invoke-virtual {p0, v0, p2, p3}, Landroid/widget/NumberPicker;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 1767
    return-void

    .line 1763
    :cond_16
    iget-object v0, p0, Landroid/widget/NumberPicker;->mChangeCurrentByOneFromLongPressCommand:Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;

    invoke-virtual {p0, v0}, Landroid/widget/NumberPicker;->removeCallbacks(Ljava/lang/Runnable;)Z

    goto :goto_b
.end method

.method private postSetSelectionCommand(II)V
    .registers 4
    .parameter "selectionStart"
    .parameter "selectionEnd"

    .prologue
    .line 1854
    iget-object v0, p0, Landroid/widget/NumberPicker;->mSetSelectionCommand:Landroid/widget/NumberPicker$SetSelectionCommand;

    if-nez v0, :cond_1b

    .line 1855
    new-instance v0, Landroid/widget/NumberPicker$SetSelectionCommand;

    invoke-direct {v0, p0}, Landroid/widget/NumberPicker$SetSelectionCommand;-><init>(Landroid/widget/NumberPicker;)V

    iput-object v0, p0, Landroid/widget/NumberPicker;->mSetSelectionCommand:Landroid/widget/NumberPicker$SetSelectionCommand;

    .line 1859
    :goto_b
    iget-object v0, p0, Landroid/widget/NumberPicker;->mSetSelectionCommand:Landroid/widget/NumberPicker$SetSelectionCommand;

    #setter for: Landroid/widget/NumberPicker$SetSelectionCommand;->mSelectionStart:I
    invoke-static {v0, p1}, Landroid/widget/NumberPicker$SetSelectionCommand;->access$602(Landroid/widget/NumberPicker$SetSelectionCommand;I)I

    .line 1860
    iget-object v0, p0, Landroid/widget/NumberPicker;->mSetSelectionCommand:Landroid/widget/NumberPicker$SetSelectionCommand;

    #setter for: Landroid/widget/NumberPicker$SetSelectionCommand;->mSelectionEnd:I
    invoke-static {v0, p2}, Landroid/widget/NumberPicker$SetSelectionCommand;->access$702(Landroid/widget/NumberPicker$SetSelectionCommand;I)I

    .line 1861
    iget-object v0, p0, Landroid/widget/NumberPicker;->mSetSelectionCommand:Landroid/widget/NumberPicker$SetSelectionCommand;

    invoke-virtual {p0, v0}, Landroid/widget/NumberPicker;->post(Ljava/lang/Runnable;)Z

    .line 1862
    return-void

    .line 1857
    :cond_1b
    iget-object v0, p0, Landroid/widget/NumberPicker;->mSetSelectionCommand:Landroid/widget/NumberPicker$SetSelectionCommand;

    invoke-virtual {p0, v0}, Landroid/widget/NumberPicker;->removeCallbacks(Ljava/lang/Runnable;)Z

    goto :goto_b
.end method

.method private removeAllCallbacks()V
    .registers 2

    .prologue
    .line 1804
    iget-object v0, p0, Landroid/widget/NumberPicker;->mChangeCurrentByOneFromLongPressCommand:Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;

    if-eqz v0, :cond_9

    .line 1805
    iget-object v0, p0, Landroid/widget/NumberPicker;->mChangeCurrentByOneFromLongPressCommand:Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;

    invoke-virtual {p0, v0}, Landroid/widget/NumberPicker;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 1807
    :cond_9
    iget-object v0, p0, Landroid/widget/NumberPicker;->mSetSelectionCommand:Landroid/widget/NumberPicker$SetSelectionCommand;

    if-eqz v0, :cond_12

    .line 1808
    iget-object v0, p0, Landroid/widget/NumberPicker;->mSetSelectionCommand:Landroid/widget/NumberPicker$SetSelectionCommand;

    invoke-virtual {p0, v0}, Landroid/widget/NumberPicker;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 1810
    :cond_12
    iget-object v0, p0, Landroid/widget/NumberPicker;->mBeginSoftInputOnLongPressCommand:Landroid/widget/NumberPicker$BeginSoftInputOnLongPressCommand;

    if-eqz v0, :cond_1b

    .line 1811
    iget-object v0, p0, Landroid/widget/NumberPicker;->mBeginSoftInputOnLongPressCommand:Landroid/widget/NumberPicker$BeginSoftInputOnLongPressCommand;

    invoke-virtual {p0, v0}, Landroid/widget/NumberPicker;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 1813
    :cond_1b
    iget-object v0, p0, Landroid/widget/NumberPicker;->mPressedStateHelper:Landroid/widget/NumberPicker$PressedStateHelper;

    invoke-virtual {v0}, Landroid/widget/NumberPicker$PressedStateHelper;->cancel()V

    .line 1814
    return-void
.end method

.method private removeBeginSoftInputCommand()V
    .registers 2

    .prologue
    .line 1795
    iget-object v0, p0, Landroid/widget/NumberPicker;->mBeginSoftInputOnLongPressCommand:Landroid/widget/NumberPicker$BeginSoftInputOnLongPressCommand;

    if-eqz v0, :cond_9

    .line 1796
    iget-object v0, p0, Landroid/widget/NumberPicker;->mBeginSoftInputOnLongPressCommand:Landroid/widget/NumberPicker$BeginSoftInputOnLongPressCommand;

    invoke-virtual {p0, v0}, Landroid/widget/NumberPicker;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 1798
    :cond_9
    return-void
.end method

.method private removeChangeCurrentByOneFromLongPress()V
    .registers 2

    .prologue
    .line 1773
    iget-object v0, p0, Landroid/widget/NumberPicker;->mChangeCurrentByOneFromLongPressCommand:Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;

    if-eqz v0, :cond_9

    .line 1774
    iget-object v0, p0, Landroid/widget/NumberPicker;->mChangeCurrentByOneFromLongPressCommand:Landroid/widget/NumberPicker$ChangeCurrentByOneFromLongPressCommand;

    invoke-virtual {p0, v0}, Landroid/widget/NumberPicker;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 1776
    :cond_9
    return-void
.end method

.method private resolveSizeAndStateRespectingMinSize(III)I
    .registers 6
    .parameter "minSize"
    .parameter "measuredSize"
    .parameter "measureSpec"

    .prologue
    .line 1489
    const/4 v1, -0x1

    if-eq p1, v1, :cond_c

    .line 1490
    invoke-static {p1, p2}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 1491
    .local v0, desiredWidth:I
    const/4 v1, 0x0

    invoke-static {v0, p3, v1}, Landroid/widget/NumberPicker;->resolveSizeAndState(III)I

    move-result p2

    .line 1493
    .end local v0           #desiredWidth:I
    .end local p2
    :cond_c
    return p2
.end method

.method private setValueInternal(IZ)V
    .registers 5
    .parameter "current"
    .parameter "notifyChange"

    .prologue
    .line 1522
    iget v1, p0, Landroid/widget/NumberPicker;->mValue:I

    if-ne v1, p1, :cond_5

    .line 1540
    :goto_4
    return-void

    .line 1526
    :cond_5
    iget-boolean v1, p0, Landroid/widget/NumberPicker;->mWrapSelectorWheel:Z

    if-eqz v1, :cond_20

    .line 1527
    invoke-direct {p0, p1}, Landroid/widget/NumberPicker;->getWrappedSelectorIndex(I)I

    move-result p1

    .line 1532
    :goto_d
    iget v0, p0, Landroid/widget/NumberPicker;->mValue:I

    .line 1533
    .local v0, previous:I
    iput p1, p0, Landroid/widget/NumberPicker;->mValue:I

    .line 1534
    invoke-direct {p0}, Landroid/widget/NumberPicker;->updateInputTextView()Z

    .line 1535
    if-eqz p2, :cond_19

    .line 1536
    invoke-direct {p0, v0, p1}, Landroid/widget/NumberPicker;->notifyChange(II)V

    .line 1538
    :cond_19
    invoke-direct {p0}, Landroid/widget/NumberPicker;->initializeSelectorWheelIndices()V

    .line 1539
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->invalidate()V

    goto :goto_4

    .line 1529
    .end local v0           #previous:I
    :cond_20
    iget v1, p0, Landroid/widget/NumberPicker;->mMinValue:I

    invoke-static {p1, v1}, Ljava/lang/Math;->max(II)I

    move-result p1

    .line 1530
    iget v1, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    invoke-static {p1, v1}, Ljava/lang/Math;->min(II)I

    move-result p1

    goto :goto_d
.end method

.method private showSoftInput()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 1125
    invoke-static {}, Landroid/view/inputmethod/InputMethodManager;->peekInstance()Landroid/view/inputmethod/InputMethodManager;

    move-result-object v0

    .line 1126
    .local v0, inputMethodManager:Landroid/view/inputmethod/InputMethodManager;
    if-eqz v0, :cond_1a

    .line 1127
    iget-boolean v1, p0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    if-eqz v1, :cond_10

    .line 1128
    iget-object v1, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setVisibility(I)V

    .line 1130
    :cond_10
    iget-object v1, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->requestFocus()Z

    .line 1131
    iget-object v1, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 1133
    :cond_1a
    return-void
.end method

.method private tryComputeMaxWidth()V
    .registers 11

    .prologue
    .line 1152
    iget-boolean v8, p0, Landroid/widget/NumberPicker;->mComputeMaxWidth:Z

    if-nez v8, :cond_5

    .line 1189
    :cond_4
    :goto_4
    return-void

    .line 1155
    :cond_5
    const/4 v4, 0x0

    .line 1156
    .local v4, maxTextWidth:I
    iget-object v8, p0, Landroid/widget/NumberPicker;->mDisplayedValues:[Ljava/lang/String;

    if-nez v8, :cond_4b

    .line 1157
    const/4 v3, 0x0

    .line 1158
    .local v3, maxDigitWidth:F
    const/4 v2, 0x0

    .local v2, i:I
    :goto_c
    const/16 v8, 0x9

    if-gt v2, v8, :cond_22

    .line 1159
    iget-object v8, p0, Landroid/widget/NumberPicker;->mSelectorWheelPaint:Landroid/graphics/Paint;

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v1

    .line 1160
    .local v1, digitWidth:F
    cmpl-float v8, v1, v3

    if-lez v8, :cond_1f

    .line 1161
    move v3, v1

    .line 1158
    :cond_1f
    add-int/lit8 v2, v2, 0x1

    goto :goto_c

    .line 1164
    .end local v1           #digitWidth:F
    :cond_22
    const/4 v5, 0x0

    .line 1165
    .local v5, numberOfDigits:I
    iget v0, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    .line 1166
    .local v0, current:I
    :goto_25
    if-lez v0, :cond_2c

    .line 1167
    add-int/lit8 v5, v5, 0x1

    .line 1168
    div-int/lit8 v0, v0, 0xa

    goto :goto_25

    .line 1170
    :cond_2c
    int-to-float v8, v5

    mul-float/2addr v8, v3

    float-to-int v4, v8

    .line 1180
    .end local v0           #current:I
    .end local v3           #maxDigitWidth:F
    .end local v5           #numberOfDigits:I
    :cond_2f
    iget-object v8, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v8}, Landroid/widget/EditText;->getPaddingLeft()I

    move-result v8

    iget-object v9, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v9}, Landroid/widget/EditText;->getPaddingRight()I

    move-result v9

    add-int/2addr v8, v9

    add-int/2addr v4, v8

    .line 1181
    iget v8, p0, Landroid/widget/NumberPicker;->mMaxWidth:I

    if-eq v8, v4, :cond_4

    .line 1182
    iget v8, p0, Landroid/widget/NumberPicker;->mMinWidth:I

    if-le v4, v8, :cond_64

    .line 1183
    iput v4, p0, Landroid/widget/NumberPicker;->mMaxWidth:I

    .line 1187
    :goto_47
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->invalidate()V

    goto :goto_4

    .line 1172
    .end local v2           #i:I
    :cond_4b
    iget-object v8, p0, Landroid/widget/NumberPicker;->mDisplayedValues:[Ljava/lang/String;

    array-length v7, v8

    .line 1173
    .local v7, valueCount:I
    const/4 v2, 0x0

    .restart local v2       #i:I
    :goto_4f
    if-ge v2, v7, :cond_2f

    .line 1174
    iget-object v8, p0, Landroid/widget/NumberPicker;->mSelectorWheelPaint:Landroid/graphics/Paint;

    iget-object v9, p0, Landroid/widget/NumberPicker;->mDisplayedValues:[Ljava/lang/String;

    aget-object v9, v9, v2

    invoke-virtual {v8, v9}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v6

    .line 1175
    .local v6, textWidth:F
    int-to-float v8, v4

    cmpl-float v8, v6, v8

    if-lez v8, :cond_61

    .line 1176
    float-to-int v4, v6

    .line 1173
    :cond_61
    add-int/lit8 v2, v2, 0x1

    goto :goto_4f

    .line 1185
    .end local v6           #textWidth:F
    .end local v7           #valueCount:I
    :cond_64
    iget v8, p0, Landroid/widget/NumberPicker;->mMinWidth:I

    iput v8, p0, Landroid/widget/NumberPicker;->mMaxWidth:I

    goto :goto_47
.end method

.method private updateInputTextView()Z
    .registers 5

    .prologue
    .line 1734
    iget-object v1, p0, Landroid/widget/NumberPicker;->mDisplayedValues:[Ljava/lang/String;

    if-nez v1, :cond_27

    iget v1, p0, Landroid/widget/NumberPicker;->mValue:I

    invoke-direct {p0, v1}, Landroid/widget/NumberPicker;->formatNumber(I)Ljava/lang/String;

    move-result-object v0

    .line 1736
    .local v0, text:Ljava/lang/String;
    :goto_a
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_31

    iget-object v1, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_31

    .line 1737
    iget-object v1, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v1, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 1738
    const/4 v1, 0x1

    .line 1741
    :goto_26
    return v1

    .line 1734
    .end local v0           #text:Ljava/lang/String;
    :cond_27
    iget-object v1, p0, Landroid/widget/NumberPicker;->mDisplayedValues:[Ljava/lang/String;

    iget v2, p0, Landroid/widget/NumberPicker;->mValue:I

    iget v3, p0, Landroid/widget/NumberPicker;->mMinValue:I

    sub-int/2addr v2, v3

    aget-object v0, v1, v2

    goto :goto_a

    .line 1741
    .restart local v0       #text:Ljava/lang/String;
    :cond_31
    const/4 v1, 0x0

    goto :goto_26
.end method

.method private validateInputTextView(Landroid/view/View;)V
    .registers 5
    .parameter "v"

    .prologue
    .line 1709
    check-cast p1, Landroid/widget/TextView;

    .end local p1
    invoke-virtual {p1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 1710
    .local v1, str:Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_14

    .line 1712
    invoke-direct {p0}, Landroid/widget/NumberPicker;->updateInputTextView()Z

    .line 1718
    :goto_13
    return-void

    .line 1715
    :cond_14
    invoke-virtual {v1}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Landroid/widget/NumberPicker;->getSelectedPos(Ljava/lang/String;)I

    move-result v0

    .line 1716
    .local v0, current:I
    const/4 v2, 0x1

    invoke-direct {p0, v0, v2}, Landroid/widget/NumberPicker;->setValueInternal(IZ)V

    goto :goto_13
.end method


# virtual methods
.method public addFocusables(Ljava/util/ArrayList;II)V
    .registers 6
    .parameter
    .parameter "direction"
    .parameter "focusableMode"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;II)V"
        }
    .end annotation

    .prologue
    .line 1423
    .local p1, views:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    and-int/lit8 v0, p3, 0x2

    const/4 v1, 0x2

    if-ne v0, v1, :cond_f

    .line 1424
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->isAccessibilityFocusable()Z

    move-result v0

    if-eqz v0, :cond_f

    .line 1425
    invoke-virtual {p1, p0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1430
    :goto_e
    return-void

    .line 1429
    :cond_f
    invoke-super {p0, p1, p2, p3}, Landroid/widget/LinearLayout;->addFocusables(Ljava/util/ArrayList;II)V

    goto :goto_e
.end method

.method public computeScroll()V
    .registers 5

    .prologue
    .line 981
    iget-object v1, p0, Landroid/widget/NumberPicker;->mFlingScroller:Landroid/widget/Scroller;

    .line 982
    .local v1, scroller:Landroid/widget/Scroller;
    invoke-virtual {v1}, Landroid/widget/Scroller;->isFinished()Z

    move-result v2

    if-eqz v2, :cond_11

    .line 983
    iget-object v1, p0, Landroid/widget/NumberPicker;->mAdjustScroller:Landroid/widget/Scroller;

    .line 984
    invoke-virtual {v1}, Landroid/widget/Scroller;->isFinished()Z

    move-result v2

    if-eqz v2, :cond_11

    .line 1000
    :goto_10
    return-void

    .line 988
    :cond_11
    invoke-virtual {v1}, Landroid/widget/Scroller;->computeScrollOffset()Z

    .line 989
    invoke-virtual {v1}, Landroid/widget/Scroller;->getCurrY()I

    move-result v0

    .line 990
    .local v0, currentScrollerY:I
    iget v2, p0, Landroid/widget/NumberPicker;->mPreviousScrollerY:I

    if-nez v2, :cond_22

    .line 991
    invoke-virtual {v1}, Landroid/widget/Scroller;->getStartY()I

    move-result v2

    iput v2, p0, Landroid/widget/NumberPicker;->mPreviousScrollerY:I

    .line 993
    :cond_22
    const/4 v2, 0x0

    iget v3, p0, Landroid/widget/NumberPicker;->mPreviousScrollerY:I

    sub-int v3, v0, v3

    invoke-virtual {p0, v2, v3}, Landroid/widget/NumberPicker;->scrollBy(II)V

    .line 994
    iput v0, p0, Landroid/widget/NumberPicker;->mPreviousScrollerY:I

    .line 995
    invoke-virtual {v1}, Landroid/widget/Scroller;->isFinished()Z

    move-result v2

    if-eqz v2, :cond_36

    .line 996
    invoke-direct {p0, v1}, Landroid/widget/NumberPicker;->onScrollerFinished(Landroid/widget/Scroller;)V

    goto :goto_10

    .line 998
    :cond_36
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->invalidate()V

    goto :goto_10
.end method

.method protected dispatchHoverEvent(Landroid/view/MotionEvent;)Z
    .registers 12
    .parameter "event"

    .prologue
    const/4 v9, 0x0

    const/16 v8, 0x100

    const/16 v7, 0x80

    const/16 v6, 0x40

    const/4 v5, -0x1

    .line 932
    iget-boolean v4, p0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    if-nez v4, :cond_11

    .line 933
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->dispatchHoverEvent(Landroid/view/MotionEvent;)Z

    move-result v4

    .line 976
    :goto_10
    return v4

    .line 935
    :cond_11
    iget-object v4, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-static {v4}, Landroid/view/accessibility/AccessibilityManager;->getInstance(Landroid/content/Context;)Landroid/view/accessibility/AccessibilityManager;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v4

    if-eqz v4, :cond_34

    .line 936
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    float-to-int v1, v4

    .line 938
    .local v1, eventY:I
    iget v4, p0, Landroid/widget/NumberPicker;->mTopSelectionDividerTop:I

    if-ge v1, v4, :cond_36

    .line 939
    const/4 v2, 0x3

    .line 945
    .local v2, hoveredVirtualViewId:I
    :goto_27
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    .line 946
    .local v0, action:I
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->getAccessibilityNodeProvider()Landroid/view/accessibility/AccessibilityNodeProvider;

    move-result-object v3

    check-cast v3, Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;

    .line 948
    .local v3, provider:Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;
    packed-switch v0, :pswitch_data_64

    .line 976
    .end local v0           #action:I
    .end local v1           #eventY:I
    .end local v2           #hoveredVirtualViewId:I
    .end local v3           #provider:Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;
    :cond_34
    :goto_34
    :pswitch_34
    const/4 v4, 0x0

    goto :goto_10

    .line 940
    .restart local v1       #eventY:I
    :cond_36
    iget v4, p0, Landroid/widget/NumberPicker;->mBottomSelectionDividerBottom:I

    if-le v1, v4, :cond_3c

    .line 941
    const/4 v2, 0x1

    .restart local v2       #hoveredVirtualViewId:I
    goto :goto_27

    .line 943
    .end local v2           #hoveredVirtualViewId:I
    :cond_3c
    const/4 v2, 0x2

    .restart local v2       #hoveredVirtualViewId:I
    goto :goto_27

    .line 950
    .restart local v0       #action:I
    .restart local v3       #provider:Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;
    :pswitch_3e
    invoke-virtual {v3, v2, v7}, Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;->sendAccessibilityEventForVirtualView(II)V

    .line 952
    iput v2, p0, Landroid/widget/NumberPicker;->mLastHoveredChildVirtualViewId:I

    .line 953
    invoke-virtual {v3, v2, v6, v9}, Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;->performAction(IILandroid/os/Bundle;)Z

    goto :goto_34

    .line 957
    :pswitch_47
    iget v4, p0, Landroid/widget/NumberPicker;->mLastHoveredChildVirtualViewId:I

    if-eq v4, v2, :cond_34

    iget v4, p0, Landroid/widget/NumberPicker;->mLastHoveredChildVirtualViewId:I

    if-eq v4, v5, :cond_34

    .line 959
    iget v4, p0, Landroid/widget/NumberPicker;->mLastHoveredChildVirtualViewId:I

    invoke-virtual {v3, v4, v8}, Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;->sendAccessibilityEventForVirtualView(II)V

    .line 962
    invoke-virtual {v3, v2, v7}, Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;->sendAccessibilityEventForVirtualView(II)V

    .line 964
    iput v2, p0, Landroid/widget/NumberPicker;->mLastHoveredChildVirtualViewId:I

    .line 965
    invoke-virtual {v3, v2, v6, v9}, Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;->performAction(IILandroid/os/Bundle;)Z

    goto :goto_34

    .line 970
    :pswitch_5d
    invoke-virtual {v3, v2, v8}, Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;->sendAccessibilityEventForVirtualView(II)V

    .line 972
    iput v5, p0, Landroid/widget/NumberPicker;->mLastHoveredChildVirtualViewId:I

    goto :goto_34

    .line 948
    nop

    :pswitch_data_64
    .packed-switch 0x7
        :pswitch_47
        :pswitch_34
        :pswitch_3e
        :pswitch_5d
    .end packed-switch
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .registers 4
    .parameter "event"

    .prologue
    .line 908
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    .line 909
    .local v0, keyCode:I
    sparse-switch v0, :sswitch_data_10

    .line 915
    :goto_7
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v1

    return v1

    .line 912
    :sswitch_c
    invoke-direct {p0}, Landroid/widget/NumberPicker;->removeAllCallbacks()V

    goto :goto_7

    .line 909
    :sswitch_data_10
    .sparse-switch
        0x17 -> :sswitch_c
        0x42 -> :sswitch_c
    .end sparse-switch
.end method

.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 4
    .parameter "event"

    .prologue
    .line 896
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    .line 897
    .local v0, action:I
    packed-switch v0, :pswitch_data_10

    .line 903
    :goto_7
    :pswitch_7
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v1

    return v1

    .line 900
    :pswitch_c
    invoke-direct {p0}, Landroid/widget/NumberPicker;->removeAllCallbacks()V

    goto :goto_7

    .line 897
    :pswitch_data_10
    .packed-switch 0x1
        :pswitch_c
        :pswitch_7
        :pswitch_c
    .end packed-switch
.end method

.method public dispatchTrackballEvent(Landroid/view/MotionEvent;)Z
    .registers 4
    .parameter "event"

    .prologue
    .line 920
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    .line 921
    .local v0, action:I
    packed-switch v0, :pswitch_data_10

    .line 927
    :goto_7
    :pswitch_7
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->dispatchTrackballEvent(Landroid/view/MotionEvent;)Z

    move-result v1

    return v1

    .line 924
    :pswitch_c
    invoke-direct {p0}, Landroid/widget/NumberPicker;->removeAllCallbacks()V

    goto :goto_7

    .line 921
    :pswitch_data_10
    .packed-switch 0x1
        :pswitch_c
        :pswitch_7
        :pswitch_c
    .end packed-switch
.end method

.method public getAccessibilityNodeProvider()Landroid/view/accessibility/AccessibilityNodeProvider;
    .registers 2

    .prologue
    .line 1443
    iget-boolean v0, p0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    if-nez v0, :cond_9

    .line 1444
    invoke-super {p0}, Landroid/widget/LinearLayout;->getAccessibilityNodeProvider()Landroid/view/accessibility/AccessibilityNodeProvider;

    move-result-object v0

    .line 1449
    :goto_8
    return-object v0

    .line 1446
    :cond_9
    iget-object v0, p0, Landroid/widget/NumberPicker;->mAccessibilityNodeProvider:Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;

    if-nez v0, :cond_14

    .line 1447
    new-instance v0, Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;

    invoke-direct {v0, p0}, Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;-><init>(Landroid/widget/NumberPicker;)V

    iput-object v0, p0, Landroid/widget/NumberPicker;->mAccessibilityNodeProvider:Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;

    .line 1449
    :cond_14
    iget-object v0, p0, Landroid/widget/NumberPicker;->mAccessibilityNodeProvider:Landroid/widget/NumberPicker$AccessibilityNodeProviderImpl;

    goto :goto_8
.end method

.method protected getBottomFadingEdgeStrength()F
    .registers 2

    .prologue
    .line 1354
    const v0, 0x3f666666

    return v0
.end method

.method public getDisplayedValues()[Ljava/lang/String;
    .registers 2

    .prologue
    .line 1322
    iget-object v0, p0, Landroid/widget/NumberPicker;->mDisplayedValues:[Ljava/lang/String;

    return-object v0
.end method

.method public getMaxValue()I
    .registers 2

    .prologue
    .line 1289
    iget v0, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    return v0
.end method

.method public getMinValue()I
    .registers 2

    .prologue
    .line 1256
    iget v0, p0, Landroid/widget/NumberPicker;->mMinValue:I

    return v0
.end method

.method public getSolidColor()I
    .registers 2

    .prologue
    .line 1048
    iget v0, p0, Landroid/widget/NumberPicker;->mSolidColor:I

    return v0
.end method

.method protected getTopFadingEdgeStrength()F
    .registers 2

    .prologue
    .line 1349
    const v0, 0x3f666666

    return v0
.end method

.method public getValue()I
    .registers 2

    .prologue
    .line 1247
    iget v0, p0, Landroid/widget/NumberPicker;->mValue:I

    return v0
.end method

.method public getWrapSelectorWheel()Z
    .registers 2

    .prologue
    .line 1200
    iget-boolean v0, p0, Landroid/widget/NumberPicker;->mWrapSelectorWheel:Z

    return v0
.end method

.method protected onDetachedFromWindow()V
    .registers 1

    .prologue
    .line 1359
    invoke-direct {p0}, Landroid/widget/NumberPicker;->removeAllCallbacks()V

    .line 1360
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .registers 18
    .parameter "canvas"

    .prologue
    .line 1364
    move-object/from16 v0, p0

    iget-boolean v11, v0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    if-nez v11, :cond_a

    .line 1365
    invoke-super/range {p0 .. p1}, Landroid/widget/LinearLayout;->onDraw(Landroid/graphics/Canvas;)V

    .line 1417
    :cond_9
    :goto_9
    return-void

    .line 1368
    :cond_a
    move-object/from16 v0, p0

    iget v11, v0, Landroid/view/View;->mRight:I

    move-object/from16 v0, p0

    iget v12, v0, Landroid/view/View;->mLeft:I

    sub-int/2addr v11, v12

    div-int/lit8 v11, v11, 0x2

    int-to-float v9, v11

    .line 1369
    .local v9, x:F
    move-object/from16 v0, p0

    iget v11, v0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    int-to-float v10, v11

    .line 1372
    .local v10, y:F
    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/widget/NumberPicker;->mVirtualButtonPressedDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v11, :cond_7c

    move-object/from16 v0, p0

    iget v11, v0, Landroid/widget/NumberPicker;->mScrollState:I

    if-nez v11, :cond_7c

    .line 1374
    move-object/from16 v0, p0

    iget-boolean v11, v0, Landroid/widget/NumberPicker;->mDecrementVirtualButtonPressed:Z

    if-eqz v11, :cond_50

    .line 1375
    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/widget/NumberPicker;->mVirtualButtonPressedDrawable:Landroid/graphics/drawable/Drawable;

    sget-object v12, Landroid/widget/NumberPicker;->PRESSED_STATE_SET:[I

    invoke-virtual {v11, v12}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 1376
    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/widget/NumberPicker;->mVirtualButtonPressedDrawable:Landroid/graphics/drawable/Drawable;

    const/4 v12, 0x0

    const/4 v13, 0x0

    move-object/from16 v0, p0

    iget v14, v0, Landroid/view/View;->mRight:I

    move-object/from16 v0, p0

    iget v15, v0, Landroid/widget/NumberPicker;->mTopSelectionDividerTop:I

    invoke-virtual {v11, v12, v13, v14, v15}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 1377
    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/widget/NumberPicker;->mVirtualButtonPressedDrawable:Landroid/graphics/drawable/Drawable;

    move-object/from16 v0, p1

    invoke-virtual {v11, v0}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 1379
    :cond_50
    move-object/from16 v0, p0

    iget-boolean v11, v0, Landroid/widget/NumberPicker;->mIncrementVirtualButtonPressed:Z

    if-eqz v11, :cond_7c

    .line 1380
    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/widget/NumberPicker;->mVirtualButtonPressedDrawable:Landroid/graphics/drawable/Drawable;

    sget-object v12, Landroid/widget/NumberPicker;->PRESSED_STATE_SET:[I

    invoke-virtual {v11, v12}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 1381
    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/widget/NumberPicker;->mVirtualButtonPressedDrawable:Landroid/graphics/drawable/Drawable;

    const/4 v12, 0x0

    move-object/from16 v0, p0

    iget v13, v0, Landroid/widget/NumberPicker;->mBottomSelectionDividerBottom:I

    move-object/from16 v0, p0

    iget v14, v0, Landroid/view/View;->mRight:I

    move-object/from16 v0, p0

    iget v15, v0, Landroid/view/View;->mBottom:I

    invoke-virtual {v11, v12, v13, v14, v15}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 1383
    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/widget/NumberPicker;->mVirtualButtonPressedDrawable:Landroid/graphics/drawable/Drawable;

    move-object/from16 v0, p1

    invoke-virtual {v11, v0}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 1388
    :cond_7c
    move-object/from16 v0, p0

    iget-object v6, v0, Landroid/widget/NumberPicker;->mSelectorIndices:[I

    .line 1389
    .local v6, selectorIndices:[I
    const/4 v3, 0x0

    .local v3, i:I
    :goto_81
    array-length v11, v6

    if-ge v3, v11, :cond_af

    .line 1390
    aget v5, v6, v3

    .line 1391
    .local v5, selectorIndex:I
    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/widget/NumberPicker;->mSelectorIndexToStringCache:Landroid/util/SparseArray;

    invoke-virtual {v11, v5}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 1397
    .local v4, scrollSelectorValue:Ljava/lang/String;
    const/4 v11, 0x1

    if-ne v3, v11, :cond_9d

    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v11}, Landroid/widget/EditText;->getVisibility()I

    move-result v11

    if-eqz v11, :cond_a6

    .line 1398
    :cond_9d
    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/widget/NumberPicker;->mSelectorWheelPaint:Landroid/graphics/Paint;

    move-object/from16 v0, p1

    invoke-virtual {v0, v4, v9, v10, v11}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 1400
    :cond_a6
    move-object/from16 v0, p0

    iget v11, v0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    int-to-float v11, v11

    add-float/2addr v10, v11

    .line 1389
    add-int/lit8 v3, v3, 0x1

    goto :goto_81

    .line 1404
    .end local v4           #scrollSelectorValue:Ljava/lang/String;
    .end local v5           #selectorIndex:I
    :cond_af
    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/widget/NumberPicker;->mSelectionDivider:Landroid/graphics/drawable/Drawable;

    if-eqz v11, :cond_9

    .line 1406
    move-object/from16 v0, p0

    iget v8, v0, Landroid/widget/NumberPicker;->mTopSelectionDividerTop:I

    .line 1407
    .local v8, topOfTopDivider:I
    move-object/from16 v0, p0

    iget v11, v0, Landroid/widget/NumberPicker;->mSelectionDividerHeight:I

    add-int v2, v8, v11

    .line 1408
    .local v2, bottomOfTopDivider:I
    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/widget/NumberPicker;->mSelectionDivider:Landroid/graphics/drawable/Drawable;

    const/4 v12, 0x0

    move-object/from16 v0, p0

    iget v13, v0, Landroid/view/View;->mRight:I

    invoke-virtual {v11, v12, v8, v13, v2}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 1409
    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/widget/NumberPicker;->mSelectionDivider:Landroid/graphics/drawable/Drawable;

    move-object/from16 v0, p1

    invoke-virtual {v11, v0}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 1412
    move-object/from16 v0, p0

    iget v1, v0, Landroid/widget/NumberPicker;->mBottomSelectionDividerBottom:I

    .line 1413
    .local v1, bottomOfBottomDivider:I
    move-object/from16 v0, p0

    iget v11, v0, Landroid/widget/NumberPicker;->mSelectionDividerHeight:I

    sub-int v7, v1, v11

    .line 1414
    .local v7, topOfBottomDivider:I
    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/widget/NumberPicker;->mSelectionDivider:Landroid/graphics/drawable/Drawable;

    const/4 v12, 0x0

    move-object/from16 v0, p0

    iget v13, v0, Landroid/view/View;->mRight:I

    invoke-virtual {v11, v12, v7, v13, v1}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 1415
    move-object/from16 v0, p0

    iget-object v11, v0, Landroid/widget/NumberPicker;->mSelectionDivider:Landroid/graphics/drawable/Drawable;

    move-object/from16 v0, p1

    invoke-virtual {v11, v0}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    goto/16 :goto_9
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .registers 4
    .parameter "event"

    .prologue
    .line 1434
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 1435
    const-class v0, Landroid/widget/NumberPicker;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    .line 1436
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setScrollable(Z)V

    .line 1437
    iget v0, p0, Landroid/widget/NumberPicker;->mMinValue:I

    iget v1, p0, Landroid/widget/NumberPicker;->mValue:I

    add-int/2addr v0, v1

    iget v1, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    mul-int/2addr v0, v1

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setScrollY(I)V

    .line 1438
    iget v0, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    iget v1, p0, Landroid/widget/NumberPicker;->mMinValue:I

    sub-int/2addr v0, v1

    iget v1, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    mul-int/2addr v0, v1

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setMaxScrollY(I)V

    .line 1439
    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 7
    .parameter "event"

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 771
    iget-boolean v3, p0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    if-eqz v3, :cond_c

    invoke-virtual {p0}, Landroid/widget/NumberPicker;->isEnabled()Z

    move-result v3

    if-nez v3, :cond_e

    :cond_c
    move v1, v2

    .line 819
    :goto_d
    return v1

    .line 774
    :cond_e
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    .line 775
    .local v0, action:I
    packed-switch v0, :pswitch_data_bc

    move v1, v2

    .line 819
    goto :goto_d

    .line 777
    :pswitch_17
    invoke-direct {p0}, Landroid/widget/NumberPicker;->removeAllCallbacks()V

    .line 778
    iget-object v3, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    const/4 v4, 0x4

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setVisibility(I)V

    .line 779
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    iput v3, p0, Landroid/widget/NumberPicker;->mLastDownEventY:F

    iput v3, p0, Landroid/widget/NumberPicker;->mLastDownOrMoveEventY:F

    .line 780
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v3

    iput-wide v3, p0, Landroid/widget/NumberPicker;->mLastDownEventTime:J

    .line 781
    iput-boolean v2, p0, Landroid/widget/NumberPicker;->mIngonreMoveEvents:Z

    .line 782
    iput-boolean v2, p0, Landroid/widget/NumberPicker;->mShowSoftInputOnTap:Z

    .line 784
    iget v3, p0, Landroid/widget/NumberPicker;->mLastDownEventY:F

    iget v4, p0, Landroid/widget/NumberPicker;->mTopSelectionDividerTop:I

    int-to-float v4, v4

    cmpg-float v3, v3, v4

    if-gez v3, :cond_62

    .line 785
    iget v3, p0, Landroid/widget/NumberPicker;->mScrollState:I

    if-nez v3, :cond_45

    .line 786
    iget-object v3, p0, Landroid/widget/NumberPicker;->mPressedStateHelper:Landroid/widget/NumberPicker$PressedStateHelper;

    const/4 v4, 0x2

    invoke-virtual {v3, v4}, Landroid/widget/NumberPicker$PressedStateHelper;->buttonPressDelayed(I)V

    .line 796
    :cond_45
    :goto_45
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->getParent()Landroid/view/ViewParent;

    move-result-object v3

    invoke-interface {v3, v1}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 797
    iget-object v3, p0, Landroid/widget/NumberPicker;->mFlingScroller:Landroid/widget/Scroller;

    invoke-virtual {v3}, Landroid/widget/Scroller;->isFinished()Z

    move-result v3

    if-nez v3, :cond_75

    .line 798
    iget-object v3, p0, Landroid/widget/NumberPicker;->mFlingScroller:Landroid/widget/Scroller;

    invoke-virtual {v3, v1}, Landroid/widget/Scroller;->forceFinished(Z)V

    .line 799
    iget-object v3, p0, Landroid/widget/NumberPicker;->mAdjustScroller:Landroid/widget/Scroller;

    invoke-virtual {v3, v1}, Landroid/widget/Scroller;->forceFinished(Z)V

    .line 800
    invoke-direct {p0, v2}, Landroid/widget/NumberPicker;->onScrollStateChange(I)V

    goto :goto_d

    .line 789
    :cond_62
    iget v3, p0, Landroid/widget/NumberPicker;->mLastDownEventY:F

    iget v4, p0, Landroid/widget/NumberPicker;->mBottomSelectionDividerBottom:I

    int-to-float v4, v4

    cmpl-float v3, v3, v4

    if-lez v3, :cond_45

    .line 790
    iget v3, p0, Landroid/widget/NumberPicker;->mScrollState:I

    if-nez v3, :cond_45

    .line 791
    iget-object v3, p0, Landroid/widget/NumberPicker;->mPressedStateHelper:Landroid/widget/NumberPicker$PressedStateHelper;

    invoke-virtual {v3, v1}, Landroid/widget/NumberPicker$PressedStateHelper;->buttonPressDelayed(I)V

    goto :goto_45

    .line 801
    :cond_75
    iget-object v3, p0, Landroid/widget/NumberPicker;->mAdjustScroller:Landroid/widget/Scroller;

    invoke-virtual {v3}, Landroid/widget/Scroller;->isFinished()Z

    move-result v3

    if-nez v3, :cond_88

    .line 802
    iget-object v2, p0, Landroid/widget/NumberPicker;->mFlingScroller:Landroid/widget/Scroller;

    invoke-virtual {v2, v1}, Landroid/widget/Scroller;->forceFinished(Z)V

    .line 803
    iget-object v2, p0, Landroid/widget/NumberPicker;->mAdjustScroller:Landroid/widget/Scroller;

    invoke-virtual {v2, v1}, Landroid/widget/Scroller;->forceFinished(Z)V

    goto :goto_d

    .line 804
    :cond_88
    iget v3, p0, Landroid/widget/NumberPicker;->mLastDownEventY:F

    iget v4, p0, Landroid/widget/NumberPicker;->mTopSelectionDividerTop:I

    int-to-float v4, v4

    cmpg-float v3, v3, v4

    if-gez v3, :cond_9e

    .line 805
    invoke-direct {p0}, Landroid/widget/NumberPicker;->hideSoftInput()V

    .line 806
    invoke-static {}, Landroid/view/ViewConfiguration;->getLongPressTimeout()I

    move-result v3

    int-to-long v3, v3

    invoke-direct {p0, v2, v3, v4}, Landroid/widget/NumberPicker;->postChangeCurrentByOneFromLongPress(ZJ)V

    goto/16 :goto_d

    .line 808
    :cond_9e
    iget v2, p0, Landroid/widget/NumberPicker;->mLastDownEventY:F

    iget v3, p0, Landroid/widget/NumberPicker;->mBottomSelectionDividerBottom:I

    int-to-float v3, v3

    cmpl-float v2, v2, v3

    if-lez v2, :cond_b4

    .line 809
    invoke-direct {p0}, Landroid/widget/NumberPicker;->hideSoftInput()V

    .line 810
    invoke-static {}, Landroid/view/ViewConfiguration;->getLongPressTimeout()I

    move-result v2

    int-to-long v2, v2

    invoke-direct {p0, v1, v2, v3}, Landroid/widget/NumberPicker;->postChangeCurrentByOneFromLongPress(ZJ)V

    goto/16 :goto_d

    .line 813
    :cond_b4
    iput-boolean v1, p0, Landroid/widget/NumberPicker;->mShowSoftInputOnTap:Z

    .line 814
    invoke-direct {p0}, Landroid/widget/NumberPicker;->postBeginSoftInputOnLongPressCommand()V

    goto/16 :goto_d

    .line 775
    nop

    :pswitch_data_bc
    .packed-switch 0x0
        :pswitch_17
    .end packed-switch
.end method

.method protected onLayout(ZIIII)V
    .registers 16
    .parameter "changed"
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    .line 696
    iget-boolean v8, p0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    if-nez v8, :cond_8

    .line 697
    invoke-super/range {p0 .. p5}, Landroid/widget/LinearLayout;->onLayout(ZIIII)V

    .line 721
    :cond_7
    :goto_7
    return-void

    .line 700
    :cond_8
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->getMeasuredWidth()I

    move-result v7

    .line 701
    .local v7, msrdWdth:I
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->getMeasuredHeight()I

    move-result v6

    .line 704
    .local v6, msrdHght:I
    iget-object v8, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v8}, Landroid/widget/EditText;->getMeasuredWidth()I

    move-result v3

    .line 705
    .local v3, inptTxtMsrdWdth:I
    iget-object v8, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v8}, Landroid/widget/EditText;->getMeasuredHeight()I

    move-result v2

    .line 706
    .local v2, inptTxtMsrdHght:I
    sub-int v8, v7, v3

    div-int/lit8 v1, v8, 0x2

    .line 707
    .local v1, inptTxtLeft:I
    sub-int v8, v6, v2

    div-int/lit8 v5, v8, 0x2

    .line 708
    .local v5, inptTxtTop:I
    add-int v4, v1, v3

    .line 709
    .local v4, inptTxtRight:I
    add-int v0, v5, v2

    .line 710
    .local v0, inptTxtBottom:I
    iget-object v8, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v8, v1, v5, v4, v0}, Landroid/widget/EditText;->layout(IIII)V

    .line 712
    if-eqz p1, :cond_7

    .line 714
    invoke-direct {p0}, Landroid/widget/NumberPicker;->initializeSelectorWheel()V

    .line 715
    invoke-direct {p0}, Landroid/widget/NumberPicker;->initializeFadingEdges()V

    .line 716
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->getHeight()I

    move-result v8

    iget v9, p0, Landroid/widget/NumberPicker;->mSelectionDividersDistance:I

    sub-int/2addr v8, v9

    div-int/lit8 v8, v8, 0x2

    iget v9, p0, Landroid/widget/NumberPicker;->mSelectionDividerHeight:I

    sub-int/2addr v8, v9

    iput v8, p0, Landroid/widget/NumberPicker;->mTopSelectionDividerTop:I

    .line 718
    iget v8, p0, Landroid/widget/NumberPicker;->mTopSelectionDividerTop:I

    iget v9, p0, Landroid/widget/NumberPicker;->mSelectionDividerHeight:I

    mul-int/lit8 v9, v9, 0x2

    add-int/2addr v8, v9

    iget v9, p0, Landroid/widget/NumberPicker;->mSelectionDividersDistance:I

    add-int/2addr v8, v9

    iput v8, p0, Landroid/widget/NumberPicker;->mBottomSelectionDividerBottom:I

    goto :goto_7
.end method

.method protected onMeasure(II)V
    .registers 9
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    .line 725
    iget-boolean v4, p0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    if-nez v4, :cond_8

    .line 726
    invoke-super {p0, p1, p2}, Landroid/widget/LinearLayout;->onMeasure(II)V

    .line 739
    :goto_7
    return-void

    .line 730
    :cond_8
    iget v4, p0, Landroid/widget/NumberPicker;->mMaxWidth:I

    invoke-direct {p0, p1, v4}, Landroid/widget/NumberPicker;->makeMeasureSpec(II)I

    move-result v2

    .line 731
    .local v2, newWidthMeasureSpec:I
    iget v4, p0, Landroid/widget/NumberPicker;->mMaxHeight:I

    invoke-direct {p0, p2, v4}, Landroid/widget/NumberPicker;->makeMeasureSpec(II)I

    move-result v1

    .line 732
    .local v1, newHeightMeasureSpec:I
    invoke-super {p0, v2, v1}, Landroid/widget/LinearLayout;->onMeasure(II)V

    .line 734
    iget v4, p0, Landroid/widget/NumberPicker;->mMinWidth:I

    invoke-virtual {p0}, Landroid/widget/NumberPicker;->getMeasuredWidth()I

    move-result v5

    invoke-direct {p0, v4, v5, p1}, Landroid/widget/NumberPicker;->resolveSizeAndStateRespectingMinSize(III)I

    move-result v3

    .line 736
    .local v3, widthSize:I
    iget v4, p0, Landroid/widget/NumberPicker;->mMinHeight:I

    invoke-virtual {p0}, Landroid/widget/NumberPicker;->getMeasuredHeight()I

    move-result v5

    invoke-direct {p0, v4, v5, p2}, Landroid/widget/NumberPicker;->resolveSizeAndStateRespectingMinSize(III)I

    move-result v0

    .line 738
    .local v0, heightSize:I
    invoke-virtual {p0, v3, v0}, Landroid/widget/NumberPicker;->setMeasuredDimension(II)V

    goto :goto_7
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 16
    .parameter "event"

    .prologue
    .line 824
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->isEnabled()Z

    move-result v10

    if-eqz v10, :cond_a

    iget-boolean v10, p0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    if-nez v10, :cond_c

    .line 825
    :cond_a
    const/4 v10, 0x0

    .line 891
    :goto_b
    return v10

    .line 827
    :cond_c
    iget-object v10, p0, Landroid/widget/NumberPicker;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-nez v10, :cond_16

    .line 828
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v10

    iput-object v10, p0, Landroid/widget/NumberPicker;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 830
    :cond_16
    iget-object v10, p0, Landroid/widget/NumberPicker;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v10, p1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 831
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    .line 832
    .local v0, action:I
    packed-switch v0, :pswitch_data_de

    .line 891
    :cond_22
    :goto_22
    const/4 v10, 0x1

    goto :goto_b

    .line 834
    :pswitch_24
    iget-boolean v10, p0, Landroid/widget/NumberPicker;->mIngonreMoveEvents:Z

    if-nez v10, :cond_22

    .line 837
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    .line 838
    .local v1, currentMoveY:F
    iget v10, p0, Landroid/widget/NumberPicker;->mScrollState:I

    const/4 v11, 0x1

    if-eq v10, v11, :cond_48

    .line 839
    iget v10, p0, Landroid/widget/NumberPicker;->mLastDownEventY:F

    sub-float v10, v1, v10

    invoke-static {v10}, Ljava/lang/Math;->abs(F)F

    move-result v10

    float-to-int v2, v10

    .line 840
    .local v2, deltaDownY:I
    iget v10, p0, Landroid/widget/NumberPicker;->mTouchSlop:I

    if-le v2, v10, :cond_45

    .line 841
    invoke-direct {p0}, Landroid/widget/NumberPicker;->removeAllCallbacks()V

    .line 842
    const/4 v10, 0x1

    invoke-direct {p0, v10}, Landroid/widget/NumberPicker;->onScrollStateChange(I)V

    .line 849
    .end local v2           #deltaDownY:I
    :cond_45
    :goto_45
    iput v1, p0, Landroid/widget/NumberPicker;->mLastDownOrMoveEventY:F

    goto :goto_22

    .line 845
    :cond_48
    iget v10, p0, Landroid/widget/NumberPicker;->mLastDownOrMoveEventY:F

    sub-float v10, v1, v10

    float-to-int v3, v10

    .line 846
    .local v3, deltaMoveY:I
    const/4 v10, 0x0

    invoke-virtual {p0, v10, v3}, Landroid/widget/NumberPicker;->scrollBy(II)V

    .line 847
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->invalidate()V

    goto :goto_45

    .line 852
    .end local v1           #currentMoveY:F
    .end local v3           #deltaMoveY:I
    :pswitch_55
    invoke-direct {p0}, Landroid/widget/NumberPicker;->removeBeginSoftInputCommand()V

    .line 853
    invoke-direct {p0}, Landroid/widget/NumberPicker;->removeChangeCurrentByOneFromLongPress()V

    .line 854
    iget-object v10, p0, Landroid/widget/NumberPicker;->mPressedStateHelper:Landroid/widget/NumberPicker$PressedStateHelper;

    invoke-virtual {v10}, Landroid/widget/NumberPicker$PressedStateHelper;->cancel()V

    .line 855
    iget-object v9, p0, Landroid/widget/NumberPicker;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 856
    .local v9, velocityTracker:Landroid/view/VelocityTracker;
    const/16 v10, 0x3e8

    iget v11, p0, Landroid/widget/NumberPicker;->mMaximumFlingVelocity:I

    int-to-float v11, v11

    invoke-virtual {v9, v10, v11}, Landroid/view/VelocityTracker;->computeCurrentVelocity(IF)V

    .line 857
    invoke-virtual {v9}, Landroid/view/VelocityTracker;->getYVelocity()F

    move-result v10

    float-to-int v7, v10

    .line 858
    .local v7, initialVelocity:I
    invoke-static {v7}, Ljava/lang/Math;->abs(I)I

    move-result v10

    iget v11, p0, Landroid/widget/NumberPicker;->mMinimumFlingVelocity:I

    if-le v10, v11, :cond_87

    .line 859
    invoke-direct {p0, v7}, Landroid/widget/NumberPicker;->fling(I)V

    .line 860
    const/4 v10, 0x2

    invoke-direct {p0, v10}, Landroid/widget/NumberPicker;->onScrollStateChange(I)V

    .line 887
    :goto_7e
    iget-object v10, p0, Landroid/widget/NumberPicker;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v10}, Landroid/view/VelocityTracker;->recycle()V

    .line 888
    const/4 v10, 0x0

    iput-object v10, p0, Landroid/widget/NumberPicker;->mVelocityTracker:Landroid/view/VelocityTracker;

    goto :goto_22

    .line 862
    :cond_87
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v10

    float-to-int v6, v10

    .line 863
    .local v6, eventY:I
    int-to-float v10, v6

    iget v11, p0, Landroid/widget/NumberPicker;->mLastDownEventY:F

    sub-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Math;->abs(F)F

    move-result v10

    float-to-int v3, v10

    .line 864
    .restart local v3       #deltaMoveY:I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v10

    iget-wide v12, p0, Landroid/widget/NumberPicker;->mLastDownEventTime:J

    sub-long v4, v10, v12

    .line 865
    .local v4, deltaTime:J
    iget v10, p0, Landroid/widget/NumberPicker;->mTouchSlop:I

    if-gt v3, v10, :cond_d9

    invoke-static {}, Landroid/view/ViewConfiguration;->getTapTimeout()I

    move-result v10

    int-to-long v10, v10

    cmp-long v10, v4, v10

    if-gez v10, :cond_d9

    .line 866
    iget-boolean v10, p0, Landroid/widget/NumberPicker;->mShowSoftInputOnTap:Z

    if-eqz v10, :cond_b9

    .line 867
    const/4 v10, 0x0

    iput-boolean v10, p0, Landroid/widget/NumberPicker;->mShowSoftInputOnTap:Z

    .line 868
    invoke-direct {p0}, Landroid/widget/NumberPicker;->showSoftInput()V

    .line 885
    :cond_b4
    :goto_b4
    const/4 v10, 0x0

    invoke-direct {p0, v10}, Landroid/widget/NumberPicker;->onScrollStateChange(I)V

    goto :goto_7e

    .line 870
    :cond_b9
    iget v10, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    div-int v10, v6, v10

    add-int/lit8 v8, v10, -0x1

    .line 872
    .local v8, selectorIndexOffset:I
    if-lez v8, :cond_cc

    .line 873
    const/4 v10, 0x1

    invoke-direct {p0, v10}, Landroid/widget/NumberPicker;->changeValueByOne(Z)V

    .line 874
    iget-object v10, p0, Landroid/widget/NumberPicker;->mPressedStateHelper:Landroid/widget/NumberPicker$PressedStateHelper;

    const/4 v11, 0x1

    invoke-virtual {v10, v11}, Landroid/widget/NumberPicker$PressedStateHelper;->buttonTapped(I)V

    goto :goto_b4

    .line 876
    :cond_cc
    if-gez v8, :cond_b4

    .line 877
    const/4 v10, 0x0

    invoke-direct {p0, v10}, Landroid/widget/NumberPicker;->changeValueByOne(Z)V

    .line 878
    iget-object v10, p0, Landroid/widget/NumberPicker;->mPressedStateHelper:Landroid/widget/NumberPicker$PressedStateHelper;

    const/4 v11, 0x2

    invoke-virtual {v10, v11}, Landroid/widget/NumberPicker$PressedStateHelper;->buttonTapped(I)V

    goto :goto_b4

    .line 883
    .end local v8           #selectorIndexOffset:I
    :cond_d9
    invoke-direct {p0}, Landroid/widget/NumberPicker;->ensureScrollWheelAdjusted()Z

    goto :goto_b4

    .line 832
    nop

    :pswitch_data_de
    .packed-switch 0x1
        :pswitch_55
        :pswitch_24
    .end packed-switch
.end method

.method public scrollBy(II)V
    .registers 7
    .parameter "x"
    .parameter "y"

    .prologue
    const/4 v3, 0x1

    .line 1016
    iget-object v0, p0, Landroid/widget/NumberPicker;->mSelectorIndices:[I

    .line 1017
    .local v0, selectorIndices:[I
    iget-boolean v1, p0, Landroid/widget/NumberPicker;->mWrapSelectorWheel:Z

    if-nez v1, :cond_14

    if-lez p2, :cond_14

    aget v1, v0, v3

    iget v2, p0, Landroid/widget/NumberPicker;->mMinValue:I

    if-gt v1, v2, :cond_14

    .line 1019
    iget v1, p0, Landroid/widget/NumberPicker;->mInitialScrollOffset:I

    iput v1, p0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    .line 1044
    :cond_13
    :goto_13
    return-void

    .line 1022
    :cond_14
    iget-boolean v1, p0, Landroid/widget/NumberPicker;->mWrapSelectorWheel:Z

    if-nez v1, :cond_25

    if-gez p2, :cond_25

    aget v1, v0, v3

    iget v2, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    if-lt v1, v2, :cond_25

    .line 1024
    iget v1, p0, Landroid/widget/NumberPicker;->mInitialScrollOffset:I

    iput v1, p0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    goto :goto_13

    .line 1027
    :cond_25
    iget v1, p0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    add-int/2addr v1, p2

    iput v1, p0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    .line 1028
    :cond_2a
    :goto_2a
    iget v1, p0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    iget v2, p0, Landroid/widget/NumberPicker;->mInitialScrollOffset:I

    sub-int/2addr v1, v2

    iget v2, p0, Landroid/widget/NumberPicker;->mSelectorTextGapHeight:I

    if-le v1, v2, :cond_51

    .line 1029
    iget v1, p0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    iget v2, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    sub-int/2addr v1, v2

    iput v1, p0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    .line 1030
    invoke-direct {p0, v0}, Landroid/widget/NumberPicker;->decrementSelectorIndices([I)V

    .line 1031
    aget v1, v0, v3

    invoke-direct {p0, v1, v3}, Landroid/widget/NumberPicker;->setValueInternal(IZ)V

    .line 1032
    iget-boolean v1, p0, Landroid/widget/NumberPicker;->mWrapSelectorWheel:Z

    if-nez v1, :cond_2a

    aget v1, v0, v3

    iget v2, p0, Landroid/widget/NumberPicker;->mMinValue:I

    if-gt v1, v2, :cond_2a

    .line 1033
    iget v1, p0, Landroid/widget/NumberPicker;->mInitialScrollOffset:I

    iput v1, p0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    goto :goto_2a

    .line 1036
    :cond_51
    :goto_51
    iget v1, p0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    iget v2, p0, Landroid/widget/NumberPicker;->mInitialScrollOffset:I

    sub-int/2addr v1, v2

    iget v2, p0, Landroid/widget/NumberPicker;->mSelectorTextGapHeight:I

    neg-int v2, v2

    if-ge v1, v2, :cond_13

    .line 1037
    iget v1, p0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    iget v2, p0, Landroid/widget/NumberPicker;->mSelectorElementHeight:I

    add-int/2addr v1, v2

    iput v1, p0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    .line 1038
    invoke-direct {p0, v0}, Landroid/widget/NumberPicker;->incrementSelectorIndices([I)V

    .line 1039
    aget v1, v0, v3

    invoke-direct {p0, v1, v3}, Landroid/widget/NumberPicker;->setValueInternal(IZ)V

    .line 1040
    iget-boolean v1, p0, Landroid/widget/NumberPicker;->mWrapSelectorWheel:Z

    if-nez v1, :cond_51

    aget v1, v0, v3

    iget v2, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    if-lt v1, v2, :cond_51

    .line 1041
    iget v1, p0, Landroid/widget/NumberPicker;->mInitialScrollOffset:I

    iput v1, p0, Landroid/widget/NumberPicker;->mCurrentScrollOffset:I

    goto :goto_51
.end method

.method public setDisplayedValues([Ljava/lang/String;)V
    .registers 4
    .parameter "displayedValues"

    .prologue
    .line 1331
    iget-object v0, p0, Landroid/widget/NumberPicker;->mDisplayedValues:[Ljava/lang/String;

    if-ne v0, p1, :cond_5

    .line 1345
    :goto_4
    return-void

    .line 1334
    :cond_5
    iput-object p1, p0, Landroid/widget/NumberPicker;->mDisplayedValues:[Ljava/lang/String;

    .line 1335
    iget-object v0, p0, Landroid/widget/NumberPicker;->mDisplayedValues:[Ljava/lang/String;

    if-eqz v0, :cond_1d

    .line 1337
    iget-object v0, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    const v1, 0x80001

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setRawInputType(I)V

    .line 1342
    :goto_13
    invoke-direct {p0}, Landroid/widget/NumberPicker;->updateInputTextView()Z

    .line 1343
    invoke-direct {p0}, Landroid/widget/NumberPicker;->initializeSelectorWheelIndices()V

    .line 1344
    invoke-direct {p0}, Landroid/widget/NumberPicker;->tryComputeMaxWidth()V

    goto :goto_4

    .line 1340
    :cond_1d
    iget-object v0, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setRawInputType(I)V

    goto :goto_13
.end method

.method public setEnabled(Z)V
    .registers 3
    .parameter "enabled"

    .prologue
    .line 1004
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->setEnabled(Z)V

    .line 1005
    iget-boolean v0, p0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    if-nez v0, :cond_c

    .line 1006
    iget-object v0, p0, Landroid/widget/NumberPicker;->mIncrementButton:Landroid/widget/ImageButton;

    invoke-virtual {v0, p1}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 1008
    :cond_c
    iget-boolean v0, p0, Landroid/widget/NumberPicker;->mHasSelectorWheel:Z

    if-nez v0, :cond_15

    .line 1009
    iget-object v0, p0, Landroid/widget/NumberPicker;->mDecrementButton:Landroid/widget/ImageButton;

    invoke-virtual {v0, p1}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 1011
    :cond_15
    iget-object v0, p0, Landroid/widget/NumberPicker;->mInputText:Landroid/widget/EditText;

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 1012
    return-void
.end method

.method public setFormatter(Landroid/widget/NumberPicker$Formatter;)V
    .registers 3
    .parameter "formatter"

    .prologue
    .line 1081
    iget-object v0, p0, Landroid/widget/NumberPicker;->mFormatter:Landroid/widget/NumberPicker$Formatter;

    if-ne p1, v0, :cond_5

    .line 1087
    :goto_4
    return-void

    .line 1084
    :cond_5
    iput-object p1, p0, Landroid/widget/NumberPicker;->mFormatter:Landroid/widget/NumberPicker$Formatter;

    .line 1085
    invoke-direct {p0}, Landroid/widget/NumberPicker;->initializeSelectorWheelIndices()V

    .line 1086
    invoke-direct {p0}, Landroid/widget/NumberPicker;->updateInputTextView()Z

    goto :goto_4
.end method

.method public setMaxValue(I)V
    .registers 5
    .parameter "maxValue"

    .prologue
    .line 1298
    iget v1, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    if-ne v1, p1, :cond_5

    .line 1314
    :goto_4
    return-void

    .line 1301
    :cond_5
    if-gez p1, :cond_10

    .line 1302
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "maxValue must be >= 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1304
    :cond_10
    iput p1, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    .line 1305
    iget v1, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    iget v2, p0, Landroid/widget/NumberPicker;->mValue:I

    if-ge v1, v2, :cond_1c

    .line 1306
    iget v1, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    iput v1, p0, Landroid/widget/NumberPicker;->mValue:I

    .line 1308
    :cond_1c
    iget v1, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    iget v2, p0, Landroid/widget/NumberPicker;->mMinValue:I

    sub-int/2addr v1, v2

    iget-object v2, p0, Landroid/widget/NumberPicker;->mSelectorIndices:[I

    array-length v2, v2

    if-le v1, v2, :cond_37

    const/4 v0, 0x1

    .line 1309
    .local v0, wrapSelectorWheel:Z
    :goto_27
    invoke-virtual {p0, v0}, Landroid/widget/NumberPicker;->setWrapSelectorWheel(Z)V

    .line 1310
    invoke-direct {p0}, Landroid/widget/NumberPicker;->initializeSelectorWheelIndices()V

    .line 1311
    invoke-direct {p0}, Landroid/widget/NumberPicker;->updateInputTextView()Z

    .line 1312
    invoke-direct {p0}, Landroid/widget/NumberPicker;->tryComputeMaxWidth()V

    .line 1313
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->invalidate()V

    goto :goto_4

    .line 1308
    .end local v0           #wrapSelectorWheel:Z
    :cond_37
    const/4 v0, 0x0

    goto :goto_27
.end method

.method public setMinValue(I)V
    .registers 5
    .parameter "minValue"

    .prologue
    .line 1265
    iget v1, p0, Landroid/widget/NumberPicker;->mMinValue:I

    if-ne v1, p1, :cond_5

    .line 1281
    :goto_4
    return-void

    .line 1268
    :cond_5
    if-gez p1, :cond_10

    .line 1269
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "minValue must be >= 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1271
    :cond_10
    iput p1, p0, Landroid/widget/NumberPicker;->mMinValue:I

    .line 1272
    iget v1, p0, Landroid/widget/NumberPicker;->mMinValue:I

    iget v2, p0, Landroid/widget/NumberPicker;->mValue:I

    if-le v1, v2, :cond_1c

    .line 1273
    iget v1, p0, Landroid/widget/NumberPicker;->mMinValue:I

    iput v1, p0, Landroid/widget/NumberPicker;->mValue:I

    .line 1275
    :cond_1c
    iget v1, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    iget v2, p0, Landroid/widget/NumberPicker;->mMinValue:I

    sub-int/2addr v1, v2

    iget-object v2, p0, Landroid/widget/NumberPicker;->mSelectorIndices:[I

    array-length v2, v2

    if-le v1, v2, :cond_37

    const/4 v0, 0x1

    .line 1276
    .local v0, wrapSelectorWheel:Z
    :goto_27
    invoke-virtual {p0, v0}, Landroid/widget/NumberPicker;->setWrapSelectorWheel(Z)V

    .line 1277
    invoke-direct {p0}, Landroid/widget/NumberPicker;->initializeSelectorWheelIndices()V

    .line 1278
    invoke-direct {p0}, Landroid/widget/NumberPicker;->updateInputTextView()Z

    .line 1279
    invoke-direct {p0}, Landroid/widget/NumberPicker;->tryComputeMaxWidth()V

    .line 1280
    invoke-virtual {p0}, Landroid/widget/NumberPicker;->invalidate()V

    goto :goto_4

    .line 1275
    .end local v0           #wrapSelectorWheel:Z
    :cond_37
    const/4 v0, 0x0

    goto :goto_27
.end method

.method public setOnLongPressUpdateInterval(J)V
    .registers 3
    .parameter "intervalMillis"

    .prologue
    .line 1238
    iput-wide p1, p0, Landroid/widget/NumberPicker;->mLongPressUpdateInterval:J

    .line 1239
    return-void
.end method

.method public setOnScrollListener(Landroid/widget/NumberPicker$OnScrollListener;)V
    .registers 2
    .parameter "onScrollListener"

    .prologue
    .line 1066
    iput-object p1, p0, Landroid/widget/NumberPicker;->mOnScrollListener:Landroid/widget/NumberPicker$OnScrollListener;

    .line 1067
    return-void
.end method

.method public setOnValueChangedListener(Landroid/widget/NumberPicker$OnValueChangeListener;)V
    .registers 2
    .parameter "onValueChangedListener"

    .prologue
    .line 1057
    iput-object p1, p0, Landroid/widget/NumberPicker;->mOnValueChangeListener:Landroid/widget/NumberPicker$OnValueChangeListener;

    .line 1058
    return-void
.end method

.method public setValue(I)V
    .registers 3
    .parameter "value"

    .prologue
    .line 1118
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/widget/NumberPicker;->setValueInternal(IZ)V

    .line 1119
    return-void
.end method

.method public setWrapSelectorWheel(Z)V
    .registers 5
    .parameter "wrapSelectorWheel"

    .prologue
    .line 1221
    iget v1, p0, Landroid/widget/NumberPicker;->mMaxValue:I

    iget v2, p0, Landroid/widget/NumberPicker;->mMinValue:I

    sub-int/2addr v1, v2

    iget-object v2, p0, Landroid/widget/NumberPicker;->mSelectorIndices:[I

    array-length v2, v2

    if-lt v1, v2, :cond_16

    const/4 v0, 0x1

    .line 1222
    .local v0, wrappingAllowed:Z
    :goto_b
    if-eqz p1, :cond_f

    if-eqz v0, :cond_15

    :cond_f
    iget-boolean v1, p0, Landroid/widget/NumberPicker;->mWrapSelectorWheel:Z

    if-eq p1, v1, :cond_15

    .line 1223
    iput-boolean p1, p0, Landroid/widget/NumberPicker;->mWrapSelectorWheel:Z

    .line 1225
    :cond_15
    return-void

    .line 1221
    .end local v0           #wrappingAllowed:Z
    :cond_16
    const/4 v0, 0x0

    goto :goto_b
.end method
