// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            Parcelable, Parcel

public class WorkSource
    implements Parcelable {

    public WorkSource() {
        mNum = 0;
    }

    public WorkSource(int i) {
        mNum = 1;
        int ai[] = new int[2];
        ai[0] = i;
        ai[1] = 0;
        mUids = ai;
    }

    WorkSource(Parcel parcel) {
        mNum = parcel.readInt();
        mUids = parcel.createIntArray();
    }

    public WorkSource(WorkSource worksource) {
        if(worksource == null) {
            mNum = 0;
        } else {
            mNum = worksource.mNum;
            if(worksource.mUids != null)
                mUids = (int[])worksource.mUids.clone();
            else
                mUids = null;
        }
    }

    private void addLocked(int i) {
        if(mUids == null) {
            mUids = new int[4];
            mUids[0] = i;
            mNum = 1;
        } else {
            if(mNum >= mUids.length) {
                int ai[] = new int[(3 * mNum) / 2];
                System.arraycopy(mUids, 0, ai, 0, mNum);
                mUids = ai;
            }
            mUids[mNum] = i;
            mNum = 1 + mNum;
        }
    }

    private boolean updateLocked(WorkSource worksource, boolean flag, boolean flag1) {
        int i;
        int ai[];
        int j;
        int ai1[];
        boolean flag2;
        int k;
        int l;
        i = mNum;
        ai = mUids;
        j = worksource.mNum;
        ai1 = worksource.mUids;
        flag2 = false;
        k = 0;
        l = 0;
_L7:
        if(l >= j) goto _L2; else goto _L1
_L1:
        if(k < i && ai1[l] >= ai[k]) goto _L4; else goto _L3
_L3:
        flag2 = true;
        if(ai == null) {
            ai = new int[4];
            ai[0] = ai1[l];
        } else
        if(k >= ai.length) {
            int ai2[] = new int[(3 * ai.length) / 2];
            if(k > 0)
                System.arraycopy(ai, 0, ai2, 0, k);
            if(k < i)
                System.arraycopy(ai, k, ai2, k + 1, i - k);
            ai = ai2;
            ai[k] = ai1[l];
        } else {
            if(k < i)
                System.arraycopy(ai, k, ai, k + 1, i - k);
            ai[k] = ai1[l];
        }
        if(flag1)
            if(sNewbWork == null)
                sNewbWork = new WorkSource(ai1[l]);
            else
                sNewbWork.addLocked(ai1[l]);
        i++;
        k++;
_L5:
        l++;
        continue; /* Loop/switch isn't completed */
_L4:
        if(!flag) {
            while(++k < i && ai1[l] >= ai[k]) ;
        } else {
            int i1 = k;
            while(k < i && ai1[l] > ai[k])  {
                if(sGoneWork == null)
                    sGoneWork = new WorkSource(ai[k]);
                else
                    sGoneWork.addLocked(ai[k]);
                k++;
            }
            if(i1 < k) {
                System.arraycopy(ai, k, ai, i1, k - i1);
                i -= k - i1;
                k = i1;
            }
            if(k < i && ai1[k] == ai[k])
                k++;
        }
        if(true) goto _L5; else goto _L2
_L2:
        mNum = i;
        mUids = ai;
        return flag2;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public boolean add(int i) {
        WorkSource worksource = sTmpWorkSource;
        worksource;
        JVM INSTR monitorenter ;
        sTmpWorkSource.mUids[0] = i;
        boolean flag = updateLocked(sTmpWorkSource, false, false);
        return flag;
    }

    public boolean add(WorkSource worksource) {
        WorkSource worksource1 = sTmpWorkSource;
        worksource1;
        JVM INSTR monitorenter ;
        boolean flag = updateLocked(worksource, false, false);
        return flag;
    }

    public WorkSource addReturningNewbs(int i) {
        WorkSource worksource = sTmpWorkSource;
        worksource;
        JVM INSTR monitorenter ;
        sNewbWork = null;
        sTmpWorkSource.mUids[0] = i;
        updateLocked(sTmpWorkSource, false, true);
        WorkSource worksource1 = sNewbWork;
        return worksource1;
    }

    public WorkSource addReturningNewbs(WorkSource worksource) {
        WorkSource worksource1 = sTmpWorkSource;
        worksource1;
        JVM INSTR monitorenter ;
        sNewbWork = null;
        updateLocked(worksource, false, true);
        WorkSource worksource2 = sNewbWork;
        return worksource2;
    }

    public void clear() {
        mNum = 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean diff(WorkSource worksource) {
        boolean flag;
        int i;
        flag = true;
        i = mNum;
        if(i == worksource.mNum) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int ai[] = mUids;
        int ai1[] = worksource.mUids;
        for(int j = 0; j < i; j++)
            if(ai[j] != ai1[j])
                continue; /* Loop/switch isn't completed */

        flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int get(int i) {
        return mUids[i];
    }

    public boolean remove(WorkSource worksource) {
        int i = mNum;
        int ai[] = mUids;
        int j = worksource.mNum;
        int ai1[] = worksource.mUids;
        int k = 0;
        for(int l = 0; l < j && k < i; l++) {
            if(ai1[l] == ai[k]) {
                i--;
                if(k < i)
                    System.arraycopy(ai, k + 1, ai, k, i - k);
            }
            for(; k < i && ai1[l] > ai[k]; k++);
        }

        mNum = i;
        return false;
    }

    public void set(int i) {
        mNum = 1;
        if(mUids == null)
            mUids = new int[2];
        mUids[0] = i;
    }

    public void set(WorkSource worksource) {
        if(worksource == null) {
            mNum = 0;
        } else {
            mNum = worksource.mNum;
            if(worksource.mUids != null) {
                if(mUids != null && mUids.length >= mNum)
                    System.arraycopy(worksource.mUids, 0, mUids, 0, mNum);
                else
                    mUids = (int[])worksource.mUids.clone();
            } else {
                mUids = null;
            }
        }
    }

    public WorkSource[] setReturningDiffs(WorkSource worksource) {
        WorkSource aworksource[] = null;
        WorkSource worksource1 = sTmpWorkSource;
        worksource1;
        JVM INSTR monitorenter ;
        sNewbWork = null;
        sGoneWork = null;
        updateLocked(worksource, true, true);
        if(sNewbWork != null || sGoneWork != null) {
            aworksource = new WorkSource[2];
            aworksource[0] = sNewbWork;
            aworksource[1] = sGoneWork;
        }
        return aworksource;
    }

    public int size() {
        return mNum;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mNum);
        parcel.writeIntArray(mUids);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public WorkSource createFromParcel(Parcel parcel) {
            return new WorkSource(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public WorkSource[] newArray(int i) {
            return new WorkSource[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    static WorkSource sGoneWork;
    static WorkSource sNewbWork;
    static final WorkSource sTmpWorkSource = new WorkSource(0);
    int mNum;
    int mUids[];

}
