/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.revista.modelo;

import java.util.Date;

/**
 *
 * @author luana
 */
public class Edicao {
    private String numero;
    private int volume;
    private Date data;
    
    private RevistaCientifica revistaCientifica;
    
    public Edicao(String numero, int volume, Date data, RevistaCientifica revista){
        this.numero=numero;
        this.volume=volume;
        this.data=data;
        this.revistaCientifica=revista;
    }

    public String getNumero() {
        return numero;
    }

    public int getVolume() {
        return volume;
    }

    public Date getData() {
        return data;
    }

    public RevistaCientifica getRevistaCientifica() {
        return revistaCientifica;
    }
    
    
}
