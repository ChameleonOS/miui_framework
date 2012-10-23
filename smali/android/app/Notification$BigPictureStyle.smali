.class public Landroid/app/Notification$BigPictureStyle;
.super Landroid/app/Notification$Style;
.source "Notification.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/Notification;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BigPictureStyle"
.end annotation


# instance fields
.field private mBigLargeIcon:Landroid/graphics/Bitmap;

.field private mBigLargeIconSet:Z

.field private mPicture:Landroid/graphics/Bitmap;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 1710
    invoke-direct {p0}, Landroid/app/Notification$Style;-><init>()V

    .line 1708
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/app/Notification$BigPictureStyle;->mBigLargeIconSet:Z

    .line 1711
    return-void
.end method

.method public constructor <init>(Landroid/app/Notification$Builder;)V
    .registers 3
    .parameter "builder"

    .prologue
    .line 1713
    invoke-direct {p0}, Landroid/app/Notification$Style;-><init>()V

    .line 1708
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/app/Notification$BigPictureStyle;->mBigLargeIconSet:Z

    .line 1714
    invoke-virtual {p0, p1}, Landroid/app/Notification$BigPictureStyle;->setBuilder(Landroid/app/Notification$Builder;)V

    .line 1715
    return-void
.end method

.method private makeBigContentView()Landroid/widget/RemoteViews;
    .registers 4

    .prologue
    .line 1749
    const v1, 0x1090073

    invoke-virtual {p0, v1}, Landroid/app/Notification$BigPictureStyle;->getStandardView(I)Landroid/widget/RemoteViews;

    move-result-object v0

    .line 1751
    .local v0, contentView:Landroid/widget/RemoteViews;
    const v1, 0x10202ed

    iget-object v2, p0, Landroid/app/Notification$BigPictureStyle;->mPicture:Landroid/graphics/Bitmap;

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 1753
    return-object v0
.end method


# virtual methods
.method public bigLargeIcon(Landroid/graphics/Bitmap;)Landroid/app/Notification$BigPictureStyle;
    .registers 3
    .parameter "b"

    .prologue
    .line 1743
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/app/Notification$BigPictureStyle;->mBigLargeIconSet:Z

    .line 1744
    iput-object p1, p0, Landroid/app/Notification$BigPictureStyle;->mBigLargeIcon:Landroid/graphics/Bitmap;

    .line 1745
    return-object p0
.end method

.method public bigPicture(Landroid/graphics/Bitmap;)Landroid/app/Notification$BigPictureStyle;
    .registers 2
    .parameter "b"

    .prologue
    .line 1735
    iput-object p1, p0, Landroid/app/Notification$BigPictureStyle;->mPicture:Landroid/graphics/Bitmap;

    .line 1736
    return-object p0
.end method

.method public build()Landroid/app/Notification;
    .registers 4

    .prologue
    .line 1758
    invoke-virtual {p0}, Landroid/app/Notification$BigPictureStyle;->checkBuilder()V

    .line 1759
    iget-object v1, p0, Landroid/app/Notification$Style;->mBuilder:Landroid/app/Notification$Builder;

    #calls: Landroid/app/Notification$Builder;->buildUnstyled()Landroid/app/Notification;
    invoke-static {v1}, Landroid/app/Notification$Builder;->access$500(Landroid/app/Notification$Builder;)Landroid/app/Notification;

    move-result-object v0

    .line 1760
    .local v0, wip:Landroid/app/Notification;
    iget-boolean v1, p0, Landroid/app/Notification$BigPictureStyle;->mBigLargeIconSet:Z

    if-eqz v1, :cond_14

    .line 1761
    iget-object v1, p0, Landroid/app/Notification$Style;->mBuilder:Landroid/app/Notification$Builder;

    iget-object v2, p0, Landroid/app/Notification$BigPictureStyle;->mBigLargeIcon:Landroid/graphics/Bitmap;

    #setter for: Landroid/app/Notification$Builder;->mLargeIcon:Landroid/graphics/Bitmap;
    invoke-static {v1, v2}, Landroid/app/Notification$Builder;->access$602(Landroid/app/Notification$Builder;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    .line 1763
    :cond_14
    invoke-direct {p0}, Landroid/app/Notification$BigPictureStyle;->makeBigContentView()Landroid/widget/RemoteViews;

    move-result-object v1

    iput-object v1, v0, Landroid/app/Notification;->bigContentView:Landroid/widget/RemoteViews;

    .line 1764
    return-object v0
.end method

.method public setBigContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$BigPictureStyle;
    .registers 2
    .parameter "title"

    .prologue
    .line 1722
    invoke-virtual {p0, p1}, Landroid/app/Notification$BigPictureStyle;->internalSetBigContentTitle(Ljava/lang/CharSequence;)V

    .line 1723
    return-object p0
.end method

.method public setSummaryText(Ljava/lang/CharSequence;)Landroid/app/Notification$BigPictureStyle;
    .registers 2
    .parameter "cs"

    .prologue
    .line 1730
    invoke-virtual {p0, p1}, Landroid/app/Notification$BigPictureStyle;->internalSetSummaryText(Ljava/lang/CharSequence;)V

    .line 1731
    return-object p0
.end method
