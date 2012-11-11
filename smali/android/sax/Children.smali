.class Landroid/sax/Children;
.super Ljava/lang/Object;
.source "Children.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/sax/Children$Child;
    }
.end annotation


# instance fields
.field children:[Landroid/sax/Children$Child;


# direct methods
.method constructor <init>()V
    .registers 2

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/16 v0, 0x10

    new-array v0, v0, [Landroid/sax/Children$Child;

    iput-object v0, p0, Landroid/sax/Children;->children:[Landroid/sax/Children$Child;

    return-void
.end method


# virtual methods
.method get(Ljava/lang/String;Ljava/lang/String;)Landroid/sax/Element;
    .registers 9
    .parameter "uri"
    .parameter "localName"

    .prologue
    const/4 v3, 0x0

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v4

    mul-int/lit8 v4, v4, 0x1f

    invoke-virtual {p2}, Ljava/lang/String;->hashCode()I

    move-result v5

    add-int v1, v4, v5

    .local v1, hash:I
    and-int/lit8 v2, v1, 0xf

    .local v2, index:I
    iget-object v4, p0, Landroid/sax/Children;->children:[Landroid/sax/Children$Child;

    aget-object v0, v4, v2

    .local v0, current:Landroid/sax/Children$Child;
    if-nez v0, :cond_16

    :goto_15
    return-object v3

    :cond_16
    iget v4, v0, Landroid/sax/Children$Child;->hash:I

    if-ne v4, v1, :cond_2c

    iget-object v4, v0, Landroid/sax/Element;->uri:Ljava/lang/String;

    invoke-virtual {v4, p1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_2c

    iget-object v4, v0, Landroid/sax/Element;->localName:Ljava/lang/String;

    invoke-virtual {v4, p2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_2c

    move-object v3, v0

    goto :goto_15

    :cond_2c
    iget-object v0, v0, Landroid/sax/Children$Child;->next:Landroid/sax/Children$Child;

    if-nez v0, :cond_16

    goto :goto_15
.end method

.method getOrCreate(Landroid/sax/Element;Ljava/lang/String;Ljava/lang/String;)Landroid/sax/Element;
    .registers 13
    .parameter "parent"
    .parameter "uri"
    .parameter "localName"

    .prologue
    invoke-virtual {p2}, Ljava/lang/String;->hashCode()I

    move-result v1

    mul-int/lit8 v1, v1, 0x1f

    invoke-virtual {p3}, Ljava/lang/String;->hashCode()I

    move-result v2

    add-int v5, v1, v2

    .local v5, hash:I
    and-int/lit8 v7, v5, 0xf

    .local v7, index:I
    iget-object v1, p0, Landroid/sax/Children;->children:[Landroid/sax/Children$Child;

    aget-object v0, v1, v7

    .local v0, current:Landroid/sax/Children$Child;
    if-nez v0, :cond_26

    new-instance v0, Landroid/sax/Children$Child;

    .end local v0           #current:Landroid/sax/Children$Child;
    iget v1, p1, Landroid/sax/Element;->depth:I

    add-int/lit8 v4, v1, 0x1

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-direct/range {v0 .. v5}, Landroid/sax/Children$Child;-><init>(Landroid/sax/Element;Ljava/lang/String;Ljava/lang/String;II)V

    .restart local v0       #current:Landroid/sax/Children$Child;
    iget-object v1, p0, Landroid/sax/Children;->children:[Landroid/sax/Children$Child;

    aput-object v0, v1, v7

    move-object v6, v0

    .end local v0           #current:Landroid/sax/Children$Child;
    .local v6, current:Ljava/lang/Object;
    :goto_25
    return-object v6

    .end local v6           #current:Ljava/lang/Object;
    .restart local v0       #current:Landroid/sax/Children$Child;
    :cond_26
    iget v1, v0, Landroid/sax/Children$Child;->hash:I

    if-ne v1, v5, :cond_3c

    iget-object v1, v0, Landroid/sax/Element;->uri:Ljava/lang/String;

    invoke-virtual {v1, p2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_3c

    iget-object v1, v0, Landroid/sax/Element;->localName:Ljava/lang/String;

    invoke-virtual {v1, p3}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_3c

    move-object v6, v0

    .restart local v6       #current:Ljava/lang/Object;
    goto :goto_25

    .end local v6           #current:Ljava/lang/Object;
    :cond_3c
    move-object v8, v0

    .local v8, previous:Landroid/sax/Children$Child;
    iget-object v0, v0, Landroid/sax/Children$Child;->next:Landroid/sax/Children$Child;

    if-nez v0, :cond_26

    new-instance v0, Landroid/sax/Children$Child;

    .end local v0           #current:Landroid/sax/Children$Child;
    iget v1, p1, Landroid/sax/Element;->depth:I

    add-int/lit8 v4, v1, 0x1

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-direct/range {v0 .. v5}, Landroid/sax/Children$Child;-><init>(Landroid/sax/Element;Ljava/lang/String;Ljava/lang/String;II)V

    .restart local v0       #current:Landroid/sax/Children$Child;
    iput-object v0, v8, Landroid/sax/Children$Child;->next:Landroid/sax/Children$Child;

    move-object v6, v0

    .restart local v6       #current:Ljava/lang/Object;
    goto :goto_25
.end method
