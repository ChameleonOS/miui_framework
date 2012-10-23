// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;


public class LocalSocketAddress {
    public static final class Namespace extends Enum {

        public static Namespace valueOf(String s) {
            return (Namespace)Enum.valueOf(android/net/LocalSocketAddress$Namespace, s);
        }

        public static Namespace[] values() {
            return (Namespace[])$VALUES.clone();
        }

        int getId() {
            return id;
        }

        private static final Namespace $VALUES[];
        public static final Namespace ABSTRACT;
        public static final Namespace FILESYSTEM;
        public static final Namespace RESERVED;
        private int id;

        static  {
            ABSTRACT = new Namespace("ABSTRACT", 0, 0);
            RESERVED = new Namespace("RESERVED", 1, 1);
            FILESYSTEM = new Namespace("FILESYSTEM", 2, 2);
            Namespace anamespace[] = new Namespace[3];
            anamespace[0] = ABSTRACT;
            anamespace[1] = RESERVED;
            anamespace[2] = FILESYSTEM;
            $VALUES = anamespace;
        }

        private Namespace(String s, int i, int j) {
            super(s, i);
            id = j;
        }
    }


    public LocalSocketAddress(String s) {
        this(s, Namespace.ABSTRACT);
    }

    public LocalSocketAddress(String s, Namespace namespace1) {
        name = s;
        namespace = namespace1;
    }

    public String getName() {
        return name;
    }

    public Namespace getNamespace() {
        return namespace;
    }

    private final String name;
    private final Namespace namespace;
}
