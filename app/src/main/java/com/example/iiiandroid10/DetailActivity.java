package com.example.iiiandroid10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

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
    }

    private void fetchRemoteImage(){

    }

}
