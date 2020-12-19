package com.example.crudretrofit.Service;

import com.example.crudretrofit.Models.AddressModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CrudAddressService {
    @POST("getaddress")
    Call<List<AddressModel.Data>> getAddress();

    @POST("addaddress/")
    Call<AddressModel.Data> addAddress(@Body AddressModel.Data addressModel);

    @POST("updateaddress/")
    Call<AddressModel.Data> updateAddress(int user_id,@Body AddressModel.Data addressModel);

    @POST("deleteaddress/")
    Call<AddressModel.Data> deleteAddress(int user_id);
}
