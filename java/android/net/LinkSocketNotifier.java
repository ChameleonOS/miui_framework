// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;


// Referenced classes of package android.net:
//            LinkSocket, LinkCapabilities

public interface LinkSocketNotifier {

    public abstract boolean onBetterLinkAvailable(LinkSocket linksocket, LinkSocket linksocket1);

    public abstract void onCapabilitiesChanged(LinkSocket linksocket, LinkCapabilities linkcapabilities);

    public abstract void onLinkLost(LinkSocket linksocket);

    public abstract void onNewLinkUnavailable(LinkSocket linksocket);
}
