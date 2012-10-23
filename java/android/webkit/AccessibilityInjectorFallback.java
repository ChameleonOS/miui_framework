// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.*;

// Referenced classes of package android.webkit:
//            WebViewClassic, WebView, WebViewCore

class AccessibilityInjectorFallback {
    private static final class AccessibilityWebContentKeyBinding {

        public int getAction(int i) {
            return mActionSequence[i];
        }

        public int getActionCode(int i) {
            return (0xff000000 & mActionSequence[i]) >> 24;
        }

        public int getActionCount() {
            return mActionSequence.length;
        }

        public int getFirstArgument(int i) {
            return (0xff0000 & mActionSequence[i]) >> 16;
        }

        public int getKeyCode() {
            return (int)((0xffffffffL & mKeyCodeAndModifiers) >> 0);
        }

        public int getModifiers() {
            return (int)((0xfffffff00000000L & mKeyCodeAndModifiers) >> 32);
        }

        public int getSecondArgument(int i) {
            return (0xff00 & mActionSequence[i]) >> 8;
        }

        public int getThirdArgument(int i) {
            return (0xff & mActionSequence[i]) >> 0;
        }

        public String toString() {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("modifiers: ");
            stringbuilder.append(getModifiers());
            stringbuilder.append(", keyCode: ");
            stringbuilder.append(getKeyCode());
            stringbuilder.append(", actions[");
            int i = 0;
            for(int j = getActionCount(); i < j; i++) {
                stringbuilder.append("{actionCode");
                stringbuilder.append(i);
                stringbuilder.append(": ");
                stringbuilder.append(getActionCode(i));
                stringbuilder.append(", firstArgument: ");
                stringbuilder.append(getFirstArgument(i));
                stringbuilder.append(", secondArgument: ");
                stringbuilder.append(getSecondArgument(i));
                stringbuilder.append(", thirdArgument: ");
                stringbuilder.append(getThirdArgument(i));
                stringbuilder.append("}");
            }

            stringbuilder.append("]");
            return stringbuilder.toString();
        }

        private static final int ACTION_MASK = 0xff000000;
        private static final int ACTION_OFFSET = 24;
        private static final int FIRST_ARGUMENT_MASK = 0xff0000;
        private static final int FIRST_ARGUMENT_OFFSET = 16;
        private static final long KEY_CODE_MASK = 0xffffffffL;
        private static final int KEY_CODE_OFFSET = 0;
        private static final long MODIFIERS_MASK = 0xfffffff00000000L;
        private static final int MODIFIERS_OFFSET = 32;
        private static final int SECOND_ARGUMENT_MASK = 65280;
        private static final int SECOND_ARGUMENT_OFFSET = 8;
        private static final int THIRD_ARGUMENT_MASK = 255;
        private static final int THIRD_ARGUMENT_OFFSET;
        private final int mActionSequence[];
        private final long mKeyCodeAndModifiers;

        public AccessibilityWebContentKeyBinding(long l, int ai[]) {
            mKeyCodeAndModifiers = l;
            mActionSequence = ai;
        }
    }


    public AccessibilityInjectorFallback(WebViewClassic webviewclassic) {
        mCurrentAxis = 2;
        mWebView = webviewclassic;
        mWebViewInternal = mWebView.getWebView();
        ensureWebContentKeyBindings();
    }

    private void ensureWebContentKeyBindings() {
        if(sBindings.size() <= 0) {
            String s = android.provider.Settings.Secure.getString(mWebView.getContext().getContentResolver(), "accessibility_web_content_key_bindings");
            android.text.TextUtils.SimpleStringSplitter simplestringsplitter = new android.text.TextUtils.SimpleStringSplitter(';');
            simplestringsplitter.setString(s);
            while(simplestringsplitter.hasNext())  {
                String s1 = simplestringsplitter.next();
                if(TextUtils.isEmpty(s1)) {
                    Log.e("AccessibilityInjector", (new StringBuilder()).append("Disregarding malformed Web content key binding: ").append(s).toString());
                } else {
                    String as[] = s1.split("=");
                    if(as.length != 2)
                        Log.e("AccessibilityInjector", (new StringBuilder()).append("Disregarding malformed Web content key binding: ").append(s1).toString());
                    else
                        try {
                            long l = Long.decode(as[0].trim()).longValue();
                            String as1[] = as[1].split(":");
                            int ai[] = new int[as1.length];
                            int i = 0;
                            for(int j = ai.length; i < j; i++)
                                ai[i] = Integer.decode(as1[i].trim()).intValue();

                            sBindings.add(new AccessibilityWebContentKeyBinding(l, ai));
                        }
                        catch(NumberFormatException numberformatexception) {
                            Log.e("AccessibilityInjector", (new StringBuilder()).append("Disregarding malformed key binding: ").append(s1).toString());
                        }
                }
            }
        }
    }

