// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;


public interface PlayerActions {
    public static interface Out {
        public static interface LyricStatus {

            public static final int FAILED = 2;
            public static final int IDLE = 0;
            public static final int INVISIBLE = 1;
            public static final int NETWORK_ERROR = 5;
            public static final int SEARCHING = 4;
            public static final int SEARCH_DENIED = 6;
            public static final int SUCCESS = 3;
        }


        public static final String ACTION_LOCKSRECCN_UPDATE = "lockscreen.action.SONG_METADATA_UPDATED";
        public static final String KEY_ALBUM = "album";
        public static final String KEY_ALBUM_PATH = "album_path";
        public static final String KEY_ALBUM_URI = "album_uri";
        public static final String KEY_ARTIST = "artist";
        public static final String KEY_BLOCKING = "blocking";
        public static final String KEY_BUFFERED_POS = "buffered_pos";
        public static final String KEY_BUFFERING = "buffering";
        public static final String KEY_CALLBACK_WRAP = "callback_wrap";
        public static final String KEY_CHANNEL_NAME = "channel_name";
        public static final String KEY_DURATION = "duration";
        public static final String KEY_FAVORITE = "favorite";
        public static final String KEY_ID = "id";
        public static final String KEY_LYRIC = "lyric";
        public static final String KEY_LYRIC_STATUS = "lyric_status";
        public static final String KEY_LYRIC_TIME = "lyric_time";
        public static final String KEY_MUSIC_SHOW = "is_showmusic";
        public static final String KEY_ONLINE_ID = "online_id";
        public static final String KEY_OTHER = "other";
        public static final String KEY_PLAYING = "playing";
        public static final String KEY_POSITION = "position";
        public static final String KEY_TEMP_ALBUM_PATH = "tmp_album_path";
        public static final String KEY_TIME_STAMP = "time_stamp";
        public static final String KEY_TRACK = "track";
        public static final String KEY_UPDATE_VERSION = "update_version";
        public static final String META_CHANGED_ALBUM = "meta_changed_album";
        public static final String META_CHANGED_BUFFERED_OVER = "meta_changed_buffer";
        public static final String META_CHANGED_LYRIC = "meta_changed_lyric";
        public static final String META_CHANGED_TRACK = "meta_changed_track";
        public static final String STATUS_META_CHANGED = "com.miui.player.metachanged";
        public static final String STATUS_PLAYBACK_COMPLETE = "com.miui.player.playbackcomplete";
        public static final String STATUS_PLAYSTATE_CHANGED = "com.miui.player.playstatechanged";
        public static final String STATUS_QUEUE_CHANGED = "com.miui.player.queuechanged";
        public static final String STATUS_REFRESH_PROGRESS = "com.miui.player.refreshprogress";
    }

    public static interface In {

        public static final String ACTION_LOCKSCREEN_REQUEST = "lockscreen.action.SONG_METADATA_REQUEST";
        public static final String ACTION_MUSIC_MAIN = "android.intent.action.MIUI_MUSIC_PLAYER";
        public static final String ACTION_MUSIC_META = "com.miui.player.MUSIC_META";
        public static final String ACTION_MUSIC_NOWPLAYING_PLAYLIST = "com.miui.player.NOWPLAYING_PLAYLIST";
        public static final String ACTION_MUSIC_ONLINE_SEARCH = "com.miui.player.ONLINE_SEARCH";
        public static final String ACTION_MUSIC_PLAYBACK_VIEWER = "com.miui.player.PLAYBACK_VIEWER";
        public static final String ACTION_NEXT = "com.miui.player.musicservicecommand.next";
        public static final String ACTION_PREVIOUS = "com.miui.player.musicservicecommand.previous";
        public static final String ACTION_REMOVE = "com.miui.player.remove";
        public static final String ACTION_REQUEST_PREGRESS = "com.miui.player.requestprogress";
        public static final String ACTION_REQUEST_STATUS = "com.miui.player.requeststatus";
        public static final String ACTION_SEEK = "com.miui.player.seek";
        public static final String ACTION_TOGGLEFAVORITE = "com.miui.player.togglefavorite";
        public static final String ACTION_TOGGLEPAUSE = "com.miui.player.musicservicecommand.togglepause";
        public static final String KEY_APPEND = "music_meta_append";
        public static final String KEY_CALLBACK_DATA = "callback_data";
        public static final String KEY_CALLBACK_NAME = "callback_name";
        public static final String KEY_LOACAL_ID = "local_id";
        public static final String KEY_MUSIC_META_ARRAY = "music_meta_data";
        public static final String KEY_MUSIC_META_POSITION = "music_meta_data_pos";
        public static final String KEY_ONLINE_ID = "online_id";
        public static final String KEY_ONLINE_SEARCH = "search_key";
        public static final String KEY_REMOVE_ID = "remove_id";
        public static final String KEY_SEEK_POSITION = "seek_position";
    }


    public static final String BROADCAST_PREFIX = "com.miui.player";
}
