package pk.pl.database;

import java.sql.*;

public class DataBase {
    private Connection conn;

    public DataBase() {
        try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(myDriver);
            String myUrl = "jdbc:mysql://localhost:3306/finapp";
            this.conn = DriverManager.getConnection(myUrl, "root", "");
            System.out.println("Connected to expenses database");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void saveData(String name, String category, String subcategory, float expense, String comment, Date date) throws SQLException {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO expenses " +
                            "(name ,category, subcategory, expense, comment, date) "
                            + "VALUES (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, name);
            pstmt.setString(2, category);
            pstmt.setString(3, subcategory);
            pstmt.setFloat(4, expense);
            pstmt.setString(5, comment);
            pstmt.setDate(6, date);
            pstmt.executeUpdate();
            System.out.println("Record has been saved to database");
            try {
                pstmt.close();
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }

        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void closeDateBase() throws SQLException {
        try {
            this.conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void readData(){
        try {
            System.out.println("Connected to expenses database");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM expenses";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Records have been loaded");
            while (rs.next()) {
                System.out.println(
                        rs.getString("category") +
                        "\t" + rs.getString("subcategory") +
                        "\t" + rs.getFloat("expense") +
                        "\t" + rs.getString("comment") +
                        "\t" + rs.getDate("date"));
            }
            try {
                stmt.close();
                rs.close();
                conn.close();
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
