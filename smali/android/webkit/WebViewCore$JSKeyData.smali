.class Landroid/webkit/WebViewCore$JSKeyData;
.super Ljava/lang/Object;
.source "WebViewCore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebViewCore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "JSKeyData"
.end annotation


# instance fields
.field mCurrentText:Ljava/lang/String;

.field mEvent:Landroid/view/KeyEvent;


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 866
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
