package com.example.crudretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.crudretrofit.Models.AddressModel;
import com.example.crudretrofit.Service.CrudAddressService;
import com.example.crudretrofit.Utils.AddressUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnAddAddress;
    Button btnGetAddress;
    ListView listView;

    CrudAddressService addressService;
    List<AddressModel.Data> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Retrofit 2 CRUD Demo");

        btnAddAddress = (Button) findViewById(R.id.btnAddAddress);
        btnGetAddress = (Button) findViewById(R.id.btnGetAddressList);
        listView = (ListView) findViewById(R.id.listView);
        addressService = AddressUtils.getAddressService();

        btnAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CrudAddress.class);
                intent.putExtra("user_name","");
                startActivity(intent);
            }
        });

        btnGetAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get Address List
                getAddressList();
            }
        });


    }

    private void getAddressList() {
        Call<List<AddressModel.Data>> call = addressService.getAddress();
        call.enqueue(new Callback<List<AddressModel.Data>>() {
            @Override
            public void onResponse(Call<List<AddressModel.Data>> call, Response<List<AddressModel.Data>> response) {
                if (response.isSuccessful()){
                    list = response.body();
                    listView.setAdapter(new AddressAdapter(MainActivity.this,R.layout.listaddress,list));
                }
            }

            @Override
            public void onFailure(Call<List<AddressModel.Data>> call, Throwable t) {
                Log.e("ERROR:",t.getMessage());
            }
        });
    }
}