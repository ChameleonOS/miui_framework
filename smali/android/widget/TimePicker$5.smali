.class Landroid/widget/TimePicker$5;
.super Ljava/lang/Object;
.source "TimePicker.java"

# interfaces
.implements Landroid/widget/NumberPicker$OnValueChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/TimePicker;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/TimePicker;


# direct methods
.method constructor <init>(Landroid/widget/TimePicker;)V
    .registers 2
    .parameter

    .prologue
    .line 211
    iput-object p1, p0, Landroid/widget/TimePicker$5;->this$0:Landroid/widget/TimePicker;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onValueChange(Landroid/widget/NumberPicker;II)V
    .registers 6
    .parameter "picker"
    .parameter "oldVal"
    .parameter "newVal"

    .prologue
    .line 213
    iget-object v0, p0, Landroid/widget/TimePicker$5;->this$0:Landroid/widget/TimePicker;

    #calls: Landroid/widget/TimePicker;->updateInputState()V
    invoke-static {v0}, Landroid/widget/TimePicker;->access$000(Landroid/widget/TimePicker;)V

    .line 214
    invoke-virtual {p1}, Landroid/widget/NumberPicker;->requestFocus()Z

    .line 215
    iget-object v1, p0, Landroid/widget/TimePicker$5;->this$0:Landroid/widget/TimePicker;

    iget-object v0, p0, Landroid/widget/TimePicker$5;->this$0:Landroid/widget/TimePicker;

    #getter for: Landroid/widget/TimePicker;->mIsAm:Z
    invoke-static {v0}, Landroid/widget/TimePicker;->access$100(Landroid/widget/TimePicker;)Z

    move-result v0

    if-nez v0, :cond_21

    const/4 v0, 0x1

    :goto_13
    #setter for: Landroid/widget/TimePicker;->mIsAm:Z
    invoke-static {v1, v0}, Landroid/widget/TimePicker;->access$102(Landroid/widget/TimePicker;Z)Z

    .line 216
    iget-object v0, p0, Landroid/widget/TimePicker$5;->this$0:Landroid/widget/TimePicker;

    #calls: Landroid/widget/TimePicker;->updateAmPmControl()V
    invoke-static {v0}, Landroid/widget/TimePicker;->access$200(Landroid/widget/TimePicker;)V

    .line 217
    iget-object v0, p0, Landroid/widget/TimePicker$5;->this$0:Landroid/widget/TimePicker;

    invoke-virtual {v0}, Landroid/widget/TimePicker;->onTimeChanged()V

    .line 218
    return-void

    .line 215
    :cond_21
    const/4 v0, 0x0

    goto :goto_13
.end method
