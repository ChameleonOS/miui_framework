.class public Landroid/net/rtp/AudioCodec;
.super Ljava/lang/Object;
.source "AudioCodec.java"


# static fields
.field public static final AMR:Landroid/net/rtp/AudioCodec;

.field public static final GSM:Landroid/net/rtp/AudioCodec;

.field public static final GSM_EFR:Landroid/net/rtp/AudioCodec;

.field public static final PCMA:Landroid/net/rtp/AudioCodec;

.field public static final PCMU:Landroid/net/rtp/AudioCodec;

.field private static final sCodecs:[Landroid/net/rtp/AudioCodec;


# instance fields
.field public final fmtp:Ljava/lang/String;

.field public final rtpmap:Ljava/lang/String;

.field public final type:I


# direct methods
.method static constructor <clinit>()V
    .registers 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 56
    new-instance v0, Landroid/net/rtp/AudioCodec;

    const-string v1, "PCMU/8000"

    invoke-direct {v0, v4, v1, v3}, Landroid/net/rtp/AudioCodec;-><init>(ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Landroid/net/rtp/AudioCodec;->PCMU:Landroid/net/rtp/AudioCodec;

    .line 61
    new-instance v0, Landroid/net/rtp/AudioCodec;

    const/16 v1, 0x8

    const-string v2, "PCMA/8000"

    invoke-direct {v0, v1, v2, v3}, Landroid/net/rtp/AudioCodec;-><init>(ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Landroid/net/rtp/AudioCodec;->PCMA:Landroid/net/rtp/AudioCodec;

    .line 67
    new-instance v0, Landroid/net/rtp/AudioCodec;

    const-string v1, "GSM/8000"

    invoke-direct {v0, v5, v1, v3}, Landroid/net/rtp/AudioCodec;-><init>(ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Landroid/net/rtp/AudioCodec;->GSM:Landroid/net/rtp/AudioCodec;

    .line 73
    new-instance v0, Landroid/net/rtp/AudioCodec;

    const/16 v1, 0x60

    const-string v2, "GSM-EFR/8000"

    invoke-direct {v0, v1, v2, v3}, Landroid/net/rtp/AudioCodec;-><init>(ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Landroid/net/rtp/AudioCodec;->GSM_EFR:Landroid/net/rtp/AudioCodec;

    .line 80
    new-instance v0, Landroid/net/rtp/AudioCodec;

    const/16 v1, 0x61

    const-string v2, "AMR/8000"

    invoke-direct {v0, v1, v2, v3}, Landroid/net/rtp/AudioCodec;-><init>(ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Landroid/net/rtp/AudioCodec;->AMR:Landroid/net/rtp/AudioCodec;

    .line 82
    const/4 v0, 0x5

    new-array v0, v0, [Landroid/net/rtp/AudioCodec;

    sget-object v1, Landroid/net/rtp/AudioCodec;->GSM_EFR:Landroid/net/rtp/AudioCodec;

    aput-object v1, v0, v4

    const/4 v1, 0x1

    sget-object v2, Landroid/net/rtp/AudioCodec;->AMR:Landroid/net/rtp/AudioCodec;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    sget-object v2, Landroid/net/rtp/AudioCodec;->GSM:Landroid/net/rtp/AudioCodec;

    aput-object v2, v0, v1

    sget-object v1, Landroid/net/rtp/AudioCodec;->PCMU:Landroid/net/rtp/AudioCodec;

    aput-object v1, v0, v5

    const/4 v1, 0x4

    sget-object v2, Landroid/net/rtp/AudioCodec;->PCMA:Landroid/net/rtp/AudioCodec;

    aput-object v2, v0, v1

    sput-object v0, Landroid/net/rtp/AudioCodec;->sCodecs:[Landroid/net/rtp/AudioCodec;

    return-void
.end method

.method private constructor <init>(ILjava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "type"
    .parameter "rtpmap"
    .parameter "fmtp"

    .prologue
    .line 84
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 85
    iput p1, p0, Landroid/net/rtp/AudioCodec;->type:I

    .line 86
    iput-object p2, p0, Landroid/net/rtp/AudioCodec;->rtpmap:Ljava/lang/String;

    .line 87
    iput-object p3, p0, Landroid/net/rtp/AudioCodec;->fmtp:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public static getCodec(ILjava/lang/String;Ljava/lang/String;)Landroid/net/rtp/AudioCodec;
    .registers 12
    .parameter "type"
    .parameter "rtpmap"
    .parameter "fmtp"

    .prologue
    const/4 v7, 0x0

    .line 108
    if-ltz p0, :cond_7

    const/16 v8, 0x7f

    if-le p0, v8, :cond_8

    .line 144
    :cond_7
    :goto_7
    return-object v7

    .line 112
    :cond_8
    const/4 v4, 0x0

    .line 113
    .local v4, hint:Landroid/net/rtp/AudioCodec;
    if-eqz p1, :cond_6a

    .line 114
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v2

    .line 115
    .local v2, clue:Ljava/lang/String;
    sget-object v0, Landroid/net/rtp/AudioCodec;->sCodecs:[Landroid/net/rtp/AudioCodec;

    .local v0, arr$:[Landroid/net/rtp/AudioCodec;
    array-length v6, v0

    .local v6, len$:I
    const/4 v5, 0x0

    .local v5, i$:I
    :goto_17
    if-ge v5, v6, :cond_3c

    aget-object v3, v0, v5

    .line 116
    .local v3, codec:Landroid/net/rtp/AudioCodec;
    iget-object v8, v3, Landroid/net/rtp/AudioCodec;->rtpmap:Ljava/lang/String;

    invoke-virtual {v2, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_67

    .line 117
    iget-object v8, v3, Landroid/net/rtp/AudioCodec;->rtpmap:Ljava/lang/String;

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    invoke-virtual {v2, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    .line 118
    .local v1, channels:Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v8

    if-eqz v8, :cond_3b

    const-string v8, "/1"

    invoke-virtual {v1, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_3c

    .line 119
    :cond_3b
    move-object v4, v3

    .line 134
    .end local v0           #arr$:[Landroid/net/rtp/AudioCodec;
    .end local v1           #channels:Ljava/lang/String;
    .end local v2           #clue:Ljava/lang/String;
    .end local v3           #codec:Landroid/net/rtp/AudioCodec;
    .end local v5           #i$:I
    .end local v6           #len$:I
    :cond_3c
    :goto_3c
    if-eqz v4, :cond_7

    .line 137
    sget-object v8, Landroid/net/rtp/AudioCodec;->AMR:Landroid/net/rtp/AudioCodec;

    if-ne v4, v8, :cond_61

    if-eqz p2, :cond_61

    .line 138
    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    .line 139
    .restart local v2       #clue:Ljava/lang/String;
    const-string v8, "crc=1"

    invoke-virtual {v2, v8}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_7

    const-string/jumbo v8, "robust-sorting=1"

    invoke-virtual {v2, v8}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_7

    const-string v8, "interleaving="

    invoke-virtual {v2, v8}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_7

    .line 144
    .end local v2           #clue:Ljava/lang/String;
    :cond_61
    new-instance v7, Landroid/net/rtp/AudioCodec;

    invoke-direct {v7, p0, p1, p2}, Landroid/net/rtp/AudioCodec;-><init>(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_7

    .line 115
    .restart local v0       #arr$:[Landroid/net/rtp/AudioCodec;
    .restart local v2       #clue:Ljava/lang/String;
    .restart local v3       #codec:Landroid/net/rtp/AudioCodec;
    .restart local v5       #i$:I
    .restart local v6       #len$:I
    :cond_67
    add-int/lit8 v5, v5, 0x1

    goto :goto_17

    .line 124
    .end local v0           #arr$:[Landroid/net/rtp/AudioCodec;
    .end local v2           #clue:Ljava/lang/String;
    .end local v3           #codec:Landroid/net/rtp/AudioCodec;
    .end local v5           #i$:I
    .end local v6           #len$:I
    :cond_6a
    const/16 v8, 0x60

    if-ge p0, v8, :cond_3c

    .line 125
    sget-object v0, Landroid/net/rtp/AudioCodec;->sCodecs:[Landroid/net/rtp/AudioCodec;

    .restart local v0       #arr$:[Landroid/net/rtp/AudioCodec;
    array-length v6, v0

    .restart local v6       #len$:I
    const/4 v5, 0x0

    .restart local v5       #i$:I
    :goto_72
    if-ge v5, v6, :cond_3c

    aget-object v3, v0, v5

    .line 126
    .restart local v3       #codec:Landroid/net/rtp/AudioCodec;
    iget v8, v3, Landroid/net/rtp/AudioCodec;->type:I

    if-ne p0, v8, :cond_7e

    .line 127
    move-object v4, v3

    .line 128
    iget-object p1, v3, Landroid/net/rtp/AudioCodec;->rtpmap:Ljava/lang/String;

    .line 129
    goto :goto_3c

    .line 125
    :cond_7e
    add-int/lit8 v5, v5, 0x1

    goto :goto_72
.end method

.method public static getCodecs()[Landroid/net/rtp/AudioCodec;
    .registers 2

    .prologue
    .line 94
    sget-object v0, Landroid/net/rtp/AudioCodec;->sCodecs:[Landroid/net/rtp/AudioCodec;

    sget-object v1, Landroid/net/rtp/AudioCodec;->sCodecs:[Landroid/net/rtp/AudioCodec;

    array-length v1, v1

    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/net/rtp/AudioCodec;

    return-object v0
.end method
