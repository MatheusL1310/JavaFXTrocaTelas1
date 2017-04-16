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
    "[2]CÁLCULO", "[2]ALGORITMOS E PROGRAMAÇÃO", "[2]CIRCUITOS DIGITAIS", "[2]DESENHO TÉCNICO", "[2]FÍSICA GERAL", "[2]ÁLGEBRA", "[3]CÁLCULO", "[3]ESTRUTURAS DE DADOS", "[3]PROGRAMAÇÃO ORIENTADA A OBJETOS", "[3]ARQUITETURA DE COMPUTADORES", "[3]FÍSICA", "[3]QUÍMICA", "[4]ARQUITETURA DE COMPUTADORES", 
    "[4]PROGRAMAÇÃO ORIENTADA A OBJETOS", "[4]CÁLCULO", "[4]ANÁLISE DE CIRCUITOS ELÉTRICOS", "[4]QUÍMICA", "[4]ÓTICA E FÍSICA PARA SEMICONDUTORES", "[4]RESISTÊNCIA DOS MATERIAIS", "[5]BANCO DE DADOS", "[5]SISTEMAS OPERACIONAIS", "[5]MATEMÁTICA APLICADA À ENGENHARIA", "[5]ENGENHARIA DE SOFTWARE",
    "[5]PROBABILIDADE E ESTATÍSTICA", "[5]ELETRÔNICA BÁSICA", "[5]INTERFACE HUMANO - COMPUTADOR", "[6]ENGENHARIA DE SOFTWARE", "[6]REDES DE COMPUTADORES", "[6]CÁLCULO NUMERICO", "[6]LINGUAGENS FORMAIS", "[6]ELETRÔNICA APLICADA", "[6]ANÁLISE E CONTROLE DE PROCESSOS", "[7]ENGENHARIA ECONÔMICA", "[7]REDES DE COMPUTADORES",
    "[7]GRAFOS", "[7]CONTROLE LÓGICO DE SISTEMAS", "[7]MICROCONTROLADORES", "[7]PROJETO DE SISTEMAS DIGITAIS", "[8]INTELIGÊNCIA ARTIFICIAL", "[8]TRABALHO TÉC.-CIENTÍF.DE CONCLUSÃO DE CURSO", "[8]PROJETO DE SISTEMAS EMBARCADOS", "[8]SISTEMAS EM TEMPO REAL", "[8]COMUNICAÇÃO DIGITAL", "[8]PROCESSADOR DIGITAL DE SINAIS",
    "[8]SISTEMAS ROBÓTICOS", "[9]SIMULAÇÃO DISCRETA", "[9]GERÊNCIA DE PROJETOS", "[9]TÓPICOS ESPECIAIS EM ENGENHARIA DE COMPUTAÇÃO", "[9]TÓPICOS ESPECIAIS EM HARDWARE", "[9]TRABALHO TÉC-CIENTÍF. DE CONCLUSÃO DE CURSO", "[10]ADMINISTRAÇÃO DE NEGÓCIOS DE BASE TECNOLÓGICA", "[10]TÓP. ESPECIAIS EM INTEGRAÇÃO SOFTWARE HARDWARE",
    "[10]TRABALHO TÉC-CIENTÍFICO DE CONCLUSÃO DE CURSO", "[10]SISTEMAS DISTRIBUÍDOS"
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
    }
     
    @FXML
    private boolean valida(){
        if("".equals(campoNome.getText())){
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro");
            dialogoErro.setHeaderText("CAMPO NOME VAZIO!!!");
            dialogoErro.setContentText("É necessário nomear a prova");
            dialogoErro.showAndWait();
            return false;
        }
        if("".equals(campoDisciplina.getValue())){
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro");
            dialogoErro.setHeaderText("CAMPO DISCIPLINA VAZIO!!!");
            dialogoErro.setContentText("É necessário nomear a disciplina");
            dialogoErro.showAndWait();
            return false;
        }
        if("".equals(campoMedia.getValue())){
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro");
            dialogoErro.setHeaderText("CAMPO MEDIA VAZIO!!!");
            dialogoErro.setContentText("É necessário nomear a prova");
            dialogoErro.showAndWait();
            return false;
        }
        if("".equals(campoPeso.getText())){
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro");
            dialogoErro.setHeaderText("CAMPO PESO VAZIO!!!");
            dialogoErro.setContentText("É necessário dar peso à prova");
            dialogoErro.showAndWait();
            return false;
        }
        return true;            
    } 
    
    @FXML
    private void salvarProva() throws IOException{   
        if(valida()){
        Avaliacao meuObj = new Avaliacao();
        meuObj.setNome(campoNome.getText());
        meuObj.setDisciplina(campoDisciplina.getValue());
        meuObj.setMedia(campoMedia.getValue().toCharArray());
        meuObj.setPeso(Double.parseDouble(campoPeso.getText()));
        
        meuObj.salvar();
        }
    }
        
}
