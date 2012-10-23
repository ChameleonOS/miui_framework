.class public final Lmiui/provider/ExtraContacts$EmotionStatus;
.super Ljava/lang/Object;
.source "ExtraContacts.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/ExtraContacts;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "EmotionStatus"
.end annotation


# static fields
.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.com.miui.cursor.item/emotionStatus"

.field public static final TYPE_MARRIED:I = 0x3

.field public static final TYPE_SINGLEL:I = 0x1

.field public static final TYPE_UNMARRIED:I = 0x2

.field public static final VALUE:Ljava/lang/String; = "data1"


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 752
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 753
    return-void
.end method
