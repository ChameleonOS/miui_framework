// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.net.Uri;
import android.os.*;
import android.util.*;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.util.*;
import org.xmlpull.v1.*;

// Referenced classes of package android.content:
//            Intent, ContentResolver

public class IntentFilter
    implements Parcelable {
    public static final class AuthorityEntry {

        public String getHost() {
            return mOrigHost;
        }

        public int getPort() {
            return mPort;
        }

        public int match(Uri uri) {
            int i;
            String s;
            i = -2;
            s = uri.getHost();
            if(s != null) goto _L2; else goto _L1
_L1:
            return i;
_L2:
            if(mWild) {
                if(s.length() < mHost.length())
                    continue; /* Loop/switch isn't completed */
                s = s.substring(s.length() - mHost.length());
            }
            if(s.compareToIgnoreCase(mHost) == 0)
                if(mPort >= 0) {
                    if(mPort == uri.getPort())
                        i = 0x400000;
                } else {
                    i = 0x300000;
                }
            if(true) goto _L1; else goto _L3
_L3:
        }

        void writeToParcel(Parcel parcel) {
            parcel.writeString(mOrigHost);
            parcel.writeString(mHost);
            int i;
            if(mWild)
                i = 1;
            else
                i = 0;
            parcel.writeInt(i);
            parcel.writeInt(mPort);
        }

        private final String mHost;
        private final String mOrigHost;
        private final int mPort;
        private final boolean mWild;




        AuthorityEntry(Parcel parcel) {
            mOrigHost = parcel.readString();
            mHost = parcel.readString();
            boolean flag;
            if(parcel.readInt() != 0)
                flag = true;
            else
                flag = false;
            mWild = flag;
            mPort = parcel.readInt();
        }

        public AuthorityEntry(String s, String s1) {
            boolean flag = false;
            super();
            mOrigHost = s;
            if(s.length() > 0 && s.charAt(0) == '*')
                flag = true;
            mWild = flag;
            if(mWild)
                s = s.substring(1).intern();
            mHost = s;
            int i;
            if(s1 != null)
                i = Integer.parseInt(s1);
            else
                i = -1;
            mPort = i;
        }
    }

    public static class MalformedMimeTypeException extends AndroidException {

        public MalformedMimeTypeException() {
        }

        public MalformedMimeTypeException(String s) {
            super(s);
        }
    }


    public IntentFilter() {
        mCategories = null;
        mDataSchemes = null;
        mDataAuthorities = null;
        mDataPaths = null;
        mDataTypes = null;
        mHasPartialTypes = false;
        mPriority = 0;
        mActions = new ArrayList();
    }

    public IntentFilter(IntentFilter intentfilter) {
        mCategories = null;
        mDataSchemes = null;
        mDataAuthorities = null;
        mDataPaths = null;
        mDataTypes = null;
        mHasPartialTypes = false;
        mPriority = intentfilter.mPriority;
        mActions = new ArrayList(intentfilter.mActions);
        if(intentfilter.mCategories != null)
            mCategories = new ArrayList(intentfilter.mCategories);
        if(intentfilter.mDataTypes != null)
            mDataTypes = new ArrayList(intentfilter.mDataTypes);
        if(intentfilter.mDataSchemes != null)
            mDataSchemes = new ArrayList(intentfilter.mDataSchemes);
        if(intentfilter.mDataAuthorities != null)
            mDataAuthorities = new ArrayList(intentfilter.mDataAuthorities);
        if(intentfilter.mDataPaths != null)
            mDataPaths = new ArrayList(intentfilter.mDataPaths);
        mHasPartialTypes = intentfilter.mHasPartialTypes;
    }

    private IntentFilter(Parcel parcel) {
        boolean flag = false;
        super();
        mCategories = null;
        mDataSchemes = null;
        mDataAuthorities = null;
        mDataPaths = null;
        mDataTypes = null;
        mHasPartialTypes = false;
        mActions = new ArrayList();
        parcel.readStringList(mActions);
        if(parcel.readInt() != 0) {
            mCategories = new ArrayList();
            parcel.readStringList(mCategories);
        }
        if(parcel.readInt() != 0) {
            mDataSchemes = new ArrayList();
            parcel.readStringList(mDataSchemes);
        }
        if(parcel.readInt() != 0) {
            mDataTypes = new ArrayList();
            parcel.readStringList(mDataTypes);
        }
        int i = parcel.readInt();
        if(i > 0) {
            mDataAuthorities = new ArrayList();
            for(int l = 0; l < i; l++)
                mDataAuthorities.add(new AuthorityEntry(parcel));

        }
        int j = parcel.readInt();
        if(j > 0) {
            mDataPaths = new ArrayList();
            for(int k = 0; k < j; k++)
                mDataPaths.add(new PatternMatcher(parcel));

        }
        mPriority = parcel.readInt();
        if(parcel.readInt() > 0)
            flag = true;
        mHasPartialTypes = flag;
    }


    public IntentFilter(String s) {
        mCategories = null;
        mDataSchemes = null;
        mDataAuthorities = null;
        mDataPaths = null;
        mDataTypes = null;
        mHasPartialTypes = false;
        mPriority = 0;
        mActions = new ArrayList();
        addAction(s);
    }

    public IntentFilter(String s, String s1) throws MalformedMimeTypeException {
        mCategories = null;
        mDataSchemes = null;
        mDataAuthorities = null;
        mDataPaths = null;
        mDataTypes = null;
        mHasPartialTypes = false;
        mPriority = 0;
        mActions = new ArrayList();
        addAction(s);
        addDataType(s1);
    }

    private static String[] addStringToSet(String as[], String s, int ai[], int i) {
        if(findStringInSet(as, s, ai, i) < 0)
            if(as == null) {
                as = new String[2];
                as[0] = s;
                ai[i] = 1;
            } else {
                int j = ai[i];
                if(j < as.length) {
                    as[j] = s;
                    ai[i] = j + 1;
                } else {
                    String as1[] = new String[2 + (j * 3) / 2];
                    System.arraycopy(as, 0, as1, 0, j);
                    as = as1;
                    as[j] = s;
                    ai[i] = j + 1;
                }
            }
        return as;
    }

    public static IntentFilter create(String s, String s1) {
        IntentFilter intentfilter;
        try {
            intentfilter = new IntentFilter(s, s1);
        }
        catch(MalformedMimeTypeException malformedmimetypeexception) {
            throw new RuntimeException("Bad MIME type", malformedmimetypeexception);
        }
        return intentfilter;
    }

    private final boolean findMimeType(String s) {
        boolean flag;
        ArrayList arraylist;
        flag = true;
        arraylist = mDataTypes;
        if(s != null) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if(arraylist.contains(s))
            continue; /* Loop/switch isn't completed */
        int i = s.length();
        if(i == 3 && s.equals("*/*")) {
            if(arraylist.isEmpty())
                flag = false;
            continue; /* Loop/switch isn't completed */
        }
        if(mHasPartialTypes && arraylist.contains("*"))
            continue; /* Loop/switch isn't completed */
        int j = s.indexOf('/');
        if(j > 0) {
            if(mHasPartialTypes && arraylist.contains(s.substring(0, j)))
                continue; /* Loop/switch isn't completed */
            if(i == j + 2 && s.charAt(j + 1) == '*') {
                int k = arraylist.size();
                for(int l = 0; l < k; l++)
                    if(s.regionMatches(0, (String)arraylist.get(l), 0, j + 1))
                        continue; /* Loop/switch isn't completed */

            }
        }
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static int findStringInSet(String as[], String s, int ai[], int i) {
        if(as != null) goto _L2; else goto _L1
_L1:
        int k = -1;
_L4:
        return k;
_L2:
        int j = ai[i];
        for(k = 0; k < j; k++)
            if(as[k].equals(s))
                continue; /* Loop/switch isn't completed */

        k = -1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static String[] removeStringFromSet(String as[], String s, int ai[], int i) {
        int j = findStringInSet(as, s, ai, i);
        if(j >= 0) {
            int k = ai[i];
            if(k > as.length / 4) {
                int l = k - (j + 1);
                if(l > 0)
                    System.arraycopy(as, j + 1, as, j, l);
                as[k - 1] = null;
                ai[i] = k - 1;
            } else {
                String as1[] = new String[as.length / 3];
                if(j > 0)
                    System.arraycopy(as, 0, as1, 0, j);
                if(j + 1 < k)
                    System.arraycopy(as, j + 1, as1, j, k - (j + 1));
                as = as1;
            }
        }
        return as;
    }

    public final Iterator actionsIterator() {
        Iterator iterator;
        if(mActions != null)
            iterator = mActions.iterator();
        else
            iterator = null;
        return iterator;
    }

    public final void addAction(String s) {
        if(!mActions.contains(s))
            mActions.add(s.intern());
    }

    public final void addCategory(String s) {
        if(mCategories == null)
            mCategories = new ArrayList();
        if(!mCategories.contains(s))
            mCategories.add(s.intern());
    }

    public final void addDataAuthority(String s, String s1) {
        if(mDataAuthorities == null)
            mDataAuthorities = new ArrayList();
        if(s1 != null)
            s1 = s1.intern();
        mDataAuthorities.add(new AuthorityEntry(s.intern(), s1));
    }

    public final void addDataPath(String s, int i) {
        if(mDataPaths == null)
            mDataPaths = new ArrayList();
        mDataPaths.add(new PatternMatcher(s.intern(), i));
    }

    public final void addDataScheme(String s) {
        if(mDataSchemes == null)
            mDataSchemes = new ArrayList();
        if(!mDataSchemes.contains(s))
            mDataSchemes.add(s.intern());
    }

    public final void addDataType(String s) throws MalformedMimeTypeException {
        int i;
        int j;
        i = s.indexOf('/');
        j = s.length();
        if(i <= 0 || j < i + 2) goto _L2; else goto _L1
_L1:
        if(mDataTypes == null)
            mDataTypes = new ArrayList();
        if(j != i + 2 || s.charAt(i + 1) != '*') goto _L4; else goto _L3
_L3:
        String s1 = s.substring(0, i);
        if(!mDataTypes.contains(s1))
            mDataTypes.add(s1.intern());
        mHasPartialTypes = true;
_L5:
        return;
_L4:
        if(!mDataTypes.contains(s))
            mDataTypes.add(s.intern());
        if(true) goto _L5; else goto _L2
_L2:
        throw new MalformedMimeTypeException(s);
    }

    public final Iterator authoritiesIterator() {
        Iterator iterator;
        if(mDataAuthorities != null)
            iterator = mDataAuthorities.iterator();
        else
            iterator = null;
        return iterator;
    }

    public final Iterator categoriesIterator() {
        Iterator iterator;
        if(mCategories != null)
            iterator = mCategories.iterator();
        else
            iterator = null;
        return iterator;
    }

    public final int countActions() {
        return mActions.size();
    }

    public final int countCategories() {
        int i;
        if(mCategories != null)
            i = mCategories.size();
        else
            i = 0;
        return i;
    }

    public final int countDataAuthorities() {
        int i;
        if(mDataAuthorities != null)
            i = mDataAuthorities.size();
        else
            i = 0;
        return i;
    }

    public final int countDataPaths() {
        int i;
        if(mDataPaths != null)
            i = mDataPaths.size();
        else
            i = 0;
        return i;
    }

    public final int countDataSchemes() {
        int i;
        if(mDataSchemes != null)
            i = mDataSchemes.size();
        else
            i = 0;
        return i;
    }

    public final int countDataTypes() {
        int i;
        if(mDataTypes != null)
            i = mDataTypes.size();
        else
            i = 0;
        return i;
    }

    public boolean debugCheck() {
        return true;
    }

    public final int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String s) {
        StringBuilder stringbuilder = new StringBuilder(256);
        if(mActions.size() > 0) {
            for(Iterator iterator5 = mActions.iterator(); iterator5.hasNext(); printer.println(stringbuilder.toString())) {
                stringbuilder.setLength(0);
                stringbuilder.append(s);
                stringbuilder.append("Action: \"");
                stringbuilder.append((String)iterator5.next());
                stringbuilder.append("\"");
            }

        }
        if(mCategories != null) {
            for(Iterator iterator4 = mCategories.iterator(); iterator4.hasNext(); printer.println(stringbuilder.toString())) {
                stringbuilder.setLength(0);
                stringbuilder.append(s);
                stringbuilder.append("Category: \"");
                stringbuilder.append((String)iterator4.next());
                stringbuilder.append("\"");
            }

        }
        if(mDataSchemes != null) {
            for(Iterator iterator3 = mDataSchemes.iterator(); iterator3.hasNext(); printer.println(stringbuilder.toString())) {
                stringbuilder.setLength(0);
                stringbuilder.append(s);
                stringbuilder.append("Scheme: \"");
                stringbuilder.append((String)iterator3.next());
                stringbuilder.append("\"");
            }

        }
        if(mDataAuthorities != null) {
            for(Iterator iterator2 = mDataAuthorities.iterator(); iterator2.hasNext(); printer.println(stringbuilder.toString())) {
                AuthorityEntry authorityentry = (AuthorityEntry)iterator2.next();
                stringbuilder.setLength(0);
                stringbuilder.append(s);
                stringbuilder.append("Authority: \"");
                stringbuilder.append(authorityentry.mHost);
                stringbuilder.append("\": ");
                stringbuilder.append(authorityentry.mPort);
                if(authorityentry.mWild)
                    stringbuilder.append(" WILD");
            }

        }
        if(mDataPaths != null) {
            for(Iterator iterator1 = mDataPaths.iterator(); iterator1.hasNext(); printer.println(stringbuilder.toString())) {
                PatternMatcher patternmatcher = (PatternMatcher)iterator1.next();
                stringbuilder.setLength(0);
                stringbuilder.append(s);
                stringbuilder.append("Path: \"");
                stringbuilder.append(patternmatcher);
                stringbuilder.append("\"");
            }

        }
        if(mDataTypes != null) {
            for(Iterator iterator = mDataTypes.iterator(); iterator.hasNext(); printer.println(stringbuilder.toString())) {
                stringbuilder.setLength(0);
                stringbuilder.append(s);
                stringbuilder.append("Type: \"");
                stringbuilder.append((String)iterator.next());
                stringbuilder.append("\"");
            }

        }
        if(mPriority != 0 || mHasPartialTypes) {
            stringbuilder.setLength(0);
            stringbuilder.append(s);
            stringbuilder.append("mPriority=");
            stringbuilder.append(mPriority);
            stringbuilder.append(", mHasPartialTypes=");
            stringbuilder.append(mHasPartialTypes);
            printer.println(stringbuilder.toString());
        }
    }

    public final String getAction(int i) {
        return (String)mActions.get(i);
    }

    public final String getCategory(int i) {
        return (String)mCategories.get(i);
    }

    public final AuthorityEntry getDataAuthority(int i) {
        return (AuthorityEntry)mDataAuthorities.get(i);
    }

    public final PatternMatcher getDataPath(int i) {
        return (PatternMatcher)mDataPaths.get(i);
    }

    public final String getDataScheme(int i) {
        return (String)mDataSchemes.get(i);
    }

    public final String getDataType(int i) {
        return (String)mDataTypes.get(i);
    }

    public final int getPriority() {
        return mPriority;
    }

    public final boolean hasAction(String s) {
        boolean flag;
        if(s != null && mActions.contains(s))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean hasCategory(String s) {
        boolean flag;
        if(mCategories != null && mCategories.contains(s))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean hasDataAuthority(Uri uri) {
        boolean flag;
        if(matchDataAuthority(uri) >= 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean hasDataPath(String s) {
        boolean flag = false;
        if(mDataPaths != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i = mDataPaths.size();
        int j = 0;
        do {
            if(j < i) {
label0:
                {
                    if(!((PatternMatcher)mDataPaths.get(j)).match(s))
                        break label0;
                    flag = true;
                }
            }
            if(true)
                continue;
            j++;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public final boolean hasDataScheme(String s) {
        boolean flag;
        if(mDataSchemes != null && mDataSchemes.contains(s))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean hasDataType(String s) {
        boolean flag;
        if(mDataTypes != null && findMimeType(s))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final int match(ContentResolver contentresolver, Intent intent, boolean flag, String s) {
        String s1;
        if(flag)
            s1 = intent.resolveType(contentresolver);
        else
            s1 = intent.getType();
        return match(intent.getAction(), s1, intent.getScheme(), intent.getData(), intent.getCategories(), s);
    }

    public final int match(String s, String s1, String s2, Uri uri, Set set, String s3) {
        if(s == null || matchAction(s)) goto _L2; else goto _L1
_L1:
        int i = -3;
_L4:
        return i;
_L2:
        i = matchData(s1, s2, uri);
        if(i >= 0 && matchCategories(set) != null)
            i = -4;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final boolean matchAction(String s) {
        return hasAction(s);
    }

    public final String matchCategories(Set set) {
        String s = null;
        if(set != null) goto _L2; else goto _L1
_L1:
        return s;
_L2:
        Iterator iterator = set.iterator();
        if(mCategories == null) {
            if(iterator.hasNext())
                s = (String)iterator.next();
            continue; /* Loop/switch isn't completed */
        }
        String s1;
        do {
            if(!iterator.hasNext())
                continue; /* Loop/switch isn't completed */
            s1 = (String)iterator.next();
        } while(mCategories.contains(s1));
        s = s1;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public final int matchData(String s, String s1, Uri uri) {
        int i;
        ArrayList arraylist;
        ArrayList arraylist1;
        ArrayList arraylist2;
        ArrayList arraylist3;
        int j;
        i = -2;
        arraylist = mDataTypes;
        arraylist1 = mDataSchemes;
        arraylist2 = mDataAuthorities;
        arraylist3 = mDataPaths;
        j = 0x100000;
        if(arraylist != null || arraylist1 != null) goto _L2; else goto _L1
_L1:
        if(s == null && uri == null)
            i = 0x108000;
_L14:
        return i;
_L2:
        if(arraylist1 == null) goto _L4; else goto _L3
_L3:
        if(s1 == null)
            s1 = "";
        if(!arraylist1.contains(s1))
            continue; /* Loop/switch isn't completed */
        j = 0x200000;
        if(arraylist2 != null) {
            int k = matchDataAuthority(uri);
            if(k < 0)
                continue; /* Loop/switch isn't completed */
            if(arraylist3 == null) {
                j = k;
            } else {
                if(!hasDataPath(uri.getPath()))
                    break; /* Loop/switch isn't completed */
                j = 0x500000;
            }
        }
_L10:
        if(arraylist == null) goto _L6; else goto _L5
_L5:
        if(!findMimeType(s)) goto _L8; else goto _L7
_L7:
        j = 0x600000;
_L12:
        i = 32768 + j;
        break; /* Loop/switch isn't completed */
_L4:
        if(s1 == null || "".equals(s1) || "content".equals(s1) || "file".equals(s1)) goto _L10; else goto _L9
_L9:
        continue; /* Loop/switch isn't completed */
_L8:
        i = -1;
        continue; /* Loop/switch isn't completed */
_L6:
        if(s == null) goto _L12; else goto _L11
_L11:
        i = -1;
        if(true) goto _L14; else goto _L13
_L13:
    }

    public final int matchDataAuthority(Uri uri) {
        if(mDataAuthorities != null) goto _L2; else goto _L1
_L1:
        int k = -2;
_L4:
        return k;
_L2:
        int i = mDataAuthorities.size();
        for(int j = 0; j < i; j++) {
            k = ((AuthorityEntry)mDataAuthorities.get(j)).match(uri);
            if(k >= 0)
                continue; /* Loop/switch isn't completed */
        }

        k = -2;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final Iterator pathsIterator() {
        Iterator iterator;
        if(mDataPaths != null)
            iterator = mDataPaths.iterator();
        else
            iterator = null;
        return iterator;
    }

    public void readFromXml(XmlPullParser xmlpullparser) throws XmlPullParserException, IOException {
        int i = xmlpullparser.getDepth();
        do {
            int j = xmlpullparser.next();
            if(j != 1 && (j != 3 || xmlpullparser.getDepth() > i)) {
                if(j != 3 && j != 4) {
                    String s = xmlpullparser.getName();
                    if(s.equals("action")) {
                        String s9 = xmlpullparser.getAttributeValue(null, "name");
                        if(s9 != null)
                            addAction(s9);
                    } else
                    if(s.equals("cat")) {
                        String s8 = xmlpullparser.getAttributeValue(null, "name");
                        if(s8 != null)
                            addCategory(s8);
                    } else
                    if(s.equals("type")) {
                        String s7 = xmlpullparser.getAttributeValue(null, "name");
                        if(s7 != null)
                            try {
                                addDataType(s7);
                            }
                            catch(MalformedMimeTypeException malformedmimetypeexception) { }
                    } else
                    if(s.equals("scheme")) {
                        String s6 = xmlpullparser.getAttributeValue(null, "name");
                        if(s6 != null)
                            addDataScheme(s6);
                    } else
                    if(s.equals("auth")) {
                        String s4 = xmlpullparser.getAttributeValue(null, "host");
                        String s5 = xmlpullparser.getAttributeValue(null, "port");
                        if(s4 != null)
                            addDataAuthority(s4, s5);
                    } else
                    if(s.equals("path")) {
                        String s1 = xmlpullparser.getAttributeValue(null, "literal");
                        if(s1 != null) {
                            addDataPath(s1, 0);
                        } else {
                            String s2 = xmlpullparser.getAttributeValue(null, "prefix");
                            if(s2 != null) {
                                addDataPath(s2, 1);
                            } else {
                                String s3 = xmlpullparser.getAttributeValue(null, "sglob");
                                if(s3 != null)
                                    addDataPath(s3, 2);
                            }
                        }
                    } else {
                        Log.w("IntentFilter", (new StringBuilder()).append("Unknown tag parsing IntentFilter: ").append(s).toString());
                    }
                    XmlUtils.skipCurrentTag(xmlpullparser);
                }
            } else {
                return;
            }
        } while(true);
    }

    public final Iterator schemesIterator() {
        Iterator iterator;
        if(mDataSchemes != null)
            iterator = mDataSchemes.iterator();
        else
            iterator = null;
        return iterator;
    }

    public final void setPriority(int i) {
        mPriority = i;
    }

    public final Iterator typesIterator() {
        Iterator iterator;
        if(mDataTypes != null)
            iterator = mDataTypes.iterator();
        else
            iterator = null;
        return iterator;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(mActions);
        if(mCategories != null) {
            parcel.writeInt(1);
            parcel.writeStringList(mCategories);
        } else {
            parcel.writeInt(0);
        }
        if(mDataSchemes != null) {
            parcel.writeInt(1);
            parcel.writeStringList(mDataSchemes);
        } else {
            parcel.writeInt(0);
        }
        if(mDataTypes != null) {
            parcel.writeInt(1);
            parcel.writeStringList(mDataTypes);
        } else {
            parcel.writeInt(0);
        }
        if(mDataAuthorities != null) {
            int i1 = mDataAuthorities.size();
            parcel.writeInt(i1);
            for(int j1 = 0; j1 < i1; j1++)
                ((AuthorityEntry)mDataAuthorities.get(j1)).writeToParcel(parcel);

        } else {
            parcel.writeInt(0);
        }
        if(mDataPaths != null) {
            int k = mDataPaths.size();
            parcel.writeInt(k);
            for(int l = 0; l < k; l++)
                ((PatternMatcher)mDataPaths.get(l)).writeToParcel(parcel, 0);

        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(mPriority);
        int j;
        if(mHasPartialTypes)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
    }

    public void writeToXml(XmlSerializer xmlserializer) throws IOException {
        int k2;
        int l2;
        int i = countActions();
        for(int j = 0; j < i; j++) {
            xmlserializer.startTag(null, "action");
            xmlserializer.attribute(null, "name", (String)mActions.get(j));
            xmlserializer.endTag(null, "action");
        }

        int k = countCategories();
        for(int l = 0; l < k; l++) {
            xmlserializer.startTag(null, "cat");
            xmlserializer.attribute(null, "name", (String)mCategories.get(l));
            xmlserializer.endTag(null, "cat");
        }

        int i1 = countDataTypes();
        for(int j1 = 0; j1 < i1; j1++) {
            xmlserializer.startTag(null, "type");
            String s = (String)mDataTypes.get(j1);
            if(s.indexOf('/') < 0)
                s = (new StringBuilder()).append(s).append("/*").toString();
            xmlserializer.attribute(null, "name", s);
            xmlserializer.endTag(null, "type");
        }

        int k1 = countDataSchemes();
        for(int l1 = 0; l1 < k1; l1++) {
            xmlserializer.startTag(null, "scheme");
            xmlserializer.attribute(null, "name", (String)mDataSchemes.get(l1));
            xmlserializer.endTag(null, "scheme");
        }

        int i2 = countDataAuthorities();
        for(int j2 = 0; j2 < i2; j2++) {
            xmlserializer.startTag(null, "auth");
            AuthorityEntry authorityentry = (AuthorityEntry)mDataAuthorities.get(j2);
            xmlserializer.attribute(null, "host", authorityentry.getHost());
            if(authorityentry.getPort() >= 0)
                xmlserializer.attribute(null, "port", Integer.toString(authorityentry.getPort()));
            xmlserializer.endTag(null, "auth");
        }

        k2 = countDataPaths();
        l2 = 0;
_L6:
        PatternMatcher patternmatcher;
        if(l2 >= k2)
            break MISSING_BLOCK_LABEL_526;
        xmlserializer.startTag(null, "path");
        patternmatcher = (PatternMatcher)mDataPaths.get(l2);
        patternmatcher.getType();
        JVM INSTR tableswitch 0 2: default 456
    //                   0 472
    //                   1 490
    //                   2 508;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_508;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L7:
        xmlserializer.endTag(null, "path");
        l2++;
        if(true) goto _L6; else goto _L5
_L5:
        xmlserializer.attribute(null, "literal", patternmatcher.getPath());
          goto _L7
_L3:
        xmlserializer.attribute(null, "prefix", patternmatcher.getPath());
          goto _L7
        xmlserializer.attribute(null, "sglob", patternmatcher.getPath());
          goto _L7
    }

    private static final String ACTION_STR = "action";
    private static final String AUTH_STR = "auth";
    private static final String CAT_STR = "cat";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public IntentFilter createFromParcel(Parcel parcel) {
            return new IntentFilter(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public IntentFilter[] newArray(int i) {
            return new IntentFilter[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final String HOST_STR = "host";
    private static final String LITERAL_STR = "literal";
    public static final int MATCH_ADJUSTMENT_MASK = 65535;
    public static final int MATCH_ADJUSTMENT_NORMAL = 32768;
    public static final int MATCH_CATEGORY_EMPTY = 0x100000;
    public static final int MATCH_CATEGORY_HOST = 0x300000;
    public static final int MATCH_CATEGORY_MASK = 0xfff0000;
    public static final int MATCH_CATEGORY_PATH = 0x500000;
    public static final int MATCH_CATEGORY_PORT = 0x400000;
    public static final int MATCH_CATEGORY_SCHEME = 0x200000;
    public static final int MATCH_CATEGORY_TYPE = 0x600000;
    private static final String NAME_STR = "name";
    public static final int NO_MATCH_ACTION = -3;
    public static final int NO_MATCH_CATEGORY = -4;
    public static final int NO_MATCH_DATA = -2;
    public static final int NO_MATCH_TYPE = -1;
    private static final String PATH_STR = "path";
    private static final String PORT_STR = "port";
    private static final String PREFIX_STR = "prefix";
    private static final String SCHEME_STR = "scheme";
    private static final String SGLOB_STR = "sglob";
    public static final int SYSTEM_HIGH_PRIORITY = 1000;
    public static final int SYSTEM_LOW_PRIORITY = -1000;
    private static final String TYPE_STR = "type";
    private final ArrayList mActions;
    private ArrayList mCategories;
    private ArrayList mDataAuthorities;
    private ArrayList mDataPaths;
    private ArrayList mDataSchemes;
    private ArrayList mDataTypes;
    private boolean mHasPartialTypes;
    private int mPriority;

}
