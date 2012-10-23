.class public abstract Landroid/app/backup/RestoreObserver;
.super Ljava/lang/Object;
.source "RestoreObserver.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 26
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onUpdate(ILjava/lang/String;)V
    .registers 3
    .parameter "nowBeingRestored"
    .parameter "currentPackage"

    .prologue
    .line 65
    return-void
.end method

.method public restoreFinished(I)V
    .registers 2
    .parameter "error"

    .prologue
    .line 75
    return-void
.end method

.method public restoreSetsAvailable([Landroid/app/backup/RestoreSet;)V
    .registers 2
    .parameter "result"

    .prologue
    .line 40
    return-void
.end method

.method public restoreStarting(I)V
    .registers 2
    .parameter "numPackages"

    .prologue
    .line 49
    return-void
.end method
