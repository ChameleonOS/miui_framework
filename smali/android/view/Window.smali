.class public abstract Landroid/view/Window;
.super Ljava/lang/Object;
.source "Window.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/Window$LocalWindowManager;,
        Landroid/view/Window$Callback;
    }
.end annotation


# static fields
.field protected static final DEFAULT_FEATURES:I = 0x41

.field public static final FEATURE_ACTION_BAR:I = 0x8

.field public static final FEATURE_ACTION_BAR_OVERLAY:I = 0x9

.field public static final FEATURE_ACTION_MODE_OVERLAY:I = 0xa

.field public static final FEATURE_CONTEXT_MENU:I = 0x6

.field public static final FEATURE_CUSTOM_TITLE:I = 0x7

.field public static final FEATURE_INDETERMINATE_PROGRESS:I = 0x5

.field public static final FEATURE_LEFT_ICON:I = 0x3

.field public static final FEATURE_NO_TITLE:I = 0x1

.field public static final FEATURE_OPTIONS_PANEL:I = 0x0

.field public static final FEATURE_PROGRESS:I = 0x2

.field public static final FEATURE_RIGHT_ICON:I = 0x4

.field public static final ID_ANDROID_CONTENT:I = 0x1020002

.field public static final PROGRESS_END:I = 0x2710

.field public static final PROGRESS_INDETERMINATE_OFF:I = -0x4

.field public static final PROGRESS_INDETERMINATE_ON:I = -0x3

.field public static final PROGRESS_SECONDARY_END:I = 0x7530

.field public static final PROGRESS_SECONDARY_START:I = 0x4e20

.field public static final PROGRESS_START:I = 0x0

.field public static final PROGRESS_VISIBILITY_OFF:I = -0x2

.field public static final PROGRESS_VISIBILITY_ON:I = -0x1


# instance fields
.field private mActiveChild:Landroid/view/Window;

.field private mAppName:Ljava/lang/String;

.field private mAppToken:Landroid/os/IBinder;

.field private mCallback:Landroid/view/Window$Callback;

.field private mCloseOnTouchOutside:Z

.field private mContainer:Landroid/view/Window;

.field private final mContext:Landroid/content/Context;

.field private mDefaultWindowFormat:I

.field private mDestroyed:Z

.field private mFeatures:I

.field private mForcedWindowFlags:I

.field private mHasChildren:Z

.field private mHasSoftInputMode:Z

.field private mHaveDimAmount:Z

.field private mHaveWindowFormat:Z

.field private mIsActive:Z

.field private mLocalFeatures:I

.field private mSetCloseOnTouchOutside:Z

.field private final mWindowAttributes:Landroid/view/WindowManager$LayoutParams;

.field private mWindowManager:Landroid/view/WindowManager;

.field private mWindowStyle:Landroid/content/res/TypedArray;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 4
    .parameter "context"

    .prologue
    const/16 v0, 0x41

    const/4 v1, 0x0

    .line 383
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 131
    iput-boolean v1, p0, Landroid/view/Window;->mIsActive:Z

    .line 132
    iput-boolean v1, p0, Landroid/view/Window;->mHasChildren:Z

    .line 133
    iput-boolean v1, p0, Landroid/view/Window;->mCloseOnTouchOutside:Z

    .line 134
    iput-boolean v1, p0, Landroid/view/Window;->mSetCloseOnTouchOutside:Z

    .line 135
    iput v1, p0, Landroid/view/Window;->mForcedWindowFlags:I

    .line 137
    iput v0, p0, Landroid/view/Window;->mFeatures:I

    .line 138
    iput v0, p0, Landroid/view/Window;->mLocalFeatures:I

    .line 140
    iput-boolean v1, p0, Landroid/view/Window;->mHaveWindowFormat:Z

    .line 141
    iput-boolean v1, p0, Landroid/view/Window;->mHaveDimAmount:Z

    .line 142
    const/4 v0, -0x1

    iput v0, p0, Landroid/view/Window;->mDefaultWindowFormat:I

    .line 144
    iput-boolean v1, p0, Landroid/view/Window;->mHasSoftInputMode:Z

    .line 149
    new-instance v0, Landroid/view/WindowManager$LayoutParams;

    invoke-direct {v0}, Landroid/view/WindowManager$LayoutParams;-><init>()V

    iput-object v0, p0, Landroid/view/Window;->mWindowAttributes:Landroid/view/WindowManager$LayoutParams;

    .line 384
    iput-object p1, p0, Landroid/view/Window;->mContext:Landroid/content/Context;

    .line 385
    return-void
