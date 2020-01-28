package com.example.sqliteexample;

public class ContactContract {

    private ContactContract() {
    }

    public static class ContactEntry {
        public static final String TABLE_NAME = "contact_info";
        public static final String CONTACT_ID = "contact_id";
        public static final String NAME = "name";
        public static final String EMAIL = "email";
        public static final String CONTACT_NO = "contact_no";
    }
}
