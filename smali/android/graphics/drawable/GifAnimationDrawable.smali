.class public Landroid/graphics/drawable/GifAnimationDrawable;
.super Landroid/graphics/drawable/AnimationDrawable;
.source "GifAnimationDrawable.java"


# instance fields
.field private final mHelper:Lmiui/util/DecodeGifImageHelper;

.field private mResources:Landroid/content/res/Resources;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/graphics/drawable/AnimationDrawable;-><init>()V

    new-instance v0, Lmiui/util/DecodeGifImageHelper;

    invoke-direct {v0}, Lmiui/util/DecodeGifImageHelper;-><init>()V

    iput-object v0, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mHelper:Lmiui/util/DecodeGifImageHelper;

    return-void
.end method

.method private handleFirstDecodeResult(Lmiui/util/DecodeGifImageHelper$GifDecodeResult;)Z
    .registers 13
    .parameter "decodeResult"

    .prologue
    const/4 v7, 0x0

    iget-object v8, p1, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mGifDecoder:Lmiui/util/GifDecoder;

    if-eqz v8, :cond_9

    iget-boolean v8, p1, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mIsDecodeOk:Z

    if-nez v8, :cond_a

    :cond_9
    :goto_9
    return v7

    :cond_a
    iget-object v4, p1, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mGifDecoder:Lmiui/util/GifDecoder;

    .local v4, gifDecoder:Lmiui/util/GifDecoder;
    iget-object v8, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mHelper:Lmiui/util/DecodeGifImageHelper;

    invoke-virtual {v4}, Lmiui/util/GifDecoder;->isDecodeToTheEnd()Z

    move-result v9

    iput-boolean v9, v8, Lmiui/util/DecodeGifImageHelper;->mDecodedAllFrames:Z

    invoke-virtual {v4}, Lmiui/util/GifDecoder;->getFrameCount()I

    move-result v1

    .local v1, count:I
    if-lez v1, :cond_9

    const/4 v6, 0x0

    .local v6, i:I
    :goto_1b
    if-ge v6, v1, :cond_4d

    iget-object v8, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mHelper:Lmiui/util/DecodeGifImageHelper;

    iget-boolean v8, v8, Lmiui/util/DecodeGifImageHelper;->mDecodedAllFrames:Z

    if-eqz v8, :cond_38

    new-instance v8, Landroid/graphics/drawable/BitmapDrawable;

    iget-object v9, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mResources:Landroid/content/res/Resources;

    invoke-virtual {v4, v6}, Lmiui/util/GifDecoder;->getFrame(I)Landroid/graphics/Bitmap;

    move-result-object v10

    invoke-direct {v8, v9, v10}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v4, v6}, Lmiui/util/GifDecoder;->getDelay(I)I

    move-result v9

    invoke-virtual {p0, v8, v9}, Landroid/graphics/drawable/GifAnimationDrawable;->addFrame(Landroid/graphics/drawable/Drawable;I)V

    :goto_35
    add-int/lit8 v6, v6, 0x1

    goto :goto_1b

    :cond_38
    invoke-virtual {v4, v6}, Lmiui/util/GifDecoder;->getFrame(I)Landroid/graphics/Bitmap;

    move-result-object v0

    .local v0, bitmap:Landroid/graphics/Bitmap;
    invoke-virtual {v4, v6}, Lmiui/util/GifDecoder;->getDelay(I)I

    move-result v3

    .local v3, duration:I
    iget-object v8, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mHelper:Lmiui/util/DecodeGifImageHelper;

    iget-object v8, v8, Lmiui/util/DecodeGifImageHelper;->mFrames:Ljava/util/List;

    new-instance v9, Lmiui/util/DecodeGifImageHelper$GifFrame;

    invoke-direct {v9, v0, v3, v6}, Lmiui/util/DecodeGifImageHelper$GifFrame;-><init>(Landroid/graphics/Bitmap;II)V

    invoke-interface {v8, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_35

    .end local v0           #bitmap:Landroid/graphics/Bitmap;
    .end local v3           #duration:I
    :cond_4d
    iget-object v8, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mHelper:Lmiui/util/DecodeGifImageHelper;

    iget-boolean v8, v8, Lmiui/util/DecodeGifImageHelper;->mDecodedAllFrames:Z

    if-nez v8, :cond_75

    iget-object v8, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mHelper:Lmiui/util/DecodeGifImageHelper;

    invoke-virtual {v8}, Lmiui/util/DecodeGifImageHelper;->firstDecodeNextFrames()V

    iget-object v8, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mHelper:Lmiui/util/DecodeGifImageHelper;

    iget-object v8, v8, Lmiui/util/DecodeGifImageHelper;->mFrames:Ljava/util/List;

    invoke-interface {v8, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lmiui/util/DecodeGifImageHelper$GifFrame;

    .local v5, gifFame:Lmiui/util/DecodeGifImageHelper$GifFrame;
    new-instance v2, Landroid/graphics/drawable/BitmapDrawable;

    iget-object v8, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mResources:Landroid/content/res/Resources;

    iget-object v9, v5, Lmiui/util/DecodeGifImageHelper$GifFrame;->mImage:Landroid/graphics/Bitmap;

    invoke-direct {v2, v8, v9}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .local v2, drawable:Landroid/graphics/drawable/BitmapDrawable;
    iget v8, v5, Lmiui/util/DecodeGifImageHelper$GifFrame;->mDuration:I

    invoke-virtual {p0, v2, v8}, Landroid/graphics/drawable/GifAnimationDrawable;->addFrame(Landroid/graphics/drawable/Drawable;I)V

    iget v8, v5, Lmiui/util/DecodeGifImageHelper$GifFrame;->mDuration:I

    invoke-virtual {p0, v2, v8}, Landroid/graphics/drawable/GifAnimationDrawable;->addFrame(Landroid/graphics/drawable/Drawable;I)V

    .end local v2           #drawable:Landroid/graphics/drawable/BitmapDrawable;
    .end local v5           #gifFame:Lmiui/util/DecodeGifImageHelper$GifFrame;
    :cond_75
    invoke-virtual {p0, v7}, Landroid/graphics/drawable/GifAnimationDrawable;->setOneShot(Z)V

    invoke-super {p0, v7}, Landroid/graphics/drawable/AnimationDrawable;->selectDrawable(I)Z

    const/4 v7, 0x1

    goto :goto_9
.end method

.method private internalLoad(Landroid/content/res/Resources;Lmiui/util/InputStreamLoader;)Z
    .registers 6
    .parameter "res"
    .parameter "gifSource"

    .prologue
    iput-object p1, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mResources:Landroid/content/res/Resources;

    iget-object v1, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mHelper:Lmiui/util/DecodeGifImageHelper;

    iput-object p2, v1, Lmiui/util/DecodeGifImageHelper;->mGifSource:Lmiui/util/InputStreamLoader;

    iget-object v1, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mHelper:Lmiui/util/DecodeGifImageHelper;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lmiui/util/DecodeGifImageHelper;->decodeFrom(I)Lmiui/util/DecodeGifImageHelper$GifDecodeResult;

    move-result-object v0

    .local v0, decodeResult:Lmiui/util/DecodeGifImageHelper$GifDecodeResult;
    invoke-direct {p0, v0}, Landroid/graphics/drawable/GifAnimationDrawable;->handleFirstDecodeResult(Lmiui/util/DecodeGifImageHelper$GifDecodeResult;)Z

    move-result v1

    return v1
.end method


# virtual methods
.method public load(Landroid/content/res/Resources;Landroid/content/Context;Landroid/net/Uri;)Z
    .registers 5
    .parameter "res"
    .parameter "context"
    .parameter "uri"

    .prologue
    new-instance v0, Lmiui/util/InputStreamLoader;

    invoke-direct {v0, p2, p3}, Lmiui/util/InputStreamLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;)V

    invoke-direct {p0, p1, v0}, Landroid/graphics/drawable/GifAnimationDrawable;->internalLoad(Landroid/content/res/Resources;Lmiui/util/InputStreamLoader;)Z

    move-result v0

    return v0
.end method

.method public load(Landroid/content/res/Resources;Ljava/lang/String;)Z
    .registers 4
    .parameter "res"
    .parameter "gifPath"

    .prologue
    new-instance v0, Lmiui/util/InputStreamLoader;

    invoke-direct {v0, p2}, Lmiui/util/InputStreamLoader;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, p1, v0}, Landroid/graphics/drawable/GifAnimationDrawable;->internalLoad(Landroid/content/res/Resources;Lmiui/util/InputStreamLoader;)Z

    move-result v0

    return v0
