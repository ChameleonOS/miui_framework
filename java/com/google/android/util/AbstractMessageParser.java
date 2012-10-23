// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractMessageParser {
    public static class Part {

        private String getPartType() {
            String s;
            if(isMedia())
                s = "d";
            else
            if(meText != null)
                s = "m";
            else
                s = "";
            return s;
        }

        public void add(Token token) {
            if(isMedia()) {
                throw new AssertionError("media ");
            } else {
                tokens.add(token);
                return;
            }
        }

        public Token getMediaToken() {
            Token token;
            if(isMedia())
                token = (Token)tokens.get(0);
            else
                token = null;
            return token;
        }

        public String getRawText() {
            StringBuilder stringbuilder = new StringBuilder();
            if(meText != null)
                stringbuilder.append(meText);
            for(int i = 0; i < tokens.size(); i++)
                stringbuilder.append(((Token)tokens.get(i)).getRawText());

            return stringbuilder.toString();
        }

        public ArrayList getTokens() {
            return tokens;
        }

        public String getType(boolean flag) {
            StringBuilder stringbuilder = new StringBuilder();
            String s;
            if(flag)
                s = "s";
            else
                s = "r";
            return stringbuilder.append(s).append(getPartType()).toString();
        }

        public boolean isMedia() {
            boolean flag;
            if(tokens.size() == 1 && ((Token)tokens.get(0)).isMedia())
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void setMeText(String s) {
            meText = s;
        }

        private String meText;
        private ArrayList tokens;

        public Part() {
            tokens = new ArrayList();
        }
    }

    public static class TrieNode {

        public static void addToTrie(TrieNode trienode, String s, String s1) {
            int j;
            for(int i = 0; i < s.length(); i = j) {
                j = i + 1;
                trienode = trienode.getOrCreateChild(s.charAt(i));
            }

            trienode.setValue(s1);
        }

        public final boolean exists() {
            boolean flag;
            if(value != null)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public TrieNode getChild(char c) {
            return (TrieNode)children.get(Character.valueOf(c));
        }

        public TrieNode getOrCreateChild(char c) {
            Character character = Character.valueOf(c);
            TrieNode trienode = (TrieNode)children.get(character);
            if(trienode == null) {
                trienode = new TrieNode((new StringBuilder()).append(text).append(String.valueOf(c)).toString());
                children.put(character, trienode);
            }
            return trienode;
        }

        public final String getText() {
            return text;
        }

        public final String getValue() {
            return value;
        }

        public void setValue(String s) {
            value = s;
        }

        private final HashMap children;
        private String text;
        private String value;

        public TrieNode() {
            this("");
        }

        public TrieNode(String s) {
            children = new HashMap();
            text = s;
        }
    }

    public static class Format extends Token {

        private String getFormatEnd(char c) {
            c;
            JVM INSTR lookupswitch 4: default 44
        //                       34: 93
        //                       42: 76
        //                       94: 87
        //                       95: 81;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            throw new AssertionError((new StringBuilder()).append("unknown format '").append(c).append("'").toString());
_L3:
            String s = "</b>";
_L7:
            return s;
_L5:
            s = "</i>";
            continue; /* Loop/switch isn't completed */
_L4:
            s = "</font></b>";
            continue; /* Loop/switch isn't completed */
_L2:
            s = "\u201D</font>";
            if(true) goto _L7; else goto _L6
_L6:
        }

        private String getFormatStart(char c) {
            c;
            JVM INSTR lookupswitch 4: default 44
        //                       34: 93
        //                       42: 76
        //                       94: 87
        //                       95: 81;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            throw new AssertionError((new StringBuilder()).append("unknown format '").append(c).append("'").toString());
_L3:
            String s = "<b>";
_L7:
            return s;
_L5:
            s = "<i>";
            continue; /* Loop/switch isn't completed */
_L4:
            s = "<b><font color=\"#005FFF\">";
            continue; /* Loop/switch isn't completed */
_L2:
            s = "<font color=\"#999999\">\u201C";
            if(true) goto _L7; else goto _L6
_L6:
        }

        public boolean controlCaps() {
            boolean flag;
            if(ch == '^')
                flag = true;
            else
                flag = false;
            return flag;
        }

        public List getInfo() {
            throw new UnsupportedOperationException();
        }

        public boolean isHtml() {
            return true;
        }

        public boolean setCaps() {
            return start;
        }

        public void setMatched(boolean flag) {
            matched = flag;
        }

        public String toHtml(boolean flag) {
            String s;
            if(matched) {
                if(start)
                    s = getFormatStart(ch);
                else
                    s = getFormatEnd(ch);
            } else
            if(ch == '"')
                s = "&quot;";
            else
                s = String.valueOf(ch);
            return s;
        }

        private char ch;
        private boolean matched;
        private boolean start;

        public Format(char c, boolean flag) {
            class Token.Type extends Enum {

                public static Token.Type valueOf(String s) {
                    return (Token.Type)Enum.valueOf(com/google/android/util/AbstractMessageParser$Token$Type, s);
                }

                public static Token.Type[] values() {
                    return (Token.Type[])$VALUES.clone();
                }

                public String toString() {
                    return stringRep;
                }

                private static final Token.Type $VALUES[];
                public static final Token.Type ACRONYM;
                public static final Token.Type FLICKR;
                public static final Token.Type FORMAT;
                public static final Token.Type GOOGLE_VIDEO;
                public static final Token.Type HTML;
                public static final Token.Type LINK;
                public static final Token.Type MUSIC;
                public static final Token.Type PHOTO;
                public static final Token.Type SMILEY;
                public static final Token.Type YOUTUBE_VIDEO;
                private String stringRep;

                static  {
                    HTML = new Token.Type("HTML", 0, "html");
                    FORMAT = new Token.Type("FORMAT", 1, "format");
                    LINK = new Token.Type("LINK", 2, "l");
                    SMILEY = new Token.Type("SMILEY", 3, "e");
                    ACRONYM = new Token.Type("ACRONYM", 4, "a");
                    MUSIC = new Token.Type("MUSIC", 5, "m");
                    GOOGLE_VIDEO = new Token.Type("GOOGLE_VIDEO", 6, "v");
                    YOUTUBE_VIDEO = new Token.Type("YOUTUBE_VIDEO", 7, "yt");
                    PHOTO = new Token.Type("PHOTO", 8, "p");
                    FLICKR = new Token.Type("FLICKR", 9, "f");
                    Token.Type atype[] = new Token.Type[10];
                    atype[0] = HTML;
                    atype[1] = FORMAT;
                    atype[2] = LINK;
                    atype[3] = SMILEY;
                    atype[4] = ACRONYM;
                    atype[5] = MUSIC;
                    atype[6] = GOOGLE_VIDEO;
                    atype[7] = YOUTUBE_VIDEO;
                    atype[8] = PHOTO;
                    atype[9] = FLICKR;
                    $VALUES = atype;
                }

                private Token.Type(String s, int i, String s1) {
                    super(s, i);
                    stringRep = s1;
                }
            }

            super(Token.Type.FORMAT, String.valueOf(c));
            ch = c;
            start = flag;
        }
    }

    public static class Acronym extends Token {

        public List getInfo() {
            List list = super.getInfo();
            list.add(getRawText());
            list.add(getValue());
            return list;
        }

        public String getValue() {
            return value;
        }

        public boolean isHtml() {
            return false;
        }

        private String value;

        public Acronym(String s, String s1) {
            super(Token.Type.ACRONYM, s);
            value = s1;
        }
    }

    public static class Smiley extends Token {

        public List getInfo() {
            List list = super.getInfo();
            list.add(getRawText());
            return list;
        }

        public boolean isHtml() {
            return false;
        }

        public Smiley(String s) {
            super(Token.Type.SMILEY, s);
        }
    }

    public static class FlickrPhoto extends Token {

        public static String getPhotoURL(String s, String s1) {
            return (new StringBuilder()).append("http://flickr.com/photos/").append(s).append("/").append(s1).toString();
        }

        public static String getRssUrl(String s) {
            return null;
        }

        public static String getTagsURL(String s) {
            return (new StringBuilder()).append("http://flickr.com/photos/tags/").append(s).toString();
        }

        public static String getUserSetsURL(String s, String s1) {
            return (new StringBuilder()).append("http://flickr.com/photos/").append(s).append("/sets/").append(s1).toString();
        }

        public static String getUserTagsURL(String s, String s1) {
            return (new StringBuilder()).append("http://flickr.com/photos/").append(s).append("/tags/").append(s1).toString();
        }

        public static String getUserURL(String s) {
            return (new StringBuilder()).append("http://flickr.com/photos/").append(s).toString();
        }

        public static FlickrPhoto matchURL(String s, String s1) {
            Matcher matcher = GROUPING_PATTERN.matcher(s);
            FlickrPhoto flickrphoto;
            if(matcher.matches()) {
                flickrphoto = new FlickrPhoto(matcher.group(1), null, matcher.group(2), matcher.group(3), s1);
            } else {
                Matcher matcher1 = URL_PATTERN.matcher(s);
                if(matcher1.matches())
                    flickrphoto = new FlickrPhoto(matcher1.group(1), matcher1.group(2), null, null, s1);
                else
                    flickrphoto = null;
            }
            return flickrphoto;
        }

        public String getGrouping() {
            return grouping;
        }

        public String getGroupingId() {
            return groupingId;
        }

        public List getInfo() {
            List list = super.getInfo();
            list.add(getUrl());
            String s;
            String s1;
            String s2;
            String s3;
            if(getUser() != null)
                s = getUser();
            else
                s = "";
            list.add(s);
            if(getPhoto() != null)
                s1 = getPhoto();
            else
                s1 = "";
            list.add(s1);
            if(getGrouping() != null)
                s2 = getGrouping();
            else
                s2 = "";
            list.add(s2);
            if(getGroupingId() != null)
                s3 = getGroupingId();
            else
                s3 = "";
            list.add(s3);
            return list;
        }

        public String getPhoto() {
            return photo;
        }

        public String getUrl() {
            String s;
            if("sets".equals(grouping))
                s = getUserSetsURL(user, groupingId);
            else
            if("tags".equals(grouping)) {
                if(user != null)
                    s = getUserTagsURL(user, groupingId);
                else
                    s = getTagsURL(groupingId);
            } else
            if(photo != null)
                s = getPhotoURL(user, photo);
            else
                s = getUserURL(user);
            return s;
        }

        public String getUser() {
            return user;
        }

        public boolean isHtml() {
            return false;
        }

        public boolean isMedia() {
            return true;
        }

        private static final Pattern GROUPING_PATTERN = Pattern.compile("http://(?:www.)?flickr.com/photos/([^/?#&]+)/(tags|sets)/([^/?#&]+)/?");
        private static final String SETS = "sets";
        private static final String TAGS = "tags";
        private static final Pattern URL_PATTERN = Pattern.compile("http://(?:www.)?flickr.com/photos/([^/?#&]+)/?([^/?#&]+)?/?.*");
        private String grouping;
        private String groupingId;
        private String photo;
        private String user;


        public FlickrPhoto(String s, String s1, String s2, String s3, String s4) {
            super(Token.Type.FLICKR, s4);
            if(!"tags".equals(s)) {
                user = s;
                if("show".equals(s1))
                    s1 = null;
                photo = s1;
                grouping = s2;
                groupingId = s3;
            } else {
                user = null;
                photo = null;
                grouping = "tags";
                groupingId = s1;
            }
        }
    }

    public static class Photo extends Token {

        public static String getAlbumURL(String s, String s1) {
            return (new StringBuilder()).append("http://picasaweb.google.com/").append(s).append("/").append(s1).toString();
        }

        public static String getPhotoURL(String s, String s1, String s2) {
            return (new StringBuilder()).append("http://picasaweb.google.com/").append(s).append("/").append(s1).append("/photo#").append(s2).toString();
        }

        public static String getRssUrl(String s) {
            return (new StringBuilder()).append("http://picasaweb.google.com/data/feed/api/user/").append(s).append("?category=album&alt=rss").toString();
        }

        public static Photo matchURL(String s, String s1) {
            Matcher matcher = URL_PATTERN.matcher(s);
            Photo photo1;
            if(matcher.matches())
                photo1 = new Photo(matcher.group(1), matcher.group(2), matcher.group(3), s1);
            else
                photo1 = null;
            return photo1;
        }

        public String getAlbum() {
            return album;
        }

        public List getInfo() {
            List list = super.getInfo();
            list.add(getRssUrl(getUser()));
            list.add(getAlbumURL(getUser(), getAlbum()));
            if(getPhoto() != null)
                list.add(getPhotoURL(getUser(), getAlbum(), getPhoto()));
            else
                list.add((String)null);
            return list;
        }

        public String getPhoto() {
            return photo;
        }

        public String getUser() {
            return user;
        }

        public boolean isHtml() {
            return false;
        }

        public boolean isMedia() {
            return true;
        }

        private static final Pattern URL_PATTERN = Pattern.compile("http://picasaweb.google.com/([^/?#&]+)/+((?!searchbrowse)[^/?#&]+)(?:/|/photo)?(?:\\?[^#]*)?(?:#(.*))?");
        private String album;
        private String photo;
        private String user;


        public Photo(String s, String s1, String s2, String s3) {
            super(Token.Type.PHOTO, s3);
            user = s;
            album = s1;
            photo = s2;
        }
    }

    public static class YouTubeVideo extends Token {

        public static String getPrefixedURL(boolean flag, String s, String s1, String s2) {
            String s3;
            s3 = "";
            if(flag)
                s3 = "http://";
            if(s == null)
                s = "";
            if(s2 != null) goto _L2; else goto _L1
_L1:
            s2 = "";
_L4:
            return (new StringBuilder()).append(s3).append(s).append("youtube.com/watch?").append(s2).append("v=").append(s1).toString();
_L2:
            if(s2.length() > 0)
                s2 = (new StringBuilder()).append(s2).append("&").toString();
            if(true) goto _L4; else goto _L3
_L3:
        }

        public static String getRssUrl(String s) {
            return (new StringBuilder()).append("http://youtube.com/watch?v=").append(s).toString();
        }

        public static String getURL(String s) {
            return getURL(s, null);
        }

        public static String getURL(String s, String s1) {
            if(s1 != null) goto _L2; else goto _L1
_L1:
            s1 = "";
_L4:
            return (new StringBuilder()).append("http://youtube.com/watch?").append(s1).append("v=").append(s).toString();
_L2:
            if(s1.length() > 0)
                s1 = (new StringBuilder()).append(s1).append("&").toString();
            if(true) goto _L4; else goto _L3
_L3:
        }

        public static YouTubeVideo matchURL(String s, String s1) {
            Matcher matcher = URL_PATTERN.matcher(s);
            YouTubeVideo youtubevideo;
            if(matcher.matches())
                youtubevideo = new YouTubeVideo(matcher.group(1), s1);
            else
                youtubevideo = null;
            return youtubevideo;
        }

        public String getDocID() {
            return docid;
        }

        public List getInfo() {
            List list = super.getInfo();
            list.add(getRssUrl(docid));
            list.add(getURL(docid));
            return list;
        }

        public boolean isHtml() {
            return false;
        }

        public boolean isMedia() {
            return true;
        }

        private static final Pattern URL_PATTERN = Pattern.compile("(?i)http://(?:[a-z0-9]+\\.)?youtube\\.[a-z0-9]+(?:\\.[a-z0-9]+)?/watch\\?.*\\bv=([-_a-zA-Z0-9=]+).*");
        private String docid;


        public YouTubeVideo(String s, String s1) {
            super(Token.Type.YOUTUBE_VIDEO, s1);
            docid = s;
        }
    }

    public static class Video extends Token {

        public static String getRssUrl(String s) {
            return (new StringBuilder()).append("http://video.google.com/videofeed?type=docid&output=rss&sourceid=gtalk&docid=").append(s).toString();
        }

        public static String getURL(String s) {
            return getURL(s, null);
        }

        public static String getURL(String s, String s1) {
            if(s1 != null) goto _L2; else goto _L1
_L1:
            s1 = "";
_L4:
            return (new StringBuilder()).append("http://video.google.com/videoplay?").append(s1).append("docid=").append(s).toString();
_L2:
            if(s1.length() > 0)
                s1 = (new StringBuilder()).append(s1).append("&").toString();
            if(true) goto _L4; else goto _L3
_L3:
        }

        public static Video matchURL(String s, String s1) {
            Matcher matcher = URL_PATTERN.matcher(s);
            Video video;
            if(matcher.matches())
                video = new Video(matcher.group(1), s1);
            else
                video = null;
            return video;
        }

        public String getDocID() {
            return docid;
        }

        public List getInfo() {
            List list = super.getInfo();
            list.add(getRssUrl(docid));
            list.add(getURL(docid));
            return list;
        }

        public boolean isHtml() {
            return false;
        }

        public boolean isMedia() {
            return true;
        }

        private static final Pattern URL_PATTERN = Pattern.compile("(?i)http://video\\.google\\.[a-z0-9]+(?:\\.[a-z0-9]+)?/videoplay\\?.*?\\bdocid=(-?\\d+).*");
        private String docid;


        public Video(String s, String s1) {
            super(Token.Type.GOOGLE_VIDEO, s1);
            docid = s;
        }
    }

    public static class Link extends Token {

        public List getInfo() {
            List list = super.getInfo();
            list.add(getURL());
            list.add(getRawText());
            return list;
        }

        public String getURL() {
            return url;
        }

        public boolean isHtml() {
            return false;
        }

        private String url;

        public Link(String s, String s1) {
            super(Token.Type.LINK, s1);
            url = s;
        }
    }

    public static class MusicTrack extends Token {

        public List getInfo() {
            List list = super.getInfo();
            list.add(getTrack());
            return list;
        }

        public String getTrack() {
            return track;
        }

        public boolean isHtml() {
            return false;
        }

        private String track;

        public MusicTrack(String s) {
            super(Token.Type.MUSIC, s);
            track = s;
        }
    }

    public static class Html extends Token {

        private static String trimLeadingWhitespace(String s) {
            int i;
            for(i = 0; i < s.length() && Character.isWhitespace(s.charAt(i)); i++);
            return s.substring(i);
        }

        public static String trimTrailingWhitespace(String s) {
            int i;
            for(i = s.length(); i > 0 && Character.isWhitespace(s.charAt(i - 1)); i--);
            return s.substring(0, i);
        }

        public List getInfo() {
            throw new UnsupportedOperationException();
        }

        public boolean isHtml() {
            return true;
        }

        public String toHtml(boolean flag) {
            String s;
            if(flag)
                s = html.toUpperCase();
            else
                s = html;
            return s;
        }

        public void trimLeadingWhitespace() {
            super.text = trimLeadingWhitespace(super.text);
            html = trimLeadingWhitespace(html);
        }

        public void trimTrailingWhitespace() {
            super.text = trimTrailingWhitespace(super.text);
            html = trimTrailingWhitespace(html);
        }

        private String html;

        public Html(String s, String s1) {
            super(Token.Type.HTML, s);
            html = s1;
        }
    }

    public static abstract class Token {

        public boolean controlCaps() {
            return false;
        }

        public List getInfo() {
            ArrayList arraylist = new ArrayList();
            arraylist.add(getType().toString());
            return arraylist;
        }

        public String getRawText() {
            return text;
        }

        public Type getType() {
            return type;
        }

        public boolean isArray() {
            boolean flag;
            if(!isHtml())
                flag = true;
            else
                flag = false;
            return flag;
        }

        public abstract boolean isHtml();

        public boolean isMedia() {
            return false;
        }

        public boolean setCaps() {
            return false;
        }

        public String toHtml(boolean flag) {
            throw new AssertionError("not html");
        }

        protected String text;
        protected Type type;

        protected Token(Type type1, String s) {
            type = type1;
            text = s;
        }
    }

    public static interface Resources {

        public abstract TrieNode getAcronyms();

        public abstract TrieNode getDomainSuffixes();

        public abstract Set getSchemes();

        public abstract TrieNode getSmileys();
    }


    public AbstractMessageParser(String s) {
        this(s, true, true, true, true, true, true);
    }

    public AbstractMessageParser(String s, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5) {
        text = s;
        nextChar = 0;
        nextClass = 10;
        parts = new ArrayList();
        tokens = new ArrayList();
        formatStart = new HashMap();
        parseSmilies = flag;
        parseAcronyms = flag1;
        parseFormatting = flag2;
        parseUrls = flag3;
        parseMusic = flag4;
        parseMeText = flag5;
    }

    private void addToken(Token token) {
        tokens.add(token);
    }

    private void addURLToken(String s, String s1) {
        addToken(tokenForUrl(s, s1));
    }

    private void buildParts(String s) {
        for(int i = 0; i < tokens.size(); i++) {
            Token token = (Token)tokens.get(i);
            if(token.isMedia() || parts.size() == 0 || lastPart().isMedia())
                parts.add(new Part());
            lastPart().add(token);
        }

        if(parts.size() > 0)
            ((Part)parts.get(0)).setMeText(s);
    }

    private int getCharClass(int i) {
        int j;
        if(i < 0 || text.length() <= i) {
            j = 0;
        } else {
            char c = text.charAt(i);
            if(Character.isWhitespace(c))
                j = 1;
            else
            if(Character.isLetter(c))
                j = 2;
            else
            if(Character.isDigit(c))
                j = 3;
            else
            if(isPunctuation(c)) {
                j = 1 + nextClass;
                nextClass = j;
            } else {
                j = 4;
            }
        }
        return j;
    }

    private boolean isDomainChar(char c) {
        boolean flag;
        if(c == '-' || Character.isLetter(c) || Character.isDigit(c))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isFormatChar(char c) {
        c;
        JVM INSTR lookupswitch 3: default 36
    //                   42: 40
    //                   94: 40
    //                   95: 40;
           goto _L1 _L2 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static boolean isPunctuation(char c) {
        c;
        JVM INSTR lookupswitch 9: default 84
    //                   33: 88
    //                   34: 88
    //                   40: 88
    //                   41: 88
    //                   44: 88
    //                   46: 88
    //                   58: 88
    //                   59: 88
    //                   63: 88;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static boolean isSmileyBreak(char c, char c1) {
        c;
        JVM INSTR lookupswitch 17: default 148
    //                   36: 152
    //                   38: 152
    //                   42: 152
    //                   43: 152
    //                   45: 152
    //                   47: 152
    //                   60: 152
    //                   61: 152
    //                   62: 152
    //                   64: 152
    //                   91: 152
    //                   92: 152
    //                   93: 152
    //                   94: 152
    //                   124: 152
    //                   125: 152
    //                   126: 152;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        c1;
        JVM INSTR lookupswitch 13: default 268
    //                   35: 271
    //                   36: 271
    //                   37: 271
    //                   42: 271
    //                   47: 271
    //                   60: 271
    //                   61: 271
    //                   62: 271
    //                   64: 271
    //                   91: 271
    //                   92: 271
    //                   94: 271
    //                   126: 271;
           goto _L1 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3
_L3:
        flag = true;
          goto _L4
    }

    private boolean isSmileyBreak(int i) {
        boolean flag;
        if(i > 0 && i < text.length() && isSmileyBreak(text.charAt(i - 1), text.charAt(i)))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean isURLBreak(int i) {
        getCharClass(i - 1);
        JVM INSTR tableswitch 2 4: default 32
    //                   2 36
    //                   3 36
    //                   4 36;
           goto _L1 _L2 _L2 _L2
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean isValidDomain(String s) {
        boolean flag;
        if(matches(getResources().getDomainSuffixes(), reverse(s)))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean isWordBreak(int i) {
        boolean flag;
        if(getCharClass(i - 1) != getCharClass(i))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private Part lastPart() {
        return (Part)parts.get(-1 + parts.size());
    }

    private static TrieNode longestMatch(TrieNode trienode, AbstractMessageParser abstractmessageparser, int i) {
        return longestMatch(trienode, abstractmessageparser, i, false);
    }

    private static TrieNode longestMatch(TrieNode trienode, AbstractMessageParser abstractmessageparser, int i, boolean flag) {
        int j = i;
        TrieNode trienode1 = null;
        do {
            int k;
label0:
            {
                if(j < abstractmessageparser.getRawText().length()) {
                    String s = abstractmessageparser.getRawText();
                    k = j + 1;
                    trienode = trienode.getChild(s.charAt(j));
                    if(trienode != null)
                        break label0;
                }
                return trienode1;
            }
            if(trienode.exists()) {
                if(abstractmessageparser.isWordBreak(k)) {
                    trienode1 = trienode;
                    j = k;
                    continue;
                }
                if(flag && abstractmessageparser.isSmileyBreak(k)) {
                    trienode1 = trienode;
                    j = k;
                    continue;
                }
            }
            j = k;
        } while(true);
    }

    private static boolean matches(TrieNode trienode, String s) {
        int i = 0;
_L7:
        if(i >= s.length()) goto _L2; else goto _L1
_L1:
        int j;
        j = i + 1;
        trienode = trienode.getChild(s.charAt(i));
        if(trienode != null) goto _L3; else goto _L2
_L2:
        boolean flag = false;
_L5:
        return flag;
_L3:
        if(!trienode.exists())
            break; /* Loop/switch isn't completed */
        flag = true;
        if(true) goto _L5; else goto _L4
_L4:
        i = j;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private boolean parseAcronym() {
        boolean flag = false;
        if(parseAcronyms) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        TrieNode trienode = longestMatch(getResources().getAcronyms(), this, nextChar);
        if(trienode != null) {
            addToken(new Acronym(trienode.getText(), trienode.getValue()));
            nextChar = nextChar + trienode.getText().length();
            flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean parseFormatting() {
        boolean flag = false;
        if(parseFormatting) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i;
        for(i = nextChar; i < text.length() && isFormatChar(text.charAt(i)); i++);
        if(i != nextChar && isWordBreak(i)) {
            LinkedHashMap linkedhashmap = new LinkedHashMap();
            int j = nextChar;
            while(j < i)  {
                char c = text.charAt(j);
                Character character1 = Character.valueOf(c);
                if(linkedhashmap.containsKey(character1)) {
                    addToken(new Format(c, false));
                } else {
                    Format format1 = (Format)formatStart.get(character1);
                    if(format1 != null) {
                        format1.setMatched(true);
                        formatStart.remove(character1);
                        linkedhashmap.put(character1, Boolean.TRUE);
                    } else {
                        Format format2 = new Format(c, true);
                        formatStart.put(character1, format2);
                        addToken(format2);
                        linkedhashmap.put(character1, Boolean.FALSE);
                    }
                }
                j++;
            }
            Iterator iterator = linkedhashmap.keySet().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                Character character = (Character)iterator.next();
                if(linkedhashmap.get(character) == Boolean.TRUE) {
                    Format format = new Format(character.charValue(), false);
                    format.setMatched(true);
                    addToken(format);
                }
            } while(true);
            nextChar = i;
            flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean parseMusicTrack() {
        boolean flag;
        if(parseMusic && text.startsWith("\u266B ")) {
            addToken(new MusicTrack(text.substring("\u266B ".length())));
            nextChar = text.length();
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    private boolean parseSmiley() {
        boolean flag = false;
        if(parseSmilies) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        TrieNode trienode = longestMatch(getResources().getSmileys(), this, nextChar, true);
        if(trienode != null) {
            int i = getCharClass(-1 + nextChar);
            int j = getCharClass(nextChar + trienode.getText().length());
            if(i != 2 && i != 3 || j != 2 && j != 3) {
                addToken(new Smiley(trienode.getText()));
                nextChar = nextChar + trienode.getText().length();
                flag = true;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void parseText() {
        StringBuilder stringbuilder;
        int i;
        stringbuilder = new StringBuilder();
        i = nextChar;
_L9:
        char c;
        String s = text;
        int j = nextChar;
        nextChar = j + 1;
        c = s.charAt(j);
        c;
        JVM INSTR lookupswitch 6: default 100
    //                   10: 201
    //                   34: 179
    //                   38: 168
    //                   39: 190
    //                   60: 146
    //                   62: 157;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        break MISSING_BLOCK_LABEL_201;
_L6:
        break; /* Loop/switch isn't completed */
_L1:
        stringbuilder.append(c);
_L10:
        if(isWordBreak(nextChar)) {
            addToken(new Html(text.substring(i, nextChar), stringbuilder.toString()));
            return;
        }
        if(true) goto _L9; else goto _L8
_L8:
        stringbuilder.append("&lt;");
          goto _L10
_L7:
        stringbuilder.append("&gt;");
          goto _L10
_L4:
        stringbuilder.append("&amp;");
          goto _L10
_L3:
        stringbuilder.append("&quot;");
          goto _L10
_L5:
        stringbuilder.append("&apos;");
          goto _L10
        stringbuilder.append("<br>");
          goto _L10
    }

    private boolean parseURL() {
        boolean flag = false;
        if(parseUrls && isURLBreak(nextChar)) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i;
        int j;
        String s;
        boolean flag1;
        i = nextChar;
        for(j = i; j < text.length() && isDomainChar(text.charAt(j)); j++);
        s = "";
        flag1 = false;
        if(j == text.length())
            continue; /* Loop/switch isn't completed */
        if(text.charAt(j) != ':') goto _L4; else goto _L3
_L3:
        String s2 = text.substring(nextChar, j);
        if(!getResources().getSchemes().contains(s2))
            continue; /* Loop/switch isn't completed */
_L6:
        char c;
        char c1;
        char c2;
        if(!flag1)
            for(; j < text.length() && !Character.isWhitespace(text.charAt(j)); j++);
        String s1 = text.substring(i, j);
        addURLToken((new StringBuilder()).append(s).append(s1).toString(), s1);
        nextChar = j;
        flag = true;
        continue; /* Loop/switch isn't completed */
_L4:
        if(text.charAt(j) != '.')
            continue; /* Loop/switch isn't completed */
label0:
        do {
label1:
            {
                if(j < text.length()) {
                    c2 = text.charAt(j);
                    if(c2 == '.' || isDomainChar(c2))
                        break label1;
                }
                if(!isValidDomain(text.substring(nextChar, j)))
                    continue; /* Loop/switch isn't completed */
                if(j + 1 < text.length() && text.charAt(j) == ':' && Character.isDigit(text.charAt(j + 1)))
                    for(j++; j < text.length() && Character.isDigit(text.charAt(j)); j++);
                break label0;
            }
            j++;
        } while(true);
        if(j != text.length())
            break; /* Loop/switch isn't completed */
        flag1 = true;
_L7:
        s = "http://";
        if(true) goto _L6; else goto _L5
_L5:
        c = text.charAt(j);
        if(c == '?') {
            if(j + 1 == text.length()) {
                flag1 = true;
            } else {
                c1 = text.charAt(j + 1);
                if(Character.isWhitespace(c1) || isPunctuation(c1))
                    flag1 = true;
            }
        } else
        if(isPunctuation(c)) {
            flag1 = true;
        } else {
            if(!Character.isWhitespace(c))
                continue; /* Loop/switch isn't completed */
            flag1 = true;
        }
          goto _L7
          goto _L6
        if(c != '/' && c != '#') goto _L1; else goto _L7
        if(true) goto _L1; else goto _L8
_L8:
    }

    protected static String reverse(String s) {
        StringBuilder stringbuilder = new StringBuilder();
        for(int i = -1 + s.length(); i >= 0; i--)
            stringbuilder.append(s.charAt(i));

        return stringbuilder.toString();
    }

    public static Token tokenForUrl(String s, String s1) {
        if(s != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((Token) (obj));
_L2:
        obj = Video.matchURL(s, s1);
        if(obj == null) {
            YouTubeVideo youtubevideo = YouTubeVideo.matchURL(s, s1);
            if(youtubevideo != null) {
                obj = youtubevideo;
            } else {
                Photo photo = Photo.matchURL(s, s1);
                if(photo != null) {
                    obj = photo;
                } else {
                    FlickrPhoto flickrphoto = FlickrPhoto.matchURL(s, s1);
                    if(flickrphoto != null)
                        obj = flickrphoto;
                    else
                        obj = new Link(s, s1);
                }
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final Part getPart(int i) {
        return (Part)parts.get(i);
    }

    public final int getPartCount() {
        return parts.size();
    }

    public final List getParts() {
        return parts;
    }

    public final String getRawText() {
        return text;
    }

    protected abstract Resources getResources();

    public void parse() {
        if(parseMusicTrack()) {
            buildParts(null);
        } else {
            String s = null;
            if(parseMeText && text.startsWith("/me") && text.length() > 3 && Character.isWhitespace(text.charAt(3))) {
                s = text.substring(0, 4);
                text = text.substring(4);
            }
            boolean flag = false;
            do {
                if(nextChar >= text.length())
                    break;
                if(!isWordBreak(nextChar) && (!flag || !isSmileyBreak(nextChar)))
                    throw new AssertionError("last chunk did not end at word break");
                if(parseSmiley()) {
                    flag = true;
                } else {
                    flag = false;
                    if(!parseAcronym() && !parseURL() && !parseFormatting())
                        parseText();
                }
            } while(true);
            for(int i = 0; i < tokens.size(); i++) {
                if(!((Token)tokens.get(i)).isMedia())
                    continue;
                if(i > 0 && (tokens.get(i - 1) instanceof Html))
                    ((Html)tokens.get(i - 1)).trimLeadingWhitespace();
                if(i + 1 < tokens.size() && (tokens.get(i + 1) instanceof Html))
                    ((Html)tokens.get(i + 1)).trimTrailingWhitespace();
            }

            for(int j = 0; j < tokens.size(); j++)
                if(((Token)tokens.get(j)).isHtml() && ((Token)tokens.get(j)).toHtml(true).length() == 0) {
                    tokens.remove(j);
                    j--;
                }

            buildParts(s);
        }
    }

    public String toHtml() {
        StringBuilder stringbuilder;
        Iterator iterator;
        stringbuilder = new StringBuilder();
        iterator = parts.iterator();
_L6:
        boolean flag;
        Iterator iterator1;
        if(!iterator.hasNext())
            break; /* Loop/switch isn't completed */
        Part part = (Part)iterator.next();
        flag = false;
        stringbuilder.append("<p>");
        iterator1 = part.getTokens().iterator();
_L2:
        Token token;
        if(!iterator1.hasNext())
            break MISSING_BLOCK_LABEL_531;
        token = (Token)iterator1.next();
        if(!token.isHtml())
            break; /* Loop/switch isn't completed */
        stringbuilder.append(token.toHtml(flag));
_L4:
        if(token.controlCaps())
            flag = token.setCaps();
        if(true) goto _L2; else goto _L1
_L1:
        class _cls1 {

            static final int $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[];

            static  {
                $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type = new int[Token.Type.values().length];
                NoSuchFieldError nosuchfielderror7;
                try {
                    $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.LINK.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.SMILEY.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.ACRONYM.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.MUSIC.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                try {
                    $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.GOOGLE_VIDEO.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                try {
                    $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.YOUTUBE_VIDEO.ordinal()] = 6;
                }
                catch(NoSuchFieldError nosuchfielderror5) { }
                try {
                    $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.PHOTO.ordinal()] = 7;
                }
                catch(NoSuchFieldError nosuchfielderror6) { }
                $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.FLICKR.ordinal()] = 8;
_L2:
                return;
                nosuchfielderror7;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        switch(_cls1..SwitchMap.com.google.android.util.AbstractMessageParser.Token.Type[token.getType().ordinal()]) {
        default:
            throw new AssertionError((new StringBuilder()).append("unknown token type: ").append(token.getType()).toString());

        case 1: // '\001'
            stringbuilder.append("<a href=\"");
            stringbuilder.append(((Link)token).getURL());
            stringbuilder.append("\">");
            stringbuilder.append(token.getRawText());
            stringbuilder.append("</a>");
            break;

        case 2: // '\002'
            stringbuilder.append(token.getRawText());
            break;

        case 3: // '\003'
            stringbuilder.append(token.getRawText());
            break;

        case 4: // '\004'
            stringbuilder.append(((MusicTrack)token).getTrack());
            break;

        case 5: // '\005'
            stringbuilder.append("<a href=\"");
            (Video)token;
            stringbuilder.append(Video.getURL(((Video)token).getDocID()));
            stringbuilder.append("\">");
            stringbuilder.append(token.getRawText());
            stringbuilder.append("</a>");
            break;

        case 6: // '\006'
            stringbuilder.append("<a href=\"");
            (YouTubeVideo)token;
            stringbuilder.append(YouTubeVideo.getURL(((YouTubeVideo)token).getDocID()));
            stringbuilder.append("\">");
            stringbuilder.append(token.getRawText());
            stringbuilder.append("</a>");
            break;

        case 7: // '\007'
            stringbuilder.append("<a href=\"");
            stringbuilder.append(Photo.getAlbumURL(((Photo)token).getUser(), ((Photo)token).getAlbum()));
            stringbuilder.append("\">");
            stringbuilder.append(token.getRawText());
            stringbuilder.append("</a>");
            break;

        case 8: // '\b'
            (Photo)token;
            stringbuilder.append("<a href=\"");
            stringbuilder.append(((FlickrPhoto)token).getUrl());
            stringbuilder.append("\">");
            stringbuilder.append(token.getRawText());
            stringbuilder.append("</a>");
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
        stringbuilder.append("</p>\n");
        if(true) goto _L6; else goto _L5
_L5:
        return stringbuilder.toString();
    }

    public static final String musicNote = "\u266B ";
    private HashMap formatStart;
    private int nextChar;
    private int nextClass;
    private boolean parseAcronyms;
    private boolean parseFormatting;
    private boolean parseMeText;
    private boolean parseMusic;
    private boolean parseSmilies;
    private boolean parseUrls;
    private ArrayList parts;
    private String text;
    private ArrayList tokens;
}
