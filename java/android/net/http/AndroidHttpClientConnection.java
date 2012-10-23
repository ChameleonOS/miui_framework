// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import java.io.IOException;
import java.net.*;
import org.apache.http.*;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.HttpConnectionMetricsImpl;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.io.*;
import org.apache.http.io.*;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

// Referenced classes of package android.net.http:
//            Headers

public class AndroidHttpClientConnection
    implements HttpInetConnection, HttpConnection {

    public AndroidHttpClientConnection() {
        inbuffer = null;
        outbuffer = null;
        requestWriter = null;
        metrics = null;
        socket = null;
    }

    private void assertNotOpen() {
        if(open)
            throw new IllegalStateException("Connection is already open");
        else
            return;
    }

    private void assertOpen() {
        if(!open)
            throw new IllegalStateException("Connection is not open");
        else
            return;
    }

    private long determineLength(Headers headers) {
        long l = headers.getTransferEncoding();
        if(l >= 0L) {
            long l1 = headers.getContentLength();
            if(l1 > -1L)
                l = l1;
            else
                l = -1L;
        }
        return l;
    }

    public void bind(Socket socket1, HttpParams httpparams) throws IOException {
        if(socket1 == null)
            throw new IllegalArgumentException("Socket may not be null");
        if(httpparams == null)
            throw new IllegalArgumentException("HTTP parameters may not be null");
        assertNotOpen();
        socket1.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(httpparams));
        socket1.setSoTimeout(HttpConnectionParams.getSoTimeout(httpparams));
        int i = HttpConnectionParams.getLinger(httpparams);
        if(i >= 0) {
            int j;
            boolean flag;
            if(i > 0)
                flag = true;
            else
                flag = false;
            socket1.setSoLinger(flag, i);
        }
        socket = socket1;
        j = HttpConnectionParams.getSocketBufferSize(httpparams);
        inbuffer = new SocketInputBuffer(socket1, j, httpparams);
        outbuffer = new SocketOutputBuffer(socket1, j, httpparams);
        maxHeaderCount = httpparams.getIntParameter("http.connection.max-header-count", -1);
        maxLineLength = httpparams.getIntParameter("http.connection.max-line-length", -1);
        requestWriter = new HttpRequestWriter(outbuffer, null, httpparams);
        metrics = new HttpConnectionMetricsImpl(inbuffer.getMetrics(), outbuffer.getMetrics());
        open = true;
    }

    public void close() throws IOException {
        if(open) goto _L2; else goto _L1
_L1:
        return;
_L2:
        open = false;
        doFlush();
        UnsupportedOperationException unsupportedoperationexception;
        try {
            socket.shutdownOutput();
        }
        catch(IOException ioexception) { }
        try {
            socket.shutdownInput();
        }
        catch(IOException ioexception1) { }
        socket.close();
        if(true) goto _L1; else goto _L3
_L3:
        unsupportedoperationexception;
        break MISSING_BLOCK_LABEL_31;
    }

    protected void doFlush() throws IOException {
        outbuffer.flush();
    }

    public void flush() throws IOException {
        assertOpen();
        doFlush();
    }

    public InetAddress getLocalAddress() {
        InetAddress inetaddress;
        if(socket != null)
            inetaddress = socket.getLocalAddress();
        else
            inetaddress = null;
        return inetaddress;
    }

    public int getLocalPort() {
        int i;
        if(socket != null)
            i = socket.getLocalPort();
        else
            i = -1;
        return i;
    }

    public HttpConnectionMetrics getMetrics() {
        return metrics;
    }

    public InetAddress getRemoteAddress() {
        InetAddress inetaddress;
        if(socket != null)
            inetaddress = socket.getInetAddress();
        else
            inetaddress = null;
        return inetaddress;
    }

    public int getRemotePort() {
        int i;
        if(socket != null)
            i = socket.getPort();
        else
            i = -1;
        return i;
    }

    public int getSocketTimeout() {
        int i;
        i = -1;
        if(socket == null)
            break MISSING_BLOCK_LABEL_20;
        int j = socket.getSoTimeout();
        i = j;
_L2:
        return i;
        SocketException socketexception;
        socketexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isOpen() {
        boolean flag;
        if(open && socket != null && socket.isConnected())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isStale() {
        boolean flag;
        flag = true;
        assertOpen();
        inbuffer.isDataAvailable(1);
        flag = false;
_L2:
        return flag;
        IOException ioexception;
        ioexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public StatusLine parseResponseHeader(Headers headers) throws IOException, ParseException {
        CharArrayBuffer chararraybuffer;
        StatusLine statusline;
        int i;
        CharArrayBuffer chararraybuffer1;
        int j;
        assertOpen();
        chararraybuffer = new CharArrayBuffer(64);
        if(inbuffer.readLine(chararraybuffer) == -1)
            throw new NoHttpResponseException("The target server failed to respond");
        statusline = BasicLineParser.DEFAULT.parseStatusLine(chararraybuffer, new ParserCursor(0, chararraybuffer.length()));
        i = statusline.getStatusCode();
        chararraybuffer1 = null;
        j = 0;
_L2:
        if(chararraybuffer == null)
            chararraybuffer = new CharArrayBuffer(64);
        else
            chararraybuffer.clear();
        if(inbuffer.readLine(chararraybuffer) == -1 || chararraybuffer.length() < 1) {
            if(chararraybuffer1 != null)
                headers.parseHeader(chararraybuffer1);
            if(i >= 200)
                metrics.incrementResponseCount();
            return statusline;
        }
        char c = chararraybuffer.charAt(0);
        if(c != ' ' && c != '\t' || chararraybuffer1 == null)
            break; /* Loop/switch isn't completed */
        int k = 0;
        int l = chararraybuffer.length();
label0:
        do {
label1:
            {
                if(k < l) {
                    char c1 = chararraybuffer.charAt(k);
                    if(c1 == ' ' || c1 == '\t')
                        break label1;
                }
                if(maxLineLength > 0 && (1 + chararraybuffer1.length() + chararraybuffer.length()) - k > maxLineLength)
                    throw new IOException("Maximum line length limit exceeded");
                break label0;
            }
            k++;
        } while(true);
        chararraybuffer1.append(' ');
        chararraybuffer1.append(chararraybuffer, k, chararraybuffer.length() - k);
_L3:
        if(maxHeaderCount > 0 && j >= maxHeaderCount)
            throw new IOException("Maximum header count exceeded");
        if(true) goto _L2; else goto _L1
_L1:
        if(chararraybuffer1 != null)
            headers.parseHeader(chararraybuffer1);
        j++;
        chararraybuffer1 = chararraybuffer;
        chararraybuffer = null;
          goto _L3
        if(true) goto _L2; else goto _L4
_L4:
    }

    public HttpEntity receiveResponseEntity(Headers headers) {
        assertOpen();
        BasicHttpEntity basichttpentity = new BasicHttpEntity();
        long l = determineLength(headers);
        String s;
        String s1;
        if(l == -2L) {
            basichttpentity.setChunked(true);
            basichttpentity.setContentLength(-1L);
            basichttpentity.setContent(new ChunkedInputStream(inbuffer));
        } else
        if(l == -1L) {
            basichttpentity.setChunked(false);
            basichttpentity.setContentLength(-1L);
            basichttpentity.setContent(new IdentityInputStream(inbuffer));
        } else {
            basichttpentity.setChunked(false);
            basichttpentity.setContentLength(l);
            basichttpentity.setContent(new ContentLengthInputStream(inbuffer, l));
        }
        s = headers.getContentType();
        if(s != null)
            basichttpentity.setContentType(s);
        s1 = headers.getContentEncoding();
        if(s1 != null)
            basichttpentity.setContentEncoding(s1);
        return basichttpentity;
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpentityenclosingrequest) throws HttpException, IOException {
        if(httpentityenclosingrequest == null)
            throw new IllegalArgumentException("HTTP request may not be null");
        assertOpen();
        if(httpentityenclosingrequest.getEntity() != null)
            entityserializer.serialize(outbuffer, httpentityenclosingrequest, httpentityenclosingrequest.getEntity());
    }

    public void sendRequestHeader(HttpRequest httprequest) throws HttpException, IOException {
        if(httprequest == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else {
            assertOpen();
            requestWriter.write(httprequest);
            metrics.incrementRequestCount();
            return;
        }
    }

    public void setSocketTimeout(int i) {
        assertOpen();
        if(socket == null)
            break MISSING_BLOCK_LABEL_19;
        socket.setSoTimeout(i);
_L2:
        return;
        SocketException socketexception;
        socketexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void shutdown() throws IOException {
        open = false;
        Socket socket1 = socket;
        if(socket1 != null)
            socket1.close();
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getClass().getSimpleName()).append("[");
        if(isOpen())
            stringbuilder.append(getRemotePort());
        else
            stringbuilder.append("closed");
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    private final EntitySerializer entityserializer = new EntitySerializer(new StrictContentLengthStrategy());
    private SessionInputBuffer inbuffer;
    private int maxHeaderCount;
    private int maxLineLength;
    private HttpConnectionMetricsImpl metrics;
    private volatile boolean open;
    private SessionOutputBuffer outbuffer;
    private HttpMessageWriter requestWriter;
    private Socket socket;
}
