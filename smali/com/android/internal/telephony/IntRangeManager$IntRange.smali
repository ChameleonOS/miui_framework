.class Lcom/android/internal/telephony/IntRangeManager$IntRange;
.super Ljava/lang/Object;
.source "IntRangeManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/IntRangeManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "IntRange"
.end annotation


# instance fields
.field final clients:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/internal/telephony/IntRangeManager$ClientRange;",
            ">;"
        }
    .end annotation
.end field

.field endId:I

.field startId:I

.field final synthetic this$0:Lcom/android/internal/telephony/IntRangeManager;


# direct methods
.method constructor <init>(Lcom/android/internal/telephony/IntRangeManager;IILjava/lang/String;)V
    .registers 7
    .parameter
    .parameter "startId"
    .parameter "endId"
    .parameter "client"

    .prologue
    iput-object p1, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->this$0:Lcom/android/internal/telephony/IntRangeManager;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p2, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    iput p3, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    iget-object v0, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    new-instance v1, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    invoke-direct {v1, p1, p2, p3, p4}, Lcom/android/internal/telephony/IntRangeManager$ClientRange;-><init>(Lcom/android/internal/telephony/IntRangeManager;IILjava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method constructor <init>(Lcom/android/internal/telephony/IntRangeManager;Lcom/android/internal/telephony/IntRangeManager$ClientRange;)V
    .registers 5
    .parameter
    .parameter "clientRange"

    .prologue
    iput-object p1, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->this$0:Lcom/android/internal/telephony/IntRangeManager;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iget v0, p2, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->startId:I

    iput v0, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    iget v0, p2, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->endId:I

    iput v0, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    iget-object v0, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method constructor <init>(Lcom/android/internal/telephony/IntRangeManager;Lcom/android/internal/telephony/IntRangeManager$IntRange;I)V
    .registers 7
    .parameter
    .parameter "intRange"
    .parameter "numElements"

    .prologue
    iput-object p1, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->this$0:Lcom/android/internal/telephony/IntRangeManager;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iget v1, p2, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    iput v1, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    iget v1, p2, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    iput v1, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p2, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v1, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    const/4 v0, 0x0

    .local v0, i:I
    :goto_1b
    if-ge v0, p3, :cond_2b

    iget-object v1, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    iget-object v2, p2, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_1b

    :cond_2b
    return-void
.end method


# virtual methods
.method insert(Lcom/android/internal/telephony/IntRangeManager$ClientRange;)V
    .registers 7
    .parameter "range"

    .prologue
    iget-object v3, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v1

    .local v1, len:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_7
    if-ge v0, v1, :cond_26

    iget-object v3, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    .local v2, nextRange:Lcom/android/internal/telephony/IntRangeManager$ClientRange;
    iget v3, p1, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->startId:I

    iget v4, v2, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->startId:I

    if-gt v3, v4, :cond_23

    invoke-virtual {p1, v2}, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_22

    iget-object v3, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    invoke-virtual {v3, v0, p1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .end local v2           #nextRange:Lcom/android/internal/telephony/IntRangeManager$ClientRange;
    :cond_22
    :goto_22
    return-void

    .restart local v2       #nextRange:Lcom/android/internal/telephony/IntRangeManager$ClientRange;
    :cond_23
    add-int/lit8 v0, v0, 0x1

    goto :goto_7

    .end local v2           #nextRange:Lcom/android/internal/telephony/IntRangeManager$ClientRange;
    :cond_26
    iget-object v3, p0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_22
.end method
