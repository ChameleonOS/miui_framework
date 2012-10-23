.class public abstract Landroid/widget/SimpleCursorTreeAdapter;
.super Landroid/widget/ResourceCursorTreeAdapter;
.source "SimpleCursorTreeAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/SimpleCursorTreeAdapter$ViewBinder;
    }
.end annotation


# instance fields
.field private mChildFrom:[I

.field private mChildFromNames:[Ljava/lang/String;

.field private mChildTo:[I

.field private mGroupFrom:[I

.field private mGroupFromNames:[Ljava/lang/String;

.field private mGroupTo:[I

.field private mViewBinder:Landroid/widget/SimpleCursorTreeAdapter$ViewBinder;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;II[Ljava/lang/String;[III[Ljava/lang/String;[I)V
    .registers 20
    .parameter "context"
    .parameter "cursor"
    .parameter "collapsedGroupLayout"
    .parameter "expandedGroupLayout"
    .parameter "groupFrom"
    .parameter "groupTo"
    .parameter "childLayout"
    .parameter "lastChildLayout"
    .parameter "childFrom"
    .parameter "childTo"

    .prologue
    .line 105
    move-object v2, p0

    move-object v3, p1

    move-object v4, p2

    move v5, p3

    move v6, p4

    move/from16 v7, p7

    move/from16 v8, p8

    invoke-direct/range {v2 .. v8}, Landroid/widget/ResourceCursorTreeAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;IIII)V

    .line 107
    move-object/from16 v0, p9

    move-object/from16 v1, p10

    invoke-direct {p0, p5, p6, v0, v1}, Landroid/widget/SimpleCursorTreeAdapter;->init([Ljava/lang/String;[I[Ljava/lang/String;[I)V

    .line 108
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;II[Ljava/lang/String;[II[Ljava/lang/String;[I)V
    .registers 16
    .parameter "context"
    .parameter "cursor"
    .parameter "collapsedGroupLayout"
    .parameter "expandedGroupLayout"
    .parameter "groupFrom"
    .parameter "groupTo"
    .parameter "childLayout"
    .parameter "childFrom"
    .parameter "childTo"

    .prologue
    .line 142
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move v4, p4

    move v5, p7

    invoke-direct/range {v0 .. v5}, Landroid/widget/ResourceCursorTreeAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;III)V

    .line 143
    invoke-direct {p0, p5, p6, p8, p9}, Landroid/widget/SimpleCursorTreeAdapter;->init([Ljava/lang/String;[I[Ljava/lang/String;[I)V

    .line 144
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;I[Ljava/lang/String;[II[Ljava/lang/String;[I)V
    .registers 9
    .parameter "context"
    .parameter "cursor"
    .parameter "groupLayout"
    .parameter "groupFrom"
    .parameter "groupTo"
    .parameter "childLayout"
    .parameter "childFrom"
    .parameter "childTo"

    .prologue
    .line 175
    invoke-direct {p0, p1, p2, p3, p6}, Landroid/widget/ResourceCursorTreeAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;II)V

    .line 176
    invoke-direct {p0, p4, p5, p7, p8}, Landroid/widget/SimpleCursorTreeAdapter;->init([Ljava/lang/String;[I[Ljava/lang/String;[I)V

    .line 177
    return-void
.end method

.method private bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;[I[I)V
    .registers 13
    .parameter "view"
    .parameter "context"
    .parameter "cursor"
    .parameter "from"
    .parameter "to"

    .prologue
    .line 213
    iget-object v0, p0, Landroid/widget/SimpleCursorTreeAdapter;->mViewBinder:Landroid/widget/SimpleCursorTreeAdapter$ViewBinder;

    .line 215
    .local v0, binder:Landroid/widget/SimpleCursorTreeAdapter$ViewBinder;
    const/4 v2, 0x0

    .local v2, i:I
    :goto_3
    array-length v5, p5

    if-ge v2, v5, :cond_41

    .line 216
    aget v5, p5, v2

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 217
    .local v4, v:Landroid/view/View;
    if-eqz v4, :cond_2c

    .line 218
    const/4 v1, 0x0

    .line 219
    .local v1, bound:Z
    if-eqz v0, :cond_17

    .line 220
    aget v5, p4, v2

    invoke-interface {v0, v4, p3, v5}, Landroid/widget/SimpleCursorTreeAdapter$ViewBinder;->setViewValue(Landroid/view/View;Landroid/database/Cursor;I)Z

    move-result v1

    .line 223
    :cond_17
    if-nez v1, :cond_2c

    .line 224
    aget v5, p4, v2

    invoke-interface {p3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 225
    .local v3, text:Ljava/lang/String;
    if-nez v3, :cond_23

    .line 226
    const-string v3, ""

    .line 228
    :cond_23
    instance-of v5, v4, Landroid/widget/TextView;

    if-eqz v5, :cond_2f

    .line 229
    check-cast v4, Landroid/widget/TextView;

    .end local v4           #v:Landroid/view/View;
    invoke-virtual {p0, v4, v3}, Landroid/widget/SimpleCursorTreeAdapter;->setViewText(Landroid/widget/TextView;Ljava/lang/String;)V

    .line 215
    .end local v1           #bound:Z
    .end local v3           #text:Ljava/lang/String;
    :cond_2c
    :goto_2c
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .line 230
    .restart local v1       #bound:Z
    .restart local v3       #text:Ljava/lang/String;
    .restart local v4       #v:Landroid/view/View;
    :cond_2f
    instance-of v5, v4, Landroid/widget/ImageView;

    if-eqz v5, :cond_39

    .line 231
    check-cast v4, Landroid/widget/ImageView;

    .end local v4           #v:Landroid/view/View;
    invoke-virtual {p0, v4, v3}, Landroid/widget/SimpleCursorTreeAdapter;->setViewImage(Landroid/widget/ImageView;Ljava/lang/String;)V

    goto :goto_2c

    .line 233
    .restart local v4       #v:Landroid/view/View;
    :cond_39
    new-instance v5, Ljava/lang/IllegalStateException;

    const-string v6, "SimpleCursorTreeAdapter can bind values only to TextView and ImageView!"

    invoke-direct {v5, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 239
    .end local v1           #bound:Z
    .end local v3           #text:Ljava/lang/String;
    .end local v4           #v:Landroid/view/View;
    :cond_41
    return-void
.end method

.method private init([Ljava/lang/String;[I[Ljava/lang/String;[I)V
    .registers 5
    .parameter "groupFromNames"
    .parameter "groupTo"
    .parameter "childFromNames"
    .parameter "childTo"

    .prologue
    .line 182
    iput-object p1, p0, Landroid/widget/SimpleCursorTreeAdapter;->mGroupFromNames:[Ljava/lang/String;

    .line 183
    iput-object p2, p0, Landroid/widget/SimpleCursorTreeAdapter;->mGroupTo:[I

    .line 185
    iput-object p3, p0, Landroid/widget/SimpleCursorTreeAdapter;->mChildFromNames:[Ljava/lang/String;

    .line 186
    iput-object p4, p0, Landroid/widget/SimpleCursorTreeAdapter;->mChildTo:[I

    .line 187
    return-void
.end method

.method private initFromColumns(Landroid/database/Cursor;[Ljava/lang/String;[I)V
    .registers 6
    .parameter "cursor"
    .parameter "fromColumnNames"
    .parameter "fromColumns"

    .prologue
    .line 242
    array-length v1, p2

    add-int/lit8 v0, v1, -0x1

    .local v0, i:I
    :goto_3
    if-ltz v0, :cond_10

    .line 243
    aget-object v1, p2, v0

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    aput v1, p3, v0

    .line 242
    add-int/lit8 v0, v0, -0x1

    goto :goto_3

    .line 245
    :cond_10
    return-void
.end method


# virtual methods
.method protected bindChildView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;Z)V
    .registers 11
    .parameter "view"
    .parameter "context"
    .parameter "cursor"
    .parameter "isLastChild"

    .prologue
    .line 249
    iget-object v0, p0, Landroid/widget/SimpleCursorTreeAdapter;->mChildFrom:[I

    if-nez v0, :cond_12

    .line 250
    iget-object v0, p0, Landroid/widget/SimpleCursorTreeAdapter;->mChildFromNames:[Ljava/lang/String;

    array-length v0, v0

    new-array v0, v0, [I

    iput-object v0, p0, Landroid/widget/SimpleCursorTreeAdapter;->mChildFrom:[I

    .line 251
    iget-object v0, p0, Landroid/widget/SimpleCursorTreeAdapter;->mChildFromNames:[Ljava/lang/String;

    iget-object v1, p0, Landroid/widget/SimpleCursorTreeAdapter;->mChildFrom:[I

    invoke-direct {p0, p3, v0, v1}, Landroid/widget/SimpleCursorTreeAdapter;->initFromColumns(Landroid/database/Cursor;[Ljava/lang/String;[I)V

    .line 254
    :cond_12
    iget-object v4, p0, Landroid/widget/SimpleCursorTreeAdapter;->mChildFrom:[I

    iget-object v5, p0, Landroid/widget/SimpleCursorTreeAdapter;->mChildTo:[I

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-direct/range {v0 .. v5}, Landroid/widget/SimpleCursorTreeAdapter;->bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;[I[I)V

    .line 255
    return-void
.end method

.method protected bindGroupView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;Z)V
    .registers 11
    .parameter "view"
    .parameter "context"
    .parameter "cursor"
    .parameter "isExpanded"

    .prologue
    .line 259
    iget-object v0, p0, Landroid/widget/SimpleCursorTreeAdapter;->mGroupFrom:[I

    if-nez v0, :cond_12

    .line 260
    iget-object v0, p0, Landroid/widget/SimpleCursorTreeAdapter;->mGroupFromNames:[Ljava/lang/String;

    array-length v0, v0

    new-array v0, v0, [I

    iput-object v0, p0, Landroid/widget/SimpleCursorTreeAdapter;->mGroupFrom:[I

    .line 261
    iget-object v0, p0, Landroid/widget/SimpleCursorTreeAdapter;->mGroupFromNames:[Ljava/lang/String;

    iget-object v1, p0, Landroid/widget/SimpleCursorTreeAdapter;->mGroupFrom:[I

    invoke-direct {p0, p3, v0, v1}, Landroid/widget/SimpleCursorTreeAdapter;->initFromColumns(Landroid/database/Cursor;[Ljava/lang/String;[I)V

    .line 264
    :cond_12
    iget-object v4, p0, Landroid/widget/SimpleCursorTreeAdapter;->mGroupFrom:[I

    iget-object v5, p0, Landroid/widget/SimpleCursorTreeAdapter;->mGroupTo:[I

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-direct/range {v0 .. v5}, Landroid/widget/SimpleCursorTreeAdapter;->bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;[I[I)V

    .line 265
    return-void
.end method

.method public getViewBinder()Landroid/widget/SimpleCursorTreeAdapter$ViewBinder;
    .registers 2

    .prologue
    .line 197
    iget-object v0, p0, Landroid/widget/SimpleCursorTreeAdapter;->mViewBinder:Landroid/widget/SimpleCursorTreeAdapter$ViewBinder;

    return-object v0
.end method

.method public setViewBinder(Landroid/widget/SimpleCursorTreeAdapter$ViewBinder;)V
    .registers 2
    .parameter "viewBinder"

    .prologue
    .line 209
    iput-object p1, p0, Landroid/widget/SimpleCursorTreeAdapter;->mViewBinder:Landroid/widget/SimpleCursorTreeAdapter$ViewBinder;

    .line 210
    return-void
.end method

.method protected setViewImage(Landroid/widget/ImageView;Ljava/lang/String;)V
    .registers 5
    .parameter "v"
    .parameter "value"

    .prologue
    .line 277
    :try_start_0
    invoke-static {p2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/widget/ImageView;->setImageResource(I)V
    :try_end_7
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_7} :catch_8

    .line 281
    :goto_7
    return-void

    .line 278
    :catch_8
    move-exception v0

    .line 279
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
    .line 295
    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 296
    return-void
.end method
