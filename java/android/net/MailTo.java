// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import java.util.*;

// Referenced classes of package android.net:
//            ParseException, Uri

public class MailTo {

    private MailTo() {
        mHeaders = new HashMap();
    }

    public static boolean isMailTo(String s) {
        boolean flag;
        if(s != null && s.startsWith("mailto:"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static MailTo parse(String s) throws ParseException {
        if(s == null)
            throw new NullPointerException();
        if(!isMailTo(s))
            throw new ParseException("Not a mailto scheme");
        Uri uri = Uri.parse(s.substring("mailto:".length()));
        MailTo mailto = new MailTo();
        String s1 = uri.getQuery();
        if(s1 != null) {
            String as[] = s1.split("&");
            int i = as.length;
            int j = 0;
            while(j < i)  {
                String as1[] = as[j].split("=");
                if(as1.length != 0) {
                    HashMap hashmap = mailto.mHeaders;
                    String s4 = Uri.decode(as1[0]).toLowerCase();
                    String s5;
                    if(as1.length > 1)
                        s5 = Uri.decode(as1[1]);
                    else
                        s5 = null;
                    hashmap.put(s4, s5);
                }
                j++;
            }
        }
        String s2 = uri.getPath();
        if(s2 != null) {
            String s3 = mailto.getTo();
            if(s3 != null)
                s2 = (new StringBuilder()).append(s2).append(", ").append(s3).toString();
            mailto.mHeaders.put("to", s2);
        }
        return mailto;
    }

    public String getBody() {
        return (String)mHeaders.get("body");
    }

    public String getCc() {
        return (String)mHeaders.get("cc");
    }

    public Map getHeaders() {
        return mHeaders;
    }

    public String getSubject() {
        return (String)mHeaders.get("subject");
    }

    public String getTo() {
        return (String)mHeaders.get("to");
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder("mailto:");
        stringbuilder.append('?');
        for(Iterator iterator = mHeaders.entrySet().iterator(); iterator.hasNext(); stringbuilder.append('&')) {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            stringbuilder.append(Uri.encode((String)entry.getKey()));
            stringbuilder.append('=');
            stringbuilder.append(Uri.encode((String)entry.getValue()));
        }

        return stringbuilder.toString();
    }

    private static final String BODY = "body";
    private static final String CC = "cc";
    public static final String MAILTO_SCHEME = "mailto:";
    private static final String SUBJECT = "subject";
    private static final String TO = "to";
    private HashMap mHeaders;
}
