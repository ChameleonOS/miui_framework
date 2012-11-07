// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.*;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import java.io.*;
import java.util.WeakHashMap;

// Referenced classes of package android.widget:
//            ResourceCursorAdapter, CursorAdapter, Filter, ImageView, 
//            TextView, SearchView

class SuggestionsAdapter extends ResourceCursorAdapter
    implements android.view.View.OnClickListener {
    private static final class ChildViewCache {

        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View view) {
            mText1 = (TextView)view.findViewById(0x1020014);
            mText2 = (TextView)view.findViewById(0x1020015);
            mIcon1 = (ImageView)view.findViewById(0x1020007);
            mIcon2 = (ImageView)view.findViewById(0x1020008);
            mIconRefine = (ImageView)view.findViewById(0x1020327);
        }
    }

    static class Injector {

        static Drawable getDrawable(PackageManager packagemanager, String s, int i, ActivityInfo activityinfo) {
            return activityinfo.loadIcon(packagemanager);
        }

        Injector() {
        }
    }


    public SuggestionsAdapter(Context context, SearchView searchview, SearchableInfo searchableinfo, WeakHashMap weakhashmap) {
        super(context, 0x10900a1, null, true);
        mClosed = false;
        mQueryRefinement = 1;
        mText1Col = -1;
        mText2Col = -1;
        mText2UrlCol = -1;
        mIconName1Col = -1;
        mIconName2Col = -1;
        mFlagsCol = -1;
        mSearchManager = (SearchManager)super.mContext.getSystemService("search");
        mSearchView = searchview;
        mSearchable = searchableinfo;
        Context context1 = mSearchable.getActivityContext(super.mContext);
        mProviderContext = mSearchable.getProviderContext(super.mContext, context1);
        mOutsideDrawablesCache = weakhashmap;
        getFilter().setDelayer(new Filter.Delayer() {

            public long getPostingDelay(CharSequence charsequence) {
                long l = 0L;
                if(charsequence != null) {
                    if(charsequence.length() < mPreviousLength)
                        l = 500L;
                    mPreviousLength = charsequence.length();
                }
                return l;
            }

            private int mPreviousLength;
            final SuggestionsAdapter this$0;

             {
                this$0 = SuggestionsAdapter.this;
                super();
                mPreviousLength = 0;
            }
        });
    }

    private Drawable checkIconCache(String s) {
        android.graphics.drawable.Drawable.ConstantState constantstate = (android.graphics.drawable.Drawable.ConstantState)mOutsideDrawablesCache.get(s);
        Drawable drawable;
        if(constantstate == null)
            drawable = null;
        else
            drawable = constantstate.newDrawable();
        return drawable;
    }

    private CharSequence formatUrl(CharSequence charsequence) {
        if(mUrlColor == null) {
            TypedValue typedvalue = new TypedValue();
            super.mContext.getTheme().resolveAttribute(0x1010267, typedvalue, true);
            mUrlColor = super.mContext.getResources().getColorStateList(typedvalue.resourceId);
        }
        SpannableString spannablestring = new SpannableString(charsequence);
        spannablestring.setSpan(new TextAppearanceSpan(null, 0, 0, mUrlColor, null), 0, charsequence.length(), 33);
        return spannablestring;
    }

    private Drawable getActivityIcon(ComponentName componentname) {
        PackageManager packagemanager;
        Drawable drawable;
        ActivityInfo activityinfo;
        int i;
        packagemanager = super.mContext.getPackageManager();
        try {
            activityinfo = packagemanager.getActivityInfo(componentname, 128);
        }
        catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) {
            Log.w("SuggestionsAdapter", namenotfoundexception.toString());
            drawable = null;
            continue; /* Loop/switch isn't completed */
        }
        i = activityinfo.getIconResource();
        if(i != 0) goto _L2; else goto _L1
_L1:
        drawable = null;
_L4:
        return drawable;
