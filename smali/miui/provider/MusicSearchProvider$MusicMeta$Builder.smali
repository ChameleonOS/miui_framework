.class public Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;
.super Ljava/lang/Object;
.source "MusicSearchProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/MusicSearchProvider$MusicMeta;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field public mAlbumName:Ljava/lang/String;

.field public mArtistName:Ljava/lang/String;

.field public mData:Ljava/lang/String;

.field public mDuartion:J

.field public mFlag:I

.field public mLocalId:J

.field public mOnlineId:Ljava/lang/String;

.field public mTitle:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mLocalId:J

    iput-object v2, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mOnlineId:Ljava/lang/String;

    iput-object v2, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mTitle:Ljava/lang/String;

    iput-object v2, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mData:Ljava/lang/String;

    iput-object v2, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mArtistName:Ljava/lang/String;

    iput-object v2, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mAlbumName:Ljava/lang/String;

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mDuartion:J

    const/4 v0, 0x0

    iput v0, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mFlag:I

    return-void
.end method


# virtual methods
.method public create()Lmiui/provider/MusicSearchProvider$MusicMeta;
    .registers 12

    .prologue
    new-instance v0, Lmiui/provider/MusicSearchProvider$MusicMeta;

    iget-wide v1, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mLocalId:J

    iget-object v3, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mOnlineId:Ljava/lang/String;

    iget-object v4, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mTitle:Ljava/lang/String;

    iget-object v5, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mData:Ljava/lang/String;

    iget-object v6, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mArtistName:Ljava/lang/String;

    iget-object v7, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mAlbumName:Ljava/lang/String;

    iget-wide v8, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mDuartion:J

    iget v10, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mFlag:I

    invoke-direct/range {v0 .. v10}, Lmiui/provider/MusicSearchProvider$MusicMeta;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)V

    return-object v0
.end method

.method public setAlbumName(Ljava/lang/String;)Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;
    .registers 2
    .parameter "albumName"

    .prologue
    iput-object p1, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mAlbumName:Ljava/lang/String;

    return-object p0
.end method

.method public setArtistName(Ljava/lang/String;)Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;
    .registers 2
    .parameter "artistName"

    .prologue
    iput-object p1, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mArtistName:Ljava/lang/String;

    return-object p0
.end method

.method public setData(Ljava/lang/String;)Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;
    .registers 2
    .parameter "data"

    .prologue
    iput-object p1, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mData:Ljava/lang/String;

    return-object p0
.end method

.method public setDuration(J)Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;
    .registers 3
    .parameter "duration"

    .prologue
    iput-wide p1, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mDuartion:J

    return-object p0
.end method

.method public setFlag(I)Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;
    .registers 2
    .parameter "flag"

    .prologue
    iput p1, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mFlag:I

    return-object p0
.end method

.method public setLocalId(J)Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;
    .registers 3
    .parameter "localId"

    .prologue
    iput-wide p1, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mLocalId:J

    return-object p0
.end method

.method public setOnlineId(Ljava/lang/String;)Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;
    .registers 2
    .parameter "onlineId"

    .prologue
    iput-object p1, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mOnlineId:Ljava/lang/String;

    return-object p0
.end method

.method public setTitle(Ljava/lang/String;)Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;
    .registers 2
    .parameter "title"

    .prologue
    iput-object p1, p0, Lmiui/provider/MusicSearchProvider$MusicMeta$Builder;->mTitle:Ljava/lang/String;

    return-object p0
.end method
