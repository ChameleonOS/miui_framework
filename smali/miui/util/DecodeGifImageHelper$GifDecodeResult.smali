.class public Lmiui/util/DecodeGifImageHelper$GifDecodeResult;
.super Ljava/lang/Object;
.source "DecodeGifImageHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/util/DecodeGifImageHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GifDecodeResult"
.end annotation


# instance fields
.field public mGifDecoder:Lmiui/util/GifDecoder;

.field public mIsDecodeOk:Z


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 122
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
