.class public Landroid/service/textservice/SpellCheckerService$SentenceLevelAdapter$SentenceWordItem;
.super Ljava/lang/Object;
.source "SpellCheckerService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/service/textservice/SpellCheckerService$SentenceLevelAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SentenceWordItem"
.end annotation


# instance fields
.field public final mLength:I

.field public final mStart:I

.field public final mTextInfo:Landroid/view/textservice/TextInfo;


# direct methods
.method public constructor <init>(Landroid/view/textservice/TextInfo;II)V
    .registers 5
    .parameter "ti"
    .parameter "start"
    .parameter "end"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/service/textservice/SpellCheckerService$SentenceLevelAdapter$SentenceWordItem;->mTextInfo:Landroid/view/textservice/TextInfo;

    iput p2, p0, Landroid/service/textservice/SpellCheckerService$SentenceLevelAdapter$SentenceWordItem;->mStart:I

    sub-int v0, p3, p2

    iput v0, p0, Landroid/service/textservice/SpellCheckerService$SentenceLevelAdapter$SentenceWordItem;->mLength:I

    return-void
.end method
