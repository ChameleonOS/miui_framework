// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.statusbar;

import android.app.Notification;
import android.os.Parcel;
import android.os.Parcelable;

public class StatusBarNotification
    implements Parcelable {

    public StatusBarNotification() {
    }

    public StatusBarNotification(Parcel parcel) {
        readFromParcel(parcel);
    }

    public StatusBarNotification(String s, int i, String s1, int j, int k, int l, Notification notification1) {
        if(s == null)
            throw new NullPointerException();
        if(notification1 == null) {
            throw new NullPointerException();
        } else {
            pkg = s;
            id = i;
            tag = s1;
            uid = j;
            initialPid = k;
            score = l;
            notification = notification1;
            return;
        }
    }

    public StatusBarNotification clone() {
        return new StatusBarNotification(pkg, id, tag, uid, initialPid, score, notification.clone());
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public int describeContents() {
        return 0;
    }

    public boolean isClearable() {
        boolean flag;
        if((2 & notification.flags) == 0 && (0x20 & notification.flags) == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isOngoing() {
        boolean flag;
        if((2 & notification.flags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void readFromParcel(Parcel parcel) {
        pkg = parcel.readString();
        id = parcel.readInt();
        if(parcel.readInt() != 0)
            tag = parcel.readString();
        else
            tag = null;
        uid = parcel.readInt();
        initialPid = parcel.readInt();
        score = parcel.readInt();
        notification = new Notification(parcel);
    }

    public String toString() {
        return (new StringBuilder()).append("StatusBarNotification(pkg=").append(pkg).append(" id=").append(id).append(" tag=").append(tag).append(" score=").append(score).append(" notn=").append(notification).append(")").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(pkg);
        parcel.writeInt(id);
        if(tag != null) {
            parcel.writeInt(1);
            parcel.writeString(tag);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(uid);
        parcel.writeInt(initialPid);
        parcel.writeInt(score);
        notification.writeToParcel(parcel, i);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public StatusBarNotification createFromParcel(Parcel parcel) {
            return new StatusBarNotification(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public StatusBarNotification[] newArray(int i) {
            return new StatusBarNotification[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public int id;
    public int initialPid;
    public Notification notification;
    public String pkg;
    public int score;
    public String tag;
    public int uid;

}
