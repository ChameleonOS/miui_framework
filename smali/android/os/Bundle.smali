.class public final Landroid/os/Bundle;
.super Ljava/lang/Object;
.source "Bundle.java"

# interfaces
.implements Landroid/os/Parcelable;
.implements Ljava/lang/Cloneable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation
.end field

.field public static final EMPTY:Landroid/os/Bundle; = null

.field private static final LOG_TAG:Ljava/lang/String; = "Bundle"


# instance fields
.field private mAllowFds:Z

.field private mClassLoader:Ljava/lang/ClassLoader;

.field private mFdsKnown:Z

.field private mHasFds:Z

.field mMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field mParcelledData:Landroid/os/Parcel;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    sput-object v0, Landroid/os/Bundle;->EMPTY:Landroid/os/Bundle;

    sget-object v0, Landroid/os/Bundle;->EMPTY:Landroid/os/Bundle;

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    invoke-static {v1}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    iput-object v1, v0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    new-instance v0, Landroid/os/Bundle$1;

    invoke-direct {v0}, Landroid/os/Bundle$1;-><init>()V

    sput-object v0, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .registers 3

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    iput-object v0, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/os/Bundle;->mHasFds:Z

    iput-boolean v1, p0, Landroid/os/Bundle;->mFdsKnown:Z

    iput-boolean v1, p0, Landroid/os/Bundle;->mAllowFds:Z

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    iput-object v0, p0, Landroid/os/Bundle;->mClassLoader:Ljava/lang/ClassLoader;

    return-void
.end method

.method public constructor <init>(I)V
    .registers 4
    .parameter "capacity"

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    iput-object v0, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/os/Bundle;->mHasFds:Z

    iput-boolean v1, p0, Landroid/os/Bundle;->mFdsKnown:Z

    iput-boolean v1, p0, Landroid/os/Bundle;->mAllowFds:Z

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0, p1}, Ljava/util/HashMap;-><init>(I)V

    iput-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    iput-object v0, p0, Landroid/os/Bundle;->mClassLoader:Ljava/lang/ClassLoader;

    return-void
.end method

.method public constructor <init>(Landroid/os/Bundle;)V
    .registers 7
    .parameter "b"

    .prologue
    const/4 v0, 0x1

    const/4 v4, 0x0

    const/4 v3, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    iput-object v3, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    iput-boolean v4, p0, Landroid/os/Bundle;->mHasFds:Z

    iput-boolean v0, p0, Landroid/os/Bundle;->mFdsKnown:Z

    iput-boolean v0, p0, Landroid/os/Bundle;->mAllowFds:Z

    iget-object v0, p1, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    if-eqz v0, :cond_46

    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    iput-object v0, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    iget-object v0, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    iget-object v1, p1, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    iget-object v2, p1, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    invoke-virtual {v2}, Landroid/os/Parcel;->dataSize()I

    move-result v2

    invoke-virtual {v0, v1, v4, v2}, Landroid/os/Parcel;->appendFrom(Landroid/os/Parcel;II)V

    iget-object v0, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    invoke-virtual {v0, v4}, Landroid/os/Parcel;->setDataPosition(I)V

    :goto_2c
    iget-object v0, p1, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    if-eqz v0, :cond_49

    new-instance v0, Ljava/util/HashMap;

    iget-object v1, p1, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    iput-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    :goto_39
    iget-boolean v0, p1, Landroid/os/Bundle;->mHasFds:Z

    iput-boolean v0, p0, Landroid/os/Bundle;->mHasFds:Z

    iget-boolean v0, p1, Landroid/os/Bundle;->mFdsKnown:Z

    iput-boolean v0, p0, Landroid/os/Bundle;->mFdsKnown:Z

    iget-object v0, p1, Landroid/os/Bundle;->mClassLoader:Ljava/lang/ClassLoader;

    iput-object v0, p0, Landroid/os/Bundle;->mClassLoader:Ljava/lang/ClassLoader;

    return-void

    :cond_46
    iput-object v3, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    goto :goto_2c

    :cond_49
    iput-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    goto :goto_39
.end method

.method constructor <init>(Landroid/os/Parcel;)V
    .registers 4
    .parameter "parcelledData"

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    iput-object v0, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/os/Bundle;->mHasFds:Z

    iput-boolean v1, p0, Landroid/os/Bundle;->mFdsKnown:Z

    iput-boolean v1, p0, Landroid/os/Bundle;->mAllowFds:Z

    invoke-virtual {p0, p1}, Landroid/os/Bundle;->readFromParcel(Landroid/os/Parcel;)V

    return-void
.end method

.method constructor <init>(Landroid/os/Parcel;I)V
    .registers 5
    .parameter "parcelledData"
    .parameter "length"

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    iput-object v0, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/os/Bundle;->mHasFds:Z

    iput-boolean v1, p0, Landroid/os/Bundle;->mFdsKnown:Z

    iput-boolean v1, p0, Landroid/os/Bundle;->mAllowFds:Z

    invoke-virtual {p0, p1, p2}, Landroid/os/Bundle;->readFromParcelInner(Landroid/os/Parcel;I)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/ClassLoader;)V
    .registers 4
    .parameter "loader"

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    iput-object v0, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/os/Bundle;->mHasFds:Z

    iput-boolean v1, p0, Landroid/os/Bundle;->mFdsKnown:Z

    iput-boolean v1, p0, Landroid/os/Bundle;->mAllowFds:Z

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    iput-object p1, p0, Landroid/os/Bundle;->mClassLoader:Ljava/lang/ClassLoader;

    return-void
.end method

.method public static forPair(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    new-instance v0, Landroid/os/Bundle;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/os/Bundle;-><init>(I)V

    .local v0, b:Landroid/os/Bundle;
    invoke-virtual {v0, p0, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method private typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V
    .registers 11
    .parameter "key"
    .parameter "value"
    .parameter "className"
    .parameter "e"

    .prologue
    const-string v4, "<null>"

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassCastException;)V

    return-void
.end method

.method private typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassCastException;)V
    .registers 9
    .parameter "key"
    .parameter "value"
    .parameter "className"
    .parameter "defaultValue"
    .parameter "e"

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .local v0, sb:Ljava/lang/StringBuilder;
    const-string v1, "Key "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " expected "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " but value was a "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ".  The default value "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, " was returned."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "Bundle"

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    const-string v1, "Bundle"

    const-string v2, "Attempt to cast generated internal exception:"

    invoke-static {v1, v2, p5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    return-void
.end method


# virtual methods
.method public clear()V
    .registers 2

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/os/Bundle;->mHasFds:Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/os/Bundle;->mFdsKnown:Z

    return-void
.end method

.method public clone()Ljava/lang/Object;
    .registers 2

    .prologue
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0, p0}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    return-object v0
.end method

