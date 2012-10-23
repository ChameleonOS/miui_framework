.class public Landroid/preference/MiuiVolumePreference$VolumeStore;
.super Ljava/lang/Object;
.source "MiuiVolumePreference.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/preference/MiuiVolumePreference;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "VolumeStore"
.end annotation


# instance fields
.field public originalVolume:I

.field public volume:I


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    const/4 v0, -0x1

    .line 179
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 180
    iput v0, p0, Landroid/preference/MiuiVolumePreference$VolumeStore;->volume:I

    .line 181
    iput v0, p0, Landroid/preference/MiuiVolumePreference$VolumeStore;->originalVolume:I

    return-void
.end method
