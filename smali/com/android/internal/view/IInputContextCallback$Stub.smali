.class public abstract Lcom/android/internal/view/IInputContextCallback$Stub;
.super Landroid/os/Binder;
.source "IInputContextCallback.java"

# interfaces
.implements Lcom/android/internal/view/IInputContextCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/view/IInputContextCallback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/view/IInputContextCallback$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "com.android.internal.view.IInputContextCallback"

.field static final TRANSACTION_setCursorCapsMode:I = 0x3

.field static final TRANSACTION_setExtractedText:I = 0x4

.field static final TRANSACTION_setSelectedText:I = 0x5

.field static final TRANSACTION_setTextAfterCursor:I = 0x2

.field static final TRANSACTION_setTextBeforeCursor:I = 0x1


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 18
    const-string v0, "com.android.internal.view.IInputContextCallback"

    invoke-virtual {p0, p0, v0}, Lcom/android/internal/view/IInputContextCallback$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 19
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/android/internal/view/IInputContextCallback;
    .registers 3
    .parameter "obj"

    .prologue
    .line 26
    if-nez p0, :cond_4

    .line 27
    const/4 v0, 0x0

    .line 33
    :goto_3
    return-object v0

    .line 29
    :cond_4
    const-string v1, "com.android.internal.view.IInputContextCallback"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 30
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Lcom/android/internal/view/IInputContextCallback;

    if-eqz v1, :cond_13

    .line 31
    check-cast v0, Lcom/android/internal/view/IInputContextCallback;

    goto :goto_3

    .line 33
    :cond_13
    new-instance v0, Lcom/android/internal/view/IInputContextCallback$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/android/internal/view/IInputContextCallback$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    .line 37
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 9
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
    const/4 v2, 0x1

    .line 41
    sparse-switch p1, :sswitch_data_96

    .line 119
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v2

    :goto_8
    return v2

    .line 45
    :sswitch_9
    const-string v3, "com.android.internal.view.IInputContextCallback"

    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_8

    .line 50
    :sswitch_f
    const-string v3, "com.android.internal.view.IInputContextCallback"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 52
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    if-eqz v3, :cond_2a

    .line 53
    sget-object v3, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v3, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    .line 59
    .local v0, _arg0:Ljava/lang/CharSequence;
    :goto_22
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 60
    .local v1, _arg1:I
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/view/IInputContextCallback$Stub;->setTextBeforeCursor(Ljava/lang/CharSequence;I)V

    goto :goto_8

    .line 56
    .end local v0           #_arg0:Ljava/lang/CharSequence;
    .end local v1           #_arg1:I
    :cond_2a
    const/4 v0, 0x0

    .restart local v0       #_arg0:Ljava/lang/CharSequence;
    goto :goto_22

    .line 65
    .end local v0           #_arg0:Ljava/lang/CharSequence;
    :sswitch_2c
    const-string v3, "com.android.internal.view.IInputContextCallback"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 67
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    if-eqz v3, :cond_47

    .line 68
    sget-object v3, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v3, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    .line 74
    .restart local v0       #_arg0:Ljava/lang/CharSequence;
    :goto_3f
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 75
    .restart local v1       #_arg1:I
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/view/IInputContextCallback$Stub;->setTextAfterCursor(Ljava/lang/CharSequence;I)V

    goto :goto_8

    .line 71
    .end local v0           #_arg0:Ljava/lang/CharSequence;
    .end local v1           #_arg1:I
    :cond_47
    const/4 v0, 0x0

    .restart local v0       #_arg0:Ljava/lang/CharSequence;
    goto :goto_3f

    .line 80
    .end local v0           #_arg0:Ljava/lang/CharSequence;
    :sswitch_49
    const-string v3, "com.android.internal.view.IInputContextCallback"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 82
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 84
    .local v0, _arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 85
    .restart local v1       #_arg1:I
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/view/IInputContextCallback$Stub;->setCursorCapsMode(II)V

    goto :goto_8

    .line 90
    .end local v0           #_arg0:I
    .end local v1           #_arg1:I
    :sswitch_5a
    const-string v3, "com.android.internal.view.IInputContextCallback"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 92
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    if-eqz v3, :cond_75

    .line 93
    sget-object v3, Landroid/view/inputmethod/ExtractedText;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v3, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/ExtractedText;

    .line 99
    .local v0, _arg0:Landroid/view/inputmethod/ExtractedText;
    :goto_6d
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 100
    .restart local v1       #_arg1:I
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/view/IInputContextCallback$Stub;->setExtractedText(Landroid/view/inputmethod/ExtractedText;I)V

    goto :goto_8

    .line 96
    .end local v0           #_arg0:Landroid/view/inputmethod/ExtractedText;
    .end local v1           #_arg1:I
    :cond_75
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/view/inputmethod/ExtractedText;
    goto :goto_6d

    .line 105
    .end local v0           #_arg0:Landroid/view/inputmethod/ExtractedText;
    :sswitch_77
    const-string v3, "com.android.internal.view.IInputContextCallback"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 107
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    if-eqz v3, :cond_93

    .line 108
    sget-object v3, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v3, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    .line 114
    .local v0, _arg0:Ljava/lang/CharSequence;
    :goto_8a
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 115
    .restart local v1       #_arg1:I
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/view/IInputContextCallback$Stub;->setSelectedText(Ljava/lang/CharSequence;I)V

    goto/16 :goto_8

    .line 111
    .end local v0           #_arg0:Ljava/lang/CharSequence;
    .end local v1           #_arg1:I
    :cond_93
    const/4 v0, 0x0

    .restart local v0       #_arg0:Ljava/lang/CharSequence;
    goto :goto_8a

    .line 41
    nop

    :sswitch_data_96
    .sparse-switch
        0x1 -> :sswitch_f
        0x2 -> :sswitch_2c
        0x3 -> :sswitch_49
        0x4 -> :sswitch_5a
        0x5 -> :sswitch_77
        0x5f4e5446 -> :sswitch_9
    .end sparse-switch
.end method
