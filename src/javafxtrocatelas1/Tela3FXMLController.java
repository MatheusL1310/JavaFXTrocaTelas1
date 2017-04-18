/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtrocatelas1;

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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
public class Tela3FXMLController extends InterfaceUsuario {

    public Tela3FXMLController(){
        super("Tela3FXML.fxml");
    }
    
    @FXML
    private AnchorPane elementoRaiz;
    
    @FXML
    private BarChart<?, ?> tabela;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    
    @FXML
    private ChoiceBox<String> campoDisciplina;
    
    ObservableList<String> listaDisciplinas = FXCollections.observableArrayList("[1]ÉTICA EM INFORMÁTICA", "[1]MATEMÁTICA COMPUTACIONAL", "[1]ALGORITMOS E PROGRAMAÇÃO", "[1]ÁLGEBRA", "[1]INTRODUÇÃO AO CÁLCULO", "[1]INICIAÇÃO TÉCNICO-CIENTÍFICA", "[1]INTRODUÇÃO A ENGENHARIA DE COMPUTAÇÃO", "[1]INTRODUÇÃO À FÍSICA",
    "[2]CÁLCULO", "[2]ALGORITMOS E PROGRAMAÇÃO", "[2]CIRCUITOS DIGITAIS", "[2]DESENHO TÉCNICO", "[2]FÍSICA GERAL", "[2]ÁLGEBRA", "[3]CÁLCULO", "[3]ESTRUTURAS DE DADOS", "[3]PROGRAMAÇÃO ORIENTADA A OBJETOS", "[3]ARQUITETURA DE COMPUTADORES", "[3]FÍSICA", "[3]QUÍMICA", "[4]ARQUITETURA DE COMPUTADORES", 
    "[4]PROGRAMAÇÃO ORIENTADA A OBJETOS", "[4]CÁLCULO", "[4]ANÁLISE DE CIRCUITOS ELÉTRICOS", "[4]QUÍMICA", "[4]ÓTICA E FÍSICA PARA SEMICONDUTORES", "[4]RESISTÊNCIA DOS MATERIAIS", "[5]BANCO DE DADOS", "[5]SISTEMAS OPERACIONAIS", "[5]MATEMÁTICA APLICADA À ENGENHARIA", "[5]ENGENHARIA DE SOFTWARE",
    "[5]PROBABILIDADE E ESTATÍSTICA", "[5]ELETRÔNICA BÁSICA", "[5]INTERFACE HUMANO - COMPUTADOR", "[6]ENGENHARIA DE SOFTWARE", "[6]REDES DE COMPUTADORES", "[6]CÁLCULO NUMERICO", "[6]LINGUAGENS FORMAIS", "[6]ELETRÔNICA APLICADA", "[6]ANÁLISE E CONTROLE DE PROCESSOS", "[7]ENGENHARIA ECONÔMICA", "[7]REDES DE COMPUTADORES",
    "[7]GRAFOS", "[7]CONTROLE LÓGICO DE SISTEMAS", "[7]MICROCONTROLADORES", "[7]PROJETO DE SISTEMAS DIGITAIS", "[8]INTELIGÊNCIA ARTIFICIAL", "[8]TRABALHO TÉC.-CIENTÍF.DE CONCLUSÃO DE CURSO", "[8]PROJETO DE SISTEMAS EMBARCADOS", "[8]SISTEMAS EM TEMPO REAL", "[8]COMUNICAÇÃO DIGITAL", "[8]PROCESSADOR DIGITAL DE SINAIS",
    "[8]SISTEMAS ROBÓTICOS", "[9]SIMULAÇÃO DISCRETA", "[9]GERÊNCIA DE PROJETOS", "[9]TÓPICOS ESPECIAIS EM ENGENHARIA DE COMPUTAÇÃO", "[9]TÓPICOS ESPECIAIS EM HARDWARE", "[9]TRABALHO TÉC-CIENTÍF. DE CONCLUSÃO DE CURSO", "[10]ADMINISTRAÇÃO DE NEGÓCIOS DE BASE TECNOLÓGICA", "[10]TÓP. ESPECIAIS EM INTEGRAÇÃO SOFTWARE HARDWARE",
    "[10]TRABALHO TÉC-CIENTÍFICO DE CONCLUSÃO DE CURSO", "[10]SISTEMAS DISTRIBUÍDOS"
    );
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tabela.setAnimated(false);
        campoDisciplina.setValue("[4]QUÍMICA");
        campoDisciplina.setItems(listaDisciplinas);
        
    }    
    
    @FXML
    public void onActionChoiceBox() throws IOException{
        double m1,m2,m3,mf;
        
        m1 = Avaliacao.calculaMediaDaDisciplina(campoDisciplina.getValue(), "M1".toCharArray());
        m2 = Avaliacao.calculaMediaDaDisciplina(campoDisciplina.getValue(), "M2".toCharArray());
        m3 = Avaliacao.calculaMediaDaDisciplina(campoDisciplina.getValue(), "M3".toCharArray());
        
        
        XYChart.Series set1 = new   XYChart.Series<>();
        
        if(!Double.isNaN(m1))
            set1.getData().add(new XYChart.Data("M1", m1));
        if(!Double.isNaN(m2))
            set1.getData().add(new XYChart.Data("M2", m2));
        if(!Double.isNaN(m3))
            set1.getData().add(new XYChart.Data("M3", m3));
        if(!Double.isNaN(m1) && !Double.isNaN(m2) && !Double.isNaN(m3)){
            mf = (m1+m2+m3)/3;
            set1.getData().add(new XYChart.Data("MF", mf));
        }
        tabela.getData().clear();
        tabela.getData().addAll(set1);
    }
    
    @FXML 
    public void voltarParaTela1() throws IOException {
        
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}
