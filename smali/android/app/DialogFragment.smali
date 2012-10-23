.class public Landroid/app/DialogFragment;
.super Landroid/app/Fragment;
.source "DialogFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;
.implements Landroid/content/DialogInterface$OnDismissListener;


# static fields
.field private static final SAVED_BACK_STACK_ID:Ljava/lang/String; = "android:backStackId"

.field private static final SAVED_CANCELABLE:Ljava/lang/String; = "android:cancelable"

.field private static final SAVED_DIALOG_STATE_TAG:Ljava/lang/String; = "android:savedDialogState"

.field private static final SAVED_SHOWS_DIALOG:Ljava/lang/String; = "android:showsDialog"

.field private static final SAVED_STYLE:Ljava/lang/String; = "android:style"

.field private static final SAVED_THEME:Ljava/lang/String; = "android:theme"

.field public static final STYLE_NORMAL:I = 0x0

.field public static final STYLE_NO_FRAME:I = 0x2

.field public static final STYLE_NO_INPUT:I = 0x3

.field public static final STYLE_NO_TITLE:I = 0x1


# instance fields
.field mBackStackId:I

.field mCancelable:Z

.field mDialog:Landroid/app/Dialog;

.field mDismissed:Z

.field mShownByMe:Z

.field mShowsDialog:Z

.field mStyle:I

.field mTheme:I

.field mViewDestroyed:Z


# direct methods
.method public constructor <init>()V
    .registers 3

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 187
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 176
    iput v0, p0, Landroid/app/DialogFragment;->mStyle:I

    .line 177
    iput v0, p0, Landroid/app/DialogFragment;->mTheme:I

    .line 178
    iput-boolean v1, p0, Landroid/app/DialogFragment;->mCancelable:Z

    .line 179
    iput-boolean v1, p0, Landroid/app/DialogFragment;->mShowsDialog:Z

    .line 180
    const/4 v0, -0x1

    iput v0, p0, Landroid/app/DialogFragment;->mBackStackId:I

    .line 188
    return-void
.end method


# virtual methods
.method public dismiss()V
    .registers 2

    .prologue
    .line 258
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/app/DialogFragment;->dismissInternal(Z)V

    .line 259
    return-void
.end method

.method public dismissAllowingStateLoss()V
    .registers 2

    .prologue
    .line 268
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/app/DialogFragment;->dismissInternal(Z)V

    .line 269
    return-void
.end method

