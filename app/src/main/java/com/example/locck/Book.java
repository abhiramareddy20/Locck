package com.example.locck;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Book extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";
    ImageView imgageView;
    AlertDialog.Builder builder;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_book);

        imgageView =(ImageView)findViewById (R.id.lock1);
        Bundle bundle =getIntent ().getExtras ();
        if(bundle!=null)
        {
            int img = bundle.getInt ("image");
            imgageView.setImageResource (img);

        }



        b1 = (Button)findViewById (R.id.book);
        builder = new AlertDialog.Builder (this);
        b1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);


                builder.setPositiveButton("Pay 20% in advance", null);

                builder.setPositiveButton("Pay 20% in advance", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent (Book.this,Pay_Half.class);
                        startActivity (intent);
                    }
                });


                builder.setNegativeButton("Cancel", null);

                builder.setNegativeButton("Pay full service charges online", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent (Book.this,Pay_Full.class);
                        startActivity (intent);
                    }
                });



                AlertDialog alert = builder.create();
                alert.setTitle("Please choose payment option");
                alert.show();


            }
        });









    }



}
