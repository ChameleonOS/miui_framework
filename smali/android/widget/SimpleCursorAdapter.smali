.class public Landroid/widget/SimpleCursorAdapter;
.super Landroid/widget/ResourceCursorAdapter;
.source "SimpleCursorAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/SimpleCursorAdapter$CursorToStringConverter;,
        Landroid/widget/SimpleCursorAdapter$ViewBinder;
    }
.end annotation


# instance fields
.field private mCursorToStringConverter:Landroid/widget/SimpleCursorAdapter$CursorToStringConverter;

.field protected mFrom:[I

.field mOriginalFrom:[Ljava/lang/String;

.field private mStringConversionColumn:I

.field protected mTo:[I

.field private mViewBinder:Landroid/widget/SimpleCursorAdapter$ViewBinder;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILandroid/database/Cursor;[Ljava/lang/String;[I)V
    .registers 7
    .parameter "context"
    .parameter "layout"
    .parameter "c"
    .parameter "from"
    .parameter "to"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ResourceCursorAdapter;-><init>(Landroid/content/Context;ILandroid/database/Cursor;)V

    const/4 v0, -0x1

    iput v0, p0, Landroid/widget/SimpleCursorAdapter;->mStringConversionColumn:I

    iput-object p5, p0, Landroid/widget/SimpleCursorAdapter;->mTo:[I

    iput-object p4, p0, Landroid/widget/SimpleCursorAdapter;->mOriginalFrom:[Ljava/lang/String;

    invoke-direct {p0, p3, p4}, Landroid/widget/SimpleCursorAdapter;->findColumns(Landroid/database/Cursor;[Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;ILandroid/database/Cursor;[Ljava/lang/String;[II)V
    .registers 8
    .parameter "context"
    .parameter "layout"
    .parameter "c"
    .parameter "from"
    .parameter "to"
    .parameter "flags"

    .prologue
    invoke-direct {p0, p1, p2, p3, p6}, Landroid/widget/ResourceCursorAdapter;-><init>(Landroid/content/Context;ILandroid/database/Cursor;I)V

    const/4 v0, -0x1

    iput v0, p0, Landroid/widget/SimpleCursorAdapter;->mStringConversionColumn:I

    iput-object p5, p0, Landroid/widget/SimpleCursorAdapter;->mTo:[I

    iput-object p4, p0, Landroid/widget/SimpleCursorAdapter;->mOriginalFrom:[Ljava/lang/String;

    invoke-direct {p0, p3, p4}, Landroid/widget/SimpleCursorAdapter;->findColumns(Landroid/database/Cursor;[Ljava/lang/String;)V

    return-void
.end method

.method private findColumns(Landroid/database/Cursor;[Ljava/lang/String;)V
    .registers 7
    .parameter "c"
    .parameter "from"

    .prologue
    if-eqz p1, :cond_20

    array-length v0, p2

    .local v0, count:I
    iget-object v2, p0, Landroid/widget/SimpleCursorAdapter;->mFrom:[I

    if-eqz v2, :cond_c

    iget-object v2, p0, Landroid/widget/SimpleCursorAdapter;->mFrom:[I

    array-length v2, v2

    if-eq v2, v0, :cond_10

    :cond_c
    new-array v2, v0, [I

    iput-object v2, p0, Landroid/widget/SimpleCursorAdapter;->mFrom:[I

    :cond_10
    const/4 v1, 0x0

    .local v1, i:I
    :goto_11
    if-ge v1, v0, :cond_23

    iget-object v2, p0, Landroid/widget/SimpleCursorAdapter;->mFrom:[I

    aget-object v3, p2, v1

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    aput v3, v2, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_11

    .end local v0           #count:I
    .end local v1           #i:I
    :cond_20
    const/4 v2, 0x0

    iput-object v2, p0, Landroid/widget/SimpleCursorAdapter;->mFrom:[I

    :cond_23
    return-void
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .registers 15
    .parameter "view"
    .parameter "context"
    .parameter "cursor"

    .prologue
    iget-object v0, p0, Landroid/widget/SimpleCursorAdapter;->mViewBinder:Landroid/widget/SimpleCursorAdapter$ViewBinder;

    .local v0, binder:Landroid/widget/SimpleCursorAdapter$ViewBinder;
    iget-object v8, p0, Landroid/widget/SimpleCursorAdapter;->mTo:[I

    array-length v2, v8

    .local v2, count:I
    iget-object v3, p0, Landroid/widget/SimpleCursorAdapter;->mFrom:[I

    .local v3, from:[I
    iget-object v6, p0, Landroid/widget/SimpleCursorAdapter;->mTo:[I

    .local v6, to:[I
    const/4 v4, 0x0

    .local v4, i:I
    :goto_a
    if-ge v4, v2, :cond_66

    aget v8, v6, v4

    invoke-virtual {p1, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    .local v7, v:Landroid/view/View;
    if-eqz v7, :cond_32

    const/4 v1, 0x0

    .local v1, bound:Z
    if-eqz v0, :cond_1d

    aget v8, v3, v4

    invoke-interface {v0, v7, p3, v8}, Landroid/widget/SimpleCursorAdapter$ViewBinder;->setViewValue(Landroid/view/View;Landroid/database/Cursor;I)Z

    move-result v1

    :cond_1d
    if-nez v1, :cond_32

    aget v8, v3, v4

    invoke-interface {p3, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .local v5, text:Ljava/lang/String;
    if-nez v5, :cond_29

    const-string v5, ""

    :cond_29
    instance-of v8, v7, Landroid/widget/TextView;

    if-eqz v8, :cond_35

    check-cast v7, Landroid/widget/TextView;

    .end local v7           #v:Landroid/view/View;
    invoke-virtual {p0, v7, v5}, Landroid/widget/SimpleCursorAdapter;->setViewText(Landroid/widget/TextView;Ljava/lang/String;)V

    .end local v1           #bound:Z
    .end local v5           #text:Ljava/lang/String;
    :cond_32
    :goto_32
    add-int/lit8 v4, v4, 0x1

    goto :goto_a

    .restart local v1       #bound:Z
    .restart local v5       #text:Ljava/lang/String;
    .restart local v7       #v:Landroid/view/View;
    :cond_35
    instance-of v8, v7, Landroid/widget/ImageView;

    if-eqz v8, :cond_3f

    check-cast v7, Landroid/widget/ImageView;

    .end local v7           #v:Landroid/view/View;
    invoke-virtual {p0, v7, v5}, Landroid/widget/SimpleCursorAdapter;->setViewImage(Landroid/widget/ImageView;Ljava/lang/String;)V

    goto :goto_32

    .restart local v7       #v:Landroid/view/View;
    :cond_3f
    new-instance v8, Ljava/lang/IllegalStateException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " is not a "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " view that can be bounds by this SimpleCursorAdapter"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v8

    .end local v1           #bound:Z
    .end local v5           #text:Ljava/lang/String;
    .end local v7           #v:Landroid/view/View;
    :cond_66
    return-void
.end method

.method public changeCursorAndColumns(Landroid/database/Cursor;[Ljava/lang/String;[I)V
    .registers 5
    .parameter "c"
    .parameter "from"
    .parameter "to"

    .prologue
    iput-object p2, p0, Landroid/widget/SimpleCursorAdapter;->mOriginalFrom:[Ljava/lang/String;

    iput-object p3, p0, Landroid/widget/SimpleCursorAdapter;->mTo:[I

    iget-object v0, p0, Landroid/widget/SimpleCursorAdapter;->mOriginalFrom:[Ljava/lang/String;

    invoke-direct {p0, p1, v0}, Landroid/widget/SimpleCursorAdapter;->findColumns(Landroid/database/Cursor;[Ljava/lang/String;)V

    invoke-super {p0, p1}, Landroid/widget/ResourceCursorAdapter;->changeCursor(Landroid/database/Cursor;)V

    return-void
.end method

.method public convertToString(Landroid/database/Cursor;)Ljava/lang/CharSequence;
    .registers 4
    .parameter "cursor"

    .prologue
    iget-object v0, p0, Landroid/widget/SimpleCursorAdapter;->mCursorToStringConverter:Landroid/widget/SimpleCursorAdapter$CursorToStringConverter;

    if-eqz v0, :cond_b

    iget-object v0, p0, Landroid/widget/SimpleCursorAdapter;->mCursorToStringConverter:Landroid/widget/SimpleCursorAdapter$CursorToStringConverter;

    invoke-interface {v0, p1}, Landroid/widget/SimpleCursorAdapter$CursorToStringConverter;->convertToString(Landroid/database/Cursor;)Ljava/lang/CharSequence;

    move-result-object v0

    :goto_a
    return-object v0

    :cond_b
    iget v0, p0, Landroid/widget/SimpleCursorAdapter;->mStringConversionColumn:I

    const/4 v1, -0x1

    if-le v0, v1, :cond_17

    iget v0, p0, Landroid/widget/SimpleCursorAdapter;->mStringConversionColumn:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_a

    :cond_17
    invoke-super {p0, p1}, Landroid/widget/ResourceCursorAdapter;->convertToString(Landroid/database/Cursor;)Ljava/lang/CharSequence;

    move-result-object v0

    goto :goto_a
.end method

.method public getCursorToStringConverter()Landroid/widget/SimpleCursorAdapter$CursorToStringConverter;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/widget/SimpleCursorAdapter;->mCursorToStringConverter:Landroid/widget/SimpleCursorAdapter$CursorToStringConverter;

    return-object v0
.end method

.method public getStringConversionColumn()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/widget/SimpleCursorAdapter;->mStringConversionColumn:I

    return v0
.end method

.method public getViewBinder()Landroid/widget/SimpleCursorAdapter$ViewBinder;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/widget/SimpleCursorAdapter;->mViewBinder:Landroid/widget/SimpleCursorAdapter$ViewBinder;

    return-object v0
.end method

.method public setCursorToStringConverter(Landroid/widget/SimpleCursorAdapter$CursorToStringConverter;)V
    .registers 2
    .parameter "cursorToStringConverter"

    .prologue
    iput-object p1, p0, Landroid/widget/SimpleCursorAdapter;->mCursorToStringConverter:Landroid/widget/SimpleCursorAdapter$CursorToStringConverter;

    return-void
.end method

.method public setStringConversionColumn(I)V
    .registers 2
    .parameter "stringConversionColumn"

    .prologue
    iput p1, p0, Landroid/widget/SimpleCursorAdapter;->mStringConversionColumn:I

    return-void
.end method

.method public setViewBinder(Landroid/widget/SimpleCursorAdapter$ViewBinder;)V
    .registers 2
    .parameter "viewBinder"

    .prologue
    iput-object p1, p0, Landroid/widget/SimpleCursorAdapter;->mViewBinder:Landroid/widget/SimpleCursorAdapter$ViewBinder;

    return-void
.end method

.method public setViewImage(Landroid/widget/ImageView;Ljava/lang/String;)V
    .registers 5
    .parameter "v"
    .parameter "value"

    .prologue
    :try_start_0
    invoke-static {p2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/widget/ImageView;->setImageResource(I)V
    :try_end_7
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_7} :catch_8

    :goto_7
    return-void

    :catch_8
    move-exception v0

    .local v0, nfe:Ljava/lang/NumberFormatException;
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/widget/ImageView;->setImageURI(Landroid/net/Uri;)V

    goto :goto_7
.end method

.method public setViewText(Landroid/widget/TextView;Ljava/lang/String;)V
    .registers 3
    .parameter "v"
    .parameter "text"

    .prologue
    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;
    .registers 3
    .parameter "c"

    .prologue
    iget-object v0, p0, Landroid/widget/SimpleCursorAdapter;->mOriginalFrom:[Ljava/lang/String;

    invoke-direct {p0, p1, v0}, Landroid/widget/SimpleCursorAdapter;->findColumns(Landroid/database/Cursor;[Ljava/lang/String;)V

    invoke-super {p0, p1}, Landroid/widget/ResourceCursorAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method
