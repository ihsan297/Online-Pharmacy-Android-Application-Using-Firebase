package com.abubaker.p01_epharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Home1 extends AppCompatActivity {
    ImageView med_supplements;
    ImageView med_cough;
    ImageView med_eye;
    ImageView med_equip;
    ImageView med_cosmetics;
    ImageView med_nutrition;
    ImageView cart;


    ViewFlipper viewFlipper;
    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        int []images={R.drawable.specialoffer,R.drawable.offer1,R.drawable.offer2,R.drawable.offer3,R.drawable.offer4,R.drawable.offer5};
        //Toast.makeText(getApplicationContext(),"Iam in",Toast.LENGTH_LONG).show();

        med_supplements=findViewById(R.id.med_supplements);
        med_cosmetics=findViewById(R.id.med_cosmetics);
        med_cough=findViewById(R.id.med_cough);
        med_eye=findViewById(R.id.med_eye);
        med_equip=findViewById(R.id.med_equip);
        med_nutrition=findViewById(R.id.med_nutritions);
        cart=findViewById(R.id.cart);
     //   userProfile=findViewById(R.id.userProfle);
        final Intent intent=new Intent(this,ShowMed.class);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),Cart.class);
                startActivity(intent1);
            }
        });

        med_nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                intent.putExtra("type","Nutrition Medicines");

                startActivity(intent);
            }
        });
        med_equip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("type","Equipments");

                startActivity(intent);
            }
        });
        med_eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("type","Eye Medicines");

                startActivity(intent);
            }
        });
        med_cough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("type","Cough Medicines" );

                startActivity(intent);
            }
        });
        med_cosmetics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("type","Cosmetic Medicines");

                startActivity(intent);
            }
        });
        med_supplements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("type","Supplements");

                startActivity(intent);
            }
        });




        viewFlipper=findViewById(R.id.v_flipper);
        search=findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home1.this,SearchMedicines.class);
                startActivity(intent);
            }
        });
        for (int i=0;i<images.length;i++)
        {
            flipperImages(images[i]);
        }

    }
    public void flipperImages(int image)
    {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
        Toast.makeText(Home1.this,"Iam in",Toast.LENGTH_LONG).show();


    }
}
