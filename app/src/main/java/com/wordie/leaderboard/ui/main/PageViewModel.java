package com.wordie.leaderboard.ui.main;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.wordie.leaderboard.model.LeaderBoardDto;
import com.wordie.leaderboard.service.LeaderBoardNetworkCalls;

import java.util.List;

public class PageViewModel extends ViewModel {
    private Context context;
    LeaderBoardNetworkCalls network ;
    private Integer position = 0;
    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();

    private LiveData<List<LeaderBoardDto>> getLeaderData(){
        network = new LeaderBoardNetworkCalls(context);
        if (position.equals(1)) {
            System.out.println("first fragment called");
            return network.getLearningLeaders();
        }
        return network.getSkillIQLeaders();
    }

    public void setIndex(int index,Context context) {
        this.context = context;
        position = index;
        mIndex.setValue(index);
    }

    public LiveData<List<LeaderBoardDto>> getLeaders() {
        return getLeaderData();
    }
}