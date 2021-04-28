package com.example.macapp.ui.client;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.macapp.R;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewAdapter> {

    private List<ClientModel> list;
    private Context context;

    public ClientAdapter(List<ClientModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ClientViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_client_layout_recycler, parent , false);
        return new ClientViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewAdapter holder, int position) {
        ClientModel item = list.get(position);
        holder.clientName.setText(item.getName());
        holder.clientNumber.setText(item.getNumber());

        holder.clientUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("name", holder.clientName.getText().toString());
                bundle.putString("number", holder.clientNumber.getText().toString());

                UpdateClientFragment fragment = new UpdateClientFragment();
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.clientFragment, fragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ClientViewAdapter extends RecyclerView.ViewHolder{

        private TextView clientName , clientNumber;
        private Button clientUpdate;

        public ClientViewAdapter(@NonNull View itemView){
            super(itemView);
            clientName = itemView.findViewById(R.id.clientNameTV);
            clientNumber = itemView.findViewById(R.id.clientNumberTV);
            clientUpdate = itemView.findViewById(R.id.clientUpdate);

        }
    }
}
