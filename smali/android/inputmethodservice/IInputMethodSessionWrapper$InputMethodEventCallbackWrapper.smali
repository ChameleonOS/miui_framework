.class Landroid/inputmethodservice/IInputMethodSessionWrapper$InputMethodEventCallbackWrapper;
.super Ljava/lang/Object;
.source "IInputMethodSessionWrapper.java"

# interfaces
.implements Landroid/view/inputmethod/InputMethodSession$EventCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/inputmethodservice/IInputMethodSessionWrapper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "InputMethodEventCallbackWrapper"
.end annotation


# instance fields
.field final mCb:Lcom/android/internal/view/IInputMethodCallback;


# direct methods
.method constructor <init>(Lcom/android/internal/view/IInputMethodCallback;)V
    .registers 2
    .parameter "cb"

    .prologue
    .line 58
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 59
    iput-object p1, p0, Landroid/inputmethodservice/IInputMethodSessionWrapper$InputMethodEventCallbackWrapper;->mCb:Lcom/android/internal/view/IInputMethodCallback;

    .line 60
    return-void
.end method


# virtual methods
.method public finishedEvent(IZ)V
    .registers 4
    .parameter "seq"
    .parameter "handled"

    .prologue
    .line 63
    :try_start_0
    iget-object v0, p0, Landroid/inputmethodservice/IInputMethodSessionWrapper$InputMethodEventCallbackWrapper;->mCb:Lcom/android/internal/view/IInputMethodCallback;

    invoke-interface {v0, p1, p2}, Lcom/android/internal/view/IInputMethodCallback;->finishedEvent(IZ)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 66
    :goto_5
    return-void

    .line 64
    :catch_6
    move-exception v0

    goto :goto_5
.end method
