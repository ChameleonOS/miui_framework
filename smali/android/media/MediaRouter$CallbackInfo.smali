.class Landroid/media/MediaRouter$CallbackInfo;
.super Ljava/lang/Object;
.source "MediaRouter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/MediaRouter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "CallbackInfo"
.end annotation


# instance fields
.field public final cb:Landroid/media/MediaRouter$Callback;

.field public final router:Landroid/media/MediaRouter;

.field public type:I


# direct methods
.method public constructor <init>(Landroid/media/MediaRouter$Callback;ILandroid/media/MediaRouter;)V
    .registers 4
    .parameter "cb"
    .parameter "type"
    .parameter "router"

    .prologue
    .line 1488
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1489
    iput-object p1, p0, Landroid/media/MediaRouter$CallbackInfo;->cb:Landroid/media/MediaRouter$Callback;

    .line 1490
    iput p2, p0, Landroid/media/MediaRouter$CallbackInfo;->type:I

    .line 1491
    iput-object p3, p0, Landroid/media/MediaRouter$CallbackInfo;->router:Landroid/media/MediaRouter;

    .line 1492
    return-void
.end method
