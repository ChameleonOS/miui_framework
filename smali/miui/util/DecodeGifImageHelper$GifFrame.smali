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
    .line 135
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 136
    iput-object p1, p0, Lmiui/util/DecodeGifImageHelper$GifFrame;->mImage:Landroid/graphics/Bitmap;

    .line 137
    iput p2, p0, Lmiui/util/DecodeGifImageHelper$GifFrame;->mDuration:I

    .line 138
    iput p3, p0, Lmiui/util/DecodeGifImageHelper$GifFrame;->mIndex:I

    .line 139
    return-void
.end method
