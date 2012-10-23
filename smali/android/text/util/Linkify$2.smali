.class final Landroid/text/util/Linkify$2;
.super Ljava/lang/Object;
.source "Linkify.java"

# interfaces
.implements Landroid/text/util/Linkify$MatchFilter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/text/util/Linkify;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 114
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final acceptMatch(Ljava/lang/CharSequence;II)Z
    .registers 7
    .parameter "s"
    .parameter "start"
    .parameter "end"

    .prologue
    .line 116
    const/4 v0, 0x0

    .line 118
    .local v0, digitCount:I
    move v1, p2

    .local v1, i:I
    :goto_2
    if-ge v1, p3, :cond_18

    .line 119
    invoke-interface {p1, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    invoke-static {v2}, Ljava/lang/Character;->isDigit(C)Z

    move-result v2

    if-eqz v2, :cond_15

    .line 120
    add-int/lit8 v0, v0, 0x1

    .line 121
    const/4 v2, 0x5

    if-lt v0, v2, :cond_15

    .line 122
    const/4 v2, 0x1

    .line 126
    :goto_14
    return v2

    .line 118
    :cond_15
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 126
    :cond_18
    const/4 v2, 0x0

    goto :goto_14
.end method
