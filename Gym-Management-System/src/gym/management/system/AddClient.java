package gym.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class AddClient extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tfphone, tfaadhar, tfemail, tffee, tfage, tfplan, tftype;
    
    JLabel lbCId;
    
    JButton add, back;
    
    AddClient() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Client Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel labelfname = new JLabel("Phone no.");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 150, 150, 30);
        add(tfphone);
        
        JLabel labelage = new JLabel("Age ");
        labelage.setBounds(50, 200, 150, 30);
        labelage.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 200, 150, 30);
        add(tfage);
        
        JLabel labelfee = new JLabel("Fees ");
        labelfee.setBounds(400, 200, 150, 30);
        labelfee.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfee);
        
        tffee = new JTextField();
        tffee.setBounds(600, 200, 150, 30);
        add(tffee);
        
        JLabel labelplan = new JLabel("Plan");
        labelplan.setBounds(50, 250, 150, 30);
        labelplan.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelplan);
        
        tfplan = new JTextField();
        tfplan.setBounds(200, 250, 150, 30);
        add(tfplan);
        
        JLabel labeltype = new JLabel("Training type");
        labeltype.setBounds(400, 250, 150, 30);
        labeltype.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeltype);
        
        tftype = new JTextField();
        tftype.setBounds(600, 250, 150, 30);
        add(tftype);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 300, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 300, 150, 30);
        add(tfaadhar);
        
        JLabel labelcId = new JLabel("Client id");
        labelcId.setBounds(50, 400, 150, 30);
        labelcId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelcId);
        
        lbCId = new JLabel("" + number);
        lbCId.setBounds(200, 400, 150, 30);
        lbCId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbCId);
        
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String fphone = tfphone.getText();
            String fees = tffee.getText();
            String age = tfage.getText();
            String plan = tfplan.getText();
            String email = tfemail.getText();
            String aadhar = tfaadhar.getText();
            String CId = lbCId.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into client values('"+name+"', '"+fphone+"', '"+fees+"', '"+age+"', '"+plan+"', '"+email+"','"+aadhar+"', '"+CId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddClient();
    }
}

//create table client(name varchar(20), phone varchar(20), fees varchar(20), age varchar(10), plan varchar(20), email varchar(40), aadhar varchar(25), CId varchar(15));