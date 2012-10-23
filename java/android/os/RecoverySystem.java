// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.pkcs7.ContentInfo;
import org.apache.harmony.security.pkcs7.SignedData;
import org.apache.harmony.security.pkcs7.SignerInfo;
import org.apache.harmony.security.provider.cert.X509CertImpl;
import org.apache.harmony.security.x509.Certificate;

// Referenced classes of package android.os:
//            PowerManager, FileUtils, ConditionVariable

public class RecoverySystem {
    public static interface ProgressListener {

        public abstract void onProgress(int i);
    }


    public RecoverySystem() {
    }

    private void RecoverySystem() {
    }

    private static void bootCommand(Context context, String s) throws IOException {
        FileWriter filewriter;
        RECOVERY_DIR.mkdirs();
        COMMAND_FILE.delete();
        LOG_FILE.delete();
        filewriter = new FileWriter(COMMAND_FILE);
        filewriter.write(s);
        filewriter.write("\n");
        filewriter.close();
        ((PowerManager)context.getSystemService("power")).reboot("recovery");
        throw new IOException("Reboot failed (no permissions?)");
        Exception exception;
        exception;
        filewriter.close();
        throw exception;
    }

    private static HashSet getTrustedCerts(File file) throws IOException, GeneralSecurityException {
        HashSet hashset;
        ZipFile zipfile;
        hashset = new HashSet();
        if(file == null)
            file = DEFAULT_KEYSTORE;
        zipfile = new ZipFile(file);
        CertificateFactory certificatefactory;
        Enumeration enumeration;
        certificatefactory = CertificateFactory.getInstance("X.509");
        enumeration = zipfile.entries();
_L1:
        InputStream inputstream;
        if(!enumeration.hasMoreElements())
            break MISSING_BLOCK_LABEL_101;
        inputstream = zipfile.getInputStream((ZipEntry)enumeration.nextElement());
        hashset.add(certificatefactory.generateCertificate(inputstream));
        inputstream.close();
          goto _L1
        Exception exception;
        exception;
        zipfile.close();
        throw exception;
        Exception exception1;
        exception1;
        inputstream.close();
        throw exception1;
        zipfile.close();
        return hashset;
    }

    public static String handleAftermath() {
        String s = null;
        String s1;
        try {
            s1 = FileUtils.readTextFile(LOG_FILE, -LOG_FILE_MAX_LENGTH, "...\n");
        }
        catch(FileNotFoundException filenotfoundexception) {
            Log.i("RecoverySystem", "No recovery log file");
            continue;
        }
        catch(IOException ioexception) {
            Log.e("RecoverySystem", "Error reading recovery log", ioexception);
            continue;
        }
        s = s1;
        do {
            String as[] = RECOVERY_DIR.list();
            int i = 0;
            while(as != null && i < as.length)  {
                if(!as[i].startsWith(LAST_PREFIX)) {
                    File file = new File(RECOVERY_DIR, as[i]);
                    if(!file.delete())
                        Log.e("RecoverySystem", (new StringBuilder()).append("Can't delete: ").append(file).toString());
                    else
                        Log.i("RecoverySystem", (new StringBuilder()).append("Deleted: ").append(file).toString());
                }
                i++;
            }
            return s;
        } while(true);
    }

    public static void installPackage(Context context, File file) throws IOException {
        String s = file.getCanonicalPath();
        Log.w("RecoverySystem", (new StringBuilder()).append("!!! REBOOTING TO INSTALL ").append(s).append(" !!!").toString());
        bootCommand(context, (new StringBuilder()).append("--update_package=").append(s).toString());
    }

    public static void rebootWipeCache(Context context) throws IOException {
        bootCommand(context, "--wipe_cache");
    }

