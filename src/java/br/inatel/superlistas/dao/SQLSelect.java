/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.superlistas.dao;

import br.inatel.superlistas.model.Lista;
import br.inatel.superlistas.model.Produto;
import br.inatel.superlistas.model.User;
import java.sql.Connection;
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
public class SQLSelect {

    private SQLConnection mSQLConnection;

    private static final String SQL_SELECT_LISTAS = "select * from lista";
    private static final String SQL_SELECT_PRODUTO_BY_ID = "select * from produto "
            + "where lista_idLista = ?";
    private static final String SQL_SELECT_USER_BY_EMAIL = "select * from user "
            + "where email = ?";

    public List<Lista> getListas() {

        mSQLConnection = SQLConnection.getInstance();
        Connection conn = mSQLConnection.getMySQLConnetion();

        ArrayList<Lista> result = new ArrayList<>();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(SQL_SELECT_LISTAS);
            rs = pstmt.executeQuery();

            while (rs != null && rs.next()) {
                int id = rs.getInt("idLista");
                String nome = rs.getString("nomeLista");
                Lista lista = new Lista(id, nome);
                result.add(lista);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLSelect.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
            mSQLConnection.closeConnection(pstmt, rs);
        }

        return result;
    }

    public List<Produto> getProdutoById(int idLista) {

        mSQLConnection = SQLConnection.getInstance();
        Connection conn = mSQLConnection.getMySQLConnetion();

        ArrayList<Produto> result = new ArrayList<>();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(SQL_SELECT_PRODUTO_BY_ID);
            pstmt.setInt(1, idLista);
            rs = pstmt.executeQuery();

            while (rs != null && rs.next()) {
                int id = rs.getInt("idProduto");
                String nome = rs.getString("nomeProduto");
                int qnt = rs.getInt("qntProduto");
                float valor = rs.getFloat("valorProduto");
                Produto produto = new Produto(id, nome, qnt, valor);
                result.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLSelect.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
            mSQLConnection.closeConnection(pstmt, rs);
        }

        return result;
    }
    
    public User getUserByEmail(String email) {
        mSQLConnection = SQLConnection.getInstance();
        Connection conn = mSQLConnection.getMySQLConnetion();

        User user = null;

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            pstmt = conn.prepareStatement(SQL_SELECT_PRODUTO_BY_ID);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            while (rs != null && rs.next()) {
                int id = rs.getInt("iduser");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                user = new User(nome, email, senha);
                user.setIdUser(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLSelect.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
            mSQLConnection.closeConnection(pstmt, rs);
        }
        
        return user;
    }

}
