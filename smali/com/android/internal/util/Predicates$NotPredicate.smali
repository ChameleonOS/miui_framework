.class Lcom/android/internal/util/Predicates$NotPredicate;
.super Ljava/lang/Object;
.source "Predicates.java"

# interfaces
.implements Lcom/android/internal/util/Predicate;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/util/Predicates;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "NotPredicate"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/android/internal/util/Predicate",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final predicate:Lcom/android/internal/util/Predicate;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/android/internal/util/Predicate",
            "<-TT;>;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Lcom/android/internal/util/Predicate;)V
    .registers 2
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/internal/util/Predicate",
            "<-TT;>;)V"
        }
    .end annotation

    .prologue
    .line 117
    .local p0, this:Lcom/android/internal/util/Predicates$NotPredicate;,"Lcom/android/internal/util/Predicates$NotPredicate<TT;>;"
    .local p1, predicate:Lcom/android/internal/util/Predicate;,"Lcom/android/internal/util/Predicate<-TT;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 118
    iput-object p1, p0, Lcom/android/internal/util/Predicates$NotPredicate;->predicate:Lcom/android/internal/util/Predicate;

    .line 119
    return-void
.end method

.method synthetic constructor <init>(Lcom/android/internal/util/Predicate;Lcom/android/internal/util/Predicates$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 114
    .local p0, this:Lcom/android/internal/util/Predicates$NotPredicate;,"Lcom/android/internal/util/Predicates$NotPredicate<TT;>;"
    invoke-direct {p0, p1}, Lcom/android/internal/util/Predicates$NotPredicate;-><init>(Lcom/android/internal/util/Predicate;)V

    return-void
.end method


# virtual methods
.method public apply(Ljava/lang/Object;)Z
    .registers 3
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    .prologue
    .line 122
    .local p0, this:Lcom/android/internal/util/Predicates$NotPredicate;,"Lcom/android/internal/util/Predicates$NotPredicate<TT;>;"
    .local p1, t:Ljava/lang/Object;,"TT;"
    iget-object v0, p0, Lcom/android/internal/util/Predicates$NotPredicate;->predicate:Lcom/android/internal/util/Predicate;

    invoke-interface {v0, p1}, Lcom/android/internal/util/Predicate;->apply(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method
