/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.revista.dados;

import br.edu.ifnmg.poo.revista.modelo.Artigo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luana
 */
public class ArtigoDAO {
    private static Map<String,Artigo> artigos= new HashMap();
    
    public static void adicionarArtigo(Artigo artigo){
        artigos.put(artigo.getTitulo(), artigo);
    }
    public static List<Artigo> buscarTodosArtigos(){
        return new ArrayList<>(artigos.values());
    }
}
