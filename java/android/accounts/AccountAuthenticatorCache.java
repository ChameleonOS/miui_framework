// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import android.content.Context;
import android.content.pm.RegisteredServicesCache;
import android.content.pm.XmlSerializerAndParser;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.*;

// Referenced classes of package android.accounts:
//            IAccountAuthenticatorCache, AuthenticatorDescription

class AccountAuthenticatorCache extends RegisteredServicesCache
    implements IAccountAuthenticatorCache {
    private static class MySerializer
        implements XmlSerializerAndParser {

        public AuthenticatorDescription createFromXml(XmlPullParser xmlpullparser) throws IOException, XmlPullParserException {
            return AuthenticatorDescription.newKey(xmlpullparser.getAttributeValue(null, "type"));
        }

        public volatile Object createFromXml(XmlPullParser xmlpullparser) throws IOException, XmlPullParserException {
            return createFromXml(xmlpullparser);
        }

        public void writeAsXml(AuthenticatorDescription authenticatordescription, XmlSerializer xmlserializer) throws IOException {
            xmlserializer.attribute(null, "type", authenticatordescription.type);
        }

        public volatile void writeAsXml(Object obj, XmlSerializer xmlserializer) throws IOException {
            writeAsXml((AuthenticatorDescription)obj, xmlserializer);
        }

        private MySerializer() {
        }

    }


    public AccountAuthenticatorCache(Context context) {
        super(context, "android.accounts.AccountAuthenticator", "android.accounts.AccountAuthenticator", "account-authenticator", sSerializer);
    }

    public volatile android.content.pm.RegisteredServicesCache.ServiceInfo getServiceInfo(AuthenticatorDescription authenticatordescription) {
        return super.getServiceInfo(authenticatordescription);
    }

    public AuthenticatorDescription parseServiceAttributes(Resources resources, String s, AttributeSet attributeset) {
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AccountAuthenticator);
        String s1;
        int i;
        int j;
        int k;
        int l;
        boolean flag;
        boolean flag1;
        s1 = typedarray.getString(2);
        i = typedarray.getResourceId(0, 0);
        j = typedarray.getResourceId(1, 0);
        k = typedarray.getResourceId(3, 0);
        l = typedarray.getResourceId(4, 0);
        flag = typedarray.getBoolean(5, false);
        flag1 = TextUtils.isEmpty(s1);
        if(!flag1) goto _L2; else goto _L1
_L1:
        AuthenticatorDescription authenticatordescription = null;
_L4:
        typedarray.recycle();
        return authenticatordescription;
_L2:
        authenticatordescription = new AuthenticatorDescription(s1, s, i, j, k, l, flag);
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        typedarray.recycle();
        throw exception;
    }

    public volatile Object parseServiceAttributes(Resources resources, String s, AttributeSet attributeset) {
        return parseServiceAttributes(resources, s, attributeset);
    }

    private static final String TAG = "Account";
    private static final MySerializer sSerializer = new MySerializer();

}
