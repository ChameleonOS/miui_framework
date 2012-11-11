.class public Landroid/renderscript/AllocationAdapter;
.super Landroid/renderscript/Allocation;
.source "AllocationAdapter.java"


# direct methods
.method constructor <init>(ILandroid/renderscript/RenderScript;Landroid/renderscript/Allocation;)V
    .registers 6
    .parameter "id"
    .parameter "rs"
    .parameter "alloc"

    .prologue
    iget-object v0, p3, Landroid/renderscript/Allocation;->mType:Landroid/renderscript/Type;

    iget v1, p3, Landroid/renderscript/Allocation;->mUsage:I

    invoke-direct {p0, p1, p2, v0, v1}, Landroid/renderscript/Allocation;-><init>(ILandroid/renderscript/RenderScript;Landroid/renderscript/Type;I)V

    iput-object p3, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    return-void
.end method

.method public static create1D(Landroid/renderscript/RenderScript;Landroid/renderscript/Allocation;)Landroid/renderscript/AllocationAdapter;
    .registers 5
    .parameter "rs"
    .parameter "a"

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    new-instance v0, Landroid/renderscript/AllocationAdapter;

    invoke-direct {v0, v2, p0, p1}, Landroid/renderscript/AllocationAdapter;-><init>(ILandroid/renderscript/RenderScript;Landroid/renderscript/Allocation;)V

    .local v0, aa:Landroid/renderscript/AllocationAdapter;
    iput-boolean v1, v0, Landroid/renderscript/Allocation;->mConstrainedLOD:Z

    iput-boolean v1, v0, Landroid/renderscript/Allocation;->mConstrainedFace:Z

    iput-boolean v1, v0, Landroid/renderscript/Allocation;->mConstrainedY:Z

    iput-boolean v1, v0, Landroid/renderscript/Allocation;->mConstrainedZ:Z

    invoke-virtual {v0, v2}, Landroid/renderscript/AllocationAdapter;->initLOD(I)V

    return-object v0
.end method

.method public static create2D(Landroid/renderscript/RenderScript;Landroid/renderscript/Allocation;)Landroid/renderscript/AllocationAdapter;
    .registers 8
    .parameter "rs"
    .parameter "a"

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    const-string/jumbo v1, "rs"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "create2d "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    new-instance v0, Landroid/renderscript/AllocationAdapter;

    invoke-direct {v0, v4, p0, p1}, Landroid/renderscript/AllocationAdapter;-><init>(ILandroid/renderscript/RenderScript;Landroid/renderscript/Allocation;)V

    .local v0, aa:Landroid/renderscript/AllocationAdapter;
    iput-boolean v5, v0, Landroid/renderscript/Allocation;->mConstrainedLOD:Z

    iput-boolean v5, v0, Landroid/renderscript/Allocation;->mConstrainedFace:Z

    iput-boolean v4, v0, Landroid/renderscript/Allocation;->mConstrainedY:Z

    iput-boolean v5, v0, Landroid/renderscript/Allocation;->mConstrainedZ:Z

    invoke-virtual {v0, v4}, Landroid/renderscript/AllocationAdapter;->initLOD(I)V

    return-object v0
.end method


