/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;
import java.sql.*;

/**
 *
 * @author Mapina
 */
public class Conexion {
    
    public static final String URL = "jdbc:mysql://localhost/tattoo_studio_db";
    public static final String USERNAME = "babayaga";
    public static final String PASSWORD = "";
    
    public static Connection getConnection(){
        Connection cn = null;
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch(Exception e){
            e.getMessage();
        }
        return cn;
    }
}
