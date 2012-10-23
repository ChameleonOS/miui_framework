.class public abstract Landroid/view/IWindowSession$Stub;
.super Landroid/os/Binder;
.source "IWindowSession.java"

# interfaces
.implements Landroid/view/IWindowSession;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/IWindowSession;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/IWindowSession$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.view.IWindowSession"

.field static final TRANSACTION_add:I = 0x1

.field static final TRANSACTION_addWithoutInputChannel:I = 0x2

.field static final TRANSACTION_dragRecipientEntered:I = 0x11

.field static final TRANSACTION_dragRecipientExited:I = 0x12

.field static final TRANSACTION_finishDrawing:I = 0xa

.field static final TRANSACTION_getDisplayFrame:I = 0x9

.field static final TRANSACTION_getInTouchMode:I = 0xc

.field static final TRANSACTION_outOfMemory:I = 0x6

.field static final TRANSACTION_performDeferredDestroy:I = 0x5

.field static final TRANSACTION_performDrag:I = 0xf

.field static final TRANSACTION_performHapticFeedback:I = 0xd

.field static final TRANSACTION_prepareDrag:I = 0xe

.field static final TRANSACTION_relayout:I = 0x4

.field static final TRANSACTION_remove:I = 0x3

.field static final TRANSACTION_reportDropResult:I = 0x10

.field static final TRANSACTION_sendWallpaperCommand:I = 0x15

.field static final TRANSACTION_setInTouchMode:I = 0xb

.field static final TRANSACTION_setInsets:I = 0x8

.field static final TRANSACTION_setTransparentRegion:I = 0x7

.field static final TRANSACTION_setWallpaperPosition:I = 0x13

.field static final TRANSACTION_wallpaperCommandComplete:I = 0x16

