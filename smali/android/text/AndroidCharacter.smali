.class public Landroid/text/AndroidCharacter;
.super Ljava/lang/Object;
.source "AndroidCharacter.java"


# static fields
.field public static final EAST_ASIAN_WIDTH_AMBIGUOUS:I = 0x1

.field public static final EAST_ASIAN_WIDTH_FULL_WIDTH:I = 0x3

.field public static final EAST_ASIAN_WIDTH_HALF_WIDTH:I = 0x2

.field public static final EAST_ASIAN_WIDTH_NARROW:I = 0x4

.field public static final EAST_ASIAN_WIDTH_NEUTRAL:I = 0x0

.field public static final EAST_ASIAN_WIDTH_WIDE:I = 0x5


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 23
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static native getDirectionalities([C[BI)V
.end method

.method public static native getEastAsianWidth(C)I
.end method

.method public static native getEastAsianWidths([CII[B)V
.end method

.method public static native getMirror(C)C
.end method

.method public static native mirror([CII)Z
.end method
