/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pi3.five.dao;

import br.com.pi3.five.veiculo.Veiculo;
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
public class VeiculoDAO {
    
    public VeiculoDAO(){
    
    }

    public String adicionarVeiculo(Veiculo v) throws SQLException {

        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;
        
        String log = "";

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
            log = e.toString();
        } finally {
            Connect.closeConnection(conn, stmt);
        }
        
        return log;
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
            Connect.closeConnection(conn, stmt, rst);
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
            Connect.closeConnection(conn, stmt, rst);
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

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar os dados"
                    + e);
        } finally {
            Connect.closeConnection(conn, stmt);
        }
    }
    
    public void excluir(int id){
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;
        String sql = "DELETE FROM VEICULO WHERE (IDVEICULO=?)";
        
        try{
        
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro ao atualizar" + e);
        }finally{
            Connect.closeConnection(conn, stmt);
        }
    }
}
