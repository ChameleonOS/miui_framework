// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.sip;

import java.util.*;

public class SimpleSessionDescription {
    private static class Fields {

        private String[] cut(String s, char c) {
            String as[] = new String[mLines.size()];
            int i = 0;
            Iterator iterator = mLines.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                String s1 = (String)iterator.next();
                if(s1.startsWith(s)) {
                    int j = s1.indexOf(c);
                    if(j == -1)
                        j = s1.length();
                    as[i] = s1.substring(s.length(), j);
                    i++;
                }
            } while(true);
            return (String[])Arrays.copyOf(as, i);
        }

        private int find(String s, char c) {
            int i;
            int j;
            i = s.length();
            j = -1 + mLines.size();
_L3:
            String s1;
            if(j < 0)
                break MISSING_BLOCK_LABEL_73;
            s1 = (String)mLines.get(j);
            if(!s1.startsWith(s) || s1.length() != i && s1.charAt(i) != c) goto _L2; else goto _L1
_L1:
            return j;
_L2:
            j--;
              goto _L3
            j = -1;
              goto _L1
        }

        private String get(String s, char c) {
            int i = find(s, c);
            String s2;
            if(i == -1) {
                s2 = null;
            } else {
                String s1 = (String)mLines.get(i);
                int j = s.length();
                if(s1.length() == j)
                    s2 = "";
                else
                    s2 = s1.substring(j + 1);
            }
            return s2;
        }

        private void parse(String s) {
            char c = s.charAt(0);
            if(mOrder.indexOf(c) != -1) goto _L2; else goto _L1
_L1:
            return;
_L2:
            char c1 = '=';
            if(!s.startsWith("a=rtpmap:") && !s.startsWith("a=fmtp:")) goto _L4; else goto _L3
_L3:
            c1 = ' ';
_L5:
            int i = s.indexOf(c1);
            if(i == -1)
                set(s, c1, "");
            else
                set(s.substring(0, i), c1, s.substring(i + 1));
            if(true) goto _L1; else goto _L4
_L4:
            if(c == 'b' || c == 'a')
                c1 = ':';
              goto _L5
        }

        private void set(String s, char c, String s1) {
            int i = find(s, c);
            if(s1 == null) goto _L2; else goto _L1
_L1:
            if(s1.length() != 0)
                s = (new StringBuilder()).append(s).append(c).append(s1).toString();
            if(i == -1)
                mLines.add(s);
            else
                mLines.set(i, s);
_L4:
            return;
_L2:
            if(i != -1)
                mLines.remove(i);
            if(true) goto _L4; else goto _L3
_L3:
        }

        private void write(StringBuilder stringbuilder) {
label0:
            for(int i = 0; i < mOrder.length(); i++) {
                char c = mOrder.charAt(i);
                Iterator iterator = mLines.iterator();
                do {
                    if(!iterator.hasNext())
                        continue label0;
                    String s = (String)iterator.next();
                    if(s.charAt(0) == c)
                        stringbuilder.append(s).append("\r\n");
                } while(true);
            }

        }

