// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.util;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.Patterns;
import android.webkit.WebView;
import android.widget.TextView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Linkify {
    public static class LinkSpec {

        public int end;
        public int start;
        public String url;

        public LinkSpec() {
        }
    }

    public static interface TransformFilter {

        public abstract String transformUrl(Matcher matcher, String s);
    }

    public static interface MatchFilter {

        public abstract boolean acceptMatch(CharSequence charsequence, int i, int j);
    }


    public Linkify() {
    }

    private static final void addLinkMovementMethod(TextView textview) {
        android.text.method.MovementMethod movementmethod = textview.getMovementMethod();
        if((movementmethod == null || !(movementmethod instanceof LinkMovementMethod)) && textview.getLinksClickable())
            textview.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static final void addLinks(TextView textview, Pattern pattern, String s) {
        addLinks(textview, pattern, s, null, null);
    }

    public static final void addLinks(TextView textview, Pattern pattern, String s, MatchFilter matchfilter, TransformFilter transformfilter) {
        SpannableString spannablestring = SpannableString.valueOf(textview.getText());
        if(addLinks(((Spannable) (spannablestring)), pattern, s, matchfilter, transformfilter)) {
            textview.setText(spannablestring);
            addLinkMovementMethod(textview);
        }
    }

    public static final boolean addLinks(Spannable spannable, int i) {
        boolean flag;
        if(i == 0) {
            flag = false;
        } else {
            URLSpan aurlspan[] = (URLSpan[])spannable.getSpans(0, spannable.length(), android/text/style/URLSpan);
            for(int j = -1 + aurlspan.length; j >= 0; j--)
                spannable.removeSpan(aurlspan[j]);

            ArrayList arraylist = new ArrayList();
            if((i & 1) != 0) {
                Pattern pattern2 = Patterns.WEB_URL;
                String as2[] = new String[3];
                as2[0] = "http://";
                as2[1] = "https://";
                as2[2] = "rtsp://";
                gatherLinks(arraylist, spannable, pattern2, as2, sUrlMatchFilter, null);
            }
            if((i & 2) != 0) {
                Pattern pattern1 = Patterns.EMAIL_ADDRESS;
                String as1[] = new String[1];
                as1[0] = "mailto:";
                gatherLinks(arraylist, spannable, pattern1, as1, null, null);
            }
            if((i & 4) != 0) {
                Pattern pattern = Patterns.PHONE;
                String as[] = new String[1];
                as[0] = "tel:";
                gatherLinks(arraylist, spannable, pattern, as, sPhoneNumberMatchFilter, sPhoneNumberTransformFilter);
            }
            if((i & 8) != 0)
                gatherMapLinks(arraylist, spannable);
            pruneOverlaps(arraylist);
            if(arraylist.size() == 0) {
                flag = false;
            } else {
                LinkSpec linkspec;
                for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); applyLink(linkspec.url, linkspec.start, linkspec.end, spannable))
                    linkspec = (LinkSpec)iterator.next();

                flag = true;
            }
        }
        return flag;
    }

    public static final boolean addLinks(Spannable spannable, Pattern pattern, String s) {
        return addLinks(spannable, pattern, s, null, null);
    }

    public static final boolean addLinks(Spannable spannable, Pattern pattern, String s, MatchFilter matchfilter, TransformFilter transformfilter) {
        boolean flag = false;
        String s1;
        Matcher matcher;
        if(s == null)
            s1 = "";
        else
            s1 = s.toLowerCase();
        matcher = pattern.matcher(spannable);
        do {
            if(!matcher.find())
                break;
            int i = matcher.start();
            int j = matcher.end();
            boolean flag1 = true;
            if(matchfilter != null)
                flag1 = matchfilter.acceptMatch(spannable, i, j);
            if(flag1) {
                String s2 = matcher.group(0);
                String as[] = new String[1];
                as[0] = s1;
                applyLink(makeUrl(s2, as, matcher, transformfilter), i, j, spannable);
                flag = true;
            }
        } while(true);
        return flag;
    }

    public static final boolean addLinks(TextView textview, int i) {
        boolean flag = false;
        if(i != 0) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        CharSequence charsequence = textview.getText();
        if(charsequence instanceof Spannable) {
            if(addLinks((Spannable)charsequence, i)) {
                addLinkMovementMethod(textview);
                flag = true;
            }
        } else {
            SpannableString spannablestring = SpannableString.valueOf(charsequence);
            if(addLinks(((Spannable) (spannablestring)), i)) {
                addLinkMovementMethod(textview);
                textview.setText(spannablestring);
                flag = true;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static final void applyLink(String s, int i, int j, Spannable spannable) {
        spannable.setSpan(new URLSpan(s), i, j, 33);
    }

    public static final void gatherLinks(ArrayList arraylist, Spannable spannable, Pattern pattern, String as[], MatchFilter matchfilter, TransformFilter transformfilter) {
        Matcher matcher = pattern.matcher(spannable);
        do {
            if(!matcher.find())
                break;
            int i = matcher.start();
            int j = matcher.end();
            if(matchfilter == null || matchfilter.acceptMatch(spannable, i, j)) {
                LinkSpec linkspec = new LinkSpec();
                linkspec.url = makeUrl(matcher.group(0), as, matcher, transformfilter);
                linkspec.start = i;
                linkspec.end = j;
                arraylist.add(linkspec);
            }
        } while(true);
    }

    public static final void gatherMapLinks(ArrayList arraylist, Spannable spannable) {
        String s;
        int i;
        s = spannable.toString();
        i = 0;
_L2:
        String s1;
        LinkSpec linkspec;
        int j;
label0:
        {
            s1 = WebView.findAddress(s);
            if(s1 != null) {
                j = s.indexOf(s1);
                if(j >= 0)
                    break label0;
            }
            return;
        }
        linkspec = new LinkSpec();
        int k = j + s1.length();
        linkspec.start = i + j;
        linkspec.end = i + k;
        s = s.substring(k);
        i += k;
        String s2 = URLEncoder.encode(s1, "UTF-8");
        linkspec.url = (new StringBuilder()).append("geo:0,0?q=").append(s2).toString();
        arraylist.add(linkspec);
        continue; /* Loop/switch isn't completed */
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static final String makeUrl(String s, String as[], Matcher matcher, TransformFilter transformfilter) {
        if(transformfilter != null)
            s = transformfilter.transformUrl(matcher, s);
        boolean flag = false;
        int i = 0;
        do {
label0:
            {
                if(i < as.length) {
                    String s1 = as[i];
                    int j = as[i].length();
                    if(!s.regionMatches(true, 0, s1, 0, j))
                        break label0;
                    flag = true;
                    String s2 = as[i];
                    int k = as[i].length();
                    if(!s.regionMatches(false, 0, s2, 0, k))
                        s = (new StringBuilder()).append(as[i]).append(s.substring(as[i].length())).toString();
                }
                if(!flag)
                    s = (new StringBuilder()).append(as[0]).append(s).toString();
                return s;
            }
            i++;
        } while(true);
    }

    public static final void pruneOverlaps(ArrayList arraylist) {
        int i;
        int j;
        Collections.sort(arraylist, new Comparator() {

            public final int compare(LinkSpec linkspec2, LinkSpec linkspec3) {
                byte byte0 = -1;
                if(linkspec2.start >= linkspec3.start) goto _L2; else goto _L1
_L1:
                return byte0;
_L2:
                if(linkspec2.start > linkspec3.start)
                    byte0 = 1;
                else
                if(linkspec2.end < linkspec3.end)
                    byte0 = 1;
                else
                if(linkspec2.end <= linkspec3.end)
                    byte0 = 0;
                if(true) goto _L1; else goto _L3
_L3:
            }

            public volatile int compare(Object obj, Object obj1) {
                return compare((LinkSpec)obj, (LinkSpec)obj1);
            }

            public final boolean equals(Object obj) {
                return false;
            }

        });
        i = arraylist.size();
        j = 0;
_L7:
        LinkSpec linkspec;
        LinkSpec linkspec1;
        int k;
        if(j >= i - 1)
            break; /* Loop/switch isn't completed */
        linkspec = (LinkSpec)arraylist.get(j);
        linkspec1 = (LinkSpec)arraylist.get(j + 1);
        k = -1;
        if(linkspec.start > linkspec1.start || linkspec.end <= linkspec1.start) goto _L2; else goto _L1
_L1:
        if(linkspec1.end > linkspec.end) goto _L4; else goto _L3
_L3:
        k = j + 1;
_L5:
        if(k == -1)
            break; /* Loop/switch isn't completed */
        arraylist.remove(k);
        i--;
        continue; /* Loop/switch isn't completed */
_L4:
        if(linkspec.end - linkspec.start > linkspec1.end - linkspec1.start)
            k = j + 1;
        else
        if(linkspec.end - linkspec.start < linkspec1.end - linkspec1.start)
            k = j;
        if(true) goto _L5; else goto _L2
_L2:
        j++;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public static final int ALL = 15;
    public static final int EMAIL_ADDRESSES = 2;
    public static final int MAP_ADDRESSES = 8;
    public static final int PHONE_NUMBERS = 4;
    private static final int PHONE_NUMBER_MINIMUM_DIGITS = 5;
    public static final int WEB_URLS = 1;
    public static final MatchFilter sPhoneNumberMatchFilter = new MatchFilter() {

        public final boolean acceptMatch(CharSequence charsequence, int i, int j) {
            int k;
            int l;
            k = 0;
            l = i;
_L3:
            if(l >= j)
                break MISSING_BLOCK_LABEL_47;
            if(!Character.isDigit(charsequence.charAt(l)) || ++k < 5) goto _L2; else goto _L1
_L1:
            boolean flag = true;
_L4:
            return flag;
_L2:
            l++;
              goto _L3
            flag = false;
              goto _L4
        }

    };
    public static final TransformFilter sPhoneNumberTransformFilter = new TransformFilter() {

        public final String transformUrl(Matcher matcher, String s) {
            return Patterns.digitsAndPlusOnly(matcher);
        }

    };
    public static final MatchFilter sUrlMatchFilter = new MatchFilter() {

        public final boolean acceptMatch(CharSequence charsequence, int i, int j) {
            boolean flag;
            flag = true;
            break MISSING_BLOCK_LABEL_3;
            if(i != 0 && charsequence.charAt(i - 1) == '@')
                flag = false;
            return flag;
        }

    };

}
