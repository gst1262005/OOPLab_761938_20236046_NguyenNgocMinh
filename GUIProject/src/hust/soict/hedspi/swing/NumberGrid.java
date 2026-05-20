package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        // Tạo ô hiển thị
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        // Tạo panel chứa các nút số và chức năng
        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        // Sắp xếp layout
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200, 200);
        setVisible(true);
    }

    private void addButtons(JPanel panel) {
        ButtonListener btnListener = new ButtonListener();

        // Thêm các nút số 1–9
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panel.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        // Nút Delete
        btnDelete = new JButton("DEL");
        panel.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        // Nút số 0
        btnNumbers[0] = new JButton("0");
        panel.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        // Nút Reset
        btnReset = new JButton("C");
        panel.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + button);
            } else if (button.equals("DEL")) {
                String text = tfDisplay.getText();
                if (text.length() > 0) {
                    tfDisplay.setText(text.substring(0, text.length() - 1));
                }
            } else if (button.equals("C")) {
                tfDisplay.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}