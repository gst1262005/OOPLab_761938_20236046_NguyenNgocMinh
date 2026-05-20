package hust.soict.hedspi.aims.screen.manager;

import java.awt.GridLayout;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    // Field thêm cho CD
    private JTextField tfLength;
    private JTextField tfDirector;
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);

        // Lấy panel form từ content pane
        Container panel = (Container) getContentPane().getComponent(0);
        GridLayout layout = (GridLayout) panel.getLayout();

        // Tăng số dòng
        layout.setRows(7);

        // Length
        panel.add(new JLabel("Length:"));
        tfLength = new JTextField();
        panel.add(tfLength);

        // Director
        panel.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        panel.add(tfDirector);

        // Artist
        panel.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        panel.add(tfArtist);

        revalidate();
        repaint();
    }

    @Override
    protected void addItem() {
        try {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            int length = Integer.parseInt(tfLength.getText());
            String director = tfDirector.getText();
            String artist = tfArtist.getText();

            CompactDisc cd = new CompactDisc(
                    0,
                    title,
                    category,
                    cost,
                    length,
                    director,
                    artist);

            store.addMedia(cd);

            JOptionPane.showMessageDialog(this, "Added CD successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }
    }
}