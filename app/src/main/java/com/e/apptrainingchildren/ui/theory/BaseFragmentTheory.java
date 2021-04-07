package com.e.apptrainingchildren.ui.theory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.apptrainingchildren.MainActivity;
import com.e.apptrainingchildren.R;
import com.e.apptrainingchildren.adapters.ListItemTheory;
import com.e.apptrainingchildren.adapters.theory_adapter.TheoryAdapter;
import com.e.apptrainingchildren.arrays.ArraysRecyclerView;

import java.util.ArrayList;

public class BaseFragmentTheory extends Fragment {
    private RecyclerView numberList;
    private TheoryAdapter adapter;
    private ArraysRecyclerView arraysRecyclerView = new ArraysRecyclerView();
    Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_base_theory, container, false);

        toolbar = v.findViewById(R.id.toolbar_base_fragment_theory);
        toolbar.setTitle("");
        if (getActivity()!=null) ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        ArrayList<ListItemTheory> list = new ArrayList<>();
        for (int i = 0; i <arraysRecyclerView.arrTitleTheoryAndTestEnglish.length;i++){
            list.add(new ListItemTheory(arraysRecyclerView.arrTitleTheoryAndTestEnglish[i], arraysRecyclerView.arrContentTheory[i], arraysRecyclerView.arrDrawableTheory[i], i));
        }
        numberList = v.findViewById(R.id.rc_view_theory);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        numberList.setLayoutManager(layoutManager);

        numberList.setHasFixedSize(true);

        adapter = new TheoryAdapter(list, (MainActivity) getActivity());
        numberList.setAdapter(adapter);
        return v;
    }
}
