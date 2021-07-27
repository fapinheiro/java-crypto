package tech.pinheirolabs;


import static tech.pinheirolabs.util.Const.METODO_ENCRIPTACAO;
import static tech.pinheirolabs.util.Util.formatar;
import static javax.crypto.Cipher.*;

import java.security.KeyException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;
import tech.pinheirolabs.util.Const;
import tech.pinheirolabs.util.Util;

/**
 * Permite decriptar um dado de acordo com a chave informada.
 * 
 * @author filipe.pinheiro
 *
 */
public class Decrypter {
	
	/*******************************************************************************************/
	public static String decriptar(byte[] chave, String dadosCriptografado) throws KeyException {

		byte[] decrypted = null;
		try {
			byte[] decoded = Base64.getDecoder().decode(dadosCriptografado);
			Cipher cipher = getInstance(METODO_ENCRIPTACAO);
			SecretKeySpec skeySpec = new SecretKeySpec(chave, METODO_ENCRIPTACAO);
			cipher.init(DECRYPT_MODE, skeySpec);
			
			decrypted = cipher.doFinal(decoded);
		}
		catch (Exception e) {
			throw new KeyException("Erro ao descriptografar a informa��o.\nCausa:" + e.getMessage() + "\nChave: " + formatar(chave) + "\nValor:" + dadosCriptografado);
		}
		return new String(decrypted);
	}
	
	/*
	 * Sobrecarga do metodo 'String decriptar(byte[] key, String valor)'
	 * 
	 * Autor: Filipe Pinheiro
	 *  Data: 23/07/2014
	 */
	public static String decriptar(String chave, String dadosCriptografado) throws KeyException {
		return decriptar(Util.formatar(chave), dadosCriptografado);
	}
	/*
	 * Sobrecarga do metodo 'String decriptar(byte[] key, String valor)'
	 * 
	 * Autor: Filipe Pinheiro
	 *  Data: 23/07/2014
	 */
	public static String decriptar(String chave, String dadosCriptografado, boolean encoding) throws KeyException {
		if(encoding){
			return decriptar(Util.formatar(chave), Util.decoding(dadosCriptografado));
		}
		return decriptar(Util.formatar(chave), dadosCriptografado);
	}
	
	/*
	 * Descriptografa de acordo com a chave do ambiente
	 * 
	 * Autor: Filipe Pinheiro
	 *  Data: 23/07/2014
	 */
	public static String decriptar(String dadosCriptografado) throws KeyException {
		if (Const.CHAVE_AMBIENTE != null) {
			return decriptar(Const.CHAVE_AMBIENTE, dadosCriptografado);
		}
		else {
			return decriptar(Const.CHAVE_PADRAO, dadosCriptografado);
		}
	}
	public static String decriptar(String dadosCriptografado, boolean enconding) throws KeyException {
		if (Const.CHAVE_AMBIENTE != null) {
			return decriptar(Const.CHAVE_AMBIENTE, dadosCriptografado, enconding);
		}
		else {
			return decriptar(Const.CHAVE_PADRAO, dadosCriptografado, enconding);
		}
	}

}//END - By FP - 2021
