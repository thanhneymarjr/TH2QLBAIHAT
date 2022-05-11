package com.example.e2th2qlbaihat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.e2th2qlbaihat.adapter.ViewPagerAdapter;
import com.example.e2th2qlbaihat.dal.SQLiteHelper;

import com.example.e2th2qlbaihat.model.Item;

import java.util.Calendar;

public class UpdateDeleteActivity extends AppCompatActivity implements View.OnClickListener {
    public Spinner spAlbum,spCat,spFav;
    private EditText eSong,eSinger;
    private Button btUpdate,btBack,btRemove;
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);
        initView();
        btBack.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btRemove.setOnClickListener(this);
        eSinger.setOnClickListener(this);

        Intent intent=getIntent();
        item=(Item) intent.getSerializableExtra("item");
        eSong.setText(item.getSong());
        eSinger.setText(item.getSinger());

        int p=0;
        for(int i=0;i<spAlbum.getCount();i++){
            if(spAlbum.getItemAtPosition(i).toString().equalsIgnoreCase(item.getAlbum())){
                p=i;
                break;


            }
        }
        spAlbum.setSelection(p);
        int q=0;
        for(int i=0;i<spCat.getCount();i++){
            if(spCat.getItemAtPosition(i).toString().equalsIgnoreCase(item.getCategory())){
                q=i;
                break;


            }
        }
        spCat.setSelection(q);
        int t=0;
        for(int i=0;i<spFav.getCount();i++){
            if(spFav.getItemAtPosition(i).toString().equalsIgnoreCase(item.getFavourite())){
                t=i;
                break;


            }
        }
        spFav.setSelection(t);
    }

    private void initView() {
        eSinger=findViewById(R.id.tvSinger);
        eSong=findViewById(R.id.tvSong);

        spAlbum=findViewById(R.id.spAlbum);
        spCat=findViewById(R.id.spCategory);
        spFav=findViewById(R.id.spFavourite);
        btUpdate=findViewById(R.id.btUpdate);
        btRemove=findViewById(R.id.btRemove);
        btBack=findViewById(R.id.btBack);
        spAlbum.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spinner,
                getResources().getStringArray(R.array.album) ));
        spCat.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spinner,
                getResources().getStringArray(R.array.category) ));
        spFav.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spinner,
                getResources().getStringArray(R.array.favorite) ));
    }

    @Override
    public void onClick(View view) {
        SQLiteHelper db=new SQLiteHelper(this);

        if(view==btBack){
            finish();
        }
        if(view==btUpdate){
            String song=eSong.getText().toString();
            String singer=eSinger.getText().toString();
            String album=spAlbum.getSelectedItem().toString();
            String cat=spCat.getSelectedItem().toString();
            String favourite=spFav.getSelectedItem().toString();
            if(!song.isEmpty()&&!singer.isEmpty()){
                int id=item.getId();
                Item i=new Item(id,song,singer,album,cat,favourite);
                db=new SQLiteHelper(this);
                db.update(i);
                finish();
            }
        }
        if(view==btRemove){
            int id=item.getId();
            AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
            builder.setTitle("Thong bao xoa");
            builder.setMessage("Ban co chac muon xoa"+item.getSong()+"khong?");
            builder.setIcon(R.drawable.download);
            builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    SQLiteHelper bb=new SQLiteHelper(getApplicationContext());
                    bb.delete(id);
                    finish();

                }
            });
            builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {


                }
            });
            AlertDialog dialog=builder.create();
            dialog.show();
        }


    }
}