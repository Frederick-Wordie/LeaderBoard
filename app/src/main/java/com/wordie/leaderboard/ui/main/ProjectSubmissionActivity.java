package com.wordie.leaderboard.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.wordie.leaderboard.R;

import java.util.Objects;

public class ProjectSubmissionActivity extends AppCompatActivity {

    private Button mBtnSave;
    private EditText mEditTextFirstName, mEditTextLastName, mEditTextEmail,mEditProjectLink;
    DialogUtility dialogUtility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        initBtn();
        dialogUtility = new DialogUtility(this);
    }

    private void initBtn(){
        mBtnSave = findViewById(R.id.button_submit_project);
        mEditTextFirstName = findViewById(R.id.text_firstName);
        mEditTextLastName = findViewById(R.id.text_lastName);
        mEditTextEmail = findViewById(R.id.text_email);
        mEditProjectLink = findViewById(R.id.text_project);
        mBtnSave.setOnClickListener(view -> {
            if (!(mEditTextFirstName.getText().toString().isEmpty())
                    && !(mEditTextLastName.getText().toString().isEmpty())
                    && !(mEditTextEmail.getText().toString().isEmpty())
                    && !(mEditProjectLink.getText().toString().isEmpty())) {

                dialogUtility.SubmitProject(mEditTextFirstName.getText().toString(),mEditTextLastName.getText().toString(),
                        mEditTextEmail.getText().toString(),mEditProjectLink.getText().toString() ).show();
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }

        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}