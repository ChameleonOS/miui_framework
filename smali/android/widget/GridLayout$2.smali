.class final Landroid/widget/GridLayout$2;
.super Landroid/widget/GridLayout$Alignment;
.source "GridLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/GridLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/widget/GridLayout$Alignment;-><init>()V

    return-void
.end method


# virtual methods
.method public getAlignmentValue(Landroid/view/View;II)I
    .registers 5
    .parameter "view"
    .parameter "viewSize"
    .parameter "mode"

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method getGravityOffset(Landroid/view/View;I)I
    .registers 4
    .parameter "view"
    .parameter "cellDelta"

    .prologue
    const/4 v0, 0x0

    return v0
.end method
