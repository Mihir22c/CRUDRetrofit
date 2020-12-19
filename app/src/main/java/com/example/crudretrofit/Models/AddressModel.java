package com.example.crudretrofit.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class AddressModel {

    @Expose
    @SerializedName("data")
    private Data data;
    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("status")
    private boolean status;

    public static class Data {
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("addition_notice")
        private String addition_notice;
        @Expose
        @SerializedName("apt_no")
        private String apt_no;
        @Expose
        @SerializedName("building")
        private String building;
        @Expose
        @SerializedName("street_name")
        private String street_name;
        @Expose
        @SerializedName("block")
        private String block;
        @Expose
        @SerializedName("address_name")
        private String address_name;
        @Expose
        @SerializedName("mobile_no")
        private String mobile_no;
        @Expose
        @SerializedName("address_type")
        private String address_type;
        @Expose
        @SerializedName("user_name")
        private String user_name;
        @Expose
        @SerializedName("id")
        private int id;


        public Data(String created_at, String addition_notice, String apt_no, String building, String street_name, String block, String address_name, String mobile_no, String address_type, String user_name, int id) {
            this.created_at = created_at;
            this.addition_notice = addition_notice;
            this.apt_no = apt_no;
            this.building = building;
            this.street_name = street_name;
            this.block = block;
            this.address_name = address_name;
            this.mobile_no = mobile_no;
            this.address_type = address_type;
            this.user_name = user_name;
            this.id = id;
        }

        public Data() {

        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getAddition_notice() {
            return addition_notice;
        }

        public void setAddition_notice(String addition_notice) {
            this.addition_notice = addition_notice;
        }

        public String getApt_no() {
            return apt_no;
        }

        public void setApt_no(String apt_no) {
            this.apt_no = apt_no;
        }

        public String getBuilding() {
            return building;
        }

        public void setBuilding(String building) {
            this.building = building;
        }

        public String getStreet_name() {
            return street_name;
        }

        public void setStreet_name(String street_name) {
            this.street_name = street_name;
        }

        public String getBlock() {
            return block;
        }

        public void setBlock(String block) {
            this.block = block;
        }

        public String getAddress_name() {
            return address_name;
        }

        public void setAddress_name(String address_name) {
            this.address_name = address_name;
        }

        public String getMobile_no() {
            return mobile_no;
        }

        public void setMobile_no(String mobile_no) {
            this.mobile_no = mobile_no;
        }

        public String getAddress_type() {
            return address_type;
        }

        public void setAddress_type(String address_type) {
            this.address_type = address_type;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

}
