package com.datacrawler;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by soham on 21/7/16.
 */
public class PhoneContactsUtils {


    public class Contacts {
        String name = "";
        String phone = "";

        public Contacts(String name, String phoneNo) {
            this.name = name;
            this.phone = phoneNo;
        }
    }

    public List<Contacts> getContacts(Context context) {
        List<Contacts> contacts = new ArrayList<>();
        ContentResolver cr = context.getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);

        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));

                if (cur.getInt(cur.getColumnIndex(
                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (pCur.moveToNext()) {

                        String phoneNo = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));
                      /* Log.e("LOGGER", "Name: " + name
                               + ", Phone No: " + phoneNo);*/
                        if(!TextUtils.isEmpty(phoneNo))
                        contacts.add(new Contacts(name, phoneNo));
                    }
                    pCur.close();
                }
            }
        }
        Log.e("LOGGER","number of contacts found = "+contacts.size());
        return contacts;
    }
}
