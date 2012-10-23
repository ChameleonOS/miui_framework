.class Landroid/webkit/WebViewCore$FindAllRequest;
.super Ljava/lang/Object;
.source "WebViewCore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebViewCore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "FindAllRequest"
.end annotation


# instance fields
.field public mMatchCount:I

.field public mMatchIndex:I

.field public final mSearchText:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .registers 3
    .parameter "text"

    .prologue
    const/4 v0, -0x1

    .line 1075
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1076
    iput-object p1, p0, Landroid/webkit/WebViewCore$FindAllRequest;->mSearchText:Ljava/lang/String;

    .line 1077
    iput v0, p0, Landroid/webkit/WebViewCore$FindAllRequest;->mMatchCount:I

    .line 1078
    iput v0, p0, Landroid/webkit/WebViewCore$FindAllRequest;->mMatchIndex:I

    .line 1079
    return-void
.end method
