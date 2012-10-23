// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

// Referenced classes of package android.media:
//            AudioManager, MediaPlayer, RingtoneManager, IRingtonePlayer

public class Ringtone {

    public Ringtone(Context context, boolean flag) {
        Binder binder = null;
        super();
        mStreamType = 2;
        mContext = context;
        mAudioManager = (AudioManager)mContext.getSystemService("audio");
        mAllowRemote = flag;
        IRingtonePlayer iringtoneplayer;
        if(flag)
            iringtoneplayer = mAudioManager.getRingtonePlayer();
        else
            iringtoneplayer = null;
        mRemotePlayer = iringtoneplayer;
        if(flag)
            binder = new Binder();
        mRemoteToken = binder;
    }

    private void destroyLocalPlayer() {
        if(mLocalPlayer != null) {
            mLocalPlayer.reset();
            mLocalPlayer.release();
            mLocalPlayer = null;
        }
    }

    private static String getTitle(Context context, Uri uri, boolean flag) {
        Cursor cursor;
        ContentResolver contentresolver;
        String s;
        cursor = null;
        contentresolver = context.getContentResolver();
        s = null;
        if(uri == null) goto _L2; else goto _L1
_L1:
        String s2 = uri.getAuthority();
        if(!"settings".equals(s2)) goto _L4; else goto _L3
_L3:
        if(flag) {
            String s5 = getTitle(context, RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.getDefaultType(uri)), false);
            Object aobj[] = new Object[1];
            aobj[0] = s5;
            s = context.getString(0x10403ff, aobj);
        }
_L2:
        String s1;
        if(s == null) {
            s = context.getString(0x1040402);
            if(s == null)
                s = "";
        }
        s1 = s;
_L10:
        return s1;
_L4:
        if(!"drm".equals(s2)) goto _L6; else goto _L5
_L5:
        Cursor cursor2 = contentresolver.query(uri, DRM_COLUMNS, null, null, null);
        cursor = cursor2;
_L12:
        if(cursor == null) goto _L8; else goto _L7
_L7:
        if(cursor.getCount() != 1) goto _L8; else goto _L9
_L9:
        String s4;
        cursor.moveToFirst();
        s4 = cursor.getString(2);
        s1 = s4;
        if(cursor != null)
            cursor.close();
          goto _L10
_L6:
        if(!"media".equals(s2)) goto _L12; else goto _L11
_L11:
        Cursor cursor1 = contentresolver.query(uri, MEDIA_COLUMNS, null, null, null);
        cursor = cursor1;
          goto _L12
_L8:
        String s3 = uri.getLastPathSegment();
        s = s3;
        if(cursor != null)
            cursor.close();
          goto _L2
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
        SecurityException securityexception;
        securityexception;
          goto _L12
    }

    public int getStreamType() {
        return mStreamType;
    }

    public String getTitle(Context context) {
        String s;
        if(mTitle != null) {
            s = mTitle;
        } else {
            s = getTitle(context, mUri, true);
            mTitle = s;
        }
        return s;
    }

    public Uri getUri() {
        return mUri;
    }

    public boolean isPlaying() {
        boolean flag = false;
        if(mLocalPlayer == null) goto _L2; else goto _L1
_L1:
        flag = mLocalPlayer.isPlaying();
_L4:
        return flag;
_L2:
        if(mAllowRemote) {
            boolean flag1;
            try {
                flag1 = mRemotePlayer.isPlaying(mRemoteToken);
            }
            catch(RemoteException remoteexception) {
                Log.w("Ringtone", (new StringBuilder()).append("Problem checking ringtone: ").append(remoteexception).toString());
                continue; /* Loop/switch isn't completed */
            }
            flag = flag1;
            continue; /* Loop/switch isn't completed */
        }
        Log.w("Ringtone", "Neither local nor remote playback available");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void play() {
        if(mLocalPlayer != null) {
            if(mAudioManager.getStreamVolume(mStreamType) != 0)
                mLocalPlayer.start();
        } else
        if(mAllowRemote)
            try {
                mRemotePlayer.play(mRemoteToken, mUri, mStreamType);
            }
            catch(RemoteException remoteexception) {
                Log.w("Ringtone", (new StringBuilder()).append("Problem playing ringtone: ").append(remoteexception).toString());
            }
        else
            Log.w("Ringtone", "Neither local nor remote playback available");
    }

    public void setStreamType(int i) {
        mStreamType = i;
        setUri(mUri);
    }

    void setTitle(String s) {
        mTitle = s;
    }

    public void setUri(Uri uri) {
        destroyLocalPlayer();
        mUri = uri;
        if(mUri != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mLocalPlayer = new MediaPlayer();
        try {
            mLocalPlayer.setDataSource(mContext, mUri);
            mLocalPlayer.setAudioStreamType(mStreamType);
            mLocalPlayer.prepare();
        }
        catch(SecurityException securityexception) {
            destroyLocalPlayer();
            if(!mAllowRemote)
                Log.w("Ringtone", (new StringBuilder()).append("Remote playback not allowed: ").append(securityexception).toString());
        }
        catch(IOException ioexception) {
            destroyLocalPlayer();
            if(!mAllowRemote)
                Log.w("Ringtone", (new StringBuilder()).append("Remote playback not allowed: ").append(ioexception).toString());
        }
        if(mLocalPlayer != null)
            Log.d("Ringtone", "Successfully created local player");
        else
            Log.d("Ringtone", "Problem opening; delegating to remote player");
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void stop() {
        if(mLocalPlayer == null) goto _L2; else goto _L1
_L1:
        destroyLocalPlayer();
_L4:
        return;
_L2:
        if(mAllowRemote)
            try {
                mRemotePlayer.stop(mRemoteToken);
            }
            catch(RemoteException remoteexception) {
                Log.w("Ringtone", (new StringBuilder()).append("Problem stopping ringtone: ").append(remoteexception).toString());
            }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final String DRM_COLUMNS[];
    private static final boolean LOGD = true;
    private static final String MEDIA_COLUMNS[];
    private static final String TAG = "Ringtone";
    private final boolean mAllowRemote;
    private final AudioManager mAudioManager;
    private final Context mContext;
    private MediaPlayer mLocalPlayer;
    private final IRingtonePlayer mRemotePlayer;
    private final Binder mRemoteToken;
    private int mStreamType;
    private String mTitle;
    private Uri mUri;

    static  {
        String as[] = new String[3];
        as[0] = "_id";
        as[1] = "_data";
        as[2] = "title";
        MEDIA_COLUMNS = as;
        String as1[] = new String[3];
        as1[0] = "_id";
        as1[1] = "_data";
        as1[2] = "title";
        DRM_COLUMNS = as1;
    }
}
