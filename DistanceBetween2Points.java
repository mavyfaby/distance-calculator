import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.net.MalformedURLException;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * ---------------------------------
 * Author: Maverick G. Fabroa
 * ---------------------------------
 * Project: Distance Between 2 Points
 * ---------------------------------
 * Date: April 29, 2021
 * ---------------------------------
 */

public class DistanceBetween2Points {
    private static Dimension WIN_SIZE = new Dimension(1000, 562);
    private static boolean DARK_MODE = true;

    private static final Color DARK_COLOR = new Color(0xFF1C212E);
    private static final Color LIGHTFORE_COLOR = new Color(0xFF7A88A6);
    private static final Color FORE_COLOR = new Color(0xFF6F819D);
    private static final Color SUCCESS_COLOR = new Color(0xFF5EC479);
    private static final Color ERROR_COLOR = new Color(0xFFF08070);

    /**
     * The Distance Formula
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return The distance
     */
    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {    
        // Main frame
        JFrame frame = new JFrame();
        // Main panel
        JPanel panel = new JPanel(new BorderLayout());

        // Application Icon
        try {
            File iconFile  = new File(System.getProperty("user.dir") + "/icon.png");
            ImageIcon icon = new ImageIcon(iconFile.toURI().toURL());
    
            if (icon != null) {
                frame.setIconImage(icon.getImage());
            }
        }
            catch (MalformedURLException e) {
                System.out.println("Error: MalformedException has occured!");
            }

        frame.setMinimumSize(WIN_SIZE);
        frame.setSize(WIN_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Pythagorean Theorem by Maverick G. Fabroa");

        panel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        Border fieldBorder = BorderFactory.createEmptyBorder(8, 8, 8, 8);

        // ===== NORTH ===== //

        JPanel northPanel = new JPanel(new GridLayout(2, 1));

        JLabel title = new JLabel("Distance Between Two Points", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel subtitle = new JLabel("by Maverick G. Fabroa", SwingConstants.CENTER);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));

        northPanel.add(title);
        northPanel.add(subtitle);

        // ===== CENTER ===== //

        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel panel1 = new JPanel(new GridBagLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        
        JLabel x1Label = new JLabel("<html>x<sub>1</sub> = </html>");
        JLabel y1Label = new JLabel("<html>y<sub>1</sub> = </html>");
        JLabel x2Label = new JLabel("<html>x<sub>2</sub> = </html>");
        JLabel y2Label = new JLabel("<html>y<sub>2</sub> = </html>");

        JLabel answer = new JLabel("The answer will appear here");
        answer.setFont(new Font("Arial", Font.BOLD, 18));
        
        x1Label.setFont(new Font("Arial", Font.BOLD, 16));
        y1Label.setFont(new Font("Arial", Font.BOLD, 16));
        x2Label.setFont(new Font("Arial", Font.BOLD, 16));
        y2Label.setFont(new Font("Arial", Font.BOLD, 16));
        
        JTextField x1 = new JTextField(8);
        JTextField y1 = new JTextField(8);
        JTextField x2 = new JTextField(8);
        JTextField y2 = new JTextField(8);
        
        x1.setBorder(fieldBorder);
        y1.setBorder(fieldBorder);
        x2.setBorder(fieldBorder);
        y2.setBorder(fieldBorder);
        
        x1.setFont(new Font("Arial", Font.BOLD, 16));
        y1.setFont(new Font("Arial", Font.BOLD, 16));
        x2.setFont(new Font("Arial", Font.BOLD, 16));
        y2.setFont(new Font("Arial", Font.BOLD, 16));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 16, 0, 32);
        
        panel1.add(x1Label);
        panel1.add(x1, gbc);
        panel1.add(y1Label);
        panel1.add(y1, gbc);
        panel1.add(x2Label);
        panel1.add(x2, gbc);
        panel1.add(y2Label);
        panel1.add(y2, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 8;
        gbc.gridy = 1;
        gbc.insets = new Insets(50, 0, 0, 0);

        panel2.add(answer);
        panel1.add(panel2, gbc);

        centerPanel.add(panel1, BorderLayout.CENTER);

        // ===== SOUTH ===== //

        JPanel southPanel = new JPanel(new GridBagLayout());
        JButton calcButton = new JButton("Calculate");

        calcButton.setFont(new Font("Arial", Font.BOLD, 16));
        calcButton.setPreferredSize(new Dimension(150, 50));
        calcButton.setForeground(Color.BLACK);
        calcButton.setBackground(Color.WHITE);
        calcButton.setFocusPainted(false);
        calcButton.setBorderPainted(false);
        calcButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        calcButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                final String rawX1 = x1.getText();
                final String rawY1 = y1.getText();
                final String rawX2 = x2.getText();
                final String rawY2 = y2.getText();

                if (rawX1.length() != 0 && rawY1.length() != 0 && rawX2.length() != 0 && rawY2.length() != 0) {
                    try {
                        final double pX1 = Double.parseDouble(rawX1);
                        final double pY1 = Double.parseDouble(rawY1);
                        final double pX2 = Double.parseDouble(rawX2);
                        final double pY2 = Double.parseDouble(rawY2);
    
                        answer.setText("d = " + String.valueOf(calculateDistance(pX1, pY1, pX2, pY2)));
                        answer.setForeground(SUCCESS_COLOR);
                    }  
                        catch (Exception e) {
                            answer.setText("Only numbers allowed to be calculated.");
                            answer.setForeground(ERROR_COLOR);
                        }
                }
                    else {
                        answer.setText("Please fill all the empty fields.");
                        answer.setForeground(ERROR_COLOR);
                    }
            }
        });
        
        if (DARK_MODE) {
            panel.setBackground(DARK_COLOR);
            panel1.setBackground(DARK_COLOR);
            panel2.setBackground(DARK_COLOR);
            northPanel.setBackground(DARK_COLOR);
            centerPanel.setBackground(DARK_COLOR);
            southPanel.setBackground(DARK_COLOR);
            
            title.setForeground(LIGHTFORE_COLOR);
            subtitle.setForeground(LIGHTFORE_COLOR);
            answer.setForeground(LIGHTFORE_COLOR);
            x1Label.setForeground(FORE_COLOR);
            y1Label.setForeground(FORE_COLOR);
            x2Label.setForeground(FORE_COLOR);
            y2Label.setForeground(FORE_COLOR);
            
            x1.setBackground(LIGHTFORE_COLOR);
            x2.setBackground(LIGHTFORE_COLOR);
            y1.setBackground(LIGHTFORE_COLOR);
            y2.setBackground(LIGHTFORE_COLOR);
            
            x1.setForeground(DARK_COLOR);
            y1.setForeground(DARK_COLOR);
            x2.setForeground(DARK_COLOR);
            y2.setForeground(DARK_COLOR);

            calcButton.setForeground(DARK_COLOR);
            calcButton.setBackground(FORE_COLOR);
        }

        southPanel.add(calcButton);
    
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(southPanel, BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}