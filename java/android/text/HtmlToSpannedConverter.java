// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import org.ccil.cowan.tagsoup.Parser;
import org.xml.sax.*;

// Referenced classes of package android.text:
//            SpannableStringBuilder, TextUtils, Spanned

class HtmlToSpannedConverter
    implements ContentHandler {
    private static class Header {

        private int mLevel;


        public Header(int i) {
            mLevel = i;
        }
    }

    private static class Href {

        public String mHref;

        public Href(String s) {
            mHref = s;
        }
    }

    private static class Font {

        public String mColor;
        public String mFace;

        public Font(String s, String s1) {
            mColor = s;
            mFace = s1;
        }
    }

    private static class Sub {

        private Sub() {
        }

    }

    private static class Super {

        private Super() {
        }

    }

    private static class Blockquote {

        private Blockquote() {
        }

    }

    private static class Monospace {

        private Monospace() {
        }

    }

    private static class Small {

        private Small() {
        }

    }

    private static class Big {

        private Big() {
        }

    }

    private static class Underline {

        private Underline() {
        }

    }

    private static class Italic {

        private Italic() {
        }

    }

    private static class Bold {

        private Bold() {
        }

    }


    public HtmlToSpannedConverter(String s, Html.ImageGetter imagegetter, Html.TagHandler taghandler, Parser parser) {
        mSource = s;
        mSpannableStringBuilder = new SpannableStringBuilder();
        mImageGetter = imagegetter;
        mTagHandler = taghandler;
        mReader = parser;
    }

    private static HashMap buildColorMap() {
        HashMap hashmap = new HashMap();
        hashmap.put("aqua", Integer.valueOf(65535));
        hashmap.put("black", Integer.valueOf(0));
        hashmap.put("blue", Integer.valueOf(255));
        hashmap.put("fuchsia", Integer.valueOf(0xff00ff));
        hashmap.put("green", Integer.valueOf(32768));
        hashmap.put("grey", Integer.valueOf(0x808080));
        hashmap.put("lime", Integer.valueOf(65280));
        hashmap.put("maroon", Integer.valueOf(0x800000));
        hashmap.put("navy", Integer.valueOf(128));
        hashmap.put("olive", Integer.valueOf(0x808000));
        hashmap.put("purple", Integer.valueOf(0x800080));
        hashmap.put("red", Integer.valueOf(0xff0000));
        hashmap.put("silver", Integer.valueOf(0xc0c0c0));
        hashmap.put("teal", Integer.valueOf(32896));
        hashmap.put("white", Integer.valueOf(0xffffff));
        hashmap.put("yellow", Integer.valueOf(0xffff00));
        return hashmap;
    }

    private static void end(SpannableStringBuilder spannablestringbuilder, Class class1, Object obj) {
        int i = spannablestringbuilder.length();
        Object obj1 = getLast(spannablestringbuilder, class1);
        int j = spannablestringbuilder.getSpanStart(obj1);
        spannablestringbuilder.removeSpan(obj1);
        if(j != i)
            spannablestringbuilder.setSpan(obj, j, i, 33);
    }

    private static void endA(SpannableStringBuilder spannablestringbuilder) {
        int i = spannablestringbuilder.length();
        Object obj = getLast(spannablestringbuilder, android/text/HtmlToSpannedConverter$Href);
        int j = spannablestringbuilder.getSpanStart(obj);
        spannablestringbuilder.removeSpan(obj);
        if(j != i) {
            Href href = (Href)obj;
            if(href.mHref != null)
                spannablestringbuilder.setSpan(new URLSpan(href.mHref), j, i, 33);
        }
    }

    private static void endFont(SpannableStringBuilder spannablestringbuilder) {
        int i;
        Object obj;
        int j;
        i = spannablestringbuilder.length();
        obj = getLast(spannablestringbuilder, android/text/HtmlToSpannedConverter$Font);
        j = spannablestringbuilder.getSpanStart(obj);
        spannablestringbuilder.removeSpan(obj);
        if(j == i) goto _L2; else goto _L1
_L1:
        Font font = (Font)obj;
        if(TextUtils.isEmpty(font.mColor)) goto _L4; else goto _L3
_L3:
        if(!font.mColor.startsWith("@")) goto _L6; else goto _L5
_L5:
        Resources resources = Resources.getSystem();
        int l = resources.getIdentifier(font.mColor.substring(1), "color", "android");
        if(l != 0)
            spannablestringbuilder.setSpan(new TextAppearanceSpan(null, 0, 0, resources.getColorStateList(l), null), j, i, 33);
_L4:
        if(font.mFace != null)
            spannablestringbuilder.setSpan(new TypefaceSpan(font.mFace), j, i, 33);
_L2:
        return;
_L6:
        int k = getHtmlColor(font.mColor);
        if(k != -1)
            spannablestringbuilder.setSpan(new ForegroundColorSpan(0xff000000 | k), j, i, 33);
        if(true) goto _L4; else goto _L7
_L7:
    }

    private static void endHeader(SpannableStringBuilder spannablestringbuilder) {
        int i = spannablestringbuilder.length();
        Object obj = getLast(spannablestringbuilder, android/text/HtmlToSpannedConverter$Header);
        int j = spannablestringbuilder.getSpanStart(obj);
        spannablestringbuilder.removeSpan(obj);
        for(; i > j && spannablestringbuilder.charAt(i - 1) == '\n'; i--);
        if(j != i) {
            Header header = (Header)obj;
            spannablestringbuilder.setSpan(new RelativeSizeSpan(HEADER_SIZES[header.mLevel]), j, i, 33);
            spannablestringbuilder.setSpan(new StyleSpan(1), j, i, 33);
        }
    }

    private static int getHtmlColor(String s) {
        int i;
        Integer integer;
        i = -1;
        integer = (Integer)COLORS.get(s.toLowerCase());
        if(integer == null) goto _L2; else goto _L1
_L1:
        i = integer.intValue();
_L4:
        return i;
_L2:
        int j = XmlUtils.convertValueToInt(s, -1);
        i = j;
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static Object getLast(Spanned spanned, Class class1) {
        Object aobj[] = spanned.getSpans(0, spanned.length(), class1);
        Object obj;
        if(aobj.length == 0)
            obj = null;
        else
            obj = aobj[-1 + aobj.length];
        return obj;
    }

    private static void handleBr(SpannableStringBuilder spannablestringbuilder) {
        spannablestringbuilder.append("\n");
    }

    private void handleEndTag(String s) {
        if(!s.equalsIgnoreCase("br")) goto _L2; else goto _L1
_L1:
        handleBr(mSpannableStringBuilder);
_L4:
        return;
_L2:
        if(s.equalsIgnoreCase("p"))
            handleP(mSpannableStringBuilder);
        else
        if(s.equalsIgnoreCase("div"))
            handleP(mSpannableStringBuilder);
        else
        if(s.equalsIgnoreCase("strong"))
            end(mSpannableStringBuilder, android/text/HtmlToSpannedConverter$Bold, new StyleSpan(1));
        else
        if(s.equalsIgnoreCase("b"))
            end(mSpannableStringBuilder, android/text/HtmlToSpannedConverter$Bold, new StyleSpan(1));
        else
        if(s.equalsIgnoreCase("em"))
            end(mSpannableStringBuilder, android/text/HtmlToSpannedConverter$Italic, new StyleSpan(2));
        else
        if(s.equalsIgnoreCase("cite"))
            end(mSpannableStringBuilder, android/text/HtmlToSpannedConverter$Italic, new StyleSpan(2));
        else
        if(s.equalsIgnoreCase("dfn"))
            end(mSpannableStringBuilder, android/text/HtmlToSpannedConverter$Italic, new StyleSpan(2));
        else
        if(s.equalsIgnoreCase("i"))
            end(mSpannableStringBuilder, android/text/HtmlToSpannedConverter$Italic, new StyleSpan(2));
        else
        if(s.equalsIgnoreCase("big"))
            end(mSpannableStringBuilder, android/text/HtmlToSpannedConverter$Big, new RelativeSizeSpan(1.25F));
        else
        if(s.equalsIgnoreCase("small"))
            end(mSpannableStringBuilder, android/text/HtmlToSpannedConverter$Small, new RelativeSizeSpan(0.8F));
        else
        if(s.equalsIgnoreCase("font"))
            endFont(mSpannableStringBuilder);
        else
        if(s.equalsIgnoreCase("blockquote")) {
            handleP(mSpannableStringBuilder);
            end(mSpannableStringBuilder, android/text/HtmlToSpannedConverter$Blockquote, new QuoteSpan());
        } else
        if(s.equalsIgnoreCase("tt"))
            end(mSpannableStringBuilder, android/text/HtmlToSpannedConverter$Monospace, new TypefaceSpan("monospace"));
        else
        if(s.equalsIgnoreCase("a"))
            endA(mSpannableStringBuilder);
        else
        if(s.equalsIgnoreCase("u"))
            end(mSpannableStringBuilder, android/text/HtmlToSpannedConverter$Underline, new UnderlineSpan());
        else
        if(s.equalsIgnoreCase("sup"))
            end(mSpannableStringBuilder, android/text/HtmlToSpannedConverter$Super, new SuperscriptSpan());
        else
        if(s.equalsIgnoreCase("sub"))
            end(mSpannableStringBuilder, android/text/HtmlToSpannedConverter$Sub, new SubscriptSpan());
        else
        if(s.length() == 2 && Character.toLowerCase(s.charAt(0)) == 'h' && s.charAt(1) >= '1' && s.charAt(1) <= '6') {
            handleP(mSpannableStringBuilder);
            endHeader(mSpannableStringBuilder);
        } else
        if(mTagHandler != null)
            mTagHandler.handleTag(false, s, mSpannableStringBuilder, mReader);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static void handleP(SpannableStringBuilder spannablestringbuilder) {
        int i = spannablestringbuilder.length();
        if(i < 1 || spannablestringbuilder.charAt(i - 1) != '\n') goto _L2; else goto _L1
_L1:
        if(i < 2 || spannablestringbuilder.charAt(i - 2) != '\n')
            spannablestringbuilder.append("\n");
_L4:
        return;
_L2:
        if(i != 0)
            spannablestringbuilder.append("\n\n");
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void handleStartTag(String s, Attributes attributes) {
        if(!s.equalsIgnoreCase("br")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(s.equalsIgnoreCase("p"))
            handleP(mSpannableStringBuilder);
        else
        if(s.equalsIgnoreCase("div"))
            handleP(mSpannableStringBuilder);
        else
        if(s.equalsIgnoreCase("strong"))
            start(mSpannableStringBuilder, new Bold());
        else
        if(s.equalsIgnoreCase("b"))
            start(mSpannableStringBuilder, new Bold());
        else
        if(s.equalsIgnoreCase("em"))
            start(mSpannableStringBuilder, new Italic());
        else
        if(s.equalsIgnoreCase("cite"))
            start(mSpannableStringBuilder, new Italic());
        else
        if(s.equalsIgnoreCase("dfn"))
            start(mSpannableStringBuilder, new Italic());
        else
        if(s.equalsIgnoreCase("i"))
            start(mSpannableStringBuilder, new Italic());
        else
        if(s.equalsIgnoreCase("big"))
            start(mSpannableStringBuilder, new Big());
        else
        if(s.equalsIgnoreCase("small"))
            start(mSpannableStringBuilder, new Small());
        else
        if(s.equalsIgnoreCase("font"))
            startFont(mSpannableStringBuilder, attributes);
        else
        if(s.equalsIgnoreCase("blockquote")) {
            handleP(mSpannableStringBuilder);
            start(mSpannableStringBuilder, new Blockquote());
        } else
        if(s.equalsIgnoreCase("tt"))
            start(mSpannableStringBuilder, new Monospace());
        else
        if(s.equalsIgnoreCase("a"))
            startA(mSpannableStringBuilder, attributes);
        else
        if(s.equalsIgnoreCase("u"))
            start(mSpannableStringBuilder, new Underline());
        else
        if(s.equalsIgnoreCase("sup"))
            start(mSpannableStringBuilder, new Super());
        else
        if(s.equalsIgnoreCase("sub"))
            start(mSpannableStringBuilder, new Sub());
        else
        if(s.length() == 2 && Character.toLowerCase(s.charAt(0)) == 'h' && s.charAt(1) >= '1' && s.charAt(1) <= '6') {
            handleP(mSpannableStringBuilder);
            start(mSpannableStringBuilder, new Header(-49 + s.charAt(1)));
        } else
        if(s.equalsIgnoreCase("img"))
            startImg(mSpannableStringBuilder, attributes, mImageGetter);
        else
        if(mTagHandler != null)
            mTagHandler.handleTag(true, s, mSpannableStringBuilder, mReader);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static void start(SpannableStringBuilder spannablestringbuilder, Object obj) {
        int i = spannablestringbuilder.length();
        spannablestringbuilder.setSpan(obj, i, i, 17);
    }

    private static void startA(SpannableStringBuilder spannablestringbuilder, Attributes attributes) {
        String s = attributes.getValue("", "href");
        int i = spannablestringbuilder.length();
        spannablestringbuilder.setSpan(new Href(s), i, i, 17);
    }

    private static void startFont(SpannableStringBuilder spannablestringbuilder, Attributes attributes) {
        String s = attributes.getValue("", "color");
        String s1 = attributes.getValue("", "face");
        int i = spannablestringbuilder.length();
        spannablestringbuilder.setSpan(new Font(s, s1), i, i, 17);
    }

    private static void startImg(SpannableStringBuilder spannablestringbuilder, Attributes attributes, Html.ImageGetter imagegetter) {
        String s = attributes.getValue("", "src");
        Drawable drawable = null;
        if(imagegetter != null)
            drawable = imagegetter.getDrawable(s);
        if(drawable == null) {
            drawable = Resources.getSystem().getDrawable(0x10805f4);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        int i = spannablestringbuilder.length();
        spannablestringbuilder.append("\uFFFC");
        spannablestringbuilder.setSpan(new ImageSpan(drawable, s), i, spannablestringbuilder.length(), 33);
    }

    public void characters(char ac[], int i, int j) throws SAXException {
        StringBuilder stringbuilder = new StringBuilder();
        int k = 0;
        while(k < j)  {
            char c = ac[k + i];
            if(c == ' ' || c == '\n') {
                int l = stringbuilder.length();
                char c1;
                if(l == 0) {
                    int i1 = mSpannableStringBuilder.length();
                    if(i1 == 0)
                        c1 = '\n';
                    else
                        c1 = mSpannableStringBuilder.charAt(i1 - 1);
                } else {
                    c1 = stringbuilder.charAt(l - 1);
                }
                if(c1 != 32 && c1 != 10)
                    stringbuilder.append(' ');
            } else {
                stringbuilder.append(c);
            }
            k++;
        }
        mSpannableStringBuilder.append(stringbuilder);
    }

    public Spanned convert() {
        mReader.setContentHandler(this);
        Object aobj[];
        int i;
        try {
            mReader.parse(new InputSource(new StringReader(mSource)));
        }
        catch(IOException ioexception) {
            throw new RuntimeException(ioexception);
        }
        catch(SAXException saxexception) {
            throw new RuntimeException(saxexception);
        }
        aobj = mSpannableStringBuilder.getSpans(0, mSpannableStringBuilder.length(), android/text/style/ParagraphStyle);
        i = 0;
        while(i < aobj.length)  {
            int j = mSpannableStringBuilder.getSpanStart(aobj[i]);
            int k = mSpannableStringBuilder.getSpanEnd(aobj[i]);
            if(k - 2 >= 0 && mSpannableStringBuilder.charAt(k - 1) == '\n' && mSpannableStringBuilder.charAt(k - 2) == '\n')
                k--;
            if(k == j)
                mSpannableStringBuilder.removeSpan(aobj[i]);
            else
                mSpannableStringBuilder.setSpan(aobj[i], j, k, 51);
            i++;
        }
        return mSpannableStringBuilder;
    }

    public void endDocument() throws SAXException {
    }

    public void endElement(String s, String s1, String s2) throws SAXException {
        handleEndTag(s1);
    }

    public void endPrefixMapping(String s) throws SAXException {
    }

    public void ignorableWhitespace(char ac[], int i, int j) throws SAXException {
    }

    public void processingInstruction(String s, String s1) throws SAXException {
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void skippedEntity(String s) throws SAXException {
    }

    public void startDocument() throws SAXException {
    }

    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
        handleStartTag(s1, attributes);
    }

    public void startPrefixMapping(String s, String s1) throws SAXException {
    }

    private static HashMap COLORS = buildColorMap();
    private static final float HEADER_SIZES[];
    private Html.ImageGetter mImageGetter;
    private XMLReader mReader;
    private String mSource;
    private SpannableStringBuilder mSpannableStringBuilder;
    private Html.TagHandler mTagHandler;

    static  {
        float af[] = new float[6];
        af[0] = 1.5F;
        af[1] = 1.4F;
        af[2] = 1.3F;
        af[3] = 1.2F;
        af[4] = 1.1F;
        af[5] = 1.0F;
        HEADER_SIZES = af;
    }
}
