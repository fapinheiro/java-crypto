package tech.pinheirolabs;

import static tech.pinheirolabs.util.Const.*;
import static tech.pinheirolabs.util.Util.formatar;
import static javax.crypto.Cipher.*;

import java.security.KeyException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;
import tech.pinheirolabs.util.Const;
import tech.pinheirolabs.util.Util;

/**
 * Permite encriptar um dado de acordo com a chave informada.
 * 
 * @author filipe.pinheiro
 *
 */
public class Encripter {

	
	/*******************************************************************************************/
	public static String encriptar(byte[] key, String valor) throws KeyException {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key, 0, NUMERO_CHAVE, METODO_ENCRIPTACAO);
            Cipher cipher = getInstance(METODO_ENCRIPTACAO);
            
            cipher.init(ENCRYPT_MODE, skeySpec);
            
            byte[] encrypted = cipher.doFinal(valor.getBytes());
 
            return Base64.getEncoder().encodeToString(encrypted);
        }
        catch (Exception e) {
        	throw new KeyException("Erro ao criptografar a informa��o.\nCausa: " + e.getMessage() + "\nChave: " + formatar(key) + "\nValor:" + valor);
        }
    }
	
	/*
	 * Sobrecarga do metodo 'String encriptar(byte[] key, String valor)'
	 * 
	 * Autor: Filipe Pinheiro
	 *  Data: 23/07/2014
	 */
	public static String encriptar(String key, String valor) throws KeyException {
		return encriptar(Util.formatar(key), valor);
	}
	public static String encriptar(String key, String valor, boolean encoding) throws KeyException {
		if(encoding) {
			String str = encriptar(Util.formatar(key), valor);
			return Util.encoding(str);
		}
		return encriptar(Util.formatar(key), valor);
	}
	
	/*
	 * Criptografa de acordo com a chave do ambiente
	 * 
	 * Autor: Filipe Pinheiro
	 *  Data: 23/07/2014
	 */
	public static String encriptar(String valor) throws KeyException {
		if (Const.CHAVE_AMBIENTE != null) {
			return encriptar(Const.CHAVE_AMBIENTE, valor);
		}
		else {
			return encriptar(Const.CHAVE_PADRAO, valor);
		}
		
	}
	public static String encriptar(String valor, boolean enconding) throws KeyException {
		if (Const.CHAVE_AMBIENTE != null) {
			return encriptar(Const.CHAVE_AMBIENTE, valor, enconding);
		}
		else {
			return encriptar(Const.CHAVE_PADRAO, valor, enconding);
		}
		
	}
}//END - By FP - 2021
