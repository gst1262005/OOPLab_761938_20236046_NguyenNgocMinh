package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import javax.swing.*;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        setBackground(Color.WHITE);

        JLabel title = new JLabel(media.getTitle(), JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $", JLabel.CENTER);
        cost.setForeground(new Color(200, 0, 0));
        cost.setFont(new Font("Arial", Font.PLAIN, 14));
        cost.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("▶ Play");
            btnPlay.addActionListener(e -> showPlayDialog());
            buttonPanel.add(btnPlay);
        }

        JButton btnAdd = new JButton("➕ Add to Cart");
        btnAdd.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                media.getTitle() + " has been added to the cart.",
                "Cart Update",
                JOptionPane.INFORMATION_MESSAGE);
        });
        
        buttonPanel.add(btnAdd);
        add(title);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(cost);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(buttonPanel);
    }

    private void showPlayDialog() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Playing Media");
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(null);

        JLabel message = new JLabel("Playing: " + media.getTitle(), JLabel.CENTER);
        message.setFont(new Font("Arial", Font.ITALIC, 16));

        dialog.add(message);
        dialog.setVisible(true);
    }
}