.method dismissInternal(Z)V
    .registers 6
    .parameter "allowStateLoss"

    .prologue
    const/4 v3, 0x1

    .line 272
    iget-boolean v1, p0, Landroid/app/DialogFragment;->mDismissed:Z

    if-eqz v1, :cond_6

    .line 295
    :goto_5
    return-void

    .line 275
    :cond_6
    iput-boolean v3, p0, Landroid/app/DialogFragment;->mDismissed:Z

    .line 276
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/app/DialogFragment;->mShownByMe:Z

    .line 277
    iget-object v1, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    if-eqz v1, :cond_17

    .line 278
    iget-object v1, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    invoke-virtual {v1}, Landroid/app/Dialog;->dismiss()V

    .line 279
    const/4 v1, 0x0

    iput-object v1, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    .line 281
    :cond_17
    iput-boolean v3, p0, Landroid/app/DialogFragment;->mViewDestroyed:Z

    .line 282
    iget v1, p0, Landroid/app/DialogFragment;->mBackStackId:I

    if-ltz v1, :cond_2a

    .line 283
    invoke-virtual {p0}, Landroid/app/DialogFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    iget v2, p0, Landroid/app/DialogFragment;->mBackStackId:I

    invoke-virtual {v1, v2, v3}, Landroid/app/FragmentManager;->popBackStack(II)V

    .line 285
    const/4 v1, -0x1

    iput v1, p0, Landroid/app/DialogFragment;->mBackStackId:I

    goto :goto_5

    .line 287
    :cond_2a
    invoke-virtual {p0}, Landroid/app/DialogFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 288
    .local v0, ft:Landroid/app/FragmentTransaction;
    invoke-virtual {v0, p0}, Landroid/app/FragmentTransaction;->remove(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    .line 289
    if-eqz p1, :cond_3b

    .line 290
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commitAllowingStateLoss()I

    goto :goto_5

    .line 292
    :cond_3b
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    goto :goto_5
.end method

.method public dump(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .registers 6
    .parameter "prefix"
    .parameter "fd"
    .parameter "writer"
    .parameter "args"

    .prologue
    .line 546
    invoke-super {p0, p1, p2, p3, p4}, Landroid/app/Fragment;->dump(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    .line 547
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "DialogFragment:"

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    .line 548
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "  mStyle="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/app/DialogFragment;->mStyle:I

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(I)V

    .line 549
    const-string v0, " mTheme=0x"

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/app/DialogFragment;->mTheme:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    .line 550
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "  mCancelable="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/app/DialogFragment;->mCancelable:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Z)V

    .line 551
    const-string v0, " mShowsDialog="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/app/DialogFragment;->mShowsDialog:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Z)V

    .line 552
    const-string v0, " mBackStackId="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/app/DialogFragment;->mBackStackId:I

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(I)V

    .line 553
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "  mDialog="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 554
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "  mViewDestroyed="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/app/DialogFragment;->mViewDestroyed:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Z)V

    .line 555
    const-string v0, " mDismissed="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/app/DialogFragment;->mDismissed:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Z)V

    .line 556
    const-string v0, " mShownByMe="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/app/DialogFragment;->mShownByMe:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Z)V

    .line 557
    return-void
.end method

.method public getDialog()Landroid/app/Dialog;
    .registers 2

    .prologue
    .line 298
    iget-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    return-object v0
.end method

