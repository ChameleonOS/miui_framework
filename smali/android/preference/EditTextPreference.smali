.class public Landroid/preference/EditTextPreference;
.super Landroid/preference/DialogPreference;
.source "EditTextPreference.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/preference/EditTextPreference$SavedState;
    }
.end annotation


# instance fields
.field private mEditText:Landroid/widget/EditText;

.field private mText:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 75
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/preference/EditTextPreference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 76
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 71
    const v0, 0x1010092

    invoke-direct {p0, p1, p2, v0}, Landroid/preference/EditTextPreference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 72
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 6
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyle"

    .prologue
    .line 54
    invoke-direct {p0, p1, p2, p3}, Landroid/preference/DialogPreference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 56
    new-instance v0, Landroid/widget/EditText;

    invoke-direct {v0, p1, p2}, Landroid/widget/EditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    iput-object v0, p0, Landroid/preference/EditTextPreference;->mEditText:Landroid/widget/EditText;

    .line 59
    iget-object v0, p0, Landroid/preference/EditTextPreference;->mEditText:Landroid/widget/EditText;

    const v1, 0x1020003

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setId(I)V

    .line 67
    iget-object v0, p0, Landroid/preference/EditTextPreference;->mEditText:Landroid/widget/EditText;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 68
    return-void
.end method


# virtual methods
.method public getEditText()Landroid/widget/EditText;
    .registers 2

    .prologue
    .line 168
    iget-object v0, p0, Landroid/preference/EditTextPreference;->mEditText:Landroid/widget/EditText;

    return-object v0
.end method

.method public getText()Ljava/lang/String;
    .registers 2

    .prologue
    .line 102
    iget-object v0, p0, Landroid/preference/EditTextPreference;->mText:Ljava/lang/String;

    return-object v0
.end method

.method protected needInputMethod()Z
    .registers 2

    .prologue
    .line 175
    const/4 v0, 0x1

    return v0
.end method

.method protected onAddEditTextToDialogView(Landroid/view/View;Landroid/widget/EditText;)V
    .registers 6
    .parameter "dialogView"
    .parameter "editText"

    .prologue
    .line 127
    const v1, 0x10202ff

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 129
    .local v0, container:Landroid/view/ViewGroup;
    if-eqz v0, :cond_10

    .line 130
    const/4 v1, -0x1

    const/4 v2, -0x2

    invoke-virtual {v0, p2, v1, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;II)V

    .line 133
    :cond_10
    return-void
.end method

.method protected onBindDialogView(Landroid/view/View;)V
    .registers 5
    .parameter "view"

    .prologue
    .line 107
    invoke-super {p0, p1}, Landroid/preference/DialogPreference;->onBindDialogView(Landroid/view/View;)V

    .line 109
    iget-object v0, p0, Landroid/preference/EditTextPreference;->mEditText:Landroid/widget/EditText;

    .line 110
    .local v0, editText:Landroid/widget/EditText;
    invoke-virtual {p0}, Landroid/preference/EditTextPreference;->getText()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 112
    invoke-virtual {v0}, Landroid/widget/EditText;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    .line 113
    .local v1, oldParent:Landroid/view/ViewParent;
    if-eq v1, p1, :cond_1c

    .line 114
    if-eqz v1, :cond_19

    .line 115
    check-cast v1, Landroid/view/ViewGroup;

    .end local v1           #oldParent:Landroid/view/ViewParent;
    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 117
    :cond_19
    invoke-virtual {p0, p1, v0}, Landroid/preference/EditTextPreference;->onAddEditTextToDialogView(Landroid/view/View;Landroid/widget/EditText;)V

    .line 119
    :cond_1c
    return-void
.end method

