.class Lcom/google/android/mms/pdu/PduComposer$LengthRecordNode;
.super Ljava/lang/Object;
.source "PduComposer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/mms/pdu/PduComposer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "LengthRecordNode"
.end annotation


# instance fields
.field currentMessage:Ljava/io/ByteArrayOutputStream;

.field public currentPosition:I

.field public next:Lcom/google/android/mms/pdu/PduComposer$LengthRecordNode;


# direct methods
.method private constructor <init>()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 1023
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1024
    iput-object v1, p0, Lcom/google/android/mms/pdu/PduComposer$LengthRecordNode;->currentMessage:Ljava/io/ByteArrayOutputStream;

    .line 1025
    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/mms/pdu/PduComposer$LengthRecordNode;->currentPosition:I

    .line 1027
    iput-object v1, p0, Lcom/google/android/mms/pdu/PduComposer$LengthRecordNode;->next:Lcom/google/android/mms/pdu/PduComposer$LengthRecordNode;

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/mms/pdu/PduComposer$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 1023
    invoke-direct {p0}, Lcom/google/android/mms/pdu/PduComposer$LengthRecordNode;-><init>()V

    return-void
.end method
