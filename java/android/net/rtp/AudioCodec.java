// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.rtp;

import java.util.Arrays;

public class AudioCodec {

    private AudioCodec(int i, String s, String s1) {
        type = i;
        rtpmap = s;
        fmtp = s1;
    }

    public static AudioCodec getCodec(int i, String s, String s1) {
        AudioCodec audiocodec = null;
        if(i >= 0 && i <= 127) goto _L2; else goto _L1
_L1:
        return audiocodec;
_L2:
        AudioCodec audiocodec1 = null;
        if(s == null) goto _L4; else goto _L3
_L3:
        String s3;
        AudioCodec aaudiocodec1[];
        int l;
        int i1;
        s3 = s.trim().toUpperCase();
        aaudiocodec1 = sCodecs;
        l = aaudiocodec1.length;
        i1 = 0;
_L12:
        if(i1 >= l) goto _L6; else goto _L5
_L5:
        AudioCodec audiocodec3 = aaudiocodec1[i1];
        if(!s3.startsWith(audiocodec3.rtpmap)) goto _L8; else goto _L7
_L7:
        String s4 = s3.substring(audiocodec3.rtpmap.length());
        if(s4.length() == 0 || s4.equals("/1"))
            audiocodec1 = audiocodec3;
_L6:
        if(audiocodec1 == null) goto _L1; else goto _L9
_L9:
        if(audiocodec1 != AMR || s1 == null) goto _L11; else goto _L10
_L10:
        String s2 = s1.toLowerCase();
        if(s2.contains("crc=1") || s2.contains("robust-sorting=1") || s2.contains("interleaving=")) goto _L1; else goto _L11
_L11:
        audiocodec = new AudioCodec(i, s, s1);
          goto _L1
_L8:
        i1++;
          goto _L12
_L4:
        if(i >= 96) goto _L6; else goto _L13
_L13:
        AudioCodec aaudiocodec[];
        int j;
        int k;
        aaudiocodec = sCodecs;
        j = aaudiocodec.length;
        k = 0;
_L14:
        if(k < j) {
label0:
            {
                AudioCodec audiocodec2 = aaudiocodec[k];
                if(i != audiocodec2.type)
                    break label0;
                audiocodec1 = audiocodec2;
                s = audiocodec2.rtpmap;
            }
        }
          goto _L6
        k++;
          goto _L14
    }

    public static AudioCodec[] getCodecs() {
        return (AudioCodec[])Arrays.copyOf(sCodecs, sCodecs.length);
    }

    public static final AudioCodec AMR;
    public static final AudioCodec GSM;
    public static final AudioCodec GSM_EFR;
    public static final AudioCodec PCMA;
    public static final AudioCodec PCMU;
    private static final AudioCodec sCodecs[];
    public final String fmtp;
    public final String rtpmap;
    public final int type;

    static  {
        PCMU = new AudioCodec(0, "PCMU/8000", null);
        PCMA = new AudioCodec(8, "PCMA/8000", null);
        GSM = new AudioCodec(3, "GSM/8000", null);
        GSM_EFR = new AudioCodec(96, "GSM-EFR/8000", null);
        AMR = new AudioCodec(97, "AMR/8000", null);
        AudioCodec aaudiocodec[] = new AudioCodec[5];
        aaudiocodec[0] = GSM_EFR;
        aaudiocodec[1] = AMR;
        aaudiocodec[2] = GSM;
        aaudiocodec[3] = PCMU;
        aaudiocodec[4] = PCMA;
        sCodecs = aaudiocodec;
    }
}
