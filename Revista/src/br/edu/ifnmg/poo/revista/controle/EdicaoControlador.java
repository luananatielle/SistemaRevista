/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.revista.controle;

import br.edu.ifnmg.poo.revista.dados.EdicaoDAO;
import br.edu.ifnmg.poo.revista.modelo.Edicao;
import java.util.List;

/**
 *
 * @author luana
 */
public class EdicaoControlador {
    public void cadastrarEdicao(Edicao edicao){
        EdicaoDAO.adicionarEdicao(edicao);
    }

    public List<Edicao> buscarTodasEdicoes(){
        return EdicaoDAO.buscarTodasEdicoes();
    }

    public Edicao buscarEdicao(String numero) {
        return EdicaoDAO.getEdicao(numero);
    }
}
