.class public Landroid/text/method/MultiTapKeyListener;
.super Landroid/text/method/BaseKeyListener;
.source "MultiTapKeyListener.java"

# interfaces
.implements Landroid/text/SpanWatcher;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/text/method/MultiTapKeyListener$Timeout;
    }
.end annotation


# static fields
.field private static sInstance:[Landroid/text/method/MultiTapKeyListener;

.field private static final sRecs:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mAutoText:Z

.field private mCapitalize:Landroid/text/method/TextKeyListener$Capitalize;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    invoke-static {}, Landroid/text/method/TextKeyListener$Capitalize;->values()[Landroid/text/method/TextKeyListener$Capitalize;

    move-result-object v0

    array-length v0, v0

    mul-int/lit8 v0, v0, 0x2

    new-array v0, v0, [Landroid/text/method/MultiTapKeyListener;

    sput-object v0, Landroid/text/method/MultiTapKeyListener;->sInstance:[Landroid/text/method/MultiTapKeyListener;

    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    sput-object v0, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    sget-object v0, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    const/16 v1, 0x8

    const-string v2, ".,1!@#$%^&*:/?\'=()"

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    sget-object v0, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    const/16 v1, 0x9

    const-string v2, "abc2ABC"

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    sget-object v0, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    const/16 v1, 0xa

    const-string v2, "def3DEF"

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    sget-object v0, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    const/16 v1, 0xb

    const-string v2, "ghi4GHI"

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    sget-object v0, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    const/16 v1, 0xc

    const-string v2, "jkl5JKL"

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    sget-object v0, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    const/16 v1, 0xd

    const-string/jumbo v2, "mno6MNO"

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    sget-object v0, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    const/16 v1, 0xe

    const-string/jumbo v2, "pqrs7PQRS"

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    sget-object v0, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    const/16 v1, 0xf

    const-string/jumbo v2, "tuv8TUV"

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    sget-object v0, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    const/16 v1, 0x10

    const-string/jumbo v2, "wxyz9WXYZ"

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    sget-object v0, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    const/4 v1, 0x7

    const-string v2, "0+"

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    sget-object v0, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    const/16 v1, 0x12

    const-string v2, " "

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    return-void
.end method

.method public constructor <init>(Landroid/text/method/TextKeyListener$Capitalize;Z)V
    .registers 3
    .parameter "cap"
    .parameter "autotext"

    .prologue
    invoke-direct {p0}, Landroid/text/method/BaseKeyListener;-><init>()V

    iput-object p1, p0, Landroid/text/method/MultiTapKeyListener;->mCapitalize:Landroid/text/method/TextKeyListener$Capitalize;

    iput-boolean p2, p0, Landroid/text/method/MultiTapKeyListener;->mAutoText:Z

    return-void
.end method

.method public static getInstance(ZLandroid/text/method/TextKeyListener$Capitalize;)Landroid/text/method/MultiTapKeyListener;
    .registers 5
    .parameter "autotext"
    .parameter "cap"

    .prologue
    invoke-virtual {p1}, Landroid/text/method/TextKeyListener$Capitalize;->ordinal()I

    move-result v1

    mul-int/lit8 v2, v1, 0x2

    if-eqz p0, :cond_1f

    const/4 v1, 0x1

    :goto_9
    add-int v0, v2, v1

    .local v0, off:I
    sget-object v1, Landroid/text/method/MultiTapKeyListener;->sInstance:[Landroid/text/method/MultiTapKeyListener;

    aget-object v1, v1, v0

    if-nez v1, :cond_1a

    sget-object v1, Landroid/text/method/MultiTapKeyListener;->sInstance:[Landroid/text/method/MultiTapKeyListener;

    new-instance v2, Landroid/text/method/MultiTapKeyListener;

    invoke-direct {v2, p1, p0}, Landroid/text/method/MultiTapKeyListener;-><init>(Landroid/text/method/TextKeyListener$Capitalize;Z)V

    aput-object v2, v1, v0

    :cond_1a
    sget-object v1, Landroid/text/method/MultiTapKeyListener;->sInstance:[Landroid/text/method/MultiTapKeyListener;

    aget-object v1, v1, v0

    return-object v1

    .end local v0           #off:I
    :cond_1f
    const/4 v1, 0x0

    goto :goto_9
.end method

.method private static removeTimeouts(Landroid/text/Spannable;)V
    .registers 7
    .parameter "buf"

    .prologue
    const/4 v3, 0x0

    invoke-interface {p0}, Landroid/text/Spannable;->length()I

    move-result v4

    const-class v5, Landroid/text/method/MultiTapKeyListener$Timeout;

    invoke-interface {p0, v3, v4, v5}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Landroid/text/method/MultiTapKeyListener$Timeout;

    .local v2, timeout:[Landroid/text/method/MultiTapKeyListener$Timeout;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_e
    array-length v3, v2

    if-ge v0, v3, :cond_20

    aget-object v1, v2, v0

    .local v1, t:Landroid/text/method/MultiTapKeyListener$Timeout;
    invoke-virtual {v1, v1}, Landroid/text/method/MultiTapKeyListener$Timeout;->removeCallbacks(Ljava/lang/Runnable;)V

    const/4 v3, 0x0

    #setter for: Landroid/text/method/MultiTapKeyListener$Timeout;->mBuffer:Landroid/text/Editable;
    invoke-static {v1, v3}, Landroid/text/method/MultiTapKeyListener$Timeout;->access$002(Landroid/text/method/MultiTapKeyListener$Timeout;Landroid/text/Editable;)Landroid/text/Editable;

    invoke-interface {p0, v1}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_e

    .end local v1           #t:Landroid/text/method/MultiTapKeyListener$Timeout;
    :cond_20
    return-void
.end method


# virtual methods
.method public getInputType()I
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/text/method/MultiTapKeyListener;->mCapitalize:Landroid/text/method/TextKeyListener$Capitalize;

    iget-boolean v1, p0, Landroid/text/method/MultiTapKeyListener;->mAutoText:Z

    invoke-static {v0, v1}, Landroid/text/method/MultiTapKeyListener;->makeTextContentType(Landroid/text/method/TextKeyListener$Capitalize;Z)I

    move-result v0

    return v0
.end method

.method public onKeyDown(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;)Z
    .registers 33
    .parameter "view"
    .parameter "content"
    .parameter "keyCode"
    .parameter "event"

    .prologue
    const/16 v26, 0x0

    .local v26, pref:I
    if-eqz p1, :cond_10

    invoke-static {}, Landroid/text/method/TextKeyListener;->getInstance()Landroid/text/method/TextKeyListener;

    move-result-object v2

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v2, v7}, Landroid/text/method/TextKeyListener;->getPrefs(Landroid/content/Context;)I

    move-result v26

    :cond_10
    invoke-static/range {p2 .. p2}, Landroid/text/Selection;->getSelectionStart(Ljava/lang/CharSequence;)I

    move-result v13

    .local v13, a:I
    invoke-static/range {p2 .. p2}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v17

    .local v17, b:I
    move/from16 v0, v17

    invoke-static {v13, v0}, Ljava/lang/Math;->min(II)I

    move-result v3

    .local v3, selStart:I
    move/from16 v0, v17

    invoke-static {v13, v0}, Ljava/lang/Math;->max(II)I

    move-result v4

    .local v4, selEnd:I
    sget-object v2, Landroid/text/method/TextKeyListener;->ACTIVE:Ljava/lang/Object;

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/text/Editable;->getSpanStart(Ljava/lang/Object;)I

    move-result v15

    .local v15, activeStart:I
    sget-object v2, Landroid/text/method/TextKeyListener;->ACTIVE:Ljava/lang/Object;

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/text/Editable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v14

    .local v14, activeEnd:I
    sget-object v2, Landroid/text/method/TextKeyListener;->ACTIVE:Ljava/lang/Object;

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/text/Editable;->getSpanFlags(Ljava/lang/Object;)I

    move-result v2

    const/high16 v7, -0x100

    and-int/2addr v2, v7

    ushr-int/lit8 v27, v2, 0x18

    .local v27, rec:I
    if-ne v15, v3, :cond_1b3

    if-ne v14, v4, :cond_1b3

    sub-int v2, v4, v3

    const/4 v7, 0x1

    if-ne v2, v7, :cond_1b3

    if-ltz v27, :cond_1b3

    sget-object v2, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    invoke-virtual {v2}, Landroid/util/SparseArray;->size()I

    move-result v2

    move/from16 v0, v27

    if-ge v0, v2, :cond_1b3

    const/16 v2, 0x11

    move/from16 v0, p3

    if-ne v0, v2, :cond_a4

    move-object/from16 v0, p2

    invoke-interface {v0, v3}, Landroid/text/Editable;->charAt(I)C

    move-result v19

    .local v19, current:C
    invoke-static/range {v19 .. v19}, Ljava/lang/Character;->isLowerCase(C)Z

    move-result v2

    if-eqz v2, :cond_83

    invoke-static/range {v19 .. v19}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p2

    invoke-interface {v0, v3, v4, v2}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    invoke-static/range {p2 .. p2}, Landroid/text/method/MultiTapKeyListener;->removeTimeouts(Landroid/text/Spannable;)V

    new-instance v2, Landroid/text/method/MultiTapKeyListener$Timeout;

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v2, v0, v1}, Landroid/text/method/MultiTapKeyListener$Timeout;-><init>(Landroid/text/method/MultiTapKeyListener;Landroid/text/Editable;)V

    const/4 v2, 0x1

    .end local v19           #current:C
    :goto_82
    return v2

    .restart local v19       #current:C
    :cond_83
    invoke-static/range {v19 .. v19}, Ljava/lang/Character;->isUpperCase(C)Z

    move-result v2

    if-eqz v2, :cond_a4

    invoke-static/range {v19 .. v19}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p2

    invoke-interface {v0, v3, v4, v2}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    invoke-static/range {p2 .. p2}, Landroid/text/method/MultiTapKeyListener;->removeTimeouts(Landroid/text/Spannable;)V

    new-instance v2, Landroid/text/method/MultiTapKeyListener$Timeout;

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v2, v0, v1}, Landroid/text/method/MultiTapKeyListener$Timeout;-><init>(Landroid/text/method/MultiTapKeyListener;Landroid/text/Editable;)V

    const/4 v2, 0x1

    goto :goto_82

    .end local v19           #current:C
    :cond_a4
    sget-object v2, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    move/from16 v0, p3

    invoke-virtual {v2, v0}, Landroid/util/SparseArray;->indexOfKey(I)I

    move-result v2

    move/from16 v0, v27

    if-ne v2, v0, :cond_e5

    sget-object v2, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    move/from16 v0, v27

    invoke-virtual {v2, v0}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .local v5, val:Ljava/lang/String;
    move-object/from16 v0, p2

    invoke-interface {v0, v3}, Landroid/text/Editable;->charAt(I)C

    move-result v18

    .local v18, ch:C
    move/from16 v0, v18

    invoke-virtual {v5, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v6

    .local v6, ix:I
    if-ltz v6, :cond_e5

    add-int/lit8 v2, v6, 0x1

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v7

    rem-int v6, v2, v7

    add-int/lit8 v7, v6, 0x1

    move-object/from16 v2, p2

    invoke-interface/range {v2 .. v7}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;II)Landroid/text/Editable;

    invoke-static/range {p2 .. p2}, Landroid/text/method/MultiTapKeyListener;->removeTimeouts(Landroid/text/Spannable;)V

    new-instance v2, Landroid/text/method/MultiTapKeyListener$Timeout;

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v2, v0, v1}, Landroid/text/method/MultiTapKeyListener$Timeout;-><init>(Landroid/text/method/MultiTapKeyListener;Landroid/text/Editable;)V

    const/4 v2, 0x1

    goto :goto_82

    .end local v5           #val:Ljava/lang/String;
    .end local v6           #ix:I
    .end local v18           #ch:C
    :cond_e5
    sget-object v2, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    move/from16 v0, p3

    invoke-virtual {v2, v0}, Landroid/util/SparseArray;->indexOfKey(I)I

    move-result v27

    if-ltz v27, :cond_f5

    move-object/from16 v0, p2

    invoke-static {v0, v4, v4}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;II)V

    move v3, v4

    :cond_f5
    :goto_f5
    if-ltz v27, :cond_1d2

    sget-object v2, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    move/from16 v0, v27

    invoke-virtual {v2, v0}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .restart local v5       #val:Ljava/lang/String;
    const/4 v11, 0x0

    .local v11, off:I
    and-int/lit8 v2, v26, 0x1

    if-eqz v2, :cond_12a

    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/text/method/MultiTapKeyListener;->mCapitalize:Landroid/text/method/TextKeyListener$Capitalize;

    move-object/from16 v0, p2

    invoke-static {v2, v0, v3}, Landroid/text/method/TextKeyListener;->shouldCap(Landroid/text/method/TextKeyListener$Capitalize;Ljava/lang/CharSequence;I)Z

    move-result v2

    if-eqz v2, :cond_12a

    const/16 v20, 0x0

    .local v20, i:I
    :goto_114
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v2

    move/from16 v0, v20

    if-ge v0, v2, :cond_12a

    move/from16 v0, v20

    invoke-virtual {v5, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    invoke-static {v2}, Ljava/lang/Character;->isUpperCase(C)Z

    move-result v2

    if-eqz v2, :cond_1bd

    move/from16 v11, v20

    .end local v20           #i:I
    :cond_12a
    if-eq v3, v4, :cond_131

    move-object/from16 v0, p2

    invoke-static {v0, v4}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;I)V

    :cond_131
    sget-object v2, Landroid/text/method/MultiTapKeyListener;->OLD_SEL_START:Ljava/lang/Object;

    const/16 v7, 0x11

    move-object/from16 v0, p2

    invoke-interface {v0, v2, v3, v3, v7}, Landroid/text/Editable;->setSpan(Ljava/lang/Object;III)V

    add-int/lit8 v12, v11, 0x1

    move-object/from16 v7, p2

    move v8, v3

    move v9, v4

    move-object v10, v5

    invoke-interface/range {v7 .. v12}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;II)Landroid/text/Editable;

    sget-object v2, Landroid/text/method/MultiTapKeyListener;->OLD_SEL_START:Ljava/lang/Object;

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/text/Editable;->getSpanStart(Ljava/lang/Object;)I

    move-result v25

    .local v25, oldStart:I
    invoke-static/range {p2 .. p2}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v4

    move/from16 v0, v25

    if-eq v4, v0, :cond_173

    move-object/from16 v0, p2

    move/from16 v1, v25

    invoke-static {v0, v1, v4}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;II)V

    sget-object v2, Landroid/text/method/TextKeyListener;->LAST_TYPED:Ljava/lang/Object;

    const/16 v7, 0x21

    move-object/from16 v0, p2

    move/from16 v1, v25

    invoke-interface {v0, v2, v1, v4, v7}, Landroid/text/Editable;->setSpan(Ljava/lang/Object;III)V

    sget-object v2, Landroid/text/method/TextKeyListener;->ACTIVE:Ljava/lang/Object;

    shl-int/lit8 v7, v27, 0x18

    or-int/lit8 v7, v7, 0x21

    move-object/from16 v0, p2

    move/from16 v1, v25

    invoke-interface {v0, v2, v1, v4, v7}, Landroid/text/Editable;->setSpan(Ljava/lang/Object;III)V

    :cond_173
    invoke-static/range {p2 .. p2}, Landroid/text/method/MultiTapKeyListener;->removeTimeouts(Landroid/text/Spannable;)V

    new-instance v2, Landroid/text/method/MultiTapKeyListener$Timeout;

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v2, v0, v1}, Landroid/text/method/MultiTapKeyListener$Timeout;-><init>(Landroid/text/method/MultiTapKeyListener;Landroid/text/Editable;)V

    move-object/from16 v0, p2

    move-object/from16 v1, p0

    invoke-interface {v0, v1}, Landroid/text/Editable;->getSpanStart(Ljava/lang/Object;)I

    move-result v2

    if-gez v2, :cond_1cf

    const/4 v2, 0x0

    invoke-interface/range {p2 .. p2}, Landroid/text/Editable;->length()I

    move-result v7

    const-class v8, Landroid/text/method/KeyListener;

    move-object/from16 v0, p2

    invoke-interface {v0, v2, v7, v8}, Landroid/text/Editable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v24

    check-cast v24, [Landroid/text/method/KeyListener;

    .local v24, methods:[Landroid/text/method/KeyListener;
    move-object/from16 v16, v24

    .local v16, arr$:[Landroid/text/method/KeyListener;
    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v22, v0

    .local v22, len$:I
    const/16 v21, 0x0

    .local v21, i$:I
    :goto_1a1
    move/from16 v0, v21

    move/from16 v1, v22

    if-ge v0, v1, :cond_1c1

    aget-object v23, v16, v21

    .local v23, method:Landroid/text/method/KeyListener;
    move-object/from16 v0, p2

    move-object/from16 v1, v23

    invoke-interface {v0, v1}, Landroid/text/Editable;->removeSpan(Ljava/lang/Object;)V

    add-int/lit8 v21, v21, 0x1

    goto :goto_1a1

    .end local v5           #val:Ljava/lang/String;
    .end local v11           #off:I
    .end local v16           #arr$:[Landroid/text/method/KeyListener;
    .end local v21           #i$:I
    .end local v22           #len$:I
    .end local v23           #method:Landroid/text/method/KeyListener;
    .end local v24           #methods:[Landroid/text/method/KeyListener;
    .end local v25           #oldStart:I
    :cond_1b3
    sget-object v2, Landroid/text/method/MultiTapKeyListener;->sRecs:Landroid/util/SparseArray;

    move/from16 v0, p3

    invoke-virtual {v2, v0}, Landroid/util/SparseArray;->indexOfKey(I)I

    move-result v27

    goto/16 :goto_f5

    .restart local v5       #val:Ljava/lang/String;
    .restart local v11       #off:I
    .restart local v20       #i:I
    :cond_1bd
    add-int/lit8 v20, v20, 0x1

    goto/16 :goto_114

    .end local v20           #i:I
    .restart local v16       #arr$:[Landroid/text/method/KeyListener;
    .restart local v21       #i$:I
    .restart local v22       #len$:I
    .restart local v24       #methods:[Landroid/text/method/KeyListener;
    .restart local v25       #oldStart:I
    :cond_1c1
    const/4 v2, 0x0

    invoke-interface/range {p2 .. p2}, Landroid/text/Editable;->length()I

    move-result v7

    const/16 v8, 0x12

    move-object/from16 v0, p2

    move-object/from16 v1, p0

    invoke-interface {v0, v1, v2, v7, v8}, Landroid/text/Editable;->setSpan(Ljava/lang/Object;III)V

    .end local v16           #arr$:[Landroid/text/method/KeyListener;
    .end local v21           #i$:I
    .end local v22           #len$:I
    .end local v24           #methods:[Landroid/text/method/KeyListener;
    :cond_1cf
    const/4 v2, 0x1

    goto/16 :goto_82

    .end local v5           #val:Ljava/lang/String;
    .end local v11           #off:I
    .end local v25           #oldStart:I
    :cond_1d2
    invoke-super/range {p0 .. p4}, Landroid/text/method/BaseKeyListener;->onKeyDown(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;)Z

    move-result v2

    goto/16 :goto_82
.end method

.method public onSpanAdded(Landroid/text/Spannable;Ljava/lang/Object;II)V
    .registers 5
    .parameter "s"
    .parameter "what"
    .parameter "start"
    .parameter "end"

    .prologue
    return-void
.end method

.method public onSpanChanged(Landroid/text/Spannable;Ljava/lang/Object;IIII)V
    .registers 8
    .parameter "buf"
    .parameter "what"
    .parameter "s"
    .parameter "e"
    .parameter "start"
    .parameter "stop"

    .prologue
    sget-object v0, Landroid/text/Selection;->SELECTION_END:Ljava/lang/Object;

    if-ne p2, v0, :cond_c

    sget-object v0, Landroid/text/method/TextKeyListener;->ACTIVE:Ljava/lang/Object;

    invoke-interface {p1, v0}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    invoke-static {p1}, Landroid/text/method/MultiTapKeyListener;->removeTimeouts(Landroid/text/Spannable;)V

    :cond_c
    return-void
.end method

.method public onSpanRemoved(Landroid/text/Spannable;Ljava/lang/Object;II)V
    .registers 5
    .parameter "s"
    .parameter "what"
    .parameter "start"
    .parameter "end"

    .prologue
    return-void
.end method
