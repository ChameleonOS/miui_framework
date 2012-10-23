// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import android.content.*;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteException;
import android.drm.DrmManagerClient;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.mms.*;
import com.google.android.mms.util.*;
import java.io.*;
import java.util.*;

// Referenced classes of package com.google.android.mms.pdu:
//            EncodedStringValue, PduHeaders, PduPart, PduBody, 
//            NotificationInd, DeliveryInd, ReadOrigInd, RetrieveConf, 
//            SendReq, AcknowledgeInd, NotifyRespInd, ReadRecInd, 
//            GenericPdu, MultimediaMessagePdu

public class PduPersister {

    private PduPersister(Context context) {
        mContext = context;
        mContentResolver = context.getContentResolver();
        mDrmManagerClient = new DrmManagerClient(context);
    }

    public static String convertUriToPath(Context context, Uri uri) {
        String s = null;
        if(uri == null) goto _L2; else goto _L1
_L1:
        String s1 = uri.getScheme();
        if(s1 != null && !s1.equals("") && !s1.equals("file")) goto _L4; else goto _L3
_L3:
        s = uri.getPath();
_L2:
        return s;
_L4:
        Cursor cursor;
label0:
        {
            if(s1.equals("http")) {
                s = uri.toString();
                continue; /* Loop/switch isn't completed */
            }
            if(!s1.equals("content"))
                break; /* Loop/switch isn't completed */
            String as[] = new String[1];
            as[0] = "_data";
            cursor = null;
            try {
                cursor = context.getContentResolver().query(uri, as, null, null, null);
                if(cursor == null || cursor.getCount() == 0 || !cursor.moveToFirst())
                    throw new IllegalArgumentException("Given Uri could not be found in media store");
                break label0;
            }
            catch(SQLiteException sqliteexception) { }
            finally {
                if(cursor != null)
                    cursor.close();
                throw exception;
            }
        }
        throw new IllegalArgumentException("Given Uri is not formatted in a way so that it can be found in media store.");
        String s2 = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
        s = s2;
        if(cursor != null)
            cursor.close();
        if(true) goto _L2; else goto _L5
_L5:
        throw new IllegalArgumentException("Given Uri scheme is not supported");
    }

    private byte[] getByteArrayFromPartColumn(Cursor cursor, int i) {
        byte abyte0[];
        if(!cursor.isNull(i))
            abyte0 = getBytes(cursor.getString(i));
        else
            abyte0 = null;
        return abyte0;
    }

    public static byte[] getBytes(String s) {
        byte abyte1[] = s.getBytes("iso-8859-1");
        byte abyte0[] = abyte1;
_L2:
        return abyte0;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        Log.e("PduPersister", "ISO_8859_1 must be supported!", unsupportedencodingexception);
        abyte0 = new byte[0];
        if(true) goto _L2; else goto _L1
_L1:
    }

    private Integer getIntegerFromPartColumn(Cursor cursor, int i) {
        Integer integer;
        if(!cursor.isNull(i))
            integer = Integer.valueOf(cursor.getInt(i));
        else
            integer = null;
        return integer;
    }

    public static PduPersister getPduPersister(Context context) {
        if(sPersister == null || !context.equals(sPersister.mContext))
            sPersister = new PduPersister(context);
        return sPersister;
    }

    private void loadAddress(long l, PduHeaders pduheaders) {
        Cursor cursor;
        Context context = mContext;
        ContentResolver contentresolver = mContentResolver;
        Uri uri = Uri.parse((new StringBuilder()).append("content://mms/").append(l).append("/addr").toString());
        String as[] = new String[3];
        as[0] = "address";
        as[1] = "charset";
        as[2] = "type";
        cursor = SqliteWrapper.query(context, contentresolver, uri, as, null, null, null);
        if(cursor == null)
            break MISSING_BLOCK_LABEL_279;
_L5:
        String s;
        int i;
        if(!cursor.moveToNext())
            break; /* Loop/switch isn't completed */
        s = cursor.getString(0);
        if(TextUtils.isEmpty(s))
            continue; /* Loop/switch isn't completed */
        i = cursor.getInt(2);
        i;
        JVM INSTR lookupswitch 4: default 172
    //                   129: 243
    //                   130: 243
    //                   137: 214
    //                   151: 243;
           goto _L1 _L2 _L2 _L3 _L2
_L1:
        Log.e("PduPersister", (new StringBuilder()).append("Unknown address type: ").append(i).toString());
        if(false)
            ;
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        cursor.close();
        throw exception;
_L3:
        pduheaders.setEncodedStringValue(new EncodedStringValue(cursor.getInt(1), getBytes(s)), i);
        break; /* Loop/switch isn't completed */
_L2:
        pduheaders.appendEncodedStringValue(new EncodedStringValue(cursor.getInt(1), getBytes(s)), i);
        if(true) goto _L5; else goto _L4
_L4:
        cursor.close();
    }

    private PduPart[] loadParts(long l) throws MmsException {
        Cursor cursor = SqliteWrapper.query(mContext, mContentResolver, Uri.parse((new StringBuilder()).append("content://mms/").append(l).append("/part").toString()), PART_PROJECTION, null, null, null);
        if(cursor == null) goto _L2; else goto _L1
_L1:
        int i = cursor.getCount();
        if(i != 0) goto _L3; else goto _L2
_L2:
        PduPart apdupart[];
        apdupart = null;
        if(cursor != null)
            cursor.close();
_L19:
        return apdupart;
_L3:
        PduPart apdupart1[];
        int j;
        apdupart1 = new PduPart[cursor.getCount()];
        j = 0;
_L12:
        PduPart pdupart;
        byte abyte3[];
        if(!cursor.moveToNext())
            break MISSING_BLOCK_LABEL_626;
        pdupart = new PduPart();
        Integer integer = getIntegerFromPartColumn(cursor, 1);
        if(integer != null)
            pdupart.setCharset(integer.intValue());
        byte abyte0[] = getByteArrayFromPartColumn(cursor, 2);
        if(abyte0 != null)
            pdupart.setContentDisposition(abyte0);
        byte abyte1[] = getByteArrayFromPartColumn(cursor, 3);
        if(abyte1 != null)
            pdupart.setContentId(abyte1);
        byte abyte2[] = getByteArrayFromPartColumn(cursor, 4);
        if(abyte2 != null)
            pdupart.setContentLocation(abyte2);
        abyte3 = getByteArrayFromPartColumn(cursor, 5);
        if(abyte3 == null) goto _L5; else goto _L4
_L4:
        Uri uri;
        String s;
        pdupart.setContentType(abyte3);
        byte abyte4[] = getByteArrayFromPartColumn(cursor, 6);
        if(abyte4 != null)
            pdupart.setFilename(abyte4);
        byte abyte5[] = getByteArrayFromPartColumn(cursor, 7);
        if(abyte5 != null)
            pdupart.setName(abyte5);
        long l1 = cursor.getLong(0);
        uri = Uri.parse((new StringBuilder()).append("content://mms/part/").append(l1).toString());
        pdupart.setDataUri(uri);
        s = toIsoString(abyte3);
        if(ContentType.isImageType(s) || ContentType.isAudioType(s) || ContentType.isVideoType(s)) goto _L7; else goto _L6
_L6:
        ByteArrayOutputStream bytearrayoutputstream;
        InputStream inputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();
        inputstream = null;
        if(!"text/plain".equals(s) && !"application/smil".equals(s) && !"text/html".equals(s)) goto _L9; else goto _L8
_L8:
        String s1 = cursor.getString(8);
        if(s1 == null) goto _L11; else goto _L10
_L10:
        byte abyte6[] = (new EncodedStringValue(s1)).getTextString();
        bytearrayoutputstream.write(abyte6, 0, abyte6.length);
_L17:
        pdupart.setData(bytearrayoutputstream.toByteArray());
_L7:
        int k = j + 1;
        apdupart1[j] = pdupart;
        j = k;
          goto _L12
_L5:
        throw new MmsException("Content-Type must be set.");
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
_L11:
        s1 = "";
          goto _L10
_L9:
        byte abyte7[];
        int i1;
        inputstream = mContentResolver.openInputStream(uri);
        abyte7 = new byte[256];
        i1 = inputstream.read(abyte7);
_L15:
        if(i1 < 0) goto _L14; else goto _L13
_L13:
        int j1;
        bytearrayoutputstream.write(abyte7, 0, i1);
        j1 = inputstream.read(abyte7);
        i1 = j1;
          goto _L15
_L14:
        if(inputstream == null) goto _L17; else goto _L16
_L16:
        inputstream.close();
          goto _L17
        IOException ioexception2;
        ioexception2;
        Log.e("PduPersister", "Failed to close stream", ioexception2);
          goto _L17
        IOException ioexception1;
        ioexception1;
        Log.e("PduPersister", "Failed to load part data", ioexception1);
        cursor.close();
        throw new MmsException(ioexception1);
        Exception exception1;
        exception1;
        if(inputstream == null)
            break MISSING_BLOCK_LABEL_607;
        try {
            inputstream.close();
        }
        catch(IOException ioexception) {
            Log.e("PduPersister", "Failed to close stream", ioexception);
        }
        throw exception1;
        if(cursor != null)
            cursor.close();
        apdupart = apdupart1;
        if(true) goto _L19; else goto _L18
_L18:
    }

