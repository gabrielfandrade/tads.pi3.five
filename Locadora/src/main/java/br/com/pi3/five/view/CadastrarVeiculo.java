/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pi3.five.view;

import br.com.pi3.five.servico.ServicoVeiculo;
import br.com.pi3.five.veiculo.Veiculo;
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
 * @author Pichau
 */
@WebServlet(name = "CadastrarVeiculo", urlPatterns = {"/cadastrarVeiculo"})
public class CadastrarVeiculo {

    public class Cadastrar extends HttpServlet {

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

            Veiculo veiculo = new Veiculo(
                    request.getParameter("modelo"),
                    request.getParameter("categoria"),
                    Date.valueOf(request.getParameter("ano")),
                    request.getParameter("placa"),
                    request.getParameter("marca"),
                    Integer.parseInt(request.getParameter("ndocumento")),
                    request.getParameter("caracteristicas"),
                    (File) request.getAttribute("imagem"));

            ServicoVeiculo v = new ServicoVeiculo();
            String log = v.inserir(veiculo);

            request.setAttribute("result", "Ocorreu tudo bem\n" + "<br>" + log);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("index.jsp");

            dispatcher.forward(request, response);
        }
    }
}
