.class public Landroid/net/UrlQuerySanitizer$ParameterValuePair;
.super Ljava/lang/Object;
.source "UrlQuerySanitizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/UrlQuerySanitizer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ParameterValuePair"
.end annotation


# instance fields
.field public mParameter:Ljava/lang/String;

.field public mValue:Ljava/lang/String;

.field final synthetic this$0:Landroid/net/UrlQuerySanitizer;


# direct methods
.method public constructor <init>(Landroid/net/UrlQuerySanitizer;Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter
    .parameter "parameter"
    .parameter "value"

    .prologue
    .line 74
    iput-object p1, p0, Landroid/net/UrlQuerySanitizer$ParameterValuePair;->this$0:Landroid/net/UrlQuerySanitizer;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 75
    iput-object p2, p0, Landroid/net/UrlQuerySanitizer$ParameterValuePair;->mParameter:Ljava/lang/String;

    .line 76
    iput-object p3, p0, Landroid/net/UrlQuerySanitizer$ParameterValuePair;->mValue:Ljava/lang/String;

    .line 77
    return-void
.end method
