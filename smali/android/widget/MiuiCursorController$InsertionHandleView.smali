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
.field private static final DELAY_BEFORE_HANDLE_FADES_OUT:I = 0xbb8

.field private static final DELAY_WHEN_HANDLE_INVISIBLE:I = 0xc8


# instance fields
.field mDelayed:Z

.field private mHider:Ljava/lang/Runnable;

.field final synthetic this$0:Landroid/widget/MiuiCursorController;


# direct methods
.method public constructor <init>(Landroid/widget/MiuiCursorController;Landroid/widget/Editor;Landroid/graphics/drawable/Drawable;)V
    .registers 4
    .parameter
    .parameter "tv"
    .parameter "drawable"

    .prologue
    .line 1092
    iput-object p1, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->this$0:Landroid/widget/MiuiCursorController;

    .line 1093
    invoke-direct {p0, p1, p2, p3, p3}, Landroid/widget/MiuiCursorController$MiuiHandleView;-><init>(Landroid/widget/MiuiCursorController;Landroid/widget/Editor;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 1094
    return-void
.end method

.method private hideAfterDelay(I)V
    .registers 6
    .parameter "delay"

    .prologue
    .line 1118
    invoke-direct {p0}, Landroid/widget/MiuiCursorController$InsertionHandleView;->removeHiderCallback()V

    .line 1119
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->mHider:Ljava/lang/Runnable;

    if-nez v0, :cond_e

    .line 1120
    new-instance v0, Landroid/widget/MiuiCursorController$InsertionHandleView$1;

    invoke-direct {v0, p0}, Landroid/widget/MiuiCursorController$InsertionHandleView$1;-><init>(Landroid/widget/MiuiCursorController$InsertionHandleView;)V

    iput-object v0, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->mHider:Ljava/lang/Runnable;

    .line 1126
    :cond_e
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->mDelayed:Z

    .line 1127
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->mHider:Ljava/lang/Runnable;

    int-to-long v2, p1

    invoke-virtual {v0, v1, v2, v3}, Landroid/widget/TextView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 1128
    return-void
.end method

.method private removeHiderCallback()V
    .registers 3

    .prologue
    .line 1143
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->mHider:Ljava/lang/Runnable;

    if-eqz v0, :cond_b

    .line 1144
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->mHider:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 1146
    :cond_b
    return-void
.end method


# virtual methods
.method public getCurrentCursorOffset()I
    .registers 2

    .prologue
    .line 1179
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
    .line 1150
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    return v0
.end method

.method public hide()V
    .registers 4

    .prologue
    .line 1131
    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mVisible:Z

    if-nez v0, :cond_8

    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->mDelayed:Z

    if-eqz v0, :cond_32

    .line 1132
    :cond_8
    const-string v0, "MiuiHandleView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Hide the HandleView and remove from PositionListener, mVisible="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mVisible:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " mDelayed="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->mDelayed:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1133
    invoke-super {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->hide()V

    .line 1140
    :goto_31
    return-void

    .line 1137
    :cond_32
    const-string v0, "MiuiHandleView"

    const-string v1, "To hide the HandleView when invisible, just delay"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1138
    const/16 v0, 0xc8

    invoke-direct {p0, v0}, Landroid/widget/MiuiCursorController$InsertionHandleView;->hideAfterDelay(I)V

    goto :goto_31
.end method

.method public onDetached()V
    .registers 1

    .prologue
    .line 1200
    invoke-super {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->onDetached()V

    .line 1201
    invoke-direct {p0}, Landroid/widget/MiuiCursorController$InsertionHandleView;->removeHiderCallback()V

    .line 1202
    return-void
.end method

.method onHandleMoved()V
    .registers 1

    .prologue
    .line 1194
    invoke-super {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->onHandleMoved()V

    .line 1195
    invoke-direct {p0}, Landroid/widget/MiuiCursorController$InsertionHandleView;->removeHiderCallback()V

    .line 1196
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 4
    .parameter "ev"

    .prologue
    .line 1155
    invoke-super {p0, p1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 1157
    .local v0, result:Z
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v1

    packed-switch v1, :pswitch_data_12

    .line 1174
    :goto_b
    :pswitch_b
    return v0

    .line 1167
    :pswitch_c
    const/16 v1, 0xbb8

    invoke-direct {p0, v1}, Landroid/widget/MiuiCursorController$InsertionHandleView;->hideAfterDelay(I)V

    goto :goto_b

    .line 1157
    :pswitch_data_12
    .packed-switch 0x0
        :pswitch_b
        :pswitch_b
        :pswitch_b
        :pswitch_c
    .end packed-switch
.end method

.method public show()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 1098
    invoke-super {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->show()V

    .line 1104
    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mVisible:Z

    if-eqz v0, :cond_1f

    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->hasMagnifierController()Z

    move-result v0

    if-eqz v0, :cond_1f

    .line 1105
    iput-boolean v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mVisible:Z

    .line 1106
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->mDelayed:Z

    .line 1112
    :goto_15
    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mVisible:Z

    if-eqz v0, :cond_1e

    .line 1113
    const/16 v0, 0xbb8

    invoke-direct {p0, v0}, Landroid/widget/MiuiCursorController$InsertionHandleView;->hideAfterDelay(I)V

    .line 1115
    :cond_1e
    return-void

    .line 1109
    :cond_1f
    iput-boolean v1, p0, Landroid/widget/MiuiCursorController$InsertionHandleView;->mDelayed:Z

    goto :goto_15
.end method

.method public updatePosition(FF)V
    .registers 5
    .parameter "x"
    .parameter "y"

    .prologue
    .line 1189
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0, p1, p2}, Landroid/widget/TextView;->getOffsetForPosition(FF)I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/widget/MiuiCursorController$InsertionHandleView;->positionAtCursorOffset(IZ)V

    .line 1190
    return-void
.end method

.method public updateSelection(I)V
    .registers 3
    .parameter "offset"

    .prologue
    .line 1184
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v0, p1, p1}, Landroid/widget/Editor;->setTextSelectionWrap(II)V

    .line 1185
    return-void
.end method
