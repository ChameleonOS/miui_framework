.class public Landroid/renderscript/RenderScriptGL;
.super Landroid/renderscript/RenderScript;
.source "RenderScriptGL.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/renderscript/RenderScriptGL$SurfaceConfig;
    }
.end annotation


# instance fields
.field mHeight:I

.field mSurfaceConfig:Landroid/renderscript/RenderScriptGL$SurfaceConfig;

.field mWidth:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/renderscript/RenderScriptGL$SurfaceConfig;)V
    .registers 20
    .parameter "ctx"
    .parameter "sc"

    .prologue
    .line 179
    invoke-direct/range {p0 .. p1}, Landroid/renderscript/RenderScript;-><init>(Landroid/content/Context;)V

    .line 180
    new-instance v1, Landroid/renderscript/RenderScriptGL$SurfaceConfig;

    move-object/from16 v0, p2

    invoke-direct {v1, v0}, Landroid/renderscript/RenderScriptGL$SurfaceConfig;-><init>(Landroid/renderscript/RenderScriptGL$SurfaceConfig;)V

    move-object/from16 v0, p0

    iput-object v1, v0, Landroid/renderscript/RenderScriptGL;->mSurfaceConfig:Landroid/renderscript/RenderScriptGL$SurfaceConfig;

    .line 182
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    iget v4, v1, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    .line 184
    .local v4, sdkVersion:I
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput v1, v0, Landroid/renderscript/RenderScriptGL;->mWidth:I

    .line 185
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput v1, v0, Landroid/renderscript/RenderScriptGL;->mHeight:I

    .line 186
    invoke-virtual/range {p0 .. p0}, Landroid/renderscript/RenderScriptGL;->nDeviceCreate()I

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Landroid/renderscript/RenderScript;->mDev:I

    .line 187
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v0, v1, Landroid/util/DisplayMetrics;->densityDpi:I

    move/from16 v16, v0

    .line 188
    .local v16, dpi:I
    move-object/from16 v0, p0

    iget v2, v0, Landroid/renderscript/RenderScript;->mDev:I

    const/4 v3, 0x0

    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/renderscript/RenderScriptGL;->mSurfaceConfig:Landroid/renderscript/RenderScriptGL$SurfaceConfig;

    iget v5, v1, Landroid/renderscript/RenderScriptGL$SurfaceConfig;->mColorMin:I

    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/renderscript/RenderScriptGL;->mSurfaceConfig:Landroid/renderscript/RenderScriptGL$SurfaceConfig;

    iget v6, v1, Landroid/renderscript/RenderScriptGL$SurfaceConfig;->mColorPref:I

    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/renderscript/RenderScriptGL;->mSurfaceConfig:Landroid/renderscript/RenderScriptGL$SurfaceConfig;

    iget v7, v1, Landroid/renderscript/RenderScriptGL$SurfaceConfig;->mAlphaMin:I

    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/renderscript/RenderScriptGL;->mSurfaceConfig:Landroid/renderscript/RenderScriptGL$SurfaceConfig;

    iget v8, v1, Landroid/renderscript/RenderScriptGL$SurfaceConfig;->mAlphaPref:I

    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/renderscript/RenderScriptGL;->mSurfaceConfig:Landroid/renderscript/RenderScriptGL$SurfaceConfig;

    iget v9, v1, Landroid/renderscript/RenderScriptGL$SurfaceConfig;->mDepthMin:I

    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/renderscript/RenderScriptGL;->mSurfaceConfig:Landroid/renderscript/RenderScriptGL$SurfaceConfig;

    iget v10, v1, Landroid/renderscript/RenderScriptGL$SurfaceConfig;->mDepthPref:I

    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/renderscript/RenderScriptGL;->mSurfaceConfig:Landroid/renderscript/RenderScriptGL$SurfaceConfig;

    iget v11, v1, Landroid/renderscript/RenderScriptGL$SurfaceConfig;->mStencilMin:I

    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/renderscript/RenderScriptGL;->mSurfaceConfig:Landroid/renderscript/RenderScriptGL$SurfaceConfig;

    iget v12, v1, Landroid/renderscript/RenderScriptGL$SurfaceConfig;->mStencilPref:I

    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/renderscript/RenderScriptGL;->mSurfaceConfig:Landroid/renderscript/RenderScriptGL$SurfaceConfig;

    iget v13, v1, Landroid/renderscript/RenderScriptGL$SurfaceConfig;->mSamplesMin:I

    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/renderscript/RenderScriptGL;->mSurfaceConfig:Landroid/renderscript/RenderScriptGL$SurfaceConfig;

    iget v14, v1, Landroid/renderscript/RenderScriptGL$SurfaceConfig;->mSamplesPref:I

    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/renderscript/RenderScriptGL;->mSurfaceConfig:Landroid/renderscript/RenderScriptGL$SurfaceConfig;

    iget v15, v1, Landroid/renderscript/RenderScriptGL$SurfaceConfig;->mSamplesQ:F

    move-object/from16 v1, p0

    invoke-virtual/range {v1 .. v16}, Landroid/renderscript/RenderScriptGL;->nContextCreateGL(IIIIIIIIIIIIIFI)I

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Landroid/renderscript/RenderScript;->mContext:I

    .line 195
    move-object/from16 v0, p0

    iget v1, v0, Landroid/renderscript/RenderScript;->mContext:I

    if-nez v1, :cond_91

    .line 196
    new-instance v1, Landroid/renderscript/RSDriverException;

    const-string v2, "Failed to create RS context."

    invoke-direct {v1, v2}, Landroid/renderscript/RSDriverException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 198
    :cond_91
    new-instance v1, Landroid/renderscript/RenderScript$MessageThread;

    move-object/from16 v0, p0

    invoke-direct {v1, v0}, Landroid/renderscript/RenderScript$MessageThread;-><init>(Landroid/renderscript/RenderScript;)V

    move-object/from16 v0, p0

    iput-object v1, v0, Landroid/renderscript/RenderScript;->mMessageThread:Landroid/renderscript/RenderScript$MessageThread;

    .line 199
    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/renderscript/RenderScript;->mMessageThread:Landroid/renderscript/RenderScript$MessageThread;

    invoke-virtual {v1}, Landroid/renderscript/RenderScript$MessageThread;->start()V

    .line 200
    return-void
