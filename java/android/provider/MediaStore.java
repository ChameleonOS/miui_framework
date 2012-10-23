// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.provider;

import android.content.*;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteException;
import android.graphics.*;
import android.media.MiniThumbFile;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.*;

// Referenced classes of package android.provider:
//            BaseColumns

public final class MediaStore {
    public static final class Video {
        public static class Thumbnails
            implements BaseColumns {

            public static void cancelThumbnailRequest(ContentResolver contentresolver, long l) {
                InternalThumbnails.cancelThumbnailRequest(contentresolver, l, EXTERNAL_CONTENT_URI, 0L);
            }

            public static void cancelThumbnailRequest(ContentResolver contentresolver, long l, long l1) {
                InternalThumbnails.cancelThumbnailRequest(contentresolver, l, EXTERNAL_CONTENT_URI, l1);
            }

            public static Uri getContentUri(String s) {
                return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/video/thumbnails").toString());
            }

            public static Bitmap getThumbnail(ContentResolver contentresolver, long l, int i, android.graphics.BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(contentresolver, l, 0L, i, options, EXTERNAL_CONTENT_URI, true);
            }

            public static Bitmap getThumbnail(ContentResolver contentresolver, long l, long l1, int i, android.graphics.BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(contentresolver, l, l1, i, options, EXTERNAL_CONTENT_URI, true);
            }

            public static final String DATA = "_data";
            public static final String DEFAULT_SORT_ORDER = "video_id ASC";
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri("external");
            public static final int FULL_SCREEN_KIND = 2;
            public static final String HEIGHT = "height";
            public static final Uri INTERNAL_CONTENT_URI = getContentUri("internal");
            public static final String KIND = "kind";
            public static final int MICRO_KIND = 3;
            public static final int MINI_KIND = 1;
            public static final String VIDEO_ID = "video_id";
            public static final String WIDTH = "width";


            public Thumbnails() {
            }
        }

        public static final class Media
            implements VideoColumns {

            public static Uri getContentUri(String s) {
                return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/video/media").toString());
            }

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/video";
            public static final String DEFAULT_SORT_ORDER = "title";
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri("external");
            public static final Uri INTERNAL_CONTENT_URI = getContentUri("internal");


            public Media() {
            }
        }

        public static interface VideoColumns
            extends MediaColumns {

            public static final String ALBUM = "album";
            public static final String ARTIST = "artist";
            public static final String BOOKMARK = "bookmark";
            public static final String BUCKET_DISPLAY_NAME = "bucket_display_name";
            public static final String BUCKET_ID = "bucket_id";
            public static final String CATEGORY = "category";
            public static final String DATE_TAKEN = "datetaken";
            public static final String DESCRIPTION = "description";
            public static final String DURATION = "duration";
            public static final String IS_PRIVATE = "isprivate";
            public static final String LANGUAGE = "language";
            public static final String LATITUDE = "latitude";
            public static final String LONGITUDE = "longitude";
            public static final String MINI_THUMB_MAGIC = "mini_thumb_magic";
            public static final String RESOLUTION = "resolution";
            public static final String TAGS = "tags";
        }


        public static final Cursor query(ContentResolver contentresolver, Uri uri, String as[]) {
            return contentresolver.query(uri, as, null, null, "_display_name");
        }

        public static final String DEFAULT_SORT_ORDER = "_display_name";

        public Video() {
        }
    }

    public static final class Audio {
        public static final class Albums
            implements BaseColumns, AlbumColumns {

            public static Uri getContentUri(String s) {
                return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/audio/albums").toString());
            }

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/albums";
            public static final String DEFAULT_SORT_ORDER = "album_key";
            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/album";
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri("external");
            public static final Uri INTERNAL_CONTENT_URI = getContentUri("internal");


            public Albums() {
            }
        }

        public static interface AlbumColumns {

