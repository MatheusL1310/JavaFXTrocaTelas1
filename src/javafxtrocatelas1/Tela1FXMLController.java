package javafxtrocatelas1;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author matheus
 */
public class Tela1FXMLController extends InterfaceUsuario {

    public Tela1FXMLController(){
        super("Tela1FXML.fxml");
    }
    
    @FXML
    private Button minhasAvaliacoes, meuDesempenho;
    
    @FXML
    private AnchorPane elementoRaiz;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML 
    public void irParaTela2() throws IOException {
        
        Tela2FXMLController tela2 = new Tela2FXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(tela2);
    }
    
    @FXML
    public void irParaTela3() throws IOException {
       
        Tela3FXMLController tela3 = new Tela3FXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(tela3);
    }
}
