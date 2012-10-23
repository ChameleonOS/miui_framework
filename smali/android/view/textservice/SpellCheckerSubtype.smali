.class public final Landroid/view/textservice/SpellCheckerSubtype;
.super Ljava/lang/Object;
.source "SpellCheckerSubtype.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/view/textservice/SpellCheckerSubtype;",
            ">;"
        }
    .end annotation
.end field

.field private static final EXTRA_VALUE_KEY_VALUE_SEPARATOR:Ljava/lang/String; = "="

.field private static final EXTRA_VALUE_PAIR_SEPARATOR:Ljava/lang/String; = ","

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mExtraValueHashMapCache:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mSubtypeExtraValue:Ljava/lang/String;

.field private final mSubtypeHashCode:I

.field private final mSubtypeLocale:Ljava/lang/String;

.field private final mSubtypeNameResId:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 38
    const-class v0, Landroid/view/textservice/SpellCheckerSubtype;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroid/view/textservice/SpellCheckerSubtype;->TAG:Ljava/lang/String;

    .line 206
    new-instance v0, Landroid/view/textservice/SpellCheckerSubtype$1;

    invoke-direct {v0}, Landroid/view/textservice/SpellCheckerSubtype$1;-><init>()V

    sput-object v0, Landroid/view/textservice/SpellCheckerSubtype;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Ljava/lang/String;)V
    .registers 6
    .parameter "nameId"
    .parameter "locale"
    .parameter "extraValue"

    .prologue
    .line 54
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 55
    iput p1, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeNameResId:I

    .line 56
    if-eqz p2, :cond_18

    .end local p2
    :goto_7
    iput-object p2, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeLocale:Ljava/lang/String;

    .line 57
    if-eqz p3, :cond_1b

    .end local p3
    :goto_b
    iput-object p3, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeExtraValue:Ljava/lang/String;

    .line 58
    iget-object v0, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeLocale:Ljava/lang/String;

    iget-object v1, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeExtraValue:Ljava/lang/String;

    invoke-static {v0, v1}, Landroid/view/textservice/SpellCheckerSubtype;->hashCodeInternal(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeHashCode:I

    .line 59
    return-void

    .line 56
    .restart local p2
    .restart local p3
    :cond_18
    const-string p2, ""

    goto :goto_7

    .line 57
    .end local p2
    :cond_1b
    const-string p3, ""

    goto :goto_b
.end method

.method constructor <init>(Landroid/os/Parcel;)V
    .registers 5
    .parameter "source"

    .prologue
    .line 61
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 63
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeNameResId:I

    .line 64
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 65
    .local v0, s:Ljava/lang/String;
    if-eqz v0, :cond_24

    .end local v0           #s:Ljava/lang/String;
    :goto_f
    iput-object v0, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeLocale:Ljava/lang/String;

    .line 66
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 67
    .restart local v0       #s:Ljava/lang/String;
    if-eqz v0, :cond_27

    .end local v0           #s:Ljava/lang/String;
    :goto_17
    iput-object v0, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeExtraValue:Ljava/lang/String;

    .line 68
    iget-object v1, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeLocale:Ljava/lang/String;

    iget-object v2, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeExtraValue:Ljava/lang/String;

    invoke-static {v1, v2}, Landroid/view/textservice/SpellCheckerSubtype;->hashCodeInternal(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeHashCode:I

    .line 69
    return-void

    .line 65
    .restart local v0       #s:Ljava/lang/String;
    :cond_24
    const-string v0, ""

    goto :goto_f

    .line 67
    :cond_27
    const-string v0, ""

    goto :goto_17
.end method

.method public static constructLocaleFromString(Ljava/lang/String;)Ljava/util/Locale;
    .registers 8
    .parameter "localeStr"

    .prologue
    const/4 v1, 0x0

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 153
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_c

    .line 165
    :cond_b
    :goto_b
    return-object v1

    .line 155
    :cond_c
    const-string v2, "_"

    invoke-virtual {p0, v2, v6}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    .line 158
    .local v0, localeParams:[Ljava/lang/String;
    array-length v2, v0

    if-ne v2, v4, :cond_1d

    .line 159
    new-instance v1, Ljava/util/Locale;

    aget-object v2, v0, v3

    invoke-direct {v1, v2}, Ljava/util/Locale;-><init>(Ljava/lang/String;)V

    goto :goto_b

    .line 160
    :cond_1d
    array-length v2, v0

    if-ne v2, v5, :cond_2a

    .line 161
    new-instance v1, Ljava/util/Locale;

    aget-object v2, v0, v3

    aget-object v3, v0, v4

    invoke-direct {v1, v2, v3}, Ljava/util/Locale;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_b

    .line 162
    :cond_2a
    array-length v2, v0

    if-ne v2, v6, :cond_b

    .line 163
    new-instance v1, Ljava/util/Locale;

    aget-object v2, v0, v3

    aget-object v3, v0, v4

    aget-object v4, v0, v5

    invoke-direct {v1, v2, v3, v4}, Ljava/util/Locale;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_b
.end method

.method private getExtraValueHashMap()Ljava/util/HashMap;
    .registers 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 93
    iget-object v4, p0, Landroid/view/textservice/SpellCheckerSubtype;->mExtraValueHashMapCache:Ljava/util/HashMap;

    if-nez v4, :cond_47

    .line 94
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    iput-object v4, p0, Landroid/view/textservice/SpellCheckerSubtype;->mExtraValueHashMapCache:Ljava/util/HashMap;

    .line 95
    iget-object v4, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeExtraValue:Ljava/lang/String;

    const-string v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 96
    .local v3, pairs:[Ljava/lang/String;
    array-length v0, v3

    .line 97
    .local v0, N:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_17
    if-ge v1, v0, :cond_47

    .line 98
    aget-object v4, v3, v1

    const-string v5, "="

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 99
    .local v2, pair:[Ljava/lang/String;
    array-length v4, v2

    if-ne v4, v7, :cond_2f

    .line 100
    iget-object v4, p0, Landroid/view/textservice/SpellCheckerSubtype;->mExtraValueHashMapCache:Ljava/util/HashMap;

    aget-object v5, v2, v8

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 97
    :cond_2c
    :goto_2c
    add-int/lit8 v1, v1, 0x1

    goto :goto_17

    .line 101
    :cond_2f
    array-length v4, v2

    if-le v4, v7, :cond_2c

    .line 102
    array-length v4, v2

    const/4 v5, 0x2

    if-le v4, v5, :cond_3d

    .line 103
    sget-object v4, Landroid/view/textservice/SpellCheckerSubtype;->TAG:Ljava/lang/String;

    const-string v5, "ExtraValue has two or more \'=\'s"

    invoke-static {v4, v5}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 105
    :cond_3d
    iget-object v4, p0, Landroid/view/textservice/SpellCheckerSubtype;->mExtraValueHashMapCache:Ljava/util/HashMap;

    aget-object v5, v2, v8

    aget-object v6, v2, v7

    invoke-virtual {v4, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2c

    .line 109
    .end local v0           #N:I
    .end local v1           #i:I
    .end local v2           #pair:[Ljava/lang/String;
    .end local v3           #pairs:[Ljava/lang/String;
    :cond_47
    iget-object v4, p0, Landroid/view/textservice/SpellCheckerSubtype;->mExtraValueHashMapCache:Ljava/util/HashMap;

    return-object v4
.end method

.method private static hashCodeInternal(Ljava/lang/String;Ljava/lang/String;)I
    .registers 4
    .parameter "locale"
    .parameter "extraValue"

    .prologue
    .line 220
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p0, v0, v1

    const/4 v1, 0x1

    aput-object p1, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public static sort(Landroid/content/Context;ILandroid/view/textservice/SpellCheckerInfo;Ljava/util/List;)Ljava/util/List;
    .registers 11
    .parameter "context"
    .parameter "flags"
    .parameter "sci"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Landroid/view/textservice/SpellCheckerInfo;",
            "Ljava/util/List",
            "<",
            "Landroid/view/textservice/SpellCheckerSubtype;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Landroid/view/textservice/SpellCheckerSubtype;",
            ">;"
        }
    .end annotation

    .prologue
    .line 234
    .local p3, subtypeList:Ljava/util/List;,"Ljava/util/List<Landroid/view/textservice/SpellCheckerSubtype;>;"
    if-nez p2, :cond_3

    .line 251
    .end local p3           #subtypeList:Ljava/util/List;,"Ljava/util/List<Landroid/view/textservice/SpellCheckerSubtype;>;"
    :goto_2
    return-object p3

    .line 235
    .restart local p3       #subtypeList:Ljava/util/List;,"Ljava/util/List<Landroid/view/textservice/SpellCheckerSubtype;>;"
    :cond_3
    new-instance v5, Ljava/util/HashSet;

    invoke-direct {v5, p3}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 237
    .local v5, subtypesSet:Ljava/util/HashSet;,"Ljava/util/HashSet<Landroid/view/textservice/SpellCheckerSubtype;>;"
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 238
    .local v3, sortedList:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/textservice/SpellCheckerSubtype;>;"
    invoke-virtual {p2}, Landroid/view/textservice/SpellCheckerInfo;->getSubtypeCount()I

    move-result v0

    .line 239
    .local v0, N:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_12
    if-ge v1, v0, :cond_27

    .line 240
    invoke-virtual {p2, v1}, Landroid/view/textservice/SpellCheckerInfo;->getSubtypeAt(I)Landroid/view/textservice/SpellCheckerSubtype;

    move-result-object v4

    .line 241
    .local v4, subtype:Landroid/view/textservice/SpellCheckerSubtype;
    invoke-virtual {v5, v4}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_24

    .line 242
    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 243
    invoke-virtual {v5, v4}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    .line 239
    :cond_24
    add-int/lit8 v1, v1, 0x1

    goto :goto_12

    .line 248
    .end local v4           #subtype:Landroid/view/textservice/SpellCheckerSubtype;
    :cond_27
    invoke-virtual {v5}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, i$:Ljava/util/Iterator;
    :goto_2b
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3b

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/textservice/SpellCheckerSubtype;

    .line 249
    .restart local v4       #subtype:Landroid/view/textservice/SpellCheckerSubtype;
    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2b

    .end local v4           #subtype:Landroid/view/textservice/SpellCheckerSubtype;
    :cond_3b
    move-object p3, v3

    .line 251
    goto :goto_2
.end method


# virtual methods
.method public containsExtraValueKey(Ljava/lang/String;)Z
    .registers 3
    .parameter "key"

    .prologue
    .line 119
    invoke-direct {p0}, Landroid/view/textservice/SpellCheckerSubtype;->getExtraValueHashMap()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public describeContents()I
    .registers 2

    .prologue
    .line 196
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 6
    .parameter "o"

    .prologue
    const/4 v1, 0x0

    .line 139
    instance-of v2, p1, Landroid/view/textservice/SpellCheckerSubtype;

    if-eqz v2, :cond_39

    move-object v0, p1

    .line 140
    check-cast v0, Landroid/view/textservice/SpellCheckerSubtype;

    .line 141
    .local v0, subtype:Landroid/view/textservice/SpellCheckerSubtype;
    invoke-virtual {v0}, Landroid/view/textservice/SpellCheckerSubtype;->hashCode()I

    move-result v2

    invoke-virtual {p0}, Landroid/view/textservice/SpellCheckerSubtype;->hashCode()I

    move-result v3

    if-ne v2, v3, :cond_39

    invoke-virtual {v0}, Landroid/view/textservice/SpellCheckerSubtype;->getNameResId()I

    move-result v2

    invoke-virtual {p0}, Landroid/view/textservice/SpellCheckerSubtype;->getNameResId()I

    move-result v3

    if-ne v2, v3, :cond_39

    invoke-virtual {v0}, Landroid/view/textservice/SpellCheckerSubtype;->getLocale()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Landroid/view/textservice/SpellCheckerSubtype;->getLocale()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_39

    invoke-virtual {v0}, Landroid/view/textservice/SpellCheckerSubtype;->getExtraValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Landroid/view/textservice/SpellCheckerSubtype;->getExtraValue()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_39

    const/4 v1, 0x1

    .line 146
    .end local v0           #subtype:Landroid/view/textservice/SpellCheckerSubtype;
    :cond_39
    return v1
.end method

.method public getDisplayName(Landroid/content/Context;Ljava/lang/String;Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    .registers 10
    .parameter "context"
    .parameter "packageName"
    .parameter "appInfo"

    .prologue
    .line 180
    iget-object v3, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeLocale:Ljava/lang/String;

    invoke-static {v3}, Landroid/view/textservice/SpellCheckerSubtype;->constructLocaleFromString(Ljava/lang/String;)Ljava/util/Locale;

    move-result-object v0

    .line 181
    .local v0, locale:Ljava/util/Locale;
    if-eqz v0, :cond_11

    invoke-virtual {v0}, Ljava/util/Locale;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    .line 182
    .local v1, localeStr:Ljava/lang/String;
    :goto_c
    iget v3, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeNameResId:I

    if-nez v3, :cond_14

    .line 190
    .end local v1           #localeStr:Ljava/lang/String;
    :cond_10
    :goto_10
    return-object v1

    .line 181
    :cond_11
    iget-object v1, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeLocale:Ljava/lang/String;

    goto :goto_c

    .line 185
    .restart local v1       #localeStr:Ljava/lang/String;
    :cond_14
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    iget v4, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeNameResId:I

    invoke-virtual {v3, p2, v4, p3}, Landroid/content/pm/PackageManager;->getText(Ljava/lang/String;ILandroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v2

    .line 187
    .local v2, subtypeName:Ljava/lang/CharSequence;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_10

    .line 188
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v1, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_10
.end method

.method public getExtraValue()Ljava/lang/String;
    .registers 2

    .prologue
    .line 89
    iget-object v0, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeExtraValue:Ljava/lang/String;

    return-object v0
.end method

.method public getExtraValueOf(Ljava/lang/String;)Ljava/lang/String;
    .registers 3
    .parameter "key"

    .prologue
    .line 129
    invoke-direct {p0}, Landroid/view/textservice/SpellCheckerSubtype;->getExtraValueHashMap()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getLocale()Ljava/lang/String;
    .registers 2

    .prologue
    .line 82
    iget-object v0, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeLocale:Ljava/lang/String;

    return-object v0
.end method

.method public getNameResId()I
    .registers 2

    .prologue
    .line 75
    iget v0, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeNameResId:I

    return v0
.end method

.method public hashCode()I
    .registers 2

    .prologue
    .line 134
    iget v0, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeHashCode:I

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "parcelableFlags"

    .prologue
    .line 201
    iget v0, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeNameResId:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 202
    iget-object v0, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeLocale:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 203
    iget-object v0, p0, Landroid/view/textservice/SpellCheckerSubtype;->mSubtypeExtraValue:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 204
    return-void
.end method
