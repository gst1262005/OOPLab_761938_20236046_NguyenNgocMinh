package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import javax.swing.*;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame {

    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        setTitle("AIMS Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ================= NORTH =================
    public JPanel createNorth() {
        JPanel north = new JPanel(new BorderLayout());
        north.add(createMenuBar(), BorderLayout.NORTH);
        north.add(createHeader(), BorderLayout.CENTER);
        return north;
    }

    public JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");

        addBook.addActionListener(e -> {
            new AddBookToStoreScreen(store);
            dispose();
        });

        addCD.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store);
            dispose();
        });

        addDVD.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store);
            dispose();
        });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    public JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        header.setBackground(new Color(230, 230, 250)); // nền tím nhạt

        JLabel title = new JLabel("AIMS Store");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(new Color(70, 70, 120));

        header.add(Box.createHorizontalGlue());
        header.add(title);
        header.add(Box.createHorizontalGlue());

        return header;
    }

    // ================= CENTER =================
    public JPanel createCenter() {
        // Panel chính chứa nhiều hàng
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBackground(new Color(245, 245, 245));

        int itemsPerRow = 3; // số sản phẩm mỗi hàng
        java.util.List<hust.soict.hedspi.aims.media.Media> items = store.getItemsInStore();

        for (int i = 0; i < items.size(); i += itemsPerRow) {
            // Tạo một hàng
            JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
            row.setOpaque(false);

            for (int j = i; j < i + itemsPerRow && j < items.size(); j++) {
                MediaStore cell = new MediaStore(items.get(j));
                cell.setPreferredSize(new Dimension(250, 150)); // kích thước card
                row.add(cell);
            }

            center.add(row);
        }

        // Bọc trong JScrollPane để cuộn dọc
        JScrollPane scrollPane = new JScrollPane(center,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(scrollPane, BorderLayout.CENTER);

        return wrapper;
    }
    // ================= MAIN =================
    public static void main(String[] args) {
        Store store = new Store();

        // Sách
        store.addMedia(new hust.soict.hedspi.aims.media.Book(1, "Java Programming", "Programming", 20.5f));
        store.addMedia(new hust.soict.hedspi.aims.media.Book(2, "Clean Code", "Software Engineering", 30.0f));
        store.addMedia(new hust.soict.hedspi.aims.media.Book(3, "Design Patterns", "Architecture", 28.5f));
        store.addMedia(new hust.soict.hedspi.aims.media.Book(4, "Effective Java", "Programming", 32.0f));
        store.addMedia(new hust.soict.hedspi.aims.media.Book(5, "Refactoring", "Software Engineering", 27.5f));

        // DVD
        store.addMedia(new hust.soict.hedspi.aims.media.DigitalVideoDisc(6, "Avengers", "Movie", "Marvel Studio", 120, 25.0f));
        store.addMedia(new hust.soict.hedspi.aims.media.DigitalVideoDisc(7, "Inception", "Movie", "Warner Bros", 148, 22.0f));
        store.addMedia(new hust.soict.hedspi.aims.media.DigitalVideoDisc(8, "Interstellar", "Movie", "Paramount", 169, 26.0f));
        store.addMedia(new hust.soict.hedspi.aims.media.DigitalVideoDisc(9, "The Matrix", "Movie", "Warner Bros", 136, 24.0f));

        // CD với track
        hust.soict.hedspi.aims.media.CompactDisc cd1 =
            new hust.soict.hedspi.aims.media.CompactDisc(10, "Greatest Hits", "Music", 15.0f, 60, "Producer A", "Artist X");
        cd1.addTrack(new hust.soict.hedspi.aims.media.Track("Song One", 4));
        cd1.addTrack(new hust.soict.hedspi.aims.media.Track("Song Two", 5));
        store.addMedia(cd1);

        hust.soict.hedspi.aims.media.CompactDisc cd2 =
            new hust.soict.hedspi.aims.media.CompactDisc(11, "Rock Classics", "Music", 18.0f, 70, "Producer B", "Artist Y");
        cd2.addTrack(new hust.soict.hedspi.aims.media.Track("Bohemian Rhapsody", 6));
        cd2.addTrack(new hust.soict.hedspi.aims.media.Track("Hotel California", 7));
        store.addMedia(cd2);

        new StoreManagerScreen(store);
    }
}