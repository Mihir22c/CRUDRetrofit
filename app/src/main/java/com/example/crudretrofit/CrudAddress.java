package com.example.crudretrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudretrofit.Models.AddressModel;
import com.example.crudretrofit.Service.CrudAddressService;
import com.example.crudretrofit.Utils.AddressUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class CrudAddress extends AppCompatActivity {

    CrudAddressService crudAddressService;
    EditText editId;
    EditText editUsername;
    EditText editAddress;
    EditText editMobile;
    Button btnSave;
    Button btnDelete;
    TextView textId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_address);

        setTitle("Address");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textId = (TextView) findViewById(R.id.tv_id);
        editId = (EditText) findViewById(R.id.ed_id);
        editUsername = (EditText) findViewById(R.id.ed_username);
        editAddress = (EditText) findViewById(R.id.ed_address);
        editMobile = (EditText) findViewById(R.id.ed_mobile_no);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDel);

        crudAddressService = AddressUtils.getAddressService();

        Bundle extras = getIntent().getExtras();
        final String Id = extras.getString("Id");
        String userName = extras.getString("user_name");
        String address = extras.getString("Address");

        editId.setText(Id);
        editUsername.setText(userName);
        editAddress.setText(address);

        if (Id != null && Id.trim().length() > 0 ){
            editId.setFocusable(true);
        }
        else {
            textId.setVisibility(View.INVISIBLE);
            editId.setVisibility(View.INVISIBLE);
            btnDelete.setVisibility(View.INVISIBLE);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddressModel.Data addressModel = new AddressModel.Data();
                addressModel.setUser_name(editUsername.getText().toString());
                addressModel.setUser_name(editAddress.getText().toString());
                if(Id != null && Id.trim().length() > 0) {
                    // update Address
                    updateAddress(Integer.parseInt(Id), addressModel);
                }
                else {
                    // add Address
                    addAddress(addressModel);
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAddress(Integer.parseInt(Id));
            }
        });
    }

    private void addAddress(AddressModel.Data addressModel) {
        Call<AddressModel.Data> call = crudAddressService.addAddress(addressModel);
        call.enqueue(new Callback<AddressModel.Data>() {
            @Override
            public void onResponse(Call<AddressModel.Data> call, Response<AddressModel.Data> response) {
                if (response.isSuccessful()){
                    Toast.makeText(CrudAddress.this, "Address Created Successfully", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AddressModel.Data> call, Throwable t) {
                Log.e("ERROR",t.getMessage());
            }
        });
    }

    private void deleteAddress(int user_id) {
        Call<AddressModel.Data> call = crudAddressService.deleteAddress(user_id);
        call.enqueue(new Callback<AddressModel.Data>() {
            @Override
            public void onResponse(Call<AddressModel.Data> call, Response<AddressModel.Data> response) {
                if (response.isSuccessful()){
                    Toast.makeText(CrudAddress.this, "Address deleted Successfully", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AddressModel.Data> call, Throwable t) {
                Log.e("ERROR",t.getMessage());
            }
        });
    }

    private void updateAddress(int user_id,AddressModel.Data addressModel) {
        Call<AddressModel.Data> call = crudAddressService.updateAddress(user_id,addressModel);
        call.enqueue(new Callback<AddressModel.Data>() {
            @Override
            public void onResponse(Call<AddressModel.Data> call, Response<AddressModel.Data> response) {
                if (response.isSuccessful()){
                    Toast.makeText(CrudAddress.this, "Address updates Successfully", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AddressModel.Data> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home :
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}