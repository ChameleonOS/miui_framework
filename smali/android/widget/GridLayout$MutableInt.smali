.class final Landroid/widget/GridLayout$MutableInt;
.super Ljava/lang/Object;
.source "GridLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/GridLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "MutableInt"
.end annotation


# instance fields
.field public value:I


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p0}, Landroid/widget/GridLayout$MutableInt;->reset()V

    return-void
.end method

.method public constructor <init>(I)V
    .registers 2
    .parameter "value"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroid/widget/GridLayout$MutableInt;->value:I

    return-void
.end method


# virtual methods
.method public reset()V
    .registers 2

    .prologue
    const/high16 v0, -0x8000

    iput v0, p0, Landroid/widget/GridLayout$MutableInt;->value:I

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    .prologue
    iget v0, p0, Landroid/widget/GridLayout$MutableInt;->value:I

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
