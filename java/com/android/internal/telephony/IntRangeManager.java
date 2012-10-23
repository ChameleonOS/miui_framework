// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class IntRangeManager {
    private class ClientRange {

        public boolean equals(Object obj) {
            boolean flag = false;
            if(obj != null && (obj instanceof ClientRange)) {
                ClientRange clientrange = (ClientRange)obj;
                if(startId == clientrange.startId && endId == clientrange.endId && client.equals(clientrange.client))
                    flag = true;
            }
            return flag;
        }

        public int hashCode() {
            return 31 * (31 * startId + endId) + client.hashCode();
        }

        final String client;
        final int endId;
        final int startId;
        final IntRangeManager this$0;

        ClientRange(int i, int j, String s) {
            this$0 = IntRangeManager.this;
            super();
            startId = i;
            endId = j;
            client = s;
        }
    }

    private class IntRange {

        void insert(ClientRange clientrange) {
            int i;
            int j;
            i = clients.size();
            j = 0;
_L3:
            ClientRange clientrange1;
            if(j >= i)
                break MISSING_BLOCK_LABEL_65;
            clientrange1 = (ClientRange)clients.get(j);
            if(clientrange.startId > clientrange1.startId) goto _L2; else goto _L1
_L1:
            if(!clientrange.equals(clientrange1))
                clients.add(j, clientrange);
_L4:
            return;
_L2:
            j++;
              goto _L3
            clients.add(clientrange);
              goto _L4
        }

        final ArrayList clients;
        int endId;
        int startId;
        final IntRangeManager this$0;

        IntRange(int i, int j, String s) {
            this$0 = IntRangeManager.this;
            super();
            startId = i;
            endId = j;
            clients = new ArrayList(4);
            clients.add(new ClientRange(i, j, s));
        }

        IntRange(ClientRange clientrange) {
            this$0 = IntRangeManager.this;
            super();
            startId = clientrange.startId;
            endId = clientrange.endId;
            clients = new ArrayList(4);
            clients.add(clientrange);
        }

        IntRange(IntRange intrange, int i) {
            this$0 = IntRangeManager.this;
            super();
            startId = intrange.startId;
            endId = intrange.endId;
            clients = new ArrayList(intrange.clients.size());
            for(int j = 0; j < i; j++)
                clients.add(intrange.clients.get(j));

        }
    }


    protected IntRangeManager() {
        mRanges = new ArrayList();
    }

    private boolean tryAddSingleRange(int i, int j, boolean flag) {
        startUpdate();
        addRange(i, j, flag);
        return finishUpdate();
    }

    protected abstract void addRange(int i, int j, boolean flag);

    /**
     * @deprecated Method disableRange is deprecated
     */

    public boolean disableRange(int i, int j, String s) {
        this;
        JVM INSTR monitorenter ;
        int k;
        int l;
        k = mRanges.size();
        l = 0;
_L20:
        if(l >= k) goto _L2; else goto _L1
_L1:
        IntRange intrange;
        int i1;
        intrange = (IntRange)mRanges.get(l);
        i1 = intrange.startId;
        if(i >= i1) goto _L4; else goto _L3
_L3:
        boolean flag = false;
_L13:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        if(j > intrange.endId) goto _L6; else goto _L5
_L5:
        ArrayList arraylist;
        int j1;
        arraylist = intrange.clients;
        j1 = arraylist.size();
        if(j1 != 1) goto _L8; else goto _L7
_L7:
        ClientRange clientrange2 = (ClientRange)arraylist.get(0);
        if(clientrange2.startId != i || clientrange2.endId != j || !clientrange2.client.equals(s)) goto _L10; else goto _L9
_L9:
        if(!tryAddSingleRange(i, j, false)) goto _L12; else goto _L11
_L11:
        mRanges.remove(l);
        flag = true;
          goto _L13
_L19:
        int l1;
        if(l1 >= j1) goto _L6; else goto _L14
_L14:
        ClientRange clientrange = (ClientRange)arraylist.get(l1);
        if(clientrange.startId != i || clientrange.endId != j || !clientrange.client.equals(s)) goto _L16; else goto _L15
_L15:
        if(l1 != j1 - 1) goto _L18; else goto _L17
_L17:
        int k1;
        if(intrange.endId == k1) {
            arraylist.remove(l1);
            flag = true;
        } else {
            if(!tryAddSingleRange(k1 + 1, intrange.endId, false))
                break MISSING_BLOCK_LABEL_653;
            arraylist.remove(l1);
            intrange.endId = k1;
            flag = true;
        }
          goto _L13
_L18:
        boolean flag1;
        ArrayList arraylist1;
        IntRange intrange2;
        IntRange intrange1 = new IntRange(intrange, l1);
        if(l1 == 0) {
            int j2 = ((ClientRange)arraylist.get(1)).startId;
            if(j2 != intrange.startId) {
                startUpdate();
                flag1 = true;
                addRange(intrange.startId, j2 - 1, false);
                intrange1.startId = j2;
            }
            k1 = ((ClientRange)arraylist.get(1)).endId;
        }
        arraylist1 = new ArrayList();
        intrange2 = intrange1;
        Exception exception;
        for(int i2 = l1 + 1; i2 < j1; i2++) {
            ClientRange clientrange1 = (ClientRange)arraylist.get(i2);
            if(clientrange1.startId > k1 + 1) {
                if(!flag1) {
                    startUpdate();
                    flag1 = true;
                }
                addRange(k1 + 1, -1 + clientrange1.startId, false);
                intrange2.endId = k1;
                arraylist1.add(intrange2);
                intrange2 = new IntRange(clientrange1);
            } else {
                intrange2.clients.add(clientrange1);
            }
            if(clientrange1.endId > k1)
                k1 = clientrange1.endId;
            break MISSING_BLOCK_LABEL_659;
        }

        break MISSING_BLOCK_LABEL_504;
        exception;
        throw exception;
        if(k1 >= j)
            break MISSING_BLOCK_LABEL_539;
        if(flag1)
            break MISSING_BLOCK_LABEL_522;
        startUpdate();
        flag1 = true;
        addRange(k1 + 1, j, false);
        intrange2.endId = k1;
        arraylist1.add(intrange2);
        if(flag1 && !finishUpdate()) {
            flag = false;
        } else {
            mRanges.remove(l);
            mRanges.addAll(l, arraylist1);
            flag = true;
        }
          goto _L13
_L16:
        if(clientrange.endId > k1)
            k1 = clientrange.endId;
        l1++;
          goto _L19
_L6:
        l++;
          goto _L20
_L2:
        flag = false;
          goto _L13
_L12:
        flag = false;
          goto _L13
_L10:
        flag = false;
          goto _L13
_L8:
        k1 = 0x80000000;
        flag1 = false;
        l1 = 0;
          goto _L19
        flag = false;
          goto _L13
    }

    /**
     * @deprecated Method enableRange is deprecated
     */

    public boolean enableRange(int i, int j, String s) {
        this;
        JVM INSTR monitorenter ;
        int k = mRanges.size();
        if(k != 0) goto _L2; else goto _L1
_L1:
        if(!tryAddSingleRange(i, j, true)) goto _L4; else goto _L3
_L3:
        ArrayList arraylist2 = mRanges;
        IntRange intrange10 = new IntRange(i, j, s);
        arraylist2.add(intrange10);
        boolean flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        flag = false;
          goto _L5
_L2:
        int l = 0;
_L47:
        if(l >= k) goto _L7; else goto _L6
_L6:
        IntRange intrange1 = (IntRange)mRanges.get(l);
        if(i >= intrange1.startId) goto _L9; else goto _L8
_L8:
        if(j + 1 >= intrange1.startId) goto _L11; else goto _L10
_L10:
        if(!tryAddSingleRange(i, j, true)) goto _L13; else goto _L12
_L12:
        ArrayList arraylist1 = mRanges;
        IntRange intrange9 = new IntRange(i, j, s);
        arraylist1.add(l, intrange9);
        flag = true;
          goto _L5
_L11:
        if(j > intrange1.endId) goto _L15; else goto _L14
_L14:
        if(!tryAddSingleRange(i, -1 + intrange1.startId, true)) goto _L17; else goto _L16
_L16:
        intrange1.startId = i;
        intrange1.clients.add(0, new ClientRange(i, j, s));
        flag = true;
          goto _L5
_L44:
        int j2;
        if(j2 >= k) goto _L19; else goto _L18
_L18:
        IntRange intrange6 = (IntRange)mRanges.get(j2);
        if(j + 1 >= intrange6.startId) goto _L21; else goto _L20
_L20:
        if(!tryAddSingleRange(i, j, true)) goto _L23; else goto _L22
_L22:
        intrange1.startId = i;
        intrange1.endId = j;
        intrange1.clients.add(0, new ClientRange(i, j, s));
        int k3 = l + 1;
        for(int l3 = k3; l3 < j2; l3++) {
            IntRange intrange8 = (IntRange)mRanges.get(k3);
            intrange1.clients.addAll(intrange8.clients);
            mRanges.remove(intrange8);
        }

          goto _L24
_L21:
        if(j > intrange6.endId) goto _L26; else goto _L25
_L25:
        if(!tryAddSingleRange(i, -1 + intrange6.startId, true)) goto _L28; else goto _L27
_L27:
        intrange1.startId = i;
        intrange1.endId = intrange6.endId;
        intrange1.clients.add(0, new ClientRange(i, j, s));
        int i3 = l + 1;
        for(int j3 = i3; j3 <= j2; j3++) {
            IntRange intrange7 = (IntRange)mRanges.get(i3);
            intrange1.clients.addAll(intrange7.clients);
            mRanges.remove(intrange7);
        }

          goto _L29
_L19:
        if(!tryAddSingleRange(i, j, true)) goto _L31; else goto _L30
_L30:
        intrange1.startId = i;
        intrange1.endId = j;
        intrange1.clients.add(0, new ClientRange(i, j, s));
        int k2 = l + 1;
        for(int l2 = k2; l2 < k; l2++) {
            IntRange intrange5 = (IntRange)mRanges.get(k2);
            intrange1.clients.addAll(intrange5.clients);
            mRanges.remove(intrange5);
        }

          goto _L32
_L9:
        if(i + 1 > intrange1.endId)
            break MISSING_BLOCK_LABEL_1010;
        if(j > intrange1.endId) goto _L34; else goto _L33
_L33:
        ClientRange clientrange = new ClientRange(i, j, s);
        intrange1.insert(clientrange);
        flag = true;
          goto _L5
_L45:
        int j1;
        if(j1 >= k) goto _L36; else goto _L35
_L35:
        IntRange intrange4 = (IntRange)mRanges.get(j1);
        if(j + 1 >= intrange4.startId) goto _L37; else goto _L36
_L36:
        int i1;
        if(i1 != l) goto _L39; else goto _L38
_L38:
        if(!tryAddSingleRange(1 + intrange1.endId, j, true)) goto _L41; else goto _L40
_L40:
        intrange1.endId = j;
        ClientRange clientrange2 = new ClientRange(i, j, s);
        intrange1.insert(clientrange2);
        flag = true;
          goto _L5
_L39:
        int k1;
        IntRange intrange2 = (IntRange)mRanges.get(i1);
        if(j > intrange2.endId)
            break MISSING_BLOCK_LABEL_992;
        k1 = -1 + intrange2.startId;
_L46:
        if(!tryAddSingleRange(1 + intrange1.endId, k1, true))
            break MISSING_BLOCK_LABEL_1004;
        intrange1.endId = j;
        ClientRange clientrange1 = new ClientRange(i, j, s);
        intrange1.insert(clientrange1);
        int l1 = l + 1;
        for(int i2 = l1; i2 < i1; i2++) {
            IntRange intrange3 = (IntRange)mRanges.get(l1);
            intrange1.clients.addAll(intrange3.clients);
            mRanges.remove(intrange3);
        }

        break MISSING_BLOCK_LABEL_998;
_L7:
        if(!tryAddSingleRange(i, j, true)) goto _L43; else goto _L42
_L42:
        ArrayList arraylist = mRanges;
        IntRange intrange = new IntRange(i, j, s);
        arraylist.add(intrange);
        flag = true;
          goto _L5
_L43:
        flag = false;
          goto _L5
        Exception exception;
        exception;
        throw exception;
_L13:
        flag = false;
          goto _L5
_L17:
        flag = false;
          goto _L5
_L15:
        j2 = l + 1;
          goto _L44
_L24:
        flag = true;
          goto _L5
_L23:
        flag = false;
          goto _L5
_L29:
        flag = true;
          goto _L5
_L28:
        flag = false;
          goto _L5
_L26:
        j2++;
          goto _L44
_L32:
        flag = true;
          goto _L5
_L31:
        flag = false;
          goto _L5
_L34:
        i1 = l;
        j1 = l + 1;
          goto _L45
_L37:
        i1 = j1;
        j1++;
          goto _L45
_L41:
        flag = false;
          goto _L5
        k1 = j;
          goto _L46
        flag = true;
          goto _L5
        flag = false;
          goto _L5
        l++;
          goto _L47
    }

    protected abstract boolean finishUpdate();

    public boolean isEmpty() {
        return mRanges.isEmpty();
    }

    protected abstract void startUpdate();

    public boolean updateRanges() {
        startUpdate();
        Iterator iterator = mRanges.iterator();
        if(iterator.hasNext()) {
            IntRange intrange = (IntRange)iterator.next();
            int i = intrange.startId;
            int j = intrange.endId;
            do {
                if(!iterator.hasNext())
                    break;
                IntRange intrange1 = (IntRange)iterator.next();
                if(intrange1.startId <= j + 1) {
                    if(intrange1.endId > j)
                        j = intrange1.endId;
                } else {
                    addRange(i, j, true);
                    i = intrange1.startId;
                    j = intrange1.endId;
                }
            } while(true);
            addRange(i, j, true);
        }
        return finishUpdate();
    }

    private static final int INITIAL_CLIENTS_ARRAY_SIZE = 4;
    private ArrayList mRanges;
}
