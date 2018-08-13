package com.jerome.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jerome.tvfocus.BorderConfig;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BorderConfig.init(R.drawable.item_focus)
                .shadowRes(R.drawable.item_unfocus)
                .debug(true)
                .create();
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new SpaceItemDecoration(10));
        recyclerView.setAdapter(new MyAdapter());
    }

    private class MyHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
        }

        public void setTextView(String text) {
            textView.setText(text);
        }
    }

    private class MyAdapter extends RecyclerView.Adapter<MyHolder> {
        private final LayoutInflater mLayoutInflater;

        public MyAdapter() {
            mLayoutInflater = LayoutInflater.from(MainActivity.this);
        }

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mLayoutInflater.inflate(R.layout.item, parent, false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.setTextView("DecorRecyclerView-item-" + position);
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }
}