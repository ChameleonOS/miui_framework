.class public final enum Lcom/android/internal/telephony/cat/ResultCode;
.super Ljava/lang/Enum;
.source "ResultCode.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/android/internal/telephony/cat/ResultCode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum ACCESS_TECH_UNABLE_TO_PROCESS:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum BACKWARD_MOVE_BY_USER:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum BEYOND_TERMINAL_CAPABILITY:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum BIP_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum CMD_DATA_NOT_UNDERSTOOD:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum CMD_NUM_NOT_KNOWN:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum CMD_TYPE_NOT_UNDERSTOOD:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum CONTRADICTION_WITH_TIMER:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum FRAMES_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum HELP_INFO_REQUIRED:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum LAUNCH_BROWSER_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum MMS_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum MMS_TEMPORARY:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum MULTI_CARDS_CMD_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum NAA_CALL_CONTROL_TEMPORARY:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum NETWORK_CRNTLY_UNABLE_TO_PROCESS:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum NO_RESPONSE_FROM_USER:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum OK:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum PRFRMD_ICON_NOT_DISPLAYED:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum PRFRMD_LIMITED_SERVICE:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum PRFRMD_MODIFIED_BY_NAA:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum PRFRMD_NAA_NOT_ACTIVE:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum PRFRMD_TONE_NOT_PLAYED:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum PRFRMD_WITH_ADDITIONAL_EFS_READ:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum PRFRMD_WITH_MISSING_INFO:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum PRFRMD_WITH_MODIFICATION:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum PRFRMD_WITH_PARTIAL_COMPREHENSION:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum REQUIRED_VALUES_MISSING:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum SMS_RP_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum SS_RETURN_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum TERMINAL_CRNTLY_UNABLE_TO_PROCESS:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum UICC_SESSION_TERM_BY_USER:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum USER_CLEAR_DOWN_CALL:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum USER_NOT_ACCEPT:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum USIM_CALL_CONTROL_PERMANENT:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum USSD_RETURN_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

.field public static final enum USSD_SS_SESSION_TERM_BY_USER:Lcom/android/internal/telephony/cat/ResultCode;


# instance fields
.field private mCode:I


