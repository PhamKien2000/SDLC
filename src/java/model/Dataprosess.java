/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kienv
 */
public class Dataprosess {
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user = "sa";
            String pass = "123456";
            String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Scenario";
            try {
                conn = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(Dataprosess.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dataprosess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
        
    }
    public static void main(String[] args) {
        new Dataprosess().getConnection();
    }
    
}
