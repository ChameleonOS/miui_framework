.class public Landroid/renderscript/Script;
.super Landroid/renderscript/BaseObj;
.source "Script.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/renderscript/Script$FieldBase;,
        Landroid/renderscript/Script$Builder;
    }
.end annotation


# direct methods
.method constructor <init>(ILandroid/renderscript/RenderScript;)V
    .registers 3
    .parameter "id"
    .parameter "rs"

    .prologue
    .line 76
    invoke-direct {p0, p1, p2}, Landroid/renderscript/BaseObj;-><init>(ILandroid/renderscript/RenderScript;)V

    .line 77
    return-void
.end method


# virtual methods
.method public bindAllocation(Landroid/renderscript/Allocation;I)V
    .registers 6
    .parameter "va"
    .parameter "slot"

    .prologue
    .line 87
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {v0}, Landroid/renderscript/RenderScript;->validate()V

    .line 88
    if-eqz p1, :cond_19

    .line 89
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v1}, Landroid/renderscript/Script;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    iget-object v2, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p1, v2}, Landroid/renderscript/Allocation;->getID(Landroid/renderscript/RenderScript;)I

    move-result v2

    invoke-virtual {v0, v1, v2, p2}, Landroid/renderscript/RenderScript;->nScriptBindAllocation(III)V

    .line 93
    :goto_18
    return-void

    .line 91
    :cond_19
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v1}, Landroid/renderscript/Script;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, p2}, Landroid/renderscript/RenderScript;->nScriptBindAllocation(III)V

    goto :goto_18
.end method

.method protected forEach(ILandroid/renderscript/Allocation;Landroid/renderscript/Allocation;Landroid/renderscript/FieldPacker;)V
    .registers 11
    .parameter "slot"
    .parameter "ain"
    .parameter "aout"
    .parameter "v"

    .prologue
    .line 55
    if-nez p2, :cond_c

    if-nez p3, :cond_c

    .line 56
    new-instance v0, Landroid/renderscript/RSIllegalArgumentException;

    const-string v1, "At least one of ain or aout is required to be non-null."

    invoke-direct {v0, v1}, Landroid/renderscript/RSIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 59
    :cond_c
    const/4 v3, 0x0

    .line 60
    .local v3, in_id:I
    if-eqz p2, :cond_15

    .line 61
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p2, v0}, Landroid/renderscript/Allocation;->getID(Landroid/renderscript/RenderScript;)I

    move-result v3

    .line 63
    :cond_15
    const/4 v4, 0x0

    .line 64
    .local v4, out_id:I
    if-eqz p3, :cond_1e

    .line 65
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p3, v0}, Landroid/renderscript/Allocation;->getID(Landroid/renderscript/RenderScript;)I

    move-result v4

    .line 67
    :cond_1e
    const/4 v5, 0x0

    .line 68
    .local v5, params:[B
    if-eqz p4, :cond_25

    .line 69
    invoke-virtual {p4}, Landroid/renderscript/FieldPacker;->getData()[B

    move-result-object v5

    .line 71
    :cond_25
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v1}, Landroid/renderscript/Script;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    move v2, p1

    invoke-virtual/range {v0 .. v5}, Landroid/renderscript/RenderScript;->nScriptForEach(IIII[B)V

    .line 72
    return-void
.end method

.method protected invoke(I)V
    .registers 4
    .parameter "slot"

    .prologue
    .line 29
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v1}, Landroid/renderscript/Script;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    invoke-virtual {v0, v1, p1}, Landroid/renderscript/RenderScript;->nScriptInvoke(II)V

    .line 30
    return-void
.end method

.method protected invoke(ILandroid/renderscript/FieldPacker;)V
    .registers 6
    .parameter "slot"
    .parameter "v"

    .prologue
    .line 39
    if-eqz p2, :cond_12

    .line 40
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v1}, Landroid/renderscript/Script;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    invoke-virtual {p2}, Landroid/renderscript/FieldPacker;->getData()[B

    move-result-object v2

    invoke-virtual {v0, v1, p1, v2}, Landroid/renderscript/RenderScript;->nScriptInvokeV(II[B)V

    .line 44
    :goto_11
    return-void

    .line 42
    :cond_12
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v1}, Landroid/renderscript/Script;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    invoke-virtual {v0, v1, p1}, Landroid/renderscript/RenderScript;->nScriptInvoke(II)V

    goto :goto_11
.end method

.method public setTimeZone(Ljava/lang/String;)V
    .registers 6
    .parameter "timeZone"

    .prologue
    .line 178
    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {v1}, Landroid/renderscript/RenderScript;->validate()V

    .line 180
    :try_start_5
    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v2, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v2}, Landroid/renderscript/Script;->getID(Landroid/renderscript/RenderScript;)I

    move-result v2

    const-string v3, "UTF-8"

    invoke-virtual {p1, v3}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/renderscript/RenderScript;->nScriptSetTimeZone(I[B)V
    :try_end_16
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_5 .. :try_end_16} :catch_17

    .line 184
    return-void

    .line 181
    :catch_17
    move-exception v0

    .line 182
    .local v0, e:Ljava/io/UnsupportedEncodingException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public setVar(ID)V
    .registers 6
    .parameter "index"
    .parameter "v"

    .prologue
    .line 112
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v1}, Landroid/renderscript/Script;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    invoke-virtual {v0, v1, p1, p2, p3}, Landroid/renderscript/RenderScript;->nScriptSetVarD(IID)V

    .line 113
    return-void
