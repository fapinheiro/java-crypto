package tech.pinheirolabs.util;

import static tech.pinheirolabs.util.Const.*;
import static tech.pinheirolabs.util.Util.getQuantidade;
import static tech.pinheirolabs.Acao.*;

public class Valida {


	/*******************************************************************************************/
	public static boolean validarArgs(String[] args){
		if(args == null || args.length <= 1)
			return false;
		String comando = args[0];
		
		if(!validarComando(comando)){
			System.out.println("Erro: Comando invalido! Deve ser: " + comandos());
			return false;
		}
		if(AJUDA.acao().equals(comando)){
			return false;
		}
		
		if(CHAVE.acao().equals(comando)){
			int qtde = getQuantidade(args[1]);
			if(qtde <=0 || qtde > 9){
				System.out.println("Erro: <Quantidade> nao informada ou invalida! Deve ser um n�mero entre 1 e 9.");
				return false;
			}
		} 
		
		if(CRYPTO.acao().equals(comando) || DECRYPTO.acao().equals(comando)) {
			if(args.length < 2) {
				System.out.println("Erro: <comando> ou numero de parametros invalido!");
				return false;
			}
			if(args[1]==null || !validarChave(args[1])) {
				System.out.println("Erro: Chave invalida! Deve ser exatamente o valor gerado pelo <comando>=chave");
				return false;
			}
			if(args[2]==null || args[2].length() < MININO_CRYPTO) {
				System.out.println("Erro: Conteudo a ser criptografado invalido! Deve ter pelo menos 4 caracteres.");
				return false;
			}
		}
		
		return true;
	}
	
	
	/*******************************************************************************************/
	private static boolean validarChave(String chave) {
		String[] dados = chave.split(SEPARADOR);
		if(chave == null || dados.length != NUMERO_CHAVE)
			return false;
		for (String key : dados) {
			try {
				Integer.parseInt(key);
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}
	
}//END - By FP - 2021
