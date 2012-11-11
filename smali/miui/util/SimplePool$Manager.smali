.class public abstract Lmiui/util/SimplePool$Manager;
.super Ljava/lang/Object;
.source "SimplePool.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/util/SimplePool;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Manager"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .local p0, this:Lmiui/util/SimplePool$Manager;,"Lmiui/util/SimplePool$Manager<TT;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract createInstance()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation
.end method

.method public onAcquire(Ljava/lang/Object;)V
    .registers 2
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Lmiui/util/SimplePool$Manager;,"Lmiui/util/SimplePool$Manager<TT;>;"
    .local p1, element:Ljava/lang/Object;,"TT;"
    return-void
.end method

.method public onRelease(Ljava/lang/Object;)V
    .registers 2
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Lmiui/util/SimplePool$Manager;,"Lmiui/util/SimplePool$Manager<TT;>;"
    .local p1, element:Ljava/lang/Object;,"TT;"
    return-void
.end method
