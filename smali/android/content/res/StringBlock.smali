.class final Landroid/content/res/StringBlock;
.super Ljava/lang/Object;
.source "StringBlock.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/content/res/StringBlock$Height;,
        Landroid/content/res/StringBlock$StyleIDs;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "AssetManager"

.field private static final localLOGV:Z


# instance fields
.field private final mNative:I

.field private final mOwnsNative:Z

.field private mSparseStrings:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/CharSequence;",
            ">;"
        }
    .end annotation
.end field

.field private mStrings:[Ljava/lang/CharSequence;

.field mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

.field private final mUseSparse:Z


# direct methods
.method constructor <init>(IZ)V
    .registers 4
    .parameter "obj"
    .parameter "useSparse"

    .prologue
    .line 418
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 43
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    .line 419
    iput p1, p0, Landroid/content/res/StringBlock;->mNative:I

    .line 420
    iput-boolean p2, p0, Landroid/content/res/StringBlock;->mUseSparse:Z

    .line 421
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/content/res/StringBlock;->mOwnsNative:Z

    .line 424
    return-void
.end method

.method public constructor <init>([BIIZ)V
    .registers 6
    .parameter "data"
    .parameter "offset"
    .parameter "size"
    .parameter "useSparse"

    .prologue
    .line 53
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 43
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    .line 54
    invoke-static {p1, p2, p3}, Landroid/content/res/StringBlock;->nativeCreate([BII)I

    move-result v0

    iput v0, p0, Landroid/content/res/StringBlock;->mNative:I

    .line 55
    iput-boolean p4, p0, Landroid/content/res/StringBlock;->mUseSparse:Z

    .line 56
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/content/res/StringBlock;->mOwnsNative:Z

    .line 59
    return-void
.end method

.method public constructor <init>([BZ)V
    .registers 5
    .parameter "data"
    .parameter "useSparse"

    .prologue
    .line 45
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 43
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    .line 46
    const/4 v0, 0x0

    array-length v1, p1

    invoke-static {p1, v0, v1}, Landroid/content/res/StringBlock;->nativeCreate([BII)I

    move-result v0

    iput v0, p0, Landroid/content/res/StringBlock;->mNative:I

    .line 47
    iput-boolean p2, p0, Landroid/content/res/StringBlock;->mUseSparse:Z

    .line 48
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/content/res/StringBlock;->mOwnsNative:Z

    .line 51
    return-void
.end method

.method private static addParagraphSpan(Landroid/text/Spannable;Ljava/lang/Object;II)V
    .registers 7
    .parameter "buffer"
    .parameter "what"
    .parameter "start"
    .parameter "end"

    .prologue
    const/16 v2, 0xa

    .line 298
    invoke-interface {p0}, Landroid/text/Spannable;->length()I

    move-result v0

    .line 300
    .local v0, len:I
    if-eqz p2, :cond_1e

    if-eq p2, v0, :cond_1e

    add-int/lit8 v1, p2, -0x1

    invoke-interface {p0, v1}, Landroid/text/Spannable;->charAt(I)C

    move-result v1

    if-eq v1, v2, :cond_1e

    .line 301
    add-int/lit8 p2, p2, -0x1

    :goto_14
    if-lez p2, :cond_1e

    .line 302
    add-int/lit8 v1, p2, -0x1

    invoke-interface {p0, v1}, Landroid/text/Spannable;->charAt(I)C

    move-result v1

    if-ne v1, v2, :cond_3c

    .line 308
    :cond_1e
    if-eqz p3, :cond_36

    if-eq p3, v0, :cond_36

    add-int/lit8 v1, p3, -0x1

    invoke-interface {p0, v1}, Landroid/text/Spannable;->charAt(I)C

    move-result v1

    if-eq v1, v2, :cond_36

    .line 309
    add-int/lit8 p3, p3, 0x1

    :goto_2c
    if-ge p3, v0, :cond_36

    .line 310
    add-int/lit8 v1, p3, -0x1

    invoke-interface {p0, v1}, Landroid/text/Spannable;->charAt(I)C

    move-result v1

    if-ne v1, v2, :cond_3f

    .line 316
    :cond_36
    const/16 v1, 0x33

    invoke-interface {p0, p1, p2, p3, v1}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    .line 317
    return-void

    .line 301
    :cond_3c
    add-int/lit8 p2, p2, -0x1

    goto :goto_14

    .line 309
    :cond_3f
    add-int/lit8 p3, p3, 0x1

    goto :goto_2c
.end method

.method private applyStyles(Ljava/lang/String;[ILandroid/content/res/StringBlock$StyleIDs;)Ljava/lang/CharSequence;
    .registers 25
    .parameter "str"
    .parameter "style"
    .parameter "ids"

    .prologue
    .line 162
    move-object/from16 v0, p2

    array-length v0, v0

    move/from16 v17, v0

    if-nez v17, :cond_8

    .line 288
    .end local p1
    :goto_7
    return-object p1

    .line 165
    .restart local p1
    :cond_8
    new-instance v4, Landroid/text/SpannableString;

    move-object/from16 v0, p1

    invoke-direct {v4, v0}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 166
    .local v4, buffer:Landroid/text/SpannableString;
    const/4 v7, 0x0

    .line 167
    .local v7, i:I
    :goto_10
    move-object/from16 v0, p2

    array-length v0, v0

    move/from16 v17, v0

    move/from16 v0, v17

    if-ge v7, v0, :cond_325

    .line 168
    aget v15, p2, v7

    .line 173
    .local v15, type:I
    #getter for: Landroid/content/res/StringBlock$StyleIDs;->boldId:I
    invoke-static/range {p3 .. p3}, Landroid/content/res/StringBlock$StyleIDs;->access$000(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v17

    move/from16 v0, v17

    if-ne v15, v0, :cond_44

    .line 174
    new-instance v17, Landroid/text/style/StyleSpan;

    const/16 v18, 0x1

    invoke-direct/range {v17 .. v18}, Landroid/text/style/StyleSpan;-><init>(I)V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    const/16 v20, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 286
    :cond_41
    :goto_41
    add-int/lit8 v7, v7, 0x3

    .line 287
    goto :goto_10

    .line 177
    :cond_44
    #getter for: Landroid/content/res/StringBlock$StyleIDs;->italicId:I
    invoke-static/range {p3 .. p3}, Landroid/content/res/StringBlock$StyleIDs;->access$100(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v17

    move/from16 v0, v17

    if-ne v15, v0, :cond_6b

    .line 178
    new-instance v17, Landroid/text/style/StyleSpan;

    const/16 v18, 0x2

    invoke-direct/range {v17 .. v18}, Landroid/text/style/StyleSpan;-><init>(I)V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    const/16 v20, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto :goto_41

    .line 181
    :cond_6b
    #getter for: Landroid/content/res/StringBlock$StyleIDs;->underlineId:I
    invoke-static/range {p3 .. p3}, Landroid/content/res/StringBlock$StyleIDs;->access$200(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v17

    move/from16 v0, v17

    if-ne v15, v0, :cond_90

    .line 182
    new-instance v17, Landroid/text/style/UnderlineSpan;

    invoke-direct/range {v17 .. v17}, Landroid/text/style/UnderlineSpan;-><init>()V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    const/16 v20, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto :goto_41

    .line 185
    :cond_90
    #getter for: Landroid/content/res/StringBlock$StyleIDs;->ttId:I
    invoke-static/range {p3 .. p3}, Landroid/content/res/StringBlock$StyleIDs;->access$300(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v17

    move/from16 v0, v17

    if-ne v15, v0, :cond_b8

    .line 186
    new-instance v17, Landroid/text/style/TypefaceSpan;

    const-string/jumbo v18, "monospace"

    invoke-direct/range {v17 .. v18}, Landroid/text/style/TypefaceSpan;-><init>(Ljava/lang/String;)V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    const/16 v20, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto :goto_41

    .line 189
    :cond_b8
    #getter for: Landroid/content/res/StringBlock$StyleIDs;->bigId:I
    invoke-static/range {p3 .. p3}, Landroid/content/res/StringBlock$StyleIDs;->access$400(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v17

    move/from16 v0, v17

    if-ne v15, v0, :cond_e0

    .line 190
    new-instance v17, Landroid/text/style/RelativeSizeSpan;

    const/high16 v18, 0x3fa0

    invoke-direct/range {v17 .. v18}, Landroid/text/style/RelativeSizeSpan;-><init>(F)V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    const/16 v20, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_41

    .line 193
    :cond_e0
    #getter for: Landroid/content/res/StringBlock$StyleIDs;->smallId:I
    invoke-static/range {p3 .. p3}, Landroid/content/res/StringBlock$StyleIDs;->access$500(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v17

    move/from16 v0, v17

    if-ne v15, v0, :cond_109

    .line 194
    new-instance v17, Landroid/text/style/RelativeSizeSpan;

    const v18, 0x3f4ccccd

    invoke-direct/range {v17 .. v18}, Landroid/text/style/RelativeSizeSpan;-><init>(F)V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    const/16 v20, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_41

    .line 197
    :cond_109
    #getter for: Landroid/content/res/StringBlock$StyleIDs;->subId:I
    invoke-static/range {p3 .. p3}, Landroid/content/res/StringBlock$StyleIDs;->access$600(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v17

    move/from16 v0, v17

    if-ne v15, v0, :cond_12f

    .line 198
    new-instance v17, Landroid/text/style/SubscriptSpan;

    invoke-direct/range {v17 .. v17}, Landroid/text/style/SubscriptSpan;-><init>()V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    const/16 v20, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_41

    .line 201
    :cond_12f
    #getter for: Landroid/content/res/StringBlock$StyleIDs;->supId:I
    invoke-static/range {p3 .. p3}, Landroid/content/res/StringBlock$StyleIDs;->access$700(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v17

    move/from16 v0, v17

    if-ne v15, v0, :cond_155

    .line 202
    new-instance v17, Landroid/text/style/SuperscriptSpan;

    invoke-direct/range {v17 .. v17}, Landroid/text/style/SuperscriptSpan;-><init>()V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    const/16 v20, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_41

    .line 205
    :cond_155
    #getter for: Landroid/content/res/StringBlock$StyleIDs;->strikeId:I
    invoke-static/range {p3 .. p3}, Landroid/content/res/StringBlock$StyleIDs;->access$800(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v17

    move/from16 v0, v17

    if-ne v15, v0, :cond_17b

    .line 206
    new-instance v17, Landroid/text/style/StrikethroughSpan;

    invoke-direct/range {v17 .. v17}, Landroid/text/style/StrikethroughSpan;-><init>()V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    const/16 v20, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_41

    .line 209
    :cond_17b
    #getter for: Landroid/content/res/StringBlock$StyleIDs;->listItemId:I
    invoke-static/range {p3 .. p3}, Landroid/content/res/StringBlock$StyleIDs;->access$900(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v17

    move/from16 v0, v17

    if-ne v15, v0, :cond_19f

    .line 210
    new-instance v17, Landroid/text/style/BulletSpan;

    const/16 v18, 0xa

    invoke-direct/range {v17 .. v18}, Landroid/text/style/BulletSpan;-><init>(I)V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    invoke-static {v4, v0, v1, v2}, Landroid/content/res/StringBlock;->addParagraphSpan(Landroid/text/Spannable;Ljava/lang/Object;II)V

    goto/16 :goto_41

    .line 212
    :cond_19f
    #getter for: Landroid/content/res/StringBlock$StyleIDs;->marqueeId:I
    invoke-static/range {p3 .. p3}, Landroid/content/res/StringBlock$StyleIDs;->access$1000(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v17

    move/from16 v0, v17

    if-ne v15, v0, :cond_1c2

    .line 213
    sget-object v17, Landroid/text/TextUtils$TruncateAt;->MARQUEE:Landroid/text/TextUtils$TruncateAt;

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    const/16 v20, 0x12

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_41

    .line 217
    :cond_1c2
    move-object/from16 v0, p0

    iget v0, v0, Landroid/content/res/StringBlock;->mNative:I

    move/from16 v17, v0

    move/from16 v0, v17

    invoke-static {v0, v15}, Landroid/content/res/StringBlock;->nativeGetString(II)Ljava/lang/String;

    move-result-object v14

    .line 219
    .local v14, tag:Ljava/lang/String;
    const-string v17, "font;"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_292

    .line 222
    const-string v17, ";height="

    move-object/from16 v0, v17

    invoke-static {v14, v0}, Landroid/content/res/StringBlock;->subtag(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 223
    .local v12, sub:Ljava/lang/String;
    if-eqz v12, :cond_200

    .line 224
    invoke-static {v12}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v11

    .line 225
    .local v11, size:I
    new-instance v17, Landroid/content/res/StringBlock$Height;

    move-object/from16 v0, v17

    invoke-direct {v0, v11}, Landroid/content/res/StringBlock$Height;-><init>(I)V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    invoke-static {v4, v0, v1, v2}, Landroid/content/res/StringBlock;->addParagraphSpan(Landroid/text/Spannable;Ljava/lang/Object;II)V

    .line 229
    .end local v11           #size:I
    :cond_200
    const-string v17, ";size="

    move-object/from16 v0, v17

    invoke-static {v14, v0}, Landroid/content/res/StringBlock;->subtag(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 230
    if-eqz v12, :cond_230

    .line 231
    invoke-static {v12}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v11

    .line 232
    .restart local v11       #size:I
    new-instance v17, Landroid/text/style/AbsoluteSizeSpan;

    const/16 v18, 0x1

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-direct {v0, v11, v1}, Landroid/text/style/AbsoluteSizeSpan;-><init>(IZ)V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    const/16 v20, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 237
    .end local v11           #size:I
    :cond_230
    const-string v17, ";fgcolor="

    move-object/from16 v0, v17

    invoke-static {v14, v0}, Landroid/content/res/StringBlock;->subtag(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 238
    if-eqz v12, :cond_260

    .line 239
    const/16 v17, -0x1

    move/from16 v0, v17

    invoke-static {v12, v0}, Lcom/android/internal/util/XmlUtils;->convertValueToUnsignedInt(Ljava/lang/String;I)I

    move-result v5

    .line 240
    .local v5, color:I
    new-instance v17, Landroid/text/style/ForegroundColorSpan;

    move-object/from16 v0, v17

    invoke-direct {v0, v5}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    const/16 v20, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 245
    .end local v5           #color:I
    :cond_260
    const-string v17, ";bgcolor="

    move-object/from16 v0, v17

    invoke-static {v14, v0}, Landroid/content/res/StringBlock;->subtag(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 246
    if-eqz v12, :cond_41

    .line 247
    const/16 v17, -0x1

    move/from16 v0, v17

    invoke-static {v12, v0}, Lcom/android/internal/util/XmlUtils;->convertValueToUnsignedInt(Ljava/lang/String;I)I

    move-result v5

    .line 248
    .restart local v5       #color:I
    new-instance v17, Landroid/text/style/BackgroundColorSpan;

    move-object/from16 v0, v17

    invoke-direct {v0, v5}, Landroid/text/style/BackgroundColorSpan;-><init>(I)V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    const/16 v20, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_41

    .line 252
    .end local v5           #color:I
    .end local v12           #sub:Ljava/lang/String;
    :cond_292
    const-string v17, "a;"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_2c6

    .line 255
    const-string v17, ";href="

    move-object/from16 v0, v17

    invoke-static {v14, v0}, Landroid/content/res/StringBlock;->subtag(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 256
    .restart local v12       #sub:Ljava/lang/String;
    if-eqz v12, :cond_41

    .line 257
    new-instance v17, Landroid/text/style/URLSpan;

    move-object/from16 v0, v17

    invoke-direct {v0, v12}, Landroid/text/style/URLSpan;-><init>(Ljava/lang/String;)V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    const/16 v20, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_41

    .line 261
    .end local v12           #sub:Ljava/lang/String;
    :cond_2c6
    const-string v17, "annotation;"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_41

    .line 262
    invoke-virtual {v14}, Ljava/lang/String;->length()I

    move-result v9

    .line 265
    .local v9, len:I
    const/16 v17, 0x3b

    move/from16 v0, v17

    invoke-virtual {v14, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v13

    .local v13, t:I
    :goto_2dc
    if-ge v13, v9, :cond_41

    .line 266
    const/16 v17, 0x3d

    move/from16 v0, v17

    invoke-virtual {v14, v0, v13}, Ljava/lang/String;->indexOf(II)I

    move-result v6

    .line 267
    .local v6, eq:I
    if-ltz v6, :cond_41

    .line 271
    const/16 v17, 0x3b

    move/from16 v0, v17

    invoke-virtual {v14, v0, v6}, Ljava/lang/String;->indexOf(II)I

    move-result v10

    .line 272
    .local v10, next:I
    if-gez v10, :cond_2f3

    .line 273
    move v10, v9

    .line 276
    :cond_2f3
    add-int/lit8 v17, v13, 0x1

    move/from16 v0, v17

    invoke-virtual {v14, v0, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v8

    .line 277
    .local v8, key:Ljava/lang/String;
    add-int/lit8 v17, v6, 0x1

    move/from16 v0, v17

    invoke-virtual {v14, v0, v10}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v16

    .line 279
    .local v16, value:Ljava/lang/String;
    new-instance v17, Landroid/text/Annotation;

    move-object/from16 v0, v17

    move-object/from16 v1, v16

    invoke-direct {v0, v8, v1}, Landroid/text/Annotation;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    add-int/lit8 v18, v7, 0x1

    aget v18, p2, v18

    add-int/lit8 v19, v7, 0x2

    aget v19, p2, v19

    add-int/lit8 v19, v19, 0x1

    const/16 v20, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 265
    move v13, v10

    goto :goto_2dc

    .line 288
    .end local v6           #eq:I
    .end local v8           #key:Ljava/lang/String;
    .end local v9           #len:I
    .end local v10           #next:I
    .end local v13           #t:I
    .end local v14           #tag:Ljava/lang/String;
    .end local v15           #type:I
    .end local v16           #value:Ljava/lang/String;
    :cond_325
    new-instance p1, Landroid/text/SpannedString;

    .end local p1
    move-object/from16 v0, p1

    invoke-direct {v0, v4}, Landroid/text/SpannedString;-><init>(Ljava/lang/CharSequence;)V

    goto/16 :goto_7
.end method

.method private static final native nativeCreate([BII)I
.end method

.method private static final native nativeDestroy(I)V
.end method

.method private static final native nativeGetSize(I)I
.end method

.method private static final native nativeGetString(II)Ljava/lang/String;
.end method

.method private static final native nativeGetStyle(II)[I
.end method

.method private static subtag(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 5
    .parameter "full"
    .parameter "attribute"

    .prologue
    .line 320
    invoke-virtual {p0, p1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 321
    .local v1, start:I
    if-gez v1, :cond_8

    .line 322
    const/4 v2, 0x0

    .line 331
    :goto_7
    return-object v2

    .line 325
    :cond_8
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v1, v2

    .line 326
    const/16 v2, 0x3b

    invoke-virtual {p0, v2, v1}, Ljava/lang/String;->indexOf(II)I

    move-result v0

    .line 328
    .local v0, end:I
    if-gez v0, :cond_1a

    .line 329
    invoke-virtual {p0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_7

    .line 331
    :cond_1a
    invoke-virtual {p0, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    goto :goto_7
.end method


# virtual methods
.method protected finalize()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 142
    iget-boolean v0, p0, Landroid/content/res/StringBlock;->mOwnsNative:Z

    if-eqz v0, :cond_9

    .line 143
    iget v0, p0, Landroid/content/res/StringBlock;->mNative:I

    invoke-static {v0}, Landroid/content/res/StringBlock;->nativeDestroy(I)V

    .line 145
    :cond_9
    return-void
.end method

.method public get(I)Ljava/lang/CharSequence;
    .registers 10
    .parameter "idx"

    .prologue
    .line 62
    monitor-enter p0

    .line 63
    :try_start_1
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStrings:[Ljava/lang/CharSequence;

    if-eqz v7, :cond_d

    .line 64
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStrings:[Ljava/lang/CharSequence;

    aget-object v1, v7, p1

    .line 65
    .local v1, res:Ljava/lang/CharSequence;
    if-eqz v1, :cond_35

    .line 66
    monitor-exit p0

    .line 137
    :goto_c
    return-object v1

    .line 68
    .end local v1           #res:Ljava/lang/CharSequence;
    :cond_d
    iget-object v7, p0, Landroid/content/res/StringBlock;->mSparseStrings:Landroid/util/SparseArray;

    if-eqz v7, :cond_20

    .line 69
    iget-object v7, p0, Landroid/content/res/StringBlock;->mSparseStrings:Landroid/util/SparseArray;

    invoke-virtual {v7, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    .line 70
    .restart local v1       #res:Ljava/lang/CharSequence;
    if-eqz v1, :cond_35

    .line 71
    monitor-exit p0

    goto :goto_c

    .line 138
    .end local v1           #res:Ljava/lang/CharSequence;
    :catchall_1d
    move-exception v7

    monitor-exit p0
    :try_end_1f
    .catchall {:try_start_1 .. :try_end_1f} :catchall_1d

    throw v7

    .line 74
    :cond_20
    :try_start_20
    iget v7, p0, Landroid/content/res/StringBlock;->mNative:I

    invoke-static {v7}, Landroid/content/res/StringBlock;->nativeGetSize(I)I

    move-result v0

    .line 75
    .local v0, num:I
    iget-boolean v7, p0, Landroid/content/res/StringBlock;->mUseSparse:Z

    if-eqz v7, :cond_b0

    const/16 v7, 0xfa

    if-le v0, v7, :cond_b0

    .line 76
    new-instance v7, Landroid/util/SparseArray;

    invoke-direct {v7}, Landroid/util/SparseArray;-><init>()V

    iput-object v7, p0, Landroid/content/res/StringBlock;->mSparseStrings:Landroid/util/SparseArray;

    .line 81
    .end local v0           #num:I
    :cond_35
    :goto_35
    iget v7, p0, Landroid/content/res/StringBlock;->mNative:I

    invoke-static {v7, p1}, Landroid/content/res/StringBlock;->nativeGetString(II)Ljava/lang/String;

    move-result-object v2

    .line 82
    .local v2, str:Ljava/lang/String;
    move-object v1, v2

    .line 83
    .restart local v1       #res:Ljava/lang/CharSequence;
    iget v7, p0, Landroid/content/res/StringBlock;->mNative:I

    invoke-static {v7, p1}, Landroid/content/res/StringBlock;->nativeGetStyle(II)[I

    move-result-object v3

    .line 86
    .local v3, style:[I
    if-eqz v3, :cond_167

    .line 87
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    if-nez v7, :cond_4f

    .line 88
    new-instance v7, Landroid/content/res/StringBlock$StyleIDs;

    invoke-direct {v7}, Landroid/content/res/StringBlock$StyleIDs;-><init>()V

    iput-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    .line 93
    :cond_4f
    const/4 v5, 0x0

    .local v5, styleIndex:I
    :goto_50
    array-length v7, v3

    if-ge v5, v7, :cond_161

    .line 94
    aget v4, v3, v5

    .line 96
    .local v4, styleId:I
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #getter for: Landroid/content/res/StringBlock$StyleIDs;->boldId:I
    invoke-static {v7}, Landroid/content/res/StringBlock$StyleIDs;->access$000(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v7

    if-eq v4, v7, :cond_ad

    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #getter for: Landroid/content/res/StringBlock$StyleIDs;->italicId:I
    invoke-static {v7}, Landroid/content/res/StringBlock$StyleIDs;->access$100(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v7

    if-eq v4, v7, :cond_ad

    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #getter for: Landroid/content/res/StringBlock$StyleIDs;->underlineId:I
    invoke-static {v7}, Landroid/content/res/StringBlock$StyleIDs;->access$200(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v7

    if-eq v4, v7, :cond_ad

    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #getter for: Landroid/content/res/StringBlock$StyleIDs;->ttId:I
    invoke-static {v7}, Landroid/content/res/StringBlock$StyleIDs;->access$300(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v7

    if-eq v4, v7, :cond_ad

    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #getter for: Landroid/content/res/StringBlock$StyleIDs;->bigId:I
    invoke-static {v7}, Landroid/content/res/StringBlock$StyleIDs;->access$400(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v7

    if-eq v4, v7, :cond_ad

    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #getter for: Landroid/content/res/StringBlock$StyleIDs;->smallId:I
    invoke-static {v7}, Landroid/content/res/StringBlock$StyleIDs;->access$500(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v7

    if-eq v4, v7, :cond_ad

    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #getter for: Landroid/content/res/StringBlock$StyleIDs;->subId:I
    invoke-static {v7}, Landroid/content/res/StringBlock$StyleIDs;->access$600(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v7

    if-eq v4, v7, :cond_ad

    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #getter for: Landroid/content/res/StringBlock$StyleIDs;->supId:I
    invoke-static {v7}, Landroid/content/res/StringBlock$StyleIDs;->access$700(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v7

    if-eq v4, v7, :cond_ad

    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #getter for: Landroid/content/res/StringBlock$StyleIDs;->strikeId:I
    invoke-static {v7}, Landroid/content/res/StringBlock$StyleIDs;->access$800(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v7

    if-eq v4, v7, :cond_ad

    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #getter for: Landroid/content/res/StringBlock$StyleIDs;->listItemId:I
    invoke-static {v7}, Landroid/content/res/StringBlock$StyleIDs;->access$900(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v7

    if-eq v4, v7, :cond_ad

    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #getter for: Landroid/content/res/StringBlock$StyleIDs;->marqueeId:I
    invoke-static {v7}, Landroid/content/res/StringBlock$StyleIDs;->access$1000(Landroid/content/res/StringBlock$StyleIDs;)I

    move-result v7

    if-ne v4, v7, :cond_b5

    .line 93
    :cond_ad
    :goto_ad
    add-int/lit8 v5, v5, 0x3

    goto :goto_50

    .line 78
    .end local v1           #res:Ljava/lang/CharSequence;
    .end local v2           #str:Ljava/lang/String;
    .end local v3           #style:[I
    .end local v4           #styleId:I
    .end local v5           #styleIndex:I
    .restart local v0       #num:I
    :cond_b0
    new-array v7, v0, [Ljava/lang/CharSequence;

    iput-object v7, p0, Landroid/content/res/StringBlock;->mStrings:[Ljava/lang/CharSequence;

    goto :goto_35

    .line 106
    .end local v0           #num:I
    .restart local v1       #res:Ljava/lang/CharSequence;
    .restart local v2       #str:Ljava/lang/String;
    .restart local v3       #style:[I
    .restart local v4       #styleId:I
    .restart local v5       #styleIndex:I
    :cond_b5
    iget v7, p0, Landroid/content/res/StringBlock;->mNative:I

    invoke-static {v7, v4}, Landroid/content/res/StringBlock;->nativeGetString(II)Ljava/lang/String;

    move-result-object v6

    .line 108
    .local v6, styleTag:Ljava/lang/String;
    const-string v7, "b"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_c9

    .line 109
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #setter for: Landroid/content/res/StringBlock$StyleIDs;->boldId:I
    invoke-static {v7, v4}, Landroid/content/res/StringBlock$StyleIDs;->access$002(Landroid/content/res/StringBlock$StyleIDs;I)I

    goto :goto_ad

    .line 110
    :cond_c9
    const-string v7, "i"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_d7

    .line 111
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #setter for: Landroid/content/res/StringBlock$StyleIDs;->italicId:I
    invoke-static {v7, v4}, Landroid/content/res/StringBlock$StyleIDs;->access$102(Landroid/content/res/StringBlock$StyleIDs;I)I

    goto :goto_ad

    .line 112
    :cond_d7
    const-string/jumbo v7, "u"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_e6

    .line 113
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #setter for: Landroid/content/res/StringBlock$StyleIDs;->underlineId:I
    invoke-static {v7, v4}, Landroid/content/res/StringBlock$StyleIDs;->access$202(Landroid/content/res/StringBlock$StyleIDs;I)I

    goto :goto_ad

    .line 114
    :cond_e6
    const-string/jumbo v7, "tt"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_f5

    .line 115
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #setter for: Landroid/content/res/StringBlock$StyleIDs;->ttId:I
    invoke-static {v7, v4}, Landroid/content/res/StringBlock$StyleIDs;->access$302(Landroid/content/res/StringBlock$StyleIDs;I)I

    goto :goto_ad

    .line 116
    :cond_f5
    const-string v7, "big"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_103

    .line 117
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #setter for: Landroid/content/res/StringBlock$StyleIDs;->bigId:I
    invoke-static {v7, v4}, Landroid/content/res/StringBlock$StyleIDs;->access$402(Landroid/content/res/StringBlock$StyleIDs;I)I

    goto :goto_ad

    .line 118
    :cond_103
    const-string/jumbo v7, "small"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_112

    .line 119
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #setter for: Landroid/content/res/StringBlock$StyleIDs;->smallId:I
    invoke-static {v7, v4}, Landroid/content/res/StringBlock$StyleIDs;->access$502(Landroid/content/res/StringBlock$StyleIDs;I)I

    goto :goto_ad

    .line 120
    :cond_112
    const-string/jumbo v7, "sup"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_121

    .line 121
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #setter for: Landroid/content/res/StringBlock$StyleIDs;->supId:I
    invoke-static {v7, v4}, Landroid/content/res/StringBlock$StyleIDs;->access$702(Landroid/content/res/StringBlock$StyleIDs;I)I

    goto :goto_ad

    .line 122
    :cond_121
    const-string/jumbo v7, "sub"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_131

    .line 123
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #setter for: Landroid/content/res/StringBlock$StyleIDs;->subId:I
    invoke-static {v7, v4}, Landroid/content/res/StringBlock$StyleIDs;->access$602(Landroid/content/res/StringBlock$StyleIDs;I)I

    goto/16 :goto_ad

    .line 124
    :cond_131
    const-string/jumbo v7, "strike"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_141

    .line 125
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #setter for: Landroid/content/res/StringBlock$StyleIDs;->strikeId:I
    invoke-static {v7, v4}, Landroid/content/res/StringBlock$StyleIDs;->access$802(Landroid/content/res/StringBlock$StyleIDs;I)I

    goto/16 :goto_ad

    .line 126
    :cond_141
    const-string/jumbo v7, "li"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_151

    .line 127
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #setter for: Landroid/content/res/StringBlock$StyleIDs;->listItemId:I
    invoke-static {v7, v4}, Landroid/content/res/StringBlock$StyleIDs;->access$902(Landroid/content/res/StringBlock$StyleIDs;I)I

    goto/16 :goto_ad

    .line 128
    :cond_151
    const-string/jumbo v7, "marquee"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_ad

    .line 129
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    #setter for: Landroid/content/res/StringBlock$StyleIDs;->marqueeId:I
    invoke-static {v7, v4}, Landroid/content/res/StringBlock$StyleIDs;->access$1002(Landroid/content/res/StringBlock$StyleIDs;I)I

    goto/16 :goto_ad

    .line 133
    .end local v4           #styleId:I
    .end local v6           #styleTag:Ljava/lang/String;
    :cond_161
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStyleIDs:Landroid/content/res/StringBlock$StyleIDs;

    invoke-direct {p0, v2, v3, v7}, Landroid/content/res/StringBlock;->applyStyles(Ljava/lang/String;[ILandroid/content/res/StringBlock$StyleIDs;)Ljava/lang/CharSequence;

    move-result-object v1

    .line 135
    .end local v5           #styleIndex:I
    :cond_167
    iget-object v7, p0, Landroid/content/res/StringBlock;->mStrings:[Ljava/lang/CharSequence;

    if-eqz v7, :cond_172

    iget-object v7, p0, Landroid/content/res/StringBlock;->mStrings:[Ljava/lang/CharSequence;

    aput-object v1, v7, p1

    .line 137
    :goto_16f
    monitor-exit p0

    goto/16 :goto_c

    .line 136
    :cond_172
    iget-object v7, p0, Landroid/content/res/StringBlock;->mSparseStrings:Landroid/util/SparseArray;

    invoke-virtual {v7, p1, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V
    :try_end_177
    .catchall {:try_start_20 .. :try_end_177} :catchall_1d

    goto :goto_16f
.end method
