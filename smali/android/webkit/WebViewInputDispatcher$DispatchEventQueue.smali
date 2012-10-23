.class final Landroid/webkit/WebViewInputDispatcher$DispatchEventQueue;
.super Ljava/lang/Object;
.source "WebViewInputDispatcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebViewInputDispatcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "DispatchEventQueue"
.end annotation


# instance fields
.field public mHead:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

.field public mTail:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 1173
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/webkit/WebViewInputDispatcher$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 1173
    invoke-direct {p0}, Landroid/webkit/WebViewInputDispatcher$DispatchEventQueue;-><init>()V

    return-void
.end method


# virtual methods
.method public dequeue()Landroid/webkit/WebViewInputDispatcher$DispatchEvent;
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 1192
    iget-object v0, p0, Landroid/webkit/WebViewInputDispatcher$DispatchEventQueue;->mHead:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    .line 1193
    .local v0, d:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;
    if-eqz v0, :cond_d

    .line 1194
    iget-object v1, v0, Landroid/webkit/WebViewInputDispatcher$DispatchEvent;->mNext:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    .line 1195
    .local v1, next:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;
    if-nez v1, :cond_e

    .line 1196
    iput-object v2, p0, Landroid/webkit/WebViewInputDispatcher$DispatchEventQueue;->mHead:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    .line 1197
    iput-object v2, p0, Landroid/webkit/WebViewInputDispatcher$DispatchEventQueue;->mTail:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    .line 1203
    .end local v1           #next:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;
    :cond_d
    :goto_d
    return-object v0

    .line 1199
    .restart local v1       #next:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;
    :cond_e
    iput-object v1, p0, Landroid/webkit/WebViewInputDispatcher$DispatchEventQueue;->mHead:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    .line 1200
    iput-object v2, v0, Landroid/webkit/WebViewInputDispatcher$DispatchEvent;->mNext:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    goto :goto_d
.end method

.method public dequeueList()Landroid/webkit/WebViewInputDispatcher$DispatchEvent;
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 1207
    iget-object v0, p0, Landroid/webkit/WebViewInputDispatcher$DispatchEventQueue;->mHead:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    .line 1208
    .local v0, d:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;
    if-eqz v0, :cond_9

    .line 1209
    iput-object v1, p0, Landroid/webkit/WebViewInputDispatcher$DispatchEventQueue;->mHead:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    .line 1210
    iput-object v1, p0, Landroid/webkit/WebViewInputDispatcher$DispatchEventQueue;->mTail:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    .line 1212
    :cond_9
    return-object v0
.end method

.method public enqueue(Landroid/webkit/WebViewInputDispatcher$DispatchEvent;)V
    .registers 3
    .parameter "d"

    .prologue
    .line 1182
    iget-object v0, p0, Landroid/webkit/WebViewInputDispatcher$DispatchEventQueue;->mHead:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    if-nez v0, :cond_9

    .line 1183
    iput-object p1, p0, Landroid/webkit/WebViewInputDispatcher$DispatchEventQueue;->mHead:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    .line 1184
    iput-object p1, p0, Landroid/webkit/WebViewInputDispatcher$DispatchEventQueue;->mTail:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    .line 1189
    :goto_8
    return-void

    .line 1186
    :cond_9
    iget-object v0, p0, Landroid/webkit/WebViewInputDispatcher$DispatchEventQueue;->mTail:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    iput-object p1, v0, Landroid/webkit/WebViewInputDispatcher$DispatchEvent;->mNext:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    .line 1187
    iput-object p1, p0, Landroid/webkit/WebViewInputDispatcher$DispatchEventQueue;->mTail:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    goto :goto_8
.end method

.method public isEmpty()Z
    .registers 2

    .prologue
    .line 1178
    iget-object v0, p0, Landroid/webkit/WebViewInputDispatcher$DispatchEventQueue;->mHead:Landroid/webkit/WebViewInputDispatcher$DispatchEvent;

    if-eqz v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method
