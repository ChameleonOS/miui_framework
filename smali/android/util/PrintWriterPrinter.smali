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
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/util/PrintWriterPrinter;->mPW:Ljava/io/PrintWriter;

    return-void
.end method


# virtual methods
.method public println(Ljava/lang/String;)V
    .registers 3
    .parameter "x"

    .prologue
    iget-object v0, p0, Landroid/util/PrintWriterPrinter;->mPW:Ljava/io/PrintWriter;

    invoke-virtual {v0, p1}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    return-void
.end method
