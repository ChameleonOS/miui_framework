.class public Landroid/app/ListFragment;
.super Landroid/app/Fragment;
.source "ListFragment.java"


# instance fields
.field mAdapter:Landroid/widget/ListAdapter;

.field mEmptyText:Ljava/lang/CharSequence;

.field mEmptyView:Landroid/view/View;

.field private final mHandler:Landroid/os/Handler;

.field mList:Landroid/widget/ListView;

.field mListContainer:Landroid/view/View;

.field mListShown:Z

.field private final mOnClickListener:Landroid/widget/AdapterView$OnItemClickListener;

.field mProgressContainer:Landroid/view/View;

.field private final mRequestFocus:Ljava/lang/Runnable;

.field mStandardEmptyView:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 173
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 149
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Landroid/app/ListFragment;->mHandler:Landroid/os/Handler;

    .line 151
    new-instance v0, Landroid/app/ListFragment$1;

    invoke-direct {v0, p0}, Landroid/app/ListFragment$1;-><init>(Landroid/app/ListFragment;)V

    iput-object v0, p0, Landroid/app/ListFragment;->mRequestFocus:Ljava/lang/Runnable;

    .line 157
    new-instance v0, Landroid/app/ListFragment$2;

    invoke-direct {v0, p0}, Landroid/app/ListFragment$2;-><init>(Landroid/app/ListFragment;)V

    iput-object v0, p0, Landroid/app/ListFragment;->mOnClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    .line 174
    return-void
.end method

