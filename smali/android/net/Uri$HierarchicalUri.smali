.class Landroid/net/Uri$HierarchicalUri;
.super Landroid/net/Uri$AbstractHierarchicalUri;
.source "Uri.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/Uri;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "HierarchicalUri"
.end annotation


# static fields
.field static final TYPE_ID:I = 0x3


# instance fields
.field private final authority:Landroid/net/Uri$Part;

.field private final fragment:Landroid/net/Uri$Part;

.field private final path:Landroid/net/Uri$PathPart;

.field private final query:Landroid/net/Uri$Part;

.field private final scheme:Ljava/lang/String;

.field private ssp:Landroid/net/Uri$Part;

.field private volatile uriString:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;Landroid/net/Uri$Part;Landroid/net/Uri$PathPart;Landroid/net/Uri$Part;Landroid/net/Uri$Part;)V
    .registers 7
    .parameter "scheme"
    .parameter "authority"
    .parameter "path"
    .parameter "query"
    .parameter "fragment"

    .prologue
    .line 1139
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/net/Uri$AbstractHierarchicalUri;-><init>(Landroid/net/Uri$1;)V

    .line 1259
    invoke-static {}, Landroid/net/Uri;->access$300()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/net/Uri$HierarchicalUri;->uriString:Ljava/lang/String;

    .line 1140
    iput-object p1, p0, Landroid/net/Uri$HierarchicalUri;->scheme:Ljava/lang/String;

    .line 1141
    invoke-static {p2}, Landroid/net/Uri$Part;->nonNull(Landroid/net/Uri$Part;)Landroid/net/Uri$Part;

    move-result-object v0

    iput-object v0, p0, Landroid/net/Uri$HierarchicalUri;->authority:Landroid/net/Uri$Part;

    .line 1142
    if-nez p3, :cond_16

    sget-object p3, Landroid/net/Uri$PathPart;->NULL:Landroid/net/Uri$PathPart;

    .end local p3
    :cond_16
    iput-object p3, p0, Landroid/net/Uri$HierarchicalUri;->path:Landroid/net/Uri$PathPart;

    .line 1143
    invoke-static {p4}, Landroid/net/Uri$Part;->nonNull(Landroid/net/Uri$Part;)Landroid/net/Uri$Part;

    move-result-object v0

    iput-object v0, p0, Landroid/net/Uri$HierarchicalUri;->query:Landroid/net/Uri$Part;

    .line 1144
    invoke-static {p5}, Landroid/net/Uri$Part;->nonNull(Landroid/net/Uri$Part;)Landroid/net/Uri$Part;

    move-result-object v0

    iput-object v0, p0, Landroid/net/Uri$HierarchicalUri;->fragment:Landroid/net/Uri$Part;

    .line 1145
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;Landroid/net/Uri$Part;Landroid/net/Uri$PathPart;Landroid/net/Uri$Part;Landroid/net/Uri$Part;Landroid/net/Uri$1;)V
    .registers 7
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"
    .parameter "x4"
    .parameter "x5"

    .prologue
    .line 1127
    invoke-direct/range {p0 .. p5}, Landroid/net/Uri$HierarchicalUri;-><init>(Ljava/lang/String;Landroid/net/Uri$Part;Landroid/net/Uri$PathPart;Landroid/net/Uri$Part;Landroid/net/Uri$Part;)V

    return-void
.end method

.method private appendSspTo(Ljava/lang/StringBuilder;)V
    .registers 6
    .parameter "builder"

    .prologue
    .line 1207
    iget-object v2, p0, Landroid/net/Uri$HierarchicalUri;->authority:Landroid/net/Uri$Part;

    invoke-virtual {v2}, Landroid/net/Uri$Part;->getEncoded()Ljava/lang/String;

    move-result-object v0

    .line 1208
    .local v0, encodedAuthority:Ljava/lang/String;
    if-eqz v0, :cond_11

    .line 1210
    const-string v2, "//"

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1213
    :cond_11
    iget-object v2, p0, Landroid/net/Uri$HierarchicalUri;->path:Landroid/net/Uri$PathPart;

    invoke-virtual {v2}, Landroid/net/Uri$PathPart;->getEncoded()Ljava/lang/String;

    move-result-object v1

    .line 1214
    .local v1, encodedPath:Ljava/lang/String;
    if-eqz v1, :cond_1c

    .line 1215
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1218
    :cond_1c
    iget-object v2, p0, Landroid/net/Uri$HierarchicalUri;->query:Landroid/net/Uri$Part;

    invoke-virtual {v2}, Landroid/net/Uri$Part;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_33

    .line 1219
    const/16 v2, 0x3f

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Landroid/net/Uri$HierarchicalUri;->query:Landroid/net/Uri$Part;

    invoke-virtual {v3}, Landroid/net/Uri$Part;->getEncoded()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1221
    :cond_33
    return-void
