.class Landroid/text/HtmlToSpannedConverter;
.super Ljava/lang/Object;
.source "Html.java"

# interfaces
.implements Lorg/xml/sax/ContentHandler;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/text/HtmlToSpannedConverter$1;,
        Landroid/text/HtmlToSpannedConverter$Header;,
        Landroid/text/HtmlToSpannedConverter$Href;,
        Landroid/text/HtmlToSpannedConverter$Font;,
        Landroid/text/HtmlToSpannedConverter$Sub;,
        Landroid/text/HtmlToSpannedConverter$Super;,
        Landroid/text/HtmlToSpannedConverter$Blockquote;,
        Landroid/text/HtmlToSpannedConverter$Monospace;,
        Landroid/text/HtmlToSpannedConverter$Small;,
        Landroid/text/HtmlToSpannedConverter$Big;,
        Landroid/text/HtmlToSpannedConverter$Underline;,
        Landroid/text/HtmlToSpannedConverter$Italic;,
        Landroid/text/HtmlToSpannedConverter$Bold;
    }
.end annotation


# static fields
.field private static COLORS:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static final HEADER_SIZES:[F


# instance fields
.field private mImageGetter:Landroid/text/Html$ImageGetter;

.field private mReader:Lorg/xml/sax/XMLReader;

.field private mSource:Ljava/lang/String;

.field private mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

.field private mTagHandler:Landroid/text/Html$TagHandler;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 411
    const/4 v0, 0x6

    new-array v0, v0, [F

    fill-array-data v0, :array_10

    sput-object v0, Landroid/text/HtmlToSpannedConverter;->HEADER_SIZES:[F

    .line 846
    invoke-static {}, Landroid/text/HtmlToSpannedConverter;->buildColorMap()Ljava/util/HashMap;

    move-result-object v0

    sput-object v0, Landroid/text/HtmlToSpannedConverter;->COLORS:Ljava/util/HashMap;

    return-void

    .line 411
    nop

    :array_10
    .array-data 0x4
        0x0t 0x0t 0xc0t 0x3ft
        0x33t 0x33t 0xb3t 0x3ft
        0x66t 0x66t 0xa6t 0x3ft
        0x9at 0x99t 0x99t 0x3ft
        0xcdt 0xcct 0x8ct 0x3ft
        0x0t 0x0t 0x80t 0x3ft
    .end array-data
.end method

.method public constructor <init>(Ljava/lang/String;Landroid/text/Html$ImageGetter;Landroid/text/Html$TagHandler;Lorg/ccil/cowan/tagsoup/Parser;)V
    .registers 6
    .parameter "source"
    .parameter "imageGetter"
    .parameter "tagHandler"
    .parameter "parser"

    .prologue
    .line 423
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 424
    iput-object p1, p0, Landroid/text/HtmlToSpannedConverter;->mSource:Ljava/lang/String;

    .line 425
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0}, Landroid/text/SpannableStringBuilder;-><init>()V

    iput-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    .line 426
    iput-object p2, p0, Landroid/text/HtmlToSpannedConverter;->mImageGetter:Landroid/text/Html$ImageGetter;

    .line 427
    iput-object p3, p0, Landroid/text/HtmlToSpannedConverter;->mTagHandler:Landroid/text/Html$TagHandler;

    .line 428
    iput-object p4, p0, Landroid/text/HtmlToSpannedConverter;->mReader:Lorg/xml/sax/XMLReader;

    .line 429
    return-void
.end method

.method private static buildColorMap()Ljava/util/HashMap;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 849
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 850
    .local v0, map:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Integer;>;"
    const-string v1, "aqua"

    const v2, 0xffff

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 851
    const-string v1, "black"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 852
    const-string v1, "blue"

    const/16 v2, 0xff

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 853
    const-string v1, "fuchsia"

    const v2, 0xff00ff

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 854
    const-string v1, "green"

    const v2, 0x8000

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 855
    const-string v1, "grey"

    const v2, 0x808080

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 856
    const-string/jumbo v1, "lime"

    const v2, 0xff00

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 857
    const-string/jumbo v1, "maroon"

    const/high16 v2, 0x80

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 858
    const-string/jumbo v1, "navy"

    const/16 v2, 0x80

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 859
    const-string/jumbo v1, "olive"

    const v2, 0x808000

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 860
    const-string/jumbo v1, "purple"

    const v2, 0x800080

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 861
    const-string/jumbo v1, "red"

    const/high16 v2, 0xff

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 862
    const-string/jumbo v1, "silver"

    const v2, 0xc0c0c0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 863
    const-string/jumbo v1, "teal"

    const v2, 0x8080

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 864
    const-string/jumbo v1, "white"

    const v2, 0xffffff

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 865
    const-string/jumbo v1, "yellow"

    const v2, 0xffff00

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 866
    return-object v0
.end method

.method private static end(Landroid/text/SpannableStringBuilder;Ljava/lang/Class;Ljava/lang/Object;)V
    .registers 7
    .parameter "text"
    .parameter "kind"
    .parameter "repl"

    .prologue
    .line 610
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v0

    .line 611
    .local v0, len:I
    invoke-static {p0, p1}, Landroid/text/HtmlToSpannedConverter;->getLast(Landroid/text/Spanned;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    .line 612
    .local v1, obj:Ljava/lang/Object;
    invoke-virtual {p0, v1}, Landroid/text/SpannableStringBuilder;->getSpanStart(Ljava/lang/Object;)I

    move-result v2

    .line 614
    .local v2, where:I
    invoke-virtual {p0, v1}, Landroid/text/SpannableStringBuilder;->removeSpan(Ljava/lang/Object;)V

    .line 616
    if-eq v2, v0, :cond_16

    .line 617
    const/16 v3, 0x21

    invoke-virtual {p0, p2, v2, v0, v3}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 620
    :cond_16
    return-void
.end method

.method private static endA(Landroid/text/SpannableStringBuilder;)V
    .registers 7
    .parameter "text"

    .prologue
    .line 700
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v1

    .line 701
    .local v1, len:I
    const-class v4, Landroid/text/HtmlToSpannedConverter$Href;

    invoke-static {p0, v4}, Landroid/text/HtmlToSpannedConverter;->getLast(Landroid/text/Spanned;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    .line 702
    .local v2, obj:Ljava/lang/Object;
    invoke-virtual {p0, v2}, Landroid/text/SpannableStringBuilder;->getSpanStart(Ljava/lang/Object;)I

    move-result v3

    .line 704
    .local v3, where:I
    invoke-virtual {p0, v2}, Landroid/text/SpannableStringBuilder;->removeSpan(Ljava/lang/Object;)V

    .line 706
    if-eq v3, v1, :cond_26

    move-object v0, v2

    .line 707
    check-cast v0, Landroid/text/HtmlToSpannedConverter$Href;

    .line 709
    .local v0, h:Landroid/text/HtmlToSpannedConverter$Href;
    iget-object v4, v0, Landroid/text/HtmlToSpannedConverter$Href;->mHref:Ljava/lang/String;

    if-eqz v4, :cond_26

    .line 710
    new-instance v4, Landroid/text/style/URLSpan;

    iget-object v5, v0, Landroid/text/HtmlToSpannedConverter$Href;->mHref:Ljava/lang/String;

    invoke-direct {v4, v5}, Landroid/text/style/URLSpan;-><init>(Ljava/lang/String;)V

    const/16 v5, 0x21

    invoke-virtual {p0, v4, v3, v1, v5}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 714
    .end local v0           #h:Landroid/text/HtmlToSpannedConverter$Href;
    :cond_26
    return-void
.end method

.method private static endFont(Landroid/text/SpannableStringBuilder;)V
    .registers 16
    .parameter "text"

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x0

    const/16 v14, 0x21

    .line 655
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v9

    .line 656
    .local v9, len:I
    const-class v0, Landroid/text/HtmlToSpannedConverter$Font;

    invoke-static {p0, v0}, Landroid/text/HtmlToSpannedConverter;->getLast(Landroid/text/Spanned;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v11

    .line 657
    .local v11, obj:Ljava/lang/Object;
    invoke-virtual {p0, v11}, Landroid/text/SpannableStringBuilder;->getSpanStart(Ljava/lang/Object;)I

    move-result v13

    .line 659
    .local v13, where:I
    invoke-virtual {p0, v11}, Landroid/text/SpannableStringBuilder;->removeSpan(Ljava/lang/Object;)V

    .line 661
    if-eq v13, v9, :cond_5d

    move-object v8, v11

    .line 662
    check-cast v8, Landroid/text/HtmlToSpannedConverter$Font;

    .line 664
    .local v8, f:Landroid/text/HtmlToSpannedConverter$Font;
    iget-object v0, v8, Landroid/text/HtmlToSpannedConverter$Font;->mColor:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_4f

    .line 665
    iget-object v0, v8, Landroid/text/HtmlToSpannedConverter$Font;->mColor:Ljava/lang/String;

    const-string v3, "@"

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5e

    .line 666
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v12

    .line 667
    .local v12, res:Landroid/content/res/Resources;
    iget-object v0, v8, Landroid/text/HtmlToSpannedConverter$Font;->mColor:Ljava/lang/String;

    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v10

    .line 668
    .local v10, name:Ljava/lang/String;
    const-string v0, "color"

    const-string v3, "android"

    invoke-virtual {v12, v10, v0, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v7

    .line 669
    .local v7, colorRes:I
    if-eqz v7, :cond_4f

    .line 670
    invoke-virtual {v12, v7}, Landroid/content/res/Resources;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v4

    .line 671
    .local v4, colors:Landroid/content/res/ColorStateList;
    new-instance v0, Landroid/text/style/TextAppearanceSpan;

    move v3, v2

    move-object v5, v1

    invoke-direct/range {v0 .. v5}, Landroid/text/style/TextAppearanceSpan;-><init>(Ljava/lang/String;IILandroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;)V

    invoke-virtual {p0, v0, v13, v9, v14}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 685
    .end local v4           #colors:Landroid/content/res/ColorStateList;
    .end local v7           #colorRes:I
    .end local v10           #name:Ljava/lang/String;
    .end local v12           #res:Landroid/content/res/Resources;
    :cond_4f
    :goto_4f
    iget-object v0, v8, Landroid/text/HtmlToSpannedConverter$Font;->mFace:Ljava/lang/String;

    if-eqz v0, :cond_5d

    .line 686
    new-instance v0, Landroid/text/style/TypefaceSpan;

    iget-object v1, v8, Landroid/text/HtmlToSpannedConverter$Font;->mFace:Ljava/lang/String;

    invoke-direct {v0, v1}, Landroid/text/style/TypefaceSpan;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v13, v9, v14}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 690
    .end local v8           #f:Landroid/text/HtmlToSpannedConverter$Font;
    :cond_5d
    return-void

    .line 676
    .restart local v8       #f:Landroid/text/HtmlToSpannedConverter$Font;
    :cond_5e
    iget-object v0, v8, Landroid/text/HtmlToSpannedConverter$Font;->mColor:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/HtmlToSpannedConverter;->getHtmlColor(Ljava/lang/String;)I

    move-result v6

    .line 677
    .local v6, c:I
    const/4 v0, -0x1

    if-eq v6, v0, :cond_4f

    .line 678
    new-instance v0, Landroid/text/style/ForegroundColorSpan;

    const/high16 v1, -0x100

    or-int/2addr v1, v6

    invoke-direct {v0, v1}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {p0, v0, v13, v9, v14}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto :goto_4f
.end method

.method private static endHeader(Landroid/text/SpannableStringBuilder;)V
    .registers 9
    .parameter "text"

    .prologue
    const/16 v7, 0x21

    .line 717
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v1

    .line 718
    .local v1, len:I
    const-class v4, Landroid/text/HtmlToSpannedConverter$Header;

    invoke-static {p0, v4}, Landroid/text/HtmlToSpannedConverter;->getLast(Landroid/text/Spanned;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    .line 720
    .local v2, obj:Ljava/lang/Object;
    invoke-virtual {p0, v2}, Landroid/text/SpannableStringBuilder;->getSpanStart(Ljava/lang/Object;)I

    move-result v3

    .line 722
    .local v3, where:I
    invoke-virtual {p0, v2}, Landroid/text/SpannableStringBuilder;->removeSpan(Ljava/lang/Object;)V

    .line 725
    :goto_13
    if-le v1, v3, :cond_22

    add-int/lit8 v4, v1, -0x1

    invoke-virtual {p0, v4}, Landroid/text/SpannableStringBuilder;->charAt(I)C

    move-result v4

    const/16 v5, 0xa

    if-ne v4, v5, :cond_22

    .line 726
    add-int/lit8 v1, v1, -0x1

    goto :goto_13

    .line 729
    :cond_22
    if-eq v3, v1, :cond_40

    move-object v0, v2

    .line 730
    check-cast v0, Landroid/text/HtmlToSpannedConverter$Header;

    .line 732
    .local v0, h:Landroid/text/HtmlToSpannedConverter$Header;
    new-instance v4, Landroid/text/style/RelativeSizeSpan;

    sget-object v5, Landroid/text/HtmlToSpannedConverter;->HEADER_SIZES:[F

    #getter for: Landroid/text/HtmlToSpannedConverter$Header;->mLevel:I
    invoke-static {v0}, Landroid/text/HtmlToSpannedConverter$Header;->access$900(Landroid/text/HtmlToSpannedConverter$Header;)I

    move-result v6

    aget v5, v5, v6

    invoke-direct {v4, v5}, Landroid/text/style/RelativeSizeSpan;-><init>(F)V

    invoke-virtual {p0, v4, v3, v1, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 734
    new-instance v4, Landroid/text/style/StyleSpan;

    const/4 v5, 0x1

    invoke-direct {v4, v5}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-virtual {p0, v4, v3, v1, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 737
    .end local v0           #h:Landroid/text/HtmlToSpannedConverter$Header;
    :cond_40
    return-void
.end method

.method private static getHtmlColor(Ljava/lang/String;)I
    .registers 6
    .parameter "color"

    .prologue
    const/4 v2, -0x1

    .line 876
    sget-object v3, Landroid/text/HtmlToSpannedConverter;->COLORS:Ljava/util/HashMap;

    invoke-virtual {p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 877
    .local v0, i:Ljava/lang/Integer;
    if-eqz v0, :cond_14

    .line 878
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 883
    :goto_13
    return v2

    .line 881
    :cond_14
    const/4 v3, -0x1

    :try_start_15
    invoke-static {p0, v3}, Lcom/android/internal/util/XmlUtils;->convertValueToInt(Ljava/lang/CharSequence;I)I
    :try_end_18
    .catch Ljava/lang/NumberFormatException; {:try_start_15 .. :try_end_18} :catch_1a

    move-result v2

    goto :goto_13

    .line 882
    :catch_1a
    move-exception v1

    .line 883
    .local v1, nfe:Ljava/lang/NumberFormatException;
    goto :goto_13
.end method

.method private static getLast(Landroid/text/Spanned;Ljava/lang/Class;)Ljava/lang/Object;
    .registers 5
    .parameter "text"
    .parameter "kind"

    .prologue
    .line 594
    const/4 v1, 0x0

    invoke-interface {p0}, Landroid/text/Spanned;->length()I

    move-result v2

    invoke-interface {p0, v1, v2, p1}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    .line 596
    .local v0, objs:[Ljava/lang/Object;
    array-length v1, v0

    if-nez v1, :cond_e

    .line 597
    const/4 v1, 0x0

    .line 599
    :goto_d
    return-object v1

    :cond_e
    array-length v1, v0

    add-int/lit8 v1, v1, -0x1

    aget-object v1, v0, v1

    goto :goto_d
.end method

.method private static handleBr(Landroid/text/SpannableStringBuilder;)V
    .registers 2
    .parameter "text"

    .prologue
    .line 586
    const-string v0, "\n"

    invoke-virtual {p0, v0}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 587
    return-void
.end method

.method private handleEndTag(Ljava/lang/String;)V
    .registers 8
    .parameter "tag"

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x2

    .line 520
    const-string v0, "br"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 521
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-static {v0}, Landroid/text/HtmlToSpannedConverter;->handleBr(Landroid/text/SpannableStringBuilder;)V

    .line 566
    :cond_10
    :goto_10
    return-void

    .line 522
    :cond_11
    const-string/jumbo v0, "p"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_20

    .line 523
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-static {v0}, Landroid/text/HtmlToSpannedConverter;->handleP(Landroid/text/SpannableStringBuilder;)V

    goto :goto_10

    .line 524
    :cond_20
    const-string v0, "div"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2e

    .line 525
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-static {v0}, Landroid/text/HtmlToSpannedConverter;->handleP(Landroid/text/SpannableStringBuilder;)V

    goto :goto_10

    .line 526
    :cond_2e
    const-string/jumbo v0, "strong"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_44

    .line 527
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    const-class v1, Landroid/text/HtmlToSpannedConverter$Bold;

    new-instance v2, Landroid/text/style/StyleSpan;

    invoke-direct {v2, v4}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-static {v0, v1, v2}, Landroid/text/HtmlToSpannedConverter;->end(Landroid/text/SpannableStringBuilder;Ljava/lang/Class;Ljava/lang/Object;)V

    goto :goto_10

    .line 528
    :cond_44
    const-string v0, "b"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_59

    .line 529
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    const-class v1, Landroid/text/HtmlToSpannedConverter$Bold;

    new-instance v2, Landroid/text/style/StyleSpan;

    invoke-direct {v2, v4}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-static {v0, v1, v2}, Landroid/text/HtmlToSpannedConverter;->end(Landroid/text/SpannableStringBuilder;Ljava/lang/Class;Ljava/lang/Object;)V

    goto :goto_10

    .line 530
    :cond_59
    const-string v0, "em"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6e

    .line 531
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    const-class v1, Landroid/text/HtmlToSpannedConverter$Italic;

    new-instance v2, Landroid/text/style/StyleSpan;

    invoke-direct {v2, v3}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-static {v0, v1, v2}, Landroid/text/HtmlToSpannedConverter;->end(Landroid/text/SpannableStringBuilder;Ljava/lang/Class;Ljava/lang/Object;)V

    goto :goto_10

    .line 532
    :cond_6e
    const-string v0, "cite"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_83

    .line 533
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    const-class v1, Landroid/text/HtmlToSpannedConverter$Italic;

    new-instance v2, Landroid/text/style/StyleSpan;

    invoke-direct {v2, v3}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-static {v0, v1, v2}, Landroid/text/HtmlToSpannedConverter;->end(Landroid/text/SpannableStringBuilder;Ljava/lang/Class;Ljava/lang/Object;)V

    goto :goto_10

    .line 534
    :cond_83
    const-string v0, "dfn"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_99

    .line 535
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    const-class v1, Landroid/text/HtmlToSpannedConverter$Italic;

    new-instance v2, Landroid/text/style/StyleSpan;

    invoke-direct {v2, v3}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-static {v0, v1, v2}, Landroid/text/HtmlToSpannedConverter;->end(Landroid/text/SpannableStringBuilder;Ljava/lang/Class;Ljava/lang/Object;)V

    goto/16 :goto_10

    .line 536
    :cond_99
    const-string v0, "i"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_af

    .line 537
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    const-class v1, Landroid/text/HtmlToSpannedConverter$Italic;

    new-instance v2, Landroid/text/style/StyleSpan;

    invoke-direct {v2, v3}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-static {v0, v1, v2}, Landroid/text/HtmlToSpannedConverter;->end(Landroid/text/SpannableStringBuilder;Ljava/lang/Class;Ljava/lang/Object;)V

    goto/16 :goto_10

    .line 538
    :cond_af
    const-string v0, "big"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_c7

    .line 539
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    const-class v1, Landroid/text/HtmlToSpannedConverter$Big;

    new-instance v2, Landroid/text/style/RelativeSizeSpan;

    const/high16 v3, 0x3fa0

    invoke-direct {v2, v3}, Landroid/text/style/RelativeSizeSpan;-><init>(F)V

    invoke-static {v0, v1, v2}, Landroid/text/HtmlToSpannedConverter;->end(Landroid/text/SpannableStringBuilder;Ljava/lang/Class;Ljava/lang/Object;)V

    goto/16 :goto_10

    .line 540
    :cond_c7
    const-string/jumbo v0, "small"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_e1

    .line 541
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    const-class v1, Landroid/text/HtmlToSpannedConverter$Small;

    new-instance v2, Landroid/text/style/RelativeSizeSpan;

    const v3, 0x3f4ccccd

    invoke-direct {v2, v3}, Landroid/text/style/RelativeSizeSpan;-><init>(F)V

    invoke-static {v0, v1, v2}, Landroid/text/HtmlToSpannedConverter;->end(Landroid/text/SpannableStringBuilder;Ljava/lang/Class;Ljava/lang/Object;)V

    goto/16 :goto_10

    .line 542
    :cond_e1
    const-string v0, "font"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_f0

    .line 543
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-static {v0}, Landroid/text/HtmlToSpannedConverter;->endFont(Landroid/text/SpannableStringBuilder;)V

    goto/16 :goto_10

    .line 544
    :cond_f0
    const-string v0, "blockquote"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_10b

    .line 545
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-static {v0}, Landroid/text/HtmlToSpannedConverter;->handleP(Landroid/text/SpannableStringBuilder;)V

    .line 546
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    const-class v1, Landroid/text/HtmlToSpannedConverter$Blockquote;

    new-instance v2, Landroid/text/style/QuoteSpan;

    invoke-direct {v2}, Landroid/text/style/QuoteSpan;-><init>()V

    invoke-static {v0, v1, v2}, Landroid/text/HtmlToSpannedConverter;->end(Landroid/text/SpannableStringBuilder;Ljava/lang/Class;Ljava/lang/Object;)V

    goto/16 :goto_10

    .line 547
    :cond_10b
    const-string/jumbo v0, "tt"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_125

    .line 548
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    const-class v1, Landroid/text/HtmlToSpannedConverter$Monospace;

    new-instance v2, Landroid/text/style/TypefaceSpan;

    const-string/jumbo v3, "monospace"

    invoke-direct {v2, v3}, Landroid/text/style/TypefaceSpan;-><init>(Ljava/lang/String;)V

    invoke-static {v0, v1, v2}, Landroid/text/HtmlToSpannedConverter;->end(Landroid/text/SpannableStringBuilder;Ljava/lang/Class;Ljava/lang/Object;)V

    goto/16 :goto_10

    .line 550
    :cond_125
    const-string v0, "a"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_134

    .line 551
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-static {v0}, Landroid/text/HtmlToSpannedConverter;->endA(Landroid/text/SpannableStringBuilder;)V

    goto/16 :goto_10

    .line 552
    :cond_134
    const-string/jumbo v0, "u"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_14b

    .line 553
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    const-class v1, Landroid/text/HtmlToSpannedConverter$Underline;

    new-instance v2, Landroid/text/style/UnderlineSpan;

    invoke-direct {v2}, Landroid/text/style/UnderlineSpan;-><init>()V

    invoke-static {v0, v1, v2}, Landroid/text/HtmlToSpannedConverter;->end(Landroid/text/SpannableStringBuilder;Ljava/lang/Class;Ljava/lang/Object;)V

    goto/16 :goto_10

    .line 554
    :cond_14b
    const-string/jumbo v0, "sup"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_162

    .line 555
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    const-class v1, Landroid/text/HtmlToSpannedConverter$Super;

    new-instance v2, Landroid/text/style/SuperscriptSpan;

    invoke-direct {v2}, Landroid/text/style/SuperscriptSpan;-><init>()V

    invoke-static {v0, v1, v2}, Landroid/text/HtmlToSpannedConverter;->end(Landroid/text/SpannableStringBuilder;Ljava/lang/Class;Ljava/lang/Object;)V

    goto/16 :goto_10

    .line 556
    :cond_162
    const-string/jumbo v0, "sub"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_179

    .line 557
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    const-class v1, Landroid/text/HtmlToSpannedConverter$Sub;

    new-instance v2, Landroid/text/style/SubscriptSpan;

    invoke-direct {v2}, Landroid/text/style/SubscriptSpan;-><init>()V

    invoke-static {v0, v1, v2}, Landroid/text/HtmlToSpannedConverter;->end(Landroid/text/SpannableStringBuilder;Ljava/lang/Class;Ljava/lang/Object;)V

    goto/16 :goto_10

    .line 558
    :cond_179
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-ne v0, v3, :cond_1a7

    invoke-virtual {p1, v5}, Ljava/lang/String;->charAt(I)C

    move-result v0

    invoke-static {v0}, Ljava/lang/Character;->toLowerCase(C)C

    move-result v0

    const/16 v1, 0x68

    if-ne v0, v1, :cond_1a7

    invoke-virtual {p1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x31

    if-lt v0, v1, :cond_1a7

    invoke-virtual {p1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x36

    if-gt v0, v1, :cond_1a7

    .line 561
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-static {v0}, Landroid/text/HtmlToSpannedConverter;->handleP(Landroid/text/SpannableStringBuilder;)V

    .line 562
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-static {v0}, Landroid/text/HtmlToSpannedConverter;->endHeader(Landroid/text/SpannableStringBuilder;)V

    goto/16 :goto_10

    .line 563
    :cond_1a7
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mTagHandler:Landroid/text/Html$TagHandler;

    if-eqz v0, :cond_10

    .line 564
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mTagHandler:Landroid/text/Html$TagHandler;

    iget-object v1, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    iget-object v2, p0, Landroid/text/HtmlToSpannedConverter;->mReader:Lorg/xml/sax/XMLReader;

    invoke-interface {v0, v5, p1, v1, v2}, Landroid/text/Html$TagHandler;->handleTag(ZLjava/lang/String;Landroid/text/Editable;Lorg/xml/sax/XMLReader;)V

    goto/16 :goto_10
.end method

.method private static handleP(Landroid/text/SpannableStringBuilder;)V
    .registers 4
    .parameter "text"

    .prologue
    const/16 v2, 0xa

    .line 569
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v0

    .line 571
    .local v0, len:I
    const/4 v1, 0x1

    if-lt v0, v1, :cond_23

    add-int/lit8 v1, v0, -0x1

    invoke-virtual {p0, v1}, Landroid/text/SpannableStringBuilder;->charAt(I)C

    move-result v1

    if-ne v1, v2, :cond_23

    .line 572
    const/4 v1, 0x2

    if-lt v0, v1, :cond_1d

    add-int/lit8 v1, v0, -0x2

    invoke-virtual {p0, v1}, Landroid/text/SpannableStringBuilder;->charAt(I)C

    move-result v1

    if-ne v1, v2, :cond_1d

    .line 583
    :cond_1c
    :goto_1c
    return-void

    .line 576
    :cond_1d
    const-string v1, "\n"

    invoke-virtual {p0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_1c

    .line 580
    :cond_23
    if-eqz v0, :cond_1c

    .line 581
    const-string v1, "\n\n"

    invoke-virtual {p0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_1c
.end method

.method private handleStartTag(Ljava/lang/String;Lorg/xml/sax/Attributes;)V
    .registers 7
    .parameter "tag"
    .parameter "attributes"

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 469
    const-string v0, "br"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 517
    :cond_a
    :goto_a
    return-void

    .line 472
    :cond_b
    const-string/jumbo v0, "p"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1a

    .line 473
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-static {v0}, Landroid/text/HtmlToSpannedConverter;->handleP(Landroid/text/SpannableStringBuilder;)V

    goto :goto_a

    .line 474
    :cond_1a
    const-string v0, "div"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_28

    .line 475
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-static {v0}, Landroid/text/HtmlToSpannedConverter;->handleP(Landroid/text/SpannableStringBuilder;)V

    goto :goto_a

    .line 476
    :cond_28
    const-string/jumbo v0, "strong"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3c

    .line 477
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    new-instance v1, Landroid/text/HtmlToSpannedConverter$Bold;

    invoke-direct {v1, v2}, Landroid/text/HtmlToSpannedConverter$Bold;-><init>(Landroid/text/HtmlToSpannedConverter$1;)V

    invoke-static {v0, v1}, Landroid/text/HtmlToSpannedConverter;->start(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V

    goto :goto_a

    .line 478
    :cond_3c
    const-string v0, "b"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4f

    .line 479
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    new-instance v1, Landroid/text/HtmlToSpannedConverter$Bold;

    invoke-direct {v1, v2}, Landroid/text/HtmlToSpannedConverter$Bold;-><init>(Landroid/text/HtmlToSpannedConverter$1;)V

    invoke-static {v0, v1}, Landroid/text/HtmlToSpannedConverter;->start(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V

    goto :goto_a

    .line 480
    :cond_4f
    const-string v0, "em"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_62

    .line 481
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    new-instance v1, Landroid/text/HtmlToSpannedConverter$Italic;

    invoke-direct {v1, v2}, Landroid/text/HtmlToSpannedConverter$Italic;-><init>(Landroid/text/HtmlToSpannedConverter$1;)V

    invoke-static {v0, v1}, Landroid/text/HtmlToSpannedConverter;->start(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V

    goto :goto_a

    .line 482
    :cond_62
    const-string v0, "cite"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_75

    .line 483
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    new-instance v1, Landroid/text/HtmlToSpannedConverter$Italic;

    invoke-direct {v1, v2}, Landroid/text/HtmlToSpannedConverter$Italic;-><init>(Landroid/text/HtmlToSpannedConverter$1;)V

    invoke-static {v0, v1}, Landroid/text/HtmlToSpannedConverter;->start(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V

    goto :goto_a

    .line 484
    :cond_75
    const-string v0, "dfn"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_88

    .line 485
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    new-instance v1, Landroid/text/HtmlToSpannedConverter$Italic;

    invoke-direct {v1, v2}, Landroid/text/HtmlToSpannedConverter$Italic;-><init>(Landroid/text/HtmlToSpannedConverter$1;)V

    invoke-static {v0, v1}, Landroid/text/HtmlToSpannedConverter;->start(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V

    goto :goto_a

    .line 486
    :cond_88
    const-string v0, "i"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9c

    .line 487
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    new-instance v1, Landroid/text/HtmlToSpannedConverter$Italic;

    invoke-direct {v1, v2}, Landroid/text/HtmlToSpannedConverter$Italic;-><init>(Landroid/text/HtmlToSpannedConverter$1;)V

    invoke-static {v0, v1}, Landroid/text/HtmlToSpannedConverter;->start(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V

    goto/16 :goto_a

    .line 488
    :cond_9c
    const-string v0, "big"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_b0

    .line 489
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    new-instance v1, Landroid/text/HtmlToSpannedConverter$Big;

    invoke-direct {v1, v2}, Landroid/text/HtmlToSpannedConverter$Big;-><init>(Landroid/text/HtmlToSpannedConverter$1;)V

    invoke-static {v0, v1}, Landroid/text/HtmlToSpannedConverter;->start(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V

    goto/16 :goto_a

    .line 490
    :cond_b0
    const-string/jumbo v0, "small"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_c5

    .line 491
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    new-instance v1, Landroid/text/HtmlToSpannedConverter$Small;

    invoke-direct {v1, v2}, Landroid/text/HtmlToSpannedConverter$Small;-><init>(Landroid/text/HtmlToSpannedConverter$1;)V

    invoke-static {v0, v1}, Landroid/text/HtmlToSpannedConverter;->start(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V

    goto/16 :goto_a

    .line 492
    :cond_c5
    const-string v0, "font"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_d4

    .line 493
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-static {v0, p2}, Landroid/text/HtmlToSpannedConverter;->startFont(Landroid/text/SpannableStringBuilder;Lorg/xml/sax/Attributes;)V

    goto/16 :goto_a

    .line 494
    :cond_d4
    const-string v0, "blockquote"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_ed

    .line 495
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-static {v0}, Landroid/text/HtmlToSpannedConverter;->handleP(Landroid/text/SpannableStringBuilder;)V

    .line 496
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    new-instance v1, Landroid/text/HtmlToSpannedConverter$Blockquote;

    invoke-direct {v1, v2}, Landroid/text/HtmlToSpannedConverter$Blockquote;-><init>(Landroid/text/HtmlToSpannedConverter$1;)V

    invoke-static {v0, v1}, Landroid/text/HtmlToSpannedConverter;->start(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V

    goto/16 :goto_a

    .line 497
    :cond_ed
    const-string/jumbo v0, "tt"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_102

    .line 498
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    new-instance v1, Landroid/text/HtmlToSpannedConverter$Monospace;

    invoke-direct {v1, v2}, Landroid/text/HtmlToSpannedConverter$Monospace;-><init>(Landroid/text/HtmlToSpannedConverter$1;)V

    invoke-static {v0, v1}, Landroid/text/HtmlToSpannedConverter;->start(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V

    goto/16 :goto_a

    .line 499
    :cond_102
    const-string v0, "a"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_111

    .line 500
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-static {v0, p2}, Landroid/text/HtmlToSpannedConverter;->startA(Landroid/text/SpannableStringBuilder;Lorg/xml/sax/Attributes;)V

    goto/16 :goto_a

    .line 501
    :cond_111
    const-string/jumbo v0, "u"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_126

    .line 502
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    new-instance v1, Landroid/text/HtmlToSpannedConverter$Underline;

    invoke-direct {v1, v2}, Landroid/text/HtmlToSpannedConverter$Underline;-><init>(Landroid/text/HtmlToSpannedConverter$1;)V

    invoke-static {v0, v1}, Landroid/text/HtmlToSpannedConverter;->start(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V

    goto/16 :goto_a

    .line 503
    :cond_126
    const-string/jumbo v0, "sup"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_13b

    .line 504
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    new-instance v1, Landroid/text/HtmlToSpannedConverter$Super;

    invoke-direct {v1, v2}, Landroid/text/HtmlToSpannedConverter$Super;-><init>(Landroid/text/HtmlToSpannedConverter$1;)V

    invoke-static {v0, v1}, Landroid/text/HtmlToSpannedConverter;->start(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V

    goto/16 :goto_a

    .line 505
    :cond_13b
    const-string/jumbo v0, "sub"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_150

    .line 506
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    new-instance v1, Landroid/text/HtmlToSpannedConverter$Sub;

    invoke-direct {v1, v2}, Landroid/text/HtmlToSpannedConverter$Sub;-><init>(Landroid/text/HtmlToSpannedConverter$1;)V

    invoke-static {v0, v1}, Landroid/text/HtmlToSpannedConverter;->start(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V

    goto/16 :goto_a

    .line 507
    :cond_150
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_18b

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    invoke-static {v0}, Ljava/lang/Character;->toLowerCase(C)C

    move-result v0

    const/16 v1, 0x68

    if-ne v0, v1, :cond_18b

    invoke-virtual {p1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x31

    if-lt v0, v1, :cond_18b

    invoke-virtual {p1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x36

    if-gt v0, v1, :cond_18b

    .line 510
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-static {v0}, Landroid/text/HtmlToSpannedConverter;->handleP(Landroid/text/SpannableStringBuilder;)V

    .line 511
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    new-instance v1, Landroid/text/HtmlToSpannedConverter$Header;

    invoke-virtual {p1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v2

    add-int/lit8 v2, v2, -0x31

    invoke-direct {v1, v2}, Landroid/text/HtmlToSpannedConverter$Header;-><init>(I)V

    invoke-static {v0, v1}, Landroid/text/HtmlToSpannedConverter;->start(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V

    goto/16 :goto_a

    .line 512
    :cond_18b
    const-string v0, "img"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_19c

    .line 513
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    iget-object v1, p0, Landroid/text/HtmlToSpannedConverter;->mImageGetter:Landroid/text/Html$ImageGetter;

    invoke-static {v0, p2, v1}, Landroid/text/HtmlToSpannedConverter;->startImg(Landroid/text/SpannableStringBuilder;Lorg/xml/sax/Attributes;Landroid/text/Html$ImageGetter;)V

    goto/16 :goto_a

    .line 514
    :cond_19c
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mTagHandler:Landroid/text/Html$TagHandler;

    if-eqz v0, :cond_a

    .line 515
    iget-object v0, p0, Landroid/text/HtmlToSpannedConverter;->mTagHandler:Landroid/text/Html$TagHandler;

    iget-object v1, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    iget-object v2, p0, Landroid/text/HtmlToSpannedConverter;->mReader:Lorg/xml/sax/XMLReader;

    invoke-interface {v0, v3, p1, v1, v2}, Landroid/text/Html$TagHandler;->handleTag(ZLjava/lang/String;Landroid/text/Editable;Lorg/xml/sax/XMLReader;)V

    goto/16 :goto_a
.end method

.method private static start(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V
    .registers 4
    .parameter "text"
    .parameter "mark"

    .prologue
    .line 604
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v0

    .line 605
    .local v0, len:I
    const/16 v1, 0x11

    invoke-virtual {p0, p1, v0, v0, v1}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 606
    return-void
.end method

.method private static startA(Landroid/text/SpannableStringBuilder;Lorg/xml/sax/Attributes;)V
    .registers 6
    .parameter "text"
    .parameter "attributes"

    .prologue
    .line 693
    const-string v2, ""

    const-string v3, "href"

    invoke-interface {p1, v2, v3}, Lorg/xml/sax/Attributes;->getValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 695
    .local v0, href:Ljava/lang/String;
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v1

    .line 696
    .local v1, len:I
    new-instance v2, Landroid/text/HtmlToSpannedConverter$Href;

    invoke-direct {v2, v0}, Landroid/text/HtmlToSpannedConverter$Href;-><init>(Ljava/lang/String;)V

    const/16 v3, 0x11

    invoke-virtual {p0, v2, v1, v1, v3}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 697
    return-void
.end method

.method private static startFont(Landroid/text/SpannableStringBuilder;Lorg/xml/sax/Attributes;)V
    .registers 7
    .parameter "text"
    .parameter "attributes"

    .prologue
    .line 647
    const-string v3, ""

    const-string v4, "color"

    invoke-interface {p1, v3, v4}, Lorg/xml/sax/Attributes;->getValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 648
    .local v0, color:Ljava/lang/String;
    const-string v3, ""

    const-string v4, "face"

    invoke-interface {p1, v3, v4}, Lorg/xml/sax/Attributes;->getValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 650
    .local v1, face:Ljava/lang/String;
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    .line 651
    .local v2, len:I
    new-instance v3, Landroid/text/HtmlToSpannedConverter$Font;

    invoke-direct {v3, v0, v1}, Landroid/text/HtmlToSpannedConverter$Font;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v4, 0x11

    invoke-virtual {p0, v3, v2, v2, v4}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 652
    return-void
.end method

.method private static startImg(Landroid/text/SpannableStringBuilder;Lorg/xml/sax/Attributes;Landroid/text/Html$ImageGetter;)V
    .registers 9
    .parameter "text"
    .parameter "attributes"
    .parameter "img"

    .prologue
    const/4 v5, 0x0

    .line 625
    const-string v3, ""

    const-string/jumbo v4, "src"

    invoke-interface {p1, v3, v4}, Lorg/xml/sax/Attributes;->getValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 626
    .local v2, src:Ljava/lang/String;
    const/4 v0, 0x0

    .line 628
    .local v0, d:Landroid/graphics/drawable/Drawable;
    if-eqz p2, :cond_11

    .line 629
    invoke-interface {p2, v2}, Landroid/text/Html$ImageGetter;->getDrawable(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 632
    :cond_11
    if-nez v0, :cond_29

    .line 633
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x10805f4

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 635
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v3

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v4

    invoke-virtual {v0, v5, v5, v3, v4}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 638
    :cond_29
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v1

    .line 639
    .local v1, len:I
    const-string/jumbo v3, "\ufffc"

    invoke-virtual {p0, v3}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 641
    new-instance v3, Landroid/text/style/ImageSpan;

    invoke-direct {v3, v0, v2}, Landroid/text/style/ImageSpan;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v4

    const/16 v5, 0x21

    invoke-virtual {p0, v3, v1, v4, v5}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 643
    return-void
.end method


# virtual methods
.method public characters([CII)V
    .registers 13
    .parameter "ch"
    .parameter "start"
    .parameter "length"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xml/sax/SAXException;
        }
    .end annotation

    .prologue
    const/16 v8, 0xa

    const/16 v7, 0x20

    .line 764
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 771
    .local v4, sb:Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_a
    if-ge v1, p3, :cond_42

    .line 772
    add-int v5, v1, p2

    aget-char v0, p1, v5

    .line 774
    .local v0, c:C
    if-eq v0, v7, :cond_14

    if-ne v0, v8, :cond_3e

    .line 776
    :cond_14
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->length()I

    move-result v2

    .line 778
    .local v2, len:I
    if-nez v2, :cond_37

    .line 779
    iget-object v5, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v5}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    .line 781
    if-nez v2, :cond_2e

    .line 782
    const/16 v3, 0xa

    .line 790
    .local v3, pred:C
    :goto_24
    if-eq v3, v7, :cond_2b

    if-eq v3, v8, :cond_2b

    .line 791
    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 771
    .end local v2           #len:I
    .end local v3           #pred:C
    :cond_2b
    :goto_2b
    add-int/lit8 v1, v1, 0x1

    goto :goto_a

    .line 784
    .restart local v2       #len:I
    :cond_2e
    iget-object v5, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    add-int/lit8 v6, v2, -0x1

    invoke-virtual {v5, v6}, Landroid/text/SpannableStringBuilder;->charAt(I)C

    move-result v3

    .restart local v3       #pred:C
    goto :goto_24

    .line 787
    .end local v3           #pred:C
    :cond_37
    add-int/lit8 v5, v2, -0x1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v3

    .restart local v3       #pred:C
    goto :goto_24

    .line 794
    .end local v2           #len:I
    .end local v3           #pred:C
    :cond_3e
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_2b

    .line 798
    .end local v0           #c:C
    :cond_42
    iget-object v5, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v5, v4}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 799
    return-void
.end method

.method public convert()Landroid/text/Spanned;
    .registers 11

    .prologue
    const/16 v9, 0xa

    .line 433
    iget-object v5, p0, Landroid/text/HtmlToSpannedConverter;->mReader:Lorg/xml/sax/XMLReader;

    invoke-interface {v5, p0}, Lorg/xml/sax/XMLReader;->setContentHandler(Lorg/xml/sax/ContentHandler;)V

    .line 435
    :try_start_7
    iget-object v5, p0, Landroid/text/HtmlToSpannedConverter;->mReader:Lorg/xml/sax/XMLReader;

    new-instance v6, Lorg/xml/sax/InputSource;

    new-instance v7, Ljava/io/StringReader;

    iget-object v8, p0, Landroid/text/HtmlToSpannedConverter;->mSource:Ljava/lang/String;

    invoke-direct {v7, v8}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-direct {v6, v7}, Lorg/xml/sax/InputSource;-><init>(Ljava/io/Reader;)V

    invoke-interface {v5, v6}, Lorg/xml/sax/XMLReader;->parse(Lorg/xml/sax/InputSource;)V
    :try_end_18
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_18} :catch_61
    .catch Lorg/xml/sax/SAXException; {:try_start_7 .. :try_end_18} :catch_68

    .line 445
    iget-object v5, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    const/4 v6, 0x0

    iget-object v7, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v7}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v7

    const-class v8, Landroid/text/style/ParagraphStyle;

    invoke-virtual {v5, v6, v7, v8}, Landroid/text/SpannableStringBuilder;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v3

    .line 446
    .local v3, obj:[Ljava/lang/Object;
    const/4 v2, 0x0

    .local v2, i:I
    :goto_28
    array-length v5, v3

    if-ge v2, v5, :cond_79

    .line 447
    iget-object v5, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    aget-object v6, v3, v2

    invoke-virtual {v5, v6}, Landroid/text/SpannableStringBuilder;->getSpanStart(Ljava/lang/Object;)I

    move-result v4

    .line 448
    .local v4, start:I
    iget-object v5, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    aget-object v6, v3, v2

    invoke-virtual {v5, v6}, Landroid/text/SpannableStringBuilder;->getSpanEnd(Ljava/lang/Object;)I

    move-result v1

    .line 451
    .local v1, end:I
    add-int/lit8 v5, v1, -0x2

    if-ltz v5, :cond_55

    .line 452
    iget-object v5, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    add-int/lit8 v6, v1, -0x1

    invoke-virtual {v5, v6}, Landroid/text/SpannableStringBuilder;->charAt(I)C

    move-result v5

    if-ne v5, v9, :cond_55

    iget-object v5, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    add-int/lit8 v6, v1, -0x2

    invoke-virtual {v5, v6}, Landroid/text/SpannableStringBuilder;->charAt(I)C

    move-result v5

    if-ne v5, v9, :cond_55

    .line 454
    add-int/lit8 v1, v1, -0x1

    .line 458
    :cond_55
    if-ne v1, v4, :cond_6f

    .line 459
    iget-object v5, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    aget-object v6, v3, v2

    invoke-virtual {v5, v6}, Landroid/text/SpannableStringBuilder;->removeSpan(Ljava/lang/Object;)V

    .line 446
    :goto_5e
    add-int/lit8 v2, v2, 0x1

    goto :goto_28

    .line 436
    .end local v1           #end:I
    .end local v2           #i:I
    .end local v3           #obj:[Ljava/lang/Object;
    .end local v4           #start:I
    :catch_61
    move-exception v0

    .line 438
    .local v0, e:Ljava/io/IOException;
    new-instance v5, Ljava/lang/RuntimeException;

    invoke-direct {v5, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v5

    .line 439
    .end local v0           #e:Ljava/io/IOException;
    :catch_68
    move-exception v0

    .line 441
    .local v0, e:Lorg/xml/sax/SAXException;
    new-instance v5, Ljava/lang/RuntimeException;

    invoke-direct {v5, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v5

    .line 461
    .end local v0           #e:Lorg/xml/sax/SAXException;
    .restart local v1       #end:I
    .restart local v2       #i:I
    .restart local v3       #obj:[Ljava/lang/Object;
    .restart local v4       #start:I
    :cond_6f
    iget-object v5, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    aget-object v6, v3, v2

    const/16 v7, 0x33

    invoke-virtual {v5, v6, v4, v1, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto :goto_5e

    .line 465
    .end local v1           #end:I
    .end local v4           #start:I
    :cond_79
    iget-object v5, p0, Landroid/text/HtmlToSpannedConverter;->mSpannableStringBuilder:Landroid/text/SpannableStringBuilder;

    return-object v5
.end method

.method public endDocument()V
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xml/sax/SAXException;
        }
    .end annotation

    .prologue
    .line 746
    return-void
.end method

.method public endElement(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "uri"
    .parameter "localName"
    .parameter "qName"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xml/sax/SAXException;
        }
    .end annotation

    .prologue
    .line 760
    invoke-direct {p0, p2}, Landroid/text/HtmlToSpannedConverter;->handleEndTag(Ljava/lang/String;)V

    .line 761
    return-void
.end method

.method public endPrefixMapping(Ljava/lang/String;)V
    .registers 2
    .parameter "prefix"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xml/sax/SAXException;
        }
    .end annotation

    .prologue
    .line 752
    return-void
.end method

.method public ignorableWhitespace([CII)V
    .registers 4
    .parameter "ch"
    .parameter "start"
    .parameter "length"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xml/sax/SAXException;
        }
    .end annotation

    .prologue
    .line 802
    return-void
.end method

.method public processingInstruction(Ljava/lang/String;Ljava/lang/String;)V
    .registers 3
    .parameter "target"
    .parameter "data"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xml/sax/SAXException;
        }
    .end annotation

    .prologue
    .line 805
    return-void
.end method

.method public setDocumentLocator(Lorg/xml/sax/Locator;)V
    .registers 2
    .parameter "locator"

    .prologue
    .line 740
    return-void
.end method

.method public skippedEntity(Ljava/lang/String;)V
    .registers 2
    .parameter "name"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xml/sax/SAXException;
        }
    .end annotation

    .prologue
    .line 808
    return-void
.end method

.method public startDocument()V
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xml/sax/SAXException;
        }
    .end annotation

    .prologue
    .line 743
    return-void
.end method

.method public startElement(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/xml/sax/Attributes;)V
    .registers 5
    .parameter "uri"
    .parameter "localName"
    .parameter "qName"
    .parameter "attributes"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xml/sax/SAXException;
        }
    .end annotation

    .prologue
    .line 756
    invoke-direct {p0, p2, p4}, Landroid/text/HtmlToSpannedConverter;->handleStartTag(Ljava/lang/String;Lorg/xml/sax/Attributes;)V

    .line 757
    return-void
.end method

.method public startPrefixMapping(Ljava/lang/String;Ljava/lang/String;)V
    .registers 3
    .parameter "prefix"
    .parameter "uri"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xml/sax/SAXException;
        }
    .end annotation

    .prologue
    .line 749
    return-void
.end method
