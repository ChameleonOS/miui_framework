.class final Landroid/location/Address$1;
.super Ljava/lang/Object;
.source "Address.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/location/Address;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Landroid/location/Address;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 476
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/location/Address;
    .registers 15
    .parameter "in"

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 478
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    .line 479
    .local v5, language:Ljava/lang/String;
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 480
    .local v2, country:Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_4c

    new-instance v7, Ljava/util/Locale;

    invoke-direct {v7, v5, v2}, Ljava/util/Locale;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 483
    .local v7, locale:Ljava/util/Locale;
    :goto_15
    new-instance v1, Landroid/location/Address;

    invoke-direct {v1, v7}, Landroid/location/Address;-><init>(Ljava/util/Locale;)V

    .line 485
    .local v1, a:Landroid/location/Address;
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 486
    .local v0, N:I
    if-lez v0, :cond_52

    .line 487
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8, v0}, Ljava/util/HashMap;-><init>(I)V

    #setter for: Landroid/location/Address;->mAddressLines:Ljava/util/HashMap;
    invoke-static {v1, v8}, Landroid/location/Address;->access$002(Landroid/location/Address;Ljava/util/HashMap;)Ljava/util/HashMap;

    .line 488
    const/4 v3, 0x0

    .local v3, i:I
    :goto_29
    if-ge v3, v0, :cond_5a

    .line 489
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v4

    .line 490
    .local v4, index:I
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v6

    .line 491
    .local v6, line:Ljava/lang/String;
    #getter for: Landroid/location/Address;->mAddressLines:Ljava/util/HashMap;
    invoke-static {v1}, Landroid/location/Address;->access$000(Landroid/location/Address;)Ljava/util/HashMap;

    move-result-object v8

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v8, v11, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 492
    #getter for: Landroid/location/Address;->mMaxAddressLineIndex:I
    invoke-static {v1}, Landroid/location/Address;->access$100(Landroid/location/Address;)I

    move-result v8

    invoke-static {v8, v4}, Ljava/lang/Math;->max(II)I

    move-result v8

    #setter for: Landroid/location/Address;->mMaxAddressLineIndex:I
    invoke-static {v1, v8}, Landroid/location/Address;->access$102(Landroid/location/Address;I)I

    .line 488
    add-int/lit8 v3, v3, 0x1

    goto :goto_29

    .line 480
    .end local v0           #N:I
    .end local v1           #a:Landroid/location/Address;
    .end local v3           #i:I
    .end local v4           #index:I
    .end local v6           #line:Ljava/lang/String;
    .end local v7           #locale:Ljava/util/Locale;
    :cond_4c
    new-instance v7, Ljava/util/Locale;

    invoke-direct {v7, v5}, Ljava/util/Locale;-><init>(Ljava/lang/String;)V

    goto :goto_15

    .line 496
    .restart local v0       #N:I
    .restart local v1       #a:Landroid/location/Address;
    .restart local v7       #locale:Ljava/util/Locale;
    :cond_52
    const/4 v8, 0x0

    #setter for: Landroid/location/Address;->mAddressLines:Ljava/util/HashMap;
    invoke-static {v1, v8}, Landroid/location/Address;->access$002(Landroid/location/Address;Ljava/util/HashMap;)Ljava/util/HashMap;

    .line 497
    const/4 v8, -0x1

    #setter for: Landroid/location/Address;->mMaxAddressLineIndex:I
    invoke-static {v1, v8}, Landroid/location/Address;->access$102(Landroid/location/Address;I)I

    .line 499
    :cond_5a
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v8

    #setter for: Landroid/location/Address;->mFeatureName:Ljava/lang/String;
    invoke-static {v1, v8}, Landroid/location/Address;->access$202(Landroid/location/Address;Ljava/lang/String;)Ljava/lang/String;

    .line 500
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v8

    #setter for: Landroid/location/Address;->mAdminArea:Ljava/lang/String;
    invoke-static {v1, v8}, Landroid/location/Address;->access$302(Landroid/location/Address;Ljava/lang/String;)Ljava/lang/String;

    .line 501
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v8

    #setter for: Landroid/location/Address;->mSubAdminArea:Ljava/lang/String;
    invoke-static {v1, v8}, Landroid/location/Address;->access$402(Landroid/location/Address;Ljava/lang/String;)Ljava/lang/String;

    .line 502
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v8

    #setter for: Landroid/location/Address;->mLocality:Ljava/lang/String;
    invoke-static {v1, v8}, Landroid/location/Address;->access$502(Landroid/location/Address;Ljava/lang/String;)Ljava/lang/String;

    .line 503
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v8

    #setter for: Landroid/location/Address;->mSubLocality:Ljava/lang/String;
    invoke-static {v1, v8}, Landroid/location/Address;->access$602(Landroid/location/Address;Ljava/lang/String;)Ljava/lang/String;

    .line 504
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v8

    #setter for: Landroid/location/Address;->mThoroughfare:Ljava/lang/String;
    invoke-static {v1, v8}, Landroid/location/Address;->access$702(Landroid/location/Address;Ljava/lang/String;)Ljava/lang/String;

    .line 505
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v8

    #setter for: Landroid/location/Address;->mSubThoroughfare:Ljava/lang/String;
    invoke-static {v1, v8}, Landroid/location/Address;->access$802(Landroid/location/Address;Ljava/lang/String;)Ljava/lang/String;

    .line 506
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v8

    #setter for: Landroid/location/Address;->mPremises:Ljava/lang/String;
    invoke-static {v1, v8}, Landroid/location/Address;->access$902(Landroid/location/Address;Ljava/lang/String;)Ljava/lang/String;

    .line 507
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v8

    #setter for: Landroid/location/Address;->mPostalCode:Ljava/lang/String;
    invoke-static {v1, v8}, Landroid/location/Address;->access$1002(Landroid/location/Address;Ljava/lang/String;)Ljava/lang/String;

    .line 508
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v8

    #setter for: Landroid/location/Address;->mCountryCode:Ljava/lang/String;
    invoke-static {v1, v8}, Landroid/location/Address;->access$1102(Landroid/location/Address;Ljava/lang/String;)Ljava/lang/String;

    .line 509
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v8

    #setter for: Landroid/location/Address;->mCountryName:Ljava/lang/String;
    invoke-static {v1, v8}, Landroid/location/Address;->access$1202(Landroid/location/Address;Ljava/lang/String;)Ljava/lang/String;

    .line 510
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v8

    if-nez v8, :cond_ea

    move v8, v9

    :goto_ae
    #setter for: Landroid/location/Address;->mHasLatitude:Z
    invoke-static {v1, v8}, Landroid/location/Address;->access$1302(Landroid/location/Address;Z)Z

    .line 511
    #getter for: Landroid/location/Address;->mHasLatitude:Z
    invoke-static {v1}, Landroid/location/Address;->access$1300(Landroid/location/Address;)Z

    move-result v8

    if-eqz v8, :cond_be

    .line 512
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v11

    #setter for: Landroid/location/Address;->mLatitude:D
    invoke-static {v1, v11, v12}, Landroid/location/Address;->access$1402(Landroid/location/Address;D)D

    .line 514
    :cond_be
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v8

    if-nez v8, :cond_ec

    :goto_c4
    #setter for: Landroid/location/Address;->mHasLongitude:Z
    invoke-static {v1, v9}, Landroid/location/Address;->access$1502(Landroid/location/Address;Z)Z

    .line 515
    #getter for: Landroid/location/Address;->mHasLongitude:Z
    invoke-static {v1}, Landroid/location/Address;->access$1500(Landroid/location/Address;)Z

    move-result v8

    if-eqz v8, :cond_d4

    .line 516
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v8

    #setter for: Landroid/location/Address;->mLongitude:D
    invoke-static {v1, v8, v9}, Landroid/location/Address;->access$1602(Landroid/location/Address;D)D

    .line 518
    :cond_d4
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v8

    #setter for: Landroid/location/Address;->mPhone:Ljava/lang/String;
    invoke-static {v1, v8}, Landroid/location/Address;->access$1702(Landroid/location/Address;Ljava/lang/String;)Ljava/lang/String;

    .line 519
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v8

    #setter for: Landroid/location/Address;->mUrl:Ljava/lang/String;
    invoke-static {v1, v8}, Landroid/location/Address;->access$1802(Landroid/location/Address;Ljava/lang/String;)Ljava/lang/String;

    .line 520
    invoke-virtual {p1}, Landroid/os/Parcel;->readBundle()Landroid/os/Bundle;

    move-result-object v8

    #setter for: Landroid/location/Address;->mExtras:Landroid/os/Bundle;
    invoke-static {v1, v8}, Landroid/location/Address;->access$1902(Landroid/location/Address;Landroid/os/Bundle;)Landroid/os/Bundle;

    .line 521
    return-object v1

    :cond_ea
    move v8, v10

    .line 510
    goto :goto_ae

    :cond_ec
    move v9, v10

    .line 514
    goto :goto_c4
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 476
    invoke-virtual {p0, p1}, Landroid/location/Address$1;->createFromParcel(Landroid/os/Parcel;)Landroid/location/Address;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/location/Address;
    .registers 3
    .parameter "size"

    .prologue
    .line 525
    new-array v0, p1, [Landroid/location/Address;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 476
    invoke-virtual {p0, p1}, Landroid/location/Address$1;->newArray(I)[Landroid/location/Address;

    move-result-object v0

    return-object v0
.end method
