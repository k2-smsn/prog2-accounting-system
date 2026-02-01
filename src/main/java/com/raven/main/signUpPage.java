package com.raven.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.miginfocom.swing.MigLayout;

public class signUpPage extends JFrame {

    private RoundedPanel card;

    public signUpPage() {
        setTitle("Sign Up");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Background panel
        BackgroundPanel backgroundPanel = new BackgroundPanel(
            "C:\\Users\\Admin\\Documents\\NetBeansProjects\\prog2-accounting-system\\src\\main\\java\\com\\raven\\icon\\background.jpg"
        );
        setContentPane(backgroundPanel);

        // Rounded card (semi-transparent)
        card = new RoundedPanel();
        card.setLayout(new MigLayout("wrap 1, gapy 15, align center", "[grow]", "[]"));
        card.setPreferredSize(new Dimension(400, 650));
        backgroundPanel.add(card, "center");

        // Title & subtitle
        JLabel title = new JLabel("Sign up");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        card.add(title, "align center, span");

        JLabel subtitle = new JLabel("Create your account");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        card.add(subtitle, "align center, span");

        // Load PNG icons
        Image userIcon = new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\prog2-accounting-system\\src\\main\\java\\com\\raven\\icon\\user.png").getImage();
        Image emailIcon = new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\prog2-accounting-system\\src\\main\\java\\com\\raven\\icon\\email.png").getImage();
        Image passwordIcon = new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\prog2-accounting-system\\src\\main\\java\\com\\raven\\icon\\key.png").getImage();
        Image eyeOpen = new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\prog2-accounting-system\\src\\main\\java\\com\\raven\\icon\\eyeOpen.png").getImage();
        Image eyeClosed = new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\prog2-accounting-system\\src\\main\\java\\com\\raven\\icon\\eyeClosed.png").getImage();

        // Input fields
        IconTextField firstNameField = new IconTextField("First Name", userIcon);
        card.add(firstNameField, "w 320!, h 40!, align center");

        IconTextField lastNameField = new IconTextField("Last Name", userIcon);
        card.add(lastNameField, "w 320!, h 40!, align center");

        IconTextField emailField = new IconTextField("Email", emailIcon);
        card.add(emailField, "w 320!, h 40!, align center");

        TogglePasswordField passwordField = new TogglePasswordField("Password", passwordIcon, eyeOpen, eyeClosed);
        card.add(passwordField, "w 320!, h 40!, align center");

        TogglePasswordField confirmPasswordField = new TogglePasswordField("Confirm Password", passwordIcon, eyeOpen, eyeClosed);
        card.add(confirmPasswordField, "w 320!, h 40!, align center");

        // Sign-up button
        RoundedButton signUpBtn = new RoundedButton("Sign up");
        signUpBtn.setBackground(new Color(33, 150, 243));
        signUpBtn.setForeground(Color.WHITE);
        signUpBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        card.add(signUpBtn, "w 320!, h 40!, align center");

        // Footer
        JLabel footer = new JLabel("Already have an account? Sign in");
        footer.setFont(new Font("Arial", Font.PLAIN, 12));
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        card.add(footer, "align center, span");

        setVisible(true);
    }

    // Rounded card panel
    class RoundedPanel extends JPanel {
        private int cornerRadius = 20;

