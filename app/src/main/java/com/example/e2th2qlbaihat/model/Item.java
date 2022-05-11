package com.example.e2th2qlbaihat.model;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private String song,singer,album,category,favourite;

    public Item() {
    }

    public Item(int id, String song, String singer, String album, String category, String favourite) {
        this.id = id;
        this.song = song;
        this.singer = singer;
        this.album = album;
        this.category = category;
        this.favourite = favourite;
    }

    public Item(String song, String singer, String album, String category, String favourite) {
        this.song = song;
        this.singer = singer;
        this.album = album;
        this.category = category;
        this.favourite = favourite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }
}