    private void persistAddress(long l, int i, EncodedStringValue aencodedstringvalue[]) {
        ContentValues contentvalues = new ContentValues(3);
        int j = aencodedstringvalue.length;
        for(int k = 0; k < j; k++) {
            EncodedStringValue encodedstringvalue = aencodedstringvalue[k];
            contentvalues.clear();
            contentvalues.put("address", toIsoString(encodedstringvalue.getTextString()));
            contentvalues.put("charset", Integer.valueOf(encodedstringvalue.getCharacterSet()));
            contentvalues.put("type", Integer.valueOf(i));
            Uri uri = Uri.parse((new StringBuilder()).append("content://mms/").append(l).append("/addr").toString());
            SqliteWrapper.insert(mContext, mContentResolver, uri, contentvalues);
        }

    }

    private void persistData(PduPart pdupart, Uri uri, String s) throws MmsException {
        OutputStream outputstream;
        InputStream inputstream;
        DrmConvertSession drmconvertsession;
        String s1;
        outputstream = null;
        inputstream = null;
        drmconvertsession = null;
        s1 = null;
        byte abyte0[] = pdupart.getData();
        if(!"text/plain".equals(s) && !"application/smil".equals(s) && !"text/html".equals(s)) goto _L2; else goto _L1
_L1:
        ContentValues contentvalues1 = new ContentValues();
        contentvalues1.put("text", (new EncodedStringValue(abyte0)).getString());
        if(mContentResolver.update(uri, contentvalues1, null, null) != 1)
            throw new MmsException((new StringBuilder()).append("unable to update ").append(uri.toString()).toString());
          goto _L3
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        Log.e("PduPersister", "Failed to open Input/Output stream.", filenotfoundexception);
        throw new MmsException(filenotfoundexception);
        Exception exception;
        exception;
        IOException ioexception;
        File file1;
        ContentValues contentvalues2;
        Context context;
        ContentResolver contentresolver;
        Uri uri1;
        boolean flag;
        byte abyte1[];
        int i;
        Uri uri2;
        File file2;
        byte abyte2[];
        int j;
        byte abyte3[];
        int k;
        Exception exception1;
        long l;
        if(outputstream != null)
            try {
                outputstream.close();
            }
            catch(IOException ioexception2) {
                Log.e("PduPersister", (new StringBuilder()).append("IOException while closing: ").append(outputstream).toString(), ioexception2);
            }
        if(inputstream != null)
            try {
                inputstream.close();
            }
            catch(IOException ioexception1) {
                Log.e("PduPersister", (new StringBuilder()).append("IOException while closing: ").append(inputstream).toString(), ioexception1);
            }
        if(drmconvertsession != null) {
            drmconvertsession.close(s1);
            File file = new File(s1);
            ContentValues contentvalues = new ContentValues(0);
            SqliteWrapper.update(mContext, mContentResolver, Uri.parse((new StringBuilder()).append("content://mms/resetFilePerm/").append(file.getName()).toString()), contentvalues, null, null);
        }
        throw exception;
_L2:
        flag = DownloadDrmHelper.isDrmConvertNeeded(s);
        if(!flag) goto _L5; else goto _L4
_L4:
        if(uri == null) goto _L7; else goto _L6
_L6:
        s1 = convertUriToPath(mContext, uri);
        l = (new File(s1)).length();
        if(l <= 0L) goto _L7; else goto _L8
_L8:
        IOException ioexception3;
        IOException ioexception4;
        IOException ioexception5;
        IOException ioexception6;
        if(false)
            try {
                throw null;
            }
            catch(IOException ioexception8) {
                Log.e("PduPersister", (new StringBuilder()).append("IOException while closing: ").append(null).toString(), ioexception8);
            }
        if(false)
            try {
                throw null;
            }
            catch(IOException ioexception7) {
                Log.e("PduPersister", (new StringBuilder()).append("IOException while closing: ").append(null).toString(), ioexception7);
            }
        if(false) {
            s1;
            throw null;
        }
          goto _L9
_L15:
        SqliteWrapper.update(context, contentresolver, uri1, contentvalues2, null, null);
_L9:
        return;
        exception1;
        Log.e("PduPersister", (new StringBuilder()).append("Can't get file info for: ").append(pdupart.getDataUri()).toString(), exception1);
_L7:
        drmconvertsession = DrmConvertSession.open(mContext, s);
        if(drmconvertsession == null)
            throw new MmsException((new StringBuilder()).append("Mimetype ").append(s).append(" can not be converted.").toString());
          goto _L5
        ioexception;
        Log.e("PduPersister", "Failed to read/write data.", ioexception);
        throw new MmsException(ioexception);
_L5:
        outputstream = mContentResolver.openOutputStream(uri);
        if(abyte0 != null) goto _L11; else goto _L10
_L10:
        uri2 = pdupart.getDataUri();
        if(uri2 != null && uri2 != uri) goto _L13; else goto _L12
_L12:
        Log.w("PduPersister", "Can't find data for this part.");
        if(outputstream != null)
            try {
                outputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception6) {
                Log.e("PduPersister", (new StringBuilder()).append("IOException while closing: ").append(outputstream).toString(), ioexception6);
            }
        if(false)
            try {
                throw null;
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception5) {
                Log.e("PduPersister", (new StringBuilder()).append("IOException while closing: ").append(null).toString(), ioexception5);
            }
        if(drmconvertsession == null) goto _L9; else goto _L14
_L14:
        drmconvertsession.close(s1);
        file2 = new File(s1);
        contentvalues2 = new ContentValues(0);
        context = mContext;
        contentresolver = mContentResolver;
        uri1 = Uri.parse((new StringBuilder()).append("content://mms/resetFilePerm/").append(file2.getName()).toString());
          goto _L15
_L13:
        inputstream = mContentResolver.openInputStream(uri2);
        abyte2 = new byte[8192];
        do {
            j = inputstream.read(abyte2);
            if(j == -1)
                break;
            if(!flag) {
                outputstream.write(abyte2, 0, j);
            } else {
                abyte3 = drmconvertsession.convert(abyte2, j);
                if(abyte3 != null) {
                    k = abyte3.length;
                    outputstream.write(abyte3, 0, k);
                } else {
                    throw new MmsException("Error converting drm data.");
                }
            }
        } while(true);
          goto _L3
_L11:
        if(flag) goto _L17; else goto _L16
_L16:
        outputstream.write(abyte0);
_L3:
        if(outputstream != null)
            try {
                outputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception4) {
                Log.e("PduPersister", (new StringBuilder()).append("IOException while closing: ").append(outputstream).toString(), ioexception4);
            }
        if(inputstream != null)
            try {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception3) {
                Log.e("PduPersister", (new StringBuilder()).append("IOException while closing: ").append(inputstream).toString(), ioexception3);
            }
        if(drmconvertsession == null) goto _L9; else goto _L18
_L18:
        drmconvertsession.close(s1);
        file1 = new File(s1);
        contentvalues2 = new ContentValues(0);
        context = mContext;
        contentresolver = mContentResolver;
        uri1 = Uri.parse((new StringBuilder()).append("content://mms/resetFilePerm/").append(file1.getName()).toString());
          goto _L15
_L17:
label0:
        {
            abyte1 = drmconvertsession.convert(abyte0, abyte0.length);
            if(abyte1 == null)
                break label0;
            i = abyte1.length;
            outputstream.write(abyte1, 0, i);
        }
          goto _L3
        throw new MmsException("Error converting drm data.");
          goto _L15
    }

