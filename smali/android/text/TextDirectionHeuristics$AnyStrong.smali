.class Landroid/text/TextDirectionHeuristics$AnyStrong;
.super Ljava/lang/Object;
.source "TextDirectionHeuristics.java"

# interfaces
.implements Landroid/text/TextDirectionHeuristics$TextDirectionAlgorithm;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/text/TextDirectionHeuristics;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AnyStrong"
.end annotation


# static fields
.field public static final INSTANCE_LTR:Landroid/text/TextDirectionHeuristics$AnyStrong;

.field public static final INSTANCE_RTL:Landroid/text/TextDirectionHeuristics$AnyStrong;


# instance fields
.field private final mLookForRtl:Z


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    new-instance v0, Landroid/text/TextDirectionHeuristics$AnyStrong;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/text/TextDirectionHeuristics$AnyStrong;-><init>(Z)V

    sput-object v0, Landroid/text/TextDirectionHeuristics$AnyStrong;->INSTANCE_RTL:Landroid/text/TextDirectionHeuristics$AnyStrong;

    new-instance v0, Landroid/text/TextDirectionHeuristics$AnyStrong;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroid/text/TextDirectionHeuristics$AnyStrong;-><init>(Z)V

    sput-object v0, Landroid/text/TextDirectionHeuristics$AnyStrong;->INSTANCE_LTR:Landroid/text/TextDirectionHeuristics$AnyStrong;

    return-void
.end method

.method private constructor <init>(Z)V
    .registers 2
    .parameter "lookForRtl"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-boolean p1, p0, Landroid/text/TextDirectionHeuristics$AnyStrong;->mLookForRtl:Z

    return-void
.end method


# virtual methods
.method public checkRtl([CII)Landroid/text/TextDirectionHeuristics$TriState;
    .registers 9
    .parameter "text"
    .parameter "start"
    .parameter "count"

    .prologue
    const/4 v1, 0x0

    .local v1, haveUnlookedFor:Z
    move v2, p2

    .local v2, i:I
    add-int v0, p2, p3

    .local v0, e:I
    :goto_4
    if-ge v2, v0, :cond_30

    sget-object v3, Landroid/text/TextDirectionHeuristics$1;->$SwitchMap$android$text$TextDirectionHeuristics$TriState:[I

    aget-char v4, p1, v2

    invoke-static {v4}, Ljava/lang/Character;->getDirectionality(C)B

    move-result v4

    #calls: Landroid/text/TextDirectionHeuristics;->isRtlText(I)Landroid/text/TextDirectionHeuristics$TriState;
    invoke-static {v4}, Landroid/text/TextDirectionHeuristics;->access$200(I)Landroid/text/TextDirectionHeuristics$TriState;

    move-result-object v4

    invoke-virtual {v4}, Landroid/text/TextDirectionHeuristics$TriState;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_40

    :goto_1b
    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    :pswitch_1e
    iget-boolean v3, p0, Landroid/text/TextDirectionHeuristics$AnyStrong;->mLookForRtl:Z

    if-eqz v3, :cond_25

    sget-object v3, Landroid/text/TextDirectionHeuristics$TriState;->TRUE:Landroid/text/TextDirectionHeuristics$TriState;

    :goto_24
    return-object v3

    :cond_25
    const/4 v1, 0x1

    goto :goto_1b

    :pswitch_27
    iget-boolean v3, p0, Landroid/text/TextDirectionHeuristics$AnyStrong;->mLookForRtl:Z

    if-nez v3, :cond_2e

    sget-object v3, Landroid/text/TextDirectionHeuristics$TriState;->FALSE:Landroid/text/TextDirectionHeuristics$TriState;

    goto :goto_24

    :cond_2e
    const/4 v1, 0x1

    goto :goto_1b

    :cond_30
    if-eqz v1, :cond_3c

    iget-boolean v3, p0, Landroid/text/TextDirectionHeuristics$AnyStrong;->mLookForRtl:Z

    if-eqz v3, :cond_39

    sget-object v3, Landroid/text/TextDirectionHeuristics$TriState;->FALSE:Landroid/text/TextDirectionHeuristics$TriState;

    goto :goto_24

    :cond_39
    sget-object v3, Landroid/text/TextDirectionHeuristics$TriState;->TRUE:Landroid/text/TextDirectionHeuristics$TriState;

    goto :goto_24

    :cond_3c
    sget-object v3, Landroid/text/TextDirectionHeuristics$TriState;->UNKNOWN:Landroid/text/TextDirectionHeuristics$TriState;

    goto :goto_24

    nop

    :pswitch_data_40
    .packed-switch 0x1
        :pswitch_1e
        :pswitch_27
    .end packed-switch
.end method
