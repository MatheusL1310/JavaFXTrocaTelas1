/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtrocatelas1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private int identificadorNoArquivo;

    
    
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
        ArrayList<Avaliacao> listaConteudoTabela = new ArrayList<>();
        Avaliacao a;
        try {
            FileReader leitor = new FileReader("ListaProvas.csv");
            BufferedReader leitorLin = new BufferedReader(leitor);
            int cont = 0;
            while (leitorLin.ready()) {                
                a = new Avaliacao(); 
                String linha = leitorLin.readLine();                
                String[] array = linha.split(",+");
                a.disciplina = array[0];
                a.media = array[1].toCharArray();
                a.nome = array[2];
                a.peso = Double.parseDouble(array[3]);
                if(array.length > 4)
                    a.nota = Double.parseDouble(array[4]);
                a.identificadorNoArquivo = cont;
                listaConteudoTabela.add(a);     
                cont++;
            }
            leitorLin.close();
            leitor.close();
        } catch (Exception e) {
            System.out.println(e);
        }                   
       return listaConteudoTabela;
    }
    
   
    public static double calculaMediaDaDisciplina(String disciplina, char[] media){
        ArrayList<Avaliacao> listaAvaliacoes = obterListaAvaliacoes();
        Avaliacao a1 = new Avaliacao();
        Double m = 0.0;
        Double peso = 0.0;
        for(int i = 0;i<listaAvaliacoes.size();i++){
            a1 = listaAvaliacoes.get(i);
            if(a1.disciplina.equals(disciplina) && Arrays.equals(a1.media, media)){
                m += (a1.nota*a1.peso);
                peso += a1.peso;
            }            
           
        }
        return m/peso;
        
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
    
    public int getIdentificadorNoArquivo() {
        return identificadorNoArquivo;
    }

    public void setIdentificadorNoArquivo(int identificadorNoArquivo) {
        this.identificadorNoArquivo = identificadorNoArquivo;
    }


    public void salvar() throws IOException{
         File arquivo1 = new File("ListaProvas.csv");
        if(!arquivo1.exists()){
            arquivo1.createNewFile();
        }
        FileWriter escritor = new FileWriter(arquivo1, true);
        
        BufferedWriter gravador = new BufferedWriter(escritor);
        
        gravador.write(getDisciplina()+","+String.valueOf(getMedia())+","+getNome()+","+getPeso());
        gravador.newLine();
        
        gravador.close();
        escritor.close();
        
        Tela2FXMLController tela2 = new Tela2FXMLController();
        GerenciadorJanela.obterInstancia().pilhaRetorno.pop();
        GerenciadorJanela.obterInstancia().abreJanela(tela2);
        GerenciadorJanela.obterInstancia().pilhaRetorno.pop();
    } 
    
    public void atualizar() throws IOException{
        Path path = Paths.get("ListaProvas.csv");
        List<String> linhas = Files.readAllLines(path);

        String novoConteudo = linhas.get(identificadorNoArquivo).substring(0, linhas.get(identificadorNoArquivo).length()) +","+getNota();
        linhas.remove(identificadorNoArquivo);
        linhas.add(identificadorNoArquivo, novoConteudo);

        Files.write(path, linhas);
        
        Tela2FXMLController tela2 = new Tela2FXMLController();
        GerenciadorJanela.obterInstancia().pilhaRetorno.pop();
        GerenciadorJanela.obterInstancia().abreJanela(tela2);
        GerenciadorJanela.obterInstancia().pilhaRetorno.pop();        
    }
        
    


}