.end method

.method public load(Landroid/content/res/Resources;[B)Z
    .registers 4
    .parameter "res"
    .parameter "data"

    .prologue
    new-instance v0, Lmiui/util/InputStreamLoader;

    invoke-direct {v0, p2}, Lmiui/util/InputStreamLoader;-><init>([B)V

    invoke-direct {p0, p1, v0}, Landroid/graphics/drawable/GifAnimationDrawable;->internalLoad(Landroid/content/res/Resources;Lmiui/util/InputStreamLoader;)Z

    move-result v0

    return v0
.end method

.method public preSelectDrawable(I)V
    .registers 7
    .parameter "frame"

    .prologue
    const/4 v4, 0x0

    iget-object v2, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mHelper:Lmiui/util/DecodeGifImageHelper;

    iget-object v2, v2, Lmiui/util/DecodeGifImageHelper;->mFrames:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_c

    :goto_b
    return-void

    :cond_c
    iget-object v2, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mHelper:Lmiui/util/DecodeGifImageHelper;

    iget-object v2, v2, Lmiui/util/DecodeGifImageHelper;->mFrames:Ljava/util/List;

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lmiui/util/DecodeGifImageHelper$GifFrame;

    .local v1, gifFame:Lmiui/util/DecodeGifImageHelper$GifFrame;
    iget-object v2, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mHelper:Lmiui/util/DecodeGifImageHelper;

    iget-object v2, v2, Lmiui/util/DecodeGifImageHelper;->mFrames:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    const/4 v3, 0x1

    if-le v2, v3, :cond_28

    iget-object v2, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mHelper:Lmiui/util/DecodeGifImageHelper;

    iget-object v2, v2, Lmiui/util/DecodeGifImageHelper;->mFrames:Ljava/util/List;

    invoke-interface {v2, v4}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    :cond_28
    iget-object v2, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mHelper:Lmiui/util/DecodeGifImageHelper;

    invoke-virtual {v2}, Lmiui/util/DecodeGifImageHelper;->decodeNextFrames()V

    new-instance v0, Landroid/graphics/drawable/BitmapDrawable;

    iget-object v2, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mResources:Landroid/content/res/Resources;

    iget-object v3, v1, Lmiui/util/DecodeGifImageHelper$GifFrame;->mImage:Landroid/graphics/Bitmap;

    invoke-direct {v0, v2, v3}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .local v0, drawable:Landroid/graphics/drawable/BitmapDrawable;
    invoke-virtual {p0}, Landroid/graphics/drawable/GifAnimationDrawable;->getAnimationState()Landroid/graphics/drawable/AnimationDrawable$AnimationState;

    move-result-object v2

    iget-object v2, v2, Landroid/graphics/drawable/AnimationDrawable$AnimationState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    aput-object v0, v2, p1

    invoke-virtual {p0}, Landroid/graphics/drawable/GifAnimationDrawable;->getAnimationState()Landroid/graphics/drawable/AnimationDrawable$AnimationState;

    move-result-object v2

    iget v3, v1, Lmiui/util/DecodeGifImageHelper$GifFrame;->mDuration:I

    invoke-virtual {v2, p1, v3}, Landroid/graphics/drawable/AnimationDrawable$AnimationState;->setDuration(II)V

    goto :goto_b
.end method

.method public selectDrawable(I)Z
    .registers 3
    .parameter "idx"

    .prologue
    invoke-virtual {p0, p1}, Landroid/graphics/drawable/GifAnimationDrawable;->preSelectDrawable(I)V

    invoke-super {p0, p1}, Landroid/graphics/drawable/AnimationDrawable;->selectDrawable(I)Z

    move-result v0

    return v0
.end method

.method public setMaxDecodeSize(J)V
    .registers 4
    .parameter "maxDecodeSize"

    .prologue
    iget-object v0, p0, Landroid/graphics/drawable/GifAnimationDrawable;->mHelper:Lmiui/util/DecodeGifImageHelper;

    iput-wide p1, v0, Lmiui/util/DecodeGifImageHelper;->mMaxDecodeSize:J

    return-void
.end method
