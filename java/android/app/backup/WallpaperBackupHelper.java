// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.ParcelFileDescriptor;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;

// Referenced classes of package android.app.backup:
//            FileBackupHelperBase, BackupHelper, BackupDataInputStream, BackupDataOutput

public class WallpaperBackupHelper extends FileBackupHelperBase
    implements BackupHelper {

    public WallpaperBackupHelper(Context context, String as[], String as1[]) {
        super(context);
        mContext = context;
        mFiles = as;
        mKeys = as1;
        WallpaperManager wallpapermanager = (WallpaperManager)context.getSystemService("wallpaper");
        mDesiredMinWidth = wallpapermanager.getDesiredMinimumWidth();
        mDesiredMinHeight = wallpapermanager.getDesiredMinimumHeight();
        if(mDesiredMinWidth <= 0.0D || mDesiredMinHeight <= 0.0D) {
            Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            mDesiredMinWidth = point.x;
            mDesiredMinHeight = point.y;
        }
    }

    public void performBackup(ParcelFileDescriptor parcelfiledescriptor, BackupDataOutput backupdataoutput, ParcelFileDescriptor parcelfiledescriptor1) {
        performBackup_checked(parcelfiledescriptor, backupdataoutput, parcelfiledescriptor1, mFiles, mKeys);
    }

    public void restoreEntity(BackupDataInputStream backupdatainputstream) {
        String s = backupdatainputstream.getKey();
        if(!isKeyInList(s, mKeys)) goto _L2; else goto _L1
_L1:
        if(!s.equals("/data/data/com.android.settings/files/wallpaper")) goto _L4; else goto _L3
_L3:
        File file = new File("/data/system/users/0/wallpaper-tmp");
        if(writeFile(file, backupdatainputstream)) {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile("/data/system/users/0/wallpaper-tmp", options);
            double d = mDesiredMinWidth / (double)options.outWidth;
            double d1 = mDesiredMinHeight / (double)options.outHeight;
            if(d > 0.0D && d < 1.3300000000000001D && d1 > 0.0D && d1 < 1.3300000000000001D)
                file.renameTo(new File("/data/system/users/0/wallpaper"));
            else
                file.delete();
        }
_L2:
        return;
_L4:
        if(s.equals("/data/system/wallpaper_info.xml"))
            writeFile(new File("/data/system/users/0/wallpaper_info.xml"), backupdatainputstream);
        if(true) goto _L2; else goto _L5
_L5:
    }

    public volatile void writeNewStateDescription(ParcelFileDescriptor parcelfiledescriptor) {
        super.writeNewStateDescription(parcelfiledescriptor);
    }

    private static final boolean DEBUG = false;
    private static final String STAGE_FILE = "/data/system/users/0/wallpaper-tmp";
    private static final String TAG = "WallpaperBackupHelper";
    public static final String WALLPAPER_IMAGE = "/data/system/users/0/wallpaper";
    public static final String WALLPAPER_IMAGE_KEY = "/data/data/com.android.settings/files/wallpaper";
    public static final String WALLPAPER_INFO = "/data/system/users/0/wallpaper_info.xml";
    public static final String WALLPAPER_INFO_KEY = "/data/system/wallpaper_info.xml";
    Context mContext;
    double mDesiredMinHeight;
    double mDesiredMinWidth;
    String mFiles[];
    String mKeys[];
}
