.class public Landroid/content/ClipDescription;
.super Ljava/lang/Object;
.source "ClipDescription.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/content/ClipDescription;",
            ">;"
        }
    .end annotation
.end field

.field public static final MIMETYPE_TEXT_HTML:Ljava/lang/String; = "text/html"

.field public static final MIMETYPE_TEXT_INTENT:Ljava/lang/String; = "text/vnd.android.intent"

.field public static final MIMETYPE_TEXT_PLAIN:Ljava/lang/String; = "text/plain"

.field public static final MIMETYPE_TEXT_URILIST:Ljava/lang/String; = "text/uri-list"


# instance fields
.field final mLabel:Ljava/lang/CharSequence;

.field final mMimeTypes:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 240
    new-instance v0, Landroid/content/ClipDescription$1;

    invoke-direct {v0}, Landroid/content/ClipDescription$1;-><init>()V

    sput-object v0, Landroid/content/ClipDescription;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/content/ClipDescription;)V
    .registers 3
    .parameter "o"

    .prologue
    .line 82
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 83
    iget-object v0, p1, Landroid/content/ClipDescription;->mLabel:Ljava/lang/CharSequence;

    iput-object v0, p0, Landroid/content/ClipDescription;->mLabel:Ljava/lang/CharSequence;

    .line 84
    iget-object v0, p1, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    iput-object v0, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    .line 85
    return-void
.end method

