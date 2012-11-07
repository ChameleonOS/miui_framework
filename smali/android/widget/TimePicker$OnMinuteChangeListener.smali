.class Landroid/widget/TimePicker$OnMinuteChangeListener;
.super Ljava/lang/Object;
.source "TimePicker.java"

# interfaces
.implements Landroid/widget/NumberPicker$OnValueChangeListener;


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/TimePicker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "OnMinuteChangeListener"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/TimePicker;


# direct methods
.method constructor <init>(Landroid/widget/TimePicker;)V
    .registers 2
    .parameter

    .prologue
    .line 66
    iput-object p1, p0, Landroid/widget/TimePicker$OnMinuteChangeListener;->this$0:Landroid/widget/TimePicker;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onValueChange(Landroid/widget/NumberPicker;II)V
    .registers 5
    .parameter "picker"
    .parameter "oldVal"
    .parameter "newVal"

    .prologue
    .line 69
    iget-object v0, p0, Landroid/widget/TimePicker$OnMinuteChangeListener;->this$0:Landroid/widget/TimePicker;

    invoke-virtual {v0}, Landroid/widget/TimePicker;->callUpdateInputState()V

    .line 70
    iget-object v0, p0, Landroid/widget/TimePicker$OnMinuteChangeListener;->this$0:Landroid/widget/TimePicker;

    invoke-virtual {v0}, Landroid/widget/TimePicker;->callOnTimeChanged()V

    .line 71
    return-void
.end method
