package hust.soict.hedspi.test.polymorphism;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<>();

        // Tạo DVD
        DigitalVideoDisc dvd = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        // Tạo Book
        Book book = new Book(1, "Effective Java", "Education", 35.5f);
        book.addAuthor("Joshua Bloch");

        // Tạo CD
        CompactDisc cd = new CompactDisc(2, "Top Hits", "Music", 20.0f, 0, "Producer", "Artist B");
        cd.addTrack(new Track("Track A", 150));
        cd.addTrack(new Track("Track B", 210));

        // Thêm vào danh sách
        mediaList.add(dvd);
        mediaList.add(book);
        mediaList.add(cd);

        // In thông tin từng media
        System.out.println("*************** MEDIA LIST ***************");
        for (Media m : mediaList) {
            System.out.println(m.toString());
        }
    }
}