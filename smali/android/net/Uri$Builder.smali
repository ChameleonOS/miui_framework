.class public final Landroid/net/Uri$Builder;
.super Ljava/lang/Object;
.source "Uri.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/Uri;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# instance fields
.field private authority:Landroid/net/Uri$Part;

.field private fragment:Landroid/net/Uri$Part;

.field private opaquePart:Landroid/net/Uri$Part;

.field private path:Landroid/net/Uri$PathPart;

.field private query:Landroid/net/Uri$Part;

.field private scheme:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 1323
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private hasSchemeOrAuthority()Z
    .registers 3

    .prologue
    .line 1535
    iget-object v0, p0, Landroid/net/Uri$Builder;->scheme:Ljava/lang/String;

    if-nez v0, :cond_e

    iget-object v0, p0, Landroid/net/Uri$Builder;->authority:Landroid/net/Uri$Part;

    if-eqz v0, :cond_10

    iget-object v0, p0, Landroid/net/Uri$Builder;->authority:Landroid/net/Uri$Part;

    sget-object v1, Landroid/net/Uri$Part;->NULL:Landroid/net/Uri$Part;

    if-eq v0, v1, :cond_10

    :cond_e
    const/4 v0, 0x1

    :goto_f
    return v0

    :cond_10
    const/4 v0, 0x0

    goto :goto_f
.end method


# virtual methods
.method public appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;
    .registers 3
    .parameter "newSegment"

    .prologue
    .line 1422
    iget-object v0, p0, Landroid/net/Uri$Builder;->path:Landroid/net/Uri$PathPart;

    invoke-static {v0, p1}, Landroid/net/Uri$PathPart;->appendEncodedSegment(Landroid/net/Uri$PathPart;Ljava/lang/String;)Landroid/net/Uri$PathPart;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/net/Uri$Builder;->path(Landroid/net/Uri$PathPart;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method public appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;
    .registers 3
    .parameter "newSegment"

    .prologue
    .line 1415
    iget-object v0, p0, Landroid/net/Uri$Builder;->path:Landroid/net/Uri$PathPart;

    invoke-static {v0, p1}, Landroid/net/Uri$PathPart;->appendDecodedSegment(Landroid/net/Uri$PathPart;Ljava/lang/String;)Landroid/net/Uri$PathPart;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/net/Uri$Builder;->path(Landroid/net/Uri$PathPart;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method public appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    .registers 8
    .parameter "key"
    .parameter "value"

    .prologue
    const/4 v4, 0x0

    .line 1475
    iput-object v4, p0, Landroid/net/Uri$Builder;->opaquePart:Landroid/net/Uri$Part;

    .line 1477
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p1, v4}, Landroid/net/Uri;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2, v4}, Landroid/net/Uri;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1480
    .local v0, encodedParameter:Ljava/lang/String;
    iget-object v2, p0, Landroid/net/Uri$Builder;->query:Landroid/net/Uri$Part;

    if-nez v2, :cond_2d

    .line 1481
    invoke-static {v0}, Landroid/net/Uri$Part;->fromEncoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v2

    iput-object v2, p0, Landroid/net/Uri$Builder;->query:Landroid/net/Uri$Part;

    .line 1492
    :goto_2c
    return-object p0

    .line 1485
    :cond_2d
    iget-object v2, p0, Landroid/net/Uri$Builder;->query:Landroid/net/Uri$Part;

    invoke-virtual {v2}, Landroid/net/Uri$Part;->getEncoded()Ljava/lang/String;

    move-result-object v1

    .line 1486
    .local v1, oldQuery:Ljava/lang/String;
    if-eqz v1, :cond_3b

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_42

    .line 1487
    :cond_3b
    invoke-static {v0}, Landroid/net/Uri$Part;->fromEncoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v2

    iput-object v2, p0, Landroid/net/Uri$Builder;->query:Landroid/net/Uri$Part;

    goto :goto_2c

    .line 1489
    :cond_42
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "&"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri$Part;->fromEncoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v2

    iput-object v2, p0, Landroid/net/Uri$Builder;->query:Landroid/net/Uri$Part;

    goto :goto_2c
.end method

