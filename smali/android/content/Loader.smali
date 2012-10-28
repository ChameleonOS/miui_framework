.class public Landroid/content/Loader;
.super Ljava/lang/Object;
.source "Loader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/content/Loader$OnLoadCanceledListener;,
        Landroid/content/Loader$OnLoadCompleteListener;,
        Landroid/content/Loader$ForceLoadContentObserver;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<D:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field mAbandoned:Z

.field mContentChanged:Z

.field mContext:Landroid/content/Context;

.field mId:I

.field mListener:Landroid/content/Loader$OnLoadCompleteListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/content/Loader$OnLoadCompleteListener",
            "<TD;>;"
        }
    .end annotation
.end field

.field mOnLoadCanceledListener:Landroid/content/Loader$OnLoadCanceledListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/content/Loader$OnLoadCanceledListener",
            "<TD;>;"
        }
    .end annotation
.end field

.field mReset:Z

.field mStarted:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 4
    .parameter "context"

    .prologue
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    const/4 v1, 0x0

    .line 130
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 57
    iput-boolean v1, p0, Landroid/content/Loader;->mStarted:Z

    .line 58
    iput-boolean v1, p0, Landroid/content/Loader;->mAbandoned:Z

    .line 59
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/content/Loader;->mReset:Z

    .line 60
    iput-boolean v1, p0, Landroid/content/Loader;->mContentChanged:Z

    .line 131
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Landroid/content/Loader;->mContext:Landroid/content/Context;

    .line 132
    return-void
.end method


# virtual methods
.method public abandon()V
    .registers 2

    .prologue
    .line 402
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/content/Loader;->mAbandoned:Z

    .line 403
    invoke-virtual {p0}, Landroid/content/Loader;->onAbandon()V

    .line 404
    return-void
.end method

.method public cancelLoad()Z
    .registers 2

    .prologue
    .line 319
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    invoke-virtual {p0}, Landroid/content/Loader;->onCancelLoad()Z

    move-result v0

    return v0
.end method

.method public dataToString(Ljava/lang/Object;)Ljava/lang/String;
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 488
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    .local p1, data:Ljava/lang/Object;,"TD;"
    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x40

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 489
    .local v0, sb:Ljava/lang/StringBuilder;
    invoke-static {p1, v0}, Landroid/util/DebugUtils;->buildShortClassTag(Ljava/lang/Object;Ljava/lang/StringBuilder;)V

    .line 490
    const-string/jumbo v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 491
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public deliverCancellation()V
    .registers 2

    .prologue
    .line 154
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    iget-object v0, p0, Landroid/content/Loader;->mOnLoadCanceledListener:Landroid/content/Loader$OnLoadCanceledListener;

    if-eqz v0, :cond_9

    .line 155
    iget-object v0, p0, Landroid/content/Loader;->mOnLoadCanceledListener:Landroid/content/Loader$OnLoadCanceledListener;

    invoke-interface {v0, p0}, Landroid/content/Loader$OnLoadCanceledListener;->onLoadCanceled(Landroid/content/Loader;)V

    .line 157
    :cond_9
    return-void
.end method

.method public deliverResult(Ljava/lang/Object;)V
    .registers 3
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .prologue
    .line 142
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    .local p1, data:Ljava/lang/Object;,"TD;"
    iget-object v0, p0, Landroid/content/Loader;->mListener:Landroid/content/Loader$OnLoadCompleteListener;

    if-eqz v0, :cond_9

    .line 143
    iget-object v0, p0, Landroid/content/Loader;->mListener:Landroid/content/Loader$OnLoadCompleteListener;

    invoke-interface {v0, p0, p1}, Landroid/content/Loader$OnLoadCompleteListener;->onLoadComplete(Landroid/content/Loader;Ljava/lang/Object;)V

    .line 145
    :cond_9
    return-void
.end method

.method public dump(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .registers 6
    .parameter "prefix"
    .parameter "fd"
    .parameter "writer"
    .parameter "args"

    .prologue
    .line 513
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mId="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/content/Loader;->mId:I

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(I)V

    .line 514
    const-string v0, " mListener="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/content/Loader;->mListener:Landroid/content/Loader$OnLoadCompleteListener;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 515
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string/jumbo v0, "mStarted="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/content/Loader;->mStarted:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Z)V

    .line 516
    const-string v0, " mContentChanged="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/content/Loader;->mContentChanged:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Z)V

    .line 517
    const-string v0, " mAbandoned="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/content/Loader;->mAbandoned:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Z)V

    .line 518
    const-string v0, " mReset="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/content/Loader;->mReset:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Z)V

    .line 519
    return-void
