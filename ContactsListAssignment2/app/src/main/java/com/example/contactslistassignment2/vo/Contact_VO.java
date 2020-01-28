package com.example.contactslistassignment2.vo;

import android.net.Uri;

public class Contact_VO {

    private String contact_name;
    private String contact_number;
    public Uri profilePic;
//    private int pic;

    public Contact_VO() {
    }

    public Contact_VO(String contact_name, String contact_number) {
        this.contact_name = contact_name;
        this.contact_number = contact_number;
    }

    public Contact_VO(String contact_name, String contact_number, Uri profilePic) {
        this.contact_name = contact_name;
        this.contact_number = contact_number;
        this.profilePic = profilePic;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

//    public Uri getProfilePic() {
//        return profilePic;
//    }
//
//    public void setProfilePic(Uri profilePic) {
//        this.profilePic = profilePic;
//    }
}
