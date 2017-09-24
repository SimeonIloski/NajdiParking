package com.example.simeon.najdiparking;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        StorageReference storageReference= FirebaseStorage.getInstance().getReference();
        ImageView imageView1=(ImageView) findViewById(R.id.imageView4);
        ImageView imageView2=(ImageView) findViewById(R.id.imageView5);
        ImageView imageView3=(ImageView) findViewById(R.id.imageView6);
        ImageView imageView4=(ImageView) findViewById(R.id.imageView7);
        ImageView imageView5=(ImageView) findViewById(R.id.imageView9);
        ImageView imageView6=(ImageView) findViewById(R.id.imageView8);
        ImageView imageView7=(ImageView) findViewById(R.id.imageView3);
        ImageView imageView8=(ImageView) findViewById(R.id.imageView2);


        Glide.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/najdiparking-542f3.appspot.com/o/imagelogo.jpg?alt=media&token=266ce98d-3432-4c5c-a732-1deb6044b1df").into(imageView1);
        Glide.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/najdiparking-542f3.appspot.com/o/image0.jpg?alt=media&token=16d23ac2-4d15-4ed0-8284-4df23c25ebc7").into(imageView2);
        Glide.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/najdiparking-542f3.appspot.com/o/image5.jpg?alt=media&token=16d23ac2-4d15-4ed0-8284-4df23c25ebc7").into(imageView3);
        Glide.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/najdiparking-542f3.appspot.com/o/image6.jpg?alt=media&token=16d23ac2-4d15-4ed0-8284-4df23c25ebc7").into(imageView4);
        Glide.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/najdiparking-542f3.appspot.com/o/image3.jpg?alt=media&token=16d23ac2-4d15-4ed0-8284-4df23c25ebc7").into(imageView5);
        Glide.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/najdiparking-542f3.appspot.com/o/image4.jpg?alt=media&token=16d23ac2-4d15-4ed0-8284-4df23c25ebc7").into(imageView6);
        Glide.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/najdiparking-542f3.appspot.com/o/image1.jpg?alt=media&token=16d23ac2-4d15-4ed0-8284-4df23c25ebc7").into(imageView7);
        Glide.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/najdiparking-542f3.appspot.com/o/image2.jpg?alt=media&token=16d23ac2-4d15-4ed0-8284-4df23c25ebc7").into(imageView8);

    }
}
