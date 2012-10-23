.class public Landroid/webkit/WebViewCore$EventHub;
.super Ljava/lang/Object;
.source "WebViewCore.java"

# interfaces
.implements Landroid/webkit/WebViewInputDispatcher$WebKitCallbacks;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebViewCore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "EventHub"
.end annotation


# static fields
.field static final ADD_JS_INTERFACE:I = 0x8a

.field static final ADD_PACKAGE_NAME:I = 0xb9

.field static final ADD_PACKAGE_NAMES:I = 0xb8

.field static final AUTOFILL_FORM:I = 0xc0

.field static final CLEAR_CACHE:I = 0x6f

.field static final CLEAR_CONTENT:I = 0x86

.field static final CLEAR_HISTORY:I = 0x70

.field static final CLEAR_SSL_PREF_TABLE:I = 0x96

.field static final CONTENT_INVALIDATE_ALL:I = 0xaf

.field static final COPY_TEXT:I = 0xd2

.field static final DELETE_SELECTION:I = 0x7a

.field static final DELETE_SURROUNDING_TEXT:I = 0x81

.field static final DELETE_TEXT:I = 0xd3

.field private static final DESTROY:I = 0xc8

.field static final DOC_HAS_IMAGES:I = 0x78

.field static final DUMP_DOMTREE:I = 0xaa

.field static final DUMP_RENDERTREE:I = 0xab

.field static final EXECUTE_JS:I = 0xc2

.field static final FIND_ALL:I = 0xdd

.field static final FIND_NEXT:I = 0xde

.field private static final FIRST_PACKAGE_MSG_ID:I = 0x60

.field static final FREE_MEMORY:I = 0x91

.field static final GEOLOCATION_PERMISSIONS_PROVIDE:I = 0xb4

.field static final GO_BACK_FORWARD:I = 0x6a

.field static final HEARTBEAT:I = 0xc5

.field static final HIDE_FULLSCREEN:I = 0xb6

.field static final INSERT_TEXT:I = 0xd4

.field static final KEY_DOWN:I = 0x67

.field static final KEY_PRESS:I = 0xdf

.field static final KEY_UP:I = 0x68

.field private static final LAST_PACKAGE_MSG_ID:I = 0x95

.field static final LISTBOX_CHOICES:I = 0x7b

.field static final LOAD_DATA:I = 0x8b

.field static final LOAD_URL:I = 0x64

.field public static final MESSAGE_RELAY:I = 0x7d

.field static final MODIFY_SELECTION:I = 0xbe

.field static final NOTIFY_ANIMATION_STARTED:I = 0xc4

.field static final ON_PAUSE:I = 0x8f

.field static final ON_RESUME:I = 0x90

.field static final PASS_TO_JS:I = 0x73

.field static final PAUSE_TIMERS:I = 0x6d

.field static final PLUGIN_SURFACE_READY:I = 0xc3

.field static final POPULATE_VISITED_LINKS:I = 0xb5

.field static final POST_URL:I = 0x84

.field static final PROXY_CHANGED:I = 0xc1

.field static final RELOAD:I = 0x66

.field static final REMOVE_JS_INTERFACE:I = 0x95

.field static final REMOVE_PACKAGE_NAME:I = 0xba

.field static final REPLACE_TEXT:I = 0x72

.field static final REQUEST_CURSOR_HREF:I = 0x89

.field static final REQUEST_DOC_AS_TEXT:I = 0xa1

.field static final REQUEST_EXT_REPRESENTATION:I = 0xa0

.field static final RESTORE_STATE:I = 0x6c

.field static final RESUME_TIMERS:I = 0x6e

.field static final REVEAL_SELECTION:I = 0x60

.field static final SAVE_DOCUMENT_STATE:I = 0x80

.field static final SAVE_VIEW_STATE:I = 0xe1

.field static final SAVE_WEBARCHIVE:I = 0x93

.field static final SCROLL_LAYER:I = 0xc6

.field static final SCROLL_TEXT_INPUT:I = 0x63

.field static final SELECT_ALL:I = 0xd7

.field static final SELECT_TEXT:I = 0xd5

.field static final SELECT_WORD_AT:I = 0xd6

.field static final SET_ACTIVE:I = 0x8e

.field static final SET_BACKGROUND_COLOR:I = 0x7e