            public static final String ALBUM = "album";
            public static final String ALBUM_ART = "album_art";
            public static final String ALBUM_ID = "album_id";
            public static final String ALBUM_KEY = "album_key";
            public static final String ARTIST = "artist";
            public static final String FIRST_YEAR = "minyear";
            public static final String LAST_YEAR = "maxyear";
            public static final String NUMBER_OF_SONGS = "numsongs";
            public static final String NUMBER_OF_SONGS_FOR_ARTIST = "numsongs_by_artist";
        }

        public static final class Artists
            implements BaseColumns, ArtistColumns {
            public static final class Albums
                implements AlbumColumns {

                public static final Uri getContentUri(String s, long l) {
                    return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/audio/artists/").append(l).append("/albums").toString());
                }

                public Albums() {
                }
            }


            public static Uri getContentUri(String s) {
                return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/audio/artists").toString());
            }

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/artists";
            public static final String DEFAULT_SORT_ORDER = "artist_key";
            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/artist";
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri("external");
            public static final Uri INTERNAL_CONTENT_URI = getContentUri("internal");


            public Artists() {
            }
        }

        public static interface ArtistColumns {

            public static final String ARTIST = "artist";
            public static final String ARTIST_KEY = "artist_key";
            public static final String NUMBER_OF_ALBUMS = "number_of_albums";
            public static final String NUMBER_OF_TRACKS = "number_of_tracks";
        }

        public static final class Playlists
            implements BaseColumns, PlaylistsColumns {
            public static final class Members
                implements AudioColumns {

                public static final Uri getContentUri(String s, long l) {
                    return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/audio/playlists/").append(l).append("/members").toString());
                }

                public static final boolean moveItem(ContentResolver contentresolver, long l, int i, int j) {
                    Uri uri = getContentUri("external", l).buildUpon().appendEncodedPath(String.valueOf(i)).appendQueryParameter("move", "true").build();
                    ContentValues contentvalues = new ContentValues();
                    contentvalues.put("play_order", Integer.valueOf(j));
                    boolean flag;
                    if(contentresolver.update(uri, contentvalues, null, null) != 0)
                        flag = true;
                    else
                        flag = false;
                    return flag;
                }

                public static final String AUDIO_ID = "audio_id";
                public static final String CONTENT_DIRECTORY = "members";
                public static final String DEFAULT_SORT_ORDER = "play_order";
                public static final String PLAYLIST_ID = "playlist_id";
                public static final String PLAY_ORDER = "play_order";
                public static final String _ID = "_id";

                public Members() {
                }
            }


            public static Uri getContentUri(String s) {
                return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/audio/playlists").toString());
            }

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/playlist";
            public static final String DEFAULT_SORT_ORDER = "name";
            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/playlist";
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri("external");
            public static final Uri INTERNAL_CONTENT_URI = getContentUri("internal");


            public Playlists() {
            }
        }

        public static interface PlaylistsColumns {

            public static final String DATA = "_data";
            public static final String DATE_ADDED = "date_added";
            public static final String DATE_MODIFIED = "date_modified";
            public static final String NAME = "name";
        }

        public static final class Genres
            implements BaseColumns, GenresColumns {
            public static final class Members
                implements AudioColumns {

                public static final Uri getContentUri(String s, long l) {
                    return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/audio/genres/").append(l).append("/members").toString());
                }

                public static final String AUDIO_ID = "audio_id";
                public static final String CONTENT_DIRECTORY = "members";
                public static final String DEFAULT_SORT_ORDER = "title_key";
                public static final String GENRE_ID = "genre_id";

                public Members() {
                }
            }


            public static Uri getContentUri(String s) {
                return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/audio/genres").toString());
            }

            public static Uri getContentUriForAudioId(String s, int i) {
                return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/audio/media/").append(i).append("/genres").toString());
            }

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/genre";
            public static final String DEFAULT_SORT_ORDER = "name";
            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/genre";
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri("external");
            public static final Uri INTERNAL_CONTENT_URI = getContentUri("internal");


            public Genres() {
            }
        }

        public static interface GenresColumns {

            public static final String NAME = "name";
        }

