.class public final Lcom/android/server/NetworkManagementSocketTagger;
.super Ldalvik/system/SocketTagger;
.source "NetworkManagementSocketTagger.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/server/NetworkManagementSocketTagger$SocketTags;
    }
.end annotation


# static fields
.field private static final LOGD:Z = false

.field public static final PROP_QTAGUID_ENABLED:Ljava/lang/String; = "net.qtaguid_enabled"

.field private static final TAG:Ljava/lang/String; = "NetworkManagementSocketTagger"

.field private static threadSocketTags:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal",
            "<",
            "Lcom/android/server/NetworkManagementSocketTagger$SocketTags;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 42
    new-instance v0, Lcom/android/server/NetworkManagementSocketTagger$1;

    invoke-direct {v0}, Lcom/android/server/NetworkManagementSocketTagger$1;-><init>()V

    sput-object v0, Lcom/android/server/NetworkManagementSocketTagger;->threadSocketTags:Ljava/lang/ThreadLocal;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 31
    invoke-direct {p0}, Ldalvik/system/SocketTagger;-><init>()V

    .line 109
    return-void
.end method

.method public static getThreadSocketStatsTag()I
    .registers 1

    .prologue
    .line 58
    sget-object v0, Lcom/android/server/NetworkManagementSocketTagger;->threadSocketTags:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/server/NetworkManagementSocketTagger$SocketTags;

    iget v0, v0, Lcom/android/server/NetworkManagementSocketTagger$SocketTags;->statsTag:I

    return v0
.end method

.method public static install()V
    .registers 1

    .prologue
    .line 50
    new-instance v0, Lcom/android/server/NetworkManagementSocketTagger;

    invoke-direct {v0}, Lcom/android/server/NetworkManagementSocketTagger;-><init>()V

    invoke-static {v0}, Ldalvik/system/SocketTagger;->set(Ldalvik/system/SocketTagger;)V

    .line 51
    return-void
.end method

