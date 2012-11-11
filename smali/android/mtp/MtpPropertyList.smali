.class Landroid/mtp/MtpPropertyList;
.super Ljava/lang/Object;
.source "MtpPropertyList.java"


# instance fields
.field private mCount:I

.field public final mDataTypes:[I

.field public mLongValues:[J

.field private final mMaxCount:I

.field public final mObjectHandles:[I

.field public final mPropertyCodes:[I

.field public mResult:I

.field public mStringValues:[Ljava/lang/String;


# direct methods
.method public constructor <init>(II)V
    .registers 4
    .parameter "maxCount"
    .parameter "result"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroid/mtp/MtpPropertyList;->mMaxCount:I

    iput p2, p0, Landroid/mtp/MtpPropertyList;->mResult:I

    new-array v0, p1, [I

    iput-object v0, p0, Landroid/mtp/MtpPropertyList;->mObjectHandles:[I

    new-array v0, p1, [I

    iput-object v0, p0, Landroid/mtp/MtpPropertyList;->mPropertyCodes:[I

    new-array v0, p1, [I

    iput-object v0, p0, Landroid/mtp/MtpPropertyList;->mDataTypes:[I

    return-void
.end method


# virtual methods
.method public append(IIIJ)V
    .registers 8
    .parameter "handle"
    .parameter "property"
    .parameter "type"
    .parameter "value"

    .prologue
    iget v0, p0, Landroid/mtp/MtpPropertyList;->mCount:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Landroid/mtp/MtpPropertyList;->mCount:I

    .local v0, index:I
    iget-object v1, p0, Landroid/mtp/MtpPropertyList;->mLongValues:[J

    if-nez v1, :cond_10

    iget v1, p0, Landroid/mtp/MtpPropertyList;->mMaxCount:I

    new-array v1, v1, [J

    iput-object v1, p0, Landroid/mtp/MtpPropertyList;->mLongValues:[J

    :cond_10
    iget-object v1, p0, Landroid/mtp/MtpPropertyList;->mObjectHandles:[I

    aput p1, v1, v0

    iget-object v1, p0, Landroid/mtp/MtpPropertyList;->mPropertyCodes:[I

    aput p2, v1, v0

    iget-object v1, p0, Landroid/mtp/MtpPropertyList;->mDataTypes:[I

    aput p3, v1, v0

    iget-object v1, p0, Landroid/mtp/MtpPropertyList;->mLongValues:[J

    aput-wide p4, v1, v0

    return-void
.end method

.method public append(IILjava/lang/String;)V
    .registers 7
    .parameter "handle"
    .parameter "property"
    .parameter "value"

    .prologue
    iget v0, p0, Landroid/mtp/MtpPropertyList;->mCount:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Landroid/mtp/MtpPropertyList;->mCount:I

    .local v0, index:I
    iget-object v1, p0, Landroid/mtp/MtpPropertyList;->mStringValues:[Ljava/lang/String;

    if-nez v1, :cond_10

    iget v1, p0, Landroid/mtp/MtpPropertyList;->mMaxCount:I

    new-array v1, v1, [Ljava/lang/String;

    iput-object v1, p0, Landroid/mtp/MtpPropertyList;->mStringValues:[Ljava/lang/String;

    :cond_10
    iget-object v1, p0, Landroid/mtp/MtpPropertyList;->mObjectHandles:[I

    aput p1, v1, v0

    iget-object v1, p0, Landroid/mtp/MtpPropertyList;->mPropertyCodes:[I

    aput p2, v1, v0

    iget-object v1, p0, Landroid/mtp/MtpPropertyList;->mDataTypes:[I

    const v2, 0xffff

    aput v2, v1, v0

    iget-object v1, p0, Landroid/mtp/MtpPropertyList;->mStringValues:[Ljava/lang/String;

    aput-object p3, v1, v0

    return-void
.end method

.method public setResult(I)V
    .registers 2
    .parameter "result"

    .prologue
    iput p1, p0, Landroid/mtp/MtpPropertyList;->mResult:I

    return-void
.end method
