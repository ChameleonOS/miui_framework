.class Lcom/android/internal/telephony/IntRangeManager$ClientRange;
.super Ljava/lang/Object;
.source "IntRangeManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/IntRangeManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ClientRange"
.end annotation


# instance fields
.field final client:Ljava/lang/String;

.field final endId:I

.field final startId:I

.field final synthetic this$0:Lcom/android/internal/telephony/IntRangeManager;


# direct methods
.method constructor <init>(Lcom/android/internal/telephony/IntRangeManager;IILjava/lang/String;)V
    .registers 5
    .parameter
    .parameter "startId"
    .parameter "endId"
    .parameter "client"

    .prologue
    .line 136
    iput-object p1, p0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->this$0:Lcom/android/internal/telephony/IntRangeManager;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 137
    iput p2, p0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->startId:I

    .line 138
    iput p3, p0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->endId:I

    .line 139
    iput-object p4, p0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->client:Ljava/lang/String;

    .line 140
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6
    .parameter "o"

    .prologue
    const/4 v1, 0x0

    .line 144
    if-eqz p1, :cond_21

    instance-of v2, p1, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    if-eqz v2, :cond_21

    move-object v0, p1

    .line 145
    check-cast v0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    .line 146
    .local v0, other:Lcom/android/internal/telephony/IntRangeManager$ClientRange;
    iget v2, p0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->startId:I

    iget v3, v0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->startId:I

    if-ne v2, v3, :cond_21

    iget v2, p0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->endId:I

    iget v3, v0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->endId:I

    if-ne v2, v3, :cond_21

    iget-object v2, p0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->client:Ljava/lang/String;

    iget-object v3, v0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->client:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_21

    const/4 v1, 0x1

    .line 150
    .end local v0           #other:Lcom/android/internal/telephony/IntRangeManager$ClientRange;
    :cond_21
    return v1
.end method

.method public hashCode()I
    .registers 3

    .prologue
    .line 156
    iget v0, p0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->startId:I

    mul-int/lit8 v0, v0, 0x1f

    iget v1, p0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->endId:I

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->client:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method
