// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import android.os.*;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.*;

// Referenced classes of package com.android.internal.util:
//            IState, State

public class StateMachine {
    private static class SmHandler extends Handler {
        private class QuittingState extends State {

            public boolean processMessage(Message message) {
                return false;
            }

            final SmHandler this$0;

            private QuittingState() {
                this$0 = SmHandler.this;
                super();
            }

        }

        private class HaltingState extends State {

            public boolean processMessage(Message message) {
                mSm.haltedProcessMessage(message);
                return true;
            }

            final SmHandler this$0;

            private HaltingState() {
                this$0 = SmHandler.this;
                super();
            }

        }

        private class StateInfo {

            public String toString() {
                StringBuilder stringbuilder = (new StringBuilder()).append("state=").append(state.getName()).append(",active=").append(active).append(",parent=");
                String s;
                if(parentStateInfo == null)
                    s = "null";
                else
                    s = parentStateInfo.state.getName();
                return stringbuilder.append(s).toString();
            }

            boolean active;
            StateInfo parentStateInfo;
            State state;
            final SmHandler this$0;

            private StateInfo() {
                this$0 = SmHandler.this;
                super();
            }

        }


        private final StateInfo addState(State state, State state1) {
            StateInfo stateinfo;
            StateInfo stateinfo1;
            if(mDbg) {
                StringBuilder stringbuilder = (new StringBuilder()).append("addStateInternal: E state=").append(state.getName()).append(",parent=");
                String s;
                if(state1 == null)
                    s = "";
                else
                    s = state1.getName();
                Log.d("StateMachine", stringbuilder.append(s).toString());
            }
            stateinfo = null;
            if(state1 != null) {
                stateinfo = (StateInfo)mStateInfo.get(state1);
                if(stateinfo == null)
                    stateinfo = addState(state1, null);
            }
            stateinfo1 = (StateInfo)mStateInfo.get(state);
            if(stateinfo1 == null) {
                stateinfo1 = new StateInfo();
                mStateInfo.put(state, stateinfo1);
            }
            if(stateinfo1.parentStateInfo != null && stateinfo1.parentStateInfo != stateinfo)
                throw new RuntimeException("state already added");
            stateinfo1.state = state;
            stateinfo1.parentStateInfo = stateinfo;
            stateinfo1.active = false;
            if(mDbg)
                Log.d("StateMachine", (new StringBuilder()).append("addStateInternal: X stateInfo: ").append(stateinfo1).toString());
            return stateinfo1;
        }

        private final void cleanupAfterQuitting() {
            mSm.quitting();
            if(mSm.mSmThread != null) {
                getLooper().quit();
                mSm.mSmThread = null;
            }
            mSm.mSmHandler = null;
            mSm = null;
            mMsg = null;
            mProcessedMessages.cleanup();
            mStateStack = null;
            mTempStateStack = null;
            mStateInfo.clear();
            mInitialState = null;
            mDestState = null;
            mDeferredMessages.clear();
        }

        private final void completeConstruction() {
            if(mDbg)
                Log.d("StateMachine", "completeConstruction: E");
            int i = 0;
            Iterator iterator = mStateInfo.values().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                StateInfo stateinfo = (StateInfo)iterator.next();
                int j = 0;
                for(StateInfo stateinfo1 = stateinfo; stateinfo1 != null;) {
                    stateinfo1 = stateinfo1.parentStateInfo;
                    j++;
                }

                if(i < j)
                    i = j;
            } while(true);
            if(mDbg)
                Log.d("StateMachine", (new StringBuilder()).append("completeConstruction: maxDepth=").append(i).toString());
            mStateStack = new StateInfo[i];
            mTempStateStack = new StateInfo[i];
            setupInitialStateStack();
            sendMessageAtFrontOfQueue(obtainMessage(-2, mSmHandlerObj));
            if(mDbg)
                Log.d("StateMachine", "completeConstruction: X");
        }

        private final void deferMessage(Message message) {
            if(mDbg)
                Log.d("StateMachine", (new StringBuilder()).append("deferMessage: msg=").append(message.what).toString());
            Message message1 = obtainMessage();
            message1.copyFrom(message);
            mDeferredMessages.add(message1);
        }

        private final Message getCurrentMessage() {
            return mMsg;
        }

        private final IState getCurrentState() {
            return mStateStack[mStateStackTopIndex].state;
        }

        private final ProcessedMessageInfo getProcessedMessageInfo(int i) {
            return mProcessedMessages.get(i);
        }

        private final int getProcessedMessagesCount() {
            return mProcessedMessages.count();
        }

