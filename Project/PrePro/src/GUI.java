import java.awt.*;
import javax.swing.*;


import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;



public class GUI {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7; 
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private BinSearchTree tree;
    private JFrame mainFrame;
    private JFrame insertFrame;
    private JFrame createTreeFrame;
    private JFrame browseFrame;
    private JFrame findFrame;
    private JTextArea inputText;
    private JTextArea findArea;
    private JTextArea stuID;
    private JTextArea facu;
    private JTextArea major;
    private JTextArea year;


    public GUI() {
        mainFrame = new JFrame();
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

        
        

        mainFrame.add(mainText, BorderLayout.NORTH);
        mainFrame.add(scroll, BorderLayout.CENTER);
        mainFrame.add(panel, BorderLayout.PAGE_END);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Main Window");
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new GUI();
    }


    private ActionListener actions = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                mainFrame.setVisible(false);
                insertButton();
                
            }
                
            if(e.getSource() == button2) {
                mainFrame.setVisible(false);
                findStudent();
            }
            if(e.getSource() == button3){
                mainFrame.setVisible(false);
                browseTree();
            }
            if(e.getSource() == button4) {
                mainFrame.setVisible(false);
                getTree();
            }   
            if(e.getSource() == button5){
                tree.insert(stuID.getText(), facu.getText(), major.getText(), year.getText());
                insertFrame.setVisible(false);
                mainFrame.setVisible(true);
            }
            if(e.getSource() == button6){
                insertFrame.setVisible(false);
                mainFrame.setVisible(true);
            }
            if(e.getSource() == button7) {
                createTreeFrame.setVisible(false);
                mainFrame.setVisible(true);
            }
            if(e.getSource() == button8){
                tree = inputReader.fillTree(".\\database\\" + inputText.getText());
                createTreeFrame.setVisible(false);
                mainFrame.setVisible(true);
            }
            if(e.getSource() == button9) {
                findFrame.setVisible(false);
                mainFrame.setVisible(true);
            }
            if(e.getSource() == button10) {
                JOptionPane.showMessageDialog(findFrame, tree.find(tree.root, findArea.getText()));

            }
        }

        

    };



    public void findStudent() {
        findFrame = new JFrame();
        JPanel findPanel = new JPanel();
        JPanel subPanel = new JPanel();
        findArea = new JTextArea(1,10);
        JLabel findLabel = new JLabel("Please enter the student's id");
        button9 = new JButton("Cancel");
        button10 = new JButton("OK");

        findPanel.setLayout(new GridLayout(0,1));
        findPanel.add(findLabel, BorderLayout.BEFORE_LINE_BEGINS);
        findPanel.add(findArea, BorderLayout.CENTER);
        subPanel.add(button9);
        subPanel.add(button10);
        findPanel.add(subPanel);

        button9.addActionListener(actions);
        button10.addActionListener(actions);

        findFrame.setTitle("Input");
        findFrame.add(findPanel, BorderLayout.CENTER);
        findFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        findFrame.setTitle("Main Window");
        findFrame.pack();
        findFrame.setVisible(true);
        
    }

    public void browseTree() {
        browseFrame = new JFrame();
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

        
        try {
            StringWriter buffer = new StringWriter();
            PrintWriter writer = new PrintWriter(buffer);
            tree.print_tree(tree.root, writer);

            String contents = buffer.toString();
            textArea.setText(contents);

        } catch (IOException e) {
            e.printStackTrace();
        }

        browseFrame.add(mainText, BorderLayout.NORTH);
        browseFrame.add(scroll, BorderLayout.CENTER);
        browseFrame.add(panel, BorderLayout.PAGE_END);
        browseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        browseFrame.setTitle("Main Window");
        browseFrame.pack();
        browseFrame.setVisible(true);
    }

    public void getTree() {
        createTreeFrame = new JFrame();
        JPanel inputPanel = new JPanel();
        JPanel subPanel = new JPanel();
        inputText = new JTextArea(1,10);
        JLabel inputLabel = new JLabel("Enter the file name:");
        JButton button7 = new JButton("Cancel");
        button8 = new JButton("OK");

        inputPanel.setLayout(new GridLayout(0,1));
        subPanel.setLayout(new FlowLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 10));
        inputText.setBorder(BorderFactory.createLoweredBevelBorder());

        inputPanel.add(inputLabel, BorderLayout.BEFORE_LINE_BEGINS);
        inputPanel.add(inputText, BorderLayout.CENTER);
        subPanel.add(button7);
        subPanel.add(button8);
        inputPanel.add(subPanel);

        button7.addActionListener(actions);
        button8.addActionListener(actions);
        

        
        


        
        
        createTreeFrame.add(inputPanel, BorderLayout.CENTER);
        createTreeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createTreeFrame.pack();
        createTreeFrame.setVisible(true);

        
    }

    public void insertButton() {
        insertFrame = new JFrame();
        JPanel insertPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        JPanel subPanel1 = new JPanel();
        JPanel subPanel2 = new JPanel();

        JTextField insertNode = new JTextField("Insert a New Node");

        JLabel studentIDLabel = new JLabel("Enter the Student ID ");
        stuID = new JTextArea(1,5);
        JLabel facultyLabel = new JLabel("Enter Faculty ");
        facu = new JTextArea(1,10);
        JLabel majorLabel = new JLabel("Enter Student's Major ");
        major = new JTextArea(1,20);
        JLabel yearLabel = new JLabel("Enter year ");
        year = new JTextArea(1,8);
        button5 = new JButton("Insert");
        button6 = new JButton("Return to Main Window");
        
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
        button5.addActionListener(actions);
        button6.addActionListener(actions);


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

