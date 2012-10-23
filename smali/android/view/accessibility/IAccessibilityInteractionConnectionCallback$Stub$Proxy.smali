.class Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback$Stub$Proxy;
.super Ljava/lang/Object;
.source "IAccessibilityInteractionConnectionCallback.java"

# interfaces
.implements Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback$Stub;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Proxy"
.end annotation


# instance fields
.field private mRemote:Landroid/os/IBinder;


# direct methods
.method constructor <init>(Landroid/os/IBinder;)V
    .registers 2
    .parameter "remote"

    .prologue
    .line 93
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 94
    iput-object p1, p0, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    .line 95
    return-void
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 2

    .prologue
    .line 98
    iget-object v0, p0, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    return-object v0
.end method

.method public getInterfaceDescriptor()Ljava/lang/String;
    .registers 2

    .prologue
    .line 102
    const-string v0, "android.view.accessibility.IAccessibilityInteractionConnectionCallback"

    return-object v0
.end method

.method public setFindAccessibilityNodeInfoResult(Landroid/view/accessibility/AccessibilityNodeInfo;I)V
    .registers 8
    .parameter "info"
    .parameter "interactionId"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 112
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 114
    .local v0, _data:Landroid/os/Parcel;
    :try_start_4
    const-string v1, "android.view.accessibility.IAccessibilityInteractionConnectionCallback"

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 115
    if-eqz p1, :cond_22

    .line 116
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 117
    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/accessibility/AccessibilityNodeInfo;->writeToParcel(Landroid/os/Parcel;I)V

    .line 122
    :goto_13
    invoke-virtual {v0, p2}, Landroid/os/Parcel;->writeInt(I)V

    .line 123
    iget-object v1, p0, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v2, 0x1

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-interface {v1, v2, v0, v3, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    :try_end_1e
    .catchall {:try_start_4 .. :try_end_1e} :catchall_27

    .line 126
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 128
    return-void

    .line 120
    :cond_22
    const/4 v1, 0x0

    :try_start_23
    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V
    :try_end_26
    .catchall {:try_start_23 .. :try_end_26} :catchall_27

    goto :goto_13

    .line 126
    :catchall_27
    move-exception v1

    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    throw v1
.end method

.method public setFindAccessibilityNodeInfosResult(Ljava/util/List;I)V
    .registers 8
    .parameter
    .parameter "interactionId"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;I)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 137
    .local p1, infos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 139
    .local v0, _data:Landroid/os/Parcel;
    :try_start_4
    const-string v1, "android.view.accessibility.IAccessibilityInteractionConnectionCallback"

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 140
    invoke-virtual {v0, p1}, Landroid/os/Parcel;->writeTypedList(Ljava/util/List;)V

    .line 141
    invoke-virtual {v0, p2}, Landroid/os/Parcel;->writeInt(I)V

    .line 142
    iget-object v1, p0, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v2, 0x2

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-interface {v1, v2, v0, v3, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    :try_end_17
    .catchall {:try_start_4 .. :try_end_17} :catchall_1b

    .line 145
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 147
    return-void

    .line 145
    :catchall_1b
    move-exception v1

    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    throw v1
.end method

.method public setPerformAccessibilityActionResult(ZI)V
    .registers 8
    .parameter "succeeded"
    .parameter "interactionId"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 156
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 158
    .local v0, _data:Landroid/os/Parcel;
    :try_start_5
    const-string v2, "android.view.accessibility.IAccessibilityInteractionConnectionCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 159
    if-eqz p1, :cond_1e

    :goto_c
    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 160
    invoke-virtual {v0, p2}, Landroid/os/Parcel;->writeInt(I)V

    .line 161
    iget-object v1, p0, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v2, 0x3

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-interface {v1, v2, v0, v3, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    :try_end_1a
    .catchall {:try_start_5 .. :try_end_1a} :catchall_20

    .line 164
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 166
    return-void

    .line 159
    :cond_1e
    const/4 v1, 0x0

    goto :goto_c

    .line 164
    :catchall_20
    move-exception v1

    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    throw v1
.end method
