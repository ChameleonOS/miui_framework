.class public Landroid/net/sip/SipProfile$Builder;
.super Ljava/lang/Object;
.source "SipProfile.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/sip/SipProfile;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private mAddressFactory:Ljavax/sip/address/AddressFactory;

.field private mDisplayName:Ljava/lang/String;

.field private mProfile:Landroid/net/sip/SipProfile;

.field private mProxyAddress:Ljava/lang/String;

.field private mUri:Ljavax/sip/address/SipURI;


# direct methods
.method public constructor <init>(Landroid/net/sip/SipProfile;)V
    .registers 5
    .parameter "profile"

    .prologue
    const/4 v2, 0x0

    .line 98
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 81
    new-instance v1, Landroid/net/sip/SipProfile;

    invoke-direct {v1, v2}, Landroid/net/sip/SipProfile;-><init>(Landroid/net/sip/SipProfile$1;)V

    iput-object v1, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    .line 88
    :try_start_b
    invoke-static {}, Ljavax/sip/SipFactory;->getInstance()Ljavax/sip/SipFactory;

    move-result-object v1

    invoke-virtual {v1}, Ljavax/sip/SipFactory;->createAddressFactory()Ljavax/sip/address/AddressFactory;

    move-result-object v1

    iput-object v1, p0, Landroid/net/sip/SipProfile$Builder;->mAddressFactory:Ljavax/sip/address/AddressFactory;
    :try_end_15
    .catch Ljavax/sip/PeerUnavailableException; {:try_start_b .. :try_end_15} :catch_1d

    .line 99
    if-nez p1, :cond_24

    new-instance v1, Ljava/lang/NullPointerException;

    invoke-direct {v1}, Ljava/lang/NullPointerException;-><init>()V

    throw v1

    .line 90
    :catch_1d
    move-exception v0

    .line 91
    .local v0, e:Ljavax/sip/PeerUnavailableException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 101
    .end local v0           #e:Ljavax/sip/PeerUnavailableException;
    :cond_24
    :try_start_24
    #calls: Ljava/lang/Object;->clone()Ljava/lang/Object;
    invoke-static {p1}, Landroid/net/sip/SipProfile;->access$200(Landroid/net/sip/SipProfile;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/sip/SipProfile;

    iput-object v1, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;
    :try_end_2c
    .catch Ljava/lang/CloneNotSupportedException; {:try_start_24 .. :try_end_2c} :catch_56

    .line 105
    iget-object v1, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    #setter for: Landroid/net/sip/SipProfile;->mAddress:Ljavax/sip/address/Address;
    invoke-static {v1, v2}, Landroid/net/sip/SipProfile;->access$302(Landroid/net/sip/SipProfile;Ljavax/sip/address/Address;)Ljavax/sip/address/Address;

    .line 106
    invoke-virtual {p1}, Landroid/net/sip/SipProfile;->getUri()Ljavax/sip/address/SipURI;

    move-result-object v1

    iput-object v1, p0, Landroid/net/sip/SipProfile$Builder;->mUri:Ljavax/sip/address/SipURI;

    .line 107
    iget-object v1, p0, Landroid/net/sip/SipProfile$Builder;->mUri:Ljavax/sip/address/SipURI;

    invoke-virtual {p1}, Landroid/net/sip/SipProfile;->getPassword()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ljavax/sip/address/SipURI;->setUserPassword(Ljava/lang/String;)V

    .line 108
    invoke-virtual {p1}, Landroid/net/sip/SipProfile;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/net/sip/SipProfile$Builder;->mDisplayName:Ljava/lang/String;

    .line 109
    invoke-virtual {p1}, Landroid/net/sip/SipProfile;->getProxyAddress()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/net/sip/SipProfile$Builder;->mProxyAddress:Ljava/lang/String;

    .line 110
    iget-object v1, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    invoke-virtual {p1}, Landroid/net/sip/SipProfile;->getPort()I

    move-result v2

    #setter for: Landroid/net/sip/SipProfile;->mPort:I
    invoke-static {v1, v2}, Landroid/net/sip/SipProfile;->access$402(Landroid/net/sip/SipProfile;I)I

    .line 111
    return-void

    .line 102
    :catch_56
    move-exception v0

    .line 103
    .local v0, e:Ljava/lang/CloneNotSupportedException;
    new-instance v1, Ljava/lang/RuntimeException;

    const-string/jumbo v2, "should not occur"

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 7
    .parameter "uriString"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/text/ParseException;
        }
    .end annotation

    .prologue
    .line 119
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 81
    new-instance v2, Landroid/net/sip/SipProfile;

    const/4 v3, 0x0

    invoke-direct {v2, v3}, Landroid/net/sip/SipProfile;-><init>(Landroid/net/sip/SipProfile$1;)V

    iput-object v2, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    .line 88
    :try_start_b
    invoke-static {}, Ljavax/sip/SipFactory;->getInstance()Ljavax/sip/SipFactory;

    move-result-object v2

    invoke-virtual {v2}, Ljavax/sip/SipFactory;->createAddressFactory()Ljavax/sip/address/AddressFactory;

    move-result-object v2

    iput-object v2, p0, Landroid/net/sip/SipProfile$Builder;->mAddressFactory:Ljavax/sip/address/AddressFactory;
    :try_end_15
    .catch Ljavax/sip/PeerUnavailableException; {:try_start_b .. :try_end_15} :catch_20

    .line 120
    if-nez p1, :cond_27

    .line 121
    new-instance v2, Ljava/lang/NullPointerException;

    const-string/jumbo v3, "uriString cannot be null"

    invoke-direct {v2, v3}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 90
    :catch_20
    move-exception v0

    .line 91
    .local v0, e:Ljavax/sip/PeerUnavailableException;
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    .line 123
    .end local v0           #e:Ljavax/sip/PeerUnavailableException;
    :cond_27
    iget-object v2, p0, Landroid/net/sip/SipProfile$Builder;->mAddressFactory:Ljavax/sip/address/AddressFactory;

    invoke-direct {p0, p1}, Landroid/net/sip/SipProfile$Builder;->fix(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljavax/sip/address/AddressFactory;->createURI(Ljava/lang/String;)Ljavax/sip/address/URI;

    move-result-object v1

    .line 124
    .local v1, uri:Ljavax/sip/address/URI;
    instance-of v2, v1, Ljavax/sip/address/SipURI;

    if-eqz v2, :cond_45

    .line 125
    check-cast v1, Ljavax/sip/address/SipURI;

    .end local v1           #uri:Ljavax/sip/address/URI;
    iput-object v1, p0, Landroid/net/sip/SipProfile$Builder;->mUri:Ljavax/sip/address/SipURI;

    .line 129
    iget-object v2, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    iget-object v3, p0, Landroid/net/sip/SipProfile$Builder;->mUri:Ljavax/sip/address/SipURI;

    invoke-interface {v3}, Ljavax/sip/address/SipURI;->getHost()Ljava/lang/String;

    move-result-object v3

    #setter for: Landroid/net/sip/SipProfile;->mDomain:Ljava/lang/String;
    invoke-static {v2, v3}, Landroid/net/sip/SipProfile;->access$502(Landroid/net/sip/SipProfile;Ljava/lang/String;)Ljava/lang/String;

    .line 130
    return-void

    .line 127
    .restart local v1       #uri:Ljavax/sip/address/URI;
    :cond_45
    new-instance v2, Ljava/text/ParseException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " is not a SIP URI"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-direct {v2, v3, v4}, Ljava/text/ParseException;-><init>(Ljava/lang/String;I)V

    throw v2
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .registers 6
    .parameter "username"
    .parameter "serverDomain"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/text/ParseException;
        }
    .end annotation

    .prologue
    .line 142
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 81
    new-instance v1, Landroid/net/sip/SipProfile;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Landroid/net/sip/SipProfile;-><init>(Landroid/net/sip/SipProfile$1;)V

    iput-object v1, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    .line 88
    :try_start_b
    invoke-static {}, Ljavax/sip/SipFactory;->getInstance()Ljavax/sip/SipFactory;

    move-result-object v1

    invoke-virtual {v1}, Ljavax/sip/SipFactory;->createAddressFactory()Ljavax/sip/address/AddressFactory;

    move-result-object v1

    iput-object v1, p0, Landroid/net/sip/SipProfile$Builder;->mAddressFactory:Ljavax/sip/address/AddressFactory;
    :try_end_15
    .catch Ljavax/sip/PeerUnavailableException; {:try_start_b .. :try_end_15} :catch_22

    .line 143
    if-eqz p1, :cond_19

    if-nez p2, :cond_29

    .line 144
    :cond_19
    new-instance v1, Ljava/lang/NullPointerException;

    const-string/jumbo v2, "username and serverDomain cannot be null"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 90
    :catch_22
    move-exception v0

    .line 91
    .local v0, e:Ljavax/sip/PeerUnavailableException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 147
    .end local v0           #e:Ljavax/sip/PeerUnavailableException;
    :cond_29
    iget-object v1, p0, Landroid/net/sip/SipProfile$Builder;->mAddressFactory:Ljavax/sip/address/AddressFactory;

    invoke-interface {v1, p1, p2}, Ljavax/sip/address/AddressFactory;->createSipURI(Ljava/lang/String;Ljava/lang/String;)Ljavax/sip/address/SipURI;

    move-result-object v1

    iput-object v1, p0, Landroid/net/sip/SipProfile$Builder;->mUri:Ljavax/sip/address/SipURI;

    .line 148
    iget-object v1, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    #setter for: Landroid/net/sip/SipProfile;->mDomain:Ljava/lang/String;
    invoke-static {v1, p2}, Landroid/net/sip/SipProfile;->access$502(Landroid/net/sip/SipProfile;Ljava/lang/String;)Ljava/lang/String;

    .line 149
    return-void
