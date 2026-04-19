package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Tạo DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        // Tạo Book
        Book book1 = new Book(1, "Java Programming", "Education", 29.99f);
        book1.addAuthor("James Gosling");

        // Tạo CD
        CompactDisc cd1 = new CompactDisc(2, "Greatest Hits", "Music", 15.0f, 0, "Producer", "Artist A");
        cd1.addTrack(new Track("Song 1", 180));
        cd1.addTrack(new Track("Song 2", 200));

        // Thêm vào giỏ
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(book1);
        cart.addMedia(cd1);

        // In giỏ hàng
        cart.print();

        // Tìm theo ID
        cart.searchById(dvd2.getId());

        // Tìm theo Title
        cart.searchByTitle("Java Programming");
        cart.searchByTitle("Unknown Title");

        // Tổng tiền
        System.out.println("Total cost: " + cart.totalCost() + " $");
    }
}