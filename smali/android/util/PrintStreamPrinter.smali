.class public Landroid/util/PrintStreamPrinter;
.super Ljava/lang/Object;
.source "PrintStreamPrinter.java"

# interfaces
.implements Landroid/util/Printer;


# instance fields
.field private final mPS:Ljava/io/PrintStream;


# direct methods
.method public constructor <init>(Ljava/io/PrintStream;)V
    .registers 2
    .parameter "pw"

    .prologue
    .line 33
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Landroid/util/PrintStreamPrinter;->mPS:Ljava/io/PrintStream;

    .line 35
    return-void
.end method


# virtual methods
.method public println(Ljava/lang/String;)V
    .registers 3
    .parameter "x"

    .prologue
    .line 38
    iget-object v0, p0, Landroid/util/PrintStreamPrinter;->mPS:Ljava/io/PrintStream;

    invoke-virtual {v0, p1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 39
    return-void
.end method
