.class Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;
.super Ljava/util/concurrent/FutureTask;
.source "ExtraTelephonyManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/telephony/ExtraTelephonyManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AsyncFuture"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/FutureTask",
        "<TV;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 341
    .local p0, this:Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;,"Lmiui/telephony/ExtraTelephonyManager$AsyncFuture<TV;>;"
    new-instance v0, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture$1;

    invoke-direct {v0}, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture$1;-><init>()V

    invoke-direct {p0, v0}, Ljava/util/concurrent/FutureTask;-><init>(Ljava/util/concurrent/Callable;)V

    .line 348
    return-void
.end method


# virtual methods
.method public setResult(Ljava/lang/Object;)V
    .registers 2
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TV;)V"
        }
    .end annotation

    .prologue
    .line 351
    .local p0, this:Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;,"Lmiui/telephony/ExtraTelephonyManager$AsyncFuture<TV;>;"
    .local p1, v:Ljava/lang/Object;,"TV;"
    invoke-virtual {p0, p1}, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;->set(Ljava/lang/Object;)V

    .line 352
    return-void
.end method