.field static final SET_GLOBAL_BOUNDS:I = 0x74

.field static final SET_INITIAL_FOCUS:I = 0xe0

.field static final SET_JS_FLAGS:I = 0xae

.field static final SET_MOVE_MOUSE:I = 0x87

.field static final SET_NETWORK_STATE:I = 0x77

.field static final SET_NETWORK_TYPE:I = 0xb7

.field static final SET_SCROLL_OFFSET:I = 0x6b

.field static final SET_SELECTION:I = 0x71

.field static final SET_USE_MOCK_DEVICE_ORIENTATION:I = 0xbf

.field static final SINGLE_LISTBOX_CHOICE:I = 0x7c

.field static final STOP_LOADING:I = 0x65

.field static final TRUST_STORAGE_UPDATED:I = 0xdc

.field static final VIEW_SIZE_CHANGED:I = 0x69

.field static final WEBKIT_DRAW:I = 0x82


# instance fields
.field private mBlockMessages:Z

.field private mDestroying:Z

.field private mHandler:Landroid/os/Handler;

.field private mMessages:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Landroid/os/Message;",
            ">;"
        }
    .end annotation
.end field

.field private mSavedPriority:I

.field private mTid:I

.field final synthetic this$0:Landroid/webkit/WebViewCore;


# direct methods
.method private constructor <init>(Landroid/webkit/WebViewCore;)V
    .registers 3
    .parameter

    .prologue
    .line 1219
    iput-object p1, p0, Landroid/webkit/WebViewCore$EventHub;->this$0:Landroid/webkit/WebViewCore;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1207
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewCore$EventHub;->mMessages:Ljava/util/LinkedList;

    .line 1219
    return-void
.end method

