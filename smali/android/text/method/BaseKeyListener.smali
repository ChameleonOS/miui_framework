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
    new-instance v0, Landroid/text/NoCopySpan$Concrete;

    invoke-direct {v0}, Landroid/text/NoCopySpan$Concrete;-><init>()V

    sput-object v0, Landroid/text/method/BaseKeyListener;->OLD_SEL_START:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/text/method/MetaKeyKeyListener;-><init>()V

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

    invoke-virtual {p4}, Landroid/view/KeyEvent;->getMetaState()I

    move-result v4

    and-int/lit16 v4, v4, -0xf4

    invoke-static {v4}, Landroid/view/KeyEvent;->metaStateHasNoModifiers(I)Z

    move-result v4

    if-nez v4, :cond_f

    :cond_e
    :goto_e
    return v2

    :cond_f
    invoke-direct {p0, p1, p2}, Landroid/text/method/BaseKeyListener;->deleteSelection(Landroid/view/View;Landroid/text/Editable;)Z

    move-result v4

    if-eqz v4, :cond_17

    move v2, v3

    goto :goto_e

    :cond_17
    invoke-virtual {p4}, Landroid/view/KeyEvent;->isAltPressed()Z

    move-result v4

    if-nez v4, :cond_24

    const/4 v4, 0x2

    invoke-static {p2, v4}, Landroid/text/method/BaseKeyListener;->getMetaState(Ljava/lang/CharSequence;I)I

    move-result v4

    if-ne v4, v3, :cond_2c

    :cond_24
    invoke-direct {p0, p1, p2}, Landroid/text/method/BaseKeyListener;->deleteLine(Landroid/view/View;Landroid/text/Editable;)Z

    move-result v4

    if-eqz v4, :cond_2c

    move v2, v3

    goto :goto_e

    :cond_2c
    invoke-static {p2}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v1

    .local v1, start:I
    if-nez p5, :cond_3e

    invoke-virtual {p4}, Landroid/view/KeyEvent;->isShiftPressed()Z

    move-result v4

    if-nez v4, :cond_3e

    invoke-static {p2, v3}, Landroid/text/method/BaseKeyListener;->getMetaState(Ljava/lang/CharSequence;I)I

    move-result v4

    if-ne v4, v3, :cond_51

    :cond_3e
    invoke-static {p2, v1}, Landroid/text/TextUtils;->getOffsetAfter(Ljava/lang/CharSequence;I)I

    move-result v0

    .local v0, end:I
    :goto_42
    if-eq v1, v0, :cond_e

    invoke-static {v1, v0}, Ljava/lang/Math;->min(II)I

    move-result v2

    invoke-static {v1, v0}, Ljava/lang/Math;->max(II)I

    move-result v4

    invoke-interface {p2, v2, v4}, Landroid/text/Editable;->delete(II)Landroid/text/Editable;

    move v2, v3

    goto :goto_e

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
    instance-of v4, p1, Landroid/widget/TextView;

    if-eqz v4, :cond_23

    check-cast p1, Landroid/widget/TextView;

    .end local p1
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v1

    .local v1, layout:Landroid/text/Layout;
    if-eqz v1, :cond_23

    invoke-static {p2}, Landroid/text/Selection;->getSelectionStart(Ljava/lang/CharSequence;)I

    move-result v4

    invoke-virtual {v1, v4}, Landroid/text/Layout;->getLineForOffset(I)I

    move-result v2

    .local v2, line:I
    invoke-virtual {v1, v2}, Landroid/text/Layout;->getLineStart(I)I

    move-result v3

    .local v3, start:I
    invoke-virtual {v1, v2}, Landroid/text/Layout;->getLineEnd(I)I

    move-result v0

    .local v0, end:I
    if-eq v0, v3, :cond_23

    invoke-interface {p2, v3, v0}, Landroid/text/Editable;->delete(II)Landroid/text/Editable;

    const/4 v4, 0x1

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
    invoke-static {p2}, Landroid/text/Selection;->getSelectionStart(Ljava/lang/CharSequence;)I

    move-result v1

    .local v1, selectionStart:I
    invoke-static {p2}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v0

    .local v0, selectionEnd:I
    if-ge v0, v1, :cond_d

    move v2, v0

    .local v2, temp:I
    move v0, v1

    move v1, v2

    .end local v2           #temp:I
    :cond_d
    if-eq v1, v0, :cond_14

    invoke-interface {p2, v1, v0}, Landroid/text/Editable;->delete(II)Landroid/text/Editable;

    const/4 v3, 0x1

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
    const/4 v0, 0x1

    .local v0, contentType:I
    sget-object v1, Landroid/text/method/BaseKeyListener$1;->$SwitchMap$android$text$method$TextKeyListener$Capitalize:[I

    invoke-virtual {p0}, Landroid/text/method/TextKeyListener$Capitalize;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_1c

    :goto_c
    if-eqz p1, :cond_12

    const v1, 0x8000

    or-int/2addr v0, v1

    :cond_12
    return v0

    :pswitch_13
    or-int/lit16 v0, v0, 0x1000

    goto :goto_c

    :pswitch_16
    or-int/lit16 v0, v0, 0x2000

    goto :goto_c

    :pswitch_19
    or-int/lit16 v0, v0, 0x4000

    goto :goto_c

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
    sparse-switch p3, :sswitch_data_18

    const/4 v0, 0x0

    .local v0, handled:Z
    :goto_4
    if-eqz v0, :cond_9

    invoke-static {p2}, Landroid/text/method/BaseKeyListener;->adjustMetaAfterKeypress(Landroid/text/Spannable;)V

    :cond_9
    invoke-super {p0, p1, p2, p3, p4}, Landroid/text/method/MetaKeyKeyListener;->onKeyDown(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;)Z

    move-result v1

    return v1

    .end local v0           #handled:Z
    :sswitch_e
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/text/method/BaseKeyListener;->backspace(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;)Z

    move-result v0

    .restart local v0       #handled:Z
    goto :goto_4

    .end local v0           #handled:Z
    :sswitch_13
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/text/method/BaseKeyListener;->forwardDelete(Landroid/view/View;Landroid/text/Editable;ILandroid/view/KeyEvent;)Z

    move-result v0

    .restart local v0       #handled:Z
    goto :goto_4

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

    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v5

    const/4 v6, 0x2

    if-ne v5, v6, :cond_e

    invoke-virtual {p3}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v5

    if-eqz v5, :cond_f

    :cond_e
    :goto_e
    return v4

    :cond_f
    invoke-static {p2}, Landroid/text/Selection;->getSelectionStart(Ljava/lang/CharSequence;)I

    move-result v1

    .local v1, selectionStart:I
    invoke-static {p2}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v0

    .local v0, selectionEnd:I
    if-ge v0, v1, :cond_1c

    move v2, v0

    .local v2, temp:I
    move v0, v1

    move v1, v2

    .end local v2           #temp:I
    :cond_1c
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getCharacters()Ljava/lang/String;

    move-result-object v3

    .local v3, text:Ljava/lang/CharSequence;
    if-eqz v3, :cond_e

    invoke-interface {p2, v1, v0, v3}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    const/4 v4, 0x1

    goto :goto_e
.end method
