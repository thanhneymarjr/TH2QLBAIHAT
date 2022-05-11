package com.example.e2th2qlbaihat.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e2th2qlbaihat.R;
import com.example.e2th2qlbaihat.UpdateDeleteActivity;
import com.example.e2th2qlbaihat.adapter.RecycleViewAdapter;
import com.example.e2th2qlbaihat.dal.SQLiteHelper;
import com.example.e2th2qlbaihat.model.Item;

import java.util.List;

public class FragmentList extends Fragment implements RecycleViewAdapter.ItemListener {
    private RecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private SQLiteHelper db;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recycleView);
        adapter=new RecycleViewAdapter();
        db=new SQLiteHelper(getContext());


       // Item i=new Item(2,"nang am xa dan","son tung","abc","def","co");
      //  db.addItem(i);
        List<Item> list =db.getAll();

        adapter.setList(list);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setItemListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        Item item=adapter.getItem(position);
        Intent intent=new Intent(getActivity(), UpdateDeleteActivity.class);
        intent.putExtra("item",item);
        startActivity(intent);

    }

    @Override
    public void onResume() {
        super.onResume();
        List<Item> list=db.getAll();
        adapter.setList(list);
    }
}