.end method

.method private getSsp()Landroid/net/Uri$Part;
    .registers 2

    .prologue
    .line 1185
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->ssp:Landroid/net/Uri$Part;

    if-nez v0, :cond_f

    invoke-direct {p0}, Landroid/net/Uri$HierarchicalUri;->makeSchemeSpecificPart()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri$Part;->fromEncoded(Ljava/lang/String;)Landroid/net/Uri$Part;

    move-result-object v0

    iput-object v0, p0, Landroid/net/Uri$HierarchicalUri;->ssp:Landroid/net/Uri$Part;

    :goto_e
    return-object v0

    :cond_f
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->ssp:Landroid/net/Uri$Part;

    goto :goto_e
.end method

.method private makeSchemeSpecificPart()Ljava/lang/String;
    .registers 3

    .prologue
    .line 1201
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 1202
    .local v0, builder:Ljava/lang/StringBuilder;
    invoke-direct {p0, v0}, Landroid/net/Uri$HierarchicalUri;->appendSspTo(Ljava/lang/StringBuilder;)V

    .line 1203
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private makeUriString()Ljava/lang/String;
    .registers 4

    .prologue
    .line 1270
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 1272
    .local v0, builder:Ljava/lang/StringBuilder;
    iget-object v1, p0, Landroid/net/Uri$HierarchicalUri;->scheme:Ljava/lang/String;

    if-eqz v1, :cond_14

    .line 1273
    iget-object v1, p0, Landroid/net/Uri$HierarchicalUri;->scheme:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0x3a

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1276
    :cond_14
    invoke-direct {p0, v0}, Landroid/net/Uri$HierarchicalUri;->appendSspTo(Ljava/lang/StringBuilder;)V

    .line 1278
    iget-object v1, p0, Landroid/net/Uri$HierarchicalUri;->fragment:Landroid/net/Uri$Part;

    invoke-virtual {v1}, Landroid/net/Uri$Part;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2e

    .line 1279
    const/16 v1, 0x23

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/net/Uri$HierarchicalUri;->fragment:Landroid/net/Uri$Part;

    invoke-virtual {v2}, Landroid/net/Uri$Part;->getEncoded()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1282
    :cond_2e
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method static readFrom(Landroid/os/Parcel;)Landroid/net/Uri;
    .registers 7
    .parameter "parcel"

    .prologue
    .line 1148
    new-instance v0, Landroid/net/Uri$HierarchicalUri;

    invoke-virtual {p0}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p0}, Landroid/net/Uri$Part;->readFrom(Landroid/os/Parcel;)Landroid/net/Uri$Part;

    move-result-object v2

    invoke-static {p0}, Landroid/net/Uri$PathPart;->readFrom(Landroid/os/Parcel;)Landroid/net/Uri$PathPart;

    move-result-object v3

    invoke-static {p0}, Landroid/net/Uri$Part;->readFrom(Landroid/os/Parcel;)Landroid/net/Uri$Part;

    move-result-object v4

    invoke-static {p0}, Landroid/net/Uri$Part;->readFrom(Landroid/os/Parcel;)Landroid/net/Uri$Part;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Landroid/net/Uri$HierarchicalUri;-><init>(Ljava/lang/String;Landroid/net/Uri$Part;Landroid/net/Uri$PathPart;Landroid/net/Uri$Part;Landroid/net/Uri$Part;)V

    return-object v0
.end method


