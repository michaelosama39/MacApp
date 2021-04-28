package com.example.macapp.ui.client;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.macapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UpdateClientFragment extends Fragment implements View.OnClickListener {

    private EditText updateClientName, updateClientNumber;
    private Button updateClientBTN, deleteClientBTN;
    private String name, number;
    private DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_client, container, false);
        updateClientName = view.findViewById(R.id.updateClientName);
        updateClientNumber = view.findViewById(R.id.updateClientNumber);
        updateClientBTN = view.findViewById(R.id.updateClientBTN);
        deleteClientBTN = view.findViewById(R.id.deleteClientBTN);

        Bundle bundle = this.getArguments();
        name = bundle.getString("name");
        number = bundle.getString("number");

        updateClientName.setText(name);
        updateClientNumber.setText(number);

        updateClientBTN.setOnClickListener(this);
        deleteClientBTN.setOnClickListener(this);

        reference = FirebaseDatabase.getInstance().getReference().child("client");
        return view;
    }

    private void updateData(){
        HashMap hp = new HashMap();
        hp.put("name" , updateClientName.getText().toString());
        hp.put("number" , updateClientNumber.getText().toString());

        reference.child(name).updateChildren(hp).addOnSuccessListener(new  OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                Toast.makeText(getContext(), "Client Updated Successfully", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "SomeThing went wrong2", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteData(){
        reference.child(name).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getContext(), "Teacher Deleted Successfully", Toast.LENGTH_SHORT).show();
                        ClientFragment fragment = new ClientFragment();
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.clientFragment, fragment).addToBackStack(null).commit();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "SomeThing went wrong2", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.updateClientBTN) {
            updateData();
        }else if (v.getId() == R.id.deleteClientBTN){
            deleteData();
        }
    }
}