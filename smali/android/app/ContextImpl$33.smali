.class final Landroid/app/ContextImpl$33;
.super Landroid/app/ContextImpl$ServiceFetcher;
.source "ContextImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/ContextImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 478
    invoke-direct {p0}, Landroid/app/ContextImpl$ServiceFetcher;-><init>()V

    return-void
.end method


# virtual methods
.method public createService(Landroid/app/ContextImpl;)Ljava/lang/Object;
    .registers 5
    .parameter "ctx"

    .prologue
    .line 480
    const-string/jumbo v1, "serial"

    invoke-static {v1}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    .line 481
    .local v0, b:Landroid/os/IBinder;
    new-instance v1, Landroid/hardware/SerialManager;

    invoke-static {v0}, Landroid/hardware/ISerialManager$Stub;->asInterface(Landroid/os/IBinder;)Landroid/hardware/ISerialManager;

    move-result-object v2

    invoke-direct {v1, p1, v2}, Landroid/hardware/SerialManager;-><init>(Landroid/content/Context;Landroid/hardware/ISerialManager;)V

    return-object v1
.end method
