// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.text.util;

import android.text.Spannable;
import android.text.style.URLSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import miui.util.Patterns;

public class Linkify {

    public Linkify() {
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
                Pattern pattern1 = android.util.Patterns.EMAIL_ADDRESS;
                String as1[] = new String[1];
                as1[0] = "mailto:";
                gatherLinks(arraylist, spannable, pattern1, as1, null, null);
            }
            if((i & 4) != 0) {
                Pattern pattern = android.util.Patterns.PHONE;
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
                android.text.util.LinkSpec linkspec;
                for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); applyLink(linkspec.url, linkspec.start, linkspec.end, spannable))
                    linkspec = (android.text.util.LinkSpec)iterator.next();

                flag = true;
            }
        }
        return flag;
    }

    private static final void applyLink(String s, int i, int j, Spannable spannable) {
        android.text.util.Linkify.applyLink(s, i, j, spannable);
    }

    private static final void gatherLinks(ArrayList arraylist, Spannable spannable, Pattern pattern, String as[], android.text.util.MatchFilter matchfilter, android.text.util.TransformFilter transformfilter) {
        android.text.util.Linkify.gatherLinks(arraylist, spannable, pattern, as, matchfilter, transformfilter);
    }

    private static final void gatherMapLinks(ArrayList arraylist, Spannable spannable) {
        android.text.util.Linkify.gatherMapLinks(arraylist, spannable);
    }

    private static final void pruneOverlaps(ArrayList arraylist) {
        android.text.util.Linkify.pruneOverlaps(arraylist);
    }

    public static final android.text.util.MatchFilter sPhoneNumberMatchFilter;
    public static final android.text.util.TransformFilter sPhoneNumberTransformFilter;
    public static final android.text.util.MatchFilter sUrlMatchFilter;

    static  {
        sUrlMatchFilter = android.text.util.Linkify.sUrlMatchFilter;
        sPhoneNumberMatchFilter = android.text.util.Linkify.sPhoneNumberMatchFilter;
        sPhoneNumberTransformFilter = android.text.util.Linkify.sPhoneNumberTransformFilter;
    }
}
