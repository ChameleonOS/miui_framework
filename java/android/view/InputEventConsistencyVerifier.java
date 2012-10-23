// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.os.Build;
import android.util.Log;

// Referenced classes of package android.view:
//            InputEvent, MotionEvent, KeyEvent

public final class InputEventConsistencyVerifier {
    private static final class KeyState {

        public static KeyState obtain(int i, int j, int k) {
            Object obj = mRecycledListLock;
            obj;
            JVM INSTR monitorenter ;
            KeyState keystate;
            keystate = mRecycledList;
            if(keystate == null)
                break MISSING_BLOCK_LABEL_53;
            mRecycledList = keystate.next;
_L2:
            keystate.deviceId = i;
            keystate.source = j;
            keystate.keyCode = k;
            keystate.unhandled = false;
            return keystate;
            keystate = new KeyState();
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            throw exception;
        }

        public void recycle() {
            Object obj = mRecycledListLock;
            obj;
            JVM INSTR monitorenter ;
            next = mRecycledList;
            mRecycledList = next;
            return;
        }

        private static KeyState mRecycledList;
        private static Object mRecycledListLock = new Object();
        public int deviceId;
        public int keyCode;
        public KeyState next;
        public int source;
        public boolean unhandled;


        private KeyState() {
        }
    }


    public InputEventConsistencyVerifier(Object obj, int i) {
        this(obj, i, android/view/InputEventConsistencyVerifier.getSimpleName());
    }

    public InputEventConsistencyVerifier(Object obj, int i, String s) {
        mTouchEventStreamDeviceId = -1;
        mCaller = obj;
        mFlags = i;
        if(s == null)
            s = "InputEventConsistencyVerifier";
        mLogTag = s;
    }

    private void addKeyState(int i, int j, int k) {
        KeyState keystate = KeyState.obtain(i, j, k);
        keystate.next = mKeyStateList;
        mKeyStateList = keystate;
    }

    private static void appendEvent(StringBuilder stringbuilder, int i, InputEvent inputevent, boolean flag) {
        stringbuilder.append(i).append(": sent at ").append(inputevent.getEventTimeNano());
        stringbuilder.append(", ");
        if(flag)
            stringbuilder.append("(unhandled) ");
        stringbuilder.append(inputevent);
    }

    private void ensureHistorySizeIsZeroForThisAction(MotionEvent motionevent) {
        int i = motionevent.getHistorySize();
        if(i != 0)
            problem((new StringBuilder()).append("History size is ").append(i).append(" but it should always be 0 for ").append(MotionEvent.actionToString(motionevent.getAction())).toString());
    }

    private void ensureMetaStateIsNormalized(int i) {
        int j = KeyEvent.normalizeMetaState(i);
        if(j != i) {
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(i);
            aobj[1] = Integer.valueOf(j);
            problem(String.format("Metastate not normalized.  Was 0x%08x but expected 0x%08x.", aobj));
        }
    }

    private void ensurePointerCountIsOneForThisAction(MotionEvent motionevent) {
        int i = motionevent.getPointerCount();
        if(i != 1)
            problem((new StringBuilder()).append("Pointer count is ").append(i).append(" but it should always be 1 for ").append(MotionEvent.actionToString(motionevent.getAction())).toString());
    }

    private KeyState findKeyState(int i, int j, int k, boolean flag) {
        KeyState keystate;
        KeyState keystate1;
        keystate = null;
        keystate1 = mKeyStateList;
_L3:
        if(keystate1 == null)
            break MISSING_BLOCK_LABEL_96;
        if(keystate1.deviceId != i || keystate1.source != j || keystate1.keyCode != k) goto _L2; else goto _L1
_L1:
        if(flag) {
            if(keystate != null)
                keystate.next = keystate1.next;
            else
                mKeyStateList = keystate1.next;
            keystate1.next = null;
        }
_L4:
        return keystate1;
_L2:
        keystate = keystate1;
        keystate1 = keystate1.next;
          goto _L3
        keystate1 = null;
          goto _L4
    }

