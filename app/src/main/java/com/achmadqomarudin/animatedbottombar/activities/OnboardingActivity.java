package com.achmadqomarudin.animatedbottombar.activities;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;


import com.achmadqomarudin.animatedbottombar.R;
import com.hololo.tutorial.library.PermissionStep;
import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;


public class OnboardingActivity extends TutorialActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addFragment(
                new PermissionStep
                        .Builder()
                        .setPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
                        .setTitle(getString(R.string.permission_title)).setContent(getString(R.string.permission_detail))
                        .setBackgroundColor(Color.parseColor("#4C6BFD"))
                        .setDrawable(R.drawable.onboarding_1)
                        .build());
        addFragment(
                new Step.Builder()
                        .setTitle(getString(R.string.automatic_data))
                        .setContent(getString(R.string.gm_finds_photos))
                        .setBackgroundColor(Color.parseColor("#4C6BFD"))
                        .setDrawable(R.drawable.onboarding_2)
                        .build());
        addFragment(
                new Step.Builder()
                        .setTitle(getString(R.string.choose_the_song))
                        .setContent(getString(R.string.swap_to_the_tab))
                        .setBackgroundColor(Color.parseColor("#4C6BFD"))
                        .setDrawable(R.drawable.onboarding_3)
                        .setSummary(getString(R.string.continue_and_update))
                        .build());
    }

    @Override
    public void finishTutorial() {
        finish();
    }

    @Override
    public void currentFragmentPosition(int position) {
    }
}
