import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class GUI {

    private JButton button1;
    private JButton button2;
    JButton button3;
    JButton button4;


    public GUI() {
        JFrame frame = new JFrame();
        JTextArea textArea = new JTextArea(20,60);
        JTextField mainText = new JTextField("An Application to Maintain Student Records");
        button1 = new JButton("Insert");
        button2 = new JButton("Find");
        button3 = new JButton("Browse");
        button4 = new JButton("Create Tree from File");
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

        button1.addActionListener(actions);
        button2.addActionListener(actions);
        button3.addActionListener(actions);
        button4.addActionListener(actions);

        
        

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


    private ActionListener actions = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1)
                System.out.println("button 1 was pressed");
            if(e.getSource() == button2)
                System.out.println("button 2 was pressed");
            if(e.getSource() == button3)
                System.out.println("button 3 was pressed");
            if(e.getSource() == button4)    
                System.out.println("button 4 was pressed");
        }

    };
    

    
}
