.class public final Landroid/webkit/ClientCertRequestHandler;
.super Landroid/os/Handler;
.source "ClientCertRequestHandler.java"


# instance fields
.field private final mBrowserFrame:Landroid/webkit/BrowserFrame;

.field private final mHandle:I

.field private final mHostAndPort:Ljava/lang/String;

.field private final mTable:Landroid/webkit/SslClientCertLookupTable;


# direct methods
.method constructor <init>(Landroid/webkit/BrowserFrame;ILjava/lang/String;Landroid/webkit/SslClientCertLookupTable;)V
    .registers 5
    .parameter "browserFrame"
    .parameter "handle"
    .parameter "host_and_port"
    .parameter "table"

    .prologue
    .line 44
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    .line 45
    iput-object p1, p0, Landroid/webkit/ClientCertRequestHandler;->mBrowserFrame:Landroid/webkit/BrowserFrame;

    .line 46
    iput p2, p0, Landroid/webkit/ClientCertRequestHandler;->mHandle:I

    .line 47
    iput-object p3, p0, Landroid/webkit/ClientCertRequestHandler;->mHostAndPort:Ljava/lang/String;

    .line 48
    iput-object p4, p0, Landroid/webkit/ClientCertRequestHandler;->mTable:Landroid/webkit/SslClientCertLookupTable;

    .line 49
    return-void
.end method

