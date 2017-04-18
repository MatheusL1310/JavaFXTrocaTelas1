/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtrocatelas1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author matheus
 */
public class Tela2FXMLController extends InterfaceUsuario {

    public Tela2FXMLController(){
        super("Tela2FXML.fxml");
    }
    
    
    
    @FXML
    private Button informaNota, adicionaAvaliacao, voltaTela1;
    
    @FXML
    private TableView<Avaliacao> tabela;
        
    @FXML
    private TableColumn colNome, colDisc, colMedia, colPeso, colNota;
    
    @FXML
    private AnchorPane elementoRaiz;
    
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Avaliacao> conteudo = FXCollections.observableArrayList(Avaliacao.obterListaAvaliacoes());              
        tabela.setItems(conteudo); 
        
        colNome.setCellValueFactory(new PropertyValueFactory<Avaliacao, String>("nome"));
        colDisc.setCellValueFactory(new PropertyValueFactory<Avaliacao, String>("disciplina"));
        colMedia.setCellValueFactory(new PropertyValueFactory<Avaliacao, String>("mediaString"));
        colPeso.setCellValueFactory(new PropertyValueFactory<Avaliacao, Double>("peso"));
        colNota.setCellValueFactory(new PropertyValueFactory<Avaliacao, Double>("nota"));
        
    }    
    
    
    @FXML
    public void irParaTela4() throws IOException {
        if(tabela.getItems().isEmpty() == false){
            if(Avaliacao.obterListaAvaliacoes().get(tabela.getSelectionModel().getSelectedItem().getIdentificadorNoArquivo()).getNota()!=null){
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro");
                dialogoErro.setHeaderText("NOTA JÁ EXISTE!!!");
                dialogoErro.setContentText("Já existe nota cadastrada nesta prova");
                dialogoErro.showAndWait();
            }else{
                GerenciadorJanela.setIdentificador(tabela.getSelectionModel().getSelectedItem().getIdentificadorNoArquivo());
                Tela4FXMLController tela4 = new Tela4FXMLController();
                GerenciadorJanela.obterInstancia().abreJanela(tela4);
            }
        }else{
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro");
            dialogoErro.setHeaderText("TABELA VAZIA!!!");
            dialogoErro.setContentText("É necessário adicionar uma prova antes de adicionar a nota");
            dialogoErro.showAndWait();
        }
        
    }
    
    @FXML
    public void irParaTela5() throws IOException {
        
        Tela5FXMLController tela5 = new Tela5FXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(tela5);      
    }
    
    @FXML 
    public void voltarParaTela1() throws IOException {
        
        GerenciadorJanela.obterInstancia().voltar();
    }
}
