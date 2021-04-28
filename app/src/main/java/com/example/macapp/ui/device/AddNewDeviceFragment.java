package com.example.macapp.ui.device;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.macapp.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class AddNewDeviceFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private EditText helperNameET, helperNumberET, typeOfDeviceET, dateOfBuyET, mobilePriceET, firstBatchET, premiumET, monthOfLengthET;
    private Spinner namesOfClientSPN, payOfDaySPN, copySPN;
    private Button saveBTN;
    private DatabaseReference databaseNamesOfClientSpinner, reference;
    private ArrayList<String> listNamesOfClient, listPayOfDay , listCopy;
    private ArrayAdapter<String> arrayAdapterNamesOfClient, arrayAdapterPayOfDay , arrayAdapterCopy;
    private String namesOfClient, typeOfDevice, payOfDay, helperName, helperNumber, date, mobilePrice, firstBatch, premium, monthOfLength , copy;
    private DatePickerDialog.OnDateSetListener setListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_new_device, container, false);

        namesOfClientSPN = view.findViewById(R.id.namesOfClientSPN);
        payOfDaySPN = view.findViewById(R.id.payOfDaySPN);
        copySPN = view.findViewById(R.id.copySPN);
        helperNameET = view.findViewById(R.id.helperNameET);
        helperNumberET = view.findViewById(R.id.helperNumberET);
        typeOfDeviceET = view.findViewById(R.id.typeOfDeviceET);
        dateOfBuyET = view.findViewById(R.id.dateOfBuyET);
        mobilePriceET = view.findViewById(R.id.mobilePriceET);
        firstBatchET = view.findViewById(R.id.firstBatchET);
        premiumET = view.findViewById(R.id.premiumET);
        monthOfLengthET = view.findViewById(R.id.monthOfLengthET);
        saveBTN = view.findViewById(R.id.saveBTN);
        reference = FirebaseDatabase.getInstance().getReference().child("device");

        // Show Data Spinner NamesOfClient
        databaseNamesOfClientSpinner = FirebaseDatabase.getInstance().getReference();
        listNamesOfClient = new ArrayList<>();
        showDataSpinnerNamesOfClient();

        // Show Data Spinner
        showDataSpinnerPayOfDay();
        showDataSpinnerCopy();

        // get data from Spinner
        namesOfClientSPN.setOnItemSelectedListener(this);
        payOfDaySPN.setOnItemSelectedListener(this);
        copySPN.setOnItemSelectedListener(this);

        // Save Data
        saveBTN.setOnClickListener(this);

        return view;
    }

    private void showDataSpinnerCopy() {
        listCopy = new ArrayList<>();
        listCopy.add("قديم");
        listCopy.add("جديد");
        arrayAdapterCopy = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, listCopy);
        copySPN.setAdapter(arrayAdapterCopy);
    }

    private void showDataSpinnerPayOfDay() {
        listPayOfDay = new ArrayList<>();
        listPayOfDay.add("5");
        listPayOfDay.add("10");
        listPayOfDay.add("15");
        listPayOfDay.add("20");
        listPayOfDay.add("25");
        listPayOfDay.add("30");
        arrayAdapterPayOfDay = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, listPayOfDay);
        payOfDaySPN.setAdapter(arrayAdapterPayOfDay);
    }

    private void showDataSpinnerNamesOfClient() {
        databaseNamesOfClientSpinner.child("client").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listNamesOfClient.clear();
                for (DataSnapshot item : snapshot.getChildren()) {
                    listNamesOfClient.add(item.child("name").getValue(String.class));
                }
                arrayAdapterNamesOfClient = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, listNamesOfClient);
                namesOfClientSPN.setAdapter(arrayAdapterNamesOfClient);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == namesOfClientSPN.getId()) {
            namesOfClient = parent.getItemAtPosition(position).toString();
        } else if (parent.getId() == payOfDaySPN.getId()) {
            payOfDay = parent.getItemAtPosition(position).toString();
        } else if (parent.getId() == copySPN.getId()) {
             copy = parent.getItemAtPosition(position).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void saveDataintoFirebase() {
        helperName = helperNameET.getText().toString();
        helperNumber = helperNumberET.getText().toString();
        typeOfDevice = typeOfDeviceET.getText().toString();
        mobilePrice = mobilePriceET.getText().toString();
        firstBatch = firstBatchET.getText().toString();
        premium = premiumET.getText().toString();
        monthOfLength = monthOfLengthET.getText().toString();
        DeviceModel deviceModel = new DeviceModel(namesOfClient, helperName, helperNumber,
                typeOfDevice, copy , date, mobilePrice, firstBatch, premium, monthOfLength, payOfDay);
        reference.child(payOfDay).child(typeOfDevice + "+" + namesOfClient).setValue(deviceModel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

            }
        });

        helperNameET.setText("");
        helperNumberET.setText("");
        typeOfDeviceET.setText("");
        mobilePriceET.setText("");
        firstBatchET.setText("");
        premiumET.setText("");
        monthOfLengthET.setText("");
        dateOfBuyET.setText("");

        helperNameET.clearFocus();
        helperNumberET.clearFocus();
        typeOfDeviceET.clearFocus();
        mobilePriceET.clearFocus();
        firstBatchET.clearFocus();
        premiumET.clearFocus();
        monthOfLengthET.clearFocus();
        dateOfBuyET.clearFocus();
        Toast.makeText(getContext(), "تم", Toast.LENGTH_SHORT).show();
    }

    private void checkValidation() {
        helperName = helperNameET.getText().toString();
        helperNumber = helperNumberET.getText().toString();
        typeOfDevice = typeOfDeviceET.getText().toString();
        mobilePrice = mobilePriceET.getText().toString();
        firstBatch = firstBatchET.getText().toString();
        premium = premiumET.getText().toString();
        monthOfLength = premiumET.getText().toString();
        date = dateOfBuyET.getText().toString();

        if (helperName.isEmpty()) {
            helperNameET.setError("Empty");
            helperNameET.requestFocus();
        } else if (helperNumber.isEmpty()) {
            helperNumberET.setError("Empty");
            helperNumberET.requestFocus();
        }else if (typeOfDevice.isEmpty()) {
            typeOfDeviceET.setError("Empty");
            typeOfDeviceET.requestFocus();
        }else if (mobilePrice.isEmpty()) {
            mobilePriceET.setError("Empty");
            mobilePriceET.requestFocus();
        }else if (firstBatch.isEmpty()) {
            firstBatchET.setError("Empty");
            firstBatchET.requestFocus();
        }else if (premium.isEmpty()) {
            premiumET.setError("Empty");
            premiumET.requestFocus();
        }else if (firstBatch.isEmpty()) {
            firstBatchET.setError("Empty");
            firstBatchET.requestFocus();
        }else if (date.isEmpty()) {
            dateOfBuyET.setError("Empty");
            dateOfBuyET.requestFocus();
        } else {
            saveDataintoFirebase();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.saveBTN) {
            checkValidation();
        }
    }
}