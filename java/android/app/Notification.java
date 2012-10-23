// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.*;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.text.NumberFormat;
import java.util.ArrayList;

// Referenced classes of package android.app:
//            PendingIntent

public class Notification
    implements Parcelable {
    public static class InboxStyle extends Style {

        private RemoteViews makeBigContentView() {
            super.mBuilder.mContentText = null;
            RemoteViews remoteviews = getStandardView(0x1090075);
            remoteviews.setViewVisibility(0x1020015, 8);
            int ai[] = new int[7];
            ai[0] = 0x10202f3;
            ai[1] = 0x10202f4;
            ai[2] = 0x10202f5;
            ai[3] = 0x10202f6;
            ai[4] = 0x10202f7;
            ai[5] = 0x10202f8;
            ai[6] = 0x10202f9;
            int i = ai.length;
            for(int j = 0; j < i; j++)
                remoteviews.setViewVisibility(ai[j], 8);

            for(int k = 0; k < mTexts.size() && k < ai.length; k++) {
                CharSequence charsequence = (CharSequence)mTexts.get(k);
                if(charsequence != null && !charsequence.equals("")) {
                    remoteviews.setViewVisibility(ai[k], 0);
                    remoteviews.setTextViewText(ai[k], charsequence);
                }
            }

            if(mTexts.size() > ai.length)
                remoteviews.setViewVisibility(0x10202fa, 0);
            else
                remoteviews.setViewVisibility(0x10202fa, 8);
            return remoteviews;
        }

        public InboxStyle addLine(CharSequence charsequence) {
            mTexts.add(charsequence);
            return this;
        }

        public Notification build() {
            checkBuilder();
            Notification notification = super.mBuilder.buildUnstyled();
            notification.bigContentView = makeBigContentView();
            return notification;
        }

        public InboxStyle setBigContentTitle(CharSequence charsequence) {
            internalSetBigContentTitle(charsequence);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence charsequence) {
            internalSetSummaryText(charsequence);
            return this;
        }

        private ArrayList mTexts;

        public InboxStyle() {
            mTexts = new ArrayList(5);
        }

        public InboxStyle(Builder builder) {
            mTexts = new ArrayList(5);
            setBuilder(builder);
        }
    }

    public static class BigTextStyle extends Style {

        private RemoteViews makeBigContentView() {
            boolean flag;
            RemoteViews remoteviews;
            if(super.mBuilder.mContentText != null && super.mBuilder.mSubText != null)
                flag = true;
            else
                flag = false;
            super.mBuilder.mContentText = null;
            remoteviews = getStandardView(0x1090074);
            if(flag)
                remoteviews.setViewPadding(0x10202e6, 0, 0, 0, 0);
            remoteviews.setTextViewText(0x10202eb, mBigText);
            remoteviews.setViewVisibility(0x10202eb, 0);
            remoteviews.setViewVisibility(0x1020015, 8);
            return remoteviews;
        }

        public BigTextStyle bigText(CharSequence charsequence) {
            mBigText = charsequence;
            return this;
        }

        public Notification build() {
            checkBuilder();
            Notification notification = super.mBuilder.buildUnstyled();
            notification.bigContentView = makeBigContentView();
            return notification;
        }

        public BigTextStyle setBigContentTitle(CharSequence charsequence) {
            internalSetBigContentTitle(charsequence);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence charsequence) {
            internalSetSummaryText(charsequence);
            return this;
        }

        private CharSequence mBigText;

        public BigTextStyle() {
        }

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }
    }

    public static class BigPictureStyle extends Style {

        private RemoteViews makeBigContentView() {
            RemoteViews remoteviews = getStandardView(0x1090073);
            remoteviews.setImageViewBitmap(0x10202ed, mPicture);
            return remoteviews;
        }

        public BigPictureStyle bigLargeIcon(Bitmap bitmap) {
            mBigLargeIconSet = true;
            mBigLargeIcon = bitmap;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap bitmap) {
            mPicture = bitmap;
            return this;
        }

        public Notification build() {
            checkBuilder();
            Notification notification = super.mBuilder.buildUnstyled();
            if(mBigLargeIconSet)
                super.mBuilder.mLargeIcon = mBigLargeIcon;
            notification.bigContentView = makeBigContentView();
            return notification;
        }

        public BigPictureStyle setBigContentTitle(CharSequence charsequence) {
            internalSetBigContentTitle(charsequence);
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence charsequence) {
            internalSetSummaryText(charsequence);
            return this;
        }

        private Bitmap mBigLargeIcon;
        private boolean mBigLargeIconSet;
        private Bitmap mPicture;

        public BigPictureStyle() {
            mBigLargeIconSet = false;
        }

        public BigPictureStyle(Builder builder) {
            mBigLargeIconSet = false;
            setBuilder(builder);
        }
    }

    public static abstract class Style {

        public abstract Notification build();

        protected void checkBuilder() {
            if(mBuilder == null)
                throw new IllegalArgumentException("Style requires a valid Builder object");
            else
                return;
        }

        protected RemoteViews getStandardView(int i) {
            checkBuilder();
            if(mBigContentTitle != null)
                mBuilder.setContentTitle(mBigContentTitle);
            RemoteViews remoteviews = mBuilder.applyStandardTemplateWithActions(i);
            CharSequence charsequence;
            if(mBigContentTitle != null && mBigContentTitle.equals(""))
                remoteviews.setViewVisibility(0x10202e6, 8);
            else
                remoteviews.setViewVisibility(0x10202e6, 0);
            if(mSummaryTextSet)
                charsequence = mSummaryText;
            else
                charsequence = mBuilder.mSubText;
            if(charsequence != null) {
                remoteviews.setTextViewText(0x1020046, charsequence);
                remoteviews.setViewVisibility(0x10202f1, 0);
                remoteviews.setViewVisibility(0x10202e8, 0);
            } else {
                remoteviews.setViewVisibility(0x10202f1, 8);
                remoteviews.setViewVisibility(0x10202e8, 8);
            }
            return remoteviews;
        }

        protected void internalSetBigContentTitle(CharSequence charsequence) {
            mBigContentTitle = charsequence;
        }

        protected void internalSetSummaryText(CharSequence charsequence) {
            mSummaryText = charsequence;
            mSummaryTextSet = true;
        }

        public void setBuilder(Builder builder) {
            if(mBuilder != builder) {
                mBuilder = builder;
                if(mBuilder != null)
                    mBuilder.setStyle(this);
            }
        }

        private CharSequence mBigContentTitle;
        protected Builder mBuilder;
        private CharSequence mSummaryText;
        private boolean mSummaryTextSet;

        public Style() {
            mSummaryText = null;
            mSummaryTextSet = false;
        }
    }

    public static class Builder {

        private RemoteViews applyStandardTemplate(int i, boolean flag) {
            RemoteViews remoteviews = new RemoteViews(mContext.getPackageName(), i);
            boolean flag1 = false;
            boolean flag2 = false;
            int j = 0x1020006;
            if(mLargeIcon != null) {
                remoteviews.setImageViewBitmap(0x1020006, mLargeIcon);
                j = 0x1020234;
            }
            if(mPriority < -1) {
                remoteviews.setInt(0x1020006, "setBackgroundResource", 0x108060a);
                remoteviews.setInt(0x10202e5, "setBackgroundResource", 0x108040a);
            }
            int k;
            int l;
            if(mSmallIcon != 0) {
                remoteviews.setImageViewResource(j, mSmallIcon);
                remoteviews.setViewVisibility(j, 0);
            } else {
                remoteviews.setViewVisibility(j, 8);
            }
            if(mContentTitle != null)
                remoteviews.setTextViewText(0x1020016, mContentTitle);
            if(mContentText != null) {
                remoteviews.setTextViewText(0x1020046, mContentText);
                flag1 = true;
            }
            if(mContentInfo != null) {
                remoteviews.setTextViewText(0x10202e9, mContentInfo);
                remoteviews.setViewVisibility(0x10202e9, 0);
                flag1 = true;
            } else
            if(mNumber > 0) {
                int i1 = mContext.getResources().getInteger(0x10e0003);
                if(mNumber > i1)
                    remoteviews.setTextViewText(0x10202e9, mContext.getResources().getString(0x1040017));
                else
                    remoteviews.setTextViewText(0x10202e9, NumberFormat.getIntegerInstance().format(mNumber));
                remoteviews.setViewVisibility(0x10202e9, 0);
                flag1 = true;
            } else {
                remoteviews.setViewVisibility(0x10202e9, 8);
            }
            if(mSubText != null) {
                remoteviews.setTextViewText(0x1020046, mSubText);
                if(mContentText != null) {
                    remoteviews.setTextViewText(0x1020015, mContentText);
                    remoteviews.setViewVisibility(0x1020015, 0);
                    flag2 = true;
                } else {
                    remoteviews.setViewVisibility(0x1020015, 8);
                }
            } else {
                remoteviews.setViewVisibility(0x1020015, 8);
                if(mProgressMax != 0 || mProgressIndeterminate) {
                    remoteviews.setProgressBar(0x102000d, mProgressMax, mProgress, mProgressIndeterminate);
                    remoteviews.setViewVisibility(0x102000d, 0);
                    flag2 = true;
                } else {
                    remoteviews.setViewVisibility(0x102000d, 8);
                }
            }
            if(flag2) {
                if(flag)
                    remoteviews.setTextViewTextSize(0x1020046, 0, mContext.getResources().getDimensionPixelSize(0x1050054));
                remoteviews.setViewPadding(0x10202e6, 0, 0, 0, 0);
            }
            if(mWhen != 0L)
                if(mUseChronometer) {
                    remoteviews.setViewVisibility(0x10202e7, 0);
                    remoteviews.setLong(0x10202e7, "setBase", mWhen + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
                    remoteviews.setBoolean(0x10202e7, "setStarted", true);
                } else {
                    remoteviews.setViewVisibility(0x1020064, 0);
                    remoteviews.setLong(0x1020064, "setTime", mWhen);
                }
            if(flag1)
                k = 0;
            else
                k = 8;
            remoteviews.setViewVisibility(0x10202e8, k);
            if(flag1)
                l = 0;
            else
                l = 8;
            remoteviews.setViewVisibility(0x10202f1, l);
            return remoteviews;
        }

        private RemoteViews applyStandardTemplateWithActions(int i) {
            RemoteViews remoteviews = applyStandardTemplate(i, false);
            int j = mActions.size();
            if(j > 0) {
                remoteviews.setViewVisibility(0x10202e2, 0);
                remoteviews.setViewVisibility(0x10202ec, 0);
                if(j > 3)
                    j = 3;
                remoteviews.removeAllViews(0x10202e2);
                for(int k = 0; k < j; k++)
                    remoteviews.addView(0x10202e2, generateActionButton((Action)mActions.get(k)));

            }
            return remoteviews;
        }

        private Notification buildUnstyled() {
            Bundle bundle = null;
            Notification notification = new Notification();
            notification.when = mWhen;
            notification.icon = mSmallIcon;
            notification.iconLevel = mSmallIconLevel;
            notification.number = mNumber;
            notification.contentView = makeContentView();
            notification.contentIntent = mContentIntent;
            notification.deleteIntent = mDeleteIntent;
            notification.fullScreenIntent = mFullScreenIntent;
            notification.tickerText = mTickerText;
            notification.tickerView = makeTickerView();
            notification.largeIcon = mLargeIcon;
            notification.sound = mSound;
            notification.audioStreamType = mAudioStreamType;
            notification.vibrate = mVibrate;
            notification.ledARGB = mLedArgb;
            notification.ledOnMS = mLedOnMs;
            notification.ledOffMS = mLedOffMs;
            notification.defaults = mDefaults;
            notification.flags = mFlags;
            notification.bigContentView = makeBigContentView();
            if(mLedOnMs != 0 && mLedOffMs != 0)
                notification.flags = 1 | notification.flags;
            if((4 & mDefaults) != 0)
                notification.flags = 1 | notification.flags;
            if(mKindList.size() > 0) {
                notification.kind = new String[mKindList.size()];
                mKindList.toArray(notification.kind);
            } else {
                notification.kind = null;
            }
            notification.priority = mPriority;
            if(mExtras != null)
                bundle = new Bundle(mExtras);
            notification.extras = bundle;
            if(mActions.size() > 0) {
                notification.actions = new Action[mActions.size()];
                mActions.toArray(notification.actions);
            }
            return notification;
        }

        private RemoteViews generateActionButton(Action action) {
            boolean flag;
            String s;
            int i;
            RemoteViews remoteviews;
            if(action.actionIntent == null)
                flag = true;
            else
                flag = false;
            s = mContext.getPackageName();
            if(flag)
                i = 0x109006f;
            else
                i = 0x109006d;
            remoteviews = new RemoteViews(s, i);
            remoteviews.setTextViewCompoundDrawables(0x10202e1, action.icon, 0, 0, 0);
            remoteviews.setTextViewText(0x10202e1, action.title);
            if(!flag)
                remoteviews.setOnClickPendingIntent(0x10202e1, action.actionIntent);
            remoteviews.setContentDescription(0x10202e1, action.title);
            return remoteviews;
        }

        private RemoteViews makeBigContentView() {
            RemoteViews remoteviews;
            if(mActions.size() == 0)
                remoteviews = null;
            else
                remoteviews = applyStandardTemplateWithActions(0x1090072);
            return remoteviews;
        }

        private RemoteViews makeContentView() {
            RemoteViews remoteviews;
            if(mContentView != null)
                remoteviews = mContentView;
            else
                remoteviews = applyStandardTemplate(0x1090071, true);
            return remoteviews;
        }

        private RemoteViews makeTickerView() {
            RemoteViews remoteviews;
            if(mTickerView != null)
                remoteviews = mTickerView;
            else
            if(mContentView == null) {
                int i;
                if(mLargeIcon == null)
                    i = 0x10900ae;
                else
                    i = 0x10900af;
                remoteviews = applyStandardTemplate(i, true);
            } else {
                remoteviews = null;
            }
            return remoteviews;
        }

        private void setFlag(int i, boolean flag) {
            if(flag)
                mFlags = i | mFlags;
            else
                mFlags = mFlags & ~i;
        }

        public Builder addAction(int i, CharSequence charsequence, PendingIntent pendingintent) {
            mActions.add(new Action(i, charsequence, pendingintent));
            return this;
        }

        public Builder addKind(String s) {
            mKindList.add(s);
            return this;
        }

        public Notification build() {
            Notification notification;
            if(mStyle != null)
                notification = mStyle.build();
            else
                notification = buildUnstyled();
            return notification;
        }

        public Notification getNotification() {
            return build();
        }

        public Builder setAutoCancel(boolean flag) {
            setFlag(16, flag);
            return this;
        }

        public Builder setContent(RemoteViews remoteviews) {
            mContentView = remoteviews;
            return this;
        }

        public Builder setContentInfo(CharSequence charsequence) {
            mContentInfo = charsequence;
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingintent) {
            mContentIntent = pendingintent;
            return this;
        }

        public Builder setContentText(CharSequence charsequence) {
            mContentText = charsequence;
            return this;
        }

        public Builder setContentTitle(CharSequence charsequence) {
            mContentTitle = charsequence;
            return this;
        }

        public Builder setDefaults(int i) {
            mDefaults = i;
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingintent) {
            mDeleteIntent = pendingintent;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            mExtras = bundle;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent pendingintent, boolean flag) {
            mFullScreenIntent = pendingintent;
            setFlag(128, flag);
            return this;
        }

        public Builder setLargeIcon(Bitmap bitmap) {
            mLargeIcon = bitmap;
            return this;
        }

        public Builder setLights(int i, int j, int k) {
            mLedArgb = i;
            mLedOnMs = j;
            mLedOffMs = k;
            return this;
        }

        public Builder setNumber(int i) {
            mNumber = i;
            return this;
        }

        public Builder setOngoing(boolean flag) {
            setFlag(2, flag);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean flag) {
            setFlag(8, flag);
            return this;
        }

        public Builder setPriority(int i) {
            mPriority = i;
            return this;
        }

        public Builder setProgress(int i, int j, boolean flag) {
            mProgressMax = i;
            mProgress = j;
            mProgressIndeterminate = flag;
            return this;
        }

        public Builder setSmallIcon(int i) {
            mSmallIcon = i;
            return this;
        }

        public Builder setSmallIcon(int i, int j) {
            mSmallIcon = i;
            mSmallIconLevel = j;
            return this;
        }

        public Builder setSound(Uri uri) {
            mSound = uri;
            mAudioStreamType = -1;
            return this;
        }

        public Builder setSound(Uri uri, int i) {
            mSound = uri;
            mAudioStreamType = i;
            return this;
        }

        public Builder setStyle(Style style) {
            if(mStyle != style) {
                mStyle = style;
                if(mStyle != null)
                    mStyle.setBuilder(this);
            }
            return this;
        }

        public Builder setSubText(CharSequence charsequence) {
            mSubText = charsequence;
            return this;
        }

        public Builder setTicker(CharSequence charsequence) {
            mTickerText = charsequence;
            return this;
        }

        public Builder setTicker(CharSequence charsequence, RemoteViews remoteviews) {
            mTickerText = charsequence;
            mTickerView = remoteviews;
            return this;
        }

        public Builder setUsesChronometer(boolean flag) {
            mUseChronometer = flag;
            return this;
        }

        public Builder setVibrate(long al[]) {
            mVibrate = al;
            return this;
        }

        public Builder setWhen(long l) {
            mWhen = l;
            return this;
        }

        private static final int MAX_ACTION_BUTTONS = 3;
        private ArrayList mActions;
        private int mAudioStreamType;
        private CharSequence mContentInfo;
        private PendingIntent mContentIntent;
        private CharSequence mContentText;
        private CharSequence mContentTitle;
        private RemoteViews mContentView;
        private Context mContext;
        private int mDefaults;
        private PendingIntent mDeleteIntent;
        private Bundle mExtras;
        private int mFlags;
        private PendingIntent mFullScreenIntent;
        private ArrayList mKindList;
        private Bitmap mLargeIcon;
        private int mLedArgb;
        private int mLedOffMs;
        private int mLedOnMs;
        private int mNumber;
        private int mPriority;
        private int mProgress;
        private boolean mProgressIndeterminate;
        private int mProgressMax;
        private int mSmallIcon;
        private int mSmallIconLevel;
        private Uri mSound;
        private Style mStyle;
        private CharSequence mSubText;
        private CharSequence mTickerText;
        private RemoteViews mTickerView;
        private boolean mUseChronometer;
        private long mVibrate[];
        private long mWhen;





/*
        static Bitmap access$602(Builder builder, Bitmap bitmap) {
            builder.mLargeIcon = bitmap;
            return bitmap;
        }

*/



/*
        static CharSequence access$702(Builder builder, CharSequence charsequence) {
            builder.mContentText = charsequence;
            return charsequence;
        }

*/

        public Builder(Context context) {
            mKindList = new ArrayList(1);
            mActions = new ArrayList(3);
            mContext = context;
            mWhen = System.currentTimeMillis();
            mAudioStreamType = -1;
            mPriority = 0;
        }
    }

    private static class Action
        implements Parcelable {

        public Action clone() {
            return new Action(icon, title.toString(), actionIntent);
        }

        public volatile Object clone() throws CloneNotSupportedException {
            return clone();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(icon);
            TextUtils.writeToParcel(title, parcel, i);
            if(actionIntent != null) {
                parcel.writeInt(1);
                actionIntent.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Action createFromParcel(Parcel parcel) {
                return new Action(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public Action[] newArray(int i) {
                return new Action[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public PendingIntent actionIntent;
        public int icon;
        public CharSequence title;


        public Action() {
        }

        public Action(int i, CharSequence charsequence, PendingIntent pendingintent) {
            icon = i;
            title = charsequence;
            actionIntent = pendingintent;
        }

        private Action(Parcel parcel) {
            icon = parcel.readInt();
            title = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            if(parcel.readInt() == 1)
                actionIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
        }

    }


    public Notification() {
        audioStreamType = -1;
        when = System.currentTimeMillis();
        priority = 0;
    }

    public Notification(int i, CharSequence charsequence, long l) {
        audioStreamType = -1;
        icon = i;
        tickerText = charsequence;
        when = l;
    }

    public Notification(Context context, int i, CharSequence charsequence, long l, CharSequence charsequence1, CharSequence charsequence2, 
            Intent intent) {
        audioStreamType = -1;
        when = l;
        icon = i;
        tickerText = charsequence;
        setLatestEventInfo(context, charsequence1, charsequence2, PendingIntent.getActivity(context, 0, intent, 0));
    }

    public Notification(Parcel parcel) {
        audioStreamType = -1;
        parcel.readInt();
        when = parcel.readLong();
        icon = parcel.readInt();
        number = parcel.readInt();
        if(parcel.readInt() != 0)
            contentIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
        if(parcel.readInt() != 0)
            deleteIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
        if(parcel.readInt() != 0)
            tickerText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        if(parcel.readInt() != 0)
            tickerView = (RemoteViews)RemoteViews.CREATOR.createFromParcel(parcel);
        if(parcel.readInt() != 0)
            contentView = (RemoteViews)RemoteViews.CREATOR.createFromParcel(parcel);
        if(parcel.readInt() != 0)
            largeIcon = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel);
        defaults = parcel.readInt();
        flags = parcel.readInt();
        if(parcel.readInt() != 0)
            sound = (Uri)Uri.CREATOR.createFromParcel(parcel);
        audioStreamType = parcel.readInt();
        vibrate = parcel.createLongArray();
        ledARGB = parcel.readInt();
        ledOnMS = parcel.readInt();
        ledOffMS = parcel.readInt();
        iconLevel = parcel.readInt();
        if(parcel.readInt() != 0)
            fullScreenIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
        priority = parcel.readInt();
        kind = parcel.createStringArray();
        if(parcel.readInt() != 0)
            extras = parcel.readBundle();
        actions = (Action[])parcel.createTypedArray(Action.CREATOR);
        if(parcel.readInt() != 0)
            bigContentView = (RemoteViews)RemoteViews.CREATOR.createFromParcel(parcel);
    }

    public Notification clone() {
        Notification notification = new Notification();
        notification.when = when;
        notification.icon = icon;
        notification.number = number;
        notification.contentIntent = contentIntent;
        notification.deleteIntent = deleteIntent;
        notification.fullScreenIntent = fullScreenIntent;
        if(tickerText != null)
            notification.tickerText = tickerText.toString();
        if(tickerView != null)
            notification.tickerView = tickerView.clone();
        if(contentView != null)
            notification.contentView = contentView.clone();
        if(largeIcon != null)
            notification.largeIcon = Bitmap.createBitmap(largeIcon);
        notification.iconLevel = iconLevel;
        notification.sound = sound;
        notification.audioStreamType = audioStreamType;
        long al[] = vibrate;
        if(al != null) {
            int k = al.length;
            long al1[] = new long[k];
            notification.vibrate = al1;
            System.arraycopy(al, 0, al1, 0, k);
        }
        notification.ledARGB = ledARGB;
        notification.ledOnMS = ledOnMS;
        notification.ledOffMS = ledOffMS;
        notification.defaults = defaults;
        notification.flags = flags;
        notification.priority = priority;
        String as[] = kind;
        if(as != null) {
            int j = as.length;
            String as1[] = new String[j];
            notification.kind = as1;
            System.arraycopy(as, 0, as1, 0, j);
        }
        if(extras != null)
            notification.extras = new Bundle(extras);
        notification.actions = new Action[actions.length];
        for(int i = 0; i < actions.length; i++)
            notification.actions[i] = actions[i].clone();

        if(bigContentView != null)
            notification.bigContentView = bigContentView.clone();
        return notification;
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public int describeContents() {
        return 0;
    }

    public void setLatestEventInfo(Context context, CharSequence charsequence, CharSequence charsequence1, PendingIntent pendingintent) {
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x1090071);
        if(icon != 0)
            remoteviews.setImageViewResource(0x1020006, icon);
        if(priority < -1) {
            remoteviews.setInt(0x1020006, "setBackgroundResource", 0x108060a);
            remoteviews.setInt(0x10202e5, "setBackgroundResource", 0x108040a);
        }
        if(charsequence != null)
            remoteviews.setTextViewText(0x1020016, charsequence);
        if(charsequence1 != null)
            remoteviews.setTextViewText(0x1020046, charsequence1);
        if(when != 0L) {
            remoteviews.setViewVisibility(0x1020064, 0);
            remoteviews.setLong(0x1020064, "setTime", when);
        }
        if(number != 0)
            remoteviews.setTextViewText(0x10202e9, NumberFormat.getIntegerInstance().format(number));
        contentView = remoteviews;
        contentIntent = pendingintent;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Notification(pri=");
        stringbuilder.append(priority);
        stringbuilder.append(" contentView=");
        if(contentView != null) {
            stringbuilder.append(contentView.getPackage());
            stringbuilder.append("/0x");
            stringbuilder.append(Integer.toHexString(contentView.getLayoutId()));
        } else {
            stringbuilder.append("null");
        }
        stringbuilder.append(" vibrate=");
        if(vibrate != null) {
            int j = -1 + vibrate.length;
            stringbuilder.append("[");
            for(int k = 0; k < j; k++) {
                stringbuilder.append(vibrate[k]);
                stringbuilder.append(',');
            }

            if(j != -1)
                stringbuilder.append(vibrate[j]);
            stringbuilder.append("]");
        } else
        if((2 & defaults) != 0)
            stringbuilder.append("default");
        else
            stringbuilder.append("null");
        stringbuilder.append(" sound=");
        if(sound != null)
            stringbuilder.append(sound.toString());
        else
        if((1 & defaults) != 0)
            stringbuilder.append("default");
        else
            stringbuilder.append("null");
        stringbuilder.append(" defaults=0x");
        stringbuilder.append(Integer.toHexString(defaults));
        stringbuilder.append(" flags=0x");
        stringbuilder.append(Integer.toHexString(flags));
        stringbuilder.append(" kind=[");
        if(kind == null) {
            stringbuilder.append("null");
        } else {
            int i = 0;
            while(i < kind.length)  {
                if(i > 0)
                    stringbuilder.append(",");
                stringbuilder.append(kind[i]);
                i++;
            }
        }
        stringbuilder.append("]");
        if(actions != null) {
            stringbuilder.append(" ");
            stringbuilder.append(actions.length);
            stringbuilder.append(" action");
            if(actions.length > 1)
                stringbuilder.append("s");
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(1);
        parcel.writeLong(when);
        parcel.writeInt(icon);
        parcel.writeInt(number);
        if(contentIntent != null) {
            parcel.writeInt(1);
            contentIntent.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if(deleteIntent != null) {
            parcel.writeInt(1);
            deleteIntent.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if(tickerText != null) {
            parcel.writeInt(1);
            TextUtils.writeToParcel(tickerText, parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if(tickerView != null) {
            parcel.writeInt(1);
            tickerView.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if(contentView != null) {
            parcel.writeInt(1);
            contentView.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if(largeIcon != null) {
            parcel.writeInt(1);
            largeIcon.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(defaults);
        parcel.writeInt(flags);
        if(sound != null) {
            parcel.writeInt(1);
            sound.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(audioStreamType);
        parcel.writeLongArray(vibrate);
        parcel.writeInt(ledARGB);
        parcel.writeInt(ledOnMS);
        parcel.writeInt(ledOffMS);
        parcel.writeInt(iconLevel);
        if(fullScreenIntent != null) {
            parcel.writeInt(1);
            fullScreenIntent.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(priority);
        parcel.writeStringArray(kind);
        if(extras != null) {
            parcel.writeInt(1);
            extras.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeTypedArray(actions, 0);
        if(bigContentView != null) {
            parcel.writeInt(1);
            bigContentView.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Notification createFromParcel(Parcel parcel) {
            return new Notification(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Notification[] newArray(int i) {
            return new Notification[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_PEOPLE = "android.people";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final String KIND_CALL = "android.call";
    public static final String KIND_EMAIL = "android.email";
    public static final String KIND_EVENT = "android.event";
    public static final String KIND_MESSAGE = "android.message";
    public static final String KIND_PROMO = "android.promo";
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    private Action actions[];
    public int audioStreamType;
    public RemoteViews bigContentView;
    public PendingIntent contentIntent;
    public RemoteViews contentView;
    public int defaults;
    public PendingIntent deleteIntent;
    private Bundle extras;
    public int flags;
    public PendingIntent fullScreenIntent;
    public int icon;
    public int iconLevel;
    public String kind[];
    public Bitmap largeIcon;
    public int ledARGB;
    public int ledOffMS;
    public int ledOnMS;
    public int number;
    public int priority;
    public Uri sound;
    public CharSequence tickerText;
    public RemoteViews tickerView;
    public long vibrate[];
    public long when;



/*
    static Bundle access$102(Notification notification, Bundle bundle) {
        notification.extras = bundle;
        return bundle;
    }

*/



/*
    static Action[] access$202(Notification notification, Action aaction[]) {
        notification.actions = aaction;
        return aaction;
    }

*/
}
