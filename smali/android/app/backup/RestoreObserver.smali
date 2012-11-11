.class public abstract Landroid/app/backup/RestoreObserver;
.super Ljava/lang/Object;
.source "RestoreObserver.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onUpdate(ILjava/lang/String;)V
    .registers 3
    .parameter "nowBeingRestored"
    .parameter "currentPackage"

    .prologue
    return-void
.end method

.method public restoreFinished(I)V
    .registers 2
    .parameter "error"

    .prologue
    return-void
.end method

.method public restoreSetsAvailable([Landroid/app/backup/RestoreSet;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public restoreStarting(I)V
    .registers 2
    .parameter "numPackages"

    .prologue
    return-void
.end method
