.class public Lmiui/provider/ExtraMediaStore$Audio;
.super Ljava/lang/Object;
.source "ExtraMediaStore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/ExtraMediaStore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Audio"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/provider/ExtraMediaStore$Audio$Albums;,
        Lmiui/provider/ExtraMediaStore$Audio$Artists;,
        Lmiui/provider/ExtraMediaStore$Audio$Media;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
