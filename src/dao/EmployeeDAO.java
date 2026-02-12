package dao;

import database.DatabaseConnection;
import model.Cashier;
import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public boolean insertCashier(Cashier cashier) {
        String sql = "INSERT INTO employee(name, salary, register_number) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cashier.getName());
            ps.setDouble(2, cashier.getSalary());
            ps.setInt(3, cashier.getRegisterNumber());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extractCashier(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Employee getById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return extractCashier(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateCashier(Cashier cashier) {
        String sql = "UPDATE employee SET name=?, salary=?, register_number=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cashier.getName());
            ps.setDouble(2, cashier.getSalary());
            ps.setInt(3, cashier.getRegisterNumber());
            ps.setInt(4, cashier.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteById(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Employee> searchByName(String name) {
        List<Employee> list = new ArrayList<>();
        // Используем ILIKE для PostgreSQL
        String sql = "SELECT * FROM employee WHERE name ILIKE ? ORDER BY name";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(extractCashier(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Employee> searchBySalaryRange(double min, double max) {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee WHERE salary BETWEEN ? AND ? ORDER BY salary DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, min);
            ps.setDouble(2, max);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(extractCashier(rs));
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public List<Employee> searchByMinSalary(double minSalary) {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee WHERE salary >= ? ORDER BY salary DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, minSalary);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(extractCashier(rs));
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    private Cashier extractCashier(ResultSet rs) throws SQLException {
        return new Cashier(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("salary"),
                rs.getInt("register_number")
        );
    }
}