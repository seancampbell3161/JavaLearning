import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Jukebox1 {

    public ArrayList<String> songList = new ArrayList<>();

    public static void main(String[] args) {
        Jukebox1 j1 = new Jukebox1();
        j1.go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
    }

    public void getSongs() {
        try {
            File file = new File("songs.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void addSong(String s) {
        String[] songAndArtist = s.split("/");
        songList.add(songAndArtist[0]);
    }
}