.end method

.method static synthetic access$000(Landroid/view/Window;)Landroid/content/Context;
    .registers 2
    .parameter "x0"

    .prologue
    .line 45
    iget-object v0, p0, Landroid/view/Window;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$100(Landroid/view/Window;)Ljava/lang/String;
    .registers 2
    .parameter "x0"

    .prologue
    .line 45
    iget-object v0, p0, Landroid/view/Window;->mAppName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Landroid/view/Window;)Landroid/view/Window;
    .registers 2
    .parameter "x0"

    .prologue
    .line 45
    iget-object v0, p0, Landroid/view/Window;->mContainer:Landroid/view/Window;

    return-object v0
.end method

.method static synthetic access$300(Landroid/view/Window;)Landroid/os/IBinder;
    .registers 2
    .parameter "x0"

    .prologue
    .line 45
    iget-object v0, p0, Landroid/view/Window;->mAppToken:Landroid/os/IBinder;

    return-object v0
.end method

.method static getCompatInfo(Landroid/content/Context;)Landroid/view/CompatibilityInfoHolder;
    .registers 3
    .parameter "context"

    .prologue
    .line 481
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/app/Application;

    .line 482
    .local v0, app:Landroid/app/Application;
    if-eqz v0, :cond_d

    iget-object v1, v0, Landroid/app/Application;->mLoadedApk:Landroid/app/LoadedApk;

    iget-object v1, v1, Landroid/app/LoadedApk;->mCompatibilityInfo:Landroid/view/CompatibilityInfoHolder;

    :goto_c
    return-object v1

    :cond_d
    new-instance v1, Landroid/view/CompatibilityInfoHolder;

    invoke-direct {v1}, Landroid/view/CompatibilityInfoHolder;-><init>()V

    goto :goto_c
.end method

.method private isOutOfBounds(Landroid/content/Context;Landroid/view/MotionEvent;)Z
    .registers 8
    .parameter "context"
    .parameter "event"

    .prologue
    .line 851
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v4

    float-to-int v2, v4

    .line 852
    .local v2, x:I
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    float-to-int v3, v4

    .line 853
    .local v3, y:I
    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/ViewConfiguration;->getScaledWindowTouchSlop()I

    move-result v1

    .line 854
    .local v1, slop:I
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 855
    .local v0, decorView:Landroid/view/View;
    neg-int v4, v1

    if-lt v2, v4, :cond_2a

    neg-int v4, v1

    if-lt v3, v4, :cond_2a

    invoke-virtual {v0}, Landroid/view/View;->getWidth()I

    move-result v4

    add-int/2addr v4, v1

    if-gt v2, v4, :cond_2a

    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v4

    add-int/2addr v4, v1

    if-le v3, v4, :cond_2c

    :cond_2a
    const/4 v4, 0x1

    :goto_2b
    return v4

    :cond_2c
    const/4 v4, 0x0

    goto :goto_2b
.end method


# virtual methods
.method public abstract addContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
.end method

.method public addFlags(I)V
    .registers 2
    .parameter "flags"

    .prologue
    .line 723
    invoke-virtual {p0, p1, p1}, Landroid/view/Window;->setFlags(II)V

    .line 724
    return-void
.end method

.method public abstract alwaysReadCloseOnTouchAttr()V
.end method

.method public clearFlags(I)V
    .registers 3
    .parameter "flags"

    .prologue
    .line 733
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1}, Landroid/view/Window;->setFlags(II)V

    .line 734
    return-void
