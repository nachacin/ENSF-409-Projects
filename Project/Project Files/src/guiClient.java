import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class guiClient {
    private Dimension buttonDimension = new Dimension(3,10);
    private JButton browse;
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JTextField welcomeText;

    public guiClient() {
        mainFrame = new JFrame();
        mainPanel = new JPanel();
        welcomeText = new JTextField("Welcome to your course registration!");
        browse = new JButton("Browse");

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 10));
        welcomeText.setBorder(BorderFactory.createEmptyBorder());
        welcomeText.setHorizontalAlignment(JTextField.CENTER);
        welcomeText.setEditable(false);
        browse.setSize(buttonDimension);
        browse.setFocusable(false);


        browse.addActionListener(actions);


        mainPanel.add(welcomeText, BorderLayout.NORTH);
        mainPanel.add(browse, BorderLayout.SOUTH);
        mainPanel.setPreferredSize(new Dimension(200,100));
        mainFrame.setContentPane(mainPanel);
        mainFrame.setSize(350,200);
        mainFrame.setMinimumSize(new Dimension(350,200));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Main Window");
        mainFrame.pack();
        mainFrame.setVisible(true);

    }

    public static void main(String[] args) {
        new guiClient();
    }

    private ActionListener actions = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == browse){
                JOptionPane.showMessageDialog(mainFrame, "The backend has not been developed yet, please return later to view the courses.");
            }

        }

    };
}