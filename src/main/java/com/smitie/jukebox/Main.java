package com.smitie.jukebox;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        CD cd1 = new CD();
        Song s1 = new Song("Song 1", cd1);
        Song s2 = new Song("Song 2", cd1);
        cd1.setSongs(List.of(s1, s2));

        CD cd2 = new CD();
        Song s3 = new Song("Song 3", cd2);
        Song s4 = new Song("Song 4", cd2);
        cd2.setSongs(List.of(s3, s4));

        Playlist pl = new Playlist(List.of(s1, s2, s3, s4));

        CDPlayer cdp = new CDPlayer(pl, Set.of(cd1, cd2));

        JukeBox jb = new JukeBox(cdp);

        User user = new User(jb);

        user.getJukebox().nextSongBtn();
    }
}
