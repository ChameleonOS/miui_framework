.class final Landroid/speech/tts/SynthesisPlaybackQueueItem$ListEntry;
.super Ljava/lang/Object;
.source "SynthesisPlaybackQueueItem.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/speech/tts/SynthesisPlaybackQueueItem;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "ListEntry"
.end annotation


# instance fields
.field final mBytes:[B


# direct methods
.method constructor <init>([B)V
    .registers 2
    .parameter "bytes"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/speech/tts/SynthesisPlaybackQueueItem$ListEntry;->mBytes:[B

    return-void
.end method
