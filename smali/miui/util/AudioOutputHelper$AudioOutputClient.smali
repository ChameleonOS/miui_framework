.class public Lmiui/util/AudioOutputHelper$AudioOutputClient;
.super Ljava/lang/Object;
.source "AudioOutputHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/util/AudioOutputHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AudioOutputClient"
.end annotation


# instance fields
.field public mActive:Z

.field public final mProcessId:I

.field public final mSessionId:I

.field public final mStreamType:I


# direct methods
.method public constructor <init>(III)V
    .registers 5
    .parameter "sessionId"
    .parameter "processId"
    .parameter "streamType"

    .prologue
    .line 47
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lmiui/util/AudioOutputHelper$AudioOutputClient;-><init>(IIIZ)V

    .line 48
    return-void
.end method

.method public constructor <init>(IIIZ)V
    .registers 5
    .parameter "sessionId"
    .parameter "processId"
    .parameter "streamType"
    .parameter "active"

    .prologue
    .line 39
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 40
    iput p1, p0, Lmiui/util/AudioOutputHelper$AudioOutputClient;->mSessionId:I

    .line 41
    iput p2, p0, Lmiui/util/AudioOutputHelper$AudioOutputClient;->mProcessId:I

    .line 42
    iput p3, p0, Lmiui/util/AudioOutputHelper$AudioOutputClient;->mStreamType:I

    .line 43
    iput-boolean p4, p0, Lmiui/util/AudioOutputHelper$AudioOutputClient;->mActive:Z

    .line 44
    return-void
.end method
