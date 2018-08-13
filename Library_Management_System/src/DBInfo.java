import java.sql.Connection;
import java.sql.DriverManager;


public class DBInfo
{
    static 
    {
    	// load the drivers 
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static Connection DBConnect()
    {
    Connection con = null ;
    try 
    {
    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system","root","oracle");
    }
    catch  (Exception e)
    {
    	e.printStackTrace();
    }
    return con;
    }
}