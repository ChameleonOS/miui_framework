.class public Landroid/view/KeyCharacterMap;
.super Ljava/lang/Object;
.source "KeyCharacterMap.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/KeyCharacterMap$FallbackAction;,
        Landroid/view/KeyCharacterMap$UnavailableException;,
        Landroid/view/KeyCharacterMap$KeyData;
    }
.end annotation


# static fields
.field private static final ACCENT_ACUTE:I = 0xb4

.field private static final ACCENT_BREVE:I = 0x2d8

.field private static final ACCENT_CARON:I = 0x2c7

.field private static final ACCENT_CEDILLA:I = 0xb8

.field private static final ACCENT_CIRCUMFLEX:I = 0x2c6

.field private static final ACCENT_CIRCUMFLEX_LEGACY:I = 0x5e

.field private static final ACCENT_COMMA_ABOVE:I = 0x1fbd

.field private static final ACCENT_COMMA_ABOVE_RIGHT:I = 0x2bc

.field private static final ACCENT_DOT_ABOVE:I = 0x2d9

.field private static final ACCENT_DOT_BELOW:I = 0x2e

.field private static final ACCENT_DOUBLE_ACUTE:I = 0x2dd

.field private static final ACCENT_GRAVE:I = 0x2cb

.field private static final ACCENT_GRAVE_LEGACY:I = 0x60

.field private static final ACCENT_HOOK_ABOVE:I = 0x2c0

.field private static final ACCENT_HORN:I = 0x27

.field private static final ACCENT_MACRON:I = 0xaf

.field private static final ACCENT_MACRON_BELOW:I = 0x2cd

.field private static final ACCENT_OGONEK:I = 0x2db

.field private static final ACCENT_REVERSED_COMMA_ABOVE:I = 0x2bd

.field private static final ACCENT_RING_ABOVE:I = 0x2da

.field private static final ACCENT_STROKE:I = 0x2d

.field private static final ACCENT_TILDE:I = 0x2dc

.field private static final ACCENT_TILDE_LEGACY:I = 0x7e

.field private static final ACCENT_TURNED_COMMA_ABOVE:I = 0x2bb

.field private static final ACCENT_UMLAUT:I = 0xa8

.field private static final ACCENT_VERTICAL_LINE_ABOVE:I = 0x2c8

.field private static final ACCENT_VERTICAL_LINE_BELOW:I = 0x2cc

.field public static final ALPHA:I = 0x3

.field public static final BUILT_IN_KEYBOARD:I = 0x0
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final COMBINING_ACCENT:I = -0x80000000

.field public static final COMBINING_ACCENT_MASK:I = 0x7fffffff

.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/view/KeyCharacterMap;",
            ">;"
        }
    .end annotation
.end field

.field public static final FULL:I = 0x4

.field public static final HEX_INPUT:C = '\uef00'

.field public static final MODIFIER_BEHAVIOR_CHORDED:I = 0x0

.field public static final MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED:I = 0x1

.field public static final NUMERIC:I = 0x1

.field public static final PICKER_DIALOG_INPUT:C = '\uef01'

.field public static final PREDICTIVE:I = 0x2

.field public static final SPECIAL_FUNCTION:I = 0x5

.field public static final VIRTUAL_KEYBOARD:I = -0x1

.field private static final sAccentToCombining:Landroid/util/SparseIntArray;

.field private static final sCombiningToAccent:Landroid/util/SparseIntArray;

.field private static final sDeadKeyBuilder:Ljava/lang/StringBuilder;

.field private static final sDeadKeyCache:Landroid/util/SparseIntArray;


# instance fields
.field private mPtr:I


