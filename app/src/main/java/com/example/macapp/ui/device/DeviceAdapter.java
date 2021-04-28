package com.example.macapp.ui.device;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.macapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.DeviceViewAdapter> {

    private List<DeviceModel> list;
    private Context context;
    private DatabaseReference reference;

    public DeviceAdapter(List<DeviceModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DeviceViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_device_layout_recycler, parent , false);
        return new DeviceViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewAdapter holder, int position) {
        DeviceModel item = list.get(position);
        holder.deviceHelperName.setText(item.getHelperName());
        holder.deviceNamesOfClient.setText(item.getName());
        holder.deviceHelperNumber.setText(item.getHelperNumber());
        holder.deviceTypeOfDevice.setText(item.getTypeOfDevice());
        holder.deviceDateOfBuy.setText(item.getDateOfBuy());
        holder.deviceMobilePrice.setText(item.getMobilePrice());
        holder.deviceFirstBatch.setText(item.getFirstBatch());
        holder.devicePremium.setText(item.getPremium());
        holder.deviceMonthOfLength.setText(item.getMonthOfLength());
        holder.devicePayOfDay.setText(item.getPayOfDay());

        holder.deviceDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference = FirebaseDatabase.getInstance().getReference().child("device");

                reference.child(holder.devicePayOfDay.getText().toString()).child(holder.deviceTypeOfDevice.getText().toString() +
                        "+" + holder.deviceNamesOfClient.getText().toString()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DeviceViewAdapter extends RecyclerView.ViewHolder{

        private TextView deviceHelperName , deviceNamesOfClient , deviceHelperNumber ,
        deviceTypeOfDevice , deviceDateOfBuy , deviceMobilePrice , deviceFirstBatch ,
        devicePremium , deviceMonthOfLength , devicePayOfDay;
        private Button deviceDelete;

        public DeviceViewAdapter(@NonNull View itemView){
            super(itemView);
            deviceHelperName = itemView.findViewById(R.id.deviceHelperNameTV);
            deviceNamesOfClient = itemView.findViewById(R.id.deviceNamesOfClientTV);
            deviceHelperNumber = itemView.findViewById(R.id.deviceHelperNumberTV);
            deviceTypeOfDevice = itemView.findViewById(R.id.deviceTypeOfDeviceTV);
            deviceDateOfBuy = itemView.findViewById(R.id.deviceDateOfBuyTV);
            deviceMobilePrice = itemView.findViewById(R.id.deviceMobilePriceTV);
            deviceFirstBatch = itemView.findViewById(R.id.deviceFirstBatchTV);
            devicePremium = itemView.findViewById(R.id.devicePremiumTV);
            deviceMonthOfLength = itemView.findViewById(R.id.deviceMonthOfLengthTV);
            devicePayOfDay = itemView.findViewById(R.id.devicePayOfDayTV);
            deviceDelete = itemView.findViewById(R.id.deviceDeleteBTN);
        }
    }
}
