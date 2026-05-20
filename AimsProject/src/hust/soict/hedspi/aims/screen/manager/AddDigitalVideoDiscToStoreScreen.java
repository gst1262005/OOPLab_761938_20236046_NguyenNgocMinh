package hust.soict.hedspi.aims.screen.manager;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen
        extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected void addItem() {

        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                0,
                title,
                category,
                "Unknown Director",
                120,
                cost);

        store.addMedia(dvd);

        JOptionPane.showMessageDialog(this,
                "Added DVD successfully!");
    }
}