package SQL;

import java.sql.*;

public class MySQLConnection {
    String URL = "jdbc:mysql://localhost/game";
    String UserName = "root";
    String Password = "123";
    Connection Con;

    static MySQLConnection mySQLConnection = null;

    public static MySQLConnection getMySQL() {
        if (mySQLConnection == null) {
            mySQLConnection = new MySQLConnection();
        }
        return mySQLConnection;
    }

    public ResultSet ExecuteQuery(String SQLCom) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection(URL, UserName, Password);
            Statement s = Con.prepareStatement(SQLCom);
            ResultSet rs = s.executeQuery(SQLCom);
            return rs;
        } catch (Exception ex) {
            return null;
        }
    }

    public Boolean Execute(String SQLCom) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection(URL, UserName, Password);
            Statement s = Con.prepareStatement(SQLCom);
            ;
            s.execute(SQLCom);
            Con.close();

            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
}
