package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " has been added.");
        } else {
            System.out.println("Track " + track.getTitle() + " already exists.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Track " + track.getTitle() + " has been removed.");
        } else {
            System.out.println("Track " + track.getTitle() + " not found.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CD - " + getTitle() + " - " + getCost() + "\n");
        for (Track track : tracks) {
            sb.append("   ").append(track.toString()).append("\n");
        }
        return sb.toString();
    }
    // Phương thức play
    public void play() {
        if (getLength() <= 0) {
            System.out.println("This CD cannot be played.");
            return;
        }
        System.out.println("Playing CD: " + getTitle() + " - Length: " + getLength());
        for (Track track : tracks) {
            if (track.getLength() > 0) {
                System.out.println("Playing track: " + track.getTitle() + " - " + track.getLength());
            } else {
                System.out.println("Track " + track.getTitle() + " cannot be played.");
            }
        }
    }
}