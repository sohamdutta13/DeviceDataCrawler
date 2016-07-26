package com.datacrawler;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.provider.Browser;
import android.widget.Toast;

/**
 * Created by soham on 21/7/16.
 */
public class BrowserData {
    private Context context;
    private Cursor cr;
    public StringBuilder sb;
    public BrowserData(Context c){
        this.context = c;
    }

    public void takeHistory(){
       /* if (android.os.Build.VERSION.SDK_INT< Build.VERSION_CODES.N) {
            cr = context.getContentResolver().query(Browser.BOOKMARKS_URI, Browser.HISTORY_PROJECTION, null, null, null);
            cr.moveToFirst();
            String title = "";
            String date = "";
            String visits = "";
            String url = "";
            String info = "";
            if (cr.moveToFirst() && cr.getCount() > 0) {
                while (cr.isAfterLast() == false) {
                    title = cr.getString(Browser.HISTORY_PROJECTION_TITLE_INDEX);
                    date = cr.getString(Browser.HISTORY_PROJECTION_DATE_INDEX);
                    url = cr.getString(Browser.HISTORY_PROJECTION_URL_INDEX);
                    visits = cr.getString(Browser.HISTORY_PROJECTION_VISITS_INDEX);
                    info = title + " date: " + date + " url: " + url + " visits" + visits + "\n";
                    Toast.makeText(context, info, Toast.LENGTH_LONG).show();
                    cr.moveToNext();
                }
            }

        }*/
    }
}
