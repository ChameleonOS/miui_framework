.class Landroid/webkit/WebViewCore$AutoFillData;
.super Ljava/lang/Object;
.source "WebViewCore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebViewCore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "AutoFillData"
.end annotation


# instance fields
.field private mPreview:Ljava/lang/String;

.field private mQueryId:I


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 950
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 951
    const/4 v0, -0x1

    iput v0, p0, Landroid/webkit/WebViewCore$AutoFillData;->mQueryId:I

    .line 952
    const-string v0, ""

    iput-object v0, p0, Landroid/webkit/WebViewCore$AutoFillData;->mPreview:Ljava/lang/String;

    .line 953
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .registers 3
    .parameter "queryId"
    .parameter "preview"

    .prologue
    .line 955
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 956
    iput p1, p0, Landroid/webkit/WebViewCore$AutoFillData;->mQueryId:I

    .line 957
    iput-object p2, p0, Landroid/webkit/WebViewCore$AutoFillData;->mPreview:Ljava/lang/String;

    .line 958
    return-void
.end method


# virtual methods
.method public getPreviewString()Ljava/lang/String;
    .registers 2

    .prologue
    .line 965
    iget-object v0, p0, Landroid/webkit/WebViewCore$AutoFillData;->mPreview:Ljava/lang/String;

    return-object v0
.end method

.method public getQueryId()I
    .registers 2

    .prologue
    .line 961
    iget v0, p0, Landroid/webkit/WebViewCore$AutoFillData;->mQueryId:I

    return v0
.end method
