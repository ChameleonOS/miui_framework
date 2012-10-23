.class public final Lmiui/provider/ExtraTelephony;
.super Ljava/lang/Object;
.source "ExtraTelephony.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/provider/ExtraTelephony$FirewallLog;,
        Lmiui/provider/ExtraTelephony$Keyword;,
        Lmiui/provider/ExtraTelephony$Whitelist;,
        Lmiui/provider/ExtraTelephony$Blacklist;,
        Lmiui/provider/ExtraTelephony$SimCards;,
        Lmiui/provider/ExtraTelephony$SmsPhrase;,
        Lmiui/provider/ExtraTelephony$MmsSms;,
        Lmiui/provider/ExtraTelephony$Threads;,
        Lmiui/provider/ExtraTelephony$ThreadsColumns;,
        Lmiui/provider/ExtraTelephony$Mx;,
        Lmiui/provider/ExtraTelephony$Mms;,
        Lmiui/provider/ExtraTelephony$Sms;,
        Lmiui/provider/ExtraTelephony$TextBasedSmsColumns;
    }
.end annotation


# static fields
.field public static final CALLER_IS_SYNCADAPTER:Ljava/lang/String; = "caller_is_syncadapter"

.field public static final CHECK_DUPLICATION:Ljava/lang/String; = "check_duplication"