.method constructor <init>(Landroid/os/Parcel;)V
    .registers 3
    .parameter "in"

    .prologue
    .line 235
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 236
    sget-object v0, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p1}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    iput-object v0, p0, Landroid/content/ClipDescription;->mLabel:Ljava/lang/CharSequence;

    .line 237
    invoke-virtual {p1}, Landroid/os/Parcel;->createStringArray()[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    .line 238
    return-void
.end method

.method public constructor <init>(Ljava/lang/CharSequence;[Ljava/lang/String;)V
    .registers 5
    .parameter "label"
    .parameter "mimeTypes"

    .prologue
    .line 71
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 72
    if-nez p2, :cond_e

    .line 73
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "mimeTypes is null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 75
    :cond_e
    iput-object p1, p0, Landroid/content/ClipDescription;->mLabel:Ljava/lang/CharSequence;

    .line 76
    iput-object p2, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    .line 77
    return-void
.end method

.method public static compareMimeTypes(Ljava/lang/String;Ljava/lang/String;)Z
    .registers 8
    .parameter "concreteType"
    .parameter "desiredType"

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 94
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    .line 95
    .local v1, typeLength:I
    const/4 v4, 0x3

    if-ne v1, v4, :cond_12

    const-string v4, "*/*"

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_12

    .line 110
    :cond_11
    :goto_11
    return v2

    .line 99
    :cond_12
    const/16 v4, 0x2f

    invoke-virtual {p1, v4}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    .line 100
    .local v0, slashpos:I
    if-lez v0, :cond_30

    .line 101
    add-int/lit8 v4, v0, 0x2

    if-ne v1, v4, :cond_32

    add-int/lit8 v4, v0, 0x1

    invoke-virtual {p1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0x2a

    if-ne v4, v5, :cond_32

    .line 102
    add-int/lit8 v4, v0, 0x1

    invoke-virtual {p1, v3, p0, v3, v4}, Ljava/lang/String;->regionMatches(ILjava/lang/String;II)Z

    move-result v4

    if-nez v4, :cond_11

    :cond_30
    move v2, v3

    .line 110
    goto :goto_11

    .line 105
    :cond_32
    invoke-virtual {p1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_30

    goto :goto_11
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 226
    const/4 v0, 0x0

    return v0
.end method

.method public filterMimeTypes(Ljava/lang/String;)[Ljava/lang/String;
    .registers 6
    .parameter "mimeType"

    .prologue
    .line 145
    const/4 v0, 0x0

    .line 146
    .local v0, array:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v1, 0x0

    .local v1, i:I
    :goto_2
    iget-object v3, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    array-length v3, v3

    if-ge v1, v3, :cond_22

    .line 147
    iget-object v3, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    aget-object v3, v3, v1

    invoke-static {v3, p1}, Landroid/content/ClipDescription;->compareMimeTypes(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1f

    .line 148
    if-nez v0, :cond_18

    .line 149
    new-instance v0, Ljava/util/ArrayList;

    .end local v0           #array:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 151
    .restart local v0       #array:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_18
    iget-object v3, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    aget-object v3, v3, v1

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 146
    :cond_1f
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 154
    :cond_22
    if-nez v0, :cond_26

    .line 155
    const/4 v2, 0x0

    .line 159
    :goto_25
    return-object v2

    .line 157
    :cond_26
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v3

    new-array v2, v3, [Ljava/lang/String;

    .line 158
    .local v2, rawArray:[Ljava/lang/String;
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    goto :goto_25
.end method

.method public getLabel()Ljava/lang/CharSequence;
    .registers 2

    .prologue
    .line 117
    iget-object v0, p0, Landroid/content/ClipDescription;->mLabel:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public getMimeType(I)Ljava/lang/String;
    .registers 3
    .parameter "index"

    .prologue
    .line 173
    iget-object v0, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getMimeTypeCount()I
    .registers 2

    .prologue
    .line 166
    iget-object v0, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public hasMimeType(Ljava/lang/String;)Z
    .registers 4
    .parameter "mimeType"

    .prologue
    .line 128
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    iget-object v1, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    array-length v1, v1

    if-ge v0, v1, :cond_15

    .line 129
    iget-object v1, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    aget-object v1, v1, v0

    invoke-static {v1, p1}, Landroid/content/ClipDescription;->compareMimeTypes(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_12

    .line 130
    const/4 v1, 0x1

    .line 133
    :goto_11
    return v1

    .line 128
    :cond_12
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 133
    :cond_15
    const/4 v1, 0x0

    goto :goto_11
.end method

.method public toShortString(Ljava/lang/StringBuilder;)Z
    .registers 7
    .parameter "b"

    .prologue
    const/16 v4, 0x22

    const/16 v3, 0x20

    .line 204
    const/4 v0, 0x1

    .line 205
    .local v0, first:Z
    const/4 v1, 0x0

    .local v1, i:I
    :goto_6
    iget-object v2, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    array-length v2, v2

    if-ge v1, v2, :cond_1b

    .line 206
    if-nez v0, :cond_10

    .line 207
    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 209
    :cond_10
    const/4 v0, 0x0

    .line 210
    iget-object v2, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    aget-object v2, v2, v1

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 205
    add-int/lit8 v1, v1, 0x1

    goto :goto_6

    .line 212
    :cond_1b
    iget-object v2, p0, Landroid/content/ClipDescription;->mLabel:Ljava/lang/CharSequence;

    if-eqz v2, :cond_30

    .line 213
    if-nez v0, :cond_24

    .line 214
    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 216
    :cond_24
    const/4 v0, 0x0

    .line 217
    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 218
    iget-object v2, p0, Landroid/content/ClipDescription;->mLabel:Ljava/lang/CharSequence;

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    .line 219
    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 221
    :cond_30
    if-nez v0, :cond_34

    const/4 v2, 0x1

    :goto_33
    return v2

    :cond_34
    const/4 v2, 0x0

    goto :goto_33
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    .line 193
    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x80

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 195
    .local v0, b:Ljava/lang/StringBuilder;
    const-string v1, "ClipDescription { "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 196
    invoke-virtual {p0, v0}, Landroid/content/ClipDescription;->toShortString(Ljava/lang/StringBuilder;)Z

    .line 197
    const-string v1, " }"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 199
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public validate()V
    .registers 5

    .prologue
    .line 178
    iget-object v1, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    if-nez v1, :cond_d

    .line 179
    new-instance v1, Ljava/lang/NullPointerException;

    const-string/jumbo v2, "null mime types"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 181
    :cond_d
    iget-object v1, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    array-length v1, v1

    if-gtz v1, :cond_1b

    .line 182
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "must have at least 1 mime type"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 184
    :cond_1b
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1c
    iget-object v1, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    array-length v1, v1

    if-ge v0, v1, :cond_4a

    .line 185
    iget-object v1, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    aget-object v1, v1, v0

    if-nez v1, :cond_47

    .line 186
    new-instance v1, Ljava/lang/NullPointerException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "mime type at "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " is null"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 184
    :cond_47
    add-int/lit8 v0, v0, 0x1

    goto :goto_1c

    .line 189
    :cond_4a
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 231
    iget-object v0, p0, Landroid/content/ClipDescription;->mLabel:Ljava/lang/CharSequence;

    invoke-static {v0, p1, p2}, Landroid/text/TextUtils;->writeToParcel(Ljava/lang/CharSequence;Landroid/os/Parcel;I)V

    .line 232
    iget-object v0, p0, Landroid/content/ClipDescription;->mMimeTypes:[Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeStringArray([Ljava/lang/String;)V

    .line 233
    return-void
.end method
