.class Landroid/net/Uri$StringUri;
.super Landroid/net/Uri$AbstractHierarchicalUri;
.source "Uri.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/Uri;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "StringUri"
.end annotation


# static fields
.field static final TYPE_ID:I = 0x1


# instance fields
.field private authority:Landroid/net/Uri$Part;

.field private volatile cachedFsi:I

.field private volatile cachedSsi:I

.field private fragment:Landroid/net/Uri$Part;

.field private path:Landroid/net/Uri$PathPart;

.field private query:Landroid/net/Uri$Part;

.field private volatile scheme:Ljava/lang/String;

.field private ssp:Landroid/net/Uri$Part;

.field private final uriString:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;)V
    .registers 4
    .parameter "uriString"

    .prologue
    const/4 v1, -0x2

    .line 462
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/net/Uri$AbstractHierarchicalUri;-><init>(Landroid/net/Uri$1;)V

    .line 484
    iput v1, p0, Landroid/net/Uri$StringUri;->cachedSsi:I

    .line 494
    iput v1, p0, Landroid/net/Uri$StringUri;->cachedFsi:I

    .line 525
    invoke-static {}, Landroid/net/Uri;->access$300()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/net/Uri$StringUri;->scheme:Ljava/lang/String;

    .line 463
    if-nez p1, :cond_1a

    .line 464
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "uriString"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 467
    :cond_1a
    iput-object p1, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    .line 468
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;Landroid/net/Uri$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 454
    invoke-direct {p0, p1}, Landroid/net/Uri$StringUri;-><init>(Ljava/lang/String;)V

    return-void
.end method

.method private findFragmentSeparator()I
    .registers 4

    .prologue
    .line 498
    iget v0, p0, Landroid/net/Uri$StringUri;->cachedFsi:I

    const/4 v1, -0x2

    if-ne v0, v1, :cond_14

    iget-object v0, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    const/16 v1, 0x23

    invoke-direct {p0}, Landroid/net/Uri$StringUri;->findSchemeSeparator()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->indexOf(II)I

    move-result v0

    iput v0, p0, Landroid/net/Uri$StringUri;->cachedFsi:I

    :goto_13
    return v0

    :cond_14
    iget v0, p0, Landroid/net/Uri$StringUri;->cachedFsi:I

    goto :goto_13
.end method

.method private findSchemeSeparator()I
    .registers 3

    .prologue
    .line 488
    iget v0, p0, Landroid/net/Uri$StringUri;->cachedSsi:I

    const/4 v1, -0x2

    if-ne v0, v1, :cond_10

    iget-object v0, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    const/16 v1, 0x3a

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    iput v0, p0, Landroid/net/Uri$StringUri;->cachedSsi:I

    :goto_f
    return v0

    :cond_10
    iget v0, p0, Landroid/net/Uri$StringUri;->cachedSsi:I

    goto :goto_f
.end method

