import java.awt.*;
import javax.swing.*;


import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;



public class GUI {

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JFrame frame;


    public GUI() {
        frame = new JFrame();
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

        // var aTree = inputReader.fillTree(".\\database\\input.txt");
        // try {
        //     aTree.print_tree(aTree.root, new PrintWriter(System.out));
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
    }


    private ActionListener actions = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                frame.setVisible(false);
                insertButton();
                
            }
                
            if(e.getSource() == button2)
                System.out.println("button 2 was pressed");
            if(e.getSource() == button3)
                System.out.println("button 3 was pressed");
            if(e.getSource() == button4)    
                System.out.println("button 4 was pressed");
        }

        

    };

    public void insertButton() {
        JFrame insertFrame = new JFrame();
        JPanel insertPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        JPanel subPanel1 = new JPanel();
        JPanel subPanel2 = new JPanel();

        JTextField insertNode = new JTextField("Insert a New Node");

        JLabel studentIDLabel = new JLabel("Enter the Student ID ");
        JTextArea stuID = new JTextArea(1,5);
        JLabel facultyLabel = new JLabel("Enter Faculty ");
        JTextArea facu = new JTextArea(1,10);
        JLabel majorLabel = new JLabel("Enter Student's Major ");
        JTextArea major = new JTextArea(1,20);
        JLabel yearLabel = new JLabel("Enter year ");
        JTextArea year = new JTextArea(1,8);
        JButton button5 = new JButton("Insert");
        JButton button6 = new JButton("Return to Main Window");
        
        insertNode.setHorizontalAlignment(JTextField.CENTER);
        insertNode.setEditable(false);

        subPanel1.setLayout(new FlowLayout());
        subPanel1.setBorder(BorderFactory.createEmptyBorder(30,30,10,10));

        subPanel2.setLayout(new FlowLayout());
        subPanel2.setBorder(BorderFactory.createEmptyBorder(30,30,10,10));



        stuID.setBorder(BorderFactory.createLoweredBevelBorder());
        facu.setBorder(BorderFactory.createLoweredBevelBorder());
        major.setBorder(BorderFactory.createLoweredBevelBorder());
        year.setBorder(BorderFactory.createLoweredBevelBorder());


        subPanel1.add(studentIDLabel);
        subPanel1.add(stuID);
        subPanel1.add(facultyLabel);
        subPanel1.add(facu);
        insertPanel.add(subPanel1);

        subPanel2.add(majorLabel);
        subPanel2.add(major);
        subPanel2.add(yearLabel);
        subPanel2.add(year);
        insertPanel.add(subPanel2);


        buttonsPanel.add(button5);
        buttonsPanel.add(button6);
        


        insertPanel.setLayout(new GridLayout(0,1));
        insertPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,10));

        buttonsPanel.setLayout(new GridLayout());
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        
        
        insertFrame.add(insertNode, BorderLayout.NORTH);
        //insertFrame.add(scroll, BorderLayout.CENTER);
        insertFrame.add(insertPanel, BorderLayout.CENTER);
        insertFrame.add(buttonsPanel, BorderLayout.SOUTH);
        insertFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        insertFrame.pack();
        insertFrame.setVisible(true);

    }
    

    
}
