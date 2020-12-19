package com.example.crudretrofit.Utils;

import com.example.crudretrofit.Clients.AddressClient;
import com.example.crudretrofit.Service.CrudAddressService;

public class AddressUtils {

    public AddressUtils() {
    }

    public static final String BASE_URL = "https://adsumoriginator.com/meatapp/api/";

    public static CrudAddressService getAddressService(){
        return AddressClient.getClient(BASE_URL).create(CrudAddressService.class);
    }

}
