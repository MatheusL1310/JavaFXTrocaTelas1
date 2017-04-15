
package javafxtrocatelas1;


import java.util.Stack;
import javafx.stage.Stage;
/**
 *
 * @author matheus
 */

public class GerenciadorJanela {
    
    private static GerenciadorJanela instancia;
    
    private GerenciadorJanela(){
        this.pilhaRetorno = new Stack<>();
    }
    
    public static GerenciadorJanela obterInstancia(){
        if(GerenciadorJanela.instancia == null){
            GerenciadorJanela.instancia = new GerenciadorJanela();
        }
        return GerenciadorJanela.instancia;
    }
    
    private Stage palco;
    protected Stack<InterfaceUsuario> pilhaRetorno;
    private InterfaceUsuario janelaAtual;
    public static int identificador;

    public static int getIdentificador() {
        return identificador;
    }

    public static void setIdentificador(int identificador) {
        GerenciadorJanela.identificador = identificador;
    }
    
    public void inicializaPalco(Stage p, InterfaceUsuario interfaceInicial){
        this.palco = p;
        this.janelaAtual = interfaceInicial;
        this.palco.setScene(interfaceInicial.obterCena());
        this.palco.show();
    }
    
    private Stage getPalco(){
        return this.palco;
    }
    
    public void abreJanela(InterfaceUsuario novaJanela) {
        this.pilhaRetorno.push(this.janelaAtual);
        this.getPalco().setScene(novaJanela.obterCena());
        this.janelaAtual = novaJanela;
        //System.out.println(this.pilhaRetorno.size());
    }
    
    public void voltar() {
        if(!this.pilhaRetorno.empty()){
            InterfaceUsuario anterior = this.pilhaRetorno.pop();
            this.getPalco().setScene(anterior.obterCena());
            this.janelaAtual = anterior;
            return;
        }
        System.err.println("A pilha de retorno esta vazia");
    }
    
    public void voltar(int quantasTelas) {
        if(quantasTelas <= this.pilhaRetorno.size()){
            while(quantasTelas > 1){
                this.pilhaRetorno.pop();
                quantasTelas--;
            }
            InterfaceUsuario anterior = this.pilhaRetorno.pop();
            this.getPalco().setScene(anterior.obterCena());   
            this.janelaAtual = anterior;
            return;
        }
        System.err.println("Numero de retornos maior que o tamanho da pilha");       
    }
    
    
    public void abreEmPopup(InterfaceUsuario novaJanela){
        Stage popUp = new Stage();
        popUp.setScene(novaJanela.obterCena());
    }
    
    
}