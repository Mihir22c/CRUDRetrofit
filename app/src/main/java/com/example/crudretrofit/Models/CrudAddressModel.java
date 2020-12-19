package com.example.crudretrofit.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CrudAddressModel {

    @Expose
    @SerializedName("item")
    public List<Item> item;
    @Expose
    @SerializedName("info")
    public Info info;

    public static class Item {
        @Expose
        @SerializedName("response")
        public List<String> response;
        @Expose
        @SerializedName("request")
        public Request request;
        @Expose
        @SerializedName("protocolProfileBehavior")
        public ProtocolProfileBehavior protocolProfileBehavior;
        @Expose
        @SerializedName("name")
        public String name;
    }

    public static class Request {
        @Expose
        @SerializedName("url")
        public Url url;
        @Expose
        @SerializedName("body")
        public Body body;
        @Expose
        @SerializedName("header")
        public List<String> header;
        @Expose
        @SerializedName("method")
        public String method;
    }

    public static class Url {
        @Expose
        @SerializedName("host")
        public List<String> host;
        @Expose
        @SerializedName("raw")
        public String raw;
    }

    public static class Body {
    }

    public static class ProtocolProfileBehavior {
        @Expose
        @SerializedName("disableBodyPruning")
        public boolean disableBodyPruning;
    }

    public static class Info {
        @Expose
        @SerializedName("schema")
        public String schema;
        @Expose
        @SerializedName("name")
        public String name;
        @Expose
        @SerializedName("_postman_id")
        public String _postman_id;
    }
}
