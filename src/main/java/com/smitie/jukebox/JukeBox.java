package com.smitie.jukebox;

public class JukeBox implements Selector {

    private final  CDPlayer cdPlayer;

    public JukeBox(CDPlayer cdPlayer) {
        this.cdPlayer = cdPlayer;
    }

    @Override
    public void nextSongBtn() {
        System.out.println("Playing next song ...");
        cdPlayer.playNextSong();
    }

    @Override
    public void prevSongBtn() {
        System.out.println("Playing previous song ...");
        cdPlayer.playPrevSong();
    }

    @Override
    public void addSongToPlaylistBtn() {

    }

    @Override
    public void removeSongFromPlaylistBtn() {

    }

    @Override
    public void shuffleBtn() {

    }


}
