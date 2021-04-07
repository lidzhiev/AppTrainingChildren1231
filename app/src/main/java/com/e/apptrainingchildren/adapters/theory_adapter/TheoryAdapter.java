package com.e.apptrainingchildren.adapters.theory_adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.e.apptrainingchildren.MainActivity;
import com.e.apptrainingchildren.R;
import com.e.apptrainingchildren.adapters.ListItemTheory;
import com.e.apptrainingchildren.adapters.ListItemTheoryContent;
import com.e.apptrainingchildren.arrays.Color;
import com.e.apptrainingchildren.arrays.Shapes;
import com.e.apptrainingchildren.arrays.Shapes2;
import com.e.apptrainingchildren.ui.theory.FragmentTheoryContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TheoryAdapter extends RecyclerView.Adapter<TheoryAdapter.ViewHolder> {

    private final ArrayList<ListItemTheory> list;
    private MainActivity context;

    public TheoryAdapter(ArrayList<ListItemTheory> list, MainActivity context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_adapter_theory, parent, false);
        return new ViewHolder(view, (MainActivity) context, list);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItemTheory listItemTheory = list.get(position);
        holder.bind(listItemTheory.getTitle(), listItemTheory.getContent(), listItemTheory.getDrawable());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private Color color = new Color();
        private Shapes shapes = new Shapes();
        private Shapes2 shapes2 = new Shapes2();
        private
        TextView titleTheory;
        TextView contentTheory;
        ImageView imageViewTheory;
        HashMap<Integer, String[]> hashMapWords = new HashMap<>();
        HashMap<Integer, int[]> hashDrawable = new HashMap<>();
        HashMap<Integer, int[]> hashSound = new HashMap<>();
        private ArrayList<ListItemTheoryContent> list = new ArrayList<>();
        private ArrayList<String> arrWord = new ArrayList<>();
        private ArrayList<Integer> arrDrawable = new ArrayList<>();
        private ArrayList<Integer> arrSound = new ArrayList<>();
        private FragmentTheoryContent fragmentTheoryContent = new FragmentTheoryContent();
        public ViewHolder(@NonNull final View itemView, final MainActivity context, final ArrayList<ListItemTheory> listItemTheories) {
            super(itemView);
            titleTheory = itemView.findViewById(R.id.tvTitleTheory);
            contentTheory = itemView.findViewById(R.id.tvContentTheory);
            imageViewTheory = itemView.findViewById(R.id.image_v_theory);

            hashMapWords.put(0, color.arrColor);
            hashDrawable.put(0, color.arrColorDrawable);
            hashSound.put(0, color.arrColorSound);

            hashMapWords.put(1, shapes.arrShapes);
            hashDrawable.put(1, shapes.arrShapesDrawable);
            hashSound.put(1, shapes.arrShapesSound);

            hashMapWords.put(2, shapes2.arrShapes2);
            hashDrawable.put(2, shapes2.arrShapes2Drawable);
            hashSound.put(2, shapes2.arrShapes2Sound);

            hashMapWords.put(3, shapes2.arrShapes2);
            hashDrawable.put(3, shapes2.arrShapes2Drawable);
            hashSound.put(3, shapes2.arrShapes2Sound);





            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int i = 0; i <hashMapWords.get(getAdapterPosition()).length;i++){
                        arrWord.add(hashMapWords.get(getAdapterPosition())[i]);
                        arrDrawable.add(hashDrawable.get(getAdapterPosition())[i]);
                        arrSound.add(hashSound.get(getAdapterPosition())[i]);
                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("arrWord", arrWord);
                    bundle.putIntegerArrayList("arrDrawable", arrDrawable);
                    bundle.putIntegerArrayList("arrSound", arrSound);
                    fragmentTheoryContent.setArguments(bundle);
                    context.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, fragmentTheoryContent)
                            .addToBackStack("s")
                            .commit();
                }
            });
        }
        public void bind(String title, String content, int drawable){
            titleTheory.setText(title);
            contentTheory.setText(content);
            imageViewTheory.setBackground(ContextCompat.getDrawable(itemView.getContext(), drawable));
        }
    }
}