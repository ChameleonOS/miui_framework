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
    .line 29
    iget-object v0, p3, Landroid/renderscript/Allocation;->mType:Landroid/renderscript/Type;

    iget v1, p3, Landroid/renderscript/Allocation;->mUsage:I

    invoke-direct {p0, p1, p2, v0, v1}, Landroid/renderscript/Allocation;-><init>(ILandroid/renderscript/RenderScript;Landroid/renderscript/Type;I)V

    .line 30
    iput-object p3, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    .line 31
    return-void
.end method

.method public static create1D(Landroid/renderscript/RenderScript;Landroid/renderscript/Allocation;)Landroid/renderscript/AllocationAdapter;
    .registers 5
    .parameter "rs"
    .parameter "a"

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 215
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 216
    new-instance v0, Landroid/renderscript/AllocationAdapter;

    invoke-direct {v0, v2, p0, p1}, Landroid/renderscript/AllocationAdapter;-><init>(ILandroid/renderscript/RenderScript;Landroid/renderscript/Allocation;)V

    .line 217
    .local v0, aa:Landroid/renderscript/AllocationAdapter;
    iput-boolean v1, v0, Landroid/renderscript/Allocation;->mConstrainedLOD:Z

    .line 218
    iput-boolean v1, v0, Landroid/renderscript/Allocation;->mConstrainedFace:Z

    .line 219
    iput-boolean v1, v0, Landroid/renderscript/Allocation;->mConstrainedY:Z

    .line 220
    iput-boolean v1, v0, Landroid/renderscript/Allocation;->mConstrainedZ:Z

    .line 221
    invoke-virtual {v0, v2}, Landroid/renderscript/AllocationAdapter;->initLOD(I)V

    .line 222
    return-object v0
.end method

.method public static create2D(Landroid/renderscript/RenderScript;Landroid/renderscript/Allocation;)Landroid/renderscript/AllocationAdapter;
    .registers 8
    .parameter "rs"
    .parameter "a"

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 226
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

    .line 227
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 228
    new-instance v0, Landroid/renderscript/AllocationAdapter;

    invoke-direct {v0, v4, p0, p1}, Landroid/renderscript/AllocationAdapter;-><init>(ILandroid/renderscript/RenderScript;Landroid/renderscript/Allocation;)V

    .line 229
    .local v0, aa:Landroid/renderscript/AllocationAdapter;
    iput-boolean v5, v0, Landroid/renderscript/Allocation;->mConstrainedLOD:Z

    .line 230
    iput-boolean v5, v0, Landroid/renderscript/Allocation;->mConstrainedFace:Z

    .line 231
    iput-boolean v4, v0, Landroid/renderscript/Allocation;->mConstrainedY:Z

    .line 232
    iput-boolean v5, v0, Landroid/renderscript/Allocation;->mConstrainedZ:Z

    .line 233
    invoke-virtual {v0, v4}, Landroid/renderscript/AllocationAdapter;->initLOD(I)V

    .line 234
    return-object v0
.end method


