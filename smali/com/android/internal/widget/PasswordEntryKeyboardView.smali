.class public Lcom/android/internal/widget/PasswordEntryKeyboardView;
.super Landroid/inputmethodservice/KeyboardView;
.source "PasswordEntryKeyboardView.java"


# static fields
.field static final KEYCODE_F1:I = -0x67

.field static final KEYCODE_NEXT_LANGUAGE:I = -0x68

.field static final KEYCODE_OPTIONS:I = -0x64

.field static final KEYCODE_SHIFT_LONGPRESS:I = -0x65

.field static final KEYCODE_VOICE:I = -0x66


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 3
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Landroid/inputmethodservice/KeyboardView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 33
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 4
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyle"

    .prologue
    .line 36
    invoke-direct {p0, p1, p2, p3}, Landroid/inputmethodservice/KeyboardView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 37
    return-void
.end method


# virtual methods
.method public setShifted(Z)Z
    .registers 9
    .parameter "shifted"

    .prologue
    .line 41
    invoke-super {p0, p1}, Landroid/inputmethodservice/KeyboardView;->setShifted(Z)Z

    move-result v5

    .line 43
    .local v5, result:Z
    invoke-virtual {p0}, Lcom/android/internal/widget/PasswordEntryKeyboardView;->getKeyboard()Landroid/inputmethodservice/Keyboard;

    move-result-object v6

    invoke-virtual {v6}, Landroid/inputmethodservice/Keyboard;->getShiftKeyIndices()[I

    move-result-object v3

    .line 44
    .local v3, indices:[I
    move-object v0, v3

    .local v0, arr$:[I
    array-length v4, v0

    .local v4, len$:I
    const/4 v1, 0x0

    .local v1, i$:I
    :goto_f
    if-ge v1, v4, :cond_19

    aget v2, v0, v1

    .line 45
    .local v2, index:I
    invoke-virtual {p0, v2}, Lcom/android/internal/widget/PasswordEntryKeyboardView;->invalidateKey(I)V

    .line 44
    add-int/lit8 v1, v1, 0x1

    goto :goto_f

    .line 47
    .end local v2           #index:I
    :cond_19
    return v5
.end method
