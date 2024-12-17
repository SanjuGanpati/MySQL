import java.sql.*;
import java.util.Scanner;

public class TransactionDemoWithCommitAndRollback {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "Sanju@1981";

        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        System.out.println("Data before Transaction:");//  printAccounts(st);
        System.out.println("-----------");
        ResultSet rs= st.executeQuery("select * from account");
        while (rs.next()){
            System.out.println(rs.getString(1)+"...."+rs.getInt(2));
        }

        System.out.println("Transaction begins...");
        con.setAutoCommit(false);

        st.executeUpdate("update account set balance=balance -2000 WHERE user= 'Manu'");
        st.executeUpdate("update account set balance=balance +2000 WHERE user= 'Aanu'");
        System.out.print("Can you please confirm this transaction of 2000.... [Yes|No]: ");

        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if (option.equalsIgnoreCase("yes")) {
            con.commit();
            System.out.println("Transaction committed.");
        } else {
            con.rollback();
            System.out.println("Transaction Rolled Back");
        }

        System.out.println("Data After Transaction:");
        System.out.println("-----------");
        ResultSet rs1= st.executeQuery("select * from account");
        while (rs1.next()) {
            System.out.println(rs1.getString(1) + "...." + rs1.getInt(2));
        }

        //con.close();
    }}

