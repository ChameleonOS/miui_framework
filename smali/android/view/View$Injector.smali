.class Landroid/view/View$Injector;
.super Ljava/lang/Object;
.source "View.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Injector"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static isHapticEnabledExplictly(Landroid/view/View;I)Z
    .registers 3
    .parameter "view"
    .parameter "flags"

    .prologue
    and-int/lit8 v0, p1, 0x4

    if-eqz v0, :cond_a

    iget-boolean v0, p0, Landroid/view/View;->mHapticEnabledExplicitly:Z

    if-nez v0, :cond_a

    const/4 v0, 0x0

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x1

    goto :goto_9
.end method

.method static performHapticFeedbackOnDown(Landroid/view/View;)V
    .registers 3
    .parameter "view"

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x4

    invoke-virtual {p0, v0, v1}, Landroid/view/View;->performHapticFeedback(II)Z

    return-void
.end method

.method static performHapticFeedbackOnRelease(Landroid/view/View;)V
    .registers 3
    .parameter "view"

    .prologue
    const/4 v0, 0x2

    const/4 v1, 0x4

    invoke-virtual {p0, v0, v1}, Landroid/view/View;->performHapticFeedback(II)Z

    return-void
.end method
