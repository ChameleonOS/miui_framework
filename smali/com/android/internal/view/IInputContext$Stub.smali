.class public abstract Lcom/android/internal/view/IInputContext$Stub;
.super Landroid/os/Binder;
.source "IInputContext.java"

# interfaces
.implements Lcom/android/internal/view/IInputContext;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/view/IInputContext;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/view/IInputContext$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "com.android.internal.view.IInputContext"

.field static final TRANSACTION_beginBatchEdit:I = 0xe

.field static final TRANSACTION_clearMetaKeyStates:I = 0x12

.field static final TRANSACTION_commitCompletion:I = 0x9

.field static final TRANSACTION_commitCorrection:I = 0xa

.field static final TRANSACTION_commitText:I = 0x8

.field static final TRANSACTION_deleteSurroundingText:I = 0x5

.field static final TRANSACTION_endBatchEdit:I = 0xf

.field static final TRANSACTION_finishComposingText:I = 0x7

.field static final TRANSACTION_getCursorCapsMode:I = 0x3

.field static final TRANSACTION_getExtractedText:I = 0x4

.field static final TRANSACTION_getSelectedText:I = 0x15

.field static final TRANSACTION_getTextAfterCursor:I = 0x2

.field static final TRANSACTION_getTextBeforeCursor:I = 0x1

.field static final TRANSACTION_performContextMenuAction:I = 0xd

.field static final TRANSACTION_performEditorAction:I = 0xc

.field static final TRANSACTION_performPrivateCommand:I = 0x13

.field static final TRANSACTION_reportFullscreenMode:I = 0x10

.field static final TRANSACTION_sendKeyEvent:I = 0x11

.field static final TRANSACTION_setComposingRegion:I = 0x14

.field static final TRANSACTION_setComposingText:I = 0x6

