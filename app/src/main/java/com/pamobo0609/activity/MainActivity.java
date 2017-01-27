package com.pamobo0609.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pamobo0609.R;

import java.util.ArrayList;

import manager.ContentManager;
import recyclerview.adapter.SimpleAdapter;
import recyclerview.adapter.SimpleSectionedRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecycler;

    SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // To init all visual content
        getViews();
        // Recycler init
        setUpRecyclerView();
    }

    private void getViews() {
        mRecycler = (RecyclerView) findViewById(R.id.rv_list);
    }

    private void setUpRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(layoutManager);

        // This adapter has the RecyclerView's items.
        mAdapter = new SimpleAdapter(ContentManager.getInstance().getItems());

        ArrayList<SimpleSectionedRecyclerViewAdapter.Section> sections =
                new ArrayList<>();

        // Sections
        // IMPORTANT: to add a header, we still need to add a section at the first position, which
        // is zero.
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(0, "HEADER"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(2, "Section 2"));

        // The sections adapter is going to fill the Recyclerview with sections, in the given positions
        // of the sections array
        SimpleSectionedRecyclerViewAdapter.Section[] dummy = new SimpleSectionedRecyclerViewAdapter.Section[sections.size()];
        SimpleSectionedRecyclerViewAdapter mSectionedAdapter = new
                SimpleSectionedRecyclerViewAdapter(mAdapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        // Apply this adapter to the RecyclerView
        mRecycler.setAdapter(mSectionedAdapter);
    }
}
