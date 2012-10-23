// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charsets;
import java.util.*;
import libcore.net.UriCodec;

public abstract class Uri
    implements Parcelable, Comparable {
    static class PathPart extends AbstractPart {

        static PathPart appendDecodedSegment(PathPart pathpart, String s) {
            return appendEncodedSegment(pathpart, Uri.encode(s));
        }

        static PathPart appendEncodedSegment(PathPart pathpart, String s) {
            if(pathpart != null) goto _L2; else goto _L1
_L1:
            PathPart pathpart1 = fromEncoded((new StringBuilder()).append("/").append(s).toString());
_L4:
            return pathpart1;
_L2:
            String s1;
            int i;
            String s2;
            s1 = pathpart.getEncoded();
            if(s1 == null)
                s1 = "";
            i = s1.length();
            if(i != 0)
                break; /* Loop/switch isn't completed */
            s2 = (new StringBuilder()).append("/").append(s).toString();
_L5:
            pathpart1 = fromEncoded(s2);
            if(true) goto _L4; else goto _L3
_L3:
            if(s1.charAt(i - 1) == '/')
                s2 = (new StringBuilder()).append(s1).append(s).toString();
            else
                s2 = (new StringBuilder()).append(s1).append("/").append(s).toString();
              goto _L5
            if(true) goto _L4; else goto _L6
_L6:
        }

        static PathPart from(String s, String s1) {
            PathPart pathpart;
            if(s == null)
                pathpart = NULL;
            else
            if(s.length() == 0)
                pathpart = EMPTY;
            else
                pathpart = new PathPart(s, s1);
            return pathpart;
        }

        static PathPart fromDecoded(String s) {
            return from(Uri.NOT_CACHED, s);
        }

        static PathPart fromEncoded(String s) {
            return from(s, Uri.NOT_CACHED);
        }

        static PathPart makeAbsolute(PathPart pathpart) {
            boolean flag = true;
            boolean flag1;
            String s;
            if(((AbstractPart) (pathpart)).encoded != Uri.NOT_CACHED)
                flag1 = flag;
            else
                flag1 = false;
            if(flag1)
                s = ((AbstractPart) (pathpart)).encoded;
            else
                s = ((AbstractPart) (pathpart)).decoded;
            if(s != null && s.length() != 0 && !s.startsWith("/")) {
                String s1;
                String s2;
                if(flag1)
                    s1 = (new StringBuilder()).append("/").append(((AbstractPart) (pathpart)).encoded).toString();
                else
                    s1 = Uri.NOT_CACHED;
                if(((AbstractPart) (pathpart)).decoded == Uri.NOT_CACHED)
                    flag = false;
                if(flag)
                    s2 = (new StringBuilder()).append("/").append(((AbstractPart) (pathpart)).decoded).toString();
                else
                    s2 = Uri.NOT_CACHED;
                pathpart = new PathPart(s1, s2);
            }
            return pathpart;
        }

        static PathPart readFrom(Parcel parcel) {
            int i = parcel.readInt();
            i;
            JVM INSTR tableswitch 0 2: default 32
        //                       0 59
        //                       1 73
        //                       2 84;
               goto _L1 _L2 _L3 _L4
_L1:
            throw new IllegalArgumentException((new StringBuilder()).append("Bad representation: ").append(i).toString());
_L2:
            PathPart pathpart = from(parcel.readString(), parcel.readString());
_L6:
            return pathpart;
_L3:
            pathpart = fromEncoded(parcel.readString());
            continue; /* Loop/switch isn't completed */
_L4:
            pathpart = fromDecoded(parcel.readString());
            if(true) goto _L6; else goto _L5
_L5:
        }

        String getEncoded() {
            boolean flag;
            String s;
            if(super.encoded != Uri.NOT_CACHED)
                flag = true;
            else
                flag = false;
            if(flag) {
                s = super.encoded;
            } else {
                s = Uri.encode(super.decoded, "/");
                super.encoded = s;
            }
            return s;
        }

        PathSegments getPathSegments() {
            PathSegments pathsegments;
            if(pathSegments != null) {
                pathsegments = pathSegments;
            } else {
                String s = getEncoded();
                if(s == null) {
                    pathsegments = PathSegments.EMPTY;
                    pathSegments = pathsegments;
                } else {
                    PathSegmentsBuilder pathsegmentsbuilder = new PathSegmentsBuilder();
                    int i = 0;
                    do {
                        int j = s.indexOf('/', i);
                        if(j <= -1)
                            break;
                        if(i < j)
                            pathsegmentsbuilder.add(Uri.decode(s.substring(i, j)));
                        i = j + 1;
                    } while(true);
                    if(i < s.length())
                        pathsegmentsbuilder.add(Uri.decode(s.substring(i)));
                    pathsegments = pathsegmentsbuilder.build();
                    pathSegments = pathsegments;
                }
            }
            return pathsegments;
        }

        static final PathPart EMPTY = new PathPart("", "");
        static final PathPart NULL = new PathPart(null, null);
        private PathSegments pathSegments;


        private PathPart(String s, String s1) {
            super(s, s1);
        }
    }

    static class Part extends AbstractPart {
        private static class EmptyPart extends Part {

            boolean isEmpty() {
                return true;
            }

            public EmptyPart(String s) {
                super(s, s, null);
            }
        }


        static Part from(String s, String s1) {
            Part part;
            if(s == null)
                part = NULL;
            else
            if(s.length() == 0)
                part = EMPTY;
            else
            if(s1 == null)
                part = NULL;
            else
            if(s1.length() == 0)
                part = EMPTY;
            else
                part = new Part(s, s1);
            return part;
        }

        static Part fromDecoded(String s) {
            return from(Uri.NOT_CACHED, s);
        }

        static Part fromEncoded(String s) {
            return from(s, Uri.NOT_CACHED);
        }

        static Part nonNull(Part part) {
            if(part == null)
                part = NULL;
            return part;
        }

        static Part readFrom(Parcel parcel) {
            int i = parcel.readInt();
            i;
            JVM INSTR tableswitch 0 2: default 32
        //                       0 59
        //                       1 73
        //                       2 84;
               goto _L1 _L2 _L3 _L4
_L1:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown representation: ").append(i).toString());
_L2:
            Part part = from(parcel.readString(), parcel.readString());
_L6:
            return part;
_L3:
            part = fromEncoded(parcel.readString());
            continue; /* Loop/switch isn't completed */
_L4:
            part = fromDecoded(parcel.readString());
            if(true) goto _L6; else goto _L5
_L5:
        }

        String getEncoded() {
            boolean flag;
            String s;
            if(super.encoded != Uri.NOT_CACHED)
                flag = true;
            else
                flag = false;
            if(flag) {
                s = super.encoded;
            } else {
                s = Uri.encode(super.decoded);
                super.encoded = s;
            }
            return s;
        }

        boolean isEmpty() {
            return false;
        }

        static final Part EMPTY = new EmptyPart("");
        static final Part NULL = new EmptyPart(null);


        private Part(String s, String s1) {
            super(s, s1);
        }

    }

    static abstract class AbstractPart {
        static class Representation {

            static final int BOTH = 0;
            static final int DECODED = 2;
            static final int ENCODED = 1;

            Representation() {
            }
        }


        final String getDecoded() {
            boolean flag;
            String s;
            if(decoded != Uri.NOT_CACHED)
                flag = true;
            else
                flag = false;
            if(flag) {
                s = decoded;
            } else {
                s = Uri.decode(encoded);
                decoded = s;
            }
            return s;
        }

        abstract String getEncoded();

        final void writeTo(Parcel parcel) {
            boolean flag;
            boolean flag1;
            if(encoded != Uri.NOT_CACHED)
                flag = true;
            else
                flag = false;
            if(decoded != Uri.NOT_CACHED)
                flag1 = true;
            else
                flag1 = false;
            if(flag && flag1) {
                parcel.writeInt(0);
                parcel.writeString(encoded);
                parcel.writeString(decoded);
            } else
            if(flag) {
                parcel.writeInt(1);
                parcel.writeString(encoded);
            } else
            if(flag1) {
                parcel.writeInt(2);
                parcel.writeString(decoded);
            } else {
                throw new IllegalArgumentException("Neither encoded nor decoded");
            }
        }

        volatile String decoded;
        volatile String encoded;

        AbstractPart(String s, String s1) {
            encoded = s;
            decoded = s1;
        }
    }

    public static final class Builder {

        private boolean hasSchemeOrAuthority() {
            boolean flag;
            if(scheme != null || authority != null && authority != Part.NULL)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public Builder appendEncodedPath(String s) {
            return path(PathPart.appendEncodedSegment(path, s));
        }

        public Builder appendPath(String s) {
            return path(PathPart.appendDecodedSegment(path, s));
        }

        public Builder appendQueryParameter(String s, String s1) {
            opaquePart = null;
            String s2 = (new StringBuilder()).append(Uri.encode(s, null)).append("=").append(Uri.encode(s1, null)).toString();
            if(query == null) {
                query = Part.fromEncoded(s2);
            } else {
                String s3 = query.getEncoded();
                if(s3 == null || s3.length() == 0)
                    query = Part.fromEncoded(s2);
                else
                    query = Part.fromEncoded((new StringBuilder()).append(s3).append("&").append(s2).toString());
            }
            return this;
        }

        Builder authority(Part part) {
            opaquePart = null;
            authority = part;
            return this;
        }

        public Builder authority(String s) {
            return authority(Part.fromDecoded(s));
        }

        public Uri build() {
            if(opaquePart == null) goto _L2; else goto _L1
_L1:
            Object obj;
            if(scheme == null)
                throw new UnsupportedOperationException("An opaque URI must have a scheme.");
            obj = new OpaqueUri(scheme, opaquePart, fragment);
_L4:
            return ((Uri) (obj));
_L2:
            PathPart pathpart;
            pathpart = path;
            if(pathpart != null && pathpart != PathPart.NULL)
                break; /* Loop/switch isn't completed */
            pathpart = PathPart.EMPTY;
_L6:
            obj = new HierarchicalUri(scheme, authority, pathpart, query, fragment);
            if(true) goto _L4; else goto _L3
_L3:
            if(!hasSchemeOrAuthority()) goto _L6; else goto _L5
_L5:
            pathpart = PathPart.makeAbsolute(pathpart);
              goto _L6
        }

        public Builder clearQuery() {
            return query((Part)null);
        }

        public Builder encodedAuthority(String s) {
            return authority(Part.fromEncoded(s));
        }

        public Builder encodedFragment(String s) {
            return fragment(Part.fromEncoded(s));
        }

        public Builder encodedOpaquePart(String s) {
            return opaquePart(Part.fromEncoded(s));
        }

        public Builder encodedPath(String s) {
            return path(PathPart.fromEncoded(s));
        }

        public Builder encodedQuery(String s) {
            return query(Part.fromEncoded(s));
        }

        Builder fragment(Part part) {
            fragment = part;
            return this;
        }

        public Builder fragment(String s) {
            return fragment(Part.fromDecoded(s));
        }

        Builder opaquePart(Part part) {
            opaquePart = part;
            return this;
        }

        public Builder opaquePart(String s) {
            return opaquePart(Part.fromDecoded(s));
        }

        Builder path(PathPart pathpart) {
            opaquePart = null;
            path = pathpart;
            return this;
        }

        public Builder path(String s) {
            return path(PathPart.fromDecoded(s));
        }

        Builder query(Part part) {
            opaquePart = null;
            query = part;
            return this;
        }

        public Builder query(String s) {
            return query(Part.fromDecoded(s));
        }

        public Builder scheme(String s) {
            scheme = s;
            return this;
        }

        public String toString() {
            return build().toString();
        }

        private Part authority;
        private Part fragment;
        private Part opaquePart;
        private PathPart path;
        private Part query;
        private String scheme;

        public Builder() {
        }
    }

    private static class HierarchicalUri extends AbstractHierarchicalUri {

        private void appendSspTo(StringBuilder stringbuilder) {
            String s = authority.getEncoded();
            if(s != null)
                stringbuilder.append("//").append(s);
            String s1 = path.getEncoded();
            if(s1 != null)
                stringbuilder.append(s1);
            if(!query.isEmpty())
                stringbuilder.append('?').append(query.getEncoded());
        }

        private Part getSsp() {
            Part part;
            if(ssp == null) {
                part = Part.fromEncoded(makeSchemeSpecificPart());
                ssp = part;
            } else {
                part = ssp;
            }
            return part;
        }

        private String makeSchemeSpecificPart() {
            StringBuilder stringbuilder = new StringBuilder();
            appendSspTo(stringbuilder);
            return stringbuilder.toString();
        }

        private String makeUriString() {
            StringBuilder stringbuilder = new StringBuilder();
            if(scheme != null)
                stringbuilder.append(scheme).append(':');
            appendSspTo(stringbuilder);
            if(!fragment.isEmpty())
                stringbuilder.append('#').append(fragment.getEncoded());
            return stringbuilder.toString();
        }

        static Uri readFrom(Parcel parcel) {
            return new HierarchicalUri(parcel.readString(), Part.readFrom(parcel), PathPart.readFrom(parcel), Part.readFrom(parcel), Part.readFrom(parcel));
        }

        public Builder buildUpon() {
            return (new Builder()).scheme(scheme).authority(authority).path(path).query(query).fragment(fragment);
        }

        public int describeContents() {
            return 0;
        }

        public String getAuthority() {
            return authority.getDecoded();
        }

        public String getEncodedAuthority() {
            return authority.getEncoded();
        }

        public String getEncodedFragment() {
            return fragment.getEncoded();
        }

        public String getEncodedPath() {
            return path.getEncoded();
        }

        public String getEncodedQuery() {
            return query.getEncoded();
        }

        public String getEncodedSchemeSpecificPart() {
            return getSsp().getEncoded();
        }

        public String getFragment() {
            return fragment.getDecoded();
        }

        public String getPath() {
            return path.getDecoded();
        }

        public List getPathSegments() {
            return path.getPathSegments();
        }

        public String getQuery() {
            return query.getDecoded();
        }

        public String getScheme() {
            return scheme;
        }

        public String getSchemeSpecificPart() {
            return getSsp().getDecoded();
        }

        public boolean isHierarchical() {
            return true;
        }

        public boolean isRelative() {
            boolean flag;
            if(scheme == null)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public String toString() {
            boolean flag;
            String s;
            if(uriString != Uri.NOT_CACHED)
                flag = true;
            else
                flag = false;
            if(flag) {
                s = uriString;
            } else {
                s = makeUriString();
                uriString = s;
            }
            return s;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(3);
            parcel.writeString(scheme);
            authority.writeTo(parcel);
            path.writeTo(parcel);
            query.writeTo(parcel);
            fragment.writeTo(parcel);
        }

        static final int TYPE_ID = 3;
        private final Part authority;
        private final Part fragment;
        private final PathPart path;
        private final Part query;
        private final String scheme;
        private Part ssp;
        private volatile String uriString;

        private HierarchicalUri(String s, Part part, PathPart pathpart, Part part1, Part part2) {
            uriString = Uri.NOT_CACHED;
            scheme = s;
            authority = Part.nonNull(part);
            if(pathpart == null)
                pathpart = PathPart.NULL;
            path = pathpart;
            query = Part.nonNull(part1);
            fragment = Part.nonNull(part2);
        }

    }

    private static abstract class AbstractHierarchicalUri extends Uri {

        private Part getUserInfoPart() {
            Part part;
            if(userInfo == null) {
                part = Part.fromEncoded(parseUserInfo());
                userInfo = part;
            } else {
                part = userInfo;
            }
            return part;
        }

        private String parseHost() {
            String s = getEncodedAuthority();
            String s2;
            if(s == null) {
                s2 = null;
            } else {
                int i = s.indexOf('@');
                int j = s.indexOf(':', i);
                String s1;
                if(j == -1)
                    s1 = s.substring(i + 1);
                else
                    s1 = s.substring(i + 1, j);
                s2 = decode(s1);
            }
            return s2;
        }

        private int parsePort() {
            int i;
            String s;
            i = -1;
            s = getEncodedAuthority();
            if(s != null) goto _L2; else goto _L1
_L1:
            return i;
_L2:
            String s1;
            int j = s.indexOf(':', s.indexOf('@'));
            if(j == i)
                continue; /* Loop/switch isn't completed */
            s1 = decode(s.substring(j + 1));
            int k = Integer.parseInt(s1);
            i = k;
            continue; /* Loop/switch isn't completed */
            NumberFormatException numberformatexception;
            numberformatexception;
            Log.w(Uri.LOG, "Error parsing port string.", numberformatexception);
            if(true) goto _L1; else goto _L3
_L3:
        }

        private String parseUserInfo() {
            String s;
            String s1;
            s = null;
            s1 = getEncodedAuthority();
            if(s1 != null) goto _L2; else goto _L1
_L1:
            return s;
_L2:
            int i = s1.indexOf('@');
            if(i != -1)
                s = s1.substring(0, i);
            if(true) goto _L1; else goto _L3
_L3:
        }

        public volatile int compareTo(Object obj) {
            return compareTo((Uri)obj);
        }

        public final String getEncodedUserInfo() {
            return getUserInfoPart().getEncoded();
        }

        public String getHost() {
            boolean flag;
            String s;
            if(host != Uri.NOT_CACHED)
                flag = true;
            else
                flag = false;
            if(flag) {
                s = host;
            } else {
                s = parseHost();
                host = s;
            }
            return s;
        }

        public String getLastPathSegment() {
            List list = getPathSegments();
            int i = list.size();
            String s;
            if(i == 0)
                s = null;
            else
                s = (String)list.get(i - 1);
            return s;
        }

        public int getPort() {
            int i;
            if(port == -2) {
                i = parsePort();
                port = i;
            } else {
                i = port;
            }
            return i;
        }

        public String getUserInfo() {
            return getUserInfoPart().getDecoded();
        }

        private volatile String host;
        private volatile int port;
        private Part userInfo;

        private AbstractHierarchicalUri() {
            host = Uri.NOT_CACHED;
            port = -2;
        }

    }

    static class PathSegmentsBuilder {

        void add(String s) {
            if(segments != null) goto _L2; else goto _L1
_L1:
            segments = new String[4];
_L4:
            String as1[] = segments;
            int i = size;
            size = i + 1;
            as1[i] = s;
            return;
_L2:
            if(1 + size == segments.length) {
                String as[] = new String[2 * segments.length];
                System.arraycopy(segments, 0, as, 0, segments.length);
                segments = as;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        PathSegments build() {
            if(segments != null) goto _L2; else goto _L1
_L1:
            PathSegments pathsegments = PathSegments.EMPTY;
_L4:
            return pathsegments;
_L2:
            pathsegments = new PathSegments(segments, size);
            segments = null;
            if(true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            segments = null;
            throw exception;
        }

        String segments[];
        int size;

        PathSegmentsBuilder() {
            size = 0;
        }
    }

    static class PathSegments extends AbstractList
        implements RandomAccess {

        public volatile Object get(int i) {
            return get(i);
        }

        public String get(int i) {
            if(i >= size)
                throw new IndexOutOfBoundsException();
            else
                return segments[i];
        }

        public int size() {
            return size;
        }

        static final PathSegments EMPTY = new PathSegments(null, 0);
        final String segments[];
        final int size;


        PathSegments(String as[], int i) {
            segments = as;
            size = i;
        }
    }

    private static class OpaqueUri extends Uri {

        static Uri readFrom(Parcel parcel) {
            return new OpaqueUri(parcel.readString(), Part.readFrom(parcel), Part.readFrom(parcel));
        }

        public Builder buildUpon() {
            return (new Builder()).scheme(scheme).opaquePart(ssp).fragment(fragment);
        }

        public volatile int compareTo(Object obj) {
            return compareTo((Uri)obj);
        }

        public int describeContents() {
            return 0;
        }

        public String getAuthority() {
            return null;
        }

        public String getEncodedAuthority() {
            return null;
        }

        public String getEncodedFragment() {
            return fragment.getEncoded();
        }

        public String getEncodedPath() {
            return null;
        }

        public String getEncodedQuery() {
            return null;
        }

        public String getEncodedSchemeSpecificPart() {
            return ssp.getEncoded();
        }

        public String getEncodedUserInfo() {
            return null;
        }

        public String getFragment() {
            return fragment.getDecoded();
        }

        public String getHost() {
            return null;
        }

        public String getLastPathSegment() {
            return null;
        }

        public String getPath() {
            return null;
        }

        public List getPathSegments() {
            return Collections.emptyList();
        }

        public int getPort() {
            return -1;
        }

        public String getQuery() {
            return null;
        }

        public String getScheme() {
            return scheme;
        }

        public String getSchemeSpecificPart() {
            return ssp.getDecoded();
        }

        public String getUserInfo() {
            return null;
        }

        public boolean isHierarchical() {
            return false;
        }

        public boolean isRelative() {
            boolean flag;
            if(scheme == null)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public String toString() {
            boolean flag;
            String s;
            if(cachedString != Uri.NOT_CACHED)
                flag = true;
            else
                flag = false;
            if(flag) {
                s = cachedString;
            } else {
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append(scheme).append(':');
                stringbuilder.append(getEncodedSchemeSpecificPart());
                if(!fragment.isEmpty())
                    stringbuilder.append('#').append(fragment.getEncoded());
                s = stringbuilder.toString();
                cachedString = s;
            }
            return s;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(2);
            parcel.writeString(scheme);
            ssp.writeTo(parcel);
            fragment.writeTo(parcel);
        }

        static final int TYPE_ID = 2;
        private volatile String cachedString;
        private final Part fragment;
        private final String scheme;
        private final Part ssp;

        private OpaqueUri(String s, Part part, Part part1) {
            cachedString = Uri.NOT_CACHED;
            scheme = s;
            ssp = part;
            if(part1 == null)
                part1 = Part.NULL;
            fragment = part1;
        }

    }

    private static class StringUri extends AbstractHierarchicalUri {

        private int findFragmentSeparator() {
            int i;
            if(cachedFsi == -2) {
                i = uriString.indexOf('#', findSchemeSeparator());
                cachedFsi = i;
            } else {
                i = cachedFsi;
            }
            return i;
        }

        private int findSchemeSeparator() {
            int i;
            if(cachedSsi == -2) {
                i = uriString.indexOf(':');
                cachedSsi = i;
            } else {
                i = cachedSsi;
            }
            return i;
        }

        private Part getAuthorityPart() {
            Part part;
            if(authority == null) {
                part = Part.fromEncoded(parseAuthority(uriString, findSchemeSeparator()));
                authority = part;
            } else {
                part = authority;
            }
            return part;
        }

        private Part getFragmentPart() {
            Part part;
            if(fragment == null) {
                part = Part.fromEncoded(parseFragment());
                fragment = part;
            } else {
                part = fragment;
            }
            return part;
        }

        private PathPart getPathPart() {
            PathPart pathpart;
            if(path == null) {
                pathpart = PathPart.fromEncoded(parsePath());
                path = pathpart;
            } else {
                pathpart = path;
            }
            return pathpart;
        }

        private Part getQueryPart() {
            Part part;
            if(query == null) {
                part = Part.fromEncoded(parseQuery());
                query = part;
            } else {
                part = query;
            }
            return part;
        }

        private Part getSsp() {
            Part part;
            if(ssp == null) {
                part = Part.fromEncoded(parseSsp());
                ssp = part;
            } else {
                part = ssp;
            }
            return part;
        }

        static String parseAuthority(String s, int i) {
            int j = s.length();
            String s1;
            if(j > i + 2 && s.charAt(i + 1) == '/' && s.charAt(i + 2) == '/') {
                int k = i + 3;
label0:
                do {
                    if(k >= j)
                        break;
                    switch(s.charAt(k)) {
                    default:
                        k++;
                        break;

                    case 35: // '#'
                    case 47: // '/'
                    case 63: // '?'
                        break label0;
                    }
                } while(true);
                s1 = s.substring(i + 3, k);
            } else {
                s1 = null;
            }
            return s1;
        }

        private String parseFragment() {
            int i = findFragmentSeparator();
            String s;
            if(i == -1)
                s = null;
            else
                s = uriString.substring(i + 1);
            return s;
        }

        private String parsePath() {
            String s = null;
            String s1 = uriString;
            int i = findSchemeSeparator();
            if(i > -1) {
                boolean flag;
                if(i + 1 == s1.length())
                    flag = true;
                else
                    flag = false;
                break MISSING_BLOCK_LABEL_31;
            }
            do {
                s = parsePath(s1, i);
                if(true)
                    do
                        return s;
                    while(flag || s1.charAt(i + 1) != '/');
            } while(true);
        }

        static String parsePath(String s, int i) {
            int j = s.length();
            if(j <= i + 2 || s.charAt(i + 1) != '/' || s.charAt(i + 2) != '/') goto _L2; else goto _L1
_L1:
            int k = i + 3;
_L7:
            if(k >= j) goto _L4; else goto _L3
_L3:
            s.charAt(k);
            JVM INSTR lookupswitch 3: default 84
        //                       35: 90
        //                       47: 101
        //                       63: 90;
               goto _L5 _L6 _L4 _L6
_L5:
            k++;
              goto _L7
_L6:
            String s1 = "";
_L9:
            return s1;
_L2:
            k = i + 1;
_L4:
            int l = k;
label0:
            do {
                if(l >= j)
                    break;
                switch(s.charAt(l)) {
                default:
                    l++;
                    break;

                case 35: // '#'
                case 63: // '?'
                    break label0;
                }
            } while(true);
            s1 = s.substring(k, l);
            if(true) goto _L9; else goto _L8
_L8:
        }

        private String parseQuery() {
            String s;
            int i;
            s = null;
            i = uriString.indexOf('?', findSchemeSeparator());
            if(i != -1) goto _L2; else goto _L1
_L1:
            return s;
_L2:
            int j = findFragmentSeparator();
            if(j == -1)
                s = uriString.substring(i + 1);
            else
            if(j >= i)
                s = uriString.substring(i + 1, j);
            if(true) goto _L1; else goto _L3
_L3:
        }

        private String parseScheme() {
            int i = findSchemeSeparator();
            String s;
            if(i == -1)
                s = null;
            else
                s = uriString.substring(0, i);
            return s;
        }

        private String parseSsp() {
            int i = findSchemeSeparator();
            int j = findFragmentSeparator();
            String s;
            if(j == -1)
                s = uriString.substring(i + 1);
            else
                s = uriString.substring(i + 1, j);
            return s;
        }

        static Uri readFrom(Parcel parcel) {
            return new StringUri(parcel.readString());
        }

        public Builder buildUpon() {
            Builder builder;
            if(isHierarchical())
                builder = (new Builder()).scheme(getScheme()).authority(getAuthorityPart()).path(getPathPart()).query(getQueryPart()).fragment(getFragmentPart());
            else
                builder = (new Builder()).scheme(getScheme()).opaquePart(getSsp()).fragment(getFragmentPart());
            return builder;
        }

        public int describeContents() {
            return 0;
        }

        public String getAuthority() {
            return getAuthorityPart().getDecoded();
        }

        public String getEncodedAuthority() {
            return getAuthorityPart().getEncoded();
        }

        public String getEncodedFragment() {
            return getFragmentPart().getEncoded();
        }

        public String getEncodedPath() {
            return getPathPart().getEncoded();
        }

        public String getEncodedQuery() {
            return getQueryPart().getEncoded();
        }

        public String getEncodedSchemeSpecificPart() {
            return getSsp().getEncoded();
        }

        public String getFragment() {
            return getFragmentPart().getDecoded();
        }

        public String getPath() {
            return getPathPart().getDecoded();
        }

        public List getPathSegments() {
            return getPathPart().getPathSegments();
        }

        public String getQuery() {
            return getQueryPart().getDecoded();
        }

        public String getScheme() {
            boolean flag;
            String s;
            if(scheme != Uri.NOT_CACHED)
                flag = true;
            else
                flag = false;
            if(flag) {
                s = scheme;
            } else {
                s = parseScheme();
                scheme = s;
            }
            return s;
        }

        public String getSchemeSpecificPart() {
            return getSsp().getDecoded();
        }

        public boolean isHierarchical() {
            boolean flag;
            int i;
            flag = true;
            i = findSchemeSeparator();
            if(i != -1) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            if(uriString.length() == i + 1)
                flag = false;
            else
            if(uriString.charAt(i + 1) != '/')
                flag = false;
            if(true) goto _L1; else goto _L3
_L3:
        }

        public boolean isRelative() {
            boolean flag;
            if(findSchemeSeparator() == -1)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public String toString() {
            return uriString;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(1);
            parcel.writeString(uriString);
        }

        static final int TYPE_ID = 1;
        private Part authority;
        private volatile int cachedFsi;
        private volatile int cachedSsi;
        private Part fragment;
        private PathPart path;
        private Part query;
        private volatile String scheme;
        private Part ssp;
        private final String uriString;

        private StringUri(String s) {
            cachedSsi = -2;
            cachedFsi = -2;
            scheme = Uri.NOT_CACHED;
            if(s == null) {
                throw new NullPointerException("uriString");
            } else {
                uriString = s;
                return;
            }
        }

    }


    private Uri() {
    }


    public static String decode(String s) {
        String s1;
        if(s == null)
            s1 = null;
        else
            s1 = UriCodec.decode(s, false, Charsets.UTF_8, false);
        return s1;
    }

    public static String encode(String s) {
        return encode(s, null);
    }

    public static String encode(String s, String s1) {
        if(s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L7:
        return s;
_L2:
        StringBuilder stringbuilder;
        int i;
        int j;
        stringbuilder = null;
        i = s.length();
        j = 0;
_L5:
        int i1;
        String s2;
        if(j >= i)
            break; /* Loop/switch isn't completed */
        int k;
        for(k = j; k < i && isAllowed(s.charAt(k), s1); k++);
        if(k == i) {
            if(j != 0) {
                stringbuilder.append(s, j, i);
                s = stringbuilder.toString();
            }
            continue; /* Loop/switch isn't completed */
        }
        if(stringbuilder == null)
            stringbuilder = new StringBuilder();
        if(k > j)
            stringbuilder.append(s, j, k);
        int l = k;
        for(i1 = l + 1; i1 < i && !isAllowed(s.charAt(i1), s1); i1++);
        s2 = s.substring(l, i1);
        byte abyte0[];
        int j1;
        int k1;
        abyte0 = s2.getBytes("UTF-8");
        j1 = abyte0.length;
        k1 = 0;
_L3:
        if(k1 >= j1)
            break MISSING_BLOCK_LABEL_241;
        stringbuilder.append('%');
        stringbuilder.append(HEX_DIGITS[(0xf0 & abyte0[k1]) >> 4]);
        stringbuilder.append(HEX_DIGITS[0xf & abyte0[k1]]);
        k1++;
          goto _L3
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        throw new AssertionError(unsupportedencodingexception);
        j = i1;
        if(true) goto _L5; else goto _L4
_L4:
        if(stringbuilder != null)
            s = stringbuilder.toString();
        if(true) goto _L7; else goto _L6
_L6:
    }

    public static Uri fromFile(File file) {
        if(file == null) {
            throw new NullPointerException("file");
        } else {
            PathPart pathpart = PathPart.fromDecoded(file.getAbsolutePath());
            return new HierarchicalUri("file", Part.EMPTY, pathpart, Part.NULL, Part.NULL);
        }
    }

    public static Uri fromParts(String s, String s1, String s2) {
        if(s == null)
            throw new NullPointerException("scheme");
        if(s1 == null)
            throw new NullPointerException("ssp");
        else
            return new OpaqueUri(s, Part.fromDecoded(s1), Part.fromDecoded(s2));
    }

    private static boolean isAllowed(char c, String s) {
        boolean flag;
        if(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9' || "_-!.~'()*".indexOf(c) != -1 || s != null && s.indexOf(c) != -1)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static Uri parse(String s) {
        return new StringUri(s);
    }

    public static Uri withAppendedPath(Uri uri, String s) {
        return uri.buildUpon().appendEncodedPath(s).build();
    }

    public static void writeToParcel(Parcel parcel, Uri uri) {
        if(uri == null)
            parcel.writeInt(0);
        else
            uri.writeToParcel(parcel, 0);
    }

    public abstract Builder buildUpon();

    public int compareTo(Uri uri) {
        return toString().compareTo(uri.toString());
    }

    public volatile int compareTo(Object obj) {
        return compareTo((Uri)obj);
    }

    public boolean equals(Object obj) {
        boolean flag;
        if(!(obj instanceof Uri)) {
            flag = false;
        } else {
            Uri uri = (Uri)obj;
            flag = toString().equals(uri.toString());
        }
        return flag;
    }

    public abstract String getAuthority();

    public boolean getBooleanQueryParameter(String s, boolean flag) {
        String s1 = getQueryParameter(s);
        if(s1 != null) {
            String s2 = s1.toLowerCase();
            boolean flag1;
            if(!"false".equals(s2) && !"0".equals(s2))
                flag1 = true;
            else
                flag1 = false;
            flag = flag1;
        }
        return flag;
    }

    public abstract String getEncodedAuthority();

    public abstract String getEncodedFragment();

    public abstract String getEncodedPath();

    public abstract String getEncodedQuery();

    public abstract String getEncodedSchemeSpecificPart();

    public abstract String getEncodedUserInfo();

    public abstract String getFragment();

    public abstract String getHost();

    public abstract String getLastPathSegment();

    public abstract String getPath();

    public abstract List getPathSegments();

    public abstract int getPort();

    public abstract String getQuery();

    public String getQueryParameter(String s) {
        String s1;
        String s2;
        s1 = null;
        if(isOpaque())
            throw new UnsupportedOperationException("This isn't a hierarchical URI.");
        if(s == null)
            throw new NullPointerException("key");
        s2 = getEncodedQuery();
        if(s2 != null) goto _L2; else goto _L1
_L1:
        return s1;
_L2:
        String s3;
        int i;
        int j;
        s3 = encode(s, null);
        i = s2.length();
        j = 0;
_L5:
        int k;
        k = s2.indexOf('&', j);
        int l;
        int i1;
        if(k != -1)
            l = k;
        else
            l = i;
        i1 = s2.indexOf('=', j);
        if(i1 > l || i1 == -1)
            i1 = l;
        if(i1 - j != s3.length() || !s2.regionMatches(j, s3, 0, s3.length()))
            continue; /* Loop/switch isn't completed */
        if(i1 == l)
            s1 = "";
        else
            s1 = UriCodec.decode(s2.substring(i1 + 1, l), true, Charsets.UTF_8, false);
        if(true) goto _L1; else goto _L3
_L3:
        if(k == -1) goto _L1; else goto _L4
_L4:
        j = k + 1;
          goto _L5
    }

    public Set getQueryParameterNames() {
        if(isOpaque())
            throw new UnsupportedOperationException("This isn't a hierarchical URI.");
        String s = getEncodedQuery();
        Set set;
        if(s == null) {
            set = Collections.emptySet();
        } else {
            LinkedHashSet linkedhashset = new LinkedHashSet();
            int i = 0;
            do {
                int j = s.indexOf('&', i);
                int k;
                int l;
                if(j == -1)
                    k = s.length();
                else
                    k = j;
                l = s.indexOf('=', i);
                if(l > k || l == -1)
                    l = k;
                linkedhashset.add(decode(s.substring(i, l)));
                i = k + 1;
            } while(i < s.length());
            set = Collections.unmodifiableSet(linkedhashset);
        }
        return set;
    }

    public List getQueryParameters(String s) {
        String s1;
        if(isOpaque())
            throw new UnsupportedOperationException("This isn't a hierarchical URI.");
        if(s == null)
            throw new NullPointerException("key");
        s1 = getEncodedQuery();
        if(s1 != null) goto _L2; else goto _L1
_L1:
        List list = Collections.emptyList();
_L4:
        return list;
_L2:
        ArrayList arraylist;
        String s2;
        int i;
        try {
            s2 = URLEncoder.encode(s, "UTF-8");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            throw new AssertionError(unsupportedencodingexception);
        }
        arraylist = new ArrayList();
        i = 0;
        do {
label0:
            {
                int j = s1.indexOf('&', i);
                int k;
                int l;
                if(j != -1)
                    k = j;
                else
                    k = s1.length();
                l = s1.indexOf('=', i);
                if(l > k || l == -1)
                    l = k;
                if(l - i == s2.length() && s1.regionMatches(i, s2, 0, s2.length()))
                    if(l == k)
                        arraylist.add("");
                    else
                        arraylist.add(decode(s1.substring(l + 1, k)));
                if(j == -1)
                    break label0;
                i = j + 1;
            }
        } while(true);
        list = Collections.unmodifiableList(arraylist);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public abstract String getScheme();

    public abstract String getSchemeSpecificPart();

    public abstract String getUserInfo();

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isAbsolute() {
        boolean flag;
        if(!isRelative())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public abstract boolean isHierarchical();

    public boolean isOpaque() {
        boolean flag;
        if(!isHierarchical())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public abstract boolean isRelative();

    public Uri normalizeScheme() {
        String s = getScheme();
        if(s != null) goto _L2; else goto _L1
_L1:
        return this;
_L2:
        String s1 = s.toLowerCase(Locale.US);
        if(!s.equals(s1))
            this = buildUpon().scheme(s1).build();
        if(true) goto _L1; else goto _L3
_L3:
    }

    public String toSafeString() {
        String s = getScheme();
        String s1 = getSchemeSpecificPart();
        String s2;
        if(s != null && (s.equalsIgnoreCase("tel") || s.equalsIgnoreCase("sip") || s.equalsIgnoreCase("sms") || s.equalsIgnoreCase("smsto") || s.equalsIgnoreCase("mailto"))) {
            StringBuilder stringbuilder1 = new StringBuilder(64);
            stringbuilder1.append(s);
            stringbuilder1.append(':');
            if(s1 != null) {
                int i = 0;
                while(i < s1.length())  {
                    char c = s1.charAt(i);
                    if(c == '-' || c == '@' || c == '.')
                        stringbuilder1.append(c);
                    else
                        stringbuilder1.append('x');
                    i++;
                }
            }
            s2 = stringbuilder1.toString();
        } else {
            StringBuilder stringbuilder = new StringBuilder(64);
            if(s != null) {
                stringbuilder.append(s);
                stringbuilder.append(':');
            }
            if(s1 != null)
                stringbuilder.append(s1);
            s2 = stringbuilder.toString();
        }
        return s2;
    }

    public abstract String toString();

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Uri createFromParcel(Parcel parcel) {
            int i = parcel.readInt();
            i;
            JVM INSTR tableswitch 0 3: default 36
        //                       0 63
        //                       1 67
        //                       2 75
        //                       3 83;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown URI type: ").append(i).toString());
_L2:
            Uri uri = null;
_L7:
            return uri;
_L3:
            uri = StringUri.readFrom(parcel);
            continue; /* Loop/switch isn't completed */
_L4:
            uri = OpaqueUri.readFrom(parcel);
            continue; /* Loop/switch isn't completed */
_L5:
            uri = HierarchicalUri.readFrom(parcel);
            if(true) goto _L7; else goto _L6
_L6:
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Uri[] newArray(int i) {
            return new Uri[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final String DEFAULT_ENCODING = "UTF-8";
    public static final Uri EMPTY;
    private static final char HEX_DIGITS[] = "0123456789ABCDEF".toCharArray();
    private static final String LOG = android/net/Uri.getSimpleName();
    private static final String NOT_CACHED = new String("NOT CACHED");
    private static final int NOT_CALCULATED = -2;
    private static final int NOT_FOUND = -1;
    private static final String NOT_HIERARCHICAL = "This isn't a hierarchical URI.";
    private static final int NULL_TYPE_ID;

    static  {
        EMPTY = new HierarchicalUri(null, Part.NULL, PathPart.EMPTY, Part.NULL, Part.NULL);
    }


}
