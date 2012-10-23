.class public abstract Landroid/app/backup/IFullBackupRestoreObserver$Stub;
.super Landroid/os/Binder;
.source "IFullBackupRestoreObserver.java"

# interfaces
.implements Landroid/app/backup/IFullBackupRestoreObserver;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/backup/IFullBackupRestoreObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/app/backup/IFullBackupRestoreObserver$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.app.backup.IFullBackupRestoreObserver"

.field static final TRANSACTION_onBackupPackage:I = 0x2

.field static final TRANSACTION_onEndBackup:I = 0x3

.field static final TRANSACTION_onEndRestore:I = 0x6

.field static final TRANSACTION_onRestorePackage:I = 0x5

.field static final TRANSACTION_onStartBackup:I = 0x1

.field static final TRANSACTION_onStartRestore:I = 0x4

.field static final TRANSACTION_onTimeout:I = 0x7


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 20
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 21
    const-string v0, "android.app.backup.IFullBackupRestoreObserver"

    invoke-virtual {p0, p0, v0}, Landroid/app/backup/IFullBackupRestoreObserver$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 22
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/app/backup/IFullBackupRestoreObserver;
    .registers 3
    .parameter "obj"

    .prologue
    .line 29
    if-nez p0, :cond_4

    .line 30
    const/4 v0, 0x0

    .line 36
    :goto_3
    return-object v0

    .line 32
    :cond_4
    const-string v1, "android.app.backup.IFullBackupRestoreObserver"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 33
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/app/backup/IFullBackupRestoreObserver;

    if-eqz v1, :cond_13

    .line 34
    check-cast v0, Landroid/app/backup/IFullBackupRestoreObserver;

    goto :goto_3

    .line 36
    :cond_13
    new-instance v0, Landroid/app/backup/IFullBackupRestoreObserver$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/app/backup/IFullBackupRestoreObserver$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    .line 40
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 8
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
    const/4 v1, 0x1

    .line 44
    sparse-switch p1, :sswitch_data_56

    .line 98
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v1

    :goto_8
    return v1

    .line 48
    :sswitch_9
    const-string v2, "android.app.backup.IFullBackupRestoreObserver"

    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_8

    .line 53
    :sswitch_f
    const-string v2, "android.app.backup.IFullBackupRestoreObserver"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 54
    invoke-virtual {p0}, Landroid/app/backup/IFullBackupRestoreObserver$Stub;->onStartBackup()V

    goto :goto_8

    .line 59
    :sswitch_18
    const-string v2, "android.app.backup.IFullBackupRestoreObserver"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 61
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 62
    .local v0, _arg0:Ljava/lang/String;
    invoke-virtual {p0, v0}, Landroid/app/backup/IFullBackupRestoreObserver$Stub;->onBackupPackage(Ljava/lang/String;)V

    goto :goto_8

    .line 67
    .end local v0           #_arg0:Ljava/lang/String;
    :sswitch_25
    const-string v2, "android.app.backup.IFullBackupRestoreObserver"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 68
    invoke-virtual {p0}, Landroid/app/backup/IFullBackupRestoreObserver$Stub;->onEndBackup()V

    goto :goto_8

    .line 73
    :sswitch_2e
    const-string v2, "android.app.backup.IFullBackupRestoreObserver"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 74
    invoke-virtual {p0}, Landroid/app/backup/IFullBackupRestoreObserver$Stub;->onStartRestore()V

    goto :goto_8

    .line 79
    :sswitch_37
    const-string v2, "android.app.backup.IFullBackupRestoreObserver"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 81
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 82
    .restart local v0       #_arg0:Ljava/lang/String;
    invoke-virtual {p0, v0}, Landroid/app/backup/IFullBackupRestoreObserver$Stub;->onRestorePackage(Ljava/lang/String;)V

    goto :goto_8

    .line 87
    .end local v0           #_arg0:Ljava/lang/String;
    :sswitch_44
    const-string v2, "android.app.backup.IFullBackupRestoreObserver"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 88
    invoke-virtual {p0}, Landroid/app/backup/IFullBackupRestoreObserver$Stub;->onEndRestore()V

    goto :goto_8

    .line 93
    :sswitch_4d
    const-string v2, "android.app.backup.IFullBackupRestoreObserver"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 94
    invoke-virtual {p0}, Landroid/app/backup/IFullBackupRestoreObserver$Stub;->onTimeout()V

    goto :goto_8

    .line 44
    :sswitch_data_56
    .sparse-switch
        0x1 -> :sswitch_f
        0x2 -> :sswitch_18
        0x3 -> :sswitch_25
        0x4 -> :sswitch_2e
        0x5 -> :sswitch_37
        0x6 -> :sswitch_44
        0x7 -> :sswitch_4d
        0x5f4e5446 -> :sswitch_9
    .end sparse-switch
.end method
