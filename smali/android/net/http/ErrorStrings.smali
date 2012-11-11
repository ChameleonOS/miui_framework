.class public Landroid/net/http/ErrorStrings;
.super Ljava/lang/Object;
.source "ErrorStrings.java"


# static fields
.field private static final LOGTAG:Ljava/lang/String; = "Http"


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getResource(I)I
    .registers 5
    .parameter "errorCode"

    .prologue
    const v0, 0x1040112

    packed-switch p0, :pswitch_data_5c

    const-string v1, "Http"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Using generic message for unknown error code: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :goto_1e
    :pswitch_1e
    return v0

    :pswitch_1f
    const v0, 0x1040111

    goto :goto_1e

    :pswitch_23
    const v0, 0x1040113

    goto :goto_1e

    :pswitch_27
    const v0, 0x1040114

    goto :goto_1e

    :pswitch_2b
    const v0, 0x1040115

    goto :goto_1e

    :pswitch_2f
    const v0, 0x1040116

    goto :goto_1e

    :pswitch_33
    const v0, 0x1040117

    goto :goto_1e

    :pswitch_37
    const v0, 0x1040118

    goto :goto_1e

    :pswitch_3b
    const v0, 0x1040119

    goto :goto_1e

    :pswitch_3f
    const v0, 0x104011a

    goto :goto_1e

    :pswitch_43
    const v0, 0x1040008

    goto :goto_1e

    :pswitch_47
    const v0, 0x104011b

    goto :goto_1e

    :pswitch_4b
    const v0, 0x1040007

    goto :goto_1e

    :pswitch_4f
    const v0, 0x104011c

    goto :goto_1e

    :pswitch_53
    const v0, 0x104011d

    goto :goto_1e

    :pswitch_57
    const v0, 0x104011e

    goto :goto_1e

    nop

    :pswitch_data_5c
    .packed-switch -0xf
        :pswitch_57
        :pswitch_53
        :pswitch_4f
        :pswitch_4b
        :pswitch_47
        :pswitch_43
        :pswitch_3f
        :pswitch_3b
        :pswitch_37
        :pswitch_33
        :pswitch_2f
        :pswitch_2b
        :pswitch_27
        :pswitch_23
        :pswitch_1e
        :pswitch_1f
    .end packed-switch
.end method

.method public static getString(ILandroid/content/Context;)Ljava/lang/String;
    .registers 3
    .parameter "errorCode"
    .parameter "context"

    .prologue
    invoke-static {p0}, Landroid/net/http/ErrorStrings;->getResource(I)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
