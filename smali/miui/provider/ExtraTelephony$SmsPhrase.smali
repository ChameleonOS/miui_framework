.class public final Lmiui/provider/ExtraTelephony$SmsPhrase;
.super Ljava/lang/Object;
.source "ExtraTelephony.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/ExtraTelephony;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "SmsPhrase"
.end annotation


# static fields
.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/smsphrase"

.field public static final CONTENT_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/smsphrase"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 424
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
