.class Landroid/webkit/WebViewCore$ReplaceTextData;
.super Ljava/lang/Object;
.source "WebViewCore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebViewCore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ReplaceTextData"
.end annotation


# instance fields
.field mNewEnd:I

.field mNewStart:I

.field mReplace:Ljava/lang/String;

.field mTextGeneration:I


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 890
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
