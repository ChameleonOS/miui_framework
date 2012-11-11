.class Landroid/webkit/ClientCertRequestHandler$5;
.super Ljava/lang/Object;
.source "ClientCertRequestHandler.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/ClientCertRequestHandler;->cancel()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/webkit/ClientCertRequestHandler;


# direct methods
.method constructor <init>(Landroid/webkit/ClientCertRequestHandler;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/webkit/ClientCertRequestHandler$5;->this$0:Landroid/webkit/ClientCertRequestHandler;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 5

    .prologue
    iget-object v0, p0, Landroid/webkit/ClientCertRequestHandler$5;->this$0:Landroid/webkit/ClientCertRequestHandler;

    #getter for: Landroid/webkit/ClientCertRequestHandler;->mBrowserFrame:Landroid/webkit/BrowserFrame;
    invoke-static {v0}, Landroid/webkit/ClientCertRequestHandler;->access$100(Landroid/webkit/ClientCertRequestHandler;)Landroid/webkit/BrowserFrame;

    move-result-object v1

    iget-object v0, p0, Landroid/webkit/ClientCertRequestHandler$5;->this$0:Landroid/webkit/ClientCertRequestHandler;

    #getter for: Landroid/webkit/ClientCertRequestHandler;->mHandle:I
    invoke-static {v0}, Landroid/webkit/ClientCertRequestHandler;->access$000(Landroid/webkit/ClientCertRequestHandler;)I

    move-result v2

    const/4 v3, 0x0

    const/4 v0, 0x0

    check-cast v0, [[B

    invoke-virtual {v1, v2, v3, v0}, Landroid/webkit/BrowserFrame;->nativeSslClientCert(II[[B)V

    return-void
.end method
