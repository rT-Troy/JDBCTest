import java.sql.*;

public class Test {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/web";

    static final String USERNAME = "user";
    static final String PASSWORD = "123456";

    public static void main(String[] args){

        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting...");
            conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            stat = conn.createStatement();

            String sql = "select * from web.students ";
            ResultSet rs = stat.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String grade = rs.getString("grade");
                System.out.println("id = " + id);
                System.out.println("name = " + name);
                System.out.println("age = " + age);
                System.out.println("grade = " + grade);
            }

            rs.close();
            stat.close();
            conn.close();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (stat!=null) stat.close();
            } catch (SQLException ignored) {
            } try {
                if (conn!=null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            System.out.println("Success!");
        }
    }
}