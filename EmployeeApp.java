package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeApp {

    public static void main(String[] args) {
        Connection con = null;
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBConfig.url, DBConfig.username, DBConfig.password);
            System.out.println("Connected to database.");

            while (true) {
                System.out.println("1.Add Employee");
                System.out.println("2.View Employee");
                System.out.println("3.Update Employee");
                System.out.println("4.Delete Employee");
                System.out.println("5.Exit");
                System.out.print("Choose: ");
                int choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1:
                        addEmployee(con, sc);
                        break;
                    case 2:
                        viewEmployees(con);
                        break;
                    case 3:
                        updateEmployeeMobile(con, sc);
                        break;
                    case 4:
                        deleteEmployee(con, sc);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        con.close();
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } 
        
        catch (Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addEmployee(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Mobile: ");
        String mobile = sc.nextLine();

        String sql = "INSERT INTO employee(id, name, email, mobile) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, email);
        ps.setString(4, mobile);
        int rows = ps.executeUpdate();
        System.out.println(rows + " employee added.");
    }

    private static void viewEmployees(Connection con) throws SQLException {
        String sql = "SELECT * FROM employee";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        System.out.println("Employee List:");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Email: " + rs.getString("email") + ", Mobile: " + rs.getString("mobile"));
        }
    }

    private static void updateEmployeeMobile(Connection con, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new Mobile: ");
        String mobile = scanner.nextLine();
        String sql = "UPDATE employee SET mobile = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, mobile);
        ps.setInt(2, id);
        int rows = ps.executeUpdate();
        System.out.println(rows + " employee updated.");
    }

    private static void deleteEmployee(Connection con, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        String sql = "DELETE FROM employee WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        System.out.println(rows + " employee deleted.");
    }
}