.end method

.method public setVar(IF)V
    .registers 5
    .parameter "index"
    .parameter "v"

    .prologue
    .line 102
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v1}, Landroid/renderscript/Script;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    invoke-virtual {v0, v1, p1, p2}, Landroid/renderscript/RenderScript;->nScriptSetVarF(IIF)V

    .line 103
    return-void
.end method

.method public setVar(II)V
    .registers 5
    .parameter "index"
    .parameter "v"

    .prologue
    .line 122
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v1}, Landroid/renderscript/Script;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    invoke-virtual {v0, v1, p1, p2}, Landroid/renderscript/RenderScript;->nScriptSetVarI(III)V

    .line 123
    return-void
.end method

.method public setVar(IJ)V
    .registers 6
    .parameter "index"
    .parameter "v"

    .prologue
    .line 132
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v1}, Landroid/renderscript/Script;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    invoke-virtual {v0, v1, p1, p2, p3}, Landroid/renderscript/RenderScript;->nScriptSetVarJ(IIJ)V

    .line 133
    return-void
.end method

.method public setVar(ILandroid/renderscript/BaseObj;)V
    .registers 6
    .parameter "index"
    .parameter "o"

    .prologue
    .line 152
    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v0}, Landroid/renderscript/Script;->getID(Landroid/renderscript/RenderScript;)I

    move-result v2

    if-nez p2, :cond_f

    const/4 v0, 0x0

    :goto_b
    invoke-virtual {v1, v2, p1, v0}, Landroid/renderscript/RenderScript;->nScriptSetVarObj(III)V

    .line 153
    return-void

    .line 152
    :cond_f
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p2, v0}, Landroid/renderscript/BaseObj;->getID(Landroid/renderscript/RenderScript;)I

    move-result v0

    goto :goto_b
.end method

.method public setVar(ILandroid/renderscript/FieldPacker;)V
    .registers 6
    .parameter "index"
    .parameter "v"

    .prologue
    .line 162
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v1}, Landroid/renderscript/Script;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    invoke-virtual {p2}, Landroid/renderscript/FieldPacker;->getData()[B

    move-result-object v2

    invoke-virtual {v0, v1, p1, v2}, Landroid/renderscript/RenderScript;->nScriptSetVarV(II[B)V

    .line 163
    return-void
.end method

.method public setVar(ILandroid/renderscript/FieldPacker;Landroid/renderscript/Element;[I)V
    .registers 11
    .parameter "index"
    .parameter "v"
    .parameter "e"
    .parameter "dims"

    .prologue
    .line 174
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v1}, Landroid/renderscript/Script;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    invoke-virtual {p2}, Landroid/renderscript/FieldPacker;->getData()[B

    move-result-object v3

    iget-object v2, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p3, v2}, Landroid/renderscript/Element;->getID(Landroid/renderscript/RenderScript;)I

    move-result v4

    move v2, p1

    move-object v5, p4

    invoke-virtual/range {v0 .. v5}, Landroid/renderscript/RenderScript;->nScriptSetVarVE(II[BI[I)V

    .line 175
    return-void
.end method

.method public setVar(IZ)V
    .registers 6
    .parameter "index"
    .parameter "v"

    .prologue
    .line 142
    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v0}, Landroid/renderscript/Script;->getID(Landroid/renderscript/RenderScript;)I

    move-result v2

    if-eqz p2, :cond_f

    const/4 v0, 0x1

    :goto_b
    invoke-virtual {v1, v2, p1, v0}, Landroid/renderscript/RenderScript;->nScriptSetVarI(III)V

    .line 143
    return-void

    .line 142
    :cond_f
    const/4 v0, 0x0

    goto :goto_b
.end method