# virtual methods
.method getID(Landroid/renderscript/RenderScript;)I
    .registers 4
    .parameter "rs"

    .prologue
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "This operation is not supported with adapters at this time."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method initLOD(I)V
    .registers 10
    .parameter "lod"

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    if-gez p1, :cond_23

    new-instance v4, Landroid/renderscript/RSIllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Attempting to set negative lod ("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ")."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Landroid/renderscript/RSIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    :cond_23
    iget-object v4, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    iget-object v4, v4, Landroid/renderscript/Allocation;->mType:Landroid/renderscript/Type;

    invoke-virtual {v4}, Landroid/renderscript/Type;->getX()I

    move-result v1

    .local v1, tx:I
    iget-object v4, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    iget-object v4, v4, Landroid/renderscript/Allocation;->mType:Landroid/renderscript/Type;

    invoke-virtual {v4}, Landroid/renderscript/Type;->getY()I

    move-result v2

    .local v2, ty:I
    iget-object v4, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    iget-object v4, v4, Landroid/renderscript/Allocation;->mType:Landroid/renderscript/Type;

    invoke-virtual {v4}, Landroid/renderscript/Type;->getZ()I

    move-result v3

    .local v3, tz:I
    const/4 v0, 0x0

    .local v0, ct:I
    :goto_3c
    if-ge v0, p1, :cond_72

    if-ne v1, v6, :cond_63

    if-ne v2, v6, :cond_63

    if-ne v3, v6, :cond_63

    new-instance v4, Landroid/renderscript/RSIllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Attempting to set lod ("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ") out of range."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Landroid/renderscript/RSIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    :cond_63
    if-le v1, v6, :cond_67

    shr-int/lit8 v1, v1, 0x1

    :cond_67
    if-le v2, v6, :cond_6b

    shr-int/lit8 v2, v2, 0x1

    :cond_6b
    if-le v3, v6, :cond_6f

    shr-int/lit8 v3, v3, 0x1

    :cond_6f
    add-int/lit8 v0, v0, 0x1

    goto :goto_3c

    :cond_72
    iput v1, p0, Landroid/renderscript/Allocation;->mCurrentDimX:I

    iput v2, p0, Landroid/renderscript/Allocation;->mCurrentDimY:I

    iput v3, p0, Landroid/renderscript/Allocation;->mCurrentDimZ:I

    iget v4, p0, Landroid/renderscript/Allocation;->mCurrentDimX:I

    iput v4, p0, Landroid/renderscript/Allocation;->mCurrentCount:I

    iget v4, p0, Landroid/renderscript/Allocation;->mCurrentDimY:I

    if-le v4, v6, :cond_87

    iget v4, p0, Landroid/renderscript/Allocation;->mCurrentCount:I

    iget v5, p0, Landroid/renderscript/Allocation;->mCurrentDimY:I

    mul-int/2addr v4, v5

    iput v4, p0, Landroid/renderscript/Allocation;->mCurrentCount:I

    :cond_87
    iget v4, p0, Landroid/renderscript/Allocation;->mCurrentDimZ:I

    if-le v4, v6, :cond_92

    iget v4, p0, Landroid/renderscript/Allocation;->mCurrentCount:I

    iget v5, p0, Landroid/renderscript/Allocation;->mCurrentDimZ:I

    mul-int/2addr v4, v5

    iput v4, p0, Landroid/renderscript/Allocation;->mCurrentCount:I

    :cond_92
    iput v7, p0, Landroid/renderscript/Allocation;->mSelectedY:I

    iput v7, p0, Landroid/renderscript/Allocation;->mSelectedZ:I

    return-void
.end method

