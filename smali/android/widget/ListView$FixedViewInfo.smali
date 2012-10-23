.class public Landroid/widget/ListView$FixedViewInfo;
.super Ljava/lang/Object;
.source "ListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/ListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "FixedViewInfo"
.end annotation


# instance fields
.field public data:Ljava/lang/Object;

.field public isSelectable:Z

.field final synthetic this$0:Landroid/widget/ListView;

.field public view:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/widget/ListView;)V
    .registers 2
    .parameter

    .prologue
    .line 93
    iput-object p1, p0, Landroid/widget/ListView$FixedViewInfo;->this$0:Landroid/widget/ListView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
