.class public final Landroid/media/TimedText$Karaoke;
.super Ljava/lang/Object;
.source "TimedText.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/TimedText;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Karaoke"
.end annotation


# instance fields
.field public final endChar:I

.field public final endTimeMs:I

.field public final startChar:I

.field public final startTimeMs:I


# direct methods
.method public constructor <init>(IIII)V
    .registers 5
    .parameter "startTimeMs"
    .parameter "endTimeMs"
    .parameter "startChar"
    .parameter "endChar"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroid/media/TimedText$Karaoke;->startTimeMs:I

    iput p2, p0, Landroid/media/TimedText$Karaoke;->endTimeMs:I

    iput p3, p0, Landroid/media/TimedText$Karaoke;->startChar:I

    iput p4, p0, Landroid/media/TimedText$Karaoke;->endChar:I

    return-void
.end method