    private void setEncodedStringValueToHeaders(Cursor cursor, int i, PduHeaders pduheaders, int j) {
        String s = cursor.getString(i);
        if(s != null && s.length() > 0)
            pduheaders.setEncodedStringValue(new EncodedStringValue(cursor.getInt(((Integer)CHARSET_COLUMN_INDEX_MAP.get(Integer.valueOf(j))).intValue()), getBytes(s)), j);
    }

    private void setLongToHeaders(Cursor cursor, int i, PduHeaders pduheaders, int j) {
        if(!cursor.isNull(i))
            pduheaders.setLongInteger(cursor.getLong(i), j);
    }

    private void setOctetToHeaders(Cursor cursor, int i, PduHeaders pduheaders, int j) throws InvalidHeaderValueException {
        if(!cursor.isNull(i))
            pduheaders.setOctet(cursor.getInt(i), j);
    }

    private void setTextStringToHeaders(Cursor cursor, int i, PduHeaders pduheaders, int j) {
        String s = cursor.getString(i);
        if(s != null)
            pduheaders.setTextString(getBytes(s), j);
    }

    public static String toIsoString(byte abyte0[]) {
        String s;
        try {
            s = new String(abyte0, "iso-8859-1");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            Log.e("PduPersister", "ISO_8859_1 must be supported!", unsupportedencodingexception);
            s = "";
        }
        return s;
    }

    private void updateAddress(long l, int i, EncodedStringValue aencodedstringvalue[]) {
        SqliteWrapper.delete(mContext, mContentResolver, Uri.parse((new StringBuilder()).append("content://mms/").append(l).append("/addr").toString()), (new StringBuilder()).append("type=").append(i).toString(), null);
        persistAddress(l, i, aencodedstringvalue);
    }

    private void updatePart(Uri uri, PduPart pdupart) throws MmsException {
        ContentValues contentvalues = new ContentValues(7);
        int i = pdupart.getCharset();
        if(i != 0)
            contentvalues.put("chset", Integer.valueOf(i));
        if(pdupart.getContentType() != null) {
            String s = toIsoString(pdupart.getContentType());
            contentvalues.put("ct", s);
            if(pdupart.getFilename() != null)
                contentvalues.put("fn", new String(pdupart.getFilename()));
            if(pdupart.getName() != null)
                contentvalues.put("name", new String(pdupart.getName()));
            if(pdupart.getContentDisposition() != null)
                contentvalues.put("cd", (String)toIsoString(pdupart.getContentDisposition()));
            if(pdupart.getContentId() != null)
                contentvalues.put("cid", (String)toIsoString(pdupart.getContentId()));
            if(pdupart.getContentLocation() != null)
                contentvalues.put("cl", (String)toIsoString(pdupart.getContentLocation()));
            SqliteWrapper.update(mContext, mContentResolver, uri, contentvalues, null, null);
            if(pdupart.getData() != null || uri != pdupart.getDataUri())
                persistData(pdupart, uri, s);
            return;
        } else {
            throw new MmsException("MIME type of the part must be set.");
        }
    }

    public Cursor getPendingMessages(long l) {
        android.net.Uri.Builder builder = android.provider.Telephony.MmsSms.PendingMessages.CONTENT_URI.buildUpon();
        builder.appendQueryParameter("protocol", "mms");
        String as[] = new String[2];
        as[0] = String.valueOf(10);
        as[1] = String.valueOf(l);
        return SqliteWrapper.query(mContext, mContentResolver, builder.build(), null, "err_type < ? AND due_time <= ?", as, "due_time");
    }

