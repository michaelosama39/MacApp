package com.example.macapp.ui.client;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.macapp.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNewClientFragment extends Fragment {

    private EditText clientNameET, clientNumberET;
    private Button addNewClientBTN;
    private DatabaseReference reference;
    String name, number;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_new_client, container, false);
        clientNameET = view.findViewById(R.id.clientNameET);
        clientNumberET = view.findViewById(R.id.clientNumberET);
        addNewClientBTN = view.findViewById(R.id.addNewClientBTN);

        reference = FirebaseDatabase.getInstance().getReference().child("client");

        addNewClientBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidation();
            }
        });

        return view;
    }

    private void checkValidation() {
        name = clientNameET.getText().toString();
        number = clientNumberET.getText().toString();

        if (name.isEmpty()) {
            clientNameET.setError("Empty");
            clientNameET.requestFocus();
        } else if (number.isEmpty()) {
            clientNumberET.setError("Empty");
            clientNumberET.requestFocus();
        } else {
           saveData();
        }
    }

    private void saveData(){
        name = clientNameET.getText().toString();
        number = clientNumberET.getText().toString();
        ClientModel model = new ClientModel(name, number);
        reference.child(name).setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

            }
        });

        clientNameET.setText("");
        clientNumberET.setText("");
        clientNameET.clearFocus();
        clientNumberET.clearFocus();
        Toast.makeText(getContext(), "تم", Toast.LENGTH_SHORT).show();
    }
}
