.class Landroid/webkit/WebViewCore$SaveViewStateRequest;
.super Ljava/lang/Object;
.source "WebViewCore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebViewCore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "SaveViewStateRequest"
.end annotation


# instance fields
.field public mCallback:Landroid/webkit/ValueCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/webkit/ValueCallback",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field public mStream:Ljava/io/OutputStream;


# direct methods
.method constructor <init>(Ljava/io/OutputStream;Landroid/webkit/ValueCallback;)V
    .registers 3
    .parameter "s"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/OutputStream;",
            "Landroid/webkit/ValueCallback",
            "<",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1086
    .local p2, cb:Landroid/webkit/ValueCallback;,"Landroid/webkit/ValueCallback<Ljava/lang/Boolean;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1087
    iput-object p1, p0, Landroid/webkit/WebViewCore$SaveViewStateRequest;->mStream:Ljava/io/OutputStream;

    .line 1088
    iput-object p2, p0, Landroid/webkit/WebViewCore$SaveViewStateRequest;->mCallback:Landroid/webkit/ValueCallback;

    .line 1089
    return-void
.end method
