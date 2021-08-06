import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * Front-End menu that users interact with to select certain functions that 
 * include; creating a Binary Search Tree, browsing through the tree, finding
 * nodes within the tree, inserting additional nodes. This class also uses the
 * ActionListener class that reads the pressing of buttons, to allow users to 
 * manouver through the GUI.
 * 
 * @author Nasih Nazeem and Nestor Chacin
 * @since 2021 - 08 - 06
 * @version 1.0
 */
public class GUI {
    // Various data fields for I/O purposes.
    private BinSearchTree tree;
    private JTextField inputText;
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
    private JFrame mainFrame;
    private JFrame insertFrame;
    private JFrame createTreeFrame;
    private JFrame browseFrame;
    private JFrame findFrame;
    private JTextArea findArea;
    private JTextArea stuID;
    private JTextArea facu;
    private JTextArea major;
    private JTextArea year;



    /**
     * Creates default constructor that holds the {@code mainFrame} of the GUI, with options to move onto other windows.
     */
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
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    /**
     * Main method to create the initial GUI.
     * @param args Not used.
     */
    public static void main(String[] args) {
        new GUI();
    }

    /**
     * Created an {@code ActionListener} object using a lambda expression. This
     * holds all the ActionEvents that allow users to manouver through the
     * window.
     */
    private ActionListener actions = new ActionListener() {
        JFrame prev;
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
                if (prev != null) {
                    prev.setVisible(false);
                }
                mainFrame.setVisible(false);
                prev = browseTree();
            }
            if(e.getSource() == button4) {
                mainFrame.setVisible(false);
                getTree();
            }   
            if(e.getSource() == button5){
                if(prev != null) {
                    prev.setVisible(true);
                }
                tree.insert(stuID.getText(), facu.getText(), major.getText(), year.getText());
                insertFrame.setVisible(false);
            }
            if(e.getSource() == button6){
                if (prev == null) {
                    mainFrame.setVisible(true);
                }
                insertFrame.setVisible(false);
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
                if (prev == null) {
                    mainFrame.setVisible(true);
                }
                findFrame.setVisible(false);
            }
            if(e.getSource() == button10) {
                JOptionPane.showMessageDialog(findFrame, tree.find(tree.root, findArea.getText()));
            }


        }
    };


    /**
     * Creates a new {@code findFrame} JFrame that requires users to input a
     * student's id inside {@code findArea}. 
     */
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
        findArea.setBorder(BorderFactory.createLoweredBevelBorder());

        button9.addActionListener(actions);
        button10.addActionListener(actions);

        findFrame.setTitle("Input");
        findFrame.setPreferredSize(new Dimension(300,250));
        findFrame.add(findPanel, BorderLayout.CENTER);
        findFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        findFrame.setTitle("Main Window");
        findFrame.pack();
        findFrame.setLocationRelativeTo(null);
        findFrame.setVisible(true);
    }
    

    /**
     * After inputting the BinarySearchTree, {@code textArea} is filled with
     * the database and is displayed in the {@code browseFrame}.
     * 
     * @return browseFrame is returned to actionPerformed where 
     * we make sure that the frame is not repeatedly opened.
     */
    public JFrame browseTree() {
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
            if (tree == null) {
                JOptionPane.showMessageDialog(browseFrame, "A Tree has not been created yet! Use \"Create Tree from File\" button!");
            } else {
                tree.print_tree(tree.root, writer);

                String contents = buffer.toString();
                textArea.setText(contents);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        browseFrame.add(mainText, BorderLayout.NORTH);
        browseFrame.add(scroll, BorderLayout.CENTER);
        browseFrame.add(panel, BorderLayout.PAGE_END);
        browseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        browseFrame.setTitle("Main Window");
        browseFrame.pack();
        browseFrame.setLocationRelativeTo(null);
        browseFrame.setVisible(true);

        return browseFrame;
    }


    /**
     * Creates a new {@code createTreeFrame} JFrame that asks the user to input
     * a database that holds the Binary Search Tree. Once input, user has now
     * loaded the database into the BinarySearchTree.
     */
    public void getTree() {
        createTreeFrame = new JFrame();
        JPanel inputPanel = new JPanel();
        JPanel subPanel = new JPanel();
        inputText = new JTextField(20);
        JLabel inputLabel = new JLabel("Enter the file name:");
        JButton button7 = new JButton("Cancel");
        button8 = new JButton("OK");

        inputPanel.setLayout(new BorderLayout());
        subPanel.setLayout(new FlowLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 10));
        inputText.setBorder(BorderFactory.createLoweredBevelBorder());

        inputLabel.setLabelFor(inputText);
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(new JScrollPane(inputText), BorderLayout.LINE_START);
        subPanel.add(button7);
        subPanel.add(button8);
        inputPanel.add(subPanel, BorderLayout.SOUTH);


        button7.addActionListener(actions);
        button8.addActionListener(actions);
        
        
        createTreeFrame.add(inputPanel, BorderLayout.CENTER);
        createTreeFrame.setPreferredSize(new Dimension(400,200));
        createTreeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createTreeFrame.pack();
        createTreeFrame.setLocationRelativeTo(null);
        createTreeFrame.setVisible(true);

        
    }


    /**
     * Creates a {@code insertFrame} JFrame that requires the user to input
     * the student's id, faculty, major and year of study. This then creates
     * a new Node within the BinarySearchTree, which is updated by refreshing
     * the {@code browseFrame}.
     */
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
        insertFrame.setLocationRelativeTo(null);
        insertFrame.setVisible(true);

    }
    

    

    
}

