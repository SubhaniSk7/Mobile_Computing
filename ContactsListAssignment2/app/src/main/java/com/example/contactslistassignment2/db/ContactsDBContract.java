// Referred developers.android.com and online tutorials
//https://www.youtube.com/playlist?list=PLshdtb5UWjSrOJfpFOE-u55s3SnY2EO9v

package com.example.contactslistassignment2.db;

public class ContactsDBContract {

    private ContactsDBContract() {
    }

    public static class ContactEntry {
        public static final String DB_NAME = "contacts_db";
        public static final String TABLE_NAME = "contacts_info";
        public static final String CONTACT_ID = "contact_id";
        public static final String CONTACT_NAME = "contact_name";
        public static final String CONTACTS_VALUE = "contacts_value";
    }
}
