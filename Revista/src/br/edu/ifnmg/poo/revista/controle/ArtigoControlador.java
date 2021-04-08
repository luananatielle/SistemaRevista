/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.revista.controle;

import br.edu.ifnmg.poo.revista.dados.ArtigoDAO;
import br.edu.ifnmg.poo.revista.modelo.Artigo;
import java.util.List;

/**
 *
 * @author luana
 */
public class ArtigoControlador {
    public void cadastrarArtigo(Artigo artigo){
        ArtigoDAO.adicionarArtigo(artigo);
    }

    public List<Artigo> buscarTodosArtigos(){
        return ArtigoDAO.buscarTodosArtigos();
    }
}
