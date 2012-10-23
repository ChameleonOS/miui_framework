// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.SharedPreferences;
import android.os.*;
import android.util.Log;
import com.android.internal.util.XmlUtils;
import com.google.android.collect.Maps;
import dalvik.system.BlockGuard;
import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.app:
//            QueuedWork, ContextImpl, ActivityThread

final class SharedPreferencesImpl
    implements SharedPreferences {
    public final class EditorImpl
        implements android.content.SharedPreferences.Editor {

        private MemoryCommitResult commitToMemory() {
            boolean flag;
            MemoryCommitResult memorycommitresult;
            flag = true;
            memorycommitresult = new MemoryCommitResult();
            SharedPreferencesImpl sharedpreferencesimpl = SharedPreferencesImpl.this;
            sharedpreferencesimpl;
            JVM INSTR monitorenter ;
            if(mDiskWritesInFlight > 0)
                mMap = new HashMap(mMap);
            memorycommitresult.mapToWriteToDisk = mMap;
            int i = ((MemoryCommitResult) (this)).MemoryCommitResult;
            Exception exception;
            Exception exception1;
            Iterator iterator;
            String s;
            Object obj;
            if(mListeners.size() <= 0)
                flag = false;
            if(!flag)
                break MISSING_BLOCK_LABEL_118;
            memorycommitresult.keysModified = new ArrayList();
            memorycommitresult.listeners = new HashSet(mListeners.keySet());
            this;
            JVM INSTR monitorenter ;
            if(mClear) {
                if(!mMap.isEmpty()) {
                    memorycommitresult.changesMade = true;
                    mMap.clear();
                }
                mClear = false;
            }
            iterator = mModified.entrySet().iterator();
_L3:
            if(!iterator.hasNext())
                break MISSING_BLOCK_LABEL_372;
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            s = (String)entry.getKey();
            obj = entry.getValue();
            if(obj != this)
                break MISSING_BLOCK_LABEL_304;
            if(!mMap.containsKey(s))
                continue; /* Loop/switch isn't completed */
            mMap.remove(s);
_L1:
            memorycommitresult.changesMade = true;
            if(flag)
                memorycommitresult.keysModified.add(s);
            continue; /* Loop/switch isn't completed */
            exception1;
            throw exception1;
            exception;
            throw exception;
            if(mMap.containsKey(s)) {
                Object obj1 = mMap.get(s);
                if(obj1 != null && obj1.equals(obj))
                    continue; /* Loop/switch isn't completed */
            }
            mMap.put(s, obj);
              goto _L1
            mModified.clear();
            this;
            JVM INSTR monitorexit ;
            sharedpreferencesimpl;
            JVM INSTR monitorexit ;
            return memorycommitresult;
            if(true) goto _L3; else goto _L2
_L2:
        }

        private void notifyListeners(final MemoryCommitResult mcr) {
            if(mcr.listeners != null && mcr.keysModified != null && mcr.keysModified.size() != 0)
                if(Looper.myLooper() == Looper.getMainLooper()) {
                    int i = -1 + mcr.keysModified.size();
                    while(i >= 0)  {
                        String s = (String)mcr.keysModified.get(i);
                        Iterator iterator = mcr.listeners.iterator();
                        do {
                            if(!iterator.hasNext())
                                break;
                            android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener = (android.content.SharedPreferences.OnSharedPreferenceChangeListener)iterator.next();
                            if(onsharedpreferencechangelistener != null)
                                onsharedpreferencechangelistener.onSharedPreferenceChanged(SharedPreferencesImpl.this, s);
                        } while(true);
                        i--;
                    }
                } else {
                    ActivityThread.sMainThreadHandler.post(new Runnable() {

                        public void run() {
                            notifyListeners(mcr);
                        }

                        final EditorImpl this$1;
                        final MemoryCommitResult val$mcr;

                 {
                    this$1 = EditorImpl.this;
                    mcr = memorycommitresult;
                    super();
                }
                    });
                }
        }

        public void apply() {
            final MemoryCommitResult mcr = commitToMemory();
            final Runnable awaitCommit = new Runnable() {

                public void run() {
                    mcr.writtenToDiskLatch.await();
_L2:
                    return;
                    InterruptedException interruptedexception;
                    interruptedexception;
                    if(true) goto _L2; else goto _L1
_L1:
                }

                final EditorImpl this$1;
                final MemoryCommitResult val$mcr;

                 {
                    this$1 = EditorImpl.this;
                    mcr = memorycommitresult;
                    super();
                }
            };
            QueuedWork.add(awaitCommit);
            Runnable runnable = new Runnable() {

                public void run() {
                    awaitCommit.run();
                    QueuedWork.remove(awaitCommit);
                }

                final EditorImpl this$1;
                final Runnable val$awaitCommit;

                 {
                    this$1 = EditorImpl.this;
                    awaitCommit = runnable;
                    super();
                }
            };
            enqueueDiskWrite(mcr, runnable);
            notifyListeners(mcr);
        }

        public android.content.SharedPreferences.Editor clear() {
            this;
            JVM INSTR monitorenter ;
            mClear = true;
            return this;
        }

        public boolean commit() {
            MemoryCommitResult memorycommitresult;
            memorycommitresult = commitToMemory();
            enqueueDiskWrite(memorycommitresult, null);
            memorycommitresult.writtenToDiskLatch.await();
            boolean flag;
            notifyListeners(memorycommitresult);
            flag = memorycommitresult.writeToDiskResult;
_L2:
            return flag;
            InterruptedException interruptedexception;
            interruptedexception;
            flag = false;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public android.content.SharedPreferences.Editor putBoolean(String s, boolean flag) {
            this;
            JVM INSTR monitorenter ;
            mModified.put(s, Boolean.valueOf(flag));
            return this;
        }

        public android.content.SharedPreferences.Editor putFloat(String s, float f) {
            this;
            JVM INSTR monitorenter ;
            mModified.put(s, Float.valueOf(f));
            return this;
        }

        public android.content.SharedPreferences.Editor putInt(String s, int i) {
            this;
            JVM INSTR monitorenter ;
            mModified.put(s, Integer.valueOf(i));
            return this;
        }

        public android.content.SharedPreferences.Editor putLong(String s, long l) {
            this;
            JVM INSTR monitorenter ;
            mModified.put(s, Long.valueOf(l));
            return this;
        }

        public android.content.SharedPreferences.Editor putString(String s, String s1) {
            this;
            JVM INSTR monitorenter ;
            mModified.put(s, s1);
            return this;
        }

        public android.content.SharedPreferences.Editor putStringSet(String s, Set set) {
            this;
            JVM INSTR monitorenter ;
            mModified.put(s, set);
            return this;
        }

        public android.content.SharedPreferences.Editor remove(String s) {
            this;
            JVM INSTR monitorenter ;
            mModified.put(s, this);
            return this;
        }

        private boolean mClear;
        private final Map mModified = Maps.newHashMap();
        final SharedPreferencesImpl this$0;


        public EditorImpl() {
            this$0 = SharedPreferencesImpl.this;
            super();
            mClear = false;
        }
    }

    private static class MemoryCommitResult {

        public void setDiskWriteResult(boolean flag) {
            writeToDiskResult = flag;
            writtenToDiskLatch.countDown();
        }

        public boolean changesMade;
        public List keysModified;
        public Set listeners;
        public Map mapToWriteToDisk;
        public volatile boolean writeToDiskResult;
        public final CountDownLatch writtenToDiskLatch;

        private MemoryCommitResult() {
            writtenToDiskLatch = new CountDownLatch(1);
            writeToDiskResult = false;
        }

    }


    SharedPreferencesImpl(File file, int i) {
        mDiskWritesInFlight = 0;
        mLoaded = false;
        mFile = file;
        mBackupFile = makeBackupFile(file);
        mMode = i;
        mLoaded = false;
        mMap = null;
        startLoadFromDisk();
    }

    private void awaitLoadedLocked() {
        if(!mLoaded)
            BlockGuard.getThreadPolicy().onReadFromDisk();
        while(!mLoaded) 
            try {
                wait();
            }
            catch(InterruptedException interruptedexception) { }
    }

    private static FileOutputStream createFileOutputStream(File file) {
        FileOutputStream fileoutputstream = null;
        FileOutputStream fileoutputstream1 = new FileOutputStream(file);
        fileoutputstream = fileoutputstream1;
_L4:
        FileOutputStream fileoutputstream2 = fileoutputstream;
_L2:
        return fileoutputstream2;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        File file1;
        file1 = file.getParentFile();
        if(file1.mkdir())
            break; /* Loop/switch isn't completed */
        Log.e("SharedPreferencesImpl", (new StringBuilder()).append("Couldn't create directory for SharedPreferences file ").append(file).toString());
        fileoutputstream2 = null;
        if(true) goto _L2; else goto _L1
_L1:
        FileUtils.setPermissions(file1.getPath(), 505, -1, -1);
        FileOutputStream fileoutputstream3 = new FileOutputStream(file);
        fileoutputstream = fileoutputstream3;
        continue; /* Loop/switch isn't completed */
        FileNotFoundException filenotfoundexception1;
        filenotfoundexception1;
        Log.e("SharedPreferencesImpl", (new StringBuilder()).append("Couldn't create SharedPreferences file ").append(file).toString(), filenotfoundexception1);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void enqueueDiskWrite(final MemoryCommitResult mcr, final Runnable postWriteRunnable) {
        Runnable runnable;
        boolean flag1;
        runnable = new Runnable() ;
        boolean flag;
        if(postWriteRunnable == null)
            flag = true;
        else
            flag = false;
        if(!flag)
            break MISSING_BLOCK_LABEL_69;
        this;
        JVM INSTR monitorenter ;
        if(mDiskWritesInFlight != 1) goto _L2; else goto _L1
_L1:
        flag1 = true;
_L3:
        this;
        JVM INSTR monitorexit ;
        if(!flag1)
            break MISSING_BLOCK_LABEL_69;
        runnable.run();
_L4:
        return;
_L2:
        flag1 = false;
          goto _L3
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        QueuedWork.singleThreadExecutor().execute(runnable);
          goto _L4
    }

    private boolean hasFileChangedUnexpectedly() {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        if(mDiskWritesInFlight <= 0)
            break MISSING_BLOCK_LABEL_16;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_91;
        this;
        JVM INSTR monitorexit ;
        android.os.FileUtils.FileStatus filestatus;
        filestatus = new FileStatus();
        if(!FileUtils.getFileStatus(mFile.getPath(), filestatus)) {
            flag = true;
            break MISSING_BLOCK_LABEL_91;
        }
        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorenter ;
        if(mStatTimestamp != filestatus.mtime || mStatSize != filestatus.size)
            flag = true;
        return flag;
    }

    private void loadFromDiskLocked() {
        if(!mLoaded) {
            if(mBackupFile.exists()) {
                mFile.delete();
                mBackupFile.renameTo(mFile);
            }
            if(mFile.exists() && !mFile.canRead())
                Log.w("SharedPreferencesImpl", (new StringBuilder()).append("Attempt to read preferences file ").append(mFile).append(" without permission").toString());
            HashMap hashmap = null;
            android.os.FileUtils.FileStatus filestatus = new FileStatus();
            if(FileUtils.getFileStatus(mFile.getPath(), filestatus) && mFile.canRead())
                try {
                    BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(mFile), 16384);
                    hashmap = XmlUtils.readMapXml(bufferedinputstream);
                    bufferedinputstream.close();
                }
                catch(XmlPullParserException xmlpullparserexception) {
                    Log.w("SharedPreferencesImpl", "getSharedPreferences", xmlpullparserexception);
                }
                catch(FileNotFoundException filenotfoundexception) {
                    Log.w("SharedPreferencesImpl", "getSharedPreferences", filenotfoundexception);
                }
                catch(IOException ioexception) {
                    Log.w("SharedPreferencesImpl", "getSharedPreferences", ioexception);
                }
            mLoaded = true;
            if(hashmap != null) {
                mMap = hashmap;
                mStatTimestamp = filestatus.mtime;
                mStatSize = filestatus.size;
            } else {
                mMap = new HashMap();
            }
            notifyAll();
        }
    }

    private static File makeBackupFile(File file) {
        return new File((new StringBuilder()).append(file.getPath()).append(".bak").toString());
    }

    private void startLoadFromDisk() {
        this;
        JVM INSTR monitorenter ;
        mLoaded = false;
        this;
        JVM INSTR monitorexit ;
        (new Thread("SharedPreferencesImpl-load") {

            public void run() {
                SharedPreferencesImpl sharedpreferencesimpl = SharedPreferencesImpl.this;
                sharedpreferencesimpl;
                JVM INSTR monitorenter ;
                loadFromDiskLocked();
                return;
            }

            final SharedPreferencesImpl this$0;

             {
                this$0 = SharedPreferencesImpl.this;
                super(s);
            }
        }).start();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void writeToFile(MemoryCommitResult memorycommitresult) {
        if(!mFile.exists()) goto _L2; else goto _L1
_L1:
        if(memorycommitresult.changesMade) goto _L4; else goto _L3
_L3:
        memorycommitresult.setDiskWriteResult(true);
_L8:
        return;
_L4:
        if(mBackupFile.exists()) goto _L6; else goto _L5
_L5:
        if(mFile.renameTo(mBackupFile)) goto _L2; else goto _L7
_L7:
        Log.e("SharedPreferencesImpl", (new StringBuilder()).append("Couldn't rename file ").append(mFile).append(" to backup file ").append(mBackupFile).toString());
        memorycommitresult.setDiskWriteResult(false);
          goto _L8
_L6:
        mFile.delete();
_L2:
        FileOutputStream fileoutputstream = createFileOutputStream(mFile);
        if(fileoutputstream != null) goto _L10; else goto _L9
_L9:
        memorycommitresult.setDiskWriteResult(false);
          goto _L8
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        Log.w("SharedPreferencesImpl", "writeToFile: Got exception:", xmlpullparserexception);
_L13:
        if(mFile.exists() && !mFile.delete())
            Log.e("SharedPreferencesImpl", (new StringBuilder()).append("Couldn't clean up partially-written file ").append(mFile).toString());
        memorycommitresult.setDiskWriteResult(false);
          goto _L8
_L10:
        android.os.FileUtils.FileStatus filestatus;
        XmlUtils.writeMapXml(memorycommitresult.mapToWriteToDisk, fileoutputstream);
        FileUtils.sync(fileoutputstream);
        fileoutputstream.close();
        ContextImpl.setFilePermissionsFromMode(mFile.getPath(), mMode, 0);
        filestatus = new android.os.FileUtils.FileStatus();
        if(!FileUtils.getFileStatus(mFile.getPath(), filestatus)) goto _L12; else goto _L11
_L11:
        this;
        JVM INSTR monitorenter ;
        mStatTimestamp = filestatus.mtime;
        mStatSize = filestatus.size;
        this;
        JVM INSTR monitorexit ;
_L12:
        mBackupFile.delete();
        memorycommitresult.setDiskWriteResult(true);
          goto _L8
        IOException ioexception;
        ioexception;
        Log.w("SharedPreferencesImpl", "writeToFile: Got exception:", ioexception);
          goto _L13
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
          goto _L8
    }

    public boolean contains(String s) {
        this;
        JVM INSTR monitorenter ;
        awaitLoadedLocked();
        boolean flag = mMap.containsKey(s);
        return flag;
    }

    public android.content.SharedPreferences.Editor edit() {
        this;
        JVM INSTR monitorenter ;
        awaitLoadedLocked();
        this;
        JVM INSTR monitorexit ;
        return new EditorImpl();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Map getAll() {
        this;
        JVM INSTR monitorenter ;
        awaitLoadedLocked();
        HashMap hashmap = new HashMap(mMap);
        return hashmap;
    }

    public boolean getBoolean(String s, boolean flag) {
        this;
        JVM INSTR monitorenter ;
        awaitLoadedLocked();
        Boolean boolean1 = (Boolean)mMap.get(s);
        if(boolean1 != null)
            flag = boolean1.booleanValue();
        return flag;
    }

    public float getFloat(String s, float f) {
        this;
        JVM INSTR monitorenter ;
        awaitLoadedLocked();
        Float float1 = (Float)mMap.get(s);
        if(float1 != null)
            f = float1.floatValue();
        return f;
    }

    public int getInt(String s, int i) {
        this;
        JVM INSTR monitorenter ;
        awaitLoadedLocked();
        Integer integer = (Integer)mMap.get(s);
        if(integer != null)
            i = integer.intValue();
        return i;
    }

    public long getLong(String s, long l) {
        this;
        JVM INSTR monitorenter ;
        awaitLoadedLocked();
        Long long1 = (Long)mMap.get(s);
        if(long1 != null)
            l = long1.longValue();
        return l;
    }

    public String getString(String s, String s1) {
        this;
        JVM INSTR monitorenter ;
        awaitLoadedLocked();
        String s2 = (String)mMap.get(s);
        if(s2 == null)
            s2 = s1;
        return s2;
    }

    public Set getStringSet(String s, Set set) {
        this;
        JVM INSTR monitorenter ;
        awaitLoadedLocked();
        Set set1 = (Set)mMap.get(s);
        if(set1 == null)
            set1 = set;
        return set1;
    }

    public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener) {
        this;
        JVM INSTR monitorenter ;
        mListeners.put(onsharedpreferencechangelistener, mContent);
        return;
    }

    void startReloadIfChangedUnexpectedly() {
        this;
        JVM INSTR monitorenter ;
        if(hasFileChangedUnexpectedly())
            startLoadFromDisk();
        return;
    }

    public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener) {
        this;
        JVM INSTR monitorenter ;
        mListeners.remove(onsharedpreferencechangelistener);
        return;
    }

    private static final boolean DEBUG = false;
    private static final String TAG = "SharedPreferencesImpl";
    private static final Object mContent = new Object();
    private final File mBackupFile;
    private int mDiskWritesInFlight;
    private final File mFile;
    private final WeakHashMap mListeners = new WeakHashMap();
    private boolean mLoaded;
    private Map mMap;
    private final int mMode;
    private long mStatSize;
    private long mStatTimestamp;
    private final Object mWritingToDiskLock = new Object();






/*
    static int access$308(SharedPreferencesImpl sharedpreferencesimpl) {
        int i = sharedpreferencesimpl.mDiskWritesInFlight;
        sharedpreferencesimpl.mDiskWritesInFlight = i + 1;
        return i;
    }

*/


/*
    static int access$310(SharedPreferencesImpl sharedpreferencesimpl) {
        int i = sharedpreferencesimpl.mDiskWritesInFlight;
        sharedpreferencesimpl.mDiskWritesInFlight = i - 1;
        return i;
    }

*/



/*
    static Map access$402(SharedPreferencesImpl sharedpreferencesimpl, Map map) {
        sharedpreferencesimpl.mMap = map;
        return map;
    }

*/



}