    public static void rebootWipeUserData(Context context) throws IOException {
        final ConditionVariable condition = new ConditionVariable();
        context.sendOrderedBroadcast(new Intent("android.intent.action.MASTER_CLEAR_NOTIFICATION"), "android.permission.MASTER_CLEAR", new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                condition.open();
            }

            final ConditionVariable val$condition;

             {
                condition = conditionvariable;
                super();
            }
        }, null, 0, null, null);
        condition.block();
        bootCommand(context, "--wipe_data");
    }

    public static void verifyPackage(File file, ProgressListener progresslistener, File file1) throws IOException, GeneralSecurityException {
        long l;
        RandomAccessFile randomaccessfile;
        int i;
        l = file.length();
        randomaccessfile = new RandomAccessFile(file, "r");
        i = 0;
        long l1;
        byte abyte0[];
        l1 = System.currentTimeMillis();
        if(progresslistener != null)
            progresslistener.onProgress(0);
        randomaccessfile.seek(l - 6L);
        abyte0 = new byte[6];
        randomaccessfile.readFully(abyte0);
        if(abyte0[2] != -1 || abyte0[3] != -1)
            throw new SignatureException("no signature in file (no footer)");
        break MISSING_BLOCK_LABEL_99;
        Exception exception;
        exception;
        randomaccessfile.close();
        throw exception;
        int j;
        int k;
        byte abyte1[];
        j = 0xff & abyte0[4] | (0xff & abyte0[5]) << 8;
        k = 0xff & abyte0[0] | (0xff & abyte0[1]) << 8;
        abyte1 = new byte[j + 22];
        randomaccessfile.seek(l - (long)(j + 22));
        randomaccessfile.readFully(abyte1);
        if(abyte1[0] != 80 || abyte1[1] != 75 || abyte1[2] != 5 || abyte1[3] != 6)
            throw new SignatureException("no signature in file (bad footer)");
          goto _L1
_L7:
        int i1;
        SignerInfo signerinfo;
        Signature signature;
        long l2;
        long l3;
        byte abyte2[];
        int j1 = -3 + abyte1.length;
        if(i1 < j1) {
            if(abyte1[i1] == 80 && abyte1[i1 + 1] == 75 && abyte1[i1 + 2] == 5 && abyte1[i1 + 3] == 6)
                throw new SignatureException("EOCD marker found after start of EOCD");
            break MISSING_BLOCK_LABEL_854;
        }
        ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte1, (j + 22) - k, k);
        BerInputStream berinputstream = new BerInputStream(bytearrayinputstream);
        SignedData signeddata = ((ContentInfo)ContentInfo.ASN1.decode(berinputstream)).getSignedData();
        if(signeddata == null)
            throw new IOException("signedData is null");
        List list = signeddata.getCertificates();
        if(list.isEmpty())
            throw new IOException("encCerts is empty");
        Iterator iterator = list.iterator();
        X509CertImpl x509certimpl;
        if(iterator.hasNext()) {
            x509certimpl = new X509CertImpl((Certificate)iterator.next());
            List list1 = signeddata.getSignerInfos();
            if(!list1.isEmpty()) {
                signerinfo = (SignerInfo)list1.get(0);
                if(file1 == null)
                    file1 = DEFAULT_KEYSTORE;
                HashSet hashset = getTrustedCerts(file1);
                java.security.PublicKey publickey = x509certimpl.getPublicKey();
                boolean flag = false;
                Iterator iterator1 = hashset.iterator();
                do {
                    if(!iterator1.hasNext())
                        break;
                    if(!((java.security.cert.Certificate)iterator1.next()).getPublicKey().equals(publickey))
                        continue;
                    flag = true;
                    break;
                } while(true);
                if(!flag)
                    throw new SignatureException("signature doesn't match any trusted key");
            } else {
                throw new IOException("no signer infos!");
            }
        } else {
            throw new SignatureException("signature contains no certificates");
        }
        String s = signerinfo.getDigestAlgorithm();
        String s1 = signerinfo.getDigestEncryptionAlgorithm();
        String s2;
        boolean flag1;
        if(s == null || s1 == null)
            s2 = x509certimpl.getSigAlgName();
        else
            s2 = (new StringBuilder()).append(s).append("with").append(s1).toString();
        signature = Signature.getInstance(s2);
        signature.initVerify(x509certimpl);
        l2 = l - (long)j - 2L;
        l3 = 0L;
        randomaccessfile.seek(0L);
        abyte2 = new byte[4096];
        flag1 = false;
_L6:
        if(l3 >= l2) goto _L3; else goto _L2
_L2:
        flag1 = Thread.interrupted();
        if(!flag1) goto _L4; else goto _L3
_L3:
        if(progresslistener != null)
            progresslistener.onProgress(100);
        if(flag1)
            throw new SignatureException("verification was interrupted");
        break; /* Loop/switch isn't completed */
_L4:
        int k1 = abyte2.length;
        if(l3 + (long)k1 > l2)
            k1 = (int)(l2 - l3);
        int i2 = randomaccessfile.read(abyte2, 0, k1);
        signature.update(abyte2, 0, i2);
        l3 += i2;
        if(progresslistener != null) {
            long l4 = System.currentTimeMillis();
            int j2 = (int)((100L * l3) / l2);
            if(j2 > i && l4 - l1 > 500L) {
                i = j2;
                l1 = l4;
                progresslistener.onProgress(i);
            }
        }
        if(true) goto _L6; else goto _L5
_L5:
        if(!signature.verify(signerinfo.getEncryptedDigest()))
            throw new SignatureException("signature digest verification failed");
        randomaccessfile.close();
        return;
_L1:
        i1 = 4;
          goto _L7
        i1++;
          goto _L7
    }

    private static File COMMAND_FILE;
    private static final File DEFAULT_KEYSTORE = new File("/system/etc/security/otacerts.zip");
    private static String LAST_PREFIX = "last_";
    private static File LOG_FILE;
    private static int LOG_FILE_MAX_LENGTH = 0;
    private static final long PUBLISH_PROGRESS_INTERVAL_MS = 500L;
    private static File RECOVERY_DIR;
    private static final String TAG = "RecoverySystem";

    static  {
        RECOVERY_DIR = new File("/cache/recovery");
        COMMAND_FILE = new File(RECOVERY_DIR, "command");
        LOG_FILE = new File(RECOVERY_DIR, "log");
        LOG_FILE_MAX_LENGTH = 0x10000;
    }
}
