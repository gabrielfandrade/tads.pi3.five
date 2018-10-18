/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pi3.five.servico;

import br.com.pi3.five.dao.VeiculoDAO;
import br.com.pi3.five.validacao.ValidacaoVeiculo;
import br.com.pi3.five.veiculo.Veiculo;

/**
 *
 * @author Pichau
 */
public class ServicoVeiculo {

    private VeiculoDAO dao = new VeiculoDAO();

    public String inserir(Veiculo veiculo) {

        String resposta = ValidacaoVeiculo.validar(veiculo);
        try {
            if (resposta == null) {
                dao.adicionarVeiculo(veiculo);
            }
        } catch (Exception e) {
            resposta = "Erro na fonte de dados";
        }

        return resposta;
    }

    public String atualizar(Veiculo veiculo) {
        
        String resposta = ValidacaoVeiculo.validar(veiculo);
        try {
            if (resposta == null) {
                dao.atualizarVeiculo(veiculo);
            }
        } catch (Exception e) {
            resposta = "Erro na fonte de dados";
        }
        return resposta;
    }
}
