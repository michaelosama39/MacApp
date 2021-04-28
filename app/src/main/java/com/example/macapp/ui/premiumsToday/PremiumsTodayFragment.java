package com.example.macapp.ui.premiumsToday;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.macapp.R;
import com.example.macapp.ui.device.DeviceAdapter;
import com.example.macapp.ui.device.DeviceModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PremiumsTodayFragment extends Fragment {

    private RecyclerView deviceRV5, deviceRV10, deviceRV15, deviceRV20, deviceRV25, deviceRV30;
    private LinearLayout noDataLayout5, noDataLayout10 , noDataLayout15 , noDataLayout20 , noDataLayout25 , noDataLayout30;
    private DatabaseReference reference;
    private List<PremiumsTodayModel> list5, list10 , list15 , list20 , list25 , list30;
    private PremiumsTodayAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_premiums_today, container, false);
        deviceRV5 = view.findViewById(R.id.device_5_premiumsToday_RV);
        deviceRV10 = view.findViewById(R.id.device_10_premiumsToday_RV);
        deviceRV15 = view.findViewById(R.id.device_15_premiumsToday_RV);
        deviceRV20 = view.findViewById(R.id.device_20_premiumsToday_RV);
        deviceRV25 = view.findViewById(R.id.device_25_premiumsToday_RV);
        deviceRV30 = view.findViewById(R.id.device_30_premiumsToday_RV);

        noDataLayout5 = view.findViewById(R.id.noData_5_premiumsToday);
        noDataLayout10 = view.findViewById(R.id.noData_10_premiumsToday);
        noDataLayout15 = view.findViewById(R.id.noData_15_premiumsToday);
        noDataLayout20 = view.findViewById(R.id.noData_20_premiumsToday);
        noDataLayout25 = view.findViewById(R.id.noData_25_premiumsToday);
        noDataLayout30 = view.findViewById(R.id.noData_30_premiumsToday);
        reference = FirebaseDatabase.getInstance().getReference().child("device");

        getDeviceTodayProfile5();
        getDeviceTodayProfile10();
        getDeviceTodayProfile15();
        getDeviceTodayProfile20();
        getDeviceTodayProfile25();
        getDeviceTodayProfile30();


        return view;
    }

    private void getDeviceTodayProfile5(){
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
                        PremiumsTodayModel premiumsTodayModel = snapshot1.getValue(PremiumsTodayModel.class);
                        list5.add(premiumsTodayModel);
                    }
                    deviceRV5.setHasFixedSize(true);
                    deviceRV5.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new PremiumsTodayAdapter(list5, getActivity());
                    deviceRV5.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getDeviceTodayProfile10(){
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
                        PremiumsTodayModel premiumsTodayModel = snapshot1.getValue(PremiumsTodayModel.class);
                        list10.add(premiumsTodayModel);
                    }
                    deviceRV10.setHasFixedSize(true);
                    deviceRV10.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new PremiumsTodayAdapter(list10, getActivity());
                    deviceRV10.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getDeviceTodayProfile15(){
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
                        PremiumsTodayModel premiumsTodayModel = snapshot1.getValue(PremiumsTodayModel.class);
                        list15.add(premiumsTodayModel);
                    }
                    deviceRV15.setHasFixedSize(true);
                    deviceRV15.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new PremiumsTodayAdapter(list15, getActivity());
                    deviceRV15.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getDeviceTodayProfile20(){
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
                        PremiumsTodayModel premiumsTodayModel = snapshot1.getValue(PremiumsTodayModel.class);
                        list20.add(premiumsTodayModel);
                    }
                    deviceRV20.setHasFixedSize(true);
                    deviceRV20.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new PremiumsTodayAdapter(list20, getActivity());
                    deviceRV20.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getDeviceTodayProfile25(){
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
                        PremiumsTodayModel premiumsTodayModel = snapshot1.getValue(PremiumsTodayModel.class);
                        list25.add(premiumsTodayModel);
                    }
                    deviceRV25.setHasFixedSize(true);
                    deviceRV25.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new PremiumsTodayAdapter(list25, getActivity());
                    deviceRV25.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getDeviceTodayProfile30(){
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
                        PremiumsTodayModel premiumsTodayModel = snapshot1.getValue(PremiumsTodayModel.class);
                        list30.add(premiumsTodayModel);
                    }
                    deviceRV30.setHasFixedSize(true);
                    deviceRV30.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new PremiumsTodayAdapter(list30, getActivity());
                    deviceRV30.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}