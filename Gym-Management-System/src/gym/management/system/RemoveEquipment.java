package gym.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEquipment extends JFrame implements ActionListener {
    
    Choice eId;
    JButton delete, back;
    
    RemoveEquipment() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempId = new JLabel("Equipment Id");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);
        
        eId = new Choice();
        eId.setBounds(200, 50, 150, 30);
        add(eId);
        
        try {
            Conn c = new Conn();
            String query = "select * from equipment";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                eId.add(rs.getString("EId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        
        JLabel labelcompany = new JLabel("Company");
        labelcompany.setBounds(50, 150, 100, 30);
        add(labelcompany);
        
        JLabel lblcompany = new JLabel();
        lblcompany.setBounds(200, 150, 100, 30);
        add(lblcompany);
        
        JLabel labelquantity = new JLabel("Quantity");
        labelquantity.setBounds(50, 200, 100, 30);
        add(labelquantity);
        
        JLabel lblquantity = new JLabel();
        lblquantity.setBounds(200, 200, 100, 30);
        add(lblquantity);
        
        try {
            Conn c = new Conn();
            String query = "select * from equipment where EId = '"+eId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblcompany.setText(rs.getString("company"));
                lblquantity.setText(rs.getString("quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        eId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from equipment where EId = '"+eId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblcompany.setText(rs.getString("company"));
                        lblquantity.setText(rs.getString("quantity"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from equipment where EId = '"+eId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Equipment Information Deleted Sucessfully");
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
        new RemoveEquipment();
    }
}

