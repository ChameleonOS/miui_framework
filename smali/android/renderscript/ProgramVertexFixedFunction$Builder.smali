.class public Landroid/renderscript/ProgramVertexFixedFunction$Builder;
.super Ljava/lang/Object;
.source "ProgramVertexFixedFunction.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/renderscript/ProgramVertexFixedFunction;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field mRS:Landroid/renderscript/RenderScript;

.field mShader:Ljava/lang/String;

.field mTextureMatrixEnable:Z


# direct methods
.method public constructor <init>(Landroid/renderscript/RenderScript;)V
    .registers 2
    .parameter "rs"

    .prologue
    .line 124
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 125
    iput-object p1, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mRS:Landroid/renderscript/RenderScript;

    .line 126
    return-void
.end method

.method private buildShaderString()V
    .registers 3

    .prologue
    .line 152
    const-string v0, "//rs_shader_internal\n"

    iput-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    .line 153
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "varying vec4 varColor;\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    .line 154
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "varying vec2 varTex0;\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    .line 156
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "void main() {\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    .line 157
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "  gl_Position = UNI_MVP * ATTRIB_position;\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    .line 158
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "  gl_PointSize = 1.0;\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    .line 160
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "  varColor = ATTRIB_color;\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    .line 161
    iget-boolean v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mTextureMatrixEnable:Z

    if-eqz v0, :cond_c5

    .line 162
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "  varTex0 = (UNI_TexMatrix * vec4(ATTRIB_texture0, 0.0, 1.0)).xy;\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    .line 166
    :goto_ac
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "}\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    .line 167
    return-void

    .line 164
    :cond_c5
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "  varTex0 = ATTRIB_texture0;\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    goto :goto_ac
.end method

.method static getConstantInputType(Landroid/renderscript/RenderScript;)Landroid/renderscript/Type;
    .registers 5
    .parameter "rs"

    .prologue
    .line 139
    new-instance v0, Landroid/renderscript/Element$Builder;

    invoke-direct {v0, p0}, Landroid/renderscript/Element$Builder;-><init>(Landroid/renderscript/RenderScript;)V

    .line 140
    .local v0, b:Landroid/renderscript/Element$Builder;
    invoke-static {p0}, Landroid/renderscript/Element;->MATRIX4X4(Landroid/renderscript/RenderScript;)Landroid/renderscript/Element;

    move-result-object v2

    const-string v3, "MV"

    invoke-virtual {v0, v2, v3}, Landroid/renderscript/Element$Builder;->add(Landroid/renderscript/Element;Ljava/lang/String;)Landroid/renderscript/Element$Builder;

    .line 141
    invoke-static {p0}, Landroid/renderscript/Element;->MATRIX4X4(Landroid/renderscript/RenderScript;)Landroid/renderscript/Element;

    move-result-object v2

    const-string v3, "P"

    invoke-virtual {v0, v2, v3}, Landroid/renderscript/Element$Builder;->add(Landroid/renderscript/Element;Ljava/lang/String;)Landroid/renderscript/Element$Builder;

    .line 142
    invoke-static {p0}, Landroid/renderscript/Element;->MATRIX4X4(Landroid/renderscript/RenderScript;)Landroid/renderscript/Element;

    move-result-object v2

    const-string v3, "TexMatrix"

    invoke-virtual {v0, v2, v3}, Landroid/renderscript/Element$Builder;->add(Landroid/renderscript/Element;Ljava/lang/String;)Landroid/renderscript/Element$Builder;

    .line 143
    invoke-static {p0}, Landroid/renderscript/Element;->MATRIX4X4(Landroid/renderscript/RenderScript;)Landroid/renderscript/Element;

    move-result-object v2

    const-string v3, "MVP"

    invoke-virtual {v0, v2, v3}, Landroid/renderscript/Element$Builder;->add(Landroid/renderscript/Element;Ljava/lang/String;)Landroid/renderscript/Element$Builder;

    .line 145
    new-instance v1, Landroid/renderscript/Type$Builder;

    invoke-virtual {v0}, Landroid/renderscript/Element$Builder;->create()Landroid/renderscript/Element;

    move-result-object v2

    invoke-direct {v1, p0, v2}, Landroid/renderscript/Type$Builder;-><init>(Landroid/renderscript/RenderScript;Landroid/renderscript/Element;)V

    .line 146
    .local v1, typeBuilder:Landroid/renderscript/Type$Builder;
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/renderscript/Type$Builder;->setX(I)Landroid/renderscript/Type$Builder;

    .line 147
    invoke-virtual {v1}, Landroid/renderscript/Type$Builder;->create()Landroid/renderscript/Type;

    move-result-object v2

    return-object v2