.method authority(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;
    .registers 3
    .parameter "authority"

    .prologue
    .line 1360
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/net/Uri$Builder;->opaquePart:Landroid/net/Uri$Part;

    .line 1362
    iput-object p1, p0, Landroid/net/Uri$Builder;->authority:Landroid/net/Uri$Part;

    .line 1363
    return-object p0
.end method

.method public authority(Ljava/lang/String;)Landroid/net/Uri$Builder;
    .registers 3
    .parameter "authority"

    .prologue
    .line 1370
    invoke-static {p1}, Landroid/net/Uri$Part;->fromDecoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/net/Uri$Builder;->authority(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method public build()Landroid/net/Uri;
    .registers 8

    .prologue
    const/4 v6, 0x0

    .line 1509
    iget-object v0, p0, Landroid/net/Uri$Builder;->opaquePart:Landroid/net/Uri$Part;

    if-eqz v0, :cond_1d

    .line 1510
    iget-object v0, p0, Landroid/net/Uri$Builder;->scheme:Ljava/lang/String;

    if-nez v0, :cond_11

    .line 1511
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "An opaque URI must have a scheme."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1515
    :cond_11
    new-instance v0, Landroid/net/Uri$OpaqueUri;

    iget-object v1, p0, Landroid/net/Uri$Builder;->scheme:Ljava/lang/String;

    iget-object v2, p0, Landroid/net/Uri$Builder;->opaquePart:Landroid/net/Uri$Part;

    iget-object v4, p0, Landroid/net/Uri$Builder;->fragment:Landroid/net/Uri$Part;

    invoke-direct {v0, v1, v2, v4, v6}, Landroid/net/Uri$OpaqueUri;-><init>(Ljava/lang/String;Landroid/net/Uri$Part;Landroid/net/Uri$Part;Landroid/net/Uri$1;)V

    .line 1529
    :goto_1c
    return-object v0

    .line 1518
    :cond_1d
    iget-object v3, p0, Landroid/net/Uri$Builder;->path:Landroid/net/Uri$PathPart;

    .line 1519
    .local v3, path:Landroid/net/Uri$PathPart;
    if-eqz v3, :cond_25

    sget-object v0, Landroid/net/Uri$PathPart;->NULL:Landroid/net/Uri$PathPart;

    if-ne v3, v0, :cond_35

    .line 1520
    :cond_25
    sget-object v3, Landroid/net/Uri$PathPart;->EMPTY:Landroid/net/Uri$PathPart;

    .line 1529
    :cond_27
    :goto_27
    new-instance v0, Landroid/net/Uri$HierarchicalUri;

    iget-object v1, p0, Landroid/net/Uri$Builder;->scheme:Ljava/lang/String;

    iget-object v2, p0, Landroid/net/Uri$Builder;->authority:Landroid/net/Uri$Part;

    iget-object v4, p0, Landroid/net/Uri$Builder;->query:Landroid/net/Uri$Part;

    iget-object v5, p0, Landroid/net/Uri$Builder;->fragment:Landroid/net/Uri$Part;

    invoke-direct/range {v0 .. v6}, Landroid/net/Uri$HierarchicalUri;-><init>(Ljava/lang/String;Landroid/net/Uri$Part;Landroid/net/Uri$PathPart;Landroid/net/Uri$Part;Landroid/net/Uri$Part;Landroid/net/Uri$1;)V

    goto :goto_1c

    .line 1524
    :cond_35
    invoke-direct {p0}, Landroid/net/Uri$Builder;->hasSchemeOrAuthority()Z

    move-result v0

    if-eqz v0, :cond_27

    .line 1525
    invoke-static {v3}, Landroid/net/Uri$PathPart;->makeAbsolute(Landroid/net/Uri$PathPart;)Landroid/net/Uri$PathPart;

    move-result-object v3

    goto :goto_27
.end method

.method public clearQuery()Landroid/net/Uri$Builder;
    .registers 2

    .prologue
    .line 1499
    const/4 v0, 0x0

    check-cast v0, Landroid/net/Uri$Part;

    invoke-virtual {p0, v0}, Landroid/net/Uri$Builder;->query(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method public encodedAuthority(Ljava/lang/String;)Landroid/net/Uri$Builder;
    .registers 3
    .parameter "authority"

    .prologue
    .line 1377
    invoke-static {p1}, Landroid/net/Uri$Part;->fromEncoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/net/Uri$Builder;->authority(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method public encodedFragment(Ljava/lang/String;)Landroid/net/Uri$Builder;
    .registers 3
    .parameter "fragment"

    .prologue
    .line 1463
    invoke-static {p1}, Landroid/net/Uri$Part;->fromEncoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/net/Uri$Builder;->fragment(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method public encodedOpaquePart(Ljava/lang/String;)Landroid/net/Uri$Builder;
    .registers 3
    .parameter "opaquePart"

    .prologue
    .line 1355
    invoke-static {p1}, Landroid/net/Uri$Part;->fromEncoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/net/Uri$Builder;->opaquePart(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method public encodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;
    .registers 3
    .parameter "path"

    .prologue
    .line 1408
    invoke-static {p1}, Landroid/net/Uri$PathPart;->fromEncoded(Ljava/lang/String;)Landroid/net/Uri$PathPart;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/net/Uri$Builder;->path(Landroid/net/Uri$PathPart;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method public encodedQuery(Ljava/lang/String;)Landroid/net/Uri$Builder;
    .registers 3
    .parameter "query"

    .prologue
    .line 1444
    invoke-static {p1}, Landroid/net/Uri$Part;->fromEncoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/net/Uri$Builder;->query(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method fragment(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;
    .registers 2
    .parameter "fragment"

    .prologue
    .line 1448
    iput-object p1, p0, Landroid/net/Uri$Builder;->fragment:Landroid/net/Uri$Part;

    .line 1449
    return-object p0
.end method

.method public fragment(Ljava/lang/String;)Landroid/net/Uri$Builder;
    .registers 3
    .parameter "fragment"

    .prologue
    .line 1456
    invoke-static {p1}, Landroid/net/Uri$Part;->fromDecoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/net/Uri$Builder;->fragment(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method opaquePart(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;
    .registers 2
    .parameter "opaquePart"

    .prologue
    .line 1336
    iput-object p1, p0, Landroid/net/Uri$Builder;->opaquePart:Landroid/net/Uri$Part;

    .line 1337
    return-object p0
.end method

.method public opaquePart(Ljava/lang/String;)Landroid/net/Uri$Builder;
    .registers 3
    .parameter "opaquePart"

    .prologue
    .line 1346
    invoke-static {p1}, Landroid/net/Uri$Part;->fromDecoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/net/Uri$Builder;->opaquePart(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method path(Landroid/net/Uri$PathPart;)Landroid/net/Uri$Builder;
    .registers 3
    .parameter "path"

    .prologue
    .line 1382
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/net/Uri$Builder;->opaquePart:Landroid/net/Uri$Part;

    .line 1384
    iput-object p1, p0, Landroid/net/Uri$Builder;->path:Landroid/net/Uri$PathPart;

    .line 1385
    return-object p0
.end method

.method public path(Ljava/lang/String;)Landroid/net/Uri$Builder;
    .registers 3
    .parameter "path"

    .prologue
    .line 1397
    invoke-static {p1}, Landroid/net/Uri$PathPart;->fromDecoded(Ljava/lang/String;)Landroid/net/Uri$PathPart;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/net/Uri$Builder;->path(Landroid/net/Uri$PathPart;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method query(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;
    .registers 3
    .parameter "query"

    .prologue
    .line 1427
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/net/Uri$Builder;->opaquePart:Landroid/net/Uri$Part;

    .line 1429
    iput-object p1, p0, Landroid/net/Uri$Builder;->query:Landroid/net/Uri$Part;

    .line 1430
    return-object p0
.end method

.method public query(Ljava/lang/String;)Landroid/net/Uri$Builder;
    .registers 3
    .parameter "query"

    .prologue
    .line 1437
    invoke-static {p1}, Landroid/net/Uri$Part;->fromDecoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/net/Uri$Builder;->query(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method public scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;
    .registers 2
    .parameter "scheme"

    .prologue
    .line 1331
    iput-object p1, p0, Landroid/net/Uri$Builder;->scheme:Ljava/lang/String;

    .line 1332
    return-object p0
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1542
    invoke-virtual {p0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
