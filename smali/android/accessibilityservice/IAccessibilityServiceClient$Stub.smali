.class public abstract Landroid/accessibilityservice/IAccessibilityServiceClient$Stub;
.super Landroid/os/Binder;
.source "IAccessibilityServiceClient.java"

# interfaces
.implements Landroid/accessibilityservice/IAccessibilityServiceClient;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/accessibilityservice/IAccessibilityServiceClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/accessibilityservice/IAccessibilityServiceClient$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.accessibilityservice.IAccessibilityServiceClient"

.field static final TRANSACTION_onAccessibilityEvent:I = 0x2

.field static final TRANSACTION_onGesture:I = 0x4

.field static final TRANSACTION_onInterrupt:I = 0x3

.field static final TRANSACTION_setConnection:I = 0x1


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 20
    const-string v0, "android.accessibilityservice.IAccessibilityServiceClient"

    invoke-virtual {p0, p0, v0}, Landroid/accessibilityservice/IAccessibilityServiceClient$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 21
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/accessibilityservice/IAccessibilityServiceClient;
    .registers 3
    .parameter "obj"

    .prologue
    .line 28
    if-nez p0, :cond_4

    .line 29
    const/4 v0, 0x0

    .line 35
    :goto_3
    return-object v0

    .line 31
    :cond_4
    const-string v1, "android.accessibilityservice.IAccessibilityServiceClient"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 32
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/accessibilityservice/IAccessibilityServiceClient;

    if-eqz v1, :cond_13

    .line 33
    check-cast v0, Landroid/accessibilityservice/IAccessibilityServiceClient;

    goto :goto_3

    .line 35
    :cond_13
    new-instance v0, Landroid/accessibilityservice/IAccessibilityServiceClient$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/accessibilityservice/IAccessibilityServiceClient$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    .line 39
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

    .line 43
    sparse-switch p1, :sswitch_data_54

    .line 88
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v2

    :goto_8
    return v2

    .line 47
    :sswitch_9
    const-string v3, "android.accessibilityservice.IAccessibilityServiceClient"

    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_8

    .line 52
    :sswitch_f
    const-string v3, "android.accessibilityservice.IAccessibilityServiceClient"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 54
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v3

    invoke-static {v3}, Landroid/accessibilityservice/IAccessibilityServiceConnection$Stub;->asInterface(Landroid/os/IBinder;)Landroid/accessibilityservice/IAccessibilityServiceConnection;

    move-result-object v0

    .line 56
    .local v0, _arg0:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 57
    .local v1, _arg1:I
    invoke-virtual {p0, v0, v1}, Landroid/accessibilityservice/IAccessibilityServiceClient$Stub;->setConnection(Landroid/accessibilityservice/IAccessibilityServiceConnection;I)V

    goto :goto_8

    .line 62
    .end local v0           #_arg0:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    .end local v1           #_arg1:I
    :sswitch_24
    const-string v3, "android.accessibilityservice.IAccessibilityServiceClient"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 64
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    if-eqz v3, :cond_3b

    .line 65
    sget-object v3, Landroid/view/accessibility/AccessibilityEvent;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v3, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/accessibility/AccessibilityEvent;

    .line 70
    .local v0, _arg0:Landroid/view/accessibility/AccessibilityEvent;
    :goto_37
    invoke-virtual {p0, v0}, Landroid/accessibilityservice/IAccessibilityServiceClient$Stub;->onAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    goto :goto_8

    .line 68
    .end local v0           #_arg0:Landroid/view/accessibility/AccessibilityEvent;
    :cond_3b
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/view/accessibility/AccessibilityEvent;
    goto :goto_37

    .line 75
    .end local v0           #_arg0:Landroid/view/accessibility/AccessibilityEvent;
    :sswitch_3d
    const-string v3, "android.accessibilityservice.IAccessibilityServiceClient"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 76
    invoke-virtual {p0}, Landroid/accessibilityservice/IAccessibilityServiceClient$Stub;->onInterrupt()V

    goto :goto_8

    .line 81
    :sswitch_46
    const-string v3, "android.accessibilityservice.IAccessibilityServiceClient"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 83
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 84
    .local v0, _arg0:I
    invoke-virtual {p0, v0}, Landroid/accessibilityservice/IAccessibilityServiceClient$Stub;->onGesture(I)V

    goto :goto_8

    .line 43
    nop

    :sswitch_data_54
    .sparse-switch
        0x1 -> :sswitch_f
        0x2 -> :sswitch_24
        0x3 -> :sswitch_3d
        0x4 -> :sswitch_46
        0x5f4e5446 -> :sswitch_9
    .end sparse-switch
.end method
