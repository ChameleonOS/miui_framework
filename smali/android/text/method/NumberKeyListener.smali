.class public abstract Landroid/text/method/NumberKeyListener;
.super Landroid/text/method/BaseKeyListener;
.source "NumberKeyListener.java"

# interfaces
.implements Landroid/text/InputFilter;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 35
    invoke-direct {p0}, Landroid/text/method/BaseKeyListener;-><init>()V

    return-void
.end method

.method protected static ok([CC)Z
    .registers 4
    .parameter "accept"
    .parameter "c"

    .prologue
    .line 86
    array-length v1, p0

    add-int/lit8 v0, v1, -0x1

    .local v0, i:I
    :goto_3
    if-ltz v0, :cond_e

    .line 87
    aget-char v1, p0, v0

    if-ne v1, p1, :cond_b

    .line 88
    const/4 v1, 0x1

    .line 92
    :goto_a
    return v1

    .line 86
    :cond_b
    add-int/lit8 v0, v0, -0x1

    goto :goto_3

    .line 92
    :cond_e
    const/4 v1, 0x0

    goto :goto_a
.end method


# virtual methods
.method public filter(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;
    .registers 15
    .parameter "source"
    .parameter "start"
    .parameter "end"
    .parameter "dest"
    .parameter "dstart"
    .parameter "dend"

    .prologue
    .line 49
    invoke-virtual {p0}, Landroid/text/method/NumberKeyListener;->getAcceptedChars()[C

    move-result-object v0

    .line 50
    .local v0, accept:[C
    const/4 v1, 0x0

    .line 53
    .local v1, filter:Z
    move v3, p2

    .local v3, i:I
    :goto_6
    if-ge v3, p3, :cond_12

    .line 54
    invoke-interface {p1, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v6

    invoke-static {v0, v6}, Landroid/text/method/NumberKeyListener;->ok([CC)Z

    move-result v6

    if-nez v6, :cond_16

    .line 59
    :cond_12
    if-ne v3, p3, :cond_19

    .line 61
    const/4 v2, 0x0

    .line 82
    :cond_15
    :goto_15
    return-object v2

    .line 53
    :cond_16
    add-int/lit8 v3, v3, 0x1

    goto :goto_6

    .line 64
    :cond_19
    sub-int v6, p3, p2

    const/4 v7, 0x1

    if-ne v6, v7, :cond_21

    .line 66
    const-string v2, ""

    goto :goto_15

    .line 69
    :cond_21
    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2, p1, p2, p3}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;II)V

    .line 71
    .local v2, filtered:Landroid/text/SpannableStringBuilder;
    sub-int/2addr v3, p2

    .line 72
    sub-int/2addr p3, p2

    .line 74
    sub-int v5, p3, p2

    .line 76
    .local v5, len:I
    add-int/lit8 v4, p3, -0x1

    .local v4, j:I
    :goto_2c
    if-lt v4, v3, :cond_15

    .line 77
    invoke-interface {p1, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v6

    invoke-static {v0, v6}, Landroid/text/method/NumberKeyListener;->ok([CC)Z

    move-result v6

    if-nez v6, :cond_3d

    .line 78
    add-int/lit8 v6, v4, 0x1

    invoke-virtual {v2, v4, v6}, Landroid/text/SpannableStringBuilder;->delete(II)Landroid/text/SpannableStringBuilder;

    .line 76
    :cond_3d
    add-int/lit8 v4, v4, -0x1

    goto :goto_2c
.end method

.method protected abstract getAcceptedChars()[C
.end method

.method protected lookup(Landroid/view/KeyEvent;Landroid/text/Spannable;)I
    .registers 6
    .parameter "event"
    .parameter "content"

    .prologue
    .line 44
    invoke-virtual {p0}, Landroid/text/method/NumberKeyListener;->getAcceptedChars()[C

    move-result-object v0

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getMetaState()I

    move-result v1

    invoke-static {p2}, Landroid/text/method/NumberKeyListener;->getMetaState(Ljava/lang/CharSequence;)I

    move-result v2

    or-int/2addr v1, v2

    invoke-virtual {p1, v0, v1}, Landroid/view/KeyEvent;->getMatch([CI)C

    move-result v0

    return v0
.end method

.method public onKeyDown(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;)Z
    .registers 14
    .parameter "view"
    .parameter "content"
    .parameter "keyCode"
    .parameter "event"

    .prologue
    const/16 v8, 0x30

    const/4 v6, 0x1

    const/4 v3, 0x0

    .line 101
    invoke-static {p2}, Landroid/text/Selection;->getSelectionStart(Ljava/lang/CharSequence;)I

    move-result v0

    .line 102
    .local v0, a:I
    invoke-static {p2}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v1

    .line 104
    .local v1, b:I
    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v5

    .line 105
    .local v5, selStart:I
    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v4

    .line 108
    .local v4, selEnd:I
    if-ltz v5, :cond_18

    if-gez v4, :cond_1d

    .line 109
    :cond_18
    const/4 v4, 0x0

    move v5, v4

    .line 110
    invoke-static {p2, v3}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;I)V

    .line 113
    :cond_1d
    if-eqz p4, :cond_3e

    invoke-virtual {p0, p4, p2}, Landroid/text/method/NumberKeyListener;->lookup(Landroid/view/KeyEvent;Landroid/text/Spannable;)I

    move-result v2

    .line 114
    .local v2, i:I
    :goto_23
    if-eqz p4, :cond_29

    invoke-virtual {p4}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v3

    .line 115
    .local v3, repeatCount:I
    :cond_29
    if-nez v3, :cond_40

    .line 116
    if-eqz v2, :cond_5f

    .line 117
    if-eq v5, v4, :cond_32

    .line 118
    invoke-static {p2, v4}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;I)V

    .line 121
    :cond_32
    int-to-char v7, v2

    invoke-static {v7}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v7

    invoke-interface {p2, v5, v4, v7}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 123
    invoke-static {p2}, Landroid/text/method/NumberKeyListener;->adjustMetaAfterKeypress(Landroid/text/Spannable;)V

    .line 138
    :goto_3d
    return v6

    .end local v2           #i:I
    .end local v3           #repeatCount:I
    :cond_3e
    move v2, v3

    .line 113
    goto :goto_23

    .line 126
    .restart local v2       #i:I
    .restart local v3       #repeatCount:I
    :cond_40
    if-ne v2, v8, :cond_5f

    if-ne v3, v6, :cond_5f

    .line 129
    if-ne v5, v4, :cond_5f

    if-lez v4, :cond_5f

    add-int/lit8 v7, v5, -0x1

    invoke-interface {p2, v7}, Landroid/text/Editable;->charAt(I)C

    move-result v7

    if-ne v7, v8, :cond_5f

    .line 131
    add-int/lit8 v7, v5, -0x1

    const/16 v8, 0x2b

    invoke-static {v8}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v8

    invoke-interface {p2, v7, v4, v8}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 132
    invoke-static {p2}, Landroid/text/method/NumberKeyListener;->adjustMetaAfterKeypress(Landroid/text/Spannable;)V

    goto :goto_3d

    .line 137
    :cond_5f
    invoke-static {p2}, Landroid/text/method/NumberKeyListener;->adjustMetaAfterKeypress(Landroid/text/Spannable;)V

    .line 138
    invoke-super {p0, p1, p2, p3, p4}, Landroid/text/method/BaseKeyListener;->onKeyDown(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;)Z

    move-result v6

    goto :goto_3d
.end method
