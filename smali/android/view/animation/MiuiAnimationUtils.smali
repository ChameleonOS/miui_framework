.class public Landroid/view/animation/MiuiAnimationUtils;
.super Ljava/lang/Object;
.source "MiuiAnimationUtils.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static clone(Landroid/view/animation/Animation;)Landroid/view/animation/Animation;
    .registers 3
    .parameter "animation"

    .prologue
    const/4 v0, 0x0

    .local v0, result:Landroid/view/animation/Animation;
    :try_start_1
    invoke-virtual {p0}, Landroid/view/animation/Animation;->clone()Landroid/view/animation/Animation;
    :try_end_4
    .catch Ljava/lang/CloneNotSupportedException; {:try_start_1 .. :try_end_4} :catch_6

    move-result-object v0

    :goto_5
    return-object v0

    :catch_6
    move-exception v1

    goto :goto_5
.end method
