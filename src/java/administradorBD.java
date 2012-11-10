
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class administradorBD {

    private final String URL = "jdbc:mysql://localhost:3306/test";
    private final String USER = "roger";
    private final String PASSWORD = "toast";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private Connection conn;
    private static administradorBD singleton;
    public static final String SELECT_STRING = "";

    private administradorBD() {
    }

    public static administradorBD getInstance() {
        if (singleton == null) {
            singleton = new administradorBD();
        }
        return singleton;
    }

    private Connection getConnection(boolean resetConnection) throws Exception {
        if (resetConnection) {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } else {
            if (conn == null) {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        }
        return conn;
    }

    public ResultSet selectQuery(String p_query, Properties p_parameters) throws Exception {
        PreparedStatement s = getConnection(false).prepareStatement("");
        String whereClause="";
        if (p_parameters != null) {
            int index = 1;
            whereClause = " WHERE ";
            for (String key : p_parameters.stringPropertyNames()) {
                String value = p_parameters.getProperty(key);
                whereClause +=key+"=? AND";
                s.setString(index, value);
                index++;
            }
            whereClause = whereClause.substring(0, whereClause.length()-4);
        }
        ResultSet rs = s.executeQuery(p_query+whereClause);
        return rs;
    }
    
    public boolean updateQuery(String p_query, String p_table, Properties p_parameters) throws Exception
    {
        PreparedStatement s = getConnection(false).prepareStatement("");
        String whereClause="";
        if (p_parameters != null) {
            int index = 1;
            whereClause = " WHERE ";
            for (String key : p_parameters.stringPropertyNames()) {
                String value = p_parameters.getProperty(key);
                whereClause +=key+"=? AND";
                s.setString(index, value);
                index++;
            }
            whereClause = whereClause.substring(0, whereClause.length()-4);
        }
        return s.execute(p_query+whereClause);
    }
    
    public boolean insertQuery(String p_query, String[] p_parameters) throws Exception {
        PreparedStatement s = getConnection(false).prepareStatement("");
        if (p_parameters != null) {
            int index = 1;
            for (String value : p_parameters) {
                s.setString(index, value);
                index++;
            }
        }
        return s.execute(p_query);
    }
    
    public boolean deleteQuery(String p_table, String p_id) throws Exception {
        String query=String.format("DELETE FROM %s WHERE %s_ID=%s",p_table, p_table, p_id);
        PreparedStatement s = getConnection(false).prepareStatement(query);
        return s.execute();
    }
    
}
