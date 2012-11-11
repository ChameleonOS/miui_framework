.class public Landroid/renderscript/BaseObj;
.super Ljava/lang/Object;
.source "BaseObj.java"


# instance fields
.field private mDestroyed:Z

.field private mID:I

.field private mName:Ljava/lang/String;

.field mRS:Landroid/renderscript/RenderScript;


# direct methods
.method constructor <init>(ILandroid/renderscript/RenderScript;)V
    .registers 4
    .parameter "id"
    .parameter "rs"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p2}, Landroid/renderscript/RenderScript;->validate()V

    iput-object p2, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iput p1, p0, Landroid/renderscript/BaseObj;->mID:I

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/renderscript/BaseObj;->mDestroyed:Z

    return-void
.end method


# virtual methods
.method checkValid()V
    .registers 3

    .prologue
    iget v0, p0, Landroid/renderscript/BaseObj;->mID:I

    if-nez v0, :cond_c

    new-instance v0, Landroid/renderscript/RSIllegalArgumentException;

    const-string v1, "Invalid object."

    invoke-direct {v0, v1}, Landroid/renderscript/RSIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_c
    return-void
.end method

.method public declared-synchronized destroy()V
    .registers 3

    .prologue
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/renderscript/BaseObj;->mDestroyed:Z

    if-eqz v0, :cond_10

    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Object already destroyed."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_d
    .catchall {:try_start_1 .. :try_end_d} :catchall_d

    :catchall_d
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_10
    const/4 v0, 0x1

    :try_start_11
    iput-boolean v0, p0, Landroid/renderscript/BaseObj;->mDestroyed:Z

    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget v1, p0, Landroid/renderscript/BaseObj;->mID:I

    invoke-virtual {v0, v1}, Landroid/renderscript/RenderScript;->nObjDestroy(I)V
    :try_end_1a
    .catchall {:try_start_11 .. :try_end_1a} :catchall_d

    monitor-exit p0

    return-void
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 7
    .parameter "obj"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    if-ne p0, p1, :cond_5

    :cond_4
    :goto_4
    return v1

    :cond_5
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_11

    move v1, v2

    goto :goto_4

    :cond_11
    move-object v0, p1

    check-cast v0, Landroid/renderscript/BaseObj;

    .local v0, b:Landroid/renderscript/BaseObj;
    iget v3, p0, Landroid/renderscript/BaseObj;->mID:I

    iget v4, v0, Landroid/renderscript/BaseObj;->mID:I

    if-eq v3, v4, :cond_4

    move v1, v2

    goto :goto_4
.end method

.method protected finalize()V
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    iget-boolean v0, p0, Landroid/renderscript/BaseObj;->mDestroyed:Z

    if-nez v0, :cond_20

    iget v0, p0, Landroid/renderscript/BaseObj;->mID:I

    if-eqz v0, :cond_17

    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {v0}, Landroid/renderscript/RenderScript;->isAlive()Z

    move-result v0

    if-eqz v0, :cond_17

    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget v1, p0, Landroid/renderscript/BaseObj;->mID:I

    invoke-virtual {v0, v1}, Landroid/renderscript/RenderScript;->nObjDestroy(I)V

    :cond_17
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    const/4 v0, 0x0

    iput v0, p0, Landroid/renderscript/BaseObj;->mID:I

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/renderscript/BaseObj;->mDestroyed:Z

    :cond_20
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    return-void
.end method

.method getID(Landroid/renderscript/RenderScript;)I
    .registers 4
    .parameter "rs"

    .prologue
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {v0}, Landroid/renderscript/RenderScript;->validate()V

    iget-boolean v0, p0, Landroid/renderscript/BaseObj;->mDestroyed:Z

    if-eqz v0, :cond_12

    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string/jumbo v1, "using a destroyed object."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_12
    iget v0, p0, Landroid/renderscript/BaseObj;->mID:I

    if-nez v0, :cond_1e

    new-instance v0, Landroid/renderscript/RSRuntimeException;

    const-string v1, "Internal error: Object id 0."

    invoke-direct {v0, v1}, Landroid/renderscript/RSRuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1e
    if-eqz p1, :cond_2d

    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    if-eq p1, v0, :cond_2d

    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string/jumbo v1, "using object with mismatched context."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2d
    iget v0, p0, Landroid/renderscript/BaseObj;->mID:I

    return v0
.end method

.method public getName()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/renderscript/BaseObj;->mID:I

    return v0
.end method

.method setID(I)V
    .registers 4
    .parameter "id"

    .prologue
    iget v0, p0, Landroid/renderscript/BaseObj;->mID:I

    if-eqz v0, :cond_c

    new-instance v0, Landroid/renderscript/RSRuntimeException;

    const-string v1, "Internal Error, reset of object ID."

    invoke-direct {v0, v1}, Landroid/renderscript/RSRuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_c
    iput p1, p0, Landroid/renderscript/BaseObj;->mID:I

    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .registers 6
    .parameter "name"

    .prologue
    if-nez p1, :cond_b

    new-instance v2, Landroid/renderscript/RSIllegalArgumentException;

    const-string/jumbo v3, "setName requires a string of non-zero length."

    invoke-direct {v2, v3}, Landroid/renderscript/RSIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    :cond_b
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    const/4 v3, 0x1

    if-ge v2, v3, :cond_1b

    new-instance v2, Landroid/renderscript/RSIllegalArgumentException;

    const-string/jumbo v3, "setName does not accept a zero length string."

    invoke-direct {v2, v3}, Landroid/renderscript/RSIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    :cond_1b
    iget-object v2, p0, Landroid/renderscript/BaseObj;->mName:Ljava/lang/String;

    if-eqz v2, :cond_28

    new-instance v2, Landroid/renderscript/RSIllegalArgumentException;

    const-string/jumbo v3, "setName object already has a name."

    invoke-direct {v2, v3}, Landroid/renderscript/RSIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    :cond_28
    :try_start_28
    const-string v2, "UTF-8"

    invoke-virtual {p1, v2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    .local v0, bytes:[B
    iget-object v2, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget v3, p0, Landroid/renderscript/BaseObj;->mID:I

    invoke-virtual {v2, v3, v0}, Landroid/renderscript/RenderScript;->nAssignName(I[B)V

    iput-object p1, p0, Landroid/renderscript/BaseObj;->mName:Ljava/lang/String;
    :try_end_37
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_28 .. :try_end_37} :catch_38

    return-void

    .end local v0           #bytes:[B
    :catch_38
    move-exception v1

    .local v1, e:Ljava/io/UnsupportedEncodingException;
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method updateFromNative()V
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {v0}, Landroid/renderscript/RenderScript;->validate()V

    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v1}, Landroid/renderscript/BaseObj;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/renderscript/RenderScript;->nGetName(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/renderscript/BaseObj;->mName:Ljava/lang/String;

    return-void
.end method
