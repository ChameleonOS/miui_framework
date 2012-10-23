.class public abstract Landroid/animation/Animator;
.super Ljava/lang/Object;
.source "Animator.java"

# interfaces
.implements Ljava/lang/Cloneable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/animation/Animator$AnimatorListener;
    }
.end annotation


# instance fields
.field mListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/animation/Animator$AnimatorListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 25
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 31
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    .line 245
    return-void
.end method


# virtual methods
.method public addListener(Landroid/animation/Animator$AnimatorListener;)V
    .registers 3
    .parameter "listener"

    .prologue
    .line 143
    iget-object v0, p0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    if-nez v0, :cond_b

    .line 144
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    .line 146
    :cond_b
    iget-object v0, p0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 147
    return-void
.end method

.method public cancel()V
    .registers 1

    .prologue
    .line 59
    return-void
.end method

.method public clone()Landroid/animation/Animator;
    .registers 8

    .prologue
    .line 190
    :try_start_0
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/Animator;

    .line 191
    .local v0, anim:Landroid/animation/Animator;
    iget-object v5, p0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    if-eqz v5, :cond_2d

    .line 192
    iget-object v4, p0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    .line 193
    .local v4, oldListeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/Animator$AnimatorListener;>;"
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iput-object v5, v0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    .line 194
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 195
    .local v3, numListeners:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_18
    if-ge v2, v3, :cond_2d

    .line 196
    iget-object v5, v0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_23
    .catch Ljava/lang/CloneNotSupportedException; {:try_start_0 .. :try_end_23} :catch_26

    .line 195
    add-int/lit8 v2, v2, 0x1

    goto :goto_18

    .line 200
    .end local v0           #anim:Landroid/animation/Animator;
    .end local v2           #i:I
    .end local v3           #numListeners:I
    .end local v4           #oldListeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/Animator$AnimatorListener;>;"
    :catch_26
    move-exception v1

    .line 201
    .local v1, e:Ljava/lang/CloneNotSupportedException;
    new-instance v5, Ljava/lang/AssertionError;

    invoke-direct {v5}, Ljava/lang/AssertionError;-><init>()V

    throw v5

    .line 199
    .end local v1           #e:Ljava/lang/CloneNotSupportedException;
    .restart local v0       #anim:Landroid/animation/Animator;
    :cond_2d
    return-object v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 25
    invoke-virtual {p0}, Landroid/animation/Animator;->clone()Landroid/animation/Animator;

    move-result-object v0

    return-object v0
.end method

.method public end()V
    .registers 1

    .prologue
    .line 70
    return-void
.end method

.method public abstract getDuration()J
.end method

.method public getListeners()Ljava/util/ArrayList;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/animation/Animator$AnimatorListener;",
            ">;"
        }
    .end annotation

    .prologue
    .line 172
    iget-object v0, p0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    return-object v0
.end method

.method public abstract getStartDelay()J
.end method

.method public abstract isRunning()Z
.end method

.method public isStarted()Z
    .registers 2

    .prologue
    .line 133
    invoke-virtual {p0}, Landroid/animation/Animator;->isRunning()Z

    move-result v0

    return v0
.end method

.method public removeAllListeners()V
    .registers 2

    .prologue
    .line 181
    iget-object v0, p0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    if-eqz v0, :cond_c

    .line 182
    iget-object v0, p0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 183
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    .line 185
    :cond_c
    return-void
.end method

.method public removeListener(Landroid/animation/Animator$AnimatorListener;)V
    .registers 3
    .parameter "listener"

    .prologue
    .line 156
    iget-object v0, p0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    if-nez v0, :cond_5

    .line 163
    :cond_4
    :goto_4
    return-void

    .line 159
    :cond_5
    iget-object v0, p0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 160
    iget-object v0, p0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_4

    .line 161
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/animation/Animator;->mListeners:Ljava/util/ArrayList;

    goto :goto_4
.end method

.method public abstract setDuration(J)Landroid/animation/Animator;
.end method

.method public abstract setInterpolator(Landroid/animation/TimeInterpolator;)V
.end method

.method public abstract setStartDelay(J)V
.end method

.method public setTarget(Ljava/lang/Object;)V
    .registers 2
    .parameter "target"

    .prologue
    .line 238
    return-void
.end method

.method public setupEndValues()V
    .registers 1

    .prologue
    .line 227
    return-void
.end method

.method public setupStartValues()V
    .registers 1

    .prologue
    .line 215
    return-void
.end method

.method public start()V
    .registers 1

    .prologue
    .line 47
    return-void
.end method
