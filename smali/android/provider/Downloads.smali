.class public final Landroid/provider/Downloads;
.super Ljava/lang/Object;
.source "Downloads.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/provider/Downloads$Impl;
    }
.end annotation


# static fields
.field private static final QUERY_WHERE_CLAUSE:Ljava/lang/String; = "notificationpackage=? AND notificationclass=?"


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 30
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final removeAllDownloadsByPackage(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .registers 8
    .parameter "context"
    .parameter "notification_package"
    .parameter "notification_class"

    .prologue
    .line 800
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Landroid/provider/Downloads$Impl;->CONTENT_URI:Landroid/net/Uri;

    const-string/jumbo v2, "notificationpackage=? AND notificationclass=?"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/4 v4, 0x1

    aput-object p2, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 802
    return-void
.end method
