// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.res;


// Referenced classes of package android.content.res:
//            TypedArray, MiuiResources, Resources

public class MiuiTypedArray extends TypedArray {

    MiuiTypedArray(Resources resources, int ai[], int ai1[], int i) {
        super(resources, ai, ai1, i);
        mIsMiuiResources = getResources() instanceof MiuiResources;
    }

    private CharSequence loadStringValueAt(int i) {
        if(mIsMiuiResources) goto _L2; else goto _L1
_L1:
        CharSequence charsequence = null;
_L4:
        return charsequence;
_L2:
        if(super.mData[i + 0] == 3) {
            int j = super.mData[i + 3];
            charsequence = ((MiuiResources)getResources()).getThemeCharSequence(j);
            if(charsequence != null)
                continue; /* Loop/switch isn't completed */
        }
        charsequence = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public String getString(int i) {
        CharSequence charsequence = loadStringValueAt(i * 6);
        String s;
        if(charsequence != null)
            s = charsequence.toString();
        else
            s = super.getString(i);
        return s;
    }

    public CharSequence getText(int i) {
        CharSequence charsequence = loadStringValueAt(i * 6);
        if(charsequence == null)
            charsequence = super.getText(i);
        return charsequence;
    }

    private boolean mIsMiuiResources;
}