.field static final TRANSACTION_setSelection:I = 0xb


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    const-string v0, "com.android.internal.view.IInputContext"

    invoke-virtual {p0, p0, v0}, Lcom/android/internal/view/IInputContext$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/android/internal/view/IInputContext;
    .registers 3
    .parameter "obj"

    .prologue
    if-nez p0, :cond_4

    const/4 v0, 0x0

    :goto_3
    return-object v0

    :cond_4
    const-string v1, "com.android.internal.view.IInputContext"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Lcom/android/internal/view/IInputContext;

    if-eqz v1, :cond_13

    check-cast v0, Lcom/android/internal/view/IInputContext;

    goto :goto_3

    :cond_13
    new-instance v0, Lcom/android/internal/view/IInputContext$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/android/internal/view/IInputContext$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 11
    .parameter "code"
    .parameter "data"
    .parameter "reply"
    .parameter "flags"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    sparse-switch p1, :sswitch_data_1de

    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v4

    :goto_8
    return v4

    :sswitch_9
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p3, v5}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_8

    :sswitch_f
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .local v0, _arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .local v1, _arg1:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .local v2, _arg2:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v5

    invoke-static {v5}, Lcom/android/internal/view/IInputContextCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/view/IInputContextCallback;

    move-result-object v3

    .local v3, _arg3:Lcom/android/internal/view/IInputContextCallback;
    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/android/internal/view/IInputContext$Stub;->getTextBeforeCursor(IIILcom/android/internal/view/IInputContextCallback;)V

    goto :goto_8

    .end local v0           #_arg0:I
    .end local v1           #_arg1:I
    .end local v2           #_arg2:I
    .end local v3           #_arg3:Lcom/android/internal/view/IInputContextCallback;
    :sswitch_2c
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .restart local v0       #_arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .restart local v1       #_arg1:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .restart local v2       #_arg2:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v5

    invoke-static {v5}, Lcom/android/internal/view/IInputContextCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/view/IInputContextCallback;

    move-result-object v3

    .restart local v3       #_arg3:Lcom/android/internal/view/IInputContextCallback;
    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/android/internal/view/IInputContext$Stub;->getTextAfterCursor(IIILcom/android/internal/view/IInputContextCallback;)V

    goto :goto_8

    .end local v0           #_arg0:I
    .end local v1           #_arg1:I
    .end local v2           #_arg2:I
    .end local v3           #_arg3:Lcom/android/internal/view/IInputContextCallback;
    :sswitch_49
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .restart local v0       #_arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .restart local v1       #_arg1:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v5

    invoke-static {v5}, Lcom/android/internal/view/IInputContextCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/view/IInputContextCallback;

    move-result-object v2

    .local v2, _arg2:Lcom/android/internal/view/IInputContextCallback;
    invoke-virtual {p0, v0, v1, v2}, Lcom/android/internal/view/IInputContext$Stub;->getCursorCapsMode(IILcom/android/internal/view/IInputContextCallback;)V

    goto :goto_8

    .end local v0           #_arg0:I
    .end local v1           #_arg1:I
    .end local v2           #_arg2:Lcom/android/internal/view/IInputContextCallback;
    :sswitch_62
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_89

    sget-object v5, Landroid/view/inputmethod/ExtractedTextRequest;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/ExtractedTextRequest;

    .local v0, _arg0:Landroid/view/inputmethod/ExtractedTextRequest;
    :goto_75
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .restart local v1       #_arg1:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .local v2, _arg2:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v5

    invoke-static {v5}, Lcom/android/internal/view/IInputContextCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/view/IInputContextCallback;

    move-result-object v3

    .restart local v3       #_arg3:Lcom/android/internal/view/IInputContextCallback;
    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/android/internal/view/IInputContext$Stub;->getExtractedText(Landroid/view/inputmethod/ExtractedTextRequest;IILcom/android/internal/view/IInputContextCallback;)V

    goto :goto_8

    .end local v0           #_arg0:Landroid/view/inputmethod/ExtractedTextRequest;
    .end local v1           #_arg1:I
    .end local v2           #_arg2:I
    .end local v3           #_arg3:Lcom/android/internal/view/IInputContextCallback;
    :cond_89
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/view/inputmethod/ExtractedTextRequest;
    goto :goto_75

    .end local v0           #_arg0:Landroid/view/inputmethod/ExtractedTextRequest;
    :sswitch_8b
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .local v0, _arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .restart local v1       #_arg1:I
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/view/IInputContext$Stub;->deleteSurroundingText(II)V

    goto/16 :goto_8

    .end local v0           #_arg0:I
    .end local v1           #_arg1:I
    :sswitch_9d
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_b9

    sget-object v5, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    .local v0, _arg0:Ljava/lang/CharSequence;
    :goto_b0
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .restart local v1       #_arg1:I
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/view/IInputContext$Stub;->setComposingText(Ljava/lang/CharSequence;I)V

    goto/16 :goto_8

    .end local v0           #_arg0:Ljava/lang/CharSequence;
    .end local v1           #_arg1:I
    :cond_b9
    const/4 v0, 0x0

    .restart local v0       #_arg0:Ljava/lang/CharSequence;
    goto :goto_b0

    .end local v0           #_arg0:Ljava/lang/CharSequence;
    :sswitch_bb
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/android/internal/view/IInputContext$Stub;->finishComposingText()V

    goto/16 :goto_8

    :sswitch_c5
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_e1

    sget-object v5, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    .restart local v0       #_arg0:Ljava/lang/CharSequence;
    :goto_d8
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .restart local v1       #_arg1:I
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/view/IInputContext$Stub;->commitText(Ljava/lang/CharSequence;I)V

    goto/16 :goto_8

    .end local v0           #_arg0:Ljava/lang/CharSequence;
    .end local v1           #_arg1:I
    :cond_e1
    const/4 v0, 0x0

    .restart local v0       #_arg0:Ljava/lang/CharSequence;
    goto :goto_d8

    .end local v0           #_arg0:Ljava/lang/CharSequence;
    :sswitch_e3
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_fb

    sget-object v5, Landroid/view/inputmethod/CompletionInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/CompletionInfo;

    .local v0, _arg0:Landroid/view/inputmethod/CompletionInfo;
    :goto_f6
    invoke-virtual {p0, v0}, Lcom/android/internal/view/IInputContext$Stub;->commitCompletion(Landroid/view/inputmethod/CompletionInfo;)V

    goto/16 :goto_8

    .end local v0           #_arg0:Landroid/view/inputmethod/CompletionInfo;
    :cond_fb
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/view/inputmethod/CompletionInfo;
    goto :goto_f6

    .end local v0           #_arg0:Landroid/view/inputmethod/CompletionInfo;
    :sswitch_fd
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_115

    sget-object v5, Landroid/view/inputmethod/CorrectionInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/CorrectionInfo;

    .local v0, _arg0:Landroid/view/inputmethod/CorrectionInfo;
    :goto_110
    invoke-virtual {p0, v0}, Lcom/android/internal/view/IInputContext$Stub;->commitCorrection(Landroid/view/inputmethod/CorrectionInfo;)V

    goto/16 :goto_8

    .end local v0           #_arg0:Landroid/view/inputmethod/CorrectionInfo;
    :cond_115
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/view/inputmethod/CorrectionInfo;
    goto :goto_110

    .end local v0           #_arg0:Landroid/view/inputmethod/CorrectionInfo;
    :sswitch_117
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .local v0, _arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .restart local v1       #_arg1:I
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/view/IInputContext$Stub;->setSelection(II)V

    goto/16 :goto_8

    .end local v0           #_arg0:I
    .end local v1           #_arg1:I
    :sswitch_129
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .restart local v0       #_arg0:I
    invoke-virtual {p0, v0}, Lcom/android/internal/view/IInputContext$Stub;->performEditorAction(I)V

    goto/16 :goto_8

    .end local v0           #_arg0:I
    :sswitch_137
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .restart local v0       #_arg0:I
    invoke-virtual {p0, v0}, Lcom/android/internal/view/IInputContext$Stub;->performContextMenuAction(I)V

    goto/16 :goto_8

    .end local v0           #_arg0:I
    :sswitch_145
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/android/internal/view/IInputContext$Stub;->beginBatchEdit()V

    goto/16 :goto_8

    :sswitch_14f
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/android/internal/view/IInputContext$Stub;->endBatchEdit()V

    goto/16 :goto_8

    :sswitch_159
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_16a

    move v0, v4

    .local v0, _arg0:Z
    :goto_165
    invoke-virtual {p0, v0}, Lcom/android/internal/view/IInputContext$Stub;->reportFullscreenMode(Z)V

    goto/16 :goto_8

    .end local v0           #_arg0:Z
    :cond_16a
    const/4 v0, 0x0

    goto :goto_165

    :sswitch_16c
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_184

    sget-object v5, Landroid/view/KeyEvent;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/KeyEvent;

    .local v0, _arg0:Landroid/view/KeyEvent;
    :goto_17f
    invoke-virtual {p0, v0}, Lcom/android/internal/view/IInputContext$Stub;->sendKeyEvent(Landroid/view/KeyEvent;)V

    goto/16 :goto_8

    .end local v0           #_arg0:Landroid/view/KeyEvent;
    :cond_184
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/view/KeyEvent;
    goto :goto_17f

    .end local v0           #_arg0:Landroid/view/KeyEvent;
    :sswitch_186
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .local v0, _arg0:I
    invoke-virtual {p0, v0}, Lcom/android/internal/view/IInputContext$Stub;->clearMetaKeyStates(I)V

    goto/16 :goto_8

    .end local v0           #_arg0:I
    :sswitch_194
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .local v0, _arg0:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_1b0

    sget-object v5, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Bundle;

    .local v1, _arg1:Landroid/os/Bundle;
    :goto_1ab
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/view/IInputContext$Stub;->performPrivateCommand(Ljava/lang/String;Landroid/os/Bundle;)V

    goto/16 :goto_8

    .end local v1           #_arg1:Landroid/os/Bundle;
    :cond_1b0
    const/4 v1, 0x0

    .restart local v1       #_arg1:Landroid/os/Bundle;
    goto :goto_1ab

    .end local v0           #_arg0:Ljava/lang/String;
    .end local v1           #_arg1:Landroid/os/Bundle;
    :sswitch_1b2
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .local v0, _arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .local v1, _arg1:I
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/view/IInputContext$Stub;->setComposingRegion(II)V

    goto/16 :goto_8

    .end local v0           #_arg0:I
    .end local v1           #_arg1:I
    :sswitch_1c4
    const-string v5, "com.android.internal.view.IInputContext"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .restart local v0       #_arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .restart local v1       #_arg1:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v5

    invoke-static {v5}, Lcom/android/internal/view/IInputContextCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/view/IInputContextCallback;

    move-result-object v2

    .local v2, _arg2:Lcom/android/internal/view/IInputContextCallback;
    invoke-virtual {p0, v0, v1, v2}, Lcom/android/internal/view/IInputContext$Stub;->getSelectedText(IILcom/android/internal/view/IInputContextCallback;)V

    goto/16 :goto_8

    :sswitch_data_1de
    .sparse-switch
        0x1 -> :sswitch_f
        0x2 -> :sswitch_2c
        0x3 -> :sswitch_49
        0x4 -> :sswitch_62
        0x5 -> :sswitch_8b
        0x6 -> :sswitch_9d
        0x7 -> :sswitch_bb
        0x8 -> :sswitch_c5
        0x9 -> :sswitch_e3
        0xa -> :sswitch_fd
        0xb -> :sswitch_117
        0xc -> :sswitch_129
        0xd -> :sswitch_137
        0xe -> :sswitch_145
        0xf -> :sswitch_14f
        0x10 -> :sswitch_159
        0x11 -> :sswitch_16c
        0x12 -> :sswitch_186
        0x13 -> :sswitch_194
        0x14 -> :sswitch_1b2
        0x15 -> :sswitch_1c4
        0x5f4e5446 -> :sswitch_9
    .end sparse-switch
.end method
