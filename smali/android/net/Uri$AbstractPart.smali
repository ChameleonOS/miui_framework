.class abstract Landroid/net/Uri$AbstractPart;
.super Ljava/lang/Object;
.source "Uri.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/Uri;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x408
    name = "AbstractPart"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/net/Uri$AbstractPart$Representation;
    }
.end annotation


# instance fields
.field volatile decoded:Ljava/lang/String;

.field volatile encoded:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .registers 3
    .parameter "encoded"
    .parameter "decoded"

    .prologue
    .line 1947
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1948
    iput-object p1, p0, Landroid/net/Uri$AbstractPart;->encoded:Ljava/lang/String;

    .line 1949
    iput-object p2, p0, Landroid/net/Uri$AbstractPart;->decoded:Ljava/lang/String;

    .line 1950
    return-void
.end method


# virtual methods
.method final getDecoded()Ljava/lang/String;
    .registers 4

    .prologue
    .line 1956
    iget-object v1, p0, Landroid/net/Uri$AbstractPart;->decoded:Ljava/lang/String;

    invoke-static {}, Landroid/net/Uri;->access$300()Ljava/lang/String;

    move-result-object v2

    if-eq v1, v2, :cond_e

    const/4 v0, 0x1

    .line 1957
    .local v0, hasDecoded:Z
    :goto_9
    if-eqz v0, :cond_10

    iget-object v1, p0, Landroid/net/Uri$AbstractPart;->decoded:Ljava/lang/String;

    :goto_d
    return-object v1

    .line 1956
    .end local v0           #hasDecoded:Z
    :cond_e
    const/4 v0, 0x0

    goto :goto_9

    .line 1957
    .restart local v0       #hasDecoded:Z
    :cond_10
    iget-object v1, p0, Landroid/net/Uri$AbstractPart;->encoded:Ljava/lang/String;

    invoke-static {v1}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/net/Uri$AbstractPart;->decoded:Ljava/lang/String;

    goto :goto_d
.end method

.method abstract getEncoded()Ljava/lang/String;
.end method

.method final writeTo(Landroid/os/Parcel;)V
    .registers 8
    .parameter "parcel"

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 1962
    iget-object v4, p0, Landroid/net/Uri$AbstractPart;->encoded:Ljava/lang/String;

    invoke-static {}, Landroid/net/Uri;->access$300()Ljava/lang/String;

    move-result-object v5

    if-eq v4, v5, :cond_26

    move v1, v2

    .line 1965
    .local v1, hasEncoded:Z
    :goto_b
    iget-object v4, p0, Landroid/net/Uri$AbstractPart;->decoded:Ljava/lang/String;

    invoke-static {}, Landroid/net/Uri;->access$300()Ljava/lang/String;

    move-result-object v5

    if-eq v4, v5, :cond_28

    move v0, v2

    .line 1967
    .local v0, hasDecoded:Z
    :goto_14
    if-eqz v1, :cond_2a

    if-eqz v0, :cond_2a

    .line 1968
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeInt(I)V

    .line 1969
    iget-object v2, p0, Landroid/net/Uri$AbstractPart;->encoded:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 1970
    iget-object v2, p0, Landroid/net/Uri$AbstractPart;->decoded:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 1980
    :goto_25
    return-void

    .end local v0           #hasDecoded:Z
    .end local v1           #hasEncoded:Z
    :cond_26
    move v1, v3

    .line 1962
    goto :goto_b

    .restart local v1       #hasEncoded:Z
    :cond_28
    move v0, v3

    .line 1965
    goto :goto_14

    .line 1971
    .restart local v0       #hasDecoded:Z
    :cond_2a
    if-eqz v1, :cond_35

    .line 1972
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 1973
    iget-object v2, p0, Landroid/net/Uri$AbstractPart;->encoded:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_25

    .line 1974
    :cond_35
    if-eqz v0, :cond_41

    .line 1975
    const/4 v2, 0x2

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 1976
    iget-object v2, p0, Landroid/net/Uri$AbstractPart;->decoded:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_25

    .line 1978
    :cond_41
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Neither encoded nor decoded"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2
.end method
