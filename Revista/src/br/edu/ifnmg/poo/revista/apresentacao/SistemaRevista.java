/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.revista.apresentacao;

import br.edu.ifnmg.poo.revista.controle.ArtigoControlador;
import br.edu.ifnmg.poo.revista.controle.EdicaoControlador;
import br.edu.ifnmg.poo.revista.controle.RevistaCientificaControlador;
import br.edu.ifnmg.poo.revista.modelo.Artigo;
import br.edu.ifnmg.poo.revista.modelo.Edicao;
import br.edu.ifnmg.poo.revista.modelo.RevistaCientifica;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author luana
 */
public class SistemaRevista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int operacao=0;

        do{
            try{//menu
                System.out.println("\n\n ***Menu***");
                System.out.println("Operação:");
                System.out.println("1- Cadastrar Revista Cientifica:");
                System.out.println("2-Cadastrar Edição");
                System.out.println("3-Cadastrar Artigo");
                System.out.println("4-Mostrar todas revistas cientificas cadastradas:");
                System.out.println("5-Mostrar todas edições cadastradas:");
                System.out.println("6-Mostrar todos artigos cadastradas:");
                System.out.println("0-Sair");

                operacao= Integer.parseInt(scanner.nextLine());

                switch (operacao) {
                    case 1:
                        cadastrarRevistaCientifica(scanner);
                        break;
                    case 2:
                        cadastrarEdicao(scanner);
                        break;
                    case 3:
                        cadastrarArtigo(scanner);
                        break;
                    case 4:
                        mostrarRevistasCientificas();
                        break;
                    case 5:
                        mostrarEdicoes();
                        break;
                    case 6:
                        mostrarArtigos();
                        break;
                    default:
                        break;
                }
            }catch(NumberFormatException e){
                System.out.println("\nValor inválido!Tente novamente\n");
                operacao=-1;

            }
        }while(operacao !=0);
    }

    private static void cadastrarRevistaCientifica(Scanner scanner) {
        System.out.println("\n\n******Cadastro de Revista Científica******\n");
            
        System.out.println("Título: ");
        String titulo=scanner.nextLine();
        System.out.println("ISSN ");
        int issn=Integer.parseInt(scanner.nextLine());  
        System.out.println("Periodicidade: ");
        String periodicidade=scanner.nextLine();
        
        RevistaCientifica revista=new RevistaCientifica(titulo,issn,periodicidade);
        RevistaCientificaControlador revistaControlador=new RevistaCientificaControlador();
        revistaControlador.cadastrarRevistaCientifica(revista);
        
        System.out.println("Revista cadastrada com sucesso!");
    }

    private static void cadastrarEdicao(Scanner scanner) {
        System.out.println("\n\n******Cadastro de Edição******\n");
            
        System.out.println("Número: ");
        String numero=scanner.nextLine();   
        System.out.println("Volume: ");
        int volume=Integer.parseInt(scanner.nextLine());  
        Date data=null;
        int controlador=0;
        do{
            try{
                controlador=0;
                data=null;
                SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Data: DD/MM/AA");
                String dataEdicao=scanner.nextLine();
                data=format.parse(dataEdicao);
            }catch(ParseException e){
                System.out.println("Data inválida! O formato de ser: DD/MM/AA. Tente novamente:\n");
                controlador=1;
            }
        }while(controlador==1);
       
        RevistaCientifica revista=null;
        do{
            System.out.println("\nDigite o titulo da revista científica:\n");
            String titulo =scanner.nextLine();
            RevistaCientificaControlador revistaControlador =new RevistaCientificaControlador();
            revista= revistaControlador.buscarRevista(titulo);

            //verifica se existe instrutor, se não houver da opção para cadastrar
            if(revista==null){
                System.out.println("Revista científica não encontrada!Tente novamente:");
                controlador=1;
            }else controlador=0;
        }while(controlador==1);
        Edicao edicao=new Edicao(numero,volume,data,revista);
        EdicaoControlador edicaoControlador=new EdicaoControlador();
        edicaoControlador.cadastrarEdicao(edicao);
        
        System.out.println("Edicao cadastrada com sucesso!");
    }

    private static void cadastrarArtigo(Scanner scanner) {
        System.out.println("\n\n******Cadastro de Artigo******\n");
            
        System.out.println("Título: ");
        String titulo=scanner.nextLine();        
        System.out.println("Nome do autor: ");
        String autor=scanner.nextLine();     
        
        Edicao edicao=null;
        int controlador=0;
        do{
            System.out.println("\nDigite o número da edição:\n");
            String numero=scanner.nextLine();
            EdicaoControlador edicaoControlador =new EdicaoControlador();
            edicao= edicaoControlador.buscarEdicao(numero);

            //verifica se existe instrutor, se não houver da opção para cadastrar
            if(edicao==null){
                System.out.println("Edicao não encontrada!Tente novamente:");
                controlador=1;
            }else controlador=0;
        }while(controlador==1);
        
        Artigo artigo=new Artigo(titulo,autor,edicao);
        ArtigoControlador artigoControlador=new ArtigoControlador();
        artigoControlador.cadastrarArtigo(artigo);
      
        System.out.println("Arigo cadastrada com sucesso!");
    }

    private static void mostrarRevistasCientificas() {
        System.out.println("\nRevistas Científicas cadastradas\n");
        RevistaCientificaControlador revistaControlador= new RevistaCientificaControlador();
        List<RevistaCientifica> revistas=revistaControlador.buscarTodasRevistasCientificas();

        OrdenadorRevista ordenadorRevista=new OrdenadorRevista();
        Collections.sort(revistas,ordenadorRevista);
        System.out.println("Titulo  \t  ISSN  \t  Periodicidade");
        for(RevistaCientifica revista:revistas){
            System.out.println(revista.getTitulo()+ "\t " + revista.getIssn()+ "\t "+revista.getPeriodicidade());
        }
    }

    private static class OrdenadorRevista implements Comparator<RevistaCientifica> {

        @Override
        public int compare(RevistaCientifica revista1, RevistaCientifica revista2){
            return revista1.getTitulo().compareToIgnoreCase(revista2.getTitulo());
        }

    }
    
    private static void mostrarEdicoes() {
       System.out.println("\nEdições cadastradas\n");
        EdicaoControlador edicaoControlador= new EdicaoControlador();
        List<Edicao> edicoes=edicaoControlador.buscarTodasEdicoes();

        OrdenadorEdicao ordenadorEdicao=new OrdenadorEdicao();
        Collections.sort(edicoes,ordenadorEdicao);
        System.out.println("Data  \t  Número  \t  Volume");
        for(Edicao edicao:edicoes){
            System.out.println(edicao.getData()+ "\t "+ edicao.getNumero()+ "\t " + edicao.getVolume());
        }
    }
    private static class OrdenadorEdicao implements Comparator<Edicao> {

        @Override
        public int compare(Edicao edicao1, Edicao edicao2){
            return edicao1.getData().compareTo(edicao2.getData());
        }

    }
    
    private static void mostrarArtigos() {
        System.out.println("\nArtigos cadastradas\n");
        ArtigoControlador artigoControlador= new ArtigoControlador();
        List<Artigo> artigos= artigoControlador.buscarTodosArtigos();

        OrdenadorArtigo ordenadorArtigo=new OrdenadorArtigo();
        Collections.sort(artigos,ordenadorArtigo);
        System.out.println("Título  \t  Nome autor \t  Número da edicão");
        for(Artigo artigo:artigos){
            System.out.println(artigo.getTitulo()+ "\t "+ artigo.getNomeAutor()+ "\t " + artigo.getEdicao().getNumero());
        }
    }
    private static class OrdenadorArtigo implements Comparator<Artigo> {

        @Override
        public int compare(Artigo artigo1,Artigo artigo2){
            return artigo1.getTitulo().compareToIgnoreCase(artigo2.getTitulo());
        }     
    }
    
}
