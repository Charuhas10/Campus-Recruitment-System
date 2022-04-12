//User ID for Student = student
//Password for Student = password

package com.mycompany.campusrecruitment;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;

public class Login implements ActionListener {
        JFrame f = new JFrame("Project");
        JPanel panel = new JPanel();
        JLabel heading = new JLabel("CAMPUS RECRUITMENT SYSTEM");
        ImageIcon logo;

        ImageIcon welcome;
        JLabel welcomeimage = new JLabel();

        JLabel loginpage = new JLabel("LOGIN PAGE!");

        JLabel user = new JLabel("User");
        JTextField usertext = new JTextField(25);

        JLabel password = new JLabel("Password");
        JPasswordField passwordtext = new JPasswordField(25);

        JLabel success = new JLabel("");

        JButton b = new JButton("Login!");
        
        public Login()
        { 
            Color c =new Color(251,209,209); 
            
            panel.setBackground(c);
            f.add(panel);
            panel.setLayout(null);

            welcome = new ImageIcon("D:\\SNU\\CSD\\Java\\Project\\CampusRecruitment\\src\\main\\java\\com\\mycompany\\campusrecruitment\\Pictures\\welcome.jpg");
            welcomeimage.setBounds(0, 0, 500, 350);
            welcomeimage.setIcon(welcome);
            panel.add(welcomeimage);
            
            Border blackline = BorderFactory.createLineBorder(Color.black);
            heading.setForeground(new java.awt.Color(0, 0, 153));
            heading.setFont(new Font("sansserif", Font.BOLD,27));
            heading.setBounds(17, 370, 450, 50);
            heading.setBorder(blackline);
            panel.add(heading);

            loginpage.setBounds(173,440,200,20);
            loginpage.setFont(new Font("sansserif", Font.BOLD,20));
            panel.add(loginpage);

            user.setBounds(100, 480, 100, 20);      //Jlabel
            panel.add(user);
            
            usertext.setBounds(200, 480, 100, 20);      //Jtextfield
            panel.add(usertext);

            password.setBounds(100, 510, 100, 20);
            panel.add(password);
            
            passwordtext.setBounds(200, 510, 100, 20);
            panel.add(passwordtext);

            success.setBounds(100, 540, 300, 20);
            success.setForeground(Color.RED);
            success.setFont(new Font("sansserif", Font.BOLD,17));
            panel.add(success);

            b.setBounds(203, 565, 80, 25);
            b.setBorder(BorderFactory.createEtchedBorder());
            b.addActionListener(this);
            panel.add(b);

            f.getContentPane().setBackground(c);
            f.setSize(500,700);
            f.setResizable(false);
            f.setLocation(500, 0);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            logo = new ImageIcon("D:\\SNU\\CSD\\Java\\Project\\CampusRecruitment\\src\\main\\java\\com\\mycompany\\campusrecruitment\\Pictures\\logo.jpeg");
            f.setIconImage(logo.getImage());
            f.setVisible(true);
            
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        String user = usertext.getText();
        String password = passwordtext.getText();

        if(user.equals("student") && password.equals("password")){
            f.dispose();
            Student o = new Student();
        }
        else 
            success.setText("User ID or Password are WRONG!!");
    }
    public static void main(String[] args) {
       Login obj = new Login();
    }
}