        public static final class Media
            implements AudioColumns {

            public static Uri getContentUri(String s) {
                return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/audio/media").toString());
            }

            public static Uri getContentUriForPath(String s) {
                Uri uri;
                if(s.startsWith(Environment.getExternalStorageDirectory().getPath()))
                    uri = EXTERNAL_CONTENT_URI;
                else
                    uri = INTERNAL_CONTENT_URI;
                return uri;
            }

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/audio";
            public static final String DEFAULT_SORT_ORDER = "title_key";
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri("external");
            public static final String EXTRA_MAX_BYTES = "android.provider.MediaStore.extra.MAX_BYTES";
            public static final Uri INTERNAL_CONTENT_URI = getContentUri("internal");
            public static final String RECORD_SOUND_ACTION = "android.provider.MediaStore.RECORD_SOUND";


            public Media() {
            }
        }

        public static interface AudioColumns
            extends MediaColumns {

            public static final String ALBUM = "album";
            public static final String ALBUM_ARTIST = "album_artist";
            public static final String ALBUM_ID = "album_id";
            public static final String ALBUM_KEY = "album_key";
            public static final String ARTIST = "artist";
            public static final String ARTIST_ID = "artist_id";
            public static final String ARTIST_KEY = "artist_key";
            public static final String BOOKMARK = "bookmark";
            public static final String COMPILATION = "compilation";
            public static final String COMPOSER = "composer";
            public static final String DURATION = "duration";
            public static final String GENRE = "genre";
            public static final String IS_ALARM = "is_alarm";
            public static final String IS_MUSIC = "is_music";
            public static final String IS_NOTIFICATION = "is_notification";
            public static final String IS_PODCAST = "is_podcast";
            public static final String IS_RINGTONE = "is_ringtone";
            public static final String TITLE_KEY = "title_key";
            public static final String TRACK = "track";
            public static final String YEAR = "year";
        }


        public static String keyFor(String s) {
            if(s == null) goto _L2; else goto _L1
_L1:
            boolean flag = false;
            if(!s.equals("<unknown>")) goto _L4; else goto _L3
_L3:
            String s1 = "\001";
_L6:
            return s1;
_L4:
            if(s.startsWith("\001"))
                flag = true;
            String s2 = s.trim().toLowerCase();
            if(s2.startsWith("the "))
                s2 = s2.substring(4);
            if(s2.startsWith("an "))
                s2 = s2.substring(3);
            if(s2.startsWith("a "))
                s2 = s2.substring(2);
            if(s2.endsWith(", the") || s2.endsWith(",the") || s2.endsWith(", an") || s2.endsWith(",an") || s2.endsWith(", a") || s2.endsWith(",a"))
                s2 = s2.substring(0, s2.lastIndexOf(','));
            String s3 = s2.replaceAll("[\\[\\]\\(\\)\"'.,?!]", "").trim();
            if(s3.length() > 0) {
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append('.');
                int i = s3.length();
                for(int j = 0; j < i; j++) {
                    stringbuilder.append(s3.charAt(j));
                    stringbuilder.append('.');
                }

                s1 = DatabaseUtils.getCollationKey(stringbuilder.toString());
                if(flag)
                    s1 = (new StringBuilder()).append("\001").append(s1).toString();
            } else {
                s1 = "";
            }
            continue; /* Loop/switch isn't completed */
_L2:
            s1 = null;
            if(true) goto _L6; else goto _L5
_L5:
        }

        public Audio() {
        }
    }