# virtual methods
.method getID(Landroid/renderscript/RenderScript;)I
    .registers 4
    .parameter "rs"

    .prologue
    .line 34
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

    .line 100
    if-gez p1, :cond_23

    .line 101
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

    .line 104
    :cond_23
    iget-object v4, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    iget-object v4, v4, Landroid/renderscript/Allocation;->mType:Landroid/renderscript/Type;

    invoke-virtual {v4}, Landroid/renderscript/Type;->getX()I

    move-result v1

    .line 105
    .local v1, tx:I
    iget-object v4, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    iget-object v4, v4, Landroid/renderscript/Allocation;->mType:Landroid/renderscript/Type;

    invoke-virtual {v4}, Landroid/renderscript/Type;->getY()I

    move-result v2

    .line 106
    .local v2, ty:I
    iget-object v4, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    iget-object v4, v4, Landroid/renderscript/Allocation;->mType:Landroid/renderscript/Type;

    invoke-virtual {v4}, Landroid/renderscript/Type;->getZ()I

    move-result v3

    .line 108
    .local v3, tz:I
    const/4 v0, 0x0

    .local v0, ct:I
    :goto_3c
    if-ge v0, p1, :cond_72

    .line 109
    if-ne v1, v6, :cond_63

    if-ne v2, v6, :cond_63

    if-ne v3, v6, :cond_63

    .line 110
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

    .line 113
    :cond_63
    if-le v1, v6, :cond_67

    shr-int/lit8 v1, v1, 0x1

    .line 114
    :cond_67
    if-le v2, v6, :cond_6b

    shr-int/lit8 v2, v2, 0x1

    .line 115
    :cond_6b
    if-le v3, v6, :cond_6f

    shr-int/lit8 v3, v3, 0x1

    .line 108
    :cond_6f
    add-int/lit8 v0, v0, 0x1

    goto :goto_3c

    .line 118
    :cond_72
    iput v1, p0, Landroid/renderscript/Allocation;->mCurrentDimX:I

    .line 119
    iput v2, p0, Landroid/renderscript/Allocation;->mCurrentDimY:I

    .line 120
    iput v3, p0, Landroid/renderscript/Allocation;->mCurrentDimZ:I

    .line 121
    iget v4, p0, Landroid/renderscript/Allocation;->mCurrentDimX:I

    iput v4, p0, Landroid/renderscript/Allocation;->mCurrentCount:I

    .line 122
    iget v4, p0, Landroid/renderscript/Allocation;->mCurrentDimY:I

    if-le v4, v6, :cond_87

    .line 123
    iget v4, p0, Landroid/renderscript/Allocation;->mCurrentCount:I

    iget v5, p0, Landroid/renderscript/Allocation;->mCurrentDimY:I

    mul-int/2addr v4, v5

    iput v4, p0, Landroid/renderscript/Allocation;->mCurrentCount:I

    .line 125
    :cond_87
    iget v4, p0, Landroid/renderscript/Allocation;->mCurrentDimZ:I

    if-le v4, v6, :cond_92

    .line 126
    iget v4, p0, Landroid/renderscript/Allocation;->mCurrentCount:I

    iget v5, p0, Landroid/renderscript/Allocation;->mCurrentDimZ:I

    mul-int/2addr v4, v5

    iput v4, p0, Landroid/renderscript/Allocation;->mCurrentCount:I

    .line 128
    :cond_92
    iput v7, p0, Landroid/renderscript/Allocation;->mSelectedY:I

    .line 129
    iput v7, p0, Landroid/renderscript/Allocation;->mSelectedZ:I

    .line 130
    return-void
.end method

