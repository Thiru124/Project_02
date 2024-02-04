package Login;

import java.sql.*;
import java.util.ArrayList;

public class ProjectDB {
    public ArrayList<String> list;
    public String name = "";
    public String password = "";

    public void DB() throws Exception {
        String url = "jdbc:mysql://localhost:3306/ReservationDB";
        String uname = "root";
        String pass = "Thiru@2003";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);

        String query = "SELECT*FROM USERS";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        name = rs.getString(2);
        password = rs.getString(3);
    }
    public void saveData(String name, String source, String destiny, int seat) throws Exception {
        String url = "jdbc:mysql://localhost:3306/ReservationDB";
        String uname = "root";
        String pass = "Thiru@2003";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);

        String insertQuery = "INSERT INTO user_info (name, source, destiny, seats) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, source);
        preparedStatement.setString(3, destiny);
        preparedStatement.setInt(4, seat);

        preparedStatement.executeLargeUpdate();
        System.out.println("User information inserted successfully.");

            System.out.println("Congratulations");
    }

}