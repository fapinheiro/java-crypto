package tech.pinheirolabs;

import static tech.pinheirolabs.util.Const.*;
import static tech.pinheirolabs.util.Util.formatar;

import java.security.KeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * Permite gerar uma chave de acordo com o tipo de encripta��o.
 * 
 * @author filipe.pinheiro
 */
class GeraChave {

	/*******************************************************************************************/
	static String[] gerarChave(int numeroDeChaves) throws KeyException {
		String[] chaves = new String[numeroDeChaves];
		try {
			KeyGenerator	kg 		= KeyGenerator.getInstance(METODO_ENCRIPTACAO);
			for (int i = 0; i < chaves.length; i++) {
				String chave = formatar(gerar(kg));
				chaves[i] = chave;
			}
		} catch (Exception e) {
			throw new KeyException("Erro ao gerar a chave de criptografia.\nCausa:" + e.getMessage());
		}
		return chaves;
	}
	

	/*******************************************************************************************/
	private static byte[] gerar(KeyGenerator kg) throws NoSuchAlgorithmException{
		SecureRandom random = SecureRandom.getInstance(ALGORITIMO);
		byte[] seed		= random.generateSeed(QUANTIDADE);
		
		kg.init(CHAVE_TAMANHO, getRandom(seed)); 
		
		SecretKey  		aesKey 	= kg.generateKey();
		byte[] 			chave 	= aesKey.getEncoded();
		return chave;
	}
	
	/*******************************************************************************************/
	private static SecureRandom getRandom(byte[] seed) throws NoSuchAlgorithmException{
		SecureRandom random = SecureRandom.getInstance(ALGORITIMO);
		random.setSeed(seed);
		return random;
	}
	
}//END - By FP - 2021
