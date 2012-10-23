.class Lmiui/util/AudioOutputHelper$DUMP_TAG;
.super Ljava/lang/Object;
.source "AudioOutputHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/util/AudioOutputHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DUMP_TAG"
.end annotation


# static fields
.field public static final ACTIVE_TRACKS_FINDER:Ljava/util/regex/Pattern; = null

.field public static final PID_GRP_IDX:I = 0x2

.field public static final SESSIONS_CONTENT_FINDER:Ljava/util/regex/Pattern; = null

.field public static final SESSIONS_HEAD_FINDER:Ljava/util/regex/Pattern; = null

.field public static final SESSION_GRP_IDX:I = 0x1

.field public static final STANDBY_FINDER:Ljava/util/regex/Pattern; = null

.field public static final STANDBY_GRP_IDX:I = 0x1

.field public static final TRACKS_FINDER:Ljava/util/regex/Pattern; = null

.field public static final TRACK_CONTENT_FINDER:Ljava/util/regex/Pattern; = null

.field public static final TRACK_SESSION_GRP_IDX:I = 0x3

.field public static final TRACK_STREAM_TYPE_GRP_IDX:I = 0x2


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 56
    const-string v0, "^ session pid (cnt|count)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lmiui/util/AudioOutputHelper$DUMP_TAG;->SESSIONS_HEAD_FINDER:Ljava/util/regex/Pattern;

    .line 59
    const-string v0, "^\\s+(\\d+)\\s+(\\d+)\\s+\\d+$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lmiui/util/AudioOutputHelper$DUMP_TAG;->SESSIONS_CONTENT_FINDER:Ljava/util/regex/Pattern;

    .line 65
    const-string v0, "^standby: (\\w+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lmiui/util/AudioOutputHelper$DUMP_TAG;->STANDBY_FINDER:Ljava/util/regex/Pattern;

    .line 70
    const-string v0, "^Output thread 0x[\\w]+ tracks"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lmiui/util/AudioOutputHelper$DUMP_TAG;->TRACKS_FINDER:Ljava/util/regex/Pattern;

    .line 74
    const-string v0, "^Output thread 0x[\\w]+ active tracks"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lmiui/util/AudioOutputHelper$DUMP_TAG;->ACTIVE_TRACKS_FINDER:Ljava/util/regex/Pattern;

    .line 81
    const-string v0, "^(\\s|F)+\\d+\\s+\\d+\\s+(\\d+)\\s+\\d+\\s+\\w+\\s+(\\d+)\\s.+"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lmiui/util/AudioOutputHelper$DUMP_TAG;->TRACK_CONTENT_FINDER:Ljava/util/regex/Pattern;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 54
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
