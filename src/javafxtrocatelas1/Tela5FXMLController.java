/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtrocatelas1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author matheus
 */
public class Tela5FXMLController extends InterfaceUsuario {

    public Tela5FXMLController(){
        super("Tela5FXML.fxml");
    }
    
    @FXML
    private AnchorPane elementoRaiz;

    @FXML
    private TextField campoNome, campoPeso;

    @FXML
    private ChoiceBox<String> campoDisciplina, campoMedia;

    @FXML
    private Button voltaTela2, salvaTela5;
    
    ObservableList<String> listaDisciplinas = FXCollections.observableArrayList("[1]ÉTICA EM INFORMÁTICA", "[1]MATEMÁTICA COMPUTACIONAL", "[1]ALGORITMOS E PROGRAMAÇÃO", "[1]ÁLGEBRA", "[1]INTRODUÇÃO AO CÁLCULO", "[1]INICIAÇÃO TÉCNICO-CIENTÍFICA", "[1]INTRODUÇÃO A ENGENHARIA DE COMPUTAÇÃO", "[1]INTRODUÇÃO À FÍSICA",
    "[2]CÁLCULO", "[2]ALGORITMOS E PROGRAMAÇÃO", "[2]CIRCUITOS DIGITAIS", "[2]DESENHO TÉCNICO", "[2]FÍSICA GERAL", "[2]ÁLGEBRA", "[3]CÁLCULO", "[3]ESTRUTURAS DE DADOS", "[3]PROGRAMAÇÃO ORIENTADA A OBJETOS", "[3]ARQUITETURA DE COMPUTADORES", "[3]FÍSICA", "[3]QUÍMICA",
    "[4]ARQUITETURA DE COMPUTADORES", "[4]PROGRAMAÇÃO ORIENTADA A OBJETOS", "[4]CÁLCULO", "[4]ANÁLISE DE CIRCUITOS ELÉTRICOS", "[4]QUÍMICA", "[4]ÓTICA E FÍSICA PARA SEMICONDUTORES", "[4]RESISTÊNCIA DOS MATERIAIS"
    );
   
    ObservableList<String> listaMedias = FXCollections.observableArrayList("M1", "M2", "M3");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        campoDisciplina.setValue("[1]INTRODUÇÃO À FÍSICA");
        campoDisciplina.setItems(listaDisciplinas);
        
        campoMedia.setValue("M1");
        campoMedia.setItems(listaMedias);
    }    
       
    @FXML 
    public void voltarParaTela2() throws IOException {
        
        GerenciadorJanela.obterInstancia().voltar();

      /*  //carrega o elemento raiz do FXML da tela que será aberta
        AnchorPane elementoRaizFXML2 = FXMLLoader.load(getClass().getResource("Tela2FXML.fxml"));
        
        //cria uma nova cena, passando para o construtor o elemento raiz do FXML que será aberto
        Scene novaCena = new Scene(elementoRaizFXML2);
        
        //obtém a cena a partir do elemenento raiz da tela que está aberta (tela atual)
        Scene cenaAtual = elementoRaiz.getScene();
        
        //obtém o palco da aplicação a partir da cena atual (com cast para Stage)
        Stage palcoDaAplicacao = (Stage) cenaAtual.getWindow();
        
        //atribuindo a nova cena, criada no início do método, ao palco da aplicação
        palcoDaAplicacao.setScene(novaCena);
        
        palcoDaAplicacao.setTitle("Minhas avaliacoes");  */
    }
    
    @FXML
    private String pegaNomeProva() throws IOException{
        String nomeProva = campoNome.getText();
        if(nomeProva.equals("")){
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro");
            dialogoErro.setHeaderText("CAMPO PROVA VAZIO!!!");
            dialogoErro.setContentText("É necessário nomear a prova");
            dialogoErro.showAndWait();
            // Como parar aqui?
        }        
        return nomeProva;            
    }
    
    @FXML
    private String pegaPeso() throws IOException{
        String pesoProva = campoPeso.getText();        
        if(pesoProva.equals("")){
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro");
            dialogoErro.setHeaderText("CAMPO PESO VAZIO!!!");
            dialogoErro.setContentText("É necessário definir o peso");
            dialogoErro.showAndWait();
            // Como parar aqui?
        }
        //Double pesoProva = Double.parseDouble(campoPeso.getText());
        return pesoProva;
    }
    
    @FXML
    private String pegaDisciplina() throws IOException{
        String disc = campoDisciplina.getValue();
        return disc;        
    }
    
    @FXML
    private String pegaMedia() throws IOException{
        String media = campoMedia.getValue();
        return media;
    }
   
    @FXML
    private void salvarProva() throws IOException{
        if(!arquivo1.exists()){
            arquivo1.createNewFile();
        }
        FileWriter escritor = new FileWriter(arquivo1, true);
        
        BufferedWriter gravador = new BufferedWriter(escritor);
        
        gravador.write(pegaDisciplina()+","+pegaMedia()+","+pegaNomeProva()+","+pegaPeso());
        gravador.newLine();
        
        gravador.close();
        escritor.close();
        
        voltarParaTela2();
    }
        
}
