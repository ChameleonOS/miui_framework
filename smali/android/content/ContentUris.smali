.class public Landroid/content/ContentUris;
.super Ljava/lang/Object;
.source "ContentUris.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 70
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static appendId(Landroid/net/Uri$Builder;J)Landroid/net/Uri$Builder;
    .registers 4
    .parameter "builder"
    .parameter "id"

    .prologue
    .line 98
    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method public static parseId(Landroid/net/Uri;)J
    .registers 4
    .parameter "contentUri"

    .prologue
    .line 85
    invoke-virtual {p0}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v0

    .line 86
    .local v0, last:Ljava/lang/String;
    if-nez v0, :cond_9

    const-wide/16 v1, -0x1

    :goto_8
    return-wide v1

    :cond_9
    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v1

    goto :goto_8
.end method

.method public static withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;
    .registers 4
    .parameter "contentUri"
    .parameter "id"

    .prologue
    .line 110
    invoke-virtual {p0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-static {v0, p1, p2}, Landroid/content/ContentUris;->appendId(Landroid/net/Uri$Builder;J)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method
