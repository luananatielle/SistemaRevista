/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.revista.dados;

import br.edu.ifnmg.poo.revista.modelo.Edicao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luana
 */
public class EdicaoDAO {
    private static Map<String,Edicao> edicoes= new HashMap();
    
    public static void adicionarEdicao(Edicao edicao){
        edicoes.put(edicao.getNumero(), edicao);
    }
    public static List<Edicao> buscarTodasEdicoes(){
        return new ArrayList<>(edicoes.values());
    }

    public static Edicao getEdicao(String numero) {
        Edicao edicao=edicoes.get(numero);
        return edicao;
    }
}
