.class Lcom/android/internal/telephony/gsm/GsmDataConnectionTracker$ApnChangeObserver;
.super Landroid/database/ContentObserver;
.source "GsmDataConnectionTracker.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/gsm/GsmDataConnectionTracker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ApnChangeObserver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/telephony/gsm/GsmDataConnectionTracker;


# direct methods
.method public constructor <init>(Lcom/android/internal/telephony/gsm/GsmDataConnectionTracker;)V
    .registers 3
    .parameter

    .prologue
    .line 91
    iput-object p1, p0, Lcom/android/internal/telephony/gsm/GsmDataConnectionTracker$ApnChangeObserver;->this$0:Lcom/android/internal/telephony/gsm/GsmDataConnectionTracker;

    .line 92
    #getter for: Lcom/android/internal/telephony/DataConnectionTracker;->mDataConnectionTracker:Landroid/os/Handler;
    invoke-static {p1}, Lcom/android/internal/telephony/gsm/GsmDataConnectionTracker;->access$000(Lcom/android/internal/telephony/gsm/GsmDataConnectionTracker;)Landroid/os/Handler;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    .line 93
    return-void
.end method


# virtual methods
.method public onChange(Z)V
    .registers 5
    .parameter "selfChange"

    .prologue
    .line 97
    iget-object v0, p0, Lcom/android/internal/telephony/gsm/GsmDataConnectionTracker$ApnChangeObserver;->this$0:Lcom/android/internal/telephony/gsm/GsmDataConnectionTracker;

    iget-object v1, p0, Lcom/android/internal/telephony/gsm/GsmDataConnectionTracker$ApnChangeObserver;->this$0:Lcom/android/internal/telephony/gsm/GsmDataConnectionTracker;

    const v2, 0x42013

    invoke-virtual {v1, v2}, Lcom/android/internal/telephony/gsm/GsmDataConnectionTracker;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/internal/telephony/gsm/GsmDataConnectionTracker;->sendMessage(Landroid/os/Message;)Z

    .line 98
    return-void
.end method
