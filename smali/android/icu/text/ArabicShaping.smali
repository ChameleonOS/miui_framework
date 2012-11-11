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

    new-instance v0, Landroid/icu/text/ArabicShaping;

    const/16 v1, 0x9

    invoke-direct {v0, v1}, Landroid/icu/text/ArabicShaping;-><init>(I)V

    sput-object v0, Landroid/icu/text/ArabicShaping;->SHAPER:Landroid/icu/text/ArabicShaping;

    const/16 v0, 0x8

    new-array v0, v0, [I

    fill-array-data v0, :array_d8

    sput-object v0, Landroid/icu/text/ArabicShaping;->irrelevantPos:[I

    const/16 v0, 0xe

    new-array v0, v0, [I

    fill-array-data v0, :array_ec

    sput-object v0, Landroid/icu/text/ArabicShaping;->tailFamilyIsolatedFinal:[I

    const/16 v0, 0x10

    new-array v0, v0, [I

    fill-array-data v0, :array_10c

    sput-object v0, Landroid/icu/text/ArabicShaping;->tashkeelMedial:[I

    new-array v0, v4, [C

    fill-array-data v0, :array_130

    sput-object v0, Landroid/icu/text/ArabicShaping;->yehHamzaToYeh:[C

    new-array v0, v3, [C

    fill-array-data v0, :array_136

    sput-object v0, Landroid/icu/text/ArabicShaping;->convertNormalizedLamAlef:[C

    const/16 v0, 0xb2

    new-array v0, v0, [I

    fill-array-data v0, :array_13e

    sput-object v0, Landroid/icu/text/ArabicShaping;->araLink:[I

    const/16 v0, 0x8d

    new-array v0, v0, [I

    fill-array-data v0, :array_2a6

    sput-object v0, Landroid/icu/text/ArabicShaping;->presLink:[I

    const/16 v0, 0x8d

    new-array v0, v0, [I

    fill-array-data v0, :array_3c4

    sput-object v0, Landroid/icu/text/ArabicShaping;->convertFEto06:[I

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

    :array_130
    .array-data 0x2
        0xeft 0xfet
        0xf0t 0xfet
    .end array-data

    :array_136
    .array-data 0x2
        0x22t 0x6t
        0x23t 0x6t
        0x25t 0x6t
        0x27t 0x6t
    .end array-data

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

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit16 v0, p1, 0xe0

    const/16 v3, 0x80

    if-le v0, v3, :cond_19

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "bad DIGITS options"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_19
    and-int/lit8 v0, p1, 0x4

    if-nez v0, :cond_30

    move v0, v1

    :goto_1e
    iput-boolean v0, p0, Landroid/icu/text/ArabicShaping;->isLogical:Z

    and-int v0, p1, v4

    if-ne v0, v4, :cond_32

    :goto_24
    iput-boolean v1, p0, Landroid/icu/text/ArabicShaping;->spacesRelativeToTextBeginEnd:Z

    and-int v0, p1, v5

    if-ne v0, v5, :cond_34

    const v0, 0xfe73

    iput-char v0, p0, Landroid/icu/text/ArabicShaping;->tailChar:C

    :goto_2f
    return-void

    :cond_30
    move v0, v2

    goto :goto_1e

    :cond_32
    move v1, v2

    goto :goto_24

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

    move v0, p3

    .local v0, destSize:I
    iget v3, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit8 v3, v3, 0x18

    sparse-switch v3, :sswitch_data_64

    :cond_a
    return v0

    :sswitch_b
    iget-boolean v3, p0, Landroid/icu/text/ArabicShaping;->isLogical:Z

    if-eqz v3, :cond_31

    move v2, p2

    .local v2, i:I
    add-int v3, p2, p3

    add-int/lit8 v1, v3, -0x1

    .local v1, e:I
    :goto_14
    if-ge v2, v1, :cond_a

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

    :cond_2c
    add-int/lit8 v0, v0, -0x1

    :cond_2e
    add-int/lit8 v2, v2, 0x1

    goto :goto_14

    .end local v1           #e:I
    .end local v2           #i:I
    :cond_31
    add-int/lit8 v2, p2, 0x1

    .restart local v2       #i:I
    add-int v1, p2, p3

    .restart local v1       #e:I
    :goto_35
    if-ge v2, v1, :cond_a

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

    :cond_4d
    add-int/lit8 v0, v0, -0x1

    :cond_4f
    add-int/lit8 v2, v2, 0x1

    goto :goto_35

    .end local v1           #e:I
    .end local v2           #i:I
    :sswitch_52
    move v2, p2

    .restart local v2       #i:I
    add-int v1, p2, p3

    .restart local v1       #e:I
    :goto_55
    if-ge v2, v1, :cond_a

    aget-char v3, p1, v2

    invoke-static {v3}, Landroid/icu/text/ArabicShaping;->isLamAlefChar(C)Z

    move-result v3

    if-eqz v3, :cond_61

    add-int/lit8 v0, v0, 0x1

    :cond_61
    add-int/lit8 v2, v2, 0x1

    goto :goto_55

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
    packed-switch p0, :pswitch_data_12

    :pswitch_3
    const/4 v0, 0x0

    :goto_4
    return v0

    :pswitch_5
    const/16 v0, 0x65c

    goto :goto_4

    :pswitch_8
    const/16 v0, 0x65d

    goto :goto_4

    :pswitch_b
    const/16 v0, 0x65e

    goto :goto_4

    :pswitch_e
    const/16 v0, 0x65f

    goto :goto_4

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
    const/4 v1, 0x0

    .local v1, i:I
    const/4 v0, 0x0

    .local v0, count:I
    :goto_2
    if-ge v1, p1, :cond_d

    aget-char v2, p0, v1

    if-ne v2, p2, :cond_a

    add-int/lit8 v0, v0, 0x1

    :cond_a
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_d
    return v0
.end method

.method private static countSpacesLeft([CII)I
    .registers 7
    .parameter "dest"
    .parameter "start"
    .parameter "count"

    .prologue
    move v1, p1

    .local v1, i:I
    add-int v0, p1, p2

    .local v0, e:I
    :goto_3
    if-ge v1, v0, :cond_d

    aget-char v2, p0, v1

    const/16 v3, 0x20

    if-eq v2, v3, :cond_e

    sub-int p2, v1, p1

    .end local p2
    :cond_d
    return p2

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
    add-int v0, p1, p2

    .local v0, i:I
    :cond_2
    add-int/lit8 v0, v0, -0x1

    if-lt v0, p1, :cond_12

    aget-char v1, p0, v0

    const/16 v2, 0x20

    if-eq v1, v2, :cond_2

    add-int v1, p1, p2

    add-int/lit8 v1, v1, -0x1

    sub-int p2, v1, v0

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
    invoke-direct {p0, p1, p2, p3}, Landroid/icu/text/ArabicShaping;->deshapeNormalize([CII)I

    move-result v4

    .local v4, lamalef_count:I
    if-eqz v4, :cond_10

    const/4 v5, 0x1

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    invoke-direct/range {v0 .. v5}, Landroid/icu/text/ArabicShaping;->expandCompositChar([CIIII)I

    move-result p4

    :goto_f
    return p4

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

    const/4 v3, 0x0

    .local v3, lacount:I
    const/4 v5, 0x0

    .local v5, yehHamzaComposeEnabled:I
    const/4 v4, 0x0

    .local v4, seenComposeEnabled:I
    iget v8, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v9, 0x380

    and-int/2addr v8, v9

    const/high16 v9, 0x100

    if-ne v8, v9, :cond_49

    move v5, v6

    :goto_14
    iget v8, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v9, 0x70

    and-int/2addr v8, v9

    const/high16 v9, 0x20

    if-ne v8, v9, :cond_4b

    move v4, v6

    :goto_1e
    move v2, p2

    .local v2, i:I
    add-int v1, v2, p3

    .local v1, e:I
    :goto_21
    if-ge v2, v1, :cond_7f

    aget-char v0, p1, v2

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

    aput-char v10, p1, v2

    add-int/lit8 v7, v2, 0x1

    const/16 v8, 0x626

    aput-char v8, p1, v7

    :cond_46
    :goto_46
    add-int/lit8 v2, v2, 0x1

    goto :goto_21

    .end local v0           #ch:C
    .end local v1           #e:I
    .end local v2           #i:I
    :cond_49
    move v5, v7

    goto :goto_14

    :cond_4b
    move v4, v7

    goto :goto_1e

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

    aput-char v10, p1, v2

    goto :goto_46

    :cond_66
    if-lt v0, v11, :cond_46

    const v7, 0xfefc

    if-gt v0, v7, :cond_46

    invoke-static {v0}, Landroid/icu/text/ArabicShaping;->isLamAlefChar(C)Z

    move-result v7

    if-eqz v7, :cond_75

    add-int/lit8 v3, v3, 0x1

    :cond_75
    sget-object v7, Landroid/icu/text/ArabicShaping;->convertFEto06:[I

    sub-int v8, v0, v11

    aget v7, v7, v8

    int-to-char v7, v7

    aput-char v7, p1, v2

    goto :goto_46

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
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const v2, 0x10003

    and-int v9, v1, v2

    .local v9, lenOptionsLamAlef:I
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v2, 0x70

    and-int v10, v1, v2

    .local v10, lenOptionsSeen:I
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v2, 0x380

    and-int v11, v1, v2

    .local v11, lenOptionsYehHamza:I
    const/4 v13, 0x0

    .local v13, spaceNotFound:Z
    iget-boolean v1, p0, Landroid/icu/text/ArabicShaping;->isLogical:Z

    if-nez v1, :cond_1f

    iget-boolean v1, p0, Landroid/icu/text/ArabicShaping;->spacesRelativeToTextBeginEnd:Z

    if-nez v1, :cond_1f

    packed-switch v9, :pswitch_data_11a

    :cond_1f
    :goto_1f
    const/4 v1, 0x1

    move/from16 v0, p5

    if-ne v0, v1, :cond_e2

    const/high16 v1, 0x1

    if-ne v9, v1, :cond_78

    iget-boolean v1, p0, Landroid/icu/text/ArabicShaping;->isLogical:Z

    if-eqz v1, :cond_54

    invoke-direct/range {p0 .. p4}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtEnd([CIII)Z

    move-result v13

    if-eqz v13, :cond_36

    invoke-direct/range {p0 .. p4}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtBegin([CIII)Z

    move-result v13

    :cond_36
    if-eqz v13, :cond_46

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x1

    move-object v1, p0

    move-object/from16 v2, p1

    move/from16 v3, p2

    move/from16 v4, p3

    invoke-direct/range {v1 .. v7}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtNear([CIIIII)Z

    move-result v13

    :cond_46
    if-eqz v13, :cond_e1

    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string v2, "No spacefor lamalef"

    invoke-direct {v1, v2}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

    :pswitch_50
    const/4 v9, 0x2

    goto :goto_1f

    :pswitch_52
    const/4 v9, 0x3

    goto :goto_1f

    :cond_54
    invoke-direct/range {p0 .. p4}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtBegin([CIII)Z

    move-result v13

    if-eqz v13, :cond_5e

    invoke-direct/range {p0 .. p4}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtEnd([CIII)Z

    move-result v13

    :cond_5e
    if-eqz v13, :cond_6e

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x1

    move-object v1, p0

    move-object/from16 v2, p1

    move/from16 v3, p2

    move/from16 v4, p3

    invoke-direct/range {v1 .. v7}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtNear([CIIIII)Z

    move-result v13

    :cond_6e
    if-eqz v13, :cond_e1

    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string v2, "No spacefor lamalef"

    invoke-direct {v1, v2}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_78
    const/4 v1, 0x2

    if-ne v9, v1, :cond_89

    invoke-direct/range {p0 .. p4}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtEnd([CIII)Z

    move-result v13

    if-eqz v13, :cond_e1

    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string v2, "No spacefor lamalef"

    invoke-direct {v1, v2}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_89
    const/4 v1, 0x3

    if-ne v9, v1, :cond_9a

    invoke-direct/range {p0 .. p4}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtBegin([CIII)Z

    move-result v13

    if-eqz v13, :cond_e1

    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string v2, "No spacefor lamalef"

    invoke-direct {v1, v2}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_9a
    const/4 v1, 0x1

    if-ne v9, v1, :cond_b5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x1

    move-object v1, p0

    move-object/from16 v2, p1

    move/from16 v3, p2

    move/from16 v4, p3

    invoke-direct/range {v1 .. v7}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtNear([CIIIII)Z

    move-result v13

    if-eqz v13, :cond_e1

    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string v2, "No spacefor lamalef"

    invoke-direct {v1, v2}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_b5
    if-nez v9, :cond_e1

    add-int v12, p2, p3

    .local v12, r:I
    add-int v14, v12, p4

    .local v14, w:I
    :goto_bb
    add-int/lit8 v12, v12, -0x1

    move/from16 v0, p2

    if-lt v12, v0, :cond_df

    aget-char v8, p1, v12

    .local v8, ch:C
    invoke-static {v8}, Landroid/icu/text/ArabicShaping;->isNormalizedLamAlefChar(C)Z

    move-result v1

    if-eqz v1, :cond_da

    add-int/lit8 v14, v14, -0x1

    const/16 v1, 0x644

    aput-char v1, p1, v14

    add-int/lit8 v14, v14, -0x1

    sget-object v1, Landroid/icu/text/ArabicShaping;->convertNormalizedLamAlef:[C

    add-int/lit16 v2, v8, -0x65c

    aget-char v1, v1, v2

    aput-char v1, p1, v14

    goto :goto_bb

    :cond_da
    add-int/lit8 v14, v14, -0x1

    aput-char v8, p1, v14

    goto :goto_bb

    .end local v8           #ch:C
    :cond_df
    add-int p3, p3, p4

    .end local v12           #r:I
    .end local v14           #w:I
    :cond_e1
    return p3

    :cond_e2
    const/high16 v1, 0x20

    if-ne v10, v1, :cond_fe

    const/4 v5, 0x0

    const/4 v6, 0x1

    const/4 v7, 0x0

    move-object v1, p0

    move-object/from16 v2, p1

    move/from16 v3, p2

    move/from16 v4, p3

    invoke-direct/range {v1 .. v7}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtNear([CIIIII)Z

    move-result v13

    if-eqz v13, :cond_fe

    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string v2, "No space for Seen tail expansion"

    invoke-direct {v1, v2}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_fe
    const/high16 v1, 0x100

    if-ne v11, v1, :cond_e1

    const/4 v5, 0x1

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v1, p0

    move-object/from16 v2, p1

    move/from16 v3, p2

    move/from16 v4, p3

    invoke-direct/range {v1 .. v7}, Landroid/icu/text/ArabicShaping;->expandCompositCharAtNear([CIIIII)Z

    move-result v13

    if-eqz v13, :cond_e1

    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string v2, "No space for YehHamza expansion"

    invoke-direct {v1, v2}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

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
    const/4 v2, 0x0

    .local v2, spaceNotFound:Z
    invoke-static {p1, p2, p3}, Landroid/icu/text/ArabicShaping;->countSpacesRight([CII)I

    move-result v5

    if-le p4, v5, :cond_a

    const/4 v2, 0x1

    move v3, v2

    .end local v2           #spaceNotFound:Z
    .local v3, spaceNotFound:I
    :goto_9
    return v3

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

    aget-char v0, p1, v1

    .local v0, ch:C
    invoke-static {v0}, Landroid/icu/text/ArabicShaping;->isNormalizedLamAlefChar(C)Z

    move-result v5

    if-eqz v5, :cond_2d

    add-int/lit8 v4, v4, -0x1

    const/16 v5, 0x644

    aput-char v5, p1, v4

    add-int/lit8 v4, v4, -0x1

    sget-object v5, Landroid/icu/text/ArabicShaping;->convertNormalizedLamAlef:[C

    add-int/lit16 v6, v0, -0x65c

    aget-char v5, v5, v6

    aput-char v5, p1, v4

    goto :goto_10

    :cond_2d
    add-int/lit8 v4, v4, -0x1

    aput-char v0, p1, v4

    goto :goto_10

    .end local v0           #ch:C
    :cond_32
    move v3, v2

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
    const/4 v3, 0x0

    .local v3, spaceNotFound:Z
    invoke-static {p1, p2, p3}, Landroid/icu/text/ArabicShaping;->countSpacesLeft([CII)I

    move-result v7

    if-le p4, v7, :cond_a

    const/4 v3, 0x1

    move v4, v3

    .end local v3           #spaceNotFound:Z
    .local v4, spaceNotFound:I
    :goto_9
    return v4

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

    aget-char v0, p1, v2

    .local v0, ch:C
    invoke-static {v0}, Landroid/icu/text/ArabicShaping;->isNormalizedLamAlefChar(C)Z

    move-result v7

    if-eqz v7, :cond_2f

    add-int/lit8 v5, v6, 0x1

    .end local v6           #w:I
    .restart local v5       #w:I
    sget-object v7, Landroid/icu/text/ArabicShaping;->convertNormalizedLamAlef:[C

    add-int/lit16 v8, v0, -0x65c

    aget-char v7, v7, v8

    aput-char v7, p1, v6

    add-int/lit8 v6, v5, 0x1

    .end local v5           #w:I
    .restart local v6       #w:I
    const/16 v7, 0x644

    aput-char v7, p1, v5

    move v5, v6

    .end local v6           #w:I
    .restart local v5       #w:I
    :goto_2b
    add-int/lit8 v2, v2, 0x1

    move v6, v5

    .end local v5           #w:I
    .restart local v6       #w:I
    goto :goto_10

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

    const/4 v2, 0x0

    .local v2, spaceNotFound:Z
    aget-char v3, p1, p2

    invoke-static {v3}, Landroid/icu/text/ArabicShaping;->isNormalizedLamAlefChar(C)Z

    move-result v3

    if-eqz v3, :cond_f

    const/4 v2, 0x1

    move v3, v2

    :goto_e
    return v3

    :cond_f
    add-int v1, p2, p3

    .local v1, i:I
    :cond_11
    :goto_11
    add-int/lit8 v1, v1, -0x1

    if-lt v1, p2, :cond_79

    aget-char v0, p1, v1

    .local v0, ch:C
    if-ne p6, v5, :cond_39

    invoke-static {v0}, Landroid/icu/text/ArabicShaping;->isNormalizedLamAlefChar(C)Z

    move-result v3

    if-eqz v3, :cond_39

    if-le v1, p2, :cond_36

    add-int/lit8 v3, v1, -0x1

    aget-char v3, p1, v3

    if-ne v3, v6, :cond_36

    const/16 v3, 0x644

    aput-char v3, p1, v1

    add-int/lit8 v1, v1, -0x1

    sget-object v3, Landroid/icu/text/ArabicShaping;->convertNormalizedLamAlef:[C

    add-int/lit16 v4, v0, -0x65c

    aget-char v3, v3, v4

    aput-char v3, p1, v1

    goto :goto_11

    :cond_36
    const/4 v2, 0x1

    move v3, v2

    goto :goto_e

    :cond_39
    if-ne p5, v5, :cond_53

    invoke-static {v0}, Landroid/icu/text/ArabicShaping;->isSeenTailFamilyChar(C)I

    move-result v3

    if-ne v3, v5, :cond_53

    if-le v1, p2, :cond_50

    add-int/lit8 v3, v1, -0x1

    aget-char v3, p1, v3

    if-ne v3, v6, :cond_50

    add-int/lit8 v3, v1, -0x1

    iget-char v4, p0, Landroid/icu/text/ArabicShaping;->tailChar:C

    aput-char v4, p1, v3

    goto :goto_11

    :cond_50
    const/4 v2, 0x1

    move v3, v2

    goto :goto_e

    :cond_53
    if-ne p4, v5, :cond_11

    invoke-static {v0}, Landroid/icu/text/ArabicShaping;->isYehHamzaChar(C)Z

    move-result v3

    if-eqz v3, :cond_11

    if-le v1, p2, :cond_76

    add-int/lit8 v3, v1, -0x1

    aget-char v3, p1, v3

    if-ne v3, v6, :cond_76

    sget-object v3, Landroid/icu/text/ArabicShaping;->yehHamzaToYeh:[C

    const v4, 0xfe89

    sub-int v4, v0, v4

    aget-char v3, v3, v4

    aput-char v3, p1, v1

    add-int/lit8 v3, v1, -0x1

    const v4, 0xfe80

    aput-char v4, p1, v3

    goto :goto_11

    :cond_76
    const/4 v2, 0x1

    move v3, v2

    goto :goto_e

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
    if-le p3, p1, :cond_13

    move v0, p3

    .local v0, r:I
    move p3, p1

    move v1, v0

    .end local v0           #r:I
    .local v1, r:I
    move v2, p3

    .end local p3
    .local v2, w:I
    :goto_6
    if-ge v1, p2, :cond_15

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

    .end local v1           #r:I
    .end local v2           #w:I
    .restart local p3
    :cond_13
    move p3, p2

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

    const/16 v0, 0x622

    if-lt p0, v0, :cond_12

    const/16 v0, 0x6d3

    if-gt p0, v0, :cond_12

    sget-object v0, Landroid/icu/text/ArabicShaping;->araLink:[I

    add-int/lit16 v1, p0, -0x622

    aget v0, v0, v1

    :goto_11
    return v0

    :cond_12
    const/16 v0, 0x200d

    if-ne p0, v0, :cond_18

    const/4 v0, 0x3

    goto :goto_11

    :cond_18
    const/16 v0, 0x206d

    if-lt p0, v0, :cond_22

    const/16 v0, 0x206f

    if-gt p0, v0, :cond_22

    const/4 v0, 0x4

    goto :goto_11

    :cond_22
    if-lt p0, v1, :cond_30

    const v0, 0xfefc

    if-gt p0, v0, :cond_30

    sget-object v0, Landroid/icu/text/ArabicShaping;->presLink:[I

    sub-int v1, p0, v1

    aget v0, v0, v1

    goto :goto_11

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
    iget v10, p0, Landroid/icu/text/ArabicShaping;->options:I

    const v11, 0x10003

    and-int v3, v10, v11

    .local v3, lenOptionsLamAlef:I
    iget v10, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v11, 0xe

    and-int v4, v10, v11

    .local v4, lenOptionsTashkeel:I
    const/4 v2, 0x0

    .local v2, lamAlefOn:Z
    const/4 v5, 0x0

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

    packed-switch v3, :pswitch_data_100

    :goto_1f
    sparse-switch v4, :sswitch_data_108

    :cond_22
    :goto_22
    const/4 v10, 0x1

    if-ne v3, v10, :cond_47

    move v1, p2

    .local v1, i:I
    add-int v0, v1, p3

    .local v0, e:I
    :goto_28
    if-ge v1, v0, :cond_fe

    aget-char v10, p1, v1

    const v11, 0xffff

    if-ne v10, v11, :cond_36

    const v10, 0xfeff

    aput-char v10, p1, v1

    :cond_36
    add-int/lit8 v1, v1, 0x1

    goto :goto_28

    .end local v0           #e:I
    .end local v1           #i:I
    :cond_39
    const/4 v10, 0x0

    goto :goto_14

    :cond_3b
    const/4 v11, 0x0

    goto :goto_19

    :pswitch_3d
    const/4 v3, 0x2

    goto :goto_1f

    :pswitch_3f
    const/4 v3, 0x3

    goto :goto_1f

    :sswitch_41
    const/high16 v4, 0x6

    goto :goto_22

    :sswitch_44
    const/high16 v4, 0x4

    goto :goto_22

    :cond_47
    add-int v0, p2, p3

    .restart local v0       #e:I
    const v10, 0xffff

    invoke-static {p1, p3, v10}, Landroid/icu/text/ArabicShaping;->countSpaceSub([CIC)I

    move-result v6

    .local v6, wL:I
    const v10, 0xfffe

    invoke-static {p1, p3, v10}, Landroid/icu/text/ArabicShaping;->countSpaceSub([CIC)I

    move-result v8

    .local v8, wT:I
    const/4 v10, 0x2

    if-ne v3, v10, :cond_5b

    const/4 v2, 0x1

    :cond_5b
    const/high16 v10, 0x6

    if-ne v4, v10, :cond_60

    const/4 v5, 0x1

    :cond_60
    if-eqz v2, :cond_74

    const/4 v10, 0x2

    if-ne v3, v10, :cond_74

    const v10, 0xffff

    invoke-static {p1, p2, v0, v10}, Landroid/icu/text/ArabicShaping;->shiftArray([CIIC)V

    :goto_6b
    if-le v6, p2, :cond_74

    add-int/lit8 v6, v6, -0x1

    const/16 v10, 0x20

    aput-char v10, p1, v6

    goto :goto_6b

    :cond_74
    if-eqz v5, :cond_89

    const/high16 v10, 0x6

    if-ne v4, v10, :cond_89

    const v10, 0xfffe

    invoke-static {p1, p2, v0, v10}, Landroid/icu/text/ArabicShaping;->shiftArray([CIIC)V

    :goto_80
    if-le v8, p2, :cond_89

    add-int/lit8 v8, v8, -0x1

    const/16 v10, 0x20

    aput-char v10, p1, v8

    goto :goto_80

    :cond_89
    const/4 v2, 0x0

    const/4 v5, 0x0

    if-nez v3, :cond_8e

    const/4 v2, 0x1

    :cond_8e
    const/high16 v10, 0x8

    if-ne v4, v10, :cond_93

    const/4 v5, 0x1

    :cond_93
    if-eqz v2, :cond_a3

    if-nez v3, :cond_a3

    const v10, 0xffff

    invoke-static {p1, p2, v0, v10}, Landroid/icu/text/ArabicShaping;->shiftArray([CIIC)V

    invoke-static {p1, p2, v0, v6}, Landroid/icu/text/ArabicShaping;->flipArray([CIII)I

    move-result v6

    sub-int p3, v6, p2

    :cond_a3
    if-eqz v5, :cond_b5

    const/high16 v10, 0x8

    if-ne v4, v10, :cond_b5

    const v10, 0xfffe

    invoke-static {p1, p2, v0, v10}, Landroid/icu/text/ArabicShaping;->shiftArray([CIIC)V

    invoke-static {p1, p2, v0, v8}, Landroid/icu/text/ArabicShaping;->flipArray([CIII)I

    move-result v8

    sub-int p3, v8, p2

    :cond_b5
    const/4 v2, 0x0

    const/4 v5, 0x0

    const/4 v10, 0x3

    if-eq v3, v10, :cond_be

    const/high16 v10, 0x1

    if-ne v3, v10, :cond_bf

    :cond_be
    const/4 v2, 0x1

    :cond_bf
    const/high16 v10, 0x4

    if-ne v4, v10, :cond_c4

    const/4 v5, 0x1

    :cond_c4
    if-eqz v2, :cond_e3

    const/4 v10, 0x3

    if-eq v3, v10, :cond_cd

    const/high16 v10, 0x1

    if-ne v3, v10, :cond_e3

    :cond_cd
    const v10, 0xffff

    invoke-static {p1, p2, v0, v10}, Landroid/icu/text/ArabicShaping;->shiftArray([CIIC)V

    invoke-static {p1, p2, v0, v6}, Landroid/icu/text/ArabicShaping;->flipArray([CIII)I

    move-result v6

    move v7, v6

    .end local v6           #wL:I
    .local v7, wL:I
    :goto_d8
    if-ge v7, v0, :cond_e2

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

    .end local v7           #wL:I
    .restart local v6       #wL:I
    :cond_e3
    if-eqz v5, :cond_fe

    const/high16 v10, 0x4

    if-ne v4, v10, :cond_fe

    const v10, 0xfffe

    invoke-static {p1, p2, v0, v10}, Landroid/icu/text/ArabicShaping;->shiftArray([CIIC)V

    invoke-static {p1, p2, v0, v8}, Landroid/icu/text/ArabicShaping;->flipArray([CIII)I

    move-result v8

    move v9, v8

    .end local v8           #wT:I
    .local v9, wT:I
    :goto_f4
    if-ge v9, v0, :cond_fe

    add-int/lit8 v8, v9, 0x1

    .end local v9           #wT:I
    .restart local v8       #wT:I
    const/16 v10, 0x20

    aput-char v10, p1, v9

    move v9, v8

    .end local v8           #wT:I
    .restart local v9       #wT:I
    goto :goto_f4

    .end local v6           #wL:I
    .end local v9           #wT:I
    :cond_fe
    return p3

    nop

    :pswitch_data_100
    .packed-switch 0x2
        :pswitch_3f
        :pswitch_3d
    .end packed-switch

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

    const/4 v0, 0x0

    .local v0, i:I
    :goto_2
    if-ge v0, p1, :cond_36

    aget-char v1, p0, v0

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->isTashkeelOnTatweelChar(C)I

    move-result v1

    if-ne v1, v3, :cond_13

    const/16 v1, 0x640

    aput-char v1, p0, v0

    :cond_10
    :goto_10
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_13
    aget-char v1, p0, v0

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->isTashkeelOnTatweelChar(C)I

    move-result v1

    const/4 v2, 0x2

    if-ne v1, v2, :cond_22

    const v1, 0xfe7d

    aput-char v1, p0, v0

    goto :goto_10

    :cond_22
    aget-char v1, p0, v0

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->isIsolatedTashkeelChar(C)I

    move-result v1

    if-ne v1, v3, :cond_10

    aget-char v1, p0, v0

    const v2, 0xfe7c

    if-eq v1, v2, :cond_10

    const/16 v1, 0x20

    aput-char v1, p0, v0

    goto :goto_10

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
    if-nez p3, :cond_4

    const/4 p3, 0x0

    .end local p3
    :cond_3
    :goto_3
    return p3

    .restart local p3
    :cond_4
    if-nez p6, :cond_19

    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit8 v1, v1, 0x18

    if-eqz v1, :cond_3

    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const v3, 0x10003

    and-int/2addr v1, v3

    if-nez v1, :cond_3

    invoke-direct {p0, p1, p2, p3}, Landroid/icu/text/ArabicShaping;->calculateSize([CII)I

    move-result p3

    goto :goto_3

    :cond_19
    mul-int/lit8 v1, p3, 0x2

    new-array v2, v1, [C

    .local v2, temp:[C
    const/4 v1, 0x0

    invoke-static {p1, p2, v2, v1, p3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget-boolean v1, p0, Landroid/icu/text/ArabicShaping;->isLogical:Z

    if-eqz v1, :cond_29

    const/4 v1, 0x0

    invoke-static {v2, v1, p3}, Landroid/icu/text/ArabicShaping;->invertBuffer([CII)V

    :cond_29
    move v4, p3

    .local v4, outputSize:I
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit8 v1, v1, 0x18

    sparse-switch v1, :sswitch_data_ee

    :cond_31
    :goto_31
    move/from16 v0, p6

    if-le v4, v0, :cond_84

    new-instance v1, Landroid/icu/text/ArabicShaping$ArabicShapingException;

    const-string/jumbo v3, "not enough room for result data"

    invoke-direct {v1, v3}, Landroid/icu/text/ArabicShaping$ArabicShapingException;-><init>(Ljava/lang/String;)V

    throw v1

    :sswitch_3e
    const/4 v3, 0x0

    const/4 v6, 0x1

    move-object v1, p0

    move v4, p3

    move/from16 v5, p6

    invoke-direct/range {v1 .. v6}, Landroid/icu/text/ArabicShaping;->shapeUnicode([CIIII)I

    .end local v4           #outputSize:I
    move-result v4

    .restart local v4       #outputSize:I
    goto :goto_31

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

    :cond_64
    const/4 v3, 0x0

    const/4 v6, 0x0

    move-object v1, p0

    move v4, p3

    move/from16 v5, p6

    invoke-direct/range {v1 .. v6}, Landroid/icu/text/ArabicShaping;->shapeUnicode([CIIII)I

    .end local v4           #outputSize:I
    move-result v4

    .restart local v4       #outputSize:I
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v3, 0xe

    and-int/2addr v1, v3

    const/high16 v3, 0xc

    if-ne v1, v3, :cond_31

    invoke-static {v2, p3}, Landroid/icu/text/ArabicShaping;->handleTashkeelWithTatweel([CI)I

    move-result v4

    goto :goto_31

    :sswitch_7c
    const/4 v1, 0x0

    move/from16 v0, p6

    invoke-direct {p0, v2, v1, p3, v0}, Landroid/icu/text/ArabicShaping;->deShapeUnicode([CIII)I

    move-result v4

    goto :goto_31

    :cond_84
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit16 v1, v1, 0xe0

    if-eqz v1, :cond_9a

    const/16 v5, 0x30

    .local v5, digitBase:C
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit16 v1, v1, 0x100

    sparse-switch v1, :sswitch_data_fc

    :goto_93
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit16 v1, v1, 0xe0

    sparse-switch v1, :sswitch_data_106

    .end local v5           #digitBase:C
    :cond_9a
    :goto_9a
    iget-boolean v1, p0, Landroid/icu/text/ArabicShaping;->isLogical:Z

    if-eqz v1, :cond_a2

    const/4 v1, 0x0

    invoke-static {v2, v1, v4}, Landroid/icu/text/ArabicShaping;->invertBuffer([CII)V

    :cond_a2
    const/4 v1, 0x0

    move/from16 v0, p5

    invoke-static {v2, v1, p4, v0, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move p3, v4

    goto/16 :goto_3

    .restart local v5       #digitBase:C
    :sswitch_ab
    const/16 v5, 0x660

    goto :goto_93

    :sswitch_ae
    const/16 v5, 0x6f0

    goto :goto_93

    :sswitch_b1
    add-int/lit8 v8, v5, -0x30

    .local v8, digitDelta:I
    const/4 v10, 0x0

    .local v10, i:I
    :goto_b4
    if-ge v10, v4, :cond_9a

    aget-char v7, v2, v10

    .local v7, ch:C
    const/16 v1, 0x39

    if-gt v7, v1, :cond_c6

    const/16 v1, 0x30

    if-lt v7, v1, :cond_c6

    aget-char v1, v2, v10

    add-int/2addr v1, v8

    int-to-char v1, v1

    aput-char v1, v2, v10

    :cond_c6
    add-int/lit8 v10, v10, 0x1

    goto :goto_b4

    .end local v7           #ch:C
    .end local v8           #digitDelta:I
    .end local v10           #i:I
    :sswitch_c9
    add-int/lit8 v1, v5, 0x9

    int-to-char v9, v1

    .local v9, digitTop:C
    rsub-int/lit8 v8, v5, 0x30

    .restart local v8       #digitDelta:I
    const/4 v10, 0x0

    .restart local v10       #i:I
    :goto_cf
    if-ge v10, v4, :cond_9a

    aget-char v7, v2, v10

    .restart local v7       #ch:C
    if-gt v7, v9, :cond_dd

    if-lt v7, v5, :cond_dd

    aget-char v1, v2, v10

    add-int/2addr v1, v8

    int-to-char v1, v1

    aput-char v1, v2, v10

    :cond_dd
    add-int/lit8 v10, v10, 0x1

    goto :goto_cf

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

    :sswitch_e7
    const/4 v3, 0x0

    const/4 v6, 0x1

    move-object v1, p0

    invoke-direct/range {v1 .. v6}, Landroid/icu/text/ArabicShaping;->shapeToArabicDigitsWithContext([CIICZ)V

    goto :goto_9a

    :sswitch_data_ee
    .sparse-switch
        0x8 -> :sswitch_49
        0x10 -> :sswitch_7c
        0x18 -> :sswitch_3e
    .end sparse-switch

    :sswitch_data_fc
    .sparse-switch
        0x0 -> :sswitch_ab
        0x100 -> :sswitch_ae
    .end sparse-switch

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
    move v0, p1

    .local v0, i:I
    add-int v3, p1, p2

    add-int/lit8 v1, v3, -0x1

    .local v1, j:I
    :goto_5
    if-ge v0, v1, :cond_14

    aget-char v2, p0, v0

    .local v2, temp:C
    aget-char v3, p0, v1

    aput-char v3, p0, v0

    aput-char v2, p0, v1

    add-int/lit8 v0, v0, 0x1

    add-int/lit8 v1, v1, -0x1

    goto :goto_5

    .end local v2           #temp:C
    :cond_14
    return-void
.end method

.method private static isAlefChar(C)Z
    .registers 2
    .parameter "ch"

    .prologue
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

    if-lt p0, v1, :cond_1d

    const v0, 0xfe7f

    if-gt p0, v0, :cond_1d

    const v0, 0xfe73

    if-eq p0, v0, :cond_1d

    const v0, 0xfe75

    if-eq p0, v0, :cond_1d

    sget-object v0, Landroid/icu/text/ArabicShaping;->tashkeelMedial:[I

    sub-int v1, p0, v1

    aget v0, v0, v1

    rsub-int/lit8 v0, v0, 0x1

    :goto_1c
    return v0

    :cond_1d
    const v0, 0xfc5e

    if-lt p0, v0, :cond_29

    const v0, 0xfc63

    if-gt p0, v0, :cond_29

    const/4 v0, 0x1

    goto :goto_1c

    :cond_29
    const/4 v0, 0x0

    goto :goto_1c
.end method

.method private static isLamAlefChar(C)Z
    .registers 2
    .parameter "ch"

    .prologue
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
    const/16 v0, 0x633

    if-lt p0, v0, :cond_a

    const/16 v0, 0x636

    if-gt p0, v0, :cond_a

    const/4 v0, 0x1

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

    if-lt p0, v1, :cond_11

    const v0, 0xfebf

    if-ge p0, v0, :cond_11

    sget-object v0, Landroid/icu/text/ArabicShaping;->tailFamilyIsolatedFinal:[I

    sub-int v1, p0, v1

    aget v0, v0, v1

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
    const/16 v0, 0x200b

    if-eq p0, v0, :cond_9

    const v0, 0xfe73

    if-ne p0, v0, :cond_b

    :cond_9
    const/4 v0, 0x1

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

    if-lt p0, v1, :cond_20

    const v0, 0xfe7f

    if-gt p0, v0, :cond_20

    const v0, 0xfe73

    if-eq p0, v0, :cond_20

    const v0, 0xfe75

    if-eq p0, v0, :cond_20

    if-eq p0, v2, :cond_20

    sget-object v0, Landroid/icu/text/ArabicShaping;->tashkeelMedial:[I

    sub-int v1, p0, v1

    aget v0, v0, v1

    :goto_1f
    return v0

    :cond_20
    const v0, 0xfcf2

    if-lt p0, v0, :cond_2a

    const v0, 0xfcf4

    if-le p0, v0, :cond_2c

    :cond_2a
    if-ne p0, v2, :cond_2e

    :cond_2c
    const/4 v0, 0x2

    goto :goto_1f

    :cond_2e
    const/4 v0, 0x0

    goto :goto_1f
.end method

.method private static isYehHamzaChar(C)Z
    .registers 2
    .parameter "ch"

    .prologue
    const v0, 0xfe89

    if-eq p0, v0, :cond_a

    const v0, 0xfe8a

    if-ne p0, v0, :cond_c

    :cond_a
    const/4 v0, 0x1

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

    const/4 v3, 0x0

    .local v3, lacount:I
    move v2, p2

    .local v2, i:I
    add-int v1, v2, p3

    .local v1, e:I
    :goto_7
    if-ge v2, v1, :cond_26

    aget-char v0, p1, v2

    .local v0, ch:C
    if-lt v0, v6, :cond_23

    const v4, 0xfefc

    if-gt v0, v4, :cond_23

    invoke-static {v0}, Landroid/icu/text/ArabicShaping;->isLamAlefChar(C)Z

    move-result v4

    if-eqz v4, :cond_1a

    add-int/lit8 v3, v3, 0x1

    :cond_1a
    sget-object v4, Landroid/icu/text/ArabicShaping;->convertFEto06:[I

    sub-int v5, v0, v6

    aget v4, v4, v5

    int-to-char v4, v4

    aput-char v4, p1, v2

    :cond_23
    add-int/lit8 v2, v2, 0x1

    goto :goto_7

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
    add-int/lit8 v2, p4, -0x30

    int-to-char p4, v2

    add-int v1, p2, p3

    .local v1, i:I
    :cond_5
    :goto_5
    add-int/lit8 v1, v1, -0x1

    if-lt v1, p2, :cond_23

    aget-char v0, p1, v1

    .local v0, ch:C
    invoke-static {v0}, Ljava/lang/Character;->getDirectionality(C)B

    move-result v2

    packed-switch v2, :pswitch_data_24

    goto :goto_5

    :pswitch_13
    const/4 p5, 0x0

    goto :goto_5

    :pswitch_15
    const/4 p5, 0x1

    goto :goto_5

    :pswitch_17
    if-eqz p5, :cond_5

    const/16 v2, 0x39

    if-gt v0, v2, :cond_5

    add-int v2, v0, p4

    int-to-char v2, v2

    aput-char v2, p1, v1

    goto :goto_5

    .end local v0           #ch:C
    :cond_23
    return-void

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
    invoke-direct/range {p0 .. p3}, Landroid/icu/text/ArabicShaping;->normalize([CII)I

    move-result v5

    .local v5, lamalef_count:I
    const/4 v10, 0x0

    .local v10, lamalef_found:Z
    const/16 v17, 0x0

    .local v17, seenfam_found:Z
    const/16 v21, 0x0

    .local v21, yehhamza_found:Z
    const/16 v19, 0x0

    .local v19, tashkeel_found:Z
    add-int v1, p2, p3

    add-int/lit8 v9, v1, -0x1

    .local v9, i:I
    aget-char v1, p1, v9

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->getLink(C)I

    move-result v7

    .local v7, currLink:I
    const/4 v13, 0x0

    .local v13, nextLink:I
    const/16 v16, 0x0

    .local v16, prevLink:I
    const/4 v11, 0x0

    .local v11, lastLink:I
    move v12, v9

    .local v12, lastPos:I
    const/4 v15, -0x2

    .local v15, nx:I
    const/4 v14, 0x0

    .local v14, nw:I
    :cond_1c
    :goto_1c
    if-ltz v9, :cond_128

    const v1, 0xff00

    and-int/2addr v1, v7

    if-gtz v1, :cond_2c

    aget-char v1, p1, v9

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->isTashkeelChar(C)Z

    move-result v1

    if-eqz v1, :cond_a4

    :cond_2c
    add-int/lit8 v14, v9, -0x1

    const/4 v15, -0x2

    :goto_2f
    if-gez v15, :cond_48

    const/4 v1, -0x1

    if-ne v14, v1, :cond_39

    const/4 v13, 0x0

    const v15, 0x7fffffff

    goto :goto_2f

    :cond_39
    aget-char v1, p1, v14

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->getLink(C)I

    move-result v13

    and-int/lit8 v1, v13, 0x4

    if-nez v1, :cond_45

    move v15, v14

    goto :goto_2f

    :cond_45
    add-int/lit8 v14, v14, -0x1

    goto :goto_2f

    :cond_48
    and-int/lit8 v1, v7, 0x20

    if-lez v1, :cond_67

    and-int/lit8 v1, v11, 0x10

    if-lez v1, :cond_67

    const/4 v10, 0x1

    aget-char v1, p1, v9

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->changeLamAlef(C)C

    move-result v20

    .local v20, wLamalef:C
    if-eqz v20, :cond_61

    const v1, 0xffff

    aput-char v1, p1, v9

    aput-char v20, p1, v12

    move v9, v12

    :cond_61
    move/from16 v11, v16

    invoke-static/range {v20 .. v20}, Landroid/icu/text/ArabicShaping;->getLink(C)I

    move-result v7

    .end local v20           #wLamalef:C
    :cond_67
    if-lez v9, :cond_bd

    add-int/lit8 v1, v9, -0x1

    aget-char v1, p1, v1

    const/16 v2, 0x20

    if-ne v1, v2, :cond_bd

    aget-char v1, p1, v9

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->isSeenFamilyChar(C)I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_b4

    const/16 v17, 0x1

    :cond_7c
    :goto_7c
    aget-char v1, p1, v9

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->specialChar(C)I

    move-result v8

    .local v8, flag:I
    sget-object v1, Landroid/icu/text/ArabicShaping;->shapeTable:[[[I

    and-int/lit8 v2, v13, 0x3

    aget-object v1, v1, v2

    and-int/lit8 v2, v11, 0x3

    aget-object v1, v1, v2

    and-int/lit8 v2, v7, 0x3

    aget v18, v1, v2

    .local v18, shape:I
    const/4 v1, 0x1

    if-ne v8, v1, :cond_d4

    and-int/lit8 v18, v18, 0x1

    :cond_95
    :goto_95
    const/4 v1, 0x2

    if-ne v8, v1, :cond_111

    const/4 v1, 0x2

    move/from16 v0, p5

    if-ne v0, v1, :cond_ff

    const v1, 0xfffe

    aput-char v1, p1, v9

    const/16 v19, 0x1

    .end local v8           #flag:I
    .end local v18           #shape:I
    :cond_a4
    :goto_a4
    and-int/lit8 v1, v7, 0x4

    if-nez v1, :cond_ac

    move/from16 v16, v11

    move v11, v7

    move v12, v9

    :cond_ac
    add-int/lit8 v9, v9, -0x1

    if-ne v9, v15, :cond_11d

    move v7, v13

    const/4 v15, -0x2

    goto/16 :goto_1c

    :cond_b4
    aget-char v1, p1, v9

    const/16 v2, 0x626

    if-ne v1, v2, :cond_7c

    const/16 v21, 0x1

    goto :goto_7c

    :cond_bd
    if-nez v9, :cond_7c

    aget-char v1, p1, v9

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->isSeenFamilyChar(C)I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_cb

    const/16 v17, 0x1

    goto :goto_7c

    :cond_cb
    aget-char v1, p1, v9

    const/16 v2, 0x626

    if-ne v1, v2, :cond_7c

    const/16 v21, 0x1

    goto :goto_7c

    .restart local v8       #flag:I
    .restart local v18       #shape:I
    :cond_d4
    const/4 v1, 0x2

    if-ne v8, v1, :cond_95

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

    :cond_f9
    const/16 v18, 0x1

    goto :goto_95

    :cond_fc
    const/16 v18, 0x0

    goto :goto_95

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

    :cond_111
    const v1, 0xfe70

    shr-int/lit8 v2, v7, 0x8

    add-int/2addr v1, v2

    add-int v1, v1, v18

    int-to-char v1, v1

    aput-char v1, p1, v9

    goto :goto_a4

    .end local v8           #flag:I
    .end local v18           #shape:I
    :cond_11d
    const/4 v1, -0x1

    if-eq v9, v1, :cond_1c

    aget-char v1, p1, v9

    invoke-static {v1}, Landroid/icu/text/ArabicShaping;->getLink(C)I

    move-result v7

    goto/16 :goto_1c

    :cond_128
    move/from16 p4, p3

    if-nez v10, :cond_12e

    if-eqz v19, :cond_132

    :cond_12e
    invoke-direct/range {p0 .. p3}, Landroid/icu/text/ArabicShaping;->handleGeneratedSpaces([CII)I

    move-result p4

    :cond_132
    if-nez v17, :cond_136

    if-eqz v21, :cond_143

    :cond_136
    const/4 v6, 0x0

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move/from16 v3, p2

    move/from16 v4, p4

    invoke-direct/range {v1 .. v6}, Landroid/icu/text/ArabicShaping;->expandCompositChar([CIIII)I

    move-result p4

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
    move v2, p2

    .local v2, w:I
    move v1, p2

    .local v1, r:I
    :cond_2
    :goto_2
    add-int/lit8 v1, v1, -0x1

    if-lt v1, p1, :cond_11

    aget-char v0, p0, v1

    .local v0, ch:C
    if-eq v0, p3, :cond_2

    add-int/lit8 v2, v2, -0x1

    if-eq v2, v1, :cond_2

    aput-char v0, p0, v2

    goto :goto_2

    .end local v0           #ch:C
    :cond_11
    return-void
.end method

.method private static specialChar(C)I
    .registers 2
    .parameter "ch"

    .prologue
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

    :cond_20
    const/4 v0, 0x1

    :goto_21
    return v0

    :cond_22
    const/16 v0, 0x64b

    if-lt p0, v0, :cond_2c

    const/16 v0, 0x652

    if-gt p0, v0, :cond_2c

    const/4 v0, 0x2

    goto :goto_21

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

    :cond_42
    const/4 v0, 0x3

    goto :goto_21

    :cond_44
    const/4 v0, 0x0

    goto :goto_21
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 4
    .parameter "rhs"

    .prologue
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

    if-nez p1, :cond_10

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "source can not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_10
    if-ltz p2, :cond_19

    if-ltz p3, :cond_19

    add-int v0, p2, p3

    array-length v1, p1

    if-le v0, v1, :cond_47

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

    :cond_47
    if-nez p4, :cond_54

    if-eqz p6, :cond_54

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "null dest requires destSize == 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_54
    if-eqz p6, :cond_8d

    if-ltz p5, :cond_5f

    if-ltz p6, :cond_5f

    add-int v0, p5, p6

    array-length v1, p4

    if-le v0, v1, :cond_8d

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

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Wrong Tashkeel argument"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

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

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Wrong Lam Alef argument"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_e1
    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/2addr v0, v3

    if-lez v0, :cond_f6

    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit8 v0, v0, 0x18

    const/16 v1, 0x10

    if-ne v0, v1, :cond_f6

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Tashkeel replacement should not be enabled in deshaping mode "

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

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

    invoke-virtual {p1}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    .local v1, src:[C
    move-object v4, v1

    .local v4, dest:[C
    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    const v3, 0x10003

    and-int/2addr v0, v3

    if-nez v0, :cond_1b

    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit8 v0, v0, 0x18

    const/16 v3, 0x10

    if-ne v0, v3, :cond_1b

    array-length v0, v1

    mul-int/lit8 v0, v0, 0x2

    new-array v4, v0, [C

    :cond_1b
    array-length v3, v1

    array-length v6, v4

    move-object v0, p0

    move v5, v2

    invoke-virtual/range {v0 .. v6}, Landroid/icu/text/ArabicShaping;->shape([CII[CII)I

    move-result v7

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
    iget v0, p0, Landroid/icu/text/ArabicShaping;->options:I

    const v1, 0x10003

    and-int/2addr v0, v1

    if-nez v0, :cond_10

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

    invoke-virtual/range {v0 .. v6}, Landroid/icu/text/ArabicShaping;->shape([CII[CII)I

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .local v0, buf:Ljava/lang/StringBuffer;
    const/16 v1, 0x5b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const v2, 0x10003

    and-int/2addr v1, v2

    sparse-switch v1, :sswitch_data_ec

    :goto_17
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit8 v1, v1, 0x4

    sparse-switch v1, :sswitch_data_102

    :goto_1e
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit8 v1, v1, 0x18

    sparse-switch v1, :sswitch_data_10c

    :goto_25
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v2, 0x70

    and-int/2addr v1, v2

    packed-switch v1, :pswitch_data_11e

    :goto_2d
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v2, 0x380

    and-int/2addr v1, v2

    packed-switch v1, :pswitch_data_124

    :goto_35
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    const/high16 v2, 0xe

    and-int/2addr v1, v2

    sparse-switch v1, :sswitch_data_12a

    :goto_3d
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit16 v1, v1, 0xe0

    sparse-switch v1, :sswitch_data_13c

    :goto_44
    iget v1, p0, Landroid/icu/text/ArabicShaping;->options:I

    and-int/lit16 v1, v1, 0x100

    sparse-switch v1, :sswitch_data_152

    :goto_4b
    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    :sswitch_55
    const-string v1, "LamAlef resize"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_17

    :sswitch_5b
    const-string v1, "LamAlef spaces at near"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_17

    :sswitch_61
    const-string v1, "LamAlef spaces at begin"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_17

    :sswitch_67
    const-string v1, "LamAlef spaces at end"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_17

    :sswitch_6d
    const-string v1, "lamAlef auto"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_17

    :sswitch_73
    const-string v1, ", logical"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1e

    :sswitch_79
    const-string v1, ", visual"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1e

    :sswitch_7f
    const-string v1, ", no letter shaping"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_25

    :sswitch_85
    const-string v1, ", shape letters"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_25

    :sswitch_8b
    const-string v1, ", shape letters tashkeel isolated"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_25

    :sswitch_91
    const-string v1, ", unshape letters"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_25

    :pswitch_97
    const-string v1, ", Seen at near"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2d

    :pswitch_9d
    const-string v1, ", Yeh Hamza at near"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_35

    :sswitch_a3
    const-string v1, ", Tashkeel at begin"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_3d

    :sswitch_a9
    const-string v1, ", Tashkeel at end"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_3d

    :sswitch_af
    const-string v1, ", Tashkeel replace with tatweel"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_3d

    :sswitch_b5
    const-string v1, ", Tashkeel resize"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_3d

    :sswitch_bb
    const-string v1, ", no digit shaping"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_44

    :sswitch_c1
    const-string v1, ", shape digits to AN"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_44

    :sswitch_c8
    const-string v1, ", shape digits to EN"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_44

    :sswitch_cf
    const-string v1, ", shape digits to AN contextually: default EN"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_44

    :sswitch_d6
    const-string v1, ", shape digits to AN contextually: default AL"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_44

    :sswitch_dd
    const-string v1, ", standard Arabic-Indic digits"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_4b

    :sswitch_e4
    const-string v1, ", extended Arabic-Indic digits"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_4b

    nop

    :sswitch_data_ec
    .sparse-switch
        0x0 -> :sswitch_55
        0x1 -> :sswitch_5b
        0x2 -> :sswitch_67
        0x3 -> :sswitch_61
        0x10000 -> :sswitch_6d
    .end sparse-switch

    :sswitch_data_102
    .sparse-switch
        0x0 -> :sswitch_73
        0x4 -> :sswitch_79
    .end sparse-switch

    :sswitch_data_10c
    .sparse-switch
        0x0 -> :sswitch_7f
        0x8 -> :sswitch_85
        0x10 -> :sswitch_91
        0x18 -> :sswitch_8b
    .end sparse-switch

    :pswitch_data_11e
    .packed-switch 0x200000
        :pswitch_97
    .end packed-switch

    :pswitch_data_124
    .packed-switch 0x1000000
        :pswitch_9d
    .end packed-switch

    :sswitch_data_12a
    .sparse-switch
        0x40000 -> :sswitch_a3
        0x60000 -> :sswitch_a9
        0x80000 -> :sswitch_b5
        0xc0000 -> :sswitch_af
    .end sparse-switch

    :sswitch_data_13c
    .sparse-switch
        0x0 -> :sswitch_bb
        0x20 -> :sswitch_c1
        0x40 -> :sswitch_c8
        0x60 -> :sswitch_cf
        0x80 -> :sswitch_d6
    .end sparse-switch

    :sswitch_data_152
    .sparse-switch
        0x0 -> :sswitch_dd
        0x100 -> :sswitch_e4
    .end sparse-switch
.end method
