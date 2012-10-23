.class public abstract Landroid/app/IBackupAgent$Stub;
.super Landroid/os/Binder;
.source "IBackupAgent.java"

# interfaces
.implements Landroid/app/IBackupAgent;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/IBackupAgent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/app/IBackupAgent$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.app.IBackupAgent"

.field static final TRANSACTION_doBackup:I = 0x1

.field static final TRANSACTION_doFullBackup:I = 0x3

.field static final TRANSACTION_doRestore:I = 0x2

.field static final TRANSACTION_doRestoreFile:I = 0x4


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 21
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 22
    const-string v0, "android.app.IBackupAgent"

    invoke-virtual {p0, p0, v0}, Landroid/app/IBackupAgent$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 23
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/app/IBackupAgent;
    .registers 3
    .parameter "obj"

    .prologue
    .line 30
    if-nez p0, :cond_4

    .line 31
    const/4 v0, 0x0

    .line 37
    :goto_3
    return-object v0

    .line 33
    :cond_4
    const-string v1, "android.app.IBackupAgent"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 34
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/app/IBackupAgent;

    if-eqz v1, :cond_13

    .line 35
    check-cast v0, Landroid/app/IBackupAgent;

    goto :goto_3

    .line 37
    :cond_13
    new-instance v0, Landroid/app/IBackupAgent$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/app/IBackupAgent$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    .line 41
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 25
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
    .line 45
    sparse-switch p1, :sswitch_data_11a

    .line 156
    invoke-super/range {p0 .. p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v1

    :goto_7
    return v1

    .line 49
    :sswitch_8
    const-string v1, "android.app.IBackupAgent"

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 50
    const/4 v1, 0x1

    goto :goto_7

    .line 54
    :sswitch_11
    const-string v1, "android.app.IBackupAgent"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 56
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_5b

    .line 57
    sget-object v1, Landroid/os/ParcelFileDescriptor;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/ParcelFileDescriptor;

    .line 63
    .local v2, _arg0:Landroid/os/ParcelFileDescriptor;
    :goto_28
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_5d

    .line 64
    sget-object v1, Landroid/os/ParcelFileDescriptor;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/os/ParcelFileDescriptor;

    .line 70
    .local v3, _arg1:Landroid/os/ParcelFileDescriptor;
    :goto_38
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_5f

    .line 71
    sget-object v1, Landroid/os/ParcelFileDescriptor;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/os/ParcelFileDescriptor;

    .line 77
    .local v4, _arg2:Landroid/os/ParcelFileDescriptor;
    :goto_48
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    .line 79
    .local v5, _arg3:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/app/backup/IBackupManager$Stub;->asInterface(Landroid/os/IBinder;)Landroid/app/backup/IBackupManager;

    move-result-object v6

    .local v6, _arg4:Landroid/app/backup/IBackupManager;
    move-object/from16 v1, p0

    .line 80
    invoke-virtual/range {v1 .. v6}, Landroid/app/IBackupAgent$Stub;->doBackup(Landroid/os/ParcelFileDescriptor;Landroid/os/ParcelFileDescriptor;Landroid/os/ParcelFileDescriptor;ILandroid/app/backup/IBackupManager;)V

    .line 81
    const/4 v1, 0x1

    goto :goto_7

    .line 60
    .end local v2           #_arg0:Landroid/os/ParcelFileDescriptor;
    .end local v3           #_arg1:Landroid/os/ParcelFileDescriptor;
    .end local v4           #_arg2:Landroid/os/ParcelFileDescriptor;
    .end local v5           #_arg3:I
    .end local v6           #_arg4:Landroid/app/backup/IBackupManager;
    :cond_5b
    const/4 v2, 0x0

    .restart local v2       #_arg0:Landroid/os/ParcelFileDescriptor;
    goto :goto_28

    .line 67
    :cond_5d
    const/4 v3, 0x0

    .restart local v3       #_arg1:Landroid/os/ParcelFileDescriptor;
    goto :goto_38

    .line 74
    :cond_5f
    const/4 v4, 0x0

    .restart local v4       #_arg2:Landroid/os/ParcelFileDescriptor;
    goto :goto_48

    .line 85
    .end local v2           #_arg0:Landroid/os/ParcelFileDescriptor;
    .end local v3           #_arg1:Landroid/os/ParcelFileDescriptor;
    .end local v4           #_arg2:Landroid/os/ParcelFileDescriptor;
    :sswitch_61
    const-string v1, "android.app.IBackupAgent"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 87
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_a0

    .line 88
    sget-object v1, Landroid/os/ParcelFileDescriptor;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/ParcelFileDescriptor;

    .line 94
    .restart local v2       #_arg0:Landroid/os/ParcelFileDescriptor;
    :goto_78
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 96
    .local v3, _arg1:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_a2

    .line 97
    sget-object v1, Landroid/os/ParcelFileDescriptor;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/os/ParcelFileDescriptor;

    .line 103
    .restart local v4       #_arg2:Landroid/os/ParcelFileDescriptor;
    :goto_8c
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    .line 105
    .restart local v5       #_arg3:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/app/backup/IBackupManager$Stub;->asInterface(Landroid/os/IBinder;)Landroid/app/backup/IBackupManager;

    move-result-object v6

    .restart local v6       #_arg4:Landroid/app/backup/IBackupManager;
    move-object/from16 v1, p0

    .line 106
    invoke-virtual/range {v1 .. v6}, Landroid/app/IBackupAgent$Stub;->doRestore(Landroid/os/ParcelFileDescriptor;ILandroid/os/ParcelFileDescriptor;ILandroid/app/backup/IBackupManager;)V

    .line 107
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 91
    .end local v2           #_arg0:Landroid/os/ParcelFileDescriptor;
    .end local v3           #_arg1:I
    .end local v4           #_arg2:Landroid/os/ParcelFileDescriptor;
    .end local v5           #_arg3:I
    .end local v6           #_arg4:Landroid/app/backup/IBackupManager;
    :cond_a0
    const/4 v2, 0x0

    .restart local v2       #_arg0:Landroid/os/ParcelFileDescriptor;
    goto :goto_78

    .line 100
    .restart local v3       #_arg1:I
    :cond_a2
    const/4 v4, 0x0

    .restart local v4       #_arg2:Landroid/os/ParcelFileDescriptor;
    goto :goto_8c

    .line 111
    .end local v2           #_arg0:Landroid/os/ParcelFileDescriptor;
    .end local v3           #_arg1:I
    .end local v4           #_arg2:Landroid/os/ParcelFileDescriptor;
    :sswitch_a4
    const-string v1, "android.app.IBackupAgent"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 113
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_cf

    .line 114
    sget-object v1, Landroid/os/ParcelFileDescriptor;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/ParcelFileDescriptor;

    .line 120
    .restart local v2       #_arg0:Landroid/os/ParcelFileDescriptor;
    :goto_bb
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 122
    .restart local v3       #_arg1:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/app/backup/IBackupManager$Stub;->asInterface(Landroid/os/IBinder;)Landroid/app/backup/IBackupManager;

    move-result-object v4

    .line 123
    .local v4, _arg2:Landroid/app/backup/IBackupManager;
    move-object/from16 v0, p0

    invoke-virtual {v0, v2, v3, v4}, Landroid/app/IBackupAgent$Stub;->doFullBackup(Landroid/os/ParcelFileDescriptor;ILandroid/app/backup/IBackupManager;)V

    .line 124
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 117
    .end local v2           #_arg0:Landroid/os/ParcelFileDescriptor;
    .end local v3           #_arg1:I
    .end local v4           #_arg2:Landroid/app/backup/IBackupManager;
    :cond_cf
    const/4 v2, 0x0

    .restart local v2       #_arg0:Landroid/os/ParcelFileDescriptor;
    goto :goto_bb

    .line 128
    .end local v2           #_arg0:Landroid/os/ParcelFileDescriptor;
    :sswitch_d1
    const-string v1, "android.app.IBackupAgent"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 130
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_118

    .line 131
    sget-object v1, Landroid/os/ParcelFileDescriptor;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/ParcelFileDescriptor;

    .line 137
    .restart local v2       #_arg0:Landroid/os/ParcelFileDescriptor;
    :goto_e8
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v9

    .line 139
    .local v9, _arg1:J
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    .line 141
    .local v4, _arg2:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    .line 143
    .local v5, _arg3:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v6

    .line 145
    .local v6, _arg4:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v14

    .line 147
    .local v14, _arg5:J
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v16

    .line 149
    .local v16, _arg6:J
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v18

    .line 151
    .local v18, _arg7:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/app/backup/IBackupManager$Stub;->asInterface(Landroid/os/IBinder;)Landroid/app/backup/IBackupManager;

    move-result-object v19

    .local v19, _arg8:Landroid/app/backup/IBackupManager;
    move-object/from16 v7, p0

    move-object v8, v2

    move v11, v4

    move-object v12, v5

    move-object v13, v6

    .line 152
    invoke-virtual/range {v7 .. v19}, Landroid/app/IBackupAgent$Stub;->doRestoreFile(Landroid/os/ParcelFileDescriptor;JILjava/lang/String;Ljava/lang/String;JJILandroid/app/backup/IBackupManager;)V

    .line 153
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 134
    .end local v2           #_arg0:Landroid/os/ParcelFileDescriptor;
    .end local v4           #_arg2:I
    .end local v5           #_arg3:Ljava/lang/String;
    .end local v6           #_arg4:Ljava/lang/String;
    .end local v9           #_arg1:J
    .end local v14           #_arg5:J
    .end local v16           #_arg6:J
    .end local v18           #_arg7:I
    .end local v19           #_arg8:Landroid/app/backup/IBackupManager;
    :cond_118
    const/4 v2, 0x0

    .restart local v2       #_arg0:Landroid/os/ParcelFileDescriptor;
    goto :goto_e8

    .line 45
    :sswitch_data_11a
    .sparse-switch
        0x1 -> :sswitch_11
        0x2 -> :sswitch_61
        0x3 -> :sswitch_a4
        0x4 -> :sswitch_d1
        0x5f4e5446 -> :sswitch_8
    .end sparse-switch
.end method
