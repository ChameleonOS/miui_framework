.class public abstract Landroid/app/Notification$Style;
.super Ljava/lang/Object;
.source "Notification.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/Notification;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Style"
.end annotation


# instance fields
.field private mBigContentTitle:Ljava/lang/CharSequence;

.field protected mBuilder:Landroid/app/Notification$Builder;

.field private mSummaryText:Ljava/lang/CharSequence;

.field private mSummaryTextSet:Z


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 1615
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1618
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/app/Notification$Style;->mSummaryText:Ljava/lang/CharSequence;

    .line 1619
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/app/Notification$Style;->mSummaryTextSet:Z

    return-void
.end method


# virtual methods
.method public abstract build()Landroid/app/Notification;
.end method

.method protected checkBuilder()V
    .registers 3

    .prologue
    .line 1649
    iget-object v0, p0, Landroid/app/Notification$Style;->mBuilder:Landroid/app/Notification$Builder;

    if-nez v0, :cond_c

    .line 1650
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Style requires a valid Builder object"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1652
    :cond_c
    return-void
.end method

.method protected getStandardView(I)Landroid/widget/RemoteViews;
    .registers 11
    .parameter "layoutId"

    .prologue
    const v8, 0x10202f1

    const v7, 0x10202e8

    const v6, 0x10202e6

    const/16 v5, 0x8

    const/4 v4, 0x0

    .line 1655
    invoke-virtual {p0}, Landroid/app/Notification$Style;->checkBuilder()V

    .line 1657
    iget-object v2, p0, Landroid/app/Notification$Style;->mBigContentTitle:Ljava/lang/CharSequence;

    if-eqz v2, :cond_1a

    .line 1658
    iget-object v2, p0, Landroid/app/Notification$Style;->mBuilder:Landroid/app/Notification$Builder;

    iget-object v3, p0, Landroid/app/Notification$Style;->mBigContentTitle:Ljava/lang/CharSequence;

    invoke-virtual {v2, v3}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 1661
    :cond_1a
    iget-object v2, p0, Landroid/app/Notification$Style;->mBuilder:Landroid/app/Notification$Builder;

    #calls: Landroid/app/Notification$Builder;->applyStandardTemplateWithActions(I)Landroid/widget/RemoteViews;
    invoke-static {v2, p1}, Landroid/app/Notification$Builder;->access$300(Landroid/app/Notification$Builder;I)Landroid/widget/RemoteViews;

    move-result-object v0

    .line 1663
    .local v0, contentView:Landroid/widget/RemoteViews;
    iget-object v2, p0, Landroid/app/Notification$Style;->mBigContentTitle:Ljava/lang/CharSequence;

    if-eqz v2, :cond_46

    iget-object v2, p0, Landroid/app/Notification$Style;->mBigContentTitle:Ljava/lang/CharSequence;

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_46

    .line 1664
    invoke-virtual {v0, v6, v5}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 1670
    :goto_31
    iget-boolean v2, p0, Landroid/app/Notification$Style;->mSummaryTextSet:Z

    if-eqz v2, :cond_4a

    iget-object v1, p0, Landroid/app/Notification$Style;->mSummaryText:Ljava/lang/CharSequence;

    .line 1673
    .local v1, overflowText:Ljava/lang/CharSequence;
    :goto_37
    if-eqz v1, :cond_51

    .line 1674
    const v2, 0x1020046

    invoke-virtual {v0, v2, v1}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 1675
    invoke-virtual {v0, v8, v4}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 1676
    invoke-virtual {v0, v7, v4}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 1682
    :goto_45
    return-object v0

    .line 1666
    .end local v1           #overflowText:Ljava/lang/CharSequence;
    :cond_46
    invoke-virtual {v0, v6, v4}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    goto :goto_31

    .line 1670
    :cond_4a
    iget-object v2, p0, Landroid/app/Notification$Style;->mBuilder:Landroid/app/Notification$Builder;

    #getter for: Landroid/app/Notification$Builder;->mSubText:Ljava/lang/CharSequence;
    invoke-static {v2}, Landroid/app/Notification$Builder;->access$400(Landroid/app/Notification$Builder;)Ljava/lang/CharSequence;

    move-result-object v1

    goto :goto_37

    .line 1678
    .restart local v1       #overflowText:Ljava/lang/CharSequence;
    :cond_51
    invoke-virtual {v0, v8, v5}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 1679
    invoke-virtual {v0, v7, v5}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    goto :goto_45
.end method

.method protected internalSetBigContentTitle(Ljava/lang/CharSequence;)V
    .registers 2
    .parameter "title"

    .prologue
    .line 1628
    iput-object p1, p0, Landroid/app/Notification$Style;->mBigContentTitle:Ljava/lang/CharSequence;

    .line 1629
    return-void
.end method

.method protected internalSetSummaryText(Ljava/lang/CharSequence;)V
    .registers 3
    .parameter "cs"

    .prologue
    .line 1635
    iput-object p1, p0, Landroid/app/Notification$Style;->mSummaryText:Ljava/lang/CharSequence;

    .line 1636
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/app/Notification$Style;->mSummaryTextSet:Z

    .line 1637
    return-void
.end method

.method public setBuilder(Landroid/app/Notification$Builder;)V
    .registers 3
    .parameter "builder"

    .prologue
    .line 1640
    iget-object v0, p0, Landroid/app/Notification$Style;->mBuilder:Landroid/app/Notification$Builder;

    if-eq v0, p1, :cond_f

    .line 1641
    iput-object p1, p0, Landroid/app/Notification$Style;->mBuilder:Landroid/app/Notification$Builder;

    .line 1642
    iget-object v0, p0, Landroid/app/Notification$Style;->mBuilder:Landroid/app/Notification$Builder;

    if-eqz v0, :cond_f

    .line 1643
    iget-object v0, p0, Landroid/app/Notification$Style;->mBuilder:Landroid/app/Notification$Builder;

    invoke-virtual {v0, p0}, Landroid/app/Notification$Builder;->setStyle(Landroid/app/Notification$Style;)Landroid/app/Notification$Builder;

    .line 1646
    :cond_f
    return-void
.end method
