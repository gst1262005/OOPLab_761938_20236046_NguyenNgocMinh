package hust.soict.hedspi.aims.screen.manager;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected void addItem() {

        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());

        Book book = new Book(
                0,
                title,
                category,
                cost);

        store.addMedia(book);

        JOptionPane.showMessageDialog(this,
                "Added book successfully!");
    }
}