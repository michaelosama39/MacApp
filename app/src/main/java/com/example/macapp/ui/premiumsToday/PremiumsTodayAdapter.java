package com.example.macapp.ui.premiumsToday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.macapp.R;
import com.example.macapp.ui.device.DeviceModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class PremiumsTodayAdapter extends RecyclerView.Adapter<PremiumsTodayAdapter.DeviceViewAdapter> {

    private List<PremiumsTodayModel> list;
    private Context context;

    public PremiumsTodayAdapter(List<PremiumsTodayModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DeviceViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_device_today_layout_recycler, parent , false);
        return new DeviceViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewAdapter holder, int position) {
        PremiumsTodayModel item = list.get(position);
        holder.namesOfClient.setText(item.getName());
        holder.premium.setText(item.getPremium());
        holder.copy.setText(item.getCopy());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DeviceViewAdapter extends RecyclerView.ViewHolder{

        private TextView namesOfClient , premium , copy ;

        public DeviceViewAdapter(@NonNull View itemView){
            super(itemView);
            namesOfClient = itemView.findViewById(R.id.deviceToday_nameTV);
            premium = itemView.findViewById(R.id.deviceToday_premiumTV);
            copy = itemView.findViewById(R.id.deviceToday_copyTV);
        }
    }
}
