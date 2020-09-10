package com.wordie.leaderboard.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wordie.leaderboard.R;
import com.wordie.leaderboard.model.LeaderBoardDto;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoardListAdapter extends RecyclerView.Adapter<LeaderBoardListAdapter.ViewHolder> {

    private final Context mContext;
    private final Fragment mFragment;
    private LayoutInflater inflater;
    private List<LeaderBoardDto> leaderBoardDtoList = new ArrayList<>();
    private LeaderBoardDto leaderBoardDto;

    public LeaderBoardListAdapter(Context context, Fragment fragment) {
        mContext = context;
        mFragment = fragment;
        this.inflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        leaderBoardDto = leaderBoardDtoList.get(position);
        holder.leaderName.setText(leaderBoardDto.getName());
        if(leaderBoardDto.getHours()!= null){
            holder.leaderResults.setText(leaderBoardDto.getHours() +" learning hours, "+ leaderBoardDto.getCountry());
        }else{
            holder.leaderResults.setText(leaderBoardDto.getScore() +" skill IQ Score, "+ leaderBoardDto.getCountry());
        }
        holder.mCurrentPosition = position;
        Glide.with(holder.badge).load(leaderBoardDto.getBadgeUrl()).into(holder.badge);
    }

    @Override
    public int getItemCount() {
        return leaderBoardDtoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public int mCurrentPosition;
        public final TextView leaderName;
        public final TextView leaderResults;
        public ImageView badge;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leaderName = itemView.findViewById(R.id.text_leader_name);
            leaderResults = itemView.findViewById(R.id.text_leader_results);
            badge = itemView.findViewById(R.id.badge);
        }
    }

    final void setLeaders(List<LeaderBoardDto> leaderItems) {
        this.leaderBoardDtoList = leaderItems;
        notifyDataSetChanged();
    }
}
