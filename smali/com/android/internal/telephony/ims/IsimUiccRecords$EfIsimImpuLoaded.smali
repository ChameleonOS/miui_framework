.class Lcom/android/internal/telephony/ims/IsimUiccRecords$EfIsimImpuLoaded;
.super Ljava/lang/Object;
.source "IsimUiccRecords.java"

# interfaces
.implements Lcom/android/internal/telephony/IccRecords$IccRecordLoaded;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/ims/IsimUiccRecords;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "EfIsimImpuLoaded"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/telephony/ims/IsimUiccRecords;


# direct methods
.method private constructor <init>(Lcom/android/internal/telephony/ims/IsimUiccRecords;)V
    .registers 2
    .parameter

    .prologue
    .line 61
    iput-object p1, p0, Lcom/android/internal/telephony/ims/IsimUiccRecords$EfIsimImpuLoaded;->this$0:Lcom/android/internal/telephony/ims/IsimUiccRecords;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/internal/telephony/ims/IsimUiccRecords;Lcom/android/internal/telephony/ims/IsimUiccRecords$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 61
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/ims/IsimUiccRecords$EfIsimImpuLoaded;-><init>(Lcom/android/internal/telephony/ims/IsimUiccRecords;)V

    return-void
.end method


# virtual methods
.method public getEfName()Ljava/lang/String;
    .registers 2

    .prologue
    .line 63
    const-string v0, "EF_ISIM_IMPU"

    return-object v0
.end method

.method public onRecordLoaded(Landroid/os/AsyncResult;)V
    .registers 11
    .parameter "ar"

    .prologue
    .line 66
    iget-object v5, p1, Landroid/os/AsyncResult;->result:Ljava/lang/Object;

    check-cast v5, Ljava/util/ArrayList;

    .line 67
    .local v5, impuList:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    iget-object v6, p0, Lcom/android/internal/telephony/ims/IsimUiccRecords$EfIsimImpuLoaded;->this$0:Lcom/android/internal/telephony/ims/IsimUiccRecords;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "EF_IMPU record count: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/android/internal/telephony/ims/IsimUiccRecords;->log(Ljava/lang/String;)V

    .line 68
    iget-object v6, p0, Lcom/android/internal/telephony/ims/IsimUiccRecords$EfIsimImpuLoaded;->this$0:Lcom/android/internal/telephony/ims/IsimUiccRecords;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v7

    new-array v7, v7, [Ljava/lang/String;

    #setter for: Lcom/android/internal/telephony/ims/IsimUiccRecords;->mIsimImpu:[Ljava/lang/String;
    invoke-static {v6, v7}, Lcom/android/internal/telephony/ims/IsimUiccRecords;->access$202(Lcom/android/internal/telephony/ims/IsimUiccRecords;[Ljava/lang/String;)[Ljava/lang/String;

    .line 69
    const/4 v0, 0x0

    .line 70
    .local v0, i:I
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, i$:Ljava/util/Iterator;
    :goto_30
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_4c

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [B

    .line 71
    .local v3, identity:[B
    #calls: Lcom/android/internal/telephony/ims/IsimUiccRecords;->isimTlvToString([B)Ljava/lang/String;
    invoke-static {v3}, Lcom/android/internal/telephony/ims/IsimUiccRecords;->access$100([B)Ljava/lang/String;

    move-result-object v4

    .line 73
    .local v4, impu:Ljava/lang/String;
    iget-object v6, p0, Lcom/android/internal/telephony/ims/IsimUiccRecords$EfIsimImpuLoaded;->this$0:Lcom/android/internal/telephony/ims/IsimUiccRecords;

    #getter for: Lcom/android/internal/telephony/ims/IsimUiccRecords;->mIsimImpu:[Ljava/lang/String;
    invoke-static {v6}, Lcom/android/internal/telephony/ims/IsimUiccRecords;->access$200(Lcom/android/internal/telephony/ims/IsimUiccRecords;)[Ljava/lang/String;

    move-result-object v6

    add-int/lit8 v1, v0, 0x1

    .end local v0           #i:I
    .local v1, i:I
    aput-object v4, v6, v0

    move v0, v1

    .line 74
    .end local v1           #i:I
    .restart local v0       #i:I
    goto :goto_30

    .line 75
    .end local v3           #identity:[B
    .end local v4           #impu:Ljava/lang/String;
    :cond_4c
    return-void
.end method
