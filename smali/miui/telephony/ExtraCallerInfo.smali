.class public Lmiui/telephony/ExtraCallerInfo;
.super Ljava/lang/Object;
.source "ExtraCallerInfo.java"


# instance fields
.field public company:Ljava/lang/String;

.field public displayName:Ljava/lang/String;

.field public isSpNumber:Z


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 12
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getExtraCallerInfo(Landroid/content/Context;Lcom/android/internal/telephony/CallerInfo;Landroid/database/Cursor;)Lmiui/telephony/ExtraCallerInfo;
    .registers 6
    .parameter "context"
    .parameter "info"
    .parameter "cursor"

    .prologue
    .line 18
    iget-object v1, p1, Lcom/android/internal/telephony/CallerInfo;->extra:Lmiui/telephony/ExtraCallerInfo;

    .line 19
    .local v1, extra:Lmiui/telephony/ExtraCallerInfo;
    const/4 v2, 0x0

    iput-boolean v2, v1, Lmiui/telephony/ExtraCallerInfo;->isSpNumber:Z

    .line 20
    const/4 v2, 0x0

    iput-object v2, v1, Lmiui/telephony/ExtraCallerInfo;->company:Ljava/lang/String;

    .line 21
    const-string v2, "company"

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 22
    .local v0, columnIndex:I
    const/4 v2, -0x1

    if-eq v0, v2, :cond_17

    .line 23
    invoke-interface {p2, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lmiui/telephony/ExtraCallerInfo;->company:Ljava/lang/String;

    .line 25
    :cond_17
    invoke-static {p0, p1, p2}, Lmiui/telephony/CallerInfo;->updateDisplayName(Landroid/content/Context;Lcom/android/internal/telephony/CallerInfo;Landroid/database/Cursor;)V

    .line 26
    return-object v1
.end method
