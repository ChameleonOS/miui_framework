.class Landroid/webkit/WebViewCore$BaseUrlData;
.super Ljava/lang/Object;
.source "WebViewCore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebViewCore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "BaseUrlData"
.end annotation


# instance fields
.field mBaseUrl:Ljava/lang/String;

.field mData:Ljava/lang/String;

.field mEncoding:Ljava/lang/String;

.field mHistoryUrl:Ljava/lang/String;

.field mMimeType:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 831
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
