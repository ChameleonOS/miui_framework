.class public Landroid/text/InputFilter$AllCaps;
.super Ljava/lang/Object;
.source "InputFilter.java"

# interfaces
.implements Landroid/text/InputFilter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/text/InputFilter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AllCaps"
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 49
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public filter(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;
    .registers 16
    .parameter "source"
    .parameter "start"
    .parameter "end"
    .parameter "dest"
    .parameter "dstart"
    .parameter "dend"

    .prologue
    const/4 v3, 0x0

    const/4 v5, 0x0

    .line 52
    move v6, p2

    .local v6, i:I
    :goto_3
    if-ge v6, p3, :cond_36

    .line 53
    invoke-interface {p1, v6}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    invoke-static {v0}, Ljava/lang/Character;->isLowerCase(C)Z

    move-result v0

    if-eqz v0, :cond_33

    .line 54
    sub-int v0, p3, p2

    new-array v8, v0, [C

    .line 55
    .local v8, v:[C
    invoke-static {p1, p2, p3, v8, v5}, Landroid/text/TextUtils;->getChars(Ljava/lang/CharSequence;II[CI)V

    .line 56
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v8}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v7

    .line 58
    .local v7, s:Ljava/lang/String;
    instance-of v0, p1, Landroid/text/Spanned;

    if-eqz v0, :cond_31

    .line 59
    new-instance v4, Landroid/text/SpannableString;

    invoke-direct {v4, v7}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .local v4, sp:Landroid/text/SpannableString;
    move-object v0, p1

    .line 60
    check-cast v0, Landroid/text/Spanned;

    move v1, p2

    move v2, p3

    invoke-static/range {v0 .. v5}, Landroid/text/TextUtils;->copySpansFrom(Landroid/text/Spanned;IILjava/lang/Class;Landroid/text/Spannable;I)V

    .line 69
    .end local v4           #sp:Landroid/text/SpannableString;
    .end local v7           #s:Ljava/lang/String;
    .end local v8           #v:[C
    :goto_30
    return-object v4

    .restart local v7       #s:Ljava/lang/String;
    .restart local v8       #v:[C
    :cond_31
    move-object v4, v7

    .line 64
    goto :goto_30

    .line 52
    .end local v7           #s:Ljava/lang/String;
    .end local v8           #v:[C
    :cond_33
    add-int/lit8 v6, v6, 0x1

    goto :goto_3

    :cond_36
    move-object v4, v3

    .line 69
    goto :goto_30
.end method
