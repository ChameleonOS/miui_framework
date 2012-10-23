.class public abstract Landroid/text/LoginFilter;
.super Ljava/lang/Object;
.source "LoginFilter.java"

# interfaces
.implements Landroid/text/InputFilter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/text/LoginFilter$PasswordFilterGMail;,
        Landroid/text/LoginFilter$UsernameFilterGeneric;,
        Landroid/text/LoginFilter$UsernameFilterGMail;
    }
.end annotation


# instance fields
.field private mAppendInvalid:Z


# direct methods
.method constructor <init>()V
    .registers 2

    .prologue
    .line 36
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/text/LoginFilter;->mAppendInvalid:Z

    .line 38
    return-void
.end method

.method constructor <init>(Z)V
    .registers 2
    .parameter "appendInvalid"

    .prologue
    .line 29
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-boolean p1, p0, Landroid/text/LoginFilter;->mAppendInvalid:Z

    .line 31
    return-void
.end method


# virtual methods
.method public filter(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;
    .registers 12
    .parameter "source"
    .parameter "start"
    .parameter "end"
    .parameter "dest"
    .parameter "dstart"
    .parameter "dend"

    .prologue
    .line 52
    invoke-virtual {p0}, Landroid/text/LoginFilter;->onStart()V

    .line 56
    const/4 v1, 0x0

    .local v1, i:I
    :goto_4
    if-ge v1, p5, :cond_16

    .line 57
    invoke-interface {p4, v1}, Landroid/text/Spanned;->charAt(I)C

    move-result v0

    .line 58
    .local v0, c:C
    invoke-virtual {p0, v0}, Landroid/text/LoginFilter;->isAllowed(C)Z

    move-result v4

    if-nez v4, :cond_13

    invoke-virtual {p0, v0}, Landroid/text/LoginFilter;->onInvalidCharacter(C)V

    .line 56
    :cond_13
    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    .line 62
    .end local v0           #c:C
    :cond_16
    const/4 v2, 0x0

    .line 63
    .local v2, modification:Landroid/text/SpannableStringBuilder;
    const/4 v3, 0x0

    .line 65
    .local v3, modoff:I
    move v1, p2

    :goto_19
    if-ge v1, p3, :cond_43

    .line 66
    invoke-interface {p1, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 67
    .restart local v0       #c:C
    invoke-virtual {p0, v0}, Landroid/text/LoginFilter;->isAllowed(C)Z

    move-result v4

    if-eqz v4, :cond_2a

    .line 69
    add-int/lit8 v3, v3, 0x1

    .line 65
    :goto_27
    add-int/lit8 v1, v1, 0x1

    goto :goto_19

    .line 71
    :cond_2a
    iget-boolean v4, p0, Landroid/text/LoginFilter;->mAppendInvalid:Z

    if-eqz v4, :cond_34

    .line 72
    add-int/lit8 v3, v3, 0x1

    .line 82
    :goto_30
    invoke-virtual {p0, v0}, Landroid/text/LoginFilter;->onInvalidCharacter(C)V

    goto :goto_27

    .line 74
    :cond_34
    if-nez v2, :cond_3d

    .line 75
    new-instance v2, Landroid/text/SpannableStringBuilder;

    .end local v2           #modification:Landroid/text/SpannableStringBuilder;
    invoke-direct {v2, p1, p2, p3}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;II)V

    .line 76
    .restart local v2       #modification:Landroid/text/SpannableStringBuilder;
    sub-int v3, v1, p2

    .line 79
    :cond_3d
    add-int/lit8 v4, v3, 0x1

    invoke-virtual {v2, v3, v4}, Landroid/text/SpannableStringBuilder;->delete(II)Landroid/text/SpannableStringBuilder;

    goto :goto_30

    .line 88
    .end local v0           #c:C
    :cond_43
    move v1, p6

    :goto_44
    invoke-interface {p4}, Landroid/text/Spanned;->length()I

    move-result v4

    if-ge v1, v4, :cond_5a

    .line 89
    invoke-interface {p4, v1}, Landroid/text/Spanned;->charAt(I)C

    move-result v0

    .line 90
    .restart local v0       #c:C
    invoke-virtual {p0, v0}, Landroid/text/LoginFilter;->isAllowed(C)Z

    move-result v4

    if-nez v4, :cond_57

    invoke-virtual {p0, v0}, Landroid/text/LoginFilter;->onInvalidCharacter(C)V

    .line 88
    :cond_57
    add-int/lit8 v1, v1, 0x1

    goto :goto_44

    .line 93
    .end local v0           #c:C
    :cond_5a
    invoke-virtual {p0}, Landroid/text/LoginFilter;->onStop()V

    .line 97
    return-object v2
.end method

.method public abstract isAllowed(C)Z
.end method

.method public onInvalidCharacter(C)V
    .registers 2
    .parameter "c"

    .prologue
    .line 113
    return-void
.end method

.method public onStart()V
    .registers 1

    .prologue
    .line 105
    return-void
.end method

.method public onStop()V
    .registers 1

    .prologue
    .line 120
    return-void
.end method
