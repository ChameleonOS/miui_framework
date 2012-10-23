// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.inputmethodservice;

import android.content.Context;
import android.content.res.*;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.*;
import java.io.IOException;
import java.util.*;
import org.xmlpull.v1.XmlPullParserException;

public class Keyboard {
    public static class Key {

        public int[] getCurrentDrawableState() {
            int ai[] = KEY_STATE_NORMAL;
            if(!on) goto _L2; else goto _L1
_L1:
            if(pressed)
                ai = KEY_STATE_PRESSED_ON;
            else
                ai = KEY_STATE_NORMAL_ON;
_L4:
            return ai;
_L2:
            if(sticky) {
                if(pressed)
                    ai = KEY_STATE_PRESSED_OFF;
                else
                    ai = KEY_STATE_NORMAL_OFF;
            } else
            if(pressed)
                ai = KEY_STATE_PRESSED;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public boolean isInside(int i, int j) {
            boolean flag = true;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            boolean flag4;
            if((1 & edgeFlags) > 0)
                flag1 = flag;
            else
                flag1 = false;
            if((2 & edgeFlags) > 0)
                flag2 = flag;
            else
                flag2 = false;
            if((4 & edgeFlags) > 0)
                flag3 = flag;
            else
                flag3 = false;
            if((8 & edgeFlags) > 0)
                flag4 = flag;
            else
                flag4 = false;
            if(i < x && (!flag1 || i > x + width) || i >= x + width && (!flag2 || i < x) || j < y && (!flag3 || j > y + height) || j >= y + height && (!flag4 || j < y))
                flag = false;
            return flag;
        }

        public void onPressed() {
            boolean flag;
            if(!pressed)
                flag = true;
            else
                flag = false;
            pressed = flag;
        }

        public void onReleased(boolean flag) {
            boolean flag1 = true;
            boolean flag2;
            if(!pressed)
                flag2 = flag1;
            else
                flag2 = false;
            pressed = flag2;
            if(sticky) {
                if(on)
                    flag1 = false;
                on = flag1;
            }
        }

        int[] parseCSV(String s) {
            int ai[];
            int k;
            StringTokenizer stringtokenizer;
            int i = 0;
            int j = 0;
            if(s.length() > 0) {
                i = 0 + 1;
                do {
                    j = s.indexOf(",", j + 1);
                    if(j <= 0)
                        break;
                    i++;
                } while(true);
            }
            ai = new int[i];
            k = 0;
            stringtokenizer = new StringTokenizer(s, ",");
_L2:
            int l;
            if(!stringtokenizer.hasMoreTokens())
                break; /* Loop/switch isn't completed */
            l = k + 1;
            ai[k] = Integer.parseInt(stringtokenizer.nextToken());
            k = l;
            continue; /* Loop/switch isn't completed */
            NumberFormatException numberformatexception;
            numberformatexception;
            Log.e("Keyboard", (new StringBuilder()).append("Error parsing keycodes ").append(s).toString());
            k = l;
            if(true) goto _L2; else goto _L1
_L1:
            return ai;
        }

        public int squaredDistanceFrom(int i, int j) {
            int k = (x + width / 2) - i;
            int l = (y + height / 2) - j;
            return k * k + l * l;
        }

        private static final int KEY_STATE_NORMAL[] = new int[0];
        private static final int KEY_STATE_NORMAL_OFF[];
        private static final int KEY_STATE_NORMAL_ON[];
        private static final int KEY_STATE_PRESSED[];
        private static final int KEY_STATE_PRESSED_OFF[];
        private static final int KEY_STATE_PRESSED_ON[];
        public int codes[];
        public int edgeFlags;
        public int gap;
        public int height;
        public Drawable icon;
        public Drawable iconPreview;
        private Keyboard keyboard;
        public CharSequence label;
        public boolean modifier;
        public boolean on;
        public CharSequence popupCharacters;
        public int popupResId;
        public boolean pressed;
        public boolean repeatable;
        public boolean sticky;
        public CharSequence text;
        public int width;
        public int x;
        public int y;

        static  {
            int ai[] = new int[2];
            ai[0] = 0x101009f;
            ai[1] = 0x10100a0;
            KEY_STATE_NORMAL_ON = ai;
            int ai1[] = new int[3];
            ai1[0] = 0x10100a7;
            ai1[1] = 0x101009f;
            ai1[2] = 0x10100a0;
            KEY_STATE_PRESSED_ON = ai1;
            int ai2[] = new int[1];
            ai2[0] = 0x101009f;
            KEY_STATE_NORMAL_OFF = ai2;
            int ai3[] = new int[2];
            ai3[0] = 0x10100a7;
            ai3[1] = 0x101009f;
            KEY_STATE_PRESSED_OFF = ai3;
            int ai4[] = new int[1];
            ai4[0] = 0x10100a7;
            KEY_STATE_PRESSED = ai4;
        }

        public Key(Resources resources, Row row, int i, int j, XmlResourceParser xmlresourceparser) {
            TypedArray typedarray1;
            TypedValue typedvalue;
            this(row);
            x = i;
            y = j;
            TypedArray typedarray = resources.obtainAttributes(Xml.asAttributeSet(xmlresourceparser), com.android.internal.R.styleable.Keyboard);
            width = Keyboard.getDimensionOrFraction(typedarray, 0, keyboard.mDisplayWidth, row.defaultWidth);
            height = Keyboard.getDimensionOrFraction(typedarray, 1, keyboard.mDisplayHeight, row.defaultHeight);
            gap = Keyboard.getDimensionOrFraction(typedarray, 2, keyboard.mDisplayWidth, row.defaultHorizontalGap);
            typedarray.recycle();
            typedarray1 = resources.obtainAttributes(Xml.asAttributeSet(xmlresourceparser), com.android.internal.R.styleable.Keyboard_Key);
            x = x + gap;
            typedvalue = new TypedValue();
            typedarray1.getValue(0, typedvalue);
            if(typedvalue.type != 16 && typedvalue.type != 17) goto _L2; else goto _L1
_L1:
            int ai[] = new int[1];
            ai[0] = typedvalue.data;
            codes = ai;
_L4:
            iconPreview = typedarray1.getDrawable(7);
            if(iconPreview != null)
                iconPreview.setBounds(0, 0, iconPreview.getIntrinsicWidth(), iconPreview.getIntrinsicHeight());
            popupCharacters = typedarray1.getText(2);
            popupResId = typedarray1.getResourceId(1, 0);
            repeatable = typedarray1.getBoolean(6, false);
            modifier = typedarray1.getBoolean(4, false);
            sticky = typedarray1.getBoolean(5, false);
            edgeFlags = typedarray1.getInt(3, 0);
            edgeFlags = edgeFlags | row.rowEdgeFlags;
            icon = typedarray1.getDrawable(10);
            if(icon != null)
                icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
            label = typedarray1.getText(9);
            text = typedarray1.getText(8);
            if(codes == null && !TextUtils.isEmpty(label)) {
                int ai1[] = new int[1];
                ai1[0] = label.charAt(0);
                codes = ai1;
            }
            typedarray1.recycle();
            return;
_L2:
            if(typedvalue.type == 3)
                codes = parseCSV(typedvalue.string.toString());
            if(true) goto _L4; else goto _L3
_L3:
        }

        public Key(Row row) {
            keyboard = row.parent;
            height = row.defaultHeight;
            width = row.defaultWidth;
            gap = row.defaultHorizontalGap;
            edgeFlags = row.rowEdgeFlags;
        }
    }

