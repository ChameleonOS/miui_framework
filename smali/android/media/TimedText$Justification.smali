.class public final Landroid/media/TimedText$Justification;
.super Ljava/lang/Object;
.source "TimedText.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/TimedText;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Justification"
.end annotation


# instance fields
.field public final horizontalJustification:I

.field public final verticalJustification:I


# direct methods
.method public constructor <init>(II)V
    .registers 3
    .parameter "horizontal"
    .parameter "vertical"

    .prologue
    .line 160
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 161
    iput p1, p0, Landroid/media/TimedText$Justification;->horizontalJustification:I

    .line 162
    iput p2, p0, Landroid/media/TimedText$Justification;->verticalJustification:I

    .line 163
    return-void
.end method
