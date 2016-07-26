package com.datacrawler;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by soham on 20/7/16.
 */
public class AppsUtils {
Context context;
    public class AppInfo {
        private String appname = "";
        private String pname = "";
        private String versionName = "";
        private int versionCode = 0;
        private Drawable icon;
        private void prettyPrint() {
            Log.e("LOGGER",appname + "\t" + pname + "\t" + versionName + "\t" + versionCode);
        }
    }

    public ArrayList<AppInfo> getPackages(Context context) {
        this.context=context;
        ArrayList<AppInfo> apps = getInstalledApps(false); /* false = no system packages */
        final int max = apps.size();
        for (int i=0; i<max; i++) {
            apps.get(i).prettyPrint();
        }
        return apps;
    }

    private ArrayList<AppInfo> getInstalledApps(boolean getSysPackages) {
        ArrayList<AppInfo> res = new ArrayList<AppInfo>();
        List<PackageInfo> packs = context.getPackageManager().getInstalledPackages(0);
        for(int i=0;i<packs.size();i++) {
            PackageInfo p = packs.get(i);
            if ((!getSysPackages) && (p.versionName == null)) {
                continue ;
            }
            AppInfo newInfo = new AppInfo();
            newInfo.appname = p.applicationInfo.loadLabel(context.getPackageManager()).toString();
            newInfo.pname = p.packageName;
            newInfo.versionName = p.versionName;
            newInfo.versionCode = p.versionCode;
            newInfo.icon = p.applicationInfo.loadIcon(context.getPackageManager());
            res.add(newInfo);
        }
        return res;
    }
}
