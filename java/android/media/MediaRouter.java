// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.content.*;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.*;
import android.text.TextUtils;
import android.util.Log;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package android.media:
//            IAudioService, RemoteControlClient, AudioRoutesInfo

public class MediaRouter {
    static class VolumeChangeReceiver extends BroadcastReceiver {

        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION") && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) goto _L2; else goto _L1
_L1:
            return;
_L2:
            int i = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
            if(i != intent.getIntExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", 0))
                MediaRouter.systemVolumeChanged(i);
            if(true) goto _L1; else goto _L3
_L3:
        }

        VolumeChangeReceiver() {
        }
    }

    public static abstract class VolumeCallback {

        public abstract void onVolumeSetRequest(RouteInfo routeinfo, int i);

        public abstract void onVolumeUpdateRequest(RouteInfo routeinfo, int i);

        public VolumeCallback() {
        }
    }

    static class VolumeCallbackInfo {

        public final RouteInfo route;
        public final VolumeCallback vcb;

        public VolumeCallbackInfo(VolumeCallback volumecallback, RouteInfo routeinfo) {
            vcb = volumecallback;
            route = routeinfo;
        }
    }

    public static class SimpleCallback extends Callback {

        public void onRouteAdded(MediaRouter mediarouter, RouteInfo routeinfo) {
        }

        public void onRouteChanged(MediaRouter mediarouter, RouteInfo routeinfo) {
        }

        public void onRouteGrouped(MediaRouter mediarouter, RouteInfo routeinfo, RouteGroup routegroup, int i) {
        }

        public void onRouteRemoved(MediaRouter mediarouter, RouteInfo routeinfo) {
        }

        public void onRouteSelected(MediaRouter mediarouter, int i, RouteInfo routeinfo) {
        }

        public void onRouteUngrouped(MediaRouter mediarouter, RouteInfo routeinfo, RouteGroup routegroup) {
        }

        public void onRouteUnselected(MediaRouter mediarouter, int i, RouteInfo routeinfo) {
        }

        public void onRouteVolumeChanged(MediaRouter mediarouter, RouteInfo routeinfo) {
        }

        public SimpleCallback() {
        }
    }

    public static abstract class Callback {

        public abstract void onRouteAdded(MediaRouter mediarouter, RouteInfo routeinfo);

        public abstract void onRouteChanged(MediaRouter mediarouter, RouteInfo routeinfo);

        public abstract void onRouteGrouped(MediaRouter mediarouter, RouteInfo routeinfo, RouteGroup routegroup, int i);

        public abstract void onRouteRemoved(MediaRouter mediarouter, RouteInfo routeinfo);

        public abstract void onRouteSelected(MediaRouter mediarouter, int i, RouteInfo routeinfo);

        public abstract void onRouteUngrouped(MediaRouter mediarouter, RouteInfo routeinfo, RouteGroup routegroup);

        public abstract void onRouteUnselected(MediaRouter mediarouter, int i, RouteInfo routeinfo);

        public abstract void onRouteVolumeChanged(MediaRouter mediarouter, RouteInfo routeinfo);

        public Callback() {
        }
    }

    static class CallbackInfo {

        public final Callback cb;
        public final MediaRouter router;
        public int type;

        public CallbackInfo(Callback callback, int i, MediaRouter mediarouter) {
            cb = callback;
            type = i;
            router = mediarouter;
        }
    }

    public static class RouteCategory {

        public CharSequence getName() {
            return getName(MediaRouter.sStatic.mResources);
        }

        public CharSequence getName(Context context) {
            return getName(context.getResources());
        }

        CharSequence getName(Resources resources) {
            CharSequence charsequence;
            if(mNameResId != 0)
                charsequence = resources.getText(mNameResId);
            else
                charsequence = mName;
            return charsequence;
        }

        public List getRoutes(List list) {
            int i;
            if(list == null)
                list = new ArrayList();
            else
                list.clear();
            i = MediaRouter.getRouteCountStatic();
            for(int j = 0; j < i; j++) {
                RouteInfo routeinfo = MediaRouter.getRouteAtStatic(j);
                if(routeinfo.mCategory == this)
                    list.add(routeinfo);
            }

            return list;
        }

        public int getSupportedTypes() {
            return mTypes;
        }

        public boolean isGroupable() {
            return mGroupable;
        }

        public String toString() {
            return (new StringBuilder()).append("RouteCategory{ name=").append(mName).append(" types=").append(MediaRouter.typesToString(mTypes)).append(" groupable=").append(mGroupable).append(" }").toString();
        }

        final boolean mGroupable;
        CharSequence mName;
        int mNameResId;
        int mTypes;

        RouteCategory(int i, int j, boolean flag) {
            mNameResId = i;
            mTypes = j;
            mGroupable = flag;
        }

        RouteCategory(CharSequence charsequence, int i, boolean flag) {
            mName = charsequence;
            mTypes = i;
            mGroupable = flag;
        }
    }

    public static class RouteGroup extends RouteInfo {

