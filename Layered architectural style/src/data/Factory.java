package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-28
 * Time: 上午10:27
 * To change this template use File | Settings | File Templates.
 */
public class Factory {
    private static Connection connection = null;
    private static final String DBDRIVER="com.mysql.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://localhost:3306/phone";
    private static final String USER="root";
    private static final String PASS="hlr1992129";

    public static PhoneNumberDao getPhoneNumberDao(){
        return new PhoneNumberDao();
    }

    public static Connection getConnection()
    {
        try {

            Class.forName(DBDRIVER);
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e1){
            e1.printStackTrace();
        }
        System.out.println("got context");
        System.out.println("About to get ds");

        return connection;
    }

    public static void closeConnection(Connection con)
    {
        if(con!=null)
        {
            try
            {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
