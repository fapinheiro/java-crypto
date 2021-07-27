package tech.pinheirolabs.util;

import static tech.pinheirolabs.util.Const.*;

public class Impressao {

    /*******************************************************************************************/
    public static void imprimirHelp(){
        System.out.println("\n****************** GERADOR DE CHAVES e CRIPTOGRAFIA ***********************");
        System.out.println("* ");
        System.out.println("* Informar os seguintes comandos para execucao da aplicacao:");
        System.out.println("* ");
        System.out.println("* <comando> [<quantidade | (<chave> <conteudo>) ]");
        System.out.println("* ");
        System.out.println("* <comando>= chave | cripto | decripto");
        System.out.println("* ");
        System.out.println("* <quantidade> - A QUANTIDADE de chaves a serem geradas automaticamente. Valor maximo aceito e' 9. Ex: 3");
        System.out.println("* ");
        System.out.println("* <chave> - Uma chave gerada pelo comando \"chave\". Nao deve conter espacos antes, no meio ou no fim da chave e deve conter pelo menos 16 numeros.");
        System.out.println("* Ex: \"-80,24,-100,-96,84,-103,-46,55,-80,24,-100,-96,84,-103,-46,55\" ");
        System.out.println("* ");
        System.out.println("* <conteudo> - O conteudo a ser criptografado ou descriptografado. Nao deve conter espacos antes ou no fim do do mesmo.");
        System.out.println("* Ex: \"123$456@\" | \"V09ApAbHV0n4Qzj+f2lsgw==\" ");
        System.out.println("* ");
        System.out.println("* ");
        imprimirVersao();
    }
    
    /*******************************************************************************************/
    public static void imprimirChaves(String[] chaves){
        imprimirSucesso();
        System.out.println("\n************************** CHAVES CRIPTOGRAFICAS ****************************");
        System.out.println("* ");
        System.out.println("* Metodo de Encriptacao:" + METODO_ENCRIPTACAO);
        System.out.println("* Tamanho da chave     :" + CHAVE_TAMANHO + " bits");
        System.out.println("* Algoritmo Aleatorio  :" + ALGORITIMO);
        System.out.println("* ");
        System.out.println("*****************************************************************************");
        for (int i = 0; i < chaves.length; i++) {
            System.out.println("\nCHAVE " +  (i+1) + ": " + chaves[i]);
        }
        imprimirVersao();
    }
    
    /*******************************************************************************************/
    public static void imprimirCriptografia(String cripto, String original){
        imprimirSucesso();
        System.out.println("\n************************** CONTEUDO CRIPTOGRAFADO **************************");
        System.out.println("* ");
        System.out.println("* Metodo de Encriptacao:" + METODO_ENCRIPTACAO);
        System.out.println("* Codificador Base     :" + "BASE64");
        System.out.println("* ");
        System.out.println("*****************************************************************************");
        System.out.println("\nDADO ORIGINAL     : "+ original);
        System.out.println("\nDADO CRIPTOGRAFADO: "+ cripto);
        imprimirVersao();
    }
    
    /*******************************************************************************************/
    public static void imprimirSucesso(){
        System.out.println("\nComando executado com sucesso!!!");
    }
    
    public static void imprimirVersao(){
        System.out.println("*************************** Version 1.0 **************************************");
    }
    
    public static void imprimirMenu(){
        System.out.println("********* MENU DE ACAO **********");
        System.out.println("* [ 0 ] - Ajuda                 *");
        System.out.println("* [ 1 ] - Gerar CHAVE           *");
        System.out.println("* [ 2 ] - Criptografar Senha    *");
        System.out.println("* [ 3 ] - Decriptografar Senha  *");
        System.out.println("*******************************************************************************");
        System.out.print("Entre ACAO desejada: ");
    }
    
}//END - By FP - 2021
