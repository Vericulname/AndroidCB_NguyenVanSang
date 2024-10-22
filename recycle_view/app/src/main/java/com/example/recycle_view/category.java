package com.example.recycle_view;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class category extends AppCompatActivity implements RecycleClick {
    RecyclerView list;
    CategoryAdapder Adapder;
    ArrayList<category_items> categories = new ArrayList<>();
    ArrayList<story_item> stories = new ArrayList<>();
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        innit();
        list = findViewById(R.id.list1);

        Adapder = new CategoryAdapder(this, categories, this);
        list.setAdapter(Adapder);
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    private void innit() {
        stories.add(new story_item("mẹ mày béo vcl","Story_t1"));
        categories.add(new category_items("title1", getResources().getDrawable(R.drawable.arrow_left), new ArrayList<story_item>(stories)));
        stories.add(new story_item("mẹ mày gae","Story_t2"));
        categories.add(new category_items("title2", getResources().getDrawable(R.drawable.arrow_left), new ArrayList<story_item>(stories)));
    }

    @Override
    public void recycleItemClick(int position) {
        Intent intent = new Intent(this, story.class);
        intent.putExtra("category", categories.get(position).getStories());
        intent.putExtra("title", categories.get(position).getTitle());
        startActivity(intent);
    }
}