.method private getAuthorityPart()Landroid/net/Uri$Part;
    .registers 4

    .prologue
    .line 565
    iget-object v1, p0, Landroid/net/Uri$StringUri;->authority:Landroid/net/Uri$Part;

    if-nez v1, :cond_15

    .line 566
    iget-object v1, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    invoke-direct {p0}, Landroid/net/Uri$StringUri;->findSchemeSeparator()I

    move-result v2

    invoke-static {v1, v2}, Landroid/net/Uri$StringUri;->parseAuthority(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    .line 568
    .local v0, encodedAuthority:Ljava/lang/String;
    invoke-static {v0}, Landroid/net/Uri$Part;->fromEncoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v1

    iput-object v1, p0, Landroid/net/Uri$StringUri;->authority:Landroid/net/Uri$Part;

    .line 571
    .end local v0           #encodedAuthority:Ljava/lang/String;
    :goto_14
    return-object v1

    :cond_15
    iget-object v1, p0, Landroid/net/Uri$StringUri;->authority:Landroid/net/Uri$Part;

    goto :goto_14
.end method

.method private getFragmentPart()Landroid/net/Uri$Part;
    .registers 2

    .prologue
    .line 667
    iget-object v0, p0, Landroid/net/Uri$StringUri;->fragment:Landroid/net/Uri$Part;

    if-nez v0, :cond_f

    invoke-direct {p0}, Landroid/net/Uri$StringUri;->parseFragment()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri$Part;->fromEncoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v0

    iput-object v0, p0, Landroid/net/Uri$StringUri;->fragment:Landroid/net/Uri$Part;

    :goto_e
    return-object v0

    :cond_f
    iget-object v0, p0, Landroid/net/Uri$StringUri;->fragment:Landroid/net/Uri$Part;

    goto :goto_e
.end method

.method private getPathPart()Landroid/net/Uri$PathPart;
    .registers 2

    .prologue
    .line 585
    iget-object v0, p0, Landroid/net/Uri$StringUri;->path:Landroid/net/Uri$PathPart;

    if-nez v0, :cond_f

    invoke-direct {p0}, Landroid/net/Uri$StringUri;->parsePath()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri$PathPart;->fromEncoded(Ljava/lang/String;)Landroid/net/Uri$PathPart;

    move-result-object v0

    iput-object v0, p0, Landroid/net/Uri$StringUri;->path:Landroid/net/Uri$PathPart;

    :goto_e
    return-object v0

    :cond_f
    iget-object v0, p0, Landroid/net/Uri$StringUri;->path:Landroid/net/Uri$PathPart;

    goto :goto_e
.end method

.method private getQueryPart()Landroid/net/Uri$Part;
    .registers 2

    .prologue
    .line 630
    iget-object v0, p0, Landroid/net/Uri$StringUri;->query:Landroid/net/Uri$Part;

    if-nez v0, :cond_f

    invoke-direct {p0}, Landroid/net/Uri$StringUri;->parseQuery()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri$Part;->fromEncoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v0

    iput-object v0, p0, Landroid/net/Uri$StringUri;->query:Landroid/net/Uri$Part;

    :goto_e
    return-object v0

    :cond_f
    iget-object v0, p0, Landroid/net/Uri$StringUri;->query:Landroid/net/Uri$Part;

    goto :goto_e
.end method

.method private getSsp()Landroid/net/Uri$Part;
    .registers 2

    .prologue
    .line 541
    iget-object v0, p0, Landroid/net/Uri$StringUri;->ssp:Landroid/net/Uri$Part;

    if-nez v0, :cond_f

    invoke-direct {p0}, Landroid/net/Uri$StringUri;->parseSsp()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri$Part;->fromEncoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v0

    iput-object v0, p0, Landroid/net/Uri$StringUri;->ssp:Landroid/net/Uri$Part;

    :goto_e
    return-object v0

    :cond_f
    iget-object v0, p0, Landroid/net/Uri$StringUri;->ssp:Landroid/net/Uri$Part;

    goto :goto_e
.end method

.method static parseAuthority(Ljava/lang/String;I)Ljava/lang/String;
    .registers 6
    .parameter "uriString"
    .parameter "ssi"

    .prologue
    const/16 v3, 0x2f

    .line 697
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    .line 700
    .local v1, length:I
    add-int/lit8 v2, p1, 0x2

    if-le v1, v2, :cond_2f

    add-int/lit8 v2, p1, 0x1

    invoke-virtual {p0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    if-ne v2, v3, :cond_2f

    add-int/lit8 v2, p1, 0x2

    invoke-virtual {p0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    if-ne v2, v3, :cond_2f

    .line 707
    add-int/lit8 v0, p1, 0x3

    .line 708
    .local v0, end:I
    :goto_1c
    if-ge v0, v1, :cond_28

    .line 709
    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    sparse-switch v2, :sswitch_data_32

    .line 715
    add-int/lit8 v0, v0, 0x1

    goto :goto_1c

    .line 718
    :cond_28
    :sswitch_28
    add-int/lit8 v2, p1, 0x3

    invoke-virtual {p0, v2, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 720
    .end local v0           #end:I
    :goto_2e
    return-object v2

    :cond_2f
    const/4 v2, 0x0

    goto :goto_2e

    .line 709
    nop

    :sswitch_data_32
    .sparse-switch
        0x23 -> :sswitch_28
        0x2f -> :sswitch_28
        0x3f -> :sswitch_28
    .end sparse-switch
.end method

.method private parseFragment()Ljava/lang/String;
    .registers 4

    .prologue
    .line 676
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->findFragmentSeparator()I

    move-result v0

    .line 677
    .local v0, fsi:I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_9

    const/4 v1, 0x0

    :goto_8
    return-object v1

    :cond_9
    iget-object v1, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    add-int/lit8 v2, v0, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_8
.end method

.method private parsePath()Ljava/lang/String;
    .registers 7

    .prologue
    const/4 v3, 0x0

    .line 603
    iget-object v2, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    .line 604
    .local v2, uriString:Ljava/lang/String;
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->findSchemeSeparator()I

    move-result v1

    .line 607
    .local v1, ssi:I
    const/4 v4, -0x1

    if-le v1, v4, :cond_22

    .line 609
    add-int/lit8 v4, v1, 0x1

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    if-ne v4, v5, :cond_16

    const/4 v0, 0x1

    .line 610
    .local v0, schemeOnly:Z
    :goto_13
    if-eqz v0, :cond_18

    .line 624
    .end local v0           #schemeOnly:Z
    :cond_15
    :goto_15
    return-object v3

    .line 609
    :cond_16
    const/4 v0, 0x0

    goto :goto_13

    .line 616
    .restart local v0       #schemeOnly:Z
    :cond_18
    add-int/lit8 v4, v1, 0x1

    invoke-virtual {v2, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0x2f

    if-ne v4, v5, :cond_15

    .line 624
    .end local v0           #schemeOnly:Z
    :cond_22
    invoke-static {v2, v1}, Landroid/net/Uri$StringUri;->parsePath(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v3

    goto :goto_15
.end method

.method static parsePath(Ljava/lang/String;I)Ljava/lang/String;
    .registers 7
    .parameter "uriString"
    .parameter "ssi"

    .prologue
    const/16 v4, 0x2f

    .line 734
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    .line 738
    .local v0, length:I
    add-int/lit8 v3, p1, 0x2

    if-le v0, v3, :cond_2b

    add-int/lit8 v3, p1, 0x1

    invoke-virtual {p0, v3}, Ljava/lang/String;->charAt(I)C

    move-result v3

    if-ne v3, v4, :cond_2b

    add-int/lit8 v3, p1, 0x2

    invoke-virtual {p0, v3}, Ljava/lang/String;->charAt(I)C

    move-result v3

    if-ne v3, v4, :cond_2b

    .line 742
    add-int/lit8 v2, p1, 0x3

    .line 743
    .local v2, pathStart:I
    :goto_1c
    if-ge v2, v0, :cond_2d

    .line 744
    invoke-virtual {p0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v3

    sparse-switch v3, :sswitch_data_40

    .line 751
    add-int/lit8 v2, v2, 0x1

    goto :goto_1c

    .line 747
    :sswitch_28
    const-string v3, ""

    .line 769
    :goto_2a
    return-object v3

    .line 755
    .end local v2           #pathStart:I
    :cond_2b
    add-int/lit8 v2, p1, 0x1

    .line 759
    .restart local v2       #pathStart:I
    :cond_2d
    :sswitch_2d
    move v1, v2

    .line 760
    .local v1, pathEnd:I
    :goto_2e
    if-ge v1, v0, :cond_3a

    .line 761
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v3

    sparse-switch v3, :sswitch_data_4e

    .line 766
    add-int/lit8 v1, v1, 0x1

    goto :goto_2e

    .line 769
    :cond_3a
    :sswitch_3a
    invoke-virtual {p0, v2, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    goto :goto_2a

    .line 744
    nop

    :sswitch_data_40
    .sparse-switch
        0x23 -> :sswitch_28
        0x2f -> :sswitch_2d
        0x3f -> :sswitch_28
    .end sparse-switch

    .line 761
    :sswitch_data_4e
    .sparse-switch
        0x23 -> :sswitch_3a
        0x3f -> :sswitch_3a
    .end sparse-switch
.end method

.method private parseQuery()Ljava/lang/String;
    .registers 8

    .prologue
    const/4 v2, 0x0

    const/4 v6, -0x1

    .line 641
    iget-object v3, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    const/16 v4, 0x3f

    invoke-direct {p0}, Landroid/net/Uri$StringUri;->findSchemeSeparator()I

    move-result v5

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->indexOf(II)I

    move-result v1

    .line 642
    .local v1, qsi:I
    if-ne v1, v6, :cond_11

    .line 657
    :cond_10
    :goto_10
    return-object v2

    .line 646
    :cond_11
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->findFragmentSeparator()I

    move-result v0

    .line 648
    .local v0, fsi:I
    if-ne v0, v6, :cond_20

    .line 649
    iget-object v2, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    add-int/lit8 v3, v1, 0x1

    invoke-virtual {v2, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_10

    .line 652
    :cond_20
    if-lt v0, v1, :cond_10

    .line 657
    iget-object v2, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    add-int/lit8 v3, v1, 0x1

    invoke-virtual {v2, v3, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    goto :goto_10
.end method

.method private parseScheme()Ljava/lang/String;
    .registers 4

    .prologue
    .line 534
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->findSchemeSeparator()I

    move-result v0

    .line 535
    .local v0, ssi:I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_9

    const/4 v1, 0x0

    :goto_8
    return-object v1

    :cond_9
    iget-object v1, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    const/4 v2, 0x0

    invoke-virtual {v1, v2, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    goto :goto_8
.end method

.method private parseSsp()Ljava/lang/String;
    .registers 5

    .prologue
    .line 553
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->findSchemeSeparator()I

    move-result v1

    .line 554
    .local v1, ssi:I
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->findFragmentSeparator()I

    move-result v0

    .line 557
    .local v0, fsi:I
    const/4 v2, -0x1

    if-ne v0, v2, :cond_14

    iget-object v2, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    add-int/lit8 v3, v1, 0x1

    invoke-virtual {v2, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    :goto_13
    return-object v2

    :cond_14
    iget-object v2, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    add-int/lit8 v3, v1, 0x1

    invoke-virtual {v2, v3, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    goto :goto_13
.end method

.method static readFrom(Landroid/os/Parcel;)Landroid/net/Uri;
    .registers 3
    .parameter "parcel"

    .prologue
    .line 471
    new-instance v0, Landroid/net/Uri$StringUri;

    invoke-virtual {p0}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/net/Uri$StringUri;-><init>(Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public buildUpon()Landroid/net/Uri$Builder;
    .registers 3

    .prologue
    .line 773
    invoke-virtual {p0}, Landroid/net/Uri$StringUri;->isHierarchical()Z

    move-result v0

    if-eqz v0, :cond_34

    .line 774
    new-instance v0, Landroid/net/Uri$Builder;

    invoke-direct {v0}, Landroid/net/Uri$Builder;-><init>()V

    invoke-virtual {p0}, Landroid/net/Uri$StringUri;->getScheme()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getAuthorityPart()Landroid/net/Uri$Part;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->authority(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getPathPart()Landroid/net/Uri$PathPart;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->path(Landroid/net/Uri$PathPart;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getQueryPart()Landroid/net/Uri$Part;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->query(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getFragmentPart()Landroid/net/Uri$Part;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->fragment(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    .line 781
    :goto_33
    return-object v0

    :cond_34
    new-instance v0, Landroid/net/Uri$Builder;

    invoke-direct {v0}, Landroid/net/Uri$Builder;-><init>()V

    invoke-virtual {p0}, Landroid/net/Uri$StringUri;->getScheme()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getSsp()Landroid/net/Uri$Part;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->opaquePart(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getFragmentPart()Landroid/net/Uri$Part;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->fragment(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    goto :goto_33
.end method

.method public describeContents()I
    .registers 2

    .prologue
    .line 475
    const/4 v0, 0x0

    return v0
.end method

.method public getAuthority()Ljava/lang/String;
    .registers 2

    .prologue
    .line 579
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getAuthorityPart()Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getDecoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getEncodedAuthority()Ljava/lang/String;
    .registers 2

    .prologue
    .line 575
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getAuthorityPart()Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getEncoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getEncodedFragment()Ljava/lang/String;
    .registers 2

    .prologue
    .line 672
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getFragmentPart()Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getEncoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getEncodedPath()Ljava/lang/String;
    .registers 2

    .prologue
    .line 595
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getPathPart()Landroid/net/Uri$PathPart;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$PathPart;->getEncoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getEncodedQuery()Ljava/lang/String;
    .registers 2

    .prologue
    .line 635
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getQueryPart()Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getEncoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getEncodedSchemeSpecificPart()Ljava/lang/String;
    .registers 2

    .prologue
    .line 545
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getSsp()Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getEncoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getFragment()Ljava/lang/String;
    .registers 2

    .prologue
    .line 681
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getFragmentPart()Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getDecoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPath()Ljava/lang/String;
    .registers 2

    .prologue
    .line 591
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getPathPart()Landroid/net/Uri$PathPart;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$PathPart;->getDecoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPathSegments()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 599
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getPathPart()Landroid/net/Uri$PathPart;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$PathPart;->getPathSegments()Landroid/net/Uri$PathSegments;

    move-result-object v0

    return-object v0
.end method

.method public getQuery()Ljava/lang/String;
    .registers 2

    .prologue
    .line 661
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getQueryPart()Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getDecoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getScheme()Ljava/lang/String;
    .registers 4

    .prologue
    .line 529
    iget-object v1, p0, Landroid/net/Uri$StringUri;->scheme:Ljava/lang/String;

    invoke-static {}, Landroid/net/Uri;->access$300()Ljava/lang/String;

    move-result-object v2

    if-eq v1, v2, :cond_e

    const/4 v0, 0x1

    .line 530
    .local v0, cached:Z
    :goto_9
    if-eqz v0, :cond_10

    iget-object v1, p0, Landroid/net/Uri$StringUri;->scheme:Ljava/lang/String;

    :goto_d
    return-object v1

    .line 529
    .end local v0           #cached:Z
    :cond_e
    const/4 v0, 0x0

    goto :goto_9

    .line 530
    .restart local v0       #cached:Z
    :cond_10
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->parseScheme()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/net/Uri$StringUri;->scheme:Ljava/lang/String;

    goto :goto_d
.end method

.method public getSchemeSpecificPart()Ljava/lang/String;
    .registers 2

    .prologue
    .line 549
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->getSsp()Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getDecoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isHierarchical()Z
    .registers 6

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 504
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->findSchemeSeparator()I

    move-result v0

    .line 506
    .local v0, ssi:I
    const/4 v3, -0x1

    if-ne v0, v3, :cond_a

    .line 517
    :cond_9
    :goto_9
    return v1

    .line 511
    :cond_a
    iget-object v3, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v4, v0, 0x1

    if-ne v3, v4, :cond_16

    move v1, v2

    .line 513
    goto :goto_9

    .line 517
    :cond_16
    iget-object v3, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    add-int/lit8 v4, v0, 0x1

    invoke-virtual {v3, v4}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/16 v4, 0x2f

    if-eq v3, v4, :cond_9

    move v1, v2

    goto :goto_9
.end method

.method public isRelative()Z
    .registers 3

    .prologue
    .line 522
    invoke-direct {p0}, Landroid/net/Uri$StringUri;->findSchemeSeparator()I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_9

    const/4 v0, 0x1

    :goto_8
    return v0

    :cond_9
    const/4 v0, 0x0

    goto :goto_8
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    .prologue
    .line 685
    iget-object v0, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "parcel"
    .parameter "flags"

    .prologue
    .line 479
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 480
    iget-object v0, p0, Landroid/net/Uri$StringUri;->uriString:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 481
    return-void
.end method
