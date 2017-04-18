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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author matheus
 */
public class Tela4FXMLController extends InterfaceUsuario {

    public Tela4FXMLController(){
        super("Tela4FXML.fxml");
    }
    
     @FXML
    private AnchorPane elementoRaiz;

    @FXML
    private Label label1, label2, label3, label4;

    @FXML
    private TextField campoNota;

    @FXML
    private Button voltaTela2, salvaTela4;
    
    protected Avaliacao a1 = Avaliacao.obterListaAvaliacoes().get(GerenciadorJanela.identificador);    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label1.setText("Nome: "+a1.getNome());
        label2.setText("Disciplina: "+a1.getDisciplina());
        label3.setText("Media: "+String.valueOf(a1.getMedia()));
    }    
    
    @FXML 
    public void voltarParaTela2() throws IOException {
        
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    @FXML
    private boolean validaNota() throws IOException{
        if("".equals(campoNota.getText())){
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro");
            dialogoErro.setHeaderText("CAMPO NOTA VAZIO!!!");
            dialogoErro.setContentText("É necessário inserir a nota");
            dialogoErro.showAndWait();
            return false;
        }
        if(Double.parseDouble(campoNota.getText())< 0.0 || Double.parseDouble(campoNota.getText()) >= 10.0){
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro");
            dialogoErro.setHeaderText("NOTA INVALIDA!!!");
            dialogoErro.setContentText("A nota tem que ser um numero de 0.0 a 10.0");
            dialogoErro.showAndWait();
            return false;
        }
        return true;
    }
    
    
    @FXML
    private void salvarNota() throws IOException{
        if(validaNota()){
            
            a1.setNota(Double.parseDouble(campoNota.getText()));
            
            a1.atualizar();
        }
        
    }
}