.field private static final COLUMNS:[Ljava/lang/String; = null

.field private static final DATA_COLUMN:I = 0x0

.field public static final DIRTY_QUERY_LIMIT:Ljava/lang/String; = "dirty_query_limit"

.field private static final KEYWORD_COLUMNS:[Ljava/lang/String; = null

.field private static final NAME_COLUMN:I = 0x0

.field public static final NEED_FULL_INSERT_URI:Ljava/lang/String; = "need_full_insert_uri"

.field private static final STARRED_COLUMN:I = 0x1

.field private static final TAG:Ljava/lang/String; = "ExtraTelephony"


# direct methods
.method static constructor <clinit>()V
    .registers 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 447
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "display_name"

    aput-object v1, v0, v2

    const-string/jumbo v1, "starred"

    aput-object v1, v0, v3

    sput-object v0, Lmiui/provider/ExtraTelephony;->COLUMNS:[Ljava/lang/String;

    .line 451
    new-array v0, v3, [Ljava/lang/String;

    const-string v1, "data"

    aput-object v1, v0, v2

    sput-object v0, Lmiui/provider/ExtraTelephony;->KEYWORD_COLUMNS:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 29
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 963
    return-void
.end method

.method public static checkFirewallForMessage(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    .registers 13
    .parameter "context"
    .parameter "address"
    .parameter "body"

    .prologue
    const/4 v6, 0x1

    const/4 v8, 0x2

    .line 776
    const/4 v2, 0x0

    .line 778
    .local v2, insertFw:Z
    const/4 v3, 0x0

    .line 779
    .local v3, reason:I
    :try_start_4
    invoke-virtual {p2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {p0, p1, v7}, Lmiui/provider/ExtraTelephony;->shouldBlockByFirewall(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v4

    .line 780
    .local v4, ret:I
    if-ne v4, v6, :cond_67

    .line 781
    const/4 v2, 0x1

    .line 782
    const/4 v3, 0x4

    .line 793
    :cond_10
    :goto_10
    if-eqz v2, :cond_8a

    .line 794
    invoke-static {p0}, Lmiui/provider/ExtraTelephony;->getSmsAct(Landroid/content/Context;)I

    move-result v0

    .line 796
    .local v0, act:I
    if-eq v0, v8, :cond_1c

    const/high16 v7, 0x1

    if-ne v3, v7, :cond_8a

    .line 799
    :cond_1c
    const/4 v7, 0x4

    if-ne v3, v7, :cond_74

    .line 800
    const-string v7, "ExtraTelephony"

    const-string/jumbo v8, "\u76f4\u63a5\u5220\u9664\u9ed1\u540d\u5355\u6210\u5458\u77ed\u4fe1."

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 808
    :goto_27
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 809
    .local v5, values:Landroid/content/ContentValues;
    const-string/jumbo v7, "number"

    invoke-virtual {v5, v7, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 810
    const-string v7, "date"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 811
    const-string/jumbo v7, "type"

    const/4 v8, 0x2

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 812
    const-string v7, "data1"

    invoke-virtual {p2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 813
    const-string/jumbo v7, "reason"

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 814
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v7

    sget-object v8, Lmiui/provider/ExtraTelephony$FirewallLog;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v7, v8, v5}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 821
    .end local v0           #act:I
    .end local v4           #ret:I
    .end local v5           #values:Landroid/content/ContentValues;
    :goto_66
    return v6

    .line 784
    .restart local v4       #ret:I
    :cond_67
    if-ne v4, v8, :cond_6d

    .line 785
    const/4 v2, 0x1

    .line 786
    const/16 v3, 0x104

    goto :goto_10

    .line 788
    :cond_6d
    const/4 v7, 0x3

    if-ne v4, v7, :cond_10

    .line 789
    const/4 v2, 0x1

    .line 790
    const/high16 v3, 0x1

    goto :goto_10

    .line 801
    .restart local v0       #act:I
    :cond_74
    const/16 v7, 0x104

    if-ne v3, v7, :cond_8c

    .line 802
    const-string v7, "ExtraTelephony"

    const-string/jumbo v8, "\u76f4\u63a5\u5220\u9664\u767d\u540d\u5355\u6210\u5458\u77ed\u4fe1."

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_80
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_80} :catch_81

    goto :goto_27

    .line 818
    .end local v0           #act:I
    .end local v4           #ret:I
    :catch_81
    move-exception v1

    .line 819
    .local v1, e:Ljava/lang/Exception;
    const-string v6, "ExtraTelephony"

    const-string/jumbo v7, "\u9632\u6253\u6270\u53d1\u751f\u5f02\u5e38"

    invoke-static {v6, v7, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 821
    .end local v1           #e:Ljava/lang/Exception;
    :cond_8a
    const/4 v6, 0x0

    goto :goto_66

    .line 804
    .restart local v0       #act:I
    .restart local v4       #ret:I
    :cond_8c
    :try_start_8c
    const-string v7, "ExtraTelephony"

    const-string/jumbo v8, "\u77ed\u4fe1\u88ab\u8fc7\u6ee4."

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_94
    .catch Ljava/lang/Exception; {:try_start_8c .. :try_end_94} :catch_81

    goto :goto_27
.end method

.method public static checkFirewallForSms(Landroid/content/Context;[[B)Z
    .registers 10
    .parameter "context"
    .parameter "pdus"

    .prologue
    const/4 v5, 0x0

    .line 832
    if-eqz p1, :cond_2d

    :try_start_3
    array-length v6, p1
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_4} :catch_37

    const/4 v7, 0x1

    if-lt v6, v7, :cond_2d

    .line 833
    const/4 v0, 0x0

    .line 836
    .local v0, address:Ljava/lang/String;
    const/4 v6, 0x0

    :try_start_9
    aget-object v6, p1, v6

    invoke-static {v6}, Landroid/telephony/SmsMessage;->createFromPdu([B)Landroid/telephony/SmsMessage;

    move-result-object v6

    invoke-virtual {v6}, Landroid/telephony/SmsMessage;->getOriginatingAddress()Ljava/lang/String;
    :try_end_12
    .catch Ljava/lang/NullPointerException; {:try_start_9 .. :try_end_12} :catch_2c
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_12} :catch_37

    move-result-object v0

    .line 841
    :try_start_13
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 842
    .local v1, body:Ljava/lang/StringBuilder;
    const/4 v4, 0x0

    .local v4, i:I
    :goto_19
    array-length v6, p1
    :try_end_1a
    .catch Ljava/lang/Exception; {:try_start_13 .. :try_end_1a} :catch_37

    if-ge v4, v6, :cond_2e

    .line 844
    :try_start_1c
    aget-object v6, p1, v4

    invoke-static {v6}, Landroid/telephony/SmsMessage;->createFromPdu([B)Landroid/telephony/SmsMessage;

    move-result-object v6

    invoke-virtual {v6}, Landroid/telephony/SmsMessage;->getDisplayMessageBody()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_29
    .catch Ljava/lang/NullPointerException; {:try_start_1c .. :try_end_29} :catch_41
    .catch Ljava/lang/Exception; {:try_start_1c .. :try_end_29} :catch_37

    .line 842
    :goto_29
    add-int/lit8 v4, v4, 0x1

    goto :goto_19

    .line 837
    .end local v1           #body:Ljava/lang/StringBuilder;
    .end local v4           #i:I
    :catch_2c
    move-exception v3

    .line 856
    .end local v0           #address:Ljava/lang/String;
    :cond_2d
    :goto_2d
    return v5

    .line 851
    .restart local v0       #address:Ljava/lang/String;
    .restart local v1       #body:Ljava/lang/StringBuilder;
    .restart local v4       #i:I
    :cond_2e
    :try_start_2e
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {p0, v0, v6}, Lmiui/provider/ExtraTelephony;->checkFirewallForMessage(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    :try_end_35
    .catch Ljava/lang/Exception; {:try_start_2e .. :try_end_35} :catch_37

    move-result v5

    goto :goto_2d

    .line 853
    .end local v0           #address:Ljava/lang/String;
    .end local v1           #body:Ljava/lang/StringBuilder;
    .end local v4           #i:I
    :catch_37
    move-exception v2

    .line 854
    .local v2, e:Ljava/lang/Exception;
    const-string v6, "ExtraTelephony"

    const-string/jumbo v7, "\u9632\u6253\u6270\u53d1\u751f\u5f02\u5e38"

    invoke-static {v6, v7, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_2d

    .line 845
    .end local v2           #e:Ljava/lang/Exception;
    .restart local v0       #address:Ljava/lang/String;
    .restart local v1       #body:Ljava/lang/StringBuilder;
    .restart local v4       #i:I
    :catch_41
    move-exception v6

    goto :goto_29
.end method

.method public static checkFirewallForWapPush(Landroid/content/Context;[B)Z
    .registers 15
    .parameter "context"
    .parameter "pduData"

    .prologue
    .line 866
    if-eqz p1, :cond_b9

    .line 867
    :try_start_2
    new-instance v5, Lcom/google/android/mms/pdu/PduParser;

    invoke-direct {v5, p1}, Lcom/google/android/mms/pdu/PduParser;-><init>([B)V

    .line 868
    .local v5, parser:Lcom/google/android/mms/pdu/PduParser;
    invoke-virtual {v5}, Lcom/google/android/mms/pdu/PduParser;->parse()Lcom/google/android/mms/pdu/GenericPdu;

    move-result-object v6

    .line 869
    .local v6, pdu:Lcom/google/android/mms/pdu/GenericPdu;
    if-nez v6, :cond_f

    .line 870
    const/4 v10, 0x0

    .line 918
    .end local v5           #parser:Lcom/google/android/mms/pdu/PduParser;
    .end local v6           #pdu:Lcom/google/android/mms/pdu/GenericPdu;
    :goto_e
    return v10

    .line 873
    .restart local v5       #parser:Lcom/google/android/mms/pdu/PduParser;
    .restart local v6       #pdu:Lcom/google/android/mms/pdu/GenericPdu;
    :cond_f
    invoke-virtual {v6}, Lcom/google/android/mms/pdu/GenericPdu;->getFrom()Lcom/google/android/mms/pdu/EncodedStringValue;

    move-result-object v3

    .line 874
    .local v3, from:Lcom/google/android/mms/pdu/EncodedStringValue;
    if-nez v3, :cond_17

    .line 875
    const/4 v10, 0x0

    goto :goto_e

    .line 878
    :cond_17
    invoke-virtual {v3}, Lcom/google/android/mms/pdu/EncodedStringValue;->getTextString()[B

    move-result-object v10

    invoke-static {v10}, Lcom/google/android/mms/pdu/PduPersister;->toIsoString([B)Ljava/lang/String;

    move-result-object v1

    .line 879
    .local v1, address:Ljava/lang/String;
    const/4 v4, 0x0

    .line 880
    .local v4, insertFw:Z
    const/4 v7, 0x0

    .line 882
    .local v7, reason:I
    invoke-static {p0, v1}, Lmiui/provider/ExtraTelephony;->shouldBlockByFirewall(Landroid/content/Context;Ljava/lang/String;)I

    move-result v8

    .line 883
    .local v8, ret:I
    const/4 v10, 0x1

    if-ne v8, v10, :cond_9c

    .line 884
    const/4 v4, 0x1

    .line 885
    const/4 v7, 0x6

    .line 892
    :cond_2a
    :goto_2a
    if-eqz v4, :cond_b9

    .line 893
    invoke-static {p0}, Lmiui/provider/ExtraTelephony;->getSmsAct(Landroid/content/Context;)I

    move-result v0

    .line 895
    .local v0, act:I
    const/4 v10, 0x2

    if-ne v0, v10, :cond_b9

    .line 896
    const/4 v10, 0x6

    if-ne v7, v10, :cond_a3

    .line 897
    const-string v10, "ExtraTelephony"

    const-string/jumbo v11, "\u76f4\u63a5\u5220\u9664\u9ed1\u540d\u5355\u6210\u5458\u5f69\u4fe1."

    invoke-static {v10, v11}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 902
    :cond_3e
    :goto_3e
    new-instance v9, Landroid/content/ContentValues;

    invoke-direct {v9}, Landroid/content/ContentValues;-><init>()V

    .line 903
    .local v9, values:Landroid/content/ContentValues;
    const-string/jumbo v10, "number"

    invoke-virtual {v9, v10, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 904
    const-string v10, "date"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v11

    invoke-static {v11, v12}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 905
    const-string/jumbo v10, "type"

    const/4 v11, 0x3

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 906
    const-string v10, "data1"

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "<"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const v12, 0x60c016d

    invoke-virtual {p0, v12}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, ">"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 908
    const-string/jumbo v10, "reason"

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 909
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v10

    sget-object v11, Lmiui/provider/ExtraTelephony$FirewallLog;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v10, v11, v9}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 911
    const/4 v10, 0x1

    goto/16 :goto_e

    .line 887
    .end local v0           #act:I
    .end local v9           #values:Landroid/content/ContentValues;
    :cond_9c
    const/4 v10, 0x2

    if-ne v8, v10, :cond_2a

    .line 888
    const/4 v4, 0x1

    .line 889
    const/16 v7, 0x106

    goto :goto_2a

    .line 898
    .restart local v0       #act:I
    :cond_a3
    const/16 v10, 0x106

    if-ne v7, v10, :cond_3e

    .line 899
    const-string v10, "ExtraTelephony"

    const-string/jumbo v11, "\u76f4\u63a5\u5220\u9664\u767d\u540d\u5355\u6210\u5458\u5f69\u4fe1."

    invoke-static {v10, v11}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_af
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_af} :catch_b0

    goto :goto_3e

    .line 915
    .end local v0           #act:I
    .end local v1           #address:Ljava/lang/String;
    .end local v3           #from:Lcom/google/android/mms/pdu/EncodedStringValue;
    .end local v4           #insertFw:Z
    .end local v5           #parser:Lcom/google/android/mms/pdu/PduParser;
    .end local v6           #pdu:Lcom/google/android/mms/pdu/GenericPdu;
    .end local v7           #reason:I
    .end local v8           #ret:I
    :catch_b0
    move-exception v2

    .line 916
    .local v2, e:Ljava/lang/Exception;
    const-string v10, "ExtraTelephony"

    const-string/jumbo v11, "\u9632\u6253\u6270\u53d1\u751f\u5f02\u5e38"

    invoke-static {v10, v11, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 918
    .end local v2           #e:Ljava/lang/Exception;
    :cond_b9
    const/4 v10, 0x0

    goto/16 :goto_e
.end method

.method public static getCallAct(Landroid/content/Context;)I
    .registers 4
    .parameter "context"

    .prologue
    .line 455
    if-nez p0, :cond_a

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "context should not be null!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 457
    :cond_a
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "firewall_call_act"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public static getSmsAct(Landroid/content/Context;)I
    .registers 4
    .parameter "context"

    .prologue
    .line 463
    if-nez p0, :cond_a

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "context should not be null!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 465
    :cond_a
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "firewall_sms_act"

    const/4 v2, 0x2

    invoke-static {v0, v1, v2}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public static isAntiPrivateEnabled(Landroid/content/Context;)Z
    .registers 4
    .parameter "context"

    .prologue
    const/4 v0, 0x0

    .line 560
    if-nez p0, :cond_b

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "context should not be null!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 562
    :cond_b
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "anti_private_call"

    invoke-static {v1, v2, v0}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v1

    if-eqz v1, :cond_18

    const/4 v0, 0x1

    :cond_18
    return v0
.end method

.method public static isAntiStrangerEnabled(Landroid/content/Context;)Z
    .registers 4
    .parameter "context"

    .prologue
    const/4 v0, 0x1

    .line 550
    if-nez p0, :cond_b

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "context should not be null!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 552
    :cond_b
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "anti_stranger_call"

    invoke-static {v1, v2, v0}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v1

    if-eqz v1, :cond_18

    :goto_17
    return v0

    :cond_18
    const/4 v0, 0x0

    goto :goto_17
.end method

.method private static isBlacklistEnabled(Landroid/content/Context;)Z
    .registers 4
    .parameter "context"

    .prologue
    const/4 v0, 0x1

    .line 580
    if-nez p0, :cond_b

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "context should not be null!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 582
    :cond_b
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "blacklist_enabled"

    invoke-static {v1, v2, v0}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v1

    if-eqz v1, :cond_18

    :goto_17
    return v0

    :cond_18
    const/4 v0, 0x0

    goto :goto_17
.end method

.method public static isCallLogNumber(Landroid/content/Context;Ljava/lang/String;)Z
    .registers 13
    .parameter "context"
    .parameter "phone"

    .prologue
    const/4 v4, 0x0

    const/4 v10, 0x0

    .line 732
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_a

    move v7, v10

    .line 753
    :cond_9
    :goto_9
    return v7

    .line 736
    :cond_a
    invoke-static {p1}, Lmiui/telephony/PhoneNumberUtils$PhoneNumber;->parse(Ljava/lang/CharSequence;)Lmiui/telephony/PhoneNumberUtils$PhoneNumber;

    move-result-object v8

    .line 737
    .local v8, pn:Lmiui/telephony/PhoneNumberUtils$PhoneNumber;
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "number=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v8, v10, v10}, Lmiui/telephony/PhoneNumberUtils$PhoneNumber;->getNormalizedNumber(ZZ)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 738
    .local v3, selection:Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Landroid/provider/CallLog$Calls;->CONTENT_URI:Landroid/net/Uri;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string/jumbo v5, "type"

    aput-object v5, v2, v10

    move-object v5, v4

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 742
    .local v6, cursor:Landroid/database/Cursor;
    const/4 v7, 0x0

    .line 743
    .local v7, hasConnection:Z
    if-eqz v6, :cond_9

    .line 744
    :cond_42
    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_50

    .line 745
    invoke-interface {v6, v10}, Landroid/database/Cursor;->getInt(I)I

    move-result v9

    .line 746
    .local v9, type:I
    const/4 v0, 0x3

    if-eq v9, v0, :cond_42

    .line 747
    const/4 v7, 0x1

    .line 751
    .end local v9           #type:I
    :cond_50
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto :goto_9
.end method

.method public static isFilterSmsEnabled(Landroid/content/Context;)Z
    .registers 4
    .parameter "context"

    .prologue
    const/4 v0, 0x1

    .line 570
    if-nez p0, :cond_b

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "context should not be null!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 572
    :cond_b
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "filter_stranger_sms"

    invoke-static {v1, v2, v0}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v1

    if-eqz v1, :cond_18

    :goto_17
    return v0

    :cond_18
    const/4 v0, 0x0

    goto :goto_17
.end method

.method public static isFirewallEnabled(Landroid/content/Context;)Z
    .registers 4
    .parameter "context"

    .prologue
    const/4 v0, 0x1

    .line 540
    if-nez p0, :cond_b

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "context should not be null!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 542
    :cond_b
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "firewall_enabled"

    invoke-static {v1, v2, v0}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v1

    if-eqz v1, :cond_18

    :goto_17
    return v0

    :cond_18
    const/4 v0, 0x0

    goto :goto_17
.end method

.method private static isInBlacklist(Landroid/content/Context;Ljava/lang/String;)Z
    .registers 10
    .parameter "context"
    .parameter "phone"

    .prologue
    const/4 v2, 0x0

    .line 494
    if-nez p0, :cond_b

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "context should not be null!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 496
    :cond_b
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_13

    const/4 v7, 0x0

    .line 510
    :cond_12
    :goto_12
    return v7

    .line 498
    :cond_13
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lmiui/provider/ExtraTelephony$Blacklist;->CONTENT_URI:Landroid/net/Uri;

    invoke-static {v1, p1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 502
    .local v6, c:Landroid/database/Cursor;
    const/4 v7, 0x0

    .line 503
    .local v7, result:Z
    if-eqz v6, :cond_34

    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_34

    .line 504
    const/4 v7, 0x1

    .line 509
    :goto_2e
    if-eqz v6, :cond_12

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto :goto_12

    .line 506
    :cond_34
    const/4 v7, 0x0

    goto :goto_2e
.end method

.method private static isInFirewallTimeLimit(Landroid/content/Context;)Z
    .registers 11
    .parameter "context"

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 597
    if-nez p0, :cond_c

    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "context should not be null!"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 599
    :cond_c
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v7

    const-string v8, "firewall_time_limit_enabled"

    invoke-static {v7, v8, v6}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v7

    if-eqz v7, :cond_1c

    move v2, v5

    .line 602
    .local v2, isEnabled:Z
    :goto_19
    if-nez v2, :cond_1e

    .line 618
    :cond_1b
    :goto_1b
    return v5

    .end local v2           #isEnabled:Z
    :cond_1c
    move v2, v6

    .line 599
    goto :goto_19

    .line 604
    .restart local v2       #isEnabled:Z
    :cond_1e
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v7

    const-string v8, "firewall_start_time"

    invoke-static {v7, v8, v6}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v4

    .line 607
    .local v4, startTime:I
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v7

    const-string v8, "firewall_end_time"

    const/16 v9, 0x1a4

    invoke-static {v7, v8, v9}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v1

    .line 610
    .local v1, endTime:I
    if-ne v4, v1, :cond_38

    move v5, v6

    goto :goto_1b

    .line 612
    :cond_38
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 613
    .local v0, c:Ljava/util/Calendar;
    const/16 v7, 0xb

    invoke-virtual {v0, v7}, Ljava/util/Calendar;->get(I)I

    move-result v7

    mul-int/lit8 v7, v7, 0x3c

    const/16 v8, 0xc

    invoke-virtual {v0, v8}, Ljava/util/Calendar;->get(I)I

    move-result v8

    add-int v3, v7, v8

    .line 614
    .local v3, now:I
    if-ge v4, v1, :cond_54

    .line 615
    if-gt v4, v3, :cond_52

    if-le v3, v1, :cond_1b

    :cond_52
    move v5, v6

    goto :goto_1b

    .line 618
    :cond_54
    if-ge v3, v4, :cond_58

    if-gt v3, v1, :cond_59

    :cond_58
    move v6, v5

    :cond_59
    move v5, v6

    goto :goto_1b
.end method

.method private static isInWhitelist(Landroid/content/Context;Ljava/lang/String;)Z
    .registers 10
    .parameter "context"
    .parameter "phone"

    .prologue
    const/4 v2, 0x0

    .line 518
    if-nez p0, :cond_b

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "context should not be null!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 520
    :cond_b
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_13

    const/4 v7, 0x0

    .line 533
    :cond_12
    :goto_12
    return v7

    .line 523
    :cond_13
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lmiui/provider/ExtraTelephony$Whitelist;->CONTENT_URI:Landroid/net/Uri;

    invoke-static {v1, p1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 527
    .local v6, c:Landroid/database/Cursor;
    const/4 v7, 0x0

    .line 528
    .local v7, result:Z
    if-eqz v6, :cond_2e

    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_2e

    .line 529
    const/4 v7, 0x1

    .line 532
    :cond_2e
    if-eqz v6, :cond_12

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto :goto_12
.end method

.method public static isSkipInCallLogForFirewall(Landroid/content/Context;)Z
    .registers 4
    .parameter "context"

    .prologue
    const/4 v0, 0x1

    .line 761
    if-nez p0, :cond_b

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "context should not be null!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 763
    :cond_b
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "firewall_hide_calllog"

    invoke-static {v1, v2, v0}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v1

    if-eqz v1, :cond_18

    :goto_17
    return v0

    :cond_18
    const/4 v0, 0x0

    goto :goto_17
.end method

.method private static isStranger(Landroid/content/Context;Ljava/lang/String;)Z
    .registers 10
    .parameter "context"
    .parameter "phone"

    .prologue
    const/4 v3, 0x0

    .line 471
    const/4 v7, 0x1

    .line 472
    .local v7, stranger:Z
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Landroid/provider/ContactsContract$PhoneLookup;->CONTENT_FILTER_URI:Landroid/net/Uri;

    invoke-static {v1, p1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    sget-object v2, Lmiui/provider/ExtraTelephony;->COLUMNS:[Ljava/lang/String;

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 476
    .local v6, cursor:Landroid/database/Cursor;
    if-eqz v6, :cond_2b

    .line 477
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_28

    .line 479
    const/4 v0, 0x0

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_28

    .line 480
    const/4 v7, 0x0

    .line 483
    :cond_28
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 486
    :cond_2b
    return v7
.end method

.method private static isWhitelistEnabled(Landroid/content/Context;)Z
    .registers 4
    .parameter "context"

    .prologue
    const/4 v0, 0x1

    .line 590
    if-nez p0, :cond_b

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "context should not be null!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 592
    :cond_b
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string/jumbo v2, "whitelist_enabled"

    invoke-static {v1, v2, v0}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v1

    if-eqz v1, :cond_19

    :goto_18
    return v0

    :cond_19
    const/4 v0, 0x0

    goto :goto_18
.end method

.method public static shouldBlockByFirewall(Landroid/content/Context;Ljava/lang/String;)I
    .registers 3
    .parameter "context"
    .parameter "phone"

    .prologue
    const/4 v0, 0x1

    .line 623
    invoke-static {p0, p1, v0, v0}, Lmiui/provider/ExtraTelephony;->shouldBlockByFirewall(Landroid/content/Context;Ljava/lang/String;ZZ)I

    move-result v0

    return v0
.end method

.method public static shouldBlockByFirewall(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I
    .registers 5
    .parameter "context"
    .parameter "phone"
    .parameter "smsBody"

    .prologue
    const/4 v1, 0x1

    .line 627
    invoke-static {p0, p1, v1, v1}, Lmiui/provider/ExtraTelephony;->shouldBlockByFirewall(Landroid/content/Context;Ljava/lang/String;ZZ)I

    move-result v0

    .line 629
    .local v0, result:I
    if-nez v0, :cond_b

    .line 630
    invoke-static {p0, p1, p2}, Lmiui/provider/ExtraTelephony;->shouldFilter(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 633
    :cond_b
    return v0
.end method

.method public static shouldBlockByFirewall(Landroid/content/Context;Ljava/lang/String;Z)I
    .registers 4
    .parameter "context"
    .parameter "phone"
    .parameter "stranger"

    .prologue
    .line 637
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lmiui/provider/ExtraTelephony;->shouldBlockByFirewall(Landroid/content/Context;Ljava/lang/String;ZZ)I

    move-result v0

    return v0
.end method

.method private static shouldBlockByFirewall(Landroid/content/Context;Ljava/lang/String;ZZ)I
    .registers 10
    .parameter "context"
    .parameter "phone"
    .parameter "stranger"
    .parameter "queryContact"

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x2

    const/4 v1, 0x0

    .line 648
    invoke-static {p0}, Lmiui/provider/ExtraTelephony;->isFirewallEnabled(Landroid/content/Context;)Z

    move-result v4

    if-nez v4, :cond_a

    .line 682
    :cond_9
    :goto_9
    return v1

    .line 650
    :cond_a
    invoke-static {p0}, Lmiui/provider/ExtraTelephony;->isInFirewallTimeLimit(Landroid/content/Context;)Z

    move-result v4

    if-eqz v4, :cond_9

    .line 655
    invoke-static {p0}, Lmiui/provider/ExtraTelephony;->isBlacklistEnabled(Landroid/content/Context;)Z

    move-result v4

    if-eqz v4, :cond_1e

    invoke-static {p0, p1}, Lmiui/provider/ExtraTelephony;->isInBlacklist(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1e

    move v1, v2

    .line 656
    goto :goto_9

    .line 659
    :cond_1e
    invoke-static {p0}, Lmiui/provider/ExtraTelephony;->isWhitelistEnabled(Landroid/content/Context;)Z

    move-result v4

    if-eqz v4, :cond_2a

    invoke-static {p0, p1}, Lmiui/provider/ExtraTelephony;->isInWhitelist(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_9

    .line 663
    :cond_2a
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    const-string v5, "incoming_call_limit_setting"

    invoke-static {v4, v5, v1}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    .line 666
    .local v0, limitSetting:I
    const/4 v4, 0x3

    if-ne v0, v4, :cond_39

    move v1, v3

    .line 667
    goto :goto_9

    .line 669
    :cond_39
    if-ne v0, v2, :cond_9

    .line 670
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_43

    move v1, v3

    .line 671
    goto :goto_9

    .line 673
    :cond_43
    if-eqz p3, :cond_49

    .line 674
    invoke-static {p0, p1}, Lmiui/provider/ExtraTelephony;->isStranger(Landroid/content/Context;Ljava/lang/String;)Z

    move-result p2

    .line 677
    :cond_49
    if-eqz p2, :cond_9

    move v1, v3

    .line 678
    goto :goto_9
.end method

.method private static shouldFilter(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I
    .registers 14
    .parameter "context"
    .parameter "phone"
    .parameter "smsBody"

    .prologue
    const/4 v3, 0x0

    const/4 v10, 0x0

    .line 686
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 725
    :cond_8
    :goto_8
    return v10

    .line 688
    :cond_9
    invoke-static {p0}, Lmiui/provider/ExtraTelephony;->isFilterSmsEnabled(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 690
    invoke-static {p0, p1}, Lmiui/provider/ExtraTelephony;->isStranger(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v9

    .line 691
    .local v9, stranger:Z
    if-eqz v9, :cond_8

    .line 695
    invoke-static {p0, p1}, Lmiui/provider/ExtraTelephony;->isInWhitelist(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 699
    invoke-static {p0, p1}, Lmiui/provider/ExtraTelephony;->isCallLogNumber(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 703
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lmiui/provider/ExtraTelephony$Keyword;->CONTENT_URI:Landroid/net/Uri;

    sget-object v2, Lmiui/provider/ExtraTelephony;->KEYWORD_COLUMNS:[Ljava/lang/String;

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 707
    .local v7, cursor:Landroid/database/Cursor;
    const/4 v8, 0x0

    .line 708
    .local v8, matched:Z
    if-eqz v7, :cond_50

    .line 709
    :cond_32
    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_4d

    .line 710
    invoke-interface {v7, v10}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    .line 711
    .local v6, Keyword:Ljava/lang/String;
    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_32

    .line 712
    invoke-virtual {p2, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_32

    .line 713
    const/4 v8, 0x1

    .line 718
    .end local v6           #Keyword:Ljava/lang/String;
    :cond_4d
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 721
    :cond_50
    if-nez v8, :cond_56

    .line 722
    invoke-static {p0, p1, p2}, Lmiui/provider/ExtraGuard;->checkSms(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v8

    .line 725
    :cond_56
    if-eqz v8, :cond_5b

    const/4 v0, 0x3

    :goto_59
    move v10, v0

    goto :goto_8

    :cond_5b
    move v0, v10

    goto :goto_59
.end method
