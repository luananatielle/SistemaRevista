/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.revista.modelo;

/**
 *
 * @author luana
 */
public class RevistaCientifica {
    
    private String titulo;
    private int issn; 
    private String periodicidade;
    
    public RevistaCientifica(String titulo, int issn, String periodicidade){
        this.titulo=titulo;
        this.issn=issn;
        this.periodicidade=periodicidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getIssn() {
        return issn;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }
    
}