.field static final TRANSACTION_wallpaperOffsetsComplete:I = 0x14


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 20
    const-string v0, "android.view.IWindowSession"

    invoke-virtual {p0, p0, v0}, Landroid/view/IWindowSession$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 21
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/view/IWindowSession;
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
    const-string v1, "android.view.IWindowSession"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 32
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/view/IWindowSession;

    if-eqz v1, :cond_13

    .line 33
    check-cast v0, Landroid/view/IWindowSession;

    goto :goto_3

    .line 35
    :cond_13
    new-instance v0, Landroid/view/IWindowSession$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/view/IWindowSession$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

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
    .registers 20
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
    .line 43
    sparse-switch p1, :sswitch_data_4aa

    .line 482
    invoke-super/range {p0 .. p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v1

    :goto_7
    return v1

    .line 47
    :sswitch_8
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 48
    const/4 v1, 0x1

    goto :goto_7

    .line 52
    :sswitch_11
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 54
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 56
    .local v2, _arg0:Landroid/view/IWindow;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 58
    .local v3, _arg1:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_6d

    .line 59
    sget-object v1, Landroid/view/WindowManager$LayoutParams;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/WindowManager$LayoutParams;

    .line 65
    .local v4, _arg2:Landroid/view/WindowManager$LayoutParams;
    :goto_34
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    .line 67
    .local v5, _arg3:I
    new-instance v6, Landroid/graphics/Rect;

    invoke-direct {v6}, Landroid/graphics/Rect;-><init>()V

    .line 69
    .local v6, _arg4:Landroid/graphics/Rect;
    new-instance v7, Landroid/view/InputChannel;

    invoke-direct {v7}, Landroid/view/InputChannel;-><init>()V

    .local v7, _arg5:Landroid/view/InputChannel;
    move-object v1, p0

    .line 70
    invoke-virtual/range {v1 .. v7}, Landroid/view/IWindowSession$Stub;->add(Landroid/view/IWindow;ILandroid/view/WindowManager$LayoutParams;ILandroid/graphics/Rect;Landroid/view/InputChannel;)I

    move-result v14

    .line 71
    .local v14, _result:I
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 72
    move-object/from16 v0, p3

    invoke-virtual {v0, v14}, Landroid/os/Parcel;->writeInt(I)V

    .line 73
    if-eqz v6, :cond_6f

    .line 74
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 75
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v6, v0, v1}, Landroid/graphics/Rect;->writeToParcel(Landroid/os/Parcel;I)V

    .line 80
    :goto_5d
    if-eqz v7, :cond_76

    .line 81
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 82
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v7, v0, v1}, Landroid/view/InputChannel;->writeToParcel(Landroid/os/Parcel;I)V

    .line 87
    :goto_6b
    const/4 v1, 0x1

    goto :goto_7

    .line 62
    .end local v4           #_arg2:Landroid/view/WindowManager$LayoutParams;
    .end local v5           #_arg3:I
    .end local v6           #_arg4:Landroid/graphics/Rect;
    .end local v7           #_arg5:Landroid/view/InputChannel;
    .end local v14           #_result:I
    :cond_6d
    const/4 v4, 0x0

    .restart local v4       #_arg2:Landroid/view/WindowManager$LayoutParams;
    goto :goto_34

    .line 78
    .restart local v5       #_arg3:I
    .restart local v6       #_arg4:Landroid/graphics/Rect;
    .restart local v7       #_arg5:Landroid/view/InputChannel;
    .restart local v14       #_result:I
    :cond_6f
    const/4 v1, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_5d

    .line 85
    :cond_76
    const/4 v1, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_6b

    .line 91
    .end local v2           #_arg0:Landroid/view/IWindow;
    .end local v3           #_arg1:I
    .end local v4           #_arg2:Landroid/view/WindowManager$LayoutParams;
    .end local v5           #_arg3:I
    .end local v6           #_arg4:Landroid/graphics/Rect;
    .end local v7           #_arg5:Landroid/view/InputChannel;
    .end local v14           #_result:I
    :sswitch_7d
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 93
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 95
    .restart local v2       #_arg0:Landroid/view/IWindow;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 97
    .restart local v3       #_arg1:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_c7

    .line 98
    sget-object v1, Landroid/view/WindowManager$LayoutParams;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/WindowManager$LayoutParams;

    .line 104
    .restart local v4       #_arg2:Landroid/view/WindowManager$LayoutParams;
    :goto_a0
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    .line 106
    .restart local v5       #_arg3:I
    new-instance v6, Landroid/graphics/Rect;

    invoke-direct {v6}, Landroid/graphics/Rect;-><init>()V

    .restart local v6       #_arg4:Landroid/graphics/Rect;
    move-object v1, p0

    .line 107
    invoke-virtual/range {v1 .. v6}, Landroid/view/IWindowSession$Stub;->addWithoutInputChannel(Landroid/view/IWindow;ILandroid/view/WindowManager$LayoutParams;ILandroid/graphics/Rect;)I

    move-result v14

    .line 108
    .restart local v14       #_result:I
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 109
    move-object/from16 v0, p3

    invoke-virtual {v0, v14}, Landroid/os/Parcel;->writeInt(I)V

    .line 110
    if-eqz v6, :cond_c9

    .line 111
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 112
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v6, v0, v1}, Landroid/graphics/Rect;->writeToParcel(Landroid/os/Parcel;I)V

    .line 117
    :goto_c4
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 101
    .end local v4           #_arg2:Landroid/view/WindowManager$LayoutParams;
    .end local v5           #_arg3:I
    .end local v6           #_arg4:Landroid/graphics/Rect;
    .end local v14           #_result:I
    :cond_c7
    const/4 v4, 0x0

    .restart local v4       #_arg2:Landroid/view/WindowManager$LayoutParams;
    goto :goto_a0

    .line 115
    .restart local v5       #_arg3:I
    .restart local v6       #_arg4:Landroid/graphics/Rect;
    .restart local v14       #_result:I
    :cond_c9
    const/4 v1, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_c4

    .line 121
    .end local v2           #_arg0:Landroid/view/IWindow;
    .end local v3           #_arg1:I
    .end local v4           #_arg2:Landroid/view/WindowManager$LayoutParams;
    .end local v5           #_arg3:I
    .end local v6           #_arg4:Landroid/graphics/Rect;
    .end local v14           #_result:I
    :sswitch_d0
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 123
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 124
    .restart local v2       #_arg0:Landroid/view/IWindow;
    invoke-virtual {p0, v2}, Landroid/view/IWindowSession$Stub;->remove(Landroid/view/IWindow;)V

    .line 125
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 126
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 130
    .end local v2           #_arg0:Landroid/view/IWindow;
    :sswitch_e8
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 132
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 134
    .restart local v2       #_arg0:Landroid/view/IWindow;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 136
    .restart local v3       #_arg1:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_18a

    .line 137
    sget-object v1, Landroid/view/WindowManager$LayoutParams;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/WindowManager$LayoutParams;

    .line 143
    .restart local v4       #_arg2:Landroid/view/WindowManager$LayoutParams;
    :goto_10b
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    .line 145
    .restart local v5       #_arg3:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v6

    .line 147
    .local v6, _arg4:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v7

    .line 149
    .local v7, _arg5:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v8

    .line 151
    .local v8, _arg6:I
    new-instance v9, Landroid/graphics/Rect;

    invoke-direct {v9}, Landroid/graphics/Rect;-><init>()V

    .line 153
    .local v9, _arg7:Landroid/graphics/Rect;
    new-instance v10, Landroid/graphics/Rect;

    invoke-direct {v10}, Landroid/graphics/Rect;-><init>()V

    .line 155
    .local v10, _arg8:Landroid/graphics/Rect;
    new-instance v11, Landroid/graphics/Rect;

    invoke-direct {v11}, Landroid/graphics/Rect;-><init>()V

    .line 157
    .local v11, _arg9:Landroid/graphics/Rect;
    new-instance v12, Landroid/content/res/Configuration;

    invoke-direct {v12}, Landroid/content/res/Configuration;-><init>()V

    .line 159
    .local v12, _arg10:Landroid/content/res/Configuration;
    new-instance v13, Landroid/view/Surface;

    invoke-direct {v13}, Landroid/view/Surface;-><init>()V

    .local v13, _arg11:Landroid/view/Surface;
    move-object v1, p0

    .line 160
    invoke-virtual/range {v1 .. v13}, Landroid/view/IWindowSession$Stub;->relayout(Landroid/view/IWindow;ILandroid/view/WindowManager$LayoutParams;IIIILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/content/res/Configuration;Landroid/view/Surface;)I

    move-result v14

    .line 161
    .restart local v14       #_result:I
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 162
    move-object/from16 v0, p3

    invoke-virtual {v0, v14}, Landroid/os/Parcel;->writeInt(I)V

    .line 163
    if-eqz v9, :cond_18c

    .line 164
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 165
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v9, v0, v1}, Landroid/graphics/Rect;->writeToParcel(Landroid/os/Parcel;I)V

    .line 170
    :goto_14f
    if-eqz v10, :cond_193

    .line 171
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 172
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v10, v0, v1}, Landroid/graphics/Rect;->writeToParcel(Landroid/os/Parcel;I)V

    .line 177
    :goto_15d
    if-eqz v11, :cond_19a

    .line 178
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 179
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v11, v0, v1}, Landroid/graphics/Rect;->writeToParcel(Landroid/os/Parcel;I)V

    .line 184
    :goto_16b
    if-eqz v12, :cond_1a1

    .line 185
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 186
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v12, v0, v1}, Landroid/content/res/Configuration;->writeToParcel(Landroid/os/Parcel;I)V

    .line 191
    :goto_179
    if-eqz v13, :cond_1a8

    .line 192
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 193
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v13, v0, v1}, Landroid/view/Surface;->writeToParcel(Landroid/os/Parcel;I)V

    .line 198
    :goto_187
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 140
    .end local v4           #_arg2:Landroid/view/WindowManager$LayoutParams;
    .end local v5           #_arg3:I
    .end local v6           #_arg4:I
    .end local v7           #_arg5:I
    .end local v8           #_arg6:I
    .end local v9           #_arg7:Landroid/graphics/Rect;
    .end local v10           #_arg8:Landroid/graphics/Rect;
    .end local v11           #_arg9:Landroid/graphics/Rect;
    .end local v12           #_arg10:Landroid/content/res/Configuration;
    .end local v13           #_arg11:Landroid/view/Surface;
    .end local v14           #_result:I
    :cond_18a
    const/4 v4, 0x0

    .restart local v4       #_arg2:Landroid/view/WindowManager$LayoutParams;
    goto :goto_10b

    .line 168
    .restart local v5       #_arg3:I
    .restart local v6       #_arg4:I
    .restart local v7       #_arg5:I
    .restart local v8       #_arg6:I
    .restart local v9       #_arg7:Landroid/graphics/Rect;
    .restart local v10       #_arg8:Landroid/graphics/Rect;
    .restart local v11       #_arg9:Landroid/graphics/Rect;
    .restart local v12       #_arg10:Landroid/content/res/Configuration;
    .restart local v13       #_arg11:Landroid/view/Surface;
    .restart local v14       #_result:I
    :cond_18c
    const/4 v1, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_14f

    .line 175
    :cond_193
    const/4 v1, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_15d

    .line 182
    :cond_19a
    const/4 v1, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_16b

    .line 189
    :cond_1a1
    const/4 v1, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_179

    .line 196
    :cond_1a8
    const/4 v1, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_187

    .line 202
    .end local v2           #_arg0:Landroid/view/IWindow;
    .end local v3           #_arg1:I
    .end local v4           #_arg2:Landroid/view/WindowManager$LayoutParams;
    .end local v5           #_arg3:I
    .end local v6           #_arg4:I
    .end local v7           #_arg5:I
    .end local v8           #_arg6:I
    .end local v9           #_arg7:Landroid/graphics/Rect;
    .end local v10           #_arg8:Landroid/graphics/Rect;
    .end local v11           #_arg9:Landroid/graphics/Rect;
    .end local v12           #_arg10:Landroid/content/res/Configuration;
    .end local v13           #_arg11:Landroid/view/Surface;
    .end local v14           #_result:I
    :sswitch_1af
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 204
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 205
    .restart local v2       #_arg0:Landroid/view/IWindow;
    invoke-virtual {p0, v2}, Landroid/view/IWindowSession$Stub;->performDeferredDestroy(Landroid/view/IWindow;)V

    .line 206
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 207
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 211
    .end local v2           #_arg0:Landroid/view/IWindow;
    :sswitch_1c7
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 213
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 214
    .restart local v2       #_arg0:Landroid/view/IWindow;
    invoke-virtual {p0, v2}, Landroid/view/IWindowSession$Stub;->outOfMemory(Landroid/view/IWindow;)Z

    move-result v14

    .line 215
    .local v14, _result:Z
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 216
    if-eqz v14, :cond_1e8

    const/4 v1, 0x1

    :goto_1e0
    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 217
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 216
    :cond_1e8
    const/4 v1, 0x0

    goto :goto_1e0

    .line 221
    .end local v2           #_arg0:Landroid/view/IWindow;
    .end local v14           #_result:Z
    :sswitch_1ea
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 223
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 225
    .restart local v2       #_arg0:Landroid/view/IWindow;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_212

    .line 226
    sget-object v1, Landroid/graphics/Region;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/graphics/Region;

    .line 231
    .local v3, _arg1:Landroid/graphics/Region;
    :goto_209
    invoke-virtual {p0, v2, v3}, Landroid/view/IWindowSession$Stub;->setTransparentRegion(Landroid/view/IWindow;Landroid/graphics/Region;)V

    .line 232
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 233
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 229
    .end local v3           #_arg1:Landroid/graphics/Region;
    :cond_212
    const/4 v3, 0x0

    .restart local v3       #_arg1:Landroid/graphics/Region;
    goto :goto_209

    .line 237
    .end local v2           #_arg0:Landroid/view/IWindow;
    .end local v3           #_arg1:Landroid/graphics/Region;
    :sswitch_214
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 239
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 241
    .restart local v2       #_arg0:Landroid/view/IWindow;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 243
    .local v3, _arg1:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_261

    .line 244
    sget-object v1, Landroid/graphics/Rect;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/graphics/Rect;

    .line 250
    .local v4, _arg2:Landroid/graphics/Rect;
    :goto_237
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_263

    .line 251
    sget-object v1, Landroid/graphics/Rect;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/graphics/Rect;

    .line 257
    .local v5, _arg3:Landroid/graphics/Rect;
    :goto_247
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_265

    .line 258
    sget-object v1, Landroid/graphics/Region;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/graphics/Region;

    .local v6, _arg4:Landroid/graphics/Region;
    :goto_257
    move-object v1, p0

    .line 263
    invoke-virtual/range {v1 .. v6}, Landroid/view/IWindowSession$Stub;->setInsets(Landroid/view/IWindow;ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Region;)V

    .line 264
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 265
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 247
    .end local v4           #_arg2:Landroid/graphics/Rect;
    .end local v5           #_arg3:Landroid/graphics/Rect;
    .end local v6           #_arg4:Landroid/graphics/Region;
    :cond_261
    const/4 v4, 0x0

    .restart local v4       #_arg2:Landroid/graphics/Rect;
    goto :goto_237

    .line 254
    :cond_263
    const/4 v5, 0x0

    .restart local v5       #_arg3:Landroid/graphics/Rect;
    goto :goto_247

    .line 261
    :cond_265
    const/4 v6, 0x0

    .restart local v6       #_arg4:Landroid/graphics/Region;
    goto :goto_257

    .line 269
    .end local v2           #_arg0:Landroid/view/IWindow;
    .end local v3           #_arg1:I
    .end local v4           #_arg2:Landroid/graphics/Rect;
    .end local v5           #_arg3:Landroid/graphics/Rect;
    .end local v6           #_arg4:Landroid/graphics/Region;
    :sswitch_267
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 271
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 273
    .restart local v2       #_arg0:Landroid/view/IWindow;
    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    .line 274
    .local v3, _arg1:Landroid/graphics/Rect;
    invoke-virtual {p0, v2, v3}, Landroid/view/IWindowSession$Stub;->getDisplayFrame(Landroid/view/IWindow;Landroid/graphics/Rect;)V

    .line 275
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 276
    if-eqz v3, :cond_292

    .line 277
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 278
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v3, v0, v1}, Landroid/graphics/Rect;->writeToParcel(Landroid/os/Parcel;I)V

    .line 283
    :goto_28f
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 281
    :cond_292
    const/4 v1, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_28f

    .line 287
    .end local v2           #_arg0:Landroid/view/IWindow;
    .end local v3           #_arg1:Landroid/graphics/Rect;
    :sswitch_299
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 289
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 290
    .restart local v2       #_arg0:Landroid/view/IWindow;
    invoke-virtual {p0, v2}, Landroid/view/IWindowSession$Stub;->finishDrawing(Landroid/view/IWindow;)V

    .line 291
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 292
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 296
    .end local v2           #_arg0:Landroid/view/IWindow;
    :sswitch_2b1
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 298
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_2c8

    const/4 v2, 0x1

    .line 299
    .local v2, _arg0:Z
    :goto_2bf
    invoke-virtual {p0, v2}, Landroid/view/IWindowSession$Stub;->setInTouchMode(Z)V

    .line 300
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 301
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 298
    .end local v2           #_arg0:Z
    :cond_2c8
    const/4 v2, 0x0

    goto :goto_2bf

    .line 305
    :sswitch_2ca
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 306
    invoke-virtual {p0}, Landroid/view/IWindowSession$Stub;->getInTouchMode()Z

    move-result v14

    .line 307
    .restart local v14       #_result:Z
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 308
    if-eqz v14, :cond_2e3

    const/4 v1, 0x1

    :goto_2db
    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 309
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 308
    :cond_2e3
    const/4 v1, 0x0

    goto :goto_2db

    .line 313
    .end local v14           #_result:Z
    :sswitch_2e5
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 315
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 317
    .local v2, _arg0:Landroid/view/IWindow;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 319
    .local v3, _arg1:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_311

    const/4 v4, 0x1

    .line 320
    .local v4, _arg2:Z
    :goto_2ff
    invoke-virtual {p0, v2, v3, v4}, Landroid/view/IWindowSession$Stub;->performHapticFeedback(Landroid/view/IWindow;IZ)Z

    move-result v14

    .line 321
    .restart local v14       #_result:Z
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 322
    if-eqz v14, :cond_313

    const/4 v1, 0x1

    :goto_309
    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 323
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 319
    .end local v4           #_arg2:Z
    .end local v14           #_result:Z
    :cond_311
    const/4 v4, 0x0

    goto :goto_2ff

    .line 322
    .restart local v4       #_arg2:Z
    .restart local v14       #_result:Z
    :cond_313
    const/4 v1, 0x0

    goto :goto_309

    .line 327
    .end local v2           #_arg0:Landroid/view/IWindow;
    .end local v3           #_arg1:I
    .end local v4           #_arg2:Z
    .end local v14           #_result:Z
    :sswitch_315
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 329
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 331
    .restart local v2       #_arg0:Landroid/view/IWindow;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 333
    .restart local v3       #_arg1:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    .line 335
    .local v4, _arg2:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    .line 337
    .local v5, _arg3:I
    new-instance v6, Landroid/view/Surface;

    invoke-direct {v6}, Landroid/view/Surface;-><init>()V

    .local v6, _arg4:Landroid/view/Surface;
    move-object v1, p0

    .line 338
    invoke-virtual/range {v1 .. v6}, Landroid/view/IWindowSession$Stub;->prepareDrag(Landroid/view/IWindow;IIILandroid/view/Surface;)Landroid/os/IBinder;

    move-result-object v14

    .line 339
    .local v14, _result:Landroid/os/IBinder;
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 340
    move-object/from16 v0, p3

    invoke-virtual {v0, v14}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    .line 341
    if-eqz v6, :cond_353

    .line 342
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 343
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v6, v0, v1}, Landroid/view/Surface;->writeToParcel(Landroid/os/Parcel;I)V

    .line 348
    :goto_350
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 346
    :cond_353
    const/4 v1, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_350

    .line 352
    .end local v2           #_arg0:Landroid/view/IWindow;
    .end local v3           #_arg1:I
    .end local v4           #_arg2:I
    .end local v5           #_arg3:I
    .end local v6           #_arg4:Landroid/view/Surface;
    .end local v14           #_result:Landroid/os/IBinder;
    :sswitch_35a
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 354
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 356
    .restart local v2       #_arg0:Landroid/view/IWindow;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v3

    .line 358
    .local v3, _arg1:Landroid/os/IBinder;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFloat()F

    move-result v4

    .line 360
    .local v4, _arg2:F
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFloat()F

    move-result v5

    .line 362
    .local v5, _arg3:F
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFloat()F

    move-result v6

    .line 364
    .local v6, _arg4:F
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFloat()F

    move-result v7

    .line 366
    .local v7, _arg5:F
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_3a0

    .line 367
    sget-object v1, Landroid/content/ClipData;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/ClipData;

    .local v8, _arg6:Landroid/content/ClipData;
    :goto_38d
    move-object v1, p0

    .line 372
    invoke-virtual/range {v1 .. v8}, Landroid/view/IWindowSession$Stub;->performDrag(Landroid/view/IWindow;Landroid/os/IBinder;FFFFLandroid/content/ClipData;)Z

    move-result v14

    .line 373
    .local v14, _result:Z
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 374
    if-eqz v14, :cond_3a2

    const/4 v1, 0x1

    :goto_398
    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 375
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 370
    .end local v8           #_arg6:Landroid/content/ClipData;
    .end local v14           #_result:Z
    :cond_3a0
    const/4 v8, 0x0

    .restart local v8       #_arg6:Landroid/content/ClipData;
    goto :goto_38d

    .line 374
    .restart local v14       #_result:Z
    :cond_3a2
    const/4 v1, 0x0

    goto :goto_398

    .line 379
    .end local v2           #_arg0:Landroid/view/IWindow;
    .end local v3           #_arg1:Landroid/os/IBinder;
    .end local v4           #_arg2:F
    .end local v5           #_arg3:F
    .end local v6           #_arg4:F
    .end local v7           #_arg5:F
    .end local v8           #_arg6:Landroid/content/ClipData;
    .end local v14           #_result:Z
    :sswitch_3a4
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 381
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 383
    .restart local v2       #_arg0:Landroid/view/IWindow;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_3c3

    const/4 v3, 0x1

    .line 384
    .local v3, _arg1:Z
    :goto_3ba
    invoke-virtual {p0, v2, v3}, Landroid/view/IWindowSession$Stub;->reportDropResult(Landroid/view/IWindow;Z)V

    .line 385
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 386
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 383
    .end local v3           #_arg1:Z
    :cond_3c3
    const/4 v3, 0x0

    goto :goto_3ba

    .line 390
    .end local v2           #_arg0:Landroid/view/IWindow;
    :sswitch_3c5
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 392
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 393
    .restart local v2       #_arg0:Landroid/view/IWindow;
    invoke-virtual {p0, v2}, Landroid/view/IWindowSession$Stub;->dragRecipientEntered(Landroid/view/IWindow;)V

    .line 394
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 395
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 399
    .end local v2           #_arg0:Landroid/view/IWindow;
    :sswitch_3dd
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 401
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Landroid/view/IWindow$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindow;

    move-result-object v2

    .line 402
    .restart local v2       #_arg0:Landroid/view/IWindow;
    invoke-virtual {p0, v2}, Landroid/view/IWindowSession$Stub;->dragRecipientExited(Landroid/view/IWindow;)V

    .line 403
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 404
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 408
    .end local v2           #_arg0:Landroid/view/IWindow;
    :sswitch_3f5
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 410
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v2

    .line 412
    .local v2, _arg0:Landroid/os/IBinder;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFloat()F

    move-result v3

    .line 414
    .local v3, _arg1:F
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFloat()F

    move-result v4

    .line 416
    .restart local v4       #_arg2:F
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFloat()F

    move-result v5

    .line 418
    .restart local v5       #_arg3:F
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFloat()F

    move-result v6

    .restart local v6       #_arg4:F
    move-object v1, p0

    .line 419
    invoke-virtual/range {v1 .. v6}, Landroid/view/IWindowSession$Stub;->setWallpaperPosition(Landroid/os/IBinder;FFFF)V

    .line 420
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 421
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 425
    .end local v2           #_arg0:Landroid/os/IBinder;
    .end local v3           #_arg1:F
    .end local v4           #_arg2:F
    .end local v5           #_arg3:F
    .end local v6           #_arg4:F
    :sswitch_41a
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 427
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v2

    .line 428
    .restart local v2       #_arg0:Landroid/os/IBinder;
    invoke-virtual {p0, v2}, Landroid/view/IWindowSession$Stub;->wallpaperOffsetsComplete(Landroid/os/IBinder;)V

    .line 429
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 430
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 434
    .end local v2           #_arg0:Landroid/os/IBinder;
    :sswitch_42e
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 436
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v2

    .line 438
    .restart local v2       #_arg0:Landroid/os/IBinder;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 440
    .local v3, _arg1:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    .line 442
    .local v4, _arg2:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    .line 444
    .local v5, _arg3:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v6

    .line 446
    .local v6, _arg4:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_479

    .line 447
    sget-object v1, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/os/Bundle;

    .line 453
    .local v7, _arg5:Landroid/os/Bundle;
    :goto_459
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_47b

    const/4 v8, 0x1

    .local v8, _arg6:Z
    :goto_460
    move-object v1, p0

    .line 454
    invoke-virtual/range {v1 .. v8}, Landroid/view/IWindowSession$Stub;->sendWallpaperCommand(Landroid/os/IBinder;Ljava/lang/String;IIILandroid/os/Bundle;Z)Landroid/os/Bundle;

    move-result-object v14

    .line 455
    .local v14, _result:Landroid/os/Bundle;
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 456
    if-eqz v14, :cond_47d

    .line 457
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 458
    const/4 v1, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v14, v0, v1}, Landroid/os/Bundle;->writeToParcel(Landroid/os/Parcel;I)V

    .line 463
    :goto_476
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 450
    .end local v7           #_arg5:Landroid/os/Bundle;
    .end local v8           #_arg6:Z
    .end local v14           #_result:Landroid/os/Bundle;
    :cond_479
    const/4 v7, 0x0

    .restart local v7       #_arg5:Landroid/os/Bundle;
    goto :goto_459

    .line 453
    :cond_47b
    const/4 v8, 0x0

    goto :goto_460

    .line 461
    .restart local v8       #_arg6:Z
    .restart local v14       #_result:Landroid/os/Bundle;
    :cond_47d
    const/4 v1, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_476

    .line 467
    .end local v2           #_arg0:Landroid/os/IBinder;
    .end local v3           #_arg1:Ljava/lang/String;
    .end local v4           #_arg2:I
    .end local v5           #_arg3:I
    .end local v6           #_arg4:I
    .end local v7           #_arg5:Landroid/os/Bundle;
    .end local v8           #_arg6:Z
    .end local v14           #_result:Landroid/os/Bundle;
    :sswitch_484
    const-string v1, "android.view.IWindowSession"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 469
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v2

    .line 471
    .restart local v2       #_arg0:Landroid/os/IBinder;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_4a8

    .line 472
    sget-object v1, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/os/Bundle;

    .line 477
    .local v3, _arg1:Landroid/os/Bundle;
    :goto_49f
    invoke-virtual {p0, v2, v3}, Landroid/view/IWindowSession$Stub;->wallpaperCommandComplete(Landroid/os/IBinder;Landroid/os/Bundle;)V

    .line 478
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 479
    const/4 v1, 0x1

    goto/16 :goto_7

    .line 475
    .end local v3           #_arg1:Landroid/os/Bundle;
    :cond_4a8
    const/4 v3, 0x0

    .restart local v3       #_arg1:Landroid/os/Bundle;
    goto :goto_49f

    .line 43
    :sswitch_data_4aa
    .sparse-switch
        0x1 -> :sswitch_11
        0x2 -> :sswitch_7d
        0x3 -> :sswitch_d0
        0x4 -> :sswitch_e8
        0x5 -> :sswitch_1af
        0x6 -> :sswitch_1c7
        0x7 -> :sswitch_1ea
        0x8 -> :sswitch_214
        0x9 -> :sswitch_267
        0xa -> :sswitch_299
        0xb -> :sswitch_2b1
        0xc -> :sswitch_2ca
        0xd -> :sswitch_2e5
        0xe -> :sswitch_315
        0xf -> :sswitch_35a
        0x10 -> :sswitch_3a4
        0x11 -> :sswitch_3c5
        0x12 -> :sswitch_3dd
        0x13 -> :sswitch_3f5
        0x14 -> :sswitch_41a
        0x15 -> :sswitch_42e
        0x16 -> :sswitch_484
        0x5f4e5446 -> :sswitch_8
    .end sparse-switch
.end method
