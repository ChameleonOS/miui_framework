.class Landroid/app/LoadedApk$ServiceDispatcher$ConnectionInfo;
.super Ljava/lang/Object;
.source "LoadedApk.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/LoadedApk$ServiceDispatcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ConnectionInfo"
.end annotation


# instance fields
.field binder:Landroid/os/IBinder;

.field deathMonitor:Landroid/os/IBinder$DeathRecipient;


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 939
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/app/LoadedApk$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 939
    invoke-direct {p0}, Landroid/app/LoadedApk$ServiceDispatcher$ConnectionInfo;-><init>()V

    return-void
.end method
