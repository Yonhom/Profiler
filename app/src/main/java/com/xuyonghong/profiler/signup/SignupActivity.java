package com.xuyonghong.profiler.signup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.xuyonghong.profiler.R;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        loadFragment();

    }

    public void loadFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        Fragment fragment = manager.findFragmentByTag(SignupFragment.class.getSimpleName());

        if (fragment == null) {
            fragment = new SignupFragment();
        }
        transaction.replace(R.id.signup_frag_cont, fragment, SignupFragment.class.getSimpleName());
        transaction.commit();
    }
}
