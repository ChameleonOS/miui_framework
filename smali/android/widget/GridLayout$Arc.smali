.class final Landroid/widget/GridLayout$Arc;
.super Ljava/lang/Object;
.source "GridLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/GridLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "Arc"
.end annotation


# instance fields
.field public final span:Landroid/widget/GridLayout$Interval;

.field public valid:Z

.field public final value:Landroid/widget/GridLayout$MutableInt;


# direct methods
.method public constructor <init>(Landroid/widget/GridLayout$Interval;Landroid/widget/GridLayout$MutableInt;)V
    .registers 4
    .parameter "span"
    .parameter "value"

    .prologue
    .line 2043
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 2041
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/widget/GridLayout$Arc;->valid:Z

    .line 2044
    iput-object p1, p0, Landroid/widget/GridLayout$Arc;->span:Landroid/widget/GridLayout$Interval;

    .line 2045
    iput-object p2, p0, Landroid/widget/GridLayout$Arc;->value:Landroid/widget/GridLayout$MutableInt;

    .line 2046
    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    .line 2050
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Landroid/widget/GridLayout$Arc;->span:Landroid/widget/GridLayout$Interval;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v0, p0, Landroid/widget/GridLayout$Arc;->valid:Z

    if-nez v0, :cond_2c

    const-string v0, "+>"

    :goto_17
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/widget/GridLayout$Arc;->value:Landroid/widget/GridLayout$MutableInt;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_2c
    const-string v0, "->"

    goto :goto_17
.end method
