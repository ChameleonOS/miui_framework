// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import java.util.HashMap;
import java.util.List;

// Referenced classes of package android.media:
//            DecoderCapabilities

public class MediaFile {
    public static class MediaFileType {

        public final int fileType;
        public final String mimeType;

        MediaFileType(int i, String s) {
            fileType = i;
            mimeType = s;
        }
    }

    static class Injector {

        static void addAPE() {
            MediaFile.addFileType("APE", 1001, "audio/x-monkeys-audio");
        }

        static boolean isFFMpegAudoFileType(int i) {
            boolean flag;
            if(i >= 1001 && i <= 1001)
                flag = true;
            else
                flag = false;
            return flag;
        }

        static boolean isWMAEnabled() {
            return true;
        }

        Injector() {
        }
    }


    public MediaFile() {
    }

    static void addFileType(String s, int i, String s1) {
        sFileTypeMap.put(s, new MediaFileType(i, s1));
        sMimeTypeMap.put(s1, Integer.valueOf(i));
    }

    static void addFileType(String s, int i, String s1, int j) {
        addFileType(s, i, s1);
        sFileTypeToFormatMap.put(s, Integer.valueOf(j));
        sMimeTypeToFormatMap.put(s1, Integer.valueOf(j));
        sFormatToMimeTypeMap.put(Integer.valueOf(j), s1);
    }

    public static String getFileTitle(String s) {
        int i = s.lastIndexOf('/');
        if(i >= 0) {
            int k = i + 1;
            if(k < s.length())
                s = s.substring(k);
        }
        int j = s.lastIndexOf('.');
        if(j > 0)
            s = s.substring(0, j);
        return s;
    }

    public static MediaFileType getFileType(String s) {
        int i = s.lastIndexOf(".");
        MediaFileType mediafiletype;
        if(i < 0)
            mediafiletype = null;
        else
            mediafiletype = (MediaFileType)sFileTypeMap.get(s.substring(i + 1).toUpperCase());
        return mediafiletype;
    }

    public static int getFileTypeForMimeType(String s) {
        Integer integer = (Integer)sMimeTypeMap.get(s);
        int i;
        if(integer == null)
            i = 0;
        else
            i = integer.intValue();
        return i;
    }