        public void addRoute(RouteInfo routeinfo) {
            if(routeinfo.getGroup() != null)
                throw new IllegalStateException((new StringBuilder()).append("Route ").append(routeinfo).append(" is already part of a group.").toString());
            if(routeinfo.getCategory() != super.mCategory) {
                throw new IllegalArgumentException((new StringBuilder()).append("Route cannot be added to a group with a different category. (Route category=").append(routeinfo.getCategory()).append(" group category=").append(super.mCategory).append(")").toString());
            } else {
                int i = mRoutes.size();
                mRoutes.add(routeinfo);
                routeinfo.mGroup = this;
                mUpdateName = true;
                updateVolume();
                routeUpdated();
                MediaRouter.dispatchRouteGrouped(routeinfo, this, i);
                return;
            }
        }

        public void addRoute(RouteInfo routeinfo, int i) {
            if(routeinfo.getGroup() != null)
                throw new IllegalStateException((new StringBuilder()).append("Route ").append(routeinfo).append(" is already part of a group.").toString());
            if(routeinfo.getCategory() != super.mCategory) {
                throw new IllegalArgumentException((new StringBuilder()).append("Route cannot be added to a group with a different category. (Route category=").append(routeinfo.getCategory()).append(" group category=").append(super.mCategory).append(")").toString());
            } else {
                mRoutes.add(i, routeinfo);
                routeinfo.mGroup = this;
                mUpdateName = true;
                updateVolume();
                routeUpdated();
                MediaRouter.dispatchRouteGrouped(routeinfo, this, i);
                return;
            }
        }

        CharSequence getName(Resources resources) {
            if(mUpdateName)
                updateName();
            return super.getName(resources);
        }

        public RouteInfo getRouteAt(int i) {
            return (RouteInfo)mRoutes.get(i);
        }

        public int getRouteCount() {
            return mRoutes.size();
        }

        void memberNameChanged(RouteInfo routeinfo, CharSequence charsequence) {
            mUpdateName = true;
            routeUpdated();
        }

        void memberStatusChanged(RouteInfo routeinfo, CharSequence charsequence) {
            setStatusInt(charsequence);
        }

        void memberVolumeChanged(RouteInfo routeinfo) {
            updateVolume();
        }

        public void removeRoute(int i) {
            RouteInfo routeinfo = (RouteInfo)mRoutes.remove(i);
            routeinfo.mGroup = null;
            mUpdateName = true;
            updateVolume();
            MediaRouter.dispatchRouteUngrouped(routeinfo, this);
            routeUpdated();
        }

        public void removeRoute(RouteInfo routeinfo) {
            if(routeinfo.getGroup() != this) {
                throw new IllegalArgumentException((new StringBuilder()).append("Route ").append(routeinfo).append(" is not a member of this group.").toString());
            } else {
                mRoutes.remove(routeinfo);
                routeinfo.mGroup = null;
                mUpdateName = true;
                updateVolume();
                MediaRouter.dispatchRouteUngrouped(routeinfo, this);
                routeUpdated();
                return;
            }
        }

