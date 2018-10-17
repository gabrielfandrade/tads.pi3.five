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
    
    private Connection conn;
    private ResultSet rst;
    private PreparedStatement pst;
    private String sql;
    private StringBuilder result;
    private ArrayList<Veiculo> list;
    
    public CrudVeiculo(){
        setSql("");
        
        result = new StringBuilder();
    }
    
    public void adicionarVeiculo(Veiculo v)throws SQLException{
        try {
            conn = Connect.getConnection();
            
            setSql("INSERT INTO VEICULO (MODELO, CATEGORIA, ANO, PLACA, MARCA, "
                    + "NUMERODOC, CARACTERISTICAS, IMAGEM) VALUES "
                    + "(?,?,?,?,?,?,?,?)");
            
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, v.getModelo());
            pst.setString(2, v.getCategoria());
            pst.setDate(3, (Date) v.getAno());
            pst.setString(4, v.getPlaca());
            pst.setString(5, v.getMarca());
            pst.setInt(6, v.getNumeroDoc());
            pst.setString(7, v.getCaracter());
            pst.setObject(8, v.getImagem());
            
            pst.execute();
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na "
                    + "fonte de dados:\n"
                    + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }finally{
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
    }
    
    public ArrayList<Veiculo> listarTodosVeiculos()throws SQLException{
      Veiculo prt = new Veiculo();

        conn = Connect.getConnection();

        setSql("SELECT * FROM VEICULO");

        pst = conn.prepareStatement(sql);

        rst = pst.executeQuery();

        while (rst.next()) {
            if (list == null) {
                list = new ArrayList<>();
            }

            prt.setId(rst.getInt("IDVEICULO"));
            prt.setModelo(rst.getString("MODELO"));
            prt.setCategoria(rst.getString("CATEGORIA"));
            prt.setAno(rst.getDate("ANO"));
            prt.setPlaca(rst.getString("PLACA"));
            prt.setMarca(rst.getString("MARCA"));
            prt.setNumeroDoc(rst.getInt("NUMERODOC"));
            prt.setCaracter(rst.getString("CARACTERISTICAS"));
            prt.setImagem((File) rst.getObject("IMAGEM"));

            setAddList(prt);

        }

        return getList();  
    }
    
    public ArrayList<Veiculo> listarVeiculos(String att, String busca)throws SQLException{
      Veiculo prt = new Veiculo();

        conn = Connect.getConnection();

        setSql("SELECT * FROM VEICULO WHERE (?=?)");

        pst = conn.prepareStatement(sql);
        pst.setString(1, att); 
        pst.setString(2, busca);

        rst = pst.executeQuery();

        while (rst.next()) {
            if (list == null) {
                list = new ArrayList<>();
            }

            prt.setId(rst.getInt("IDVEICULO"));
            prt.setModelo(rst.getString("MODELO"));
            prt.setCategoria(rst.getString("CATEGORIA"));
            prt.setAno(rst.getDate("ANO"));
            prt.setPlaca(rst.getString("PLACA"));
            prt.setMarca(rst.getString("MARCA"));
            prt.setNumeroDoc(rst.getInt("NUMERODOC"));
            prt.setCaracter(rst.getString("CARACTERISTICAS"));
            prt.setImagem((File) rst.getObject("IMAGEM"));

            setAddList(prt);

        }

        return getList();  
    }
    
    public void atualizarVeiculo(Veiculo v)throws SQLException{
        try {
            conn = Connect.getConnection();
            
            setSql("UPDATE VEICULO SET MODELO=?, CATEGORIA=?,"
                    + " ANO=?, PLACA=?, MARCA=?, "
                    + "NUMERODOC=?, CARACTERISTICAS=?, IMAGEM=? "
                    + "WHERE (IDVEICULO=?) ");
            
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, v.getModelo());
            pst.setString(2, v.getCategoria());
            pst.setDate(3, (Date) v.getAno());
            pst.setString(4, v.getPlaca());
            pst.setString(5, v.getMarca());
            pst.setInt(6, v.getNumeroDoc());
            pst.setString(7, v.getCaracter());
            pst.setObject(8, v.getImagem());
            pst.setInt(9, v.getId());
            
            pst.execute();
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na "
                    + "fonte de dados:\n"
                    + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }finally{
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
    }
    
    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public ArrayList<Veiculo> getList() {
        return this.list;
    }

    public void setList(ArrayList<Veiculo> list) {
        this.list = list;
    }

    public void setAddList(Veiculo prt) {
        this.list.add(prt);
    }
    
}
