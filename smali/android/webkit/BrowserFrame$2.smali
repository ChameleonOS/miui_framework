.class Landroid/webkit/BrowserFrame$2;
.super Landroid/webkit/SslErrorHandler;
.source "BrowserFrame.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/BrowserFrame;->reportSslCertError(II[BLjava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/webkit/BrowserFrame;

.field final synthetic val$certError:I

.field final synthetic val$handle:I

.field final synthetic val$sslError:Landroid/net/http/SslError;


# direct methods
.method constructor <init>(Landroid/webkit/BrowserFrame;Landroid/net/http/SslError;II)V
    .registers 5
    .parameter
    .parameter
    .parameter
    .parameter

    .prologue
    .line 1077
    iput-object p1, p0, Landroid/webkit/BrowserFrame$2;->this$0:Landroid/webkit/BrowserFrame;

    iput-object p2, p0, Landroid/webkit/BrowserFrame$2;->val$sslError:Landroid/net/http/SslError;

    iput p3, p0, Landroid/webkit/BrowserFrame$2;->val$handle:I

    iput p4, p0, Landroid/webkit/BrowserFrame$2;->val$certError:I

    invoke-direct {p0}, Landroid/webkit/SslErrorHandler;-><init>()V

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 2

    .prologue
    .line 1089
    new-instance v0, Landroid/webkit/BrowserFrame$2$2;

    invoke-direct {v0, p0}, Landroid/webkit/BrowserFrame$2$2;-><init>(Landroid/webkit/BrowserFrame$2;)V

    invoke-virtual {p0, v0}, Landroid/webkit/BrowserFrame$2;->post(Ljava/lang/Runnable;)Z

    .line 1094
    return-void
.end method

.method public proceed()V
    .registers 3

    .prologue
    .line 1080
    invoke-static {}, Landroid/webkit/SslCertLookupTable;->getInstance()Landroid/webkit/SslCertLookupTable;

    move-result-object v0

    iget-object v1, p0, Landroid/webkit/BrowserFrame$2;->val$sslError:Landroid/net/http/SslError;

    invoke-virtual {v0, v1}, Landroid/webkit/SslCertLookupTable;->setIsAllowed(Landroid/net/http/SslError;)V

    .line 1081
    new-instance v0, Landroid/webkit/BrowserFrame$2$1;

    invoke-direct {v0, p0}, Landroid/webkit/BrowserFrame$2$1;-><init>(Landroid/webkit/BrowserFrame$2;)V

    invoke-virtual {p0, v0}, Landroid/webkit/BrowserFrame$2;->post(Ljava/lang/Runnable;)Z

    .line 1086
    return-void
.end method
