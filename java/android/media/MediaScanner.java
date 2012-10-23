// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.content.*;
import android.database.Cursor;
import android.database.SQLException;
import android.drm.DrmManagerClient;
import android.graphics.BitmapFactory;
import android.mtp.MtpConstants;
import android.net.Uri;
import android.os.*;
import android.sax.*;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.*;
import java.util.*;
import libcore.io.*;
import org.xml.sax.*;

// Referenced classes of package android.media:
//            MediaFile, MediaInserter, MediaScannerClient, ExifInterface

public class MediaScanner {
    class WplHandler
        implements ElementListener {

        public void end() {
        }

        ContentHandler getContentHandler() {
            return handler;
        }

        public void start(Attributes attributes) {
            String s = attributes.getValue("", "src");
            if(s != null)
                cachePlaylistEntry(s, playListDirectory);
        }

        final ContentHandler handler;
        String playListDirectory;
        final MediaScanner this$0;

        public WplHandler(String s, Uri uri, Cursor cursor) {
            this$0 = MediaScanner.this;
            super();
            playListDirectory = s;
            RootElement rootelement = new RootElement("smil");
            rootelement.getChild("body").getChild("seq").getChild("media").setElementListener(this);
            handler = rootelement.getContentHandler();
        }
    }

    static class MediaBulkDeleter {

        public void delete(long l) throws RemoteException {
            if(whereClause.length() != 0)
                whereClause.append(",");
            whereClause.append("?");
            whereArgs.add((new StringBuilder()).append("").append(l).toString());
            if(whereArgs.size() > 100)
                flush();
        }

        public void flush() throws RemoteException {
            int i = whereArgs.size();
            if(i > 0) {
                String as[] = new String[i];
                String as1[] = (String[])whereArgs.toArray(as);
                mProvider.delete(mBaseUri, (new StringBuilder()).append("_id IN (").append(whereClause.toString()).append(")").toString(), as1);
                whereClause.setLength(0);
                whereArgs.clear();
            }
        }

        Uri mBaseUri;
        IContentProvider mProvider;
        ArrayList whereArgs;
        StringBuilder whereClause;

        public MediaBulkDeleter(IContentProvider icontentprovider, Uri uri) {
            whereClause = new StringBuilder();
            whereArgs = new ArrayList(100);
            mProvider = icontentprovider;
            mBaseUri = uri;
        }
    }