    private static int getAxisForGranularity(int i) {
        byte byte0 = 2;
        i;
        JVM INSTR lookupswitch 5: default 52
    //                   1: 57
    //                   2: 62
    //                   4: 55
    //                   8: 55
    //                   16: 67;
           goto _L1 _L2 _L3 _L4 _L4 _L5
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        byte0 = -1;
_L7:
        return byte0;
_L2:
        byte0 = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L5:
        byte0 = 6;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private static int getDirectionForAction(int i) {
        i;
        JVM INSTR lookupswitch 4: default 44
    //                   256: 49
    //                   512: 54
    //                   1024: 49
    //                   2048: 54;
           goto _L1 _L2 _L3 _L2 _L3
_L1:
        byte byte0 = -1;
_L5:
        return byte0;
_L2:
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        byte0 = 0;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private AccessibilityEvent getPartialyPopulatedAccessibilityEvent(int i) {
        AccessibilityEvent accessibilityevent = AccessibilityEvent.obtain(i);
        mWebViewInternal.onInitializeAccessibilityEvent(accessibilityevent);
        return accessibilityevent;
    }

    private boolean isEnterActionKey(int i) {
        boolean flag;
        if(i == 23 || i == 66 || i == 160)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void performAxisTransition(int i, int j, boolean flag, String s) {
        if(mCurrentAxis == i)
            setCurrentAxis(j, flag, s);
    }

    private void sendAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        Log.d("AccessibilityInjector", (new StringBuilder()).append("Dispatching: ").append(accessibilityevent).toString());
        AccessibilityManager accessibilitymanager = AccessibilityManager.getInstance(mWebView.getContext());
        if(accessibilitymanager.isEnabled())
            accessibilitymanager.sendAccessibilityEvent(accessibilityevent);
    }

    private void setCurrentAxis(int i, boolean flag, String s) {
        mCurrentAxis = i;
        if(flag) {
            AccessibilityEvent accessibilityevent = getPartialyPopulatedAccessibilityEvent(16384);
            accessibilityevent.getText().add(String.valueOf(i));
            accessibilityevent.setContentDescription(s);
            sendAccessibilityEvent(accessibilityevent);
        }
    }

    private boolean traverseCurrentAxis(int i, boolean flag, String s) {
        return traverseGivenAxis(i, mCurrentAxis, flag, s);
    }

    private boolean traverseGivenAxis(int i, int j, boolean flag, String s) {
        boolean flag1;
        WebViewCore webviewcore;
        flag1 = false;
        webviewcore = mWebView.getWebViewCore();
        if(webviewcore != null) goto _L2; else goto _L1
_L1:
        return flag1;
_L2:
        AccessibilityEvent accessibilityevent = null;
        if(flag) {
            accessibilityevent = getPartialyPopulatedAccessibilityEvent(0x20000);
            accessibilityevent.setContentDescription(s);
        }
        mScheduledEventStack.push(accessibilityevent);
        if(j != 7) {
            webviewcore.sendMessage(190, i, j);
            flag1 = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean onKeyEvent(KeyEvent keyevent) {
        if(!isEnterActionKey(keyevent.getKeyCode())) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L13:
        return flag;
_L2:
        AccessibilityWebContentKeyBinding accessibilitywebcontentkeybinding;
        int i;
        int j;
        if(keyevent.getAction() == 1) {
            flag = mLastDownEventHandled;
            continue; /* Loop/switch isn't completed */
        }
        mLastDownEventHandled = false;
        accessibilitywebcontentkeybinding = null;
        Iterator iterator = sBindings.iterator();
        do {
            if(!iterator.hasNext())
                break;
            AccessibilityWebContentKeyBinding accessibilitywebcontentkeybinding1 = (AccessibilityWebContentKeyBinding)iterator.next();
            if(keyevent.getKeyCode() != accessibilitywebcontentkeybinding1.getKeyCode() || !keyevent.hasModifiers(accessibilitywebcontentkeybinding1.getModifiers()))
                continue;
            accessibilitywebcontentkeybinding = accessibilitywebcontentkeybinding1;
            break;
        } while(true);
        if(accessibilitywebcontentkeybinding == null) {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        i = 0;
        j = accessibilitywebcontentkeybinding.getActionCount();
_L10:
        int k;
        String s;
        if(i >= j)
            break MISSING_BLOCK_LABEL_544;
        k = accessibilitywebcontentkeybinding.getActionCode(i);
        s = Integer.toHexString(accessibilitywebcontentkeybinding.getAction(i));
        k;
        JVM INSTR tableswitch 0 4: default 176
    //                   0 209
    //                   1 254
    //                   2 331
    //                   3 420
    //                   4 475;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_475;
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        Log.w("AccessibilityInjector", (new StringBuilder()).append("Unknown action code: ").append(k).toString());
_L11:
        i++;
        if(true) goto _L10; else goto _L9
_L9:
        int i2 = accessibilitywebcontentkeybinding.getFirstArgument(i);
        boolean flag5;
        if(accessibilitywebcontentkeybinding.getSecondArgument(i) == 1)
            flag5 = true;
        else
            flag5 = false;
        setCurrentAxis(i2, flag5, s);
        mLastDownEventHandled = true;
          goto _L11
_L5:
        int l1 = accessibilitywebcontentkeybinding.getFirstArgument(i);
        if(l1 == mLastDirection && mIsLastSelectionStringNull) {
            mIsLastSelectionStringNull = false;
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        mLastDirection = l1;
        boolean flag4;
        if(accessibilitywebcontentkeybinding.getSecondArgument(i) == 1)
            flag4 = true;
        else
            flag4 = false;
        mLastDownEventHandled = traverseCurrentAxis(l1, flag4, s);
          goto _L11
_L6:
        int j1 = accessibilitywebcontentkeybinding.getFirstArgument(i);
        if(j1 == mLastDirection && mIsLastSelectionStringNull) {
            mIsLastSelectionStringNull = false;
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        mLastDirection = j1;
        int k1 = accessibilitywebcontentkeybinding.getSecondArgument(i);
        boolean flag3;
        if(accessibilitywebcontentkeybinding.getThirdArgument(i) == 1)
            flag3 = true;
        else
            flag3 = false;
        traverseGivenAxis(j1, k1, flag3, s);
        mLastDownEventHandled = true;
          goto _L11
_L7:
        int l = accessibilitywebcontentkeybinding.getFirstArgument(i);
        int i1 = accessibilitywebcontentkeybinding.getSecondArgument(i);
        boolean flag2;
        if(accessibilitywebcontentkeybinding.getThirdArgument(i) == 1)
            flag2 = true;
        else
            flag2 = false;
        performAxisTransition(l, i1, flag2, s);
        mLastDownEventHandled = true;
          goto _L11
        if(mCurrentAxis == 7) {
            mLastDirection = accessibilitywebcontentkeybinding.getFirstArgument(i);
            boolean flag1;
            if(accessibilitywebcontentkeybinding.getSecondArgument(i) == 1)
                flag1 = true;
            else
                flag1 = false;
            traverseGivenAxis(mLastDirection, 7, flag1, s);
            mLastDownEventHandled = false;
        } else {
            mLastDownEventHandled = true;
        }
          goto _L11
        flag = mLastDownEventHandled;
        if(true) goto _L13; else goto _L12
_L12:
    }

    public void onSelectionStringChange(String s) {
        Log.d("AccessibilityInjector", (new StringBuilder()).append("Selection string: ").append(s).toString());
        boolean flag;
        if(s == null)
            flag = true;
        else
            flag = false;
        mIsLastSelectionStringNull = flag;
        if(!mScheduledEventStack.isEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        AccessibilityEvent accessibilityevent = (AccessibilityEvent)mScheduledEventStack.pop();
        if(accessibilityevent != null && s != null) {
            accessibilityevent.getText().add(s);
            accessibilityevent.setFromIndex(0);
            accessibilityevent.setToIndex(s.length());
            sendAccessibilityEvent(accessibilityevent);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    boolean performAccessibilityAction(int i, Bundle bundle) {
        i;
        JVM INSTR lookupswitch 4: default 44
    //                   256: 48
    //                   512: 48
    //                   1024: 72
    //                   2048: 72;
           goto _L1 _L2 _L2 _L3 _L3
_L1:
        boolean flag = false;
_L5:
        return flag;
_L2:
        flag = traverseGivenAxis(getDirectionForAction(i), getAxisForGranularity(bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT")), true, null);
        continue; /* Loop/switch isn't completed */
_L3:
        flag = traverseGivenAxis(getDirectionForAction(i), 2, true, null);
        if(true) goto _L5; else goto _L4
_L4:
    }

    private static final int ACTION_PERFORM_AXIS_TRANSITION = 3;
    private static final int ACTION_SET_CURRENT_AXIS = 0;
    private static final int ACTION_TRAVERSE_CURRENT_AXIS = 1;
    private static final int ACTION_TRAVERSE_DEFAULT_WEB_VIEW_BEHAVIOR_AXIS = 4;
    private static final int ACTION_TRAVERSE_GIVEN_AXIS = 2;
    private static final boolean DEBUG = true;
    private static final String LOG_TAG = "AccessibilityInjector";
    private static final int NAVIGATION_AXIS_CHARACTER = 0;
    private static final int NAVIGATION_AXIS_DEFAULT_WEB_VIEW_BEHAVIOR = 7;
    private static final int NAVIGATION_AXIS_DOCUMENT = 6;
    private static final int NAVIGATION_AXIS_HEADING = 3;
    private static final int NAVIGATION_AXIS_PARENT_FIRST_CHILD = 5;
    private static final int NAVIGATION_AXIS_SENTENCE = 2;
    private static final int NAVIGATION_AXIS_SIBLING = 5;
    private static final int NAVIGATION_AXIS_WORD = 1;
    private static final int NAVIGATION_DIRECTION_BACKWARD = 0;
    private static final int NAVIGATION_DIRECTION_FORWARD = 1;
    private static ArrayList sBindings = new ArrayList();
    private int mCurrentAxis;
    private boolean mIsLastSelectionStringNull;
    private int mLastDirection;
    private boolean mLastDownEventHandled;
    private final Stack mScheduledEventStack = new Stack();
    private final WebViewClassic mWebView;
    private final WebView mWebViewInternal;

}
