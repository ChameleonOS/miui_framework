.class final Landroid/app/LoadedApk$ServiceDispatcher$DeathMonitor;
.super Ljava/lang/Object;
.source "LoadedApk.java"

# interfaces
.implements Landroid/os/IBinder$DeathRecipient;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/LoadedApk$ServiceDispatcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "DeathMonitor"
.end annotation


# instance fields
.field final mName:Landroid/content/ComponentName;

.field final mService:Landroid/os/IBinder;

.field final synthetic this$0:Landroid/app/LoadedApk$ServiceDispatcher;


# direct methods
.method constructor <init>(Landroid/app/LoadedApk$ServiceDispatcher;Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .registers 4
    .parameter
    .parameter "name"
    .parameter "service"

    .prologue
    .line 1131
    iput-object p1, p0, Landroid/app/LoadedApk$ServiceDispatcher$DeathMonitor;->this$0:Landroid/app/LoadedApk$ServiceDispatcher;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1132
    iput-object p2, p0, Landroid/app/LoadedApk$ServiceDispatcher$DeathMonitor;->mName:Landroid/content/ComponentName;

    .line 1133
    iput-object p3, p0, Landroid/app/LoadedApk$ServiceDispatcher$DeathMonitor;->mService:Landroid/os/IBinder;

    .line 1134
    return-void
.end method


# virtual methods
.method public binderDied()V
    .registers 4

    .prologue
    .line 1137
    iget-object v0, p0, Landroid/app/LoadedApk$ServiceDispatcher$DeathMonitor;->this$0:Landroid/app/LoadedApk$ServiceDispatcher;

    iget-object v1, p0, Landroid/app/LoadedApk$ServiceDispatcher$DeathMonitor;->mName:Landroid/content/ComponentName;

    iget-object v2, p0, Landroid/app/LoadedApk$ServiceDispatcher$DeathMonitor;->mService:Landroid/os/IBinder;

    invoke-virtual {v0, v1, v2}, Landroid/app/LoadedApk$ServiceDispatcher;->death(Landroid/content/ComponentName;Landroid/os/IBinder;)V

    .line 1138
    return-void
.end method