    private class MyMediaScannerClient
        implements MediaScannerClient {

        private boolean convertGenreCode(String s, String s1) {
            String s2 = getGenreName(s);
            boolean flag;
            if(s2.equals(s1)) {
                flag = true;
            } else {
                Log.d("MediaScanner", (new StringBuilder()).append("'").append(s).append("' -> '").append(s2).append("', expected '").append(s1).append("'").toString());
                flag = false;
            }
            return flag;
        }

        private boolean doesPathHaveFilename(String s, String s1) {
            boolean flag = false;
            int i = 1 + s.lastIndexOf(File.separatorChar);
            int j = s1.length();
            if(s.regionMatches(i, s1, 0, j) && i + j == s.length())
                flag = true;
            return flag;
        }

        private Uri endFile(FileEntry fileentry, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4) throws RemoteException {
            ContentValues contentvalues;
            if(mArtist == null || mArtist.length() == 0)
                mArtist = mAlbumArtist;
            contentvalues = toValues();
            String s = contentvalues.getAsString("title");
            if(s == null || TextUtils.isEmpty(s.trim()))
                contentvalues.put("title", MediaFile.getFileTitle(contentvalues.getAsString("_data")));
            if(!"<unknown>".equals(contentvalues.getAsString("album"))) goto _L2; else goto _L1
_L1:
            String s1;
            int j1;
            s1 = contentvalues.getAsString("_data");
            j1 = s1.lastIndexOf('/');
            if(j1 < 0) goto _L2; else goto _L3
_L3:
            int k1 = 0;
_L8:
            int i2 = s1.indexOf('/', k1 + 1);
            if(i2 >= 0 && i2 < j1) goto _L5; else goto _L4
_L4:
            if(k1 != 0)
                contentvalues.put("album", s1.substring(k1 + 1, j1));
_L2:
            long l = fileentry.mRowId;
            if(!MediaFile.isAudioFileType(mFileType) || l != 0L && mMtpObjectHandle == 0) goto _L7; else goto _L6
_L6:
            contentvalues.put("is_ringtone", Boolean.valueOf(flag));
            contentvalues.put("is_notification", Boolean.valueOf(flag1));
            contentvalues.put("is_alarm", Boolean.valueOf(flag2));
            contentvalues.put("is_music", Boolean.valueOf(flag3));
            contentvalues.put("is_podcast", Boolean.valueOf(flag4));
_L10:
            Uri uri = mFilesUri;
            MediaInserter mediainserter = mMediaInserter;
            Uri uri1;
            boolean flag5;
            if(!mNoMedia)
                if(MediaFile.isVideoFileType(mFileType))
                    uri = mVideoUri;
                else
                if(MediaFile.isImageFileType(mFileType))
                    uri = mImagesUri;
                else
                if(MediaFile.isAudioFileType(mFileType))
                    uri = mAudioUri;
            uri1 = null;
            flag5 = false;
            if(l == 0L) {
                if(mMtpObjectHandle != 0)
                    contentvalues.put("media_scanner_new_object_id", Integer.valueOf(mMtpObjectHandle));
                Uri uri2 = mFilesUri;
                if(uri == uri2) {
                    int i1 = fileentry.mFormat;
                    if(i1 == 0)
                        i1 = MediaFile.getFormatCode(fileentry.mPath, mMimeType);
                    contentvalues.put("format", Integer.valueOf(i1));
                }
                ExifInterface exifinterface;
                ExifInterface exifinterface1;
                float af[];
                long l1;
                long l2;
                int i;
                int j;
                if(mWasEmptyPriorToScan)
                    if(flag1 && !mDefaultNotificationSet) {
                        if(TextUtils.isEmpty(mDefaultNotificationFilename) || doesPathHaveFilename(fileentry.mPath, mDefaultNotificationFilename))
                            flag5 = true;
                    } else
                    if(flag && !mDefaultRingtoneSet) {
                        if(TextUtils.isEmpty(mDefaultRingtoneFilename) || doesPathHaveFilename(fileentry.mPath, mDefaultRingtoneFilename))
                            flag5 = true;
                    } else
                    if(flag2 && !mDefaultAlarmSet && (TextUtils.isEmpty(mDefaultAlarmAlertFilename) || doesPathHaveFilename(fileentry.mPath, mDefaultAlarmAlertFilename)))
                        flag5 = true;
                if(mediainserter == null || flag5)
                    uri1 = mMediaProvider.insert(uri, contentvalues);
                else
                if(fileentry.mFormat == 12289)
                    mediainserter.insertwithPriority(uri, contentvalues);
                else
                    mediainserter.insert(uri, contentvalues);
                if(uri1 != null)
                    fileentry.mRowId = ContentUris.parseId(uri1);
            } else {
                uri1 = ContentUris.withAppendedId(uri, l);
                contentvalues.remove("_data");
                byte byte0 = 0;
                if(!MediaScanner.isNoMediaPath(fileentry.mPath)) {
                    int k = MediaFile.getFileTypeForMimeType(mMimeType);
                    if(MediaFile.isAudioFileType(k))
                        byte0 = 2;
                    else
                    if(MediaFile.isVideoFileType(k))
                        byte0 = 3;
                    else
                    if(MediaFile.isImageFileType(k))
                        byte0 = 1;
                    else
                    if(MediaFile.isPlayListFileType(k))
                        byte0 = 4;
                    contentvalues.put("media_type", Integer.valueOf(byte0));
                }
                mMediaProvider.update(uri1, contentvalues, null, null);
            }
            if(flag5)
                if(flag1) {
                    setSettingIfNotSet("notification_sound", fileentry.mPath);
                    setSettingIfNotSet("sms_delivered_sound", fileentry.mPath);
                    setSettingIfNotSet("sms_received_sound", fileentry.mPath);
                    mDefaultNotificationSet = true;
                } else
                if(flag) {
                    setSettingIfNotSet("ringtone", fileentry.mPath);
                    mDefaultRingtoneSet = true;
                } else
                if(flag2) {
                    setSettingIfNotSet("alarm_alert", fileentry.mPath);
                    mDefaultAlarmSet = true;
                }
            return uri1;
_L5:
            k1 = i2;
              goto _L8
_L7:
            if(mFileType != 31 || mNoMedia) goto _L10; else goto _L9
_L9:
            exifinterface = null;
            exifinterface1 = new ExifInterface(fileentry.mPath);
            exifinterface = exifinterface1;
_L18:
            if(exifinterface == null) goto _L10; else goto _L11
_L11:
            af = new float[2];
            if(exifinterface.getLatLong(af)) {
                contentvalues.put("latitude", Float.valueOf(af[0]));
                contentvalues.put("longitude", Float.valueOf(af[1]));
            }
            l1 = exifinterface.getGpsDateTime();
            if(l1 != -1L) {
                contentvalues.put("datetaken", Long.valueOf(l1));
            } else {
                l2 = exifinterface.getDateTime();
                if(l2 != -1L && Math.abs(1000L * mLastModified - l2) >= 0x5265c00L)
                    contentvalues.put("datetaken", Long.valueOf(l2));
            }
            i = exifinterface.getAttributeInt("Orientation", -1);
            if(i == -1) goto _L10; else goto _L12
_L12:
            i;
            JVM INSTR tableswitch 3 8: default 724
        //                       3 803
        //                       4 724
        //                       5 724
        //                       6 796
        //                       7 724
        //                       8 811;
               goto _L13 _L14 _L13 _L13 _L15 _L13 _L16
_L16:
            break MISSING_BLOCK_LABEL_811;
_L13:
            j = 0;
_L17:
            contentvalues.put("orientation", Integer.valueOf(j));
              goto _L10
_L15:
            j = 90;
              goto _L17
_L14:
            j = 180;
              goto _L17
            j = 270;
              goto _L17
            IOException ioexception;
            ioexception;
              goto _L18
        }

        private int getFileTypeFromDrm(String s) {
            if(isDrmEnabled()) goto _L2; else goto _L1
_L1:
            int i = 0;
_L4:
            return i;
_L2:
            i = 0;
            if(mDrmManagerClient == null)
                mDrmManagerClient = new DrmManagerClient(mContext);
            if(mDrmManagerClient.canHandle(s, null)) {
                String s1 = mDrmManagerClient.getOriginalMimeType(s);
                if(s1 != null) {
                    mMimeType = s1;
                    i = MediaFile.getFileTypeForMimeType(s1);
                }
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        private int parseSubstring(String s, int i, int j) {
            int k = s.length();
            if(i != k) goto _L2; else goto _L1
_L1:
            return j;
_L2:
            int l = i + 1;
            char c = s.charAt(i);
            if(c < '0' || c > '9') {
                l;
                continue; /* Loop/switch isn't completed */
            }
            int i1 = c - 48;
            do {
                if(l >= k)
                    break;
                int j1 = l + 1;
                char c1 = s.charAt(l);
                if(c1 < '0' || c1 > '9') {
                    j = i1;
                    continue; /* Loop/switch isn't completed */
                }
                i1 = i1 * 10 + (c1 - 48);
                l = j1;
            } while(true);
            l;
            j = i1;
            if(true) goto _L1; else goto _L3
_L3:
        }

        private void processImageFile(String s) {
            mBitmapOptions.outWidth = 0;
            mBitmapOptions.outHeight = 0;
            BitmapFactory.decodeFile(s, mBitmapOptions);
            mWidth = mBitmapOptions.outWidth;
            mHeight = mBitmapOptions.outHeight;
_L2:
            return;
            Throwable throwable;
            throwable;
            if(true) goto _L2; else goto _L1
_L1:
        }

        private void setSettingIfNotSet(String s, Uri uri, long l) {
            if(TextUtils.isEmpty(android.provider.Settings.System.getString(mContext.getContentResolver(), s)))
                android.provider.Settings.System.putString(mContext.getContentResolver(), s, ContentUris.withAppendedId(uri, l).toString());
        }

        private void setSettingIfNotSet(String s, String s1) {
            if(TextUtils.isEmpty(android.provider.Settings.System.getString(mContext.getContentResolver(), s)))
                android.provider.Settings.System.putString(mContext.getContentResolver(), s, Uri.fromFile(new File(s1)).toString());
        }

        private void testGenreNameConverter() {
            convertGenreCode("2", "Country");
            convertGenreCode("(2)", "Country");
            convertGenreCode("(2", "(2");
            convertGenreCode("2 Foo", "Country");
            convertGenreCode("(2) Foo", "Country");
            convertGenreCode("(2 Foo", "(2 Foo");
            convertGenreCode("2Foo", "2Foo");
            convertGenreCode("(2)Foo", "Country");
            convertGenreCode("200 Foo", "Foo");
            convertGenreCode("(200) Foo", "Foo");
            convertGenreCode("200Foo", "200Foo");
            convertGenreCode("(200)Foo", "Foo");
            convertGenreCode("200)Foo", "200)Foo");
            convertGenreCode("200) Foo", "200) Foo");
        }

        private ContentValues toValues() {
            ContentValues contentvalues;
            String s;
            contentvalues = new ContentValues();
            contentvalues.put("_data", mPath);
            contentvalues.put("title", mTitle);
            contentvalues.put("date_modified", Long.valueOf(mLastModified));
            contentvalues.put("_size", Long.valueOf(mFileSize));
            contentvalues.put("mime_type", mMimeType);
            contentvalues.put("is_drm", Boolean.valueOf(mIsDrm));
            s = null;
            if(mWidth > 0 && mHeight > 0) {
                contentvalues.put("width", Integer.valueOf(mWidth));
                contentvalues.put("height", Integer.valueOf(mHeight));
                s = (new StringBuilder()).append(mWidth).append("x").append(mHeight).toString();
            }
            if(mNoMedia) goto _L2; else goto _L1
_L1:
            if(!MediaFile.isVideoFileType(mFileType)) goto _L4; else goto _L3
_L3:
            String s4;
            String s5;
            if(mArtist != null && mArtist.length() > 0)
                s4 = mArtist;
            else
                s4 = "<unknown>";
            contentvalues.put("artist", s4);
            if(mAlbum != null && mAlbum.length() > 0)
                s5 = mAlbum;
            else
                s5 = "<unknown>";
            contentvalues.put("album", s5);
            contentvalues.put("duration", Integer.valueOf(mDuration));
            if(s != null)
                contentvalues.put("resolution", s);
_L2:
            return contentvalues;
_L4:
            if(!MediaFile.isImageFileType(mFileType) && MediaFile.isAudioFileType(mFileType)) {
                String s1;
                String s2;
                String s3;
                if(mArtist != null && mArtist.length() > 0)
                    s1 = mArtist;
                else
                    s1 = "<unknown>";
                contentvalues.put("artist", s1);
                if(mAlbumArtist != null && mAlbumArtist.length() > 0)
                    s2 = mAlbumArtist;
                else
                    s2 = null;
                contentvalues.put("album_artist", s2);
                if(mAlbum != null && mAlbum.length() > 0)
                    s3 = mAlbum;
                else
                    s3 = "<unknown>";
                contentvalues.put("album", s3);
                contentvalues.put("composer", mComposer);
                contentvalues.put("genre", mGenre);
                if(mYear != 0)
                    contentvalues.put("year", Integer.valueOf(mYear));
                contentvalues.put("track", Integer.valueOf(mTrack));
                contentvalues.put("duration", Integer.valueOf(mDuration));
                contentvalues.put("compilation", Integer.valueOf(mCompilation));
            }
            if(true) goto _L2; else goto _L5
_L5:
        }

        public FileEntry beginFile(String s, String s1, long l, long l1, boolean flag, 
                boolean flag1) {
            mMimeType = s1;
            mFileType = 0;
            mFileSize = l1;
            if(!flag) {
                if(!flag1 && MediaScanner.isNoMediaFile(s))
                    flag1 = true;
                mNoMedia = flag1;
                if(s1 != null)
                    mFileType = MediaFile.getFileTypeForMimeType(s1);
                if(mFileType == 0) {
                    MediaFile.MediaFileType mediafiletype = MediaFile.getFileType(s);
                    if(mediafiletype != null) {
                        mFileType = mediafiletype.fileType;
                        if(mMimeType == null)
                            mMimeType = mediafiletype.mimeType;
                    }
                }
                if(isDrmEnabled() && MediaFile.isDrmFileType(mFileType))
                    mFileType = getFileTypeFromDrm(s);
            }
            FileEntry fileentry = makeEntryFor(s);
            long l2;
            boolean flag2;
            if(fileentry != null)
                l2 = l - fileentry.mLastModified;
            else
                l2 = 0L;
            if(l2 > 1L || l2 < -1L)
                flag2 = true;
            else
                flag2 = false;
            if(fileentry == null || flag2) {
                if(flag2) {
                    fileentry.mLastModified = l;
                } else {
                    char c;
                    if(flag)
                        c = '\u3001';
                    else
                        c = '\0';
                    fileentry = new FileEntry(0L, s, l, c);
                }
                fileentry.mLastModifiedChanged = true;
            }
            if(mProcessPlaylists && MediaFile.isPlayListFileType(mFileType)) {
                mPlayLists.add(fileentry);
                fileentry = null;
            } else {
                mArtist = null;
                mAlbumArtist = null;
                mAlbum = null;
                mTitle = null;
                mComposer = null;
                mGenre = null;
                mTrack = 0;
                mYear = 0;
                mDuration = 0;
                mPath = s;
                mLastModified = l;
                mWriter = null;
                mCompilation = 0;
                mIsDrm = false;
                mWidth = 0;
                mHeight = 0;
            }
            return fileentry;
        }

        public Uri doScanFile(String s, String s1, long l, long l1, boolean flag, 
                boolean flag1, boolean flag2) {
            Uri uri = null;
            FileEntry fileentry;
            fileentry = beginFile(s, s1, l, l1, flag, flag2);
            if(mMtpObjectHandle != 0)
                fileentry.mRowId = 0L;
            if(fileentry == null || !fileentry.mLastModifiedChanged && !flag1) goto _L2; else goto _L1
_L1:
            if(!flag2) goto _L4; else goto _L3
_L3:
            uri = endFile(fileentry, false, false, false, false, false);
              goto _L2
_L4:
            String s2 = s.toLowerCase();
            if(s2.indexOf("/ringtones/") <= 0) goto _L6; else goto _L5
_L5:
            boolean flag3 = true;
_L17:
            if(s2.indexOf("/notifications/") <= 0) goto _L8; else goto _L7
_L7:
            boolean flag4 = true;
_L13:
            if(s2.indexOf("/alarms/") <= 0) goto _L10; else goto _L9
_L9:
            boolean flag5 = true;
_L14:
            if(s2.indexOf("/podcasts/") <= 0) goto _L12; else goto _L11
_L11:
            boolean flag6 = true;
_L15:
            RemoteException remoteexception;
            boolean flag7;
            Uri uri1;
            if(s2.indexOf("/music/") <= 0 && (flag3 || flag4 || flag5 || flag6))
                flag7 = false;
            else
                flag7 = true;
            if(MediaFile.isAudioFileType(mFileType) || MediaFile.isVideoFileType(mFileType))
                processFile(s, s1, this);
            if(MediaFile.isImageFileType(mFileType))
                processImageFile(s);
            uri1 = endFile(fileentry, flag3, flag4, flag5, flag7, flag6);
            uri = uri1;
              goto _L2
_L6:
            flag3 = false;
            continue; /* Loop/switch isn't completed */
_L8:
            flag4 = false;
              goto _L13
_L10:
            flag5 = false;
              goto _L14
_L12:
            flag6 = false;
              goto _L15
            remoteexception;
            Log.e("MediaScanner", "RemoteException in MediaScanner.scanFile()", remoteexception);
_L2:
            return uri;
            if(true) goto _L17; else goto _L16
_L16:
        }

        public String getGenreName(String s) {
            String s1 = null;
            if(s != null) goto _L2; else goto _L1
_L1:
            return s1;
_L2:
            int i;
            boolean flag;
            StringBuffer stringbuffer;
            int j;
            i = s.length();
            if(i <= 0)
                break MISSING_BLOCK_LABEL_246;
            flag = false;
            stringbuffer = new StringBuffer();
            j = 0;
_L4:
            char c1;
            if(j >= i)
                break MISSING_BLOCK_LABEL_86;
            c1 = s.charAt(j);
            if(j != 0 || c1 != '(')
                break; /* Loop/switch isn't completed */
            flag = true;
_L5:
            j++;
            if(true) goto _L4; else goto _L3
_L3:
            if(!Character.isDigit(c1))
                break MISSING_BLOCK_LABEL_86;
            stringbuffer.append(c1);
              goto _L5
            if(true) goto _L4; else goto _L6
_L6:
            char c;
            short word0;
            NumberFormatException numberformatexception;
            String s2;
            if(j < i)
                c = s.charAt(j);
            else
                c = ' ';
            if((!flag || c != ')') && (flag || !Character.isWhitespace(c)))
                break MISSING_BLOCK_LABEL_246;
            word0 = Short.parseShort(stringbuffer.toString());
            if(word0 < 0)
                break MISSING_BLOCK_LABEL_246;
            if(word0 < MediaScanner.ID3_GENRES.length) {
                s1 = MediaScanner.ID3_GENRES[word0];
                continue; /* Loop/switch isn't completed */
            }
              goto _L7
_L10:
            s1 = s.substring(j).trim();
            if(s1.length() != 0)
                continue; /* Loop/switch isn't completed */
            break MISSING_BLOCK_LABEL_246;
_L9:
            s2 = stringbuffer.toString();
            s1 = s2;
            continue; /* Loop/switch isn't completed */
            numberformatexception;
            break MISSING_BLOCK_LABEL_246;
_L7:
            if(word0 == 255)
                continue; /* Loop/switch isn't completed */
            if(word0 >= 255 || j + 1 >= i) goto _L9; else goto _L8
_L8:
            if(flag && c == ')')
                j++;
              goto _L10
            s1 = s;
            if(true) goto _L1; else goto _L11
_L11:
        }

        public void handleStringTag(String s, String s1) {
            boolean flag = true;
            if(!s.equalsIgnoreCase("title") && !s.startsWith("title;")) goto _L2; else goto _L1
_L1:
            mTitle = s1;
_L4:
            return;
_L2:
            if(s.equalsIgnoreCase("artist") || s.startsWith("artist;"))
                mArtist = s1.trim();
            else
            if(s.equalsIgnoreCase("albumartist") || s.startsWith("albumartist;") || s.equalsIgnoreCase("band") || s.startsWith("band;"))
                mAlbumArtist = s1.trim();
            else
            if(s.equalsIgnoreCase("album") || s.startsWith("album;"))
                mAlbum = s1.trim();
            else
            if(s.equalsIgnoreCase("composer") || s.startsWith("composer;"))
                mComposer = s1.trim();
            else
            if(mProcessGenres && (s.equalsIgnoreCase("genre") || s.startsWith("genre;")))
                mGenre = getGenreName(s1);
            else
            if(s.equalsIgnoreCase("year") || s.startsWith("year;"))
                mYear = parseSubstring(s1, 0, 0);
            else
            if(s.equalsIgnoreCase("tracknumber") || s.startsWith("tracknumber;"))
                mTrack = parseSubstring(s1, 0, 0) + 1000 * (mTrack / 1000);
            else
            if(s.equalsIgnoreCase("discnumber") || s.equals("set") || s.startsWith("set;"))
                mTrack = 1000 * parseSubstring(s1, 0, 0) + mTrack % 1000;
            else
            if(s.equalsIgnoreCase("duration"))
                mDuration = parseSubstring(s1, 0, 0);
            else
            if(s.equalsIgnoreCase("writer") || s.startsWith("writer;"))
                mWriter = s1.trim();
            else
            if(s.equalsIgnoreCase("compilation"))
                mCompilation = parseSubstring(s1, 0, 0);
            else
            if(s.equalsIgnoreCase("isdrm")) {
                if(parseSubstring(s1, 0, 0) != flag)
                    flag = false;
                mIsDrm = flag;
            } else
            if(s.equalsIgnoreCase("width"))
                mWidth = parseSubstring(s1, 0, 0);
            else
            if(s.equalsIgnoreCase("height"))
                mHeight = parseSubstring(s1, 0, 0);
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void scanFile(String s, long l, long l1, boolean flag, boolean flag1) {
            doScanFile(s, null, l, l1, flag, false, flag1);
        }

        public void setMimeType(String s) {
            if(!"audio/mp4".equals(mMimeType) || !s.startsWith("video")) {
                mMimeType = s;
                mFileType = MediaFile.getFileTypeForMimeType(s);
            }
        }

        private String mAlbum;
        private String mAlbumArtist;
        private String mArtist;
        private int mCompilation;
        private String mComposer;
        private int mDuration;
        private long mFileSize;
        private int mFileType;
        private String mGenre;
        private int mHeight;
        private boolean mIsDrm;
        private long mLastModified;
        private String mMimeType;
        private boolean mNoMedia;
        private String mPath;
        private String mTitle;
        private int mTrack;
        private int mWidth;
        private String mWriter;
        private int mYear;
        final MediaScanner this$0;

        private MyMediaScannerClient() {
            this$0 = MediaScanner.this;
            super();
        }

    }

    private static class PlaylistEntry {

        long bestmatchid;
        int bestmatchlevel;
        String path;

        private PlaylistEntry() {
        }

    }

    private static class FileEntry {

        public String toString() {
            return (new StringBuilder()).append(mPath).append(" mRowId: ").append(mRowId).toString();
        }

        int mFormat;
        long mLastModified;
        boolean mLastModifiedChanged;
        String mPath;
        long mRowId;

        FileEntry(long l, String s, long l1, int i) {
            mRowId = l;
            mPath = s;
            mLastModified = l1;
            mFormat = i;
            mLastModifiedChanged = false;
        }
    }


    public MediaScanner(Context context) {
        mWasEmptyPriorToScan = false;
        mPlaylistEntries = new ArrayList();
        mDrmManagerClient = null;
        native_setup();
        mContext = context;
        mBitmapOptions.inSampleSize = 1;
        mBitmapOptions.inJustDecodeBounds = true;
        setDefaultRingtoneFileNames();
    }

    private void cachePlaylistEntry(String s, String s1) {
        boolean flag = false;
        PlaylistEntry playlistentry = new PlaylistEntry();
        int i;
        for(i = s.length(); i > 0 && Character.isWhitespace(s.charAt(i - 1)); i--);
        if(i >= 3) {
            if(i < s.length())
                s = s.substring(0, i);
            char c = s.charAt(0);
            if(c == '/' || Character.isLetter(c) && s.charAt(1) == ':' && s.charAt(2) == '\\')
                flag = true;
            if(!flag)
                s = (new StringBuilder()).append(s1).append(s).toString();
            playlistentry.path = s;
            mPlaylistEntries.add(playlistentry);
        }
    }

    private boolean inScanDirectory(String s, String as[]) {
        int i = 0;
_L3:
        if(i >= as.length)
            break MISSING_BLOCK_LABEL_30;
        if(!s.startsWith(as[i])) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = false;
          goto _L4
    }

    private void initialize(String s) {
        mMediaProvider = mContext.getContentResolver().acquireProvider("media");
        mAudioUri = android.provider.MediaStore.Audio.Media.getContentUri(s);
        mVideoUri = android.provider.MediaStore.Video.Media.getContentUri(s);
        mImagesUri = android.provider.MediaStore.Images.Media.getContentUri(s);
        mThumbsUri = android.provider.MediaStore.Images.Thumbnails.getContentUri(s);
        mFilesUri = android.provider.MediaStore.Files.getContentUri(s);
        if(!s.equals("internal")) {
            mProcessPlaylists = true;
            mProcessGenres = true;
            mPlaylistsUri = android.provider.MediaStore.Audio.Playlists.getContentUri(s);
            mCaseInsensitivePaths = true;
        }
    }

    private boolean isDrmEnabled() {
        String s = SystemProperties.get("drm.service.enabled");
        boolean flag;
        if(s != null && s.equals("true"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isNoMediaFile(String s) {
        boolean flag = true;
        if(!(new File(s)).isDirectory()) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        int i = s.lastIndexOf('/');
        if(i >= 0 && i + 2 < s.length()) {
            if(s.regionMatches(i + 1, "._", 0, 2))
                continue; /* Loop/switch isn't completed */
            if(s.regionMatches(flag, -4 + s.length(), ".jpg", 0, 4)) {
                if(s.regionMatches(flag, i + 1, "AlbumArt_{", 0, 10) || s.regionMatches(flag, i + 1, "AlbumArt.", 0, 9))
                    continue; /* Loop/switch isn't completed */
                int j = -1 + (s.length() - i);
                if(j == 17 && s.regionMatches(flag, i + 1, "AlbumArtSmall", 0, 13) || j == 10 && s.regionMatches(flag, i + 1, "Folder", 0, 6))
                    continue; /* Loop/switch isn't completed */
            }
        }
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean isNoMediaPath(String s) {
        boolean flag = false;
        if(s != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(s.indexOf("/.") >= 0) {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        int j;
        for(int i = 1; i >= 0; i = j) {
            j = s.indexOf('/', i);
            if(j <= i)
                continue;
            j++;
            if(!(new File((new StringBuilder()).append(s.substring(0, j)).append(".nomedia").toString())).exists())
                continue;
            flag = true;
            continue; /* Loop/switch isn't completed */
        }

        flag = isNoMediaFile(s);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean matchEntries(long l, String s) {
        int i = mPlaylistEntries.size();
        boolean flag = true;
        int j = 0;
        while(j < i)  {
            PlaylistEntry playlistentry = (PlaylistEntry)mPlaylistEntries.get(j);
            if(playlistentry.bestmatchlevel != 0x7fffffff) {
                flag = false;
                if(s.equalsIgnoreCase(playlistentry.path)) {
                    playlistentry.bestmatchid = l;
                    playlistentry.bestmatchlevel = 0x7fffffff;
                } else {
                    int k = matchPaths(s, playlistentry.path);
                    if(k > playlistentry.bestmatchlevel) {
                        playlistentry.bestmatchid = l;
                        playlistentry.bestmatchlevel = k;
                    }
                }
            }
            j++;
        }
        return flag;
    }

    private int matchPaths(String s, String s1) {
        int i = 0;
        int j = s.length();
        int k = s1.length();
        do {
            int j2;
            int k2;
            int l2;
            if(j > 0 && k > 0) {
                int l = s.lastIndexOf('/', j - 1);
                int i1 = s1.lastIndexOf('/', k - 1);
                int j1 = s.lastIndexOf('\\', j - 1);
                int k1 = s1.lastIndexOf('\\', k - 1);
                int l1;
                int i2;
                if(l > j1)
                    l1 = l;
                else
                    l1 = j1;
                if(i1 > k1)
                    i2 = i1;
                else
                    i2 = k1;
                if(l1 < 0)
                    j2 = 0;
                else
                    j2 = l1 + 1;
                if(i2 < 0)
                    k2 = 0;
                else
                    k2 = i2 + 1;
                l2 = j - j2;
                break MISSING_BLOCK_LABEL_117;
            }
            do
                return i;
            while(k - k2 != l2 || !s.regionMatches(true, j2, s1, k2, l2));
            i++;
            j = j2 - 1;
            k = k2 - 1;
        } while(true);
    }

    private final native void native_finalize();

    private static final native void native_init();

    private final native void native_setup();

    private void postscan(String as[]) throws RemoteException {
        if(mProcessPlaylists)
            processPlayLists();
        if(mOriginalCount == 0 && mImagesUri.equals(android.provider.MediaStore.Images.Media.getContentUri("external")))
            pruneDeadThumbnailFiles();
        mPlayLists = null;
        mMediaProvider = null;
    }

    private void prescan(String s, boolean flag) throws RemoteException {
        Cursor cursor;
        MediaBulkDeleter mediabulkdeleter;
        long l;
        cursor = null;
        String s1;
        String as[];
        android.net.Uri.Builder builder;
        Cursor cursor1;
        Uri uri;
        Cursor cursor2;
        if(mPlayLists == null)
            mPlayLists = new ArrayList();
        else
            mPlayLists.clear();
        if(s != null) {
            s1 = "_id>? AND _data=?";
            as = new String[2];
            as[0] = "";
            as[1] = s;
        } else {
            s1 = "_id>?";
            as = new String[1];
            as[0] = "";
        }
        builder = mFilesUri.buildUpon();
        builder.appendQueryParameter("deletedata", "false");
        mediabulkdeleter = new MediaBulkDeleter(mMediaProvider, builder.build());
        if(!flag) goto _L2; else goto _L1
_L1:
        l = 0x8000000000000000L;
        uri = mFilesUri.buildUpon().appendQueryParameter("limit", "1000").build();
        mWasEmptyPriorToScan = true;
_L6:
        as[0] = (new StringBuilder()).append("").append(l).toString();
        if(cursor != null) {
            cursor.close();
            cursor = null;
        }
        cursor2 = mMediaProvider.query(uri, FILES_PRESCAN_PROJECTION, s1, as, "_id", null);
        cursor = cursor2;
        if(cursor != null) goto _L3; else goto _L2
_L2:
        if(cursor != null)
            cursor.close();
        mediabulkdeleter.flush();
        mOriginalCount = 0;
        cursor1 = mMediaProvider.query(mImagesUri, ID_PROJECTION, null, null, null, null);
        if(cursor1 != null) {
            mOriginalCount = cursor1.getCount();
            cursor1.close();
        }
        return;
_L3:
        if(cursor.getCount() == 0) goto _L2; else goto _L4
_L4:
        mWasEmptyPriorToScan = false;
_L8:
        if(!cursor.moveToNext()) goto _L6; else goto _L5
_L5:
        long l1;
        String s2;
        int i;
        l1 = cursor.getLong(0);
        s2 = cursor.getString(1);
        i = cursor.getInt(2);
        cursor.getLong(3);
        l = l1;
        if(s2 == null) goto _L8; else goto _L7
_L7:
        boolean flag1 = s2.startsWith("/");
        if(!flag1) goto _L8; else goto _L9
_L9:
        boolean flag2 = false;
        boolean flag3 = Libcore.os.access(s2, OsConstants.F_OK);
        flag2 = flag3;
_L13:
        if(flag2) goto _L8; else goto _L10
_L10:
        if(MtpConstants.isAbstractObject(i)) goto _L8; else goto _L11
_L11:
        MediaFile.MediaFileType mediafiletype;
        int j;
        mediafiletype = MediaFile.getFileType(s2);
        if(mediafiletype != null)
            break MISSING_BLOCK_LABEL_507;
        j = 0;
_L12:
        if(!MediaFile.isPlayListFileType(j)) {
            mediabulkdeleter.delete(l1);
            if(s2.toLowerCase(Locale.US).endsWith("/.nomedia")) {
                mediabulkdeleter.flush();
                String s3 = (new File(s2)).getParent();
                mMediaProvider.call("unhide", s3, null);
            }
        }
          goto _L8
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        mediabulkdeleter.flush();
        throw exception;
        j = mediafiletype.fileType;
          goto _L12
        ErrnoException errnoexception;
        errnoexception;
          goto _L13
    }

    private void processCachedPlaylist(Cursor cursor, ContentValues contentvalues, Uri uri) {
        int i;
        int j;
        int k;
        cursor.moveToPosition(-1);
        while(cursor.moveToNext() && !matchEntries(cursor.getLong(0), cursor.getString(1))) ;
        i = mPlaylistEntries.size();
        j = 0;
        k = 0;
_L2:
        PlaylistEntry playlistentry;
        if(k >= i)
            break; /* Loop/switch isn't completed */
        playlistentry = (PlaylistEntry)mPlaylistEntries.get(k);
        if(playlistentry.bestmatchlevel <= 0)
            break MISSING_BLOCK_LABEL_129;
        contentvalues.clear();
        contentvalues.put("play_order", Integer.valueOf(j));
        contentvalues.put("audio_id", Long.valueOf(playlistentry.bestmatchid));
        mMediaProvider.insert(uri, contentvalues);
        j++;
        k++;
        if(true) goto _L2; else goto _L1
        RemoteException remoteexception;
        remoteexception;
        Log.e("MediaScanner", "RemoteException in MediaScanner.processCachedPlaylist()", remoteexception);
_L4:
        return;
_L1:
        mPlaylistEntries.clear();
        if(true) goto _L4; else goto _L3
_L3:
    }

    private native void processDirectory(String s, MediaScannerClient mediascannerclient);

    private native void processFile(String s, String s1, MediaScannerClient mediascannerclient);

    private void processM3uPlayList(String s, String s1, Uri uri, ContentValues contentvalues, Cursor cursor) {
        BufferedReader bufferedreader = null;
        BufferedReader bufferedreader1;
        File file = new File(s);
        if(!file.exists())
            break MISSING_BLOCK_LABEL_117;
        bufferedreader1 = new BufferedReader(new InputStreamReader(new FileInputStream(file)), 8192);
        String s4 = bufferedreader1.readLine();
        mPlaylistEntries.clear();
        for(; s4 != null; s4 = bufferedreader1.readLine())
            if(s4.length() > 0 && s4.charAt(0) != '#')
                cachePlaylistEntry(s4, s1);

        processCachedPlaylist(cursor, contentvalues, uri);
        bufferedreader = bufferedreader1;
        if(bufferedreader == null)
            break MISSING_BLOCK_LABEL_127;
        bufferedreader.close();
_L2:
        return;
        IOException ioexception1;
        ioexception1;
_L5:
        Log.e("MediaScanner", "IOException in MediaScanner.processM3uPlayList()", ioexception1);
        if(bufferedreader == null) goto _L2; else goto _L1
_L1:
        bufferedreader.close();
          goto _L2
        IOException ioexception2;
        ioexception2;
        String s2;
        String s3;
        s2 = "MediaScanner";
        s3 = "IOException in MediaScanner.processM3uPlayList()";
_L3:
        Log.e(s2, s3, ioexception2);
          goto _L2
        Exception exception;
        exception;
_L4:
        if(bufferedreader != null)
            try {
                bufferedreader.close();
            }
            catch(IOException ioexception) {
                Log.e("MediaScanner", "IOException in MediaScanner.processM3uPlayList()", ioexception);
            }
        throw exception;
        ioexception2;
        s2 = "MediaScanner";
        s3 = "IOException in MediaScanner.processM3uPlayList()";
          goto _L3
        exception;
        bufferedreader = bufferedreader1;
          goto _L4
        ioexception1;
        bufferedreader = bufferedreader1;
          goto _L5
    }

    private void processPlayList(FileEntry fileentry, Cursor cursor) throws RemoteException {
        String s;
        ContentValues contentvalues;
        Uri uri1;
        String s2;
        int j;
        s = fileentry.mPath;
        contentvalues = new ContentValues();
        int i = s.lastIndexOf('/');
        if(i < 0)
            throw new IllegalArgumentException((new StringBuilder()).append("bad path ").append(s).toString());
        long l = fileentry.mRowId;
        String s1 = contentvalues.getAsString("name");
        MediaFile.MediaFileType mediafiletype;
        if(s1 == null) {
            s1 = contentvalues.getAsString("title");
            if(s1 == null) {
                int k = s.lastIndexOf('.');
                Uri uri2;
                if(k < 0)
                    s1 = s.substring(i + 1);
                else
                    s1 = s.substring(i + 1, k);
            }
        }
        contentvalues.put("name", s1);
        contentvalues.put("date_modified", Long.valueOf(fileentry.mLastModified));
        if(l == 0L) {
            contentvalues.put("_data", s);
            uri2 = mMediaProvider.insert(mPlaylistsUri, contentvalues);
            ContentUris.parseId(uri2);
            uri1 = Uri.withAppendedPath(uri2, "members");
        } else {
            Uri uri = ContentUris.withAppendedId(mPlaylistsUri, l);
            mMediaProvider.update(uri, contentvalues, null, null);
            uri1 = Uri.withAppendedPath(uri, "members");
            mMediaProvider.delete(uri1, null, null);
        }
        s2 = s.substring(0, i + 1);
        mediafiletype = MediaFile.getFileType(s);
        if(mediafiletype == null)
            j = 0;
        else
            j = mediafiletype.fileType;
        if(j != 41) goto _L2; else goto _L1
_L1:
        processM3uPlayList(s, s2, uri1, contentvalues, cursor);
_L4:
        return;
_L2:
        if(j == 42)
            processPlsPlayList(s, s2, uri1, contentvalues, cursor);
        else
        if(j == 43)
            processWplPlayList(s, s2, uri1, contentvalues, cursor);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void processPlayLists() throws RemoteException {
        Iterator iterator;
        Cursor cursor;
        iterator = mPlayLists.iterator();
        cursor = null;
        cursor = mMediaProvider.query(mFilesUri, FILES_PRESCAN_PROJECTION, "media_type=2", null, null, null);
        while(iterator.hasNext())  {
            FileEntry fileentry = (FileEntry)iterator.next();
            if(fileentry.mLastModifiedChanged)
                processPlayList(fileentry, cursor);
        }
          goto _L1
        RemoteException remoteexception;
        remoteexception;
        if(cursor == null) goto _L3; else goto _L2
_L2:
        cursor.close();
_L3:
        return;
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
_L1:
        if(cursor == null) goto _L3; else goto _L2
    }

    private void processPlsPlayList(String s, String s1, Uri uri, ContentValues contentvalues, Cursor cursor) {
        BufferedReader bufferedreader = null;
        BufferedReader bufferedreader1;
        File file = new File(s);
        if(!file.exists())
            break MISSING_BLOCK_LABEL_130;
        bufferedreader1 = new BufferedReader(new InputStreamReader(new FileInputStream(file)), 8192);
        String s4 = bufferedreader1.readLine();
        mPlaylistEntries.clear();
        for(; s4 != null; s4 = bufferedreader1.readLine()) {
            if(!s4.startsWith("File"))
                continue;
            int i = s4.indexOf('=');
            if(i > 0)
                cachePlaylistEntry(s4.substring(i + 1), s1);
        }

        processCachedPlaylist(cursor, contentvalues, uri);
        bufferedreader = bufferedreader1;
        if(bufferedreader == null)
            break MISSING_BLOCK_LABEL_140;
        bufferedreader.close();
_L2:
        return;
        IOException ioexception1;
        ioexception1;
_L5:
        Log.e("MediaScanner", "IOException in MediaScanner.processPlsPlayList()", ioexception1);
        if(bufferedreader == null) goto _L2; else goto _L1
_L1:
        bufferedreader.close();
          goto _L2
        IOException ioexception2;
        ioexception2;
        String s2;
        String s3;
        s2 = "MediaScanner";
        s3 = "IOException in MediaScanner.processPlsPlayList()";
_L3:
        Log.e(s2, s3, ioexception2);
          goto _L2
        Exception exception;
        exception;
_L4:
        if(bufferedreader != null)
            try {
                bufferedreader.close();
            }
            catch(IOException ioexception) {
                Log.e("MediaScanner", "IOException in MediaScanner.processPlsPlayList()", ioexception);
            }
        throw exception;
        ioexception2;
        s2 = "MediaScanner";
        s3 = "IOException in MediaScanner.processPlsPlayList()";
          goto _L3
        exception;
        bufferedreader = bufferedreader1;
          goto _L4
        ioexception1;
        bufferedreader = bufferedreader1;
          goto _L5
    }

    private void processWplPlayList(String s, String s1, Uri uri, ContentValues contentvalues, Cursor cursor) {
        FileInputStream fileinputstream = null;
        FileInputStream fileinputstream1;
        File file = new File(s);
        if(!file.exists())
            break MISSING_BLOCK_LABEL_78;
        fileinputstream1 = new FileInputStream(file);
        mPlaylistEntries.clear();
        Xml.parse(fileinputstream1, Xml.findEncodingByName("UTF-8"), (new WplHandler(s1, uri, cursor)).getContentHandler());
        processCachedPlaylist(cursor, contentvalues, uri);
        fileinputstream = fileinputstream1;
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_88;
        fileinputstream.close();
_L2:
        return;
        SAXException saxexception;
        saxexception;
_L7:
        saxexception.printStackTrace();
        if(fileinputstream == null) goto _L2; else goto _L1
_L1:
        fileinputstream.close();
          goto _L2
        IOException ioexception2;
        ioexception2;
        String s2;
        String s3;
        s2 = "MediaScanner";
        s3 = "IOException in MediaScanner.processWplPlayList()";
_L4:
        Log.e(s2, s3, ioexception2);
          goto _L2
        IOException ioexception1;
        ioexception1;
_L6:
        ioexception1.printStackTrace();
        if(fileinputstream == null) goto _L2; else goto _L3
_L3:
        fileinputstream.close();
          goto _L2
        ioexception2;
        s2 = "MediaScanner";
        s3 = "IOException in MediaScanner.processWplPlayList()";
          goto _L4
        Exception exception;
        exception;
_L5:
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception) {
                Log.e("MediaScanner", "IOException in MediaScanner.processWplPlayList()", ioexception);
            }
        throw exception;
        ioexception2;
        s2 = "MediaScanner";
        s3 = "IOException in MediaScanner.processWplPlayList()";
          goto _L4
        exception;
        fileinputstream = fileinputstream1;
          goto _L5
        ioexception1;
        fileinputstream = fileinputstream1;
          goto _L6
        saxexception;
        fileinputstream = fileinputstream1;
          goto _L7
    }

    private void pruneDeadThumbnailFiles() {
        HashSet hashset;
        hashset = new HashSet();
        String as[] = (new File("/sdcard/DCIM/.thumbnails")).list();
        if(as == null)
            as = new String[0];
        for(int i = 0; i < as.length; i++)
            hashset.add((new StringBuilder()).append("/sdcard/DCIM/.thumbnails").append("/").append(as[i]).toString());

        Cursor cursor;
        Iterator iterator;
        IContentProvider icontentprovider = mMediaProvider;
        Uri uri = mThumbsUri;
        String as1[] = new String[1];
        as1[0] = "_data";
        cursor = icontentprovider.query(uri, as1, null, null, null, null);
        Log.v("MediaScanner", (new StringBuilder()).append("pruneDeadThumbnailFiles... ").append(cursor).toString());
        if(cursor != null && cursor.moveToFirst())
            do
                hashset.remove(cursor.getString(0));
            while(cursor.moveToNext());
        iterator = hashset.iterator();
_L1:
        String s;
        if(!iterator.hasNext())
            break MISSING_BLOCK_LABEL_233;
        s = (String)iterator.next();
        try {
            (new File(s)).delete();
        }
        catch(SecurityException securityexception) { }
          goto _L1
        Log.v("MediaScanner", (new StringBuilder()).append("/pruneDeadThumbnailFiles... ").append(cursor).toString());
        if(cursor != null)
            cursor.close();
_L3:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L3; else goto _L2
_L2:
    }

    private void setDefaultRingtoneFileNames() {
        mDefaultRingtoneFilename = SystemProperties.get("ro.config.ringtone");
        mDefaultNotificationFilename = SystemProperties.get("ro.config.notification_sound");
        mDefaultAlarmAlertFilename = SystemProperties.get("ro.config.alarm_alert");
    }

    public native byte[] extractAlbumArt(FileDescriptor filedescriptor);

    protected void finalize() {
        mContext.getContentResolver().releaseProvider(mMediaProvider);
        native_finalize();
    }

    FileEntry makeEntryFor(String s) {
        Cursor cursor;
        FileEntry fileentry;
        String s1;
        String as[];
        long l;
        int i;
        if(mCaseInsensitivePaths) {
            s1 = "_data LIKE ?1 AND lower(_data)=lower(?1)";
            as = new String[1];
            as[0] = s;
        } else {
            s1 = "_data=?";
            as = new String[1];
            as[0] = s;
        }
        cursor = null;
        cursor = mMediaProvider.query(mFilesUri, FILES_PRESCAN_PROJECTION, s1, as, null, null);
        if(!cursor.moveToNext()) goto _L2; else goto _L1
_L1:
        l = cursor.getLong(0);
        i = cursor.getInt(2);
        fileentry = new FileEntry(l, s, cursor.getLong(3), i);
        if(cursor != null)
            cursor.close();
_L5:
        return fileentry;
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
        RemoteException remoteexception;
        remoteexception;
        if(cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
_L4:
        fileentry = null;
          goto _L5
_L2:
        if(cursor == null) goto _L4; else goto _L3
    }

    public void release() {
        native_finalize();
    }

    public void scanDirectories(String as[], String s) {
        System.currentTimeMillis();
        initialize(s);
        prescan(null, true);
        System.currentTimeMillis();
        mMediaInserter = new MediaInserter(mMediaProvider, 500);
        for(int i = 0; i < as.length; i++)
            processDirectory(as[i], mClient);

        mMediaInserter.flushAll();
        mMediaInserter = null;
        System.currentTimeMillis();
        postscan(as);
        System.currentTimeMillis();
_L1:
        return;
        SQLException sqlexception;
        sqlexception;
        Log.e("MediaScanner", "SQLException in MediaScanner.scan()", sqlexception);
          goto _L1
        UnsupportedOperationException unsupportedoperationexception;
        unsupportedoperationexception;
        Log.e("MediaScanner", "UnsupportedOperationException in MediaScanner.scan()", unsupportedoperationexception);
          goto _L1
        RemoteException remoteexception;
        remoteexception;
        Log.e("MediaScanner", "RemoteException in MediaScanner.scan()", remoteexception);
          goto _L1
    }

    public void scanMtpFile(String s, String s1, int i, int j) {
        MediaFile.MediaFileType mediafiletype;
        int k;
        File file;
        long l;
        initialize(s1);
        mediafiletype = MediaFile.getFileType(s);
        ContentValues contentvalues;
        String as[];
        if(mediafiletype == null)
            k = 0;
        else
            k = mediafiletype.fileType;
        file = new File(s);
        l = file.lastModified() / 1000L;
        if(MediaFile.isAudioFileType(k) || MediaFile.isVideoFileType(k) || MediaFile.isImageFileType(k) || MediaFile.isPlayListFileType(k)) goto _L2; else goto _L1
_L1:
        contentvalues = new ContentValues();
        contentvalues.put("_size", Long.valueOf(file.length()));
        contentvalues.put("date_modified", Long.valueOf(l));
        as = new String[1];
        as[0] = Integer.toString(i);
        mMediaProvider.update(android.provider.MediaStore.Files.getMtpObjectsUri(s1), contentvalues, "_id=?", as);
_L3:
        return;
        RemoteException remoteexception1;
        remoteexception1;
        Log.e("MediaScanner", "RemoteException in scanMtpFile", remoteexception1);
          goto _L3
_L2:
        Cursor cursor;
        mMtpObjectHandle = i;
        cursor = null;
        if(!MediaFile.isPlayListFileType(k)) goto _L5; else goto _L4
_L4:
        prescan(null, true);
        FileEntry fileentry = makeEntryFor(s);
        if(fileentry != null) {
            cursor = mMediaProvider.query(mFilesUri, FILES_PRESCAN_PROJECTION, null, null, null, null);
            processPlayList(fileentry, cursor);
        }
_L9:
        mMtpObjectHandle = 0;
        if(cursor == null) goto _L3; else goto _L6
_L6:
        cursor.close();
        break; /* Loop/switch isn't completed */
_L5:
        MyMediaScannerClient mymediascannerclient;
        String s2;
        long l1;
        prescan(s, false);
        mymediascannerclient = mClient;
        s2 = mediafiletype.mimeType;
        l1 = file.length();
        if(j != 12289) goto _L8; else goto _L7
_L7:
        boolean flag = true;
_L10:
        mymediascannerclient.doScanFile(s, s2, l, l1, flag, true, isNoMediaPath(s));
          goto _L9
        RemoteException remoteexception;
        remoteexception;
        Log.e("MediaScanner", "RemoteException in MediaScanner.scanFile()", remoteexception);
        mMtpObjectHandle = 0;
        if(cursor == null) goto _L3; else goto _L6
_L8:
        flag = false;
          goto _L10
        Exception exception;
        exception;
        mMtpObjectHandle = 0;
        if(cursor != null)
            cursor.close();
        throw exception;
          goto _L3
    }

    public Uri scanSingleFile(String s, String s1, String s2) {
        Uri uri1;
        initialize(s1);
        prescan(s, true);
        File file = new File(s);
        long l = file.lastModified() / 1000L;
        uri1 = mClient.doScanFile(s, s2, l, file.length(), false, true, false);
        Uri uri = uri1;
_L2:
        return uri;
        RemoteException remoteexception;
        remoteexception;
        Log.e("MediaScanner", "RemoteException in MediaScanner.scanFile()", remoteexception);
        uri = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public native void setLocale(String s);

    private static final String ALARMS_DIR = "/alarms/";
    private static final int DATE_MODIFIED_PLAYLISTS_COLUMN_INDEX = 2;
    private static final String DEFAULT_RINGTONE_PROPERTY_PREFIX = "ro.config.";
    private static final boolean ENABLE_BULK_INSERTS = true;
    private static final int FILES_PRESCAN_DATE_MODIFIED_COLUMN_INDEX = 3;
    private static final int FILES_PRESCAN_FORMAT_COLUMN_INDEX = 2;
    private static final int FILES_PRESCAN_ID_COLUMN_INDEX = 0;
    private static final int FILES_PRESCAN_PATH_COLUMN_INDEX = 1;
    private static final String FILES_PRESCAN_PROJECTION[];
    private static final String ID3_GENRES[];
    private static final int ID_PLAYLISTS_COLUMN_INDEX = 0;
    private static final String ID_PROJECTION[];
    private static final String MUSIC_DIR = "/music/";
    private static final String NOTIFICATIONS_DIR = "/notifications/";
    private static final int PATH_PLAYLISTS_COLUMN_INDEX = 1;
    private static final String PLAYLIST_MEMBERS_PROJECTION[];
    private static final String PODCAST_DIR = "/podcasts/";
    private static final String RINGTONES_DIR = "/ringtones/";
    private static final String TAG = "MediaScanner";
    private Uri mAudioUri;
    private final android.graphics.BitmapFactory.Options mBitmapOptions = new android.graphics.BitmapFactory.Options();
    private boolean mCaseInsensitivePaths;
    private final MyMediaScannerClient mClient = new MyMediaScannerClient();
    private Context mContext;
    private String mDefaultAlarmAlertFilename;
    private boolean mDefaultAlarmSet;
    private String mDefaultNotificationFilename;
    private boolean mDefaultNotificationSet;
    private String mDefaultRingtoneFilename;
    private boolean mDefaultRingtoneSet;
    private DrmManagerClient mDrmManagerClient;
    private final String mExternalStoragePath = Environment.getExternalStorageDirectory().getAbsolutePath();
    private Uri mFilesUri;
    private Uri mImagesUri;
    private MediaInserter mMediaInserter;
    private IContentProvider mMediaProvider;
    private int mMtpObjectHandle;
    private int mNativeContext;
    private int mOriginalCount;
    private ArrayList mPlayLists;
    private ArrayList mPlaylistEntries;
    private Uri mPlaylistsUri;
    private boolean mProcessGenres;
    private boolean mProcessPlaylists;
    private Uri mThumbsUri;
    private Uri mVideoUri;
    private boolean mWasEmptyPriorToScan;

    static  {
        System.loadLibrary("media_jni");
        native_init();
        String as[] = new String[4];
        as[0] = "_id";
        as[1] = "_data";
        as[2] = "format";
        as[3] = "date_modified";
        FILES_PRESCAN_PROJECTION = as;
        String as1[] = new String[1];
        as1[0] = "_id";
        ID_PROJECTION = as1;
        String as2[] = new String[1];
        as2[0] = "playlist_id";
        PLAYLIST_MEMBERS_PROJECTION = as2;
        String as3[] = new String[148];
        as3[0] = "Blues";
        as3[1] = "Classic Rock";
        as3[2] = "Country";
        as3[3] = "Dance";
        as3[4] = "Disco";
        as3[5] = "Funk";
        as3[6] = "Grunge";
        as3[7] = "Hip-Hop";
        as3[8] = "Jazz";
        as3[9] = "Metal";
        as3[10] = "New Age";
        as3[11] = "Oldies";
        as3[12] = "Other";
        as3[13] = "Pop";
        as3[14] = "R&B";
        as3[15] = "Rap";
        as3[16] = "Reggae";
        as3[17] = "Rock";
        as3[18] = "Techno";
        as3[19] = "Industrial";
        as3[20] = "Alternative";
        as3[21] = "Ska";
        as3[22] = "Death Metal";
        as3[23] = "Pranks";
        as3[24] = "Soundtrack";
        as3[25] = "Euro-Techno";
        as3[26] = "Ambient";
        as3[27] = "Trip-Hop";
        as3[28] = "Vocal";
        as3[29] = "Jazz+Funk";
        as3[30] = "Fusion";
        as3[31] = "Trance";
        as3[32] = "Classical";
        as3[33] = "Instrumental";
        as3[34] = "Acid";
        as3[35] = "House";
        as3[36] = "Game";
        as3[37] = "Sound Clip";
        as3[38] = "Gospel";
        as3[39] = "Noise";
        as3[40] = "AlternRock";
        as3[41] = "Bass";
        as3[42] = "Soul";
        as3[43] = "Punk";
        as3[44] = "Space";
        as3[45] = "Meditative";
        as3[46] = "Instrumental Pop";
        as3[47] = "Instrumental Rock";
        as3[48] = "Ethnic";
        as3[49] = "Gothic";
        as3[50] = "Darkwave";
        as3[51] = "Techno-Industrial";
        as3[52] = "Electronic";
        as3[53] = "Pop-Folk";
        as3[54] = "Eurodance";
        as3[55] = "Dream";
        as3[56] = "Southern Rock";
        as3[57] = "Comedy";
        as3[58] = "Cult";
        as3[59] = "Gangsta";
        as3[60] = "Top 40";
        as3[61] = "Christian Rap";
        as3[62] = "Pop/Funk";
        as3[63] = "Jungle";
        as3[64] = "Native American";
        as3[65] = "Cabaret";
        as3[66] = "New Wave";
        as3[67] = "Psychadelic";
        as3[68] = "Rave";
        as3[69] = "Showtunes";
        as3[70] = "Trailer";
        as3[71] = "Lo-Fi";
        as3[72] = "Tribal";
        as3[73] = "Acid Punk";
        as3[74] = "Acid Jazz";
        as3[75] = "Polka";
        as3[76] = "Retro";
        as3[77] = "Musical";
        as3[78] = "Rock & Roll";
        as3[79] = "Hard Rock";
        as3[80] = "Folk";
        as3[81] = "Folk-Rock";
        as3[82] = "National Folk";
        as3[83] = "Swing";
        as3[84] = "Fast Fusion";
        as3[85] = "Bebob";
        as3[86] = "Latin";
        as3[87] = "Revival";
        as3[88] = "Celtic";
        as3[89] = "Bluegrass";
        as3[90] = "Avantgarde";
        as3[91] = "Gothic Rock";
        as3[92] = "Progressive Rock";
        as3[93] = "Psychedelic Rock";
        as3[94] = "Symphonic Rock";
        as3[95] = "Slow Rock";
        as3[96] = "Big Band";
        as3[97] = "Chorus";
        as3[98] = "Easy Listening";
        as3[99] = "Acoustic";
        as3[100] = "Humour";
        as3[101] = "Speech";
        as3[102] = "Chanson";
        as3[103] = "Opera";
        as3[104] = "Chamber Music";
        as3[105] = "Sonata";
        as3[106] = "Symphony";
        as3[107] = "Booty Bass";
        as3[108] = "Primus";
        as3[109] = "Porn Groove";
        as3[110] = "Satire";
        as3[111] = "Slow Jam";
        as3[112] = "Club";
        as3[113] = "Tango";
        as3[114] = "Samba";
        as3[115] = "Folklore";
        as3[116] = "Ballad";
        as3[117] = "Power Ballad";
        as3[118] = "Rhythmic Soul";
        as3[119] = "Freestyle";
        as3[120] = "Duet";
        as3[121] = "Punk Rock";
        as3[122] = "Drum Solo";
        as3[123] = "A capella";
        as3[124] = "Euro-House";
        as3[125] = "Dance Hall";
        as3[126] = "Goa";
        as3[127] = "Drum & Bass";
        as3[128] = "Club-House";
        as3[129] = "Hardcore";
        as3[130] = "Terror";
        as3[131] = "Indie";
        as3[132] = "Britpop";
        as3[133] = "Negerpunk";
        as3[134] = "Polsk Punk";
        as3[135] = "Beat";
        as3[136] = "Christian Gangsta";
        as3[137] = "Heavy Metal";
        as3[138] = "Black Metal";
        as3[139] = "Crossover";
        as3[140] = "Contemporary Christian";
        as3[141] = "Christian Rock";
        as3[142] = "Merengue";
        as3[143] = "Salsa";
        as3[144] = "Thrash Metal";
        as3[145] = "Anime";
        as3[146] = "JPop";
        as3[147] = "Synthpop";
        ID3_GENRES = as3;
    }










/*
    static boolean access$1602(MediaScanner mediascanner, boolean flag) {
        mediascanner.mDefaultNotificationSet = flag;
        return flag;
    }

*/




/*
    static boolean access$1802(MediaScanner mediascanner, boolean flag) {
        mediascanner.mDefaultRingtoneSet = flag;
        return flag;
    }

*/





/*
    static boolean access$2002(MediaScanner mediascanner, boolean flag) {
        mediascanner.mDefaultAlarmSet = flag;
        return flag;
    }

*/






/*
    static DrmManagerClient access$2402(MediaScanner mediascanner, DrmManagerClient drmmanagerclient) {
        mediascanner.mDrmManagerClient = drmmanagerclient;
        return drmmanagerclient;
    }

*/








}
