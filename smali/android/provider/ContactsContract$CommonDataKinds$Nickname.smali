.class public final Landroid/provider/ContactsContract$CommonDataKinds$Nickname;
.super Ljava/lang/Object;
.source "ContactsContract.java"

# interfaces
.implements Landroid/provider/ContactsContract$DataColumnsWithJoins;
.implements Landroid/provider/ContactsContract$CommonDataKinds$CommonColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/provider/ContactsContract$CommonDataKinds;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Nickname"
.end annotation


# static fields
.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/nickname"

.field public static final NAME:Ljava/lang/String; = "data1"

.field public static final TYPE_DEFAULT:I = 0x1

.field public static final TYPE_INITIALS:I = 0x5

.field public static final TYPE_MAIDEN_NAME:I = 0x3

.field public static final TYPE_MAINDEN_NAME:I = 0x3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final TYPE_OTHER_NAME:I = 0x2

.field public static final TYPE_SHORT_NAME:I = 0x4


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 5307
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
