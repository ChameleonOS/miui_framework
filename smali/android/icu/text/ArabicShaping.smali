.class public Landroid/icu/text/ArabicShaping;
.super Ljava/lang/Object;
.source "ArabicShaping.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/icu/text/ArabicShaping$ArabicShapingException;
    }
.end annotation


# static fields
.field private static final ALEFTYPE:I = 0x20

.field private static final DESHAPE_MODE:I = 0x1

.field public static final DIGITS_AN2EN:I = 0x40

.field public static final DIGITS_EN2AN:I = 0x20

.field public static final DIGITS_EN2AN_INIT_AL:I = 0x80

.field public static final DIGITS_EN2AN_INIT_LR:I = 0x60

.field public static final DIGITS_MASK:I = 0xe0

.field public static final DIGITS_NOOP:I = 0x0

.field public static final DIGIT_TYPE_AN:I = 0x0

.field public static final DIGIT_TYPE_AN_EXTENDED:I = 0x100

.field public static final DIGIT_TYPE_MASK:I = 0x100

.field private static final HAMZA06_CHAR:C = '\u0621'

.field private static final HAMZAFE_CHAR:C = '\ufe80'

.field private static final IRRELEVANT:I = 0x4

.field public static final LAMALEF_AUTO:I = 0x10000

.field public static final LAMALEF_BEGIN:I = 0x3

.field public static final LAMALEF_END:I = 0x2

.field public static final LAMALEF_MASK:I = 0x10003

.field public static final LAMALEF_NEAR:I = 0x1

.field public static final LAMALEF_RESIZE:I = 0x0

.field private static final LAMALEF_SPACE_SUB:C = '\uffff'

.field private static final LAMTYPE:I = 0x10

.field private static final LAM_CHAR:C = '\u0644'

.field public static final LENGTH_FIXED_SPACES_AT_BEGINNING:I = 0x3

.field public static final LENGTH_FIXED_SPACES_AT_END:I = 0x2

.field public static final LENGTH_FIXED_SPACES_NEAR:I = 0x1

.field public static final LENGTH_GROW_SHRINK:I = 0x0

.field public static final LENGTH_MASK:I = 0x10003

.field public static final LETTERS_MASK:I = 0x18

.field public static final LETTERS_NOOP:I = 0x0

.field public static final LETTERS_SHAPE:I = 0x8

.field public static final LETTERS_SHAPE_TASHKEEL_ISOLATED:I = 0x18

.field public static final LETTERS_UNSHAPE:I = 0x10

.field private static final LINKL:I = 0x2

.field private static final LINKR:I = 0x1

.field private static final LINK_MASK:I = 0x3

.field private static final NEW_TAIL_CHAR:C = '\ufe73'

.field private static final OLD_TAIL_CHAR:C = '\u200b'

.field public static final SEEN_MASK:I = 0x700000

.field public static final SEEN_TWOCELL_NEAR:I = 0x200000

.field private static final SHADDA_CHAR:C = '\ufe7c'

.field private static final SHADDA_TATWEEL_CHAR:C = '\ufe7d'

.field public static final SHAPER:Landroid/icu/text/ArabicShaping; = null

.field private static final SHAPE_MODE:I = 0x0

.field public static final SHAPE_TAIL_NEW_UNICODE:I = 0x8000000

.field public static final SHAPE_TAIL_TYPE_MASK:I = 0x8000000

.field public static final SPACES_RELATIVE_TO_TEXT_BEGIN_END:I = 0x4000000

.field public static final SPACES_RELATIVE_TO_TEXT_MASK:I = 0x4000000

.field private static final SPACE_CHAR:C = ' '

.field private static final SPACE_CHAR_FOR_LAMALEF:C = '\ufeff'

.field public static final TASHKEEL_BEGIN:I = 0x40000

.field public static final TASHKEEL_END:I = 0x60000

.field public static final TASHKEEL_MASK:I = 0xe0000

.field public static final TASHKEEL_REPLACE_BY_TATWEEL:I = 0xc0000

.field public static final TASHKEEL_RESIZE:I = 0x80000

.field private static final TASHKEEL_SPACE_SUB:C = '\ufffe'

.field private static final TATWEEL_CHAR:C = '\u0640'

.field public static final TEXT_DIRECTION_LOGICAL:I = 0x0

.field public static final TEXT_DIRECTION_MASK:I = 0x4

.field public static final TEXT_DIRECTION_VISUAL_LTR:I = 0x4

.field public static final TEXT_DIRECTION_VISUAL_RTL:I = 0x0

.field public static final YEHHAMZA_MASK:I = 0x3800000

.field public static final YEHHAMZA_TWOCELL_NEAR:I = 0x1000000

.field private static final YEH_HAMZAFE_CHAR:C = '\ufe89'

.field private static final YEH_HAMZA_CHAR:C = '\u0626'

