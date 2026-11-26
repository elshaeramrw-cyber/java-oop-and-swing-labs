import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CounterMouseApp extends JFrame implements ActionListener {
    // Data fields
    private int counter = 0;
    private JLabel counterLabel = new JLabel("0");
    private JLabel mouseLabel = new JLabel("Mouse information");
    private JButton incrementButton = new JButton("Increment");
    private JButton decrementButton = new JButton("Decrement");
    private JButton resetButton = new JButton("Reset");
    private JPanel mousePanel = new JPanel();
    private Color originalColor;

    /** Construct the frame and set up the components */
    public CounterMouseApp() {
        setTitle("Counter and Mouse Events");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Counter label and buttons
        add(new JLabel("Counter:"));
        add(counterLabel);
        add(incrementButton);
        add(decrementButton);
        add(resetButton);

        // Mouse panel
        mousePanel.setPreferredSize(new Dimension(300, 150));
        mousePanel.setBackground(Color.LIGHT_GRAY);
        originalColor = mousePanel.getBackground();
        add(mousePanel);

        // Mouse information label
        add(mouseLabel);

        // Part A: Handle button events
        incrementButton.addActionListener(this);
        decrementButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Part B: Handle mouse events
        mousePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mousePanel.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mousePanel.setBackground(originalColor);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                mouseLabel.setText("Clicked at (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mouseLabel.setText("Mouse Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mouseLabel.setText("Mouse Released");
            }
        });

        setSize(450, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /** Handle button-click events */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == incrementButton) {
            counter++;
        } else if (e.getSource() == decrementButton) {
            counter--;
        } else if (e.getSource() == resetButton) {
            counter = 0;
        }

        counterLabel.setText(String.valueOf(counter));
    }

    /** Main method */
    public static void main(String[] args) {
        new CounterMouseApp();
    }
}