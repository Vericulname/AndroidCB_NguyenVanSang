package com.example.recycle_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapder extends RecyclerView.Adapter<CategoryAdapder.ViewHolder> {
    private final RecycleClick recycleClick;
    Context context;
    ArrayList<category_items> categories;

    public CategoryAdapder(Context context, ArrayList<category_items> categories, RecycleClick recycleClick) {
        this.context = context;
        this.categories = categories;
        this.recycleClick = recycleClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        System.out.println(viewType);
        System.out.println(parent);
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder viewHolder = null;
        View view = inflater.inflate(R.layout.activity_category_items, parent, false);
        viewHolder = new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imgv.setImageDrawable(categories.get(position).getImage());
        holder.tv.setText(categories.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgv;
        private TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgv = itemView.findViewById(R.id.imgV1);
            tv = itemView.findViewById(R.id.tv2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recycleClick != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            recycleClick.recycleItemClick(pos);
                        }
                    }
                }
            });

        }
    }
}
