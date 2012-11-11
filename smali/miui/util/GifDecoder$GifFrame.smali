.class Lmiui/util/GifDecoder$GifFrame;
.super Ljava/lang/Object;
.source "GifDecoder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/util/GifDecoder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "GifFrame"
.end annotation


# instance fields
.field public delay:I

.field public image:Landroid/graphics/Bitmap;


# direct methods
.method public constructor <init>(Landroid/graphics/Bitmap;I)V
    .registers 3
    .parameter "im"
    .parameter "del"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmiui/util/GifDecoder$GifFrame;->image:Landroid/graphics/Bitmap;

    iput p2, p0, Lmiui/util/GifDecoder$GifFrame;->delay:I

    return-void
.end method


# virtual methods
.method public recycle()V
    .registers 2

    .prologue
    iget-object v0, p0, Lmiui/util/GifDecoder$GifFrame;->image:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_11

    iget-object v0, p0, Lmiui/util/GifDecoder$GifFrame;->image:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v0

    if-nez v0, :cond_11

    iget-object v0, p0, Lmiui/util/GifDecoder$GifFrame;->image:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    :cond_11
    return-void
.end method
