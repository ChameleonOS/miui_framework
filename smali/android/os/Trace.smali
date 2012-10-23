.class public final Landroid/os/Trace;
.super Ljava/lang/Object;
.source "Trace.java"


# static fields
.field public static final PROPERTY_TRACE_TAG_ENABLEFLAGS:Ljava/lang/String; = "debug.atrace.tags.enableflags"

.field public static final TRACE_FLAGS_START_BIT:I = 0x1

.field public static final TRACE_TAGS:[Ljava/lang/String; = null

.field public static final TRACE_TAG_ACTIVITY_MANAGER:J = 0x40L

.field public static final TRACE_TAG_ALWAYS:J = 0x1L

.field public static final TRACE_TAG_AUDIO:J = 0x100L

.field public static final TRACE_TAG_GRAPHICS:J = 0x2L

.field public static final TRACE_TAG_INPUT:J = 0x4L

.field public static final TRACE_TAG_NEVER:J = 0x0L

.field public static final TRACE_TAG_SYNC_MANAGER:J = 0x80L

.field public static final TRACE_TAG_VIDEO:J = 0x200L

.field public static final TRACE_TAG_VIEW:J = 0x8L

.field public static final TRACE_TAG_WEBVIEW:J = 0x10L

.field public static final TRACE_TAG_WINDOW_MANAGER:J = 0x20L

.field private static sEnabledTags:J


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 44
    const/16 v0, 0x9

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "Graphics"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "Input"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "View"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "WebView"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "Window Manager"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "Activity Manager"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "Sync Manager"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "Audio"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "Video"

    aput-object v2, v0, v1

    sput-object v0, Landroid/os/Trace;->TRACE_TAGS:[Ljava/lang/String;

    .line 51
    invoke-static {}, Landroid/os/Trace;->nativeGetEnabledTags()J

    move-result-wide v0

    sput-wide v0, Landroid/os/Trace;->sEnabledTags:J

    .line 59
    new-instance v0, Landroid/os/Trace$1;

    invoke-direct {v0}, Landroid/os/Trace$1;-><init>()V

    invoke-static {v0}, Landroid/os/SystemProperties;->addChangeCallback(Ljava/lang/Runnable;)V

    .line 64
    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 66
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 67
    return-void
.end method

.method static synthetic access$002(J)J
    .registers 2
    .parameter "x0"

    .prologue
    .line 29
    sput-wide p0, Landroid/os/Trace;->sEnabledTags:J

    return-wide p0
.end method

.method static synthetic access$100()J
    .registers 2

    .prologue
    .line 29
    invoke-static {}, Landroid/os/Trace;->nativeGetEnabledTags()J

    move-result-wide v0

    return-wide v0
.end method

.method public static isTagEnabled(J)Z
    .registers 6
    .parameter "traceTag"

    .prologue
    .line 76
    sget-wide v0, Landroid/os/Trace;->sEnabledTags:J

    and-long/2addr v0, p0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_b

    const/4 v0, 0x1

    :goto_a
    return v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method private static native nativeGetEnabledTags()J
.end method

.method private static native nativeTraceBegin(JLjava/lang/String;)V
.end method

.method private static native nativeTraceCounter(JLjava/lang/String;I)V
.end method

.method private static native nativeTraceEnd(J)V
.end method

.method public static traceBegin(JLjava/lang/String;)V
    .registers 7
    .parameter "traceTag"
    .parameter "methodName"

    .prologue
    .line 100
    sget-wide v0, Landroid/os/Trace;->sEnabledTags:J

    and-long/2addr v0, p0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_c

    .line 101
    invoke-static {p0, p1, p2}, Landroid/os/Trace;->nativeTraceBegin(JLjava/lang/String;)V

    .line 103
    :cond_c
    return-void
.end method

.method public static traceCounter(JLjava/lang/String;I)V
    .registers 8
    .parameter "traceTag"
    .parameter "counterName"
    .parameter "counterValue"

    .prologue
    .line 87
    sget-wide v0, Landroid/os/Trace;->sEnabledTags:J

    and-long/2addr v0, p0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_c

    .line 88
    invoke-static {p0, p1, p2, p3}, Landroid/os/Trace;->nativeTraceCounter(JLjava/lang/String;I)V

    .line 90
    :cond_c
    return-void
.end method

.method public static traceEnd(J)V
    .registers 6
    .parameter "traceTag"

    .prologue
    .line 112
    sget-wide v0, Landroid/os/Trace;->sEnabledTags:J

    and-long/2addr v0, p0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_c

    .line 113
    invoke-static {p0, p1}, Landroid/os/Trace;->nativeTraceEnd(J)V

    .line 115
    :cond_c
    return-void
.end method
