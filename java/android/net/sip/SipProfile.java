// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.sip;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.text.ParseException;
import javax.sip.*;
import javax.sip.address.*;

public class SipProfile
    implements Parcelable, Serializable, Cloneable {
    public static class Builder {

        private String fix(String s) {
            if(!s.trim().toLowerCase().startsWith("sip:"))
                s = (new StringBuilder()).append("sip:").append(s).toString();
            return s;
        }

        public SipProfile build() {
            mProfile.mPassword = mUri.getUserPassword();
            mUri.setUserPassword(null);
            if(TextUtils.isEmpty(mProxyAddress))
                break MISSING_BLOCK_LABEL_104;
            SipURI sipuri = (SipURI)mAddressFactory.createURI(fix(mProxyAddress));
            mProfile.mProxyAddress = sipuri.getHost();
_L1:
            mProfile.mAddress = mAddressFactory.createAddress(mDisplayName, mUri);
            return mProfile;
            try {
                if(!mProfile.mProtocol.equals("UDP"))
                    mUri.setTransportParam(mProfile.mProtocol);
                if(mProfile.mPort != 5060)
                    mUri.setPort(mProfile.mPort);
            }
            catch(InvalidArgumentException invalidargumentexception) {
                throw new RuntimeException(invalidargumentexception);
            }
            catch(ParseException parseexception) {
                throw new RuntimeException(parseexception);
            }
              goto _L1
        }

        public Builder setAuthUserName(String s) {
            mProfile.mAuthUserName = s;
            return this;
        }

        public Builder setAutoRegistration(boolean flag) {
            mProfile.mAutoRegistration = flag;
            return this;
        }

        public Builder setDisplayName(String s) {
            mDisplayName = s;
            return this;
        }

        public Builder setOutboundProxy(String s) {
            mProxyAddress = s;
            return this;
        }

        public Builder setPassword(String s) {
            mUri.setUserPassword(s);
            return this;
        }

        public Builder setPort(int i) throws IllegalArgumentException {
            if(i > 65535 || i < 1000) {
                throw new IllegalArgumentException((new StringBuilder()).append("incorrect port arugment: ").append(i).toString());
            } else {
                mProfile.mPort = i;
                return this;
            }
        }

        public Builder setProfileName(String s) {
            mProfile.mProfileName = s;
            return this;
        }

        public Builder setProtocol(String s) throws IllegalArgumentException {
            if(s == null)
                throw new NullPointerException("protocol cannot be null");
            String s1 = s.toUpperCase();
            if(!s1.equals("UDP") && !s1.equals("TCP")) {
                throw new IllegalArgumentException((new StringBuilder()).append("unsupported protocol: ").append(s1).toString());
            } else {
                mProfile.mProtocol = s1;
                return this;
            }
        }

        public Builder setSendKeepAlive(boolean flag) {
            mProfile.mSendKeepAlive = flag;
            return this;
        }

        private AddressFactory mAddressFactory;
        private String mDisplayName;
        private SipProfile mProfile;
        private String mProxyAddress;
        private SipURI mUri;

        public Builder(SipProfile sipprofile) {
            mProfile = new SipProfile();
            try {
                mAddressFactory = SipFactory.getInstance().createAddressFactory();
            }
            catch(PeerUnavailableException peerunavailableexception) {
                throw new RuntimeException(peerunavailableexception);
            }
            if(sipprofile == null)
                throw new NullPointerException();
            try {
                mProfile = (SipProfile)sipprofile.clone();
            }
            catch(CloneNotSupportedException clonenotsupportedexception) {
                throw new RuntimeException("should not occur", clonenotsupportedexception);
            }
            mProfile.mAddress = null;
            mUri = sipprofile.getUri();
            mUri.setUserPassword(sipprofile.getPassword());
            mDisplayName = sipprofile.getDisplayName();
            mProxyAddress = sipprofile.getProxyAddress();
            mProfile.mPort = sipprofile.getPort();
        }

        public Builder(String s) throws ParseException {
            mProfile = new SipProfile();
            try {
                mAddressFactory = SipFactory.getInstance().createAddressFactory();
            }
            catch(PeerUnavailableException peerunavailableexception) {
                throw new RuntimeException(peerunavailableexception);
            }
            if(s == null)
                throw new NullPointerException("uriString cannot be null");
            javax.sip.address.URI uri = mAddressFactory.createURI(fix(s));
            if(uri instanceof SipURI) {
                mUri = (SipURI)uri;
                mProfile.mDomain = mUri.getHost();
                return;
            } else {
                throw new ParseException((new StringBuilder()).append(s).append(" is not a SIP URI").toString(), 0);
            }
        }

        public Builder(String s, String s1) throws ParseException {
            mProfile = new SipProfile();
            try {
                mAddressFactory = SipFactory.getInstance().createAddressFactory();
            }
            catch(PeerUnavailableException peerunavailableexception) {
                throw new RuntimeException(peerunavailableexception);
            }
            if(s == null || s1 == null) {
                throw new NullPointerException("username and serverDomain cannot be null");
            } else {
                mUri = mAddressFactory.createSipURI(s, s1);
                mProfile.mDomain = s1;
                return;
            }
        }
    }


    private SipProfile() {
        mProtocol = "UDP";
        mPort = 5060;
        mSendKeepAlive = false;
        mAutoRegistration = true;
        mCallingUid = 0;
    }


    private SipProfile(Parcel parcel) {
        boolean flag = false;
        super();
        mProtocol = "UDP";
        mPort = 5060;
        mSendKeepAlive = false;
        mAutoRegistration = true;
        mCallingUid = 0;
        mAddress = (Address)parcel.readSerializable();
        mProxyAddress = parcel.readString();
        mPassword = parcel.readString();
        mDomain = parcel.readString();
        mProtocol = parcel.readString();
        mProfileName = parcel.readString();
        boolean flag1;
        if(parcel.readInt() == 0)
            flag1 = false;
        else
            flag1 = true;
        mSendKeepAlive = flag1;
        if(parcel.readInt() != 0)
            flag = true;
        mAutoRegistration = flag;
        mCallingUid = parcel.readInt();
        mPort = parcel.readInt();
        mAuthUserName = parcel.readString();
    }


    private Object readResolve() throws ObjectStreamException {
        if(mPort == 0)
            mPort = 5060;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public String getAuthUserName() {
        return mAuthUserName;
    }

    public boolean getAutoRegistration() {
        return mAutoRegistration;
    }

    public int getCallingUid() {
        return mCallingUid;
    }

    public String getDisplayName() {
        return mAddress.getDisplayName();
    }

    public String getPassword() {
        return mPassword;
    }

    public int getPort() {
        return mPort;
    }

    public String getProfileName() {
        return mProfileName;
    }

    public String getProtocol() {
        return mProtocol;
    }

    public String getProxyAddress() {
        return mProxyAddress;
    }

    public boolean getSendKeepAlive() {
        return mSendKeepAlive;
    }

    public Address getSipAddress() {
        return mAddress;
    }

    public String getSipDomain() {
        return mDomain;
    }

    public SipURI getUri() {
        return (SipURI)mAddress.getURI();
    }

    public String getUriString() {
        String s;
        if(!TextUtils.isEmpty(mProxyAddress))
            s = (new StringBuilder()).append("sip:").append(getUserName()).append("@").append(mDomain).toString();
        else
            s = getUri().toString();
        return s;
    }

    public String getUserName() {
        return getUri().getUser();
    }

    public void setCallingUid(int i) {
        mCallingUid = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        parcel.writeSerializable(mAddress);
        parcel.writeString(mProxyAddress);
        parcel.writeString(mPassword);
        parcel.writeString(mDomain);
        parcel.writeString(mProtocol);
        parcel.writeString(mProfileName);
        int k;
        if(mSendKeepAlive)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        if(!mAutoRegistration)
            j = 0;
        parcel.writeInt(j);
        parcel.writeInt(mCallingUid);
        parcel.writeInt(mPort);
        parcel.writeString(mAuthUserName);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SipProfile createFromParcel(Parcel parcel) {
            return new SipProfile(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SipProfile[] newArray(int i) {
            return new SipProfile[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final int DEFAULT_PORT = 5060;
    private static final String TCP = "TCP";
    private static final String UDP = "UDP";
    private static final long serialVersionUID = 1L;
    private Address mAddress;
    private String mAuthUserName;
    private boolean mAutoRegistration;
    private transient int mCallingUid;
    private String mDomain;
    private String mPassword;
    private int mPort;
    private String mProfileName;
    private String mProtocol;
    private String mProxyAddress;
    private boolean mSendKeepAlive;



/*
    static boolean access$1002(SipProfile sipprofile, boolean flag) {
        sipprofile.mAutoRegistration = flag;
        return flag;
    }

*/


/*
    static String access$1102(SipProfile sipprofile, String s) {
        sipprofile.mPassword = s;
        return s;
    }

*/


/*
    static String access$1202(SipProfile sipprofile, String s) {
        sipprofile.mProxyAddress = s;
        return s;
    }

*/



/*
    static Address access$302(SipProfile sipprofile, Address address) {
        sipprofile.mAddress = address;
        return address;
    }

*/



/*
    static int access$402(SipProfile sipprofile, int i) {
        sipprofile.mPort = i;
        return i;
    }

*/


/*
    static String access$502(SipProfile sipprofile, String s) {
        sipprofile.mDomain = s;
        return s;
    }

*/


/*
    static String access$602(SipProfile sipprofile, String s) {
        sipprofile.mAuthUserName = s;
        return s;
    }

*/


/*
    static String access$702(SipProfile sipprofile, String s) {
        sipprofile.mProfileName = s;
        return s;
    }

*/



/*
    static String access$802(SipProfile sipprofile, String s) {
        sipprofile.mProtocol = s;
        return s;
    }

*/


/*
    static boolean access$902(SipProfile sipprofile, boolean flag) {
        sipprofile.mSendKeepAlive = flag;
        return flag;
    }

*/
}
