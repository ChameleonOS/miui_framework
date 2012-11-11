.class Landroid/app/MiuiDownloadManager$CursorTranslator;
.super Landroid/app/DownloadManager$CursorTranslator;
.source "MiuiDownloadManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/MiuiDownloadManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "CursorTranslator"
.end annotation


# direct methods
.method public constructor <init>(Landroid/database/Cursor;Landroid/net/Uri;)V
    .registers 3
    .parameter "cursor"
    .parameter "baseUri"

    .prologue
    invoke-direct {p0, p1, p2}, Landroid/app/DownloadManager$CursorTranslator;-><init>(Landroid/database/Cursor;Landroid/net/Uri;)V

    return-void
.end method


# virtual methods
.method getPausedReason(I)J
    .registers 4
    .parameter "status"

    .prologue
    const/16 v0, 0xc1

    if-ne p1, v0, :cond_7

    const-wide/16 v0, 0x5

    :goto_6
    return-wide v0

    :cond_7
    invoke-super {p0, p1}, Landroid/app/DownloadManager$CursorTranslator;->getPausedReason(I)J

    move-result-wide v0

    goto :goto_6
.end method
