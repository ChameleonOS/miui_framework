// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.rtp;

import java.net.InetAddress;
import java.net.SocketException;

// Referenced classes of package android.net.rtp:
//            RtpStream, AudioGroup, AudioCodec

public class AudioStream extends RtpStream {

    public AudioStream(InetAddress inetaddress) throws SocketException {
        super(inetaddress);
        mDtmfType = -1;
    }

    public AudioCodec getCodec() {
        return mCodec;
    }

    public int getDtmfType() {
        return mDtmfType;
    }

    public AudioGroup getGroup() {
        return mGroup;
    }

    public final boolean isBusy() {
        boolean flag;
        if(mGroup != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void join(AudioGroup audiogroup) {
        this;
        JVM INSTR monitorenter ;
        if(mGroup != audiogroup) {
            if(mGroup != null) {
                mGroup.remove(this);
                mGroup = null;
            }
            if(audiogroup != null) {
                audiogroup.add(this);
                mGroup = audiogroup;
            }
        }
        return;
    }

    public void setCodec(AudioCodec audiocodec) {
        if(isBusy())
            throw new IllegalStateException("Busy");
        if(audiocodec.type == mDtmfType) {
            throw new IllegalArgumentException("The type is used by DTMF");
        } else {
            mCodec = audiocodec;
            return;
        }
    }

    public void setDtmfType(int i) {
        if(isBusy())
            throw new IllegalStateException("Busy");
        if(i != -1) {
            if(i < 96 || i > 127)
                throw new IllegalArgumentException("Invalid type");
            if(mCodec != null && i == mCodec.type)
                throw new IllegalArgumentException("The type is used by codec");
        }
        mDtmfType = i;
    }

    private AudioCodec mCodec;
    private int mDtmfType;
    private AudioGroup mGroup;
}
