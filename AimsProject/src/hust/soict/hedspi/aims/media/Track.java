package hust.soict.hedspi.aims.media;

public class Track extends Media implements Playable {
    private int length;

    public Track(String title, int length) {
        super(0, title, "Track", 0f); // gọi constructor Media với id=0, category="Track", cost=0
        this.length = length;
    }

    public int getLength() { return length; }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track other = (Track) obj;
            return this.getTitle().equalsIgnoreCase(other.getTitle()) && this.length == other.length;
        }
        return false;
    }

    @Override
    public void play() {
        if (length <= 0) {
            System.out.println("Track cannot be played.");
            return;
        }
        System.out.println("Playing track: " + getTitle() + " - Length: " + length);
    }

    @Override
    public String toString() {
        return "Track - " + getTitle() + " - " + length;
    }
}