.method public containsKey(Ljava/lang/String;)Z
    .registers 3
    .parameter "key"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public describeContents()I
    .registers 3

    .prologue
    const/4 v0, 0x0

    .local v0, mask:I
    invoke-virtual {p0}, Landroid/os/Bundle;->hasFileDescriptors()Z

    move-result v1

    if-eqz v1, :cond_9

    or-int/lit8 v0, v0, 0x1

    :cond_9
    return v0
.end method

.method public get(Ljava/lang/String;)Ljava/lang/Object;
    .registers 3
    .parameter "key"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getBoolean(Ljava/lang/String;)Z
    .registers 3
    .parameter "key"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public getBoolean(Ljava/lang/String;Z)Z
    .registers 10
    .parameter "key"
    .parameter "defaultValue"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v1, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .local v3, o:Ljava/lang/Object;
    if-nez v3, :cond_c

    .end local p2
    :goto_b
    return p2

    .restart local p2
    :cond_c
    :try_start_c
    move-object v0, v3

    check-cast v0, Ljava/lang/Boolean;

    move-object v1, v0

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_13
    .catch Ljava/lang/ClassCastException; {:try_start_c .. :try_end_13} :catch_15

    move-result p2

    goto :goto_b

    :catch_15
    move-exception v6

    .local v6, e:Ljava/lang/ClassCastException;
    const-string v4, "Boolean"

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    move-object v1, p0

    move-object v2, p1

    invoke-direct/range {v1 .. v6}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassCastException;)V

    goto :goto_b
.end method

.method public getBooleanArray(Ljava/lang/String;)[Z
    .registers 7
    .parameter "key"

    .prologue
    const/4 v4, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .local v2, o:Ljava/lang/Object;
    if-nez v2, :cond_e

    move-object v3, v4

    :goto_d
    return-object v3

    :cond_e
    :try_start_e
    move-object v0, v2

    check-cast v0, [Z

    move-object v3, v0

    check-cast v3, [Z
    :try_end_14
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_14} :catch_15

    goto :goto_d

    :catch_15
    move-exception v1

    .local v1, e:Ljava/lang/ClassCastException;
    const-string v3, "byte[]"

    invoke-direct {p0, p1, v2, v3, v1}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v3, v4

    goto :goto_d
.end method

.method public getBundle(Ljava/lang/String;)Landroid/os/Bundle;
    .registers 6
    .parameter "key"

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .local v1, o:Ljava/lang/Object;
    if-nez v1, :cond_e

    move-object v1, v2

    .end local v1           #o:Ljava/lang/Object;
    :goto_d
    return-object v1

    .restart local v1       #o:Ljava/lang/Object;
    :cond_e
    :try_start_e
    check-cast v1, Landroid/os/Bundle;
    :try_end_10
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_10} :catch_11

    goto :goto_d

    :catch_11
    move-exception v0

    .local v0, e:Ljava/lang/ClassCastException;
    const-string v3, "Bundle"

    invoke-direct {p0, p1, v1, v3, v0}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v1, v2

    goto :goto_d
.end method

.method public getByte(Ljava/lang/String;)B
    .registers 3
    .parameter "key"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/os/Bundle;->getByte(Ljava/lang/String;B)Ljava/lang/Byte;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Byte;->byteValue()B

    move-result v0

    return v0
.end method

.method public getByte(Ljava/lang/String;B)Ljava/lang/Byte;
    .registers 9
    .parameter "key"
    .parameter "defaultValue"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .local v2, o:Ljava/lang/Object;
    if-nez v2, :cond_10

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    .end local v2           #o:Ljava/lang/Object;
    :goto_f
    return-object v2

    .restart local v2       #o:Ljava/lang/Object;
    :cond_10
    :try_start_10
    check-cast v2, Ljava/lang/Byte;
    :try_end_12
    .catch Ljava/lang/ClassCastException; {:try_start_10 .. :try_end_12} :catch_13

    goto :goto_f

    :catch_13
    move-exception v5

    .local v5, e:Ljava/lang/ClassCastException;
    const-string v3, "Byte"

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v4

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassCastException;)V

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    goto :goto_f
.end method

