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

class CartRVAdapter extends RecyclerView.Adapter<CartRVAdapter.RVViewHolder> {
    List<CartModel> ls;
    public CartRVAdapter(List<CartModel> ls) {
        this.ls=ls;
    }

    @NonNull
    @Override
    public RVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.cartrow,parent,false);

        return new RVViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull RVViewHolder holder, int position) {

        holder.medname.setText(ls.get(position).getCartMedName());
        holder.price.setText(ls.get(position).getCartPrice());
        holder.qty.setText(ls.get(position).getCartQty());

    }

    @Override
    public int getItemCount() {
        return ls.size();
    }


    public class RVViewHolder extends RecyclerView.ViewHolder {
        TextView medname,price,qty;

        public RVViewHolder(@NonNull View itemView) {
            super(itemView);
            medname=itemView.findViewById(R.id.CartItemMedName);
            price=itemView.findViewById(R.id.CartItemPrice);
            qty=itemView.findViewById(R.id.CaartItemQty);


        }
    }
}
