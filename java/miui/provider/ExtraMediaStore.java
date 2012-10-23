// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.provider;


public final class ExtraMediaStore {
    public static class Audio {
        public static interface Albums {

            public static final String ALBUM_SORT_KEY_PRIMARY = "album_sort_key";
        }

        public static interface Artists {

            public static final String ARTIST_SORT_KEY_PRIMARY = "artist_sort_key";
        }

        public static interface Media {

            public static final String ALBUM_SORT_KEY_PRIMARY = "album_sort_key";
            public static final String ARTIST_SORT_KEY_PRIMARY = "artist_sort_key";
            public static final String SORT_KEY_PRIMARY = "sort_key";
        }


        public Audio() {
        }
    }


    public ExtraMediaStore() {
    }

    private static final String TAG = "ExtraMediaStore";
}
