.class public final Landroid/nfc/tech/NdefFormatable;
.super Landroid/nfc/tech/BasicTagTechnology;
.source "NdefFormatable.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "NFC"


# direct methods
.method public constructor <init>(Landroid/nfc/Tag;)V
    .registers 3
    .parameter "tag"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 73
    const/4 v0, 0x7

    invoke-direct {p0, p1, v0}, Landroid/nfc/tech/BasicTagTechnology;-><init>(Landroid/nfc/Tag;I)V

    .line 74
    return-void
.end method

.method public static get(Landroid/nfc/Tag;)Landroid/nfc/tech/NdefFormatable;
    .registers 4
    .parameter "tag"

    .prologue
    const/4 v1, 0x0

    .line 60
    const/4 v2, 0x7

    invoke-virtual {p0, v2}, Landroid/nfc/Tag;->hasTech(I)Z

    move-result v2

    if-nez v2, :cond_9

    .line 64
    :goto_8
    return-object v1

    .line 62
    :cond_9
    :try_start_9
    new-instance v2, Landroid/nfc/tech/NdefFormatable;

    invoke-direct {v2, p0}, Landroid/nfc/tech/NdefFormatable;-><init>(Landroid/nfc/Tag;)V
    :try_end_e
    .catch Landroid/os/RemoteException; {:try_start_9 .. :try_end_e} :catch_10

    move-object v1, v2

    goto :goto_8

    .line 63
    :catch_10
    move-exception v0

    .line 64
    .local v0, e:Landroid/os/RemoteException;
    goto :goto_8
.end method


# virtual methods
.method public bridge synthetic close()V
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 47
    invoke-super {p0}, Landroid/nfc/tech/BasicTagTechnology;->close()V

    return-void
.end method

.method public bridge synthetic connect()V
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 47
    invoke-super {p0}, Landroid/nfc/tech/BasicTagTechnology;->connect()V

    return-void
.end method

.method public format(Landroid/nfc/NdefMessage;)V
    .registers 3
    .parameter "firstMessage"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Landroid/nfc/FormatException;
        }
    .end annotation

    .prologue
    .line 95
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/nfc/tech/NdefFormatable;->format(Landroid/nfc/NdefMessage;Z)V

    .line 96
    return-void
.end method

