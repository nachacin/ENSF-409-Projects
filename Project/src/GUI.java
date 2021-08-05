import java.awt.*;
import javax.swing.*;



public class GUI {

    public GUI() {
        JFrame frame = new JFrame();
        JTextArea textArea = new JTextArea(20,60);
        JTextField mainText = new JTextField("An Application to Maintain Student Records");
        JButton button1 = new JButton("Insert");
        JButton button2 = new JButton("Find");
        JButton button3 = new JButton("Browse");
        JButton button4 = new JButton("Create Tree from File");
        JPanel panel = new JPanel();
        JScrollPane scroll = new JScrollPane(textArea);
        JPanel subPanel = new JPanel();
        
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,10));
        mainText.setHorizontalAlignment(JTextField.CENTER);
        mainText.setEditable(false);
        
                
        
        
        
        button1.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);
        button4.setFocusable(false);

        subPanel.add(button1);
        subPanel.add(button2);
        subPanel.add(button3);
        subPanel.add(button4);
        panel.add(subPanel, BorderLayout.CENTER);
        
        

        frame.add(mainText, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Window");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new GUI();
    }
}