.end method


# virtual methods
.method public create()Landroid/renderscript/ProgramVertexFixedFunction;
    .registers 5

    .prologue
    .line 177
    invoke-direct {p0}, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->buildShaderString()V

    .line 179
    new-instance v1, Landroid/renderscript/ProgramVertexFixedFunction$InternalBuilder;

    iget-object v2, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mRS:Landroid/renderscript/RenderScript;

    invoke-direct {v1, v2}, Landroid/renderscript/ProgramVertexFixedFunction$InternalBuilder;-><init>(Landroid/renderscript/RenderScript;)V

    .line 180
    .local v1, sb:Landroid/renderscript/ProgramVertexFixedFunction$InternalBuilder;
    iget-object v2, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mShader:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/renderscript/ProgramVertexFixedFunction$InternalBuilder;->setShader(Ljava/lang/String;)Landroid/renderscript/Program$BaseProgramBuilder;

    .line 181
    iget-object v2, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mRS:Landroid/renderscript/RenderScript;

    invoke-static {v2}, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->getConstantInputType(Landroid/renderscript/RenderScript;)Landroid/renderscript/Type;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/renderscript/ProgramVertexFixedFunction$InternalBuilder;->addConstant(Landroid/renderscript/Type;)Landroid/renderscript/Program$BaseProgramBuilder;

    .line 183
    new-instance v0, Landroid/renderscript/Element$Builder;

    iget-object v2, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mRS:Landroid/renderscript/RenderScript;

    invoke-direct {v0, v2}, Landroid/renderscript/Element$Builder;-><init>(Landroid/renderscript/RenderScript;)V

    .line 184
    .local v0, b:Landroid/renderscript/Element$Builder;
    iget-object v2, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mRS:Landroid/renderscript/RenderScript;

    invoke-static {v2}, Landroid/renderscript/Element;->F32_4(Landroid/renderscript/RenderScript;)Landroid/renderscript/Element;

    move-result-object v2

    const-string/jumbo v3, "position"

    invoke-virtual {v0, v2, v3}, Landroid/renderscript/Element$Builder;->add(Landroid/renderscript/Element;Ljava/lang/String;)Landroid/renderscript/Element$Builder;

    .line 185
    iget-object v2, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mRS:Landroid/renderscript/RenderScript;

    invoke-static {v2}, Landroid/renderscript/Element;->F32_4(Landroid/renderscript/RenderScript;)Landroid/renderscript/Element;

    move-result-object v2

    const-string v3, "color"

    invoke-virtual {v0, v2, v3}, Landroid/renderscript/Element$Builder;->add(Landroid/renderscript/Element;Ljava/lang/String;)Landroid/renderscript/Element$Builder;

    .line 186
    iget-object v2, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mRS:Landroid/renderscript/RenderScript;

    invoke-static {v2}, Landroid/renderscript/Element;->F32_3(Landroid/renderscript/RenderScript;)Landroid/renderscript/Element;

    move-result-object v2

    const-string/jumbo v3, "normal"

    invoke-virtual {v0, v2, v3}, Landroid/renderscript/Element$Builder;->add(Landroid/renderscript/Element;Ljava/lang/String;)Landroid/renderscript/Element$Builder;

    .line 187
    iget-object v2, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mRS:Landroid/renderscript/RenderScript;

    invoke-static {v2}, Landroid/renderscript/Element;->F32_2(Landroid/renderscript/RenderScript;)Landroid/renderscript/Element;

    move-result-object v2

    const-string/jumbo v3, "texture0"

    invoke-virtual {v0, v2, v3}, Landroid/renderscript/Element$Builder;->add(Landroid/renderscript/Element;Ljava/lang/String;)Landroid/renderscript/Element$Builder;

    .line 188
    invoke-virtual {v0}, Landroid/renderscript/Element$Builder;->create()Landroid/renderscript/Element;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/renderscript/ProgramVertexFixedFunction$InternalBuilder;->addInput(Landroid/renderscript/Element;)Landroid/renderscript/ProgramVertexFixedFunction$InternalBuilder;

    .line 190
    invoke-virtual {v1}, Landroid/renderscript/ProgramVertexFixedFunction$InternalBuilder;->create()Landroid/renderscript/ProgramVertexFixedFunction;

    move-result-object v2

    return-object v2
.end method

.method public setTextureMatrixEnable(Z)Landroid/renderscript/ProgramVertexFixedFunction$Builder;
    .registers 2
    .parameter "enable"

    .prologue
    .line 135
    iput-boolean p1, p0, Landroid/renderscript/ProgramVertexFixedFunction$Builder;->mTextureMatrixEnable:Z

    .line 136
    return-object p0
.end method