    public GenericPdu load(Uri uri) throws MmsException {
        PduCacheEntry pducacheentry;
        int i;
        long l;
        pducacheentry = null;
        i = 0;
        l = -1L;
        PduCache pducache1 = PDU_CACHE_INSTANCE;
        pducache1;
        JVM INSTR monitorenter ;
        boolean flag = PDU_CACHE_INSTANCE.isUpdating(uri);
        if(!flag) goto _L2; else goto _L1
_L1:
        PDU_CACHE_INSTANCE.wait();
_L7:
        pducacheentry = (PduCacheEntry)PDU_CACHE_INSTANCE.get(uri);
        if(pducacheentry == null) goto _L2; else goto _L3
_L3:
        Object obj1 = pducacheentry.getPdu();
        pducache1;
        JVM INSTR monitorexit ;
        PduCache pducache3 = PDU_CACHE_INSTANCE;
        pducache3;
        JVM INSTR monitorenter ;
        if(true) goto _L5; else goto _L4
_L4:
        if(!$assertionsDisabled && PDU_CACHE_INSTANCE.get(uri) != null)
            throw new AssertionError();
          goto _L6
_L20:
        pducache3;
        JVM INSTR monitorexit ;
        Exception exception5;
        throw exception5;
        InterruptedException interruptedexception;
        interruptedexception;
        Log.e("PduPersister", "load: ", interruptedexception);
          goto _L7
_L22:
        pducache1;
        JVM INSTR monitorexit ;
        Exception exception2;
        throw exception2;
        Exception exception;
        exception;
_L11:
        PduCache pducache = PDU_CACHE_INSTANCE;
        pducache;
        JVM INSTR monitorenter ;
        if(true) goto _L9; else goto _L8
_L8:
        if(!$assertionsDisabled && PDU_CACHE_INSTANCE.get(uri) != null)
            throw new AssertionError();
          goto _L10
_L21:
        pducache;
        JVM INSTR monitorexit ;
        Exception exception1;
        throw exception1;
_L2:
        pducacheentry;
        PDU_CACHE_INSTANCE.setUpdating(uri, true);
        pducache1;
        JVM INSTR monitorexit ;
        Cursor cursor;
        PduHeaders pduheaders;
        long l1;
        cursor = SqliteWrapper.query(mContext, mContentResolver, uri, PDU_PROJECTION, null, null, null);
        pduheaders = new PduHeaders();
        l1 = ContentUris.parseId(uri);
        if(cursor == null)
            break MISSING_BLOCK_LABEL_243;
        if(cursor.getCount() == 1 && cursor.moveToFirst())
            break MISSING_BLOCK_LABEL_293;
        throw new MmsException((new StringBuilder()).append("Bad uri: ").append(uri).toString());
        Exception exception3;
        exception3;
        if(cursor == null)
            break MISSING_BLOCK_LABEL_285;
        cursor.close();
        throw exception3;
        exception;
          goto _L11
        i = cursor.getInt(1);
        l = cursor.getLong(2);
        java.util.Map.Entry entry3;
        for(Iterator iterator = ENCODED_STRING_COLUMN_INDEX_MAP.entrySet().iterator(); iterator.hasNext(); setEncodedStringValueToHeaders(cursor, ((Integer)entry3.getValue()).intValue(), pduheaders, ((Integer)entry3.getKey()).intValue()))
            entry3 = (java.util.Map.Entry)iterator.next();

        java.util.Map.Entry entry2;
        for(Iterator iterator1 = TEXT_STRING_COLUMN_INDEX_MAP.entrySet().iterator(); iterator1.hasNext(); setTextStringToHeaders(cursor, ((Integer)entry2.getValue()).intValue(), pduheaders, ((Integer)entry2.getKey()).intValue()))
            entry2 = (java.util.Map.Entry)iterator1.next();

        java.util.Map.Entry entry1;
        for(Iterator iterator2 = OCTET_COLUMN_INDEX_MAP.entrySet().iterator(); iterator2.hasNext(); setOctetToHeaders(cursor, ((Integer)entry1.getValue()).intValue(), pduheaders, ((Integer)entry1.getKey()).intValue()))
            entry1 = (java.util.Map.Entry)iterator2.next();

        java.util.Map.Entry entry;
        for(Iterator iterator3 = LONG_COLUMN_INDEX_MAP.entrySet().iterator(); iterator3.hasNext(); setLongToHeaders(cursor, ((Integer)entry.getValue()).intValue(), pduheaders, ((Integer)entry.getKey()).intValue()))
            entry = (java.util.Map.Entry)iterator3.next();

        if(cursor == null)
            break MISSING_BLOCK_LABEL_612;
        cursor.close();
        int j;
        PduBody pdubody;
        if(l1 == -1L)
            throw new MmsException("Error! ID of the message: -1.");
        loadAddress(l1, pduheaders);
        j = pduheaders.getOctet(140);
        pdubody = new PduBody();
        if(j == 132 || j == 128) {
            PduPart apdupart[] = loadParts(l1);
            if(apdupart != null) {
                int k = apdupart.length;
                for(int i1 = 0; i1 < k; i1++)
                    pdubody.addPart(apdupart[i1]);

            }
        }
          goto _L12
_L23:
        throw new MmsException((new StringBuilder()).append("Unrecognized PDU type: ").append(Integer.toHexString(j)).toString());
_L26:
        NotificationInd notificationind = new NotificationInd(pduheaders);
        Object obj = notificationind;
_L16:
        PduCache pducache2 = PDU_CACHE_INSTANCE;
        pducache2;
        JVM INSTR monitorenter ;
        if(obj == null) goto _L14; else goto _L13
_L13:
        if(!$assertionsDisabled && PDU_CACHE_INSTANCE.get(uri) != null)
            throw new AssertionError();
          goto _L15
        Exception exception4;
        exception4;
_L19:
        pducache2;
        JVM INSTR monitorexit ;
        throw exception4;
_L30:
        DeliveryInd deliveryind = new DeliveryInd(pduheaders);
        obj = deliveryind;
          goto _L16
_L32:
        ReadOrigInd readorigind = new ReadOrigInd(pduheaders);
        obj = readorigind;
          goto _L16
_L28:
        RetrieveConf retrieveconf = new RetrieveConf(pduheaders, pdubody);
        obj = retrieveconf;
          goto _L16
_L24:
        SendReq sendreq = new SendReq(pduheaders, pdubody);
        obj = sendreq;
          goto _L16
_L29:
        AcknowledgeInd acknowledgeind = new AcknowledgeInd(pduheaders);
        obj = acknowledgeind;
          goto _L16
_L27:
        NotifyRespInd notifyrespind = new NotifyRespInd(pduheaders);
        obj = notifyrespind;
          goto _L16
_L31:
        ReadRecInd readrecind = new ReadRecInd(pduheaders);
        obj = readrecind;
          goto _L16
_L25:
        throw new MmsException((new StringBuilder()).append("Unsupported PDU type: ").append(Integer.toHexString(j)).toString());
_L10:
        PduCacheEntry pducacheentry1 = new PduCacheEntry(null, i, l);
        PDU_CACHE_INSTANCE.put(uri, pducacheentry1);
_L9:
        PDU_CACHE_INSTANCE.setUpdating(uri, false);
        PDU_CACHE_INSTANCE.notifyAll();
        pducache;
        JVM INSTR monitorexit ;
        throw exception;
_L15:
        PduCacheEntry pducacheentry2 = new PduCacheEntry(((GenericPdu) (obj)), i, l);
        PDU_CACHE_INSTANCE.put(uri, pducacheentry2);
_L14:
        PDU_CACHE_INSTANCE.setUpdating(uri, false);
        PDU_CACHE_INSTANCE.notifyAll();
        pducache2;
        JVM INSTR monitorexit ;
        obj1 = obj;
_L18:
        return ((GenericPdu) (obj1));
_L6:
        PduCacheEntry pducacheentry3 = new PduCacheEntry(null, 0, l);
        PDU_CACHE_INSTANCE.put(uri, pducacheentry3);
_L5:
        PDU_CACHE_INSTANCE.setUpdating(uri, false);
        PDU_CACHE_INSTANCE.notifyAll();
        pducache3;
        JVM INSTR monitorexit ;
        if(true) goto _L18; else goto _L17
_L17:
        exception4;
          goto _L19
        exception5;
          goto _L20
        exception1;
          goto _L21
        exception2;
          goto _L22
        exception5;
          goto _L20
        exception2;
          goto _L22
        exception1;
          goto _L21
_L12:
        j;
        JVM INSTR tableswitch 128 151: default 720
    //                   128 868
    //                   129 942
    //                   130 752
    //                   131 906
    //                   132 848
    //                   133 888
    //                   134 812
    //                   135 924
    //                   136 830
    //                   137 942
    //                   138 942
    //                   139 942
    //                   140 942
    //                   141 942
    //                   142 942
    //                   143 942
    //                   144 942
    //                   145 942
    //                   146 942
    //                   147 942
    //                   148 942
    //                   149 942
    //                   150 942
    //                   151 942;
           goto _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L25 _L25 _L25 _L25 _L25 _L25 _L25 _L25 _L25 _L25 _L25 _L25 _L25 _L25 _L25
    }

    public Uri move(Uri uri, Uri uri1) throws MmsException {
        long l = ContentUris.parseId(uri);
        if(l == -1L)
            throw new MmsException("Error! ID of the message: -1.");
        Integer integer = (Integer)MESSAGE_BOX_MAP.get(uri1);
        if(integer == null) {
            throw new MmsException("Bad destination, must be one of content://mms/inbox, content://mms/sent, content://mms/drafts, content://mms/outbox, content://mms/temp.");
        } else {
            ContentValues contentvalues = new ContentValues(1);
            contentvalues.put("msg_box", integer);
            SqliteWrapper.update(mContext, mContentResolver, uri, contentvalues, null, null);
            return ContentUris.withAppendedId(uri1, l);
        }
    }