    public static final class Images {
        public static class Thumbnails
            implements BaseColumns {

            public static void cancelThumbnailRequest(ContentResolver contentresolver, long l) {
                InternalThumbnails.cancelThumbnailRequest(contentresolver, l, EXTERNAL_CONTENT_URI, 0L);
            }

            public static void cancelThumbnailRequest(ContentResolver contentresolver, long l, long l1) {
                InternalThumbnails.cancelThumbnailRequest(contentresolver, l, EXTERNAL_CONTENT_URI, l1);
            }

            public static Uri getContentUri(String s) {
                return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/images/thumbnails").toString());
            }

            public static Bitmap getThumbnail(ContentResolver contentresolver, long l, int i, android.graphics.BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(contentresolver, l, 0L, i, options, EXTERNAL_CONTENT_URI, false);
            }

            public static Bitmap getThumbnail(ContentResolver contentresolver, long l, long l1, int i, android.graphics.BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(contentresolver, l, l1, i, options, EXTERNAL_CONTENT_URI, false);
            }

            public static final Cursor query(ContentResolver contentresolver, Uri uri, String as[]) {
                return contentresolver.query(uri, as, null, null, "image_id ASC");
            }

            public static final Cursor queryMiniThumbnail(ContentResolver contentresolver, long l, int i, String as[]) {
                return contentresolver.query(EXTERNAL_CONTENT_URI, as, (new StringBuilder()).append("image_id = ").append(l).append(" AND ").append("kind").append(" = ").append(i).toString(), null, null);
            }

            public static final Cursor queryMiniThumbnails(ContentResolver contentresolver, Uri uri, int i, String as[]) {
                return contentresolver.query(uri, as, (new StringBuilder()).append("kind = ").append(i).toString(), null, "image_id ASC");
            }

            public static final String DATA = "_data";
            public static final String DEFAULT_SORT_ORDER = "image_id ASC";
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri("external");
            public static final int FULL_SCREEN_KIND = 2;
            public static final String HEIGHT = "height";
            public static final String IMAGE_ID = "image_id";
            public static final Uri INTERNAL_CONTENT_URI = getContentUri("internal");
            public static final String KIND = "kind";
            public static final int MICRO_KIND = 3;
            public static final int MINI_KIND = 1;
            public static final String THUMB_DATA = "thumb_data";
            public static final String WIDTH = "width";


            public Thumbnails() {
            }
        }

        public static final class Media
            implements ImageColumns {

            private static final Bitmap StoreThumbnail(ContentResolver contentresolver, Bitmap bitmap, long l, float f, float f1, int i) {
                Matrix matrix = new Matrix();
                matrix.setScale(f / (float)bitmap.getWidth(), f1 / (float)bitmap.getHeight());
                Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                ContentValues contentvalues = new ContentValues(4);
                contentvalues.put("kind", Integer.valueOf(i));
                contentvalues.put("image_id", Integer.valueOf((int)l));
                contentvalues.put("height", Integer.valueOf(bitmap1.getHeight()));
                contentvalues.put("width", Integer.valueOf(bitmap1.getWidth()));
                Uri uri = contentresolver.insert(Thumbnails.EXTERNAL_CONTENT_URI, contentvalues);
                try {
                    OutputStream outputstream = contentresolver.openOutputStream(uri);
                    bitmap1.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, outputstream);
                    outputstream.close();
                }
                catch(FileNotFoundException filenotfoundexception) {
                    bitmap1 = null;
                }
                catch(IOException ioexception) {
                    bitmap1 = null;
                }
                return bitmap1;
            }

            public static final Bitmap getBitmap(ContentResolver contentresolver, Uri uri) throws FileNotFoundException, IOException {
                InputStream inputstream = contentresolver.openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputstream);
                inputstream.close();
                return bitmap;
            }

            public static Uri getContentUri(String s) {
                return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/images/media").toString());
            }

