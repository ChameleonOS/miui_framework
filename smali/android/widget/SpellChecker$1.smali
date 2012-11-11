.class Landroid/widget/SpellChecker$1;
.super Ljava/lang/Object;
.source "SpellChecker.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/SpellChecker;->scheduleNewSpellCheck()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/SpellChecker;


# direct methods
.method constructor <init>(Landroid/widget/SpellChecker;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/widget/SpellChecker$1;->this$0:Landroid/widget/SpellChecker;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 5

    .prologue
    iget-object v3, p0, Landroid/widget/SpellChecker$1;->this$0:Landroid/widget/SpellChecker;

    #getter for: Landroid/widget/SpellChecker;->mSpellParsers:[Landroid/widget/SpellChecker$SpellParser;
    invoke-static {v3}, Landroid/widget/SpellChecker;->access$100(Landroid/widget/SpellChecker;)[Landroid/widget/SpellChecker$SpellParser;

    move-result-object v3

    array-length v1, v3

    .local v1, length:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_8
    if-ge v0, v1, :cond_1b

    iget-object v3, p0, Landroid/widget/SpellChecker$1;->this$0:Landroid/widget/SpellChecker;

    #getter for: Landroid/widget/SpellChecker;->mSpellParsers:[Landroid/widget/SpellChecker$SpellParser;
    invoke-static {v3}, Landroid/widget/SpellChecker;->access$100(Landroid/widget/SpellChecker;)[Landroid/widget/SpellChecker$SpellParser;

    move-result-object v3

    aget-object v2, v3, v0

    .local v2, spellParser:Landroid/widget/SpellChecker$SpellParser;
    invoke-virtual {v2}, Landroid/widget/SpellChecker$SpellParser;->isFinished()Z

    move-result v3

    if-nez v3, :cond_1c

    invoke-virtual {v2}, Landroid/widget/SpellChecker$SpellParser;->parse()V

    .end local v2           #spellParser:Landroid/widget/SpellChecker$SpellParser;
    :cond_1b
    return-void

    .restart local v2       #spellParser:Landroid/widget/SpellChecker$SpellParser;
    :cond_1c
    add-int/lit8 v0, v0, 0x1

    goto :goto_8
.end method
