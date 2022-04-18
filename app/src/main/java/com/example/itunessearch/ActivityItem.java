package com.example.itunessearch;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class ActivityItem extends AppCompatActivity {

    private TextView itemHead,itemDesc;
    private ImageView itemImg;

    private static final String TAG= "ActivityItem";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        itemHead=(TextView) findViewById(R.id.header_title);
        itemDesc=(TextView) findViewById(R.id.lngDec);
        itemImg=(ImageView) findViewById(R.id.imageHeader);

        new DownloadImageFromInternet(itemImg).execute(getIntent().getStringExtra("imageURL"));
        itemHead.setText(getIntent().getStringExtra("itemHead"));
        itemDesc.setText(getIntent().getStringExtra("longDesc"));

    }

    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;
        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView=imageView;

        }
        protected Bitmap doInBackground(String... urls) {
            String imageURL=urls[0];
            Bitmap bimage=null;
            try {
                InputStream in=new java.net.URL(imageURL).openStream();
                bimage= BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }
}
