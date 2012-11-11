.class public Landroid/media/audiofx/Virtualizer;
.super Landroid/media/audiofx/AudioEffect;
.source "Virtualizer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/media/audiofx/Virtualizer$1;,
        Landroid/media/audiofx/Virtualizer$Settings;,
        Landroid/media/audiofx/Virtualizer$BaseParameterListener;,
        Landroid/media/audiofx/Virtualizer$OnParameterChangeListener;
    }
.end annotation


# static fields
.field public static final PARAM_STRENGTH:I = 0x1

.field public static final PARAM_STRENGTH_SUPPORTED:I = 0x0

.field private static final TAG:Ljava/lang/String; = "Virtualizer"


# instance fields
.field private mBaseParamListener:Landroid/media/audiofx/Virtualizer$BaseParameterListener;

.field private mParamListener:Landroid/media/audiofx/Virtualizer$OnParameterChangeListener;

.field private final mParamListenerLock:Ljava/lang/Object;

.field private mStrengthSupported:Z


# direct methods
.method public constructor <init>(II)V
    .registers 9
    .parameter "priority"
    .parameter "audioSession"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/UnsupportedOperationException;,
            Ljava/lang/RuntimeException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    sget-object v3, Landroid/media/audiofx/Virtualizer;->EFFECT_TYPE_VIRTUALIZER:Ljava/util/UUID;

    sget-object v4, Landroid/media/audiofx/Virtualizer;->EFFECT_TYPE_NULL:Ljava/util/UUID;

    invoke-direct {p0, v3, v4, p1, p2}, Landroid/media/audiofx/AudioEffect;-><init>(Ljava/util/UUID;Ljava/util/UUID;II)V

    iput-boolean v2, p0, Landroid/media/audiofx/Virtualizer;->mStrengthSupported:Z

    iput-object v5, p0, Landroid/media/audiofx/Virtualizer;->mParamListener:Landroid/media/audiofx/Virtualizer$OnParameterChangeListener;

    iput-object v5, p0, Landroid/media/audiofx/Virtualizer;->mBaseParamListener:Landroid/media/audiofx/Virtualizer$BaseParameterListener;

    new-instance v3, Ljava/lang/Object;

    invoke-direct/range {v3 .. v3}, Ljava/lang/Object;-><init>()V

    iput-object v3, p0, Landroid/media/audiofx/Virtualizer;->mParamListenerLock:Ljava/lang/Object;

    if-nez p2, :cond_20

    const-string v3, "Virtualizer"

    const-string v4, "WARNING: attaching a Virtualizer to global output mix is deprecated!"

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_20
    new-array v0, v1, [I

    .local v0, value:[I
    invoke-virtual {p0, v2, v0}, Landroid/media/audiofx/Virtualizer;->getParameter(I[I)I

    move-result v3

    invoke-virtual {p0, v3}, Landroid/media/audiofx/Virtualizer;->checkStatus(I)V

    aget v3, v0, v2

    if-eqz v3, :cond_30

    :goto_2d
    iput-boolean v1, p0, Landroid/media/audiofx/Virtualizer;->mStrengthSupported:Z

    return-void

    :cond_30
    move v1, v2

    goto :goto_2d
.end method

.method static synthetic access$000(Landroid/media/audiofx/Virtualizer;)Ljava/lang/Object;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/media/audiofx/Virtualizer;->mParamListenerLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$100(Landroid/media/audiofx/Virtualizer;)Landroid/media/audiofx/Virtualizer$OnParameterChangeListener;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/media/audiofx/Virtualizer;->mParamListener:Landroid/media/audiofx/Virtualizer$OnParameterChangeListener;

    return-object v0
.end method


# virtual methods
.method public getProperties()Landroid/media/audiofx/Virtualizer$Settings;
    .registers 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/UnsupportedOperationException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    new-instance v0, Landroid/media/audiofx/Virtualizer$Settings;

    invoke-direct {v0}, Landroid/media/audiofx/Virtualizer$Settings;-><init>()V

    .local v0, settings:Landroid/media/audiofx/Virtualizer$Settings;
    new-array v1, v2, [S

    .local v1, value:[S
    invoke-virtual {p0, v2, v1}, Landroid/media/audiofx/Virtualizer;->getParameter(I[S)I

    move-result v2

    invoke-virtual {p0, v2}, Landroid/media/audiofx/Virtualizer;->checkStatus(I)V

    const/4 v2, 0x0

    aget-short v2, v1, v2

    iput-short v2, v0, Landroid/media/audiofx/Virtualizer$Settings;->strength:S

    return-object v0
.end method

.method public getRoundedStrength()S
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/UnsupportedOperationException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    new-array v0, v1, [S

    .local v0, value:[S
    invoke-virtual {p0, v1, v0}, Landroid/media/audiofx/Virtualizer;->getParameter(I[S)I

    move-result v1

    invoke-virtual {p0, v1}, Landroid/media/audiofx/Virtualizer;->checkStatus(I)V

    const/4 v1, 0x0

    aget-short v1, v0, v1

    return v1
.end method

.method public getStrengthSupported()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/media/audiofx/Virtualizer;->mStrengthSupported:Z

    return v0
.end method

.method public setParameterListener(Landroid/media/audiofx/Virtualizer$OnParameterChangeListener;)V
    .registers 5
    .parameter "listener"

    .prologue
    iget-object v1, p0, Landroid/media/audiofx/Virtualizer;->mParamListenerLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iget-object v0, p0, Landroid/media/audiofx/Virtualizer;->mParamListener:Landroid/media/audiofx/Virtualizer$OnParameterChangeListener;

    if-nez v0, :cond_16

    iput-object p1, p0, Landroid/media/audiofx/Virtualizer;->mParamListener:Landroid/media/audiofx/Virtualizer$OnParameterChangeListener;

    new-instance v0, Landroid/media/audiofx/Virtualizer$BaseParameterListener;

    const/4 v2, 0x0

    invoke-direct {v0, p0, v2}, Landroid/media/audiofx/Virtualizer$BaseParameterListener;-><init>(Landroid/media/audiofx/Virtualizer;Landroid/media/audiofx/Virtualizer$1;)V

    iput-object v0, p0, Landroid/media/audiofx/Virtualizer;->mBaseParamListener:Landroid/media/audiofx/Virtualizer$BaseParameterListener;

    iget-object v0, p0, Landroid/media/audiofx/Virtualizer;->mBaseParamListener:Landroid/media/audiofx/Virtualizer$BaseParameterListener;

    invoke-super {p0, v0}, Landroid/media/audiofx/AudioEffect;->setParameterListener(Landroid/media/audiofx/AudioEffect$OnParameterChangeListener;)V

    :cond_16
    monitor-exit v1

    return-void

    :catchall_18
    move-exception v0

    monitor-exit v1
    :try_end_1a
    .catchall {:try_start_3 .. :try_end_1a} :catchall_18

    throw v0
.end method

.method public setProperties(Landroid/media/audiofx/Virtualizer$Settings;)V
    .registers 4
    .parameter "settings"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/UnsupportedOperationException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x1

    iget-short v1, p1, Landroid/media/audiofx/Virtualizer$Settings;->strength:S

    invoke-virtual {p0, v0, v1}, Landroid/media/audiofx/Virtualizer;->setParameter(IS)I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/media/audiofx/Virtualizer;->checkStatus(I)V

    return-void
.end method

.method public setStrength(S)V
    .registers 3
    .parameter "strength"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/UnsupportedOperationException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x1

    invoke-virtual {p0, v0, p1}, Landroid/media/audiofx/Virtualizer;->setParameter(IS)I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/media/audiofx/Virtualizer;->checkStatus(I)V

    return-void
.end method