.end method

.method public abstract closeAllPanels()V
.end method

.method public abstract closePanel(I)V
.end method

.method public final destroy()V
    .registers 2

    .prologue
    .line 444
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/Window;->mDestroyed:Z

    .line 445
    return-void
.end method

.method public findViewById(I)Landroid/view/View;
    .registers 3
    .parameter "id"

    .prologue
    .line 911
    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public final getAttributes()Landroid/view/WindowManager$LayoutParams;
    .registers 2

    .prologue
    .line 806
    iget-object v0, p0, Landroid/view/Window;->mWindowAttributes:Landroid/view/WindowManager$LayoutParams;

    return-object v0
.end method

.method public final getCallback()Landroid/view/Window$Callback;
    .registers 2

    .prologue
    .line 575
    iget-object v0, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    return-object v0
.end method

.method public final getContainer()Landroid/view/Window;
    .registers 2

    .prologue
    .line 435
    iget-object v0, p0, Landroid/view/Window;->mContainer:Landroid/view/Window;

    return-object v0
.end method

.method public final getContext()Landroid/content/Context;
    .registers 2

    .prologue
    .line 394
    iget-object v0, p0, Landroid/view/Window;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public abstract getCurrentFocus()Landroid/view/View;
.end method

.method public abstract getDecorView()Landroid/view/View;
.end method

.method protected final getFeatures()I
    .registers 2

    .prologue
    .line 1185
    iget v0, p0, Landroid/view/Window;->mFeatures:I

    return v0
.end method

.method protected final getForcedWindowFlags()I
    .registers 2

    .prologue
    .line 814
    iget v0, p0, Landroid/view/Window;->mForcedWindowFlags:I

    return v0
.end method

.method public abstract getLayoutInflater()Landroid/view/LayoutInflater;
.end method

.method protected final getLocalFeatures()I
    .registers 2

    .prologue
    .line 1207
    iget v0, p0, Landroid/view/Window;->mLocalFeatures:I

    return v0
.end method

.method public abstract getVolumeControlStream()I
.end method

.method public getWindowManager()Landroid/view/WindowManager;
    .registers 2

    .prologue
    .line 558
    iget-object v0, p0, Landroid/view/Window;->mWindowManager:Landroid/view/WindowManager;

    return-object v0
.end method

