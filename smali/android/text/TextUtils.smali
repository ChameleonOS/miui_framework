.class public Landroid/text/TextUtils;
.super Ljava/lang/Object;
.source "TextUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/text/TextUtils$EllipsizeCallback;,
        Landroid/text/TextUtils$TruncateAt;,
        Landroid/text/TextUtils$Reverser;,
        Landroid/text/TextUtils$SimpleStringSplitter;,
        Landroid/text/TextUtils$StringSplitter;
    }
.end annotation


# static fields
.field public static final ABSOLUTE_SIZE_SPAN:I = 0x10

.field public static final ALIGNMENT_SPAN:I = 0x1

.field public static final ANNOTATION:I = 0x12

.field public static final BACKGROUND_COLOR_SPAN:I = 0xc

.field public static final BULLET_SPAN:I = 0x8

.field public static final CAP_MODE_CHARACTERS:I = 0x1000

.field public static final CAP_MODE_SENTENCES:I = 0x4000

.field public static final CAP_MODE_WORDS:I = 0x2000

.field public static final CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Ljava/lang/CharSequence;",
            ">;"
        }
    .end annotation
.end field

.field public static final EASY_EDIT_SPAN:I = 0x16

.field private static final ELLIPSIS_NORMAL:Ljava/lang/String; = null

.field private static final ELLIPSIS_TWO_DOTS:Ljava/lang/String; = null

