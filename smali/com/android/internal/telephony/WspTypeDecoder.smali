.class public Lcom/android/internal/telephony/WspTypeDecoder;
.super Ljava/lang/Object;
.source "WspTypeDecoder.java"


# static fields
.field public static final CONTENT_TYPE_B_MMS:Ljava/lang/String; = "application/vnd.wap.mms-message"

.field public static final CONTENT_TYPE_B_PUSH_CO:Ljava/lang/String; = "application/vnd.wap.coc"

.field public static final CONTENT_TYPE_B_PUSH_SYNCML_NOTI:Ljava/lang/String; = "application/vnd.syncml.notification"

.field public static final PARAMETER_ID_X_WAP_APPLICATION_ID:I = 0x2f

.field public static final PDU_TYPE_CONFIRMED_PUSH:I = 0x7

.field public static final PDU_TYPE_PUSH:I = 0x6

.field private static final Q_VALUE:I = 0x0

.field private static final WAP_PDU_LENGTH_QUOTE:I = 0x1f

.field private static final WAP_PDU_SHORT_LENGTH_MAX:I = 0x1e

.field private static final WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field contentParameters:Ljava/util/HashMap;
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

.field dataLength:I

.field stringValue:Ljava/lang/String;

.field unsigned32bit:J

.field wspData:[B


# direct methods
.method static constructor <clinit>()V
    .registers 8

    .prologue
    const/4 v7, 0x7

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "*/*"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/*"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/html"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/plain"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/4 v1, 0x4

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/x-hdml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/4 v1, 0x5

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/x-ttml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/4 v1, 0x6

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/x-vCalendar"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/x-vCard"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x8

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/vnd.wap.wml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x9

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/vnd.wap.wmlscript"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0xa

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/vnd.wap.wta-event"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0xb

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "multipart/*"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0xc

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "multipart/mixed"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0xd

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "multipart/form-data"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0xe

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "multipart/byterantes"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0xf

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "multipart/alternative"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x10

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/*"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x11

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/java-vm"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x12

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/x-www-form-urlencoded"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x13

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/x-hdmlc"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x14

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.wmlc"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x15

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.wmlscriptc"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x16

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.wta-eventc"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x17

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.uaprof"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x18

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.wtls-ca-certificate"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x19

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.wtls-user-certificate"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x1a

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/x-x509-ca-cert"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x1b

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/x-x509-user-cert"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x1c

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "image/*"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x1d

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "image/gif"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x1e

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "image/jpeg"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x1f

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "image/tiff"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x20

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "image/png"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x21

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "image/vnd.wap.wbmp"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x22

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.multipart.*"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x23

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.multipart.mixed"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x24

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.multipart.form-data"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x25

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.multipart.byteranges"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x26

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.multipart.alternative"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x27

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x28

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x29

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x2a

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/x-x968-cross-cert"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x2b

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/x-x968-ca-cert"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x2c

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/x-x968-user-cert"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x2d

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/vnd.wap.si"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x2e

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.sic"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x2f

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/vnd.wap.sl"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x30

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.slc"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x31

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/vnd.wap.co"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x32

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.coc"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x33

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.multipart.related"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x34

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.sia"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x35

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/vnd.wap.connectivity-xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x36

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.connectivity-wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x37

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/pkcs7-mime"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x38

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.hashed-certificate"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x39

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.signed-certificate"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x3a

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.cert-response"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x3b

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/xhtml+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x3c

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/wml+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x3d

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/css"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x3e

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.mms-message"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x3f

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.rollover-certificate"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x40

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.locc+wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x41

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.loc+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x42

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.syncml.dm+wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x43

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.syncml.dm+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x44

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.syncml.notification"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x45

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.xhtml+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x46

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wv.csp.cir"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x47

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.oma.dd+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x48

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.oma.drm.message"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x49

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.oma.drm.content"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x4a

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.oma.drm.rights+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x4b

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.oma.drm.rights+wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x4c

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wv.csp+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x4d

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wv.csp+wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x4e

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.syncml.ds.notification"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x4f

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "audio/*"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x50

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "video/*"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x51

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.oma.dd2+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x52

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/mikey"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x53

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.oma.dcd"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x54

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.oma.dcdc"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x201

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.uplanet.cacheop-wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x202

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.uplanet.signal"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x203

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.uplanet.alert-wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x204

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.uplanet.list-wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x205

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.uplanet.listcmd-wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x206

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.uplanet.channel-wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x207

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.uplanet.provisioning-status-uri"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x208

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "x-wap.multipart/vnd.uplanet.header-set"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x209

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.uplanet.bearer-choice-wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x20a

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.phonecom.mmc-wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x20b

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.nokia.syncset+wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x20c

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "image/x-up-wpng"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x300

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/iota.mmc-wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x301

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/iota.mmc-xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x302

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.syncml+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x303

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.syncml+wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x304

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/vnd.wap.emn+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x305

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/calendar"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x306

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.omads-email+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x307

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.omads-file+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x308

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.omads-folder+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x309

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "text/directory;profile=vCard"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x30a

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wap.emn+wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x30b

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.nokia.ipdc-purchase-response"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x30c

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.motorola.screen3+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x30d

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.motorola.screen3+gzip"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x30e

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.cmcc.setting+wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x30f

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.cmcc.bombing+wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x310

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.docomo.pf"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x311

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.docomo.ub"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x312

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.omaloc-supl-init"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x313

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.oma.group-usage-list+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x314

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/oma-directory+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x315

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.docomo.pf2"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x316

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.oma.drm.roap-trigger+wbxml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x317

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.sbm.mid2"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x318

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.wmf.bootstrap"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x319

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnc.cmcc.dcd+xml"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x31a

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.sbm.cid"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    const/16 v1, 0x31b

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "application/vnd.oma.bcast.provisioningtrigger"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Q"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Charset"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Level"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Type"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Differences"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x8

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Padding"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x9

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Type"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0xe

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Max-Age"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x10

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Secure"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x11

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "SEC"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x12

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "MAC"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x13

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Creation-date"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x14

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Modification-date"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x15

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Read-date"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x16

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Size"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x17

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Name"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x18

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Filename"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x19

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Start"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x1a

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Start-info"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x1b

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Comment"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x1c

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Domain"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    const/16 v1, 0x1d

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "Path"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>([B)V
    .registers 2
    .parameter "pdu"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    return-void
.end method

.method private decodeNoValue(I)Z
    .registers 4
    .parameter "startIndex"

    .prologue
    const/4 v0, 0x1

    iget-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v1, v1, p1

    if-nez v1, :cond_a

    iput v0, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method private expandWellKnownMimeType()V
    .registers 4

    .prologue
    iget-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    if-nez v1, :cond_16

    iget-wide v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    long-to-int v0, v1

    .local v0, binaryContentType:I
    sget-object v1, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_MIME_TYPES:Ljava/util/HashMap;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    iput-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    .end local v0           #binaryContentType:I
    :goto_15
    return-void

    :cond_16
    const-wide/16 v1, -0x1

    iput-wide v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    goto :goto_15
.end method

.method private readContentParameters(III)Z
    .registers 15
    .parameter "startIndex"
    .parameter "leftToRead"
    .parameter "accumulator"

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    const/4 v3, 0x0

    .local v3, totalRead:I
    if-lez p2, :cond_bd

    iget-object v8, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v1, v8, p1

    .local v1, nextByte:B
    const/4 v4, 0x0

    .local v4, value:Ljava/lang/String;
    const/4 v2, 0x0

    .local v2, param:Ljava/lang/String;
    and-int/lit16 v8, v1, 0x80

    if-nez v8, :cond_37

    const/16 v8, 0x1f

    if-le v1, v8, :cond_37

    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeTokenText(I)Z

    iget-object v2, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    iget v6, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/2addr v3, v6

    :cond_1b
    add-int v6, p1, v3

    invoke-direct {p0, v6}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeNoValue(I)Z

    move-result v6

    if-eqz v6, :cond_8d

    iget v6, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/2addr v3, v6

    const/4 v4, 0x0

    :cond_27
    :goto_27
    iget-object v6, p0, Lcom/android/internal/telephony/WspTypeDecoder;->contentParameters:Ljava/util/HashMap;

    invoke-virtual {v6, v2, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    add-int v6, p1, v3

    sub-int v7, p2, v3

    add-int v8, p3, v3

    invoke-direct {p0, v6, v7, v8}, Lcom/android/internal/telephony/WspTypeDecoder;->readContentParameters(III)Z

    move-result v6

    .end local v1           #nextByte:B
    .end local v2           #param:Ljava/lang/String;
    .end local v4           #value:Ljava/lang/String;
    :cond_36
    :goto_36
    return v6

    .restart local v1       #nextByte:B
    .restart local v2       #param:Ljava/lang/String;
    .restart local v4       #value:Ljava/lang/String;
    :cond_37
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeIntegerValue(I)Z

    move-result v8

    if-eqz v8, :cond_36

    iget v8, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/2addr v3, v8

    iget-wide v8, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    long-to-int v5, v8

    .local v5, wellKnownParameterValue:I
    sget-object v8, Lcom/android/internal/telephony/WspTypeDecoder;->WELL_KNOWN_PARAMETERS:Ljava/util/HashMap;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .end local v2           #param:Ljava/lang/String;
    check-cast v2, Ljava/lang/String;

    .restart local v2       #param:Ljava/lang/String;
    if-nez v2, :cond_6a

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "unassigned/0x"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    int-to-long v9, v5

    invoke-static {v9, v10}, Ljava/lang/Long;->toHexString(J)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    :cond_6a
    if-nez v5, :cond_1b

    add-int v7, p1, v3

    invoke-virtual {p0, v7}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeUintvarInteger(I)Z

    move-result v7

    if-eqz v7, :cond_36

    iget v6, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/2addr v3, v6

    iget-wide v6, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    iget-object v6, p0, Lcom/android/internal/telephony/WspTypeDecoder;->contentParameters:Ljava/util/HashMap;

    invoke-virtual {v6, v2, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    add-int v6, p1, v3

    sub-int v7, p2, v3

    add-int v8, p3, v3

    invoke-direct {p0, v6, v7, v8}, Lcom/android/internal/telephony/WspTypeDecoder;->readContentParameters(III)Z

    move-result v6

    goto :goto_36

    .end local v5           #wellKnownParameterValue:I
    :cond_8d
    add-int v6, p1, v3

    invoke-virtual {p0, v6}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeIntegerValue(I)Z

    move-result v6

    if-eqz v6, :cond_a5

    iget v6, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/2addr v3, v6

    iget-wide v6, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    long-to-int v0, v6

    .local v0, intValue:I
    if-nez v0, :cond_a0

    const-string v4, ""

    goto :goto_27

    :cond_a0
    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    goto :goto_27

    .end local v0           #intValue:I
    :cond_a5
    add-int v6, p1, v3

    invoke-virtual {p0, v6}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeTokenText(I)Z

    iget v6, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/2addr v3, v6

    iget-object v4, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    const-string v6, "\""

    invoke-virtual {v4, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_27

    invoke-virtual {v4, v7}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    goto/16 :goto_27

    .end local v1           #nextByte:B
    .end local v2           #param:Ljava/lang/String;
    .end local v4           #value:Ljava/lang/String;
    :cond_bd
    iput p3, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    move v6, v7

    goto/16 :goto_36
.end method


# virtual methods
.method public decodeConstrainedEncoding(I)Z
    .registers 4
    .parameter "startIndex"

    .prologue
    const/4 v0, 0x1

    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeShortInteger(I)Z

    move-result v1

    if-ne v1, v0, :cond_b

    const/4 v1, 0x0

    iput-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    :goto_a
    return v0

    :cond_b
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeExtensionMedia(I)Z

    move-result v0

    goto :goto_a
.end method

.method public decodeContentLength(I)Z
    .registers 3
    .parameter "startIndex"

    .prologue
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeIntegerValue(I)Z

    move-result v0

    return v0
.end method

.method public decodeContentLocation(I)Z
    .registers 3
    .parameter "startIndex"

    .prologue
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeTextString(I)Z

    move-result v0

    return v0
.end method

.method public decodeContentType(I)Z
    .registers 14
    .parameter "startIndex"

    .prologue
    const/4 v1, 0x1

    const/4 v8, 0x0

    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    iput-object v9, p0, Lcom/android/internal/telephony/WspTypeDecoder;->contentParameters:Ljava/util/HashMap;

    :try_start_9
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeValueLength(I)Z

    move-result v9

    if-nez v9, :cond_19

    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeConstrainedEncoding(I)Z

    move-result v1

    .local v1, found:Z
    if-eqz v1, :cond_18

    invoke-direct {p0}, Lcom/android/internal/telephony/WspTypeDecoder;->expandWellKnownMimeType()V

    .end local v1           #found:Z
    :cond_18
    :goto_18
    return v1

    :cond_19
    iget-wide v9, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    long-to-int v2, v9

    .local v2, headersLength:I
    invoke-virtual {p0}, Lcom/android/internal/telephony/WspTypeDecoder;->getDecodedDataLength()I

    move-result v3

    .local v3, mediaPrefixLength:I
    add-int v9, p1, v3

    invoke-virtual {p0, v9}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeIntegerValue(I)Z

    move-result v9

    if-ne v9, v1, :cond_57

    iget v9, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/2addr v9, v3

    iput v9, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    iget v5, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    .local v5, readLength:I
    const/4 v9, 0x0

    iput-object v9, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    invoke-direct {p0}, Lcom/android/internal/telephony/WspTypeDecoder;->expandWellKnownMimeType()V

    iget-wide v6, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    .local v6, wellKnownValue:J
    iget-object v4, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    .local v4, mimeType:Ljava/lang/String;
    iget v9, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/2addr v9, p1

    iget v10, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    sub-int/2addr v10, v3

    sub-int v10, v2, v10

    const/4 v11, 0x0

    invoke-direct {p0, v9, v10, v11}, Lcom/android/internal/telephony/WspTypeDecoder;->readContentParameters(III)Z

    move-result v9

    if-eqz v9, :cond_55

    iget v9, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/2addr v9, v5

    iput v9, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    iput-wide v6, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    iput-object v4, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    goto :goto_18

    .end local v2           #headersLength:I
    .end local v3           #mediaPrefixLength:I
    .end local v4           #mimeType:Ljava/lang/String;
    .end local v5           #readLength:I
    .end local v6           #wellKnownValue:J
    :catch_52
    move-exception v0

    .local v0, e:Ljava/lang/ArrayIndexOutOfBoundsException;
    move v1, v8

    goto :goto_18

    .end local v0           #e:Ljava/lang/ArrayIndexOutOfBoundsException;
    .restart local v2       #headersLength:I
    .restart local v3       #mediaPrefixLength:I
    .restart local v4       #mimeType:Ljava/lang/String;
    .restart local v5       #readLength:I
    .restart local v6       #wellKnownValue:J
    :cond_55
    move v1, v8

    goto :goto_18

    .end local v4           #mimeType:Ljava/lang/String;
    .end local v5           #readLength:I
    .end local v6           #wellKnownValue:J
    :cond_57
    add-int v9, p1, v3

    invoke-virtual {p0, v9}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeExtensionMedia(I)Z

    move-result v9

    if-ne v9, v1, :cond_86

    iget v9, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/2addr v9, v3

    iput v9, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    iget v5, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    .restart local v5       #readLength:I
    invoke-direct {p0}, Lcom/android/internal/telephony/WspTypeDecoder;->expandWellKnownMimeType()V

    iget-wide v6, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    .restart local v6       #wellKnownValue:J
    iget-object v4, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    .restart local v4       #mimeType:Ljava/lang/String;
    iget v9, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/2addr v9, p1

    iget v10, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    sub-int/2addr v10, v3

    sub-int v10, v2, v10

    const/4 v11, 0x0

    invoke-direct {p0, v9, v10, v11}, Lcom/android/internal/telephony/WspTypeDecoder;->readContentParameters(III)Z

    move-result v9

    if-eqz v9, :cond_86

    iget v9, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/2addr v9, v5

    iput v9, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    iput-wide v6, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    iput-object v4, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;
    :try_end_85
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_9 .. :try_end_85} :catch_52

    goto :goto_18

    .end local v4           #mimeType:Ljava/lang/String;
    .end local v5           #readLength:I
    .end local v6           #wellKnownValue:J
    :cond_86
    move v1, v8

    goto :goto_18
.end method

.method public decodeExtensionMedia(I)Z
    .registers 8
    .parameter "startIndex"

    .prologue
    const/4 v2, 0x0

    move v0, p1

    .local v0, index:I
    iput v2, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    const/4 v3, 0x0

    iput-object v3, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    iget-object v3, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    array-length v1, v3

    .local v1, length:I
    if-ge v0, v1, :cond_d

    const/4 v2, 0x1

    .local v2, rtrn:Z
    :cond_d
    :goto_d
    if-ge v0, v1, :cond_18

    iget-object v3, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v3, v3, v0

    if-eqz v3, :cond_18

    add-int/lit8 v0, v0, 0x1

    goto :goto_d

    :cond_18
    sub-int v3, v0, p1

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    new-instance v3, Ljava/lang/String;

    iget-object v4, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    iget v5, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/lit8 v5, v5, -0x1

    invoke-direct {v3, v4, p1, v5}, Ljava/lang/String;-><init>([BII)V

    iput-object v3, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    return v2
.end method

.method public decodeIntegerValue(I)Z
    .registers 4
    .parameter "startIndex"

    .prologue
    const/4 v0, 0x1

    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeShortInteger(I)Z

    move-result v1

    if-ne v1, v0, :cond_8

    :goto_7
    return v0

    :cond_8
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeLongInteger(I)Z

    move-result v0

    goto :goto_7
.end method

.method public decodeLongInteger(I)Z
    .registers 8
    .parameter "startIndex"

    .prologue
    iget-object v2, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v2, v2, p1

    and-int/lit16 v1, v2, 0xff

    .local v1, lengthMultiOctet:I
    const/16 v2, 0x1e

    if-le v1, v2, :cond_c

    const/4 v2, 0x0

    :goto_b
    return v2

    :cond_c
    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    const/4 v0, 0x1

    .local v0, i:I
    :goto_11
    if-gt v0, v1, :cond_27

    iget-wide v2, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    const/16 v4, 0x8

    shl-long/2addr v2, v4

    iget-object v4, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    add-int v5, p1, v0

    aget-byte v4, v4, v5

    and-int/lit16 v4, v4, 0xff

    int-to-long v4, v4

    or-long/2addr v2, v4

    iput-wide v2, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    add-int/lit8 v0, v0, 0x1

    goto :goto_11

    :cond_27
    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    const/4 v2, 0x1

    goto :goto_b
.end method

.method public decodeShortInteger(I)Z
    .registers 5
    .parameter "startIndex"

    .prologue
    const/4 v0, 0x1

    iget-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v1, v1, p1

    and-int/lit16 v1, v1, 0x80

    if-nez v1, :cond_b

    const/4 v0, 0x0

    :goto_a
    return v0

    :cond_b
    iget-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v1, v1, p1

    and-int/lit8 v1, v1, 0x7f

    int-to-long v1, v1

    iput-wide v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    iput v0, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    goto :goto_a
.end method

.method public decodeTextString(I)Z
    .registers 7
    .parameter "startIndex"

    .prologue
    move v0, p1

    .local v0, index:I
    :goto_1
    iget-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v1, v1, v0

    if-eqz v1, :cond_a

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_a
    sub-int v1, v0, p1

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    iget-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v1, v1, p1

    const/16 v2, 0x7f

    if-ne v1, v2, :cond_29

    new-instance v1, Ljava/lang/String;

    iget-object v2, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    add-int/lit8 v3, p1, 0x1

    iget v4, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/lit8 v4, v4, -0x2

    invoke-direct {v1, v2, v3, v4}, Ljava/lang/String;-><init>([BII)V

    iput-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    :goto_27
    const/4 v1, 0x1

    return v1

    :cond_29
    new-instance v1, Ljava/lang/String;

    iget-object v2, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    iget v3, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/lit8 v3, v3, -0x1

    invoke-direct {v1, v2, p1, v3}, Ljava/lang/String;-><init>([BII)V

    iput-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    goto :goto_27
.end method

.method public decodeTokenText(I)Z
    .registers 6
    .parameter "startIndex"

    .prologue
    move v0, p1

    .local v0, index:I
    :goto_1
    iget-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v1, v1, v0

    if-eqz v1, :cond_a

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_a
    sub-int v1, v0, p1

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    new-instance v1, Ljava/lang/String;

    iget-object v2, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    iget v3, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/lit8 v3, v3, -0x1

    invoke-direct {v1, v2, p1, v3}, Ljava/lang/String;-><init>([BII)V

    iput-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    const/4 v1, 0x1

    return v1
.end method

.method public decodeUintvarInteger(I)Z
    .registers 8
    .parameter "startIndex"

    .prologue
    const/4 v5, 0x7

    move v0, p1

    .local v0, index:I
    const-wide/16 v1, 0x0

    iput-wide v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    :goto_6
    iget-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v1, v1, v0

    and-int/lit16 v1, v1, 0x80

    if-eqz v1, :cond_25

    sub-int v1, v0, p1

    const/4 v2, 0x4

    if-lt v1, v2, :cond_15

    const/4 v1, 0x0

    :goto_14
    return v1

    :cond_15
    iget-wide v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    shl-long/2addr v1, v5

    iget-object v3, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v3, v3, v0

    and-int/lit8 v3, v3, 0x7f

    int-to-long v3, v3

    or-long/2addr v1, v3

    iput-wide v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    add-int/lit8 v0, v0, 0x1

    goto :goto_6

    :cond_25
    iget-wide v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    shl-long/2addr v1, v5

    iget-object v3, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v3, v3, v0

    and-int/lit8 v3, v3, 0x7f

    int-to-long v3, v3

    or-long/2addr v1, v3

    iput-wide v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    sub-int v1, v0, p1

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    const/4 v1, 0x1

    goto :goto_14
.end method

.method public decodeValueLength(I)Z
    .registers 5
    .parameter "startIndex"

    .prologue
    const/16 v2, 0x1f

    const/4 v0, 0x1

    iget-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v1, v1, p1

    and-int/lit16 v1, v1, 0xff

    if-le v1, v2, :cond_d

    const/4 v0, 0x0

    :goto_c
    return v0

    :cond_d
    iget-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v1, v1, p1

    if-ge v1, v2, :cond_1d

    iget-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v1, v1, p1

    int-to-long v1, v1

    iput-wide v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    iput v0, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    goto :goto_c

    :cond_1d
    add-int/lit8 v1, p1, 0x1

    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeUintvarInteger(I)Z

    iget v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    goto :goto_c
.end method

.method public decodeXWapApplicationId(I)Z
    .registers 4
    .parameter "startIndex"

    .prologue
    const/4 v0, 0x1

    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeIntegerValue(I)Z

    move-result v1

    if-ne v1, v0, :cond_b

    const/4 v1, 0x0

    iput-object v1, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    :goto_a
    return v0

    :cond_b
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeTextString(I)Z

    move-result v0

    goto :goto_a
.end method

.method public decodeXWapContentURI(I)Z
    .registers 3
    .parameter "startIndex"

    .prologue
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeTextString(I)Z

    move-result v0

    return v0
.end method

.method public decodeXWapInitiatorURI(I)Z
    .registers 3
    .parameter "startIndex"

    .prologue
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeTextString(I)Z

    move-result v0

    return v0
.end method

.method public getContentParameters()Ljava/util/HashMap;
    .registers 2
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
    iget-object v0, p0, Lcom/android/internal/telephony/WspTypeDecoder;->contentParameters:Ljava/util/HashMap;

    return-object v0
.end method

.method public getDecodedDataLength()I
    .registers 2

    .prologue
    iget v0, p0, Lcom/android/internal/telephony/WspTypeDecoder;->dataLength:I

    return v0
.end method

.method public getValue32()J
    .registers 3

    .prologue
    iget-wide v0, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    return-wide v0
.end method

.method public getValueString()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/WspTypeDecoder;->stringValue:Ljava/lang/String;

    return-object v0
.end method

.method public seekXWapApplicationId(II)Z
    .registers 11
    .parameter "startIndex"
    .parameter "endIndex"

    .prologue
    const/16 v7, 0x1f

    const/4 v4, 0x0

    move v2, p1

    .local v2, index:I
    move v2, p1

    :goto_5
    if-gt v2, p2, :cond_1c

    :try_start_7
    invoke-virtual {p0, v2}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeIntegerValue(I)Z

    move-result v5

    if-eqz v5, :cond_1d

    invoke-virtual {p0}, Lcom/android/internal/telephony/WspTypeDecoder;->getValue32()J

    move-result-wide v5

    long-to-int v1, v5

    .local v1, fieldValue:I
    const/16 v5, 0x2f

    if-ne v1, v5, :cond_23

    add-int/lit8 v5, v2, 0x1

    int-to-long v5, v5

    iput-wide v5, p0, Lcom/android/internal/telephony/WspTypeDecoder;->unsigned32bit:J

    const/4 v4, 0x1

    .end local v1           #fieldValue:I
    :cond_1c
    :goto_1c
    return v4

    :cond_1d
    invoke-virtual {p0, v2}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeTextString(I)Z

    move-result v5

    if-eqz v5, :cond_1c

    :cond_23
    invoke-virtual {p0}, Lcom/android/internal/telephony/WspTypeDecoder;->getDecodedDataLength()I

    move-result v5

    add-int/2addr v2, v5

    if-gt v2, p2, :cond_1c

    iget-object v5, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v3, v5, v2

    .local v3, val:B
    if-ltz v3, :cond_3c

    const/16 v5, 0x1e

    if-gt v3, v5, :cond_3c

    iget-object v5, p0, Lcom/android/internal/telephony/WspTypeDecoder;->wspData:[B

    aget-byte v5, v5, v2

    add-int/lit8 v5, v5, 0x1

    add-int/2addr v2, v5

    goto :goto_5

    :cond_3c
    if-ne v3, v7, :cond_50

    add-int/lit8 v5, v2, 0x1

    if-ge v5, p2, :cond_1c

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {p0, v2}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeUintvarInteger(I)Z

    move-result v5

    if-eqz v5, :cond_1c

    invoke-virtual {p0}, Lcom/android/internal/telephony/WspTypeDecoder;->getDecodedDataLength()I

    move-result v5

    add-int/2addr v2, v5

    goto :goto_5

    :cond_50
    if-ge v7, v3, :cond_62

    const/16 v5, 0x7f

    if-gt v3, v5, :cond_62

    invoke-virtual {p0, v2}, Lcom/android/internal/telephony/WspTypeDecoder;->decodeTextString(I)Z

    move-result v5

    if-eqz v5, :cond_1c

    invoke-virtual {p0}, Lcom/android/internal/telephony/WspTypeDecoder;->getDecodedDataLength()I
    :try_end_5f
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_7 .. :try_end_5f} :catch_65

    move-result v5

    add-int/2addr v2, v5

    goto :goto_5

    :cond_62
    add-int/lit8 v2, v2, 0x1

    goto :goto_5

    .end local v3           #val:B
    :catch_65
    move-exception v0

    .local v0, e:Ljava/lang/ArrayIndexOutOfBoundsException;
    goto :goto_1c
.end method
