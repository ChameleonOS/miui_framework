// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.res;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import com.android.internal.util.XmlUtils;
import java.util.Arrays;

// Referenced classes of package android.content.res:
//            Resources, AssetManager, ColorStateList

public class TypedArray {

    TypedArray(Resources resources, int ai[], int ai1[], int i) {
        mValue = new TypedValue();
        mResources = resources;
        mData = ai;
        mIndices = ai1;
        mLength = i;
    }

    private boolean getValueAt(int i, TypedValue typedvalue) {
        int ai[] = mData;
        int j = ai[i + 0];
        boolean flag;
        if(j == 0) {
            flag = false;
        } else {
            typedvalue.type = j;
            typedvalue.data = ai[i + 1];
            typedvalue.assetCookie = ai[i + 2];
            typedvalue.resourceId = ai[i + 3];
            typedvalue.changingConfigurations = ai[i + 4];
            typedvalue.density = ai[i + 5];
            CharSequence charsequence;
            if(j == 3)
                charsequence = loadStringValueAt(i);
            else
                charsequence = null;
            typedvalue.string = charsequence;
            flag = true;
        }
        return flag;
    }

    private CharSequence loadStringValueAt(int i) {
        int ai[] = mData;
        int j = ai[i + 2];
        CharSequence charsequence;
        if(j < 0) {
            if(mXml != null)
                charsequence = mXml.getPooledString(ai[i + 1]);
            else
                charsequence = null;
        } else {
            charsequence = mResources.mAssets.getPooledString(j, ai[i + 1]);
        }
        return charsequence;
    }

    public boolean getBoolean(int i, boolean flag) {
        int j = i * 6;
        int ai[] = mData;
        int k = ai[j + 0];
        if(k != 0)
            if(k >= 16 && k <= 31) {
                boolean flag1;
                if(ai[j + 1] != 0)
                    flag1 = true;
                else
                    flag1 = false;
                flag = flag1;
            } else {
                TypedValue typedvalue = mValue;
                if(getValueAt(j, typedvalue)) {
                    Log.w("Resources", (new StringBuilder()).append("Converting to boolean: ").append(typedvalue).toString());
                    flag = XmlUtils.convertValueToBoolean(typedvalue.coerceToString(), flag);
                } else {
                    Log.w("Resources", (new StringBuilder()).append("getBoolean of bad type: 0x").append(Integer.toHexString(k)).toString());
                }
            }
        return flag;
    }

    public int getColor(int i, int j) {
        int k;
        int ai[];
        int l;
        k = i * 6;
        ai = mData;
        l = ai[k + 0];
        if(l != 0) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        if(l >= 16 && l <= 31) {
            j = ai[k + 1];
            continue; /* Loop/switch isn't completed */
        }
        if(l != 3)
            break; /* Loop/switch isn't completed */
        TypedValue typedvalue = mValue;
        if(getValueAt(k, typedvalue))
            j = mResources.loadColorStateList(typedvalue, typedvalue.resourceId).getDefaultColor();
        if(true) goto _L1; else goto _L3
_L3:
        throw new UnsupportedOperationException((new StringBuilder()).append("Can't convert to color: type=0x").append(Integer.toHexString(l)).toString());
    }

    public ColorStateList getColorStateList(int i) {
        TypedValue typedvalue = mValue;
        ColorStateList colorstatelist;
        if(getValueAt(i * 6, typedvalue))
            colorstatelist = mResources.loadColorStateList(typedvalue, typedvalue.resourceId);
        else
            colorstatelist = null;
        return colorstatelist;
    }

    public float getDimension(int i, float f) {
        int j = i * 6;
        int ai[] = mData;
        int k = ai[j + 0];
        if(k != 0)
            if(k == 5)
                f = TypedValue.complexToDimension(ai[j + 1], mResources.mMetrics);
            else
                throw new UnsupportedOperationException((new StringBuilder()).append("Can't convert to dimension: type=0x").append(Integer.toHexString(k)).toString());
        return f;
    }

    public int getDimensionPixelOffset(int i, int j) {
        int k = i * 6;
        int ai[] = mData;
        int l = ai[k + 0];
        if(l != 0)
            if(l == 5)
                j = TypedValue.complexToDimensionPixelOffset(ai[k + 1], mResources.mMetrics);
            else
                throw new UnsupportedOperationException((new StringBuilder()).append("Can't convert to dimension: type=0x").append(Integer.toHexString(l)).toString());
        return j;
    }

