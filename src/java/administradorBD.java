/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jsoto
 */
public class administradorBD {

/*private Connection conn;
private boolean estadoOrden;

    public administradorBD() {
        setEstadoOrden(false);
    }

    public administradorBD(Connection conn) {
        setConn(conn);
        setEstadoOrden(false);
        * 
        * 
        * 
        *
        * 
    }*/

 /*
  public Connection conectar(){

      try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(administradorBD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(administradorBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(administradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //setConn((Connection) DriverManager.getConnection("jdbc:mysql://localhost/inventario", "root", "databasepccrlocal"));
            setConn((Connection) DriverManager.getConnection("jdbc:mysql://localhost/inventario", "root", "admin"));
            //System.out.print("se conecto a la bd");
        } catch (SQLException ex) {
            Logger.getLogger(administradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

      if (getConn() != null) {/*? si esta conectado
        return getConn();
        }else{
        return null;
        }

  } 
  */

} // fin clase
