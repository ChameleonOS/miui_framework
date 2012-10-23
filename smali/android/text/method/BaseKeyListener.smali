.class public abstract Landroid/text/method/BaseKeyListener;
.super Landroid/text/method/MetaKeyKeyListener;
.source "BaseKeyListener.java"

# interfaces
.implements Landroid/text/method/KeyListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/text/method/BaseKeyListener$1;
    }
.end annotation


# static fields
.field static final OLD_SEL_START:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 38
    new-instance v0, Landroid/text/NoCopySpan$Concrete;

    invoke-direct {v0}, Landroid/text/NoCopySpan$Concrete;-><init>()V

    sput-object v0, Landroid/text/method/BaseKeyListener;->OLD_SEL_START:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 36
    invoke-direct {p0}, Landroid/text/method/MetaKeyKeyListener;-><init>()V

    .line 142
    return-void
.end method

.method private backspaceOrForwardDelete(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;Z)Z
    .registers 11
    .parameter "view"
    .parameter "content"
    .parameter "keyCode"
    .parameter "event"
    .parameter "isForwardDelete"

    .prologue
    const/4 v2, 0x0

    const/4 v3, 0x1

    .line 67
    invoke-virtual {p4}, Landroid/view/KeyEvent;->getMetaState()I

    move-result v4

    and-int/lit16 v4, v4, -0xf4

    invoke-static {v4}, Landroid/view/KeyEvent;->metaStateHasNoModifiers(I)Z

    move-result v4

    if-nez v4, :cond_f

    .line 97
    :cond_e
    :goto_e
    return v2

    .line 73
    :cond_f
    invoke-direct {p0, p1, p2}, Landroid/text/method/BaseKeyListener;->deleteSelection(Landroid/view/View;Landroid/text/Editable;)Z

    move-result v4

    if-eqz v4, :cond_17

    move v2, v3

    .line 74
    goto :goto_e

    .line 78
    :cond_17
    invoke-virtual {p4}, Landroid/view/KeyEvent;->isAltPressed()Z

    move-result v4

    if-nez v4, :cond_24

    const/4 v4, 0x2

    invoke-static {p2, v4}, Landroid/text/method/BaseKeyListener;->getMetaState(Ljava/lang/CharSequence;I)I

    move-result v4

    if-ne v4, v3, :cond_2c

    .line 79
    :cond_24
    invoke-direct {p0, p1, p2}, Landroid/text/method/BaseKeyListener;->deleteLine(Landroid/view/View;Landroid/text/Editable;)Z

    move-result v4

    if-eqz v4, :cond_2c

    move v2, v3

    .line 80
    goto :goto_e

    .line 85
    :cond_2c
    invoke-static {p2}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v1

    .line 87
    .local v1, start:I
    if-nez p5, :cond_3e

    invoke-virtual {p4}, Landroid/view/KeyEvent;->isShiftPressed()Z

    move-result v4

    if-nez v4, :cond_3e

    invoke-static {p2, v3}, Landroid/text/method/BaseKeyListener;->getMetaState(Ljava/lang/CharSequence;I)I

    move-result v4

    if-ne v4, v3, :cond_51

    .line 89
    :cond_3e
    invoke-static {p2, v1}, Landroid/text/TextUtils;->getOffsetAfter(Ljava/lang/CharSequence;I)I

    move-result v0

    .line 93
    .local v0, end:I
    :goto_42
    if-eq v1, v0, :cond_e

    .line 94
    invoke-static {v1, v0}, Ljava/lang/Math;->min(II)I

    move-result v2

    invoke-static {v1, v0}, Ljava/lang/Math;->max(II)I

    move-result v4

    invoke-interface {p2, v2, v4}, Landroid/text/Editable;->delete(II)Landroid/text/Editable;

    move v2, v3

    .line 95
    goto :goto_e

    .line 91
    .end local v0           #end:I
    :cond_51
    invoke-static {p2, v1}, Landroid/text/TextUtils;->getOffsetBefore(Ljava/lang/CharSequence;I)I

    move-result v0

    .restart local v0       #end:I
    goto :goto_42
.end method

.method private deleteLine(Landroid/view/View;Landroid/text/Editable;)Z
    .registers 8
    .parameter "view"
    .parameter "content"

    .prologue
    .line 116
    instance-of v4, p1, Landroid/widget/TextView;

    if-eqz v4, :cond_23

    .line 117
    check-cast p1, Landroid/widget/TextView;

    .end local p1
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v1

    .line 118
    .local v1, layout:Landroid/text/Layout;
    if-eqz v1, :cond_23

    .line 119
    invoke-static {p2}, Landroid/text/Selection;->getSelectionStart(Ljava/lang/CharSequence;)I

    move-result v4

    invoke-virtual {v1, v4}, Landroid/text/Layout;->getLineForOffset(I)I

    move-result v2

    .line 120
    .local v2, line:I
    invoke-virtual {v1, v2}, Landroid/text/Layout;->getLineStart(I)I

    move-result v3

    .line 121
    .local v3, start:I
    invoke-virtual {v1, v2}, Landroid/text/Layout;->getLineEnd(I)I

    move-result v0

    .line 122
    .local v0, end:I
    if-eq v0, v3, :cond_23

    .line 123
    invoke-interface {p2, v3, v0}, Landroid/text/Editable;->delete(II)Landroid/text/Editable;

    .line 124
    const/4 v4, 0x1

    .line 128
    .end local v0           #end:I
    .end local v1           #layout:Landroid/text/Layout;
    .end local v2           #line:I
    .end local v3           #start:I
    :goto_22
    return v4

    :cond_23
    const/4 v4, 0x0

    goto :goto_22
.end method

