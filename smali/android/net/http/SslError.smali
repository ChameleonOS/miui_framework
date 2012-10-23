.class public Landroid/net/http/SslError;
.super Ljava/lang/Object;
.source "SslError.java"


# static fields
#the value of this static final field might be set in the static constructor
.field static final synthetic $assertionsDisabled:Z = false

.field public static final SSL_DATE_INVALID:I = 0x4

.field public static final SSL_EXPIRED:I = 0x1

.field public static final SSL_IDMISMATCH:I = 0x2

.field public static final SSL_INVALID:I = 0x5

.field public static final SSL_MAX_ERROR:I = 0x6
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final SSL_NOTYETVALID:I = 0x0

.field public static final SSL_UNTRUSTED:I = 0x3


# instance fields
.field final mCertificate:Landroid/net/http/SslCertificate;

.field mErrors:I

.field final mUrl:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 25
    const-class v0, Landroid/net/http/SslError;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_c

    const/4 v0, 0x1

    :goto_9
    sput-boolean v0, Landroid/net/http/SslError;->$assertionsDisabled:Z

    return-void

    :cond_c
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public constructor <init>(ILandroid/net/http/SslCertificate;)V
    .registers 4
    .parameter "error"
    .parameter "certificate"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 91
    const-string v0, ""

    invoke-direct {p0, p1, p2, v0}, Landroid/net/http/SslError;-><init>(ILandroid/net/http/SslCertificate;Ljava/lang/String;)V

    .line 92
    return-void
.end method

.method public constructor <init>(ILandroid/net/http/SslCertificate;Ljava/lang/String;)V
    .registers 5
    .parameter "error"
    .parameter "certificate"
    .parameter "url"

    .prologue
    .line 113
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 114
    sget-boolean v0, Landroid/net/http/SslError;->$assertionsDisabled:Z

    if-nez v0, :cond_f

    if-nez p2, :cond_f

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 115
    :cond_f
    sget-boolean v0, Landroid/net/http/SslError;->$assertionsDisabled:Z

    if-nez v0, :cond_1b

    if-nez p3, :cond_1b

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 116
    :cond_1b
    invoke-virtual {p0, p1}, Landroid/net/http/SslError;->addError(I)Z

    .line 117
    iput-object p2, p0, Landroid/net/http/SslError;->mCertificate:Landroid/net/http/SslCertificate;

    .line 118
    iput-object p3, p0, Landroid/net/http/SslError;->mUrl:Ljava/lang/String;

    .line 119
    return-void
.end method

.method public constructor <init>(ILjava/security/cert/X509Certificate;)V
    .registers 4
    .parameter "error"
    .parameter "certificate"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 103
    const-string v0, ""

    invoke-direct {p0, p1, p2, v0}, Landroid/net/http/SslError;-><init>(ILjava/security/cert/X509Certificate;Ljava/lang/String;)V

    .line 104
    return-void
.end method

.method public constructor <init>(ILjava/security/cert/X509Certificate;Ljava/lang/String;)V
    .registers 5
    .parameter "error"
    .parameter "certificate"
    .parameter "url"

    .prologue
    .line 129
    new-instance v0, Landroid/net/http/SslCertificate;

    invoke-direct {v0, p2}, Landroid/net/http/SslCertificate;-><init>(Ljava/security/cert/X509Certificate;)V

    invoke-direct {p0, p1, v0, p3}, Landroid/net/http/SslError;-><init>(ILandroid/net/http/SslCertificate;Ljava/lang/String;)V

    .line 130
    return-void
.end method

