.class final Landroid/widget/NumberPicker$1;
.super Ljava/lang/Object;
.source "NumberPicker.java"

# interfaces
.implements Landroid/widget/NumberPicker$Formatter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/NumberPicker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final mArgs:[Ljava/lang/Object;

.field final mBuilder:Ljava/lang/StringBuilder;

.field final mFmt:Ljava/util/Formatter;


# direct methods
.method constructor <init>()V
    .registers 4

    .prologue
    .line 160
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 161
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v0, p0, Landroid/widget/NumberPicker$1;->mBuilder:Ljava/lang/StringBuilder;

    .line 163
    new-instance v0, Ljava/util/Formatter;

    iget-object v1, p0, Landroid/widget/NumberPicker$1;->mBuilder:Ljava/lang/StringBuilder;

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v1, v2}, Ljava/util/Formatter;-><init>(Ljava/lang/Appendable;Ljava/util/Locale;)V

    iput-object v0, p0, Landroid/widget/NumberPicker$1;->mFmt:Ljava/util/Formatter;

    .line 165
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Landroid/widget/NumberPicker$1;->mArgs:[Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public format(I)Ljava/lang/String;
    .registers 5
    .parameter "value"

    .prologue
    const/4 v2, 0x0

    .line 168
    iget-object v0, p0, Landroid/widget/NumberPicker$1;->mArgs:[Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v2

    .line 169
    iget-object v0, p0, Landroid/widget/NumberPicker$1;->mBuilder:Ljava/lang/StringBuilder;

    iget-object v1, p0, Landroid/widget/NumberPicker$1;->mBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v1

    invoke-virtual {v0, v2, v1}, Ljava/lang/StringBuilder;->delete(II)Ljava/lang/StringBuilder;

    .line 170
    iget-object v0, p0, Landroid/widget/NumberPicker$1;->mFmt:Ljava/util/Formatter;

    const-string v1, "%02d"

    iget-object v2, p0, Landroid/widget/NumberPicker$1;->mArgs:[Ljava/lang/Object;

    invoke-virtual {v0, v1, v2}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    .line 171
    iget-object v0, p0, Landroid/widget/NumberPicker$1;->mFmt:Ljava/util/Formatter;

    invoke-virtual {v0}, Ljava/util/Formatter;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
