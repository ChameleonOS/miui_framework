.class public final Landroid/provider/ContactsContract$CommonDataKinds$Organization;
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
    name = "Organization"
.end annotation


# static fields
.field public static final COMPANY:Ljava/lang/String; = "data1"

.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/organization"

.field public static final DEPARTMENT:Ljava/lang/String; = "data5"

.field public static final JOB_DESCRIPTION:Ljava/lang/String; = "data6"

.field public static final OFFICE_LOCATION:Ljava/lang/String; = "data9"

.field public static final PHONETIC_NAME:Ljava/lang/String; = "data8"

.field public static final PHONETIC_NAME_STYLE:Ljava/lang/String; = "data10"

.field public static final SYMBOL:Ljava/lang/String; = "data7"

.field public static final TITLE:Ljava/lang/String; = "data4"

.field public static final TYPE_OTHER:I = 0x2

.field public static final TYPE_WORK:I = 0x1


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 6153
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final getTypeLabel(Landroid/content/res/Resources;ILjava/lang/CharSequence;)Ljava/lang/CharSequence;
    .registers 5
    .parameter "res"
    .parameter "type"
    .parameter "label"

    .prologue
    .line 6229
    if-nez p1, :cond_9

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_9

    .line 6233
    .end local p2
    :goto_8
    return-object p2

    .line 6232
    .restart local p2
    :cond_9
    invoke-static {p1}, Landroid/provider/ContactsContract$CommonDataKinds$Organization;->getTypeLabelResource(I)I

    move-result v0

    .line 6233
    .local v0, labelRes:I
    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object p2

    goto :goto_8
.end method

.method public static final getTypeLabelResource(I)I
    .registers 2
    .parameter "type"

    .prologue
    .line 6215
    packed-switch p0, :pswitch_data_10

    .line 6218
    const v0, 0x10402d8

    :goto_6
    return v0

    .line 6216
    :pswitch_7
    const v0, 0x10402d6

    goto :goto_6

    .line 6217
    :pswitch_b
    const v0, 0x10402d7

    goto :goto_6

    .line 6215
    nop

    :pswitch_data_10
    .packed-switch 0x1
        :pswitch_7
        :pswitch_b
    .end packed-switch
.end method
