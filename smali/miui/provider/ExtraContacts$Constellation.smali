.class public final Lmiui/provider/ExtraContacts$Constellation;
.super Ljava/lang/Object;
.source "ExtraContacts.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/ExtraContacts;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Constellation"
.end annotation


# static fields
.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.com.miui.cursor.item/constellation"

.field public static final TYPE_AQUARIUS:I = 0xb

.field public static final TYPE_ARIES:I = 0x1

.field public static final TYPE_CANCER:I = 0x4

.field public static final TYPE_CAPRICORN:I = 0xa

.field public static final TYPE_GEMINI:I = 0x3

.field public static final TYPE_LEO:I = 0x5

.field public static final TYPE_LIBRA:I = 0x7

.field public static final TYPE_PISCES:I = 0xc

.field public static final TYPE_SAGITTARIUS:I = 0x9

.field public static final TYPE_SCORPION:I = 0x8

.field public static final TYPE_TAURUS:I = 0x2

.field public static final TYPE_VIRGO:I = 0x6

.field public static final VALUE:Ljava/lang/String; = "data1"


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
