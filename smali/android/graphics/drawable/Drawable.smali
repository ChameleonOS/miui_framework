.class public abstract Landroid/graphics/drawable/Drawable;
.super Ljava/lang/Object;
.source "Drawable.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/graphics/drawable/Drawable$ConstantState;,
        Landroid/graphics/drawable/Drawable$Callback2;,
        Landroid/graphics/drawable/Drawable$Callback;
    }
.end annotation


# static fields
.field private static final ZERO_BOUNDS_RECT:Landroid/graphics/Rect;


# instance fields
.field private mBounds:Landroid/graphics/Rect;

.field private mCallback:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/graphics/drawable/Drawable$Callback;",
            ">;"
        }
    .end annotation
.end field

.field private mChangingConfigurations:I

.field private mLevel:I

.field private mStateSet:[I

.field private mVisible:Z


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 118
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    sput-object v0, Landroid/graphics/drawable/Drawable;->ZERO_BOUNDS_RECT:Landroid/graphics/Rect;

    return-void
.end method

.method public constructor <init>()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 117
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 120
    sget-object v0, Landroid/util/StateSet;->WILD_CARD:[I

    iput-object v0, p0, Landroid/graphics/drawable/Drawable;->mStateSet:[I

    .line 121
    iput v1, p0, Landroid/graphics/drawable/Drawable;->mLevel:I

    .line 122
    iput v1, p0, Landroid/graphics/drawable/Drawable;->mChangingConfigurations:I

    .line 123
    sget-object v0, Landroid/graphics/drawable/Drawable;->ZERO_BOUNDS_RECT:Landroid/graphics/Rect;

    iput-object v0, p0, Landroid/graphics/drawable/Drawable;->mBounds:Landroid/graphics/Rect;

    .line 124
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/graphics/drawable/Drawable;->mCallback:Ljava/lang/ref/WeakReference;

    .line 125
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/graphics/drawable/Drawable;->mVisible:Z

    .line 940
    return-void
.end method

.method public static createFromPath(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    .registers 7
    .parameter "pathName"

    .prologue
    const/4 v0, 0x0

    .line 890
    if-nez p0, :cond_4

    .line 899
    :cond_3
    :goto_3
    return-object v0

    .line 894
    :cond_4
    invoke-static {p0}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 895
    .local v1, bm:Landroid/graphics/Bitmap;
    if-eqz v1, :cond_3

    move-object v2, v0

    move-object v3, v0

    move-object v4, v0

    move-object v5, p0

    .line 896
    invoke-static/range {v0 .. v5}, Landroid/graphics/drawable/Drawable;->drawableFromBitmap(Landroid/content/res/Resources;Landroid/graphics/Bitmap;[BLandroid/graphics/Rect;Landroid/graphics/Rect;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_3
.end method

.method public static createFromResourceStream(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    .registers 5
    .parameter "res"
    .parameter "value"
    .parameter "is"
    .parameter "srcName"

    .prologue
    .line 750
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, p3, v0}, Landroid/graphics/drawable/Drawable;->createFromResourceStream(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public static createFromResourceStream(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/drawable/Drawable;
    .registers 14
    .parameter "res"
    .parameter "value"
    .parameter "is"
    .parameter "srcName"
    .parameter "opts"

    .prologue
    const/4 v0, 0x0

    .line 760
    if-nez p2, :cond_4

    .line 796
    :cond_3
    :goto_3
    return-object v0

    .line 770
    :cond_4
    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    .line 779
    .local v3, pad:Landroid/graphics/Rect;
    if-nez p4, :cond_10

    new-instance p4, Landroid/graphics/BitmapFactory$Options;

    .end local p4
    invoke-direct {p4}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 780
    .restart local p4
    :cond_10
    sget v5, Landroid/util/DisplayMetrics;->DENSITY_DEVICE:I

    iput v5, p4, Landroid/graphics/BitmapFactory$Options;->inScreenDensity:I

    .line 781
    invoke-static {p0, p1, p2, v3, p4}, Landroid/graphics/BitmapFactory;->decodeResourceStream(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 782
    .local v1, bm:Landroid/graphics/Bitmap;
    if-eqz v1, :cond_3

    .line 783
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getNinePatchChunk()[B

    move-result-object v2

    .line 784
    .local v2, np:[B
    if-eqz v2, :cond_26

    invoke-static {v2}, Landroid/graphics/NinePatch;->isNinePatchChunk([B)Z

    move-result v0

    if-nez v0, :cond_28

    .line 785
    :cond_26
    const/4 v2, 0x0

    .line 786
    const/4 v3, 0x0

    .line 788
    :cond_28
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getLayoutBounds()[I

    move-result-object v6

    .line 789
    .local v6, layoutBounds:[I
    const/4 v4, 0x0

    .line 790
    .local v4, layoutBoundsRect:Landroid/graphics/Rect;
    if-eqz v6, :cond_40

    .line 791
    new-instance v4, Landroid/graphics/Rect;

    .end local v4           #layoutBoundsRect:Landroid/graphics/Rect;
    const/4 v0, 0x0

    aget v0, v6, v0

    const/4 v5, 0x1

    aget v5, v6, v5

    const/4 v7, 0x2

    aget v7, v6, v7

    const/4 v8, 0x3

    aget v8, v6, v8

    invoke-direct {v4, v0, v5, v7, v8}, Landroid/graphics/Rect;-><init>(IIII)V

    .restart local v4       #layoutBoundsRect:Landroid/graphics/Rect;
    :cond_40
    move-object v0, p0

    move-object v5, p3

    .line 794
    invoke-static/range {v0 .. v5}, Landroid/graphics/drawable/Drawable;->drawableFromBitmap(Landroid/content/res/Resources;Landroid/graphics/Bitmap;[BLandroid/graphics/Rect;Landroid/graphics/Rect;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_3
.end method

.method public static createFromStream(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    .registers 3
    .parameter "is"
    .parameter "srcName"

    .prologue
    const/4 v0, 0x0

    .line 741
    invoke-static {v0, v0, p0, p1, v0}, Landroid/graphics/drawable/Drawable;->createFromResourceStream(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public static createFromXml(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)Landroid/graphics/drawable/Drawable;
    .registers 8
    .parameter "r"
    .parameter "parser"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x2

    .line 806
    invoke-static {p1}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    move-result-object v0

    .line 810
    .local v0, attrs:Landroid/util/AttributeSet;
    :cond_5
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v2

    .local v2, type:I
    if-eq v2, v4, :cond_e

    const/4 v3, 0x1

    if-ne v2, v3, :cond_5

    .line 814
    :cond_e
    if-eq v2, v4, :cond_18

    .line 815
    new-instance v3, Lorg/xmlpull/v1/XmlPullParserException;

    const-string v4, "No start tag found"

    invoke-direct {v3, v4}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 818
    :cond_18
    invoke-static {p0, p1, v0}, Landroid/graphics/drawable/Drawable;->createFromXmlInner(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 820
    .local v1, drawable:Landroid/graphics/drawable/Drawable;
    if-nez v1, :cond_3b

    .line 821
    new-instance v3, Ljava/lang/RuntimeException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unknown initial tag: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 824
    :cond_3b
    return-object v1
.end method

.method public static createFromXmlInner(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)Landroid/graphics/drawable/Drawable;
    .registers 8
    .parameter "r"
    .parameter "parser"
    .parameter "attrs"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 836
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 838
    .local v1, name:Ljava/lang/String;
    const-string/jumbo v2, "selector"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_16

    .line 839
    new-instance v0, Landroid/graphics/drawable/StateListDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/StateListDrawable;-><init>()V

    .line 881
    .local v0, drawable:Landroid/graphics/drawable/Drawable;
    :cond_12
    :goto_12
    invoke-virtual {v0, p0, p1, p2}, Landroid/graphics/drawable/Drawable;->inflate(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)V

    .line 882
    return-object v0

    .line 840
    .end local v0           #drawable:Landroid/graphics/drawable/Drawable;
    :cond_16
    const-string/jumbo v2, "level-list"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_25

    .line 841
    new-instance v0, Landroid/graphics/drawable/LevelListDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/LevelListDrawable;-><init>()V

    .restart local v0       #drawable:Landroid/graphics/drawable/Drawable;
    goto :goto_12

    .line 846
    .end local v0           #drawable:Landroid/graphics/drawable/Drawable;
    :cond_25
    const-string v2, "layer-list"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_33

    .line 847
    new-instance v0, Landroid/graphics/drawable/LayerDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/LayerDrawable;-><init>()V

    .restart local v0       #drawable:Landroid/graphics/drawable/Drawable;
    goto :goto_12

    .line 848
    .end local v0           #drawable:Landroid/graphics/drawable/Drawable;
    :cond_33
    const-string/jumbo v2, "transition"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_42

    .line 849
    new-instance v0, Landroid/graphics/drawable/TransitionDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/TransitionDrawable;-><init>()V

    .restart local v0       #drawable:Landroid/graphics/drawable/Drawable;
    goto :goto_12

    .line 850
    .end local v0           #drawable:Landroid/graphics/drawable/Drawable;
    :cond_42
    const-string v2, "color"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_50

    .line 851
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/ColorDrawable;-><init>()V

    .restart local v0       #drawable:Landroid/graphics/drawable/Drawable;
    goto :goto_12

    .line 852
    .end local v0           #drawable:Landroid/graphics/drawable/Drawable;
    :cond_50
    const-string/jumbo v2, "shape"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5f

    .line 853
    new-instance v0, Landroid/graphics/drawable/GradientDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/GradientDrawable;-><init>()V

    .restart local v0       #drawable:Landroid/graphics/drawable/Drawable;
    goto :goto_12

    .line 854
    .end local v0           #drawable:Landroid/graphics/drawable/Drawable;
    :cond_5f
    const-string/jumbo v2, "scale"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6e

    .line 855
    new-instance v0, Landroid/graphics/drawable/ScaleDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/ScaleDrawable;-><init>()V

    .restart local v0       #drawable:Landroid/graphics/drawable/Drawable;
    goto :goto_12

    .line 856
    .end local v0           #drawable:Landroid/graphics/drawable/Drawable;
    :cond_6e
    const-string v2, "clip"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7c

    .line 857
    new-instance v0, Landroid/graphics/drawable/ClipDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/ClipDrawable;-><init>()V

    .restart local v0       #drawable:Landroid/graphics/drawable/Drawable;
    goto :goto_12

    .line 858
    .end local v0           #drawable:Landroid/graphics/drawable/Drawable;
    :cond_7c
    const-string/jumbo v2, "rotate"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8b

    .line 859
    new-instance v0, Landroid/graphics/drawable/RotateDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/RotateDrawable;-><init>()V

    .restart local v0       #drawable:Landroid/graphics/drawable/Drawable;
    goto :goto_12

    .line 860
    .end local v0           #drawable:Landroid/graphics/drawable/Drawable;
    :cond_8b
    const-string v2, "animated-rotate"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9a

    .line 861
    new-instance v0, Landroid/graphics/drawable/AnimatedRotateDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/AnimatedRotateDrawable;-><init>()V

    .restart local v0       #drawable:Landroid/graphics/drawable/Drawable;
    goto/16 :goto_12

    .line 862
    .end local v0           #drawable:Landroid/graphics/drawable/Drawable;
    :cond_9a
    const-string v2, "animation-list"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a9

    .line 863
    new-instance v0, Landroid/graphics/drawable/AnimationDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/AnimationDrawable;-><init>()V

    .restart local v0       #drawable:Landroid/graphics/drawable/Drawable;
    goto/16 :goto_12

    .line 864
    .end local v0           #drawable:Landroid/graphics/drawable/Drawable;
    :cond_a9
    const-string v2, "inset"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_b8

    .line 865
    new-instance v0, Landroid/graphics/drawable/InsetDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/InsetDrawable;-><init>()V

    .restart local v0       #drawable:Landroid/graphics/drawable/Drawable;
    goto/16 :goto_12

    .line 866
    .end local v0           #drawable:Landroid/graphics/drawable/Drawable;
    :cond_b8
    const-string v2, "bitmap"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_d3

    .line 867
    new-instance v0, Landroid/graphics/drawable/BitmapDrawable;

    invoke-direct {v0, p0}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;)V

    .line 868
    .restart local v0       #drawable:Landroid/graphics/drawable/Drawable;
    if-eqz p0, :cond_12

    move-object v2, v0

    .line 869
    check-cast v2, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/graphics/drawable/BitmapDrawable;->setTargetDensity(Landroid/util/DisplayMetrics;)V

    goto/16 :goto_12

    .line 871
    .end local v0           #drawable:Landroid/graphics/drawable/Drawable;
    :cond_d3
    const-string/jumbo v2, "nine-patch"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_ef

    .line 872
    new-instance v0, Landroid/graphics/drawable/NinePatchDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/NinePatchDrawable;-><init>()V

    .line 873
    .restart local v0       #drawable:Landroid/graphics/drawable/Drawable;
    if-eqz p0, :cond_12

    move-object v2, v0

    .line 874
    check-cast v2, Landroid/graphics/drawable/NinePatchDrawable;

    invoke-virtual {p0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/graphics/drawable/NinePatchDrawable;->setTargetDensity(Landroid/util/DisplayMetrics;)V

    goto/16 :goto_12

    .line 877
    .end local v0           #drawable:Landroid/graphics/drawable/Drawable;
    :cond_ef
    new-instance v2, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": invalid drawable tag "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method private static drawableFromBitmap(Landroid/content/res/Resources;Landroid/graphics/Bitmap;[BLandroid/graphics/Rect;Landroid/graphics/Rect;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    .registers 13
    .parameter "res"
    .parameter "bm"
    .parameter "np"
    .parameter "pad"
    .parameter "layoutBounds"
    .parameter "srcName"

    .prologue
    .line 979
    if-eqz p2, :cond_e

    .line 980
    new-instance v0, Landroid/graphics/drawable/NinePatchDrawable;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Landroid/graphics/drawable/NinePatchDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;[BLandroid/graphics/Rect;Landroid/graphics/Rect;Ljava/lang/String;)V

    .line 983
    :goto_d
    return-object v0

    :cond_e
    new-instance v0, Landroid/graphics/drawable/BitmapDrawable;

    invoke-direct {v0, p0, p1}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    goto :goto_d
.end method

.method public static resolveOpacity(II)I
    .registers 4
    .parameter "op1"
    .parameter "op2"

    .prologue
    const/4 v0, -0x2

    const/4 v1, -0x3

    .line 597
    if-ne p0, p1, :cond_5

    .line 609
    .end local p0
    :goto_4
    return p0

    .line 600
    .restart local p0
    :cond_5
    if-eqz p0, :cond_9

    if-nez p1, :cond_b

    .line 601
    :cond_9
    const/4 p0, 0x0

    goto :goto_4

    .line 603
    :cond_b
    if-eq p0, v1, :cond_f

    if-ne p1, v1, :cond_11

    :cond_f
    move p0, v1

    .line 604
    goto :goto_4

    .line 606
    :cond_11
    if-eq p0, v0, :cond_15

    if-ne p1, v0, :cond_17

    :cond_15
    move p0, v0

    .line 607
    goto :goto_4

    .line 609
    :cond_17
    const/4 p0, -0x1

    goto :goto_4
.end method


# virtual methods
.method public clearColorFilter()V
    .registers 2

    .prologue
    .line 420
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 421
    return-void
.end method

.method public final copyBounds()Landroid/graphics/Rect;
    .registers 3

    .prologue
    .line 182
    new-instance v0, Landroid/graphics/Rect;

    iget-object v1, p0, Landroid/graphics/drawable/Drawable;->mBounds:Landroid/graphics/Rect;

    invoke-direct {v0, v1}, Landroid/graphics/Rect;-><init>(Landroid/graphics/Rect;)V

    return-object v0
.end method

.method public final copyBounds(Landroid/graphics/Rect;)V
    .registers 3
    .parameter "bounds"

    .prologue
    .line 170
    iget-object v0, p0, Landroid/graphics/drawable/Drawable;->mBounds:Landroid/graphics/Rect;

    invoke-virtual {p1, v0}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 171
    return-void
.end method

.method public abstract draw(Landroid/graphics/Canvas;)V
.end method

.method public final getBounds()Landroid/graphics/Rect;
    .registers 3

    .prologue
    .line 201
    iget-object v0, p0, Landroid/graphics/drawable/Drawable;->mBounds:Landroid/graphics/Rect;

    sget-object v1, Landroid/graphics/drawable/Drawable;->ZERO_BOUNDS_RECT:Landroid/graphics/Rect;

    if-ne v0, v1, :cond_d

    .line 202
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/graphics/drawable/Drawable;->mBounds:Landroid/graphics/Rect;

    .line 205
    :cond_d
    iget-object v0, p0, Landroid/graphics/drawable/Drawable;->mBounds:Landroid/graphics/Rect;

    return-object v0
.end method

.method public getCallback()Landroid/graphics/drawable/Drawable$Callback;
    .registers 2

    .prologue
    .line 332
    iget-object v0, p0, Landroid/graphics/drawable/Drawable;->mCallback:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_d

    .line 333
    iget-object v0, p0, Landroid/graphics/drawable/Drawable;->mCallback:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/Drawable$Callback;

    .line 335
    :goto_c
    return-object v0

    :cond_d
    const/4 v0, 0x0

    goto :goto_c
.end method

.method public getChangingConfigurations()I
    .registers 2

    .prologue
    .line 235
    iget v0, p0, Landroid/graphics/drawable/Drawable;->mChangingConfigurations:I

    return v0
.end method

.method public getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;
    .registers 2

    .prologue
    .line 973
    const/4 v0, 0x0

    return-object v0
.end method

.method public getCurrent()Landroid/graphics/drawable/Drawable;
    .registers 1

    .prologue
    .line 492
    return-object p0
.end method

.method public getIntrinsicHeight()I
    .registers 2

    .prologue
    .line 666
    const/4 v0, -0x1

    return v0
.end method

.method public getIntrinsicWidth()I
    .registers 2

    .prologue
    .line 658
    const/4 v0, -0x1

    return v0
.end method

.method public getLayoutInsets()Landroid/graphics/Insets;
    .registers 2

    .prologue
    .line 716
    sget-object v0, Landroid/graphics/Insets;->NONE:Landroid/graphics/Insets;

    return-object v0
.end method

.method public final getLevel()I
    .registers 2

    .prologue
    .line 525
    iget v0, p0, Landroid/graphics/drawable/Drawable;->mLevel:I

    return v0
.end method

.method public getMinimumHeight()I
    .registers 2

    .prologue
    .line 693
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    .line 694
    .local v0, intrinsicHeight:I
    if-lez v0, :cond_7

    .end local v0           #intrinsicHeight:I
    :goto_6
    return v0

    .restart local v0       #intrinsicHeight:I
    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public getMinimumWidth()I
    .registers 2

    .prologue
    .line 679
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    .line 680
    .local v0, intrinsicWidth:I
    if-lez v0, :cond_7

    .end local v0           #intrinsicWidth:I
    :goto_6
    return v0

    .restart local v0       #intrinsicWidth:I
    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public abstract getOpacity()I
.end method

.method public getPadding(Landroid/graphics/Rect;)Z
    .registers 3
    .parameter "padding"

    .prologue
    const/4 v0, 0x0

    .line 705
    invoke-virtual {p1, v0, v0, v0, v0}, Landroid/graphics/Rect;->set(IIII)V

    .line 706
    return v0
.end method

.method public getResolvedLayoutDirectionSelf()I
    .registers 3

    .prologue
    .line 392
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getCallback()Landroid/graphics/drawable/Drawable$Callback;

    move-result-object v0

    .line 393
    .local v0, callback:Landroid/graphics/drawable/Drawable$Callback;
    if-eqz v0, :cond_a

    instance-of v1, v0, Landroid/graphics/drawable/Drawable$Callback2;

    if-nez v1, :cond_c

    .line 394
    :cond_a
    const/4 v1, 0x0

    .line 396
    .end local v0           #callback:Landroid/graphics/drawable/Drawable$Callback;
    :goto_b
    return v1

    .restart local v0       #callback:Landroid/graphics/drawable/Drawable$Callback;
    :cond_c
    check-cast v0, Landroid/graphics/drawable/Drawable$Callback2;

    .end local v0           #callback:Landroid/graphics/drawable/Drawable$Callback;
    invoke-interface {v0, p0}, Landroid/graphics/drawable/Drawable$Callback2;->getResolvedLayoutDirection(Landroid/graphics/drawable/Drawable;)I

    move-result v1

    goto :goto_b
.end method

.method public getState()[I
    .registers 2

    .prologue
    .line 475
    iget-object v0, p0, Landroid/graphics/drawable/Drawable;->mStateSet:[I

    return-object v0
.end method

.method public getTransparentRegion()Landroid/graphics/Region;
    .registers 2

    .prologue
    .line 626
    const/4 v0, 0x0

    return-object v0
.end method

.method public inflate(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)V
    .registers 6
    .parameter "r"
    .parameter "parser"
    .parameter "attrs"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 908
    sget-object v1, Lcom/android/internal/R$styleable;->Drawable:[I

    invoke-virtual {p1, p3, v1}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 909
    .local v0, a:Landroid/content/res/TypedArray;
    const/4 v1, 0x0

    invoke-virtual {p0, p1, p2, v0, v1}, Landroid/graphics/drawable/Drawable;->inflateWithAttributes(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/TypedArray;I)V

    .line 910
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 911
    return-void
.end method

.method inflateWithAttributes(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/TypedArray;I)V
    .registers 6
    .parameter "r"
    .parameter "parser"
    .parameter "attrs"
    .parameter "visibleAttr"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 923
    iget-boolean v0, p0, Landroid/graphics/drawable/Drawable;->mVisible:Z

    invoke-virtual {p3, p4, v0}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    iput-boolean v0, p0, Landroid/graphics/drawable/Drawable;->mVisible:Z

    .line 924
    return-void
.end method

.method public invalidateSelf()V
    .registers 2

    .prologue
    .line 348
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getCallback()Landroid/graphics/drawable/Drawable$Callback;

    move-result-object v0

    .line 349
    .local v0, callback:Landroid/graphics/drawable/Drawable$Callback;
    if-eqz v0, :cond_9

    .line 350
    invoke-interface {v0, p0}, Landroid/graphics/drawable/Drawable$Callback;->invalidateDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 352
    :cond_9
    return-void
.end method

.method public isStateful()Z
    .registers 2

    .prologue
    .line 434
    const/4 v0, 0x0

    return v0
.end method

.method public final isVisible()Z
    .registers 2

    .prologue
    .line 552
    iget-boolean v0, p0, Landroid/graphics/drawable/Drawable;->mVisible:Z

    return v0
.end method

.method public jumpToCurrentState()V
    .registers 1

    .prologue
    .line 483
    return-void
.end method

.method public mutate()Landroid/graphics/drawable/Drawable;
    .registers 1

    .prologue
    .line 734
    return-object p0
.end method

.method protected onBoundsChange(Landroid/graphics/Rect;)V
    .registers 2
    .parameter "bounds"

    .prologue
    .line 651
    return-void
.end method

.method protected onLevelChange(I)Z
    .registers 3
    .parameter "level"

    .prologue
    .line 646
    const/4 v0, 0x0

    return v0
.end method

.method protected onStateChange([I)Z
    .registers 3
    .parameter "state"

    .prologue
    .line 638
    const/4 v0, 0x0

    return v0
.end method

.method public scheduleSelf(Ljava/lang/Runnable;J)V
    .registers 5
    .parameter "what"
    .parameter "when"

    .prologue
    .line 365
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getCallback()Landroid/graphics/drawable/Drawable$Callback;

    move-result-object v0

    .line 366
    .local v0, callback:Landroid/graphics/drawable/Drawable$Callback;
    if-eqz v0, :cond_9

    .line 367
    invoke-interface {v0, p0, p1, p2, p3}, Landroid/graphics/drawable/Drawable$Callback;->scheduleDrawable(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;J)V

    .line 369
    :cond_9
    return-void
.end method

.method public abstract setAlpha(I)V
.end method

.method public setBounds(IIII)V
    .registers 7
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    .line 140
    iget-object v0, p0, Landroid/graphics/drawable/Drawable;->mBounds:Landroid/graphics/Rect;

    .line 142
    .local v0, oldBounds:Landroid/graphics/Rect;
    sget-object v1, Landroid/graphics/drawable/Drawable;->ZERO_BOUNDS_RECT:Landroid/graphics/Rect;

    if-ne v0, v1, :cond_d

    .line 143
    new-instance v0, Landroid/graphics/Rect;

    .end local v0           #oldBounds:Landroid/graphics/Rect;
    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/graphics/drawable/Drawable;->mBounds:Landroid/graphics/Rect;

    .line 146
    .restart local v0       #oldBounds:Landroid/graphics/Rect;
    :cond_d
    iget v1, v0, Landroid/graphics/Rect;->left:I

    if-ne v1, p1, :cond_1d

    iget v1, v0, Landroid/graphics/Rect;->top:I

    if-ne v1, p2, :cond_1d

    iget v1, v0, Landroid/graphics/Rect;->right:I

    if-ne v1, p3, :cond_1d

    iget v1, v0, Landroid/graphics/Rect;->bottom:I

    if-eq v1, p4, :cond_27

    .line 148
    :cond_1d
    iget-object v1, p0, Landroid/graphics/drawable/Drawable;->mBounds:Landroid/graphics/Rect;

    invoke-virtual {v1, p1, p2, p3, p4}, Landroid/graphics/Rect;->set(IIII)V

    .line 149
    iget-object v1, p0, Landroid/graphics/drawable/Drawable;->mBounds:Landroid/graphics/Rect;

    invoke-virtual {p0, v1}, Landroid/graphics/drawable/Drawable;->onBoundsChange(Landroid/graphics/Rect;)V

    .line 151
    :cond_27
    return-void
.end method

.method public setBounds(Landroid/graphics/Rect;)V
    .registers 6
    .parameter "bounds"

    .prologue
    .line 158
    iget v0, p1, Landroid/graphics/Rect;->left:I

    iget v1, p1, Landroid/graphics/Rect;->top:I

    iget v2, p1, Landroid/graphics/Rect;->right:I

    iget v3, p1, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {p0, v0, v1, v2, v3}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 159
    return-void
.end method

.method public final setCallback(Landroid/graphics/drawable/Drawable$Callback;)V
    .registers 3
    .parameter "cb"

    .prologue
    .line 320
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Landroid/graphics/drawable/Drawable;->mCallback:Ljava/lang/ref/WeakReference;

    .line 321
    return-void
.end method

.method public setChangingConfigurations(I)V
    .registers 2
    .parameter "configs"

    .prologue
    .line 218
    iput p1, p0, Landroid/graphics/drawable/Drawable;->mChangingConfigurations:I

    .line 219
    return-void
.end method

.method public setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V
    .registers 4
    .parameter "color"
    .parameter "mode"

    .prologue
    .line 416
    new-instance v0, Landroid/graphics/PorterDuffColorFilter;

    invoke-direct {v0, p1, p2}, Landroid/graphics/PorterDuffColorFilter;-><init>(ILandroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {p0, v0}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 417
    return-void
.end method

.method public abstract setColorFilter(Landroid/graphics/ColorFilter;)V
.end method

.method public setDither(Z)V
    .registers 2
    .parameter "dither"

    .prologue
    .line 243
    return-void
.end method

.method public setFilterBitmap(Z)V
    .registers 2
    .parameter "filter"

    .prologue
    .line 251
    return-void
.end method

.method public final setLevel(I)Z
    .registers 3
    .parameter "level"

    .prologue
    .line 512
    iget v0, p0, Landroid/graphics/drawable/Drawable;->mLevel:I

    if-eq v0, p1, :cond_b

    .line 513
    iput p1, p0, Landroid/graphics/drawable/Drawable;->mLevel:I

    .line 514
    invoke-virtual {p0, p1}, Landroid/graphics/drawable/Drawable;->onLevelChange(I)Z

    move-result v0

    .line 516
    :goto_a
    return v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method public setState([I)Z
    .registers 3
    .parameter "stateSet"

    .prologue
    .line 460
    iget-object v0, p0, Landroid/graphics/drawable/Drawable;->mStateSet:[I

    invoke-static {v0, p1}, Ljava/util/Arrays;->equals([I[I)Z

    move-result v0

    if-nez v0, :cond_f

    .line 461
    iput-object p1, p0, Landroid/graphics/drawable/Drawable;->mStateSet:[I

    .line 462
    invoke-virtual {p0, p1}, Landroid/graphics/drawable/Drawable;->onStateChange([I)Z

    move-result v0

    .line 464
    :goto_e
    return v0

    :cond_f
    const/4 v0, 0x0

    goto :goto_e
.end method

.method public setVisible(ZZ)Z
    .registers 5
    .parameter "visible"
    .parameter "restart"

    .prologue
    .line 543
    iget-boolean v1, p0, Landroid/graphics/drawable/Drawable;->mVisible:Z

    if-eq v1, p1, :cond_d

    const/4 v0, 0x1

    .line 544
    .local v0, changed:Z
    :goto_5
    if-eqz v0, :cond_c

    .line 545
    iput-boolean p1, p0, Landroid/graphics/drawable/Drawable;->mVisible:Z

    .line 546
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->invalidateSelf()V

    .line 548
    :cond_c
    return v0

    .line 543
    .end local v0           #changed:Z
    :cond_d
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public unscheduleSelf(Ljava/lang/Runnable;)V
    .registers 3
    .parameter "what"

    .prologue
    .line 381
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getCallback()Landroid/graphics/drawable/Drawable$Callback;

    move-result-object v0

    .line 382
    .local v0, callback:Landroid/graphics/drawable/Drawable$Callback;
    if-eqz v0, :cond_9

    .line 383
    invoke-interface {v0, p0, p1}, Landroid/graphics/drawable/Drawable$Callback;->unscheduleDrawable(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;)V

    .line 385
    :cond_9
    return-void
.end method
