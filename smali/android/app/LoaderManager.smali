.class public abstract Landroid/app/LoaderManager;
.super Ljava/lang/Object;
.source "LoaderManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/app/LoaderManager$LoaderCallbacks;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 59
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 63
    return-void
.end method

.method public static enableDebugLogging(Z)V
    .registers 1
    .parameter "enabled"

    .prologue
    .line 197
    sput-boolean p0, Landroid/app/LoaderManagerImpl;->DEBUG:Z

    .line 198
    return-void
.end method


# virtual methods
.method public abstract destroyLoader(I)V
.end method

.method public abstract dump(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
.end method

.method public abstract getLoader(I)Landroid/content/Loader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<D:",
            "Ljava/lang/Object;",
            ">(I)",
            "Landroid/content/Loader",
            "<TD;>;"
        }
    .end annotation
.end method

.method public abstract initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<D:",
            "Ljava/lang/Object;",
            ">(I",
            "Landroid/os/Bundle;",
            "Landroid/app/LoaderManager$LoaderCallbacks",
            "<TD;>;)",
            "Landroid/content/Loader",
            "<TD;>;"
        }
    .end annotation
.end method

.method public abstract restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<D:",
            "Ljava/lang/Object;",
            ">(I",
            "Landroid/os/Bundle;",
            "Landroid/app/LoaderManager$LoaderCallbacks",
            "<TD;>;)",
            "Landroid/content/Loader",
            "<TD;>;"
        }
    .end annotation
.end method
