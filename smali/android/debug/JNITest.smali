.class public Landroid/debug/JNITest;
.super Ljava/lang/Object;
.source "JNITest.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 24
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 25
    return-void
.end method

.method private native part1(IDLjava/lang/String;[I)I
.end method

.method private part2(DILjava/lang/String;)I
    .registers 9
    .parameter "doubleArg"
    .parameter "fromArray"
    .parameter "stringArg"

    .prologue
    .line 39
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    double-to-float v3, p1

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 41
    invoke-static {p4}, Landroid/debug/JNITest;->part3(Ljava/lang/String;)I

    move-result v0

    .line 43
    .local v0, result:I
    add-int/lit8 v1, v0, 0x6

    return v1
.end method

.method private static native part3(Ljava/lang/String;)I
.end method


# virtual methods
.method public test(IDLjava/lang/String;)I
    .registers 11
    .parameter "intArg"
    .parameter "doubleArg"
    .parameter "stringArg"

    .prologue
    .line 28
    const/4 v0, 0x4

    new-array v5, v0, [I

    fill-array-data v5, :array_10

    .local v5, intArray:[I
    move-object v0, p0

    move v1, p1

    move-wide v2, p2

    move-object v4, p4

    .line 30
    invoke-direct/range {v0 .. v5}, Landroid/debug/JNITest;->part1(IDLjava/lang/String;[I)I

    move-result v0

    return v0

    .line 28
    nop

    :array_10
    .array-data 0x4
        0x2at 0x0t 0x0t 0x0t
        0x35t 0x0t 0x0t 0x0t
        0x41t 0x0t 0x0t 0x0t
        0x7ft 0x0t 0x0t 0x0t
    .end array-data
.end method
