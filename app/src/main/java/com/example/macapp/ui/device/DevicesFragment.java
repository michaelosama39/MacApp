package com.example.macapp.ui.device;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.macapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DevicesFragment extends Fragment implements View.OnClickListener {

    private FloatingActionButton fab;
    private RecyclerView deviceRV5, deviceRV10, deviceRV15, deviceRV20, deviceRV25, deviceRV30;
    private LinearLayout noDataLayout5, noDataLayout10 , noDataLayout15 , noDataLayout20 , noDataLayout25 , noDataLayout30;
    private DatabaseReference reference;
    private List<DeviceModel> list5, list10 , list15 , list20 , list25 , list30;
    private DeviceAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_devices, container, false);
        fab = view.findViewById(R.id.fab_device);
        deviceRV5 = view.findViewById(R.id.device_5_RV);
        deviceRV10 = view.findViewById(R.id.device_10_RV);
        deviceRV15 = view.findViewById(R.id.device_15_RV);
        deviceRV20 = view.findViewById(R.id.device_20_RV);
        deviceRV25 = view.findViewById(R.id.device_25_RV);
        deviceRV30 = view.findViewById(R.id.device_30_RV);

        noDataLayout5 = view.findViewById(R.id.noData_5);
        noDataLayout10 = view.findViewById(R.id.noData_10);
        noDataLayout15 = view.findViewById(R.id.noData_15);
        noDataLayout20 = view.findViewById(R.id.noData_20);
        noDataLayout25 = view.findViewById(R.id.noData_25);
        noDataLayout30 = view.findViewById(R.id.noData_30);
        reference = FirebaseDatabase.getInstance().getReference().child("device");

        fab.setOnClickListener(this);

        getDeviceProfile5();
        getDeviceProfile10();
        getDeviceProfile15();
        getDeviceProfile20();
        getDeviceProfile25();
        getDeviceProfile30();

        return view;
    }

    private void getDeviceProfile5(){
        reference.child("5").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list5 = new ArrayList<>();
                if (!snapshot.exists()){
                    noDataLayout5.setVisibility(View.VISIBLE);
                    deviceRV5.setVisibility(View.GONE);
                }else {
                    noDataLayout5.setVisibility(View.GONE);
                    deviceRV5.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        DeviceModel deviceModel = snapshot1.getValue(DeviceModel.class);
                        list5.add(deviceModel);
                    }
                    deviceRV5.setHasFixedSize(true);
                    deviceRV5.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new DeviceAdapter(list5, getActivity());
                    deviceRV5.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getDeviceProfile10(){
        reference.child("10").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list10 = new ArrayList<>();
                if (!snapshot.exists()){
                    noDataLayout10.setVisibility(View.VISIBLE);
                    deviceRV10.setVisibility(View.GONE);
                }else {
                    noDataLayout10.setVisibility(View.GONE);
                    deviceRV10.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        DeviceModel deviceModel = snapshot1.getValue(DeviceModel.class);
                        list10.add(deviceModel);
                    }
                    deviceRV10.setHasFixedSize(true);
                    deviceRV10.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new DeviceAdapter(list10, getActivity());
                    deviceRV10.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getDeviceProfile15(){
        reference.child("15").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list15 = new ArrayList<>();
                if (!snapshot.exists()){
                    noDataLayout15.setVisibility(View.VISIBLE);
                    deviceRV15.setVisibility(View.GONE);
                }else {
                    noDataLayout15.setVisibility(View.GONE);
                    deviceRV15.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        DeviceModel deviceModel = snapshot1.getValue(DeviceModel.class);
                        list15.add(deviceModel);
                    }
                    deviceRV15.setHasFixedSize(true);
                    deviceRV15.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new DeviceAdapter(list15, getActivity());
                    deviceRV15.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getDeviceProfile20(){
        reference.child("20").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list20 = new ArrayList<>();
                if (!snapshot.exists()){
                    noDataLayout20.setVisibility(View.VISIBLE);
                    deviceRV20.setVisibility(View.GONE);
                }else {
                    noDataLayout20.setVisibility(View.GONE);
                    deviceRV20.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        DeviceModel deviceModel = snapshot1.getValue(DeviceModel.class);
                        list20.add(deviceModel);
                    }
                    deviceRV20.setHasFixedSize(true);
                    deviceRV20.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new DeviceAdapter(list20, getActivity());
                    deviceRV20.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getDeviceProfile25(){
        reference.child("25").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list25 = new ArrayList<>();
                if (!snapshot.exists()){
                    noDataLayout25.setVisibility(View.VISIBLE);
                    deviceRV25.setVisibility(View.GONE);
                }else {
                    noDataLayout25.setVisibility(View.GONE);
                    deviceRV25.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        DeviceModel deviceModel = snapshot1.getValue(DeviceModel.class);
                        list25.add(deviceModel);
                    }
                    deviceRV25.setHasFixedSize(true);
                    deviceRV25.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new DeviceAdapter(list25, getActivity());
                    deviceRV25.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getDeviceProfile30(){
        reference.child("30").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list30 = new ArrayList<>();
                if (!snapshot.exists()){
                    noDataLayout30.setVisibility(View.VISIBLE);
                    deviceRV30.setVisibility(View.GONE);
                }else {
                    noDataLayout30.setVisibility(View.GONE);
                    deviceRV30.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        DeviceModel deviceModel = snapshot1.getValue(DeviceModel.class);
                        list30.add(deviceModel);
                    }
                    deviceRV30.setHasFixedSize(true);
                    deviceRV30.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new DeviceAdapter(list30, getActivity());
                    deviceRV30.setAdapter(adapter);
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
        if (v.getId() == R.id.fab_device){
            AddNewDeviceFragment fragment = new AddNewDeviceFragment();
            FragmentTransaction transactionsale = getFragmentManager().beginTransaction();
            transactionsale.replace(R.id.devicesFragment, fragment);
            transactionsale.commit();
        }
    }
}