.end method

.method public forceLoad()V
    .registers 1

    .prologue
    .line 346
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    invoke-virtual {p0}, Landroid/content/Loader;->onForceLoad()V

    .line 347
    return-void
.end method

.method public getContext()Landroid/content/Context;
    .registers 2

    .prologue
    .line 163
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    iget-object v0, p0, Landroid/content/Loader;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public getId()I
    .registers 2

    .prologue
    .line 170
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    iget v0, p0, Landroid/content/Loader;->mId:I

    return v0
.end method

.method public isAbandoned()Z
    .registers 2

    .prologue
    .line 252
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    iget-boolean v0, p0, Landroid/content/Loader;->mAbandoned:Z

    return v0
.end method

.method public isReset()Z
    .registers 2

    .prologue
    .line 261
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    iget-boolean v0, p0, Landroid/content/Loader;->mReset:Z

    return v0
.end method

.method public isStarted()Z
    .registers 2

    .prologue
    .line 243
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    iget-boolean v0, p0, Landroid/content/Loader;->mStarted:Z

    return v0
.end method

.method protected onAbandon()V
    .registers 1

    .prologue
    .line 416
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    return-void
.end method

.method protected onCancelLoad()Z
    .registers 2

    .prologue
    .line 334
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    const/4 v0, 0x0

    return v0
.end method

.method public onContentChanged()V
    .registers 2

    .prologue
    .line 473
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    iget-boolean v0, p0, Landroid/content/Loader;->mStarted:Z

    if-eqz v0, :cond_8

    .line 474
    invoke-virtual {p0}, Landroid/content/Loader;->forceLoad()V

    .line 481
    :goto_7
    return-void

    .line 479
    :cond_8
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/content/Loader;->mContentChanged:Z

    goto :goto_7
.end method

.method protected onForceLoad()V
    .registers 1

    .prologue
    .line 354
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    return-void
.end method

.method protected onReset()V
    .registers 1

    .prologue
    .line 451
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    return-void
.end method

.method protected onStartLoading()V
    .registers 1

    .prologue
    .line 298
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    return-void
.end method

.method protected onStopLoading()V
    .registers 1

    .prologue
    .line 388
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    return-void
.end method

.method public registerListener(ILandroid/content/Loader$OnLoadCompleteListener;)V
    .registers 5
    .parameter "id"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/content/Loader$OnLoadCompleteListener",
            "<TD;>;)V"
        }
    .end annotation

    .prologue
    .line 181
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    .local p2, listener:Landroid/content/Loader$OnLoadCompleteListener;,"Landroid/content/Loader$OnLoadCompleteListener<TD;>;"
    iget-object v0, p0, Landroid/content/Loader;->mListener:Landroid/content/Loader$OnLoadCompleteListener;

    if-eqz v0, :cond_c

    .line 182
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "There is already a listener registered"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 184
    :cond_c
    iput-object p2, p0, Landroid/content/Loader;->mListener:Landroid/content/Loader$OnLoadCompleteListener;

    .line 185
    iput p1, p0, Landroid/content/Loader;->mId:I

    .line 186
    return-void
.end method

.method public registerOnLoadCanceledListener(Landroid/content/Loader$OnLoadCanceledListener;)V
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader$OnLoadCanceledListener",
            "<TD;>;)V"
        }
    .end annotation

    .prologue
    .line 213
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    .local p1, listener:Landroid/content/Loader$OnLoadCanceledListener;,"Landroid/content/Loader$OnLoadCanceledListener<TD;>;"
    iget-object v0, p0, Landroid/content/Loader;->mOnLoadCanceledListener:Landroid/content/Loader$OnLoadCanceledListener;

    if-eqz v0, :cond_c

    .line 214
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "There is already a listener registered"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 216
    :cond_c
    iput-object p1, p0, Landroid/content/Loader;->mOnLoadCanceledListener:Landroid/content/Loader$OnLoadCanceledListener;

    .line 217
    return-void