.field private static EMPTY_STRING_ARRAY:[Ljava/lang/String; = null

.field private static final FIRST_RIGHT_TO_LEFT:C = '\u0590'

.field public static final FOREGROUND_COLOR_SPAN:I = 0x2

.field public static final LEADING_MARGIN_SPAN:I = 0xa

.field public static final QUOTE_SPAN:I = 0x9

.field public static final RELATIVE_SIZE_SPAN:I = 0x3

.field public static final SCALE_X_SPAN:I = 0x4

.field public static final SPELL_CHECK_SPAN:I = 0x14

.field public static final STRIKETHROUGH_SPAN:I = 0x5

.field public static final STYLE_SPAN:I = 0x7

.field public static final SUBSCRIPT_SPAN:I = 0xf

.field public static final SUGGESTION_RANGE_SPAN:I = 0x15

.field public static final SUGGESTION_SPAN:I = 0x13

.field public static final SUPERSCRIPT_SPAN:I = 0xe

.field public static final TEXT_APPEARANCE_SPAN:I = 0x11

.field public static final TYPEFACE_SPAN:I = 0xd

.field public static final UNDERLINE_SPAN:I = 0x6

.field public static final URL_SPAN:I = 0xb

.field private static final ZWNBS_CHAR:C = '\ufeff'

.field private static sLock:Ljava/lang/Object;

.field private static sTemp:[C


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 642
    new-instance v0, Landroid/text/TextUtils$1;

    invoke-direct {v0}, Landroid/text/TextUtils$1;-><init>()V

    sput-object v0, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    .line 1697
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/text/TextUtils;->sLock:Ljava/lang/Object;

    .line 1698
    const/4 v0, 0x0

    sput-object v0, Landroid/text/TextUtils;->sTemp:[C

    .line 1700
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    sput-object v0, Landroid/text/TextUtils;->EMPTY_STRING_ARRAY:[Ljava/lang/String;

    .line 1704
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x10400c4

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroid/text/TextUtils;->ELLIPSIS_NORMAL:Ljava/lang/String;

    .line 1706
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x10400c5

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroid/text/TextUtils;->ELLIPSIS_TWO_DOTS:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 57
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Landroid/os/Parcel;Landroid/text/Spannable;Ljava/lang/Object;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 55
    invoke-static {p0, p1, p2}, Landroid/text/TextUtils;->readSpan(Landroid/os/Parcel;Landroid/text/Spannable;Ljava/lang/Object;)V

    return-void
.end method

.method public static commaEllipsize(Ljava/lang/CharSequence;Landroid/text/TextPaint;FLjava/lang/String;Ljava/lang/String;)Ljava/lang/CharSequence;
    .registers 11
    .parameter "text"
    .parameter "p"
    .parameter "avail"
    .parameter "oneMore"
    .parameter "more"

    .prologue
    .line 1164
    sget-object v5, Landroid/text/TextDirectionHeuristics;->FIRSTSTRONG_LTR:Landroid/text/TextDirectionHeuristic;

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-static/range {v0 .. v5}, Landroid/text/TextUtils;->commaEllipsize(Ljava/lang/CharSequence;Landroid/text/TextPaint;FLjava/lang/String;Ljava/lang/String;Landroid/text/TextDirectionHeuristic;)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public static commaEllipsize(Ljava/lang/CharSequence;Landroid/text/TextPaint;FLjava/lang/String;Ljava/lang/String;Landroid/text/TextDirectionHeuristic;)Ljava/lang/CharSequence;
    .registers 28
    .parameter "text"
    .parameter "p"
    .parameter "avail"
    .parameter "oneMore"
    .parameter "more"
    .parameter "textDir"

    .prologue
    .line 1174
    invoke-static {}, Landroid/text/MeasuredText;->obtain()Landroid/text/MeasuredText;

    move-result-object v2

    .line 1176
    .local v2, mt:Landroid/text/MeasuredText;
    :try_start_4
    invoke-interface/range {p0 .. p0}, Ljava/lang/CharSequence;->length()I

    move-result v6

    .line 1177
    .local v6, len:I
    const/4 v5, 0x0

    move-object/from16 v3, p1

    move-object/from16 v4, p0

    move-object/from16 v7, p5

    invoke-static/range {v2 .. v7}, Landroid/text/TextUtils;->setPara(Landroid/text/MeasuredText;Landroid/text/TextPaint;Ljava/lang/CharSequence;IILandroid/text/TextDirectionHeuristic;)F
    :try_end_12
    .catchall {:try_start_4 .. :try_end_12} :catchall_d1

    move-result v20

    .line 1178
    .local v20, width:F
    cmpg-float v3, v20, p2

    if-gtz v3, :cond_1b

    .line 1232
    invoke-static {v2}, Landroid/text/MeasuredText;->recycle(Landroid/text/MeasuredText;)Landroid/text/MeasuredText;

    .end local p0
    :goto_1a
    return-object p0

    .line 1182
    .restart local p0
    :cond_1b
    :try_start_1b
    iget-object v8, v2, Landroid/text/MeasuredText;->mChars:[C

    .line 1184
    .local v8, buf:[C
    const/4 v9, 0x0

    .line 1185
    .local v9, commaCount:I
    const/4 v12, 0x0

    .local v12, i:I
    :goto_1f
    if-ge v12, v6, :cond_2c

    .line 1186
    aget-char v3, v8, v12

    const/16 v4, 0x2c

    if-ne v3, v4, :cond_29

    .line 1187
    add-int/lit8 v9, v9, 0x1

    .line 1185
    :cond_29
    add-int/lit8 v12, v12, 0x1

    goto :goto_1f

    .line 1191
    :cond_2c
    add-int/lit8 v17, v9, 0x1

    .line 1193
    .local v17, remaining:I
    const/4 v14, 0x0

    .line 1194
    .local v14, ok:I
    const-string v15, ""

    .line 1196
    .local v15, okFormat:Ljava/lang/String;
    const/16 v19, 0x0

    .line 1197
    .local v19, w:I
    const/4 v10, 0x0

    .line 1198
    .local v10, count:I
    iget-object v0, v2, Landroid/text/MeasuredText;->mWidths:[F

    move-object/from16 v21, v0

    .line 1200
    .local v21, widths:[F
    invoke-static {}, Landroid/text/MeasuredText;->obtain()Landroid/text/MeasuredText;

    move-result-object v18

    .line 1201
    .local v18, tempMt:Landroid/text/MeasuredText;
    const/4 v12, 0x0

    :goto_3d
    if-ge v12, v6, :cond_b7

    .line 1202
    move/from16 v0, v19

    int-to-float v3, v0

    aget v4, v21, v12

    add-float/2addr v3, v4

    float-to-int v0, v3

    move/from16 v19, v0

    .line 1204
    aget-char v3, v8, v12

    const/16 v4, 0x2c

    if-ne v3, v4, :cond_90

    .line 1205
    add-int/lit8 v10, v10, 0x1

    .line 1210
    add-int/lit8 v17, v17, -0x1

    const/4 v3, 0x1

    move/from16 v0, v17

    if-ne v0, v3, :cond_93

    .line 1211
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    .line 1217
    .local v11, format:Ljava/lang/String;
    :goto_6c
    const/4 v3, 0x0

    invoke-virtual {v11}, Ljava/lang/String;->length()I

    move-result v4

    move-object/from16 v0, v18

    move-object/from16 v1, p5

    invoke-virtual {v0, v11, v3, v4, v1}, Landroid/text/MeasuredText;->setPara(Ljava/lang/CharSequence;IILandroid/text/TextDirectionHeuristic;)V

    .line 1218
    move-object/from16 v0, v18

    iget v3, v0, Landroid/text/MeasuredText;->mLen:I

    const/4 v4, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v3, v4}, Landroid/text/MeasuredText;->addStyleRun(Landroid/text/TextPaint;ILandroid/graphics/Paint$FontMetricsInt;)F

    move-result v13

    .line 1220
    .local v13, moreWid:F
    move/from16 v0, v19

    int-to-float v3, v0

    add-float/2addr v3, v13

    cmpg-float v3, v3, p2

    if-gtz v3, :cond_90

    .line 1221
    add-int/lit8 v14, v12, 0x1

    .line 1222
    move-object v15, v11

    .line 1201
    .end local v11           #format:Ljava/lang/String;
    .end local v13           #moreWid:F
    :cond_90
    add-int/lit8 v12, v12, 0x1

    goto :goto_3d

    .line 1213
    :cond_93
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v4, v5

    move-object/from16 v0, p4

    invoke-static {v0, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    .restart local v11       #format:Ljava/lang/String;
    goto :goto_6c

    .line 1226
    .end local v11           #format:Ljava/lang/String;
    :cond_b7
    invoke-static/range {v18 .. v18}, Landroid/text/MeasuredText;->recycle(Landroid/text/MeasuredText;)Landroid/text/MeasuredText;

    .line 1228
    new-instance v16, Landroid/text/SpannableStringBuilder;

    move-object/from16 v0, v16

    invoke-direct {v0, v15}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 1229
    .local v16, out:Landroid/text/SpannableStringBuilder;
    const/4 v3, 0x0

    const/4 v4, 0x0

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    invoke-virtual {v0, v3, v1, v4, v14}, Landroid/text/SpannableStringBuilder;->insert(ILjava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;
    :try_end_ca
    .catchall {:try_start_1b .. :try_end_ca} :catchall_d1

    .line 1232
    invoke-static {v2}, Landroid/text/MeasuredText;->recycle(Landroid/text/MeasuredText;)Landroid/text/MeasuredText;

    move-object/from16 p0, v16

    goto/16 :goto_1a

    .end local v6           #len:I
    .end local v8           #buf:[C
    .end local v9           #commaCount:I
    .end local v10           #count:I
    .end local v12           #i:I
    .end local v14           #ok:I
    .end local v15           #okFormat:Ljava/lang/String;
    .end local v16           #out:Landroid/text/SpannableStringBuilder;
    .end local v17           #remaining:I
    .end local v18           #tempMt:Landroid/text/MeasuredText;
    .end local v19           #w:I
    .end local v20           #width:F
    .end local v21           #widths:[F
    :catchall_d1
    move-exception v3

    invoke-static {v2}, Landroid/text/MeasuredText;->recycle(Landroid/text/MeasuredText;)Landroid/text/MeasuredText;

    throw v3
.end method

.method public static varargs concat([Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    .registers 10
    .parameter "text"

    .prologue
    const/4 v1, 0x0

    .line 1349
    array-length v0, p0

    if-nez v0, :cond_7

    .line 1350
    const-string v0, ""

    .line 1386
    :goto_6
    return-object v0

    .line 1353
    :cond_7
    array-length v0, p0

    const/4 v3, 0x1

    if-ne v0, v3, :cond_e

    .line 1354
    aget-object v0, p0, v1

    goto :goto_6

    .line 1357
    :cond_e
    const/4 v8, 0x0

    .line 1358
    .local v8, spanned:Z
    const/4 v6, 0x0

    .local v6, i:I
    :goto_10
    array-length v0, p0

    if-ge v6, v0, :cond_1a

    .line 1359
    aget-object v0, p0, v6

    instance-of v0, v0, Landroid/text/Spanned;

    if-eqz v0, :cond_2b

    .line 1360
    const/4 v8, 0x1

    .line 1365
    :cond_1a
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 1366
    .local v7, sb:Ljava/lang/StringBuilder;
    const/4 v6, 0x0

    :goto_20
    array-length v0, p0

    if-ge v6, v0, :cond_2e

    .line 1367
    aget-object v0, p0, v6

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    .line 1366
    add-int/lit8 v6, v6, 0x1

    goto :goto_20

    .line 1358
    .end local v7           #sb:Ljava/lang/StringBuilder;
    :cond_2b
    add-int/lit8 v6, v6, 0x1

    goto :goto_10

    .line 1370
    .restart local v7       #sb:Ljava/lang/StringBuilder;
    :cond_2e
    if-nez v8, :cond_35

    .line 1371
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_6

    .line 1374
    :cond_35
    new-instance v4, Landroid/text/SpannableString;

    invoke-direct {v4, v7}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 1375
    .local v4, ss:Landroid/text/SpannableString;
    const/4 v5, 0x0

    .line 1376
    .local v5, off:I
    const/4 v6, 0x0

    :goto_3c
    array-length v0, p0

    if-ge v6, v0, :cond_58

    .line 1377
    aget-object v0, p0, v6

    invoke-interface {v0}, Ljava/lang/CharSequence;->length()I

    move-result v2

    .line 1379
    .local v2, len:I
    aget-object v0, p0, v6

    instance-of v0, v0, Landroid/text/Spanned;

    if-eqz v0, :cond_54

    .line 1380
    aget-object v0, p0, v6

    check-cast v0, Landroid/text/Spanned;

    const-class v3, Ljava/lang/Object;

    invoke-static/range {v0 .. v5}, Landroid/text/TextUtils;->copySpansFrom(Landroid/text/Spanned;IILjava/lang/Class;Landroid/text/Spannable;I)V

    .line 1383
    :cond_54
    add-int/2addr v5, v2

    .line 1376
    add-int/lit8 v6, v6, 0x1

    goto :goto_3c

    .line 1386
    .end local v2           #len:I
    :cond_58
    new-instance v0, Landroid/text/SpannedString;

    invoke-direct {v0, v4}, Landroid/text/SpannedString;-><init>(Ljava/lang/CharSequence;)V

    goto :goto_6
.end method

.method public static copySpansFrom(Landroid/text/Spanned;IILjava/lang/Class;Landroid/text/Spannable;I)V
    .registers 14
    .parameter "source"
    .parameter "start"
    .parameter "end"
    .parameter "kind"
    .parameter "dest"
    .parameter "destoff"

    .prologue
    .line 976
    if-nez p3, :cond_4

    .line 977
    const-class p3, Ljava/lang/Object;

    .line 980
    :cond_4
    invoke-interface {p0, p1, p2, p3}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v3

    .line 982
    .local v3, spans:[Ljava/lang/Object;
    const/4 v2, 0x0

    .local v2, i:I
    :goto_9
    array-length v5, v3

    if-ge v2, v5, :cond_32

    .line 983
    aget-object v5, v3, v2

    invoke-interface {p0, v5}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v4

    .line 984
    .local v4, st:I
    aget-object v5, v3, v2

    invoke-interface {p0, v5}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v0

    .line 985
    .local v0, en:I
    aget-object v5, v3, v2

    invoke-interface {p0, v5}, Landroid/text/Spanned;->getSpanFlags(Ljava/lang/Object;)I

    move-result v1

    .line 987
    .local v1, fl:I
    if-ge v4, p1, :cond_21

    .line 988
    move v4, p1

    .line 989
    :cond_21
    if-le v0, p2, :cond_24

    .line 990
    move v0, p2

    .line 992
    :cond_24
    aget-object v5, v3, v2

    sub-int v6, v4, p1

    add-int/2addr v6, p5

    sub-int v7, v0, p1

    add-int/2addr v7, p5

    invoke-interface {p4, v5, v6, v7, v1}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    .line 982
    add-int/lit8 v2, v2, 0x1

    goto :goto_9

    .line 995
    .end local v0           #en:I
    .end local v1           #fl:I
    .end local v4           #st:I
    :cond_32
    return-void
.end method

.method public static delimitedStringContains(Ljava/lang/String;CLjava/lang/String;)Z
    .registers 9
    .parameter "delimitedString"
    .parameter "delimiter"
    .parameter "item"

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 1596
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_e

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_10

    :cond_e
    move v3, v4

    .line 1614
    :cond_f
    :goto_f
    return v3

    .line 1599
    :cond_10
    const/4 v2, -0x1

    .line 1600
    .local v2, pos:I
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    .line 1601
    .local v1, length:I
    :cond_15
    add-int/lit8 v5, v2, 0x1

    invoke-virtual {p0, p2, v5}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v2

    const/4 v5, -0x1

    if-eq v2, v5, :cond_37

    .line 1602
    if-lez v2, :cond_28

    add-int/lit8 v5, v2, -0x1

    invoke-virtual {p0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v5

    if-ne v5, p1, :cond_15

    .line 1605
    :cond_28
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v5

    add-int v0, v2, v5

    .line 1606
    .local v0, expectedDelimiterPos:I
    if-eq v0, v1, :cond_f

    .line 1610
    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v5

    if-ne v5, p1, :cond_15

    goto :goto_f

    .end local v0           #expectedDelimiterPos:I
    :cond_37
    move v3, v4

    .line 1614
    goto :goto_f
.end method

.method static doesNotNeedBidi(Ljava/lang/CharSequence;II)Z
    .registers 6
    .parameter "s"
    .parameter "start"
    .parameter "end"

    .prologue
    .line 1266
    move v0, p1

    .local v0, i:I
    :goto_1
    if-ge v0, p2, :cond_10

    .line 1267
    invoke-interface {p0, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    const/16 v2, 0x590

    if-lt v1, v2, :cond_d

    .line 1268
    const/4 v1, 0x0

    .line 1271
    :goto_c
    return v1

    .line 1266
    :cond_d
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1271
    :cond_10
    const/4 v1, 0x1

    goto :goto_c
.end method

.method static doesNotNeedBidi([CII)Z
    .registers 7
    .parameter "text"
    .parameter "start"
    .parameter "len"

    .prologue
    .line 1276
    move v1, p1

    .local v1, i:I
    add-int v0, v1, p2

    .local v0, e:I
    :goto_3
    if-ge v1, v0, :cond_10

    .line 1277
    aget-char v2, p0, v1

    const/16 v3, 0x590

    if-lt v2, v3, :cond_d

    .line 1278
    const/4 v2, 0x0

    .line 1281
    :goto_c
    return v2

    .line 1276
    :cond_d
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 1281
    :cond_10
    const/4 v2, 0x1

    goto :goto_c
.end method

.method public static dumpSpans(Ljava/lang/CharSequence;Landroid/util/Printer;Ljava/lang/String;)V
    .registers 10
    .parameter "cs"
    .parameter "printer"
    .parameter "prefix"

    .prologue
    .line 777
    instance-of v4, p0, Landroid/text/Spanned;

    if-eqz v4, :cond_89

    move-object v3, p0

    .line 778
    check-cast v3, Landroid/text/Spanned;

    .line 779
    .local v3, sp:Landroid/text/Spanned;
    const/4 v4, 0x0

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v5

    const-class v6, Ljava/lang/Object;

    invoke-interface {v3, v4, v5, v6}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v2

    .line 781
    .local v2, os:[Ljava/lang/Object;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_13
    array-length v4, v2

    if-ge v0, v4, :cond_a3

    .line 782
    aget-object v1, v2, v0

    .line 783
    .local v1, o:Ljava/lang/Object;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v3, v1}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v5

    invoke-interface {v3, v1}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v6

    invoke-interface {p0, v5, v6}, Ljava/lang/CharSequence;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ": "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {v1}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " ("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v3, v1}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "-"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v3, v1}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ") fl=#"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v3, v1}, Landroid/text/Spanned;->getSpanFlags(Ljava/lang/Object;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v4}, Landroid/util/Printer;->println(Ljava/lang/String;)V

    .line 781
    add-int/lit8 v0, v0, 0x1

    goto :goto_13

    .line 791
    .end local v0           #i:I
    .end local v1           #o:Ljava/lang/Object;
    .end local v2           #os:[Ljava/lang/Object;
    .end local v3           #sp:Landroid/text/Spanned;
    :cond_89
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ": (no spans)"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v4}, Landroid/util/Printer;->println(Ljava/lang/String;)V

    .line 793
    :cond_a3
    return-void
.end method

.method public static ellipsize(Ljava/lang/CharSequence;Landroid/text/TextPaint;FLandroid/text/TextUtils$TruncateAt;)Ljava/lang/CharSequence;
    .registers 10
    .parameter "text"
    .parameter "p"
    .parameter "avail"
    .parameter "where"

    .prologue
    .line 1025
    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    invoke-static/range {v0 .. v5}, Landroid/text/TextUtils;->ellipsize(Ljava/lang/CharSequence;Landroid/text/TextPaint;FLandroid/text/TextUtils$TruncateAt;ZLandroid/text/TextUtils$EllipsizeCallback;)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public static ellipsize(Ljava/lang/CharSequence;Landroid/text/TextPaint;FLandroid/text/TextUtils$TruncateAt;ZLandroid/text/TextUtils$EllipsizeCallback;)Ljava/lang/CharSequence;
    .registers 14
    .parameter "text"
    .parameter "paint"
    .parameter "avail"
    .parameter "where"
    .parameter "preserveLength"
    .parameter "callback"

    .prologue
    .line 1045
    sget-object v6, Landroid/text/TextDirectionHeuristics;->FIRSTSTRONG_LTR:Landroid/text/TextDirectionHeuristic;

    sget-object v0, Landroid/text/TextUtils$TruncateAt;->END_SMALL:Landroid/text/TextUtils$TruncateAt;

    if-ne p3, v0, :cond_13

    sget-object v7, Landroid/text/TextUtils;->ELLIPSIS_TWO_DOTS:Ljava/lang/String;

    :goto_8
    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move v4, p4

    move-object v5, p5

    invoke-static/range {v0 .. v7}, Landroid/text/TextUtils;->ellipsize(Ljava/lang/CharSequence;Landroid/text/TextPaint;FLandroid/text/TextUtils$TruncateAt;ZLandroid/text/TextUtils$EllipsizeCallback;Landroid/text/TextDirectionHeuristic;Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0

    :cond_13
    sget-object v7, Landroid/text/TextUtils;->ELLIPSIS_NORMAL:Ljava/lang/String;

    goto :goto_8
.end method

.method public static ellipsize(Ljava/lang/CharSequence;Landroid/text/TextPaint;FLandroid/text/TextUtils$TruncateAt;ZLandroid/text/TextUtils$EllipsizeCallback;Landroid/text/TextDirectionHeuristic;Ljava/lang/String;)Ljava/lang/CharSequence;
    .registers 30
    .parameter "text"
    .parameter "paint"
    .parameter "avail"
    .parameter "where"
    .parameter "preserveLength"
    .parameter "callback"
    .parameter "textDir"
    .parameter "ellipsis"

    .prologue
    .line 1070
    invoke-interface/range {p0 .. p0}, Ljava/lang/CharSequence;->length()I

    move-result v15

    .line 1072
    .local v15, len:I
    invoke-static {}, Landroid/text/MeasuredText;->obtain()Landroid/text/MeasuredText;

    move-result-object v3

    .line 1074
    .local v3, mt:Landroid/text/MeasuredText;
    const/4 v6, 0x0

    :try_start_9
    invoke-interface/range {p0 .. p0}, Ljava/lang/CharSequence;->length()I

    move-result v7

    move-object/from16 v4, p1

    move-object/from16 v5, p0

    move-object/from16 v8, p6

    invoke-static/range {v3 .. v8}, Landroid/text/TextUtils;->setPara(Landroid/text/MeasuredText;Landroid/text/TextPaint;Ljava/lang/CharSequence;IILandroid/text/TextDirectionHeuristic;)F

    move-result v21

    .line 1076
    .local v21, width:F
    cmpg-float v5, v21, p2

    if-gtz v5, :cond_28

    .line 1077
    if-eqz p5, :cond_24

    .line 1078
    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-interface {v0, v5, v6}, Landroid/text/TextUtils$EllipsizeCallback;->ellipsized(II)V
    :try_end_24
    .catchall {:try_start_9 .. :try_end_24} :catchall_13a

    .line 1145
    :cond_24
    invoke-static {v3}, Landroid/text/MeasuredText;->recycle(Landroid/text/MeasuredText;)Landroid/text/MeasuredText;

    .end local p0
    :goto_27
    return-object p0

    .line 1086
    .restart local p0
    :cond_28
    :try_start_28
    move-object/from16 v0, p1

    move-object/from16 v1, p7

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F

    move-result v11

    .line 1087
    .local v11, ellipsiswid:F
    sub-float p2, p2, v11

    .line 1089
    const/4 v13, 0x0

    .line 1090
    .local v13, left:I
    move/from16 v17, v15

    .line 1091
    .local v17, right:I
    const/4 v5, 0x0

    cmpg-float v5, p2, v5

    if-gez v5, :cond_72

    move v14, v13

    .line 1103
    .end local v13           #left:I
    .local v14, left:I
    :goto_3b
    if-eqz p5, :cond_44

    .line 1104
    move-object/from16 v0, p5

    move/from16 v1, v17

    invoke-interface {v0, v14, v1}, Landroid/text/TextUtils$EllipsizeCallback;->ellipsized(II)V

    .line 1107
    :cond_44
    iget-object v10, v3, Landroid/text/MeasuredText;->mChars:[C

    .line 1108
    .local v10, buf:[C
    move-object/from16 v0, p0

    instance-of v5, v0, Landroid/text/Spanned;

    if-eqz v5, :cond_b6

    move-object/from16 v0, p0

    check-cast v0, Landroid/text/Spanned;

    move-object v5, v0

    move-object v4, v5

    .line 1110
    .local v4, sp:Landroid/text/Spanned;
    :goto_52
    sub-int v5, v17, v14

    sub-int v16, v15, v5

    .line 1111
    .local v16, remaining:I
    if-eqz p4, :cond_df

    .line 1112
    if-lez v16, :cond_13f

    .line 1113
    add-int/lit8 v13, v14, 0x1

    .end local v14           #left:I
    .restart local v13       #left:I
    const/4 v5, 0x0

    move-object/from16 v0, p7

    invoke-virtual {v0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v5

    aput-char v5, v10, v14

    .line 1115
    :goto_65
    move v12, v13

    .local v12, i:I
    :goto_66
    move/from16 v0, v17

    if-ge v12, v0, :cond_b8

    .line 1116
    const v5, 0xfeff

    aput-char v5, v10, v12

    .line 1115
    add-int/lit8 v12, v12, 0x1

    goto :goto_66

    .line 1093
    .end local v4           #sp:Landroid/text/Spanned;
    .end local v10           #buf:[C
    .end local v12           #i:I
    .end local v16           #remaining:I
    :cond_72
    sget-object v5, Landroid/text/TextUtils$TruncateAt;->START:Landroid/text/TextUtils$TruncateAt;

    move-object/from16 v0, p3

    if-ne v0, v5, :cond_83

    .line 1094
    const/4 v5, 0x0

    move/from16 v0, p2

    invoke-virtual {v3, v15, v5, v0}, Landroid/text/MeasuredText;->breakText(IZF)I

    move-result v5

    sub-int v17, v15, v5

    move v14, v13

    .end local v13           #left:I
    .restart local v14       #left:I
    goto :goto_3b

    .line 1095
    .end local v14           #left:I
    .restart local v13       #left:I
    :cond_83
    sget-object v5, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    move-object/from16 v0, p3

    if-eq v0, v5, :cond_8f

    sget-object v5, Landroid/text/TextUtils$TruncateAt;->END_SMALL:Landroid/text/TextUtils$TruncateAt;

    move-object/from16 v0, p3

    if-ne v0, v5, :cond_98

    .line 1096
    :cond_8f
    const/4 v5, 0x1

    move/from16 v0, p2

    invoke-virtual {v3, v15, v5, v0}, Landroid/text/MeasuredText;->breakText(IZF)I

    move-result v13

    move v14, v13

    .end local v13           #left:I
    .restart local v14       #left:I
    goto :goto_3b

    .line 1098
    .end local v14           #left:I
    .restart local v13       #left:I
    :cond_98
    const/4 v5, 0x0

    const/high16 v6, 0x4000

    div-float v6, p2, v6

    invoke-virtual {v3, v15, v5, v6}, Landroid/text/MeasuredText;->breakText(IZF)I

    move-result v5

    sub-int v17, v15, v5

    .line 1099
    move/from16 v0, v17

    invoke-virtual {v3, v0, v15}, Landroid/text/MeasuredText;->measure(II)F

    move-result v5

    sub-float p2, p2, v5

    .line 1100
    const/4 v5, 0x1

    move/from16 v0, v17

    move/from16 v1, p2

    invoke-virtual {v3, v0, v5, v1}, Landroid/text/MeasuredText;->breakText(IZF)I

    move-result v13

    move v14, v13

    .end local v13           #left:I
    .restart local v14       #left:I
    goto :goto_3b

    .line 1108
    .restart local v10       #buf:[C
    :cond_b6
    const/4 v4, 0x0

    goto :goto_52

    .line 1118
    .end local v14           #left:I
    .restart local v4       #sp:Landroid/text/Spanned;
    .restart local v12       #i:I
    .restart local v13       #left:I
    .restart local v16       #remaining:I
    :cond_b8
    new-instance v18, Ljava/lang/String;

    const/4 v5, 0x0

    move-object/from16 v0, v18

    invoke-direct {v0, v10, v5, v15}, Ljava/lang/String;-><init>([CII)V
    :try_end_c0
    .catchall {:try_start_28 .. :try_end_c0} :catchall_13a

    .line 1119
    .local v18, s:Ljava/lang/String;
    if-nez v4, :cond_c9

    .line 1145
    invoke-static {v3}, Landroid/text/MeasuredText;->recycle(Landroid/text/MeasuredText;)Landroid/text/MeasuredText;

    move-object/from16 p0, v18

    goto/16 :goto_27

    .line 1122
    :cond_c9
    :try_start_c9
    new-instance v8, Landroid/text/SpannableString;

    move-object/from16 v0, v18

    invoke-direct {v8, v0}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 1123
    .local v8, ss:Landroid/text/SpannableString;
    const/4 v5, 0x0

    const-class v7, Ljava/lang/Object;

    const/4 v9, 0x0

    move v6, v15

    invoke-static/range {v4 .. v9}, Landroid/text/TextUtils;->copySpansFrom(Landroid/text/Spanned;IILjava/lang/Class;Landroid/text/Spannable;I)V
    :try_end_d8
    .catchall {:try_start_c9 .. :try_end_d8} :catchall_13a

    .line 1145
    invoke-static {v3}, Landroid/text/MeasuredText;->recycle(Landroid/text/MeasuredText;)Landroid/text/MeasuredText;

    move-object/from16 p0, v8

    goto/16 :goto_27

    .line 1127
    .end local v8           #ss:Landroid/text/SpannableString;
    .end local v12           #i:I
    .end local v13           #left:I
    .end local v18           #s:Ljava/lang/String;
    .restart local v14       #left:I
    :cond_df
    if-nez v16, :cond_e8

    .line 1128
    :try_start_e1
    const-string p0, ""
    :try_end_e3
    .catchall {:try_start_e1 .. :try_end_e3} :catchall_13a

    .line 1145
    .end local p0
    invoke-static {v3}, Landroid/text/MeasuredText;->recycle(Landroid/text/MeasuredText;)Landroid/text/MeasuredText;

    goto/16 :goto_27

    .line 1131
    .restart local p0
    :cond_e8
    if-nez v4, :cond_116

    .line 1132
    :try_start_ea
    new-instance v19, Ljava/lang/StringBuilder;

    invoke-virtual/range {p7 .. p7}, Ljava/lang/String;->length()I

    move-result v5

    add-int v5, v5, v16

    move-object/from16 v0, v19

    invoke-direct {v0, v5}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 1133
    .local v19, sb:Ljava/lang/StringBuilder;
    const/4 v5, 0x0

    move-object/from16 v0, v19

    invoke-virtual {v0, v10, v5, v14}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;

    .line 1134
    move-object/from16 v0, v19

    move-object/from16 v1, p7

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1135
    sub-int v5, v15, v17

    move-object/from16 v0, v19

    move/from16 v1, v17

    invoke-virtual {v0, v10, v1, v5}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;

    .line 1136
    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_110
    .catchall {:try_start_ea .. :try_end_110} :catchall_13a

    move-result-object p0

    .line 1145
    .end local p0
    invoke-static {v3}, Landroid/text/MeasuredText;->recycle(Landroid/text/MeasuredText;)Landroid/text/MeasuredText;

    goto/16 :goto_27

    .line 1139
    .end local v19           #sb:Ljava/lang/StringBuilder;
    .restart local p0
    :cond_116
    :try_start_116
    new-instance v20, Landroid/text/SpannableStringBuilder;

    invoke-direct/range {v20 .. v20}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 1140
    .local v20, ssb:Landroid/text/SpannableStringBuilder;
    const/4 v5, 0x0

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-virtual {v0, v1, v5, v14}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;

    .line 1141
    move-object/from16 v0, v20

    move-object/from16 v1, p7

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 1142
    move-object/from16 v0, v20

    move-object/from16 v1, p0

    move/from16 v2, v17

    invoke-virtual {v0, v1, v2, v15}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;
    :try_end_133
    .catchall {:try_start_116 .. :try_end_133} :catchall_13a

    .line 1145
    invoke-static {v3}, Landroid/text/MeasuredText;->recycle(Landroid/text/MeasuredText;)Landroid/text/MeasuredText;

    move-object/from16 p0, v20

    goto/16 :goto_27

    .end local v4           #sp:Landroid/text/Spanned;
    .end local v10           #buf:[C
    .end local v11           #ellipsiswid:F
    .end local v14           #left:I
    .end local v16           #remaining:I
    .end local v17           #right:I
    .end local v20           #ssb:Landroid/text/SpannableStringBuilder;
    .end local v21           #width:F
    :catchall_13a
    move-exception v5

    invoke-static {v3}, Landroid/text/MeasuredText;->recycle(Landroid/text/MeasuredText;)Landroid/text/MeasuredText;

    throw v5

    .restart local v4       #sp:Landroid/text/Spanned;
    .restart local v10       #buf:[C
    .restart local v11       #ellipsiswid:F
    .restart local v14       #left:I
    .restart local v16       #remaining:I
    .restart local v17       #right:I
    .restart local v21       #width:F
    :cond_13f
    move v13, v14

    .end local v14           #left:I
    .restart local v13       #left:I
    goto/16 :goto_65
.end method

.method public static equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    .registers 8
    .parameter "a"
    .parameter "b"

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 476
    if-ne p0, p1, :cond_5

    .line 488
    :cond_4
    :goto_4
    return v2

    .line 478
    :cond_5
    if-eqz p0, :cond_32

    if-eqz p1, :cond_32

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v1

    .local v1, length:I
    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v4

    if-ne v1, v4, :cond_32

    .line 479
    instance-of v4, p0, Ljava/lang/String;

    if-eqz v4, :cond_20

    instance-of v4, p1, Ljava/lang/String;

    if-eqz v4, :cond_20

    .line 480
    invoke-virtual {p0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    goto :goto_4

    .line 482
    :cond_20
    const/4 v0, 0x0

    .local v0, i:I
    :goto_21
    if-ge v0, v1, :cond_4

    .line 483
    invoke-interface {p0, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v4

    invoke-interface {p1, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v5

    if-eq v4, v5, :cond_2f

    move v2, v3

    goto :goto_4

    .line 482
    :cond_2f
    add-int/lit8 v0, v0, 0x1

    goto :goto_21

    .end local v0           #i:I
    .end local v1           #length:I
    :cond_32
    move v2, v3

    .line 488
    goto :goto_4
.end method

.method public static varargs expandTemplate(Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    .registers 9
    .parameter "template"
    .parameter "values"

    .prologue
    const/16 v6, 0x5e

    .line 847
    array-length v4, p1

    const/16 v5, 0x9

    if-le v4, v5, :cond_10

    .line 848
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v5, "max of 9 values are supported"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 851
    :cond_10
    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2, p0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 854
    .local v2, ssb:Landroid/text/SpannableStringBuilder;
    const/4 v0, 0x0

    .line 855
    .local v0, i:I
    :goto_16
    :try_start_16
    invoke-virtual {v2}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v4

    if-ge v0, v4, :cond_5f

    .line 856
    invoke-virtual {v2, v0}, Landroid/text/SpannableStringBuilder;->charAt(I)C

    move-result v4

    if-ne v4, v6, :cond_a0

    .line 857
    add-int/lit8 v4, v0, 0x1

    invoke-virtual {v2, v4}, Landroid/text/SpannableStringBuilder;->charAt(I)C

    move-result v1

    .line 858
    .local v1, next:C
    if-ne v1, v6, :cond_34

    .line 859
    add-int/lit8 v4, v0, 0x1

    add-int/lit8 v5, v0, 0x2

    invoke-virtual {v2, v4, v5}, Landroid/text/SpannableStringBuilder;->delete(II)Landroid/text/SpannableStringBuilder;

    .line 860
    add-int/lit8 v0, v0, 0x1

    .line 861
    goto :goto_16

    .line 862
    :cond_34
    invoke-static {v1}, Ljava/lang/Character;->isDigit(C)Z

    move-result v4

    if-eqz v4, :cond_a0

    .line 863
    invoke-static {v1}, Ljava/lang/Character;->getNumericValue(C)I

    move-result v4

    add-int/lit8 v3, v4, -0x1

    .line 864
    .local v3, which:I
    if-gez v3, :cond_60

    .line 865
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "template requests value ^"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    add-int/lit8 v6, v3, 0x1

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 880
    .end local v1           #next:C
    .end local v3           #which:I
    :catch_5e
    move-exception v4

    .line 883
    :cond_5f
    return-object v2

    .line 868
    .restart local v1       #next:C
    .restart local v3       #which:I
    :cond_60
    array-length v4, p1

    if-lt v3, v4, :cond_90

    .line 869
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "template requests value ^"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    add-int/lit8 v6, v3, 0x1

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "; only "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    array-length v6, p1

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " provided"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 873
    :cond_90
    add-int/lit8 v4, v0, 0x2

    aget-object v5, p1, v3

    invoke-virtual {v2, v0, v4, v5}, Landroid/text/SpannableStringBuilder;->replace(IILjava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 874
    aget-object v4, p1, v3

    invoke-interface {v4}, Ljava/lang/CharSequence;->length()I
    :try_end_9c
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_16 .. :try_end_9c} :catch_5e

    move-result v4

    add-int/2addr v0, v4

    .line 875
    goto/16 :goto_16

    .line 878
    .end local v1           #next:C
    .end local v3           #which:I
    :cond_a0
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_16
.end method

.method public static getCapsMode(Ljava/lang/CharSequence;II)I
    .registers 13
    .parameter "cs"
    .parameter "off"
    .parameter "reqModes"

    .prologue
    const/16 v9, 0x27

    const/16 v8, 0x22

    const/16 v7, 0x2e

    .line 1500
    if-gez p1, :cond_a

    .line 1501
    const/4 v4, 0x0

    .line 1585
    :cond_9
    :goto_9
    return v4

    .line 1506
    :cond_a
    const/4 v4, 0x0

    .line 1508
    .local v4, mode:I
    and-int/lit16 v5, p2, 0x1000

    if-eqz v5, :cond_11

    .line 1509
    or-int/lit16 v4, v4, 0x1000

    .line 1511
    :cond_11
    and-int/lit16 v5, p2, 0x6000

    if-eqz v5, :cond_9

    .line 1517
    move v1, p1

    .local v1, i:I
    :goto_16
    if-lez v1, :cond_2a

    .line 1518
    add-int/lit8 v5, v1, -0x1

    invoke-interface {p0, v5}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 1520
    .local v0, c:C
    if-eq v0, v8, :cond_3e

    if-eq v0, v9, :cond_3e

    invoke-static {v0}, Ljava/lang/Character;->getType(C)I

    move-result v5

    const/16 v6, 0x15

    if-eq v5, v6, :cond_3e

    .line 1528
    .end local v0           #c:C
    :cond_2a
    move v2, v1

    .line 1529
    .local v2, j:I
    :goto_2b
    if-lez v2, :cond_41

    add-int/lit8 v5, v2, -0x1

    invoke-interface {p0, v5}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .restart local v0       #c:C
    const/16 v5, 0x20

    if-eq v0, v5, :cond_3b

    const/16 v5, 0x9

    if-ne v0, v5, :cond_41

    .line 1530
    :cond_3b
    add-int/lit8 v2, v2, -0x1

    goto :goto_2b

    .line 1517
    .end local v2           #j:I
    :cond_3e
    add-int/lit8 v1, v1, -0x1

    goto :goto_16

    .line 1532
    .end local v0           #c:C
    .restart local v2       #j:I
    :cond_41
    if-eqz v2, :cond_4d

    add-int/lit8 v5, v2, -0x1

    invoke-interface {p0, v5}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v5

    const/16 v6, 0xa

    if-ne v5, v6, :cond_50

    .line 1533
    :cond_4d
    or-int/lit16 v4, v4, 0x2000

    goto :goto_9

    .line 1538
    :cond_50
    and-int/lit16 v5, p2, 0x4000

    if-nez v5, :cond_59

    .line 1539
    if-eq v1, v2, :cond_9

    or-int/lit16 v4, v4, 0x2000

    goto :goto_9

    .line 1545
    :cond_59
    if-eq v1, v2, :cond_9

    .line 1551
    :goto_5b
    if-lez v2, :cond_6f

    .line 1552
    add-int/lit8 v5, v2, -0x1

    invoke-interface {p0, v5}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 1554
    .restart local v0       #c:C
    if-eq v0, v8, :cond_97

    if-eq v0, v9, :cond_97

    invoke-static {v0}, Ljava/lang/Character;->getType(C)I

    move-result v5

    const/16 v6, 0x16

    if-eq v5, v6, :cond_97

    .line 1560
    .end local v0           #c:C
    :cond_6f
    if-lez v2, :cond_9

    .line 1561
    add-int/lit8 v5, v2, -0x1

    invoke-interface {p0, v5}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 1563
    .restart local v0       #c:C
    if-eq v0, v7, :cond_81

    const/16 v5, 0x3f

    if-eq v0, v5, :cond_81

    const/16 v5, 0x21

    if-ne v0, v5, :cond_9

    .line 1567
    :cond_81
    if-ne v0, v7, :cond_93

    .line 1568
    add-int/lit8 v3, v2, -0x2

    .local v3, k:I
    :goto_85
    if-ltz v3, :cond_93

    .line 1569
    invoke-interface {p0, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 1571
    if-eq v0, v7, :cond_9

    .line 1575
    invoke-static {v0}, Ljava/lang/Character;->isLetter(C)Z

    move-result v5

    if-nez v5, :cond_9a

    .line 1581
    .end local v3           #k:I
    :cond_93
    or-int/lit16 v4, v4, 0x4000

    goto/16 :goto_9

    .line 1551
    :cond_97
    add-int/lit8 v2, v2, -0x1

    goto :goto_5b

    .line 1568
    .restart local v3       #k:I
    :cond_9a
    add-int/lit8 v3, v3, -0x1

    goto :goto_85
.end method

.method public static getChars(Ljava/lang/CharSequence;II[CI)V
    .registers 9
    .parameter "s"
    .parameter "start"
    .parameter "end"
    .parameter "dest"
    .parameter "destoff"

    .prologue
    .line 61
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 63
    .local v0, c:Ljava/lang/Class;,"Ljava/lang/Class<+Ljava/lang/CharSequence;>;"
    const-class v3, Ljava/lang/String;

    if-ne v0, v3, :cond_e

    .line 64
    check-cast p0, Ljava/lang/String;

    .end local p0
    invoke-virtual {p0, p1, p2, p3, p4}, Ljava/lang/String;->getChars(II[CI)V

    .line 75
    :goto_d
    return-void

    .line 65
    .restart local p0
    :cond_e
    const-class v3, Ljava/lang/StringBuffer;

    if-ne v0, v3, :cond_18

    .line 66
    check-cast p0, Ljava/lang/StringBuffer;

    .end local p0
    invoke-virtual {p0, p1, p2, p3, p4}, Ljava/lang/StringBuffer;->getChars(II[CI)V

    goto :goto_d

    .line 67
    .restart local p0
    :cond_18
    const-class v3, Ljava/lang/StringBuilder;

    if-ne v0, v3, :cond_22

    .line 68
    check-cast p0, Ljava/lang/StringBuilder;

    .end local p0
    invoke-virtual {p0, p1, p2, p3, p4}, Ljava/lang/StringBuilder;->getChars(II[CI)V

    goto :goto_d

    .line 69
    .restart local p0
    :cond_22
    instance-of v3, p0, Landroid/text/GetChars;

    if-eqz v3, :cond_2c

    .line 70
    check-cast p0, Landroid/text/GetChars;

    .end local p0
    invoke-interface {p0, p1, p2, p3, p4}, Landroid/text/GetChars;->getChars(II[CI)V

    goto :goto_d

    .line 72
    .restart local p0
    :cond_2c
    move v2, p1

    .local v2, i:I
    move v1, p4

    .end local p4
    .local v1, destoff:I
    :goto_2e
    if-ge v2, p2, :cond_3c

    .line 73
    add-int/lit8 p4, v1, 0x1

    .end local v1           #destoff:I
    .restart local p4
    invoke-interface {p0, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    aput-char v3, p3, v1

    .line 72
    add-int/lit8 v2, v2, 0x1

    move v1, p4

    .end local p4
    .restart local v1       #destoff:I
    goto :goto_2e

    :cond_3c
    move p4, v1

    .end local v1           #destoff:I
    .restart local p4
    goto :goto_d
.end method

.method public static getOffsetAfter(Ljava/lang/CharSequence;I)I
    .registers 11
    .parameter "text"
    .parameter "offset"

    .prologue
    .line 922
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v4

    .line 924
    .local v4, len:I
    if-ne p1, v4, :cond_7

    .line 955
    .end local v4           #len:I
    :cond_6
    :goto_6
    return v4

    .line 926
    .restart local v4       #len:I
    :cond_7
    add-int/lit8 v7, v4, -0x1

    if-eq p1, v7, :cond_6

    .line 929
    invoke-interface {p0, p1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 931
    .local v0, c:C
    const v7, 0xd800

    if-lt v0, v7, :cond_5b

    const v7, 0xdbff

    if-gt v0, v7, :cond_5b

    .line 932
    add-int/lit8 v7, p1, 0x1

    invoke-interface {p0, v7}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    .line 934
    .local v1, c1:C
    const v7, 0xdc00

    if-lt v1, v7, :cond_58

    const v7, 0xdfff

    if-gt v1, v7, :cond_58

    .line 935
    add-int/lit8 p1, p1, 0x2

    .line 942
    .end local v1           #c1:C
    :goto_2b
    instance-of v7, p0, Landroid/text/Spanned;

    if-eqz v7, :cond_5e

    move-object v7, p0

    .line 943
    check-cast v7, Landroid/text/Spanned;

    const-class v8, Landroid/text/style/ReplacementSpan;

    invoke-interface {v7, p1, p1, v8}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Landroid/text/style/ReplacementSpan;

    .line 946
    .local v5, spans:[Landroid/text/style/ReplacementSpan;
    const/4 v3, 0x0

    .local v3, i:I
    :goto_3b
    array-length v7, v5

    if-ge v3, v7, :cond_5e

    move-object v7, p0

    .line 947
    check-cast v7, Landroid/text/Spanned;

    aget-object v8, v5, v3

    invoke-interface {v7, v8}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v6

    .local v6, start:I
    move-object v7, p0

    .line 948
    check-cast v7, Landroid/text/Spanned;

    aget-object v8, v5, v3

    invoke-interface {v7, v8}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v2

    .line 950
    .local v2, end:I
    if-ge v6, p1, :cond_55

    if-le v2, p1, :cond_55

    .line 951
    move p1, v2

    .line 946
    :cond_55
    add-int/lit8 v3, v3, 0x1

    goto :goto_3b

    .line 937
    .end local v2           #end:I
    .end local v3           #i:I
    .end local v5           #spans:[Landroid/text/style/ReplacementSpan;
    .end local v6           #start:I
    .restart local v1       #c1:C
    :cond_58
    add-int/lit8 p1, p1, 0x1

    goto :goto_2b

    .line 939
    .end local v1           #c1:C
    :cond_5b
    add-int/lit8 p1, p1, 0x1

    goto :goto_2b

    :cond_5e
    move v4, p1

    .line 955
    goto :goto_6
.end method

.method public static getOffsetBefore(Ljava/lang/CharSequence;I)I
    .registers 10
    .parameter "text"
    .parameter "offset"

    .prologue
    const/4 v6, 0x0

    .line 887
    if-nez p1, :cond_4

    .line 918
    :cond_3
    :goto_3
    return v6

    .line 889
    :cond_4
    const/4 v7, 0x1

    if-eq p1, v7, :cond_3

    .line 892
    add-int/lit8 v6, p1, -0x1

    invoke-interface {p0, v6}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 894
    .local v0, c:C
    const v6, 0xdc00

    if-lt v0, v6, :cond_59

    const v6, 0xdfff

    if-gt v0, v6, :cond_59

    .line 895
    add-int/lit8 v6, p1, -0x2

    invoke-interface {p0, v6}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    .line 897
    .local v1, c1:C
    const v6, 0xd800

    if-lt v1, v6, :cond_56

    const v6, 0xdbff

    if-gt v1, v6, :cond_56

    .line 898
    add-int/lit8 p1, p1, -0x2

    .line 905
    .end local v1           #c1:C
    :goto_29
    instance-of v6, p0, Landroid/text/Spanned;

    if-eqz v6, :cond_5c

    move-object v6, p0

    .line 906
    check-cast v6, Landroid/text/Spanned;

    const-class v7, Landroid/text/style/ReplacementSpan;

    invoke-interface {v6, p1, p1, v7}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Landroid/text/style/ReplacementSpan;

    .line 909
    .local v4, spans:[Landroid/text/style/ReplacementSpan;
    const/4 v3, 0x0

    .local v3, i:I
    :goto_39
    array-length v6, v4

    if-ge v3, v6, :cond_5c

    move-object v6, p0

    .line 910
    check-cast v6, Landroid/text/Spanned;

    aget-object v7, v4, v3

    invoke-interface {v6, v7}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v5

    .local v5, start:I
    move-object v6, p0

    .line 911
    check-cast v6, Landroid/text/Spanned;

    aget-object v7, v4, v3

    invoke-interface {v6, v7}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v2

    .line 913
    .local v2, end:I
    if-ge v5, p1, :cond_53

    if-le v2, p1, :cond_53

    .line 914
    move p1, v5

    .line 909
    :cond_53
    add-int/lit8 v3, v3, 0x1

    goto :goto_39

    .line 900
    .end local v2           #end:I
    .end local v3           #i:I
    .end local v4           #spans:[Landroid/text/style/ReplacementSpan;
    .end local v5           #start:I
    .restart local v1       #c1:C
    :cond_56
    add-int/lit8 p1, p1, -0x1

    goto :goto_29

    .line 902
    .end local v1           #c1:C
    :cond_59
    add-int/lit8 p1, p1, -0x1

    goto :goto_29

    :cond_5c
    move v6, p1

    .line 918
    goto :goto_3
.end method

.method public static getReverse(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    .registers 4
    .parameter "source"
    .parameter "start"
    .parameter "end"

    .prologue
    .line 494
    new-instance v0, Landroid/text/TextUtils$Reverser;

    invoke-direct {v0, p0, p1, p2}, Landroid/text/TextUtils$Reverser;-><init>(Ljava/lang/CharSequence;II)V

    return-object v0
.end method

.method public static getTrimmedLength(Ljava/lang/CharSequence;)I
    .registers 6
    .parameter "s"

    .prologue
    const/16 v4, 0x20

    .line 452
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v1

    .line 454
    .local v1, len:I
    const/4 v2, 0x0

    .line 455
    .local v2, start:I
    :goto_7
    if-ge v2, v1, :cond_12

    invoke-interface {p0, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    if-gt v3, v4, :cond_12

    .line 456
    add-int/lit8 v2, v2, 0x1

    goto :goto_7

    .line 459
    :cond_12
    move v0, v1

    .line 460
    .local v0, end:I
    :goto_13
    if-le v0, v2, :cond_20

    add-int/lit8 v3, v0, -0x1

    invoke-interface {p0, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    if-gt v3, v4, :cond_20

    .line 461
    add-int/lit8 v0, v0, -0x1

    goto :goto_13

    .line 464
    :cond_20
    sub-int v3, v0, v2

    return v3
.end method

.method public static htmlEncode(Ljava/lang/String;)Ljava/lang/String;
    .registers 5
    .parameter "s"

    .prologue
    .line 1313
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 1315
    .local v2, sb:Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_6
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    if-ge v1, v3, :cond_37

    .line 1316
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 1317
    .local v0, c:C
    sparse-switch v0, :sswitch_data_3c

    .line 1338
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1315
    :goto_16
    add-int/lit8 v1, v1, 0x1

    goto :goto_6

    .line 1319
    :sswitch_19
    const-string v3, "&lt;"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_16

    .line 1322
    :sswitch_1f
    const-string v3, "&gt;"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_16

    .line 1325
    :sswitch_25
    const-string v3, "&amp;"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_16

    .line 1332
    :sswitch_2b
    const-string v3, "&#39;"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_16

    .line 1335
    :sswitch_31
    const-string v3, "&quot;"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_16

    .line 1341
    .end local v0           #c:C
    :cond_37
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 1317
    :sswitch_data_3c
    .sparse-switch
        0x22 -> :sswitch_31
        0x26 -> :sswitch_25
        0x27 -> :sswitch_2b
        0x3c -> :sswitch_19
        0x3e -> :sswitch_1f
    .end sparse-switch
.end method

.method public static indexOf(Ljava/lang/CharSequence;C)I
    .registers 3
    .parameter "s"
    .parameter "ch"

    .prologue
    .line 78
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Landroid/text/TextUtils;->indexOf(Ljava/lang/CharSequence;CI)I

    move-result v0

    return v0
.end method

.method public static indexOf(Ljava/lang/CharSequence;CI)I
    .registers 5
    .parameter "s"
    .parameter "ch"
    .parameter "start"

    .prologue
    .line 82
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 84
    .local v0, c:Ljava/lang/Class;,"Ljava/lang/Class<+Ljava/lang/CharSequence;>;"
    const-class v1, Ljava/lang/String;

    if-ne v0, v1, :cond_f

    .line 85
    check-cast p0, Ljava/lang/String;

    .end local p0
    invoke-virtual {p0, p1, p2}, Ljava/lang/String;->indexOf(II)I

    move-result v1

    .line 87
    :goto_e
    return v1

    .restart local p0
    :cond_f
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v1

    invoke-static {p0, p1, p2, v1}, Landroid/text/TextUtils;->indexOf(Ljava/lang/CharSequence;CII)I

    move-result v1

    goto :goto_e
.end method

.method public static indexOf(Ljava/lang/CharSequence;CII)I
    .registers 12
    .parameter "s"
    .parameter "ch"
    .parameter "start"
    .parameter "end"

    .prologue
    const/4 v6, -0x1

    .line 91
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    .line 93
    .local v1, c:Ljava/lang/Class;,"Ljava/lang/Class<+Ljava/lang/CharSequence;>;"
    instance-of v7, p0, Landroid/text/GetChars;

    if-nez v7, :cond_15

    const-class v7, Ljava/lang/StringBuffer;

    if-eq v1, v7, :cond_15

    const-class v7, Ljava/lang/StringBuilder;

    if-eq v1, v7, :cond_15

    const-class v7, Ljava/lang/String;

    if-ne v1, v7, :cond_40

    .line 95
    :cond_15
    const/16 v0, 0x1f4

    .line 96
    .local v0, INDEX_INCREMENT:I
    const/16 v7, 0x1f4

    invoke-static {v7}, Landroid/text/TextUtils;->obtain(I)[C

    move-result-object v5

    .line 98
    .local v5, temp:[C
    :goto_1d
    if-ge p2, p3, :cond_3b

    .line 99
    add-int/lit16 v4, p2, 0x1f4

    .line 100
    .local v4, segend:I
    if-le v4, p3, :cond_24

    .line 101
    move v4, p3

    .line 103
    :cond_24
    const/4 v7, 0x0

    invoke-static {p0, p2, v4, v5, v7}, Landroid/text/TextUtils;->getChars(Ljava/lang/CharSequence;II[CI)V

    .line 105
    sub-int v2, v4, p2

    .line 106
    .local v2, count:I
    const/4 v3, 0x0

    .local v3, i:I
    :goto_2b
    if-ge v3, v2, :cond_39

    .line 107
    aget-char v7, v5, v3

    if-ne v7, p1, :cond_36

    .line 108
    invoke-static {v5}, Landroid/text/TextUtils;->recycle([C)V

    .line 109
    add-int/2addr v3, p2

    .line 124
    .end local v0           #INDEX_INCREMENT:I
    .end local v2           #count:I
    .end local v3           #i:I
    .end local v4           #segend:I
    .end local v5           #temp:[C
    :cond_35
    :goto_35
    return v3

    .line 106
    .restart local v0       #INDEX_INCREMENT:I
    .restart local v2       #count:I
    .restart local v3       #i:I
    .restart local v4       #segend:I
    .restart local v5       #temp:[C
    :cond_36
    add-int/lit8 v3, v3, 0x1

    goto :goto_2b

    .line 113
    :cond_39
    move p2, v4

    .line 114
    goto :goto_1d

    .line 116
    .end local v2           #count:I
    .end local v3           #i:I
    .end local v4           #segend:I
    :cond_3b
    invoke-static {v5}, Landroid/text/TextUtils;->recycle([C)V

    move v3, v6

    .line 117
    goto :goto_35

    .line 120
    .end local v0           #INDEX_INCREMENT:I
    .end local v5           #temp:[C
    :cond_40
    move v3, p2

    .restart local v3       #i:I
    :goto_41
    if-ge v3, p3, :cond_4c

    .line 121
    invoke-interface {p0, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v7

    if-eq v7, p1, :cond_35

    .line 120
    add-int/lit8 v3, v3, 0x1

    goto :goto_41

    :cond_4c
    move v3, v6

    .line 124
    goto :goto_35
.end method

.method public static indexOf(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)I
    .registers 4
    .parameter "s"
    .parameter "needle"

    .prologue
    .line 186
    const/4 v0, 0x0

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v1

    invoke-static {p0, p1, v0, v1}, Landroid/text/TextUtils;->indexOf(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I

    move-result v0

    return v0
.end method

.method public static indexOf(Ljava/lang/CharSequence;Ljava/lang/CharSequence;I)I
    .registers 4
    .parameter "s"
    .parameter "needle"
    .parameter "start"

    .prologue
    .line 190
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    invoke-static {p0, p1, p2, v0}, Landroid/text/TextUtils;->indexOf(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I

    move-result v0

    return v0
.end method

.method public static indexOf(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I
    .registers 9
    .parameter "s"
    .parameter "needle"
    .parameter "start"
    .parameter "end"

    .prologue
    const/4 v4, 0x0

    const/4 v2, -0x1

    .line 195
    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v1

    .line 196
    .local v1, nlen:I
    if-nez v1, :cond_a

    move v2, p2

    .line 217
    :cond_9
    :goto_9
    return v2

    .line 199
    :cond_a
    invoke-interface {p1, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 202
    .local v0, c:C
    :goto_e
    invoke-static {p0, v0, p2}, Landroid/text/TextUtils;->indexOf(Ljava/lang/CharSequence;CI)I

    move-result p2

    .line 203
    sub-int v3, p3, v1

    if-gt p2, v3, :cond_9

    .line 207
    if-ltz p2, :cond_9

    .line 211
    invoke-static {p0, p2, p1, v4, v1}, Landroid/text/TextUtils;->regionMatches(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Z

    move-result v3

    if-eqz v3, :cond_20

    move v2, p2

    .line 212
    goto :goto_9

    .line 215
    :cond_20
    add-int/lit8 p2, p2, 0x1

    goto :goto_e
.end method

.method public static isDigitsOnly(Ljava/lang/CharSequence;)Z
    .registers 4
    .parameter "str"

    .prologue
    .line 1427
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v1

    .line 1428
    .local v1, len:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_5
    if-ge v0, v1, :cond_16

    .line 1429
    invoke-interface {p0, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    invoke-static {v2}, Ljava/lang/Character;->isDigit(C)Z

    move-result v2

    if-nez v2, :cond_13

    .line 1430
    const/4 v2, 0x0

    .line 1433
    :goto_12
    return v2

    .line 1428
    :cond_13
    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    .line 1433
    :cond_16
    const/4 v2, 0x1

    goto :goto_12
.end method

.method public static isEmpty(Ljava/lang/CharSequence;)Z
    .registers 2
    .parameter "str"

    .prologue
    .line 440
    if-eqz p0, :cond_8

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-nez v0, :cond_a

    .line 441
    :cond_8
    const/4 v0, 0x1

    .line 443
    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public static isGraphic(C)Z
    .registers 3
    .parameter "c"

    .prologue
    .line 1413
    invoke-static {p0}, Ljava/lang/Character;->getType(C)I

    move-result v0

    .line 1414
    .local v0, gc:I
    const/16 v1, 0xf

    if-eq v0, v1, :cond_20

    const/16 v1, 0x10

    if-eq v0, v1, :cond_20

    const/16 v1, 0x13

    if-eq v0, v1, :cond_20

    if-eqz v0, :cond_20

    const/16 v1, 0xd

    if-eq v0, v1, :cond_20

    const/16 v1, 0xe

    if-eq v0, v1, :cond_20

    const/16 v1, 0xc

    if-eq v0, v1, :cond_20

    const/4 v1, 0x1

    :goto_1f
    return v1

    :cond_20
    const/4 v1, 0x0

    goto :goto_1f
.end method

.method public static isGraphic(Ljava/lang/CharSequence;)Z
    .registers 5
    .parameter "str"

    .prologue
    .line 1393
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v2

    .line 1394
    .local v2, len:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_5
    if-ge v1, v2, :cond_2e

    .line 1395
    invoke-interface {p0, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    invoke-static {v3}, Ljava/lang/Character;->getType(C)I

    move-result v0

    .line 1396
    .local v0, gc:I
    const/16 v3, 0xf

    if-eq v0, v3, :cond_2b

    const/16 v3, 0x10

    if-eq v0, v3, :cond_2b

    const/16 v3, 0x13

    if-eq v0, v3, :cond_2b

    if-eqz v0, :cond_2b

    const/16 v3, 0xd

    if-eq v0, v3, :cond_2b

    const/16 v3, 0xe

    if-eq v0, v3, :cond_2b

    const/16 v3, 0xc

    if-eq v0, v3, :cond_2b

    .line 1403
    const/4 v3, 0x1

    .line 1406
    .end local v0           #gc:I
    :goto_2a
    return v3

    .line 1394
    .restart local v0       #gc:I
    :cond_2b
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    .line 1406
    .end local v0           #gc:I
    :cond_2e
    const/4 v3, 0x0

    goto :goto_2a
.end method

.method public static isPrintableAscii(C)Z
    .registers 4
    .parameter "c"

    .prologue
    .line 1440
    const/16 v0, 0x20

    .line 1441
    .local v0, asciiFirst:I
    const/16 v1, 0x7e

    .line 1442
    .local v1, asciiLast:I
    const/16 v2, 0x20

    if-gt v2, p0, :cond_c

    const/16 v2, 0x7e

    if-le p0, v2, :cond_14

    :cond_c
    const/16 v2, 0xd

    if-eq p0, v2, :cond_14

    const/16 v2, 0xa

    if-ne p0, v2, :cond_16

    :cond_14
    const/4 v2, 0x1

    :goto_15
    return v2

    :cond_16
    const/4 v2, 0x0

    goto :goto_15
.end method

.method public static isPrintableAsciiOnly(Ljava/lang/CharSequence;)Z
    .registers 4
    .parameter "str"

    .prologue
    .line 1449
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v1

    .line 1450
    .local v1, len:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_5
    if-ge v0, v1, :cond_16

    .line 1451
    invoke-interface {p0, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    invoke-static {v2}, Landroid/text/TextUtils;->isPrintableAscii(C)Z

    move-result v2

    if-nez v2, :cond_13

    .line 1452
    const/4 v2, 0x0

    .line 1455
    :goto_12
    return v2

    .line 1450
    :cond_13
    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    .line 1455
    :cond_16
    const/4 v2, 0x1

    goto :goto_12
.end method

.method public static join(Ljava/lang/Iterable;)Ljava/lang/CharSequence;
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Iterable",
            "<",
            "Ljava/lang/CharSequence;",
            ">;)",
            "Ljava/lang/CharSequence;"
        }
    .end annotation

    .prologue
    .line 270
    .local p0, list:Ljava/lang/Iterable;,"Ljava/lang/Iterable<Ljava/lang/CharSequence;>;"
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x10404f7

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    .line 271
    .local v0, delimiter:Ljava/lang/CharSequence;
    invoke-static {v0, p0}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    .registers 7
    .parameter "delimiter"
    .parameter "tokens"

    .prologue
    .line 299
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 300
    .local v2, sb:Ljava/lang/StringBuilder;
    const/4 v0, 0x1

    .line 301
    .local v0, firstTime:Z
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :goto_a
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1f

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    .line 302
    .local v3, token:Ljava/lang/Object;
    if-eqz v0, :cond_1b

    .line 303
    const/4 v0, 0x0

    .line 307
    :goto_17
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    goto :goto_a

    .line 305
    :cond_1b
    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    goto :goto_17

    .line 309
    .end local v3           #token:Ljava/lang/Object;
    :cond_1f
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method

.method public static join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;
    .registers 9
    .parameter "delimiter"
    .parameter "tokens"

    .prologue
    .line 280
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 281
    .local v4, sb:Ljava/lang/StringBuilder;
    const/4 v1, 0x1

    .line 282
    .local v1, firstTime:Z
    move-object v0, p1

    .local v0, arr$:[Ljava/lang/Object;
    array-length v3, v0

    .local v3, len$:I
    const/4 v2, 0x0

    .local v2, i$:I
    :goto_9
    if-ge v2, v3, :cond_1a

    aget-object v5, v0, v2

    .line 283
    .local v5, token:Ljava/lang/Object;
    if-eqz v1, :cond_16

    .line 284
    const/4 v1, 0x0

    .line 288
    :goto_10
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 282
    add-int/lit8 v2, v2, 0x1

    goto :goto_9

    .line 286
    :cond_16
    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    goto :goto_10

    .line 290
    .end local v5           #token:Ljava/lang/Object;
    :cond_1a
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    return-object v6
.end method

.method public static lastIndexOf(Ljava/lang/CharSequence;C)I
    .registers 3
    .parameter "s"
    .parameter "ch"

    .prologue
    .line 128
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-static {p0, p1, v0}, Landroid/text/TextUtils;->lastIndexOf(Ljava/lang/CharSequence;CI)I

    move-result v0

    return v0
.end method

.method public static lastIndexOf(Ljava/lang/CharSequence;CI)I
    .registers 5
    .parameter "s"
    .parameter "ch"
    .parameter "last"

    .prologue
    .line 132
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 134
    .local v0, c:Ljava/lang/Class;,"Ljava/lang/Class<+Ljava/lang/CharSequence;>;"
    const-class v1, Ljava/lang/String;

    if-ne v0, v1, :cond_f

    .line 135
    check-cast p0, Ljava/lang/String;

    .end local p0
    invoke-virtual {p0, p1, p2}, Ljava/lang/String;->lastIndexOf(II)I

    move-result v1

    .line 137
    :goto_e
    return v1

    .restart local p0
    :cond_f
    const/4 v1, 0x0

    invoke-static {p0, p1, v1, p2}, Landroid/text/TextUtils;->lastIndexOf(Ljava/lang/CharSequence;CII)I

    move-result v1

    goto :goto_e
.end method

.method public static lastIndexOf(Ljava/lang/CharSequence;CII)I
    .registers 13
    .parameter "s"
    .parameter "ch"
    .parameter "start"
    .parameter "last"

    .prologue
    const/4 v7, -0x1

    .line 142
    if-gez p3, :cond_5

    move v4, v7

    .line 182
    :cond_4
    :goto_4
    return v4

    .line 144
    :cond_5
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v8

    if-lt p3, v8, :cond_11

    .line 145
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v8

    add-int/lit8 p3, v8, -0x1

    .line 147
    :cond_11
    add-int/lit8 v3, p3, 0x1

    .line 149
    .local v3, end:I
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    .line 151
    .local v1, c:Ljava/lang/Class;,"Ljava/lang/Class<+Ljava/lang/CharSequence;>;"
    instance-of v8, p0, Landroid/text/GetChars;

    if-nez v8, :cond_27

    const-class v8, Ljava/lang/StringBuffer;

    if-eq v1, v8, :cond_27

    const-class v8, Ljava/lang/StringBuilder;

    if-eq v1, v8, :cond_27

    const-class v8, Ljava/lang/String;

    if-ne v1, v8, :cond_53

    .line 153
    :cond_27
    const/16 v0, 0x1f4

    .line 154
    .local v0, INDEX_INCREMENT:I
    const/16 v8, 0x1f4

    invoke-static {v8}, Landroid/text/TextUtils;->obtain(I)[C

    move-result-object v6

    .line 156
    .local v6, temp:[C
    :goto_2f
    if-ge p2, v3, :cond_4e

    .line 157
    add-int/lit16 v5, v3, -0x1f4

    .line 158
    .local v5, segstart:I
    if-ge v5, p2, :cond_36

    .line 159
    move v5, p2

    .line 161
    :cond_36
    const/4 v8, 0x0

    invoke-static {p0, v5, v3, v6, v8}, Landroid/text/TextUtils;->getChars(Ljava/lang/CharSequence;II[CI)V

    .line 163
    sub-int v2, v3, v5

    .line 164
    .local v2, count:I
    add-int/lit8 v4, v2, -0x1

    .local v4, i:I
    :goto_3e
    if-ltz v4, :cond_4c

    .line 165
    aget-char v8, v6, v4

    if-ne v8, p1, :cond_49

    .line 166
    invoke-static {v6}, Landroid/text/TextUtils;->recycle([C)V

    .line 167
    add-int/2addr v4, v5

    goto :goto_4

    .line 164
    :cond_49
    add-int/lit8 v4, v4, -0x1

    goto :goto_3e

    .line 171
    :cond_4c
    move v3, v5

    .line 172
    goto :goto_2f

    .line 174
    .end local v2           #count:I
    .end local v4           #i:I
    .end local v5           #segstart:I
    :cond_4e
    invoke-static {v6}, Landroid/text/TextUtils;->recycle([C)V

    move v4, v7

    .line 175
    goto :goto_4

    .line 178
    .end local v0           #INDEX_INCREMENT:I
    .end local v6           #temp:[C
    :cond_53
    add-int/lit8 v4, v3, -0x1

    .restart local v4       #i:I
    :goto_55
    if-lt v4, p2, :cond_60

    .line 179
    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v8

    if-eq v8, p1, :cond_4

    .line 178
    add-int/lit8 v4, v4, -0x1

    goto :goto_55

    :cond_60
    move v4, v7

    .line 182
    goto :goto_4
.end method

.method static obtain(I)[C
    .registers 4
    .parameter "len"

    .prologue
    .line 1287
    sget-object v2, Landroid/text/TextUtils;->sLock:Ljava/lang/Object;

    monitor-enter v2

    .line 1288
    :try_start_3
    sget-object v0, Landroid/text/TextUtils;->sTemp:[C

    .line 1289
    .local v0, buf:[C
    const/4 v1, 0x0

    sput-object v1, Landroid/text/TextUtils;->sTemp:[C

    .line 1290
    monitor-exit v2
    :try_end_9
    .catchall {:try_start_3 .. :try_end_9} :catchall_15

    .line 1292
    if-eqz v0, :cond_e

    array-length v1, v0

    if-ge v1, p0, :cond_14

    .line 1293
    :cond_e
    invoke-static {p0}, Lcom/android/internal/util/ArrayUtils;->idealCharArraySize(I)I

    move-result v1

    new-array v0, v1, [C

    .line 1295
    :cond_14
    return-object v0

    .line 1290
    .end local v0           #buf:[C
    :catchall_15
    move-exception v1

    :try_start_16
    monitor-exit v2
    :try_end_17
    .catchall {:try_start_16 .. :try_end_17} :catchall_15

    throw v1
.end method

.method public static packRangeInLong(II)J
    .registers 6
    .parameter "start"
    .parameter "end"

    .prologue
    .line 1674
    int-to-long v0, p0

    const/16 v2, 0x20

    shl-long/2addr v0, v2

    int-to-long v2, p1

    or-long/2addr v0, v2

    return-wide v0
.end method

.method private static readSpan(Landroid/os/Parcel;Landroid/text/Spannable;Ljava/lang/Object;)V
    .registers 6
    .parameter "p"
    .parameter "sp"
    .parameter "o"

    .prologue
    .line 959
    invoke-virtual {p0}, Landroid/os/Parcel;->readInt()I

    move-result v0

    invoke-virtual {p0}, Landroid/os/Parcel;->readInt()I

    move-result v1

    invoke-virtual {p0}, Landroid/os/Parcel;->readInt()I

    move-result v2

    invoke-interface {p1, p2, v0, v1, v2}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    .line 960
    return-void
.end method

.method static recycle([C)V
    .registers 3
    .parameter "temp"

    .prologue
    .line 1299
    array-length v0, p0

    const/16 v1, 0x3e8

    if-le v0, v1, :cond_6

    .line 1305
    :goto_5
    return-void

    .line 1302
    :cond_6
    sget-object v1, Landroid/text/TextUtils;->sLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1303
    :try_start_9
    sput-object p0, Landroid/text/TextUtils;->sTemp:[C

    .line 1304
    monitor-exit v1

    goto :goto_5

    :catchall_d
    move-exception v0

    monitor-exit v1
    :try_end_f
    .catchall {:try_start_9 .. :try_end_f} :catchall_d

    throw v0
.end method

.method public static regionMatches(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Z
    .registers 10
    .parameter "one"
    .parameter "toffset"
    .parameter "two"
    .parameter "ooffset"
    .parameter "len"

    .prologue
    .line 223
    mul-int/lit8 v3, p4, 0x2

    invoke-static {v3}, Landroid/text/TextUtils;->obtain(I)[C

    move-result-object v2

    .line 225
    .local v2, temp:[C
    add-int v3, p1, p4

    const/4 v4, 0x0

    invoke-static {p0, p1, v3, v2, v4}, Landroid/text/TextUtils;->getChars(Ljava/lang/CharSequence;II[CI)V

    .line 226
    add-int v3, p3, p4

    invoke-static {p2, p3, v3, v2, p4}, Landroid/text/TextUtils;->getChars(Ljava/lang/CharSequence;II[CI)V

    .line 228
    const/4 v1, 0x1

    .line 229
    .local v1, match:Z
    const/4 v0, 0x0

    .local v0, i:I
    :goto_13
    if-ge v0, p4, :cond_1e

    .line 230
    aget-char v3, v2, v0

    add-int v4, v0, p4

    aget-char v4, v2, v4

    if-eq v3, v4, :cond_22

    .line 231
    const/4 v1, 0x0

    .line 236
    :cond_1e
    invoke-static {v2}, Landroid/text/TextUtils;->recycle([C)V

    .line 237
    return v1

    .line 229
    :cond_22
    add-int/lit8 v0, v0, 0x1

    goto :goto_13
.end method

.method public static removeEmptySpans([Ljava/lang/Object;Landroid/text/Spanned;Ljava/lang/Class;)[Ljava/lang/Object;
    .registers 12
    .parameter
    .parameter "spanned"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;",
            "Landroid/text/Spanned;",
            "Ljava/lang/Class",
            "<TT;>;)[TT;"
        }
    .end annotation

    .prologue
    .local p0, spans:[Ljava/lang/Object;,"[TT;"
    .local p2, klass:Ljava/lang/Class;,"Ljava/lang/Class<TT;>;"
    const/4 v8, 0x0

    .line 1636
    const/4 v0, 0x0

    .line 1637
    .local v0, copy:[Ljava/lang/Object;,"[TT;"
    const/4 v1, 0x0

    .line 1639
    .local v1, count:I
    const/4 v3, 0x0

    .local v3, i:I
    :goto_4
    array-length v7, p0

    if-ge v3, v7, :cond_2f

    .line 1640
    aget-object v5, p0, v3

    .line 1641
    .local v5, span:Ljava/lang/Object;,"TT;"
    invoke-interface {p1, v5}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v6

    .line 1642
    .local v6, start:I
    invoke-interface {p1, v5}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v2

    .line 1644
    .local v2, end:I
    if-ne v6, v2, :cond_28

    .line 1645
    if-nez v0, :cond_25

    .line 1646
    array-length v7, p0

    add-int/lit8 v7, v7, -0x1

    invoke-static {p2, v7}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, [Ljava/lang/Object;

    move-object v0, v7

    check-cast v0, [Ljava/lang/Object;

    .line 1647
    invoke-static {p0, v8, v0, v8, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1648
    move v1, v3

    .line 1639
    :cond_25
    :goto_25
    add-int/lit8 v3, v3, 0x1

    goto :goto_4

    .line 1651
    :cond_28
    if-eqz v0, :cond_25

    .line 1652
    aput-object v5, v0, v1

    .line 1653
    add-int/lit8 v1, v1, 0x1

    goto :goto_25

    .line 1658
    .end local v2           #end:I
    .end local v5           #span:Ljava/lang/Object;,"TT;"
    .end local v6           #start:I
    :cond_2f
    if-eqz v0, :cond_3e

    .line 1659
    invoke-static {p2, v1}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, [Ljava/lang/Object;

    move-object v4, v7

    check-cast v4, [Ljava/lang/Object;

    .line 1660
    .local v4, result:[Ljava/lang/Object;,"[TT;"
    invoke-static {v0, v8, v4, v8, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1663
    .end local v4           #result:[Ljava/lang/Object;,"[TT;"
    :goto_3d
    return-object v4

    :cond_3e
    move-object v4, p0

    goto :goto_3d
.end method

.method public static replace(Ljava/lang/CharSequence;[Ljava/lang/String;[Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    .registers 11
    .parameter "template"
    .parameter "sources"
    .parameter "destinations"

    .prologue
    .line 802
    new-instance v3, Landroid/text/SpannableStringBuilder;

    invoke-direct {v3, p0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 804
    .local v3, tb:Landroid/text/SpannableStringBuilder;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_6
    array-length v5, p1

    if-ge v1, v5, :cond_22

    .line 805
    aget-object v5, p1, v1

    invoke-static {v3, v5}, Landroid/text/TextUtils;->indexOf(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)I

    move-result v4

    .line 807
    .local v4, where:I
    if-ltz v4, :cond_1f

    .line 808
    aget-object v5, p1, v1

    aget-object v6, p1, v1

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    add-int/2addr v6, v4

    const/16 v7, 0x21

    invoke-virtual {v3, v5, v4, v6, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 804
    :cond_1f
    add-int/lit8 v1, v1, 0x1

    goto :goto_6

    .line 812
    .end local v4           #where:I
    :cond_22
    const/4 v1, 0x0

    :goto_23
    array-length v5, p1

    if-ge v1, v5, :cond_3c

    .line 813
    aget-object v5, p1, v1

    invoke-virtual {v3, v5}, Landroid/text/SpannableStringBuilder;->getSpanStart(Ljava/lang/Object;)I

    move-result v2

    .line 814
    .local v2, start:I
    aget-object v5, p1, v1

    invoke-virtual {v3, v5}, Landroid/text/SpannableStringBuilder;->getSpanEnd(Ljava/lang/Object;)I

    move-result v0

    .line 816
    .local v0, end:I
    if-ltz v2, :cond_39

    .line 817
    aget-object v5, p2, v1

    invoke-virtual {v3, v2, v0, v5}, Landroid/text/SpannableStringBuilder;->replace(IILjava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 812
    :cond_39
    add-int/lit8 v1, v1, 0x1

    goto :goto_23

    .line 821
    .end local v0           #end:I
    .end local v2           #start:I
    :cond_3c
    return-object v3
.end method

.method private static setPara(Landroid/text/MeasuredText;Landroid/text/TextPaint;Ljava/lang/CharSequence;IILandroid/text/TextDirectionHeuristic;)F
    .registers 14
    .parameter "mt"
    .parameter "paint"
    .parameter "text"
    .parameter "start"
    .parameter "end"
    .parameter "textDir"

    .prologue
    const/4 v6, 0x0

    .line 1239
    invoke-virtual {p0, p2, p3, p4, p5}, Landroid/text/MeasuredText;->setPara(Ljava/lang/CharSequence;IILandroid/text/TextDirectionHeuristic;)V

    .line 1242
    instance-of v7, p2, Landroid/text/Spanned;

    if-eqz v7, :cond_14

    check-cast p2, Landroid/text/Spanned;

    .end local p2
    move-object v1, p2

    .line 1243
    .local v1, sp:Landroid/text/Spanned;
    :goto_b
    sub-int v0, p4, p3

    .line 1244
    .local v0, len:I
    if-nez v1, :cond_16

    .line 1245
    invoke-virtual {p0, p1, v0, v6}, Landroid/text/MeasuredText;->addStyleRun(Landroid/text/TextPaint;ILandroid/graphics/Paint$FontMetricsInt;)F

    move-result v5

    .line 1259
    .local v5, width:F
    :cond_13
    return v5

    .end local v0           #len:I
    .end local v1           #sp:Landroid/text/Spanned;
    .end local v5           #width:F
    .restart local p2
    :cond_14
    move-object v1, v6

    .line 1242
    goto :goto_b

    .line 1247
    .end local p2
    .restart local v0       #len:I
    .restart local v1       #sp:Landroid/text/Spanned;
    :cond_16
    const/4 v5, 0x0

    .line 1249
    .restart local v5       #width:F
    const/4 v3, 0x0

    .local v3, spanStart:I
    :goto_18
    if-ge v3, v0, :cond_13

    .line 1250
    const-class v7, Landroid/text/style/MetricAffectingSpan;

    invoke-interface {v1, v3, v0, v7}, Landroid/text/Spanned;->nextSpanTransition(IILjava/lang/Class;)I

    move-result v2

    .line 1252
    .local v2, spanEnd:I
    const-class v7, Landroid/text/style/MetricAffectingSpan;

    invoke-interface {v1, v3, v2, v7}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Landroid/text/style/MetricAffectingSpan;

    .line 1254
    .local v4, spans:[Landroid/text/style/MetricAffectingSpan;
    const-class v7, Landroid/text/style/MetricAffectingSpan;

    invoke-static {v4, v1, v7}, Landroid/text/TextUtils;->removeEmptySpans([Ljava/lang/Object;Landroid/text/Spanned;Ljava/lang/Class;)[Ljava/lang/Object;

    move-result-object v4

    .end local v4           #spans:[Landroid/text/style/MetricAffectingSpan;
    check-cast v4, [Landroid/text/style/MetricAffectingSpan;

    .line 1255
    .restart local v4       #spans:[Landroid/text/style/MetricAffectingSpan;
    sub-int v7, v2, v3

    invoke-virtual {p0, p1, v4, v7, v6}, Landroid/text/MeasuredText;->addStyleRun(Landroid/text/TextPaint;[Landroid/text/style/MetricAffectingSpan;ILandroid/graphics/Paint$FontMetricsInt;)F

    move-result v7

    add-float/2addr v5, v7

    .line 1249
    move v3, v2

    goto :goto_18
.end method

.method public static split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    .registers 3
    .parameter "text"
    .parameter "expression"

    .prologue
    .line 323
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    .line 324
    sget-object v0, Landroid/text/TextUtils;->EMPTY_STRING_ARRAY:[Ljava/lang/String;

    .line 326
    :goto_8
    return-object v0

    :cond_9
    const/4 v0, -0x1

    invoke-virtual {p0, p1, v0}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    goto :goto_8
.end method

.method public static split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;
    .registers 3
    .parameter "text"
    .parameter "pattern"

    .prologue
    .line 340
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    .line 341
    sget-object v0, Landroid/text/TextUtils;->EMPTY_STRING_ARRAY:[Ljava/lang/String;

    .line 343
    :goto_8
    return-object v0

    :cond_9
    const/4 v0, -0x1

    invoke-virtual {p1, p0, v0}, Ljava/util/regex/Pattern;->split(Ljava/lang/CharSequence;I)[Ljava/lang/String;

    move-result-object v0

    goto :goto_8
.end method

.method public static stringOrSpannedString(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    .registers 2
    .parameter "source"

    .prologue
    .line 424
    if-nez p0, :cond_4

    .line 425
    const/4 p0, 0x0

    .line 431
    .end local p0
    :cond_3
    :goto_3
    return-object p0

    .line 426
    .restart local p0
    :cond_4
    instance-of v0, p0, Landroid/text/SpannedString;

    if-nez v0, :cond_3

    .line 428
    instance-of v0, p0, Landroid/text/Spanned;

    if-eqz v0, :cond_13

    .line 429
    new-instance v0, Landroid/text/SpannedString;

    invoke-direct {v0, p0}, Landroid/text/SpannedString;-><init>(Ljava/lang/CharSequence;)V

    move-object p0, v0

    goto :goto_3

    .line 431
    :cond_13
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_3
.end method

.method public static substring(Ljava/lang/CharSequence;II)Ljava/lang/String;
    .registers 7
    .parameter "source"
    .parameter "start"
    .parameter "end"

    .prologue
    const/4 v3, 0x0

    .line 248
    instance-of v2, p0, Ljava/lang/String;

    if-eqz v2, :cond_c

    .line 249
    check-cast p0, Ljava/lang/String;

    .end local p0
    invoke-virtual {p0, p1, p2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 260
    :goto_b
    return-object v0

    .line 250
    .restart local p0
    :cond_c
    instance-of v2, p0, Ljava/lang/StringBuilder;

    if-eqz v2, :cond_17

    .line 251
    check-cast p0, Ljava/lang/StringBuilder;

    .end local p0
    invoke-virtual {p0, p1, p2}, Ljava/lang/StringBuilder;->substring(II)Ljava/lang/String;

    move-result-object v0

    goto :goto_b

    .line 252
    .restart local p0
    :cond_17
    instance-of v2, p0, Ljava/lang/StringBuffer;

    if-eqz v2, :cond_22

    .line 253
    check-cast p0, Ljava/lang/StringBuffer;

    .end local p0
    invoke-virtual {p0, p1, p2}, Ljava/lang/StringBuffer;->substring(II)Ljava/lang/String;

    move-result-object v0

    goto :goto_b

    .line 255
    .restart local p0
    :cond_22
    sub-int v2, p2, p1

    invoke-static {v2}, Landroid/text/TextUtils;->obtain(I)[C

    move-result-object v1

    .line 256
    .local v1, temp:[C
    invoke-static {p0, p1, p2, v1, v3}, Landroid/text/TextUtils;->getChars(Ljava/lang/CharSequence;II[CI)V

    .line 257
    new-instance v0, Ljava/lang/String;

    sub-int v2, p2, p1

    invoke-direct {v0, v1, v3, v2}, Ljava/lang/String;-><init>([CII)V

    .line 258
    .local v0, ret:Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->recycle([C)V

    goto :goto_b
.end method

.method public static unpackRangeEndFromLong(J)I
    .registers 4
    .parameter "range"

    .prologue
    .line 1694
    const-wide v0, 0xffffffffL

    and-long/2addr v0, p0

    long-to-int v0, v0

    return v0
.end method

.method public static unpackRangeStartFromLong(J)I
    .registers 4
    .parameter "range"

    .prologue
    .line 1684
    const/16 v0, 0x20

    ushr-long v0, p0, v0

    long-to-int v0, v0

    return v0
.end method

.method public static writeToParcel(Ljava/lang/CharSequence;Landroid/os/Parcel;I)V
    .registers 12
    .parameter "cs"
    .parameter "p"
    .parameter "parcelableFlags"

    .prologue
    const/4 v8, 0x0

    .line 597
    instance-of v6, p0, Landroid/text/Spanned;

    if-eqz v6, :cond_49

    .line 598
    invoke-virtual {p1, v8}, Landroid/os/Parcel;->writeInt(I)V

    .line 599
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v6}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    move-object v5, p0

    .line 601
    check-cast v5, Landroid/text/Spanned;

    .line 602
    .local v5, sp:Landroid/text/Spanned;
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v6

    const-class v7, Ljava/lang/Object;

    invoke-interface {v5, v8, v6, v7}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v2

    .line 609
    .local v2, os:[Ljava/lang/Object;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1d
    array-length v6, v2

    if-ge v0, v6, :cond_45

    .line 610
    aget-object v1, v2, v0

    .line 611
    .local v1, o:Ljava/lang/Object;
    aget-object v3, v2, v0

    .line 613
    .local v3, prop:Ljava/lang/Object;
    instance-of v6, v3, Landroid/text/style/CharacterStyle;

    if-eqz v6, :cond_2e

    .line 614
    check-cast v3, Landroid/text/style/CharacterStyle;

    .end local v3           #prop:Ljava/lang/Object;
    invoke-virtual {v3}, Landroid/text/style/CharacterStyle;->getUnderlying()Landroid/text/style/CharacterStyle;

    move-result-object v3

    .line 617
    :cond_2e
    instance-of v6, v3, Landroid/text/ParcelableSpan;

    if-eqz v6, :cond_42

    move-object v4, v3

    .line 618
    check-cast v4, Landroid/text/ParcelableSpan;

    .line 619
    .local v4, ps:Landroid/text/ParcelableSpan;
    invoke-interface {v4}, Landroid/text/ParcelableSpan;->getSpanTypeId()I

    move-result v6

    invoke-virtual {p1, v6}, Landroid/os/Parcel;->writeInt(I)V

    .line 620
    invoke-interface {v4, p1, p2}, Landroid/text/ParcelableSpan;->writeToParcel(Landroid/os/Parcel;I)V

    .line 621
    invoke-static {p1, v5, v1}, Landroid/text/TextUtils;->writeWhere(Landroid/os/Parcel;Landroid/text/Spanned;Ljava/lang/Object;)V

    .line 609
    .end local v4           #ps:Landroid/text/ParcelableSpan;
    :cond_42
    add-int/lit8 v0, v0, 0x1

    goto :goto_1d

    .line 625
    .end local v1           #o:Ljava/lang/Object;
    :cond_45
    invoke-virtual {p1, v8}, Landroid/os/Parcel;->writeInt(I)V

    .line 634
    .end local v0           #i:I
    .end local v2           #os:[Ljava/lang/Object;
    .end local v5           #sp:Landroid/text/Spanned;
    :goto_48
    return-void

    .line 627
    :cond_49
    const/4 v6, 0x1

    invoke-virtual {p1, v6}, Landroid/os/Parcel;->writeInt(I)V

    .line 628
    if-eqz p0, :cond_57

    .line 629
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v6}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_48

    .line 631
    :cond_57
    const/4 v6, 0x0

    invoke-virtual {p1, v6}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_48
.end method

.method private static writeWhere(Landroid/os/Parcel;Landroid/text/Spanned;Ljava/lang/Object;)V
    .registers 4
    .parameter "p"
    .parameter "sp"
    .parameter "o"

    .prologue
    .line 637
    invoke-interface {p1, p2}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 638
    invoke-interface {p1, p2}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 639
    invoke-interface {p1, p2}, Landroid/text/Spanned;->getSpanFlags(Ljava/lang/Object;)I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 640
    return-void
.end method
