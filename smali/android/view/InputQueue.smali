.class public final Landroid/view/InputQueue;
.super Ljava/lang/Object;
.source "InputQueue.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/InputQueue$Callback;
    }
.end annotation


# instance fields
.field final mChannel:Landroid/view/InputChannel;


# direct methods
.method public constructor <init>(Landroid/view/InputChannel;)V
    .registers 2
    .parameter "channel"

    .prologue
    .line 45
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-object p1, p0, Landroid/view/InputQueue;->mChannel:Landroid/view/InputChannel;

    .line 47
    return-void
.end method


# virtual methods
.method public getInputChannel()Landroid/view/InputChannel;
    .registers 2

    .prologue
    .line 51
    iget-object v0, p0, Landroid/view/InputQueue;->mChannel:Landroid/view/InputChannel;

    return-object v0
.end method