    public Uri persist(GenericPdu genericpdu, Uri uri) throws MmsException {
        long l;
        if(uri == null)
            throw new MmsException("Uri may not be null.");
        l = -1L;
        long l4 = ContentUris.parseId(uri);
        l = l4;
_L6:
        boolean flag;
        if(l != -1L)
            flag = true;
        else
            flag = false;
        if(!flag && MESSAGE_BOX_MAP.get(uri) == null)
            throw new MmsException("Bad destination, must be one of content://mms/inbox, content://mms/sent, content://mms/drafts, content://mms/outbox, content://mms/temp.");
        PduCache pducache = PDU_CACHE_INSTANCE;
        pducache;
        JVM INSTR monitorenter ;
        boolean flag1 = PDU_CACHE_INSTANCE.isUpdating(uri);
        if(!flag1)
            break MISSING_BLOCK_LABEL_99;
        PduHeaders pduheaders;
        ContentValues contentvalues;
        try {
            PDU_CACHE_INSTANCE.wait();
        }
        catch(InterruptedException interruptedexception) {
            Log.e("PduPersister", "persist1: ", interruptedexception);
        }
        pducache;
        JVM INSTR monitorexit ;
        PDU_CACHE_INSTANCE.purge(uri);
        pduheaders = genericpdu.getPduHeaders();
        contentvalues = new ContentValues();
        Iterator iterator = ENCODED_STRING_COLUMN_NAME_MAP.entrySet().iterator();
        do {
            if(!iterator.hasNext())
                break;
            java.util.Map.Entry entry3 = (java.util.Map.Entry)iterator.next();
            int k3 = ((Integer)entry3.getKey()).intValue();
            EncodedStringValue encodedstringvalue2 = pduheaders.getEncodedStringValue(k3);
            if(encodedstringvalue2 != null) {
                String s = (String)CHARSET_COLUMN_NAME_MAP.get(Integer.valueOf(k3));
                contentvalues.put((String)entry3.getValue(), toIsoString(encodedstringvalue2.getTextString()));
                contentvalues.put(s, Integer.valueOf(encodedstringvalue2.getCharacterSet()));
            }
        } while(true);
        break MISSING_BLOCK_LABEL_270;
        Exception exception;
        exception;
        throw exception;
        HashMap hashmap;
        HashSet hashset;
        int k;
        EncodedStringValue aencodedstringvalue[];
        Iterator iterator1 = TEXT_STRING_COLUMN_NAME_MAP.entrySet().iterator();
        do {
            if(!iterator1.hasNext())
                break;
            java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator1.next();
            byte abyte0[] = pduheaders.getTextString(((Integer)entry2.getKey()).intValue());
            if(abyte0 != null)
                contentvalues.put((String)entry2.getValue(), toIsoString(abyte0));
        } while(true);
        Iterator iterator2 = OCTET_COLUMN_NAME_MAP.entrySet().iterator();
        do {
            if(!iterator2.hasNext())
                break;
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator2.next();
            int j3 = pduheaders.getOctet(((Integer)entry1.getKey()).intValue());
            if(j3 != 0)
                contentvalues.put((String)entry1.getValue(), Integer.valueOf(j3));
        } while(true);
        Iterator iterator3 = LONG_COLUMN_NAME_MAP.entrySet().iterator();
        do {
            if(!iterator3.hasNext())
                break;
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator3.next();
            long l3 = pduheaders.getLongInteger(((Integer)entry.getKey()).intValue());
            if(l3 != -1L)
                contentvalues.put((String)entry.getValue(), Long.valueOf(l3));
        } while(true);
        hashmap = new HashMap(ADDRESS_FIELDS.length);
        int ai[] = ADDRESS_FIELDS;
        int i = ai.length;
        int j = 0;
        while(j < i)  {
            int i3 = ai[j];
            EncodedStringValue aencodedstringvalue2[] = null;
            if(i3 == 137) {
                EncodedStringValue encodedstringvalue1 = pduheaders.getEncodedStringValue(i3);
                if(encodedstringvalue1 != null) {
                    aencodedstringvalue2 = new EncodedStringValue[1];
                    aencodedstringvalue2[0] = encodedstringvalue1;
                }
            } else {
                aencodedstringvalue2 = pduheaders.getEncodedStringValues(i3);
            }
            hashmap.put(Integer.valueOf(i3), aencodedstringvalue2);
            j++;
        }
        hashset = new HashSet();
        k = genericpdu.getMessageType();
        if(k != 130 && k != 132 && k != 128)
            break MISSING_BLOCK_LABEL_826;
        aencodedstringvalue = null;
        k;
        JVM INSTR tableswitch 128 132: default 708
    //                   128 780
    //                   129 708
    //                   130 761
    //                   131 708
    //                   132 761;
           goto _L1 _L2 _L1 _L3 _L1 _L3
_L1:
        if(aencodedstringvalue != null) {
            Object obj = aencodedstringvalue;
            int k2 = obj.length;
            for(int l2 = 0; l2 < k2; l2++) {
                EncodedStringValue encodedstringvalue = obj[l2];
                if(encodedstringvalue != null)
                    hashset.add(encodedstringvalue.getString());
            }

        }
        break; /* Loop/switch isn't completed */
_L3:
        aencodedstringvalue = (EncodedStringValue[])hashmap.get(Integer.valueOf(137));
        continue; /* Loop/switch isn't completed */
_L2:
        aencodedstringvalue = (EncodedStringValue[])hashmap.get(Integer.valueOf(151));
        if(true) goto _L1; else goto _L4
_L4:
        if(!hashset.isEmpty())
            contentvalues.put("thread_id", Long.valueOf(android.provider.Telephony.Threads.getOrCreateThreadId(mContext, hashset)));
        Uri uri1;
        long l1 = System.currentTimeMillis();
        if(genericpdu instanceof MultimediaMessagePdu) {
            PduBody pdubody = ((MultimediaMessagePdu)genericpdu).getBody();
            if(pdubody != null) {
                int i2 = pdubody.getPartsNum();
                for(int j2 = 0; j2 < i2; j2++)
                    persistPart(pdubody.getPart(j2), l1);

            }
        }
        ContentValues contentvalues1;
        int ai1[];
        int i1;
        if(flag) {
            uri1 = uri;
            SqliteWrapper.update(mContext, mContentResolver, uri1, contentvalues, null, null);
        } else {
            uri1 = SqliteWrapper.insert(mContext, mContentResolver, uri, contentvalues);
            if(uri1 == null)
                throw new MmsException("persist() failed: return null.");
            l = ContentUris.parseId(uri1);
        }
        contentvalues1 = new ContentValues(1);
        contentvalues1.put("mid", Long.valueOf(l));
        SqliteWrapper.update(mContext, mContentResolver, Uri.parse((new StringBuilder()).append("content://mms/").append(l1).append("/part").toString()), contentvalues1, null, null);
        if(!flag)
            uri1 = Uri.parse((new StringBuilder()).append(uri).append("/").append(l).toString());
        ai1 = ADDRESS_FIELDS;
        i1 = ai1.length;
        for(int j1 = 0; j1 < i1; j1++) {
            int k1 = ai1[j1];
            EncodedStringValue aencodedstringvalue1[] = (EncodedStringValue[])hashmap.get(Integer.valueOf(k1));
            if(aencodedstringvalue1 != null)
                persistAddress(l, k1, aencodedstringvalue1);
        }

        break MISSING_BLOCK_LABEL_1125;
        NumberFormatException numberformatexception;
        numberformatexception;
        if(true) goto _L6; else goto _L5
_L5:
        return uri1;
    }