# direct methods
.method static constructor <clinit>()V
    .registers 7

    .prologue
    const/16 v6, 0x302

    const/16 v5, 0x300

    const/16 v4, 0x2cb

    const/16 v2, 0xb4

    const/16 v3, 0x2d

    .line 186
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    sput-object v0, Landroid/view/KeyCharacterMap;->sCombiningToAccent:Landroid/util/SparseIntArray;

    .line 187
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    sput-object v0, Landroid/view/KeyCharacterMap;->sAccentToCombining:Landroid/util/SparseIntArray;

    .line 189
    invoke-static {v5, v4}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 190
    const/16 v0, 0x301

    invoke-static {v0, v2}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 191
    const/16 v0, 0x2c6

    invoke-static {v6, v0}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 192
    const/16 v0, 0x303

    const/16 v1, 0x2dc

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 193
    const/16 v0, 0x304

    const/16 v1, 0xaf

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 194
    const/16 v0, 0x306

    const/16 v1, 0x2d8

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 195
    const/16 v0, 0x307

    const/16 v1, 0x2d9

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 196
    const/16 v0, 0x308

    const/16 v1, 0xa8

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 197
    const/16 v0, 0x309

    const/16 v1, 0x2c0

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 198
    const/16 v0, 0x30a

    const/16 v1, 0x2da

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 199
    const/16 v0, 0x30b

    const/16 v1, 0x2dd

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 200
    const/16 v0, 0x30c

    const/16 v1, 0x2c7

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 201
    const/16 v0, 0x30d

    const/16 v1, 0x2c8

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 206
    const/16 v0, 0x312

    const/16 v1, 0x2bb

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 207
    const/16 v0, 0x313

    const/16 v1, 0x1fbd

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 208
    const/16 v0, 0x314

    const/16 v1, 0x2bd

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 209
    const/16 v0, 0x315

    const/16 v1, 0x2bc

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 210
    const/16 v0, 0x31b

    const/16 v1, 0x27

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 211
    const/16 v0, 0x323

    const/16 v1, 0x2e

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 213
    const/16 v0, 0x327

    const/16 v1, 0xb8

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 214
    const/16 v0, 0x328

    const/16 v1, 0x2db

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 215
    const/16 v0, 0x329

    const/16 v1, 0x2cc

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 216
    const/16 v0, 0x331

    const/16 v1, 0x2cd

    invoke-static {v0, v1}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 217
    const/16 v0, 0x335

    invoke-static {v0, v3}, Landroid/view/KeyCharacterMap;->addCombining(II)V

    .line 223
    sget-object v0, Landroid/view/KeyCharacterMap;->sCombiningToAccent:Landroid/util/SparseIntArray;

    const/16 v1, 0x340

    invoke-virtual {v0, v1, v4}, Landroid/util/SparseIntArray;->append(II)V

    .line 224
    sget-object v0, Landroid/view/KeyCharacterMap;->sCombiningToAccent:Landroid/util/SparseIntArray;

    const/16 v1, 0x341

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 225
    sget-object v0, Landroid/view/KeyCharacterMap;->sCombiningToAccent:Landroid/util/SparseIntArray;

    const/16 v1, 0x343

    const/16 v2, 0x1fbd

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 228
    sget-object v0, Landroid/view/KeyCharacterMap;->sAccentToCombining:Landroid/util/SparseIntArray;

    const/16 v1, 0x60

    invoke-virtual {v0, v1, v5}, Landroid/util/SparseIntArray;->append(II)V

    .line 229
    sget-object v0, Landroid/view/KeyCharacterMap;->sAccentToCombining:Landroid/util/SparseIntArray;

    const/16 v1, 0x5e

    invoke-virtual {v0, v1, v6}, Landroid/util/SparseIntArray;->append(II)V

    .line 230
    sget-object v0, Landroid/view/KeyCharacterMap;->sAccentToCombining:Landroid/util/SparseIntArray;

    const/16 v1, 0x7e

    const/16 v2, 0x303

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 243
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    sput-object v0, Landroid/view/KeyCharacterMap;->sDeadKeyCache:Landroid/util/SparseIntArray;

    .line 244
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sput-object v0, Landroid/view/KeyCharacterMap;->sDeadKeyBuilder:Ljava/lang/StringBuilder;

    .line 248
    const/16 v0, 0x44

    const/16 v1, 0x110

    invoke-static {v3, v0, v1}, Landroid/view/KeyCharacterMap;->addDeadKey(III)V

    .line 249
    const/16 v0, 0x47

    const/16 v1, 0x1e4

    invoke-static {v3, v0, v1}, Landroid/view/KeyCharacterMap;->addDeadKey(III)V

    .line 250
    const/16 v0, 0x48

    const/16 v1, 0x126

    invoke-static {v3, v0, v1}, Landroid/view/KeyCharacterMap;->addDeadKey(III)V

    .line 251
    const/16 v0, 0x49

    const/16 v1, 0x197

    invoke-static {v3, v0, v1}, Landroid/view/KeyCharacterMap;->addDeadKey(III)V

    .line 252
    const/16 v0, 0x4c

    const/16 v1, 0x141

    invoke-static {v3, v0, v1}, Landroid/view/KeyCharacterMap;->addDeadKey(III)V

    .line 253
    const/16 v0, 0x4f

    const/16 v1, 0xd8

    invoke-static {v3, v0, v1}, Landroid/view/KeyCharacterMap;->addDeadKey(III)V

    .line 254
    const/16 v0, 0x54

    const/16 v1, 0x166

    invoke-static {v3, v0, v1}, Landroid/view/KeyCharacterMap;->addDeadKey(III)V

    .line 255
    const/16 v0, 0x64

    const/16 v1, 0x111

    invoke-static {v3, v0, v1}, Landroid/view/KeyCharacterMap;->addDeadKey(III)V

    .line 256
    const/16 v0, 0x67

    const/16 v1, 0x1e5

    invoke-static {v3, v0, v1}, Landroid/view/KeyCharacterMap;->addDeadKey(III)V

    .line 257
    const/16 v0, 0x68

    const/16 v1, 0x127

    invoke-static {v3, v0, v1}, Landroid/view/KeyCharacterMap;->addDeadKey(III)V

    .line 258
    const/16 v0, 0x69

    const/16 v1, 0x268

    invoke-static {v3, v0, v1}, Landroid/view/KeyCharacterMap;->addDeadKey(III)V

    .line 259
    const/16 v0, 0x6c

    const/16 v1, 0x142

    invoke-static {v3, v0, v1}, Landroid/view/KeyCharacterMap;->addDeadKey(III)V

    .line 260
    const/16 v0, 0x6f

    const/16 v1, 0xf8

    invoke-static {v3, v0, v1}, Landroid/view/KeyCharacterMap;->addDeadKey(III)V

    .line 261
    const/16 v0, 0x74

    const/16 v1, 0x167

    invoke-static {v3, v0, v1}, Landroid/view/KeyCharacterMap;->addDeadKey(III)V

    .line 273
    new-instance v0, Landroid/view/KeyCharacterMap$1;

    invoke-direct {v0}, Landroid/view/KeyCharacterMap$1;-><init>()V

    sput-object v0, Landroid/view/KeyCharacterMap;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>(I)V
    .registers 2
    .parameter "ptr"

    .prologue
    .line 309
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 310
    iput p1, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    .line 311
    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .registers 4
    .parameter "in"

    .prologue
    .line 298
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 299
    if-nez p1, :cond_e

    .line 300
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "parcel must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 302
    :cond_e
    invoke-static {p1}, Landroid/view/KeyCharacterMap;->nativeReadFromParcel(Landroid/os/Parcel;)I

    move-result v0

    iput v0, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    .line 303
    iget v0, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    if-nez v0, :cond_20

    .line 304
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Could not read KeyCharacterMap from parcel."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 306
    :cond_20
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Landroid/view/KeyCharacterMap$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 32
    invoke-direct {p0, p1}, Landroid/view/KeyCharacterMap;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method private static addCombining(II)V
    .registers 3
    .parameter "combining"
    .parameter "accent"

    .prologue
    .line 234
    sget-object v0, Landroid/view/KeyCharacterMap;->sCombiningToAccent:Landroid/util/SparseIntArray;

    invoke-virtual {v0, p0, p1}, Landroid/util/SparseIntArray;->append(II)V

    .line 235
    sget-object v0, Landroid/view/KeyCharacterMap;->sAccentToCombining:Landroid/util/SparseIntArray;

    invoke-virtual {v0, p1, p0}, Landroid/util/SparseIntArray;->append(II)V

    .line 236
    return-void