.method private ensureList()V
    .registers 7

    .prologue
    const/4 v5, 0x0

    .line 381
    iget-object v3, p0, Landroid/app/ListFragment;->mList:Landroid/widget/ListView;

    if-eqz v3, :cond_6

    .line 433
    :goto_5
    return-void

    .line 384
    :cond_6
    invoke-virtual {p0}, Landroid/app/ListFragment;->getView()Landroid/view/View;

    move-result-object v2

    .line 385
    .local v2, root:Landroid/view/View;
    if-nez v2, :cond_14

    .line 386
    new-instance v3, Ljava/lang/IllegalStateException;

    const-string v4, "Content view not yet created"

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 388
    :cond_14
    instance-of v3, v2, Landroid/widget/ListView;

    if-eqz v3, :cond_3a

    .line 389
    check-cast v2, Landroid/widget/ListView;

    .end local v2           #root:Landroid/view/View;
    iput-object v2, p0, Landroid/app/ListFragment;->mList:Landroid/widget/ListView;

    .line 419
    :cond_1c
    :goto_1c
    const/4 v3, 0x1

    iput-boolean v3, p0, Landroid/app/ListFragment;->mListShown:Z

    .line 420
    iget-object v3, p0, Landroid/app/ListFragment;->mList:Landroid/widget/ListView;

    iget-object v4, p0, Landroid/app/ListFragment;->mOnClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {v3, v4}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 421
    iget-object v3, p0, Landroid/app/ListFragment;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v3, :cond_af

    .line 422
    iget-object v0, p0, Landroid/app/ListFragment;->mAdapter:Landroid/widget/ListAdapter;

    .line 423
    .local v0, adapter:Landroid/widget/ListAdapter;
    const/4 v3, 0x0

    iput-object v3, p0, Landroid/app/ListFragment;->mAdapter:Landroid/widget/ListAdapter;

    .line 424
    invoke-virtual {p0, v0}, Landroid/app/ListFragment;->setListAdapter(Landroid/widget/ListAdapter;)V

    .line 432
    .end local v0           #adapter:Landroid/widget/ListAdapter;
    :cond_32
    :goto_32
    iget-object v3, p0, Landroid/app/ListFragment;->mHandler:Landroid/os/Handler;

    iget-object v4, p0, Landroid/app/ListFragment;->mRequestFocus:Ljava/lang/Runnable;

    invoke-virtual {v3, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_5

    .line 391
    .restart local v2       #root:Landroid/view/View;
    :cond_3a
    const v3, 0x10202d1

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Landroid/app/ListFragment;->mStandardEmptyView:Landroid/widget/TextView;

    .line 393
    iget-object v3, p0, Landroid/app/ListFragment;->mStandardEmptyView:Landroid/widget/TextView;

    if-nez v3, :cond_77

    .line 394
    const v3, 0x1020004

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    iput-object v3, p0, Landroid/app/ListFragment;->mEmptyView:Landroid/view/View;

    .line 398
    :goto_52
    const v3, 0x10202cf

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    iput-object v3, p0, Landroid/app/ListFragment;->mProgressContainer:Landroid/view/View;

    .line 399
    const v3, 0x10202d0

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    iput-object v3, p0, Landroid/app/ListFragment;->mListContainer:Landroid/view/View;

    .line 400
    const v3, 0x102000a

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 401
    .local v1, rawListView:Landroid/view/View;
    instance-of v3, v1, Landroid/widget/ListView;

    if-nez v3, :cond_7f

    .line 402
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "Content has view with id attribute \'android.R.id.list\' that is not a ListView class"

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 396
    .end local v1           #rawListView:Landroid/view/View;
    :cond_77
    iget-object v3, p0, Landroid/app/ListFragment;->mStandardEmptyView:Landroid/widget/TextView;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_52

    .line 406
    .restart local v1       #rawListView:Landroid/view/View;
    :cond_7f
    check-cast v1, Landroid/widget/ListView;

    .end local v1           #rawListView:Landroid/view/View;
    iput-object v1, p0, Landroid/app/ListFragment;->mList:Landroid/widget/ListView;

    .line 407
    iget-object v3, p0, Landroid/app/ListFragment;->mList:Landroid/widget/ListView;

    if-nez v3, :cond_8f

    .line 408
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "Your content must have a ListView whose id attribute is \'android.R.id.list\'"

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 412
    :cond_8f
    iget-object v3, p0, Landroid/app/ListFragment;->mEmptyView:Landroid/view/View;

    if-eqz v3, :cond_9b

    .line 413
    iget-object v3, p0, Landroid/app/ListFragment;->mList:Landroid/widget/ListView;

    iget-object v4, p0, Landroid/app/ListFragment;->mEmptyView:Landroid/view/View;

    invoke-virtual {v3, v4}, Landroid/widget/ListView;->setEmptyView(Landroid/view/View;)V

    goto :goto_1c

    .line 414
    :cond_9b
    iget-object v3, p0, Landroid/app/ListFragment;->mEmptyText:Ljava/lang/CharSequence;

    if-eqz v3, :cond_1c

    .line 415
    iget-object v3, p0, Landroid/app/ListFragment;->mStandardEmptyView:Landroid/widget/TextView;

    iget-object v4, p0, Landroid/app/ListFragment;->mEmptyText:Ljava/lang/CharSequence;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 416
    iget-object v3, p0, Landroid/app/ListFragment;->mList:Landroid/widget/ListView;

    iget-object v4, p0, Landroid/app/ListFragment;->mStandardEmptyView:Landroid/widget/TextView;

    invoke-virtual {v3, v4}, Landroid/widget/ListView;->setEmptyView(Landroid/view/View;)V

    goto/16 :goto_1c

    .line 428
    .end local v2           #root:Landroid/view/View;
    :cond_af
    iget-object v3, p0, Landroid/app/ListFragment;->mProgressContainer:Landroid/view/View;

    if-eqz v3, :cond_32

    .line 429
    invoke-direct {p0, v5, v5}, Landroid/app/ListFragment;->setListShown(ZZ)V

    goto/16 :goto_32
.end method

.method private setListShown(ZZ)V
    .registers 9
    .parameter "shown"
    .parameter "animate"

    .prologue
    const v5, 0x10a0001

    const/high16 v4, 0x10a

    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 338
    invoke-direct {p0}, Landroid/app/ListFragment;->ensureList()V

    .line 339
    iget-object v0, p0, Landroid/app/ListFragment;->mProgressContainer:Landroid/view/View;

    if-nez v0, :cond_17

    .line 340
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Can\'t be used with a custom content view"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 342
    :cond_17
    iget-boolean v0, p0, Landroid/app/ListFragment;->mListShown:Z

    if-ne v0, p1, :cond_1c

    .line 371
    :goto_1b
    return-void

    .line 345
    :cond_1c
    iput-boolean p1, p0, Landroid/app/ListFragment;->mListShown:Z

    .line 346
    if-eqz p1, :cond_52

    .line 347
    if-eqz p2, :cond_47

    .line 348
    iget-object v0, p0, Landroid/app/ListFragment;->mProgressContainer:Landroid/view/View;

    invoke-virtual {p0}, Landroid/app/ListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-static {v1, v5}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 350
    iget-object v0, p0, Landroid/app/ListFragment;->mListContainer:Landroid/view/View;

    invoke-virtual {p0}, Landroid/app/ListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-static {v1, v4}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 356
    :goto_3c
    iget-object v0, p0, Landroid/app/ListFragment;->mProgressContainer:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 357
    iget-object v0, p0, Landroid/app/ListFragment;->mListContainer:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1b

    .line 353
    :cond_47
    iget-object v0, p0, Landroid/app/ListFragment;->mProgressContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->clearAnimation()V

    .line 354
    iget-object v0, p0, Landroid/app/ListFragment;->mListContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->clearAnimation()V

    goto :goto_3c

    .line 359
    :cond_52
    if-eqz p2, :cond_79

    .line 360
    iget-object v0, p0, Landroid/app/ListFragment;->mProgressContainer:Landroid/view/View;

    invoke-virtual {p0}, Landroid/app/ListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-static {v1, v4}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 362
    iget-object v0, p0, Landroid/app/ListFragment;->mListContainer:Landroid/view/View;

    invoke-virtual {p0}, Landroid/app/ListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-static {v1, v5}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 368
    :goto_6e
    iget-object v0, p0, Landroid/app/ListFragment;->mProgressContainer:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 369
    iget-object v0, p0, Landroid/app/ListFragment;->mListContainer:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1b

    .line 365
    :cond_79
    iget-object v0, p0, Landroid/app/ListFragment;->mProgressContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->clearAnimation()V

    .line 366
    iget-object v0, p0, Landroid/app/ListFragment;->mListContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->clearAnimation()V

    goto :goto_6e
.end method


# virtual methods
.method public getListAdapter()Landroid/widget/ListAdapter;
    .registers 2

    .prologue
    .line 377
    iget-object v0, p0, Landroid/app/ListFragment;->mAdapter:Landroid/widget/ListAdapter;

    return-object v0
.end method

.method public getListView()Landroid/widget/ListView;
    .registers 2

    .prologue
    .line 280
    invoke-direct {p0}, Landroid/app/ListFragment;->ensureList()V

    .line 281
    iget-object v0, p0, Landroid/app/ListFragment;->mList:Landroid/widget/ListView;

    return-object v0
.end method

.method public getSelectedItemId()J
    .registers 3

    .prologue
    .line 272
    invoke-direct {p0}, Landroid/app/ListFragment;->ensureList()V

    .line 273
    iget-object v0, p0, Landroid/app/ListFragment;->mList:Landroid/widget/ListView;

    invoke-virtual {v0}, Landroid/widget/ListView;->getSelectedItemId()J

    move-result-wide v0

    return-wide v0
.end method

.method public getSelectedItemPosition()I
    .registers 2

    .prologue
    .line 264
    invoke-direct {p0}, Landroid/app/ListFragment;->ensureList()V

    .line 265
    iget-object v0, p0, Landroid/app/ListFragment;->mList:Landroid/widget/ListView;

    invoke-virtual {v0}, Landroid/widget/ListView;->getSelectedItemPosition()I

    move-result v0

    return v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .registers 6
    .parameter "inflater"
    .parameter "container"
    .parameter "savedInstanceState"

    .prologue
    .line 193
    const v0, 0x1090014

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroyView()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 211
    iget-object v0, p0, Landroid/app/ListFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroid/app/ListFragment;->mRequestFocus:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 212
    iput-object v2, p0, Landroid/app/ListFragment;->mList:Landroid/widget/ListView;

    .line 213
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/app/ListFragment;->mListShown:Z

    .line 214
    iput-object v2, p0, Landroid/app/ListFragment;->mListContainer:Landroid/view/View;

    iput-object v2, p0, Landroid/app/ListFragment;->mProgressContainer:Landroid/view/View;

    iput-object v2, p0, Landroid/app/ListFragment;->mEmptyView:Landroid/view/View;

    .line 215
    iput-object v2, p0, Landroid/app/ListFragment;->mStandardEmptyView:Landroid/widget/TextView;

    .line 216
    invoke-super {p0}, Landroid/app/Fragment;->onDestroyView()V

    .line 217
    return-void
.end method

.method public onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V
    .registers 6
    .parameter "l"
    .parameter "v"
    .parameter "position"
    .parameter "id"

    .prologue
    .line 231
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .registers 3
    .parameter "view"
    .parameter "savedInstanceState"

    .prologue
    .line 202
    invoke-super {p0, p1, p2}, Landroid/app/Fragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 203
    invoke-direct {p0}, Landroid/app/ListFragment;->ensureList()V

    .line 204
    return-void
.end method

.method public setEmptyText(Ljava/lang/CharSequence;)V
    .registers 4
    .parameter "text"

    .prologue
    .line 290
    invoke-direct {p0}, Landroid/app/ListFragment;->ensureList()V

    .line 291
    iget-object v0, p0, Landroid/app/ListFragment;->mStandardEmptyView:Landroid/widget/TextView;

    if-nez v0, :cond_f

    .line 292
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Can\'t be used with a custom content view"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 294
    :cond_f
    iget-object v0, p0, Landroid/app/ListFragment;->mStandardEmptyView:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 295
    iget-object v0, p0, Landroid/app/ListFragment;->mEmptyText:Ljava/lang/CharSequence;

    if-nez v0, :cond_1f

    .line 296
    iget-object v0, p0, Landroid/app/ListFragment;->mList:Landroid/widget/ListView;

    iget-object v1, p0, Landroid/app/ListFragment;->mStandardEmptyView:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setEmptyView(Landroid/view/View;)V

    .line 298
    :cond_1f
    iput-object p1, p0, Landroid/app/ListFragment;->mEmptyText:Ljava/lang/CharSequence;

    .line 299
    return-void
.end method

.method public setListAdapter(Landroid/widget/ListAdapter;)V
    .registers 6
    .parameter "adapter"

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 237
    iget-object v3, p0, Landroid/app/ListFragment;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v3, :cond_27

    move v0, v1

    .line 238
    .local v0, hadAdapter:Z
    :goto_7
    iput-object p1, p0, Landroid/app/ListFragment;->mAdapter:Landroid/widget/ListAdapter;

    .line 239
    iget-object v3, p0, Landroid/app/ListFragment;->mList:Landroid/widget/ListView;

    if-eqz v3, :cond_26

    .line 240
    iget-object v3, p0, Landroid/app/ListFragment;->mList:Landroid/widget/ListView;

    invoke-virtual {v3, p1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 241
    iget-boolean v3, p0, Landroid/app/ListFragment;->mListShown:Z

    if-nez v3, :cond_26

    if-nez v0, :cond_26

    .line 244
    invoke-virtual {p0}, Landroid/app/ListFragment;->getView()Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v3

    if-eqz v3, :cond_23

    move v2, v1

    :cond_23
    invoke-direct {p0, v1, v2}, Landroid/app/ListFragment;->setListShown(ZZ)V

    .line 247
    :cond_26
    return-void

    .end local v0           #hadAdapter:Z
    :cond_27
    move v0, v2

    .line 237
    goto :goto_7
.end method

.method public setListShown(Z)V
    .registers 3
    .parameter "shown"

    .prologue
    .line 316
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Landroid/app/ListFragment;->setListShown(ZZ)V

    .line 317
    return-void
.end method

.method public setListShownNoAnimation(Z)V
    .registers 3
    .parameter "shown"

    .prologue
    .line 324
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/app/ListFragment;->setListShown(ZZ)V

    .line 325
    return-void
.end method

.method public setSelection(I)V
    .registers 3
    .parameter "position"

    .prologue
    .line 256
    invoke-direct {p0}, Landroid/app/ListFragment;->ensureList()V

    .line 257
    iget-object v0, p0, Landroid/app/ListFragment;->mList:Landroid/widget/ListView;

    invoke-virtual {v0, p1}, Landroid/widget/ListView;->setSelection(I)V

    .line 258
    return-void
.end method
