.class public Landroid/net/MailTo;
.super Ljava/lang/Object;
.source "MailTo.java"


# static fields
.field private static final BODY:Ljava/lang/String; = "body"

.field private static final CC:Ljava/lang/String; = "cc"

.field public static final MAILTO_SCHEME:Ljava/lang/String; = "mailto:"

.field private static final SUBJECT:Ljava/lang/String; = "subject"

.field private static final TO:Ljava/lang/String; = "to"


# instance fields
.field private mHeaders:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>()V
    .registers 2

    .prologue
    .line 169
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 170
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/net/MailTo;->mHeaders:Ljava/util/HashMap;

    .line 171
    return-void
.end method

.method public static isMailTo(Ljava/lang/String;)Z
    .registers 2
    .parameter "url"

    .prologue
    .line 51
    if-eqz p0, :cond_d

    const-string/jumbo v0, "mailto:"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 52
    const/4 v0, 0x1

    .line 54
    :goto_c
    return v0

    :cond_d
    const/4 v0, 0x0

    goto :goto_c
.end method

.method public static parse(Ljava/lang/String;)Landroid/net/MailTo;
    .registers 18
    .parameter "url"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/net/ParseException;
        }
    .end annotation

    .prologue
    .line 65
    if-nez p0, :cond_8

    .line 66
    new-instance v13, Ljava/lang/NullPointerException;

    invoke-direct {v13}, Ljava/lang/NullPointerException;-><init>()V

    throw v13

    .line 68
    :cond_8
    invoke-static/range {p0 .. p0}, Landroid/net/MailTo;->isMailTo(Ljava/lang/String;)Z

    move-result v13

    if-nez v13, :cond_16

    .line 69
    new-instance v13, Landroid/net/ParseException;

    const-string v14, "Not a mailto scheme"

    invoke-direct {v13, v14}, Landroid/net/ParseException;-><init>(Ljava/lang/String;)V

    throw v13

    .line 72
    :cond_16
    const-string/jumbo v13, "mailto:"

    invoke-virtual {v13}, Ljava/lang/String;->length()I

    move-result v13

    move-object/from16 v0, p0

    invoke-virtual {v0, v13}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v9

    .line 73
    .local v9, noScheme:Ljava/lang/String;
    invoke-static {v9}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 74
    .local v4, email:Landroid/net/Uri;
    new-instance v7, Landroid/net/MailTo;

    invoke-direct {v7}, Landroid/net/MailTo;-><init>()V

    .line 77
    .local v7, m:Landroid/net/MailTo;
    invoke-virtual {v4}, Landroid/net/Uri;->getQuery()Ljava/lang/String;

    move-result-object v12

    .line 78
    .local v12, query:Ljava/lang/String;
    if-eqz v12, :cond_6c

    .line 79
    const-string v13, "&"

    invoke-virtual {v12, v13}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v11

    .line 80
    .local v11, queries:[Ljava/lang/String;
    move-object v3, v11

    .local v3, arr$:[Ljava/lang/String;
    array-length v6, v3

    .local v6, len$:I
    const/4 v5, 0x0

    .local v5, i$:I
    :goto_3b
    if-ge v5, v6, :cond_6c

    aget-object v10, v3, v5

    .line 81
    .local v10, q:Ljava/lang/String;
    const-string v13, "="

    invoke-virtual {v10, v13}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    .line 82
    .local v8, nameval:[Ljava/lang/String;
    array-length v13, v8

    if-nez v13, :cond_4b

    .line 80
    :goto_48
    add-int/lit8 v5, v5, 0x1

    goto :goto_3b

    .line 87
    :cond_4b
    iget-object v14, v7, Landroid/net/MailTo;->mHeaders:Ljava/util/HashMap;

    const/4 v13, 0x0

    aget-object v13, v8, v13

    invoke-static {v13}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v15

    array-length v13, v8

    const/16 v16, 0x1

    move/from16 v0, v16

    if-le v13, v0, :cond_6a

    const/4 v13, 0x1

    aget-object v13, v8, v13

    invoke-static {v13}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    :goto_66
    invoke-virtual {v14, v15, v13}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_48

    :cond_6a
    const/4 v13, 0x0

    goto :goto_66

    .line 94
    .end local v3           #arr$:[Ljava/lang/String;
    .end local v5           #i$:I
    .end local v6           #len$:I
    .end local v8           #nameval:[Ljava/lang/String;
    .end local v10           #q:Ljava/lang/String;
    .end local v11           #queries:[Ljava/lang/String;
    :cond_6c
    invoke-virtual {v4}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v2

    .line 95
    .local v2, address:Ljava/lang/String;
    if-eqz v2, :cond_97

    .line 96
    invoke-virtual {v7}, Landroid/net/MailTo;->getTo()Ljava/lang/String;

    move-result-object v1

    .line 97
    .local v1, addr:Ljava/lang/String;
    if-eqz v1, :cond_8f

    .line 98
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v13, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, ", "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 100
    :cond_8f
    iget-object v13, v7, Landroid/net/MailTo;->mHeaders:Ljava/util/HashMap;

    const-string/jumbo v14, "to"

    invoke-virtual {v13, v14, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 103
    .end local v1           #addr:Ljava/lang/String;
    :cond_97
    return-object v7
.end method


# virtual methods
.method public getBody()Ljava/lang/String;
    .registers 3

    .prologue
    .line 141
    iget-object v0, p0, Landroid/net/MailTo;->mHeaders:Ljava/util/HashMap;

    const-string v1, "body"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getCc()Ljava/lang/String;
    .registers 3

    .prologue
    .line 123
    iget-object v0, p0, Landroid/net/MailTo;->mHeaders:Ljava/util/HashMap;

    const-string v1, "cc"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getHeaders()Ljava/util/Map;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 149
    iget-object v0, p0, Landroid/net/MailTo;->mHeaders:Ljava/util/HashMap;

    return-object v0
.end method

.method public getSubject()Ljava/lang/String;
    .registers 3

    .prologue
    .line 132
    iget-object v0, p0, Landroid/net/MailTo;->mHeaders:Ljava/util/HashMap;

    const-string/jumbo v1, "subject"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getTo()Ljava/lang/String;
    .registers 3

    .prologue
    .line 113
    iget-object v0, p0, Landroid/net/MailTo;->mHeaders:Ljava/util/HashMap;

    const-string/jumbo v1, "to"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .registers 5

    .prologue
    .line 154
    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "mailto:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 155
    .local v2, sb:Ljava/lang/StringBuilder;
    const/16 v3, 0x3f

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 156
    iget-object v3, p0, Landroid/net/MailTo;->mHeaders:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :goto_17
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_48

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 157
    .local v0, header:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 158
    const/16 v3, 0x3d

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 159
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 160
    const/16 v3, 0x26

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_17

    .line 162
    .end local v0           #header:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_48
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method
