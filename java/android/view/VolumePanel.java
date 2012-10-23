// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.app.Dialog;
import android.content.*;
import android.content.res.Resources;
import android.media.*;
import android.os.*;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import java.util.HashMap;

// Referenced classes of package android.view:
//            LayoutInflater, View, ViewGroup, Window, 
//            MotionEvent

public class VolumePanel extends Handler
    implements android.widget.SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    private class StreamControl {

        ViewGroup group;
        ImageView icon;
        int iconMuteRes;
        int iconRes;
        SeekBar seekbarView;
        int streamType;
        final VolumePanel this$0;

        private StreamControl() {
            this$0 = VolumePanel.this;
            super();
        }

    }

    private static final class StreamResources extends Enum {

        public static StreamResources valueOf(String s) {
            return (StreamResources)Enum.valueOf(android/view/VolumePanel$StreamResources, s);
        }

        public static StreamResources[] values() {
            return (StreamResources[])$VALUES.clone();
        }

        private static final StreamResources $VALUES[];
        public static final StreamResources AlarmStream;
        public static final StreamResources BluetoothSCOStream;
        public static final StreamResources MasterStream;
        public static final StreamResources MediaStream;
        public static final StreamResources NotificationStream;
        public static final StreamResources RemoteStream;
        public static final StreamResources RingerStream;
        public static final StreamResources VoiceStream;
        int descRes;
        int iconMuteRes;
        int iconRes;
        boolean show;
        int streamType;

        static  {
            BluetoothSCOStream = new StreamResources("BluetoothSCOStream", 0, 6, 0x10403f9, 0x108029e, 0x108029e, false);
            RingerStream = new StreamResources("RingerStream", 1, 2, 0x10403fa, 0x10802a3, 0x10802a4, false);
            VoiceStream = new StreamResources("VoiceStream", 2, 0, 0x10403fb, 0x10802a2, 0x10802a2, false);
            AlarmStream = new StreamResources("AlarmStream", 3, 4, 0x10403f6, 0x108029c, 0x108029d, false);
            MediaStream = new StreamResources("MediaStream", 4, 3, 0x10403fc, 0x10802a6, 0x10802a7, true);
            NotificationStream = new StreamResources("NotificationStream", 5, 5, 0x10403fd, 0x10802a0, 0x10802a1, true);
            MasterStream = new StreamResources("MasterStream", 6, -100, 0x10403fc, 0x10802a6, 0x10802a7, false);
            RemoteStream = new StreamResources("RemoteStream", 7, -200, 0x10403fc, 0x1080315, 0x108030f, false);
            StreamResources astreamresources[] = new StreamResources[8];
            astreamresources[0] = BluetoothSCOStream;
            astreamresources[1] = RingerStream;
            astreamresources[2] = VoiceStream;
            astreamresources[3] = AlarmStream;
            astreamresources[4] = MediaStream;
            astreamresources[5] = NotificationStream;
            astreamresources[6] = MasterStream;
            astreamresources[7] = RemoteStream;
            $VALUES = astreamresources;
        }

        private StreamResources(String s, int i, int j, int k, int l, int i1, boolean flag) {
            super(s, i);
            streamType = j;
            descRes = k;
            iconRes = l;
            iconMuteRes = i1;
            show = flag;
        }
    }


    public VolumePanel(Context context, AudioService audioservice) {
        mActiveStreamType = -1;
        mContext = context;
        mAudioManager = (AudioManager)context.getSystemService("audio");
        mAudioService = audioservice;
        boolean flag = context.getResources().getBoolean(0x111000a);
        if(flag) {
            int i = 0;
            while(i < STREAMS.length)  {
                StreamResources streamresources = STREAMS[i];
                boolean flag2;
                if(streamresources.streamType == -100)
                    flag2 = true;
                else
                    flag2 = false;
                streamresources.show = flag2;
                i++;
            }
        }
        mView = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x10900c3, null);
        mView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View view, MotionEvent motionevent) {
                resetTimeout();
                return false;
            }

            final VolumePanel this$0;

             {
                this$0 = VolumePanel.this;
                super();
            }
        });
        mPanel = (ViewGroup)mView.findViewById(0x1020361);
        mSliderGroup = (ViewGroup)mView.findViewById(0x1020362);
        mMoreButton = (ImageView)mView.findViewById(0x10202de);
        mDivider = (ImageView)mView.findViewById(0x1020363);
        mDialog = new Dialog(context, 0x10302f5) {

            public boolean onTouchEvent(MotionEvent motionevent) {
                boolean flag3;
                if(isShowing() && motionevent.getAction() == 4) {
                    forceTimeout();
                    flag3 = true;
                } else {
                    flag3 = false;
                }
                return flag3;
            }

            final VolumePanel this$0;

             {
                this$0 = VolumePanel.this;
                super(context, i);
            }
        };
        mDialog.setTitle("Volume control");
        mDialog.setContentView(mView);
        mDialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            public void onDismiss(DialogInterface dialoginterface) {
                mActiveStreamType = -1;
                mAudioManager.forceVolumeControlStream(mActiveStreamType);
            }

            final VolumePanel this$0;

             {
                this$0 = VolumePanel.this;
                super();
            }
        });
        Window window = mDialog.getWindow();
        window.setGravity(48);
        WindowManager.LayoutParams layoutparams = window.getAttributes();
        layoutparams.token = null;
        layoutparams.y = mContext.getResources().getDimensionPixelOffset(0x105004a);
        layoutparams.type = 2020;
        layoutparams.width = -2;
        layoutparams.height = -2;
        window.setAttributes(layoutparams);
        window.addFlags(0x40028);
        mToneGenerators = new ToneGenerator[AudioSystem.getNumStreamTypes()];
        mVibrator = (Vibrator)context.getSystemService("vibrator");
        mVoiceCapable = context.getResources().getBoolean(0x1110028);
        boolean flag1;
        if(!mVoiceCapable && !flag)
            flag1 = true;
        else
            flag1 = false;
        mShowCombinedVolumes = flag1;
        if(!mShowCombinedVolumes) {
            mMoreButton.setVisibility(8);
            mDivider.setVisibility(8);
        } else {
            mMoreButton.setOnClickListener(this);
        }
        listenToRingerMode();
    }

    private void addOtherVolumes() {
        if(mShowCombinedVolumes) {
            int i = 0;
            while(i < STREAMS.length)  {
                int j = STREAMS[i].streamType;
                if(STREAMS[i].show && j != mActiveStreamType) {
                    StreamControl streamcontrol = (StreamControl)mStreamControls.get(Integer.valueOf(j));
                    mSliderGroup.addView(streamcontrol.group);
                    updateSlider(streamcontrol);
                }
                i++;
            }
        }
    }

    private void collapse() {
        mMoreButton.setVisibility(0);
        mDivider.setVisibility(0);
        int i = mSliderGroup.getChildCount();
        for(int j = 1; j < i; j++)
            mSliderGroup.getChildAt(j).setVisibility(8);

    }

    private void createSliders() {
        LayoutInflater layoutinflater = (LayoutInflater)mContext.getSystemService("layout_inflater");
        mStreamControls = new HashMap(STREAMS.length);
        Resources resources = mContext.getResources();
        int i = 0;
        while(i < STREAMS.length)  {
            StreamResources streamresources = STREAMS[i];
            int j = streamresources.streamType;
            if(mVoiceCapable && streamresources == StreamResources.NotificationStream)
                streamresources = StreamResources.RingerStream;
            StreamControl streamcontrol = new StreamControl();
            streamcontrol.streamType = j;
            streamcontrol.group = (ViewGroup)layoutinflater.inflate(0x10900c4, null);
            streamcontrol.group.setTag(streamcontrol);
            streamcontrol.icon = (ImageView)streamcontrol.group.findViewById(0x1020364);
            streamcontrol.icon.setTag(streamcontrol);
            streamcontrol.icon.setContentDescription(resources.getString(streamresources.descRes));
            streamcontrol.iconRes = streamresources.iconRes;
            streamcontrol.iconMuteRes = streamresources.iconMuteRes;
            streamcontrol.icon.setImageResource(streamcontrol.iconRes);
            streamcontrol.seekbarView = (SeekBar)streamcontrol.group.findViewById(0x102030c);
            int k;
            if(j == 6 || j == 0)
                k = 1;
            else
                k = 0;
            streamcontrol.seekbarView.setMax(k + getStreamMaxVolume(j));
            streamcontrol.seekbarView.setOnSeekBarChangeListener(this);
            streamcontrol.seekbarView.setTag(streamcontrol);
            mStreamControls.put(Integer.valueOf(j), streamcontrol);
            i++;
        }
    }

    private void expand() {
        int i = mSliderGroup.getChildCount();
        for(int j = 0; j < i; j++)
            mSliderGroup.getChildAt(j).setVisibility(0);

        mMoreButton.setVisibility(4);
        mDivider.setVisibility(4);
    }

    private void forceTimeout() {
        removeMessages(5);
        sendMessage(obtainMessage(5));
    }

    private ToneGenerator getOrCreateToneGenerator(int i) {
        if(i != -100) goto _L2; else goto _L1
_L1:
        ToneGenerator tonegenerator1 = null;
_L3:
        return tonegenerator1;
_L2:
        this;
        JVM INSTR monitorenter ;
        ToneGenerator tonegenerator = mToneGenerators[i];
        if(tonegenerator != null)
            break MISSING_BLOCK_LABEL_41;
        mToneGenerators[i] = new ToneGenerator(i, 100);
_L5:
        tonegenerator1 = mToneGenerators[i];
        this;
        JVM INSTR monitorexit ;
          goto _L3
        Exception exception;
        exception;
        throw exception;
        RuntimeException runtimeexception;
        runtimeexception;
        if(!LOGD) goto _L5; else goto _L4
_L4:
        Log.d("VolumePanel", (new StringBuilder()).append("ToneGenerator constructor failed with RuntimeException: ").append(runtimeexception).toString());
          goto _L5
    }

    private int getStreamMaxVolume(int i) {
        int j;
        if(i == -100)
            j = mAudioManager.getMasterMaxVolume();
        else
        if(i == -200)
            j = mAudioService.getRemoteStreamMaxVolume();
        else
            j = mAudioManager.getStreamMaxVolume(i);
        return j;
    }

    private int getStreamVolume(int i) {
        int j;
        if(i == -100)
            j = mAudioManager.getMasterVolume();
        else
        if(i == -200)
            j = mAudioService.getRemoteStreamVolume();
        else
            j = mAudioManager.getStreamVolume(i);
        return j;
    }

    private boolean isExpanded() {
        boolean flag;
        if(mMoreButton.getVisibility() != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean isMuted(int i) {
        boolean flag;
        if(i == -100)
            flag = mAudioManager.isMasterMute();
        else
        if(i == -200) {
            if(mAudioService.getRemoteStreamVolume() <= 0)
                flag = true;
            else
                flag = false;
        } else {
            flag = mAudioManager.isStreamMute(i);
        }
        return flag;
    }

    private void listenToRingerMode() {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.media.RINGER_MODE_CHANGED");
        mContext.registerReceiver(new BroadcastReceiver() {

            public void onReceive(Context context, Intent intent) {
                if("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
                    removeMessages(6);
                    sendMessage(obtainMessage(6));
                }
            }

            final VolumePanel this$0;

             {
                this$0 = VolumePanel.this;
                super();
            }
        }, intentfilter);
    }

    private void reorderSliders(int i) {
        mSliderGroup.removeAllViews();
        StreamControl streamcontrol = (StreamControl)mStreamControls.get(Integer.valueOf(i));
        if(streamcontrol == null) {
            Log.e("VolumePanel", (new StringBuilder()).append("Missing stream type! - ").append(i).toString());
            mActiveStreamType = -1;
        } else {
            mSliderGroup.addView(streamcontrol.group);
            mActiveStreamType = i;
            streamcontrol.group.setVisibility(0);
            updateSlider(streamcontrol);
        }
        addOtherVolumes();
    }

    private void resetTimeout() {
        removeMessages(5);
        sendMessageDelayed(obtainMessage(5), 3000L);
    }

    private void setMusicIcon(int i, int j) {
        StreamControl streamcontrol = (StreamControl)mStreamControls.get(Integer.valueOf(3));
        if(streamcontrol != null) {
            streamcontrol.iconRes = i;
            streamcontrol.iconMuteRes = j;
            ImageView imageview = streamcontrol.icon;
            int k;
            if(isMuted(streamcontrol.streamType))
                k = streamcontrol.iconMuteRes;
            else
                k = streamcontrol.iconRes;
            imageview.setImageResource(k);
        }
    }

    private void setStreamVolume(int i, int j, int k) {
        if(i == -100)
            mAudioManager.setMasterVolume(j, k);
        else
        if(i == -200)
            mAudioService.setRemoteStreamVolume(j);
        else
            mAudioManager.setStreamVolume(i, j, k);
    }

    private void updateSlider(StreamControl streamcontrol) {
        streamcontrol.seekbarView.setProgress(getStreamVolume(streamcontrol.streamType));
        boolean flag = isMuted(streamcontrol.streamType);
        ImageView imageview = streamcontrol.icon;
        int i;
        if(flag)
            i = streamcontrol.iconMuteRes;
        else
            i = streamcontrol.iconRes;
        imageview.setImageResource(i);
        if(streamcontrol.streamType == 2 && mAudioManager.getRingerMode() == 1)
            streamcontrol.icon.setImageResource(0x10802a5);
        if(streamcontrol.streamType == -200)
            streamcontrol.seekbarView.setEnabled(true);
        else
        if(streamcontrol.streamType != mAudioManager.getMasterStreamType() && flag)
            streamcontrol.seekbarView.setEnabled(false);
        else
            streamcontrol.seekbarView.setEnabled(true);
    }

    private void updateStates() {
        int i = mSliderGroup.getChildCount();
        for(int j = 0; j < i; j++)
            updateSlider((StreamControl)mSliderGroup.getChildAt(j).getTag());

    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 0 10: default 64
    //                   0 65
    //                   1 95
    //                   2 109
    //                   3 102
    //                   4 124
    //                   5 131
    //                   6 157
    //                   7 80
    //                   8 174
    //                   9 189
    //                   10 196;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
        return;
_L2:
        onVolumeChanged(message.arg1, message.arg2);
        continue; /* Loop/switch isn't completed */
_L9:
        onMuteChanged(message.arg1, message.arg2);
        continue; /* Loop/switch isn't completed */
_L3:
        onFreeResources();
        continue; /* Loop/switch isn't completed */
_L5:
        onStopSounds();
        continue; /* Loop/switch isn't completed */
_L4:
        onPlaySound(message.arg1, message.arg2);
        continue; /* Loop/switch isn't completed */
_L6:
        onVibrate();
        continue; /* Loop/switch isn't completed */
_L7:
        if(mDialog.isShowing()) {
            mDialog.dismiss();
            mActiveStreamType = -1;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if(mDialog.isShowing())
            updateStates();
        continue; /* Loop/switch isn't completed */
_L10:
        onRemoteVolumeChanged(message.arg1, message.arg2);
        continue; /* Loop/switch isn't completed */
_L11:
        onRemoteVolumeUpdateIfShown();
        continue; /* Loop/switch isn't completed */
_L12:
        onSliderVisibilityChanged(message.arg1, message.arg2);
        if(true) goto _L1; else goto _L13
_L13:
    }

    public void onClick(View view) {
        if(view == mMoreButton)
            expand();
        resetTimeout();
    }

    protected void onFreeResources() {
        this;
        JVM INSTR monitorenter ;
        for(int i = -1 + mToneGenerators.length; i >= 0; i--) {
            if(mToneGenerators[i] != null)
                mToneGenerators[i].release();
            mToneGenerators[i] = null;
        }

        return;
    }

    protected void onMuteChanged(int i, int j) {
        if(LOGD)
            Log.d("VolumePanel", (new StringBuilder()).append("onMuteChanged(streamType: ").append(i).append(", flags: ").append(j).append(")").toString());
        StreamControl streamcontrol = (StreamControl)mStreamControls.get(Integer.valueOf(i));
        if(streamcontrol != null) {
            ImageView imageview = streamcontrol.icon;
            int k;
            if(isMuted(streamcontrol.streamType))
                k = streamcontrol.iconMuteRes;
            else
                k = streamcontrol.iconRes;
            imageview.setImageResource(k);
        }
        onVolumeChanged(i, j);
    }

    protected void onPlaySound(int i, int j) {
        if(hasMessages(3)) {
            removeMessages(3);
            onStopSounds();
        }
        this;
        JVM INSTR monitorenter ;
        ToneGenerator tonegenerator = getOrCreateToneGenerator(i);
        if(tonegenerator != null) {
            tonegenerator.startTone(24);
            sendMessageDelayed(obtainMessage(3), 150L);
        }
        return;
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag) {
        Object obj = seekbar.getTag();
        if(flag && (obj instanceof StreamControl)) {
            StreamControl streamcontrol = (StreamControl)obj;
            if(getStreamVolume(streamcontrol.streamType) != i)
                setStreamVolume(streamcontrol.streamType, i, 0);
        }
        resetTimeout();
    }

    protected void onRemoteVolumeChanged(int i, int j) {
        if(LOGD)
            Log.d("VolumePanel", (new StringBuilder()).append("onRemoteVolumeChanged(stream:").append(i).append(", flags: ").append(j).append(")").toString());
        if((j & 1) == 0 && !mDialog.isShowing()) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if(mActiveStreamType != -200)
            reorderSliders(-200);
        onShowVolumeChanged(-200, j);
        this;
        JVM INSTR monitorexit ;
_L4:
        if((j & 4) != 0 && !mRingIsSilent) {
            removeMessages(2);
            sendMessageDelayed(obtainMessage(2, i, j), 300L);
        }
        if((j & 8) != 0) {
            removeMessages(2);
            removeMessages(4);
            onStopSounds();
        }
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), 10000L);
        resetTimeout();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        if(LOGD)
            Log.d("VolumePanel", "not calling onShowVolumeChanged(), no FLAG_SHOW_UI or no UI");
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void onRemoteVolumeUpdateIfShown() {
        if(LOGD)
            Log.d("VolumePanel", "onRemoteVolumeUpdateIfShown()");
        if(mDialog.isShowing() && mActiveStreamType == -200 && mStreamControls != null)
            onShowVolumeChanged(-200, 0);
    }

    protected void onShowVolumeChanged(int i, int j) {
        int k;
        int l;
        k = getStreamVolume(i);
        mRingIsSilent = false;
        if(LOGD)
            Log.d("VolumePanel", (new StringBuilder()).append("onShowVolumeChanged(streamType: ").append(i).append(", flags: ").append(j).append("), index: ").append(k).toString());
        l = getStreamMaxVolume(i);
        i;
        JVM INSTR lookupswitch 7: default 136
    //                   -200: 430
    //                   0: 393
    //                   2: 333
    //                   3: 352
    //                   4: 136
    //                   5: 402
    //                   6: 421;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_430;
_L8:
        StreamControl streamcontrol = (StreamControl)mStreamControls.get(Integer.valueOf(i));
        if(streamcontrol != null) {
            if(streamcontrol.seekbarView.getMax() != l)
                streamcontrol.seekbarView.setMax(l);
            streamcontrol.seekbarView.setProgress(k);
            if(i != mAudioManager.getMasterStreamType() && i != -200 && isMuted(i))
                streamcontrol.seekbarView.setEnabled(false);
            else
                streamcontrol.seekbarView.setEnabled(true);
        }
        if(!mDialog.isShowing()) {
            int i1;
            if(i == -200)
                i1 = -1;
            else
                i1 = i;
            mAudioManager.forceVolumeControlStream(i1);
            mDialog.setContentView(mView);
            if(mShowCombinedVolumes)
                collapse();
            mDialog.show();
        }
        if(i != -200 && (j & 0x10) != 0 && mAudioService.isStreamAffectedByRingerMode(i) && mAudioManager.getRingerMode() == 1)
            sendMessageDelayed(obtainMessage(4), 300L);
        return;
_L4:
        if(RingtoneManager.getActualDefaultRingtoneUri(mContext, 1) == null)
            mRingIsSilent = true;
          goto _L8
_L5:
        if((0x380 & mAudioManager.getDevicesForStream(3)) != 0)
            setMusicIcon(0x108029e, 0x108029f);
        else
            setMusicIcon(0x10802a6, 0x10802a7);
          goto _L8
_L3:
        k++;
        l++;
          goto _L8
_L6:
        if(RingtoneManager.getActualDefaultRingtoneUri(mContext, 2) == null)
            mRingIsSilent = true;
          goto _L8
_L7:
        k++;
        l++;
          goto _L8
        if(LOGD)
            Log.d("VolumePanel", (new StringBuilder()).append("showing remote volume ").append(k).append(" over ").append(l).toString());
          goto _L8
    }

    /**
     * @deprecated Method onSliderVisibilityChanged is deprecated
     */

    protected void onSliderVisibilityChanged(int i, int j) {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        if(LOGD)
            Log.d("VolumePanel", (new StringBuilder()).append("onSliderVisibilityChanged(stream=").append(i).append(", visi=").append(j).append(")").toString());
          goto _L1
_L7:
        int k = -1 + STREAMS.length;
_L6:
        if(k < 0) goto _L3; else goto _L2
_L2:
        StreamResources streamresources = STREAMS[k];
        if(streamresources.streamType != i) goto _L5; else goto _L4
_L4:
        streamresources.show = flag;
        if(!flag && mActiveStreamType == i)
            mActiveStreamType = -1;
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L8:
        flag = false;
        break; /* Loop/switch isn't completed */
_L5:
        k--;
          goto _L6
        Exception exception;
        exception;
        throw exception;
_L1:
        if(j != flag) goto _L8; else goto _L7
    }

    public void onStartTrackingTouch(SeekBar seekbar) {
    }

    protected void onStopSounds() {
        this;
        JVM INSTR monitorenter ;
        int i = -1 + AudioSystem.getNumStreamTypes();
        do {
            if(i >= 0) {
                ToneGenerator tonegenerator = mToneGenerators[i];
                if(tonegenerator != null)
                    tonegenerator.stopTone();
            } else {
                return;
            }
            i--;
        } while(true);
    }

    public void onStopTrackingTouch(SeekBar seekbar) {
        Object obj = seekbar.getTag();
        if((obj instanceof StreamControl) && ((StreamControl)obj).streamType == -200)
            seekbar.setProgress(getStreamVolume(-200));
    }

    protected void onVibrate() {
        if(mAudioManager.getRingerMode() == 1)
            mVibrator.vibrate(300L);
    }

    protected void onVolumeChanged(int i, int j) {
        if(LOGD)
            Log.d("VolumePanel", (new StringBuilder()).append("onVolumeChanged(streamType: ").append(i).append(", flags: ").append(j).append(")").toString());
        if((j & 1) == 0) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if(mActiveStreamType != i)
            reorderSliders(i);
        onShowVolumeChanged(i, j);
        this;
        JVM INSTR monitorexit ;
_L2:
        if((j & 4) != 0 && !mRingIsSilent) {
            removeMessages(2);
            sendMessageDelayed(obtainMessage(2, i, j), 300L);
        }
        if((j & 8) != 0) {
            removeMessages(2);
            removeMessages(4);
            onStopSounds();
        }
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), 10000L);
        resetTimeout();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void postHasNewRemotePlaybackInfo() {
        if(!hasMessages(9))
            obtainMessage(9).sendToTarget();
    }

    public void postMasterMuteChanged(int i) {
        postMuteChanged(-100, i);
    }

    public void postMasterVolumeChanged(int i) {
        postVolumeChanged(-100, i);
    }

    public void postMuteChanged(int i, int j) {
        if(!hasMessages(0)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        this;
        JVM INSTR monitorenter ;
        if(mStreamControls == null)
            createSliders();
        this;
        JVM INSTR monitorexit ;
        removeMessages(1);
        obtainMessage(7, i, j).sendToTarget();
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void postRemoteSliderVisibility(boolean flag) {
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        obtainMessage(10, -200, i).sendToTarget();
    }

    public void postRemoteVolumeChanged(int i, int j) {
        if(!hasMessages(8)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        this;
        JVM INSTR monitorenter ;
        if(mStreamControls == null)
            createSliders();
        this;
        JVM INSTR monitorexit ;
        removeMessages(1);
        obtainMessage(8, i, j).sendToTarget();
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void postVolumeChanged(int i, int j) {
        if(!hasMessages(0)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        this;
        JVM INSTR monitorenter ;
        if(mStreamControls == null)
            createSliders();
        this;
        JVM INSTR monitorexit ;
        removeMessages(1);
        obtainMessage(0, i, j).sendToTarget();
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static final int BEEP_DURATION = 150;
    private static final int FREE_DELAY = 10000;
    private static boolean LOGD = false;
    private static final int MAX_VOLUME = 100;
    private static final int MSG_FREE_RESOURCES = 1;
    private static final int MSG_MUTE_CHANGED = 7;
    private static final int MSG_PLAY_SOUND = 2;
    private static final int MSG_REMOTE_VOLUME_CHANGED = 8;
    private static final int MSG_REMOTE_VOLUME_UPDATE_IF_SHOWN = 9;
    private static final int MSG_RINGER_MODE_CHANGED = 6;
    private static final int MSG_SLIDER_VISIBILITY_CHANGED = 10;
    private static final int MSG_STOP_SOUNDS = 3;
    private static final int MSG_TIMEOUT = 5;
    private static final int MSG_VIBRATE = 4;
    private static final int MSG_VOLUME_CHANGED = 0;
    public static final int PLAY_SOUND_DELAY = 300;
    private static final StreamResources STREAMS[];
    private static final int STREAM_MASTER = -100;
    private static final String TAG = "VolumePanel";
    private static final int TIMEOUT_DELAY = 3000;
    public static final int VIBRATE_DELAY = 300;
    private static final int VIBRATE_DURATION = 300;
    private int mActiveStreamType;
    private AudioManager mAudioManager;
    protected AudioService mAudioService;
    protected Context mContext;
    private final Dialog mDialog;
    private final View mDivider;
    private final View mMoreButton;
    private final ViewGroup mPanel;
    private boolean mRingIsSilent;
    private boolean mShowCombinedVolumes;
    private final ViewGroup mSliderGroup;
    private HashMap mStreamControls;
    private ToneGenerator mToneGenerators[];
    private Vibrator mVibrator;
    private final View mView;
    private boolean mVoiceCapable;

    static  {
        LOGD = false;
        StreamResources astreamresources[] = new StreamResources[8];
        astreamresources[0] = StreamResources.BluetoothSCOStream;
        astreamresources[1] = StreamResources.RingerStream;
        astreamresources[2] = StreamResources.VoiceStream;
        astreamresources[3] = StreamResources.MediaStream;
        astreamresources[4] = StreamResources.NotificationStream;
        astreamresources[5] = StreamResources.AlarmStream;
        astreamresources[6] = StreamResources.MasterStream;
        astreamresources[7] = StreamResources.RemoteStream;
        STREAMS = astreamresources;
    }





/*
    static int access$202(VolumePanel volumepanel, int i) {
        volumepanel.mActiveStreamType = i;
        return i;
    }

*/

}