    public int getDimensionPixelSize(int i, int j) {
        int k = i * 6;
        int ai[] = mData;
        int l = ai[k + 0];
        if(l != 0)
            if(l == 5)
                j = TypedValue.complexToDimensionPixelSize(ai[k + 1], mResources.mMetrics);
            else
                throw new UnsupportedOperationException((new StringBuilder()).append("Can't convert to dimension: type=0x").append(Integer.toHexString(l)).toString());
        return j;
    }

    public Drawable getDrawable(int i) {
        TypedValue typedvalue = mValue;
        Drawable drawable;
        if(getValueAt(i * 6, typedvalue))
            drawable = mResources.loadDrawable(typedvalue, typedvalue.resourceId);
        else
            drawable = null;
        return drawable;
    }

    public float getFloat(int i, float f) {
        int j;
        int ai[];
        int k;
        j = i * 6;
        ai = mData;
        k = ai[j + 0];
        if(k != 0) goto _L2; else goto _L1
_L1:
        return f;
_L2:
        if(k == 4) {
            f = Float.intBitsToFloat(ai[j + 1]);
            continue; /* Loop/switch isn't completed */
        }
        if(k >= 16 && k <= 31) {
            f = ai[j + 1];
            continue; /* Loop/switch isn't completed */
        }
        TypedValue typedvalue = mValue;
        if(getValueAt(j, typedvalue)) {
            Log.w("Resources", (new StringBuilder()).append("Converting to float: ").append(typedvalue).toString());
            CharSequence charsequence = typedvalue.coerceToString();
            if(charsequence != null) {
                f = Float.parseFloat(charsequence.toString());
                continue; /* Loop/switch isn't completed */
            }
        }
        Log.w("Resources", (new StringBuilder()).append("getFloat of bad type: 0x").append(Integer.toHexString(k)).toString());
        if(true) goto _L1; else goto _L3
_L3:
    }

    public float getFraction(int i, int j, int k, float f) {
        int l = i * 6;
        int ai[] = mData;
        int i1 = ai[l + 0];
        if(i1 != 0)
            if(i1 == 6)
                f = TypedValue.complexToFraction(ai[l + 1], j, k);
            else
                throw new UnsupportedOperationException((new StringBuilder()).append("Can't convert to fraction: type=0x").append(Integer.toHexString(i1)).toString());
        return f;
    }

    public int getIndex(int i) {
        return mIndices[i + 1];
    }

    public int getIndexCount() {
        return mIndices[0];
    }

    public int getInt(int i, int j) {
        int k = i * 6;
        int ai[] = mData;
        int l = ai[k + 0];
        if(l != 0)
            if(l >= 16 && l <= 31) {
                j = ai[k + 1];
            } else {
                TypedValue typedvalue = mValue;
                if(getValueAt(k, typedvalue)) {
                    Log.w("Resources", (new StringBuilder()).append("Converting to int: ").append(typedvalue).toString());
                    j = XmlUtils.convertValueToInt(typedvalue.coerceToString(), j);
                } else {
                    Log.w("Resources", (new StringBuilder()).append("getInt of bad type: 0x").append(Integer.toHexString(l)).toString());
                }
            }
        return j;
    }

    public int getInteger(int i, int j) {
        int k = i * 6;
        int ai[] = mData;
        int l = ai[k + 0];
        if(l != 0)
            if(l >= 16 && l <= 31)
                j = ai[k + 1];
            else
                throw new UnsupportedOperationException((new StringBuilder()).append("Can't convert to integer: type=0x").append(Integer.toHexString(l)).toString());
        return j;
    }