.method public static SslErrorFromChromiumErrorCode(ILandroid/net/http/SslCertificate;Ljava/lang/String;)Landroid/net/http/SslError;
    .registers 5
    .parameter "error"
    .parameter "cert"
    .parameter "url"

    .prologue
    const/16 v1, -0xc8

    .line 143
    sget-boolean v0, Landroid/net/http/SslError;->$assertionsDisabled:Z

    if-nez v0, :cond_12

    const/16 v0, -0x12b

    if-lt p0, v0, :cond_c

    if-le p0, v1, :cond_12

    :cond_c
    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 144
    :cond_12
    if-ne p0, v1, :cond_1b

    .line 145
    new-instance v0, Landroid/net/http/SslError;

    const/4 v1, 0x2

    invoke-direct {v0, v1, p1, p2}, Landroid/net/http/SslError;-><init>(ILandroid/net/http/SslCertificate;Ljava/lang/String;)V

    .line 151
    :goto_1a
    return-object v0

    .line 146
    :cond_1b
    const/16 v0, -0xc9

    if-ne p0, v0, :cond_26

    .line 147
    new-instance v0, Landroid/net/http/SslError;

    const/4 v1, 0x4

    invoke-direct {v0, v1, p1, p2}, Landroid/net/http/SslError;-><init>(ILandroid/net/http/SslCertificate;Ljava/lang/String;)V

    goto :goto_1a

    .line 148
    :cond_26
    const/16 v0, -0xca

    if-ne p0, v0, :cond_31

    .line 149
    new-instance v0, Landroid/net/http/SslError;

    const/4 v1, 0x3

    invoke-direct {v0, v1, p1, p2}, Landroid/net/http/SslError;-><init>(ILandroid/net/http/SslCertificate;Ljava/lang/String;)V

    goto :goto_1a

    .line 151
    :cond_31
    new-instance v0, Landroid/net/http/SslError;

    const/4 v1, 0x5

    invoke-direct {v0, v1, p1, p2}, Landroid/net/http/SslError;-><init>(ILandroid/net/http/SslCertificate;Ljava/lang/String;)V

    goto :goto_1a
.end method


# virtual methods
.method public addError(I)Z
    .registers 5
    .parameter "error"

    .prologue
    const/4 v1, 0x1

    .line 177
    if-ltz p1, :cond_10

    const/4 v2, 0x6

    if-ge p1, v2, :cond_10

    move v0, v1

    .line 178
    .local v0, rval:Z
    :goto_7
    if-eqz v0, :cond_f

    .line 179
    iget v2, p0, Landroid/net/http/SslError;->mErrors:I

    shl-int/2addr v1, p1

    or-int/2addr v1, v2

    iput v1, p0, Landroid/net/http/SslError;->mErrors:I

    .line 182
    :cond_f
    return v0

    .line 177
    .end local v0           #rval:Z
    :cond_10
    const/4 v0, 0x0

    goto :goto_7
.end method

.method public getCertificate()Landroid/net/http/SslCertificate;
    .registers 2

    .prologue
    .line 159
    iget-object v0, p0, Landroid/net/http/SslError;->mCertificate:Landroid/net/http/SslCertificate;

    return-object v0
.end method

.method public getPrimaryError()I
    .registers 4

    .prologue
    .line 205
    iget v1, p0, Landroid/net/http/SslError;->mErrors:I

    if-eqz v1, :cond_1c

    .line 207
    const/4 v0, 0x5

    .local v0, error:I
    :goto_5
    if-ltz v0, :cond_12

    .line 208
    iget v1, p0, Landroid/net/http/SslError;->mErrors:I

    const/4 v2, 0x1

    shl-int/2addr v2, v0

    and-int/2addr v1, v2

    if-eqz v1, :cond_f

    .line 216
    .end local v0           #error:I
    :goto_e
    return v0

    .line 207
    .restart local v0       #error:I
    :cond_f
    add-int/lit8 v0, v0, -0x1

    goto :goto_5

    .line 213
    :cond_12
    sget-boolean v1, Landroid/net/http/SslError;->$assertionsDisabled:Z

    if-nez v1, :cond_1c

    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1}, Ljava/lang/AssertionError;-><init>()V

    throw v1

    .line 216
    .end local v0           #error:I
    :cond_1c
    const/4 v0, -0x1

    goto :goto_e
.end method

.method public getUrl()Ljava/lang/String;
    .registers 2

    .prologue
    .line 167
    iget-object v0, p0, Landroid/net/http/SslError;->mUrl:Ljava/lang/String;

    return-object v0
.end method

.method public hasError(I)Z
    .registers 7
    .parameter "error"

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 191
    if-ltz p1, :cond_13

    const/4 v3, 0x6

    if-ge p1, v3, :cond_13

    move v0, v1

    .line 192
    .local v0, rval:Z
    :goto_8
    if-eqz v0, :cond_12

    .line 193
    iget v3, p0, Landroid/net/http/SslError;->mErrors:I

    shl-int v4, v1, p1

    and-int/2addr v3, v4

    if-eqz v3, :cond_15

    move v0, v1

    .line 196
    :cond_12
    :goto_12
    return v0

    .end local v0           #rval:Z
    :cond_13
    move v0, v2

    .line 191
    goto :goto_8

    .restart local v0       #rval:Z
    :cond_15
    move v0, v2

    .line 193
    goto :goto_12
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    .line 224
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "primary error: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Landroid/net/http/SslError;->getPrimaryError()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " certificate: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Landroid/net/http/SslError;->getCertificate()Landroid/net/http/SslCertificate;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " on URL: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Landroid/net/http/SslError;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