.end method


# virtual methods
.method public bindProgramFragment(Landroid/renderscript/ProgramFragment;)V
    .registers 3
    .parameter "p"

    .prologue
    .line 311
    invoke-virtual {p0}, Landroid/renderscript/RenderScriptGL;->validate()V

    .line 312
    invoke-virtual {p0, p1}, Landroid/renderscript/RenderScriptGL;->safeID(Landroid/renderscript/BaseObj;)I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/renderscript/RenderScriptGL;->nContextBindProgramFragment(I)V

    .line 313
    return-void
.end method

.method public bindProgramRaster(Landroid/renderscript/ProgramRaster;)V
    .registers 3
    .parameter "p"

    .prologue
    .line 323
    invoke-virtual {p0}, Landroid/renderscript/RenderScriptGL;->validate()V

    .line 324
    invoke-virtual {p0, p1}, Landroid/renderscript/RenderScriptGL;->safeID(Landroid/renderscript/BaseObj;)I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/renderscript/RenderScriptGL;->nContextBindProgramRaster(I)V

    .line 325
    return-void
.end method

.method public bindProgramStore(Landroid/renderscript/ProgramStore;)V
    .registers 3
    .parameter "p"

    .prologue
    .line 299
    invoke-virtual {p0}, Landroid/renderscript/RenderScriptGL;->validate()V

    .line 300
    invoke-virtual {p0, p1}, Landroid/renderscript/RenderScriptGL;->safeID(Landroid/renderscript/BaseObj;)I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/renderscript/RenderScriptGL;->nContextBindProgramStore(I)V

    .line 301
    return-void