.method public getLayoutInflater(Landroid/os/Bundle;)Landroid/view/LayoutInflater;
    .registers 4
    .parameter "savedInstanceState"

    .prologue
    .line 394
    iget-boolean v0, p0, Landroid/app/DialogFragment;->mShowsDialog:Z

    if-nez v0, :cond_9

    .line 395
    invoke-super {p0, p1}, Landroid/app/Fragment;->getLayoutInflater(Landroid/os/Bundle;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 413
    :goto_8
    return-object v0

    .line 398
    :cond_9
    invoke-virtual {p0, p1}, Landroid/app/DialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;

    move-result-object v0

    iput-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    .line 399
    iget v0, p0, Landroid/app/DialogFragment;->mStyle:I

    packed-switch v0, :pswitch_data_44

    .line 409
    :goto_14
    iget-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    if-eqz v0, :cond_39

    .line 410
    iget-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    goto :goto_8

    .line 401
    :pswitch_27
    iget-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x18

    invoke-virtual {v0, v1}, Landroid/view/Window;->addFlags(I)V

    .line 407
    :pswitch_32
    iget-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/Dialog;->requestWindowFeature(I)Z

    goto :goto_14

    .line 413
    :cond_39
    iget-object v0, p0, Landroid/app/Fragment;->mActivity:Landroid/app/Activity;

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    goto :goto_8

    .line 399
    :pswitch_data_44
    .packed-switch 0x1
        :pswitch_32
        :pswitch_32
        :pswitch_27
    .end packed-switch
.end method

.method public getShowsDialog()Z
    .registers 2

    .prologue
    .line 351
    iget-boolean v0, p0, Landroid/app/DialogFragment;->mShowsDialog:Z

    return v0
.end method

.method public getTheme()I
    .registers 2

    .prologue
    .line 302
    iget v0, p0, Landroid/app/DialogFragment;->mTheme:I

    return v0
.end method

.method public isCancelable()Z
    .registers 2

    .prologue
    .line 323
    iget-boolean v0, p0, Landroid/app/DialogFragment;->mCancelable:Z

    return v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .registers 6
    .parameter "savedInstanceState"

    .prologue
    .line 458
    invoke-super {p0, p1}, Landroid/app/Fragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 460
    iget-boolean v2, p0, Landroid/app/DialogFragment;->mShowsDialog:Z

    if-nez v2, :cond_8

    .line 483
    :cond_7
    :goto_7
    return-void

    .line 464
    :cond_8
    invoke-virtual {p0}, Landroid/app/DialogFragment;->getView()Landroid/view/View;

    move-result-object v1

    .line 465
    .local v1, view:Landroid/view/View;
    if-eqz v1, :cond_21

    .line 466
    invoke-virtual {v1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    if-eqz v2, :cond_1c

    .line 467
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "DialogFragment can not be attached to a container view"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 469
    :cond_1c
    iget-object v2, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    invoke-virtual {v2, v1}, Landroid/app/Dialog;->setContentView(Landroid/view/View;)V

    .line 471
    :cond_21
    iget-object v2, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    invoke-virtual {p0}, Landroid/app/DialogFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/app/Dialog;->setOwnerActivity(Landroid/app/Activity;)V

    .line 472
    iget-object v2, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    iget-boolean v3, p0, Landroid/app/DialogFragment;->mCancelable:Z

    invoke-virtual {v2, v3}, Landroid/app/Dialog;->setCancelable(Z)V

    .line 473
    iget-object v2, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    const-string v3, "DialogFragment"

    invoke-virtual {v2, v3, p0, p0}, Landroid/app/Dialog;->takeCancelAndDismissListeners(Ljava/lang/String;Landroid/content/DialogInterface$OnCancelListener;Landroid/content/DialogInterface$OnDismissListener;)Z

    move-result v2

    if-nez v2, :cond_43

    .line 474
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "You can not set Dialog\'s OnCancelListener or OnDismissListener"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 477
    :cond_43
    if-eqz p1, :cond_7

    .line 478
    const-string v2, "android:savedDialogState"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 479
    .local v0, dialogState:Landroid/os/Bundle;
    if-eqz v0, :cond_7

    .line 480
    iget-object v2, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    invoke-virtual {v2, v0}, Landroid/app/Dialog;->onRestoreInstanceState(Landroid/os/Bundle;)V

    goto :goto_7
.end method

.method public onAttach(Landroid/app/Activity;)V
    .registers 3
    .parameter "activity"

    .prologue
    .line 356
    invoke-super {p0, p1}, Landroid/app/Fragment;->onAttach(Landroid/app/Activity;)V

    .line 357
    iget-boolean v0, p0, Landroid/app/DialogFragment;->mShownByMe:Z

    if-nez v0, :cond_a

    .line 360
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/app/DialogFragment;->mDismissed:Z

    .line 362
    :cond_a
    return-void
.end method

.method public onCancel(Landroid/content/DialogInterface;)V
    .registers 2
    .parameter "dialog"

    .prologue
    .line 444
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .registers 5
    .parameter "savedInstanceState"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 377
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 379
    iget v0, p0, Landroid/app/Fragment;->mContainerId:I

    if-nez v0, :cond_3a

    move v0, v1

    :goto_a
    iput-boolean v0, p0, Landroid/app/DialogFragment;->mShowsDialog:Z

    .line 381
    if-eqz p1, :cond_39

    .line 382
    const-string v0, "android:style"

    invoke-virtual {p1, v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Landroid/app/DialogFragment;->mStyle:I

    .line 383
    const-string v0, "android:theme"

    invoke-virtual {p1, v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Landroid/app/DialogFragment;->mTheme:I

    .line 384
    const-string v0, "android:cancelable"

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Landroid/app/DialogFragment;->mCancelable:Z

    .line 385
    const-string v0, "android:showsDialog"

    iget-boolean v1, p0, Landroid/app/DialogFragment;->mShowsDialog:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Landroid/app/DialogFragment;->mShowsDialog:Z

    .line 386
    const-string v0, "android:backStackId"

    const/4 v1, -0x1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Landroid/app/DialogFragment;->mBackStackId:I

    .line 389
    :cond_39
    return-void

    :cond_3a
    move v0, v2

    .line 379
    goto :goto_a
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .registers 5
    .parameter "savedInstanceState"

    .prologue
    .line 440
    new-instance v0, Landroid/app/Dialog;

    invoke-virtual {p0}, Landroid/app/DialogFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {p0}, Landroid/app/DialogFragment;->getTheme()I

    move-result v2

    invoke-direct {v0, v1, v2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    return-object v0
.end method

.method public onDestroyView()V
    .registers 2

    .prologue
    .line 533
    invoke-super {p0}, Landroid/app/Fragment;->onDestroyView()V

    .line 534
    iget-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    if-eqz v0, :cond_12

    .line 538
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/app/DialogFragment;->mViewDestroyed:Z

    .line 539
    iget-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    .line 540
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    .line 542
    :cond_12
    return-void
.end method

.method public onDetach()V
    .registers 2

    .prologue
    .line 366
    invoke-super {p0}, Landroid/app/Fragment;->onDetach()V

    .line 367
    iget-boolean v0, p0, Landroid/app/DialogFragment;->mShownByMe:Z

    if-nez v0, :cond_e

    iget-boolean v0, p0, Landroid/app/DialogFragment;->mDismissed:Z

    if-nez v0, :cond_e

    .line 371
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/app/DialogFragment;->mDismissed:Z

    .line 373
    :cond_e
    return-void
.end method

.method public onDismiss(Landroid/content/DialogInterface;)V
    .registers 3
    .parameter "dialog"

    .prologue
    .line 447
    iget-boolean v0, p0, Landroid/app/DialogFragment;->mViewDestroyed:Z

    if-nez v0, :cond_8

    .line 452
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/app/DialogFragment;->dismissInternal(Z)V

    .line 454
    :cond_8
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .registers 5
    .parameter "outState"

    .prologue
    .line 496
    invoke-super {p0, p1}, Landroid/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 497
    iget-object v1, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    if-eqz v1, :cond_14

    .line 498
    iget-object v1, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    invoke-virtual {v1}, Landroid/app/Dialog;->onSaveInstanceState()Landroid/os/Bundle;

    move-result-object v0

    .line 499
    .local v0, dialogState:Landroid/os/Bundle;
    if-eqz v0, :cond_14

    .line 500
    const-string v1, "android:savedDialogState"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 503
    .end local v0           #dialogState:Landroid/os/Bundle;
    :cond_14
    iget v1, p0, Landroid/app/DialogFragment;->mStyle:I

    if-eqz v1, :cond_1f

    .line 504
    const-string v1, "android:style"

    iget v2, p0, Landroid/app/DialogFragment;->mStyle:I

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 506
    :cond_1f
    iget v1, p0, Landroid/app/DialogFragment;->mTheme:I

    if-eqz v1, :cond_2a

    .line 507
    const-string v1, "android:theme"

    iget v2, p0, Landroid/app/DialogFragment;->mTheme:I

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 509
    :cond_2a
    iget-boolean v1, p0, Landroid/app/DialogFragment;->mCancelable:Z

    if-nez v1, :cond_35

    .line 510
    const-string v1, "android:cancelable"

    iget-boolean v2, p0, Landroid/app/DialogFragment;->mCancelable:Z

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 512
    :cond_35
    iget-boolean v1, p0, Landroid/app/DialogFragment;->mShowsDialog:Z

    if-nez v1, :cond_40

    .line 513
    const-string v1, "android:showsDialog"

    iget-boolean v2, p0, Landroid/app/DialogFragment;->mShowsDialog:Z

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 515
    :cond_40
    iget v1, p0, Landroid/app/DialogFragment;->mBackStackId:I

    const/4 v2, -0x1

    if-eq v1, v2, :cond_4c

    .line 516
    const-string v1, "android:backStackId"

    iget v2, p0, Landroid/app/DialogFragment;->mBackStackId:I

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 518
    :cond_4c
    return-void
.end method

.method public onStart()V
    .registers 2

    .prologue
    .line 487
    invoke-super {p0}, Landroid/app/Fragment;->onStart()V

    .line 488
    iget-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    if-eqz v0, :cond_f

    .line 489
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/app/DialogFragment;->mViewDestroyed:Z

    .line 490
    iget-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 492
    :cond_f
    return-void
.end method

.method public onStop()V
    .registers 2

    .prologue
    .line 522
    invoke-super {p0}, Landroid/app/Fragment;->onStop()V

    .line 523
    iget-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    if-eqz v0, :cond_c

    .line 524
    iget-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->hide()V

    .line 526
    :cond_c
    return-void
.end method

.method public setCancelable(Z)V
    .registers 3
    .parameter "cancelable"

    .prologue
    .line 315
    iput-boolean p1, p0, Landroid/app/DialogFragment;->mCancelable:Z

    .line 316
    iget-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    if-eqz v0, :cond_b

    iget-object v0, p0, Landroid/app/DialogFragment;->mDialog:Landroid/app/Dialog;

    invoke-virtual {v0, p1}, Landroid/app/Dialog;->setCancelable(Z)V

    .line 317
    :cond_b
    return-void
.end method

.method public setShowsDialog(Z)V
    .registers 2
    .parameter "showsDialog"

    .prologue
    .line 344
    iput-boolean p1, p0, Landroid/app/DialogFragment;->mShowsDialog:Z

    .line 345
    return-void
.end method

.method public setStyle(II)V
    .registers 5
    .parameter "style"
    .parameter "theme"

    .prologue
    .line 205
    iput p1, p0, Landroid/app/DialogFragment;->mStyle:I

    .line 206
    iget v0, p0, Landroid/app/DialogFragment;->mStyle:I

    const/4 v1, 0x2

    if-eq v0, v1, :cond_c

    iget v0, p0, Landroid/app/DialogFragment;->mStyle:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_11

    .line 207
    :cond_c
    const v0, 0x1030305

    iput v0, p0, Landroid/app/DialogFragment;->mTheme:I

    .line 209
    :cond_11
    if-eqz p2, :cond_15

    .line 210
    iput p2, p0, Landroid/app/DialogFragment;->mTheme:I

    .line 212
    :cond_15
    return-void
.end method

.method public show(Landroid/app/FragmentTransaction;Ljava/lang/String;)I
    .registers 5
    .parameter "transaction"
    .parameter "tag"

    .prologue
    const/4 v1, 0x0

    .line 243
    iput-boolean v1, p0, Landroid/app/DialogFragment;->mDismissed:Z

    .line 244
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/app/DialogFragment;->mShownByMe:Z

    .line 245
    invoke-virtual {p1, p0, p2}, Landroid/app/FragmentTransaction;->add(Landroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 246
    iput-boolean v1, p0, Landroid/app/DialogFragment;->mViewDestroyed:Z

    .line 247
    invoke-virtual {p1}, Landroid/app/FragmentTransaction;->commit()I

    move-result v0

    iput v0, p0, Landroid/app/DialogFragment;->mBackStackId:I

    .line 248
    iget v0, p0, Landroid/app/DialogFragment;->mBackStackId:I

    return v0
.end method

.method public show(Landroid/app/FragmentManager;Ljava/lang/String;)V
    .registers 5
    .parameter "manager"
    .parameter "tag"

    .prologue
    .line 226
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/app/DialogFragment;->mDismissed:Z

    .line 227
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/app/DialogFragment;->mShownByMe:Z

    .line 228
    invoke-virtual {p1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 229
    .local v0, ft:Landroid/app/FragmentTransaction;
    invoke-virtual {v0, p0, p2}, Landroid/app/FragmentTransaction;->add(Landroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 230
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    .line 231
    return-void
.end method
