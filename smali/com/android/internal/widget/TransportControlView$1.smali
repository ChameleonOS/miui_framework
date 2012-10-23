.class Lcom/android/internal/widget/TransportControlView$1;
.super Landroid/os/Handler;
.source "TransportControlView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/widget/TransportControlView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/widget/TransportControlView;


# direct methods
.method constructor <init>(Lcom/android/internal/widget/TransportControlView;)V
    .registers 2
    .parameter

    .prologue
    .line 91
    iput-object p1, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 4
    .parameter "msg"

    .prologue
    .line 94
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_ac

    .line 130
    :cond_5
    :goto_5
    return-void

    .line 96
    :pswitch_6
    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    #getter for: Lcom/android/internal/widget/TransportControlView;->mClientGeneration:I
    invoke-static {v0}, Lcom/android/internal/widget/TransportControlView;->access$000(Lcom/android/internal/widget/TransportControlView;)I

    move-result v0

    iget v1, p1, Landroid/os/Message;->arg1:I

    if-ne v0, v1, :cond_5

    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    iget v1, p1, Landroid/os/Message;->arg2:I

    #calls: Lcom/android/internal/widget/TransportControlView;->updatePlayPauseState(I)V
    invoke-static {v0, v1}, Lcom/android/internal/widget/TransportControlView;->access$100(Lcom/android/internal/widget/TransportControlView;I)V

    goto :goto_5

    .line 100
    :pswitch_18
    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    #getter for: Lcom/android/internal/widget/TransportControlView;->mClientGeneration:I
    invoke-static {v0}, Lcom/android/internal/widget/TransportControlView;->access$000(Lcom/android/internal/widget/TransportControlView;)I

    move-result v0

    iget v1, p1, Landroid/os/Message;->arg1:I

    if-ne v0, v1, :cond_5

    iget-object v1, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/os/Bundle;

    #calls: Lcom/android/internal/widget/TransportControlView;->updateMetadata(Landroid/os/Bundle;)V
    invoke-static {v1, v0}, Lcom/android/internal/widget/TransportControlView;->access$200(Lcom/android/internal/widget/TransportControlView;Landroid/os/Bundle;)V

    goto :goto_5

    .line 104
    :pswitch_2c
    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    #getter for: Lcom/android/internal/widget/TransportControlView;->mClientGeneration:I
    invoke-static {v0}, Lcom/android/internal/widget/TransportControlView;->access$000(Lcom/android/internal/widget/TransportControlView;)I

    move-result v0

    iget v1, p1, Landroid/os/Message;->arg1:I

    if-ne v0, v1, :cond_5

    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    iget v1, p1, Landroid/os/Message;->arg2:I

    #calls: Lcom/android/internal/widget/TransportControlView;->updateTransportControls(I)V
    invoke-static {v0, v1}, Lcom/android/internal/widget/TransportControlView;->access$300(Lcom/android/internal/widget/TransportControlView;I)V

    goto :goto_5

    .line 108
    :pswitch_3e
    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    #getter for: Lcom/android/internal/widget/TransportControlView;->mClientGeneration:I
    invoke-static {v0}, Lcom/android/internal/widget/TransportControlView;->access$000(Lcom/android/internal/widget/TransportControlView;)I

    move-result v0

    iget v1, p1, Landroid/os/Message;->arg1:I

    if-ne v0, v1, :cond_5

    .line 109
    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    #getter for: Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;
    invoke-static {v0}, Lcom/android/internal/widget/TransportControlView;->access$400(Lcom/android/internal/widget/TransportControlView;)Lcom/android/internal/widget/TransportControlView$Metadata;

    move-result-object v0

    #getter for: Lcom/android/internal/widget/TransportControlView$Metadata;->bitmap:Landroid/graphics/Bitmap;
    invoke-static {v0}, Lcom/android/internal/widget/TransportControlView$Metadata;->access$500(Lcom/android/internal/widget/TransportControlView$Metadata;)Landroid/graphics/Bitmap;

    move-result-object v0

    if-eqz v0, :cond_61

    .line 110
    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    #getter for: Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;
    invoke-static {v0}, Lcom/android/internal/widget/TransportControlView;->access$400(Lcom/android/internal/widget/TransportControlView;)Lcom/android/internal/widget/TransportControlView$Metadata;

    move-result-object v0

    #getter for: Lcom/android/internal/widget/TransportControlView$Metadata;->bitmap:Landroid/graphics/Bitmap;
    invoke-static {v0}, Lcom/android/internal/widget/TransportControlView$Metadata;->access$500(Lcom/android/internal/widget/TransportControlView$Metadata;)Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 112
    :cond_61
    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    #getter for: Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;
    invoke-static {v0}, Lcom/android/internal/widget/TransportControlView;->access$400(Lcom/android/internal/widget/TransportControlView;)Lcom/android/internal/widget/TransportControlView$Metadata;

    move-result-object v1

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/graphics/Bitmap;

    #setter for: Lcom/android/internal/widget/TransportControlView$Metadata;->bitmap:Landroid/graphics/Bitmap;
    invoke-static {v1, v0}, Lcom/android/internal/widget/TransportControlView$Metadata;->access$502(Lcom/android/internal/widget/TransportControlView$Metadata;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    .line 113
    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    #getter for: Lcom/android/internal/widget/TransportControlView;->mAlbumArt:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/android/internal/widget/TransportControlView;->access$600(Lcom/android/internal/widget/TransportControlView;)Landroid/widget/ImageView;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    #getter for: Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;
    invoke-static {v1}, Lcom/android/internal/widget/TransportControlView;->access$400(Lcom/android/internal/widget/TransportControlView;)Lcom/android/internal/widget/TransportControlView$Metadata;

    move-result-object v1

    #getter for: Lcom/android/internal/widget/TransportControlView$Metadata;->bitmap:Landroid/graphics/Bitmap;
    invoke-static {v1}, Lcom/android/internal/widget/TransportControlView$Metadata;->access$500(Lcom/android/internal/widget/TransportControlView$Metadata;)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_5

    .line 118
    :pswitch_82
    iget v0, p1, Landroid/os/Message;->arg2:I

    if-eqz v0, :cond_99

    .line 120
    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    #getter for: Lcom/android/internal/widget/TransportControlView;->mWidgetCallbacks:Lcom/android/internal/widget/LockScreenWidgetCallback;
    invoke-static {v0}, Lcom/android/internal/widget/TransportControlView;->access$700(Lcom/android/internal/widget/TransportControlView;)Lcom/android/internal/widget/LockScreenWidgetCallback;

    move-result-object v0

    if-eqz v0, :cond_99

    .line 121
    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    #getter for: Lcom/android/internal/widget/TransportControlView;->mWidgetCallbacks:Lcom/android/internal/widget/LockScreenWidgetCallback;
    invoke-static {v0}, Lcom/android/internal/widget/TransportControlView;->access$700(Lcom/android/internal/widget/TransportControlView;)Lcom/android/internal/widget/LockScreenWidgetCallback;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    invoke-interface {v0, v1}, Lcom/android/internal/widget/LockScreenWidgetCallback;->requestHide(Landroid/view/View;)V

    .line 125
    :cond_99
    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    iget v1, p1, Landroid/os/Message;->arg1:I

    #setter for: Lcom/android/internal/widget/TransportControlView;->mClientGeneration:I
    invoke-static {v0, v1}, Lcom/android/internal/widget/TransportControlView;->access$002(Lcom/android/internal/widget/TransportControlView;I)I

    .line 126
    iget-object v1, p0, Lcom/android/internal/widget/TransportControlView$1;->this$0:Lcom/android/internal/widget/TransportControlView;

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/app/PendingIntent;

    #setter for: Lcom/android/internal/widget/TransportControlView;->mClientIntent:Landroid/app/PendingIntent;
    invoke-static {v1, v0}, Lcom/android/internal/widget/TransportControlView;->access$802(Lcom/android/internal/widget/TransportControlView;Landroid/app/PendingIntent;)Landroid/app/PendingIntent;

    goto/16 :goto_5

    .line 94
    nop

    :pswitch_data_ac
    .packed-switch 0x64
        :pswitch_6
        :pswitch_18
        :pswitch_2c
        :pswitch_3e
        :pswitch_82
    .end packed-switch
.end method
