.class public abstract Landroid/telephony/CellLocation;
.super Ljava/lang/Object;
.source "CellLocation.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getEmpty()Landroid/telephony/CellLocation;
    .registers 1

    .prologue
    invoke-static {}, Landroid/telephony/TelephonyManager;->getDefault()Landroid/telephony/TelephonyManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getCurrentPhoneType()I

    move-result v0

    packed-switch v0, :pswitch_data_1a

    const/4 v0, 0x0

    :goto_c
    return-object v0

    :pswitch_d
    new-instance v0, Landroid/telephony/cdma/CdmaCellLocation;

    invoke-direct {v0}, Landroid/telephony/cdma/CdmaCellLocation;-><init>()V

    goto :goto_c

    :pswitch_13
    new-instance v0, Landroid/telephony/gsm/GsmCellLocation;

    invoke-direct {v0}, Landroid/telephony/gsm/GsmCellLocation;-><init>()V

    goto :goto_c

    nop

    :pswitch_data_1a
    .packed-switch 0x1
        :pswitch_13
        :pswitch_d
    .end packed-switch
.end method

.method public static newFromBundle(Landroid/os/Bundle;)Landroid/telephony/CellLocation;
    .registers 2
    .parameter "bundle"

    .prologue
    invoke-static {}, Landroid/telephony/TelephonyManager;->getDefault()Landroid/telephony/TelephonyManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getCurrentPhoneType()I

    move-result v0

    packed-switch v0, :pswitch_data_1a

    const/4 v0, 0x0

    :goto_c
    return-object v0

    :pswitch_d
    new-instance v0, Landroid/telephony/cdma/CdmaCellLocation;

    invoke-direct {v0, p0}, Landroid/telephony/cdma/CdmaCellLocation;-><init>(Landroid/os/Bundle;)V

    goto :goto_c

    :pswitch_13
    new-instance v0, Landroid/telephony/gsm/GsmCellLocation;

    invoke-direct {v0, p0}, Landroid/telephony/gsm/GsmCellLocation;-><init>(Landroid/os/Bundle;)V

    goto :goto_c

    nop

    :pswitch_data_1a
    .packed-switch 0x1
        :pswitch_13
        :pswitch_d
    .end packed-switch
.end method

.method public static requestLocationUpdate()V
    .registers 2

    .prologue
    :try_start_0
    const-string/jumbo v1, "phone"

    invoke-static {v1}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Lcom/android/internal/telephony/ITelephony$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/telephony/ITelephony;

    move-result-object v0

    .local v0, phone:Lcom/android/internal/telephony/ITelephony;
    if-eqz v0, :cond_10

    invoke-interface {v0}, Lcom/android/internal/telephony/ITelephony;->updateServiceLocation()V
    :try_end_10
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_10} :catch_11

    :cond_10
    :goto_10
    return-void

    :catch_11
    move-exception v1

    goto :goto_10
.end method


# virtual methods
.method public abstract fillInNotifierBundle(Landroid/os/Bundle;)V
.end method

.method public abstract isEmpty()Z
.end method