.end method

.method private fix(Ljava/lang/String;)Ljava/lang/String;
    .registers 4
    .parameter "uriString"

    .prologue
    .line 152
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "sip:"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_12

    .end local p1
    :goto_11
    return-object p1

    .restart local p1
    :cond_12
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "sip:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_11
.end method


# virtual methods
.method public build()Landroid/net/sip/SipProfile;
    .registers 7

    .prologue
    .line 281
    iget-object v2, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    iget-object v3, p0, Landroid/net/sip/SipProfile$Builder;->mUri:Ljavax/sip/address/SipURI;

    invoke-interface {v3}, Ljavax/sip/address/SipURI;->getUserPassword()Ljava/lang/String;

    move-result-object v3

    #setter for: Landroid/net/sip/SipProfile;->mPassword:Ljava/lang/String;
    invoke-static {v2, v3}, Landroid/net/sip/SipProfile;->access$1102(Landroid/net/sip/SipProfile;Ljava/lang/String;)Ljava/lang/String;

    .line 282
    iget-object v2, p0, Landroid/net/sip/SipProfile$Builder;->mUri:Ljavax/sip/address/SipURI;

    const/4 v3, 0x0

    invoke-interface {v2, v3}, Ljavax/sip/address/SipURI;->setUserPassword(Ljava/lang/String;)V

    .line 284
    :try_start_11
    iget-object v2, p0, Landroid/net/sip/SipProfile$Builder;->mProxyAddress:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_42

    .line 285
    iget-object v2, p0, Landroid/net/sip/SipProfile$Builder;->mAddressFactory:Ljavax/sip/address/AddressFactory;

    iget-object v3, p0, Landroid/net/sip/SipProfile$Builder;->mProxyAddress:Ljava/lang/String;

    invoke-direct {p0, v3}, Landroid/net/sip/SipProfile$Builder;->fix(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljavax/sip/address/AddressFactory;->createURI(Ljava/lang/String;)Ljavax/sip/address/URI;

    move-result-object v1

    check-cast v1, Ljavax/sip/address/SipURI;

    .line 287
    .local v1, uri:Ljavax/sip/address/SipURI;
    iget-object v2, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    invoke-interface {v1}, Ljavax/sip/address/SipURI;->getHost()Ljava/lang/String;

    move-result-object v3

    #setter for: Landroid/net/sip/SipProfile;->mProxyAddress:Ljava/lang/String;
    invoke-static {v2, v3}, Landroid/net/sip/SipProfile;->access$1202(Landroid/net/sip/SipProfile;Ljava/lang/String;)Ljava/lang/String;

    .line 296
    .end local v1           #uri:Ljavax/sip/address/SipURI;
    :cond_30
    :goto_30
    iget-object v2, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    iget-object v3, p0, Landroid/net/sip/SipProfile$Builder;->mAddressFactory:Ljavax/sip/address/AddressFactory;

    iget-object v4, p0, Landroid/net/sip/SipProfile$Builder;->mDisplayName:Ljava/lang/String;

    iget-object v5, p0, Landroid/net/sip/SipProfile$Builder;->mUri:Ljavax/sip/address/SipURI;

    invoke-interface {v3, v4, v5}, Ljavax/sip/address/AddressFactory;->createAddress(Ljava/lang/String;Ljavax/sip/address/URI;)Ljavax/sip/address/Address;

    move-result-object v3

    #setter for: Landroid/net/sip/SipProfile;->mAddress:Ljavax/sip/address/Address;
    invoke-static {v2, v3}, Landroid/net/sip/SipProfile;->access$302(Landroid/net/sip/SipProfile;Ljavax/sip/address/Address;)Ljavax/sip/address/Address;
    :try_end_3f
    .catch Ljavax/sip/InvalidArgumentException; {:try_start_11 .. :try_end_3f} :catch_71
    .catch Ljava/text/ParseException; {:try_start_11 .. :try_end_3f} :catch_78

    .line 304
    iget-object v2, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    return-object v2

    .line 289
    :cond_42
    :try_start_42
    iget-object v2, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    #getter for: Landroid/net/sip/SipProfile;->mProtocol:Ljava/lang/String;
    invoke-static {v2}, Landroid/net/sip/SipProfile;->access$800(Landroid/net/sip/SipProfile;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "UDP"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5b

    .line 290
    iget-object v2, p0, Landroid/net/sip/SipProfile$Builder;->mUri:Ljavax/sip/address/SipURI;

    iget-object v3, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    #getter for: Landroid/net/sip/SipProfile;->mProtocol:Ljava/lang/String;
    invoke-static {v3}, Landroid/net/sip/SipProfile;->access$800(Landroid/net/sip/SipProfile;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljavax/sip/address/SipURI;->setTransportParam(Ljava/lang/String;)V

    .line 292
    :cond_5b
    iget-object v2, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    #getter for: Landroid/net/sip/SipProfile;->mPort:I
    invoke-static {v2}, Landroid/net/sip/SipProfile;->access$400(Landroid/net/sip/SipProfile;)I

    move-result v2

    const/16 v3, 0x13c4

    if-eq v2, v3, :cond_30

    .line 293
    iget-object v2, p0, Landroid/net/sip/SipProfile$Builder;->mUri:Ljavax/sip/address/SipURI;

    iget-object v3, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    #getter for: Landroid/net/sip/SipProfile;->mPort:I
    invoke-static {v3}, Landroid/net/sip/SipProfile;->access$400(Landroid/net/sip/SipProfile;)I

    move-result v3

    invoke-interface {v2, v3}, Ljavax/sip/address/SipURI;->setPort(I)V
    :try_end_70
    .catch Ljavax/sip/InvalidArgumentException; {:try_start_42 .. :try_end_70} :catch_71
    .catch Ljava/text/ParseException; {:try_start_42 .. :try_end_70} :catch_78

    goto :goto_30

    .line 298
    :catch_71
    move-exception v0

    .line 299
    .local v0, e:Ljavax/sip/InvalidArgumentException;
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    .line 300
    .end local v0           #e:Ljavax/sip/InvalidArgumentException;
    :catch_78
    move-exception v0

    .line 302
    .local v0, e:Ljava/text/ParseException;
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method public setAuthUserName(Ljava/lang/String;)Landroid/net/sip/SipProfile$Builder;
    .registers 3
    .parameter "name"

    .prologue
    .line 164
    iget-object v0, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    #setter for: Landroid/net/sip/SipProfile;->mAuthUserName:Ljava/lang/String;
    invoke-static {v0, p1}, Landroid/net/sip/SipProfile;->access$602(Landroid/net/sip/SipProfile;Ljava/lang/String;)Ljava/lang/String;

    .line 165
    return-object p0
.end method

.method public setAutoRegistration(Z)Landroid/net/sip/SipProfile$Builder;
    .registers 3
    .parameter "flag"

    .prologue
    .line 270
    iget-object v0, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    #setter for: Landroid/net/sip/SipProfile;->mAutoRegistration:Z
    invoke-static {v0, p1}, Landroid/net/sip/SipProfile;->access$1002(Landroid/net/sip/SipProfile;Z)Z

    .line 271
    return-object p0
.end method

.method public setDisplayName(Ljava/lang/String;)Landroid/net/sip/SipProfile$Builder;
    .registers 2
    .parameter "displayName"

    .prologue
    .line 245
    iput-object p1, p0, Landroid/net/sip/SipProfile$Builder;->mDisplayName:Ljava/lang/String;

    .line 246
    return-object p0
.end method

.method public setOutboundProxy(Ljava/lang/String;)Landroid/net/sip/SipProfile$Builder;
    .registers 2
    .parameter "outboundProxy"

    .prologue
    .line 234
    iput-object p1, p0, Landroid/net/sip/SipProfile$Builder;->mProxyAddress:Ljava/lang/String;

    .line 235
    return-object p0
.end method

.method public setPassword(Ljava/lang/String;)Landroid/net/sip/SipProfile$Builder;
    .registers 3
    .parameter "password"

    .prologue
    .line 186
    iget-object v0, p0, Landroid/net/sip/SipProfile$Builder;->mUri:Ljavax/sip/address/SipURI;

    invoke-interface {v0, p1}, Ljavax/sip/address/SipURI;->setUserPassword(Ljava/lang/String;)V

    .line 187
    return-object p0
.end method

.method public setPort(I)Landroid/net/sip/SipProfile$Builder;
    .registers 5
    .parameter "port"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 198
    const v0, 0xffff

    if-gt p1, v0, :cond_9

    const/16 v0, 0x3e8

    if-ge p1, v0, :cond_22

    .line 199
    :cond_9
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "incorrect port arugment: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 201
    :cond_22
    iget-object v0, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    #setter for: Landroid/net/sip/SipProfile;->mPort:I
    invoke-static {v0, p1}, Landroid/net/sip/SipProfile;->access$402(Landroid/net/sip/SipProfile;I)I

    .line 202
    return-object p0
.end method

.method public setProfileName(Ljava/lang/String;)Landroid/net/sip/SipProfile$Builder;
    .registers 3
    .parameter "name"

    .prologue
    .line 175
    iget-object v0, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    #setter for: Landroid/net/sip/SipProfile;->mProfileName:Ljava/lang/String;
    invoke-static {v0, p1}, Landroid/net/sip/SipProfile;->access$702(Landroid/net/sip/SipProfile;Ljava/lang/String;)Ljava/lang/String;

    .line 176
    return-object p0
.end method

.method public setProtocol(Ljava/lang/String;)Landroid/net/sip/SipProfile$Builder;
    .registers 5
    .parameter "protocol"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 215
    if-nez p1, :cond_b

    .line 216
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "protocol cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 218
    :cond_b
    invoke-virtual {p1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object p1

    .line 219
    const-string v0, "UDP"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_39

    const-string v0, "TCP"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_39

    .line 220
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "unsupported protocol: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 223
    :cond_39
    iget-object v0, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    #setter for: Landroid/net/sip/SipProfile;->mProtocol:Ljava/lang/String;
    invoke-static {v0, p1}, Landroid/net/sip/SipProfile;->access$802(Landroid/net/sip/SipProfile;Ljava/lang/String;)Ljava/lang/String;

    .line 224
    return-object p0
.end method

.method public setSendKeepAlive(Z)Landroid/net/sip/SipProfile$Builder;
    .registers 3
    .parameter "flag"

    .prologue
    .line 257
    iget-object v0, p0, Landroid/net/sip/SipProfile$Builder;->mProfile:Landroid/net/sip/SipProfile;

    #setter for: Landroid/net/sip/SipProfile;->mSendKeepAlive:Z
    invoke-static {v0, p1}, Landroid/net/sip/SipProfile;->access$902(Landroid/net/sip/SipProfile;Z)Z

    .line 258
    return-object p0
.end method
