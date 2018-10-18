/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pi3.five.servico;

import br.com.pi3.five.dao.LocacaoDAO;
import br.com.pi3.five.locacao.Locacao;
import br.com.pi3.five.validacao.ValidacaoLocacao;

/**
 *
 * @author Pichau
 */
public class ServicoLocacao {

    private LocacaoDAO dao = new LocacaoDAO();

    public String inserir(Locacao locacao) {

        String resposta = ValidacaoLocacao.validar(locacao);
        try {
            if (resposta == null) {
                dao.efetuarLocacao(locacao);
            }
        } catch (Exception e) {
            resposta = "Erro na fonte de dados";
        }

        return resposta;
    }

    public String atualizar(Locacao locacao) {

        String resposta = ValidacaoLocacao.validar(locacao);
        try {
            if (resposta == null) {
                dao.atualizarLocacao(locacao);
            }
        } catch (Exception e) {
            resposta = "Erro na fonte de dados";
        }
        return resposta;
    }
}
