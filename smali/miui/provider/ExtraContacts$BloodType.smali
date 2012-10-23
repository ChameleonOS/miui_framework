.class public final Lmiui/provider/ExtraContacts$BloodType;
.super Ljava/lang/Object;
.source "ExtraContacts.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/ExtraContacts;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "BloodType"
.end annotation


# static fields
.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.com.miui.cursor.item/bloodType"

.field public static final TYPE_A:I = 0x1

.field public static final TYPE_AB:I = 0x3

.field public static final TYPE_B:I = 0x2

.field public static final TYPE_O:I = 0x4

.field public static final VALUE:Ljava/lang/String; = "data1"


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 694
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 695
    return-void
.end method
