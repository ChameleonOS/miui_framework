.class public Lcom/miui/internal/app/ShutdownAlarm;
.super Ljava/lang/Object;
.source "ShutdownAlarm.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "ShutdownAlarm"

.field private static final WAKEALARM_PATH:Ljava/lang/String; = "/sys/class/rtc/rtc0/wakealarm"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 18
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static buildShutdownAlarmCheckBox(Landroid/content/Context;)Landroid/widget/CheckBox;
    .registers 14
    .parameter "context"

    .prologue
    const/4 v7, 0x0

    const/4 v8, 0x1

    .line 92
    invoke-static {}, Lcom/miui/internal/app/ShutdownAlarm;->readWakeAlarm()J

    move-result-wide v9

    const-wide/16 v11, 0x3e8

    mul-long v5, v9, v11

    .line 93
    .local v5, wakeAlarm:J
    invoke-static {v5, v6}, Lcom/miui/internal/app/ShutdownAlarm;->getWakeAlarmDeltaDays(J)I

    move-result v1

    .line 94
    .local v1, days:I
    if-eqz v1, :cond_12

    if-ne v1, v8, :cond_50

    :cond_12
    move v3, v8

    .line 95
    .local v3, showWakeAlarmMessage:Z
    :goto_13
    const/4 v4, 0x0

    .line 96
    .local v4, shutAlarmCheckBox:Landroid/widget/CheckBox;
    if-eqz v3, :cond_4f

    .line 97
    new-instance v4, Landroid/widget/CheckBox;

    .end local v4           #shutAlarmCheckBox:Landroid/widget/CheckBox;
    invoke-direct {v4, p0}, Landroid/widget/CheckBox;-><init>(Landroid/content/Context;)V

    .line 98
    .restart local v4       #shutAlarmCheckBox:Landroid/widget/CheckBox;
    invoke-virtual {v4, v8}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 99
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 100
    .local v2, sb:Ljava/lang/StringBuilder;
    if-nez v1, :cond_52

    .line 101
    const v9, 0x60c01d1

    invoke-virtual {p0, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 105
    :cond_2f
    :goto_2f
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 106
    .local v0, c:Ljava/util/Calendar;
    invoke-virtual {v0, v5, v6}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 107
    invoke-static {p0, v0}, Lcom/miui/internal/app/ShutdownAlarm;->formatTime(Landroid/content/Context;Ljava/util/Calendar;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 108
    const v9, 0x60c01f5

    new-array v8, v8, [Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v7

    invoke-virtual {p0, v9, v8}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Landroid/widget/CheckBox;->setText(Ljava/lang/CharSequence;)V

    .line 111
    .end local v0           #c:Ljava/util/Calendar;
    .end local v2           #sb:Ljava/lang/StringBuilder;
    :cond_4f
    return-object v4

    .end local v3           #showWakeAlarmMessage:Z
    .end local v4           #shutAlarmCheckBox:Landroid/widget/CheckBox;
    :cond_50
    move v3, v7

    .line 94
    goto :goto_13

    .line 102
    .restart local v2       #sb:Ljava/lang/StringBuilder;
    .restart local v3       #showWakeAlarmMessage:Z
    .restart local v4       #shutAlarmCheckBox:Landroid/widget/CheckBox;
    :cond_52
    if-ne v1, v8, :cond_2f

    .line 103
    const v9, 0x60c01a9

    invoke-virtual {p0, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2f
.end method

.method private static formatTime(Landroid/content/Context;Ljava/util/Calendar;)Ljava/lang/String;
    .registers 4
    .parameter "context"
    .parameter "c"

    .prologue
    .line 115
    invoke-static {p0}, Landroid/text/format/DateFormat;->is24HourFormat(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_d

    const-string v0, "kk:mm"

    .line 118
    .local v0, format:Ljava/lang/String;
    :goto_8
    if-nez p1, :cond_15

    const-string v1, ""

    :goto_c
    return-object v1

    .line 115
    .end local v0           #format:Ljava/lang/String;
    :cond_d
    const v1, 0x60c01f6

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_8

    .line 118
    .restart local v0       #format:Ljava/lang/String;
    :cond_15
    invoke-static {v0, p1}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;Ljava/util/Calendar;)Ljava/lang/CharSequence;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    goto :goto_c
.end method

.method private static getWakeAlarmDeltaDays(J)I
    .registers 11
    .parameter "wakeAlarm"

    .prologue
    const/4 v8, 0x7

    .line 78
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    sub-long v3, p0, v6

    .line 79
    .local v3, delta:J
    const/4 v2, -0x1

    .line 80
    .local v2, days:I
    const-wide/16 v6, 0x0

    cmp-long v6, v3, v6

    if-lez v6, :cond_43

    const-wide/32 v6, 0xa4cb800

    cmp-long v6, v3, v6

    if-gez v6, :cond_43

    .line 81
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 82
    .local v0, c:Ljava/util/Calendar;
    invoke-virtual {v0, v8}, Ljava/util/Calendar;->get(I)I

    move-result v1

    .line 83
    .local v1, curDay:I
    invoke-virtual {v0, p0, p1}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 84
    invoke-virtual {v0, v8}, Ljava/util/Calendar;->get(I)I

    move-result v5

    .line 85
    .local v5, wakeDay:I
    sub-int v6, v5, v1

    add-int/lit8 v6, v6, 0x7

    rem-int/lit8 v2, v6, 0x7

    .line 86
    const-string v6, "ShutdownAlarm"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "wake alarm days: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 88
    .end local v0           #c:Ljava/util/Calendar;
    .end local v1           #curDay:I
    .end local v5           #wakeDay:I
    :cond_43
    return v2
.end method

.method public static readWakeAlarm()J
    .registers 8

    .prologue
    .line 27
    const-wide/16 v0, 0x0

    .line 28
    .local v0, alarmTime:J
    const/4 v3, 0x0

    .line 30
    .local v3, reader:Ljava/io/BufferedReader;
    :try_start_3
    new-instance v4, Ljava/io/BufferedReader;

    new-instance v5, Ljava/io/FileReader;

    const-string v6, "/sys/class/rtc/rtc0/wakealarm"

    invoke-direct {v5, v6}, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V

    invoke-direct {v4, v5}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_f
    .catchall {:try_start_3 .. :try_end_f} :catchall_64
    .catch Ljava/io/FileNotFoundException; {:try_start_3 .. :try_end_f} :catch_1f
    .catch Ljava/lang/NumberFormatException; {:try_start_3 .. :try_end_f} :catch_38
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_f} :catch_4e

    .line 31
    .end local v3           #reader:Ljava/io/BufferedReader;
    .local v4, reader:Ljava/io/BufferedReader;
    :try_start_f
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_16
    .catchall {:try_start_f .. :try_end_16} :catchall_7f
    .catch Ljava/io/FileNotFoundException; {:try_start_f .. :try_end_16} :catch_88
    .catch Ljava/lang/NumberFormatException; {:try_start_f .. :try_end_16} :catch_85
    .catch Ljava/io/IOException; {:try_start_f .. :try_end_16} :catch_82

    move-result v5

    int-to-long v0, v5

    .line 39
    if-eqz v4, :cond_1d

    .line 41
    :try_start_1a
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V
    :try_end_1d
    .catch Ljava/io/IOException; {:try_start_1a .. :try_end_1d} :catch_75

    :cond_1d
    :goto_1d
    move-object v3, v4

    .line 47
    .end local v4           #reader:Ljava/io/BufferedReader;
    .restart local v3       #reader:Ljava/io/BufferedReader;
    :cond_1e
    :goto_1e
    return-wide v0

    .line 32
    :catch_1f
    move-exception v2

    .line 33
    .local v2, e:Ljava/io/FileNotFoundException;
    :goto_20
    :try_start_20
    const-string v5, "ShutdownAlarm"

    const-string/jumbo v6, "read wake alarm error"

    invoke-static {v5, v6, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_28
    .catchall {:try_start_20 .. :try_end_28} :catchall_64

    .line 39
    if-eqz v3, :cond_1e

    .line 41
    :try_start_2a
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V
    :try_end_2d
    .catch Ljava/io/IOException; {:try_start_2a .. :try_end_2d} :catch_2e

    goto :goto_1e

    .line 42
    :catch_2e
    move-exception v2

    .line 43
    .local v2, e:Ljava/io/IOException;
    const-string v5, "ShutdownAlarm"

    const-string/jumbo v6, "read wake alarm error"

    :goto_34
    invoke-static {v5, v6, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1e

    .line 34
    .end local v2           #e:Ljava/io/IOException;
    :catch_38
    move-exception v2

    .line 35
    .local v2, e:Ljava/lang/NumberFormatException;
    :goto_39
    :try_start_39
    const-string v5, "ShutdownAlarm"

    const-string/jumbo v6, "read wake alarm error"

    invoke-static {v5, v6, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_41
    .catchall {:try_start_39 .. :try_end_41} :catchall_64

    .line 39
    if-eqz v3, :cond_1e

    .line 41
    :try_start_43
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V
    :try_end_46
    .catch Ljava/io/IOException; {:try_start_43 .. :try_end_46} :catch_47

    goto :goto_1e

    .line 42
    :catch_47
    move-exception v2

    .line 43
    .local v2, e:Ljava/io/IOException;
    const-string v5, "ShutdownAlarm"

    const-string/jumbo v6, "read wake alarm error"

    goto :goto_34

    .line 36
    .end local v2           #e:Ljava/io/IOException;
    :catch_4e
    move-exception v2

    .line 37
    .restart local v2       #e:Ljava/io/IOException;
    :goto_4f
    :try_start_4f
    const-string v5, "ShutdownAlarm"

    const-string/jumbo v6, "read wake alarm error"

    invoke-static {v5, v6, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_57
    .catchall {:try_start_4f .. :try_end_57} :catchall_64

    .line 39
    if-eqz v3, :cond_1e

    .line 41
    :try_start_59
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V
    :try_end_5c
    .catch Ljava/io/IOException; {:try_start_59 .. :try_end_5c} :catch_5d

    goto :goto_1e

    .line 42
    :catch_5d
    move-exception v2

    .line 43
    const-string v5, "ShutdownAlarm"

    const-string/jumbo v6, "read wake alarm error"

    goto :goto_34

    .line 39
    .end local v2           #e:Ljava/io/IOException;
    :catchall_64
    move-exception v5

    :goto_65
    if-eqz v3, :cond_6a

    .line 41
    :try_start_67
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V
    :try_end_6a
    .catch Ljava/io/IOException; {:try_start_67 .. :try_end_6a} :catch_6b

    .line 39
    :cond_6a
    :goto_6a
    throw v5

    .line 42
    :catch_6b
    move-exception v2

    .line 43
    .restart local v2       #e:Ljava/io/IOException;
    const-string v6, "ShutdownAlarm"

    const-string/jumbo v7, "read wake alarm error"

    invoke-static {v6, v7, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_6a

    .line 42
    .end local v2           #e:Ljava/io/IOException;
    .end local v3           #reader:Ljava/io/BufferedReader;
    .restart local v4       #reader:Ljava/io/BufferedReader;
    :catch_75
    move-exception v2

    .line 43
    .restart local v2       #e:Ljava/io/IOException;
    const-string v5, "ShutdownAlarm"

    const-string/jumbo v6, "read wake alarm error"

    invoke-static {v5, v6, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1d

    .line 39
    .end local v2           #e:Ljava/io/IOException;
    :catchall_7f
    move-exception v5

    move-object v3, v4

    .end local v4           #reader:Ljava/io/BufferedReader;
    .restart local v3       #reader:Ljava/io/BufferedReader;
    goto :goto_65

    .line 36
    .end local v3           #reader:Ljava/io/BufferedReader;
    .restart local v4       #reader:Ljava/io/BufferedReader;
    :catch_82
    move-exception v2

    move-object v3, v4

    .end local v4           #reader:Ljava/io/BufferedReader;
    .restart local v3       #reader:Ljava/io/BufferedReader;
    goto :goto_4f

    .line 34
    .end local v3           #reader:Ljava/io/BufferedReader;
    .restart local v4       #reader:Ljava/io/BufferedReader;
    :catch_85
    move-exception v2

    move-object v3, v4

    .end local v4           #reader:Ljava/io/BufferedReader;
    .restart local v3       #reader:Ljava/io/BufferedReader;
    goto :goto_39

    .line 32
    .end local v3           #reader:Ljava/io/BufferedReader;
    .restart local v4       #reader:Ljava/io/BufferedReader;
    :catch_88
    move-exception v2

    move-object v3, v4

    .end local v4           #reader:Ljava/io/BufferedReader;
    .restart local v3       #reader:Ljava/io/BufferedReader;
    goto :goto_20
.end method

.method public static writeWakeAlarm(J)V
    .registers 8
    .parameter "timeInSeconds"

    .prologue
    .line 55
    const/4 v1, 0x0

    .line 57
    .local v1, writer:Ljava/io/BufferedWriter;
    :try_start_1
    new-instance v2, Ljava/io/BufferedWriter;

    new-instance v3, Ljava/io/FileWriter;

    const-string v4, "/sys/class/rtc/rtc0/wakealarm"

    invoke-direct {v3, v4}, Ljava/io/FileWriter;-><init>(Ljava/lang/String;)V

    invoke-direct {v2, v3}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V
    :try_end_d
    .catchall {:try_start_1 .. :try_end_d} :catchall_34
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_d} :catch_1b

    .line 58
    .end local v1           #writer:Ljava/io/BufferedWriter;
    .local v2, writer:Ljava/io/BufferedWriter;
    :try_start_d
    invoke-static {p0, p1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V
    :try_end_14
    .catchall {:try_start_d .. :try_end_14} :catchall_4f
    .catch Ljava/io/IOException; {:try_start_d .. :try_end_14} :catch_52

    .line 62
    if-eqz v2, :cond_19

    .line 64
    :try_start_16
    invoke-virtual {v2}, Ljava/io/BufferedWriter;->close()V
    :try_end_19
    .catch Ljava/io/IOException; {:try_start_16 .. :try_end_19} :catch_45

    :cond_19
    :goto_19
    move-object v1, v2

    .line 70
    .end local v2           #writer:Ljava/io/BufferedWriter;
    .restart local v1       #writer:Ljava/io/BufferedWriter;
    :cond_1a
    :goto_1a
    return-void

    .line 59
    :catch_1b
    move-exception v0

    .line 60
    .local v0, e:Ljava/io/IOException;
    :goto_1c
    :try_start_1c
    const-string v3, "ShutdownAlarm"

    const-string/jumbo v4, "write wake alarm error"

    invoke-static {v3, v4, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_24
    .catchall {:try_start_1c .. :try_end_24} :catchall_34

    .line 62
    if-eqz v1, :cond_1a

    .line 64
    :try_start_26
    invoke-virtual {v1}, Ljava/io/BufferedWriter;->close()V
    :try_end_29
    .catch Ljava/io/IOException; {:try_start_26 .. :try_end_29} :catch_2a

    goto :goto_1a

    .line 65
    :catch_2a
    move-exception v0

    .line 66
    const-string v3, "ShutdownAlarm"

    const-string/jumbo v4, "write wake alarm error"

    invoke-static {v3, v4, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1a

    .line 62
    .end local v0           #e:Ljava/io/IOException;
    :catchall_34
    move-exception v3

    :goto_35
    if-eqz v1, :cond_3a

    .line 64
    :try_start_37
    invoke-virtual {v1}, Ljava/io/BufferedWriter;->close()V
    :try_end_3a
    .catch Ljava/io/IOException; {:try_start_37 .. :try_end_3a} :catch_3b

    .line 62
    :cond_3a
    :goto_3a
    throw v3

    .line 65
    :catch_3b
    move-exception v0

    .line 66
    .restart local v0       #e:Ljava/io/IOException;
    const-string v4, "ShutdownAlarm"

    const-string/jumbo v5, "write wake alarm error"

    invoke-static {v4, v5, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_3a

    .line 65
    .end local v0           #e:Ljava/io/IOException;
    .end local v1           #writer:Ljava/io/BufferedWriter;
    .restart local v2       #writer:Ljava/io/BufferedWriter;
    :catch_45
    move-exception v0

    .line 66
    .restart local v0       #e:Ljava/io/IOException;
    const-string v3, "ShutdownAlarm"

    const-string/jumbo v4, "write wake alarm error"

    invoke-static {v3, v4, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_19

    .line 62
    .end local v0           #e:Ljava/io/IOException;
    :catchall_4f
    move-exception v3

    move-object v1, v2

    .end local v2           #writer:Ljava/io/BufferedWriter;
    .restart local v1       #writer:Ljava/io/BufferedWriter;
    goto :goto_35

    .line 59
    .end local v1           #writer:Ljava/io/BufferedWriter;
    .restart local v2       #writer:Ljava/io/BufferedWriter;
    :catch_52
    move-exception v0

    move-object v1, v2

    .end local v2           #writer:Ljava/io/BufferedWriter;
    .restart local v1       #writer:Ljava/io/BufferedWriter;
    goto :goto_1c
.end method
