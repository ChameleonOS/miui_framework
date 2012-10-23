// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.ContentObserver;
import android.media.*;
import android.net.Uri;
import android.os.*;
import android.util.AttributeSet;
import android.view.*;
import android.widget.SeekBar;

// Referenced classes of package android.preference:
//            SeekBarDialogPreference, PreferenceManager

public class VolumePreference extends SeekBarDialogPreference
    implements PreferenceManager.OnActivityStopListener, android.view.View.OnKeyListener {
    public class SeekBarVolumizer
        implements android.widget.SeekBar.OnSeekBarChangeListener, Runnable {

        private void initSeekBar(SeekBar seekbar, Uri uri) {
            seekbar.setMax(mAudioManager.getStreamMaxVolume(mStreamType));
            mOriginalStreamVolume = mAudioManager.getStreamVolume(mStreamType);
            seekbar.setProgress(mOriginalStreamVolume);
            seekbar.setOnSeekBarChangeListener(this);
            mContext.getContentResolver().registerContentObserver(android.provider.Settings.System.getUriFor(android.provider.Settings.System.VOLUME_SETTINGS[mStreamType]), false, mVolumeObserver);
            if(uri == null)
                if(mStreamType == 2)
                    uri = android.provider.Settings.System.DEFAULT_RINGTONE_URI;
                else
                if(mStreamType == 5)
                    uri = android.provider.Settings.System.DEFAULT_NOTIFICATION_URI;
                else
                    uri = android.provider.Settings.System.DEFAULT_ALARM_ALERT_URI;
            mRingtone = RingtoneManager.getRingtone(mContext, uri);
            if(mRingtone != null)
                mRingtone.setStreamType(mStreamType);
        }

        public void changeVolumeBy(int i) {
            mSeekBar.incrementProgressBy(i);
            if(!isSamplePlaying())
                startSample();
            postSetVolume(mSeekBar.getProgress());
            mVolumeBeforeMute = -1;
        }

        public SeekBar getSeekBar() {
            return mSeekBar;
        }

        public boolean isSamplePlaying() {
            boolean flag;
            if(mRingtone != null && mRingtone.isPlaying())
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void muteVolume() {
            if(mVolumeBeforeMute != -1) {
                mSeekBar.setProgress(mVolumeBeforeMute);
                startSample();
                postSetVolume(mVolumeBeforeMute);
                mVolumeBeforeMute = -1;
            } else {
                mVolumeBeforeMute = mSeekBar.getProgress();
                mSeekBar.setProgress(0);
                stopSample();
                postSetVolume(0);
            }
        }

        public void onProgressChanged(SeekBar seekbar, int i, boolean flag) {
            if(flag)
                postSetVolume(i);
        }

        public void onRestoreInstanceState(VolumeStore volumestore) {
            if(volumestore.volume != -1) {
                mOriginalStreamVolume = volumestore.originalVolume;
                mLastProgress = volumestore.volume;
                postSetVolume(mLastProgress);
            }
        }

        public void onSaveInstanceState(VolumeStore volumestore) {
            if(mLastProgress >= 0) {
                volumestore.volume = mLastProgress;
                volumestore.originalVolume = mOriginalStreamVolume;
            }
        }

        public void onStartTrackingTouch(SeekBar seekbar) {
        }

        public void onStopTrackingTouch(SeekBar seekbar) {
            if(!isSamplePlaying())
                startSample();
        }

        void postSetVolume(int i) {
            mLastProgress = i;
            mHandler.removeCallbacks(this);
            mHandler.post(this);
        }

        public void revertVolume() {
            mAudioManager.setStreamVolume(mStreamType, mOriginalStreamVolume, 0);
        }

        public void run() {
            mAudioManager.setStreamVolume(mStreamType, mLastProgress, 0);
        }

        public void startSample() {
            onSampleStarting(this);
            if(mRingtone != null)
                mRingtone.play();
        }

        public void stop() {
            stopSample();
            mContext.getContentResolver().unregisterContentObserver(mVolumeObserver);
            mSeekBar.setOnSeekBarChangeListener(null);
        }

        public void stopSample() {
            if(mRingtone != null)
                mRingtone.stop();
        }

        private AudioManager mAudioManager;
        private Context mContext;
        private Handler mHandler;
        private int mLastProgress;
        private int mOriginalStreamVolume;
        private Ringtone mRingtone;
        private SeekBar mSeekBar;
        private int mStreamType;
        private int mVolumeBeforeMute;
        private ContentObserver mVolumeObserver;
        final VolumePreference this$0;




        public SeekBarVolumizer(Context context, SeekBar seekbar, int i) {
            this(context, seekbar, i, null);
        }

        public SeekBarVolumizer(Context context, SeekBar seekbar, int i, Uri uri) {
            this$0 = VolumePreference.this;
            super();
            mHandler = new Handler();
            mLastProgress = -1;
            mVolumeBeforeMute = -1;
            mVolumeObserver = new ContentObserver(mHandler) {

                public void onChange(boolean flag) {
                    super.onChange(flag);
                    if(mSeekBar != null && mAudioManager != null) {
                        int j = mAudioManager.getStreamVolume(mStreamType);
                        mSeekBar.setProgress(j);
                    }
                }

                final SeekBarVolumizer this$1;

                 {
                    this$1 = SeekBarVolumizer.this;
                    super(handler);
                }
            };
            mContext = context;
            mAudioManager = (AudioManager)context.getSystemService("audio");
            mStreamType = i;
            mSeekBar = seekbar;
            initSeekBar(seekbar, uri);
        }
    }

    private static class SavedState extends Preference.BaseSavedState {

        VolumeStore getVolumeStore() {
            return mVolumeStore;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(mVolumeStore.volume);
            parcel.writeInt(mVolumeStore.originalVolume);
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
        VolumeStore mVolumeStore;


        public SavedState(Parcel parcel) {
            super(parcel);
            mVolumeStore = new VolumeStore();
            mVolumeStore.volume = parcel.readInt();
            mVolumeStore.originalVolume = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            mVolumeStore = new VolumeStore();
        }
    }

    public static class VolumeStore {

        public int originalVolume;
        public int volume;

        public VolumeStore() {
            volume = -1;
            originalVolume = -1;
        }
    }


    public VolumePreference(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.VolumePreference, 0, 0);
        mStreamType = typedarray.getInt(0, 0);
        typedarray.recycle();
    }

    private void cleanup() {
        getPreferenceManager().unregisterOnActivityStopListener(this);
        if(mSeekBarVolumizer != null) {
            Dialog dialog = getDialog();
            if(dialog != null && dialog.isShowing()) {
                View view = dialog.getWindow().getDecorView().findViewById(0x102030c);
                if(view != null)
                    view.setOnKeyListener(null);
                mSeekBarVolumizer.revertVolume();
            }
            mSeekBarVolumizer.stop();
            mSeekBarVolumizer = null;
        }
    }

    public void onActivityStop() {
        if(mSeekBarVolumizer != null)
            mSeekBarVolumizer.stopSample();
    }

    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        SeekBar seekbar = (SeekBar)view.findViewById(0x102030c);
        mSeekBarVolumizer = new SeekBarVolumizer(getContext(), seekbar, mStreamType);
        getPreferenceManager().registerOnActivityStopListener(this);
        view.setOnKeyListener(this);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }

    protected void onDialogClosed(boolean flag) {
        super.onDialogClosed(flag);
        if(!flag && mSeekBarVolumizer != null)
            mSeekBarVolumizer.revertVolume();
        cleanup();
    }

    public boolean onKey(View view, int i, KeyEvent keyevent) {
        boolean flag = true;
        if(mSeekBarVolumizer != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1;
        if(keyevent.getAction() == 0)
            flag1 = flag;
        else
            flag1 = false;
        switch(i) {
        default:
            flag = false;
            break;

        case 25: // '\031'
            if(flag1)
                mSeekBarVolumizer.changeVolumeBy(-1);
            break;

        case 24: // '\030'
            if(flag1)
                mSeekBarVolumizer.changeVolumeBy(flag);
            break;

        case 164: 
            if(flag1)
                mSeekBarVolumizer.muteVolume();
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if(parcelable != null && parcelable.getClass().equals(android/preference/VolumePreference$SavedState)) goto _L2; else goto _L1
_L1:
        super.onRestoreInstanceState(parcelable);
_L4:
        return;
_L2:
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        if(mSeekBarVolumizer != null)
            mSeekBarVolumizer.onRestoreInstanceState(savedstate.getVolumeStore());
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void onSampleStarting(SeekBarVolumizer seekbarvolumizer) {
        if(mSeekBarVolumizer != null && seekbarvolumizer != mSeekBarVolumizer)
            mSeekBarVolumizer.stopSample();
    }

    protected Parcelable onSaveInstanceState() {
        Object obj = super.onSaveInstanceState();
        if(!isPersistent()) {
            SavedState savedstate = new SavedState(((Parcelable) (obj)));
            if(mSeekBarVolumizer != null)
                mSeekBarVolumizer.onSaveInstanceState(savedstate.getVolumeStore());
            obj = savedstate;
        }
        return ((Parcelable) (obj));
    }

    public void setStreamType(int i) {
        mStreamType = i;
    }

    private static final String TAG = "VolumePreference";
    private SeekBarVolumizer mSeekBarVolumizer;
    private int mStreamType;
}
