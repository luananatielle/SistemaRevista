/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.revista.controle;

import br.edu.ifnmg.poo.revista.dados.RevistaCientificaDAO;
import br.edu.ifnmg.poo.revista.modelo.RevistaCientifica;
import java.util.List;

/**
 *
 * @author luana
 */
public class RevistaCientificaControlador {
    public void cadastrarRevistaCientifica(RevistaCientifica revistaCientifica){
        RevistaCientificaDAO.adicionarRevista(revistaCientifica);
    }

    public List<RevistaCientifica> buscarTodasRevistasCientificas(){
        return RevistaCientificaDAO.buscarTodasRevistas();
    }

    public RevistaCientifica buscarRevista(String revista) {
        RevistaCientifica revistaRecuperada = RevistaCientificaDAO.getRevista(revista);
        return revistaRecuperada;   
    }
    

}
