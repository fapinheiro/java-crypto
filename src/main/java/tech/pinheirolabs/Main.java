package tech.pinheirolabs;

/**
 * Permite executar uma a��o no sistema.
 * 
 * @author filipe.pinheiro
 *
 */
public class Main {

    public static void main(String[] args){
        if (args != null && args.length >= 2) {
            JCripto.acao(args);
         } else {
            JCripto.acao(Acao.ler());
         }
   
         System.exit(0);
    }
    
}//END - By FP - 2021
