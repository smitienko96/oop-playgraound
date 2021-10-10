package com.smitie.jukebox;

import java.util.Set;

public class CDPlayer {
    private CD cd;

    private final Set<CD> cds;
    private final Playlist playlist;

    public CDPlayer(Playlist playlist, Set<CD> cds) {
        this.cds = cds;
        this.playlist = playlist;
    }

    protected void playNextSong(){}
    protected void playPrevSong(){}
    protected void addCD(){}
    protected void removeCD(){}

    public CD getCd() {
        return cd;
    }

    public Set<CD> getCds() {
        return cds;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

}
