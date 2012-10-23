// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.app.PendingIntent;
import android.net.*;
import android.os.Message;
import android.util.Log;
import com.android.internal.util.AsyncChannel;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.android.internal.telephony:
//            ApnSetting, DataConnection, ApnContext, DataCallState

public class DataConnectionAc extends AsyncChannel {
    public static final class LinkPropertyChangeAction extends Enum {

        public static LinkPropertyChangeAction fromInt(int i) {
            LinkPropertyChangeAction linkpropertychangeaction;
            if(i == NONE.ordinal())
                linkpropertychangeaction = NONE;
            else
            if(i == CHANGED.ordinal())
                linkpropertychangeaction = CHANGED;
            else
            if(i == RESET.ordinal())
                linkpropertychangeaction = RESET;
            else
                throw new RuntimeException((new StringBuilder()).append("LinkPropertyChangeAction.fromInt: bad value=").append(i).toString());
            return linkpropertychangeaction;
        }

        public static LinkPropertyChangeAction valueOf(String s) {
            return (LinkPropertyChangeAction)Enum.valueOf(com/android/internal/telephony/DataConnectionAc$LinkPropertyChangeAction, s);
        }

        public static LinkPropertyChangeAction[] values() {
            return (LinkPropertyChangeAction[])$VALUES.clone();
        }

        private static final LinkPropertyChangeAction $VALUES[];
        public static final LinkPropertyChangeAction CHANGED;
        public static final LinkPropertyChangeAction NONE;
        public static final LinkPropertyChangeAction RESET;

        static  {
            NONE = new LinkPropertyChangeAction("NONE", 0);
            CHANGED = new LinkPropertyChangeAction("CHANGED", 1);
            RESET = new LinkPropertyChangeAction("RESET", 2);
            LinkPropertyChangeAction alinkpropertychangeaction[] = new LinkPropertyChangeAction[3];
            alinkpropertychangeaction[0] = NONE;
            alinkpropertychangeaction[1] = CHANGED;
            alinkpropertychangeaction[2] = RESET;
            $VALUES = alinkpropertychangeaction;
        }

        private LinkPropertyChangeAction(String s, int i) {
            super(s, i);
        }
    }


    public DataConnectionAc(DataConnection dataconnection, String s) {
        dataConnection = dataconnection;
        mLogTag = s;
    }

    protected static String cmdToString(int i) {
        int j = i - 0x41000;
        String s;
        if(j >= 0 && j < sCmdToString.length)
            s = sCmdToString[j];
        else
            s = AsyncChannel.cmdToString(j + 0x41000);
        return s;
    }

    private void log(String s) {
        Log.d(mLogTag, (new StringBuilder()).append("DataConnectionAc ").append(s).toString());
    }

    public void addApnContextSync(ApnContext apncontext) {
        Message message = sendMessageSynchronously(0x41012, apncontext);
        if(message == null || message.what != 0x41013)
            log((new StringBuilder()).append("addApnContext error response=").append(message).toString());
    }

    public Collection getApnListSync() {
        Message message = sendMessageSynchronously(0x41016);
        Object obj;
        if(message != null && message.what == 0x41017) {
            obj = rspApnList(message);
        } else {
            log((new StringBuilder()).append("getApnList error response=").append(message).toString());
            obj = new ArrayList();
        }
        return ((Collection) (obj));
    }

    public ApnSetting getApnSettingSync() {
        Message message = sendMessageSynchronously(0x41004);
        ApnSetting apnsetting;
        if(message != null && message.what == 0x41005) {
            apnsetting = rspApnSetting(message);
        } else {
            log((new StringBuilder()).append("getApnSetting error response=").append(message).toString());
            apnsetting = null;
        }
        return apnsetting;
    }

    public int getCidSync() {
        Message message = sendMessageSynchronously(0x41002);
        int i;
        if(message != null && message.what == 0x41003) {
            i = rspCid(message);
        } else {
            log((new StringBuilder()).append("rspCid error response=").append(message).toString());
            i = -1;
        }
        return i;
    }

    public LinkCapabilities getLinkCapabilitiesSync() {
        Message message = sendMessageSynchronously(0x4100a);
        LinkCapabilities linkcapabilities;
        if(message != null && message.what == 0x4100b) {
            linkcapabilities = rspLinkCapabilities(message);
        } else {
            log((new StringBuilder()).append("getLinkCapabilities error response=").append(message).toString());
            linkcapabilities = null;
        }
        return linkcapabilities;
    }

    public LinkProperties getLinkPropertiesSync() {
        Message message = sendMessageSynchronously(0x41006);
        LinkProperties linkproperties;
        if(message != null && message.what == 0x41007) {
            linkproperties = rspLinkProperties(message);
        } else {
            log((new StringBuilder()).append("getLinkProperties error response=").append(message).toString());
            linkproperties = null;
        }
        return linkproperties;
    }

