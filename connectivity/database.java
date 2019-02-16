package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;


public class database {
    public Connection connection;
    public Connection getConnecton(){
        String dbName = "shop";
        String UserName = "root";
        String PassWord = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,UserName,PassWord);
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