.method private deleteSelection(Landroid/view/View;Landroid/text/Editable;)Z
    .registers 7
    .parameter "view"
    .parameter "content"

    .prologue
    .line 101
    invoke-static {p2}, Landroid/text/Selection;->getSelectionStart(Ljava/lang/CharSequence;)I

    move-result v1

    .line 102
    .local v1, selectionStart:I
    invoke-static {p2}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v0

    .line 103
    .local v0, selectionEnd:I
    if-ge v0, v1, :cond_d

    .line 104
    move v2, v0

    .line 105
    .local v2, temp:I
    move v0, v1

    .line 106
    move v1, v2

    .line 108
    .end local v2           #temp:I
    :cond_d
    if-eq v1, v0, :cond_14

    .line 109
    invoke-interface {p2, v1, v0}, Landroid/text/Editable;->delete(II)Landroid/text/Editable;

    .line 110
    const/4 v3, 0x1

    .line 112
    :goto_13
    return v3

    :cond_14
    const/4 v3, 0x0

    goto :goto_13
.end method

.method static makeTextContentType(Landroid/text/method/TextKeyListener$Capitalize;Z)I
    .registers 5
    .parameter "caps"
    .parameter "autoText"

    .prologue
    .line 132
    const/4 v0, 0x1

    .line 133
    .local v0, contentType:I
    sget-object v1, Landroid/text/method/BaseKeyListener$1;->$SwitchMap$android$text$method$TextKeyListener$Capitalize:[I

    invoke-virtual {p0}, Landroid/text/method/TextKeyListener$Capitalize;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_1c

    .line 144
    :goto_c
    if-eqz p1, :cond_12

    .line 145
    const v1, 0x8000

    or-int/2addr v0, v1

    .line 147
    :cond_12
    return v0

    .line 135
    :pswitch_13
    or-int/lit16 v0, v0, 0x1000

    .line 136
    goto :goto_c

    .line 138
    :pswitch_16
    or-int/lit16 v0, v0, 0x2000

    .line 139
    goto :goto_c

    .line 141
    :pswitch_19
    or-int/lit16 v0, v0, 0x4000

    goto :goto_c

    .line 133
    :pswitch_data_1c
    .packed-switch 0x1
        :pswitch_13
        :pswitch_16
        :pswitch_19
    .end packed-switch
.end method


# virtual methods
.method public backspace(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;)Z
    .registers 11
    .parameter "view"
    .parameter "content"
    .parameter "keyCode"
    .parameter "event"

    .prologue
    .line 49
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v5}, Landroid/text/method/BaseKeyListener;->backspaceOrForwardDelete(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;Z)Z

    move-result v0

    return v0
.end method

.method public forwardDelete(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;)Z
    .registers 11
    .parameter "view"
    .parameter "content"
    .parameter "keyCode"
    .parameter "event"

    .prologue
    .line 61
    const/4 v5, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v5}, Landroid/text/method/BaseKeyListener;->backspaceOrForwardDelete(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;Z)Z

    move-result v0

    return v0
.end method

.method public onKeyDown(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;)Z
    .registers 7
    .parameter "view"
    .parameter "content"
    .parameter "keyCode"
    .parameter "event"

    .prologue
    .line 153
    sparse-switch p3, :sswitch_data_18

    .line 161
    const/4 v0, 0x0

    .line 165
    .local v0, handled:Z
    :goto_4
    if-eqz v0, :cond_9

    .line 166
    invoke-static {p2}, Landroid/text/method/BaseKeyListener;->adjustMetaAfterKeypress(Landroid/text/Spannable;)V

    .line 169
    :cond_9
    invoke-super {p0, p1, p2, p3, p4}, Landroid/text/method/MetaKeyKeyListener;->onKeyDown(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;)Z

    move-result v1

    return v1

    .line 155
    .end local v0           #handled:Z
    :sswitch_e
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/text/method/BaseKeyListener;->backspace(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;)Z

    move-result v0

    .line 156
    .restart local v0       #handled:Z
    goto :goto_4

    .line 158
    .end local v0           #handled:Z
    :sswitch_13
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/text/method/BaseKeyListener;->forwardDelete(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;)Z

    move-result v0

    .line 159
    .restart local v0       #handled:Z
    goto :goto_4

    .line 153
    :sswitch_data_18
    .sparse-switch
        0x43 -> :sswitch_e
        0x70 -> :sswitch_13
    .end sparse-switch
.end method

.method public onKeyOther(Landroid/view/View;Landroid/text/Editable;Landroid/view/KeyEvent;)Z
    .registers 11
    .parameter "view"
    .parameter "content"
    .parameter "event"

    .prologue
    const/4 v4, 0x0

    .line 177
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v5

    const/4 v6, 0x2

    if-ne v5, v6, :cond_e

    invoke-virtual {p3}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v5

    if-eqz v5, :cond_f

    .line 197
    :cond_e
    :goto_e
    return v4

    .line 183
    :cond_f
    invoke-static {p2}, Landroid/text/Selection;->getSelectionStart(Ljava/lang/CharSequence;)I

    move-result v1

    .line 184
    .local v1, selectionStart:I
    invoke-static {p2}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v0

    .line 185
    .local v0, selectionEnd:I
    if-ge v0, v1, :cond_1c

    .line 186
    move v2, v0

    .line 187
    .local v2, temp:I
    move v0, v1

    .line 188
    move v1, v2

    .line 191
    .end local v2           #temp:I
    :cond_1c
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getCharacters()Ljava/lang/String;

    move-result-object v3

    .line 192
    .local v3, text:Ljava/lang/CharSequence;
    if-eqz v3, :cond_e

    .line 196
    invoke-interface {p2, v1, v0, v3}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 197
    const/4 v4, 0x1

    goto :goto_e
.end method
