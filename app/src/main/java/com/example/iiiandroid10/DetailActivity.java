package com.example.iiiandroid10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {
    private String id,name, addr, tel, hostwords, feature, latlng, picurl, heart;
    private ImageView img;
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        HashMap<String,String> row =
                (HashMap<String,String>)(intent.getSerializableExtra("data"));
        id = row.get("ID");
        name = row.get("Name");
        addr = row.get("Address");
        tel = row.get("Tel");
        hostwords = row.get("HostWords");
        feature = row.get("FoodFeature");
        latlng = row.get("Coordinate");
        picurl = row.get("PicURL");

        img = findViewById(R.id.detail_img);
        content = findViewById(R.id.detail_content);

        fetchRemoteImage();
    }

    private void fetchRemoteImage(){
        ImageRequest request = new ImageRequest(picurl, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                img.setImageBitmap(response);
            }
        }, 0, 0, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MainApp.queue.add(request);
    }

    public void gotoMap(View view) {

        String[] temp = latlng.split(",");
        double lat = Double.valueOf(temp[0]);
        double lng = Double.valueOf(temp[1]);

        Log.v("brad", lat + " x " + lng);
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("lat",lat);
        intent.putExtra("lng", lng);
        startActivity(intent);
    }
}
