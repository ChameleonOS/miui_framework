.class public final Landroid/security/KeyChain;
.super Ljava/lang/Object;
.source "KeyChain.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/security/KeyChain$KeyChainConnection;,
        Landroid/security/KeyChain$AliasResponse;
    }
.end annotation


# static fields
.field public static final ACCOUNT_TYPE:Ljava/lang/String; = "com.android.keychain"

.field private static final ACTION_CHOOSER:Ljava/lang/String; = "com.android.keychain.CHOOSER"

.field private static final ACTION_INSTALL:Ljava/lang/String; = "android.credentials.INSTALL"

.field public static final ACTION_STORAGE_CHANGED:Ljava/lang/String; = "android.security.STORAGE_CHANGED"

.field public static final EXTRA_ALIAS:Ljava/lang/String; = "alias"

.field public static final EXTRA_CERTIFICATE:Ljava/lang/String; = "CERT"

.field public static final EXTRA_HOST:Ljava/lang/String; = "host"

.field public static final EXTRA_NAME:Ljava/lang/String; = "name"

.field public static final EXTRA_PKCS12:Ljava/lang/String; = "PKCS12"

.field public static final EXTRA_PORT:Ljava/lang/String; = "port"

.field public static final EXTRA_RESPONSE:Ljava/lang/String; = "response"

.field public static final EXTRA_SENDER:Ljava/lang/String; = "sender"

.field private static final TAG:Ljava/lang/String; = "KeyChain"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 85
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 386
    return-void
.end method

.method public static bind(Landroid/content/Context;)Landroid/security/KeyChain$KeyChainConnection;
    .registers 7
    .parameter "context"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    .line 411
    if-nez p0, :cond_b

    .line 412
    new-instance v3, Ljava/lang/NullPointerException;

    const-string v4, "context == null"

    invoke-direct {v3, v4}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 414
    :cond_b
    invoke-static {p0}, Landroid/security/KeyChain;->ensureNotOnMainThread(Landroid/content/Context;)V

    .line 415
    new-instance v2, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v2, v5}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>(I)V

    .line 416
    .local v2, q:Ljava/util/concurrent/BlockingQueue;,"Ljava/util/concurrent/BlockingQueue<Landroid/security/IKeyChainService;>;"
    new-instance v1, Landroid/security/KeyChain$1;

    invoke-direct {v1, v2}, Landroid/security/KeyChain$1;-><init>(Ljava/util/concurrent/BlockingQueue;)V

    .line 430
    .local v1, keyChainServiceConnection:Landroid/content/ServiceConnection;
    new-instance v3, Landroid/content/Intent;

    const-class v4, Landroid/security/IKeyChainService;

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v3, v1, v5}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result v0

    .line 433
    .local v0, isBound:Z
    if-nez v0, :cond_31

    .line 434
    new-instance v3, Ljava/lang/AssertionError;

    const-string v4, "could not bind to KeyChainService"

    invoke-direct {v3, v4}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v3

    .line 436
    :cond_31
    new-instance v4, Landroid/security/KeyChain$KeyChainConnection;

    invoke-interface {v2}, Ljava/util/concurrent/BlockingQueue;->take()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/security/IKeyChainService;

    const/4 v5, 0x0

    invoke-direct {v4, p0, v1, v3, v5}, Landroid/security/KeyChain$KeyChainConnection;-><init>(Landroid/content/Context;Landroid/content/ServiceConnection;Landroid/security/IKeyChainService;Landroid/security/KeyChain$1;)V

    return-object v4
.end method

