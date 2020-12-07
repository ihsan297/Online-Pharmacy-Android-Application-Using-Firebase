package com.abubaker.p01_epharma;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

class OrderRVAdapter extends RecyclerView.Adapter<OrderRVAdapter.RVViewHolder> {
    DatabaseReference myRef;
    FirebaseDatabase database;
    FirebaseAuth mFirebaseAuth;
    FirebaseUser fuser;
    ImageButton imageButton;
    String photoLink;
    StorageReference mStorageReference;
    FirebaseStorage mFirebaseStorage;

    List<OrderMedModel> ls;
    public OrderRVAdapter(List<OrderMedModel> ls) {
        this.ls=ls;
    }
    
    @NonNull
    @Override
    public RVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.showmedrow,parent,false);

        return new RVViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull final RVViewHolder holder, final int position) {
        holder.brandNAME.setText(ls.get(position).getBrandName());
        holder.genNAME.setText(ls.get(position).getGenName());

        holder.price.setText(String.valueOf(ls.get(position).getPrice()));
        holder.quantity.setText(String.valueOf(ls.get(position).getQuantity()) );
        holder.availability.setText(String.valueOf(ls.get(position).getAvailability()));
        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Item is added to Cart", Toast.LENGTH_SHORT).show();
                holder.addToCart.setBackgroundColor(12);
                database=FirebaseDatabase.getInstance();
                mFirebaseAuth=FirebaseAuth.getInstance();
                fuser= FirebaseAuth.getInstance().getCurrentUser();
                database = FirebaseDatabase.getInstance();
                myRef = database.getReference("cartMedic").push();
                //  String flink=Fileuploader();

                OrderMedModel model=new OrderMedModel(
                        ls.get(position).getBrandName(),
                        ls.get(position).getGenName(),
                        ls.get(position).getPrice(),
                        ls.get(position).getQuantity(),
                        ls.get(position).getAvailability()


                );
                myRef.setValue(model);

            }
        });

    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class RVViewHolder extends RecyclerView.ViewHolder {
        TextView brandNAME,genNAME,price, availability,quantity;
        Button addToCart,buyNow;
        public RVViewHolder(@NonNull View itemView) {
            super(itemView);
            brandNAME=itemView.findViewById(R.id.brandName);
            genNAME=itemView.findViewById(R.id.genName);
            price=itemView.findViewById(R.id.price);
            availability=itemView.findViewById(R.id.availbility);
            quantity=itemView.findViewById(R.id.quantity);
            addToCart=itemView.findViewById(R.id.addToCart);
            buyNow=itemView.findViewById(R.id.buyNow);


        }
    }

}