.method public static kernelToTag(Ljava/lang/String;)I
    .registers 4
    .parameter "string"

    .prologue
    const/4 v1, 0x0

    .line 138
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    .line 139
    .local v0, length:I
    const/16 v2, 0xa

    if-le v0, v2, :cond_17

    .line 140
    add-int/lit8 v2, v0, -0x8

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Long;->decode(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Long;->intValue()I

    move-result v1

    .line 142
    :cond_17
    return v1
.end method

.method private static native native_deleteTagData(II)I
.end method

.method private static native native_setCounterSet(II)I
.end method

.method private static native native_tagSocketFd(Ljava/io/FileDescriptor;II)I
.end method

.method private static native native_untagSocketFd(Ljava/io/FileDescriptor;)I
.end method

.method public static resetKernelUidStats(I)V
    .registers 5
    .parameter "uid"

    .prologue
    const/4 v2, 0x0

    .line 125
    const-string/jumbo v1, "net.qtaguid_enabled"

    invoke-static {v1, v2}, Landroid/os/SystemProperties;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_33

    .line 126
    invoke-static {v2, p0}, Lcom/android/server/NetworkManagementSocketTagger;->native_deleteTagData(II)I

    move-result v0

    .line 127
    .local v0, errno:I
    if-gez v0, :cond_33

    .line 128
    const-string v1, "NetworkManagementSocketTagger"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "problem clearing counters for uid "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " : errno "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 131
    .end local v0           #errno:I
    :cond_33
    return-void
.end method

.method public static setKernelCounterSet(II)V
    .registers 6
    .parameter "uid"
    .parameter "counterSet"

    .prologue
    .line 115
    const-string/jumbo v1, "net.qtaguid_enabled"

    const/4 v2, 0x0

    invoke-static {v1, v2}, Landroid/os/SystemProperties;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_3d

    .line 116
    invoke-static {p1, p0}, Lcom/android/server/NetworkManagementSocketTagger;->native_setCounterSet(II)I

    move-result v0

    .line 117
    .local v0, errno:I
    if-gez v0, :cond_3d

    .line 118
    const-string v1, "NetworkManagementSocketTagger"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "setKernelCountSet("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ") failed with errno "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 122
    .end local v0           #errno:I
    :cond_3d
    return-void
.end method

.method public static setThreadSocketStatsTag(I)V
    .registers 2
    .parameter "tag"

    .prologue
    .line 54
    sget-object v0, Lcom/android/server/NetworkManagementSocketTagger;->threadSocketTags:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/server/NetworkManagementSocketTagger$SocketTags;

    iput p0, v0, Lcom/android/server/NetworkManagementSocketTagger$SocketTags;->statsTag:I

    .line 55
    return-void
.end method

.method public static setThreadSocketStatsUid(I)V
    .registers 2
    .parameter "uid"

    .prologue
    .line 62
    sget-object v0, Lcom/android/server/NetworkManagementSocketTagger;->threadSocketTags:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/server/NetworkManagementSocketTagger$SocketTags;

    iput p0, v0, Lcom/android/server/NetworkManagementSocketTagger$SocketTags;->statsUid:I

    .line 63
    return-void
.end method

.method private tagSocketFd(Ljava/io/FileDescriptor;II)V
    .registers 8
    .parameter "fd"
    .parameter "tag"
    .parameter "uid"

    .prologue
    const/4 v1, -0x1

    .line 77
    if-ne p2, v1, :cond_6

    if-ne p3, v1, :cond_6

    .line 87
    :cond_5
    :goto_5
    return-void

    .line 79
    :cond_6
    const-string/jumbo v1, "net.qtaguid_enabled"

    const/4 v2, 0x0

    invoke-static {v1, v2}, Landroid/os/SystemProperties;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 80
    invoke-static {p1, p2, p3}, Lcom/android/server/NetworkManagementSocketTagger;->native_tagSocketFd(Ljava/io/FileDescriptor;II)I

    move-result v0

    .line 81
    .local v0, errno:I
    if-gez v0, :cond_5

    .line 82
    const-string v1, "NetworkManagementSocketTagger"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "tagSocketFd("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/io/FileDescriptor;->getInt$()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ") failed with errno"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_5
.end method

.method private unTagSocketFd(Ljava/io/FileDescriptor;)V
    .registers 7
    .parameter "fd"

    .prologue
    const/4 v3, -0x1

    .line 98
    sget-object v2, Lcom/android/server/NetworkManagementSocketTagger;->threadSocketTags:Ljava/lang/ThreadLocal;

    invoke-virtual {v2}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/server/NetworkManagementSocketTagger$SocketTags;

    .line 99
    .local v1, options:Lcom/android/server/NetworkManagementSocketTagger$SocketTags;
    iget v2, v1, Lcom/android/server/NetworkManagementSocketTagger$SocketTags;->statsTag:I

    if-ne v2, v3, :cond_12

    iget v2, v1, Lcom/android/server/NetworkManagementSocketTagger$SocketTags;->statsUid:I

    if-ne v2, v3, :cond_12

    .line 107
    :cond_11
    :goto_11
    return-void

    .line 101
    :cond_12
    const-string/jumbo v2, "net.qtaguid_enabled"

    const/4 v3, 0x0

    invoke-static {v2, v3}, Landroid/os/SystemProperties;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_11

    .line 102
    invoke-static {p1}, Lcom/android/server/NetworkManagementSocketTagger;->native_untagSocketFd(Ljava/io/FileDescriptor;)I

    move-result v0

    .line 103
    .local v0, errno:I
    if-gez v0, :cond_11

    .line 104
    const-string v2, "NetworkManagementSocketTagger"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "untagSocket("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Ljava/io/FileDescriptor;->getInt$()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ") failed with errno "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_11
.end method


# virtual methods
.method public tag(Ljava/io/FileDescriptor;)V
    .registers 5
    .parameter "fd"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/SocketException;
        }
    .end annotation

    .prologue
    .line 67
    sget-object v1, Lcom/android/server/NetworkManagementSocketTagger;->threadSocketTags:Ljava/lang/ThreadLocal;

    invoke-virtual {v1}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/server/NetworkManagementSocketTagger$SocketTags;

    .line 73
    .local v0, options:Lcom/android/server/NetworkManagementSocketTagger$SocketTags;
    iget v1, v0, Lcom/android/server/NetworkManagementSocketTagger$SocketTags;->statsTag:I

    iget v2, v0, Lcom/android/server/NetworkManagementSocketTagger$SocketTags;->statsUid:I

    invoke-direct {p0, p1, v1, v2}, Lcom/android/server/NetworkManagementSocketTagger;->tagSocketFd(Ljava/io/FileDescriptor;II)V

    .line 74
    return-void
.end method

.method public untag(Ljava/io/FileDescriptor;)V
    .registers 2
    .parameter "fd"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/SocketException;
        }
    .end annotation

    .prologue
    .line 94
    invoke-direct {p0, p1}, Lcom/android/server/NetworkManagementSocketTagger;->unTagSocketFd(Ljava/io/FileDescriptor;)V

    .line 95
    return-void
.end method
