.class public Lmiui/telephony/phonenumber/Prefix;
.super Ljava/lang/Object;
.source "Prefix.java"


# static fields
.field public static final EMPTY:Ljava/lang/String; = ""

.field public static final PREFIX_10193:Ljava/lang/String; = "10193"

.field public static final PREFIX_10650:Ljava/lang/String; = "10650"

.field public static final PREFIX_10651:Ljava/lang/String; = "10651"

.field public static final PREFIX_10656:Ljava/lang/String; = "10656"

.field public static final PREFIX_10657:Ljava/lang/String; = "10657"

.field public static final PREFIX_10659:Ljava/lang/String; = "10659"

.field public static final PREFIX_12520:Ljava/lang/String; = "12520"

.field public static final PREFIX_12593:Ljava/lang/String; = "12593"

.field public static final PREFIX_17901:Ljava/lang/String; = "17901"

.field public static final PREFIX_17909:Ljava/lang/String; = "17909"

.field public static final PREFIX_17911:Ljava/lang/String; = "17911"

.field public static final PREFIX_17951:Ljava/lang/String; = "17951"

.field public static final PREFIX_17961:Ljava/lang/String; = "17961"

.field public static final PREFIX_600:Ljava/lang/String; = "600"

.field public static final SMS_PREFIXES:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 23
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "12520"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "10657"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "10656"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "10650"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "10651"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "10659"

    aput-object v2, v0, v1

    sput-object v0, Lmiui/telephony/phonenumber/Prefix;->SMS_PREFIXES:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 5
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isSmsPrefix(Ljava/lang/String;)Z
    .registers 6
    .parameter "prefix"

    .prologue
    .line 84
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_19

    .line 85
    sget-object v0, Lmiui/telephony/phonenumber/Prefix;->SMS_PREFIXES:[Ljava/lang/String;

    .local v0, arr$:[Ljava/lang/String;
    array-length v2, v0

    .local v2, len$:I
    const/4 v1, 0x0

    .local v1, i$:I
    :goto_a
    if-ge v1, v2, :cond_19

    aget-object v3, v0, v1

    .line 86
    .local v3, sms:Ljava/lang/String;
    invoke-virtual {v3, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_16

    .line 87
    const/4 v4, 0x1

    .line 91
    .end local v0           #arr$:[Ljava/lang/String;
    .end local v1           #i$:I
    .end local v2           #len$:I
    .end local v3           #sms:Ljava/lang/String;
    :goto_15
    return v4

    .line 85
    .restart local v0       #arr$:[Ljava/lang/String;
    .restart local v1       #i$:I
    .restart local v2       #len$:I
    .restart local v3       #sms:Ljava/lang/String;
    :cond_16
    add-int/lit8 v1, v1, 0x1

    goto :goto_a

    .line 91
    .end local v0           #arr$:[Ljava/lang/String;
    .end local v1           #i$:I
    .end local v2           #len$:I
    .end local v3           #sms:Ljava/lang/String;
    :cond_19
    const/4 v4, 0x0

    goto :goto_15
.end method

.method public static parse(Ljava/lang/StringBuffer;II)Ljava/lang/String;
    .registers 10
    .parameter "buffer"
    .parameter "start"
    .parameter "length"

    .prologue
    const/16 v6, 0x33

    const/16 v5, 0x35

    const/16 v4, 0x39

    const/16 v3, 0x30

    const/16 v2, 0x31

    .line 28
    invoke-static {}, Lmiui/telephony/phonenumber/CountryCode;->isChinaEnvironment()Z

    move-result v0

    if-nez v0, :cond_13

    .line 29
    const-string v0, ""

    .line 80
    :goto_12
    return-object v0

    .line 32
    :cond_13
    if-gtz p2, :cond_18

    .line 33
    const-string v0, ""

    goto :goto_12

    .line 36
    :cond_18
    invoke-virtual {p0, p1}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    sparse-switch v0, :sswitch_data_12c

    .line 80
    :cond_1f
    :goto_1f
    const-string v0, ""

    goto :goto_12

    .line 38
    :sswitch_22
    const/4 v0, 0x4

    if-le p2, v0, :cond_1f

    .line 39
    add-int/lit8 v0, p1, 0x1

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    sparse-switch v0, :sswitch_data_136

    goto :goto_1f

    .line 41
    :sswitch_2f
    add-int/lit8 v0, p1, 0x2

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    const/16 v1, 0x36

    if-ne v0, v1, :cond_5a

    add-int/lit8 v0, p1, 0x3

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v5, :cond_5a

    .line 42
    add-int/lit8 v0, p1, 0x4

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    packed-switch v0, :pswitch_data_144

    :pswitch_4a
    goto :goto_1f

    .line 43
    :pswitch_4b
    const-string v0, "10650"

    goto :goto_12

    .line 44
    :pswitch_4e
    const-string v0, "10651"

    goto :goto_12

    .line 45
    :pswitch_51
    const-string v0, "10656"

    goto :goto_12

    .line 46
    :pswitch_54
    const-string v0, "10657"

    goto :goto_12

    .line 47
    :pswitch_57
    const-string v0, "10659"

    goto :goto_12

    .line 49
    :cond_5a
    add-int/lit8 v0, p1, 0x2

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v2, :cond_1f

    .line 50
    add-int/lit8 v0, p1, 0x3

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v4, :cond_1f

    add-int/lit8 v0, p1, 0x4

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v6, :cond_1f

    const-string v0, "10193"

    goto :goto_12

    .line 54
    :sswitch_75
    add-int/lit8 v0, p1, 0x2

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v5, :cond_1f

    .line 55
    add-int/lit8 v0, p1, 0x3

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v4, :cond_90

    add-int/lit8 v0, p1, 0x4

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v6, :cond_90

    const-string v0, "12593"

    goto :goto_12

    .line 56
    :cond_90
    add-int/lit8 v0, p1, 0x3

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    const/16 v1, 0x32

    if-ne v0, v1, :cond_1f

    add-int/lit8 v0, p1, 0x4

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v3, :cond_1f

    const-string v0, "12520"

    goto/16 :goto_12

    .line 60
    :sswitch_a6
    add-int/lit8 v0, p1, 0x2

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v4, :cond_1f

    .line 61
    add-int/lit8 v0, p1, 0x3

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v3, :cond_c2

    add-int/lit8 v0, p1, 0x4

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v2, :cond_c2

    const-string v0, "17901"

    goto/16 :goto_12

    .line 62
    :cond_c2
    add-int/lit8 v0, p1, 0x3

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v3, :cond_d6

    add-int/lit8 v0, p1, 0x4

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v4, :cond_d6

    const-string v0, "17909"

    goto/16 :goto_12

    .line 63
    :cond_d6
    add-int/lit8 v0, p1, 0x3

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v2, :cond_ea

    add-int/lit8 v0, p1, 0x4

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v2, :cond_ea

    const-string v0, "17911"

    goto/16 :goto_12

    .line 64
    :cond_ea
    add-int/lit8 v0, p1, 0x3

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v5, :cond_fe

    add-int/lit8 v0, p1, 0x4

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v2, :cond_fe

    const-string v0, "17951"

    goto/16 :goto_12

    .line 65
    :cond_fe
    add-int/lit8 v0, p1, 0x3

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    const/16 v1, 0x36

    if-ne v0, v1, :cond_1f

    add-int/lit8 v0, p1, 0x4

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v2, :cond_1f

    const-string v0, "17961"

    goto/16 :goto_12

    .line 72
    :sswitch_114
    const/16 v0, 0xd

    if-le p2, v0, :cond_1f

    .line 73
    add-int/lit8 v0, p1, 0x1

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v3, :cond_1f

    add-int/lit8 v0, p1, 0x2

    invoke-virtual {p0, v0}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v0

    if-ne v0, v3, :cond_1f

    .line 75
    const-string v0, "600"

    goto/16 :goto_12

    .line 36
    :sswitch_data_12c
    .sparse-switch
        0x31 -> :sswitch_22
        0x36 -> :sswitch_114
    .end sparse-switch

    .line 39
    :sswitch_data_136
    .sparse-switch
        0x30 -> :sswitch_2f
        0x32 -> :sswitch_75
        0x37 -> :sswitch_a6
    .end sparse-switch

    .line 42
    :pswitch_data_144
    .packed-switch 0x30
        :pswitch_4b
        :pswitch_4e
        :pswitch_4a
        :pswitch_4a
        :pswitch_4a
        :pswitch_4a
        :pswitch_51
        :pswitch_54
        :pswitch_4a
        :pswitch_57
    .end packed-switch
.end method
