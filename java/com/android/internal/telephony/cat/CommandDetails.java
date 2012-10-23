// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.android.internal.telephony.cat:
//            ValueObject, ComprehensionTlvTag

class CommandDetails extends ValueObject
    implements Parcelable {

    CommandDetails() {
    }

    public CommandDetails(Parcel parcel) {
        compRequired = true;
        commandNumber = parcel.readInt();
        typeOfCommand = parcel.readInt();
        commandQualifier = parcel.readInt();
    }

    public boolean compareTo(CommandDetails commanddetails) {
        boolean flag;
        if(compRequired == commanddetails.compRequired && commandNumber == commanddetails.commandNumber && commandQualifier == commanddetails.commandQualifier && typeOfCommand == commanddetails.typeOfCommand)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public int describeContents() {
        return 0;
    }

    public ComprehensionTlvTag getTag() {
        return ComprehensionTlvTag.COMMAND_DETAILS;
    }

    public String toString() {
        return (new StringBuilder()).append("CmdDetails: compRequired=").append(compRequired).append(" commandNumber=").append(commandNumber).append(" typeOfCommand=").append(typeOfCommand).append(" commandQualifier=").append(commandQualifier).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(commandNumber);
        parcel.writeInt(typeOfCommand);
        parcel.writeInt(commandQualifier);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CommandDetails createFromParcel(Parcel parcel) {
            return new CommandDetails(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public CommandDetails[] newArray(int i) {
            return new CommandDetails[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public int commandNumber;
    public int commandQualifier;
    public boolean compRequired;
    public int typeOfCommand;

}
