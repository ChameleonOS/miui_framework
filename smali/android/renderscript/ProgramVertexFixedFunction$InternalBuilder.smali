.class Landroid/renderscript/ProgramVertexFixedFunction$InternalBuilder;
.super Landroid/renderscript/Program$BaseProgramBuilder;
.source "ProgramVertexFixedFunction.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/renderscript/ProgramVertexFixedFunction;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "InternalBuilder"
.end annotation


# direct methods
.method public constructor <init>(Landroid/renderscript/RenderScript;)V
    .registers 2
    .parameter "rs"

    .prologue
    .line 54
    invoke-direct {p0, p1}, Landroid/renderscript/Program$BaseProgramBuilder;-><init>(Landroid/renderscript/RenderScript;)V

    .line 55
    return-void
.end method


# virtual methods
.method public addInput(Landroid/renderscript/Element;)Landroid/renderscript/ProgramVertexFixedFunction$InternalBuilder;
    .registers 5
    .parameter "e"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 62
    iget v0, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mInputCount:I

    const/16 v1, 0x8

    if-lt v0, v1, :cond_e

    .line 63
    new-instance v0, Landroid/renderscript/RSIllegalArgumentException;

    const-string v1, "Max input count exceeded."

    invoke-direct {v0, v1}, Landroid/renderscript/RSIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 65
    :cond_e
    invoke-virtual {p1}, Landroid/renderscript/Element;->isComplex()Z

    move-result v0

    if-eqz v0, :cond_1c

    .line 66
    new-instance v0, Landroid/renderscript/RSIllegalArgumentException;

    const-string v1, "Complex elements not allowed."

    invoke-direct {v0, v1}, Landroid/renderscript/RSIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 68
    :cond_1c
    iget-object v0, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mInputs:[Landroid/renderscript/Element;

    iget v1, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mInputCount:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mInputCount:I

    aput-object p1, v0, v1

    .line 69
    return-object p0
.end method

.method public create()Landroid/renderscript/ProgramVertexFixedFunction;
    .registers 10

    .prologue
    .line 80
    iget-object v7, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {v7}, Landroid/renderscript/RenderScript;->validate()V

    .line 81
    iget v7, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mInputCount:I

    iget v8, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mOutputCount:I

    add-int/2addr v7, v8

    iget v8, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mConstantCount:I

    add-int/2addr v7, v8

    iget v8, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mTextureCount:I

    add-int/2addr v7, v8

    mul-int/lit8 v7, v7, 0x2

    new-array v6, v7, [I

    .line 82
    .local v6, tmp:[I
    iget v7, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mTextureCount:I

    new-array v5, v7, [Ljava/lang/String;

    .line 83
    .local v5, texNames:[Ljava/lang/String;
    const/4 v2, 0x0

    .line 85
    .local v2, idx:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1a
    iget v7, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mInputCount:I

    if-ge v0, v7, :cond_37

    .line 86
    add-int/lit8 v3, v2, 0x1

    .end local v2           #idx:I
    .local v3, idx:I
    sget-object v7, Landroid/renderscript/Program$ProgramParam;->INPUT:Landroid/renderscript/Program$ProgramParam;

    iget v7, v7, Landroid/renderscript/Program$ProgramParam;->mID:I

    aput v7, v6, v2

    .line 87
    add-int/lit8 v2, v3, 0x1

    .end local v3           #idx:I
    .restart local v2       #idx:I
    iget-object v7, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mInputs:[Landroid/renderscript/Element;

    aget-object v7, v7, v0

    iget-object v8, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {v7, v8}, Landroid/renderscript/Element;->getID(Landroid/renderscript/RenderScript;)I

    move-result v7

    aput v7, v6, v3

    .line 85
    add-int/lit8 v0, v0, 0x1

    goto :goto_1a

    .line 89
    :cond_37
    const/4 v0, 0x0

    :goto_38
    iget v7, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mOutputCount:I

    if-ge v0, v7, :cond_55

    .line 90
    add-int/lit8 v3, v2, 0x1

    .end local v2           #idx:I
    .restart local v3       #idx:I
    sget-object v7, Landroid/renderscript/Program$ProgramParam;->OUTPUT:Landroid/renderscript/Program$ProgramParam;

    iget v7, v7, Landroid/renderscript/Program$ProgramParam;->mID:I

    aput v7, v6, v2

    .line 91
    add-int/lit8 v2, v3, 0x1

    .end local v3           #idx:I
    .restart local v2       #idx:I
    iget-object v7, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mOutputs:[Landroid/renderscript/Element;

    aget-object v7, v7, v0

    iget-object v8, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {v7, v8}, Landroid/renderscript/Element;->getID(Landroid/renderscript/RenderScript;)I

    move-result v7

    aput v7, v6, v3

    .line 89
    add-int/lit8 v0, v0, 0x1

    goto :goto_38

    .line 93
    :cond_55
    const/4 v0, 0x0

    :goto_56
    iget v7, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mConstantCount:I

    if-ge v0, v7, :cond_73

    .line 94
    add-int/lit8 v3, v2, 0x1

    .end local v2           #idx:I
    .restart local v3       #idx:I
    sget-object v7, Landroid/renderscript/Program$ProgramParam;->CONSTANT:Landroid/renderscript/Program$ProgramParam;

    iget v7, v7, Landroid/renderscript/Program$ProgramParam;->mID:I

    aput v7, v6, v2

    .line 95
    add-int/lit8 v2, v3, 0x1

    .end local v3           #idx:I
    .restart local v2       #idx:I
    iget-object v7, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mConstants:[Landroid/renderscript/Type;

    aget-object v7, v7, v0

    iget-object v8, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {v7, v8}, Landroid/renderscript/Type;->getID(Landroid/renderscript/RenderScript;)I

    move-result v7

    aput v7, v6, v3

    .line 93
    add-int/lit8 v0, v0, 0x1

    goto :goto_56

    .line 97
    :cond_73
    const/4 v0, 0x0

    :goto_74
    iget v7, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mTextureCount:I

    if-ge v0, v7, :cond_93

    .line 98
    add-int/lit8 v3, v2, 0x1

    .end local v2           #idx:I
    .restart local v3       #idx:I
    sget-object v7, Landroid/renderscript/Program$ProgramParam;->TEXTURE_TYPE:Landroid/renderscript/Program$ProgramParam;

    iget v7, v7, Landroid/renderscript/Program$ProgramParam;->mID:I

    aput v7, v6, v2

    .line 99
    add-int/lit8 v2, v3, 0x1

    .end local v3           #idx:I
    .restart local v2       #idx:I
    iget-object v7, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mTextureTypes:[Landroid/renderscript/Program$TextureType;

    aget-object v7, v7, v0

    iget v7, v7, Landroid/renderscript/Program$TextureType;->mID:I

    aput v7, v6, v3

    .line 100
    iget-object v7, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mTextureNames:[Ljava/lang/String;

    aget-object v7, v7, v0

    aput-object v7, v5, v0

    .line 97
    add-int/lit8 v0, v0, 0x1

    goto :goto_74

    .line 103
    :cond_93
    iget-object v7, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mRS:Landroid/renderscript/RenderScript;

    iget-object v8, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mShader:Ljava/lang/String;

    invoke-virtual {v7, v8, v5, v6}, Landroid/renderscript/RenderScript;->nProgramVertexCreate(Ljava/lang/String;[Ljava/lang/String;[I)I

    move-result v1

    .line 104
    .local v1, id:I
    new-instance v4, Landroid/renderscript/ProgramVertexFixedFunction;

    iget-object v7, p0, Landroid/renderscript/Program$BaseProgramBuilder;->mRS:Landroid/renderscript/RenderScript;

    invoke-direct {v4, v1, v7}, Landroid/renderscript/ProgramVertexFixedFunction;-><init>(ILandroid/renderscript/RenderScript;)V

    .line 105
    .local v4, pv:Landroid/renderscript/ProgramVertexFixedFunction;
    invoke-virtual {p0, v4}, Landroid/renderscript/ProgramVertexFixedFunction$InternalBuilder;->initProgram(Landroid/renderscript/Program;)V

    .line 106
    return-object v4
.end method