            public static final String insertImage(ContentResolver contentresolver, Bitmap bitmap, String s, String s1) {
                ContentValues contentvalues;
                Uri uri;
                String s2;
                contentvalues = new ContentValues();
                contentvalues.put("title", s);
                contentvalues.put("description", s1);
                contentvalues.put("mime_type", "image/jpeg");
                uri = null;
                s2 = null;
                uri = contentresolver.insert(EXTERNAL_CONTENT_URI, contentvalues);
                if(bitmap == null) goto _L2; else goto _L1
_L1:
                OutputStream outputstream = contentresolver.openOutputStream(uri);
                bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 50, outputstream);
                outputstream.close();
                long l = ContentUris.parseId(uri);
                StoreThumbnail(contentresolver, Thumbnails.getThumbnail(contentresolver, l, 1, null), l, 50F, 50F, 3);
_L4:
                if(uri != null)
                    s2 = uri.toString();
                return s2;
                Exception exception1;
                exception1;
                try {
                    outputstream.close();
                    throw exception1;
                }
                catch(Exception exception) {
                    Log.e("MediaStore", "Failed to insert image", exception);
                }
                if(uri != null) {
                    contentresolver.delete(uri, null, null);
                    uri = null;
                }
                continue; /* Loop/switch isn't completed */
_L2:
                Log.e("MediaStore", "Failed to create thumbnail, removing original");
                contentresolver.delete(uri, null, null);
                uri = null;
                if(true) goto _L4; else goto _L3
_L3:
            }

            public static final String insertImage(ContentResolver contentresolver, String s, String s1, String s2) throws FileNotFoundException {
                FileInputStream fileinputstream = new FileInputStream(s);
                String s3;
                Bitmap bitmap = BitmapFactory.decodeFile(s);
                s3 = insertImage(contentresolver, bitmap, s1, s2);
                bitmap.recycle();
                Exception exception;
                try {
                    fileinputstream.close();
                }
                catch(IOException ioexception1) { }
                return s3;
                exception;
                try {
                    fileinputstream.close();
                }
                catch(IOException ioexception) { }
                throw exception;
            }

            public static final Cursor query(ContentResolver contentresolver, Uri uri, String as[]) {
                return contentresolver.query(uri, as, null, null, "bucket_display_name");
            }

            public static final Cursor query(ContentResolver contentresolver, Uri uri, String as[], String s, String s1) {
                String s2;
                if(s1 == null)
                    s2 = "bucket_display_name";
                else
                    s2 = s1;
                return contentresolver.query(uri, as, s, null, s2);
            }

            public static final Cursor query(ContentResolver contentresolver, Uri uri, String as[], String s, String as1[], String s1) {
                String s2;
                if(s1 == null)
                    s2 = "bucket_display_name";
                else
                    s2 = s1;
                return contentresolver.query(uri, as, s, as1, s2);
            }

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/image";
            public static final String DEFAULT_SORT_ORDER = "bucket_display_name";
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri("external");
            public static final Uri INTERNAL_CONTENT_URI = getContentUri("internal");


            public Media() {
            }
        }

        public static interface ImageColumns
            extends MediaColumns {

            public static final String BUCKET_DISPLAY_NAME = "bucket_display_name";
            public static final String BUCKET_ID = "bucket_id";
            public static final String DATE_TAKEN = "datetaken";
            public static final String DESCRIPTION = "description";
            public static final String IS_PRIVATE = "isprivate";
            public static final String LATITUDE = "latitude";
            public static final String LONGITUDE = "longitude";
            public static final String MINI_THUMB_MAGIC = "mini_thumb_magic";
            public static final String ORIENTATION = "orientation";
            public static final String PICASA_ID = "picasa_id";
        }


        public Images() {
        }
    }

    private static class InternalThumbnails
        implements BaseColumns {

        static void cancelThumbnailRequest(ContentResolver contentresolver, long l, Uri uri, long l1) {
            Uri uri1 = uri.buildUpon().appendQueryParameter("cancel", "1").appendQueryParameter("orig_id", String.valueOf(l)).appendQueryParameter("group_id", String.valueOf(l1)).build();
            Cursor cursor = contentresolver.query(uri1, PROJECTION, null, null, null);
            if(cursor != null)
                cursor.close();
            return;
            Exception exception;
            exception;
            if(false)
                null.close();
            throw exception;
        }

        private static Bitmap getMiniThumbFromFile(Cursor cursor, Uri uri, ContentResolver contentresolver, android.graphics.BitmapFactory.Options options) {
            Bitmap bitmap = null;
            Uri uri1 = null;
            try {
                long l = cursor.getLong(0);
                cursor.getString(1);
                uri1 = ContentUris.withAppendedId(uri, l);
                ParcelFileDescriptor parcelfiledescriptor = contentresolver.openFileDescriptor(uri1, "r");
                bitmap = BitmapFactory.decodeFileDescriptor(parcelfiledescriptor.getFileDescriptor(), null, options);
                parcelfiledescriptor.close();
            }
            catch(FileNotFoundException filenotfoundexception) {
                Log.e("MediaStore", (new StringBuilder()).append("couldn't open thumbnail ").append(uri1).append("; ").append(filenotfoundexception).toString());
            }
            catch(IOException ioexception) {
                Log.e("MediaStore", (new StringBuilder()).append("couldn't open thumbnail ").append(uri1).append("; ").append(ioexception).toString());
            }
            catch(OutOfMemoryError outofmemoryerror) {
                Log.e("MediaStore", (new StringBuilder()).append("failed to allocate memory for thumbnail ").append(uri1).append("; ").append(outofmemoryerror).toString());
            }
            return bitmap;
        }

        static Bitmap getThumbnail(ContentResolver contentresolver, long l, long l1, int i, android.graphics.BitmapFactory.Options options, Uri uri, 
                boolean flag) {
            Bitmap bitmap;
            String s;
            MiniThumbFile minithumbfile;
            Cursor cursor;
            Bitmap bitmap1;
            bitmap = null;
            s = null;
            Uri uri1;
            if(flag)
                uri1 = Video.Media.EXTERNAL_CONTENT_URI;
            else
                uri1 = Images.Media.EXTERNAL_CONTENT_URI;
            minithumbfile = new MiniThumbFile(uri1);
            cursor = null;
            if(minithumbfile.getMagic(l) == 0L) goto _L2; else goto _L1
_L1:
            if(i != 3) goto _L4; else goto _L3
_L3:
            synchronized(sThumbBufLock) {
                if(sThumbBuf == null)
                    sThumbBuf = new byte[10000];
                if(minithumbfile.getMiniThumbFromFile(l, sThumbBuf) != null) {
                    bitmap = BitmapFactory.decodeByteArray(sThumbBuf, 0, sThumbBuf.length);
                    if(bitmap == null)
                        Log.w("MediaStore", "couldn't decode byte array.");
                }
            }
            if(false)
                null.close();
            minithumbfile.deactivate();
            bitmap1 = bitmap;
_L5:
            return bitmap1;
            exception2;
            obj1;
            JVM INSTR monitorexit ;
            throw exception2;
            SQLiteException sqliteexception;
            sqliteexception;
            Log.w("MediaStore", sqliteexception);
            if(cursor != null)
                cursor.close();
            minithumbfile.deactivate();
_L26:
            bitmap1 = bitmap;
              goto _L5
_L4:
            if(i != 1) goto _L2; else goto _L6
_L6:
            if(!flag) goto _L8; else goto _L7
_L7:
            String s1 = "video_id=";
_L11:
            cursor = contentresolver.query(uri, PROJECTION, (new StringBuilder()).append(s1).append(l).toString(), null, null);
            if(cursor == null || !cursor.moveToFirst()) goto _L2; else goto _L9
_L9:
            Bitmap bitmap4 = getMiniThumbFromFile(cursor, uri, contentresolver, options);
            bitmap = bitmap4;
            if(bitmap == null) goto _L2; else goto _L10
_L10:
            if(cursor != null)
                cursor.close();
            minithumbfile.deactivate();
            bitmap1 = bitmap;
              goto _L5
_L8:
            s1 = "image_id=";
              goto _L11
_L2:
            Cursor cursor1;
            Uri uri2 = uri.buildUpon().appendQueryParameter("blocking", "1").appendQueryParameter("orig_id", String.valueOf(l)).appendQueryParameter("group_id", String.valueOf(l1)).build();
            if(cursor != null)
                cursor.close();
            cursor1 = contentresolver.query(uri2, PROJECTION, null, null, null);
label0:
            {
                cursor = cursor1;
                if(cursor != null)
                    break label0;
                bitmap1 = null;
                if(cursor != null)
                    cursor.close();
                minithumbfile.deactivate();
            }
            if(true) goto _L5; else goto _L12
_L12:
            if(i != 3) goto _L14; else goto _L13
_L13:
            synchronized(sThumbBufLock) {
                if(sThumbBuf == null)
                    sThumbBuf = new byte[10000];
                if(minithumbfile.getMiniThumbFromFile(l, sThumbBuf) != null) {
                    bitmap = BitmapFactory.decodeByteArray(sThumbBuf, 0, sThumbBuf.length);
                    if(bitmap == null)
                        Log.w("MediaStore", "couldn't decode byte array.");
                }
            }
_L23:
            if(bitmap != null) goto _L16; else goto _L15
_L15:
            Uri uri3;
            Log.v("MediaStore", (new StringBuilder()).append("Create the thumbnail in memory: origId=").append(l).append(", kind=").append(i).append(", isVideo=").append(flag).toString());
            uri3 = Uri.parse(uri.buildUpon().appendPath(String.valueOf(l)).toString().replaceFirst("thumbnails", "media"));
            if(false) goto _L18; else goto _L17
_L17:
            if(cursor != null)
                cursor.close();
            cursor = contentresolver.query(uri3, PROJECTION, null, null, null);
            if(cursor == null) goto _L20; else goto _L19
_L19:
            boolean flag1 = cursor.moveToFirst();
            if(flag1) goto _L21; else goto _L20
_L20:
            bitmap1 = null;
            if(cursor != null)
                cursor.close();
            minithumbfile.deactivate();
              goto _L5
            exception1;
            obj;
            JVM INSTR monitorexit ;
            throw exception1;
            Exception exception;
            exception;
            if(cursor != null)
                cursor.close();
            minithumbfile.deactivate();
            throw exception;
_L14:
            if(i != 1)
                break MISSING_BLOCK_LABEL_668;
            if(!cursor.moveToFirst()) goto _L23; else goto _L22
_L22:
            bitmap = getMiniThumbFromFile(cursor, uri, contentresolver, options);
              goto _L23
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported kind: ").append(i).toString());
_L21:
            s = cursor.getString(1);
_L18:
            if(!flag) goto _L25; else goto _L24
_L24:
            Bitmap bitmap3 = ThumbnailUtils.createVideoThumbnail(s, i);
            bitmap = bitmap3;
_L16:
            if(cursor != null)
                cursor.close();
            minithumbfile.deactivate();
              goto _L26
_L25:
            Bitmap bitmap2 = ThumbnailUtils.createImageThumbnail(s, i);
            bitmap = bitmap2;
              goto _L16
        }

        static final int DEFAULT_GROUP_ID = 0;
        private static final int FULL_SCREEN_KIND = 2;
        private static final int MICRO_KIND = 3;
        private static final int MINI_KIND = 1;
        private static final String PROJECTION[];
        private static byte sThumbBuf[];
        private static final Object sThumbBufLock = new Object();

        static  {
            String as[] = new String[2];
            as[0] = "_id";
            as[1] = "_data";
            PROJECTION = as;
        }

        private InternalThumbnails() {
        }
    }

    public static final class Files {
        public static interface FileColumns
            extends MediaColumns {

            public static final String FORMAT = "format";
            public static final String MEDIA_TYPE = "media_type";
            public static final int MEDIA_TYPE_AUDIO = 2;
            public static final int MEDIA_TYPE_IMAGE = 1;
            public static final int MEDIA_TYPE_NONE = 0;
            public static final int MEDIA_TYPE_PLAYLIST = 4;
            public static final int MEDIA_TYPE_VIDEO = 3;
            public static final String MIME_TYPE = "mime_type";
            public static final String PARENT = "parent";
            public static final String STORAGE_ID = "storage_id";
            public static final String TITLE = "title";
        }


        public static Uri getContentUri(String s) {
            return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/file").toString());
        }

        public static final Uri getContentUri(String s, long l) {
            return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/file/").append(l).toString());
        }

        public static Uri getMtpObjectsUri(String s) {
            return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/object").toString());
        }

        public static final Uri getMtpObjectsUri(String s, long l) {
            return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/object/").append(l).toString());
        }

        public static final Uri getMtpReferencesUri(String s, long l) {
            return Uri.parse((new StringBuilder()).append("content://media/").append(s).append("/object/").append(l).append("/references").toString());
        }

        public Files() {
        }
    }

    public static interface MediaColumns
        extends BaseColumns {

        public static final String DATA = "_data";
        public static final String DATE_ADDED = "date_added";
        public static final String DATE_MODIFIED = "date_modified";
        public static final String DISPLAY_NAME = "_display_name";
        public static final String HEIGHT = "height";
        public static final String IS_DRM = "is_drm";
        public static final String MEDIA_SCANNER_NEW_OBJECT_ID = "media_scanner_new_object_id";
        public static final String MIME_TYPE = "mime_type";
        public static final String SIZE = "_size";
        public static final String TITLE = "title";
        public static final String WIDTH = "width";
    }


    public MediaStore() {
    }

    public static Uri getMediaScannerUri() {
        return Uri.parse("content://media/none/media_scanner");
    }

    public static String getVersion(Context context) {
        String s;
        Cursor cursor;
        s = null;
        cursor = context.getContentResolver().query(Uri.parse("content://media/none/version"), null, null, null, null);
        if(cursor == null) goto _L2; else goto _L1
_L1:
        if(!cursor.moveToFirst()) goto _L4; else goto _L3
_L3:
        String s1 = cursor.getString(0);
        s = s1;
        cursor.close();
_L2:
        return s;
_L4:
        cursor.close();
        if(true) goto _L2; else goto _L5
_L5:
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    public static final String ACTION_IMAGE_CAPTURE = "android.media.action.IMAGE_CAPTURE";
    public static final String ACTION_MTP_SESSION_END = "android.provider.action.MTP_SESSION_END";
    public static final String ACTION_VIDEO_CAPTURE = "android.media.action.VIDEO_CAPTURE";
    public static final String AUTHORITY = "media";
    private static final String CONTENT_AUTHORITY_SLASH = "content://media/";
    public static final String EXTRA_DURATION_LIMIT = "android.intent.extra.durationLimit";
    public static final String EXTRA_FINISH_ON_COMPLETION = "android.intent.extra.finishOnCompletion";
    public static final String EXTRA_FULL_SCREEN = "android.intent.extra.fullScreen";
    public static final String EXTRA_MEDIA_ALBUM = "android.intent.extra.album";
    public static final String EXTRA_MEDIA_ARTIST = "android.intent.extra.artist";
    public static final String EXTRA_MEDIA_FOCUS = "android.intent.extra.focus";
    public static final String EXTRA_MEDIA_TITLE = "android.intent.extra.title";
    public static final String EXTRA_OUTPUT = "output";
    public static final String EXTRA_SCREEN_ORIENTATION = "android.intent.extra.screenOrientation";
    public static final String EXTRA_SHOW_ACTION_ICONS = "android.intent.extra.showActionIcons";
    public static final String EXTRA_SIZE_LIMIT = "android.intent.extra.sizeLimit";
    public static final String EXTRA_VIDEO_QUALITY = "android.intent.extra.videoQuality";
    public static final String INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH = "android.media.action.MEDIA_PLAY_FROM_SEARCH";
    public static final String INTENT_ACTION_MEDIA_SEARCH = "android.intent.action.MEDIA_SEARCH";
    public static final String INTENT_ACTION_MUSIC_PLAYER = "android.intent.action.MUSIC_PLAYER";
    public static final String INTENT_ACTION_STILL_IMAGE_CAMERA = "android.media.action.STILL_IMAGE_CAMERA";
    public static final String INTENT_ACTION_VIDEO_CAMERA = "android.media.action.VIDEO_CAMERA";
    public static final String MEDIA_IGNORE_FILENAME = ".nomedia";
    public static final String MEDIA_SCANNER_VOLUME = "volume";
    public static final String PARAM_DELETE_DATA = "deletedata";
    private static final String TAG = "MediaStore";
    public static final String UNHIDE_CALL = "unhide";
    public static final String UNKNOWN_STRING = "<unknown>";
}
