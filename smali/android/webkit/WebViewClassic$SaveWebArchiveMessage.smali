.class Landroid/webkit/WebViewClassic$SaveWebArchiveMessage;
.super Ljava/lang/Object;
.source "WebViewClassic.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebViewClassic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "SaveWebArchiveMessage"
.end annotation


# instance fields
.field final mAutoname:Z

.field final mBasename:Ljava/lang/String;

.field final mCallback:Landroid/webkit/ValueCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/webkit/ValueCallback",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field mResultFile:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;ZLandroid/webkit/ValueCallback;)V
    .registers 4
    .parameter "basename"
    .parameter "autoname"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z",
            "Landroid/webkit/ValueCallback",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 2598
    .local p3, callback:Landroid/webkit/ValueCallback;,"Landroid/webkit/ValueCallback<Ljava/lang/String;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 2599
    iput-object p1, p0, Landroid/webkit/WebViewClassic$SaveWebArchiveMessage;->mBasename:Ljava/lang/String;

    .line 2600
    iput-boolean p2, p0, Landroid/webkit/WebViewClassic$SaveWebArchiveMessage;->mAutoname:Z

    .line 2601
    iput-object p3, p0, Landroid/webkit/WebViewClassic$SaveWebArchiveMessage;->mCallback:Landroid/webkit/ValueCallback;

    .line 2602
    return-void
.end method
