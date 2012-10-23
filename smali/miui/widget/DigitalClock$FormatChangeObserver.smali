.class Lmiui/widget/DigitalClock$FormatChangeObserver;
.super Landroid/database/ContentObserver;
.source "DigitalClock.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/widget/DigitalClock;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "FormatChangeObserver"
.end annotation


# instance fields
.field private mClock:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lmiui/widget/DigitalClock;",
            ">;"
        }
    .end annotation
.end field

.field private mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Lmiui/widget/DigitalClock;)V
    .registers 3
    .parameter "clock"

    .prologue
    .line 137
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    invoke-direct {p0, v0}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    .line 138
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lmiui/widget/DigitalClock$FormatChangeObserver;->mClock:Ljava/lang/ref/WeakReference;

    .line 139
    invoke-virtual {p1}, Lmiui/widget/DigitalClock;->getContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lmiui/widget/DigitalClock$FormatChangeObserver;->mContext:Landroid/content/Context;

    .line 140
    return-void
.end method


# virtual methods
.method public onChange(Z)V
    .registers 4
    .parameter "selfChange"

    .prologue
    .line 143
    iget-object v1, p0, Lmiui/widget/DigitalClock$FormatChangeObserver;->mClock:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lmiui/widget/DigitalClock;

    .line 144
    .local v0, digitalClock:Lmiui/widget/DigitalClock;
    if-eqz v0, :cond_11

    .line 145
    #calls: Lmiui/widget/DigitalClock;->setDateFormat()V
    invoke-static {v0}, Lmiui/widget/DigitalClock;->access$300(Lmiui/widget/DigitalClock;)V

    .line 146
    #calls: Lmiui/widget/DigitalClock;->updateTime()V
    invoke-static {v0}, Lmiui/widget/DigitalClock;->access$100(Lmiui/widget/DigitalClock;)V

    .line 154
    :goto_10
    return-void

    .line 149
    :cond_11
    :try_start_11
    iget-object v1, p0, Lmiui/widget/DigitalClock$FormatChangeObserver;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/content/ContentResolver;->unregisterContentObserver(Landroid/database/ContentObserver;)V
    :try_end_1a
    .catch Ljava/lang/RuntimeException; {:try_start_11 .. :try_end_1a} :catch_1b

    goto :goto_10

    .line 150
    :catch_1b
    move-exception v1

    goto :goto_10
.end method
