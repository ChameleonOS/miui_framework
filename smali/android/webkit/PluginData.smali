.class public final Landroid/webkit/PluginData;
.super Ljava/lang/Object;
.source "PluginData.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field private mContentLength:J

.field private mHeaders:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mStatusCode:I

.field private mStream:Ljava/io/InputStream;


# direct methods
.method public constructor <init>(Ljava/io/InputStream;JLjava/util/Map;I)V
    .registers 6
    .parameter "stream"
    .parameter "length"
    .parameter
    .parameter "code"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/InputStream;",
            "J",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            ">;I)V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 76
    .local p4, headers:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;[Ljava/lang/String;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 77
    iput-object p1, p0, Landroid/webkit/PluginData;->mStream:Ljava/io/InputStream;

    .line 78
    iput-wide p2, p0, Landroid/webkit/PluginData;->mContentLength:J

    .line 79
    iput-object p4, p0, Landroid/webkit/PluginData;->mHeaders:Ljava/util/Map;

    .line 80
    iput p5, p0, Landroid/webkit/PluginData;->mStatusCode:I

    .line 81
    return-void
.end method


# virtual methods
.method public getContentLength()J
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 108
    iget-wide v0, p0, Landroid/webkit/PluginData;->mContentLength:J

    return-wide v0
.end method

.method public getHeaders()Ljava/util/Map;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 125
    iget-object v0, p0, Landroid/webkit/PluginData;->mHeaders:Ljava/util/Map;

    return-object v0
.end method

.method public getInputStream()Ljava/io/InputStream;
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 94
    iget-object v0, p0, Landroid/webkit/PluginData;->mStream:Ljava/io/InputStream;

    return-object v0
.end method

.method public getStatusCode()I
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 139
    iget v0, p0, Landroid/webkit/PluginData;->mStatusCode:I

    return v0
.end method
