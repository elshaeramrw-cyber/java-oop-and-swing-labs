import javax.swing.*;
import java.awt.*;

public class Studentform {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Registration Form & Graphics");
        frame.setLayout(new BorderLayout(10, 10));
        frame.setSize(450, 310);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        
        JPanel northPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);      

                
                int rectX = 20;
                int rectY = 10;
                int rectW = getWidth() - 40;
                int rectH = 30;

               
                g.setColor(new Color(200, 220, 240));
                g.fillRect(rectX, rectY, rectW, rectH);

               
                g.setColor(Color.BLACK);
                g.drawRect(rectX, rectY, rectW, rectH);

              
                String title = "Student Information System";
                g.setFont(new Font("SansSerif", Font.BOLD, 16));

               
                FontMetrics fm = g.getFontMetrics();
                int textWidth  = fm.stringWidth(title);
                int x = rectX + (rectW - textWidth) / 2;              
                int y = rectY + (rectH + fm.getAscent()) / 2 - 2;     
                g.drawString(title, x, y);

               
                g.drawLine(x, y + 3, x + textWidth, y + 3);
            }
        };
        northPanel.setPreferredSize(new Dimension(450, 50));

   
        JPanel centerPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        centerPanel.add(new JLabel("Student ID:"));
        centerPanel.add(new JTextField());
        centerPanel.add(new JLabel("Full Name:"));
        centerPanel.add(new JTextField());
        centerPanel.add(new JLabel("Department:"));
        centerPanel.add(new JTextField());
        centerPanel.add(new JLabel("Email Address:"));
        centerPanel.add(new JTextField());

    
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        southPanel.add(new JButton("Save Record"));
        southPanel.add(new JButton("Clear Form"));

        frame.add(northPanel,  BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(southPanel,  BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}