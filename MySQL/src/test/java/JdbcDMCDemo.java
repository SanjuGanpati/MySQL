import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDMCDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/universalit";
        String uname = "root";
        String password = "Sanju@1981";
        String query = "select * from student";
        String insertQuery = "Insert into student values ( 'Sangeeta', 'Automation Testing')";
        Connection con = null;
        ResultSet resultSet = null;
        try {
            con = DriverManager.getConnection(url, uname, password);
            Statement st = con.createStatement();
            int count = st.executeUpdate(insertQuery);
            System.out.println("No of rows affected = " + count);
             System.out.println("Going to commit again ");
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
