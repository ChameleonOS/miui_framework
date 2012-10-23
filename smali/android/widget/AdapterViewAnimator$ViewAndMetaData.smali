.class Landroid/widget/AdapterViewAnimator$ViewAndMetaData;
.super Ljava/lang/Object;
.source "AdapterViewAnimator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/AdapterViewAnimator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewAndMetaData"
.end annotation


# instance fields
.field adapterPosition:I

.field itemId:J

.field relativeIndex:I

.field final synthetic this$0:Landroid/widget/AdapterViewAnimator;

.field view:Landroid/view/View;


# direct methods
.method constructor <init>(Landroid/widget/AdapterViewAnimator;Landroid/view/View;IIJ)V
    .registers 7
    .parameter
    .parameter "view"
    .parameter "relativeIndex"
    .parameter "adapterPosition"
    .parameter "itemId"

    .prologue
    .line 219
    iput-object p1, p0, Landroid/widget/AdapterViewAnimator$ViewAndMetaData;->this$0:Landroid/widget/AdapterViewAnimator;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 220
    iput-object p2, p0, Landroid/widget/AdapterViewAnimator$ViewAndMetaData;->view:Landroid/view/View;

    .line 221
    iput p3, p0, Landroid/widget/AdapterViewAnimator$ViewAndMetaData;->relativeIndex:I

    .line 222
    iput p4, p0, Landroid/widget/AdapterViewAnimator$ViewAndMetaData;->adapterPosition:I

    .line 223
    iput-wide p5, p0, Landroid/widget/AdapterViewAnimator$ViewAndMetaData;->itemId:J

    .line 224
    return-void
.end method
