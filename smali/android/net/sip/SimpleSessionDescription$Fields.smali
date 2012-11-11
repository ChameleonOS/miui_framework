.class Landroid/net/sip/SimpleSessionDescription$Fields;
.super Ljava/lang/Object;
.source "SimpleSessionDescription.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/sip/SimpleSessionDescription;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Fields"
.end annotation


# instance fields
.field private final mLines:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mOrder:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .registers 3
    .parameter "order"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/net/sip/SimpleSessionDescription$Fields;->mLines:Ljava/util/ArrayList;

    iput-object p1, p0, Landroid/net/sip/SimpleSessionDescription$Fields;->mOrder:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$000(Landroid/net/sip/SimpleSessionDescription$Fields;Ljava/lang/String;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/net/sip/SimpleSessionDescription$Fields;->parse(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$200(Landroid/net/sip/SimpleSessionDescription$Fields;Ljava/lang/StringBuilder;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/net/sip/SimpleSessionDescription$Fields;->write(Ljava/lang/StringBuilder;)V

    return-void
.end method

.method static synthetic access$400(Landroid/net/sip/SimpleSessionDescription$Fields;Ljava/lang/String;C)Ljava/lang/String;
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    invoke-direct {p0, p1, p2}, Landroid/net/sip/SimpleSessionDescription$Fields;->get(Ljava/lang/String;C)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$500(Landroid/net/sip/SimpleSessionDescription$Fields;Ljava/lang/String;CLjava/lang/String;)V
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"

    .prologue
    invoke-direct {p0, p1, p2, p3}, Landroid/net/sip/SimpleSessionDescription$Fields;->set(Ljava/lang/String;CLjava/lang/String;)V

    return-void
.end method

.method private cut(Ljava/lang/String;C)[Ljava/lang/String;
    .registers 9
    .parameter "prefix"
    .parameter "delimiter"

    .prologue
    iget-object v5, p0, Landroid/net/sip/SimpleSessionDescription$Fields;->mLines:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    new-array v4, v5, [Ljava/lang/String;

    .local v4, names:[Ljava/lang/String;
    const/4 v2, 0x0

    .local v2, length:I
    iget-object v5, p0, Landroid/net/sip/SimpleSessionDescription$Fields;->mLines:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :cond_f
    :goto_f
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_39

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .local v3, line:Ljava/lang/String;
    invoke-virtual {v3, p1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_f

    invoke-virtual {v3, p2}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    .local v0, i:I
    const/4 v5, -0x1

    if-ne v0, v5, :cond_2c

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v0

    :cond_2c
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    invoke-virtual {v3, v5, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_f

    .end local v0           #i:I
    .end local v3           #line:Ljava/lang/String;
    :cond_39
    invoke-static {v4, v2}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Ljava/lang/String;

    return-object v5
.end method

.method private find(Ljava/lang/String;C)I
    .registers 7
    .parameter "key"
    .parameter "delimiter"

    .prologue
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    .local v1, length:I
    iget-object v3, p0, Landroid/net/sip/SimpleSessionDescription$Fields;->mLines:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    add-int/lit8 v0, v3, -0x1

    .local v0, i:I
    :goto_c
    if-ltz v0, :cond_2c

    iget-object v3, p0, Landroid/net/sip/SimpleSessionDescription$Fields;->mLines:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .local v2, line:Ljava/lang/String;
    invoke-virtual {v2, p1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_29

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    if-eq v3, v1, :cond_28

    invoke-virtual {v2, v1}, Ljava/lang/String;->charAt(I)C

    move-result v3

    if-ne v3, p2, :cond_29

    .end local v0           #i:I
    .end local v2           #line:Ljava/lang/String;
    :cond_28
    :goto_28
    return v0

    .restart local v0       #i:I
    .restart local v2       #line:Ljava/lang/String;
    :cond_29
    add-int/lit8 v0, v0, -0x1

    goto :goto_c

    .end local v2           #line:Ljava/lang/String;
    :cond_2c
    const/4 v0, -0x1

    goto :goto_28
.end method

.method private get(Ljava/lang/String;C)Ljava/lang/String;
    .registers 7
    .parameter "key"
    .parameter "delimiter"

    .prologue
    invoke-direct {p0, p1, p2}, Landroid/net/sip/SimpleSessionDescription$Fields;->find(Ljava/lang/String;C)I

    move-result v0

    .local v0, index:I
    const/4 v3, -0x1

    if-ne v0, v3, :cond_9

    const/4 v3, 0x0

    :goto_8
    return-object v3

    :cond_9
    iget-object v3, p0, Landroid/net/sip/SimpleSessionDescription$Fields;->mLines:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .local v2, line:Ljava/lang/String;
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    .local v1, length:I
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    if-ne v3, v1, :cond_1e

    const-string v3, ""

    goto :goto_8

    :cond_1e
    add-int/lit8 v3, v1, 0x1

    invoke-virtual {v2, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    goto :goto_8
.end method

.method private parse(Ljava/lang/String;)V
    .registers 8
    .parameter "line"

    .prologue
    const/4 v5, 0x0

    const/4 v4, -0x1

    invoke-virtual {p1, v5}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .local v2, type:C
    iget-object v3, p0, Landroid/net/sip/SimpleSessionDescription$Fields;->mOrder:Ljava/lang/String;

    invoke-virtual {v3, v2}, Ljava/lang/String;->indexOf(I)I

    move-result v3

    if-ne v3, v4, :cond_f

    :goto_e
    return-void

    :cond_f
    const/16 v0, 0x3d

    .local v0, delimiter:C
    const-string v3, "a=rtpmap:"

    invoke-virtual {p1, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_21

    const-string v3, "a=fmtp:"

    invoke-virtual {p1, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2f

    :cond_21
    const/16 v0, 0x20

    :cond_23
    :goto_23
    invoke-virtual {p1, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    .local v1, i:I
    if-ne v1, v4, :cond_3a

    const-string v3, ""

    invoke-direct {p0, p1, v0, v3}, Landroid/net/sip/SimpleSessionDescription$Fields;->set(Ljava/lang/String;CLjava/lang/String;)V

    goto :goto_e

    .end local v1           #i:I
    :cond_2f
    const/16 v3, 0x62

    if-eq v2, v3, :cond_37

    const/16 v3, 0x61

    if-ne v2, v3, :cond_23

    :cond_37
    const/16 v0, 0x3a

    goto :goto_23

    .restart local v1       #i:I
    :cond_3a
    invoke-virtual {p1, v5, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    add-int/lit8 v4, v1, 0x1

    invoke-virtual {p1, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v3, v0, v4}, Landroid/net/sip/SimpleSessionDescription$Fields;->set(Ljava/lang/String;CLjava/lang/String;)V

    goto :goto_e
.end method

.method private set(Ljava/lang/String;CLjava/lang/String;)V
    .registers 7
    .parameter "key"
    .parameter "delimiter"
    .parameter "value"

    .prologue
    const/4 v2, -0x1

    invoke-direct {p0, p1, p2}, Landroid/net/sip/SimpleSessionDescription$Fields;->find(Ljava/lang/String;C)I

    move-result v0

    .local v0, index:I
    if-eqz p3, :cond_30

    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_22

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    :cond_22
    if-ne v0, v2, :cond_2a

    iget-object v1, p0, Landroid/net/sip/SimpleSessionDescription$Fields;->mLines:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_29
    :goto_29
    return-void

    :cond_2a
    iget-object v1, p0, Landroid/net/sip/SimpleSessionDescription$Fields;->mLines:Ljava/util/ArrayList;

    invoke-virtual {v1, v0, p1}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_29

    :cond_30
    if-eq v0, v2, :cond_29

    iget-object v1, p0, Landroid/net/sip/SimpleSessionDescription$Fields;->mLines:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    goto :goto_29
.end method

.method private write(Ljava/lang/StringBuilder;)V
    .registers 8
    .parameter "buffer"

    .prologue
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    iget-object v4, p0, Landroid/net/sip/SimpleSessionDescription$Fields;->mOrder:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-ge v0, v4, :cond_35

    iget-object v4, p0, Landroid/net/sip/SimpleSessionDescription$Fields;->mOrder:Ljava/lang/String;

    invoke-virtual {v4, v0}, Ljava/lang/String;->charAt(I)C

    move-result v3

    .local v3, type:C
    iget-object v4, p0, Landroid/net/sip/SimpleSessionDescription$Fields;->mLines:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :cond_15
    :goto_15
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_32

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .local v2, line:Ljava/lang/String;
    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-ne v4, v3, :cond_15

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\r\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_15

    .end local v2           #line:Ljava/lang/String;
    :cond_32
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .end local v1           #i$:Ljava/util/Iterator;
    .end local v3           #type:C
    :cond_35
    return-void
.end method


# virtual methods
.method public getAddress()Ljava/lang/String;
    .registers 8

    .prologue
    const/4 v3, 0x0

    const/4 v6, 0x2

    const-string v4, "c"

    const/16 v5, 0x3d

    invoke-direct {p0, v4, v5}, Landroid/net/sip/SimpleSessionDescription$Fields;->get(Ljava/lang/String;C)Ljava/lang/String;

    move-result-object v0

    .local v0, address:Ljava/lang/String;
    if-nez v0, :cond_d

    :cond_c
    :goto_c
    return-object v3

    :cond_d
    const-string v4, " "

    invoke-virtual {v0, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .local v1, parts:[Ljava/lang/String;
    array-length v4, v1

    const/4 v5, 0x3

    if-ne v4, v5, :cond_c

    aget-object v3, v1, v6

    const/16 v4, 0x2f

    invoke-virtual {v3, v4}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    .local v2, slash:I
    if-gez v2, :cond_24

    aget-object v3, v1, v6

    goto :goto_c

    :cond_24
    aget-object v3, v1, v6

    const/4 v4, 0x0

    invoke-virtual {v3, v4, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    goto :goto_c
.end method

.method public getAttribute(Ljava/lang/String;)Ljava/lang/String;
    .registers 4
    .parameter "name"

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "a="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/16 v1, 0x3a

    invoke-direct {p0, v0, v1}, Landroid/net/sip/SimpleSessionDescription$Fields;->get(Ljava/lang/String;C)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getAttributeNames()[Ljava/lang/String;
    .registers 3

    .prologue
    const-string v0, "a="

    const/16 v1, 0x3a

    invoke-direct {p0, v0, v1}, Landroid/net/sip/SimpleSessionDescription$Fields;->cut(Ljava/lang/String;C)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getBandwidth(Ljava/lang/String;)I
    .registers 6
    .parameter "type"

    .prologue
    const/4 v1, -0x1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "b="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x3a

    invoke-direct {p0, v2, v3}, Landroid/net/sip/SimpleSessionDescription$Fields;->get(Ljava/lang/String;C)Ljava/lang/String;

    move-result-object v0

    .local v0, value:Ljava/lang/String;
    if-eqz v0, :cond_20

    :try_start_1c
    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_1f
    .catch Ljava/lang/NumberFormatException; {:try_start_1c .. :try_end_1f} :catch_21

    move-result v1

    :cond_20
    :goto_20
    return v1

    :catch_21
    move-exception v2

    invoke-virtual {p0, p1, v1}, Landroid/net/sip/SimpleSessionDescription$Fields;->setBandwidth(Ljava/lang/String;I)V

    goto :goto_20
.end method

.method public getBandwidthTypes()[Ljava/lang/String;
    .registers 3

    .prologue
    const-string v0, "b="

    const/16 v1, 0x3a

    invoke-direct {p0, v0, v1}, Landroid/net/sip/SimpleSessionDescription$Fields;->cut(Ljava/lang/String;C)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getEncryptionKey()Ljava/lang/String;
    .registers 6

    .prologue
    const/4 v2, 0x0

    const-string v3, "k"

    const/16 v4, 0x3d

    invoke-direct {p0, v3, v4}, Landroid/net/sip/SimpleSessionDescription$Fields;->get(Ljava/lang/String;C)Ljava/lang/String;

    move-result-object v1

    .local v1, encryption:Ljava/lang/String;
    if-nez v1, :cond_c

    :cond_b
    :goto_b
    return-object v2

    :cond_c
    const/16 v3, 0x3a

    invoke-virtual {v1, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    .local v0, colon:I
    const/4 v3, -0x1

    if-eq v0, v3, :cond_b

    const/4 v2, 0x0

    add-int/lit8 v3, v0, 0x1

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    goto :goto_b
.end method

.method public getEncryptionMethod()Ljava/lang/String;
    .registers 5

    .prologue
    const-string v2, "k"

    const/16 v3, 0x3d

    invoke-direct {p0, v2, v3}, Landroid/net/sip/SimpleSessionDescription$Fields;->get(Ljava/lang/String;C)Ljava/lang/String;

    move-result-object v1

    .local v1, encryption:Ljava/lang/String;
    if-nez v1, :cond_c

    const/4 v1, 0x0

    .end local v1           #encryption:Ljava/lang/String;
    :cond_b
    :goto_b
    return-object v1

    .restart local v1       #encryption:Ljava/lang/String;
    :cond_c
    const/16 v2, 0x3a

    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    .local v0, colon:I
    const/4 v2, -0x1

    if-eq v0, v2, :cond_b

    const/4 v2, 0x0

    invoke-virtual {v1, v2, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    goto :goto_b
.end method

.method public setAddress(Ljava/lang/String;)V
    .registers 4
    .parameter "address"

    .prologue
    if-eqz p1, :cond_1d

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v0, 0x3a

    invoke-virtual {p1, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    if-gez v0, :cond_25

    const-string v0, "IN IP4 "

    :goto_11
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    :cond_1d
    const-string v0, "c"

    const/16 v1, 0x3d

    invoke-direct {p0, v0, v1, p1}, Landroid/net/sip/SimpleSessionDescription$Fields;->set(Ljava/lang/String;CLjava/lang/String;)V

    return-void

    :cond_25
    const-string v0, "IN IP6 "

    goto :goto_11
.end method

.method public setAttribute(Ljava/lang/String;Ljava/lang/String;)V
    .registers 5
    .parameter "name"
    .parameter "value"

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "a="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/16 v1, 0x3a

    invoke-direct {p0, v0, v1, p2}, Landroid/net/sip/SimpleSessionDescription$Fields;->set(Ljava/lang/String;CLjava/lang/String;)V

    return-void
.end method

.method public setBandwidth(Ljava/lang/String;I)V
    .registers 6
    .parameter "type"
    .parameter "value"

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "b="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0x3a

    if-gez p2, :cond_1c

    const/4 v0, 0x0

    :goto_18
    invoke-direct {p0, v1, v2, v0}, Landroid/net/sip/SimpleSessionDescription$Fields;->set(Ljava/lang/String;CLjava/lang/String;)V

    return-void

    :cond_1c
    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_18
.end method

.method public setEncryption(Ljava/lang/String;Ljava/lang/String;)V
    .registers 7
    .parameter "method"
    .parameter "key"

    .prologue
    const-string v0, "k"

    const/16 v1, 0x3d

    if-eqz p1, :cond_8

    if-nez p2, :cond_c

    .end local p1
    :cond_8
    :goto_8
    invoke-direct {p0, v0, v1, p1}, Landroid/net/sip/SimpleSessionDescription$Fields;->set(Ljava/lang/String;CLjava/lang/String;)V

    return-void

    .restart local p1
    :cond_c
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0x3a

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_8
.end method
