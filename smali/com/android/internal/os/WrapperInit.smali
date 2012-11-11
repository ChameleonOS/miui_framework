.class public Lcom/android/internal/os/WrapperInit;
.super Ljava/lang/Object;
.source "WrapperInit.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "AndroidRuntime"


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static execApplication(Ljava/lang/String;Ljava/lang/String;ILjava/io/FileDescriptor;[Ljava/lang/String;)V
    .registers 8
    .parameter "invokeWith"
    .parameter "niceName"
    .parameter "targetSdkVersion"
    .parameter "pipeFd"
    .parameter "args"

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, p0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .local v0, command:Ljava/lang/StringBuilder;
    const-string v1, " /system/bin/app_process /system/bin --application"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    if-eqz p1, :cond_1b

    const-string v1, " \'--nice-name="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_1b
    const-string v1, " com.android.internal.os.WrapperInit "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    if-eqz p3, :cond_3c

    invoke-virtual {p3}, Ljava/io/FileDescriptor;->getInt$()I

    move-result v1

    :goto_26
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-static {v0, p4}, Ldalvik/system/Zygote;->appendQuotedShellArgs(Ljava/lang/StringBuilder;[Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ldalvik/system/Zygote;->execShell(Ljava/lang/String;)V

    return-void

    :cond_3c
    const/4 v1, 0x0

    goto :goto_26
.end method

.method public static execStandalone(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    .registers 6
    .parameter "invokeWith"
    .parameter "classPath"
    .parameter "className"
    .parameter "args"

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, p0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .local v0, command:Ljava/lang/StringBuilder;
    const-string v1, " /system/bin/dalvikvm -classpath \'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\' "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {v0, p3}, Ldalvik/system/Zygote;->appendQuotedShellArgs(Ljava/lang/StringBuilder;[Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ldalvik/system/Zygote;->execShell(Ljava/lang/String;)V

    return-void
.end method

.method public static main([Ljava/lang/String;)V
    .registers 11
    .parameter "args"

    .prologue
    const/4 v7, 0x0

    :try_start_1
    aget-object v7, p0, v7

    const/16 v8, 0xa

    invoke-static {v7, v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v3

    .local v3, fdNum:I
    const/4 v7, 0x1

    aget-object v7, p0, v7

    const/16 v8, 0xa

    invoke-static {v7, v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I
    :try_end_11
    .catch Lcom/android/internal/os/ZygoteInit$MethodAndArgsCaller; {:try_start_1 .. :try_end_11} :catch_4a

    move-result v6

    .local v6, targetSdkVersion:I
    if-eqz v3, :cond_2f

    :try_start_14
    invoke-static {v3}, Lcom/android/internal/os/ZygoteInit;->createFileDescriptor(I)Ljava/io/FileDescriptor;

    move-result-object v2

    .local v2, fd:Ljava/io/FileDescriptor;
    new-instance v4, Ljava/io/DataOutputStream;

    new-instance v7, Ljava/io/FileOutputStream;

    invoke-direct {v7, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/FileDescriptor;)V

    invoke-direct {v4, v7}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    .local v4, os:Ljava/io/DataOutputStream;
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v7

    invoke-virtual {v4, v7}, Ljava/io/DataOutputStream;->writeInt(I)V

    invoke-virtual {v4}, Ljava/io/DataOutputStream;->close()V

    invoke-static {v2}, Llibcore/io/IoUtils;->closeQuietly(Ljava/io/FileDescriptor;)V
    :try_end_2f
    .catch Ljava/io/IOException; {:try_start_14 .. :try_end_2f} :catch_41
    .catch Lcom/android/internal/os/ZygoteInit$MethodAndArgsCaller; {:try_start_14 .. :try_end_2f} :catch_4a

    .end local v2           #fd:Ljava/io/FileDescriptor;
    .end local v4           #os:Ljava/io/DataOutputStream;
    :cond_2f
    :goto_2f
    :try_start_2f
    invoke-static {}, Lcom/android/internal/os/ZygoteInit;->preload()V

    array-length v7, p0

    add-int/lit8 v7, v7, -0x2

    new-array v5, v7, [Ljava/lang/String;

    .local v5, runtimeArgs:[Ljava/lang/String;
    const/4 v7, 0x2

    const/4 v8, 0x0

    array-length v9, v5

    invoke-static {p0, v7, v5, v8, v9}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    invoke-static {v6, v5}, Lcom/android/internal/os/RuntimeInit;->wrapperInit(I[Ljava/lang/String;)V

    .end local v3           #fdNum:I
    .end local v5           #runtimeArgs:[Ljava/lang/String;
    .end local v6           #targetSdkVersion:I
    :goto_40
    return-void

    .restart local v3       #fdNum:I
    .restart local v6       #targetSdkVersion:I
    :catch_41
    move-exception v1

    .local v1, ex:Ljava/io/IOException;
    const-string v7, "AndroidRuntime"

    const-string v8, "Could not write pid of wrapped process to Zygote pipe."

    invoke-static {v7, v8, v1}, Landroid/util/Slog;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_49
    .catch Lcom/android/internal/os/ZygoteInit$MethodAndArgsCaller; {:try_start_2f .. :try_end_49} :catch_4a

    goto :goto_2f

    .end local v1           #ex:Ljava/io/IOException;
    .end local v3           #fdNum:I
    .end local v6           #targetSdkVersion:I
    :catch_4a
    move-exception v0

    .local v0, caller:Lcom/android/internal/os/ZygoteInit$MethodAndArgsCaller;
    invoke-virtual {v0}, Lcom/android/internal/os/ZygoteInit$MethodAndArgsCaller;->run()V

    goto :goto_40
.end method
