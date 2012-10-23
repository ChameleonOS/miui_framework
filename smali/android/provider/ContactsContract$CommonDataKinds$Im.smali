.class public final Landroid/provider/ContactsContract$CommonDataKinds$Im;
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
    name = "Im"
.end annotation


# static fields
.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/im"

.field public static final CUSTOM_PROTOCOL:Ljava/lang/String; = "data6"

.field public static final PROTOCOL:Ljava/lang/String; = "data5"

.field public static final PROTOCOL_AIM:I = 0x0

.field public static final PROTOCOL_CUSTOM:I = -0x1

.field public static final PROTOCOL_GOOGLE_TALK:I = 0x5

.field public static final PROTOCOL_ICQ:I = 0x6

.field public static final PROTOCOL_JABBER:I = 0x7

.field public static final PROTOCOL_MSN:I = 0x1

.field public static final PROTOCOL_NETMEETING:I = 0x8

.field public static final PROTOCOL_QQ:I = 0x4

.field public static final PROTOCOL_SKYPE:I = 0x3

.field public static final PROTOCOL_YAHOO:I = 0x2

.field public static final TYPE_HOME:I = 0x1

.field public static final TYPE_OTHER:I = 0x3

.field public static final TYPE_WORK:I = 0x2


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 5969
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final getProtocolLabel(Landroid/content/res/Resources;ILjava/lang/CharSequence;)Ljava/lang/CharSequence;
    .registers 5
    .parameter "res"
    .parameter "type"
    .parameter "label"

    .prologue
    .line 6056
    const/4 v1, -0x1

    if-ne p1, v1, :cond_a

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_a

    .line 6060
    .end local p2
    :goto_9
    return-object p2

    .line 6059
    .restart local p2
    :cond_a
    invoke-static {p1}, Landroid/provider/ContactsContract$CommonDataKinds$Im;->getProtocolLabelResource(I)I

    move-result v0

    .line 6060
    .local v0, labelRes:I
    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object p2

    goto :goto_9
.end method

.method public static final getProtocolLabelResource(I)I
    .registers 2
    .parameter "type"

    .prologue
    .line 6035
    packed-switch p0, :pswitch_data_2c

    .line 6045
    const v0, 0x10402cc

    :goto_6
    return v0

    .line 6036
    :pswitch_7
    const v0, 0x10402cd

    goto :goto_6

    .line 6037
    :pswitch_b
    const v0, 0x10402ce

    goto :goto_6

    .line 6038
    :pswitch_f
    const v0, 0x10402cf

    goto :goto_6

    .line 6039
    :pswitch_13
    const v0, 0x10402d0

    goto :goto_6

    .line 6040
    :pswitch_17
    const v0, 0x10402d1

    goto :goto_6

    .line 6041
    :pswitch_1b
    const v0, 0x10402d2

    goto :goto_6

    .line 6042
    :pswitch_1f
    const v0, 0x10402d3

    goto :goto_6

    .line 6043
    :pswitch_23
    const v0, 0x10402d4

    goto :goto_6

    .line 6044
    :pswitch_27
    const v0, 0x10402d5

    goto :goto_6

    .line 6035
    nop

    :pswitch_data_2c
    .packed-switch 0x0
        :pswitch_7
        :pswitch_b
        :pswitch_f
        :pswitch_13
        :pswitch_17
        :pswitch_1b
        :pswitch_1f
        :pswitch_23
        :pswitch_27
    .end packed-switch
.end method

.method public static final getTypeLabel(Landroid/content/res/Resources;ILjava/lang/CharSequence;)Ljava/lang/CharSequence;
    .registers 5
    .parameter "res"
    .parameter "type"
    .parameter "label"

    .prologue
    .line 6022
    if-nez p1, :cond_9

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_9

    .line 6026
    .end local p2
    :goto_8
    return-object p2

    .line 6025
    .restart local p2
    :cond_9
    invoke-static {p1}, Landroid/provider/ContactsContract$CommonDataKinds$Im;->getTypeLabelResource(I)I

    move-result v0

    .line 6026
    .local v0, labelRes:I
    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object p2

    goto :goto_8
.end method

.method public static final getTypeLabelResource(I)I
    .registers 2
    .parameter "type"

    .prologue
    .line 6007
    packed-switch p0, :pswitch_data_14

    .line 6011
    const v0, 0x10402c8

    :goto_6
    return v0

    .line 6008
    :pswitch_7
    const v0, 0x10402c9

    goto :goto_6

    .line 6009
    :pswitch_b
    const v0, 0x10402ca

    goto :goto_6

    .line 6010
    :pswitch_f
    const v0, 0x10402cb

    goto :goto_6

    .line 6007
    nop

    :pswitch_data_14
    .packed-switch 0x1
        :pswitch_7
        :pswitch_b
        :pswitch_f
    .end packed-switch
.end method
