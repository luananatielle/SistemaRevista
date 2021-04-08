/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.revista.dados;

import br.edu.ifnmg.poo.revista.modelo.RevistaCientifica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luana
 */
public class RevistaCientificaDAO {
    private static Map<String,RevistaCientifica> revistasCientificas= new HashMap();
    
    public static void adicionarRevista(RevistaCientifica revista){
        revistasCientificas.put(revista.getTitulo(), revista);
    }
    public static List<RevistaCientifica> buscarTodasRevistas(){
        return new ArrayList<>(revistasCientificas.values());
    }

    public static RevistaCientifica getRevista(String revista) {
        RevistaCientifica revistaCientifica= revistasCientificas.get(revista);
        return revistaCientifica;
    }
}
