.class public abstract Lcom/android/internal/textservice/ISpellCheckerService$Stub;
.super Landroid/os/Binder;
.source "ISpellCheckerService.java"

# interfaces
.implements Lcom/android/internal/textservice/ISpellCheckerService;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/textservice/ISpellCheckerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/textservice/ISpellCheckerService$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "com.android.internal.textservice.ISpellCheckerService"

.field static final TRANSACTION_getISpellCheckerSession:I = 0x1


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 18
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 19
    const-string v0, "com.android.internal.textservice.ISpellCheckerService"

    invoke-virtual {p0, p0, v0}, Lcom/android/internal/textservice/ISpellCheckerService$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 20
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/android/internal/textservice/ISpellCheckerService;
    .registers 3
    .parameter "obj"

    .prologue
    .line 27
    if-nez p0, :cond_4

    .line 28
    const/4 v0, 0x0

    .line 34
    :goto_3
    return-object v0

    .line 30
    :cond_4
    const-string v1, "com.android.internal.textservice.ISpellCheckerService"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 31
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Lcom/android/internal/textservice/ISpellCheckerService;

    if-eqz v1, :cond_13

    .line 32
    check-cast v0, Lcom/android/internal/textservice/ISpellCheckerService;

    goto :goto_3

    .line 34
    :cond_13
    new-instance v0, Lcom/android/internal/textservice/ISpellCheckerService$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/android/internal/textservice/ISpellCheckerService$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    .line 38
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
    const/4 v5, 0x1

    .line 42
    sparse-switch p1, :sswitch_data_46

    .line 69
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v4

    :goto_8
    return v4

    .line 46
    :sswitch_9
    const-string v4, "com.android.internal.textservice.ISpellCheckerService"

    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    move v4, v5

    .line 47
    goto :goto_8

    .line 51
    :sswitch_10
    const-string v4, "com.android.internal.textservice.ISpellCheckerService"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 53
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 55
    .local v0, _arg0:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lcom/android/internal/textservice/ISpellCheckerSessionListener$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/textservice/ISpellCheckerSessionListener;

    move-result-object v1

    .line 57
    .local v1, _arg1:Lcom/android/internal/textservice/ISpellCheckerSessionListener;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_41

    .line 58
    sget-object v4, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v4, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Bundle;

    .line 63
    .local v2, _arg2:Landroid/os/Bundle;
    :goto_2f
    invoke-virtual {p0, v0, v1, v2}, Lcom/android/internal/textservice/ISpellCheckerService$Stub;->getISpellCheckerSession(Ljava/lang/String;Lcom/android/internal/textservice/ISpellCheckerSessionListener;Landroid/os/Bundle;)Lcom/android/internal/textservice/ISpellCheckerSession;

    move-result-object v3

    .line 64
    .local v3, _result:Lcom/android/internal/textservice/ISpellCheckerSession;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 65
    if-eqz v3, :cond_43

    invoke-interface {v3}, Lcom/android/internal/textservice/ISpellCheckerSession;->asBinder()Landroid/os/IBinder;

    move-result-object v4

    :goto_3c
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    move v4, v5

    .line 66
    goto :goto_8

    .line 61
    .end local v2           #_arg2:Landroid/os/Bundle;
    .end local v3           #_result:Lcom/android/internal/textservice/ISpellCheckerSession;
    :cond_41
    const/4 v2, 0x0

    .restart local v2       #_arg2:Landroid/os/Bundle;
    goto :goto_2f

    .line 65
    .restart local v3       #_result:Lcom/android/internal/textservice/ISpellCheckerSession;
    :cond_43
    const/4 v4, 0x0

    goto :goto_3c

    .line 42
    nop

    :sswitch_data_46
    .sparse-switch
        0x1 -> :sswitch_10
        0x5f4e5446 -> :sswitch_9
    .end sparse-switch
.end method
