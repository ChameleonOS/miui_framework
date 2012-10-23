.class public abstract Landroid/view/LayoutInflater;
.super Ljava/lang/Object;
.source "LayoutInflater.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/LayoutInflater$BlinkLayout;,
        Landroid/view/LayoutInflater$FactoryMerger;,
        Landroid/view/LayoutInflater$Factory2;,
        Landroid/view/LayoutInflater$Factory;,
        Landroid/view/LayoutInflater$Filter;
    }
.end annotation


# static fields
.field private static final TAG_1995:Ljava/lang/String; = "blink"

.field private static final TAG_INCLUDE:Ljava/lang/String; = "include"

.field private static final TAG_MERGE:Ljava/lang/String; = "merge"

.field private static final TAG_REQUEST_FOCUS:Ljava/lang/String; = "requestFocus"

.field static final mConstructorSignature:[Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field private static final sConstructorMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/reflect/Constructor",
            "<+",
            "Landroid/view/View;",
            ">;>;"
        }
    .end annotation
.end field


# instance fields
.field private final DEBUG:Z

.field final mConstructorArgs:[Ljava/lang/Object;

.field protected final mContext:Landroid/content/Context;

.field private mFactory:Landroid/view/LayoutInflater$Factory;

.field private mFactory2:Landroid/view/LayoutInflater$Factory2;

.field private mFactorySet:Z

.field private mFilter:Landroid/view/LayoutInflater$Filter;

.field private mFilterMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private mPrivateFactory:Landroid/view/LayoutInflater$Factory2;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 80
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Class;

    const/4 v1, 0x0

    const-class v2, Landroid/content/Context;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-class v2, Landroid/util/AttributeSet;

    aput-object v2, v0, v1

    sput-object v0, Landroid/view/LayoutInflater;->mConstructorSignature:[Ljava/lang/Class;

    .line 83
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Landroid/view/LayoutInflater;->sConstructorMap:Ljava/util/HashMap;

    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 186
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 63
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/view/LayoutInflater;->DEBUG:Z

    .line 78
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Landroid/view/LayoutInflater;->mConstructorArgs:[Ljava/lang/Object;

    .line 187
    iput-object p1, p0, Landroid/view/LayoutInflater;->mContext:Landroid/content/Context;

    .line 188
    return-void
.end method

.method protected constructor <init>(Landroid/view/LayoutInflater;Landroid/content/Context;)V
    .registers 4
    .parameter "original"
    .parameter "newContext"

    .prologue
    .line 198
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 63
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/view/LayoutInflater;->DEBUG:Z

    .line 78
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Landroid/view/LayoutInflater;->mConstructorArgs:[Ljava/lang/Object;

    .line 199
    iput-object p2, p0, Landroid/view/LayoutInflater;->mContext:Landroid/content/Context;

    .line 200
    iget-object v0, p1, Landroid/view/LayoutInflater;->mFactory:Landroid/view/LayoutInflater$Factory;

    iput-object v0, p0, Landroid/view/LayoutInflater;->mFactory:Landroid/view/LayoutInflater$Factory;

    .line 201
    iget-object v0, p1, Landroid/view/LayoutInflater;->mFactory2:Landroid/view/LayoutInflater$Factory2;

    iput-object v0, p0, Landroid/view/LayoutInflater;->mFactory2:Landroid/view/LayoutInflater$Factory2;

    .line 202
    iget-object v0, p1, Landroid/view/LayoutInflater;->mPrivateFactory:Landroid/view/LayoutInflater$Factory2;

    iput-object v0, p0, Landroid/view/LayoutInflater;->mPrivateFactory:Landroid/view/LayoutInflater$Factory2;

    .line 203
    iget-object v0, p1, Landroid/view/LayoutInflater;->mFilter:Landroid/view/LayoutInflater$Filter;

    iput-object v0, p0, Landroid/view/LayoutInflater;->mFilter:Landroid/view/LayoutInflater$Filter;

    .line 204
    return-void
.end method

.method private failNotAllowed(Ljava/lang/String;Ljava/lang/String;Landroid/util/AttributeSet;)V
    .registers 7
    .parameter "name"
    .parameter "prefix"
    .parameter "attrs"

    .prologue
    .line 625
    new-instance v0, Landroid/view/InflateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p3}, Landroid/util/AttributeSet;->getPositionDescription()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ": Class not allowed to be inflated "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    if-eqz p2, :cond_28

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .end local p1
    :cond_28
    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    .registers 4
    .parameter "context"

    .prologue
    .line 210
    const-string v1, "layout_inflater"

    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    .line 212
    .local v0, LayoutInflater:Landroid/view/LayoutInflater;
    if-nez v0, :cond_12

    .line 213
    new-instance v1, Ljava/lang/AssertionError;

    const-string v2, "LayoutInflater not found."

    invoke-direct {v1, v2}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v1

    .line 215
    :cond_12
    return-object v0
.end method

.method private parseInclude(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/View;Landroid/util/AttributeSet;)V
    .registers 27
    .parameter "parser"
    .parameter "parent"
    .parameter "attrs"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 773
    move-object/from16 v0, p2

    instance-of v0, v0, Landroid/view/ViewGroup;

    move/from16 v19, v0

    if-eqz v19, :cond_17f

    .line 774
    const/16 v19, 0x0

    const-string v20, "layout"

    const/16 v21, 0x0

    move-object/from16 v0, p3

    move-object/from16 v1, v19

    move-object/from16 v2, v20

    move/from16 v3, v21

    invoke-interface {v0, v1, v2, v3}, Landroid/util/AttributeSet;->getAttributeResourceValue(Ljava/lang/String;Ljava/lang/String;I)I

    move-result v13

    .line 775
    .local v13, layout:I
    if-nez v13, :cond_57

    .line 776
    const/16 v19, 0x0

    const-string v20, "layout"

    move-object/from16 v0, p3

    move-object/from16 v1, v19

    move-object/from16 v2, v20

    invoke-interface {v0, v1, v2}, Landroid/util/AttributeSet;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 777
    .local v16, value:Ljava/lang/String;
    if-nez v16, :cond_34

    .line 778
    new-instance v19, Landroid/view/InflateException;

    const-string v20, "You must specifiy a layout in the include tag: <include layout=\"@layout/layoutID\" />"

    invoke-direct/range {v19 .. v20}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    throw v19

    .line 781
    :cond_34
    new-instance v19, Landroid/view/InflateException;

    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    const-string v21, "You must specifiy a valid layout reference. The layout ID "

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    move-object/from16 v0, v20

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, " is not valid."

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    invoke-direct/range {v19 .. v20}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    throw v19

    .line 785
    .end local v16           #value:Ljava/lang/String;
    :cond_57
    invoke-virtual/range {p0 .. p0}, Landroid/view/LayoutInflater;->getContext()Landroid/content/Context;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v13}, Landroid/content/res/Resources;->getLayout(I)Landroid/content/res/XmlResourceParser;

    move-result-object v8

    .line 789
    .local v8, childParser:Landroid/content/res/XmlResourceParser;
    :try_start_65
    invoke-static {v8}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    move-result-object v6

    .line 792
    .local v6, childAttrs:Landroid/util/AttributeSet;
    :cond_69
    invoke-interface {v8}, Landroid/content/res/XmlResourceParser;->next()I

    move-result v15

    .local v15, type:I
    const/16 v19, 0x2

    move/from16 v0, v19

    if-eq v15, v0, :cond_79

    const/16 v19, 0x1

    move/from16 v0, v19

    if-ne v15, v0, :cond_69

    .line 796
    :cond_79
    const/16 v19, 0x2

    move/from16 v0, v19

    if-eq v15, v0, :cond_a1

    .line 797
    new-instance v19, Landroid/view/InflateException;

    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v8}, Landroid/content/res/XmlResourceParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, ": No start tag found!"

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    invoke-direct/range {v19 .. v20}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    throw v19
    :try_end_9c
    .catchall {:try_start_65 .. :try_end_9c} :catchall_9c

    .line 860
    .end local v6           #childAttrs:Landroid/util/AttributeSet;
    .end local v15           #type:I
    :catchall_9c
    move-exception v19

    invoke-interface {v8}, Landroid/content/res/XmlResourceParser;->close()V

    throw v19

    .line 801
    .restart local v6       #childAttrs:Landroid/util/AttributeSet;
    .restart local v15       #type:I
    :cond_a1
    :try_start_a1
    invoke-interface {v8}, Landroid/content/res/XmlResourceParser;->getName()Ljava/lang/String;

    move-result-object v7

    .line 803
    .local v7, childName:Ljava/lang/String;
    const-string/jumbo v19, "merge"

    move-object/from16 v0, v19

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_db

    .line 805
    const/16 v19, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move/from16 v2, v19

    invoke-virtual {v0, v8, v1, v6, v2}, Landroid/view/LayoutInflater;->rInflate(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/View;Landroid/util/AttributeSet;Z)V
    :try_end_bb
    .catchall {:try_start_a1 .. :try_end_bb} :catchall_9c

    .line 860
    :goto_bb
    invoke-interface {v8}, Landroid/content/res/XmlResourceParser;->close()V

    .line 867
    invoke-interface/range {p1 .. p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v9

    .line 869
    .local v9, currentDepth:I
    :cond_c2
    invoke-interface/range {p1 .. p1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v15

    const/16 v19, 0x3

    move/from16 v0, v19

    if-ne v15, v0, :cond_d4

    invoke-interface/range {p1 .. p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v19

    move/from16 v0, v19

    if-le v0, v9, :cond_da

    :cond_d4
    const/16 v19, 0x1

    move/from16 v0, v19

    if-ne v15, v0, :cond_c2

    .line 872
    :cond_da
    return-void

    .line 807
    .end local v9           #currentDepth:I
    :cond_db
    :try_start_db
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v7, v6}, Landroid/view/LayoutInflater;->createViewFromTag(Landroid/view/View;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v17

    .line 808
    .local v17, view:Landroid/view/View;
    move-object/from16 v0, p2

    check-cast v0, Landroid/view/ViewGroup;

    move-object v11, v0
    :try_end_e8
    .catchall {:try_start_db .. :try_end_e8} :catchall_9c

    .line 818
    .local v11, group:Landroid/view/ViewGroup;
    const/4 v14, 0x0

    .line 820
    .local v14, params:Landroid/view/ViewGroup$LayoutParams;
    :try_start_e9
    move-object/from16 v0, p3

    invoke-virtual {v11, v0}, Landroid/view/ViewGroup;->generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    :try_end_ee
    .catchall {:try_start_e9 .. :try_end_ee} :catchall_158
    .catch Ljava/lang/RuntimeException; {:try_start_e9 .. :try_end_ee} :catch_14b

    move-result-object v14

    .line 824
    if-eqz v14, :cond_f6

    .line 825
    :try_start_f1
    move-object/from16 v0, v17

    invoke-virtual {v0, v14}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 830
    :cond_f6
    :goto_f6
    const/16 v19, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move/from16 v2, v19

    invoke-virtual {v0, v8, v1, v6, v2}, Landroid/view/LayoutInflater;->rInflate(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/View;Landroid/util/AttributeSet;Z)V

    .line 834
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/LayoutInflater;->mContext:Landroid/content/Context;

    move-object/from16 v19, v0

    sget-object v20, Lcom/android/internal/R$styleable;->View:[I

    const/16 v21, 0x0

    const/16 v22, 0x0

    move-object/from16 v0, v19

    move-object/from16 v1, p3

    move-object/from16 v2, v20

    move/from16 v3, v21

    move/from16 v4, v22

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v5

    .line 836
    .local v5, a:Landroid/content/res/TypedArray;
    const/16 v19, 0x8

    const/16 v20, -0x1

    move/from16 v0, v19

    move/from16 v1, v20

    invoke-virtual {v5, v0, v1}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v12

    .line 838
    .local v12, id:I
    const/16 v19, 0x14

    const/16 v20, -0x1

    move/from16 v0, v19

    move/from16 v1, v20

    invoke-virtual {v5, v0, v1}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v18

    .line 839
    .local v18, visibility:I
    invoke-virtual {v5}, Landroid/content/res/TypedArray;->recycle()V

    .line 841
    const/16 v19, -0x1

    move/from16 v0, v19

    if-eq v12, v0, :cond_141

    .line 842
    move-object/from16 v0, v17

    invoke-virtual {v0, v12}, Landroid/view/View;->setId(I)V

    .line 845
    :cond_141
    packed-switch v18, :pswitch_data_188

    .line 857
    :goto_144
    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    :try_end_149
    .catchall {:try_start_f1 .. :try_end_149} :catchall_9c

    goto/16 :goto_bb

    .line 821
    .end local v5           #a:Landroid/content/res/TypedArray;
    .end local v12           #id:I
    .end local v18           #visibility:I
    :catch_14b
    move-exception v10

    .line 822
    .local v10, e:Ljava/lang/RuntimeException;
    :try_start_14c
    invoke-virtual {v11, v6}, Landroid/view/ViewGroup;->generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    :try_end_14f
    .catchall {:try_start_14c .. :try_end_14f} :catchall_158

    move-result-object v14

    .line 824
    if-eqz v14, :cond_f6

    .line 825
    :try_start_152
    move-object/from16 v0, v17

    invoke-virtual {v0, v14}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_f6

    .line 824
    .end local v10           #e:Ljava/lang/RuntimeException;
    :catchall_158
    move-exception v19

    if-eqz v14, :cond_160

    .line 825
    move-object/from16 v0, v17

    invoke-virtual {v0, v14}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 824
    :cond_160
    throw v19

    .line 847
    .restart local v5       #a:Landroid/content/res/TypedArray;
    .restart local v12       #id:I
    .restart local v18       #visibility:I
    :pswitch_161
    const/16 v19, 0x0

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_144

    .line 850
    :pswitch_16b
    const/16 v19, 0x4

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_144

    .line 853
    :pswitch_175
    const/16 v19, 0x8

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V
    :try_end_17e
    .catchall {:try_start_152 .. :try_end_17e} :catchall_9c

    goto :goto_144

    .line 864
    .end local v5           #a:Landroid/content/res/TypedArray;
    .end local v6           #childAttrs:Landroid/util/AttributeSet;
    .end local v7           #childName:Ljava/lang/String;
    .end local v8           #childParser:Landroid/content/res/XmlResourceParser;
    .end local v11           #group:Landroid/view/ViewGroup;
    .end local v12           #id:I
    .end local v13           #layout:I
    .end local v14           #params:Landroid/view/ViewGroup$LayoutParams;
    .end local v15           #type:I
    .end local v17           #view:Landroid/view/View;
    .end local v18           #visibility:I
    :cond_17f
    new-instance v19, Landroid/view/InflateException;

    const-string v20, "<include /> can only be used inside of a ViewGroup"

    invoke-direct/range {v19 .. v20}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    throw v19

    .line 845
    nop

    :pswitch_data_188
    .packed-switch 0x0
        :pswitch_161
        :pswitch_16b
        :pswitch_175
    .end packed-switch
.end method

.method private parseRequestFocus(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/View;)V
    .registers 6
    .parameter "parser"
    .parameter "parent"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 760
    invoke-virtual {p2}, Landroid/view/View;->requestFocus()Z

    .line 761
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v0

    .line 763
    .local v0, currentDepth:I
    :cond_7
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    .local v1, type:I
    const/4 v2, 0x3

    if-ne v1, v2, :cond_14

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v2

    if-le v2, v0, :cond_17

    :cond_14
    const/4 v2, 0x1

    if-ne v1, v2, :cond_7

    .line 766
    :cond_17
    return-void
.end method


# virtual methods
.method public abstract cloneInContext(Landroid/content/Context;)Landroid/view/LayoutInflater;
.end method

.method public final createView(Ljava/lang/String;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;
    .registers 16
    .parameter "name"
    .parameter "prefix"
    .parameter "attrs"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;,
            Landroid/view/InflateException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 546
    sget-object v10, Landroid/view/LayoutInflater;->sConstructorMap:Ljava/util/HashMap;

    invoke-virtual {v10, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/reflect/Constructor;

    .line 547
    .local v5, constructor:Ljava/lang/reflect/Constructor;,"Ljava/lang/reflect/Constructor<+Landroid/view/View;>;"
    const/4 v4, 0x0

    .line 550
    .local v4, clazz:Ljava/lang/Class;,"Ljava/lang/Class<+Landroid/view/View;>;"
    if-nez v5, :cond_64

    .line 552
    :try_start_c
    iget-object v10, p0, Landroid/view/LayoutInflater;->mContext:Landroid/content/Context;

    invoke-virtual {v10}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v11

    if-eqz p2, :cond_62

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v10, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    :goto_25
    invoke-virtual {v11, v10}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v10

    const-class v11, Landroid/view/View;

    invoke-virtual {v10, v11}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v4

    .line 555
    iget-object v10, p0, Landroid/view/LayoutInflater;->mFilter:Landroid/view/LayoutInflater$Filter;

    if-eqz v10, :cond_40

    if-eqz v4, :cond_40

    .line 556
    iget-object v10, p0, Landroid/view/LayoutInflater;->mFilter:Landroid/view/LayoutInflater$Filter;

    invoke-interface {v10, v4}, Landroid/view/LayoutInflater$Filter;->onLoadClass(Ljava/lang/Class;)Z

    move-result v1

    .line 557
    .local v1, allowed:Z
    if-nez v1, :cond_40

    .line 558
    invoke-direct {p0, p1, p2, p3}, Landroid/view/LayoutInflater;->failNotAllowed(Ljava/lang/String;Ljava/lang/String;Landroid/util/AttributeSet;)V

    .line 561
    .end local v1           #allowed:Z
    :cond_40
    sget-object v10, Landroid/view/LayoutInflater;->mConstructorSignature:[Ljava/lang/Class;

    invoke-virtual {v4, v10}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v5

    .line 562
    sget-object v10, Landroid/view/LayoutInflater;->sConstructorMap:Ljava/util/HashMap;

    invoke-virtual {v10, p1, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 584
    :cond_4b
    :goto_4b
    iget-object v3, p0, Landroid/view/LayoutInflater;->mConstructorArgs:[Ljava/lang/Object;

    .line 585
    .local v3, args:[Ljava/lang/Object;
    const/4 v10, 0x1

    aput-object p3, v3, v10

    .line 587
    invoke-virtual {v5, v3}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/view/View;

    .line 588
    .local v8, view:Landroid/view/View;
    instance-of v10, v8, Landroid/view/ViewStub;

    if-eqz v10, :cond_61

    .line 590
    move-object v0, v8

    check-cast v0, Landroid/view/ViewStub;

    move-object v9, v0

    .line 591
    .local v9, viewStub:Landroid/view/ViewStub;
    invoke-virtual {v9, p0}, Landroid/view/ViewStub;->setLayoutInflater(Landroid/view/LayoutInflater;)V

    .line 593
    .end local v9           #viewStub:Landroid/view/ViewStub;
    :cond_61
    return-object v8

    .end local v3           #args:[Ljava/lang/Object;
    .end local v8           #view:Landroid/view/View;
    :cond_62
    move-object v10, p1

    .line 552
    goto :goto_25

    .line 565
    :cond_64
    iget-object v10, p0, Landroid/view/LayoutInflater;->mFilter:Landroid/view/LayoutInflater$Filter;

    if-eqz v10, :cond_4b

    .line 567
    iget-object v10, p0, Landroid/view/LayoutInflater;->mFilterMap:Ljava/util/HashMap;

    invoke-virtual {v10, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    .line 568
    .local v2, allowedState:Ljava/lang/Boolean;
    if-nez v2, :cond_ea

    .line 570
    iget-object v10, p0, Landroid/view/LayoutInflater;->mContext:Landroid/content/Context;

    invoke-virtual {v10}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v11

    if-eqz p2, :cond_e6

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v10, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    :goto_8b
    invoke-virtual {v11, v10}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v10

    const-class v11, Landroid/view/View;

    invoke-virtual {v10, v11}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v4

    .line 573
    if-eqz v4, :cond_e8

    iget-object v10, p0, Landroid/view/LayoutInflater;->mFilter:Landroid/view/LayoutInflater$Filter;

    invoke-interface {v10, v4}, Landroid/view/LayoutInflater$Filter;->onLoadClass(Ljava/lang/Class;)Z

    move-result v10

    if-eqz v10, :cond_e8

    .line 574
    .restart local v1       #allowed:Z
    :goto_9f
    iget-object v10, p0, Landroid/view/LayoutInflater;->mFilterMap:Ljava/util/HashMap;

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v11

    invoke-virtual {v10, p1, v11}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 575
    if-nez v1, :cond_4b

    .line 576
    invoke-direct {p0, p1, p2, p3}, Landroid/view/LayoutInflater;->failNotAllowed(Ljava/lang/String;Ljava/lang/String;Landroid/util/AttributeSet;)V
    :try_end_ad
    .catch Ljava/lang/NoSuchMethodException; {:try_start_c .. :try_end_ad} :catch_ae
    .catch Ljava/lang/ClassCastException; {:try_start_c .. :try_end_ad} :catch_f7
    .catch Ljava/lang/ClassNotFoundException; {:try_start_c .. :try_end_ad} :catch_12f
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_ad} :catch_131

    goto :goto_4b

    .line 595
    .end local v1           #allowed:Z
    .end local v2           #allowedState:Ljava/lang/Boolean;
    :catch_ae
    move-exception v6

    .line 596
    .local v6, e:Ljava/lang/NoSuchMethodException;
    new-instance v7, Landroid/view/InflateException;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p3}, Landroid/util/AttributeSet;->getPositionDescription()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ": Error inflating class "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    if-eqz p2, :cond_d7

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v11, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .end local p1
    :cond_d7
    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v7, v10}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    .line 599
    .local v7, ie:Landroid/view/InflateException;
    invoke-virtual {v7, v6}, Landroid/view/InflateException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    .line 600
    throw v7

    .end local v6           #e:Ljava/lang/NoSuchMethodException;
    .end local v7           #ie:Landroid/view/InflateException;
    .restart local v2       #allowedState:Ljava/lang/Boolean;
    .restart local p1
    :cond_e6
    move-object v10, p1

    .line 570
    goto :goto_8b

    .line 573
    :cond_e8
    const/4 v1, 0x0

    goto :goto_9f

    .line 578
    :cond_ea
    :try_start_ea
    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v2, v10}, Ljava/lang/Boolean;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_4b

    .line 579
    invoke-direct {p0, p1, p2, p3}, Landroid/view/LayoutInflater;->failNotAllowed(Ljava/lang/String;Ljava/lang/String;Landroid/util/AttributeSet;)V
    :try_end_f5
    .catch Ljava/lang/NoSuchMethodException; {:try_start_ea .. :try_end_f5} :catch_ae
    .catch Ljava/lang/ClassCastException; {:try_start_ea .. :try_end_f5} :catch_f7
    .catch Ljava/lang/ClassNotFoundException; {:try_start_ea .. :try_end_f5} :catch_12f
    .catch Ljava/lang/Exception; {:try_start_ea .. :try_end_f5} :catch_131

    goto/16 :goto_4b

    .line 602
    .end local v2           #allowedState:Ljava/lang/Boolean;
    :catch_f7
    move-exception v6

    .line 604
    .local v6, e:Ljava/lang/ClassCastException;
    new-instance v7, Landroid/view/InflateException;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p3}, Landroid/util/AttributeSet;->getPositionDescription()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ": Class is not a View "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    if-eqz p2, :cond_120

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v11, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .end local p1
    :cond_120
    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v7, v10}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    .line 607
    .restart local v7       #ie:Landroid/view/InflateException;
    invoke-virtual {v7, v6}, Landroid/view/InflateException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    .line 608
    throw v7

    .line 609
    .end local v6           #e:Ljava/lang/ClassCastException;
    .end local v7           #ie:Landroid/view/InflateException;
    .restart local p1
    :catch_12f
    move-exception v6

    .line 611
    .local v6, e:Ljava/lang/ClassNotFoundException;
    throw v6

    .line 612
    .end local v6           #e:Ljava/lang/ClassNotFoundException;
    :catch_131
    move-exception v6

    .line 613
    .local v6, e:Ljava/lang/Exception;
    new-instance v7, Landroid/view/InflateException;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p3}, Landroid/util/AttributeSet;->getPositionDescription()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ": Error inflating class "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    if-nez v4, :cond_15a

    const-string v10, "<unknown>"

    :goto_14b
    invoke-virtual {v11, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v7, v10}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    .line 616
    .restart local v7       #ie:Landroid/view/InflateException;
    invoke-virtual {v7, v6}, Landroid/view/InflateException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    .line 617
    throw v7

    .line 613
    .end local v7           #ie:Landroid/view/InflateException;
    :cond_15a
    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v10

    goto :goto_14b
.end method

.method createViewFromTag(Landroid/view/View;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;
    .registers 9
    .parameter "parent"
    .parameter "name"
    .parameter "attrs"

    .prologue
    const/4 v4, 0x0

    .line 667
    const-string/jumbo v3, "view"

    invoke-virtual {p2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_10

    .line 668
    const-string v3, "class"

    invoke-interface {p3, v4, v3}, Landroid/util/AttributeSet;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .line 675
    :cond_10
    :try_start_10
    iget-object v3, p0, Landroid/view/LayoutInflater;->mFactory2:Landroid/view/LayoutInflater$Factory2;

    if-eqz v3, :cond_3a

    iget-object v3, p0, Landroid/view/LayoutInflater;->mFactory2:Landroid/view/LayoutInflater$Factory2;

    iget-object v4, p0, Landroid/view/LayoutInflater;->mContext:Landroid/content/Context;

    invoke-interface {v3, p1, p2, v4, p3}, Landroid/view/LayoutInflater$Factory2;->onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v2

    .line 679
    .local v2, view:Landroid/view/View;
    :goto_1c
    if-nez v2, :cond_2a

    iget-object v3, p0, Landroid/view/LayoutInflater;->mPrivateFactory:Landroid/view/LayoutInflater$Factory2;

    if-eqz v3, :cond_2a

    .line 680
    iget-object v3, p0, Landroid/view/LayoutInflater;->mPrivateFactory:Landroid/view/LayoutInflater$Factory2;

    iget-object v4, p0, Landroid/view/LayoutInflater;->mContext:Landroid/content/Context;

    invoke-interface {v3, p1, p2, v4, p3}, Landroid/view/LayoutInflater$Factory2;->onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v2

    .line 683
    :cond_2a
    if-nez v2, :cond_39

    .line 684
    const/4 v3, -0x1

    const/16 v4, 0x2e

    invoke-virtual {p2, v4}, Ljava/lang/String;->indexOf(I)I

    move-result v4

    if-ne v3, v4, :cond_49

    .line 685
    invoke-virtual {p0, p1, p2, p3}, Landroid/view/LayoutInflater;->onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v2

    .line 692
    :cond_39
    :goto_39
    return-object v2

    .line 676
    .end local v2           #view:Landroid/view/View;
    :cond_3a
    iget-object v3, p0, Landroid/view/LayoutInflater;->mFactory:Landroid/view/LayoutInflater$Factory;

    if-eqz v3, :cond_47

    iget-object v3, p0, Landroid/view/LayoutInflater;->mFactory:Landroid/view/LayoutInflater$Factory;

    iget-object v4, p0, Landroid/view/LayoutInflater;->mContext:Landroid/content/Context;

    invoke-interface {v3, p2, v4, p3}, Landroid/view/LayoutInflater$Factory;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v2

    .restart local v2       #view:Landroid/view/View;
    goto :goto_1c

    .line 677
    .end local v2           #view:Landroid/view/View;
    :cond_47
    const/4 v2, 0x0

    .restart local v2       #view:Landroid/view/View;
    goto :goto_1c

    .line 687
    :cond_49
    const/4 v3, 0x0

    invoke-virtual {p0, p2, v3, p3}, Landroid/view/LayoutInflater;->createView(Ljava/lang/String;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;
    :try_end_4d
    .catch Landroid/view/InflateException; {:try_start_10 .. :try_end_4d} :catch_4f
    .catch Ljava/lang/ClassNotFoundException; {:try_start_10 .. :try_end_4d} :catch_51
    .catch Ljava/lang/Exception; {:try_start_10 .. :try_end_4d} :catch_76

    move-result-object v2

    goto :goto_39

    .line 694
    .end local v2           #view:Landroid/view/View;
    :catch_4f
    move-exception v0

    .line 695
    .local v0, e:Landroid/view/InflateException;
    throw v0

    .line 697
    .end local v0           #e:Landroid/view/InflateException;
    :catch_51
    move-exception v0

    .line 698
    .local v0, e:Ljava/lang/ClassNotFoundException;
    new-instance v1, Landroid/view/InflateException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p3}, Landroid/util/AttributeSet;->getPositionDescription()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": Error inflating class "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    .line 700
    .local v1, ie:Landroid/view/InflateException;
    invoke-virtual {v1, v0}, Landroid/view/InflateException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    .line 701
    throw v1

    .line 703
    .end local v0           #e:Ljava/lang/ClassNotFoundException;
    .end local v1           #ie:Landroid/view/InflateException;
    :catch_76
    move-exception v0

    .line 704
    .local v0, e:Ljava/lang/Exception;
    new-instance v1, Landroid/view/InflateException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p3}, Landroid/util/AttributeSet;->getPositionDescription()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": Error inflating class "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    .line 706
    .restart local v1       #ie:Landroid/view/InflateException;
    invoke-virtual {v1, v0}, Landroid/view/InflateException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    .line 707
    throw v1
.end method

.method public getContext()Landroid/content/Context;
    .registers 2

    .prologue
    .line 237
    iget-object v0, p0, Landroid/view/LayoutInflater;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public final getFactory()Landroid/view/LayoutInflater$Factory;
    .registers 2

    .prologue
    .line 246
    iget-object v0, p0, Landroid/view/LayoutInflater;->mFactory:Landroid/view/LayoutInflater$Factory;

    return-object v0
.end method

.method public final getFactory2()Landroid/view/LayoutInflater$Factory2;
    .registers 2

    .prologue
    .line 257
    iget-object v0, p0, Landroid/view/LayoutInflater;->mFactory2:Landroid/view/LayoutInflater$Factory2;

    return-object v0
.end method

.method public getFilter()Landroid/view/LayoutInflater$Filter;
    .registers 2

    .prologue
    .line 321
    iget-object v0, p0, Landroid/view/LayoutInflater;->mFilter:Landroid/view/LayoutInflater$Filter;

    return-object v0
.end method

.method public inflate(ILandroid/view/ViewGroup;)Landroid/view/View;
    .registers 4
    .parameter "resource"
    .parameter "root"

    .prologue
    .line 352
    if-eqz p2, :cond_8

    const/4 v0, 0x1

    :goto_3
    invoke-virtual {p0, p1, p2, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_3
.end method

.method public inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    .registers 6
    .parameter "resource"
    .parameter "root"
    .parameter "attachToRoot"

    .prologue
    .line 394
    invoke-virtual {p0}, Landroid/view/LayoutInflater;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/content/res/Resources;->getLayout(I)Landroid/content/res/XmlResourceParser;

    move-result-object v0

    .line 396
    .local v0, parser:Landroid/content/res/XmlResourceParser;
    :try_start_c
    invoke-virtual {p0, v0, p2, p3}, Landroid/view/LayoutInflater;->inflate(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/ViewGroup;Z)Landroid/view/View;
    :try_end_f
    .catchall {:try_start_c .. :try_end_f} :catchall_14

    move-result-object v1

    .line 398
    invoke-interface {v0}, Landroid/content/res/XmlResourceParser;->close()V

    .line 396
    return-object v1

    .line 398
    :catchall_14
    move-exception v1

    invoke-interface {v0}, Landroid/content/res/XmlResourceParser;->close()V

    throw v1
.end method

.method public inflate(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/ViewGroup;)Landroid/view/View;
    .registers 4
    .parameter "parser"
    .parameter "root"

    .prologue
    .line 372
    if-eqz p2, :cond_8

    const/4 v0, 0x1

    :goto_3
    invoke-virtual {p0, p1, p2, v0}, Landroid/view/LayoutInflater;->inflate(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_3
.end method

.method public inflate(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/ViewGroup;Z)Landroid/view/View;
    .registers 21
    .parameter "parser"
    .parameter "root"
    .parameter "attachToRoot"

    .prologue
    .line 425
    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/view/LayoutInflater;->mConstructorArgs:[Ljava/lang/Object;

    monitor-enter v13

    .line 426
    :try_start_5
    invoke-static/range {p1 .. p1}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    move-result-object v3

    .line 427
    .local v3, attrs:Landroid/util/AttributeSet;
    move-object/from16 v0, p0

    iget-object v12, v0, Landroid/view/LayoutInflater;->mConstructorArgs:[Ljava/lang/Object;

    const/4 v14, 0x0

    aget-object v6, v12, v14

    check-cast v6, Landroid/content/Context;

    .line 428
    .local v6, lastContext:Landroid/content/Context;
    move-object/from16 v0, p0

    iget-object v12, v0, Landroid/view/LayoutInflater;->mConstructorArgs:[Ljava/lang/Object;

    const/4 v14, 0x0

    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/view/LayoutInflater;->mContext:Landroid/content/Context;

    aput-object v15, v12, v14
    :try_end_1d
    .catchall {:try_start_5 .. :try_end_1d} :catchall_69

    .line 429
    move-object/from16 v9, p2

    .line 435
    .local v9, result:Landroid/view/View;
    :cond_1f
    :try_start_1f
    invoke-interface/range {p1 .. p1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v11

    .local v11, type:I
    const/4 v12, 0x2

    if-eq v11, v12, :cond_29

    const/4 v12, 0x1

    if-ne v11, v12, :cond_1f

    .line 439
    :cond_29
    const/4 v12, 0x2

    if-eq v11, v12, :cond_6c

    .line 440
    new-instance v12, Landroid/view/InflateException;

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface/range {p1 .. p1}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, ": No start tag found!"

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-direct {v12, v14}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    throw v12
    :try_end_49
    .catchall {:try_start_1f .. :try_end_49} :catchall_57
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_1f .. :try_end_49} :catch_49
    .catch Ljava/io/IOException; {:try_start_1f .. :try_end_49} :catch_85

    .line 507
    .end local v11           #type:I
    :catch_49
    move-exception v4

    .line 508
    .local v4, e:Lorg/xmlpull/v1/XmlPullParserException;
    :try_start_4a
    new-instance v5, Landroid/view/InflateException;

    invoke-virtual {v4}, Lorg/xmlpull/v1/XmlPullParserException;->getMessage()Ljava/lang/String;

    move-result-object v12

    invoke-direct {v5, v12}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    .line 509
    .local v5, ex:Landroid/view/InflateException;
    invoke-virtual {v5, v4}, Landroid/view/InflateException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    .line 510
    throw v5
    :try_end_57
    .catchall {:try_start_4a .. :try_end_57} :catchall_57

    .line 519
    .end local v4           #e:Lorg/xmlpull/v1/XmlPullParserException;
    .end local v5           #ex:Landroid/view/InflateException;
    :catchall_57
    move-exception v12

    :try_start_58
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/LayoutInflater;->mConstructorArgs:[Ljava/lang/Object;

    const/4 v15, 0x0

    aput-object v6, v14, v15

    .line 520
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/LayoutInflater;->mConstructorArgs:[Ljava/lang/Object;

    const/4 v15, 0x1

    const/16 v16, 0x0

    aput-object v16, v14, v15

    .line 519
    throw v12

    .line 524
    .end local v3           #attrs:Landroid/util/AttributeSet;
    .end local v6           #lastContext:Landroid/content/Context;
    .end local v9           #result:Landroid/view/View;
    :catchall_69
    move-exception v12

    monitor-exit v13
    :try_end_6b
    .catchall {:try_start_58 .. :try_end_6b} :catchall_69

    throw v12

    .line 444
    .restart local v3       #attrs:Landroid/util/AttributeSet;
    .restart local v6       #lastContext:Landroid/content/Context;
    .restart local v9       #result:Landroid/view/View;
    .restart local v11       #type:I
    :cond_6c
    :try_start_6c
    invoke-interface/range {p1 .. p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v7

    .line 453
    .local v7, name:Ljava/lang/String;
    const-string/jumbo v12, "merge"

    invoke-virtual {v12, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_c9

    .line 454
    if-eqz p2, :cond_7d

    if-nez p3, :cond_ae

    .line 455
    :cond_7d
    new-instance v12, Landroid/view/InflateException;

    const-string v14, "<merge /> can be used only with a valid ViewGroup root and attachToRoot=true"

    invoke-direct {v12, v14}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    throw v12
    :try_end_85
    .catchall {:try_start_6c .. :try_end_85} :catchall_57
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_6c .. :try_end_85} :catch_49
    .catch Ljava/io/IOException; {:try_start_6c .. :try_end_85} :catch_85

    .line 511
    .end local v7           #name:Ljava/lang/String;
    .end local v11           #type:I
    :catch_85
    move-exception v4

    .line 512
    .local v4, e:Ljava/io/IOException;
    :try_start_86
    new-instance v5, Landroid/view/InflateException;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface/range {p1 .. p1}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v14, ": "

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-direct {v5, v12}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    .line 515
    .restart local v5       #ex:Landroid/view/InflateException;
    invoke-virtual {v5, v4}, Landroid/view/InflateException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    .line 516
    throw v5
    :try_end_ae
    .catchall {:try_start_86 .. :try_end_ae} :catchall_57

    .line 459
    .end local v4           #e:Ljava/io/IOException;
    .end local v5           #ex:Landroid/view/InflateException;
    .restart local v7       #name:Ljava/lang/String;
    .restart local v11       #type:I
    :cond_ae
    const/4 v12, 0x0

    :try_start_af
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    invoke-virtual {v0, v1, v2, v3, v12}, Landroid/view/LayoutInflater;->rInflate(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/View;Landroid/util/AttributeSet;Z)V
    :try_end_b8
    .catchall {:try_start_af .. :try_end_b8} :catchall_57
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_af .. :try_end_b8} :catch_49
    .catch Ljava/io/IOException; {:try_start_af .. :try_end_b8} :catch_85

    .line 519
    :cond_b8
    :goto_b8
    :try_start_b8
    move-object/from16 v0, p0

    iget-object v12, v0, Landroid/view/LayoutInflater;->mConstructorArgs:[Ljava/lang/Object;

    const/4 v14, 0x0

    aput-object v6, v12, v14

    .line 520
    move-object/from16 v0, p0

    iget-object v12, v0, Landroid/view/LayoutInflater;->mConstructorArgs:[Ljava/lang/Object;

    const/4 v14, 0x1

    const/4 v15, 0x0

    aput-object v15, v12, v14

    .line 523
    monitor-exit v13
    :try_end_c8
    .catchall {:try_start_b8 .. :try_end_c8} :catchall_69

    return-object v9

    .line 463
    :cond_c9
    :try_start_c9
    const-string v12, "blink"

    invoke-virtual {v12, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_ff

    .line 464
    new-instance v10, Landroid/view/LayoutInflater$BlinkLayout;

    move-object/from16 v0, p0

    iget-object v12, v0, Landroid/view/LayoutInflater;->mContext:Landroid/content/Context;

    invoke-direct {v10, v12, v3}, Landroid/view/LayoutInflater$BlinkLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 469
    .local v10, temp:Landroid/view/View;
    :goto_da
    const/4 v8, 0x0

    .line 471
    .local v8, params:Landroid/view/ViewGroup$LayoutParams;
    if-eqz p2, :cond_e8

    .line 477
    move-object/from16 v0, p2

    invoke-virtual {v0, v3}, Landroid/view/ViewGroup;->generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;

    move-result-object v8

    .line 478
    if-nez p3, :cond_e8

    .line 481
    invoke-virtual {v10, v8}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 489
    :cond_e8
    const/4 v12, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v10, v3, v12}, Landroid/view/LayoutInflater;->rInflate(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/View;Landroid/util/AttributeSet;Z)V

    .line 496
    if-eqz p2, :cond_f9

    if-eqz p3, :cond_f9

    .line 497
    move-object/from16 v0, p2

    invoke-virtual {v0, v10, v8}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 502
    :cond_f9
    if-eqz p2, :cond_fd

    if-nez p3, :cond_b8

    .line 503
    :cond_fd
    move-object v9, v10

    goto :goto_b8

    .line 466
    .end local v8           #params:Landroid/view/ViewGroup$LayoutParams;
    .end local v10           #temp:Landroid/view/View;
    :cond_ff
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v7, v3}, Landroid/view/LayoutInflater;->createViewFromTag(Landroid/view/View;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;
    :try_end_106
    .catchall {:try_start_c9 .. :try_end_106} :catchall_57
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_c9 .. :try_end_106} :catch_49
    .catch Ljava/io/IOException; {:try_start_c9 .. :try_end_106} :catch_85

    move-result-object v10

    .restart local v10       #temp:Landroid/view/View;
    goto :goto_da
.end method

.method protected onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;
    .registers 5
    .parameter "parent"
    .parameter "name"
    .parameter "attrs"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 660
    invoke-virtual {p0, p2, p3}, Landroid/view/LayoutInflater;->onCreateView(Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method protected onCreateView(Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;
    .registers 4
    .parameter "name"
    .parameter "attrs"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 643
    const-string v0, "android.view."

    invoke-virtual {p0, p1, v0, p2}, Landroid/view/LayoutInflater;->createView(Ljava/lang/String;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method rInflate(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/View;Landroid/util/AttributeSet;Z)V
    .registers 13
    .parameter "parser"
    .parameter "parent"
    .parameter "attrs"
    .parameter "finishInflate"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    .line 718
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v0

    .line 722
    .local v0, depth:I
    :cond_5
    :goto_5
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v3

    .local v3, type:I
    const/4 v6, 0x3

    if-ne v3, v6, :cond_12

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v6

    if-le v6, v0, :cond_82

    :cond_12
    if-eq v3, v7, :cond_82

    .line 724
    const/4 v6, 0x2

    if-ne v3, v6, :cond_5

    .line 728
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 730
    .local v1, name:Ljava/lang/String;
    const-string/jumbo v6, "requestFocus"

    invoke-virtual {v6, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_28

    .line 731
    invoke-direct {p0, p1, p2}, Landroid/view/LayoutInflater;->parseRequestFocus(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/View;)V

    goto :goto_5

    .line 732
    :cond_28
    const-string v6, "include"

    invoke-virtual {v6, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_42

    .line 733
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v6

    if-nez v6, :cond_3e

    .line 734
    new-instance v6, Landroid/view/InflateException;

    const-string v7, "<include /> cannot be the root element"

    invoke-direct {v6, v7}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 736
    :cond_3e
    invoke-direct {p0, p1, p2, p3}, Landroid/view/LayoutInflater;->parseInclude(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/View;Landroid/util/AttributeSet;)V

    goto :goto_5

    .line 737
    :cond_42
    const-string/jumbo v6, "merge"

    invoke-virtual {v6, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_53

    .line 738
    new-instance v6, Landroid/view/InflateException;

    const-string v7, "<merge /> must be the root element"

    invoke-direct {v6, v7}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 739
    :cond_53
    const-string v6, "blink"

    invoke-virtual {v6, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_70

    .line 740
    new-instance v4, Landroid/view/LayoutInflater$BlinkLayout;

    iget-object v6, p0, Landroid/view/LayoutInflater;->mContext:Landroid/content/Context;

    invoke-direct {v4, v6, p3}, Landroid/view/LayoutInflater$BlinkLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .local v4, view:Landroid/view/View;
    move-object v5, p2

    .line 741
    check-cast v5, Landroid/view/ViewGroup;

    .line 742
    .local v5, viewGroup:Landroid/view/ViewGroup;
    invoke-virtual {v5, p3}, Landroid/view/ViewGroup;->generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    .line 743
    .local v2, params:Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual {p0, p1, v4, p3, v7}, Landroid/view/LayoutInflater;->rInflate(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/View;Landroid/util/AttributeSet;Z)V

    .line 744
    invoke-virtual {v5, v4, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_5

    .line 746
    .end local v2           #params:Landroid/view/ViewGroup$LayoutParams;
    .end local v4           #view:Landroid/view/View;
    .end local v5           #viewGroup:Landroid/view/ViewGroup;
    :cond_70
    invoke-virtual {p0, p2, v1, p3}, Landroid/view/LayoutInflater;->createViewFromTag(Landroid/view/View;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v4

    .restart local v4       #view:Landroid/view/View;
    move-object v5, p2

    .line 747
    check-cast v5, Landroid/view/ViewGroup;

    .line 748
    .restart local v5       #viewGroup:Landroid/view/ViewGroup;
    invoke-virtual {v5, p3}, Landroid/view/ViewGroup;->generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    .line 749
    .restart local v2       #params:Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual {p0, p1, v4, p3, v7}, Landroid/view/LayoutInflater;->rInflate(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/View;Landroid/util/AttributeSet;Z)V

    .line 750
    invoke-virtual {v5, v4, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_5

    .line 754
    .end local v1           #name:Ljava/lang/String;
    .end local v2           #params:Landroid/view/ViewGroup$LayoutParams;
    .end local v4           #view:Landroid/view/View;
    .end local v5           #viewGroup:Landroid/view/ViewGroup;
    :cond_82
    if-eqz p4, :cond_87

    invoke-virtual {p2}, Landroid/view/View;->onFinishInflate()V

    .line 755
    :cond_87
    return-void
.end method

.method public setFactory(Landroid/view/LayoutInflater$Factory;)V
    .registers 6
    .parameter "factory"

    .prologue
    .line 276
    iget-boolean v0, p0, Landroid/view/LayoutInflater;->mFactorySet:Z

    if-eqz v0, :cond_c

    .line 277
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "A factory has already been set on this LayoutInflater"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 279
    :cond_c
    if-nez p1, :cond_16

    .line 280
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Given factory can not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 282
    :cond_16
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/LayoutInflater;->mFactorySet:Z

    .line 283
    iget-object v0, p0, Landroid/view/LayoutInflater;->mFactory:Landroid/view/LayoutInflater$Factory;

    if-nez v0, :cond_20

    .line 284
    iput-object p1, p0, Landroid/view/LayoutInflater;->mFactory:Landroid/view/LayoutInflater$Factory;

    .line 288
    :goto_1f
    return-void

    .line 286
    :cond_20
    new-instance v0, Landroid/view/LayoutInflater$FactoryMerger;

    const/4 v1, 0x0

    iget-object v2, p0, Landroid/view/LayoutInflater;->mFactory:Landroid/view/LayoutInflater$Factory;

    iget-object v3, p0, Landroid/view/LayoutInflater;->mFactory2:Landroid/view/LayoutInflater$Factory2;

    invoke-direct {v0, p1, v1, v2, v3}, Landroid/view/LayoutInflater$FactoryMerger;-><init>(Landroid/view/LayoutInflater$Factory;Landroid/view/LayoutInflater$Factory2;Landroid/view/LayoutInflater$Factory;Landroid/view/LayoutInflater$Factory2;)V

    iput-object v0, p0, Landroid/view/LayoutInflater;->mFactory:Landroid/view/LayoutInflater$Factory;

    goto :goto_1f
.end method

.method public setFactory2(Landroid/view/LayoutInflater$Factory2;)V
    .registers 5
    .parameter "factory"

    .prologue
    .line 295
    iget-boolean v0, p0, Landroid/view/LayoutInflater;->mFactorySet:Z

    if-eqz v0, :cond_c

    .line 296
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "A factory has already been set on this LayoutInflater"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 298
    :cond_c
    if-nez p1, :cond_16

    .line 299
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Given factory can not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 301
    :cond_16
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/LayoutInflater;->mFactorySet:Z

    .line 302
    iget-object v0, p0, Landroid/view/LayoutInflater;->mFactory:Landroid/view/LayoutInflater$Factory;

    if-nez v0, :cond_22

    .line 303
    iput-object p1, p0, Landroid/view/LayoutInflater;->mFactory2:Landroid/view/LayoutInflater$Factory2;

    iput-object p1, p0, Landroid/view/LayoutInflater;->mFactory:Landroid/view/LayoutInflater$Factory;

    .line 307
    :goto_21
    return-void

    .line 305
    :cond_22
    new-instance v0, Landroid/view/LayoutInflater$FactoryMerger;

    iget-object v1, p0, Landroid/view/LayoutInflater;->mFactory:Landroid/view/LayoutInflater$Factory;

    iget-object v2, p0, Landroid/view/LayoutInflater;->mFactory2:Landroid/view/LayoutInflater$Factory2;

    invoke-direct {v0, p1, p1, v1, v2}, Landroid/view/LayoutInflater$FactoryMerger;-><init>(Landroid/view/LayoutInflater$Factory;Landroid/view/LayoutInflater$Factory2;Landroid/view/LayoutInflater$Factory;Landroid/view/LayoutInflater$Factory2;)V

    iput-object v0, p0, Landroid/view/LayoutInflater;->mFactory:Landroid/view/LayoutInflater$Factory;

    goto :goto_21
.end method

.method public setFilter(Landroid/view/LayoutInflater$Filter;)V
    .registers 3
    .parameter "filter"

    .prologue
    .line 334
    iput-object p1, p0, Landroid/view/LayoutInflater;->mFilter:Landroid/view/LayoutInflater$Filter;

    .line 335
    if-eqz p1, :cond_b

    .line 336
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/view/LayoutInflater;->mFilterMap:Ljava/util/HashMap;

    .line 338
    :cond_b
    return-void
.end method

.method public setPrivateFactory(Landroid/view/LayoutInflater$Factory2;)V
    .registers 2
    .parameter "factory"

    .prologue
    .line 313
    iput-object p1, p0, Landroid/view/LayoutInflater;->mPrivateFactory:Landroid/view/LayoutInflater$Factory2;

    .line 314
    return-void
.end method
