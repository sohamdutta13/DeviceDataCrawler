package com.datacrawler;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.TrafficStats;
import android.util.Log;

import java.util.List;

/**
 * Created by soham on 26/7/16.
 */
public class NetworkStats {
    int UID = 0;

    public void getPakagesInfoUsingHashMap(Context context) {
        final PackageManager pm = context.getPackageManager();
        // get a list of installed apps.
        List<ApplicationInfo> packages = pm.getInstalledApplications(0);

        // loop through the list of installed packages and see if the selected
        // app is in the list
        for (ApplicationInfo packageInfo : packages) {
            // get the UID for the selected app
            UID = packageInfo.uid;
            String package_name = packageInfo.packageName;
            ApplicationInfo app = null;
            try {
                app = pm.getApplicationInfo(package_name, 0);
            } catch (PackageManager.NameNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String name = (String) pm.getApplicationLabel(app);
            Drawable icon = pm.getApplicationIcon(app);
            // internet usage for particular app(sent and received)
            double received = (double) TrafficStats.getUidRxBytes(UID)

                    / (1024 * 1024);
            double send = (double) TrafficStats.getUidTxBytes(UID)
                    / (1024 * 1024);
            double total = received + send;

            if (total > 0) {
               /* PackageInformationTotal pi = new PackageInformationTotal();
                pi.name = name;
                pi.packageName = package_name;
                pi.icon = icon;
                pi.totalMB = String.format("%.2f", total) + " MB";
                pi.individual_mb = String.format("%.2f", total);
                totalData += Double.parseDouble(String.format("%.2f", total));
                dataHash.add(pi);*/
                Log.e(name, String.format("%.2f", total) + " MB");
            }

        }
       /* Editor edit = shared.edit();
        edit.putString("Total", String.format("%.2f", totalData));
        edit.commit();*/
    }

    public void showNetworkData(Context context) {
        Log.e("Total", "Bytes received" + android.net.TrafficStats.getTotalRxBytes());
       /* ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = manager.getRunningAppProcesses();

        for (ActivityManager.RunningAppProcessInfo runningApp : runningApps) {

            // Get UID of the selected process
            int uid = ((ActivityManager.RunningAppProcessInfo)getListAdapter().getItem(position)).uid;

            // Get traffic data
            TrafficStats.getMobileRxBytes();
            long received = TrafficStats.getUidRxBytes(uid);
            long send   = TrafficStats.getUidTxBytes(uid);
            Log.v("" + uid, "Send :" + send + ", Received :" + received);
        }*/
    }
}
