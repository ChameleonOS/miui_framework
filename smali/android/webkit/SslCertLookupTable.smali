.class final Landroid/webkit/SslCertLookupTable;
.super Ljava/lang/Object;
.source "SslCertLookupTable.java"


# static fields
.field private static sTable:Landroid/webkit/SslCertLookupTable;


# instance fields
.field private final table:Landroid/os/Bundle;


# direct methods
.method private constructor <init>()V
    .registers 2

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Landroid/webkit/SslCertLookupTable;->table:Landroid/os/Bundle;

    return-void
.end method

.method public static getInstance()Landroid/webkit/SslCertLookupTable;
    .registers 1

    .prologue
    sget-object v0, Landroid/webkit/SslCertLookupTable;->sTable:Landroid/webkit/SslCertLookupTable;

    if-nez v0, :cond_b

    new-instance v0, Landroid/webkit/SslCertLookupTable;

    invoke-direct {v0}, Landroid/webkit/SslCertLookupTable;-><init>()V

    sput-object v0, Landroid/webkit/SslCertLookupTable;->sTable:Landroid/webkit/SslCertLookupTable;

    :cond_b
    sget-object v0, Landroid/webkit/SslCertLookupTable;->sTable:Landroid/webkit/SslCertLookupTable;

    return-object v0
.end method


# virtual methods
.method public clear()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/webkit/SslCertLookupTable;->table:Landroid/os/Bundle;

    invoke-virtual {v0}, Landroid/os/Bundle;->clear()V

    return-void
.end method

.method public isAllowed(Landroid/net/http/SslError;)Z
    .registers 7
    .parameter "sslError"

    .prologue
    const/4 v2, 0x0

    :try_start_1
    new-instance v3, Ljava/net/URL;

    invoke-virtual {p1}, Landroid/net/http/SslError;->getUrl()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/net/URL;->getHost()Ljava/lang/String;
    :try_end_d
    .catch Ljava/net/MalformedURLException; {:try_start_1 .. :try_end_d} :catch_24

    move-result-object v1

    .local v1, host:Ljava/lang/String;
    iget-object v3, p0, Landroid/webkit/SslCertLookupTable;->table:Landroid/os/Bundle;

    invoke-virtual {v3, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_23

    invoke-virtual {p1}, Landroid/net/http/SslError;->getPrimaryError()I

    move-result v3

    iget-object v4, p0, Landroid/webkit/SslCertLookupTable;->table:Landroid/os/Bundle;

    invoke-virtual {v4, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v4

    if-gt v3, v4, :cond_23

    const/4 v2, 0x1

    .end local v1           #host:Ljava/lang/String;
    :cond_23
    :goto_23
    return v2

    :catch_24
    move-exception v0

    .local v0, e:Ljava/net/MalformedURLException;
    goto :goto_23
.end method

.method public setIsAllowed(Landroid/net/http/SslError;)V
    .registers 6
    .parameter "sslError"

    .prologue
    :try_start_0
    new-instance v2, Ljava/net/URL;

    invoke-virtual {p1}, Landroid/net/http/SslError;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/net/URL;->getHost()Ljava/lang/String;
    :try_end_c
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_c} :catch_17

    move-result-object v1

    .local v1, host:Ljava/lang/String;
    iget-object v2, p0, Landroid/webkit/SslCertLookupTable;->table:Landroid/os/Bundle;

    invoke-virtual {p1}, Landroid/net/http/SslError;->getPrimaryError()I

    move-result v3

    invoke-virtual {v2, v1, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .end local v1           #host:Ljava/lang/String;
    :goto_16
    return-void

    :catch_17
    move-exception v0

    .local v0, e:Ljava/net/MalformedURLException;
    goto :goto_16
.end method
