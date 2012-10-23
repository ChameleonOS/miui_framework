// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.content.Context;
import android.net.Uri;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import java.util.LinkedList;

// Referenced classes of package android.media:
//            MediaPlayer

public class AsyncPlayer {
    private final class Thread extends java.lang.Thread {

        public void run() {
_L6:
            Command command;
            synchronized(mCmdQueue) {
                command = (Command)mCmdQueue.removeFirst();
            }
            command.code;
            JVM INSTR tableswitch 1 2: default 52
        //                       1 102
        //                       2 113;
               goto _L1 _L2 _L3
_L1:
            long l;
            synchronized(mCmdQueue) {
                if(mCmdQueue.size() != 0)
                    break; /* Loop/switch isn't completed */
                mThread = null;
                releaseWakeLock();
            }
            return;
            exception;
            linkedlist;
            JVM INSTR monitorexit ;
            throw exception;
_L2:
            startSound(command);
            continue; /* Loop/switch isn't completed */
_L3:
            if(mPlayer != null) {
                l = SystemClock.uptimeMillis() - command.requestTime;
                if(l > 1000L)
                    Log.w(mTag, (new StringBuilder()).append("Notification stop delayed by ").append(l).append("msecs").toString());
                mPlayer.stop();
                mPlayer.release();
                mPlayer = null;
            } else {
                Log.w(mTag, "STOP command without a player");
            }
            if(true) goto _L1; else goto _L4
_L4:
            if(true) goto _L6; else goto _L5
_L5:
        }

        final AsyncPlayer this$0;

        Thread() {
            this$0 = AsyncPlayer.this;
            super((new StringBuilder()).append("AsyncPlayer-").append(mTag).toString());
        }
    }

    private static final class Command {

        public String toString() {
            return (new StringBuilder()).append("{ code=").append(code).append(" looping=").append(looping).append(" stream=").append(stream).append(" uri=").append(uri).append(" }").toString();
        }

        int code;
        Context context;
        boolean looping;
        long requestTime;
        int stream;
        Uri uri;

        private Command() {
        }

    }


    public AsyncPlayer(String s) {
        mState = 2;
        if(s != null)
            mTag = s;
        else
            mTag = "AsyncPlayer";
    }

    private void acquireWakeLock() {
        if(mWakeLock != null)
            mWakeLock.acquire();
    }

    private void enqueueLocked(Command command) {
        mCmdQueue.add(command);
        if(mThread == null) {
            acquireWakeLock();
            mThread = new Thread();
            mThread.start();
        }
    }

    private void releaseWakeLock() {
        if(mWakeLock != null)
            mWakeLock.release();
    }

    private void startSound(Command command) {
        MediaPlayer mediaplayer = new MediaPlayer();
        mediaplayer.setAudioStreamType(command.stream);
        mediaplayer.setDataSource(command.context, command.uri);
        mediaplayer.setLooping(command.looping);
        mediaplayer.prepare();
        mediaplayer.start();
        if(mPlayer != null)
            mPlayer.release();
        mPlayer = mediaplayer;
        long l = SystemClock.uptimeMillis() - command.requestTime;
        if(l > 1000L)
            Log.w(mTag, (new StringBuilder()).append("Notification sound delayed by ").append(l).append("msecs").toString());
_L1:
        return;
        Exception exception;
        exception;
        Log.w(mTag, (new StringBuilder()).append("error loading sound for ").append(command.uri).toString(), exception);
          goto _L1
    }

    public void play(Context context, Uri uri, boolean flag, int i) {
        Command command;
        command = new Command();
        command.requestTime = SystemClock.uptimeMillis();
        command.code = 1;
        command.context = context;
        command.uri = uri;
        command.looping = flag;
        command.stream = i;
        LinkedList linkedlist = mCmdQueue;
        linkedlist;
        JVM INSTR monitorenter ;
        enqueueLocked(command);
        mState = 1;
        return;
    }

    public void setUsesWakeLock(Context context) {
        if(mWakeLock != null || mThread != null) {
            throw new RuntimeException((new StringBuilder()).append("assertion failed mWakeLock=").append(mWakeLock).append(" mThread=").append(mThread).toString());
        } else {
            mWakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(1, mTag);
            return;
        }
    }

    public void stop() {
        LinkedList linkedlist = mCmdQueue;
        linkedlist;
        JVM INSTR monitorenter ;
        if(mState != 2) {
            Command command = new Command();
            command.requestTime = SystemClock.uptimeMillis();
            command.code = 2;
            enqueueLocked(command);
            mState = 2;
        }
        return;
    }

    private static final int PLAY = 1;
    private static final int STOP = 2;
    private static final boolean mDebug;
    private final LinkedList mCmdQueue = new LinkedList();
    private MediaPlayer mPlayer;
    private int mState;
    private String mTag;
    private Thread mThread;
    private android.os.PowerManager.WakeLock mWakeLock;






/*
    static MediaPlayer access$302(AsyncPlayer asyncplayer, MediaPlayer mediaplayer) {
        asyncplayer.mPlayer = mediaplayer;
        return mediaplayer;
    }

*/


/*
    static Thread access$402(AsyncPlayer asyncplayer, Thread thread) {
        asyncplayer.mThread = thread;
        return thread;
    }

*/

}
