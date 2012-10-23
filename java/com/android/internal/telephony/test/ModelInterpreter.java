// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.test;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.io.*;
import java.net.*;
import java.util.List;

// Referenced classes of package com.android.internal.telephony.test:
//            SimulatedRadioControl, InterpreterEx, SimulatedGsmCallState, LineReader

public class ModelInterpreter
    implements Runnable, SimulatedRadioControl {

    public ModelInterpreter(InputStream inputstream, OutputStream outputstream) {
        pausedResponseMonitor = new Object();
        in = inputstream;
        out = outputstream;
        init();
    }

    public ModelInterpreter(InetSocketAddress inetsocketaddress) throws IOException {
        pausedResponseMonitor = new Object();
        ss = new ServerSocket();
        ss.setReuseAddress(true);
        ss.bind(inetsocketaddress);
        init();
    }

    private void conference() throws InterpreterEx {
        if(!simulatedCallState.conference())
            throw new InterpreterEx("ERROR");
        else
            return;
    }

    private void init() {
        (new Thread(this, "ModelInterpreter")).start();
        mHandlerThread = new HandlerThread("ModelInterpreter");
        mHandlerThread.start();
        simulatedCallState = new SimulatedGsmCallState(mHandlerThread.getLooper());
    }

    private void onAnswer() throws InterpreterEx {
        if(!simulatedCallState.onAnswer())
            throw new InterpreterEx("ERROR");
        else
            return;
    }

    private void onCHLD(String s) throws InterpreterEx {
        char c = '\0';
        char c1 = s.charAt(6);
        if(s.length() >= 8)
            c = s.charAt(7);
        if(!simulatedCallState.onChld(c1, c))
            throw new InterpreterEx("ERROR");
        else
            return;
    }

    private void onCLCC() throws InterpreterEx {
        List list = simulatedCallState.getClccLines();
        int i = 0;
        for(int j = list.size(); i < j; i++)
            println((String)list.get(i));

    }

    private void onDial(String s) throws InterpreterEx {
        if(!simulatedCallState.onDial(s.substring(1)))
            throw new InterpreterEx("ERROR");
        else
            return;
    }

    private void onHangup() throws InterpreterEx {
        if(!simulatedCallState.onAnswer()) {
            throw new InterpreterEx("ERROR");
        } else {
            finalResponse = "NO CARRIER";
            return;
        }
    }

    private void onSMSSend(String s) throws InterpreterEx {
        print("> ");
        lineReader.getNextLineCtrlZ();
        println("+CMGS: 1");
    }

    private void releaseActiveAcceptHeldOrWaiting() throws InterpreterEx {
        if(!simulatedCallState.releaseActiveAcceptHeldOrWaiting())
            throw new InterpreterEx("ERROR");
        else
            return;
    }

    private void releaseHeldOrUDUB() throws InterpreterEx {
        if(!simulatedCallState.releaseHeldOrUDUB())
            throw new InterpreterEx("ERROR");
        else
            return;
    }

    private void separateCall(int i) throws InterpreterEx {
        if(!simulatedCallState.separateCall(i))
            throw new InterpreterEx("ERROR");
        else
            return;
    }

    private void switchActiveAndHeldOrWaiting() throws InterpreterEx {
        if(!simulatedCallState.switchActiveAndHeldOrWaiting())
            throw new InterpreterEx("ERROR");
        else
            return;
    }

    public void pauseResponses() {
        Object obj = pausedResponseMonitor;
        obj;
        JVM INSTR monitorenter ;
        pausedResponseCount = 1 + pausedResponseCount;
        return;
    }

    void print(String s) {
        this;
        JVM INSTR monitorenter ;
        Exception exception;
        try {
            byte abyte0[] = s.getBytes("US-ASCII");
            out.write(abyte0);
        }
        catch(IOException ioexception) {
            ioexception.printStackTrace();
        }
        finally {
            this;
        }
        return;
        throw exception;
    }

    void println(String s) {
        this;
        JVM INSTR monitorenter ;
        Exception exception;
        try {
            byte abyte0[] = s.getBytes("US-ASCII");
            out.write(abyte0);
            out.write(13);
        }
        catch(IOException ioexception) {
            ioexception.printStackTrace();
        }
        finally {
            this;
        }
        return;
        throw exception;
    }

    void processLine(String s) throws InterpreterEx {
        String as[];
        int i;
        as = splitCommands(s);
        i = 0;
_L2:
        String s1;
        if(i >= as.length)
            break MISSING_BLOCK_LABEL_212;
        s1 = as[i];
        if(!s1.equals("A"))
            break; /* Loop/switch isn't completed */
        onAnswer();
_L3:
        i++;
        if(true) goto _L2; else goto _L1
_L1:
        if(s1.equals("H"))
            onHangup();
        else
        if(s1.startsWith("+CHLD="))
            onCHLD(s1);
        else
        if(s1.equals("+CLCC"))
            onCLCC();
        else
        if(s1.startsWith("D")) {
            onDial(s1);
        } else {
label0:
            {
                if(!s1.startsWith("+CMGS="))
                    break label0;
                onSMSSend(s1);
            }
        }
          goto _L3
        continue; /* Loop/switch isn't completed */
        boolean flag;
        int j;
        flag = false;
        j = 0;
_L5:
        if(j >= sDefaultResponses.length)
            continue; /* Loop/switch isn't completed */
        if(!s1.equals(sDefaultResponses[j][0]))
            break MISSING_BLOCK_LABEL_206;
        String s2 = sDefaultResponses[j][1];
        if(s2 != null)
            println(s2);
        flag = true;
        if(flag) goto _L3; else goto _L4
_L4:
        throw new InterpreterEx("ERROR");
        j++;
          goto _L5
        return;
        if(true) goto _L2; else goto _L6
_L6:
    }

    public void progressConnectingCallState() {
        simulatedCallState.progressConnectingCallState();
    }

    public void progressConnectingToActive() {
        simulatedCallState.progressConnectingToActive();
    }

    public void resumeResponses() {
        Object obj = pausedResponseMonitor;
        obj;
        JVM INSTR monitorenter ;
        pausedResponseCount = -1 + pausedResponseCount;
        if(pausedResponseCount == 0)
            pausedResponseMonitor.notifyAll();
        return;
    }

    public void run() {
_L2:
        if(ss == null)
            break MISSING_BLOCK_LABEL_43;
        Socket socket = ss.accept();
        in = socket.getInputStream();
        out = socket.getOutputStream();
        Log.i("ModelInterpreter", "New connection accepted");
        lineReader = new LineReader(in);
        println("Welcome");
_L7:
        String s;
        s = lineReader.getNextLine();
        if(s != null)
            break MISSING_BLOCK_LABEL_126;
        Log.i("ModelInterpreter", "Disconnected");
        if(ss != null) goto _L2; else goto _L1
_L1:
        return;
        IOException ioexception;
        ioexception;
        Log.w("ModelInterpreter", "IOException on socket.accept(); stopping", ioexception);
        if(true) goto _L1; else goto _L3
_L3:
        IOException ioexception1;
        ioexception1;
        Log.w("ModelInterpreter", "IOException on accepted socket(); re-listening", ioexception1);
          goto _L2
        Object obj = pausedResponseMonitor;
        obj;
        JVM INSTR monitorenter ;
_L6:
        int i = pausedResponseCount;
        if(i <= 0) goto _L5; else goto _L4
_L4:
        Exception exception;
        Exception exception1;
        try {
            pausedResponseMonitor.wait();
        }
        catch(InterruptedException interruptedexception) { }
        finally { }
        if(true) goto _L6; else goto _L5
_L5:
        obj;
        JVM INSTR monitorexit ;
        this;
        JVM INSTR monitorenter ;
        finalResponse = "OK";
        processLine(s);
        println(finalResponse);
_L8:
        this;
        JVM INSTR monitorexit ;
          goto _L7
        exception1;
        throw exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        InterpreterEx interpreterex;
        interpreterex;
        println(interpreterex.result);
          goto _L8
        RuntimeException runtimeexception;
        runtimeexception;
        runtimeexception.printStackTrace();
        println("ERROR");
          goto _L8
    }

    public void sendUnsolicited(String s) {
        this;
        JVM INSTR monitorenter ;
        println(s);
        return;
    }

    public void setAutoProgressConnectingCall(boolean flag) {
        simulatedCallState.setAutoProgressConnectingCall(flag);
    }

    public void setNextCallFailCause(int i) {
    }

    public void setNextDialFailImmediately(boolean flag) {
        simulatedCallState.setNextDialFailImmediately(flag);
    }

    public void shutdown() {
        Looper looper = mHandlerThread.getLooper();
        if(looper != null)
            looper.quit();
        IOException ioexception1;
        try {
            in.close();
        }
        catch(IOException ioexception) { }
        out.close();
_L2:
        return;
        ioexception1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    String[] splitCommands(String s) throws InterpreterEx {
        if(!s.startsWith("AT"))
            throw new InterpreterEx("ERROR");
        String as[];
        if(s.length() == 2) {
            as = new String[0];
        } else {
            as = new String[1];
            as[0] = s.substring(2);
        }
        return as;
    }

    public void triggerHangupAll() {
        if(simulatedCallState.triggerHangupAll())
            println("NO CARRIER");
    }

    public void triggerHangupBackground() {
        if(simulatedCallState.triggerHangupBackground())
            println("NO CARRIER");
    }

    public void triggerHangupForeground() {
        if(simulatedCallState.triggerHangupForeground())
            println("NO CARRIER");
    }

    public void triggerIncomingSMS(String s) {
    }

    public void triggerIncomingUssd(String s, String s1) {
    }

    public void triggerRing(String s) {
        this;
        JVM INSTR monitorenter ;
        if(simulatedCallState.triggerRing(s))
            println("RING");
        return;
    }

    public void triggerSsn(int i, int j) {
    }

    static final int CONNECTING_PAUSE_MSEC = 500;
    static final String LOG_TAG = "ModelInterpreter";
    static final int MAX_CALLS = 6;
    static final int PROGRESS_CALL_STATE = 1;
    static final String sDefaultResponses[][];
    private String finalResponse;
    InputStream in;
    LineReader lineReader;
    HandlerThread mHandlerThread;
    OutputStream out;
    int pausedResponseCount;
    Object pausedResponseMonitor;
    SimulatedGsmCallState simulatedCallState;
    ServerSocket ss;

    static  {
        String as[][] = new String[31][];
        String as1[] = new String[2];
        as1[0] = "E0Q0V1";
        as1[1] = null;
        as[0] = as1;
        String as2[] = new String[2];
        as2[0] = "+CMEE=2";
        as2[1] = null;
        as[1] = as2;
        String as3[] = new String[2];
        as3[0] = "+CREG=2";
        as3[1] = null;
        as[2] = as3;
        String as4[] = new String[2];
        as4[0] = "+CGREG=2";
        as4[1] = null;
        as[3] = as4;
        String as5[] = new String[2];
        as5[0] = "+CCWA=1";
        as5[1] = null;
        as[4] = as5;
        String as6[] = new String[2];
        as6[0] = "+COPS=0";
        as6[1] = null;
        as[5] = as6;
        String as7[] = new String[2];
        as7[0] = "+CFUN=1";
        as7[1] = null;
        as[6] = as7;
        String as8[] = new String[2];
        as8[0] = "+CGMI";
        as8[1] = "+CGMI: Android Model AT Interpreter\r";
        as[7] = as8;
        String as9[] = new String[2];
        as9[0] = "+CGMM";
        as9[1] = "+CGMM: Android Model AT Interpreter\r";
        as[8] = as9;
        String as10[] = new String[2];
        as10[0] = "+CGMR";
        as10[1] = "+CGMR: 1.0\r";
        as[9] = as10;
        String as11[] = new String[2];
        as11[0] = "+CGSN";
        as11[1] = "000000000000000\r";
        as[10] = as11;
        String as12[] = new String[2];
        as12[0] = "+CIMI";
        as12[1] = "320720000000000\r";
        as[11] = as12;
        String as13[] = new String[2];
        as13[0] = "+CSCS=?";
        as13[1] = "+CSCS: (\"HEX\",\"UCS2\")\r";
        as[12] = as13;
        String as14[] = new String[2];
        as14[0] = "+CFUN?";
        as14[1] = "+CFUN: 1\r";
        as[13] = as14;
        String as15[] = new String[2];
        as15[0] = "+COPS=3,0;+COPS?;+COPS=3,1;+COPS?;+COPS=3,2;+COPS?";
        as15[1] = "+COPS: 0,0,\"Android\"\r+COPS: 0,1,\"Android\"\r+COPS: 0,2,\"310995\"\r";
        as[14] = as15;
        String as16[] = new String[2];
        as16[0] = "+CREG?";
        as16[1] = "+CREG: 2,5, \"0113\", \"6614\"\r";
        as[15] = as16;
        String as17[] = new String[2];
        as17[0] = "+CGREG?";
        as17[1] = "+CGREG: 2,0\r";
        as[16] = as17;
        String as18[] = new String[2];
        as18[0] = "+CSQ";
        as18[1] = "+CSQ: 16,99\r";
        as[17] = as18;
        String as19[] = new String[2];
        as19[0] = "+CNMI?";
        as19[1] = "+CNMI: 1,2,2,1,1\r";
        as[18] = as19;
        String as20[] = new String[2];
        as20[0] = "+CLIR?";
        as20[1] = "+CLIR: 1,3\r";
        as[19] = as20;
        String as21[] = new String[2];
        as21[0] = "%CPVWI=2";
        as21[1] = "%CPVWI: 0\r";
        as[20] = as21;
        String as22[] = new String[2];
        as22[0] = "+CUSD=1,\"#646#\"";
        as22[1] = "+CUSD=0,\"You have used 23 minutes\"\r";
        as[21] = as22;
        String as23[] = new String[2];
        as23[0] = "+CRSM=176,12258,0,0,10";
        as23[1] = "+CRSM: 144,0,981062200050259429F6\r";
        as[22] = as23;
        String as24[] = new String[2];
        as24[0] = "+CRSM=192,12258,0,0,15";
        as24[1] = "+CRSM: 144,0,0000000A2FE204000FF55501020000\r";
        as[23] = as24;
        String as25[] = new String[2];
        as25[0] = "+CRSM=192,28474,0,0,15";
        as25[1] = "+CRSM: 144,0,0000005a6f3a040011f5220102011e\r";
        as[24] = as25;
        String as26[] = new String[2];
        as26[0] = "+CRSM=178,28474,1,4,30";
        as26[1] = "+CRSM: 144,0,437573746f6d65722043617265ffffff07818100398799f7ffffffffffff\r";
        as[25] = as26;
        String as27[] = new String[2];
        as27[0] = "+CRSM=178,28474,2,4,30";
        as27[1] = "+CRSM: 144,0,566f696365204d61696cffffffffffff07918150367742f3ffffffffffff\r";
        as[26] = as27;
        String as28[] = new String[2];
        as28[0] = "+CRSM=178,28474,3,4,30";
        as28[1] = "+CRSM: 144,0,4164676a6dffffffffffffffffffffff0b918188551512c221436587ff01\r";
        as[27] = as28;
        String as29[] = new String[2];
        as29[0] = "+CRSM=178,28474,4,4,30";
        as29[1] = "+CRSM: 144,0,810101c1ffffffffffffffffffffffff068114455245f8ffffffffffffff\r";
        as[28] = as29;
        String as30[] = new String[2];
        as30[0] = "+CRSM=192,28490,0,0,15";
        as30[1] = "+CRSM: 144,0,000000416f4a040011f5550102010d\r";
        as[29] = as30;
        String as31[] = new String[2];
        as31[0] = "+CRSM=178,28490,1,4,13";
        as31[1] = "+CRSM: 144,0,0206092143658709ffffffffff\r";
        as[30] = as31;
        sDefaultResponses = as;
    }
}