    private void finishEvent() {
        if(mViolationMessage == null || mViolationMessage.length() == 0) goto _L2; else goto _L1
_L1:
        if(mCurrentEvent.isTainted()) goto _L4; else goto _L3
_L3:
        mViolationMessage.append("\n  in ").append(mCaller);
        mViolationMessage.append("\n  ");
        appendEvent(mViolationMessage, 0, mCurrentEvent, false);
        if(mRecentEvents == null) goto _L6; else goto _L5
_L5:
        int j;
        mViolationMessage.append("\n  -- recent events --");
        j = 0;
_L10:
        if(j >= 5) goto _L6; else goto _L7
_L7:
        int k;
        InputEvent inputevent;
        k = ((5 + mMostRecentEventIndex) - j) % 5;
        inputevent = mRecentEvents[k];
        if(inputevent != null) goto _L8; else goto _L6
_L6:
        Log.d(mLogTag, mViolationMessage.toString());
        mCurrentEvent.setTainted(true);
_L4:
        mViolationMessage.setLength(0);
_L2:
        if(mRecentEvents == null) {
            mRecentEvents = new InputEvent[5];
            mRecentEventsUnhandled = new boolean[5];
        }
        int i = (1 + mMostRecentEventIndex) % 5;
        mMostRecentEventIndex = i;
        if(mRecentEvents[i] != null)
            mRecentEvents[i].recycle();
        mRecentEvents[i] = mCurrentEvent.copy();
        mRecentEventsUnhandled[i] = false;
        mCurrentEvent = null;
        mCurrentEventType = null;
        return;
_L8:
        mViolationMessage.append("\n  ");
        appendEvent(mViolationMessage, j + 1, inputevent, mRecentEventsUnhandled[k]);
        j++;
        if(true) goto _L10; else goto _L9
_L9:
    }

    public static boolean isInstrumentationEnabled() {
        return IS_ENG_BUILD;
    }

    private void problem(String s) {
        if(mViolationMessage == null)
            mViolationMessage = new StringBuilder();
        if(mViolationMessage.length() == 0)
            mViolationMessage.append(mCurrentEventType).append(": ");
        else
            mViolationMessage.append("\n  ");
        mViolationMessage.append(s);
    }

    private boolean startEvent(InputEvent inputevent, int i, String s) {
        boolean flag = false;
        int j = inputevent.getSequenceNumber();
        if(j != mLastEventSeq || i >= mLastNestingLevel || s != mLastEventType) {
            if(i > 0) {
                mLastEventSeq = j;
                mLastEventType = s;
                mLastNestingLevel = i;
            } else {
                mLastEventSeq = -1;
                mLastEventType = null;
                mLastNestingLevel = 0;
            }
            mCurrentEvent = inputevent;
            mCurrentEventType = s;
            flag = true;
        }
        return flag;
    }

