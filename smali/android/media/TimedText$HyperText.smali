.class public final Landroid/media/TimedText$HyperText;
.super Ljava/lang/Object;
.source "TimedText.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/TimedText;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "HyperText"
.end annotation


# instance fields
.field public final URL:Ljava/lang/String;

.field public final altString:Ljava/lang/String;

.field public final endChar:I

.field public final startChar:I


# direct methods
.method public constructor <init>(IILjava/lang/String;Ljava/lang/String;)V
    .registers 5
    .parameter "startChar"
    .parameter "endChar"
    .parameter "url"
    .parameter "alt"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroid/media/TimedText$HyperText;->startChar:I

    iput p2, p0, Landroid/media/TimedText$HyperText;->endChar:I

    iput-object p3, p0, Landroid/media/TimedText$HyperText;->URL:Ljava/lang/String;

    iput-object p4, p0, Landroid/media/TimedText$HyperText;->altString:Ljava/lang/String;

    return-void
.end method
