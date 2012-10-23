// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            Parcelable, Parcel

public class PatternMatcher
    implements Parcelable {

    public PatternMatcher(Parcel parcel) {
        mPattern = parcel.readString();
        mType = parcel.readInt();
    }

    public PatternMatcher(String s, int i) {
        mPattern = s;
        mType = i;
    }

    static boolean matchPattern(String s, String s1, int i) {
        int j;
        int k;
        j = 1;
        k = 0;
        if(s1 != null) goto _L2; else goto _L1
_L1:
        return k;
_L2:
        int l;
        int i1;
        int j1;
        int k1;
        char c;
        if(i == 0) {
            k = s.equals(s1);
            continue; /* Loop/switch isn't completed */
        }
        if(i == j) {
            k = s1.startsWith(s);
            continue; /* Loop/switch isn't completed */
        }
        if(i != 2)
            continue; /* Loop/switch isn't completed */
        l = s.length();
        if(l <= 0) {
            if(s1.length() > 0)
                j = 0;
            k = j;
            continue; /* Loop/switch isn't completed */
        }
        i1 = s1.length();
        j1 = 0;
        k1 = 0;
        c = s.charAt(0);
_L4:
        char c1;
        if(j1 >= l || k1 >= i1)
            break; /* Loop/switch isn't completed */
        c1 = c;
        int l1;
        if(++j1 < l)
            c = s.charAt(j1);
        else
            c = '\0';
        if(c1 == '\\')
            l1 = j;
        else
            l1 = 0;
        if(l1 != 0) {
            c1 = c;
            if(++j1 < l)
                c = s.charAt(j1);
            else
                c = '\0';
        }
        if(c != '*')
            break MISSING_BLOCK_LABEL_379;
        if(l1 != 0 || c1 != '.')
            break MISSING_BLOCK_LABEL_328;
        if(j1 >= l - 1) {
            k = j;
            continue; /* Loop/switch isn't completed */
        }
        int i2 = j1 + 1;
        char c2 = s.charAt(i2);
        if(c2 == '\\')
            if(++i2 < l)
                c2 = s.charAt(i2);
            else
                c2 = '\0';
        break MISSING_BLOCK_LABEL_258;
        while(s1.charAt(k1) != c2 && ++k1 < i1) ;
        if(k1 == i1)
            continue; /* Loop/switch isn't completed */
        j1 = i2 + 1;
        if(j1 < l)
            c = s.charAt(j1);
        else
            c = '\0';
        k1++;
        continue; /* Loop/switch isn't completed */
        while(s1.charAt(k1) == c1 && ++k1 < i1) ;
        if(++j1 < l)
            c = s.charAt(j1);
        else
            c = '\0';
        continue; /* Loop/switch isn't completed */
        if(c1 != '.' && s1.charAt(k1) != c1)
            continue; /* Loop/switch isn't completed */
        k1++;
        if(true) goto _L4; else goto _L3
_L3:
        if(j1 >= l && k1 >= i1)
            k = j;
        else
        if(j1 == l - 2 && s.charAt(j1) == '.' && s.charAt(j1 + 1) == '*')
            k = j;
        if(true) goto _L1; else goto _L5
_L5:
    }

    public int describeContents() {
        return 0;
    }

    public final String getPath() {
        return mPattern;
    }

    public final int getType() {
        return mType;
    }

    public boolean match(String s) {
        return matchPattern(mPattern, s, mType);
    }

    public String toString() {
        String s = "? ";
        mType;
        JVM INSTR tableswitch 0 2: default 32
    //                   0 64
    //                   1 70
    //                   2 76;
           goto _L1 _L2 _L3 _L4
_L1:
        return (new StringBuilder()).append("PatternMatcher{").append(s).append(mPattern).append("}").toString();
_L2:
        s = "LITERAL: ";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "PREFIX: ";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "GLOB: ";
        if(true) goto _L1; else goto _L5
_L5:
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mPattern);
        parcel.writeInt(mType);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public PatternMatcher createFromParcel(Parcel parcel) {
            return new PatternMatcher(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public PatternMatcher[] newArray(int i) {
            return new PatternMatcher[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int PATTERN_LITERAL = 0;
    public static final int PATTERN_PREFIX = 1;
    public static final int PATTERN_SIMPLE_GLOB = 2;
    private final String mPattern;
    private final int mType;

}
