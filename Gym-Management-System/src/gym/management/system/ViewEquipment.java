package gym.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEquipment extends JFrame implements ActionListener{

    JTable table;
    JTextField equipId;
    JButton search, print, update, back,add,remove;
    
    ViewEquipment() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Equipment Name: ");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        equipId = new JTextField();
        equipId.setBounds(250, 20, 150, 20);
        add(equipId);
        
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from equipment");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        add = new JButton("Add");
        add.setBounds(420, 70, 80, 20);
        add.addActionListener(this);
        add(add);
        
        remove = new JButton("Remove");
        remove.setBounds(520, 70, 80, 20);
        remove.addActionListener(this);
        add(remove);
        
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from equipment where name = '"+equipId.getText()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEquipment(equipId.getText());
        }else if (ae.getSource() == add){
            setVisible(false);
            new AddEquipment();
        }else if (ae.getSource() == remove){
            setVisible(false);
            new RemoveEquipment();
        }else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEquipment();
    }
}
