.class Landroid/widget/RemoteViewsAdapter$RemoteViewsIndexMetaData;
.super Ljava/lang/Object;
.source "RemoteViewsAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/RemoteViewsAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RemoteViewsIndexMetaData"
.end annotation


# instance fields
.field isRequested:Z

.field itemId:J

.field final synthetic this$0:Landroid/widget/RemoteViewsAdapter;

.field typeId:I


# direct methods
.method public constructor <init>(Landroid/widget/RemoteViewsAdapter;Landroid/widget/RemoteViews;JZ)V
    .registers 6
    .parameter
    .parameter "v"
    .parameter "itemId"
    .parameter "requested"

    .prologue
    .line 459
    iput-object p1, p0, Landroid/widget/RemoteViewsAdapter$RemoteViewsIndexMetaData;->this$0:Landroid/widget/RemoteViewsAdapter;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 460
    invoke-virtual {p0, p2, p3, p4, p5}, Landroid/widget/RemoteViewsAdapter$RemoteViewsIndexMetaData;->set(Landroid/widget/RemoteViews;JZ)V

    .line 461
    return-void
.end method


# virtual methods
.method public set(Landroid/widget/RemoteViews;JZ)V
    .registers 6
    .parameter "v"
    .parameter "id"
    .parameter "requested"

    .prologue
    .line 464
    iput-wide p2, p0, Landroid/widget/RemoteViewsAdapter$RemoteViewsIndexMetaData;->itemId:J

    .line 465
    if-eqz p1, :cond_d

    .line 466
    invoke-virtual {p1}, Landroid/widget/RemoteViews;->getLayoutId()I

    move-result v0

    iput v0, p0, Landroid/widget/RemoteViewsAdapter$RemoteViewsIndexMetaData;->typeId:I

    .line 469
    :goto_a
    iput-boolean p4, p0, Landroid/widget/RemoteViewsAdapter$RemoteViewsIndexMetaData;->isRequested:Z

    .line 470
    return-void

    .line 468
    :cond_d
    const/4 v0, 0x0

    iput v0, p0, Landroid/widget/RemoteViewsAdapter$RemoteViewsIndexMetaData;->typeId:I

    goto :goto_a
.end method
