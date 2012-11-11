.class public Lmiui/view/ExtraWindowManager$LayoutParams;
.super Landroid/view/WindowManager$LayoutParams;
.source "ExtraWindowManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/view/ExtraWindowManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LayoutParams"
.end annotation


# static fields
.field public static final PRIVATE_FLAG_LOCKSCREEN_DISPALY_DESKTOP:I = 0x40000000

.field public static final PRIVATE_FLAG_TRANSPARENT_STATUS_BAR:I = -0x80000000


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/view/WindowManager$LayoutParams;-><init>()V

    return-void
.end method
