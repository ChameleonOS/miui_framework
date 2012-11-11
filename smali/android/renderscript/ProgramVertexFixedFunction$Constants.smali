.class public Landroid/renderscript/ProgramVertexFixedFunction$Constants;
.super Ljava/lang/Object;
.source "ProgramVertexFixedFunction.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/renderscript/ProgramVertexFixedFunction;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Constants"
.end annotation


# static fields
.field static final MODELVIEW_OFFSET:I = 0x0

.field static final PROJECTION_OFFSET:I = 0x10

.field static final TEXTURE_OFFSET:I = 0x20


# instance fields
.field mAlloc:Landroid/renderscript/Allocation;

.field private mIOBuffer:Landroid/renderscript/FieldPacker;

.field mModel:Landroid/renderscript/Matrix4f;

.field mProjection:Landroid/renderscript/Matrix4f;

.field mTexture:Landroid/renderscript/Matrix4f;


# direct methods
.method public constructor <init>(Landroid/renderscript/RenderScript;)V
    .registers 6
    .parameter "rs"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->getConstantInputType(Landroid/renderscript/RenderScript;)Landroid/renderscript/Type;

    move-result-object v1

    .local v1, constInputType:Landroid/renderscript/Type;
    invoke-static {p1, v1}, Landroid/renderscript/Allocation;->createTyped(Landroid/renderscript/RenderScript;Landroid/renderscript/Type;)Landroid/renderscript/Allocation;

    move-result-object v2

    iput-object v2, p0, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->mAlloc:Landroid/renderscript/Allocation;

    invoke-virtual {v1}, Landroid/renderscript/Type;->getElement()Landroid/renderscript/Element;

    move-result-object v2

    invoke-virtual {v2}, Landroid/renderscript/Element;->getBytesSize()I

    move-result v2

    invoke-virtual {v1}, Landroid/renderscript/Type;->getCount()I

    move-result v3

    mul-int v0, v2, v3

    .local v0, bufferSize:I
    new-instance v2, Landroid/renderscript/FieldPacker;

    invoke-direct {v2, v0}, Landroid/renderscript/FieldPacker;-><init>(I)V

    iput-object v2, p0, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->mIOBuffer:Landroid/renderscript/FieldPacker;

    new-instance v2, Landroid/renderscript/Matrix4f;

    invoke-direct {v2}, Landroid/renderscript/Matrix4f;-><init>()V

    iput-object v2, p0, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->mModel:Landroid/renderscript/Matrix4f;

    new-instance v2, Landroid/renderscript/Matrix4f;

    invoke-direct {v2}, Landroid/renderscript/Matrix4f;-><init>()V

    iput-object v2, p0, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->mProjection:Landroid/renderscript/Matrix4f;

    new-instance v2, Landroid/renderscript/Matrix4f;

    invoke-direct {v2}, Landroid/renderscript/Matrix4f;-><init>()V

    iput-object v2, p0, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->mTexture:Landroid/renderscript/Matrix4f;

    new-instance v2, Landroid/renderscript/Matrix4f;

    invoke-direct {v2}, Landroid/renderscript/Matrix4f;-><init>()V

    invoke-virtual {p0, v2}, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->setModelview(Landroid/renderscript/Matrix4f;)V

    new-instance v2, Landroid/renderscript/Matrix4f;

    invoke-direct {v2}, Landroid/renderscript/Matrix4f;-><init>()V

    invoke-virtual {p0, v2}, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->setProjection(Landroid/renderscript/Matrix4f;)V

    new-instance v2, Landroid/renderscript/Matrix4f;

    invoke-direct {v2}, Landroid/renderscript/Matrix4f;-><init>()V

    invoke-virtual {p0, v2}, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->setTexture(Landroid/renderscript/Matrix4f;)V

    return-void
.end method

.method private addToBuffer(ILandroid/renderscript/Matrix4f;)V
    .registers 7
    .parameter "offset"
    .parameter "m"

    .prologue
    iget-object v1, p0, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->mIOBuffer:Landroid/renderscript/FieldPacker;

    invoke-virtual {v1, p1}, Landroid/renderscript/FieldPacker;->reset(I)V

    const/4 v0, 0x0

    .local v0, i:I
    :goto_6
    const/16 v1, 0x10

    if-ge v0, v1, :cond_16

    iget-object v1, p0, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->mIOBuffer:Landroid/renderscript/FieldPacker;

    iget-object v2, p2, Landroid/renderscript/Matrix4f;->mMat:[F

    aget v2, v2, v0

    invoke-virtual {v1, v2}, Landroid/renderscript/FieldPacker;->addF32(F)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_6

    :cond_16
    iget-object v1, p0, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->mAlloc:Landroid/renderscript/Allocation;

    const/4 v2, 0x0

    iget-object v3, p0, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->mIOBuffer:Landroid/renderscript/FieldPacker;

    invoke-virtual {v1, v2, v3}, Landroid/renderscript/Allocation;->setFromFieldPacker(ILandroid/renderscript/FieldPacker;)V

    return-void
.end method


# virtual methods
.method public destroy()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->mAlloc:Landroid/renderscript/Allocation;

    invoke-virtual {v0}, Landroid/renderscript/Allocation;->destroy()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->mAlloc:Landroid/renderscript/Allocation;

    return-void
.end method

.method getAllocation()Landroid/renderscript/Allocation;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->mAlloc:Landroid/renderscript/Allocation;

    return-object v0
.end method

.method public setModelview(Landroid/renderscript/Matrix4f;)V
    .registers 3
    .parameter "m"

    .prologue
    iget-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->mModel:Landroid/renderscript/Matrix4f;

    invoke-virtual {v0, p1}, Landroid/renderscript/Matrix4f;->load(Landroid/renderscript/Matrix4f;)V

    const/4 v0, 0x0

    invoke-direct {p0, v0, p1}, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->addToBuffer(ILandroid/renderscript/Matrix4f;)V

    return-void
.end method

.method public setProjection(Landroid/renderscript/Matrix4f;)V
    .registers 3
    .parameter "m"

    .prologue
    iget-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->mProjection:Landroid/renderscript/Matrix4f;

    invoke-virtual {v0, p1}, Landroid/renderscript/Matrix4f;->load(Landroid/renderscript/Matrix4f;)V

    const/16 v0, 0x40

    invoke-direct {p0, v0, p1}, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->addToBuffer(ILandroid/renderscript/Matrix4f;)V

    return-void
.end method

.method public setTexture(Landroid/renderscript/Matrix4f;)V
    .registers 3
    .parameter "m"

    .prologue
    iget-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->mTexture:Landroid/renderscript/Matrix4f;

    invoke-virtual {v0, p1}, Landroid/renderscript/Matrix4f;->load(Landroid/renderscript/Matrix4f;)V

    const/16 v0, 0x80

    invoke-direct {p0, v0, p1}, Landroid/renderscript/ProgramVertexFixedFunction$Constants;->addToBuffer(ILandroid/renderscript/Matrix4f;)V

    return-void
.end method
