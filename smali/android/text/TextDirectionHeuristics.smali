.class public Landroid/text/TextDirectionHeuristics;
.super Ljava/lang/Object;
.source "TextDirectionHeuristics.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/text/TextDirectionHeuristics$1;,
        Landroid/text/TextDirectionHeuristics$TextDirectionHeuristicLocale;,
        Landroid/text/TextDirectionHeuristics$AnyStrong;,
        Landroid/text/TextDirectionHeuristics$FirstStrong;,
        Landroid/text/TextDirectionHeuristics$TextDirectionAlgorithm;,
        Landroid/text/TextDirectionHeuristics$TextDirectionHeuristicInternal;,
        Landroid/text/TextDirectionHeuristics$TextDirectionHeuristicImpl;,
        Landroid/text/TextDirectionHeuristics$TriState;
    }
.end annotation


# static fields
.field public static final ANYRTL_LTR:Landroid/text/TextDirectionHeuristic;

.field public static final FIRSTSTRONG_LTR:Landroid/text/TextDirectionHeuristic;

.field public static final FIRSTSTRONG_RTL:Landroid/text/TextDirectionHeuristic;

.field public static final LOCALE:Landroid/text/TextDirectionHeuristic;

.field public static final LTR:Landroid/text/TextDirectionHeuristic;

.field public static final RTL:Landroid/text/TextDirectionHeuristic;


# direct methods
.method static constructor <clinit>()V
    .registers 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 30
    new-instance v0, Landroid/text/TextDirectionHeuristics$TextDirectionHeuristicInternal;

    invoke-direct {v0, v2, v3, v2}, Landroid/text/TextDirectionHeuristics$TextDirectionHeuristicInternal;-><init>(Landroid/text/TextDirectionHeuristics$TextDirectionAlgorithm;ZLandroid/text/TextDirectionHeuristics$1;)V

    sput-object v0, Landroid/text/TextDirectionHeuristics;->LTR:Landroid/text/TextDirectionHeuristic;

    .line 34
    new-instance v0, Landroid/text/TextDirectionHeuristics$TextDirectionHeuristicInternal;

    invoke-direct {v0, v2, v4, v2}, Landroid/text/TextDirectionHeuristics$TextDirectionHeuristicInternal;-><init>(Landroid/text/TextDirectionHeuristics$TextDirectionAlgorithm;ZLandroid/text/TextDirectionHeuristics$1;)V

    sput-object v0, Landroid/text/TextDirectionHeuristics;->RTL:Landroid/text/TextDirectionHeuristic;

    .line 43
    new-instance v0, Landroid/text/TextDirectionHeuristics$TextDirectionHeuristicInternal;

    sget-object v1, Landroid/text/TextDirectionHeuristics$FirstStrong;->INSTANCE:Landroid/text/TextDirectionHeuristics$FirstStrong;

    invoke-direct {v0, v1, v3, v2}, Landroid/text/TextDirectionHeuristics$TextDirectionHeuristicInternal;-><init>(Landroid/text/TextDirectionHeuristics$TextDirectionAlgorithm;ZLandroid/text/TextDirectionHeuristics$1;)V

    sput-object v0, Landroid/text/TextDirectionHeuristics;->FIRSTSTRONG_LTR:Landroid/text/TextDirectionHeuristic;

    .line 52
    new-instance v0, Landroid/text/TextDirectionHeuristics$TextDirectionHeuristicInternal;

    sget-object v1, Landroid/text/TextDirectionHeuristics$FirstStrong;->INSTANCE:Landroid/text/TextDirectionHeuristics$FirstStrong;

    invoke-direct {v0, v1, v4, v2}, Landroid/text/TextDirectionHeuristics$TextDirectionHeuristicInternal;-><init>(Landroid/text/TextDirectionHeuristics$TextDirectionAlgorithm;ZLandroid/text/TextDirectionHeuristics$1;)V

    sput-object v0, Landroid/text/TextDirectionHeuristics;->FIRSTSTRONG_RTL:Landroid/text/TextDirectionHeuristic;

    .line 60
    new-instance v0, Landroid/text/TextDirectionHeuristics$TextDirectionHeuristicInternal;

    sget-object v1, Landroid/text/TextDirectionHeuristics$AnyStrong;->INSTANCE_RTL:Landroid/text/TextDirectionHeuristics$AnyStrong;

    invoke-direct {v0, v1, v3, v2}, Landroid/text/TextDirectionHeuristics$TextDirectionHeuristicInternal;-><init>(Landroid/text/TextDirectionHeuristics$TextDirectionAlgorithm;ZLandroid/text/TextDirectionHeuristics$1;)V

    sput-object v0, Landroid/text/TextDirectionHeuristics;->ANYRTL_LTR:Landroid/text/TextDirectionHeuristic;

    .line 66
    sget-object v0, Landroid/text/TextDirectionHeuristics$TextDirectionHeuristicLocale;->INSTANCE:Landroid/text/TextDirectionHeuristics$TextDirectionHeuristicLocale;

    sput-object v0, Landroid/text/TextDirectionHeuristics;->LOCALE:Landroid/text/TextDirectionHeuristic;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 27
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 236
    return-void
