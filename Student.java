package com.mycompany.campusrecruitment;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import java.sql.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Student implements ActionListener {
        JFrame frame = new JFrame("Student");
        JPanel panel = new JPanel();
        JLabel heading = new JLabel("TELL US ABOUT YOURSELF");
        ImageIcon logo;

        ImageIcon image;
        JLabel welcomeimage = new JLabel();

        JLabel name = new JLabel("NAME");
        JLabel qualifications = new JLabel("QUALIFICATIONS");
        JLabel age = new JLabel("AGE");
        JLabel skills = new JLabel("SKILLS");
        JLabel CGPA = new JLabel("CGPA");

        JTextField studentName = new JTextField(25);
        JTextField studentAge = new JTextField(25);
        JTextField studentCGPA = new JTextField(25);

        JCheckBox[] checkList = new JCheckBox[6];

        ButtonGroup group = new ButtonGroup();
        JRadioButton[] qual = new JRadioButton[8];
        
        JButton b = new JButton("Submit!!");
        
        JPanel panelButton = new JPanel();
        JTextArea ta  = new JTextArea(20,50);
        JLabel end = new JLabel("YOU CAN APPLY HERE!");
        JLabel lastimage = new JLabel();
        ImageIcon last;
        
        public Student()
        { 
            Color c =new Color(251,209,209); 
            
            panel.setBackground(c);
            frame.add(panel);
            panel.setLayout(null);

            image = new ImageIcon("D:\\SNU\\CSD\\Java\\Project\\CampusRecruitment\\src\\main\\java\\com\\mycompany\\campusrecruitment\\Pictures\\student.jpeg");
            welcomeimage.setBounds(0, 0, 500, 350);
            welcomeimage.setIcon(image);
            panel.add(welcomeimage);
            
            heading.setForeground(new java.awt.Color(122, 17, 73));
            heading.setFont(new Font("sansserif", Font.BOLD,27));
            heading.setBounds(65, 350, 450, 50);
            panel.add(heading);

            name.setBounds(50,410,100,20);
            name.setForeground(new java.awt.Color(122, 17, 73));
            studentName.setBounds(200, 410, 100, 20);
            panel.add(name);
            panel.add(studentName);

            age.setBounds(50, 440, 100, 20);
            age.setForeground(new java.awt.Color(122, 17, 73));
            studentAge.setBounds(200, 440, 100, 20);
            panel.add(age);
            panel.add(studentAge);

            CGPA.setBounds(50, 470, 100, 20);
            CGPA.setForeground(new java.awt.Color(122, 17, 73));
            studentCGPA.setBounds(200, 470, 100, 20);
            panel.add(CGPA);
            panel.add(studentCGPA);

            qualifications.setBounds(50, 500, 100, 20);
            qualifications.setForeground(new java.awt.Color(122, 17, 73));
            
            qual[0] = new JRadioButton("10th");
            qual[1] = new JRadioButton("12th");
            qual[2] = new JRadioButton("BTech (CSE)");
            qual[3] = new JRadioButton("BTech (ECE)");
            qual[4] = new JRadioButton("BTech (Mech)");
            qual[5] = new JRadioButton("Btech (Chem)");
            qual[6] = new JRadioButton("MTech");
            qual[7] = new JRadioButton("MBA");
            for(int i=0; i<8; i++){
                qual[i].setFocusPainted(false);
            }

            qual[0].setBackground(c);
            qual[1].setBackground(c);
            qual[2].setBackground(c);
            qual[3].setBackground(c);
            qual[4].setBackground(c);
            qual[5].setBackground(c);
            qual[6].setBackground(c);
            qual[7].setBackground(c);

            qual[0].setBounds(165, 500, 100, 20);
            qual[1].setBounds(315, 500, 140, 15);
            qual[2].setBounds(165, 520, 140, 15);
            qual[3].setBounds(315, 520, 140, 15);
            qual[4].setBounds(165, 540, 140, 15);
            qual[5].setBounds(315, 540, 140, 15);
            qual[6].setBounds(165, 560, 140, 15);
            qual[7].setBounds(315, 560, 140, 15);

            group.add(qual[0]);
            group.add(qual[1]);
            group.add(qual[2]);
            group.add(qual[3]);
            group.add(qual[4]);
            group.add(qual[5]);
            group.add(qual[6]);
            group.add(qual[7]);

            panel.add(qualifications);
            panel.add(qual[0]);
            panel.add(qual[1]);
            panel.add(qual[2]);
            panel.add(qual[3]);
            panel.add(qual[4]);
            panel.add(qual[5]);
            panel.add(qual[6]);
            panel.add(qual[7]);

            skills.setBounds(50, 590, 100, 20);
            skills.setForeground(new java.awt.Color(122, 17, 73));

            checkList[0] = new JCheckBox("Machine Learning");
            checkList[1] = new JCheckBox("Cloud Computing");
            checkList[2] = new JCheckBox("IOT");
            checkList[3] = new JCheckBox("Full Stack Developer");
            checkList[4] = new JCheckBox("Data Analyst");
            checkList[5] = new JCheckBox("Graphic Designer");

            checkList[0].setBackground(c);
            checkList[1].setBackground(c);
            checkList[2].setBackground(c);
            checkList[3].setBackground(c);
            checkList[4].setBackground(c);
            checkList[5].setBackground(c);
            checkList[0].setBounds(165, 590, 140, 15);
            checkList[1].setBounds(315, 590, 140, 15);
            checkList[2].setBounds(165, 610, 140, 15);
            checkList[3].setBounds(315, 610, 140, 15);
            checkList[4].setBounds(165, 630, 140, 15);
            checkList[5].setBounds(315, 630, 140, 15);
            panel.add(skills);
            panel.add(checkList[0]);
            panel.add(checkList[1]);
            panel.add(checkList[2]);
            panel.add(checkList[3]);
            panel.add(checkList[4]);
            panel.add(checkList[5]);
            Listener listener = new Listener();
            for (int i = 0; i < 6; ++i) {
                checkList[i].addItemListener(listener);
            }
            
            b.setBounds(203, 670, 80, 25);
            b.setBorder(BorderFactory.createEtchedBorder());
            b.addActionListener(this);
            panel.add(b);

            frame.getContentPane().setBackground(c);
            frame.setSize(500,800);
            frame.setResizable(false);
            frame.setLocation(500, 0);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            logo = new ImageIcon("D:\\SNU\\CSD\\Java\\Project\\CampusRecruitment\\src\\main\\java\\com\\mycompany\\campusrecruitment\\Pictures\\logo.jpeg");
            frame.setIconImage(logo.getImage());
            frame.setVisible(true);
            
        }
        public class Listener implements ItemListener {
            private final int maxSelections = 2;
            private int selectionCounter = 0;
    
            @Override
            public void itemStateChanged(ItemEvent event) {
                JCheckBox source = (JCheckBox) event.getSource();
    
                if (source.isSelected()) {
                    selectionCounter++;
                    if (selectionCounter == maxSelections)
                        for (JCheckBox box: checkList)
                            if (!box.isSelected())
                                box.setEnabled(false);
                }
                else {
                    selectionCounter--;
                    if (selectionCounter < maxSelections)
                        for (JCheckBox box: checkList)
                            box.setEnabled(true);
                }
            }
        }
    
    @Override
    public void actionPerformed(ActionEvent ac) {
        Connection c = null;
        try {
                panel.setVisible(false);
                
                Color col =new Color(251,209,209); 
                panelButton.setBackground(col);
                frame.add(panelButton);
                panelButton.setLayout(null);
                last = new ImageIcon("D:\\SNU\\CSD\\Java\\Project\\CampusRecruitment\\src\\main\\java\\com\\mycompany\\campusrecruitment\\Pictures\\end.jpeg");
                lastimage.setBounds(0, 0, 500, 350);
                lastimage.setIcon(last);
                panelButton.add(lastimage);
                end.setForeground(new java.awt.Color(122, 17, 73));
                end.setFont(new Font("sansserif", Font.BOLD,27));
                end.setBounds(82, 375, 450, 50);
                panelButton.add(end);
                
                ta.setBackground(col);
                ta.setBounds(50,455,450,200);
                ta.setForeground(Color.BLACK);
                ta.setFont(new Font("sansserif", Font.BOLD,15));
                panelButton.add(ta);
                
                String name = studentName.getText(); 
                
                String qualification="none";
                if(qual[0].isSelected())
                    qualification = "10th";
                else if(qual[1].isSelected())
                    qualification = "12th";
                else if(qual[2].isSelected())
                    qualification = "BTech (CSE)";
                else if(qual[3].isSelected())
                    qualification = "BTech (ECE)";
                else if(qual[4].isSelected())
                    qualification = "BTech (Mech)";
                else if(qual[5].isSelected())
                    qualification = "Btech (Chem)";
                else if(qual[6].isSelected())
                    qualification = "MTech";
                else if(qual[7].isSelected())
                    qualification = "MBA";
                
                int age = Integer.parseInt(studentAge.getText());
                
                float gpa = Float.parseFloat(studentCGPA.getText());
                
                int[] a = { 0, 0, 0, 0, 0, 0 };
    
                for (int i = 0; i < 6; ++i){
                    if(checkList[i].isSelected())
                        a[i] = 1;
                }
                
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:C:src\\main\\java\\com\\mycompany\\campusrecruitment\\data.db");
                System.out.println("Opened database successfully");
                Statement stmt = null;
                stmt = c.createStatement();
                String sql = "INSERT INTO \"student\" (\"Full Name\",QUALIFICATIONS,AGE,\"MACHINE LEARNING\",\"CLOUD COMPUTING\",\"FULL STACK DEVELOPER\",\"INTERNET OF THINGS(IOT)\",\"DATA ANALYST\",\"GRAPHIC DESIGNER\",CGPA) " +
                             "VALUES ('"+name+"', '"+qualification+"' , '"+age+"', '"+a[0]+"','"+a[1]+"','"+a[3]+"','"+a[2]+"','"+a[4]+"','"+a[5]+"', '"+gpa+"');"; 
                c.setAutoCommit(false);
                stmt.executeUpdate(sql);       

                if(gpa>=9.50)
                 {
                   if(a[0] == 1 && a[1] == 1)
                        ta.setText("GOOGLE: \n Expected Salary: 28 L.P.A \n\n" + "APPLE: \n Expected Salary: 30 L.P.A \n\n" + "MICROSOFT: \n Expected Salary: 25 L.P.A \n\n" );
                   else if(a[0] == 1 && a[4] == 1)
                        ta.setText("GOOGLE: \n Expected Salary: 28 L.P.A \n\n" + "APPLE: \n Expected Salary: 27 L.P.A \n\n" + "INTEL: \n Expected Salary: 25 L.P.A \n\n");
                   else if(a[0] == 1 && a[2] == 1)
                        ta.setText("GOOGLE: \n Expected Salary: 28 L.P.A \n\n" + "APPLE: \n Expected Salary: 27 L.P.A \n\n"  + "SIEMENS: \n Expected Salary: 23 L.P.A \n\n");
                   else if(a[0] == 1 && a[5] == 1)
                        ta.setText("GOOGLE: \n Expected Salary: 28 L.P.A \n\n" + "APPLE: \n Expected Salary: 27 L.P.A \n\n" + "SIEMENS: \n Expected Salary: 23 L.P.A \n\n" );
                   else if(a[0] == 1 && a[3] == 1)
                        ta.setText("GOOGLE: \n Expected Salary: 28 L.P.A \n\n" + "APPLE: \n Expected Salary: 27 L.P.A \n\n" + "SIEMENS: \n Expected Salary: 23 L.P.A \n\n");

                   else if(a[1] == 1 && a[4] == 1)
                        ta.setText("GOOGLE: \n Expected Salary: 28 L.P.A \n\n"  + "INTEL: \n Expected Salary: 25 L.P.A \n\n" + "MICROSOFT: \n Expected Salary: 30 L.P.A \n\n");
                   else if(a[1] == 1 && a[2] == 1)
                        ta.setText( "SIEMENS: \n Expected Salary: 23 L.P.A \n\n" + "MICROSOFT: \n Expected Salary: 30 L.P.A \n\n" + "AMAZON: \n Expected Salary: 25 L.P.A \n\n");
                   else if(a[1] == 1 && a[5] == 1)
                        ta.setText("GOOGLE: \n Expected Salary: 28 L.P.A \n\n" + "MICROSOFT: \n Expected Salary: 30 L.P.A \n\n" + "AMAZON: \n Expected Salary: 25 L.P.A \n\n");

                   else if(a[1] == 1 && a[3] == 1)
                        ta.setText("GOOGLE: \n Expected Salary: 28 L.P.A \n\n"  + "NVIDIA: \n Expected Salary: 29 L.P.A \n\n" + "MICROSOFT: \n Expected Salary: 30 L.P.A \n\n");
                   else if(a[4] == 1 && a[2] == 1)
                        ta.setText("SIEMENS: \n Expected Salary: 23 L.P.A \n\n"  + "INTEL: \n Expected Salary: 25 L.P.A \n\n" + "AMAZON: \n Expected Salary: 25 L.P.A \n\n");

                   else if(a[4] == 1 && a[5] == 1)
                        ta.setText("INTEL: \n Expected Salary: 25 L.P.A \n\n" + "AMAZON: \n Expected Salary: 25 L.P.A \n\n");

                   else if(a[4] == 1 && a[3] == 1)
                        ta.setText("NVIDIA: \n Expected Salary: 29 L.P.A \n\n"  + "INTEL: \n Expected Salary: 25 L.P.A \n\n" + "AMAZON: \n Expected Salary: 25 L.P.A \n\n");

                   else if(a[2] == 1 && a[5] == 1)
                        ta.setText("SIEMENS: \n Expected Salary: 23 L.P.A \n\n" + "AMAZON: \n Expected Salary: 25 L.P.A \n\n");
                   else if(a[2] == 1 && a[3] == 1)
                        ta.setText("SIEMENS: \n Expected Salary: 23 L.P.A \n\n" + "NVIDIA: \n Expected Salary: 29 L.P.A \n\n");
                   else if(a[5] == 1 && a[3] == 1)
                        ta.setText("NVIDIA: \n Expected Salary: 29 L.P.A \n\n" + "AMAZON: \n Expected Salary: 25 L.P.A \n\n");
                   else if(a[0] == 1)
                        ta.setText("SIEMENS: \n Expected Salary: 23 L.P.A \n\n"  + "GOOGLE: \n Expected Salary: 28 L.P.A \n\n" + "APPLE: \n Expected Salary: 27 L.P.A \n\n");
                   else if(a[1] == 1)
                        ta.setText("GOOGLE: \n Expected Salary: 28 L.P.A \n\n"  + "MICROSOFT: \n Expected Salary: 30 L.P.A \n\n" + "AMAZON: \n Expected Salary: 25 L.P.A \n\n");

                   else if(a[4] == 1)
                        ta.setText("INTEL: \n Expected Salary: 25 L.P.A \n\n" + "AMAZON: \n Expected Salary: 25 L.P.A \n\n");

                   else if(a[2] == 1)
                        ta.setText("SIEMENS: \n Expected Salary: 23 L.P.A \n\n");

                   else if(a[5] == 1)
                        ta.setText("AMAZON: \n Expected Salary: 25 L.P.A \n\n");
                   else if(a[3] == 1)
                        ta.setText("NVIDIA: \n Expected Salary: 29 L.P.A \n\n");
                }
              if(gpa>=9.0 &&gpa <9.50)
              {
                   if(a[0] == 1 && a[1] == 1)
                        ta.setText("HEWLETT PACKARD: \n Expected Salary: 16 L.P.A \n\n" + "IBM: \n Expected Salary: 15 L.P.A \n\n");

                   else if(a[0] == 1 && a[4] == 1)
                        ta.setText("HEWLETT PACKARD: \n Expected Salary: 16 L.P.A \n\n" + "FLIPKART: \n Expected Salary: 18 L.P.A \n\n");
                   else if(a[0] == 1 && a[2] == 1)
                        ta.setText("HEWLETT PACKARD: \n Expected Salary: 16 L.P.A \n\n" + "HITACHI DATA SYSTEMS: \n Expected Salary: 17 L.P.A \n\n");
                   else if(a[0] == 1 && a[5] == 1)
                        ta.setText("HEWLETT PACKARD: \n Expected Salary: 16 L.P.A \n\n" + "FLIPKART: \n Expected Salary: 18 L.P.A \n\n" + "ACCENTURE: \n Expected Salary: 20 L.P.A \n\n");
                   else if(a[0] == 1 && a[3] == 1)
                        ta.setText("HEWLETT PACKARD: \n Expected Salary: 16 L.P.A \n\n" + "BOSCH: \n Expected Salary: 19 L.P.A \n\n");

                   else if(a[1] == 1 && a[4] == 1)
                        ta.setText("IBM: \n Expected Salary: 15 L.P.A \n\n" + "FLIPKART: \n Expected Salary: 18 L.P.A \n\n");
                   else if(a[1] == 1 && a[2] == 1)
                        ta.setText("IBM: \n Expected Salary: 15 L.P.A \n\n" + "HITACHI DATA SYSTEMS: \n Expected Salary: 17 L.P.A \n\n");

                   else if(a[1] == 1 && a[5] == 1)
                        ta.setText("IBM: \n Expected Salary: 15 L.P.A \n\n" + "FLIPKART: \n Expected Salary: 18 L.P.A \n\n" + "ACCENTURE: \n Expected Salary: 20 L.P.A \n\n");
                   else if(a[1] == 1 && a[3] == 1)
                        ta.setText("IBM: \n Expected Salary: 15 L.P.A \n\n" + "BOSCH: \n Expected Salary: 19 L.P.A \n\n");
                   else if(a[4] == 1 && a[2] == 1)
                        ta.setText("FLIPKART: \n Expected Salary: 18 L.P.A \n\n" + "HITACHI DATA SYSTEMS: \n Expected Salary: 17 L.P.A \n\n");
                   else if(a[4] == 1 && a[5] == 1)
                        ta.setText("FLIPKART: \n Expected Salary: 18 L.P.A \n\n" + "ACCENTURE: \n Expected Salary: 20 L.P.A \n\n");
                   else if(a[4] == 1 && a[3] == 1)
                        ta.setText("FLIPKART: \n Expected Salary: 18 L.P.A \n\n" + "BOSCH: \n Expected Salary: 19 L.P.A \n\n");
                   else if(a[2] == 1 && a[5] == 1)
                        ta.setText("HITACHI DATA SYSTEMS: \n Expected Salary: 17 L.P.A \n\n" + "FLIPKART: \n Expected Salary: 18 L.P.A \n\n" + "ACCENTURE: \n Expected Salary: 20 L.P.A \n\n");
                   else if(a[2] == 1 && a[3] == 1)
                        ta.setText("HITACHI DATA SYSTEMS: \n Expected Salary: 17 L.P.A \n\n" + "BOSCH: \n Expected Salary: 19 L.P.A \n\n");

                   else if(a[5] == 1 && a[3] == 1)
                        ta.setText("BOSCH: \n Expected Salary: 19 L.P.A \n\n" + "FLIPKART: \n Expected Salary: 18 L.P.A \n\n" + "ACCENTURE: \n Expected Salary: 20 L.P.A \n\n");
                   else if(a[0] == 1)
                        ta.setText("HEWLETT PACKARD: \n Expected Salary: 16 L.P.A \n\n");
                   else if(a[1] == 1)
                        ta.setText("IBM: \n Expected Salary: 15 L.P.A \n\n");
                   else if(a[4] == 1)
                        ta.setText("FLIPKART: \n Expected Salary: 18 L.P.A \n\n");
                   else if(a[2] == 1)
                        ta.setText("HITACHI DATA SYSTEMS: \n Expected Salary: 17 L.P.A \n\n");
                   else if(a[5] == 1)
                        ta.setText("ACCENTURE: \n Expected Salary: 20 L.P.A \n\n" + "FLIPKART: \n Expected Salary: 18 L.P.A \n\n");
                   else if(a[3] == 1)
                        ta.setText("BOSCH: \n Expected Salary: 19 L.P.A \n\n");
                }
                if(gpa < 9.0)
                  {
                   if(a[0] == 1 && a[1] == 1)
                        ta.setText("GE CORPORATE: \n Expected Salary: 9 L.P.A \n\n" + "TCS: \n Expected Salary: 5 L.P.A \n\n" + "INFOSYS: \n Expected Salary: 10 L.P.A \n\n");
                   else if(a[0] == 1 && a[4] == 1)
                        ta.setText("GE CORPORATE: \n Expected Salary: 9 L.P.A \n\n" + "TCS: \n Expected Salary: 5 L.P.A \n\n" + "INFOSYS: \n Expected Salary: 10 L.P.A \n\n");
                   else if(a[0] == 1 && a[2] == 1)
                        ta.setText("TCS: \n Expected Salary: 5 L.P.A \n\n" + "INFOSYS: \n Expected Salary: 10 L.P.A \n\n" + "MATHWORKS: \n Expected Salary: 7 L.P.A \n\n");
                   else if(a[0] == 1 && a[5] == 1)
                        ta.setText("GE CORPORATE: \n Expected Salary: 9 L.P.A \n\n" + "TCS: \n Expected Salary: 5 L.P.A \n\n" + "INFOSYS: \n Expected Salary: 10 L.P.A \n\n");
                   else if(a[0] == 1 && a[3] == 1)
                        ta.setText("GE CORPORATE: \n Expected Salary: 9 L.P.A \n\n" + "TCS: \n Expected Salary: 5 L.P.A \n\n" + "INFOSYS: \n Expected Salary: 10 L.P.A \n\n");
                   else if(a[1] == 1 && a[4] == 1)
                        ta.setText("TCS: \n Expected Salary: 5 L.P.A \n\n");
                   else if(a[1] == 1 && a[2] == 1)
                        ta.setText("MATHWORKS: \n Expected Salary: 7L.P.A \n\n" + "TCS: \n Expected Salary: 5 L.P.A \n\n");
                   else if((a[1] == 1 && a[5] == 1)||(a[1] == 1 && a[3] == 1)||(a[4] == 1 && a[5] == 1)||(a[4] == 1 && a[3] == 1)||(a[5] == 1 && a[3] == 1))
                        ta.setText("TCS: \n Expected Salary: 5 L.P.A \n\n");
                   else if(a[4] == 1 && a[2] == 1)
                        ta.setText("MATHWORKS: \n Expected Salary: 7L.P.A \n\n" + "TCS: \n Expected Salary: 5 L.P.A \n\n");
                   else if(a[2] == 1 && a[5] == 1)
                        ta.setText("MATHWORKS: \n Expected Salary: 7L.P.A \n\n" + "TCS: \n Expected Salary: 5 L.P.A \n\n");
                   else if(a[2] == 1 && a[3] == 1)
                        ta.setText("MATHWORKS: \n Expected Salary: 7L.P.A \n\n" + "TCS: \n Expected Salary: 5 L.P.A \n\n");
                   else if(a[0] == 1)
                        ta.setText("GE CORPORATE: \n Expected Salary: 9 L.P.A \n\n" + "TCS: \n Expected Salary: 5 L.P.A \n\n" + "INFOSYS: \n Expected Salary: 10 L.P.A \n\n");
                   else if(a[1] == 1||a[4] == 1||a[5] == 1||a[3] == 1)
                        ta.setText("TCS: \n Expected Salary: 5 L.P.A \n\n");
                   else if(a[2] == 1)
                        ta.setText("MATHWORKS: \n Expected Salary: 7L.P.A \n\n" + "TCS: \n Expected Salary: 5 L.P.A \n\n");
                  }
               stmt.close();
                c.commit();
                c.close();
            } 
        catch ( Exception e ) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
}
}