.method public readData([F)V
    .registers 2
    .parameter "d"

    .prologue
    invoke-super {p0, p1}, Landroid/renderscript/Allocation;->copyTo([F)V

    return-void
.end method

.method public readData([I)V
    .registers 2
    .parameter "d"

    .prologue
    invoke-super {p0, p1}, Landroid/renderscript/Allocation;->copyTo([I)V

    return-void
.end method

.method public declared-synchronized resize(I)V
    .registers 4
    .parameter "dimX"

    .prologue
    monitor-enter p0

    :try_start_1
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Resize not allowed for Adapters."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_9

    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setFace(Landroid/renderscript/Type$CubemapFace;)V
    .registers 4
    .parameter "cf"

    .prologue
    iget-object v0, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    invoke-virtual {v0}, Landroid/renderscript/Allocation;->getType()Landroid/renderscript/Type;

    move-result-object v0

    invoke-virtual {v0}, Landroid/renderscript/Type;->hasFaces()Z

    move-result v0

    if-nez v0, :cond_14

    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set Face when the allocation type does not include faces."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_14
    iget-boolean v0, p0, Landroid/renderscript/Allocation;->mConstrainedFace:Z

    if-nez v0, :cond_20

    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set LOD when the adapter includes mipmaps."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_20
    if-nez p1, :cond_2a

    new-instance v0, Landroid/renderscript/RSIllegalArgumentException;

    const-string v1, "Cannot set null face."

    invoke-direct {v0, v1}, Landroid/renderscript/RSIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2a
    iput-object p1, p0, Landroid/renderscript/Allocation;->mSelectedFace:Landroid/renderscript/Type$CubemapFace;

    return-void
.end method

.method public setLOD(I)V
    .registers 4
    .parameter "lod"

    .prologue
    iget-object v0, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    invoke-virtual {v0}, Landroid/renderscript/Allocation;->getType()Landroid/renderscript/Type;

    move-result-object v0

    invoke-virtual {v0}, Landroid/renderscript/Type;->hasMipmaps()Z

    move-result v0

    if-nez v0, :cond_14

    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set LOD when the allocation type does not include mipmaps."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_14
    iget-boolean v0, p0, Landroid/renderscript/Allocation;->mConstrainedLOD:Z

    if-nez v0, :cond_20

    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set LOD when the adapter includes mipmaps."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_20
    invoke-virtual {p0, p1}, Landroid/renderscript/AllocationAdapter;->initLOD(I)V

    return-void
.end method

.method public setY(I)V
    .registers 4
    .parameter "y"

    .prologue
    iget-object v0, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    invoke-virtual {v0}, Landroid/renderscript/Allocation;->getType()Landroid/renderscript/Type;

    move-result-object v0

    invoke-virtual {v0}, Landroid/renderscript/Type;->getY()I

    move-result v0

    if-nez v0, :cond_14

    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set Y when the allocation type does not include Y dim."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_14
    iget-object v0, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    invoke-virtual {v0}, Landroid/renderscript/Allocation;->getType()Landroid/renderscript/Type;

    move-result-object v0

    invoke-virtual {v0}, Landroid/renderscript/Type;->getY()I

    move-result v0

    if-gt v0, p1, :cond_28

    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set Y greater than dimension of allocation."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_28
    iget-boolean v0, p0, Landroid/renderscript/Allocation;->mConstrainedY:Z

    if-nez v0, :cond_34

    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set Y when the adapter includes Y."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_34
    iput p1, p0, Landroid/renderscript/Allocation;->mSelectedY:I

    return-void
.end method

.method public setZ(I)V
    .registers 4
    .parameter "z"

    .prologue
    iget-object v0, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    invoke-virtual {v0}, Landroid/renderscript/Allocation;->getType()Landroid/renderscript/Type;

    move-result-object v0

    invoke-virtual {v0}, Landroid/renderscript/Type;->getZ()I

    move-result v0

    if-nez v0, :cond_14

    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set Z when the allocation type does not include Z dim."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_14
    iget-object v0, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    invoke-virtual {v0}, Landroid/renderscript/Allocation;->getType()Landroid/renderscript/Type;

    move-result-object v0

    invoke-virtual {v0}, Landroid/renderscript/Type;->getZ()I

    move-result v0

    if-gt v0, p1, :cond_28

    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set Z greater than dimension of allocation."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_28
    iget-boolean v0, p0, Landroid/renderscript/Allocation;->mConstrainedZ:Z

    if-nez v0, :cond_34

    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set Z when the adapter includes Z."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_34
    iput p1, p0, Landroid/renderscript/Allocation;->mSelectedZ:I

    return-void
.end method

.method public subData(ILandroid/renderscript/FieldPacker;)V
    .registers 3
    .parameter "xoff"
    .parameter "fp"

    .prologue
    invoke-super {p0, p1, p2}, Landroid/renderscript/Allocation;->setFromFieldPacker(ILandroid/renderscript/FieldPacker;)V

    return-void
.end method

.method public subData1D(II[B)V
    .registers 4
    .parameter "off"
    .parameter "count"
    .parameter "d"

    .prologue
    invoke-super {p0, p1, p2, p3}, Landroid/renderscript/Allocation;->copy1DRangeFrom(II[B)V

    return-void
.end method

.method public subData1D(II[F)V
    .registers 4
    .parameter "off"
    .parameter "count"
    .parameter "d"

    .prologue
    invoke-super {p0, p1, p2, p3}, Landroid/renderscript/Allocation;->copy1DRangeFrom(II[F)V

    return-void
.end method

.method public subData1D(II[I)V
    .registers 4
    .parameter "off"
    .parameter "count"
    .parameter "d"

    .prologue
    invoke-super {p0, p1, p2, p3}, Landroid/renderscript/Allocation;->copy1DRangeFrom(II[I)V

    return-void
.end method

.method public subData1D(II[S)V
    .registers 4
    .parameter "off"
    .parameter "count"
    .parameter "d"

    .prologue
    invoke-super {p0, p1, p2, p3}, Landroid/renderscript/Allocation;->copy1DRangeFrom(II[S)V

    return-void
.end method

.method public subData2D(IIII[F)V
    .registers 6
    .parameter "xoff"
    .parameter "yoff"
    .parameter "w"
    .parameter "h"
    .parameter "d"

    .prologue
    invoke-super/range {p0 .. p5}, Landroid/renderscript/Allocation;->copy2DRangeFrom(IIII[F)V

    return-void
.end method

.method public subData2D(IIII[I)V
    .registers 6
    .parameter "xoff"
    .parameter "yoff"
    .parameter "w"
    .parameter "h"
    .parameter "d"

    .prologue
    invoke-super/range {p0 .. p5}, Landroid/renderscript/Allocation;->copy2DRangeFrom(IIII[I)V

    return-void
.end method

.method public subElementData(IILandroid/renderscript/FieldPacker;)V
    .registers 4
    .parameter "xoff"
    .parameter "component_number"
    .parameter "fp"

    .prologue
    invoke-super {p0, p1, p2, p3}, Landroid/renderscript/Allocation;->setFromFieldPacker(IILandroid/renderscript/FieldPacker;)V

    return-void
.end method
