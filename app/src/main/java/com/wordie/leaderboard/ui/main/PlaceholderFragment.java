package com.wordie.leaderboard.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wordie.leaderboard.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;
    private LeaderBoardListAdapter leaderboardListAdapter;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index,getContext());
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        leaderboardListAdapter = new LeaderBoardListAdapter(getContext(),  this);
        RecyclerView recyclerView = root.findViewById(R.id.leads_list);
        recyclerView.setAdapter(leaderboardListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity().getApplicationContext()));
        pageViewModel.getLeaders().observe(getViewLifecycleOwner(), leaderboardListAdapter::setLeaders);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        pageViewModel.getLeaders().observe(getViewLifecycleOwner(), leaderboardListAdapter::setLeaders);
    }
}