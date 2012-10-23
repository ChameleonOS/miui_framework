// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.ListIterator;

class ByteArrayBuilder {
    public static class Chunk {

        public void release() {
            mLength = 0;
            LinkedList linkedlist = ByteArrayBuilder.sPool;
            linkedlist;
            JVM INSTR monitorenter ;
            ByteArrayBuilder.sPool.offer(new SoftReference(this, ByteArrayBuilder.sQueue));
            ByteArrayBuilder.sPool.notifyAll();
            return;
        }

        public byte mArray[];
        public int mLength;

        public Chunk(int i) {
            mArray = new byte[i];
            mLength = 0;
        }
    }


    public ByteArrayBuilder() {
        mChunks = new LinkedList();
    }

    private Chunk obtainChunk(int i) {
        if(i < 8192)
            i = 8192;
        LinkedList linkedlist = sPool;
        linkedlist;
        JVM INSTR monitorenter ;
        Chunk chunk;
label0:
        {
            processPoolLocked();
            if(!sPool.isEmpty()) {
                chunk = (Chunk)((SoftReference)sPool.removeFirst()).get();
                if(chunk != null)
                    break label0;
            }
            chunk = new Chunk(i);
        }
        return chunk;
    }

    private void processPoolLocked() {
        do {
            SoftReference softreference = (SoftReference)sQueue.poll();
            if(softreference == null)
                return;
            sPool.remove(softreference);
        } while(true);
    }

    /**
     * @deprecated Method append is deprecated
     */

    public void append(byte abyte0[], int i, int j) {
        this;
        JVM INSTR monitorenter ;
_L2:
        if(j <= 0)
            break; /* Loop/switch isn't completed */
        Chunk chunk;
        int k;
        if(mChunks.isEmpty()) {
            chunk = obtainChunk(j);
            mChunks.addLast(chunk);
        } else {
            chunk = (Chunk)mChunks.getLast();
            if(chunk.mLength == chunk.mArray.length) {
                chunk = obtainChunk(j);
                mChunks.addLast(chunk);
            }
        }
        k = Math.min(j, chunk.mArray.length - chunk.mLength);
        System.arraycopy(abyte0, i, chunk.mArray, chunk.mLength, k);
        chunk.mLength = k + chunk.mLength;
        j -= k;
        i += k;
        if(true) goto _L2; else goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        this;
        JVM INSTR monitorexit ;
    }

    /**
     * @deprecated Method clear is deprecated
     */

    public void clear() {
        this;
        JVM INSTR monitorenter ;
        Chunk chunk = getFirstChunk();
_L1:
        Chunk chunk1;
        if(chunk == null)
            break MISSING_BLOCK_LABEL_25;
        chunk.release();
        chunk1 = getFirstChunk();
        chunk = chunk1;
          goto _L1
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getByteSize is deprecated
     */

    public int getByteSize() {
        this;
        JVM INSTR monitorenter ;
        int i = 0;
        ListIterator listiterator = mChunks.listIterator(0);
_L1:
        int j;
        if(!listiterator.hasNext())
            break MISSING_BLOCK_LABEL_44;
        j = ((Chunk)listiterator.next()).mLength;
        i += j;
          goto _L1
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getFirstChunk is deprecated
     */

    public Chunk getFirstChunk() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mChunks.isEmpty();
        if(!flag) goto _L2; else goto _L1
_L1:
        Chunk chunk = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return chunk;
_L2:
        chunk = (Chunk)mChunks.removeFirst();
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method isEmpty is deprecated
     */

    public boolean isEmpty() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mChunks.isEmpty();
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    private static final int DEFAULT_CAPACITY = 8192;
    private static final LinkedList sPool = new LinkedList();
    private static final ReferenceQueue sQueue = new ReferenceQueue();
    private LinkedList mChunks;



}
