package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Tạo DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        // Tạo Book
        Book book1 = new Book(2, "Effective Java", "Education", 35.5f);
        book1.addAuthor("Joshua Bloch");

        // Tạo CD
        CompactDisc cd1 = new CompactDisc(3, "Top Hits", "Music", 20.0f, 0, "Producer", "Artist B");
        cd1.addTrack(new Track("Track A", 150));
        cd1.addTrack(new Track("Track B", 210));

        // Thêm vào store
        store.addMedia(dvd1);
        store.addMedia(book1);
        store.addMedia(cd1);

        // In store
        store.printStore();

        // Xóa media
        store.removeMedia(book1);
        store.printStore();
    }
}