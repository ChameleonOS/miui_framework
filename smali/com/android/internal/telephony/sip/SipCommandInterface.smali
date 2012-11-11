.class Lcom/android/internal/telephony/sip/SipCommandInterface;
.super Lcom/android/internal/telephony/BaseCommands;
.source "SipCommandInterface.java"

# interfaces
.implements Lcom/android/internal/telephony/CommandsInterface;


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .registers 2
    .parameter "context"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/BaseCommands;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public acceptCall(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public acknowledgeIncomingGsmSmsWithPdu(ZLjava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "success"
    .parameter "ackPdu"
    .parameter "result"

    .prologue
    return-void
.end method

.method public acknowledgeLastIncomingCdmaSms(ZILandroid/os/Message;)V
    .registers 4
    .parameter "success"
    .parameter "cause"
    .parameter "result"

    .prologue
    return-void
.end method

.method public acknowledgeLastIncomingGsmSms(ZILandroid/os/Message;)V
    .registers 4
    .parameter "success"
    .parameter "cause"
    .parameter "result"

    .prologue
    return-void
.end method

.method public cancelPendingUssd(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public changeBarringPassword(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 5
    .parameter "facility"
    .parameter "oldPwd"
    .parameter "newPwd"
    .parameter "result"

    .prologue
    return-void
.end method

.method public changeIccPin(Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "oldPin"
    .parameter "newPin"
    .parameter "result"

    .prologue
    return-void
.end method

.method public changeIccPin2(Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "oldPin2"
    .parameter "newPin2"
    .parameter "result"

    .prologue
    return-void
.end method

.method public changeIccPin2ForApp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 5
    .parameter "oldPin2"
    .parameter "newPin2"
    .parameter "aidPtr"
    .parameter "response"

    .prologue
    return-void
.end method

.method public changeIccPinForApp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 5
    .parameter "oldPin"
    .parameter "newPin"
    .parameter "aidPtr"
    .parameter "response"

    .prologue
    return-void
.end method

.method public conference(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public deactivateDataCall(IILandroid/os/Message;)V
    .registers 4
    .parameter "cid"
    .parameter "reason"
    .parameter "result"

    .prologue
    return-void
.end method

.method public deleteSmsOnRuim(ILandroid/os/Message;)V
    .registers 3
    .parameter "index"
    .parameter "response"

    .prologue
    return-void
.end method

.method public deleteSmsOnSim(ILandroid/os/Message;)V
    .registers 3
    .parameter "index"
    .parameter "response"

    .prologue
    return-void
.end method

.method public dial(Ljava/lang/String;ILandroid/os/Message;)V
    .registers 4
    .parameter "address"
    .parameter "clirMode"
    .parameter "result"

    .prologue
    return-void
.end method

.method public dial(Ljava/lang/String;ILcom/android/internal/telephony/UUSInfo;Landroid/os/Message;)V
    .registers 5
    .parameter "address"
    .parameter "clirMode"
    .parameter "uusInfo"
    .parameter "result"

    .prologue
    return-void
.end method

.method public exitEmergencyCallbackMode(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public explicitCallTransfer(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getAvailableNetworks(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public getBasebandVersion(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public getCDMASubscription(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public getCLIR(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getCdmaBroadcastConfig(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public getCdmaSubscriptionSource(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public getCurrentCalls(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getDataCallList(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getDataRegistrationState(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getDeviceIdentity(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public getGsmBroadcastConfig(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public getIMEI(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getIMEISV(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getIMSI(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getIMSIForApp(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "aid"
    .parameter "result"

    .prologue
    return-void
.end method

.method public getIccCardStatus(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getLastCallFailCause(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getLastDataCallFailCause(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getLastPdpFailCause(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getMute(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public getNeighboringCids(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public getNetworkSelectionMode(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public getOperator(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getPDPContextList(Landroid/os/Message;)V
    .registers 2
    .parameter "result"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    return-void
.end method

.method public getPreferredNetworkType(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public getPreferredVoicePrivacy(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getSignalStrength(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getSmscAddress(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getVoiceRadioTechnology(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public getVoiceRegistrationState(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public handleCallSetupRequestFromSim(ZLandroid/os/Message;)V
    .registers 3
    .parameter "accept"
    .parameter "response"

    .prologue
    return-void
.end method

.method public hangupConnection(ILandroid/os/Message;)V
    .registers 3
    .parameter "gsmIndex"
    .parameter "result"

    .prologue
    return-void
.end method

.method public hangupForegroundResumeBackground(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public hangupWaitingOrBackground(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public iccIO(IILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 10
    .parameter "command"
    .parameter "fileid"
    .parameter "path"
    .parameter "p1"
    .parameter "p2"
    .parameter "p3"
    .parameter "data"
    .parameter "pin2"
    .parameter "result"

    .prologue
    return-void
.end method

.method public iccIOForApp(IILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 11
    .parameter "command"
    .parameter "fileid"
    .parameter "path"
    .parameter "p1"
    .parameter "p2"
    .parameter "p3"
    .parameter "data"
    .parameter "pin2"
    .parameter "aid"
    .parameter "result"

    .prologue
    return-void
.end method

.method public invokeOemRilRequestRaw([BLandroid/os/Message;)V
    .registers 3
    .parameter "data"
    .parameter "response"

    .prologue
    return-void
.end method

.method public invokeOemRilRequestStrings([Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "strings"
    .parameter "response"

    .prologue
    return-void
.end method

.method public queryAvailableBandMode(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public queryCLIP(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public queryCallForwardStatus(IILjava/lang/String;Landroid/os/Message;)V
    .registers 5
    .parameter "cfReason"
    .parameter "serviceClass"
    .parameter "number"
    .parameter "response"

    .prologue
    return-void
.end method

.method public queryCallWaiting(ILandroid/os/Message;)V
    .registers 3
    .parameter "serviceClass"
    .parameter "response"

    .prologue
    return-void
.end method

.method public queryCdmaRoamingPreference(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public queryFacilityLock(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Message;)V
    .registers 5
    .parameter "facility"
    .parameter "password"
    .parameter "serviceClass"
    .parameter "response"

    .prologue
    return-void
.end method

.method public queryFacilityLockForApp(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/os/Message;)V
    .registers 6
    .parameter "facility"
    .parameter "password"
    .parameter "serviceClass"
    .parameter "appId"
    .parameter "response"

    .prologue
    return-void
.end method

.method public queryTTYMode(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public rejectCall(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public reportSmsMemoryStatus(ZLandroid/os/Message;)V
    .registers 3
    .parameter "available"
    .parameter "result"

    .prologue
    return-void
.end method

.method public reportStkServiceIsRunning(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public requestIsimAuthentication(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "nonce"
    .parameter "response"

    .prologue
    return-void
.end method

.method public resetRadio(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public sendBurstDtmf(Ljava/lang/String;IILandroid/os/Message;)V
    .registers 5
    .parameter "dtmfString"
    .parameter "on"
    .parameter "off"
    .parameter "result"

    .prologue
    return-void
.end method

.method public sendCDMAFeatureCode(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "FeatureCode"
    .parameter "response"

    .prologue
    return-void
.end method

.method public sendCdmaSms([BLandroid/os/Message;)V
    .registers 3
    .parameter "pdu"
    .parameter "result"

    .prologue
    return-void
.end method

.method public sendDtmf(CLandroid/os/Message;)V
    .registers 3
    .parameter "c"
    .parameter "result"

    .prologue
    return-void
.end method

.method public sendEnvelope(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "contents"
    .parameter "response"

    .prologue
    return-void
.end method

.method public sendEnvelopeWithStatus(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "contents"
    .parameter "response"

    .prologue
    return-void
.end method

.method public sendSMS(Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "smscPDU"
    .parameter "pdu"
    .parameter "result"

    .prologue
    return-void
.end method

.method public sendTerminalResponse(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "contents"
    .parameter "response"

    .prologue
    return-void
.end method

.method public sendUSSD(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "ussdString"
    .parameter "response"

    .prologue
    return-void
.end method

.method public separateConnection(ILandroid/os/Message;)V
    .registers 3
    .parameter "gsmIndex"
    .parameter "result"

    .prologue
    return-void
.end method

.method public setBandMode(ILandroid/os/Message;)V
    .registers 3
    .parameter "bandMode"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setCLIR(ILandroid/os/Message;)V
    .registers 3
    .parameter "clirMode"
    .parameter "result"

    .prologue
    return-void
.end method

.method public setCallForward(IIILjava/lang/String;ILandroid/os/Message;)V
    .registers 7
    .parameter "action"
    .parameter "cfReason"
    .parameter "serviceClass"
    .parameter "number"
    .parameter "timeSeconds"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setCallWaiting(ZILandroid/os/Message;)V
    .registers 4
    .parameter "enable"
    .parameter "serviceClass"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setCdmaBroadcastActivation(ZLandroid/os/Message;)V
    .registers 3
    .parameter "activate"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setCdmaBroadcastConfig([ILandroid/os/Message;)V
    .registers 3
    .parameter "configValuesArray"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setCdmaRoamingPreference(ILandroid/os/Message;)V
    .registers 3
    .parameter "cdmaRoamingType"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setCdmaSubscriptionSource(ILandroid/os/Message;)V
    .registers 3
    .parameter "cdmaSubscription"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setFacilityLock(Ljava/lang/String;ZLjava/lang/String;ILandroid/os/Message;)V
    .registers 6
    .parameter "facility"
    .parameter "lockState"
    .parameter "password"
    .parameter "serviceClass"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setFacilityLockForApp(Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;Landroid/os/Message;)V
    .registers 7
    .parameter "facility"
    .parameter "lockState"
    .parameter "password"
    .parameter "serviceClass"
    .parameter "appId"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setGsmBroadcastActivation(ZLandroid/os/Message;)V
    .registers 3
    .parameter "activate"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setGsmBroadcastConfig([Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;Landroid/os/Message;)V
    .registers 3
    .parameter "config"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setLocationUpdates(ZLandroid/os/Message;)V
    .registers 3
    .parameter "enable"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setMute(ZLandroid/os/Message;)V
    .registers 3
    .parameter "enableMute"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setNetworkSelectionModeAutomatic(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    return-void
.end method

.method public setNetworkSelectionModeManual(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "operatorNumeric"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setOnNITZTime(Landroid/os/Handler;ILjava/lang/Object;)V
    .registers 4
    .parameter "h"
    .parameter "what"
    .parameter "obj"

    .prologue
    return-void
.end method

.method public setPhoneType(I)V
    .registers 2
    .parameter "phoneType"

    .prologue
    return-void
.end method

.method public setPreferredNetworkType(ILandroid/os/Message;)V
    .registers 3
    .parameter "networkType"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setPreferredVoicePrivacy(ZLandroid/os/Message;)V
    .registers 3
    .parameter "enable"
    .parameter "result"

    .prologue
    return-void
.end method

.method public setRadioPower(ZLandroid/os/Message;)V
    .registers 3
    .parameter "on"
    .parameter "result"

    .prologue
    return-void
.end method

.method public setSmscAddress(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "address"
    .parameter "result"

    .prologue
    return-void
.end method

.method public setSuppServiceNotifications(ZLandroid/os/Message;)V
    .registers 3
    .parameter "enable"
    .parameter "result"

    .prologue
    return-void
.end method

.method public setTTYMode(ILandroid/os/Message;)V
    .registers 3
    .parameter "ttyMode"
    .parameter "response"

    .prologue
    return-void
.end method

.method public setupDataCall(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 9
    .parameter "radioTechnology"
    .parameter "profile"
    .parameter "apn"
    .parameter "user"
    .parameter "password"
    .parameter "authType"
    .parameter "protocol"
    .parameter "result"

    .prologue
    return-void
.end method

.method public startDtmf(CLandroid/os/Message;)V
    .registers 3
    .parameter "c"
    .parameter "result"

    .prologue
    return-void
.end method

.method public stopDtmf(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public supplyIccPin(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "pin"
    .parameter "result"

    .prologue
    return-void
.end method

.method public supplyIccPin2(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "pin"
    .parameter "result"

    .prologue
    return-void
.end method

.method public supplyIccPin2ForApp(Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "pin2"
    .parameter "aid"
    .parameter "response"

    .prologue
    return-void
.end method

.method public supplyIccPinForApp(Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "pin"
    .parameter "aid"
    .parameter "response"

    .prologue
    return-void
.end method

.method public supplyIccPuk(Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "puk"
    .parameter "newPin"
    .parameter "result"

    .prologue
    return-void
.end method

.method public supplyIccPuk2(Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "puk"
    .parameter "newPin2"
    .parameter "result"

    .prologue
    return-void
.end method

.method public supplyIccPuk2ForApp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 5
    .parameter "puk2"
    .parameter "newPin2"
    .parameter "aid"
    .parameter "response"

    .prologue
    return-void
.end method

.method public supplyIccPukForApp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 5
    .parameter "puk"
    .parameter "newPin"
    .parameter "aid"
    .parameter "response"

    .prologue
    return-void
.end method

.method public supplyNetworkDepersonalization(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "netpin"
    .parameter "result"

    .prologue
    return-void
.end method

.method public switchWaitingOrHoldingAndActive(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    return-void
.end method

.method public writeSmsToRuim(ILjava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "status"
    .parameter "pdu"
    .parameter "response"

    .prologue
    return-void
.end method

.method public writeSmsToSim(ILjava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 5
    .parameter "status"
    .parameter "smsc"
    .parameter "pdu"
    .parameter "response"

    .prologue
    return-void
.end method
