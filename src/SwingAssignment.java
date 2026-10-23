
import javax.swing.*;
import java.awt.*;

public class SwingAssignment extends JFrame {

    JFrame frame;
    JPanel panel;
    JLabel label;
    JLabel nameLabel;

    public SwingAssignment() {

        frame = new JFrame("Java Swing Assignment");
        panel = new JPanel();

        // Set the background colour
        panel.setBackground(Color.YELLOW);

        // Arrange components vertically
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Image
        ImageIcon originalIcon = new ImageIcon("images/app-icon.png");
        JLabel imageLabel;

        if (originalIcon.getIconWidth() > 0) {
            Image scaledImage = originalIcon.getImage()
                    .getScaledInstance(240, 180, Image.SCALE_SMOOTH);

            imageLabel = new JLabel(new ImageIcon(scaledImage));
        } else {
            imageLabel = new JLabel("Your Image / Icon Here");
        }

        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Main heading
        label = new JLabel("Welcome to Java Swing Assignment");
        label.setFont(new Font("Arial", Font.BOLD, 44));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Your name
        nameLabel = new JLabel("By: Derick Valcarcel");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 34));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Change Text button
        JButton changeTextButton = new JButton("Change Text");
        changeTextButton.setFont(new Font("Arial", Font.PLAIN, 22));
        changeTextButton.setPreferredSize(new Dimension(290, 65));
        changeTextButton.addActionListener(e -> {
            String newText = JOptionPane.showInputDialog(
                    frame,
                    "Enter the text you want to display:",
                    "Change Text",
                    JOptionPane.PLAIN_MESSAGE
            );

            if (newText != null && !newText.trim().isEmpty()) {
                label.setText(newText);
            }
        });

        // Background buttons
        JButton blueButton = new JButton("Blue Background");
        JButton greenButton = new JButton("Green Background");
        JButton yellowButton = new JButton("Yellow Background");

        blueButton.setFont(new Font("Arial", Font.PLAIN, 22));
        greenButton.setFont(new Font("Arial", Font.PLAIN, 22));
        yellowButton.setFont(new Font("Arial", Font.PLAIN, 22));

        blueButton.setPreferredSize(new Dimension(290, 65));
        greenButton.setPreferredSize(new Dimension(340, 65));
        yellowButton.setPreferredSize(new Dimension(340, 65));

        blueButton.addActionListener(e -> panel.setBackground(Color.CYAN));
        greenButton.addActionListener(e -> panel.setBackground(Color.GREEN));
        yellowButton.addActionListener(e -> panel.setBackground(Color.YELLOW));

        // First row of buttons
        JPanel firstRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        firstRow.setOpaque(false);
        firstRow.add(changeTextButton);
        firstRow.add(blueButton);

        // Second row of buttons
        JPanel secondRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        secondRow.setOpaque(false);
        secondRow.add(greenButton);
        secondRow.add(yellowButton);

        // Add components in order
        panel.add(Box.createVerticalStrut(30));
        panel.add(imageLabel);
        panel.add(Box.createVerticalStrut(25));
        panel.add(label);
        panel.add(Box.createVerticalStrut(15));
        panel.add(nameLabel);
        panel.add(Box.createVerticalStrut(30));
        panel.add(firstRow);
        panel.add(secondRow);

        // Window settings
        frame.add(panel);
        frame.setSize(1100, 700);
        frame.setMinimumSize(new Dimension(900, 650));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingAssignment());
    }
}
