package com.example.macapp.ui.client;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.macapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ClientFragment extends Fragment implements View.OnClickListener {

    private FloatingActionButton fab;
    private RecyclerView clientRV;
    private LinearLayout noDataLayout;
    private DatabaseReference reference;
    private List<ClientModel> list1;
    private ClientAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_client, container, false);
        fab = view.findViewById(R.id.fab_client);
        clientRV = view.findViewById(R.id.clientRV);
        noDataLayout = view.findViewById(R.id.noData_5);
        reference = FirebaseDatabase.getInstance().getReference().child("client");

        fab.setOnClickListener(this);

        getClientProfile();

        return view;
    }

    private void getClientProfile(){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()){
                    noDataLayout.setVisibility(View.VISIBLE);
                    clientRV.setVisibility(View.GONE);
                }else {
                    noDataLayout.setVisibility(View.GONE);
                    clientRV.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        ClientModel clientModel = snapshot1.getValue(ClientModel.class);
                        list1.add(clientModel);
                    }
                    clientRV.setHasFixedSize(true);
                    clientRV.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new ClientAdapter(list1 , getActivity());
                    clientRV.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fab_client){
            AddNewClientFragment fragment = new AddNewClientFragment();
            FragmentTransaction transactionsale = getFragmentManager().beginTransaction();
            transactionsale.replace(R.id.clientFragment, fragment );
            transactionsale.commit();
        }
    }
}