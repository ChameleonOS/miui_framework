.class Landroid/webkit/WebViewCore$2;
.super Ljava/lang/Object;
.source "WebViewCore.java"

# interfaces
.implements Landroid/webkit/WebStorage$QuotaUpdater;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/WebViewCore;->reachedMaxAppCacheSize(J)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/webkit/WebViewCore;


# direct methods
.method constructor <init>(Landroid/webkit/WebViewCore;)V
    .registers 2
    .parameter

    .prologue
    .line 475
    iput-object p1, p0, Landroid/webkit/WebViewCore$2;->this$0:Landroid/webkit/WebViewCore;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public updateQuota(J)V
    .registers 5
    .parameter "newQuota"

    .prologue
    .line 478
    iget-object v0, p0, Landroid/webkit/WebViewCore$2;->this$0:Landroid/webkit/WebViewCore;

    iget-object v1, p0, Landroid/webkit/WebViewCore$2;->this$0:Landroid/webkit/WebViewCore;

    #getter for: Landroid/webkit/WebViewCore;->mNativeClass:I
    invoke-static {v1}, Landroid/webkit/WebViewCore;->access$300(Landroid/webkit/WebViewCore;)I

    move-result v1

    #calls: Landroid/webkit/WebViewCore;->nativeSetNewStorageLimit(IJ)V
    invoke-static {v0, v1, p1, p2}, Landroid/webkit/WebViewCore;->access$400(Landroid/webkit/WebViewCore;IJ)V

    .line 479
    return-void
.end method