.method format(Landroid/nfc/NdefMessage;Z)V
    .registers 9
    .parameter "firstMessage"
    .parameter "makeReadOnly"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Landroid/nfc/FormatException;
        }
    .end annotation

    .prologue
    .line 122
    invoke-virtual {p0}, Landroid/nfc/tech/NdefFormatable;->checkConnected()V

    .line 125
    :try_start_3
    iget-object v4, p0, Landroid/nfc/tech/BasicTagTechnology;->mTag:Landroid/nfc/Tag;

    invoke-virtual {v4}, Landroid/nfc/Tag;->getServiceHandle()I

    move-result v2

    .line 126
    .local v2, serviceHandle:I
    iget-object v4, p0, Landroid/nfc/tech/BasicTagTechnology;->mTag:Landroid/nfc/Tag;

    invoke-virtual {v4}, Landroid/nfc/Tag;->getTagService()Landroid/nfc/INfcTag;

    move-result-object v3

    .line 127
    .local v3, tagService:Landroid/nfc/INfcTag;
    sget-object v4, Landroid/nfc/tech/MifareClassic;->KEY_DEFAULT:[B

    invoke-interface {v3, v2, v4}, Landroid/nfc/INfcTag;->formatNdef(I[B)I

    move-result v1

    .line 128
    .local v1, errorCode:I
    sparse-switch v1, :sswitch_data_76

    .line 137
    new-instance v4, Ljava/io/IOException;

    invoke-direct {v4}, Ljava/io/IOException;-><init>()V

    throw v4
    :try_end_1e
    .catch Landroid/os/RemoteException; {:try_start_3 .. :try_end_1e} :catch_1e

    .line 175
    .end local v1           #errorCode:I
    .end local v2           #serviceHandle:I
    .end local v3           #tagService:Landroid/nfc/INfcTag;
    :catch_1e
    move-exception v0

    .line 176
    .local v0, e:Landroid/os/RemoteException;
    const-string v4, "NFC"

    const-string v5, "NFC service dead"

    invoke-static {v4, v5, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 178
    .end local v0           #e:Landroid/os/RemoteException;
    :cond_26
    :sswitch_26
    return-void

    .line 132
    .restart local v1       #errorCode:I
    .restart local v2       #serviceHandle:I
    .restart local v3       #tagService:Landroid/nfc/INfcTag;
    :sswitch_27
    :try_start_27
    new-instance v4, Ljava/io/IOException;

    invoke-direct {v4}, Ljava/io/IOException;-><init>()V

    throw v4

    .line 134
    :sswitch_2d
    new-instance v4, Landroid/nfc/FormatException;

    invoke-direct {v4}, Landroid/nfc/FormatException;-><init>()V

    throw v4

    .line 140
    :sswitch_33
    invoke-interface {v3, v2}, Landroid/nfc/INfcTag;->isNdef(I)Z

    move-result v4

    if-nez v4, :cond_3f

    .line 141
    new-instance v4, Ljava/io/IOException;

    invoke-direct {v4}, Ljava/io/IOException;-><init>()V

    throw v4

    .line 145
    :cond_3f
    if-eqz p1, :cond_5a

    .line 146
    invoke-interface {v3, v2, p1}, Landroid/nfc/INfcTag;->ndefWrite(ILandroid/nfc/NdefMessage;)I

    move-result v1

    .line 147
    sparse-switch v1, :sswitch_data_84

    .line 156
    new-instance v4, Ljava/io/IOException;

    invoke-direct {v4}, Ljava/io/IOException;-><init>()V

    throw v4

    .line 151
    :sswitch_4e
    new-instance v4, Ljava/io/IOException;

    invoke-direct {v4}, Ljava/io/IOException;-><init>()V

    throw v4

    .line 153
    :sswitch_54
    new-instance v4, Landroid/nfc/FormatException;

    invoke-direct {v4}, Landroid/nfc/FormatException;-><init>()V

    throw v4

    .line 161
    :cond_5a
    :sswitch_5a
    if-eqz p2, :cond_26

    .line 162
    invoke-interface {v3, v2}, Landroid/nfc/INfcTag;->ndefMakeReadOnly(I)I

    move-result v1

    .line 163
    sparse-switch v1, :sswitch_data_92

    .line 172
    new-instance v4, Ljava/io/IOException;

    invoke-direct {v4}, Ljava/io/IOException;-><init>()V

    throw v4

    .line 167
    :sswitch_69
    new-instance v4, Ljava/io/IOException;

    invoke-direct {v4}, Ljava/io/IOException;-><init>()V

    throw v4

    .line 169
    :sswitch_6f
    new-instance v4, Ljava/io/IOException;

    invoke-direct {v4}, Ljava/io/IOException;-><init>()V

    throw v4
    :try_end_75
    .catch Landroid/os/RemoteException; {:try_start_27 .. :try_end_75} :catch_1e

    .line 128
    nop

    :sswitch_data_76
    .sparse-switch
        -0x8 -> :sswitch_2d
        -0x1 -> :sswitch_27
        0x0 -> :sswitch_33
    .end sparse-switch

    .line 147
    :sswitch_data_84
    .sparse-switch
        -0x8 -> :sswitch_54
        -0x1 -> :sswitch_4e
        0x0 -> :sswitch_5a
    .end sparse-switch

    .line 163
    :sswitch_data_92
    .sparse-switch
        -0x8 -> :sswitch_6f
        -0x1 -> :sswitch_69
        0x0 -> :sswitch_26
    .end sparse-switch
.end method

.method public formatReadOnly(Landroid/nfc/NdefMessage;)V
    .registers 3
    .parameter "firstMessage"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Landroid/nfc/FormatException;
        }
    .end annotation

    .prologue
    .line 117
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Landroid/nfc/tech/NdefFormatable;->format(Landroid/nfc/NdefMessage;Z)V

    .line 118
    return-void
.end method

.method public bridge synthetic getTag()Landroid/nfc/Tag;
    .registers 2

    .prologue
    .line 47
    invoke-super {p0}, Landroid/nfc/tech/BasicTagTechnology;->getTag()Landroid/nfc/Tag;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic isConnected()Z
    .registers 2

    .prologue
    .line 47
    invoke-super {p0}, Landroid/nfc/tech/BasicTagTechnology;->isConnected()Z

    move-result v0

    return v0
.end method

.method public bridge synthetic reconnect()V
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 47
    invoke-super {p0}, Landroid/nfc/tech/BasicTagTechnology;->reconnect()V

    return-void
.end method
