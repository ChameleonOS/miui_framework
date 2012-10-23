// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.sax;


// Referenced classes of package android.sax:
//            Element

class Children {
    static class Child extends Element {

        final int hash;
        Child next;

        Child(Element element, String s, String s1, int i, int j) {
            super(element, s, s1, i);
            hash = j;
        }
    }


    Children() {
        children = new Child[16];
    }

    Element get(String s, String s1) {
        Object obj = null;
        int i = 31 * s.hashCode() + s1.hashCode();
        int j = i & 0xf;
        Child child = children[j];
        if(child != null)
            do {
                if(child.hash == i && ((Element) (child)).uri.compareTo(s) == 0 && ((Element) (child)).localName.compareTo(s1) == 0) {
                    obj = child;
                    break;
                }
                child = child.next;
            } while(child != null);
        return ((Element) (obj));
    }

    Element getOrCreate(Element element, String s, String s1) {
        int i;
        int j;
        Child child;
        i = 31 * s.hashCode() + s1.hashCode();
        j = i & 0xf;
        child = children[j];
        if(child != null) goto _L2; else goto _L1
_L1:
        Child child2;
        Child child1 = new Child(element, s, s1, 1 + element.depth, i);
        children[j] = child1;
        child2 = child1;
_L4:
        return child2;
_L2:
        Child child3;
        do {
            if(child.hash == i && ((Element) (child)).uri.compareTo(s) == 0 && ((Element) (child)).localName.compareTo(s1) == 0) {
                child2 = child;
                continue; /* Loop/switch isn't completed */
            }
            child3 = child;
            child = child.next;
        } while(child != null);
        Child child4 = new Child(element, s, s1, 1 + element.depth, i);
        child3.next = child4;
        child2 = child4;
        if(true) goto _L4; else goto _L3
_L3:
    }

    Child children[];
}