_L2:
        drawable = Injector.getDrawable(packagemanager, componentname.getPackageName(), i, activityinfo);
        if(drawable == null) {
            Log.w("SuggestionsAdapter", (new StringBuilder()).append("Invalid icon resource ").append(i).append(" for ").append(componentname.flattenToShortString()).toString());
            drawable = null;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private Drawable getActivityIconWithCache(ComponentName componentname) {
        Drawable drawable = null;
        String s = componentname.flattenToShortString();
        if(mOutsideDrawablesCache.containsKey(s)) {
            android.graphics.drawable.Drawable.ConstantState constantstate1 = (android.graphics.drawable.Drawable.ConstantState)mOutsideDrawablesCache.get(s);
            if(constantstate1 != null)
                drawable = constantstate1.newDrawable(mProviderContext.getResources());
        } else {
            Drawable drawable1 = getActivityIcon(componentname);
            android.graphics.drawable.Drawable.ConstantState constantstate;
            if(drawable1 == null)
                constantstate = null;
            else
                constantstate = drawable1.getConstantState();
            mOutsideDrawablesCache.put(s, constantstate);
            drawable = drawable1;
        }
        return drawable;
    }

    public static String getColumnString(Cursor cursor, String s) {
        return getStringOrNull(cursor, cursor.getColumnIndex(s));
    }

    private Drawable getDefaultIcon1(Cursor cursor) {
        Drawable drawable = getActivityIconWithCache(mSearchable.getSearchActivity());
        if(drawable == null)
            drawable = super.mContext.getPackageManager().getDefaultActivityIcon();
        return drawable;
    }

    private Drawable getDrawable(Uri uri) {
        if(!"android.resource".equals(uri.getScheme())) goto _L2; else goto _L1
_L1:
        android.content.ContentResolver.OpenResourceIdResult openresourceidresult = mProviderContext.getContentResolver().getResourceId(uri);
        Drawable drawable;
        Drawable drawable2;
        try {
            drawable2 = openresourceidresult.r.getDrawable(openresourceidresult.id);
        }
        catch(android.content.res.Resources.NotFoundException notfoundexception) {
            try {
                throw new FileNotFoundException((new StringBuilder()).append("Resource does not exist: ").append(uri).toString());
            }
            catch(FileNotFoundException filenotfoundexception) {
                Log.w("SuggestionsAdapter", (new StringBuilder()).append("Icon not found: ").append(uri).append(", ").append(filenotfoundexception.getMessage()).toString());
            }
            drawable = null;
            continue; /* Loop/switch isn't completed */
        }
        drawable = drawable2;
_L4:
        return drawable;
_L2:
        InputStream inputstream;
        inputstream = mProviderContext.getContentResolver().openInputStream(uri);
        if(inputstream == null)
            throw new FileNotFoundException((new StringBuilder()).append("Failed to open ").append(uri).toString());
        Drawable drawable1 = Drawable.createFromStream(inputstream, null);
        drawable = drawable1;
        inputstream.close();
        continue; /* Loop/switch isn't completed */
        IOException ioexception1;
        ioexception1;
        Log.e("SuggestionsAdapter", (new StringBuilder()).append("Error closing icon stream for ").append(uri).toString(), ioexception1);
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        try {
            inputstream.close();
        }
        catch(IOException ioexception) {
            Log.e("SuggestionsAdapter", (new StringBuilder()).append("Error closing icon stream for ").append(uri).toString(), ioexception);
        }
        throw exception;
    }

    private Drawable getDrawableFromResourceValue(String s) {
        if(s != null && s.length() != 0 && !"0".equals(s)) goto _L2; else goto _L1
_L1:
        Drawable drawable = null;
_L4:
        return drawable;
_L2:
        try {
            int i = Integer.parseInt(s);
            String s1 = (new StringBuilder()).append("android.resource://").append(mProviderContext.getPackageName()).append("/").append(i).toString();
            drawable = checkIconCache(s1);
            if(drawable == null) {
                drawable = mProviderContext.getResources().getDrawable(i);
                storeInIconCache(s1, drawable);
            }
        }
        catch(NumberFormatException numberformatexception) {
            drawable = checkIconCache(s);
            if(drawable == null) {
                drawable = getDrawable(Uri.parse(s));
                storeInIconCache(s, drawable);
            }
        }
        catch(android.content.res.Resources.NotFoundException notfoundexception) {
            Log.w("SuggestionsAdapter", (new StringBuilder()).append("Icon resource not found: ").append(s).toString());
            drawable = null;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private Drawable getIcon1(Cursor cursor) {
        if(mIconName1Col != -1) goto _L2; else goto _L1
_L1:
        Drawable drawable = null;
_L4:
        return drawable;
_L2:
        drawable = getDrawableFromResourceValue(cursor.getString(mIconName1Col));
        if(drawable == null)
            drawable = getDefaultIcon1(cursor);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private Drawable getIcon2(Cursor cursor) {
        Drawable drawable;
        if(mIconName2Col == -1)
            drawable = null;
        else
            drawable = getDrawableFromResourceValue(cursor.getString(mIconName2Col));
        return drawable;
    }

    private static String getStringOrNull(Cursor cursor, int i) {
        String s = null;
        if(i != -1) goto _L2; else goto _L1
_L1:
        return s;
_L2:
        String s1 = cursor.getString(i);
        s = s1;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", exception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void setViewDrawable(ImageView imageview, Drawable drawable, int i) {
        imageview.setImageDrawable(drawable);
        if(drawable == null) {
            imageview.setVisibility(i);
        } else {
            imageview.setVisibility(0);
            drawable.setVisible(false, false);
            drawable.setVisible(true, false);
        }
    }

    private void setViewText(TextView textview, CharSequence charsequence) {
        textview.setText(charsequence);
        if(TextUtils.isEmpty(charsequence))
            textview.setVisibility(8);
        else
            textview.setVisibility(0);
    }

    private void storeInIconCache(String s, Drawable drawable) {
        if(drawable != null)
            mOutsideDrawablesCache.put(s, drawable.getConstantState());
    }

    private void updateSpinnerState(Cursor cursor) {
        Bundle bundle;
        if(cursor != null)
            bundle = cursor.getExtras();
        else
            bundle = null;
        if(bundle != null)
            if(!bundle.getBoolean("in_progress"));
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ChildViewCache childviewcache;
        int i;
        childviewcache = (ChildViewCache)view.getTag();
        i = 0;
        if(mFlagsCol != -1)
            i = cursor.getInt(mFlagsCol);
        if(childviewcache.mText1 != null) {
            String s1 = getStringOrNull(cursor, mText1Col);
            setViewText(childviewcache.mText1, s1);
        }
        if(childviewcache.mText2 == null) goto _L2; else goto _L1
_L1:
        String s = getStringOrNull(cursor, mText2UrlCol);
        Object obj;
        if(s != null)
            obj = formatUrl(s);
        else
            obj = getStringOrNull(cursor, mText2Col);
        if(!TextUtils.isEmpty(((CharSequence) (obj)))) goto _L4; else goto _L3
_L3:
        if(childviewcache.mText1 != null) {
            childviewcache.mText1.setSingleLine(false);
            childviewcache.mText1.setMaxLines(2);
        }
_L6:
        setViewText(childviewcache.mText2, ((CharSequence) (obj)));
_L2:
        if(childviewcache.mIcon1 != null)
            setViewDrawable(childviewcache.mIcon1, getIcon1(cursor), 4);
        if(childviewcache.mIcon2 != null)
            setViewDrawable(childviewcache.mIcon2, getIcon2(cursor), 8);
        if(mQueryRefinement == 2 || mQueryRefinement == 1 && (i & 1) != 0) {
            childviewcache.mIconRefine.setVisibility(0);
            childviewcache.mIconRefine.setTag(childviewcache.mText1.getText());
            childviewcache.mIconRefine.setOnClickListener(this);
        } else {
            childviewcache.mIconRefine.setVisibility(8);
        }
        return;
_L4:
        if(childviewcache.mText1 != null) {
            childviewcache.mText1.setSingleLine(true);
            childviewcache.mText1.setMaxLines(1);
        }
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void changeCursor(Cursor cursor) {
        if(!mClosed) goto _L2; else goto _L1
_L1:
        Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
        if(cursor != null)
            cursor.close();
_L4:
        return;
_L2:
        try {
            super.changeCursor(cursor);
            if(cursor != null) {
                mText1Col = cursor.getColumnIndex("suggest_text_1");
                mText2Col = cursor.getColumnIndex("suggest_text_2");
                mText2UrlCol = cursor.getColumnIndex("suggest_text_2_url");
                mIconName1Col = cursor.getColumnIndex("suggest_icon_1");
                mIconName2Col = cursor.getColumnIndex("suggest_icon_2");
                mFlagsCol = cursor.getColumnIndex("suggest_flags");
            }
        }
        catch(Exception exception) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", exception);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void close() {
        changeCursor(null);
        mClosed = true;
    }

    public CharSequence convertToString(Cursor cursor) {
        if(cursor != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((CharSequence) (obj));
_L2:
        obj = getColumnString(cursor, "suggest_intent_query");
        if(obj != null)
            continue; /* Loop/switch isn't completed */
        if(mSearchable.shouldRewriteQueryFromData()) {
            String s1 = getColumnString(cursor, "suggest_intent_data");
            if(s1 != null) {
                obj = s1;
                continue; /* Loop/switch isn't completed */
            }
        }
        if(mSearchable.shouldRewriteQueryFromText()) {
            String s = getColumnString(cursor, "suggest_text_1");
            if(s != null) {
                obj = s;
                continue; /* Loop/switch isn't completed */
            }
        }
        obj = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getQueryRefinement() {
        return mQueryRefinement;
    }

    public View getView(int i, View view, ViewGroup viewgroup) {
        View view2 = super.getView(i, view, viewgroup);
        View view1 = view2;
_L2:
        return view1;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", runtimeexception);
        view1 = newView(super.mContext, super.mCursor, viewgroup);
        if(view1 != null)
            ((ChildViewCache)view1.getTag()).mText1.setText(runtimeexception.toString());
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean hasStableIds() {
        return false;
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup) {
        View view = super.newView(context, cursor, viewgroup);
        view.setTag(new ChildViewCache(view));
        return view;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        updateSpinnerState(getCursor());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        updateSpinnerState(getCursor());
    }

    public void onClick(View view) {
        Object obj = view.getTag();
        if(obj instanceof CharSequence)
            mSearchView.onQueryRefine((CharSequence)obj);
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charsequence) {
        Cursor cursor;
        String s;
        cursor = null;
        if(charsequence == null)
            s = "";
        else
            s = charsequence.toString();
        if(mSearchView.getVisibility() == 0 && mSearchView.getWindowVisibility() == 0) goto _L2; else goto _L1
_L1:
        return cursor;
_L2:
        Cursor cursor1;
        cursor1 = mSearchManager.getSuggestions(mSearchable, s, 50);
        if(cursor1 == null)
            continue; /* Loop/switch isn't completed */
        cursor1.getCount();
        cursor = cursor1;
        continue; /* Loop/switch isn't completed */
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", runtimeexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setQueryRefinement(int i) {
        mQueryRefinement = i;
    }

    private static final boolean DBG = false;
    private static final long DELETE_KEY_POST_DELAY = 500L;
    static final int INVALID_INDEX = -1;
    private static final String LOG_TAG = "SuggestionsAdapter";
    private static final int QUERY_LIMIT = 50;
    static final int REFINE_ALL = 2;
    static final int REFINE_BY_ENTRY = 1;
    static final int REFINE_NONE;
    private boolean mClosed;
    private int mFlagsCol;
    private int mIconName1Col;
    private int mIconName2Col;
    private WeakHashMap mOutsideDrawablesCache;
    private Context mProviderContext;
    private int mQueryRefinement;
    private SearchManager mSearchManager;
    private SearchView mSearchView;
    private SearchableInfo mSearchable;
    private int mText1Col;
    private int mText2Col;
    private int mText2UrlCol;
    private ColorStateList mUrlColor;
}
