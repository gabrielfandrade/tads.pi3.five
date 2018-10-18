/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pi3.five.dao;

import br.com.pi3.five.locacao.Locacao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pichau
 */
public class LocacaoDAO {

    public LocacaoDAO() {

    }

    public void efetuarLocacao(Locacao l) throws SQLException {

        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;

        try {

            String sql = "INSERT INTO LOCACAO (IDCLIENTE, "
                    + "IDFUNCIONARIO, IDVEICULO, CODIGO, PROTECAO, "
                    + "PRECO_TOTAL, DIARETIRA, DIAENTREGA) VALUES "
                    + "(?,?,?,?,?,?,?,?)";

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, Integer.parseInt(l.getIdCliente()));
            stmt.setInt(2, Integer.parseInt(l.getIdFuncionario()));
            stmt.setInt(3, Integer.parseInt(l.getIdVeiculo()));
            stmt.setString(4, l.getCodigo());
            stmt.setString(5, l.getProtecao());
            stmt.setDouble(6, Double.parseDouble(l.getPrecoTotal()));
            stmt.setDate(7, Date.valueOf(l.getDiaRetira()));
            stmt.setDate(8, Date.valueOf(l.getDiaEntrega()));

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"
                    + e);
        } finally {
            Connect.closeConnection(conn, stmt);
        }
    }

    public ArrayList<Locacao> ApresentarTodasLocacoes() throws SQLException {

        Connection conn = Connect.getConnection();

        PreparedStatement stmt = null;

        ResultSet rst = null;

        ArrayList<Locacao> locacoes = new ArrayList<>();

        String sql = "SELECT * FROM LOCACAO";

        try {

            stmt = conn.prepareStatement(sql);
            rst = stmt.executeQuery();
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

            while (rst.next()) {

                Locacao l = new Locacao();

                l.setId(Integer.toString(rst.getInt("IDLOCACAO")));
                l.setIdCliente(Integer.toString(rst.getInt("IDCLIENTE")));
                l.setIdFuncionario(Integer.toString(rst.getInt("IDFUNCIONARIO")));
                l.setIdVeiculo(Integer.toString(rst.getInt("IDVEICULO")));
                l.setCodigo(rst.getString("CODIGO"));
                l.setProtecao(rst.getString("PROTECAO"));
                l.setPrecoTotal(Double.toString(rst.getDouble("PRECO_TOTAL")));
                l.setDiaRetira(fmt.format(rst.getDate("DIARETIRA")));
                l.setDiaEntrega(fmt.format(rst.getDate("DIAENTREGA")));

                locacoes.add(l);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"
                    + e);
        } finally {
            Connect.closeConnection(conn, stmt, rst);
        }

        return locacoes;
    }

    public ArrayList<Locacao> ApresentarLocacoes(String att, String busca) throws SQLException {
        Connection conn = Connect.getConnection();

        PreparedStatement stmt = null;

        ResultSet rst = null;

        ArrayList<Locacao> locacoes = new ArrayList<>();

        String sql = "SELECT * FROM VEICULO WHERE (?=?)";
        
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

        try {

            stmt = conn.prepareStatement(sql);

            //tratar condições//
            rst = stmt.executeQuery();

            while (rst.next()) {

                Locacao l = new Locacao();

                l.setId(Integer.toString(rst.getInt("IDLOCACAO")));
                l.setIdCliente(Integer.toString(rst.getInt("IDCLIENTE")));
                l.setIdFuncionario(Integer.toString(rst.getInt("IDFUNCIONARIO")));
                l.setIdVeiculo(Integer.toString(rst.getInt("IDVEICULO")));
                l.setCodigo(rst.getString("CODIGO"));
                l.setProtecao(rst.getString("PROTECAO"));
                l.setPrecoTotal(Double.toString(rst.getDouble("PRECO_TOTAL")));
                l.setDiaRetira(fmt.format(rst.getDate("DIARETIRA")));
                l.setDiaEntrega(fmt.format(rst.getDate("DIAENTREGA")));

                locacoes.add(l);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"
                    + e);
        } finally {
            Connect.closeConnection(conn, stmt, rst);
        }

        return locacoes;
    }

    public void atualizarLocacao(Locacao l) throws SQLException {
        String sql = "UPDATE VEICULO SET IDCLIENTE=?, IDFUNCIONARIO=?,"
                + " IDVEICULO=?, CODIGO=?, PROTECAO=?, "
                + "PRECO_TOTAL=?, DIARETIRA=?, DIAENTREGA=? "
                + "WHERE (IDLOCACAO=?)";
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, Integer.parseInt(l.getIdCliente()));
            stmt.setInt(2, Integer.parseInt(l.getIdFuncionario()));
            stmt.setInt(3, Integer.parseInt(l.getIdVeiculo()));
            stmt.setString(4, l.getCodigo());
            stmt.setString(5, l.getProtecao());
            stmt.setDouble(6, Double.parseDouble(l.getPrecoTotal()));
            stmt.setDate(7, Date.valueOf(l.getDiaRetira()));
            stmt.setDate(8, Date.valueOf(l.getDiaEntrega()));
            stmt.setInt(9, Integer.parseInt(l.getId()));

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"
                    + e);
        } finally {
            Connect.closeConnection(conn, stmt);
        }
    }
}