.method public readData([F)V
    .registers 2
    .parameter "d"

    .prologue
    .line 96
    invoke-super {p0, p1}, Landroid/renderscript/Allocation;->copyTo([F)V

    .line 97
    return-void
.end method

.method public readData([I)V
    .registers 2
    .parameter "d"

    .prologue
    .line 90
    invoke-super {p0, p1}, Landroid/renderscript/Allocation;->copyTo([I)V

    .line 91
    return-void
.end method

.method public declared-synchronized resize(I)V
    .registers 4
    .parameter "dimX"

    .prologue
    .line 245
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
    .line 159
    iget-object v0, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    invoke-virtual {v0}, Landroid/renderscript/Allocation;->getType()Landroid/renderscript/Type;

    move-result-object v0

    invoke-virtual {v0}, Landroid/renderscript/Type;->hasFaces()Z

    move-result v0

    if-nez v0, :cond_14

    .line 160
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set Face when the allocation type does not include faces."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 162
    :cond_14
    iget-boolean v0, p0, Landroid/renderscript/Allocation;->mConstrainedFace:Z

    if-nez v0, :cond_20

    .line 163
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set LOD when the adapter includes mipmaps."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 165
    :cond_20
    if-nez p1, :cond_2a

    .line 166
    new-instance v0, Landroid/renderscript/RSIllegalArgumentException;

    const-string v1, "Cannot set null face."

    invoke-direct {v0, v1}, Landroid/renderscript/RSIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 169
    :cond_2a
    iput-object p1, p0, Landroid/renderscript/Allocation;->mSelectedFace:Landroid/renderscript/Type$CubemapFace;

    .line 170
    return-void
.end method

.method public setLOD(I)V
    .registers 4
    .parameter "lod"

    .prologue
    .line 142
    iget-object v0, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    invoke-virtual {v0}, Landroid/renderscript/Allocation;->getType()Landroid/renderscript/Type;

    move-result-object v0

    invoke-virtual {v0}, Landroid/renderscript/Type;->hasMipmaps()Z

    move-result v0

    if-nez v0, :cond_14

    .line 143
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set LOD when the allocation type does not include mipmaps."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 145
    :cond_14
    iget-boolean v0, p0, Landroid/renderscript/Allocation;->mConstrainedLOD:Z

    if-nez v0, :cond_20

    .line 146
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set LOD when the adapter includes mipmaps."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 149
    :cond_20
    invoke-virtual {p0, p1}, Landroid/renderscript/AllocationAdapter;->initLOD(I)V

    .line 150
    return-void
.end method

.method public setY(I)V
    .registers 4
    .parameter "y"

    .prologue
    .line 180
    iget-object v0, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    invoke-virtual {v0}, Landroid/renderscript/Allocation;->getType()Landroid/renderscript/Type;

    move-result-object v0

    invoke-virtual {v0}, Landroid/renderscript/Type;->getY()I

    move-result v0

    if-nez v0, :cond_14

    .line 181
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set Y when the allocation type does not include Y dim."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 183
    :cond_14
    iget-object v0, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    invoke-virtual {v0}, Landroid/renderscript/Allocation;->getType()Landroid/renderscript/Type;

    move-result-object v0

    invoke-virtual {v0}, Landroid/renderscript/Type;->getY()I

    move-result v0

    if-gt v0, p1, :cond_28

    .line 184
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set Y greater than dimension of allocation."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 186
    :cond_28
    iget-boolean v0, p0, Landroid/renderscript/Allocation;->mConstrainedY:Z

    if-nez v0, :cond_34

    .line 187
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set Y when the adapter includes Y."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 190
    :cond_34
    iput p1, p0, Landroid/renderscript/Allocation;->mSelectedY:I

    .line 191
    return-void
.end method

.method public setZ(I)V
    .registers 4
    .parameter "z"

    .prologue
    .line 201
    iget-object v0, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    invoke-virtual {v0}, Landroid/renderscript/Allocation;->getType()Landroid/renderscript/Type;

    move-result-object v0

    invoke-virtual {v0}, Landroid/renderscript/Type;->getZ()I

    move-result v0

    if-nez v0, :cond_14

    .line 202
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set Z when the allocation type does not include Z dim."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 204
    :cond_14
    iget-object v0, p0, Landroid/renderscript/Allocation;->mAdaptedAllocation:Landroid/renderscript/Allocation;

    invoke-virtual {v0}, Landroid/renderscript/Allocation;->getType()Landroid/renderscript/Type;

    move-result-object v0

    invoke-virtual {v0}, Landroid/renderscript/Type;->getZ()I

    move-result v0

    if-gt v0, p1, :cond_28

    .line 205
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set Z greater than dimension of allocation."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 207
    :cond_28
    iget-boolean v0, p0, Landroid/renderscript/Allocation;->mConstrainedZ:Z

    if-nez v0, :cond_34

    .line 208
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Cannot set Z when the adapter includes Z."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 211
    :cond_34
    iput p1, p0, Landroid/renderscript/Allocation;->mSelectedZ:I

    .line 212
    return-void
.end method

.method public subData(ILandroid/renderscript/FieldPacker;)V
    .registers 3
    .parameter "xoff"
    .parameter "fp"

    .prologue
    .line 42
    invoke-super {p0, p1, p2}, Landroid/renderscript/Allocation;->setFromFieldPacker(ILandroid/renderscript/FieldPacker;)V

    .line 43
    return-void
.end method

.method public subData1D(II[B)V
    .registers 4
    .parameter "off"
    .parameter "count"
    .parameter "d"

    .prologue
    .line 66
    invoke-super {p0, p1, p2, p3}, Landroid/renderscript/Allocation;->copy1DRangeFrom(II[B)V

    .line 67
    return-void
.end method

.method public subData1D(II[F)V
    .registers 4
    .parameter "off"
    .parameter "count"
    .parameter "d"

    .prologue
    .line 72
    invoke-super {p0, p1, p2, p3}, Landroid/renderscript/Allocation;->copy1DRangeFrom(II[F)V

    .line 73
    return-void
.end method

.method public subData1D(II[I)V
    .registers 4
    .parameter "off"
    .parameter "count"
    .parameter "d"

    .prologue
    .line 54
    invoke-super {p0, p1, p2, p3}, Landroid/renderscript/Allocation;->copy1DRangeFrom(II[I)V

    .line 55
    return-void
.end method

.method public subData1D(II[S)V
    .registers 4
    .parameter "off"
    .parameter "count"
    .parameter "d"

    .prologue
    .line 60
    invoke-super {p0, p1, p2, p3}, Landroid/renderscript/Allocation;->copy1DRangeFrom(II[S)V

    .line 61
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
    .line 84
    invoke-super/range {p0 .. p5}, Landroid/renderscript/Allocation;->copy2DRangeFrom(IIII[F)V

    .line 85
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
    .line 78
    invoke-super/range {p0 .. p5}, Landroid/renderscript/Allocation;->copy2DRangeFrom(IIII[I)V

    .line 79
    return-void
.end method

.method public subElementData(IILandroid/renderscript/FieldPacker;)V
    .registers 4
    .parameter "xoff"
    .parameter "component_number"
    .parameter "fp"

    .prologue
    .line 48
    invoke-super {p0, p1, p2, p3}, Landroid/renderscript/Allocation;->setFromFieldPacker(IILandroid/renderscript/FieldPacker;)V

    .line 49
    return-void
.end method
