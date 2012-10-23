.class public Landroid/renderscript/Type$Builder;
.super Ljava/lang/Object;
.source "Type.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/renderscript/Type;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field mDimFaces:Z

.field mDimMipmaps:Z

.field mDimX:I

.field mDimY:I

.field mDimZ:I

.field mElement:Landroid/renderscript/Element;

.field mRS:Landroid/renderscript/RenderScript;


# direct methods
.method public constructor <init>(Landroid/renderscript/RenderScript;Landroid/renderscript/Element;)V
    .registers 4
    .parameter "rs"
    .parameter "e"

    .prologue
    .line 219
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 205
    const/4 v0, 0x1

    iput v0, p0, Landroid/renderscript/Type$Builder;->mDimX:I

    .line 220
    invoke-virtual {p2}, Landroid/renderscript/Element;->checkValid()V

    .line 221
    iput-object p1, p0, Landroid/renderscript/Type$Builder;->mRS:Landroid/renderscript/RenderScript;

    .line 222
    iput-object p2, p0, Landroid/renderscript/Type$Builder;->mElement:Landroid/renderscript/Element;

    .line 223
    return-void
.end method


# virtual methods
.method public create()Landroid/renderscript/Type;
    .registers 10

    .prologue
    const/4 v1, 0x1

    .line 264
    iget v0, p0, Landroid/renderscript/Type$Builder;->mDimZ:I

    if-lez v0, :cond_21

    .line 265
    iget v0, p0, Landroid/renderscript/Type$Builder;->mDimX:I

    if-lt v0, v1, :cond_d

    iget v0, p0, Landroid/renderscript/Type$Builder;->mDimY:I

    if-ge v0, v1, :cond_15

    .line 266
    :cond_d
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Both X and Y dimension required when Z is present."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 268
    :cond_15
    iget-boolean v0, p0, Landroid/renderscript/Type$Builder;->mDimFaces:Z

    if-eqz v0, :cond_21

    .line 269
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cube maps not supported with 3D types."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 272
    :cond_21
    iget v0, p0, Landroid/renderscript/Type$Builder;->mDimY:I

    if-lez v0, :cond_31

    .line 273
    iget v0, p0, Landroid/renderscript/Type$Builder;->mDimX:I

    if-ge v0, v1, :cond_31

    .line 274
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "X dimension required when Y is present."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 277
    :cond_31
    iget-boolean v0, p0, Landroid/renderscript/Type$Builder;->mDimFaces:Z

    if-eqz v0, :cond_41

    .line 278
    iget v0, p0, Landroid/renderscript/Type$Builder;->mDimY:I

    if-ge v0, v1, :cond_41

    .line 279
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cube maps require 2D Types."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 283
    :cond_41
    iget-object v0, p0, Landroid/renderscript/Type$Builder;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/Type$Builder;->mElement:Landroid/renderscript/Element;

    iget-object v2, p0, Landroid/renderscript/Type$Builder;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {v1, v2}, Landroid/renderscript/Element;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    iget v2, p0, Landroid/renderscript/Type$Builder;->mDimX:I

    iget v3, p0, Landroid/renderscript/Type$Builder;->mDimY:I

    iget v4, p0, Landroid/renderscript/Type$Builder;->mDimZ:I

    iget-boolean v5, p0, Landroid/renderscript/Type$Builder;->mDimMipmaps:Z

    iget-boolean v6, p0, Landroid/renderscript/Type$Builder;->mDimFaces:Z

    invoke-virtual/range {v0 .. v6}, Landroid/renderscript/RenderScript;->nTypeCreate(IIIIZZ)I

    move-result v7

    .line 285
    .local v7, id:I
    new-instance v8, Landroid/renderscript/Type;

    iget-object v0, p0, Landroid/renderscript/Type$Builder;->mRS:Landroid/renderscript/RenderScript;

    invoke-direct {v8, v7, v0}, Landroid/renderscript/Type;-><init>(ILandroid/renderscript/RenderScript;)V

    .line 286
    .local v8, t:Landroid/renderscript/Type;
    iget-object v0, p0, Landroid/renderscript/Type$Builder;->mElement:Landroid/renderscript/Element;

    iput-object v0, v8, Landroid/renderscript/Type;->mElement:Landroid/renderscript/Element;

    .line 287
    iget v0, p0, Landroid/renderscript/Type$Builder;->mDimX:I

    iput v0, v8, Landroid/renderscript/Type;->mDimX:I

    .line 288
    iget v0, p0, Landroid/renderscript/Type$Builder;->mDimY:I

    iput v0, v8, Landroid/renderscript/Type;->mDimY:I

    .line 289
    iget v0, p0, Landroid/renderscript/Type$Builder;->mDimZ:I

    iput v0, v8, Landroid/renderscript/Type;->mDimZ:I

    .line 290
    iget-boolean v0, p0, Landroid/renderscript/Type$Builder;->mDimMipmaps:Z

    iput-boolean v0, v8, Landroid/renderscript/Type;->mDimMipmaps:Z

    .line 291
    iget-boolean v0, p0, Landroid/renderscript/Type$Builder;->mDimFaces:Z

    iput-boolean v0, v8, Landroid/renderscript/Type;->mDimFaces:Z

    .line 293
    invoke-virtual {v8}, Landroid/renderscript/Type;->calcElementCount()V

    .line 294
    return-object v8
.end method

.method public setFaces(Z)Landroid/renderscript/Type$Builder;
    .registers 2
    .parameter "value"

    .prologue
    .line 253
    iput-boolean p1, p0, Landroid/renderscript/Type$Builder;->mDimFaces:Z

    .line 254
    return-object p0
.end method

.method public setMipmaps(Z)Landroid/renderscript/Type$Builder;
    .registers 2
    .parameter "value"

    .prologue
    .line 248
    iput-boolean p1, p0, Landroid/renderscript/Type$Builder;->mDimMipmaps:Z

    .line 249
    return-object p0
.end method

.method public setX(I)Landroid/renderscript/Type$Builder;
    .registers 4
    .parameter "value"

    .prologue
    .line 232
    const/4 v0, 0x1

    if-ge p1, v0, :cond_b

    .line 233
    new-instance v0, Landroid/renderscript/RSIllegalArgumentException;

    const-string v1, "Values of less than 1 for Dimension X are not valid."

    invoke-direct {v0, v1}, Landroid/renderscript/RSIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 235
    :cond_b
    iput p1, p0, Landroid/renderscript/Type$Builder;->mDimX:I

    .line 236
    return-object p0
.end method

.method public setY(I)Landroid/renderscript/Type$Builder;
    .registers 4
    .parameter "value"

    .prologue
    .line 240
    const/4 v0, 0x1

    if-ge p1, v0, :cond_b

    .line 241
    new-instance v0, Landroid/renderscript/RSIllegalArgumentException;

    const-string v1, "Values of less than 1 for Dimension Y are not valid."

    invoke-direct {v0, v1}, Landroid/renderscript/RSIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 243
    :cond_b
    iput p1, p0, Landroid/renderscript/Type$Builder;->mDimY:I

    .line 244
    return-object p0
.end method
