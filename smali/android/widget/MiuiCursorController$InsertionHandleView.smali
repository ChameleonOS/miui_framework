.class Landroid/widget/MiuiCursorController$InsertionHandleView;
.super Landroid/widget/MiuiCursorController$MiuiHandleView;
.source "MiuiCursorController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/MiuiCursorController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "InsertionHandleView"
.end annotation


# static fields
.field protected static final DELAY_BEFORE_HANDLE_FADES_OUT:I = 0xbb8

.field protected static final DELAY_WHEN_HANDLE_INVISIBLE:I = 0xc8


# instance fields
.field private mHider:Ljava/lang/Runnable;

.field final synthetic this$0:Landroid/widget/MiuiCursorController;


# direct methods
.method public constructor <init>(Landroid/widget/MiuiCursorController;Landroid/widget/Editor;Landroid/graphics/drawable/Drawable;)V
    .registers 4
    .parameter
    .parameter "tv"
    .parameter "drawable"

    .prologue
    .line 1158
    iput-object p1, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->this$0:Landroid/widget/MiuiCursorController;

    .line 1159
    invoke-direct {p0, p1, p2, p3, p3}, Landroid/widget/MiuiCursorController$MiuiHandleView;-><init>(Landroid/widget/MiuiCursorController;Landroid/widget/Editor;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 1160
    return-void
.end method

.method private removeHiderCallback()V
    .registers 3

    .prologue
    .line 1181
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->mHider:Ljava/lang/Runnable;

    if-eqz v0, :cond_b

    .line 1182
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->mHider:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 1184
    :cond_b
    return-void
.end method


# virtual methods
.method public getCurrentCursorOffset()I
    .registers 2

    .prologue
    .line 1217
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getSelectionStart()I

    move-result v0

    return v0
.end method

.method protected getHotspotX(Landroid/graphics/drawable/Drawable;Z)I
    .registers 4
    .parameter "drawable"
    .parameter "isRtlRun"

    .prologue
    .line 1188
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    return v0
.end method

.method protected hideAfterDelay(I)V
    .registers 6
    .parameter "delay"

    .prologue
    .line 1169
    invoke-direct {p0}, Landroid/widget/MiuiCursorController$InsertionHandleView;->removeHiderCallback()V

    .line 1170
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->mHider:Ljava/lang/Runnable;

    if-nez v0, :cond_e

    .line 1171
    new-instance v0, Landroid/widget/MiuiCursorController$InsertionHandleView$1;

    invoke-direct {v0, p0}, Landroid/widget/MiuiCursorController$InsertionHandleView$1;-><init>(Landroid/widget/MiuiCursorController$InsertionHandleView;)V

    iput-object v0, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->mHider:Ljava/lang/Runnable;

    .line 1177
    :cond_e
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->mHider:Ljava/lang/Runnable;

    int-to-long v2, p1

    invoke-virtual {v0, v1, v2, v3}, Landroid/widget/TextView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 1178
    return-void
.end method

.method public onDetached()V
    .registers 1

    .prologue
    .line 1238
    invoke-super {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->onDetached()V

    .line 1239
    invoke-direct {p0}, Landroid/widget/MiuiCursorController$InsertionHandleView;->removeHiderCallback()V

    .line 1240
    return-void
.end method

.method onHandleMoved()V
    .registers 1

    .prologue
    .line 1232
    invoke-super {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->onHandleMoved()V

    .line 1233
    invoke-direct {p0}, Landroid/widget/MiuiCursorController$InsertionHandleView;->removeHiderCallback()V

    .line 1234
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 4
    .parameter "ev"

    .prologue
    .line 1193
    invoke-super {p0, p1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 1195
    .local v0, result:Z
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v1

    packed-switch v1, :pswitch_data_12

    .line 1212
    :goto_b
    :pswitch_b
    return v0

    .line 1205
    :pswitch_c
    const/16 v1, 0xbb8

    invoke-virtual {p0, v1}, Landroid/widget/MiuiCursorController$InsertionHandleView;->hideAfterDelay(I)V

    goto :goto_b

    .line 1195
    :pswitch_data_12
    .packed-switch 0x0
        :pswitch_b
        :pswitch_b
        :pswitch_b
        :pswitch_c
    .end packed-switch
.end method

.method public show()V
    .registers 2

    .prologue
    .line 1164
    invoke-super {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->show()V

    .line 1165
    const/16 v0, 0xbb8

    invoke-virtual {p0, v0}, Landroid/widget/MiuiCursorController$InsertionHandleView;->hideAfterDelay(I)V

    .line 1166
    return-void
.end method

.method public updatePosition(FF)V
    .registers 5
    .parameter "x"
    .parameter "y"

    .prologue
    .line 1227
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0, p1, p2}, Landroid/widget/TextView;->getOffsetForPosition(FF)I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/widget/MiuiCursorController$InsertionHandleView;->positionAtCursorOffset(IZ)V

    .line 1228
    return-void
.end method

.method public updateSelection(I)V
    .registers 3
    .parameter "offset"

    .prologue
    .line 1222
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v0, p1, p1}, Landroid/widget/Editor;->setTextSelectionWrap(II)V

    .line 1223
    return-void
.end method