    public static class Row {

        public int defaultHeight;
        public int defaultHorizontalGap;
        public int defaultWidth;
        ArrayList mKeys;
        public int mode;
        private Keyboard parent;
        public int rowEdgeFlags;
        public int verticalGap;


        public Row(Resources resources, Keyboard keyboard, XmlResourceParser xmlresourceparser) {
            mKeys = new ArrayList();
            parent = keyboard;
            TypedArray typedarray = resources.obtainAttributes(Xml.asAttributeSet(xmlresourceparser), com.android.internal.R.styleable.Keyboard);
            defaultWidth = Keyboard.getDimensionOrFraction(typedarray, 0, keyboard.mDisplayWidth, keyboard.mDefaultWidth);
            defaultHeight = Keyboard.getDimensionOrFraction(typedarray, 1, keyboard.mDisplayHeight, keyboard.mDefaultHeight);
            defaultHorizontalGap = Keyboard.getDimensionOrFraction(typedarray, 2, keyboard.mDisplayWidth, keyboard.mDefaultHorizontalGap);
            verticalGap = Keyboard.getDimensionOrFraction(typedarray, 3, keyboard.mDisplayHeight, keyboard.mDefaultVerticalGap);
            typedarray.recycle();
            TypedArray typedarray1 = resources.obtainAttributes(Xml.asAttributeSet(xmlresourceparser), com.android.internal.R.styleable.Keyboard_Row);
            rowEdgeFlags = typedarray1.getInt(0, 0);
            mode = typedarray1.getResourceId(1, 0);
        }

        public Row(Keyboard keyboard) {
            mKeys = new ArrayList();
            parent = keyboard;
        }
    }