        public void requestSetVolume(int i) {
            int j = getVolumeMax();
            if(j != 0) goto _L2; else goto _L1
_L1:
            return;
_L2:
            float f = (float)i / (float)j;
            int k = getRouteCount();
            for(int l = 0; l < k; l++) {
                RouteInfo routeinfo = getRouteAt(l);
                routeinfo.requestSetVolume((int)(f * (float)routeinfo.getVolumeMax()));
            }

            if(i != super.mVolume) {
                super.mVolume = i;
                MediaRouter.dispatchRouteVolumeChanged(this);
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void requestUpdateVolume(int i) {
            if(getVolumeMax() != 0) goto _L2; else goto _L1
_L1:
            return;
_L2:
            int j = getRouteCount();
            int k = 0;
            for(int l = 0; l < j; l++) {
                RouteInfo routeinfo = getRouteAt(l);
                routeinfo.requestUpdateVolume(i);
                int i1 = routeinfo.getVolume();
                if(i1 > k)
                    k = i1;
            }

            if(k != super.mVolume) {
                super.mVolume = k;
                MediaRouter.dispatchRouteVolumeChanged(this);
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        void routeUpdated() {
            int i = 0;
            int j = mRoutes.size();
            if(j == 0) {
                MediaRouter.removeRoute(this);
            } else {
                int k = 0;
                boolean flag = true;
                boolean flag1 = true;
                int l = 0;
                while(l < j)  {
                    RouteInfo routeinfo = (RouteInfo)mRoutes.get(l);
                    i |= routeinfo.mSupportedTypes;
                    int k1 = routeinfo.getVolumeMax();
                    if(k1 > k)
                        k = k1;
                    boolean flag2;
                    boolean flag3;
                    if(routeinfo.getPlaybackType() == 0)
                        flag2 = true;
                    else
                        flag2 = false;
                    flag &= flag2;
                    if(routeinfo.getVolumeHandling() == 0)
                        flag3 = true;
                    else
                        flag3 = false;
                    flag1 &= flag3;
                    l++;
                }
                int i1;
                int j1;
                Drawable drawable;
                if(flag)
                    i1 = 0;
                else
                    i1 = 1;
                super.mPlaybackType = i1;
                if(flag1)
                    j1 = 0;
                else
                    j1 = 1;
                super.mVolumeHandling = j1;
                super.mSupportedTypes = i;
                super.mVolumeMax = k;
                if(j == 1)
                    drawable = ((RouteInfo)mRoutes.get(0)).getIconDrawable();
                else
                    drawable = null;
                super.mIcon = drawable;
                super.routeUpdated();
            }
        }

        public void setIconDrawable(Drawable drawable) {
            super.mIcon = drawable;
        }

        public void setIconResource(int i) {
            setIconDrawable(MediaRouter.sStatic.mResources.getDrawable(i));
        }

        public String toString() {
            StringBuilder stringbuilder = new StringBuilder(super.toString());
            stringbuilder.append('[');
            int i = mRoutes.size();
            for(int j = 0; j < i; j++) {
                if(j > 0)
                    stringbuilder.append(", ");
                stringbuilder.append(mRoutes.get(j));
            }

            stringbuilder.append(']');
            return stringbuilder.toString();
        }

        void updateName() {
            StringBuilder stringbuilder = new StringBuilder();
            int i = mRoutes.size();
            for(int j = 0; j < i; j++) {
                RouteInfo routeinfo = (RouteInfo)mRoutes.get(j);
                if(j > 0)
                    stringbuilder.append(", ");
                stringbuilder.append(routeinfo.mName);
            }

            super.mName = stringbuilder.toString();
            mUpdateName = false;
        }

        void updateVolume() {
            int i = getRouteCount();
            int j = 0;
            for(int k = 0; k < i; k++) {
                int l = getRouteAt(k).getVolume();
                if(l > j)
                    j = l;
            }

            if(j != super.mVolume) {
                super.mVolume = j;
                MediaRouter.dispatchRouteVolumeChanged(this);
            }
        }

        final ArrayList mRoutes = new ArrayList();
        private boolean mUpdateName;

        RouteGroup(RouteCategory routecategory) {
            super(routecategory);
            super.mGroup = this;
            super.mVolumeHandling = 0;
        }
    }

    public static class UserRouteInfo extends RouteInfo {

        private void setPlaybackInfoOnRcc(int i, int j) {
            if(mRcc != null)
                mRcc.setPlaybackInformation(i, j);
        }

        private void updatePlaybackInfoOnRcc() {
            if(mRcc == null || mRcc.getRcseId() == -1)
                break MISSING_BLOCK_LABEL_101;
            mRcc.setPlaybackInformation(3, super.mVolumeMax);
            mRcc.setPlaybackInformation(2, super.mVolume);
            mRcc.setPlaybackInformation(4, super.mVolumeHandling);
            mRcc.setPlaybackInformation(5, super.mPlaybackStream);
            mRcc.setPlaybackInformation(1, super.mPlaybackType);
            MediaRouter.sStatic.mAudioService.registerRemoteVolumeObserverForRcc(mRcc.getRcseId(), super.mRemoteVolObserver);
_L1:
            return;
            RemoteException remoteexception;
            remoteexception;
            Log.e("MediaRouter", "Error registering remote volume observer", remoteexception);
              goto _L1
        }

        public RemoteControlClient getRemoteControlClient() {
            return mRcc;
        }

        public void requestSetVolume(int i) {
            if(super.mVolumeHandling == 1)
                if(super.mVcb == null)
                    Log.e("MediaRouter", "Cannot requestSetVolume on user route - no volume callback set");
                else
                    super.mVcb.vcb.onVolumeSetRequest(this, i);
        }

        public void requestUpdateVolume(int i) {
            if(super.mVolumeHandling == 1)
                if(super.mVcb == null)
                    Log.e("MediaRouter", "Cannot requestChangeVolume on user route - no volumec callback set");
                else
                    super.mVcb.vcb.onVolumeUpdateRequest(this, i);
        }

        public void setIconDrawable(Drawable drawable) {
            super.mIcon = drawable;
        }

        public void setIconResource(int i) {
            setIconDrawable(MediaRouter.sStatic.mResources.getDrawable(i));
        }

        public void setName(int i) {
            super.mNameResId = i;
            super.mName = null;
            routeUpdated();
        }

        public void setName(CharSequence charsequence) {
            super.mName = charsequence;
            routeUpdated();
        }

        public void setPlaybackStream(int i) {
            if(super.mPlaybackStream != i) {
                super.mPlaybackStream = i;
                setPlaybackInfoOnRcc(5, i);
            }
        }

        public void setPlaybackType(int i) {
            if(super.mPlaybackType != i) {
                super.mPlaybackType = i;
                setPlaybackInfoOnRcc(1, i);
            }
        }

        public void setRemoteControlClient(RemoteControlClient remotecontrolclient) {
            mRcc = remotecontrolclient;
            updatePlaybackInfoOnRcc();
        }

        public void setStatus(CharSequence charsequence) {
            setStatusInt(charsequence);
        }

        public void setVolume(int i) {
            int j = Math.max(0, Math.min(i, getVolumeMax()));
            if(super.mVolume != j) {
                super.mVolume = j;
                setPlaybackInfoOnRcc(2, j);
                MediaRouter.dispatchRouteVolumeChanged(this);
                if(super.mGroup != null)
                    super.mGroup.memberVolumeChanged(this);
            }
        }

        public void setVolumeCallback(VolumeCallback volumecallback) {
            super.mVcb = new VolumeCallbackInfo(volumecallback, this);
        }

        public void setVolumeHandling(int i) {
            if(super.mVolumeHandling != i) {
                super.mVolumeHandling = i;
                setPlaybackInfoOnRcc(4, i);
            }
        }

        public void setVolumeMax(int i) {
            if(super.mVolumeMax != i) {
                super.mVolumeMax = i;
                setPlaybackInfoOnRcc(3, i);
            }
        }

        RemoteControlClient mRcc;

        UserRouteInfo(RouteCategory routecategory) {
            super(routecategory);
            super.mSupportedTypes = 0x800000;
            super.mPlaybackType = 1;
            super.mVolumeHandling = 0;
        }
    }

    public static class RouteInfo {

        public RouteCategory getCategory() {
            return mCategory;
        }

        public RouteGroup getGroup() {
            return mGroup;
        }

        public Drawable getIconDrawable() {
            return mIcon;
        }

        public CharSequence getName() {
            return getName(MediaRouter.sStatic.mResources);
        }

        public CharSequence getName(Context context) {
            return getName(context.getResources());
        }

        CharSequence getName(Resources resources) {
            CharSequence charsequence;
            if(mNameResId != 0) {
                charsequence = resources.getText(mNameResId);
                mName = charsequence;
            } else {
                charsequence = mName;
            }
            return charsequence;
        }

        public int getPlaybackStream() {
            return mPlaybackStream;
        }

        public int getPlaybackType() {
            return mPlaybackType;
        }

        public CharSequence getStatus() {
            return mStatus;
        }

        public int getSupportedTypes() {
            return mSupportedTypes;
        }

        public Object getTag() {
            return mTag;
        }

        public int getVolume() {
            if(mPlaybackType != 0) goto _L2; else goto _L1
_L1:
            int i;
            i = 0;
            int j;
            try {
                j = MediaRouter.sStatic.mAudioService.getStreamVolume(mPlaybackStream);
            }
            catch(RemoteException remoteexception) {
                Log.e("MediaRouter", "Error getting local stream volume", remoteexception);
                continue; /* Loop/switch isn't completed */
            }
            i = j;
_L4:
            return i;
_L2:
            i = mVolume;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public int getVolumeHandling() {
            return mVolumeHandling;
        }

        public int getVolumeMax() {
            if(mPlaybackType != 0) goto _L2; else goto _L1
_L1:
            int i;
            i = 0;
            int j;
            try {
                j = MediaRouter.sStatic.mAudioService.getStreamMaxVolume(mPlaybackStream);
            }
            catch(RemoteException remoteexception) {
                Log.e("MediaRouter", "Error getting local stream volume", remoteexception);
                continue; /* Loop/switch isn't completed */
            }
            i = j;
_L4:
            return i;
_L2:
            i = mVolumeMax;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void requestSetVolume(int i) {
            if(mPlaybackType != 0)
                break MISSING_BLOCK_LABEL_38;
            MediaRouter.sStatic.mAudioService.setStreamVolume(mPlaybackStream, i, 0);
_L1:
            return;
            RemoteException remoteexception;
            remoteexception;
            Log.e("MediaRouter", "Error setting local stream volume", remoteexception);
              goto _L1
            Log.e("MediaRouter", (new StringBuilder()).append(getClass().getSimpleName()).append(".requestSetVolume(): ").append("Non-local volume playback on system route? ").append("Could not request volume change.").toString());
              goto _L1
        }

        public void requestUpdateVolume(int i) {
            if(mPlaybackType != 0)
                break MISSING_BLOCK_LABEL_58;
            int j = Math.max(0, Math.min(i + getVolume(), getVolumeMax()));
            MediaRouter.sStatic.mAudioService.setStreamVolume(mPlaybackStream, j, 0);
_L1:
            return;
            RemoteException remoteexception;
            remoteexception;
            Log.e("MediaRouter", "Error setting local stream volume", remoteexception);
              goto _L1
            Log.e("MediaRouter", (new StringBuilder()).append(getClass().getSimpleName()).append(".requestChangeVolume(): ").append("Non-local volume playback on system route? ").append("Could not request volume change.").toString());
              goto _L1
        }

        void routeUpdated() {
            MediaRouter.updateRoute(this);
        }

        void setStatusInt(CharSequence charsequence) {
            if(!charsequence.equals(mStatus)) {
                mStatus = charsequence;
                if(mGroup != null)
                    mGroup.memberStatusChanged(this, charsequence);
                routeUpdated();
            }
        }

        public void setTag(Object obj) {
            mTag = obj;
            routeUpdated();
        }

        public String toString() {
            String s = MediaRouter.typesToString(getSupportedTypes());
            return (new StringBuilder()).append(getClass().getSimpleName()).append("{ name=").append(getName()).append(", status=").append(getStatus()).append(" category=").append(getCategory()).append(" supportedTypes=").append(s).append("}").toString();
        }

        public static final int PLAYBACK_TYPE_LOCAL = 0;
        public static final int PLAYBACK_TYPE_REMOTE = 1;
        public static final int PLAYBACK_VOLUME_FIXED = 0;
        public static final int PLAYBACK_VOLUME_VARIABLE = 1;
        final RouteCategory mCategory;
        RouteGroup mGroup;
        Drawable mIcon;
        CharSequence mName;
        int mNameResId;
        int mPlaybackStream;
        int mPlaybackType;
        final IRemoteVolumeObserver.Stub mRemoteVolObserver = new IRemoteVolumeObserver.Stub() {

            public void dispatchRemoteVolumeUpdate(final int direction, final int value) {
                MediaRouter.sStatic.mHandler.post(new Runnable() {

                    public void run() {
                        if(mVcb != null)
                            if(direction != 0)
                                mVcb.vcb.onVolumeUpdateRequest(mVcb.route, direction);
                            else
                                mVcb.vcb.onVolumeSetRequest(mVcb.route, value);
                    }

                    final _cls1 this$1;
                    final int val$direction;
                    final int val$value;

                         {
                            this$1 = _cls1.this;
                            direction = i;
                            value = j;
                            super();
                        }
                });
            }

            final RouteInfo this$0;

                 {
                    this$0 = RouteInfo.this;
                    super();
                }
        };
        private CharSequence mStatus;
        int mSupportedTypes;
        private Object mTag;
        VolumeCallbackInfo mVcb;
        int mVolume;
        int mVolumeHandling;
        int mVolumeMax;

        RouteInfo(RouteCategory routecategory) {
            mPlaybackType = 0;
            mVolumeMax = 15;
            mVolume = 15;
            mVolumeHandling = 1;
            mPlaybackStream = 3;
            mCategory = routecategory;
        }
    }

    static class Static {

        void startMonitoringRoutes(Context context) {
            AudioRoutesInfo audioroutesinfo;
            mDefaultAudio = new RouteInfo(mSystemCategory);
            mDefaultAudio.mNameResId = 0x10404fd;
            mDefaultAudio.mSupportedTypes = 1;
            MediaRouter.addRoute(mDefaultAudio);
            context.registerReceiver(new VolumeChangeReceiver(), new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            audioroutesinfo = null;
            AudioRoutesInfo audioroutesinfo1 = mAudioService.startWatchingRoutes(mRoutesObserver);
            audioroutesinfo = audioroutesinfo1;
_L2:
            if(audioroutesinfo != null)
                updateRoutes(audioroutesinfo);
            return;
            RemoteException remoteexception;
            remoteexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        void updateRoutes(AudioRoutesInfo audioroutesinfo) {
            if(audioroutesinfo.mMainType != mCurRoutesInfo.mMainType) {
                mCurRoutesInfo.mMainType = audioroutesinfo.mMainType;
                RouteInfo routeinfo;
                int i;
                if((2 & audioroutesinfo.mMainType) != 0 || (1 & audioroutesinfo.mMainType) != 0)
                    i = 0x10404fe;
                else
                if((4 & audioroutesinfo.mMainType) != 0)
                    i = 0x10404ff;
                else
                if((8 & audioroutesinfo.mMainType) != 0)
                    i = 0x1040500;
                else
                    i = 0x10404fd;
                MediaRouter.sStatic.mDefaultAudio.mNameResId = i;
                MediaRouter.dispatchRouteChanged(MediaRouter.sStatic.mDefaultAudio);
            }
            if(TextUtils.equals(audioroutesinfo.mBluetoothName, mCurRoutesInfo.mBluetoothName)) goto _L2; else goto _L1
_L1:
            mCurRoutesInfo.mBluetoothName = audioroutesinfo.mBluetoothName;
            if(mCurRoutesInfo.mBluetoothName == null)
                break MISSING_BLOCK_LABEL_262;
            if(MediaRouter.sStatic.mBluetoothA2dpRoute != null) goto _L4; else goto _L3
_L3:
            routeinfo = new RouteInfo(MediaRouter.sStatic.mSystemCategory);
            routeinfo.mName = mCurRoutesInfo.mBluetoothName;
            routeinfo.mSupportedTypes = 1;
            MediaRouter.sStatic.mBluetoothA2dpRoute = routeinfo;
            MediaRouter.addRoute(MediaRouter.sStatic.mBluetoothA2dpRoute);
            if(mAudioService.isBluetoothA2dpOn())
                MediaRouter.selectRouteStatic(1, mBluetoothA2dpRoute);
_L2:
            return;
            RemoteException remoteexception;
            remoteexception;
            Log.e("MediaRouter", "Error selecting Bluetooth A2DP route", remoteexception);
              goto _L2
_L4:
            MediaRouter.sStatic.mBluetoothA2dpRoute.mName = mCurRoutesInfo.mBluetoothName;
            MediaRouter.dispatchRouteChanged(MediaRouter.sStatic.mBluetoothA2dpRoute);
              goto _L2
            if(MediaRouter.sStatic.mBluetoothA2dpRoute != null) {
                MediaRouter.removeRoute(MediaRouter.sStatic.mBluetoothA2dpRoute);
                MediaRouter.sStatic.mBluetoothA2dpRoute = null;
            }
              goto _L2
        }

        final IAudioService mAudioService = IAudioService.Stub.asInterface(ServiceManager.getService("audio"));
        RouteInfo mBluetoothA2dpRoute;
        final CopyOnWriteArrayList mCallbacks = new CopyOnWriteArrayList();
        final ArrayList mCategories = new ArrayList();
        final AudioRoutesInfo mCurRoutesInfo = new AudioRoutesInfo();
        RouteInfo mDefaultAudio;
        final Handler mHandler;
        final Resources mResources = Resources.getSystem();
        final ArrayList mRoutes = new ArrayList();
        final IAudioRoutesObserver.Stub mRoutesObserver = new IAudioRoutesObserver.Stub() {

            public void dispatchAudioRoutesChanged(final AudioRoutesInfo newRoutes) {
                mHandler.post(new Runnable() {

                    public void run() {
                        updateRoutes(newRoutes);
                    }

                    final _cls1 this$1;
                    final AudioRoutesInfo val$newRoutes;

                         {
                            this$1 = _cls1.this;
                            newRoutes = audioroutesinfo;
                            super();
                        }
                });
            }

            final Static this$0;

                 {
                    this$0 = Static.this;
                    super();
                }
        };
        RouteInfo mSelectedRoute;
        final RouteCategory mSystemCategory = new RouteCategory(0x1040501, 1, false);

        Static(Context context) {
            mHandler = new Handler(context.getMainLooper());
        }
    }


    public MediaRouter(Context context) {
        android/media/MediaRouter$Static;
        JVM INSTR monitorenter ;
        if(sStatic == null) {
            Context context1 = context.getApplicationContext();
            sStatic = new Static(context1);
            sStatic.startMonitoringRoutes(context1);
        }
        return;
    }

    static void addRoute(RouteInfo routeinfo) {
        RouteCategory routecategory = routeinfo.getCategory();
        if(!sStatic.mCategories.contains(routecategory))
            sStatic.mCategories.add(routecategory);
        boolean flag = sStatic.mRoutes.isEmpty();
        if(routecategory.isGroupable() && !(routeinfo instanceof RouteGroup)) {
            RouteGroup routegroup = new RouteGroup(routeinfo.getCategory());
            routegroup.mSupportedTypes = routeinfo.mSupportedTypes;
            sStatic.mRoutes.add(routegroup);
            dispatchRouteAdded(routegroup);
            routegroup.addRoute(routeinfo);
            routeinfo = routegroup;
        } else {
            sStatic.mRoutes.add(routeinfo);
            dispatchRouteAdded(routeinfo);
        }
        if(flag)
            selectRouteStatic(routeinfo.getSupportedTypes(), routeinfo);
    }

    static void dispatchRouteAdded(RouteInfo routeinfo) {
        Iterator iterator = sStatic.mCallbacks.iterator();
        do {
            if(!iterator.hasNext())
                break;
            CallbackInfo callbackinfo = (CallbackInfo)iterator.next();
            if((callbackinfo.type & routeinfo.mSupportedTypes) != 0)
                callbackinfo.cb.onRouteAdded(callbackinfo.router, routeinfo);
        } while(true);
    }

    static void dispatchRouteChanged(RouteInfo routeinfo) {
        Iterator iterator = sStatic.mCallbacks.iterator();
        do {
            if(!iterator.hasNext())
                break;
            CallbackInfo callbackinfo = (CallbackInfo)iterator.next();
            if((callbackinfo.type & routeinfo.mSupportedTypes) != 0)
                callbackinfo.cb.onRouteChanged(callbackinfo.router, routeinfo);
        } while(true);
    }

    static void dispatchRouteGrouped(RouteInfo routeinfo, RouteGroup routegroup, int i) {
        Iterator iterator = sStatic.mCallbacks.iterator();
        do {
            if(!iterator.hasNext())
                break;
            CallbackInfo callbackinfo = (CallbackInfo)iterator.next();
            if((callbackinfo.type & ((RouteInfo) (routegroup)).mSupportedTypes) != 0)
                callbackinfo.cb.onRouteGrouped(callbackinfo.router, routeinfo, routegroup, i);
        } while(true);
    }

    static void dispatchRouteRemoved(RouteInfo routeinfo) {
        Iterator iterator = sStatic.mCallbacks.iterator();
        do {
            if(!iterator.hasNext())
                break;
            CallbackInfo callbackinfo = (CallbackInfo)iterator.next();
            if((callbackinfo.type & routeinfo.mSupportedTypes) != 0)
                callbackinfo.cb.onRouteRemoved(callbackinfo.router, routeinfo);
        } while(true);
    }

    static void dispatchRouteSelected(int i, RouteInfo routeinfo) {
        Iterator iterator = sStatic.mCallbacks.iterator();
        do {
            if(!iterator.hasNext())
                break;
            CallbackInfo callbackinfo = (CallbackInfo)iterator.next();
            if((i & callbackinfo.type) != 0)
                callbackinfo.cb.onRouteSelected(callbackinfo.router, i, routeinfo);
        } while(true);
    }

    static void dispatchRouteUngrouped(RouteInfo routeinfo, RouteGroup routegroup) {
        Iterator iterator = sStatic.mCallbacks.iterator();
        do {
            if(!iterator.hasNext())
                break;
            CallbackInfo callbackinfo = (CallbackInfo)iterator.next();
            if((callbackinfo.type & ((RouteInfo) (routegroup)).mSupportedTypes) != 0)
                callbackinfo.cb.onRouteUngrouped(callbackinfo.router, routeinfo, routegroup);
        } while(true);
    }

    static void dispatchRouteUnselected(int i, RouteInfo routeinfo) {
        Iterator iterator = sStatic.mCallbacks.iterator();
        do {
            if(!iterator.hasNext())
                break;
            CallbackInfo callbackinfo = (CallbackInfo)iterator.next();
            if((i & callbackinfo.type) != 0)
                callbackinfo.cb.onRouteUnselected(callbackinfo.router, i, routeinfo);
        } while(true);
    }

    static void dispatchRouteVolumeChanged(RouteInfo routeinfo) {
        Iterator iterator = sStatic.mCallbacks.iterator();
        do {
            if(!iterator.hasNext())
                break;
            CallbackInfo callbackinfo = (CallbackInfo)iterator.next();
            if((callbackinfo.type & routeinfo.mSupportedTypes) != 0)
                callbackinfo.cb.onRouteVolumeChanged(callbackinfo.router, routeinfo);
        } while(true);
    }

    static RouteInfo getRouteAtStatic(int i) {
        return (RouteInfo)sStatic.mRoutes.get(i);
    }

    static int getRouteCountStatic() {
        return sStatic.mRoutes.size();
    }

    static void removeRoute(RouteInfo routeinfo) {
        if(!sStatic.mRoutes.remove(routeinfo)) goto _L2; else goto _L1
_L1:
        RouteCategory routecategory;
        int i;
        boolean flag;
        int j;
        routecategory = routeinfo.getCategory();
        i = sStatic.mRoutes.size();
        flag = false;
        j = 0;
_L8:
        if(j >= i) goto _L4; else goto _L3
_L3:
        if(routecategory != ((RouteInfo)sStatic.mRoutes.get(j)).getCategory()) goto _L6; else goto _L5
_L5:
        flag = true;
_L4:
        if(routeinfo == sStatic.mSelectedRoute)
            selectRouteStatic(0x800001, sStatic.mDefaultAudio);
        if(!flag)
            sStatic.mCategories.remove(routecategory);
        dispatchRouteRemoved(routeinfo);
_L2:
        return;
_L6:
        j++;
        if(true) goto _L8; else goto _L7
_L7:
    }

    static void selectRouteStatic(int i, RouteInfo routeinfo) {
        if(sStatic.mSelectedRoute != routeinfo) {
label0:
            {
                if((i & routeinfo.getSupportedTypes()) != 0)
                    break label0;
                Log.w("MediaRouter", (new StringBuilder()).append("selectRoute ignored; cannot select route with supported types ").append(typesToString(routeinfo.getSupportedTypes())).append(" into route types ").append(typesToString(i)).toString());
            }
        }
_L5:
        return;
        RouteInfo routeinfo1 = sStatic.mBluetoothA2dpRoute;
        if(routeinfo1 == null || (i & 1) == 0 || routeinfo != routeinfo1 && routeinfo != sStatic.mDefaultAudio) goto _L2; else goto _L1
_L1:
        IAudioService iaudioservice = sStatic.mAudioService;
        if(routeinfo != routeinfo1) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        iaudioservice.setBluetoothA2dpOn(flag);
_L2:
        if(sStatic.mSelectedRoute != null)
            dispatchRouteUnselected(i & sStatic.mSelectedRoute.getSupportedTypes(), sStatic.mSelectedRoute);
        sStatic.mSelectedRoute = routeinfo;
        if(routeinfo != null)
            dispatchRouteSelected(i & routeinfo.getSupportedTypes(), routeinfo);
          goto _L5
_L4:
        flag = false;
          goto _L6
        RemoteException remoteexception;
        remoteexception;
        Log.e("MediaRouter", "Error changing Bluetooth A2DP state", remoteexception);
          goto _L2
    }

    static void systemVolumeChanged(int i) {
        RouteInfo routeinfo = sStatic.mSelectedRoute;
        if(routeinfo != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(routeinfo == sStatic.mBluetoothA2dpRoute || routeinfo == sStatic.mDefaultAudio) {
            dispatchRouteVolumeChanged(routeinfo);
            continue; /* Loop/switch isn't completed */
        }
        if(sStatic.mBluetoothA2dpRoute == null) goto _L4; else goto _L3
_L3:
        if(!sStatic.mAudioService.isBluetoothA2dpOn()) goto _L6; else goto _L5
_L5:
        RouteInfo routeinfo1 = sStatic.mBluetoothA2dpRoute;
_L7:
        RemoteException remoteexception;
        dispatchRouteVolumeChanged(routeinfo1);
        continue; /* Loop/switch isn't completed */
_L6:
        try {
            routeinfo1 = sStatic.mDefaultAudio;
        }
        // Misplaced declaration of an exception variable
        catch(RemoteException remoteexception) {
            Log.e("MediaRouter", "Error checking Bluetooth A2DP state to report volume change", remoteexception);
            continue; /* Loop/switch isn't completed */
        }
        if(true) goto _L7; else goto _L4
_L4:
        dispatchRouteVolumeChanged(sStatic.mDefaultAudio);
        if(true) goto _L1; else goto _L8
_L8:
    }

    static String typesToString(int i) {
        StringBuilder stringbuilder = new StringBuilder();
        if((i & 1) != 0)
            stringbuilder.append("ROUTE_TYPE_LIVE_AUDIO ");
        if((0x800000 & i) != 0)
            stringbuilder.append("ROUTE_TYPE_USER ");
        return stringbuilder.toString();
    }

    static void updateRoute(RouteInfo routeinfo) {
        dispatchRouteChanged(routeinfo);
    }

    public void addCallback(int i, Callback callback) {
        int j;
        int k;
        j = sStatic.mCallbacks.size();
        k = 0;
_L3:
        CallbackInfo callbackinfo;
        if(k >= j)
            break MISSING_BLOCK_LABEL_63;
        callbackinfo = (CallbackInfo)sStatic.mCallbacks.get(k);
        if(callbackinfo.cb != callback) goto _L2; else goto _L1
_L1:
        callbackinfo.type = i | callbackinfo.type;
_L4:
        return;
_L2:
        k++;
          goto _L3
        sStatic.mCallbacks.add(new CallbackInfo(callback, i, this));
          goto _L4
    }

    public void addRouteInt(RouteInfo routeinfo) {
        addRoute(routeinfo);
    }

    public void addUserRoute(UserRouteInfo userrouteinfo) {
        addRoute(userrouteinfo);
    }

    public void clearUserRoutes() {
        for(int i = 0; i < sStatic.mRoutes.size(); i++) {
            RouteInfo routeinfo = (RouteInfo)sStatic.mRoutes.get(i);
            if((routeinfo instanceof UserRouteInfo) || (routeinfo instanceof RouteGroup)) {
                removeRouteAt(i);
                i--;
            }
        }

    }

    public RouteCategory createRouteCategory(int i, boolean flag) {
        return new RouteCategory(i, 0x800000, flag);
    }

    public RouteCategory createRouteCategory(CharSequence charsequence, boolean flag) {
        return new RouteCategory(charsequence, 0x800000, flag);
    }

    public UserRouteInfo createUserRoute(RouteCategory routecategory) {
        return new UserRouteInfo(routecategory);
    }

    public RouteCategory getCategoryAt(int i) {
        return (RouteCategory)sStatic.mCategories.get(i);
    }

    public int getCategoryCount() {
        return sStatic.mCategories.size();
    }

    public RouteInfo getRouteAt(int i) {
        return (RouteInfo)sStatic.mRoutes.get(i);
    }

    public int getRouteCount() {
        return sStatic.mRoutes.size();
    }

    public RouteInfo getSelectedRoute(int i) {
        return sStatic.mSelectedRoute;
    }

    public RouteCategory getSystemAudioCategory() {
        return sStatic.mSystemCategory;
    }

    public RouteInfo getSystemAudioRoute() {
        return sStatic.mDefaultAudio;
    }

    public void removeCallback(Callback callback) {
        int i;
        int j;
        i = sStatic.mCallbacks.size();
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_55;
        if(((CallbackInfo)sStatic.mCallbacks.get(j)).cb != callback) goto _L2; else goto _L1
_L1:
        sStatic.mCallbacks.remove(j);
_L4:
        return;
_L2:
        j++;
          goto _L3
        Log.w("MediaRouter", (new StringBuilder()).append("removeCallback(").append(callback).append("): callback not registered").toString());
          goto _L4
    }

    void removeRouteAt(int i) {
        if(i < 0 || i >= sStatic.mRoutes.size()) goto _L2; else goto _L1
_L1:
        RouteInfo routeinfo;
        RouteCategory routecategory;
        int j;
        boolean flag;
        int k;
        routeinfo = (RouteInfo)sStatic.mRoutes.remove(i);
        routecategory = routeinfo.getCategory();
        j = sStatic.mRoutes.size();
        flag = false;
        k = 0;
_L8:
        if(k >= j) goto _L4; else goto _L3
_L3:
        if(routecategory != ((RouteInfo)sStatic.mRoutes.get(k)).getCategory()) goto _L6; else goto _L5
_L5:
        flag = true;
_L4:
        if(routeinfo == sStatic.mSelectedRoute)
            selectRouteStatic(0x800001, sStatic.mDefaultAudio);
        if(!flag)
            sStatic.mCategories.remove(routecategory);
        dispatchRouteRemoved(routeinfo);
_L2:
        return;
_L6:
        k++;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public void removeRouteInt(RouteInfo routeinfo) {
        removeRoute(routeinfo);
    }

    public void removeUserRoute(UserRouteInfo userrouteinfo) {
        removeRoute(userrouteinfo);
    }

    public void selectRoute(int i, RouteInfo routeinfo) {
        selectRouteStatic(i & 0x800000, routeinfo);
    }

    public void selectRouteInt(int i, RouteInfo routeinfo) {
        selectRouteStatic(i, routeinfo);
    }

    public static final int ROUTE_TYPE_LIVE_AUDIO = 1;
    public static final int ROUTE_TYPE_USER = 0x800000;
    private static final String TAG = "MediaRouter";
    static final HashMap sRouters = new HashMap();
    static Static sStatic;

}
