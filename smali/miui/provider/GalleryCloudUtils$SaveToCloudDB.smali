.class public Lmiui/provider/GalleryCloudUtils$SaveToCloudDB;
.super Ljava/lang/Object;
.source "GalleryCloudUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/GalleryCloudUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SaveToCloudDB"
.end annotation


# instance fields
.field public dateTaken:J

.field public fileName:Ljava/lang/String;

.field public groupId:I

.field public height:I

.field public localFlag:I

.field public location:Landroid/location/Location;

.field public mimeType:Ljava/lang/String;

.field public orientation:I

.field public path:Ljava/lang/String;

.field public serverType:I

.field public size:J

.field public title:Ljava/lang/String;

.field public width:I


# direct methods
.method public constructor <init>(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIILandroid/location/Location;III)V
    .registers 16
    .parameter "path"
    .parameter "size"
    .parameter "mimeType"
    .parameter "title"
    .parameter "fileName"
    .parameter "dateTaken"
    .parameter "width"
    .parameter "height"
    .parameter "orientation"
    .parameter "location"
    .parameter "groupId"
    .parameter "serverType"
    .parameter "localFlag"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmiui/provider/GalleryCloudUtils$SaveToCloudDB;->path:Ljava/lang/String;

    iput-wide p2, p0, Lmiui/provider/GalleryCloudUtils$SaveToCloudDB;->size:J

    iput-object p4, p0, Lmiui/provider/GalleryCloudUtils$SaveToCloudDB;->mimeType:Ljava/lang/String;

    iput-object p5, p0, Lmiui/provider/GalleryCloudUtils$SaveToCloudDB;->title:Ljava/lang/String;

    iput-object p6, p0, Lmiui/provider/GalleryCloudUtils$SaveToCloudDB;->fileName:Ljava/lang/String;

    iput-wide p7, p0, Lmiui/provider/GalleryCloudUtils$SaveToCloudDB;->dateTaken:J

    iput p9, p0, Lmiui/provider/GalleryCloudUtils$SaveToCloudDB;->width:I

    iput p10, p0, Lmiui/provider/GalleryCloudUtils$SaveToCloudDB;->height:I

    iput p11, p0, Lmiui/provider/GalleryCloudUtils$SaveToCloudDB;->orientation:I

    iput-object p12, p0, Lmiui/provider/GalleryCloudUtils$SaveToCloudDB;->location:Landroid/location/Location;

    iput p13, p0, Lmiui/provider/GalleryCloudUtils$SaveToCloudDB;->groupId:I

    iput p14, p0, Lmiui/provider/GalleryCloudUtils$SaveToCloudDB;->serverType:I

    iput p15, p0, Lmiui/provider/GalleryCloudUtils$SaveToCloudDB;->localFlag:I

    return-void
.end method
