.class final Landroid/view/ViewDebug$4;
.super Ljava/lang/Object;
.source "ViewDebug.java"

# interfaces
.implements Landroid/view/ViewDebug$ViewOperation;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/view/ViewDebug;->profileViewAndChildren(Landroid/view/View;Ljava/io/BufferedWriter;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/view/ViewDebug$ViewOperation",
        "<",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic val$view:Landroid/view/View;


# direct methods
.method constructor <init>(Landroid/view/View;)V
    .registers 2
    .parameter

    .prologue
    .line 514
    iput-object p1, p0, Landroid/view/ViewDebug$4;->val$view:Landroid/view/View;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public varargs post([Ljava/lang/Object;)V
    .registers 5
    .parameter "data"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 535
    aget-object v0, p1, v1

    if-eqz v0, :cond_e

    .line 536
    aget-object v0, p1, v1

    check-cast v0, Landroid/graphics/Canvas;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/graphics/Canvas;->setBitmap(Landroid/graphics/Bitmap;)V

    .line 538
    :cond_e
    aget-object v0, p1, v2

    if-eqz v0, :cond_19

    .line 539
    aget-object v0, p1, v2

    check-cast v0, Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 541
    :cond_19
    return-void
.end method

.method public pre()[Ljava/lang/Object;
    .registers 7

    .prologue
    const/4 v1, 0x0

    .line 516
    iget-object v3, p0, Landroid/view/ViewDebug$4;->val$view:Landroid/view/View;

    if-eqz v3, :cond_34

    iget-object v3, p0, Landroid/view/ViewDebug$4;->val$view:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    if-eqz v3, :cond_34

    iget-object v3, p0, Landroid/view/ViewDebug$4;->val$view:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    .line 519
    .local v2, metrics:Landroid/util/DisplayMetrics;
    :goto_17
    if-eqz v2, :cond_36

    iget v3, v2, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v4, v2, Landroid/util/DisplayMetrics;->heightPixels:I

    sget-object v5, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    invoke-static {v3, v4, v5}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 522
    .local v0, bitmap:Landroid/graphics/Bitmap;
    :goto_23
    if-eqz v0, :cond_2a

    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 523
    .local v1, canvas:Landroid/graphics/Canvas;
    :cond_2a
    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    const/4 v4, 0x1

    aput-object v1, v3, v4

    return-object v3

    .end local v0           #bitmap:Landroid/graphics/Bitmap;
    .end local v1           #canvas:Landroid/graphics/Canvas;
    .end local v2           #metrics:Landroid/util/DisplayMetrics;
    :cond_34
    move-object v2, v1

    .line 516
    goto :goto_17

    .restart local v2       #metrics:Landroid/util/DisplayMetrics;
    :cond_36
    move-object v0, v1

    .line 519
    goto :goto_23
.end method

.method public varargs run([Ljava/lang/Object;)V
    .registers 5
    .parameter "data"

    .prologue
    const/4 v2, 0x1

    .line 529
    aget-object v0, p1, v2

    if-eqz v0, :cond_e

    .line 530
    iget-object v1, p0, Landroid/view/ViewDebug$4;->val$view:Landroid/view/View;

    aget-object v0, p1, v2

    check-cast v0, Landroid/graphics/Canvas;

    invoke-virtual {v1, v0}, Landroid/view/View;->draw(Landroid/graphics/Canvas;)V

    .line 532
    :cond_e
    return-void
.end method
