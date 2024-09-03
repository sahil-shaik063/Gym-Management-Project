package gym.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateClient extends JFrame implements ActionListener{
    
    JTextField tfname, tfphone, tfaadhar, tfemail, tffee, tfage, tfplan, tftype;
    JLabel lbCId;
    JButton add, back;
    String CId;
    
    UpdateClient(String cId) {
        this.CId = cId;
        
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
        
        JLabel labeldob = new JLabel("Age ");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        tfage = new JTextField();
        tfage.setBounds(200, 200, 150, 30);
        add(tfage);
        
        JLabel labelsalary = new JLabel("Fees ");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tffee = new JTextField();
        tffee.setBounds(600, 200, 150, 30);
        add(tffee);
        
        JLabel labeladdress = new JLabel("Plan");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfplan = new JTextField();
        tfplan.setBounds(200, 250, 150, 30);
        add(tfplan);
        
        JLabel labelphone = new JLabel("Training type");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
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
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);
        
        JLabel labelempId = new JLabel("Client id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lbCId = new JLabel();
        lbCId.setBounds(200, 400, 150, 30);
        lbCId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbCId);
        
        try {
            Conn c = new Conn();
            String query = "select * from client where name = '"+CId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                tfname.setText(rs.getString("name"));
                tfphone.setText(rs.getString("phone"));
                tfage.setText(rs.getString("age"));
                tffee.setText(rs.getString("fees"));
                tfplan.setText(rs.getString("plan"));
                tfemail.setText(rs.getString("email"));
                tfaadhar.setText(rs.getString("aadhar"));
                lbCId.setText(rs.getString("CId"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
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
            String fname = tfname.getText();
            String fphone = tfphone.getText();
            String ffees = tffee.getText();
            String fage = tfage.getText();
            String fplan = tfplan.getText();
            String femail = tfemail.getText();
            String faadhar = tfaadhar.getText();
            String CId = lbCId.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update client set name = '"+fname+"', phone = '"+fphone+"', fees = '"+ffees+"', age = '"+fage+"', plan =  '"+fplan+"', email = '"+femail+"', aadhar = '"+faadhar+"' where CId = '"+CId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
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
        new UpdateClient("");
    }
}
