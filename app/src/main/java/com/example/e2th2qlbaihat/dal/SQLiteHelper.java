package com.example.e2th2qlbaihat.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.e2th2qlbaihat.model.Item;
import com.example.e2th2qlbaihat.model.Item;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="BaiHat.db";
    private static int DATABASE_VERSION=5;
    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE items(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "song TEXT,singer TEXT,album TEXT,category TEXT,favourite TEXT)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
    //get all order by id
    public List<Item> getAll(){
        List<Item> list=new ArrayList<>();
        SQLiteDatabase st=getReadableDatabase();
        String order ="singer DESC";
        Cursor rs=st.query("items",null,null,
                null,null,null,order);
        while((rs!=null) && (rs.moveToNext())){
            int id=rs.getInt(0);
            String song=rs.getString(1);
            String sin=rs.getString(2);
            String album=rs.getString(3);
            String category=rs.getString(4);
            String favourite=rs.getString(5);
            list.add(new Item(id,song,sin,album,category,favourite));
        }


        return list;

    }
    //add
    public long addItem(Item i){
        ContentValues values=new ContentValues();
        values.put("song",i.getSong());
        values.put("singer",i.getSinger());
        values.put("album",i.getAlbum());
        values.put("category",i.getCategory());
        values.put("favourite",i.getFavourite());
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        return sqLiteDatabase.insert("items",null,values);

    }

    //update
    public int update(Item i){
        ContentValues values=new ContentValues();
        values.put("song",i.getSong());
        values.put("singer",i.getSinger());
        values.put("category",i.getCategory());
        values.put("album",i.getAlbum());
        values.put("favourite",i.getFavourite());
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String whereClause="id=?";
        String[] whereArgs={Integer.toString(i.getId())};

        return sqLiteDatabase.update("items",values,whereClause,whereArgs);

    }
    //delete
    public int delete(int id){
        String whereClause="id=?";
        String[] whereArgs={Integer.toString(id)};
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        return sqLiteDatabase.delete("items",whereClause,whereArgs);

    }
    //lay item theo title
    public List<Item> searchBySong(String key){
        List<Item> list=new ArrayList<>();
        String whereClause="song like?";
        String[] whereArgs={"%"+key+"%"};
        SQLiteDatabase st=getReadableDatabase();
        Cursor rs=st.query("items",null,whereClause,whereArgs,null,
                null,null);
        while(rs!=null && rs.moveToNext()){
            int id=rs.getInt(0);
            String song=rs.getString(1);
            String singer=rs.getString(2);
            String album=rs.getString(3);
            String category=rs.getString(4);
            String favourite=rs.getString(5);
            list.add(new Item(id,song,singer,album,category,favourite));




        }
        return list;



    }
    public List<Item> SearchByAlbum(String album){
        List<Item> list=new ArrayList<>();
        String whereClause="album like?";
        String[] whereArgs={album};
        SQLiteDatabase st=getReadableDatabase();
        Cursor rs=st.query("items",null,whereClause,whereArgs,null,
                null,null);
        while(rs!=null && rs.moveToNext()){
            int id=rs.getInt(0);
            String song=rs.getString(1);
            String singer=rs.getString(2);
            String alb=rs.getString(3);
            String cat=rs.getString(4);
            String favourite=rs.getString(5);
            list.add(new Item(id,song,singer,alb,cat,favourite));

        }
        return list;



    }
    public List<Item> SearchByCategory(String category){
        List<Item> list=new ArrayList<>();
        String whereClause="category like?";
        String[] whereArgs={category};
        SQLiteDatabase st=getReadableDatabase();
        Cursor rs=st.query("items",null,whereClause,whereArgs,null,
                null,null);
        while(rs!=null && rs.moveToNext()){
            int id=rs.getInt(0);
            String song=rs.getString(1);
            String singer=rs.getString(2);
            String album=rs.getString(3);
            String cat=rs.getString(4);
            String favourite=rs.getString(5);
            list.add(new Item(id,song,singer,album,cat,favourite));

        }
        return list;



    }



}