.field private static final araLink:[I

.field private static convertFEto06:[I

.field private static final convertNormalizedLamAlef:[C

.field private static final irrelevantPos:[I

.field private static final presLink:[I

.field private static final shapeTable:[[[I

.field private static final tailFamilyIsolatedFinal:[I

.field private static final tashkeelMedial:[I

.field private static final yehHamzaToYeh:[C


# instance fields
.field private isLogical:Z

.field private final options:I

.field private spacesRelativeToTextBeginEnd:Z

.field private tailChar:C


# direct methods
.method static constructor <clinit>()V
    .registers 8

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x1

    const/4 v5, 0x0

    const/4 v4, 0x2

    const/4 v3, 0x4

    .line 66
    new-instance v0, Landroid/icu/text/ArabicShaping;

    const/16 v1, 0x9

    invoke-direct {v0, v1}, Landroid/icu/text/ArabicShaping;-><init>(I)V

    sput-object v0, Landroid/icu/text/ArabicShaping;->SHAPER:Landroid/icu/text/ArabicShaping;

    .line 648
    const/16 v0, 0x8

    new-array v0, v0, [I

    fill-array-data v0, :array_d8

    sput-object v0, Landroid/icu/text/ArabicShaping;->irrelevantPos:[I

    .line 665
    const/16 v0, 0xe

    new-array v0, v0, [I

    fill-array-data v0, :array_ec

    sput-object v0, Landroid/icu/text/ArabicShaping;->tailFamilyIsolatedFinal:[I

    .line 682
    const/16 v0, 0x10

    new-array v0, v0, [I

    fill-array-data v0, :array_10c

    sput-object v0, Landroid/icu/text/ArabicShaping;->tashkeelMedial:[I

    .line 701
    new-array v0, v4, [C

    fill-array-data v0, :array_130

    sput-object v0, Landroid/icu/text/ArabicShaping;->yehHamzaToYeh:[C

    .line 707
    new-array v0, v3, [C

    fill-array-data v0, :array_136

    sput-object v0, Landroid/icu/text/ArabicShaping;->convertNormalizedLamAlef:[C

    .line 714
    const/16 v0, 0xb2

    new-array v0, v0, [I

    fill-array-data v0, :array_13e

    sput-object v0, Landroid/icu/text/ArabicShaping;->araLink:[I

    .line 792
    const/16 v0, 0x8d

    new-array v0, v0, [I

    fill-array-data v0, :array_2a6

    sput-object v0, Landroid/icu/text/ArabicShaping;->presLink:[I

    .line 833
    const/16 v0, 0x8d

    new-array v0, v0, [I

    fill-array-data v0, :array_3c4

    sput-object v0, Landroid/icu/text/ArabicShaping;->convertFEto06:[I

    .line 846
    new-array v0, v3, [[[I

    new-array v1, v3, [[I

    new-array v2, v3, [I

    fill-array-data v2, :array_4e2

    aput-object v2, v1, v5

    new-array v2, v3, [I

    fill-array-data v2, :array_4ee

    aput-object v2, v1, v6

    new-array v2, v3, [I

    fill-array-data v2, :array_4fa

    aput-object v2, v1, v4

    new-array v2, v3, [I

    fill-array-data v2, :array_506

    aput-object v2, v1, v7

    aput-object v1, v0, v5

    new-array v1, v3, [[I

    new-array v2, v3, [I

    fill-array-data v2, :array_512

    aput-object v2, v1, v5

    new-array v2, v3, [I

    fill-array-data v2, :array_51e

    aput-object v2, v1, v6

    new-array v2, v3, [I

    fill-array-data v2, :array_52a

    aput-object v2, v1, v4

    new-array v2, v3, [I

    fill-array-data v2, :array_536

    aput-object v2, v1, v7

    aput-object v1, v0, v6

    new-array v1, v3, [[I

    new-array v2, v3, [I

    fill-array-data v2, :array_542

    aput-object v2, v1, v5

    new-array v2, v3, [I

    fill-array-data v2, :array_54e

    aput-object v2, v1, v6

    new-array v2, v3, [I

    fill-array-data v2, :array_55a

    aput-object v2, v1, v4

    new-array v2, v3, [I

    fill-array-data v2, :array_566

    aput-object v2, v1, v7

    aput-object v1, v0, v4

    new-array v1, v3, [[I

    new-array v2, v3, [I

    fill-array-data v2, :array_572

    aput-object v2, v1, v5

    new-array v2, v3, [I

    fill-array-data v2, :array_57e

    aput-object v2, v1, v6

    new-array v2, v3, [I

    fill-array-data v2, :array_58a

    aput-object v2, v1, v4

    new-array v2, v3, [I

    fill-array-data v2, :array_596

    aput-object v2, v1, v7

    aput-object v1, v0, v7

    sput-object v0, Landroid/icu/text/ArabicShaping;->shapeTable:[[[I

    return-void

    .line 648
    nop

    :array_d8
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x6t 0x0t 0x0t 0x0t
        0x8t 0x0t 0x0t 0x0t
        0xat 0x0t 0x0t 0x0t
        0xct 0x0t 0x0t 0x0t
        0xet 0x0t 0x0t 0x0t
    .end array-data

    .line 665
    :array_ec
    .array-data 0x4
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
    .end array-data

    .line 682
    :array_10c
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
    .end array-data

    .line 701
    :array_130
    .array-data 0x2
        0xeft 0xfet
        0xf0t 0xfet
    .end array-data

    .line 707
    :array_136
    .array-data 0x2
        0x22t 0x6t
        0x23t 0x6t
        0x25t 0x6t
        0x27t 0x6t
    .end array-data

    .line 714
    :array_13e
    .array-data 0x4
        0x21t 0x11t 0x0t 0x0t
        0x21t 0x13t 0x0t 0x0t
        0x1t 0x15t 0x0t 0x0t
        0x21t 0x17t 0x0t 0x0t
        0x3t 0x19t 0x0t 0x0t
        0x21t 0x1dt 0x0t 0x0t
        0x3t 0x1ft 0x0t 0x0t
        0x1t 0x23t 0x0t 0x0t
        0x3t 0x25t 0x0t 0x0t
        0x3t 0x29t 0x0t 0x0t
        0x3t 0x2dt 0x0t 0x0t
        0x3t 0x31t 0x0t 0x0t
        0x3t 0x35t 0x0t 0x0t
        0x1t 0x39t 0x0t 0x0t
        0x1t 0x3bt 0x0t 0x0t
        0x1t 0x3dt 0x0t 0x0t
        0x1t 0x3ft 0x0t 0x0t
        0x3t 0x41t 0x0t 0x0t
        0x3t 0x45t 0x0t 0x0t
        0x3t 0x49t 0x0t 0x0t
        0x3t 0x4dt 0x0t 0x0t
        0x3t 0x51t 0x0t 0x0t
        0x3t 0x55t 0x0t 0x0t
        0x3t 0x59t 0x0t 0x0t
        0x3t 0x5dt 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x61t 0x0t 0x0t
        0x3t 0x65t 0x0t 0x0t
        0x3t 0x69t 0x0t 0x0t
        0x13t 0x6dt 0x0t 0x0t
        0x3t 0x71t 0x0t 0x0t
        0x3t 0x75t 0x0t 0x0t
        0x3t 0x79t 0x0t 0x0t
        0x1t 0x7dt 0x0t 0x0t
        0x1t 0x7ft 0x0t 0x0t
        0x3t 0x81t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x85t 0x0t 0x0t
        0x1t 0x87t 0x0t 0x0t
        0x1t 0x89t 0x0t 0x0t
        0x1t 0x8bt 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x21t 0x0t 0x0t 0x0t
        0x21t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x21t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
    .end array-data

    .line 792
    :array_2a6
    .array-data 0x4
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x20t 0x0t 0x0t 0x0t
        0x21t 0x0t 0x0t 0x0t
        0x20t 0x0t 0x0t 0x0t
        0x21t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x20t 0x0t 0x0t 0x0t
        0x21t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x20t 0x0t 0x0t 0x0t
        0x21t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x10t 0x0t 0x0t 0x0t
        0x12t 0x0t 0x0t 0x0t
        0x13t 0x0t 0x0t 0x0t
        0x11t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
    .end array-data

    .line 833
    :array_3c4
    .array-data 0x4
        0x4bt 0x6t 0x0t 0x0t
        0x4bt 0x6t 0x0t 0x0t
        0x4ct 0x6t 0x0t 0x0t
        0x4ct 0x6t 0x0t 0x0t
        0x4dt 0x6t 0x0t 0x0t
        0x4dt 0x6t 0x0t 0x0t
        0x4et 0x6t 0x0t 0x0t
        0x4et 0x6t 0x0t 0x0t
        0x4ft 0x6t 0x0t 0x0t
        0x4ft 0x6t 0x0t 0x0t
        0x50t 0x6t 0x0t 0x0t
        0x50t 0x6t 0x0t 0x0t
        0x51t 0x6t 0x0t 0x0t
        0x51t 0x6t 0x0t 0x0t
        0x52t 0x6t 0x0t 0x0t
        0x52t 0x6t 0x0t 0x0t
        0x21t 0x6t 0x0t 0x0t
        0x22t 0x6t 0x0t 0x0t
        0x22t 0x6t 0x0t 0x0t
        0x23t 0x6t 0x0t 0x0t
        0x23t 0x6t 0x0t 0x0t
        0x24t 0x6t 0x0t 0x0t
        0x24t 0x6t 0x0t 0x0t
        0x25t 0x6t 0x0t 0x0t
        0x25t 0x6t 0x0t 0x0t
        0x26t 0x6t 0x0t 0x0t
        0x26t 0x6t 0x0t 0x0t
        0x26t 0x6t 0x0t 0x0t
        0x26t 0x6t 0x0t 0x0t
        0x27t 0x6t 0x0t 0x0t
        0x27t 0x6t 0x0t 0x0t
        0x28t 0x6t 0x0t 0x0t
        0x28t 0x6t 0x0t 0x0t
        0x28t 0x6t 0x0t 0x0t
        0x28t 0x6t 0x0t 0x0t
        0x29t 0x6t 0x0t 0x0t
        0x29t 0x6t 0x0t 0x0t
        0x2at 0x6t 0x0t 0x0t
        0x2at 0x6t 0x0t 0x0t
        0x2at 0x6t 0x0t 0x0t
        0x2at 0x6t 0x0t 0x0t
        0x2bt 0x6t 0x0t 0x0t
        0x2bt 0x6t 0x0t 0x0t
        0x2bt 0x6t 0x0t 0x0t
        0x2bt 0x6t 0x0t 0x0t
        0x2ct 0x6t 0x0t 0x0t
        0x2ct 0x6t 0x0t 0x0t
        0x2ct 0x6t 0x0t 0x0t
        0x2ct 0x6t 0x0t 0x0t
        0x2dt 0x6t 0x0t 0x0t
        0x2dt 0x6t 0x0t 0x0t
        0x2dt 0x6t 0x0t 0x0t
        0x2dt 0x6t 0x0t 0x0t
        0x2et 0x6t 0x0t 0x0t
        0x2et 0x6t 0x0t 0x0t
        0x2et 0x6t 0x0t 0x0t
        0x2et 0x6t 0x0t 0x0t
        0x2ft 0x6t 0x0t 0x0t
        0x2ft 0x6t 0x0t 0x0t
        0x30t 0x6t 0x0t 0x0t
        0x30t 0x6t 0x0t 0x0t
        0x31t 0x6t 0x0t 0x0t
        0x31t 0x6t 0x0t 0x0t
        0x32t 0x6t 0x0t 0x0t
        0x32t 0x6t 0x0t 0x0t
        0x33t 0x6t 0x0t 0x0t
        0x33t 0x6t 0x0t 0x0t
        0x33t 0x6t 0x0t 0x0t
        0x33t 0x6t 0x0t 0x0t
        0x34t 0x6t 0x0t 0x0t
        0x34t 0x6t 0x0t 0x0t
        0x34t 0x6t 0x0t 0x0t
        0x34t 0x6t 0x0t 0x0t
        0x35t 0x6t 0x0t 0x0t
        0x35t 0x6t 0x0t 0x0t
        0x35t 0x6t 0x0t 0x0t
        0x35t 0x6t 0x0t 0x0t
        0x36t 0x6t 0x0t 0x0t
        0x36t 0x6t 0x0t 0x0t
        0x36t 0x6t 0x0t 0x0t
        0x36t 0x6t 0x0t 0x0t
        0x37t 0x6t 0x0t 0x0t
        0x37t 0x6t 0x0t 0x0t
        0x37t 0x6t 0x0t 0x0t
        0x37t 0x6t 0x0t 0x0t
        0x38t 0x6t 0x0t 0x0t
        0x38t 0x6t 0x0t 0x0t
        0x38t 0x6t 0x0t 0x0t
        0x38t 0x6t 0x0t 0x0t
        0x39t 0x6t 0x0t 0x0t
        0x39t 0x6t 0x0t 0x0t
        0x39t 0x6t 0x0t 0x0t
        0x39t 0x6t 0x0t 0x0t
        0x3at 0x6t 0x0t 0x0t
        0x3at 0x6t 0x0t 0x0t
        0x3at 0x6t 0x0t 0x0t
        0x3at 0x6t 0x0t 0x0t
        0x41t 0x6t 0x0t 0x0t
        0x41t 0x6t 0x0t 0x0t
        0x41t 0x6t 0x0t 0x0t
        0x41t 0x6t 0x0t 0x0t
        0x42t 0x6t 0x0t 0x0t
        0x42t 0x6t 0x0t 0x0t
        0x42t 0x6t 0x0t 0x0t
        0x42t 0x6t 0x0t 0x0t
        0x43t 0x6t 0x0t 0x0t
        0x43t 0x6t 0x0t 0x0t
        0x43t 0x6t 0x0t 0x0t
        0x43t 0x6t 0x0t 0x0t
        0x44t 0x6t 0x0t 0x0t
        0x44t 0x6t 0x0t 0x0t
        0x44t 0x6t 0x0t 0x0t
        0x44t 0x6t 0x0t 0x0t
        0x45t 0x6t 0x0t 0x0t
        0x45t 0x6t 0x0t 0x0t
        0x45t 0x6t 0x0t 0x0t
        0x45t 0x6t 0x0t 0x0t
        0x46t 0x6t 0x0t 0x0t
        0x46t 0x6t 0x0t 0x0t
        0x46t 0x6t 0x0t 0x0t
        0x46t 0x6t 0x0t 0x0t
        0x47t 0x6t 0x0t 0x0t
        0x47t 0x6t 0x0t 0x0t
        0x47t 0x6t 0x0t 0x0t
        0x47t 0x6t 0x0t 0x0t
        0x48t 0x6t 0x0t 0x0t
        0x48t 0x6t 0x0t 0x0t
        0x49t 0x6t 0x0t 0x0t
        0x49t 0x6t 0x0t 0x0t
        0x4at 0x6t 0x0t 0x0t
        0x4at 0x6t 0x0t 0x0t
        0x4at 0x6t 0x0t 0x0t
        0x4at 0x6t 0x0t 0x0t
        0x5ct 0x6t 0x0t 0x0t
        0x5ct 0x6t 0x0t 0x0t
        0x5dt 0x6t 0x0t 0x0t
        0x5dt 0x6t 0x0t 0x0t
        0x5et 0x6t 0x0t 0x0t
        0x5et 0x6t 0x0t 0x0t
        0x5ft 0x6t 0x0t 0x0t
        0x5ft 0x6t 0x0t 0x0t
    .end array-data

    .line 846
    :array_4e2
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
    .end array-data

    :array_4ee
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
    .end array-data

    :array_4fa
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
    .end array-data

    :array_506
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
    .end array-data

    :array_512
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
    .end array-data

    :array_51e
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
    .end array-data

    :array_52a
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
    .end array-data

    :array_536
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
    .end array-data

    :array_542
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
    .end array-data

    :array_54e
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
    .end array-data

    :array_55a
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
    .end array-data

    :array_566
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
    .end array-data

    :array_572
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
    .end array-data

    :array_57e
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
    .end array-data

    :array_58a
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
    .end array-data

    :array_596
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
    .end array-data
.end method

.method public constructor <init>(I)V
    .registers 8
    .parameter "options"

    .prologue
    const/high16 v5, 0x800

    const/high16 v4, 0x400

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 198
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 199
    iput p1, p0, Landroid/icu/text/ArabicShaping;->options:I

    .line 200
    and-int/lit16 v0, p1, 0xe0

    const/16 v3, 0x80

    if-le v0, v3, :cond_19

    .line 201
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "bad DIGITS options"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 204
    :cond_19
    and-int/lit8 v0, p1, 0x4

    if-nez v0, :cond_30

    move v0, v1

    :goto_1e
    iput-boolean v0, p0, Landroid/icu/text/ArabicShaping;->isLogical:Z

    .line 206
    and-int v0, p1, v4

    if-ne v0, v4, :cond_32

    :goto_24
    iput-boolean v1, p0, Landroid/icu/text/ArabicShaping;->spacesRelativeToTextBeginEnd:Z

    .line 207
    and-int v0, p1, v5

    if-ne v0, v5, :cond_34

    .line 208
    const v0, 0xfe73

    iput-char v0, p0, Landroid/icu/text/ArabicShaping;->tailChar:C

    .line 212
    :goto_2f
    return-void

    :cond_30
    move v0, v2

    .line 204
    goto :goto_1e

    :cond_32
    move v1, v2

    .line 206
    goto :goto_24

    .line 210
    :cond_34
    const/16 v0, 0x200b

    iput-char v0, p0, Landroid/icu/text/ArabicShaping;->tailChar:C

    goto :goto_2f
.end method

.method private calculateSize([CII)I
    .registers 9
    .parameter "source"
    .parameter "sourceStart"
    .parameter "sourceLength"

    .prologue
    const/16 v4, 0x644

    .line 1136
    move v0, p3

    .line 1138
    .local v0, destSize:I
    iget v3, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit8 v3, v3, 0x18

    sparse-switch v3, :sswitch_data_64

    .line 1168
    :cond_a
    return v0

    .line 1141
    :sswitch_b
    iget-boolean v3, p0, Landroid/icu/text/ArabicShaping;->isLogical:Z

    if-eqz v3, :cond_31

    .line 1142
    move v2, p2

    .local v2, i:I
    add-int v3, p2, p3

    add-int/lit8 v1, v3, -0x1

    .local v1, e:I
    :goto_14
    if-ge v2, v1, :cond_a

    .line 1143
    aget-char v3, p1, v2

    if-ne v3, v4, :cond_24

    add-int/lit8 v3, v2, 0x1

    aget-char v3, p1, v3

    invoke-static {v3}, Landroid/icu/text/ArabicShaping;->isAlefChar(C)Z

    move-result v3

    if-nez v3, :cond_2c

    :cond_24
    aget-char v3, p1, v2

    invoke-static {v3}, Landroid/icu/text/ArabicShaping;->isTashkeelCharFE(C)Z

    move-result v3

    if-eqz v3, :cond_2e

    .line 1144
    :cond_2c
    add-int/lit8 v0, v0, -0x1

    .line 1142
    :cond_2e
    add-int/lit8 v2, v2, 0x1

    goto :goto_14

    .line 1148
    .end local v1           #e:I
    .end local v2           #i:I
    :cond_31
    add-int/lit8 v2, p2, 0x1

    .restart local v2       #i:I
    add-int v1, p2, p3

    .restart local v1       #e:I
    :goto_35
    if-ge v2, v1, :cond_a

    .line 1149
    aget-char v3, p1, v2

    if-ne v3, v4, :cond_45

    add-int/lit8 v3, v2, -0x1

    aget-char v3, p1, v3

    invoke-static {v3}, Landroid/icu/text/ArabicShaping;->isAlefChar(C)Z

    move-result v3

    if-nez v3, :cond_4d

    :cond_45
    aget-char v3, p1, v2

    invoke-static {v3}, Landroid/icu/text/ArabicShaping;->isTashkeelCharFE(C)Z

    move-result v3

    if-eqz v3, :cond_4f

    .line 1150
    :cond_4d
    add-int/lit8 v0, v0, -0x1

    .line 1148
    :cond_4f
    add-int/lit8 v2, v2, 0x1

    goto :goto_35

    .line 1157
    .end local v1           #e:I
    .end local v2           #i:I
    :sswitch_52
    move v2, p2

    .restart local v2       #i:I
    add-int v1, p2, p3

    .restart local v1       #e:I
    :goto_55
    if-ge v2, v1, :cond_a

    .line 1158
    aget-char v3, p1, v2

    invoke-static {v3}, Landroid/icu/text/ArabicShaping;->isLamAlefChar(C)Z

    move-result v3

    if-eqz v3, :cond_61

    .line 1159
    add-int/lit8 v0, v0, 0x1

    .line 1157
    :cond_61
    add-int/lit8 v2, v2, 0x1

    goto :goto_55

    .line 1138
    :sswitch_data_64
    .sparse-switch
        0x8 -> :sswitch_b
        0x10 -> :sswitch_52
        0x18 -> :sswitch_b
    .end sparse-switch
.end method

.method private static changeLamAlef(C)C
    .registers 2
    .parameter "ch"

    .prologue
    .line 912
    packed-switch p0, :pswitch_data_12

    .line 917
    :pswitch_3
    const/4 v0, 0x0

    :goto_4
    return v0

    .line 913
    :pswitch_5
    const/16 v0, 0x65c

    goto :goto_4

    .line 914
    :pswitch_8
    const/16 v0, 0x65d

    goto :goto_4

    .line 915
    :pswitch_b
    const/16 v0, 0x65e

    goto :goto_4

    .line 916
    :pswitch_e
    const/16 v0, 0x65f

    goto :goto_4

    .line 912
    nop

    :pswitch_data_12
    .packed-switch 0x622
        :pswitch_5
        :pswitch_8
        :pswitch_3
        :pswitch_b
        :pswitch_3
        :pswitch_e
    .end packed-switch
.end method

.method public static countSpaceSub([CIC)I
    .registers 6
    .parameter "dest"
    .parameter "length"
    .parameter "subChar"

    .prologue
    .line 1177
    const/4 v1, 0x0

    .line 1178
    .local v1, i:I
    const/4 v0, 0x0

    .line 1179
    .local v0, count:I
    :goto_2
    if-ge v1, p1, :cond_d

    .line 1180
    aget-char v2, p0, v1

    if-ne v2, p2, :cond_a

    .line 1181
    add-int/lit8 v0, v0, 0x1

    .line 1183
    :cond_a
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 1185
    :cond_d
    return v0
.end method

.method private static countSpacesLeft([CII)I
    .registers 7
    .parameter "dest"
    .parameter "start"
    .parameter "count"

    .prologue
    .line 972
    move v1, p1

    .local v1, i:I
    add-int v0, p1, p2

    .local v0, e:I
    :goto_3
    if-ge v1, v0, :cond_d

    .line 973
    aget-char v2, p0, v1

    const/16 v3, 0x20

    if-eq v2, v3, :cond_e

    .line 974
    sub-int p2, v1, p1

    .line 977
    .end local p2
    :cond_d
    return p2

    .line 972
    .restart local p2
    :cond_e
    add-int/lit8 v1, v1, 0x1

    goto :goto_3
.end method

.method private static countSpacesRight([CII)I
    .registers 6
    .parameter "dest"
    .parameter "start"
    .parameter "count"

    .prologue
    .line 984
    add-int v0, p1, p2

    .local v0, i:I
    :cond_2
    add-int/lit8 v0, v0, -0x1

    if-lt v0, p1, :cond_12

    .line 985
    aget-char v1, p0, v0

    const/16 v2, 0x20

    if-eq v1, v2, :cond_2

    .line 986
    add-int v1, p1, p2

    add-int/lit8 v1, v1, -0x1

    sub-int p2, v1, v0

    .line 989
    .end local p2
    :cond_12
    return p2
.end method

.method private deShapeUnicode([CIII)I
    .registers 11
    .parameter "dest"
    .parameter "start"
    .parameter "length"
    .parameter "destSize"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/icu/text/ArabicShaping$ArabicShapingException;
        }
    .end annotation

    .prologue
    .line 1802
    invoke-direct {p0, p1, p2, p3}, Landroid/icu/text/ArabicShaping;->deshapeNormalize([CII)I

    move-result v4

    .line 1805
    .local v4, lamalef_count:I
    if-eqz v4, :cond_10

    .line 1807
    const/4 v5, 0x1

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    invoke-direct/range {v0 .. v5}, Landroid/icu/text/ArabicShaping;->expandCompositChar([CIIII)I

    move-result p4

    .line 1812
    :goto_f
    return p4

    .line 1809
    :cond_10
    move p4, p3

    goto :goto_f
.end method

.method private deshapeNormalize([CII)I
    .registers 16
    .parameter "dest"
    .parameter "start"
    .parameter "length"

    .prologue
    const v11, 0xfe70

    const/16 v10, 0x20

    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 1615
    const/4 v3, 0x0

    .line 1616
    .local v3, lacount:I
    const/4 v5, 0x0

    .line 1617
    .local v5, yehHamzaComposeEnabled:I
    const/4 v4, 0x0

    .line 1619
    .local v4, seenComposeEnabled:I
    iget v8, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v9, 0x380

    and-int/2addr v8, v9

    const/high16 v9, 0x100

    if-ne v8, v9, :cond_49

    move v5, v6

    .line 1620
    :goto_14
    iget v8, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v9, 0x70

    and-int/2addr v8, v9

    const/high16 v9, 0x20

    if-ne v8, v9, :cond_4b

    move v4, v6

    .line 1622
    :goto_1e
    move v2, p2

    .local v2, i:I
    add-int v1, v2, p3

    .local v1, e:I
    :goto_21
    if-ge v2, v1, :cond_7f

    .line 1623
    aget-char v0, p1, v2

    .line 1625
    .local v0, ch:C
    if-ne v5, v6, :cond_4d

    const/16 v7, 0x621

    if-eq v0, v7, :cond_30

    const v7, 0xfe80

    if-ne v0, v7, :cond_4d

    :cond_30
    add-int/lit8 v7, p3, -0x1

    if-ge v2, v7, :cond_4d

    add-int/lit8 v7, v2, 0x1

    aget-char v7, p1, v7

    invoke-static {v7}, Landroid/icu/text/ArabicShaping;->isAlefMaksouraChar(C)Z

    move-result v7

    if-eqz v7, :cond_4d

    .line 1627
    aput-char v10, p1, v2

    .line 1628
    add-int/lit8 v7, v2, 0x1

    const/16 v8, 0x626

    aput-char v8, p1, v7

    .line 1622
    :cond_46
    :goto_46
    add-int/lit8 v2, v2, 0x1

    goto :goto_21

    .end local v0           #ch:C
    .end local v1           #e:I
    .end local v2           #i:I
    :cond_49
    move v5, v7

    .line 1619
    goto :goto_14

    :cond_4b
    move v4, v7

    .line 1620
    goto :goto_1e

    .line 1629
    .restart local v0       #ch:C
    .restart local v1       #e:I
    .restart local v2       #i:I
    :cond_4d
    if-ne v4, v6, :cond_66

    invoke-static {v0}, Landroid/icu/text/ArabicShaping;->isTailChar(C)Z

    move-result v7

    if-eqz v7, :cond_66

    add-int/lit8 v7, p3, -0x1

    if-ge v2, v7, :cond_66

    add-int/lit8 v7, v2, 0x1

    aget-char v7, p1, v7

    invoke-static {v7}, Landroid/icu/text/ArabicShaping;->isSeenTailFamilyChar(C)I

    move-result v7

    if-ne v7, v6, :cond_66

    .line 1631
    aput-char v10, p1, v2

    goto :goto_46

    .line 1633
    :cond_66
    if-lt v0, v11, :cond_46

    const v7, 0xfefc

    if-gt v0, v7, :cond_46

    .line 1634
    invoke-static {v0}, Landroid/icu/text/ArabicShaping;->isLamAlefChar(C)Z

    move-result v7

    if-eqz v7, :cond_75

    .line 1635
    add-int/lit8 v3, v3, 0x1

    .line 1637
    :cond_75
    sget-object v7, Landroid/icu/text/ArabicShaping;->convertFEto06:[I

    sub-int v8, v0, v11

    aget v7, v7, v8

    int-to-char v7, v7

    aput-char v7, p1, v2

    goto :goto_46

    .line 1640
    .end local v0           #ch:C
    :cond_7f
    return v3
.end method

.method private expandCompositChar([CIIII)I
    .registers 21
    .parameter "dest"
    .parameter "start"
    .parameter "length"
    .parameter "lacount"
    .parameter "shapingMode"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/icu/text/ArabicShaping$ArabicShapingException;
        }
    .end annotation

    .prologue
    .line 1503
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const v2, 0x10003

    and-int v9, v1, v2

    .line 1504
    .local v9, lenOptionsLamAlef:I
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v2, 0x70

    and-int v10, v1, v2

    .line 1505
    .local v10, lenOptionsSeen:I
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v2, 0x380

    and-int v11, v1, v2

    .line 1506
    .local v11, lenOptionsYehHamza:I
    const/4 v13, 0x0

    .line 1508
    .local v13, spaceNotFound:Z
    iget-boolean v1, p0, Landroid/icu/text/ArabicShaping;->isLogical:Z

    if-nez v1, :cond_1f

    iget-boolean v1, p0, Landroid/icu/text/ArabicShaping;->spacesRelativeToTextBeginEnd:Z

    if-nez v1, :cond_1f

    .line 1509
    packed-switch v9, :pswitch_data_11a

    .line 1516
    :cond_1f
    :goto_1f
    const/4 v1, 0x1

    move/from16 v0, p5

    if-ne v0, v1, :cond_e2

    .line 1517
    const/high16 v1, 0x1

    if-ne v9, v1, :cond_78

    .line 1518
    iget-boolean v1, p0, Landroid/icu/text/ArabicShaping;->isLogical:Z

    if-eqz v1, :cond_54

    .line 1519
    invoke-direct/range {p0 .. p4}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtEnd([CIII)Z

    move-result v13

    .line 1520
    if-eqz v13, :cond_36

    .line 1521
    invoke-direct/range {p0 .. p4}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtBegin([CIII)Z

    move-result v13

    .line 1523
    :cond_36
    if-eqz v13, :cond_46

    .line 1524
    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x1

    move-object v1, p0

    move-object/from16 v2, p1

    move/from16 v3, p2

    move/from16 v4, p3

    invoke-direct/range {v1 .. v7}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtNear([CIIIII)Z

    move-result v13

    .line 1526
    :cond_46
    if-eqz v13, :cond_e1

    .line 1527
    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string v2, "No spacefor lamalef"

    invoke-direct {v1, v2}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1510
    :pswitch_50
    const/4 v9, 0x2

    goto :goto_1f

    .line 1511
    :pswitch_52
    const/4 v9, 0x3

    goto :goto_1f

    .line 1530
    :cond_54
    invoke-direct/range {p0 .. p4}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtBegin([CIII)Z

    move-result v13

    .line 1531
    if-eqz v13, :cond_5e

    .line 1532
    invoke-direct/range {p0 .. p4}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtEnd([CIII)Z

    move-result v13

    .line 1534
    :cond_5e
    if-eqz v13, :cond_6e

    .line 1535
    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x1

    move-object v1, p0

    move-object/from16 v2, p1

    move/from16 v3, p2

    move/from16 v4, p3

    invoke-direct/range {v1 .. v7}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtNear([CIIIII)Z

    move-result v13

    .line 1537
    :cond_6e
    if-eqz v13, :cond_e1

    .line 1538
    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string v2, "No spacefor lamalef"

    invoke-direct {v1, v2}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1541
    :cond_78
    const/4 v1, 0x2

    if-ne v9, v1, :cond_89

    .line 1542
    invoke-direct/range {p0 .. p4}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtEnd([CIII)Z

    move-result v13

    .line 1543
    if-eqz v13, :cond_e1

    .line 1544
    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string v2, "No spacefor lamalef"

    invoke-direct {v1, v2}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1546
    :cond_89
    const/4 v1, 0x3

    if-ne v9, v1, :cond_9a

    .line 1547
    invoke-direct/range {p0 .. p4}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtBegin([CIII)Z

    move-result v13

    .line 1548
    if-eqz v13, :cond_e1

    .line 1549
    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string v2, "No spacefor lamalef"

    invoke-direct {v1, v2}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1551
    :cond_9a
    const/4 v1, 0x1

    if-ne v9, v1, :cond_b5

    .line 1552
    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x1

    move-object v1, p0

    move-object/from16 v2, p1

    move/from16 v3, p2

    move/from16 v4, p3

    invoke-direct/range {v1 .. v7}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtNear([CIIIII)Z

    move-result v13

    .line 1553
    if-eqz v13, :cond_e1

    .line 1554
    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string v2, "No spacefor lamalef"

    invoke-direct {v1, v2}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1556
    :cond_b5
    if-nez v9, :cond_e1

    .line 1557
    add-int v12, p2, p3

    .local v12, r:I
    add-int v14, v12, p4

    .local v14, w:I
    :goto_bb
    add-int/lit8 v12, v12, -0x1

    move/from16 v0, p2

    if-lt v12, v0, :cond_df

    .line 1558
    aget-char v8, p1, v12

    .line 1559
    .local v8, ch:C
    invoke-static {v8}, Landroid/icu/text/ArabicShaping;->isNormalizedLamAlefChar(C)Z

    move-result v1

    if-eqz v1, :cond_da

    .line 1560
    add-int/lit8 v14, v14, -0x1

    const/16 v1, 0x644

    aput-char v1, p1, v14

    .line 1561
    add-int/lit8 v14, v14, -0x1

    sget-object v1, Landroid/icu/text/ArabicShaping;->convertNormalizedLamAlef:[C

    add-int/lit16 v2, v8, -0x65c

    aget-char v1, v1, v2

    aput-char v1, p1, v14

    goto :goto_bb

    .line 1563
    :cond_da
    add-int/lit8 v14, v14, -0x1

    aput-char v8, p1, v14

    goto :goto_bb

    .line 1566
    .end local v8           #ch:C
    :cond_df
    add-int p3, p3, p4

    .line 1582
    .end local v12           #r:I
    .end local v14           #w:I
    :cond_e1
    return p3

    .line 1569
    :cond_e2
    const/high16 v1, 0x20

    if-ne v10, v1, :cond_fe

    .line 1570
    const/4 v5, 0x0

    const/4 v6, 0x1

    const/4 v7, 0x0

    move-object v1, p0

    move-object/from16 v2, p1

    move/from16 v3, p2

    move/from16 v4, p3

    invoke-direct/range {v1 .. v7}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtNear([CIIIII)Z

    move-result v13

    .line 1571
    if-eqz v13, :cond_fe

    .line 1572
    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string v2, "No space for Seen tail expansion"

    invoke-direct {v1, v2}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1575
    :cond_fe
    const/high16 v1, 0x100

    if-ne v11, v1, :cond_e1

    .line 1576
    const/4 v5, 0x1

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v1, p0

    move-object/from16 v2, p1

    move/from16 v3, p2

    move/from16 v4, p3

    invoke-direct/range {v1 .. v7}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtNear([CIIIII)Z

    move-result v13

    .line 1577
    if-eqz v13, :cond_e1

    .line 1578
    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string v2, "No space for YehHamza expansion"

    invoke-direct {v1, v2}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1509
    :pswitch_data_11a
    .packed-switch 0x2
        :pswitch_52
        :pswitch_50
    .end packed-switch
.end method

.method private expandCompositCharAtBegin([CIII)Z
    .registers 12
    .parameter "dest"
    .parameter "start"
    .parameter "length"
    .parameter "lacount"

    .prologue
    .line 1387
    const/4 v2, 0x0

    .line 1389
    .local v2, spaceNotFound:Z
    invoke-static {p1, p2, p3}, Landroid/icu/text/ArabicShaping;->countSpacesRight([CII)I

    move-result v5

    if-le p4, v5, :cond_a

    .line 1390
    const/4 v2, 0x1

    move v3, v2

    .line 1402
    .end local v2           #spaceNotFound:Z
    .local v3, spaceNotFound:I
    :goto_9
    return v3

    .line 1393
    .end local v3           #spaceNotFound:I
    .restart local v2       #spaceNotFound:Z
    :cond_a
    add-int v5, p2, p3

    sub-int v1, v5, p4

    .local v1, r:I
    add-int v4, p2, p3

    .local v4, w:I
    :goto_10
    add-int/lit8 v1, v1, -0x1

    if-lt v1, p2, :cond_32

    .line 1394
    aget-char v0, p1, v1

    .line 1395
    .local v0, ch:C
    invoke-static {v0}, Landroid/icu/text/ArabicShaping;->isNormalizedLamAlefChar(C)Z

    move-result v5

    if-eqz v5, :cond_2d

    .line 1396
    add-int/lit8 v4, v4, -0x1

    const/16 v5, 0x644

    aput-char v5, p1, v4

    .line 1397
    add-int/lit8 v4, v4, -0x1

    sget-object v5, Landroid/icu/text/ArabicShaping;->convertNormalizedLamAlef:[C

    add-int/lit16 v6, v0, -0x65c

    aget-char v5, v5, v6

    aput-char v5, p1, v4

    goto :goto_10

    .line 1399
    :cond_2d
    add-int/lit8 v4, v4, -0x1

    aput-char v0, p1, v4

    goto :goto_10

    .end local v0           #ch:C
    :cond_32
    move v3, v2

    .line 1402
    .restart local v3       #spaceNotFound:I
    goto :goto_9
.end method

.method private expandCompositCharAtEnd([CIII)Z
    .registers 14
    .parameter "dest"
    .parameter "start"
    .parameter "length"
    .parameter "lacount"

    .prologue
    .line 1417
    const/4 v3, 0x0

    .line 1419
    .local v3, spaceNotFound:Z
    invoke-static {p1, p2, p3}, Landroid/icu/text/ArabicShaping;->countSpacesLeft([CII)I

    move-result v7

    if-le p4, v7, :cond_a

    .line 1420
    const/4 v3, 0x1

    move v4, v3

    .line 1432
    .end local v3           #spaceNotFound:Z
    .local v4, spaceNotFound:I
    :goto_9
    return v4

    .line 1423
    .end local v4           #spaceNotFound:I
    .restart local v3       #spaceNotFound:Z
    :cond_a
    add-int v2, p2, p4

    .local v2, r:I
    move v5, p2

    .local v5, w:I
    add-int v1, p2, p3

    .local v1, e:I
    move v6, v5

    .end local v5           #w:I
    .local v6, w:I
    :goto_10
    if-ge v2, v1, :cond_34

    .line 1424
    aget-char v0, p1, v2

    .line 1425
    .local v0, ch:C
    invoke-static {v0}, Landroid/icu/text/ArabicShaping;->isNormalizedLamAlefChar(C)Z

    move-result v7

    if-eqz v7, :cond_2f

    .line 1426
    add-int/lit8 v5, v6, 0x1

    .end local v6           #w:I
    .restart local v5       #w:I
    sget-object v7, Landroid/icu/text/ArabicShaping;->convertNormalizedLamAlef:[C

    add-int/lit16 v8, v0, -0x65c

    aget-char v7, v7, v8

    aput-char v7, p1, v6

    .line 1427
    add-int/lit8 v6, v5, 0x1

    .end local v5           #w:I
    .restart local v6       #w:I
    const/16 v7, 0x644

    aput-char v7, p1, v5

    move v5, v6

    .line 1423
    .end local v6           #w:I
    .restart local v5       #w:I
    :goto_2b
    add-int/lit8 v2, v2, 0x1

    move v6, v5

    .end local v5           #w:I
    .restart local v6       #w:I
    goto :goto_10

    .line 1429
    :cond_2f
    add-int/lit8 v5, v6, 0x1

    .end local v6           #w:I
    .restart local v5       #w:I
    aput-char v0, p1, v6

    goto :goto_2b

    .end local v0           #ch:C
    .end local v5           #w:I
    .restart local v6       #w:I
    :cond_34
    move v4, v3

    .line 1432
    .restart local v4       #spaceNotFound:I
    goto :goto_9
.end method

.method private expandCompositCharAtNear([CIIIII)Z
    .registers 14
    .parameter "dest"
    .parameter "start"
    .parameter "length"
    .parameter "yehHamzaOption"
    .parameter "seenTailOption"
    .parameter "lamAlefOption"

    .prologue
    const/16 v6, 0x20

    const/4 v5, 0x1

    .line 1445
    const/4 v2, 0x0

    .line 1449
    .local v2, spaceNotFound:Z
    aget-char v3, p1, p2

    invoke-static {v3}, Landroid/icu/text/ArabicShaping;->isNormalizedLamAlefChar(C)Z

    move-result v3

    if-eqz v3, :cond_f

    .line 1450
    const/4 v2, 0x1

    move v3, v2

    .line 1483
    :goto_e
    return v3

    .line 1453
    :cond_f
    add-int v1, p2, p3

    .local v1, i:I
    :cond_11
    :goto_11
    add-int/lit8 v1, v1, -0x1

    if-lt v1, p2, :cond_79

    .line 1454
    aget-char v0, p1, v1

    .line 1455
    .local v0, ch:C
    if-ne p6, v5, :cond_39

    invoke-static {v0}, Landroid/icu/text/ArabicShaping;->isNormalizedLamAlefChar(C)Z

    move-result v3

    if-eqz v3, :cond_39

    .line 1456
    if-le v1, p2, :cond_36

    add-int/lit8 v3, v1, -0x1

    aget-char v3, p1, v3

    if-ne v3, v6, :cond_36

    .line 1457
    const/16 v3, 0x644

    aput-char v3, p1, v1

    .line 1458
    add-int/lit8 v1, v1, -0x1

    sget-object v3, Landroid/icu/text/ArabicShaping;->convertNormalizedLamAlef:[C

    add-int/lit16 v4, v0, -0x65c

    aget-char v3, v3, v4

    aput-char v3, p1, v1

    goto :goto_11

    .line 1460
    :cond_36
    const/4 v2, 0x1

    move v3, v2

    .line 1461
    goto :goto_e

    .line 1463
    :cond_39
    if-ne p5, v5, :cond_53

    invoke-static {v0}, Landroid/icu/text/ArabicShaping;->isSeenTailFamilyChar(C)I

    move-result v3

    if-ne v3, v5, :cond_53

    .line 1464
    if-le v1, p2, :cond_50

    add-int/lit8 v3, v1, -0x1

    aget-char v3, p1, v3

    if-ne v3, v6, :cond_50

    .line 1465
    add-int/lit8 v3, v1, -0x1

    iget-char v4, p0, Landroid/icu/text/ArabicShaping;->tailChar:C

    aput-char v4, p1, v3

    goto :goto_11

    .line 1467
    :cond_50
    const/4 v2, 0x1

    move v3, v2

    .line 1468
    goto :goto_e

    .line 1470
    :cond_53
    if-ne p4, v5, :cond_11

    invoke-static {v0}, Landroid/icu/text/ArabicShaping;->isYehHamzaChar(C)Z

    move-result v3

    if-eqz v3, :cond_11

    .line 1472
    if-le v1, p2, :cond_76

    add-int/lit8 v3, v1, -0x1

    aget-char v3, p1, v3

    if-ne v3, v6, :cond_76

    .line 1473
    sget-object v3, Landroid/icu/text/ArabicShaping;->yehHamzaToYeh:[C

    const v4, 0xfe89

    sub-int v4, v0, v4

    aget-char v3, v3, v4

    aput-char v3, p1, v1

    .line 1474
    add-int/lit8 v3, v1, -0x1

    const v4, 0xfe80

    aput-char v4, p1, v3

    goto :goto_11

    .line 1476
    :cond_76
    const/4 v2, 0x1

    move v3, v2

    .line 1477
    goto :goto_e

    .line 1483
    .end local v0           #ch:C
    :cond_79
    const/4 v3, 0x0

    goto :goto_e
.end method

.method public static flipArray([CIII)I
    .registers 8
    .parameter "dest"
    .parameter "start"
    .parameter "e"
    .parameter "w"

    .prologue
    .line 1212
    if-le p3, p1, :cond_13

    .line 1214
    move v0, p3

    .line 1215
    .local v0, r:I
    move p3, p1

    move v1, v0

    .end local v0           #r:I
    .local v1, r:I
    move v2, p3

    .line 1216
    .end local p3
    .local v2, w:I
    :goto_6
    if-ge v1, p2, :cond_15

    .line 1217
    add-int/lit8 p3, v2, 0x1

    .end local v2           #w:I
    .restart local p3
    add-int/lit8 v0, v1, 0x1

    .end local v1           #r:I
    .restart local v0       #r:I
    aget-char v3, p0, v1

    aput-char v3, p0, v2

    move v1, v0

    .end local v0           #r:I
    .restart local v1       #r:I
    move v2, p3

    .end local p3
    .restart local v2       #w:I
    goto :goto_6

    .line 1220
    .end local v1           #r:I
    .end local v2           #w:I
    .restart local p3
    :cond_13
    move p3, p2

    .line 1222
    :goto_14
    return p3

    .end local p3
    .restart local v1       #r:I
    .restart local v2       #w:I
    :cond_15
    move p3, v2

    .end local v2           #w:I
    .restart local p3
    goto :goto_14
.end method

.method private static getLink(C)I
    .registers 3
    .parameter "ch"

    .prologue
    const v1, 0xfe70

    .line 951
    const/16 v0, 0x622

    if-lt p0, v0, :cond_12

    const/16 v0, 0x6d3

    if-gt p0, v0, :cond_12

    .line 952
    sget-object v0, Landroid/icu/text/ArabicShaping;->araLink:[I

    add-int/lit16 v1, p0, -0x622

    aget v0, v0, v1

    .line 960
    :goto_11
    return v0

    .line 953
    :cond_12
    const/16 v0, 0x200d

    if-ne p0, v0, :cond_18

    .line 954
    const/4 v0, 0x3

    goto :goto_11

    .line 955
    :cond_18
    const/16 v0, 0x206d

    if-lt p0, v0, :cond_22

    const/16 v0, 0x206f

    if-gt p0, v0, :cond_22

    .line 956
    const/4 v0, 0x4

    goto :goto_11

    .line 957
    :cond_22
    if-lt p0, v1, :cond_30

    const v0, 0xfefc

    if-gt p0, v0, :cond_30

    .line 958
    sget-object v0, Landroid/icu/text/ArabicShaping;->presLink:[I

    sub-int v1, p0, v1

    aget v0, v0, v1

    goto :goto_11

    .line 960
    :cond_30
    const/4 v0, 0x0

    goto :goto_11
.end method

.method private handleGeneratedSpaces([CII)I
    .registers 16
    .parameter "dest"
    .parameter "start"
    .parameter "length"

    .prologue
    .line 1270
    iget v10, p0, Landroid/icu/text/ArabicShaping;->options:I

    const v11, 0x10003

    and-int v3, v10, v11

    .line 1271
    .local v3, lenOptionsLamAlef:I
    iget v10, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v11, 0xe

    and-int v4, v10, v11

    .line 1272
    .local v4, lenOptionsTashkeel:I
    const/4 v2, 0x0

    .line 1273
    .local v2, lamAlefOn:Z
    const/4 v5, 0x0

    .line 1275
    .local v5, tashkeelOn:Z
    iget-boolean v10, p0, Landroid/icu/text/ArabicShaping;->isLogical:Z

    if-nez v10, :cond_39

    const/4 v10, 0x1

    :goto_14
    iget-boolean v11, p0, Landroid/icu/text/ArabicShaping;->spacesRelativeToTextBeginEnd:Z

    if-nez v11, :cond_3b

    const/4 v11, 0x1

    :goto_19
    and-int/2addr v10, v11

    if-eqz v10, :cond_22

    .line 1276
    packed-switch v3, :pswitch_data_100

    .line 1281
    :goto_1f
    sparse-switch v4, :sswitch_data_108

    .line 1289
    :cond_22
    :goto_22
    const/4 v10, 0x1

    if-ne v3, v10, :cond_47

    .line 1290
    move v1, p2

    .local v1, i:I
    add-int v0, v1, p3

    .local v0, e:I
    :goto_28
    if-ge v1, v0, :cond_fe

    .line 1291
    aget-char v10, p1, v1

    const v11, 0xffff

    if-ne v10, v11, :cond_36

    .line 1292
    const v10, 0xfeff

    aput-char v10, p1, v1

    .line 1290
    :cond_36
    add-int/lit8 v1, v1, 0x1

    goto :goto_28

    .line 1275
    .end local v0           #e:I
    .end local v1           #i:I
    :cond_39
    const/4 v10, 0x0

    goto :goto_14

    :cond_3b
    const/4 v11, 0x0

    goto :goto_19

    .line 1277
    :pswitch_3d
    const/4 v3, 0x2

    goto :goto_1f

    .line 1278
    :pswitch_3f
    const/4 v3, 0x3

    goto :goto_1f

    .line 1282
    :sswitch_41
    const/high16 v4, 0x6

    goto :goto_22

    .line 1283
    :sswitch_44
    const/high16 v4, 0x4

    goto :goto_22

    .line 1298
    :cond_47
    add-int v0, p2, p3

    .line 1299
    .restart local v0       #e:I
    const v10, 0xffff

    invoke-static {p1, p3, v10}, Landroid/icu/text/ArabicShaping;->countSpaceSub([CIC)I

    move-result v6

    .line 1300
    .local v6, wL:I
    const v10, 0xfffe

    invoke-static {p1, p3, v10}, Landroid/icu/text/ArabicShaping;->countSpaceSub([CIC)I

    move-result v8

    .line 1302
    .local v8, wT:I
    const/4 v10, 0x2

    if-ne v3, v10, :cond_5b

    .line 1303
    const/4 v2, 0x1

    .line 1305
    :cond_5b
    const/high16 v10, 0x6

    if-ne v4, v10, :cond_60

    .line 1306
    const/4 v5, 0x1

    .line 1310
    :cond_60
    if-eqz v2, :cond_74

    const/4 v10, 0x2

    if-ne v3, v10, :cond_74

    .line 1311
    const v10, 0xffff

    invoke-static {p1, p2, v0, v10}, Landroid/icu/text/ArabicShaping;->shiftArray([CIIC)V

    .line 1312
    :goto_6b
    if-le v6, p2, :cond_74

    .line 1313
    add-int/lit8 v6, v6, -0x1

    const/16 v10, 0x20

    aput-char v10, p1, v6

    goto :goto_6b

    .line 1317
    :cond_74
    if-eqz v5, :cond_89

    const/high16 v10, 0x6

    if-ne v4, v10, :cond_89

    .line 1318
    const v10, 0xfffe

    invoke-static {p1, p2, v0, v10}, Landroid/icu/text/ArabicShaping;->shiftArray([CIIC)V

    .line 1319
    :goto_80
    if-le v8, p2, :cond_89

    .line 1320
    add-int/lit8 v8, v8, -0x1

    const/16 v10, 0x20

    aput-char v10, p1, v8

    goto :goto_80

    .line 1324
    :cond_89
    const/4 v2, 0x0

    .line 1325
    const/4 v5, 0x0

    .line 1327
    if-nez v3, :cond_8e

    .line 1328
    const/4 v2, 0x1

    .line 1330
    :cond_8e
    const/high16 v10, 0x8

    if-ne v4, v10, :cond_93

    .line 1331
    const/4 v5, 0x1

    .line 1334
    :cond_93
    if-eqz v2, :cond_a3

    if-nez v3, :cond_a3

    .line 1335
    const v10, 0xffff

    invoke-static {p1, p2, v0, v10}, Landroid/icu/text/ArabicShaping;->shiftArray([CIIC)V

    .line 1336
    invoke-static {p1, p2, v0, v6}, Landroid/icu/text/ArabicShaping;->flipArray([CIII)I

    move-result v6

    .line 1337
    sub-int p3, v6, p2

    .line 1339
    :cond_a3
    if-eqz v5, :cond_b5

    const/high16 v10, 0x8

    if-ne v4, v10, :cond_b5

    .line 1340
    const v10, 0xfffe

    invoke-static {p1, p2, v0, v10}, Landroid/icu/text/ArabicShaping;->shiftArray([CIIC)V

    .line 1341
    invoke-static {p1, p2, v0, v8}, Landroid/icu/text/ArabicShaping;->flipArray([CIII)I

    move-result v8

    .line 1342
    sub-int p3, v8, p2

    .line 1345
    :cond_b5
    const/4 v2, 0x0

    .line 1346
    const/4 v5, 0x0

    .line 1348
    const/4 v10, 0x3

    if-eq v3, v10, :cond_be

    const/high16 v10, 0x1

    if-ne v3, v10, :cond_bf

    .line 1350
    :cond_be
    const/4 v2, 0x1

    .line 1352
    :cond_bf
    const/high16 v10, 0x4

    if-ne v4, v10, :cond_c4

    .line 1353
    const/4 v5, 0x1

    .line 1356
    :cond_c4
    if-eqz v2, :cond_e3

    const/4 v10, 0x3

    if-eq v3, v10, :cond_cd

    const/high16 v10, 0x1

    if-ne v3, v10, :cond_e3

    .line 1358
    :cond_cd
    const v10, 0xffff

    invoke-static {p1, p2, v0, v10}, Landroid/icu/text/ArabicShaping;->shiftArray([CIIC)V

    .line 1359
    invoke-static {p1, p2, v0, v6}, Landroid/icu/text/ArabicShaping;->flipArray([CIII)I

    move-result v6

    move v7, v6

    .line 1360
    .end local v6           #wL:I
    .local v7, wL:I
    :goto_d8
    if-ge v7, v0, :cond_e2

    .line 1361
    add-int/lit8 v6, v7, 0x1

    .end local v7           #wL:I
    .restart local v6       #wL:I
    const/16 v10, 0x20

    aput-char v10, p1, v7

    move v7, v6

    .end local v6           #wL:I
    .restart local v7       #wL:I
    goto :goto_d8

    :cond_e2
    move v6, v7

    .line 1364
    .end local v7           #wL:I
    .restart local v6       #wL:I
    :cond_e3
    if-eqz v5, :cond_fe

    const/high16 v10, 0x4

    if-ne v4, v10, :cond_fe

    .line 1365
    const v10, 0xfffe

    invoke-static {p1, p2, v0, v10}, Landroid/icu/text/ArabicShaping;->shiftArray([CIIC)V

    .line 1366
    invoke-static {p1, p2, v0, v8}, Landroid/icu/text/ArabicShaping;->flipArray([CIII)I

    move-result v8

    move v9, v8

    .line 1367
    .end local v8           #wT:I
    .local v9, wT:I
    :goto_f4
    if-ge v9, v0, :cond_fe

    .line 1368
    add-int/lit8 v8, v9, 0x1

    .end local v9           #wT:I
    .restart local v8       #wT:I
    const/16 v10, 0x20

    aput-char v10, p1, v9

    move v9, v8

    .end local v8           #wT:I
    .restart local v9       #wT:I
    goto :goto_f4

    .line 1373
    .end local v6           #wL:I
    .end local v9           #wT:I
    :cond_fe
    return p3

    .line 1276
    nop

    :pswitch_data_100
    .packed-switch 0x2
        :pswitch_3f
        :pswitch_3d
    .end packed-switch

    .line 1281
    :sswitch_data_108
    .sparse-switch
        0x40000 -> :sswitch_41
        0x60000 -> :sswitch_44
    .end sparse-switch
.end method

.method private static handleTashkeelWithTatweel([CI)I
    .registers 6
    .parameter "dest"
    .parameter "sourceLength"

    .prologue
    const/4 v3, 0x1

    .line 1236
    const/4 v0, 0x0

    .local v0, i:I
    :goto_2
    if-ge v0, p1, :cond_36

    .line 1237
    aget-char v1, p0, v0

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->isTashkeelOnTatweelChar(C)I

    move-result v1

    if-ne v1, v3, :cond_13

    .line 1238
    const/16 v1, 0x640

    aput-char v1, p0, v0

    .line 1236
    :cond_10
    :goto_10
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 1239
    :cond_13
    aget-char v1, p0, v0

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->isTashkeelOnTatweelChar(C)I

    move-result v1

    const/4 v2, 0x2

    if-ne v1, v2, :cond_22

    .line 1240
    const v1, 0xfe7d

    aput-char v1, p0, v0

    goto :goto_10

    .line 1241
    :cond_22
    aget-char v1, p0, v0

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->isIsolatedTashkeelChar(C)I

    move-result v1

    if-ne v1, v3, :cond_10

    aget-char v1, p0, v0

    const v2, 0xfe7c

    if-eq v1, v2, :cond_10

    .line 1242
    const/16 v1, 0x20

    aput-char v1, p0, v0

    goto :goto_10

    .line 1245
    :cond_36
    return p1
.end method

.method private internalShape([CII[CII)I
    .registers 18
    .parameter "source"
    .parameter "sourceStart"
    .parameter "sourceLength"
    .parameter "dest"
    .parameter "destStart"
    .parameter "destSize"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/icu/text/ArabicShaping$ArabicShapingException;
        }
    .end annotation

    .prologue
    .line 1822
    if-nez p3, :cond_4

    .line 1823
    const/4 p3, 0x0

    .line 1939
    .end local p3
    :cond_3
    :goto_3
    return p3

    .line 1826
    .restart local p3
    :cond_4
    if-nez p6, :cond_19

    .line 1827
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit8 v1, v1, 0x18

    if-eqz v1, :cond_3

    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const v3, 0x10003

    and-int/2addr v1, v3

    if-nez v1, :cond_3

    .line 1830
    invoke-direct {p0, p1, p2, p3}, Landroid/icu/text/ArabicShaping;->calculateSize([CII)I

    move-result p3

    goto :goto_3

    .line 1837
    :cond_19
    mul-int/lit8 v1, p3, 0x2

    new-array v2, v1, [C

    .line 1838
    .local v2, temp:[C
    const/4 v1, 0x0

    invoke-static {p1, p2, v2, v1, p3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1840
    iget-boolean v1, p0, Landroid/icu/text/ArabicShaping;->isLogical:Z

    if-eqz v1, :cond_29

    .line 1841
    const/4 v1, 0x0

    invoke-static {v2, v1, p3}, Landroid/icu/text/ArabicShaping;->invertBuffer([CII)V

    .line 1844
    :cond_29
    move v4, p3

    .line 1846
    .local v4, outputSize:I
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit8 v1, v1, 0x18

    sparse-switch v1, :sswitch_data_ee

    .line 1875
    :cond_31
    :goto_31
    move/from16 v0, p6

    if-le v4, v0, :cond_84

    .line 1876
    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string/jumbo v3, "not enough room for result data"

    invoke-direct {v1, v3}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1848
    :sswitch_3e
    const/4 v3, 0x0

    const/4 v6, 0x1

    move-object v1, p0

    move v4, p3

    move/from16 v5, p6

    invoke-direct/range {v1 .. v6}, Landroid/icu/text/ArabicShaping;->shapeUnicode([CIIII)I

    .end local v4           #outputSize:I
    move-result v4

    .line 1849
    .restart local v4       #outputSize:I
    goto :goto_31

    .line 1852
    :sswitch_49
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v3, 0xe

    and-int/2addr v1, v3

    if-lez v1, :cond_64

    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v3, 0xe

    and-int/2addr v1, v3

    const/high16 v3, 0xc

    if-eq v1, v3, :cond_64

    .line 1855
    const/4 v3, 0x0

    const/4 v6, 0x2

    move-object v1, p0

    move v4, p3

    move/from16 v5, p6

    invoke-direct/range {v1 .. v6}, Landroid/icu/text/ArabicShaping;->shapeUnicode([CIIII)I

    .end local v4           #outputSize:I
    move-result v4

    .restart local v4       #outputSize:I
    goto :goto_31

    .line 1858
    :cond_64
    const/4 v3, 0x0

    const/4 v6, 0x0

    move-object v1, p0

    move v4, p3

    move/from16 v5, p6

    invoke-direct/range {v1 .. v6}, Landroid/icu/text/ArabicShaping;->shapeUnicode([CIIII)I

    .end local v4           #outputSize:I
    move-result v4

    .line 1861
    .restart local v4       #outputSize:I
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v3, 0xe

    and-int/2addr v1, v3

    const/high16 v3, 0xc

    if-ne v1, v3, :cond_31

    .line 1862
    invoke-static {v2, p3}, Landroid/icu/text/ArabicShaping;->handleTashkeelWithTatweel([CI)I

    move-result v4

    goto :goto_31

    .line 1868
    :sswitch_7c
    const/4 v1, 0x0

    move/from16 v0, p6

    invoke-direct {p0, v2, v1, p3, v0}, Landroid/icu/text/ArabicShaping;->deShapeUnicode([CIII)I

    move-result v4

    .line 1869
    goto :goto_31

    .line 1879
    :cond_84
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit16 v1, v1, 0xe0

    if-eqz v1, :cond_9a

    .line 1880
    const/16 v5, 0x30

    .line 1881
    .local v5, digitBase:C
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit16 v1, v1, 0x100

    sparse-switch v1, :sswitch_data_fc

    .line 1894
    :goto_93
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit16 v1, v1, 0xe0

    sparse-switch v1, :sswitch_data_106

    .line 1933
    .end local v5           #digitBase:C
    :cond_9a
    :goto_9a
    iget-boolean v1, p0, Landroid/icu/text/ArabicShaping;->isLogical:Z

    if-eqz v1, :cond_a2

    .line 1934
    const/4 v1, 0x0

    invoke-static {v2, v1, v4}, Landroid/icu/text/ArabicShaping;->invertBuffer([CII)V

    .line 1937
    :cond_a2
    const/4 v1, 0x0

    move/from16 v0, p5

    invoke-static {v2, v1, p4, v0, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move p3, v4

    .line 1939
    goto/16 :goto_3

    .line 1883
    .restart local v5       #digitBase:C
    :sswitch_ab
    const/16 v5, 0x660

    .line 1884
    goto :goto_93

    .line 1887
    :sswitch_ae
    const/16 v5, 0x6f0

    .line 1888
    goto :goto_93

    .line 1897
    :sswitch_b1
    add-int/lit8 v8, v5, -0x30

    .line 1898
    .local v8, digitDelta:I
    const/4 v10, 0x0

    .local v10, i:I
    :goto_b4
    if-ge v10, v4, :cond_9a

    .line 1899
    aget-char v7, v2, v10

    .line 1900
    .local v7, ch:C
    const/16 v1, 0x39

    if-gt v7, v1, :cond_c6

    const/16 v1, 0x30

    if-lt v7, v1, :cond_c6

    .line 1901
    aget-char v1, v2, v10

    add-int/2addr v1, v8

    int-to-char v1, v1

    aput-char v1, v2, v10

    .line 1898
    :cond_c6
    add-int/lit8 v10, v10, 0x1

    goto :goto_b4

    .line 1909
    .end local v7           #ch:C
    .end local v8           #digitDelta:I
    .end local v10           #i:I
    :sswitch_c9
    add-int/lit8 v1, v5, 0x9

    int-to-char v9, v1

    .line 1910
    .local v9, digitTop:C
    rsub-int/lit8 v8, v5, 0x30

    .line 1911
    .restart local v8       #digitDelta:I
    const/4 v10, 0x0

    .restart local v10       #i:I
    :goto_cf
    if-ge v10, v4, :cond_9a

    .line 1912
    aget-char v7, v2, v10

    .line 1913
    .restart local v7       #ch:C
    if-gt v7, v9, :cond_dd

    if-lt v7, v5, :cond_dd

    .line 1914
    aget-char v1, v2, v10

    add-int/2addr v1, v8

    int-to-char v1, v1

    aput-char v1, v2, v10

    .line 1911
    :cond_dd
    add-int/lit8 v10, v10, 0x1

    goto :goto_cf

    .line 1921
    .end local v7           #ch:C
    .end local v8           #digitDelta:I
    .end local v9           #digitTop:C
    .end local v10           #i:I
    :sswitch_e0
    const/4 v3, 0x0

    const/4 v6, 0x0

    move-object v1, p0

    invoke-direct/range {v1 .. v6}, Landroid/icu/text/ArabicShaping;->shapeToArabicDigitsWithContext([CIICZ)V

    goto :goto_9a

    .line 1925
    :sswitch_e7
    const/4 v3, 0x0

    const/4 v6, 0x1

    move-object v1, p0

    invoke-direct/range {v1 .. v6}, Landroid/icu/text/ArabicShaping;->shapeToArabicDigitsWithContext([CIICZ)V

    goto :goto_9a

    .line 1846
    :sswitch_data_ee
    .sparse-switch
        0x8 -> :sswitch_49
        0x10 -> :sswitch_7c
        0x18 -> :sswitch_3e
    .end sparse-switch

    .line 1881
    :sswitch_data_fc
    .sparse-switch
        0x0 -> :sswitch_ab
        0x100 -> :sswitch_ae
    .end sparse-switch

    .line 1894
    :sswitch_data_106
    .sparse-switch
        0x20 -> :sswitch_b1
        0x40 -> :sswitch_c9
        0x60 -> :sswitch_e0
        0x80 -> :sswitch_e7
    .end sparse-switch
.end method

.method private static invertBuffer([CII)V
    .registers 7
    .parameter "buffer"
    .parameter "start"
    .parameter "length"

    .prologue
    .line 896
    move v0, p1

    .local v0, i:I
    add-int v3, p1, p2

    add-int/lit8 v1, v3, -0x1

    .local v1, j:I
    :goto_5
    if-ge v0, v1, :cond_14

    .line 897
    aget-char v2, p0, v0

    .line 898
    .local v2, temp:C
    aget-char v3, p0, v1

    aput-char v3, p0, v0

    .line 899
    aput-char v2, p0, v1

    .line 896
    add-int/lit8 v0, v0, 0x1

    add-int/lit8 v1, v1, -0x1

    goto :goto_5

    .line 901
    .end local v2           #temp:C
    :cond_14
    return-void
.end method

.method private static isAlefChar(C)Z
    .registers 2
    .parameter "ch"

    .prologue
    .line 1112
    const/16 v0, 0x622

    if-eq p0, v0, :cond_10

    const/16 v0, 0x623

    if-eq p0, v0, :cond_10

    const/16 v0, 0x625

    if-eq p0, v0, :cond_10

    const/16 v0, 0x627

    if-ne p0, v0, :cond_12

    :cond_10
    const/4 v0, 0x1

    :goto_11
    return v0

    :cond_12
    const/4 v0, 0x0

    goto :goto_11
.end method

.method private static isAlefMaksouraChar(C)Z
    .registers 2
    .parameter "ch"

    .prologue
    .line 1047
    const v0, 0xfeef

    if-eq p0, v0, :cond_e

    const v0, 0xfef0

    if-eq p0, v0, :cond_e

    const/16 v0, 0x649

    if-ne p0, v0, :cond_10

    :cond_e
    const/4 v0, 0x1

    :goto_f
    return v0

    :cond_10
    const/4 v0, 0x0

    goto :goto_f
.end method

.method private static isIsolatedTashkeelChar(C)I
    .registers 3
    .parameter "ch"

    .prologue
    const v1, 0xfe70

    .line 1098
    if-lt p0, v1, :cond_1d

    const v0, 0xfe7f

    if-gt p0, v0, :cond_1d

    const v0, 0xfe73

    if-eq p0, v0, :cond_1d

    const v0, 0xfe75

    if-eq p0, v0, :cond_1d

    .line 1099
    sget-object v0, Landroid/icu/text/ArabicShaping;->tashkeelMedial:[I

    sub-int v1, p0, v1

    aget v0, v0, v1

    rsub-int/lit8 v0, v0, 0x1

    .line 1103
    :goto_1c
    return v0

    .line 1100
    :cond_1d
    const v0, 0xfc5e

    if-lt p0, v0, :cond_29

    const v0, 0xfc63

    if-gt p0, v0, :cond_29

    .line 1101
    const/4 v0, 0x1

    goto :goto_1c

    .line 1103
    :cond_29
    const/4 v0, 0x0

    goto :goto_1c
.end method

.method private static isLamAlefChar(C)Z
    .registers 2
    .parameter "ch"

    .prologue
    .line 1120
    const v0, 0xfef5

    if-lt p0, v0, :cond_c

    const v0, 0xfefc

    if-gt p0, v0, :cond_c

    const/4 v0, 0x1

    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method

.method private static isNormalizedLamAlefChar(C)Z
    .registers 2
    .parameter "ch"

    .prologue
    .line 1124
    const/16 v0, 0x65c

    if-lt p0, v0, :cond_a

    const/16 v0, 0x65f

    if-gt p0, v0, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method private static isSeenFamilyChar(C)I
    .registers 2
    .parameter "ch"

    .prologue
    .line 1020
    const/16 v0, 0x633

    if-lt p0, v0, :cond_a

    const/16 v0, 0x636

    if-gt p0, v0, :cond_a

    .line 1021
    const/4 v0, 0x1

    .line 1023
    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method private static isSeenTailFamilyChar(C)I
    .registers 3
    .parameter "ch"

    .prologue
    const v1, 0xfeb1

    .line 1007
    if-lt p0, v1, :cond_11

    const v0, 0xfebf

    if-ge p0, v0, :cond_11

    .line 1008
    sget-object v0, Landroid/icu/text/ArabicShaping;->tailFamilyIsolatedFinal:[I

    sub-int v1, p0, v1

    aget v0, v0, v1

    .line 1010
    :goto_10
    return v0

    :cond_11
    const/4 v0, 0x0

    goto :goto_10
.end method

.method private static isTailChar(C)Z
    .registers 2
    .parameter "ch"

    .prologue
    .line 1034
    const/16 v0, 0x200b

    if-eq p0, v0, :cond_9

    const v0, 0xfe73

    if-ne p0, v0, :cond_b

    .line 1035
    :cond_9
    const/4 v0, 0x1

    .line 1037
    :goto_a
    return v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method private static isTashkeelChar(C)Z
    .registers 2
    .parameter "ch"

    .prologue
    .line 997
    const/16 v0, 0x64b

    if-lt p0, v0, :cond_a

    const/16 v0, 0x652

    if-gt p0, v0, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method private static isTashkeelCharFE(C)Z
    .registers 2
    .parameter "ch"

    .prologue
    .line 1069
    const v0, 0xfe75

    if-eq p0, v0, :cond_11

    const v0, 0xfe70

    if-lt p0, v0, :cond_11

    const v0, 0xfe7f

    if-gt p0, v0, :cond_11

    const/4 v0, 0x1

    :goto_10
    return v0

    :cond_11
    const/4 v0, 0x0

    goto :goto_10
.end method

.method private static isTashkeelOnTatweelChar(C)I
    .registers 4
    .parameter "ch"

    .prologue
    const v2, 0xfe7d

    const v1, 0xfe70

    .line 1080
    if-lt p0, v1, :cond_20

    const v0, 0xfe7f

    if-gt p0, v0, :cond_20

    const v0, 0xfe73

    if-eq p0, v0, :cond_20

    const v0, 0xfe75

    if-eq p0, v0, :cond_20

    if-eq p0, v2, :cond_20

    .line 1082
    sget-object v0, Landroid/icu/text/ArabicShaping;->tashkeelMedial:[I

    sub-int v1, p0, v1

    aget v0, v0, v1

    .line 1086
    :goto_1f
    return v0

    .line 1083
    :cond_20
    const v0, 0xfcf2

    if-lt p0, v0, :cond_2a

    const v0, 0xfcf4

    if-le p0, v0, :cond_2c

    :cond_2a
    if-ne p0, v2, :cond_2e

    .line 1084
    :cond_2c
    const/4 v0, 0x2

    goto :goto_1f

    .line 1086
    :cond_2e
    const/4 v0, 0x0

    goto :goto_1f
.end method

.method private static isYehHamzaChar(C)Z
    .registers 2
    .parameter "ch"

    .prologue
    .line 1056
    const v0, 0xfe89

    if-eq p0, v0, :cond_a

    const v0, 0xfe8a

    if-ne p0, v0, :cond_c

    .line 1057
    :cond_a
    const/4 v0, 0x1

    .line 1059
    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method

.method private normalize([CII)I
    .registers 11
    .parameter "dest"
    .parameter "start"
    .parameter "length"

    .prologue
    const v6, 0xfe70

    .line 1592
    const/4 v3, 0x0

    .line 1593
    .local v3, lacount:I
    move v2, p2

    .local v2, i:I
    add-int v1, v2, p3

    .local v1, e:I
    :goto_7
    if-ge v2, v1, :cond_26

    .line 1594
    aget-char v0, p1, v2

    .line 1595
    .local v0, ch:C
    if-lt v0, v6, :cond_23

    const v4, 0xfefc

    if-gt v0, v4, :cond_23

    .line 1596
    invoke-static {v0}, Landroid/icu/text/ArabicShaping;->isLamAlefChar(C)Z

    move-result v4

    if-eqz v4, :cond_1a

    .line 1597
    add-int/lit8 v3, v3, 0x1

    .line 1599
    :cond_1a
    sget-object v4, Landroid/icu/text/ArabicShaping;->convertFEto06:[I

    sub-int v5, v0, v6

    aget v4, v4, v5

    int-to-char v4, v4

    aput-char v4, p1, v2

    .line 1593
    :cond_23
    add-int/lit8 v2, v2, 0x1

    goto :goto_7

    .line 1602
    .end local v0           #ch:C
    :cond_26
    return v3
.end method

.method private shapeToArabicDigitsWithContext([CIICZ)V
    .registers 9
    .parameter "dest"
    .parameter "start"
    .parameter "length"
    .parameter "digitBase"
    .parameter "lastStrongWasAL"

    .prologue
    .line 863
    add-int/lit8 v2, p4, -0x30

    int-to-char p4, v2

    .line 865
    add-int v1, p2, p3

    .local v1, i:I
    :cond_5
    :goto_5
    add-int/lit8 v1, v1, -0x1

    if-lt v1, p2, :cond_23

    .line 866
    aget-char v0, p1, v1

    .line 867
    .local v0, ch:C
    invoke-static {v0}, Ljava/lang/Character;->getDirectionality(C)B

    move-result v2

    packed-switch v2, :pswitch_data_24

    goto :goto_5

    .line 870
    :pswitch_13
    const/4 p5, 0x0

    .line 871
    goto :goto_5

    .line 873
    :pswitch_15
    const/4 p5, 0x1

    .line 874
    goto :goto_5

    .line 876
    :pswitch_17
    if-eqz p5, :cond_5

    const/16 v2, 0x39

    if-gt v0, v2, :cond_5

    .line 877
    add-int v2, v0, p4

    int-to-char v2, v2

    aput-char v2, p1, v1

    goto :goto_5

    .line 884
    .end local v0           #ch:C
    :cond_23
    return-void

    .line 867
    :pswitch_data_24
    .packed-switch 0x0
        :pswitch_13
        :pswitch_13
        :pswitch_15
        :pswitch_17
    .end packed-switch
.end method

.method private shapeUnicode([CIIII)I
    .registers 28
    .parameter "dest"
    .parameter "start"
    .parameter "length"
    .parameter "destSize"
    .parameter "tashkeelFlag"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/icu/text/ArabicShaping$ArabicShapingException;
        }
    .end annotation

    .prologue
    .line 1654
    invoke-direct/range {p0 .. p3}, Landroid/icu/text/ArabicShaping;->normalize([CII)I

    move-result v5

    .line 1661
    .local v5, lamalef_count:I
    const/4 v10, 0x0

    .local v10, lamalef_found:Z
    const/16 v17, 0x0

    .line 1662
    .local v17, seenfam_found:Z
    const/16 v21, 0x0

    .local v21, yehhamza_found:Z
    const/16 v19, 0x0

    .line 1663
    .local v19, tashkeel_found:Z
    add-int v1, p2, p3

    add-int/lit8 v9, v1, -0x1

    .line 1664
    .local v9, i:I
    aget-char v1, p1, v9

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->getLink(C)I

    move-result v7

    .line 1665
    .local v7, currLink:I
    const/4 v13, 0x0

    .line 1666
    .local v13, nextLink:I
    const/16 v16, 0x0

    .line 1667
    .local v16, prevLink:I
    const/4 v11, 0x0

    .line 1669
    .local v11, lastLink:I
    move v12, v9

    .line 1670
    .local v12, lastPos:I
    const/4 v15, -0x2

    .line 1671
    .local v15, nx:I
    const/4 v14, 0x0

    .line 1673
    .local v14, nw:I
    :cond_1c
    :goto_1c
    if-ltz v9, :cond_128

    .line 1675
    const v1, 0xff00

    and-int/2addr v1, v7

    if-gtz v1, :cond_2c

    aget-char v1, p1, v9

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->isTashkeelChar(C)Z

    move-result v1

    if-eqz v1, :cond_a4

    .line 1676
    :cond_2c
    add-int/lit8 v14, v9, -0x1

    .line 1677
    const/4 v15, -0x2

    .line 1678
    :goto_2f
    if-gez v15, :cond_48

    .line 1679
    const/4 v1, -0x1

    if-ne v14, v1, :cond_39

    .line 1680
    const/4 v13, 0x0

    .line 1681
    const v15, 0x7fffffff

    goto :goto_2f

    .line 1683
    :cond_39
    aget-char v1, p1, v14

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->getLink(C)I

    move-result v13

    .line 1684
    and-int/lit8 v1, v13, 0x4

    if-nez v1, :cond_45

    .line 1685
    move v15, v14

    goto :goto_2f

    .line 1687
    :cond_45
    add-int/lit8 v14, v14, -0x1

    goto :goto_2f

    .line 1692
    :cond_48
    and-int/lit8 v1, v7, 0x20

    if-lez v1, :cond_67

    and-int/lit8 v1, v11, 0x10

    if-lez v1, :cond_67

    .line 1693
    const/4 v10, 0x1

    .line 1694
    aget-char v1, p1, v9

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->changeLamAlef(C)C

    move-result v20

    .line 1695
    .local v20, wLamalef:C
    if-eqz v20, :cond_61

    .line 1697
    const v1, 0xffff

    aput-char v1, p1, v9

    .line 1698
    aput-char v20, p1, v12

    .line 1699
    move v9, v12

    .line 1702
    :cond_61
    move/from16 v11, v16

    .line 1703
    invoke-static/range {v20 .. v20}, Landroid/icu/text/ArabicShaping;->getLink(C)I

    move-result v7

    .line 1705
    .end local v20           #wLamalef:C
    :cond_67
    if-lez v9, :cond_bd

    add-int/lit8 v1, v9, -0x1

    aget-char v1, p1, v1

    const/16 v2, 0x20

    if-ne v1, v2, :cond_bd

    .line 1707
    aget-char v1, p1, v9

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->isSeenFamilyChar(C)I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_b4

    .line 1708
    const/16 v17, 0x1

    .line 1726
    :cond_7c
    :goto_7c
    aget-char v1, p1, v9

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->specialChar(C)I

    move-result v8

    .line 1728
    .local v8, flag:I
    sget-object v1, Landroid/icu/text/ArabicShaping;->shapeTable:[[[I

    and-int/lit8 v2, v13, 0x3

    aget-object v1, v1, v2

    and-int/lit8 v2, v11, 0x3

    aget-object v1, v1, v2

    and-int/lit8 v2, v7, 0x3

    aget v18, v1, v2

    .line 1732
    .local v18, shape:I
    const/4 v1, 0x1

    if-ne v8, v1, :cond_d4

    .line 1733
    and-int/lit8 v18, v18, 0x1

    .line 1748
    :cond_95
    :goto_95
    const/4 v1, 0x2

    if-ne v8, v1, :cond_111

    .line 1749
    const/4 v1, 0x2

    move/from16 v0, p5

    if-ne v0, v1, :cond_ff

    .line 1750
    const v1, 0xfffe

    aput-char v1, p1, v9

    .line 1751
    const/16 v19, 0x1

    .line 1763
    .end local v8           #flag:I
    .end local v18           #shape:I
    :cond_a4
    :goto_a4
    and-int/lit8 v1, v7, 0x4

    if-nez v1, :cond_ac

    .line 1764
    move/from16 v16, v11

    .line 1765
    move v11, v7

    .line 1767
    move v12, v9

    .line 1770
    :cond_ac
    add-int/lit8 v9, v9, -0x1

    .line 1771
    if-ne v9, v15, :cond_11d

    .line 1772
    move v7, v13

    .line 1773
    const/4 v15, -0x2

    goto/16 :goto_1c

    .line 1709
    :cond_b4
    aget-char v1, p1, v9

    const/16 v2, 0x626

    if-ne v1, v2, :cond_7c

    .line 1710
    const/16 v21, 0x1

    goto :goto_7c

    .line 1713
    :cond_bd
    if-nez v9, :cond_7c

    .line 1714
    aget-char v1, p1, v9

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->isSeenFamilyChar(C)I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_cb

    .line 1715
    const/16 v17, 0x1

    goto :goto_7c

    .line 1716
    :cond_cb
    aget-char v1, p1, v9

    const/16 v2, 0x626

    if-ne v1, v2, :cond_7c

    .line 1717
    const/16 v21, 0x1

    goto :goto_7c

    .line 1734
    .restart local v8       #flag:I
    .restart local v18       #shape:I
    :cond_d4
    const/4 v1, 0x2

    if-ne v8, v1, :cond_95

    .line 1735
    if-nez p5, :cond_fc

    and-int/lit8 v1, v11, 0x2

    if-eqz v1, :cond_fc

    and-int/lit8 v1, v13, 0x1

    if-eqz v1, :cond_fc

    aget-char v1, p1, v9

    const/16 v2, 0x64c

    if-eq v1, v2, :cond_fc

    aget-char v1, p1, v9

    const/16 v2, 0x64d

    if-eq v1, v2, :cond_fc

    and-int/lit8 v1, v13, 0x20

    const/16 v2, 0x20

    if-ne v1, v2, :cond_f9

    and-int/lit8 v1, v11, 0x10

    const/16 v2, 0x10

    if-eq v1, v2, :cond_fc

    .line 1743
    :cond_f9
    const/16 v18, 0x1

    goto :goto_95

    .line 1745
    :cond_fc
    const/16 v18, 0x0

    goto :goto_95

    .line 1754
    :cond_ff
    const v1, 0xfe70

    sget-object v2, Landroid/icu/text/ArabicShaping;->irrelevantPos:[I

    aget-char v3, p1, v9

    add-int/lit16 v3, v3, -0x64b

    aget v2, v2, v3

    add-int/2addr v1, v2

    add-int v1, v1, v18

    int-to-char v1, v1

    aput-char v1, p1, v9

    goto :goto_a4

    .line 1758
    :cond_111
    const v1, 0xfe70

    shr-int/lit8 v2, v7, 0x8

    add-int/2addr v1, v2

    add-int v1, v1, v18

    int-to-char v1, v1

    aput-char v1, p1, v9

    goto :goto_a4

    .line 1774
    .end local v8           #flag:I
    .end local v18           #shape:I
    :cond_11d
    const/4 v1, -0x1

    if-eq v9, v1, :cond_1c

    .line 1775
    aget-char v1, p1, v9

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->getLink(C)I

    move-result v7

    goto/16 :goto_1c

    .line 1782
    :cond_128
    move/from16 p4, p3

    .line 1783
    if-nez v10, :cond_12e

    if-eqz v19, :cond_132

    .line 1784
    :cond_12e
    invoke-direct/range {p0 .. p3}, Landroid/icu/text/ArabicShaping;->handleGeneratedSpaces([CII)I

    move-result p4

    .line 1786
    :cond_132
    if-nez v17, :cond_136

    if-eqz v21, :cond_143

    .line 1787
    :cond_136
    const/4 v6, 0x0

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move/from16 v3, p2

    move/from16 v4, p4

    invoke-direct/range {v1 .. v6}, Landroid/icu/text/ArabicShaping;->expandCompositChar([CIIII)I

    move-result p4

    .line 1789
    :cond_143
    return p4
.end method

.method public static shiftArray([CIIC)V
    .registers 7
    .parameter "dest"
    .parameter "start"
    .parameter "e"
    .parameter "subChar"

    .prologue
    .line 1193
    move v2, p2

    .line 1194
    .local v2, w:I
    move v1, p2

    .line 1195
    .local v1, r:I
    :cond_2
    :goto_2
    add-int/lit8 v1, v1, -0x1

    if-lt v1, p1, :cond_11

    .line 1196
    aget-char v0, p0, v1

    .line 1197
    .local v0, ch:C
    if-eq v0, p3, :cond_2

    .line 1198
    add-int/lit8 v2, v2, -0x1

    .line 1199
    if-eq v2, v1, :cond_2

    .line 1200
    aput-char v0, p0, v2

    goto :goto_2

    .line 1204
    .end local v0           #ch:C
    :cond_11
    return-void
.end method

.method private static specialChar(C)I
    .registers 2
    .parameter "ch"

    .prologue
    .line 927
    const/16 v0, 0x621

    if-le p0, v0, :cond_8

    const/16 v0, 0x626

    if-lt p0, v0, :cond_20

    :cond_8
    const/16 v0, 0x627

    if-eq p0, v0, :cond_20

    const/16 v0, 0x62e

    if-le p0, v0, :cond_14

    const/16 v0, 0x633

    if-lt p0, v0, :cond_20

    :cond_14
    const/16 v0, 0x647

    if-le p0, v0, :cond_1c

    const/16 v0, 0x64a

    if-lt p0, v0, :cond_20

    :cond_1c
    const/16 v0, 0x629

    if-ne p0, v0, :cond_22

    .line 932
    :cond_20
    const/4 v0, 0x1

    .line 940
    :goto_21
    return v0

    .line 933
    :cond_22
    const/16 v0, 0x64b

    if-lt p0, v0, :cond_2c

    const/16 v0, 0x652

    if-gt p0, v0, :cond_2c

    .line 934
    const/4 v0, 0x2

    goto :goto_21

    .line 935
    :cond_2c
    const/16 v0, 0x653

    if-lt p0, v0, :cond_34

    const/16 v0, 0x655

    if-le p0, v0, :cond_42

    :cond_34
    const/16 v0, 0x670

    if-eq p0, v0, :cond_42

    const v0, 0xfe70

    if-lt p0, v0, :cond_44

    const v0, 0xfe7f

    if-gt p0, v0, :cond_44

    .line 938
    :cond_42
    const/4 v0, 0x3

    goto :goto_21

    .line 940
    :cond_44
    const/4 v0, 0x0

    goto :goto_21
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 4
    .parameter "rhs"

    .prologue
    .line 569
    if-eqz p1, :cond_14

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Landroid/icu/text/ArabicShaping;

    if-ne v0, v1, :cond_14

    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    check-cast p1, Landroid/icu/text/ArabicShaping;

    .end local p1
    iget v1, p1, Landroid/icu/text/ArabicShaping;->options:I

    if-ne v0, v1, :cond_14

    const/4 v0, 0x1

    :goto_13
    return v0

    :cond_14
    const/4 v0, 0x0

    goto :goto_13
.end method

.method public hashCode()I
    .registers 2

    .prologue
    .line 579
    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    return v0
.end method

.method public shape([CII[CII)I
    .registers 11
    .parameter "source"
    .parameter "sourceStart"
    .parameter "sourceLength"
    .parameter "dest"
    .parameter "destStart"
    .parameter "destSize"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/icu/text/ArabicShaping$ArabicShapingException;
        }
    .end annotation

    .prologue
    const/high16 v3, 0xe

    const v2, 0x10003

    .line 99
    if-nez p1, :cond_10

    .line 100
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "source can not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 102
    :cond_10
    if-ltz p2, :cond_19

    if-ltz p3, :cond_19

    add-int v0, p2, p3

    array-length v1, p1

    if-le v0, v1, :cond_47

    .line 103
    :cond_19
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "bad source start ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ") or length ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ") for buffer of length "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    array-length v2, p1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 107
    :cond_47
    if-nez p4, :cond_54

    if-eqz p6, :cond_54

    .line 108
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "null dest requires destSize == 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 110
    :cond_54
    if-eqz p6, :cond_8d

    if-ltz p5, :cond_5f

    if-ltz p6, :cond_5f

    add-int v0, p5, p6

    array-length v1, p4

    if-le v0, v1, :cond_8d

    .line 112
    :cond_5f
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "bad dest start ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ") or size ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ") for buffer of length "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    array-length v2, p4

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 117
    :cond_8d
    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/2addr v0, v3

    if-lez v0, :cond_b6

    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/2addr v0, v3

    const/high16 v1, 0x4

    if-eq v0, v1, :cond_b6

    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/2addr v0, v3

    const/high16 v1, 0x6

    if-eq v0, v1, :cond_b6

    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/2addr v0, v3

    const/high16 v1, 0x8

    if-eq v0, v1, :cond_b6

    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/2addr v0, v3

    const/high16 v1, 0xc

    if-eq v0, v1, :cond_b6

    .line 122
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Wrong Tashkeel argument"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 127
    :cond_b6
    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/2addr v0, v2

    if-lez v0, :cond_e1

    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/2addr v0, v2

    const/4 v1, 0x3

    if-eq v0, v1, :cond_e1

    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/2addr v0, v2

    const/4 v1, 0x2

    if-eq v0, v1, :cond_e1

    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/2addr v0, v2

    if-eqz v0, :cond_e1

    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/2addr v0, v2

    const/high16 v1, 0x1

    if-eq v0, v1, :cond_e1

    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/2addr v0, v2

    const/4 v1, 0x1

    if-eq v0, v1, :cond_e1

    .line 133
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Wrong Lam Alef argument"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 138
    :cond_e1
    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/2addr v0, v3

    if-lez v0, :cond_f6

    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit8 v0, v0, 0x18

    const/16 v1, 0x10

    if-ne v0, v1, :cond_f6

    .line 139
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Tashkeel replacement should not be enabled in deshaping mode "

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 141
    :cond_f6
    invoke-direct/range {p0 .. p6}, Landroid/icu/text/ArabicShaping;->internalShape([CII[CII)I

    move-result v0

    return v0
.end method

.method public shape(Ljava/lang/String;)Ljava/lang/String;
    .registers 10
    .parameter "text"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/icu/text/ArabicShaping$ArabicShapingException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 170
    invoke-virtual {p1}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    .line 171
    .local v1, src:[C
    move-object v4, v1

    .line 172
    .local v4, dest:[C
    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    const v3, 0x10003

    and-int/2addr v0, v3

    if-nez v0, :cond_1b

    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit8 v0, v0, 0x18

    const/16 v3, 0x10

    if-ne v0, v3, :cond_1b

    .line 175
    array-length v0, v1

    mul-int/lit8 v0, v0, 0x2

    new-array v4, v0, [C

    .line 177
    :cond_1b
    array-length v3, v1

    array-length v6, v4

    move-object v0, p0

    move v5, v2

    invoke-virtual/range {v0 .. v6}, Landroid/icu/text/ArabicShaping;->shape([CII[CII)I

    move-result v7

    .line 179
    .local v7, len:I
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v4, v2, v7}, Ljava/lang/String;-><init>([CII)V

    return-object v0
.end method

.method public shape([CII)V
    .registers 11
    .parameter "source"
    .parameter "start"
    .parameter "length"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/icu/text/ArabicShaping$ArabicShapingException;
        }
    .end annotation

    .prologue
    .line 155
    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    const v1, 0x10003

    and-int/2addr v0, v1

    if-nez v0, :cond_10

    .line 156
    new-instance v0, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string v1, "Cannot shape in place with length option resize."

    invoke-direct {v0, v1}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_10
    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    move-object v4, p1

    move v5, p2

    move v6, p3

    .line 158
    invoke-virtual/range {v0 .. v6}, Landroid/icu/text/ArabicShaping;->shape([CII[CII)I

    .line 159
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    .line 586
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 587
    .local v0, buf:Ljava/lang/StringBuffer;
    const/16 v1, 0x5b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 589
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const v2, 0x10003

    and-int/2addr v1, v2

    sparse-switch v1, :sswitch_data_ec

    .line 596
    :goto_17
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit8 v1, v1, 0x4

    sparse-switch v1, :sswitch_data_102

    .line 600
    :goto_1e
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit8 v1, v1, 0x18

    sparse-switch v1, :sswitch_data_10c

    .line 606
    :goto_25
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v2, 0x70

    and-int/2addr v1, v2

    packed-switch v1, :pswitch_data_11e

    .line 609
    :goto_2d
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v2, 0x380

    and-int/2addr v1, v2

    packed-switch v1, :pswitch_data_124

    .line 612
    :goto_35
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v2, 0xe

    and-int/2addr v1, v2

    sparse-switch v1, :sswitch_data_12a

    .line 619
    :goto_3d
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit16 v1, v1, 0xe0

    sparse-switch v1, :sswitch_data_13c

    .line 626
    :goto_44
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit16 v1, v1, 0x100

    sparse-switch v1, :sswitch_data_152

    .line 630
    :goto_4b
    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 632
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 590
    :sswitch_55
    const-string v1, "LamAlef resize"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_17

    .line 591
    :sswitch_5b
    const-string v1, "LamAlef spaces at near"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_17

    .line 592
    :sswitch_61
    const-string v1, "LamAlef spaces at begin"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_17

    .line 593
    :sswitch_67
    const-string v1, "LamAlef spaces at end"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_17

    .line 594
    :sswitch_6d
    const-string v1, "lamAlef auto"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_17

    .line 597
    :sswitch_73
    const-string v1, ", logical"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1e

    .line 598
    :sswitch_79
    const-string v1, ", visual"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1e

    .line 601
    :sswitch_7f
    const-string v1, ", no letter shaping"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_25

    .line 602
    :sswitch_85
    const-string v1, ", shape letters"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_25

    .line 603
    :sswitch_8b
    const-string v1, ", shape letters tashkeel isolated"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_25

    .line 604
    :sswitch_91
    const-string v1, ", unshape letters"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_25

    .line 607
    :pswitch_97
    const-string v1, ", Seen at near"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2d

    .line 610
    :pswitch_9d
    const-string v1, ", Yeh Hamza at near"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_35

    .line 613
    :sswitch_a3
    const-string v1, ", Tashkeel at begin"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_3d

    .line 614
    :sswitch_a9
    const-string v1, ", Tashkeel at end"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_3d

    .line 615
    :sswitch_af
    const-string v1, ", Tashkeel replace with tatweel"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_3d

    .line 616
    :sswitch_b5
    const-string v1, ", Tashkeel resize"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_3d

    .line 620
    :sswitch_bb
    const-string v1, ", no digit shaping"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_44

    .line 621
    :sswitch_c1
    const-string v1, ", shape digits to AN"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_44

    .line 622
    :sswitch_c8
    const-string v1, ", shape digits to EN"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_44

    .line 623
    :sswitch_cf
    const-string v1, ", shape digits to AN contextually: default EN"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_44

    .line 624
    :sswitch_d6
    const-string v1, ", shape digits to AN contextually: default AL"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_44

    .line 627
    :sswitch_dd
    const-string v1, ", standard Arabic-Indic digits"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_4b

    .line 628
    :sswitch_e4
    const-string v1, ", extended Arabic-Indic digits"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_4b

    .line 589
    nop

    :sswitch_data_ec
    .sparse-switch
        0x0 -> :sswitch_55
        0x1 -> :sswitch_5b
        0x2 -> :sswitch_67
        0x3 -> :sswitch_61
        0x10000 -> :sswitch_6d
    .end sparse-switch

    .line 596
    :sswitch_data_102
    .sparse-switch
        0x0 -> :sswitch_73
        0x4 -> :sswitch_79
    .end sparse-switch

    .line 600
    :sswitch_data_10c
    .sparse-switch
        0x0 -> :sswitch_7f
        0x8 -> :sswitch_85
        0x10 -> :sswitch_91
        0x18 -> :sswitch_8b
    .end sparse-switch

    .line 606
    :pswitch_data_11e
    .packed-switch 0x200000
        :pswitch_97
    .end packed-switch

    .line 609
    :pswitch_data_124
    .packed-switch 0x1000000
        :pswitch_9d
    .end packed-switch

    .line 612
    :sswitch_data_12a
    .sparse-switch
        0x40000 -> :sswitch_a3
        0x60000 -> :sswitch_a9
        0x80000 -> :sswitch_b5
        0xc0000 -> :sswitch_af
    .end sparse-switch

    .line 619
    :sswitch_data_13c
    .sparse-switch
        0x0 -> :sswitch_bb
        0x20 -> :sswitch_c1
        0x40 -> :sswitch_c8
        0x60 -> :sswitch_cf
        0x80 -> :sswitch_d6
    .end sparse-switch

    .line 626
    :sswitch_data_152
    .sparse-switch
        0x0 -> :sswitch_dd
        0x100 -> :sswitch_e4
    .end sparse-switch
.end method
