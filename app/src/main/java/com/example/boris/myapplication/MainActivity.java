package com.example.boris.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<MessageModel> messages;
    private MyAdapter adapter;
    private RewardedVideoAd rAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefaults();

        recyclerView.setAdapter(adapter);
    }

    private void setDefaults() {
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        messages = new ArrayList<>(getMessages());
        adapter = new MyAdapter(messages, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        rAd = MobileAds.getRewardedVideoAdInstance(this);
        rAd.setRewardedVideoAdListener(new AddListener(this));
        loadReward();
    }
    public void loadReward(){
        if (!rAd.isLoaded()){
            rAd.loadAd("ca-app-pub-3940256099942544/5224354917", new AdRequest.Builder().addTestDevice("33BE2250B43518CCDA7DE426D04EE231").build());
        }
    }

    public void startAd(){
        if (rAd.isLoaded())
            rAd.show();
    }
    private List<MessageModel> getMessages() {
        List<MessageModel> messageModels = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i % 5 == 0){
                messageModels.add(new MessageModel(R.drawable.pic9, "Link", MessageType.LINK, System.currentTimeMillis()));
                continue;
            }
            if (i % 2 == 0){
                messageModels.add(new MessageModel(R.drawable.pic1, "Simple oponent text", MessageType.OPONENT_MESSAGE, System.currentTimeMillis()));
                continue;
            }
            if (i % 2 == 1){
                messageModels.add(new MessageModel(R.drawable.pic2, "My text", MessageType.MY_MESSAGE, System.currentTimeMillis()));
                continue;
            }
        }
        return messageModels;
    }

    @Override
    protected void onPause() {
        rAd.pause(this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        rAd.resume(this);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        rAd.destroy(this);
        super.onDestroy();
    }
}


/*
* а(итенное) = а(полученное) +- дельта а (ошибка)
* а>>дельта а - очень точное
* а~дельта а - очень большая ошибка
* коефициент ошибки Ба = дельта а/а(истенное)
* */