.method static synthetic access$000(Landroid/webkit/ClientCertRequestHandler;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 35
    iget v0, p0, Landroid/webkit/ClientCertRequestHandler;->mHandle:I

    return v0
.end method

.method static synthetic access$100(Landroid/webkit/ClientCertRequestHandler;)Landroid/webkit/BrowserFrame;
    .registers 2
    .parameter "x0"

    .prologue
    .line 35
    iget-object v0, p0, Landroid/webkit/ClientCertRequestHandler;->mBrowserFrame:Landroid/webkit/BrowserFrame;

    return-object v0
.end method

.method private setSslClientCertFromCtx(I[[B)V
    .registers 4
    .parameter "ctx"
    .parameter "chainBytes"

    .prologue
    .line 82
    new-instance v0, Landroid/webkit/ClientCertRequestHandler$2;

    invoke-direct {v0, p0, p1, p2}, Landroid/webkit/ClientCertRequestHandler$2;-><init>(Landroid/webkit/ClientCertRequestHandler;I[[B)V

    invoke-virtual {p0, v0}, Landroid/webkit/ClientCertRequestHandler;->post(Ljava/lang/Runnable;)Z

    .line 87
    return-void
.end method

.method private setSslClientCertFromPKCS8([B[[B)V
    .registers 4
    .parameter "key"
    .parameter "chainBytes"

    .prologue
    .line 93
    new-instance v0, Landroid/webkit/ClientCertRequestHandler$3;

    invoke-direct {v0, p0, p1, p2}, Landroid/webkit/ClientCertRequestHandler$3;-><init>(Landroid/webkit/ClientCertRequestHandler;[B[[B)V

    invoke-virtual {p0, v0}, Landroid/webkit/ClientCertRequestHandler;->post(Ljava/lang/Runnable;)Z

    .line 98
    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 3

    .prologue
    .line 115
    iget-object v0, p0, Landroid/webkit/ClientCertRequestHandler;->mTable:Landroid/webkit/SslClientCertLookupTable;

    iget-object v1, p0, Landroid/webkit/ClientCertRequestHandler;->mHostAndPort:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/webkit/SslClientCertLookupTable;->Deny(Ljava/lang/String;)V

    .line 116
    new-instance v0, Landroid/webkit/ClientCertRequestHandler$5;

    invoke-direct {v0, p0}, Landroid/webkit/ClientCertRequestHandler$5;-><init>(Landroid/webkit/ClientCertRequestHandler;)V

    invoke-virtual {p0, v0}, Landroid/webkit/ClientCertRequestHandler;->post(Ljava/lang/Runnable;)Z

    .line 121
    return-void
.end method

.method public ignore()V
    .registers 2

    .prologue
    .line 104
    new-instance v0, Landroid/webkit/ClientCertRequestHandler$4;

    invoke-direct {v0, p0}, Landroid/webkit/ClientCertRequestHandler$4;-><init>(Landroid/webkit/ClientCertRequestHandler;)V

    invoke-virtual {p0, v0}, Landroid/webkit/ClientCertRequestHandler;->post(Ljava/lang/Runnable;)Z

    .line 109
    return-void
.end method

.method public proceed(Ljava/security/PrivateKey;[Ljava/security/cert/X509Certificate;)V
    .registers 7
    .parameter "privateKey"
    .parameter "chain"

    .prologue
    .line 56
    :try_start_0
    invoke-static {p2}, Lorg/apache/harmony/xnet/provider/jsse/NativeCrypto;->encodeCertificates([Ljava/security/cert/Certificate;)[[B

    move-result-object v0

    .line 57
    .local v0, chainBytes:[[B
    iget-object v2, p0, Landroid/webkit/ClientCertRequestHandler;->mTable:Landroid/webkit/SslClientCertLookupTable;

    iget-object v3, p0, Landroid/webkit/ClientCertRequestHandler;->mHostAndPort:Ljava/lang/String;

    invoke-virtual {v2, v3, p1, v0}, Landroid/webkit/SslClientCertLookupTable;->Allow(Ljava/lang/String;Ljava/security/PrivateKey;[[B)V

    .line 59
    instance-of v2, p1, Lorg/apache/harmony/xnet/provider/jsse/OpenSSLRSAPrivateKey;

    if-eqz v2, :cond_19

    .line 60
    check-cast p1, Lorg/apache/harmony/xnet/provider/jsse/OpenSSLRSAPrivateKey;

    .end local p1
    invoke-virtual {p1}, Lorg/apache/harmony/xnet/provider/jsse/OpenSSLRSAPrivateKey;->getPkeyContext()I

    move-result v2

    invoke-direct {p0, v2, v0}, Landroid/webkit/ClientCertRequestHandler;->setSslClientCertFromCtx(I[[B)V

    .line 76
    .end local v0           #chainBytes:[[B
    :goto_18
    return-void

    .line 62
    .restart local v0       #chainBytes:[[B
    .restart local p1
    :cond_19
    instance-of v2, p1, Lorg/apache/harmony/xnet/provider/jsse/OpenSSLDSAPrivateKey;

    if-eqz v2, :cond_31

    .line 63
    check-cast p1, Lorg/apache/harmony/xnet/provider/jsse/OpenSSLDSAPrivateKey;

    .end local p1
    invoke-virtual {p1}, Lorg/apache/harmony/xnet/provider/jsse/OpenSSLDSAPrivateKey;->getPkeyContext()I

    move-result v2

    invoke-direct {p0, v2, v0}, Landroid/webkit/ClientCertRequestHandler;->setSslClientCertFromCtx(I[[B)V
    :try_end_26
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_0 .. :try_end_26} :catch_27

    goto :goto_18

    .line 68
    .end local v0           #chainBytes:[[B
    :catch_27
    move-exception v1

    .line 69
    .local v1, e:Ljava/security/cert/CertificateEncodingException;
    new-instance v2, Landroid/webkit/ClientCertRequestHandler$1;

    invoke-direct {v2, p0}, Landroid/webkit/ClientCertRequestHandler$1;-><init>(Landroid/webkit/ClientCertRequestHandler;)V

    invoke-virtual {p0, v2}, Landroid/webkit/ClientCertRequestHandler;->post(Ljava/lang/Runnable;)Z

    goto :goto_18

    .line 66
    .end local v1           #e:Ljava/security/cert/CertificateEncodingException;
    .restart local v0       #chainBytes:[[B
    .restart local p1
    :cond_31
    :try_start_31
    invoke-interface {p1}, Ljava/security/PrivateKey;->getEncoded()[B

    move-result-object v2

    invoke-direct {p0, v2, v0}, Landroid/webkit/ClientCertRequestHandler;->setSslClientCertFromPKCS8([B[[B)V
    :try_end_38
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_31 .. :try_end_38} :catch_27

    goto :goto_18
.end method