    public PendingIntent getReconnectIntentSync() {
        Message message = sendMessageSynchronously(0x4101a);
        PendingIntent pendingintent;
        if(message != null && message.what == 0x4101b) {
            pendingintent = rspReconnectIntent(message);
        } else {
            log((new StringBuilder()).append("getReconnectIntent error response=").append(message).toString());
            pendingintent = null;
        }
        return pendingintent;
    }

    public int getRefCountSync() {
        Message message = sendMessageSynchronously(0x41010);
        int i;
        if(message != null && message.what == 0x41011) {
            i = rspRefCount(message);
        } else {
            log((new StringBuilder()).append("rspRefCount error response=").append(message).toString());
            i = -1;
        }
        return i;
    }

    public boolean isInactiveSync() {
        Message message = sendMessageSynchronously(0x41000);
        boolean flag;
        if(message != null && message.what == 0x41001) {
            flag = rspIsInactive(message);
        } else {
            log((new StringBuilder()).append("rspIsInactive error response=").append(message).toString());
            flag = false;
        }
        return flag;
    }

    public void removeApnContextSync(ApnContext apncontext) {
        Message message = sendMessageSynchronously(0x41014, apncontext);
        if(message == null || message.what != 0x41015)
            log((new StringBuilder()).append("removeApnContext error response=").append(message).toString());
    }

    public void reqAddApnContext(ApnContext apncontext) {
        sendMessageSynchronously(0x41012, apncontext);
    }

    public void reqApnSetting() {
        sendMessage(0x41004);
    }

    public void reqCid() {
        sendMessage(0x41002);
    }

    public void reqGetApnList(ApnContext apncontext) {
        sendMessageSynchronously(0x41016);
    }

    public void reqGetReconnectIntent() {
        sendMessageSynchronously(0x4101a);
    }

    public void reqIsInactive() {
        sendMessage(0x41000);
    }

    public void reqLinkCapabilities() {
        sendMessage(0x4100a);
    }

    public void reqLinkProperties() {
        sendMessage(0x41006);
    }

    public void reqRefCount() {
        sendMessage(0x41010);
    }

    public void reqRemomveApnContext(ApnContext apncontext) {
        sendMessageSynchronously(0x41014, apncontext);
    }

    public void reqReset() {
        sendMessage(0x4100e);
    }

    public void reqSetLinkPropertiesHttpProxy(ProxyProperties proxyproperties) {
        sendMessage(0x41008, proxyproperties);
    }

    public void reqSetReconnectIntent(PendingIntent pendingintent) {
        sendMessageSynchronously(0x41018, pendingintent);
    }

    public void reqUpdateLinkPropertiesDataCallState(DataCallState datacallstate) {
        sendMessage(0x4100c, datacallstate);
    }

    public void resetSync() {
        Message message = sendMessageSynchronously(0x4100e);
        if(message == null || message.what != 0x4100f)
            log((new StringBuilder()).append("restSync error response=").append(message).toString());
    }

    public Collection rspApnList(Message message) {
        Object obj = (Collection)message.obj;
        if(obj == null)
            obj = new ArrayList();
        return ((Collection) (obj));
    }

    public ApnSetting rspApnSetting(Message message) {
        return (ApnSetting)message.obj;
    }

    public int rspCid(Message message) {
        return message.arg1;
    }

    public boolean rspIsInactive(Message message) {
        boolean flag = true;
        if(message.arg1 != flag)
            flag = false;
        return flag;
    }

    public LinkCapabilities rspLinkCapabilities(Message message) {
        return (LinkCapabilities)message.obj;
    }

    public LinkProperties rspLinkProperties(Message message) {
        return (LinkProperties)message.obj;
    }

    public PendingIntent rspReconnectIntent(Message message) {
        return (PendingIntent)message.obj;
    }

    public int rspRefCount(Message message) {
        return message.arg1;
    }

    public DataConnection.UpdateLinkPropertyResult rspUpdateLinkPropertiesDataCallState(Message message) {
        return (DataConnection.UpdateLinkPropertyResult)message.obj;
    }

    public void setLinkPropertiesHttpProxySync(ProxyProperties proxyproperties) {
        Message message = sendMessageSynchronously(0x41008, proxyproperties);
        if(message == null || message.what != 0x41009)
            log((new StringBuilder()).append("setLinkPropertiesHttpPoxy error response=").append(message).toString());
    }

    public void setReconnectIntentSync(PendingIntent pendingintent) {
        Message message = sendMessageSynchronously(0x41018, pendingintent);
        if(message == null || message.what != 0x41019)
            log((new StringBuilder()).append("setReconnectIntent error response=").append(message).toString());
    }

    public String toString() {
        return dataConnection.getName();
    }

