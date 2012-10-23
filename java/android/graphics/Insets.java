// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            Rect

public class Insets {

    private Insets(int i, int j, int k, int l) {
        left = i;
        top = j;
        right = k;
        bottom = l;
    }

    public static Insets of(int i, int j, int k, int l) {
        Insets insets;
        if(i == 0 && j == 0 && k == 0 && l == 0)
            insets = NONE;
        else
            insets = new Insets(i, j, k, l);
        return insets;
    }

    public static Insets of(Rect rect) {
        Insets insets;
        if(rect == null)
            insets = NONE;
        else
            insets = of(rect.left, rect.top, rect.right, rect.bottom);
        return insets;
    }

    public boolean equals(Object obj) {
        boolean flag = true;
        if(this != obj) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(obj == null || getClass() != obj.getClass()) {
            flag = false;
        } else {
            Insets insets = (Insets)obj;
            if(bottom != insets.bottom)
                flag = false;
            else
            if(left != insets.left)
                flag = false;
            else
            if(right != insets.right)
                flag = false;
            else
            if(top != insets.top)
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int hashCode() {
        return 31 * (31 * (31 * left + top) + right) + bottom;
    }

    public String toString() {
        return (new StringBuilder()).append("Insets{left=").append(left).append(", top=").append(top).append(", right=").append(right).append(", bottom=").append(bottom).append('}').toString();
    }

    public static final Insets NONE = new Insets(0, 0, 0, 0);
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

}