        private final int getProcessedMessagesSize() {
            return mProcessedMessages.size();
        }

        private final void invokeEnterMethods(int i) {
            for(int j = i; j <= mStateStackTopIndex; j++) {
                if(mDbg)
                    Log.d("StateMachine", (new StringBuilder()).append("invokeEnterMethods: ").append(mStateStack[j].state.getName()).toString());
                mStateStack[j].state.enter();
                mStateStack[j].active = true;
            }

        }

        private final void invokeExitMethods(StateInfo stateinfo) {
            for(; mStateStackTopIndex >= 0 && mStateStack[mStateStackTopIndex] != stateinfo; mStateStackTopIndex = -1 + mStateStackTopIndex) {
                State state = mStateStack[mStateStackTopIndex].state;
                if(mDbg)
                    Log.d("StateMachine", (new StringBuilder()).append("invokeExitMethods: ").append(state.getName()).toString());
                state.exit();
                mStateStack[mStateStackTopIndex].active = false;
            }

        }

        private final boolean isDbg() {
            return mDbg;
        }

        private final boolean isQuit(Message message) {
            boolean flag;
            if(message.what == -1 && message.obj == mSmHandlerObj)
                flag = true;
            else
                flag = false;
            return flag;
        }

        private final void moveDeferredMessageAtFrontOfQueue() {
            for(int i = -1 + mDeferredMessages.size(); i >= 0; i--) {
                Message message = (Message)mDeferredMessages.get(i);
                if(mDbg)
                    Log.d("StateMachine", (new StringBuilder()).append("moveDeferredMessageAtFrontOfQueue; what=").append(message.what).toString());
                sendMessageAtFrontOfQueue(message);
            }

            mDeferredMessages.clear();
        }

        private final int moveTempStateStackToStateStack() {
            int i = 1 + mStateStackTopIndex;
            int j = -1 + mTempStateStackCount;
            int k = i;
            for(; j >= 0; j--) {
                if(mDbg)
                    Log.d("StateMachine", (new StringBuilder()).append("moveTempStackToStateStack: i=").append(j).append(",j=").append(k).toString());
                mStateStack[k] = mTempStateStack[j];
                k++;
            }

            mStateStackTopIndex = k - 1;
            if(mDbg)
                Log.d("StateMachine", (new StringBuilder()).append("moveTempStackToStateStack: X mStateStackTop=").append(mStateStackTopIndex).append(",startingIndex=").append(i).append(",Top=").append(mStateStack[mStateStackTopIndex].state.getName()).toString());
            return i;
        }

        private void performTransitions() {
            State state;
            state = null;
            while(mDestState != null)  {
                if(mDbg)
                    Log.d("StateMachine", "handleMessage: new destination call exit");
                state = mDestState;
                mDestState = null;
                invokeExitMethods(setupTempStateStackWithStatesToEnter(state));
                invokeEnterMethods(moveTempStateStackToStateStack());
                moveDeferredMessageAtFrontOfQueue();
            }
            if(state == null) goto _L2; else goto _L1
_L1:
            if(state != mQuittingState) goto _L4; else goto _L3
_L3:
            cleanupAfterQuitting();
_L2:
            return;
_L4:
            if(state == mHaltingState)
                mSm.halting();
            if(true) goto _L2; else goto _L5
_L5:
        }

        private final void processMsg(Message message) {
            StateInfo stateinfo = mStateStack[mStateStackTopIndex];
            if(mDbg)
                Log.d("StateMachine", (new StringBuilder()).append("processMsg: ").append(stateinfo.state.getName()).toString());
            do {
label0:
                {
                    if(!stateinfo.state.processMessage(message)) {
                        stateinfo = stateinfo.parentStateInfo;
                        if(stateinfo != null)
                            break label0;
                        mSm.unhandledMessage(message);
                        if(isQuit(message))
                            transitionTo(mQuittingState);
                    }
                    if(mSm.recordProcessedMessage(message))
                        if(stateinfo != null) {
                            State state = mStateStack[mStateStackTopIndex].state;
                            mProcessedMessages.add(message, mSm.getMessageInfo(message), stateinfo.state, state);
                        } else {
                            mProcessedMessages.add(message, mSm.getMessageInfo(message), null, null);
                        }
                    return;
                }
                if(mDbg)
                    Log.d("StateMachine", (new StringBuilder()).append("processMsg: ").append(stateinfo.state.getName()).toString());
            } while(true);
        }

