.class public Lcom/android/internal/telephony/cat/CatCmdMessage;
.super Ljava/lang/Object;
.source "CatCmdMessage.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/telephony/cat/CatCmdMessage$2;,
        Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;,
        Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/android/internal/telephony/cat/CatCmdMessage;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mBrowserSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;

.field private mCallSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;

.field mCmdDet:Lcom/android/internal/telephony/cat/CommandDetails;

.field private mInput:Lcom/android/internal/telephony/cat/Input;

.field private mMenu:Lcom/android/internal/telephony/cat/Menu;

.field private mTextMsg:Lcom/android/internal/telephony/cat/TextMessage;

.field private mToneSettings:Lcom/android/internal/telephony/cat/ToneSettings;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Lcom/android/internal/telephony/cat/CatCmdMessage$1;

    invoke-direct {v0}, Lcom/android/internal/telephony/cat/CatCmdMessage$1;-><init>()V

    sput-object v0, Lcom/android/internal/telephony/cat/CatCmdMessage;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .registers 5
    .parameter "in"

    .prologue
    const/4 v2, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mBrowserSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mToneSettings:Lcom/android/internal/telephony/cat/ToneSettings;

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mCallSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/internal/telephony/cat/CommandDetails;

    iput-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mCmdDet:Lcom/android/internal/telephony/cat/CommandDetails;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/internal/telephony/cat/TextMessage;

    iput-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mTextMsg:Lcom/android/internal/telephony/cat/TextMessage;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/internal/telephony/cat/Menu;

    iput-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mMenu:Lcom/android/internal/telephony/cat/Menu;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/internal/telephony/cat/Input;

    iput-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mInput:Lcom/android/internal/telephony/cat/Input;

    sget-object v0, Lcom/android/internal/telephony/cat/CatCmdMessage$2;->$SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType:[I

    invoke-virtual {p0}, Lcom/android/internal/telephony/cat/CatCmdMessage;->getCmdType()Lcom/android/internal/telephony/cat/AppInterface$CommandType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/android/internal/telephony/cat/AppInterface$CommandType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_7e

    :goto_39
    return-void

    :pswitch_3a
    new-instance v0, Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;

    invoke-direct {v0, p0}, Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;-><init>(Lcom/android/internal/telephony/cat/CatCmdMessage;)V

    iput-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mBrowserSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;

    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mBrowserSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;->url:Ljava/lang/String;

    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mBrowserSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;

    invoke-static {}, Lcom/android/internal/telephony/cat/LaunchBrowserMode;->values()[Lcom/android/internal/telephony/cat/LaunchBrowserMode;

    move-result-object v1

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    aget-object v1, v1, v2

    iput-object v1, v0, Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;->mode:Lcom/android/internal/telephony/cat/LaunchBrowserMode;

    goto :goto_39

    :pswitch_58
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/internal/telephony/cat/ToneSettings;

    iput-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mToneSettings:Lcom/android/internal/telephony/cat/ToneSettings;

    goto :goto_39

    :pswitch_61
    new-instance v0, Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;

    invoke-direct {v0, p0}, Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;-><init>(Lcom/android/internal/telephony/cat/CatCmdMessage;)V

    iput-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mCallSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;

    iget-object v1, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mCallSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/internal/telephony/cat/TextMessage;

    iput-object v0, v1, Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;->confirmMsg:Lcom/android/internal/telephony/cat/TextMessage;

    iget-object v1, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mCallSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/internal/telephony/cat/TextMessage;

    iput-object v0, v1, Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;->callMsg:Lcom/android/internal/telephony/cat/TextMessage;

    goto :goto_39

    nop

    :pswitch_data_7e
    .packed-switch 0xb
        :pswitch_3a
        :pswitch_58
        :pswitch_61
    .end packed-switch
.end method

.method constructor <init>(Lcom/android/internal/telephony/cat/CommandParams;)V
    .registers 6
    .parameter "cmdParams"

    .prologue
    const/4 v2, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mBrowserSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mToneSettings:Lcom/android/internal/telephony/cat/ToneSettings;

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mCallSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;

    iget-object v2, p1, Lcom/android/internal/telephony/cat/CommandParams;->cmdDet:Lcom/android/internal/telephony/cat/CommandDetails;

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mCmdDet:Lcom/android/internal/telephony/cat/CommandDetails;

    sget-object v2, Lcom/android/internal/telephony/cat/CatCmdMessage$2;->$SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType:[I

    invoke-virtual {p0}, Lcom/android/internal/telephony/cat/CatCmdMessage;->getCmdType()Lcom/android/internal/telephony/cat/AppInterface$CommandType;

    move-result-object v3

    invoke-virtual {v3}, Lcom/android/internal/telephony/cat/AppInterface$CommandType;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_80

    .end local p1
    :goto_1d
    return-void

    .restart local p1
    :pswitch_1e
    check-cast p1, Lcom/android/internal/telephony/cat/SelectItemParams;

    .end local p1
    iget-object v2, p1, Lcom/android/internal/telephony/cat/SelectItemParams;->menu:Lcom/android/internal/telephony/cat/Menu;

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mMenu:Lcom/android/internal/telephony/cat/Menu;

    goto :goto_1d

    .restart local p1
    :pswitch_25
    check-cast p1, Lcom/android/internal/telephony/cat/DisplayTextParams;

    .end local p1
    iget-object v2, p1, Lcom/android/internal/telephony/cat/DisplayTextParams;->textMsg:Lcom/android/internal/telephony/cat/TextMessage;

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mTextMsg:Lcom/android/internal/telephony/cat/TextMessage;

    goto :goto_1d

    .restart local p1
    :pswitch_2c
    check-cast p1, Lcom/android/internal/telephony/cat/GetInputParams;

    .end local p1
    iget-object v2, p1, Lcom/android/internal/telephony/cat/GetInputParams;->input:Lcom/android/internal/telephony/cat/Input;

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mInput:Lcom/android/internal/telephony/cat/Input;

    goto :goto_1d

    .restart local p1
    :pswitch_33
    move-object v2, p1

    check-cast v2, Lcom/android/internal/telephony/cat/LaunchBrowserParams;

    iget-object v2, v2, Lcom/android/internal/telephony/cat/LaunchBrowserParams;->confirmMsg:Lcom/android/internal/telephony/cat/TextMessage;

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mTextMsg:Lcom/android/internal/telephony/cat/TextMessage;

    new-instance v2, Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;

    invoke-direct {v2, p0}, Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;-><init>(Lcom/android/internal/telephony/cat/CatCmdMessage;)V

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mBrowserSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;

    iget-object v3, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mBrowserSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;

    move-object v2, p1

    check-cast v2, Lcom/android/internal/telephony/cat/LaunchBrowserParams;

    iget-object v2, v2, Lcom/android/internal/telephony/cat/LaunchBrowserParams;->url:Ljava/lang/String;

    iput-object v2, v3, Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;->url:Ljava/lang/String;

    iget-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mBrowserSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;

    check-cast p1, Lcom/android/internal/telephony/cat/LaunchBrowserParams;

    .end local p1
    iget-object v3, p1, Lcom/android/internal/telephony/cat/LaunchBrowserParams;->mode:Lcom/android/internal/telephony/cat/LaunchBrowserMode;

    iput-object v3, v2, Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;->mode:Lcom/android/internal/telephony/cat/LaunchBrowserMode;

    goto :goto_1d

    .restart local p1
    :pswitch_53
    move-object v1, p1

    check-cast v1, Lcom/android/internal/telephony/cat/PlayToneParams;

    .local v1, params:Lcom/android/internal/telephony/cat/PlayToneParams;
    iget-object v2, v1, Lcom/android/internal/telephony/cat/PlayToneParams;->settings:Lcom/android/internal/telephony/cat/ToneSettings;

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mToneSettings:Lcom/android/internal/telephony/cat/ToneSettings;

    iget-object v2, v1, Lcom/android/internal/telephony/cat/PlayToneParams;->textMsg:Lcom/android/internal/telephony/cat/TextMessage;

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mTextMsg:Lcom/android/internal/telephony/cat/TextMessage;

    goto :goto_1d

    .end local v1           #params:Lcom/android/internal/telephony/cat/PlayToneParams;
    :pswitch_5f
    new-instance v2, Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;

    invoke-direct {v2, p0}, Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;-><init>(Lcom/android/internal/telephony/cat/CatCmdMessage;)V

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mCallSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;

    iget-object v3, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mCallSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;

    move-object v2, p1

    check-cast v2, Lcom/android/internal/telephony/cat/CallSetupParams;

    iget-object v2, v2, Lcom/android/internal/telephony/cat/CallSetupParams;->confirmMsg:Lcom/android/internal/telephony/cat/TextMessage;

    iput-object v2, v3, Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;->confirmMsg:Lcom/android/internal/telephony/cat/TextMessage;

    iget-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mCallSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;

    check-cast p1, Lcom/android/internal/telephony/cat/CallSetupParams;

    .end local p1
    iget-object v3, p1, Lcom/android/internal/telephony/cat/CallSetupParams;->callMsg:Lcom/android/internal/telephony/cat/TextMessage;

    iput-object v3, v2, Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;->callMsg:Lcom/android/internal/telephony/cat/TextMessage;

    goto :goto_1d

    .restart local p1
    :pswitch_78
    move-object v0, p1

    check-cast v0, Lcom/android/internal/telephony/cat/BIPClientParams;

    .local v0, param:Lcom/android/internal/telephony/cat/BIPClientParams;
    iget-object v2, v0, Lcom/android/internal/telephony/cat/BIPClientParams;->textMsg:Lcom/android/internal/telephony/cat/TextMessage;

    iput-object v2, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mTextMsg:Lcom/android/internal/telephony/cat/TextMessage;

    goto :goto_1d

    :pswitch_data_80
    .packed-switch 0x1
        :pswitch_1e
        :pswitch_1e
        :pswitch_25
        :pswitch_25
        :pswitch_25
        :pswitch_25
        :pswitch_25
        :pswitch_25
        :pswitch_2c
        :pswitch_2c
        :pswitch_33
        :pswitch_53
        :pswitch_5f
        :pswitch_78
        :pswitch_78
        :pswitch_78
        :pswitch_78
    .end packed-switch
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public geInput()Lcom/android/internal/telephony/cat/Input;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mInput:Lcom/android/internal/telephony/cat/Input;

    return-object v0
.end method

.method public geTextMessage()Lcom/android/internal/telephony/cat/TextMessage;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mTextMsg:Lcom/android/internal/telephony/cat/TextMessage;

    return-object v0
.end method

.method public getBrowserSettings()Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mBrowserSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;

    return-object v0
.end method

.method public getCallSettings()Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mCallSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;

    return-object v0
.end method

.method public getCmdType()Lcom/android/internal/telephony/cat/AppInterface$CommandType;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mCmdDet:Lcom/android/internal/telephony/cat/CommandDetails;

    iget v0, v0, Lcom/android/internal/telephony/cat/CommandDetails;->typeOfCommand:I

    invoke-static {v0}, Lcom/android/internal/telephony/cat/AppInterface$CommandType;->fromInt(I)Lcom/android/internal/telephony/cat/AppInterface$CommandType;

    move-result-object v0

    return-object v0
.end method

.method public getMenu()Lcom/android/internal/telephony/cat/Menu;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mMenu:Lcom/android/internal/telephony/cat/Menu;

    return-object v0
.end method

.method public getToneSettings()Lcom/android/internal/telephony/cat/ToneSettings;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mToneSettings:Lcom/android/internal/telephony/cat/ToneSettings;

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 6
    .parameter "dest"
    .parameter "flags"

    .prologue
    const/4 v2, 0x0

    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mCmdDet:Lcom/android/internal/telephony/cat/CommandDetails;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mTextMsg:Lcom/android/internal/telephony/cat/TextMessage;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mMenu:Lcom/android/internal/telephony/cat/Menu;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mInput:Lcom/android/internal/telephony/cat/Input;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    sget-object v0, Lcom/android/internal/telephony/cat/CatCmdMessage$2;->$SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType:[I

    invoke-virtual {p0}, Lcom/android/internal/telephony/cat/CatCmdMessage;->getCmdType()Lcom/android/internal/telephony/cat/AppInterface$CommandType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/android/internal/telephony/cat/AppInterface$CommandType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_4e

    :goto_24
    return-void

    :pswitch_25
    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mBrowserSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;

    iget-object v0, v0, Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;->url:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mBrowserSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;

    iget-object v0, v0, Lcom/android/internal/telephony/cat/CatCmdMessage$BrowserSettings;->mode:Lcom/android/internal/telephony/cat/LaunchBrowserMode;

    invoke-virtual {v0}, Lcom/android/internal/telephony/cat/LaunchBrowserMode;->ordinal()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_24

    :pswitch_38
    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mToneSettings:Lcom/android/internal/telephony/cat/ToneSettings;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    goto :goto_24

    :pswitch_3e
    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mCallSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;

    iget-object v0, v0, Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;->confirmMsg:Lcom/android/internal/telephony/cat/TextMessage;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    iget-object v0, p0, Lcom/android/internal/telephony/cat/CatCmdMessage;->mCallSettings:Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;

    iget-object v0, v0, Lcom/android/internal/telephony/cat/CatCmdMessage$CallSettings;->callMsg:Lcom/android/internal/telephony/cat/TextMessage;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    goto :goto_24

    nop

    :pswitch_data_4e
    .packed-switch 0xb
        :pswitch_25
        :pswitch_38
        :pswitch_3e
    .end packed-switch
.end method
