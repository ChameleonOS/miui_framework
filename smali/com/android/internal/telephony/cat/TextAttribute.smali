.class public Lcom/android/internal/telephony/cat/TextAttribute;
.super Ljava/lang/Object;
.source "TextAttribute.java"


# instance fields
.field public align:Lcom/android/internal/telephony/cat/TextAlignment;

.field public bold:Z

.field public color:Lcom/android/internal/telephony/cat/TextColor;

.field public italic:Z

.field public length:I

.field public size:Lcom/android/internal/telephony/cat/FontSize;

.field public start:I

.field public strikeThrough:Z

.field public underlined:Z


# direct methods
.method public constructor <init>(IILcom/android/internal/telephony/cat/TextAlignment;Lcom/android/internal/telephony/cat/FontSize;ZZZZLcom/android/internal/telephony/cat/TextColor;)V
    .registers 10
    .parameter "start"
    .parameter "length"
    .parameter "align"
    .parameter "size"
    .parameter "bold"
    .parameter "italic"
    .parameter "underlined"
    .parameter "strikeThrough"
    .parameter "color"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/android/internal/telephony/cat/TextAttribute;->start:I

    iput p2, p0, Lcom/android/internal/telephony/cat/TextAttribute;->length:I

    iput-object p3, p0, Lcom/android/internal/telephony/cat/TextAttribute;->align:Lcom/android/internal/telephony/cat/TextAlignment;

    iput-object p4, p0, Lcom/android/internal/telephony/cat/TextAttribute;->size:Lcom/android/internal/telephony/cat/FontSize;

    iput-boolean p5, p0, Lcom/android/internal/telephony/cat/TextAttribute;->bold:Z

    iput-boolean p6, p0, Lcom/android/internal/telephony/cat/TextAttribute;->italic:Z

    iput-boolean p7, p0, Lcom/android/internal/telephony/cat/TextAttribute;->underlined:Z

    iput-boolean p8, p0, Lcom/android/internal/telephony/cat/TextAttribute;->strikeThrough:Z

    iput-object p9, p0, Lcom/android/internal/telephony/cat/TextAttribute;->color:Lcom/android/internal/telephony/cat/TextColor;

    return-void
.end method
