package com.wordie.leaderboard.service;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.wordie.leaderboard.model.LeaderBoardDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderBoardNetworkCalls {

    Context context;
    private MutableLiveData<List<LeaderBoardDto>> leaderBoardDtoList = new MutableLiveData();
    public LeaderBoardNetworkCalls(Context context) {
        this.context = context;
    }

    public LiveData<List<LeaderBoardDto>> getLearningLeaders(){
        LeaderBoardService leaderBoardService = ServiceBuilder.buildService(LeaderBoardService.class);
        Call<List<LeaderBoardDto>> request = leaderBoardService.getLearningLeaders();
        request.enqueue(new Callback<List<LeaderBoardDto>>() {
            @Override
            public void onResponse(Call<List<LeaderBoardDto>> call, Response<List<LeaderBoardDto>> response) {
                if (response.isSuccessful()) {
                    leaderBoardDtoList.setValue(response.body());
                }else{
                    Toast.makeText(context, "Retrieving learners list failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<LeaderBoardDto>> call, Throwable t) {
                Toast.makeText(context, "Please check your connection and try again", Toast.LENGTH_SHORT).show();
            }
        });
        return leaderBoardDtoList;
    }

    public LiveData<List<LeaderBoardDto>> getSkillIQLeaders(){
        LeaderBoardService leaderBoardService = ServiceBuilder.buildService(LeaderBoardService.class);
        Call<List<LeaderBoardDto>> request = leaderBoardService.getSkillIQLeaders();
        request.enqueue(new Callback<List<LeaderBoardDto>>() {
            @Override
            public void onResponse(Call<List<LeaderBoardDto>> call, Response<List<LeaderBoardDto>> response) {
                if (response.isSuccessful()) {
                    leaderBoardDtoList.setValue(response.body());
                }else{
                    Toast.makeText(context, "Retrieving Skill IQ leaders list failed", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<LeaderBoardDto>> call, Throwable t) {
                Toast.makeText(context, "Please check your connection and try again", Toast.LENGTH_SHORT).show();
            }
        });
        return leaderBoardDtoList;
    }

    public void submitProject(String email, String firstName, String lastName, String projectLink){
        String newURL = "https://docs.google.com/forms/d/e/";
        ServiceBuilder.changeApiBaseUrl(newURL);
        LeaderBoardService leaderBoardService = ServiceBuilder.buildService(LeaderBoardService.class);
        Call<Void> request = leaderBoardService.submitProject(email,firstName,lastName,projectLink);
        request.enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(context, "Done Sending", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "Sending failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
