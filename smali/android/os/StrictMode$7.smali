.class final Landroid/os/StrictMode$7;
.super Ljava/lang/ThreadLocal;
.source "StrictMode.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/StrictMode;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/ThreadLocal",
        "<",
        "Landroid/os/StrictMode$ThreadSpanState;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 1785
    invoke-direct {p0}, Ljava/lang/ThreadLocal;-><init>()V

    return-void
.end method


# virtual methods
.method protected initialValue()Landroid/os/StrictMode$ThreadSpanState;
    .registers 3

    .prologue
    .line 1787
    new-instance v0, Landroid/os/StrictMode$ThreadSpanState;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroid/os/StrictMode$ThreadSpanState;-><init>(Landroid/os/StrictMode$1;)V

    return-object v0
.end method

.method protected bridge synthetic initialValue()Ljava/lang/Object;
    .registers 2

    .prologue
    .line 1785
    invoke-virtual {p0}, Landroid/os/StrictMode$7;->initialValue()Landroid/os/StrictMode$ThreadSpanState;

    move-result-object v0

    return-object v0
.end method
