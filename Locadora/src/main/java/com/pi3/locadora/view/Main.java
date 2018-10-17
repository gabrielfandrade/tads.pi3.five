/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi3.locadora.view;

import com.pi3.locadora.veiculo.Veiculo;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabriel.fandrade
 */
@WebServlet(name = "Locadora", urlPatterns = {"/main"})

public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("CadastrarVeiculo.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(request.getParameter("modelo"));
        veiculo.setCategoria(request.getParameter("categoria"));
        veiculo.setAno(Date.valueOf(request.getParameter("ano")));
        veiculo.setCaracter(request.getParameter("caracter"));
        veiculo.setPlaca(request.getParameter("placa"));
        veiculo.setMarca(request.getParameter("marca"));
        veiculo.setNumeroDoc(Integer.parseInt(request.getParameter("ndocumento")));
        File file = new File(request.getParameter("imagem"));
        veiculo.setImagem(file);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("CadastrarVeiculo.jsp");
        
        dispatcher.forward(request, response);
    }
}