.method public static choosePrivateKeyAlias(Landroid/app/Activity;Landroid/security/KeyChainAliasCallback;[Ljava/lang/String;[Ljava/security/Principal;Ljava/lang/String;ILjava/lang/String;)V
    .registers 12
    .parameter "activity"
    .parameter "response"
    .parameter "keyTypes"
    .parameter "issuers"
    .parameter "host"
    .parameter "port"
    .parameter "alias"

    .prologue
    const/4 v4, 0x0

    .line 266
    if-nez p0, :cond_b

    .line 267
    new-instance v1, Ljava/lang/NullPointerException;

    const-string v2, "activity == null"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 269
    :cond_b
    if-nez p1, :cond_16

    .line 270
    new-instance v1, Ljava/lang/NullPointerException;

    const-string/jumbo v2, "response == null"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 272
    :cond_16
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.android.keychain.CHOOSER"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 273
    .local v0, intent:Landroid/content/Intent;
    const-string/jumbo v1, "response"

    new-instance v2, Landroid/security/KeyChain$AliasResponse;

    const/4 v3, 0x0

    invoke-direct {v2, p1, v3}, Landroid/security/KeyChain$AliasResponse;-><init>(Landroid/security/KeyChainAliasCallback;Landroid/security/KeyChain$1;)V

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/IBinder;)Landroid/content/Intent;

    .line 274
    const-string v1, "host"

    invoke-virtual {v0, v1, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 275
    const-string/jumbo v1, "port"

    invoke-virtual {v0, v1, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 276
    const-string v1, "alias"

    invoke-virtual {v0, v1, p6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 278
    const-string/jumbo v1, "sender"

    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    invoke-static {p0, v4, v2, v4}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 279
    invoke-virtual {p0, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 280
    return-void
.end method

.method public static createInstallIntent()Landroid/content/Intent;
    .registers 3

    .prologue
    .line 206
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.credentials.INSTALL"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 207
    .local v0, intent:Landroid/content/Intent;
    const-string v1, "com.android.certinstaller"

    const-string v2, "com.android.certinstaller.CertInstallerMain"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 209
    return-object v0
.end method

.method private static ensureNotOnMainThread(Landroid/content/Context;)V
    .registers 4
    .parameter "context"

    .prologue
    .line 440
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    .line 441
    .local v0, looper:Landroid/os/Looper;
    if-eqz v0, :cond_14

    invoke-virtual {p0}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_14

    .line 442
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "calling this from your main thread can lead to deadlock"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 445
    :cond_14
    return-void
.end method

.method public static getCertificateChain(Landroid/content/Context;Ljava/lang/String;)[Ljava/security/cert/X509Certificate;
    .registers 13
    .parameter "context"
    .parameter "alias"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/security/KeyChainException;,
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 337
    if-nez p1, :cond_a

    .line 338
    new-instance v9, Ljava/lang/NullPointerException;

    const-string v10, "alias == null"

    invoke-direct {v9, v10}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 340
    :cond_a
    invoke-static {p0}, Landroid/security/KeyChain;->bind(Landroid/content/Context;)Landroid/security/KeyChain$KeyChainConnection;

    move-result-object v6

    .line 342
    .local v6, keyChainConnection:Landroid/security/KeyChain$KeyChainConnection;
    :try_start_e
    invoke-virtual {v6}, Landroid/security/KeyChain$KeyChainConnection;->getService()Landroid/security/IKeyChainService;

    move-result-object v7

    .line 343
    .local v7, keyChainService:Landroid/security/IKeyChainService;
    invoke-interface {v7, p1}, Landroid/security/IKeyChainService;->getCertificate(Ljava/lang/String;)[B

    move-result-object v1

    .line 344
    .local v1, certificateBytes:[B
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 345
    .local v2, chain:Ljava/util/List;,"Ljava/util/List<Ljava/security/cert/X509Certificate;>;"
    invoke-static {v1}, Landroid/security/KeyChain;->toCertificate([B)Ljava/security/cert/X509Certificate;

    move-result-object v9

    invoke-interface {v2, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 346
    new-instance v8, Lorg/apache/harmony/xnet/provider/jsse/TrustedCertificateStore;

    invoke-direct {v8}, Lorg/apache/harmony/xnet/provider/jsse/TrustedCertificateStore;-><init>()V

    .line 347
    .local v8, store:Lorg/apache/harmony/xnet/provider/jsse/TrustedCertificateStore;
    const/4 v4, 0x0

    .line 348
    .local v4, i:I
    :goto_28
    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/security/cert/X509Certificate;

    .line 349
    .local v0, cert:Ljava/security/cert/X509Certificate;
    invoke-virtual {v0}, Ljava/security/cert/X509Certificate;->getSubjectX500Principal()Ljavax/security/auth/x500/X500Principal;

    move-result-object v9

    invoke-virtual {v0}, Ljava/security/cert/X509Certificate;->getIssuerX500Principal()Ljavax/security/auth/x500/X500Principal;

    move-result-object v10

    invoke-static {v9, v10}, Llibcore/util/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_4c

    .line 358
    :cond_3c
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v9

    new-array v9, v9, [Ljava/security/cert/X509Certificate;

    invoke-interface {v2, v9}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v9

    check-cast v9, [Ljava/security/cert/X509Certificate;
    :try_end_48
    .catchall {:try_start_e .. :try_end_48} :catchall_5f
    .catch Landroid/os/RemoteException; {:try_start_e .. :try_end_48} :catch_58
    .catch Ljava/lang/RuntimeException; {:try_start_e .. :try_end_48} :catch_64

    .line 365
    invoke-virtual {v6}, Landroid/security/KeyChain$KeyChainConnection;->close()V

    .line 358
    return-object v9

    .line 352
    :cond_4c
    :try_start_4c
    invoke-virtual {v8, v0}, Lorg/apache/harmony/xnet/provider/jsse/TrustedCertificateStore;->findIssuer(Ljava/security/cert/X509Certificate;)Ljava/security/cert/X509Certificate;

    move-result-object v5

    .line 353
    .local v5, issuer:Ljava/security/cert/X509Certificate;
    if-eqz v5, :cond_3c

    .line 356
    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_55
    .catchall {:try_start_4c .. :try_end_55} :catchall_5f
    .catch Landroid/os/RemoteException; {:try_start_4c .. :try_end_55} :catch_58
    .catch Ljava/lang/RuntimeException; {:try_start_4c .. :try_end_55} :catch_64

    .line 347
    add-int/lit8 v4, v4, 0x1

    goto :goto_28

    .line 359
    .end local v0           #cert:Ljava/security/cert/X509Certificate;
    .end local v1           #certificateBytes:[B
    .end local v2           #chain:Ljava/util/List;,"Ljava/util/List<Ljava/security/cert/X509Certificate;>;"
    .end local v4           #i:I
    .end local v5           #issuer:Ljava/security/cert/X509Certificate;
    .end local v7           #keyChainService:Landroid/security/IKeyChainService;
    .end local v8           #store:Lorg/apache/harmony/xnet/provider/jsse/TrustedCertificateStore;
    :catch_58
    move-exception v3

    .line 360
    .local v3, e:Landroid/os/RemoteException;
    :try_start_59
    new-instance v9, Landroid/security/KeyChainException;

    invoke-direct {v9, v3}, Landroid/security/KeyChainException;-><init>(Ljava/lang/Throwable;)V

    throw v9
    :try_end_5f
    .catchall {:try_start_59 .. :try_end_5f} :catchall_5f

    .line 365
    .end local v3           #e:Landroid/os/RemoteException;
    :catchall_5f
    move-exception v9

    invoke-virtual {v6}, Landroid/security/KeyChain$KeyChainConnection;->close()V

    throw v9

    .line 361
    :catch_64
    move-exception v3

    .line 363
    .local v3, e:Ljava/lang/RuntimeException;
    :try_start_65
    new-instance v9, Landroid/security/KeyChainException;

    invoke-direct {v9, v3}, Landroid/security/KeyChainException;-><init>(Ljava/lang/Throwable;)V

    throw v9
    :try_end_6b
    .catchall {:try_start_65 .. :try_end_6b} :catchall_5f
.end method

.method public static getPrivateKey(Landroid/content/Context;Ljava/lang/String;)Ljava/security/PrivateKey;
    .registers 9
    .parameter "context"
    .parameter "alias"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/security/KeyChainException;,
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 302
    if-nez p1, :cond_a

    .line 303
    new-instance v5, Ljava/lang/NullPointerException;

    const-string v6, "alias == null"

    invoke-direct {v5, v6}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 305
    :cond_a
    invoke-static {p0}, Landroid/security/KeyChain;->bind(Landroid/content/Context;)Landroid/security/KeyChain$KeyChainConnection;

    move-result-object v2

    .line 307
    .local v2, keyChainConnection:Landroid/security/KeyChain$KeyChainConnection;
    :try_start_e
    invoke-virtual {v2}, Landroid/security/KeyChain$KeyChainConnection;->getService()Landroid/security/IKeyChainService;

    move-result-object v3

    .line 308
    .local v3, keyChainService:Landroid/security/IKeyChainService;
    invoke-interface {v3, p1}, Landroid/security/IKeyChainService;->requestPrivateKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 309
    .local v4, keyId:Ljava/lang/String;
    if-nez v4, :cond_2c

    .line 310
    new-instance v5, Landroid/security/KeyChainException;

    const-string v6, "keystore had a problem"

    invoke-direct {v5, v6}, Landroid/security/KeyChainException;-><init>(Ljava/lang/String;)V

    throw v5
    :try_end_20
    .catchall {:try_start_e .. :try_end_20} :catchall_27
    .catch Landroid/os/RemoteException; {:try_start_e .. :try_end_20} :catch_20
    .catch Ljava/lang/RuntimeException; {:try_start_e .. :try_end_20} :catch_3a
    .catch Ljava/security/InvalidKeyException; {:try_start_e .. :try_end_20} :catch_41

    .line 315
    .end local v3           #keyChainService:Landroid/security/IKeyChainService;
    .end local v4           #keyId:Ljava/lang/String;
    :catch_20
    move-exception v0

    .line 316
    .local v0, e:Landroid/os/RemoteException;
    :try_start_21
    new-instance v5, Landroid/security/KeyChainException;

    invoke-direct {v5, v0}, Landroid/security/KeyChainException;-><init>(Ljava/lang/Throwable;)V

    throw v5
    :try_end_27
    .catchall {:try_start_21 .. :try_end_27} :catchall_27

    .line 323
    .end local v0           #e:Landroid/os/RemoteException;
    :catchall_27
    move-exception v5

    invoke-virtual {v2}, Landroid/security/KeyChain$KeyChainConnection;->close()V

    throw v5

    .line 313
    .restart local v3       #keyChainService:Landroid/security/IKeyChainService;
    .restart local v4       #keyId:Ljava/lang/String;
    :cond_2c
    :try_start_2c
    const-string v5, "keystore"

    invoke-static {v5}, Lorg/apache/harmony/xnet/provider/jsse/OpenSSLEngine;->getInstance(Ljava/lang/String;)Lorg/apache/harmony/xnet/provider/jsse/OpenSSLEngine;

    move-result-object v1

    .line 314
    .local v1, engine:Lorg/apache/harmony/xnet/provider/jsse/OpenSSLEngine;
    invoke-virtual {v1, v4}, Lorg/apache/harmony/xnet/provider/jsse/OpenSSLEngine;->getPrivateKeyById(Ljava/lang/String;)Ljava/security/PrivateKey;
    :try_end_35
    .catchall {:try_start_2c .. :try_end_35} :catchall_27
    .catch Landroid/os/RemoteException; {:try_start_2c .. :try_end_35} :catch_20
    .catch Ljava/lang/RuntimeException; {:try_start_2c .. :try_end_35} :catch_3a
    .catch Ljava/security/InvalidKeyException; {:try_start_2c .. :try_end_35} :catch_41

    move-result-object v5

    .line 323
    invoke-virtual {v2}, Landroid/security/KeyChain$KeyChainConnection;->close()V

    .line 314
    return-object v5

    .line 317
    .end local v1           #engine:Lorg/apache/harmony/xnet/provider/jsse/OpenSSLEngine;
    .end local v3           #keyChainService:Landroid/security/IKeyChainService;
    .end local v4           #keyId:Ljava/lang/String;
    :catch_3a
    move-exception v0

    .line 319
    .local v0, e:Ljava/lang/RuntimeException;
    :try_start_3b
    new-instance v5, Landroid/security/KeyChainException;

    invoke-direct {v5, v0}, Landroid/security/KeyChainException;-><init>(Ljava/lang/Throwable;)V

    throw v5

    .line 320
    .end local v0           #e:Ljava/lang/RuntimeException;
    :catch_41
    move-exception v0

    .line 321
    .local v0, e:Ljava/security/InvalidKeyException;
    new-instance v5, Landroid/security/KeyChainException;

    invoke-direct {v5, v0}, Landroid/security/KeyChainException;-><init>(Ljava/lang/Throwable;)V

    throw v5
    :try_end_48
    .catchall {:try_start_3b .. :try_end_48} :catchall_27
.end method

.method private static toCertificate([B)Ljava/security/cert/X509Certificate;
    .registers 6
    .parameter "bytes"

    .prologue
    .line 370
    if-nez p0, :cond_a

    .line 371
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "bytes == null"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 374
    :cond_a
    :try_start_a
    const-string v3, "X.509"

    invoke-static {v3}, Ljava/security/cert/CertificateFactory;->getInstance(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;

    move-result-object v1

    .line 375
    .local v1, certFactory:Ljava/security/cert/CertificateFactory;
    new-instance v3, Ljava/io/ByteArrayInputStream;

    invoke-direct {v3, p0}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    invoke-virtual {v1, v3}, Ljava/security/cert/CertificateFactory;->generateCertificate(Ljava/io/InputStream;)Ljava/security/cert/Certificate;

    move-result-object v0

    .line 376
    .local v0, cert:Ljava/security/cert/Certificate;
    check-cast v0, Ljava/security/cert/X509Certificate;
    :try_end_1b
    .catch Ljava/security/cert/CertificateException; {:try_start_a .. :try_end_1b} :catch_1c

    .end local v0           #cert:Ljava/security/cert/Certificate;
    return-object v0

    .line 377
    .end local v1           #certFactory:Ljava/security/cert/CertificateFactory;
    :catch_1c
    move-exception v2

    .line 378
    .local v2, e:Ljava/security/cert/CertificateException;
    new-instance v3, Ljava/lang/AssertionError;

    invoke-direct {v3, v2}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v3
.end method
