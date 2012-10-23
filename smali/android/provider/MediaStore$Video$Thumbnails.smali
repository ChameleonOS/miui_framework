.class public Landroid/provider/MediaStore$Video$Thumbnails;
.super Ljava/lang/Object;
.source "MediaStore.java"

# interfaces
.implements Landroid/provider/BaseColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/provider/MediaStore$Video;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Thumbnails"
.end annotation


# static fields
.field public static final DATA:Ljava/lang/String; = "_data"

.field public static final DEFAULT_SORT_ORDER:Ljava/lang/String; = "video_id ASC"

.field public static final EXTERNAL_CONTENT_URI:Landroid/net/Uri; = null

.field public static final FULL_SCREEN_KIND:I = 0x2

.field public static final HEIGHT:Ljava/lang/String; = "height"

.field public static final INTERNAL_CONTENT_URI:Landroid/net/Uri; = null

.field public static final KIND:Ljava/lang/String; = "kind"

.field public static final MICRO_KIND:I = 0x3

.field public static final MINI_KIND:I = 0x1

.field public static final VIDEO_ID:Ljava/lang/String; = "video_id"

.field public static final WIDTH:Ljava/lang/String; = "width"


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 2003
    const-string v0, "internal"

    invoke-static {v0}, Landroid/provider/MediaStore$Video$Thumbnails;->getContentUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Landroid/provider/MediaStore$Video$Thumbnails;->INTERNAL_CONTENT_URI:Landroid/net/Uri;

    .line 2010
    const-string v0, "external"

    invoke-static {v0}, Landroid/provider/MediaStore$Video$Thumbnails;->getContentUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Landroid/provider/MediaStore$Video$Thumbnails;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 1925
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static cancelThumbnailRequest(Landroid/content/ContentResolver;J)V
    .registers 9
    .parameter "cr"
    .parameter "origId"

    .prologue
    .line 1935
    sget-object v3, Landroid/provider/MediaStore$Video$Thumbnails;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    const-wide/16 v4, 0x0

    move-object v0, p0

    move-wide v1, p1

    invoke-static/range {v0 .. v5}, Landroid/provider/MediaStore$InternalThumbnails;->cancelThumbnailRequest(Landroid/content/ContentResolver;JLandroid/net/Uri;J)V

    .line 1937
    return-void
.end method

.method public static cancelThumbnailRequest(Landroid/content/ContentResolver;JJ)V
    .registers 11
    .parameter "cr"
    .parameter "origId"
    .parameter "groupId"

    .prologue
    .line 1985
    sget-object v3, Landroid/provider/MediaStore$Video$Thumbnails;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    move-object v0, p0

    move-wide v1, p1

    move-wide v4, p3

    invoke-static/range {v0 .. v5}, Landroid/provider/MediaStore$InternalThumbnails;->cancelThumbnailRequest(Landroid/content/ContentResolver;JLandroid/net/Uri;J)V

    .line 1986
    return-void
.end method

.method public static getContentUri(Ljava/lang/String;)Landroid/net/Uri;
    .registers 3
    .parameter "volumeName"

    .prologue
    .line 1996
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://media/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/video/thumbnails"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getThumbnail(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    .registers 14
    .parameter "cr"
    .parameter "origId"
    .parameter "kind"
    .parameter "options"

    .prologue
    .line 1952
    const-wide/16 v3, 0x0

    sget-object v7, Landroid/provider/MediaStore$Video$Thumbnails;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    const/4 v8, 0x1

    move-object v0, p0

    move-wide v1, p1

    move v5, p3

    move-object v6, p4

    invoke-static/range {v0 .. v8}, Landroid/provider/MediaStore$InternalThumbnails;->getThumbnail(Landroid/content/ContentResolver;JJILandroid/graphics/BitmapFactory$Options;Landroid/net/Uri;Z)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public static getThumbnail(Landroid/content/ContentResolver;JJILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    .registers 16
    .parameter "cr"
    .parameter "origId"
    .parameter "groupId"
    .parameter "kind"
    .parameter "options"

    .prologue
    .line 1971
    sget-object v7, Landroid/provider/MediaStore$Video$Thumbnails;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    const/4 v8, 0x1

    move-object v0, p0

    move-wide v1, p1

    move-wide v3, p3

    move v5, p5

    move-object v6, p6

    invoke-static/range {v0 .. v8}, Landroid/provider/MediaStore$InternalThumbnails;->getThumbnail(Landroid/content/ContentResolver;JJILandroid/graphics/BitmapFactory$Options;Landroid/net/Uri;Z)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method
