.class public abstract Landroid/webkit/SearchBox$SearchBoxListener;
.super Ljava/lang/Object;
.source "SearchBox.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/SearchBox;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "SearchBoxListener"
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 98
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancelComplete(Z)V
    .registers 2
    .parameter "called"

    .prologue
    .line 103
    return-void
.end method

.method public onChangeComplete(Z)V
    .registers 2
    .parameter "called"

    .prologue
    .line 100
    return-void
.end method

.method public onResizeComplete(Z)V
    .registers 2
    .parameter "called"

    .prologue
    .line 102
    return-void
.end method

.method public onSubmitComplete(Z)V
    .registers 2
    .parameter "called"

    .prologue
    .line 101
    return-void
.end method

.method public onSuggestionsReceived(Ljava/lang/String;Ljava/util/List;)V
    .registers 3
    .parameter "query"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 99
    .local p2, suggestions:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    return-void
.end method
