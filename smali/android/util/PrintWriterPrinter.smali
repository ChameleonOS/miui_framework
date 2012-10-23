.class public Landroid/util/PrintWriterPrinter;
.super Ljava/lang/Object;
.source "PrintWriterPrinter.java"

# interfaces
.implements Landroid/util/Printer;


# instance fields
.field private final mPW:Ljava/io/PrintWriter;


# direct methods
.method public constructor <init>(Ljava/io/PrintWriter;)V
    .registers 2
    .parameter "pw"

    .prologue
    .line 33
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Landroid/util/PrintWriterPrinter;->mPW:Ljava/io/PrintWriter;

    .line 35
    return-void
.end method


# virtual methods
.method public println(Ljava/lang/String;)V
    .registers 3
    .parameter "x"

    .prologue
    .line 38
    iget-object v0, p0, Landroid/util/PrintWriterPrinter;->mPW:Ljava/io/PrintWriter;

    invoke-virtual {v0, p1}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    .line 39
    return-void
.end method
