// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms;

import java.util.ArrayList;

public class ContentType {

    private ContentType() {
    }

    public static ArrayList getAudioTypes() {
        return (ArrayList)sSupportedAudioTypes.clone();
    }

    public static ArrayList getImageTypes() {
        return (ArrayList)sSupportedImageTypes.clone();
    }

    public static ArrayList getSupportedTypes() {
        return (ArrayList)sSupportedContentTypes.clone();
    }

    public static ArrayList getVideoTypes() {
        return (ArrayList)sSupportedVideoTypes.clone();
    }

    public static boolean isAudioType(String s) {
        boolean flag;
        if(s != null && s.startsWith("audio/"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isDrmType(String s) {
        boolean flag;
        if(s != null && (s.equals("application/vnd.oma.drm.content") || s.equals("application/vnd.oma.drm.message")))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isImageType(String s) {
        boolean flag;
        if(s != null && s.startsWith("image/"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isSupportedAudioType(String s) {
        boolean flag;
        if(isAudioType(s) && isSupportedType(s))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isSupportedImageType(String s) {
        boolean flag;
        if(isImageType(s) && isSupportedType(s))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isSupportedType(String s) {
        boolean flag;
        if(s != null && sSupportedContentTypes.contains(s))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isSupportedVideoType(String s) {
        boolean flag;
        if(isVideoType(s) && isSupportedType(s))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isTextType(String s) {
        boolean flag;
        if(s != null && s.startsWith("text/"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isUnspecified(String s) {
        boolean flag;
        if(s != null && s.endsWith("*"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isVideoType(String s) {
        boolean flag;
        if(s != null && s.startsWith("video/"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final String APP_DRM_CONTENT = "application/vnd.oma.drm.content";
    public static final String APP_DRM_MESSAGE = "application/vnd.oma.drm.message";
    public static final String APP_SMIL = "application/smil";
    public static final String APP_WAP_XHTML = "application/vnd.wap.xhtml+xml";
    public static final String APP_XHTML = "application/xhtml+xml";
    public static final String AUDIO_3GPP = "audio/3gpp";
    public static final String AUDIO_AAC = "audio/aac";
    public static final String AUDIO_AMR = "audio/amr";
    public static final String AUDIO_IMELODY = "audio/imelody";
    public static final String AUDIO_MID = "audio/mid";
    public static final String AUDIO_MIDI = "audio/midi";
    public static final String AUDIO_MP3 = "audio/mp3";
    public static final String AUDIO_MP4 = "audio/mp4";
    public static final String AUDIO_MPEG = "audio/mpeg";
    public static final String AUDIO_MPEG3 = "audio/mpeg3";
    public static final String AUDIO_MPG = "audio/mpg";
    public static final String AUDIO_OGG = "application/ogg";
    public static final String AUDIO_UNSPECIFIED = "audio/*";
    public static final String AUDIO_X_MID = "audio/x-mid";
    public static final String AUDIO_X_MIDI = "audio/x-midi";
    public static final String AUDIO_X_MP3 = "audio/x-mp3";
    public static final String AUDIO_X_MPEG = "audio/x-mpeg";
    public static final String AUDIO_X_MPEG3 = "audio/x-mpeg3";
    public static final String AUDIO_X_MPG = "audio/x-mpg";
    public static final String AUDIO_X_WAV = "audio/x-wav";
    public static final String IMAGE_GIF = "image/gif";
    public static final String IMAGE_JPEG = "image/jpeg";
    public static final String IMAGE_JPG = "image/jpg";
    public static final String IMAGE_PNG = "image/png";
    public static final String IMAGE_UNSPECIFIED = "image/*";
    public static final String IMAGE_WBMP = "image/vnd.wap.wbmp";
    public static final String IMAGE_X_MS_BMP = "image/x-ms-bmp";
    public static final String MMS_GENERIC = "application/vnd.wap.mms-generic";
    public static final String MMS_MESSAGE = "application/vnd.wap.mms-message";
    public static final String MULTIPART_ALTERNATIVE = "application/vnd.wap.multipart.alternative";
    public static final String MULTIPART_MIXED = "application/vnd.wap.multipart.mixed";
    public static final String MULTIPART_RELATED = "application/vnd.wap.multipart.related";
    public static final String TEXT_HTML = "text/html";
    public static final String TEXT_PLAIN = "text/plain";
    public static final String TEXT_VCALENDAR = "text/x-vCalendar";
    public static final String TEXT_VCARD = "text/x-vCard";
    public static final String VIDEO_3G2 = "video/3gpp2";
    public static final String VIDEO_3GPP = "video/3gpp";
    public static final String VIDEO_H263 = "video/h263";
    public static final String VIDEO_MP4 = "video/mp4";
    public static final String VIDEO_UNSPECIFIED = "video/*";
    private static final ArrayList sSupportedAudioTypes;
    private static final ArrayList sSupportedContentTypes;
    private static final ArrayList sSupportedImageTypes;
    private static final ArrayList sSupportedVideoTypes;

    static  {
        sSupportedContentTypes = new ArrayList();
        sSupportedImageTypes = new ArrayList();
        sSupportedAudioTypes = new ArrayList();
        sSupportedVideoTypes = new ArrayList();
        sSupportedContentTypes.add("text/plain");
        sSupportedContentTypes.add("text/html");
        sSupportedContentTypes.add("text/x-vCalendar");
        sSupportedContentTypes.add("text/x-vCard");
        sSupportedContentTypes.add("image/jpeg");
        sSupportedContentTypes.add("image/gif");
        sSupportedContentTypes.add("image/vnd.wap.wbmp");
        sSupportedContentTypes.add("image/png");
        sSupportedContentTypes.add("image/jpg");
        sSupportedContentTypes.add("image/x-ms-bmp");
        sSupportedContentTypes.add("audio/aac");
        sSupportedContentTypes.add("audio/amr");
        sSupportedContentTypes.add("audio/imelody");
        sSupportedContentTypes.add("audio/mid");
        sSupportedContentTypes.add("audio/midi");
        sSupportedContentTypes.add("audio/mp3");
        sSupportedContentTypes.add("audio/mpeg3");
        sSupportedContentTypes.add("audio/mpeg");
        sSupportedContentTypes.add("audio/mpg");
        sSupportedContentTypes.add("audio/x-mid");
        sSupportedContentTypes.add("audio/x-midi");
        sSupportedContentTypes.add("audio/x-mp3");
        sSupportedContentTypes.add("audio/x-mpeg3");
        sSupportedContentTypes.add("audio/x-mpeg");
        sSupportedContentTypes.add("audio/x-mpg");
        sSupportedContentTypes.add("audio/x-wav");
        sSupportedContentTypes.add("audio/3gpp");
        sSupportedContentTypes.add("application/ogg");
        sSupportedContentTypes.add("video/3gpp");
        sSupportedContentTypes.add("video/3gpp2");
        sSupportedContentTypes.add("video/h263");
        sSupportedContentTypes.add("video/mp4");
        sSupportedContentTypes.add("application/smil");
        sSupportedContentTypes.add("application/vnd.wap.xhtml+xml");
        sSupportedContentTypes.add("application/xhtml+xml");
        sSupportedContentTypes.add("application/vnd.oma.drm.content");
        sSupportedContentTypes.add("application/vnd.oma.drm.message");
        sSupportedImageTypes.add("image/jpeg");
        sSupportedImageTypes.add("image/gif");
        sSupportedImageTypes.add("image/vnd.wap.wbmp");
        sSupportedImageTypes.add("image/png");
        sSupportedImageTypes.add("image/jpg");
        sSupportedImageTypes.add("image/x-ms-bmp");
        sSupportedAudioTypes.add("audio/aac");
        sSupportedAudioTypes.add("audio/amr");
        sSupportedAudioTypes.add("audio/imelody");
        sSupportedAudioTypes.add("audio/mid");
        sSupportedAudioTypes.add("audio/midi");
        sSupportedAudioTypes.add("audio/mp3");
        sSupportedAudioTypes.add("audio/mpeg3");
        sSupportedAudioTypes.add("audio/mpeg");
        sSupportedAudioTypes.add("audio/mpg");
        sSupportedAudioTypes.add("audio/mp4");
        sSupportedAudioTypes.add("audio/x-mid");
        sSupportedAudioTypes.add("audio/x-midi");
        sSupportedAudioTypes.add("audio/x-mp3");
        sSupportedAudioTypes.add("audio/x-mpeg3");
        sSupportedAudioTypes.add("audio/x-mpeg");
        sSupportedAudioTypes.add("audio/x-mpg");
        sSupportedAudioTypes.add("audio/x-wav");
        sSupportedAudioTypes.add("audio/3gpp");
        sSupportedAudioTypes.add("application/ogg");
        sSupportedVideoTypes.add("video/3gpp");
        sSupportedVideoTypes.add("video/3gpp2");
        sSupportedVideoTypes.add("video/h263");
        sSupportedVideoTypes.add("video/mp4");
    }
}
