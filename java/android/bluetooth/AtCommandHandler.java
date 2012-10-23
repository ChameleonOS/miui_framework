// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;


// Referenced classes of package android.bluetooth:
//            AtCommandResult

public abstract class AtCommandHandler {

    public AtCommandHandler() {
    }

    public AtCommandResult handleActionCommand() {
        return new AtCommandResult(1);
    }

    public AtCommandResult handleBasicCommand(String s) {
        return new AtCommandResult(1);
    }

    public AtCommandResult handleReadCommand() {
        return new AtCommandResult(1);
    }

    public AtCommandResult handleSetCommand(Object aobj[]) {
        return new AtCommandResult(1);
    }

    public AtCommandResult handleTestCommand() {
        return new AtCommandResult(0);
    }
}
