package com.codes.practice.DesignPatterns.Structral;

// This acts as an interface for every Song (Leaf)
// and SongGroup (Composite) we create
import java.util.ArrayList;
import java.util.Iterator;

// allow clients to operate in generic manner on objects
// that may or may not represent a hierarchy of objects
//
// In main(), use the same abstract methods for different objects
abstract class SongComponent {

    // We throw UnsupportedOperationException so that if
    // it doesn't make sense for a song, or song group
    // to inherit a method they can just inherit the
    // default implementation

    // add components
    public void add(SongComponent newSongComponent) {
        throw new UnsupportedOperationException();
    }

    // remove components
    public void remove(SongComponent newSongComponent) {
        throw new UnsupportedOperationException();
    }

    // get components
    public SongComponent getComponent(int componentIndex) {
        throw new UnsupportedOperationException();
    }

    // retrieve song names
    public String getSongName() {
        throw new UnsupportedOperationException();
    }

    // retrieve band names
    public String getBandName() {
        throw new UnsupportedOperationException();
    }

    // retrieve release year
    public int getReleaseYear() {
        throw new UnsupportedOperationException();
    }

    // When this is called by a class object that extends
    // SongComponent it will print out information
    // specific to the Song or SongGroup
    public void displaySongInfo() {
        throw new UnsupportedOperationException();
    }
}

class SongGroup extends SongComponent {

    // Contains any Songs or SongGroups that are added
    // to this ArrayList
    // noticed that no type specified for the ArrayList
    ArrayList songComponents = new ArrayList();

    String groupName;
    String groupDescription;

    public SongGroup(String newGroupName, String newGroupDescription){
        groupName = newGroupName;
        groupDescription = newGroupDescription;
    }

    public String getGroupName() { return groupName; }
    public String getGroupDescription() { return groupDescription; }

    // override Abstract method
    public void add(SongComponent newSongComponent) {
        songComponents.add(newSongComponent);
    }

    // override Abstract method
    public void remove(SongComponent newSongComponent) {
        songComponents.remove(newSongComponent);
    }

    // override Abstract method
    public SongComponent getComponent(int componentIndex) {
        return (SongComponent)songComponents.get(componentIndex);
    }

    public void displaySongInfo(){

        System.out.println(getGroupName() + " " +
                getGroupDescription() + "\n");

        // Cycles through and prints any Songs or SongGroups added
        // to this SongGroups ArrayList songComponents
        Iterator songIterator = songComponents.iterator();
        while(songIterator.hasNext()) {
            SongComponent songInfo = (SongComponent) songIterator.next();
            songInfo.displaySongInfo();
        }
    }
}

class Song extends SongComponent {

    String songName;
    String bandName;
    int releaseYear;

    public Song(String newSongName, String newBandName, int newReleaseYear){
        songName = newSongName;
        bandName = newBandName;
        releaseYear = newReleaseYear;
    }

    public String getSongName() { return songName; }
    public String getBandName() { return bandName; }
    public int getReleaseYear() { return releaseYear; }

    public void displaySongInfo(){
        System.out.println(getSongName() + " was recorded by " +
                getBandName() + " in " + getReleaseYear());
    }
}


class DiscJockey{

    SongComponent songList;

    // newSongList contains every Song, SongGroup,
    // and any Songs saved in SongGroups
    public DiscJockey(SongComponent newSongList){
        songList = newSongList;
    }

    // Calls the displaySongInfo() on every Song
    // or SongGroup stored in songList
    public void getSongList(){
        songList.displaySongInfo();
    }
}

public class CompositeDemo1 {

    public static void main(String[] args){

        SongComponent industrialMusic =
                new SongGroup("Industrial",
                        "is a style of experimental music that draws on transgressive and provocative themes");

        SongComponent heavyMetalMusic =
                new SongGroup("\nHeavy Metal",
                        "is a genre of rock that developed in the late 1960s, largely in the UK and in the US");

        SongComponent dubstepMusic =
                new SongGroup("\nDubstep",
                        "is a genre of electronic dance music that originated in South London, England");

        // Top level component that holds everything
        SongComponent everySong = new SongGroup("Song List", "Every Song Available");

        // Composite that holds individual groups of songs
        // This holds Songs plus a SongGroup with Songs
        everySong.add(industrialMusic);

        industrialMusic.add(new Song("Head Like a Hole", "NIN", 1990));
        industrialMusic.add(new Song("Headhunter", "Front 242", 1988));

        industrialMusic.add(dubstepMusic);

        dubstepMusic.add(new Song("Centipede", "Knife Party", 2012));
        dubstepMusic.add(new Song("Tetris", "Doctor P", 2011));

        // This is a SongGroup that just holds Songs
        everySong.add(heavyMetalMusic);
// non overrite method call (throw an exception as from original abstract class
//        everySong.getReleaseYear();  // overrited on Song level only

        heavyMetalMusic.add(new Song("War Pigs", "Black Sabath", 1970));
        heavyMetalMusic.add(new Song("Ace of Spades", "Motorhead", 1980));

        DiscJockey crazyLarry = new DiscJockey(everySong);
        crazyLarry.getSongList();
    }
}
