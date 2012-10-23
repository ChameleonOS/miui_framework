// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.*;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import java.lang.ref.WeakReference;

// Referenced classes of package com.android.internal.widget:
//            LockScreenWidgetInterface, LockScreenWidgetCallback

public class TransportControlView extends FrameLayout
    implements android.view.View.OnClickListener, LockScreenWidgetInterface {
    static class SavedState extends android.view.View.BaseSavedState {

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int j;
            if(wasShowing)
                j = 1;
            else
                j = 0;
            parcel.writeInt(j);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        boolean wasShowing;


        private SavedState(Parcel parcel) {
            super(parcel);
            boolean flag;
            if(parcel.readInt() != 0)
                flag = true;
            else
                flag = false;
            wasShowing = flag;
        }


        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    class Metadata {

        public String toString() {
            return (new StringBuilder()).append("Metadata[artist=").append(artist).append(" trackTitle=").append(trackTitle).append(" albumTitle=").append(albumTitle).append("]").toString();
        }

        private String albumTitle;
        private String artist;
        private Bitmap bitmap;
        final TransportControlView this$0;
        private String trackTitle;



/*
        static String access$1002(Metadata metadata, String s) {
            metadata.trackTitle = s;
            return s;
        }

*/



/*
        static String access$1102(Metadata metadata, String s) {
            metadata.albumTitle = s;
            return s;
        }

*/



/*
        static Bitmap access$502(Metadata metadata, Bitmap bitmap1) {
            metadata.bitmap = bitmap1;
            return bitmap1;
        }

*/



/*
        static String access$902(Metadata metadata, String s) {
            metadata.artist = s;
            return s;
        }

*/

        Metadata() {
            this$0 = TransportControlView.this;
            super();
        }
    }

    private static class IRemoteControlDisplayWeak extends android.media.IRemoteControlDisplay.Stub {

        public void setAllMetadata(int i, Bundle bundle, Bitmap bitmap) {
            Handler handler = (Handler)mLocalHandler.get();
            if(handler != null) {
                handler.obtainMessage(101, i, 0, bundle).sendToTarget();
                handler.obtainMessage(103, i, 0, bitmap).sendToTarget();
            }
        }

        public void setArtwork(int i, Bitmap bitmap) {
            Handler handler = (Handler)mLocalHandler.get();
            if(handler != null)
                handler.obtainMessage(103, i, 0, bitmap).sendToTarget();
        }

        public void setCurrentClientId(int i, PendingIntent pendingintent, boolean flag) throws RemoteException {
            Handler handler = (Handler)mLocalHandler.get();
            if(handler != null) {
                int j;
                if(flag)
                    j = 1;
                else
                    j = 0;
                handler.obtainMessage(104, i, j, pendingintent).sendToTarget();
            }
        }

        public void setMetadata(int i, Bundle bundle) {
            Handler handler = (Handler)mLocalHandler.get();
            if(handler != null)
                handler.obtainMessage(101, i, 0, bundle).sendToTarget();
        }

        public void setPlaybackState(int i, int j, long l) {
            Handler handler = (Handler)mLocalHandler.get();
            if(handler != null)
                handler.obtainMessage(100, i, j).sendToTarget();
        }

        public void setTransportControlFlags(int i, int j) {
            Handler handler = (Handler)mLocalHandler.get();
            if(handler != null)
                handler.obtainMessage(102, i, j).sendToTarget();
        }

        private WeakReference mLocalHandler;

        IRemoteControlDisplayWeak(Handler handler) {
            mLocalHandler = new WeakReference(handler);
        }
    }


    public TransportControlView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mMetadata = new Metadata();
        mPopulateMetadataWhenAttached = null;
        mHandler = new Handler() {

            public void handleMessage(Message message) {
                message.what;
                JVM INSTR tableswitch 100 104: default 40
            //                           100 41
            //                           101 69
            //                           102 100
            //                           103 128
            //                           104 209;
                   goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
                return;
_L2:
                if(mClientGeneration == message.arg1)
                    updatePlayPauseState(message.arg2);
                continue; /* Loop/switch isn't completed */
_L3:
                if(mClientGeneration == message.arg1)
                    updateMetadata((Bundle)message.obj);
                continue; /* Loop/switch isn't completed */
_L4:
                if(mClientGeneration == message.arg1)
                    updateTransportControls(message.arg2);
                continue; /* Loop/switch isn't completed */
_L5:
                if(mClientGeneration == message.arg1) {
                    if(mMetadata.bitmap != null)
                        mMetadata.bitmap.recycle();
                    mMetadata.bitmap = (Bitmap)message.obj;
                    mAlbumArt.setImageBitmap(mMetadata.bitmap);
                }
                continue; /* Loop/switch isn't completed */
_L6:
                if(message.arg2 != 0 && mWidgetCallbacks != null)
                    mWidgetCallbacks.requestHide(TransportControlView.this);
                mClientGeneration = message.arg1;
                mClientIntent = (PendingIntent)message.obj;
                if(true) goto _L1; else goto _L7
_L7:
            }

            final TransportControlView this$0;

             {
                this$0 = TransportControlView.this;
                super();
            }
        };
        Log.v("TransportControlView", (new StringBuilder()).append("Create TCV ").append(this).toString());
        mAudioManager = new AudioManager(super.mContext);
        mCurrentPlayState = 0;
        mIRCD = new IRemoteControlDisplayWeak(mHandler);
    }

    private String getMdString(Bundle bundle, int i) {
        return bundle.getString(Integer.toString(i));
    }

    private void populateMetadata() {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        if(!TextUtils.isEmpty(mMetadata.trackTitle)) {
            stringbuilder.append(mMetadata.trackTitle);
            i = mMetadata.trackTitle.length();
        }
        if(!TextUtils.isEmpty(mMetadata.artist)) {
            if(stringbuilder.length() != 0)
                stringbuilder.append(" - ");
            stringbuilder.append(mMetadata.artist);
        }
        if(!TextUtils.isEmpty(mMetadata.albumTitle)) {
            if(stringbuilder.length() != 0)
                stringbuilder.append(" - ");
            stringbuilder.append(mMetadata.albumTitle);
        }
        mTrackTitle.setText(stringbuilder.toString(), android.widget.TextView.BufferType.SPANNABLE);
        Spannable spannable = (Spannable)mTrackTitle.getText();
        if(i != 0) {
            spannable.setSpan(new ForegroundColorSpan(-1), 0, i, 33);
            i++;
        }
        if(stringbuilder.length() > i)
            spannable.setSpan(new ForegroundColorSpan(0x7fffffff), i, stringbuilder.length(), 33);
        mAlbumArt.setImageBitmap(mMetadata.bitmap);
        int j = mTransportControlFlags;
        setVisibilityBasedOnFlag(mBtnPrev, j, 1);
        setVisibilityBasedOnFlag(mBtnNext, j, 128);
        setVisibilityBasedOnFlag(mBtnPlay, j, 60);
        updatePlayPauseState(mCurrentPlayState);
    }

    private void sendMediaButtonClick(int i) {
        if(mClientIntent != null) goto _L2; else goto _L1
_L1:
        Log.e("TransportControlView", "sendMediaButtonClick(): No client is currently registered");
_L4:
        return;
_L2:
        KeyEvent keyevent = new KeyEvent(0, i);
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.putExtra("android.intent.extra.KEY_EVENT", keyevent);
        KeyEvent keyevent1;
        Intent intent1;
        try {
            mClientIntent.send(getContext(), 0, intent);
        }
        catch(android.app.PendingIntent.CanceledException canceledexception) {
            Log.e("TransportControlView", (new StringBuilder()).append("Error sending intent for media button down: ").append(canceledexception).toString());
            canceledexception.printStackTrace();
        }
        keyevent1 = new KeyEvent(1, i);
        intent1 = new Intent("android.intent.action.MEDIA_BUTTON");
        intent1.putExtra("android.intent.extra.KEY_EVENT", keyevent1);
        try {
            mClientIntent.send(getContext(), 0, intent1);
        }
        catch(android.app.PendingIntent.CanceledException canceledexception1) {
            Log.e("TransportControlView", (new StringBuilder()).append("Error sending intent for media button up: ").append(canceledexception1).toString());
            canceledexception1.printStackTrace();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static void setVisibilityBasedOnFlag(View view, int i, int j) {
        if((i & j) != 0)
            view.setVisibility(0);
        else
            view.setVisibility(8);
    }

    private void updateMetadata(Bundle bundle) {
        if(mAttached) {
            mMetadata.artist = getMdString(bundle, 13);
            mMetadata.trackTitle = getMdString(bundle, 7);
            mMetadata.albumTitle = getMdString(bundle, 1);
            populateMetadata();
        } else {
            mPopulateMetadataWhenAttached = bundle;
        }
    }

    private void updatePlayPauseState(int i) {
        if(i != mCurrentPlayState) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag = false;
        i;
        JVM INSTR lookupswitch 3: default 48
    //                   3: 137
    //                   8: 151
    //                   9: 125;
           goto _L3 _L4 _L5 _L6
_L5:
        break MISSING_BLOCK_LABEL_151;
_L6:
        break; /* Loop/switch isn't completed */
_L3:
        int j;
        int k;
        j = 0x1080024;
        k = 0x104030e;
        flag = false;
_L8:
        mBtnPlay.setImageResource(j);
        mBtnPlay.setContentDescription(getResources().getString(k));
        if(flag && mWidgetCallbacks != null && !mWidgetCallbacks.isVisible(this))
            mWidgetCallbacks.requestShow(this);
        mCurrentPlayState = i;
        if(true) goto _L1; else goto _L7
_L7:
        j = 0x108008a;
        k = 0x104030e;
          goto _L8
_L4:
        j = 0x1080023;
        k = 0x104030d;
        flag = true;
          goto _L8
        j = 0x1080317;
        k = 0x104030f;
        flag = true;
          goto _L8
    }

    private void updateTransportControls(int i) {
        mTransportControlFlags = i;
    }

    private boolean wasPlayingRecently(int i, long l) {
        boolean flag = true;
        i;
        JVM INSTR tableswitch 0 9: default 60
    //                   0 98
    //                   1 104
    //                   2 104
    //                   3 95
    //                   4 95
    //                   5 95
    //                   6 95
    //                   7 95
    //                   8 95
    //                   9 104;
           goto _L1 _L2 _L3 _L3 _L4 _L4 _L4 _L4 _L4 _L4 _L3
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        Log.e("TransportControlView", (new StringBuilder()).append("Unknown playback state ").append(i).append(" in wasPlayingRecently()").toString());
        flag = false;
_L6:
        return flag;
_L2:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L3:
        if(SystemClock.elapsedRealtime() - l >= 5000L)
            flag = false;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(mPopulateMetadataWhenAttached != null) {
            updateMetadata(mPopulateMetadataWhenAttached);
            mPopulateMetadataWhenAttached = null;
        }
        if(!mAttached)
            mAudioManager.registerRemoteControlDisplay(mIRCD);
        mAttached = true;
    }

    public void onClick(View view) {
        byte byte0 = -1;
        if(view != mBtnPrev) goto _L2; else goto _L1
_L1:
        byte0 = 88;
_L4:
        if(byte0 != -1) {
            sendMediaButtonClick(byte0);
            if(mWidgetCallbacks != null)
                mWidgetCallbacks.userActivity(this);
        }
        return;
_L2:
        if(view == mBtnNext)
            byte0 = 87;
        else
        if(view == mBtnPlay)
            byte0 = 85;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(mAttached)
            mAudioManager.unregisterRemoteControlDisplay(mIRCD);
        mAttached = false;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        mTrackTitle = (TextView)findViewById(0x1020016);
        mTrackTitle.setSelected(true);
        mAlbumArt = (ImageView)findViewById(0x10202c7);
        mBtnPrev = (ImageView)findViewById(0x10202c8);
        mBtnPlay = (ImageView)findViewById(0x10202c9);
        mBtnNext = (ImageView)findViewById(0x10202ca);
        View aview[] = new View[3];
        aview[0] = mBtnPrev;
        aview[1] = mBtnPlay;
        aview[2] = mBtnNext;
        int i = aview.length;
        for(int j = 0; j < i; j++)
            aview[j].setOnClickListener(this);

    }

    protected void onMeasure(int i, int j) {
        super.onMeasure(i, j);
        Math.min(512, Math.max(getWidth(), getHeight()));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if(parcelable instanceof SavedState) goto _L2; else goto _L1
_L1:
        super.onRestoreInstanceState(parcelable);
_L4:
        return;
_L2:
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        if(savedstate.wasShowing && mWidgetCallbacks != null)
            mWidgetCallbacks.requestShow(this);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        boolean flag;
        if(mWidgetCallbacks != null && mWidgetCallbacks.isVisible(this))
            flag = true;
        else
            flag = false;
        savedstate.wasShowing = flag;
        return savedstate;
    }

    public boolean providesClock() {
        return false;
    }

    public void setCallback(LockScreenWidgetCallback lockscreenwidgetcallback) {
        mWidgetCallbacks = lockscreenwidgetcallback;
    }

    protected static final boolean DEBUG = false;
    private static final int DISPLAY_TIMEOUT_MS = 5000;
    private static final int MAXDIM = 512;
    private static final int MSG_SET_ARTWORK = 103;
    private static final int MSG_SET_GENERATION_ID = 104;
    private static final int MSG_SET_METADATA = 101;
    private static final int MSG_SET_TRANSPORT_CONTROLS = 102;
    private static final int MSG_UPDATE_STATE = 100;
    protected static final String TAG = "TransportControlView";
    private ImageView mAlbumArt;
    private boolean mAttached;
    private AudioManager mAudioManager;
    private ImageView mBtnNext;
    private ImageView mBtnPlay;
    private ImageView mBtnPrev;
    private int mClientGeneration;
    private PendingIntent mClientIntent;
    private int mCurrentPlayState;
    private Handler mHandler;
    private IRemoteControlDisplayWeak mIRCD;
    private Metadata mMetadata;
    private Bundle mPopulateMetadataWhenAttached;
    private TextView mTrackTitle;
    private int mTransportControlFlags;
    private LockScreenWidgetCallback mWidgetCallbacks;



/*
    static int access$002(TransportControlView transportcontrolview, int i) {
        transportcontrolview.mClientGeneration = i;
        return i;
    }

*/








/*
    static PendingIntent access$802(TransportControlView transportcontrolview, PendingIntent pendingintent) {
        transportcontrolview.mClientIntent = pendingintent;
        return pendingintent;
    }

*/
}
