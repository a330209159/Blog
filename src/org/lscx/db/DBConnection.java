package org.lscx.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String Drvier = "com.mysql.jdbc.Driver";
    private static final String URL = "xxxxxxxxxxxx";
    private static final String USER = "xxxx";
    private static final String PASSWORD = "xxx";
    private Connection conn;

    public DBConnection() throws Exception {
        try{
            Class.forName(Drvier);
            this.conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (Exception e) {
            throw e;
        }
    }
    public Connection getConnection(){
        return this.conn;
    }
    public void close() throws SQLException {
        if(this.conn!=null){
            try{
                this.conn.close();
            } catch (SQLException e) {
                throw e;
            }
        }
    }
}
