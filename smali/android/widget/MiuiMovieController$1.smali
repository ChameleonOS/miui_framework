.class Landroid/widget/MiuiMovieController$1;
.super Ljava/lang/Object;
.source "MiuiMovieController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/MiuiMovieController;-><init>(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/MiuiMovieController;


# direct methods
.method constructor <init>(Landroid/widget/MiuiMovieController;)V
    .registers 2
    .parameter

    .prologue
    .line 101
    iput-object p1, p0, Landroid/widget/MiuiMovieController$1;->this$0:Landroid/widget/MiuiMovieController;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 2

    .prologue
    .line 103
    iget-object v0, p0, Landroid/widget/MiuiMovieController$1;->this$0:Landroid/widget/MiuiMovieController;

    #calls: Landroid/widget/MiuiMovieController;->startHiding()V
    invoke-static {v0}, Landroid/widget/MiuiMovieController;->access$000(Landroid/widget/MiuiMovieController;)V

    .line 104
    return-void
.end method
