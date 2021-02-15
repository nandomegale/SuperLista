/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.superlistas.dao;

import br.inatel.superlistas.model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MatheusdeOliveiraCam
 */
public class SQLConnection {

    private final String USER_NAME = "root";
    private final String PASSWORD = "root";
    private final String DB_NAME = "jdbc:mysql://127.0.0.1:3306/"
            + "mydb?autoReconnect=true&useSSL=false";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    private Connection mConn;
    private static SQLConnection mSqlConnection;
    
    public static void main(String[] args) {
        SQLSelect select = new SQLSelect();
        List<Produto> produtos = select.getProdutoById(2);
        
        produtos.forEach((produto) -> {
            System.out.println(produto.getNome());
        });
    }
    
    public static SQLConnection getInstance () {
        if (mSqlConnection == null) {
            mSqlConnection = new SQLConnection();
        }
        
        return mSqlConnection;
    }

    public Connection getMySQLConnetion() {

        try {
            if (mConn == null || mConn.isClosed()) {
                try {
                    Class.forName(DRIVER);
                    mConn = DriverManager.getConnection(DB_NAME, USER_NAME,
                            PASSWORD);
                    return mConn;
                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println("Erro:");
                    System.err.println(e.getMessage());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void closeConnection (PreparedStatement pstmt, ResultSet rs) {
        
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(SQLConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
        
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(SQLConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } 
        
        if (mConn != null) {
            try {
                mConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SQLConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
