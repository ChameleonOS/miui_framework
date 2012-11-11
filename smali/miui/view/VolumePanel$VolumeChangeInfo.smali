.class Lmiui/view/VolumePanel$VolumeChangeInfo;
.super Ljava/lang/Object;
.source "VolumePanel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/view/VolumePanel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "VolumeChangeInfo"
.end annotation


# instance fields
.field public final mFromVolume:I

.field public final mToVolume:I


# direct methods
.method public constructor <init>(II)V
    .registers 3
    .parameter "from"
    .parameter "to"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lmiui/view/VolumePanel$VolumeChangeInfo;->mFromVolume:I

    iput p2, p0, Lmiui/view/VolumePanel$VolumeChangeInfo;->mToVolume:I

    return-void
.end method
