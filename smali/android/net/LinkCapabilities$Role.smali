.class public final Landroid/net/LinkCapabilities$Role;
.super Ljava/lang/Object;
.source "LinkCapabilities.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/LinkCapabilities;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Role"
.end annotation


# static fields
.field public static final BULK_DOWNLOAD:Ljava/lang/String; = "bulk.download"

.field public static final BULK_UPLOAD:Ljava/lang/String; = "bulk.upload"

.field public static final DEFAULT:Ljava/lang/String; = "default"

.field public static final VIDEO_CHAT_360P:Ljava/lang/String; = "video.chat.360p"

.field public static final VIDEO_CHAT_480P:Ljava/lang/String; = "video.chat.480i"

.field public static final VIDEO_STREAMING_480P:Ljava/lang/String; = "video.streaming.480p"

.field public static final VIDEO_STREAMING_720I:Ljava/lang/String; = "video.streaming.720i"

.field public static final VOIP_24KBPS:Ljava/lang/String; = "voip.24k"

.field public static final VOIP_32KBPS:Ljava/lang/String; = "voip.32k"


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 143
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
