.class public Lcom/android/internal/preference/YesNoPreference;
.super Landroid/preference/DialogPreference;
.source "YesNoPreference.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/preference/YesNoPreference$SavedState;
    }
.end annotation


# instance fields
.field private mWasPositiveResult:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 44
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/internal/preference/YesNoPreference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 45
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 40
    const v0, 0x1010090

    invoke-direct {p0, p1, p2, v0}, Lcom/android/internal/preference/YesNoPreference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 41
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 4
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyle"

    .prologue
    .line 36
    invoke-direct {p0, p1, p2, p3}, Landroid/preference/DialogPreference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 37
    return-void
.end method


# virtual methods
.method public getValue()Z
    .registers 2

    .prologue
    .line 76
    iget-boolean v0, p0, Lcom/android/internal/preference/YesNoPreference;->mWasPositiveResult:Z

    return v0
.end method

.method protected onDialogClosed(Z)V
    .registers 3
    .parameter "positiveResult"

    .prologue
    .line 49
    invoke-super {p0, p1}, Landroid/preference/DialogPreference;->onDialogClosed(Z)V

    .line 51
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/internal/preference/YesNoPreference;->callChangeListener(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_10

    .line 52
    invoke-virtual {p0, p1}, Lcom/android/internal/preference/YesNoPreference;->setValue(Z)V

    .line 54
    :cond_10
    return-void
.end method

.method protected onGetDefaultValue(Landroid/content/res/TypedArray;I)Ljava/lang/Object;
    .registers 4
    .parameter "a"
    .parameter "index"

    .prologue
    .line 81
    const/4 v0, 0x0

    invoke-virtual {p1, p2, v0}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method protected onRestoreInstanceState(Landroid/os/Parcelable;)V
    .registers 5
    .parameter "state"

    .prologue
    .line 110
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const-class v2, Lcom/android/internal/preference/YesNoPreference$SavedState;

    invoke-virtual {v1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_10

    .line 112
    invoke-super {p0, p1}, Landroid/preference/DialogPreference;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 119
    :goto_f
    return-void

    :cond_10
    move-object v0, p1

    .line 116
    check-cast v0, Lcom/android/internal/preference/YesNoPreference$SavedState;

    .line 117
    .local v0, myState:Lcom/android/internal/preference/YesNoPreference$SavedState;
    invoke-virtual {v0}, Lcom/android/internal/preference/YesNoPreference$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-super {p0, v1}, Landroid/preference/DialogPreference;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 118
    iget-boolean v1, v0, Lcom/android/internal/preference/YesNoPreference$SavedState;->wasPositiveResult:Z

    invoke-virtual {p0, v1}, Lcom/android/internal/preference/YesNoPreference;->setValue(Z)V

    goto :goto_f
.end method

.method protected onSaveInstanceState()Landroid/os/Parcelable;
    .registers 4

    .prologue
    .line 97
    invoke-super {p0}, Landroid/preference/DialogPreference;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v1

    .line 98
    .local v1, superState:Landroid/os/Parcelable;
    invoke-virtual {p0}, Lcom/android/internal/preference/YesNoPreference;->isPersistent()Z

    move-result v2

    if-eqz v2, :cond_b

    .line 105
    .end local v1           #superState:Landroid/os/Parcelable;
    :goto_a
    return-object v1

    .line 103
    .restart local v1       #superState:Landroid/os/Parcelable;
    :cond_b
    new-instance v0, Lcom/android/internal/preference/YesNoPreference$SavedState;

    invoke-direct {v0, v1}, Lcom/android/internal/preference/YesNoPreference$SavedState;-><init>(Landroid/os/Parcelable;)V

    .line 104
    .local v0, myState:Lcom/android/internal/preference/YesNoPreference$SavedState;
    invoke-virtual {p0}, Lcom/android/internal/preference/YesNoPreference;->getValue()Z

    move-result v2

    iput-boolean v2, v0, Lcom/android/internal/preference/YesNoPreference$SavedState;->wasPositiveResult:Z

    move-object v1, v0

    .line 105
    goto :goto_a
.end method

.method protected onSetInitialValue(ZLjava/lang/Object;)V
    .registers 4
    .parameter "restorePersistedValue"
    .parameter "defaultValue"

    .prologue
    .line 86
    if-eqz p1, :cond_c

    iget-boolean v0, p0, Lcom/android/internal/preference/YesNoPreference;->mWasPositiveResult:Z

    invoke-virtual {p0, v0}, Lcom/android/internal/preference/YesNoPreference;->getPersistedBoolean(Z)Z

    move-result v0

    .end local p2
    :goto_8
    invoke-virtual {p0, v0}, Lcom/android/internal/preference/YesNoPreference;->setValue(Z)V

    .line 88
    return-void

    .line 86
    .restart local p2
    :cond_c
    check-cast p2, Ljava/lang/Boolean;

    .end local p2
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    goto :goto_8
.end method

.method public setValue(Z)V
    .registers 3
    .parameter "value"

    .prologue
    .line 63
    iput-boolean p1, p0, Lcom/android/internal/preference/YesNoPreference;->mWasPositiveResult:Z

    .line 65
    invoke-virtual {p0, p1}, Lcom/android/internal/preference/YesNoPreference;->persistBoolean(Z)Z

    .line 67
    if-nez p1, :cond_c

    const/4 v0, 0x1

    :goto_8
    invoke-virtual {p0, v0}, Lcom/android/internal/preference/YesNoPreference;->notifyDependencyChange(Z)V

    .line 68
    return-void

    .line 67
    :cond_c
    const/4 v0, 0x0

    goto :goto_8
.end method

.method public shouldDisableDependents()Z
    .registers 2

    .prologue
    .line 92
    iget-boolean v0, p0, Lcom/android/internal/preference/YesNoPreference;->mWasPositiveResult:Z

    if-eqz v0, :cond_a

    invoke-super {p0}, Landroid/preference/DialogPreference;->shouldDisableDependents()Z

    move-result v0

    if-eqz v0, :cond_c

    :cond_a
    const/4 v0, 0x1

    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method
