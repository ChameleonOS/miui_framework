.class final Landroid/content/res/StringBlock$StyleIDs;
.super Ljava/lang/Object;
.source "StringBlock.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/res/StringBlock;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "StyleIDs"
.end annotation


# instance fields
.field private bigId:I

.field private boldId:I

.field private italicId:I

.field private listItemId:I

.field private marqueeId:I

.field private smallId:I

.field private strikeId:I

.field private subId:I

.field private supId:I

.field private ttId:I

.field private underlineId:I


# direct methods
.method constructor <init>()V
    .registers 2

    .prologue
    const/4 v0, -0x1

    .line 147
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 148
    iput v0, p0, Landroid/content/res/StringBlock$StyleIDs;->boldId:I

    .line 149
    iput v0, p0, Landroid/content/res/StringBlock$StyleIDs;->italicId:I

    .line 150
    iput v0, p0, Landroid/content/res/StringBlock$StyleIDs;->underlineId:I

    .line 151
    iput v0, p0, Landroid/content/res/StringBlock$StyleIDs;->ttId:I

    .line 152
    iput v0, p0, Landroid/content/res/StringBlock$StyleIDs;->bigId:I

    .line 153
    iput v0, p0, Landroid/content/res/StringBlock$StyleIDs;->smallId:I

    .line 154
    iput v0, p0, Landroid/content/res/StringBlock$StyleIDs;->subId:I

    .line 155
    iput v0, p0, Landroid/content/res/StringBlock$StyleIDs;->supId:I

    .line 156
    iput v0, p0, Landroid/content/res/StringBlock$StyleIDs;->strikeId:I

    .line 157
    iput v0, p0, Landroid/content/res/StringBlock$StyleIDs;->listItemId:I

    .line 158
    iput v0, p0, Landroid/content/res/StringBlock$StyleIDs;->marqueeId:I

    return-void
.end method

.method static synthetic access$000(Landroid/content/res/StringBlock$StyleIDs;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 147
    iget v0, p0, Landroid/content/res/StringBlock$StyleIDs;->boldId:I

    return v0
.end method

.method static synthetic access$002(Landroid/content/res/StringBlock$StyleIDs;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 147
    iput p1, p0, Landroid/content/res/StringBlock$StyleIDs;->boldId:I

    return p1
.end method

.method static synthetic access$100(Landroid/content/res/StringBlock$StyleIDs;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 147
    iget v0, p0, Landroid/content/res/StringBlock$StyleIDs;->italicId:I

    return v0
.end method

.method static synthetic access$1000(Landroid/content/res/StringBlock$StyleIDs;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 147
    iget v0, p0, Landroid/content/res/StringBlock$StyleIDs;->marqueeId:I

    return v0
.end method

.method static synthetic access$1002(Landroid/content/res/StringBlock$StyleIDs;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 147
    iput p1, p0, Landroid/content/res/StringBlock$StyleIDs;->marqueeId:I

    return p1
.end method

.method static synthetic access$102(Landroid/content/res/StringBlock$StyleIDs;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 147
    iput p1, p0, Landroid/content/res/StringBlock$StyleIDs;->italicId:I

    return p1
.end method

.method static synthetic access$200(Landroid/content/res/StringBlock$StyleIDs;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 147
    iget v0, p0, Landroid/content/res/StringBlock$StyleIDs;->underlineId:I

    return v0
.end method

.method static synthetic access$202(Landroid/content/res/StringBlock$StyleIDs;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 147
    iput p1, p0, Landroid/content/res/StringBlock$StyleIDs;->underlineId:I

    return p1
.end method

.method static synthetic access$300(Landroid/content/res/StringBlock$StyleIDs;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 147
    iget v0, p0, Landroid/content/res/StringBlock$StyleIDs;->ttId:I

    return v0
.end method

.method static synthetic access$302(Landroid/content/res/StringBlock$StyleIDs;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 147
    iput p1, p0, Landroid/content/res/StringBlock$StyleIDs;->ttId:I

    return p1
.end method

.method static synthetic access$400(Landroid/content/res/StringBlock$StyleIDs;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 147
    iget v0, p0, Landroid/content/res/StringBlock$StyleIDs;->bigId:I

    return v0
.end method

.method static synthetic access$402(Landroid/content/res/StringBlock$StyleIDs;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 147
    iput p1, p0, Landroid/content/res/StringBlock$StyleIDs;->bigId:I

    return p1
.end method

.method static synthetic access$500(Landroid/content/res/StringBlock$StyleIDs;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 147
    iget v0, p0, Landroid/content/res/StringBlock$StyleIDs;->smallId:I

    return v0
.end method

.method static synthetic access$502(Landroid/content/res/StringBlock$StyleIDs;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 147
    iput p1, p0, Landroid/content/res/StringBlock$StyleIDs;->smallId:I

    return p1
.end method

.method static synthetic access$600(Landroid/content/res/StringBlock$StyleIDs;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 147
    iget v0, p0, Landroid/content/res/StringBlock$StyleIDs;->subId:I

    return v0
.end method

.method static synthetic access$602(Landroid/content/res/StringBlock$StyleIDs;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 147
    iput p1, p0, Landroid/content/res/StringBlock$StyleIDs;->subId:I

    return p1
.end method

.method static synthetic access$700(Landroid/content/res/StringBlock$StyleIDs;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 147
    iget v0, p0, Landroid/content/res/StringBlock$StyleIDs;->supId:I

    return v0
.end method

.method static synthetic access$702(Landroid/content/res/StringBlock$StyleIDs;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 147
    iput p1, p0, Landroid/content/res/StringBlock$StyleIDs;->supId:I

    return p1
.end method

.method static synthetic access$800(Landroid/content/res/StringBlock$StyleIDs;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 147
    iget v0, p0, Landroid/content/res/StringBlock$StyleIDs;->strikeId:I

    return v0
.end method

.method static synthetic access$802(Landroid/content/res/StringBlock$StyleIDs;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 147
    iput p1, p0, Landroid/content/res/StringBlock$StyleIDs;->strikeId:I

    return p1
.end method

.method static synthetic access$900(Landroid/content/res/StringBlock$StyleIDs;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 147
    iget v0, p0, Landroid/content/res/StringBlock$StyleIDs;->listItemId:I

    return v0
.end method

.method static synthetic access$902(Landroid/content/res/StringBlock$StyleIDs;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 147
    iput p1, p0, Landroid/content/res/StringBlock$StyleIDs;->listItemId:I

    return p1
.end method
