package tech.pinheirolabs;


/**
 * Permite executar uma a��o no sistema.
 * 
 * @author filipe.pinheiro
 *
 */
public class Main {

    public static void main(String[] args1){
        if(args1!=null && args1.length >=2){
            JCripto.acao(args1);
        }else{
            JCripto.acao(Acao.ler());
        }
        System.exit(0);
    }
    
}//END - By FP - 2021
