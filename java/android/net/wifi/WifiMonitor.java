// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pProvDiscEvent;
import android.net.wifi.p2p.nsd.WifiP2pServiceResponse;
import android.util.Log;
import com.android.internal.util.StateMachine;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package android.net.wifi:
//            StateChangeResult, WifiNative, SupplicantState

public class WifiMonitor {
    class MonitorThread extends Thread {

        private boolean connectToSupplicant() {
            boolean flag;
            int i;
            flag = true;
            i = 0;
_L3:
            if(!mWifiNative.connectToSupplicant()) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
label0:
            {
                int j = i + 1;
                if(i >= 5)
                    break label0;
                WifiMonitor.nap(flag);
                i = j;
            }
              goto _L3
            flag = false;
              goto _L1
        }

        private void handleDriverEvent(String s) {
            if(s != null && s.equals("HANGED"))
                mStateMachine.sendMessage(0x2400c);
        }

        private void handleHostApEvents(String s) {
            String as[] = s.split(" ");
            if(!as[0].equals("AP-STA-CONNECTED")) goto _L2; else goto _L1
_L1:
            mStateMachine.sendMessage(0x2402a, new WifiP2pDevice(s));
_L4:
            return;
_L2:
            if(as[0].equals("AP-STA-DISCONNECTED"))
                mStateMachine.sendMessage(0x24029, new WifiP2pDevice(s));
            if(true) goto _L4; else goto _L3
_L3:
        }

