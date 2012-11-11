.class public Landroid/content/UriMatcher;
.super Ljava/lang/Object;
.source "UriMatcher.java"


# static fields
.field private static final EXACT:I = 0x0

.field public static final NO_MATCH:I = -0x1

.field private static final NUMBER:I = 0x1

.field static final PATH_SPLIT_PATTERN:Ljava/util/regex/Pattern; = null

.field private static final TEXT:I = 0x2


# instance fields
.field private mChildren:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/content/UriMatcher;",
            ">;"
        }
    .end annotation
.end field

.field private mCode:I

.field private mText:Ljava/lang/String;

.field private mWhich:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const-string v0, "/"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroid/content/UriMatcher;->PATH_SPLIT_PATTERN:Ljava/util/regex/Pattern;

    return-void
.end method

.method private constructor <init>()V
    .registers 2

    .prologue
    const/4 v0, -0x1

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput v0, p0, Landroid/content/UriMatcher;->mCode:I

    iput v0, p0, Landroid/content/UriMatcher;->mWhich:I

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/content/UriMatcher;->mChildren:Ljava/util/ArrayList;

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/content/UriMatcher;->mText:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(I)V
    .registers 3
    .parameter "code"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroid/content/UriMatcher;->mCode:I

    const/4 v0, -0x1

    iput v0, p0, Landroid/content/UriMatcher;->mWhich:I

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/content/UriMatcher;->mChildren:Ljava/util/ArrayList;

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/content/UriMatcher;->mText:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public addURI(Ljava/lang/String;Ljava/lang/String;I)V
    .registers 16
    .parameter "authority"
    .parameter "path"
    .parameter "code"

    .prologue
    const/4 v9, 0x0

    if-gez p3, :cond_22

    new-instance v9, Ljava/lang/IllegalArgumentException;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "code "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " is invalid: it must be positive"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    :cond_22
    if-eqz p2, :cond_69

    sget-object v10, Landroid/content/UriMatcher;->PATH_SPLIT_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v10, p2}, Ljava/util/regex/Pattern;->split(Ljava/lang/CharSequence;)[Ljava/lang/String;

    move-result-object v8

    .local v8, tokens:[Ljava/lang/String;
    :goto_2a
    if-eqz v8, :cond_6b

    array-length v6, v8

    .local v6, numTokens:I
    :goto_2d
    move-object v4, p0

    .local v4, node:Landroid/content/UriMatcher;
    const/4 v2, -0x1

    .local v2, i:I
    :goto_2f
    if-ge v2, v6, :cond_82

    if-gez v2, :cond_6d

    move-object v7, p1

    .local v7, token:Ljava/lang/String;
    :goto_34
    iget-object v1, v4, Landroid/content/UriMatcher;->mChildren:Ljava/util/ArrayList;

    .local v1, children:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/content/UriMatcher;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v5

    .local v5, numChildren:I
    const/4 v3, 0x0

    .local v3, j:I
    :goto_3b
    if-ge v3, v5, :cond_4c

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/UriMatcher;

    .local v0, child:Landroid/content/UriMatcher;
    iget-object v10, v0, Landroid/content/UriMatcher;->mText:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_70

    move-object v4, v0

    .end local v0           #child:Landroid/content/UriMatcher;
    :cond_4c
    if-ne v3, v5, :cond_66

    new-instance v0, Landroid/content/UriMatcher;

    invoke-direct {v0}, Landroid/content/UriMatcher;-><init>()V

    .restart local v0       #child:Landroid/content/UriMatcher;
    const-string v10, "#"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_73

    const/4 v10, 0x1

    iput v10, v0, Landroid/content/UriMatcher;->mWhich:I

    :goto_5e
    iput-object v7, v0, Landroid/content/UriMatcher;->mText:Ljava/lang/String;

    iget-object v10, v4, Landroid/content/UriMatcher;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v10, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move-object v4, v0

    .end local v0           #child:Landroid/content/UriMatcher;
    :cond_66
    add-int/lit8 v2, v2, 0x1

    goto :goto_2f

    .end local v1           #children:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/content/UriMatcher;>;"
    .end local v2           #i:I
    .end local v3           #j:I
    .end local v4           #node:Landroid/content/UriMatcher;
    .end local v5           #numChildren:I
    .end local v6           #numTokens:I
    .end local v7           #token:Ljava/lang/String;
    .end local v8           #tokens:[Ljava/lang/String;
    :cond_69
    const/4 v8, 0x0

    goto :goto_2a

    .restart local v8       #tokens:[Ljava/lang/String;
    :cond_6b
    move v6, v9

    goto :goto_2d

    .restart local v2       #i:I
    .restart local v4       #node:Landroid/content/UriMatcher;
    .restart local v6       #numTokens:I
    :cond_6d
    aget-object v7, v8, v2

    goto :goto_34

    .restart local v0       #child:Landroid/content/UriMatcher;
    .restart local v1       #children:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/content/UriMatcher;>;"
    .restart local v3       #j:I
    .restart local v5       #numChildren:I
    .restart local v7       #token:Ljava/lang/String;
    :cond_70
    add-int/lit8 v3, v3, 0x1

    goto :goto_3b

    :cond_73
    const-string v10, "*"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_7f

    const/4 v10, 0x2

    iput v10, v0, Landroid/content/UriMatcher;->mWhich:I

    goto :goto_5e

    :cond_7f
    iput v9, v0, Landroid/content/UriMatcher;->mWhich:I

    goto :goto_5e

    .end local v0           #child:Landroid/content/UriMatcher;
    .end local v1           #children:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/content/UriMatcher;>;"
    .end local v3           #j:I
    .end local v5           #numChildren:I
    .end local v7           #token:Ljava/lang/String;
    :cond_82
    iput p3, v4, Landroid/content/UriMatcher;->mCode:I

    return-void
.end method

.method public match(Landroid/net/Uri;)I
    .registers 15
    .parameter "uri"

    .prologue
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v10

    .local v10, pathSegments:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v4

    .local v4, li:I
    move-object v9, p0

    .local v9, node:Landroid/content/UriMatcher;
    if-nez v4, :cond_14

    invoke-virtual {p1}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v12

    if-nez v12, :cond_14

    iget v12, p0, Landroid/content/UriMatcher;->mCode:I

    :goto_13
    return v12

    :cond_14
    const/4 v1, -0x1

    .local v1, i:I
    :goto_15
    if-ge v1, v4, :cond_21

    if-gez v1, :cond_24

    invoke-virtual {p1}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v11

    .local v11, u:Ljava/lang/String;
    :goto_1d
    iget-object v5, v9, Landroid/content/UriMatcher;->mChildren:Ljava/util/ArrayList;

    .local v5, list:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/content/UriMatcher;>;"
    if-nez v5, :cond_2c

    .end local v5           #list:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/content/UriMatcher;>;"
    .end local v11           #u:Ljava/lang/String;
    :cond_21
    iget v12, v9, Landroid/content/UriMatcher;->mCode:I

    goto :goto_13

    :cond_24
    invoke-interface {v10, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    move-object v11, v12

    goto :goto_1d

    .restart local v5       #list:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/content/UriMatcher;>;"
    .restart local v11       #u:Ljava/lang/String;
    :cond_2c
    const/4 v9, 0x0

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v6

    .local v6, lj:I
    const/4 v2, 0x0

    .local v2, j:I
    :goto_32
    if-ge v2, v6, :cond_41

    invoke-virtual {v5, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/UriMatcher;

    .local v8, n:Landroid/content/UriMatcher;
    iget v12, v8, Landroid/content/UriMatcher;->mWhich:I

    packed-switch v12, :pswitch_data_70

    :cond_3f
    :goto_3f
    if-eqz v9, :cond_69

    .end local v8           #n:Landroid/content/UriMatcher;
    :cond_41
    if-nez v9, :cond_6c

    const/4 v12, -0x1

    goto :goto_13

    .restart local v8       #n:Landroid/content/UriMatcher;
    :pswitch_45
    iget-object v12, v8, Landroid/content/UriMatcher;->mText:Ljava/lang/String;

    invoke-virtual {v12, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_3f

    move-object v9, v8

    goto :goto_3f

    :pswitch_4f
    invoke-virtual {v11}, Ljava/lang/String;->length()I

    move-result v7

    .local v7, lk:I
    const/4 v3, 0x0

    .local v3, k:I
    :goto_54
    if-ge v3, v7, :cond_65

    invoke-virtual {v11, v3}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .local v0, c:C
    const/16 v12, 0x30

    if-lt v0, v12, :cond_3f

    const/16 v12, 0x39

    if-gt v0, v12, :cond_3f

    add-int/lit8 v3, v3, 0x1

    goto :goto_54

    .end local v0           #c:C
    :cond_65
    move-object v9, v8

    goto :goto_3f

    .end local v3           #k:I
    .end local v7           #lk:I
    :pswitch_67
    move-object v9, v8

    goto :goto_3f

    :cond_69
    add-int/lit8 v2, v2, 0x1

    goto :goto_32

    .end local v8           #n:Landroid/content/UriMatcher;
    :cond_6c
    add-int/lit8 v1, v1, 0x1

    goto :goto_15

    nop

    :pswitch_data_70
    .packed-switch 0x0
        :pswitch_45
        :pswitch_4f
        :pswitch_67
    .end packed-switch
.end method
