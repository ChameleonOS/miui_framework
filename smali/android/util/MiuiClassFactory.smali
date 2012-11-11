.class public Landroid/util/MiuiClassFactory;
.super Ljava/lang/Object;
.source "MiuiClassFactory.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static newDownloadManager(Landroid/content/ContentResolver;Ljava/lang/String;)Landroid/app/DownloadManager;
    .registers 3
    .parameter "resolver"
    .parameter "packageName"

    .prologue
    new-instance v0, Landroid/app/MiuiDownloadManager;

    invoke-direct {v0, p0, p1}, Landroid/app/MiuiDownloadManager;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    return-object v0
.end method
