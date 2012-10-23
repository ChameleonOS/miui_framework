.class Landroid/location/IGeocodeProvider$Stub$Proxy;
.super Ljava/lang/Object;
.source "IGeocodeProvider.java"

# interfaces
.implements Landroid/location/IGeocodeProvider;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/location/IGeocodeProvider$Stub;
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
    .line 111
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 112
    iput-object p1, p0, Landroid/location/IGeocodeProvider$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    .line 113
    return-void
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 2

    .prologue
    .line 116
    iget-object v0, p0, Landroid/location/IGeocodeProvider$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    return-object v0
.end method

.method public getFromLocation(DDILandroid/location/GeocoderParams;Ljava/util/List;)Ljava/lang/String;
    .registers 14
    .parameter "latitude"
    .parameter "longitude"
    .parameter "maxResults"
    .parameter "params"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(DDI",
            "Landroid/location/GeocoderParams;",
            "Ljava/util/List",
            "<",
            "Landroid/location/Address;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 124
    .local p7, addrs:Ljava/util/List;,"Ljava/util/List<Landroid/location/Address;>;"
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 125
    .local v0, _data:Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 128
    .local v1, _reply:Landroid/os/Parcel;
    :try_start_8
    const-string v3, "android.location.IGeocodeProvider"

    invoke-virtual {v0, v3}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 129
    invoke-virtual {v0, p1, p2}, Landroid/os/Parcel;->writeDouble(D)V

    .line 130
    invoke-virtual {v0, p3, p4}, Landroid/os/Parcel;->writeDouble(D)V

    .line 131
    invoke-virtual {v0, p5}, Landroid/os/Parcel;->writeInt(I)V

    .line 132
    if-eqz p6, :cond_3a

    .line 133
    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Landroid/os/Parcel;->writeInt(I)V

    .line 134
    const/4 v3, 0x0

    invoke-virtual {p6, v0, v3}, Landroid/location/GeocoderParams;->writeToParcel(Landroid/os/Parcel;I)V

    .line 139
    :goto_20
    iget-object v3, p0, Landroid/location/IGeocodeProvider$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v4, 0x1

    const/4 v5, 0x0

    invoke-interface {v3, v4, v0, v1, v5}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 140
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V

    .line 141
    invoke-virtual {v1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 142
    .local v2, _result:Ljava/lang/String;
    sget-object v3, Landroid/location/Address;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {v1, p7, v3}, Landroid/os/Parcel;->readTypedList(Ljava/util/List;Landroid/os/Parcelable$Creator;)V
    :try_end_33
    .catchall {:try_start_8 .. :try_end_33} :catchall_3f

    .line 145
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 146
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 148
    return-object v2

    .line 137
    .end local v2           #_result:Ljava/lang/String;
    :cond_3a
    const/4 v3, 0x0

    :try_start_3b
    invoke-virtual {v0, v3}, Landroid/os/Parcel;->writeInt(I)V
    :try_end_3e
    .catchall {:try_start_3b .. :try_end_3e} :catchall_3f

    goto :goto_20

    .line 145
    :catchall_3f
    move-exception v3

    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 146
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 145
    throw v3
.end method

.method public getFromLocationName(Ljava/lang/String;DDDDILandroid/location/GeocoderParams;Ljava/util/List;)Ljava/lang/String;
    .registers 21
    .parameter "locationName"
    .parameter "lowerLeftLatitude"
    .parameter "lowerLeftLongitude"
    .parameter "upperRightLatitude"
    .parameter "upperRightLongitude"
    .parameter "maxResults"
    .parameter "params"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "DDDDI",
            "Landroid/location/GeocoderParams;",
            "Ljava/util/List",
            "<",
            "Landroid/location/Address;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 152
    .local p12, addrs:Ljava/util/List;,"Ljava/util/List<Landroid/location/Address;>;"
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v2

    .line 153
    .local v2, _data:Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v3

    .line 156
    .local v3, _reply:Landroid/os/Parcel;
    :try_start_8
    const-string v5, "android.location.IGeocodeProvider"

    invoke-virtual {v2, v5}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 157
    invoke-virtual {v2, p1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 158
    invoke-virtual {v2, p2, p3}, Landroid/os/Parcel;->writeDouble(D)V

    .line 159
    invoke-virtual {v2, p4, p5}, Landroid/os/Parcel;->writeDouble(D)V

    .line 160
    invoke-virtual {v2, p6, p7}, Landroid/os/Parcel;->writeDouble(D)V

    .line 161
    move-wide/from16 v0, p8

    invoke-virtual {v2, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    .line 162
    move/from16 v0, p10

    invoke-virtual {v2, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 163
    if-eqz p11, :cond_4b

    .line 164
    const/4 v5, 0x1

    invoke-virtual {v2, v5}, Landroid/os/Parcel;->writeInt(I)V

    .line 165
    const/4 v5, 0x0

    move-object/from16 v0, p11

    invoke-virtual {v0, v2, v5}, Landroid/location/GeocoderParams;->writeToParcel(Landroid/os/Parcel;I)V

    .line 170
    :goto_2f
    iget-object v5, p0, Landroid/location/IGeocodeProvider$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v6, 0x2

    const/4 v7, 0x0

    invoke-interface {v5, v6, v2, v3, v7}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 171
    invoke-virtual {v3}, Landroid/os/Parcel;->readException()V

    .line 172
    invoke-virtual {v3}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    .line 173
    .local v4, _result:Ljava/lang/String;
    sget-object v5, Landroid/location/Address;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p12

    invoke-virtual {v3, v0, v5}, Landroid/os/Parcel;->readTypedList(Ljava/util/List;Landroid/os/Parcelable$Creator;)V
    :try_end_44
    .catchall {:try_start_8 .. :try_end_44} :catchall_50

    .line 176
    invoke-virtual {v3}, Landroid/os/Parcel;->recycle()V

    .line 177
    invoke-virtual {v2}, Landroid/os/Parcel;->recycle()V

    .line 179
    return-object v4

    .line 168
    .end local v4           #_result:Ljava/lang/String;
    :cond_4b
    const/4 v5, 0x0

    :try_start_4c
    invoke-virtual {v2, v5}, Landroid/os/Parcel;->writeInt(I)V
    :try_end_4f
    .catchall {:try_start_4c .. :try_end_4f} :catchall_50

    goto :goto_2f

    .line 176
    :catchall_50
    move-exception v5

    invoke-virtual {v3}, Landroid/os/Parcel;->recycle()V

    .line 177
    invoke-virtual {v2}, Landroid/os/Parcel;->recycle()V

    .line 176
    throw v5
.end method

.method public getInterfaceDescriptor()Ljava/lang/String;
    .registers 2

    .prologue
    .line 120
    const-string v0, "android.location.IGeocodeProvider"

    return-object v0
.end method
