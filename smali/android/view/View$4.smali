.class final Landroid/view/View$4;
.super Landroid/util/FloatProperty;
.source "View.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/util/FloatProperty",
        "<",
        "Landroid/view/View;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .registers 2
    .parameter "x0"

    .prologue
    invoke-direct {p0, p1}, Landroid/util/FloatProperty;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public get(Landroid/view/View;)Ljava/lang/Float;
    .registers 3
    .parameter "object"

    .prologue
    invoke-virtual {p1}, Landroid/view/View;->getAlpha()F

    move-result v0

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    check-cast p1, Landroid/view/View;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/view/View$4;->get(Landroid/view/View;)Ljava/lang/Float;

    move-result-object v0

    return-object v0
.end method

.method public setValue(Landroid/view/View;F)V
    .registers 3
    .parameter "object"
    .parameter "value"

    .prologue
    invoke-virtual {p1, p2}, Landroid/view/View;->setAlpha(F)V

    return-void
.end method

.method public bridge synthetic setValue(Ljava/lang/Object;F)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    check-cast p1, Landroid/view/View;

    .end local p1
    invoke-virtual {p0, p1, p2}, Landroid/view/View$4;->setValue(Landroid/view/View;F)V

    return-void
.end method