    public static int getFormatCode(String s, String s1) {
        if(s1 == null) goto _L2; else goto _L1
_L1:
        Integer integer1 = (Integer)sMimeTypeToFormatMap.get(s1);
        if(integer1 == null) goto _L2; else goto _L3
_L3:
        int j = integer1.intValue();
_L5:
        return j;
_L2:
        int i = s.lastIndexOf('.');
        if(i > 0) {
            String s2 = s.substring(i + 1);
            Integer integer = (Integer)sFileTypeToFormatMap.get(s2);
            if(integer != null) {
                j = integer.intValue();
                continue; /* Loop/switch isn't completed */
            }
        }
        j = 12288;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public static String getMimeTypeForFile(String s) {
        MediaFileType mediafiletype = getFileType(s);
        String s1;
        if(mediafiletype == null)
            s1 = null;
        else
            s1 = mediafiletype.mimeType;
        return s1;
    }

    public static String getMimeTypeForFormatCode(int i) {
        return (String)sFormatToMimeTypeMap.get(Integer.valueOf(i));
    }

    public static boolean isAudioFileType(int i) {
        boolean flag = true;
        if((i < flag || i > 10) && (i < 11 || i > 13) && !Injector.isFFMpegAudoFileType(i))
            flag = false;
        return flag;
    }

    public static boolean isDrmFileType(int i) {
        boolean flag;
        if(i >= 51 && i <= 51)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isImageFileType(int i) {
        boolean flag;
        if(i >= 31 && i <= 36)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isMimeTypeMedia(String s) {
        int i = getFileTypeForMimeType(s);
        boolean flag;
        if(isAudioFileType(i) || isVideoFileType(i) || isImageFileType(i) || isPlayListFileType(i))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isPlayListFileType(int i) {
        boolean flag;
        if(i >= 41 && i <= 44)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isVideoFileType(int i) {
        boolean flag;
        if(i >= 21 && i <= 30 || i >= 200 && i <= 200)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isWMAEnabled() {
        List list;
        int i;
        int j;
        list = DecoderCapabilities.getAudioDecoders();
        i = list.size();
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_44;
        if((DecoderCapabilities.AudioDecoder)list.get(j) != DecoderCapabilities.AudioDecoder.AUDIO_DECODER_WMA) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        j++;
          goto _L3
        flag = false;
          goto _L4
    }

    private static boolean isWMVEnabled() {
        List list;
        int i;
        int j;
        list = DecoderCapabilities.getVideoDecoders();
        i = list.size();
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_44;
        if((DecoderCapabilities.VideoDecoder)list.get(j) != DecoderCapabilities.VideoDecoder.VIDEO_DECODER_WMV) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        j++;
          goto _L3
        flag = false;
          goto _L4
    }

    public static final int FILE_TYPE_3GPP = 23;
    public static final int FILE_TYPE_3GPP2 = 24;
    public static final int FILE_TYPE_AAC = 8;
    public static final int FILE_TYPE_AMR = 4;
    public static final int FILE_TYPE_APE = 1001;
    public static final int FILE_TYPE_ASF = 26;
    public static final int FILE_TYPE_AVI = 29;
    public static final int FILE_TYPE_AWB = 5;
    public static final int FILE_TYPE_BMP = 34;
    public static final int FILE_TYPE_FL = 51;
    public static final int FILE_TYPE_FLAC = 10;
    public static final int FILE_TYPE_GIF = 32;
    public static final int FILE_TYPE_HTML = 101;
    public static final int FILE_TYPE_HTTPLIVE = 44;
    public static final int FILE_TYPE_IMY = 13;
    public static final int FILE_TYPE_JPEG = 31;
    public static final int FILE_TYPE_M3U = 41;
    public static final int FILE_TYPE_M4A = 2;
    public static final int FILE_TYPE_M4V = 22;
    public static final int FILE_TYPE_MID = 11;
    public static final int FILE_TYPE_MKA = 9;
    public static final int FILE_TYPE_MKV = 27;
    public static final int FILE_TYPE_MP2PS = 200;
    public static final int FILE_TYPE_MP2TS = 28;
    public static final int FILE_TYPE_MP3 = 1;
    public static final int FILE_TYPE_MP4 = 21;
    public static final int FILE_TYPE_MS_EXCEL = 105;
    public static final int FILE_TYPE_MS_POWERPOINT = 106;
    public static final int FILE_TYPE_MS_WORD = 104;
    public static final int FILE_TYPE_OGG = 7;
    public static final int FILE_TYPE_PDF = 102;
    public static final int FILE_TYPE_PLS = 42;
    public static final int FILE_TYPE_PNG = 33;
    public static final int FILE_TYPE_SMF = 12;
    public static final int FILE_TYPE_TEXT = 100;
    public static final int FILE_TYPE_WAV = 3;
    public static final int FILE_TYPE_WBMP = 35;
    public static final int FILE_TYPE_WEBM = 30;
    public static final int FILE_TYPE_WEBP = 36;
    public static final int FILE_TYPE_WMA = 6;
    public static final int FILE_TYPE_WMV = 25;
    public static final int FILE_TYPE_WPL = 43;
    public static final int FILE_TYPE_XML = 103;
    public static final int FILE_TYPE_ZIP = 107;
    private static final int FIRST_AUDIO_FILE_TYPE = 1;
    private static final int FIRST_DRM_FILE_TYPE = 51;
    private static final int FIRST_FFMPEG_AUDIO_FILE_TYPE = 1001;
    private static final int FIRST_IMAGE_FILE_TYPE = 31;
    private static final int FIRST_MIDI_FILE_TYPE = 11;
    private static final int FIRST_PLAYLIST_FILE_TYPE = 41;
    private static final int FIRST_VIDEO_FILE_TYPE = 21;
    private static final int FIRST_VIDEO_FILE_TYPE2 = 200;
    private static final int LAST_AUDIO_FILE_TYPE = 10;
    private static final int LAST_DRM_FILE_TYPE = 51;
    private static final int LAST_FFMPEG_AUDIO_FILE_TYPE = 1001;
    private static final int LAST_IMAGE_FILE_TYPE = 36;
    private static final int LAST_MIDI_FILE_TYPE = 13;
    private static final int LAST_PLAYLIST_FILE_TYPE = 44;
    private static final int LAST_VIDEO_FILE_TYPE = 30;
    private static final int LAST_VIDEO_FILE_TYPE2 = 200;
    private static final HashMap sFileTypeMap = new HashMap();
    private static final HashMap sFileTypeToFormatMap = new HashMap();
    private static final HashMap sFormatToMimeTypeMap = new HashMap();
    private static final HashMap sMimeTypeMap = new HashMap();
    private static final HashMap sMimeTypeToFormatMap = new HashMap();

    static  {
        addFileType("MP3", 1, "audio/mpeg", 12297);
        addFileType("M4A", 2, "audio/mp4", 12299);
        addFileType("WAV", 3, "audio/x-wav", 12296);
        addFileType("AMR", 4, "audio/amr");
        addFileType("AWB", 5, "audio/amr-wb");
        if(Injector.isWMAEnabled())
            addFileType("WMA", 6, "audio/x-ms-wma", 47361);
        addFileType("OGG", 7, "audio/ogg", 47362);
        addFileType("OGG", 7, "application/ogg", 47362);
        addFileType("OGA", 7, "application/ogg", 47362);
        addFileType("AAC", 8, "audio/aac", 47363);
        addFileType("AAC", 8, "audio/aac-adts", 47363);
        addFileType("MKA", 9, "audio/x-matroska");
        addFileType("MID", 11, "audio/midi");
        addFileType("MIDI", 11, "audio/midi");
        addFileType("XMF", 11, "audio/midi");
        addFileType("RTTTL", 11, "audio/midi");
        addFileType("SMF", 12, "audio/sp-midi");
        addFileType("IMY", 13, "audio/imelody");
        addFileType("RTX", 11, "audio/midi");
        addFileType("OTA", 11, "audio/midi");
        addFileType("MXMF", 11, "audio/midi");
        Injector.addAPE();
        addFileType("MPEG", 21, "video/mpeg", 12299);
        addFileType("MPG", 21, "video/mpeg", 12299);
        addFileType("MP4", 21, "video/mp4", 12299);
        addFileType("M4V", 22, "video/mp4", 12299);
        addFileType("3GP", 23, "video/3gpp", 47492);
        addFileType("3GPP", 23, "video/3gpp", 47492);
        addFileType("3G2", 24, "video/3gpp2", 47492);
        addFileType("3GPP2", 24, "video/3gpp2", 47492);
        addFileType("MKV", 27, "video/x-matroska");
        addFileType("WEBM", 30, "video/webm");
        addFileType("TS", 28, "video/mp2ts");
        addFileType("AVI", 29, "video/avi");
        if(isWMVEnabled()) {
            addFileType("WMV", 25, "video/x-ms-wmv", 47489);
            addFileType("ASF", 26, "video/x-ms-asf");
        }
        addFileType("JPG", 31, "image/jpeg", 14337);
        addFileType("JPEG", 31, "image/jpeg", 14337);
        addFileType("GIF", 32, "image/gif", 14343);
        addFileType("PNG", 33, "image/png", 14347);
        addFileType("BMP", 34, "image/x-ms-bmp", 14340);
        addFileType("WBMP", 35, "image/vnd.wap.wbmp");
        addFileType("WEBP", 36, "image/webp");
        addFileType("M3U", 41, "audio/x-mpegurl", 47633);
        addFileType("M3U", 41, "application/x-mpegurl", 47633);
        addFileType("PLS", 42, "audio/x-scpls", 47636);
        addFileType("WPL", 43, "application/vnd.ms-wpl", 47632);
        addFileType("M3U8", 44, "application/vnd.apple.mpegurl");
        addFileType("M3U8", 44, "audio/mpegurl");
        addFileType("M3U8", 44, "audio/x-mpegurl");
        addFileType("FL", 51, "application/x-android-drm-fl");
        addFileType("TXT", 100, "text/plain", 12292);
        addFileType("HTM", 101, "text/html", 12293);
        addFileType("HTML", 101, "text/html", 12293);
        addFileType("PDF", 102, "application/pdf");
        addFileType("DOC", 104, "application/msword", 47747);
        addFileType("XLS", 105, "application/vnd.ms-excel", 47749);
        addFileType("PPT", 106, "application/mspowerpoint", 47750);
        addFileType("FLAC", 10, "audio/flac", 47366);
        addFileType("ZIP", 107, "application/zip");
        addFileType("MPG", 200, "video/mp2p");
        addFileType("MPEG", 200, "video/mp2p");
    }
}
