.class Lcom/android/internal/util/Predicates$AndPredicate;
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
    name = "AndPredicate"
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
.field private final components:Ljava/lang/Iterable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Iterable",
            "<+",
            "Lcom/android/internal/util/Predicate",
            "<-TT;>;>;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Ljava/lang/Iterable;)V
    .registers 2
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Iterable",
            "<+",
            "Lcom/android/internal/util/Predicate",
            "<-TT;>;>;)V"
        }
    .end annotation

    .prologue
    .line 83
    .local p0, this:Lcom/android/internal/util/Predicates$AndPredicate;,"Lcom/android/internal/util/Predicates$AndPredicate<TT;>;"
    .local p1, components:Ljava/lang/Iterable;,"Ljava/lang/Iterable<+Lcom/android/internal/util/Predicate<-TT;>;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 84
    iput-object p1, p0, Lcom/android/internal/util/Predicates$AndPredicate;->components:Ljava/lang/Iterable;

    .line 85
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/Iterable;Lcom/android/internal/util/Predicates$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 80
    .local p0, this:Lcom/android/internal/util/Predicates$AndPredicate;,"Lcom/android/internal/util/Predicates$AndPredicate<TT;>;"
    invoke-direct {p0, p1}, Lcom/android/internal/util/Predicates$AndPredicate;-><init>(Ljava/lang/Iterable;)V

    return-void
.end method


# virtual methods
.method public apply(Ljava/lang/Object;)Z
    .registers 5
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    .prologue
    .line 88
    .local p0, this:Lcom/android/internal/util/Predicates$AndPredicate;,"Lcom/android/internal/util/Predicates$AndPredicate<TT;>;"
    .local p1, t:Ljava/lang/Object;,"TT;"
    iget-object v2, p0, Lcom/android/internal/util/Predicates$AndPredicate;->components:Ljava/lang/Iterable;

    invoke-interface {v2}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :cond_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1a

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/internal/util/Predicate;

    .line 89
    .local v1, predicate:Lcom/android/internal/util/Predicate;,"Lcom/android/internal/util/Predicate<-TT;>;"
    invoke-interface {v1, p1}, Lcom/android/internal/util/Predicate;->apply(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_6

    .line 90
    const/4 v2, 0x0

    .line 93
    .end local v1           #predicate:Lcom/android/internal/util/Predicate;,"Lcom/android/internal/util/Predicate<-TT;>;"
    :goto_19
    return v2

    :cond_1a
    const/4 v2, 0x1

    goto :goto_19
.end method
