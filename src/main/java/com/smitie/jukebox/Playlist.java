package com.smitie.jukebox;

import java.util.List;

public class Playlist {
    private Song song;
    private final List<Song> songs;

    public Playlist(List<Song> songs) {
        this.songs = songs;
    }

    public Playlist(Song song, List<Song> songs) {
        this.song = song;
        this.songs = songs;
    }

    protected void addSong(Song song) {}

    protected void removeSong(Song song){}

    protected void shuffle() {}

    protected Song getNextSong(){
        return null;
    }
    protected Song getPrevSong(){
        return null;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