    public Uri persistPart(PduPart pdupart, long l) throws MmsException {
        Uri uri = Uri.parse((new StringBuilder()).append("content://mms/").append(l).append("/part").toString());
        ContentValues contentvalues = new ContentValues(8);
        int i = pdupart.getCharset();
        if(i != 0)
            contentvalues.put("chset", Integer.valueOf(i));
        if(pdupart.getContentType() != null) {
            String s = toIsoString(pdupart.getContentType());
            if("image/jpg".equals(s))
                s = "image/jpeg";
            contentvalues.put("ct", s);
            if("application/smil".equals(s))
                contentvalues.put("seq", Integer.valueOf(-1));
            if(pdupart.getFilename() != null)
                contentvalues.put("fn", new String(pdupart.getFilename()));
            if(pdupart.getName() != null)
                contentvalues.put("name", new String(pdupart.getName()));
            if(pdupart.getContentDisposition() != null)
                contentvalues.put("cd", (String)toIsoString(pdupart.getContentDisposition()));
            if(pdupart.getContentId() != null)
                contentvalues.put("cid", (String)toIsoString(pdupart.getContentId()));
            if(pdupart.getContentLocation() != null)
                contentvalues.put("cl", (String)toIsoString(pdupart.getContentLocation()));
            Uri uri1 = SqliteWrapper.insert(mContext, mContentResolver, uri, contentvalues);
            if(uri1 == null) {
                throw new MmsException("Failed to persist part, return null.");
            } else {
                persistData(pdupart, uri1, s);
                pdupart.setDataUri(uri1);
                return uri1;
            }
        } else {
            throw new MmsException("MIME type of the part must be set.");
        }
    }

    public void release() {
        Uri uri = Uri.parse("content://mms/9223372036854775807/part");
        SqliteWrapper.delete(mContext, mContentResolver, uri, null, null);
    }

    public void updateHeaders(Uri uri, SendReq sendreq) {
        PduCache pducache = PDU_CACHE_INSTANCE;
        pducache;
        JVM INSTR monitorenter ;
        boolean flag = PDU_CACHE_INSTANCE.isUpdating(uri);
        if(!flag)
            break MISSING_BLOCK_LABEL_26;
        ContentValues contentvalues;
        HashSet hashset;
        try {
            PDU_CACHE_INSTANCE.wait();
        }
        catch(InterruptedException interruptedexception) {
            Log.e("PduPersister", "updateHeaders: ", interruptedexception);
        }
        pducache;
        JVM INSTR monitorexit ;
        PDU_CACHE_INSTANCE.purge(uri);
        contentvalues = new ContentValues(10);
        byte abyte0[] = sendreq.getContentType();
        if(abyte0 != null)
            contentvalues.put("ct_t", toIsoString(abyte0));
        long l = sendreq.getDate();
        if(l != -1L)
            contentvalues.put("date", Long.valueOf(l));
        int i = sendreq.getDeliveryReport();
        if(i != 0)
            contentvalues.put("d_rpt", Integer.valueOf(i));
        long l1 = sendreq.getExpiry();
        if(l1 != -1L)
            contentvalues.put("exp", Long.valueOf(l1));
        byte abyte1[] = sendreq.getMessageClass();
        if(abyte1 != null)
            contentvalues.put("m_cls", toIsoString(abyte1));
        int j = sendreq.getPriority();
        if(j != 0)
            contentvalues.put("pri", Integer.valueOf(j));
        int k = sendreq.getReadReport();
        if(k != 0)
            contentvalues.put("rr", Integer.valueOf(k));
        byte abyte2[] = sendreq.getTransactionId();
        if(abyte2 != null)
            contentvalues.put("tr_id", toIsoString(abyte2));
        EncodedStringValue encodedstringvalue = sendreq.getSubject();
        long l2;
        PduHeaders pduheaders;
        int ai[];
        int i1;
        if(encodedstringvalue != null) {
            contentvalues.put("sub", toIsoString(encodedstringvalue.getTextString()));
            contentvalues.put("sub_cs", Integer.valueOf(encodedstringvalue.getCharacterSet()));
        } else {
            contentvalues.put("sub", "");
        }
        l2 = sendreq.getMessageSize();
        if(l2 > 0L)
            contentvalues.put("m_size", Long.valueOf(l2));
        pduheaders = sendreq.getPduHeaders();
        hashset = new HashSet();
        ai = ADDRESS_FIELDS;
        i1 = ai.length;
label0:
        for(int j1 = 0; j1 < i1; j1++) {
            int k1 = ai[j1];
            EncodedStringValue aencodedstringvalue[] = null;
            Exception exception;
            EncodedStringValue aencodedstringvalue1[];
            int i2;
            int j2;
            if(k1 == 137) {
                EncodedStringValue encodedstringvalue2 = pduheaders.getEncodedStringValue(k1);
                if(encodedstringvalue2 != null) {
                    aencodedstringvalue = new EncodedStringValue[1];
                    aencodedstringvalue[0] = encodedstringvalue2;
                }
            } else {
                aencodedstringvalue = pduheaders.getEncodedStringValues(k1);
            }
            if(aencodedstringvalue == null)
                continue;
            updateAddress(ContentUris.parseId(uri), k1, aencodedstringvalue);
            if(k1 != 151)
                continue;
            aencodedstringvalue1 = aencodedstringvalue;
            i2 = aencodedstringvalue1.length;
            j2 = 0;
            do {
                if(j2 >= i2)
                    continue label0;
                EncodedStringValue encodedstringvalue1 = aencodedstringvalue1[j2];
                if(encodedstringvalue1 != null)
                    hashset.add(encodedstringvalue1.getString());
                j2++;
            } while(true);
        }

        break MISSING_BLOCK_LABEL_511;
        exception;
        throw exception;
        if(!hashset.isEmpty())
            contentvalues.put("thread_id", Long.valueOf(android.provider.Telephony.Threads.getOrCreateThreadId(mContext, hashset)));
        SqliteWrapper.update(mContext, mContentResolver, uri, contentvalues, null, null);
        return;
    }

