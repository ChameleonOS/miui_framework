.class Landroid/webkit/WebViewCore$3;
.super Ljava/lang/Object;
.source "WebViewCore.java"

# interfaces
.implements Landroid/webkit/ValueCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/WebViewCore;->populateVisitedLinks()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/webkit/ValueCallback",
        "<[",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Landroid/webkit/WebViewCore;


# direct methods
.method constructor <init>(Landroid/webkit/WebViewCore;)V
    .registers 2
    .parameter

    .prologue
    .line 484
    iput-object p1, p0, Landroid/webkit/WebViewCore$3;->this$0:Landroid/webkit/WebViewCore;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic onReceiveValue(Ljava/lang/Object;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 484
    check-cast p1, [Ljava/lang/String;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/webkit/WebViewCore$3;->onReceiveValue([Ljava/lang/String;)V

    return-void
.end method

.method public onReceiveValue([Ljava/lang/String;)V
    .registers 4
    .parameter "value"

    .prologue
    .line 487
    iget-object v0, p0, Landroid/webkit/WebViewCore$3;->this$0:Landroid/webkit/WebViewCore;

    const/16 v1, 0xb5

    invoke-virtual {v0, v1, p1}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 488
    return-void
.end method
