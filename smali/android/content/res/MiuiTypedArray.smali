.class public Landroid/content/res/MiuiTypedArray;
.super Landroid/content/res/TypedArray;
.source "MiuiTypedArray.java"


# instance fields
.field private mIsMiuiResources:Z


# direct methods
.method constructor <init>(Landroid/content/res/Resources;[I[II)V
    .registers 6
    .parameter "resources"
    .parameter "data"
    .parameter "indices"
    .parameter "len"

    .prologue
    .line 13
    invoke-direct {p0, p1, p2, p3, p4}, Landroid/content/res/TypedArray;-><init>(Landroid/content/res/Resources;[I[II)V

    .line 14
    invoke-virtual {p0}, Landroid/content/res/MiuiTypedArray;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    instance-of v0, v0, Landroid/content/res/MiuiResources;

    iput-boolean v0, p0, Landroid/content/res/MiuiTypedArray;->mIsMiuiResources:Z

    .line 15
    return-void
.end method

.method private loadStringValueAt(I)Ljava/lang/CharSequence;
    .registers 8
    .parameter "index"

    .prologue
    const/4 v4, 0x0

    .line 36
    iget-boolean v3, p0, Landroid/content/res/MiuiTypedArray;->mIsMiuiResources:Z

    if-nez v3, :cond_7

    move-object v0, v4

    .line 47
    :cond_6
    :goto_6
    return-object v0

    .line 39
    :cond_7
    iget-object v3, p0, Landroid/content/res/TypedArray;->mData:[I

    add-int/lit8 v5, p1, 0x0

    aget v2, v3, v5

    .line 40
    .local v2, type:I
    const/4 v3, 0x3

    if-ne v2, v3, :cond_22

    .line 41
    iget-object v3, p0, Landroid/content/res/TypedArray;->mData:[I

    add-int/lit8 v5, p1, 0x3

    aget v1, v3, v5

    .line 42
    .local v1, id:I
    invoke-virtual {p0}, Landroid/content/res/MiuiTypedArray;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    check-cast v3, Landroid/content/res/MiuiResources;

    invoke-virtual {v3, v1}, Landroid/content/res/MiuiResources;->getThemeCharSequence(I)Ljava/lang/CharSequence;

    move-result-object v0

    .line 43
    .local v0, cs:Ljava/lang/CharSequence;
    if-nez v0, :cond_6

    .end local v0           #cs:Ljava/lang/CharSequence;
    .end local v1           #id:I
    :cond_22
    move-object v0, v4

    .line 47
    goto :goto_6
.end method


# virtual methods
.method public getString(I)Ljava/lang/String;
    .registers 4
    .parameter "index"

    .prologue
    .line 28
    mul-int/lit8 v1, p1, 0x6

    invoke-direct {p0, v1}, Landroid/content/res/MiuiTypedArray;->loadStringValueAt(I)Ljava/lang/CharSequence;

    move-result-object v0

    .line 29
    .local v0, cs:Ljava/lang/CharSequence;
    if-eqz v0, :cond_d

    .line 30
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 32
    :goto_c
    return-object v1

    :cond_d
    invoke-super {p0, p1}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_c
.end method

.method public getText(I)Ljava/lang/CharSequence;
    .registers 4
    .parameter "index"

    .prologue
    .line 19
    mul-int/lit8 v1, p1, 0x6

    invoke-direct {p0, v1}, Landroid/content/res/MiuiTypedArray;->loadStringValueAt(I)Ljava/lang/CharSequence;

    move-result-object v0

    .line 20
    .local v0, cs:Ljava/lang/CharSequence;
    if-eqz v0, :cond_9

    .line 23
    .end local v0           #cs:Ljava/lang/CharSequence;
    :goto_8
    return-object v0

    .restart local v0       #cs:Ljava/lang/CharSequence;
    :cond_9
    invoke-super {p0, p1}, Landroid/content/res/TypedArray;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    goto :goto_8
.end method