.method public getByteArray(Ljava/lang/String;)[B
    .registers 7
    .parameter "key"

    .prologue
    const/4 v4, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .local v2, o:Ljava/lang/Object;
    if-nez v2, :cond_e

    move-object v3, v4

    :goto_d
    return-object v3

    :cond_e
    :try_start_e
    move-object v0, v2

    check-cast v0, [B

    move-object v3, v0

    check-cast v3, [B
    :try_end_14
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_14} :catch_15

    goto :goto_d

    :catch_15
    move-exception v1

    .local v1, e:Ljava/lang/ClassCastException;
    const-string v3, "byte[]"

    invoke-direct {p0, p1, v2, v3, v1}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v3, v4

    goto :goto_d
.end method

.method public getChar(Ljava/lang/String;)C
    .registers 3
    .parameter "key"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/os/Bundle;->getChar(Ljava/lang/String;C)C

    move-result v0

    return v0
.end method

.method public getChar(Ljava/lang/String;C)C
    .registers 10
    .parameter "key"
    .parameter "defaultValue"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v1, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .local v3, o:Ljava/lang/Object;
    if-nez v3, :cond_c

    .end local p2
    :goto_b
    return p2

    .restart local p2
    :cond_c
    :try_start_c
    move-object v0, v3

    check-cast v0, Ljava/lang/Character;

    move-object v1, v0

    invoke-virtual {v1}, Ljava/lang/Character;->charValue()C
    :try_end_13
    .catch Ljava/lang/ClassCastException; {:try_start_c .. :try_end_13} :catch_15

    move-result p2

    goto :goto_b

    :catch_15
    move-exception v6

    .local v6, e:Ljava/lang/ClassCastException;
    const-string v4, "Character"

    invoke-static {p2}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v5

    move-object v1, p0

    move-object v2, p1

    invoke-direct/range {v1 .. v6}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassCastException;)V

    goto :goto_b
.end method

.method public getCharArray(Ljava/lang/String;)[C
    .registers 7
    .parameter "key"

    .prologue
    const/4 v4, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .local v2, o:Ljava/lang/Object;
    if-nez v2, :cond_e

    move-object v3, v4

    :goto_d
    return-object v3

    :cond_e
    :try_start_e
    move-object v0, v2

    check-cast v0, [C

    move-object v3, v0

    check-cast v3, [C
    :try_end_14
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_14} :catch_15

    goto :goto_d

    :catch_15
    move-exception v1

    .local v1, e:Ljava/lang/ClassCastException;
    const-string v3, "char[]"

    invoke-direct {p0, p1, v2, v3, v1}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v3, v4

    goto :goto_d
.end method

.method public getCharSequence(Ljava/lang/String;)Ljava/lang/CharSequence;
    .registers 6
    .parameter "key"

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .local v1, o:Ljava/lang/Object;
    if-nez v1, :cond_e

    move-object v1, v2

    .end local v1           #o:Ljava/lang/Object;
    :goto_d
    return-object v1

    .restart local v1       #o:Ljava/lang/Object;
    :cond_e
    :try_start_e
    check-cast v1, Ljava/lang/CharSequence;
    :try_end_10
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_10} :catch_11

    goto :goto_d

    :catch_11
    move-exception v0

    .local v0, e:Ljava/lang/ClassCastException;
    const-string v3, "CharSequence"

    invoke-direct {p0, p1, v1, v3, v0}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v1, v2

    goto :goto_d
.end method

.method public getCharSequence(Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    .registers 6
    .parameter "key"
    .parameter "defaultValue"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v2, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .local v1, o:Ljava/lang/Object;
    if-nez v1, :cond_c

    .end local v1           #o:Ljava/lang/Object;
    .end local p2
    :goto_b
    return-object p2

    .restart local v1       #o:Ljava/lang/Object;
    .restart local p2
    :cond_c
    :try_start_c
    check-cast v1, Ljava/lang/CharSequence;
    :try_end_e
    .catch Ljava/lang/ClassCastException; {:try_start_c .. :try_end_e} :catch_10

    .end local v1           #o:Ljava/lang/Object;
    move-object p2, v1

    goto :goto_b

    .restart local v1       #o:Ljava/lang/Object;
    :catch_10
    move-exception v0

    .local v0, e:Ljava/lang/ClassCastException;
    const-string v2, "CharSequence"

    invoke-direct {p0, p1, v1, v2, v0}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    goto :goto_b
.end method

.method public getCharSequenceArray(Ljava/lang/String;)[Ljava/lang/CharSequence;
    .registers 7
    .parameter "key"

    .prologue
    const/4 v4, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .local v2, o:Ljava/lang/Object;
    if-nez v2, :cond_e

    move-object v3, v4

    :goto_d
    return-object v3

    :cond_e
    :try_start_e
    move-object v0, v2

    check-cast v0, [Ljava/lang/CharSequence;

    move-object v3, v0

    check-cast v3, [Ljava/lang/CharSequence;
    :try_end_14
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_14} :catch_15

    goto :goto_d

    :catch_15
    move-exception v1

    .local v1, e:Ljava/lang/ClassCastException;
    const-string v3, "CharSequence[]"

    invoke-direct {p0, p1, v2, v3, v1}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v3, v4

    goto :goto_d
.end method

.method public getCharSequenceArrayList(Ljava/lang/String;)Ljava/util/ArrayList;
    .registers 6
    .parameter "key"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/CharSequence;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .local v1, o:Ljava/lang/Object;
    if-nez v1, :cond_e

    move-object v1, v2

    .end local v1           #o:Ljava/lang/Object;
    :goto_d
    return-object v1

    .restart local v1       #o:Ljava/lang/Object;
    :cond_e
    :try_start_e
    check-cast v1, Ljava/util/ArrayList;
    :try_end_10
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_10} :catch_11

    goto :goto_d

    :catch_11
    move-exception v0

    .local v0, e:Ljava/lang/ClassCastException;
    const-string v3, "ArrayList<CharSequence>"

    invoke-direct {p0, p1, v1, v3, v0}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v1, v2

    goto :goto_d
.end method

.method public getClassLoader()Ljava/lang/ClassLoader;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/os/Bundle;->mClassLoader:Ljava/lang/ClassLoader;

    return-object v0
.end method

.method public getDouble(Ljava/lang/String;)D
    .registers 4
    .parameter "key"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    const-wide/16 v0, 0x0

    invoke-virtual {p0, p1, v0, v1}, Landroid/os/Bundle;->getDouble(Ljava/lang/String;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public getDouble(Ljava/lang/String;D)D
    .registers 11
    .parameter "key"
    .parameter "defaultValue"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v1, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .local v3, o:Ljava/lang/Object;
    if-nez v3, :cond_c

    .end local p2
    :goto_b
    return-wide p2

    .restart local p2
    :cond_c
    :try_start_c
    move-object v0, v3

    check-cast v0, Ljava/lang/Double;

    move-object v1, v0

    invoke-virtual {v1}, Ljava/lang/Double;->doubleValue()D
    :try_end_13
    .catch Ljava/lang/ClassCastException; {:try_start_c .. :try_end_13} :catch_15

    move-result-wide p2

    goto :goto_b

    :catch_15
    move-exception v6

    .local v6, e:Ljava/lang/ClassCastException;
    const-string v4, "Double"

    invoke-static {p2, p3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v5

    move-object v1, p0

    move-object v2, p1

    invoke-direct/range {v1 .. v6}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassCastException;)V

    goto :goto_b
.end method

.method public getDoubleArray(Ljava/lang/String;)[D
    .registers 7
    .parameter "key"

    .prologue
    const/4 v4, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .local v2, o:Ljava/lang/Object;
    if-nez v2, :cond_e

    move-object v3, v4

    :goto_d
    return-object v3

    :cond_e
    :try_start_e
    move-object v0, v2

    check-cast v0, [D

    move-object v3, v0

    check-cast v3, [D
    :try_end_14
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_14} :catch_15

    goto :goto_d

    :catch_15
    move-exception v1

    .local v1, e:Ljava/lang/ClassCastException;
    const-string v3, "double[]"

    invoke-direct {p0, p1, v2, v3, v1}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v3, v4

    goto :goto_d
.end method

.method public getFloat(Ljava/lang/String;)F
    .registers 3
    .parameter "key"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;F)F

    move-result v0

    return v0
.end method

.method public getFloat(Ljava/lang/String;F)F
    .registers 10
    .parameter "key"
    .parameter "defaultValue"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v1, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .local v3, o:Ljava/lang/Object;
    if-nez v3, :cond_c

    .end local p2
    :goto_b
    return p2

    .restart local p2
    :cond_c
    :try_start_c
    move-object v0, v3

    check-cast v0, Ljava/lang/Float;

    move-object v1, v0

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F
    :try_end_13
    .catch Ljava/lang/ClassCastException; {:try_start_c .. :try_end_13} :catch_15

    move-result p2

    goto :goto_b

    :catch_15
    move-exception v6

    .local v6, e:Ljava/lang/ClassCastException;
    const-string v4, "Float"

    invoke-static {p2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    move-object v1, p0

    move-object v2, p1

    invoke-direct/range {v1 .. v6}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassCastException;)V

    goto :goto_b
.end method

.method public getFloatArray(Ljava/lang/String;)[F
    .registers 7
    .parameter "key"

    .prologue
    const/4 v4, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .local v2, o:Ljava/lang/Object;
    if-nez v2, :cond_e

    move-object v3, v4

    :goto_d
    return-object v3

    :cond_e
    :try_start_e
    move-object v0, v2

    check-cast v0, [F

    move-object v3, v0

    check-cast v3, [F
    :try_end_14
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_14} :catch_15

    goto :goto_d

    :catch_15
    move-exception v1

    .local v1, e:Ljava/lang/ClassCastException;
    const-string v3, "float[]"

    invoke-direct {p0, p1, v2, v3, v1}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v3, v4

    goto :goto_d
.end method

.method public getIBinder(Ljava/lang/String;)Landroid/os/IBinder;
    .registers 6
    .parameter "key"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .local v1, o:Ljava/lang/Object;
    if-nez v1, :cond_e

    move-object v1, v2

    .end local v1           #o:Ljava/lang/Object;
    :goto_d
    return-object v1

    .restart local v1       #o:Ljava/lang/Object;
    :cond_e
    :try_start_e
    check-cast v1, Landroid/os/IBinder;
    :try_end_10
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_10} :catch_11

    goto :goto_d

    :catch_11
    move-exception v0

    .local v0, e:Ljava/lang/ClassCastException;
    const-string v3, "IBinder"

    invoke-direct {p0, p1, v1, v3, v0}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v1, v2

    goto :goto_d
.end method

.method public getInt(Ljava/lang/String;)I
    .registers 3
    .parameter "key"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getInt(Ljava/lang/String;I)I
    .registers 10
    .parameter "key"
    .parameter "defaultValue"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v1, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .local v3, o:Ljava/lang/Object;
    if-nez v3, :cond_c

    .end local p2
    :goto_b
    return p2

    .restart local p2
    :cond_c
    :try_start_c
    move-object v0, v3

    check-cast v0, Ljava/lang/Integer;

    move-object v1, v0

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I
    :try_end_13
    .catch Ljava/lang/ClassCastException; {:try_start_c .. :try_end_13} :catch_15

    move-result p2

    goto :goto_b

    :catch_15
    move-exception v6

    .local v6, e:Ljava/lang/ClassCastException;
    const-string v4, "Integer"

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    move-object v1, p0

    move-object v2, p1

    invoke-direct/range {v1 .. v6}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassCastException;)V

    goto :goto_b
.end method

.method public getIntArray(Ljava/lang/String;)[I
    .registers 7
    .parameter "key"

    .prologue
    const/4 v4, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .local v2, o:Ljava/lang/Object;
    if-nez v2, :cond_e

    move-object v3, v4

    :goto_d
    return-object v3

    :cond_e
    :try_start_e
    move-object v0, v2

    check-cast v0, [I

    move-object v3, v0

    check-cast v3, [I
    :try_end_14
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_14} :catch_15

    goto :goto_d

    :catch_15
    move-exception v1

    .local v1, e:Ljava/lang/ClassCastException;
    const-string v3, "int[]"

    invoke-direct {p0, p1, v2, v3, v1}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v3, v4

    goto :goto_d
.end method

.method public getIntegerArrayList(Ljava/lang/String;)Ljava/util/ArrayList;
    .registers 6
    .parameter "key"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .local v1, o:Ljava/lang/Object;
    if-nez v1, :cond_e

    move-object v1, v2

    .end local v1           #o:Ljava/lang/Object;
    :goto_d
    return-object v1

    .restart local v1       #o:Ljava/lang/Object;
    :cond_e
    :try_start_e
    check-cast v1, Ljava/util/ArrayList;
    :try_end_10
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_10} :catch_11

    goto :goto_d

    :catch_11
    move-exception v0

    .local v0, e:Ljava/lang/ClassCastException;
    const-string v3, "ArrayList<Integer>"

    invoke-direct {p0, p1, v1, v3, v0}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v1, v2

    goto :goto_d
.end method

.method public getLong(Ljava/lang/String;)J
    .registers 4
    .parameter "key"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    const-wide/16 v0, 0x0

    invoke-virtual {p0, p1, v0, v1}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public getLong(Ljava/lang/String;J)J
    .registers 11
    .parameter "key"
    .parameter "defaultValue"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v1, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .local v3, o:Ljava/lang/Object;
    if-nez v3, :cond_c

    .end local p2
    :goto_b
    return-wide p2

    .restart local p2
    :cond_c
    :try_start_c
    move-object v0, v3

    check-cast v0, Ljava/lang/Long;

    move-object v1, v0

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J
    :try_end_13
    .catch Ljava/lang/ClassCastException; {:try_start_c .. :try_end_13} :catch_15

    move-result-wide p2

    goto :goto_b

    :catch_15
    move-exception v6

    .local v6, e:Ljava/lang/ClassCastException;
    const-string v4, "Long"

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    move-object v1, p0

    move-object v2, p1

    invoke-direct/range {v1 .. v6}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassCastException;)V

    goto :goto_b
.end method

.method public getLongArray(Ljava/lang/String;)[J
    .registers 7
    .parameter "key"

    .prologue
    const/4 v4, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .local v2, o:Ljava/lang/Object;
    if-nez v2, :cond_e

    move-object v3, v4

    :goto_d
    return-object v3

    :cond_e
    :try_start_e
    move-object v0, v2

    check-cast v0, [J

    move-object v3, v0

    check-cast v3, [J
    :try_end_14
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_14} :catch_15

    goto :goto_d

    :catch_15
    move-exception v1

    .local v1, e:Ljava/lang/ClassCastException;
    const-string v3, "long[]"

    invoke-direct {p0, p1, v2, v3, v1}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v3, v4

    goto :goto_d
.end method

.method public getPairValue()Ljava/lang/String;
    .registers 7

    .prologue
    const/4 v3, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v4, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->size()I

    move-result v2

    .local v2, size:I
    const/4 v4, 0x1

    if-le v2, v4, :cond_14

    const-string v4, "Bundle"

    const-string v5, "getPairValue() used on Bundle with multiple pairs."

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_14
    if-nez v2, :cond_18

    move-object v1, v3

    :goto_17
    return-object v1

    :cond_18
    iget-object v4, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .local v1, o:Ljava/lang/Object;
    :try_start_26
    check-cast v1, Ljava/lang/String;
    :try_end_28
    .catch Ljava/lang/ClassCastException; {:try_start_26 .. :try_end_28} :catch_29

    goto :goto_17

    :catch_29
    move-exception v0

    .local v0, e:Ljava/lang/ClassCastException;
    const-string v4, "getPairValue()"

    const-string v5, "String"

    invoke-direct {p0, v4, v1, v5, v0}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v1, v3

    goto :goto_17
.end method

.method public getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;
    .registers 6
    .parameter "key"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroid/os/Parcelable;",
            ">(",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .local v1, o:Ljava/lang/Object;
    if-nez v1, :cond_e

    move-object v1, v2

    .end local v1           #o:Ljava/lang/Object;
    :goto_d
    return-object v1

    .restart local v1       #o:Ljava/lang/Object;
    :cond_e
    :try_start_e
    check-cast v1, Landroid/os/Parcelable;
    :try_end_10
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_10} :catch_11

    goto :goto_d

    :catch_11
    move-exception v0

    .local v0, e:Ljava/lang/ClassCastException;
    const-string v3, "Parcelable"

    invoke-direct {p0, p1, v1, v3, v0}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v1, v2

    goto :goto_d
.end method

.method public getParcelableArray(Ljava/lang/String;)[Landroid/os/Parcelable;
    .registers 7
    .parameter "key"

    .prologue
    const/4 v4, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .local v2, o:Ljava/lang/Object;
    if-nez v2, :cond_e

    move-object v3, v4

    :goto_d
    return-object v3

    :cond_e
    :try_start_e
    move-object v0, v2

    check-cast v0, [Landroid/os/Parcelable;

    move-object v3, v0

    check-cast v3, [Landroid/os/Parcelable;
    :try_end_14
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_14} :catch_15

    goto :goto_d

    :catch_15
    move-exception v1

    .local v1, e:Ljava/lang/ClassCastException;
    const-string v3, "Parcelable[]"

    invoke-direct {p0, p1, v2, v3, v1}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v3, v4

    goto :goto_d
.end method

.method public getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;
    .registers 6
    .parameter "key"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroid/os/Parcelable;",
            ">(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<TT;>;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .local v1, o:Ljava/lang/Object;
    if-nez v1, :cond_e

    move-object v1, v2

    .end local v1           #o:Ljava/lang/Object;
    :goto_d
    return-object v1

    .restart local v1       #o:Ljava/lang/Object;
    :cond_e
    :try_start_e
    check-cast v1, Ljava/util/ArrayList;
    :try_end_10
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_10} :catch_11

    goto :goto_d

    :catch_11
    move-exception v0

    .local v0, e:Ljava/lang/ClassCastException;
    const-string v3, "ArrayList"

    invoke-direct {p0, p1, v1, v3, v0}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v1, v2

    goto :goto_d
.end method

.method public getSerializable(Ljava/lang/String;)Ljava/io/Serializable;
    .registers 6
    .parameter "key"

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .local v1, o:Ljava/lang/Object;
    if-nez v1, :cond_e

    move-object v1, v2

    .end local v1           #o:Ljava/lang/Object;
    :goto_d
    return-object v1

    .restart local v1       #o:Ljava/lang/Object;
    :cond_e
    :try_start_e
    check-cast v1, Ljava/io/Serializable;
    :try_end_10
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_10} :catch_11

    goto :goto_d

    :catch_11
    move-exception v0

    .local v0, e:Ljava/lang/ClassCastException;
    const-string v3, "Serializable"

    invoke-direct {p0, p1, v1, v3, v0}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v1, v2

    goto :goto_d
.end method

.method public getShort(Ljava/lang/String;)S
    .registers 3
    .parameter "key"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/os/Bundle;->getShort(Ljava/lang/String;S)S

    move-result v0

    return v0
.end method

.method public getShort(Ljava/lang/String;S)S
    .registers 10
    .parameter "key"
    .parameter "defaultValue"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v1, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .local v3, o:Ljava/lang/Object;
    if-nez v3, :cond_c

    .end local p2
    :goto_b
    return p2

    .restart local p2
    :cond_c
    :try_start_c
    move-object v0, v3

    check-cast v0, Ljava/lang/Short;

    move-object v1, v0

    invoke-virtual {v1}, Ljava/lang/Short;->shortValue()S
    :try_end_13
    .catch Ljava/lang/ClassCastException; {:try_start_c .. :try_end_13} :catch_15

    move-result p2

    goto :goto_b

    :catch_15
    move-exception v6

    .local v6, e:Ljava/lang/ClassCastException;
    const-string v4, "Short"

    invoke-static {p2}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v5

    move-object v1, p0

    move-object v2, p1

    invoke-direct/range {v1 .. v6}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassCastException;)V

    goto :goto_b
.end method

.method public getShortArray(Ljava/lang/String;)[S
    .registers 7
    .parameter "key"

    .prologue
    const/4 v4, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .local v2, o:Ljava/lang/Object;
    if-nez v2, :cond_e

    move-object v3, v4

    :goto_d
    return-object v3

    :cond_e
    :try_start_e
    move-object v0, v2

    check-cast v0, [S

    move-object v3, v0

    check-cast v3, [S
    :try_end_14
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_14} :catch_15

    goto :goto_d

    :catch_15
    move-exception v1

    .local v1, e:Ljava/lang/ClassCastException;
    const-string/jumbo v3, "short[]"

    invoke-direct {p0, p1, v2, v3, v1}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v3, v4

    goto :goto_d
.end method

.method public getSparseParcelableArray(Ljava/lang/String;)Landroid/util/SparseArray;
    .registers 6
    .parameter "key"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroid/os/Parcelable;",
            ">(",
            "Ljava/lang/String;",
            ")",
            "Landroid/util/SparseArray",
            "<TT;>;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .local v1, o:Ljava/lang/Object;
    if-nez v1, :cond_e

    move-object v1, v2

    .end local v1           #o:Ljava/lang/Object;
    :goto_d
    return-object v1

    .restart local v1       #o:Ljava/lang/Object;
    :cond_e
    :try_start_e
    check-cast v1, Landroid/util/SparseArray;
    :try_end_10
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_10} :catch_11

    goto :goto_d

    :catch_11
    move-exception v0

    .local v0, e:Ljava/lang/ClassCastException;
    const-string v3, "SparseArray"

    invoke-direct {p0, p1, v1, v3, v0}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v1, v2

    goto :goto_d
.end method

.method public getString(Ljava/lang/String;)Ljava/lang/String;
    .registers 6
    .parameter "key"

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .local v1, o:Ljava/lang/Object;
    if-nez v1, :cond_e

    move-object v1, v2

    .end local v1           #o:Ljava/lang/Object;
    :goto_d
    return-object v1

    .restart local v1       #o:Ljava/lang/Object;
    :cond_e
    :try_start_e
    check-cast v1, Ljava/lang/String;
    :try_end_10
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_10} :catch_11

    goto :goto_d

    :catch_11
    move-exception v0

    .local v0, e:Ljava/lang/ClassCastException;
    const-string v3, "String"

    invoke-direct {p0, p1, v1, v3, v0}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v1, v2

    goto :goto_d
.end method

.method public getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 6
    .parameter "key"
    .parameter "defaultValue"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v2, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .local v1, o:Ljava/lang/Object;
    if-nez v1, :cond_c

    .end local v1           #o:Ljava/lang/Object;
    .end local p2
    :goto_b
    return-object p2

    .restart local v1       #o:Ljava/lang/Object;
    .restart local p2
    :cond_c
    :try_start_c
    check-cast v1, Ljava/lang/String;
    :try_end_e
    .catch Ljava/lang/ClassCastException; {:try_start_c .. :try_end_e} :catch_10

    .end local v1           #o:Ljava/lang/Object;
    move-object p2, v1

    goto :goto_b

    .restart local v1       #o:Ljava/lang/Object;
    :catch_10
    move-exception v0

    .local v0, e:Ljava/lang/ClassCastException;
    const-string v2, "String"

    invoke-direct {p0, p1, v1, v2, v0}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    goto :goto_b
.end method

.method public getStringArray(Ljava/lang/String;)[Ljava/lang/String;
    .registers 7
    .parameter "key"

    .prologue
    const/4 v4, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .local v2, o:Ljava/lang/Object;
    if-nez v2, :cond_e

    move-object v3, v4

    :goto_d
    return-object v3

    :cond_e
    :try_start_e
    move-object v0, v2

    check-cast v0, [Ljava/lang/String;

    move-object v3, v0

    check-cast v3, [Ljava/lang/String;
    :try_end_14
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_14} :catch_15

    goto :goto_d

    :catch_15
    move-exception v1

    .local v1, e:Ljava/lang/ClassCastException;
    const-string v3, "String[]"

    invoke-direct {p0, p1, v2, v3, v1}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v3, v4

    goto :goto_d
.end method

.method public getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;
    .registers 6
    .parameter "key"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v3, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .local v1, o:Ljava/lang/Object;
    if-nez v1, :cond_e

    move-object v1, v2

    .end local v1           #o:Ljava/lang/Object;
    :goto_d
    return-object v1

    .restart local v1       #o:Ljava/lang/Object;
    :cond_e
    :try_start_e
    check-cast v1, Ljava/util/ArrayList;
    :try_end_10
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_10} :catch_11

    goto :goto_d

    :catch_11
    move-exception v0

    .local v0, e:Ljava/lang/ClassCastException;
    const-string v3, "ArrayList<String>"

    invoke-direct {p0, p1, v1, v3, v0}, Landroid/os/Bundle;->typeWarning(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassCastException;)V

    move-object v1, v2

    goto :goto_d
.end method

.method public hasFileDescriptors()Z
    .registers 9

    .prologue
    iget-boolean v7, p0, Landroid/os/Bundle;->mFdsKnown:Z

    if-nez v7, :cond_17

    const/4 v2, 0x0

    .local v2, fdFound:Z
    iget-object v7, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    if-eqz v7, :cond_1a

    iget-object v7, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    invoke-virtual {v7}, Landroid/os/Parcel;->hasFileDescriptors()Z

    move-result v7

    if-eqz v7, :cond_12

    const/4 v2, 0x1

    :cond_12
    :goto_12
    iput-boolean v2, p0, Landroid/os/Bundle;->mHasFds:Z

    const/4 v7, 0x1

    iput-boolean v7, p0, Landroid/os/Bundle;->mFdsKnown:Z

    .end local v2           #fdFound:Z
    :cond_17
    iget-boolean v7, p0, Landroid/os/Bundle;->mHasFds:Z

    return v7

    .restart local v2       #fdFound:Z
    :cond_1a
    iget-object v7, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, iter:Ljava/util/Iterator;,"Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;>;"
    :cond_24
    :goto_24
    if-nez v2, :cond_12

    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_12

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/Map$Entry;

    invoke-interface {v7}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    .local v5, obj:Ljava/lang/Object;
    instance-of v7, v5, Landroid/os/Parcelable;

    if-eqz v7, :cond_46

    check-cast v5, Landroid/os/Parcelable;

    .end local v5           #obj:Ljava/lang/Object;
    invoke-interface {v5}, Landroid/os/Parcelable;->describeContents()I

    move-result v7

    and-int/lit8 v7, v7, 0x1

    if-eqz v7, :cond_24

    const/4 v2, 0x1

    goto :goto_12

    .restart local v5       #obj:Ljava/lang/Object;
    :cond_46
    instance-of v7, v5, [Landroid/os/Parcelable;

    if-eqz v7, :cond_63

    check-cast v5, [Landroid/os/Parcelable;

    .end local v5           #obj:Ljava/lang/Object;
    move-object v0, v5

    check-cast v0, [Landroid/os/Parcelable;

    .local v0, array:[Landroid/os/Parcelable;
    array-length v7, v0

    add-int/lit8 v4, v7, -0x1

    .local v4, n:I
    :goto_52
    if-ltz v4, :cond_24

    aget-object v7, v0, v4

    invoke-interface {v7}, Landroid/os/Parcelable;->describeContents()I

    move-result v7

    and-int/lit8 v7, v7, 0x1

    if-eqz v7, :cond_60

    const/4 v2, 0x1

    goto :goto_24

    :cond_60
    add-int/lit8 v4, v4, -0x1

    goto :goto_52

    .end local v0           #array:[Landroid/os/Parcelable;
    .end local v4           #n:I
    .restart local v5       #obj:Ljava/lang/Object;
    :cond_63
    instance-of v7, v5, Landroid/util/SparseArray;

    if-eqz v7, :cond_85

    move-object v1, v5

    check-cast v1, Landroid/util/SparseArray;

    .local v1, array:Landroid/util/SparseArray;,"Landroid/util/SparseArray<+Landroid/os/Parcelable;>;"
    invoke-virtual {v1}, Landroid/util/SparseArray;->size()I

    move-result v7

    add-int/lit8 v4, v7, -0x1

    .restart local v4       #n:I
    :goto_70
    if-ltz v4, :cond_24

    invoke-virtual {v1, v4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/os/Parcelable;

    invoke-interface {v7}, Landroid/os/Parcelable;->describeContents()I

    move-result v7

    and-int/lit8 v7, v7, 0x1

    if-eqz v7, :cond_82

    const/4 v2, 0x1

    goto :goto_24

    :cond_82
    add-int/lit8 v4, v4, -0x1

    goto :goto_70

    .end local v1           #array:Landroid/util/SparseArray;,"Landroid/util/SparseArray<+Landroid/os/Parcelable;>;"
    .end local v4           #n:I
    :cond_85
    instance-of v7, v5, Ljava/util/ArrayList;

    if-eqz v7, :cond_24

    move-object v0, v5

    check-cast v0, Ljava/util/ArrayList;

    .local v0, array:Ljava/util/ArrayList;
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lez v7, :cond_24

    const/4 v7, 0x0

    invoke-virtual {v0, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    instance-of v7, v7, Landroid/os/Parcelable;

    if-eqz v7, :cond_24

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v7

    add-int/lit8 v4, v7, -0x1

    .restart local v4       #n:I
    :goto_a1
    if-ltz v4, :cond_24

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/os/Parcelable;

    .local v6, p:Landroid/os/Parcelable;
    if-eqz v6, :cond_b6

    invoke-interface {v6}, Landroid/os/Parcelable;->describeContents()I

    move-result v7

    and-int/lit8 v7, v7, 0x1

    if-eqz v7, :cond_b6

    const/4 v2, 0x1

    goto/16 :goto_24

    :cond_b6
    add-int/lit8 v4, v4, -0x1

    goto :goto_a1
.end method

.method public isEmpty()Z
    .registers 2

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public isParcelled()Z
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    if-eqz v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public keySet()Ljava/util/Set;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public putAll(Landroid/os/Bundle;)V
    .registers 4
    .parameter "map"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    invoke-virtual {p1}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    iget-object v1, p1, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, v1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    iget-boolean v0, p0, Landroid/os/Bundle;->mHasFds:Z

    iget-boolean v1, p1, Landroid/os/Bundle;->mHasFds:Z

    or-int/2addr v0, v1

    iput-boolean v0, p0, Landroid/os/Bundle;->mHasFds:Z

    iget-boolean v0, p0, Landroid/os/Bundle;->mFdsKnown:Z

    if-eqz v0, :cond_20

    iget-boolean v0, p1, Landroid/os/Bundle;->mFdsKnown:Z

    if-eqz v0, :cond_20

    const/4 v0, 0x1

    :goto_1d
    iput-boolean v0, p0, Landroid/os/Bundle;->mFdsKnown:Z

    return-void

    :cond_20
    const/4 v0, 0x0

    goto :goto_1d
.end method

.method public putBoolean(Ljava/lang/String;Z)V
    .registers 5
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putBooleanArray(Ljava/lang/String;[Z)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putBundle(Ljava/lang/String;Landroid/os/Bundle;)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putByte(Ljava/lang/String;B)V
    .registers 5
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putByteArray(Ljava/lang/String;[B)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putChar(Ljava/lang/String;C)V
    .registers 5
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putCharArray(Ljava/lang/String;[C)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putCharSequence(Ljava/lang/String;Ljava/lang/CharSequence;)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putCharSequenceArray(Ljava/lang/String;[Ljava/lang/CharSequence;)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putCharSequenceArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V
    .registers 4
    .parameter "key"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/CharSequence;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, value:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/CharSequence;>;"
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putDouble(Ljava/lang/String;D)V
    .registers 6
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-static {p2, p3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putDoubleArray(Ljava/lang/String;[D)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putFloat(Ljava/lang/String;F)V
    .registers 5
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putFloatArray(Ljava/lang/String;[F)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putIBinder(Ljava/lang/String;Landroid/os/IBinder;)V
    .registers 4
    .parameter "key"
    .parameter "value"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putInt(Ljava/lang/String;I)V
    .registers 5
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putIntArray(Ljava/lang/String;[I)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putIntegerArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V
    .registers 4
    .parameter "key"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, value:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putLong(Ljava/lang/String;J)V
    .registers 6
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putLongArray(Ljava/lang/String;[J)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/os/Bundle;->mFdsKnown:Z

    return-void
.end method

.method public putParcelableArray(Ljava/lang/String;[Landroid/os/Parcelable;)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/os/Bundle;->mFdsKnown:Z

    return-void
.end method

.method public putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V
    .registers 4
    .parameter "key"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<+",
            "Landroid/os/Parcelable;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, value:Ljava/util/ArrayList;,"Ljava/util/ArrayList<+Landroid/os/Parcelable;>;"
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/os/Bundle;->mFdsKnown:Z

    return-void
.end method

.method public putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putShort(Ljava/lang/String;S)V
    .registers 5
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putShortArray(Ljava/lang/String;[S)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putSparseParcelableArray(Ljava/lang/String;Landroid/util/SparseArray;)V
    .registers 4
    .parameter "key"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Landroid/util/SparseArray",
            "<+",
            "Landroid/os/Parcelable;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, value:Landroid/util/SparseArray;,"Landroid/util/SparseArray<+Landroid/os/Parcelable;>;"
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/os/Bundle;->mFdsKnown:Z

    return-void
.end method

.method public putString(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putStringArray(Ljava/lang/String;[Ljava/lang/String;)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V
    .registers 4
    .parameter "key"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, value:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public readFromParcel(Landroid/os/Parcel;)V
    .registers 6
    .parameter "parcel"

    .prologue
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .local v0, length:I
    if-gez v0, :cond_1f

    new-instance v1, Ljava/lang/RuntimeException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Bad length in parcel: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_1f
    invoke-virtual {p0, p1, v0}, Landroid/os/Bundle;->readFromParcelInner(Landroid/os/Parcel;I)V

    return-void
.end method

.method readFromParcelInner(Landroid/os/Parcel;I)V
    .registers 11
    .parameter "parcel"
    .parameter "length"

    .prologue
    const/4 v7, 0x0

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .local v0, magic:I
    const v4, 0x4c444e42

    if-eq v0, v4, :cond_34

    new-instance v4, Ljava/lang/RuntimeException;

    invoke-direct {v4}, Ljava/lang/RuntimeException;-><init>()V

    invoke-static {v4}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v3

    .local v3, st:Ljava/lang/String;
    const-string v4, "Bundle"

    const-string/jumbo v5, "readBundle: bad magic number"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    const-string v4, "Bundle"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "readBundle: trace = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .end local v3           #st:Ljava/lang/String;
    :cond_34
    invoke-virtual {p1}, Landroid/os/Parcel;->dataPosition()I

    move-result v1

    .local v1, offset:I
    add-int v4, v1, p2

    invoke-virtual {p1, v4}, Landroid/os/Parcel;->setDataPosition(I)V

    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v2

    .local v2, p:Landroid/os/Parcel;
    invoke-virtual {v2, v7}, Landroid/os/Parcel;->setDataPosition(I)V

    invoke-virtual {v2, p1, v1, p2}, Landroid/os/Parcel;->appendFrom(Landroid/os/Parcel;II)V

    invoke-virtual {v2, v7}, Landroid/os/Parcel;->setDataPosition(I)V

    iput-object v2, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    invoke-virtual {v2}, Landroid/os/Parcel;->hasFileDescriptors()Z

    move-result v4

    iput-boolean v4, p0, Landroid/os/Bundle;->mHasFds:Z

    const/4 v4, 0x1

    iput-boolean v4, p0, Landroid/os/Bundle;->mFdsKnown:Z

    return-void
.end method

.method public remove(Ljava/lang/String;)V
    .registers 3
    .parameter "key"

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public setAllowFds(Z)Z
    .registers 3
    .parameter "allowFds"

    .prologue
    iget-boolean v0, p0, Landroid/os/Bundle;->mAllowFds:Z

    .local v0, orig:Z
    iput-boolean p1, p0, Landroid/os/Bundle;->mAllowFds:Z

    return v0
.end method

.method public setClassLoader(Ljava/lang/ClassLoader;)V
    .registers 2
    .parameter "loader"

    .prologue
    iput-object p1, p0, Landroid/os/Bundle;->mClassLoader:Ljava/lang/ClassLoader;

    return-void
.end method

.method public size()I
    .registers 2

    .prologue
    invoke-virtual {p0}, Landroid/os/Bundle;->unparcel()V

    iget-object v0, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    return v0
.end method

.method public declared-synchronized toString()Ljava/lang/String;
    .registers 3

    .prologue
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    if-eqz v0, :cond_26

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Bundle[mParcelledData.dataSize="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    invoke-virtual {v1}, Landroid/os/Parcel;->dataSize()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_23
    .catchall {:try_start_1 .. :try_end_23} :catchall_46

    move-result-object v0

    :goto_24
    monitor-exit p0

    return-object v0

    :cond_26
    :try_start_26
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Bundle["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_44
    .catchall {:try_start_26 .. :try_end_44} :catchall_46

    move-result-object v0

    goto :goto_24

    :catchall_46
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized unparcel()V
    .registers 5

    .prologue
    monitor-enter p0

    :try_start_1
    iget-object v1, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_2c

    if-nez v1, :cond_7

    :cond_5
    :goto_5
    monitor-exit p0

    return-void

    :cond_7
    :try_start_7
    iget-object v1, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    invoke-virtual {v1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .local v0, N:I
    if-ltz v0, :cond_5

    iget-object v1, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    if-nez v1, :cond_1a

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    :cond_1a
    iget-object v1, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    iget-object v2, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    iget-object v3, p0, Landroid/os/Bundle;->mClassLoader:Ljava/lang/ClassLoader;

    invoke-virtual {v1, v2, v0, v3}, Landroid/os/Parcel;->readMapInternal(Ljava/util/Map;ILjava/lang/ClassLoader;)V

    iget-object v1, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    const/4 v1, 0x0

    iput-object v1, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;
    :try_end_2b
    .catchall {:try_start_7 .. :try_end_2b} :catchall_2c

    goto :goto_5

    .end local v0           #N:I
    :catchall_2c
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 9
    .parameter "parcel"
    .parameter "flags"

    .prologue
    iget-boolean v4, p0, Landroid/os/Bundle;->mAllowFds:Z

    invoke-virtual {p1, v4}, Landroid/os/Parcel;->pushAllowFds(Z)Z

    move-result v2

    .local v2, oldAllowFds:Z
    :try_start_6
    iget-object v4, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    if-eqz v4, :cond_23

    iget-object v4, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    invoke-virtual {v4}, Landroid/os/Parcel;->dataSize()I

    move-result v0

    .local v0, length:I
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    const v4, 0x4c444e42

    invoke-virtual {p1, v4}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v4, p0, Landroid/os/Bundle;->mParcelledData:Landroid/os/Parcel;

    const/4 v5, 0x0

    invoke-virtual {p1, v4, v5, v0}, Landroid/os/Parcel;->appendFrom(Landroid/os/Parcel;II)V
    :try_end_1f
    .catchall {:try_start_6 .. :try_end_1f} :catchall_48

    :goto_1f
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->restoreAllowFds(Z)V

    return-void

    .end local v0           #length:I
    :cond_23
    const/4 v4, -0x1

    :try_start_24
    invoke-virtual {p1, v4}, Landroid/os/Parcel;->writeInt(I)V

    const v4, 0x4c444e42

    invoke-virtual {p1, v4}, Landroid/os/Parcel;->writeInt(I)V

    invoke-virtual {p1}, Landroid/os/Parcel;->dataPosition()I

    move-result v3

    .local v3, oldPos:I
    iget-object v4, p0, Landroid/os/Bundle;->mMap:Ljava/util/Map;

    invoke-virtual {p1, v4}, Landroid/os/Parcel;->writeMapInternal(Ljava/util/Map;)V

    invoke-virtual {p1}, Landroid/os/Parcel;->dataPosition()I

    move-result v1

    .local v1, newPos:I
    add-int/lit8 v4, v3, -0x8

    invoke-virtual {p1, v4}, Landroid/os/Parcel;->setDataPosition(I)V

    sub-int v0, v1, v3

    .restart local v0       #length:I
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    invoke-virtual {p1, v1}, Landroid/os/Parcel;->setDataPosition(I)V
    :try_end_47
    .catchall {:try_start_24 .. :try_end_47} :catchall_48

    goto :goto_1f

    .end local v0           #length:I
    .end local v1           #newPos:I
    .end local v3           #oldPos:I
    :catchall_48
    move-exception v4

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->restoreAllowFds(Z)V

    throw v4
.end method
