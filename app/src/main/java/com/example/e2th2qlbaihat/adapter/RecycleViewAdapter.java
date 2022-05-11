package com.example.e2th2qlbaihat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e2th2qlbaihat.R;
import com.example.e2th2qlbaihat.model.Item;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.HomeViewHolder> {
    private List<Item> list;
    private ItemListener itemListener;

    public RecycleViewAdapter() {
        list = new ArrayList<>();
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public void setList(List<Item> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public Item getItem(int position){
        return list.get(position);
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Item item=list.get(position);
        holder.song.setText(item.getSong());
        holder.singer.setText(item.getSinger());
        holder.album.setText(item.getAlbum());
        holder.category.setText(item.getCategory());

        holder.favourite.setText(item.getFavourite());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView song,singer,album,category,favourite;

        public HomeViewHolder(@NonNull View view) {
            super(view);
            song=view.findViewById(R.id.tvSong);
            category=view.findViewById(R.id.tvCategory);
            singer=view.findViewById(R.id.tvSinger);
            album=view.findViewById(R.id.tvAlbum);
            favourite=view.findViewById(R.id.tvFavourite);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if(itemListener!=null){
                itemListener.onItemClick(view,getAdapterPosition());
            }

        }
    }
    public interface ItemListener{
        void onItemClick(View view,int position);

    }

}
