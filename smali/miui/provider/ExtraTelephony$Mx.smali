.class public final Lmiui/provider/ExtraTelephony$Mx;
.super Ljava/lang/Object;
.source "ExtraTelephony.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/ExtraTelephony;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Mx"
.end annotation


# static fields
.field public static final TYPE_COMMON:I = 0x0

.field public static final TYPE_DELIVERED:I = 0x11

.field public static final TYPE_INCOMING:I = 0x10001

.field public static final TYPE_PENDING:I = 0x1

.field public static final TYPE_READ:I = 0x100

.field public static final TYPE_SENT:I = 0x10


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 320
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
