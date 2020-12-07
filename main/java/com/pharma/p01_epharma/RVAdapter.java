package com.abubaker.p01_epharma;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVViewHolder> {
    List<MedicineModel> ls;
    public RVAdapter(List<MedicineModel> ls) {
        this.ls=ls;
    }
    
    @NonNull
    @Override
    public RVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);

        return new RVViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull RVViewHolder holder, int position) {
        holder.brandNAME.setText(ls.get(position).getBrandName());
        holder.genNAME.setText(ls.get(position).getGenName());
        holder.price.setText(String.valueOf(ls.get(position).getPrice()));
        //holder.quantity.setText(String.valueOf(ls.get(position).getQuantity()) );
        holder.availability.setText(String.valueOf(ls.get(position).getAvailability()));
        Picasso.get().load(ls.get(position).getImg()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return ls.size();
    }
    public void filterList(ArrayList<MedicineModel> filteredList)
    {
        ls=filteredList;
        notifyDataSetChanged();
    }

    public class RVViewHolder extends RecyclerView.ViewHolder {
        TextView brandNAME,genNAME,price, availability,quantity;
        ImageView img;
        public RVViewHolder(@NonNull View itemView) {
            super(itemView);
            brandNAME=itemView.findViewById(R.id.name);
            genNAME=itemView.findViewById(R.id.genname);
            price=itemView.findViewById(R.id.price);
            availability=itemView.findViewById(R.id.Availability);
            img=itemView.findViewById(R.id.imgrc);
           // quantity=itemView.findViewById(R.id.quantity);


        }
    }
}