.end method

.method public bindProgramVertex(Landroid/renderscript/ProgramVertex;)V
    .registers 3
    .parameter "p"

    .prologue
    .line 335
    invoke-virtual {p0}, Landroid/renderscript/RenderScriptGL;->validate()V

    .line 336
    invoke-virtual {p0, p1}, Landroid/renderscript/RenderScriptGL;->safeID(Landroid/renderscript/BaseObj;)I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/renderscript/RenderScriptGL;->nContextBindProgramVertex(I)V

    .line 337
    return-void
.end method

.method public bindRootScript(Landroid/renderscript/Script;)V
    .registers 3
    .parameter "s"

    .prologue
    .line 287
    invoke-virtual {p0}, Landroid/renderscript/RenderScriptGL;->validate()V

    .line 288
    invoke-virtual {p0, p1}, Landroid/renderscript/RenderScriptGL;->safeID(Landroid/renderscript/BaseObj;)I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/renderscript/RenderScriptGL;->nContextBindRootScript(I)V

    .line 289
    return-void
.end method

.method public getHeight()I
    .registers 2

    .prologue
    .line 246
    iget v0, p0, Landroid/renderscript/RenderScriptGL;->mHeight:I

    return v0
.end method

.method public getWidth()I
    .registers 2

    .prologue
    .line 256
    iget v0, p0, Landroid/renderscript/RenderScriptGL;->mWidth:I

    return v0
.end method

.method public pause()V
    .registers 1

    .prologue
    .line 265
    invoke-virtual {p0}, Landroid/renderscript/RenderScriptGL;->validate()V

    .line 266
    invoke-virtual {p0}, Landroid/renderscript/RenderScriptGL;->nContextPause()V

    .line 267
    return-void
.end method

.method public resume()V
    .registers 1

    .prologue
    .line 275
    invoke-virtual {p0}, Landroid/renderscript/RenderScriptGL;->validate()V

    .line 276
    invoke-virtual {p0}, Landroid/renderscript/RenderScriptGL;->nContextResume()V

    .line 277
    return-void
.end method

.method public setSurface(Landroid/view/SurfaceHolder;II)V
    .registers 5
    .parameter "sur"
    .parameter "w"
    .parameter "h"

    .prologue
    .line 212
    invoke-virtual {p0}, Landroid/renderscript/RenderScriptGL;->validate()V

    .line 213
    const/4 v0, 0x0

    .line 214
    .local v0, s:Landroid/view/Surface;
    if-eqz p1, :cond_a

    .line 215
    invoke-interface {p1}, Landroid/view/SurfaceHolder;->getSurface()Landroid/view/Surface;

    move-result-object v0

    .line 217
    :cond_a
    iput p2, p0, Landroid/renderscript/RenderScriptGL;->mWidth:I

    .line 218
    iput p3, p0, Landroid/renderscript/RenderScriptGL;->mHeight:I

    .line 219
    invoke-virtual {p0, p2, p3, v0}, Landroid/renderscript/RenderScriptGL;->nContextSetSurface(IILandroid/view/Surface;)V

    .line 220
    return-void
.end method

.method public setSurfaceTexture(Landroid/graphics/SurfaceTexture;II)V
    .registers 4
    .parameter "sur"
    .parameter "w"
    .parameter "h"

    .prologue
    .line 231
    invoke-virtual {p0}, Landroid/renderscript/RenderScriptGL;->validate()V

    .line 234
    iput p2, p0, Landroid/renderscript/RenderScriptGL;->mWidth:I

    .line 235
    iput p3, p0, Landroid/renderscript/RenderScriptGL;->mHeight:I

    .line 236
    invoke-virtual {p0, p2, p3, p1}, Landroid/renderscript/RenderScriptGL;->nContextSetSurfaceTexture(IILandroid/graphics/SurfaceTexture;)V

    .line 237
    return-void
.end method
