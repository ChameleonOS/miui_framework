.class public final Landroid/nfc/NdefMessage;
.super Ljava/lang/Object;
.source "NdefMessage.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/nfc/NdefMessage;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mRecords:[Landroid/nfc/NdefRecord;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 216
    new-instance v0, Landroid/nfc/NdefMessage$1;

    invoke-direct {v0}, Landroid/nfc/NdefMessage$1;-><init>()V

    sput-object v0, Landroid/nfc/NdefMessage;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public varargs constructor <init>(Landroid/nfc/NdefRecord;[Landroid/nfc/NdefRecord;)V
    .registers 11
    .parameter "record"
    .parameter "records"

    .prologue
    const/4 v7, 0x0

    .line 111
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 113
    if-nez p1, :cond_f

    new-instance v4, Ljava/lang/NullPointerException;

    const-string/jumbo v5, "record cannot be null"

    invoke-direct {v4, v5}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 115
    :cond_f
    move-object v0, p2

    .local v0, arr$:[Landroid/nfc/NdefRecord;
    array-length v2, v0

    .local v2, len$:I
    const/4 v1, 0x0

    .local v1, i$:I
    :goto_12
    if-ge v1, v2, :cond_24

    aget-object v3, v0, v1

    .line 116
    .local v3, r:Landroid/nfc/NdefRecord;
    if-nez v3, :cond_21

    .line 117
    new-instance v4, Ljava/lang/NullPointerException;

    const-string/jumbo v5, "record cannot be null"

    invoke-direct {v4, v5}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 115
    :cond_21
    add-int/lit8 v1, v1, 0x1

    goto :goto_12

    .line 121
    .end local v3           #r:Landroid/nfc/NdefRecord;
    :cond_24
    array-length v4, p2

    add-int/lit8 v4, v4, 0x1

    new-array v4, v4, [Landroid/nfc/NdefRecord;

    iput-object v4, p0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    .line 122
    iget-object v4, p0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    aput-object p1, v4, v7

    .line 123
    iget-object v4, p0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    const/4 v5, 0x1

    array-length v6, p2

    invoke-static {p2, v7, v4, v5, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 124
    return-void
.end method

.method public constructor <init>([B)V
    .registers 5
    .parameter "data"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/nfc/FormatException;
        }
    .end annotation

    .prologue
    .line 94
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 95
    if-nez p1, :cond_d

    new-instance v1, Ljava/lang/NullPointerException;

    const-string v2, "data is null"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 96
    :cond_d
    invoke-static {p1}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 98
    .local v0, buffer:Ljava/nio/ByteBuffer;
    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/nfc/NdefRecord;->parse(Ljava/nio/ByteBuffer;Z)[Landroid/nfc/NdefRecord;

    move-result-object v1

    iput-object v1, p0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    .line 100
    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v1

    if-lez v1, :cond_27

    .line 101
    new-instance v1, Landroid/nfc/FormatException;

    const-string/jumbo v2, "trailing data"

    invoke-direct {v1, v2}, Landroid/nfc/FormatException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 103
    :cond_27
    return-void
.end method

.method public constructor <init>([Landroid/nfc/NdefRecord;)V
    .registers 8
    .parameter "records"

    .prologue
    .line 131
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 133
    array-length v4, p1

    const/4 v5, 0x1

    if-ge v4, v5, :cond_10

    .line 134
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v5, "must have at least one record"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 136
    :cond_10
    move-object v0, p1

    .local v0, arr$:[Landroid/nfc/NdefRecord;
    array-length v2, v0

    .local v2, len$:I
    const/4 v1, 0x0

    .local v1, i$:I
    :goto_13
    if-ge v1, v2, :cond_25

    aget-object v3, v0, v1

    .line 137
    .local v3, r:Landroid/nfc/NdefRecord;
    if-nez v3, :cond_22

    .line 138
    new-instance v4, Ljava/lang/NullPointerException;

    const-string/jumbo v5, "records cannot contain null"

    invoke-direct {v4, v5}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 136
    :cond_22
    add-int/lit8 v1, v1, 0x1

    goto :goto_13

    .line 142
    .end local v3           #r:Landroid/nfc/NdefRecord;
    :cond_25
    iput-object p1, p0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    .line 143
    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 207
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 6
    .parameter "obj"

    .prologue
    const/4 v1, 0x0

    .line 242
    if-ne p0, p1, :cond_5

    const/4 v1, 0x1

    .line 246
    :cond_4
    :goto_4
    return v1

    .line 243
    :cond_5
    if-eqz p1, :cond_4

    .line 244
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-ne v2, v3, :cond_4

    move-object v0, p1

    .line 245
    check-cast v0, Landroid/nfc/NdefMessage;

    .line 246
    .local v0, other:Landroid/nfc/NdefMessage;
    iget-object v1, p0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    iget-object v2, v0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    invoke-static {v1, v2}, Ljava/util/Arrays;->equals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result v1

    goto :goto_4
.end method

.method public getByteArrayLength()I
    .registers 7

    .prologue
    .line 174
    const/4 v3, 0x0

    .line 175
    .local v3, length:I
    iget-object v0, p0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    .local v0, arr$:[Landroid/nfc/NdefRecord;
    array-length v2, v0

    .local v2, len$:I
    const/4 v1, 0x0

    .local v1, i$:I
    :goto_5
    if-ge v1, v2, :cond_11

    aget-object v4, v0, v1

    .line 176
    .local v4, r:Landroid/nfc/NdefRecord;
    invoke-virtual {v4}, Landroid/nfc/NdefRecord;->getByteLength()I

    move-result v5

    add-int/2addr v3, v5

    .line 175
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    .line 178
    .end local v4           #r:Landroid/nfc/NdefRecord;
    :cond_11
    return v3
.end method

.method public getRecords()[Landroid/nfc/NdefRecord;
    .registers 2

    .prologue
    .line 157
    iget-object v0, p0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    return-object v0
.end method

.method public hashCode()I
    .registers 2

    .prologue
    .line 233
    iget-object v0, p0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    invoke-static {v0}, Ljava/util/Arrays;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public toByteArray()[B
    .registers 9

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 193
    invoke-virtual {p0}, Landroid/nfc/NdefMessage;->getByteArrayLength()I

    move-result v2

    .line 194
    .local v2, length:I
    invoke-static {v2}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 196
    .local v0, buffer:Ljava/nio/ByteBuffer;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_b
    iget-object v7, p0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    array-length v7, v7

    if-ge v1, v7, :cond_29

    .line 197
    if-nez v1, :cond_25

    move v3, v5

    .line 198
    .local v3, mb:Z
    :goto_13
    iget-object v7, p0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    array-length v7, v7

    add-int/lit8 v7, v7, -0x1

    if-ne v1, v7, :cond_27

    move v4, v5

    .line 199
    .local v4, me:Z
    :goto_1b
    iget-object v7, p0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    aget-object v7, v7, v1

    invoke-virtual {v7, v0, v3, v4}, Landroid/nfc/NdefRecord;->writeToByteBuffer(Ljava/nio/ByteBuffer;ZZ)V

    .line 196
    add-int/lit8 v1, v1, 0x1

    goto :goto_b

    .end local v3           #mb:Z
    .end local v4           #me:Z
    :cond_25
    move v3, v6

    .line 197
    goto :goto_13

    .restart local v3       #mb:Z
    :cond_27
    move v4, v6

    .line 198
    goto :goto_1b

    .line 202
    .end local v3           #mb:Z
    :cond_29
    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v5

    return-object v5
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    .line 251
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "NdefMessage "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    invoke-static {v1}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 212
    iget-object v0, p0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    array-length v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 213
    iget-object v0, p0, Landroid/nfc/NdefMessage;->mRecords:[Landroid/nfc/NdefRecord;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeTypedArray([Landroid/os/Parcelable;I)V

    .line 214
    return-void
.end method