# direct methods
.method static constructor <clinit>()V
    .registers 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 34
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "OK"

    invoke-direct {v0, v1, v4, v4}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->OK:Lcom/android/internal/telephony/cat/ResultCode;

    .line 37
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "PRFRMD_WITH_PARTIAL_COMPREHENSION"

    invoke-direct {v0, v1, v5, v5}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_WITH_PARTIAL_COMPREHENSION:Lcom/android/internal/telephony/cat/ResultCode;

    .line 40
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "PRFRMD_WITH_MISSING_INFO"

    invoke-direct {v0, v1, v6, v6}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_WITH_MISSING_INFO:Lcom/android/internal/telephony/cat/ResultCode;

    .line 43
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "PRFRMD_WITH_ADDITIONAL_EFS_READ"

    invoke-direct {v0, v1, v7, v7}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_WITH_ADDITIONAL_EFS_READ:Lcom/android/internal/telephony/cat/ResultCode;

    .line 49
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "PRFRMD_ICON_NOT_DISPLAYED"

    invoke-direct {v0, v1, v8, v8}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_ICON_NOT_DISPLAYED:Lcom/android/internal/telephony/cat/ResultCode;

    .line 52
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "PRFRMD_MODIFIED_BY_NAA"

    const/4 v2, 0x5

    const/4 v3, 0x5

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_MODIFIED_BY_NAA:Lcom/android/internal/telephony/cat/ResultCode;

    .line 55
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "PRFRMD_LIMITED_SERVICE"

    const/4 v2, 0x6

    const/4 v3, 0x6

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_LIMITED_SERVICE:Lcom/android/internal/telephony/cat/ResultCode;

    .line 58
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "PRFRMD_WITH_MODIFICATION"

    const/4 v2, 0x7

    const/4 v3, 0x7

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_WITH_MODIFICATION:Lcom/android/internal/telephony/cat/ResultCode;

    .line 61
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "PRFRMD_NAA_NOT_ACTIVE"

    const/16 v2, 0x8

    const/16 v3, 0x8

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_NAA_NOT_ACTIVE:Lcom/android/internal/telephony/cat/ResultCode;

    .line 64
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "PRFRMD_TONE_NOT_PLAYED"

    const/16 v2, 0x9

    const/16 v3, 0x9

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_TONE_NOT_PLAYED:Lcom/android/internal/telephony/cat/ResultCode;

    .line 67
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "UICC_SESSION_TERM_BY_USER"

    const/16 v2, 0xa

    const/16 v3, 0x10

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->UICC_SESSION_TERM_BY_USER:Lcom/android/internal/telephony/cat/ResultCode;

    .line 70
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "BACKWARD_MOVE_BY_USER"

    const/16 v2, 0xb

    const/16 v3, 0x11

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->BACKWARD_MOVE_BY_USER:Lcom/android/internal/telephony/cat/ResultCode;

    .line 73
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "NO_RESPONSE_FROM_USER"

    const/16 v2, 0xc

    const/16 v3, 0x12

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->NO_RESPONSE_FROM_USER:Lcom/android/internal/telephony/cat/ResultCode;

    .line 76
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "HELP_INFO_REQUIRED"

    const/16 v2, 0xd

    const/16 v3, 0x13

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->HELP_INFO_REQUIRED:Lcom/android/internal/telephony/cat/ResultCode;

    .line 79
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "USSD_SS_SESSION_TERM_BY_USER"

    const/16 v2, 0xe

    const/16 v3, 0x14

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->USSD_SS_SESSION_TERM_BY_USER:Lcom/android/internal/telephony/cat/ResultCode;

    .line 88
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "TERMINAL_CRNTLY_UNABLE_TO_PROCESS"

    const/16 v2, 0xf

    const/16 v3, 0x20

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->TERMINAL_CRNTLY_UNABLE_TO_PROCESS:Lcom/android/internal/telephony/cat/ResultCode;

    .line 91
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "NETWORK_CRNTLY_UNABLE_TO_PROCESS"

    const/16 v2, 0x10

    const/16 v3, 0x21

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->NETWORK_CRNTLY_UNABLE_TO_PROCESS:Lcom/android/internal/telephony/cat/ResultCode;

    .line 94
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "USER_NOT_ACCEPT"

    const/16 v2, 0x11

    const/16 v3, 0x22

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->USER_NOT_ACCEPT:Lcom/android/internal/telephony/cat/ResultCode;

    .line 97
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "USER_CLEAR_DOWN_CALL"

    const/16 v2, 0x12

    const/16 v3, 0x23

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->USER_CLEAR_DOWN_CALL:Lcom/android/internal/telephony/cat/ResultCode;

    .line 100
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "CONTRADICTION_WITH_TIMER"

    const/16 v2, 0x13

    const/16 v3, 0x24

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->CONTRADICTION_WITH_TIMER:Lcom/android/internal/telephony/cat/ResultCode;

    .line 103
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "NAA_CALL_CONTROL_TEMPORARY"

    const/16 v2, 0x14

    const/16 v3, 0x25

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->NAA_CALL_CONTROL_TEMPORARY:Lcom/android/internal/telephony/cat/ResultCode;

    .line 106
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "LAUNCH_BROWSER_ERROR"

    const/16 v2, 0x15

    const/16 v3, 0x26

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->LAUNCH_BROWSER_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    .line 109
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "MMS_TEMPORARY"

    const/16 v2, 0x16

    const/16 v3, 0x27

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->MMS_TEMPORARY:Lcom/android/internal/telephony/cat/ResultCode;

    .line 119
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "BEYOND_TERMINAL_CAPABILITY"

    const/16 v2, 0x17

    const/16 v3, 0x30

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->BEYOND_TERMINAL_CAPABILITY:Lcom/android/internal/telephony/cat/ResultCode;

    .line 122
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "CMD_TYPE_NOT_UNDERSTOOD"

    const/16 v2, 0x18

    const/16 v3, 0x31

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->CMD_TYPE_NOT_UNDERSTOOD:Lcom/android/internal/telephony/cat/ResultCode;

    .line 125
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "CMD_DATA_NOT_UNDERSTOOD"

    const/16 v2, 0x19

    const/16 v3, 0x32

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->CMD_DATA_NOT_UNDERSTOOD:Lcom/android/internal/telephony/cat/ResultCode;

    .line 128
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "CMD_NUM_NOT_KNOWN"

    const/16 v2, 0x1a

    const/16 v3, 0x33

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->CMD_NUM_NOT_KNOWN:Lcom/android/internal/telephony/cat/ResultCode;

    .line 131
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "SS_RETURN_ERROR"

    const/16 v2, 0x1b

    const/16 v3, 0x34

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->SS_RETURN_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    .line 134
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "SMS_RP_ERROR"

    const/16 v2, 0x1c

    const/16 v3, 0x35

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->SMS_RP_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    .line 137
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "REQUIRED_VALUES_MISSING"

    const/16 v2, 0x1d

    const/16 v3, 0x36

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->REQUIRED_VALUES_MISSING:Lcom/android/internal/telephony/cat/ResultCode;

    .line 140
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "USSD_RETURN_ERROR"

    const/16 v2, 0x1e

    const/16 v3, 0x37

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->USSD_RETURN_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    .line 143
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "MULTI_CARDS_CMD_ERROR"

    const/16 v2, 0x1f

    const/16 v3, 0x38

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->MULTI_CARDS_CMD_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    .line 149
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "USIM_CALL_CONTROL_PERMANENT"

    const/16 v2, 0x20

    const/16 v3, 0x39

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->USIM_CALL_CONTROL_PERMANENT:Lcom/android/internal/telephony/cat/ResultCode;

    .line 152
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "BIP_ERROR"

    const/16 v2, 0x21

    const/16 v3, 0x3a

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->BIP_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    .line 155
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "ACCESS_TECH_UNABLE_TO_PROCESS"

    const/16 v2, 0x22

    const/16 v3, 0x3b

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->ACCESS_TECH_UNABLE_TO_PROCESS:Lcom/android/internal/telephony/cat/ResultCode;

    .line 158
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "FRAMES_ERROR"

    const/16 v2, 0x23

    const/16 v3, 0x3c

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->FRAMES_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    .line 161
    new-instance v0, Lcom/android/internal/telephony/cat/ResultCode;

    const-string v1, "MMS_ERROR"

    const/16 v2, 0x24

    const/16 v3, 0x3d

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/cat/ResultCode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->MMS_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    .line 27
    const/16 v0, 0x25

    new-array v0, v0, [Lcom/android/internal/telephony/cat/ResultCode;

    sget-object v1, Lcom/android/internal/telephony/cat/ResultCode;->OK:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v1, v0, v4

    sget-object v1, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_WITH_PARTIAL_COMPREHENSION:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v1, v0, v5

    sget-object v1, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_WITH_MISSING_INFO:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v1, v0, v6

    sget-object v1, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_WITH_ADDITIONAL_EFS_READ:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v1, v0, v7

    sget-object v1, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_ICON_NOT_DISPLAYED:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_MODIFIED_BY_NAA:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_LIMITED_SERVICE:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_WITH_MODIFICATION:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_NAA_NOT_ACTIVE:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->PRFRMD_TONE_NOT_PLAYED:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->UICC_SESSION_TERM_BY_USER:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->BACKWARD_MOVE_BY_USER:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->NO_RESPONSE_FROM_USER:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->HELP_INFO_REQUIRED:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->USSD_SS_SESSION_TERM_BY_USER:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->TERMINAL_CRNTLY_UNABLE_TO_PROCESS:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->NETWORK_CRNTLY_UNABLE_TO_PROCESS:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->USER_NOT_ACCEPT:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->USER_CLEAR_DOWN_CALL:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->CONTRADICTION_WITH_TIMER:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->NAA_CALL_CONTROL_TEMPORARY:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->LAUNCH_BROWSER_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->MMS_TEMPORARY:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->BEYOND_TERMINAL_CAPABILITY:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->CMD_TYPE_NOT_UNDERSTOOD:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->CMD_DATA_NOT_UNDERSTOOD:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->CMD_NUM_NOT_KNOWN:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->SS_RETURN_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->SMS_RP_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->REQUIRED_VALUES_MISSING:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->USSD_RETURN_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->MULTI_CARDS_CMD_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x20

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->USIM_CALL_CONTROL_PERMANENT:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x21

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->BIP_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x22

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->ACCESS_TECH_UNABLE_TO_PROCESS:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x23

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->FRAMES_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    const/16 v1, 0x24

    sget-object v2, Lcom/android/internal/telephony/cat/ResultCode;->MMS_ERROR:Lcom/android/internal/telephony/cat/ResultCode;

    aput-object v2, v0, v1

    sput-object v0, Lcom/android/internal/telephony/cat/ResultCode;->$VALUES:[Lcom/android/internal/telephony/cat/ResultCode;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .registers 4
    .parameter
    .parameter
    .parameter "code"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 166
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 167
    iput p3, p0, Lcom/android/internal/telephony/cat/ResultCode;->mCode:I

    .line 168
    return-void
.end method

.method public static fromInt(I)Lcom/android/internal/telephony/cat/ResultCode;
    .registers 6
    .parameter "value"

    .prologue
    .line 179
    invoke-static {}, Lcom/android/internal/telephony/cat/ResultCode;->values()[Lcom/android/internal/telephony/cat/ResultCode;

    move-result-object v0

    .local v0, arr$:[Lcom/android/internal/telephony/cat/ResultCode;
    array-length v2, v0

    .local v2, len$:I
    const/4 v1, 0x0

    .local v1, i$:I
    :goto_6
    if-ge v1, v2, :cond_12

    aget-object v3, v0, v1

    .line 180
    .local v3, r:Lcom/android/internal/telephony/cat/ResultCode;
    iget v4, v3, Lcom/android/internal/telephony/cat/ResultCode;->mCode:I

    if-ne v4, p0, :cond_f

    .line 184
    .end local v3           #r:Lcom/android/internal/telephony/cat/ResultCode;
    :goto_e
    return-object v3

    .line 179
    .restart local v3       #r:Lcom/android/internal/telephony/cat/ResultCode;
    :cond_f
    add-int/lit8 v1, v1, 0x1

    goto :goto_6

    .line 184
    .end local v3           #r:Lcom/android/internal/telephony/cat/ResultCode;
    :cond_12
    const/4 v3, 0x0

    goto :goto_e
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/android/internal/telephony/cat/ResultCode;
    .registers 2
    .parameter "name"

    .prologue
    .line 27
    const-class v0, Lcom/android/internal/telephony/cat/ResultCode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/android/internal/telephony/cat/ResultCode;

    return-object v0
.end method

.method public static values()[Lcom/android/internal/telephony/cat/ResultCode;
    .registers 1

    .prologue
    .line 27
    sget-object v0, Lcom/android/internal/telephony/cat/ResultCode;->$VALUES:[Lcom/android/internal/telephony/cat/ResultCode;

    invoke-virtual {v0}, [Lcom/android/internal/telephony/cat/ResultCode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/internal/telephony/cat/ResultCode;

    return-object v0
.end method


# virtual methods
.method public value()I
    .registers 2

    .prologue
    .line 175
    iget v0, p0, Lcom/android/internal/telephony/cat/ResultCode;->mCode:I

    return v0
.end method
