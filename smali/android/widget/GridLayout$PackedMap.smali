.class final Landroid/widget/GridLayout$PackedMap;
.super Ljava/lang/Object;
.source "GridLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/GridLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "PackedMap"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field public final index:[I

.field public final keys:[Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[TK;"
        }
    .end annotation
.end field

.field public final values:[Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[TV;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>([Ljava/lang/Object;[Ljava/lang/Object;)V
    .registers 4
    .parameter
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TK;[TV;)V"
        }
    .end annotation

    .prologue
    .line 2127
    .local p0, this:Landroid/widget/GridLayout$PackedMap;,"Landroid/widget/GridLayout$PackedMap<TK;TV;>;"
    .local p1, keys:[Ljava/lang/Object;,"[TK;"
    .local p2, values:[Ljava/lang/Object;,"[TV;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 2128
    invoke-static {p1}, Landroid/widget/GridLayout$PackedMap;->createIndex([Ljava/lang/Object;)[I

    move-result-object v0

    iput-object v0, p0, Landroid/widget/GridLayout$PackedMap;->index:[I

    .line 2130
    iget-object v0, p0, Landroid/widget/GridLayout$PackedMap;->index:[I

    invoke-static {p1, v0}, Landroid/widget/GridLayout$PackedMap;->compact([Ljava/lang/Object;[I)[Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/GridLayout$PackedMap;->keys:[Ljava/lang/Object;

    .line 2131
    iget-object v0, p0, Landroid/widget/GridLayout$PackedMap;->index:[I

    invoke-static {p2, v0}, Landroid/widget/GridLayout$PackedMap;->compact([Ljava/lang/Object;[I)[Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/GridLayout$PackedMap;->values:[Ljava/lang/Object;

    .line 2132
    return-void
.end method

.method synthetic constructor <init>([Ljava/lang/Object;[Ljava/lang/Object;Landroid/widget/GridLayout$1;)V
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 2122
    .local p0, this:Landroid/widget/GridLayout$PackedMap;,"Landroid/widget/GridLayout$PackedMap<TK;TV;>;"
    invoke-direct {p0, p1, p2}, Landroid/widget/GridLayout$PackedMap;-><init>([Ljava/lang/Object;[Ljava/lang/Object;)V

    return-void
.end method

.method private static compact([Ljava/lang/Object;[I)[Ljava/lang/Object;
    .registers 8
    .parameter
    .parameter "index"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            ">([TK;[I)[TK;"
        }
    .end annotation

    .prologue
    .line 2159
    .local p0, a:[Ljava/lang/Object;,"[TK;"
    array-length v3, p0

    .line 2160
    .local v3, size:I
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v0

    .line 2161
    .local v0, componentType:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    const/4 v4, -0x1

    invoke-static {p1, v4}, Landroid/widget/GridLayout;->max2([II)I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    invoke-static {v0, v4}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Ljava/lang/Object;

    move-object v2, v4

    check-cast v2, [Ljava/lang/Object;

    .line 2164
    .local v2, result:[Ljava/lang/Object;,"[TK;"
    const/4 v1, 0x0

    .local v1, i:I
    :goto_1a
    if-ge v1, v3, :cond_25

    .line 2165
    aget v4, p1, v1

    aget-object v5, p0, v1

    aput-object v5, v2, v4

    .line 2164
    add-int/lit8 v1, v1, 0x1

    goto :goto_1a

    .line 2167
    :cond_25
    return-object v2
.end method

.method private static createIndex([Ljava/lang/Object;)[I
    .registers 8
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            ">([TK;)[I"
        }
    .end annotation

    .prologue
    .line 2139
    .local p0, keys:[Ljava/lang/Object;,"[TK;"
    array-length v5, p0

    .line 2140
    .local v5, size:I
    new-array v4, v5, [I

    .line 2142
    .local v4, result:[I
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 2143
    .local v3, keyToIndex:Ljava/util/Map;,"Ljava/util/Map<TK;Ljava/lang/Integer;>;"
    const/4 v0, 0x0

    .local v0, i:I
    :goto_9
    if-ge v0, v5, :cond_29

    .line 2144
    aget-object v2, p0, v0

    .line 2145
    .local v2, key:Ljava/lang/Object;,"TK;"
    invoke-interface {v3, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    .line 2146
    .local v1, index:Ljava/lang/Integer;
    if-nez v1, :cond_20

    .line 2147
    invoke-interface {v3}, Ljava/util/Map;->size()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    .line 2148
    invoke-interface {v3, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2150
    :cond_20
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v6

    aput v6, v4, v0

    .line 2143
    add-int/lit8 v0, v0, 0x1

    goto :goto_9

    .line 2152
    .end local v1           #index:Ljava/lang/Integer;
    .end local v2           #key:Ljava/lang/Object;,"TK;"
    :cond_29
    return-object v4
.end method


# virtual methods
.method public getValue(I)Ljava/lang/Object;
    .registers 4
    .parameter "i"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TV;"
        }
    .end annotation

    .prologue
    .line 2135
    .local p0, this:Landroid/widget/GridLayout$PackedMap;,"Landroid/widget/GridLayout$PackedMap<TK;TV;>;"
    iget-object v0, p0, Landroid/widget/GridLayout$PackedMap;->values:[Ljava/lang/Object;

    iget-object v1, p0, Landroid/widget/GridLayout$PackedMap;->index:[I

    aget v1, v1, p1

    aget-object v0, v0, v1

    return-object v0
.end method
