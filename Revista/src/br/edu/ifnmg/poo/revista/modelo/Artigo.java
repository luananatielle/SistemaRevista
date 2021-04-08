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
public class Artigo {
    private String titulo;
    private String nomeAutor;
    private int qtdArtigos=0;
    private Edicao edicao;
    
    public Artigo(String titulo, String autor, Edicao edicao){
        this.titulo=titulo;
        this.nomeAutor=autor;
        this.edicao=edicao;
        this.qtdArtigos++;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public int getQtdArtigos() {
        return qtdArtigos;
    }

    public Edicao getEdicao() {
        return edicao;
    }
    
    
    
}
