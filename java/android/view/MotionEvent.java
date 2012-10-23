// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

// Referenced classes of package android.view:
//            InputEvent, KeyEvent

public final class MotionEvent extends InputEvent
    implements Parcelable {
    public static final class PointerProperties {

        public static PointerProperties[] createArray(int i) {
            PointerProperties apointerproperties[] = new PointerProperties[i];
            for(int j = 0; j < i; j++)
                apointerproperties[j] = new PointerProperties();

            return apointerproperties;
        }

        private boolean equals(PointerProperties pointerproperties) {
            boolean flag;
            if(pointerproperties != null && id == pointerproperties.id && toolType == pointerproperties.toolType)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void clear() {
            id = -1;
            toolType = 0;
        }

        public void copyFrom(PointerProperties pointerproperties) {
            id = pointerproperties.id;
            toolType = pointerproperties.toolType;
        }

        public boolean equals(Object obj) {
            boolean flag;
            if(obj instanceof PointerProperties)
                flag = equals((PointerProperties)obj);
            else
                flag = false;
            return flag;
        }

        public int hashCode() {
            return id | toolType << 8;
        }

        public int id;
        public int toolType;


        public PointerProperties() {
            clear();
        }

        public PointerProperties(PointerProperties pointerproperties) {
            copyFrom(pointerproperties);
        }
    }

    public static final class PointerCoords {

        public static PointerCoords[] createArray(int i) {
            PointerCoords apointercoords[] = new PointerCoords[i];
            for(int j = 0; j < i; j++)
                apointercoords[j] = new PointerCoords();

            return apointercoords;
        }

        public void clear() {
            mPackedAxisBits = 0L;
            x = 0.0F;
            y = 0.0F;
            pressure = 0.0F;
            size = 0.0F;
            touchMajor = 0.0F;
            touchMinor = 0.0F;
            toolMajor = 0.0F;
            toolMinor = 0.0F;
            orientation = 0.0F;
        }

        public void copyFrom(PointerCoords pointercoords) {
            long l = pointercoords.mPackedAxisBits;
            mPackedAxisBits = l;
            if(l != 0L) {
                float af[] = pointercoords.mPackedAxisValues;
                int i = Long.bitCount(l);
                float af1[] = mPackedAxisValues;
                if(af1 == null || i > af1.length) {
                    af1 = new float[af.length];
                    mPackedAxisValues = af1;
                }
                System.arraycopy(af, 0, af1, 0, i);
            }
            x = pointercoords.x;
            y = pointercoords.y;
            pressure = pointercoords.pressure;
            size = pointercoords.size;
            touchMajor = pointercoords.touchMajor;
            touchMinor = pointercoords.touchMinor;
            toolMajor = pointercoords.toolMajor;
            toolMinor = pointercoords.toolMinor;
            orientation = pointercoords.orientation;
        }

        public float getAxisValue(int i) {
            i;
            JVM INSTR tableswitch 0 8: default 52
        //                       0 72
        //                       1 79
        //                       2 87
        //                       3 95
        //                       4 103
        //                       5 111
        //                       6 119
        //                       7 127
        //                       8 135;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
            float f;
            if(i < 0 || i > 63)
                throw new IllegalArgumentException("Axis out of range.");
            long l = mPackedAxisBits;
            long l1 = 1L << i;
            if((l & l1) == 0L) {
                f = 0.0F;
            } else {
                int j = Long.bitCount(l & l1 - 1L);
                f = mPackedAxisValues[j];
            }
              goto _L11
_L2:
            f = x;
_L13:
            return f;
_L3:
            f = y;
            continue; /* Loop/switch isn't completed */
_L4:
            f = pressure;
            continue; /* Loop/switch isn't completed */
_L5:
            f = size;
            continue; /* Loop/switch isn't completed */
_L6:
            f = touchMajor;
            continue; /* Loop/switch isn't completed */
_L7:
            f = touchMinor;
            continue; /* Loop/switch isn't completed */
_L8:
            f = toolMajor;
            continue; /* Loop/switch isn't completed */
_L9:
            f = toolMinor;
            continue; /* Loop/switch isn't completed */
_L10:
            f = orientation;
            continue; /* Loop/switch isn't completed */
_L11:
            if(true) goto _L13; else goto _L12
_L12:
        }

        public void setAxisValue(int i, float f) {
            i;
            JVM INSTR tableswitch 0 8: default 52
        //                       0 72
        //                       1 78
        //                       2 86
        //                       3 94
        //                       4 102
        //                       5 110
        //                       6 118
        //                       7 126
        //                       8 134;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
            if(i < 0 || i > 63)
                throw new IllegalArgumentException("Axis out of range.");
            long l = mPackedAxisBits;
            long l1 = 1L << i;
            int j = Long.bitCount(l & l1 - 1L);
            float af[] = mPackedAxisValues;
            if((l & l1) == 0L) {
                if(af == null) {
                    af = new float[8];
                    mPackedAxisValues = af;
                } else {
                    int k = Long.bitCount(l);
                    if(k < af.length) {
                        if(j != k)
                            System.arraycopy(af, j, af, j + 1, k - j);
                    } else {
                        float af1[] = new float[k * 2];
                        System.arraycopy(af, 0, af1, 0, j);
                        System.arraycopy(af, j, af1, j + 1, k - j);
                        af = af1;
                        mPackedAxisValues = af;
                    }
                }
                mPackedAxisBits = l | l1;
            }
            af[j] = f;
              goto _L11
_L2:
            x = f;
_L13:
            return;
_L3:
            y = f;
            continue; /* Loop/switch isn't completed */
_L4:
            pressure = f;
            continue; /* Loop/switch isn't completed */
_L5:
            size = f;
            continue; /* Loop/switch isn't completed */
_L6:
            touchMajor = f;
            continue; /* Loop/switch isn't completed */
_L7:
            touchMinor = f;
            continue; /* Loop/switch isn't completed */
_L8:
            toolMajor = f;
            continue; /* Loop/switch isn't completed */
_L9:
            toolMinor = f;
            continue; /* Loop/switch isn't completed */
_L10:
            orientation = f;
            continue; /* Loop/switch isn't completed */
_L11:
            if(true) goto _L13; else goto _L12
_L12:
        }

        private static final int INITIAL_PACKED_AXIS_VALUES = 8;
        private long mPackedAxisBits;
        private float mPackedAxisValues[];
        public float orientation;
        public float pressure;
        public float size;
        public float toolMajor;
        public float toolMinor;
        public float touchMajor;
        public float touchMinor;
        public float x;
        public float y;

        public PointerCoords() {
        }

        public PointerCoords(PointerCoords pointercoords) {
            copyFrom(pointercoords);
        }
    }


    private MotionEvent() {
    }

    public static String actionToString(int i) {
        i;
        JVM INSTR tableswitch 0 10: default 60
    //                   0 103
    //                   1 110
    //                   2 131
    //                   3 117
    //                   4 124
    //                   5 60
    //                   6 60
    //                   7 138
    //                   8 145
    //                   9 152
    //                   10 159;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L1 _L1 _L7 _L8 _L9 _L10
_L1:
        int j = (0xff00 & i) >> 8;
        i & 0xff;
        JVM INSTR tableswitch 5 6: default 96
    //                   5 166
    //                   6 196;
           goto _L11 _L12 _L13
_L11:
        String s = Integer.toString(i);
_L15:
        return s;
_L2:
        s = "ACTION_DOWN";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "ACTION_UP";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "ACTION_CANCEL";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "ACTION_OUTSIDE";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "ACTION_MOVE";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "ACTION_HOVER_MOVE";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "ACTION_SCROLL";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "ACTION_HOVER_ENTER";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "ACTION_HOVER_EXIT";
        continue; /* Loop/switch isn't completed */
_L12:
        s = (new StringBuilder()).append("ACTION_POINTER_DOWN(").append(j).append(")").toString();
        continue; /* Loop/switch isn't completed */
_L13:
        s = (new StringBuilder()).append("ACTION_POINTER_UP(").append(j).append(")").toString();
        if(true) goto _L15; else goto _L14
_L14:
    }

    public static int axisFromString(String s) {
        int i;
        int j;
        if(s == null)
            throw new IllegalArgumentException("symbolicName must not be null");
        i = AXIS_SYMBOLIC_NAMES.size();
        j = 0;
_L5:
        if(j >= i) goto _L2; else goto _L1
_L1:
        if(!s.equals(AXIS_SYMBOLIC_NAMES.valueAt(j))) goto _L4; else goto _L3
_L3:
        return j;
_L4:
        j++;
          goto _L5
_L2:
        int k = Integer.parseInt(s, 10);
        j = k;
          goto _L3
        NumberFormatException numberformatexception;
        numberformatexception;
        j = -1;
          goto _L3
    }

    public static String axisToString(int i) {
        String s = (String)AXIS_SYMBOLIC_NAMES.get(i);
        if(s == null)
            s = Integer.toString(i);
        return s;
    }

    public static String buttonStateToString(int i) {
        if(i != 0) goto _L2; else goto _L1
_L1:
        String s = "0";
_L4:
        return s;
_L2:
        StringBuilder stringbuilder = null;
        int j = 0;
        while(i != 0)  {
            boolean flag;
            if((i & 1) != 0)
                flag = true;
            else
                flag = false;
            i >>>= 1;
            if(flag) {
                s = BUTTON_SYMBOLIC_NAMES[j];
                if(stringbuilder == null) {
                    if(i == 0)
                        continue; /* Loop/switch isn't completed */
                    stringbuilder = new StringBuilder(s);
                } else {
                    stringbuilder.append('|');
                    stringbuilder.append(s);
                }
            }
            j++;
        }
        s = stringbuilder.toString();
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final float clamp(float f, float f1, float f2) {
        if(f >= f1)
            if(f > f2)
                f1 = f2;
            else
                f1 = f;
        return f1;
    }

    public static MotionEvent createFromParcelBody(Parcel parcel) {
        MotionEvent motionevent = obtain();
        motionevent.mNativePtr = nativeReadFromParcel(motionevent.mNativePtr, parcel);
        return motionevent;
    }

    private static final void ensureSharedTempPointerCapacity(int i) {
        if(gSharedTempPointerCoords == null || gSharedTempPointerCoords.length < i) {
            int j;
            if(gSharedTempPointerCoords != null)
                j = gSharedTempPointerCoords.length;
            else
                j = 8;
            for(; j < i; j *= 2);
            gSharedTempPointerCoords = PointerCoords.createArray(j);
            gSharedTempPointerProperties = PointerProperties.createArray(j);
            gSharedTempPointerIndexMap = new int[j];
        }
    }

    private static native void nativeAddBatch(int i, long l, PointerCoords apointercoords[], int j);

    private static native int nativeCopy(int i, int j, boolean flag);

    private static native void nativeDispose(int i);

    private static native int nativeFindPointerIndex(int i, int j);

    private static native int nativeGetAction(int i);

    private static native float nativeGetAxisValue(int i, int j, int k, int l);

    private static native int nativeGetButtonState(int i);

    private static native int nativeGetDeviceId(int i);

    private static native long nativeGetDownTimeNanos(int i);

    private static native int nativeGetEdgeFlags(int i);

    private static native long nativeGetEventTimeNanos(int i, int j);

    private static native int nativeGetFlags(int i);

    private static native int nativeGetHistorySize(int i);

    private static native int nativeGetMetaState(int i);

    private static native void nativeGetPointerCoords(int i, int j, int k, PointerCoords pointercoords);

    private static native int nativeGetPointerCount(int i);

    private static native int nativeGetPointerId(int i, int j);

    private static native void nativeGetPointerProperties(int i, int j, PointerProperties pointerproperties);

    private static native float nativeGetRawAxisValue(int i, int j, int k, int l);

    private static native int nativeGetSource(int i);

    private static native int nativeGetToolType(int i, int j);

    private static native float nativeGetXOffset(int i);

    private static native float nativeGetXPrecision(int i);

    private static native float nativeGetYOffset(int i);

    private static native float nativeGetYPrecision(int i);

    private static native int nativeInitialize(int i, int j, int k, int l, int i1, int j1, int k1, int l1, 
            float f, float f1, float f2, float f3, long l2, long l3, int i2, PointerProperties apointerproperties[], PointerCoords apointercoords[]);

    private static native boolean nativeIsTouchEvent(int i);

    private static native void nativeOffsetLocation(int i, float f, float f1);

    private static native int nativeReadFromParcel(int i, Parcel parcel);

    private static native void nativeScale(int i, float f);

    private static native void nativeSetAction(int i, int j);

    private static native void nativeSetDownTimeNanos(int i, long l);

    private static native void nativeSetEdgeFlags(int i, int j);

    private static native void nativeSetFlags(int i, int j);

    private static native int nativeSetSource(int i, int j);

    private static native void nativeTransform(int i, Matrix matrix);

    private static native void nativeWriteToParcel(int i, Parcel parcel);

    private static MotionEvent obtain() {
        MotionEvent motionevent;
        synchronized(gRecyclerLock) {
            motionevent = gRecyclerTop;
            if(motionevent == null) {
                motionevent = new MotionEvent();
                break MISSING_BLOCK_LABEL_62;
            }
            gRecyclerTop = motionevent.mNext;
            gRecyclerUsed = -1 + gRecyclerUsed;
        }
        motionevent.mNext = null;
        motionevent.prepareForReuse();
          goto _L1
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        return motionevent;
    }

    public static MotionEvent obtain(long l, long l1, int i, float f, float f1, float f2, 
            float f3, int j, float f4, float f5, int k, int i1) {
        MotionEvent motionevent = obtain();
        Object obj = gSharedTempLock;
        obj;
        JVM INSTR monitorenter ;
        ensureSharedTempPointerCapacity(1);
        PointerProperties apointerproperties[] = gSharedTempPointerProperties;
        apointerproperties[0].clear();
        apointerproperties[0].id = 0;
        PointerCoords apointercoords[] = gSharedTempPointerCoords;
        apointercoords[0].clear();
        apointercoords[0].x = f;
        apointercoords[0].y = f1;
        apointercoords[0].pressure = f2;
        apointercoords[0].size = f3;
        motionevent.mNativePtr = nativeInitialize(motionevent.mNativePtr, k, 0, i, 0, i1, j, 0, 0.0F, 0.0F, f4, f5, l * 0xf4240L, l1 * 0xf4240L, 1, apointerproperties, apointercoords);
        return motionevent;
    }

    public static MotionEvent obtain(long l, long l1, int i, float f, float f1, int j) {
        return obtain(l, l1, i, f, f1, 1.0F, 1.0F, j, 1.0F, 1.0F, 0, 0);
    }

    public static MotionEvent obtain(long l, long l1, int i, int j, float f, float f1, 
            float f2, float f3, int k, float f4, float f5, int i1, int j1) {
        return obtain(l, l1, i, f, f1, f2, f3, k, f4, f5, i1, j1);
    }

    public static MotionEvent obtain(long l, long l1, int i, int j, int ai[], PointerCoords apointercoords[], 
            int k, float f, float f1, int i1, int j1, int k1, int i2) {
        Object obj = gSharedTempLock;
        obj;
        JVM INSTR monitorenter ;
        ensureSharedTempPointerCapacity(j);
        PointerProperties apointerproperties[] = gSharedTempPointerProperties;
        for(int j2 = 0; j2 < j; j2++) {
            apointerproperties[j2].clear();
            apointerproperties[j2].id = ai[j2];
        }

        MotionEvent motionevent = obtain(l, l1, i, j, apointerproperties, apointercoords, k, 0, f, f1, i1, j1, k1, i2);
        return motionevent;
    }

    public static MotionEvent obtain(long l, long l1, int i, int j, PointerProperties apointerproperties[], PointerCoords apointercoords[], 
            int k, int i1, float f, float f1, int j1, int k1, int i2, 
            int j2) {
        MotionEvent motionevent = obtain();
        motionevent.mNativePtr = nativeInitialize(motionevent.mNativePtr, j1, i2, i, j2, k1, k, i1, 0.0F, 0.0F, f, f1, l * 0xf4240L, l1 * 0xf4240L, j, apointerproperties, apointercoords);
        return motionevent;
    }

    public static MotionEvent obtain(MotionEvent motionevent) {
        if(motionevent == null) {
            throw new IllegalArgumentException("other motion event must not be null");
        } else {
            MotionEvent motionevent1 = obtain();
            motionevent1.mNativePtr = nativeCopy(motionevent1.mNativePtr, motionevent.mNativePtr, true);
            return motionevent1;
        }
    }

    public static MotionEvent obtainNoHistory(MotionEvent motionevent) {
        if(motionevent == null) {
            throw new IllegalArgumentException("other motion event must not be null");
        } else {
            MotionEvent motionevent1 = obtain();
            motionevent1.mNativePtr = nativeCopy(motionevent1.mNativePtr, motionevent.mNativePtr, false);
            return motionevent1;
        }
    }

    public static String toolTypeToString(int i) {
        String s = (String)TOOL_TYPE_SYMBOLIC_NAMES.get(i);
        if(s == null)
            s = Integer.toString(i);
        return s;
    }

    public final void addBatch(long l, float f, float f1, float f2, float f3, int i) {
        Object obj = gSharedTempLock;
        obj;
        JVM INSTR monitorenter ;
        ensureSharedTempPointerCapacity(1);
        PointerCoords apointercoords[] = gSharedTempPointerCoords;
        apointercoords[0].clear();
        apointercoords[0].x = f;
        apointercoords[0].y = f1;
        apointercoords[0].pressure = f2;
        apointercoords[0].size = f3;
        nativeAddBatch(mNativePtr, 0xf4240L * l, apointercoords, i);
        return;
    }

    public final void addBatch(long l, PointerCoords apointercoords[], int i) {
        nativeAddBatch(mNativePtr, 0xf4240L * l, apointercoords, i);
    }

    public final boolean addBatch(MotionEvent motionevent) {
        boolean flag;
        int j;
        int i = nativeGetAction(mNativePtr);
        if(i != 2 && i != 7)
            flag = false;
        else
        if(i != nativeGetAction(motionevent.mNativePtr))
            flag = false;
        else
        if(nativeGetDeviceId(mNativePtr) != nativeGetDeviceId(motionevent.mNativePtr) || nativeGetSource(mNativePtr) != nativeGetSource(motionevent.mNativePtr) || nativeGetFlags(mNativePtr) != nativeGetFlags(motionevent.mNativePtr)) {
            flag = false;
        } else {
label0:
            {
                j = nativeGetPointerCount(mNativePtr);
                if(j == nativeGetPointerCount(motionevent.mNativePtr))
                    break label0;
                flag = false;
            }
        }
_L1:
        return flag;
        Object obj = gSharedTempLock;
        obj;
        JVM INSTR monitorenter ;
        PointerProperties apointerproperties[];
        PointerCoords apointercoords[];
        int k;
        ensureSharedTempPointerCapacity(Math.max(j, 2));
        apointerproperties = gSharedTempPointerProperties;
        apointercoords = gSharedTempPointerCoords;
        k = 0;
_L2:
        if(k >= j)
            break MISSING_BLOCK_LABEL_220;
        nativeGetPointerProperties(mNativePtr, k, apointerproperties[0]);
        nativeGetPointerProperties(motionevent.mNativePtr, k, apointerproperties[1]);
        if(apointerproperties[0].equals(apointerproperties[1]))
            break MISSING_BLOCK_LABEL_214;
        flag = false;
          goto _L1
        Exception exception;
        exception;
        throw exception;
        k++;
          goto _L2
        int l;
        int i1;
        int j1;
        l = nativeGetMetaState(motionevent.mNativePtr);
        i1 = nativeGetHistorySize(motionevent.mNativePtr);
        j1 = 0;
          goto _L3
_L6:
        int k1;
        int l1;
        for(; l1 < j; l1++)
            nativeGetPointerCoords(motionevent.mNativePtr, l1, k1, apointercoords[l1]);

        long l2 = nativeGetEventTimeNanos(motionevent.mNativePtr, k1);
        nativeAddBatch(mNativePtr, l2, apointercoords, l);
        j1++;
          goto _L3
_L5:
        flag = true;
          goto _L1
_L3:
        if(j1 > i1) goto _L5; else goto _L4
_L4:
        if(j1 == i1)
            k1 = 0x80000000;
        else
            k1 = j1;
        l1 = 0;
          goto _L6
    }

    public final MotionEvent clampNoHistory(float f, float f1, float f2, float f3) {
        MotionEvent motionevent = obtain();
        Object obj = gSharedTempLock;
        obj;
        JVM INSTR monitorenter ;
        int i = nativeGetPointerCount(mNativePtr);
        ensureSharedTempPointerCapacity(i);
        PointerProperties apointerproperties[] = gSharedTempPointerProperties;
        PointerCoords apointercoords[] = gSharedTempPointerCoords;
        for(int j = 0; j < i; j++) {
            int k = mNativePtr;
            PointerProperties pointerproperties = apointerproperties[j];
            nativeGetPointerProperties(k, j, pointerproperties);
            int l = mNativePtr;
            PointerCoords pointercoords = apointercoords[j];
            nativeGetPointerCoords(l, j, 0x80000000, pointercoords);
            apointercoords[j].x = clamp(apointercoords[j].x, f, f2);
            apointercoords[j].y = clamp(apointercoords[j].y, f1, f3);
        }

        motionevent.mNativePtr = nativeInitialize(motionevent.mNativePtr, nativeGetDeviceId(mNativePtr), nativeGetSource(mNativePtr), nativeGetAction(mNativePtr), nativeGetFlags(mNativePtr), nativeGetEdgeFlags(mNativePtr), nativeGetMetaState(mNativePtr), nativeGetButtonState(mNativePtr), nativeGetXOffset(mNativePtr), nativeGetYOffset(mNativePtr), nativeGetXPrecision(mNativePtr), nativeGetYPrecision(mNativePtr), nativeGetDownTimeNanos(mNativePtr), nativeGetEventTimeNanos(mNativePtr, 0x80000000), i, apointerproperties, apointercoords);
        return motionevent;
    }

    public volatile InputEvent copy() {
        return copy();
    }

    public MotionEvent copy() {
        return obtain(this);
    }

    protected void finalize() throws Throwable {
        if(mNativePtr != 0) {
            nativeDispose(mNativePtr);
            mNativePtr = 0;
        }
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public final int findPointerIndex(int i) {
        return nativeFindPointerIndex(mNativePtr, i);
    }

    public final int getAction() {
        return nativeGetAction(mNativePtr);
    }

    public final int getActionIndex() {
        return (0xff00 & nativeGetAction(mNativePtr)) >> 8;
    }

    public final int getActionMasked() {
        return 0xff & nativeGetAction(mNativePtr);
    }

    public final float getAxisValue(int i) {
        return nativeGetAxisValue(mNativePtr, i, 0, 0x80000000);
    }

    public final float getAxisValue(int i, int j) {
        return nativeGetAxisValue(mNativePtr, i, j, 0x80000000);
    }

    public final int getButtonState() {
        return nativeGetButtonState(mNativePtr);
    }

    public final int getDeviceId() {
        return nativeGetDeviceId(mNativePtr);
    }

    public final long getDownTime() {
        return nativeGetDownTimeNanos(mNativePtr) / 0xf4240L;
    }

    public final int getEdgeFlags() {
        return nativeGetEdgeFlags(mNativePtr);
    }

    public final long getEventTime() {
        return nativeGetEventTimeNanos(mNativePtr, 0x80000000) / 0xf4240L;
    }

    public final long getEventTimeNano() {
        return nativeGetEventTimeNanos(mNativePtr, 0x80000000);
    }

    public final int getFlags() {
        return nativeGetFlags(mNativePtr);
    }

    public final float getHistoricalAxisValue(int i, int j) {
        return nativeGetAxisValue(mNativePtr, i, 0, j);
    }

    public final float getHistoricalAxisValue(int i, int j, int k) {
        return nativeGetAxisValue(mNativePtr, i, j, k);
    }

    public final long getHistoricalEventTime(int i) {
        return nativeGetEventTimeNanos(mNativePtr, i) / 0xf4240L;
    }

    public final long getHistoricalEventTimeNano(int i) {
        return nativeGetEventTimeNanos(mNativePtr, i);
    }

    public final float getHistoricalOrientation(int i) {
        return nativeGetAxisValue(mNativePtr, 8, 0, i);
    }

    public final float getHistoricalOrientation(int i, int j) {
        return nativeGetAxisValue(mNativePtr, 8, i, j);
    }

    public final void getHistoricalPointerCoords(int i, int j, PointerCoords pointercoords) {
        nativeGetPointerCoords(mNativePtr, i, j, pointercoords);
    }

    public final float getHistoricalPressure(int i) {
        return nativeGetAxisValue(mNativePtr, 2, 0, i);
    }

    public final float getHistoricalPressure(int i, int j) {
        return nativeGetAxisValue(mNativePtr, 2, i, j);
    }

    public final float getHistoricalSize(int i) {
        return nativeGetAxisValue(mNativePtr, 3, 0, i);
    }

    public final float getHistoricalSize(int i, int j) {
        return nativeGetAxisValue(mNativePtr, 3, i, j);
    }

    public final float getHistoricalToolMajor(int i) {
        return nativeGetAxisValue(mNativePtr, 6, 0, i);
    }

    public final float getHistoricalToolMajor(int i, int j) {
        return nativeGetAxisValue(mNativePtr, 6, i, j);
    }

    public final float getHistoricalToolMinor(int i) {
        return nativeGetAxisValue(mNativePtr, 7, 0, i);
    }

    public final float getHistoricalToolMinor(int i, int j) {
        return nativeGetAxisValue(mNativePtr, 7, i, j);
    }

    public final float getHistoricalTouchMajor(int i) {
        return nativeGetAxisValue(mNativePtr, 4, 0, i);
    }

    public final float getHistoricalTouchMajor(int i, int j) {
        return nativeGetAxisValue(mNativePtr, 4, i, j);
    }

    public final float getHistoricalTouchMinor(int i) {
        return nativeGetAxisValue(mNativePtr, 5, 0, i);
    }

    public final float getHistoricalTouchMinor(int i, int j) {
        return nativeGetAxisValue(mNativePtr, 5, i, j);
    }

    public final float getHistoricalX(int i) {
        return nativeGetAxisValue(mNativePtr, 0, 0, i);
    }

    public final float getHistoricalX(int i, int j) {
        return nativeGetAxisValue(mNativePtr, 0, i, j);
    }

    public final float getHistoricalY(int i) {
        return nativeGetAxisValue(mNativePtr, 1, 0, i);
    }

    public final float getHistoricalY(int i, int j) {
        return nativeGetAxisValue(mNativePtr, 1, i, j);
    }

    public final int getHistorySize() {
        return nativeGetHistorySize(mNativePtr);
    }

    public final int getMetaState() {
        return nativeGetMetaState(mNativePtr);
    }

    public final float getOrientation() {
        return nativeGetAxisValue(mNativePtr, 8, 0, 0x80000000);
    }

    public final float getOrientation(int i) {
        return nativeGetAxisValue(mNativePtr, 8, i, 0x80000000);
    }

    public final void getPointerCoords(int i, PointerCoords pointercoords) {
        nativeGetPointerCoords(mNativePtr, i, 0x80000000, pointercoords);
    }

    public final int getPointerCount() {
        return nativeGetPointerCount(mNativePtr);
    }

    public final int getPointerId(int i) {
        return nativeGetPointerId(mNativePtr, i);
    }

    public final int getPointerIdBits() {
        int i = 0;
        int j = nativeGetPointerCount(mNativePtr);
        for(int k = 0; k < j; k++)
            i |= 1 << nativeGetPointerId(mNativePtr, k);

        return i;
    }

    public final void getPointerProperties(int i, PointerProperties pointerproperties) {
        nativeGetPointerProperties(mNativePtr, i, pointerproperties);
    }

    public final float getPressure() {
        return nativeGetAxisValue(mNativePtr, 2, 0, 0x80000000);
    }

    public final float getPressure(int i) {
        return nativeGetAxisValue(mNativePtr, 2, i, 0x80000000);
    }

    public final float getRawX() {
        return nativeGetRawAxisValue(mNativePtr, 0, 0, 0x80000000);
    }

    public final float getRawY() {
        return nativeGetRawAxisValue(mNativePtr, 1, 0, 0x80000000);
    }

    public final float getSize() {
        return nativeGetAxisValue(mNativePtr, 3, 0, 0x80000000);
    }

    public final float getSize(int i) {
        return nativeGetAxisValue(mNativePtr, 3, i, 0x80000000);
    }

    public final int getSource() {
        return nativeGetSource(mNativePtr);
    }

    public final float getToolMajor() {
        return nativeGetAxisValue(mNativePtr, 6, 0, 0x80000000);
    }

    public final float getToolMajor(int i) {
        return nativeGetAxisValue(mNativePtr, 6, i, 0x80000000);
    }

    public final float getToolMinor() {
        return nativeGetAxisValue(mNativePtr, 7, 0, 0x80000000);
    }

    public final float getToolMinor(int i) {
        return nativeGetAxisValue(mNativePtr, 7, i, 0x80000000);
    }

    public final int getToolType(int i) {
        return nativeGetToolType(mNativePtr, i);
    }

    public final float getTouchMajor() {
        return nativeGetAxisValue(mNativePtr, 4, 0, 0x80000000);
    }

    public final float getTouchMajor(int i) {
        return nativeGetAxisValue(mNativePtr, 4, i, 0x80000000);
    }

    public final float getTouchMinor() {
        return nativeGetAxisValue(mNativePtr, 5, 0, 0x80000000);
    }

    public final float getTouchMinor(int i) {
        return nativeGetAxisValue(mNativePtr, 5, i, 0x80000000);
    }

    public final float getX() {
        return nativeGetAxisValue(mNativePtr, 0, 0, 0x80000000);
    }

    public final float getX(int i) {
        return nativeGetAxisValue(mNativePtr, 0, i, 0x80000000);
    }

    public final float getXPrecision() {
        return nativeGetXPrecision(mNativePtr);
    }

    public final float getY() {
        return nativeGetAxisValue(mNativePtr, 1, 0, 0x80000000);
    }

    public final float getY(int i) {
        return nativeGetAxisValue(mNativePtr, 1, i, 0x80000000);
    }

    public final float getYPrecision() {
        return nativeGetYPrecision(mNativePtr);
    }

    public final boolean isTainted() {
        boolean flag;
        if((0x80000000 & getFlags()) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean isTouchEvent() {
        return nativeIsTouchEvent(mNativePtr);
    }

    public final boolean isWithinBoundsNoHistory(float f, float f1, float f2, float f3) {
        boolean flag;
        int i;
        int j;
        flag = false;
        i = nativeGetPointerCount(mNativePtr);
        j = 0;
_L3:
        float f4;
        float f5;
        if(j >= i)
            break MISSING_BLOCK_LABEL_88;
        f4 = nativeGetAxisValue(mNativePtr, 0, j, 0x80000000);
        f5 = nativeGetAxisValue(mNativePtr, 1, j, 0x80000000);
        if(f4 >= f && f4 <= f2 && f5 >= f1 && f5 <= f3) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        j++;
          goto _L3
        flag = true;
          goto _L1
    }

    public final void offsetLocation(float f, float f1) {
        if(f != 0.0F || f1 != 0.0F)
            nativeOffsetLocation(mNativePtr, f, f1);
    }

    public final void recycle() {
        super.recycle();
        Object obj = gRecyclerLock;
        obj;
        JVM INSTR monitorenter ;
        if(gRecyclerUsed < 10) {
            gRecyclerUsed = 1 + gRecyclerUsed;
            mNext = gRecyclerTop;
            gRecyclerTop = this;
        }
        return;
    }

    public final void scale(float f) {
        if(f != 1.0F)
            nativeScale(mNativePtr, f);
    }

    public final void setAction(int i) {
        nativeSetAction(mNativePtr, i);
    }

    public final void setDownTime(long l) {
        nativeSetDownTimeNanos(mNativePtr, 0xf4240L * l);
    }

    public final void setEdgeFlags(int i) {
        nativeSetEdgeFlags(mNativePtr, i);
    }

    public final void setLocation(float f, float f1) {
        float f2 = getX();
        float f3 = getY();
        offsetLocation(f - f2, f1 - f3);
    }

    public final void setSource(int i) {
        nativeSetSource(mNativePtr, i);
    }

    public final void setTainted(boolean flag) {
        int i = getFlags();
        int j = mNativePtr;
        int k;
        if(flag)
            k = 0x80000000 | i;
        else
            k = 0x7fffffff & i;
        nativeSetFlags(j, k);
    }

    public final MotionEvent split(int i) {
        MotionEvent motionevent = obtain();
        Object obj = gSharedTempLock;
        obj;
        JVM INSTR monitorenter ;
        int j;
        PointerProperties apointerproperties[];
        PointerCoords apointercoords[];
        int ai[];
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        j = nativeGetPointerCount(mNativePtr);
        ensureSharedTempPointerCapacity(j);
        apointerproperties = gSharedTempPointerProperties;
        apointercoords = gSharedTempPointerCoords;
        ai = gSharedTempPointerIndexMap;
        k = nativeGetAction(mNativePtr);
        l = k & 0xff;
        i1 = (0xff00 & k) >> 8;
        j1 = -1;
        k1 = 0;
        l1 = 0;
        i2 = 0;
        break MISSING_BLOCK_LABEL_79;
        exception;
        throw exception;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        if(l == 5 || l == 6) {
            if(j1 < 0)
                j2 = 2;
            else
            if(k1 == 1) {
                if(l == 5)
                    j2 = 0;
                else
                    j2 = 1;
            } else {
                j2 = l | j1 << 8;
            }
        } else {
            j2 = k;
        }
        k2 = nativeGetHistorySize(mNativePtr);
        l2 = 0;
          goto _L1
_L4:
        for(; j3 < k1; j3++) {
            int k3 = mNativePtr;
            int i4 = ai[j3];
            PointerCoords pointercoords = apointercoords[j3];
            nativeGetPointerCoords(k3, i4, i3, pointercoords);
        }

        long l3 = nativeGetEventTimeNanos(mNativePtr, i3);
        if(l2 == 0)
            motionevent.mNativePtr = nativeInitialize(motionevent.mNativePtr, nativeGetDeviceId(mNativePtr), nativeGetSource(mNativePtr), j2, nativeGetFlags(mNativePtr), nativeGetEdgeFlags(mNativePtr), nativeGetMetaState(mNativePtr), nativeGetButtonState(mNativePtr), nativeGetXOffset(mNativePtr), nativeGetYOffset(mNativePtr), nativeGetXPrecision(mNativePtr), nativeGetYPrecision(mNativePtr), nativeGetDownTimeNanos(mNativePtr), l3, k1, apointerproperties, apointercoords);
        else
            nativeAddBatch(motionevent.mNativePtr, l3, apointercoords, 0);
        break MISSING_BLOCK_LABEL_478;
_L3:
        return motionevent;
        do {
            Exception exception;
            if(i2 < j) {
                int j4 = mNativePtr;
                PointerProperties pointerproperties = apointerproperties[k1];
                nativeGetPointerProperties(j4, i2, pointerproperties);
                int k4 = 1 << apointerproperties[k1].id;
                if((k4 & i) != 0) {
                    if(i2 == i1)
                        j1 = k1;
                    ai[k1] = i2;
                    k1++;
                    l1 |= k4;
                }
            } else {
                if(k1 == 0)
                    throw new IllegalArgumentException("idBits did not match any ids in the event");
                break MISSING_BLOCK_LABEL_181;
            }
            i2++;
        } while(true);
_L1:
        if(l2 > k2) goto _L3; else goto _L2
_L2:
        if(l2 == k2)
            i3 = 0x80000000;
        else
            i3 = l2;
        j3 = 0;
          goto _L4
        l2++;
          goto _L1
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("MotionEvent { action=").append(actionToString(getAction()));
        int i = getPointerCount();
        for(int j = 0; j < i; j++) {
            stringbuilder.append(", id[").append(j).append("]=").append(getPointerId(j));
            stringbuilder.append(", x[").append(j).append("]=").append(getX(j));
            stringbuilder.append(", y[").append(j).append("]=").append(getY(j));
            stringbuilder.append(", toolType[").append(j).append("]=").append(toolTypeToString(getToolType(j)));
        }

        stringbuilder.append(", buttonState=").append(buttonStateToString(getButtonState()));
        stringbuilder.append(", metaState=").append(KeyEvent.metaStateToString(getMetaState()));
        stringbuilder.append(", flags=0x").append(Integer.toHexString(getFlags()));
        stringbuilder.append(", edgeFlags=0x").append(Integer.toHexString(getEdgeFlags()));
        stringbuilder.append(", pointerCount=").append(i);
        stringbuilder.append(", historySize=").append(getHistorySize());
        stringbuilder.append(", eventTime=").append(getEventTime());
        stringbuilder.append(", downTime=").append(getDownTime());
        stringbuilder.append(", deviceId=").append(getDeviceId());
        stringbuilder.append(", source=0x").append(Integer.toHexString(getSource()));
        stringbuilder.append(" }");
        return stringbuilder.toString();
    }

    public final void transform(Matrix matrix) {
        if(matrix == null) {
            throw new IllegalArgumentException("matrix must not be null");
        } else {
            nativeTransform(mNativePtr, matrix);
            return;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(1);
        nativeWriteToParcel(mNativePtr, parcel);
    }

    public static final int ACTION_CANCEL = 3;
    public static final int ACTION_DOWN = 0;
    public static final int ACTION_HOVER_ENTER = 9;
    public static final int ACTION_HOVER_EXIT = 10;
    public static final int ACTION_HOVER_MOVE = 7;
    public static final int ACTION_MASK = 255;
    public static final int ACTION_MOVE = 2;
    public static final int ACTION_OUTSIDE = 4;
    public static final int ACTION_POINTER_1_DOWN = 5;
    public static final int ACTION_POINTER_1_UP = 6;
    public static final int ACTION_POINTER_2_DOWN = 261;
    public static final int ACTION_POINTER_2_UP = 262;
    public static final int ACTION_POINTER_3_DOWN = 517;
    public static final int ACTION_POINTER_3_UP = 518;
    public static final int ACTION_POINTER_DOWN = 5;
    public static final int ACTION_POINTER_ID_MASK = 65280;
    public static final int ACTION_POINTER_ID_SHIFT = 8;
    public static final int ACTION_POINTER_INDEX_MASK = 65280;
    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    public static final int ACTION_POINTER_UP = 6;
    public static final int ACTION_SCROLL = 8;
    public static final int ACTION_UP = 1;
    public static final int AXIS_BRAKE = 23;
    public static final int AXIS_DISTANCE = 24;
    public static final int AXIS_GAS = 22;
    public static final int AXIS_GENERIC_1 = 32;
    public static final int AXIS_GENERIC_10 = 41;
    public static final int AXIS_GENERIC_11 = 42;
    public static final int AXIS_GENERIC_12 = 43;
    public static final int AXIS_GENERIC_13 = 44;
    public static final int AXIS_GENERIC_14 = 45;
    public static final int AXIS_GENERIC_15 = 46;
    public static final int AXIS_GENERIC_16 = 47;
    public static final int AXIS_GENERIC_2 = 33;
    public static final int AXIS_GENERIC_3 = 34;
    public static final int AXIS_GENERIC_4 = 35;
    public static final int AXIS_GENERIC_5 = 36;
    public static final int AXIS_GENERIC_6 = 37;
    public static final int AXIS_GENERIC_7 = 38;
    public static final int AXIS_GENERIC_8 = 39;
    public static final int AXIS_GENERIC_9 = 40;
    public static final int AXIS_HAT_X = 15;
    public static final int AXIS_HAT_Y = 16;
    public static final int AXIS_HSCROLL = 10;
    public static final int AXIS_LTRIGGER = 17;
    public static final int AXIS_ORIENTATION = 8;
    public static final int AXIS_PRESSURE = 2;
    public static final int AXIS_RTRIGGER = 18;
    public static final int AXIS_RUDDER = 20;
    public static final int AXIS_RX = 12;
    public static final int AXIS_RY = 13;
    public static final int AXIS_RZ = 14;
    public static final int AXIS_SIZE = 3;
    private static final SparseArray AXIS_SYMBOLIC_NAMES;
    public static final int AXIS_THROTTLE = 19;
    public static final int AXIS_TILT = 25;
    public static final int AXIS_TOOL_MAJOR = 6;
    public static final int AXIS_TOOL_MINOR = 7;
    public static final int AXIS_TOUCH_MAJOR = 4;
    public static final int AXIS_TOUCH_MINOR = 5;
    public static final int AXIS_VSCROLL = 9;
    public static final int AXIS_WHEEL = 21;
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_Z = 11;
    public static final int BUTTON_BACK = 8;
    public static final int BUTTON_FORWARD = 16;
    public static final int BUTTON_PRIMARY = 1;
    public static final int BUTTON_SECONDARY = 2;
    private static final String BUTTON_SYMBOLIC_NAMES[];
    public static final int BUTTON_TERTIARY = 4;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public MotionEvent createFromParcel(Parcel parcel) {
            parcel.readInt();
            return MotionEvent.createFromParcelBody(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public MotionEvent[] newArray(int i) {
            return new MotionEvent[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int EDGE_BOTTOM = 2;
    public static final int EDGE_LEFT = 4;
    public static final int EDGE_RIGHT = 8;
    public static final int EDGE_TOP = 1;
    public static final int FLAG_TAINTED = 0x80000000;
    public static final int FLAG_WINDOW_IS_OBSCURED = 1;
    private static final int HISTORY_CURRENT = 0x80000000;
    public static final int INVALID_POINTER_ID = -1;
    private static final int MAX_RECYCLED = 10;
    private static final long NS_PER_MS = 0xf4240L;
    public static final int TOOL_TYPE_ERASER = 4;
    public static final int TOOL_TYPE_FINGER = 1;
    public static final int TOOL_TYPE_MOUSE = 3;
    public static final int TOOL_TYPE_STYLUS = 2;
    private static final SparseArray TOOL_TYPE_SYMBOLIC_NAMES;
    public static final int TOOL_TYPE_UNKNOWN;
    private static final Object gRecyclerLock = new Object();
    private static MotionEvent gRecyclerTop;
    private static int gRecyclerUsed;
    private static final Object gSharedTempLock = new Object();
    private static PointerCoords gSharedTempPointerCoords[];
    private static int gSharedTempPointerIndexMap[];
    private static PointerProperties gSharedTempPointerProperties[];
    private int mNativePtr;
    private MotionEvent mNext;

    static  {
        AXIS_SYMBOLIC_NAMES = new SparseArray();
        SparseArray sparsearray = AXIS_SYMBOLIC_NAMES;
        sparsearray.append(0, "AXIS_X");
        sparsearray.append(1, "AXIS_Y");
        sparsearray.append(2, "AXIS_PRESSURE");
        sparsearray.append(3, "AXIS_SIZE");
        sparsearray.append(4, "AXIS_TOUCH_MAJOR");
        sparsearray.append(5, "AXIS_TOUCH_MINOR");
        sparsearray.append(6, "AXIS_TOOL_MAJOR");
        sparsearray.append(7, "AXIS_TOOL_MINOR");
        sparsearray.append(8, "AXIS_ORIENTATION");
        sparsearray.append(9, "AXIS_VSCROLL");
        sparsearray.append(10, "AXIS_HSCROLL");
        sparsearray.append(11, "AXIS_Z");
        sparsearray.append(12, "AXIS_RX");
        sparsearray.append(13, "AXIS_RY");
        sparsearray.append(14, "AXIS_RZ");
        sparsearray.append(15, "AXIS_HAT_X");
        sparsearray.append(16, "AXIS_HAT_Y");
        sparsearray.append(17, "AXIS_LTRIGGER");
        sparsearray.append(18, "AXIS_RTRIGGER");
        sparsearray.append(19, "AXIS_THROTTLE");
        sparsearray.append(20, "AXIS_RUDDER");
        sparsearray.append(21, "AXIS_WHEEL");
        sparsearray.append(22, "AXIS_GAS");
        sparsearray.append(23, "AXIS_BRAKE");
        sparsearray.append(24, "AXIS_DISTANCE");
        sparsearray.append(25, "AXIS_TILT");
        sparsearray.append(32, "AXIS_GENERIC_1");
        sparsearray.append(33, "AXIS_GENERIC_2");
        sparsearray.append(34, "AXIS_GENERIC_3");
        sparsearray.append(35, "AXIS_GENERIC_4");
        sparsearray.append(36, "AXIS_GENERIC_5");
        sparsearray.append(37, "AXIS_GENERIC_6");
        sparsearray.append(38, "AXIS_GENERIC_7");
        sparsearray.append(39, "AXIS_GENERIC_8");
        sparsearray.append(40, "AXIS_GENERIC_9");
        sparsearray.append(41, "AXIS_GENERIC_10");
        sparsearray.append(42, "AXIS_GENERIC_11");
        sparsearray.append(43, "AXIS_GENERIC_12");
        sparsearray.append(44, "AXIS_GENERIC_13");
        sparsearray.append(45, "AXIS_GENERIC_14");
        sparsearray.append(46, "AXIS_GENERIC_15");
        sparsearray.append(47, "AXIS_GENERIC_16");
        String as[] = new String[32];
        as[0] = "BUTTON_PRIMARY";
        as[1] = "BUTTON_SECONDARY";
        as[2] = "BUTTON_TERTIARY";
        as[3] = "BUTTON_BACK";
        as[4] = "BUTTON_FORWARD";
        as[5] = "0x00000020";
        as[6] = "0x00000040";
        as[7] = "0x00000080";
        as[8] = "0x00000100";
        as[9] = "0x00000200";
        as[10] = "0x00000400";
        as[11] = "0x00000800";
        as[12] = "0x00001000";
        as[13] = "0x00002000";
        as[14] = "0x00004000";
        as[15] = "0x00008000";
        as[16] = "0x00010000";
        as[17] = "0x00020000";
        as[18] = "0x00040000";
        as[19] = "0x00080000";
        as[20] = "0x00100000";
        as[21] = "0x00200000";
        as[22] = "0x00400000";
        as[23] = "0x00800000";
        as[24] = "0x01000000";
        as[25] = "0x02000000";
        as[26] = "0x04000000";
        as[27] = "0x08000000";
        as[28] = "0x10000000";
        as[29] = "0x20000000";
        as[30] = "0x40000000";
        as[31] = "0x80000000";
        BUTTON_SYMBOLIC_NAMES = as;
        TOOL_TYPE_SYMBOLIC_NAMES = new SparseArray();
        SparseArray sparsearray1 = TOOL_TYPE_SYMBOLIC_NAMES;
        sparsearray1.append(0, "TOOL_TYPE_UNKNOWN");
        sparsearray1.append(1, "TOOL_TYPE_FINGER");
        sparsearray1.append(2, "TOOL_TYPE_STYLUS");
        sparsearray1.append(3, "TOOL_TYPE_MOUSE");
        sparsearray1.append(4, "TOOL_TYPE_ERASER");
    }
}
