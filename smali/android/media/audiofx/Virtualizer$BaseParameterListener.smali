.class Landroid/media/audiofx/Virtualizer$BaseParameterListener;
.super Ljava/lang/Object;
.source "Virtualizer.java"

# interfaces
.implements Landroid/media/audiofx/AudioEffect$OnParameterChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/audiofx/Virtualizer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "BaseParameterListener"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/media/audiofx/Virtualizer;


# direct methods
.method private constructor <init>(Landroid/media/audiofx/Virtualizer;)V
    .registers 2
    .parameter

    .prologue
    .line 176
    iput-object p1, p0, Landroid/media/audiofx/Virtualizer$BaseParameterListener;->this$0:Landroid/media/audiofx/Virtualizer;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 178
    return-void
.end method

.method synthetic constructor <init>(Landroid/media/audiofx/Virtualizer;Landroid/media/audiofx/Virtualizer$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 175
    invoke-direct {p0, p1}, Landroid/media/audiofx/Virtualizer$BaseParameterListener;-><init>(Landroid/media/audiofx/Virtualizer;)V

    return-void
.end method


# virtual methods
.method public onParameterChange(Landroid/media/audiofx/AudioEffect;I[B[B)V
    .registers 12
    .parameter "effect"
    .parameter "status"
    .parameter "param"
    .parameter "value"

    .prologue
    const/4 v6, 0x0

    const/4 v5, -0x1

    .line 180
    const/4 v0, 0x0

    .line 182
    .local v0, l:Landroid/media/audiofx/Virtualizer$OnParameterChangeListener;
    iget-object v3, p0, Landroid/media/audiofx/Virtualizer$BaseParameterListener;->this$0:Landroid/media/audiofx/Virtualizer;

    #getter for: Landroid/media/audiofx/Virtualizer;->mParamListenerLock:Ljava/lang/Object;
    invoke-static {v3}, Landroid/media/audiofx/Virtualizer;->access$000(Landroid/media/audiofx/Virtualizer;)Ljava/lang/Object;

    move-result-object v4

    monitor-enter v4

    .line 183
    :try_start_a
    iget-object v3, p0, Landroid/media/audiofx/Virtualizer$BaseParameterListener;->this$0:Landroid/media/audiofx/Virtualizer;

    #getter for: Landroid/media/audiofx/Virtualizer;->mParamListener:Landroid/media/audiofx/Virtualizer$OnParameterChangeListener;
    invoke-static {v3}, Landroid/media/audiofx/Virtualizer;->access$100(Landroid/media/audiofx/Virtualizer;)Landroid/media/audiofx/Virtualizer$OnParameterChangeListener;

    move-result-object v3

    if-eqz v3, :cond_18

    .line 184
    iget-object v3, p0, Landroid/media/audiofx/Virtualizer$BaseParameterListener;->this$0:Landroid/media/audiofx/Virtualizer;

    #getter for: Landroid/media/audiofx/Virtualizer;->mParamListener:Landroid/media/audiofx/Virtualizer$OnParameterChangeListener;
    invoke-static {v3}, Landroid/media/audiofx/Virtualizer;->access$100(Landroid/media/audiofx/Virtualizer;)Landroid/media/audiofx/Virtualizer$OnParameterChangeListener;

    move-result-object v0

    .line 186
    :cond_18
    monitor-exit v4
    :try_end_19
    .catchall {:try_start_a .. :try_end_19} :catchall_3b

    .line 187
    if-eqz v0, :cond_3a

    .line 188
    const/4 v1, -0x1

    .line 189
    .local v1, p:I
    const/4 v2, -0x1

    .line 191
    .local v2, v:S
    array-length v3, p3

    const/4 v4, 0x4

    if-ne v3, v4, :cond_27

    .line 192
    iget-object v3, p0, Landroid/media/audiofx/Virtualizer$BaseParameterListener;->this$0:Landroid/media/audiofx/Virtualizer;

    invoke-virtual {v3, p3, v6}, Landroid/media/audiofx/Virtualizer;->byteArrayToInt([BI)I

    move-result v1

    .line 194
    :cond_27
    array-length v3, p4

    const/4 v4, 0x2

    if-ne v3, v4, :cond_31

    .line 195
    iget-object v3, p0, Landroid/media/audiofx/Virtualizer$BaseParameterListener;->this$0:Landroid/media/audiofx/Virtualizer;

    invoke-virtual {v3, p4, v6}, Landroid/media/audiofx/Virtualizer;->byteArrayToShort([BI)S

    move-result v2

    .line 197
    :cond_31
    if-eq v1, v5, :cond_3a

    if-eq v2, v5, :cond_3a

    .line 198
    iget-object v3, p0, Landroid/media/audiofx/Virtualizer$BaseParameterListener;->this$0:Landroid/media/audiofx/Virtualizer;

    invoke-interface {v0, v3, p2, v1, v2}, Landroid/media/audiofx/Virtualizer$OnParameterChangeListener;->onParameterChange(Landroid/media/audiofx/Virtualizer;IIS)V

    .line 201
    .end local v1           #p:I
    .end local v2           #v:S
    :cond_3a
    return-void

    .line 186
    :catchall_3b
    move-exception v3

    :try_start_3c
    monitor-exit v4
    :try_end_3d
    .catchall {:try_start_3c .. :try_end_3d} :catchall_3b

    throw v3
.end method
