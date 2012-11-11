.class public abstract Landroid/database/BulkCursorNative;
.super Landroid/os/Binder;
.source "BulkCursorNative.java"

# interfaces
.implements Landroid/database/IBulkCursor;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    const-string v0, "android.content.IBulkCursor"

    invoke-virtual {p0, p0, v0}, Landroid/database/BulkCursorNative;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/database/IBulkCursor;
    .registers 3
    .parameter "obj"

    .prologue
    if-nez p0, :cond_4

    const/4 v0, 0x0

    :cond_3
    :goto_3
    return-object v0

    :cond_4
    const-string v1, "android.content.IBulkCursor"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Landroid/database/IBulkCursor;

    .local v0, in:Landroid/database/IBulkCursor;
    if-nez v0, :cond_3

    new-instance v0, Landroid/database/BulkCursorProxy;

    .end local v0           #in:Landroid/database/IBulkCursor;
    invoke-direct {v0, p0}, Landroid/database/BulkCursorProxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 15
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
    const/4 v8, 0x1

    packed-switch p1, :pswitch_data_9a

    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v8

    :goto_8
    return v8

    :pswitch_9
    :try_start_9
    const-string v9, "android.content.IBulkCursor"

    invoke-virtual {p2, v9}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v6

    .local v6, startPos:I
    invoke-virtual {p0, v6}, Landroid/database/BulkCursorNative;->getWindow(I)Landroid/database/CursorWindow;

    move-result-object v7

    .local v7, window:Landroid/database/CursorWindow;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    if-nez v7, :cond_25

    const/4 v9, 0x0

    invoke-virtual {p3, v9}, Landroid/os/Parcel;->writeInt(I)V
    :try_end_1f
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_1f} :catch_20

    goto :goto_8

    .end local v6           #startPos:I
    .end local v7           #window:Landroid/database/CursorWindow;
    :catch_20
    move-exception v1

    .local v1, e:Ljava/lang/Exception;
    invoke-static {p3, v1}, Landroid/database/DatabaseUtils;->writeExceptionToParcel(Landroid/os/Parcel;Ljava/lang/Exception;)V

    goto :goto_8

    .end local v1           #e:Ljava/lang/Exception;
    .restart local v6       #startPos:I
    .restart local v7       #window:Landroid/database/CursorWindow;
    :cond_25
    const/4 v9, 0x1

    :try_start_26
    invoke-virtual {p3, v9}, Landroid/os/Parcel;->writeInt(I)V

    const/4 v9, 0x1

    invoke-virtual {v7, p3, v9}, Landroid/database/CursorWindow;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_8

    .end local v6           #startPos:I
    .end local v7           #window:Landroid/database/CursorWindow;
    :pswitch_2e
    const-string v9, "android.content.IBulkCursor"

    invoke-virtual {p2, v9}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/database/BulkCursorNative;->deactivate()V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    :pswitch_3a
    const-string v9, "android.content.IBulkCursor"

    invoke-virtual {p2, v9}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/database/BulkCursorNative;->close()V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    :pswitch_46
    const-string v9, "android.content.IBulkCursor"

    invoke-virtual {p2, v9}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v9

    invoke-static {v9}, Landroid/database/IContentObserver$Stub;->asInterface(Landroid/os/IBinder;)Landroid/database/IContentObserver;

    move-result-object v3

    .local v3, observer:Landroid/database/IContentObserver;
    invoke-virtual {p0, v3}, Landroid/database/BulkCursorNative;->requery(Landroid/database/IContentObserver;)I

    move-result v0

    .local v0, count:I
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    invoke-virtual {p0}, Landroid/database/BulkCursorNative;->getExtras()Landroid/os/Bundle;

    move-result-object v9

    invoke-virtual {p3, v9}, Landroid/os/Parcel;->writeBundle(Landroid/os/Bundle;)V

    goto :goto_8

    .end local v0           #count:I
    .end local v3           #observer:Landroid/database/IContentObserver;
    :pswitch_65
    const-string v9, "android.content.IBulkCursor"

    invoke-virtual {p2, v9}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    .local v4, position:I
    invoke-virtual {p0, v4}, Landroid/database/BulkCursorNative;->onMove(I)V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    .end local v4           #position:I
    :pswitch_75
    const-string v9, "android.content.IBulkCursor"

    invoke-virtual {p2, v9}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/database/BulkCursorNative;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    .local v2, extras:Landroid/os/Bundle;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeBundle(Landroid/os/Bundle;)V

    goto :goto_8

    .end local v2           #extras:Landroid/os/Bundle;
    :pswitch_85
    const-string v9, "android.content.IBulkCursor"

    invoke-virtual {p2, v9}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readBundle()Landroid/os/Bundle;

    move-result-object v2

    .restart local v2       #extras:Landroid/os/Bundle;
    invoke-virtual {p0, v2}, Landroid/database/BulkCursorNative;->respond(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v5

    .local v5, returnExtras:Landroid/os/Bundle;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    invoke-virtual {p3, v5}, Landroid/os/Parcel;->writeBundle(Landroid/os/Bundle;)V
    :try_end_98
    .catch Ljava/lang/Exception; {:try_start_26 .. :try_end_98} :catch_20

    goto/16 :goto_8

    :pswitch_data_9a
    .packed-switch 0x1
        :pswitch_9
        :pswitch_2e
        :pswitch_46
        :pswitch_65
        :pswitch_75
        :pswitch_85
        :pswitch_3a
    .end packed-switch
.end method
