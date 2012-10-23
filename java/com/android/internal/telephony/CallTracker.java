// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.*;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package com.android.internal.telephony:
//            CommandsInterface, CommandException

public abstract class CallTracker extends Handler {

    public CallTracker() {
    }

    private boolean checkNoOperationsPending() {
        boolean flag;
        if(pendingOperations == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected String checkForTestEmergencyNumber(String s) {
        String s1 = SystemProperties.get("ril.test.emergencynumber");
        if(!TextUtils.isEmpty(s1)) {
            String as[] = s1.split(":");
            log((new StringBuilder()).append("checkForTestEmergencyNumber: values.length=").append(as.length).toString());
            if(as.length == 2 && as[0].equals(PhoneNumberUtils.stripSeparators(s))) {
                cm.testingEmergencyCall();
                log((new StringBuilder()).append("checkForTestEmergencyNumber: remap ").append(s).append(" to ").append(as[1]).toString());
                s = as[1];
            }
        }
        return s;
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("CallTracker:");
        printwriter.println((new StringBuilder()).append(" pendingOperations=").append(pendingOperations).toString());
        printwriter.println((new StringBuilder()).append(" needsPoll=").append(needsPoll).toString());
        printwriter.println((new StringBuilder()).append(" lastRelevantPoll=").append(lastRelevantPoll).toString());
    }

    public abstract void handleMessage(Message message);

    protected abstract void handlePollCalls(AsyncResult asyncresult);

    protected void handleRadioAvailable() {
        pollCallsWhenSafe();
    }

    protected boolean isCommandExceptionRadioNotAvailable(Throwable throwable) {
        boolean flag;
        if(throwable != null && (throwable instanceof CommandException) && ((CommandException)throwable).getCommandError() == CommandException.Error.RADIO_NOT_AVAILABLE)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected abstract void log(String s);

    protected Message obtainNoPollCompleteMessage(int i) {
        pendingOperations = 1 + pendingOperations;
        lastRelevantPoll = null;
        return obtainMessage(i);
    }

    protected void pollCallsAfterDelay() {
        Message message = obtainMessage();
        message.what = 3;
        sendMessageDelayed(message, 250L);
    }

    protected void pollCallsWhenSafe() {
        needsPoll = true;
        if(checkNoOperationsPending()) {
            lastRelevantPoll = obtainMessage(1);
            cm.getCurrentCalls(lastRelevantPoll);
        }
    }

    public abstract void registerForVoiceCallEnded(Handler handler, int i, Object obj);

    public abstract void registerForVoiceCallStarted(Handler handler, int i, Object obj);

    public abstract void unregisterForVoiceCallEnded(Handler handler);

    public abstract void unregisterForVoiceCallStarted(Handler handler);

    private static final boolean DBG_POLL = false;
    protected static final int EVENT_CALL_STATE_CHANGE = 2;
    protected static final int EVENT_CALL_WAITING_INFO_CDMA = 15;
    protected static final int EVENT_CONFERENCE_RESULT = 11;
    protected static final int EVENT_ECT_RESULT = 13;
    protected static final int EVENT_EXIT_ECM_RESPONSE_CDMA = 14;
    protected static final int EVENT_GET_LAST_CALL_FAIL_CAUSE = 5;
    protected static final int EVENT_OPERATION_COMPLETE = 4;
    protected static final int EVENT_POLL_CALLS_RESULT = 1;
    protected static final int EVENT_RADIO_AVAILABLE = 9;
    protected static final int EVENT_RADIO_NOT_AVAILABLE = 10;
    protected static final int EVENT_REPOLL_AFTER_DELAY = 3;
    protected static final int EVENT_SEPARATE_RESULT = 12;
    protected static final int EVENT_SWITCH_RESULT = 8;
    protected static final int EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA = 16;
    static final int POLL_DELAY_MSEC = 250;
    public CommandsInterface cm;
    protected Message lastRelevantPoll;
    protected boolean needsPoll;
    protected int pendingOperations;
}
