/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package meeeeeeeeeeeeee.sdap;

/**
 *
 * @author RC
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.AbstractBorder;

public class HomePage extends JFrame {

    public HomePage() {
        // Setting up the frame
        setTitle("Home - Premium FITNESS ");
        setSize(1500, 700); // Increased size for better visibility
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true); // Allow resizing

        // Main panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.RED);
        add(panel);

        // Header panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(0xF98866)); // green
        panel.add(headerPanel, BorderLayout.NORTH);

        // Logo (scaled down with rounded border)
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\RC\\Desktop\\E-project\\E-project/logo.png"); // Replace with your logo path
        Image scaledLogo = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Adjust size as needed
        ImageIcon scaledIcon = new ImageIcon(scaledLogo);
        JLabel logoLabel = new JLabel(scaledIcon);
        logoLabel.setBorder(new RoundBorder(100)); // Circular border with radius 100 pixels
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around the logo
        headerPanel.add(logoLabel, BorderLayout.WEST);

        // Header label (Black text color)
        JLabel headerLabel = new JLabel("HOME - PREMIUM FITNESS GYM", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 54)); // Larger font size
        headerLabel.setForeground(Color.BLACK); // Text color changed to black
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        // Center panel for options
        JPanel centerPanel = new JPanel(new GridLayout(2, 3, 20, 20)); // Grid layout for options
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around the grid
        panel.add(centerPanel, BorderLayout.CENTER);

        // Add Member option
        JPanel addMemberPanel = createOptionPanel("Add Member", "C:\\Users\\RC\\Downloads\\addmember.png");
        addMemberPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openAddMemberFrame();
            }
        });
        centerPanel.add(addMemberPanel);

        // Add Trainer option
        JPanel addTrainerPanel = createOptionPanel("Add Trainer", "C:\\Users\\RC\\Downloads\\addtrainer.png");
        addTrainerPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openAddTrainerFrame();
            }
        });
        centerPanel.add(addTrainerPanel);

        // Enroll Membership option
        JPanel enrollMembershipPanel = createOptionPanel("Enroll Membership", "C:\\Users\\RC\\Downloads\\enrollMembership.png");
        enrollMembershipPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openEnrollMembershipFrame();
            }
        });
        centerPanel.add(enrollMembershipPanel);

        // Add Service option
        JPanel addServicePanel = createOptionPanel("Add Service", "C:\\Users\\RC\\Downloads\\addservice.png");
        addServicePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openAddServiceFrame();
            }
        });
        centerPanel.add(addServicePanel);

        // Update Member option (previously Buy Product)
        JPanel updateMemberPanel = createOptionPanel("Update Member", "C:\\Users\\RC\\Downloads\\updatemembers.png");
        updateMemberPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openUpdateMemberFrame();
            }
        });
        centerPanel.add(updateMemberPanel);

        // Pricing option
        JPanel pricingPanel = createOptionPanel("Pricing", "C:\\Users\\RC\\Downloads\\pricing.png");
        pricingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openPricingFrame();
            }
        });
        centerPanel.add(pricingPanel);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(0xA1BE95)); // Pastel olive green
        backButton.setForeground(Color.WHITE); // Text color
        backButton.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement back functionality
                // For now, just close the homepage
                dispose();
            }
        });
        panel.add(backButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createOptionPanel(String title, String imagePath) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around the panel

        // Image label
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Scale the image
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(imageLabel, BorderLayout.CENTER);

        // Title label
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0x4D4D4D)); // Dark gray
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Padding above the title
        panel.add(titleLabel, BorderLayout.SOUTH);

        // Adding zoom-out effect on hover
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Image scaledImage = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH); // Zoom out size
                imageLabel.setIcon(new ImageIcon(scaledImage));
                panel.revalidate();
                panel.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Image scaledImage = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH); // Original size
                imageLabel.setIcon(new ImageIcon(scaledImage));
                panel.revalidate();
                panel.repaint();
            }
        });

        return panel;
    }

    private void openAddMemberFrame() {
        new AddMemberFrame().setVisible(true);
        dispose(); // Close the current frame
    }

    private void openAddTrainerFrame() {
        new AddTrainerFrame().setVisible(true);
        dispose(); // Close the current frame
    }

    private void openEnrollMembershipFrame() {
        new EnrollMembershipFrame().setVisible(true);
        dispose(); // Close the current frame
    }

    private void openAddServiceFrame() {
        new AddServiceFrame().setVisible(true);
        dispose(); // Close the current frame
    }

    private void openUpdateMemberFrame() {
        new UpdateMemberFrame().setVisible(true);
        dispose(); // Close the current frame
    }

    private void openPricingFrame() {
        new PricingFrame().setVisible(true);
        dispose(); // Close the current frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomePage();
            }
        });
    }

    // Custom border class for circular borders
    private static class RoundBorder extends AbstractBorder {
        private int radius;

        public RoundBorder(int radius) {
            this.radius = radius;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(c.getBackground());
            g2d.fillOval(x, y, width - 1, height - 1);
            g2d.setColor(Color.BLACK);
            g2d.drawOval(x, y, width - 1, height - 1);
            g2d.dispose();
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = this.radius + 1;
            return insets;
        }
    }
}