# virtual methods
.method public buildUpon()Landroid/net/Uri$Builder;
    .registers 3

    .prologue
    .line 1286
    new-instance v0, Landroid/net/Uri$Builder;

    invoke-direct {v0}, Landroid/net/Uri$Builder;-><init>()V

    iget-object v1, p0, Landroid/net/Uri$HierarchicalUri;->scheme:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    iget-object v1, p0, Landroid/net/Uri$HierarchicalUri;->authority:Landroid/net/Uri$Part;

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->authority(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    iget-object v1, p0, Landroid/net/Uri$HierarchicalUri;->path:Landroid/net/Uri$PathPart;

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->path(Landroid/net/Uri$PathPart;)Landroid/net/Uri$Builder;

    move-result-object v0

    iget-object v1, p0, Landroid/net/Uri$HierarchicalUri;->query:Landroid/net/Uri$Part;

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->query(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    iget-object v1, p0, Landroid/net/Uri$HierarchicalUri;->fragment:Landroid/net/Uri$Part;

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->fragment(Landroid/net/Uri$Part;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method public describeContents()I
    .registers 2

    .prologue
    .line 1158
    const/4 v0, 0x0

    return v0
.end method

.method public getAuthority()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1224
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->authority:Landroid/net/Uri$Part;

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getDecoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getEncodedAuthority()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1228
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->authority:Landroid/net/Uri$Part;

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getEncoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getEncodedFragment()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1252
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->fragment:Landroid/net/Uri$Part;

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getEncoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getEncodedPath()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1232
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->path:Landroid/net/Uri$PathPart;

    invoke-virtual {v0}, Landroid/net/Uri$PathPart;->getEncoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getEncodedQuery()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1244
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->query:Landroid/net/Uri$Part;

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getEncoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getEncodedSchemeSpecificPart()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1190
    invoke-direct {p0}, Landroid/net/Uri$HierarchicalUri;->getSsp()Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getEncoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getFragment()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1248
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->fragment:Landroid/net/Uri$Part;

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getDecoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPath()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1236
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->path:Landroid/net/Uri$PathPart;

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
    .line 1256
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->path:Landroid/net/Uri$PathPart;

    invoke-virtual {v0}, Landroid/net/Uri$PathPart;->getPathSegments()Landroid/net/Uri$PathSegments;

    move-result-object v0

    return-object v0
.end method

.method public getQuery()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1240
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->query:Landroid/net/Uri$Part;

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getDecoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getScheme()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1179
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->scheme:Ljava/lang/String;

    return-object v0
.end method

.method public getSchemeSpecificPart()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1194
    invoke-direct {p0}, Landroid/net/Uri$HierarchicalUri;->getSsp()Landroid/net/Uri$Part;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Part;->getDecoded()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isHierarchical()Z
    .registers 2

    .prologue
    .line 1171
    const/4 v0, 0x1

    return v0
.end method

.method public isRelative()Z
    .registers 2

    .prologue
    .line 1175
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->scheme:Ljava/lang/String;

    if-nez v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    .line 1264
    iget-object v1, p0, Landroid/net/Uri$HierarchicalUri;->uriString:Ljava/lang/String;

    invoke-static {}, Landroid/net/Uri;->access$300()Ljava/lang/String;

    move-result-object v2

    if-eq v1, v2, :cond_e

    const/4 v0, 0x1

    .line 1265
    .local v0, cached:Z
    :goto_9
    if-eqz v0, :cond_10

    iget-object v1, p0, Landroid/net/Uri$HierarchicalUri;->uriString:Ljava/lang/String;

    :goto_d
    return-object v1

    .line 1264
    .end local v0           #cached:Z
    :cond_e
    const/4 v0, 0x0

    goto :goto_9

    .line 1265
    .restart local v0       #cached:Z
    :cond_10
    invoke-direct {p0}, Landroid/net/Uri$HierarchicalUri;->makeUriString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/net/Uri$HierarchicalUri;->uriString:Ljava/lang/String;

    goto :goto_d
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "parcel"
    .parameter "flags"

    .prologue
    .line 1162
    const/4 v0, 0x3

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 1163
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->scheme:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 1164
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->authority:Landroid/net/Uri$Part;

    invoke-virtual {v0, p1}, Landroid/net/Uri$Part;->writeTo(Landroid/os/Parcel;)V

    .line 1165
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->path:Landroid/net/Uri$PathPart;

    invoke-virtual {v0, p1}, Landroid/net/Uri$PathPart;->writeTo(Landroid/os/Parcel;)V

    .line 1166
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->query:Landroid/net/Uri$Part;

    invoke-virtual {v0, p1}, Landroid/net/Uri$Part;->writeTo(Landroid/os/Parcel;)V

    .line 1167
    iget-object v0, p0, Landroid/net/Uri$HierarchicalUri;->fragment:Landroid/net/Uri$Part;

    invoke-virtual {v0, p1}, Landroid/net/Uri$Part;->writeTo(Landroid/os/Parcel;)V

    .line 1168
    return-void
.end method