        private final void quit() {
            if(mDbg)
                Log.d("StateMachine", "quit:");
            sendMessage(obtainMessage(-1, mSmHandlerObj));
        }

        private final void setDbg(boolean flag) {
            mDbg = flag;
        }

        private final void setInitialState(State state) {
            if(mDbg)
                Log.d("StateMachine", (new StringBuilder()).append("setInitialState: initialState=").append(state.getName()).toString());
            mInitialState = state;
        }

        private final void setProcessedMessagesSize(int i) {
            mProcessedMessages.setSize(i);
        }

        private final void setupInitialStateStack() {
            if(mDbg)
                Log.d("StateMachine", (new StringBuilder()).append("setupInitialStateStack: E mInitialState=").append(mInitialState.getName()).toString());
            StateInfo stateinfo = (StateInfo)mStateInfo.get(mInitialState);
            for(mTempStateStackCount = 0; stateinfo != null; mTempStateStackCount = 1 + mTempStateStackCount) {
                mTempStateStack[mTempStateStackCount] = stateinfo;
                stateinfo = stateinfo.parentStateInfo;
            }

            mStateStackTopIndex = -1;
            moveTempStateStackToStateStack();
        }

        private final StateInfo setupTempStateStackWithStatesToEnter(State state) {
            mTempStateStackCount = 0;
            StateInfo stateinfo = (StateInfo)mStateInfo.get(state);
            do {
                StateInfo astateinfo[] = mTempStateStack;
                int i = mTempStateStackCount;
                mTempStateStackCount = i + 1;
                astateinfo[i] = stateinfo;
                stateinfo = stateinfo.parentStateInfo;
            } while(stateinfo != null && !stateinfo.active);
            if(mDbg)
                Log.d("StateMachine", (new StringBuilder()).append("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=").append(mTempStateStackCount).append(",curStateInfo: ").append(stateinfo).toString());
            return stateinfo;
        }

        private final void transitionTo(IState istate) {
            mDestState = (State)istate;
            if(mDbg)
                Log.d("StateMachine", (new StringBuilder()).append("transitionTo: destState=").append(mDestState.getName()).toString());
        }

        public final void handleMessage(Message message) {
            if(mDbg)
                Log.d("StateMachine", (new StringBuilder()).append("handleMessage: E msg.what=").append(message.what).toString());
            mMsg = message;
            if(mIsConstructionCompleted)
                processMsg(message);
            else
            if(!mIsConstructionCompleted && mMsg.what == -2 && mMsg.obj == mSmHandlerObj) {
                mIsConstructionCompleted = true;
                invokeEnterMethods(0);
            } else {
                throw new RuntimeException((new StringBuilder()).append("StateMachine.handleMessage: The start method not called, received msg: ").append(message).toString());
            }
            performTransitions();
            if(mDbg)
                Log.d("StateMachine", "handleMessage: X");
        }

        private static final Object mSmHandlerObj = new Object();
        private boolean mDbg;
        private ArrayList mDeferredMessages;
        private State mDestState;
        private HaltingState mHaltingState;
        private State mInitialState;
        private boolean mIsConstructionCompleted;
        private Message mMsg;
        private ProcessedMessages mProcessedMessages;
        private QuittingState mQuittingState;
        private StateMachine mSm;
        private HashMap mStateInfo;
        private StateInfo mStateStack[];
        private int mStateStackTopIndex;
        private StateInfo mTempStateStack[];
        private int mTempStateStackCount;




















