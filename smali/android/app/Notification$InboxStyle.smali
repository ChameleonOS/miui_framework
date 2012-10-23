.class public Landroid/app/Notification$InboxStyle;
.super Landroid/app/Notification$Style;
.source "Notification.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/Notification;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InboxStyle"
.end annotation


# instance fields
.field private mTexts:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/CharSequence;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 3

    .prologue
    .line 1868
    invoke-direct {p0}, Landroid/app/Notification$Style;-><init>()V

    .line 1866
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Landroid/app/Notification$InboxStyle;->mTexts:Ljava/util/ArrayList;

    .line 1869
    return-void
.end method

.method public constructor <init>(Landroid/app/Notification$Builder;)V
    .registers 4
    .parameter "builder"

    .prologue
    .line 1871
    invoke-direct {p0}, Landroid/app/Notification$Style;-><init>()V

    .line 1866
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Landroid/app/Notification$InboxStyle;->mTexts:Ljava/util/ArrayList;

    .line 1872
    invoke-virtual {p0, p1}, Landroid/app/Notification$InboxStyle;->setBuilder(Landroid/app/Notification$Builder;)V

    .line 1873
    return-void
.end method

.method private makeBigContentView()Landroid/widget/RemoteViews;
    .registers 14

    .prologue
    const v12, 0x10202f5

    const/4 v11, 0x0

    const/16 v10, 0x8

    .line 1899
    iget-object v8, p0, Landroid/app/Notification$Style;->mBuilder:Landroid/app/Notification$Builder;

    const/4 v9, 0x0

    #setter for: Landroid/app/Notification$Builder;->mContentText:Ljava/lang/CharSequence;
    invoke-static {v8, v9}, Landroid/app/Notification$Builder;->access$702(Landroid/app/Notification$Builder;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    .line 1900
    const v8, 0x1090075

    invoke-virtual {p0, v8}, Landroid/app/Notification$InboxStyle;->getStandardView(I)Landroid/widget/RemoteViews;

    move-result-object v1

    .line 1902
    .local v1, contentView:Landroid/widget/RemoteViews;
    const v8, 0x1020015

    invoke-virtual {v1, v8, v10}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 1904
    const/4 v8, 0x7

    new-array v6, v8, [I

    fill-array-data v6, :array_68

    .line 1908
    .local v6, rowIds:[I
    move-object v0, v6

    .local v0, arr$:[I
    array-length v4, v0

    .local v4, len$:I
    const/4 v3, 0x0

    .local v3, i$:I
    :goto_22
    if-ge v3, v4, :cond_2c

    aget v5, v0, v3

    .line 1909
    .local v5, rowId:I
    invoke-virtual {v1, v5, v10}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 1908
    add-int/lit8 v3, v3, 0x1

    goto :goto_22

    .line 1912
    .end local v5           #rowId:I
    :cond_2c
    const/4 v2, 0x0

    .line 1913
    .local v2, i:I
    :goto_2d
    iget-object v8, p0, Landroid/app/Notification$InboxStyle;->mTexts:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v8

    if-ge v2, v8, :cond_57

    array-length v8, v6

    if-ge v2, v8, :cond_57

    .line 1914
    iget-object v8, p0, Landroid/app/Notification$InboxStyle;->mTexts:Ljava/util/ArrayList;

    invoke-virtual {v8, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/CharSequence;

    .line 1915
    .local v7, str:Ljava/lang/CharSequence;
    if-eqz v7, :cond_54

    const-string v8, ""

    invoke-virtual {v7, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_54

    .line 1916
    aget v8, v6, v2

    invoke-virtual {v1, v8, v11}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 1917
    aget v8, v6, v2

    invoke-virtual {v1, v8, v7}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 1919
    :cond_54
    add-int/lit8 v2, v2, 0x1

    .line 1920
    goto :goto_2d

    .line 1922
    .end local v7           #str:Ljava/lang/CharSequence;
    :cond_57
    iget-object v8, p0, Landroid/app/Notification$InboxStyle;->mTexts:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v8

    array-length v9, v6

    if-le v8, v9, :cond_64

    .line 1923
    invoke-virtual {v1, v12, v11}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 1928
    :goto_63
    return-object v1

    .line 1925
    :cond_64
    invoke-virtual {v1, v12, v10}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    goto :goto_63

    .line 1904
    :array_68
    .array-data 0x4
        0xeet 0x2t 0x2t 0x1t
        0xeft 0x2t 0x2t 0x1t
        0xf0t 0x2t 0x2t 0x1t
        0xf1t 0x2t 0x2t 0x1t
        0xf2t 0x2t 0x2t 0x1t
        0xf3t 0x2t 0x2t 0x1t
        0xf4t 0x2t 0x2t 0x1t
    .end array-data
.end method


# virtual methods
.method public addLine(Ljava/lang/CharSequence;)Landroid/app/Notification$InboxStyle;
    .registers 3
    .parameter "cs"

    .prologue
    .line 1893
    iget-object v0, p0, Landroid/app/Notification$InboxStyle;->mTexts:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1894
    return-object p0
.end method

.method public build()Landroid/app/Notification;
    .registers 3

    .prologue
    .line 1933
    invoke-virtual {p0}, Landroid/app/Notification$InboxStyle;->checkBuilder()V

    .line 1934
    iget-object v1, p0, Landroid/app/Notification$Style;->mBuilder:Landroid/app/Notification$Builder;

    #calls: Landroid/app/Notification$Builder;->buildUnstyled()Landroid/app/Notification;
    invoke-static {v1}, Landroid/app/Notification$Builder;->access$500(Landroid/app/Notification$Builder;)Landroid/app/Notification;

    move-result-object v0

    .line 1935
    .local v0, wip:Landroid/app/Notification;
    invoke-direct {p0}, Landroid/app/Notification$InboxStyle;->makeBigContentView()Landroid/widget/RemoteViews;

    move-result-object v1

    iput-object v1, v0, Landroid/app/Notification;->bigContentView:Landroid/widget/RemoteViews;

    .line 1936
    return-object v0
.end method

.method public setBigContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$InboxStyle;
    .registers 2
    .parameter "title"

    .prologue
    .line 1880
    invoke-virtual {p0, p1}, Landroid/app/Notification$InboxStyle;->internalSetBigContentTitle(Ljava/lang/CharSequence;)V

    .line 1881
    return-object p0
.end method

.method public setSummaryText(Ljava/lang/CharSequence;)Landroid/app/Notification$InboxStyle;
    .registers 2
    .parameter "cs"

    .prologue
    .line 1888
    invoke-virtual {p0, p1}, Landroid/app/Notification$InboxStyle;->internalSetSummaryText(Ljava/lang/CharSequence;)V

    .line 1889
    return-object p0
.end method
