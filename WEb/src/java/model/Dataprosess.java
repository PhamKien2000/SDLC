/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Song;
import entity.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=TuneSource";
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
 
    
    public Staff checkLogin(String user, String pass) {
        Staff stf = null;
        String sql = "SELECT * FROM tbStaff WHERE _user=? and _pass=?";
        Connection conn = getConnection();
        try {            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stf = new Staff();
                stf.setUser(user);
                stf.setPermisstion(rs.getString(7));
            }            
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprosess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stf;
    }

    public boolean addStaff(String id, String user, String pass, String address, String mail, String phone, String permisstion) {
        int f = 0;
        String sql = "INSERT INTO tbStaff VALUES (?,?,?,?,?,?,?)";
        Connection conn = getConnection();
        try {            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, user);
            ps.setString(3, pass);
            ps.setString(4, address);
            ps.setString(5, mail);
            ps.setString(6, phone);
            ps.setString(7, permisstion);
            f = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprosess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f > 0;
    }

    public boolean addSong(String id, String name, float Price, String sampleURL, String fulURL, String idCategory, String idSinger) {
        int f = 0;
        String sql = "INSERT INTO tbSong VALUES (?,?,?,?,?,?,?)";
        Connection conn = getConnection();
        try {            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setFloat(3, Price);
            ps.setString(4, sampleURL);
            ps.setString(5, fulURL);
            ps.setString(6, idCategory);
            ps.setString(7, idSinger);
            f = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprosess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f > 0;
    }

    public boolean addSinger(String id, String name, String Address, String email, String Phone) {
        int f = 0;
        String sql = "INSERT INTO tbSinger VALUES (?,?,?,?,?)";
        Connection conn = getConnection();
        try {            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, Address);
            ps.setString(4, email);
            ps.setString(5, Phone);
            f = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprosess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f > 0;
    }

    public boolean addCategory(String id, String name) {
        int f = 0;
        String sql = "INSERT INTO tbCategory VALUES (?,?)";
        Connection conn = getConnection();
        try {            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            f = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprosess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f > 0;
    }

    public boolean addBill(String id, String date, Float Price, String idStaff, String idSong) {
        int f = 0;
        String sql = "INSERT INTO tbSinger VALUES (?,?,?,?,?)";
        Connection conn = getConnection();
        try {            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, date);
            ps.setFloat(3, Price);
            ps.setString(4, idStaff);
            ps.setString(5, idSong);
            f = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprosess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f > 0;
    }
    
    public ArrayList<Staff> getStaff() {
        ArrayList<Staff> list = new ArrayList<Staff>();
        String sql = "SELECT * FROM tblStaff";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Staff s = new Staff();
                s.setId(rs.getString(1));
                s.setUser(rs.getString(2));
                s.setUser(rs.getString(3));
                s.setPass(rs.getString(4));
                s.setMail(rs.getString(5));
                s.setPhone(rs.getString(6));
                s.setPermisstion(rs.getString(7));
                list.add(s);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprosess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Song> getSong() {
        ArrayList<Song> list = new ArrayList<Song>();
        String sql = "Select * from tbSong  ";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Song s = new Song();
                s.setId(rs.getString(1));
                s.setName(rs.getString(2));
                s.setPrice(rs.getFloat(3));
                s.setSampleURL(rs.getString(4));
                s.setFulURL(rs.getString(5));
                s.setIdC(rs.getString(6));
                s.setIdSg(rs.getString(7));
                list.add(s);
            }            
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprosess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean delSong(String id) {
        int f = 0;
        String sql = "DELETE FROM tbSong WHERE _idSong=?";
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            
            f = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprosess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f > 0;
    }

    public Song getSongID(String id) {
        Song s = null;
        String sql = "Select * from tbSong where _idSong=?";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                s = new Song();
                s.setId(rs.getString(1));
                s.setName(rs.getString(2));
                s.setPrice(rs.getFloat(3));
                s.setSampleURL(rs.getString(4));
                s.setFulURL(rs.getString(5));
                s.setIdC(rs.getString(6));
                s.setIdSg(rs.getString(7));
            }            
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprosess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    public boolean updateSong(String id, String name, float price, String sampleURL, String fulURL, String idCategory, String idSinger) {
        int f = 0;
        String sql = "UPDATE tbSong SET _nameSong=?,_Price=?,_sampleURL=?,_fullURL=?,_idCategory=?,_idSinger=? WHERE _idSong=?";
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setFloat(2, price);
            ps.setString(3, sampleURL);
            ps.setString(4, fulURL);
            ps.setString(5, idCategory);
            ps.setString(6, idSinger);
            ps.setString(7, id);
            f = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprosess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f > 0;
    }
    

    
}
