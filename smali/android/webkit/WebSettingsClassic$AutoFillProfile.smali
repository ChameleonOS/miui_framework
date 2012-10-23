.class public Landroid/webkit/WebSettingsClassic$AutoFillProfile;
.super Ljava/lang/Object;
.source "WebSettingsClassic.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebSettingsClassic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AutoFillProfile"
.end annotation


# instance fields
.field private mAddressLine1:Ljava/lang/String;

.field private mAddressLine2:Ljava/lang/String;

.field private mCity:Ljava/lang/String;

.field private mCompanyName:Ljava/lang/String;

.field private mCountry:Ljava/lang/String;

.field private mEmailAddress:Ljava/lang/String;

.field private mFullName:Ljava/lang/String;

.field private mPhoneNumber:Ljava/lang/String;

.field private mState:Ljava/lang/String;

.field private mUniqueId:I

.field private mZipCode:Ljava/lang/String;


# direct methods
.method public constructor <init>(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 12
    .parameter "uniqueId"
    .parameter "fullName"
    .parameter "email"
    .parameter "companyName"
    .parameter "addressLine1"
    .parameter "addressLine2"
    .parameter "city"
    .parameter "state"
    .parameter "zipCode"
    .parameter "country"
    .parameter "phoneNumber"

    .prologue
    .line 145
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 146
    iput p1, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mUniqueId:I

    .line 147
    iput-object p2, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mFullName:Ljava/lang/String;

    .line 148
    iput-object p3, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mEmailAddress:Ljava/lang/String;

    .line 149
    iput-object p4, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mCompanyName:Ljava/lang/String;

    .line 150
    iput-object p5, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mAddressLine1:Ljava/lang/String;

    .line 151
    iput-object p6, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mAddressLine2:Ljava/lang/String;

    .line 152
    iput-object p7, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mCity:Ljava/lang/String;

    .line 153
    iput-object p8, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mState:Ljava/lang/String;

    .line 154
    iput-object p9, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mZipCode:Ljava/lang/String;

    .line 155
    iput-object p10, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mCountry:Ljava/lang/String;

    .line 156
    iput-object p11, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mPhoneNumber:Ljava/lang/String;

    .line 157
    return-void
.end method


# virtual methods
.method public getAddressLine1()Ljava/lang/String;
    .registers 2

    .prologue
    .line 163
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mAddressLine1:Ljava/lang/String;

    return-object v0
.end method

.method public getAddressLine2()Ljava/lang/String;
    .registers 2

    .prologue
    .line 164
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mAddressLine2:Ljava/lang/String;

    return-object v0
.end method

.method public getCity()Ljava/lang/String;
    .registers 2

    .prologue
    .line 165
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mCity:Ljava/lang/String;

    return-object v0
.end method

.method public getCompanyName()Ljava/lang/String;
    .registers 2

    .prologue
    .line 162
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mCompanyName:Ljava/lang/String;

    return-object v0
.end method

.method public getCountry()Ljava/lang/String;
    .registers 2

    .prologue
    .line 168
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mCountry:Ljava/lang/String;

    return-object v0
.end method

.method public getEmailAddress()Ljava/lang/String;
    .registers 2

    .prologue
    .line 161
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mEmailAddress:Ljava/lang/String;

    return-object v0
.end method

.method public getFullName()Ljava/lang/String;
    .registers 2

    .prologue
    .line 160
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mFullName:Ljava/lang/String;

    return-object v0
.end method

.method public getPhoneNumber()Ljava/lang/String;
    .registers 2

    .prologue
    .line 169
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mPhoneNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getState()Ljava/lang/String;
    .registers 2

    .prologue
    .line 166
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mState:Ljava/lang/String;

    return-object v0
.end method

.method public getUniqueId()I
    .registers 2

    .prologue
    .line 159
    iget v0, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mUniqueId:I

    return v0
.end method

.method public getZipCode()Ljava/lang/String;
    .registers 2

    .prologue
    .line 167
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic$AutoFillProfile;->mZipCode:Ljava/lang/String;

    return-object v0
.end method