    public DataConnection.UpdateLinkPropertyResult updateLinkPropertiesDataCallStateSync(DataCallState datacallstate) {
        Message message = sendMessageSynchronously(0x4100c, datacallstate);
        DataConnection.UpdateLinkPropertyResult updatelinkpropertyresult;
        if(message != null && message.what == 0x4100d) {
            updatelinkpropertyresult = rspUpdateLinkPropertiesDataCallState(message);
        } else {
            log((new StringBuilder()).append("getLinkProperties error response=").append(message).toString());
            updatelinkpropertyresult = new DataConnection.UpdateLinkPropertyResult(new LinkProperties());
        }
        return updatelinkpropertyresult;
    }

    public static final int BASE = 0x41000;
    private static final int CMD_TO_STRING_COUNT = 28;
    private static final boolean DBG = false;
    public static final int REQ_ADD_APNCONTEXT = 0x41012;
    public static final int REQ_GET_APNCONTEXT_LIST = 0x41016;
    public static final int REQ_GET_APNSETTING = 0x41004;
    public static final int REQ_GET_CID = 0x41002;
    public static final int REQ_GET_LINK_CAPABILITIES = 0x4100a;
    public static final int REQ_GET_LINK_PROPERTIES = 0x41006;
    public static final int REQ_GET_RECONNECT_INTENT = 0x4101a;
    public static final int REQ_GET_REFCOUNT = 0x41010;
    public static final int REQ_IS_INACTIVE = 0x41000;
    public static final int REQ_REMOVE_APNCONTEXT = 0x41014;
    public static final int REQ_RESET = 0x4100e;
    public static final int REQ_SET_LINK_PROPERTIES_HTTP_PROXY = 0x41008;
    public static final int REQ_SET_RECONNECT_INTENT = 0x41018;
    public static final int REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE = 0x4100c;
    public static final int RSP_ADD_APNCONTEXT = 0x41013;
    public static final int RSP_GET_APNCONTEXT_LIST = 0x41017;
    public static final int RSP_GET_APNSETTING = 0x41005;
    public static final int RSP_GET_CID = 0x41003;
    public static final int RSP_GET_LINK_CAPABILITIES = 0x4100b;
    public static final int RSP_GET_LINK_PROPERTIES = 0x41007;
    public static final int RSP_GET_RECONNECT_INTENT = 0x4101b;
    public static final int RSP_GET_REFCOUNT = 0x41011;
    public static final int RSP_IS_INACTIVE = 0x41001;
    public static final int RSP_REMOVE_APNCONTEXT = 0x41015;
    public static final int RSP_RESET = 0x4100f;
    public static final int RSP_SET_LINK_PROPERTIES_HTTP_PROXY = 0x41009;
    public static final int RSP_SET_RECONNECT_INTENT = 0x41019;
    public static final int RSP_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE = 0x4100d;
    private static String sCmdToString[];
    public DataConnection dataConnection;
    private String mLogTag;

    static  {
        sCmdToString = new String[28];
        sCmdToString[0] = "REQ_IS_INACTIVE";
        sCmdToString[1] = "RSP_IS_INACTIVE";
        sCmdToString[2] = "REQ_GET_CID";
        sCmdToString[3] = "RSP_GET_CID";
        sCmdToString[4] = "REQ_GET_APNSETTING";
        sCmdToString[5] = "RSP_GET_APNSETTING";
        sCmdToString[6] = "REQ_GET_LINK_PROPERTIES";
        sCmdToString[7] = "RSP_GET_LINK_PROPERTIES";
        sCmdToString[8] = "REQ_SET_LINK_PROPERTIES_HTTP_PROXY";
        sCmdToString[9] = "RSP_SET_LINK_PROPERTIES_HTTP_PROXY";
        sCmdToString[10] = "REQ_GET_LINK_CAPABILITIES";
        sCmdToString[11] = "RSP_GET_LINK_CAPABILITIES";
        sCmdToString[12] = "REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE";
        sCmdToString[13] = "RSP_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE";
        sCmdToString[14] = "REQ_RESET";
        sCmdToString[15] = "RSP_RESET";
        sCmdToString[16] = "REQ_GET_REFCOUNT";
        sCmdToString[17] = "RSP_GET_REFCOUNT";
        sCmdToString[18] = "REQ_ADD_APNCONTEXT";
        sCmdToString[19] = "RSP_ADD_APNCONTEXT";
        sCmdToString[20] = "REQ_REMOVE_APNCONTEXT";
        sCmdToString[21] = "RSP_REMOVE_APNCONTEXT";
        sCmdToString[22] = "REQ_GET_APNCONTEXT_LIST";
        sCmdToString[23] = "RSP_GET_APNCONTEXT_LIST";
        sCmdToString[24] = "REQ_SET_RECONNECT_INTENT";
        sCmdToString[25] = "RSP_SET_RECONNECT_INTENT";
        sCmdToString[26] = "REQ_GET_RECONNECT_INTENT";
        sCmdToString[27] = "RSP_GET_RECONNECT_INTENT";
    }
}
