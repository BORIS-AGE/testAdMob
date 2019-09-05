package com.example.boris.myapplication;

import android.widget.Toast;

import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class AddListener implements RewardedVideoAdListener {

    private MainActivity mainActivity;

    public AddListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        mainActivity.loadReward();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        Toast.makeText(mainActivity, "video rewarded", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }
}
