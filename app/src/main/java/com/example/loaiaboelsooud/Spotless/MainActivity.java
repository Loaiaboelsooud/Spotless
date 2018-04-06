package com.example.loaiaboelsooud.Spotless;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "relativeLayout";
    private View mProgressView, mLoginView;
    //ProgressBar mLoginView;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        mLoginView = findViewById(R.id.login_progress);
        mProgressView = findViewById(R.id.login_form);
        mLoginView.setVisibility(View.INVISIBLE);
        Button stbutton = findViewById(R.id.SignInB);
        stbutton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        // mLoginView.setVisibility(View.VISIBLE);
                        //    showProgress(true);
                        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                        intent.putExtra("activity", "MainActivity");
                        startActivity(intent);
                        //  mLoginView.setVisibility(View.INVISIBLE);

                    }
                }
        );
        Button ndbutton = findViewById(R.id.WorkWithUsB);
        ndbutton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                        //intent.putExtra("activity", "MenuActivity");
                        startActivity(intent);
                    }
                }
        );

    }

    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

}
