package com.e.apptrainingchildren.adapters.theory_adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.e.apptrainingchildren.MainActivity;
import com.e.apptrainingchildren.R;
import com.e.apptrainingchildren.adapters.ListItemTheory;
import com.e.apptrainingchildren.adapters.ListItemTheoryContent;
import com.e.apptrainingchildren.arrays.Color;
import com.e.apptrainingchildren.ui.theory.FragmentTheoryContent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class TheoryContentAdapter extends RecyclerView.Adapter<TheoryContentAdapter.ViewHolder> {

    private ArrayList<ListItemTheoryContent> list = new ArrayList<>();

    public TheoryContentAdapter(ArrayList<ListItemTheoryContent> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TheoryContentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_adapter_theory_content, parent, false);
        return new ViewHolder(view, list);
    }

    @Override
    public void onBindViewHolder(@NonNull TheoryContentAdapter.ViewHolder holder, int position) {
        ListItemTheoryContent listItemTheoryContent = list.get(position);
        holder.bind(listItemTheoryContent.getWord(), listItemTheoryContent.getDrawable());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewWord;
        private ImageView imageView;
        private ImageButton imageButton;
        private MediaPlayer mediaPlayer;
        public ViewHolder(@NonNull final View itemView, final ArrayList<ListItemTheoryContent> listItemTheoriescontent) {
            super(itemView);
           textViewWord = itemView.findViewById(R.id.tv_word_theory_content);
           imageView = itemView.findViewById(R.id.tv_image_theory_content);
           imageButton = itemView.findViewById(R.id.buttonSoundTheory);
           imageButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   mediaPlayer = MediaPlayer.create(itemView.getContext(), listItemTheoriescontent.get(getAdapterPosition()).getSound());
                   mediaPlayer.start();
               }
           });
        }
        public void bind (String word, int drawable) {
            textViewWord.setText(word);
            imageView.setBackground(ContextCompat.getDrawable(itemView.getContext(), drawable));

        }
    }
}