.class public Landroid/opengl/ETC1Util$ETC1Texture;
.super Ljava/lang/Object;
.source "ETC1Util.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/opengl/ETC1Util;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ETC1Texture"
.end annotation


# instance fields
.field private mData:Ljava/nio/ByteBuffer;

.field private mHeight:I

.field private mWidth:I


# direct methods
.method public constructor <init>(IILjava/nio/ByteBuffer;)V
    .registers 4
    .parameter "width"
    .parameter "height"
    .parameter "data"

    .prologue
    .line 117
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 118
    iput p1, p0, Landroid/opengl/ETC1Util$ETC1Texture;->mWidth:I

    .line 119
    iput p2, p0, Landroid/opengl/ETC1Util$ETC1Texture;->mHeight:I

    .line 120
    iput-object p3, p0, Landroid/opengl/ETC1Util$ETC1Texture;->mData:Ljava/nio/ByteBuffer;

    .line 121
    return-void
.end method


# virtual methods
.method public getData()Ljava/nio/ByteBuffer;
    .registers 2

    .prologue
    .line 139
    iget-object v0, p0, Landroid/opengl/ETC1Util$ETC1Texture;->mData:Ljava/nio/ByteBuffer;

    return-object v0
.end method

.method public getHeight()I
    .registers 2

    .prologue
    .line 133
    iget v0, p0, Landroid/opengl/ETC1Util$ETC1Texture;->mHeight:I

    return v0
.end method

.method public getWidth()I
    .registers 2

    .prologue
    .line 127
    iget v0, p0, Landroid/opengl/ETC1Util$ETC1Texture;->mWidth:I

    return v0
.end method
