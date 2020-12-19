package com.example.crudretrofit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.example.crudretrofit.Models.AddressModel;

import java.util.List;

public class AddressAdapter extends ArrayAdapter<AddressModel.Data> {

    private Context context;
    private List<AddressModel.Data> addressModels;

    public AddressAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<AddressModel.Data> objects){
        super(context,resource,objects);
        this.context = context;
        this.addressModels = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listaddress,parent,false);

        TextView txtId = (TextView) rowView.findViewById(R.id.txtId);
        TextView txtUsername = (TextView) rowView.findViewById(R.id.txtUsername);

        txtId.setText(String.format("#ID: %d",addressModels.get(position).getId()));
        txtUsername.setText(String.format("USER NAME: %s",addressModels.get(position).getUser_name()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity Address Form
                Intent intent = new Intent(context,CrudAddress.class);
                intent.putExtra("id",String.valueOf(addressModels.get(position).getId()));
                intent.putExtra("user_name",addressModels.get(position).getUser_name());
                context.startActivity(intent);
            }
        });
    return rowView;
    }
}