    public Keyboard(Context context, int i) {
        this(context, i, 0);
    }

    public Keyboard(Context context, int i, int j) {
        Key akey[] = new Key[2];
        akey[0] = null;
        akey[1] = null;
        mShiftKeys = akey;
        int ai[] = new int[2];
        ai[0] = -1;
        ai[1] = -1;
        mShiftKeyIndices = ai;
        rows = new ArrayList();
        DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
        mDisplayWidth = displaymetrics.widthPixels;
        mDisplayHeight = displaymetrics.heightPixels;
        mDefaultHorizontalGap = 0;
        mDefaultWidth = mDisplayWidth / 10;
        mDefaultVerticalGap = 0;
        mDefaultHeight = mDefaultWidth;
        mKeys = new ArrayList();
        mModifierKeys = new ArrayList();
        mKeyboardMode = j;
        loadKeyboard(context, context.getResources().getXml(i));
    }

    public Keyboard(Context context, int i, int j, int k, int l) {
        Key akey[] = new Key[2];
        akey[0] = null;
        akey[1] = null;
        mShiftKeys = akey;
        int ai[] = new int[2];
        ai[0] = -1;
        ai[1] = -1;
        mShiftKeyIndices = ai;
        rows = new ArrayList();
        mDisplayWidth = k;
        mDisplayHeight = l;
        mDefaultHorizontalGap = 0;
        mDefaultWidth = mDisplayWidth / 10;
        mDefaultVerticalGap = 0;
        mDefaultHeight = mDefaultWidth;
        mKeys = new ArrayList();
        mModifierKeys = new ArrayList();
        mKeyboardMode = j;
        loadKeyboard(context, context.getResources().getXml(i));
    }

    public Keyboard(Context context, int i, CharSequence charsequence, int j, int k) {
        this(context, i);
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        mTotalWidth = 0;
        Row row = new Row(this);
        row.defaultHeight = mDefaultHeight;
        row.defaultWidth = mDefaultWidth;
        row.defaultHorizontalGap = mDefaultHorizontalGap;
        row.verticalGap = mDefaultVerticalGap;
        row.rowEdgeFlags = 12;
        int k1;
        int l1;
        if(j == -1)
            k1 = 0x7fffffff;
        else
            k1 = j;
        for(l1 = 0; l1 < charsequence.length(); l1++) {
            char c = charsequence.charAt(l1);
            if(j1 >= k1 || k + (l + mDefaultWidth) > mDisplayWidth) {
                l = 0;
                i1 += mDefaultVerticalGap + mDefaultHeight;
                j1 = 0;
            }
            Key key = new Key(row);
            key.x = l;
            key.y = i1;
            key.label = String.valueOf(c);
            int ai[] = new int[1];
            ai[0] = c;
            key.codes = ai;
            j1++;
            l += key.width + key.gap;
            mKeys.add(key);
            row.mKeys.add(key);
            if(l > mTotalWidth)
                mTotalWidth = l;
        }

        mTotalHeight = i1 + mDefaultHeight;
        rows.add(row);
    }

    private void computeNearestNeighbors() {
        mCellWidth = (-1 + (10 + getMinWidth())) / 10;
        mCellHeight = (-1 + (5 + getHeight())) / 5;
        mGridNeighbors = new int[50][];
        int ai[] = new int[mKeys.size()];
        int i = 10 * mCellWidth;
        int j = 5 * mCellHeight;
        for(int k = 0; k < i; k += mCellWidth) {
            for(int l = 0; l < j; l += mCellHeight) {
                int i1 = 0;
                for(int j1 = 0; j1 < mKeys.size(); j1++) {
                    Key key = (Key)mKeys.get(j1);
                    if(key.squaredDistanceFrom(k, l) < mProximityThreshold || key.squaredDistanceFrom(-1 + (k + mCellWidth), l) < mProximityThreshold || key.squaredDistanceFrom(-1 + (k + mCellWidth), -1 + (l + mCellHeight)) < mProximityThreshold || key.squaredDistanceFrom(k, -1 + (l + mCellHeight)) < mProximityThreshold) {
                        int k1 = i1 + 1;
                        ai[i1] = j1;
                        i1 = k1;
                    }
                }

                int ai1[] = new int[i1];
                System.arraycopy(ai, 0, ai1, 0, i1);
                mGridNeighbors[10 * (l / mCellHeight) + k / mCellWidth] = ai1;
            }

        }

    }