.end method

.method private static addDeadKey(III)V
    .registers 7
    .parameter "accent"
    .parameter "c"
    .parameter "result"

    .prologue
    .line 265
    sget-object v2, Landroid/view/KeyCharacterMap;->sAccentToCombining:Landroid/util/SparseIntArray;

    invoke-virtual {v2, p0}, Landroid/util/SparseIntArray;->get(I)I

    move-result v1

    .line 266
    .local v1, combining:I
    if-nez v1, :cond_10

    .line 267
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "Invalid dead key declaration."

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 269
    :cond_10
    shl-int/lit8 v2, v1, 0x10

    or-int v0, v2, p1

    .line 270
    .local v0, combination:I
    sget-object v2, Landroid/view/KeyCharacterMap;->sDeadKeyCache:Landroid/util/SparseIntArray;

    invoke-virtual {v2, v0, p2}, Landroid/util/SparseIntArray;->put(II)V

    .line 271
    return-void
.end method

.method public static deviceHasKey(I)Z
    .registers 4
    .parameter "keyCode"

    .prologue
    const/4 v2, 0x0

    .line 685
    invoke-static {}, Landroid/hardware/input/InputManager;->getInstance()Landroid/hardware/input/InputManager;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [I

    aput p0, v1, v2

    invoke-virtual {v0, v1}, Landroid/hardware/input/InputManager;->deviceHasKeys([I)[Z

    move-result-object v0

    aget-boolean v0, v0, v2

    return v0
.end method

.method public static deviceHasKeys([I)[Z
    .registers 2
    .parameter "keyCodes"

    .prologue
    .line 699
    invoke-static {}, Landroid/hardware/input/InputManager;->getInstance()Landroid/hardware/input/InputManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/hardware/input/InputManager;->deviceHasKeys([I)[Z

    move-result-object v0

    return-object v0
.end method

.method public static getDeadChar(II)I
    .registers 11
    .parameter "accent"
    .parameter "c"

    .prologue
    const/4 v8, -0x1

    const/4 v4, 0x0

    .line 484
    sget-object v5, Landroid/view/KeyCharacterMap;->sAccentToCombining:Landroid/util/SparseIntArray;

    invoke-virtual {v5, p0}, Landroid/util/SparseIntArray;->get(I)I

    move-result v2

    .line 485
    .local v2, combining:I
    if-nez v2, :cond_c

    move v1, v4

    .line 502
    :goto_b
    return v1

    .line 489
    :cond_c
    shl-int/lit8 v5, v2, 0x10

    or-int v0, v5, p1

    .line 491
    .local v0, combination:I
    sget-object v5, Landroid/view/KeyCharacterMap;->sDeadKeyCache:Landroid/util/SparseIntArray;

    monitor-enter v5

    .line 492
    :try_start_13
    sget-object v6, Landroid/view/KeyCharacterMap;->sDeadKeyCache:Landroid/util/SparseIntArray;

    const/4 v7, -0x1

    invoke-virtual {v6, v0, v7}, Landroid/util/SparseIntArray;->get(II)I

    move-result v1

    .line 493
    .local v1, combined:I
    if-ne v1, v8, :cond_47

    .line 494
    sget-object v6, Landroid/view/KeyCharacterMap;->sDeadKeyBuilder:Ljava/lang/StringBuilder;

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 495
    sget-object v6, Landroid/view/KeyCharacterMap;->sDeadKeyBuilder:Ljava/lang/StringBuilder;

    int-to-char v7, p1

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 496
    sget-object v6, Landroid/view/KeyCharacterMap;->sDeadKeyBuilder:Ljava/lang/StringBuilder;

    int-to-char v7, v2

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 497
    sget-object v6, Landroid/view/KeyCharacterMap;->sDeadKeyBuilder:Ljava/lang/StringBuilder;

    sget-object v7, Ljava/text/Normalizer$Form;->NFC:Ljava/text/Normalizer$Form;

    invoke-static {v6, v7}, Ljava/text/Normalizer;->normalize(Ljava/lang/CharSequence;Ljava/text/Normalizer$Form;)Ljava/lang/String;

    move-result-object v3

    .line 498
    .local v3, result:Ljava/lang/String;
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v6

    const/4 v7, 0x1

    if-ne v6, v7, :cond_4c

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Ljava/lang/String;->charAt(I)C

    move-result v1

    .line 499
    :goto_42
    sget-object v4, Landroid/view/KeyCharacterMap;->sDeadKeyCache:Landroid/util/SparseIntArray;

    invoke-virtual {v4, v0, v1}, Landroid/util/SparseIntArray;->put(II)V

    .line 501
    .end local v3           #result:Ljava/lang/String;
    :cond_47
    monitor-exit v5

    goto :goto_b

    .end local v1           #combined:I
    :catchall_49
    move-exception v4

    monitor-exit v5
    :try_end_4b
    .catchall {:try_start_13 .. :try_end_4b} :catchall_49

    throw v4

    .restart local v1       #combined:I
    .restart local v3       #result:Ljava/lang/String;
    :cond_4c
    move v1, v4

    .line 498
    goto :goto_42
.end method

.method public static load(I)Landroid/view/KeyCharacterMap;
    .registers 6
    .parameter "deviceId"

    .prologue
    .line 331
    invoke-static {}, Landroid/hardware/input/InputManager;->getInstance()Landroid/hardware/input/InputManager;

    move-result-object v0

    .line 332
    .local v0, im:Landroid/hardware/input/InputManager;
    invoke-virtual {v0, p0}, Landroid/hardware/input/InputManager;->getInputDevice(I)Landroid/view/InputDevice;

    move-result-object v1

    .line 333
    .local v1, inputDevice:Landroid/view/InputDevice;
    if-nez v1, :cond_2a

    .line 334
    const/4 v2, -0x1

    invoke-virtual {v0, v2}, Landroid/hardware/input/InputManager;->getInputDevice(I)Landroid/view/InputDevice;

    move-result-object v1

    .line 335
    if-nez v1, :cond_2a

    .line 336
    new-instance v2, Landroid/view/KeyCharacterMap$UnavailableException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not load key character map for device "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/view/KeyCharacterMap$UnavailableException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 340
    :cond_2a
    invoke-virtual {v1}, Landroid/view/InputDevice;->getKeyCharacterMap()Landroid/view/KeyCharacterMap;

    move-result-object v2

    return-object v2
.end method

.method private static native nativeDispose(I)V
.end method

.method private static native nativeGetCharacter(III)C
.end method

.method private static native nativeGetDisplayLabel(II)C
.end method

.method private static native nativeGetEvents(I[C)[Landroid/view/KeyEvent;
.end method

.method private static native nativeGetFallbackAction(IIILandroid/view/KeyCharacterMap$FallbackAction;)Z
.end method

.method private static native nativeGetKeyboardType(I)I
.end method

.method private static native nativeGetMatch(II[CI)C
.end method

.method private static native nativeGetNumber(II)C
.end method

.method private static native nativeReadFromParcel(Landroid/os/Parcel;)I
.end method

.method private static native nativeWriteToParcel(ILandroid/os/Parcel;)V
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 712
    const/4 v0, 0x0

    return v0
.end method

.method protected finalize()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 315
    iget v0, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    if-eqz v0, :cond_c

    .line 316
    iget v0, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v0}, Landroid/view/KeyCharacterMap;->nativeDispose(I)V

    .line 317
    const/4 v0, 0x0

    iput v0, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    .line 319
    :cond_c
    return-void
.end method

.method public get(II)I
    .registers 6
    .parameter "keyCode"
    .parameter "metaState"

    .prologue
    .line 365
    invoke-static {p2}, Landroid/view/KeyEvent;->normalizeMetaState(I)I

    move-result p2

    .line 366
    iget v2, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v2, p1, p2}, Landroid/view/KeyCharacterMap;->nativeGetCharacter(III)C

    move-result v0

    .line 368
    .local v0, ch:C
    sget-object v2, Landroid/view/KeyCharacterMap;->sCombiningToAccent:Landroid/util/SparseIntArray;

    invoke-virtual {v2, v0}, Landroid/util/SparseIntArray;->get(I)I

    move-result v1

    .line 369
    .local v1, map:I
    if-eqz v1, :cond_16

    .line 370
    const/high16 v2, -0x8000

    or-int v0, v1, v2

    .line 372
    .end local v0           #ch:C
    :cond_16
    return v0
.end method

.method public getDisplayLabel(I)C
    .registers 3
    .parameter "keyCode"

    .prologue
    .line 472
    iget v0, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v0, p1}, Landroid/view/KeyCharacterMap;->nativeGetDisplayLabel(II)C

    move-result v0

    return v0
.end method

.method public getEvents([C)[Landroid/view/KeyEvent;
    .registers 4
    .parameter "chars"

    .prologue
    .line 592
    if-nez p1, :cond_a

    .line 593
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "chars must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 595
    :cond_a
    iget v0, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v0, p1}, Landroid/view/KeyCharacterMap;->nativeGetEvents(I[C)[Landroid/view/KeyEvent;

    move-result-object v0

    return-object v0
.end method

.method public getFallbackAction(II)Landroid/view/KeyCharacterMap$FallbackAction;
    .registers 5
    .parameter "keyCode"
    .parameter "metaState"

    .prologue
    .line 394
    invoke-static {}, Landroid/view/KeyCharacterMap$FallbackAction;->obtain()Landroid/view/KeyCharacterMap$FallbackAction;

    move-result-object v0

    .line 395
    .local v0, action:Landroid/view/KeyCharacterMap$FallbackAction;
    invoke-static {p2}, Landroid/view/KeyEvent;->normalizeMetaState(I)I

    move-result p2

    .line 396
    iget v1, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v1, p1, p2, v0}, Landroid/view/KeyCharacterMap;->nativeGetFallbackAction(IIILandroid/view/KeyCharacterMap$FallbackAction;)Z

    move-result v1

    if-eqz v1, :cond_19

    .line 397
    iget v1, v0, Landroid/view/KeyCharacterMap$FallbackAction;->metaState:I

    invoke-static {v1}, Landroid/view/KeyEvent;->normalizeMetaState(I)I

    move-result v1

    iput v1, v0, Landroid/view/KeyCharacterMap$FallbackAction;->metaState:I

    .line 401
    .end local v0           #action:Landroid/view/KeyCharacterMap$FallbackAction;
    :goto_18
    return-object v0

    .line 400
    .restart local v0       #action:Landroid/view/KeyCharacterMap$FallbackAction;
    :cond_19
    invoke-virtual {v0}, Landroid/view/KeyCharacterMap$FallbackAction;->recycle()V

    .line 401
    const/4 v0, 0x0

    goto :goto_18
.end method

.method public getKeyData(ILandroid/view/KeyCharacterMap$KeyData;)Z
    .registers 10
    .parameter "keyCode"
    .parameter "results"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 550
    iget-object v3, p2, Landroid/view/KeyCharacterMap$KeyData;->meta:[C

    array-length v3, v3

    const/4 v4, 0x4

    if-ge v3, v4, :cond_13

    .line 551
    new-instance v1, Ljava/lang/IndexOutOfBoundsException;

    const-string/jumbo v2, "results.meta.length must be >= 4"

    invoke-direct {v1, v2}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 555
    :cond_13
    iget v3, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v3, p1}, Landroid/view/KeyCharacterMap;->nativeGetDisplayLabel(II)C

    move-result v0

    .line 556
    .local v0, displayLabel:C
    if-nez v0, :cond_1c

    .line 567
    :goto_1b
    return v1

    .line 560
    :cond_1c
    iput-char v0, p2, Landroid/view/KeyCharacterMap$KeyData;->displayLabel:C

    .line 561
    iget v3, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v3, p1}, Landroid/view/KeyCharacterMap;->nativeGetNumber(II)C

    move-result v3

    iput-char v3, p2, Landroid/view/KeyCharacterMap$KeyData;->number:C

    .line 562
    iget-object v3, p2, Landroid/view/KeyCharacterMap$KeyData;->meta:[C

    iget v4, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v4, p1, v1}, Landroid/view/KeyCharacterMap;->nativeGetCharacter(III)C

    move-result v4

    aput-char v4, v3, v1

    .line 563
    iget-object v1, p2, Landroid/view/KeyCharacterMap$KeyData;->meta:[C

    iget v3, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v3, p1, v2}, Landroid/view/KeyCharacterMap;->nativeGetCharacter(III)C

    move-result v3

    aput-char v3, v1, v2

    .line 564
    iget-object v1, p2, Landroid/view/KeyCharacterMap$KeyData;->meta:[C

    iget v3, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v3, p1, v5}, Landroid/view/KeyCharacterMap;->nativeGetCharacter(III)C

    move-result v3

    aput-char v3, v1, v5

    .line 565
    iget-object v1, p2, Landroid/view/KeyCharacterMap$KeyData;->meta:[C

    iget v3, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v3, p1, v6}, Landroid/view/KeyCharacterMap;->nativeGetCharacter(III)C

    move-result v3

    aput-char v3, v1, v6

    move v1, v2

    .line 567
    goto :goto_1b
.end method

.method public getKeyboardType()I
    .registers 2

    .prologue
    .line 632
    iget v0, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v0}, Landroid/view/KeyCharacterMap;->nativeGetKeyboardType(I)I

    move-result v0

    return v0
.end method

.method public getMatch(I[C)C
    .registers 4
    .parameter "keyCode"
    .parameter "chars"

    .prologue
    .line 442
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Landroid/view/KeyCharacterMap;->getMatch(I[CI)C

    move-result v0

    return v0
.end method

.method public getMatch(I[CI)C
    .registers 6
    .parameter "keyCode"
    .parameter "chars"
    .parameter "metaState"

    .prologue
    .line 456
    if-nez p2, :cond_a

    .line 457
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "chars must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 460
    :cond_a
    invoke-static {p3}, Landroid/view/KeyEvent;->normalizeMetaState(I)I

    move-result p3

    .line 461
    iget v0, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v0, p1, p2, p3}, Landroid/view/KeyCharacterMap;->nativeGetMatch(II[CI)C

    move-result v0

    return v0
.end method

.method public getModifierBehavior()I
    .registers 2

    .prologue
    .line 668
    invoke-virtual {p0}, Landroid/view/KeyCharacterMap;->getKeyboardType()I

    move-result v0

    packed-switch v0, :pswitch_data_c

    .line 673
    const/4 v0, 0x1

    :goto_8
    return v0

    .line 671
    :pswitch_9
    const/4 v0, 0x0

    goto :goto_8

    .line 668
    nop

    :pswitch_data_c
    .packed-switch 0x4
        :pswitch_9
        :pswitch_9
    .end packed-switch
.end method

.method public getNumber(I)C
    .registers 3
    .parameter "keyCode"

    .prologue
    .line 426
    iget v0, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v0, p1}, Landroid/view/KeyCharacterMap;->nativeGetNumber(II)C

    move-result v0

    return v0
.end method

.method public isPrintingKey(I)Z
    .registers 4
    .parameter "keyCode"

    .prologue
    .line 605
    iget v1, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v1, p1}, Landroid/view/KeyCharacterMap;->nativeGetDisplayLabel(II)C

    move-result v1

    invoke-static {v1}, Ljava/lang/Character;->getType(C)I

    move-result v0

    .line 607
    .local v0, type:I
    packed-switch v0, :pswitch_data_12

    .line 616
    const/4 v1, 0x1

    :goto_e
    return v1

    .line 614
    :pswitch_f
    const/4 v1, 0x0

    goto :goto_e

    .line 607
    nop

    :pswitch_data_12
    .packed-switch 0xc
        :pswitch_f
        :pswitch_f
        :pswitch_f
        :pswitch_f
        :pswitch_f
    .end packed-switch
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 5
    .parameter "out"
    .parameter "flags"

    .prologue
    .line 704
    if-nez p1, :cond_b

    .line 705
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "parcel must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 707
    :cond_b
    iget v0, p0, Landroid/view/KeyCharacterMap;->mPtr:I

    invoke-static {v0, p1}, Landroid/view/KeyCharacterMap;->nativeWriteToParcel(ILandroid/os/Parcel;)V

    .line 708
    return-void
.end method