    public void onGenericMotionEvent(MotionEvent motionevent, int i) {
        if(startEvent(motionevent, i, "GenericMotionEvent")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j;
        int k;
        ensureMetaStateIsNormalized(motionevent.getMetaState());
        j = motionevent.getAction();
        k = motionevent.getSource();
        if((k & 2) == 0) goto _L4; else goto _L3
_L3:
        j;
        JVM INSTR tableswitch 7 10: default 72
    //                   7 106
    //                   8 141
    //                   9 86
    //                   10 114;
           goto _L5 _L6 _L7 _L8 _L9
_L5:
        problem("Invalid action for generic pointer event.");
_L10:
        finishEvent();
          goto _L1
_L8:
        ensurePointerCountIsOneForThisAction(motionevent);
        mHoverEntered = true;
          goto _L10
        Exception exception;
        exception;
        finishEvent();
        throw exception;
_L6:
        ensurePointerCountIsOneForThisAction(motionevent);
          goto _L10
_L9:
        ensurePointerCountIsOneForThisAction(motionevent);
        if(!mHoverEntered)
            problem("ACTION_HOVER_EXIT without prior ACTION_HOVER_ENTER");
        mHoverEntered = false;
          goto _L10
_L7:
        ensureHistorySizeIsZeroForThisAction(motionevent);
        ensurePointerCountIsOneForThisAction(motionevent);
          goto _L10
_L15:
        problem("Invalid action for generic joystick event.");
          goto _L10
_L13:
        ensurePointerCountIsOneForThisAction(motionevent);
          goto _L10
_L4:
        if((k & 0x10) == 0) goto _L10; else goto _L11
_L11:
        j;
        JVM INSTR tableswitch 2 2: default 154
    //                   2 164;
           goto _L12 _L13
_L12:
        if(true) goto _L15; else goto _L14
_L14:
          goto _L10
    }

    public void onInputEvent(InputEvent inputevent, int i) {
        if(inputevent instanceof KeyEvent) {
            onKeyEvent((KeyEvent)inputevent, i);
        } else {
            MotionEvent motionevent = (MotionEvent)inputevent;
            if(motionevent.isTouchEvent())
                onTouchEvent(motionevent, i);
            else
            if((4 & motionevent.getSource()) != 0)
                onTrackballEvent(motionevent, i);
            else
                onGenericMotionEvent(motionevent, i);
        }
    }

    public void onKeyEvent(KeyEvent keyevent, int i) {
        if(startEvent(keyevent, i, "KeyEvent")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k;
        int l;
        int i1;
        ensureMetaStateIsNormalized(keyevent.getMetaState());
        int j = keyevent.getAction();
        k = keyevent.getDeviceId();
        l = keyevent.getSource();
        i1 = keyevent.getKeyCode();
        switch(j) {
        default:
            problem((new StringBuilder()).append("Invalid action ").append(KeyEvent.actionToString(j)).append(" for key event.").toString());
            break;

        case 0: // '\0'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_194;

        case 2: // '\002'
            break;
        }
_L6:
        finishEvent();
        if(true) goto _L1; else goto _L3
_L3:
        KeyState keystate1;
        keystate1 = findKeyState(k, l, i1, false);
        if(keystate1 == null)
            break MISSING_BLOCK_LABEL_181;
        if(!keystate1.unhandled) goto _L5; else goto _L4
_L4:
        keystate1.unhandled = false;
          goto _L6
        Exception exception;
        exception;
        finishEvent();
        throw exception;
_L5:
        if((1 & mFlags) != 0 || keyevent.getRepeatCount() != 0) goto _L6; else goto _L7
_L7:
        problem("ACTION_DOWN but key is already down and this event is not a key repeat.");
          goto _L6
        addKeyState(k, l, i1);
          goto _L6
        KeyState keystate = findKeyState(k, l, i1, true);
        if(keystate == null)
            problem("ACTION_UP but key was not down.");
        else
            keystate.recycle();
          goto _L6
    }

    public void onTouchEvent(MotionEvent motionevent, int i) {
        if(startEvent(motionevent, i, "TouchEvent")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j;
        int i1;
        int k1;
        int l1;
        j = motionevent.getAction();
        boolean flag;
        int k;
        int l;
        if(j == 0 || j == 3)
            flag = true;
        else
            flag = false;
        if(flag && (mTouchEventStreamIsTainted || mTouchEventStreamUnhandled)) {
            mTouchEventStreamIsTainted = false;
            mTouchEventStreamUnhandled = false;
            mTouchEventStreamPointers = 0;
        }
        if(mTouchEventStreamIsTainted)
            motionevent.setTainted(true);
        ensureMetaStateIsNormalized(motionevent.getMetaState());
        k = motionevent.getDeviceId();
        l = motionevent.getSource();
        if(!flag && mTouchEventStreamDeviceId != -1 && (mTouchEventStreamDeviceId != k || mTouchEventStreamSource != l))
            problem((new StringBuilder()).append("Touch event stream contains events from multiple sources: previous device id ").append(mTouchEventStreamDeviceId).append(", previous source ").append(Integer.toHexString(mTouchEventStreamSource)).append(", new device id ").append(k).append(", new source ").append(Integer.toHexString(l)).toString());
        mTouchEventStreamDeviceId = k;
        mTouchEventStreamSource = l;
        i1 = motionevent.getPointerCount();
        if((l & 2) == 0) goto _L4; else goto _L3
_L3:
        j;
        JVM INSTR tableswitch 0 4: default 256
    //                   0 361
    //                   1 408
    //                   2 431
    //                   3 497
    //                   4 510;
           goto _L5 _L6 _L7 _L8 _L9 _L10
_L5:
        k1 = motionevent.getActionMasked();
        l1 = motionevent.getActionIndex();
        if(k1 != 5) goto _L12; else goto _L11
_L11:
        if(mTouchEventStreamPointers == 0) {
            problem("ACTION_POINTER_DOWN but no other pointers were down.");
            mTouchEventStreamIsTainted = true;
        }
          goto _L13
_L17:
        problem((new StringBuilder()).append("ACTION_POINTER_DOWN index is ").append(l1).append(" but the pointer count is ").append(i1).append(".").toString());
        mTouchEventStreamIsTainted = true;
_L15:
        ensureHistorySizeIsZeroForThisAction(motionevent);
_L14:
        finishEvent();
          goto _L1
_L6:
        if(mTouchEventStreamPointers != 0)
            problem("ACTION_DOWN but pointers are already down.  Probably missing ACTION_UP from previous gesture.");
        ensureHistorySizeIsZeroForThisAction(motionevent);
        ensurePointerCountIsOneForThisAction(motionevent);
        mTouchEventStreamPointers = 1 << motionevent.getPointerId(0);
          goto _L14
        Exception exception;
        exception;
        finishEvent();
        throw exception;
_L7:
        ensureHistorySizeIsZeroForThisAction(motionevent);
        ensurePointerCountIsOneForThisAction(motionevent);
        mTouchEventStreamPointers = 0;
        mTouchEventStreamIsTainted = false;
          goto _L14
_L8:
        int j1 = Integer.bitCount(mTouchEventStreamPointers);
        if(i1 != j1) {
            problem((new StringBuilder()).append("ACTION_MOVE contained ").append(i1).append(" pointers but there are currently ").append(j1).append(" pointers down.").toString());
            mTouchEventStreamIsTainted = true;
        }
          goto _L14
_L9:
        mTouchEventStreamPointers = 0;
        mTouchEventStreamIsTainted = false;
          goto _L14
_L10:
        if(mTouchEventStreamPointers != 0)
            problem("ACTION_OUTSIDE but pointers are still down.");
        ensureHistorySizeIsZeroForThisAction(motionevent);
        ensurePointerCountIsOneForThisAction(motionevent);
        mTouchEventStreamIsTainted = false;
          goto _L14
_L18:
        int k2 = motionevent.getPointerId(l1);
        int l2 = 1 << k2;
        if((l2 & mTouchEventStreamPointers) != 0) {
            problem((new StringBuilder()).append("ACTION_POINTER_DOWN specified pointer id ").append(k2).append(" which is already down.").toString());
            mTouchEventStreamIsTainted = true;
        } else {
            mTouchEventStreamPointers = l2 | mTouchEventStreamPointers;
        }
          goto _L15
_L21:
        problem((new StringBuilder()).append("ACTION_POINTER_UP index is ").append(l1).append(" but the pointer count is ").append(i1).append(".").toString());
        mTouchEventStreamIsTainted = true;
_L16:
        ensureHistorySizeIsZeroForThisAction(motionevent);
          goto _L14
_L22:
        int i2 = motionevent.getPointerId(l1);
        int j2 = 1 << i2;
        if((j2 & mTouchEventStreamPointers) == 0) {
            problem((new StringBuilder()).append("ACTION_POINTER_UP specified pointer id ").append(i2).append(" which is not currently down.").toString());
            mTouchEventStreamIsTainted = true;
        } else {
            mTouchEventStreamPointers = mTouchEventStreamPointers & ~j2;
        }
          goto _L16
_L20:
        problem((new StringBuilder()).append("Invalid action ").append(MotionEvent.actionToString(j)).append(" for touch event.").toString());
          goto _L14
_L4:
        problem("Source was not SOURCE_CLASS_POINTER.");
          goto _L14
_L13:
        if(l1 >= 0 && l1 < i1) goto _L18; else goto _L17
_L12:
        if(k1 != 6) goto _L20; else goto _L19
_L19:
        if(l1 >= 0 && l1 < i1) goto _L22; else goto _L21
    }

    public void onTrackballEvent(MotionEvent motionevent, int i) {
        if(startEvent(motionevent, i, "TrackballEvent")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j;
        ensureMetaStateIsNormalized(motionevent.getMetaState());
        j = motionevent.getAction();
        if((4 & motionevent.getSource()) == 0) goto _L4; else goto _L3
_L3:
        j;
        JVM INSTR tableswitch 0 2: default 64
    //                   0 128
    //                   1 182
    //                   2 222;
           goto _L5 _L6 _L7 _L8
_L5:
        problem((new StringBuilder()).append("Invalid action ").append(MotionEvent.actionToString(j)).append(" for trackball event.").toString());
_L13:
        if(!mTrackballDown || motionevent.getPressure() > 0.0F) goto _L10; else goto _L9
_L9:
        problem("Trackball is down but pressure is not greater than 0.");
_L15:
        finishEvent();
          goto _L1
_L6:
        if(!mTrackballDown || mTrackballUnhandled) goto _L12; else goto _L11
_L11:
        problem("ACTION_DOWN but trackball is already down.");
_L14:
        ensureHistorySizeIsZeroForThisAction(motionevent);
        ensurePointerCountIsOneForThisAction(motionevent);
          goto _L13
        Exception exception;
        exception;
        finishEvent();
        throw exception;
_L12:
        mTrackballDown = true;
        mTrackballUnhandled = false;
          goto _L14
_L7:
        if(!mTrackballDown) {
            problem("ACTION_UP but trackball is not down.");
        } else {
            mTrackballDown = false;
            mTrackballUnhandled = false;
        }
        ensureHistorySizeIsZeroForThisAction(motionevent);
        ensurePointerCountIsOneForThisAction(motionevent);
          goto _L13
_L8:
        ensurePointerCountIsOneForThisAction(motionevent);
          goto _L13
_L10:
        if(!mTrackballDown && motionevent.getPressure() != 0.0F)
            problem("Trackball is up but pressure is not equal to 0.");
          goto _L15
_L4:
        problem("Source was not SOURCE_CLASS_TRACKBALL.");
          goto _L15
    }

    public void onUnhandledEvent(InputEvent inputevent, int i) {
        if(i == mLastNestingLevel) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(mRecentEventsUnhandled != null)
            mRecentEventsUnhandled[mMostRecentEventIndex] = true;
        if(inputevent instanceof KeyEvent) {
            KeyEvent keyevent = (KeyEvent)inputevent;
            KeyState keystate = findKeyState(keyevent.getDeviceId(), keyevent.getSource(), keyevent.getKeyCode(), false);
            if(keystate != null)
                keystate.unhandled = true;
        } else {
            MotionEvent motionevent = (MotionEvent)inputevent;
            if(motionevent.isTouchEvent())
                mTouchEventStreamUnhandled = true;
            else
            if((4 & motionevent.getSource()) != 0 && mTrackballDown)
                mTrackballUnhandled = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void reset() {
        mLastEventSeq = -1;
        mLastNestingLevel = 0;
        mTrackballDown = false;
        mTrackballUnhandled = false;
        mTouchEventStreamPointers = 0;
        mTouchEventStreamIsTainted = false;
        mTouchEventStreamUnhandled = false;
        mHoverEntered = false;
        while(mKeyStateList != null)  {
            KeyState keystate = mKeyStateList;
            mKeyStateList = keystate.next;
            keystate.recycle();
        }
    }

    private static final String EVENT_TYPE_GENERIC_MOTION = "GenericMotionEvent";
    private static final String EVENT_TYPE_KEY = "KeyEvent";
    private static final String EVENT_TYPE_TOUCH = "TouchEvent";
    private static final String EVENT_TYPE_TRACKBALL = "TrackballEvent";
    public static final int FLAG_RAW_DEVICE_INPUT = 1;
    private static final boolean IS_ENG_BUILD = false;
    private static final int RECENT_EVENTS_TO_LOG = 5;
    private final Object mCaller;
    private InputEvent mCurrentEvent;
    private String mCurrentEventType;
    private final int mFlags;
    private boolean mHoverEntered;
    private KeyState mKeyStateList;
    private int mLastEventSeq;
    private String mLastEventType;
    private int mLastNestingLevel;
    private final String mLogTag;
    private int mMostRecentEventIndex;
    private InputEvent mRecentEvents[];
    private boolean mRecentEventsUnhandled[];
    private int mTouchEventStreamDeviceId;
    private boolean mTouchEventStreamIsTainted;
    private int mTouchEventStreamPointers;
    private int mTouchEventStreamSource;
    private boolean mTouchEventStreamUnhandled;
    private boolean mTrackballDown;
    private boolean mTrackballUnhandled;
    private StringBuilder mViolationMessage;

    static  {
        IS_ENG_BUILD = "eng".equals(Build.TYPE);
    }
}
