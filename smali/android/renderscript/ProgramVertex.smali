.class public Landroid/renderscript/ProgramVertex;
.super Landroid/renderscript/Program;
.source "ProgramVertex.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/renderscript/ProgramVertex$Builder;
    }
.end annotation


# direct methods
.method constructor <init>(ILandroid/renderscript/RenderScript;)V
    .registers 3
    .parameter "id"
    .parameter "rs"

    .prologue
    invoke-direct {p0, p1, p2}, Landroid/renderscript/Program;-><init>(ILandroid/renderscript/RenderScript;)V

    return-void
.end method


# virtual methods
.method public getInput(I)Landroid/renderscript/Element;
    .registers 4
    .parameter "slot"

    .prologue
    if-ltz p1, :cond_7

    iget-object v0, p0, Landroid/renderscript/Program;->mInputs:[Landroid/renderscript/Element;

    array-length v0, v0

    if-lt p1, v0, :cond_f

    :cond_7
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Slot ID out of range."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_f
    iget-object v0, p0, Landroid/renderscript/Program;->mInputs:[Landroid/renderscript/Element;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getInputCount()I
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/renderscript/Program;->mInputs:[Landroid/renderscript/Element;

    if-eqz v0, :cond_8

    iget-object v0, p0, Landroid/renderscript/Program;->mInputs:[Landroid/renderscript/Element;

    array-length v0, v0

    :goto_7
    return v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_7
.end method
