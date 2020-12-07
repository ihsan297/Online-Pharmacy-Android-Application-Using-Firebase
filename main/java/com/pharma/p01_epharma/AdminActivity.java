package com.abubaker.p01_epharma;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class AdminActivity extends AppCompatActivity {
    EditText name,genname,quantitiy,price,availab;
    Button save;
    SQLiteDatabase db;
    DatabaseReference myRef;
    FirebaseDatabase database;
    FirebaseAuth mFirebaseAuth;
    FirebaseUser fuser;
    ImageButton imageButton;
    String photoLink;
    StorageReference mStorageReference;
    FirebaseStorage mFirebaseStorage;
    public Uri imgUri;
    static final int IMAGE_PICK_CODE=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        name=findViewById(R.id.name);
        availab=findViewById(R.id.avail);
        genname=findViewById(R.id.gen);
        price=findViewById(R.id.pric);
        quantitiy=findViewById(R.id.quan);

        save=findViewById(R.id.save);

        database=FirebaseDatabase.getInstance();
        mFirebaseAuth=FirebaseAuth.getInstance();
        mFirebaseStorage=FirebaseStorage.getInstance();
        mStorageReference= mFirebaseStorage.getReference().child("Images");

        fuser= FirebaseAuth.getInstance().getCurrentUser();
        database = FirebaseDatabase.getInstance();
        addListener();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myRef = database.getReference("medicine").push();
                //  String flink=Fileuploader();

                MedicineModel model=new MedicineModel(
                        name.getText().toString(),
                        genname.getText().toString(),
                        price.getText().toString(),
                        quantitiy.getText().toString(),
                        availab.getText().toString(),
                        imgUri.toString()

                );

                myRef.setValue(model);
                Fileuploader();

                finish();
            }
        });
    }
    public void addListener()
    {
        imageButton=findViewById(R.id.imgbtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickimage();
            }
        });
    }

    void pickimage()
    {
        Intent intent =new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,IMAGE_PICK_CODE);
    }
    private void Fileuploader()
    {
        StorageReference Ref=mStorageReference.child(System.currentTimeMillis()+"."+getExtension(imgUri));

        Ref.putFile(imgUri)
                .addOnSuccessListener(this,new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        //photoLink = taskSnapshot.getUploadSessionUri();
                        photoLink=taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();
                        Toast.makeText(AdminActivity.this,photoLink,Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                    }
                });


    }
    private String getExtension(Uri uri)
    {
        ContentResolver cr=getContentResolver();
        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(imgUri));


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==IMAGE_PICK_CODE && resultCode==RESULT_OK)
        {
            imgUri =data.getData();
            imageButton.setImageURI(imgUri);
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(this.getContentResolver(),imgUri);
                imageButton.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
