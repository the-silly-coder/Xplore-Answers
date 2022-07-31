import java.util.*;
public class Solution {
    public static void main(String[] args){
        String songName;
        int duration;
        String artists, language;
        double rating;
        Scanner s = new Scanner(System.in);
        Songs[] songs = new Songs[5];
        for(int i=0; i<songs.length; i++){
            songName = s.nextLine();
            duration = s.nextInt();s.nextLine();
            artists = s.nextLine();
            language = s.nextLine();
            rating = s.nextDouble();s.nextLine();
            songs[i] = new Songs(songName, duration, artists, language, rating);
        }
        String newLanguage = s.nextLine();
        String newArtist = s.nextLine();
        s.close();
        String[] newSongs = findSongBasedOnLanguage(songs, newLanguage);
        if(newSongs == null)
            System.out.println("There are no songs with the given language");
        else
            for(String i: newSongs)
                System.out.println(i);
        Songs[] songs1 = findSongBasedOnArtists(songs, newArtist);
        if(songs1 == null)
            System.out.println("There are no songs with the given artists");
        else
            for(Songs song: songs1)
                System.out.println(song.getSongName()+"\n"+song.getRating());
    }
    public static String[] findSongBasedOnLanguage(Songs[] songs, String language){
        List<String> newList = new ArrayList<>();
        for(Songs song : songs){
            if(song.getLanguage().equalsIgnoreCase(language))
                newList.add(song.getSongName());
        }
        if(newList.size() == 0) return null;
        Collections.sort(newList, Comparator.reverseOrder());
        String[] arr = newList.toArray(new String[newList.size()]);
        return arr;
    }
    public static Songs[] findSongBasedOnArtists(Songs[] songs, String artist){
        List<Songs> newList = new ArrayList<>();
        for(Songs song : songs){
            if(song.getArtists().equalsIgnoreCase(artist))
                newList.add(song);
        }
        if(newList.size() == 0) return null;
        Collections.sort(newList, new Sort());
        Songs[] arr = newList.toArray(new Songs[newList.size()]);
        return arr;
    }
}
class Sort implements Comparator<Songs>{
    public int compare(Songs obj1, Songs obj2){
        return (int)(obj1.getRating() - obj2.getRating());
    }
}
class Songs{
    private String songName;
    private int duration;
    private String artists;
    private String language;
    private double rating;
    public Songs(String songName, int duration, String artists, String language, double rating){
        this.songName = songName;
        this.duration = duration;
        this.artists = artists;
        this.language = language;
        this.rating = rating;
    }
    public String getSongName() {
        return songName;
    }
    public int getDuration() {
        return duration;
    }
    public String getArtists() {
        return artists;
    }
    public String getLanguage() {
        return language;
    }
    public double getRating() {
        return rating;
    }
}
