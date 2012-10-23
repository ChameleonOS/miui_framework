// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.hardware.input.InputManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AndroidRuntimeException;
import android.util.SparseIntArray;
import java.text.Normalizer;

// Referenced classes of package android.view:
//            InputDevice, KeyEvent

public class KeyCharacterMap
    implements Parcelable {
    public static final class FallbackAction {

        public static FallbackAction obtain() {
            Object obj = sRecycleLock;
            obj;
            JVM INSTR monitorenter ;
            FallbackAction fallbackaction;
            if(sRecycleBin == null) {
                fallbackaction = new FallbackAction();
            } else {
                fallbackaction = sRecycleBin;
                sRecycleBin = fallbackaction.next;
                sRecycledCount = -1 + sRecycledCount;
                fallbackaction.next = null;
            }
            return fallbackaction;
        }

        public void recycle() {
            Object obj = sRecycleLock;
            obj;
            JVM INSTR monitorenter ;
            if(sRecycledCount < 10) {
                next = sRecycleBin;
                sRecycleBin = this;
                sRecycledCount = 1 + sRecycledCount;
            } else {
                next = null;
            }
            return;
        }

        private static final int MAX_RECYCLED = 10;
        private static FallbackAction sRecycleBin;
        private static final Object sRecycleLock = new Object();
        private static int sRecycledCount;
        public int keyCode;
        public int metaState;
        private FallbackAction next;


        private FallbackAction() {
        }
    }

    public static class UnavailableException extends AndroidRuntimeException {

        public UnavailableException(String s) {
            super(s);
        }
    }

    public static class KeyData {

        public static final int META_LENGTH = 4;
        public char displayLabel;
        public char meta[];
        public char number;

        public KeyData() {
            meta = new char[4];
        }
    }


    private KeyCharacterMap(int i) {
        mPtr = i;
    }

    private KeyCharacterMap(Parcel parcel) {
        if(parcel == null)
            throw new IllegalArgumentException("parcel must not be null");
        mPtr = nativeReadFromParcel(parcel);
        if(mPtr == 0)
            throw new RuntimeException("Could not read KeyCharacterMap from parcel.");
        else
            return;
    }


    private static void addCombining(int i, int j) {
        sCombiningToAccent.append(i, j);
        sAccentToCombining.append(j, i);
    }

    private static void addDeadKey(int i, int j, int k) {
        int l = sAccentToCombining.get(i);
        if(l == 0) {
            throw new IllegalStateException("Invalid dead key declaration.");
        } else {
            int i1 = j | l << 16;
            sDeadKeyCache.put(i1, k);
            return;
        }
    }

    public static boolean deviceHasKey(int i) {
        InputManager inputmanager = InputManager.getInstance();
        int ai[] = new int[1];
        ai[0] = i;
        return inputmanager.deviceHasKeys(ai)[0];
    }

    public static boolean[] deviceHasKeys(int ai[]) {
        return InputManager.getInstance().deviceHasKeys(ai);
    }

    public static int getDeadChar(int i, int j) {
        int k = sAccentToCombining.get(i);
        if(k != 0) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L4:
        return i1;
_L2:
        int l = j | k << 16;
        SparseIntArray sparseintarray = sDeadKeyCache;
        sparseintarray;
        JVM INSTR monitorenter ;
        i1 = sDeadKeyCache.get(l, -1);
        if(i1 == -1) {
            sDeadKeyBuilder.setLength(0);
            sDeadKeyBuilder.append((char)j);
            sDeadKeyBuilder.append((char)k);
            String s = Normalizer.normalize(sDeadKeyBuilder, java.text.Normalizer.Form.NFC);
            if(s.length() == 1)
                i1 = s.charAt(0);
            else
                i1 = 0;
            sDeadKeyCache.put(l, i1);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static KeyCharacterMap load(int i) {
        InputManager inputmanager = InputManager.getInstance();
        InputDevice inputdevice = inputmanager.getInputDevice(i);
        if(inputdevice == null) {
            inputdevice = inputmanager.getInputDevice(-1);
            if(inputdevice == null)
                throw new UnavailableException((new StringBuilder()).append("Could not load key character map for device ").append(i).toString());
        }
        return inputdevice.getKeyCharacterMap();
    }

    private static native void nativeDispose(int i);

    private static native char nativeGetCharacter(int i, int j, int k);

    private static native char nativeGetDisplayLabel(int i, int j);

    private static native KeyEvent[] nativeGetEvents(int i, char ac[]);

    private static native boolean nativeGetFallbackAction(int i, int j, int k, FallbackAction fallbackaction);

    private static native int nativeGetKeyboardType(int i);

    private static native char nativeGetMatch(int i, int j, char ac[], int k);

    private static native char nativeGetNumber(int i, int j);

    private static native int nativeReadFromParcel(Parcel parcel);

    private static native void nativeWriteToParcel(int i, Parcel parcel);

    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        if(mPtr != 0) {
            nativeDispose(mPtr);
            mPtr = 0;
        }
    }

    public int get(int i, int j) {
        int k = KeyEvent.normalizeMetaState(j);
        int l = nativeGetCharacter(mPtr, i, k);
        int i1 = sCombiningToAccent.get(l);
        if(i1 != 0)
            l = i1 | 0x80000000;
        return l;
    }

    public char getDisplayLabel(int i) {
        return nativeGetDisplayLabel(mPtr, i);
    }

    public KeyEvent[] getEvents(char ac[]) {
        if(ac == null)
            throw new IllegalArgumentException("chars must not be null.");
        else
            return nativeGetEvents(mPtr, ac);
    }

    public FallbackAction getFallbackAction(int i, int j) {
        FallbackAction fallbackaction = FallbackAction.obtain();
        int k = KeyEvent.normalizeMetaState(j);
        if(nativeGetFallbackAction(mPtr, i, k, fallbackaction)) {
            fallbackaction.metaState = KeyEvent.normalizeMetaState(fallbackaction.metaState);
        } else {
            fallbackaction.recycle();
            fallbackaction = null;
        }
        return fallbackaction;
    }

    public boolean getKeyData(int i, KeyData keydata) {
        boolean flag = false;
        if(keydata.meta.length < 4)
            throw new IndexOutOfBoundsException("results.meta.length must be >= 4");
        char c = nativeGetDisplayLabel(mPtr, i);
        if(c != 0) {
            keydata.displayLabel = c;
            keydata.number = nativeGetNumber(mPtr, i);
            keydata.meta[flag] = nativeGetCharacter(mPtr, i, 0);
            keydata.meta[1] = nativeGetCharacter(mPtr, i, 1);
            keydata.meta[2] = nativeGetCharacter(mPtr, i, 2);
            keydata.meta[3] = nativeGetCharacter(mPtr, i, 3);
            flag = true;
        }
        return flag;
    }

    public int getKeyboardType() {
        return nativeGetKeyboardType(mPtr);
    }

    public char getMatch(int i, char ac[]) {
        return getMatch(i, ac, 0);
    }

    public char getMatch(int i, char ac[], int j) {
        if(ac == null) {
            throw new IllegalArgumentException("chars must not be null.");
        } else {
            int k = KeyEvent.normalizeMetaState(j);
            return nativeGetMatch(mPtr, i, ac, k);
        }
    }

    public int getModifierBehavior() {
        getKeyboardType();
        JVM INSTR tableswitch 4 5: default 28
    //                   4 32
    //                   5 32;
           goto _L1 _L2 _L2
_L1:
        int i = 1;
_L4:
        return i;
_L2:
        i = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public char getNumber(int i) {
        return nativeGetNumber(mPtr, i);
    }

    public boolean isPrintingKey(int i) {
        Character.getType(nativeGetDisplayLabel(mPtr, i));
        JVM INSTR tableswitch 12 16: default 44
    //                   12 48
    //                   13 48
    //                   14 48
    //                   15 48
    //                   16 48;
           goto _L1 _L2 _L2 _L2 _L2 _L2
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void writeToParcel(Parcel parcel, int i) {
        if(parcel == null) {
            throw new IllegalArgumentException("parcel must not be null");
        } else {
            nativeWriteToParcel(mPtr, parcel);
            return;
        }
    }

    private static final int ACCENT_ACUTE = 180;
    private static final int ACCENT_BREVE = 728;
    private static final int ACCENT_CARON = 711;
    private static final int ACCENT_CEDILLA = 184;
    private static final int ACCENT_CIRCUMFLEX = 710;
    private static final int ACCENT_CIRCUMFLEX_LEGACY = 94;
    private static final int ACCENT_COMMA_ABOVE = 8125;
    private static final int ACCENT_COMMA_ABOVE_RIGHT = 700;
    private static final int ACCENT_DOT_ABOVE = 729;
    private static final int ACCENT_DOT_BELOW = 46;
    private static final int ACCENT_DOUBLE_ACUTE = 733;
    private static final int ACCENT_GRAVE = 715;
    private static final int ACCENT_GRAVE_LEGACY = 96;
    private static final int ACCENT_HOOK_ABOVE = 704;
    private static final int ACCENT_HORN = 39;
    private static final int ACCENT_MACRON = 175;
    private static final int ACCENT_MACRON_BELOW = 717;
    private static final int ACCENT_OGONEK = 731;
    private static final int ACCENT_REVERSED_COMMA_ABOVE = 701;
    private static final int ACCENT_RING_ABOVE = 730;
    private static final int ACCENT_STROKE = 45;
    private static final int ACCENT_TILDE = 732;
    private static final int ACCENT_TILDE_LEGACY = 126;
    private static final int ACCENT_TURNED_COMMA_ABOVE = 699;
    private static final int ACCENT_UMLAUT = 168;
    private static final int ACCENT_VERTICAL_LINE_ABOVE = 712;
    private static final int ACCENT_VERTICAL_LINE_BELOW = 716;
    public static final int ALPHA = 3;
    public static final int BUILT_IN_KEYBOARD = 0;
    public static final int COMBINING_ACCENT = 0x80000000;
    public static final int COMBINING_ACCENT_MASK = 0x7fffffff;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public KeyCharacterMap createFromParcel(Parcel parcel) {
            return new KeyCharacterMap(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public KeyCharacterMap[] newArray(int i) {
            return new KeyCharacterMap[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int FULL = 4;
    public static final char HEX_INPUT = 61184;
    public static final int MODIFIER_BEHAVIOR_CHORDED = 0;
    public static final int MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED = 1;
    public static final int NUMERIC = 1;
    public static final char PICKER_DIALOG_INPUT = 61185;
    public static final int PREDICTIVE = 2;
    public static final int SPECIAL_FUNCTION = 5;
    public static final int VIRTUAL_KEYBOARD = -1;
    private static final SparseIntArray sAccentToCombining;
    private static final SparseIntArray sCombiningToAccent;
    private static final StringBuilder sDeadKeyBuilder = new StringBuilder();
    private static final SparseIntArray sDeadKeyCache = new SparseIntArray();
    private int mPtr;

    static  {
        sCombiningToAccent = new SparseIntArray();
        sAccentToCombining = new SparseIntArray();
        addCombining(768, 715);
        addCombining(769, 180);
        addCombining(770, 710);
        addCombining(771, 732);
        addCombining(772, 175);
        addCombining(774, 728);
        addCombining(775, 729);
        addCombining(776, 168);
        addCombining(777, 704);
        addCombining(778, 730);
        addCombining(779, 733);
        addCombining(780, 711);
        addCombining(781, 712);
        addCombining(786, 699);
        addCombining(787, 8125);
        addCombining(788, 701);
        addCombining(789, 700);
        addCombining(795, 39);
        addCombining(803, 46);
        addCombining(807, 184);
        addCombining(808, 731);
        addCombining(809, 716);
        addCombining(817, 717);
        addCombining(821, 45);
        sCombiningToAccent.append(832, 715);
        sCombiningToAccent.append(833, 180);
        sCombiningToAccent.append(835, 8125);
        sAccentToCombining.append(96, 768);
        sAccentToCombining.append(94, 770);
        sAccentToCombining.append(126, 771);
        addDeadKey(45, 68, 272);
        addDeadKey(45, 71, 484);
        addDeadKey(45, 72, 294);
        addDeadKey(45, 73, 407);
        addDeadKey(45, 76, 321);
        addDeadKey(45, 79, 216);
        addDeadKey(45, 84, 358);
        addDeadKey(45, 100, 273);
        addDeadKey(45, 103, 485);
        addDeadKey(45, 104, 295);
        addDeadKey(45, 105, 616);
        addDeadKey(45, 108, 322);
        addDeadKey(45, 111, 248);
        addDeadKey(45, 116, 359);
    }
}
