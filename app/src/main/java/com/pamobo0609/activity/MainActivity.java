package com.pamobo0609.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pamobo0609.R;

import manager.ContentManager;
import recyclerview.adapter.SimpleAdapter;

import java.util.ArrayList;

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
    }

    private void getViews() {
        mRecycler = (RecyclerView) findViewById(R.id.rv_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(layoutManager);

        //Your RecyclerView.Adapter
        mAdapter = new SimpleAdapter(this, ContentManager.getInstance().getItems().toArray(new String[ContentManager.getInstance().getItems().size()]));

        ArrayList<SimpleSectionedRecyclerViewAdapter.Section> sections =
                new ArrayList<>();

        //Sections
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(0, "Section 1"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(2, "Section 2"));

        //Add your adapter to the sectionAdapter
        SimpleSectionedRecyclerViewAdapter.Section[] dummy = new SimpleSectionedRecyclerViewAdapter.Section[sections.size()];
        SimpleSectionedRecyclerViewAdapter mSectionedAdapter = new
                SimpleSectionedRecyclerViewAdapter(this, R.layout.recycler_separator, R.id.txtv_separator, mAdapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        //Apply this adapter to the RecyclerView
        mRecycler.setAdapter(mSectionedAdapter);

    }
}