        public String getAddress() {
            String s;
            String s1;
            s = null;
            s1 = get("c", '=');
            if(s1 != null) goto _L2; else goto _L1
_L1:
            return s;
_L2:
            String as[] = s1.split(" ");
            if(as.length == 3) {
                int i = as[2].indexOf('/');
                if(i < 0)
                    s = as[2];
                else
                    s = as[2].substring(0, i);
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        public String getAttribute(String s) {
            return get((new StringBuilder()).append("a=").append(s).toString(), ':');
        }

        public String[] getAttributeNames() {
            return cut("a=", ':');
        }

        public int getBandwidth(String s) {
            int i;
            String s1;
            i = -1;
            s1 = get((new StringBuilder()).append("b=").append(s).toString(), ':');
            if(s1 == null)
                break MISSING_BLOCK_LABEL_42;
            int j = Integer.parseInt(s1);
            i = j;
_L2:
            return i;
            NumberFormatException numberformatexception;
            numberformatexception;
            setBandwidth(s, i);
            if(true) goto _L2; else goto _L1
_L1:
        }

        public String[] getBandwidthTypes() {
            return cut("b=", ':');
        }

        public String getEncryptionKey() {
            String s;
            String s1;
            s = null;
            s1 = get("k", '=');
            if(s1 != null) goto _L2; else goto _L1
_L1:
            return s;
_L2:
            int i = s1.indexOf(':');
            if(i != -1)
                s = s1.substring(0, i + 1);
            if(true) goto _L1; else goto _L3
_L3:
        }

        public String getEncryptionMethod() {
            String s = get("k", '=');
            if(s != null) goto _L2; else goto _L1
_L1:
            s = null;
_L4:
            return s;
_L2:
            int i = s.indexOf(':');
            if(i != -1)
                s = s.substring(0, i);
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void setAddress(String s) {
            if(s != null) {
                StringBuilder stringbuilder = new StringBuilder();
                String s1;
                if(s.indexOf(':') < 0)
                    s1 = "IN IP4 ";
                else
                    s1 = "IN IP6 ";
                s = stringbuilder.append(s1).append(s).toString();
            }
            set("c", '=', s);
        }

        public void setAttribute(String s, String s1) {
            set((new StringBuilder()).append("a=").append(s).toString(), ':', s1);
        }

        public void setBandwidth(String s, int i) {
            String s1 = (new StringBuilder()).append("b=").append(s).toString();
            String s2;
            if(i < 0)
                s2 = null;
            else
                s2 = String.valueOf(i);
            set(s1, ':', s2);
        }

        public void setEncryption(String s, String s1) {
            if(s != null && s1 != null)
                s = (new StringBuilder()).append(s).append(':').append(s1).toString();
            set("k", '=', s);
        }

        private final ArrayList mLines = new ArrayList();
        private final String mOrder;





        Fields(String s) {
            mOrder = s;
        }
    }

    public static class Media extends Fields {

        private void write(StringBuilder stringbuilder) {
            stringbuilder.append("m=").append(mType).append(' ').append(mPort);
            if(mPortCount != 1)
                stringbuilder.append('/').append(mPortCount);
            stringbuilder.append(' ').append(mProtocol);
            String s;
            for(Iterator iterator = mFormats.iterator(); iterator.hasNext(); stringbuilder.append(' ').append(s))
                s = (String)iterator.next();

            stringbuilder.append("\r\n");
            write(stringbuilder);
        }

        public volatile String getAddress() {
            return super.getAddress();
        }

        public volatile String getAttribute(String s) {
            return super.getAttribute(s);
        }

        public volatile String[] getAttributeNames() {
            return super.getAttributeNames();
        }

        public volatile int getBandwidth(String s) {
            return super.getBandwidth(s);
        }

        public volatile String[] getBandwidthTypes() {
            return super.getBandwidthTypes();
        }

        public volatile String getEncryptionKey() {
            return super.getEncryptionKey();
        }

        public volatile String getEncryptionMethod() {
            return super.getEncryptionMethod();
        }

        public String getFmtp(int i) {
            return get((new StringBuilder()).append("a=fmtp:").append(i).toString(), ' ');
        }

        public String getFmtp(String s) {
            return get((new StringBuilder()).append("a=fmtp:").append(s).toString(), ' ');
        }

        public String[] getFormats() {
            return (String[])mFormats.toArray(new String[mFormats.size()]);
        }

        public int getPort() {
            return mPort;
        }

        public int getPortCount() {
            return mPortCount;
        }

        public String getProtocol() {
            return mProtocol;
        }

        public int[] getRtpPayloadTypes() {
            int ai[];
            int i;
            Iterator iterator;
            ai = new int[mFormats.size()];
            i = 0;
            iterator = mFormats.iterator();
_L2:
            String s;
            if(!iterator.hasNext())
                break MISSING_BLOCK_LABEL_54;
            s = (String)iterator.next();
            ai[i] = Integer.parseInt(s);
            i++;
            continue; /* Loop/switch isn't completed */
            return Arrays.copyOf(ai, i);
            NumberFormatException numberformatexception;
            numberformatexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public String getRtpmap(int i) {
            return get((new StringBuilder()).append("a=rtpmap:").append(i).toString(), ' ');
        }

        public String getType() {
            return mType;
        }

        public void removeFormat(String s) {
            mFormats.remove(s);
            set((new StringBuilder()).append("a=rtpmap:").append(s).toString(), ' ', null);
            set((new StringBuilder()).append("a=fmtp:").append(s).toString(), ' ', null);
        }

        public void removeRtpPayload(int i) {
            removeFormat(String.valueOf(i));
        }

        public volatile void setAddress(String s) {
            super.setAddress(s);
        }

        public volatile void setAttribute(String s, String s1) {
            super.setAttribute(s, s1);
        }

        public volatile void setBandwidth(String s, int i) {
            super.setBandwidth(s, i);
        }

        public volatile void setEncryption(String s, String s1) {
            super.setEncryption(s, s1);
        }

        public void setFormat(String s, String s1) {
            mFormats.remove(s);
            mFormats.add(s);
            set((new StringBuilder()).append("a=rtpmap:").append(s).toString(), ' ', null);
            set((new StringBuilder()).append("a=fmtp:").append(s).toString(), ' ', s1);
        }

        public void setRtpPayload(int i, String s, String s1) {
            String s2 = String.valueOf(i);
            mFormats.remove(s2);
            mFormats.add(s2);
            set((new StringBuilder()).append("a=rtpmap:").append(s2).toString(), ' ', s);
            set((new StringBuilder()).append("a=fmtp:").append(s2).toString(), ' ', s1);
        }

        private ArrayList mFormats;
        private final int mPort;
        private final int mPortCount;
        private final String mProtocol;
        private final String mType;


        private Media(String s, int i, int j, String s1) {
            super("icbka");
            mFormats = new ArrayList();
            mType = s;
            mPort = i;
            mPortCount = j;
            mProtocol = s1;
        }

    }


    public SimpleSessionDescription(long l, String s) {
        mFields = new Fields("voscbtka");
        mMedia = new ArrayList();
        StringBuilder stringbuilder = new StringBuilder();
        String s1;
        String s2;
        Fields fields;
        Object aobj[];
        if(s.indexOf(':') < 0)
            s1 = "IN IP4 ";
        else
            s1 = "IN IP6 ";
        s2 = stringbuilder.append(s1).append(s).toString();
        mFields.parse("v=0");
        fields = mFields;
        aobj = new Object[3];
        aobj[0] = Long.valueOf(l);
        aobj[1] = Long.valueOf(System.currentTimeMillis());
        aobj[2] = s2;
        fields.parse(String.format("o=- %d %d %s", aobj));
        mFields.parse("s=-");
        mFields.parse("t=0 0");
        mFields.parse((new StringBuilder()).append("c=").append(s2).toString());
    }

    public SimpleSessionDescription(String s) {
        String as[];
        Object obj;
        int i;
        int j;
        mFields = new Fields("voscbtka");
        mMedia = new ArrayList();
        as = s.trim().replaceAll(" +", " ").split("[\r\n]+");
        obj = mFields;
        i = as.length;
        j = 0;
_L2:
        String s1;
        if(j >= i)
            break MISSING_BLOCK_LABEL_265;
        s1 = as[j];
        try {
            if(s1.charAt(1) != '=')
                throw new IllegalArgumentException();
        }
        catch(Exception exception) {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid SDP: ").append(s1).toString());
        }
        Media media;
        if(s1.charAt(0) == 'm') {
            String as1[] = s1.substring(2).split(" ", 4);
            String as2[] = as1[1].split("/", 2);
            String s2 = as1[0];
            int k = Integer.parseInt(as2[0]);
            int l;
            String s3;
            String as3[];
            int i1;
            if(as2.length < 2)
                l = 1;
            else
                l = Integer.parseInt(as2[1]);
            s3 = as1[2];
            media = newMedia(s2, k, l, s3);
            as3 = as1[3].split(" ");
            i1 = as3.length;
            for(int j1 = 0; j1 < i1; j1++)
                media.setFormat(as3[j1], null);

            break MISSING_BLOCK_LABEL_266;
        }
        ((Fields) (obj)).parse(s1);
        break MISSING_BLOCK_LABEL_269;
        return;
        obj = media;
        j++;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String encode() {
        StringBuilder stringbuilder = new StringBuilder();
        mFields.write(stringbuilder);
        for(Iterator iterator = mMedia.iterator(); iterator.hasNext(); ((Media)iterator.next()).write(stringbuilder));
        return stringbuilder.toString();
    }

    public String getAddress() {
        return mFields.getAddress();
    }

    public String getAttribute(String s) {
        return mFields.getAttribute(s);
    }

    public String[] getAttributeNames() {
        return mFields.getAttributeNames();
    }

    public int getBandwidth(String s) {
        return mFields.getBandwidth(s);
    }

    public String[] getBandwidthTypes() {
        return mFields.getBandwidthTypes();
    }

    public String getEncryptionKey() {
        return mFields.getEncryptionKey();
    }

    public String getEncryptionMethod() {
        return mFields.getEncryptionMethod();
    }

    public Media[] getMedia() {
        return (Media[])mMedia.toArray(new Media[mMedia.size()]);
    }

    public Media newMedia(String s, int i, int j, String s1) {
        Media media = new Media(s, i, j, s1);
        mMedia.add(media);
        return media;
    }

    public void setAddress(String s) {
        mFields.setAddress(s);
    }

    public void setAttribute(String s, String s1) {
        mFields.setAttribute(s, s1);
    }

    public void setBandwidth(String s, int i) {
        mFields.setBandwidth(s, i);
    }

    public void setEncryption(String s, String s1) {
        mFields.setEncryption(s, s1);
    }

    private final Fields mFields;
    private final ArrayList mMedia;
}
