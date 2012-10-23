// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import android.graphics.drawable.Drawable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import com.android.internal.util.ArrayUtils;
import org.ccil.cowan.tagsoup.HTMLSchema;
import org.ccil.cowan.tagsoup.Parser;
import org.xml.sax.*;

// Referenced classes of package android.text:
//            HtmlToSpannedConverter, TextUtils, AndroidBidi, Spanned, 
//            Editable

public class Html {
    private static class HtmlParser {

        private static final HTMLSchema schema = new HTMLSchema();



        private HtmlParser() {
        }
    }

    public static interface TagHandler {

        public abstract void handleTag(boolean flag, String s, Editable editable, XMLReader xmlreader);
    }

    public static interface ImageGetter {

        public abstract Drawable getDrawable(String s);
    }


    private Html() {
    }

    public static String escapeHtml(CharSequence charsequence) {
        StringBuilder stringbuilder = new StringBuilder();
        withinStyle(stringbuilder, charsequence, 0, charsequence.length());
        return stringbuilder.toString();
    }

    public static Spanned fromHtml(String s) {
        return fromHtml(s, null, null);
    }

    public static Spanned fromHtml(String s, ImageGetter imagegetter, TagHandler taghandler) {
        Parser parser = new Parser();
        try {
            parser.setProperty("http://www.ccil.org/~cowan/tagsoup/properties/schema", HtmlParser.schema);
        }
        catch(SAXNotRecognizedException saxnotrecognizedexception) {
            throw new RuntimeException(saxnotrecognizedexception);
        }
        catch(SAXNotSupportedException saxnotsupportedexception) {
            throw new RuntimeException(saxnotsupportedexception);
        }
        return (new HtmlToSpannedConverter(s, imagegetter, taghandler, parser)).convert();
    }

