package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {

    protected Store store;

    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    public AddItemToStoreScreen(Store store) {

        this.store = store;

        setTitle("Add Item");
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(4, 2, 10, 10));

        // Title
        form.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        form.add(tfTitle);

        // Category
        form.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        form.add(tfCategory);

        // Cost
        form.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        form.add(tfCost);

        // Button
        JButton btnAdd = new JButton("Add");

        btnAdd.addActionListener(e -> {
            addItem();
        });

        form.add(btnAdd);

        add(form, BorderLayout.CENTER);

        setVisible(true);
    }

    // Hàm abstract cho class con tự cài đặt
    protected abstract void addItem();
}