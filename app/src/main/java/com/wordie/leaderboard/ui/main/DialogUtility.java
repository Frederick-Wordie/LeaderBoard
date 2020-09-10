package com.wordie.leaderboard.ui.main;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.wordie.leaderboard.R;
import com.wordie.leaderboard.service.LeaderBoardNetworkCalls;

import java.util.Objects;

public class DialogUtility {

    private Context context;
    LeaderBoardNetworkCalls network ;
    public DialogUtility(Context context) {
        this.context = context;
    }

    public Dialog SubmitProject(String firstName, String lastName, String email, String projectLink){
        final Dialog dialog = new Dialog(context);
        network = new LeaderBoardNetworkCalls(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.submit_project_popup);

        final Button buttonSubmit = dialog.findViewById(R.id.button_submit);
        final ImageView imgCancel = dialog.findViewById(R.id.button_cancel);
        imgCancel.setOnClickListener(view ->dialog.dismiss());
        buttonSubmit.setOnClickListener(view -> {
            network.submitProject(firstName,lastName,email,projectLink);
            dialog.dismiss();
    });
        return dialog;
    }

    public Dialog SuccessDialog(){
        final Dialog dialog = new Dialog(context);
        network = new LeaderBoardNetworkCalls(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.success_dialog);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

        return dialog;
    }

    public Dialog FailureDialog(){
        final Dialog dialog = new Dialog(context);
        network = new LeaderBoardNetworkCalls(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.failure_dialog);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

        return dialog;
    }
}
