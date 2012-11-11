.class Lmiui/telephony/ExtraTelephonyManager$AsyncFuture$1;
.super Ljava/lang/Object;
.source "ExtraTelephonyManager.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;-><init>()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<TV;>;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .local p0, this:Lmiui/telephony/ExtraTelephonyManager$AsyncFuture$1;,"Lmiui/telephony/ExtraTelephonyManager$AsyncFuture.1;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TV;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .local p0, this:Lmiui/telephony/ExtraTelephonyManager$AsyncFuture$1;,"Lmiui/telephony/ExtraTelephonyManager$AsyncFuture.1;"
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "this should never be called"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
