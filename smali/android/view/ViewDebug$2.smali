.class final Landroid/view/ViewDebug$2;
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
        "Ljava/lang/Void;",
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
    .line 472
    iput-object p1, p0, Landroid/view/ViewDebug$2;->val$view:Landroid/view/View;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private forceLayout(Landroid/view/View;)V
    .registers 6
    .parameter "view"

    .prologue
    .line 479
    invoke-virtual {p1}, Landroid/view/View;->forceLayout()V

    .line 480
    instance-of v3, p1, Landroid/view/ViewGroup;

    if-eqz v3, :cond_1b

    move-object v1, p1

    .line 481
    check-cast v1, Landroid/view/ViewGroup;

    .line 482
    .local v1, group:Landroid/view/ViewGroup;
    invoke-virtual {v1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    .line 483
    .local v0, count:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_f
    if-ge v2, v0, :cond_1b

    .line 484
    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-direct {p0, v3}, Landroid/view/ViewDebug$2;->forceLayout(Landroid/view/View;)V

    .line 483
    add-int/lit8 v2, v2, 0x1

    goto :goto_f

    .line 487
    .end local v0           #count:I
    .end local v1           #group:Landroid/view/ViewGroup;
    .end local v2           #i:I
    :cond_1b
    return-void
.end method


# virtual methods
.method public bridge synthetic post([Ljava/lang/Object;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 472
    check-cast p1, [Ljava/lang/Void;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/view/ViewDebug$2;->post([Ljava/lang/Void;)V

    return-void
.end method

.method public varargs post([Ljava/lang/Void;)V
    .registers 2
    .parameter "data"

    .prologue
    .line 494
    return-void
.end method

.method public bridge synthetic pre()[Ljava/lang/Object;
    .registers 2

    .prologue
    .line 472
    invoke-virtual {p0}, Landroid/view/ViewDebug$2;->pre()[Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public pre()[Ljava/lang/Void;
    .registers 2

    .prologue
    .line 474
    iget-object v0, p0, Landroid/view/ViewDebug$2;->val$view:Landroid/view/View;

    invoke-direct {p0, v0}, Landroid/view/ViewDebug$2;->forceLayout(Landroid/view/View;)V

    .line 475
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic run([Ljava/lang/Object;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 472
    check-cast p1, [Ljava/lang/Void;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/view/ViewDebug$2;->run([Ljava/lang/Void;)V

    return-void
.end method

.method public varargs run([Ljava/lang/Void;)V
    .registers 5
    .parameter "data"

    .prologue
    .line 490
    iget-object v0, p0, Landroid/view/ViewDebug$2;->val$view:Landroid/view/View;

    iget-object v1, p0, Landroid/view/ViewDebug$2;->val$view:Landroid/view/View;

    iget v1, v1, Landroid/view/View;->mOldWidthMeasureSpec:I

    iget-object v2, p0, Landroid/view/ViewDebug$2;->val$view:Landroid/view/View;

    iget v2, v2, Landroid/view/View;->mOldHeightMeasureSpec:I

    invoke-virtual {v0, v1, v2}, Landroid/view/View;->measure(II)V

    .line 491
    return-void
.end method