    static int getDimensionOrFraction(TypedArray typedarray, int i, int j, int k) {
        TypedValue typedvalue = typedarray.peekValue(i);
        if(typedvalue != null) goto _L2; else goto _L1
_L1:
        return k;
_L2:
        if(typedvalue.type == 5)
            k = typedarray.getDimensionPixelOffset(i, k);
        else
        if(typedvalue.type == 6)
            k = Math.round(typedarray.getFraction(i, j, j, k));
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void loadKeyboard(Context context, XmlResourceParser xmlresourceparser) {
        boolean flag;
        boolean flag1;
        int i;
        int j;
        int k;
        Key key;
        Row row;
        Resources resources;
        flag = false;
        flag1 = false;
        i = 0;
        j = 0;
        k = 0;
        key = null;
        row = null;
        resources = context.getResources();
_L7:
        int l = xmlresourceparser.next();
        if(l == 1) goto _L2; else goto _L1
_L1:
        if(l != 2) goto _L4; else goto _L3
_L3:
        String s = xmlresourceparser.getName();
        if(!"Row".equals(s)) goto _L6; else goto _L5
_L5:
        boolean flag2;
        flag1 = true;
        j = 0;
        row = createRowFromXml(resources, xmlresourceparser);
        rows.add(row);
        if(row.mode == 0 || row.mode == mKeyboardMode)
            break MISSING_BLOCK_LABEL_439;
        flag2 = true;
_L23:
        if(flag2) {
            skipToEndOfRow(xmlresourceparser);
            flag1 = false;
        }
          goto _L7
_L6:
        if(!"Key".equals(s)) goto _L9; else goto _L8
_L8:
        flag = true;
        key = createKeyFromXml(resources, row, j, k, xmlresourceparser);
        mKeys.add(key);
        if(key.codes[0] != -1) goto _L11; else goto _L10
_L10:
        int j1 = 0;
_L16:
        if(j1 >= mShiftKeys.length) goto _L13; else goto _L12
_L12:
        if(mShiftKeys[j1] != null) goto _L15; else goto _L14
_L14:
        mShiftKeys[j1] = key;
        mShiftKeyIndices[j1] = -1 + mKeys.size();
_L13:
        mModifierKeys.add(key);
_L18:
        row.mKeys.add(key);
          goto _L7
        Exception exception;
        exception;
        Log.e("Keyboard", (new StringBuilder()).append("Parse error:").append(exception).toString());
        exception.printStackTrace();
_L2:
        mTotalHeight = k - mDefaultVerticalGap;
        return;
_L15:
        j1++;
          goto _L16
_L11:
        if(key.codes[0] != -6) goto _L18; else goto _L17
_L17:
        mModifierKeys.add(key);
          goto _L18
_L9:
        if("Keyboard".equals(s))
            parseKeyboardAttributes(resources, xmlresourceparser);
          goto _L7
_L4:
        if(l != 3) goto _L7; else goto _L19
_L19:
        if(!flag) goto _L21; else goto _L20
_L20:
        flag = false;
        j += key.gap + key.width;
        if(j > mTotalWidth)
            mTotalWidth = j;
          goto _L7
_L21:
        if(!flag1) goto _L7; else goto _L22
_L22:
        int i1;
        flag1 = false;
        k += row.verticalGap;
        i1 = row.defaultHeight;
        k += i1;
        i++;
          goto _L7
        flag2 = false;
          goto _L23
    }

    private void parseKeyboardAttributes(Resources resources, XmlResourceParser xmlresourceparser) {
        TypedArray typedarray = resources.obtainAttributes(Xml.asAttributeSet(xmlresourceparser), com.android.internal.R.styleable.Keyboard);
        mDefaultWidth = getDimensionOrFraction(typedarray, 0, mDisplayWidth, mDisplayWidth / 10);
        mDefaultHeight = getDimensionOrFraction(typedarray, 1, mDisplayHeight, 50);
        mDefaultHorizontalGap = getDimensionOrFraction(typedarray, 2, mDisplayWidth, 0);
        mDefaultVerticalGap = getDimensionOrFraction(typedarray, 3, mDisplayHeight, 0);
        mProximityThreshold = (int)((float)mDefaultWidth * SEARCH_DISTANCE);
        mProximityThreshold = mProximityThreshold * mProximityThreshold;
        typedarray.recycle();
    }

    private void skipToEndOfRow(XmlResourceParser xmlresourceparser) throws XmlPullParserException, IOException {
        int i;
        do
            i = xmlresourceparser.next();
        while(i != 1 && (i != 3 || !xmlresourceparser.getName().equals("Row")));
    }

    protected Key createKeyFromXml(Resources resources, Row row, int i, int j, XmlResourceParser xmlresourceparser) {
        return new Key(resources, row, i, j, xmlresourceparser);
    }

    protected Row createRowFromXml(Resources resources, XmlResourceParser xmlresourceparser) {
        return new Row(resources, this, xmlresourceparser);
    }

    public int getHeight() {
        return mTotalHeight;
    }

    protected int getHorizontalGap() {
        return mDefaultHorizontalGap;
    }

    protected int getKeyHeight() {
        return mDefaultHeight;
    }

    protected int getKeyWidth() {
        return mDefaultWidth;
    }

    public List getKeys() {
        return mKeys;
    }

    public int getMinWidth() {
        return mTotalWidth;
    }

    public List getModifierKeys() {
        return mModifierKeys;
    }

    public int[] getNearestKeys(int i, int j) {
        if(mGridNeighbors == null)
            computeNearestNeighbors();
        if(i < 0 || i >= getMinWidth() || j < 0 || j >= getHeight()) goto _L2; else goto _L1
_L1:
        int k = 10 * (j / mCellHeight) + i / mCellWidth;
        if(k >= 50) goto _L2; else goto _L3
_L3:
        int ai[] = mGridNeighbors[k];
_L5:
        return ai;
_L2:
        ai = new int[0];
        if(true) goto _L5; else goto _L4
_L4:
    }

    public int getShiftKeyIndex() {
        return mShiftKeyIndices[0];
    }

    public int[] getShiftKeyIndices() {
        return mShiftKeyIndices;
    }

    protected int getVerticalGap() {
        return mDefaultVerticalGap;
    }

    public boolean isShifted() {
        return mShifted;
    }

    final void resize(int i, int j) {
        int k = rows.size();
        for(int l = 0; l < k; l++) {
            Row row = (Row)rows.get(l);
            int i1 = row.mKeys.size();
            int j1 = 0;
            int k1 = 0;
            for(int l1 = 0; l1 < i1; l1++) {
                Key key1 = (Key)row.mKeys.get(l1);
                if(l1 > 0)
                    j1 += key1.gap;
                k1 += key1.width;
            }

            if(j1 + k1 <= i)
                continue;
            int i2 = 0;
            float f = (float)(i - j1) / (float)k1;
            for(int j2 = 0; j2 < i1; j2++) {
                Key key = (Key)row.mKeys.get(j2);
                key.width = (int)(f * (float)key.width);
                key.x = i2;
                i2 += key.width + key.gap;
            }

        }

        mTotalWidth = i;
    }

    protected void setHorizontalGap(int i) {
        mDefaultHorizontalGap = i;
    }

    protected void setKeyHeight(int i) {
        mDefaultHeight = i;
    }

    protected void setKeyWidth(int i) {
        mDefaultWidth = i;
    }

    public boolean setShifted(boolean flag) {
        Key akey[] = mShiftKeys;
        int i = akey.length;
        for(int j = 0; j < i; j++) {
            Key key = akey[j];
            if(key != null)
                key.on = flag;
        }

        boolean flag1;
        if(mShifted != flag) {
            mShifted = flag;
            flag1 = true;
        } else {
            flag1 = false;
        }
        return flag1;
    }

    protected void setVerticalGap(int i) {
        mDefaultVerticalGap = i;
    }

    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_TOP = 4;
    private static final int GRID_HEIGHT = 5;
    private static final int GRID_SIZE = 50;
    private static final int GRID_WIDTH = 10;
    public static final int KEYCODE_ALT = -6;
    public static final int KEYCODE_CANCEL = -3;
    public static final int KEYCODE_DELETE = -5;
    public static final int KEYCODE_DONE = -4;
    public static final int KEYCODE_MODE_CHANGE = -2;
    public static final int KEYCODE_SHIFT = -1;
    private static float SEARCH_DISTANCE = 0F;
    static final String TAG = "Keyboard";
    private static final String TAG_KEY = "Key";
    private static final String TAG_KEYBOARD = "Keyboard";
    private static final String TAG_ROW = "Row";
    private int mCellHeight;
    private int mCellWidth;
    private int mDefaultHeight;
    private int mDefaultHorizontalGap;
    private int mDefaultVerticalGap;
    private int mDefaultWidth;
    private int mDisplayHeight;
    private int mDisplayWidth;
    private int mGridNeighbors[][];
    private int mKeyHeight;
    private int mKeyWidth;
    private int mKeyboardMode;
    private List mKeys;
    private CharSequence mLabel;
    private List mModifierKeys;
    private int mProximityThreshold;
    private int mShiftKeyIndices[];
    private Key mShiftKeys[];
    private boolean mShifted;
    private int mTotalHeight;
    private int mTotalWidth;
    private ArrayList rows;

    static  {
        SEARCH_DISTANCE = 1.8F;
    }






}
