.class final Landroid/net/SSLCertificateSocketFactory$1;
.super Ljava/lang/Object;
.source "SSLCertificateSocketFactory.java"

# interfaces
.implements Ljavax/net/ssl/X509TrustManager;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/SSLCertificateSocketFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 75
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public checkClientTrusted([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V
    .registers 3
    .parameter "certs"
    .parameter "authType"

    .prologue
    .line 77
    return-void
.end method

.method public checkServerTrusted([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V
    .registers 3
    .parameter "certs"
    .parameter "authType"

    .prologue
    .line 78
    return-void
.end method

.method public getAcceptedIssuers()[Ljava/security/cert/X509Certificate;
    .registers 2

    .prologue
    .line 76
    const/4 v0, 0x0

    return-object v0
.end method
