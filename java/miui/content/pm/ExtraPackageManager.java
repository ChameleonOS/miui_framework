// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.content.pm;

import android.content.pm.*;
import com.android.internal.util.ArrayUtils;
import java.util.HashSet;
import java.util.jar.JarEntry;

public class ExtraPackageManager {

    public ExtraPackageManager() {
    }

    static int compareSignatures(Signature asignature[], Signature asignature1[]) {
        int i1;
        if(asignature == null) {
            if(asignature1 == null)
                i1 = 1;
            else
                i1 = -1;
        } else
        if(asignature1 == null) {
            i1 = -2;
        } else {
            HashSet hashset = new HashSet();
            int i = asignature.length;
            for(int j = 0; j < i; j++)
                hashset.add(asignature[j]);

            HashSet hashset1 = new HashSet();
            int k = asignature1.length;
            for(int l = 0; l < k; l++)
                hashset1.add(asignature1[l]);

            if(hashset.equals(hashset1))
                i1 = 0;
            else
                i1 = -3;
        }
        return i1;
    }

    public static boolean isTrustedAccountSignature(PackageManager packagemanager, String s, int i, int j) {
        boolean flag = true;
        if(j != 1001) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(!"com.xiaomi".equals(s) || !"com.xiaomi.channel".equals(packagemanager.getNameForUid(j)))
            break MISSING_BLOCK_LABEL_71;
        int k;
        PackageInfo packageinfo = packagemanager.getPackageInfo("com.xiaomi.channel", 64);
        k = compareSignatures(MITALK_SIGNATURES, packageinfo.signatures);
        if(k != 0)
            flag = false;
        continue; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if(packagemanager.checkSignatures(i, j) != 0)
            flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static boolean isTrustedAppEntry(JarEntry jarentry, String s) {
        boolean flag;
        if("classes.dex".equals(jarentry.getName()) && ArrayUtils.contains(TRUSTED_PACKAGES, s))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isTrustedSystemSignature(Signature asignature[]) {
        boolean flag;
        if(compareSignatures(GOOGLE_SIGNATURES, asignature) == 0 || compareSignatures(MITALK_SIGNATURES, asignature) == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    static final Signature GOOGLE_SIGNATURES[];
    static final String MITALK_NAME = "com.xiaomi.channel";
    static final Signature MITALK_SIGNATURES[];
    private static final String TRUSTED_PACKAGES[];

    static  {
        Signature asignature[] = new Signature[1];
        asignature[0] = new Signature("308204433082032ba003020102020900c2e08746644a308d300d06092a864886f70d01010405003074310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e205669657731143012060355040a130b476f6f676c6520496e632e3110300e060355040b1307416e64726f69643110300e06035504031307416e64726f6964301e170d3038303832313233313333345a170d3336303130373233313333345a3074310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e205669657731143012060355040a130b476f6f676c6520496e632e3110300e060355040b1307416e64726f69643110300e06035504031307416e64726f696430820120300d06092a864886f70d01010105000382010d00308201080282010100ab562e00d83ba208ae0a966f124e29da11f2ab56d08f58e2cca91303e9b754d372f640a71b1dcb130967624e4656a7776a92193db2e5bfb724a91e77188b0e6a47a43b33d9609b77183145ccdf7b2e586674c9e1565b1f4c6a5955bff251a63dabf9c55c27222252e875e4f8154a645f897168c0b1bfc612eabf785769bb34aa7984dc7e2ea2764cae8307d8c17154d7ee5f64a51a44a602c249054157dc02cd5f5c0e55fbef8519fbe327f0b1511692c5a06f19d18385f5c4dbc2d6b93f68cc2979c70e18ab93866b3bd5db8999552a0e3b4c99df58fb918bedc182ba35e003c1b4b10dd244a8ee24fffd333872ab5221985edab0fc0d0b145b6aa192858e79020103a381d93081d6301d0603551d0e04160414c77d8cc2211756259a7fd382df6be398e4d786a53081a60603551d2304819e30819b8014c77d8cc2211756259a7fd382df6be398e4d786a5a178a4763074310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e205669657731143012060355040a130b476f6f676c6520496e632e3110300e060355040b1307416e64726f69643110300e06035504031307416e64726f6964820900c2e08746644a308d300c0603551d13040530030101ff300d06092a864886f70d010104050003820101006dd252ceef85302c360aaace939bcff2cca904bb5d7a1661f8ae46b2994204d0ff4a68c7ed1a531ec4595a623ce60763b167297a7ae35712c407f208f0cb109429124d7b106219c084ca3eb3f9ad5fb871ef92269a8be28bf16d44c8d9a08e6cb2f005bb3fe2cb96447e868e731076ad45b33f6009ea19c161e62641aa99271dfd5228c5c587875ddb7f452758d661f6cc0cccb7352e424cc4365c523532f7325137593c4ae341f4db41edda0d0b1071a7c440f0fe9ea01cb627ca674369d084bd2fd911ff06cdbf2cfa10dc0f893ae35762919048c7efc64c7144178342f70581c9de573af55b390dd7fdb9418631895d5f759f30112687ff621410c069308a");
        GOOGLE_SIGNATURES = asignature;
        Signature asignature1[] = new Signature[1];
        asignature1[0] = new Signature("3082028b308201f4a00302010202044baf2eea300d06092a864886f70d0101050500308189310b300906035504061302434e310f300d06035504080c06e58c97e4baac3112301006035504070c09e58c97e4baace5b882312d302b060355040a0c24e58c97e4baace5b08fe7b1b3e7a791e68a80e69c89e99990e8b4a3e4bbbbe585ace58fb831123010060355040b0c09e8bdafe4bbb6e983a83112301006035504030c09e7aea1e79086e59198301e170d3130303332383130323635305a170d3335303332323130323635305a308189310b300906035504061302434e310f300d06035504080c06e58c97e4baac3112301006035504070c09e58c97e4baace5b882312d302b060355040a0c24e58c97e4baace5b08fe7b1b3e7a791e68a80e69c89e99990e8b4a3e4bbbbe585ace58fb831123010060355040b0c09e8bdafe4bbb6e983a83112301006035504030c09e7aea1e79086e5919830819f300d06092a864886f70d010101050003818d00308189028181008b0a35791ef2ed5107f6e8cbe3b74ee308a98b4f777b1c7dd7f63578f0bf788bff1c4e3900a8eed13b5b4763c22bbf6f9404e7bf91c555171756cce2cced01b99e265d74ffa77bd58a6a87f442c766758953282d6868a700f34bfc07c4389d6da3ab4cb2b8219c7f7d65837f69559dec82981472b9c57560edf693a510ebfcbf0203010001300d06092a864886f70d0101050500038181008b0562dee241538b22b53e12e5a0adcf5ade76470591256a41bde1bf6d5bcf3ed125114cb509df6d747a291a73093bd7068dc3640d2ab18a9b44626484a7b10020e0a59df1535983b582b3230d422cdea1feeedb16e9c838e2e1957ffc72e84bc83febbb97706ae2e190dab9d6483a353abcedd531398742ebdac12661f447ab");
        MITALK_SIGNATURES = asignature1;
        String as[] = new String[6];
        as[0] = "com.google.android.googlequicksearchbox";
        as[1] = "com.google.android.syncadapters.calendar";
        as[2] = "com.google.android.syncadapters.contacts";
        as[3] = "com.google.android.talk";
        as[4] = "com.google.android.tts";
        as[5] = "com.google.android.voicesearch";
        TRUSTED_PACKAGES = as;
    }
}
