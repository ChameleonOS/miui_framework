.class Landroid/view/inputmethod/InputMethodManager$ControlledInputConnectionWrapper;
.super Lcom/android/internal/view/IInputConnectionWrapper;
.source "InputMethodManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/inputmethod/InputMethodManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ControlledInputConnectionWrapper"
.end annotation


# instance fields
.field private mActive:Z

.field private final mParentInputMethodManager:Landroid/view/inputmethod/InputMethodManager;


# direct methods
.method public constructor <init>(Landroid/os/Looper;Landroid/view/inputmethod/InputConnection;Landroid/view/inputmethod/InputMethodManager;)V
    .registers 5
    .parameter "mainLooper"
    .parameter "conn"
    .parameter "inputMethodManager"

    .prologue
    invoke-direct {p0, p1, p2}, Lcom/android/internal/view/IInputConnectionWrapper;-><init>(Landroid/os/Looper;Landroid/view/inputmethod/InputConnection;)V

    iput-object p3, p0, Landroid/view/inputmethod/InputMethodManager$ControlledInputConnectionWrapper;->mParentInputMethodManager:Landroid/view/inputmethod/InputMethodManager;

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/inputmethod/InputMethodManager$ControlledInputConnectionWrapper;->mActive:Z

    return-void
.end method


# virtual methods
.method deactivate()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/view/inputmethod/InputMethodManager$ControlledInputConnectionWrapper;->mActive:Z

    return-void
.end method

.method public isActive()Z
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/view/inputmethod/InputMethodManager$ControlledInputConnectionWrapper;->mParentInputMethodManager:Landroid/view/inputmethod/InputMethodManager;

    iget-boolean v0, v0, Landroid/view/inputmethod/InputMethodManager;->mActive:Z

    if-eqz v0, :cond_c

    iget-boolean v0, p0, Landroid/view/inputmethod/InputMethodManager$ControlledInputConnectionWrapper;->mActive:Z

    if-eqz v0, :cond_c

    const/4 v0, 0x1

    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method
