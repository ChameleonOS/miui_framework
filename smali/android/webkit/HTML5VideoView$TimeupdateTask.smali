.class final Landroid/webkit/HTML5VideoView$TimeupdateTask;
.super Ljava/util/TimerTask;
.source "HTML5VideoView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/HTML5VideoView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "TimeupdateTask"
.end annotation


# instance fields
.field private mProxy:Landroid/webkit/HTML5VideoViewProxy;


# direct methods
.method public constructor <init>(Landroid/webkit/HTML5VideoViewProxy;)V
    .registers 2
    .parameter "proxy"

    .prologue
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    iput-object p1, p0, Landroid/webkit/HTML5VideoView$TimeupdateTask;->mProxy:Landroid/webkit/HTML5VideoViewProxy;

    return-void
.end method


# virtual methods
.method public run()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/webkit/HTML5VideoView$TimeupdateTask;->mProxy:Landroid/webkit/HTML5VideoViewProxy;

    invoke-virtual {v0}, Landroid/webkit/HTML5VideoViewProxy;->onTimeupdate()V

    return-void
.end method
