package com.e.apptrainingchildren.ui.theory;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.apptrainingchildren.MainActivity;
import com.e.apptrainingchildren.R;
import com.e.apptrainingchildren.adapters.ListItemTheory;
import com.e.apptrainingchildren.adapters.ListItemTheoryContent;
import com.e.apptrainingchildren.adapters.theory_adapter.TheoryAdapter;
import com.e.apptrainingchildren.adapters.theory_adapter.TheoryContentAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class FragmentTheoryContent extends Fragment {
    private RecyclerView numberList;
    private TheoryContentAdapter adapter;
    Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_theory_content, container, false);
        ArrayList<ListItemTheoryContent> list = new ArrayList<>();
        toolbar = v.findViewById(R.id.toolbar_base_fragment_theory_content);
        if (getActivity()!=null) ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        Bundle bundle = this.getArguments();
        ArrayList<String> word = new ArrayList<>(bundle.getStringArrayList("arrWord"));
        ArrayList<Integer> drawable = new ArrayList<>(bundle.getIntegerArrayList("arrDrawable"));
        ArrayList<Integer> sound = new ArrayList<>(bundle.getIntegerArrayList("arrSound"));
        for (int i = 0 ; i <word.size();i++){
            list.add(new ListItemTheoryContent(word.get(i), drawable.get(i), sound.get(i)));
        }
        numberList = v.findViewById(R.id.rc_view_theory_content);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        numberList.setLayoutManager(layoutManager);

        numberList.setHasFixedSize(true);

        adapter = new TheoryContentAdapter(list);
        numberList.setAdapter(adapter);

    return v;}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            assert getFragmentManager() != null;
            getFragmentManager().popBackStack();
        }
        return super.onOptionsItemSelected(item);
    }
}
