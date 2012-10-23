.class public Landroid/ddm/DdmHandleAppName;
.super Lorg/apache/harmony/dalvik/ddmc/ChunkHandler;
.source "DdmHandleAppName.java"


# static fields
.field public static final CHUNK_APNM:I

.field private static volatile mAppName:Ljava/lang/String;

.field private static mInstance:Landroid/ddm/DdmHandleAppName;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 31
    const-string v0, "APNM"

    invoke-static {v0}, Landroid/ddm/DdmHandleAppName;->type(Ljava/lang/String;)I

    move-result v0

    sput v0, Landroid/ddm/DdmHandleAppName;->CHUNK_APNM:I

    .line 33
    const-string v0, ""

    sput-object v0, Landroid/ddm/DdmHandleAppName;->mAppName:Ljava/lang/String;

    .line 35
    new-instance v0, Landroid/ddm/DdmHandleAppName;

    invoke-direct {v0}, Landroid/ddm/DdmHandleAppName;-><init>()V

    sput-object v0, Landroid/ddm/DdmHandleAppName;->mInstance:Landroid/ddm/DdmHandleAppName;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 39
    invoke-direct {p0}, Lorg/apache/harmony/dalvik/ddmc/ChunkHandler;-><init>()V

    return-void
.end method

.method public static getAppName()Ljava/lang/String;
    .registers 1

    .prologue
    .line 83
    sget-object v0, Landroid/ddm/DdmHandleAppName;->mAppName:Ljava/lang/String;

    return-object v0
.end method

.method public static register()V
    .registers 0

    .prologue
    .line 44
    return-void
.end method

.method private static sendAPNM(Ljava/lang/String;)V
    .registers 4
    .parameter "appName"

    .prologue
    .line 93
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    mul-int/lit8 v2, v2, 0x2

    add-int/lit8 v2, v2, 0x4

    invoke-static {v2}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v1

    .line 94
    .local v1, out:Ljava/nio/ByteBuffer;
    sget-object v2, Lorg/apache/harmony/dalvik/ddmc/ChunkHandler;->CHUNK_ORDER:Ljava/nio/ByteOrder;

    invoke-virtual {v1, v2}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    .line 95
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    .line 96
    invoke-static {v1, p0}, Landroid/ddm/DdmHandleAppName;->putString(Ljava/nio/ByteBuffer;Ljava/lang/String;)V

    .line 98
    new-instance v0, Lorg/apache/harmony/dalvik/ddmc/Chunk;

    sget v2, Landroid/ddm/DdmHandleAppName;->CHUNK_APNM:I

    invoke-direct {v0, v2, v1}, Lorg/apache/harmony/dalvik/ddmc/Chunk;-><init>(ILjava/nio/ByteBuffer;)V

    .line 99
    .local v0, chunk:Lorg/apache/harmony/dalvik/ddmc/Chunk;
    invoke-static {v0}, Lorg/apache/harmony/dalvik/ddmc/DdmServer;->sendChunk(Lorg/apache/harmony/dalvik/ddmc/Chunk;)V

    .line 100
    return-void
.end method

.method public static setAppName(Ljava/lang/String;)V
    .registers 2
    .parameter "name"

    .prologue
    .line 73
    if-eqz p0, :cond_8

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    .line 80
    :cond_8
    :goto_8
    return-void

    .line 76
    :cond_9
    sput-object p0, Landroid/ddm/DdmHandleAppName;->mAppName:Ljava/lang/String;

    .line 79
    invoke-static {p0}, Landroid/ddm/DdmHandleAppName;->sendAPNM(Ljava/lang/String;)V

    goto :goto_8
.end method


# virtual methods
.method public connected()V
    .registers 1

    .prologue
    .line 50
    return-void
.end method

.method public disconnected()V
    .registers 1

    .prologue
    .line 56
    return-void
.end method

.method public handleChunk(Lorg/apache/harmony/dalvik/ddmc/Chunk;)Lorg/apache/harmony/dalvik/ddmc/Chunk;
    .registers 3
    .parameter "request"

    .prologue
    .line 62
    const/4 v0, 0x0

    return-object v0
.end method