        private SmHandler(Looper looper, StateMachine statemachine) {
            super(looper);
            mDbg = false;
            mProcessedMessages = new ProcessedMessages();
            mStateStackTopIndex = -1;
            mHaltingState = new HaltingState();
            mQuittingState = new QuittingState();
            mStateInfo = new HashMap();
            mDeferredMessages = new ArrayList();
            mSm = statemachine;
            addState(mHaltingState, null);
            addState(mQuittingState, null);
        }

    }

    private static class ProcessedMessages {

        void add(Message message, String s, State state, State state1) {
            mCount = 1 + mCount;
            if(mMessages.size() < mMaxSize) {
                mMessages.add(new ProcessedMessageInfo(message, s, state, state1));
            } else {
                ProcessedMessageInfo processedmessageinfo = (ProcessedMessageInfo)mMessages.get(mOldestIndex);
                mOldestIndex = 1 + mOldestIndex;
                if(mOldestIndex >= mMaxSize)
                    mOldestIndex = 0;
                processedmessageinfo.update(message, s, state, state1);
            }
        }

        void cleanup() {
            mMessages.clear();
        }

        int count() {
            return mCount;
        }

        ProcessedMessageInfo get(int i) {
            int j = i + mOldestIndex;
            if(j >= mMaxSize)
                j -= mMaxSize;
            ProcessedMessageInfo processedmessageinfo;
            if(j >= size())
                processedmessageinfo = null;
            else
                processedmessageinfo = (ProcessedMessageInfo)mMessages.get(j);
            return processedmessageinfo;
        }

        void setSize(int i) {
            mMaxSize = i;
            mCount = 0;
            mMessages.clear();
        }

        int size() {
            return mMessages.size();
        }

        private static final int DEFAULT_SIZE = 20;
        private int mCount;
        private int mMaxSize;
        private Vector mMessages;
        private int mOldestIndex;

        private ProcessedMessages() {
            mMessages = new Vector();
            mMaxSize = 20;
            mOldestIndex = 0;
            mCount = 0;
        }

    }

    public static class ProcessedMessageInfo {

        public String getInfo() {
            return mInfo;
        }

        public State getOriginalState() {
            return mOrgState;
        }

        public State getState() {
            return mState;
        }

        public long getTime() {
            return mTime;
        }

        public long getWhat() {
            return (long)mWhat;
        }

        public String toString() {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("time=");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(mTime);
            Object aobj[] = new Object[6];
            aobj[0] = calendar;
            aobj[1] = calendar;
            aobj[2] = calendar;
            aobj[3] = calendar;
            aobj[4] = calendar;
            aobj[5] = calendar;
            stringbuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", aobj));
            stringbuilder.append(" state=");
            String s;
            String s1;
            if(mState == null)
                s = "<null>";
            else
                s = mState.getName();
            stringbuilder.append(s);
            stringbuilder.append(" orgState=");
            if(mOrgState == null)
                s1 = "<null>";
            else
                s1 = mOrgState.getName();
            stringbuilder.append(s1);
            stringbuilder.append(" what=");
            stringbuilder.append(mWhat);
            stringbuilder.append("(0x");
            stringbuilder.append(Integer.toHexString(mWhat));
            stringbuilder.append(")");
            if(!TextUtils.isEmpty(mInfo)) {
                stringbuilder.append(" ");
                stringbuilder.append(mInfo);
            }
            return stringbuilder.toString();
        }

        public void update(Message message, String s, State state, State state1) {
            mTime = System.currentTimeMillis();
            mWhat = message.what;
            mInfo = s;
            mState = state;
            mOrgState = state1;
        }

        private String mInfo;
        private State mOrgState;
        private State mState;
        private long mTime;
        private int mWhat;

        ProcessedMessageInfo(Message message, String s, State state, State state1) {
            update(message, s, state, state1);
        }
    }


    protected StateMachine(String s) {
        mSmThread = new HandlerThread(s);
        mSmThread.start();
        initStateMachine(s, mSmThread.getLooper());
    }

    protected StateMachine(String s, Looper looper) {
        initStateMachine(s, looper);
    }

    private void initStateMachine(String s, Looper looper) {
        mName = s;
        mSmHandler = new SmHandler(looper, this);
    }

    protected final void addState(State state) {
        mSmHandler.addState(state, null);
    }

    protected final void addState(State state, State state1) {
        mSmHandler.addState(state, state1);
    }

    protected final void deferMessage(Message message) {
        mSmHandler.deferMessage(message);
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println((new StringBuilder()).append(getName()).append(":").toString());
        printwriter.println((new StringBuilder()).append(" total messages=").append(getProcessedMessagesCount()).toString());
        for(int i = 0; i < getProcessedMessagesSize(); i++) {
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(i);
            aobj[1] = getProcessedMessageInfo(i);
            printwriter.printf(" msg[%d]: %s\n", aobj);
            printwriter.flush();
        }

        printwriter.println((new StringBuilder()).append("curState=").append(getCurrentState().getName()).toString());
    }

    protected final Message getCurrentMessage() {
        return mSmHandler.getCurrentMessage();
    }

    protected final IState getCurrentState() {
        return mSmHandler.getCurrentState();
    }

    public final Handler getHandler() {
        return mSmHandler;
    }

    protected String getMessageInfo(Message message) {
        return "";
    }

    public final String getName() {
        return mName;
    }

    public final ProcessedMessageInfo getProcessedMessageInfo(int i) {
        return mSmHandler.getProcessedMessageInfo(i);
    }

    public final int getProcessedMessagesCount() {
        return mSmHandler.getProcessedMessagesCount();
    }

    public final int getProcessedMessagesSize() {
        return mSmHandler.getProcessedMessagesSize();
    }

    protected void haltedProcessMessage(Message message) {
    }

    protected void halting() {
    }

    public boolean isDbg() {
        boolean flag;
        if(mSmHandler == null)
            flag = false;
        else
            flag = mSmHandler.isDbg();
        return flag;
    }

    protected final boolean isQuit(Message message) {
        return mSmHandler.isQuit(message);
    }

    public final Message obtainMessage() {
        Message message;
        if(mSmHandler == null)
            message = null;
        else
            message = Message.obtain(mSmHandler);
        return message;
    }

    public final Message obtainMessage(int i) {
        Message message;
        if(mSmHandler == null)
            message = null;
        else
            message = Message.obtain(mSmHandler, i);
        return message;
    }

    public final Message obtainMessage(int i, int j, int k) {
        Message message;
        if(mSmHandler == null)
            message = null;
        else
            message = Message.obtain(mSmHandler, i, j, k);
        return message;
    }

    public final Message obtainMessage(int i, int j, int k, Object obj) {
        Message message;
        if(mSmHandler == null)
            message = null;
        else
            message = Message.obtain(mSmHandler, i, j, k, obj);
        return message;
    }

    public final Message obtainMessage(int i, Object obj) {
        Message message;
        if(mSmHandler == null)
            message = null;
        else
            message = Message.obtain(mSmHandler, i, obj);
        return message;
    }

    public final void quit() {
        if(mSmHandler != null)
            mSmHandler.quit();
    }

    protected void quitting() {
    }

    protected boolean recordProcessedMessage(Message message) {
        return true;
    }

    protected final void removeMessages(int i) {
        mSmHandler.removeMessages(i);
    }

    public final void sendMessage(int i) {
        if(mSmHandler != null)
            mSmHandler.sendMessage(obtainMessage(i));
    }

    public final void sendMessage(int i, Object obj) {
        if(mSmHandler != null)
            mSmHandler.sendMessage(obtainMessage(i, obj));
    }

    public final void sendMessage(Message message) {
        if(mSmHandler != null)
            mSmHandler.sendMessage(message);
    }

    protected final void sendMessageAtFrontOfQueue(int i) {
        mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(i));
    }

    protected final void sendMessageAtFrontOfQueue(int i, Object obj) {
        mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(i, obj));
    }

    protected final void sendMessageAtFrontOfQueue(Message message) {
        mSmHandler.sendMessageAtFrontOfQueue(message);
    }

    public final void sendMessageDelayed(int i, long l) {
        if(mSmHandler != null)
            mSmHandler.sendMessageDelayed(obtainMessage(i), l);
    }

    public final void sendMessageDelayed(int i, Object obj, long l) {
        if(mSmHandler != null)
            mSmHandler.sendMessageDelayed(obtainMessage(i, obj), l);
    }

    public final void sendMessageDelayed(Message message, long l) {
        if(mSmHandler != null)
            mSmHandler.sendMessageDelayed(message, l);
    }

    public void setDbg(boolean flag) {
        if(mSmHandler != null)
            mSmHandler.setDbg(flag);
    }

    protected final void setInitialState(State state) {
        mSmHandler.setInitialState(state);
    }

    public final void setProcessedMessagesSize(int i) {
        mSmHandler.setProcessedMessagesSize(i);
    }

    public void start() {
        if(mSmHandler != null)
            mSmHandler.completeConstruction();
    }

    protected final void transitionTo(IState istate) {
        mSmHandler.transitionTo(istate);
    }

    protected final void transitionToHaltingState() {
        mSmHandler.transitionTo(mSmHandler.mHaltingState);
    }

    protected void unhandledMessage(Message message) {
        if(mSmHandler.mDbg)
            Log.e("StateMachine", (new StringBuilder()).append(mName).append(" - unhandledMessage: msg.what=").append(message.what).toString());
    }

    public static final boolean HANDLED = true;
    public static final boolean NOT_HANDLED = false;
    public static final int SM_INIT_CMD = -2;
    public static final int SM_QUIT_CMD = -1;
    private static final String TAG = "StateMachine";
    private String mName;
    private SmHandler mSmHandler;
    private HandlerThread mSmThread;



/*
    static HandlerThread access$402(StateMachine statemachine, HandlerThread handlerthread) {
        statemachine.mSmThread = handlerthread;
        return handlerthread;
    }

*/


/*
    static SmHandler access$502(StateMachine statemachine, SmHandler smhandler) {
        statemachine.mSmHandler = smhandler;
        return smhandler;
    }

*/
}
