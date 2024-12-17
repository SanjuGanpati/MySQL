import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class JdbcDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/universalit";
        String uname = "root";
        String password = "Sanju@1981";
        Connection con = DriverManager.getConnection(url, uname, password);
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery("select * from student ");
        while (resultSet.next()) {
            System.out.println("Student Name: " + resultSet.getString(1));
            System.out.println("Student Subject: " + resultSet.getString(2));
        }
    }
}
