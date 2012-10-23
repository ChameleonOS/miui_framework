.class final Landroid/webkit/CertTool;
.super Ljava/lang/Object;
.source "CertTool.java"


# static fields
.field private static final LOGTAG:Ljava/lang/String; = "CertTool"

.field private static final MD5_WITH_RSA:Lcom/android/org/bouncycastle/asn1/x509/AlgorithmIdentifier;

.field private static sCertificateTypeMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 36
    new-instance v0, Lcom/android/org/bouncycastle/asn1/x509/AlgorithmIdentifier;

    sget-object v1, Lcom/android/org/bouncycastle/asn1/pkcs/PKCSObjectIdentifiers;->md5WithRSAEncryption:Lcom/android/org/bouncycastle/asn1/ASN1ObjectIdentifier;

    invoke-direct {v0, v1}, Lcom/android/org/bouncycastle/asn1/x509/AlgorithmIdentifier;-><init>(Lcom/android/org/bouncycastle/asn1/DERObjectIdentifier;)V

    sput-object v0, Landroid/webkit/CertTool;->MD5_WITH_RSA:Lcom/android/org/bouncycastle/asn1/x509/AlgorithmIdentifier;

    .line 41
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Landroid/webkit/CertTool;->sCertificateTypeMap:Ljava/util/HashMap;

    .line 42
    sget-object v0, Landroid/webkit/CertTool;->sCertificateTypeMap:Ljava/util/HashMap;

    const-string v1, "application/x-x509-ca-cert"

    const-string v2, "CERT"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    sget-object v0, Landroid/webkit/CertTool;->sCertificateTypeMap:Ljava/util/HashMap;

    const-string v1, "application/x-x509-user-cert"

    const-string v2, "CERT"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    sget-object v0, Landroid/webkit/CertTool;->sCertificateTypeMap:Ljava/util/HashMap;

    const-string v1, "application/x-pkcs12"

    const-string v2, "PKCS12"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 78
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static addCertificate(Landroid/content/Context;Ljava/lang/String;[B)V
    .registers 4
    .parameter "context"
    .parameter "type"
    .parameter "value"

    .prologue
    .line 71
    invoke-static {}, Landroid/security/Credentials;->getInstance()Landroid/security/Credentials;

    move-result-object v0

    invoke-virtual {v0, p0, p1, p2}, Landroid/security/Credentials;->install(Landroid/content/Context;Ljava/lang/String;[B)V

    .line 72
    return-void
.end method

.method static getCertType(Ljava/lang/String;)Ljava/lang/String;
    .registers 2
    .parameter "mimeType"

    .prologue
    .line 75
    sget-object v0, Landroid/webkit/CertTool;->sCertificateTypeMap:Ljava/util/HashMap;

    invoke-virtual {v0, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method static getKeyStrengthList()[Ljava/lang/String;
    .registers 3

    .prologue
    .line 48
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "High Grade"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "Medium Grade"

    aput-object v2, v0, v1

    return-object v0
.end method

.method static getSignedPublicKey(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;
    .registers 10
    .parameter "context"
    .parameter "index"
    .parameter "challenge"

    .prologue
    .line 53
    :try_start_0
    const-string v5, "RSA"

    invoke-static {v5}, Ljava/security/KeyPairGenerator;->getInstance(Ljava/lang/String;)Ljava/security/KeyPairGenerator;

    move-result-object v1

    .line 54
    .local v1, generator:Ljava/security/KeyPairGenerator;
    if-nez p1, :cond_3c

    const/16 v5, 0x800

    :goto_a
    invoke-virtual {v1, v5}, Ljava/security/KeyPairGenerator;->initialize(I)V

    .line 55
    invoke-virtual {v1}, Ljava/security/KeyPairGenerator;->genKeyPair()Ljava/security/KeyPair;

    move-result-object v2

    .line 57
    .local v2, pair:Ljava/security/KeyPair;
    new-instance v3, Lcom/android/org/bouncycastle/jce/netscape/NetscapeCertRequest;

    sget-object v5, Landroid/webkit/CertTool;->MD5_WITH_RSA:Lcom/android/org/bouncycastle/asn1/x509/AlgorithmIdentifier;

    invoke-virtual {v2}, Ljava/security/KeyPair;->getPublic()Ljava/security/PublicKey;

    move-result-object v6

    invoke-direct {v3, p2, v5, v6}, Lcom/android/org/bouncycastle/jce/netscape/NetscapeCertRequest;-><init>(Ljava/lang/String;Lcom/android/org/bouncycastle/asn1/x509/AlgorithmIdentifier;Ljava/security/PublicKey;)V

    .line 59
    .local v3, request:Lcom/android/org/bouncycastle/jce/netscape/NetscapeCertRequest;
    invoke-virtual {v2}, Ljava/security/KeyPair;->getPrivate()Ljava/security/PrivateKey;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/android/org/bouncycastle/jce/netscape/NetscapeCertRequest;->sign(Ljava/security/PrivateKey;)V

    .line 60
    invoke-virtual {v3}, Lcom/android/org/bouncycastle/jce/netscape/NetscapeCertRequest;->toASN1Object()Lcom/android/org/bouncycastle/asn1/DERObject;

    move-result-object v5

    invoke-virtual {v5}, Lcom/android/org/bouncycastle/asn1/DERObject;->getDEREncoded()[B

    move-result-object v4

    .line 62
    .local v4, signed:[B
    invoke-static {}, Landroid/security/Credentials;->getInstance()Landroid/security/Credentials;

    move-result-object v5

    invoke-virtual {v5, p0, v2}, Landroid/security/Credentials;->install(Landroid/content/Context;Ljava/security/KeyPair;)V

    .line 63
    new-instance v5, Ljava/lang/String;

    invoke-static {v4}, Lcom/android/org/bouncycastle/util/encoders/Base64;->encode([B)[B

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/String;-><init>([B)V
    :try_end_3b
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_3b} :catch_3f

    .line 67
    .end local v1           #generator:Ljava/security/KeyPairGenerator;
    .end local v2           #pair:Ljava/security/KeyPair;
    .end local v3           #request:Lcom/android/org/bouncycastle/jce/netscape/NetscapeCertRequest;
    .end local v4           #signed:[B
    :goto_3b
    return-object v5

    .line 54
    .restart local v1       #generator:Ljava/security/KeyPairGenerator;
    :cond_3c
    const/16 v5, 0x400

    goto :goto_a

    .line 64
    .end local v1           #generator:Ljava/security/KeyPairGenerator;
    :catch_3f
    move-exception v0

    .line 65
    .local v0, e:Ljava/lang/Exception;
    const-string v5, "CertTool"

    invoke-static {v5, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 67
    const/4 v5, 0x0

    goto :goto_3b
.end method
