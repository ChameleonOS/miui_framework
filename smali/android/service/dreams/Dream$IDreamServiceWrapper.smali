.class Landroid/service/dreams/Dream$IDreamServiceWrapper;
.super Landroid/service/dreams/IDreamService$Stub;
.source "Dream.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/service/dreams/Dream;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "IDreamServiceWrapper"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/service/dreams/Dream;


# direct methods
.method public constructor <init>(Landroid/service/dreams/Dream;)V
    .registers 2
    .parameter

    .prologue
    .line 376
    iput-object p1, p0, Landroid/service/dreams/Dream$IDreamServiceWrapper;->this$0:Landroid/service/dreams/Dream;

    invoke-direct {p0}, Landroid/service/dreams/IDreamService$Stub;-><init>()V

    .line 377
    return-void
.end method


# virtual methods
.method public attach(Landroid/os/IBinder;)V
    .registers 3
    .parameter "windowToken"

    .prologue
    .line 380
    iget-object v0, p0, Landroid/service/dreams/Dream$IDreamServiceWrapper;->this$0:Landroid/service/dreams/Dream;

    invoke-virtual {v0, p1}, Landroid/service/dreams/Dream;->attach(Landroid/os/IBinder;)V

    .line 381
    return-void
.end method
