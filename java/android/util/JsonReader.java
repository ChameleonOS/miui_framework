// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import libcore.internal.StringPool;

// Referenced classes of package android.util:
//            JsonScope, JsonToken, MalformedJsonException

public final class JsonReader
    implements Closeable {

    public JsonReader(Reader reader) {
        lenient = false;
        pos = 0;
        limit = 0;
        bufferStartLine = 1;
        bufferStartColumn = 1;
        push(JsonScope.EMPTY_DOCUMENT);
        skipping = false;
        if(reader == null) {
            throw new NullPointerException("in == null");
        } else {
            in = reader;
            return;
        }
    }

    private JsonToken advance() throws IOException {
        peek();
        JsonToken jsontoken = token;
        token = null;
        value = null;
        name = null;
        return jsontoken;
    }

    private void checkLenient() throws IOException {
        if(!lenient)
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        else
            return;
    }

    private JsonToken decodeLiteral() throws IOException {
        JsonToken jsontoken;
        if(valuePos == -1)
            jsontoken = JsonToken.STRING;
        else
        if(valueLength == 4 && ('n' == buffer[valuePos] || 'N' == buffer[valuePos]) && ('u' == buffer[1 + valuePos] || 'U' == buffer[1 + valuePos]) && ('l' == buffer[2 + valuePos] || 'L' == buffer[2 + valuePos]) && ('l' == buffer[3 + valuePos] || 'L' == buffer[3 + valuePos])) {
            value = "null";
            jsontoken = JsonToken.NULL;
        } else
        if(valueLength == 4 && ('t' == buffer[valuePos] || 'T' == buffer[valuePos]) && ('r' == buffer[1 + valuePos] || 'R' == buffer[1 + valuePos]) && ('u' == buffer[2 + valuePos] || 'U' == buffer[2 + valuePos]) && ('e' == buffer[3 + valuePos] || 'E' == buffer[3 + valuePos])) {
            value = "true";
            jsontoken = JsonToken.BOOLEAN;
        } else
        if(valueLength == 5 && ('f' == buffer[valuePos] || 'F' == buffer[valuePos]) && ('a' == buffer[1 + valuePos] || 'A' == buffer[1 + valuePos]) && ('l' == buffer[2 + valuePos] || 'L' == buffer[2 + valuePos]) && ('s' == buffer[3 + valuePos] || 'S' == buffer[3 + valuePos]) && ('e' == buffer[4 + valuePos] || 'E' == buffer[4 + valuePos])) {
            value = "false";
            jsontoken = JsonToken.BOOLEAN;
        } else {
            value = stringPool.get(buffer, valuePos, valueLength);
            jsontoken = decodeNumber(buffer, valuePos, valueLength);
        }
        return jsontoken;
    }

    private JsonToken decodeNumber(char ac[], int i, int j) {
        int k;
        char c;
        k = i;
        c = ac[k];
        if(c == '-') {
            k++;
            c = ac[k];
        }
        if(c != '0') goto _L2; else goto _L1
_L1:
        int l;
        char c1;
        l = k + 1;
        c1 = ac[l];
_L5:
        JsonToken jsontoken;
        if(c1 == '.') {
            l++;
            for(c1 = ac[l]; c1 >= '0' && c1 <= '9'; c1 = ac[l])
                l++;

        }
        if(c1 == 'e' || c1 == 'E') {
            int i1 = l + 1;
            char c2 = ac[i1];
            if(c2 == '+' || c2 == '-') {
                i1++;
                c2 = ac[i1];
            }
            if(c2 >= '0' && c2 <= '9') {
                l = i1 + 1;
                for(char c3 = ac[l]; c3 >= '0' && c3 <= '9'; c3 = ac[l])
                    l++;

            } else {
                jsontoken = JsonToken.STRING;
                continue; /* Loop/switch isn't completed */
            }
        }
        if(l == i + j)
            jsontoken = JsonToken.NUMBER;
        else
            jsontoken = JsonToken.STRING;
          goto _L3
_L2:
        if(c < '1' || c > '9')
            break; /* Loop/switch isn't completed */
        l = k + 1;
        c1 = ac[l];
        while(c1 >= '0' && c1 <= '9')  {
            l++;
            c1 = ac[l];
        }
        if(true) goto _L5; else goto _L4
_L4:
        jsontoken = JsonToken.STRING;
_L7:
        return jsontoken;
_L3:
        if(true) goto _L7; else goto _L6
_L6:
    }

    private void expect(JsonToken jsontoken) throws IOException {
        peek();
        if(token != jsontoken) {
            throw new IllegalStateException((new StringBuilder()).append("Expected ").append(jsontoken).append(" but was ").append(peek()).toString());
        } else {
            advance();
            return;
        }
    }

    private boolean fillBuffer(int i) throws IOException {
        boolean flag;
        flag = true;
        int j = 0;
        while(j < pos)  {
            if(buffer[j] == '\n') {
                bufferStartLine = 1 + bufferStartLine;
                bufferStartColumn = ((flag) ? 1 : 0);
            } else {
                bufferStartColumn = 1 + bufferStartColumn;
            }
            j++;
        }
        int k;
        if(limit != pos) {
            limit = limit - pos;
            System.arraycopy(buffer, pos, buffer, 0, limit);
        } else {
            limit = 0;
        }
        pos = 0;
        k = in.read(buffer, limit, buffer.length - limit);
        if(k == -1) goto _L2; else goto _L1
_L1:
        limit = k + limit;
        if(bufferStartLine == flag && bufferStartColumn == flag && limit > 0 && buffer[0] == '\uFEFF') {
            pos = 1 + pos;
            bufferStartColumn = -1 + bufferStartColumn;
        }
        if(limit < i)
            break MISSING_BLOCK_LABEL_106;
_L4:
        return flag;
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private int getColumnNumber() {
        int i = bufferStartColumn;
        int j = 0;
        while(j < pos)  {
            if(buffer[j] == '\n')
                i = 1;
            else
                i++;
            j++;
        }
        return i;
    }

    private int getLineNumber() {
        int i = bufferStartLine;
        for(int j = 0; j < pos; j++)
            if(buffer[j] == '\n')
                i++;

        return i;
    }

    private CharSequence getSnippet() {
        StringBuilder stringbuilder = new StringBuilder();
        int i = Math.min(pos, 20);
        stringbuilder.append(buffer, pos - i, i);
        int j = Math.min(limit - pos, 20);
        stringbuilder.append(buffer, pos, j);
        return stringbuilder;
    }

    private JsonToken nextInArray(boolean flag) throws IOException {
        if(!flag) goto _L2; else goto _L1
_L1:
        replaceTop(JsonScope.NONEMPTY_ARRAY);
_L7:
        nextNonWhitespace();
        JVM INSTR lookupswitch 3: default 48
    //                   44: 156
    //                   59: 156
    //                   93: 135;
           goto _L3 _L4 _L4 _L5
_L3:
        JsonToken jsontoken;
        pos = -1 + pos;
        jsontoken = nextValue();
_L10:
        return jsontoken;
_L2:
        nextNonWhitespace();
        JVM INSTR lookupswitch 3: default 104
    //                   44: 11
    //                   59: 128
    //                   93: 111;
           goto _L6 _L7 _L8 _L9
_L6:
        throw syntaxError("Unterminated array");
_L9:
        pop();
        jsontoken = JsonToken.END_ARRAY;
        token = jsontoken;
          goto _L10
_L8:
        checkLenient();
          goto _L7
_L5:
        if(!flag) goto _L4; else goto _L11
_L11:
        pop();
        jsontoken = JsonToken.END_ARRAY;
        token = jsontoken;
          goto _L10
_L4:
        checkLenient();
        pos = -1 + pos;
        value = "null";
        jsontoken = JsonToken.NULL;
        token = jsontoken;
          goto _L10
    }

    private JsonToken nextInObject(boolean flag) throws IOException {
        if(!flag) goto _L2; else goto _L1
_L1:
        nextNonWhitespace();
        JVM INSTR tableswitch 125 125: default 28
    //                   125 113;
           goto _L3 _L4
_L3:
        pos = -1 + pos;
          goto _L5
_L4:
        pop();
        jsontoken = JsonToken.END_OBJECT;
        token = jsontoken;
_L7:
        return jsontoken;
_L2:
        switch(nextNonWhitespace()) {
        default:
            throw syntaxError("Unterminated object");

        case 44: // ','
        case 59: // ';'
            break; /* Loop/switch isn't completed */

        case 125: // '}'
            pop();
            jsontoken = JsonToken.END_OBJECT;
            token = jsontoken;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        int i = nextNonWhitespace();
        JsonToken jsontoken;
        switch(i) {
        default:
            checkLenient();
            pos = -1 + pos;
            name = nextLiteral(false);
            if(name.isEmpty())
                throw syntaxError("Expected name");
            break;

        case 39: // '\''
            checkLenient();
            // fall through

        case 34: // '"'
            name = nextString((char)i);
            break;
        }
        replaceTop(JsonScope.DANGLING_NAME);
        jsontoken = JsonToken.NAME;
        token = jsontoken;
        if(true) goto _L7; else goto _L6
_L6:
        if(true) goto _L5; else goto _L8
_L8:
    }

    private String nextLiteral(boolean flag) throws IOException {
        StringBuilder stringbuilder;
        int i;
        stringbuilder = null;
        valuePos = -1;
        valueLength = 0;
        i = 0;
_L6:
        if(i + pos >= limit) goto _L2; else goto _L1
_L1:
        buffer[i + pos];
        JVM INSTR lookupswitch 16: default 176
    //                   9: 186
    //                   10: 186
    //                   12: 186
    //                   13: 186
    //                   32: 186
    //                   35: 182
    //                   44: 186
    //                   47: 182
    //                   58: 186
    //                   59: 182
    //                   61: 182
    //                   91: 186
    //                   92: 182
    //                   93: 186
    //                   123: 186
    //                   125: 186;
           goto _L3 _L4 _L4 _L4 _L4 _L4 _L5 _L4 _L5 _L4 _L5 _L5 _L4 _L5 _L4 _L4 _L4
_L3:
        i++;
        break; /* Loop/switch isn't completed */
_L5:
        checkLenient();
          goto _L4
        if(true) goto _L6; else goto _L2
_L4:
        String s;
        if(flag && stringbuilder == null) {
            valuePos = pos;
            s = null;
        } else
        if(skipping)
            s = "skipped!";
        else
        if(stringbuilder == null) {
            s = stringPool.get(buffer, pos, i);
        } else {
            stringbuilder.append(buffer, pos, i);
            s = stringbuilder.toString();
        }
        valueLength = i + valueLength;
        pos = i + pos;
        return s;
_L2:
label0:
        {
            if(i >= buffer.length)
                break label0;
            if(fillBuffer(i + 1))
                break; /* Loop/switch isn't completed */
            buffer[limit] = '\0';
        }
          goto _L4
        if(stringbuilder == null)
            stringbuilder = new StringBuilder();
        stringbuilder.append(buffer, pos, i);
        valueLength = i + valueLength;
        pos = i + pos;
        i = 0;
        if(fillBuffer(1)) goto _L6; else goto _L4
    }

    private int nextNonWhitespace() throws IOException {
_L10:
        if(pos >= limit && !fillBuffer(1)) goto _L2; else goto _L1
_L1:
        char c;
        char ac[] = buffer;
        int i = pos;
        pos = i + 1;
        c = ac[i];
        c;
        JVM INSTR lookupswitch 6: default 100
    //                   9: 0
    //                   10: 0
    //                   13: 0
    //                   32: 0
    //                   35: 219
    //                   47: 102;
           goto _L3 _L4 _L4 _L4 _L4 _L5 _L6
_L4:
        continue; /* Loop/switch isn't completed */
_L8:
        return c;
_L6:
        if(pos != limit || fillBuffer(1)) {
            checkLenient();
            switch(buffer[pos]) {
            case 42: // '*'
                pos = 1 + pos;
                if(!skipTo("*/"))
                    throw syntaxError("Unterminated comment");
                pos = 2 + pos;
                continue; /* Loop/switch isn't completed */

            case 47: // '/'
                pos = 1 + pos;
                skipToEndOfLine();
                continue; /* Loop/switch isn't completed */
            }
        }
_L3:
        if(true) goto _L8; else goto _L7
_L7:
_L5:
        checkLenient();
        skipToEndOfLine();
        continue; /* Loop/switch isn't completed */
_L2:
        throw new EOFException("End of input");
        if(true) goto _L10; else goto _L9
_L9:
    }

    private String nextString(char c) throws IOException {
        StringBuilder stringbuilder = null;
        do {
            int i = pos;
            do {
                if(pos >= limit)
                    break;
                char ac[] = buffer;
                int j = pos;
                pos = j + 1;
                char c1 = ac[j];
                if(c1 == c) {
                    String s;
                    if(skipping)
                        s = "skipped!";
                    else
                    if(stringbuilder == null) {
                        s = stringPool.get(buffer, i, -1 + (pos - i));
                    } else {
                        stringbuilder.append(buffer, i, -1 + (pos - i));
                        s = stringbuilder.toString();
                    }
                    return s;
                }
                if(c1 == '\\') {
                    if(stringbuilder == null)
                        stringbuilder = new StringBuilder();
                    stringbuilder.append(buffer, i, -1 + (pos - i));
                    stringbuilder.append(readEscapeCharacter());
                    i = pos;
                }
            } while(true);
            if(stringbuilder == null)
                stringbuilder = new StringBuilder();
            stringbuilder.append(buffer, i, pos - i);
        } while(fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private JsonToken nextValue() throws IOException {
        int i = nextNonWhitespace();
        i;
        JVM INSTR lookupswitch 4: default 48
    //                   34: 108
    //                   39: 104
    //                   91: 85
    //                   123: 66;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        JsonToken jsontoken;
        pos = -1 + pos;
        jsontoken = readLiteral();
_L7:
        return jsontoken;
_L5:
        push(JsonScope.EMPTY_OBJECT);
        jsontoken = JsonToken.BEGIN_OBJECT;
        token = jsontoken;
        continue; /* Loop/switch isn't completed */
_L4:
        push(JsonScope.EMPTY_ARRAY);
        jsontoken = JsonToken.BEGIN_ARRAY;
        token = jsontoken;
        continue; /* Loop/switch isn't completed */
_L3:
        checkLenient();
_L2:
        value = nextString((char)i);
        jsontoken = JsonToken.STRING;
        token = jsontoken;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private JsonToken objectValue() throws IOException {
        switch(nextNonWhitespace()) {
        case 59: // ';'
        case 60: // '<'
        default:
            throw syntaxError("Expected ':'");

        case 61: // '='
            checkLenient();
            if((pos < limit || fillBuffer(1)) && buffer[pos] == '>')
                pos = 1 + pos;
            // fall through

        case 58: // ':'
            replaceTop(JsonScope.NONEMPTY_OBJECT);
            return nextValue();
        }
    }

    private JsonScope peekStack() {
        return (JsonScope)stack.get(-1 + stack.size());
    }

    private JsonScope pop() {
        return (JsonScope)stack.remove(-1 + stack.size());
    }

    private void push(JsonScope jsonscope) {
        stack.add(jsonscope);
    }

    private char readEscapeCharacter() throws IOException {
        char c;
        if(pos == limit && !fillBuffer(1))
            throw syntaxError("Unterminated escape sequence");
        char ac[] = buffer;
        int i = pos;
        pos = i + 1;
        c = ac[i];
        c;
        JVM INSTR lookupswitch 6: default 108
    //                   98: 185
    //                   102: 203
    //                   110: 191
    //                   114: 197
    //                   116: 179
    //                   117: 110;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return c;
_L7:
        if(4 + pos > limit && !fillBuffer(4))
            throw syntaxError("Unterminated escape sequence");
        String s = stringPool.get(buffer, pos, 4);
        pos = 4 + pos;
        c = (char)Integer.parseInt(s, 16);
        continue; /* Loop/switch isn't completed */
_L6:
        c = '\t';
        continue; /* Loop/switch isn't completed */
_L2:
        c = '\b';
        continue; /* Loop/switch isn't completed */
_L4:
        c = '\n';
        continue; /* Loop/switch isn't completed */
_L5:
        c = '\r';
        continue; /* Loop/switch isn't completed */
_L3:
        c = '\f';
        if(true) goto _L1; else goto _L8
_L8:
    }

    private JsonToken readLiteral() throws IOException {
        value = nextLiteral(true);
        if(valueLength == 0)
            throw syntaxError("Expected literal value");
        token = decodeLiteral();
        if(token == JsonToken.STRING)
            checkLenient();
        return token;
    }

    private void replaceTop(JsonScope jsonscope) {
        stack.set(-1 + stack.size(), jsonscope);
    }

    private boolean skipTo(String s) throws IOException {
_L6:
        if(pos + s.length() > limit && !fillBuffer(s.length())) goto _L2; else goto _L1
_L1:
        boolean flag;
        int i = 0;
        do {
            if(i >= s.length())
                break;
            if(buffer[i + pos] != s.charAt(i)) {
                pos = 1 + pos;
                continue; /* Loop/switch isn't completed */
            }
            i++;
        } while(true);
        flag = true;
_L4:
        return flag;
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void skipToEndOfLine() throws IOException {
        char c;
        do {
            if(pos >= limit && !fillBuffer(1))
                break;
            char ac[] = buffer;
            int i = pos;
            pos = i + 1;
            c = ac[i];
        } while(c != '\r' && c != '\n');
    }

    private IOException syntaxError(String s) throws IOException {
        throw new MalformedJsonException((new StringBuilder()).append(s).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
    }

    public void beginArray() throws IOException {
        expect(JsonToken.BEGIN_ARRAY);
    }

    public void beginObject() throws IOException {
        expect(JsonToken.BEGIN_OBJECT);
    }

    public void close() throws IOException {
        value = null;
        token = null;
        stack.clear();
        stack.add(JsonScope.CLOSED);
        in.close();
    }

    public void endArray() throws IOException {
        expect(JsonToken.END_ARRAY);
    }

    public void endObject() throws IOException {
        expect(JsonToken.END_OBJECT);
    }

    public boolean hasNext() throws IOException {
        peek();
        boolean flag;
        if(token != JsonToken.END_OBJECT && token != JsonToken.END_ARRAY)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isLenient() {
        return lenient;
    }

    public boolean nextBoolean() throws IOException {
        peek();
        if(token != JsonToken.BOOLEAN)
            throw new IllegalStateException((new StringBuilder()).append("Expected a boolean but was ").append(token).toString());
        boolean flag;
        if(value == "true")
            flag = true;
        else
            flag = false;
        advance();
        return flag;
    }

    public double nextDouble() throws IOException {
        peek();
        if(token != JsonToken.STRING && token != JsonToken.NUMBER) {
            throw new IllegalStateException((new StringBuilder()).append("Expected a double but was ").append(token).toString());
        } else {
            double d = Double.parseDouble(value);
            advance();
            return d;
        }
    }

    public int nextInt() throws IOException {
        peek();
        if(token != JsonToken.STRING && token != JsonToken.NUMBER)
            throw new IllegalStateException((new StringBuilder()).append("Expected an int but was ").append(token).toString());
        int j = Integer.parseInt(value);
        int i = j;
_L2:
        advance();
        return i;
        NumberFormatException numberformatexception;
        numberformatexception;
        double d = Double.parseDouble(value);
        i = (int)d;
        if((double)i != d)
            throw new NumberFormatException(value);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public long nextLong() throws IOException {
        peek();
        if(token != JsonToken.STRING && token != JsonToken.NUMBER)
            throw new IllegalStateException((new StringBuilder()).append("Expected a long but was ").append(token).toString());
        long l1 = Long.parseLong(value);
        long l = l1;
_L2:
        advance();
        return l;
        NumberFormatException numberformatexception;
        numberformatexception;
        double d = Double.parseDouble(value);
        l = (long)d;
        if((double)l != d)
            throw new NumberFormatException(value);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String nextName() throws IOException {
        peek();
        if(token != JsonToken.NAME) {
            throw new IllegalStateException((new StringBuilder()).append("Expected a name but was ").append(peek()).toString());
        } else {
            String s = name;
            advance();
            return s;
        }
    }

    public void nextNull() throws IOException {
        peek();
        if(token != JsonToken.NULL) {
            throw new IllegalStateException((new StringBuilder()).append("Expected null but was ").append(token).toString());
        } else {
            advance();
            return;
        }
    }

    public String nextString() throws IOException {
        peek();
        if(token != JsonToken.STRING && token != JsonToken.NUMBER) {
            throw new IllegalStateException((new StringBuilder()).append("Expected a string but was ").append(peek()).toString());
        } else {
            String s = value;
            advance();
            return s;
        }
    }

    public JsonToken peek() throws IOException {
        if(token == null) goto _L2; else goto _L1
_L1:
        JsonToken jsontoken = token;
_L4:
        return jsontoken;
_L2:
        class _cls1 {

            static final int $SwitchMap$android$util$JsonScope[];

            static  {
                $SwitchMap$android$util$JsonScope = new int[JsonScope.values().length];
                NoSuchFieldError nosuchfielderror7;
                try {
                    $SwitchMap$android$util$JsonScope[JsonScope.EMPTY_DOCUMENT.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$android$util$JsonScope[JsonScope.EMPTY_ARRAY.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$android$util$JsonScope[JsonScope.NONEMPTY_ARRAY.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$android$util$JsonScope[JsonScope.EMPTY_OBJECT.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                try {
                    $SwitchMap$android$util$JsonScope[JsonScope.DANGLING_NAME.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                try {
                    $SwitchMap$android$util$JsonScope[JsonScope.NONEMPTY_OBJECT.ordinal()] = 6;
                }
                catch(NoSuchFieldError nosuchfielderror5) { }
                try {
                    $SwitchMap$android$util$JsonScope[JsonScope.NONEMPTY_DOCUMENT.ordinal()] = 7;
                }
                catch(NoSuchFieldError nosuchfielderror6) { }
                $SwitchMap$android$util$JsonScope[JsonScope.CLOSED.ordinal()] = 8;
_L2:
                return;
                nosuchfielderror7;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        switch(_cls1..SwitchMap.android.util.JsonScope[peekStack().ordinal()]) {
        default:
            throw new AssertionError();

        case 1: // '\001'
            replaceTop(JsonScope.NONEMPTY_DOCUMENT);
            jsontoken = nextValue();
            if(!lenient && token != JsonToken.BEGIN_ARRAY && token != JsonToken.BEGIN_OBJECT)
                throw new IOException((new StringBuilder()).append("Expected JSON document to start with '[' or '{' but was ").append(token).toString());
            break;

        case 2: // '\002'
            jsontoken = nextInArray(true);
            break;

        case 3: // '\003'
            jsontoken = nextInArray(false);
            break;

        case 4: // '\004'
            jsontoken = nextInObject(true);
            break;

        case 5: // '\005'
            jsontoken = objectValue();
            break;

        case 6: // '\006'
            jsontoken = nextInObject(false);
            break;

        case 7: // '\007'
            try {
                JsonToken jsontoken1 = nextValue();
                if(lenient)
                    jsontoken = jsontoken1;
                else
                    throw syntaxError("Expected EOF");
            }
            catch(EOFException eofexception) {
                jsontoken = JsonToken.END_DOCUMENT;
                token = jsontoken;
            }
            break;

        case 8: // '\b'
            throw new IllegalStateException("JsonReader is closed");
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setLenient(boolean flag) {
        lenient = flag;
    }

    public void skipValue() throws IOException {
        int i;
        skipping = true;
        i = 0;
_L7:
        JsonToken jsontoken = advance();
        if(jsontoken == JsonToken.BEGIN_ARRAY) goto _L2; else goto _L1
_L1:
        JsonToken jsontoken1 = JsonToken.BEGIN_OBJECT;
        if(jsontoken != jsontoken1) goto _L3; else goto _L2
_L2:
        i++;
_L5:
        if(i == 0) {
            skipping = false;
            return;
        }
        break; /* Loop/switch isn't completed */
_L3:
        JsonToken jsontoken2;
        if(jsontoken == JsonToken.END_ARRAY)
            break MISSING_BLOCK_LABEL_61;
        jsontoken2 = JsonToken.END_OBJECT;
        if(jsontoken != jsontoken2)
            continue; /* Loop/switch isn't completed */
        i--;
        if(true) goto _L5; else goto _L4
_L4:
        if(true) goto _L7; else goto _L6
_L6:
        Exception exception;
        exception;
        skipping = false;
        throw exception;
    }

    public String toString() {
        return (new StringBuilder()).append(getClass().getSimpleName()).append(" near ").append(getSnippet()).toString();
    }

    private static final String FALSE = "false";
    private static final String TRUE = "true";
    private final char buffer[] = new char[1024];
    private int bufferStartColumn;
    private int bufferStartLine;
    private final Reader in;
    private boolean lenient;
    private int limit;
    private String name;
    private int pos;
    private boolean skipping;
    private final List stack = new ArrayList();
    private final StringPool stringPool = new StringPool();
    private JsonToken token;
    private String value;
    private int valueLength;
    private int valuePos;
}
