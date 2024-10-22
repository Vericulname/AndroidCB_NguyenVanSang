package com.example.recycle_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class story extends AppCompatActivity implements RecycleClick {

    ArrayList<story_item> stories;
    String title;
    RecyclerView list;
    StoryAdapder listAdapder;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_story);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        stories = (ArrayList<story_item>) getIntent().getSerializableExtra("category");
        title = getIntent().getStringExtra("title");
        toolbar = findViewById(R.id.tool2);
        toolbar.setTitle(title);

        list = findViewById(R.id.story_list);
        listAdapder = new StoryAdapder(this,stories,this);
        list.setAdapter(listAdapder);
        list.setLayoutManager(new LinearLayoutManager(this));
        toolbar = findViewById(R.id.tool2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void recycleItemClick(int position) {
        Intent intent = new Intent(this,story_content.class);
        intent.putExtra("story",stories.get(position).getStory());
        intent.putExtra("title",stories.get(position).getTitle());
        startActivity(intent);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}