        public RoundedPanel() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(255, 255, 255, 140));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
            g2.setColor(new Color(200, 200, 200, 120));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
            super.paintComponent(g);
            g2.dispose();
        }
    }

    // Background panel
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String filePath) {
            backgroundImage = new ImageIcon(filePath).getImage();
            setLayout(new MigLayout("fill, center", "[grow]", "[grow]"));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Text field with left icon and focus glow
    class IconTextField extends JTextField {
        private String placeholder;
        private Image icon;
        private int arc = 20;
        private int iconSize = 20;
        private int iconPadding = 10;
        private float iconOpacity = 1.0f;
        private boolean focused = false;

        public IconTextField(String placeholder, Image icon) {
            this.placeholder = placeholder;
            this.icon = icon;
            setBorder(null);
            setOpaque(false);
            setText("");
            setCaretColor(Color.BLACK);

            addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent e) { focused = true; repaint(); }
                public void focusLost(java.awt.event.FocusEvent e) { focused = false; repaint(); }
            });
        }

        @Override
        public Insets getInsets() {
            Insets defaultInsets = super.getInsets();
            int left = iconSize + iconPadding + 5;
            return new Insets(defaultInsets.top, left, defaultInsets.bottom, defaultInsets.right);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Background
            g2.setColor(new Color(255, 255, 255, 200));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);

            // Focus glow
            if (focused) {
                g2.setColor(new Color(33, 150, 243, 100));
                g2.setStroke(new BasicStroke(3));
                g2.drawRoundRect(1, 1, getWidth()-2, getHeight()-2, arc, arc);
            }

            g2.dispose();
            super.paintComponent(g);

            // Left icon
            if (icon != null) {
                Graphics2D g3 = (Graphics2D) g.create();
                g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g3.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, iconOpacity));
                g3.drawImage(icon, 10, (getHeight()-iconSize)/2, iconSize, iconSize, this);
                g3.dispose();
            }

            // Placeholder
            if (getText().isEmpty()) {
                Graphics2D g4 = (Graphics2D) g.create();
                g4.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g4.setColor(Color.GRAY);
                g4.setFont(getFont());
                g4.drawString(placeholder, iconSize + 10 + iconPadding, getHeight()/2 + g4.getFontMetrics().getAscent()/2 - 2);
                g4.dispose();
            }
        }
    }

    // Toggle password field with left icon, right eye, hover hand cursor
    class TogglePasswordField extends JPasswordField {
        private String placeholder;
        private Image leftIcon, eyeOpen, eyeClosed;
        private boolean showPassword = false;
        private int arc = 20;
        private int iconSize = 20;
        private int iconPadding = 10;
        private float iconOpacity = 1.0f;
        private boolean focused = false;

        public TogglePasswordField(String placeholder, Image leftIcon, Image eyeOpen, Image eyeClosed) {
            this.placeholder = placeholder;
            this.leftIcon = leftIcon;
            this.eyeOpen = eyeOpen;
            this.eyeClosed = eyeClosed;
            setBorder(null);
            setOpaque(false);
            setEchoChar('\u2022');
            setCaretColor(Color.BLACK);

            addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent e) { focused = true; repaint(); }
                public void focusLost(java.awt.event.FocusEvent e) { focused = false; repaint(); }
            });

            // Toggle password on click
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int x = e.getX();
                    if (x >= getWidth() - iconSize - iconPadding) {
                        showPassword = !showPassword;
                        setEchoChar(showPassword ? (char)0 : '\u2022');
                        repaint();
                    }
                }
            });

            // Cursor hand on hover over eye icon
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    int x = e.getX();
                    if (x >= getWidth() - iconSize - iconPadding) {
                        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    } else {
                        setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                    }
                }
            });
        }

        @Override
        public Insets getInsets() {
            Insets defaultInsets = super.getInsets();
            int left = iconSize + iconPadding + 5;
            int right = iconSize + iconPadding + 5;
            return new Insets(defaultInsets.top, left, defaultInsets.bottom, right);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Background
            g2.setColor(new Color(255, 255, 255, 200));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);

            // Focus glow
            if (focused) {
                g2.setColor(new Color(33, 150, 243, 100));
                g2.setStroke(new BasicStroke(3));
                g2.drawRoundRect(1, 1, getWidth()-2, getHeight()-2, arc, arc);
            }

            g2.dispose();
            super.paintComponent(g);

            // Left icon
            if (leftIcon != null) {
                Graphics2D g3 = (Graphics2D) g.create();
                g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g3.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, iconOpacity));
                g3.drawImage(leftIcon, 10, (getHeight()-iconSize)/2, iconSize, iconSize, this);
                g3.dispose();
            }

            // Placeholder
            if (getPassword().length == 0) {
                Graphics2D g4 = (Graphics2D) g.create();
                g4.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g4.setColor(Color.GRAY);
                g4.setFont(getFont());
                g4.drawString(placeholder, iconSize + 10 + iconPadding, getHeight()/2 + g4.getFontMetrics().getAscent()/2 - 2);
                g4.dispose();
            }

            // Right eye icon
            Image eyeIcon = showPassword ? eyeOpen : eyeClosed;
            if (eyeIcon != null) {
                Graphics2D g5 = (Graphics2D) g.create();
                g5.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g5.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, iconOpacity));
                g5.drawImage(eyeIcon, getWidth() - iconSize - iconPadding, (getHeight()-iconSize)/2, iconSize, iconSize, this);
                g5.dispose();
            }
        }
    }

    // Rounded button
    class RoundedButton extends JButton {
        private int arc = 20;
        public RoundedButton(String text) {
            super(text);
            setOpaque(false);
            setBorderPainted(false);
            setFocusPainted(false);
        }
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
            super.paintComponent(g);
            g2.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(signUpPage::new);
    }
}