        private void handleP2pEvents(String s) {
            if(!s.startsWith("P2P-DEVICE-FOUND")) goto _L2; else goto _L1
_L1:
            mStateMachine.sendMessage(0x24015, new WifiP2pDevice(s));
_L4:
            return;
_L2:
            if(s.startsWith("P2P-DEVICE-LOST"))
                mStateMachine.sendMessage(0x24016, new WifiP2pDevice(s));
            else
            if(s.startsWith("P2P-FIND-STOPPED"))
                mStateMachine.sendMessage(0x24025);
            else
            if(s.startsWith("P2P-GO-NEG-REQUEST"))
                mStateMachine.sendMessage(0x24017, new WifiP2pConfig(s));
            else
            if(s.startsWith("P2P-GO-NEG-SUCCESS"))
                mStateMachine.sendMessage(0x24019);
            else
            if(s.startsWith("P2P-GO-NEG-FAILURE"))
                mStateMachine.sendMessage(0x2401a);
            else
            if(s.startsWith("P2P-GROUP-FORMATION-SUCCESS"))
                mStateMachine.sendMessage(0x2401b);
            else
            if(s.startsWith("P2P-GROUP-FORMATION-FAILURE"))
                mStateMachine.sendMessage(0x2401c);
            else
            if(s.startsWith("P2P-GROUP-STARTED"))
                mStateMachine.sendMessage(0x2401d, new WifiP2pGroup(s));
            else
            if(s.startsWith("P2P-GROUP-REMOVED"))
                mStateMachine.sendMessage(0x2401e, new WifiP2pGroup(s));
            else
            if(s.startsWith("P2P-INVITATION-RECEIVED"))
                mStateMachine.sendMessage(0x2401f, new WifiP2pGroup(s));
            else
            if(s.startsWith("P2P-INVITATION-RESULT")) {
                String as[] = s.split(" ");
                if(as.length == 2) {
                    String as1[] = as[1].split("=");
                    if(as1.length == 2)
                        mStateMachine.sendMessage(0x24020, as1[1]);
                }
            } else
            if(s.startsWith("P2P-PROV-DISC-PBC-REQ"))
                mStateMachine.sendMessage(0x24021, new WifiP2pProvDiscEvent(s));
            else
            if(s.startsWith("P2P-PROV-DISC-PBC-RESP"))
                mStateMachine.sendMessage(0x24022, new WifiP2pProvDiscEvent(s));
            else
            if(s.startsWith("P2P-PROV-DISC-ENTER-PIN"))
                mStateMachine.sendMessage(0x24023, new WifiP2pProvDiscEvent(s));
            else
            if(s.startsWith("P2P-PROV-DISC-SHOW-PIN"))
                mStateMachine.sendMessage(0x24024, new WifiP2pProvDiscEvent(s));
            else
            if(s.startsWith("P2P-SERV-DISC-RESP")) {
                java.util.List list = WifiP2pServiceResponse.newInstance(s);
                if(list != null)
                    mStateMachine.sendMessage(0x24026, list);
                else
                    Log.e("WifiMonitor", (new StringBuilder()).append("Null service resp ").append(s).toString());
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        private void handleSupplicantStateChange(String s) {
            String s1;
            String as[];
            String s2;
            int j;
            int k;
            int l;
            int i1;
            s1 = null;
            int i = s.lastIndexOf("SSID=");
            if(i != -1)
                s1 = s.substring(i + 5);
            as = s.split(" ");
            s2 = null;
            j = -1;
            k = -1;
            l = as.length;
            i1 = 0;
_L2:
            String as1[];
            if(i1 >= l)
                break MISSING_BLOCK_LABEL_155;
            as1 = as[i1].split("=");
            if(as1.length == 2)
                break; /* Loop/switch isn't completed */
_L3:
            i1++;
            if(true) goto _L2; else goto _L1
_L1:
label0:
            {
                if(!as1[0].equals("BSSID"))
                    break label0;
                s2 = as1[1];
            }
              goto _L3
            int l1 = Integer.parseInt(as1[1]);
            NumberFormatException numberformatexception;
            if(as1[0].equals("id"))
                j = l1;
            else
            if(as1[0].equals("state"))
                k = l1;
              goto _L3
            numberformatexception;
              goto _L3
            if(k != -1) goto _L5; else goto _L4
_L4:
            return;
_L5:
            SupplicantState supplicantstate = SupplicantState.INVALID;
            SupplicantState asupplicantstate[] = SupplicantState.values();
            int j1 = asupplicantstate.length;
            int k1 = 0;
            do {
label1:
                {
                    if(k1 < j1) {
                        SupplicantState supplicantstate1 = asupplicantstate[k1];
                        if(supplicantstate1.ordinal() != k)
                            break label1;
                        supplicantstate = supplicantstate1;
                    }
                    if(supplicantstate == SupplicantState.INVALID)
                        Log.w("WifiMonitor", (new StringBuilder()).append("Invalid supplicant state: ").append(k).toString());
                    notifySupplicantStateChange(j, s1, s2, supplicantstate);
                }
                if(true)
                    continue;
                k1++;
            } while(true);
            if(true) goto _L4; else goto _L6
_L6:
        }

        private void handleWpsFailEvent(String s) {
            Matcher matcher = Pattern.compile("WPS-FAIL msg=\\d+(?: config_error=(\\d+))?(?: reason=(\\d+))?").matcher(s);
            if(!matcher.find()) goto _L2; else goto _L1
_L1:
            String s1;
            String s2;
            s1 = matcher.group(1);
            s2 = matcher.group(2);
            if(s2 == null) goto _L4; else goto _L3
_L3:
            Integer.parseInt(s2);
            JVM INSTR tableswitch 1 2: default 64
        //                       1 125
        //                       2 152;
               goto _L4 _L5 _L6
_L4:
            if(s1 == null) goto _L2; else goto _L7
_L7:
            Integer.parseInt(s1);
            JVM INSTR lookupswitch 2: default 100
        //                       12: 207
        //                       18: 179;
               goto _L2 _L8 _L9
_L2:
            mStateMachine.sendMessage(mStateMachine.obtainMessage(0x24009, 0, 0));
_L11:
            return;
_L5:
            mStateMachine.sendMessage(mStateMachine.obtainMessage(0x24009, 5, 0));
            continue; /* Loop/switch isn't completed */
_L6:
            mStateMachine.sendMessage(mStateMachine.obtainMessage(0x24009, 4, 0));
            continue; /* Loop/switch isn't completed */
_L9:
            mStateMachine.sendMessage(mStateMachine.obtainMessage(0x24009, 6, 0));
            continue; /* Loop/switch isn't completed */
_L8:
            mStateMachine.sendMessage(mStateMachine.obtainMessage(0x24009, 3, 0));
            if(true) goto _L11; else goto _L10
_L10:
        }

        void handleEvent(int i, String s) {
            i;
            JVM INSTR tableswitch 1 4: default 32
        //                       1 47
        //                       2 33
        //                       3 32
        //                       4 61;
               goto _L1 _L2 _L3 _L1 _L4
_L1:
            return;
_L3:
            handleNetworkStateChange(android.net.NetworkInfo.DetailedState.DISCONNECTED, s);
            continue; /* Loop/switch isn't completed */
_L2:
            handleNetworkStateChange(android.net.NetworkInfo.DetailedState.CONNECTED, s);
            continue; /* Loop/switch isn't completed */
_L4:
            mStateMachine.sendMessage(0x24005);
            if(true) goto _L1; else goto _L5
_L5:
        }

        public void run() {
            if(!connectToSupplicant()) goto _L2; else goto _L1
_L1:
            mStateMachine.sendMessage(0x24001);
_L5:
            String s = mWifiNative.waitForEvent();
            if(s.startsWith("CTRL-EVENT-")) goto _L4; else goto _L3
_L3:
            if(s.startsWith("WPA:") && s.indexOf("pre-shared key may be incorrect") > 0)
                mStateMachine.sendMessage(0x24007);
            else
            if(s.startsWith("WPS-SUCCESS"))
                mStateMachine.sendMessage(0x24008);
            else
            if(s.startsWith("WPS-FAIL"))
                handleWpsFailEvent(s);
            else
            if(s.startsWith("WPS-OVERLAP-DETECTED"))
                mStateMachine.sendMessage(0x2400a);
            else
            if(s.startsWith("WPS-TIMEOUT"))
                mStateMachine.sendMessage(0x2400b);
            else
            if(s.startsWith("P2P"))
                handleP2pEvents(s);
            else
            if(s.startsWith("AP"))
                handleHostApEvents(s);
              goto _L5
_L2:
            mStateMachine.sendMessage(0x24002);
_L8:
            return;
_L4:
            String s1;
            s1 = s.substring(WifiMonitor.EVENT_PREFIX_LEN_STR);
            int i = s1.indexOf(' ');
            if(i != -1)
                s1 = s1.substring(0, i);
            if(s1.length() == 0) goto _L5; else goto _L6
_L6:
            int j;
            String s2;
            if(s1.equals("CONNECTED"))
                j = 1;
            else
            if(s1.equals("DISCONNECTED"))
                j = 2;
            else
            if(s1.equals("STATE-CHANGE"))
                j = 3;
            else
            if(s1.equals("SCAN-RESULTS"))
                j = 4;
            else
            if(s1.equals("LINK-SPEED"))
                j = 5;
            else
            if(s1.equals("TERMINATING"))
                j = 6;
            else
            if(s1.equals("DRIVER-STATE"))
                j = 7;
            else
            if(s1.equals("EAP-FAILURE"))
                j = 8;
            else
                j = 9;
            s2 = s;
            if(j == 7 || j == 5)
                s2 = s2.split(" ")[1];
            else
            if(j == 3 || j == 8) {
                int k = s.indexOf(" ");
                if(k != -1)
                    s2 = s.substring(k + 1);
            } else {
                int l = s.indexOf(" - ");
                if(l != -1)
                    s2 = s.substring(l + 3);
            }
            if(j == 3) {
                handleSupplicantStateChange(s2);
            } else {
label0:
                {
                    if(j != 7)
                        break label0;
                    handleDriverEvent(s2);
                }
            }
_L9:
            mRecvErrors = 0;
              goto _L5
            if(j != 6)
                break MISSING_BLOCK_LABEL_576;
            if(s2.startsWith("recv error") && int i = 1 + ((access._cls500) (this)).access$500 <= 10) goto _L5; else goto _L7
_L7:
            mStateMachine.sendMessage(0x24002);
              goto _L8
            if(j == 8) {
                if(s2.startsWith("EAP authentication failed"))
                    mStateMachine.sendMessage(0x24007);
            } else {
                handleEvent(j, s2);
            }
              goto _L9
        }

        final WifiMonitor this$0;

        public MonitorThread() {
            this$0 = WifiMonitor.this;
            super("WifiMonitor");
        }
    }


    public WifiMonitor(StateMachine statemachine, WifiNative wifinative) {
        mRecvErrors = 0;
        mStateMachine = statemachine;
        mWifiNative = wifinative;
    }

    private void handleNetworkStateChange(android.net.NetworkInfo.DetailedState detailedstate, String s) {
        String s1;
        int i;
        s1 = null;
        i = -1;
        if(detailedstate != android.net.NetworkInfo.DetailedState.CONNECTED) goto _L2; else goto _L1
_L1:
        Matcher matcher = mConnectedEventPattern.matcher(s);
        if(matcher.find()) goto _L3; else goto _L2
_L2:
        notifyNetworkStateChange(detailedstate, s1, i);
        return;
_L3:
        s1 = matcher.group(1);
        int j = Integer.parseInt(matcher.group(2));
        i = j;
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        i = -1;
        if(true) goto _L2; else goto _L4
_L4:
    }

    private static void nap(int i) {
        long l = i * 1000;
        Thread.sleep(l);
_L2:
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    void notifyNetworkStateChange(android.net.NetworkInfo.DetailedState detailedstate, String s, int i) {
        if(detailedstate == android.net.NetworkInfo.DetailedState.CONNECTED) {
            android.os.Message message1 = mStateMachine.obtainMessage(0x24003, i, 0, s);
            mStateMachine.sendMessage(message1);
        } else {
            android.os.Message message = mStateMachine.obtainMessage(0x24004, i, 0, s);
            mStateMachine.sendMessage(message);
        }
    }

    void notifySupplicantStateChange(int i, String s, String s1, SupplicantState supplicantstate) {
        mStateMachine.sendMessage(mStateMachine.obtainMessage(0x24006, new StateChangeResult(i, s, s1, supplicantstate)));
    }

    public void startMonitoring() {
        (new MonitorThread()).start();
    }

    public static final int AP_STA_CONNECTED_EVENT = 0x2402a;
    private static final String AP_STA_CONNECTED_STR = "AP-STA-CONNECTED";
    public static final int AP_STA_DISCONNECTED_EVENT = 0x24029;
    private static final String AP_STA_DISCONNECTED_STR = "AP-STA-DISCONNECTED";
    public static final int AUTHENTICATION_FAILURE_EVENT = 0x24007;
    private static final int BASE = 0x24000;
    private static final int CONFIG_AUTH_FAILURE = 18;
    private static final int CONFIG_MULTIPLE_PBC_DETECTED = 12;
    private static final int CONNECTED = 1;
    private static final String CONNECTED_STR = "CONNECTED";
    private static final int DISCONNECTED = 2;
    private static final String DISCONNECTED_STR = "DISCONNECTED";
    public static final int DRIVER_HUNG_EVENT = 0x2400c;
    private static final int DRIVER_STATE = 7;
    private static final String DRIVER_STATE_STR = "DRIVER-STATE";
    private static final String EAP_AUTH_FAILURE_STR = "EAP authentication failed";
    private static final int EAP_FAILURE = 8;
    private static final String EAP_FAILURE_STR = "EAP-FAILURE";
    private static final int EVENT_PREFIX_LEN_STR = 0;
    private static final String EVENT_PREFIX_STR = "CTRL-EVENT-";
    private static final String HOST_AP_EVENT_PREFIX_STR = "AP";
    private static final int LINK_SPEED = 5;
    private static final String LINK_SPEED_STR = "LINK-SPEED";
    private static final int MAX_RECV_ERRORS = 10;
    private static final String MONITOR_SOCKET_CLOSED_STR = "connection closed";
    public static final int NETWORK_CONNECTION_EVENT = 0x24003;
    public static final int NETWORK_DISCONNECTION_EVENT = 0x24004;
    public static final int P2P_DEVICE_FOUND_EVENT = 0x24015;
    private static final String P2P_DEVICE_FOUND_STR = "P2P-DEVICE-FOUND";
    public static final int P2P_DEVICE_LOST_EVENT = 0x24016;
    private static final String P2P_DEVICE_LOST_STR = "P2P-DEVICE-LOST";
    private static final String P2P_EVENT_PREFIX_STR = "P2P";
    public static final int P2P_FIND_STOPPED_EVENT = 0x24025;
    private static final String P2P_FIND_STOPPED_STR = "P2P-FIND-STOPPED";
    public static final int P2P_GO_NEGOTIATION_FAILURE_EVENT = 0x2401a;
    public static final int P2P_GO_NEGOTIATION_REQUEST_EVENT = 0x24017;
    public static final int P2P_GO_NEGOTIATION_SUCCESS_EVENT = 0x24019;
    private static final String P2P_GO_NEG_FAILURE_STR = "P2P-GO-NEG-FAILURE";
    private static final String P2P_GO_NEG_REQUEST_STR = "P2P-GO-NEG-REQUEST";
    private static final String P2P_GO_NEG_SUCCESS_STR = "P2P-GO-NEG-SUCCESS";
    public static final int P2P_GROUP_FORMATION_FAILURE_EVENT = 0x2401c;
    private static final String P2P_GROUP_FORMATION_FAILURE_STR = "P2P-GROUP-FORMATION-FAILURE";
    public static final int P2P_GROUP_FORMATION_SUCCESS_EVENT = 0x2401b;
    private static final String P2P_GROUP_FORMATION_SUCCESS_STR = "P2P-GROUP-FORMATION-SUCCESS";
    public static final int P2P_GROUP_REMOVED_EVENT = 0x2401e;
    private static final String P2P_GROUP_REMOVED_STR = "P2P-GROUP-REMOVED";
    public static final int P2P_GROUP_STARTED_EVENT = 0x2401d;
    private static final String P2P_GROUP_STARTED_STR = "P2P-GROUP-STARTED";
    public static final int P2P_INVITATION_RECEIVED_EVENT = 0x2401f;
    private static final String P2P_INVITATION_RECEIVED_STR = "P2P-INVITATION-RECEIVED";
    public static final int P2P_INVITATION_RESULT_EVENT = 0x24020;
    private static final String P2P_INVITATION_RESULT_STR = "P2P-INVITATION-RESULT";
    public static final int P2P_PROV_DISC_ENTER_PIN_EVENT = 0x24023;
    private static final String P2P_PROV_DISC_ENTER_PIN_STR = "P2P-PROV-DISC-ENTER-PIN";
    public static final int P2P_PROV_DISC_PBC_REQ_EVENT = 0x24021;
    private static final String P2P_PROV_DISC_PBC_REQ_STR = "P2P-PROV-DISC-PBC-REQ";
    public static final int P2P_PROV_DISC_PBC_RSP_EVENT = 0x24022;
    private static final String P2P_PROV_DISC_PBC_RSP_STR = "P2P-PROV-DISC-PBC-RESP";
    public static final int P2P_PROV_DISC_SHOW_PIN_EVENT = 0x24024;
    private static final String P2P_PROV_DISC_SHOW_PIN_STR = "P2P-PROV-DISC-SHOW-PIN";
    public static final int P2P_SERV_DISC_RESP_EVENT = 0x24026;
    private static final String P2P_SERV_DISC_RESP_STR = "P2P-SERV-DISC-RESP";
    private static final String PASSWORD_MAY_BE_INCORRECT_STR = "pre-shared key may be incorrect";
    private static final int REASON_TKIP_ONLY_PROHIBITED = 1;
    private static final int REASON_WEP_PROHIBITED = 2;
    private static final int SCAN_RESULTS = 4;
    public static final int SCAN_RESULTS_EVENT = 0x24005;
    private static final String SCAN_RESULTS_STR = "SCAN-RESULTS";
    private static final int STATE_CHANGE = 3;
    private static final String STATE_CHANGE_STR = "STATE-CHANGE";
    public static final int SUPPLICANT_STATE_CHANGE_EVENT = 0x24006;
    public static final int SUP_CONNECTION_EVENT = 0x24001;
    public static final int SUP_DISCONNECTION_EVENT = 0x24002;
    private static final String TAG = "WifiMonitor";
    private static final int TERMINATING = 6;
    private static final String TERMINATING_STR = "TERMINATING";
    private static final int UNKNOWN = 9;
    private static final String WPA_EVENT_PREFIX_STR = "WPA:";
    private static final String WPA_RECV_ERROR_STR = "recv error";
    public static final int WPS_FAIL_EVENT = 0x24009;
    private static final String WPS_FAIL_PATTERN = "WPS-FAIL msg=\\d+(?: config_error=(\\d+))?(?: reason=(\\d+))?";
    private static final String WPS_FAIL_STR = "WPS-FAIL";
    public static final int WPS_OVERLAP_EVENT = 0x2400a;
    private static final String WPS_OVERLAP_STR = "WPS-OVERLAP-DETECTED";
    public static final int WPS_SUCCESS_EVENT = 0x24008;
    private static final String WPS_SUCCESS_STR = "WPS-SUCCESS";
    public static final int WPS_TIMEOUT_EVENT = 0x2400b;
    private static final String WPS_TIMEOUT_STR = "WPS-TIMEOUT";
    private static Pattern mConnectedEventPattern = Pattern.compile("((?:[0-9a-f]{2}:){5}[0-9a-f]{2}) .* \\[id=([0-9]+) ");
    private int mRecvErrors;
    private final StateMachine mStateMachine;
    private final WifiNative mWifiNative;

    static  {
        EVENT_PREFIX_LEN_STR = "CTRL-EVENT-".length();
    }





/*
    static int access$302(WifiMonitor wifimonitor, int i) {
        wifimonitor.mRecvErrors = i;
        return i;
    }

*/


/*
    static int access$304(WifiMonitor wifimonitor) {
        int i = 1 + wifimonitor.mRecvErrors;
        wifimonitor.mRecvErrors = i;
        return i;
    }

*/


}
