package com.example.e2th2qlbaihat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.e2th2qlbaihat.dal.SQLiteHelper;
import com.example.e2th2qlbaihat.model.Item;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity implements View.OnClickListener  {
    public Spinner spAlbum,spCat,spFav;
    private EditText eSong,eSinger;
    private Button btAdd,btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
        btCancel.setOnClickListener(this);
        btAdd.setOnClickListener(this);

    }

    private void initView() {

        eSinger=findViewById(R.id.tvSinger);
        eSong=findViewById(R.id.tvSong);

        spAlbum=findViewById(R.id.spAlbum);
        spCat=findViewById(R.id.spCategory);
        spFav=findViewById(R.id.spFavourite);
        btAdd=findViewById(R.id.btAdd);
        btCancel=findViewById(R.id.btCancel);
        spAlbum.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spinner,
                getResources().getStringArray(R.array.album) ));
        spCat.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spinner,
                getResources().getStringArray(R.array.category) ));
        spFav.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spinner,
                getResources().getStringArray(R.array.favorite) ));
    }

    @Override
    public void onClick(View view) {

        if(view==btCancel){
            finish();
        }
        if(view==btAdd){
            String song=eSong.getText().toString();
            String singer=eSinger.getText().toString();
            String cat=spCat.getSelectedItem().toString();
            String album=spAlbum.getSelectedItem().toString();
            String favourite=spFav.getSelectedItem().toString();
            if(!song.isEmpty()&&!singer.isEmpty()){
                Item i=new Item(song,singer,album,cat,favourite);
                SQLiteHelper db=new SQLiteHelper(this);
                db.addItem(i);
                finish();
            }
        }

    }
}