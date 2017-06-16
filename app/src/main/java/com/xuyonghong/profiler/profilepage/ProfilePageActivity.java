package com.xuyonghong.profiler.profilepage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.xuyonghong.profiler.R;

public class ProfilePageActivity extends AppCompatActivity {

    public static final String FRAGMENT_TAG = "PROFILE_PAGE_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        // load fragment
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(FRAGMENT_TAG);
        if (fragment == null) {
            fragment = new ProfilePageFragment();
        }
        manager.beginTransaction()
                .replace(R.id.profile_page_frag_cont, fragment, FRAGMENT_TAG)
                .commit();
    }
}
