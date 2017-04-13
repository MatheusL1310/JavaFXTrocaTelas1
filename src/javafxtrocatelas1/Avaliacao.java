/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtrocatelas1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author matheus
 */
public class Avaliacao{
    
    private String nome;
    private String disciplina;
    private char[] media;
    private Double peso;
    private Double nota;
    
    public Avaliacao(){
        
    }
   
    public Avaliacao(String nome, String disciplina, char[] media, Double peso, Double nota){
        this.nome = nome;
        this.disciplina = disciplina;
        this.media = media;
        this.peso = peso;
        this.nota = nota;
    }
    
    public static ArrayList<Avaliacao> obterListaAvaliacoes(){
        ArrayList<Avaliacao> listaConteudoTabela = null;
        Avaliacao a;
        try {
            FileReader leitor = new FileReader("ListaProvas.csv");
            BufferedReader leitorLin = new BufferedReader(leitor);
            
            while (leitorLin.ready()) {
                a = null;
                String linha = leitorLin.readLine();                
                String[] array = linha.split(",+");
                a.disciplina = array[0];
                a.media[0] = array[1].charAt(0);
                a.media[1] = array[1].charAt(1);
                a.nome = array[2];
                a.peso = Double.parseDouble(array[3]);
                if(array[4]!= null)
                    a.nota = Double.parseDouble(array[4]);
                listaConteudoTabela.add(a);
                /*for(String result:array)                                           
                        System.out.println(result); */                                    
                //listaConteudoTabela = new Avaliacao(linha); 
            }
            leitorLin.close();
            leitor.close();
        } catch (Exception e) {
            System.out.println(e);
        }            
       return listaConteudoTabela;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public char[] getMedia() {
        return media;
    }

    public void setMedia(char[] media) {
        this.media = media;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
