// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.res;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.*;
import com.android.internal.util.ArrayUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.content.res:
//            Resources

public class ColorStateList
    implements Parcelable {

    private ColorStateList() {
        mDefaultColor = 0xffff0000;
    }

    public ColorStateList(int ai[][], int ai1[]) {
        mDefaultColor = 0xffff0000;
        mStateSpecs = ai;
        mColors = ai1;
        if(ai.length > 0) {
            mDefaultColor = ai1[0];
            for(int i = 0; i < ai.length; i++)
                if(ai[i].length == 0)
                    mDefaultColor = ai1[i];

        }
    }

    public static ColorStateList createFromXml(Resources resources, XmlPullParser xmlpullparser) throws XmlPullParserException, IOException {
        AttributeSet attributeset = Xml.asAttributeSet(xmlpullparser);
        int i;
        do
            i = xmlpullparser.next();
        while(i != 2 && i != 1);
        if(i != 2)
            throw new XmlPullParserException("No start tag found");
        else
            return createFromXmlInner(resources, xmlpullparser, attributeset);
    }

    private static ColorStateList createFromXmlInner(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        String s = xmlpullparser.getName();
        if(s.equals("selector")) {
            ColorStateList colorstatelist = new ColorStateList();
            colorstatelist.inflate(resources, xmlpullparser, attributeset);
            return colorstatelist;
        } else {
            throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": invalid drawable tag ").append(s).toString());
        }
    }

    private void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        int i;
        int j;
        int k;
        int ai[];
        int ai1[][];
        i = 1 + xmlpullparser.getDepth();
        j = 20;
        k = 0;
        ai = new int[j];
        ai1 = new int[j][];
_L10:
        int j1;
        int k1;
        boolean flag;
        int l1;
        int ai3[];
        int i2;
        int j2;
        int l = xmlpullparser.next();
        if(l == 1)
            break MISSING_BLOCK_LABEL_389;
        int i1 = xmlpullparser.getDepth();
        if(i1 < i && l == 3)
            break MISSING_BLOCK_LABEL_389;
        if(l != 2 || i1 > i || !xmlpullparser.getName().equals("item"))
            continue; /* Loop/switch isn't completed */
        j1 = 0;
        k1 = 0xffff0000;
        flag = false;
        l1 = attributeset.getAttributeCount();
        ai3 = new int[l1];
        i2 = 0;
        j2 = 0;
_L6:
        if(i2 >= l1) goto _L2; else goto _L1
_L1:
        int k2 = attributeset.getAttributeNameResource(i2);
        if(k2 != 0) goto _L3; else goto _L2
_L2:
        int ai4[] = StateSet.trimStateSet(ai3, j2);
        if(j1 == 0) goto _L5; else goto _L4
_L4:
        k1 = resources.getColor(j1);
_L8:
        if(k == 0 || ai4.length == 0)
            mDefaultColor = k1;
        if(k + 1 >= j) {
            j = ArrayUtils.idealIntArraySize(k + 1);
            int ai5[] = new int[j];
            System.arraycopy(ai, 0, ai5, 0, k);
            int ai6[][] = new int[j][];
            System.arraycopy(ai1, 0, ai6, 0, k);
            ai = ai5;
            ai1 = ai6;
        }
        ai[k] = k1;
        ai1[k] = ai4;
        k++;
        continue; /* Loop/switch isn't completed */
_L3:
        if(k2 == 0x10101a5) {
            j1 = attributeset.getAttributeResourceValue(i2, 0);
            int ai2[][];
            int l2;
            if(j1 == 0) {
                k1 = attributeset.getAttributeIntValue(i2, k1);
                flag = true;
                l2 = j2;
            } else {
                l2 = j2;
            }
        } else {
            l2 = j2 + 1;
            if(!attributeset.getAttributeBooleanValue(i2, false))
                k2 = -k2;
            ai3[j2] = k2;
        }
        i2++;
        j2 = l2;
          goto _L6
_L5:
        if(flag) goto _L8; else goto _L7
_L7:
        throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": <item> tag requires a 'android:color' attribute.").toString());
        mColors = new int[k];
        mStateSpecs = new int[k][];
        System.arraycopy(ai, 0, mColors, 0, k);
        ai2 = mStateSpecs;
        System.arraycopy(ai1, 0, ai2, 0, k);
        return;
        if(true) goto _L10; else goto _L9
_L9:
    }

    public static ColorStateList valueOf(int i) {
        SparseArray sparsearray = sCache;
        sparsearray;
        JVM INSTR monitorenter ;
        WeakReference weakreference = (WeakReference)sCache.get(i);
        ColorStateList colorstatelist;
        ColorStateList colorstatelist2;
        if(weakreference != null)
            colorstatelist = (ColorStateList)weakreference.get();
        else
            colorstatelist = null;
        if(colorstatelist != null) {
            colorstatelist2 = colorstatelist;
        } else {
            int ai[][] = EMPTY;
            int ai1[] = new int[1];
            ai1[0] = i;
            ColorStateList colorstatelist1 = new ColorStateList(ai, ai1);
            sCache.put(i, new WeakReference(colorstatelist1));
            colorstatelist2 = colorstatelist1;
        }
        return colorstatelist2;
    }

    public int describeContents() {
        return 0;
    }

    public int getColorForState(int ai[], int i) {
        int j = mStateSpecs.length;
        int k = 0;
        do {
label0:
            {
                if(k < j) {
                    if(!StateSet.stateSetMatches(mStateSpecs[k], ai))
                        break label0;
                    i = mColors[k];
                }
                return i;
            }
            k++;
        } while(true);
    }

    public int getDefaultColor() {
        return mDefaultColor;
    }

    public boolean isStateful() {
        boolean flag = true;
        if(mStateSpecs.length <= flag)
            flag = false;
        return flag;
    }

    public String toString() {
        return (new StringBuilder()).append("ColorStateList{mStateSpecs=").append(Arrays.deepToString(mStateSpecs)).append("mColors=").append(Arrays.toString(mColors)).append("mDefaultColor=").append(mDefaultColor).append('}').toString();
    }

    public ColorStateList withAlpha(int i) {
        int ai[] = new int[mColors.length];
        int j = ai.length;
        for(int k = 0; k < j; k++)
            ai[k] = 0xffffff & mColors[k] | i << 24;

        return new ColorStateList(mStateSpecs, ai);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = mStateSpecs.length;
        parcel.writeInt(j);
        for(int k = 0; k < j; k++)
            parcel.writeIntArray(mStateSpecs[k]);

        parcel.writeIntArray(mColors);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ColorStateList createFromParcel(Parcel parcel) {
            int i = parcel.readInt();
            int ai1[][] = new int[i][];
            for(int j = 0; j < i; j++)
                ai1[j] = parcel.createIntArray();

            return new ColorStateList(ai1, parcel.createIntArray());
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ColorStateList[] newArray(int i) {
            return new ColorStateList[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final int EMPTY[][];
    private static final SparseArray sCache = new SparseArray();
    private int mColors[];
    private int mDefaultColor;
    private int mStateSpecs[][];

    static  {
        int ai[][] = new int[1][];
        ai[0] = new int[0];
        EMPTY = ai;
    }
}