.method protected onDialogClosed(Z)V
    .registers 4
    .parameter "positiveResult"

    .prologue
    .line 137
    invoke-super {p0, p1}, Landroid/preference/DialogPreference;->onDialogClosed(Z)V

    .line 139
    if-eqz p1, :cond_18

    .line 140
    iget-object v1, p0, Landroid/preference/EditTextPreference;->mEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 141
    .local v0, value:Ljava/lang/String;
    invoke-virtual {p0, v0}, Landroid/preference/EditTextPreference;->callChangeListener(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_18

    .line 142
    invoke-virtual {p0, v0}, Landroid/preference/EditTextPreference;->setText(Ljava/lang/String;)V

    .line 145
    .end local v0           #value:Ljava/lang/String;
    :cond_18
    return-void
.end method

.method protected onGetDefaultValue(Landroid/content/res/TypedArray;I)Ljava/lang/Object;
    .registers 4
    .parameter "a"
    .parameter "index"

    .prologue
    .line 149
    invoke-virtual {p1, p2}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected onRestoreInstanceState(Landroid/os/Parcelable;)V
    .registers 5
    .parameter "state"

    .prologue
    .line 193
    if-eqz p1, :cond_e

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const-class v2, Landroid/preference/EditTextPreference$SavedState;

    invoke-virtual {v1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_12

    .line 195
    :cond_e
    invoke-super {p0, p1}, Landroid/preference/DialogPreference;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 202
    :goto_11
    return-void

    :cond_12
    move-object v0, p1

    .line 199
    check-cast v0, Landroid/preference/EditTextPreference$SavedState;

    .line 200
    .local v0, myState:Landroid/preference/EditTextPreference$SavedState;
    invoke-virtual {v0}, Landroid/preference/EditTextPreference$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-super {p0, v1}, Landroid/preference/DialogPreference;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 201
    iget-object v1, v0, Landroid/preference/EditTextPreference$SavedState;->text:Ljava/lang/String;

    invoke-virtual {p0, v1}, Landroid/preference/EditTextPreference;->setText(Ljava/lang/String;)V

    goto :goto_11
.end method

.method protected onSaveInstanceState()Landroid/os/Parcelable;
    .registers 4

    .prologue
    .line 180
    invoke-super {p0}, Landroid/preference/DialogPreference;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v1

    .line 181
    .local v1, superState:Landroid/os/Parcelable;
    invoke-virtual {p0}, Landroid/preference/EditTextPreference;->isPersistent()Z

    move-result v2

    if-eqz v2, :cond_b

    .line 188
    .end local v1           #superState:Landroid/os/Parcelable;
    :goto_a
    return-object v1

    .line 186
    .restart local v1       #superState:Landroid/os/Parcelable;
    :cond_b
    new-instance v0, Landroid/preference/EditTextPreference$SavedState;

    invoke-direct {v0, v1}, Landroid/preference/EditTextPreference$SavedState;-><init>(Landroid/os/Parcelable;)V

    .line 187
    .local v0, myState:Landroid/preference/EditTextPreference$SavedState;
    invoke-virtual {p0}, Landroid/preference/EditTextPreference;->getText()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Landroid/preference/EditTextPreference$SavedState;->text:Ljava/lang/String;

    move-object v1, v0

    .line 188
    goto :goto_a
.end method

.method protected onSetInitialValue(ZLjava/lang/Object;)V
    .registers 4
    .parameter "restoreValue"
    .parameter "defaultValue"

    .prologue
    .line 154
    if-eqz p1, :cond_c

    iget-object v0, p0, Landroid/preference/EditTextPreference;->mText:Ljava/lang/String;

    invoke-virtual {p0, v0}, Landroid/preference/EditTextPreference;->getPersistedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .end local p2
    :goto_8
    invoke-virtual {p0, p2}, Landroid/preference/EditTextPreference;->setText(Ljava/lang/String;)V

    .line 155
    return-void

    .line 154
    .restart local p2
    :cond_c
    check-cast p2, Ljava/lang/String;

    goto :goto_8
.end method

.method public setText(Ljava/lang/String;)V
    .registers 4
    .parameter "text"

    .prologue
    .line 84
    invoke-virtual {p0}, Landroid/preference/EditTextPreference;->shouldDisableDependents()Z

    move-result v1

    .line 86
    .local v1, wasBlocking:Z
    iput-object p1, p0, Landroid/preference/EditTextPreference;->mText:Ljava/lang/String;

    .line 88
    invoke-virtual {p0, p1}, Landroid/preference/EditTextPreference;->persistString(Ljava/lang/String;)Z

    .line 90
    invoke-virtual {p0}, Landroid/preference/EditTextPreference;->shouldDisableDependents()Z

    move-result v0

    .line 91
    .local v0, isBlocking:Z
    if-eq v0, v1, :cond_12

    .line 92
    invoke-virtual {p0, v0}, Landroid/preference/EditTextPreference;->notifyDependencyChange(Z)V

    .line 94
    :cond_12
    return-void
.end method

.method public shouldDisableDependents()Z
    .registers 2

    .prologue
    .line 159
    iget-object v0, p0, Landroid/preference/EditTextPreference;->mText:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_e

    invoke-super {p0}, Landroid/preference/DialogPreference;->shouldDisableDependents()Z

    move-result v0

    if-eqz v0, :cond_10

    :cond_e
    const/4 v0, 0x1

    :goto_f
    return v0

    :cond_10
    const/4 v0, 0x0

    goto :goto_f
.end method
