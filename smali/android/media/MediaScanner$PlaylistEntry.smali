.class Landroid/media/MediaScanner$PlaylistEntry;
.super Ljava/lang/Object;
.source "MediaScanner.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/MediaScanner;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "PlaylistEntry"
.end annotation


# instance fields
.field bestmatchid:J

.field bestmatchlevel:I

.field path:Ljava/lang/String;


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 376
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/media/MediaScanner$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 376
    invoke-direct {p0}, Landroid/media/MediaScanner$PlaylistEntry;-><init>()V

    return-void
.end method
