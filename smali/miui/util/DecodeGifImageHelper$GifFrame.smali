.class public Lmiui/util/DecodeGifImageHelper$GifFrame;
.super Ljava/lang/Object;
.source "DecodeGifImageHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/util/DecodeGifImageHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GifFrame"
.end annotation


# instance fields
.field public mDuration:I

.field public mImage:Landroid/graphics/Bitmap;

.field public mIndex:I


# direct methods
.method public constructor <init>(Landroid/graphics/Bitmap;II)V
    .registers 4
    .parameter "im"
    .parameter "duration"
    .parameter "index"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmiui/util/DecodeGifImageHelper$GifFrame;->mImage:Landroid/graphics/Bitmap;

    iput p2, p0, Lmiui/util/DecodeGifImageHelper$GifFrame;->mDuration:I

    iput p3, p0, Lmiui/util/DecodeGifImageHelper$GifFrame;->mIndex:I

    return-void
.end method
