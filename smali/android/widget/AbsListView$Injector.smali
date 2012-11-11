.class Landroid/widget/AbsListView$Injector;
.super Ljava/lang/Object;
.source "AbsListView.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/AbsListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Injector"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/AbsListView$Injector$ChildSequenceStateTaggingListener;
    }
.end annotation


# static fields
.field static mChildSequenceStateTaggingListener:Landroid/widget/AbsListView$Injector$ChildSequenceStateTaggingListener;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 121
    new-instance v0, Landroid/widget/AbsListView$Injector$ChildSequenceStateTaggingListener;

    invoke-direct {v0}, Landroid/widget/AbsListView$Injector$ChildSequenceStateTaggingListener;-><init>()V

    sput-object v0, Landroid/widget/AbsListView$Injector;->mChildSequenceStateTaggingListener:Landroid/widget/AbsListView$Injector$ChildSequenceStateTaggingListener;

    return-void
.end method

.method constructor <init>()V
    .registers 1

    .prologue
    .line 120
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 131
    return-void
.end method

.method static isOutOfTouchRange(Landroid/widget/AbsListView;Landroid/view/MotionEvent;)Z
    .registers 5
    .parameter "alv"
    .parameter "ev"

    .prologue
    .line 124
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    iget v1, p0, Landroid/widget/AbsListView;->mTouchPaddingLeft:I

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-ltz v0, :cond_1b

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    invoke-virtual {p0}, Landroid/widget/AbsListView;->getWidth()I

    move-result v1

    iget v2, p0, Landroid/widget/AbsListView;->mTouchPaddingRight:I

    sub-int/2addr v1, v2

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_1d

    .line 126
    :cond_1b
    const/4 v0, 0x1

    .line 128
    :goto_1c
    return v0

    :cond_1d
    const/4 v0, 0x0

    goto :goto_1c
.end method

.method static setChildSequenceStateTaggingListener(Landroid/widget/AbsListView;)V
    .registers 2
    .parameter "list"

    .prologue
    .line 145
    sget-object v0, Landroid/widget/AbsListView$Injector;->mChildSequenceStateTaggingListener:Landroid/widget/AbsListView$Injector$ChildSequenceStateTaggingListener;

    invoke-virtual {p0, v0}, Landroid/widget/AbsListView;->setChildSequenceStateTaggingListener(Landroid/view/ViewGroup$ChildSequenceStateTaggingListener;)V

    .line 146
    return-void
.end method
