.class Landroid/webkit/ViewManager$ChildView;
.super Ljava/lang/Object;
.source "ViewManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/ViewManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ChildView"
.end annotation


# instance fields
.field height:I

.field mView:Landroid/view/View;

.field final synthetic this$0:Landroid/webkit/ViewManager;

.field width:I

.field x:I

.field y:I


# direct methods
.method constructor <init>(Landroid/webkit/ViewManager;)V
    .registers 2
    .parameter

    .prologue
    .line 46
    iput-object p1, p0, Landroid/webkit/ViewManager$ChildView;->this$0:Landroid/webkit/ViewManager;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 47
    return-void
.end method

.method static synthetic access$100(Landroid/webkit/ViewManager$ChildView;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 39
    invoke-direct {p0}, Landroid/webkit/ViewManager$ChildView;->attachViewOnUIThread()V

    return-void
.end method

.method static synthetic access$500(Landroid/webkit/ViewManager$ChildView;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 39
    invoke-direct {p0}, Landroid/webkit/ViewManager$ChildView;->removeViewOnUIThread()V

    return-void
.end method

.method private attachViewOnUIThread()V
    .registers 3

    .prologue
    .line 78
    iget-object v0, p0, Landroid/webkit/ViewManager$ChildView;->this$0:Landroid/webkit/ViewManager;

    #getter for: Landroid/webkit/ViewManager;->mWebView:Landroid/webkit/WebViewClassic;
    invoke-static {v0}, Landroid/webkit/ViewManager;->access$200(Landroid/webkit/ViewManager;)Landroid/webkit/WebViewClassic;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebViewClassic;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    iget-object v1, p0, Landroid/webkit/ViewManager$ChildView;->mView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->addView(Landroid/view/View;)V

    .line 79
    iget-object v0, p0, Landroid/webkit/ViewManager$ChildView;->this$0:Landroid/webkit/ViewManager;

    #getter for: Landroid/webkit/ViewManager;->mChildren:Ljava/util/ArrayList;
    invoke-static {v0}, Landroid/webkit/ViewManager;->access$300(Landroid/webkit/ViewManager;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 80
    iget-object v0, p0, Landroid/webkit/ViewManager$ChildView;->this$0:Landroid/webkit/ViewManager;

    #getter for: Landroid/webkit/ViewManager;->mReadyToDraw:Z
    invoke-static {v0}, Landroid/webkit/ViewManager;->access$400(Landroid/webkit/ViewManager;)Z

    move-result v0

    if-nez v0, :cond_27

    .line 81
    iget-object v0, p0, Landroid/webkit/ViewManager$ChildView;->mView:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 83
    :cond_27
    return-void
.end method

.method private removeViewOnUIThread()V
    .registers 3

    .prologue
    .line 97
    iget-object v0, p0, Landroid/webkit/ViewManager$ChildView;->this$0:Landroid/webkit/ViewManager;

    #getter for: Landroid/webkit/ViewManager;->mWebView:Landroid/webkit/WebViewClassic;
    invoke-static {v0}, Landroid/webkit/ViewManager;->access$200(Landroid/webkit/ViewManager;)Landroid/webkit/WebViewClassic;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebViewClassic;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    iget-object v1, p0, Landroid/webkit/ViewManager$ChildView;->mView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->removeView(Landroid/view/View;)V

    .line 98
    iget-object v0, p0, Landroid/webkit/ViewManager$ChildView;->this$0:Landroid/webkit/ViewManager;

    #getter for: Landroid/webkit/ViewManager;->mChildren:Ljava/util/ArrayList;
    invoke-static {v0}, Landroid/webkit/ViewManager;->access$300(Landroid/webkit/ViewManager;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 99
    return-void
.end method


# virtual methods
.method attachView(IIII)V
    .registers 7
    .parameter "x"
    .parameter "y"
    .parameter "width"
    .parameter "height"

    .prologue
    .line 57
    iget-object v0, p0, Landroid/webkit/ViewManager$ChildView;->mView:Landroid/view/View;

    if-nez v0, :cond_5

    .line 75
    :goto_4
    return-void

    .line 60
    :cond_5
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/webkit/ViewManager$ChildView;->setBounds(IIII)V

    .line 62
    iget-object v0, p0, Landroid/webkit/ViewManager$ChildView;->this$0:Landroid/webkit/ViewManager;

    #getter for: Landroid/webkit/ViewManager;->mWebView:Landroid/webkit/WebViewClassic;
    invoke-static {v0}, Landroid/webkit/ViewManager;->access$200(Landroid/webkit/ViewManager;)Landroid/webkit/WebViewClassic;

    move-result-object v0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    new-instance v1, Landroid/webkit/ViewManager$ChildView$1;

    invoke-direct {v1, p0}, Landroid/webkit/ViewManager$ChildView$1;-><init>(Landroid/webkit/ViewManager$ChildView;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_4
.end method

.method removeView()V
    .registers 3

    .prologue
    .line 86
    iget-object v0, p0, Landroid/webkit/ViewManager$ChildView;->mView:Landroid/view/View;

    if-nez v0, :cond_5

    .line 94
    :goto_4
    return-void

    .line 89
    :cond_5
    iget-object v0, p0, Landroid/webkit/ViewManager$ChildView;->this$0:Landroid/webkit/ViewManager;

    #getter for: Landroid/webkit/ViewManager;->mWebView:Landroid/webkit/WebViewClassic;
    invoke-static {v0}, Landroid/webkit/ViewManager;->access$200(Landroid/webkit/ViewManager;)Landroid/webkit/WebViewClassic;

    move-result-object v0

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    new-instance v1, Landroid/webkit/ViewManager$ChildView$2;

    invoke-direct {v1, p0}, Landroid/webkit/ViewManager$ChildView$2;-><init>(Landroid/webkit/ViewManager$ChildView;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_4
.end method

.method setBounds(IIII)V
    .registers 5
    .parameter "x"
    .parameter "y"
    .parameter "width"
    .parameter "height"

    .prologue
    .line 50
    iput p1, p0, Landroid/webkit/ViewManager$ChildView;->x:I

    .line 51
    iput p2, p0, Landroid/webkit/ViewManager$ChildView;->y:I

    .line 52
    iput p3, p0, Landroid/webkit/ViewManager$ChildView;->width:I

    .line 53
    iput p4, p0, Landroid/webkit/ViewManager$ChildView;->height:I

    .line 54
    return-void
.end method
