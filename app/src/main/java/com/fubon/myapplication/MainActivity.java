package com.fubon.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.iflytek.cloud.FaceRequest;
import com.iflytek.cloud.RequestListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUtility;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerview, title;
    MyAdapter myAdapter, myAdapter1;
    List<DataDetail> dataDetails;
    private static final int REQUEST_CODE_CAMERA = 100;
    Button button;
    ImageView imv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=5acee161");
        button = findViewById(R.id.btn);
        recyclerview = findViewById(R.id.recycleview);
        title = findViewById(R.id.title);
        dataDetails = new ArrayList<>();
        imv = findViewById(R.id.imv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String sss = Environment.getExternalStorageState();
//                if (sss.equals(Environment.MEDIA_MOUNTED)) {
//                    Intent getImageByCamera = new Intent("android.media.action.IMAGE_CAPTURE");
//                    startActivityForResult(getImageByCamera, REQUEST_CODE_CAMERA);
//
//                } else {
//                    Toast.makeText(MainActivity.this, "123", Toast.LENGTH_LONG).show();
//                }
                startActivity(new Intent(MainActivity.this,OnlineFaceDemo.class));


            }
        });

        dataDetails.add(new DataDetail("https://www.penghu-nsa.gov.tw/FileDownload/Album/Big/20161012162551758864338.jpg"));
        dataDetails.add(new DataDetail("https://www.penghu-nsa.gov.tw/FileDownload/Album/Big/20161012162551758864338.jpg"));
        dataDetails.add(new DataDetail("https://www.penghu-nsa.gov.tw/FileDownload/Album/Big/20161012162551758864338.jpg"));
        dataDetails.add(new DataDetail("https://www.penghu-nsa.gov.tw/FileDownload/Album/Big/20161012162551758864338.jpg"));
        dataDetails.add(new DataDetail("https://www.penghu-nsa.gov.tw/FileDownload/Album/Big/20161012162551758864338.jpg"));
        dataDetails.add(new DataDetail("https://www.penghu-nsa.gov.tw/FileDownload/Album/Big/20161012162551758864338.jpg"));
        dataDetails.add(new DataDetail("https://www.penghu-nsa.gov.tw/FileDownload/Album/Big/20161012162551758864338.jpg"));


        recyclerview.invalidate();
        recyclerview.postInvalidate();


        myAdapter = new MyAdapter(dataDetails, this);
        myAdapter1 = new MyAdapter(dataDetails, this);


        LinearLayoutManager mgr = new LinearLayoutManager(this);
        mgr.setOrientation(LinearLayoutManager.HORIZONTAL);
        title.setLayoutManager(mgr);
        GridLayoutManager mgr1 = new GridLayoutManager(this, 2);
        mgr1.setOrientation(GridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(mgr1);


        recyclerview.setAdapter(myAdapter);
        title.setAdapter(myAdapter1);


    }

    protected void onActivityResult(int requestcode, int resultcode, Intent data) {
        if (resultcode == Activity.RESULT_OK && requestcode == REQUEST_CODE_CAMERA) {

            FaceRequest mIdVerifier = new FaceRequest(this);
            mIdVerifier.setParameter(SpeechConstant.WFR_SST, "enroll");
            mIdVerifier.setParameter(SpeechConstant.AUTH_ID, "seaning12345");


            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imv.setImageBitmap(bitmap);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,out);
            byte[]imgdata = out.toByteArray();


            mIdVerifier.sendRequest(imgdata,enrollListener);
        }
    }
    public RequestListener enrollListener = new RequestListener() {
        @Override
        public void onEvent(int i, Bundle bundle) {

        }

        @Override
        public void onBufferReceived(byte[] bytes) {

        }

        @Override
        public void onCompleted(SpeechError speechError) {

            if(speechError == null){
                Toast.makeText(MainActivity.this,"success", Toast.LENGTH_SHORT).show();
            }

        }};}