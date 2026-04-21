package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.*;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("-------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("-------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("-------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("-------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("-------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("-------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("-------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("-------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void main(String[] args) {
        // Khởi tạo một số media mẫu trong store
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new Book(1, "Effective Java", "Education", 35.5f));
        CompactDisc cd = new CompactDisc(2, "Top Hits", "Music", 20.0f, 0, "Producer", "Artist B");
        cd.addTrack(new Track("Track A", 150));
        cd.addTrack(new Track("Track B", 210));
        store.addMedia(cd);

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // bỏ qua newline
            switch (choice) {
                case 1:
                    store.printStore();
                    storeMenu();
                    break;
                case 2:
                    System.out.println("Enter title to add to store:");
                    String newTitle = scanner.nextLine();
                    // Ví dụ thêm Book mới
                    store.addMedia(new Book(3, newTitle, "Unknown", 10.0f));
                    break;
                case 3:
                    cart.print();
                    cartMenu();
                    break;
                case 0:
                    System.out.println("Exiting AIMS...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}