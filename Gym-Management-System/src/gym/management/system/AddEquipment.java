package gym.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class AddEquipment extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tfcost, tfquantity, tfcompany, tfboughton;
    JLabel lbEId;
    
    JButton add, back;
    
    AddEquipment() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Equipment Detail");
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
        
        JLabel labelcost = new JLabel("Cost ");
        labelcost.setBounds(400, 150, 150, 30);
        labelcost.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelcost);
        
        tfcost = new JTextField();
        tfcost.setBounds(600, 150, 150, 30);
        add(tfcost);
        
        JLabel labelquantity = new JLabel("Quantity ");
        labelquantity.setBounds(50, 200, 150, 30);
        labelquantity.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelquantity);
        
        tfquantity = new JTextField();
        tfquantity.setBounds(200, 200, 150, 30);
        add(tfquantity);
        
        JLabel labelcompany = new JLabel("Company ");
        labelcompany.setBounds(400, 200, 150, 30);
        labelcompany.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelcompany);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(600, 200, 150, 30);
        add(tfcompany);
        
        JLabel labelbo = new JLabel("Bought On ");
        labelbo.setBounds(50, 250, 150, 30);
        labelbo.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelbo);
        
        tfboughton = new JTextField();
        tfboughton.setBounds(200, 250, 150, 30);
        add(tfboughton);
        
        JLabel labelempId = new JLabel("Equipment id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lbEId = new JLabel("" + number);
        lbEId.setBounds(200, 400, 150, 30);
        lbEId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbEId);
        
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
            String fname = tfname.getText();
            String fcost = tfcost.getText();
            String fquantity = tfquantity.getText();
            String fcompany = tfcompany.getText();
            String fdate = tfboughton.getText();
            String EId = lbEId.getText();
            
            
            try {
                Conn conn = new Conn();
                String query = "insert into equipment values('"+fname+"', '"+fcost+"', '"+fquantity+"', '"+fcompany+"', '"+fdate+"', '"+EId+"')";
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
        new AddEquipment();
    }
}

//create table equipment(name varchar(20), cost varchar(20), quantity varchar(20), company varchar(20), date varchar(20), EId varchar(15));