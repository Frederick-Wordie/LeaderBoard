package com.wordie.leaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.wordie.leaderboard.ui.main.ProjectSubmissionActivity;
import com.wordie.leaderboard.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        Button btnSubmitForm = findViewById(R.id.button_project_form);
        btnSubmitForm.setOnClickListener(view ->  startActivity(new Intent(this, ProjectSubmissionActivity.class)));
        tabs.setupWithViewPager(viewPager);

    }
}