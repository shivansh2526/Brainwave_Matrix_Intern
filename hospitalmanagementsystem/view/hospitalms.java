package view;

import db.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class StaffForm extends JFrame {
    JTextField nameField, roleField, deptField, salaryField;

    public StaffForm() {
        setTitle("Staff Management");
        setSize(350, 250);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Name:")); nameField = new JTextField(); add(nameField);
        add(new JLabel("Role:")); roleField = new JTextField(); add(roleField);
        add(new JLabel("Department:")); deptField = new JTextField(); add(deptField);
        add(new JLabel("Salary:")); salaryField = new JTextField(); add(salaryField);

        JButton addBtn = new JButton("Add Staff");
        add(new JLabel()); add(addBtn);

        addBtn.addActionListener(e -> addStaff());

        setVisible(true);
    }

    private void addStaff() {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO staff(name, role, department, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nameField.getText());
            ps.setString(2, roleField.getText());
            ps.setString(3, deptField.getText());
            ps.setDouble(4, Double.parseDouble(salaryField.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Staff added successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding staff");
        }
    }
}