    private static String getOpenParaTagWithDirection(Spanned spanned, int i, int j) {
        int k;
        byte abyte0[];
        char ac[];
        k = j - i;
        abyte0 = new byte[ArrayUtils.idealByteArraySize(k)];
        ac = TextUtils.obtain(k);
        TextUtils.getChars(spanned, i, j, ac, 0);
        AndroidBidi.bidi(2, ac, abyte0, k, false);
        JVM INSTR tableswitch -1 -1: default 56
    //                   -1 63;
           goto _L1 _L2
_L1:
        String s = "<p dir=ltr>";
_L4:
        return s;
_L2:
        s = "<p dir=rtl>";
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static String toHtml(Spanned spanned) {
        StringBuilder stringbuilder = new StringBuilder();
        withinHtml(stringbuilder, spanned);
        return stringbuilder.toString();
    }

    private static void withinBlockquote(StringBuilder stringbuilder, Spanned spanned, int i, int j) {
        stringbuilder.append(getOpenParaTagWithDirection(spanned, i, j));
        int k = i;
        while(k < j)  {
            int l = TextUtils.indexOf(spanned, '\n', k, j);
            if(l < 0)
                l = j;
            int i1 = 0;
            for(; l < j && spanned.charAt(l) == '\n'; l++)
                i1++;

            int j1 = l - i1;
            boolean flag;
            if(l == j)
                flag = true;
            else
                flag = false;
            withinParagraph(stringbuilder, spanned, k, j1, i1, flag);
            k = l;
        }
        stringbuilder.append("</p>\n");
    }

    private static void withinDiv(StringBuilder stringbuilder, Spanned spanned, int i, int j) {
        int l;
        for(int k = i; k < j; k = l) {
            l = spanned.nextSpanTransition(k, j, android/text/style/QuoteSpan);
            QuoteSpan aquotespan[] = (QuoteSpan[])spanned.getSpans(k, l, android/text/style/QuoteSpan);
            int i1 = aquotespan.length;
            for(int j1 = 0; j1 < i1; j1++) {
                QuoteSpan _tmp = aquotespan[j1];
                stringbuilder.append("<blockquote>");
            }

            withinBlockquote(stringbuilder, spanned, k, l);
            int k1 = aquotespan.length;
            for(int l1 = 0; l1 < k1; l1++) {
                QuoteSpan _tmp1 = aquotespan[l1];
                stringbuilder.append("</blockquote>\n");
            }

        }

    }

    private static void withinHtml(StringBuilder stringbuilder, Spanned spanned) {
        int i = spanned.length();
        int k;
        for(int j = 0; j < spanned.length(); j = k) {
            k = spanned.nextSpanTransition(j, i, android/text/style/ParagraphStyle);
            ParagraphStyle aparagraphstyle[] = (ParagraphStyle[])spanned.getSpans(j, k, android/text/style/ParagraphStyle);
            String s = " ";
            boolean flag = false;
            int l = 0;
            while(l < aparagraphstyle.length)  {
                if(aparagraphstyle[l] instanceof AlignmentSpan) {
                    Layout.Alignment alignment = ((AlignmentSpan)aparagraphstyle[l]).getAlignment();
                    flag = true;
                    if(alignment == Layout.Alignment.ALIGN_CENTER)
                        s = (new StringBuilder()).append("align=\"center\" ").append(s).toString();
                    else
                    if(alignment == Layout.Alignment.ALIGN_OPPOSITE)
                        s = (new StringBuilder()).append("align=\"right\" ").append(s).toString();
                    else
                        s = (new StringBuilder()).append("align=\"left\" ").append(s).toString();
                }
                l++;
            }
            if(flag)
                stringbuilder.append((new StringBuilder()).append("<div ").append(s).append(">").toString());
            withinDiv(stringbuilder, spanned, j, k);
            if(flag)
                stringbuilder.append("</div>");
        }

    }

    private static void withinParagraph(StringBuilder stringbuilder, Spanned spanned, int i, int j, int k, boolean flag) {
        int j1;
        for(int l = i; l < j; l = j1) {
            j1 = spanned.nextSpanTransition(l, j, android/text/style/CharacterStyle);
            CharacterStyle acharacterstyle[] = (CharacterStyle[])spanned.getSpans(l, j1, android/text/style/CharacterStyle);
            for(int k1 = 0; k1 < acharacterstyle.length; k1++) {
                if(acharacterstyle[k1] instanceof StyleSpan) {
                    int j2 = ((StyleSpan)acharacterstyle[k1]).getStyle();
                    if((j2 & 1) != 0)
                        stringbuilder.append("<b>");
                    if((j2 & 2) != 0)
                        stringbuilder.append("<i>");
                }
                if((acharacterstyle[k1] instanceof TypefaceSpan) && ((TypefaceSpan)acharacterstyle[k1]).getFamily().equals("monospace"))
                    stringbuilder.append("<tt>");
                if(acharacterstyle[k1] instanceof SuperscriptSpan)
                    stringbuilder.append("<sup>");
                if(acharacterstyle[k1] instanceof SubscriptSpan)
                    stringbuilder.append("<sub>");
                if(acharacterstyle[k1] instanceof UnderlineSpan)
                    stringbuilder.append("<u>");
                if(acharacterstyle[k1] instanceof StrikethroughSpan)
                    stringbuilder.append("<strike>");
                if(acharacterstyle[k1] instanceof URLSpan) {
                    stringbuilder.append("<a href=\"");
                    stringbuilder.append(((URLSpan)acharacterstyle[k1]).getURL());
                    stringbuilder.append("\">");
                }
                if(acharacterstyle[k1] instanceof ImageSpan) {
                    stringbuilder.append("<img src=\"");
                    stringbuilder.append(((ImageSpan)acharacterstyle[k1]).getSource());
                    stringbuilder.append("\">");
                    l = j1;
                }
                if(acharacterstyle[k1] instanceof AbsoluteSizeSpan) {
                    stringbuilder.append("<font size =\"");
                    stringbuilder.append(((AbsoluteSizeSpan)acharacterstyle[k1]).getSize() / 6);
                    stringbuilder.append("\">");
                }
                if(!(acharacterstyle[k1] instanceof ForegroundColorSpan))
                    continue;
                stringbuilder.append("<font color =\"#");
                String s1;
                for(s1 = Integer.toHexString(0x1000000 + ((ForegroundColorSpan)acharacterstyle[k1]).getForegroundColor()); s1.length() < 6; s1 = (new StringBuilder()).append("0").append(s1).toString());
                stringbuilder.append(s1);
                stringbuilder.append("\">");
            }

            withinStyle(stringbuilder, spanned, l, j1);
            for(int l1 = -1 + acharacterstyle.length; l1 >= 0; l1--) {
                if(acharacterstyle[l1] instanceof ForegroundColorSpan)
                    stringbuilder.append("</font>");
                if(acharacterstyle[l1] instanceof AbsoluteSizeSpan)
                    stringbuilder.append("</font>");
                if(acharacterstyle[l1] instanceof URLSpan)
                    stringbuilder.append("</a>");
                if(acharacterstyle[l1] instanceof StrikethroughSpan)
                    stringbuilder.append("</strike>");
                if(acharacterstyle[l1] instanceof UnderlineSpan)
                    stringbuilder.append("</u>");
                if(acharacterstyle[l1] instanceof SubscriptSpan)
                    stringbuilder.append("</sub>");
                if(acharacterstyle[l1] instanceof SuperscriptSpan)
                    stringbuilder.append("</sup>");
                if((acharacterstyle[l1] instanceof TypefaceSpan) && ((TypefaceSpan)acharacterstyle[l1]).getFamily().equals("monospace"))
                    stringbuilder.append("</tt>");
                if(!(acharacterstyle[l1] instanceof StyleSpan))
                    continue;
                int i2 = ((StyleSpan)acharacterstyle[l1]).getStyle();
                if((i2 & 1) != 0)
                    stringbuilder.append("</b>");
                if((i2 & 2) != 0)
                    stringbuilder.append("</i>");
            }

        }

        String s;
        if(flag)
            s = "";
        else
            s = (new StringBuilder()).append("</p>\n").append(getOpenParaTagWithDirection(spanned, i, j)).toString();
        if(k == 1)
            stringbuilder.append("<br>\n");
        else
        if(k == 2) {
            stringbuilder.append(s);
        } else {
            for(int i1 = 2; i1 < k; i1++)
                stringbuilder.append("<br>");

            stringbuilder.append(s);
        }
    }

    private static void withinStyle(StringBuilder stringbuilder, CharSequence charsequence, int i, int j) {
        int k = i;
        while(k < j)  {
            char c = charsequence.charAt(k);
            if(c == '<')
                stringbuilder.append("&lt;");
            else
            if(c == '>')
                stringbuilder.append("&gt;");
            else
            if(c == '&')
                stringbuilder.append("&amp;");
            else
            if(c > '~' || c < ' ')
                stringbuilder.append((new StringBuilder()).append("&#").append(c).append(";").toString());
            else
            if(c == ' ') {
                for(; k + 1 < j && charsequence.charAt(k + 1) == ' '; k++)
                    stringbuilder.append("&nbsp;");

                stringbuilder.append(' ');
            } else {
                stringbuilder.append(c);
            }
            k++;
        }
    }
}