.end method

.method public reset()V
    .registers 3

    .prologue
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    const/4 v1, 0x0

    .line 437
    invoke-virtual {p0}, Landroid/content/Loader;->onReset()V

    .line 438
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/content/Loader;->mReset:Z

    .line 439
    iput-boolean v1, p0, Landroid/content/Loader;->mStarted:Z

    .line 440
    iput-boolean v1, p0, Landroid/content/Loader;->mAbandoned:Z

    .line 441
    iput-boolean v1, p0, Landroid/content/Loader;->mContentChanged:Z

    .line 442
    return-void
.end method

.method public final startLoading()V
    .registers 3

    .prologue
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    const/4 v1, 0x0

    .line 286
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/content/Loader;->mStarted:Z

    .line 287
    iput-boolean v1, p0, Landroid/content/Loader;->mReset:Z

    .line 288
    iput-boolean v1, p0, Landroid/content/Loader;->mAbandoned:Z

    .line 289
    invoke-virtual {p0}, Landroid/content/Loader;->onStartLoading()V

    .line 290
    return-void
.end method

.method public stopLoading()V
    .registers 2

    .prologue
    .line 377
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/content/Loader;->mStarted:Z

    .line 378
    invoke-virtual {p0}, Landroid/content/Loader;->onStopLoading()V

    .line 379
    return-void
.end method

.method public takeContentChanged()Z
    .registers 3

    .prologue
    .line 459
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    iget-boolean v0, p0, Landroid/content/Loader;->mContentChanged:Z

    .line 460
    .local v0, res:Z
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/content/Loader;->mContentChanged:Z

    .line 461
    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    .line 496
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x40

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 497
    .local v0, sb:Ljava/lang/StringBuilder;
    invoke-static {p0, v0}, Landroid/util/DebugUtils;->buildShortClassTag(Ljava/lang/Object;Ljava/lang/StringBuilder;)V

    .line 498
    const-string v1, " id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 499
    iget v1, p0, Landroid/content/Loader;->mId:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 500
    const-string/jumbo v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 501
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public unregisterListener(Landroid/content/Loader$OnLoadCompleteListener;)V
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader$OnLoadCompleteListener",
            "<TD;>;)V"
        }
    .end annotation

    .prologue
    .line 194
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    .local p1, listener:Landroid/content/Loader$OnLoadCompleteListener;,"Landroid/content/Loader$OnLoadCompleteListener<TD;>;"
    iget-object v0, p0, Landroid/content/Loader;->mListener:Landroid/content/Loader$OnLoadCompleteListener;

    if-nez v0, :cond_c

    .line 195
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "No listener register"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 197
    :cond_c
    iget-object v0, p0, Landroid/content/Loader;->mListener:Landroid/content/Loader$OnLoadCompleteListener;

    if-eq v0, p1, :cond_18

    .line 198
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Attempting to unregister the wrong listener"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 200
    :cond_18
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/content/Loader;->mListener:Landroid/content/Loader$OnLoadCompleteListener;

    .line 201
    return-void
.end method

.method public unregisterOnLoadCanceledListener(Landroid/content/Loader$OnLoadCanceledListener;)V
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader$OnLoadCanceledListener",
            "<TD;>;)V"
        }
    .end annotation

    .prologue
    .line 228
    .local p0, this:Landroid/content/Loader;,"Landroid/content/Loader<TD;>;"
    .local p1, listener:Landroid/content/Loader$OnLoadCanceledListener;,"Landroid/content/Loader$OnLoadCanceledListener<TD;>;"
    iget-object v0, p0, Landroid/content/Loader;->mOnLoadCanceledListener:Landroid/content/Loader$OnLoadCanceledListener;

    if-nez v0, :cond_c

    .line 229
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "No listener register"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 231
    :cond_c
    iget-object v0, p0, Landroid/content/Loader;->mOnLoadCanceledListener:Landroid/content/Loader$OnLoadCanceledListener;

    if-eq v0, p1, :cond_18

    .line 232
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Attempting to unregister the wrong listener"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 234
    :cond_18
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/content/Loader;->mOnLoadCanceledListener:Landroid/content/Loader$OnLoadCanceledListener;

    .line 235
    return-void
.end method
