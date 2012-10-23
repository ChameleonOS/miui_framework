.class public final Lmiui/provider/ExtraDownloads$Impl;
.super Ljava/lang/Object;
.source "ExtraDownloads.java"

# interfaces
.implements Landroid/provider/BaseColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/ExtraDownloads;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Impl"
.end annotation


# static fields
.field public static final COLUMN_APPOINT_NAME:Ljava/lang/String; = "appointname"

.field public static final COLUMN_IF_RANGE_ID:Ljava/lang/String; = "if_range_id"

.field public static final COLUMN_SUB_DIRECTORY:Ljava/lang/String; = "subdirectory"

.field public static final CONTROL_PAUSED_WITHOUT_WIFI:I = 0x2


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 6
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