.method public final getWindowStyle()Landroid/content/res/TypedArray;
    .registers 3

    .prologue
    .line 402
    monitor-enter p0

    .line 403
    :try_start_1
    iget-object v0, p0, Landroid/view/Window;->mWindowStyle:Landroid/content/res/TypedArray;

    if-nez v0, :cond_f

    .line 404
    iget-object v0, p0, Landroid/view/Window;->mContext:Landroid/content/Context;

    sget-object v1, Lcom/android/internal/R$styleable;->Window:[I

    invoke-virtual {v0, v1}, Landroid/content/Context;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    move-result-object v0

    iput-object v0, p0, Landroid/view/Window;->mWindowStyle:Landroid/content/res/TypedArray;

    .line 407
    :cond_f
    iget-object v0, p0, Landroid/view/Window;->mWindowStyle:Landroid/content/res/TypedArray;

    monitor-exit p0

    return-object v0

    .line 408
    :catchall_13
    move-exception v0

    monitor-exit p0
    :try_end_15
    .catchall {:try_start_1 .. :try_end_15} :catchall_13

    throw v0
.end method

.method public final hasChildren()Z
    .registers 2

    .prologue
    .line 439
    iget-boolean v0, p0, Landroid/view/Window;->mHasChildren:Z

    return v0
.end method

.method public hasFeature(I)Z
    .registers 5
    .parameter "feature"

    .prologue
    const/4 v0, 0x1

    .line 1195
    invoke-virtual {p0}, Landroid/view/Window;->getFeatures()I

    move-result v1

    shl-int v2, v0, p1

    and-int/2addr v1, v2

    if-eqz v1, :cond_b

    :goto_a
    return v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method protected final hasSoftInputMode()Z
    .registers 2

    .prologue
    .line 821
    iget-boolean v0, p0, Landroid/view/Window;->mHasSoftInputMode:Z

    return v0
.end method

.method protected haveDimAmount()Z
    .registers 2

    .prologue
    .line 1233
    iget-boolean v0, p0, Landroid/view/Window;->mHaveDimAmount:Z

    return v0
.end method

.method public abstract invalidatePanelMenu(I)V
.end method

.method public final isActive()Z
    .registers 2

    .prologue
    .line 899
    iget-boolean v0, p0, Landroid/view/Window;->mIsActive:Z

    return v0
.end method

.method public final isDestroyed()Z
    .registers 2

    .prologue
    .line 449
    iget-boolean v0, p0, Landroid/view/Window;->mDestroyed:Z

    return v0
.end method

.method public abstract isFloating()Z
.end method

.method public abstract isShortcutKey(ILandroid/view/KeyEvent;)Z
.end method

.method public final makeActive()V
    .registers 3

    .prologue
    .line 887
    iget-object v0, p0, Landroid/view/Window;->mContainer:Landroid/view/Window;

    if-eqz v0, :cond_15

    .line 888
    iget-object v0, p0, Landroid/view/Window;->mContainer:Landroid/view/Window;

    iget-object v0, v0, Landroid/view/Window;->mActiveChild:Landroid/view/Window;

    if-eqz v0, :cond_11

    .line 889
    iget-object v0, p0, Landroid/view/Window;->mContainer:Landroid/view/Window;

    iget-object v0, v0, Landroid/view/Window;->mActiveChild:Landroid/view/Window;

    const/4 v1, 0x0

    iput-boolean v1, v0, Landroid/view/Window;->mIsActive:Z

    .line 891
    :cond_11
    iget-object v0, p0, Landroid/view/Window;->mContainer:Landroid/view/Window;

    iput-object p0, v0, Landroid/view/Window;->mActiveChild:Landroid/view/Window;

    .line 893
    :cond_15
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/Window;->mIsActive:Z

    .line 894
    invoke-virtual {p0}, Landroid/view/Window;->onActive()V

    .line 895
    return-void
.end method

.method protected abstract onActive()V
.end method

.method public abstract onConfigurationChanged(Landroid/content/res/Configuration;)V
.end method

.method public abstract openPanel(ILandroid/view/KeyEvent;)V
.end method

.method public abstract peekDecorView()Landroid/view/View;
.end method

.method public abstract performContextMenuIdentifierAction(II)Z
.end method

.method public abstract performPanelIdentifierAction(III)Z
.end method

.method public abstract performPanelShortcut(IILandroid/view/KeyEvent;I)Z
.end method

.method protected removeFeature(I)V
    .registers 5
    .parameter "featureId"

    .prologue
    .line 881
    const/4 v1, 0x1

    shl-int v0, v1, p1

    .line 882
    .local v0, flag:I
    iget v1, p0, Landroid/view/Window;->mFeatures:I

    xor-int/lit8 v2, v0, -0x1

    and-int/2addr v1, v2

    iput v1, p0, Landroid/view/Window;->mFeatures:I

    .line 883
    iget v1, p0, Landroid/view/Window;->mLocalFeatures:I

    iget-object v2, p0, Landroid/view/Window;->mContainer:Landroid/view/Window;

    if-eqz v2, :cond_17

    iget-object v2, p0, Landroid/view/Window;->mContainer:Landroid/view/Window;

    iget v2, v2, Landroid/view/Window;->mFeatures:I

    xor-int/lit8 v2, v2, -0x1

    and-int/2addr v0, v2

    .end local v0           #flag:I
    :cond_17
    xor-int/lit8 v2, v0, -0x1

    and-int/2addr v1, v2

    iput v1, p0, Landroid/view/Window;->mLocalFeatures:I

    .line 884
    return-void
.end method

.method public requestFeature(I)Z
    .registers 6
    .parameter "featureId"

    .prologue
    const/4 v2, 0x1

    .line 871
    shl-int v0, v2, p1

    .line 872
    .local v0, flag:I
    iget v1, p0, Landroid/view/Window;->mFeatures:I

    or-int/2addr v1, v0

    iput v1, p0, Landroid/view/Window;->mFeatures:I

    .line 873
    iget v3, p0, Landroid/view/Window;->mLocalFeatures:I

    iget-object v1, p0, Landroid/view/Window;->mContainer:Landroid/view/Window;

    if-eqz v1, :cond_1f

    iget-object v1, p0, Landroid/view/Window;->mContainer:Landroid/view/Window;

    iget v1, v1, Landroid/view/Window;->mFeatures:I

    xor-int/lit8 v1, v1, -0x1

    and-int/2addr v1, v0

    :goto_15
    or-int/2addr v1, v3

    iput v1, p0, Landroid/view/Window;->mLocalFeatures:I

    .line 874
    iget v1, p0, Landroid/view/Window;->mFeatures:I

    and-int/2addr v1, v0

    if-eqz v1, :cond_21

    move v1, v2

    :goto_1e
    return v1

    :cond_1f
    move v1, v0

    .line 873
    goto :goto_15

    .line 874
    :cond_21
    const/4 v1, 0x0

    goto :goto_1e
.end method

.method public abstract restoreHierarchyState(Landroid/os/Bundle;)V
.end method

.method public abstract saveHierarchyState()Landroid/os/Bundle;
.end method

.method public setAttributes(Landroid/view/WindowManager$LayoutParams;)V
    .registers 4
    .parameter "a"

    .prologue
    .line 793
    iget-object v0, p0, Landroid/view/Window;->mWindowAttributes:Landroid/view/WindowManager$LayoutParams;

    invoke-virtual {v0, p1}, Landroid/view/WindowManager$LayoutParams;->copyFrom(Landroid/view/WindowManager$LayoutParams;)I

    .line 794
    iget-object v0, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    if-eqz v0, :cond_10

    .line 795
    iget-object v0, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    iget-object v1, p0, Landroid/view/Window;->mWindowAttributes:Landroid/view/WindowManager$LayoutParams;

    invoke-interface {v0, v1}, Landroid/view/Window$Callback;->onWindowAttributesChanged(Landroid/view/WindowManager$LayoutParams;)V

    .line 797
    :cond_10
    return-void
.end method

.method public abstract setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
.end method

.method public setBackgroundDrawableResource(I)V
    .registers 3
    .parameter "resid"

    .prologue
    .line 1022
    iget-object v0, p0, Landroid/view/Window;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1023
    return-void
.end method

.method public setCallback(Landroid/view/Window$Callback;)V
    .registers 2
    .parameter "callback"

    .prologue
    .line 568
    iput-object p1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    .line 569
    return-void
.end method

.method public abstract setChildDrawable(ILandroid/graphics/drawable/Drawable;)V
.end method

.method public abstract setChildInt(II)V
.end method

.method public setCloseOnTouchOutside(Z)V
    .registers 3
    .parameter "close"

    .prologue
    .line 826
    iput-boolean p1, p0, Landroid/view/Window;->mCloseOnTouchOutside:Z

    .line 827
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/Window;->mSetCloseOnTouchOutside:Z

    .line 828
    return-void
.end method

.method public setCloseOnTouchOutsideIfNotSet(Z)V
    .registers 3
    .parameter "close"

    .prologue
    .line 832
    iget-boolean v0, p0, Landroid/view/Window;->mSetCloseOnTouchOutside:Z

    if-nez v0, :cond_9

    .line 833
    iput-boolean p1, p0, Landroid/view/Window;->mCloseOnTouchOutside:Z

    .line 834
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/Window;->mSetCloseOnTouchOutside:Z

    .line 836
    :cond_9
    return-void
.end method

.method public setContainer(Landroid/view/Window;)V
    .registers 3
    .parameter "container"

    .prologue
    .line 419
    iput-object p1, p0, Landroid/view/Window;->mContainer:Landroid/view/Window;

    .line 420
    if-eqz p1, :cond_13

    .line 422
    iget v0, p0, Landroid/view/Window;->mFeatures:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Landroid/view/Window;->mFeatures:I

    .line 423
    iget v0, p0, Landroid/view/Window;->mLocalFeatures:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Landroid/view/Window;->mLocalFeatures:I

    .line 424
    const/4 v0, 0x1

    iput-boolean v0, p1, Landroid/view/Window;->mHasChildren:Z

    .line 426
    :cond_13
    return-void
.end method

.method public abstract setContentView(I)V
.end method

.method public abstract setContentView(Landroid/view/View;)V
.end method

.method public abstract setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
.end method

.method protected setDefaultWindowFormat(I)V
    .registers 4
    .parameter "format"

    .prologue
    .line 1221
    iput p1, p0, Landroid/view/Window;->mDefaultWindowFormat:I

    .line 1222
    iget-boolean v1, p0, Landroid/view/Window;->mHaveWindowFormat:Z

    if-nez v1, :cond_15

    .line 1223
    invoke-virtual {p0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 1224
    .local v0, attrs:Landroid/view/WindowManager$LayoutParams;
    iput p1, v0, Landroid/view/WindowManager$LayoutParams;->format:I

    .line 1225
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    if-eqz v1, :cond_15

    .line 1226
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    invoke-interface {v1, v0}, Landroid/view/Window$Callback;->onWindowAttributesChanged(Landroid/view/WindowManager$LayoutParams;)V

    .line 1229
    .end local v0           #attrs:Landroid/view/WindowManager$LayoutParams;
    :cond_15
    return-void
.end method

.method public setDimAmount(F)V
    .registers 4
    .parameter "amount"

    .prologue
    .line 774
    invoke-virtual {p0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 775
    .local v0, attrs:Landroid/view/WindowManager$LayoutParams;
    iput p1, v0, Landroid/view/WindowManager$LayoutParams;->dimAmount:F

    .line 776
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/view/Window;->mHaveDimAmount:Z

    .line 777
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    if-eqz v1, :cond_12

    .line 778
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    invoke-interface {v1, v0}, Landroid/view/Window$Callback;->onWindowAttributesChanged(Landroid/view/WindowManager$LayoutParams;)V

    .line 780
    :cond_12
    return-void
.end method

.method public abstract setFeatureDrawable(ILandroid/graphics/drawable/Drawable;)V
.end method

.method public abstract setFeatureDrawableAlpha(II)V
.end method

.method public abstract setFeatureDrawableResource(II)V
.end method

.method public abstract setFeatureDrawableUri(ILandroid/net/Uri;)V
.end method

.method public abstract setFeatureInt(II)V
.end method

.method public setFlags(II)V
    .registers 6
    .parameter "flags"
    .parameter "mask"

    .prologue
    .line 754
    invoke-virtual {p0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 755
    .local v0, attrs:Landroid/view/WindowManager$LayoutParams;
    iget v1, v0, Landroid/view/WindowManager$LayoutParams;->flags:I

    xor-int/lit8 v2, p2, -0x1

    and-int/2addr v1, v2

    and-int v2, p1, p2

    or-int/2addr v1, v2

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->flags:I

    .line 756
    const/high16 v1, 0x800

    and-int/2addr v1, p2

    if-eqz v1, :cond_19

    .line 757
    iget v1, v0, Landroid/view/WindowManager$LayoutParams;->privateFlags:I

    or-int/lit8 v1, v1, 0x8

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->privateFlags:I

    .line 759
    :cond_19
    iget v1, p0, Landroid/view/Window;->mForcedWindowFlags:I

    or-int/2addr v1, p2

    iput v1, p0, Landroid/view/Window;->mForcedWindowFlags:I

    .line 760
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    if-eqz v1, :cond_27

    .line 761
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    invoke-interface {v1, v0}, Landroid/view/Window$Callback;->onWindowAttributesChanged(Landroid/view/WindowManager$LayoutParams;)V

    .line 763
    :cond_27
    return-void
.end method

.method public setFormat(I)V
    .registers 4
    .parameter "format"

    .prologue
    .line 668
    invoke-virtual {p0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 669
    .local v0, attrs:Landroid/view/WindowManager$LayoutParams;
    if-eqz p1, :cond_15

    .line 670
    iput p1, v0, Landroid/view/WindowManager$LayoutParams;->format:I

    .line 671
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/view/Window;->mHaveWindowFormat:Z

    .line 676
    :goto_b
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    if-eqz v1, :cond_14

    .line 677
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    invoke-interface {v1, v0}, Landroid/view/Window$Callback;->onWindowAttributesChanged(Landroid/view/WindowManager$LayoutParams;)V

    .line 679
    :cond_14
    return-void

    .line 673
    :cond_15
    iget v1, p0, Landroid/view/Window;->mDefaultWindowFormat:I

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->format:I

    .line 674
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/view/Window;->mHaveWindowFormat:Z

    goto :goto_b
.end method

.method public setGravity(I)V
    .registers 4
    .parameter "gravity"

    .prologue
    .line 635
    invoke-virtual {p0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 636
    .local v0, attrs:Landroid/view/WindowManager$LayoutParams;
    iput p1, v0, Landroid/view/WindowManager$LayoutParams;->gravity:I

    .line 637
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    if-eqz v1, :cond_f

    .line 638
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    invoke-interface {v1, v0}, Landroid/view/Window$Callback;->onWindowAttributesChanged(Landroid/view/WindowManager$LayoutParams;)V

    .line 640
    :cond_f
    return-void
.end method

.method public setLayout(II)V
    .registers 5
    .parameter "width"
    .parameter "height"

    .prologue
    .line 615
    invoke-virtual {p0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 616
    .local v0, attrs:Landroid/view/WindowManager$LayoutParams;
    iput p1, v0, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 617
    iput p2, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 618
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    if-eqz v1, :cond_11

    .line 619
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    invoke-interface {v1, v0}, Landroid/view/Window$Callback;->onWindowAttributesChanged(Landroid/view/WindowManager$LayoutParams;)V

    .line 621
    :cond_11
    return-void
.end method

.method public setSoftInputMode(I)V
    .registers 4
    .parameter "mode"

    .prologue
    .line 704
    invoke-virtual {p0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 705
    .local v0, attrs:Landroid/view/WindowManager$LayoutParams;
    if-eqz p1, :cond_15

    .line 706
    iput p1, v0, Landroid/view/WindowManager$LayoutParams;->softInputMode:I

    .line 707
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/view/Window;->mHasSoftInputMode:Z

    .line 711
    :goto_b
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    if-eqz v1, :cond_14

    .line 712
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    invoke-interface {v1, v0}, Landroid/view/Window$Callback;->onWindowAttributesChanged(Landroid/view/WindowManager$LayoutParams;)V

    .line 714
    :cond_14
    return-void

    .line 709
    :cond_15
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/view/Window;->mHasSoftInputMode:Z

    goto :goto_b
.end method

.method public abstract setTitle(Ljava/lang/CharSequence;)V
.end method

.method public abstract setTitleColor(I)V
.end method

.method public setType(I)V
    .registers 4
    .parameter "type"

    .prologue
    .line 649
    invoke-virtual {p0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 650
    .local v0, attrs:Landroid/view/WindowManager$LayoutParams;
    iput p1, v0, Landroid/view/WindowManager$LayoutParams;->type:I

    .line 651
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    if-eqz v1, :cond_f

    .line 652
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    invoke-interface {v1, v0}, Landroid/view/Window$Callback;->onWindowAttributesChanged(Landroid/view/WindowManager$LayoutParams;)V

    .line 654
    :cond_f
    return-void
.end method

.method public setUiOptions(I)V
    .registers 2
    .parameter "uiOptions"

    .prologue
    .line 1261
    return-void
.end method

.method public setUiOptions(II)V
    .registers 3
    .parameter "uiOptions"
    .parameter "mask"

    .prologue
    .line 1269
    return-void
.end method

.method public abstract setVolumeControlStream(I)V
.end method

.method public setWindowAnimations(I)V
    .registers 4
    .parameter "resId"

    .prologue
    .line 689
    invoke-virtual {p0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 690
    .local v0, attrs:Landroid/view/WindowManager$LayoutParams;
    iput p1, v0, Landroid/view/WindowManager$LayoutParams;->windowAnimations:I

    .line 691
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    if-eqz v1, :cond_f

    .line 692
    iget-object v1, p0, Landroid/view/Window;->mCallback:Landroid/view/Window$Callback;

    invoke-interface {v1, v0}, Landroid/view/Window$Callback;->onWindowAttributesChanged(Landroid/view/WindowManager$LayoutParams;)V

    .line 694
    :cond_f
    return-void
.end method

.method public setWindowManager(Landroid/view/WindowManager;Landroid/os/IBinder;Ljava/lang/String;)V
    .registers 5
    .parameter "wm"
    .parameter "appToken"
    .parameter "appName"

    .prologue
    .line 460
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Landroid/view/Window;->setWindowManager(Landroid/view/WindowManager;Landroid/os/IBinder;Ljava/lang/String;Z)V

    .line 461
    return-void
.end method

.method public setWindowManager(Landroid/view/WindowManager;Landroid/os/IBinder;Ljava/lang/String;Z)V
    .registers 6
    .parameter "wm"
    .parameter "appToken"
    .parameter "appName"
    .parameter "hardwareAccelerated"

    .prologue
    .line 472
    iput-object p2, p0, Landroid/view/Window;->mAppToken:Landroid/os/IBinder;

    .line 473
    iput-object p3, p0, Landroid/view/Window;->mAppName:Ljava/lang/String;

    .line 474
    if-nez p1, :cond_a

    .line 475
    invoke-static {}, Landroid/view/WindowManagerImpl;->getDefault()Landroid/view/WindowManagerImpl;

    move-result-object p1

    .line 477
    :cond_a
    new-instance v0, Landroid/view/Window$LocalWindowManager;

    invoke-direct {v0, p0, p1, p4}, Landroid/view/Window$LocalWindowManager;-><init>(Landroid/view/Window;Landroid/view/WindowManager;Z)V

    iput-object v0, p0, Landroid/view/Window;->mWindowManager:Landroid/view/WindowManager;

    .line 478
    return-void
.end method

.method public shouldCloseOnTouch(Landroid/content/Context;Landroid/view/MotionEvent;)Z
    .registers 4
    .parameter "context"
    .parameter "event"

    .prologue
    .line 843
    iget-boolean v0, p0, Landroid/view/Window;->mCloseOnTouchOutside:Z

    if-eqz v0, :cond_18

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_18

    invoke-direct {p0, p1, p2}, Landroid/view/Window;->isOutOfBounds(Landroid/content/Context;Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_18

    invoke-virtual {p0}, Landroid/view/Window;->peekDecorView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_18

    .line 845
    const/4 v0, 0x1

    .line 847
    :goto_17
    return v0

    :cond_18
    const/4 v0, 0x0

    goto :goto_17
.end method

.method public abstract superDispatchGenericMotionEvent(Landroid/view/MotionEvent;)Z
.end method

.method public abstract superDispatchKeyEvent(Landroid/view/KeyEvent;)Z
.end method

.method public abstract superDispatchKeyShortcutEvent(Landroid/view/KeyEvent;)Z
.end method

.method public abstract superDispatchTouchEvent(Landroid/view/MotionEvent;)Z
.end method

.method public abstract superDispatchTrackballEvent(Landroid/view/MotionEvent;)Z
.end method

.method public abstract takeInputQueue(Landroid/view/InputQueue$Callback;)V
.end method

.method public abstract takeKeyEvents(Z)V
.end method

.method public abstract takeSurface(Landroid/view/SurfaceHolder$Callback2;)V
.end method

.method public abstract togglePanel(ILandroid/view/KeyEvent;)V
.end method
