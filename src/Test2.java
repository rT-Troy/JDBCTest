import java.sql.*;

public class Test2 {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";//驱动类名
    static final String DB_URL = "jdbc:mysql://localhost:3306";//数据库URL地址

    static final String USERNAME = "user";//数据库用户名
    static final String PASSWORD = "123456";//数据库密码

    public static void main(String[] args){


        try (Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD)) {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting...");
            Statement stat = conn.createStatement();

            String sql = "SELECT * FROM test.students";//此处为MySQL语句
            ResultSet rs = stat.executeQuery(sql);

            while(rs.next()){//遍历
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("id = " + id);
                System.out.println("name = " + name);
                System.out.println("age = " + age);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
            System.out.println("Success!");

    }
}
