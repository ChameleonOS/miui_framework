.class public final Landroid/view/inputmethod/CompletionInfo;
.super Ljava/lang/Object;
.source "CompletionInfo.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/view/inputmethod/CompletionInfo;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mId:J

.field private final mLabel:Ljava/lang/CharSequence;

.field private final mPosition:I

.field private final mText:Ljava/lang/CharSequence;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 115
    new-instance v0, Landroid/view/inputmethod/CompletionInfo$1;

    invoke-direct {v0}, Landroid/view/inputmethod/CompletionInfo$1;-><init>()V

    sput-object v0, Landroid/view/inputmethod/CompletionInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(JILjava/lang/CharSequence;)V
    .registers 6
    .parameter "id"
    .parameter "index"
    .parameter "text"

    .prologue
    .line 36
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-wide p1, p0, Landroid/view/inputmethod/CompletionInfo;->mId:J

    .line 38
    iput p3, p0, Landroid/view/inputmethod/CompletionInfo;->mPosition:I

    .line 39
    iput-object p4, p0, Landroid/view/inputmethod/CompletionInfo;->mText:Ljava/lang/CharSequence;

    .line 40
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/view/inputmethod/CompletionInfo;->mLabel:Ljava/lang/CharSequence;

    .line 41
    return-void
.end method

.method public constructor <init>(JILjava/lang/CharSequence;Ljava/lang/CharSequence;)V
    .registers 6
    .parameter "id"
    .parameter "index"
    .parameter "text"
    .parameter "label"

    .prologue
    .line 46
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput-wide p1, p0, Landroid/view/inputmethod/CompletionInfo;->mId:J

    .line 48
    iput p3, p0, Landroid/view/inputmethod/CompletionInfo;->mPosition:I

    .line 49
    iput-object p4, p0, Landroid/view/inputmethod/CompletionInfo;->mText:Ljava/lang/CharSequence;

    .line 50
    iput-object p5, p0, Landroid/view/inputmethod/CompletionInfo;->mLabel:Ljava/lang/CharSequence;

    .line 51
    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .registers 4
    .parameter "source"

    .prologue
    .line 53
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 54
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/view/inputmethod/CompletionInfo;->mId:J

    .line 55
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/view/inputmethod/CompletionInfo;->mPosition:I

    .line 56
    sget-object v0, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p1}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    iput-object v0, p0, Landroid/view/inputmethod/CompletionInfo;->mText:Ljava/lang/CharSequence;

    .line 57
    sget-object v0, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p1}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    iput-object v0, p0, Landroid/view/inputmethod/CompletionInfo;->mLabel:Ljava/lang/CharSequence;

    .line 58
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Landroid/view/inputmethod/CompletionInfo$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 27
    invoke-direct {p0, p1}, Landroid/view/inputmethod/CompletionInfo;-><init>(Landroid/os/Parcel;)V

    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 127
    const/4 v0, 0x0

    return v0
.end method

.method public getId()J
    .registers 3

    .prologue
    .line 65
    iget-wide v0, p0, Landroid/view/inputmethod/CompletionInfo;->mId:J

    return-wide v0
.end method

.method public getLabel()Ljava/lang/CharSequence;
    .registers 2

    .prologue
    .line 90
    iget-object v0, p0, Landroid/view/inputmethod/CompletionInfo;->mLabel:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public getPosition()I
    .registers 2

    .prologue
    .line 73
    iget v0, p0, Landroid/view/inputmethod/CompletionInfo;->mPosition:I

    return v0
.end method

.method public getText()Ljava/lang/CharSequence;
    .registers 2

    .prologue
    .line 81
    iget-object v0, p0, Landroid/view/inputmethod/CompletionInfo;->mText:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    .line 95
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "CompletionInfo{#"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/view/inputmethod/CompletionInfo;->mPosition:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " \""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/view/inputmethod/CompletionInfo;->mText:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\" id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Landroid/view/inputmethod/CompletionInfo;->mId:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " label="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/view/inputmethod/CompletionInfo;->mLabel:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 5
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 106
    iget-wide v0, p0, Landroid/view/inputmethod/CompletionInfo;->mId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 107
    iget v0, p0, Landroid/view/inputmethod/CompletionInfo;->mPosition:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 108
    iget-object v0, p0, Landroid/view/inputmethod/CompletionInfo;->mText:Ljava/lang/CharSequence;

    invoke-static {v0, p1, p2}, Landroid/text/TextUtils;->writeToParcel(Ljava/lang/CharSequence;Landroid/os/Parcel;I)V

    .line 109
    iget-object v0, p0, Landroid/view/inputmethod/CompletionInfo;->mLabel:Ljava/lang/CharSequence;

    invoke-static {v0, p1, p2}, Landroid/text/TextUtils;->writeToParcel(Ljava/lang/CharSequence;Landroid/os/Parcel;I)V

    .line 110
    return-void
.end method
