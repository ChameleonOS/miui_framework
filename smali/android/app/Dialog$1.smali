.class Landroid/app/Dialog$1;
.super Ljava/lang/Object;
.source "Dialog.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/app/Dialog;


# direct methods
.method constructor <init>(Landroid/app/Dialog;)V
    .registers 2
    .parameter

    .prologue
    .line 117
    iput-object p1, p0, Landroid/app/Dialog$1;->this$0:Landroid/app/Dialog;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 2

    .prologue
    .line 119
    iget-object v0, p0, Landroid/app/Dialog$1;->this$0:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->dismissDialog()V

    .line 120
    return-void
.end method
