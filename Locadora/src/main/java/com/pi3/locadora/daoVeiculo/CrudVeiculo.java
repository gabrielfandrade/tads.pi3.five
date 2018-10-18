/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.daoVeiculo;

import com.pi3.locadora.dao.Connect;
import com.pi3.locadora.veiculo.Veiculo;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pichau
 */
public class CrudVeiculo {

    public void adicionarVeiculo(Veiculo v) throws SQLException {

        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;

        try {

            String sql = "INSERT INTO VEICULO (MODELO, CATEGORIA, ANO, PLACA, MARCA, "
                    + "NUMERODOC, CARACTERISTICAS, IMAGEM) VALUES "
                    + "(?,?,?,?,?,?,?,?)";

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getCategoria());
            stmt.setDate(3, (Date) v.getAno());
            stmt.setString(4, v.getPlaca());
            stmt.setString(5, v.getMarca());
            stmt.setInt(6, v.getNumeroDoc());
            stmt.setString(7, v.getCaracter());
            stmt.setObject(8, v.getImagem());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"
                    + e);
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
    }

    public ArrayList<Veiculo> ApresentarTodosVeiculos() throws SQLException {

        Connection conn = Connect.getConnection();

        PreparedStatement stmt = null;

        ResultSet rst = null;

        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        String sql = "SELECT * FROM VEICULO";

        try {
            
            stmt = conn.prepareStatement(sql);
            rst = stmt.executeQuery();

            while (rst.next()) {
                
                Veiculo v = new Veiculo();

                v.setId(rst.getInt("IDVEICULO"));
                v.setModelo(rst.getString("MODELO"));
                v.setCategoria(rst.getString("CATEGORIA"));
                v.setAno(rst.getDate("ANO"));
                v.setPlaca(rst.getString("PLACA"));
                v.setMarca(rst.getString("MARCA"));
                v.setNumeroDoc(rst.getInt("NUMERODOC"));
                v.setCaracter(rst.getString("CARACTERISTICAS"));
                v.setImagem((File) rst.getObject("IMAGEM"));

                veiculos.add(v);

            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"
                    + e);
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }

        return veiculos;
    }

    public ArrayList<Veiculo> ApresentarVeiculos(String att, String busca) throws SQLException {
        Connection conn = Connect.getConnection();

        PreparedStatement stmt = null;

        ResultSet rst = null;

        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        String sql = "SELECT * FROM VEICULO WHERE (?=?)";

        try {
            
            stmt = conn.prepareStatement(sql);
            
            //tratar condições//
            
            rst = stmt.executeQuery();

            while (rst.next()) {
                
                Veiculo v = new Veiculo();

                v.setId(rst.getInt("IDVEICULO"));
                v.setModelo(rst.getString("MODELO"));
                v.setCategoria(rst.getString("CATEGORIA"));
                v.setAno(rst.getDate("ANO"));
                v.setPlaca(rst.getString("PLACA"));
                v.setMarca(rst.getString("MARCA"));
                v.setNumeroDoc(rst.getInt("NUMERODOC"));
                v.setCaracter(rst.getString("CARACTERISTICAS"));
                v.setImagem((File) rst.getObject("IMAGEM"));

                veiculos.add(v);

            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"
                    + e);
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }

        return veiculos;
    }

    public void atualizarVeiculo(Veiculo v) throws SQLException {
        String sql = "UPDATE VEICULO SET MODELO=?, CATEGORIA=?,"
                    + " ANO=?, PLACA=?, MARCA=?, "
                    + "NUMERODOC=?, CARACTERISTICAS=?, IMAGEM=? "
                    + "WHERE (IDVEICULO=?)";
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getCategoria());
            stmt.setDate(3, (Date) v.getAno());
            stmt.setString(4, v.getPlaca());
            stmt.setString(5, v.getMarca());
            stmt.setInt(6, v.getNumeroDoc());
            stmt.setString(7, v.getCaracter());
            stmt.setObject(8, v.getImagem());
            stmt.setInt(9, v.getId());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"
                    + e);
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
    }
}