.end method

.method static synthetic access$100(I)Landroid/text/TextDirectionHeuristics$TriState;
    .registers 2
    .parameter "x0"

    .prologue
    .line 27
    invoke-static {p0}, Landroid/text/TextDirectionHeuristics;->isRtlTextOrFormat(I)Landroid/text/TextDirectionHeuristics$TriState;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(I)Landroid/text/TextDirectionHeuristics$TriState;
    .registers 2
    .parameter "x0"

    .prologue
    .line 27
    invoke-static {p0}, Landroid/text/TextDirectionHeuristics;->isRtlText(I)Landroid/text/TextDirectionHeuristics$TriState;

    move-result-object v0

    return-object v0
.end method

.method private static isRtlText(I)Landroid/text/TextDirectionHeuristics$TriState;
    .registers 2
    .parameter "directionality"

    .prologue
    .line 128
    packed-switch p0, :pswitch_data_c

    .line 135
    sget-object v0, Landroid/text/TextDirectionHeuristics$TriState;->UNKNOWN:Landroid/text/TextDirectionHeuristics$TriState;

    :goto_5
    return-object v0

    .line 130
    :pswitch_6
    sget-object v0, Landroid/text/TextDirectionHeuristics$TriState;->FALSE:Landroid/text/TextDirectionHeuristics$TriState;

    goto :goto_5

    .line 133
    :pswitch_9
    sget-object v0, Landroid/text/TextDirectionHeuristics$TriState;->TRUE:Landroid/text/TextDirectionHeuristics$TriState;

    goto :goto_5

    .line 128
    :pswitch_data_c
    .packed-switch 0x0
        :pswitch_6
        :pswitch_9
        :pswitch_9
    .end packed-switch
.end method

.method private static isRtlTextOrFormat(I)Landroid/text/TextDirectionHeuristics$TriState;
    .registers 2
    .parameter "directionality"

    .prologue
    .line 140
    sparse-switch p0, :sswitch_data_c

    .line 151
    sget-object v0, Landroid/text/TextDirectionHeuristics$TriState;->UNKNOWN:Landroid/text/TextDirectionHeuristics$TriState;

    :goto_5
    return-object v0

    .line 144
    :sswitch_6
    sget-object v0, Landroid/text/TextDirectionHeuristics$TriState;->FALSE:Landroid/text/TextDirectionHeuristics$TriState;

    goto :goto_5

    .line 149
    :sswitch_9
    sget-object v0, Landroid/text/TextDirectionHeuristics$TriState;->TRUE:Landroid/text/TextDirectionHeuristics$TriState;

    goto :goto_5

    .line 140
    :sswitch_data_c
    .sparse-switch
        0x0 -> :sswitch_6
        0x1 -> :sswitch_9
        0x2 -> :sswitch_9
        0xe -> :sswitch_6
        0xf -> :sswitch_6
        0x10 -> :sswitch_9
        0x11 -> :sswitch_9
    .end sparse-switch
.end method