    public void updateParts(Uri uri, PduBody pdubody) throws MmsException {
        PduCache pducache1 = PDU_CACHE_INSTANCE;
        pducache1;
        JVM INSTR monitorenter ;
        boolean flag = PDU_CACHE_INSTANCE.isUpdating(uri);
        if(!flag)
            break MISSING_BLOCK_LABEL_57;
        ArrayList arraylist;
        HashMap hashmap;
        int i;
        StringBuilder stringbuilder;
        int j;
        PduPart pdupart;
        Uri uri2;
        PduCacheEntry pducacheentry;
        try {
            PDU_CACHE_INSTANCE.wait();
        }
        catch(InterruptedException interruptedexception) {
            Log.e("PduPersister", "updateParts: ", interruptedexception);
        }
        pducacheentry = (PduCacheEntry)PDU_CACHE_INSTANCE.get(uri);
        if(pducacheentry != null)
            ((MultimediaMessagePdu)pducacheentry.getPdu()).setBody(pdubody);
        PDU_CACHE_INSTANCE.setUpdating(uri, true);
        pducache1;
        JVM INSTR monitorexit ;
        arraylist = new ArrayList();
        hashmap = new HashMap();
        i = pdubody.getPartsNum();
        stringbuilder = (new StringBuilder()).append('(');
        j = 0;
_L1:
        if(j >= i)
            break MISSING_BLOCK_LABEL_274;
        pdupart = pdubody.getPart(j);
        uri2 = pdupart.getDataUri();
        if(uri2 != null && uri2.getAuthority().startsWith("mms"))
            break MISSING_BLOCK_LABEL_216;
        arraylist.add(pdupart);
_L2:
        j++;
          goto _L1
        Exception exception2;
        exception2;
        throw exception2;
        Exception exception;
        exception;
        synchronized(PDU_CACHE_INSTANCE) {
            PDU_CACHE_INSTANCE.setUpdating(uri, false);
            PDU_CACHE_INSTANCE.notifyAll();
        }
        throw exception;
        hashmap.put(uri2, pdupart);
        if(stringbuilder.length() > 1)
            stringbuilder.append(" AND ");
        stringbuilder.append("_id");
        stringbuilder.append("!=");
        DatabaseUtils.appendEscapedSQLString(stringbuilder, uri2.getLastPathSegment());
          goto _L2
        long l;
        Context context;
        ContentResolver contentresolver;
        Uri uri1;
        String s;
        stringbuilder.append(')');
        l = ContentUris.parseId(uri);
        context = mContext;
        contentresolver = mContentResolver;
        uri1 = Uri.parse((new StringBuilder()).append(android.provider.Telephony.Mms.CONTENT_URI).append("/").append(l).append("/part").toString());
        if(stringbuilder.length() <= 2)
            break MISSING_BLOCK_LABEL_507;
        s = stringbuilder.toString();
_L3:
        SqliteWrapper.delete(context, contentresolver, uri1, s, null);
        for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); persistPart((PduPart)iterator.next(), l));
        java.util.Map.Entry entry;
        for(Iterator iterator1 = hashmap.entrySet().iterator(); iterator1.hasNext(); updatePart((Uri)entry.getKey(), (PduPart)entry.getValue()))
            entry = (java.util.Map.Entry)iterator1.next();

        synchronized(PDU_CACHE_INSTANCE) {
            PDU_CACHE_INSTANCE.setUpdating(uri, false);
            PDU_CACHE_INSTANCE.notifyAll();
        }
        return;
        exception1;
        pducache;
        JVM INSTR monitorexit ;
        throw exception1;
        exception3;
        pducache2;
        JVM INSTR monitorexit ;
        throw exception3;
        s = null;
          goto _L3
    }

    static final boolean $assertionsDisabled = false;
    private static final int ADDRESS_FIELDS[];
    private static final HashMap CHARSET_COLUMN_INDEX_MAP;
    private static final HashMap CHARSET_COLUMN_NAME_MAP;
    private static final boolean DEBUG = false;
    private static final long DUMMY_THREAD_ID = 0x7fffffffffffffffL;
    private static final HashMap ENCODED_STRING_COLUMN_INDEX_MAP;
    private static final HashMap ENCODED_STRING_COLUMN_NAME_MAP;
    private static final boolean LOCAL_LOGV = false;
    private static final HashMap LONG_COLUMN_INDEX_MAP;
    private static final HashMap LONG_COLUMN_NAME_MAP;
    private static final HashMap MESSAGE_BOX_MAP;
    private static final HashMap OCTET_COLUMN_INDEX_MAP;
    private static final HashMap OCTET_COLUMN_NAME_MAP;
    private static final int PART_COLUMN_CHARSET = 1;
    private static final int PART_COLUMN_CONTENT_DISPOSITION = 2;
    private static final int PART_COLUMN_CONTENT_ID = 3;
    private static final int PART_COLUMN_CONTENT_LOCATION = 4;
    private static final int PART_COLUMN_CONTENT_TYPE = 5;
    private static final int PART_COLUMN_FILENAME = 6;
    private static final int PART_COLUMN_ID = 0;
    private static final int PART_COLUMN_NAME = 7;
    private static final int PART_COLUMN_TEXT = 8;
    private static final String PART_PROJECTION[];
    private static final PduCache PDU_CACHE_INSTANCE = PduCache.getInstance();
    private static final int PDU_COLUMN_CONTENT_CLASS = 11;
    private static final int PDU_COLUMN_CONTENT_LOCATION = 5;
    private static final int PDU_COLUMN_CONTENT_TYPE = 6;
    private static final int PDU_COLUMN_DATE = 21;
    private static final int PDU_COLUMN_DELIVERY_REPORT = 12;
    private static final int PDU_COLUMN_DELIVERY_TIME = 22;
    private static final int PDU_COLUMN_EXPIRY = 23;
    private static final int PDU_COLUMN_ID = 0;
    private static final int PDU_COLUMN_MESSAGE_BOX = 1;
    private static final int PDU_COLUMN_MESSAGE_CLASS = 7;
    private static final int PDU_COLUMN_MESSAGE_ID = 8;
    private static final int PDU_COLUMN_MESSAGE_SIZE = 24;
    private static final int PDU_COLUMN_MESSAGE_TYPE = 13;
    private static final int PDU_COLUMN_MMS_VERSION = 14;
    private static final int PDU_COLUMN_PRIORITY = 15;
    private static final int PDU_COLUMN_READ_REPORT = 16;
    private static final int PDU_COLUMN_READ_STATUS = 17;
    private static final int PDU_COLUMN_REPORT_ALLOWED = 18;
    private static final int PDU_COLUMN_RESPONSE_TEXT = 9;
    private static final int PDU_COLUMN_RETRIEVE_STATUS = 19;
    private static final int PDU_COLUMN_RETRIEVE_TEXT = 3;
    private static final int PDU_COLUMN_RETRIEVE_TEXT_CHARSET = 26;
    private static final int PDU_COLUMN_STATUS = 20;
    private static final int PDU_COLUMN_SUBJECT = 4;
    private static final int PDU_COLUMN_SUBJECT_CHARSET = 25;
    private static final int PDU_COLUMN_THREAD_ID = 2;
    private static final int PDU_COLUMN_TRANSACTION_ID = 10;
    private static final String PDU_PROJECTION[];
    public static final int PROC_STATUS_COMPLETED = 3;
    public static final int PROC_STATUS_PERMANENTLY_FAILURE = 2;
    public static final int PROC_STATUS_TRANSIENT_FAILURE = 1;
    private static final String TAG = "PduPersister";
    public static final String TEMPORARY_DRM_OBJECT_URI = "content://mms/9223372036854775807/part";
    private static final HashMap TEXT_STRING_COLUMN_INDEX_MAP;
    private static final HashMap TEXT_STRING_COLUMN_NAME_MAP;
    private static PduPersister sPersister;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private final DrmManagerClient mDrmManagerClient;

    static  {
        boolean flag;
        int ai[];
        String as[];
        String as1[];
        if(!com/google/android/mms/pdu/PduPersister.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
        ai = new int[4];
        ai[0] = 129;
        ai[1] = 130;
        ai[2] = 137;
        ai[3] = 151;
        ADDRESS_FIELDS = ai;
        as = new String[27];
        as[0] = "_id";
        as[1] = "msg_box";
        as[2] = "thread_id";
        as[3] = "retr_txt";
        as[4] = "sub";
        as[5] = "ct_l";
        as[6] = "ct_t";
        as[7] = "m_cls";
        as[8] = "m_id";
        as[9] = "resp_txt";
        as[10] = "tr_id";
        as[11] = "ct_cls";
        as[12] = "d_rpt";
        as[13] = "m_type";
        as[14] = "v";
        as[15] = "pri";
        as[16] = "rr";
        as[17] = "read_status";
        as[18] = "rpt_a";
        as[19] = "retr_st";
        as[20] = "st";
        as[21] = "date";
        as[22] = "d_tm";
        as[23] = "exp";
        as[24] = "m_size";
        as[25] = "sub_cs";
        as[26] = "retr_txt_cs";
        PDU_PROJECTION = as;
        as1 = new String[9];
        as1[0] = "_id";
        as1[1] = "chset";
        as1[2] = "cd";
        as1[3] = "cid";
        as1[4] = "cl";
        as1[5] = "ct";
        as1[6] = "fn";
        as1[7] = "name";
        as1[8] = "text";
        PART_PROJECTION = as1;
        MESSAGE_BOX_MAP = new HashMap();
        MESSAGE_BOX_MAP.put(android.provider.Telephony.Mms.Inbox.CONTENT_URI, Integer.valueOf(1));
        MESSAGE_BOX_MAP.put(android.provider.Telephony.Mms.Sent.CONTENT_URI, Integer.valueOf(2));
        MESSAGE_BOX_MAP.put(android.provider.Telephony.Mms.Draft.CONTENT_URI, Integer.valueOf(3));
        MESSAGE_BOX_MAP.put(android.provider.Telephony.Mms.Outbox.CONTENT_URI, Integer.valueOf(4));
        CHARSET_COLUMN_INDEX_MAP = new HashMap();
        CHARSET_COLUMN_INDEX_MAP.put(Integer.valueOf(150), Integer.valueOf(25));
        CHARSET_COLUMN_INDEX_MAP.put(Integer.valueOf(154), Integer.valueOf(26));
        CHARSET_COLUMN_NAME_MAP = new HashMap();
        CHARSET_COLUMN_NAME_MAP.put(Integer.valueOf(150), "sub_cs");
        CHARSET_COLUMN_NAME_MAP.put(Integer.valueOf(154), "retr_txt_cs");
        ENCODED_STRING_COLUMN_INDEX_MAP = new HashMap();
        ENCODED_STRING_COLUMN_INDEX_MAP.put(Integer.valueOf(154), Integer.valueOf(3));
        ENCODED_STRING_COLUMN_INDEX_MAP.put(Integer.valueOf(150), Integer.valueOf(4));
        ENCODED_STRING_COLUMN_NAME_MAP = new HashMap();
        ENCODED_STRING_COLUMN_NAME_MAP.put(Integer.valueOf(154), "retr_txt");
        ENCODED_STRING_COLUMN_NAME_MAP.put(Integer.valueOf(150), "sub");
        TEXT_STRING_COLUMN_INDEX_MAP = new HashMap();
        TEXT_STRING_COLUMN_INDEX_MAP.put(Integer.valueOf(131), Integer.valueOf(5));
        TEXT_STRING_COLUMN_INDEX_MAP.put(Integer.valueOf(132), Integer.valueOf(6));
        TEXT_STRING_COLUMN_INDEX_MAP.put(Integer.valueOf(138), Integer.valueOf(7));
        TEXT_STRING_COLUMN_INDEX_MAP.put(Integer.valueOf(139), Integer.valueOf(8));
        TEXT_STRING_COLUMN_INDEX_MAP.put(Integer.valueOf(147), Integer.valueOf(9));
        TEXT_STRING_COLUMN_INDEX_MAP.put(Integer.valueOf(152), Integer.valueOf(10));
        TEXT_STRING_COLUMN_NAME_MAP = new HashMap();
        TEXT_STRING_COLUMN_NAME_MAP.put(Integer.valueOf(131), "ct_l");
        TEXT_STRING_COLUMN_NAME_MAP.put(Integer.valueOf(132), "ct_t");
        TEXT_STRING_COLUMN_NAME_MAP.put(Integer.valueOf(138), "m_cls");
        TEXT_STRING_COLUMN_NAME_MAP.put(Integer.valueOf(139), "m_id");
        TEXT_STRING_COLUMN_NAME_MAP.put(Integer.valueOf(147), "resp_txt");
        TEXT_STRING_COLUMN_NAME_MAP.put(Integer.valueOf(152), "tr_id");
        OCTET_COLUMN_INDEX_MAP = new HashMap();
        OCTET_COLUMN_INDEX_MAP.put(Integer.valueOf(186), Integer.valueOf(11));
        OCTET_COLUMN_INDEX_MAP.put(Integer.valueOf(134), Integer.valueOf(12));
        OCTET_COLUMN_INDEX_MAP.put(Integer.valueOf(140), Integer.valueOf(13));
        OCTET_COLUMN_INDEX_MAP.put(Integer.valueOf(141), Integer.valueOf(14));
        OCTET_COLUMN_INDEX_MAP.put(Integer.valueOf(143), Integer.valueOf(15));
        OCTET_COLUMN_INDEX_MAP.put(Integer.valueOf(144), Integer.valueOf(16));
        OCTET_COLUMN_INDEX_MAP.put(Integer.valueOf(155), Integer.valueOf(17));
        OCTET_COLUMN_INDEX_MAP.put(Integer.valueOf(145), Integer.valueOf(18));
        OCTET_COLUMN_INDEX_MAP.put(Integer.valueOf(153), Integer.valueOf(19));
        OCTET_COLUMN_INDEX_MAP.put(Integer.valueOf(149), Integer.valueOf(20));
        OCTET_COLUMN_NAME_MAP = new HashMap();
        OCTET_COLUMN_NAME_MAP.put(Integer.valueOf(186), "ct_cls");
        OCTET_COLUMN_NAME_MAP.put(Integer.valueOf(134), "d_rpt");
        OCTET_COLUMN_NAME_MAP.put(Integer.valueOf(140), "m_type");
        OCTET_COLUMN_NAME_MAP.put(Integer.valueOf(141), "v");
        OCTET_COLUMN_NAME_MAP.put(Integer.valueOf(143), "pri");
        OCTET_COLUMN_NAME_MAP.put(Integer.valueOf(144), "rr");
        OCTET_COLUMN_NAME_MAP.put(Integer.valueOf(155), "read_status");
        OCTET_COLUMN_NAME_MAP.put(Integer.valueOf(145), "rpt_a");
        OCTET_COLUMN_NAME_MAP.put(Integer.valueOf(153), "retr_st");
        OCTET_COLUMN_NAME_MAP.put(Integer.valueOf(149), "st");
        LONG_COLUMN_INDEX_MAP = new HashMap();
        LONG_COLUMN_INDEX_MAP.put(Integer.valueOf(133), Integer.valueOf(21));
        LONG_COLUMN_INDEX_MAP.put(Integer.valueOf(135), Integer.valueOf(22));
        LONG_COLUMN_INDEX_MAP.put(Integer.valueOf(136), Integer.valueOf(23));
        LONG_COLUMN_INDEX_MAP.put(Integer.valueOf(142), Integer.valueOf(24));
        LONG_COLUMN_NAME_MAP = new HashMap();
        LONG_COLUMN_NAME_MAP.put(Integer.valueOf(133), "date");
        LONG_COLUMN_NAME_MAP.put(Integer.valueOf(135), "d_tm");
        LONG_COLUMN_NAME_MAP.put(Integer.valueOf(136), "exp");
        LONG_COLUMN_NAME_MAP.put(Integer.valueOf(142), "m_size");
    }
}