    public int getLayoutDimension(int i, int j) {
        int k;
        int ai[];
        int l;
        k = i * 6;
        ai = mData;
        l = ai[k + 0];
        if(l < 16 || l > 31) goto _L2; else goto _L1
_L1:
        j = ai[k + 1];
_L4:
        return j;
_L2:
        if(l == 5)
            j = TypedValue.complexToDimensionPixelSize(ai[k + 1], mResources.mMetrics);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getLayoutDimension(int i, String s) {
        int j = i * 6;
        int ai[] = mData;
        int k = ai[j + 0];
        int l;
        if(k >= 16 && k <= 31)
            l = ai[j + 1];
        else
        if(k == 5)
            l = TypedValue.complexToDimensionPixelSize(ai[j + 1], mResources.mMetrics);
        else
            throw new RuntimeException((new StringBuilder()).append(getPositionDescription()).append(": You must supply a ").append(s).append(" attribute.").toString());
        return l;
    }

    public String getNonConfigurationString(int i, int j) {
        String s;
        int k;
        int ai[];
        int l;
        s = null;
        k = i * 6;
        ai = mData;
        l = ai[k + 0];
        break MISSING_BLOCK_LABEL_23;
        while(true)  {
            do
                return s;
            while((ai[k + 4] & ~j) != 0 || l == 0);
            if(l == 3) {
                s = loadStringValueAt(k).toString();
            } else {
                TypedValue typedvalue = mValue;
                if(getValueAt(k, typedvalue)) {
                    Log.w("Resources", (new StringBuilder()).append("Converting to string: ").append(typedvalue).toString());
                    CharSequence charsequence = typedvalue.coerceToString();
                    if(charsequence != null)
                        s = charsequence.toString();
                } else {
                    Log.w("Resources", (new StringBuilder()).append("getString of bad type: 0x").append(Integer.toHexString(l)).toString());
                }
            }
        }
    }

    public String getNonResourceString(int i) {
        int j = i * 6;
        int ai[] = mData;
        String s;
        if(ai[j + 0] == 3 && ai[j + 2] < 0)
            s = mXml.getPooledString(ai[j + 1]).toString();
        else
            s = null;
        return s;
    }

    public String getPositionDescription() {
        String s;
        if(mXml != null)
            s = mXml.getPositionDescription();
        else
            s = "<internal>";
        return s;
    }

    public int getResourceId(int i, int j) {
        int k;
        int ai[];
        k = i * 6;
        ai = mData;
        if(ai[k + 0] == 0) goto _L2; else goto _L1
_L1:
        int l = ai[k + 3];
        if(l == 0) goto _L2; else goto _L3
_L3:
        return l;
_L2:
        l = j;
        if(true) goto _L3; else goto _L4
_L4:
    }

    public Resources getResources() {
        return mResources;
    }

    public String getString(int i) {
        String s;
        int j;
        int k;
        s = null;
        j = i * 6;
        k = mData[j + 0];
        if(k != 0) goto _L2; else goto _L1
_L1:
        return s;
_L2:
        if(k == 3) {
            s = loadStringValueAt(j).toString();
        } else {
            TypedValue typedvalue = mValue;
            if(getValueAt(j, typedvalue)) {
                Log.w("Resources", (new StringBuilder()).append("Converting to string: ").append(typedvalue).toString());
                CharSequence charsequence = typedvalue.coerceToString();
                if(charsequence != null)
                    s = charsequence.toString();
            } else {
                Log.w("Resources", (new StringBuilder()).append("getString of bad type: 0x").append(Integer.toHexString(k)).toString());
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public CharSequence getText(int i) {
        CharSequence charsequence = null;
        int j = i * 6;
        int k = mData[j + 0];
        if(k != 0)
            if(k == 3) {
                charsequence = loadStringValueAt(j);
            } else {
                TypedValue typedvalue = mValue;
                if(getValueAt(j, typedvalue)) {
                    Log.w("Resources", (new StringBuilder()).append("Converting to string: ").append(typedvalue).toString());
                    charsequence = typedvalue.coerceToString();
                } else {
                    Log.w("Resources", (new StringBuilder()).append("getString of bad type: 0x").append(Integer.toHexString(k)).toString());
                }
            }
        return charsequence;
    }

    public CharSequence[] getTextArray(int i) {
        TypedValue typedvalue = mValue;
        CharSequence acharsequence[];
        if(getValueAt(i * 6, typedvalue))
            acharsequence = mResources.getTextArray(typedvalue.resourceId);
        else
            acharsequence = null;
        return acharsequence;
    }

    public boolean getValue(int i, TypedValue typedvalue) {
        return getValueAt(i * 6, typedvalue);
    }

    public boolean hasValue(int i) {
        int j = i * 6;
        boolean flag;
        if(mData[j + 0] != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public int length() {
        return mLength;
    }

    public TypedValue peekValue(int i) {
        TypedValue typedvalue = mValue;
        if(!getValueAt(i * 6, typedvalue))
            typedvalue = null;
        return typedvalue;
    }

    public void recycle() {
        TypedValue typedvalue = mResources.mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        TypedArray typedarray = mResources.mCachedStyledAttributes;
        if(typedarray == null || typedarray.mData.length < mData.length) {
            mXml = null;
            mResources.mCachedStyledAttributes = this;
        }
        return;
    }

    public String toString() {
        return Arrays.toString(mData);
    }

    int mData[];
    int mIndices[];
    int mLength;
    private final Resources mResources;
    int mRsrcs[];
    TypedValue mValue;
    XmlBlock.Parser mXml;
}
