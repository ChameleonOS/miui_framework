.class public Landroid/preference/MiuiVolumePreference;
.super Landroid/preference/SeekBarDialogPreference;
.source "MiuiVolumePreference.java"

# interfaces
.implements Landroid/preference/PreferenceManager$OnActivityStopListener;
.implements Landroid/view/View$OnKeyListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;,
        Landroid/preference/MiuiVolumePreference$SavedState;,
        Landroid/preference/MiuiVolumePreference$VolumeStore;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "VolumePreference"


# instance fields
.field private mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

.field private mStreamType:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 6
    .parameter "context"
    .parameter "attrs"

    .prologue
    const/4 v2, 0x0

    invoke-direct {p0, p1, p2}, Landroid/preference/SeekBarDialogPreference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    sget-object v1, Landroid/R$styleable;->VolumePreference:[I

    invoke-virtual {p1, p2, v1, v2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .local v0, a:Landroid/content/res/TypedArray;
    invoke-virtual {v0, v2, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    iput v1, p0, Landroid/preference/MiuiVolumePreference;->mStreamType:I

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    return-void
.end method

.method private cleanup()V
    .registers 6

    .prologue
    const/4 v4, 0x0

    invoke-virtual {p0}, Landroid/preference/MiuiVolumePreference;->getPreferenceManager()Landroid/preference/PreferenceManager;

    move-result-object v2

    invoke-virtual {v2, p0}, Landroid/preference/PreferenceManager;->unregisterOnActivityStopListener(Landroid/preference/PreferenceManager$OnActivityStopListener;)V

    iget-object v2, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    if-eqz v2, :cond_38

    invoke-virtual {p0}, Landroid/preference/MiuiVolumePreference;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    .local v0, dialog:Landroid/app/Dialog;
    if-eqz v0, :cond_31

    invoke-virtual {v0}, Landroid/app/Dialog;->isShowing()Z

    move-result v2

    if-eqz v2, :cond_31

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v2

    const v3, 0x60b0012

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .local v1, view:Landroid/view/View;
    if-eqz v1, :cond_2c

    invoke-virtual {v1, v4}, Landroid/view/View;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    :cond_2c
    iget-object v2, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    invoke-virtual {v2}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->revertVolume()V

    .end local v1           #view:Landroid/view/View;
    :cond_31
    iget-object v2, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    invoke-virtual {v2}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->stop()V

    iput-object v4, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    .end local v0           #dialog:Landroid/app/Dialog;
    :cond_38
    return-void
.end method


# virtual methods
.method public onActivityStop()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    if-eqz v0, :cond_9

    iget-object v0, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    invoke-virtual {v0}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->stopSample()V

    :cond_9
    return-void
.end method

.method protected onBindDialogView(Landroid/view/View;)V
    .registers 6
    .parameter "view"

    .prologue
    invoke-super {p0, p1}, Landroid/preference/SeekBarDialogPreference;->onBindDialogView(Landroid/view/View;)V

    const v1, 0x60b0012

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/SeekBar;

    .local v0, seekBar:Landroid/widget/SeekBar;
    new-instance v1, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    invoke-virtual {p0}, Landroid/preference/MiuiVolumePreference;->getContext()Landroid/content/Context;

    move-result-object v2

    iget v3, p0, Landroid/preference/MiuiVolumePreference;->mStreamType:I

    invoke-direct {v1, p0, v2, v0, v3}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;-><init>(Landroid/preference/MiuiVolumePreference;Landroid/content/Context;Landroid/widget/SeekBar;I)V

    iput-object v1, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    invoke-virtual {p0}, Landroid/preference/MiuiVolumePreference;->getPreferenceManager()Landroid/preference/PreferenceManager;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/preference/PreferenceManager;->registerOnActivityStopListener(Landroid/preference/PreferenceManager$OnActivityStopListener;)V

    invoke-virtual {p1, p0}, Landroid/view/View;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    const/4 v1, 0x1

    invoke-virtual {p1, v1}, Landroid/view/View;->setFocusableInTouchMode(Z)V

    invoke-virtual {p1}, Landroid/view/View;->requestFocus()Z

    return-void
.end method

.method protected onDialogClosed(Z)V
    .registers 3
    .parameter "positiveResult"

    .prologue
    invoke-super {p0, p1}, Landroid/preference/SeekBarDialogPreference;->onDialogClosed(Z)V

    if-nez p1, :cond_e

    iget-object v0, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    if-eqz v0, :cond_e

    iget-object v0, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    invoke-virtual {v0}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->revertVolume()V

    :cond_e
    invoke-direct {p0}, Landroid/preference/MiuiVolumePreference;->cleanup()V

    return-void
.end method

.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .registers 8
    .parameter "v"
    .parameter "keyCode"
    .parameter "event"

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    iget-object v3, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    if-nez v3, :cond_7

    :cond_6
    :goto_6
    return v1

    :cond_7
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v3

    if-nez v3, :cond_13

    move v0, v1

    .local v0, isdown:Z
    :goto_e
    sparse-switch p2, :sswitch_data_2e

    move v1, v2

    goto :goto_6

    .end local v0           #isdown:Z
    :cond_13
    move v0, v2

    goto :goto_e

    .restart local v0       #isdown:Z
    :sswitch_15
    if-eqz v0, :cond_6

    iget-object v2, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    const/4 v3, -0x1

    invoke-virtual {v2, v3}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->changeVolumeBy(I)V

    goto :goto_6

    :sswitch_1e
    if-eqz v0, :cond_6

    iget-object v2, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    invoke-virtual {v2, v1}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->changeVolumeBy(I)V

    goto :goto_6

    :sswitch_26
    if-eqz v0, :cond_6

    iget-object v2, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    invoke-virtual {v2}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->muteVolume()V

    goto :goto_6

    :sswitch_data_2e
    .sparse-switch
        0x18 -> :sswitch_1e
        0x19 -> :sswitch_15
        0xa4 -> :sswitch_26
    .end sparse-switch
.end method

.method protected onRestoreInstanceState(Landroid/os/Parcelable;)V
    .registers 5
    .parameter "state"

    .prologue
    if-eqz p1, :cond_e

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const-class v2, Landroid/preference/MiuiVolumePreference$SavedState;

    invoke-virtual {v1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_12

    :cond_e
    invoke-super {p0, p1}, Landroid/preference/SeekBarDialogPreference;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    :cond_11
    :goto_11
    return-void

    :cond_12
    move-object v0, p1

    check-cast v0, Landroid/preference/MiuiVolumePreference$SavedState;

    .local v0, myState:Landroid/preference/MiuiVolumePreference$SavedState;
    invoke-virtual {v0}, Landroid/preference/MiuiVolumePreference$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-super {p0, v1}, Landroid/preference/SeekBarDialogPreference;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    iget-object v1, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    if-eqz v1, :cond_11

    iget-object v1, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    invoke-virtual {v0}, Landroid/preference/MiuiVolumePreference$SavedState;->getVolumeStore()Landroid/preference/MiuiVolumePreference$VolumeStore;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->onRestoreInstanceState(Landroid/preference/MiuiVolumePreference$VolumeStore;)V

    goto :goto_11
.end method

.method protected onSampleStarting(Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;)V
    .registers 3
    .parameter "volumizer"

    .prologue
    iget-object v0, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    if-eqz v0, :cond_d

    iget-object v0, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    if-eq p1, v0, :cond_d

    iget-object v0, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    invoke-virtual {v0}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->stopSample()V

    :cond_d
    return-void
.end method

.method protected onSaveInstanceState()Landroid/os/Parcelable;
    .registers 5

    .prologue
    invoke-super {p0}, Landroid/preference/SeekBarDialogPreference;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v1

    .local v1, superState:Landroid/os/Parcelable;
    invoke-virtual {p0}, Landroid/preference/MiuiVolumePreference;->isPersistent()Z

    move-result v2

    if-eqz v2, :cond_b

    .end local v1           #superState:Landroid/os/Parcelable;
    :goto_a
    return-object v1

    .restart local v1       #superState:Landroid/os/Parcelable;
    :cond_b
    new-instance v0, Landroid/preference/MiuiVolumePreference$SavedState;

    invoke-direct {v0, v1}, Landroid/preference/MiuiVolumePreference$SavedState;-><init>(Landroid/os/Parcelable;)V

    .local v0, myState:Landroid/preference/MiuiVolumePreference$SavedState;
    iget-object v2, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    if-eqz v2, :cond_1d

    iget-object v2, p0, Landroid/preference/MiuiVolumePreference;->mSeekBarVolumizer:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    invoke-virtual {v0}, Landroid/preference/MiuiVolumePreference$SavedState;->getVolumeStore()Landroid/preference/MiuiVolumePreference$VolumeStore;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->onSaveInstanceState(Landroid/preference/MiuiVolumePreference$VolumeStore;)V

    :cond_1d
    move-object v1, v0

    goto :goto_a
.end method

.method public setStreamType(I)V
    .registers 2
    .parameter "streamType"

    .prologue
    iput p1, p0, Landroid/preference/MiuiVolumePreference;->mStreamType:I

    return-void
.end method
