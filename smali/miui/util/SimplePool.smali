.class public Lmiui/util/SimplePool;
.super Ljava/lang/Object;
.source "SimplePool.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/util/SimplePool$PoolInstance;,
        Lmiui/util/SimplePool$Manager;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static newInsance(Lmiui/util/SimplePool$Manager;I)Lmiui/util/SimplePool$PoolInstance;
    .registers 3
    .parameter
    .parameter "size"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lmiui/util/SimplePool$Manager",
            "<TT;>;I)",
            "Lmiui/util/SimplePool$PoolInstance",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .local p0, manager:Lmiui/util/SimplePool$Manager;,"Lmiui/util/SimplePool$Manager<TT;>;"
    new-instance v0, Lmiui/util/SimplePool$PoolInstance;

    invoke-direct {v0, p0, p1}, Lmiui/util/SimplePool$PoolInstance;-><init>(Lmiui/util/SimplePool$Manager;I)V

    return-object v0
.end method
