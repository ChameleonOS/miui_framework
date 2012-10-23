.class Landroid/webkit/WebViewClassic$InvokeListBox$Container;
.super Ljava/lang/Object;
.source "WebViewClassic.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebViewClassic$InvokeListBox;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Container"
.end annotation


# static fields
.field static final OPTGROUP:I = -0x1

.field static final OPTION_DISABLED:I = 0x0

.field static final OPTION_ENABLED:I = 0x1


# instance fields
.field mEnabled:I

.field mId:I

.field mString:Ljava/lang/String;

.field final synthetic this$1:Landroid/webkit/WebViewClassic$InvokeListBox;


# direct methods
.method private constructor <init>(Landroid/webkit/WebViewClassic$InvokeListBox;)V
    .registers 2
    .parameter

    .prologue
    .line 7978
    iput-object p1, p0, Landroid/webkit/WebViewClassic$InvokeListBox$Container;->this$1:Landroid/webkit/WebViewClassic$InvokeListBox;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/webkit/WebViewClassic$InvokeListBox;Landroid/webkit/WebViewClassic$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 7978
    invoke-direct {p0, p1}, Landroid/webkit/WebViewClassic$InvokeListBox$Container;-><init>(Landroid/webkit/WebViewClassic$InvokeListBox;)V

    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .registers 2

    .prologue
    .line 7993
    iget-object v0, p0, Landroid/webkit/WebViewClassic$InvokeListBox$Container;->mString:Ljava/lang/String;

    return-object v0
.end method