.method synthetic constructor <init>(Landroid/webkit/WebViewCore;Landroid/webkit/WebViewCore$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 1075
    invoke-direct {p0, p1}, Landroid/webkit/WebViewCore$EventHub;-><init>(Landroid/webkit/WebViewCore;)V

    return-void
.end method

.method static synthetic access$1200(Landroid/webkit/WebViewCore$EventHub;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 1075
    iget-boolean v0, p0, Landroid/webkit/WebViewCore$EventHub;->mDestroying:Z

    return v0
.end method

.method static synthetic access$1202(Landroid/webkit/WebViewCore$EventHub;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 1075
    iput-boolean p1, p0, Landroid/webkit/WebViewCore$EventHub;->mDestroying:Z

    return p1
.end method

.method static synthetic access$200(Landroid/webkit/WebViewCore$EventHub;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 1075
    invoke-direct {p0}, Landroid/webkit/WebViewCore$EventHub;->transferMessages()V

    return-void
.end method

.method static synthetic access$7100(Landroid/webkit/WebViewCore$EventHub;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 1075
    invoke-direct {p0, p1}, Landroid/webkit/WebViewCore$EventHub;->sendMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$7200(Landroid/webkit/WebViewCore$EventHub;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 1075
    invoke-direct {p0, p1}, Landroid/webkit/WebViewCore$EventHub;->sendMessageAtFrontOfQueue(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$7300(Landroid/webkit/WebViewCore$EventHub;Landroid/os/Message;J)V
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 1075
    invoke-direct {p0, p1, p2, p3}, Landroid/webkit/WebViewCore$EventHub;->sendMessageDelayed(Landroid/os/Message;J)V

    return-void
.end method

.method static synthetic access$7400(Landroid/webkit/WebViewCore$EventHub;I)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 1075
    invoke-direct {p0, p1}, Landroid/webkit/WebViewCore$EventHub;->removeMessages(I)V

    return-void
.end method

.method static synthetic access$7500(Landroid/webkit/WebViewCore$EventHub;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 1075
    invoke-direct {p0}, Landroid/webkit/WebViewCore$EventHub;->removeMessages()V

    return-void
.end method

.method static synthetic access$7600(Landroid/webkit/WebViewCore$EventHub;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 1075
    invoke-direct {p0}, Landroid/webkit/WebViewCore$EventHub;->blockMessages()V

    return-void
.end method

.method static synthetic access$800(Landroid/webkit/WebViewCore$EventHub;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 1075
    iget v0, p0, Landroid/webkit/WebViewCore$EventHub;->mSavedPriority:I

    return v0
.end method

.method static synthetic access$802(Landroid/webkit/WebViewCore$EventHub;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 1075
    iput p1, p0, Landroid/webkit/WebViewCore$EventHub;->mSavedPriority:I

    return p1
.end method

.method static synthetic access$900(Landroid/webkit/WebViewCore$EventHub;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 1075
    iget v0, p0, Landroid/webkit/WebViewCore$EventHub;->mTid:I

    return v0
.end method

.method private declared-synchronized blockMessages()V
    .registers 2

    .prologue
    .line 1907
    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    iput-boolean v0, p0, Landroid/webkit/WebViewCore$EventHub;->mBlockMessages:Z
    :try_end_4
    .catchall {:try_start_2 .. :try_end_4} :catchall_6

    .line 1908
    monitor-exit p0

    return-void

    .line 1907
    :catchall_6
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized removeMessages()V
    .registers 3

    .prologue
    .line 1895
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebViewCore$EventHub;->this$0:Landroid/webkit/WebViewCore;

    const/4 v1, 0x0

    #setter for: Landroid/webkit/WebViewCore;->mDrawIsScheduled:Z
    invoke-static {v0, v1}, Landroid/webkit/WebViewCore;->access$7002(Landroid/webkit/WebViewCore;Z)Z

    .line 1896
    iget-object v0, p0, Landroid/webkit/WebViewCore$EventHub;->mMessages:Ljava/util/LinkedList;

    if-eqz v0, :cond_12

    .line 1897
    iget-object v0, p0, Landroid/webkit/WebViewCore$EventHub;->mMessages:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->clear()V
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_19

    .line 1901
    :goto_10
    monitor-exit p0

    return-void

    .line 1899
    :cond_12
    :try_start_12
    iget-object v0, p0, Landroid/webkit/WebViewCore$EventHub;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V
    :try_end_18
    .catchall {:try_start_12 .. :try_end_18} :catchall_19

    goto :goto_10

    .line 1895
    :catchall_19
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized removeMessages(I)V
    .registers 6
    .parameter "what"

    .prologue
    .line 1850
    monitor-enter p0

    :try_start_1
    iget-boolean v2, p0, Landroid/webkit/WebViewCore$EventHub;->mBlockMessages:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_2f

    if-eqz v2, :cond_7

    .line 1867
    :cond_5
    :goto_5
    monitor-exit p0

    return-void

    .line 1853
    :cond_7
    const/16 v2, 0x82

    if-ne p1, v2, :cond_11

    .line 1854
    :try_start_b
    iget-object v2, p0, Landroid/webkit/WebViewCore$EventHub;->this$0:Landroid/webkit/WebViewCore;

    const/4 v3, 0x0

    #setter for: Landroid/webkit/WebViewCore;->mDrawIsScheduled:Z
    invoke-static {v2, v3}, Landroid/webkit/WebViewCore;->access$7002(Landroid/webkit/WebViewCore;Z)Z

    .line 1856
    :cond_11
    iget-object v2, p0, Landroid/webkit/WebViewCore$EventHub;->mMessages:Ljava/util/LinkedList;

    if-eqz v2, :cond_32

    .line 1857
    iget-object v2, p0, Landroid/webkit/WebViewCore$EventHub;->mMessages:Ljava/util/LinkedList;

    invoke-virtual {v2}, Ljava/util/LinkedList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 1858
    .local v0, iter:Ljava/util/Iterator;,"Ljava/util/Iterator<Landroid/os/Message;>;"
    :cond_1b
    :goto_1b
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 1859
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Message;

    .line 1860
    .local v1, m:Landroid/os/Message;
    iget v2, v1, Landroid/os/Message;->what:I

    if-ne v2, p1, :cond_1b

    .line 1861
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V
    :try_end_2e
    .catchall {:try_start_b .. :try_end_2e} :catchall_2f

    goto :goto_1b

    .line 1850
    .end local v0           #iter:Ljava/util/Iterator;,"Ljava/util/Iterator<Landroid/os/Message;>;"
    .end local v1           #m:Landroid/os/Message;
    :catchall_2f
    move-exception v2

    monitor-exit p0

    throw v2

    .line 1865
    :cond_32
    :try_start_32
    iget-object v2, p0, Landroid/webkit/WebViewCore$EventHub;->mHandler:Landroid/os/Handler;

    invoke-virtual {v2, p1}, Landroid/os/Handler;->removeMessages(I)V
    :try_end_37
    .catchall {:try_start_32 .. :try_end_37} :catchall_2f

    goto :goto_5
.end method

.method private declared-synchronized sendMessage(Landroid/os/Message;)V
    .registers 3
    .parameter "msg"

    .prologue
    .line 1839
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebViewCore$EventHub;->mBlockMessages:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_11

    if-eqz v0, :cond_7

    .line 1847
    :goto_5
    monitor-exit p0

    return-void

    .line 1842
    :cond_7
    :try_start_7
    iget-object v0, p0, Landroid/webkit/WebViewCore$EventHub;->mMessages:Ljava/util/LinkedList;

    if-eqz v0, :cond_14

    .line 1843
    iget-object v0, p0, Landroid/webkit/WebViewCore$EventHub;->mMessages:Ljava/util/LinkedList;

    invoke-virtual {v0, p1}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z
    :try_end_10
    .catchall {:try_start_7 .. :try_end_10} :catchall_11

    goto :goto_5

    .line 1839
    :catchall_11
    move-exception v0

    monitor-exit p0

    throw v0

    .line 1845
    :cond_14
    :try_start_14
    iget-object v0, p0, Landroid/webkit/WebViewCore$EventHub;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    :try_end_19
    .catchall {:try_start_14 .. :try_end_19} :catchall_11

    goto :goto_5
.end method

.method private declared-synchronized sendMessageAtFrontOfQueue(Landroid/os/Message;)V
    .registers 4
    .parameter "msg"

    .prologue
    .line 1880
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebViewCore$EventHub;->mBlockMessages:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_12

    if-eqz v0, :cond_7

    .line 1888
    :goto_5
    monitor-exit p0

    return-void

    .line 1883
    :cond_7
    :try_start_7
    iget-object v0, p0, Landroid/webkit/WebViewCore$EventHub;->mMessages:Ljava/util/LinkedList;

    if-eqz v0, :cond_15

    .line 1884
    iget-object v0, p0, Landroid/webkit/WebViewCore$EventHub;->mMessages:Ljava/util/LinkedList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p1}, Ljava/util/LinkedList;->add(ILjava/lang/Object;)V
    :try_end_11
    .catchall {:try_start_7 .. :try_end_11} :catchall_12

    goto :goto_5

    .line 1880
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0

    .line 1886
    :cond_15
    :try_start_15
    iget-object v0, p0, Landroid/webkit/WebViewCore$EventHub;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->sendMessageAtFrontOfQueue(Landroid/os/Message;)Z
    :try_end_1a
    .catchall {:try_start_15 .. :try_end_1a} :catchall_12

    goto :goto_5
.end method

.method private declared-synchronized sendMessageDelayed(Landroid/os/Message;J)V
    .registers 5
    .parameter "msg"
    .parameter "delay"

    .prologue
    .line 1870
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebViewCore$EventHub;->mBlockMessages:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_d

    if-eqz v0, :cond_7

    .line 1874
    :goto_5
    monitor-exit p0

    return-void

    .line 1873
    :cond_7
    :try_start_7
    iget-object v0, p0, Landroid/webkit/WebViewCore$EventHub;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0, p1, p2, p3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z
    :try_end_c
    .catchall {:try_start_7 .. :try_end_c} :catchall_d

    goto :goto_5

    .line 1870
    :catchall_d
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private transferMessages()V
    .registers 5

    .prologue
    .line 1228
    invoke-static {}, Landroid/os/Process;->myTid()I

    move-result v2

    iput v2, p0, Landroid/webkit/WebViewCore$EventHub;->mTid:I

    .line 1229
    iget v2, p0, Landroid/webkit/WebViewCore$EventHub;->mTid:I

    invoke-static {v2}, Landroid/os/Process;->getThreadPriority(I)I

    move-result v2

    iput v2, p0, Landroid/webkit/WebViewCore$EventHub;->mSavedPriority:I

    .line 1231
    new-instance v2, Landroid/webkit/WebViewCore$EventHub$1;

    invoke-direct {v2, p0}, Landroid/webkit/WebViewCore$EventHub$1;-><init>(Landroid/webkit/WebViewCore$EventHub;)V

    iput-object v2, p0, Landroid/webkit/WebViewCore$EventHub;->mHandler:Landroid/os/Handler;

    .line 1775
    monitor-enter p0

    .line 1776
    :try_start_16
    iget-object v2, p0, Landroid/webkit/WebViewCore$EventHub;->mMessages:Ljava/util/LinkedList;

    invoke-virtual {v2}, Ljava/util/LinkedList;->size()I

    move-result v1

    .line 1777
    .local v1, size:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1d
    if-ge v0, v1, :cond_2f

    .line 1778
    iget-object v3, p0, Landroid/webkit/WebViewCore$EventHub;->mHandler:Landroid/os/Handler;

    iget-object v2, p0, Landroid/webkit/WebViewCore$EventHub;->mMessages:Ljava/util/LinkedList;

    invoke-virtual {v2, v0}, Ljava/util/LinkedList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Message;

    invoke-virtual {v3, v2}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 1777
    add-int/lit8 v0, v0, 0x1

    goto :goto_1d

    .line 1780
    :cond_2f
    const/4 v2, 0x0

    iput-object v2, p0, Landroid/webkit/WebViewCore$EventHub;->mMessages:Ljava/util/LinkedList;

    .line 1781
    monitor-exit p0

    .line 1782
    return-void

    .line 1781
    .end local v0           #i:I
    .end local v1           #size:I
    :catchall_34
    move-exception v2

    monitor-exit p0
    :try_end_36
    .catchall {:try_start_16 .. :try_end_36} :catchall_34

    throw v2
.end method


# virtual methods
.method public dispatchWebKitEvent(Landroid/webkit/WebViewInputDispatcher;Landroid/view/MotionEvent;II)Z
    .registers 20
    .parameter "dispatcher"
    .parameter "event"
    .parameter "eventType"
    .parameter "flags"

    .prologue
    .line 1792
    iget-object v1, p0, Landroid/webkit/WebViewCore$EventHub;->this$0:Landroid/webkit/WebViewCore;

    #getter for: Landroid/webkit/WebViewCore;->mNativeClass:I
    invoke-static {v1}, Landroid/webkit/WebViewCore;->access$300(Landroid/webkit/WebViewCore;)I

    move-result v1

    if-nez v1, :cond_a

    .line 1793
    const/4 v1, 0x0

    .line 1831
    :goto_9
    return v1

    .line 1795
    :cond_a
    sparse-switch p3, :sswitch_data_ac

    .line 1831
    const/4 v1, 0x0

    goto :goto_9

    .line 1797
    :sswitch_f
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v13

    .line 1798
    .local v13, x:I
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v14

    .line 1799
    .local v14, y:I
    iget-object v1, p0, Landroid/webkit/WebViewCore$EventHub;->this$0:Landroid/webkit/WebViewCore;

    iget-object v2, p0, Landroid/webkit/WebViewCore$EventHub;->this$0:Landroid/webkit/WebViewCore;

    #getter for: Landroid/webkit/WebViewCore;->mWebViewClassic:Landroid/webkit/WebViewClassic;
    invoke-static {v2}, Landroid/webkit/WebViewCore;->access$1100(Landroid/webkit/WebViewCore;)Landroid/webkit/WebViewClassic;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebViewClassic;->getScaledNavSlop()I

    move-result v2

    const/4 v3, 0x1

    #calls: Landroid/webkit/WebViewCore;->performHitTest(IIIZ)Landroid/webkit/WebViewCore$WebKitHitTest;
    invoke-static {v1, v13, v14, v2, v3}, Landroid/webkit/WebViewCore;->access$3700(Landroid/webkit/WebViewCore;IIIZ)Landroid/webkit/WebViewCore$WebKitHitTest;

    move-result-object v10

    .line 1801
    .local v10, hit:Landroid/webkit/WebViewCore$WebKitHitTest;
    iget-object v1, p0, Landroid/webkit/WebViewCore$EventHub;->this$0:Landroid/webkit/WebViewCore;

    #getter for: Landroid/webkit/WebViewCore;->mWebViewClassic:Landroid/webkit/WebViewClassic;
    invoke-static {v1}, Landroid/webkit/WebViewCore;->access$1100(Landroid/webkit/WebViewCore;)Landroid/webkit/WebViewClassic;

    move-result-object v1

    iget-object v1, v1, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    const/16 v2, 0x83

    invoke-virtual {v1, v2, v10}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/Message;->sendToTarget()V

    .line 1803
    const/4 v1, 0x0

    goto :goto_9

    .line 1806
    .end local v10           #hit:Landroid/webkit/WebViewCore$WebKitHitTest;
    .end local v13           #x:I
    .end local v14           #y:I
    :sswitch_43
    iget-object v1, p0, Landroid/webkit/WebViewCore$EventHub;->this$0:Landroid/webkit/WebViewCore;

    iget-object v2, p0, Landroid/webkit/WebViewCore$EventHub;->this$0:Landroid/webkit/WebViewCore;

    #getter for: Landroid/webkit/WebViewCore;->mNativeClass:I
    invoke-static {v2}, Landroid/webkit/WebViewCore;->access$300(Landroid/webkit/WebViewCore;)I

    move-result v2

    #calls: Landroid/webkit/WebViewCore;->nativeMouseClick(I)Z
    invoke-static {v1, v2}, Landroid/webkit/WebViewCore;->access$6800(Landroid/webkit/WebViewCore;I)Z

    move-result v1

    goto :goto_9

    .line 1809
    :sswitch_50
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v7

    .line 1810
    .local v7, count:I
    new-array v4, v7, [I

    .line 1811
    .local v4, idArray:[I
    new-array v5, v7, [I

    .line 1812
    .local v5, xArray:[I
    new-array v6, v7, [I

    .line 1813
    .local v6, yArray:[I
    const/4 v11, 0x0

    .local v11, i:I
    :goto_5b
    if-ge v11, v7, :cond_7a

    .line 1814
    move-object/from16 v0, p2

    invoke-virtual {v0, v11}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v1

    aput v1, v4, v11

    .line 1815
    move-object/from16 v0, p2

    invoke-virtual {v0, v11}, Landroid/view/MotionEvent;->getX(I)F

    move-result v1

    float-to-int v1, v1

    aput v1, v5, v11

    .line 1816
    move-object/from16 v0, p2

    invoke-virtual {v0, v11}, Landroid/view/MotionEvent;->getY(I)F

    move-result v1

    float-to-int v1, v1

    aput v1, v6, v11

    .line 1813
    add-int/lit8 v11, v11, 0x1

    goto :goto_5b

    .line 1818
    :cond_7a
    iget-object v1, p0, Landroid/webkit/WebViewCore$EventHub;->this$0:Landroid/webkit/WebViewCore;

    iget-object v2, p0, Landroid/webkit/WebViewCore$EventHub;->this$0:Landroid/webkit/WebViewCore;

    #getter for: Landroid/webkit/WebViewCore;->mNativeClass:I
    invoke-static {v2}, Landroid/webkit/WebViewCore;->access$300(Landroid/webkit/WebViewCore;)I

    move-result v2

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v3

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getActionIndex()I

    move-result v8

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getMetaState()I

    move-result v9

    #calls: Landroid/webkit/WebViewCore;->nativeHandleTouchEvent(II[I[I[IIII)I
    invoke-static/range {v1 .. v9}, Landroid/webkit/WebViewCore;->access$6900(Landroid/webkit/WebViewCore;II[I[I[IIII)I

    move-result v12

    .line 1822
    .local v12, touchFlags:I
    if-nez v12, :cond_a2

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v1

    const/4 v2, 0x3

    if-eq v1, v2, :cond_a2

    and-int/lit8 v1, p4, 0x1

    if-nez v1, :cond_a2

    .line 1825
    invoke-virtual/range {p1 .. p1}, Landroid/webkit/WebViewInputDispatcher;->skipWebkitForRemainingTouchStream()V

    .line 1827
    :cond_a2
    and-int/lit8 v1, v12, 0x2

    if-lez v1, :cond_a9

    const/4 v1, 0x1

    goto/16 :goto_9

    :cond_a9
    const/4 v1, 0x0

    goto/16 :goto_9

    .line 1795
    :sswitch_data_ac
    .sparse-switch
        0x0 -> :sswitch_50
        0x4 -> :sswitch_43
        0x6 -> :sswitch_f
    .end sparse-switch
.end method

.method public getWebKitLooper()Landroid/os/Looper;
    .registers 2

    .prologue
    .line 1786
    iget-object v0, p0, Landroid/webkit/WebViewCore$EventHub;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v0

    return-object v0
.end method
