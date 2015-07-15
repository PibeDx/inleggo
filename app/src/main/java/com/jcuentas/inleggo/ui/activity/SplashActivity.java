package com.jcuentas.inleggo.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBarActivity;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.ImageView;

import com.jcuentas.inleggo.R;


public class SplashActivity extends ActionBarActivity {

    ImageView imvLogo;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setSharedElementExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.shared_element_transition_a));
        }
        setContentView(R.layout.activity_splash);
        imvLogo = (ImageView) findViewById(R.id.imv_logo);
        imvLogo.setOnClickListener(new imgLogoOnClickListener());


    }

    private class imgLogoOnClickListener implements View.OnClickListener {
        @SuppressLint("NewApi")
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            if (Build.VERSION.SDK_INT >= 21) {
                v.setTransitionName("imageViewLogo");
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(SplashActivity.this, v, v.getTransitionName());

                startActivity(intent, optionsCompat.toBundle());

            } else
                startActivity(intent);
            finish();
        }
    }
}
